@CLRegression
@AWSRegression
@MarketplaceLite
Feature: Verify Marketplace Lite toggle switch functionality

Scenario: Verify the MarketplaceLite toggle switch
  Given I log into Commerce Network as 'MARKETPLACE_LITE_USER'
  When I navigate to the internal 'Product Manager' page
  And I click on the Product Manager 'Buyer' 'Create Agreement' panel
  And On the Create Agreement page - I select Agreement 'Type' of 'Agent Agreement'
  Then On the Create Agreement page - I select Agreement 'Type' of 'Punchout Agreement'
  And On the Create Agreement page - I select Agreement 'Type' of 'Agent Agreement'
  And On the Create Agreement page - I check that 'Organisation Agreement' 'isNot' displayed
  And On the Create Agreement page - I check that 'Shared Agreement' 'isNot' displayed
  And On the Create Agreement page - I check that 'Framework Agreement' 'isNot' displayed
  And I log out