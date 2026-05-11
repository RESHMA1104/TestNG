Feature: Login functionality for HRM Application

  @ValidLogin
  Scenario Outline: Login with valid credentials
    Given User is on the HRMLogin page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When User enters username and password
    Then User should be able to login successfully and should see Dashboard
