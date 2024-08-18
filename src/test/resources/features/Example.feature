Feature: Example

  Scenario: Simple login
    Given I am at login page
    When I log in using "USER_1" account
    Then I successfully login

  Scenario: Login with empty email
    Given I am at login page
    When I input empty email
    When I click submit login
    Then I get error login "Please enter a valid email address"

  Scenario: Login with empty password
    Given I am at login page
    When I input empty password
    When I click submit login
    Then I get error login "Please enter at least 8 characters"
