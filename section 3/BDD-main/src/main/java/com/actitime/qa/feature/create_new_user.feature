Feature: As the admin I should be able to create a new user in Actitime

  @TC_002
  Scenario Outline: Successfully creating a new user
    Given User is logged in as an admin
    And User in the Actitime Users Page
    When User clicks on the new user button
    Then User Enters the First Name as  "<firstName>"
    Then User Enters the Last Name as  "<lastName>"
    Then User Enters the Email as  "<email>"
    Then User clicks the Save and Send Invitation button
    Then User clicks close button
    And User should be able to find the new users "<firstName>" "<lastName>" in the users list
    Examples:
      | firstName | lastName | email |
      | matheesha | mihiranga | matheeshamm@gmail.com |