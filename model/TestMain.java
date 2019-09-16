package model;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModuleGrade m1 = new ModuleGrade("SOFT6005","Linear Algorithms",87);
		ModuleGrade m2 = new ModuleGrade("SOFT4876","Java Programming",50);
		ModuleGrade m3 = new ModuleGrade("SOFT2231", "C++ Programming",90);
		
		Student s1 = new Student(1998, "dylan.murphy@mycit.ie", 875563232, "Dylan", "Brendan", "Murphy");
		Student s2 = new Student(1998, "qiyan.tan@mycit.ie", 876563637, "Xara", "QiYan", "Tan");
		Student s3 = new Student(1997, "loqyan.tan@mycit.ie", 894564337, "Edwin", "LoqYan", "Tan" );
		Student s4 = new Student(1998, "thomas.edison@mycit.ie", 875563232, "Thomas", "Park", "Edison");
		Student s5 = new Student(1998, "leslie.fu@mycit.ie", 876563637, "Leslie", "Fuslie", "Fu");
		Student s6 = new Student(1997, "eddie.chee@mycit.ie", 894564337, "Eddie", "Edith", "Chee" );
		
		s1.enrolSubject(m1);
		s1.enrolSubject(m2);
		s1.enrolSubject(m3);
		s2.enrolSubject(m1);
		s2.enrolSubject(m3);
		ClassGroup comp1bx = new ClassGroup("COMP1-BX","Software Developement");
		ClassGroup comp1by = new ClassGroup("COMP1-BY","Computer Systems");
		
		comp1bx.addStudent(s1);
		comp1bx.addStudent(s2);
		comp1bx.addStudent(s3);
		comp1by.addStudent(s4);
		comp1by.addStudent(s5);
		comp1by.addStudent(s6);
		
		s1.getModules();
		comp1by.viewStudentlist();
	}

}
