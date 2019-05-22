$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("MyTrip_LogIn.feature");
formatter.feature({
  "line": 1,
  "name": "My trip login page. As a guest user I want to login to My Trip and see the details",
  "description": "",
  "id": "my-trip-login-page.-as-a-guest-user-i-want-to-login-to-my-trip-and-see-the-details",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "To successfully login to My Trip as a registered user",
  "description": "",
  "id": "my-trip-login-page.-as-a-guest-user-i-want-to-login-to-my-trip-and-see-the-details;to-successfully-login-to-my-trip-as-a-registered-user",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@MyTripLogIn"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "As a user, I am on the My Trip login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter user name \"\u003cUserEmailId\u003e\" and password \"\u003cPassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Click on login button",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I should redirect to Trip Details Page",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I should close the browser",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "my-trip-login-page.-as-a-guest-user-i-want-to-login-to-my-trip-and-see-the-details;to-successfully-login-to-my-trip-as-a-registered-user;",
  "rows": [
    {
      "cells": [
        "UserEmailId",
        "Password"
      ],
      "line": 13,
      "id": "my-trip-login-page.-as-a-guest-user-i-want-to-login-to-my-trip-and-see-the-details;to-successfully-login-to-my-trip-as-a-registered-user;;1"
    },
    {
      "cells": [
        "wideroe.test.smart16@gmail.com",
        "Wideroe@123"
      ],
      "line": 14,
      "id": "my-trip-login-page.-as-a-guest-user-i-want-to-login-to-my-trip-and-see-the-details;to-successfully-login-to-my-trip-as-a-registered-user;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 8417778929,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "To successfully login to My Trip as a registered user",
  "description": "",
  "id": "my-trip-login-page.-as-a-guest-user-i-want-to-login-to-my-trip-and-see-the-details;to-successfully-login-to-my-trip-as-a-registered-user;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@MyTripLogIn"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "As a user, I am on the My Trip login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter user name \"wideroe.test.smart16@gmail.com\" and password \"Wideroe@123\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Click on login button",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I should redirect to Trip Details Page",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I should close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "MyTrip_LogInPageStep.as_a_user_I_am_on_the_My_Trip_login_page()"
});
formatter.result({
  "duration": 62624177112,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "wideroe.test.smart16@gmail.com",
      "offset": 19
    },
    {
      "val": "Wideroe@123",
      "offset": 65
    }
  ],
  "location": "MyTrip_LogInPageStep.i_enter_user_name_and_password(String,String)"
});
formatter.result({
  "duration": 1665450180,
  "status": "passed"
});
formatter.match({
  "location": "MyTrip_LogInPageStep.click_on_login_button()"
});
formatter.result({
  "duration": 312019057,
  "status": "passed"
});
formatter.match({
  "location": "MyTrip_LogInPageStep.i_should_redirect_to_Trip_Details_Page()"
});
formatter.result({
  "duration": 10282338927,
  "status": "passed"
});
formatter.match({
  "location": "MyTrip_LogInPageStep.i_should_close_the_browser()"
});
formatter.result({
  "duration": 3659928630,
  "status": "passed"
});
formatter.after({
  "duration": 86214,
  "status": "passed"
});
});