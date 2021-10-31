@shoppingBasket
@CLRegression
@AWSRegression
Feature: Non-destructive testing of shopping in the Marketplace

  Background: This is performed before each Scenario
    Given I log into Commerce Network as 'BUYER_ADMIN_NONDESTRUCTIVE'
    And  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item

  Scenario: [shopping_basket.feature] Emptying the shopping basket
    # Background section at start of Feature gets to Marketplace Landing page
    # Checking display of elements:
    When On the Marketplace Landing page - I click on the 'Basket' button
    When On the Shopping Basket page - I empty the shopping basket
    And  I log out

  Scenario: [shopping_basket.feature] Check Marketplace Search Results page adds, updates and removes items to/in/from the basket correctly
    # Background section at start of Feature gets to Marketplace Landing page
    # Checking addition of items to the basket:
    When On the Marketplace Landing page - I enter 'CF53-DEV-8692-01_03' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
    Then On the Marketplace Search Results page - I check that 'BasketCount' value is '1'
    And  On the Marketplace Search Results page - I check that 'BasketValue' value is '5.00EUR'
    When On the Marketplace Search Results page - I enter 'CF53-P911-MAN' into 'SearchKeywords'
    And  On the Marketplace Search Results page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I enter '2' into first item 'Quantity'
    And  On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
    And I wait '1' seconds before continuing
    Then On the Marketplace Search Results page - I check that 'BasketCount' value is '2'
    When I wait '1' seconds before continuing
    Then  On the Marketplace Search Results page - I check that 'BasketValue' value is '5.00EUR'
    When On the Marketplace Search Results page - I enter 'CF53-P911-ENG' into 'SearchKeywords'
    And  On the Marketplace Search Results page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I enter '2' into first item 'Quantity'
    And  On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
    And I wait '1' seconds before continuing
    Then On the Marketplace Search Results page - I check that 'BasketCount' value is '3'
    And  On the Marketplace Search Results page - I check that 'BasketValue' value is '28,305.00EUR'
    And On the Marketplace Search Results page - I click on the 'Basket' button
    And On the Shopping Basket page - I empty the shopping basket
     # Checking altering quantity of items in the basket from marketplace search results page:
#    When On the Marketplace Search Results page - I enter 'CF53-P911-ENG' into 'SearchKeywords'
#    And  On the Marketplace Search Results page - I click on the 'Search' button
#    And  On the Marketplace Search Results page - I enter '3' into first item 'Quantity'
#    And  On the Marketplace Search Results page - I click on the first item 'UpdateBasketQty' button
#    And  I wait '2' seconds before continuing
#    Then On the Marketplace Search Results page - I check that 'BasketCount' value is '3'
#    And  On the Marketplace Search Results page - I check that 'BasketValue' value is '42,455.00EUR'
#    And  On the Marketplace Search Results page - I enter '2' into first item 'Quantity'
#    And  On the Marketplace Search Results page - I click on the first item 'UpdateBasketQty' button
#    And  I wait '2' seconds before continuing
#    Then On the Marketplace Search Results page - I check that 'BasketCount' value is '3'
#    And  On the Marketplace Search Results page - I check that 'BasketValue' value is '28,305.00EUR'
#    # Checking removal of items from the basket:
#    When On the Marketplace Search Results page - I enter 'CF53-DEV-8692-01_03' into 'SearchKeywords'
#    And  On the Marketplace Search Results page - I click on the 'Search' button
#    And  On the Marketplace Search Results page - I click on the first item 'RemoveFromBasket' button
#    Then On the Marketplace Search Results page - I check that 'BasketCount' value is '2'
#    And  On the Marketplace Search Results page - I check that 'BasketValue' value is '28,300.00EUR'
#    When On the Marketplace Search Results page - I enter 'CF53-P911-MAN' into 'SearchKeywords'
#    And  On the Marketplace Search Results page - I click on the 'Search' button
#    And  On the Marketplace Search Results page - I click on the first item 'RemoveFromBasket' button
#    Then On the Marketplace Search Results page - I check that 'BasketCount' value is '1'
#    And  On the Marketplace Search Results page - I check that 'BasketValue' value is '28,300.00EUR'
#    When On the Marketplace Search Results page - I enter 'CF53-P911-ENG' into 'SearchKeywords'
#    And  On the Marketplace Search Results page - I click on the 'Search' button
#    And  On the Marketplace Search Results page - I click on the first item 'RemoveFromBasket' button
#    Then On the Marketplace Search Results page - I check that 'BasketCount' 'is not' displayed
#    And  On the Marketplace Search Results page - I check that 'BasketValue' 'is not' displayed
    And  I log out


  Scenario: [shopping_basket.feature] Check Shopping Basket page displays correctly when empty
    # Background section at start of Feature gets to Marketplace Landing page
    # Checking elements displayed:
    When On the Marketplace Landing page - I click on the 'Basket' button
    Then On the Shopping Basket page - I check that 'HeaderAlertMessage' 'is' displayed
    And  On the Shopping Basket page - I check that 'HeaderAlertMessage' value is 'You have no items in your shopping basket.'
