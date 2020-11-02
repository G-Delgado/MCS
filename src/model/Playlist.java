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
	
	public void updateDuration(double broughtSeconds) {
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
	
	public void addGenre(Genre genre) {
		boolean isNull = false;
		for (int i = 0; i < MAX_GENRES && !isNull; i++) {
			if (genres[i] == null) {
				genres[i] = genre;
				isNull = true;
			}
		}
	}
	
	public void addSong(Song song) {
		for (int i = 0; i < MAX_SONGS; i++) {
			if (songs[i] == null) { // Se puede validar
				songs[i] = song;
			}
		}
		addGenre(song.getGenre());
		updateDuration(song.getDuration().toSeconds());
		
	}
	
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