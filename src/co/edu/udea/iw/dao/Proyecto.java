package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import co.edu.udea.iw.util.MyException;

/**
 * 
 * @author CamiGomez318
 * @version 1
 */
class Proyecto {

	//Variables 
	Logger log = Logger.getLogger(this.getClass());

	/**
	 * Connection with data base
	 * 
	 * @return  
	 */
	public Connection getConnection() throws MyException{
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clase", "root" ,"");
			
		} catch (ClassNotFoundException e) {
			log.error(e);
			throw new MyException(e); 
		}catch(SQLException e){
			log.error(e);
			throw new MyException(e); 
		}finally {
			
			
		}
		return con;
	}
}



