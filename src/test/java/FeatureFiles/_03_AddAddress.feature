Feature: Add Address

  Background:
    Given User is on Login Page
    And User filled the username and Password
    When User click the sign in button
    Then User should login

  Scenario Outline: User can add new address
    Given User is on My Account Page
    And User clicked Manage Addresses button
    And User clicked Add Address button
    And User filled the form
      | name        | <name>        |
      | lastName    | <lastName>    |
      | phoneNumber | <phoneNumber> |
      | address1    | <address1>    |
      | city        | <city>        |
      | state       | <state>       |
      | zipCode     | <zipCode>     |
    When User click Save Address button
    Then The address should be added
    Examples:
      | name   | lastName | phoneNumber | address1                   | city           | state      | zipCode |
      | Ahmet  | kayit    | 1234567890  | Merkez mah. Cikmaz sok.    | istanbul       | TURKIYE    | 88888   |
      | isim   | soyisim  | 4567891234  | Cicek mah. Cumhuriyet sok. | Ankara         | TURKIYE    | 33333   |
      | ad     | soyad    | 2223334455  | Palm Beach. No: 1          | Palm beach     | Florida    | 44455   |



