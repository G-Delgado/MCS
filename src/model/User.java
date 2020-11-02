package model;
public class User {
	private String userName;
	private String password;
	private int age;
	private Category category;
	private int sharedSongs;
	
	public User(String userName, String password, int age) {
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.category = Category.valueOf("NEWBIE"); // We could use toUpperCase or pass it directly like a Type Category
		sharedSongs = 0;
	}
	
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
	
	/*public void setCategory(String category) {
		// Transform String to Category
	}*/
	
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
	
	public String toString() {
		return "\n*************  User *************\n" +
		"**  UserName: " + userName + "\n" +
		"**  Age: " + age + "\n" +
		"**  Category: " + category + "\n" +
		"***********************************\n";
	}
}