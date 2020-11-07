package model;
public abstract class Playlist {
	public static final int MAX_SONGS = 30;
	public static final int MAX_GENRES = 6;
	private String name;
	private Song[] songs;
	private Genre[] genres;
	private Duration duration;
	
	public Playlist(String name, Duration duration) {
		this.name = name;
		// Suponiendo que las playlist pueden tener maximo las canciones que hay en el pool
		songs = new Song[MAX_SONGS];
		genres = new Genre[MAX_GENRES];
		this.duration = duration;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		
	}
	
	public Duration getDuration() {
		return duration;
	}
	
	/**
	* Updates the duration each time a new song is added to the playlist.<br>
	* pre: The song must be defined and have its duration defined.<br>
	* pos: <br>
	* @param broughtSeconds. Seconds brough from the song to add
	*/
	
	public void updateDuration(double broughtSeconds) { // REVISARR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		double seconds = duration.toSeconds() + broughtSeconds;
		int hours = (int)seconds/60/60;
		int minutes = (int)seconds/60%60;
		double finalSeconds = seconds%60%60;
		
		duration = new Duration(hours, minutes, finalSeconds);
		
	}
	
	public String getGenres() {
		String output = "Genres:\n";
		for (int i = 0; i < genres.length; i++) {
			output += genres[i] + "\n";
		}
		
		return output;
	}
	
	/**
	* Adds a new genre to the playlist.<br> 
	* pre: The genre must be defined.<br>
	* pos: The array genres will have the first null position replaced by the genre.<br>
	* @param genre. Genre to add to the array of genres
	*/
	
	public void addGenre(Genre genre) {
		boolean isNull = false;
		for (int i = 0; i < MAX_GENRES && !isNull; i++) {
			if (genres[i] == null) {
				genres[i] = genre;
				isNull = true;
			}
		}
	}
	
	/**
	* Adds a new song to the playlist,<br>
	* pre: The song must be defined.<br>
	* pos: The array of songs will have on of its null positions replace by the song.<br>
	* @param song. Song to add to the array of songs.
	*/
	
	public void addSong(Song song) {
		for (int i = 0; i < MAX_SONGS; i++) {
			if (songs[i] == null) { // Se puede validar
				songs[i] = song;
			}
		}
		addGenre(song.getGenre());
		updateDuration(song.getDuration().toSeconds());
		
	}
	
	/**
	* Converts the information of the playlist into a message.<br>
	* pre: All the values to return must be defined.<br>
	* pos: <br>
	* @return out. Message that contains the essential information of the array
	*/
	
	public String toString() {
		String out = "\n**************  Playlist **************\n" +
		"**  Title: " + name + "\n" + 
		"**  Duration: " + duration + "\n" +
		"**  Genre: " ;
		
		for (int i = 0; i < MAX_GENRES; i++) {
			if (genres[i] != null) {
				out += genres[i] + ", "; 
			}
		}
		
		return out;
	}
}