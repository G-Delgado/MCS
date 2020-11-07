package model;
public class MCS {
	// -------------	Constants	------------- //
	public static final int MAX_USERS = 10;
	public static final int MAX_PLAYLIST = 20;
	public static final int MAX_SONGS = 30;
	// --------------------------------------------
	
	// -------------	Atributes and relations		------------- //
	private User[] users;
	private Playlist[] playlists;
	private Song[] poolOfSongs;
	// --------------------------------------------
	
	public MCS() {
		users = new User[MAX_USERS];
		playlists = new Playlist[MAX_PLAYLIST];
		poolOfSongs = new Song[MAX_SONGS];
	}
	
	/**
	* Adds a new user to the MCS application
	* pre: The name and password must be diferent from an empty string, the age must be different than 0.<br>
	* pos: The first null position of the users array will be replace by the new user.<br>
	* @param name.	User's username, used to create and add the user. <br>
	* @param password.	User's password, used to create and add the user. <br>
	* @param age.	User's age, used to create and add the user. <br>
	*/
	
	public void addUser(String name, String password, int age) { // We pass the data needed to create an user
		boolean isNull = false;
		for (int i = 0; i < MAX_USERS && !isNull; i++) {
			if (users[i] == null) {
				users[i] = new User(name, password, age);
				isNull = true;
			}
		}
	}
	
	/**
	* Used to increase the shared songs of an user by passing their username. <br>
	* pre: The user's username must be defined<br>
	* pos: <br>
	* @param userName.	User's username, used to find the user.
	*/
	
	public void userSharedSong(String userName) {
		boolean found = false;
		for (int i = 0; i < MAX_USERS && !found; i++) {
			if (users[i] != null && users[i].getUserName().equals(userName)) {
				users[i].sharedSong();
				found = true;
			}
		}
	}
	
	/**
	* Creates and adds a public playlist to the array of playlists. <br>
	* pre: The name should be different from an empty string.<br>
	* pos: The first null position of the playlists array will be replaced by the new playlist<br>
	* @param name.	Playlist's name, used to create the playlist.
	*/
	
	public void addPublicPlaylist(String name) { 
		boolean isNull = false;
		Duration duration = new Duration(0,0,0);
		for (int i = 0; i < MAX_PLAYLIST && !isNull; i++) {
			if (playlists[i] == null) {
				playlists[i] = new PublicPlaylist(name, duration);
				isNull = true;
			}
		}
	}
	
	/**
	* Rates the selected playlist
	* pre: The name of the playlist must belong to an existing playlist.<br>
	* pos: Changes the rating of one the selected playlist.<br>
	* @param name.	Playlist's name, used to find the playlist.<br>
	* @param rating. Used to add the rating to the playlist.
	*/
	
	public void ratePublicPlaylist(String name, double rating) {
		boolean found = false;
		for (int i = 0; i < MAX_PLAYLIST && !found; i++) {
			if (playlists[i] != null && playlists[i].getName().equals(name) && playlists[i] instanceof PublicPlaylist) {
					PublicPlaylist mock = (PublicPlaylist)playlists[i];
					mock.addRating(rating);
			}
		}
		if (!found) {
				System.out.println("Esa playlist publica no existe");
		}
	}
	
	/**
	* Creates and adds a restricted playlist to the array of playlists.<br>
	* pre: The name of the playlist should be different from an empty string and the userName should belong to an user.<br>
	* pos: The first null position of the playlists array will be replaced by the new playlist<br>
	* @param name. Playlist's name, used to create the playlist.<br>
	* @param userName. userName of the creator of the playlist, used to created the playlist and add the user to the allowed users.
	*/
	
	
	public void addRestrictedPlaylist(String name, String userName) {
		boolean isNull = false;
		boolean found = false;
		User foundUser = null;
		
		for (int i = 0; i < MAX_USERS; i++) {
			if (users[i] != null && users[i].getUserName().equals(userName)) {
				foundUser = users[i];
				found = true;
			}
		}
		Duration duration = new Duration(0,0,0);
		for (int i = 0; i < MAX_PLAYLIST && !isNull; i++) {
			if (playlists[i] == null) {
				playlists[i] = new RestrictedPlaylist(name, duration, foundUser);
				isNull = true;
			}
		}
	}
	
	/**
	* Adds an user to a restricted playlist.<br>
	* pre: The playlist's name should belong to a playlist and the userName to an user.<br>
	* pos: The selected playlist will add a new user in its array of users.<br>
	* @param name.	Playlist's name, used to find the playlist.<br>
	* @param userName.	User's username, used to add the respective user to the playlist
	*/
	
	public void addToRestrictedPlaylist(String name, String userName) {
		boolean userFound = false;
		boolean found = false;
		User mock = null;
		
		for (int i = 0; i < MAX_USERS && !userFound; i++) {
			if (users[i] != null && users[i].getUserName().equals(userName)) {
				mock = users[i];
				userFound = true;
			}
		}
		
		for (int i = 0; i < MAX_PLAYLIST && !found; i++) {
			if (playlists[i] != null && playlists[i].getName().equals(name)) {
				RestrictedPlaylist playlistMock = (RestrictedPlaylist)playlists[i];
				playlistMock.addUser(mock);
				found = true;
			}
		}
	}
	
	/**
	* Creates and adds a private playlist to the array of playlists.<br>
	* pre: Both the name and the userName should belong to a playlist and an user respectively.<br>
	* pos: The firs null position of the array of playlists will be replaced with the crerated playlist<br>
	* @param name.	Playlist's name, used to create the playlist.<br>
	* @param userName.	User's username, used to add the user to the playlist when created.
	*/
	
