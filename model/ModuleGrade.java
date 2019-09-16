package model;

public class ModuleGrade {
	private String modulename;
	private String modulecode;
	private int grade;

	public ModuleGrade(String modcode,String modname,int result) {
		// TODO Auto-generated constructor stub
		modulecode = modcode;
		modulename = modname;
		grade = result;
	}

	public String getModulecode() {

		return modulecode;
	}

	public void setModulecode(String modulecode) {

		this.modulecode = modulecode;
	}

	public String getModulename() {

		return modulename;
	}

	public void setModulename(String modulename) {

		this.modulename = modulename;
	}

	public int getGrade() {

		return grade;
	}

	public void setGrade(int grade) {

		this.grade = grade;
	}
	

}
