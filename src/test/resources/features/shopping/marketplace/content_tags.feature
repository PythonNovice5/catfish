@CLRegression
@AWSRegression
@ContentTag
Feature: Create content tags and verify in Marketplace

  Scenario: Create content tags and publish to Marketplace
    Given I log into Commerce Network as 'BUYER_ADMIN_NONDESTRUCTIVE'
    Given I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Buyer' 'Agreements' submenu item
    Then On Buyer Agreement directory page - I search agreement as 'Content tag agreement'
    Then On Buyer Agreement directory page - I click on cog to manage agreement
    Then On the Manage Agreement page - I verify if there are any old tags there
    And  On the Manage Agreement page - I click on the 'add content tag' button
    When Enter content tag name as 'CATFISHCONTENTTAG' in the modal popup
    Then I click on 'add' button in the modal popup
    When On the Manage Agreement page - I click on the 'review pricelist cog' button
    Then On Buyer Manage Agreement price list page - click On content tag drop down for '1' item and choose 'catfishcontenttag'
    And  On Buyer Manage Agreement price list page - click On content tag drop down for '2' item and choose 'catfishcontenttag'
    And  On Buyer Manage Agreement price list page - I click on done
    And  On the Manage Agreement page - I click on the 'publish' button
    And  I navigate to the internal 'Shopping' page
    When I click on the Shopping 'Marketplace' submenu item
    And  On the Marketplace Landing page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I verify content tag section appears
    And  On the Marketplace Search Results page - I click on newly created 'catfishcontenttag'
    And  On the Marketplace Search Results page - I check that content tag is displayed
    When On the Marketplace Search Results page - I click on the 'ShowAsThumbnailButton' button
    Then  On the Marketplace Search Results page - I verify results are displaying correct
  # remove the content tag which is created in the tests
    Given I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Buyer' 'Agreements' submenu item
    Then On Buyer Agreement directory page - I search agreement as 'Content tag agreement'
    Then On Buyer Agreement directory page - I click on cog to manage agreement
    When On the Manage Agreement page - I click on the 'remove content tag' button
    Then On the Manage Agreement page - I verify message in popup
    When On the Manage Agreement page - I click on the 'review pricelist cog' button
    Then On Buyer Manage Agreement price list page - click On content tag drop down for '1' item and choose 'None'
    And  On Buyer Manage Agreement price list page - click On content tag drop down for '2' item and choose 'None'
    And  On Buyer Manage Agreement price list page - I click on done
    Then On the Manage Agreement page - I click on the 'remove content tag' button
    Then On the Manage Agreement page - I click delete in modal popup
    And  I log out




