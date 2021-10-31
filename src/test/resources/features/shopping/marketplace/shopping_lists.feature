@ShoppingLists
Feature: Non-destructive testing of shopping Lists in the Marketplace

  Background: This is performed before each Scenario
    Given I log into Commerce Network as 'BUYER_ADMIN_NONDESTRUCTIVE'
    And  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
#    And On the Marketplace Landing page - I click on the 'newUI' toggle


  Scenario: [shopping_lists.feature] Emptying the My Lists (Favourites) Lists
    # Background section at start of Feature gets to Marketplace Landing page
    # Checking display of elements:
    When On the Marketplace Landing page - I click on the 'Lists' button
    When On the Shopping Lists page - I empty the My Lists lists
    When On the Shopping Lists page - I click on the 'Basket' button
    When On the Shopping Basket page - I empty the shopping basket
    And  I log out

  Scenario: [shopping_lists.feature] Check Shopping Lists page displays correctly when only empty Favourites is in My Lists
    # Background section at start of Feature gets to Marketplace Landing page
    # Checking display of elements:
    When On the Marketplace Landing page - I click on the 'Lists' button
    # Header area
    Then On the Shopping Lists page - I check that 'PageTitle' 'is' displayed
    And  On the Shopping Lists page - I check that 'PageTitle' value is 'Lists'
    And  On the Shopping Lists page - I check that 'HomeIcon' 'is' displayed
    And  On the Shopping Lists page - I check that 'HomeText' 'is' displayed
    And  On the Shopping Lists page - I check that 'PageTitle' 'is' displayed
    And  On the Shopping Lists page - I check that 'QuotesIcon' 'is' displayed
#    And  On the Shopping Lists page - I check that 'QuotesCount' 'is' displayed
#    And  On the Shopping Lists page - I check that 'QuotesCount' value is '0'
    And  On the Shopping Lists page - I check that 'ListsIcon' 'is' displayed
    And  On the Shopping Lists page - I check that 'ListsText' value is 'Lists'
    And  On the Shopping Lists page - I check that 'CompareIcon' 'is' displayed
#    And  On the Shopping Lists page - I check that 'CompareText' value is 'Compare Items'
 #    And  On the Shopping Lists page - I check that 'CompareCount' 'is' displayed
#    And  On the Shopping Lists page - I check that 'CompareCount' value is '0'
    And  On the Shopping Lists page - I check that 'BasketIcon' 'is' displayed
    And  On the Shopping Lists page - I check that 'BasketText' value is 'Shopping basket(Empty)'
    And  On the Shopping Lists page - I check that 'BasketCount' 'is not' displayed
    And  On the Shopping Lists page - I check that 'BasketValue' 'is not' displayed
    And  On the Shopping Lists page - I check that 'BasketAmount' 'is not' displayed
    And  On the Shopping Lists page - I check that 'BasketCurrency' 'is not' displayed
    # Bar area
    And  On the Shopping Lists page - I check that 'ListName' 'is' displayed
    And  On the Shopping Lists page - I check that 'ListName' value is 'Favourites'
    And  On the Shopping Lists page - I check that 'RenameListButton' 'is' displayed
    And  On the Shopping Lists page - I check that 'DeleteListButton' 'is' displayed
    And  On the Shopping Lists page - I check that 'BuyAllButton' 'is not' displayed
