Feature: Login Functionality

  Scenario Outline: Login attempt with different credentials
    Given the user is on the login page
    When the user enters "<email>" and "<password>"
    Then "<message>" should be displayed

    Examples:
      | email              | password     | message                 |
      | qa@julesai.com     | QaJULES2023! | redirected to dashboard |
      | invalid@example.com | wrongPass   | error message displayed |
      |                   |               | validation message      |