#    And  On the Shopping Basket page - I check that 'HeaderAlertMessageClose' 'is' displayed
    And  On the Shopping Basket page - I check that 'HomeIcon' 'is' displayed
    And  On the Shopping Basket page - I check that 'HomeText' 'is' displayed
#    And  On the Shopping Basket page - I check that 'BackLink' 'is not' displayed
    And  On the Shopping Basket page - I check that 'PageTitle' 'is' displayed
    And  On the Shopping Basket page - I check that 'PageTitle' value is 'My Basket'
    And  On the Shopping Basket page - I check that 'EmptyBasket' 'is not' displayed
    And  I log out

  Scenario: [shopping_basket.feature] Check Shopping Basket page displays correctly when not empty
    # Background section at start of Feature gets to Marketplace Landing page
    # Checking addition of items to the basket:
    When On the Marketplace Landing page - I enter 'CF53-P911-ENG' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
    And  On the Marketplace Search Results page - I click on the 'Basket' button
    Then On the Shopping Basket page - I check that 'HeaderAlertMessage' 'is not' displayed
    And  On the Shopping Basket page - I check that 'HomeIcon' 'is' displayed
    And  On the Shopping Basket page - I check that 'HomeText' 'is' displayed
    And  On the Shopping Basket page - I check that 'BackLink' 'is' displayed
    And  On the Shopping Basket page - I check that 'BackLink' value is 'Back to Search Results'
    And  On the Shopping Basket page - I check that 'PageTitle' 'is' displayed
    And  On the Shopping Basket page - I check that 'PageTitle' value is 'My Basket'
    And  On the Shopping Basket page - I check that 'EmptyBasketButton' 'is' displayed
    And  On the Shopping Basket page - I check that 'CheckoutButton' 'is' displayed

    And  On the Shopping Basket page - I check that the number of 'SupplierNames' is '1'
    And  On the Shopping Basket page - I check that 'FirstSupplierName' 'is' displayed
    And  On the Shopping Basket page - I check that 'FirstSupplierName' value is 'Catfish-NDT-Supplier'
    And  On the Shopping Basket page - I check that 'FirstSupplierAmount' 'is' displayed
    And  On the Shopping Basket page - I check that 'FirstSupplierAmount' value is '14,150.00'
    And  On the Shopping Basket page - I check that 'FirstSupplierCurrency' 'is' displayed
    And  On the Shopping Basket page - I check that 'FirstSupplierCurrency' value is 'EUR'

    And  On the Shopping Basket page - I check that the number of 'ItemNames' is '1'
    And  On the Shopping Basket page - I check that first item 'Image' 'is' displayed
    And  On the Shopping Basket page - I check that first item 'Name' 'is' displayed
    And  On the Shopping Basket page - I check that first item 'Name' value is 'Porsche 911 Turbo Engine'
    And  On the Shopping Basket page - I check that first item 'ItemIDLabel' 'is' displayed
    And  On the Shopping Basket page - I check that first item 'ItemID' 'is' displayed
    And  On the Shopping Basket page - I check that first item 'ItemID' value is 'CF53-P911-ENG'
