package DataAlloc;

public class Users {
	private String username;
	private String[] animeList;
	private int[] eps;
	private double[] scores;
	
	public Users(String username, String[] animeList, int[] eps, double[] scores){
		this.username = username;
		this.animeList = animeList;
		this.eps = eps;
		this.scores = scores;
	}	
}
