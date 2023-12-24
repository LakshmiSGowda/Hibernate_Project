package DigitalLibraryManagement.digitalLibrary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class students {
	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Regno;
	
	@Column(name = "Student_Name", nullable = false, unique = true)
	private String Name;
	
	@Column(name = "Date_of_issue", nullable = false, unique = true)
	private String Date_of_issue;
	
	@Column(name = "Address", nullable = false, unique = true)
	private String Address;
	
	//private int Accno;
	public int getRegno() {
		return Regno;
	}
	public void setRegno(int regno) {
		Regno = regno;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDate_of_issue() {
		return Date_of_issue;
	}
	public void setDate_of_issue(String date_of_issue) {
		Date_of_issue = date_of_issue;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	@Override
	public String toString() {
		return "student [Regno=" + Regno + ", Name=" + Name + ", Date_of_issue=" + Date_of_issue + ", Address="
				+ Address + "]";
	}
	
	
	}
	
	
	


