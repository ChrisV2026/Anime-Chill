package DataAlloc;

public class Anime {
	private String genre;
	private String[] users;
	private int animeID;
	
	public Anime(int animeID, String genre, String[] users) {
		this.animeID = animeID;
		this.genre = genre;
		this.users = users;
	}
}
