@CLRegression
@AWSRegression
@ShareAgentAgreement
Feature: Share agent agreement via groups

  Scenario: Add agent agreement to groups and publish
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Buyer' 'Create Group' panel
    And  On the Create Group page - I enter 'Group Name' as 'Catfish group'
    And  On the Create Group page - I enter 'My description' as 'Catfish group description'
    And  On the Create Group page - I click on save and continue
    And  On the Manage group page - I click on cog to select 'members' for the group
    When  On the Manage Group page - I search 'Catfish-NDT-BUYER' in 'directoryInputSearch'
    Then  On the Manage Group Members Page - I select member to share
    And  On the Manage Group Members Page - I click on Done
    And  On the Manage group page - I click on cog to select 'resources' for the group
    And   On the Manage resources page - I search shared agreement 'Catfish agent agreement'
    And  On the Manage resources page - I select Agreement to share
    And  On the Manage resources page - I click on Done
    And  On the Manage Group page - I click on Publish
    Then On Group directory page - I search shared group
    Then On Group directory page - I click on search button
    When On Groups directory page - I click on 'manage cog' button
    And  On the Manage group page - I click on cog to select 'resources' for the group
    When On the Manage resources page - I select filter 'Added'
    Then On the Manage resource page - I remove recently added agreement
    And  On the Manage Group page - I click on Publish
    And  I log out