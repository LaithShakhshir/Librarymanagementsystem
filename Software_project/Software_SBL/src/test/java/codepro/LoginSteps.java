package codepro;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginSteps {
     Admin b=new Admin();
     @Given("the password is {string}")
     public void the_password_is(String string) {
     	  b.setPass(string);
          b.loginFV(string);
     }
  
     @Given("that the admin is not logged in")
     public void that_the_admin_is_not_logged_in() {
    	 b.setLogged(false);
         assertFalse(b.getLogged());
     }


     @Then("the admin login succeeds")
     public void the_admin_login_succeeds() {
    	 b.setLogged(true);
    	 assertTrue( b.getLogged());

        
     }

@Then("the admin is logged in")
public void the_admin_is_logged_in() {
	 b.setLogged(true);
	 assertTrue( b.getLogged());

}


     @Then("the admin is not logged in")
     public void the_admin_is_not_logged_in() {
    	 b.setLogged(false);
         assertFalse(b.getLogged());

     }
     @Then("the admin login fails")
     public void the_admin_login_fails() {
    	 b.setLogged(false);
         assertFalse(b.getLogged());
     }

}

















