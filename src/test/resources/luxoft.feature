Feature: distance calculator tests
  Testing distance calculator on https://www.openstreetmap.org/
  Scenario: calculate the distance
    Given user launches Google Chrome browser and go to url
    When user click on the finding a distance button
    And enter From point
    And enter To point
    And in the transport option dropdown list select bicycle OSRM
    And click to Go button
    Then verify the distance and close a browser