package model;

import java.util.ArrayList;

public class ClassGroup {
	private ArrayList<Student> students;
	private String classcode;
	private String subject;

	public ClassGroup(String cc,String sub) {
		// TODO Auto-generated constructor stub
		students = new ArrayList<Student>();
		classcode = cc;
		subject = sub;
	}

	public String getSubject() {

		return subject;
	}

	public void setSubject(String subject) {

		this.subject = subject;
	}

	public String getClasscode() {

		return classcode;
	}

	public void setClasscode(String classcode) {

		this.classcode = classcode;
	}

	public void addStudent(Student s) {

		students.add(s);
	}

	public void removeStudentbyemail(String n) {
		for(int i=0;i<students.size();i++) {
			System.out.println(students.size());
			Student candidate = students.get(i);
			if(n==candidate.getEmail()) {
				students.remove(candidate);
			}
		}
	}

	public void viewStudentlist() {
		for(int i=0;i<students.size();i++) {
			System.out.println(students.get(i).getName().getFirstName());
		}
	}

	public Student retrieveStudent(String email) {
		
		Student res = null;
		for(int i=0;i<students.size();i++) {
			if(email == students.get(i).getEmail()) {
				res = students.get(i);
			}else {
				System.out.println("Student does not exist!");
			}
			
		}
		return res;
	}
}
