@AllFooterLinks
Feature: Verify Footer Links on Webpages

  @verifyFooterLinks
  Scenario Outline: Verify Footer Links on OTP Page
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with otp functionality successfully
    When I navigate to the footer section
    Then I should see multiple footer links

    Examples: 
      | firstname | lastname | email                       | phonenumber | zipcode |
      | paula     | chang    | testmail19SD001@yopmail.com |  1234567891 |   90016 |

  @FAQLink
  Scenario Outline: Verify FAQ Footer Link Opens in the Same Web Page
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And Iam on the OTP Page
    When I click on the FAQ footer link
    Then the FAQ page should open in different tab

    Examples: 
      | firstname | lastname | email                       | phonenumber | zipcode |
      | paula     | chang    | testmail19SD001@yopmail.com |  1234567891 |   90016 |

  @CookiesSetting
  Scenario Outline: Verify Cookies Setting Link Opens in the Same Web Page
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And Iam on the OTP Page
    When I click on the cookies setting link
    Then the cookies setting options should be displayed within the same web page

    Examples: 
      | firstname | lastname | email                       | phonenumber | zipcode |
      | paula     | chang    | testmail19SD001@yopmail.com |  1234567891 |   90016 |

  @VerifyTermsandConditionsPage
  Scenario Outline: User navigates to the Terms and Conditions page
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And Iam on the OTP Page
    When the user clicks on the Terms and Conditions link
    Then the user should be redirected to the Terms and Conditions page

    Examples: 
      | firstname | lastname | email                       | phonenumber | zipcode |
      | paula     | chang    | testmail19SD001@yopmail.com |  1234567891 |   90016 |

  @VerifyVisitFord.com
  Scenario Outline: User navigates to the Visit Ford.com page
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And Iam on the OTP Page
    When the user clicks on the VisitFord.com link
    Then the user should be redirected to the Visit Ford.com page

    Examples: 
      | firstname | lastname | email                       | phonenumber | zipcode |
      | paula     | chang    | testmail19SD001@yopmail.com |  1234567891 |   90016 |

  @VerifyPrivacyNotice
  Scenario Outline: User navigates to the Privacy Notice page
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And Iam on the OTP Page
    When the user clicks on the Privacy Notice link
    Then the user should be redirected to the Privacy Notice page

    Examples: 
      | firstname | lastname | email                       | phonenumber | zipcode |
      | paula     | chang    | testmail19SD001@yopmail.com |  1234567891 |   90016 |

  @VerifyYourPrivacyChoices
  Scenario Outline: User clicks on "Your Privacy Choices" link
    Given that a new driver has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And Iam on the OTP Page
    When the user clicks on the Your Privacy Choices link
    Then the user should be directed to the privacy choices page

    Examples: 
      | firstname | lastname | email                       | phonenumber | zipcode |
      | paula     | chang    | testmail19SD001@yopmail.com |  1234567891 |   90016 |
