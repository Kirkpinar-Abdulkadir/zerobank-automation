@smoke
Feature: Pay Bills Page

  Background:
    Given the user is on the login page
    And the user enters valid credentials
    When user navigates to "Pay Bills"

  Scenario: Page Title Should Be Displayed
    Then as page title "Zero - Pay Bills" should be displayed

  Scenario: Successful pay
    When user completes pay
    Then the user get message "The payment was successfully submitted."

  Scenario: Pay without amount
    When user try to complete pay without amount
    Then the user get alert "Please fill out this field."

  Scenario: Pay without date
    When user try to complete pay without date
    Then the user get alert "Please fill out this field." date

