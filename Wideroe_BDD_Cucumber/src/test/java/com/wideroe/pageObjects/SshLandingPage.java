/**
 * 
 */
/*
 * package com.wideroe.pageObjects;
 * 
 * import java.util.List;
 * 
 * 
 * import org.openqa.selenium.NoSuchElementException; import
 * org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement; import
 * org.openqa.selenium.support.FindBy; import org.openqa.selenium.support.How;
 * import org.openqa.selenium.support.PageFactory; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait; import org.testng.Assert;
 * import org.testng.AssertJUnit;
 * 
 * import com.wideroe.stepDefinitions.MasterStepDefs; import
 * com.wideroe.supportLibraries.Util;
 * 
 * //import com.etihad.booking.utilities.WaitUtil;
 * 
 *//**
	 * @author 375669
	 *
	 */
/*
 * public class SshLandingPage extends MasterStepDefs{
 * 
 * 
 * WebDriver driver; CommonMethod commMthd = new CommonMethod();
 * 
 *//**
	 * @param driver
	 */
/*
 * public SshLandingPage(WebDriver driver) { this.driver = driver;
 * PageFactory.initElements(driver, this); }
 * 
 * 
 * ELement Locator for Check-in Button
 * 
 * @FindBy(how=How.ID,using="eycheckInBtn") List<WebElement> checkInBtn;
 * 
 * ELement Locator for messages if Check-in Button is not displayed
 * 
 * 
 * @FindBy(how=How.XPATH,using="//div[@class = 'ey-unavailable-head']")
 * List<WebElement> message1;
 * 
 * @FindBy(how=How.XPATH,using="//p[@class = 'ey-unavailable-msg']")
 * List<WebElement> message2;
 * 
 * Element Locator for Booking header
 *
 * We can also use H1 Tag for the same.If class name does not work use H1 tag
 *
 * 
 * @FindBy(how=How.CLASS_NAME,using="ey-head-text") List<WebElement>
 * bookingHeader;
 * 
 * 
 * 
 * Element Locator for Primary Passenger Name . No More in use, this has been
 * removed from booking summary details.
 * 
 * @FindBy(how=How.CLASS_NAME, using="ey-head-name") List<WebElement>
 * passengerName;
 * 
 * //Not Needed anymore
 * 
 * @FindBy(how=How.CLASS_NAME,using="") List<WebElement> passengerDetails;
 * 
 * 
 * @FindBy(how=How.ID,using="bookingReference") List<WebElement>
 * bookingReference;
 * 
 * @FindBy(how=How.CLASS_NAME,using="flight-detail") List<WebElement>
 * listFlightDetails;
 * 
 * 
 * @FindBy(how=How.CLASS_NAME,using="travel-date") List<WebElement> travelDates;
 * 
 * // Not in use currently due to compound classes are used for class name
 * 
 * @FindBy(how=How.CLASS_NAME,using="more-detail  collapsed ") List<WebElement>
 * moreDetails;
 * 
 * 
 * @FindBy(how=How.CLASS_NAME,using="more-detail") List<WebElement> lessDetails;
 * 
 * 
 * @FindBy(how=How.LINK_TEXT,using="Add request") List<WebElement> addRequest;
 * 
 * 
 * @FindBy(how=How.LINK_TEXT,using="Add or change request") List<WebElement>
 * addOrChangeRequest;
 * 
 * 
 * @FindBy(how=How.LINK_TEXT,using="Change request") List<WebElement>
 * changeRequest;
 * 
 * 
 * @FindBy(how=How.TAG_NAME,using="Buy baggage") List<WebElement> buyBaggage;
 * 
 * 
 * @FindBy(how=How.CLASS_NAME,using="special-request") List<WebElement>
 * specialRequests;
 * 
 * 
 * @FindBy(how=How.NAME,using="meal_0") List<WebElement> mealOption;
 * 
 * 
 * @FindBy(how=How.XPATH,using="//a/span[contains(text(),'Select seat')]")
 * List<WebElement> selfServiceSelectSeat;
 * 
 * 
 * @FindBy(how=How.XPATH,using="//span[contains(text(),'Modify flight')]")
 * List<WebElement> modifyFlightButton;
 * 
 * 
 * @FindBy(how=How.XPATH,using="//a[contains(text(),'Cancel trip')]")
 * List<WebElement> cancelTripButton;
 * 
 * // Not sure if will work or not
 * 
 * @FindBy(how=How.XPATH,using="//button[contains(text(),'Close')]")
 * List<WebElement> closeCancelTripPopUp;
 * 
 * // Meal from SSR
 * 
 * @FindBy(how=How.XPATH,using="//*[@id='pax-leg-1-1-0-0']/div[2]/div[4]/ul/li")
 * List<WebElement> Meal;
 * 
 * 
 * // // Meal from SSR // public static final String Meal =
 * "//*[@id='pax-leg-1-1-0-0']/div[2]/div[4]/ul/li";
 *//**
	 * 
	 * @return SSH Landing Page Title
	 */
