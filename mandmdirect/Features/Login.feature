Feature: Sign in

Enter combination of valid and invalid details and finally only valid details. 
Invalid username or password should result in an error being displayed and a link to lost password
Valid username and passowrd should result in landing in the user account page.

Scenario Outline: Check username and password is valid
Given I open the website and go to sign in  
When The <username> is entered into the username field 
When <password> is entered into the password field
When I press Login
Then There should be <message> message displayed

Examples:
|username						| password 	|message		|
|jondonuttest@sharklasers.com	|Cloggone	|An Error		|
|jondonuttesttw@sharklasers.com	|Cloggtwo!	|An Error		|
|JonDublin@sharklasers.com 		|Clogg9711	|No Error		|