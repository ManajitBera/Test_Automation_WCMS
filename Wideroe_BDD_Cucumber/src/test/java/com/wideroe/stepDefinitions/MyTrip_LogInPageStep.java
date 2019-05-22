package com.wideroe.stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.wideroe.pageObjects.CommonMethod;
import com.wideroe.pageObjects.MyTrip_LogInPage;
import com.wideroe.supportLibraries.DriverManager;
import com.wideroe.supportLibraries.ExtentManager;
import com.wideroe.supportLibraries.Util;
import com.wideroe.supportLibraries.XmlInput;

import cucumber.api.java.en.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author 316701
 * 
 */
@SuppressWarnings({ })
public class MyTrip_LogInPageStep extends MasterStepDefs {

	static Logger log = Logger.getLogger(MyTrip_LogInPageStep.class);
	WebDriver driver = DriverManager.getWebDriver();
	CommonMethod commthd = new CommonMethod();
	MyTrip_LogInPage myTripLoginPage = new MyTrip_LogInPage(driver);
	XmlInput xmlInput=new XmlInput();
	ExtentManager extentManager = new ExtentManager();
	ExtentReports extentReports = ExtentManager.initiateReporting();
	ExtentTest test = extentReports.createTest(currentScenario.getName());
	
	@Given("^As a user, I am on the My Trip login page$")
	public void as_a_user_I_am_on_the_My_Trip_login_page() {
		try {
			myTripLoginPage.navigateToWideroeHomepage(test);
			myTripLoginPage.ValWideroeIconExistnc(test);
			myTripLoginPage.ClickMyTripLink(test);
			myTripLoginPage.ValUserNameEditBoxExistnc(test);
			System.out.println("I am on the My Trip login page.");
		}
		catch (Exception e) {
			
		}
	}

	@When("^I enter user name \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_enter_user_name_and_password(String UserEmailId, String Password) {
		System.out.println("I am on the My Trip login page.");
		myTripLoginPage.SetUserName(UserEmailId);
		myTripLoginPage.SetPassword(Password);
	}

	@When("^Click on login button$")
	public void click_on_login_button() throws InterruptedException {
		Thread.sleep(5000);
	    myTripLoginPage.ClickLogin();
	}

	@Then("^I should redirect to Trip Details Page$")
	public void i_should_redirect_to_Trip_Details_Page() throws Exception {
		Thread.sleep(10000);
		myTripLoginPage.ValMyTripPage_UserLoggedIn_DropdownExistnc(test);
		Util.takeScreenshot(driver);
		//TakeSnapshot.takeSnapshot(driver, String FileName);
		
	}
	
	@Then("^I should close the browser$")
	public void i_should_close_the_browser() {
		driver.quit();
		extentReports.flush();
	}
	
}
	 