@ValidationsmessagesonCreditcardpage
Feature: Verify validation messages on the Credit card page

  @declinedcreditcard
  Scenario Outline: Verify validation message for a declined credit card
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with otp functionality successfully
    And the new driver selects the "<packagename>"
    And provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    And the user is on the Credit card page provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    When the user enters a declined credit card number
    Then a validation message should be displayed indicating the card is declined

    Examples: 
      | firstname | lastname | email               | phonenumber | zipcode | packagename | DLnumber | month | Address           | city       | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year |
      | janice    | bray     | testmail64@ford.com |  1234567891 |   92020 |         289 |      123 |    05 | 3200 GLENDALE AVE | TOLEDO     | OH   |   66621 | 4000 0000 0000 0002 |    1125 |   111 |   11111 |  05 | 1995 |
      | paula     | chang    | testmailSW@ford.com |  1234567890 |   92020 |         329 |      123 |    05 | 5321 ESSEX CT     | ALEXANDRIA | VA   |   66625 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 |

  @incorrectcreditcardnumber
  Scenario Outline: Verify validation message for an incorrect credit card number
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with otp functionality successfully
    And the new driver selects the "<packagename>"
    And provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    And the user is on the Credit card page provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    When the user enters an incorrect credit card number
    Then a validation message should be displayed indicating the card is incorrect

    Examples: 
      | firstname | lastname | email               | phonenumber | zipcode | packagename | DLnumber | month | Address           | city   | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year |
      | janice    | bray     | testmail64@ford.com |  1234567891 |   92020 |         289 |      123 |    05 | 3200 GLENDALE AVE | TOLEDO | OH   |   66621 | 4242 4242 4242 4241 |    1125 |   111 |   11111 |  05 | 1995 |

  @incorrectCVCnumber
  Scenario Outline: Verify validation message for an incorrect CVC number
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with otp functionality successfully
    And the new driver selects the "<packagename>"
    And provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    And the user is on the Credit card page provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    When the user enters an incorrect CVC number
    Then a validation message should be displayed indicating the card has incorrect CVC number

    Examples: 
      | firstname | lastname | email                  | phonenumber | zipcode | packagename | DLnumber | month | Address       | city       | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year |
      | paula     | chang    | testmailSWT01@ford.com |  1234567890 |   92020 |         329 |      123 |    05 | 5321 ESSEX CT | ALEXANDRIA | VA   |   66625 | 4000 0000 0000 0127 |    1125 |   111 |   11111 |  05 | 1995 |

  @expiredcreditcard
  Scenario Outline: Verify validation message for an expired credit card
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with otp functionality successfully
    And the new driver selects the "<packagename>"
    And provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    And the user is on the Credit card page provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    When the user enters an expired credit card
    Then a validation message should be displayed indicating the card is expired credit card

    Examples: 
      | firstname | lastname | email                  | phonenumber | zipcode | packagename | DLnumber | month | Address       | city       | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year |
      | paula     | chang    | testmailSWT01@ford.com |  1234567890 |   92020 |         329 |      123 |    05 | 5321 ESSEX CT | ALEXANDRIA | VA   |   66625 | 4000 0000 0000 0069 |    1125 |   111 |   11111 |  05 | 1995 |

  @enterdebitcardnumber
  Scenario Outline: Verify validation message for a debit card
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with otp functionality successfully
    And the new driver selects the "<packagename>"
    And provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    And the user is on the Credit card page provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    When the user enters the debit card number
    Then a validation message should be displayed indicating the card is debit card number

    Examples: 
      | firstname | lastname | email                  | phonenumber | zipcode | packagename | DLnumber | month | Address       | city       | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year |
      | paula     | chang    | testmailSWT01@ford.com |  1234567890 |   92020 |         329 |      123 |    05 | 5321 ESSEX CT | ALEXANDRIA | VA   |   66625 | 4000 0566 5566 5556 |    1125 |   111 |   11111 |  05 | 1995 |

  @enterinsufficientfunds
  Scenario Outline: Verify validation message for a card with insufficient funds
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with otp functionality successfully
    And the new driver selects the "<packagename>"
    And provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    And the user is on the Credit card page provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    When the user enters the insufficient funds card number
    Then a validation message should be displayed indicating the card is insufficient funds card number

    Examples: 
      | firstname | lastname | email                  | phonenumber | zipcode | packagename | DLnumber | month | Address       | city       | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year |
      | paula     | chang    | testmailSWT01@ford.com |  1234567890 |   92020 |         329 |      123 |    05 | 5321 ESSEX CT | ALEXANDRIA | VA   |   66625 | 4000 0000 0000 9995 |    1125 |   111 |   11111 |  05 | 1995 |

  @Incorrectnumberdecline
  Scenario Outline: Verify validation message for a card with Incorrect number decline
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with otp functionality successfully
    And the new driver selects the "<packagename>"
    And provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    And the user is on the Credit card page provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    When the user enters the Incorrectnumber card number
    Then a validation message should be displayed indicating the card is Incorrect number decline card number

    Examples: 
      | firstname | lastname | email                     | phonenumber | zipcode | packagename | DLnumber | month | Address       | city       | code | pincode | cardno         | expdate | cvvno | Zipcode | day | year |
      | paula     | chang    | testmailSWT01@yopmail.com |  1234567890 |   92020 |         329 |      123 |    05 | 5321 ESSEX CT | ALEXANDRIA | VA   |   66625 | 4242 4242 4242 |    1125 |   111 |   11111 |  05 | 1995 |
