Feature: Supplier uploading media file

  @CLRegression
  @UploadContentMedia
  Scenario:[upload_media.feature] Upload and verify Media file by Supplier user
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Supplier' 'Media' submenu item
    And on Media Directory page - I click on 'Upload files' button
    And on Upload Files page - I upload 'catfish001.jpg' file
    Then on Upload Files page - I check that 'catfish001.jpg' upload status is 'Completed'
    And I click on the Product Manager 'Supplier' 'Media' submenu item
    And I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Supplier' 'Items' submenu item
    And On the Item Directory page - I click on the 'Create' button
    And  On the Create Item page - I click on the 'Select Image' button
    When On the Create Item page - I enter 'catfish001' into 'SearchKeywords'
    And On the Create Item page - I click on the 'Search' button
    And On the Create Item page - I check that 'CatfishMedia' 'is' displayed
    And On the Create Item page - I click on the 'CancelModalWindow' button
    And I log out

  @AWSRegression
  @UploadContentMedia
  Scenario: Upload an image and verify it is uploaded in AWS media
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Supplier' 'Media' submenu item
    And on Media Directory page - I click on 'Upload files' button
    And on Upload Files page - I upload 'catfish001.jpg' file
    Then on Upload Files page - I check that 'catfish001.jpg' upload status is 'Completed'
    And I click on the Product Manager 'Supplier' 'Media' submenu item
    Then On Media Directory page - I search 'catfish001' and verify image is uploaded in AWS media
    And I navigate to the internal 'Product Manager' page
    And I click on the Product Manager 'Supplier' 'Items' submenu item
    And On the Item Directory page - I click on the 'Create' button
    And  On the Create Item page - I click on the 'Select Image' button
    When On the Create Item page - I enter 'catfish001' into 'SearchKeywords'
    And On the Create Item page - I click on the 'Search' button
    And On the Create Item page - I check that 'CatfishMedia' 'is' displayed
    And On the Create Item page - I click on the 'CancelModalWindow' button
    And I log out