#    And  On the Shopping Basket page - I check that first item 'PriceLabel' 'is' displayed
    And On the Shopping Basket page - I empty the shopping basket
#    And  On the Shopping Basket page - I check that first item 'PriceCurrencyUnit' 'is' displayed
#    And  On the Shopping Basket page - I check that first item 'PriceCurrencyUnit' value is '13,500.00 EUR/Each'
#    And  On the Shopping Basket page - I check that first item 'ContractReferenceLabel' 'is' displayed
#    And  On the Shopping Basket page - I check that first item 'ContractReference' 'is' displayed
#    And  On the Shopping Basket page - I check that first item 'ContractReference' value is 'CATFISH_CONTRACT'
#    And  On the Shopping Basket page - I check that first item 'DescriptionLabel' 'is' displayed
#    And  On the Shopping Basket page - I check that first item 'Description' 'is' displayed
#    And  On the Shopping Basket page - I check that first item 'Description' value is '911 Turbo Engine'
#    And  On the Shopping Basket page - I check that first item 'ItemTotalAmount' 'is' displayed
#    And  On the Shopping Basket page - I check that first item 'ItemTotalAmount' value is '13,500.00'
#    And  On the Shopping Basket page - I check that first item 'ItemTotalCurrency' 'is' displayed
#    And  On the Shopping Basket page - I check that first item 'ItemTotalCurrency' value is 'EUR'
#    And  On the Shopping Basket page - I check that first item 'QuantityLabel' 'is' displayed
#    And  On the Shopping Basket page - I check that first item 'Quantity' 'is' displayed
#    And  On the Shopping Basket page - I check that first item 'Quantity' value is '1.00'
#    And  On the Shopping Basket page - I check that first item 'RemoveFromBasketButton' 'is' displayed
#
#    And  On the Shopping Basket page - I check that the number of 'DeliveryGroupLabels' is '1'
#    And  On the Shopping Basket page - I check that 'FirstDeliveryGroupLabel' 'is' displayed
#    And  On the Shopping Basket page - I check that 'FirstDeliveryGroupLabel' value is 'Delivery:'
#    And  On the Shopping Basket page - I check that 'FirstDeliveryGroupType' 'is' displayed
#    And  On the Shopping Basket page - I check that 'FirstDeliveryGroupType' value is 'Large Delivery'
#    And  On the Shopping Basket page - I check that 'FirstDeliveryGroupAmount' 'is' displayed
#    And  On the Shopping Basket page - I check that 'FirstDeliveryGroupAmount' value is '650.00 EUR'
#    And  On the Shopping Basket page - I check that 'SummaryTitle' 'is' displayed
#    And  On the Shopping Basket page - I check that 'SummaryTotalLabel' 'is' displayed
#    And  On the Shopping Basket page - I check that 'SummaryTotalAmount' 'is' displayed
#    And  On the Shopping Basket page - I check that 'SummaryTotalAmount' value is '14,150.00 EUR'
#
#    And  On the Shopping Basket page - I check that first item 'RemoveFromBasketButton' 'is' displayed
#    When On the Shopping Basket page - I click on the first item 'RemoveFromBasket' button
#    And  I log out

  Scenario: [shopping_basket.feature] Check Shopping Basket page updates items in and removes items from the basket correctly
    # Background section at start of Feature gets to Marketplace Landing page
    # Checking addition of items to the basket:
    When On the Marketplace Landing page - I enter 'CF53-DEV-8692-01_03' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
    And  On the Marketplace Search Results page - I click on the 'Basket' button
    Then On the Shopping Basket page - I check that 'SummaryTotalAmount' value is '5.00EUR'
    And On the Shopping Basket page - I check that 'SummaryTotalAmountCurrency' value is 'EUR'
    # Checking altering quantity of items in the basket:
    When On the Shopping Basket page - I enter '2' into first item 'Quantity'
    And  On the Shopping Basket page - I click on the first item 'UpdateBasketQty' button
    And  I wait '2' seconds before continuing
    And  On the Shopping Basket page - I click on the 'Back Link' breadcrumb
    And  On the Marketplace Search Results page - I click on the 'Basket' button
    Then On the Shopping Basket page - I check that 'SummaryTotalAmount' value is '10.00EUR'
    When On the Shopping Basket page - I click on the first item 'RemoveFromBasket' button
    # Checking removal of items from the basket:
    And  On the Shopping Basket page - I check that first item 'SummaryTotalAmount' 'is not' displayed
    And  On the Shopping Basket page - I check that 'HeaderAlertMessage' value is 'You have no items in your shopping basket.'
    And  I log out


  Scenario: [shopping_basket.feature] Check Item Details page can be navigated to from Marketplace Search Results page and from Shopping basket page
    # Background section at start of Feature gets to Marketplace Landing page
    When On the Marketplace Landing page - I enter 'CF53-DEV-8692-01_03' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I click on the first item 'Name' link
    Then On the Item Details page - I check that 'PageTitle' 'is' displayed
    And  On the Item Details page - I check that 'PageTitle' value is 'Item Details'
    And  On the Item Details page - I check that 'BackLink' value is 'Back to Search Results'
    When On the Item Details page - I click on the 'BackLink' breadcrumb
    And  On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
    And  On the Marketplace Search Results page - I click on the 'Basket' button
    And  On the Shopping Basket page - I click on the first item 'Name' link
    Then On the Edit Basket Item Details page - I check that 'PageTitle' value is 'Item Details'
    When On the Edit Basket Item page - I click on the 'Basket' button
    And  On the Shopping Basket page - I empty the shopping basket
    And  I log out

  Scenario: [shopping_basket.feature] Check Item Details page displays correctly
    # Background section at start of Feature gets to Marketplace Landing page
    When On the Marketplace Landing page - I enter 'CF53-DEV-8692-02_01' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I click on the first item 'Name' link
    # Header area elements
    Then On the Item Details page - I check that 'PageTitle' 'is' displayed
    And  On the Item Details page - I check that 'PageTitle' value is 'Item Details'
    And  On the Item Details page - I check that 'QuotesIcon' 'is' displayed
    And  On the Item Details page - I check that 'QuotesText' value is 'Quotes'