#    And  On the Shopping Lists page - I check that 'OrderByLabel' 'is' displayed
#    And  On the Shopping Lists page - I check that 'OrderByDropdown' 'is' displayed
    # Items displayed summary and Pagination area
    And  On the Shopping Lists page - I check that 'ShoppingListEmpty' 'is' displayed
    And  On the Shopping Lists page - I check that 'ShoppingListEmpty' value is 'No items to show!'
    And  On the Shopping Lists page - I check that 'PreviousPageTopButton' 'is not' displayed
    And  On the Shopping Lists page - I check that 'NextPageTopButton' 'is not' displayed
    # Items area
    And  On the Shopping Lists page - I check that the number of 'ItemNames' is '0'
    # List Selection area
    And  On the Shopping Lists page - I check that 'MyListsLabel' 'is' displayed
    And  On the Shopping Lists page - I check that 'CreateButton' 'is' displayed
    And  On the Shopping Lists page - I check that the number of 'MyLists' is '1'
    And  On the Shopping Lists page - I check that 'First My List' 'is' displayed
    And  On the Shopping Lists page - I check that 'First My List' value is 'Favourites'
    And  On the Shopping Lists page - I check that 'OrganisationListsLabel' 'is' displayed
    And  On the Shopping Lists page - I check that the number of 'OrganisationLists' is '1'
    And  On the Shopping Lists page - I check that 'First Organisation List' 'is' displayed
    And  On the Shopping Lists page - I check that 'First Organisation List' value is 'Catfish Organisation List - Preserve This'
    And  I log out

  Scenario: [shopping_lists.feature] Check Shopping Lists page create, rename and delete of a list works
    # Background section at start of Feature gets to Marketplace Landing page
    When On the Marketplace Landing page - I click on the 'Lists' button
    # Check display of modal popup for Create
    And  On the Shopping Lists page - I click on the 'Create' button
    Then I wait for the modal popup to be 'displayed'
    And  On the Shopping Lists page - I check that 'ModalCreateTitle' 'is' displayed
    And  On the Shopping Lists page - I check that 'ModalCreateNameLabel' 'is' displayed
    And  On the Shopping Lists page - I check that 'ModalCreateListName' 'is' displayed
    And  On the Shopping Lists page - I check that 'ModalCreateListName' value is ''
    And  On the Shopping Lists page - I check that 'ModalCreateCancelButton' 'is' displayed
    And  On the Shopping Lists page - I check that 'ModalCreateSaveButton' 'is' displayed
    When On the Shopping Lists page - I enter 'JUNK' into 'ModalCreateListName'
    And  On the Shopping Lists page - I click on the 'ModalCreateCancel' button
    Then I wait for the modal popup to be 'closed'
    And  On the Shopping Lists page - I check that 'ListName' value is 'Favourites'
    # Create a new list
    When On the Shopping Lists page - I click on the 'Create' button
    Then I wait for the modal popup to be 'displayed'
    When On the Shopping Lists page - I enter 'A new list' into 'ModalCreateListName'
    And  On the Shopping Lists page - I click on the 'ModalCreateSaveButton' button
    Then I wait for the modal popup to be 'closed'
    And  I wait for the page refresh to complete
    And  On the Shopping Lists page - I check that 'First My List' value is 'A new list'
    And  On the Shopping Lists page - I check that 'ListName' value is 'A new list'
    # Check display of modal popup for Rename
    When On the Shopping Lists page - I click on the 'Rename' button
    Then I wait for the modal popup to be 'displayed'
    And  On the Shopping Lists page - I check that 'ModalRenameTitle' 'is' displayed
    And  On the Shopping Lists page - I check that 'ModalRenameNameLabel' 'is' displayed
    And  On the Shopping Lists page - I check that 'ModalRenameListName' 'is' displayed
    And  On the Shopping Lists page - I check that 'ModalRenameListName' value is 'A new list'
    And  On the Shopping Lists page - I check that 'ModalRenameClose' 'is' displayed
#    And  On the Shopping Lists page - I check that 'ModalRenameOKButton' 'is' displayed
    When On the Shopping Lists page - I enter 'JUNK' into 'ModalRenameListName'
    And  On the Shopping Lists page - I click on the 'ModalRenameClose' button
    Then I wait for the modal popup to be 'closed'
    And  On the Shopping Lists page - I check that 'ListName' value is 'A new list'
    # Rename the list
    When On the Shopping Lists page - I click on the 'Rename' button
    Then I wait for the modal popup to be 'displayed'
    When On the Shopping Lists page - I enter 'A renamed list' into 'ModalRenameListName'
    And  On the Shopping Lists page - I click on the 'ModalRenameSave' button
    Then I wait for the modal popup to be 'closed'
    And  I wait for the page refresh to complete
    And  On the Shopping Lists page - I check that 'First My List' value is 'A renamed list'
    And  On the Shopping Lists page - I check that 'ListName' value is 'A renamed list'
    # Check display of modal popup for Delete
    When On the Shopping Lists page - I click on the 'Delete' button
    Then I wait for the modal popup to be 'displayed'
    And  On the Shopping Lists page - I check that 'ModalDeleteTitle' 'is' displayed
    And  On the Shopping Lists page - I check that 'ModalDeleteMessage' 'is' displayed
