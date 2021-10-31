@marketplaceSearch
@CLRegression
@AWSRegression
Feature: Non-destructive testing of searching for items in the Marketplace

  Background: This is performed before each Scenario
    Given I log into Commerce Network as 'BUYER_ADMIN_NONDESTRUCTIVE'
    And  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
#    When On the Marketplace Landing page - I click on the 'newUI' toggle

  Scenario: [marketplace_searching.feature] Emptying the shopping basket
    # Background section at start of Feature gFets to Marketplace Landing page
    # Checking display of elements:
    When On the Marketplace Landing page - I click on the 'Basket' button
    When On the Shopping Basket page - I empty the shopping basket
    And  I log out

  Scenario: [marketplace_searching.feature] Verify types of item view formats
    When  On the Marketplace Landing page - I click on the 'Search' button
    And On the Marketplace Search Results page - I check that 'ShowAsListButton' 'is' displayed
    And On the Marketplace Search Results page - I check that 'ShowAsThumbnailButton' 'is' displayed
    And On the Marketplace Search Results page - I check that 'ShowAsTableButton' 'is' displayed
    And On the Marketplace Search Results page - I check that 'ShowAsListButtonText' value is 'Show as List'
    And On the Marketplace Search Results page - I check that 'ShowAsThumbnailButtonText' value is 'Show as Thumbnails'
    And On the Marketplace Search Results page - I check that 'ShowAsTableButtonText' value is 'Show as Table'
    When On the Marketplace Search Results page - I click on the 'ShowAsListButton' button
    And On the Marketplace Search Results page - I check that 'itemsInListView' 'is' displayed
    When On the Marketplace Search Results page - I click on the 'ShowAsThumbnailButton' button
    And On the Marketplace Search Results page - I check that 'itemsInThumbnailView' 'is' displayed
    When On the Marketplace Search Results page - I click on the 'ShowAsTableButton' button
    And On the Marketplace Search Results page - I check that 'itemsInTableView' 'is' displayed
    And I log out

  Scenario: [marketplace_searching.feature] Check Marketplace Search Results page Search works
#    When On the Marketplace Landing page - I click on the '' link
    When On the Marketplace Landing page - I enter 'catfish' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    And On the Marketplace Search Results page - I click on the 'FirstItemName' link
    And I log out

  Scenario: [marketplace_searching.feature] Check Marketplace Landing page displays correctly
    # Background section at start of Feature gets to Marketplace Landing page
    # Checking display of elements:
    Then On the Marketplace Landing page - I check that 'PageTitle' 'is' displayed
    And  On the Marketplace Landing page - I check that 'PageTitle' value is 'Marketplace'
    And  On the Marketplace Landing page - I check that 'QuotesIcon' 'is' displayed
    And  On the Marketplace Landing page - I check that 'QuotesText' 'is' displayed
#    And  On the Marketplace Landing page - I check that 'QuotesCount' 'is' displayed
#    And  On the Marketplace Landing page - I check that 'QuotesCount' value is '0'
    And  On the Marketplace Landing page - I check that 'ListsIcon' 'is' displayed
    And  On the Marketplace Landing page - I check that 'ListsText' 'is' displayed
    And  On the Marketplace Landing page - I check that 'CompareIcon' 'is' displayed
    And  On the Marketplace Landing page - I check that 'CompareText' 'is' displayed
#    And  On the Marketplace Landing page - I check that 'CompareCount' 'is' displayed
#    And  On the Marketplace Landing page - I check that 'CompareCount' value is '0'
    And  On the Marketplace Landing page - I check that 'BasketIcon' 'is' displayed
    And  On the Marketplace Landing page - I check that 'BasketText' 'is' displayed
    And  On the Marketplace Landing page - I check that 'BasketCount' 'is not' displayed
    And  On the Marketplace Landing page - I check that 'BasketValue' 'is not' displayed
    And  On the Marketplace Landing page - I check that 'BasketAmount' 'is not' displayed
    And  On the Marketplace Landing page - I check that 'BasketCurrency' 'is not' displayed
#    And  On the Marketplace Landing page - I check that 'MarketplaceWelcomeMessage' 'is' displayed
    And  On the Marketplace Landing page - I check that 'SearchKeywords' 'is' displayed
    And  On the Marketplace Landing page - I check that 'SearchButton' 'is' displayed
#    And  On the Marketplace Landing page - I check that 'CarouselPreviousButton' 'is not' displayed
#    And  On the Marketplace Landing page - I check that 'CarouselNextButton' 'is not' displayed
#    And  On the Marketplace Landing page - I check that 'CarouselFirstItem' 'is not' displayed
    And  On the Marketplace Landing page - I check that the number of 'Categories' is '0'
    And  I log out

  Scenario: [marketplace_searching.feature] Check Marketplace Search Results page displays first item correctly
    # Background section at start of Feature gets to Marketplace Landing page
    When On the Marketplace Landing page - I enter 'TestItemToCheckOut' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that first item 'Image' 'is' displayed
    And  On the Marketplace Search Results page - I check that first item 'Name' value is 'TestItemToCheckOut'
    And  On the Marketplace Search Results page - I check that first item 'SupplierName' value is '(from Catfish-NDT-Supplier)'
    And  On the Marketplace Search Results page - I check that first item 'ItemIDLabel' 'is' displayed
    And  On the Marketplace Search Results page - I check that first item 'ItemID' value is 'TestItemToCheckOut'
    And  On the Marketplace Search Results page - I check that first item 'ContractReferenceLabel' 'is' displayed
    And  On the Marketplace Search Results page - I check that first item 'ContractReference' value is 'CATFISH_CONTRACT'
    And  On the Marketplace Search Results page - I check that first item 'Description' value is 'TestItemToCheckOut'
    And  On the Marketplace Search Results page - I check that first item 'PriceCurrencyUnit' value is '20.00EUR'
