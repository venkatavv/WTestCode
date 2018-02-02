package com.walmart.srikanth;

import java.sql.Timestamp;

public class Seat {

	private Integer row;
	
	private Integer column;
	
	private Boolean held = false;
	
	private Boolean reserved = false;
	
	private Boolean open = true;
	
	private Timestamp lastModified = new Timestamp(System.currentTimeMillis());
	
	

	public Seat(Integer row, Integer column, Boolean held, Boolean reserved,
			Boolean open, Timestamp lastModified) {
		super();
		this.row = row;
		this.column = column;
		this.held = held;
		this.reserved = reserved;
		this.open = open;
		this.lastModified = lastModified;
	}
	
	public Seat(Integer row, Integer column) {
		super();
		this.row = row;
		this.column = column;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((column == null) ? 0 : column.hashCode());
		result = prime * result + ((held == null) ? 0 : held.hashCode());
		result = prime * result
				+ ((lastModified == null) ? 0 : lastModified.hashCode());
		result = prime * result + ((open == null) ? 0 : open.hashCode());
		result = prime * result
				+ ((reserved == null) ? 0 : reserved.hashCode());
		result = prime * result + ((row == null) ? 0 : row.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		if (column == null) {
			if (other.column != null)
				return false;
		} else if (!column.equals(other.column))
			return false;
		if (held == null) {
			if (other.held != null)
				return false;
		} else if (!held.equals(other.held))
			return false;
		if (lastModified == null) {
			if (other.lastModified != null)
				return false;
		} else if (!lastModified.equals(other.lastModified))
			return false;
		if (open == null) {
			if (other.open != null)
				return false;
		} else if (!open.equals(other.open))
			return false;
		if (reserved == null) {
			if (other.reserved != null)
				return false;
		} else if (!reserved.equals(other.reserved))
			return false;
		if (row == null) {
			if (other.row != null)
				return false;
		} else if (!row.equals(other.row))
			return false;
		return true;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getColumn() {
		return column;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}

	public Boolean getHeld() {
		return held;
	}

	public void setHeld(Boolean held) {
		this.held = held;
	}

	public Boolean getReserved() {
		return reserved;
	}

	public void setReserved(Boolean reserved) {
		this.reserved = reserved;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}
	
	
	
	
}
