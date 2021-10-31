@products
Feature: BTTF Product Manager Dashboard page navigation checks

  Scenario: Check the Product Manager Dashboard panel links work for PROC_USER_ALL_ROLES
    Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
    # SUPPLIER
    Then I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Supplier' 'View Agreements' panel
    Then I navigate to the internal 'Product Manager' page
    #Then I click on the Supplier Content Loader panel
    Then I click on the Product Manager 'Supplier' 'Upload Content' panel
    Then I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Supplier' 'View Items' panel
    Then I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Supplier' 'View Price Lists' panel
    Then I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Supplier' 'View Media' panel
    # BUYER
    Then I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Buyer' 'Create Agreement' panel
    Then I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Buyer' 'Create a View' panel
    Then I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Buyer' 'Create Group' panel
    Then I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Buyer' 'View your Approvals' panel
    And I log out

  Scenario: Check the Product Manager Dashboard workflow count links work for PROC_USER_ALL_ROLES
    Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
    # SUPPLIER
    Then I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Supplier' 'Media' workflow count
    Then I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Supplier' 'Items' workflow count
    Then I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Supplier' 'Price Lists' workflow count
    Then I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Supplier' 'Agreements' workflow count
    # BUYER
    Then I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Buyer' 'Groups' workflow count
    Then I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Buyer' 'Agreements' workflow count
    Then I navigate to the internal 'Product Manager' page
    Then I click on the Product Manager 'Buyer' 'Views' workflow count
    And I log out