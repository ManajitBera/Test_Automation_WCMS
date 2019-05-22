package com.wideroe.supportLibraries;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.wideroe.stepDefinitions.CukeHooks;

public class ExtentManager extends CukeHooks{
	public static ExtentReports extent;
	
	
	public synchronized static ExtentReports initiateReporting() {
		String extentReportDirPath = System.getProperty("user.dir") + File.separator +"Extent_Report";
		System.out.println("extentReportDirPath" + extentReportDirPath);
		if (currentTimeStamp != null) {
			extentReportDirPath = extentReportDirPath + File.separator + "Run" + currentTimeStamp;
			File extentReportDir = new File(extentReportDirPath);
			if (!extentReportDir.exists()) {
				extentReportDir.mkdir();
			}else {
				System.out.println("Extent Report Directory Already exists");
			}
		}else {
			System.out.println("currentTimeStamp is null");
		}
		String reportFile = extentReportDirPath + File.separator + "WideroeCMS_AutomationReport.html";
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFile);
		// System.setProperty("reportFileName", reportFile);
		extent = new ExtentReports();
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir") + File.separator + "extent-config.xml"));
		extent.setSystemInfo("Selenium Version", "3.141.59");
		//extent.setSystemInfo("Environment", System.getProperty("envName"));
		//extent.setSystemInfo("Branch Name", System.getProperty("branchName"));
		//extent.setSystemInfo("Browser Name", );
		extent.attachReporter(htmlReporter);
		return extent;
	}
}
