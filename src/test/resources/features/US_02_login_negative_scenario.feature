@regression
Feature: As a user, I should not be able to log in.


  Scenario Outline: Verify user login fail with invalid credentials
    Given user on the login page
    When user enters username "<username>" and password "<password>"
    And user click the login button
    Then verify "<message>" message should be displayed
    Examples:
      | username | password    | message                     |
      | User9    | Wrong       | Wrong username or password. |
      | Wrong    | Userpass123 | Wrong username or password. |