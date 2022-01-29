Feature: Change Password, sign in with new password, then revert the password back to the original

A registered user changes thier password, signs in with the new password, then changes the password back and logs back in


Scenario: Change the password to a new value

Given I open the website and select sign in 
When I enter email <username> and current password <password> then press login
|username					|password	|
|JonDublin@sharklasers.com	|Clogg9711	|
Then I should be in the Account welcome page
Given I select the "Update Password" Tab
Then I should be in the "Password" section
Then I can change the password and select save so that it will be updated
|current password	|new password	|
|Clogg9711			|Clogg9712		|
And I receive a message "An email has been sent to your account email to confirm this."


Scenario: Log in with the new password then revert back

Given I open the website and select sign in 
When I enter email <username> and current password <password> then press login
|username					|password	|
|JonDublin@sharklasers.com	|Clogg9712	|
Then I should be in the Account welcome page
Given I select the "Update Password" Tab
Then I should be in the "Password" section
Then I can change the password and select save so that it will be updated
|current password	|new password	|
|Clogg9712			|Clogg9711		|
And I receive a message "An email has been sent to your account email to confirm this."