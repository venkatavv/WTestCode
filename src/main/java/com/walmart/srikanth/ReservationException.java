package com.walmart.srikanth;

public class ReservationException extends RuntimeException{
	
	String errorMsg = "";
	
	String errorCode = "";

	/**
	 * @param errorMsg
	 * @param errorCode
	 */
	public ReservationException(String errorMsg, String errorCode) {
		super();
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
	}

	/**
	 * 
	 */
	public ReservationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ReservationException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ReservationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ReservationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ReservationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

		

}
