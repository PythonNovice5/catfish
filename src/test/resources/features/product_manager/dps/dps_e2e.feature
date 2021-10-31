@DPSEndToEnd
@AWSRegression
Feature: Create framework agreement with DPS questionaire,Publish to Marketplace and raise a Quote
  Scenario: Create a Framework Agreement with DPS
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Buyer' 'Create Agreement' panel
    And On the Create Agreement page - I select Agreement 'Type' of 'Framework Agreement'
    And On the Create Agreement page - I enter Agreement 'Name' of 'CATFISH-Framework-'
    And On the Create Agreement page - I enter Agreement 'Start Date' of 'TODAY'
    And On the Create Agreement page - I enter Agreement 'Expiry Date' of 'FUTURE DATE'
    And On the Create Agreement page - I enter Agreement 'Contract Reference' of 'CATFISH-Framework-'
    And On the Create Agreement page - I select Agreement 'Language' of 'English'
    And On the Create Agreement page - I select Agreement 'Currency' of 'GBP'
    And On the Create Agreement page - I enter Agreement 'Keywords' of 'framwork,release'
    And On the Create Agreement page - I enter Agreement 'Description' of 'Test framework Agreement'
    And On the Create Agreement page - I save the 'framework' Agreement
    And On the Manage Agreement page - I 'Enable' dps
    And On the Manage Agreement page - I click on the 'manageitems' button
    And On the Agreement Pricelist Items page - I click on 'Create' button
    And  On the Agreement Items create item page - I enter 'CATFISH-ITEM1-DPS-' plus SessionGUID into 'supplierItemID'
    And  On the Agreement Items create item page - I enter 'CATFISH-ITEM1-DPS-Name' into 'Name'
    And  On the Agreement Items create item page - I enter 'CATFISH-ITEM1-Description-DPS' into 'Description'
    And  On the Agreement Items create item page - I click on 'classificationCog'
    And I select the classification category as 'Animal Feed' in 'level2Category'
    And I select the classification category as 'Fish food' in 'level3Category'
    And  On the Agreement Items create item page - I click on 'Done'
    And On the Agreement Items create item page - I click on 'Save'
    And On the Agreement Items Edit page - I click on 'Back To Agreement Price List Items'
    And On the Agreement Pricelist Items page - I click on 'ManageQualificationQuestionnaire' button
    And On Manage Qualificaiton Questionnaire Page - I drag 'List (single-select)' component into Form
    And On Manage Qualificaiton Questionnaire Page - I select 'Auto Approve' option from the 'Approval' dropdown
    And On Manage Qualificaiton Questionnaire Page - I click on 'Save'
    And On Manage Qualificaiton Questionnaire Page - I click on  Edit Component of 'List (single-select)'
    And On Manage Qualificaiton Questionnaire Page - I check that 'Edit Component' modal window 'is' displayed
    And On Manage Qualificaiton Questionnaire Page - I enter 'Your Delivery Time in days?' into 'labelTextInput'
    And On Manage Qualificaiton Questionnaire Page - I click on 'Required Field CheckBox'
    And On Manage Qualificaiton Questionnaire Page - I click on 'Add Option'
    And On Manage Qualificaiton Questionnaire Page - I enter '10' into 'firstOptionValue'
    And On Manage Qualificaiton Questionnaire Page - I click on 'Add Option'
    And On Manage Qualificaiton Questionnaire Page - I enter '30' into 'secondOptionValue'
    And On Manage Qualificaiton Questionnaire Page - I select 'First Option Value' for autoapproval
    And On Manage Qualificaiton Questionnaire Page - I click on 'Update'
    And On Manage Qualificaiton Questionnaire Page - I click on 'Save'
    And On Manage Qualificaiton Questionnaire Page - I click on 'Agreement Price List Items bread crumb'
    And On the Agreement Pricelist Items page - I click on 'ManageItemQuestionnaire' button
    And On Manage Item Questionnaire Page - I drag 'List (single-select)' component into Form
    And On Manage Item Questionnaire Page - I click on  Edit Component of 'List (single-select)'
    And On Manage Item Questionnaire Page - I check that 'Edit Component' modal window 'is' displayed
    And On Manage Item Questionnaire Page - I enter 'Color' into 'labelTextInput'
    And On Manage Item Questionnaire Page - I click on 'Required Field CheckBox'
    And On Manage Item Questionnaire Page - I click on 'Add Option'
    And On Manage Item Questionnaire Page - I enter 'Red' into 'firstOptionValue'
    And On Manage Item Questionnaire Page - I click on 'Add Option'
    And On Manage Item Questionnaire Page - I enter 'Blue' into 'secondOptionValue'
    And On Manage Item Questionnaire Page - I click on 'Filterable Field'
    And On Manage Item Questionnaire Page - I click on 'Update'
    And On Manage Item Questionnaire Page - I click on 'Save'
    And On Manage Item Questionnaire Page - I click on 'Agreement Price List Items bread crumb'
    And On the Agreement Pricelist Items page - I click on 'Done' button
    And On the Manage Agreement page - I click on the 'Approve' button
    And I log out


  Scenario: Create Item as per Item questionnaire
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    When I navigate to the internal 'SupplierContracts' page
#    And On Supplier Contracts page - I enter 'CATFISH-ITEM1-DPS-Name' into 'Search'
    And On Supplier Contracts page - I enter 'DPS Contract' into 'Search'
    And On Supplier Contracts page - I click on 'Search' button
    And On Supplier Contracts page - I click on first Contract 'Manage qualification' link
    And On Manage Qualification page - I enter 'xyz@basware.com' into 'Contact Email'
    And On Manage Qualification page - I select '10' from 'Your Delivery Time in days?' dropdown
    And On Manage Qualification page - I click on 'Submit'
    And On Supplier Contracts page - I click on first Contract 'Manage Items' link
    And On Contracts Item Directory page - I click on 'Create Item' button
    And On Contracts Create Item page - I enter the following item details
      | Name          | Foxfish Contract Item DPS  |
      | SKU           |  DPS Supplier ID           |
      | Description   | DPS Item Description       |
      | Keywords      | Foxfish Keywords           |
      | Contact Email | xyz@basware.com            |
      | Color         | Red                        |

    And On Contracts Create Item page - I click on 'Submit' button
    And On Contracts Item Directory page - I click on 'Done' button
    And I log out

  Scenario: Attach agreement to the view and publish the DPS item from approved supplier
    Given I log into Commerce Network as 'BUYER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Buyer' 'Views' submenu item
    When On Views directory page - I click on the Views 'Published' filter
    And On the View directory page - I enter 'FrameworkAgreementCatfishView' into 'SearchKeywords'
    And On the View directory Page - I click on the first view
    And On Manage View page - I click on 'Manage agreements' toggle button
    When On Select view agreement page - I select agreement
    And I add Agreement to the View
    And I publish the View
    When I select the 'Last Modified' option from the 'Sort By' dropdown
    And I refresh page and wait '2' seconds before continuing
    And On the View directory page - I click on 'cog' button
    Then On Manage View page - I verify that the View is published
    Then I log out

  Scenario: Search for DPS item in marketplace, select supplier and raise a quote
    Given I log into Commerce Network as 'BUYER_ADMIN'
    And  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    And  On the Marketplace Landing page - I click on the 'Search' button
    When On the Marketplace Search Results page - I enter 'DPS Supplier ID5F4CDA8A1E7B2B2D560' into 'SearchKeywords'
    And  On the Marketplace Search Results page - I click on the 'Search' button
    When On the Marketplace Search Results page - I select the 'Date (newest to oldest)' option from the 'Order By' dropdown
    Then On the Marketplace Search Results page - I check that first item 'ItemID' value is 'ExpectedValue'
    And On the Marketplace Search Results page - I click on the 'first item View' button
    And On the Item Details page - I click on the 'Select Suppliers' button
