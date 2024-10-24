Feature: Verify log out functionality in Pick-Up Pending status

  @logout_InPick-UpPendingstatus
  Scenario Outline: Verify user can log out from the dashboard with Pickup Pending status
    Given user login with existing account to signin "<email>" and "<password>"
    And user lands on the dashboard page with Pickup Pending status
    When user selects the logout option on the dashboard
    Then user should be logged out successfully

    Examples: 
      | email                       | password |
      | testmail19SD003@yopmail.com | Ford123! |