#    And  On the Shopping Lists page - I check that 'ModalDeleteListName' 'is' displayed
#    And  On the Shopping Lists page - I check that 'ModalDeleteListName' value is 'A renamed list'
    And  On the Shopping Lists page - I check that 'ModalDeleteCancelButton' 'is' displayed
    And  On the Shopping Lists page - I check that 'ModalDeleteOKButton' 'is' displayed
    And  On the Shopping Lists page - I click on the 'ModalDeleteCancel' button
    Then I wait for the modal popup to be 'closed'
    And  On the Shopping Lists page - I check that 'ListName' value is 'A renamed list'
    # Delete the list
    When On the Shopping Lists page - I click on the 'Delete' button
    Then I wait for the modal popup to be 'displayed'
    And  On the Shopping Lists page - I click on the 'ModalDeleteOK' button
    Then I wait for the modal popup to be 'closed'
    And  I wait for the page refresh to complete
    And  On the Shopping Lists page - I check that 'First My List' value is 'Favourites'
    And  On the Shopping Lists page - I check that 'ListName' value is 'Favourites'
    And  I log out


  Scenario: [shopping_lists.feature] Check items can be added to a My Lists list and deleted from it
#     Background section at start of Feature gets to Marketplace Landing page
#     Find and add items into Favourites list (defaulting to Favourites when only Favourites exists)
    When On the Marketplace Landing page - I enter 'CATFISH-ITEM1 Name' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that first item 'Name' value is 'CATFISH-ITEM1 Name'
    When On the Marketplace Search Results page - I click on the first item 'AddToList' button
    And  On the Marketplace Search Results page - I click on the 'Lists' button
    Then On the Shopping Lists page - I check that 'FirstItemName' value is 'CATFISH-ITEM1 Name'
#    And  On the Shopping Lists page - I check that 'ResultsShownTop' value is '1-1 / 1'
    When On the Shopping Lists page - I click on the 'Home' breadcrumb
    When On the Marketplace Landing page - I enter 'Check and adjust parking brake' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I click on the first item 'Name' link
    Then On the Item Details page - I check that 'ItemName' value is 'Check and adjust parking brake'
    When On the Item Details page - I click on the 'AddToList' button
    And  On the Item Details page - I click on the 'Lists' button
#    Then On the Shopping Lists page - I check that 'FirstItemName' value is 'Check and adjust parking brake'
#    And  On the Shopping Lists page - I check that 'ResultsShownTop' value is '1-2 / 2'
    # create a new list
    When On the Shopping Lists page - I click on the 'Create' button
    And  I wait for the modal popup to be 'displayed'
    And  On the Shopping Lists page - I enter 'A new list' into 'ModalCreateListName'
    And  On the Shopping Lists page - I click on the 'ModalCreateSaveButton' button
    And  I wait for the modal popup to be 'closed'
    And  I wait for the page refresh to complete
    And  On the Shopping Lists page - I click on the 'Home' breadcrumb
    # add items into the new list (selecting from modal popups when more than one list)
    When On the Marketplace Landing page - I enter 'High swivel chair with armrest in blue' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that first item 'Name' value is 'High swivel chair with armrest in blue'
    When On the Marketplace Search Results page - I click on the first item 'AddToList' button
    And  I wait for the modal popup to be 'displayed'
#    Then On the Marketplace Search Results page - I check that 'ModalTitle' value is 'Select List'???
    When On the Marketplace Search Results page - I click on the 'ModalFirstList' link
    And  I wait for the modal popup to be 'closed'
    And  On the Marketplace Search Results page - I click on the 'Lists' button
    Then On the Shopping Lists page - I check that 'FirstItemName' value is 'High swivel chair with armrest in blue'
