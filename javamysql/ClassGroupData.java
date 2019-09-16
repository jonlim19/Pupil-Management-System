package javamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.ClassGroup;

public class ClassGroupData extends DatabasePersistence{

	public ClassGroupData() {
		// TODO Auto-generated constructor stub
		super();
	}

	public void createClassGroup(ClassGroup cg) {
		String insertSQL = "INSERT INTO Classgroup(classGroup,coursename) VALUES(?,?)";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pupilmanagement?user=root&password=" );
			PreparedStatement insertStmt = con.prepareStatement(insertSQL);
			insertStmt.setString(1, cg.getClasscode());
			insertStmt.setString(2, cg.getSubject());
			insertStmt.executeUpdate();
			System.out.println("Added");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void removeClassGroup(String cc) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pupilmanagement?user=root&password=" );
			String deleteRecord = "DELETE FROM Classgroup WHERE classGroup='"+cc+"'";
			Statement deleteStmt = con.createStatement();
			deleteStmt.executeUpdate(deleteRecord);
			System.out.println("Deleted");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public String listClassGroup() {
		String res = "";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pupilmanagement?user=root&password=" );
			String getRecord = "SELECT * FROM Classgroup";
			Statement getStmt = con.createStatement();
			ResultSet rs = getStmt.executeQuery(getRecord);
			while (rs.next ())
			{
				String classgroupVal = rs.getString ("classGroup");
				String coursenameVal = rs.getString ("coursename");
				res += classgroupVal + "," + coursenameVal;
			}
			System.out.println("Data fetched");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return res;
	}
}
