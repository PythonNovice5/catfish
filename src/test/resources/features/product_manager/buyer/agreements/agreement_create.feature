@CLRegression
@AWSRegression
@buyer_agreements
Feature: Agreements - Create an Agreement
  @orgAgreement
  Scenario: Create an Organisation Agreement
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Buyer' 'Create Agreement' panel
    And On the Create Agreement page - I select Agreement 'Type' of 'Organisation agreement'
    And On the Create Agreement page - I enter Agreement 'Name' of 'CATFISH-ORG-ONLY-'
    And On the Create Agreement page - I enter Agreement 'Start Date' of 'TODAY'
    And On the Create Agreement page - I enter Agreement 'Expiry Date' of 'FUTURE DATE'
    And On the Create Agreement page - I enter Agreement 'Contract Reference' of 'CATFISH-CREF-'
    And On the Create Agreement page - I select Agreement 'Language' of 'English'
    And On the Create Agreement page - I select Agreement 'Currency' of 'GBP'
    And On the Create Agreement page - I enter Agreement 'Keywords' of 'organisation,release'
    And On the Create Agreement page - I enter Agreement 'Description' of 'Test Organisation Agreement'
    And On the Create Agreement page - I save the 'Organisation' Agreement
    And On the Manage Agreement page - I enter Agreement For Supplier of 'Test For Supplier - Organisation Agreement'
    Then On the Manage Agreement page - The Agreement 'Name' is 'CATFISH-ORG-ONLY-'
    And On the Manage Agreement page - The Agreement 'Type' is 'Organisation agreement'
    And On the Manage Agreement page - The Agreement 'Status' is 'Draft'
    And On the Manage Agreement page - The Agreement 'Language' is 'English'
    And On the Manage Agreement page - The Agreement 'Currency' is 'GBP'
    And On the Manage Agreement page - I click on the 'Select Supplier' button
    And On the Select Supplier page - I select the Supplier called 'CATFISH-RW-supplier'
    And On the Manage Agreement page - I click on the 'Select Approval Scheme' button
    And On the Select Approval Scheme page - I select the Approval Scheme called 'testApprovalScheme'
    And On the Manage Agreement page - The Agreement 'For Supplier' is 'Test For Supplier - Organisation Agreement'
    And On the Manage Agreement page - The Agreement 'Keywords' is 'organisation,release'
    And On the Manage Agreement page - The Agreement 'Approval Scheme' is 'testApprovalScheme [Auto-approval turned on]'
    When On the Manage Agreement page - The Agreement 'Supplier' is 'Catfish-RW-Supplier'
    Then On the Manage Agreement page - The Agreement 'Name' is 'CATFISH-ORG-ONLY-'
    And On the Manage Agreement page - The Agreement 'Contract Reference' is 'CATFISH-CREF-'
    Then On Manage Agreement page - I delete new agreement
    And I log out

#  @sharedAgreement
#  Scenario: Create a Shared Agreement
#    Given I log into Commerce Network as 'BUYER_ADMIN'
#    When I navigate to the internal 'Product Manager' page
#    And I click on the Product Manager 'Buyer' 'Create Agreement' panel
#    And On the Create Agreement page - I select Agreement 'Type' of 'Shared Agreement'
#    And On the Create Agreement page - I enter Agreement 'Name' of 'CATFISH-ORG-SHARED-'
#    And On the Create Agreement page - I enter Agreement 'Start Date' of 'TODAY'
#    And On the Create Agreement page - I enter Agreement 'Expiry Date' of 'FUTURE DATE'
#    And On the Create Agreement page - I enter Agreement 'Contract Reference' of 'CATFISH-CREF-'
#    And On the Create Agreement page - I select Agreement 'Language' of 'English'
#    And On the Create Agreement page - I select Agreement 'Currency' of 'GBP'
#    And On the Create Agreement page - I enter Agreement 'Keywords' of 'shared,release'
#    And On the Create Agreement page - I enter Agreement 'Description' of 'Test Shared Agreement'
#    And On the Create Agreement page - I save the 'shared' Agreement
#    And On the Manage Agreement page - I click on the 'Select Supplier' button
#    And On the Select Supplier page - I select the Supplier called 'CATFISH'
#    And On the Manage Agreement page - I click on the 'Select Approval Scheme' button
#    And On the Select Approval Scheme page - I select the Approval Scheme called 'testApprovalScheme'
#    Then On the Manage Agreement page - The Agreement 'Name' is 'CATFISH-ORG-SHARED-'
#    And On the Manage Agreement page - The Agreement 'Contract Reference' is 'CATFISH-CREF-'
#    Then On Manage Agreement page - I delete new agreement
#    And I log out

  @punchOutAgreement
  Scenario: Create a Punchout Agreement
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Buyer' 'Create Agreement' panel
    And On the Create Agreement page - I select Agreement 'Type' of 'Punchout Agreement'
    And On the Create Agreement page - I enter Agreement 'Name' of 'CATFISH-ORG-PUNCHOUT-'
    And On the Create Agreement page - I enter Agreement 'Start Date' of 'TODAY'
    And On the Create Agreement page - I enter Agreement 'Expiry Date' of 'FUTURE DATE'
    And On the Create Agreement page - I enter Agreement 'Contract Reference' of 'CATFISH-PUNH-'
    And On the Create Agreement page - I select Agreement 'Language' of 'English'
    And On the Create Agreement page - I select Agreement 'Currency' of 'GBP'
    And On the Create Agreement page - I enter Agreement 'Keywords' of 'shared,release'
    And On the Create Agreement page - I enter Agreement 'Description' of 'Test Shared Agreement'
    And On the Create Agreement page - I save the 'punchout' Agreement
    And On the Manage Agreement page - I click on the 'Select Supplier' button
    And On the Select Supplier page - I select the Supplier called 'CATFISH-RW-Supplier'
    And On the Manage Agreement page - I click on the 'Select Approval Scheme' button
    And On the Select Approval Scheme page - I select the Approval Scheme called 'testApprovalScheme'
    Then On the Manage Agreement page - The Agreement 'Name' is 'CATFISH-ORG-PUNCHOUT-'
    And On the Manage Agreement page - The Agreement 'Contract Reference' is 'CATFISH-PUNH-'
    Then On Manage Agreement page - I delete new agreement
    And I log out

















