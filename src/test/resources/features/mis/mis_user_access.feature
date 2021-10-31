@CLRegression
@misReportAccess
Feature: MIS regression checks

  Scenario: Verify Proc user who have right mis report access
    Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
    And I navigate to the internal 'MIS reports' page via the Settings dropdown
    Then On MIS dashboard page - I click on view all tile
    And On MIS report page - I verify '20' reports showing
    And I log out

  Scenario: Verify Buyer admin have right mis report access
    Given I log into Commerce Network as 'BUYER_ADMIN'
    And I navigate to the internal 'MIS reports' page via the Settings dropdown
    Then On MIS dashboard page - I click on view all tile
    And On MIS report page - I verify '12' reports showing
    And I log out

  Scenario: Verify mis download functionality
    Given I log into Commerce Network as 'BUYER_ADMIN'
    And I navigate to the internal 'MIS reports' page via the Settings dropdown
    Then On MIS dashboard page - I click on view all tile
    And On MIS report page - I select filter 'Summary Reports'
    Then On MIS report page - I click on run report button
    And  On MIS report page - I select transaction type 'All' on pop up
    And  On MIS report page - I select transaction type 'Invoice' on pop up
    Then On MIS report page - I click on create button
    And I log out






