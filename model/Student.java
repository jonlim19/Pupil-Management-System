package model;

public class Student extends Person{
	int dateofbirth;
	int numberofmodules;
	ModuleGrade module[];

	public Student(int dob, String mail, int phone, String fn, String mn, String ln) {
		// TODO Auto-generated constructor stub
		super(mail,phone,fn,mn,ln);
		module = new ModuleGrade[6];
		dateofbirth = dob;
	}
	
	public int getDateofbirth() {

		return dateofbirth;
	}

	public void setDateofbirth(int dateofbirth) {

		this.dateofbirth = dateofbirth;
	}

	public void getModules() {
		for(int i = 0; i < numberofmodules;i++) {
			System.out.println(module[i].getModulename() + "," + module[i].getGrade());
		}
	}
	
	public void enrolSubject(ModuleGrade subject) {
	
		if(numberofmodules<=module.length) {
			module[numberofmodules] = subject;
			numberofmodules++;
		}else {
			System.out.println("You can only enrol in 6 modules");
			
		}
		
	}
	
	public void dropSubject(ModuleGrade subject) {
		for(int i = 0;i<module.length;i++) {
			if(subject==module[i]) {
				module[i]=null;
			}else {
				System.out.println("You are not currently enrolled in this module");
			}
		}
	}
	
	public void setMark(ModuleGrade mod,int mark) {
		for(int i =0; i < module.length;i++) {
			if(mod==module[i]) {
				module[i].setGrade(mark);
			}else {
				System.out.println("Module does not exist");
			}
		}
	}
}
