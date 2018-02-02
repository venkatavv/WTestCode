/**
 * 
 */
package com.walmart.srikanth;

import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author VanapalliV
 *
 */
public class AppTimerTask extends TimerTask {

	private Object lock = new Object();
	
	/* (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		synchronized (Auditorium.class) {
			HashMap<String, SeatHold> seatingHeld  = Auditorium.seatingHeld;
			Set<String> keysSet = seatingHeld.keySet();
			Iterator<String> enumeration = keysSet.iterator();
			String key = null;
			SeatHold seatHold = null;
	        while(enumeration.hasNext()){
	        	key = (String) enumeration.next();
	        	seatHold = seatingHeld.get(key);
	        	
	        	// If difference more than 5 sec the release all the seats that the
	        	// particular reserved and that should update the actual seating matrix
	        	// and appropriate METADATA as well.
	        	if((System.currentTimeMillis() - seatHold.getLastModified().getTime()) >= 5000){
	        		seatingHeld.remove(key);
	        		Auditorium.seatsHeld.addAndGet(-seatHold.getNumSeatsHeld());
	        		Auditorium.seatsRemaining.addAndGet(seatHold.getNumSeatsHeld());
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
	    				rowSeat.setOpen(true);
	    				rowSeat.setLastModified(new Timestamp(System.currentTimeMillis()));
	    				row.setNumSeatsHeld(row.getNumSeatsHeld() - 1);
	    				row.setNumSeatsRemaining(row.getNumSeatsRemaining() + 1);
	    			}
	    			
	
	        	}
	        }
		}

	}

}
