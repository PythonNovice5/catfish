@CLRegression
@AWSRegression
@SuperContentLoader
Feature: Upload price list with Standard items using super content loader file
  Scenario: Upload price list with Standard items using super content loader file
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    And  I navigate to the internal 'Product Manager' page
    And  I click on the Product Manager 'Supplier' 'Loader' submenu item
    When On Loader page - I click on 'Upload files' panel
    And On Upload file page - I select mapping as 'Super Content Loader Excel (1.0)'
    And On Upload File page - I update PriceListName in superContentLoader.xlsx

    And I upload the modifiedxlsx file superContentLoader.xlsx
    Then On Upload page - I enter all details
      | Output type    | Products and Price List |
      | Language       | English (UK) |
      | UNSPSC Version | UNSPSC 8 |
      | Currency       | GBP |
    When On upload file page - I click on upload button
    Then The 2SL upload of the slcxlsx file has completed with VALID
    And On upload status page - I click on view to see the staged file
    Then On staging page - I click on 'commit'
    Then The 2SL progress of the xlsx file has completed with PROCESS-COMPLETED
    Then I navigate to the PriceList page to verify upload is success
    And On pricelist page - I click on Sort By:Last modified
    And On Pricelist Page - I verify newly created pricelist Name
    And The file has processed 2 Items successfully
    And I click on the Price List Directory 'Delete' button
    And I log out

  @SCLMatrixAndBundle
  Scenario: Verify if the Matrix Items and Bundled Items can be uploaded using SCL file
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    And  I navigate to the internal 'Product Manager' page
    And  I click on the Product Manager 'Supplier' 'Loader' submenu item
    When On Loader page - I click on 'Upload files' panel
    And On Upload file page - I select mapping as 'Super Content Loader Excel (1.0)'
    And On Upload File page - I update PriceListName in SCLMatrixAndBundle.xlsx
    And I upload the modifiedxlsx file SCLMatrixAndBundle.xlsx
    Then On Upload page - I enter all details
      | Output type    | Products and Price List |
      | Language       | English (UK) |
      | UNSPSC Version | UNSPSC 8 |
      | Currency       | GBP |
    When On upload file page - I click on upload button
    Then The 2SL upload of the slcxlsx file has completed with VALID
    And On upload status page - I click on view to see the staged file
    Then On staging page - I click on 'commit'
    Then The 2SL progress of the xlsx file has completed with PROCESS-COMPLETED
    Then I navigate to the PriceList page to verify upload is success
    And On pricelist page - I click on Sort By:Last modified
    And On Pricelist Page - I verify newly created pricelist Name
    And The file has processed 13 Items successfully
    And I click on the Price List Directory first price list name
    Then On Manage Price list page - I verify 'MatrixItems' are '1'
    Then On Manage Price list page - I verify 'BundledItems' are '2'
    When I navigate to the PriceList page to verify upload is success
    And On pricelist page - I click on Sort By:Last modified
    And I click on the Price List Directory 'Delete' button
    And I log out
