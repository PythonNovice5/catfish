@createAutomationRecord
@CLRegression
@AWSRegression
Feature: Create automation record and delete using 2SL

  Scenario: Create automation record on UI

    Given I log into Commerce Network as 'SUPPLIER_ADMIN'

    When  I navigate to the internal 'Product Manager' page

    And  I click on the Product Manager 'Supplier' 'Loader' submenu item

    When On Loader page - I click on 'Automation' panel

    Then On Automation Page - I click on 'create' button

    And On Automation page - I enter all details

      | Name            | 2SL Automation  |
      | Enabled         |  Yes |
      | Automation Type | SFTP |
      | Location        | 2SLAutomation |
      | Data Mappings   | Content Loader CSV |
      | Output Type     | Products and Price List |
      | Language        | English (UK) |
      | UNSPSC Version  |  UNSPSC 8  |
      | Currency        | GBP |
      | Auto Commit     | Yes |
      | Auto Create     | Yes |
      | Auto Publish    | Yes  |
      | Create Email    | automation@basware.com  |
      | Error Email     | automation@basware.com |
      | Update Email    | automation@basware.com |

    Then On Automation page - I click in create to create record

    Then I verify new automation create successfully

    And  On Automation Page - I delete newly created automation

    Then I log out


