package DigitalLibraryManagement.digitalLibrary;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//Entity class or pojo class

@Entity //bookDetails table will create
public class bookDetails {
	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Accno;
	
	@Column(name = "Author_Name", nullable = false, unique = true)
	private String Author;
	
	@Column(name = "Title", nullable = false)
	private String Title;
	
	@Column(name = "Publication", nullable = false)
	private String Publication;
	
//	@Column(name = "Price", nullable = false)
//	private int Price;
	
	//getter and setters -> prefix set or get
	public int getAccno() {
		return Accno;
	}
	public void setAccno(int accno) {
		Accno = accno;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPublication() {
		return Publication;
	}
	public void setPublication(String publication) {
		Publication = publication;
	}
//	public int getPrice() {
//		return Price;
//	}
//	public void setPrice(int price) {
//		Price = price;
//	}
	@Override
	public String toString() {
		return "bookDetails [Accno=" + Accno + ", Author=" + Author + ", Title=" + Title + ", Publication="
				+ Publication + "]";
	}
	
	
	
	
}
