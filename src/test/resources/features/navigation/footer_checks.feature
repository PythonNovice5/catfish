@CLRegression
@AWSRegression
@FooterChecks
Feature: BTTF page navigation external footer links

  Scenario: Check footer links as PROC_USER_ALL_ROLES
    Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
    Then I navigate to the external 'Privacy Notice' page from a logged in page
    Then I navigate back to the last page from the external page window and close it
    Then I navigate to the external 'Acceptable Use Policy' page from a logged in page
    Then I navigate back to the last page from the external page window and close it
    Then I navigate to the external 'Cookie Notice' page from a logged in page
    Then I navigate back to the last page from the external page window and close it
    And I log out