@dfdf dfdf
Feature: My Lists and Organisation Lists

  Scenario: Create a My List, add items, rename & delete
    # This scenario covers regression test 33
    Given I log into Commerce Network as 'BUYER_ADMIN'
    And  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    And  On the Marketplace Landing page - I click on the 'Lists' button
    # Make sure that lists with the names we will use do not already exist
    And  On the Shopping Lists page - I remove any My List named 'A new list'
    And  On the Shopping Lists page - I remove any My List named 'A renamed list'
    # Create the new My List list
    And  On the Shopping Lists page - I click on the 'Create' button
    Then I wait for the modal popup to be 'displayed'
    When On the Shopping Lists page - I enter 'A new list' into 'ModalCreateListName'
    And  On the Shopping Lists page - I click on the 'ModalCreateOK' button
    Then I wait for the modal popup to be 'closed'
    And  I wait for the page refresh to complete
    # Add some items to the new list from the search results page and the item details page
    When On the Shopping Lists page - I click on the 'My lists' 'A new list' link
    And  On the Shopping Lists page - I click on the 'Home' breadcrumb
    And  On the Marketplace Landing page - I enter 'CF53-DE0705' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that first item 'Name' value is 'Office swivel chair without armrests in gray'
    When On the Marketplace Search Results page - I click on the first item 'AddToList' button
    And  I wait for the modal popup to be 'displayed'
    Then On the Marketplace Search Results page - I check that 'ModalTitle' value is 'Select List'
    When On the Marketplace Search Results page - I click on the 'Modal lists' 'A new list' link
    And  I wait for the modal popup to be 'closed'
    And  On the Marketplace Search Results page - I enter 'CF53-DE0702' into 'SearchKeywords'
    And  On the Marketplace Search Results page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that first item 'Name' value is 'Office swivel chair with armrests in gray'
    When On the Marketplace Search Results page - I click on the first item 'Name' link
    Then On the Item Details page - I check that 'ItemId' value is 'CF53-DE0702'
    When On the Item Details page - I click on the 'AddToList' button
    And  I wait for the modal popup to be 'displayed'
    Then On the Item Details page - I check that 'ModalTitle' value is 'Select List'
    When On the Item Details page - I click on the 'Modal lists' 'A new list' link
    And  I wait for the modal popup to be 'closed'
    And  On the Item Details page - I click on the 'Lists' button
    Then On the Shopping Lists page - I check that the number of 'ItemNames' is '2'
    # Rename the list
    When On the Shopping Lists page - I click on the 'Rename' button
    And  I wait for the modal popup to be 'displayed'
    Then On the Shopping Lists page - I check that 'ModalRenameListName' value is 'A new list'
    When On the Shopping Lists page - I enter 'A renamed list' into 'ModalRenameListName'
    And  On the Shopping Lists page - I click on the 'ModalRenameOK' button
    Then I wait for the modal popup to be 'closed'
    And  I wait for the page refresh to complete
    # Delete the list
    When On the Shopping Lists page - I click on the 'My lists' 'A renamed list' link
    And  On the Shopping Lists page - I click on the 'Delete' button
    And  I wait for the modal popup to be 'displayed'
    Then On the Shopping Lists page - I check that 'ModalDeleteListName' value is 'A renamed list'
    When On the Shopping Lists page - I click on the 'ModalDeleteOK' button
    Then I wait for the modal popup to be 'closed'
    And  I wait for the page refresh to complete
    And  I log out


  Scenario: Buy from My List
    # This scenario covers regression test 34
    Given I log into Commerce Network as 'BUYER_ADMIN'
    And  I navigate to the internal 'Shopping' page
    # Need to make sure that the basket is empty so that we can check it when items are added
    When I click on the Shopping 'Marketplace' submenu item
    And  On the Marketplace Landing page - I click on the 'Basket' button
    And  On the Shopping Basket page - I empty the shopping basket
    Then On the Shopping Basket page - I check that the number of 'ItemNames' is '0'
    # Can now start testing buying from the list
    When I click on the Shopping 'Marketplace' submenu item
    And  On the Marketplace Landing page - I click on the 'Lists' button
    And  On the Shopping Lists page - I click on the 'My lists' 'Catfish My List - Preserve This' link
    Then On the Shopping Lists page - I check that 'ResultsShownTop' value is '1-4 / 4'
    # Buy an item directly from list
    When On the Shopping Lists page - I click on the 'Add To Basket' button associated with 'Item Name' 'Porsche 911 Turbo Engine'
    Then On the Shopping Lists page - I check that 'BasketCount' value is 'Items: 1'
    And  On the Shopping Lists page - I check that 'BasketValue' value is 'Total: 14,150.00 EUR'
    # Buy an item on the list via the item details page
    When On the Shopping Lists page - I click on the 'Item Name' 'Visitor chair with armrest in blue' link
    And  On the Item Details page - I click on the 'AddToBasket' button
    Then On the Item Details page - I check that 'BasketCount' value is 'Items: 2'
    And  On the Item Details page - I check that 'BasketValue' value is 'Total: 14,319.00 EUR'
    # Buy another item directly from list
    When  On the Item Details page - I click on the 'BackLink' breadcrumb
    And  On the Shopping Lists page - I click on the first item 'AddToBasket' button
    Then On the Shopping Lists page - I check that 'BasketCount' value is 'Items: 3'
    And  On the Shopping Lists page - I check that 'BasketValue' value is 'Total: 14,319.00 EUR'
    # Use the list to remove the item from basket
    When On the Shopping Lists page - I click on the first item 'RemoveFromBasket' button
    Then On the Shopping Lists page - I check that 'BasketCount' value is 'Items: 2'
    And  On the Shopping Lists page - I check that 'BasketValue' value is 'Total: 14,319.00 EUR'
    # Empty the basket
    And  On the Shopping Lists page - I click on the 'Basket' button
    Then On the Shopping Basket page - I empty the shopping basket
    # Now buy all items in the list
    When I click on the Shopping 'Marketplace' submenu item
    And  On the Marketplace Landing page - I click on the 'Lists' button
    And  On the Shopping Lists page - I click on the 'BuyAll' button
    Then On the Shopping Basket page - I check that the number of 'SupplierNames' is '1'
    And  On the Shopping Basket page - I check that the number of 'ItemNames' is '4'
    And  On the Shopping Basket page - I check that 'SummaryTotalAmount' value is '14,488.00 EUR'
    # Tidy up and log out
    Then On the Shopping Basket page - I empty the shopping basket
    Then On the Shopping Basket page - I check that the number of 'ItemNames' is '0'
    And  I log out


  Scenario: Buy from Organisation List
    # This scenario covers regression test 35
    Given I log into Commerce Network as 'BUYER_ADMIN'
    And  I navigate to the internal 'Shopping' page
    # Need to make sure that the basket is empty so that we can check it when items are added
    When I click on the Shopping 'Marketplace' submenu item
    And  On the Marketplace Landing page - I click on the 'Basket' button
    And  On the Shopping Basket page - I empty the shopping basket
    Then On the Shopping Basket page - I check that the number of 'ItemNames' is '0'
    # Can now start testing buying from the list
    When I click on the Shopping 'Marketplace' submenu item
    And  On the Marketplace Landing page - I click on the 'Lists' button
    And  On the Shopping Lists page - I click on the 'Organisation lists' 'Catfish Organisation List - Preserve This' link
    Then On the Shopping Lists page - I check that 'ResultsShownTop' value is '1-25 / 44'
    # Buy an item directly from list
    When On the Shopping Lists page - I click on the 'Add To Basket' button associated with 'Item Name' '2nd Year Service Plan'
    Then On the Shopping Lists page - I check that 'BasketCount' value is 'Items: 1'
    And  On the Shopping Lists page - I check that 'BasketValue' value is 'Total: 960.00 EUR'
    # Now buy all other items in the list
    When On the Shopping Lists page - I click on the 'BuyAll' button
    Then On the Shopping Basket page - I check that the number of 'SupplierNames' is '1'
    And  On the Shopping Basket page - I check that the number of 'ItemNames' is '44'
    And  On the Shopping Basket page - I check that 'SummaryTotalAmount' value is '99,801.59 EUR'
    And  On the Shopping Basket page - I check that 'SummaryFirstSupplierItemTotalAmount' value is '98,012.84'
    And  On the Shopping Basket page - I check that 'SummaryFirstSupplierDeliveryTotalAmount' value is '1,788.75'
    # Tidy up and log out
    Then On the Shopping Basket page - I empty the shopping basket
    Then On the Shopping Basket page - I check that the number of 'ItemNames' is '0'
    And  I log out
