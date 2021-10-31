
Feature: Creating Items by Supplier  -  Delivery item, Contract item

  Background: This is performed before each Scenario
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    And  I navigate to the internal 'Product Manager' page
    And  I click on the Product Manager 'Supplier' 'Items' submenu item

  @CLRegression
  @AWSRegression
  @ItemTypeDeliveryItem
  Scenario: [item_create.feature] Create a new (Item type) delivery item
    # Background section at start of Feature gets to Item Directory page
    When On the Item Directory page - I click on the 'Create' button
    And  On the Create Item page - I select the 'Delivery item' option from the 'Item type' dropdown
    And  I wait for the page refresh to complete
    # Enter/select details:
    And  On the Create Item page - I select the 'Item' option from the 'Delivery type' dropdown
    And  On the Create Item page - I enter 'CATFISH-ITEM2-' plus SessionGUID into 'SupplierItemID'
    And  On the Create Item page - I enter 'CATFISH-ITEM2 Name' into 'Name'
    And  On the Create Item page - I enter 'CATFISH-ITEM2 Description' into 'Description'
    And  On the Create Item page - I enter 'CATFISH-ITEM2 CATFISH' into 'Keywords'
    # UNSPSC Classification
    And  On the Create Item page - I click on the 'Add Classification' button
    Then On the Create Item page - I check that 'UNSPSCCode' value is '10000000'
    When On the Create Item page - I select the 'UNSPSC (v18)' option from the 'ClassificationType' dropdown
    When On the Create Item page - I enter '78102205' into 'UNSPSCCode'
    And  On the Create Item page - I click on the 'Done' button
    # Save it
    When On the Create Item page - I click on the 'Save' button
    # Check that it is now in the database:
    And  I click on the Product Manager 'Supplier' 'Items' submenu item
    # Need to use the following step because updating of search index is not immediate
    When On the Item Directory page - I search for 'CATFISH-ITEM2' until found or timeout
    And  On the Item Directory page - I check that first item 'Name' value is 'CATFISH-ITEM2 Name'
    And  On the Item Directory page - I check that first item 'ItemType' value is 'Delivery'
    And  On the Item Directory page - I check that first item 'Description' value is 'CATFISH-ITEM2 Description'
    And  On the Item Directory page - I check that first item 'Status' value is 'New'
    # Tidy-up by removing the newly created item:
    When On the Item Directory page - I click on the 'First Item Name' link
    Then On the Edit Item page - I check that 'Name' value is 'CATFISH-ITEM2 Name'
    And  On the Edit Item page - I click on the 'Select Image' button
    When On the Edit Item page - I click on 'First' thumbnail
#    When On the Edit Item page - I click on the 'Add items' button
    When On the Edit Item page - I click on the 'Save' button
    Then On the Edit Item page - I check that 'HeaderAlertMessage' 'is' displayed
    And  On the Edit Item page - I check that 'HeaderAlertMessage' value is 'Success! You have updated CATFISH-ITEM2 Name'
    When On the Edit Item page - I click on the 'Delete' button
    And  I log out


  @CLRegression
  @AWSRegression
  @BasketTypeDeliveryItem
  Scenario: [item_create.feature] Create a new (Basket type) delivery item
    # Background section at start of Feature gets to Item Directory page
    When On the Item Directory page - I click on the 'Create' button
    And  On the Create Item page - I select the 'Delivery item' option from the 'Item type' dropdown
    And  I wait for the page refresh to complete
    # Enter/select details:
    And  On the Create Item page - I select the 'Basket' option from the 'Delivery type' dropdown
    And  On the Create Item page - I select the 'Price' option from the 'Delivery Basket Attribute' dropdown
    And  On the Create Item page - I enter 'CATFISH-ITEM3-' plus SessionGUID into 'SupplierItemID'
    And  On the Create Item page - I enter 'CATFISH-ITEM3 Name' into 'Name'
    And  On the Create Item page - I enter 'CATFISH-ITEM3 Description' into 'Description'
    And  On the Create Item page - I enter 'CATFISH-ITEM3 CATFISH' into 'Keywords'
    # UNSPSC Classification
    And  On the Create Item page - I click on the 'Add Classification' button
    Then On the Create Item page - I check that 'UNSPSCCode' value is '10000000'
    When On the Create Item page - I select the 'UNSPSC (v19)' option from the 'ClassificationType' dropdown
    And  On the Create Item page - I select the 'Transportation and Storage and Mail Services' option from the 'Level1' dropdown
    When On the Create Item page - I select the 'Mail and cargo transport' option from the 'Level2' dropdown
    When On the Create Item page - I select the 'Postal and small parcel and courier services' option from the 'Level3' dropdown
    When On the Create Item page - I select the 'Letter or small parcel local delivery services' option from the 'Level4' dropdown
    When On the Create Item page - I click on the 'Done' button
