Feature: Flight Search

  Scenario: Verify user can search flight
    Given user opens application
    Then verify user is on home screen
    When user click on flight tab
    Then verify user is on flight search page
    When user enters "from.city" into flying from
    And user enters "to.city" into flying to
    And select date from "from.date" to "to.date"
    And click on search button
    Then verify flight listing page is displayed
