package DataAlloc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginAccount {

	private String user;
	private String password;

	// Don't worry about this the password and user name is ALWAYS stored locally
	public LoginAccount(String fileName) throws FileNotFoundException {

		File f = new File(fileName);
		Scanner s = new Scanner(f);

		String output = s.nextLine();

		String[] info = output.split(" ");

		this.user = info[0];
		this.password = info[1];

		s.close();
	}

	// This checks if the typed user name and password match
	public boolean check(String inputUser, String inputPass) {

		if (inputUser.equals(this.user)) { // Condition input should come from front end
			
			if (inputPass.equals(this.password)) { // Condition input should come from front end
				System.out.println("Successful login!");
				return true;
			}

			else {
				System.out.println("Password is Incorrect!"); // Type password again!
				return false;
			}
		} 
		
		else {
			System.out.println("Username/Password is Incorrect!"); // Type password again!
			return false;
		}

	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		LoginAccount akila = new LoginAccount("Data/userAndPass.txt");
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Type in username");
		String user = input.next();
		System.out.println("Type in password");
		String password = input.next();
		
		input.close();
		
		akila.check(user, password);
	}

}