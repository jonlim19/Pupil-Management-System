package controller;

import javamysql.InsertStudent;
import model.ClassGroup;
import model.Student;
/*Controller class for managing the database for the student details*/
public class StudentMainController {
	private String firstname;
	private String middlename;
	private String lastname;
	private String emailadd;
	private int dateofbirth;
	private int phoneno;
	private Student student;
	private String classcode;
	private String subject;
	private ClassGroup classgroup;
	private InsertStudent insert;
	public StudentMainController() {
		// TODO Auto-generated constructor stub
		insert = new InsertStudent();
	}
	
	public void addStudent(String finame,String miname,String laname,String email,String dob,String phone) {
		System.out.println("--------------------------------------------------------------------------------------------");
		firstname = finame;
		middlename = miname;
		lastname = laname;
		emailadd = email;
		dateofbirth = Integer.parseInt(dob);
		phoneno = Integer.parseInt(phone);
		student = new Student(dateofbirth,emailadd,phoneno,firstname,middlename,lastname);
		classgroup = new ClassGroup(classcode,subject);
		classgroup.addStudent(student);
		insert.insertStudenttoDatabase(student);
	}
	
	public void removeStudent(String d) {

		classgroup.removeStudentbyemail(d);
		insert.removeStudentfromDatabase(d);
	}
	
	public String listStudent() {
		String res = "";
		res += insert.listStudents();
		return res;
	}
	
	
}
