/*
 * package com.wideroe.stepDefinitions;
 * 
 * import com.wideroe.pageObjects.CommonMethod; import
 * com.wideroe.pageObjects.PnrLookUpPage; import
 * com.wideroe.supportLibraries.DriverManager; import
 * com.wideroe.supportLibraries.Util; import
 * com.wideroe.supportLibraries.XmlInput;
 * 
 * import cucumber.api.java.en.*; import org.junit.Assert; import
 * org.openqa.selenium.WebDriver;
 * 
 * 
 * 
 *//**
	 * @author 375669
	 *
	 *//*
		 * public class PnrLookUpStep extends MasterStepDefs{
		 * 
		 * 
		 * WebDriver driver = DriverManager.getWebDriver(); //private static Properties
		 * properties; CommonMethod commthd = new CommonMethod(); PnrLookUpPage
		 * pnrLookUpPage = new PnrLookUpPage(driver); XmlInput xmlInput=new XmlInput();
		 * 
		 * @Given("^As a passenger,I am on the PNR lookUp page$") public void
		 * as_a_passenger_I_am_on_the_PNR_lookUp_page() throws Throwable {
		 * 
		 * pnrLookUpPage.navigateToPnrLookUp(); //String
		 * UserName=xmlInput.getFromXml(usrName); String expTitle =
		 * "Retrieve booking: Etihad Self-Service Hub";
		 * 
		 * String actTitle = pnrLookUpPage.getTitle();
		 * currentScenario.embed(Util.takeScreenshot(driver),"image/png");
		 * Assert.assertEquals(expTitle, actTitle);
		 * 
		 * }
		 * 
		 * 
		 * @When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$") public void
		 * i_enter_and(String strLastName, String strBookingReference) throws Throwable
		 * {
		 * 
		 * pnrLookUpPage.setLastName(strLastName);
		 * pnrLookUpPage.setBookingReference(strBookingReference); }
		 * 
		 * @When("^Click on submit button$") public void click_on_submit_button() throws
		 * Throwable {
		 * 
		 * pnrLookUpPage.findMyBookingClick(); Thread.sleep(10000); // Will create WAIT
		 * Util to better handle waits
		 * 
		 * }
		 * 
		 * @Then("^Success message should be displayed$") public void
		 * success_message_should_be_displayed() throws Throwable {
		 * 
		 * System.out.println("Success");
		 * 
		 * }
		 * 
		 * 
		 * @When("^I enter blank lastName and blank PNR$") public void
		 * i_enter_blank_lastName_and_blank_PNR() throws Throwable {
		 * 
		 * System.out.println("*******");
		 * 
		 * pnrLookUpPage.setLastName("");
		 * 
		 * pnrLookUpPage.setBookingReference("");
		 * 
		 * }
		 * 
		 * @Then("^Error message should be displayed$") public void
		 * error_message_should_be_displayed() throws Throwable {
		 * 
		 * System.out.println("******");
		 * 
		 * Assert.assertTrue("Field Validation Error Exists ",pnrLookUpPage.
		 * ifErrorMessageExists()); }
		 * 
		 * @Then("^Submit button should be disabled$") public void
		 * submit_button_should_be_disabled() throws Throwable {
		 * 
		 * System.out.println("*****");
		 * 
		 * Assert.assertFalse(pnrLookUpPage.ifSubmitButtonEnabled());
		 * 
		 * }
		 * 
		 * 
		 * @Then("^Click on Submit button$") public void click_on_Submit_button() throws
		 * Throwable {
		 * 
		 * pnrLookUpPage.findMyBookingClick();
		 * 
		 * }
		 * 
		 * @Then("^\"([^\"]*)\" should be displayed$") public void
		 * should_be_displayed(String ErrorMessage) throws Throwable {
		 * 
		 * String actualErrorMessage = pnrLookUpPage.getErrorMessageBookingReference();
		 * String expectedErrorMessage = ErrorMessage;
		 * currentScenario.embed(Util.takeScreenshot(driver),"image/png");
		 * Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
		 * 
		 * }
		 * 
		 * 
		 * @When("^I check and click on Language Picker$") public void
		 * i_check_and_click_on_Language_Picker() throws Throwable {
		 * 
		 * pnrLookUpPage.verifyLanguagePickerLinkPresent();
		 * pnrLookUpPage.clickLanguagePicker();
		 * 
		 * }
		 * 
		 * @Then("^Language picker modal displays regions map$") public void
		 * language_picker_modal_displays_regions_map() throws Throwable {
		 * 
		 * 
		 * }
		 * 
		 * 
		 * }
		 */