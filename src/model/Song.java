package model;
public class Song {
	private String title;
	private String artist;
	private String date; // Could be of type Date
	private Duration duration; // Could be of type duration or seconds
	private Genre genre;
	
	public Song(String title, String artist, String date, Duration duration, String genre) {
		this.title = title;
		this.artist = artist;
		this.date = date;
		this.duration = duration;
		this.genre = Genre.valueOf(genre);
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		
	}
	
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		
	}
	
	public Duration getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		// Transform String to Genre
	}
}