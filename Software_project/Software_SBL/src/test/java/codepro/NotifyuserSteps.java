package codepro;

import static org.mockito.Mockito.verify;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NotifyuserSteps {
	User user = new User();
	Book book = new Book();
	
	emailmockholder n ;
	Admin admin = new Admin();
	private emailmockholder emh;
	public NotifyuserSteps(Library l,User u,emailmockholder emh) {
		
		this.emh = emh;
	}
	
	public NotifyuserSteps(emailmockholder n) {
	
		this.n = n;
	}

	@Given("there is a user with atleast one late book")
	public void there_is_a_user_with_atleast_one_late_book() {
		
	   user.addToBorrowedBook(book);
	}

	@When("the admin sends a reminder email")
	public void the_admin_sends_a_reminder_email() throws IOException {
		Library.setReminder(user);
		
	    
	}

	@Then("then the user should receive an email with subject {string} and body {string}")
	public void then_the_user_should_receive_an_email_with_subject_and_body(String string, String string2)throws IOException {
		
		verify(emh.getMockEmailHolder()).sendEmail(user.getEmail(),string,string2);
	}
	
}
