Feature: Login

  Background:
    Given the user is on the login page

  Scenario: Login with valid credentials
    When the user enters valid credentials
    Then the user should be able to login

  Scenario: Login with invalid credentials
    When the user enters invalid credentials
    Then the user should get a warning

  Scenario: Login with empty credentials
    When the user enters empty credentials
    Then the user should get a warning