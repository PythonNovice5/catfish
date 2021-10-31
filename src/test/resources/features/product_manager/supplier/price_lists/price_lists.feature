@CLRegression
@AWSRegression

Feature: BTTF Product Manager Price List checks

  @ProductManagerPriceList
   Scenario: Create a Product Manager Price List
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    And I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Supplier' 'Price Lists' submenu item
    Then I click on the Price List Directory 'Search' button
    Then I click on the Price List Directory 'Create' button
    And I enter 'NEW-PRICE-LIST' into Create Price List 'Name'
    And I enter 'Rip-off prices' into Create Price List 'Reference'
    And I select the 'Select Currency' option from the Create Price List 'Currency' dropdown
    And I select the 'GBP' option from the Create Price List 'Currency' dropdown
    And I enter 'Up to 70% off - just for you!' into Create Price List 'Description'
    And I enter 'Sale Special Offer' into Create Price List 'Keywords'
    And I click on the Create Price List 'Save' button
    And on the Manage Price List page - I verify 'Success! You added price list:' is displayed
    And I click on the Manage Price List 'Delivery Items Manage' button
    Then I click on the Price List Directory 'Plus' button
    And  On the Manage Price list Item page - I enter '7.99' into 'Price'
    And On Manage Price list Item page - I click on 'Save' button
    And I click on the Price List Directory 'Done' button
    And I click on the Manage Price List 'Standard Items Manage' button
    And on Price list Standard Items page - I click on 'Plus' button
    And  On the Manage Price list Standard Item page - I enter '33.99' into 'Price' in row '1'
    And  On the Manage Price list Standard Item page - I enter '1' into 'NumOfUnits' in row '1'
    And  On the Manage Price list Standard Item page - I click on 'Plus' button
    And  On the Manage Price list Standard Item page - I enter '30.99' into 'Price' in row '2'
    And  On the Manage Price list Standard Item page - I enter '5' into 'NumOfUnits' in row '2'
    And  On the Manage Price list Standard Item page - I click on 'Plus' button
    And  On the Manage Price list Standard Item page - I enter '25.99' into 'Price' in row '3'
    And  On the Manage Price list Standard Item page - I enter '10' into 'NumOfUnits' in row '3'
    And  On the Manage Price list Standard Item page - I click on 'Plus' button
    And  On the Manage Price list Standard Item page - I enter '20' into 'NumOfUnits' in row '4'
    And  On the Manage Price list Standard Item page - I click on 'PriceOnRequest4' button
    And  On the Manage Price list Standard Item page - I click on 'Save' button
    And on Price list Standard Items page - I click on 'Plus' button
    And  On the Manage Price list Standard Item page - I enter '33.99' into 'Price' in row '1'
    And  On the Manage Price list Standard Item page - I enter '1' into 'NumOfUnits' in row '1'
    And  On the Manage Price list Standard Item page - I click on 'Plus' button
    And  On the Manage Price list Standard Item page - I enter '30.99' into 'Price' in row '2'
    And  On the Manage Price list Standard Item page - I enter '5' into 'NumOfUnits' in row '2'
    And  On the Manage Price list Standard Item page - I click on 'Plus' button
    And  On the Manage Price list Standard Item page - I enter '25.99' into 'Price' in row '3'
    And  On the Manage Price list Standard Item page - I enter '10' into 'NumOfUnits' in row '3'
    And  On the Manage Price list Standard Item page - I click on 'Plus' button
    And  On the Manage Price list Standard Item page - I enter '20' into 'NumOfUnits' in row '4'
    And  On the Manage Price list Standard Item page - I click on 'PriceOnRequest4' button
    And  On the Manage Price list Standard Item page - I click on 'Save' button
    And on Price list Standard Items page - I click on 'Done' button
    And I click on the Manage Price List 'Standard Items Manage' button
    And on Price list Standard Items page - I verify that '2' items are added
    And I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Supplier' 'Price Lists' submenu item
    And I enter 'PriceListName' into Price List Directory 'Search'
    Then I click on the Price List Directory 'Search' button
    And I click on the Price List Directory 'Delete' button
    And I log out

  @PriceListDirectoryFilters
  Scenario: Check the Product Manager Manage Price List Directory page filters work for SUPPLIER_ADMIN
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    And I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Supplier' 'Price Lists' submenu item
    When I click on the Price List Directory 'Punchout' page filter
    Then I check that 'Punchout' filter works as expected
    When I click on the Price List Directory 'Standard' page filter
    Then I check that 'Standard' filter works as expected
    When I click on the Price List Directory 'New' page filter
    Then I check that 'New' filter works as expected
    When I click on the Price List Directory 'Unpublished' page filter
    Then I check that 'Unpublished' filter works as expected
    When I click on the Price List Directory 'Withdrawn' page filter
    Then I check that 'Withdrawn' filter works as expected
    When I click on the Price List Directory 'Modified' page filter
    Then I check that 'Modified' filter works as expected
    When I click on the Price List Directory 'Published' page filter
    Then I check that 'Published' filter works as expected
    When I click on the Price List Directory 'With Items' page filter
    Then I check that 'With Items' filter works as expected
    When I click on the Price List Directory 'Without Items' page filter
    Then I check that 'Without Items' filter works as expected
    When I click on the Price List Directory 'Linked to Agreement(s)' page filter
    When I click on the Price List Directory first price list 'Manage' button
    When I click on the Manage Price List 'Agreements Manage' button
    Then I check that Price List Agreements has 'an' Agreement displayed
    And I click on the Product Manager 'Supplier' 'Price Lists' submenu item
    When I click on the Price List Directory 'Not linked to any Agreement' page filter
    And I click on the Price List Directory first price list 'Manage' button
    And I click on the Manage Price List 'Agreements Manage' button
    Then I check that Price List Agreements has 'no' Agreement displayed
    And I click on the Product Manager 'Supplier' 'Price Lists' submenu item
    When I select the 'Relevance' option from the 'Sort By' dropdown
    Then On Price List Directory page - I verify that 'Relevance' option is applied in 'SortFilterValue'
    When I select the 'Name' option from the 'Sort By' dropdown
    Then On Price List Directory page - I verify that 'Name' option is applied in 'SortFilterValue'
    When I select the 'Last modified' option from the 'Sort By' dropdown
    Then On Price List Directory page - I verify that 'Last modified' option is applied in 'SortFilterValue'
    When I select the '25 results per page' option from the 'Results Per Page' dropdown
    Then On Price List Directory page - I verify that '25 results per page' option is applied in 'SortPerPageValue'
    When I select the '50 results per page' option from the 'Results Per Page' dropdown
    Then On Price List Directory page - I verify that '50 results per page' option is applied in 'SortPerPageValue'
    When I select the '100 results per page' option from the 'Results Per Page' dropdown
    Then On Price List Directory page - I verify that '100 results per page' option is applied in 'SortPerPageValue'
    Then I log out

  @AgreementFilterCheckInPricelist
  Scenario: Check the Price List Agreements page filters work for SUPPLIER_ADMIN
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    And I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Supplier' 'Price Lists' submenu item
    When I click on the Price List Directory 'New' page filter
    And I click on the Price List Directory first price list name
    And I click on the Manage Price List 'Agreements Manage' button
    When I click on the Price List Agreements 'All' page filter
    #Then I check that Price List Agreements has 'an' Agreement displayed
    Then I check that Price List Agreements has 'no' Agreement displayed
    When I click on the Price List Agreements 'Approved' page filter
    Then I check that Price List Agreements has 'no' Agreement displayed
    When I click on the Price List Agreements 'Pending' page filter
    Then I check that Price List Agreements has 'no' Agreement displayed
    When I click on the Price List Agreements 'Declined' page filter
    Then I check that Price List Agreements has 'no' Agreement displayed
    And I log out
