@TEST1
Feature: Cart adds up correctly when items are added
  The cart has no items, on adding the cheapest Jeans (36 X 30), then a shirt (XL) and then shoes (size 10). 
  The total displayed on screen should increase correctly as each item is added.
  
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
		And the cart total should be <price1>
		
	Scenario: Add Shirt
		When I select the product and size I want 
		|Product|Size	  |
		|Shirts	|XL			|
		And select the first in the list size "X-Large"
		Then the shopping basket count will be 2
		And the cart total should be <price2>
		
	Scenario: Add Shoes
		When I select the product and size I want 
		|Product|Size	  |
		|Shoes	|UK 10	|
		And select the first in the list size "UK 10"
		Then the shopping basket count will be 3
		And the cart total should be <price3>
  