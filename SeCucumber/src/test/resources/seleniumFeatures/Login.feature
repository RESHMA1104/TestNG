Feature : Login to HRM Application

@ValidCredentials
Scenario : Login with valid credentials

Given user is on the Home Page
When user enters "username" as "Admin"
When user enters "password" as "admin123"
Then user should be able to login successfully. 