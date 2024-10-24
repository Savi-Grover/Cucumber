Feature: Verify Create Password Button Functionality in Congrats Page

  @CreatePasswordDisabled
  Scenario Outline: Verify create password button is disabled when password and confirm password do not match
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with otp functionality successfully
    And the new driver selects the "<packagename>"
    And provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    And provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    And new driver sets the password "<password>"
    And new driver sets different confirm password "<confirm password>"
    Then Create password button should be disabled until password and confirm password match

    Examples: 
      | firstname | lastname | email               | phonenumber | zipcode | packagename | DLnumber | month | Address           | city   | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year | Uberemail                              | UberPassword | password | confirm password |
      | janice    | bray     | testmail64@ford.com |  1234567891 |   92020 |         259 |      123 |    05 | 3200 GLENDALE AVE | TOLEDO | OH   |   66621 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+lettilbirch@uber.com | Ford123!     | Ford123! | Ford12345!       |

  @confirmpassword_notentered
  Scenario Outline: Verify create password button is disabled when password and confirm password does not entered
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with otp functionality successfully
    And the new driver selects the "<packagename>"
    And provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    And provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    And new driver sets the password "<password>"
    And new driver not set password in confirm password "<confirm password>"
    Then Create password button should be disabled until password and confirm password match

    Examples: 
      | firstname | lastname | email               | phonenumber | zipcode | packagename | DLnumber | month | Address           | city   | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year | Uberemail                              | UberPassword | password | confirm password |
      #| lettil    | birch    | testmail02@ford.com |  1234567892 |   92020 |         259 |      123 |    05 | 1419 N 3RD ST | CLINTON | IA   |   66639 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+lettilbirch@uber.com | Ford123!     | Ford123! |                  |
      | janice    | bray     | testmail64@ford.com |  1234567891 |   92020 |         259 |      123 |    05 | 3200 GLENDALE AVE | TOLEDO | OH   |   66621 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+lettilbirch@uber.com | Ford123!     | Ford123! |                  |

  @password_notentered
  Scenario Outline: Verify create password button is disabled when password not entered and confirm password entered in Congrats page
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with otp functionality successfully
    And the new driver selects the "<packagename>"
    And provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    And provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    And new driver not sets the password "<password>"
    And new driver not set password in confirm password "<confirm password>"
    Then Create password button should be disabled until password and confirm password match

    Examples: 
      | firstname | lastname | email               | phonenumber | zipcode | packagename | DLnumber | month | Address           | city   | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year | Uberemail                              | UberPassword | password | confirm password |
      | janice    | bray     | testmail64@ford.com |  1234567893 |   92020 |         259 |      123 |    05 | 3200 GLENDALE AVE | TOLEDO | OH   |   66621 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+lettilbirch@uber.com | Ford123!     |          | Ford123!         |
