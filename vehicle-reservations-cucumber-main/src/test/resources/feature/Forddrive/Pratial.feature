@Partial_signuppagevalidation
Feature: Validate fields on partial profile page.

  @Partial_signupwithinvaild
  Scenario Outline: Partial signuppage validation process
    Given create user accounts with invaild details as following "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    When User clicks on the Get Strated
    Then error should be displayed

    Examples: 
      | firstname   | lastname  | email                     | phonenumber | zipcode |
      | janice@!123 | bray123!@ | testmail##001@yopmail.com | 12345678910 |    9001 |

  @PartialProfilepagesignin
  Scenario: Partial signIn link validation process
    Given user click on signin link
    And user lands on signin page
    When user enter email and password
    Then user succesfully login

  @VerifyGetStartedButtonState
  Scenario Outline: Get Started button is disabled when partial profile page is not completed
    Given the user is on the Partial Profile page
    And the user has not completed all required fields "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    When the user views the Get Started button
    Then the Get Started button should be disabled

    Examples: 
      | firstname | lastname | email                      | phonenumber | zipcode |
      | paula     | chang    | testmailbtn002@yopmail.com |  1234567891 |         |

  @VerifyGetStartedButtonStateenabled
  Scenario Outline: Get Started button is enabled when partial profile page is completed
    Given the user is on the Partial Profile page
    And the user has completed all required fields "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    When the user views the Get Started button
    Then the Get Started button should be enabled

    Examples: 
      | firstname | lastname | email                   | phonenumber | zipcode |
      | paula     | chang    | testmail001@yopmail.com |  1234567891 |   90016 |

  @Validatenewdriverconsentcheckboxes
  Scenario Outline: Verify the new driver can enable consent checkboxes
    Given the new driver is on the consent checkbox page "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    When the new driver clicks on the I accept checkbox
    Then the checkbox should be checked
    And the new driver should be able to proceed to the next page

    Examples: 
      | firstname | lastname | email                   | phonenumber | zipcode |
      | paula     | chang    | testmail001@yopmail.com |  1234567891 |   90016 |

  @ValidationProfilepageGaragingZipcodes
  Scenario Outline: Verify OTP page should be displayed when user provided valid Zipcodes
    Given a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    When user Provided valid Garaging Zipcodes
    Then Package Selection should be displayed

    Examples: 
      | firstname | lastname | email                      | phonenumber | zipcode |
      | paula     | chang    | testmailZIP005@yopmail.com |  1234567891 |   90016 |

  @ValidateerrormessageforinvalidZipcodes
  Scenario Outline: Verify error message when user enters invalid Zipcode
    Given a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    When the user enters an invalid Zipcode
    Then an error message should be displayed indicating that the Zipcode is invalid

    Examples: 
      | firstname | lastname | email                      | phonenumber | zipcode |
      | paula     | chang    | testmailZIP005@yopmail.com |  1234567891 |   92074 |
