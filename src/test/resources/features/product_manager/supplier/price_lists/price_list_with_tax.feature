@CLRegression
@AWSRegression

Feature: End to end functionality of Tax

  Scenario: Create an Organisation Agreement
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Buyer' 'Create Agreement' panel
    And On the Create Agreement page - I select Agreement 'Type' of 'Organisation agreement'
    And On the Create Agreement page - I enter Agreement 'Name' of 'CATFISH-ORG-ONLY-TAX-'
    And On the Create Agreement page - I enter Agreement 'Start Date' of 'TODAY'
    And On the Create Agreement page - I enter Agreement 'Expiry Date' of 'FUTURE DATE'
    And On the Create Agreement page - I enter Agreement 'Contract Reference' of 'CATFISH-CREF-'
    And On the Create Agreement page - I select Agreement 'Language' of 'English'
    And On the Create Agreement page - I select Agreement 'Currency' of 'GBP'
    And On the Create Agreement page - I enter Agreement 'Keywords' of 'organisation,release'
    And On the Create Agreement page - I enter Agreement 'Description' of 'Test Organisation Agreement'
    And On the Create Agreement page - I save the 'Organisation' Agreement
    And On the Manage Agreement page - I enter Agreement For Supplier of 'Test For Supplier - Organisation Agreement'
    Then On the Manage Agreement page - The Agreement 'Name' is 'CATFISH-ORG-ONLY-TAX-'
    And On the Manage Agreement page - The Agreement 'Type' is 'Organisation agreement'
    And On the Manage Agreement page - The Agreement 'Status' is 'Draft'
    And On the Manage Agreement page - The Agreement 'Language' is 'English'
    And On the Manage Agreement page - The Agreement 'Currency' is 'GBP'
    And On the Manage Agreement page - I click on the 'Select Supplier' button
    And On the Select Supplier page - I select the Supplier called 'Catfish-RW-Supplier'
    And On the Manage Agreement page - I click on the 'Select Approval Scheme' button
    And On the Select Approval Scheme page - I select the Approval Scheme called 'testApprovalScheme'
    And On the Manage Agreement page - The Agreement 'For Supplier' is 'Test For Supplier - Organisation Agreement'
    And On the Manage Agreement page - The Agreement 'Keywords' is 'organisation,release'
    And On the Manage Agreement page - The Agreement 'Approval Scheme' is 'testApprovalScheme [Auto-approval turned on]'
    When On the Manage Agreement page - The Agreement 'Supplier' is 'Catfish-RW-Supplier'
    Then On the Manage Agreement page - The Agreement 'Name' is 'CATFISH-ORG-ONLY-TAX-'
    And On the Manage Agreement page - The Agreement 'Contract Reference' is 'CATFISH-CREF-'
    When On the Manage Agreement page - I click on the 'SubmitToSupplier' button
    And I log out

  @PriceListWithTax
  Scenario: Create a Product Manager Price List with Tax
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    And I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Supplier' 'Price Lists' submenu item
    Then I click on the Price List Directory 'Search' button
    Then I click on the Price List Directory 'Create' button
    And I enter 'NEW-PRICE-LIST-WITH-TAX' into Create Price List 'Name'
    And I enter 'Rip-off prices' into Create Price List 'Reference'
    And I select the 'Select Currency' option from the Create Price List 'Currency' dropdown
    And I select the 'GBP' option from the Create Price List 'Currency' dropdown
    And I enter 'Up to 70% off - just for you!' into Create Price List 'Description'
    And I enter 'Sale Special Offer' into Create Price List 'Keywords'
    And I wait '1' seconds before continuing
    And I click on the Create Price List 'Save' button
    And on the Manage Price List page - I verify 'Success! You added price list:' is displayed
    And I click on the Manage Price List 'Standard Items Manage' button
    And on Price list Standard Items page - I click on 'Plus' button
    And  On the Manage Price list Standard Item page - I enter '33.99' into 'Price' in row '1'
    And  On the Manage Price list Standard Item page - I enter '1' into 'NumOfUnits' in row '1'
    And  On the Manage Price list Standard Item page - I click on 'Plus' button
    And  On the Manage Price list Standard Item page - I enter '30.99' into 'Price' in row '2'
    And  On the Manage Price list Standard Item page - I enter '5' into 'NumOfUnits' in row '2'
    And  On the Manage Price list Standard Item page - I click on 'Plus' button
    And  On the Manage Price list Standard Item page - I enter '25.99' into 'Price' in row '3'
    And  On the Manage Price list Standard Item page - I enter '10' into 'NumOfUnits' in row '3'
    And  On the Manage Price list Standard Item page - I click on 'Save' button
    And on Price list Standard Items page - I click on 'Plus' button
    And  On the Manage Price list Standard Item page - I enter '33.99' into 'Price' in row '1'
    And  On the Manage Price list Standard Item page - I enter '1' into 'NumOfUnits' in row '1'
    And  On the Manage Price list Standard Item page - I click on 'Plus' button
    And  On the Manage Price list Standard Item page - I enter '30.99' into 'Price' in row '2'
    And  On the Manage Price list Standard Item page - I enter '5' into 'NumOfUnits' in row '2'
    And  On the Manage Price list Standard Item page - I click on 'Plus' button
    And  On the Manage Price list Standard Item page - I enter '25.99' into 'Price' in row '3'
    And  On the Manage Price list Standard Item page - I enter '10' into 'NumOfUnits' in row '3'
    And  On the Manage Price list Standard Item page - I click on 'Save' button
    And on Price list Standard Items page - I click on 'Done' button
    And On the Manage Price list Item page - I select 'TaxType' as 'VAT'
    And On the Manage Price list Item page - I select 'TaxTerritory' as 'United Kingdom'
    And I click on the Manage Price List 'Standard Items Manage' button
    And on Price list Standard Items page - I click on 'UpdateItem1' button
    And On the Manage Price list Update Item Directory page - I select 'TaxCode' as 'Standard20%'
    And On the Manage Price list Update Item Directory page - I click on 'Save' button
    And on Price list Standard Items page - I click on 'UpdateItem2' button
    And On the Manage Price list Update Item Directory page - I select 'TaxCode' as 'Standard20%'
    And On the Manage Price list Update Item Directory page - I click on 'Save' button
    And on Price list Standard Items page - I click on 'Done' button
    And I click on the Product Manager 'Supplier' 'Agreements' submenu item
    When On Supplier Agreement directory page - I search recently created agreement
    Then I click on the Supplier Agreement 'Manage Icon' to view Agreement
    And  On Supplier Manage agreement page - I click on 'add' to 'add pricelist'
    And  On Attach pricelist page - I search recently created pricelist
    And On Attach pricelist page - I click on plus button to add pricelist
    Then On Supplier Manage agreement page - I click on 'publish' to 'publish agreement'
    And I log out

