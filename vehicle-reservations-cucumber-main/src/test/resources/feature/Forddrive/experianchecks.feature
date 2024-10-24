@experianrules
Feature: Verify experian check rules - Delinquent

  @verifyHappypath
  Scenario Outline: Verify Happypath
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When User enter valid experian details
    Then Congrats displayed successfully

    Examples:
      | firstname | lastname | email    | phonenumber | zipcode | packagename | DLnumber | month | Address         | city         | code | pincode | day | year | SSN Number |
      | DAVID     | LANGE    | testmail |  1234567890 |   95140 |         269 |      123 |    11 | 1433 MARCONI RD | WALLTOWNSHIP | NJ   |   20017 |  28 | 1921 |  666550938 |

  @verifyDelinquent
  Scenario Outline: Verify Delinquent error message is displayed when experian check failed
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When User enter invalid experian details
    Then delinquent Checkout error message should be displayed successfully

    Examples: 
      | firstname | lastname | email    | phonenumber | zipcode | packagename | DLnumber | month | Address       | city     | code | pincode | day | year |
      | NUNNA     | EMMONS   | testmail |  1234567890 |   95140 |         319 |      123 |    11 | 806 THAYER ST | ABINGTON | MA   |   02020 |  12 | 1955 |

  #| NUNNA     | EMMONS   | testmail |  1234567890 |   95140 |         269 |      123 |    11 | 806 THAYER ST | ABINGTON | MA   |   02020 |  12 | 1995 |
  #| NUNNA     | EMMONS   | testmail |  1234567890 |   95140 |         269 |      123 |    11 | 806 THAYER ST | ABINGTON | MA   |   02020 |  12 | 1960 |
  @verifyINQUIRIES
  Scenario Outline: Verify Inquiries error message is displayed when experian check failed
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When User enter invalid experian details
    Then INQUIRIES Checkout error message should be displayed successfully

    Examples: 
      | firstname | lastname | email    | phonenumber | zipcode | packagename | DLnumber | month | Address              | city           | code | pincode | day | year |
      | MERLENE   | BREWER   | testmail |  1234567890 |   95140 |         269 |      123 |    02 | 1107 XENIA AVE APT 1 | YELLOW SPRINGS | OH   |   45387 |  03 | 1972 |

  @verifyAutoloanhistory
  Scenario Outline: Verify Auto loan History error message is displayed when experian check failed
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When User enter invalid experian details
    Then Auto loan history Checkout error message should be displayed successfully

    Examples:
      | firstname | lastname | email    | phonenumber | zipcode | packagename | DLnumber | month | Address               | city  | code | pincode | day | year | SSN Number |
      | TRACY   | BIERLY | testmail |  1234567890 |   95140 |         269 |      123 |    12 | 18198 W BIG OAKS RD | WILDWOOD | IL   |   60030 |  12 | 1966 |  666113214 |

  @verifyBANKRUPTCIES
  Scenario Outline: Verify BANKRUPTCIES error message is displayed when Experian check failed
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When User enter invalid experian details
    Then BANKRUPTCIES Checkout error message should be displayed successfully

    Examples: 
      | firstname | lastname | email    | phonenumber | zipcode | packagename | DLnumber | month | Address       | city        | code | pincode | day | year |
      | SAMMIE    | gidlley  | testmail |  1234567890 |   95140 |         319 |      123 |    11 | 1364 CRANE ST | SCHENECTADY | GA   |   12303 |  27 | 1959 |

  @verifyCreditScorelow
  Scenario Outline: Verify Credit Score low error message is displayed when Experian check failed
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When User enter invalid experian details
    Then Credit Score low Checkout error message should be displayed successfully

    Examples:
      | firstname | lastname | email    | phonenumber | zipcode | packagename | DLnumber | month | Address              | city           | code | pincode | day | year |
      | MERLENE   | BREWER   | testmail |  1234567890 |   95140 |         269 |      123 |    02 | 1107 XENIA AVE APT 1 | YELLOW SPRINGS | OH   |   45387 |  03 | 1972 |

  @verifyFRAUDALERT16
  Scenario Outline: Verify FRAUD ALERT 16 error message is displayed when Experian check failed
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When the name or address does not match with experian SSN verification is required "<SSN Number>"
    When User enter invalid experian details
    Then FRAUD ALERT 16 Checkout error message should be displayed successfully

    Examples: 
      | firstname | lastname | email    | phonenumber | zipcode | packagename | DLnumber | month | Address        | city       | code | pincode | day | year | SSN Number |
      | BARBARA   | OTT      | testmail |  1234567890 |   90011 |         309 |      123 |    11 | 15607 ENNIS RD | SUGAR LAND | TX   |   77478 |  27 | 1955 |  666113214 |

  @verifyRepossesion
  Scenario Outline: Verify Repossesion error message is displayed when Experian check failed
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When User enter invalid experian details
    Then Repossesion, Auto Loan history Checkout error message should be displayed successfully

    Examples: 
      | firstname | lastname | email    | phonenumber | zipcode | packagename | DLnumber | month | Address               | city  | code | pincode | day | year | SSN Number |
      | JEFFRIE   | ROBINSON | testmail |  1234567890 |   95140 |         269 |      123 |    11 | 18200 WINDSOR HILL DR | ONLEY | MD   |   20832 |  27 | 1955 |  666113214 |

  @verifyOFAC
  Scenario Outline: Verify OFAC error message is displayed when Experian check failed
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When User enter invalid experian details
    Then OFAC Checkout error message should be displayed successfully

    Examples: 
      | firstname | lastname | email    | phonenumber | zipcode | packagename | DLnumber | month | Address             | city  | code | pincode | day | year | SSN Number |
      | MARIA     | GONZALEZ | testmail |  1234567890 |   95140 |         269 |      123 |    09 | 13520 BELLINGHAM DR | TAMPA | FL   |   33625 |  25 | 1954 |  666252876 |

  @verifyscoreusers_9000
  Scenario Outline: Verify score users error message is displayed when Experian check failed
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When User enter invalid experian details
    Then score users Checkout error message should be displayed successfully

    Examples: 
      | firstname | lastname | email    | phonenumber | zipcode | packagename | DLnumber | month | Address      | city       | code  | pincode | day | year |
      | GAYLE     | SMITH    | testmail |  1234567890 |   95140 |         269 |      123 |    04 | PO BOX 1054  | EAST HELENA | MT   |   59635 |  02 | 1940 |

  @verifyscoreusers_600to619
  Scenario Outline: Verify score users between 600to619  error message is displayed when Experian check failed
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When User enter invalid experian details
    Then score users600to619 Checkout error message should be displayed successfully

    Examples: 
      | firstname | lastname | email    | phonenumber | zipcode | packagename | DLnumber | month | Address         | city       | code | pincode | day | year | SSN Number |
      #| CHRISTOPHE | DELACRUZ | testmail |  1234567890 |   95140 |         269 |      123 |    11 | 1470 JEFFERSON ST APT 407 | DES PLAINES | IL   |   60016 |  28 | 1956 |  666389139 |
      | BRUNO     | WARD     | testmail |  1234567890 |   95140 |         269 |      123 |    11 | 4401 14TH ST NE | WASHINGTON | DC   |   20017 |  28 | 1956 |  666149472 |

  @verifyFrozenCredit
  Scenario Outline: Verify driver gets rejected when their credit profile is Frozen
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When User enter invalid experian details
    Then driver gets rejected when their credit profile is Frozen
    Examples:
      | firstname | lastname | email    | phonenumber | zipcode | packagename |      DLnumber      | month | Address       | city       | code | pincode | day | year | SSN Number |
      | Mock      | Mock     | testmail |  1234567890 |   95140 |         269 |      ABCD123456789 |    01 | Frozen Credit | Curtice    | OH   |   43412 |  01 | 1990 |  666389139 |


  @verifyFRAUDALERT23
  Scenario Outline: Verify FRAUD ALERT 23 error message is displayed when Experian check failed
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When User enter invalid experian details
    Then FRAUD ALERT 23 Checkout error message should be displayed successfully
    Examples:
      | firstname | lastname | email    | phonenumber | zipcode | packagename |     DLnumber       | month | Address        | city    | code | pincode | day | year | SSN Number |
      | Mock      | Mock     | testmail |  1234567890 |   95140 |         269 |      ABCD123456789 |    01 | Fraud Alert 23 | Curtice | OH   |   43412 |  01 | 1990 |  666389139 |


  @verifyFRAUDALERT33
  Scenario Outline: Verify FRAUD ALERT 33 error message is displayed when Experian check failed
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When User enter invalid experian details
    Then FRAUD ALERT 33 Checkout error message should be displayed successfully
    Examples:
      | firstname | lastname | email    | phonenumber | zipcode | packagename |      DLnumber      | month | Address        | city    | code | pincode | day | year | SSN Number |
      | Mock      | Mock     | testmail |  1234567890 |   95140 |         269 |      ABCD123456789 |    01 | Fraud Alert 33 | Curtice | OH   |   43412 |  01 | 1990 |  666389139 |

  @verifySKIPAUTOLOAN
  Scenario Outline: Verify Skip Auto loan error message is displayed when driver doesn't have Auto loan in Credit profile
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When User enter valid experian details
    Then Congrats displayed successfully
    Examples:
      | firstname | lastname | email    | phonenumber | zipcode | packagename |      DLnumber      | month | Address        | city    | code | pincode | day | year |
      | Mock      | Mock     | testmail |  1234567890 |   95140 |         269 |      ABCD123456789 |    01 | Skip Auto Loan | Curtice | OH   |   43412 |  01 | 1990 |

  @verifyFraudAlert6
  Scenario Outline: Verify Skip Auto loan error message is displayed when driver doesn't have Auto loan in Credit profile
    Given Sign up should be done in ford drive with this info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with an otp functionality successfully
    And Lease package "<packagename>" should be selected by user
    And user is on the Application approval page provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    When User enter valid experian details
    Then Congrats displayed successfully
    Examples:
      | firstname | lastname | email    | phonenumber | zipcode | packagename |      DLnumber      | month | Address        | city    | code | pincode | day | year |
      | Mock      | Mock     | testmail |  1234567890 |   95140 |         269 |      ABCD123456789 |    01 | Flagged Fraud | Curtice | OH   |   43412 |  01 | 1990 |

