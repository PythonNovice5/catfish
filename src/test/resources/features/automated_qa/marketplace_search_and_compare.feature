@CLRegression
@AWSRegression
@compare_items
Feature: Compare Items in Marketplace

  Background: This is performed before each Scenario
    When I log into Commerce Network as 'BUYER_ADMIN'
    And  I navigate to the internal 'Shopping' page
#    And  I click on the Shopping 'MarketplaceInGrails' submenu item
#    When On the Marketplace Landing page - I click on the 'newUI' toggle
    When I click on the Shopping 'Marketplace' submenu item
    And  On the Marketplace Landing page - I click on the 'Basket' button
    And  On the Shopping Basket page - I empty the shopping basket
    And  I click on the Shopping 'Marketplace' submenu item
    And  On the Marketplace Landing page - I click on the 'CompareItems' button
    And On the Item Comparison page - I remove all the added items for comparison

  Scenario: Verify that items can be added for comparison
    When  I click on the Shopping 'Marketplace' submenu item
    And On the Marketplace Landing page - I enter 'CF53-P911-SEAT' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that first item 'Name' 'is' displayed
    And  On the Marketplace Search Results page - I check that first item 'Name' value is 'Porsche 911 Seat Set'
    When On the Marketplace Search Results page - I click on the first item 'AddToComparison' button
    And I wait '2' seconds before continuing
    Then On the Marketplace Search Results page - I check that 'CompareCount' value is '1'
    When On the Marketplace Search Results page - I enter 'Porsche 911 Service Manual PDF' into 'SearchKeywords'
    And  On the Marketplace Search Results page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that first item 'Name' 'is' displayed
    And  On the Marketplace Search Results page - I check that first item 'Name' value is 'Porsche 911 Service Manual PDF'
    And  On the Marketplace Search Results page - I click on the first item 'Name' link
    And  On the Item Details page - I check that 'ItemName' value is 'Porsche 911 Service Manual PDF'
    And  On the Item Details page - I click on the 'AddToComparison' button
    And  On the Item Details page - I check that 'CompareCount' value is '2'
    And  On the Item Details page - I click on the 'Compare' button
    And  On the Item Comparison page - I check that the number of 'ItemNames' is '2'
    And  On the Item Comparison page - I check that first item 'ItemName' value is 'Porsche 911 Seat Set'
    And  On the Item Comparison page - I check that second item 'ItemName' value is 'Porsche 911 Service Manual PDF'
    Then I log out

  Scenario: Verify item details on Compare Page
    When  I click on the Shopping 'Marketplace' submenu item
    And On the Marketplace Landing page - I enter 'CF53-P911-SEAT' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that first item 'Name' 'is' displayed
    And  On the Marketplace Search Results page - I check that first item 'Name' value is 'Porsche 911 Seat Set'
    When On the Marketplace Search Results page - I click on the first item 'AddToComparison' button
    And I wait '2' seconds before continuing
    Then On the Marketplace Search Results page - I check that 'CompareCount' value is '1'
    When On the Marketplace Search Results page - I click on the 'CompareItems' button
    And I refresh page and wait '2' seconds before continuing
    Then On the Item Comparison page - I check that 'PageTitle' 'is' displayed
    And  On the Item Comparison page - I check that 'PageTitle' value is 'Compare Items'
    And  On the Item Comparison page - I check that 'HomeIcon' 'is' displayed
    And  On the Item Comparison page - I check that 'HomeText' 'is' displayed
    And  On the Item Comparison page - I check that 'QuotesIcon' 'is' displayed
    And I wait '1' seconds before continuing
    And  On the Item Comparison page - I check that 'QuotesText' value is 'Quotes'
    And  On the Item Comparison page - I check that 'ListsIcon' 'is' displayed
    And I wait '1' seconds before continuing
    And  On the Item Comparison page - I check that 'ListsText' value is 'Lists'
    And  On the Item Comparison page - I check that 'CompareIcon' 'is' displayed
    And I wait '1' seconds before continuing
    And  On the Item Comparison page - I check that 'CompareText' value is 'Compare Items'
    And  On the Item Comparison page - I check that 'CompareCount' value is '1'
    And  On the Item Comparison page - I check that 'BasketIcon' 'is' displayed
    And  On the Item Comparison page - I check that 'BasketText' value is 'Shopping basket(Empty)'
    And On the Item Comparison page - I check that first item 'ItemName' value is 'Porsche 911 Seat Set'
