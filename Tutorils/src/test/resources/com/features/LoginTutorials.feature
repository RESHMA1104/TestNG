Feature: Register user in TutorialsNinja

@ValidRegister
Scenario: Register with valid user details - DataTable without header
  Given User is on TutorialsNinja Home page
  And User click on My Account Link
  And User click on Register button
  When User enters valid registration details
    | Reshma | K | Reshma123@gmail.com | 1234567890 | Reshma@11 | Reshma@11 |
  And User selects privacy policy checkbox
  And User clicks on continue button
  Then User account should be created successfully