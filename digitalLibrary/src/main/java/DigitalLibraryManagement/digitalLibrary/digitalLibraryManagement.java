package DigitalLibraryManagement.digitalLibrary;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;





public class digitalLibraryManagement {

	static Configuration configuration;
	static Session session;
	static SessionFactory sessionfactory;
	static Scanner scanner;
	
	public static void studentDetails()
	{
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();
		session = factory.openSession();
		Scanner sc = new Scanner(System.in);
		int choice;
		while(true)
		{
			System.out.println("+============================================================================+");
			System.out.println("|--------------------------Student details-----------------------------------|");
			System.out.println("+============================================================================+");
			System.out.println("1. Add student information");
			System.out.println("2. View all student list");
			System.out.println("3. Update student Details.");
			System.out.println("4. Back to main page.");
			System.out.println();
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				addStudent();
				break;
			case 2:
				viewAllStudents();
				break;
			case 3:
			{
					System.out.println("-------------------------Update student details------------------------------");
					System.out.println("1. Update student Name");
					System.out.println("2. Update student Address");
					System.out.println("3. Back to previous page.");
					System.out.println();
					System.out.println("Enter your choice");
					choice = sc.nextInt();
					switch(choice)
					{
					case 1:
						updateStudName();
						break;
					case 2:
						updateAddress();
						break;
					case 3:
						return;
						
					default:
					System.out.println("Invalid choice !!!!, please enter valid choice");		
					}
				break;
			}
			case 4:
				return;
			default:
				System.out.println("Invalid choice !!!!, please enter valid choice");	
				
			}
		}
		
	}
	
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
		scanner.nextLine();
		System.out.print("Enter Student Name: ");
		String name = scanner.nextLine();
		s.setName(name);
		System.out.print("Enter Student Address: ");
		String address = scanner.nextLine();
		s.setAddress(address);
		session.save(s);
		
		Transaction transaction = session.beginTransaction();
		
		transaction.commit();
		
	}
	public static void viewAllStudents()
	{	
		System.out.println("\n-----------------Student Details:-----------------------");
		System.out.println("==========================================================");
		
		System.out.println("+----+------------------+-------------+-");
		System.out.println("| Regno |   Student_Name|	Address   | ");
		System.out.println("+----+------------------+-------------+-");

		
		String hqlQuery = "from students";
		
		List<students> data = session.createQuery(hqlQuery, students.class).list();
		
		for(students p : data)
		{
			System.out.printf("| %-6s | %-14s | %-14s |\n",p.getRegno(), p.getName(), p.getAddress());
		}
		
		System.out.println("+----+------------------+-------------+-");

	}
	//Update student name
			public static void updateStudName()
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
//				scanner.close();
				
			}
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
				scanner.nextLine();
				String address = scanner.nextLine();
				s.setAddress(address);
				session.update(s);
//				session.merge(d);
				
				System.out.println("Student Adress Updated Successfully.");
				transaction.commit();
				session.close();
