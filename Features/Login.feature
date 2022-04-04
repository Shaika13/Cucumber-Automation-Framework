Feature: Login

@sanity
Scenario: searching 
	
	When user enters name as "Cucumber"
	Then user enters Password as "Ccucmber1234"
	And user clicks on login button 
	
@sanity
Scenario Outline: Data driven searching

	When user enters name as "<name>"
	Then user enters Password as "<password>"
	And user clicks on login button

	
	Examples: 
		| name | password |
		| admin | abd34 |
		| bs23admin01 | 123rft |