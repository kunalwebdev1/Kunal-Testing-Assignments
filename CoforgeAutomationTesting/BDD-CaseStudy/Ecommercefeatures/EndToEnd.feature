Feature: Myntra E-Commerce Application Automation Testing

Scenario: Customer Registration
Given User should open Chrome Browser
When User should enter URL "https://www.myntra.com/" in the browser
Then User should click on the Profile icon
And User should click on the Sign Up option
And User should enter a valid Mobile Number
And User should click on the Continue button
Then User should verify that the OTP Verification page is displayed

Scenario: Customer Login
Given User should open Chrome Browser
When User should enter URL "https://www.myntra.com/" in the browser
Then User should click on the Profile icon
And User should enter the registered Mobile Number
And User should click on the Continue button
Then User should verify that the OTP Verification page is displayed

Scenario: Product Search
Given User should open Chrome Browser
When User should enter URL "https://www.myntra.com/" in the browser
Then User should enter "Men T-Shirt" into the Search field
And User should press the Enter key
Then User should verify that the relevant products are displayed

Scenario: View Product Details
Given User should open Chrome Browser
When User should enter URL "https://www.myntra.com/" in the browser
Then User should search for "Men T-Shirt"
And User should click on the first product
Then User should verify that the Product Details page is displayed

Scenario: Add Product to Shopping Bag
Given User should open Chrome Browser
When User should enter URL "https://www.myntra.com/" in the browser
Then User should search for "Men T-Shirt"
And User should click on the first product
And User should select the required size
And User should click on the ADD TO BAG button
Then User should verify that the product is added to the Shopping Bag

Scenario: Update Shopping Bag
Given User should open Chrome Browser
When User should enter URL "https://www.myntra.com/" in the browser
Then User should navigate to the Shopping Bag
And User should update the product quantity
Then User should verify that the updated quantity is displayed
And User should verify that the total amount is updated

Scenario: Remove Product from Shopping Bag
Given User should open Chrome Browser
When User should enter URL "https://www.myntra.com/" in the browser
Then User should navigate to the Shopping Bag
And User should click on the Remove button
Then User should verify that the product is removed from the Shopping Bag

Scenario: Add Product to Wishlist
Given User should open Chrome Browser
When User should enter URL "https://www.myntra.com/" in the browser
Then User should search for "Men T-Shirt"
And User should click on the first product
And User should click on the WISHLIST button
Then User should verify that the product is added to the Wishlist

Scenario: Checkout
Given User should open Chrome Browser
When User should enter URL "https://www.myntra.com/" in the browser
Then User should navigate to the Shopping Bag
And User should click on the PLACE ORDER button
Then User should verify that the Address page is displayed

Scenario: Payment
Given User should complete the Checkout process
When User should select a payment method
And User should click on the Continue button
Then User should verify that the Payment page is displayed

Scenario: Order Confirmation
Given User should complete the payment successfully
When User should place the order
Then User should verify that the Order Confirmation page is displayed
And User should verify that an Order ID is generated

Scenario: Order History
Given User should be logged in to the Myntra website
When User should click on the Profile icon
And User should click on the Orders option
Then User should verify that the Order History page is displayed

Scenario: Customer Logout
Given User should be logged in to the Myntra website
When User should click on the Profile icon
And User should click on the Logout option
Then User should verify that the user is logged out successfully