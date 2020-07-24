package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



import com.mysql.jdbc.Connection;

public class Db {
	
	private static Connection conn = null;
	
	private static Properties loadProperties() {
		
		try(FileInputStream fs = new FileInputStream("db.properties")){
			
			Properties props = new Properties();
			props.load(fs);
			
			return props;
		}catch(IOException e) {
			throw new DbException (e.getMessage());
			
		}
		
	}
	
	public static Connection getConnection() {
		
		if(conn == null) {
			
			try {
			Properties props = loadProperties();
			String url = props.getProperty("dburl");
			conn = (Connection) DriverManager.getConnection(url, props);
			}
			catch(SQLException erro) {
				throw new DbException (erro.getMessage());
				
			}
			
		}
		return conn;
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				
			conn.close();
			
			}
			catch(SQLException erro){
				
				throw new DbException (erro.getMessage());
			}
		}
		
	}

}
