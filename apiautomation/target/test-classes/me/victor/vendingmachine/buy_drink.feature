Feature: User successfully purchases a drink

  Background:
    Given A vending machine

  Scenario: Buying Coke
    When I insert a "quarter"
    And I select a drink of "Coke"
    Then I should get the drink
    And My balance should be 0
    And I should get change of 0

  Scenario: Buying Pepsi
    * I insert a "quarter"
    * I insert a "dime"
    And I select a drink of "Pepsi"
    Then I should get the drink
    And My balance should be 0
    And I should get change of 0

  Scenario: Buying Soda
    * I insert a "quarter"
    * I insert a "quarter"
    And I select a drink of "Soda"
    Then I should get the drink
    And My balance should be 5
    And I should get change of 5

  Scenario: Refund
    When I insert a "penny"
    Then My balance should be 1
    When I cancel the request
    Then I should get a refund of 1
    And My balance should be 0

  Scenario: Insufficient funds
    When I insert a "nickel"
    Then My balance should be 5
    When I select a drink of "Soda"
    Then My selection is refused
    And I should get a refund of 5
    And My balance should be 0
