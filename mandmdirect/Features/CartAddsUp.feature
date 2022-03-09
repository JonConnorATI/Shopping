Feature: Cart adds up correctly when items are added. Cart is cached and remebers what was previously in it.
  
  The cart has no items, on adding the cheapest Jeans (36 X 30), then a shirt (XL) and then shoes (size 10). 
  The total displayed on screen should increase correctly as each item is added. 
  
  The items are then removed one at a time and the total should decrease correctly as each item is removed. 
  
  Background:
	Given I log into my account as the Test User
	And I want to go shopping
	When I select Mens I will be in the mens clothing page
	
  Scenario: Add Jeans 
		When I select the product and size I want
		|Product|Size	  |
		|Jeans	|36x30	|
		And select the first in the list size "Waist 36"
		Then the shopping basket count will be 1
		And the cart total should be price 1
		
	Scenario: Add Shirt
		When I select the product and size I want 
		|Product|Size	  |
		|Shirts	|XL			|
		And select the first in the list size "X-Large"
		Then the shopping basket count will be 2
		And the cart total should be price 2
		
	Scenario: Add Shoes
		When I select the product and size I want 
		|Product|Size	  |
		|Shoes	|UK 10	|
		And select the first in the list size "UK 10"
		Then the shopping basket count will be 3
		And the cart total should be price 3
		
	Scenario: Remove Jeans
		Given that I clear the basket 
		Then the shopping basket count will be 2
		And the cart total should be price 2
		
	Scenario: Remove Shirt
		Given that I clear the basket 
		Then the shopping basket count will be 1
		And the cart total should be price 1
		
	Scenario: Remove shoes
		Given that I clear the basket 
		Then the shopping basket count will be 0
		
  