package ui;

/**
* @author Gabriel Delgado
*/
import java.util.Scanner;
import model.MCS;

public class Main {
	
	// -------------	Atributes y relations	------------- //
	
	private MCS mcs; // Represents the management class of the problem.
	private Scanner in; // The scanner to read the inputs
	
	// --------------------------------------------
	
	// -------------	Constructor		------------- //
	
	public Main() {
		mcs = new MCS();
		in = new Scanner(System.in);
	}
	
	// --------------------------------------------
	
	// -------------	Entry of the program	------------- //
	
	public static void main (String args[]) {
		Main ppal = new Main();
		System.out.println("Hola Tarea Integradora 2!");
		
		int option = 0;
		do {
			option = ppal.showMenu();
			ppal.executeOperation(option);
			
		} while (option != 0);
	}
	
	// --------------------------------------------
	
	/**
	* Displays the gui and shows the available options. <br>
	* pre: <br>
	* pos: <br>
	* @return opt. of type int.
	*/
	
	// -------------	Methods		------------- //
	
	public int showMenu() {
		System.out.println(
		"\nMenu!\n" +
		"(1) Agrear un usuario\n" +
		"(2) Operaciones con las playlist\n" +
		"(3) Compartir una cancion\n" +
		"(4) Listar canciones\n" +
		"(5) Listar usuarios\n" +
		"(6) Listar playlists\n" +
		"(0) Para salir\n"
		);
		
		int opt = in.nextInt();
		in.nextLine();
		
		return opt;
	}
	
	/**
	* Executes a method based on the option. <br>
	* pre: opt must be between 0 and 6. <br>
	* pos: <br>
	* @param opt. integer used to choose the method to execute.
	*/
	
	public void executeOperation(int opt) {
		switch (opt) {
			case 0:
				System.out.println("Saliendo...");
				break;
			case 1:
				createUser();
				break;
			case 2:
				showPlaylistMenu();
				break;
			case 3:
				createSong();
				break;
			case 4:
				showSongs();
				break;
			case 5:
				showUsers();
				break;
			case 6:
				showPlaylists();
				break;
			default:
				System.out.println("Opcion no valida");
				break;
		}
	}
	
	/**
	* Asks for the data and creates an user. <br>
	* pre: The username shouldn't have any spaces<br>
	* pos: <br>
	*/
	
	public void createUser() {
		System.out.println("Escribe el nombre de usuario");
		String userName = in.nextLine();
		System.out.println("Escribe la contrasena");
		String password = in.nextLine();
		System.out.println("Escribe la edad");
		int age = in.nextInt();
		in.nextLine();
		
		mcs.addUser(userName, password, age);
	}
	
	/**
	* Asks for the data and creates a song. <br>
	* pre: <br>
	* pos: <br>
	*/
	
	public void createSong() {
		System.out.println("Escribe el nombre de usuario que compartira la cancion: ");
		String userName = in.nextLine();
		
		if (mcs.userExists(userName)) {
			if (mcs.spaceForSongs()) {
			
			System.out.println("Escribe el titulo de la cancion");
			String title = in.nextLine();
			System.out.println("Escribe el artista de la cancion");
			String artist = in.nextLine();
			System.out.println("Escribe la fecha en la que salio (dd/mm/aaaa)");
			String date = in.nextLine();
			System.out.println("Escribe la duracion de la cancion (en segundos)");
			double duration = in.nextDouble();
			in.nextLine();
			System.out.println(
			"Escribe el genero de la cancion\n" +
			"Opciones:\n" +
			"Rock\n" +
			"Hip hop \n" +
			"Musica clasica \n" +
			"Reggae \n" +
			"Salsa \n" +
			"Metal\n"
			);
			String genre = in.nextLine();
			genre = genre.replaceAll(" ", "").toUpperCase();
		
			mcs.addSong(title, artist, date, duration, genre);
			mcs.userSharedSong(userName);
			
			
			} else {
				System.out.println("No hay espacio para mas canciones");
			}
		} else {
			System.out.println("Ese usuario no existe");
		}
	}
	
	/**
	* Displays the existing songs. <br>
	* pre: <br>
	* pos: <br>
	*/
	
	public void showSongs() {
		System.out.println(mcs.songsToString());
	}
	
	/**
	* Displays the existing users. <br>
	* pre: <br>
	* pos: <br>
	*/
	
	public void showUsers() {
		System.out.println(mcs.usersToString());
	}
	
	/**
	* Displays the existing playlists. <br>
	* pre: <br>
	* pos: <br>
	*/
	
	public void showPlaylists() {
		System.out.println(mcs.playlistsToString());
	}
	
	/**
	* Displays a gui for the available playlists interactions. <br>
	* pre: <br>
	* pos: <br>
	*/
	
