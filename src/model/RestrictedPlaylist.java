package model;
public class RestrictedPlaylist extends Playlist {
	private static final int MAX_USERS = 5;
	
	private User[] users;
	
	public RestrictedPlaylist(String name, Duration duration) {
		super(name, duration); 
		users = new User[MAX_USERS];
	}
	
	public void addUser(User user) {
		for (int i = 0; i < MAX_USERS; i++) {
			if (users[i] == null) {
				users[i] = user;
			}
		}
	}
	
	public String usersToString() {
		String out = "Playlist users:\n";
		for (int i = 0; i < MAX_USERS; i++) {
			if (users[i] != null) {
				out += "User: " + users[i].getUserName() + "\n";
			}
		}
		return out;
	}
	
}