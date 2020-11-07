package model;
public class User {
	// -------------	Atributes and relations		------------- //
	private String userName; // The user's username. Used in a variety of methods
	private String password; // User's password.
	private int age; // User's age. Used in the display of information
	private Category category; // User's category, used in a couple methods and to display the information of the user.
	private int sharedSongs; // Ammount of sharedSongs of the user.
	// -------------------------------------------------------------
	/**
	* User's constructor.<br>
	* pre: All the atributes must be defined and diferent from either an empty string or a 0.<br>
	* pos: <br>
	* @param userName.	User's username, asigned to the atribute userName.<br>
	* @param password.	User's password, asigned to the atribute password.<br>
	* @param age.	User's age, asigned to the atribute age.
	*/
	
	// -------------	Constructor		------------- //
	public User(String userName, String password, int age) {
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.category = Category.valueOf("NEWBIE");
		sharedSongs = 0;
	}
	// ------------------------------------------------
	
	// -------------	Methods		------------- //
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		
	}
	
	public Category getCategory() {
		return category;
	}
	
	/**
	* Increases the shared songs by one and checks whether the user leveled up his category or not. <br>
	* pre: <br>
	* pos: <br>
	*/
	
	public void sharedSong() {
		sharedSongs++;
		System.out.println("\nHas compartido " + sharedSongs + " canciones\n");
		if (sharedSongs <= 3) {
			category = Category.valueOf("NEWBIE");
			System.out.println("Tu categoria es: " + category);
		} else if (sharedSongs > 3 && sharedSongs < 10) {
			category = Category.valueOf("LITTLECONTRIBUTOR");
			System.out.println("Tu categoria es: " + category);
		} else if (sharedSongs >= 10 && sharedSongs <= 30) {
			category = Category.valueOf("MILDCONTRIBUTOR");
			System.out.println("Tu categoria es: " + category);
		} else if (sharedSongs > 30) {
			category = Category.valueOf("STARCONTRIBUTOR");
			System.out.println("Tu categoria es: " + category + "!!!!");
		}
	}
	
	/**
	* Creates and returns a message that contains the importat information of the user. <br>
	* pre: <br>
	* pos: <br>
	* @return message. Contains the information of the user.
	*/
	
	public String toString() {
		String message = "\n*************  User *************\n" +
		"**  UserName: " + userName + "\n" +
		"**  Age: " + age + "\n" +
		"**  Category: " + category + "\n" +
		"*********************************\n";
	return message;
	}
	// ------------------------------------------------
	
}