@CLRegression
@AWSRegression
@SupplierDelegation

Feature: Supplier delegation - As a Buyer Manger, can upload the content for a supplier and make content available to their end users, if supplier cannot upload the content

  Scenario: Verify supplier delegation functionality works as expected
    Given I log into Commerce Network as 'BUYER_ADMIN_NONDESTRUCTIVE'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Buyer' 'Suppliers' submenu item
    Then I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Supplier' 'Agreements' submenu item
    And On Supplier Agreement directory page - I click on exit supplier link
    And I log out


