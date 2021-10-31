@CLRegression
@AWSRegression

Feature: Agreements - Create an Eclass Agreement
  @orgAgreementEclass
  Scenario: Create an Organisation Agreement with eclass classification
    Given I log into Commerce Network as 'BUYER_ADMIN_ECLASS'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Buyer' 'Create Agreement' panel
    And On the Create Agreement page - I select Agreement 'Type' of 'Organisation agreement'
    And On the Create Agreement page - I enter Agreement 'Name' of 'CATFISH-ORG-ONLY-ECLASS'
    And On the Create Agreement page - I enter Agreement 'Start Date' of 'TODAY'
    And On the Create Agreement page - I enter Agreement 'Expiry Date' of 'FUTURE DATE'
    And On the Create Agreement page - I enter Agreement 'Contract Reference' of 'CATFISH-CREF-ECLASS'
    And On the Create Agreement page - I select Agreement 'Language' of 'English'
    And On the Create Agreement page - I select Agreement 'Currency' of 'GBP'
    And On the Create Agreement page - I enter Agreement 'Keywords' of 'organisation,release'
    And On the Create Agreement page - I enter Agreement 'Description' of 'Test Organisation Agreement ECLASS'
    And On the Create Agreement page - I save the 'Organisation' Agreement
    And On the Manage Agreement page - I enter Agreement For Supplier of 'Test For Supplier - Organisation Agreement ECLASS'
    Then On the Manage Agreement page - The Agreement 'Name' is 'CATFISH-ORG-ONLY-ECLASS'
    And On the Manage Agreement page - The Agreement 'Type' is 'Organisation agreement'
    And On the Manage Agreement page - The Agreement 'Status' is 'Draft'
    And On the Manage Agreement page - The Agreement 'Language' is 'English'
    And On the Manage Agreement page - The Agreement 'Currency' is 'GBP'
    And On the Manage Agreement page - I click on the 'Select Supplier' button
    And On the Select Supplier page - I select the Supplier called 'Catfish-RW-Supplier'
    And On the Manage Agreement page - I click on the 'Select Approval Scheme' button
    And On the Select Approval Scheme page - I select the Approval Scheme called 'testApprovalScheme'
    And On the Manage Agreement page - The Agreement 'For Supplier' is 'Test For Supplier - Organisation Agreement ECLASS'
    And On the Manage Agreement page - The Agreement 'Keywords' is 'organisation,release'
    And On the Manage Agreement page - The Agreement 'Approval Scheme' is 'Default approval scheme [Auto-approval turned on]'
    When On the Manage Agreement page - The Agreement 'Supplier' is 'Catfish-RW-Supplier'
    Then On the Manage Agreement page - The Agreement 'Name' is 'CATFISH-ORG-ONLY-ECLASS'
    And On the Manage Agreement page - The Agreement 'Contract Reference' is 'CATFISH-CREF-ECLASS'
    When On the Manage Agreement page - I click on the 'SubmitToSupplier' button
    And I log out

  @ItemTypeDeliveryItem
  Scenario: Verify if user is able to create an Eclass item
    # Background section at start of Feature gets to Item Directory page
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    And  I navigate to the internal 'Product Manager' page
    And  I click on the Product Manager 'Supplier' 'Items' submenu item
    When On the Item Directory page - I click on the 'Create' button
    And  I wait for the page refresh to complete
    And  On the Create Item page - I enter 'CATFISH-ITEM2-Eclass ' plus SessionGUID into 'SupplierItemID'
    And  On the Create Item page - I enter 'CATFISH-ITEM2 Name Eclass' into 'Name'
    And  On the Create Item page - I enter 'CATFISH-ITEM2 Description Eclass' into 'Description'
    And  On the Create Item page - I enter 'CATFISH-ITEM2 CATFISH Eclass' into 'Keywords'
