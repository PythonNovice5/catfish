@CLRegression
@AWSRegression
@customMapping
Feature: Create a custom mapping in Loader

  Scenario: Upload csv file and map all columns and create pricelist using the recent mapping

    Given I log into Commerce Network as 'SUPPLIER_ADMIN'

    When  I navigate to the internal 'Product Manager' page

    And  I click on the Product Manager 'Supplier' 'Loader' submenu item

    Then On Loader page - I verify header of the page

    When On Loader page - I click on 'Mapping Directory' panel

    Then On Mapping directory page - I click on create mapping button

    Then On Mapper page - I enter all details
      | Destination            | Products and Price Lists |
      | File type              | CSV File (.csv) |
      | Mapping Name           | CSV Mapping |
      | Description            | Catfish CSV Mapping |

    And  On Mapper page - I upload the csv file _EN_EUR_AUTO_QA.csv
    Then On Mapper page - I add constant column for 'UNSPSC'
    And On Mapper page - I add constant column for '8'
    Then On Mapper page - I drag all source columns to destination columns

      | sourceCustomId          | destinationCustomId |
      | sourceItemName          |  destinationItemName |
      | sourceItemType          | destinationItemType |
      | sourceDeliveryId        | destinationDeliveryId |
      | sourceDeliveryType      | destinationDeliveryType |
      | sourceUOM               | destinationUOM |
      | sourceNumberInOrderUnit | destinationNumberInOrderUnit|
      | sourceMinimumOrderUnity | destinationMinimumOrderQuantity |
      | sourceUnitPrice         | destinationUnitPrice |
      | sourceTaxRate           | destinationTaxRate |
      | sourceTaxTerritory      | destinationTaxTerritory |
      | sourceQualityInterval   | destinationQualityInterval  |
      | sourceUNSPSC            | destinationUNSPSC  |
      | sourceUnspscUNSPSCType  | destinationClassificationType  |
      | sourceUnspscVersion     | destinationUNSPSCVersion  |
      | sourceGoodsOrService    | destinationGoodsOrService |
      | sourceLongDescription   | destinationLongDescription |
      | sourceKeywords          | destinationKeywords |
      | sourceManufacturerPartId| destinationManufacturerPartId  |
      | sourceManufacturerName  | destinationManufacturerName |

    And On Mapper page - Save mapping

    Then On Mapper page - I add actions for fields
      | mappingActionDeliveryItemId  | NA |
      | mappingActionDeliveryType    | NA |
      | mappingActionItemClass       | NA |

    And On Mapper page - Save mapping

    When I click on the Product Manager 'Supplier' 'Loader' submenu item

    When On Loader page - I click on 'Mapping Directory' panel

    Then On Mapping directory page - I select upload button on recent custom mapping created

    And  I upload the csvTax file _EN_EUR_AUTO_QA.csv

    Then On Upload page - I enter all details
      | Output type    | Products and Price List |
      | Language       | English (UK) |
      | UNSPSC Version |  UNSPSC 8  |
      | Currency       | GBP |

    When On upload file page - I click on upload button

    Then The 2SL upload of the csv file has completed with VALID

    And On upload status page - I click on view to see the staged file

    Then On upload status page - I update the price for item first time

    And On Upload status page - I delete the record

    Then On staging page - I click on 'commit'

    Then The 2SL progress of the csv file has completed with PROCESS-COMPLETED

    Then I navigate to the PriceList page to verify upload is success

    And On pricelist page - I click on Sort By:Last modified

    And On Pricelist Page - I verify newly created pricelist Name

    And The file has processed 11 Items successfully

    And I click on the Price List Directory 'Delete' button

    When I click on the Product Manager 'Supplier' 'Loader' submenu item

    When On Loader page - I click on 'Mapping Directory' panel

    Then On Mapping directory page - I delete custom mapping created

    And I log out

  Scenario: Upload content loader excel file and map all columns and create pricelist using the recent mapping

    Given I log into Commerce Network as 'SUPPLIER_ADMIN'

    When  I navigate to the internal 'Product Manager' page

    And  I click on the Product Manager 'Supplier' 'Loader' submenu item

    Then On Loader page - I verify header of the page

    When On Loader page - I click on 'Mapping Directory' panel

    Then On Mapping directory page - I click on create mapping button

    Then On Mapper page - I enter all details
      | Destination            | Products and Price Lists |
      | File type              |  Excel Docs (.xls, .xlsx, .xlsm)  |
      | Mapping Name           | Content Loader Mapping |
      | Description            | Catfish Content Loader Mapping |
      | Start row              | 5 |

    And  On Mapper page - I upload the xlsx file _EN_EUR_AUTO_QA.xlsx

    Then On Mapper page - I enter all details
      | Sheet number            |  Item Data  |

    Then On Mapper page - I add constant column for 'UNSPSC'

    And On Mapper page - I add constant column for '8'

    Then On Mapper page - I drag all source columns to destination columns

      | sourceCustomId          | destinationCustomId |
      | sourceItemName          |  destinationItemName |
      | sourceItemType          | destinationItemType |
      | sourceDeliveryId        | destinationDeliveryId |
      | sourceDeliveryType      | destinationDeliveryType |
      | sourceUOM               | destinationUOM |
      | sourceNumberInOrderUnit | destinationNumberInOrderUnit|
      | sourceMinimumOrderUnity | destinationMinimumOrderQuantity |
      | sourceUnitPrice         | destinationUnitPrice |
      | sourceQualityInterval   | destinationQualityInterval  |
      | sourceUNSPSC            | destinationUNSPSC  |
      | sourceUnspscUNSPSCType  | destinationClassificationTypeNoTax  |
      | sourceUnspscVersion     | destinationUNSPSCVersionNoTax  |
      | sourceGoodsOrService    | destinationGoodsOrService |
      | sourceLongDescription   | destinationLongDescription |
      | sourceKeywords          | destinationKeywords |
      | sourceManufacturerPartId| destinationManufacturerPartId  |
      | sourceManufacturerName  | destinationManufacturerName |

    And On Mapper page - Save mapping

    Then On Mapper page - I add actions for fields
      | mappingActionDeliveryItemId  | NA |
      | mappingActionDeliveryType    | NA |
      | mappingActionItemClass       | NA |

    And On Mapper page - Save mapping

    When I click on the Product Manager 'Supplier' 'Loader' submenu item

    When On Loader page - I click on 'Mapping Directory' panel

    Then On Mapping directory page - I select upload button on recent custom mapping created

    And  I upload the xlsx file _EN_EUR_AUTO_QA.xlsx

    Then On Upload page - I enter all details
      | Output type    | Products and Price List |
      | Language       | English (UK) |
      | UNSPSC Version |  UNSPSC 8  |
      | Currency       | GBP |

    When On upload file page - I click on upload button

    Then The 2SL upload of the xlsx file has completed with VALID

    And On upload status page - I click on view to see the staged file

    Then On upload status page - I update the price for item first time

    And On Upload status page - I delete the record

    Then On staging page - I click on 'commit'

    Then The 2SL progress of the xlsx file has completed with PROCESS-COMPLETED

    Then I navigate to the PriceList page to verify upload is success

    And On pricelist page - I click on Sort By:Last modified

    And On Pricelist Page - I verify newly created pricelist Name

    And The file has processed 11 Items successfully

    And I click on the Price List Directory 'Delete' button

    When I click on the Product Manager 'Supplier' 'Loader' submenu item

    When On Loader page - I click on 'Mapping Directory' panel

    Then On Mapping directory page - I delete custom mapping created

    And I log out


