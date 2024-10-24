Feature: Verify Bundle Insurance hyperlink

  @VerifyBundleInsurancehyperlink
  Scenario Outline: Bundle Insurance hyperlink should be displayed in Package Selection screen
    Given user is on the Package Selection screen "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    When user navigates to the Bundle Insurance section
    Then Bundle Insurance hyperlink is displayed

    Examples: 
      | firstname | lastname | email                      | phonenumber | zipcode |  
      | paula     | chang    | testmailbun001@yopmail.com |  1234567891 |   90016 |  
