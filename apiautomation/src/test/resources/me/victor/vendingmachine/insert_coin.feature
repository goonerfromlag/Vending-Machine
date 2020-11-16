Feature: Vending machine accepts different coin types

  Background:
    Given A vending machine with a balance of 0

  Scenario Outline: Using different coins
    When I insert a "<coin>"
    Then My balance should be <amount>
    Examples:
      |coin   |amount|
      |penny  |1     |
      |nickel |5     |
      |dime   |10    |
      |quarter|25    |

