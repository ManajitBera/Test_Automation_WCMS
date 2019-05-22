package com.wideroe.supportLibraries;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.wideroe.utilities.WaitUtil;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.*;

/**
 * Factory class for creating the {@link WebDriver} object as required
 * 
 * @author Cognizant
 */
public class WebDriverFactory {
	private static Properties properties;
	static Logger log = Logger.getLogger(WebDriverFactory.class);
	
	public WebDriverFactory() {
		// To prevent external instantiation of this class
	}

	/**
	 * Function to return the appropriate {@link WebDriver} object based on the
	 * parameters passed
	 * 
	 * @param browser
	 *            The {@link Browser} to be used for the test execution
	 * @return The corresponding {@link WebDriver} object
	 */
	public static WebDriver getWebDriver(Browser browser) {
		WebDriver driver = null;
		properties = Settings.getInstance();
		boolean proxyRequired = Boolean.parseBoolean(properties
				.getProperty("ProxyRequired"));
		try {
			switch (browser) {
			case CHROME:		
				System.setProperty("webdriver.chrome.driver",WebDriverFactory.getDriverPath("ChromeDriverPath"));				
				ChromeOptions options = new ChromeOptions();
		        DesiredCapabilities cap = DesiredCapabilities.chrome();									             
		        cap.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(cap);	
				WaitUtil.implicitWait(driver);			
				break;
			/*case CHROMEHD:
				System.setProperty("webdriver.chrome.driver",WebDriverFactory.getDriverPath("ChromeDriverPath"));				
				ChromeOptions options1 = new ChromeOptions();
				options1.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--silent");
        		options1.addArguments("chrome.switches","--disable-extensions");
		        DesiredCapabilities cap1 = DesiredCapabilities.chrome();									             
		        cap1.setCapability(ChromeOptions.CAPABILITY, options1);
				driver = new ChromeDriver(cap1);	
				WaitUtil.implicitWait(driver);				
				break;*/
			case FIREFOX:
				// Takes the system proxy settings automatically
				//FirefoxProfile profile = new FirefoxProfile();
				//profile.setPreference("general.useragent.override", "Mozilla/5.0(iPad; U; CPU iPhone OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B314 Safari/531.21.10");
				//profile.setPreference("plugin.scan.plid.all", false);
				////profile.setPreference("extensions.blocklist.enabled", false);
				System.setProperty("webdriver.gecko.driver",WebDriverFactory.getDriverPath("FirefoxDriverPath"));
				
				driver = new FirefoxDriver();			
				WaitUtil.implicitWait(driver);
				break;

			case INTERNET_EXPLORER:
				// Takes the system proxy settings automatically
				DesiredCapabilities capabilities = null;
		        try {
		            capabilities = DesiredCapabilities.internetExplorer();		            
		        	capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		        	capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
		        	capabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, true);		        	
		            capabilities.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, true);
		            capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
		            //capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
		            capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		        } catch (Exception e) {
		            System.out.println("Failed due to " + e.getCause());
		        }

				System.setProperty("webdriver.ie.driver",
						WebDriverFactory.getDriverPath("InternetExplorerDriverPath"));
				driver = new InternetExplorerDriver(capabilities);
				WaitUtil.implicitWait(driver);
				break;

			case OPERA:
				// Does not take the system proxy settings automatically!
				// NTLM authentication for proxy NOT supported

				if (proxyRequired) {
					DesiredCapabilities desiredCapabilities = getProxyCapabilities();
					driver = new OperaDriver(desiredCapabilities);
				} else {
					driver = new OperaDriver();
				}
				WaitUtil.implicitWait(driver);
				break;

			case SAFARI:
				// Takes the system proxy settings automatically

				driver = new SafariDriver();
				WaitUtil.implicitWait(driver);
				break;

			default:
				throw new Exception("Unhandled browser!");
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
		}

