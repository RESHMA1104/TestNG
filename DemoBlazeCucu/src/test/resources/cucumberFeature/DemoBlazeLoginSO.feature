 Feature: Example of Scenario Outine
 
 @InvalidCredentials
 Scenario Outline: Login with Invalid Credentials
 
 Given the user is on Home Page
 When user clicks on login link
 When user enters username as "<username>" and password as "<password">
 And the user clicks on login button
 Then the error message should be displayed as "<errorMessage>"
 
 Examples:

 |username   |password   |errorMessage         |
 |Ad$$min    | admin1    |"User does not exist."|
 |KiotAdmin  | admin12   |"Wrong password."     |
 |           | admin12   |"Please fill out Username and Password."|