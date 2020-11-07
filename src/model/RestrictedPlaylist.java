package model;
public class RestrictedPlaylist extends Playlist {
	// -------------	Constants	------------- //
	private static final int MAX_USERS = 5; // The max allowed of users in the restricted playlist
	// -------------------------------------------- 
	
	// -------------	Atributes and relations		------------- //
	private User[] users; // The array of allowed users of this playlist
	// -------------------------------------------------------------
	
	/**
	* Restricted Playlist's constructor.<br>
	* pre: All the parameters should be defined<br>
	* pos: Initializes the users array and adds the first user.<br>
	* @param name.	Of type String, represents the name of the playlist.<br>
	* @param duration	Of type Duration, represents the current duration of the playlist.<br>
	* @param user	Of type User, represents the user that created the playlist.
	*/
	
	// -------------	Constructor		------------- //
	public RestrictedPlaylist(String name, Duration duration, User user) {
		super(name, duration); 
		users = new User[MAX_USERS]; // Podemos hacerlo de esta forma, o que la persona que lo cree se agregue directamente. O como un metodo, como ya lo tenemos
		users[0] = user;
	}
	// ------------------------------------------------
	
	/**
	* adds a new user to the array of users.<br>
	* pre: The user must be defined<br>
	* pos: The first null position of the users array will be replaced by the user.<br>
	* @param user.	Object of type user, used to insert into the users array.
	*/
	// -------------	Methods		------------- //
	public void addUser(User user) {
		boolean isNull = false;
		for (int i = 0; i < MAX_USERS && !isNull; i++) {
			if (users[i] == null) {
				users[i] = user;
				isNull = true;
			}
		}
	}
	
	/**
	* Confirms whether an user is or is not part of the array of users.<br>
	* pre: The userName must belong to an existing user. <br>
	* pos: <br>
	* @param userName.	User's username, used to confirm whether the user exists in the array.<br>
	* @return found. Of type boolean, its value represents whether the user was found or not.
	*/
	
	public boolean isUser(String userName) {
		boolean found = false;
		for (int i = 0; i < MAX_USERS && !found; i++) {
			if (users[i] != null && users[i].getUserName().equals(userName)) {
				found = true;
			}
		}
		return found;
	}
	
	/**
	* Creates and returns a message that contains all the names of the users that can edit the playlist.<br>
	* pre: All the users must be defined and existing in the array.<br>
	* pos: <br>
	* @return out.	Message with the user's usernames.
	*/
	
	public String usersToString() {
		String out = "";
		for (int i = 0; i < MAX_USERS; i++) {
			if (users[i] != null) {
				out += users[i].getUserName() + ",";
			}
		}
		return out;
	}
	
	/**
	* Creates and returns a message with the playlist information.<br>
	* pre: <br>
	* pos: <br>
	* @return message.	Contains the information of the playlist.
	*/
	
	@Override
	public String toString() {
		String message = super.toString() + "\n" + 
		"**  Users: " + usersToString() + "\n" +
		"***************************************\n";
		return message;
	}
	// ------------------------------------------------
}