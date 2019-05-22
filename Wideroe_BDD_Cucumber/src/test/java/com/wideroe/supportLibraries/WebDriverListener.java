package com.wideroe.supportLibraries;

import java.lang.reflect.Field;
import java.util.Properties;

import org.apache.log4j.Logger;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.internal.BaseTestMethod;

/**
 * Will be called before every TestNG Method * @author Cognizant
 */
public class WebDriverListener implements IInvokedMethodListener {

	static Logger log = Logger.getLogger(WebDriverListener.class);

 	private static Properties properties = Settings.getInstance();

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

		SeleniumTestParameters testParameters = new SeleniumTestParameters();

		log.debug("BEGINNING: com.CucumberCraft.supportLibraries.WebDriverListener-beforeInvocation");
		System.out.println("method.isTestMethod()"+method.isTestMethod());
		if (method.isTestMethod()) {

			try {
				setDefaultTestParameters(method, testParameters);
				DriverManager.setTestParameters(testParameters);

			} catch (Exception ex) {
				log.error(ex.getMessage());
				ex.printStackTrace();
			}

		} else {
			log.warn("Provided method is NOT a TestNG testMethod!!!");
		}
		log.debug("END: org.stng.jbehave.LocalWebDriverListener.beforeInvocation");

	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

		log.debug("BEGINNING: WebDriverListener.afterInvocation");
		/*
		 * change the name of the test method that will appear in the report to
		 * one that will contain very handy when analysing results.
		 */
		if (method.isTestMethod()) {
			try {
				BaseTestMethod bm = (BaseTestMethod) testResult.getMethod();
				Field f = bm.getClass().getSuperclass().getDeclaredField("m_methodName");
				f.setAccessible(true);
				String newTestName = testResult.getTestContext().getCurrentXmlTest().getName() + " - "
						+ bm.getMethodName() + " - ";
				log.info("Renaming test method name from: '" + bm.getMethodName() + "' to: '" + newTestName);
				f.set(bm, newTestName);

			} catch (Exception ex) {
				System.out.println("afterInvocation exception:\n" + ex.getMessage());
				ex.printStackTrace();
			}
		}
		log.debug("END: WebDriverListener.afterInvocation");
	}

	public void setDefaultTestParameters(IInvokedMethod method, SeleniumTestParameters testParameters) {
		try {
			String executionMode = method.getTestMethod().getXmlTest().getLocalParameters().get("ExecutionMode");
			System.out.println("executionMode"+executionMode);
			switch (executionMode) {

			case "LOCAL":
				System.out.println("in local browser creation method"+method.getTestMethod().getXmlTest().getLocalParameters().get("BrowserName"));
				testParameters.setExecutionMode(ExecutionMode.valueOf(executionMode));
				if (method.getTestMethod().getXmlTest().getLocalParameters().get("BrowserName") == null) {
					testParameters.setBrowser(Browser.valueOf(properties.getProperty("DefaultBrowser")));
					System.out.println("Briowser Name: " + method.getTestMethod().getXmlTest().getLocalParameters().get("BrowserName"));
				} else {
					testParameters.setBrowser(Browser
							.valueOf(method.getTestMethod().getXmlTest().getLocalParameters().get("BrowserName")));
					System.out.println("Briowser Name: " + method.getTestMethod().getXmlTest().getLocalParameters().get("BrowserName"));
				}

				break;

			default:
				testParameters.setExecutionMode(ExecutionMode.valueOf(properties.getProperty("DefaultExecutionMode")));
				if (method.getTestMethod().getXmlTest().getLocalParameters().get("BrowerName") == null) {
					testParameters.setBrowser(Browser
							.valueOf(method.getTestMethod().getXmlTest().getLocalParameters().get("BrowerName")));
				} else {
					testParameters.setBrowser(Browser.valueOf(properties.getProperty("DefaultBrowser")));
				}
			}

		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
	}

}