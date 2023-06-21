Feature: unregister user
Scenario: Unregister a user 
Given a user is registered with the Elibrary
 And that the admin is logged in 
 When the admin try to unregister that user 
 Then the user is out of library