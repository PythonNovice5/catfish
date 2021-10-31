@CLRegression
@AWSRegression

Feature: Marketplace - Punch in to Marketplace

  @OCIPunchinVariantA
  Scenario: [document_tracker.feature] Testing Punch Out testing tool for OCI Regression
    Given I log into POTT
    When On Punchout Home page - I click on 'VIEW' link for 'OCI Regression'
    And On Punchout Form page - I select framework as 'ANGULAR'
    And On Punchout Form page - I click on 'Submit' button
    And I wait '1' seconds before continuing
    And  On the Marketplace Landing page - I click on the 'Search' button
    When On the Marketplace Search Results page - I click on the 'Basket' button
    Then On the Shopping Basket page - I empty the shopping basket
    When  I click on the Shopping 'Marketplace' submenu item
    And On the Marketplace Landing page - I enter 'Catfish Test Item' into 'SearchKeywords'
#    And On the Marketplace Landing page - I enter 'asdasd' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    When On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
    When On the Marketplace Search Results page - I click on the 'Basket' button
    And On the Shopping Basket page - I store the item details
    When On the Shopping Basket page - I click on the 'CheckoutPO' button
    Then On Punchout Test Tool Checkout Page - I verify Item details

  @OAGPunchin
  Scenario: Testing Punch Out testing tool for OAG Regression
    Given I log into POTT
    When On Punchout Home page - I click on 'VIEW' link for 'OAG Regression'
    And On Punchout Form page - I select framework as 'ANGULAR'
    And On Punchout Form page - I click on 'Submit' button
    And I wait '1' seconds before continuing
    And  On the Marketplace Landing page - I click on the 'Search' button
    When On the Marketplace Search Results page - I click on the 'Basket' button
    Then On the Shopping Basket page - I empty the shopping basket
    And  On the Shopping Basket page - I click on the 'Back Link' breadcrumb
    When On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
    When On the Marketplace Search Results page - I click on the 'Basket' button
    And On the Shopping Basket page - I store the item details
    When On the Shopping Basket page - I click on the 'CheckoutPO' button
    Then On Punchout Test Tool Checkout Page - I verify Item details

  @CXMLPunchin
  Scenario:Testing Punch Out testing tool for CXML Regression
    Given I log into POTT
    When On Punchout Home page - I click on 'VIEW' link for 'CXML Regression'
    And On Punchout Form page - I select framework as 'ANGULAR'
    And On Punchout Form page - I click on 'Submit' button
    And I wait '1' seconds before continuing
    And  On the Marketplace Landing page - I click on the 'Search' button
    When On the Marketplace Search Results page - I click on the 'Basket' button
    Then On the Shopping Basket page - I empty the shopping basket
    When  I click on the Shopping 'Marketplace' submenu item
#    And On the Marketplace Landing page - I enter 'asdasd' into 'SearchKeywords'
    And  On the Marketplace Landing page - I click on the 'Search' button
    When On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
    When On the Marketplace Search Results page - I click on the 'Basket' button
    And On the Shopping Basket page - I store the item details
    When On the Shopping Basket page - I click on the 'CheckoutPO' button
    Then On Punchout Test Tool Checkout Page - I verify Item details

  @OAGPunchinWithDuns
  Scenario: Testing Punch Out testing tool for OAG with no shortname
    Given I log into POTT
    When On Punchout Home page - I click on 'VIEW' link for 'OAG Regression'
    And On Punchout Form page - I select framework as 'ANGULAR'
    And On Punchout Form page - I click on 'Submit' button
    And I wait '1' seconds before continuing
    And  On the Marketplace Landing page - I click on the 'Search' button
    When On the Marketplace Search Results page - I click on the 'Basket' button
    Then On the Shopping Basket page - I empty the shopping basket
    And  On the Shopping Basket page - I click on the 'Back Link' breadcrumb
    When On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
    When On the Marketplace Search Results page - I click on the 'Basket' button
    And On the Shopping Basket page - I store the item details
    When On the Shopping Basket page - I click on the 'CheckoutPO' button
    Then On Punchout Test Tool Checkout Page - I verify Item details

  @PunchInWithView
  Scenario: Verify punchin to Marketpalce with CXML with views
    Given I log into POTT
    When On Punchout Home page - I click on 'VIEW' link for 'CXML Regression'
    And On Punchout Form page - I enter value 'ViewA' into 'ViewNames'
    And On Punchout Form page - I click on 'Submit' button
    And I wait '1' seconds before continuing
    And  On the Marketplace Landing page - I click on the 'Search' button
    Then On the Marketplace Search Results page - I check that 'FirstItemContractReference' value is 'ViewA'
    When On the Marketplace Search Results page - I click on the 'Basket' button
    Then On the Shopping Basket page - I empty the shopping basket
    And  On the Shopping Basket page - I click on the 'Back Link' breadcrumb
    When On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
    When On the Marketplace Search Results page - I click on the 'Basket' button
    And On the Shopping Basket page - I store the item details
    When On the Shopping Basket page - I click on the 'CheckoutPO' button
    Then On Punchout Test Tool Checkout Page - I verify Item details

