package model;

public class Duration {
	private int hours;
	private int minutes;
	private double seconds;
	
	public Duration(int hours, int minutes, double seconds) {
		this.hours = hours >= 1 ? hours: 0; // Wrong
		this.minutes = minutes >= 1 ? minutes: 0; // Wrong
		this.seconds = seconds;
	}
	
	public int getHours() {
		return hours;
		
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public double getSeconds() {
		return seconds;
	}
	
	public String toString() {
		
		String message = hours + ":" + minutes + ":" + seconds;
		return message;
	}
}