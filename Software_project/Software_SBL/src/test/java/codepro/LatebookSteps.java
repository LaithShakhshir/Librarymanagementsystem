package codepro;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LatebookSteps {
	int f;
	Book book = new Book();
User u=new User();
MockDateHolder m;


public LatebookSteps(MockDateHolder m) {
	
	this.m = m;
}

@Given("the user has borrowed a book")
public void the_user_has_borrowed_a_book() {
	book.setBorrowed(true);
	Library.borrowBook(u, book);
}

@Given("{int} days have passed")
public void days_have_passed(Integer int1) {
 m.advancedDateByDays(21);
	 
}

@Given("the fine for one late book is {int} NIS")
public void the_fine_for_one_late_book_is_nis(Integer int1) {
	f=int1;
  u.setFines(int1);
}

@Then("the user has Late books")
public void the_user_has_late_books() {
 assertEquals(u.getFines(),f);
}

@Then("the user has to pay a fine of {int} NIS")
public void the_user_has_to_pay_a_fine_of_nis(Integer int1) {
   u.setFines(30);
}

}