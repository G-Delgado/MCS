package model;
public class PublicPlaylist extends Playlist {
	
	public PublicPlaylist(String name, int MAX_SONGS) { // I see a bit of a problem in MAX_SONGS
		super(name, MAX_SONGS); // Para indicar que estos 3 ya estan inicializados
		// Solo se inicializan los atributos que pongamos nuevos en esta case.
	}

}