package javamysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.Student;

import java.sql.ResultSet;
public class InsertStudent extends DatabasePersistence{

	public InsertStudent() {
		// TODO Auto-generated constructor stub
		super();
	}

	public void insertStudenttoDatabase(Student s) {
		System.out.println("Insert into Student values ('"+s.getEmail()+"', '"+s.getName().getFirstName()+"', '"+s.getName().getMiddleName()+"', '"+s.getName().getLastName()+"','"+s.getDateofbirth()+"','"+s.getPhoneno()+"');");
		String insertSQL = "INSERT INTO Student(email,firstname,middlename,lastname,DOB,telNo) VALUES(?,?,?,?,?,?)";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pupilmanagement?user=root&password=" );
			PreparedStatement insertStmt = con.prepareStatement(insertSQL);
			insertStmt.setString(1, s.getEmail());
			insertStmt.setString(2, s.getName().getFirstName());
			insertStmt.setString(3, s.getName().getMiddleName());
			insertStmt.setString(4, s.getName().getLastName());
			insertStmt.setString(5, Integer.toString(s.getDateofbirth()));
			insertStmt.setString(6, Integer.toString(s.getPhoneno()));

			insertStmt.executeUpdate();
			System.out.println("Added");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void removeStudentfromDatabase(String email) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pupilmanagement?user=root&password=" );
			String deleteRecord = "DELETE FROM Student WHERE email='"+email+"'";
			Statement deleteStmt = con.createStatement();
			deleteStmt.executeUpdate(deleteRecord);
			System.out.println("Deleted");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public String listStudents() {
		String res = "";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pupilmanagement?user=root&password=" );
			String getRecord = "SELECT * FROM Student";
			Statement getStmt = con.createStatement();
			ResultSet rs = getStmt.executeQuery(getRecord);
			
			while (rs.next ())
			{
				String stuEmailVal = rs.getString ("email");
				String stufNameVal = rs.getString ("firstname");
				String stumNameVal = rs.getString ("middlename");
				String stulNameVal = rs.getString ("lastname");
				String stulDOBVal = rs.getString ("DOB");
				String stuTelVal = rs.getString("telNo");
				res += stuEmailVal + "," + stufNameVal + "," + stumNameVal + "," + stulNameVal + "," + stulDOBVal + "," + stuTelVal;
			}
			System.out.println("Data fetched");
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return res;
	}

	public void listfromClassGroup(String code) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pupilmanagement?user=root&password=" );
			String getRecord = "SELECT * FROM Student WHERE classGroup='"+code+"' ORDER BY firstname ASC";
			Statement getStmt = con.createStatement();
			getStmt.executeUpdate(getRecord);
			System.out.println("Data fetched");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
