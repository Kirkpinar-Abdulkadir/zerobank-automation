@smoke
Feature: Navigating to specific accounts in Accounts Activity

  Scenario: Savings account redirect
    Given the user is logged in
    When the user clicks on "Savings" link on the Account Summary page
    Then as page title "Zero - Account Activity" should be displayed
    And account dropdown default should be "Savings"
  Scenario: Brokerage account redirect
    Given the user is logged in
    When the user clicks on "Brokerage" link on the Account Summary page
    Then as page title "Zero - Account Activity" should be displayed
    And account dropdown default should be "Brokerage"
  Scenario: Checking account redirect
    Given the user is logged in
    When the user clicks on "Checking" link on the Account Summary page
    Then as page title "Zero - Account Activity" should be displayed
    And account dropdown default should be "Checking"
  Scenario: Credit Card account redirect
    Given the user is logged in
    When the user clicks on "Credit card" link on the Account Summary page
    Then as page title "Zero - Account Activity" should be displayed
    And account dropdown default should be "Credit Card"
  Scenario: Loan account redirect
    Given the user is logged in
    When the user clicks on "Loan" link on the Account Summary page
    Then as page title "Zero - Account Activity" should be displayed
    And account dropdown default should be "Loan"