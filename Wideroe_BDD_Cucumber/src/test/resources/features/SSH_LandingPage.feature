#Feature: SSH Landing Page feature 
  #
  #As a guest I want to be shown the primary passengers name 
  #along with booking reference and itinerary information. 
  #I should be able to add meal and SSRs for the segments
 #
#
  #@Meal
  #Scenario Outline: 
    #Given As a passenger,I am on the PNR lookUp page
  #	When I enter "<LastName>" and "<PNR>"
  #	And Click on submit button
  #	Then I navigate to SSH Landing Page
  #	And Passenger details will be displayed
    #And Passenger will be allowed to select "<Meals>" and "<SSRs>"
  #	
  #	
  #Examples:
  #
  #| LastName   | PNR     | Meals   | SSRs |
  #| Patel      | CMOGOA  | VGML    | WHCR |
  #
  #
  #@selfServiceOption
  #Scenario Outline: To check self servicing options are available for a booking
  #
    #Given As a passenger,I am on the PNR lookUp page
  #	When I enter "<LastName>" and "<PNR>"
  #	And Click on submit button
  #	Then I navigate to SSH Landing Page
  #	And Should be able to see self servicing options "<Available>"
  #	
  #	Examples: 
  #	
  #	|LastName   |  PNR    | Available |
  #	| Alam      |  KJPKWK | Yes       |
  #	
  #	
  #@BlockSeats
  #Scenario Outline: To Check seats are blocked and block seat pop appears for seat blocked bookings
  #
  #	Given As a passenger,I am on the PNR lookUp page
  #	When I enter "<LastName>" and "<PNR>"
  #	And Click on submit button
  #	Then I navigate to SSH Landing Page
  #	And Check seats are blocked 
  #	
  #	
  #	Examples:
  #	
  #	| LastName   | PNR    | 
  #	| Roy        | RFJGKR | 
  #	| Karthik    | VETCGR |
  #	| Banner     | SFRXKN |
  #	| Banner     | VDLELW |
  #	| Moraes     | ANKFSW |
  #	| Test       | NZJGVP |
  #	
  #	
  #	@370
  #	Scenario Outline: To prevent cancellation for the flight depending on the business rules
  #	
  #	Given As a passenger,I am on the PNR lookUp page
  #	When I enter "<LastName>" and "<PNR>"
  #	And Click on submit button
  #	Then I navigate to SSH Landing Page
  #	And Check if the cancel flight is blocked
  #	
  #	Examples: 
  #	| LastName   | PNR    |
  #	| EATING     | FCOFAO | 
  #	| BANNER     | YRHFMW |
  #	| Banner     | YDQLWB |
  #	| TEST       | ZQUBGU |
  #	| ROY        | ZIUIBU |
  #	| Roy        | 6072135104528 |
  #	| Patel      | CMOGOA |
  #	
  #@SSH-528	
  #Scenario Outline: 
  #
  #Given As a passenger,I am on the PNR lookUp page
  #When I enter "<LastName>" and "<PNR>"
  #And Click on submit button
  #Then I navigate to SSH Landing Page
  #And Check if addition of SSRs is blocked
  #	
  #Examples:
  #| LastName   | PNR    |
  #| Warne      | SVUDDA |
  #	
  #	 @BlockCheckIn	
  #Scenario Outline: CheckIn should option should not be displayed for certain specific cases 
  #
  #Given As a passenger,I am on the PNR lookUp page
  #When I enter "<LastName>" and "<PNR>"
  #And Click on submit button
  #Then I should redirect to SSH Landing Page
  #And Validate that CheckIn button should not be displayed
  #And A proper message should be displayed "<Message>"
  #And A specific message "<SpecificMessage>" should also be displayed
  #
 #
  #	
  #Examples:
  #| LastName   | PNR    | Message                     | SpecificMessage|
  #| BAELISH     | QSJADX |Online check-in unavailable|Bus/Rail segments message|
  #	
  #	
#