#    And On the Create Item page - I click on the 'Delete UNPSC' button
#    And On the Create Item page - I click on the 'Add Classification Type' button
    And  On the Create Item page - I click on the 'Add Classification' button
    Then On the Create Item page - I check that 'UNSPSCCode' value is '10000000'
    And  On the Create Item page - I select the 'Healthcare Services' option from the 'Level1' dropdown
    And  On the Create Item page - I click on the 'Done' button
    And On the Create Item page - I click on the 'Add Classification Type Eclass' button
    And  On the Create Item page - I click on the 'Add Classification Eclass' button
    Then On the Create Item page - I check that 'UNSPSCCode' value is '16000000'
    When On the Create Item page - I select the 'eCl@ss (v11.0)' option from the 'ClassificationTypeEclass' dropdown
    And  On the Create Item page - I select the 'Food, beverage, tobacco' option from the 'Level1Eclass' dropdown
    When On the Create Item page - I select the 'Beverage' option from the 'Level2Eclass' dropdown
    When On the Create Item page - I select the 'Alcoholic beverage' option from the 'Level3Eclass' dropdown
    When On the Create Item page - I select the 'Alcoholic beverage (unspecified)' option from the 'Level4Eclass' dropdown
    When On the Create Item page - I click on the 'DoneEclass' button
    When On the Create Item page - I click on the 'Save' button
    And  I click on the Product Manager 'Supplier' 'Items' submenu item
    When On the Item Directory page - I search for 'CATFISH-ITEM2-Eclass' until found or timeout
    And  On the Item Directory page - I check that first item 'Name' value is 'CATFISH-ITEM2 Name Eclass'
    And  I log out

  @CreatePriceListEclass
  Scenario: Verify if user is able to create an Eclass Pricelist
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    And I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Supplier' 'Price Lists' submenu item
    Then I click on the Price List Directory 'Search' button
    Then I click on the Price List Directory 'Create' button
    And I enter 'NEW-PRICE-LIST-WITH-ECLASS' into Create Price List 'Name'
    And I enter 'Rip-off prices' into Create Price List 'Reference'
    And I select the 'Select Currency' option from the Create Price List 'Currency' dropdown
    And I select the 'GBP' option from the Create Price List 'Currency' dropdown
    And On the Create Price List Page - I select 'itemclassification' as 'ECLASS'
    And I wait '1' seconds before continuing
    And I click on the Create Price List 'Save' button
    And on the Manage Price List page - I verify 'Success! You added price list:' is displayed
    And I click on the Manage Price List 'Standard Items Manage' button
    And On Price list Standard Item page - I search recently created item in 'directoryInputSearch'
    And on Price list Standard Items page - I click on 'Plus' button
    And  On the Manage Price list Standard Item page - I enter '33.99' into 'Price' in row '1'
    And  On the Manage Price list Standard Item page - I enter '1' into 'NumOfUnits' in row '1'
    And  On the Manage Price list Standard Item page - I click on 'Save' button
    And I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Supplier' 'Agreements' submenu item
    When On Supplier Agreement directory page - I search recently created agreement
    Then I click on the Supplier Agreement 'Manage Icon' to view Agreement
    And  On Supplier Manage agreement page - I click on 'add' to 'add pricelist'
    And  On Attach pricelist page - I search recently created pricelist
    And On Attach pricelist page - I click on plus button to add pricelist
    Then On Supplier Manage agreement page - I click on 'publish' to 'publish agreement'
    And I log out

#  Scenario: Verify if user is able to publish the Eclass agreement using Views
#    Given I log into Commerce Network as 'BUYER_ADMIN_ECLASS'
#    When I navigate to the internal 'Product Manager' page
#    Then I click on the Product Manager 'Buyer' 'Views' submenu item
#    And On Views directory page - I click on the Views 'Published' filter
#    And On the View directory Page - I click on the first view
#    And On Manage View page - I click on 'Manage agreements' toggle button
#    When On Select view agreement page - I select agreement
#    And I add Agreement to the View
#    And I publish the View
#    Then I click on the Product Manager 'Buyer' 'Views' submenu item
#    When I select the 'Last Modified' option from the 'Sort By' dropdown
#    And On the View directory page - I click on 'cog' button
#    Then On Manage View page - I verify that the View is published
#    Then I log out
#
#  Scenario: I verify that Eclass item appears in the Marketplace
#    Given I log into Commerce Network as 'BUYER_ADMIN_ECLASS'
#    And  I navigate to the internal 'Shopping' page
#    When I click on the Shopping 'Marketplace' submenu item
#    When On the Marketplace Landing page - I enter item into 'SearchKeywords'
#    And  On the Marketplace Landing page - I click on the 'Search' button
#    Then On the Marketplace Search Results page - I check that first item is Eclass item
#    Then I log out