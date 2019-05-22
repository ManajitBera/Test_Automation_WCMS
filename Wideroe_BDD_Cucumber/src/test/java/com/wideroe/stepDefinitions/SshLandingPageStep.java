/**
 * 
 */
/*
 * package com.wideroe.stepDefinitions;
 * 
 * 
 * import com.wideroe.pageObjects.CommonMethod; import
 * com.wideroe.pageObjects.SshLandingPage; import
 * com.wideroe.supportLibraries.DriverManager; import
 * com.wideroe.supportLibraries.Util; import
 * com.wideroe.supportLibraries.XmlInput;
 * 
 * import cucumber.api.java.en.Given; import cucumber.api.java.en.Then; import
 * org.junit.Assert; import org.openqa.selenium.WebDriver;
 * 
 * 
 *//**
	 * @author 375669
	 *
	 */
/*
 * public class SshLandingPageStep extends MasterStepDefs{
 * 
 * 
 * 
 * // WaitUtil waitUtil;
 * 
 *//**
	 * @param testContext
	 *//*
		 * 
		 * WebDriver driver = DriverManager.getWebDriver(); CommonMethod commthd = new
		 * CommonMethod(); SshLandingPage sshLandingPage = new SshLandingPage(driver);
		 * XmlInput xmlInput=new XmlInput();
		 * 
		 * 
		 * @Given("^I navigate to SSH Landing Page$") public void
		 * i_navigate_to_SSH_Landing_Page() throws Throwable {
		 * 
		 * Thread.sleep(5000);
		 * 
		 * String actualSSHLandingPageTitle = "Self Service Hub";
		 * 
		 * String expSSHLandingPageTitle = sshLandingPage.getSSHLandingPageTitle();
		 * 
		 * System.out.println(expSSHLandingPageTitle);
		 * currentScenario.embed(Util.takeScreenshot(driver),"image/png");
		 * Assert.assertEquals(expSSHLandingPageTitle, actualSSHLandingPageTitle);
		 * 
		 * 
		 * }
		 * 
		 * 
		 * @Then("^I should redirect to SSH Landing Page$") public void
		 * I_should_redirect_to_SSH_landing_page() throws Throwable {
		 * Thread.sleep(5000); String actualSSHLandingPageTitle =
		 * "View booking details: Etihad Self-Service Hub";
		 * 
		 * String expSSHLandingPageTitle = sshLandingPage.getSSHLandingPageTitle();
		 * 
		 * System.out.println(expSSHLandingPageTitle);
		 * currentScenario.embed(Util.takeScreenshot(driver),"image/png");
		 * Assert.assertEquals(expSSHLandingPageTitle, actualSSHLandingPageTitle); }
		 * 
		 * @Then("^Passenger details will be displayed$") public void
		 * passenger_details_will_be_displayed() throws Throwable {
		 * 
		 * 
		 * No more in booking summary, this has been replaced with simple text showing
		 * booking reference only
		 * 
		 * String Pax = sshLandingPage.getPrimaryPaxName(); System.out.println(Pax);
		 * 
		 * sshLandingPage.getBookingReference();
		 * 
		 * sshLandingPage.getFlightDetails();
		 * 
		 * //WaitUtil.implicitWait();
		 * 
		 * Thread.sleep(1000);
		 * currentScenario.embed(Util.takeScreenshot(driver),"image/png");
		 * //sshLandingPage.clickMoreDetails(); }
		 * 
		 * @Then("^Passenger will be allowed to select \"([^\"]*)\" and \"([^\"]*)\"$")
		 * public void passenger_will_be_allowed_to_select_and(String SSR, String Meal)
		 * throws Throwable {
		 * 
		 * sshLandingPage.getDepartureDates(); //sshLandingPage.getSSRDetails();
		 * Thread.sleep(1000);
		 * 
		 * // WaitUtil.implicitWait(); sshLandingPage.addOrChangeRequest();
		 * 
		 * Thread.sleep(2000); // WaitUtil.implicitWait(); commthd.switchToPopUp();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * // WaitUtil.implicitWait(); sshLandingPage.mealOptions();
		 * currentScenario.embed(Util.takeScreenshot(driver),"image/png"); }
		 * 
		 * 
		 * @Then("^Should be able to see self servicing options \"([^\"]*)\"$") public
		 * void should_be_able_to_see_self_servicing_options(String arg1) throws
		 * Throwable {
		 * 
		 * 
		 * }
		 * 
		 * 
		 * @Then("^Check seats are blocked$") public void check_seats_are_blocked()
		 * throws Throwable {
		 * 
		 * sshLandingPage.selectSeat(); Thread.sleep(2000); commthd.switchToPopUp();
		 * Thread.sleep(2000);
		 * currentScenario.embed(Util.takeScreenshot(driver),"image/png"); }
		 * 
		 * 
		 * @Then("^Check if the cancel flight is blocked$") public void
		 * check_if_the_cancel_flight_is_blocked() throws Throwable { // Write code here
		 * that turns the phrase above into concrete actions
		 * 
		 * sshLandingPage.modifyFlightCancelTrip(); Thread.sleep(2000);
		 * commthd.switchToPopUp(); // WaitUtil.implicitWait(); Thread.sleep(2000);
		 * sshLandingPage.cancelTripPopUpCloseButton();
		 * 
		 * currentScenario.embed(Util.takeScreenshot(driver),"image/png"); }
		 * 
		 * @Then("^Validate all the details is updated$") public void
		 * validate_all_the_details_is_updated() throws Throwable {
		 * sshLandingPage.ValidateMeal(); }
		 * 
		 * @Then("^Validate that CheckIn button should not be displayed$") public void
		 * Validate_that_CheckIn_button_should_not_be_displayed() throws Throwable {
		 * sshLandingPage.validateCheckInBtn(); }
		 * 
		 * @Then("^A proper message should be displayed \"([^\"]*)\"$") public void
		 * A_proper_message_should_be_displayed(String Message) throws Throwable{
		 * sshLandingPage.validatemessage(Message); }
		 * 
		 * @Then("^A specific message \"(.*?)\" should also be displayed$") public void
		 * A_specific_message_should_also_be_displayed(String SpecificMessage) throws
		 * Throwable{ sshLandingPage.validateSpecificMessage(SpecificMessage);
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * }
		 */