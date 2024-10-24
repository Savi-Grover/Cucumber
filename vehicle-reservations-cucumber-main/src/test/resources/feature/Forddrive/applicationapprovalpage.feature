@ApplicationApprovalPage/SoftCreditCheck

Feature: Validate invalid license number

  @Validateinvalidlicensenumber
  Scenario Outline: Verify error message is displayed when entering an invalid license number
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When user enters an invalid license number in the license field
    Then an error message should be displayed

    Examples: 
      | firstname | lastname | email                  | phonenumber | zipcode | packagename | DLnumber | month | Address           | city       | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year |
      | janice    | bray     | testmail64@ford.com    |  1234567891 |   92020 |         309 |       12 |    05 | 3200 GLENDALE AVE | TOLEDO     | OH   |   66621 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 |
      | paula     | chang    | testmailSWT01@ford.com |  1234567890 |   92128 |         259 |      123 |    05 | 5321 ESSEX CT     | ALEXANDRIA | VA   |   66625 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 |

  @ValidateDateofbirth
  Scenario Outline: Verify error message is displayed when entering an invalid date of birth
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When user enters an invalid date of birth
    Then an error message should be displayed successfully

    Examples: 
      | firstname | lastname | email                  | phonenumber | zipcode | packagename | DLnumber | month | Address       | city       | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year |
      | paula     | chang    | testmailSWT01@ford.com |  1234567890 |   92128 |         309 |      123 |    13 | 5321 ESSEX CT | ALEXANDRIA | VA   |   66625 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  35 | 2025 |

  @ValidateHomeaddress
  Scenario Outline: Verify error message is displayed when entering an invalid Home address
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When user enters an invalid  special characters in the home address
    Then An error message should be displayed

    Examples: 
      | firstname | lastname | email               | phonenumber | zipcode | packagename | DLnumber | month | Address        | city   | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year |
      | janice    | bray     | testmail64@ford.com |  1234567891 |   92020 |         309 |      123 |    05 | asdfgf@@!12345 | TOLEDO | OH   |   66621 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 |

  @Validatecheckbox
  Scenario Outline: Verify that the checkbox is required to proceed to the next step
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info in  "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When the user tries to proceed without selecting the checkbox
    Then the user should not be able to proceed to the next step

    Examples: 
      | firstname | lastname | email                  | phonenumber | zipcode | packagename | DLnumber | month | Address       | city       | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year |
      | paula     | chang    | testmailSWT01@ford.com |  1234567890 |   92128 |         309 |      123 |    05 | 5321 ESSEX CT | ALEXANDRIA | VA   |   66625 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 |
