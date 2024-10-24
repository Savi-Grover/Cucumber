#Restart Membership - Inactive Customer Select Pricing Tier
#Waitlist new Driver -New Driver signup in to the FordDrive.com
#Driver able to return using JOIN NOW button with passwd. ( JOIN NOW --> fill details in partial page )
#Driver able to return using JOIN NOW-SIGNIN button
@waitlistfeature
Feature: wait_list feature

  @Creating_pendingpickup
  Scenario Outline: verify driver should lands on the pickup pending dashboard page
  #  Given User clicks on login with Uber
   # And Signin with vaild uber account and password "<Uberemail>","<UberPassword>"
   # And select Ford drive image
   # When User clicks on get started
    Then ford drive launch partial profile
    And that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with otp functionality successfully
    And the new driver selects the "<packagename>"
    And provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    And provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    When new driver sets the password and submit it
    Then new driver lands on the dashboard page
	
    @new_waitlistflow_SanDiego
    Examples: 
      | firstname | lastname | email                | phonenumber | zipcode | packagename | DLnumber | month | Address           | city           | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year | Uberemail                               | UberPassword |
      | janice    | bray     | testmail64@ford.com  |  1234567891 |   92020 |         309 |      123 |    05 | 3200 GLENDALE AVE | TOLEDO         | OH   |   66621 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+lettilbirch@uber.com  | Ford123!     |
      #| paula     | chang    | testmailSWT@ford.com |  1234567890 |   92020 |         309 |      123 |    05 | 5321 ESSEX CT     | ALEXANDRIA     | VA   |   66625 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+paulachang@uber.com   | Ford123!     |
      #| shirley   | brown    | testmail001@ford.com |  1234567891 |   92020 |         259 |      123 |    05 | 19413 LOMOND BLVD | SHAKER HEIGHTS | OH   |   66612 |  4000 0000 0000 0341 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+shirleybrown@uber.com | Ford123!     |

    #| lettil    | birch    | testmail020@ford.com |  1234567891 |   92020 |         369 |      123 |    05 | 1419 N 3RD ST     | CLINTON        | IA   |   66639 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+lettilbirch@uber.com  | Ford123!     |
    #| janice    | bray     | testmail64@ford.com  |  1234567891 |   92020 |         369 |      123 |    05 | 3200 GLENDALE AVE | TOLEDO         | OH   |   66621 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+lettilbirch@uber.com  | Ford123!     |
    #| lettil    | birch    | testmail020@ford.com |  1234567891 |   92020 |         369 |      123 |    05 | 1419 N 3RD ST     | CLINTON        | IA   |   66639 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+lettilbirch@uber.com  | Ford123!     |
    @new_waitlistflow_SanFrancisco
    Examples: 
      | firstname | lastname | email                | phonenumber | zipcode | packagename | DLnumber | month | Address       | city    | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year | Uberemail                              | UberPassword |
      | lettil    | birch    | testmail020@ford.com |  1234567891 |   95131 |         269 |      123 |    05 | 1419 N 3RD ST | CLINTON | IA   |   66639 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+lettilbirch@uber.com | Ford123!     |

    #| paula     | chang    | testmail555@ford.com |  1234567895 |   94121 |         319 |      123 |    05 | 5321 ESSEX CT | ALEXANDRIA | VA   |   66625 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+paulachang@uber.com  | Ford123!     |
    @new_waitlistflow_ManhattanBeach
    Examples: 
      | firstname | lastname | email                | phonenumber | zipcode | packagename | DLnumber | month | Address           | city           | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year | Uberemail                               | UberPassword |
      | shirley   | brown    | testmail001@ford.com |  1234567891 |   90011 |         309 |      123 |    05 | 19413 LOMOND BLVD | SHAKER HEIGHTS | OH   |   66612 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+shirleybrown@uber.com | Ford123!     |
      | paula     | chang    | testmail006@ford.com |  1234567899 |   90014 |         259 |      123 |    05 | 5321 ESSEX CT     | ALEXANDRIA     | VA   |   66625 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+paulachang@uber.com   | Ford123!     |

  @creating_pendingpickup_usingSSN
  Scenario Outline: Verify new driver register using SSN Value successfully
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with otp functionality successfully
    And the new driver selects the "<packagename>"
    And provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When the name or address does not match with experian SSN verification is required "<SSN Number>"
    Then driver provides the credit card information "<cardno>","<expdate>","<cvvno>","<zipcode>"
    When new driver sets the password and submit it
    Then new driver lands on the dashboard page

    Examples: 
      | firstname | lastname | email                   | phonenumber | zipcode | packagename | DLnumber | month | Address      | city   | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year | SSN Number |
      | janice    | bray     | testmailSSN019@ford.com |  1234567891 |   94552 |         269 |      123 |    05 | GLENDALE AVE | TOLEDO | OH   |   66621 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 |  666212622 |

  @SSN_experianCheck
  Scenario Outline: verify error screen is displayed experian check is failed
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with otp functionality successfully
    And the new driver selects the "<packagename>"
    And provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When the name or address are not match with experian SSN verification is required "<SSN Number>"
    Then checkout error screen is displayed experian check is failed

    Examples: 
      | firstname | lastname | email                   | phonenumber | zipcode | packagename | DLnumber | month | Address          | city   | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year | SSN Number |
      #| janice    | bray     | testmailSSN019@ford.com |  1234567891 |   94552 |         299 |      123 |    05 | GLENDALE AVE     | TOLEDO | OH   |   66621 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 |  666212622 |
      | MICHAEL   | MAHER    | testmailSSN006@ford.com |  1234567898 |   90014 |         349 |      123 |    05 | 4027 HILLVIEW RD | TEMPLE | PA   |   09721 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 |  666487275 |

  @switchingnewtier_onpickuppending_dashboard
  Scenario Outline: verify driver should switch new tier on the pickup pending dashboard page
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with otp functionality successfully
    And the new driver selects the "<packagename>"
    And provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    And provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    When new driver sets the password and submit it
    Then new driver lands on the dashboard page
    And driver clicks the Lease Package section in the Profile section.
    And change the required "<PackageName>"
    When driver Confirms the package name
    Then the package is changed successfull "<SuccessMessage>"

    Examples: 
      | firstname | lastname | email                  | phonenumber | zipcode | packagename | DLnumber | month | Address       | city       | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year | PackageName | SuccessMessage |
      | paula     | chang    | testmailSWT01@ford.com |  1234567891 |   92020 |         259 |      123 |    05 | 5321 ESSEX CT | ALEXANDRIA | VA   |   66625 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 |           309 | $309.00/wk      |

  #user should provides closed account email  to signin (Return process completed)
  #Restart Membership - Inactive Customer Select Pricing Tier
  @RestartMembership
  Scenario Outline: verfiy the Restart Membership
    Given user login with closed account to signin "<email>"
    And click on restart membership on dashboard
    And select the packages from the package selection page "<packagename>"
    And user complete the application approval page "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When user enter credit card details and the password information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    Then Reservation will be created sucessfully.

    Examples: 
      | firstname | lastname | phonenumber | zipcode | packagename | DLnumber | month | Address       | city    | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year | email             | password |
      #| DAVID     | Lange    |  1234567891 |   92020 |         309 |      123 |    05 | 1433 MARCONI RD | WALL TOWNSHIP | NJ   |   93825 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | david_testmail003@yopmail.com | Ford123! |
      | janice    | BOCOLOR  |  1234567891 |   92020 |         309 |      123 |    05 | 1423 WELSH RD | READING | PA   |   92109 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | oco22@yopmail.com | Ford123! |

  #Driver return using JOIN NOW button with passwd. ( JOIN NOW --> fill details in partial page )
  @Verifydriver_returnwithpassword_usingJoinNowBTN
  Scenario Outline: verify driver should return using JOIN NOW button with passwd on the pickup pending dashboard page
    Given User clicks on login with Uber
    And Signin with vaild uber account and password "<Uberemail>","<UberPassword>"
    And select Ford drive image
    When User clicks on get started
    Then ford drive launch partial profile
    And that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with otp functionality successfully
    And the new driver selects the "<packagename>"
    And provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    And provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    When new driver sets the password and submit it
    Then new driver lands on the dashboard page

    Examples: 
      | firstname | lastname | email                | phonenumber | zipcode | packagename | DLnumber | month | Address           | city           | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year | Uberemail                               | UberPassword |
      # | shirley   | brown    | testmail001@ford.com |  1234567891 |   92020 |         309 |      123 |    05 | 19413 LOMOND BLVD | SHAKER HEIGHTS | OH   |   66612 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+shirleybrown@uber.com | Ford123!     |
      | paula     | chang    | testmailSWT@ford.com |  1234567890 |   92020 |         259 |      123 |    05 | 5321 ESSEX CT     | ALEXANDRIA     | VA   |   66625 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+paulachang@uber.com   | Ford123!     |

  #Driver able to return using JOIN NOW button without passwd ( JOIN NOW--> fill details in partial page )
  @Verifydriver_returnwithoutpassword_usingJoinNowBTN
  Scenario Outline: verify driver should return using JOIN NOW button without passwd on the pickup pending dashboard page
    Given User clicks on login with Uber
    And Signin with vaild uber account and password "<Uberemail>","<UberPassword>"
    And select Ford drive image
    When User clicks on get started
    Then ford drive launch partial profile
    And that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with otp functionality successfully
    And the new driver selects the "<packagename>"
    And provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    And provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    And do not set password and submit it

    #Then new driver lands on the dashboard page
    Examples: 
      | firstname | lastname | email                | phonenumber | zipcode | packagename | DLnumber | month | Address           | city           | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year | Uberemail                               | UberPassword |
      # | shirley   | brown    | testmail001@ford.com |  1234567891 |   90011 |         309 |      123 |    05 | 19413 LOMOND BLVD | SHAKER HEIGHTS | OH   |   66612 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+shirleybrown@uber.com | Ford123!     |
      | paula     | chang    | testmail006@ford.com |  1234567899 |   90014 |         259 |      123 |    05 | 5321 ESSEX CT     | ALEXANDRIA     | VA   |   66625 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+paulachang@uber.com   | Ford123!     |

  #Driver able to return using JOIN NOW-SIGNIN button - With Password
  @Verifydriver_returnwithpassword_withSIGNINbutton
  Scenario Outline: verify driver should return using JOIN NOW-SIGNIN button with passwd on the pickup pending dashboard page
    Given User clicks on login with Uber
    And Signin with vaild uber account and password "<Uberemail>","<UberPassword>"
    And select Ford drive image
    When User clicks on get started
    Then Partial signup page will get displayed
    And click on Signin link below the Partial profile page
    And user lands on signin homepage
    When user enter email and password "<useremail>" , "<password>"
    Then user login into the dashboard succesfully

    Examples: 
      | useremail               | password | Uberemail                               | UberPassword |
      | testmailSLT@yopmail.com | Ford123! | andrew.brown+test+shirleybrown@uber.com | Ford123!     |
      | testmailSLT@yopmail.com | Ford123! | andrew.brown+test+shirleybrown@uber.com | Ford123!     |

  #Driver able to return using JOIN NOW-SIGNIN button -Without Password
  @Verifydriver_returnwithOutpassword_withSIGNINbutton
  Scenario Outline: verify driver should return using JOIN NOW-SIGNIN button without passwd on the pickup pending dashboard page
    Given User clicks on login with Uber
    And Signin with vaild uber account and password "<Uberemail>","<UberPassword>"
    And select Ford drive image
    When User clicks on get started
    Then Partial signup page will get displayed
    And click on Signin link below the Partial profile page
    And user lands on signin homepage
    When user enter email and password "<useremail>" , "<password>"
    Then user login into the OTP verification page successfully

    Examples: 
      | useremail                   | password | Uberemail                               | UberPassword |
      | testmailWPWD001@yopmail.com | Ford123! | andrew.brown+test+shirleybrown@uber.com | Ford123!     |
