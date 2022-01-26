Feature: Account page features and actions

A registered user has an account page where they can view past orders and update contact details and delivery addresses

Background:
Given I log into my account as the Test User
Then I should be in the Account welcome page


Scenario: Open the orders and return section
Given I select the Orders and Return Tab
Then I should be in the Orders and Returns section
And there should be a continue shopping button


Scenario: Open the Contact Preferences section
Given I select the Contact Preferences Tab
Then I should be in the Contact Preferences section
And I will see a checkbox asking if I don't want to be contacted
When I tick the checkbox 
And click save
Then I will see a confirmation message "Your contact preferences have now been updated."



Scenario: Open the Customer Name section
Given I select the Customer Name Tab
Then I should be in the Customer Name section
When I select to edit the name
Then I can change the first name and select save so that it will be updated

@Test1
Scenario: Open the Cardholder Address section
Given I select the Cardholder Address Tab
Then I should be in the Cardholder Address section
When I select edit
Then I can change address2 and select save so that it will be updated

Scenario: Open the Phone Numbers section
Given I select the Phone Numbers Tab
Then I should be in the Phone Numbers section
When I select to edit the Phone Numbers
Then I can change the number and select save so that it will be updated

Scenario: Open the Date of Birth section
Given I select the Date of Birth Tab
Then I should be in the Date of Birth section
When I select to edit the Date of Birth
Then I can change the Date of Birth and select save so that it will be updated


