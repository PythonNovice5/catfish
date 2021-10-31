@CheckOutAndDocTracker
Feature: Verify Shopping Basket Check out and documents in Document Tracker
  Scenario: [shopping_checkout.feature] Emptying the shopping basket
    # Background section at start of Feature gets to Marketplace Landing page
    Given I log into Commerce Network as 'BUYER_ADMIN_NONDESTRUCTIVE'
    And  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    When On the Marketplace Landing page - I click on the 'Basket' button
    When On the Shopping Basket page - I empty the shopping basket
    And  I log out

#  Scenario: [shopping_checkout.feature] Check Catalogue Shopping Requisition page displays correctly
#    # Background section at start of Feature gets to Marketplace Landing page
#    Then On the Marketplace Landing page - I check that 'CarouselPreviousButton' 'is not' displayed
#    And  On the Marketplace Landing page - I check that 'CarouselNextButton' 'is not' displayed
#    And  On the Marketplace Landing page - I check that 'FirstCarouselItem' 'is not' displayed
#    # Addition of items to the basket:
#    When On the Marketplace Landing page - I e@StandardContractnter 'Porsche 911 Service Manual PDF' into 'SearchKeywords'
#    And  On the Marketplace Landing page - I click on the 'Search' button
#    Then On the Marketplace Search Results page - I check that first item 'PriceCurrencyUnit' value is 'Free'
#    When On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
#    Then On the Marketplace Search Results page - I check that 'BasketCount' value is 'Items: 1'
#    And  On the Marketplace Search Results page - I check that 'BasketValue' value is 'Total: 0.00 EUR'
#    When On the Marketplace Search Results page - I enter 'CF53-DE0707' into 'SearchKeywords'
#    And  On the Marketplace Search Results page - I click on the 'Search' button
#    Then On the Marketplace Search Results page - I check that first item 'Name' value is 'High swivel chair with armrest in blue'
#    And  On the Marketplace Search Results page - I enter '3' into first item 'Quantity'
#    And  On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
#    Then On the Marketplace Search Results page - I check that 'BasketCount' value is 'Items: 2'
#    And  On the Marketplace Search Results page - I check that 'BasketValue' value is 'Total: 1,287.00 EUR'
#    When On the Marketplace Search Results page - I click on the 'Basket' button
#    Then On the Shopping Basket page - I check that 'SummaryTotalAmount' value is '1,287.00 EUR'
#    # Checkout
#    When On the Shopping Basket page - I click on the 'Checkout' button
#    # Checking all elements on page are displayed correctly
#    Then On the Requisition page - I check that 'PageTitle' 'is' displayed
#    Then On the Requisition page - I check that 'PageTitle' value is 'Catalogue Shopping'
#    And  On the Requisition page - I check that 'RequisitionNumber' 'is' displayed
#    And  On the Requisition page - I check that 'RequisitionStatus' value is '(Draft)'
#    And  On the Requisition page - I check that 'DetailsLabel' 'is' displayed
#    And  On the Requisition page - I check that 'YourReferenceLabel' 'is' displayed
#    And  On the Requisition page - I check that 'YourReference' value is ''
#    And  On the Requisition page - I check that 'TargetDeliveryDateLabel' 'is' displayed
#    And  On the Requisition page - I check that 'TargetDeliveryDate' value is 'dd-MM-yyyy'
#    And  On the Requisition page - I check that 'SpecialInstructionsLabel' 'is' displayed
#    And  On the Requisition page - I check that 'SpecialInstructions' value is ''
#    And  On the Requisition page - I check that 'DeliverToLabel' 'is' displayed
#    And  On the Requisition page - I check that 'DeliverTo' value is 'Catfish NDT Buyer'
#    And  On the Requisition page - I check that 'AddressLabel' 'is' displayed
#    And  On the Requisition page - I check that 'Address' value is 'Catfish Non Destructive Testing'
#    And  On the Requisition page - I check that 'CityTownLabel' 'is' displayed
#    And  On the Requisition page - I check that 'CityTown' value is 'Bristol'
#    And  On the Requisition page - I check that 'CountyLabel' 'is' displayed
#    And  On the Requisition page - I check that 'County' value is ''
#    And  On the Requisition page - I check that 'CountryDropdown' 'is' displayed
#    And  On the Requisition page - I check that 'CountryDropdown' value is 'United Kingdom'
#    And  On the Requisition page - I check that 'PostcodeLabel' 'is' displayed
#    And  On the Requisition page - I check that 'Postcode' value is 'BS1'
#    And  On the Requisition page - I check that 'PhoneNumberLabel' 'is' displayed
#    And  On the Requisition page - I check that 'PhoneNumber' value is ''
#    And  On the Requisition page - I check that 'LinesLabel' 'is' displayed
#    And  On the Requisition page - I check that 'SupplierHeaderLabel' 'is' displayed
#    And  On the Requisition page - I check that 'ItemNameHeaderLabel' 'is' displayed
#    And  On the Requisition page - I check that 'ItemDescriptionHeaderLabel' 'is' displayed
#    And  On the Requisition page - I check that 'QuantityHeaderLabel' 'is' displayed
#    And  On the Requisition page - I check that 'TargetUnitPriceHeaderLabel' 'is' displayed
#    And  On the Requisition page - I check that first line 'Supplier' value is 'Catfish-NDT-Supplier'
#    And  On the Requisition page - I check that first line 'Name' value is 'CF53-P911-MAN (CATFISH_CONTRACT)'
#    And  On the Requisition page - I check that first line 'Description' value is 'Porsche 911 Service Manual PDF'
#    And  On the Requisition page - I check that first line 'Quantity' value is '1.0   Each'
#    And  On the Requisition page - I check that first line 'TargetUnitPrice' value is '€0.00'
#    And  On the Requisition page - I check that second line 'Supplier' value is 'Catfish-NDT-Supplier'
#    And  On the Requisition page - I check that second line 'Name' value is 'CF53-DE0707 (CATFISH_CONTRACT)'
#    And  On the Requisition page - I check that second line 'Description' value is 'High swivel chair with armrest in blue'
#    And  On the Requisition page - I check that second line 'Quantity' value is '3   Each'
#    And  On the Requisition page - I check that second line 'TargetUnitPrice' value is '€409.00'
#    And  On the Requisition page - I check that 'SubmitButton' 'is' displayed
#    And  On the Requisition page - I check that 'CancelButton' 'is' displayed
#    # Abandon that basket
#    And  On the Requisition page - I click on the 'Cancel' button
#    And  I log out

  @CLRegression
  @CheckCatalogue
  Scenario: [shopping_checkout.feature] Check Catalogue Shopping Invoice Details page displays correctly
    Given I log into Commerce Network as 'BUYER_ADMIN_NONDESTRUCTIVE'
    And  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    When  On the Marketplace Landing page - I click on the 'Basket' button
    And  On the Shopping Basket page - I empty the shopping basket
    And  I click on the Shopping 'Marketplace' submenu item
