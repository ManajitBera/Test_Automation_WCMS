package com.wideroe.pageObjects;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wideroe.pageObjects.CommonMethod;
import com.wideroe.stepDefinitions.MasterStepDefs;
import com.wideroe.supportLibraries.DriverManager;
import com.wideroe.supportLibraries.WebDriverFactory;

public class CommonMethod extends MasterStepDefs {
	static Logger log = Logger.getLogger(CommonMethod.class);
	WebDriver driver = DriverManager.getWebDriver();
	WebDriverWait wait = new WebDriverWait(driver, 10000);
	public static String strLogMsg = "";

	public void ClickObject(WebElement element) {
		// WebElement element = null;
		try {
			// element = waitForObjToLoad(Element);
			if (element != null) {
				Actions actions = new Actions(driver);
				actions.moveToElement(element);
				Thread.sleep(100);
				element.click();
				Thread.sleep(100);
			}
		} catch (Exception ex) {
			element.sendKeys(" ");
			element.sendKeys("\n");
			ex.printStackTrace();
		}

	}

	public void ClickObject(String xPath) {
		WebElement element = null;
		try {
			element = waitForObjToLoad(xPath);
			if (element != null) {
				Actions actions = new Actions(driver);
				actions.moveToElement(element);
				Thread.sleep(100);
				element.click();
				Thread.sleep(100);
			}
		} catch (Exception ex) {
			element.sendKeys(" ");
			element.sendKeys("\n");
			ex.printStackTrace();
		}

	}

