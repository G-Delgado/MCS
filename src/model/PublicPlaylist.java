package model;


/*
	ESTOY PONIENDO "Double"    en vez de   "double"
*/
public class PublicPlaylist extends Playlist {
	Double[] rating;
	
	public PublicPlaylist(String name, Duration duration) {
		super(name, duration);
		rating = new Double[10];
	}
	
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
	*
	*
	*
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
	*
	*
	*
	*/
	
	@Override
	public String toString() {
		return super.toString() + "\n" +
		"**  Calificacion: " + getRating() + "\n" + 
		"***************************************\n";
	}
		
}

