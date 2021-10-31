@CLRegression
@AWSRegression
@PORItemE2E

Feature: Price on request Item E2E

  Scenario: Price on request Item - Sending a quote to supplier and withdrawing it
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When  I navigate to the internal 'Shopping' page
    And I click on the Shopping 'Marketplace' submenu item
    When On the Marketplace Landing page - I enter 'CF53-DEV-10064-01' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
#    When On the Marketplace Search Results page - I check that 'PriceOnRequestStatus' value is 'Price On Request'
    And On the Marketplace Search Results page - I click on the 'Get Quote' button
    And On the Marketplace Search Results page - I enter 'Catfishreference' plus SessionGUID into 'YourReference'
    And On the Marketplace Search Results page - I enter 'CatfishDesc' into 'QuoteDescription'
    And On the Marketplace Search Results page - I click on the 'Send' button
#    Then On the Marketplace Search Results page - I verify that 'QuotesSuccessMessage' contains 'Quote submitted successfully. View the submitted quote here'
    When On the Marketplace Search Results page - I click on the 'here' link
    And On the View Price On Request page - I click on 'Withdraw'
    And On the View Price On Request page - I click on 'ConfirmWithdraw'
    And On the View Price On Request page - I verify the success message as 'Your RFQ has been withdrawn.'
    And On the View Price On Request page - I click on 'BacktoMyquotes'
    And I log out

  Scenario: Price on request Item - Sending a quote to Supplier
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When  I navigate to the internal 'Shopping' page
    And I click on the Shopping 'Marketplace' submenu item
    When On the Marketplace Landing page - I enter '181217033332_UAT-FELT/AR1/017' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
#    When On the Marketplace Search Results page - I check that 'PriceOnRequestStatus' value is 'Price On Request'
    And On the Marketplace Search Results page - I click on the 'Get Quote' button
    And On the Marketplace Search Results page - I enter 'Catfishreference2' plus SessionGUID into 'YourReference'
    And On the Marketplace Search Results page - I enter 'CatfishDesc' into 'QuoteDescription'
    And On the Marketplace Search Results page - I click on the 'Send' button
#    Then On the Marketplace Search Results page - I verify that 'SuccessMessage' contains 'Success: You Request for Quote has been sent'
    When On the Marketplace Search Results page - I click on the 'here' link
    And On the View Price On Request page - I click on 'BacktoMyquotes'
    And I log out

  Scenario: By Supplier - Entering details for quote and sending to Buyer
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    When   I navigate to the internal 'Quotes' page
    And On the supplier RFQ directory page - I click on cog for status Open
    And On the View Price On Request Supplier page - I click on 'Quote'
    And On the View Price On Request Supplier page - I enter '10' into 'Unitprice'
    When On the View Price On Request Supplier page - I select the 'Included' option from the 'DeliveryCost' dropdown
    And On the View Price On Request Supplier page - I click on 'Send'
#    Then On the Marketplace Search Results page - I verify that 'SuccessMessage' contains 'Your quote has been sent.'
    Then On the View Price On Request Supplier page - I verify the success message as 'Your quote has been sent.'
    And I log out

  Scenario: By Buyer - Accepting quote and verifying in basket
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When  I navigate to the internal 'Shopping' page
    And I click on the Shopping 'Marketplace' submenu item
    When On the Marketplace Landing page - I click on the 'Basket' button
    And  On the Shopping Basket page - I empty the shopping basket
    And I click on the Shopping 'Marketplace' submenu item
    And On the Marketplace Landing page - I click on the 'Quotes' button
    And On My Quotes Page - I click on 'ViewQuote'
    And On the View Price On Request page - I click on 'AcceptQuote'
    Then On the View Price On Request page - I verify the success message as 'The quote has been accepted and added to your shopping basket.'
    And I click on the Shopping 'Marketplace' submenu item
    When On the Marketplace Landing page - I click on the 'Basket' button
    Then On the Shopping Basket page - I check that the '181217033332_UAT-FELT/AR1/017' is present
    Then On the Shopping Basket page - I empty the shopping basket
    And I log out























