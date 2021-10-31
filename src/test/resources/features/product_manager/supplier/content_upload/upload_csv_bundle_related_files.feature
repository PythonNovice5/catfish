@CLRegression
@AWSRegression
Feature: Verify Import and export pricelist, and also upload Bundled and Related items

  @UploadBundleItems
  @UploadRelatedItems
  @ImportAndExportPricelist
  Scenario:
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Supplier' 'Upload Content' panel
    When I select the upload type Content Loader CSV
    And I select the currency EUR for the price list
    And I select the language English for the price list
    And On Content Upload Page - I upload the csv file _EN_EUR_AUTO_CSV_QA.csv
    Then The upload of the csv file has completed with Succeeded
    Then I navigate to the PriceList page to verify upload is success
    And On pricelist page - I click on Sort By:Last modified
    And On Pricelist Page - I verify newly created pricelist Name
    And The file has processed 12 Items successfully
    And I click on the Price List Directory first price list name
    And I click on the Manage Price List 'export pricelist' button
    And I click on the Manage Price List 'import pricelist' button
    And I select 'Merge with existing items on this price list.'
    Then  On Content Upload Page - I upload the pricelist file _PRICELIST_CSV_QA.csv
    Then On upload bundles page - I click on upload button to upload
    Then On the Manage Price list page - I verify 'pricelist items'
    And I click on the Manage Price List 'import bundle' button
    Then  On Content Upload Page - I upload the bundled file _BUNDLED_CSV_QA.csv
    Then On upload bundles page - I click on upload button to upload
    Then On the Manage Price list page - I verify 'bundled items'
    Then I click on the Manage Price List 'import related items' button
    Then On Content Upload Page - I upload the related file _RELATED_CSV_QA.csv
    Then On upload bundles page - I click on upload button to upload
    Then On the Manage Price list page - I verify 'related items'
    And I log out