/**
 * 
 */
package com.walmart.srikanth;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author VanapalliV
 *
 */
public class TicketServiceImpl implements TicketService {

	private Auditorium auditorium = new Auditorium();
	
	private Object lock = new Object();
	
	/* (non-Javadoc)
	 * @see com.walmart.srikanth.TicketService#numSeatsAvailable()
	 */
	@Override
	public int numSeatsAvailable() {
		synchronized(lock){
			return Auditorium.seatsRemaining.get();

		}
	}

	/* (non-Javadoc)
	 * @see com.walmart.srikanth.TicketService#findAndHoldSeats(int, java.lang.String)
	 */
	@Override
	public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
		List<Seat> seatsHeld = null;
		SeatHold retVal;
		// Check if user already required seats to be held
		if(customerEmail == null)
			throw new ReservationException("Customer Email cannot be null");

		// Check if required nummber of seats are available
		if(numSeats > auditorium.seatsRemaining.get())
			throw new ReservationException("Requested number of seats are not available");
		
		// Check if user already required seats to be held
		if(Auditorium.seatingHeld.get(customerEmail) != null)
			throw new ReservationException("User already requested seats to be held");
		
		// Get a lock on the object.
		synchronized(lock){
			Row row;
			int seatsToBeAllocated = numSeats;
			seatsHeld = new ArrayList<Seat>();
			// We will try to hold the seats closest to the STAGE
			for(int i = 1; (i <= CodeUtils.NUMBER_OF_ROWS) && (seatsToBeAllocated > 0); i++){
		    	row = (Row) Auditorium.seatingMatrix.get(i);
		    	List<Seat> rowSeatsList = new ArrayList<Seat>();
		    	// If there are seats in the ROW then proceed further to HOLD them
				if(row.getNumSeatsRemaining() != 0) {
					int seatsToBeAllocatedBkp = seatsToBeAllocated;
					seatsToBeAllocated = seatsToBeAllocated - row.getNumSeatsRemaining();
					List<Seat> seatsList = row.getSeatsList();
					Seat seat = null;
					// Iterate and set the seats to be held in the ROW
					for(int j = row.getNumSeatsHeld(); (seatsToBeAllocatedBkp > 0) && (j < row.getNumSeatsTotal()); j++ ){
						seat = (Seat) seatsList.get(j);
						if(seat.getOpen()){
							seat.setOpen(false);
						    seat.setHeld(true);
						    seat.setLastModified(new Timestamp(System.currentTimeMillis()));
						    seatsHeld.add(seat);
						    rowSeatsList.add(seat);
						    seatsToBeAllocatedBkp--;
						}
					}
					// set different counters in the row object
					if(seatsToBeAllocated < 0){
						row.setNumSeatsRemaining(-seatsToBeAllocated);
						row.setNumSeatsHeld(row.getNumSeatsHeld() + row.getNumSeatsTotal() + seatsToBeAllocated);
					
					}else{
						row.setNumSeatsRemaining(0);
						row.setNumSeatsHeld(row.getNumSeatsHeld() + numSeats - seatsToBeAllocated);
						
					}
				}
			}
			// Set values in the SEATHOLD return object
			retVal = new SeatHold();
			retVal.setEmailId(customerEmail);
			retVal.setNumSeatsHeld(numSeats);
			retVal.setSeatsHeld(seatsHeld);
			Auditorium.seatingHeld.put(customerEmail , retVal);

			// Update metadata in the Auditorium object
			Auditorium.seatsHeld.addAndGet(numSeats);
			Auditorium.seatsRemaining.addAndGet(-numSeats); 
						
		}
		
		return retVal;
	}

	
	/* (non-Javadoc)
	 * @see com.walmart.srikanth.TicketService#reserveSeats(int, java.lang.String)
	 */
	@Override
	public String reserveSeats(int seatHoldId, String customerEmail) {
		
		// Throw an exception if the user email is not present initially
		// OR the seats held by them have been released due to TIMEOUT.
		if(Auditorium.seatingHeld.get(customerEmail) == null)
			throw new ReservationException("Requested seat hold not available");
		
		String retVal = null;
		
		/**
		 * - Convert the seats from HOLD to RESERVED
		 * - Update the maps in the Auditorium class metadata
		 * - Create purchase object and confirmation id
		 * - Send email to user
		 */
		synchronized (lock) {
			SeatHold seatHold = Auditorium.seatingHeld.get(customerEmail);
			List<Seat> seatsList = seatHold.getSeatsHeld();
			List<Seat> rowSeatsList = null;
			Seat seat = null;
			Seat rowSeat = null;
			int rowNum = 0;
			int colNum = 0;
			Row row = null;
			SeatPurchase seatPurchase = null;
			HashMap<Integer, Row> seatingMatrix = (HashMap<Integer, Row>) Auditorium.seatingMatrix;
			for(int i=0; i < seatHold.getNumSeatsHeld(); i++){
				seat = seatsList.get(i);
				rowNum = seat.getRow();
				colNum = seat.getColumn();
				row = seatingMatrix.get(rowNum);
				rowSeatsList = row.getSeatsList();
				rowSeat = rowSeatsList.get(colNum-1);
				rowSeat.setHeld(false);
				rowSeat.setReserved(true);
				rowSeat.setLastModified(new Timestamp(System.currentTimeMillis()));
				row.setNumSeatsHeld(row.getNumSeatsHeld() - 1);
				row.setNumSeatsReserved(row.getNumSeatsReserved() + 1);
			}
			
			// Update metadata in the Auditorium object
			Auditorium.seatsHeld.addAndGet(-seatHold.getNumSeatsHeld());
			Auditorium.seatsReserved.addAndGet(seatHold.getNumSeatsHeld());
			Auditorium.seatingHeld.remove(seatHold.getEmailId());
			
			// Generate confirmation and update the purchased map in Auditorium
			// Auditorium.seatingPurchased is an additional feature for future use
			seatPurchase = new SeatPurchase();
			seatPurchase.setConfirmationId(seatHold.getSeatHoldId().toString() + String.valueOf(System.currentTimeMillis()));
			seatPurchase.setEmailId(seatHold.getEmailId());
			seatPurchase.setSeatsPurchased(seatHold.getSeatsHeld());
			Auditorium.seatingPurchased.put(seatPurchase.getConfirmationId(), seatPurchase);
			retVal = seatPurchase.getConfirmationId();
			
			// Code to send email not implemented
			// but can use the email and Mail Server to send emails
		}
		return retVal;
	}

	/**
	 * @return the auditorium
	 */
	public Auditorium getAuditorium() {
		return auditorium;
	}

	/**
	 * @param auditorium the auditorium to set
	 */
	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
	}

}
