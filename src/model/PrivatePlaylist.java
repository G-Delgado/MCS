package model;
public class PrivatePlaylist extends Playlist {
	private User user;
	
	public PrivatePlaylist(String name, Duration duration, User user) {
		super(name, duration);
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
	/**
	*
	*
	*
	*/
	
	@Override
	public String toString() {
		return super.toString() + "\n" +
		"**  User: " + user.getUserName() + "\n" +
		"***************************************\n";
	}
	
	
}

