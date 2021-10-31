@CLRegression
@AWSRegression
@BuyerAgreementDirectory

Feature: Test all filters on Buyer Agreement Directory page

  Scenario: Test filters on Buyer Agreement Directory page
    Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
    Given I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Buyer' 'Manage Agreements' panel
    And I select the 'Relevance' option from the 'Sort By' dropdown
    And I select the 'Start Date' option from the 'Sort By' dropdown
    And I select the 'Expiry Date' option from the 'Sort By' dropdown
    And I select the 'Last modified' option from the 'Sort By' dropdown
    And I select the '25 results per page' option from the 'Results Per Page' dropdown
    And I select the '50 results per page' option from the 'Results Per Page' dropdown
    And I select the '100 results per page' option from the 'Results Per Page' dropdown
    Then I click on the Agreement 'Organisation Agreements' filter
    Then I click on the Agreement 'Punchout Agreements' filter
    Then I click on the Agreement 'Draft' filter
    Then I click on the Agreement 'Awaiting Response' filter
    Then I click on the Agreement 'Awaiting Approval' filter
    Then I verify 'Expiring' text in the page
    Then I click on the Agreement 'Expired' filter
    Then I click on the Agreement 'Active' filter
    Then I click on the Agreement 'Archived' filter
    Then I click on the Agreement 'All' filter
    Then I log out
