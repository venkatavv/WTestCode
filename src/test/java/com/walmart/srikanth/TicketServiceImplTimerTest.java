/**
 * 
 */
package com.walmart.srikanth;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author VanapalliV
 *
 */
public class TicketServiceImplTimerTest {
	
	TicketService ticketService = new TicketServiceImpl();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Auditorium.initialize();
	}

		

	/**
	 * Test method for {@link com.walmart.srikanth.TicketServiceImpl#findAndHoldSeats(int, java.lang.String)}.
	 */
	@Test
	public void testFindAndHoldSeatsTimer() {
		
		SeatHold seatHold = ticketService.findAndHoldSeats(4, "srikanth.vanapalli@gmail.com");
		List<Seat> seatsList = seatHold.getSeatsHeld();
		assertEquals(new Integer(1), seatsList.get(0).getRow());
		assertEquals(new Integer(1), seatsList.get(0).getColumn());
		assertEquals(new Integer(1), seatsList.get(1).getRow());
		assertEquals(new Integer(2), seatsList.get(1).getColumn());
		assertEquals(new Integer(1), seatsList.get(2).getRow());
		assertEquals(new Integer(3), seatsList.get(2).getColumn());
		assertEquals(new Integer(2), seatsList.get(3).getRow());
		assertEquals(new Integer(1), seatsList.get(3).getColumn());
		assertEquals("srikanth.vanapalli@gmail.com", seatHold.getEmailId());
		assertEquals(new Integer(4), seatHold.getNumSeatsHeld());
		assertEquals(4, Auditorium.seatsHeld.get());
		assertEquals(5, Auditorium.seatsRemaining.get());

		AppScheduler appScheduler = new AppScheduler();
		appScheduler.main(null);
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNull(Auditorium.seatingHeld.get(seatHold.getEmailId()));

	}
	
	
}
