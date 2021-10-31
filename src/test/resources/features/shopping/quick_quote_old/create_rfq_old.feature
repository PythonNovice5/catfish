@CLRegression
@RFQOld

Feature: Create old RFQ

  Scenario: Create RFQ(old) and create quote
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When  I navigate to the internal 'Shopping' page
    And I click on the Shopping 'Request for Quotation' submenu item
    And On RFQ Management Page - I click on 'Request a Quote' tab
    And On Request Quote Page - I enter 'CatFishQuoteReference' into 'Your reference'
    And On Request Quote Page - I enter '27-02-2022' into 'Target Delivery Date'
    And On Request Quote Page - I enter '27-02-2024' into 'Expiration Date'
    And On Request Quote Page - I enter '12:00' into 'Expiration Time'
    And On Request Quote Page - I enter 'Catfish instructions' into 'Special Instructions'
    And On Request Quote Page - I click on 'Add line item' button
    And On Line Items Page - I enter 'Catfish Item Name' into 'ItemName'
    And On Line Items Page - I enter '10' into 'ItemQuantity'
    And On Line Items Page - I enter '10' into 'TargetUnitPrice'
    And On Line Items Page - I enter 'Catfish description' into 'Item description'
    And On Line Items Page - I select 'Apparel and Luggage and Personal Care Products' from 'Categories Level 1'
    And On Line Items Page - I select 'Clothing' from 'Categories Level 2'
    And On Line Items Page - I select 'Athletic wear' from 'Categories Level 3'
    And On Line Items Page - I select 'Boys athletic wear' from 'Categories Level 4'
    And On Line Items Page - I click on 'Add' button
    And On Request Quote Page - I click on 'Add supplier' button
    When On the RFQ Suppliers page - I enter 'Catfish-RW-Supplier' into 'SearchKeywords'
    And  On the RFQ Suppliers page - I click on the 'Search' button
    And On the RFQ Suppliers page - I click on the 'AddSupplier' button
    When On the RFQ Suppliers page - I enter 'Catfish-NDT-Supplier' into 'SearchKeywords'
    And  On the RFQ Suppliers page - I click on the 'Search' button
    And On the RFQ Suppliers page - I click on the 'AddSupplier' button
    And  On the RFQ Suppliers page - I click on the 'Save' button
    And On Request Quote Page - I click on 'Publish' button
    Then On Manage Request For Quote page - I verify that 'SuccessMessage' contains 'Success! You published'
    When On Manage Request For Quote page - I click on 'Back to your results'
    And On My Requests For Quote page - I sort the records by 'Date Issued'
    Then On My Requests For Quote page - I verify that 'YourReferenceFirstRecord' is 'CatFishQuoteReference'
    And I log out