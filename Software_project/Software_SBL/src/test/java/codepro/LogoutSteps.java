package codepro;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.logging.*;
public class LogoutSteps {
    Logger logger
            = Logger.getLogger(LogoutSteps.class.getName());
    Admin admin =new Admin();
    @Given("that the admin is logged in")
    public void that_the_admin_is_logged_in() {
        admin.setLogged(true);

    }

    @When("the admin logs out")
    public void the_admin_logs_out() {
        admin.getLogged();

    }

}
