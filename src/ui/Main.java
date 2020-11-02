package ui;

import java.util.Scanner;
import model.MCS;

public class Main {
	private MCS mcs;
	private Scanner in;
	
	public Main() {
		mcs = new MCS();
		in = new Scanner(System.in);
	}
	
	public static void main (String args[]) {
		Main ppal = new Main();
		System.out.println("Hola Tarea Integradora 2!");
		
		int option = 0;
		do {
			option = ppal.showMenu();
			ppal.executeOperation(option);
			
		} while (option != 0);
	}
	
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
	
	public void showSongs() {
		System.out.println(mcs.songsToString());
	}
	
	public void showUsers() {
		System.out.println(mcs.usersToString());
	}
	
	public void showPlaylists() {
		System.out.println(mcs.playlistsToString());
	}
	
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
	
	public void createPublicPlaylist() {
		// Deberia validar que un usuario la cree?
		System.out.println("Escribe el nombre de la playlist");
		String name = in.nextLine();
		
		mcs.addPublicPlaylist(name);
	}
	
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

	public void addSongToPlaylist() {
		System.out.println("Escribe el nombre de la playlist"); //Se puede validar
		String playlistName = in.nextLine();
		System.out.println("Escribe el nombre de la cancion"); // Tambien se puede validar
		String songTitle = in.nextLine();
		
		mcs.shareSongToPlaylist(playlistName, songTitle);
	}
	
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
	
}