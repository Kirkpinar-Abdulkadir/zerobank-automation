@smoke
Feature: Account Summary Page

  Background:
    Given the user is on the login page
    And the user enters valid credentials

  Scenario: Page Title Should Be Displayed
    Then as page title "Zero - Account Summary" should be displayed

  Scenario: Account Types
    Then the user should see the following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: Credit Accounts Headers
    Then the user should see the following Credit Accounts headers
      | Account     |
      | Credit Card |
      | Balance     |