#    And  On the Marketplace Landing page - I click on the 'Search' button
    When On the Marketplace Landing page - I enter 'CF53-P911-DSK' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I enter '3' into first item 'Quantity'
    And  On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
    Then On the Marketplace Search Results page - I check that 'BasketCount' value is '1'
    And  On the Marketplace Search Results page - I check that 'BasketValue' value is '2,730.00EUR'
    When On the Marketplace Search Results page - I click on the 'Basket' button
    Then On the Shopping Basket page - I check that 'SummaryTotalAmount' value is '2,730.00EUR'
    # Checkout
    When On the Shopping Basket page - I click on the 'Checkout' button
    # Checking all input elements on page work
    And  On the Requisition page - I enter 'CatfishRef-' plus DateTimeNow into 'YourReference'
    And  On the Requisition page - I enter '01-01-2020' into 'TargetDeliveryDate'
    And  On the Requisition page - I enter 'Special Instructions' into 'SpecialInstructions'
    And  On the Requisition page - I enter 'Miss May Wander' into 'DeliverTo'
    And  On the Requisition page - I enter 'Upper Garden Path' into 'Address'
    And  On the Requisition page - I enter 'Toosum' into 'CityTown'
    And  On the Requisition page - I enter 'Bigplace' into 'County'
    And  On the Requisition page - I select the 'Norway' option from the 'CountryDropdown' dropdown
    And  On the Requisition page - I enter 'TO1 1ET' into 'Postcode'
    And  On the Requisition page - I enter '01234 567890' into 'PhoneNumber'
    # Submit
    And  On the Requisition page - I click on the 'Submit' button
    Then On the Invoice Details page - I check that 'PageTitle' 'is' displayed
    And  On the Invoice Details page - I check that 'PageTitle' value is 'Invoice details'
    And  On the Invoice Details page - I check that 'InvoiceToLabel' 'is' displayed
    And  On the Invoice Details page - I check that 'InvoiceTo' value is 'Catfish NDT Buyer'
    And  On the Invoice Details page - I check that 'AddressLabel' 'is' displayed
    And  On the Invoice Details page - I check that 'Address' value is 'Catfish Non Destructive Testing'
    And  On the Invoice Details page - I check that 'CityTownLabel' 'is' displayed
    And  On the Invoice Details page - I check that 'CityTown' value is 'Bristol'
    And  On the Invoice Details page - I check that 'CountyLabel' 'is' displayed
    And  On the Invoice Details page - I check that 'County' value is ''
    And  On the Invoice Details page - I check that 'CountryLabel' 'is' displayed
    And  On the Invoice Details page - I check that 'CountryDropdown' value is 'United Kingdom'
    And  On the Invoice Details page - I check that 'PostcodeLabel' 'is' displayed
    And  On the Invoice Details page - I check that 'Postcode' value is 'BS1'
    And  On the Invoice Details page - I check that 'PhoneNumberLabel' 'is' displayed
    And  On the Invoice Details page - I check that 'PhoneNumber' value is ''
    And  On the Invoice Details page - I check that 'SupplierNameHeaderLabel' 'is' displayed
    And  On the Invoice Details page - I check that 'SupplierPaymentMethodHeaderLabel' 'is' displayed
    And  On the Invoice Details page - I check that first supplier 'Checkbox' 'is not' ticked
