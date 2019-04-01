package DataAlloc;

import java.util.Scanner;

public class User {
	private String username; // User name
	private Integer[] animeList; // List of ANIMES watched by user
	private int[] eps; // List of episodes watched per ANIME corresponding to animeList
	private double[] scores; // List of scores given by user per ANIME corresponding to animeList

	private String[] friends = new String[200]; // Users accepted friends
	private int count = 0; // Keeps tracks of how many friends are in "friends"
	private String location;

	private User[] potMat = new User[4]; // Randomly filled potential mates

	public User(String username, Integer[] animeList, int[] eps, double[] scores, String location) {
		this.username = username;
		this.animeList = animeList;
		this.eps = eps;
		this.scores = scores;
		this.location = location;
	}

	public void fillPotential() {

		Integer[] animeList = { 5, 1, 2, 3, 4 };
		int[] eps = { 1, 2, 4, 3, 2 };
		double[] scores = { 5.0, 2.0, 3.0, 1.0, 7.0 };

		User akila = new User("akila", animeList, eps, scores);

		Integer[] animeList1 = { 5, 1, 2, 4, 5 };
		int[] eps1 = { 1, 2, 4, 3, 5 };
		double[] scores1 = { 2.0, 6.0, 3.1, 5.0, 1.5 };

		User eric = new User("yehhh", animeList1, eps1, scores1);

		Integer[] insAnimes = { 5, 2, 4, 3, 1 };
		int[] insEps = { 12, 234, 97, 82, 72 };
		double[] insScores = { 8.3, 9.4, 4.2, 9.5, 3.7 };

		User oleg = new User("oleg", insAnimes, insEps, insScores);

		Integer[] insAnimes1 = { 5, 2, 4, 3, 1 };
		int[] insEps1 = { 672, 40, 273, 38, 38 };
		double[] insScores1 = { 9.2, 8.5, 3.7, 7.9, 8.2 };

		User billy = new User("billy", insAnimes1, insEps1, insScores1);

		this.potMat[0] = billy;
		this.potMat[1] = eric;
		this.potMat[2] = oleg;
		this.potMat[3] = akila;

//		for(int i = 0; i < this.potMat.length; i++) {
//			this.potMat[i] = ## INSERT RANDOM USER ##;
//		}
		sort();
	}

	private void sort() {

		// Trying to sort potMat by the scores received by compareUser

		for (int i = 1; i < this.potMat.length; i++) {
			for (int j = i; j > 0; j--) {
				if (this.compareUser(this.potMat[j]) < this.compareUser(this.potMat[j - 1])) {
					User temp = this.potMat[j];
					this.potMat[j] = this.potMat[j - 1];
					this.potMat[j - 1] = temp;
				} else
					break;
			}
		}
	}

	public double compareUser(User that) {

		double totalDifference = 0.0;
		Integer[] thatAnimeList = that.getAnimeList();
		double[] thatScores = that.getScores();

		for (int i = 0; i < this.animeList.length; i++) {
			for (int j = 0; j < thatAnimeList.length; j++) {
				if (this.animeList[i] == thatAnimeList[j])
					totalDifference += Math.abs((this.scores[i] - thatScores[j]));
			}
		}
		return Math.abs(totalDifference);
	}

	public String getUser() {
		return this.username;
	}
	
	public String[] getFriends() {
		return this.friends;
	}

	public Integer[] getAnimeList() {
		return this.animeList;
	}

	public double[] getScores() {
		return this.scores;
	}

	public User[] getPotMat() {
		return this.potMat;
	}
	
	public void swipe() {
		
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i < this.potMat.length; i++) {
			
			System.out.println("Information: " + potMat[i].getUser());
			
			System.out.println("Do you like this person? 1 for Y/2 for N");
			int number = input.nextInt();
			
			if(number == 1) {
				this.friends[this.count] = this.potMat[i].getUser();
				this.count++;
			}
		}
		
		input.close();
		
	}

	public static void main(String[] args) {

		Integer[] animeList1 = { 1, 2, 3, 4, 5 };
		int[] eps1 = { 4, 2, 7, 5, 6 };
		double[] scores1 = { 4.0, 2.0, 7.0, 2.0, 3.0 };

		User yo = new User("yo", animeList1, eps1, scores1);

		yo.fillPotential();

		String[] hello = yo.getFriends();
		
		yo.swipe();

		for (int i = 0; i < hello.length; i++) {
			if (hello[i] != null)
				System.out.println(hello[i]);
		}

	}
}
