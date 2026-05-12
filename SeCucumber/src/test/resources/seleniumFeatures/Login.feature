Feature: Login to HRM Application

  Background:
    Given the user is launch the Home Page

  @ValidCredentials
  Scenario: Login with valid credentials

    Then user enters username as "<username>"
    And user enters password as "<password>"
    And user clicks on login button
    Then the user should be logged in to the application successfully
    
    Examples:
|username   |password  |
|Admin      |admin123  |