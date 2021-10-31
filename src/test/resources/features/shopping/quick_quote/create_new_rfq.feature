@CLRegression
@AWSRegression
@Rfq

Feature: Create Quick RFQ which allows the buyer to get a quotation from the supplier without the use of Supplier Portal to create a Quote by the supplier
  Scenario: Send one RFQ to expire in Seven days with multiple suppliers
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    And On the Marketplace Landing page - I click on the 'Basket' button
    When On the Shopping Basket page - I empty the shopping basket
    And  I click on the Shopping 'Marketplace' submenu item
    And On the Marketplace Landing page - I click on the 'Quotes' button
    And I click on the Shopping 'Quick Quote' submenu item
    And I click on 'Create New' in the list items
    And On the RFQ page - I enter 'RFQ Title' as 'CATFISH RFQ'
    And On the RFQ page - I enter 'Expiration date' as '7'
    And On the RFQ page - I enter 'Currency' as 'GBP'
    And On the RFQ page - I enter 'Name' as 'CATFISH RFQ PRODUCT NAME'
    And On the RFQ page - I enter 'description' as 'This is CATFISH description for rfq'
    And On the RFQ page - I enter 'Quantity' as '10'
    And On the RFQ page - I enter 'Order unit' as 'Each'
    And On the RFQ page - I click on classification cog
    And I select the classification category as 'Animal Feed' in 'level2Category'
    And I select the classification category as 'Fish food' in 'level3Category'
   And  I select the classification category as 'Fish food flakes' in 'level4Category'
   And  I click on done button
   And On the RFQ page - I click on add button to add line
   And On the RFQ Page - I click on add button to add supplier
   When On the QuickQuote Suppliers page - I enter 'Catfish-RW-Supplier' into 'SearchKeywords'
   And On the Select Supplier page - I select first supplier in the list
   When On the QuickQuote Suppliers page - I enter 'Catfish-NDT-Supplier' into 'SearchKeywords'
   And On the Select Supplier page - I select first supplier in the list
   And On the Select Supplier page - I click on the Save button
   And On the RFQ Page - I click on 'save' button
   When  I navigate to the internal 'Shopping' page
   And I click on the Shopping 'Quick Quote' submenu item
   Then I click on 'Draft' in the list items
   And click on new rfq
   # And On the RFQ page - I check title is same
   And On the RFQ Page - I click on 'send' button
   And I log out

  Scenario: Send one RFQ with today's date with current time
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When  I navigate to the internal 'Shopping' page
    And I click on the Shopping 'Quick Quote' submenu item
    And I click on 'Create New' in the list items
    And On the RFQ page - I enter 'RFQ Title' as 'CATFISH Title'
    And On the RFQ page - I enter 'Expiration date' as '0'
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
    And On the RFQ page - I click on add button to add line
    And On the RFQ Page - I click on add button to add supplier
    When On the QuickQuote Suppliers page - I enter 'Catfish-RW-Supplier' into 'SearchKeywords'
    And On the Select Supplier page - I select first supplier in the list
    When On the QuickQuote Suppliers page - I enter 'Catfish-NDT-Supplier' into 'SearchKeywords'
    And On the Select Supplier page - I select first supplier in the list
    And On the Select Supplier page - I click on the Save button
    And On the RFQ Page - I click on 'save' button
    And I click on the Shopping 'Quick Quote' submenu item
    Then I click on 'Draft' in the list items
    And click on new rfq
   # And On the RFQ page - I check title is same
    And On the RFQ Page - I click on 'send' button
    And I log out

  Scenario:  Send one RFQ to expire in three days with multiple suppliers
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When  I navigate to the internal 'Shopping' page
    And I click on the Shopping 'Quick Quote' submenu item
    And I click on 'Create New' in the list items
    And On the RFQ page - I enter 'RFQ Title' as 'CATFISHRFQTITLE'
    And On the RFQ page - I enter 'Expiration date' as '3'
    And On the RFQ page - I enter 'Currency' as 'GBP'
    And On the RFQ page - I enter 'Name' as 'Catfish-NDT-Supplier'
    And On the RFQ page - I enter 'description' as 'This is CATFISH description for rfq'
    And On the RFQ page - I enter 'Quantity' as '10'
    And On the RFQ page - I enter 'Order unit' as 'Each'
    And On the RFQ page - I click on classification cog
    And I select the classification category as 'Animal Feed' in 'level2Category'
    And I select the classification category as 'Fish food' in 'level3Category'
    And I select the classification category as 'Fish food flakes' in 'level4Category'
    And I click on done button
    And On the RFQ page - I click on add button to add line
    And On the RFQ Page - I click on add button to add supplier
    When On the QuickQuote Suppliers page - I enter 'CATFISH-RW-Supplier' into 'SearchKeywords'
    And On the Select Supplier page - I select first supplier in the list
    When On the QuickQuote Suppliers page - I enter 'CATFISH-NDT-Supplier' into 'SearchKeywords'
    And On the Select Supplier page - I select first supplier in the list
    And On the Select Supplier page - I click on the Save button
    And On the RFQ Page - I click on 'save' button
    And I click on the Shopping 'Quick Quote' submenu item
    Then I click on 'Draft' in the list items
    And click on new rfq
    #And On the RFQ page - I check title is same
    And On the RFQ Page - I click on 'send' button
    And I log out

  Scenario: Quote the rfq as a Supplier
    Given  I log into Commerce Network as 'SUPPLIER_ADMIN_NONDESTRUCTIVE'
    When   I navigate to the internal 'Quotes' page
    Then   On the supplier RFQ directory page - I search for the rfq
    And   On the supplier RFQ directory page - I click on cog
    And   On view quote page - Supplier click on 'Quote' button to 'quote'
    And   On the quote page - Supplier select 'Delivery cost' as 'Included'
#    And   On the quote page - Supplier enter 'Quantity' as '10'
#    And   On the quote page - Supplier enter 'Order Unit' as 'each'
    And On the quote page - I click on 'addProductDetailsPlus' button
    And   On the quote page - Supplier enter 'Unit price' as '100'
    And   On view quote page - Supplier click on 'Add' button to 'product details'
    And I wait '1' seconds before continuing
    And   On view quote page - Supplier click on 'Send' button to 'send'
    And I wait '2' seconds before continuing
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










