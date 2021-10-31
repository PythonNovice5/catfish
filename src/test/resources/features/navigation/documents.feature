@documents
Feature: BTTF page navigation checks

  Scenario: Check the Documents My Notifications page links work for BUYER_BASIC
    Given I log into Commerce Network as 'BUYER_BASIC'
    Then I navigate to the internal 'Documents' page
    Then I validate that I can see the correct Documents tabs
    Then I validate that I can see the correct My Notifications filters
    Then I click on the Search button
    Then I click on the 'My Notifications' tab
    Then I check that the link of the first notification found works
    Then I navigate to the internal 'Documents' page
    Then I navigate to the My Transactions page via the 'Unread Credit Notes' filter
    Then I navigate to the internal 'Documents' page
    Then I navigate to the My Transactions page via the 'Unpaid Invoices' filter
    Then I navigate to the internal 'Documents' page
    Then I navigate to the My Transactions page via the 'Unread Quotes' filter
    Then I navigate to the internal 'Documents' page
##    Then I navigate to the My Transactions page via the 'Requisitions pending my approval' filter
##    Then I navigate to the internal Documents page
    Then I navigate to the My Transactions page via the 'Requisitions pending approval' filter
    Then I navigate to the internal 'Documents' page
    Then I navigate to the My Transactions page via the 'Purchase Orders without an invoice' filter
    Then I navigate to the internal 'Documents' page
    Then I navigate to the My Transactions page via the 'Requests for Quote about to expire' filter
    Then I navigate to the internal 'Documents' page
    Then I navigate to the My Transactions page via the 'Requests for Quotes that have expired' filter
    Then I navigate to the internal 'Documents' page
    And I log out

  Scenario: Check the Documents My Transactions page links work for BUYER_BASIC
    Given I log into Commerce Network as 'BUYER_BASIC'
    Then I navigate to the internal 'Documents' page
    Then I validate that I can see the correct Documents tabs
    Then I validate that I can see the correct My Notifications filters
    Then I click on the Search button
    Then I click on the 'My Transactions' tab
    Then I click on the 'My Transactions' filter
    Then I click on the 'That Were / Received' filter
    Then I click on the 'That Were / Sent' filter
    Then I click on the 'That Were / Archived' filter
    Then I click on the 'That Were / All of the above' filter
    Then I click on the 'That I / Have flagged' filter
    Then I click on the 'That I / Have read' filter
    Then I click on the 'That I / Have not read' filter
    Then I click on the 'That I / Need to approve' filter
    Then I click on the 'That I / All of the above' filter
    Then I click on the 'Document Type / Any' filter
    Then I click on the 'Document Type / Requests for Quote' filter
    Then I click on the 'Document Type / Quotes' filter
    Then I click on the 'Document Type / Requisitions' filter
    Then I click on the 'Document Type / Purchase Orders' filter
    Then I click on the 'Document Type / Invoices' filter
    Then I click on the 'Document Type / Credit Notes' filter
    Then I click on the 'My Transactions' tab
    Then I click on Sort By: 'Date'
    Then I click on Sort By: 'Document Type'
    Then I click on Sort By: 'Ref'
    Then I click on Select: 'All'
    Then I click on Select: 'None'
    Then I click on Mark as: 'Flagged'
    Then I click on Mark as: 'Un-flagged'
    Then I click on Mark as: 'Read'
    Then I click on Mark as: 'Unread'
    Then I click on Mark as: 'Archived'
    Then I set the page size to '25'
    Then I set the page size to '50'
    Then I set the page size to '100'
    Then I check I can look at a document family in My Transactions
    Then I 'expand' the first document in the family in My Transactions
    #Then I download the first document as CXML
    #Then I download the first document as PDF
    Then I 'collapse' the first document in the family in My Transactions
    Then I click on Back to your results
    And I log out
