package com.wideroe.supportLibraries;

import io.appium.java_client.AppiumDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



//import com.experitest.selenium.MobileWebDriver;

/**
 * DriverFactory which will create respective driver Object
 * 
 * @author Cognizant
 */
public class DriverFactory {

	static Logger log = Logger.getLogger(DriverFactory.class);
	private static Properties mobileProperties = Settings.getInstance();
	static DriverFactory drvrFctry = new DriverFactory();
	@SuppressWarnings("rawtypes")
	public static AppiumDriver createInstance(SeleniumTestParameters testParameters) {

		AppiumDriver driver = null;
		try {
			switch (testParameters.getExecutionMode()) {
			case BROWSERSTACK:
				break;
			case LOCAL:
				break;
			case MINT:
				break;
			case MOBILE:
				break;
			case PERFECTO:
				break;
			case SAUCELABS:
				break;
			case SEETEST:
				break;
			default:
				break;

			
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(ex.getMessage());
		}
		return driver;
	}

	public static WebDriver createInstanceWebDriver(SeleniumTestParameters testParameters) {
		WebDriver driver = null;
		try {
			switch (testParameters.getExecutionMode()) {
			case LOCAL:
				driver = WebDriverFactory.getWebDriver(testParameters.getBrowser());
				break;	
			case BROWSERSTACK: 				
				driver = drvrFctry.createRemoteDriver();		
				break;

			default:
				throw new Exception("Unhandled Execution Mode!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(ex.getMessage());
		}
		return driver;
	}
	
	private WebDriver createRemoteDriver() throws Exception{
		WebDriver driver = null;
		try{
		//	throw new RuntimeException("RemoteWebDriver is not yet implemented");
			
			
			String userName = WebDriverFactory.getUserName();
			String accessKey = WebDriverFactory.getAccessKey();
			
			
		//	String userName ="kaushik69";
		//	String accessKey = "A3KUNHLZ9geC9zrwa572";
			
			final String URL = "https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
			
			DesiredCapabilities caps = new DesiredCapabilities();

			// Values are being hard codes, need to parameterize after discussion
			
			
			//System.setProperty("java.net.useSystemProxies", "true");
			//System.setProperty("http.proxy.cognizant.com", "6050");
			
			
			 String PROXY = "proxy.cognizant.com:6050";
			 org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
			 proxy.setHttpProxy(PROXY)
			      .setFtpProxy(PROXY)
			      .setSslProxy(PROXY);
			caps.setCapability(CapabilityType.PROXY, proxy);
					
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "10");
			caps.setCapability("browserName", "Firefox");
			caps.setCapability("browserVersion", "57.0");
			caps.setCapability("browserstack.local", "false");
			caps.setCapability("browserstack.debug", "true");
			caps.setCapability("browerstack.use_w3c","true");
			caps.setCapability("build", "Firefox_57_Win_10");
			caps.setCapability("project","SSH_PI 1");

			driver = new RemoteWebDriver(new java.net.URL(URL), caps);
			
			if(WebDriverFactory.getBrowserWindowSize()) driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(
	        		WebDriverFactory.getImplicitlyWait(), TimeUnit.SECONDS);
		}catch(Exception ex){
			ex.printStackTrace();
		}
			return driver;
			
		}
	
	
	// Not implemented Fully
	private WebDriver createGhostDriver() {
		WebDriver driver = null;
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"D:\\Development_Avecto\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		
		driver = new PhantomJSDriver(caps);
		return driver;
	}

	

}