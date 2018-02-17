Feature: IGA website functional test
  @IGA
  Scenario: Checking login page is available
    Given IGA home page
    When I click My account
    Then the login page is up
