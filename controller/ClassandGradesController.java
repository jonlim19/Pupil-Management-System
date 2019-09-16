package controller;

import javamysql.ClassandGradesData;
/*Controller class for managing the database for student grades according to student grades and classgroups*/
public class ClassandGradesController {
	private ClassandGradesData database;
	public ClassandGradesController() {
		// TODO Auto-generated constructor stub
		database = new ClassandGradesData();
	}
	
	public void addtoDatabase(String id, String ema, String clgr, String modcode, String grade) {
		database.insertRecord(id, ema, clgr, modcode, grade);
	}
	
	public String listStudentsbyClass(String cc) {

		return database.listStudentsinClass(cc);
	}
	
	public void editMarks(String email,String mod, String v) {
		database.updateGrades(email,mod, v);
	}
}
