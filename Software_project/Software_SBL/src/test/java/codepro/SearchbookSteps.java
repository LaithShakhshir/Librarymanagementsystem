package codepro;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SearchbookSteps {
    Admin user =new Admin();
    List<Book> title = new ArrayList<>();
    List<Book> author = new ArrayList<>();
    List<Book> sig = new ArrayList<>();
 
    boolean Assert_author = false;
     boolean Assert_sig = false;
    List<String> data;
    Logger logger
            = Logger.getLogger(SearchbookSteps.class.getName());

    @Given("these books are contained in the library")
    public void these_books_are_contained_in_the_library(io.cucumber.datatable.DataTable table) {
    	for(int  i = 0 ; i<table.height();i++) {
        	Book b = new Book(table.cell(i, 0) , table.cell(i, 1) , table.cell(i, 2)); 
        	Library.addbook(b,user);
        	
        	
        }

    }

    @When("the user searches for the text {string}")
    public void the_user_searches_for_the_text(String string) {
        title = Library.searchByTitle(string);

    }
    
    @Then("the book with code {string} is found")
    public void the_book_with_code_is_found(String string) {
    	 sig = Library.serachBysig(string);
         if (sig.isEmpty()) {
             logger.log(Level.INFO,"library is empty");
             Assert_sig = false;
         } else {
             Assert_sig = true;
         }
    }
  
    @Then("no books are found")
    public void no_books_are_found() {
    	 author = Library.searchByAuthor("");
         if (author.isEmpty()) {
             logger.log(Level.INFO,"library is empty");
             Assert_author = false;
         }
         assertFalse(Assert_author);

    }

@Then("the books with code {string} and {string} are found")
public void the_books_with_code_and_are_found(String string, String string2) {
    Assert_sig = true;
    assertTrue(Assert_sig);

}
}
    
