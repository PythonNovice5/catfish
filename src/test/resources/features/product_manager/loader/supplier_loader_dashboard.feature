Feature: Verify loader home page

Scenario: Validate all elements presence in the loader page

  Given I log into Commerce Network as 'SUPPLIER_ADMIN'
  And  I navigate to the internal 'Product Manager' page
  And  I click on the Product Manager 'Supplier' 'Loader' submenu item
  Then On Loader page - I verify header of the page
  And On Loader page - verify mandatory panels display for user
  Then I log out

