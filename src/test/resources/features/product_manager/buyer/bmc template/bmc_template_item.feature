@CLRegression
@AWSRegression
@BuyBMCTemplatedItem
Feature: Create BMC template item and assign it to agent agreement item and then verify and add it to basket Marketplace
  Scenario: Create a new item template which is not available and contains a form
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Buyer' 'Item Templates' submenu item
    And On the Item Template Directory page - I click on the 'Create' button
    When On the Create Item Template page - I enter 'CatfishTemplateNew' into 'TemplateName'
    When On the Create Item Template page - I enter 'CatfishTemplateDescriptionNew' into 'TemplateDescription'
    When On the Create Item Template page - I click on 'Plus' button for 'TextEntrySingleLine'
    When On the Create Item Template page - I enter 'CatfishLabel' into 'Label' for 'TextEntrySingleLine'
    When On the Create Item Template page - I enter 'CatfishVarName' into 'VariableName' for 'TextEntrySingleLine'
    And On the Create Item Template page - I enter '20' into 'MaxSize' for 'TextEntrySingleLine'
    And On the Create Item Template page - I enter '5' into 'MinSize' for 'TextEntrySingleLine'
    And On the Create Item Template page - I select 'Supplier DUNS' from 'OverrideBasketValue' dropdown for 'TextEntrySingleLine'
    When On the Create Item Template page - I click on 'Save' button for 'TextEntryMultiLine'
    When On the Create Item Template page - I click on 'Plus' button for 'TextEntryMultiLine'
    When On the Create Item Template page - I enter 'CatfishLabel2' into 'Label' for 'TextEntryMultiLine'
    When On the Create Item Template page - I enter 'CatfishVarName2' into 'VariableName' for 'TextEntryMultiLine'
    And On the Create Item Template page - I enter '25' into 'MaxSize' for 'TextEntryMultiLine'
    And On the Create Item Template page - I enter '6' into 'MinSize' for 'TextEntryMultiLine'
    And On the Create Item Template page - I select 'SKU / Item ID' from 'OverrideBasketValue' dropdown for 'TextEntryMultiLine'
    When On the Create Item Template page - I click on 'Save' button for 'TextEntryMultiLine'
    When On the Create Item Template page - I click on 'Plus' button for 'DropdownSingleSelect'
    When On the Create Item Template page - I enter 'CatfishLabel3' into 'Label' for 'DropdownSingleSelect'
    When On the Create Item Template page - I enter 'CatfishVarName3' into 'VariableName' for 'DropdownSingleSelect'
    And On the Create Item Template page - I select 'Name' from 'OverrideBasketValue' dropdown for 'DropdownSingleSelect'
    When On the Create Item Template page - I click on 'Save' button for 'ListMultiSelect'
    When On the Create Item Template page - I click on 'Plus' button for 'ListMultiSelect'
    When On the Create Item Template page - I enter 'CatfishLabel4' into 'Label' for 'ListMultiSelect'
    When On the Create Item Template page - I enter 'CatfishVarName4' into 'VariableName' for 'ListMultiSelect'
#    And On the Create Item Template page - I select 'Description' from 'OverrideBasketValue' dropdown for 'ListMultiSelect'
    When On the Create Item Template page - I click on 'Save' button for 'ListMultiSelect'
    When On the Create Item Template page - I click on 'Plus' button for 'BuyerGuidanceText'
    And On the Create Item Template page - I enter 'CatfishBuyerGuidance' into 'Text' for 'BuyerGuidanceText'
    And On the Create Item Template page - I click on 'Save' button for 'BuyerGuidanceText'
    And On the Create Item Template page - I 'Enable' the item template
    And On the Create Item Template page - I click on 'Save' button for 'ItemTemplate'
    And I log out


  Scenario: Create a Agent Agreement with item
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
   # Now add item from UI
    And On the Manage Agreement page - I click on the 'manageitems' button
    Then On the Agreement Pricelist Items page - I click on 'Create' button
    Then On the Agreement Items create item page - I enter 'CATFISH-ITEM1-' plus SessionGUID into 'supplierItemID'
    And  On the Agreement Items create item page - I enter 'CATFISH-ITEM Name' into 'agentItemName'
    And  On the Agreement Items create item page - I enter 'CATFISH-ITEM Description' into 'agentItemDescription'
    #add template to the item
    And  On the Agreement Items create item page - I select recently created templated item
    And On the Agent Agreement create item page - I enter template data
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
  # Approve the agent agreement
    When On the Manage Agreement page - I click on the 'approve' button
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

  Scenario: I verify Agent item with template appears in the Marketplace
    Given I log into Commerce Network as 'BUYER_ADMIN'
    And  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    And  On the Marketplace Landing page - I click on the 'Basket' button
    And  On the Shopping Basket page - I empty the shopping basket
    Then On the Shopping Basket page - I check that the number of 'ItemNames' is '0'
    # Now add first template item into the basket
    When I click on the Shopping 'Marketplace' submenu item
    When On the Marketplace Landing page - I enter item into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
    Then  On the Marketplace Search Results page - I check that 'ItemOptions' 'is' displayed
    When  On the Marketplace Search Results page - I enter 'CATFISHVarNewValue' into 'CatfishLabel1'
    And  On the Marketplace Search Results page - I enter 'CATFISHVarNewValue2' into 'CatfishLabel2'
    And On the Marketplace Search Results page - I click on the 'AddInformation' button
    And On the Marketplace Search Results page - I click on the 'Basket' button
    Then  On the Shopping Basket page - I check that 'PageTitle' value is 'My Basket'
    And  On the Shopping Basket page - I check that 'ItemID' value is 'CATFISHVarNewValue2'
    Then I log out

