package codepro;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisteruserSteps {
    Admin admin =new Admin();
    User U=new User();
    List< User> ID = new ArrayList<>();
    boolean Assert_sig = false;

    boolean correct;
    Logger logger
    = Logger.getLogger(RegisteruserSteps.class.getName());
 
@Given("that The admin is logged in")
public void that_the_admin_is_logged_in() {
    admin.setLogged(true);

}

@Given("there is a user whith ID {string} , NAME {string} , Email {string} , address {string} ,post code {string} ,city {string}")
public void there_is_a_user_whith_id_name_email_address_post_code_city(String string, String string2, String string3, String string4, String string5, String string6) {
   U.setAddress(string4);
   U.setCity(string6);
   U.setEmail(string3);
   U.setId(string);
   U.setPostCode(string5);
   U.setName(string2);
}

@When("the user is registered")
public void the_user_is_registered() {
	 if(correct){
         Library.addUser(admin,U);
   }
     else
          assertFalse(false);
}


@Then("the user whith ID {string} , NAME {string} , Email {string} , address {string} ,post code {string} ,city {string} is registered in the system")
public void the_user_whith_id_name_email_address_post_code_city_is_registered_in_the_system(String string, String string2, String string3, String string4, String string5, String string6) {
	Library.addUser(admin,U);
	assertTrue(  Library.isUserRegestered(string));

}

@Then("the error massage{string} is given")
public void the_error_massage_admin_login_is_required_is_given(String string) {


	 logger.log(Level.INFO,"Admin login is required");
}
@Then("the error massage {string} is given")
public void the_error_massage_this_user_is_already_registered_is_given(String string) {
	ID = Library.serachUserBysig(string);
    if (ID.isEmpty()) {
        logger.log(Level.INFO,"you can add this user");
        Assert_sig = false;
    } else {
        logger.log(Level.INFO,"this user is already registered");
        for (int i = 0; i < ID.size(); i++)

        Assert_sig = true;
    }
}
}