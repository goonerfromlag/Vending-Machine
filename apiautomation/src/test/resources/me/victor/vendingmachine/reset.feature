Feature: Vending machine can be reset to a default state.

  Scenario: 
    Given A vending machine
    * I insert a "penny"
    * I insert a "dime"
    * I insert a "nickel"
    * I insert a "quarter"
    Then My balance should be 41
    When I reset the machine
    Then My balance should be 0