#  Scenario: [View Create] Verify if user is able to create and publish the view
#    Given I log into Commerce Network as 'BUYER_ADMIN'
#    When I navigate to the internal 'Product Manager' page
#    Then I click on the Product Manager 'Buyer' 'Views' submenu item
#    And On the View directory page - I enter 'Tax view' into 'SearchKeywords'
#    And On the View directory page - I click on 'Search' button
#    And On the View directory page - I click on 'cog' button
#    And On Manage View page - I click on 'Manage agreements' toggle button
#    When On Select view agreement page - I select agreement
#    And I add Agreement to the View
#    And I publish the View
#    When I select the 'Last Modified' option from the 'Sort By' dropdown
#    And On the View directory page - I click on 'cog' button
#    Then On Manage View page - I verify that the View is published
#    Then I log out
#
#   @VerifyTaxInMp
#  Scenario: Verify tax in market place
#      Given I log into Commerce Network as 'BUYER_ADMIN'
#      And  I navigate to the internal 'Shopping' page
#      And  I click on the Shopping 'Marketplace' submenu item
#      And On the Marketplace Landing page - I click on the 'Basket' button
#      And On the Shopping Basket page - I empty the shopping basket
#      And  I click on the Shopping 'Marketplace' submenu item
#      And  On the Marketplace Landing page - I click on the 'Search' button
#      When On the Marketplace Search Results page - I enter 'Item1' into 'SearchKeywords'
#      And  On the Marketplace Search Results page - I click on the 'Search' button
#      Then On the Marketplace Search Results page - I check that first item 'ItemID' value is 'Item1'
#      Then On the Marketplace Search Results page - I check that 'TaxPercent' value is '20'
#      When On the Marketplace Search Results page - I click on the 'SearchClear' button
#      When On the Marketplace Search Results page - I enter 'Item2' into 'SearchKeywords'
#      And  On the Marketplace Search Results page - I click on the 'Search' button
#      Then On the Marketplace Search Results page - I check that first item 'ItemID' value is 'Item2'
#      Then On the Marketplace Search Results page - I check that 'TaxPercent' value is '20'
#      And I log out