@ridecell
Feature: Activation of Reservation Through Ridecell

  @ridecellActivation
  Scenario Outline: Reservation activation process
    Given User enter "<username>" and "<password>" in the ridecell login page
    And select the desired location from the dropdown "<CountryName>"
    And user search customer details with "<Email>" in Scheduled Rentals
    And User should see the record and assign vin to the reservations "<VinNo>"
    And VIN assigned successfully to the selected reservations
    And User open Lifecycle from Activity section and selects the desired location "<CountryName>"
    And User enter "<VinNo>" in the search and pull reservations details
    And Expand reservations using v icon in Actions column
    When all the Lifecycle steps status are changed to Completed for pending pickup and pickup schedule
    Then Reservation will get activated successfully in ridecell

    #And Driver able to see the reservations status as active in the dashboard
    Examples: 
      | username      | password    | VinNo             | CountryName | Email                   |
      | ST37@ford.com | Sangi@1234! | VRSD0000000000234 | San Diego   | testmailRSH@yopmail.com |

  #| ST37@ford.com | Sangi@1234! | VRSD0000000000204 | San Diego   | testmailJIE@yopmail.com |
  #| ST37@ford.com | Sangi@1234! | VRSD0000000000222 | San Diego   | testmailTWD@yopmail.com |
  #| ST37@ford.com | Sangi@1234! | VRLA0000000000300 | Manhattan Beach | testmailyux@yopmail.com |
  @ridecellPendingReturn
  Scenario Outline: Reservation return process
    Given User enter "<username>" and "<password>" in the ridecell login page
    And select the desired location from the dropdown "<CountryName>"
    And user search customer details with "<Email>" in Scheduled Rentals
    And User should see the record and assign vin to the reservations "<VinNo>"
    And VIN assigned successfully to the selected reservations
    And User open Lifecycle from Activity section and selects the desired location "<CountryName>"
    And User enter "<VinNo>" in the search and pull reservations details
    And Expand reservations using v icon in Actions column
    When all the Lifecycle steps status are changed to Completed for pending pickup and active
    Then Reservation status changed to pending return successfully
    And Driver able to see the reservations status as pending return in the dashboard

    Examples: 
      | username      | password    | VinNo             | CountryName | Email                   |
      | ST37@ford.com | Sangi@1234! | VRSD0000000000213 | San Diego   | testmailYET@yopmail.com |

  #| ST37@ford.com | Sangi@1234! | VRLA0000000000212 | Manhattan Beach | xvg69u8of5@yopmail.com |
  #| ST37@ford.com | Sangi@1234! | VRBA0000000000237 | San Francisco | testmailPLB@yopmail.com |
  @ridecellreturnprocess
  Scenario Outline: Reservation return process
    Given User enter "<username>" and "<password>" in the ridecell login page
    And select the desired location from the dropdown "<CountryName>"
    And user search customer details with "<Email>" in Scheduled Rentals
    And User should see the record and assign vin to the reservations "<VinNo>"
    And VIN assigned successfully to the selected reservations
    And User open Lifecycle from Activity section and selects the desired location "<CountryName>"
    And User enter "<VinNo>" in the search and pull reservations details
    And Expand reservations using v icon in Actions column
    When all the Lifecycle steps status are changed to Completed for pending pickup,active and pending return
    Then Reservation status changed to ended successfully
    And Driver able to see the reservations status as closed in the dashboard

    Examples: 
      | username      | password    | VinNo             | CountryName | Email                         |
      | ST37@ford.com | Sangi@1234! | VRSD0000000000336 | San Diego   | david_testmail003@yopmail.com |
      
      
      
      
      
