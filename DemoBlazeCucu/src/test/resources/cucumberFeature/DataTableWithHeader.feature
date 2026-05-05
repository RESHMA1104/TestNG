Feature: Login with invalid data -data table with header and multiple data table  

Description:
        This feature is to implement the invalid data using multiple data table 

@Multiple_InvalidDataTable
Scenario: login with Invalid credentials using multiple data table 
      Given the user is on the home page and the user click the login link 
      Then user enter invalid data and login will unsuccessfull
     | username        | password | errormsg                              |
     | KiotAdmin       | Kiot     | Wrong password.                       |
     |                 | Kiot@123 | Please fill out Username and Password.|