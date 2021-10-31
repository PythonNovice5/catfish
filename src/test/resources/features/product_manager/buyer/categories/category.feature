@CLRegression
@AWSRegression
@Categories

Feature: Categories in Product Manager

  Scenario: [Create Category] Verify if user is able to create and publish the category
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Buyer' 'Categories' submenu item
    And On Manage Categories page - I delete previous data
    And On Manage Categories page - I click on 'Heading' in dropdown
    And On Manage Categories page - I enter 'Catfish - CLOTHING' of Heading '1'
    And On Manage Categories page - I enter multiple 'SHIRTS' and 'Green' of Category '1'
    And On Manage Categories page - I enter multiple 'Trouser' and 'Blue' of Category '2'
    And On Manage Categories page - I enter multiple 'Caps' and 'Red' of Category '3'
    And On Manage Categories page - I enter multiple 'Jackets' and 'CF53-UOM-Test-kits' of Category '4'
    And On Manage Categories page - I click on 'Heading' in dropdown
    And On Manage Categories page - I enter 'Catfish - Furniture' of Heading '2'
    And On Manage Categories page - I enter multiple 'Chair' and 'Wooden' of Category '5'
    And On Manage Categories page - I enter multiple 'Table' and 'Plastic' of Category '6'
    And On Manage Categories page - I enter multiple 'Bed' and 'Double' of Category '7'
    And On Manage Categories page - I enter multiple 'Sofa' and 'Seater' of Category '8'
    And On Manage Categories page - I click on Publish
    Then On Manage Categories page - I verify the success message
#    When I navigate to the internal 'Product Manager' page
    When I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    And I wait '1' seconds before continuing
    Then On the Marketplace Landing page - I verify the category search for 'Jackets' in 'Catfish - CLOTHING'