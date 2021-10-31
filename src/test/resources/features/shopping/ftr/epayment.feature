@CLRegression
@EPaymentPO

Feature: This feature covers tests to create epayment PO and submit it supplier

  Scenario: Create ePayment PO
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When  I navigate to the internal 'Shopping' page
    And I click on the Shopping 'Free Text Requisitions' submenu item
    And On Free text requisitions management page -I click on 'Raise a Free Text Requisition' from the Actions menu
    And On FTR edit page - I enter 'Your reference' as 'Catfish reference'
    And On FTR edit page - I enter 'Target Delivery Date' as '1'
     #And On FTR edit page - I attach a file
    And On FTR edit page - I enter 'special Instructions' as 'Test for ePayement PO'
    And On FTR edit page - I click on 'Add line item' to add 'line items'
    And On Line item page - I enter 'Item name' as 'Catfish epayment'
    And On Line item page - I enter 'Quantity' as '2'
    And On Line item page - I enter 'Unit price' as '100'
    And On Line item page - I enter 'Item description' as 'Catfish description for ePayment creation'
    And On Line item page - I select 'level1Category' as 'Apparel and Luggage and Personal Care Products'
    And On Line item page - I select 'level2Category' as 'Clothing'
    And On Line item page - I select 'level3Category' as 'Athletic wear'
    And On Line item page - I select 'level4Category' as 'Girls athletic wear'
    And On Line item page - I click on 'Add' to add 'line item'
    And On FTR edit page - I click on 'Add line item' to add 'line items'
    And On Line item page - I enter 'Item name' as 'Catfish test item'
    And On Line item page - I enter 'Quantity' as '2'
    And On Line item page - I enter 'Unit price' as '100'
    And On Line item page - I enter 'Item description' as 'Catfish description for FTR creation'
    Then On Line item page - I select 'level1Category' as 'Apparel and Luggage and Personal Care Products'
    And On Line item page - I select 'level2Category' as 'Clothing'
    And On Line item page - I click on 'Add' to add 'line item'
    And On FTR edit page - I click on 'Select a Supplier' to add 'Supplier'
    Then On Available supplier page - I select supplier 'Catfish-RW-Supplier' to the the FTR
    And On FTR edit page - I click on Submit button
    Then On Invoice details page - I select check box for supplier
    Then On Invoice details page - I select payment method to 'Basware ePayment'
    And  On Invoice details page - I click on change button
    Then On add payment details page - I end card number and save
    Then On Invoice details page - I click on 'Send' button to submit 'FTR'
    And On Free text requisitions management page - I verify the FTR
    And I log out