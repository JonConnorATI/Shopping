Feature: Account page features and actions

A registered user has an account page where they can view past orders and update contact details and delivery addresses

Background:
Given I log into my account as the Test User
Then I should be in the Account welcome page


Scenario: Open the orders and return section
Given I select the "Orders and Returns" Tab
Then I should be in the "Orders" section
And there should be a continue shopping button


Scenario: Open the Contact Preferences section
Given I select the "Contact Preferences" Tab
Then I should be in the "Mailing" section
And I will see a checkbox asking if I don't want to be contacted
When I tick the checkbox 
And click save
Then I will see a confirmation message "Your contact preferences have now been updated."



Scenario: Open the Customer Name section
Given I select the "Customer Name" Tab
Then I should be in the "Customer" section
When I select to edit "name" section
Then I can change the first name and select save so that it will be updated


Scenario: Open the Cardholder Address section
Given I select the "Cardholder Address" Tab
Then I should be in the "Address" section
When I select to edit "address" section
Then I can change address2 and select save so that it will be updated

@test1
Scenario: Open the Delivery Addresses section
Given I select the "Delivery Addresses" Tab
Then I should be in the "Delivery" section
When I select to edit "delivery" section
Then I can change delivery address and select save so that it will be updated


Scenario: Open the Phone Numbers section
Given I select the "Phone Numbers" Tab
Then I should be in the "Phone" section
When I select to edit "phone" section
Then I can change the number and select save so that it will be updated


Scenario: Open the Date of Birth section
Given I select the "Date of Birth" Tab
Then I should be in the "Dob" section
When I select to edit "dob" section
Then I can change the Date of Birth and select save so that it will be updated



Scenario: Open the Email section
Given I select the "Email" Tab
Then I should be in the "Email" section
When I select to edit "email" section
Then I can change the email and select save so that it will be updated
And change it back again to the original value


