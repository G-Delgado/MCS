package model;
public class Song {
	// -------------	Atributes and relations		------------- //
	private String title; // Represents the title of the song, used to find and print the song
	private String artist; // The artist that created the song
	private String date; // The date of release of the song
	private Duration duration; // Type Duration. The duration of the song
	private Genre genre; // Genre of the song
	// -------------------------------------------------------------
	
	/**
	* Playlist's constructor.<br>
	* pre: All the parameters should be defined<br>
	* pos: Initializes the songs and genres arrays<br>
	* @param title.	Of type String, represents the name of the song.<br>
	* @param artist. Of type String, represents the name of the artist<br>
	* @param date.  Of type String, represents the date of release in the format dd/mm/aaaa<br>
	* @param duration	Of type Duration, represents the current duration of the playlist.<br>
	* @param genre. Of type String, represents one of the values in the Genre enum.<br>
	*/
	
	// -------------	Constructor		------------- //
	public Song(String title, String artist, String date, Duration duration, String genre) {
		this.title = title;
		this.artist = artist;
		this.date = date;
		this.duration = duration;
		this.genre = Genre.valueOf(genre);
	}
	// ------------------------------------------------
	
	// -------------	Methods		------------- //
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
	* Creates and returns a message with the song information.<br>
	* pre: <br>
	* pos: <br>
	* @return out.	Contains the information of the song.
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
	// ------------------------------------------------
}