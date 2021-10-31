@CLRegression
@AWSRegression
@SupplierAgreementDirectory

Feature: Test all filters and drop down lists on Supplier Directory page

  Scenario: Test all filters and drop down lists on Supplier Directory page.
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    Given I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Supplier' 'View Agreements' panel
    And I select the 'Start Date' option from the 'Sort By' dropdown
    And I select the 'Expiry Date' option from the 'Sort By' dropdown
    And I select the 'Last Modified' option from the 'Sort By' dropdown
    And I select the '25 results per page' option from the 'Results Per Page' dropdown
    And I select the '50 results per page' option from the 'Results Per Page' dropdown
    And I select the '100 results per page' option from the 'Results Per Page' dropdown
    Then I click on the Supplier Agreement 'Organisation Agreements' filter
    Then I click on the Supplier Agreement 'Punchout Agreements' filter
#    Then I click on the Supplier Agreement 'Shared Agreements' filter
    Then I click on the Supplier Agreement 'New' filter
    Then I click on the Supplier Agreement 'Awaiting Response' filter
    Then I click on the Supplier Agreement 'Awaiting Approval' filter
    Then I click on the Supplier Agreement 'Expiring Soon' filter
    Then I click on the Supplier Agreement 'Expired' filter
    Then I click on the Supplier Agreement 'Active' filter
    Then I click on the Supplier Agreement 'All' filter
    Then I click on the Supplier Agreement 'Manage Icon' to view Agreement
    Then I click on the Supplier Agreement 'Back to Agreement Directory' link
    Then I log out






