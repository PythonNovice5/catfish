@CLRegression
@AWSRegression

Feature: Matrix item creation in price list

  @MatrixItem
  Scenario: Create matrix item in the latest price list created
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    And I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Supplier' 'Price Lists' submenu item
    And I enter 'Catfish Price list Matrix' into Price List Directory 'Keywords'
    Then I click on the Price List Directory 'Search' button
    And I click on the Price List Directory first price list name
    And I click on the Manage Price List 'Matrix Items Manage' button
    When On Matrix directory page - I click on 'create' button
    Then On Create Matrix page - I enter 'name' as 'Catfish Matrix item'
    And On Create Matrix page - I enter 'description' as 'This is description for catfish test'
    And On Create Matrix page - I click on 'AddOptionSet' button
    And On Create Matrix page - I enter 'first attribute' as 'colour'
    And On Create Matrix page - I click on 'Add Item' button
    And On Create Matrix page - I enter 'First Item ID' as 'Matrix_item01'
    And On Create Matrix page - I click on save button
    And I select the 'Last Modified' option from the 'Sort By' dropdown
    And On Matrix directory page - I click on 'First Item Manage' button
    And On Edit Matrix page - I click on 'DeleteItem' button
    And On Edit Matrix page - I click on 'Save' button
    And On Matrix directory page - I delete recently created matrix
    And I log out

  @ContainerMatrixItem
  Scenario: Verify matrix container items
    Given I log into Commerce Network as 'BUYER_ADMIN'
    And  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    When On the Marketplace Landing page - I enter 'Matrix123' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I verify that 'FirstItemDescription' contains 'Matrix123'
    And  On the Marketplace Search Results page - I click on the first item 'Name' link
    And On the Item Details page - I check that 'ColorB' value is 'Blue'
    And On the Item Details page - I check that 'ColorR' value is 'Red'
    And On the Item Details page - I check that 'SizeS' value is 'Small'
    And On the Item Details page - I check that 'SizeM' value is 'Medium'
    And On the Item Details page - I check that 'SizeL' value is 'Large'
    And  I click on the Shopping 'Marketplace' submenu item
    When On the Marketplace Landing page - I enter 'CF53-DE0701' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I verify that 'FirstItemDescription' contains 'Blue chair small'
    And  On the Marketplace Search Results page - I click on the first item 'Name' link
    And On the Item Details page - I check that 'ColorB' value is 'Blue'
    And On the Item Details page - I check that 'ColorR' value is 'Red'
    And On the Item Details page - I check that 'SizeS' value is 'Small'
    And On the Item Details page - I check that 'SizeM' value is 'Medium'
    And On the Item Details page - I check that 'SizeL' value is 'Large'
    And I log out

  @BuyMatrixItem
  Scenario: Verify if user is able to buy a matrix item
    Given I log into Commerce Network as 'BUYER_ADMIN'
    And  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    When On the Marketplace Landing page - I click on the 'Basket' button
    And  On the Shopping Basket page - I empty the shopping basket
    And I click on the Shopping 'Marketplace' submenu item
    When On the Marketplace Landing page - I enter 'CF53-DE0701' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I verify that 'FirstItemDescription' contains 'Blue chair small'
    And  On the Marketplace Search Results page - I click on the first item 'Name' link
    And On the Item Details page - I check that 'ColorB' value is 'Blue'
    And On the Item Details page - I check that 'ColorR' value is 'Red'
    And On the Item Details page - I select 'ColorR' from the 'SelectColor' dropdown
    And On the Item Details page - I select 'SizeM' from the 'SelectSize' dropdown
    And  On the Item Details page - I click on the 'AddToBasket' button
    And On the Item Details page - I click on the 'Basket' button
    When On the Shopping Basket page - I click on the 'Checkout' button
    And  On the Requisition page - I enter 'CatfishRef-' plus DateTimeNow into 'YourReference'
    And  On the Requisition page - I enter '01-01-2020' into 'TargetDeliveryDate'
    And  On the Requisition page - I enter 'Special Instructions' into 'SpecialInstructions'
    And  On the Requisition page - I click on the 'Submit' button
    And  On the Invoice Details page - I click on the 'Send' button
    And I log out