@CLRegression
@AWSRegression
@GroupsE2E
Feature: Test end to end functionality of sharing through Groups

  Scenario: Create a Shared Agreement
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Buyer' 'Create Agreement' panel
    And On the Create Agreement page - I select Agreement 'Type' of 'Organisation agreement'
    And On the Create Agreement page - I enter Agreement 'Name' of 'CATFISH-ORG-SHARED-'
    And On the Create Agreement page - I enter Agreement 'Start Date' of 'TODAY'
    And On the Create Agreement page - I enter Agreement 'Expiry Date' of 'FUTURE DATE'
    And On the Create Agreement page - I enter Agreement 'Contract Reference' of 'CATFISH-CREF-'
    And On the Create Agreement page - I select Agreement 'Language' of 'English'
    And On the Create Agreement page - I select Agreement 'Currency' of 'GBP'
    And On the Create Agreement page - I enter Agreement 'Keywords' of 'shared,release'
    And On the Create Agreement page - I enter Agreement 'Description' of 'Test Shared Agreement'
    And On the Create Agreement page - I save the 'shared' Agreement
    And On the Manage Agreement page - I click on the 'Select Supplier' button
    And On the Select Supplier page - I select the Supplier called 'Catfish-RW-Supplier'
    And On the Manage Agreement page - I click on the 'Select Approval Scheme' button
    And On the Select Approval Scheme page - I select the Approval Scheme called 'testApprovalScheme'
    Then On the Manage Agreement page - The Agreement 'Name' is 'CATFISH-ORG-SHARED-'
    And On the Manage Agreement page - The Agreement 'Contract Reference' is 'CATFISH-CREF-'
    When On the Manage Agreement page - I click on the 'SubmitToSupplier' button
    And I log out

  Scenario: Create standard item, pricelist and attach to agreement and publish to buyer
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    And  I navigate to the internal 'Product Manager' page
    And  I click on the Product Manager 'Supplier' 'Items' submenu item
    And On the Item Directory page - I click on the 'Create' button
    And  On the Create Item page - I enter 'CATFISH-ITEM1-' plus SessionGUID into 'SupplierItemID'
    And  On the Create Item page - I enter 'CATFISH-ITEM1 Name' into 'Name'
    And  On the Create Item page - I enter 'CATFISH-ITEM1 Description' into 'Description'
    And  On the Create Item page - I enter 'CATFISH-ITEM1 CATFISH' into 'Keywords'
    And  On the Create Item page - I check that 'ComparisonUOM' value is 'Each'
    And  On the Create Item page - I enter '1' into 'ComparisonScale'
    And  On the Create Item page - I click on the 'Add Classification' button
    When On the Create Item page - I select the 'UNSPSC (v8)' option from the 'ClassificationType' dropdown
    Then On the Create Item page - I check that 'UNSPSCCode' value is '10000000'
    And  On the Create Item page - I select the 'Healthcare Services' option from the 'Level1' dropdown
    And  On the Create Item page - I click on the 'Done' button
    And On the Create Item page - I click on the 'Save' button
    And I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Supplier' 'Price Lists' submenu item
    Then I click on the Price List Directory 'Search' button
    Then I click on the Price List Directory 'Create' button
    And I enter 'NEW-PRICE-LIST' into Create Price List 'Name'
    And I enter 'Rip-off prices' into Create Price List 'Reference'
    And I select the 'Select Currency' option from the Create Price List 'Currency' dropdown
    And I select the 'GBP' option from the Create Price List 'Currency' dropdown
    And I enter 'Up to 70% off - just for you!' into Create Price List 'Description'
    And I enter 'Sale Special Offer' into Create Price List 'Keywords'
    And I wait '1' seconds before continuing
    And I click on the Create Price List 'Save' button
    And on the Manage Price List page - I verify 'Success! You added price list:' is displayed
    And I click on the Manage Price List 'Delivery Items Manage' button
    And I wait '1' seconds before continuing
    Then I click on the Price List Directory 'Plus' button
    And  On the Manage Price list Item page - I enter '7.99' into 'Price'
    And On Manage Price list Item page - I click on 'Save' button
    And I click on the Price List Directory 'Done' button
    And I click on the Manage Price List 'Standard Items Manage' button
    And On Price list Standard Item page - I search recently created item in 'directoryInputSearch'
    And I wait '1' seconds before continuing
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

   Scenario: Verify pricelist published from supplier
     Given I log into Commerce Network as 'BUYER_ADMIN'
     When I navigate to the internal 'Product Manager' page
     And I click on the Product Manager 'Buyer' 'Agreements' submenu item
     And On Buyer Agreement directory page - I search recently created agreement
     And On Buyer Agreement directory page - I click on cog to manage agreement
     And On Buyer Manage agreement page - I verify pricelist attached
     When I navigate to the internal 'Product Manager' page
     And I click on the Product Manager 'Buyer' 'Create Group' panel
     And  On the Create Group page - I enter 'Group Name' as 'Catfish group'
     And  On the Create Group page - I enter 'My description' as 'Catfish group description'
     And  On the Create Group page - I click on save and continue
     And  On the Manage group page - I click on cog to select 'members' for the group
     When  On the Manage Group page - I search 'Catfish-NDT-BUYER' in 'directoryInputSearch'
     Then  On the Manage Group Members Page - I select member to share
     And  On the Manage Group Members Page - I click on Done
     And  On the Manage group page - I click on cog to select 'resources' for the group
     And   On the Manage resources page - I search shared agreement
     And  On the Manage resources page - I select Agreement to share
     And  On the Manage resources page - I click on Done
     And  On the Manage Group page - I click on Publish
     And  I log out

  Scenario: As a group member publish the shared agreement on adding to the view
    Given I log into Commerce Network as 'BUYER_ADMIN_NONDESTRUCTIVE'
    When I navigate to the internal 'Product Manager' page
    And  I click on the Product Manager 'Buyer' 'Groups' submenu item
    Then On Group directory page - I search shared group
    Then On Group directory page - I click on search button
