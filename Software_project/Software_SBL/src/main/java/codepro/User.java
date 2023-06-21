package codepro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {
	
	Logger logger
    = Logger.getLogger(User.class.getName());
	private String name;
	private String id;
	private String email;
	private String address;
	private String postCode;
	private String city;
	private int fines;
	
	private List<Book> borrowedBook = new ArrayList<>();
	
	public User() {
		name = "";
		id = "";
		email = "";
		address = "";
		postCode = "";
		city = "";
		fines = 0;
	}
	
	
	public boolean checkIfHasAlateBook(Calendar cal) {
		boolean flag = true;
		for (int i = 0;i <borrowedBook.size();i++) {
			if(cal.after(borrowedBook.get(i).getDateServer().getDate())) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	
	public void printBorrowedBooks() {
		for (int i = 0;i<borrowedBook.size();i++) {
			String s = borrowedBook.get(i).toString();
			logger.log(Level.INFO,s);
		}
	}

	public Book returnPtrToBook(String inp) {
		Book book = new Book();
		for (int i = 0;i<borrowedBook.size();i++) {
			if (borrowedBook.get(i).getSignature().equals(inp)) {
				book = borrowedBook.get(i);
				break;
			}
		}
		return book;
	}
	
	
	
	
	
	public boolean isBookInArrayList(String signature) {
		for (int i = 0 ; i<borrowedBook.size();i++) {
			if (borrowedBook.get(i).getSignature().equals(signature))
				return true;
		}
		return false;
	}
	
	public void returnBook(Book book) {
		if(!(isBookInArrayList(book.getSignature()))) {
			logger.log(Level.INFO,"this book is not borrowed by you ");
			return;
		}
		borrowedBook.remove(book);
		book.setBorrowed(false);
		
	}
	
	public void addToBorrowedBook(Book b) {
		borrowedBook.add(b);
	}
	
	public int numOfBorrowedBook() {
		return borrowedBook.size();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	 
	 
	public int getFines() {
		return fines;
	}
	public void setFines(int fines) {
		this.fines = fines;
	}
	
	@Override
	public String toString() {
		return getId()+"\t"+getEmail()+"\t"+getAddress()+"\t"+getName()+"\t"+getCity()+"\t"+getPostCode();
	}
}