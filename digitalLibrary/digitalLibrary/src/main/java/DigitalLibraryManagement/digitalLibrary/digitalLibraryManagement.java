package DigitalLibraryManagement.digitalLibrary;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class digitalLibraryManagement {

	static Configuration configuration;
	static Session session;
	static SessionFactory sessionfactory;
	static Scanner scanner;
	
	
	public static void addStudent()
	{
		scanner = new Scanner(System.in);
		
		configuration = new Configuration(); //class reads both the entity class and config  file
		
		configuration.configure(); //checks config file syntax
		    	
		 //Interface. it takes metedata and build connection
		sessionfactory = configuration.buildSessionFactory();
		 //session -> time period b/n start and end.
		session = sessionfactory.openSession();
		
		students s = new students();
		
		System.out.print("Enter Student Regno: ");
		int Regno = scanner.nextInt();
		s.setRegno(Regno);
		System.out.print("Enter Student Name: ");
		String name = scanner.next();
		s.setName(name);
		System.out.print("Enter date of issue: ");
		String date  = scanner.next();
		s.setDate_of_issue(date);
		System.out.print("Enter Student Address: ");
		String address = scanner.nextLine();
		s.setAddress(address);
		session.save(s);
		System.out.println("\nStudent Details added successfully:");
		
		Transaction transaction = session.beginTransaction();
		
		transaction.commit();
		
	}
	public static void viewAllStudents()
	{	
		System.out.println("\nStudent Details:");
		System.out.println("==================");
		
		System.out.println("+----+------------------+-------------+----------------+-");
		System.out.println("| Regno |   Student_Name   | Date_of_issue 	|	Address  |");
		System.out.println("+----+------------------+-------------+----------------+-");

		
		String hqlQuery = "from students";
		
		List<students> data = session.createQuery(hqlQuery, students.class).list();
		
		for(students p : data)
		{
			System.out.printf("| %-6s | %-14s | %-14s | %-14s |\n",p.getRegno(), p.getName(), p.getDate_of_issue(), p.getAddress());
		}
		
		System.out.println("+----+------------------+-------------+----------------+");

	}
	//Update student name
		public static void updateStudentName()
		{
			scanner = new Scanner(System.in);
			
			configuration = new Configuration();
			configuration.configure();
			
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			System.out.print("Enter the regno of student : ");
			int regno = scanner.nextInt();
			
			students s=session.get(students.class,regno);
			Transaction transaction = session.beginTransaction();
			
			System.out.print("Enter the New name for student "+regno+":" );
			String name = scanner.next();
			s.setName(name);
			session.update(s);

			
			System.out.println("Student Name Updated Successfully.");
			transaction.commit();
			session.close();
//			scanner.close();
			
		}
		
		//update student address
		public static void updateAddress()
		{
			scanner = new Scanner(System.in);
			
			configuration = new Configuration();
			configuration.configure();
			
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			System.out.print("Enter the regno of student : ");
			int regno = scanner.nextInt();
			students s=session.get(students.class,regno);
			
			Transaction transaction = session.beginTransaction();
			
			System.out.print("Enter the New address for student "+regno+": ");
			String address = scanner.next();
			s.setAddress(address);
			session.update(s);
//			session.merge(d);
			
			System.out.println("Student Adress Updated Successfully.");
			transaction.commit();
			session.close();
//			scanner.close();
			
		}
		public static void updateStudent()
		{
			scanner = new Scanner(System.in);
			
//			//step1
//			Configuration config = new Configuration();
//			config.configure();
//					
//			//step2
//			SessionFactory factory = config.buildSessionFactory();
//			session = factory.openSession();

			while(true)
			{
				System.out.println("Select What you Want to Update in Students Record.");
				System.out.println("----------------------------------------------------");
				System.out.println("1. Student Name.");
				System.out.println("2. Student Address.");
				System.out.println("3. Exit.");
				System.out.print("Enter your Choice: ");
				
				int choice = scanner.nextInt();
				
				switch(choice)
				{
				case 1:
					updateStudentName();
					System.out.println();
					break;
					
				case 2:
					updateAddress();
					System.out.println();
					break;
			    default:
					System.out.println("Invalid Choice! ..Enter a Valid Choice.");
					break;			
				}
			}
		}
		
		
		
	public static void addBook()
	{
		scanner = new Scanner(System.in);
		
		configuration = new Configuration(); //class reads both the entity class and config  file
		
		configuration.configure(); //checks config file syntax
		    	
		 //Interface. it takes metedata and build connection
		sessionfactory = configuration.buildSessionFactory();
		 //session -> time period b/n start and end.
		session = sessionfactory.openSession();
		
		bookDetails p = new bookDetails();
		
		System.out.print("Enter Author Name: ");
		String name = scanner.nextLine();
		p.setAuthor(name);
		
		System.out.print("Enter Title Name: ");
		String title = scanner.nextLine();
		p.setTitle(title);
		
		System.out.print("Enter Publication Name: ");
		String Publication = scanner.nextLine();
		p.setPublication(Publication);
		
		session.save(p);
		
		Transaction transaction = session.beginTransaction();
		
		transaction.commit();
		
//		session.close();
//		sessionfactory.close();
//		System.out.println("book Added Succcessfully.");
		
		// Check if the Book is Added or not
    	
   	 if (p.getAccno() > 0)
        {
            System.out.println("Book Added Successfully.");
        }
        else
        {
            System.out.println("Failed to Add Book!");
        }
        
		
	}
	
	public static void viewAllBook()
	{	
		System.out.println("\nBook Details:");
		System.out.println("==================");
		
		System.out.println("+----+------------------+-------------+----------------+-");
		System.out.println("| Accno |   Author_Name   | Title_Age 	|	Publication  |");
		System.out.println("+----+------------------+-------------+----------------+-");

		
		String hqlQuery = "from bookDetails";
		
		List<bookDetails> data = session.createQuery(hqlQuery, bookDetails.class).list();
		
		for(bookDetails p : data)
		{
			System.out.printf("| %-6s | %-14s | %-14s | %-14s |\n",p.getAccno(), p.getAuthor(), p.getTitle(), p.getPublication());
		}
		
		System.out.println("+----+------------------+-------------+----------------+");

	}
	
	
	//Update book author
	public static void updateAuthorName()
	{
		scanner = new Scanner(System.in);
		
		configuration = new Configuration();
		configuration.configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		System.out.print("Enter Author Id to Update Name: ");
		int id = scanner.nextInt();
		
		bookDetails p = session.get(bookDetails.class, id); 
		Transaction transaction = session.beginTransaction();
		
		System.out.print("Enter the New Name for Author "+id+": ");
		String name = scanner.next();
		p.setAuthor(name);
		session.update(p);

		
		System.out.println("Author Name Updated Successfully.");
		transaction.commit();
		session.close();
//		scanner.close();
		
	}
	

	public static void updateAuthorTitle()
	{
		scanner = new Scanner(System.in);
		
		configuration = new Configuration();
		configuration.configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		System.out.print("Enter Author's Id to Update Title: ");
		int id = scanner.nextInt();
		
		bookDetails p = session.get(bookDetails.class, id); 
		Transaction transaction = session.beginTransaction();
		
		System.out.print("Enter the New Title for Book "+id+": ");
		String Title = scanner.nextLine();
		p.setTitle(Title);
		session.update(p);
//		session.merge(d);
		
		System.out.println("Book Title Updated Successfully.");
		transaction.commit();
		session.close();
//		scanner.close();
		
	}
	
	public static void updateAuthorPublication()
	{
		scanner = new Scanner(System.in);
		
		configuration = new Configuration();
		configuration.configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		System.out.print("Enter Author Id to Update Name: ");
		int id = scanner.nextInt();
		
		bookDetails p = session.get(bookDetails.class, id); 
		Transaction transaction = session.beginTransaction();
		
		System.out.print("Enter the New Publiation for Author "+id+": ");
		String Publication = scanner.nextLine();
		p.setPublication(Publication);
		session.update(p);
//		session.merge(d);
		
		System.out.println("Book Publication Updated Successfully.");
		transaction.commit();
		session.close();
//		scanner.close();
		
	}
	/*public static void returnBook() {
	    scanner = new Scanner(System.in);

	    configuration = new Configuration();
	    configuration.configure();

	    SessionFactory sessionFactory = configuration.buildSessionFactory();
	    Session session = sessionFactory.openSession();

	    System.out.print("Enter Book Id to Return: ");
	    int id = scanner.nextInt();

	    bookDetails book = session.get(bookDetails.class, id);

	    if (book != null) {
	        if (book.getReturnDate() == null) {
	            Transaction transaction = session.beginTransaction();

	            // Set the return date to the current date
	            book.setReturnDate(LocalDate.now());

	            // Update the book entity
	            session.update(book);

	            transaction.commit();

	            System.out.println("Book Returned Successfully.");
	        } else {
	            System.out.println("Book has already been returned.");
	        }
	    } else {
	        System.out.println("Book not found with ID: " + id);
	    }

	    session.close();
	}*/

	public static void updateAuthor()
	{
		scanner = new Scanner(System.in);
		
//		//step1
//		Configuration config = new Configuration();
//		config.configure();
//				
//		//step2
//		SessionFactory factory = config.buildSessionFactory();
//		session = factory.openSession();

		while(true)
		{
			System.out.println("Select What you Want to Update in BookDetails Record.");
			System.out.println("----------------------------------------------------");
			System.out.println("1. Author Name.");
			System.out.println("2. Author Title.");
			System.out.println("3. Author Publication.");
			System.out.println("4. Exit.");
			System.out.print("Enter your Choice: ");
			
			int choice = scanner.nextInt();
			
			switch(choice)
			{
			case 1:
				updateAuthorName();
				System.out.println();
				break;
				
			case 2:
				updateAuthorTitle();
				System.out.println();
				break;
				
			case 3:
				updateAuthorPublication();
				System.out.println();
				break;
				
			case 4:
				return;
				
			default:
				System.out.println("Invalid Choice! ..Enter a Valid Choice.");
				break;			
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		
	scanner = new Scanner(System.in);
			
			//step1
			Configuration config = new Configuration();
			config.configure();
			
			//step2
			SessionFactory factory = config.buildSessionFactory();
			session = factory.openSession();
			
			while(true)
			{
				System.out.println("===========================");
				System.out.println("DIGITAL LIBRARY MANAGEMENT SYSTEM");
				System.out.println("===========================");
				System.out.println("01. Add Book.");
				System.out.println("02. View Books.");
				System.out.println("03. Update Book Records.");
				System.out.println("04. Add Student.");
				System.out.println("05. View Students.");
				System.out.println("06. Update Students Records.");
				System.out.println("07. Exit.");
				System.out.print("\nEnter Your Choice: ");
				
				int choice = scanner.nextInt();
				
				switch(choice)
				{
				case 1:
					addBook();
					System.out.println();
					break;
					
				case 2:
					viewAllBook();
					System.out.println();
					break;	

				case 3:
					updateAuthor();
					System.out.println();
					break;
				case 4:
					addStudent();
					System.out.println();
					break;
				case 5:
					viewAllStudents();
					System.out.println();
					break;
				case 6:
					updateStudent();
					System.out.println();
					break;
					

//					
				/*case 4:	
					returnBook();
					System.out.println();
					return;*/
					
				default:
					System.out.println("Invalid Choice! ..Enter a Valid Choice.");
					break;
					
				}
			}
		}
	
		}


