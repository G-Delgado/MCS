package model;
public class PrivatePlaylist extends Playlist {
	private User user;
	
	public PrivatePlaylist(String name, Duration duration, User user) {
		super(name, duration);
		this.user = user;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + "Nosape";
	}
	
	
}