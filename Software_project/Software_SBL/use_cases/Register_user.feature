Feature: Register user
	 Actors: admin
	
Scenario: Register user successful 
	Given that The admin is logged in
  And there is a user whith ID "2984754" , NAME "Ahmad Ali " , Email "ahm@gmail.com" , address "Nablus street" ,post code "H3H1T5" ,city "Nablus"
	When the user is registered
	Then the user whith ID "2984754" , NAME "Ahmad Ali " , Email "ahm@gmail.com" , address "Nablus street" ,post code "H3H1T5" ,city "Nablus" is registered in the system
	
Scenario: Register user when the admin is not logged in 
	Given that the admin is not logged in
        And there is a user whith ID "2984754" , NAME "Ahmad Ali " , Email "ahm@gmail.com" , address "Nablus street" ,post code "H3H1T5" ,city "Nablus"
	When the user is registered 
	Then the error message "Admin login is required" is given

	
Scenario: admin logged in tries to register a user that is already registered 
	Given that the admin is logged in
  And there is a user whith ID "2984754" , NAME "Ahmad Ali " , Email "ahm@gmail.com" , address "Nablus street" ,post code "H3H1T5" ,city "Nablus"
	When the user is registered 
	Then the error message "this user is already registered" is given
	