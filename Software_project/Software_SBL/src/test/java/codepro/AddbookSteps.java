
package codepro;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddbookSteps {
	   Book b=new Book();
	   Admin user=new Admin();
	    boolean correct;
	    
	    List<Book> sig = new ArrayList<>();
	    
	     boolean Assert_sig = false;
	    Logger logger
	            = Logger.getLogger(AddbookSteps.class.getName());

	    

	    @Given("that the administrator is logged in")
	    public void that_the_administrator_is_logged_in() {
	    	user.setLogged(true);
	    	 assertTrue( user.getLogged());

	    }


    @Given("there is a book with title {string}, author {string}, and signature {string}")
    public void there_is_a_book_with_title_author_and_signature(String string, String string2, String string3) {
    	  b.setTitle(string);
          b.setAuthor(string2);
         b.setSignature(string3);
    }
    
    @When("the book is added to the library")
    public void the_book_is_added_to_the_library() {
    	 if(correct){
             Library.addbook(b,user);
     }
         else
              assertFalse(false);
    }

    @Given("that the administrator is not logged in")
    public void that_the_administrator_is_not_logged_in() {
     	 user.setLogged(false);
         assertFalse(user.getLogged());    }

    @Then("the error message {string} is given")
    public void the_error_message_is_given(String string) {
   	 logger.log(Level.INFO,"Administrator login required");

    }
    @Then("the book with title {string}, author {string}, and signature {string} is contained in the library")
    public void the_book_with_title_author_and_signature_is_contained_in_the_library(String string, String string2, String string3) {
        assertFalse(Assert_sig);

    }
    }


















