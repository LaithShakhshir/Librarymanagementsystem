package codepro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;


public class Main {
     static Logger logger
    = Logger.getLogger(Main.class.getName());
	
	public static void searchbook() {
		List <Book> sr = new ArrayList<Book>();
		Scanner scanner = new Scanner(System.in);
		int key;
		String inp;
		logger.log(Level.INFO,"1-search by SIGNTURE.\n2-search by auther.\n3-search by title.");
		key = scanner.nextInt();
		logger.log(Level.INFO,"enter the key-word");
		switch (key) {
		case 1:
			inp = scanner.next();
			sr = Library.serachBysig(inp);
			for (int i = 0;i<sr.size();i++) {
				logger.log(Level.INFO,sr.get(i).toString());
			}
			break;
		case 2: 
			inp = scanner.next();
			sr = Library.searchByAuthor(inp);
			for (int i = 0;i<sr.size();i++) {
				logger.log(Level.INFO,sr.get(i).toString());
			}
			break;
		case 3:
			inp = scanner.next();
			sr = Library.searchByTitle(inp);
			for (int i = 0;i<sr.size();i++) {
				logger.log(Level.INFO,sr.get(i).toString());
			}
			break;
			

		default:
			logger.log(Level.INFO,"not in the range");
			break;
		}
	}
	
	
	
	public static void main(String[] args) {
		int key;
		String inp;
		Scanner scanner = new Scanner(System.in);
		Admin admin = new Admin();
		
		for(;;) {
		logger.log(Level.INFO,"welcome to our Library , Who are you?\n1-Admin.\n2-User.\n3-Guest.\n4-Exit the Library.");
		key = scanner.nextInt();
		switch (key) {
		case 1:
			logger.log(Level.INFO,"enter the password");
			inp = scanner.next();
			if(!admin.getPass().equals(inp)) {logger.log(Level.INFO,"the password is wrong"); break;}
		    admin.loginFV(inp);
			for(;;) {
        	logger.log(Level.INFO,"1-regiter user.\n2-unregister user.\n3-search book.\n4-add book.\n5-notification user.\n6-Print all Users.\n7-print all books\n8-logout.");
        	 key = scanner.nextInt();
        	 switch (key) {
			case 1:
				User user = new User();
				logger.log(Level.INFO,"please enter the ID,name,email,address,postal code,city");
				inp = scanner.next();
				
				if(Library.isUserRegestered(inp)) { logger.log(Level.INFO,"the user is already registerd");break;}
				
				user.setId(inp);
				
				inp = scanner.next();
				user.setName(inp);
				
				inp = scanner.next();
				user.setEmail(inp);
				
				inp = scanner.next();
				user.setAddress(inp);
				
				inp = scanner.next();
				user.setPostCode(inp);
				
				inp = scanner.next();
				user.setCity(inp);
				
				Library.addUser(admin,user);
				break;
				
			case 2:
				
				logger.log(Level.INFO,"please enter the Id of the user");
				Library.PrintUsers();
				inp = scanner.next();
				User user2 = new User();
				if(!Library.isUserRegestered(inp)) {logger.log(Level.INFO,"user is not regestered");break;}
				user2 = Library.returnPtrToUser(inp);
				Library.unRegUser(user2,admin);
				
        	 
				Library.PrintUsers();
				break;
			case 3:
				searchbook();
				break;
			
				
			case 4:
				Book book = new Book();
				logger.log(Level.INFO,"please enter the Signture,Title,auther");
				inp = scanner.next();
				if(Library.isBookAvailable(inp)) { logger.log(Level.INFO,"the book is already registerd");break;}
				book.setSignature(inp);
				
				inp = scanner.next();
				book.setTitle(inp);
				
				inp = scanner.next();
				book.setAuthor(inp);
				Library.addbook(book, admin);
				
				
				break;
			case 5:
				logger.log(Level.INFO,"please enter the User id");
				inp = scanner.next();
				user2 = Library.returnPtrToUser(inp);
				try {
					Library.setReminder(user2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			
			case 6:
				Library.PrintUsers();
				break;
			case 7:
				Library.printBooks();
		    		break;
			    case 8:
				    admin.logoutFV();
				    break;
				
			    default:
				    break;
			    }
			    if (key == 8)break;
		    }
			
			    break;
		case 2:
			User user4 = new User();
			logger.log(Level.INFO,"please enter your id");
			inp = scanner.next();
			if(!Library.isUserRegestered(inp)){logger.log(Level.INFO,"you are not registered please ask the admin to register you");break;}
			user4 = Library.returnPtrToUser(inp);
			for(;;) {
	        	logger.log(Level.INFO,"1-Borrow Book.\n2-return Book.\n3-search book.\n4-Show Books.\n5-view total fines.\n6-pay fines.\n7-Back");
	        	key = scanner.nextInt();
	        	switch (key) {
				case 1:
					logger.log(Level.INFO,"please enter the id of the Book");
		        	inp = scanner.next();
		        	if(!Library.isBookAvailable(inp)) {logger.log(Level.INFO,"the book is not available");break;}
		        	Book book = new Book();
		        	book = Library.returnPtrToBook(inp);
					Library.borrowBook(user4,book);
					break;
					
				case 2:
					logger.log(Level.INFO,"please enter the id of the Book");
		        	inp = scanner.next();
		        	Book book2;
		        	book2 = user4.returnPtrToBook(inp);
		        	if (book2 == null) {logger.log(Level.INFO,"you did not borrow this Book");break;}
					user4.returnBook(book2);
					break;
				case 3:
					searchbook();
					break;
				case 4:
					user4.printBorrowedBooks();
					 
					break;
					
				case 5:
					String s = "your total fines is: "+user4.getFines();
					logger.log(Level.INFO,s);
					break;
					
				case 6:
					user4.setFines(0);
					break;
					
				case 7: 
					break;
					
					 

				default:
					logger.log(Level.INFO,"not in the range");
					break;
				}
	        	if (key == 7)break;
			}
             break;
		case 3:
			break;
		case 4: 
			logger.log(Level.INFO,"Exiting.......");
			System.exit(0);
			break;
		    default:
			    break;
		    }
		if (key == 4)break;
		}

	}

}
