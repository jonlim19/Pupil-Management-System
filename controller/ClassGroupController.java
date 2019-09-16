package controller;

import javamysql.ClassGroupData;
import model.ClassGroup;
/*Controller class for managing the database for class groups*/
public class ClassGroupController {
	private ClassGroup classgroup;
	private String classcode;
	private String subject;
	private ClassGroupData classdata;
	public ClassGroupController() {
		// TODO Auto-generated constructor stub
		classdata = new ClassGroupData();
	}
	
	public void createClassGroup(String code,String course) {
		classcode = code;
		subject = course;
		
		classgroup = new ClassGroup(classcode,subject);
		classdata.createClassGroup(classgroup);
	}
	
	public void removeClassGroup(String c) {

		classdata.removeClassGroup(c);
	}
	
	public String listoutClassGroups() {

		return classdata.listClassGroup();
	}
}
