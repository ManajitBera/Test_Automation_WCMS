#Feature: PNR look up page feature 
  #As a guest i would like to retrieve the PNR using Last Name and
  #PNR or Eticket or EMD document
  #
 # Background: Navigate to PNR Lookup Page
  #
 #@PNR 
  #Scenario Outline: To successfully retreive a booking using last Name
  #					and PNR reference or Etkt or EMD document
  #					
  #	Given As a passenger,I am on the PNR lookUp page
  #	When I enter "<LastName>" and "<PNR>"
  #	And Click on submit button
  #	Then I navigate to SSH Landing Page
  #	
  #	
  #Examples:
  #
  #|  LastName  |  PNR    |
  #|  Sane      |  UWMLMK |
#
#
#
  #
  #
 #Scenario: To check field error validations 
  #
  #Given As a passenger,I am on the PNR lookUp page
  #When I enter blank lastName and blank PNR
  #Then Click on Submit button
  #And Error message should be displayed 
  #
  #Scenario Outline: To Check Field Error Validations for text boxes
  #
  #Given As a passenger,I am on the PNR lookUp page
  #When I enter "<LastName>" and "<PNR>"
  #Then Click on Submit button
  #And "<ErrorMessages>" should be displayed
  #
  #
#	Examples: 
#	
  #|  LastName  |  PNR           | ErrorMessages |
  #|  DOE       |  LDC!PM        | Please enter a valid email address, Ticket Number or Booking Reference Number to continue. |
  #|  TEST	     |  1234567891234 | Your Ticket Number should start with '607'. Please check and try again. |
  #|  DAVE      |  12@17280987AB | Please enter a valid email address, Ticket Number or Booking Reference Number to continue. |
  #|  KUMRAN    |  BWNTRI 				| Please contact us and we'll be happy to help you with your booking.[108] |
  #	
  #@Sprint5	
  #Scenario: To Check Language Picker in PNR Look up pages. 
  #
  #Given As a passenger,I am on the PNR lookUp page
  #When I check and click on Language Picker
  #Then Language picker modal displays regions map
 #
  #
  #
#
  #		
  #	
  #	
#		
#		
#		
#		
#		
#		
#		
