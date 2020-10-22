package model;
public class Playlist {
	private String name;
	private Song[] songs;
	private Genre[] genres;
	private String duration; // Though it could be from a class Duration
	
	public Playlist(String name, int MAX_SONGS) {
		this.name = name;
		// Presuponiendo que las playlist pueden tener maximo las canciones que hay en el pool
		songs = new Song[MAX_SONGS];
		genres = null; //Probably incorrect
		// Other option === genres = new Genre[6];
		//this.genres = Genre.valueOf(genres); // genre could have a toUpperCase, just in case i do not handle it outside.
		// Starts without genre
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		
	}
	
	public String getDuration() {
		return duration;
	}
	
	// You can not set the duration as it is an automatic calculation
	
	public String getGenres() {
		String output = "Genres:\n";
		for (int i = 0; i < genres.length; i++) {
			output += genres[i] + "\n";
		}
		
		return output;
	}
	
	public void setGenre(String genre) {
		// Transfrom String to Genre
	}
	
	public String toString() {
		return "Sape";
	}
}