@BuyTemplatedItem
@CLRegression
@AWSRegression
Feature: Marketplace - Buy supplier Templated Item
  Scenario:  Validates the buying of Templated Item from Market place
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    And On the Marketplace Landing page - I click on the 'Basket' button
    Then On the Shopping Basket page - I empty the shopping basket
    When  I click on the Shopping 'Marketplace' submenu item
    And On the Marketplace Landing page - I enter 'CATFISH-ITEM1-5C51FF9205CC0E0A244' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
    Then  On the Marketplace Search Results page - I check that 'ItemOptions' 'is' displayed
    When  On the Marketplace Search Results page - I enter 'CATFISHVarNewValue' into 'CatfishLabel1'
    And  On the Marketplace Search Results page - I enter 'CATFISHVarNewValue2' into 'CatfishLabel2'
    And On the Marketplace Search Results page - I click on the 'AddInformation' button
    And On the Marketplace Search Results page - I click on the 'Basket' button
    Then  On the Shopping Basket page - I check that 'PageTitle' value is 'My Basket'
    And  On the Shopping Basket page - I check that 'ItemID' value is 'CATFISHVarNewValue2'
    And I log out


  @BMCBuyTemplatedItem
  Scenario:  Verify BMC template item can be added to basket
    Given I log into Commerce Network as 'BUYER_ADMIN_NONDESTRUCTIVE'
    When  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    And On the Marketplace Landing page - I click on the 'Basket' button
    Then On the Shopping Basket page - I empty the shopping basket
    When  I click on the Shopping 'Marketplace' submenu item
    And On the Marketplace Landing page - I enter 'AutomationTemplateItem01' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
    And On the Marketplace Search Results page - I click on the 'AddInformation' button
    And On the Marketplace Search Results page - I click on the 'Basket' button
    Then  On the Shopping Basket page - I check that 'PageTitle' value is 'My Basket'
    And  On the Shopping Basket page - I check that 'ItemID' value is 'sku1010'
    Then On the Shopping Basket page - I verify template customisations
    And I log out