/*
 * public String getSSHLandingPageTitle(){
 * 
 * // String SSHLandingPageTitle = driver.getTitle();
 * 
 * String SSHLandinPageTitle = driver.switchTo().window("").getTitle();
 * 
 * return SSHLandinPageTitle; }
 * 
 * 
 *//**
	 * 
	 * @return Primary Pax Name for the booking
	 */
/*
 * public String getPrimaryPaxName(){
 * 
 * String primePaxName = commMthd.getObjText(passengerName);
 * currentScenario.embed(Util.takeScreenshot(driver),"image/png"); return
 * primePaxName;
 * 
 * }
 * 
 * 
 * public String getBookingReference(){
 * 
 * String bookingReferenceName = commMthd.getObjText(bookingReference);
 * System.out.println(bookingReferenceName); return bookingReferenceName;
 * 
 * }
 * 
 * 
 *//**
	 * @return Flight Details for the booking.
	 */
/*
 * public void getFlightDetails(){
 * 
 * for(WebElement we:listFlightDetails){
 * 
 * System.out.println(we.getText()); System.out.println("*****"); }
 * currentScenario.embed(Util.takeScreenshot(driver),"image/png"); }
 * 
 * 
 * public void clickMoreDetails(){
 * 
 * commMthd.ClickObject(moreDetails); }
 * 
 * 
 * public void getBuyBaggage(){
 * 
 * 
 * }
 * 
 *//**
	 * This method close the update contact details pop-up
	 */
/*
 * public void closeContactDetails(){
 * 
 * try { WebDriverWait wait = new WebDriverWait(driver, 8);
 * wait.until(ExpectedConditions.alertIsPresent()); }
 * 
 * catch (Exception e) {
 * 
 * } }
 * 
 * 
 *//**
	 * This method gets the SSR details
	 */
/*
 * public void getSSRDetails(){
 * 
 * //int count = 0; for(WebElement we:specialRequests){
 * 
 * System.out.println("***********"); System.out.println(we.getText()); //count=
 * count+ 1; } currentScenario.embed(Util.takeScreenshot(driver),"image/png");
 * //System.out.println(count); }
 * 
 * 
 * 
 *//**
	 * Clicks on the add or change request link for adding Meals and SSR
	 * 
	 */
/*
 * public void addOrChangeRequest(){
 * 
 * 
 * 
 * if(commMthd.waitForObjToLoad(addOrChangeRequest)!=null){
 * commMthd.ClickObject(addOrChangeRequest); }
 * 
 * else if(commMthd.waitForObjToLoad(addRequest)!=null){
 * commMthd.ClickObject(addRequest);
 * 
 * }
 * 
 * else if(commMthd.waitForObjToLoad(changeRequest)!=null){
 * commMthd.ClickObject(changeRequest); }
 * 
 * else throw new RuntimeException();
 * currentScenario.embed(Util.takeScreenshot(driver),"image/png"); }
 * 
 * 
 *//**
	 * This will return the journey dates for all the items in itinerary
	 */
