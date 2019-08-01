package com.excilys.training.jdbc;
import java.sql.Connection;
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
	    private ConnectionMySQL() {}
		/**
		 * Méthode qui va nous retourner notre instance
		 * et la créer si elle n'existe pas.
		 * @return 
		 * @throws SQLException 
		 */
		public static Connection getInstance() throws SQLException{
			return ds.getConnection();	
		}

}
