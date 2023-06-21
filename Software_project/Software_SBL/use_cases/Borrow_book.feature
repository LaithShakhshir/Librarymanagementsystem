Feature: Borrow book
	 Actors: user
	
Scenario: successful Borrow
	  Given that the user should be registered 
	  And the book should be available in libary
	  Then the borrow book successful 
	
Scenario: successful Borrow
	  Given that the user should be registered 
	  And the book should be available in libary
      When the user borrow less than five books
	  Then the borrow book successful 
	
Scenario: user can borrow at maximum five books
	  Given that the user should be registered 
	  And the book should be available in libary
    When the user borrow more than five books
	  Then the error massage "you can't borrow more than five books" is given
	  
	  Scenario: User cannot borrow books if he has late books 
Given a book with code should be "xyz" is in the 'library 
And a book with code "Beck99" is in the library
 And a user is registered with the library 
 When the user borrows the book with code "Beck99" 
 And days have passed And the user borrows the book with code "xyz" 
 Then the book with code "xyz" is not borrowed by the user
  And the error message "You can't borrow any new book because you have an overdue books" is given
  
  Scenario: User cannot borrow books if he has fines 
  Given a book with code that "Beck99" is in the library 
  And a book with code "xyz" is in the library 
  And a user is registered with the library 
  When the user borrows the book with code "Beck99" 
  And days have passed
   Then the user has to pay a fine of NIS 
   When the user returns the book with code "Beck99" 
   Then the user has to pay a fine of NIS 
   When the user borrows the book with code "xyz" 
   Then the book with code "xyz" is not borrowed by the user 
   And the error message "Can't borrow book,you have fines" is given
   
   
   