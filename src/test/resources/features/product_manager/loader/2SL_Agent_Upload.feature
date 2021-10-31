@2SLAgentAgreementWithStock
@CLRegression
@AWSRegression
Feature: End to end agent agreement tests with stock via 2SL

  @2slUploadAgentAgreement
  Scenario: Upload agent agreement and stock via 2SL loading and verify the Agent agreement is created
    Given I log into Commerce Network as 'BUYER_ADMIN'
    And  I navigate to the internal 'Product Manager' page
    And  I click on the Product Manager 'Buyer' 'Loader' submenu item
    When On Loader page - I click on 'Upload files' panel
    Then On Upload file page - I select mapping as 'Agent Agreement Items CSV'
    And I upload the agent file _EN_AGENT_CSV_QA.csv
    Then On Upload page - I enter all details
      | Output type    | Agent Agreement |
      | Language       | English (UK) |
      | UNSPSC Version |   UNSPSC 8  |
      | Currency       | GBP |
    When On upload file page - I click on upload button
    Then The 2SL upload of the csv file has completed with VALID
    And On upload status page - I click on view to see the staged file
    Then On staging page - I click on 'commit'
    Then The 2SL progress of the csv file has completed with PROCESS-COMPLETED
    Then I navigate to the Agreements page to verify upload is success
    And I select the 'Last modified' option from the 'Sort By' dropdown
    Then On Buyer Agreement directory page - I click on cog to manage agreement
    Then On Manage Agreement page - I verify items are uploaded
      # Now add item from UI
    And On the Manage Agreement page - I click on the 'manageitems' button
    Then On the Agreement Pricelist Items page - I click on 'Create' button
    Then On the Agreement Items create item page - I enter 'CATFISH-ITEM1-' plus SessionGUID into 'supplierItemID'
    And  On the Agreement Items create item page - I enter 'CATFISH-ITEM Name' into 'Name'
    And  On the Agreement Items create item page - I enter 'CATFISH-ITEM Description' into 'Description'
    And  On the Agreement Items create item page - I enter '200' into 'agentItemPrice'
    And  On the Agreement Items create item page - I click on 'classificationCog'
    And I select the classification category as 'Animal Feed' in 'level2Category'
    And I select the classification category as 'Fish food' in 'level3Category'
    And I select the classification category as 'Fish food flakes' in 'level4Category'
    And I click on done button
    And On the Agreement Items create item page - I click on 'Save'
    Then On the Agreement Items Edit page - I verify agent item is added successfully
    Then On the Agreement Items Edit page - I click on 'Back To Agreement Price List Items'
    And On the Agreement Pricelist Items page - I click on 'Done' button

    #Upload stock Information
     When On the Manage Agreement page - I enable stock
     Then On the Manage Agreement page - I click on import stock button
     Then On Upload file page - I select mapping as 'Agent Stock CSV'
     And I upload the stock file _AGENT_STOCK_CSV_QA.csv
     Then On Upload page - I enter all details
      | Output type    | Agent Stock |
    When On upload file page - I click on upload button
    Then The 2SL upload of the stock file has completed with VALID
    And On upload status page - I click on view to see the staged file
    And On staging page - I verify items are present
    Then On staging page - I click on 'commit'
    Then The 2SL progress of the csv file has completed with PROCESS-COMPLETED
    Then I navigate to the Agreements page to verify upload is success
    And I select the 'Last modified' option from the 'Sort By' dropdown
    Then On Buyer Agreement directory page - I click on cog to manage agreement

      # Approve the agent agreement
    And On the Manage Agreement page - I click on the 'Select Supplier' button
    And On the Select Supplier page - I select the Supplier called 'CATFISH'
    When On the Manage Agreement page - I click on the 'approval link' button
    And On Buyer Manage Agreement price list page - I click on approve button
    Then On Buyer Manage Agreement price list page - I click on done
    Then I click on the Product Manager 'Buyer' 'Views' submenu item
    And On the View directory page - I enter 'Agent view' into 'SearchKeywords'
    And On the View directory page - I click on 'Search' button
    And On the View directory page - I click on 'cog' button
    And On Manage View page - I click on 'Manage agreements' toggle button
    When On Select view agreement page - I select agreement created via 2SL
    And I add Agreement to the View
    And I publish the View
    When I select the 'Last Modified' option from the 'Sort By' dropdown
    And On the View directory page - I click on 'cog' button
    Then On Manage View page - I verify that the View is published
    Then I log out


    #Verify stock information in Angular Marketplace
  @VerifyStockInMarketplace
  Scenario: Stock information is displayed in Angular Marketplace

    Given I log into Commerce Network as 'BUYER_ADMIN'
    And  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
#    When On the Marketplace Landing page - I click on the 'newUI' toggle
    When On the Marketplace Landing page - I enter item into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I click on the 'FirstItemName' link
    And  On the Item Details page - I check that stock information is displayed
    Then I log out