#  @PunchOutToOCI
#  Scenario: Testing Punch Out testing tool for PunchOut to OCI regression
#    Given I log into POTT
#    When On Punchout Home page - I click on 'VIEW' link for 'OCI Regression'
#    And On Punchout Form page - I select framework as 'ANGULAR'
#    And On Punchout Form page - I click on 'Submit' button
#    And I wait '1' seconds before continuing
#    And  On the Marketplace Landing page - I click on the 'OCI Jupiter' link
#    And  On the Marketplace Landing page Jupiter - I click on the 'Search' button
#    And On the Marketplace Search Results page Jupiter - I click on the 'Basket' button
#    And On the Shopping Basket page Jupiter - I empty the shopping basket
#    And  On the Shopping Basket page Jupiter - I click on the 'Back Link' breadcrumb
#    And On the Marketplace Search Results page Jupiter - I enter 'Catfish Test Item' into 'SearchKeywords'
#    And  On the Marketplace Search Results page Jupiter - I click on the 'Search' button
#    And On the Marketplace Search Results page Jupiter - I click on the first item 'AddToBasket' button
#    And On the Marketplace Search Results page Jupiter - I click on the 'Basket' button
#    And On the Shopping Basket page Jupiter - I store the item details
#    And On the Shopping Basket page Jupiter - I click on the 'CheckoutPO' button
#    Then On Punchout Test Tool Checkout Page - I verify Item details

  @DoublePunchOutToInternalSite
  Scenario: Testing Punch Out testing tool for double punch out to internal site
    Given I log into POTT
    When On Punchout Home page - I click on 'VIEW' link for 'OCI Regression'
    And On Punchout Form page - I select framework as 'ANGULAR'
    And On Punchout Form page - I click on 'Submit' button
    And I wait '1' seconds before continuing
    And  On the Marketplace Landing page - I click on the 'DPO TO JUPITER' link
    And  On the Marketplace Landing page Jupiter - I click on the 'Search' button
    When On the Marketplace Search Results page Jupiter - I click on the 'Basket' button
    Then On the Shopping Basket page Jupiter - I empty the shopping basket
    And  On the Shopping Basket page Jupiter - I click on the 'Back Link' breadcrumb
    When On the Marketplace Search Results page Jupiter - I enter 'catfish test' into 'SearchKeywords'
    And I wait '1' seconds before continuing
    And On the Marketplace Search Results page Jupiter - I click on the 'Search' button
    And I wait '1' seconds before continuing
    And On the Marketplace Search Results page Jupiter - I click on the first item 'AddToBasket' button
    And On the Marketplace Search Results page Jupiter - I click on the 'Basket' button
    And On the Shopping Basket page Jupiter - I store the item details
    When On the Shopping Basket page Jupiter - I click on the 'CheckoutInternalSite' button
    And I wait '1' seconds before continuing
    And On the Shopping Basket page - I click on the 'CheckoutPO' button
    Then On Punchout Test Tool Checkout Page - I verify Item details

  @OCIPunchinActionsEdit
  Scenario: Testing Punch Out testing tool for OCI punchin with EDIT action in basket
    Given I log into POTT
    When On Punchout Home page - I click on 'VIEW' link for 'Alusta (Angular)'
    And On Punchout Form page - I enter value 'EDIT' into 'Actions'
    And On Punchout Form page - I select framework as 'ANGULAR'
    And On Punchout Form page - I override the OCI fields
    And On Punchout Form page - I click on 'SubmitForEDITAction' button
    And I navigate back to previous tab

  @OCIPunchinActionsSearch
  Scenario: Testing Punch Out testing tool for OCI punchin with Search Item action in basket
    Given I log into POTT
    When On Punchout Home page - I click on 'VIEW' link for 'Alusta (Angular)'
    And On Punchout Form page - I enter value 'SEARCH' into 'Actions'
    And On Punchout Form page - I enter value 'catfishExternalBasket' into 'SearchTerms'
    And On Punchout Form page - I override the OCI fields
    And On Punchout Form page - I select framework as 'ANGULAR'
    And On Punchout Form page - I click on 'SubmitForSearchItem' button
    Then On the Marketplace Search Results page - I check that first item 'Name' 'is' displayed
    And  On the Marketplace Search Results page - I check that first item 'Name' value is 'Catfish Test Item'
    And  On the Marketplace Search Results page - I check that first item 'ItemID' value is 'catfishExternalBasket'
    Then I navigate back to previous tab

  @OCIExpressCheckOut
  Scenario: Testing Express Check out with OCI punchin
    Given I log into POTT
    When On Punchout Home page - I click on 'VIEW' link for 'OCI Regression'
    And On Punchout Form page - I select framework as 'ANGULAR'
    And On Punchout Form page - I click on 'Submit' button
    And I wait '1' seconds before continuing
    And On the Marketplace Landing page - I click on the 'Search' button
    And On the Marketplace Search Results page - I enter 'Catfish Test Item' into 'SearchKeywords'
    And I wait '1' seconds before continuing
    And  On the Marketplace Search Results page - I click on the 'Search' button
    And I wait '1' seconds before continuing
    And On the Marketplace Search Results page - I click on the 'FirsItemExpressCheckOut' button
    Then On Punchout Test Tool Checkout Page - I verify Express Checkout details


  @OCILanguageTest
  Scenario: Verify different content langague items on punchin
       Given I log into POTT
       When On Punchout Home page - I click on 'VIEW' link for 'Alusta (Angular)'
       And I wait '1' seconds before continuing
       And On Punchout Form page - I override the OCI fields
       And On Punchout Form page - I click on 'Submit' button
       And I wait '1' seconds before continuing
       And  On the Marketplace Landing page - I click on the 'Search' button
       When On the Marketplace Search Results page - I click on the 'Basket' button
       Then On the Shopping Basket page - I empty the shopping basket
       And  On the Shopping Basket page - I click on the 'Back Link' breadcrumb
       Then On the Marketplace Search Results page - I enter '-English' into 'SearchKeywords'
       And  On the Marketplace Search Results page - I click on the 'Search' button
       When On the Marketplace Search Results page - I click on the 'ShowAsThumbnailButton' button
       Then On the Marketplace Search results page - I verify language items are displaying as expected
       Then On the Marketplace Search Results page - I enter '-Danish' into 'SearchKeywords'
       And  On the Marketplace Search Results page - I click on the 'Search' button
       Then On the Marketplace Search results page - I verify language items are displaying as expected
       Then On the Marketplace Search Results page - I enter '-Finnish' into 'SearchKeywords'
       And  On the Marketplace Search Results page - I click on the 'Search' button
       Then On the Marketplace Search results page - I verify language items are displaying as expected
       When On the Marketplace Search Results page - I click on the 'ShowAsListButton' button
       When On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
       When On the Marketplace Search Results page - I click on the 'Basket' button
       And On the Shopping Basket page - I store the item details
       When On the Shopping Basket page - I click on the 'CheckoutPO' button
       Then On Punchout Test Tool Checkout Page - I verify Item details

 @CXMLPunchin
 Scenario: Verify punchin to Marketplace with CXML Format
     Given I log into POTT
     When On Punchout Home page - I click on 'SUBMIT' link for 'CXML Regression'
     And I wait '1' seconds before continuing
     And  On the Marketplace Landing page - I click on the 'Search' button
     When On the Marketplace Search Results page - I click on the 'Basket' button
     Then On the Shopping Basket page - I empty the shopping basket
     And  On the Shopping Basket page - I click on the 'Back Link' breadcrumb
     Then On the Marketplace Search Results page - I add all items into basket
        # | Item Type     | Item ID |
         | Standard item | Automation-2 |
         | Bundle item   | Automation-Bundle |
     When On the Marketplace Search Results page - I click on the 'Basket' button
     And On the Shopping Basket page - I store the item details
     When On the Shopping Basket page - I click on the 'CheckoutPO' button
     Then On Punchout Test Tool Checkout Page - I verify Item details for 'CXML'

  @OCIVariantKPunchinAddDifferentItems
  @AutoCoder
   Scenario: Verify punchin to Marketplace with OCI- Variant K Format add different type of products and verify products in checkout
        Given I log into POTT
        When On Punchout Home page - I click on 'VIEW' link for 'Alusta (Angular)'
        And I wait '1' seconds before continuing
        And On Punchout Form page - I override the OCI fields
        And On Punchout Form page - I click on 'Submit' button
        And I wait '1' seconds before continuing
        And  On the Marketplace Landing page - I click on the 'Search' button
        When On the Marketplace Search Results page - I click on the 'Basket' button
        Then On the Shopping Basket page - I empty the shopping basket
        And  On the Shopping Basket page - I click on the 'Back Link' breadcrumb
        Then On the Marketplace Search Results page - I add all items into basket
         # | Item Type     | Item ID |
            | Standard item | Automation-2 |
            | Bundle item   | Automation-Bundle |
            | Matrix item   | AutomationMatrix-2 |
            | Template item | AutomationTemplate-01 |
            | Standard item | CoderCatfish01 |

        When On the Marketplace Search Results page - I click on the 'Basket' button
        And On the Shopping Basket page - I store the item details
        When On the Shopping Basket page - I click on the 'CheckoutPO' button
        Then On Punchout Test Tool Checkout Page - I verify Item details for 'OCI'

  @ExternalBasketComplete
  Scenario: Verify External Basket Complete
        Given I log into POTT
        When On Punchout Home page - I click on 'VIEW' link for 'Alusta (Angular)'
        And I wait '1' seconds before continuing
        And On Punchout Form page - I store the View details
        And On Punchout Form page - I click on 'Submit' button
        And I wait '1' seconds before continuing
        And  On the Marketplace Landing page - I click on the 'Search' button
        When On the Marketplace Search Results page - I click on the 'Basket' button
        And On the Shopping Basket page - I empty the shopping basket
        Then On the Shopping Basket page - I check that the number of 'ItemNames' is '0'
        And  On the Shopping Basket page - I click on the 'Back Link' breadcrumb
        And On the Marketplace Search Results page - I enter 'catfishExternalBasket' into 'SearchKeywords'
        And  On the Marketplace Search Results page - I click on the 'Search' button
        And On the Marketplace Search Results page - I click on the first item 'AddToBasket' button
        And On the Marketplace Search Results page - I click on the 'Basket' button
        Then On the Shopping Basket page - I check that the number of 'ItemNames' is '1'
        When I navigate back to previous tab
        And On Punchout Home page - I click on 'ALUSTA' link
        And On Punchout Home page - I click on 'Basket Complete' link
        And On Complete Basket page - I enter value 'OrgIDValue' into 'orgID'
        And On Complete Basket page - I enter value 'SharedSecretValue' into 'sharedSecret'
        And On Complete Basket page - I enter value 'UserNameValue' into 'userName'
        And On Complete Basket page - I select 'Environment' as 'EnvUnderTest'
        And On Complete Basket page - I click on 'Submit' button
        And I click on the back button and return to the previous Complete Basket page
        And I click on the back button and return to the previous PunchOut Test tool page
        And On Punchout Home page - I click on 'SUBMIT' link for 'Alusta (Grails)'
        And  On the Marketplace Landing page - I click on the 'Search' button
        When On the Marketplace Search Results page - I click on the 'Basket' button
        Then On the Shopping Basket page - I check that the number of 'ItemNames' is '0'
