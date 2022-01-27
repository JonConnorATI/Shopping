Feature: Sign in

Enter combination of valid and invalid details and finally only valid details. 
Invalid username or password should result in an error being displayed and a link to lost password
Valid username and password should result in landing in the user account page.

Scenario Outline: Check username and password is valid
Given I open the website and select sign in 
When I enter email <username> and password <password> then press login
Then There should be <message> message displayed

Examples:
|username						| password 	|message	|
|jondonuttest@sharklasers.com	|Cloggone	|An Error	|
|jondonuttesttw@sharklasers.com	|Cloggtwo!	|An Error	|
|JonDublin@sharklasers.com 		|Clogg9711	|No Error	|
