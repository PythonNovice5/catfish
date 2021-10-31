@CLRegression
@AWSRegression
@Views
@CheckoutForm
Feature: Create view in Product Manager with checkout form

  Scenario: [View Create] Verify if user is able to create and publish the view
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Buyer' 'Views' submenu item
    And I click on Create button
    And On Create View page - I select type as 'Agreement'
    And On Create View page - I enter Name 'CatfishViewTest' and description 'CatfishViewDescription'
    And On Create View page - I click on 'Save' button
    And On Manage View page - I click on 'Manage agreements' toggle button
    And I add Agreement to the View
    Then On Manage view page - I click create checkout form
    And I publish the View
    When I select the 'Last Modified' option from the 'Sort By' dropdown
    And On the View directory Page - I click on the first view
    And On Manage View page - I click on 'Manage users' toggle button
    And On Select User page - I add user 'julian.sheppard' to the view
    Then On Manage View page - I verify that the View is published
    And  On Manage View page - I delete the view through URL
    Then I log out








































