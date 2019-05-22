package com.wideroe.stepDefinitions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.wideroe.supportLibraries.DriverFactory;
import com.wideroe.supportLibraries.SeleniumTestParameters;

import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public abstract class MasterStepDefs {

	static Logger log = Logger.getLogger(DriverFactory.class);

	Map<String, Object> perfectoCommand = new HashMap<>();
	protected static Scenario currentScenario;
	protected static String currentTimeStamp;
	protected static SeleniumTestParameters currentTestParameters;
	protected static Properties propertiesFileAccess;
	private static HttpURLConnection httpURLConnect;
	int responseStatus;
	int responseCode;

	/**
	 * Function Applicable to Pause the Script, Generic Application
	 * 
	 * @param How_Long_To_Pause
	 */
	public void PauseScript(int How_Long_To_Pause) {
		// convert to seconds
		How_Long_To_Pause = How_Long_To_Pause * 1000;

		try {
			Thread.sleep(How_Long_To_Pause);
		} catch (final InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * All reusuable Selenium Functions with Perfecto
	 */

	/**
	 * Function to switch the Context
	 * 
	 * @param driver
	 * @RemoteWebDriver
	 * @param context
	 */
	protected static void switchToContext(RemoteWebDriver driver, String context) {
		RemoteExecuteMethod executeMethod = new RemoteExecuteMethod(driver);
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", context);
		executeMethod.execute(DriverCommand.SWITCH_TO_CONTEXT, params);
	}

	
	// Used to get the integer for a month based on the string of the month
	private int getMonthInt(String month) {
		int monthInt = 0;
		switch (month) {
		case "Jan":
			monthInt = 1;
			break;
		case "January":
			monthInt = 1;
			break;
		case "February":
			monthInt = 2;
			break;
		case "Feb":
			monthInt = 2;
			break;
		case "March":
			monthInt = 3;
			break;
		case "Mar":
			monthInt = 3;
			break;
		case "April":
			monthInt = 4;
			break;
		case "Apr":
			monthInt = 4;
			break;
		case "May":
			monthInt = 5;
			break;
		case "June":
			monthInt = 6;
			break;
		case "Jun":
			monthInt = 6;
			break;
		case "July":
			monthInt = 7;
			break;
		case "Jul":
			monthInt = 7;
			break;
		case "August":
			monthInt = 8;
			break;
		case "Aug":
			monthInt = 8;
			break;
		case "September":
			monthInt = 9;
			break;
		case "Sep":
			monthInt = 9;
			break;
		case "October":
			monthInt = 10;
			break;
		case "Oct":
			monthInt = 10;
			break;
		case "November":
			monthInt = 11;
			break;
		case "Nov":
			monthInt = 11;
			break;
		case "December":
			monthInt = 12;
			break;
		case "Dec":
			monthInt = 12;
			break;
		}
		return monthInt;
	}

	

	/**
	 * Function to check the broken links
	 * 
	 * @param Url
	 */
	protected void brokenLinkValidator(String Url) {
		urlLinkStatus(validationOfLinks(Url));
	}

	private String[] validationOfLinks(String urlToValidate) {
		String[] responseArray = new String[3];
		try {
			URL url = new URL(urlToValidate);
			httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();
			responseStatus = httpURLConnect.getResponseCode();
			responseCode = responseStatus / 100;
		} catch (Exception e) {
		}
		responseArray[0] = urlToValidate;
		responseArray[1] = String.valueOf(responseCode);
		responseArray[2] = String.valueOf(responseStatus);
		return responseArray;
	}

	private void urlLinkStatus(String[] responseArray) {
		try {
			String linkValue = responseArray[0];
			String responseValue = responseArray[1];
			responseCode = Integer.valueOf(responseValue);
			String responseStatus = responseArray[2];
			switch (responseCode) {
			case 2:
				/*
				 * System.out.println("It's a Non- Broken Link with URL " +
				 * linkValue + " - " + responseCode + " - with Response code " +
				 * HttpURLConnection.HTTP_OK + " OK ");
				 */
				currentScenario.write(linkValue + ": Response code : " + responseStatus + " - OK" + " & STATUS:PASS");
				break;
			case 3:
				currentScenario.write(linkValue + ": Unknown Responce Code" + " & STATUS:FAIL");
				break;
			case 4:
				/*
				 * System.out.println("It's a Broken link with URL " + linkValue
				 * + " - " + responseCode + " - Client Error " +
				 * HttpURLConnection.HTTP_CLIENT_TIMEOUT + " Bad Request ");
				 */
				currentScenario
						.write(linkValue + ": Response code : " + responseStatus + " - Client error & STATUS:FAIL");
				break;

			case 5:
				/*
				 * System.out.println("It's a Broken link with URL " + linkValue
				 * + " - " + responseCode + " - Internal Server Error " +
				 * HttpURLConnection.HTTP_SERVER_ERROR);
				 */
				currentScenario.write(
						linkValue + ": Response code : " + responseStatus + " - Internal Server Error & STATUS:FAIL");
				break;
			default:
				currentScenario.write(linkValue + ": Unknown Responce Code & STATUS:FAIL");
				break;
			}

		} catch (Exception e) {

		} finally {
			httpURLConnect.disconnect();

		}
	}
}