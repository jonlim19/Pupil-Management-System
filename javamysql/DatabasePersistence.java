/*
 * RunDB.java
 *
 * 
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package javamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 *
 * @author Jonathan Lim
 */
public class DatabasePersistence {

	/** Creates a new instance of RunDB */
	public DatabasePersistence() {
	}

	/**
	 * @param args the command line arguments
	 */
	public void startupDatabase() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pupilmanagement?user=root&password=" );
			System.out.println ("Database connection established");
			Statement s = con.createStatement ();



		}catch (Exception ex) {
			System.out.println("SQLException: " + ex.getMessage());

		};

	}

}
