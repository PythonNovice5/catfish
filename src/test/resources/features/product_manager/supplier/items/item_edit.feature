@item_edit
Feature: Supplier inspecting and maintaining an Item in the Item Directory
  # Created by Julian Sheppard on 21/06/2017

  Background: This is performed before each Scenario
    And  I log into Commerce Network as 'SUPPLIER_ADMIN_NONDESTRUCTIVE'
    And  I navigate to the internal 'Product Manager' page
    And  I click on the Product Manager 'Supplier' 'Items' submenu item


  Scenario: [item_edit.feature] Remove any Catfish items in directory due to previously crashed scenarios
    # Background section at start of Feature gets to Item Directory page
    When On the Item Directory page - I find and remove all CATFISH- items
    And I log out


  Scenario: [item_edit.feature] Check Edit Item page displays correctly for an existing standard item (Goods)
    # Background section at start of Feature gets to Item Directory page
    When On the Item Directory page - I enter 'CF53-DE0704' into 'SearchKeywords'
    And  On the Item Directory page - I click on the 'Search' button
    Then On the Item Directory page - I check that first item 'Name' value is 'Office swivel chair without armrest in blue'
    When On the Item Directory page - I click on the 'First Item Name' link
    # Page title area fields
    Then On the Edit Item page - I check that 'PageTitle' 'is' displayed
    And  On the Edit Item page - I check that 'UpdateMarketplaceButtonTop' 'is not' displayed
    And  On the Edit Item page - I check that 'PreviewButtonTop' 'is' displayed
    And  On the Edit Item page - I check that 'CancelButtonTop' 'is' displayed
    And  On the Edit Item page - I check that 'CopyButtonTop' 'is' displayed
    And  On the Edit Item page - I check that 'SaveButtonTop' 'is' displayed
    And  On the Edit Item page - I check that 'DeleteButtonTop' 'is not' displayed
    # Details fields
    And  On the Edit Item page - I check that 'ItemTypeLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ItemType' 'is' displayed
    And  On the Edit Item page - I check that 'DeliveryTypeLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'DeliveryType' 'is not' displayed
    And  On the Edit Item page - I check that 'ContractLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'ContractChoice' 'is not' displayed
    And  On the Edit Item page - I check that 'ContractSelectButton' 'is not' displayed
    And  On the Edit Item page - I check that 'AvailabilityLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'Availability' 'is not' displayed
    And  On the Edit Item page - I check that 'SupplierItemIDLabel' 'is' displayed
    And  On the Edit Item page - I check that 'SupplierItemID' 'is' displayed
    And  On the Edit Item page - I check that 'ItemTemplateLabel' 'is' displayed
    And  On the Edit Item page - I check that 'AddItemTemplateButton' 'is' displayed
    # Language specific section
    And  On the Edit Item page - I check that 'LanguageSpecificLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'EnglishLanguageButton' 'is not' displayed
    And  On the Edit Item page - I check that 'AddLanguageButton' 'is not' displayed
    And  On the Edit Item page - I check that 'NameLabel' 'is' displayed
    And  On the Edit Item page - I check that 'Name' 'is' displayed
    And  On the Edit Item page - I check that 'DescriptionLabel' 'is' displayed
    And  On the Edit Item page - I check that 'DescriptionInfoButton' 'is' displayed
    And  On the Edit Item page - I check that 'Description' 'is' displayed
    And  On the Edit Item page - I check that 'KeywordsLabel' 'is' displayed
    And  On the Edit Item page - I check that 'Keywords' 'is' displayed
    And  On the Edit Item page - I check that 'ItemAttributesLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ItemClassLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ItemClass' 'is' displayed
    And  On the Edit Item page - I check that 'ItemClassOption1' 'is' displayed
    And  On the Edit Item page - I check that 'ItemClassOption2' 'is' displayed
    And  On the Edit Item page - I check that 'ItemClassOption3' 'is' displayed
    And  On the Edit Item page - I check that 'ItemAttrNameLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ItemAttrValueLabel' 'is' displayed
    And  On the Edit Item page - I check that 'LegalServiceLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'LegalService' 'is not' displayed
    And  On the Edit Item page - I check that 'LegalSeniorityLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'LegalSeniority' 'is not' displayed
    And  On the Edit Item page - I check that 'EnvFriendlyLabel' 'is' displayed
    And  On the Edit Item page - I check that 'EnvFriendly' 'is' displayed
    And  On the Edit Item page - I check that 'EnvFriendlyOption1' 'is' displayed
    And  On the Edit Item page - I check that 'EnvFriendlyOption2' 'is' displayed
    And  On the Edit Item page - I check that 'HazardousLabel' 'is' displayed
    And  On the Edit Item page - I check that 'Hazardous' 'is' displayed
    And  On the Edit Item page - I check that 'HazardousOption1' 'is' displayed
    And  On the Edit Item page - I check that 'HazardousOption2' 'is' displayed
    And  On the Edit Item page - I check that 'HazardousOption3' 'is' displayed
    And  On the Edit Item page - I check that 'ManufacturerNameLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ManufacturerName' 'is' displayed
    And  On the Edit Item page - I check that 'ManufacturerItemIDLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ManufacturerItemID' 'is' displayed
    And  On the Edit Item page - I check that 'LeadTimeLabel' 'is' displayed
    And  On the Edit Item page - I check that 'LeadTime' 'is' displayed
    And  On the Edit Item page - I check that 'GTINLabel' 'is' displayed
    And  On the Edit Item page - I check that 'GTIN' 'is' displayed
    # Custom attributes section
    And  On the Edit Item page - I check that 'CustomAttributesLabel' 'is' displayed
    And  On the Edit Item page - I check that 'CustomAttrNameLabel' 'is' displayed
    And  On the Edit Item page - I check that 'CustomAttrValueLabel' 'is' displayed
    And  On the Edit Item page - I check that 'CustomAttributeAddButton' 'is' displayed
    # Comparison section
    And  On the Edit Item page - I check that 'ComparisonUOMLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ComparisonUOM' 'is' displayed
    And  On the Edit Item page - I check that 'ComparisonUOMEach' 'is' displayed
    And  On the Edit Item page - I check that 'ComparisonUOMHour' 'is' displayed
    And  On the Edit Item page - I check that 'ComparisonUOMKilogram' 'is' displayed
    And  On the Edit Item page - I check that 'ComparisonUOMLitre' 'is' displayed
    And  On the Edit Item page - I check that 'ComparisonUOMMetre' 'is' displayed
    And  On the Edit Item page - I check that 'ComparisonUOMSheet' 'is' displayed
    And  On the Edit Item page - I check that 'ComparisonUOMSquareMetre' 'is' displayed
    And  On the Edit Item page - I check that 'ComparisonScaleLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ComparisonScale' 'is' displayed
    # Classification section fields
    And  On the Edit Item page - I check that 'ClassificationTitle' 'is' displayed
    And  On the Edit Item page - I check that 'ProvidedLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ProvidedType' 'is' displayed
    And  On the Edit Item page - I check that 'ProvidedVersion' 'is' displayed
    And  On the Edit Item page - I check that 'ProvidedName' 'is' displayed
    And  On the Edit Item page - I check that 'StandardLabel' 'is' displayed
    And  On the Edit Item page - I check that 'StandardType' 'is' displayed
    And  On the Edit Item page - I check that 'StandardVersion' 'is' displayed
    And  On the Edit Item page - I check that 'StandardName' 'is' displayed
    And  On the Edit Item page - I check that 'ClassificationButton' 'is' displayed
    # Price Lists section fields
    And  On the Edit Item page - I check that 'PriceListsTitle' 'is' displayed
    And  On the Edit Item page - I check that 'PriceListsNameLabel' 'is' displayed
    And  On the Edit Item page - I check that 'PriceListsSpecialLabel' 'is' displayed
    And  On the Edit Item page - I check that 'PriceListsBasePriceLabel' 'is' displayed
    And  On the Edit Item page - I check that 'FirstPriceListNameLink' 'is' displayed
    And  On the Edit Item page - I check that 'FirstPriceListSpecialIcon' 'is' displayed
    And  On the Edit Item page - I check that 'FirstPriceListBasePriceLink' 'is' displayed
    And  On the Edit Item page - I check that 'FirstPriceListRemoveButton' 'is' displayed
    # Linked Media section fields
    And  On the Edit Item page - I check that 'LinkedMediaTitle' 'is' displayed
    And  On the Edit Item page - I check that 'LinkedMediaTitleLabel' 'is' displayed
    And  On the Edit Item page - I check that 'LinkedMediaDisplayDescLabel' 'is' displayed
    And  On the Edit Item page - I check that 'LinkedMediaFileNameLabel' 'is' displayed
    And  On the Edit Item page - I check that 'AddLinkedMediaButton' 'is' displayed
    # External Links section fields
    And  On the Edit Item page - I check that 'ExternalLinksTitle' 'is' displayed
    And  On the Edit Item page - I check that 'ExternalLinksLabelLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ExternalLinksAddressLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ExternalLinkAddButton' 'is' displayed
    # Page footer area fields
    And  On the Edit Item page - I check that 'UpdateMarketplaceButtonBottom' 'is not' displayed
    And  On the Edit Item page - I check that 'PreviewButtonBottom' 'is' displayed
    And  On the Edit Item page - I check that 'CancelButtonBottom' 'is' displayed
    And  On the Edit Item page - I check that 'CopyButtonBottom' 'is' displayed
    And  On the Edit Item page - I check that 'SaveButtonBottom' 'is' displayed
    And  On the Edit Item page - I check that 'DeleteButtonBottom' 'is not' displayed
    # Images area fields
    And  On the Edit Item page - I check that 'SelectImageFromMediaButton' 'is' displayed
    And  On the Edit Item page - I check that 'Image0Dropzone' 'is' displayed
    And  On the Edit Item page - I check that 'Image0RemoveButton' 'is' displayed
    And  On the Edit Item page - I check that 'Image0Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image1Dropzone' 'is' displayed
    And  On the Edit Item page - I check that 'Image2Dropzone' 'is' displayed
    And  On the Edit Item page - I check that 'Image3Dropzone' 'is' displayed
    And  On the Edit Item page - I check that 'Image4Dropzone' 'is' displayed
    And  On the Edit Item page - I check that 'Image5Dropzone' 'is' displayed
    And  On the Edit Item page - I check that 'Image6Dropzone' 'is' displayed
    And  On the Edit Item page - I check that 'Image7Dropzone' 'is' displayed
    And  On the Edit Item page - I check that 'Image8Dropzone' 'is' displayed
    And  On the Edit Item page - I check that 'Image9Dropzone' 'is' displayed
    # Check values
    And  On the Edit Item page - I check that 'PageTitle' value is 'Edit item'
    And  On the Edit Item page - I check that 'ItemType' value is 'Standard item'
    And  On the Edit Item page - I check that 'SupplierItemID' value is 'CF53-DE0704'
    And  On the Edit Item page - I check that 'Name' value is 'Office swivel chair without armrest in blue'
    And  On the Edit Item page - I check that 'Description' value is 'Chair, armrest in plastic black - dimensions: seat width 46 cm, seat depth 38-44 cm, seat height: 41 - 40 cm, seat height: 51.6 cm, total width 68.9 cm, total width 67.5 cm, total height 106 cm'
    And  On the Edit Item page - I check that 'Keywords' value is 'Chair FN'
    And  On the Edit Item page - I check that 'ItemClass' value is 'Goods'
    And  On the Edit Item page - I check that 'EnvFriendly' value is 'N/A'
    And  On the Edit Item page - I check that 'Hazardous' value is 'N/A'
    And  On the Edit Item page - I check that 'ManufacturerName' value is 'Steelcase'
    And  On the Edit Item page - I check that 'ManufacturerItemID' value is '466160MT LDB42A05M01SL1401oAL65mm'
    And  On the Edit Item page - I check that 'LeadTime' value is ''
    And  On the Edit Item page - I check that 'GTIN' value is ''
    And  On the Edit Item page - I check that 'ComparisonUOM' value is 'Each'
    And  On the Edit Item page - I check that 'ComparisonScale' value is '1'
    And  On the Edit Item page - I check that 'ProvidedType' value is 'UNSPSC'
    And  On the Edit Item page - I check that 'ProvidedVersion' value is 'v8'
    And  On the Edit Item page - I check that 'ProvidedName' value is 'Chairs'
    And  On the Edit Item page - I check that 'StandardType' value is 'UNSPSC'
    And  On the Edit Item page - I check that 'StandardVersion' value is 'v19'
    And  On the Edit Item page - I check that 'StandardName' value is 'Chairs'
    And  On the Edit Item page - I check that 'FirstPriceListNameLink' value is 'Catfish BMECat v5.3'
    And  On the Edit Item page - I check that 'FirstPriceListSpecialIcon' 'is' displayed
    And  On the Edit Item page - I check that 'FirstPriceListBasePriceLink' value is '269.00 EUR'
    And  I log out


  Scenario: [item_edit.feature] Check Edit Item page displays correctly for an existing Delivery Item
    # Background section at start of Feature gets to Item Directory page
    When On the Item Directory page - I click on the 'Delivery' filter
    Then On the Item Directory page - I check that first item 'Name' value is 'Medium Delivery Stage 1'
    When On the Item Directory page - I click on the 'First Item Image' link
    # Page title area fields
    Then On the Edit Item page - I check that 'PageTitle' 'is' displayed
    And  On the Edit Item page - I check that 'UpdateMarketplaceButtonTop' 'is not' displayed
    And  On the Edit Item page - I check that 'PreviewButtonTop' 'is not' displayed
    And  On the Edit Item page - I check that 'CancelButtonTop' 'is' displayed
    And  On the Edit Item page - I check that 'CopyButtonTop' 'is' displayed
    And  On the Edit Item page - I check that 'SaveButtonTop' 'is' displayed
    And  On the Edit Item page - I check that 'DeleteButtonTop' 'is not' displayed
    # Details fields
    And  On the Edit Item page - I check that 'ItemTypeLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ItemType' 'is' displayed
    And  On the Edit Item page - I check that 'DeliveryTypeLabel' 'is' displayed
    And  On the Edit Item page - I check that 'DeliveryType' 'is' displayed
    And  On the Edit Item page - I check that 'ContractLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'ContractChoice' 'is not' displayed
    And  On the Edit Item page - I check that 'ContractSelectButton' 'is not' displayed
    And  On the Edit Item page - I check that 'AvailabilityLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'Availability' 'is not' displayed
    And  On the Edit Item page - I check that 'SupplierItemIDLabel' 'is' displayed
    And  On the Edit Item page - I check that 'SupplierItemID' 'is' displayed
    And  On the Edit Item page - I check that 'ItemTemplateLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'AddItemTemplateButton' 'is not' displayed
    # Language specific section
    And  On the Edit Item page - I check that 'LanguageSpecificLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'EnglishLanguageButton' 'is not' displayed
    And  On the Edit Item page - I check that 'AddLanguageButton' 'is not' displayed
    And  On the Edit Item page - I check that 'NameLabel' 'is' displayed
    And  On the Edit Item page - I check that 'Name' 'is' displayed
    And  On the Edit Item page - I check that 'DescriptionLabel' 'is' displayed
    And  On the Edit Item page - I check that 'DescriptionInfoButton' 'is' displayed
    And  On the Edit Item page - I check that 'Description' 'is' displayed
    And  On the Edit Item page - I check that 'KeywordsLabel' 'is' displayed
    And  On the Edit Item page - I check that 'Keywords' 'is' displayed
    And  On the Edit Item page - I check that 'ItemAttributesLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'ItemClassLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'ItemClass' 'is not' displayed
    And  On the Edit Item page - I check that 'ItemAttrNameLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'ItemAttrValueLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'LegalServiceLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'LegalService' 'is not' displayed
    And  On the Edit Item page - I check that 'LegalSeniorityLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'LegalSeniority' 'is not' displayed
    And  On the Edit Item page - I check that 'EnvFriendlyLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'EnvFriendly' 'is not' displayed
    And  On the Edit Item page - I check that 'HazardousLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'Hazardous' 'is not' displayed
    And  On the Edit Item page - I check that 'ManufacturerNameLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'ManufacturerName' 'is not' displayed
    And  On the Edit Item page - I check that 'ManufacturerItemIDLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'ManufacturerItemID' 'is not' displayed
    And  On the Edit Item page - I check that 'LeadTimeLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'LeadTime' 'is not' displayed
    And  On the Edit Item page - I check that 'GTINLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'GTIN' 'is not' displayed

    And  On the Edit Item page - I check that 'CustomAttributesLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'CustomAttrNameLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'CustomAttrValueLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'CustomAttributeAddButton' 'is not' displayed
    # Comparison section
    And  On the Edit Item page - I check that 'ComparisonUOMLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'ComparisonUOM' 'is not' displayed
    And  On the Edit Item page - I check that 'ComparisonScaleLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'ComparisonScale' 'is not' displayed
    # Classification section fields
    And  On the Edit Item page - I check that 'ClassificationTitle' 'is' displayed
    And  On the Edit Item page - I check that 'ProvidedLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ProvidedType' 'is' displayed
    And  On the Edit Item page - I check that 'ProvidedVersion' 'is' displayed
    And  On the Edit Item page - I check that 'ProvidedName' 'is' displayed
    And  On the Edit Item page - I check that 'StandardLabel' 'is' displayed
    And  On the Edit Item page - I check that 'StandardType' 'is' displayed
    And  On the Edit Item page - I check that 'StandardVersion' 'is' displayed
    And  On the Edit Item page - I check that 'StandardName' 'is' displayed
    And  On the Edit Item page - I check that 'ClassificationButton' 'is' displayed
    # Price Lists section fields
    And  On the Edit Item page - I check that 'PriceListsTitle' 'is' displayed
    And  On the Edit Item page - I check that 'PriceListsNameLabel' 'is' displayed
    And  On the Edit Item page - I check that 'PriceListsSpecialLabel' 'is' displayed
    And  On the Edit Item page - I check that 'PriceListsBasePriceLabel' 'is' displayed
    And  On the Edit Item page - I check that 'FirstPriceListNameLink' 'is' displayed
    And  On the Edit Item page - I check that 'FirstPriceListSpecialIcon' 'is not' displayed
    And  On the Edit Item page - I check that 'FirstPriceListBasePriceLink' 'is' displayed
    And  On the Edit Item page - I check that 'FirstPriceListRemoveButton' 'is' displayed
    # Linked Media section fields
    And  On the Edit Item page - I check that 'LinkedMediaTitle' 'is not' displayed
    And  On the Edit Item page - I check that 'LinkedMediaTitleLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'LinkedMediaDisplayDescLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'LinkedMediaFileNameLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'AddLinkedMediaButton' 'is not' displayed
    # External Links section fields
    And  On the Edit Item page - I check that 'ExternalLinksTitle' 'is not' displayed
    And  On the Edit Item page - I check that 'ExternalLinksLabelLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'ExternalLinksAddressLabel' 'is not' displayed
    And  On the Edit Item page - I check that 'ExternalLinkAddButton' 'is not' displayed
    # Page footer area fields
    And  On the Edit Item page - I check that 'UpdateMarkeplaceButtonBottom' 'is not' displayed
    And  On the Edit Item page - I check that 'PreviewButtonBottom' 'is not' displayed
    And  On the Edit Item page - I check that 'CancelButtonBottom' 'is' displayed
    And  On the Edit Item page - I check that 'CopyButtonBottom' 'is' displayed
    And  On the Edit Item page - I check that 'SaveButtonBottom' 'is' displayed
    And  On the Edit Item page - I check that 'DeleteButtonBottom' 'is not' displayed
    # Images area fields
    And  On the Edit Item page - I check that 'SelectImageFromMediaButton' 'is' displayed
    And  On the Edit Item page - I check that 'Image0Dropzone' 'is' displayed
    And  On the Edit Item page - I check that 'Image0RemoveButton' 'is' displayed
    And  On the Edit Item page - I check that 'Image0Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image1Dropzone' 'is not' displayed
    And  On the Edit Item page - I check that 'Image2Dropzone' 'is not' displayed
    And  On the Edit Item page - I check that 'Image3Dropzone' 'is not' displayed
    And  On the Edit Item page - I check that 'Image4Dropzone' 'is not' displayed
    And  On the Edit Item page - I check that 'Image5Dropzone' 'is not' displayed
    And  On the Edit Item page - I check that 'Image6Dropzone' 'is not' displayed
    And  On the Edit Item page - I check that 'Image7Dropzone' 'is not' displayed
    And  On the Edit Item page - I check that 'Image8Dropzone' 'is not' displayed
    And  On the Edit Item page - I check that 'Image9Dropzone' 'is not' displayed
    # Check values
    And  On the Edit Item page - I check that 'PageTitle' value is 'Edit item'
    And  On the Edit Item page - I check that 'ItemType' value is 'Delivery Item'
    And  On the Edit Item page - I check that 'DeliveryType' value is 'Item'
    And  On the Edit Item page - I check that 'SupplierItemID' value is 'CF53-DEL-MED'
    And  On the Edit Item page - I check that 'Name' value is 'Medium Delivery Stage 1'
    And  On the Edit Item page - I check that 'Description' value is 'Delivery (Medium)'
    And  On the Edit Item page - I check that 'Keywords' value is 'Delivery,(Medium)'
    And  On the Edit Item page - I check that 'ProvidedType' value is 'UNSPSC'
    And  On the Edit Item page - I check that 'ProvidedVersion' value is 'v8'
    And  On the Edit Item page - I check that 'ProvidedName' value is 'Transportation components and systems'
    And  On the Edit Item page - I check that 'StandardType' value is 'UNSPSC'
    And  On the Edit Item page - I check that 'StandardVersion' value is 'v19'
    And  On the Edit Item page - I check that 'StandardName' value is 'Transportation components and systems'
    And  On the Edit Item page - I check that 'FirstPriceListNameLink' value is 'Catfish BMECat v5.3'
    And  On the Edit Item page - I check that 'FirstPriceListSpecialIcon' 'is not' displayed
    And  On the Edit Item page - I check that 'FirstPriceListBasePriceLink' value is '75.00 EUR'
    And  I log out


  Scenario: [item_edit.feature] For a new standard (Goods) item, check, edit, save and check values
    # Background section at start of Feature gets to Item Directory page
    # Create the new item:
    When On the Item Directory page - I click on the 'Create' button
    And  On the Create Item page - I enter 'CATFISH-ITEM5-' plus SessionGUID into 'SupplierItemID'
    And  On the Create Item page - I enter 'CATFISH-ITEM5 Name' into 'Name'
    And  On the Create Item page - I enter 'CATFISH-ITEM5 Description' into 'Description'
    And  On the Create Item page - I enter 'CATFISH-ITEM5 CATFISH' into 'Keywords'
    And  On the Create Item page - I select the 'Goods' option from the 'Item class' dropdown
    And  On the Create Item page - I select the 'Yes' option from the 'Environment friendly' dropdown
    And  On the Create Item page - I select the 'Yes' option from the 'Hazardous item' dropdown
    And  On the Create Item page - I enter 'CATFISH-ITEM5 ManufacturerName' into 'ManufacturerName'
    And  On the Create Item page - I enter 'CATFISH-ITEM5 ManufacturerItemID' into 'ManufacturerItemID'
    And  On the Create Item page - I enter 'CATFISH-ITEM5 LeadTime' into 'LeadTime'
    And  On the Create Item page - I enter 'CATFISH-ITEM5 GTIN' into 'GTIN'
    And  On the Create Item page - I click on the 'Custom Attribute Add' button
    And  On the Create Item page - I enter 'Grade' into 'FirstCustomAttrName'
    And  On the Create Item page - I enter '2' into 'FirstCustomAttrValue'
    And  On the Create Item page - I select the 'Kilogram' option from the 'Comparison UOM' dropdown
    And  On the Create Item page - I enter '1' into 'ComparisonScale'
    And  On the Create Item page - I click on the 'External Link Add' button
    And  On the Create Item page - I enter 'BBC News' into 'FirstExternalLinkLabel'
    And  On the Create Item page - I enter 'http://www.bbc.co.uk/news' into 'FirstExternalLinkAddress'
    # UNSPSC Classification
    And  On the Create Item page - I click on the 'Add Classification' button
    Then On the Select Classification page - I check that 'UNSPSCCode' value is '10000000'
    When On the Select Classification page - I enter '31121208' into 'UNSPSCCode'
    And  On the Select Classification page - I click on the 'Save' button
    # Save it
    When On the Create Item page - I click on the 'Save' button
    Then On the Edit Item page - I check that 'HeaderAlertMessage' 'is' displayed
    And  On the Edit Item page - I check that 'HeaderAlertMessage' value is 'Success! You added CATFISH-ITEM5 Name'
    When On the Edit Item page - I click on the 'HeaderAlertMessageClose' button
    # Check some display things
    Then On the Edit Item page - I check that 'HeaderAlertMessage' 'is not' displayed
    And  On the Edit Item page - I check that 'DeleteButtonTop' 'is' displayed
    And  On the Edit Item page - I check that 'DeleteButtonBottom' 'is' displayed
    And  On the Edit Item page - I check that 'ItemType' 'is not' enabled
    And  On the Edit Item page - I check that 'SupplierItemID' 'is' readonly
    # Check values
    And  On the Edit Item page - I check that 'PageTitle' value is 'Edit item'
    And  On the Edit Item page - I check that 'ItemType' value is 'Standard item'
    And  On the Edit Item page - I check that 'SupplierItemID' value is 'CATFISH-ITEM5-' plus SessionGUID
    And  On the Edit Item page - I check that 'Name' value is 'CATFISH-ITEM5 Name'
    And  On the Edit Item page - I check that 'Description' value is 'CATFISH-ITEM5 Description'
    And  On the Edit Item page - I check that 'Keywords' value is 'CATFISH-ITEM5 CATFISH'
    And  On the Edit Item page - I check that 'ItemClass' value is 'Goods'
    And  On the Edit Item page - I check that 'EnvFriendly' value is 'Yes'
    And  On the Edit Item page - I check that 'Hazardous' value is 'Yes'
    And  On the Edit Item page - I check that 'ManufacturerName' value is 'CATFISH-ITEM5 ManufacturerName'
    And  On the Edit Item page - I check that 'ManufacturerItemID' value is 'CATFISH-ITEM5 ManufacturerItemID'
    And  On the Edit Item page - I check that 'LeadTime' value is 'CATFISH-ITEM5 LeadTime'
    And  On the Edit Item page - I check that 'GTIN' value is 'CATFISH-ITEM5 GTIN'
    And  On the Edit Item page - I check that 'FirstCustomAttrName' value is 'Grade'
    And  On the Edit Item page - I check that 'FirstCustomAttrValue' value is '2'
    And  On the Edit Item page - I check that 'ComparisonUOM' value is 'Kilogram'
    And  On the Edit Item page - I check that 'ComparisonScale' value is '1'
    And  On the Edit Item page - I check that 'ProvidedType' value is 'UNSPSC'
    And  On the Edit Item page - I check that 'ProvidedVersion' value is 'v8'
    And  On the Edit Item page - I check that 'ProvidedName' value is 'Titanium sand machined castings'
    And  On the Edit Item page - I check that 'StandardType' value is 'UNSPSC'
    And  On the Edit Item page - I check that 'StandardVersion' value is 'v19'
    And  On the Edit Item page - I check that 'StandardName' value is 'Titanium sand machined castings'
    And  On the Edit Item page - I check that 'FirstExternalLinkLabel' value is 'BBC News'
    And  On the Edit Item page - I check that 'FirstExternalLinkAddress' value is 'http://www.bbc.co.uk/news'
    And  On the Edit Item page - I check that 'FirstExternalLinkRemoveButton' 'is' displayed
    # Change some values
    And  On the Edit Item page - I enter 'CATFISH-ITEM5 New Name' into 'Name'
    And  On the Edit Item page - I enter 'CATFISH-ITEM5 New Description' into 'Description'
    And  On the Edit Item page - I enter 'CATFISH-ITEM5 CATFISHNEW' into 'Keywords'
    And  On the Edit Item page - I select the 'N/A' option from the 'Environment friendly' dropdown
    And  On the Edit Item page - I select the 'No' option from the 'Hazardous item' dropdown
    And  On the Edit Item page - I enter 'CATFISH-ITEM5 New ManufacturerName' into 'ManufacturerName'
    And  On the Edit Item page - I enter 'CATFISH-ITEM5 New ManufacturerItemID' into 'ManufacturerItemID'
    And  On the Edit Item page - I enter 'CATFISH-ITEM5 New LeadTime' into 'LeadTime'
    And  On the Edit Item page - I enter 'CATFISH-ITEM5 New GTIN' into 'GTIN'
    And  On the Edit Item page - I enter 'Colour' into 'FirstCustomAttrName'
    And  On the Edit Item page - I enter 'Green' into 'FirstCustomAttrValue'
    And  On the Edit Item page - I click on the 'Custom Attribute Add' button
    And  On the Edit Item page - I enter 'Size' into 'SecondCustomAttrName'
    And  On the Edit Item page - I enter 'Large' into 'SecondCustomAttrValue'
    And  On the Edit Item page - I select the 'Litre' option from the 'Comparison UOM' dropdown
    And  On the Edit Item page - I enter '2' into 'ComparisonScale'
    And  On the Edit Item page - I click on the 'External Link Add' button
    And  On the Edit Item page - I enter 'Google' into 'SecondExternalLinkLabel'
    And  On the Edit Item page - I enter 'http://www.google.co.uk' into 'SecondExternalLinkAddress'
    And  On the Edit Item page - I click on the 'First External Link Remove' button
    # Save it
    When On the Edit Item page - I click on the 'Save' button
    Then On the Edit Item page - I check that 'HeaderAlertMessage' 'is' displayed
    And  On the Edit Item page - I check that 'HeaderAlertMessage' value is 'Success! You have updated CATFISH-ITEM5 New Name'
    # Search for the updated item
    When I click on the Product Manager 'Supplier' 'Items' submenu item
    When On the Item Directory page - I search for 'CATFISHNEW' until found or timeout
    Then On the Item Directory page - I check that 'ResultsShownTop' value is '1-1 / 1'
    And  On the Item Directory page - I check that first item 'Name' value is 'CATFISH-ITEM5 New Name'
    When On the Item Directory page - I click on the 'First Item Name' link
    # Check values
    Then On the Edit Item page - I check that 'SupplierItemID' value is 'CATFISH-ITEM5-' plus SessionGUID
    And  On the Edit Item page - I check that 'Name' value is 'CATFISH-ITEM5 New Name'
    And  On the Edit Item page - I check that 'Description' value is 'CATFISH-ITEM5 New Description'
    And  On the Edit Item page - I check that 'Keywords' value is 'CATFISH-ITEM5 CATFISHNEW'
    And  On the Edit Item page - I check that 'ItemClass' value is 'Goods'
    And  On the Edit Item page - I check that 'EnvFriendly' value is 'N/A'
    And  On the Edit Item page - I check that 'Hazardous' value is 'No'
    And  On the Edit Item page - I check that 'ManufacturerName' value is 'CATFISH-ITEM5 New ManufacturerName'
    And  On the Edit Item page - I check that 'ManufacturerItemID' value is 'CATFISH-ITEM5 New ManufacturerItemID'
    And  On the Edit Item page - I check that 'LeadTime' value is 'CATFISH-ITEM5 New LeadTime'
    And  On the Edit Item page - I check that 'GTIN' value is 'CATFISH-ITEM5 New GTIN'
    And  On the Edit Item page - I check that 'FirstCustomAttrName' value is 'Colour'
    And  On the Edit Item page - I check that 'FirstCustomAttrValue' value is 'Green'
    And  On the Edit Item page - I check that 'SecondCustomAttrName' value is 'Size'
    And  On the Edit Item page - I check that 'SecondCustomAttrValue' value is 'Large'
    And  On the Edit Item page - I check that 'ComparisonUOM' value is 'Litre'
    And  On the Edit Item page - I check that 'ComparisonScale' value is '2'
    And  On the Edit Item page - I check that 'ProvidedType' value is 'UNSPSC'
    And  On the Edit Item page - I check that 'ProvidedVersion' value is 'v8'
    And  On the Edit Item page - I check that 'ProvidedName' value is 'Titanium sand machined castings'
    And  On the Edit Item page - I check that 'StandardType' value is 'UNSPSC'
    And  On the Edit Item page - I check that 'StandardVersion' value is 'v19'
    And  On the Edit Item page - I check that 'StandardName' value is 'Titanium sand machined castings'
    And  On the Edit Item page - I check that 'FirstExternalLinkLabel' value is 'Google'
    And  On the Edit Item page - I check that 'FirstExternalLinkAddress' value is 'http://www.google.co.uk'
    # Tidy-up by removing the created and edited item:
    When On the Edit Item page - I click on the 'Delete' button
    And  I log out


  Scenario: [item_edit.feature] For a new delivery item, check, edit, save and check values
    # Background section at start of Feature gets to Item Directory page
    # Create the new item:
    When On the Item Directory page - I click on the 'Create' button
    And  On the Create Item page - I select the 'Delivery item' option from the 'Item type' dropdown
    And  I wait for the page refresh to complete
    And  On the Create Item page - I select the 'Item' option from the 'Delivery type' dropdown
    And  On the Create Item page - I enter 'CATFISH-ITEM6-' plus SessionGUID into 'SupplierItemID'
    And  On the Create Item page - I enter 'CATFISH-ITEM6 Name' into 'Name'
    And  On the Create Item page - I enter 'CATFISH-ITEM6 Description' into 'Description'
    And  On the Create Item page - I enter 'CATFISH-ITEM6 CATFISH' into 'Keywords'
    # UNSPSC Classification
    And  On the Create Item page - I click on the 'Add Classification' button
    Then On the Select Classification page - I check that 'UNSPSCCode' value is '10000000'
    When On the Select Classification page - I enter '78102205' into 'UNSPSCCode'
    And  On the Select Classification page - I click on the 'Save' button
    # Save it
    When On the Create Item page - I click on the 'Save' button
    Then On the Edit Item page - I check that 'HeaderAlertMessage' 'is' displayed
    And  On the Edit Item page - I check that 'HeaderAlertMessage' value is 'Success! You added CATFISH-ITEM6 Name'
    When On the Edit Item page - I click on the 'HeaderAlertMessageClose' button
    # Check some display things
    Then On the Edit Item page - I check that 'HeaderAlertMessage' 'is not' displayed
    And  On the Edit Item page - I check that 'DeleteButtonTop' 'is' displayed
    And  On the Edit Item page - I check that 'DeleteButtonBottom' 'is' displayed
    And  On the Edit Item page - I check that 'ItemType' 'is not' enabled
    And  On the Edit Item page - I check that 'SupplierItemID' 'is' readonly
    # Check values
    And  On the Edit Item page - I check that 'PageTitle' value is 'Edit item'
    And  On the Edit Item page - I check that 'ItemType' value is 'Delivery Item'
    And  On the Edit Item page - I check that 'DeliveryType' value is 'Item'
    And  On the Edit Item page - I check that 'SupplierItemID' value is 'CATFISH-ITEM6-' plus SessionGUID
    And  On the Edit Item page - I check that 'Name' value is 'CATFISH-ITEM6 Name'
    And  On the Edit Item page - I check that 'Description' value is 'CATFISH-ITEM6 Description'
    And  On the Edit Item page - I check that 'Keywords' value is 'CATFISH-ITEM6 CATFISH'
    And  On the Edit Item page - I check that 'ProvidedType' value is 'UNSPSC'
    And  On the Edit Item page - I check that 'ProvidedVersion' value is 'v8'
    And  On the Edit Item page - I check that 'ProvidedName' value is 'Letter or small parcel local delivery services'
    And  On the Edit Item page - I check that 'StandardType' value is 'UNSPSC'
    And  On the Edit Item page - I check that 'StandardVersion' value is 'v19'
    And  On the Edit Item page - I check that 'StandardName' value is 'Letter or small parcel local delivery services'
    # Change some values
    And  On the Edit Item page - I enter 'CATFISH-ITEM6 New Name' into 'Name'
    And  On the Edit Item page - I enter 'CATFISH-ITEM6 New Description' into 'Description'
    And  On the Edit Item page - I enter 'CATFISH-ITEM6 CATFISHNEW' into 'Keywords'
    And  On the Edit Item page - I click on the 'Add Classification' button
    Then On the Select Classification page - I check that 'UNSPSCCode' value is '78102205'
    When On the Select Classification page - I enter '78102206' into 'UNSPSCCode'
    And  On the Select Classification page - I click on the 'Save' button
    And  On the Edit Item page - I check that 'ProvidedName' value is 'Bicycle or scooter messenger services'
    And  On the Edit Item page - I check that 'StandardName' value is 'Bicycle or scooter messenger services'
    # Save it
    When On the Edit Item page - I click on the 'Save' button
    Then On the Edit Item page - I check that 'HeaderAlertMessage' 'is' displayed
    And  On the Edit Item page - I check that 'HeaderAlertMessage' value is 'Success! You have updated CATFISH-ITEM6 New Name'
    # Search for the updated item
    When I click on the Product Manager 'Supplier' 'Items' submenu item
    When On the Item Directory page - I search for 'CATFISHNEW' until found or timeout
    Then On the Item Directory page - I check that 'ResultsShownTop' value is '1-1 / 1'
    And  On the Item Directory page - I check that first item 'Name' value is 'CATFISH-ITEM6 New Name'
    When On the Item Directory page - I click on the 'First Item Name' link
    # Check values
    Then On the Edit Item page - I check that 'ItemType' value is 'Delivery Item'
    And  On the Edit Item page - I check that 'DeliveryType' value is 'Item'
    And  On the Edit Item page - I check that 'SupplierItemID' value is 'CATFISH-ITEM6-' plus SessionGUID
    And  On the Edit Item page - I check that 'Name' value is 'CATFISH-ITEM6 New Name'
    And  On the Edit Item page - I check that 'Description' value is 'CATFISH-ITEM6 New Description'
    And  On the Edit Item page - I check that 'Keywords' value is 'CATFISH-ITEM6 CATFISHNEW'
    And  On the Edit Item page - I check that 'ProvidedType' value is 'UNSPSC'
    And  On the Edit Item page - I check that 'ProvidedVersion' value is 'v8'
    And  On the Edit Item page - I check that 'ProvidedName' value is 'Bicycle or scooter messenger services'
    And  On the Edit Item page - I check that 'StandardType' value is 'UNSPSC'
    And  On the Edit Item page - I check that 'StandardVersion' value is 'v19'
    And  On the Edit Item page - I check that 'StandardName' value is 'Bicycle or scooter messenger services'
    # Tidy-up by removing the created and edited item:
    When On the Edit Item page - I click on the 'Delete' button
    And  I log out


  Scenario: [item_edit.feature] Check Preview page displays correctly
    # Background section at start of Feature gets to Item Directory page
    # Using an existing item
    When On the Item Directory page - I enter 'CF53-P911-MAN' into 'SearchKeywords'
    And  On the Item Directory page - I click on the 'Search' button
    Then On the Item Directory page - I check that first item 'Name' value is 'Porsche 911 Service Manual PDF'
    When On the Item Directory page - I click on the 'First Item Name' link
    # Add a few more details that can be displayed in the Preview
    And  On the Edit Item page - I click on the 'Custom Attribute Add' button
    And  On the Edit Item page - I enter 'Media' into 'FirstCustomAttrName'
    And  On the Edit Item page - I enter 'Electronic' into 'FirstCustomAttrValue'
    When On the Edit Item page - I click on the 'Add Linked Media' button
    When On the Select Media page - I enter 'Koinor' into 'SearchKeywords'
    And  On the Select Media page - I click on the 'Search' button
    Then On the Select Media page - I check that the number of 'Thumbnails' is '1'
    When On the Select Media page - I click on 'First' thumbnail
    And  On the Select Media page - I check that 'AddItemsButton' value is 'Add 1 items'
    When On the Select Media page - I click on the 'Add items' button
    And  On the Edit Item page - I click on the 'External Link Add' button
    And  On the Edit Item page - I enter 'Google' into 'FirstExternalLinkLabel'
    And  On the Edit Item page - I enter 'http://www.google.co.uk' into 'FirstExternalLinkAddress'
    # Now check the display in the Preview
    And  On the Edit Item page - I click on the 'Preview' button
    And  I wait for the modal popup to be 'displayed'
    Then On the Edit Item page - I check that 'ModalTitle' value is 'Item preview'
    When On the Edit Item page - I click on the 'ModalClosePreviewIcon' button
    And  I wait for the modal popup to be 'closed'
    And  On the Edit Item page - I click on the 'Preview' button
    And  I wait for the modal popup to be 'displayed'
    Then On the Edit Item page - I check that 'ModalTitle' value is 'Item preview'
    And  On the Edit Item page - I check that 'ModalImage' 'is' displayed
    And  On the Edit Item page - I check that 'ModalCarouselPreviousButton' 'is' displayed
    And  On the Edit Item page - I check that 'ModalCarouselNextButton' 'is' displayed
    And  On the Edit Item page - I check that 'ModalFirstCarouselItem' 'is' displayed
    And  On the Edit Item page - I check that 'ModalItemName' 'is' displayed
    And  On the Edit Item page - I check that 'ModalItemName' value is 'Porsche 911 Service Manual PDF'
    And  On the Edit Item page - I check that 'ModalSupplierLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ModalSupplier' 'is' displayed
    And  On the Edit Item page - I check that 'ModalSupplier' value is 'Catfish-NDT-Supplier'
    And  On the Edit Item page - I check that 'ModalItemIdLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ModalItemId' 'is' displayed
    And  On the Edit Item page - I check that 'ModalItemId' value is 'CF53-P911-MAN'
    And  On the Edit Item page - I check that 'ModalPriceLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ModalPrice' 'is' displayed
    And  On the Edit Item page - I check that 'ModalPrice' value is 'From Price List'
    And  On the Edit Item page - I check that 'ModalOrderUnitLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ModalOrderUnit' 'is' displayed
    And  On the Edit Item page - I check that 'ModalOrderUnit' value is 'From Price List'
    And  On the Edit Item page - I check that 'ModalIncrementLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ModalIncrement' 'is' displayed
    And  On the Edit Item page - I check that 'ModalIncrement' value is 'From Price List'
    And  On the Edit Item page - I check that 'PriceBreaksLabel' 'is' displayed
    And  On the Edit Item page - I check that 'PriceBreaks' 'is' displayed
    And  On the Edit Item page - I check that 'PriceBreaks' value is 'From Price List'
    And  On the Edit Item page - I check that 'ModalDeliveryLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ModalDelivery' 'is' displayed
    And  On the Edit Item page - I check that 'ModalDelivery' value is 'From Price List'
    And  On the Edit Item page - I check that 'ModalQuantityLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ModalQuantity' 'is' displayed
    And  On the Edit Item page - I check that 'ModalQuantity' value is '1.00'
    And  On the Edit Item page - I check that 'ModalAddButton' 'is' displayed
    And  On the Edit Item page - I check that 'ModalMinIncrLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ModalMinIncr' 'is' displayed
    And  On the Edit Item page - I check that 'ModalMinIncr' value is '1/'
    And  On the Edit Item page - I check that 'ModalDescriptionLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ModalDescription' 'is' displayed
    And  On the Edit Item page - I check that 'ModalDescription' value is '911 Service Manual PDF Format'
    And  On the Edit Item page - I check that 'ModalAdditionalInformationTitle' 'is' displayed
    And  On the Edit Item page - I check that 'ModalAddInfNameLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ModalAddInfValueLabel' 'is' displayed
    And  On the Edit Item page - I check that 'ModalFirstAddInfName' 'is' displayed
    And  On the Edit Item page - I check that 'ModalFirstAddInfName' value is 'Manufacturer name'
    And  On the Edit Item page - I check that 'ModalFirstAddInfValue' 'is' displayed
    And  On the Edit Item page - I check that 'ModalFirstAddInfValue' value is 'Porsche Cars Ltd'
    And  On the Edit Item page - I check that 'ModalSecondAddInfName' 'is' displayed
    And  On the Edit Item page - I check that 'ModalSecondAddInfName' value is 'Manufacturer product ID'
    And  On the Edit Item page - I check that 'ModalSecondAddInfValue' 'is' displayed
    And  On the Edit Item page - I check that 'ModalSecondAddInfValue' value is 'Porsche-MPID-3'
    And  On the Edit Item page - I check that 'ModalThirdAddInfName' 'is' displayed
    And  On the Edit Item page - I check that 'ModalThirdAddInfName' value is 'Media'
    And  On the Edit Item page - I check that 'ModalThirdAddInfValue' 'is' displayed
    And  On the Edit Item page - I check that 'ModalThirdAddInfValue' value is 'Electronic'
    And  On the Edit Item page - I check that 'ModalFirstLinkedMediaIcon' 'is' displayed
    And  On the Edit Item page - I check that 'ModalFirstLinkedMedia' 'is' displayed
    And  On the Edit Item page - I check that 'ModalFirstLinkedMedia' value is 'Koinor_Bronx'
    And  On the Edit Item page - I check that 'ModalExtLinksTitle' 'is' displayed
    And  On the Edit Item page - I check that 'ModalExtLinksWarning' 'is' displayed
    And  On the Edit Item page - I check that 'ModalFirstExtLink' 'is' displayed
    And  On the Edit Item page - I check that 'ModalFirstExtLink' value is 'Google'
    When On the Edit Item page - I click on the 'ModalClosePreview' button
    And  I wait for the modal popup to be 'closed'
    # Cancel the extra details that were added to the item
    When On the Edit Item page - I click on the 'Cancel' button
    And  I log out


  Scenario: [item_edit.feature] Check Copy item functionality
    # Background section at start of Feature gets to Item Directory page
    # Using an existing item
    When On the Item Directory page - I enter 'CF53-P911-ENG' into 'SearchKeywords'
    And  On the Item Directory page - I click on the 'Search' button
    Then On the Item Directory page - I check that first item 'Name' value is 'Porsche 911 Turbo Engine'
    When On the Item Directory page - I click on the 'First Item Name' link
    Then On the Edit Item page - I check that 'SupplierItemID' value is 'CF53-P911-ENG'
    And  On the Edit Item page - I check that 'Image0Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image1Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image2Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image3Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image4Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image5Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image6Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image7Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image8Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image9Image' 'is' displayed
    # Add some more details
    And  On the Edit Item page - I enter '4 days' into 'LeadTime'
    And  On the Edit Item page - I enter '29600170016807' into 'GTIN'
    And  On the Edit Item page - I click on the 'Custom Attribute Add' button
    And  On the Edit Item page - I enter 'Size' into 'FirstCustomAttrName'
    And  On the Edit Item page - I enter '3.6' into 'FirstCustomAttrValue'
    When On the Edit Item page - I click on the 'Add Linked Media' button
    When On the Select Media page - I enter 'Koinor' into 'SearchKeywords'
    And  On the Select Media page - I click on the 'Search' button
    Then On the Select Media page - I check that the number of 'Thumbnails' is '1'
    When On the Select Media page - I click on 'First' thumbnail
    And  On the Select Media page - I check that 'AddItemsButton' value is 'Add 1 items'
    When On the Select Media page - I click on the 'Add items' button
    And  On the Edit Item page - I click on the 'External Link Add' button
    And  On the Edit Item page - I enter 'Google' into 'FirstExternalLinkLabel'
    And  On the Edit Item page - I enter 'http://www.google.co.uk' into 'FirstExternalLinkAddress'
    # Copy the item
    When On the Edit Item page - I click on the 'Copy' button
    # Check display of copied details
    Then On the Create Item page - I check that 'ItemType' value is 'Standard item'
    And  On the Create Item page - I check that 'SupplierItemID' value is ''
    And  On the Create Item page - I check that 'Name' value is 'Porsche 911 Turbo Engine - Copy'
    And  On the Create Item page - I check that 'Description' value is '911 Turbo Engine'
    And  On the Create Item page - I check that 'Keywords' value is '911,Turbo,Engine'
    And  On the Create Item page - I check that 'ItemClass' value is 'Goods'
    And  On the Create Item page - I check that 'EnvFriendly' value is 'N/A'
    And  On the Create Item page - I check that 'Hazardous' value is 'N/A'
    And  On the Create Item page - I check that 'ManufacturerName' value is 'Porsche Cars Ltd'
    And  On the Create Item page - I check that 'ManufacturerItemID' value is 'Porsche-MPID-2'
    And  On the Create Item page - I check that 'LeadTime' value is '4 days'
    And  On the Create Item page - I check that 'GTIN' value is '29600170016807'
    And  On the Create Item page - I check that 'FirstCustomAttrName' value is 'Size'
    And  On the Create Item page - I check that 'FirstCustomAttrValue' value is '3.6'
    And  On the Create Item page - I check that 'ComparisonUOM' value is 'Each'
    And  On the Create Item page - I check that 'ComparisonScale' value is '1'
    And  On the Create Item page - I check that 'ProvidedType' value is 'UNSPSC'
    And  On the Create Item page - I check that 'ProvidedVersion' value is 'v8'
    And  On the Create Item page - I check that 'ProvidedName' value is 'Transportation components and systems'
    And  On the Create Item page - I check that 'StandardType' value is 'UNSPSC'
    And  On the Create Item page - I check that 'StandardVersion' value is 'v19'
    And  On the Create Item page - I check that 'StandardName' value is 'Transportation components and systems'
    And  On the Create Item page - I check that 'FirstLinkedMediaFileTitle' value is 'Koinor_Bronx'
    And  On the Create Item page - I check that 'FirstLinkedMediaFileName' value is 'Koinor_Bronx.pdf'
    And  On the Create Item page - I check that 'FirstExternalLinkLabel' value is 'Google'
    And  On the Create Item page - I check that 'FirstExternalLinkAddress' value is 'http://www.google.co.uk'
    And  On the Create Item page - I check that 'Image0Image' 'is' displayed
    And  On the Create Item page - I check that 'Image1Image' 'is' displayed
    And  On the Create Item page - I check that 'Image2Image' 'is' displayed
    And  On the Create Item page - I check that 'Image3Image' 'is' displayed
    And  On the Create Item page - I check that 'Image4Image' 'is' displayed
    And  On the Create Item page - I check that 'Image5Image' 'is' displayed
    And  On the Create Item page - I check that 'Image6Image' 'is' displayed
    And  On the Create Item page - I check that 'Image7Image' 'is' displayed
    And  On the Create Item page - I check that 'Image8Image' 'is' displayed
    And  On the Create Item page - I check that 'Image9Image' 'is' displayed
    # Save the new item
    When On the Create Item page - I enter 'CATFISH-ITEM7-' plus SessionGUID into 'SupplierItemID'
    When On the Create Item page - I enter 'CATFISH-ITEM7' into 'Keywords'
    And  On the Create Item page - I click on the 'Save' button
    # Check that it is now in the database:
    And  I click on the Product Manager 'Supplier' 'Items' submenu item
    # Need to use the following step because updating of search index is not immediate
    When On the Item Directory page - I search for 'CATFISH-ITEM7' until found or timeout
    Then On the Item Directory page - I check that 'ResultsShownTop' value is '1-1 / 1'
    And  On the Item Directory page - I check that first item 'Name' value is 'Porsche 911 Turbo Engine - Copy'
    And  On the Item Directory page - I check that first item 'ItemType' value is 'Standard'
    And  On the Item Directory page - I check that first item 'Description' value is '911 Turbo Engine'
    And  On the Item Directory page - I check that first item 'Status' value is 'New'
    And  On the Item Directory page - I check that first item 'ItemID' value is 'CATFISH-ITEM7-' plus SessionGUID
    # Check details of the newly created item:
    When On the Item Directory page - I click on the 'First Item Name' link
    Then On the Edit Item page - I check that 'ItemType' value is 'Standard item'
    And  On the Edit Item page - I check that 'SupplierItemID' value is 'CATFISH-ITEM7-' plus SessionGUID
    And  On the Edit Item page - I check that 'Name' value is 'Porsche 911 Turbo Engine - Copy'
    And  On the Edit Item page - I check that 'Description' value is '911 Turbo Engine'
    And  On the Edit Item page - I check that 'Keywords' value is 'CATFISH-ITEM7'
    And  On the Edit Item page - I check that 'ItemClass' value is 'Goods'
    And  On the Edit Item page - I check that 'EnvFriendly' value is 'N/A'
    And  On the Edit Item page - I check that 'Hazardous' value is 'N/A'
    And  On the Edit Item page - I check that 'ManufacturerName' value is 'Porsche Cars Ltd'
    And  On the Edit Item page - I check that 'ManufacturerItemID' value is 'Porsche-MPID-2'
    And  On the Edit Item page - I check that 'LeadTime' value is '4 days'
    And  On the Edit Item page - I check that 'GTIN' value is '29600170016807'
    And  On the Edit Item page - I check that 'FirstCustomAttrName' value is 'Size'
    And  On the Edit Item page - I check that 'FirstCustomAttrValue' value is '3.6'
    And  On the Edit Item page - I check that 'ComparisonUOM' value is 'Each'
    And  On the Edit Item page - I check that 'ComparisonScale' value is '1'
    And  On the Edit Item page - I check that 'ProvidedType' value is 'UNSPSC'
    And  On the Edit Item page - I check that 'ProvidedVersion' value is 'v8'
    And  On the Edit Item page - I check that 'ProvidedName' value is 'Transportation components and systems'
    And  On the Edit Item page - I check that 'StandardType' value is 'UNSPSC'
    And  On the Edit Item page - I check that 'StandardVersion' value is 'v19'
    And  On the Edit Item page - I check that 'StandardName' value is 'Transportation components and systems'
    And  On the Edit Item page - I check that 'FirstLinkedMediaFileTitle' value is 'Koinor_Bronx'
    And  On the Edit Item page - I check that 'FirstLinkedMediaFileName' value is 'Koinor_Bronx.pdf'
    And  On the Edit Item page - I check that 'FirstExternalLinkLabel' value is 'Google'
    And  On the Edit Item page - I check that 'FirstExternalLinkAddress' value is 'http://www.google.co.uk'
    And  On the Edit Item page - I check that 'Image0Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image1Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image2Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image3Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image4Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image5Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image6Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image7Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image8Image' 'is' displayed
    And  On the Edit Item page - I check that 'Image9Image' 'is' displayed
    # Tidy-up by removing the newly created item:
    When On the Edit Item page - I click on the 'Delete' button
    And  I log out