/*
 * public void getDepartureDates(){ try{ for(WebElement depDate:travelDates){
 * 
 * System.out.println(depDate.getText()); } }catch(Exception ex){
 * ex.printStackTrace(); }
 * currentScenario.embed(Util.takeScreenshot(driver),"image/png"); }
 * 
 * // Need to work on this later public void mealOptions(){
 * commMthd.ClickObject(mealOption);
 * 
 * }
 * 
 *//**
	 * This method is for checking if select seat is displayed and click if
	 * available
	 */
/*
 * public void selectSeat(){
 * 
 * try{ if(commMthd.waitForObjToLoad(selfServiceSelectSeat)!=null){
 * commMthd.ClickObject(selfServiceSelectSeat); }
 * 
 * } catch(Exception ex){ System.out.println(ex); }
 * 
 * 
 * }
 * 
 *//**
	 * This method is needed to validate the blocked pop which is displayed for UMNR
	 * and other blocking criteria
	 */
/*
 * public void validateBlockedPop(){
 * 
 * //if()
 * 
 * }
 * 
 * 
 * 
 *//**
	 * Modify Flight Cancel trip
	 */
/*
 * public void modifyFlightCancelTrip(){
 * 
 * try{
 * 
 * if(commMthd.waitForObjToLoad(modifyFlightButton)!=null){
 * commMthd.ClickObject(modifyFlightButton); } } catch(NoSuchElementException
 * ex){ throw new RuntimeException("Modify Flight Button not displayed"); }
 * 
 * try{ if(commMthd.waitForObjToLoad(cancelTripButton)!=null){
 * commMthd.ClickObject(cancelTripButton); } }
 * 
 * catch(NoSuchElementException ex){ throw new
 * RuntimeException("Cancel Trip Button not displayed"); }
 * currentScenario.embed(Util.takeScreenshot(driver),"image/png"); }
 * 
 * 
 *//**
	 * Close button in pop-up Might need to update later
	 */
/*
 * public void cancelTripPopUpCloseButton(){
 * 
 * try{ if(commMthd.waitForObjToLoad(closeCancelTripPopUp)!=null){
 * commMthd.ClickObject(closeCancelTripPopUp); } } catch (NoSuchElementException
 * ex) {
 * 
 * System.err.println(ex); System.out.println("Close Button not present");
 * 
 * } currentScenario.embed(Util.takeScreenshot(driver),"image/png"); }
 * 
 *//** Need to check the significance of the method --7th Sept *//*
																	 * public void ValidateMeal(){ String ActTMealtext =
																	 * "Kosher Meal";
																	 * 
																	 * String expMealText = commMthd.getObjText(Meal);
																	 * System.out.println("Text Should Be" + " " +
																	 * expMealText);
																	 * 
																	 * Assert.assertEquals(ActTMealtext, expMealText);
																	 * 
																	 * System.out.println("Asserted"); } public void
																	 * validateCheckInBtn(){
																	 * 
																	 * if(commMthd.ObjectEnabled(checkInBtn)){
																	 * System.out.println("CheckInButton is displayed");
																	 * 
																	 * } else System.out.
																	 * println("CheckInButton is not displayed"); }
																	 * public void validatemessage(String Message){
																	 * 
																	 * String Message1 = commMthd.getObjText(message1);
																	 * 
																	 * AssertJUnit.assertEquals(Message, Message1); }
																	 * public void validateSpecificMessage(String
																	 * SpecificMessage) { String Message2 =
																	 * commMthd.getObjText(message2);
																	 * System.out.println(Message2);
																	 * AssertJUnit.assertEquals(SpecificMessage,
																	 * Message2); }
																	 * 
																	 * 
																	 * }
																	 */