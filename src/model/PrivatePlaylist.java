package model;
public class PrivatePlaylist extends Playlist {
	
	public PrivatePlaylist(String name, int MAX_SONGS) { // I see a bit of a problem in MAX_SONGS
		super(name, MAX_SONGS); // Para indicar que estos 3 ya estan inicializados
		// Solo se inicializan los atributos que pongamos nuevos en esta case.
	}
}