/**
 * 
 */
/*
 * 
 * package com.wideroe.pageObjects;
 * 
 * import java.util.List;
 * 
 * import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement;
 * import org.openqa.selenium.support.FindBy; import
 * org.openqa.selenium.support.How; import
 * org.openqa.selenium.support.PageFactory;
 * 
 * import com.wideroe.stepDefinitions.MasterStepDefs; import
 * com.wideroe.supportLibraries.Util; import
 * com.wideroe.supportLibraries.WebDriverFactory;
 * 
 *//**
	 * @author 375669
	 *
	 */
/*
 * 
 * public class PnrLookUpPage extends MasterStepDefs{
 * 
 * 
 * WebDriver driver; CommonMethod commMthd = new CommonMethod();
 * 
 *//**
	 * @param driver
	 */
/*
 * 
 * public PnrLookUpPage(WebDriver driver) { this.driver = driver;
 * PageFactory.initElements(driver, this); }
 * 
 *//**
	 * Element Locator for lastName
	 */
/*
 * 
 * @FindBy(how=How.ID, using="eyName") List<WebElement> lastName;
 * 
 *//**
	 * Element Locator for Booking reference
	 */
/*
 * 
 * @FindBy(how=How.ID,using="eyFoid") List<WebElement> bookingReference;
 * 
 *//**
	 * Element Locator for Find My Booking Btn
	 */
/*
 * 
 * @FindBy(how=How.ID,using="eyPnrSubmit") List<WebElement> btnFindMyBooking;
 * 
 *//**
	 * Element Locator for Where can i find my booking reference
	 */
/*
 * 
 * @FindBy(how=How.LINK_TEXT,using="Where can I find my booking reference?")
 * List<WebElement> findBookingReferenceHelpLink;
 * 
 *//**
	 * Element Locator for error message for Last Name field
	 */
/*
 * 
 * @FindBy(how=How.ID,using="er-eyName") List<WebElement> errorMessageLastName;
 * 
 *//**
	 * Element Locator for error message booking reference field
	 */
/*
 * 
 * @FindBy(how=How.ID,using="er-eyFoid") List<WebElement>
 * errorMessagesBookingReference;
 * 
 * 
 *//**
	 * Element Locator for language picker link
	 */
/*
 * 
 * @FindBy(how=How.CLASS_NAME,using="ey-language-link") List<WebElement>
 * languaugePickerLink;
 * 
 * 
 *//**
	 * This method sets last name in the last name text box
	 * 
	 * @param strLastName
	 */
/*
 * 
 * public void setLastName(String strLastName){
 * 
 * commMthd.SetData(lastName, strLastName);
 * 
 * }
 * 
 *//**
	 * This method sets booking reference in the booking reference text box
	 * 
	 * @param strBookingReference
	 */
/*
 * 
 * public void setBookingReference(String strBookingReference){
 * 
 * commMthd.SetData(bookingReference, strBookingReference);
 * 
 * }
 * 
 *//**
	 * This method will be used to click find my booking button
	 */
/*
 * 
 * public void findMyBookingClick(){
 * 
 * 
 * try { commMthd.ClickObject(btnFindMyBooking);
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 * 
 * }
 * 
 *//**
	 * This method will be used to retrieve booking based on Last name and Booking
	 * reference
	 * 
	 * @param strLastName
	 * @param strBookingReference
	 */
/*
 * 
 * public void findMyBooking(String strLastName, String strBookingReference){
 * try { commMthd.SetData(lastName, strLastName);
 * commMthd.SetData(bookingReference, strBookingReference);
 * commMthd.ClickObject(btnFindMyBooking);
 * currentScenario.embed(Util.takeScreenshot(driver),"image/png"); } catch
 * (Exception e) { e.printStackTrace(); }
 * 
 * }
 * 
 *//**
	 * 
	 * @return Title
	 */
/*
 * 
 * public String getTitle(){ return driver.getTitle(); }
 * 
 *//**
	 * This method is used to navigate to PNR Look up page
	 */
/*
 * 
 * 
 * public void navigateToPnrLookUp(){ try { String applicationURL =
 * WebDriverFactory.getApplicationUrl();
 * 
 * driver.get(applicationURL);
 * 
 * 
 * Thread.sleep(10000); } catch (Exception e) { e.printStackTrace(); }
 * 
 * 
 *//**
	 * Used for automating basic HTTPS authentication using AUTO IT
	 */
/*
 * 
 * 
 * try { Runtime.getRuntime().exec(
 * "D:\\Development_Avecto\\Workspace\\DTISSH\\HandleBasicAuthenthication.exe");
 * } catch (IOException e) {
 * 
 * e.printStackTrace(); }
 * 
 * }
 * 
 *//**
	 * 
	 * @return True if error message is displayed
	 *
	 */
/*
 * 
 * public boolean ifErrorMessageExists(){ Boolean blnErrorMsg = false; try{
 * WebElement elmntLstName = commMthd.waitForObjToLoad(errorMessageLastName);
 * WebElement elmntBkngRfrnc =
 * commMthd.waitForObjToLoad(errorMessagesBookingReference);
 * if((elmntLstName!=null)||(elmntBkngRfrnc!=null)){ blnErrorMsg= true; }
 * }catch(Exception ex){ ex.printStackTrace(); }
 * currentScenario.embed(Util.takeScreenshot(driver),"image/png"); return
 * blnErrorMsg; }
 *
 * 
 * 
 * @return True if Submit Button is enabled
 * 
 * public boolean ifSubmitButtonEnabled(){
 * currentScenario.embed(Util.takeScreenshot(driver),"image/png"); return
 * commMthd.ObjectEnabled(btnFindMyBooking); }
 * 
 *//**
	 * 
	 * @return Error message text for last name field error.
	 */
/*
 * 
 * public String getErrorMessageLastName(){
 * 
 * String ErrorMessage = commMthd.getObjText(errorMessageLastName); return
 * ErrorMessage; }
 * 
 * 
 *//**
	 * 
	 * @return Error Message text for Booking reference error.
	 */
/*
 * 
 * public String getErrorMessageBookingReference(){
 * 
 * String ErrorMessageBookingReference =
 * commMthd.getObjText(errorMessagesBookingReference); return
 * ErrorMessageBookingReference; }
 * 
 * 
 * 
 *//**
	 * 
	 * @return true or false based on language picker is displayed or not.
	 */
/*
 * 
 * public boolean verifyLanguagePickerLinkPresent(){ Boolean
 * blnObjctAvailability = false; try{ WebElement elmntLang =
 * commMthd.waitForObjToLoad(languaugePickerLink); if(elmntLang!=null){
 * blnObjctAvailability = true; } }catch(Exception ex){ ex.printStackTrace(); }
 * return blnObjctAvailability; }
 * 
 *//**
	 * This method will perform click on language picker link if displayed
	 *//*
		 * public void clickLanguagePicker(){ try {
		 * if(verifyLanguagePickerLinkPresent()){
		 * //commMthd.ClickObject(languaugePickerLink); ((WebElement)
		 * languaugePickerLink).click(); Thread.sleep(1000); }else {
		 * System.out.println("Language Picker not displayed/Clickable"); } } catch
		 * (InterruptedException e) { e.printStackTrace(); } }
		 * 
		 * }
		 */