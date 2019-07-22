package com.excilys.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
	private static String url = "jdbc:mysql://localhost:3306/computer-database-db";
	/**
	 * Nom du user
	 */
	private static String user = "admincdb";
	/**
	 * Mot de passe du user
	 */
	private static String passwd = "qwerty1234";
	/**
	 * Driver
	 */
	private static String driver = "com.mysql.cj.jdbc.Driver";
	/**
	 * Objet Connection
	 */
	private static Connection connect;
	
	/**
	 * Méthode qui va nous retourner notre instance
	 * et la créer si elle n'existe pas...
	 * @return 
	 */
	public static Connection getInstance(){
		if(connect == null){
			try {
				Class.forName(driver);
				connect = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return connect;	
	}	
}