@DocumentTracker
@CLRegression
Feature: Verify documents in Document Tracker tool
#
#  Scenario: [document_tracker.feature] Verifying documents in Document Tracker
#    Given I log into Commerce Network as 'BUYER_ADMIN'
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

  Scenario: [document_tracker.feature] Verifying documents in Document Tracker
    Given I log into Commerce Network as 'BUYER_ADMIN_NONDESTRUCTIVE'
    Then I navigate to the internal 'Documents' page
    Then I validate that I can see the correct Documents tabs
    When I click on the 'Document Tracker' tab
    Then On the Document Tracker Page - I check that 'Document Ref' value is 'Blank'
    And On the Document Tracker Page - I check that 'Supplier Name' value is 'Blank'
    And On the Document Tracker Page - I check that 'DateFrom' value is 'TodayLastYear'
    And On the Document Tracker Page - I check that 'DateTo' value is 'CurrentDate'
    And On the Document Tracker Page - I check that 'Event' value is 'Received by Basware'
    And On the Document Tracker Page - I check that 'Type' value is 'Any Document Sent'
    When On the Document Tracker Page - I select 'Type' value as 'Purchase Order'
    And On the Document Tracker Page - I click on 'Search' button
    And On the Document Tracker Page - I check that 'Purchase Order List' is displayed
    And On the Document Tracker Page - I click the first Document reference
    And On the Document Tracker Page - I click on 'Download as PDF' button
    #Select Document type as 'Invoice' in 'Type'
    When I click on the 'Document Tracker' tab
    When On the Document Tracker Page - I select 'Type' value as 'Invoice'
    And On the Document Tracker Page - I click on 'Search' button
    And On the Document Tracker Page - I check that 'Invoice List' is displayed
    And On the Document Tracker Page - I click the first Document reference
    Then On the Document Tracker Page - I check that 'Purchase Order XXXXXXXXXXXX' is displayed
    And On the Document Tracker Page - I check that 'Invoice XXXXXXXXXX' is displayed
    When On the Document Tracker Page - I click on 'Purchase Order XXXXXXXXXXXX' link under 'Document History'
    And On the Document Tracker Page - I click on 'BackToPreviousPage' button
    And On the Document Tracker Page - I click on 'Download as PDF' button
    When I click on the 'Document Tracker' tab
    And On the Document Tracker Page - I enter '0000000006' into 'DocumentRef'
    When On the Document Tracker Page - I select 'Type' value as 'Invoice'
    And On the Document Tracker Page - I click on 'Search' button
    Then On the Document Tracker Page - I check that 'Invoice List' is displayed
    When I click on the 'Document Tracker' tab
    And On the Document Tracker Page - I select 'Type' value as 'Any Document Received'
    And On the Document Tracker Page - I click on 'Search' button
    And On the Document Tracker Page - I check that 'Any Document Received' is displayed
    When I click on the 'Document Tracker' tab
    When On the Document Tracker Page - I select 'Type' value as 'Any Document Sent'
    And On the Document Tracker Page - I enter '' into 'DocumentRef'
    And On the Document Tracker Page - I click on 'Search' button
    And On the Document Tracker Page - I check that 'Purchase Order List' is displayed
    And I log out