#    Then On the Create Item page - I check that 'UNSPSCCode' value is '78102205'

    And  On the Create Item page - I click on the 'Save' button
    # Check that it is now in the database:
    And  I click on the Product Manager 'Supplier' 'Items' submenu item
    # Need to use the following step because updating of search index is not immediate
    When On the Item Directory page - I search for 'CATFISH-ITEM3' until found or timeout
#    Then On the Item Directory page - I check that 'ResultsShownTop' value is '1-1 / 1'
    And  On the Item Directory page - I check that first item 'Name' value is 'CATFISH-ITEM3 Name'
    And  On the Item Directory page - I check that first item 'ItemType' value is 'Delivery'
    And  On the Item Directory page - I check that first item 'Description' value is 'CATFISH-ITEM3 Description'
    And  On the Item Directory page - I check that first item 'Status' value is 'New'
    And On the Item Directory page - I select the 'Newest' option from the 'Order By' dropdown
    And  On the Item Directory page - I check that first item 'ItemID' value is 'CATFISH-ITEM3-' plus SessionGUID

#    And  On the Item Directory page - I check that first item 'ItemID' value is as expected
    # Tidy-up by removing the newly created item:
    When On the Item Directory page - I click on the 'First Item Name' link
    Then On the Edit Item page - I check that 'Name' value is 'CATFISH-ITEM3 Name'
    And  On the Edit Item page - I click on the 'Select Image' button
    And I wait '1' seconds before continuing
    When On the Edit Item page - I click on 'First' thumbnail
#    When On the Select Media page - I click on the 'Add items' button
    When On the Edit Item page - I click on the 'Save' button
    Then On the Edit Item page - I check that 'HeaderAlertMessage' 'is' displayed
    And  On the Edit Item page - I check that 'HeaderAlertMessage' value is 'Success! You have updated CATFISH-ITEM3 Name'
    When On the Edit Item page - I click on the 'Delete' button
    And  I log out

  @CLRegression
  @ContractItem
  Scenario: [item_create._contract.feature] Create FSF Contract Item
    When On the Item Directory page - I click on the 'Create' button
    And  On the Create Item page - I select the 'Contract item' option from the 'Item type' dropdown
    And  I wait for the page refresh to complete
    And  On the Create Item page - I check that 'ItemType' value is 'Contract Item'
    And  On the Create Item page - I check that 'ContractChoice' value is available
    And On the Create Item page - I click on 'Select' button
    And On the Create Item page - I select 'Catfish contract'
    And On the Create Item page - I select '4.1: Literacy / numeracy / ESOL'
    And On the Create Item page - I select 'People aged 18-24'
    And On the Create Item page - I click on 'Edit' button
    And On the Create Item page - I click on the 'London & Home Counties' Checkbox
    And On the Create Item page - I click on 'Done' button
    And  On the Create Item page - I select the 'Group / Course / Workshop' option from the 'Claimant engagement' dropdown
    And  On the Create Item page - I select the '1-10' option from the 'Minimum number of claimants' dropdown
    And  On the Create Item page - I enter '10' into 'Maximum group size'
    And  On the Create Item page - I select the 'Up to 14 days' option from the 'Lead time' dropdown
    And  On the Create Item page - I enter '175.00' into 'Unit price for 1 participant'
    And  On the Create Item page - I enter '165.00' into 'UnitPrice_2_10_Participants'
    And  On the Create Item page - I enter '160.00' into 'UnitPrice_11_20_Participants'
    And  On the Create Item page - I enter 'CATFISH-ITEM1-' plus SessionGUID into 'SupplierItemID'
    And  On the Create Item page - I enter 'CATFISH-ITEM1 Name' into 'Name'
    And  On the Create Item page - I enter 'CATFISH-ITEM1 Description' into 'Description'
    And  On the Create Item page - I enter 'CATFISH-ITEM1 CATFISH' into 'Keywords'
    When On the Create Item page - I click on the 'Add Linked Media' button
    And  On the Create Item page - I check that 'PDFPageTitle' value is 'Select PDF from Media Directory'
#    And  On the Select Media page - I check that 'AddItemsButton' value is 'Add 0 items'
    When On the Create Item page - I enter 'catfishpdf' into 'SearchKeywords'
    And On the Create Item page - I click on 'Search' button
#    And  On the Select Media page - I click on the 'Search' button
#    Then On the Select Media page - I check that 'ResultsShown' value is '1-5 / 5'
    And  On the Create Item page - I click on 'First' thumbnail
#    Then On the Select Media page - I check that 'AddItemsButton' value is 'Add 1 items'
#    When On the Select Media page - I click on the 'Add items' button
    And  On the Create Item page - I click on the 'Select Image' button
    When On the Create Item page - I click on 'First' thumbnail
#    Then On the Select Media page - I check that 'AddItemsButton' value is 'Add 1 items'
#    And On the Select Media page - I click on the 'Add items' button
    And On the Create Item page - I click on the 'Save' button
    And On the Edit Item page - I click on the 'Delete' button
    And I log out













