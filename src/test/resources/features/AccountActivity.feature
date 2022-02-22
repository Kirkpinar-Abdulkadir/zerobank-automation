@smoke
Feature: Account Activity Page

  Background:
    Given the user is on the login page
    And the user enters valid credentials
    When user navigates to "Account Activity"

  Scenario: Page Title Should Be Displayed
    Then as page title "Zero - Account Activity" should be displayed

  Scenario: Account dropdown
    Then account dropdown default should be "Savings"
    And dropdown should have following options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: Transaction table
    Then transaction table should have column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |