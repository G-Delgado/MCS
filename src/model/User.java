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
	
	public void setCategory(String category) {
		// Transform String to Category
	}
	
	public void shareSong() {
		
	}
	
	public String toString() {
		return "sape";
	}
}