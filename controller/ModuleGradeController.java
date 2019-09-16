package controller;

import javamysql.ModuleGradeData;
import model.ModuleGrade;

public class ModuleGradeController {
	private ModuleGradeData database;
	private ModuleGrade subject;
	private String modulecode;
	private String module;
	private int grade;
	public ModuleGradeController() {
		// TODO Auto-generated constructor stub
		database = new ModuleGradeData();
	}
	
	public void addModule(String modcode,String mod, String mark) {
		grade = Integer.parseInt(mark);
		module = mod;
		modulecode = modcode;
		subject = new ModuleGrade(modulecode,module,grade);
		database.insertModuleGradetoDatabase(subject);
	}
	
	public void removeModule(String code) {
		
		database.removeModuleGradefromDatabase(code);
	}
	
	
}
