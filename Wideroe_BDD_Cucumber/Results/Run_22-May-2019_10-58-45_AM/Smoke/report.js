$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CheckIn.feature");
formatter.feature({
  "line": 3,
  "name": "Check-IN Flow. As a guest user I want complete check in successfully and generate boarding pass",
  "description": "",
  "id": "check-in-flow.-as-a-guest-user-i-want-complete-check-in-successfully-and-generate-boarding-pass",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@CheckIn,"
    },
    {
      "line": 2,
      "name": "@Sanity"
    }
  ]
});
formatter.before({
  "duration": 36064227281,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "To successful complete check in for a multipax booking as a guest user and generate boarding pass for the passengers",
  "description": "",
  "id": "check-in-flow.-as-a-guest-user-i-want-complete-check-in-successfully-and-generate-boarding-pass;to-successful-complete-check-in-for-a-multipax-booking-as-a-guest-user-and-generate-boarding-pass-for-the-passengers",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@CheckIn_MultipaxBooking"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "As a user, I have a booking in check in window and I am on CMS home page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I navigated to Check in landing page",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I enter booking reference number",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I enter Last Name of one of the passenger in the booking",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "click on Find booking button to retrieve the booking",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I should see the booking retrieved",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "trip details page is displayed with booking and passenger details",
  "keyword": "And "
});
formatter.match({
  "location": "CheckIn_Multipax_Step.as_a_user_I_have_a_booking_in_check_in_window_and_I_am_on_CMS_home_page()"
});
formatter.result({
  "duration": 146528600246,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "duration": 87681,
  "status": "passed"
});
});