Feature: Login to DemoBlaze Application

  Background:
    Given the user is on the Home Page

  @ValidCredentials
  Scenario: Login with valid credentials

    When the user clicks on login link
    And the user enters username as "<username>"
    And the user enters password as "<password>"
    And the user clicks on the login button
    Then the user should be logged in successfully
    
    Examples:
|username   |password  |
|KiotAdmin  |Kiot@123  |