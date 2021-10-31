@CLRegression
@AWSRegression
@AmazonPunchOut
Feature: Marketplace - Amazon Punchout from Marketplace
  Scenario: Validates Amazon Punchout from Marketplace
    Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
    When  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    When On the Marketplace Landing page - I click on the 'Basket' button
    When On the Shopping Basket page - I empty the shopping basket
    And  I click on the Shopping 'Marketplace' submenu item
    And  On the Marketplace Landing page - I click on the 'AmazonForBusiness' link
    And On the Amazon Business page - I enter 'Amazon Basics Banded Bath Mat Black' into 'searchBoxAmazon'
    And On the Amazon Business page - I click on the 'Search' button
    And On the Amazon Search Product Page - I click on 'ProductToBeAdded'
    Then On the Amazon Product Page - I verify that the product 'is' dispatched by Amazon
    When On the Amazon Product Page - I click on 'AddToBasket' button
    And On the Amazon Shopping Basket page - I enter 'Tetley One Cup Tea Bags Catering Pack (Pack of 1100)' into 'searchBoxAmazonShoppingBasketPage'
    When On the Amazon Shopping Basket page - I click on 'Search' button
    And On the Amazon Search Product Page - I click on 'ProductToBeAdded2'
    Then On the Amazon Product Page - I verify that the product 'isNot' dispatched by Amazon
    When On the Amazon Product Page - I click on 'AddToBasket' button
    And On the Amazon Shopping Basket page - I click on 'SubmitForApproval' button
    Then On the Shopping Basket page - I check that 'Tetley One Cup Tea Bags Catering Pack (Pack of 1100)' is not available
    Then On the Shopping Basket page - I check that 'CheckoutButton' 'is' disabled
    When On the Shopping Basket page - I remove the unavailable item
    And I wait '1' seconds before continuing
    Then On the Shopping Basket page - I check that 'CheckoutButton' 'isNot' disabled
    And  On the Shopping Basket page - I empty the shopping basket
    And I log out

