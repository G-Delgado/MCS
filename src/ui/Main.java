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
		"Menu!\n" +
		"(1) Agrear un usuario\n" +
		"(2) Operaciones con playlist\n" +
		"(3) Compartir una cancion\n" +
		"(4) Listar canciones\n" +
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
		
	}
	
	public void showSongs() {
		
	}
	
	public void showPlaylistMenu() {
		int opt = 0;
		
		do {
			System.out.println(
			"Menu de playlist\n" +
			"(1) Crear playlist publica\n" +
			"(2) Crear playlist restringida\n" +
			"(3) Crear playlist privada\n" +
			"(4) Anadir usuarios a una playlist restringida\n" +
			"(5) Subir canciones a playlist\n" +
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
				break;
			case 5:
				break;
			default:
				System.out.println("Opcion no valida");
				break;
		}
	}
	
	public void createPublicPlaylist() {
		
	}
	
	
	public void createRestrictedPlaylist() {
		
	}
	
	public void createPrivatePlaylist(){
		
	}
}