	public void addPrivatePlaylist(String name, String userName) {
		boolean isNull = false;
		boolean found = false;
		User foundUser = null;
		
		for (int i = 0; i < MAX_USERS; i++) {
			if (users[i] != null && users[i].getUserName().equals(userName)) {
				foundUser = users[i];
				found = true;
			}
		}
		Duration duration = new Duration(0,0,0);
		for (int i = 0; i < MAX_PLAYLIST && !isNull; i++) {
			if (playlists[i] == null) {
				playlists[i] = new PrivatePlaylist(name, duration, foundUser);
				isNull = true;
			}
		}
	}
	
	/**
	* Shares a song to a selected playlist
	* pre: The playlistName, songTitle and userName should belong to a playlist, song and an user respectively<br>
	* pos: The selected playlist will have a song added to its array of songs.<br>
	* @param playlistName.	Playlist's name, used to find the playlist.<br>
	* @param songTitle.		Song's title, used to find the song.<br>
	* @param userName.		User's username, used to know which user added the song.
	*/
	
	public void shareSongToPlaylist(String playlistName, String songTitle, String userName) { 
			boolean searchedSong = false;
			boolean foundPlaylist = false;
			Song foundSong = null;
			for (int i = 0; i < MAX_SONGS && !searchedSong; i++) {
				if (poolOfSongs[i] != null && poolOfSongs[i].getTitle().equals(songTitle)) {
					foundSong = poolOfSongs[i];
					searchedSong = true;
				}
			}
			
			for (int i = 0; i < MAX_PLAYLIST && !foundPlaylist; i++){
				if (playlists[i] != null && playlists[i].getName().equals(playlistName)) {
					if (playlists[i] instanceof RestrictedPlaylist) {
						RestrictedPlaylist mockOne = (RestrictedPlaylist)playlists[i]; // We are cloning by reference, so it doesnt matters.
						if (mockOne.isUser(userName)) {
							mockOne.addSong(foundSong);
						} else {
							System.out.println("\n!!ALERTA!! No haces parte de los usuarios permitidos\n");
						}
					} else if (playlists[i] instanceof PrivatePlaylist) {
						PrivatePlaylist mockTwo = (PrivatePlaylist)playlists[i];
						if (mockTwo.getUser().getUserName().equals(userName)) {
							mockTwo.addSong(foundSong);
						} else {
							System.out.println("\n!!ALERTA!! No eres el usuario permitido de la playlist\n");
						}
					} else if (playlists[i] instanceof PublicPlaylist) {
						playlists[i].addSong(foundSong);
					}
					foundPlaylist = true;
				}
			}
	}
	
	/**
	* Confirms whether there is or is not enough space to add another song to the application. <br>
	* pre: <br>
	* pos: <br>
	* @return thereIsSomeSpace. Its boolean value determines whether there is or is not any space left.
	*/
	
	public boolean spaceForSongs() {
		boolean thereIsSomeSpace = false;
		for (int i = 0; i < MAX_SONGS && !thereIsSomeSpace; i++) {
			if (poolOfSongs[i] == null) {
				thereIsSomeSpace = true;
			}
		}
		return thereIsSomeSpace;
	}
	
	/**
	* Confirms whether the user exists or doesnt exists in the users array. <br>
	* pre: The userNameSape should be different from an empty string<br>
	* pos: <br>
	* @return userIsSomewhere.	Its boolean value determines whether the user exists or doesnt exists in the users array.
	*/
	
	public boolean userExists(String userNameSape) {
		boolean userIsSomewhere = false;
		for (int i = 0; i < MAX_USERS && !userIsSomewhere; i++) {
			if (users[i] != null && users[i].getUserName().equals(userNameSape)) {
				userIsSomewhere = true;
			}
		}
		return userIsSomewhere;
	}
	
	/**
	* Creates and adds a new song to the poolOfSongs.<br>
	* pre: All the parameters must be defined<br>
	* pos: The first null position of the poolOfSongs array will be replaced by the created song.<br>
	* @param title.	Song's title, used to create the song
	* @param artist. Song's artist (or band), used to create the song
	* @param date.	Song's date of release, used to create the song
	* @param durationSeconds.	Song's duration in seconds, used to create the song
	* @param genre.	Song's genre, used to create the song
	*/
	
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
	
	/**
	*
	*
	*
	*/
	
	public Duration convertSecondsToDuration(double durationSeconds) {
		int hours = 0;
		int minutes = 0;
		double seconds = 0.0;
		hours = (int)durationSeconds/60/60;
		minutes = (int)durationSeconds/60%60;
		seconds = durationSeconds%60%60;
		
		return new Duration(hours, minutes, seconds);
	}

	/**
	*
	*
	*
	*/

	public String songsToString() { 
		String out = ""; // Si tengo un toString de las canciones, me evitaria tener que hacer estos llamados aqui, lo que lo haria mejor :D
		for (int i = 0; i < MAX_SONGS; i++) {
			if (poolOfSongs[i] != null) {
				out += poolOfSongs[i].toString();
			}
		}
		return out;
	}

	/**
	*
	*
	*
	*/

	public String usersToString() {
		String out = "";
		for (int i = 0; i < MAX_USERS; i++) {
			if (users[i] != null) {
				out += users[i].toString();
			}
		}
		return out;
	}
	
	/**
	*
	*
	*
	*/
	
	public String playlistsToString() {
		String out = "";
		for (int i = 0; i < MAX_PLAYLIST; i++) {
			if (playlists[i] != null) {
				out += playlists[i].toString();
			}
		}
		return out;
	}
}