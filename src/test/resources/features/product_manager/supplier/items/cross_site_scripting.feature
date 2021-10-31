@CLRegression
@AWSRegression

Feature: Cross Site Scripting Complete and Incomplete HTML Tag

  @CrossSiteScriptingCompleteHTML
  Scenario: Add complete HTML tag to check if there is any cross site scripting attack vulnerability

      Given I log into Commerce Network as 'SUPPLIER_ADMIN'
      And  I navigate to the internal 'Product Manager' page
      And  I click on the Product Manager 'Supplier' 'Items' submenu item
      When On the Item Directory page - I click on the 'Create' button
      And  On the Create Item page - I enter 'CATFISH-ITEM1-' plus SessionGUID into 'SupplierItemID'
      And  On the Create Item page - I enter 'CATFISH-ITEM1 Name' into 'Name'
      And  On the Create Item page - I enter '<html>' into 'Description'
      And  On the Create Item page - I enter 'CATFISH-ITEM1 CATFISH' into 'Keywords'
      And  On the Create Item page - I select the 'Goods' option from the 'Item class' dropdown
      And  On the Create Item page - I select the 'Yes' option from the 'Environment friendly' dropdown
      And  On the Create Item page - I check that 'ComparisonUOM' value is 'Each'
      And  On the Create Item page - I enter '1' into 'ComparisonScale'
      And  On the Create Item page - I click on the 'Add Classification' button
      When On the Create Item page - I select the 'UNSPSC (v8)' option from the 'ClassificationType' dropdown
      Then On the Create Item page - I check that 'UNSPSCCode' value is '10000000'
      And  On the Create Item page - I select the 'Healthcare Services' option from the 'Level1' dropdown
      And  On the Create Item page - I click on the 'Done' button
      And On the Create Item page - I click on the 'Save' button to verify mandatory fields
      And On the Create Item page - I verify error message thrown
      And I log out

  @CrossSiteScriptingIncompleteHTML
  Scenario: Add incomplete HTML tag to check if there is any cross site scripting attack vulnerability

      Given I log into Commerce Network as 'SUPPLIER_ADMIN'
      And  I navigate to the internal 'Product Manager' page
      And  I click on the Product Manager 'Supplier' 'Items' submenu item
      When On the Item Directory page - I click on the 'Create' button
      And  On the Create Item page - I enter 'CATFISH-ITEM1-' plus SessionGUID into 'SupplierItemID'
      And  On the Create Item page - I enter 'CATFISH-ITEM1 Name' into 'Name'
      And  On the Create Item page - I enter '<html' into 'Description'
      And  On the Create Item page - I enter 'CATFISH-ITEM1 CATFISH' into 'Keywords'
      And  On the Create Item page - I select the 'Goods' option from the 'Item class' dropdown
      And  On the Create Item page - I select the 'Yes' option from the 'Environment friendly' dropdown
      And  On the Create Item page - I check that 'ComparisonUOM' value is 'Each'
      And  On the Create Item page - I enter '1' into 'ComparisonScale'
      And  On the Create Item page - I click on the 'Add Classification' button
      When On the Create Item page - I select the 'UNSPSC (v8)' option from the 'ClassificationType' dropdown
      Then On the Create Item page - I check that 'UNSPSCCode' value is '10000000'
      And  On the Create Item page - I select the 'Healthcare Services' option from the 'Level1' dropdown
      And  On the Create Item page - I click on the 'Done' button
      And On the Create Item page - I click on the 'Save' button to verify mandatory fields
      And On the Create Item page - I verify error message thrown
      And I log out