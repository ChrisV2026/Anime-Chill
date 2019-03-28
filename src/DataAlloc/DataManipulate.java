package DataAlloc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataManipulate {
	public static void main(String[] args) {
		String user = "Chris";
		String ID = "1";
		String eps = "100";
		String score = "10";
		String field = "username";
		//System.out.println(retrieve_data("Chris", "animeID"));
		add_data(user, ID, eps, score);
		//show_data(field);
	}
	
	public static String retrieve_data(String username, String field) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = null;
		connection = obj_DB_Connection.get_connection();
		String entry = null;
		
		PreparedStatement ps = null;
		try {
			String query = "select * from users where username = " + "'" + username + "'";
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			entry = rs.getString(field);
			connection.close();
			return entry;

		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		return entry;
	}
	
	public static void show_data(String field) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = null;
		connection = obj_DB_Connection.get_connection();
		
		PreparedStatement ps = null;
		try {
			String query = "select * from users";
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Users - " + rs.getString(field));
			}
			connection.close();
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static boolean check_data(String name, String field) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = null;
		connection = obj_DB_Connection.get_connection();
		
		PreparedStatement ps = null;
		try {
			String query = "select * from users";
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String entry = rs.getString(field);
				if (name.equals(entry)) {
					connection.close();
					return true;
				}
				
			}
			connection.close();
			return false;
		}
		
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	
	public static void add_data(String username, String animeID, String episodes, String score) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = null;
		connection = obj_DB_Connection.get_connection();
		boolean is_used = check_data(username, "username");
		if (is_used) {
			String ID = retrieve_data(username, "animeID");
			String eps = retrieve_data(username, "episodes");
			String sc = retrieve_data(username, "score");
			
			if(!(animeID.equals(ID) && episodes.equals(eps) && score.equals(sc))) {
				update_data(username, "animeID", animeID + " " + ID);
				update_data(username, "episodes", episodes+ " " + eps);
				update_data(username, "score", score+ " " + sc);
			}
			return;
		}
		else {
			String values = "Values('" + username + "', '" + animeID + "', '" + episodes + "', '" + score + "')";
			
			
			PreparedStatement ps = null;
			try {
				String command = "insert into users(username, animeID, episodes, score)";
				String statement = command + values;
				ps = connection.prepareStatement(statement);
				ps.execute();
				connection.close();
			}
			
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public static void update_data(String username, String field, String newval) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = null;
		connection = obj_DB_Connection.get_connection();
		boolean is_used = check_data(username, "username");
		if (is_used) {
			PreparedStatement ps = null;
			try {
				String command = "update users set " + field + " = " + "'" + newval + "'"; 
			    String command2 = " where username = '" + username + "'";
			    command = command + command2;
				ps = connection.prepareStatement(command);
				ps.execute();
				connection.close();
			}
			
			catch(Exception e) {
				System.out.println(e);
			}
		}
		
		else
			System.out.println("Must add user before being able to update it");
	}
	
}
