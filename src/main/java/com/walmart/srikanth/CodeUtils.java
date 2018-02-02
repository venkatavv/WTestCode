package com.walmart.srikanth;

import java.util.UUID;

public class CodeUtils {
	
	public static final Integer NUMBER_OF_SEATS = 3;
	
	public static final Integer NUMBER_OF_ROWS = 3;
	
	public static final Integer TOTAL_NUMBER_OF_SEATS = 9;

	/**
	 * Returns a unique ID
	 * @return int
	 */
	 public static int generateUniqueId() {     
		 
	        UUID idOne = UUID.randomUUID();
	        String str=""+idOne;        
	        int uid=str.hashCode();
	        String filterStr=""+uid;
	        str=filterStr.replaceAll("-", "");
	        return Integer.parseInt(str);
	 }

}