#    And  On the Marketplace Search Results page - I check that first item 'QuantityLabel' 'is' displayed
    And  On the Marketplace Search Results page - I check that first item 'Quantity' 'is' displayed
    And  On the Marketplace Search Results page - I check that first item 'Quantity' value is '1'
    And  On the Marketplace Search Results page - I check that first item 'AddToBasketButton' 'is' displayed
    And  On the Marketplace Search Results page - I check that first item 'MinIncrLabel' 'is' displayed
    And  On the Marketplace Search Results page - I check that first item 'AddToListButton' 'is' displayed
    And  On the Marketplace Search Results page - I check that first item 'AddToComparisonButton' 'is' displayed
    # Checking an item that is free
    When On the Marketplace Search Results page - I click on the 'SearchClear' button
    And  On the Marketplace Search Results page - I enter 'Porsche 911 Service Manual PDF' into 'SearchKeywords'
    And  On the Marketplace Search Results page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that first item 'PriceCurrencyUnit' value is 'Free'
    And  I log out

  @VerifyHeaders
  Scenario: [marketplace_searching.feature] Check Marketplace Search Results page header area displays correctly
    # Background section at start of Feature gets to Marketplace Landing page
    When On the Marketplace Landing page - I enter '' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that 'PageTitle' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'PageTitle' value is 'Marketplace'
    And  On the Marketplace Search Results page - I check that 'HomeIcon' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'HomeText' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'PageTitle' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'QuotesIcon' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'QuotesText' 'is' displayed
#    And  On the Marketplace Search Results page - I check that 'QuotesCount' 'is' displayed
#    And  On the Marketplace Search Results page - I check that 'QuotesCount' value is '0'
    And  On the Marketplace Search Results page - I check that 'ListsIcon' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'ListsText' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'CompareIcon' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'CompareText' 'is' displayed
#    And  On the Marketplace Search Results page - I check that 'CompareCount' 'is' displayed
#    And  On the Marketplace Search Results page - I check that 'CompareCount' value is '0'
    And  On the Marketplace Search Results page - I check that 'BasketIcon' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'BasketText' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'BasketCount' 'is not' displayed
    And  On the Marketplace Search Results page - I check that 'BasketValue' 'is not' displayed
    And  On the Marketplace Search Results page - I check that 'BasketAmount' 'is not' displayed
    And  On the Marketplace Search Results page - I check that 'BasketCurrency' 'is not' displayed
    And  On the Marketplace Search Results page - I check that 'SearchKeywords' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'SearchClearButton' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'SearchButton' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'SearchCategoriesButton' 'is not' displayed
#    And  On the Marketplace Search Results page - I check that 'OrderByLabel' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'OrderBy' 'is' displayed
    And  I log out

  Scenario: Check Marketplace Search Results page adds an item to basket correctly
    And  On the Marketplace Landing page - I click on the 'Basket' button
    And  On the Shopping Basket page - I empty the shopping basket
    And I click on the Shopping 'Marketplace' submenu item
    When On the Marketplace Landing page - I enter 'catfish' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
    Then On the Marketplace Search Results page - I check that 'BasketCount' value is '1'
#    And  On the Marketplace Search Results page - I check that 'BasketValue' value is '33.99'
    And I log out

  Scenario: [marketplace_searching.feature] Check Marketplace Search Results page filters displayed correctly and work
    And  On the Marketplace Landing page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I check that 'FiltersTitle' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'PriceFiltersTitle' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'ContractReferenceFilterTitle' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'ManufacturerNameFilterTitle' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'SupplierFilterTitle' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'CategoriesFilterTitle' 'is' displayed
    When On the Marketplace Search Results page - I click on the 'Show Expired Items' filter
    When On the Marketplace Search Results page - I click on the 'Match all keywords' filter
    And On the Marketplace Search Results page - I enter '136.00' into 'MinPrice'
    And  On the Marketplace Search Results page - I enter '140.00' into 'MaxPrice'
    And  On the Marketplace Search Results page - I click on the 'Price Go' filter
    When On the Marketplace Search Results page - I click on the 'Clear Filters' link
    And I wait '1' seconds before continuing
    When On the Marketplace Search Results page - I click on the 'First Contract Reference' filter
    Then On the Marketplace Search Results page - I verify the 'First Item Contract Reference' value
    When On the Marketplace Search Results page - I click on the 'Clear Filters' link
    And I wait '1' seconds before continuing
    When On the Marketplace Search Results page - I click on the 'First Manufacturer Name' filter
    Then On the Marketplace Search Results page - I verify the 'First Item Manufacturer Name' value

    And  On the Marketplace Search Results page - I click on the 'First Supplier' filter
    Then On the Marketplace Search Results page - I verify the 'First Item Supplier Name' value
    When On the Marketplace Search Results page - I click on the 'Clear Filters' link
    And I wait '1' seconds before continuing

#    When On the Marketplace Search Results page - I click on the 'First Category' filter
#    Then On the Marketplace Search Results page - I verify the 'First Item Categorie Name' value
#    When On the Marketplace Search Results page - I click on the 'Clear Filters' link
    And I wait '1' seconds before continuing
    And I log out




