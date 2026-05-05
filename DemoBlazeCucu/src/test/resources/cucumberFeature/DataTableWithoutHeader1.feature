Feature: Example of DataTable Without Header
 
 @validCredentials
 Scenario: Login with valid Credentials - Data Table Without header
 
 Given user is launch the application
 When the user clicks the login link
 When user enters the valid credentials
 | KiotAdmin | Kiot@123|
 | Kiot      | Kiot@123|
 And the user clicks on the login button when credentials are entered
 Then the user should see as logged in Successfully