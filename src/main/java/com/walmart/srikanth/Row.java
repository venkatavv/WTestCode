package com.walmart.srikanth;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Row {

	private Integer numSeatsHeld = 0;
	
	private Integer numSeatsReserved = 0;
	
	private Integer numSeatsTotal = CodeUtils.NUMBER_OF_SEATS;
	
	private Integer numSeatsRemaining = CodeUtils.NUMBER_OF_SEATS;
	
	
	private List seatsList = new ArrayList<Seat>();
	
	

	/**
	 * @return the numSeatsHeld
	 */
	public Integer getNumSeatsHeld() {
		return numSeatsHeld;
	}

	/**
	 * @param numSeatsHeld the numSeatsHeld to set
	 */
	public void setNumSeatsHeld(Integer numSeatsHeld) {
		this.numSeatsHeld = numSeatsHeld;
	}

	/**
	 * @return the numSeatsReserved
	 */
	public Integer getNumSeatsReserved() {
		return numSeatsReserved;
	}

	/**
	 * @param numSeatsReserved the numSeatsReserved to set
	 */
	public void setNumSeatsReserved(Integer numSeatsReserved) {
		this.numSeatsReserved = numSeatsReserved;
	}

	/**
	 * @return the numSeatsTotal
	 */
	public Integer getNumSeatsTotal() {
		return numSeatsTotal;
	}

	/**
	 * @param numSeatsTotal the numSeatsTotal to set
	 */
	public void setNumSeatsTotal(Integer numSeatsTotal) {
		this.numSeatsTotal = numSeatsTotal;
	}

	/**
	 * @return the numSeatsRemaining
	 */
	public Integer getNumSeatsRemaining() {
		return numSeatsRemaining;
	}

	/**
	 * @param numSeatsRemaining the numSeatsRemaining to set
	 */
	public void setNumSeatsRemaining(Integer numSeatsRemaining) {
		this.numSeatsRemaining = numSeatsRemaining;
	}

	/**
	 * @return the seatsList
	 */
	public List getSeatsList() {
		return seatsList;
	}

	/**
	 * @param seatsList the seatsList to set
	 */
	public void setSeatsList(List seatsList) {
		this.seatsList = seatsList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((numSeatsHeld == null) ? 0 : numSeatsHeld.hashCode());
		result = prime
				* result
				+ ((numSeatsRemaining == null) ? 0 : numSeatsRemaining
						.hashCode());
		result = prime
				* result
				+ ((numSeatsReserved == null) ? 0 : numSeatsReserved.hashCode());
		result = prime * result
				+ ((numSeatsTotal == null) ? 0 : numSeatsTotal.hashCode());
		result = prime * result
				+ ((seatsList == null) ? 0 : seatsList.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Row)) {
			return false;
		}
		Row other = (Row) obj;
		if (numSeatsHeld == null) {
			if (other.numSeatsHeld != null) {
				return false;
			}
		} else if (!numSeatsHeld.equals(other.numSeatsHeld)) {
			return false;
		}
		if (numSeatsRemaining == null) {
			if (other.numSeatsRemaining != null) {
				return false;
			}
		} else if (!numSeatsRemaining.equals(other.numSeatsRemaining)) {
			return false;
		}
		if (numSeatsReserved == null) {
			if (other.numSeatsReserved != null) {
				return false;
			}
		} else if (!numSeatsReserved.equals(other.numSeatsReserved)) {
			return false;
		}
		if (numSeatsTotal == null) {
			if (other.numSeatsTotal != null) {
				return false;
			}
		} else if (!numSeatsTotal.equals(other.numSeatsTotal)) {
			return false;
		}
		if (seatsList == null) {
			if (other.seatsList != null) {
				return false;
			}
		} else if (!seatsList.equals(other.seatsList)) {
			return false;
		}
		return true;
	}

	public Row() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Reserved required number of seats passed as an input parameter
	 * 
	 * @param numberOfSeats
	 */
	public void reserveSeat(int numberOfSeatsRequested){
		
		
	}
	
}
