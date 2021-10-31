@CLRegression
@AWSRegression
Feature: Marketplace - Punch out to Marketplace

  @OCIPunchOutToJupiter
  Scenario: Verify OCI punchout to Jupiter Marketplace with Variant C
    Given I log into Commerce Network as 'BUYER_ADMIN_NONDESTRUCTIVE'
    And  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    And  On the Marketplace Landing page - I click on the 'OCIToJupiterAngularFoxfish' link
    And  On the Marketplace Landing page Jupiter - I click on the 'Search' button
    When On the Marketplace Search Results page Jupiter - I enter 'FoxFishItemDontDelete' into 'SearchKeywords'
    And  On the Marketplace Search Results page Jupiter - I click on the 'Search' button
    When On the Marketplace Search Results page Jupiter - I click on the first item 'AddToBasket' button
    When On the Marketplace Search Results page Jupiter - I click on the 'Basket' button
    And  On the Shopping Basket page Jupiter - I check that first item 'Name' value is 'FoxFishItemDontDelete'
    And On the Shopping Basket page Jupiter - I empty the shopping basket
    

  @CXMLPunchOutToJupiter
  Scenario: Verify CXML punchout to Jupiter Marketplace with Variant C
    Given I log into Commerce Network as 'BUYER_ADMIN_NONDESTRUCTIVE'
    And  I navigate to the internal 'Shopping' page
    And  I click on the Shopping 'Marketplace' submenu item
    And  On the Marketplace Landing page - I click on the 'DPOToJupiterAngCXML' link
    And  On the Marketplace Landing page Jupiter - I click on the 'Search' button
    When On the Marketplace Search Results page Jupiter - I enter 'FoxFishItemDoNotDel' into 'SearchKeywords'
    And  On the Marketplace Search Results page Jupiter - I click on the 'Search' button
    When On the Marketplace Search Results page Jupiter - I click on the first item 'AddToBasket' button
    When On the Marketplace Search Results page Jupiter - I click on the 'Basket' button
    And  On the Shopping Basket page Jupiter - I check that first item 'Name' value is 'FoxFishItemDoNotDel'
    And On the Shopping Basket page Jupiter - I empty the shopping basket