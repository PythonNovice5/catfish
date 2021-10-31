@CLRegression
@AWSRegression
@SwitchToBuyingOrg

Feature: Switch-to to buying org and verify all necessary checks

 Scenario: Check menu item as PROC_USER_ALL_ROLES
  Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
  When I navigate to the internal 'My Profile' page
  Then I click on 'organizations' expandable menu option
  And  I click on switch-to to buying organisation '-Buyer'
  Then I verify I have switched to buying organisation
  And  I navigate to the internal 'Shopping' page
  And  I click on the Shopping 'Marketplace' submenu item
  Then  On the Marketplace Landing page - I click on the 'Search' button
  And  On the Marketplace Search Results page - I check that the number of results are more than 0
  When I navigate to the internal 'My Profile' page
  Then I click on 'organizations' expandable menu option
  And I click on switch-back to proc organisation '-Buyer'
  Then I log out