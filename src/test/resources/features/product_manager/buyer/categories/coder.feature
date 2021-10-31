@CLRegression
@AWSRegression
@Coder

Feature: Coder in Product Manager

  Scenario: [Classification Mapper] Testing the Coder functionality
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Buyer' 'Manage your Coder' panel
    And On Coder page - I delete previous data
    And On Coder page - I click on plus button
    When On Coder page - I enter '12345678' into 'From'
    And On Coder page - I enter '87654321' into 'To'
    When On Coder page - I enter 'CatfishCode' into 'Code'
    And On Coder page - I enter 'CatfishDescription' into 'Description'
    And On Coder page - I click on 'Save' button
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Buyer' 'Manage your Coder' panel
    Then On Coder page - I verify 'From' value
    And On Coder page - I verify 'To' value
    And On Coder page - I verify 'Code' value
    And I log out













