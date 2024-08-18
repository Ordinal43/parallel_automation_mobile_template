Feature: Example

  Scenario: Simple login
    Given I am at login page
    When I log in using "USER_1" account
    Then I successfully login