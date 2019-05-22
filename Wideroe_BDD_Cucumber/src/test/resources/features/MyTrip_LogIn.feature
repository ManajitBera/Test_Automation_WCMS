Feature: My trip login page. As a registered user I want to login to My Trip and see the details
  
 @MyTripLogIn	
  Scenario Outline: To successfully login to My Trip as a registered user
 	Given As a user, I am on the My Trip login page
  	When I enter user name "<UserEmailId>" and password "<Password>"
  	And Click on login button
  	Then I should redirect to Trip Details Page
  	Then I should close the browser
   	
   	Examples:
  
	  |  UserEmailId  |  Password    |
	   |   wideroe.test.smart16@gmail.com | Wideroe@123   |
	   |   wideroe.test.smart16@gmail.com | Wideroe@123   |

	
	