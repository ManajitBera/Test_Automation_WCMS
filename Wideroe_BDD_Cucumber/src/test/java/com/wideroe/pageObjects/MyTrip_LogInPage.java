package com.wideroe.pageObjects;
import java.io.File;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.wideroe.stepDefinitions.MasterStepDefs;
import com.wideroe.supportLibraries.Settings;
import com.wideroe.supportLibraries.TakeSnapshot;
import com.wideroe.supportLibraries.WebDriverFactory;
/**
 * @author 316701
 *
 */
public class MyTrip_LogInPage extends MasterStepDefs {
	static Logger log = Logger.getLogger(MyTrip_LogInPage.class);

	WebDriver driver;
	CommonMethod commMthd = new CommonMethod();
	String screenshotFormat = WebDriverFactory.getSnapshotFormat();
	String screeshotPath = System.getProperty("user.dir")+ File.separator + "ScreenShots" + File.separator + "Run" + currentTimeStamp;
	//WebDriverFactory wdFact = new WebDriverFactory();
	
	/**
	 * @param driver
	 */
	public MyTrip_LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/*Element locator for HomePage_Sidebar_MyTrips_Link
	 * 
	 */
	@FindBy(how=How.XPATH, using="//div[contains(@class,'menu-wrap')]//a[contains(.,'My trips')]")
	WebElement HomePage_Sidebar_MyTrips;
	
	/* Element locator for User Name Text box
	 *  
	 */
	@FindBy(how=How.XPATH, using="//input[@data-ng-model='loginCntrl.logindetails.user']")
	WebElement MyTrip_UserName_TextBox;
	@FindBy(how=How.XPATH, using = "//input[@data-ng-model='loginCntrl.logindetails.password']")
	WebElement Password_Textbox;
	@FindBy(how=How.XPATH, using = "//div[@class='wrapper']//img[@class='wideroe_logo']")
	WebElement Wideroe_icon_image;
	@FindBy(how=How.XPATH, using = "//button[contains(.,'LOGIN')][contains(@class,'btn_filled')]")
	WebElement LogIn_Button;
	@FindBy(how=How.XPATH, using = "//div[contains(@data-ng-if,'isLoggedIn')]/button")
	WebElement MyTripPage_UserLoggedIn_Dropdown;
	
	/*My Trip page navigation
	 * 
	 */
	public void navigateToWideroeHomepage(ExtentTest test) throws Exception{
		String fileName = "Launch_Error";
		//String fileName = currentScenario.getName() + "Launch";
    	try {
    	    String applicationURL = WebDriverFactory.getApplicationUrl();
    	    driver.get(applicationURL);
			Thread.sleep(10000);
			fileName = "Launch_Success";
			//System.out.println("screenshotFormat" + screenshotFormat);
			TakeSnapshot.takeSnapshot(driver, fileName, screeshotPath);
			test.log(Status.PASS, "Application Launched",
					MediaEntityBuilder.createScreenCaptureFromPath(screeshotPath + File.separator + fileName + screenshotFormat).build());
		} catch (Exception e) {			
			e.printStackTrace();
			test.log(Status.FAIL, "Fail to Launch the Application");
			TakeSnapshot.takeSnapshot(driver, fileName, screeshotPath);
			test.log(Status.FAIL, " Failed.\n" + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("screeshotFilePath") + File.separator + fileName + screenshotFormat).build()); 
		}
    }
	public void ValWideroeIconExistnc(ExtentTest test){
		commMthd.valObjExtnc(Wideroe_icon_image, true);
	}
	public void ClickMyTripLink(ExtentTest test){
		//commMthd.ClickObject(HomePage_Sidebar_MyTrips);
		HomePage_Sidebar_MyTrips.click();
	}
	public void ValUserNameEditBoxExistnc(ExtentTest test){
		commMthd.valObjExtnc(MyTrip_UserName_TextBox, true);
	}
	public void SetUserName(String UserEmailId){
		commMthd.SetData(MyTrip_UserName_TextBox, UserEmailId);
	}
	public void SetPassword(String Password){
		commMthd.SetData(Password_Textbox, Password);
	}
	public void ClickLogin() {
		commMthd.ClickObject(LogIn_Button);
	}
	public void ValMyTripPage_UserLoggedIn_DropdownExistnc(ExtentTest test) throws Exception {
		String fileName = "Login_Error";
		try {
		commMthd.valObjExtnc(MyTripPage_UserLoggedIn_Dropdown, true);
		fileName = "Login_Success";
		//System.out.println("screenshotFormat" + screenshotFormat);
		TakeSnapshot.takeSnapshot(driver, fileName, screeshotPath);
		test.log(Status.PASS, "Login is successful",
				MediaEntityBuilder.createScreenCaptureFromPath(screeshotPath + File.separator + fileName + screenshotFormat).build());
		}catch (Exception e) {			
			e.printStackTrace();
			test.log(Status.FAIL, "Login Failed");
			TakeSnapshot.takeSnapshot(driver, fileName, screeshotPath);
			test.log(Status.FAIL, " Failed.\n" + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(screeshotPath + File.separator + fileName + screenshotFormat).build()); 
		}
	}
	
    
}

