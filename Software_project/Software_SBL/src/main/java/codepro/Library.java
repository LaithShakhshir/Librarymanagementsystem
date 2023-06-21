package codepro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Library {
    static Logger logger
            = Logger.getLogger(Library.class.getName());
    
    private static emailServer em = new emailServer();
    private static List<Book> books =new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static DateServer d = new DateServer();
    

    public void setDateServer(DateServer da) {
	    d = da;
    }
    public void setEmailServer(emailServer emailserver) {
        em = emailserver;	
    }
    
    public static void setReminder(User u)throws IOException {
    	String email = u.getEmail();
    	String subject = "Late book(s)";
    	String body = "You have n late book(s)";
    	em.sendEmail(email, subject, body);
    }


public static void PrintUsers() {
	for (int i =0;i<users.size();i++) {
		logger.log(Level.INFO,users.get(i).toString());
	}
}

public static void printBooks() {
	for (int i = 0;i<Library.books.size();i++) {
		logger.log(Level.INFO,Library.books.get(i).toString());
	}
}

public static Book returnPtrToBook(String inp) {
	Book book = new Book();
	for (int i = 0;i<books.size();i++) {
		if (books.get(i).getSignature().equals(inp)) {
			book = books.get(i);
			break;
		}
		
	}
	return book;
}


public static User returnPtrToUser(String inp) {
	User user = new User(); 
	for (int i = 0;i<users.size();i++) {
		if (users.get(i).getId().equals(inp)) {
			user = users.get(i);
			break;
		}
	}
	return user;
}


public static void addUser(Admin admin,User u) {
	 if(admin.getLogged() && !isUserRegestered(u.getId())){users.add(u);}
	 else if(!admin.getLogged()) logger.log(Level.INFO,"Admin login is required");
	 else if(isUserRegestered(u.getId())) logger.log(Level.INFO,"this user is already registered");
   }

public static boolean isUserRegestered(String email) {
	for (int i = 0 ; i<users.size();i++) {
		if (users.get(i).getId().equals(email))
			return true;
	}
	return false;
}

public static void borrowBook(User u,Book book) {
	if (!isUserRegestered(u.getId()) || !Library.isBookAvailable(book.getSignature())) {
		return;}
	if ((u.numOfBorrowedBook()>=5)) {
		logger.log(Level.INFO,"you can not borrow more than five books");
		return;
	}
	Calendar cal = d.getDate();
	cal.add(Calendar.DAY_OF_YEAR, -21);
	if (!u.checkIfHasAlateBook(cal)) {
		logger.log(Level.INFO,"you have a late book");
		return;}
	if (u.getFines()>0) { 
		logger.log(Level.INFO,"you have fines");
		return;}
	u.addToBorrowedBook(book);
	book.setBorrowed(true);
	
}
public static List<User> serachUserBysig(String isbn){
    List<User> searched=new ArrayList<>();
    for(int i = 0; i< users.size(); i++){
        if(users.get(i).getId().contains(isbn)) searched.add(users.get(i));

    }
    return searched;
}

public static void unRegUser(User u,Admin admin) {
	 if (!admin.getLogged() || !isUserRegestered(u.getId())) return;
	 Library.users.remove(u);
}





    public static void addbook(Book a, Admin admin){
        if(admin.getLogged()){books.add(a);}
        else
            logger.log(Level.INFO,"you Should ba an admin");
    }
   
   

    public static List<Book> searchByAuthor(String author){
        List<Book> searched=new ArrayList<>();
        for(int i = 0; i< books.size(); i++){
            if(books.get(i).getAuthor().contains(author))
                searched.add(books.get(i));
        }
        return searched;
    }
    
    
    public static List<Book> searchByTitle(String title){
        List<Book> searched=new ArrayList<>();
        for(int i = 0; i< books.size(); i++){
            if(books.get(i).getTitle().contains(title)){
                searched.add(books.get(i));
            }
        }
        return searched;
    }
    public static List<Book> serachBysig(String isbn){
        List<Book> searched=new ArrayList<>();
        for(int i = 0; i< books.size(); i++){
            if(books.get(i).getSignature().contains(isbn))
                searched.add(books.get(i));

        }
        return searched;
    }
    public static boolean isBookAvailable(String isbn) {
    	for (int i = 0 ; i<books.size();i++) {
			if (books.get(i).getSignature().equals(isbn))
				return true;
		}
		return false;
    }
    
    

}