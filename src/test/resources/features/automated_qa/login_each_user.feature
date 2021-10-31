@CLRegression
@AWSRegression
@menu_options_check
Feature: User main menu, Setting and footer items validation for each test user

  Scenario: [login_each_user.feature] Check that PROC_USER_ALL_ROLES can login, validate menu options
    Given I log into Commerce Network as 'PROC_USER_ALL_ROLES'
    And  On the Dashboard page - I validate the main menu items are correct for the user
    And  On the Dashboard page - I validate the Settings dropdown options are correct for the user
    And  On the Dashboard page - I validate the footer items are correct for the user
    Then I log out

  Scenario: [login_each_user.feature] Check that BUYER_ADMIN can login, validate menu options
    Given I log into Commerce Network as 'BUYER_ADMIN'
    And  On the Dashboard page - I validate the main menu items are correct for the user
    And  On the Dashboard page - I validate the Settings dropdown options are correct for the user
    And  On the Dashboard page - I validate the footer items are correct for the user
    Then I log out

  Scenario: [login_each_user.feature] Check that BUYER_ADMIN_NONDESTRUCTIVE can login, validate menu options
    Given I log into Commerce Network as 'BUYER_ADMIN_NONDESTRUCTIVE'
    And  On the Dashboard page - I validate the main menu items are correct for the user
    And  On the Dashboard page - I validate the Settings dropdown options are correct for the user
    And  On the Dashboard page - I validate the footer items are correct for the user
    Then I log out

  Scenario: [login_each_user.feature] Check that SUPPLIER_ADMIN can login, validate menu options
    Given I log into Commerce Network as 'SUPPLIER_ADMIN'
    And  On the Dashboard page - I validate the main menu items are correct for the user
    And  On the Dashboard page - I validate the Settings dropdown options are correct for the user
    And  On the Dashboard page - I validate the footer items are correct for the user
    Then I log out

  Scenario: [login_each_user.feature] Check that SUPPLIER_ADMIN_NONDESTRUCTIVE can login, validate menu options
    Given I log into Commerce Network as 'SUPPLIER_ADMIN_NONDESTRUCTIVE'
    And  On the Dashboard page - I validate the main menu items are correct for the user
    And  On the Dashboard page - I validate the Settings dropdown options are correct for the user
    And  On the Dashboard page - I validate the footer items are correct for the user
    Then I log out

