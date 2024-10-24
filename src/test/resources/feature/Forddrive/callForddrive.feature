Feature: Verify Call Ford Drive functionality in Pickup pending status dashboard page

  @CallFordDrive_InPickupPendingdashboard
  Scenario Outline: Verify Call Customer Care functionality for Pickup Pending status
    Given user login with existing account to signin "<email>" and "<password>"
    And user lands on the dashboard page with Pickup Pending status
    And user clicks on the Schedule your pickup section dropdown Arrow
    When user clicks on the Call customer care option
    Then user should be able to contact Customer care successfully

    Examples: 
      | email                      | password |
      | testmailSAS008@yopmail.com | Ford123! |
