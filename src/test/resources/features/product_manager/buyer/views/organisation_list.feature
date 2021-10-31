@CLRegression
@AWSRegression
@OrgLists

Feature: Organisation list in Product Manager
  Scenario: [Organisation List] Create Organisation list
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Buyer' 'Views' submenu item
    When On Views directory page - I click on the Views 'Published' filter
    And On the View directory page - I enter 'Catfish Organisation-wide View' into 'SearchKeywords'
    And On the View directory page - I click on 'Search' button
    And On the View directory Page - I click on the first view
    And On Manage View page - I click on 'Manage users' toggle button
    And On Select User page - I add user 'whole organisation' to the view
    And On Manage View page - I click on 'Manage lists' toggle button
    And On List Directory page - I click on Create button to create List
    And On List directory Page - I enter Name 'CatfishTestListName' and description 'CatfishListDescription'
    And On List directory Page - I click on 'Save' button
    And On Create List page - I add items to the list
    Then On Create List page - verify that plus button changes to minus button
    When On Create List page - click Done and add two more items on next page
    Then On Create List page - I verify item count in 'Items on list' filter
    When On Manage List page - I verify and click on Available Toggle Switch
    And I select the 'Last Modified' option from the 'Sort By' dropdown
    Then On List directory page - I verify the List created and the status of Available knob
    When I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    And On Marketplace Landing page - I hover to 'Lists'
    Then I verify and click on the List created in previous steps
#    And I verify the added items in the List
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Buyer' 'Views' submenu item
    And On Views directory page - I click on the Views 'Published' filter
    And On the View directory page - I search for View
    And On the View directory Page - I click on the first view
    And On Manage View page - I click on 'Manage lists' toggle button
    Then On List directory Page - I delete the list created
    And I log out
