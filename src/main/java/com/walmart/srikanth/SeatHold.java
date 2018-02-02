package com.walmart.srikanth;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SeatHold {
	
	private List<Seat> seatsHeld = new ArrayList<Seat>();
	
	private Integer numSeatsHeld = 0;
	
	private Integer seatHoldId = CodeUtils.generateUniqueId();
	
	private String emailId = "";
	
	private Timestamp lastModified = new Timestamp(System.currentTimeMillis());


	public Integer getSeatHoldId() {
		return seatHoldId;
	}

	public void setSeatHoldId(Integer seatHoldId) {
		this.seatHoldId = seatHoldId;
	}
	
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public List<Seat> getSeatsHeld() {
		return seatsHeld;
	}

	public void setSeatsHeld(List<Seat> seatsHeld) {
		this.seatsHeld = seatsHeld;
	}

	public Integer getNumSeatsHeld() {
		return numSeatsHeld;
	}

	public void setNumSeatsHeld(Integer numSeatsHeld) {
		this.numSeatsHeld = numSeatsHeld;
	}

	/**
	 * @return the lastModified
	 */
	public Timestamp getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}
	
	

}
