package com.walmart.srikanth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Auditorium {
	
	// Metadata at Auditorium leve
	public static AtomicInteger seatsRemaining = new AtomicInteger(CodeUtils.TOTAL_NUMBER_OF_SEATS); 
	public static AtomicInteger seatsReserved = new AtomicInteger(0); 
	public static AtomicInteger seatsHeld = new AtomicInteger(0); 
	
	// Map holds the seating layout for the Auditorium
	public static HashMap<Integer, Row> seatingMatrix = new HashMap<Integer, Row>(); 
	
	// Holds the seatsHeld. Need to be modified every 5 secs to release HOLD on seats held over 5 secs
	public static HashMap<String, SeatHold> seatingHeld = new HashMap<String, SeatHold>(); 
	
	// Holds the seatsPurchased
	public static HashMap<String, SeatPurchase> seatingPurchased = new HashMap<String, SeatPurchase>(); 

	static{
		initialize();;
	}
	
	public static void initialize(){
		
		    seatsRemaining = new AtomicInteger(CodeUtils.TOTAL_NUMBER_OF_SEATS); 
		    seatsReserved = new AtomicInteger(0); 
		    seatsHeld = new AtomicInteger(0);
		    seatingHeld = new HashMap<String, SeatHold>(); 
		    seatingPurchased = new HashMap<String, SeatPurchase>(); 
		    seatingMatrix = new HashMap<Integer, Row>(); 
	        // Initialise 3 x 3 seating
			// Initialise ROW 1
			Row row = new Row();
			Seat seat1 = new Seat(1,1);
			Seat seat2 = new Seat(1,2);
			Seat seat3 = new Seat(1,3);
			List<Seat> seatList = new ArrayList<Seat>();
			seatList.add(seat1);
			seatList.add(seat2);
			seatList.add(seat3);
			row.setSeatsList(seatList);
			seatingMatrix.put(1, row);
			
			// Initialise ROW 2
			row = new Row();
			seat1 = new Seat(2,1);
			seat2 = new Seat(2,2);
			seat3 = new Seat(2,3);
			seatList = new ArrayList<Seat>();
			seatList.add(seat1);
			seatList.add(seat2);
			seatList.add(seat3);
			row.setSeatsList(seatList);
			seatingMatrix.put(2, row);
			
			// Initialise ROW 3
			row = new Row();
			seat1 = new Seat(3,1);
			seat2 = new Seat(3,2);
			seat3 = new Seat(3,3);
			seatList = new ArrayList<Seat>();
			seatList.add(seat1);
			seatList.add(seat2);
			seatList.add(seat3);
			row.setSeatsList(seatList);
			seatingMatrix.put(3, row);
	}
	/**
	 * 
	 */
	public Auditorium() {
		super();
	}

	
}
