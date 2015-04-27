package com.crunchify.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionMySQL {
	public static void main(String args[]){
		 // ConnectionMySQL connect = null;
		   Statement statement = null;
		   PreparedStatement preparedStatement = null;
		   ResultSet resultSet = null;
		try {
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
//		      connect = (Connection) DriverManager
//		          .getConnection("jdbc:mysql:?"
//		              + "user=sagar&password=passw0rd@123");
		      
		      Connection connection = DriverManager
		    		    .getConnection("jdbc:mysql://dotdb.cjv7q1dufrst.us-east-1.rds.amazonaws.com:3306", "sagar", "passw0rd123");
		      System.out.println("connection successful");
		      statement = connection.createStatement();
		      // Result set get the result of the SQL query
		      resultSet = statement
		          .executeQuery("SELECT * FROM instdot.oilconsumebycountry");
		      writeResultSet(resultSet);
		     
		}catch(Exception e){
			
			System.out.println("exception : "+e);
		}
		
		
	}
	 public static void writeResultSet(ResultSet resultSet) throws SQLException {
		    // ResultSet is initially before the first data set
		    while (resultSet.next()) {
		      // It is possible to get the columns via name
		      // also possible to get the columns via the column number
		      // which starts at 1
		      // e.g. resultSet.getSTring(2);
		      String user = resultSet.getString("Region");
		      String website = resultSet.getString("Country");
//		      String summery = resultSet.getString("summery");
//		      Date date = resultSet.getDate("datum");
//		      String comment = resultSet.getString("comments");
		      System.out.println("User: " + user);
		      System.out.println("Website: " + website);
//		      System.out.println("Summery: " + summery);
//		      System.out.println("Date: " + date);
//		      System.out.println("Comment: " + comment);
}
		  }
	
	
	
}
