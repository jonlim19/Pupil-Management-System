package model;

public class Teacher extends Person{
	String qualification;

	public Teacher(String qual,String mail, int phone, String fn, String mn, String ln) {
		// TODO Auto-generated constructor stub
		super(mail,phone,fn,mn,ln);
		qualification = qual;
	}

	public String getQualification() {

		return qualification;
	}

	public void setQualification(String qualification) {

		this.qualification = qualification;
	}
	
	
}
