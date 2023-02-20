@eurowings_automation
Feature: Eurowings Flight status Automation

  @flight_route_search_for_today_and_tomorrow
  Scenario: Verify the flight route form CGN to BER for today and Tomorrow
    Given I navigate to the test site
    When I enter "CGN" as a departure airport and "BER" as a destination airport
    And I select the today's Date
    And I select show flight status button
    Then I verify that flight routes are displayed
    When I select the tomorrow's date
    And I select show flight status button
    Then I verify that flight routes are displayed

  @flight_route_by_flight_number
  Scenario: Verify the flight route by flight number
    Given I navigate to the test site
    And I select flight number
    When I enter the flight number "EW18"
    And I select the today's Date for flight by number
    And I select show flight status button
    Then I verify that flight routes are displayed for flight by number
