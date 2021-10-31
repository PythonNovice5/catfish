@CLRegression
@AWSRegression
@UpdatePublishedItem

Feature: Verify already publish items can be updated and publish to Marketplace

 Scenario: Verify if published items can be updated

    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Supplier' 'Price Lists' submenu item
    #And I enter 'Catfish BMECat v5.3' into Price List Directory 'Search'
    And I enter 'catfishtest' into Price List Directory 'Search'
    Then I click on the Price List Directory 'Search' button
    And I click on the Price List Directory first price list name
    And I click on the Manage Price List 'Standard Items Manage' button
    And On Price list Standard Items page - I enter 'CatfishItemNewDontDelete' into 'InputSearch'
    And on Price list Standard Items page - I click on 'Search' button
    And on Price list Standard Items page - I click on 'EditFirstItem' button
    And On the Manage Price list Update Item Directory page - I enter '500' into 'Price' in row '1' to update
    And On the Manage Price list Update Item Directory page - I click on 'Save' button
    And on Price list Standard Items page - I click on 'Done' button
    And I click on the Manage Price List 'Publish' button
    And I log out

  Scenario: [Verify Updated Published Item] Verify if the published item is updated in market

    Given I log into Commerce Network as 'BUYER_ADMIN'
#    When I navigate to the internal 'Product Manager' page
    And  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    And On the Marketplace Landing page - I click on the 'Basket' button
    And On the Shopping Basket page - I empty the shopping basket
    And  I click on the Shopping 'Marketplace' submenu item
    And  On the Marketplace Landing page - I click on the 'Search' button
    When On the Marketplace Search Results page - I enter 'CatfishItemNewDontDelete' into 'SearchKeywords'
    And  On the Marketplace Search Results page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I click on the 'Search' button
    And I wait '1' seconds before continuing
    When On the Marketplace Search Results page - I select the 'Date (newest to oldest)' option from the 'Order By' dropdown
    And I wait '1' seconds before continuing
    Then On the Marketplace Search Results page - I check that first item 'Price' value is 'UpdatedPrice'
    And I log out

