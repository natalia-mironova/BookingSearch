Feature: Search of hotels using booking.com
  Scenario: Searching for Alfa Radon
    Given Hotel name is "Alfa Radon Health Resort"
    When User opens booking.com
    And Performs Search
    Then Hotel "Alfa Radon Health Resort" should be on the first page
    And has rating "9.2"