#    And  On the Item Comparison page - I check that 'ItemQnty' value is '1'
    And  On the Item Comparison page - I check that 'Supplier' value is 'Catfish-RW-Supplier'
    And  On the Item Comparison page - I check that 'ItemID' value is 'CF53-P911-SEAT'
    And  On the Item Comparison page - I check that 'ManfPartID' value is 'Porsche-MPID-12'
    And  On the Item Comparison page - I check that 'ComparisonPrice' value is '2,304.00 EUR'
    And  On the Item Comparison page - I check that 'PriceBreakNumber' value is '1 +'
    And  On the Item Comparison page - I check that 'Delivery' value is '120.00EUR'
    And  On the Item Comparison page - I check that 'ManfName' value is 'Porsche Cars Ltd'
    And  On the Item Comparison page - I check that 'ManProdID' value is 'Porsche-MPID-12'
    And  On the Item Comparison page - I check that first item 'ItemDesc' value is '911 Seat Set'
    And I log out

  Scenario: Verify labels and check if user is able to go back using 'Back To Search Results' link
    When  I click on the Shopping 'Marketplace' submenu item
    And On the Marketplace Landing page - I enter 'CF53-P911-SEAT' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that first item 'Name' 'is' displayed
    And  On the Marketplace Search Results page - I check that first item 'Name' value is 'Porsche 911 Seat Set'
    When On the Marketplace Search Results page - I click on the first item 'AddToComparison' button
    And I wait '2' seconds before continuing
    Then On the Marketplace Search Results page - I check that 'CompareCount' value is '1'
    When On the Marketplace Search Results page - I click on the 'CompareItems' button
    Then On the Item Comparison page - I check that 'PageTitle' 'is' displayed
    And  On the Item Comparison page - I check that 'PageTitle' value is 'Compare Items'
    And On the Item Comparison page - I check that 'ItemIDLabel' 'is' displayed
    And On the Item Comparison page - I check that 'ManfPartIDLabel' 'is' displayed
    And On the Item Comparison page - I check that 'ComparisonPriceLable' 'is' displayed
    And On the Item Comparison page - I check that 'PriceBreakLabel' 'is' displayed
    And On the Item Comparison page - I check that 'DeliveryLabel' 'is' displayed
    And On the Item Comparison page - I check that 'ManfNameLabel' 'is' displayed
    And On the Item Comparison page - I check that 'ManProdIDLabel' 'is' displayed
    And On the Item Comparison page - I check that 'DescLabel' 'is' displayed
    And On the Item Comparison page - I check that 'AddToBasketButton' 'is' displayed
    And On the Item Comparison page - I check that 'ItemQntyField' 'is' displayed
    And On the Item Comparison page - I check that 'ItemRemoveCross' 'is' displayed
    And On the Item Comparison page - I check that 'MinLabel' 'is' displayed
    And On the Item Comparison page - I check that 'IncrLabel' 'is' displayed
    And On the Item Comparison page - I check that 'UnitLabel' 'is' displayed
    When On the Item Comparison page - I click on 'BackToSearchResults' link
    Then On the Marketplace Search Results page - I check that 'PageTitle' 'is' displayed
    And  On the Marketplace Search Results page - I check that 'PageTitle' value is 'Marketplace'
    And I log out

  Scenario: Add item to the Shopping basket from Compare page and verify details
    When  I click on the Shopping 'Marketplace' submenu item
    And On the Marketplace Landing page - I click on the 'Search' button
    And I wait '1' seconds before continuing
    When On the Marketplace Search Results page - I enter 'CatFishSupIDNew1234' into 'SearchKeywords'
    And  On the Marketplace Search Results page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that first item 'Name' value is 'CatfishITEMLatestforTesting'
    When On the Marketplace Search Results page - I click on the first item 'AddToComparison' button
    And I wait '2' seconds before continuing
    Then On the Marketplace Search Results page - I verify item added to compare
    And On the Marketplace Search Results page - I click on the 'CompareItems' button
    Then On the Item Comparison page - I check that 'PageTitle' 'is' displayed
    And  On the Item Comparison page - I check that 'PageTitle' value is 'Compare Items'
    When On the Item Comparison page - I click on 'FirstItemAddToBasket' button
    And I wait '1' seconds before continuing
    And On the Item Comparison page - I click on 'Basket' button
    Then  On the Shopping Basket page - I check that 'CheckoutButton' 'is' displayed
    And  On the Shopping Basket page - I check that the number of 'SupplierNames' is '1'
    And  On the Shopping Basket page - I check that 'FirstSupplierName' 'is' displayed
    And  On the Shopping Basket page - I check that 'FirstSupplierName' value is 'Catfish-RW-Supplier'
    And  On the Shopping Basket page - I check that 'FirstSupplierAmount' 'is' displayed
    And  On the Shopping Basket page - I check that 'FirstSupplierAmount' value is '10.00'
    And  On the Shopping Basket page - I check that 'FirstSupplierCurrency' 'is' displayed
    And  On the Shopping Basket page - I check that 'FirstSupplierCurrency' value is 'EUR'
    And  On the Shopping Basket page - I check that the number of 'ItemNames' is '1'
    And  On the Shopping Basket page - I check that first item 'Image' 'is' displayed
    And  On the Shopping Basket page - I check that first item 'Name' 'is' displayed
    And  On the Shopping Basket page - I check that first item 'Name' value is 'CatfishITEMLatestforTesting'
    And  On the Shopping Basket page - I check that first item 'ItemIDLabel' 'is' displayed
    And  On the Shopping Basket page - I check that first item 'ItemID' 'is' displayed
    And  On the Shopping Basket page - I check that first item 'ItemID' value is 'CatFishSupIDNew1234'
    And On the Shopping Basket page - I check that first item 'Price' value is '10.00EUR'
    And  On the Shopping Basket page - I check that 'SummaryTotalAmount' value is '10.00EUR'
    And I log out

  Scenario: [marketplace_search_and_compare] Checkout two Items on Compare Page and verify Requisition
    When  I click on the Shopping 'Marketplace' submenu item
    And On the Marketplace Landing page - I enter 'CatFishSupIDNew1234' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that first item 'Name' 'is' displayed
    And  On the Marketplace Search Results page - I check that first item 'Name' value is 'CatfishITEMLatestforTesting'
    When On the Marketplace Search Results page - I click on the first item 'AddToComparison' button
    And I wait '2' seconds before continuing
    Then On the Marketplace Search Results page - I check that 'CompareCount' value is '1'
    When On the Marketplace Search Results page - I enter 'Porsche 911 Service Manual PDF' into 'SearchKeywords'
    And  On the Marketplace Search Results page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that first item 'Name' 'is' displayed
    And  On the Marketplace Search Results page - I check that first item 'Name' value is 'Porsche 911 Service Manual PDF'
    And  On the Marketplace Search Results page - I click on the first item 'Name' link
    And  On the Item Details page - I check that 'ItemName' value is 'Porsche 911 Service Manual PDF'
    And  On the Item Details page - I click on the 'AddToComparison' button
    And  On the Item Details page - I check that 'CompareCount' value is '2'
    And I wait '5' seconds before continuing
    And  On the Item Details page - I click on the 'Compare' button
    And I wait '5' seconds before continuing
    And  On the Item Comparison page - I check that the number of 'ItemNames' is '2'
    And  On the Item Comparison page - I check that first item 'ItemName' value is 'CatfishITEMLatestforTesting'
    And  On the Item Comparison page - I check that second item 'ItemName' value is 'Porsche 911 Service Manual PDF'
    And On the Item Comparison page - I click on 'FirstItemAddToBasket' button
    And  On the Item Comparison page - I check that 'BasketCount' value is '1'
    And I wait '1' seconds before continuing
    And On the Item Comparison page - I click on 'SecondItemAddToBasket' button
    And I wait '2' seconds before continuing
    And  On the Item Comparison page - I check that 'BasketCount' value is '2'
    And On the Item Comparison page - I click on 'Basket' button
    And On the Shopping Basket page - I check that 'CheckoutButton' 'is' displayed
    And On the Shopping Basket page - I click on the 'Checkout' button
    And  On the Requisition page - I check that first line 'Description' value is 'CatfishITEMLatestforTesting'
    And  On the Requisition page - I check that second line 'Description' value is 'Porsche 911 Service Manual PDF'
    And  On the Requisition page - I enter 'Catfish-' plus DateTimeNow into 'YourReference'
    And  On the Requisition page - I enter '01-01-2020' into 'TargetDeliveryDate'
    And  On the Requisition page - I enter 'Catfish special instructions' into 'SpecialInstructions'
    And  On the Requisition page - I enter 'Miss May Wander' into 'DeliverTo'
    And  On the Requisition page - I enter 'Upper Garden Path' into 'Address'
    And  On the Requisition page - I enter 'Toosum' into 'CityTown'
    And  On the Requisition page - I enter 'Bigplace' into 'County'
    And  On the Requisition page - I select the 'Norway' option from the 'CountryDropdown' dropdown
    And  On the Requisition page - I enter 'TO1 1ET' into 'Postcode'
    And  On the Requisition page - I enter '01234 567890' into 'PhoneNumber'
    And  On the Requisition page - I click on the 'Cancel' button
    Then I log out






















