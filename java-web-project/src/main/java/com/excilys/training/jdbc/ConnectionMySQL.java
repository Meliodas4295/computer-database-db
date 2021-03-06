package com.excilys.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionMySQL {
	
	private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
 
    static {
        config.setJdbcUrl( "jdbc:mysql://localhost:3306/computer-database-db" );
        config.setUsername( "admincdb" );
        config.setPassword( "qwerty1234" );
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }
 
	//private static String url = "jdbc:mysql://localhost:3306/computer-database-db";
	private static String url = "jdbc:mysql://localhost:3306/computer-database-db";
 
	//private static String url = "jdbc:mysql://localhost:3306/computer-database-db";
	/**
	 * Nom du user
	 */
	//private static String user = "admincdb";
	/**
	 * Mot de passe du user
	 */
	//private static String passwd = "qwerty1234";
	/**
	 * Driver
	 */
	//private static String driver = "com.mysql.cj.jdbc.Driver";
	/**
	 * Objet Connection
	 */

    private ConnectionMySQL() {}
	private static Connection connect;

	//private static Connection connect;
    private ConnectionMySQL() {}
	/**
	 * Méthode qui va nous retourner notre instance
	 * et la créer si elle n'existe pas.
	 * @return 
	 * @throws SQLException 
	 */
	}
	/*
	public static Connection getInstance2() throws SQLException{
		try {
			Class.forName("org.h2.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connexion = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test;DB_CLOSE_ON_EXIT=FALSE", "root",  "YourName3014");
		return connexion;
	}
	**/
	public static void close() throws SQLException  {
        if(ds.getConnection()!=null) {
         
            try {
                ds.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
 
        }
    }
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
	public static Connection getInstance() throws SQLException{
		return ds.getConnection();	
	}
}