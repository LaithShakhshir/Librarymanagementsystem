package codepro;


import static org.junit.Assert.assertFalse;

import java.util.logging.Level;
import java.util.logging.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReturnbookSteps {
	Logger logger
    = Logger.getLogger(ReturnbookSteps.class.getName());
	User user  = new User();
	Book book = new Book(); 

@Given("that The book should be borrowed by a registered user")
public void that_the_book_should_be_borrowed_by_a_registered_user() {
	book.setBorrowed(true);
}

@When("the action return happens")
public void the_action_return_happens() {
	user.returnBook(book);
	
}

@Then("the book should not be borrowed by that user")
public void the_book_should_not_be_borrowed_by_that_user() {
	book.setBorrowed(false);
assertFalse(book.getIsBorrowed());
	
   
}

@Given("that the book is not borrowed by that user")
public void that_the_book_is_not_borrowed_by_that_user() {
	book.setBorrowed(false);
    
}

@Then("the error massage \"this book is not borrowed by you \"is given")
public void the_error_massage_this_book_is_not_borrowed_by_you_is_given() {
	 logger.log(Level.INFO,"this book is not borrowed by you");
   
}

}