Feature: The shopping basket is cached

An item is added to the cart and I leave, when I come back the item should still be in the cart.
This user starts with an empty cart, adds an item, logs out, logs back in and cart still has the item, then deletes the cart so it is empty again.

Scenario: Add an item to shopping basket, log out, then come back and log in and see the item is still in the shopping basket

Given I log into my account as the Test User
And I want to go shopping
When I select Mens I will be in the mens clothing page
Then the shopping basket count will be 0
When I select the sizes and products that I want from the REFINE BY side menu
|Product|Size	|Product Type	|
|Jeans	|36x30	|Straight Jeans	|
And add them to the cart 
Then the shopping basket count will be 1
Given that I log out
Then the shopping basket count will be 0
Given I log into my account again as the Test User
Then the shopping basket count will be 1
Given that I clear the basket 
Then the shopping basket count will be 0
