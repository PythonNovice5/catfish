@CLRegression
@AWSRegression
@Approvals
Feature: Create an agreement approval

  Scenario: Create a default agreement approval
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Buyer' 'Approvals' submenu item
    And I click on the Create button
    And On the Create approval page - I enter 'name' as 'CATFISH - DEFAULT-APPROVAL'
    And On the Create approval page - I enter 'description' as ' Creating catfish approval to test '
    And on the Create approval page - I save the approval
    And On the Manage approval page - I select 'approvers' as 'Auto'
    And On the Manage approval page - I save the approval
    And I log out

  Scenario: Create an agreement approval with Approvers
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Buyer' 'Approvals' submenu item
    And I click on the Create button
    And On the Create approval page - I enter 'name' as 'CATFISH - APPROVAL WITH APPROVERS'
    And On the Create approval page - I enter 'description' as ' Creating catfish agreement approval with approvers'
    And on the Create approval page - I save the approval
    And On the Manage approval page - I select 'approvers' as 'Add APPROVERS'
    And On the Manage approval page - I click on 'add levels'
    And On the Manage approval page - I click on 'add rule'
    And On the Manage approval page - I select 'Item added' in the modal window
    And On the Manage approval page - I click on 'add rule'
    And On the Manage approval page - I select 'Item removed' in the modal window
    And On the Manage approval page - I click on 'add rule'
    And On the Manage approval page - I select 'Base price increased' in the modal window
    And on the Manage approval page - I add '5' to the 'Base price increased'
    And On the Manage approval page - I click on 'add rule'
    And On the Manage approval page - I select 'base price decreased' in the modal window
    And on the Manage approval page - I add '5' to the 'Base price decreased'
    And On the Manage approval page - I select 'approvers' as 'level2 approvers'
    And On the Manage approval page - I click on 'quality scoring rules'
    And On the Manage approval page - I select 'image' in the modal window
    And On the Manage approval page - I click on 'quality scoring rules'
    And On the Manage approval page - I select 'Keywords' in the modal window
    And On the Manage approval page - I click on 'quality scoring rules'
    And On the Manage approval page - I select 'Attributes' in the modal window
    And On the Manage approval page - I click on 'quality scoring rules'
    And On the Manage approval page - I select 'Classification' in the modal window
    And On the Manage approval page - I click on 'quality scoring rules'
    And On the Manage approval page - I select 'Supplier part ID' in the modal window
    And On the Manage approval page - I save the approval
    And I log out









