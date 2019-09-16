package javamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/*This class is used to interact with the database in SQLWorkbench
where the grades of a particular module of a student is stored*/
public class ClassandGradesData extends DatabasePersistence{

	public ClassandGradesData() {
		// TODO Auto-generated constructor stub
		super();
	}
	/*This function executes an INSERT command in SQL workbench to enter a students mark in a module*/
	public void insertRecord(String id, String email, String cg, String mc, String mark) {
		String insertSQL = "INSERT INTO Classandgrades(id,email,classGroup,modulecode,grade) VALUES(?,?,?,?,?)";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pupilmanagement?user=root&password=" );
			PreparedStatement insertStmt = con.prepareStatement(insertSQL);
			insertStmt.setString(1, id);
			insertStmt.setString(2, email);
			insertStmt.setString(3, cg);
			insertStmt.setString(4, mc);
			insertStmt.setInt(5, Integer.parseInt(mark));

			insertStmt.executeUpdate();
			System.out.println("Added");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/*Executes a SELECT statement in SQLWorkbench to view all students in a certain class group*/
	public String listStudentsinClass(String classc) {
		String res = "";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pupilmanagement?user=root&password=" );
			String getRecord = "select * from Student where email in(select email from Classandgrades where classGroup='"+classc+"')order by firstname asc;";
			Statement getStmt = con.createStatement();
			ResultSet rs = getStmt.executeQuery(getRecord);
			while(rs.next()){
				String stuEmailVal = rs.getString ("email");
				String stufNameVal = rs.getString ("firstname");
				String stumNameVal = rs.getString ("middlename");
				String stulNameVal = rs.getString ("lastname");
				String stulDOBVal = rs.getString ("DOB");
				String stuTelVal = rs.getString("telNo");
				res += stuEmailVal + "," + stufNameVal + "," + stumNameVal + "," + stulNameVal + "," + stulDOBVal + "," + stuTelVal;
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return res;
	}
	/*Executes an UPDATE statement in SQL Workbench to update the grade of a certain student*/
	public void updateGrades(String email,String modcode,String val) {
		try {
            //update
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pupilmanagement?user=root&password=" );
			Statement updateStmt = con.createStatement();
            String updateSQL = " Update Classandgrades set grade = '" + val + "' where modulecode ='" + modcode + "' and email='"+email+"'";
            updateStmt.executeUpdate(updateSQL);
            System.out.println("Update complete");
       }catch (Exception io) {
                System.out.println("error"+io);
       };   
	}
}
