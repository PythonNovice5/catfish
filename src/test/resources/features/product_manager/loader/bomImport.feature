@CLRegression
@AWSRegression
Feature: Verify BOM import
  @BOMImportValidItems
  Scenario: Verify if user is able to add items to the basket using BOM import
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    And On the Marketplace Landing page - I click on the 'Basket' button
    And On the Shopping Basket page - I empty the shopping basket
    And On the Shopping Basket page - I click on the 'Import' button
    And On the Shopping Basket page - I verify the 'ImportItems' dialog box
    And On the Shopping Basket page - I upload the xlsx file BOMImportItems.xlsx
    And On the Shopping Basket page - I click on the 'Process' button
#    And I wait '30' seconds before continuing
#    And On BOM Actions Page - I click on 'matchedFilter' radio button
#    And On BOM Actions Page - I click on 'ExpandArrow' button
#    And On BOM Actions Page - I verify that item 'BOM Item Test' is matched
#    And On BOM Actions Page - I click on 'AddToBasket' button
#    Then On the Shopping Basket page - I check that first item 'Name' value is 'BOM Item Test'
#    And I log out

  @BOMAddingDifferentCurrencyItems
  Scenario: Verify if user can add different currency items using BOM import
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    And On the Marketplace Landing page - I click on the 'Basket' button
    And On the Shopping Basket page - I empty the shopping basket
#    And On the Shopping Basket page - I click on the 'Back Link' breadcrumb
    And  I click on the Shopping 'Marketplace' submenu item
    And  On the Marketplace Landing page - I click on the 'Search' button
    And On the Marketplace Search Results page - I enter 'BOM Item Currency AUD' into 'SearchKeywords'
    And  On the Marketplace Search Results page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that first item 'Name' 'is' displayed
    And  On the Marketplace Search Results page - I check that first item 'Name' value is 'BOM Item Currency AUD'
    When  On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
    And On the Marketplace Search Results page - I click on the 'Basket' button
    And On the Shopping Basket page - I click on the 'Import' button
    And On the Shopping Basket page - I verify the 'ImportItems' dialog box
    And On the Shopping Basket page - I upload the xlsx file BOMImportItems.xlsx
    And On the Shopping Basket page - I click on the 'Process' button
    And On BOM Actions Page - I click on 'matchedFilter' radio button
    And On BOM Actions Page - I click on 'ExpandArrow' button
    And On BOM Actions Page - I verify that item 'BOM Item Test' is matched
    And On BOM Actions Page - I click on 'AddToBasketDiffCurrency' button
    And I verify that toast message 'Item with a different currency already exists in basket.' is displayed
    And I log out