//				scanner.close();
				
			}
			
			public static void bookDetails()
			{
				Configuration config = new Configuration().configure();
				SessionFactory factory = config.buildSessionFactory();
				session = factory.openSession();
			
				Scanner sc = new Scanner(System.in);
				int choice;
				while(true)
				{
					System.out.println("--------------------------Books details-----------------------------------");
					System.out.println("1. Add new book");
					System.out.println("2. View all books");
					System.out.println("3. Update book details");
					System.out.println("4. Back to main page.");
					System.out.println();
					System.out.println("Enter your choice");
					choice = sc.nextInt();
					switch(choice)
					{
					case 1:
						addBook();
						break;
					case 2:
						viewAllBook();
						break;
					case 3:
					{
						System.out.println("----------------------Update book details--------------------------------");
						System.out.println("1. update author name");
						System.out.println("2. Update book title");
						System.out.println("3. Update book publication.");
						System.out.println("4. back to previous page.");
						System.out.println();
						System.out.println("Enter your choice");
						choice= sc.nextInt();
						switch(choice)
						{
						case 1:
							updateAuthorName();
							break;
						case 2:
							updateAuthorTitle();
							break;
						case 3:
							updateAuthorPublication();
							break;
						case 4:
							return;
							default:
								System.out.println("Invalid entry !!!, please enter correct options");
						}
						
					}
					case 4:
						return;
						default:
							System.out.println("Invalid entry!!!, please enter correct choice");
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
		System.out.println("| Accno |   Author_Name   | Title_name 	|	Publication  |");
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
		System.out.print("Enter the New Name for Author "+id+": ");
		Transaction transaction = session.beginTransaction();
		scanner.nextLine();
		String name = scanner.nextLine();
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
		scanner.nextLine();
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
		scanner.nextLine();
		String Publication = scanner.nextLine();
		p.setPublication(Publication);
		session.update(p);
//		session.merge(d);
		
		System.out.println("Book Publication Updated Successfully.");
		transaction.commit();
		session.close();
//		scanner.close();
		
	}

	
	public static void updateAuthor()
	{
		scanner = new Scanner(System.in);
		
		//step1
		Configuration config = new Configuration();
		config.configure();
				
		//step2
		SessionFactory factory = config.buildSessionFactory();
		session = factory.openSession();

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
	
	public static void issueDetails()
	{
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();
		session = factory.openSession();
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("------------------------ Issuse Details -------------------------");
		System.out.println("1. Add students id who taken books from library");
		System.out.println("2.view all issues details.");
		System.out.println("3.view issues details by student id.");
		System.out.println("4.Return to previous page.");
		System.out.println();
		System.out.println("Please enter your choice.");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			addStudentToIssue();
			break;
		case 2:
			viewAllIssue();
			break;
		case 3:
//			viewByStudentId();
			break;
		case 4:
			return;
			default:
				System.out.println("Invalid entry !!!, please enter correct options.");
				break;
		}
	}
	public static void addStudentToIssue()
	{
		issue is =new issue();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student ID who taken books from library");
		int id=sc.nextInt();
		is.setStudentid(id);
		System.out.println("Enter Book ID");
		id=sc.nextInt();
		is.setBookid(id);
		System.out.println("Enter date of issue");
		sc.nextLine();
		String d = sc.nextLine();
		is.setIssueDate(d);
		Configuration config = new Configuration().configure().addAnnotatedClass(issue.class);
		 StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(is);
		tx.commit();
	}
	public static void viewAllIssue()
	{
		System.out.println("\nIssuse Details:");
		System.out.println("==================");
		
		System.out.println("+------------+------------------+-------------+----------------+---------------+-");
		System.out.println("| Student Id |  Student Name    |  Book ID    |  Book Title    |   Issue Date  |	");
		System.out.println("+------------+------------------+-------------+----------------+---------------+-");

		
//		String hqlQuery = "from issue";
		String hqlQuery = "SELECT a.Studentid, a.student.Name, a.Bookid,a.book.Title, a.IssueDate FROM issue a";
		
		List<Object[]> data = session.createQuery(hqlQuery).getResultList();
		
		for(Object[] p :data)
		{
			System.out.printf("| %-10s | %-16s | %-11s | %-14s | %-12s |\n",p[0],p[1],p[2],p[3], p[4]);
		}
		
		System.out.println("+------------+------------------+-------------+----------------+----------------+-");
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
				System.out.println("====================================================================================");
				System.out.println("------------------------DIGITAL LIBRARY MANAGEMENT SYSTEM---------------------------");
				System.out.println("====================================================================================");
				System.out.println("01.view Student details");
				System.out.println("02. View Books details");
				System.out.println("03. view issue details");
				System.out.println("4. Exit.");
				System.out.print("\nEnter Your Choice: ");
				
				int choice = scanner.nextInt();
				
				
				switch(choice)
				{
				case 1:
					studentDetails();
					break;
				case 2:
					bookDetails(); 
					break;
				case 3:
					issueDetails();
					break;
				case 4:
					return;
				default:
					System.out.println("Invalid Choice!!! Enter a Valid Choice.");
					break;
				
				}
				
//				
			}
		}
	
		}


