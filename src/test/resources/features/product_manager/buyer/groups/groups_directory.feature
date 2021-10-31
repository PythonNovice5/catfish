@CLRegression
@AWSRegression
@groups_directory

Feature: Test all sort and filters in group directory page

  Scenario: Verify filters and sort options works as expected

    Given I log into Commerce Network as 'BUYER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Buyer' 'Groups' submenu item
    #And On Groups directory page - I select the 'Relevance' option from the 'Sort By' dropdown
    And On Groups directory page - I select the 'Name' option from the 'Sort By' dropdown
    And On Groups directory page - I select the 'Last modified' option from the 'Sort By' dropdown
    And On Groups directory page - I select the '25 results per page' option from the 'Results Per Page' dropdown
    And On Groups directory page - I select the '50 results per page' option from the 'Results Per Page' dropdown
    And On Groups directory page - I select the '100 results per page' option from the 'Results Per Page' dropdown
    And On Groups directory page - I select filter 'Community only'
    And On Groups directory page - I select filter 'My group only'
    And On Groups directory page - I select filter 'Membership only'
    And On Groups directory page - I select filter 'Invited only'
    And On Groups directory page - I select filter 'Rejected only'
    And On Groups directory page - I select filter 'All'
    And I log out