#    And  On the Invoice Details page - I check that first supplier 'Supplier' value is 'VENUS'
    And  On the Invoice Details page - I check that first supplier 'PaymentMethod' value is 'Invoice'
    And  On the Invoice Details page - I check that 'ChangePaymentMethodLabel' 'is' displayed
    And  On the Invoice Details page - I check that 'PaymentMethodDropdown' value is 'Invoice'
    And  On the Invoice Details page - I check that 'ChangePaymentMethodButton' 'is' displayed
    And  On the Invoice Details page - I check that 'SendButton' 'is' displayed
    And  On the Invoice Details page - I check that 'CancelButton' 'is' displayed
    # Change the details and Cancel
    When On the Invoice Details page - I enter 'Miss May Wander' into 'InvoiceTo'
    And  On the Invoice Details page - I enter 'Upper Garden Path' into 'Address'
    And  On the Invoice Details page - I enter 'Toosum' into 'CityTown'
    And  On the Invoice Details page - I enter 'Bigplace' into 'County'
    And  On the Invoice Details page - I select the 'Norway' option from the 'CountryDropdown' dropdown
    And  On the Invoice Details page - I enter 'TO1 1ET' into 'Postcode'
    And  On the Invoice Details page - I enter '01234 567890' into 'PhoneNumber'
    And On the Invoice Details page - I click on the first supplier Checkbox
    And  On the Invoice Details page - I click on the 'Send' button
#    And I navigate to the internal 'Documents' page
#    And I click on the 'Document Tracker' tab
#    And On the Document Tracker Page - I click to sort by 'Date'
#    And On the Document Tracker Page - I click the first Document reference
#    Then On the Document Tracker Page - I check that 'ItemName' value is 'CF53-P911-DSK'
#    And On the Document Tracker Page - I check that 'Purchase Order number' is displayed
#    And On the Document Tracker Page - I check that 'Download as PDF' is displayed
    And I log out

#  @CLRegression
#  @DocumentTracker
##  Feature: Verify documents in Document Tracker tool
#  Scenario: [document_tracker.feature] Verifying documents in Document Tracker
#    Given I log into Commerce Network as 'BUYER_ADMIN_NONDESTRUCTIVE'
#    Then I navigate to the internal 'Documents' page
#    Then I validate that I can see the correct Documents tabs
#    When I click on the 'Document Tracker' tab
#    Then On the Document Tracker Page - I check that 'Document Ref' value is 'Blank'
#    And On the Document Tracker Page - I check that 'Supplier Name' value is 'Blank'
#    And On the Document Tracker Page - I check that 'DateFrom' value is 'TodayLastYear'
#    And On the Document Tracker Page - I check that 'DateTo' value is 'CurrentDate'
#    And On the Document Tracker Page - I check that 'Event' value is 'Received by Basware'
#    And On the Document Tracker Page - I check that 'Type' value is 'Any Document Sent'
#    When On the Document Tracker Page - I select 'Type' value as 'Purchase Order'
#    And On the Document Tracker Page - I click on 'Search' button
#    And On the Document Tracker Page - I check that 'Purchase Order List' is displayed
#    And On the Document Tracker Page - I click the first Document reference
#    And On the Document Tracker Page - I click on 'Download as PDF' button
#    #Select Document type as 'Invoice' in 'Type'
#    When I click on the 'Document Tracker' tab
#    When On the Document Tracker Page - I select 'Type' value as 'Invoice'
#    And On the Document Tracker Page - I click on 'Search' button
#    And On the Document Tracker Page - I check that 'Invoice List' is displayed
#    And On the Document Tracker Page - I click the first Document reference
#    Then On the Document Tracker Page - I check that 'Purchase Order XXXXXXXXXXXX' is displayed
#    And On the Document Tracker Page - I check that 'Invoice XXXXXXXXXX' is displayed
#    When On the Document Tracker Page - I click on 'Purchase Order XXXXXXXXXXXX' link under 'Document History'
#    And On the Document Tracker Page - I click on 'BackToPreviousPage' button
#    And On the Document Tracker Page - I click on 'Download as PDF' button
#    When I click on the 'Document Tracker' tab
#    And On the Document Tracker Page - I enter '0000000006' into 'DocumentRef'
#    When On the Document Tracker Page - I select 'Type' value as 'Invoice'
#    And On the Document Tracker Page - I click on 'Search' button
#    Then On the Document Tracker Page - I check that 'Invoice List' is displayed
#    When I click on the 'Document Tracker' tab
#    And On the Document Tracker Page - I select 'Type' value as 'Any Document Received'
#    And On the Document Tracker Page - I click on 'Search' button
#    And On the Document Tracker Page - I check that 'Any Document Received' is displayed
#    When I click on the 'Document Tracker' tab
#    When On the Document Tracker Page - I select 'Type' value as 'Any Document Sent'
#    And On the Document Tracker Page - I enter '' into 'DocumentRef'
#    And On the Document Tracker Page - I click on 'Search' button
#    And On the Document Tracker Page - I check that 'Purchase Order List' is displayed
#    And I log out