@products
Feature: BTTF Product Manager menu navigation checks

  Scenario: Check the Product Manager sub menu links work for PROC.user
    Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
    Then I navigate to the internal 'Product Manager' page
    Then I validate the Product Manager submenu items
    # SUPPLIER
    Then I click on the Product Manager 'Supplier' 'Home' submenu item
    Then I click on the Product Manager 'Supplier' 'Items' submenu item
    #Then I click on the Supplier Item Templates menu item
    Then I click on the Product Manager 'Supplier' 'Media' submenu item
    Then I click on the Product Manager 'Supplier' 'Price Lists' submenu item
    Then I click on the Product Manager 'Supplier' 'Agreements' submenu item
    # BUYER
    Then I click on the Product Manager 'Buyer' 'Home' submenu item
    Then I click on the Product Manager 'Buyer' 'Agreements' submenu item
    Then I click on the Product Manager 'Buyer' 'Groups' submenu item
    Then I click on the Product Manager 'Buyer' 'Views' submenu item
    Then I click on the Product Manager 'Buyer' 'Approvals' submenu item
    And I log out
