@CLRegression
@AWSRegression
@Officedepot
Feature: Add an item from Office Depot to Marketplace Shopping Basket
  Scenario: Verifying adding an item from Office Depot to Basket
    Given I log into Commerce Network as 'BUYER_ADMIN_NONDESTRUCTIVE'
    When  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    And On the Marketplace Landing page - I click on the 'Basket' button
    When On the Shopping Basket page - I empty the shopping basket
    And  I click on the Shopping 'Marketplace' submenu item
    And  On the Marketplace Landing page - I click on the 'OfficeDepot' link
#    And On Office Depot Home page - I click on 'Diaries' under Office Supplies
    And On Office Depot Home page - I click on 'Ballpoint Pens' under Office Supplies
    And On Ballpoint Pens and Pencils Page - I enter '1' into 'BallPointPenQuantity'
    And On Ballpoint Pens and Pencils Page - I click on 'AddToBasket' button
    And On Find Your Product Page - I click on 'ShoppingBasket' button
    Then On Office Depot Shopping Basket page - I verify that 'ItemDescription' is 'BIC Cristal Original Ballpoint Pen Medium 0.32 mm Black Pack of 50'
    When On Office Depot Shopping Basket page - I click on 'Checkout' button
    When On Office Depot B2B page - I click on 'Continue' button
    Then On the Shopping Basket page - I check that first item 'Name' value is 'BIC Cristal Original Ballpoint Pen Medium 0.32 mm Black Pack of 50'
    And On the Shopping Basket page - I check that first item 'Quantity' value is '1'
    And I log out
