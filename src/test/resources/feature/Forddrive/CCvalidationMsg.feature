@CCvalidate_incorrectCCdetails
Feature: verify Validations messages on Credit card page in the profile page
  (Declined, Incorrect number, Insufficient fund card)

  @CCvalidate_throughProfilePage
  Scenario Outline: Verify validation message for a card with Declined funds in the profile page
    Given user Login to the Drivers Ford drive portal with vaild "<email>" and "<password>"
    And User navigate to Edit profile page "<CardName>"
    And Open the credit card page and click on add payment button
    And the user is on the Credit Card page provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    When the user enters a vaild creditcard number number
    Then the validation message should be displayed indicating the card added sucessfully

    Examples: 
      | email                   | password | CardName        | cardno              | expdate | cvvno | Zipcode |
      | testmailOKI@yopmail.com | Ford123! | Bank of America | 4111 1111 1111 1111 |    1125 |   111 |   11111 |

  #| testmail016SD@yopmail.com | Ford123! | HDFC  Bank | 4000 0000 0000 0000 |    1125 |   111 |   11111 |
  @declinedcreditcardDetail
  Scenario Outline: Verify validation message for a declined credit card
    Given user Login to the Drivers Ford drive portal with vaild "<email>" and "<password>"
    And User navigate to Edit profile page "<CardName>"
    And Open the credit card page and click on add payment button
    And the user in the Credit card page provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    When the user enters a Declined credit card number
    Then a validation message should be displayed indicating the card is Declined

    Examples: 
      | email                   | password | CardName        | cardno           | expdate | cvvno | Zipcode |
      | testmailEHD@yopmail.com | Ford123! | Bank of America | 4000000000000002 |    1125 |   111 |   11111 |

  @CCvalidate_RemoveProfilePage
  Scenario Outline: Verify validation message for a card with Declined funds in the profile page
    Given user Login to the Drivers Ford drive portal with vaild "<email>" and "<password>"
    And User navigate to Edit profile page
    And Open the credit card page and select the credit card
    When User clicks on remove payment method in edit payment page
    Then credit card should be removed succesfully

    Examples: 
      | email                  | password |
      | ERVDU8X9S1@yopmail.com | Ford123! |

  @incorrectcreditcardnumberdetail
  Scenario Outline: Verify validation message for a declined credit card
    Given user Login to the Drivers Ford drive portal with vaild "<email>" and "<password>"
    And User navigate to Edit profile page "<CardName>"
    And Open the credit card page and click on add payment button
    And the user in the Credit card page provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    When the user enters a Incorrect credit card number
    Then a validation message should be displayed indicating the card is Incorrect

    Examples: 
      | email                  | password | CardName   | cardno              | expdate | cvvno | Zipcode |
      | ERVDU8X9S1@yopmail.com | Ford123! | ICICI Bank | 4242 4242 4242 4241 |    1125 |   111 |   11111 |

  @expiredcreditcarddetail
  Scenario Outline: Verify validation message for a declined credit card
    Given user Login to the Drivers Ford drive portal with vaild "<email>" and "<password>"
    And User navigate to Edit profile page "<CardName>"
    And Open the credit card page and click on add payment button
    And the user in the Credit card page provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    When the user enters a expired creditcard number
    Then a validation message should be displayed indicating the card is expired creditcard

    Examples: 
      | email                  | password | CardName   | cardno              | expdate | cvvno | Zipcode |
      | ERVDU8X9S1@yopmail.com | Ford123! | ICICI Bank | 4000 0000 0000 0069 |    1125 |   111 |   11111 |

  #Adding new credit details using  exsisting account through signin process
  #Adding Nickname  - To verify the capability of the Driver to add his 'Nick name' to the payment method
  @AddingNickname_tothepaymentmethod
  Scenario Outline: Verify validation message for a card with Declined funds in the profile page
    Given user login with exsisting account to signin "<email>" and "<password>"
    And click on Profile section in the dashboard
    And click on Credit section
    And click on Add Credit card "<CardName>"
    And add Nickname in Text box and Select Primary Payment method checkbox
    And user enters Credit Card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    When user click on Add Payment Method
    Then the validation message should be displayed indicating the card added to the payment method sucessfully

    Examples: 
      | email                   | password | CardName                | cardno              | expdate | cvvno | Zipcode |
      | y5suh9gdeh@yopmail.com  | Ford123! | California Bank & Trust | 4111 1111 1111 1111 |    1125 |   111 |   11111 |
      | testmailSLT@yopmail.com | Ford123! | US Bank                 | 4000 0000 0000 0341 |    1128 |   111 |   11111 |
