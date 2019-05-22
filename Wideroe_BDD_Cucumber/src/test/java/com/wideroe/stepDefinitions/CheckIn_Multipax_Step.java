package com.wideroe.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.wideroe.pageObjects.CommonMethod;
import com.wideroe.pageObjects.WCMS_HomePage;
import com.wideroe.supportLibraries.DriverManager;
import com.wideroe.supportLibraries.ExtentManager;
import com.wideroe.supportLibraries.XmlInput;

import cucumber.api.java.en.Given;

public class CheckIn_Multipax_Step extends MasterStepDefs {
	static Logger log = Logger.getLogger(CheckIn_Multipax_Step.class);
	WebDriver driver = DriverManager.getWebDriver();
	CommonMethod commthd = new CommonMethod();
	WCMS_HomePage wcmsHomePage = new WCMS_HomePage(driver);
	XmlInput xmlInput=new XmlInput();
	ExtentManager extentManager = new ExtentManager();
	ExtentReports extentReports = ExtentManager.initiateReporting();
	ExtentTest test = extentReports.createTest(currentScenario.getName());
	String strCommand = "IG;SSWF316C28MARCPHTRFNN2;NM1GEIR/HAVARD MR;NM1ESPEN/DANIEL MR;AP OSL 7349927604;FXP;FXT1/P1-2;FXP;FXT2/P1-2;FP CASH;TKOK;TTP/RT;ER;RT;TTC;RT;IG";
	String lastName = "GEIR";
	String checkInPNR = "";
	
	@Given("^As a user, I have a booking in check in window and I am on CMS home page$")
	public void as_a_user_I_have_a_booking_in_check_in_window_and_I_am_on_CMS_home_page() {
		
		try {
			checkInPNR = commthd.CreatePNRThroughAltea(strCommand);
			System.out.println("checkInPNR: " + checkInPNR);
			wcmsHomePage.navigateToCMSHomepage(test);
			wcmsHomePage.valWideroeIconExistnc(test);
			extentReports.flush();
		}
		catch (Exception e) {
			
		}
	}
	
	@Given("^I navigated to Check in landing page$")
	public void i_navigated_to_Check_in_landing_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I enter booking reference number$")
	public void i_enter_booking_reference_number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I enter Last Name of one of the passenger in the booking$")
	public void i_enter_Last_Name_of_one_of_the_passenger_in_the_booking() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^click on Find booking button to retrieve the booking$")
	public void click_on_Find_booking_button_to_retrieve_the_booking() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I should see the booking retrieved$")
	public void i_should_see_the_booking_retrieved() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^trip details page is displayed with booking and passenger details$")
	public void trip_details_page_is_displayed_with_booking_and_passenger_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
