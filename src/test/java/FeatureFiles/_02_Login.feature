Feature: Login Functionality
  Scenario: User should login
    Given User is on Login Page
    And User filled the username and Password
    When User click the sign in button
    Then User should login