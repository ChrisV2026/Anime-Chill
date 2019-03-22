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
		add_data(user, ID, eps, score);
		show_data(field);
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
			System.out.println("Already in database, update entry instead");
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
				String command = "update users set " + field + " = " + newval + "where username = '" + username + "'";
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
