package model;
public class PrivatePlaylist extends Playlist {
	// -------------	Atributes and relations		------------- //
	private User user; // The user that created the playlist
	// -------------------------------------------------------------
	
	/**
	* Private Playlist's constructor.<br>
	* pre: All the parameters should be defined<br>
	* pos: <br>
	* @param name.	Of type String, represents the name of the playlist.<br>
	* @param duration	Of type Duration, represents the current duration of the playlist.<br>
	* @param user	Of type User, represents the user that created the playlist.
	*/
	// -------------	Constructor		------------- //
	public PrivatePlaylist(String name, Duration duration, User user) {
		super(name, duration);
		this.user = user;
	}
	// ------------------------------------------------
	
	// -------------	Methods		------------- //
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
	/**
	* Returns a message with the information of the playlist.<br>
	* pre: <br>
	* pos: <br>
	* @return message.	Message that contains the information of the playlist
	*/
	
	@Override
	public String toString() {
		String message = super.toString() + "\n" +
		"**  User: " + user.getUserName() + "\n" +
		"***************************************\n";
		return message;
	}
	// ------------------------------------------------
}

