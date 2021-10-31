@CLRegression
@AWSRegression
@DoublePunchOut
Feature: Marketplace double punchout functionality and verify shopping basket return

  Scenario: [punchout.feature] Validates Double Punchout from Marketplace
    Given I log into POTT
    When On Punchout Home page - I click on 'SUBMIT' link for 'CXML Regression'
    And On the Marketplace Landing page - I click on the 'Basket' button
    And On the Shopping Basket page - I empty the shopping basket
    And On the Shopping Basket page - I click on the 'Home' breadcrumb
    And  On the Marketplace Landing page - I click on the 'DPO TO JUPITER' link
    And  On the Marketplace Landing page Jupiter - I click on the 'Search' button
    When On the Marketplace Search Results page Jupiter - I click on the 'Basket' button
    Then On the Shopping Basket page Jupiter - I empty the shopping basket
    And  On the Shopping Basket page Jupiter - I click on the 'Back Link' breadcrumb
    When On the Marketplace Search Results page Jupiter - I enter 'TestItemCatfishforCxmlDontDel' into 'SearchKeywords'
    And On the Marketplace Search Results page Jupiter - I click on the 'Search' button
    And On the Marketplace Search Results page Jupiter - I click on the first item 'AddToBasket' button
    And On the Marketplace Search Results page Jupiter - I click on the 'Basket' button
    And On the Shopping Basket page Jupiter - I store the item details
    And I wait '1' seconds before continuing
    When On the Shopping Basket page Jupiter - I click on the 'CheckoutInternalSite' button
    And I wait '1' seconds before continuing
    And On the Shopping Basket page - I click on the 'CheckoutPO' button
    Then On Punchout Test Tool Checkout Page - I verify Item details