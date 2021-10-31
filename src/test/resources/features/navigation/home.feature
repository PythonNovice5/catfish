@CLRegression
@AWSRegression
@Home
Feature: BTTF page navigation checks

  Scenario: Check the home page Knowledge Base link works
    Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
    Then On the Dashboard page - I navigate to the external Knowledge Base page which opens in a new window
    Then I navigate back to the last page from the external page window and close it
    And I log out