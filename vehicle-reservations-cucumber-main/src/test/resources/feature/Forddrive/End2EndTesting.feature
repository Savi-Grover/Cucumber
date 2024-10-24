Feature: endToendtesting feature

  @EndToEndtesting
  Scenario Outline: 
    Given Users clicks on login with Uber
    And Signin with vaild uber account and password in the uber pagev "<Uberemail>","<UberPassword>"
    And Select the Ford drive image
    And User clicks on Get started button
    And Ford drive launch partial profile page
    And The new user has registered with his info "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And has been verified with OTP functionality successfully
    And The new driver selects the new package plan "<packagename>"
    And User provides info "<DLnumber>","<month>","<day>","<year>","<Address>","<city>","<code>","<pincode>"
    And User provides the credit card information "<cardno>","<expdate>","<cvvno>","<Zipcode>"
    When New driver sets the password and submit it
    And New driver lands on the dashboard page
    And Driver clicks on the Lease Package section in the Profile section.
    And Driver change the required "<leasePackName>"
    When Driver Confirms the package name
    Then The package plan is changed successfull
    When User enters "<username>" and "<password>" in the ridecell login page
    And Select the desired location from the dropdown "<CountryName>"
    And User search customer details with "<Email>" in Scheduled Rentals field
    And User should see the record and assign Vinno to the reservations "<VinNo>"
    And VIN no assigned successfully to the selected reservations
    And User open Lifecycle from Activity section and select the desired location "<CountryName>"
    And User enter "<VinNo>" in the search and pull all the reservations details
    And User Expand reservations using v icon in Actions column
    When All the Lifecycle steps status are changed to Completed for Pending pickup,Active and Pending return
    Then Reservation status should changed to ended successfully
    And Driver should able to see the reservations status as closed in the dashboard

    Examples: 
      | firstname | lastname | email               | phonenumber | zipcode | packagename | DLnumber | month | Address           | city   | code | pincode | cardno              | expdate | cvvno | Zipcode | day | year | Uberemail                              | UberPassword | leasePackName |  | username      | password    | VinNo             | CountryName     | Email                   |
      | janice    | bray     | testmail64@ford.com |  1234567891 |   90011 |         289 |      123 |    05 | 3200 GLENDALE AVE | TOLEDO | OH   |   66621 | 4111 1111 1111 1111 |    1125 |   111 |   11111 |  05 | 1995 | andrew.brown+test+lettilbirch@uber.com | Ford123!     |           329 |  | ST37@ford.com | Sangi@1234! | RIDECELLMB0000002 | Manhattan Beach | testmailVDZ@yopmail.com |

  @updatedEndToEndtesting
  Scenario Outline: New User - registers - selects package - switches new package - operators approve and assign vin - user utilises our car services- user returns car- after verification successfuly - user closes the package - upadated in dashboard as closed
    Given The new user has registered into the Forddrive.com application successfully with details such as "<firstname>","<lastname>","<email>","<phonenumber>","<zipcode>"
    And the new user changes the new package plan successfully "<selectpackagename>" ,"<changeleasePackName>"
    And In Ride Cell operators verify the customer details and assign Vin no to the customer "<CountryName>" , "<VinNo>"
    And the new customer picked up the vehicle and the status has changed to Active from pickup scheduled
    And after utilizing the car the customer informed the company and returned the car and the status changed to the pending return
    When the inspection of the returned car is completed
    Then the reservation status is set to close and the customer can view the status as closed in the dashboard

    Examples: 
      | firstname | lastname | phonenumber | zipcode | selectpackagename | changeleasePackName | VinNo             | CountryName |
      #| janice    | bray     |  1234567891 |   90014 |               309 |                 259 | VRSD0000000000285|Manhattan Beach   |
      | janice    | bray     |  1234567891 |   92020 |               309 |                 259 | VRSD0000000000285 | San Diego   |
