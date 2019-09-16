package javamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.ClassGroup;
import model.Student;
import model.Teacher;

public class TeacherData extends DatabasePersistence{

	public TeacherData() {
		// TODO Auto-generated constructor stub
		super();
	}

	public void insertTeachertoDatabase(Teacher t) {
		System.out.println("Insert into Teacher values ('"+t.getEmail()+"', '"+t.getName().getFirstName()+"', '"+t.getName().getMiddleName()+"', '"+t.getName().getLastName()+"','"+t.getPhoneno()+"', '"+t.getQualification()+"');");
		String insertSQL = "INSERT INTO Teacher(teacheremail,firstname,middlename,lastname,telNo,qualification) VALUES(?,?,?,?,?,?)";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pupilmanagement?user=root&password=" );
			PreparedStatement insertStmt = con.prepareStatement(insertSQL);
			insertStmt.setString(1, t.getEmail());
			insertStmt.setString(2, t.getName().getFirstName());
			insertStmt.setString(3, t.getName().getMiddleName());
			insertStmt.setString(4, t.getName().getLastName());
			insertStmt.setString(5, Integer.toString(t.getPhoneno()));
			insertStmt.setString(6, t.getQualification());
			insertStmt.executeUpdate();
			System.out.println("Added");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public void removeTeacherfromDatabase(String email) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pupilmanagement?user=root&password=" );
			String deleteRecord = "DELETE FROM Teacher WHERE email='"+email+"'";
			Statement deleteStmt = con.createStatement();
			deleteStmt.executeUpdate(deleteRecord);
			System.out.println("Deleted");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public String listTeachers() {
		String res = "";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pupilmanagement?user=root&password=" );
			String getRecord = "SELECT * FROM Teacher";
			Statement getStmt = con.createStatement();
			ResultSet rs = getStmt.executeQuery(getRecord);
			while(rs.next()){
				String teaEmailVal = rs.getString ("teacheremail");
				String teafNameVal = rs.getString ("firstname");
				String teamNameVal = rs.getString ("middlename");
				String tealNameVal = rs.getString ("lastname");
				String teaTelVal = rs.getString("telNo");
				String teaqualificationVal = rs.getString ("qualification");
				res += teaEmailVal + "," + teafNameVal + "," + teamNameVal + "," + tealNameVal + "," + teaTelVal + "," + teaqualificationVal;
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return res;
	}
	
	public void editDegree(String d,String e) {
		try {
            //update
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pupilmanagement?user=root&password=" );
			Statement updateStmt = con.createStatement();
            String updateSQL = " Update Teacher set qualification = '" + d + "' where teacheremail ='" + e + "'";//update customer with id C002 country to Malaysia
            updateStmt.executeUpdate(updateSQL);
            System.out.println("Update complete");
            // You May need to uncomment if Autocommit is not set
            //con.commit();
       }catch (Exception io) {
                System.out.println("error"+io);
       };   
	}
}
