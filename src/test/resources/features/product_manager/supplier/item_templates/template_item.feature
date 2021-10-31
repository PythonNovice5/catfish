@CLRegression
@AWSRegression
@ItemTemplate

Feature: End to end functionality of template item with creation of new standard item and item template

  Scenario: Create a new item template which is not available and contains a form
      Given I log into Commerce Network as 'SUPPLIER_ADMIN'
      When I navigate to the internal 'Product Manager' page
      And I click on the Product Manager 'Supplier' 'Item Templates' submenu item
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
#      And On the Create Item Template page - I select 'Description' from 'OverrideBasketValue' dropdown for 'ListMultiSelect'
      When On the Create Item Template page - I click on 'Save' button for 'ListMultiSelect'
      When On the Create Item Template page - I click on 'Plus' button for 'BuyerGuidanceText'
      And On the Create Item Template page - I enter 'CatfishBuyerGuidance' into 'Text' for 'BuyerGuidanceText'
      And On the Create Item Template page - I click on 'Save' button for 'BuyerGuidanceText'
      And On the Create Item Template page - I 'Enable' the item template
      And On the Create Item Template page - I click on 'Save' button for 'ItemTemplate'
      And I log out

  Scenario:Create a standard item

      Given I log into Commerce Network as 'SUPPLIER_ADMIN'
      And  I navigate to the internal 'Product Manager' page
      And  I click on the Product Manager 'Supplier' 'Items' submenu item
      When On the Item Directory page - I click on the 'Create' button
      And On the Create Item page - I click on the 'Save' button to verify mandatory fields
      Then On the Create Item page - I check that 'Supplier item ID' is a mandatory field
      And On the Create Item page - I check that 'Name' is a mandatory field
      And On the Create Item page - I check that 'Description' is a mandatory field
  #    And On the Create Item page - I check that 'Comparison Scale' is a mandatory field
      When  I click on the Product Manager 'Supplier' 'Items' submenu item
      And On the Item Directory page - I click on the 'Create' button
      And On the Create Item page - I click on plus button
      And On the Create Item page - I search 'CatfishItemTemplate'
      And On the Create Item page - I add the item template
      And  On the Create Item page - I enter 'CATFISH-ITEM1-' plus SessionGUID into 'SupplierItemID'
      And  On the Create Item page - I enter 'CATFISH-ITEM1 Name' into 'Name'
      And  On the Create Item page - I enter 'CATFISH-ITEM1 Description' into 'Description'
      And  On the Create Item page - I enter 'CATFISH-ITEM1 CATFISH' into 'Keywords'
      And  On the Create Item page - I select the 'Goods' option from the 'Item class' dropdown
      And  On the Create Item page - I select the 'Yes' option from the 'Environment friendly' dropdown
      And  On the Create Item page - I select the 'No' option from the 'Hazardous item' dropdown
      And  On the Create Item page - I enter 'CATFISH-ITEM1 ManufacturerName' into 'ManufacturerName'
      And  On the Create Item page - I enter 'CATFISH-ITEM1 ManufacturerItemID' into 'ManufacturerItemID'
      And  On the Create Item page - I enter 'CATFISH-ITEM1 LeadTime' into 'LeadTime'
      And  On the Create Item page - I enter 'CATFISH-ITEM1 GTIN' into 'GTIN'
      And  On the Create Item page - I click on the 'Custom Attribute Add' button
      And  On the Create Item page - I enter 'Media' into 'FirstCustomAttrName'
      And  On the Create Item page - I enter 'Electronic' into 'FirstCustomAttrValue'
      And  On the Create Item page - I check that 'ComparisonUOM' value is 'Each'
      And  On the Create Item page - I enter '1' into 'ComparisonScale'
      And  On the Create Item page - I click on the 'Add Classification' button
      When On the Create Item page - I select the 'UNSPSC (v18)' option from the 'ClassificationType' dropdown
      Then On the Create Item page - I check that 'UNSPSCCode' value is '10000000'
      And  On the Create Item page - I select the 'Healthcare Services' option from the 'Level1' dropdown
      When On the Create Item page - I select the 'Medical practice' option from the 'Level2' dropdown
      When On the Create Item page - I select the 'Medical laboratories' option from the 'Level3' dropdown
      When On the Create Item page - I select the 'X ray laboratory services' option from the 'Level4' dropdown
      Then On the Create Item page - I check that 'UNSPSCCode' value is '85121808'
      And On the Create Item page - I click on 'Done' button
      And  On the Create Item page - I click on the 'Save' button
      And On the Edit Item page - I check that 'X ray laboratory services' is displayed under 'v18' for 'Provided'
      And On the Edit Item page - I check that 'X ray laboratory services' is displayed under 'v19' for 'Standard'
      And On the Edit Item page - I click on the 'Add Linked Media' button
      And  On the Edit Item page - I check that 'ModalWindowTitle' value is 'Select PDF from Media Directory'
      When On the Edit Item page - I enter 'catfishpdf' into 'SearchKeywords'
      And  On the Edit Item page - I click on the 'Search' button
      And  On the Edit Item page - I click on 'First' thumbnail
      And  On the Edit Item page - I check that 'catfishpdf1.pdf' is displayed in 'LinkedMediaFiles'
  #    Then On the Edit Item page - I check that 'SecondLinkedMediaFileName' 'is' displayed
  #    And  On the Create Item page - I check that 'catfishpdf2.pdf' is displayed in 'LinkedMediaFiles'
  #    Then On the Create Item page - I check that 'ThirdLinkedMediaFileName' 'is' displayed
  #    And  On the Create Item page - I check that 'catfishpdf3.pdf' is displayed in 'LinkedMediaFiles'
  #    Then On the Create Item page - I check that 'FourthLinkedMediaFileName' 'is' displayed
  #    And  On the Create Item page - I check that 'catfishpdf4.pdf' is displayed in 'LinkedMediaFiles'
  #    Then On the Create Item page - I check that 'FifthLinkedMediaFileName' 'is' displayed
  #    And  On the Create Item page - I check that 'catfishpdf5.pdf' is displayed in 'LinkedMediaFiles'
      When On the Edit Item page - I click on the 'External Link Add' button
      When On the Edit Item page - I enter 'CatfishLabel' into 'FirstExternalLinkLabel'
      And  On the Edit Item page - I enter 'http://www.basware.com' into 'FirstExternalLinkAddress'
      And  On the Edit Item page - I click on the 'Select Image' button
      When On the Edit Item page - I click on 'First' thumbnail
  #    And On the Select Media page - I click on 'Second' thumbnail
  #    And On the Select Media page - I click on 'Third' thumbnail
  #    And On the Select Media page - I click on 'Fourth' thumbnail
  #    And On the Select Media page - I click on 'Fifth' thumbnail
  #    And On the Select Media page - I click on 'Sixth' thumbnail
  #    And On the Select Media page - I click on 'Seventh' thumbnail
  #    And On the Select Media page - I click on 'Eighth' thumbnail
  #    And On the Select Media page - I click on 'Nineth' thumbnail
  #    And On the Select Media page - I click on 'Tenth' thumbnail
  #    Then On the Select Media page - I check that 'AddItemsButton' value is 'Add 10 items'
  #    When On the Select Media page - I click on the 'Add items' button
      And On the Edit Item page - I click on the 'Save' button
  #    And  On the Create Item page - I click on the 'Preview' button
  #    And  I wait for the modal popup to be 'displayed'
  #    Then On the Create Item page - I check that 'ModalTitle' value is 'Item preview'
  #    And  On the Create Item page - I check that 'ModalDescription' 'is' displayed
  #    And  On the Create Item page - I check that 'ModalDescription' value is 'CATFISH-ITEM1 Description'
  #    And On the Create item page - I verify 'First' image
  #    And On the Create Item page - I click on 'Forward' arrow
  #    And On the Create item page - I verify 'Second' image
  #    And On the Create Item page - I click on 'Forward' arrow
  #    And On the Create item page - I verify 'Third' image
  #    And On the Create Item page - I click on 'Forward' arrow
  #    And On the Create item page - I verify 'Fourth' image
  #    And On the Create Item page - I click on 'Forward' arrow
  #    And On the Create item page - I verify 'Fifth' image
  #    And On the Create Item page - I click on 'Forward' arrow
  #    And On the Create item page - I verify 'Sixth' image
  #    And On the Create Item page - I click on 'Forward' arrow
  #    And On the Create item page - I verify 'Seventh' image
  #    And On the Create Item page - I click on 'Forward' arrow
  #    And On the Create item page - I verify 'Eighth' image
  #    And On the Create Item page - I click on 'Forward' arrow
  #    And On the Create item page - I verify 'Nineth' image
  #    And On the Create Item page - I click on 'Forward' arrow
  #    And On the Create item page - I verify 'Tenth' image
  #    And  On the Create Item page - I check that 'ModalAdditionalInformationTitle' 'is' displayed
  #    And  On the Create Item page - I check that 'ModalAddInfNameLabel' 'is' displayed
  #    And  On the Create Item page - I check that 'ModalAddInfValueLabel' 'is' displayed
  #    And  On the Create Item page - I check that 'ModalFirstAddInfName' 'is' displayed
  #    And  On the Create Item page - I check that 'ModalFirstAddInfName' value is 'Environment-friendly Item'
  #    And  On the Create Item page - I check that 'ModalFirstAddInfValue' 'is' displayed
  #    And  On the Create Item page - I check that 'ModalFirstAddInfValue' value is 'Yes'
  #    And  On the Create Item page - I check that 'ModalSecondAddInfName' 'is' displayed
  #    And  On the Create Item page - I check that 'ModalSecondAddInfName' value is 'GTIN'
  #    And  On the Create Item page - I check that 'ModalSecondAddInfValue' 'is' displayed
  #    And  On the Create Item page - I check that 'ModalSecondAddInfValue' value is 'CATFISH-ITEM1 GTIN'
  #    And  On the Create Item page - I check that 'ModalThirdAddInfName' 'is' displayed
  #    And  On the Create Item page - I check that 'ModalThirdAddInfName' value is 'Hazardous item'
  #    And  On the Create Item page - I check that 'ModalThirdAddInfValue' 'is' displayed
  #    And  On the Create Item page - I check that 'ModalThirdAddInfValue' value is 'No'
  #    And  On the Create Item page - I check that 'ModalFirstLinkedMediaIcon' 'is' displayed
  #    And  On the Create Item page - I check that 'ModalFirstLinkedMedia' 'is' displayed
  #    And  On the Create Item page - I check that 'catfishpdf5.pdf' is displayed in 'Modal FirstLinked Media Files'
  #    And  On the Create Item page - I check that 'ModalExtLinksTitle' 'is' displayed
  #    And  On the Create Item page - I check that 'ModalExtLinksWarning' 'is' displayed
  #    And  On the Create Item page - I check that 'ModalFirstExtLink' 'is' displayed
  #    And  On the Create Item page - I check that 'ModalFirstExtLink' value is 'CatfishLabel'
  #    And  On the Create Item page - I check that 'ModalCancelPreview' 'is' displayed
  #    When On the Create Item page - I click on the 'ModalCancelPreview' button
  #    And  I wait for the modal popup to be 'closed'
      And  I log out

  Scenario: Create Standard item with item template

      Given I log into Commerce Network as 'SUPPLIER_ADMIN'
      And  I navigate to the internal 'Product Manager' page
      And  I click on the Product Manager 'Supplier' 'Items' submenu item
      When On the Item Directory page - I search for 'SupID' until found or timeout
      When On the Item Directory page - I click on the 'First Item Name' link
      And On the Edit Item page - I click on the 'Manage Template' button
      And On the Edit Item page - I search 'TemplateName'
  #    And On the Item template Directory page - I search 'TemplateName'
  #    And On the Item template Directory page - I add the item template for Edit Item page
      And On the Edit Item page - I add the item template for Edit Item page
      And On the Edit Item page - I click on the 'Save' button
  #    And On the Edit Item page - I click on the 'Manage Template Data' button
  #    And On the Manage Template Data page - I enter 'CatfishInitialValue1' into 'InitialValueTextEntrySingleLine'
  #    And On the Manage Template Data page - I enter 'CatfishInitialValue2' into 'InitialValueTextEntryMultiLine'
  #    And On the Manage Template Data page - I enter 'CatfishDisplayText1' into 'DisplayTextDropDownSingleSelect'
  #    And On the Manage Template Data page - I enter 'CatfishBasket1' into 'BasketValueDropDownSingleSelect'
  #    And On the Manage Template Data page - I enter 'CatfishDisplayText1' into 'DisplayTextListMultiSelect'
  #    And On the Manage Template Data page - I enter 'CatfishBasket2' into 'BasketValueListMultiSelect'
  #    And On the Manage Template Data page - I click on 'Save' button
  #    And On the Edit Item page - I click on the 'Save' button
      And  I navigate to the internal 'Product Manager' page
      And I click on the Product Manager 'Supplier' 'Items' submenu item
      When On the Item Directory page - I enter 'SupID' into 'SearchKeywords'
      And  On the Item Directory page - I click on the 'Search' button
      When On the Item Directory page - I click on the 'First Item Name' link
      When On the Edit Item page - I click on the 'Delete' button
      Then On the Item Directory page - I verify 'Success! You deleted' is displayed
      When I click on the Product Manager 'Supplier' 'Item Templates' submenu item
      And On the Item template Directory page - I search 'TemplateName'
      And On the Item Template Directory page - I click on the 'Delete' button
      And I log out
