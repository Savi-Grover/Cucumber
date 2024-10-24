@api
Feature: REST API Test cases
 This feature file contains scenarios that test REST API's

  Scenario: To verify if user can fetch a particular record
    Given A record exists in page 2 with id 9   
    When I fetch this record  
    Then I should get the status code as 200
    And body should have data.id value as 9
    
    Scenario: To add a new user record
    Given I have access to create new record
     | morpheus 	 	| TeamLeader		| 
    When I add a user record   
    Then I should get the status code as 201  