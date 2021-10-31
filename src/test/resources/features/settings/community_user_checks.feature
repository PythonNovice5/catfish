@CLRegression
@CommunityUserChecks
Feature: Verify only allowed users display in the right community

  Scenario: Verify given community can only shows users that are allowed to see

    Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
    When I navigate to the internal 'My Profile' page
    Then I click on 'organizations' expandable menu option
    And  I click on switch-to to buying organisation 'Crown Commercial Service'
    Then I verify I have switched to buying organisation
    And I navigate to the internal 'Community Management' page via the Settings dropdown
    When On Community Management page - I click on 'user cog'
    Then On Community User page - I verify 'catfisheclass@cteclss' is not in the search results


  Scenario: Verify Root management user list shows only suppliers

    Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
    And I navigate to the internal 'Root Management' page via the Settings dropdown
    Then  On Root Management page - I click on Supplier users button
    And   On Root User management page - I verify 'catfisheclass@cteclss' is not in the search results

  Scenario: Verify MIS management add user list shows only buyers

    Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
    And I navigate to the internal 'MIS Management' page via the Settings dropdown
    Then On MIS Management page - I click 'add' button
    When On MIS User management page - I verify supplier 'SUPPLIER_ADMIN' is not in the search results

