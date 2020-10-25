package model;
public class Playlist {
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