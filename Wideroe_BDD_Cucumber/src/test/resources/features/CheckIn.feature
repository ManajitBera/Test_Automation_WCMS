
@CheckIn, @Sanity
Feature: Check-IN Flow. As a guest user I want complete check in successfully and generate boarding pass

  @CheckIn_MultipaxBooking
  Scenario: To successful complete check in for a multipax booking as a guest user in domestic flight and generate boarding pass for the passengers
    Given As a user, I have a booking in check in window and I am on CMS home page
    And I navigated to Check in landing page
    When I enter booking reference number
    And I enter Last Name of one of the passenger in the booking
    And click on Find booking button to retrieve the booking
    Then I should see the booking retrieved 
    And trip details page is displayed with booking and passenger details

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
