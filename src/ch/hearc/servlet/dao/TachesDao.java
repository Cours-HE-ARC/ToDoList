package ch.hearc.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch.hearc.servlet.model.Tache;

public class TachesDao {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "toor";
	private static final String URL = "jdbc:mysql://localhost:3306/taches";
	
	
	private static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			
			connection = DriverManager.getConnection(URL,  USERNAME, PASSWORD);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return connection;

	}

	public Tache saveTaches(Tache tache){
		
		
		
		try {
			
			String insertTableSQL = "INSERT INTO taches"
					+ "(description, due_date) VALUES"
					+ "(?,?)";
			
			PreparedStatement preparedStatement = getConnection().prepareStatement(insertTableSQL);
			preparedStatement.setString(1,tache.getDescription());
			preparedStatement.setString(2, tache.getDueDate());
			
			preparedStatement .executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public List<Tache> getAllTaches(){
		
		List<Tache> taches = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement("select * from taches");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			while(resultSet.next()) {
				String description = resultSet.getString("description");
				String dueDate = resultSet.getString("due_date");
				taches.add(new Tache(description,dueDate));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return taches;
		
	}
}
