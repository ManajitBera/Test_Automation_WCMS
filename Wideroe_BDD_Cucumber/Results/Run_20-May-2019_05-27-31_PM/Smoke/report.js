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
    },
    {
      "cells": [
        "wideroe.test.smart16@gmail.com",
        "Wideroe@123"
      ],
      "line": 15,
      "id": "my-trip-login-page.-as-a-guest-user-i-want-to-login-to-my-trip-and-see-the-details;to-successfully-login-to-my-trip-as-a-registered-user;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 15559469199,
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
  "duration": 94723252709,
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
  "duration": 40532618318,
  "status": "passed"
});
formatter.match({
  "location": "MyTrip_LogInPageStep.click_on_login_button()"
});
formatter.result({
  "duration": 25217295247,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//button[contains(.,\u0027LOGIN\u0027)][contains(@class,\u0027btn_filled\u0027)]\"}\n  (Session info: chrome\u003d71.0.3578.98)\n  (Driver info: chromedriver\u003d2.41.578737 (49da6702b16031c40d63e5618de03a32ff6c197e),platform\u003dWindows NT 10.0.15063 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 10.04 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.4.0\u0027, revision: \u0027unknown\u0027, time: \u0027unknown\u0027\nSystem info: host: \u0027PC331282\u0027, ip: \u002710.245.162.207\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_141\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:61062}, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003d, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.41.578737 (49da6702b16031c40d63e5618de03a32ff6c197e), userDataDir\u003dC:\\Users\\316701\\AppData\\Local\\Temp\\scoped_dir38616_16811}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d71.0.3578.98, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 48c00ba20d7526b22bcc003bd20ad017\n*** Element info: {Using\u003dxpath, value\u003d//button[contains(.,\u0027LOGIN\u0027)][contains(@class,\u0027btn_filled\u0027)]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:215)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:167)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:671)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:410)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:509)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:402)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy22.sendKeys(Unknown Source)\r\n\tat com.wideroe.pageObjects.CommonMethod.ClickObject(CommonMethod.java:43)\r\n\tat com.wideroe.pageObjects.MyTrip_LogInPage.ClickLogin(MyTrip_LogInPage.java:101)\r\n\tat com.wideroe.stepDefinitions.MyTrip_LogInPageStep.click_on_login_button(MyTrip_LogInPageStep.java:58)\r\n\tat ✽.And Click on login button(MyTrip_LogIn.feature:7)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "MyTrip_LogInPageStep.i_should_redirect_to_Trip_Details_Page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MyTrip_LogInPageStep.i_should_close_the_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 69206,
  "status": "passed"
});
formatter.before({
  "duration": 9936451000,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "To successfully login to My Trip as a registered user",
  "description": "",
  "id": "my-trip-login-page.-as-a-guest-user-i-want-to-login-to-my-trip-and-see-the-details;to-successfully-login-to-my-trip-as-a-registered-user;;3",
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
  "duration": 90812603937,
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
  "duration": 1242996305,
  "status": "passed"
});
formatter.match({
  "location": "MyTrip_LogInPageStep.click_on_login_button()"
});
formatter.result({
  "duration": 5325444203,
  "status": "passed"
});
formatter.match({
  "location": "MyTrip_LogInPageStep.i_should_redirect_to_Trip_Details_Page()"
});
formatter.result({
  "duration": 12668006415,
  "status": "passed"
});
formatter.match({
  "location": "MyTrip_LogInPageStep.i_should_close_the_browser()"
});
formatter.result({
  "duration": 3779549121,
  "status": "passed"
});
formatter.after({
  "duration": 91200,
  "status": "passed"
});
});