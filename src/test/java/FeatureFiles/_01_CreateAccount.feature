Feature: Create Account

  Scenario: User can create an account
    Given User is on Create Account Page
    And User filled the information
      | name            | Akhmet            |
      | lastName        | Mutlu           |
      | email           | akhmet@gmail.com |
      | password        | Ahmet1234       |
      | confirmPassword | Ahmet1234        |
    When User click the Create an Account Button
    Then Account should be created
