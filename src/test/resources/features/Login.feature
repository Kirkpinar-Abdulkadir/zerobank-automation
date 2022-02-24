@smoke
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

  @wip
  Scenario Outline: Login with wrong or empty credentials
    When the user logs in with"<userName>" and "<passWord>"
    Then the user should get a warning

    Examples:
      | userName | passWord |
      | wrong    | password |
      | username | wrong    |
      | userName |          |
      |          | password |