#    And  On the Shopping Lists page - I check that 'ResultsShownTop' value is '1-1 / 1'
    When On the Shopping Lists page - I click on the 'Home' breadcrumb
    And  On the Marketplace Landing page - I enter 'Check and adjust parking brake' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    And  On the Marketplace Search Results page - I click on the first item 'Name' link
    Then On the Item Details page - I check that 'ItemName' value is 'Check and adjust parking brake'
    When On the Item Details page - I click on the 'AddToList' button
    And  I wait for the modal popup to be 'displayed'
#    Then On the Item Details page - I check that 'ModalTitle' value is 'Select List'
    When On the Item Details page - I click on the 'ModalFirstList' link
    And  I wait for the modal popup to be 'closed'
    And  On the Item Details page - I click on the 'Lists' button
    Then On the Shopping Lists page - I check that 'FirstItemName' value is 'Check and adjust parking brake'
#    And  On the Shopping Lists page - I check that 'ResultsShownTop' value is '1-2 / 2'
#     delete an item from the list
    When On the Shopping Lists page - I click on the first item 'RemoveFromList' button
    And  I wait for the page refresh to complete
#    And  On the Shopping Lists page - I check that 'ResultsShownTop' value is '1-1 / 1'
    Then On the Shopping Lists page - I check that 'FirstItemName' value is 'High swivel chair with armrest in blue'
    # re-initialise My Lists
    When On the Shopping Lists page - I empty the My Lists lists
    And  I log out


  Scenario: [shopping_lists.feature] Use the lists to do some shopping
#     Background section at start of Feature gets to Marketplace Landing page
#     Ensure that the shopping basket is empty
    And  On the Marketplace Landing page - I click on the 'Basket' button
    And  On the Shopping Basket page - I empty the shopping basket
    And  I click on the Shopping 'Marketplace' submenu item
    # Find and add items into Favourites list
    When On the Marketplace Landing page - I enter '1st Year Service Plan' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that first item 'Name' value is '1st Year Service Plan'
    When On the Marketplace Search Results page - I click on the first item 'AddToList' button
    And  On the Marketplace Search Results page - I click on the 'Lists' button
    Then On the Shopping Lists page - I check that 'FirstItemName' value is '1st Year Service Plan'
#    And  On the Shopping Lists page - I check that 'ResultsShownTop' value is '1-1 / 1'
    # Add 2 of first item in Favourites list to the basket
    When On the Shopping Lists page - I enter '2' into 'FirstItemQuantity'
    And  On the Shopping Lists page - I check that 'FirstItemUpdateQtyButton' 'is' displayed
    When  On the Shopping Lists page - I click on the first item 'UpdateQty' button
    And  I wait for the page refresh to complete
    And  On the Shopping Lists page - I check that 'FirstItemAddToBasketButton' 'is' displayed
    And  On the Shopping Lists page - I click on the first item 'AddToBasket' button
    And  I wait for the page refresh to complete
#    Then On the Shopping Lists page - I check that 'FirstItemRemoveFromBasketButton' 'is' displayed
#    And  On the Shopping Lists page - I check that 'BasketCount' value is '1'
#    And  On the Shopping Lists page - I check that 'BasketValue' value is '20'
    When On the Shopping Lists page - I click on the first item 'RemoveFromList' button
    And  I wait for the page refresh to complete
    # Add first item in first Organisation list to the basket
    And  On the Shopping Lists page - I click on the 'First Organisation List' list selection
    And  I wait for the page refresh to complete
    Then On the Shopping Lists page - I check that 'FirstItemName' value is 'High swivel chair with armrest in blue'
    And  On the Shopping Lists page - I click on the first item 'AddToBasket' button
#    Then On the Shopping Lists page - I check that 'FirstItemRemoveFromBasketButton' 'is' displayed
#    And  On the Shopping Lists page - I check that 'BasketCount' value is 'Items: 2'
    And  On the Shopping Lists page - I check that 'BasketValue' value is 'Total: 1,748.00 EUR'
    And  On the Shopping Lists page - I click on the 'BuyAll' button
    And  On the Shopping Basket page - I check that 'SummaryTotalAmount' value is '1,973.00 EUR'
    # tidy-up by emptying basket
    And  On the Shopping Basket page - I empty the shopping basket
    And  I log out
