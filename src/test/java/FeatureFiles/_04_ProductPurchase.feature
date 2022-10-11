Feature: Product Purchase

  Background:
    Given User is on Login Page
    And User filled the username and Password
    When User click the sign in button
    Then User should login

  Scenario: User can buy a product
    Given User clicked a product on HomePage
    And User selected a size
    And User selected a color
    And User clicked add to cart button
    And User navigated to checkout page
    When User completed checkout
    Then User should see thank you message


