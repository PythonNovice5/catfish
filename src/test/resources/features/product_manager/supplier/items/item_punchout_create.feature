@CLRegression
@AWSRegression
@PunchOutItem

Feature: Create punchin item as a Proc user

  Scenario: [item_punchout.create.feature] Create a standard item
    Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
    And  I navigate to the internal 'Product Manager' page
    And I select user mode as 'Supplier' on Product Manager page
    And  I click on the Product Manager 'Supplier' 'Items' submenu item
    When On the Item Directory page - I click on the 'Create' button
    And  On the Create Item page - I select the 'punchout item' option from the 'Item type' dropdown
    And  I wait for the page refresh to complete
    And  On the Create Item page - I enter 'CATFISH-ITEM1-' plus SessionGUID into 'SupplierItemID'
    And  On the Create Item page - I enter 'CATFISH-ITEM1 Name' into 'Name'
    And  On the Create Item page - I enter 'CATFISH-ITEM1 Description' into 'Description'
    And  On the Create Item page - I enter 'CATFISH-ITEM1 CATFISH' into 'Keywords'
    And  On the Create Item page - I click on the 'Add Classification' button
    When On the Create Item page - I select the 'UNSPSC (v8)' option from the 'ClassificationType' dropdown
    Then On the Create Item page - I check that 'UNSPSCCode' value is '10000000'
    And  On the Create Item page - I select the 'Healthcare Services' option from the 'Level1' dropdown
    When On the Create Item page - I select the 'Medical practice' option from the 'Level2' dropdown
    When On the Create Item page - I select the 'Medical laboratories' option from the 'Level3' dropdown
    When On the Create Item page - I select the 'X ray laboratory services' option from the 'Level4' dropdown
    Then On the Create Item page - I check that 'UNSPSCCode' value is '85121808'
    When On the Create Item page - I click on the 'Done' button
    And On the Create Item page - I check that 'X ray laboratory services' is displayed under 'v8' for 'Provided'
    And On the Create Item page - I check that 'X ray laboratory services' is displayed under 'v19' for 'Standard'
    And  On the Create Item page - I check that 'PunchoutType' value is 'XML-based (cXML and OAG)'
    And  On the Create Item page - I enter 'https://b2b-sqm.officedepot.eu/invoke/EIUK/login' into 'SetupUrl'
    And  On the Create Item page - I enter 'SetUpRequest' into 'SetupRequestField'
    And  On the Create Item page - I enter '/cXML/Response/Status/@code' into 'SetupResponseSuccess'
    And  On the Create Item page - I enter '/cXML/Response/PunchOutSetupResponse/StartPage/URL' into 'SetupResponseRedirect'
    And  On the Create Item page - I enter '//ItemIn' into 'LineTrigger'
    And  On the Create Item page - I enter '/ItemID/SupplierPartID/text()' into 'ShoppingBasketSupItemID'
    And  On the Create Item page - I enter '/ItemDetail/Description/text()' into 'ShoppingBasketDesc'
    And  On the Create Item page - I enter '/ItemDetail/Description/@xml:lang' into 'ShoppingBasketLang'
    And  On the Create Item page - I enter '/@quantity' into 'ShoppingBasketQuantity'
    And  On the Create Item page - I enter '/ItemDetail/UnitPrice/Money/text()' into 'ShoppingBasketUnitPrice'
    And  On the Create Item page - I enter '/ItemDetail/UnitPrice/Money/@currency' into 'ShoppingBasketCurCode'
    And  On the Create Item page - I enter '/SuppllierID[@domain='DUNS']/text()' into 'ShoppingBasketUOM'
    And  On the Create Item page - I enter '/SuppllierID[@domain='DUNS']/text()' into 'ShoppingBasketDUNS'
    And  On the Create Item page - I enter '/itemDetail/shipping/Description/text()' into 'ShoppingBasketShippingName'
    And  On the Create Item page - I enter '/itemDetail/shipping/Money/text()' into 'ShoppingBasketShippingPrice'
    And  On the Create Item page - I click on the 'Select Image' button
    When  On the Create Item page - I click on 'First' thumbnail
    And On the Create Item page - I click on 'SavePunchoutItem' button
    And On the Create Item page - I enter 'Test_Secret' into 'ATT_SHARED_SECRET'
    And On the Create Item page - I enter 'Test_SupID' into 'ATT_SUPPLIER_ID'
    And On the Create Item page - I click on 'Save' button
    And On the Edit Item page - I verify 'Success! You added CATFISH-ITEM1 Name' in alert message
    And On the Edit Item page - I click on the 'Delete' button
    And I log out