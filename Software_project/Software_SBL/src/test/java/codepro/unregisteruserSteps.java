package codepro;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class unregisteruserSteps {
	User u=new User();
	Admin a=new Admin();
	String id ="2984754";

	@Given("a user is registered with the Elibrary")
	public void a_user_is_registered_with_the_elibrary() {
		Library.isUserRegestered(id);
	}

	@When("the admin try to unregister that user")
	public void the_admin_try_to_unregister_that_user() {
		Library.unRegUser(u,a);

	}

	@Then("the user is out of library")
	public void the_user_is_out_of_library() {
		a.setLogged(true);
		Library.unRegUser(u,a);
		assertTrue(Library.isUserRegestered(id));

	}
}