	public void switchToPopUp() {
		try {
			driver.switchTo().activeElement();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public boolean ObjectEnabled(WebElement Element) {
		WebElement element = null;
		Boolean blnObjectEnabled = false;
		try {
			element = waitForObjToLoad(Element);
			if (element != null) {
				blnObjectEnabled = element.isEnabled();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return blnObjectEnabled;

	}

	public void SetData(WebElement element, String strData) {
		System.out.println("strData: " + strData);

		try {
			// WebElement element = waitForObjToLoad(element);
			System.out.println("element: " + element);
			if (element != null) {
				Actions actions = new Actions(driver);
				actions.moveToElement(element);
				Thread.sleep(100);
				element.clear();
				Thread.sleep(100);
				element.sendKeys(strData);
				Thread.sleep(100);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public WebElement waitForObjToLoad(WebElement Element) {
		long t0, t1;
		long intTimeInMillis = 15000;
		boolean blnObjectExistFlag = false;
		WebElement elementReturned = null;
		try {
			t0 = System.currentTimeMillis();
			do {
				Thread.sleep(200);
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ObjName)));
				// List<WebElement> ElementList = driver.findElements(By.xpath(ObjName));
				/*
				 * for (int i=0;i<Element.size();i++) {
				 * 
				 * if (Element.get(i).isDisplayed()){ elementReturned=Element.get(i);
				 * blnObjectExistFlag=true; break; } }
				 */
				Element.clear();
				t1 = System.currentTimeMillis();
			} while (t1 - t0 < intTimeInMillis && !blnObjectExistFlag);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return elementReturned;
	}

	public WebElement waitForObjToLoad(String strXpath) {
		long t0, t1;
		long intTimeInMillis = 15000;
		boolean blnObjectExistFlag = false;
		WebElement elementReturned = null;
		try {
			t0 = System.currentTimeMillis();
			do {
				Thread.sleep(200);
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ObjName)));
				List<WebElement> ElementList = driver.findElements(By.xpath(strXpath));
				for (int i = 0; i < ElementList.size(); i++) {

					if (ElementList.get(i).isDisplayed()) {
						elementReturned = ElementList.get(i);
						blnObjectExistFlag = true;
						break;
					}
				}
				ElementList.clear();
				t1 = System.currentTimeMillis();
			} while (t1 - t0 < intTimeInMillis && !blnObjectExistFlag);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return elementReturned;
	}

	public Boolean valObjExtnc(WebElement element, Boolean blnFlag) {
		Boolean objExistnc = false;
		Boolean objReturnFlag = false;

		try {
			// WebElement element = waitForObjToLoad(Element);
			if (element != null) {
				objExistnc = true;
				System.out.println("in Here");
			}

			else if (blnFlag == objExistnc) {
				objReturnFlag = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return objReturnFlag;
	}

	public Boolean valRadioBtn(WebElement Element, Boolean blnFlag) {

		Boolean objValidation = false;

		try {
			WebElement element = waitForObjToLoad(Element);
			if (element != null) {
				Actions actions = new Actions(driver);
				actions.moveToElement(element);
				Thread.sleep(500);
				Boolean isSelectedFlag = element.isSelected();
				if (blnFlag == isSelectedFlag) {
					objValidation = true;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return objValidation;
	}

	public String GetDate(String strDate) {

		try {
			String arrElmnt = null;
			Integer intDate = null;
			if (strDate.toUpperCase().contains("TODAY")) {
				Calendar cal = Calendar.getInstance();

				if (strDate.contains("+")) {
					arrElmnt = strDate.substring(strDate.indexOf("+") + 1);
					intDate = Integer.parseInt(arrElmnt);
					cal.add(Calendar.DATE, intDate);

				} else if (strDate.contains("-")) {

					arrElmnt = strDate.substring(strDate.indexOf("-") + 1);
					intDate = Integer.parseInt(arrElmnt);
					cal.add(Calendar.DATE, -intDate);
				}
				SimpleDateFormat sdf = new SimpleDateFormat("ddMMM");
				strDate = sdf.format(cal.getTime());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return strDate;
	}

	public String getObjText(WebElement Element) {

		String strElementTxt = "";

		try {
			WebElement element = waitForObjToLoad(Element);

			if (element != null) {
				strElementTxt = element.getText();
				if (strElementTxt == null || strElementTxt == "") {

					strElementTxt = element.getAttribute("value");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strElementTxt;
	}

	public void setClipboardText(String strData) {
		try {
			Thread.sleep(500);
			Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection selection = new StringSelection(strData);
			c.setContents(selection, selection);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getScreenshotDir() {
		String screeshotPath = "ScreenShots";
		SimpleDateFormat formatter = new SimpleDateFormat("_ddMMMyyyy_HH_mm_ss");
		String TodaysDate = formatter.format(new Date());
		if (TodaysDate != null) {
			screeshotPath = System.getProperty("user.dir") + File.separator + screeshotPath + File.separator + "Run"
					+ TodaysDate;
			File screenshtoDir = new File(screeshotPath);
			if (!screenshtoDir.exists()) {
				screenshtoDir.mkdirs();
			} else {
				System.out.println("Screenshot Directory Already exists");
			}
		}
		return screeshotPath;
	}

	public String getClipboardText() {
		String strData = "";
		try {
			Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
			strData = (String) c.getData(DataFlavor.stringFlavor);
			System.out.println("printed" + strData);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return strData;
	}

	public void SelectList(String dropdownListItemsId, String optionText) {
		try {
			WebElement dropdown = driver.findElement(By.id(dropdownListItemsId));
			List<WebElement> options = dropdown.findElements(By.tagName("li"));
			for (WebElement option : options) {

				if (option.getText().contains(optionText)) {
					option.click(); // click the desired option
					break;
				}
			}

		} catch (Exception ex) {

			ex.printStackTrace();
		}
	}

//	 public void SelectDateObject(String DateString, List<WebElement> DateList,  List<WebElement> MonthList, List<WebElement> YearList)
//	 {   
//		 	String [] passportExpiryDateArr = passportExpiryDate.split("-");
//			String[] DateArr = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
//			Integer date = Integer.parseInt(passportExpiryDateArr[0]);
//			String dateString = date.toString();
//			Integer monthNumber = Integer.parseInt(passportExpiryDateArr[1]);
//			ClickObject(ExpiryDay);
//			commMthd.SelectList(ExpDate, dateString);
//			commMthd.ClickObject(ExpiryMonth);
//			commMthd.SelectList(ExpMonth, DateArr[monthNumber-1]);
//			commMthd.ClickObject(ExpiryYear);
//			commMthd.SelectList(ExpYear, passportExpiryDateArr[2]);
//	 }

	/************************************************************************************************************************
	 * Project: WideroeCMS_Automation Method Name: CreatePNRThroughAltea Objective:
	 * Function to Create PNR through altea and use that in Check in flow in CMS.
	 * Methods Called: Created On: 21-May-2019 Author: Manajit Bera (316701)
	 **************************************************** Modification Section ************************************** Last Modified On:
	 * Last Modified By: Reason: NA
	 ************************************************************************************************************************/
	public String CreatePNRThroughAltea(String strCommand) throws Exception {

		boolean blnAllPassFlag = true;
		String checkInPNR = "";

		try {
			// String strResponse="";
			// LaunchApplication();
			// Login();
			LaunchAlteaApplication();
			Login();
			Thread.sleep(12000);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Altea_ObjectProp.strTextInputObj)));
			checkInPNR = createPNR(strCommand);
			// ExcelConnection();
			LogOut();
		}

		catch (Exception ex) {
			strLogMsg = ex.toString();
			ex.printStackTrace();
			;

			blnAllPassFlag = false;
		}
		if (blnAllPassFlag) {
			// LogMessage("Pass");
		} else {
			// LogMessage("Fail");
		}
		return checkInPNR;

	}

	public String createPNR(String strCommand) {
		String PNR = "";
		try {
			String pnrResponse = "";
			pnrResponse = PNRCreation(strCommand);
			PNR = ExtractPNR(pnrResponse);
			if (PNR.equalsIgnoreCase("PNR Creation NOT Successful")) {
				strLogMsg = "PNR is not created :" + PNR;
			} else {
				strLogMsg = "PNR is :" + PNR;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return PNR;
	}

	public String ExtractPNR(String Response) {
		String AlteaPNR = "";
		Boolean pnrCreated = false;
		String[] arrResponse = Response.split("-");
		if (arrResponse.length > 1) {
			if (arrResponse[0].trim().equalsIgnoreCase("IGNORED") && arrResponse[1].trim().length() == 6) {
				AlteaPNR = arrResponse[1].trim();
				pnrCreated = true;
				// strLogMsg = "The PNR is :" + AlteaPNR ;
				System.out.println("AlteaPNR: " + AlteaPNR);
				// hmGlobalData.put("AlteaBooking_ReferenceNumber",AlteaPNR);
				return AlteaPNR;
			}
		}
		if (!pnrCreated) {
			AlteaPNR = "PNR Creation NOT Successful";
		}

		return AlteaPNR;
	}

	public void LaunchAlteaApplication() {

		try {
			driver.get(Altea_ObjectProp.strURL);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			// driver.manage().deleteAllCookies();
			// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

			Thread.sleep(4000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void Login() {
		try {
			WaitForObjectToLoadAndReturnIfExist(Altea_ObjectProp.strUserNameObj).sendKeys(Altea_ObjectProp.strUserName);
			WaitForObjectToLoadAndReturnIfExist(Altea_ObjectProp.strPasswordObj).sendKeys(Altea_ObjectProp.strPassword);
			WaitForObjectToLoadAndReturnIfExist(Altea_ObjectProp.strLogInBtnObj).click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void LogOut() {
		try {
			WaitForObjectToLoadAndReturnIfExist(Altea_ObjectProp.strLogOutObj).click();
			WaitForObjectToLoadAndReturnIfExist(Altea_ObjectProp.strSignOutObj).click();
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Altea_ObjectProp.strUserNameObj)));
		} catch (Exception ex) {
			ex.printStackTrace();
		} /*
			 * finally{ seleniumDriver.quit(); }
			 */

	}

	public String PNRCreation(String strCommand) {
		String strResponse = "";
		long t0 = 0;
		long t1 = 0;
		try {
			String[] arrCommand = strCommand.split(";");
			if (arrCommand[1] != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("ddMMM");
				String TodaysDate = formatter.format(new Date());
				/*
				 * System.out.println("TodaysDate: " + TodaysDate); String flightSellCommand =
				 * arrCommand[1]; System.out.println("flightSellCommand :" + flightSellCommand);
				 * String flightDate = arrCommand[1].substring(8, 13);
				 * System.out.println("flightDate" + flightDate);
				 */
				arrCommand[1] = arrCommand[1].replace(arrCommand[1].substring(8, 13), TodaysDate);
				// System.out.println("flightSellCommand :" + arrCommand[1]);
			}

			String strTempAnthr = "";
			for (int i = 0; i < arrCommand.length; i++) {
				if (arrCommand[i].trim().length() > 0) {
					// strTemp =
					// WaitForObjectToLoadAndReturnIfExist(ObjectProp.strResponseObj).getText();
					WaitForObjectToLoadAndReturnIfExist(Altea_ObjectProp.strTextInputObj)
							.sendKeys(arrCommand[i].trim());
					Thread.sleep(1000);
					WaitForObjectToLoadAndReturnIfExist(Altea_ObjectProp.strTextInputObj).sendKeys(Keys.ENTER);
					// Thread.sleep(1000);
					strTempAnthr = WaitForObjectToLoadAndReturnIfExist(Altea_ObjectProp.strResponseObj).getText();
					/*
					 * if(strTempAnthr.indexOf("NEED ITINERARY")!=-1){ break; }
					 */
					// System.out.println("a:"+strTemp+"b:"+strTempAnthr+"c:"+(t1-t0));
					if (arrCommand[i].trim().equalsIgnoreCase("TTP/RT")) {
						t0 = System.currentTimeMillis();
						t1 = System.currentTimeMillis();
						while ((!strTempAnthr.equalsIgnoreCase("OK ETICKET")) && (t1 - t0) < 20000) {
							Thread.sleep(2000);
							t1 = System.currentTimeMillis();
							System.out.println("Wait for some more seconds TTP " + (t1 - t0));
							strTempAnthr = WaitForObjectToLoadAndReturnIfExist(Altea_ObjectProp.strResponseObj)
									.getText();
						}
					} else if (arrCommand[i].trim().equalsIgnoreCase("FXP")) {
						System.out.println("Wait for some more seconds");
						Thread.sleep(3000);
					} else if (arrCommand[i].trim().equalsIgnoreCase("IG")) {
						// System.out.println(strTempAnthr.indexOf("IGNORED"));
						// System.out.println(strTempAnthr);
						t0 = System.currentTimeMillis();
						t1 = System.currentTimeMillis();
						while ((strTempAnthr.indexOf("IGNORED") == -1) && (t1 - t0) < 15000) {
							Thread.sleep(2000);
							t1 = System.currentTimeMillis();
							System.out.println("Wait for some more seconds IG " + (t1 - t0));
							strTempAnthr = WaitForObjectToLoadAndReturnIfExist(Altea_ObjectProp.strResponseObj)
									.getText();
						}
					}

				}
			}
			strResponse = WaitForObjectToLoadAndReturnIfExist(Altea_ObjectProp.strResponseObj).getText();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strResponse;
	}

	public WebElement WaitForObjectToLoadAndReturnIfExist(String strxpath) throws Exception {
		long t0, t1;
		boolean blnObjectExistFlag = false;
		Integer intTimeInMillis = 10000;
		WebElement elementReturned = null;
		try {

			t0 = System.currentTimeMillis();
			do {

				List<WebElement> ElementList = driver.findElements(By.xpath(strxpath));
				for (int i = 0; i < ElementList.size(); i++) {
					// RenderedWebElement RWElement=(RenderedWebElement) ElementList.get(i);
					if (ElementList.get(i).isDisplayed()) {
						elementReturned = ElementList.get(i);
						// System.out.println("object found");
						blnObjectExistFlag = true;
						break;
					}
				}

				ElementList.clear();
				t1 = System.currentTimeMillis();
			} while (t1 - t0 < intTimeInMillis && !blnObjectExistFlag);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return elementReturned;
	}

}
