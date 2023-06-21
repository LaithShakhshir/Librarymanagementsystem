package codepro;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BorrowbookSteps {
	User u=new User();
	String id ="2984754";
	Book book = new Book(); 

String isbn="Kent99";
List<Book> sig = new ArrayList<>();
boolean Assert_sig = false;
Logger logger
= Logger.getLogger(BorrowbookSteps.class.getName());
	
@Given("that the user should be registered")
public void that_the_user_should_be_registered() {
	Library.isUserRegestered(id);

}

@Given("the book should be available in libary")
public void the_book_should_be_available_in_libary() {
      Library.isBookAvailable(isbn);
}

@Then("the borrow book successful")
public void the_borrow_book_successful() {
	book.setBorrowed(true);
assertTrue(book.getIsBorrowed());
}


@Given("a book with code {string} is in the library")
public void a_book_with_code_is_in_the_library(String string) {
	 sig = Library.serachBysig(string);
     if (sig.isEmpty()) {
         logger.log(Level.INFO,"library is empty");
         Assert_sig = false;
     }     else {Assert_sig = true;}
}



@Given("a user is registered with the library")
public void a_user_is_registered_with_the_library() {
	Library.isUserRegestered(id);

}



@When("the user borrows the book with code {string}")
public void the_user_borrows_the_book_with_code(String string) {
	book.setSignature(string);
Library.borrowBook(u, book);
}

@When("the user borrow less than five books")
public void the_user_borrow_less_than_five_books() {
	Library.borrowBook(u, book);
}

@When("the user borrow more than five books")
public void the_user_borrow_more_than_five_books() {
	Library.borrowBook(u, book);
	

}
@When("days have passed")
public void days_have_passed() {
   u.setFines(u.getFines()+30);
}

@Then("the user has to pay a fine of NIS")
public void the_user_has_to_pay_a_fine_of_nis() {
	assertEquals(u.getFines(), 30);
   
}

@When("days have passed And the user borrows the book with code {string}")
public void days_have_passed_and_the_user_borrows_the_book_with_code(String string) {
	DateServer d = new DateServer();
	book.setDateServer(d);
	Calendar c = book.getDateServer().getDate();
			c.add(Calendar.DAY_OF_YEAR, -22);
	d.setDate(c);
   book.setDateServer(d);
   Library.borrowBook(u, book);
}
@Then("the book with code {string} is not borrowed by the user")
public void the_book_with_code_is_not_borrowed_by_the_user(String string) {
    assertFalse(book.getIsBorrowed() );
}



@When("the user returns the book with code {string}")
public void the_user_returns_the_book_with_code(String string) {
	book.setSignature(string);
	u.returnBook(book);

}


@Given("a book with code should be {string} is in the 'library")
public void a_book_with_code_should_be_is_in_the_library(String string) {
	 sig = Library.serachBysig(string);
     if (sig.isEmpty()) {
         logger.log(Level.INFO,"library is empty");
         Assert_sig = false;
     }     else {Assert_sig = true;}
  }






@Given("a book with code that {string} is in the library")
public void a_book_with_code_that_is_in_the_library(String string) {
	 sig = Library.serachBysig(string);
     if (sig.isEmpty()) {
         logger.log(Level.INFO,"library is empty");
         Assert_sig = false;} else {Assert_sig = true;}
     
}


}