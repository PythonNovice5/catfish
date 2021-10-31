@2SLUpload
@CLRegression
@AWSRegression
Feature: Upload different file formats via 2SL and verify it all uploads creating pricelists

  @2slUploadCsvWithTax
  Scenario: Upload csv file with tax via 2SL loading and verify the price list created

    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    And  I navigate to the internal 'Product Manager' page
    And  I click on the Product Manager 'Supplier' 'Loader' submenu item
    When On Loader page - I click on 'Upload files' panel
    Then On Upload file page - I select mapping as 'Content Loader CSV (With Tax)'
    And  I upload the csvTax file _EN_EUR_AUTO_QA.csv
    Then On Upload page - I enter all details
      | Output type    | Products and Price List |
      | Language       | English (UK) |
      | UNSPSC Version |  UNSPSC 8  |
      | Currency       | GBP |
    When On upload file page - I click on upload button
    Then The 2SL upload of the csv file has completed with VALID
    And On upload status page - I click on view to see the staged file
    Then On staging page - I click on 'commit'
    Then The 2SL progress of the csv file has completed with PROCESS-COMPLETED
    Then I navigate to the PriceList page to verify upload is success
    And On pricelist page - I click on Sort By:Last modified
    And On Pricelist Page - I verify newly created pricelist Name
    And The file has processed 12 Items successfully
    And I click on the Price List Directory 'Delete' button
    And I log out

  @2slUploadCsv
  Scenario: Upload csv file via 2SL loading and verify the price list created
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    And  I navigate to the internal 'Product Manager' page
    And  I click on the Product Manager 'Supplier' 'Loader' submenu item
    When On Loader page - I click on 'Upload files' panel
    Then On Upload file page - I select mapping as 'Content Loader CSV'
    And  I upload the csv file _EN_EUR_AUTO_QA.csv
    Then On Upload page - I enter all details
      | Output type    | Products and Price List |
      | Language       | English (UK) |
      | UNSPSC Version |  UNSPSC 8  |
      | Currency       | GBP |
    When On upload file page - I click on upload button
    Then The 2SL upload of the csv file has completed with VALID
    And On upload status page - I click on view to see the staged file
    Then On staging page - I click on 'commit'
    Then The 2SL progress of the csv file has completed with PROCESS-COMPLETED
    Then I navigate to the PriceList page to verify upload is success
    And On pricelist page - I click on Sort By:Last modified
    And On Pricelist Page - I verify newly created pricelist Name
    And The file has processed 12 Items successfully
    And I click on the Price List Directory 'Delete' button
    And I log out

  @U2slUploadBMEcat
  Scenario: Upload xml file via 2SL loading and verify the price list created

    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    And  I navigate to the internal 'Product Manager' page
    And  I click on the Product Manager 'Supplier' 'Loader' submenu item
    When On Loader page - I click on 'Upload files' panel
    Then On Upload file page - I select mapping as 'BMEcat 1.2'
    And I upload the bmecat file _EN_EUR_AUTO_QA.xml
    Then On Upload page - I enter all details
      | Output type    | Products and Price List |
      | Language       | English (UK) |
      | UNSPSC Version |  UNSPSC 8  |
      | Currency       | GBP |
    When On upload file page - I click on upload button
    Then The 2SL upload of the xml file has completed with VALID
    And On upload status page - I click on view to see the staged file
    Then On staging page - I click on 'commit'
    Then The 2SL progress of the xml file has completed with PROCESS-COMPLETED
    Then I navigate to the PriceList page to verify upload is success
    And On pricelist page - I click on Sort By:Last modified
    And On Pricelist Page - I verify newly created pricelist Name
    And The file has processed 12 Items successfully
    And I click on the Price List Directory 'Delete' button
    And I log out

  @2slUploadExcel
  Scenario: Upload content loader excel file via 2SL loading and verify the price list created
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    And  I navigate to the internal 'Product Manager' page
    And  I click on the Product Manager 'Supplier' 'Loader' submenu item
    When On Loader page - I click on 'Upload files' panel
    Then On Upload file page - I select mapping as 'Content Loader Excel (5.8)'
    And I upload the xlsx file superContentLoader.xlsx
    Then On Upload page - I enter all details
      | Output type    | Products and Price List |
      | Language       | English (UK) |
      | UNSPSC Version |  UNSPSC 8  |
      | Currency       | GBP |
    When On upload file page - I click on upload button
    Then The 2SL upload of the xlsx file has completed with VALID
    And On upload status page - I click on view to see the staged file
    Then On staging page - I click on 'commit'
    Then The 2SL progress of the xlsx file has completed with PROCESS-COMPLETED
    Then I navigate to the PriceList page to verify upload is success
    And On pricelist page - I click on Sort By:Last modified
    And On Pricelist Page - I verify newly created pricelist Name
    And The file has processed 12 Items successfully
    And I click on the Price List Directory 'Delete' button
    And I log out