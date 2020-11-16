Feature: The API returns relevant data
  Background:
    Given the city bikes endpoint

  Scenario:
    Then I verify that the city of "Frankfurt" is in the country "Germany"
    And their their corresponding latitude and longitude coordinates are returned

  Scenario:
    Then I verify that the city of "London" is in the country "United Kingdom"
    And their their corresponding latitude and longitude coordinates are returned