#    And  On Group directory page - I click accept button
    When On Group directory page - I click on eye to view shared agreements
    Then On View group agreements page - I verify shared agreements
    Then I click on the Product Manager 'Buyer' 'Views' submenu item
    And On the View directory page - I enter 'Shared view' into 'SearchKeywords'
    And On the View directory page - I click on 'Search' button
    And On the View directory page - I click on 'cog' button
    And On Manage View page - I click on 'Manage agreements' toggle button
    When On Select view agreement page - I select agreement
    And I add Agreement to the View
    And I publish the View
    And On the View directory page - I enter 'Shared view' into 'SearchKeywords'
    And On the View directory page - I click on 'Search' button
    And On the View directory page - I click on 'cog' button
    Then On Manage View page - I verify that the View is published
    Then I log out

  Scenario: I verify shared item is appears in the Marketplace
    Given I log into Commerce Network as 'BUYER_ADMIN_NONDESTRUCTIVE'
    And  I navigate to the internal 'Shopping' page
    When I click on the Shopping 'Marketplace' submenu item
    When On the Marketplace Landing page - I enter item into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that first item is shared item
    Then I log out

  Scenario: As a group member publish the shared agreement on adding to the view
    Given I log into Commerce Network as 'BUYER_ADMIN_NONDESTRUCTIVE'
    When I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Buyer' 'Views' submenu item
    And On the View directory page - I enter 'Shared view' into 'SearchKeywords'
    And On the View directory page - I click on 'Search' button
    And On the View directory page - I click on 'cog' button
    And On Manage View page - I click on 'Manage agreements' toggle button
    When On Select view agreement page - I select agreement
    And I remove recently added Agreement to the View
    And I publish the View
    And On the View directory page - I enter 'Shared view' into 'SearchKeywords'
    And On the View directory page - I click on 'Search' button
    And On the View directory page - I click on 'cog' button
    Then On Manage View page - I verify that the View is published
    Then I log out





