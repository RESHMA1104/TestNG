Feature: Example of DataTable Without Header
 
 @validCredentials
 Scenario: Login with valid Credentials - Data Table Without header
 
 Given the user is launch the application
 When the user clicks on the login link
 When user enters valid credentials
 | KiotAdmin | Kiot@123|
 And the user clicks on the login button once credentials are entered
 Then the user should receives the message as logged in Successfully