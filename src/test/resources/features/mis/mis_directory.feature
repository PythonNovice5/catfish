@CLRegression
@misReportFilters
Feature: Test all filters MIS report page

Scenario: Verify filters and sort options works as expected on MIS page

  Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
  And I navigate to the internal 'MIS reports' page via the Settings dropdown
  Then On MIS dashboard page - I click on view all tile
  And On MIS report page - I select the 'Relevance' option from the 'Sort By' dropdown
  And On MIS report page - I select the 'Name' option from the 'Sort By' dropdown
  And On MIS report page - I select the 'Report Type' option from the 'Sort By' dropdown
  And On MIS report page - I select filter 'Summary Reports'
  And On MIS report page - I select filter 'Detailed Reports'
  And On MIS report page - I select filter 'Supplier Enablement Reports'
  And On MIS report page - I select filter 'Buyer Enablement Reports'
  And On MIS report page - I select filter 'Product Manager Reports'
  And On MIS report page - I select filter 'Custom Reports'
  And On MIS report page - I select filter 'All'
  And I log out
