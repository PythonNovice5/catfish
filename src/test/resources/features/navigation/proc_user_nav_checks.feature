@navigation
Feature: BTTF page navigation checks

  Scenario: Check menu item as PROC_USER_ALL_ROLES
    Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
    When I click on the Basware icon and I remain on the same page
    Then I navigate to the internal 'Dashboard' page
    Then I navigate to the internal 'Documents' page
    Then I navigate to the internal 'Shopping' page
    Then I navigate to the internal 'Product Manager' page
    Then I navigate to the internal 'Directory' page
    Then I navigate to the internal 'Contracts' page
    Then I navigate to the internal 'Fieldglass' page which opens in a new window
    Then I navigate back to the last page from the internal page window and close it
    Then I navigate to the internal 'My Profile' page
    And I log out

  Scenario: Check menu item as PROC_USER_ALL_ROLES
    Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
    Then I navigate to the internal 'System Management' page via the Settings dropdown
    Then I navigate to the internal 'Identity Management' page via the Settings dropdown
    Then I navigate to the internal 'Root Management' page via the Settings dropdown
    Then I navigate to the internal 'Network Management' page via the Settings dropdown
    Then I navigate to the internal 'Community Management' page via the Settings dropdown
    Then I navigate to the internal 'Community Registration' page via the Settings dropdown
    Then I navigate to the internal 'Organisation Management' page via the Settings dropdown
    Then I navigate to the internal 'User Management' page via the Settings dropdown
    Then I navigate to the internal 'Supplier Registration' page via the Settings dropdown
    Then I navigate to the internal 'Request a Supplier' page via the Settings dropdown
    Then I navigate to the internal 'Request a Catalogue' page via the Settings dropdown
    Then I navigate to the internal 'Buyer Registration' page via the Settings dropdown
    Then I navigate to the internal 'Web Services Accounts' page via the Settings dropdown
    Then I navigate to the external 'Catalogue Access Management' tab via the Settings dropdown
    Then I navigate back to the last page from the external page window and close it
    And I log out

