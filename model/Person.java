package model;
/**
 * 
 * @author Jonathan Lim
 *
 */
public class Person {
	private String email;
	private int phoneno;
	private Name name;

	public Person(String mail, int phone,String fn, String mn, String ln) {
		// TODO Auto-generated constructor stub
		email = mail;
		phoneno = phone;
		name = new Name(fn, mn, ln);
	}
	
	public Name getName() {

		return name;
	}

	public void setName(Name name) {

		this.name = name;
	}

	public String getEmail() {

		return email;
	}
	
	public void setEmail(String email) {

		this.email = email;
	}
	
	public int getPhoneno() {

		return phoneno;
	}
	
	public void setPhoneno(int phoneno) {

		this.phoneno = phoneno;
	}
	
}
