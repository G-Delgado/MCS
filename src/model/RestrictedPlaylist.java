package model;
public class RestrictedPlaylist extends Playlist {
	private static final int MAX_USERS = 5;
	
	private User[] users;

	
	public RestrictedPlaylist(String name, Duration duration, User user) {
		super(name, duration); 
		users = new User[MAX_USERS]; // Podemos hacerlo de esta forma, o que la persona que lo cree se agregue directamente. O como un metodo, como ya lo tenemos
		users[0] = user;
	}
	
	public void addUser(User user) {
		boolean isNull = false;
		for (int i = 0; i < MAX_USERS && !isNull; i++) {
			if (users[i] == null) {
				users[i] = user;
				isNull = true;
			}
		}
	}
	
	public String usersToString() {
		String out = "";
		for (int i = 0; i < MAX_USERS; i++) {
			if (users[i] != null) {
				out += users[i].getUserName() + ",";
			}
		}
		return out;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n" + 
		"Usuarios: " + usersToString() + "\n" +
		"***************************************\n";
	}
	
}