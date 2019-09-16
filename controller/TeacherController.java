package controller;

import javamysql.TeacherData;
import model.Teacher;
/*Controller class for managing the teacher details*/
public class TeacherController {
	private String firstname;
	private String middlename;
	private String lastname;
	private String emailadd;
	private int phoneno;
	private String qualification;
	private Teacher teacher;
	private TeacherData teacherdata;
	public TeacherController() {
		// TODO Auto-generated constructor stub
		teacherdata = new TeacherData();
	}
	
	public void addTeacher(String fname,String mname,String lname,String phnum,String qual,String mail) {
		firstname = fname;
		middlename = mname;
		lastname = lname;
		emailadd = mail;
		phoneno = Integer.parseInt(phnum);
		qualification = qual;
		teacher = new Teacher(qualification,emailadd,phoneno,firstname,middlename,lastname);
		teacherdata.insertTeachertoDatabase(teacher);
	}
	
	public void removeTeacher(String e) {
		teacherdata.removeTeacherfromDatabase(e);
	}
	
	public String listTeachers() {
		return teacherdata.listTeachers();
	}
	
	public void editQual(String de, String em) {
		teacherdata.editDegree(de, em);
	}
}
