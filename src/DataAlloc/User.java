package DataAlloc;

public class User implements Comparable<User> {
	private String username;
	private Integer[] animeList;
	private int[] eps;
	private double[] scores;
	
	public User(String username, Integer[] animeList, int[] eps, double[] scores){
		this.username = username;
		this.animeList = animeList;
		this.eps = eps;
		this.scores = scores;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public Integer[] getAnimeList() {
		return this.animeList;
	}
	
	public double getScores(int key) {
		return this.scores[key];            //needs modification
	}
	
	public int compareTo(User that) {
		int k = 0;                     //represents intended anime
		if (this.getScores(k) > that.getScores(k))
			return 1;
		
		else if (that.getScores(k) == this.getScores(k)) {
			if (this.getUsername().compareTo(that.getUsername()) > 0)
				return 1;
			else if (this.getUsername().compareTo(that.getUsername()) < 0)
				return -1;
			return 0;
		}
		return -1;
	}
}
