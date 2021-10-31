@CLRegression
@AWSRegression

@FrameworkAgreement
Feature: Create framework agreement,Publish to Marketplace and raise a Quote
  Scenario: Create a Framework Agreement
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    And On the Marketplace Landing page - I click on the 'Basket' button
    When On the Shopping Basket page - I empty the shopping basket
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Buyer' 'Create Agreement' panel
    And On the Create Agreement page - I select Agreement 'Type' of 'Framework Agreement'
    And On the Create Agreement page - I enter Agreement 'Name' of 'CATFISH-Framework-'
    And On the Create Agreement page - I enter Agreement 'Start Date' of 'TODAY'
    And On the Create Agreement page - I enter Agreement 'Expiry Date' of 'FUTURE DATE'
    And On the Create Agreement page - I enter Agreement 'Contract Reference' of 'CATFISH-Framework-'
    And On the Create Agreement page - I select Agreement 'Language' of 'English'
    And On the Create Agreement page - I select Agreement 'Currency' of 'GBP'
    And On the Create Agreement page - I enter Agreement 'Keywords' of 'framwork,release'
    And On the Create Agreement page - I enter Agreement 'Description' of 'Test framework Agreement'
    And On the Create Agreement page - I save the 'framework' Agreement
    And On the Manage Agreement page - I click on the 'importItemFramework' button
    And On Content Upload Page - I upload the Frameworkcsv file Framework Items.csv
    And On the Manage Agreement page - I click on the 'Approve' button
    And I log out

  Scenario: Publish the Framework Agreement
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Buyer' 'Views' submenu item
    And On the View directory page - I enter 'FrameworkAgreementCatfishView' into 'SearchKeywords'
    And On the View directory page - I click on 'Search' button
#    And On the View directory page - I search for View
    And On the View directory Page - I click on the first view
    And On Manage View page - I click on 'Manage users' toggle button
    And On Select User page - I add user 'whole organisation' to the view
    And On Manage View page - I click on 'Manage agreements' toggle button
    And On Select view agreement page - I select agreement
    And I add Agreement to the View
    And I publish the View
    When I select the 'Last Modified' option from the 'Sort By' dropdown
    And On the View directory Page - I click on the first view
    Then On Manage View page - I verify that the View is published
    When I log out


  Scenario: Raise a quote for supplier
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    And  On the Marketplace Landing page - I click on the 'Search' button
    When On the Marketplace Search Results page - I enter 'Test 500' into 'SearchKeywords'
    And  On the Marketplace Search Results page - I click on the 'Search' button
    When On the Marketplace Search Results page - I select the 'Date (newest to oldest)' option from the 'Order By' dropdown
    Then On the Marketplace Search Results page - I check that first item 'ContractLot' value is 'Lot 50'
    And On the Marketplace Search Results page - I check that first item 'ContractReference' value is 'ExpectedValue'
    And On the Marketplace Search Results page - I click on the 'first item View' button
    And On the Item Details page - I click on the 'Get quotes' button
    And On the RFQ page - I enter 'RFQ Title' as 'CATFISH Title'
    And On the RFQ page - I enter 'Expiration date' as '7'
    And On the RFQ page - I enter 'Expiration time' as 'now'
    And On the RFQ page - I enter 'Currency' as 'GBP'
    And On the RFQ page - I enter 'Name' as 'CATFISH RFQ PRODUCT NAME'
    And On the RFQ page - I enter 'description' as 'This is CATFISH description for rfq'
    And On the RFQ page - I enter 'Quantity' as '10'
    And On the RFQ page - I enter 'Order unit' as 'Each'
    And On the RFQ page - I click on classification cog
    And I select the classification category as 'Animal Feed' in 'level2Category'
    And I select the classification category as 'Fish food' in 'level3Category'
    And I select the classification category as 'Fish food flakes' in 'level4Category'
    And I click on done button
    And On the RFQ Page - I click on 'update' button
    And On the RFQ Page - I click on 'send' button
    And I log out

  Scenario: Send a quote to buyer
    Given  I log into Commerce Network as 'SUPPLIER_ADMIN_NONDESTRUCTIVE'
    When   I navigate to the internal 'Quotes' page
    Then   On the supplier RFQ directory page - I search for the rfq
    And    I select the 'Newest' option from the 'Sort By' dropdown
    Then I click on the Quotes 'Open' filter
    And   On the supplier RFQ directory page - I click on cog
    And   On view quote page - Supplier click on 'Quote' button to 'quote'
    And   On the quote page - Supplier select 'Delivery cost' as 'Included'
    And On the quote page - I click on 'addProductDetailsPlus' button
    And   On the quote page - Supplier enter 'Quantity' as '10'
    #And   On the quote page - Supplier enter 'Order Unit' as 'each'
    And   On the quote page - Supplier enter 'Unit price' as '100'
    And   On view quote page - Supplier click on 'Add' button to 'product details'
    And   On view quote page - Supplier click on 'Send' button to 'send'
    And   On view quote page - Validate successful message
    And I log out

  Scenario: Award the RFQ sent by Supplier
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When  I navigate to the internal 'Shopping' page
    And   I click on the Shopping 'Quick Quote' submenu item
    And   I click on 'sent' in the list items
    Then  On the buyer RFQ directory page - I search for the rfq
    And   On the buyer RFQ directory page - I click on cog
    And   On the RFQ view page - I click on Award button
    And   I click on award in the popup modal
    And   On the buyer RFQ view page - I validate awarded message
    And   On the buyer RFQ view page - I add item to the basket
    And   I log out
