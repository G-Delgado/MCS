package model;
public class Song {
	private String title;
	private String artist;
	private String date;
	private Duration duration;
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
	
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = Genre.valueOf(genre);
	}
	
	/**
	*
	*
	*
	*/
	
	public String toString() {
		String out = "\n**************  Song  **************\n" +
				"** Title: " + title + "\n" +
				"** Artist: " + artist + "\n" +
				"** Duration: " + duration + "\n" +
				"** Genre: " + genre + "\n" +
				"***********************************\n";
		return out;
	}
}