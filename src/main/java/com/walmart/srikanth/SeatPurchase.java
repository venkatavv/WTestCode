package com.walmart.srikanth;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SeatPurchase {
	
	private List<Seat> seatsPurchased = new ArrayList<Seat>();
	
	private String confirmationId;
	
	private String emailId = "";
	
	private Timestamp lastModified = new Timestamp(System.currentTimeMillis());



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

	/**
	 * @return the seatsPurchased
	 */
	public List<Seat> getSeatsPurchased() {
		return seatsPurchased;
	}

	/**
	 * @param seatsPurchased the seatsPurchased to set
	 */
	public void setSeatsPurchased(List<Seat> seatsPurchased) {
		this.seatsPurchased = seatsPurchased;
	}

	/**
	 * @return the confirmationId
	 */
	public String getConfirmationId() {
		return confirmationId;
	}

	/**
	 * @param confirmationId the confirmationId to set
	 */
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
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
