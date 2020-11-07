package model;

public class Duration {
	// -------------	Atributes and relations		------------- //
	private int hours; // Represents the hours of duration
	private int minutes; // Represents the minutes of duration
	private double seconds; // Represents the seconds of duration
	// -------------------------------------------------------------
	
	/**
	* Duration's constructor.<br>
	* pre: The hours, minutes and seconds must have been calculated<br>
	* pos: <br>
	* @param hours.	Of type int, represents the hours of duration.<br>
	* @param minutes	Of type int, represents the minutes of duration.<br>
	* @param seconds	Of type double, represents the seconds of duration.
	*/
	
	// -------------	Constructor		------------- //
	public Duration(int hours, int minutes, double seconds) {
		this.hours = hours >= 1 ? hours: 0; // Wrong
		this.minutes = minutes >= 1 ? minutes: 0; // Wrong
		this.seconds = seconds;
	}
	// ------------------------------------------------
	
	// -------------	Methods		------------- //
	public int getHours() {
		return hours;
		
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public double getSeconds() {
		return seconds;
	}
	
	public double toSeconds() {
		double result = (hours*60*60) + (minutes*60) + seconds;
		return result;
	}
	
	/**
	* Creates and returns a message that contains the Duration in hours, minutes and seconds <br>
	* pre: <br>
	* pos: <br>
	* @return message. Contains the duration in hours:minutes:seconds.
	*/
	
	public String toString() {
		
		String message = hours + ":" + minutes + ":" + seconds;
		return message;
	}
	// ------------------------------------------------
}