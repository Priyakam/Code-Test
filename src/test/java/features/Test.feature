Feature: Add 4 products to wishlist and verify final product in the cart
Scenario: Add 4 products to wishlist
Given I add four different products to my wish list
When I view my wishlist table
Then I find total four selected items in my wishlist
When I search for lowest price product
And I am able to add the lowest price item to my cart
Then I am able to verify the item in my cart

