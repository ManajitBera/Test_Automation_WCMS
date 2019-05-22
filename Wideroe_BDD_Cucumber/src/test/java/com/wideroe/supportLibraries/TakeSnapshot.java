package com.wideroe.supportLibraries;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class TakeSnapshot extends ExtentManager {
	public static void takeSnapshot (WebDriver driver, String fileName, String screeshotPath)
			throws  Exception {
		
		String screenshotFormat = WebDriverFactory.getSnapshotFormat();
		if (currentTimeStamp != null) {
			File screenshtoDir = new File(screeshotPath);
		//fileName = CukeHooks.currentScenario.getName() + "_" + fileName;
		if (!screenshtoDir.exists()) {
			screenshtoDir.mkdirs();
		}else {
			System.out.println("Screenshot Directory Already exists");
		}
		}else {
			System.out.println("currentTimeStamp is null");
		}
		System.setProperty("screeshotFilePath", screeshotPath);
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(screeshotPath + File.separator + fileName + screenshotFormat));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception (e.getLocalizedMessage());
		}
	}

}
