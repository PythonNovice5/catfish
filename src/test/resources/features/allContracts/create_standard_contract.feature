@CLRegression
@StandardContract
Feature: Create Standard contract,create RFQ for it publish

  Scenario: Create Standard contract and RFQ
    Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
    When I navigate to the internal 'Contracts' page
    Then In contract page - I click on 'create' button to create 'contract'
    Then In edit contract page - I enter 'Contract name' as 'Catfish contract'
    And In edit contract page - I enter 'Contract reference' as 'Catfish contract reference'
    And In edit contract page - I enter 'Contract Owner' as 'Catfish contract owner'
    And In edit contract page - I enter 'start date' as '0'
    And In edit contract page - I enter 'Expiry date' as '30'
    Then In edit contract page - I enter 'Description' as 'Catfish contract description'
    Then In edit contract page - I enter 'Contract scope' as 'Catfish contract scope'
    Then In edit contract page - I click on 'add suppliers' button to 'add supplier'
    And In the Contract page - I click on 'Suppliers' button
    And In the Manage suppliers page - I click on 'upload suppliers' button to 'upload' suppliers
    Then In the Contract upload suppliers page - I select a file to upload
    And In the Contract page - I click on 'Items' button
    Then In the Contract Item page - I click on 'Upload items' button to upload suppliers
    And In the Contract upload item page - I upload file for items
   # When In the Contract page - I click on 'Attachments' button
   # Then In the Contract attachment page - I upload file
    And  In the Contract page - I click on 'Categories' button
    When In the Contract categories page - I click on 'add categories' button
    And I select the classification category as 'Advertising and Media' in 'level1Category'
    And I select the classification category as 'Marketing' in 'level2Category'
    And I select the classification category as 'Marketing Services' in 'level3Category'
    Then On Add Categories page - I click on Add to add categories
    And In the Contract page - I click on 'Contract' button
    When In My Contract page - I click on publish button to publish the contract
    Then In My Contract page - I confirm ok
    Then In My Contract page - I verify contract published
    And On My Contract page - I click on 'Sharing' button
    And On Contracts Sharing page - I select and add 'Procserve'
    And On Contracts Sharing page - I click on 'Items' button
    Then On manage items page - I choose item
    And On Contracts Management Page - I click on 'requestAQuote' button
    And On Request Quote Page - I enter 'CatFishQuoteReference' into 'Your reference'
    And On Request Quote Page - I enter '27-06-2021' into 'Target Delivery Date'
    And On Request Quote Page - I enter '27-02-2024' into 'Expiration Date'
    And On Request Quote Page - I enter '12:00' into 'Expiration Time'
    And On Request Quote Page - I enter 'Catfish instructions' into 'Special Instructions'
    And On Request Quote Page - I click on 'Publish' button
    Then On Manage Request For Quote page - I verify that 'SuccessMessage' contains 'Success! You published'
    When On Manage Request For Quote page - I click on 'Back to your results'
    And On My Requests For Quote page - I sort the records by 'Date Issued'
    Then On My Requests For Quote page - I verify that 'YourReferenceFirstRecord' is 'CatFishQuoteReference'
    And I log out






