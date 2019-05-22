package com.wideroe.stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;
import com.wideroe.supportLibraries.Browser;
import com.wideroe.supportLibraries.DriverFactory;
import com.wideroe.supportLibraries.DriverManager;
import com.wideroe.supportLibraries.ExecutionMode;
import com.wideroe.supportLibraries.RestApiForJira;
import com.wideroe.supportLibraries.Settings;
import com.wideroe.supportLibraries.TimeStamp;
import com.wideroe.supportLibraries.Util;
import com.wideroe.supportLibraries.WebDriverFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;

public class CukeHooks extends MasterStepDefs {

	static Logger log;
	static Properties properties = Settings.getInstance();

	static {
		log = Logger.getLogger(CukeHooks.class);
	}

	@Before
	/*public void tearDown(){
		WebDriver driver=DriverFactory.
		driver.quit();
	}*/
	public void setUp(Scenario scenario) {
		try {
			currentScenario = scenario;
			propertiesFileAccess = properties;
			Thread.sleep(2000);
			currentTestParameters = DriverManager.getTestParameters();
			currentTestParameters.setScenarioName(scenario.getName());
			log.info("Running the Scenario : " + scenario.getName());
			if (currentTimeStamp != null) {
				System.out.println("currentTimeStamp: " +currentTimeStamp + "User is in same run");
			}else {
				currentTimeStamp = (String) WebDriverFactory.getRunTimeStamp().toString();
			}		
			//System.out.println("currentTimeStamp" +currentTimeStamp);
			
			if (Boolean.parseBoolean(properties.getProperty("ExecuteInMobile"))) {
				invokeForMobileExecution(scenario);
			} else {
				invokeForDesktopExecution(scenario);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error at Before Scenario " + e.getMessage());
		}
	}
	
	/*@After
	public void tearDown(){
		WebDriver driver=DriverFactory.
		driver.quit();
	}*/

	private void invokeForDesktopExecution(Scenario scenario) {
		WebDriver driver;
		switch (currentTestParameters.getExecutionMode()) {
		case LOCAL:
			driver = DriverFactory.createInstanceWebDriver(currentTestParameters);
			DriverManager.setWebDriver(driver);
			break;
		
		/*case GCHD:
			driver = DriverFactory.createInstanceWebDriver(currentTestParameters);
			DriverManager.setWebDriver(driver);
			break;*/
		case SAUCELABS:
			log.info(
					"Running the Scenario : " + scenario.getName() + " in " + currentTestParameters.getExecutionMode());
			 driver = DriverFactory.createInstanceWebDriver(currentTestParameters);
			DriverManager.setWebDriver(driver);
			break;
		case BROWSERSTACK:
			log.info(
					"Running the Scenario : " + scenario.getName() + " in " + currentTestParameters.getExecutionMode());
			driver = DriverFactory.createInstanceWebDriver(currentTestParameters);

		default:
			try {
				throw new Exception("Unhandled Execution Mode!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("rawtypes")
	private void invokeForMobileExecution(Scenario scenario) {
		switch (currentTestParameters.getExecutionMode()) {

		case MOBILE:
		case SAUCELABS:
		case PERFECTO:
		case MINT:

			log.info(
					"Running the Scenario : " + scenario.getName() + " in " + currentTestParameters.getExecutionMode());
			AppiumDriver driver = DriverFactory.createInstance(currentTestParameters);
			DriverManager.setAppiumDriver(driver);
			break;

		/*case SEETEST:

			log.info(
					"Running the Scenario : " + scenario.getName() + " in " + currentTestParameters.getExecutionMode());
			MobileWebDriver seetestDriver = DriverFactory.createInstanceSeetestDriver(currentTestParameters);
			DriverManager.setSeetestDriver(seetestDriver);
			break;*/

		default:
			try {
				throw new Exception("Unhandled Execution Mode!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("rawtypes")
	@After
	public void embedScreenshot(Scenario scenario) {
		try {
			if (Boolean.valueOf(properties.getProperty("TrackIssuesInJira"))) {
				updateDefectInJira(scenario);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error("Problem while closing the Driver Object " + ex.getMessage());

		} finally {			
			WebDriver driver = DriverManager.getWebDriver();			
			
		}
	}

	/**
	 * Embed a screenshot in test report if test is marked as failed And Update
	 * Task in JIRA
	 * @throws IOException 
	 */
	private void updateDefectInJira(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			try {
				if (Boolean.parseBoolean(properties.getProperty("ExecuteInMobile"))) {
					if (currentTestParameters.getExecutionMode() == ExecutionMode.SEETEST) {
						
						//byte[] screenshot = Util.takeScreenshot(DriverManager.getSeetestDriver());
						//scenario.embed(screenshot, "image/png");
					} else {
						byte[] screenshot = Util.takeScreenshot(DriverManager.getAppiumDriver());
						scenario.embed(screenshot, "image/png");
					}
				} else {
					byte[] screenshot = Util.takeScreenshot(DriverManager.getWebDriver());
					scenario.embed(screenshot, "image/png");
				}

				File filePath = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.FILE);
				RestApiForJira.createLog(scenario.getName(), scenario.getName(), filePath.toString());

			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				somePlatformsDontSupportScreenshots.printStackTrace();
				log.error(somePlatformsDontSupportScreenshots.getMessage());
			}
		}
	}

	private String getFileName(Browser browser, String deviceName) {
		String fileName = "";
		if (browser == null) {
			fileName = deviceName;
		} else if (deviceName == null) {
			fileName = browser.toString();
		} else {
			fileName = "report";
		}
		return fileName;
	}


	public static void generateCustomReports() {

		CucumberResultsOverview overviewReports = new CucumberResultsOverview();
		overviewReports.setOutputDirectory("target");
		overviewReports.setOutputName("cucumber-results");
		overviewReports.setSourceFile("target/cucumber-report/Smoke/cucumber.json");
		try {
			overviewReports.executeFeaturesOverviewReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void copyReportsFolder() {

		String timeStampResultPath = TimeStamp.getInstance();

		File source = new File(Util.getTargetPath());
		File source1 = new File(Util.getAllurePath());
		File dest = new File(timeStampResultPath);
		File dest1 = new File(timeStampResultPath + Util.getFileSeparator() + "Allure-reports");
		if (!dest1.isDirectory()) {
			dest1.mkdirs();
		}
		try {
			FileUtils.copyDirectory(source, dest);
			FileUtils.copyDirectory(source1, dest1);
			try {
				FileUtils.cleanDirectory(source);
			} catch (Exception e) {

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		TimeStamp.reportPathWithTimeStamp = null;

	}

}