package javamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import model.ModuleGrade;
import model.Teacher;

public class ModuleGradeData extends DatabasePersistence{

	public ModuleGradeData() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public void insertModuleGradetoDatabase(ModuleGrade mg) {
		String insertSQL = "INSERT INTO Modulegrade(modulecode,modulename) VALUES(?,?)";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pupilmanagement?user=root&password=" );
			PreparedStatement insertStmt = con.prepareStatement(insertSQL);
			insertStmt.setString(1, mg.getModulecode());
			insertStmt.setString(2, mg.getModulename());
			insertStmt.executeUpdate();
			System.out.println("Added");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void removeModuleGradefromDatabase(String code) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pupilmanagement?user=root&password=" );
			String deleteRecord = "DELETE FROM Modulegrade WHERE modulecode='"+code+"'";
			Statement deleteStmt = con.createStatement();
			deleteStmt.executeUpdate(deleteRecord);
			System.out.println("Deleted");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
