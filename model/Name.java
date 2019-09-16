package model;

public class Name {
	String firstName;
	String middleName;
	String lastName;

	public Name(String fn, String mn, String ln) {
		// TODO Auto-generated constructor stub
		firstName = fn;
		middleName = mn;
		lastName = ln;
	}

	public String getFirstName() {

		return firstName;
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	public String getMiddleName() {

		return middleName;
	}

	public void setMiddleName(String middleName) {

		this.middleName = middleName;
	}

	public String getLastName() {

		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
