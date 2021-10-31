@CLRegression
@AWSRegression
Feature: Supplier inspecting and maintaining Items in the Product Manager Item Directory
  # Created by Julian Sheppard on 21/06/2017

  Background: This is performed before each Scenario
    Given I log into Commerce Network as 'SUPPLIER_ADMIN_NONDESTRUCTIVE'
    And  I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Supplier' 'Items' submenu item


  Scenario: [item_directory.feature] Remove any Catfish items in directory due to previously crashed scenarios
    # Background section at start of Feature gets to Item Directory page
    When On the Item Directory page - I find and remove all CATFISH- items
    And I log out


  Scenario: [item_directory.feature] Check Item Directory page header area displays correctly
    # Background section at start of Feature gets to Item Directory page
    Then On the Item Directory page - I check that 'PageTitle' 'is' displayed
    And  On the Item Directory page - I check that 'PageTitle' value is 'Item directory'
    And  On the Item Directory page - I check that 'SearchKeywords' 'is' displayed
    And  On the Item Directory page - I check that 'SearchClearButton' 'is' displayed
    And  On the Item Directory page - I check that 'SearchButton' 'is' displayed
    And  On the Item Directory page - I check that 'PublishUpdatesButton' 'is' displayed
    And  On the Item Directory page - I check that 'CreateButton' 'is' displayed
    And I log out


  Scenario: [item_directory.feature] Check Item Directory page item details are displayed correctly
    # Background section at start of Feature gets to Item Directory page
    When On the Item Directory page - I enter 'OCI Jupiterr' into 'SearchKeywords'
    And  On the Item Directory page - I click on the 'Search' button
    Then On the Item Directory page - I check that first item 'Image' 'is' displayed
    And  On the Item Directory page - I check that first item 'Name' 'is' displayed
    Then On the Item Directory page - I check that first item 'Name' value is 'OCIToJupiterr'
    And  On the Item Directory page - I check that first item 'ItemTypeLabel' 'is' displayed
    And  On the Item Directory page - I check that first item 'ItemType' 'is' displayed
    And  On the Item Directory page - I check that first item 'ItemType' value is 'Punchout'
    And  On the Item Directory page - I check that first item 'DescriptionLabel' 'is' displayed
    And  On the Item Directory page - I check that first item 'Description' 'is' displayed
    And  On the Item Directory page - I check that first item 'Description' value is 'OCIToJupiterr'
    And  On the Item Directory page - I check that first item 'StatusLabel' 'is' displayed
    And  On the Item Directory page - I check that first item 'Status' 'is' displayed
    And  On the Item Directory page - I check that first item 'Status' value is 'Published'
    And  On the Item Directory page - I check that first item 'ItemIDLabel' 'is' displayed
    And  On the Item Directory page - I check that first item 'ItemID' 'is' displayed
    And  On the Item Directory page - I check that first item 'ItemID' value is 'OCI Jupiterr'
    And I log out

  @ItemDirectoryFilters
  Scenario: [item_directory.feature] Check Item Directory page filters work
    # Background section at start of Feature gets to Item Directory page
    When On the Item Directory page - I click on the 'All' filter
    Then On the Item Directory page - I validate the 'All' filter value in 'ResultsShownTop'
    When On the Item Directory page - I click on the 'Standard' filter
    Then On the Item Directory page - I validate the 'Standard' filter value in 'ResultsShownTop'
    When On the Item Directory page - I click on the 'Delivery' filter
    Then On the Item Directory page - I validate the 'Delivery' filter value in 'ResultsShownTop'
    When On the Item Directory page - I click on the 'Punchout' filter
    Then On the Item Directory page - I validate the 'Punchout' filter value in 'ResultsShownTop'
    When On the Item Directory page - I click on the 'Contract' filter
    Then On the Item Directory page - I validate the 'Contract' filter value in 'ResultsShownTop'
    When On the Item Directory page - I click on the 'New' filter
    Then On the Item Directory page - I validate the 'New' filter value in 'ResultsShownTop'
    When On the Item Directory page - I click on the 'Unpublished' filter
    Then On the Item Directory page - I validate the 'Unpublished' filter value in 'ResultsShownTop'
    When On the Item Directory page - I click on the 'Published' filter
    Then On the Item Directory page - I validate the 'Published' filter value in 'ResultsShownTop'
    When On the Item Directory page - I click on the 'Updated' filter
    Then On the Item Directory page - I validate the 'Updated' filter value in 'ResultsShownTop'
    When On the Item Directory page - I click on the 'Withdrawn' filter
    Then On the Item Directory page - I validate the 'Withdrawn' filter value in 'ResultsShownTop'
    When On the Item Directory page - I click on the 'WithImage' filter
    Then On the Item Directory page - I validate the 'WithImage' filter value in 'ResultsShownTop'
    When On the Item Directory page - I click on the 'WithoutImage' filter
    Then On the Item Directory page - I validate the 'WithoutImage' filter value in 'ResultsShownTop'
    When On the Item Directory page - I click on the 'WithTemplate' filter
    Then On the Item Directory page - I validate the 'WithTemplate' filter value in 'ResultsShownTop'
    When On the Item Directory page - I click on the 'WithoutTemplate' filter
    Then On the Item Directory page - I validate the 'WithoutTemplate' filter value in 'ResultsShownTop'
    And I log out

  @ItemDirectoryOrderBy
  Scenario: [item_directory.feature] Check Item Directory page Order By works
    # Background section at start of Feature gets to Item Directory page
    When On the Item Directory page - I select the 'Relevance' option from the 'Order By' dropdown
    Then On the Item Directory page - I verify that 'Relevance' option is applied in 'SortFilterValue'
    When On the Item Directory page - I select the 'Name' option from the 'Order By' dropdown
    Then On the Item Directory page - I verify that 'Name' option is applied in 'SortFilterValue'
    When On the Item Directory page - I select the 'Newest' option from the 'Order By' dropdown
    Then On the Item Directory page - I verify that 'Newest' option is applied in 'SortFilterValue'
    When On the Item Directory page - I select the 'Oldest' option from the 'Order By' dropdown
    Then On the Item Directory page - I verify that 'Oldest' option is applied in 'SortFilterValue'
    When On the Item Directory page - I select the '25' option from the 'Per Page' dropdown
    Then On the Item Directory page - I verify that '25 results per page' option is applied in 'SortPerPageValue'
    When On the Item Directory page - I select the '50' option from the 'Per Page' dropdown
    Then On the Item Directory page - I verify that '50 results per page' option is applied in 'SortPerPageValue'
    When On the Item Directory page - I select the '100' option from the 'Per Page' dropdown
    Then On the Item Directory page - I verify that '100 results per page' option is applied in 'SortPerPageValue'
    And I log out
