/**
 * 
 */
package com.walmart.srikanth;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author VanapalliV
 *
 */
public class AppScheduler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * Scheduler runs the task every 4 secs
		 */
		TimerTask task = new AppTimerTask();
    	Timer timer = new Timer();
    	timer.schedule(task, 0,4000);

	}

}
