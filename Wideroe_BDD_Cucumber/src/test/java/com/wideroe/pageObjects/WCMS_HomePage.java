package com.wideroe.pageObjects;

import java.io.File;
import java.io.IOException;

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
import com.wideroe.supportLibraries.TakeSnapshot;
import com.wideroe.supportLibraries.WebDriverFactory;

public class WCMS_HomePage extends MasterStepDefs {
	static Logger log = Logger.getLogger(WCMS_HomePage.class);
	WebDriver driver;
	CommonMethod commMthd = new CommonMethod();
	String screenshotFormat = WebDriverFactory.getSnapshotFormat();
	String screeshotPath = System.getProperty("user.dir")+ File.separator + "ScreenShots" + File.separator + "Run" + currentTimeStamp;
	String fileName = null;
	//WebDriverFactory wdFact = new WebDriverFactory();
	
	/**
	 * @param driver
	 */
	public WCMS_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using = "//div[@class='wrapper']//img[@class='wideroe_logo']")
	static
	WebElement Wideroe_icon_image;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'menu-wrap')]//a[child::img[contains(@src,'Mytrips')]]")
	WebElement HomePage_Sidebar_MyTrips_Link;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'menu-wrap')]//a[child::img[contains(@src,'check_in')]]")
	WebElement HomePage_Sidebar_CheckIn_Link;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'menu-wrap')]//a[child::img[contains(@src,'Destinations')]]")
	WebElement HomePage_Sidebar_Destinations_Link;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'menu-wrap')]//a[child::img[contains(@src,'Flight')]]")
	WebElement HomePage_Sidebar_FlightStatus_Link;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'menu-wrap')]//a[child::img[contains(@src,'luggage')]]")
	WebElement HomePage_Sidebar_Corporate_Link;
	
	
	public void navigateToCMSHomepage(ExtentTest test) throws Exception{
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
	
	public void valWideroeIconExistnc(ExtentTest test) throws IOException{
		try {
		commMthd.valObjExtnc(Wideroe_icon_image, true);
		test.log(Status.PASS, "Application Launched",
				MediaEntityBuilder.createScreenCaptureFromPath(screeshotPath + File.separator + fileName + screenshotFormat).build());
	}catch (Exception ex) {			
		ex.printStackTrace();
		test.log(Status.FAIL, "Wideroe icon image is not loaded");
		test.log(Status.FAIL, " Failed.\n" + ex.getMessage(),
				MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("screeshotFilePath") + File.separator + fileName + screenshotFormat).build()); 
	}
	}
	
}
