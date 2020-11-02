package model;
public class MCS {
	
	public static final int MAX_USERS = 10;
	public static final int MAX_PLAYLIST = 20;
	public static final int MAX_SONGS = 30;
	
	private User[] users;
	private Playlist[] playlists;
	private Song[] poolOfSongs;
	
	public MCS() {
		users = new User[MAX_USERS];
		playlists = new Playlist[MAX_PLAYLIST];
		poolOfSongs = new Song[MAX_SONGS];
	}
	
	public void addUser(String name, String password, int age) { // We pass the data needed to create an user
		boolean isNull = false;
		for (int i = 0; i < MAX_USERS && !isNull; i++) {
			if (users[i] == null) {
				users[i] = new User(name, password, age);
				isNull = true;
			}
		}
	}
	
	public void userSharedSong(String userName) {
		boolean found = false;
		for (int i = 0; i < MAX_USERS && !found; i++) {
			if (users[i] != null && users[i].getUserName().equals(userName)) {
				users[i].sharedSong();
				System.out.println("Compartiste!");
				found = true;
			}
		}
	}
	
	/*We are going to create the playlist with overloaded methods, this way we only need to change some parameters, at the best panorama*/
	public void addPublicPlaylist (String name) { // I need to pass a public, private or restricted playlist, not a "PLAYLIST" as a whole
		boolean isNull = false;
		Duration duration = new Duration(0,0,0);
		for (int i = 0; i < MAX_PLAYLIST && !isNull; i++) {
			if (playlists[i] == null) {
				playlists[i] = new PublicPlaylist(name, duration);
				isNull = true;
			}
		}
	}
	
	public void addRestrictedPlaylist() {
		
	}
	
	public void addPrivatePlaylist() {
		
	}
	
	public boolean spaceForSongs() {
		boolean thereIsSomeSpace = false;
		for (int i = 0; i < MAX_SONGS && !thereIsSomeSpace; i++) {
			if (poolOfSongs[i] == null) {
				thereIsSomeSpace = true;
			}
		}
		return thereIsSomeSpace;
	}
	
	public boolean userExists(String userNameSape) {
		boolean userIsSomewhere = false;
		for (int i = 0; i < MAX_USERS && !userIsSomewhere; i++) {
			if (users[i] != null && users[i].getUserName().equals(userNameSape)) {
				userIsSomewhere = true;
			}
		}
		
		return userIsSomewhere;
	}
	
	public void addSong(String title, String artist, String date, double durationSeconds, String genre) { // We pass the data needed to create a song
		boolean isNull = false;
		Duration duration = convertSecondsToDuration(durationSeconds);
		for (int i = 0; i < MAX_PLAYLIST && !isNull; i++) {
			if (poolOfSongs[i] == null) {
				poolOfSongs[i] = new Song(title, artist, date, duration, genre);
				isNull = true;
			}
		}
	}
	
	public Duration convertSecondsToDuration(double durationSeconds) {
		int hours = 0;
		int minutes = 0;
		double seconds = 0.0;
		hours = (int)durationSeconds/60/60;
		minutes = (int)durationSeconds/60%60;
		seconds = durationSeconds%60%60;
		/*if (durationSeconds < 60) {
			seconds = durationSeconds;
		} else if (durationSeconds < 3600) {            RECORDAR DE RETIRAR ESTA CINTAAAA
			minutes = durationSeconds/60;
			seconds = durationSeconds%60;
		} else {
			hours = durationSeconds/60/60;
			minutes = durationSeconds/60%60;
			seconds = durationSeconds%60%60;
		}*/
		return new Duration(hours, minutes, seconds);
	}

	public String songsToString() { // Tengo que hacer que los usuarios obtengan un ++ por cada cancion que compartan.
		String out = ""; // Si tengo un toString de las canciones, me evitaria tener que hacer estos llamados aqui, lo que lo haria mejor :D
		for (int i = 0; i < MAX_SONGS; i++) {
			if (poolOfSongs[i] != null) {
				out += "\n**************  Song  **************\n" +
				"** Title: " + poolOfSongs[i].getTitle() + "\n" +
				"** Artist: " + poolOfSongs[i].getArtist() + "\n" +
				"** Duration: " + poolOfSongs[i].getDuration() + "\n" +
				"** Genre: " + poolOfSongs[i].getGenre() + "\n" +
				"***********************************\n";
			}
		}
		
		return out;
	}

	public String usersToString() {
		String out = "";
		for (int i = 0; i < MAX_USERS; i++) {
			if (users[i] != null) {
				out += users[i].toString();
			}
		}
		
		return out;
	}
	
}