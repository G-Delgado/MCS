package model;

public class PublicPlaylist extends Playlist {
	// -------------	Atributes and relations		------------- //
	Double[] rating; // Array that represents the ratings addded.
	// -------------------------------------------------------------
	
	/**
	* Public Playlist's constructor.<br>
	* pre: All the parameters should be defined<br>
	* pos: Initializes the rating array<br>
	* @param name.	Of type String, represents the name of the playlist.<br>
	* @param duration	Of type Duration, represents the current duration of the playlist.
	*/
	
	// -------------	Constructor		------------- //
	public PublicPlaylist(String name, Duration duration) {
		super(name, duration);
		rating = new Double[10];
	}
	// ------------------------------------------------
	
	// -------------	Methods		------------- //
	public double getRating(){
		int counter = 0;
		double sum = 0;
		for (int i = 0; i < rating.length; i++) {
			if (rating[i] != null) {
				counter++;
				sum += rating[i];
			}
		}
		return (sum/counter);
	}
	
	/**
	* Adds a new rating to the playlist.<br>
	* pre: newRating must be greater than 0<br>
	* pos: The first null position of the rating array will be replaced by the newRating.<br>
	* @param newRating.	double, added to the rating array.
	*/
	
	public void addRating(double newRating) {
		boolean isNull = false;
		for (int i = 0; i < rating.length && !isNull; i++) {
			if (rating[i] == null) {
				rating[i] = newRating;
				isNull = true;
			}
		}
	}
	
	/**
	* Creates and returns a message with the playlist information.<br>
	* pre: <br>
	* pos: <br>
	* @return message.	Contains the information of the playlist.
	*/
	
	@Override
	public String toString() {
		String message = super.toString() + "\n" +
		"**  Calificacion: " + getRating() + "\n" + 
		"***************************************\n";
		return message;
	}
	// ------------------------------------------------
}