		return driver;
	}
	
	
	
	/**
	 * This method will return driver path for local execution
	 * @return driverPath
	 */
	public static String getDriverPath(String browserDriverPath){
		
		String driverPath = properties.getProperty(browserDriverPath);
		if(driverPath != null){
			return driverPath;
		}
		else throw new RuntimeException("Driver Path not specified in "
				+ "the Configuration.properties file for the Key:driverPath");
	}
		
	
	/**
	 * This method returns implicit wait time for execution 
	 * @return wait time
	 */
	public static long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) {
			try{
				return Long.parseLong(implicitlyWait);
			}catch(NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			}
		}else {
		return 30;
		}
	}
 
	
	/**
	 * This method will return application URL 
	 * @return application URL
	 */  
	public static String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) 
			return url;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}

	
	public static String getSnapshotFormat() {
		String snapshotFormat = properties.getProperty("snapshotFormat");
		if(snapshotFormat != null) {
			return snapshotFormat;
		}else {
			throw new RuntimeException("Snapshot Format not specified in the Configuration.properties file for the Key:snapshotFormat");
		}
	}
	
	public static String getRunTimeStamp() {
		SimpleDateFormat formatter = new SimpleDateFormat("_ddMMMyyyy_HH_mm_ss");
		String TodaysDate = formatter.format(new Date());
		if(TodaysDate != null) 
			return TodaysDate;
		else throw new RuntimeException("Todays date not found");
	}
	
	/*
	 * public static String getDateFormat() { String snapshotFormat =
	 * properties.getProperty("snapshotFormat"); if(snapshotFormat != null) return
	 * snapshotFormat; else throw new
	 * RuntimeException("Snapshot Format not specified in the Configuration.properties file for the Key:snapshotFormat"
	 * ); }
	 */
	/**
	 * This method will maximize browser window before execution 
	 * @return
	 */
	public static Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) 
			return Boolean.valueOf(windowSize);
			return true;
	}
	
	
	/**
	 * This method returns Browserstack UserName
	 * @return User name
	 */
	public static String getUserName(){
		
		String username = properties.getProperty("username");
		if(username != null) 
			return username;
		else throw new RuntimeException("User name not specified in the Configuration.properties ");
	}
	
	
	/**
	 * This method returns Browserstack Access Keys
	 * @return Access Keys
	 */
	public static String getAccessKey(){
		
		String accessKey = properties.getProperty("accessKey");
		if(accessKey != null) 
			return accessKey;
		else throw new RuntimeException("Access Key not specified in the Configuration.properties ");
		
	}

	private static DesiredCapabilities getProxyCapabilities() {
		properties = Settings.getInstance();
		String proxyUrl = properties.getProperty("ProxyHost") + ":"
				+ properties.getProperty("ProxyPort");

		Proxy proxy = new Proxy();
		proxy.setProxyType(ProxyType.MANUAL);
		proxy.setHttpProxy(proxyUrl);
		proxy.setFtpProxy(proxyUrl);
		proxy.setSslProxy(proxyUrl);

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(CapabilityType.PROXY, proxy);

		return desiredCapabilities;
	}

	/**
	 * Function to return the {@link RemoteWebDriver} object based on the
	 * parameters passed
	 * 
	 * @param browser
	 *            The {@link Browser} to be used for the test execution
	 * @param browserVersion
	 *            The browser version to be used for the test execution
	 * @param platform
	 *            The {@link Platform} to be used for the test execution
	 * @param remoteUrl
	 *            The URL of the remote machine to be used for the test
	 *            execution
	 * @return The corresponding {@link RemoteWebDriver} object
	 */
	public static WebDriver getRemoteWebDriver(Browser browser,
			String browserVersion, Platform platform, String remoteUrl) {

		properties = Settings.getInstance();
		boolean proxyRequired = Boolean.parseBoolean(properties
				.getProperty("ProxyRequired"));

		DesiredCapabilities desiredCapabilities = null;
		if (browser.equals(Browser.OPERA) && proxyRequired) {
			desiredCapabilities = getProxyCapabilities();
		} else {
			desiredCapabilities = new DesiredCapabilities();
		}

		desiredCapabilities.setBrowserName(browser.getValue());

		if (browserVersion != null) {
			desiredCapabilities.setVersion(browserVersion);
		}
		if (platform != null) {
			desiredCapabilities.setPlatform(platform);
		}

		desiredCapabilities.setJavascriptEnabled(true); // Pre-requisite for
														// remote execution

		URL url = getUrl(remoteUrl);

		return new RemoteWebDriver(url, desiredCapabilities);
	}

	private static URL getUrl(String remoteUrl) {
		URL url = null;
		try {
			url = new URL(remoteUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();

		}
		return url;
	}

	/**
	 * Function to return the {@link RemoteWebDriver} object based on the
	 * parameters passed
	 * 
	 * @param browser
	 *            The {@link Browser} to be used for the test execution
	 * @param remoteUrl
	 *            The URL of the remote machine to be used for the test
	 *            execution
	 * @return The corresponding {@link RemoteWebDriver} object
	 */
	public static WebDriver getRemoteWebDriver(Browser browser, String remoteUrl) {
		return getRemoteWebDriver(browser, null, null, remoteUrl);
	}

}