#    Then On the Item Directory page - I verify that item select checkbox is disabled ????needs to be verified after dom changes
    And On the Marketplace Item Directory page - I click on 'RedCheckBox' checkbox
    And On the Marketplace Item Directory page - I click on 'SelectItemCheckBox' checkbox
    And On the Marketplace Item Directory page - I click on 'Get Quotes' button
    And On the RFQ page - I enter 'RFQ Title' as 'CATFISH RFQ'
    And On the RFQ page - I enter 'Expiration date' as '7'
    And On the RFQ page - I enter 'Currency' as 'GBP'
    And On the RFQ page - I enter 'Name' as 'CATFISH RFQ PRODUCT NAME'
    And On the RFQ page - I enter 'Quantity' as '10'
    And On the RFQ page - I enter 'Order unit' as 'Each'
    And I wait '5' seconds before continuing
    And On the RFQ Page - I click on 'update' button
    And I wait '1' seconds before continuing
    And On the RFQ Page - I click on 'save' button
    And I wait '1' seconds before continuing
    When  I navigate to the internal 'Shopping' page
    And I click on the Shopping 'Quick Quote' submenu item
    Then I click on 'Draft' in the list items
    And click on new rfq
   # And On the RFQ page - I check title is same
    And On the RFQ Page - I click on 'send' button
    And I log out
































    



