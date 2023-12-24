package DigitalLibraryManagement.digitalLibrary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class issue {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "Book_Id", nullable = false)
	private int Bookid;
	
	@Column(name = "Student_Id", nullable = false)
	private int Studentid;
	
	@Column(name = "Issue_date", nullable = false)
	private String IssueDate;
	
	@ManyToOne
	@JoinColumn(name = "Student_Id", referencedColumnName = "Regno", insertable = false, updatable = false)
	private students student;
	
	@ManyToOne
	@JoinColumn(name = "book_Id", referencedColumnName = "Accno", insertable = false, updatable = false)
	private bookDetails book;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getBookid() {
		return Bookid;
	}


	public void setBookid(int bookid) {
		Bookid = bookid;
	}


	public int getStudentid() {
		return Studentid;
	}


	public void setStudentid(int studentid) {
		Studentid = studentid;
	}


	public String getIssueDate() {
		return IssueDate;
	}


	public void setIssueDate(String issueDate) {
		IssueDate = issueDate;
	}


	public students getStudent() {
		return student;
	}


	public void setStudent(students student) {
		this.student = student;
	}


	public bookDetails getBook() {
		return book;
	}


	public void setBook(bookDetails book) {
		this.book = book;
	}


	@Override
	public String toString() {
		return "issue [id=" + id + ", Bookid=" + Bookid + ", Studentid=" + Studentid + ", IssueDate=" + IssueDate
				+ ", student=" + student + ", book=" + book + "]";
	}
	

}
