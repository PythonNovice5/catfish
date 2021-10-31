@CLRegression
@LVP
Feature: LVP certifications

  Scenario: Verify LVP certifications
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    When I navigate to the internal 'Product Manager' page
    And I navigate to the internal 'Organisation Management' page via the Settings dropdown
    And On Organisation Management Page - I click on 'Certification'
    Then On Organisation Management Page - I verify the status as 'Certified'
    And On Organisation Management Page - I click on 'Care (All)'
    When On Organisation Management Page - I select 'Care (All)' as type of course
    When On Organisation Management Page - I click on 'Save'
    And On Organisation Management Page - I click on 'Certification'
    Then On Organisation Management Page - I verify the status as 'Not certified'
    When On Organisation Management Page - I select 'Care (All)' as type of course
    When On Organisation Management Page - I click on 'self-certification questionnaire'
    And On Organisation Management Page - I click on 'YesRadioButtonForAllAnswers'
    And On Organisation Management Page - I click on 'Update'
    When On Organisation Management Page - I click on 'Save'
    And On Organisation Management Page - I click on 'Certification'
    Then On Organisation Management Page - I verify the status as 'Certified'
    When On Organisation Management Page - I click on 'Financial information'
    And On Organisation Management Page - I enter '1234' into 'AccountName'
    When On Organisation Management Page - I click on 'Save'
    And On Organisation Management Page - I click on 'Certification'
    Then On Organisation Management Page - I verify the status as 'Not certified'
    When On Organisation Management Page - I click on 'self-certification questionnaire'
    And On Organisation Management Page - I click on 'YesRadioButtonForAllAnswers'
    And On Organisation Management Page - I click on 'Update'
    When On Organisation Management Page - I click on 'Save'
    And On Organisation Management Page - I click on 'Certification'
    Then On Organisation Management Page - I verify the status as 'Certified'
    And I log out