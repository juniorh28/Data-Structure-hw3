//Junior Hernandez
public class Movie {//Node class
	private String title;
	private int releaseYear;
	private String[] genres;
	private int movieId;
	Movie leftChild;
	Movie rightChild;
	
	
	public void setTitle(String title) {this.title = title;}
	public void setReleaseYear(int releaseYear) {this.releaseYear = releaseYear;}
	public void setGenres(String[] genres) {this.genres = genres;}
	public void setMovieId(int movieId) {this.movieId = movieId;}
	public String getTitle() {return title;}
	public int getReleaseYear() {return releaseYear;}
	public String[] genres() {return genres;}
	public int getMovieId() {return movieId;}
	
	public Movie() {}
	public Movie(int movieId, String title, int releaseYear, String[] genres) {
		this.movieId = movieId;
		this.releaseYear = releaseYear;
		this.genres = genres;
		this.title = title;
	}
	public String toString() {return "movie Id: "+movieId+" title: "+title+" genres: "+genres;}
}
