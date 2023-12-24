	package DigitalLibraryManagement.digitalLibrary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class students {
	@Id //Primary key

	private int Regno;
	
	@Column(name = "Student_Name", nullable = false, unique = false)
	private String Name;
	
	
	@Column(name = "Address", nullable = false, unique = false)
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
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	@Override
	public String toString() {
		return "student [Regno=" + Regno + ", Name=" + Name + ", Address="+ Address + "]";
	}
	
	
	}
	
	
	