	public void showPlaylistMenu() {
		int opt = 0;
		
		do {
			System.out.println(
			"\nMenu de playlist\n" +
			"(1) Crear playlist publica\n" +
			"(2) Crear playlist restringida\n" +
			"(3) Crear playlist privada\n" +
			"(4) Anadir usuarios a una playlist restringida\n" +
			"(5) Subir canciones a playlist\n" +
			"(6) Calificar playlist publica\n" +
			"(0) Para salir\n"
			);
			
			opt = in.nextInt();
			in.nextLine();
			executePlaylistOperation(opt);
			
		} while (opt != 0);
		
	}
	
	/**
	* Executes a method of the playlist gui based on the option. <br>
	* pre: opt must be between 0 and 6. <br>
	* pos: <br>
	* @param opt. integer used to choose the method to execute.
	*/
	
	public void executePlaylistOperation(int opt) {
		switch (opt) {
			case 0:
				System.out.println("Regresando al menu");
				break;
			case 1:
				createPublicPlaylist();
				break;
			case 2:
				createRestrictedPlaylist();
				break;
			case 3:
				createPrivatePlaylist();
				break;
			case 4:
				addUsersToPlaylist();
				break;
			case 5:
				addSongToPlaylist();
				break;
			case 6:
				ratePlaylist();
				break;
			default:
				System.out.println("Opcion no valida");
				break;
		}
	}
	
	/**
	* Asks for the data needed to create a public playlist and creates one. <br>
	* pre: <br>
	* pos: <br>
	*/
	
	public void createPublicPlaylist() {
		// Deberia validar que un usuario la cree?
		System.out.println("Escribe el nombre de la playlist");
		String name = in.nextLine();
		
		mcs.addPublicPlaylist(name);
	}
	
	/**
	* Asks for the data needed to create a restricted playlist and creates one. <br>
	* pre: The user's username must be defined in the application<br>
	* pos: <br>
	*/
	
	public void createRestrictedPlaylist() {
		System.out.println("Escribe el nombre del usuario");
		String userName = in.nextLine();
		if (mcs.userExists(userName)) {
			System.out.println("Escribe el nombre de la playlist");
			String name = in.nextLine();
			mcs.addRestrictedPlaylist(name, userName);
		} else {
			System.out.println("Ese usuario no existe");
		}
	}
	
	/**
	* Asks for the user to add to a restricted playlist <br>
	* pre: The user's username must be defined in the application.<br>
	* pos: <br>
	*/
	
	public void addUsersToPlaylist() {
		System.out.println("Escribe el nombre del usuario");
		String userName = in.nextLine();
		if (mcs.userExists(userName)) {
			System.out.println("A que playlist quieres agregarlo?");
			String name = in.nextLine();
			
			mcs.addToRestrictedPlaylist(name, userName);
		} else {
			System.out.println("Ese usuario no existe");
		}
	}
	
	/**
	* Asks for the data needed to create a private playlist and creates one. <br>
	* pre: The user's username must be defined in the application<br>
	* pos: <br>
	*/
	
	public void createPrivatePlaylist(){
		System.out.println("Escribe el nombre del usuario");
		String userName = in.nextLine();
		if (mcs.userExists(userName)) {
			System.out.println("Escribe el nombre de la playlist");
			String name = in.nextLine();
			mcs.addPrivatePlaylist(name, userName);
		} else {
			System.out.println("Ese usuario no existe");
		}

	}

	/**
	* Asks for an user's username and a song, to verify and insert in a playlist. <br>
	* pre: The user, the song and the playlist must be defined in the application. <br>
	* pos: <br>
	*/

	public void addSongToPlaylist() {
		System.out.println("Escribe el nombre del usuario que compartira la cancion");
		String userName = in.nextLine();
		if (mcs.userExists(userName)) {
			System.out.println("Escribe el nombre de la playlist"); 
			String playlistName = in.nextLine();
			System.out.println("Escribe el nombre de la cancion"); 
			String songTitle = in.nextLine();
			mcs.shareSongToPlaylist(playlistName, songTitle, userName);
		} else {
			System.out.println("Este usuario no existe");
		}	
	}
	
	/**
	* Asks for an user's username and a playlist name to rate it. <br>
	* pre: The playlist must be public and the user and the playlist must be defined..<br>
	* pos: <br>
	*/
	
	public void ratePlaylist() {
		System.out.println("Escribe el nombre del usuario");
		String userName = in.nextLine();
		if (mcs.userExists(userName)) {
			System.out.println("Que playlist quieres calificar?");
			String name = in.nextLine();
			System.out.println("Que calificacion le quieres dar?");
			double rating = in.nextDouble();
			in.nextLine();
			mcs.ratePublicPlaylist(name, rating);
		}
		
	}
	
	// --------------------------------------------
	
}