#    And  On the Item Details page - I check that 'QuotesCount' 'is' displayed
#    And  On the Item Details page - I check that 'QuotesCount' value is '0'
    And  On the Item Details page - I check that 'ListsIcon' 'is' displayed
    And  On the Item Details page - I check that 'ListsText' value is 'Lists'
    And  On the Item Details page - I check that 'CompareIcon' 'is' displayed
    And  On the Item Details page - I check that 'CompareText' value is 'Compare Items'
#    And  On the Item Details page - I check that 'CompareCount' 'is' displayed
#    And  On the Item Details page - I check that 'CompareCount' value is '0'
    And  On the Item Details page - I check that 'BasketIcon' 'is' displayed
    And  On the Item Details page - I check that 'BasketText' value is 'Shopping basket(Empty)'
    And  On the Item Details page - I check that 'BasketCount' 'is not' displayed
    And  On the Item Details page - I check that 'BasketValue' 'is not' displayed
    And  On the Item Details page - I check that 'BasketAmount' 'is not' displayed
    And  On the Item Details page - I check that 'BasketCurrency' 'is not' displayed
    # Left-hand column elements
    And  On the Item Details page - I check that 'MainImagePreviousButton' 'is not' displayed
    And  On the Item Details page - I check that 'FirstMainImage' 'is' displayed
#    And  On the Item Details page - I check that 'MainImageNextButton' 'is not' displayed
#    And  On the Item Details page - I check that 'CarouselPreviousButton' 'is' displayed
#    And  On the Item Details page - I check that 'FirstCarouselImage' 'is' displayed
#    And  On the Item Details page - I check that the number of 'CarouselImages' is '1'
#    And  On the Item Details page - I check that 'CarouselNextButton' 'is' displayed
    And  On the Item Details page - I check that 'ItemAttributesTitle' 'is' displayed
