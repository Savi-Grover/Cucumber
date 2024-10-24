#driver cannot complete OTP verification with wrong OTP
#driver enters less than 6-digit OTP during verification
#
Feature: Verify new driver cannot complete OTP verification with wrong OTP

  @wrongOTPduring_verification
  Scenario Outline: New driver enters wrong OTP during verification
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And the new driver is on the OTP verification page
    When the new driver enters a wrong OTP code
    Then an error message should be displayed indicating the OTP is incorrect
    And the new driver should not be able to complete the verification process

    Examples: 
      | firstname | lastname | email                       | phonenumber | zipcode |
      | paula     | chang    | testmail19SD001@yopmail.com |  1234567891 |   90016 |

  @6-digit_OTPduringverification
  Scenario Outline: New driver enters less than 6-digit OTP during verification
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And the new driver is on the OTP verification page
    When the new driver enters an OTP code with less than six digits
    Then an error message should be displayed indicating the OTP is invalid
    And the new driver should not be able to complete the verification process

    Examples: 
      | firstname | lastname | email                       | phonenumber | zipcode |
      | paula     | chang    | testmail19SD001@yopmail.com |  1234567891 |   90016 |
      
      

  @OTPverification_Timeexceeds
  Scenario Outline: Verify new driver cannot complete OTP verification if time exceeds more than 5 min
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And user lands on OTP Page and not entered OTP, timer exceeds
    When user enters old OTP
    Then user cannot complete OTP screen Successfully

    Examples: 
      | firstname | lastname | email                       | phonenumber | zipcode |
      | paula     | chang    | testmail19SD001@yopmail.com |  1234567891 |   90016 |

  @ResetTimer_afterclicking_RESENDBtn
  Scenario Outline: Verify new driver can see reset timer after clicking RESEND
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And the new driver is on the OTP verification page
    When user clicks on Resend button
    Then user can see timer reset Successfully

    Examples: 
      | firstname | lastname | email                       | phonenumber | zipcode |
      | paula     | chang    | testmail19SD001@yopmail.com |  1234567891 |   90016 |
