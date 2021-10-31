@CLRegression
@AWSRegression
@AgentAgreement
Feature: Agent agreement end to end functionality

Scenario: Create a Agent Agreement
  Given I log into Commerce Network as 'BUYER_ADMIN'
  When I navigate to the internal 'Product Manager' page
  And I click on the Product Manager 'Buyer' 'Create Agreement' panel
  And On the Create Agreement page - I select Agreement 'Type' of 'Agent Agreement'
  And On the Create Agreement page - I enter Agreement 'Name' of 'CATFISH-ORG-AGENT-'
  And On the Create Agreement page - I enter Agreement 'Start Date' of 'TODAY'
  And On the Create Agreement page - I enter Agreement 'Expiry Date' of 'FUTURE DATE'
  And On the Create Agreement page - I enter Agreement 'Contract Reference' of 'CATFISH-CREF-'
  And On the Create Agreement page - I select Agreement 'Language' of 'English'
  And On the Create Agreement page - I select Agreement 'Currency' of 'GBP'
  And On the Create Agreement page - I enter Agreement 'Keywords' of 'Agent,release'
  And On the Create Agreement page - I enter Agreement 'Description' of 'Test Agent Agreement'
  And On the Create Agreement page - I save the 'Agent' Agreement
  Then On the Manage Agreement page - I enter supplier details
  And On the Manage Agreement page - I click on the 'import' button
  And On Upload Agent agreement page - I select upload type as 'Agent agreement items'
  And On Content Upload Page - I upload the agent file _EN_AGENT_CSV_QA.csv
  And On Upload Agent agreement page - I click on back button
  Then On Manage Agreement page - I verify items are uploaded
  # Now add item from UI
  And On the Manage Agreement page - I click on the 'manageitems' button
  Then On the Agreement Pricelist Items page - I click on 'Create' button
  Then On the Agreement Items create item page - I enter 'CATFISH-ITEM1-' plus SessionGUID into 'supplierItemID'
  And  On the Agreement Items create item page - I enter 'CATFISH-ITEM Name' into 'agentItemName'
  And  On the Agreement Items create item page - I enter 'CATFISH-ITEM Description' into 'agentItemDescription'
  And  On the Agreement Items create item page - I enter '200' into 'agentItemPrice'
  And  On the Agreement Items create item page - I click on 'classificationCog'
  And I select the classification category as 'Animal Feed' in 'level2Category'
  And I select the classification category as 'Fish food' in 'level3Category'
  And I select the classification category as 'Fish food flakes' in 'level4Category'
  And I click on done button
  And On the Agreement Items create item page - I click on 'Save'
  Then On the Agenet Agreement Create item page - I verify agent item is added successfully
  Then On the Agreement Items Edit page - I click on 'Back To Agreement Price List Items'
  And On the Agreement Pricelist Items page - I click on 'Done' button
  # Approve the agent agreement
#  When On the Manage Agreement page - I click on the 'approve' button
   Then I click on the Product Manager 'Buyer' 'Views' submenu item
   And On the View directory page - I enter 'Agent view' into 'SearchKeywords'
   And On the View directory page - I click on 'Search' button
   And On the View directory page - I click on 'cog' button
   And On Manage View page - I click on 'Manage agreements' toggle button
   When On Select view agreement page - I select agreement
   And I add Agreement to the View
   And I publish the View
   When I select the 'Last Modified' option from the 'Sort By' dropdown
   And On the View directory page - I click on 'cog' button
   Then On Manage View page - I verify that the View is published
   Then I log out

  Scenario: I verify Agent item appears in the Marketplace
    Given I log into Commerce Network as 'BUYER_ADMIN'
    And  I navigate to the internal 'Shopping' page
    When I click on the Shopping 'Marketplace' submenu item
    When On the Marketplace Landing page - I enter item into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that first item is shared item
    Then I log out

 @AgentAgreementWithBMEcat
  Scenario: Create a Agent Agreement item using BMECat file
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Buyer' 'Create Agreement' panel
    And On the Create Agreement page - I select Agreement 'Type' of 'Agent Agreement'
    And On the Create Agreement page - I enter Agreement 'Name' of 'CATFISH-ORG-AGENT-'
    And On the Create Agreement page - I enter Agreement 'Start Date' of 'TODAY'
    And On the Create Agreement page - I enter Agreement 'Expiry Date' of 'FUTURE DATE'
    And On the Create Agreement page - I enter Agreement 'Contract Reference' of 'CATFISH-CREF-'
    And On the Create Agreement page - I select Agreement 'Language' of 'English'
    And On the Create Agreement page - I select Agreement 'Currency' of 'GBP'
    And On the Create Agreement page - I enter Agreement 'Keywords' of 'Agent,release'
    And On the Create Agreement page - I enter Agreement 'Description' of 'Test Agent Agreement'
    And On the Create Agreement page - I save the 'Agent' Agreement
    Then On the Manage Agreement page - I enter supplier details
    And On the Manage Agreement page - I click on the 'import' button
    And On Content Upload Page - I upload the bmecat file _EN_EUR_AUTO_QA.xml
    And On Upload Agent agreement page - I click on back button
    Then On Manage Agreement page - I verify items are uploaded
    Then On Manage Agreement page - I delete new agreement
    Then I log out
