package model;
public class MCS {
	
	public final static int MAX_USERS = 10;
	public final static int MAX_PLAYLIST = 20;
	public final static int MAX_SONGS = 30;
	
	private User[] users;
	private Playlist[] playlists;
	private Song[] songList; // Or pool?
	
	public MCS() {
		users = new User[MAX_USERS];
		playlists = new Playlist[MAX_PLAYLIST];
		songList = new Song[MAX_SONGS];
	}
	
	public void addUser() { // We pass the data needed to create an user
		
	}
	
	public void addPlaylist () { // We pass the data needed to create a playlist
		
	}
	
	public void addSong() { // We pass the data needed to create a song
		
	}
}