Feature: The shopping basket is cached

Should I add an item to the shopping basket I expect the item to remain in the shopping basket when I log out and then come back and log in again
This user starts with an empty cart

Scenario: Add an item to shopping basket, log out, then come back and log in and see the item is still in the shopping basket

Given I log into my account as the Test User
And I want to go shopping
When I select Mens I will be in the mens clothing page
And my shopping basket count will be 0
When I select the sizes and products that I want from the REFINE BY side menu
|Product|Size	|Product Type	|
|Jeans	|36x30	|Straight Jeans	|
And add them to the cart 
Then my shopping basket count will be 1
Given that I log out
Then the shopping basket count will be 0
Given I log into my account again as the Test User
Then my shopping basket count will be 1
