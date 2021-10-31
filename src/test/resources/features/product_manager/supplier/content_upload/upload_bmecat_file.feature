@CLRegression
@AWSRegression
@BMEcat
Feature: Content Upload - Price list

  Scenario:
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Supplier' 'Upload Content' panel
    When I select the upload type Content Loader generated
    And I select the currency EUR for the price list
    And I select the language English for the price list
    And On Content Upload Page - I upload the bmecat file _EN_EUR_AUTO_QA.xml
    Then The upload of the xml file has completed with Succeeded
    Then I navigate to the PriceList page to verify upload is success
    And On pricelist page - I click on Sort By:Last modified
    And On Pricelist Page - I verify newly created pricelist Name
    And The file has processed 12 Items successfully
    And I click on the Price List Directory 'Delete' button
    And I log out


