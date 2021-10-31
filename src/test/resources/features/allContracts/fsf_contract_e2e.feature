@CLRegression
@FSFContract
Feature: FSF Contract end to end testing
  Scenario: Create FSF contract and submit to supplier with item attributes
    Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
    When I navigate to the internal 'Contracts' page
    Then In contract page - I click on 'create' button to create 'contract'
    Then In edit contract page - I enter 'Contract name' as 'Catfish contract'
    And In edit contract page - I enter 'Contract reference' as 'Catfish contract reference'
    And In edit contract page - I enter 'Contract Owner' as 'Catfish contract owner'
    And In edit contract page - I enter 'start date' as '0'
    And In edit contract page - I enter 'Expiry date' as '30'
    Then In edit contract page - I select 'Item Management' as 'Items are managed by the suppliers'
    Then In edit contract page - I select 'Supplier Management' as 'Supplier can be added to a published contract'
    Then In edit contract page - I enter 'Description' as 'Catfish contract description'
    Then In edit contract page - I enter 'Contract scope' as 'Catfish contract scope'
    Then In edit contract page - I click on 'add suppliers' button to 'add supplier'
    Then In the Manage suppliers page - I click on 'select suppliers' button to 'select' suppliers
    Then In the Contract supplier page - I search as 'Catfish RW'
    Then In the Contract supplier page - I select check box for Catfish-RW-Supplier
    When In the Contract supplier page - I click on 'add selected' button
    And In the Contract page - I click on 'Items' button
    Then In the Contract page - I click on 'Item Attributes' button
    Then In the Manage item page - I enter 'item attributes configuration'
    Then In the Manage item page - I click on save button
    Then In the Manage item page - I verify successful message
    When In the Contract page - I click on 'Contract' button
    When In My Contract page - I click on publish button to publish the contract
    Then In My Contract page - I confirm ok
    Then In My Contract page - I verify contract published
    And I log out

  Scenario: [item_create._contract.feature] Create FSF Contract Item
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    And  I navigate to the internal 'Product Manager' page
    And  I click on the Product Manager 'Supplier' 'Items' submenu item
    When On the Item Directory page - I click on the 'Create' button
    And  On the Create Item page - I select the 'Contract item' option from the 'Item type' dropdown
    And  I wait for the page refresh to complete
    And  On the Create Item page - I check that 'ItemType' value is 'Contract Item'
    And  On the Create Item page - I check that 'ContractChoice' value is available
    And On the Create Item page - I click on 'Select' button
    And On the Create Item page - I select 'Contract for catfish'
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
    And  On the Create Item page - I click on the 'Search' button
#    Then On the Create Item page - I check that 'ResultsShown' value is '1-5 / 5'
    And  On the Create Item page - I click on 'First' thumbnail
#    Then On the Create Item page - I check that 'AddItemsButton' value is 'Add 1 items'
#    When On the Create Item page - I click on the 'Add items' button
    And  On the Create Item page - I click on the 'Select Image' button
    When On the Create Item page - I click on 'First' thumbnail
#    Then On the Select Media page - I check that 'AddItemsButton' value is 'Add 1 items'
#    And On the Select Media page - I click on the 'Add items' button
    And On the Create Item page - I click on the 'Save' button
    And I log out

    Scenario: Verify contract details and add to RFQ
    Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
    When I navigate to the internal 'Contracts' page
    And On Contracts List page - I enter 'Catfish Contract' into 'Search'
    And On Contracts List page - I click on 'Search' button
    And On Contracts List page - I click on 'Catfish Contract' link
    Then On My Contract page - I check that 'TotalSuppliers' value is '1'
    And On My Contract page - I check that 'RegistrationProgress' value is '0'
    And On My Contract page - I check that 'Items' value is '1'
    And On My Contract page - I click on 'ViewItems' button
    And On Contracts Management Page - I navigate 'Back'
    And On My Contract page - I click on 'Sharing' button
    And On Contracts Sharing page - I select and add 'Procserve'
    And On Contracts Sharing page - I click on 'Items' button
    And On Contracts Management Page - I click on 'AddToRFQ' button
    And On Request Quote Page - I enter 'CatFishQuoteReference' into 'Your reference'
    And On Request Quote Page - I enter '27-08-2021' into 'Target Delivery Date'
    And On Request Quote Page - I enter '27-02-2024' into 'Expiration Date'
    And On Request Quote Page - I enter '12:00' into 'Expiration Time'
    And On Request Quote Page - I enter 'Catfish instructions' into 'Special Instructions'
    And On Request Quote Page - I click on 'Publish' button
    Then On Manage Request For Quote page - I verify that 'SuccessMessage' contains 'Success! You published'
    When On Manage Request For Quote page - I click on 'Back to your results'
    And On My Requests For Quote page - I sort the records by 'Date Issued'
    Then On My Requests For Quote page - I verify that 'YourReferenceFirstRecord' is 'CatFishQuoteReference'
    And I log out

#  @AccessOldContractItem
#  Scenario: Verify old contract item can be viewed
#    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
#    And  I navigate to the internal 'Product Manager' page
#    And  I click on the Product Manager 'Supplier' 'Items' submenu item
#    When On the Item Directory page - I enter 'Old contract item' into 'SearchKeywords'
#    And  On the Item Directory page - I click on the 'Search' button
#    When On the Item Directory page - I click on the 'Contract' filter
#    Then On the Item Directory page - I check that first item 'Name' value is 'Old contract item'
#    When On the Item Directory page - I click on the 'First Item Name' link
#    Then On the Edit Item page - I check that 'Name' value is 'Old contract item'
#    And I log out