#    And  On the Item Details page - I check that 'AdditionalInformationNameLabel' 'is' displayed
#    And  On the Item Details page - I check that 'AdditionalInformationValueLabel' 'is' displayed
    And  On the Item Details page - I check that 'ItemManufacturerNameLabel' 'is' displayed
    And  On the Item Details page - I check that 'ItemManufacturerNameLabel' value is 'Manufacturer name'
    And  On the Item Details page - I check that 'FirstItemAttributeValue' 'is' displayed
    And  On the Item Details page - I check that 'FirstItemAttributeValue' value is 'Porsche Maintenance Services'
#    And  On the Item Details page - I check that the number of 'AddInfoNames' is '2'
#    And  On the Item Details page - I check that the number of 'AddInfoValues' is '2'
    And  On the Item Details page - I check that 'SecondItemAttributeName' 'is' displayed
    And  On the Item Details page - I check that 'SecondItemAttributeName' value is 'Manufacturer product ID'
    And  On the Item Details page - I check that 'SecondItemAttributeValue' 'is' displayed
    And  On the Item Details page - I check that 'SecondItemAttributeValue' value is 'Porsche-MPID-39'
    # Main area elements
    And  On the Item Details page - I check that 'ItemName' 'is' displayed
    And  On the Item Details page - I check that 'ItemName' value is 'Replace dust and pollen filter'
    And  On the Item Details page - I check that 'Supplier' 'is' displayed
    And  On the Item Details page - I check that 'Supplier' value is '(from Catfish-NDT-Supplier)'
    And  On the Item Details page - I check that 'ItemIdLabel' 'is' displayed
    And  On the Item Details page - I check that 'ItemId' 'is' displayed
    And  On the Item Details page - I check that 'ItemId' value is 'CF53-DEV-8692-02_01'
    And  On the Item Details page - I check that 'OrderUnitLabel' 'is' displayed
    And  On the Item Details page - I check that 'OrderUnit' 'is' displayed
    And  On the Item Details page - I check that 'OrderUnit' value is 'Each'
    And  On the Item Details page - I check that 'IncrementLabel' 'is' displayed
    And  On the Item Details page - I check that 'Increment' 'is' displayed
    And  On the Item Details page - I check that 'Increment' value is '1 Each'
    And  On the Item Details page - I check that 'PriceBreaksLabel' 'is' displayed
    And  On the Item Details page - I check that the number of 'PriceBreakQuantity' is '1'
    And  On the Item Details page - I check that the number of 'PriceBreakValues' is '1'
    And  On the Item Details page - I check that 'FirstPriceBreakQuantity' 'is' displayed
    And  On the Item Details page - I check that 'FirstPriceBreakQuantity' value is '1 +'
    And  On the Item Details page - I check that 'FirstPriceBreakValue' 'is' displayed
    And  On the Item Details page - I check that 'FirstPriceBreakValue' value is '10.00EUR'
    And  On the Item Details page - I check that 'ContractReferenceLabel' 'is' displayed
    And  On the Item Details page - I check that 'ContractReference' 'is' displayed
    And  On the Item Details page - I check that 'ContractReference' value is 'CATFISH_CONTRACT'
#    And  On the Item Details page - I check that 'DeliveryLabel' 'is' displayed
#    And  On the Item Details page - I check that 'Delivery' 'is' displayed
#    And  On the Item Details page - I check that 'Delivery' value is 'N/A'
#    And  On the Item Details page - I check that 'QuantityLabel' 'is' displayed
    And  On the Item Details page - I check that 'Quantity' 'is' displayed
    And  On the Item Details page - I check that 'Quantity' value is '1'
    And  On the Item Details page - I check that 'AddToBasketButton' 'is' displayed
#    And  On the Item Details page - I check that 'MinIncrLabel' 'is' displayed
#    And  On the Item Details page - I check that 'MinIncr' value is '1/1'
    And  On the Item Details page - I check that 'AddToListButton' 'is' displayed
    And  On the Item Details page - I check that 'AddToComparisonButton' 'is' displayed
    And  On the Item Details page - I check that 'DescriptionLabel' 'is' displayed
    And  On the Item Details page - I check that 'Description' 'is' displayed
    And  On the Item Details page - I check that 'Description' value is 'Replace dust and pollen filter'
    And  I log out
