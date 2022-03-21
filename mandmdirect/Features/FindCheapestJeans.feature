Feature: Find the cheapest pair of Jeans

Find the cheapest pair of jeans and verify the 1st item in the list has the lowest price

Scenario: Search for Jeans, Mens, straight fit, 36in wasit, 30in leg and sort by lowest price
Given I open the website I will be in the landing page
When I select Mens I will be in the mens clothing page
When I select the sizes and products that I want from the REFINE BY side menu
|Product|Size	|Product Type	|
|Jeans	|36x30	|Straight Jeans	|
And I sort by the lowest price
Then the 1st product in the list has the lowest or equal lowest price



