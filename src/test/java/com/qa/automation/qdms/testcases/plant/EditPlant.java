//***********************************************************************************
//* Description
//*------------
//* TC-PLANT-0070-->Check Edit Plant Functionality (Plant Edit Functionality)
//***********************************************************************************
//*
//* Author           : SIVABALAN RAHUL
//* Date Written     : 25/02/2023
//* 
//*
//* 
//* Test Case Number       Date         Author        Comments
//* ================       ====         =====        ========
//* TC-PLANT-0070          25/02/2023   RAHUL.S    Original Version
//*                                     RAHUL.S    Updated
//************************************************************************************
package com.qa.automation.qdms.testcases.plant;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.PlantPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterTest;

public class EditPlant extends DriverIntialization {
	static String code = null;
	static String plant = null;
	static String address = null;
	static String contactNo = null;
	static String fax = null;
	static String description = null;
	static String sbu = null;

	@Test
	public static void login() throws InterruptedException, IOException {
//********************************************************************************************************		
//THIS METHOD IS FOR LOGIN AND CLICKING THE MASTER AND GO TO PLANT
//********************************************************************************************************	
		PlantPage editplantpg = new PlantPage();

		LoginTest.Login();
		MasterTest.MasterCard();
		Thread.sleep(4000);

		PageFactory.initElements(driver, editplantpg);
		Thread.sleep(3000);
		try {
			PlantPage.clickplant.click();
			Thread.sleep(3000);

//STEP-01, STEP-02 THE NAME SEARCH			
//search();
			if (search() == 1) {

			} else {
//THE FIRST FIELD NEEDS TO BE DISABLED	
				EditPlant.checkfirstfield();
//CONFIRM BEFORE EDIT INTERMIATE
				beforeEdit();
//EDIT THE PLANT NAME ONLY
				EditPlant.PlantNameEdit();
//CHECK THE UPDATE BUTTON UI PROPERTIES				
				EditPlant.checkUpdateButton();
//CLICK THE UPDATE BUTTON
				EditPlant.ClickUpdateButton();
				Thread.sleep(3000);
//AGAIN SEARCH THE NAME TO CONFIRM THE EDIT			
				search();
//CONFIRM THE EDIT
				nameconfirm();
//CONFIRM THE EDITED WILL BE IN THE FIRST ROW
				editedFirstRow();
//CLICK THE CANCEL BUTTON
				PlantPage.cancelbutton.click();
			}

//THIS METHOD IS FOR LOGOUT
			Logout.LogoutFunction();
		} catch (Exception e) {
			Logout.LogoutFunction();
		}

//********************************************************************************************************	
	}

//********************************************************************************************************		
//		 THIS METHOD IS FOR SEARCH THE EXACT NAME WHAT WE GIVEN
//********************************************************************************************************	

	public static int search() throws InterruptedException, IOException {
		int a = 0;
		String Name = code;
		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[9]/span/a/span";

		boolean clickNextPage = true;
		boolean sbuExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 102; i++) {
				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println("Plant name  " + text);
					if (text.equals(Name)) {
						sbuExist = true;
						if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).isDisplayed()) {

							testCase = extent.createTest("STEP-01-CHECKING EDIT ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");

							String x = driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart))
									.getAttribute("disabled");
							if (x == null) {
								testCase = extent.createTest("STEP-02-CHECKING EDIT ICON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");
								driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
								Thread.sleep(2000);
								clickNextPage = false;
								break;
							} else if (x.equals("true")) {
								testCase = extent.createTest("STEP-02-CHECKING EDIT ICON IS ENABLED");
								testCase.log(Status.FAIL, "TEST FAIL ❎");
								clickNextPage = false;
								a = 1;
								break;

							}

						}

						else {
							testCase.log(Status.FAIL, "TEST FAIL ❎");
							System.out.println("Button NOT Displayed");
						}

					}
				} catch (Exception e) {
				}
			}
			if (clickNextPage == true) {
				clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				Thread.sleep(2000);
			} else {
				break;
			}
		}
		if (sbuExist = false) {
			System.out.println("No such Element" + sbuExist);
		}
		return a;
	}

//**********************************************************************************************************************	
//          STEP-07-- CONFIRM THE EDIT
//**********************************************************************************************************************	
	public static void nameconfirm() throws InterruptedException, IOException {

		try {
			String Value = PlantPage.plantname.getAttribute("value");
// System.out.println("plant name *************** " + plantName);
// Thread.sleep(2000);
			TestCasePrint("STEP-07--CONFIRM THE EDIT", "RMC Balangoda Plant", String.valueOf(Value));
		} catch (Exception e) {
			TestCasePrint("STEP-07--CONFIRM THE EDIT", "RMC Balangoda Plant", String.valueOf(e));
		}
		PlantPage.cancelbutton.click();
	}

//**********************************************************************************************************************	
//STEP-04-- CONFIRM BEFORE EDIT INTERMIATE 
//**********************************************************************************************************************
	public static void beforeEdit() throws InterruptedException, IOException {
		try {
			String Value = PlantPage.plantname.getAttribute("value");

			TestCasePrint("STEP-04--CONFIRM BEFORE THE EDIT", plant, String.valueOf(Value));
		} catch (Exception e) {

		}

	}
//**********************************************************************************************************************	
//STEP-08-- CONFIRM THE EDITED WILL BE IN THE FIRST ROW 
//**********************************************************************************************************************

	public static void editedFirstRow() throws InterruptedException, IOException {

		try {
			PlantPage.tableFirstRow.click();
			String Value = PlantPage.plantname.getAttribute("value");

			TestCasePrint("STEP-08--CONFIRM THE EDITED WILL BE IN THE FIRST ROW", "RMC Balangoda Plant",
					String.valueOf(Value));
		} catch (Exception e) {
			TestCasePrint("STEP-08--CONFIRM THE EDITED WILL BE IN THE FIRST ROW", "RMC Balangoda Plant",
					String.valueOf(e));
		}

	}

//*****************************************************************************************************************************	
//STEP-03 -- CHECK THE MANDATORY FILED IS DISABLED 
//***************************************************************************************************************************
	public static void checkfirstfield() throws InterruptedException, IOException {
		// test Enabled
		try {
			boolean value = PlantPage.mandatory.isEnabled();

			TestCasePrint("STEP-03 -- CHECK THE MANDATORY FILED IS DISABLED  ", "false", String.valueOf(value));
		} catch (Exception e) {
			TestCasePrint("STEP-03 -- CHECK THE MANDATORY FILED IS DISABLED", "false", String.valueOf(e));

		}

	}

//*****************************************************************************************************************************	
//	EDIT THE PLANT NAME 
//*****************************************************************************************************************************
	public static void PlantNameEdit() throws InterruptedException, IOException {

		// for plant name
		Thread.sleep(1500);
		try {
			PlantPage.plantname.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			PlantPage.plantname.sendKeys(plant);
		} catch (Exception e) {
			testCase = extent.createTest("PLANT NAME IS NOT WENT");
		}
		// for address
		try {
			PlantPage.Address.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			PlantPage.Address.sendKeys(address);
		} catch (Exception e) {
			testCase = extent.createTest("Address did not went");
		}
		// for Contact No
		try {
			PlantPage.ContactNo.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			PlantPage.ContactNo.sendKeys(contactNo);
		} catch (Exception e) {
			testCase = extent.createTest("Contact No did not went");
		}
		// for fax
		try {
			PlantPage.fax.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			PlantPage.fax.sendKeys(fax);
		} catch (Exception e) {
			testCase = extent.createTest("Fax did not went");
		}
		Thread.sleep(2000);
		// for SubBusiness drop down
		try {
			driver.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']//span[text()='RMC']")).click();

		} catch (Exception e) {
			testCase = extent.createTest("Sub Business Unit Dropdown selection wrong ");
		}
		Thread.sleep(2000);
		try {
			PlantPage.SelectSubBusiness.click();
		} catch (Exception e) {
			testCase = extent.createTest("Sub Business Unit Dropdown selection wrong ");
		}
		// for plant manager
		Thread.sleep(2000);
		try {
			PlantPage.PlantManagerDropDown.click();
		} catch (Exception e) {
			testCase = extent.createTest("Plant manager Dropdown selection wrong");
		}
		Thread.sleep(2000);
		try {
			PlantPage.SelectPlantManager.click();
		} catch (Exception e) {
			testCase = extent.createTest("Plant manager Dropdown selection wrong");
		}
		Thread.sleep(2000);
		// for description
		try {
			PlantPage.Description.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			Thread.sleep(2000);
			PlantPage.Description.sendKeys("RMC Jaffna Plant");
		} catch (Exception e) {
			testCase = extent.createTest("Description did not went");
		}

	}

//********************************************************************************************************
//THE METHOD IS FOR GENERATING REPORT 
//********************************************************************************************************	
	public static void TestCasePrint(String TestCaseName, String expectedValue, String actualValue) {
		boolean position = true;
		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			position = false;
		}
		if (position) {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "Expectedvalue :- " + expectedValue);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, actualValue);
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "ExpectedValue :- " + expectedValue);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, actualValue);
		}

	}
//*************************************************************************************************************
//STEP-04-CHECKING UI OF UPDATE BUTTON"	
//*************************************************************************************************************

	public static void checkUpdateButton() throws InterruptedException, IOException {

		testCase = extent.createTest("STEP-05-CHECKING UI OF UPDATE BUTTON");
		boolean Value1 = PlantPage.UpdateButton.isDisplayed();

		if (Value1) {

			try {
				boolean Value = PlantPage.UpdateButton.isDisplayed();
// Thread.sleep(2000);
				TestCasePrint("1)UPDATE BUTTON IS DISPLAYED", "true", String.valueOf(Value));
			} catch (Exception e) {
				TestCasePrint("1)UPDATE BUTTON IS DISPLAYED", "true", String.valueOf(e));
			}

			try {
				boolean Value = PlantPage.UpdateButton.isEnabled();
// Thread.sleep(2000);
				TestCasePrint("2)UPDATE BUTTON IS ENABLED", "true", String.valueOf(Value));
			} catch (Exception e) {
				TestCasePrint("2)UPDATE BUTTON IS ENABLED", "true", String.valueOf(e));
			}

			try {
				String Value = PlantPage.UpdateButton.getCssValue("background-color");
				System.out.println(Value);
// Thread.sleep(2000);
				TestCasePrint("3)UPDATE BUTTON background-color", "rgba(0, 19, 40, 1)", String.valueOf(Value));
			} catch (Exception e) {
				TestCasePrint("3)UPDATE BUTTON background-color", "rgba(0, 19, 40, 1)", String.valueOf(e));
			}
			try {
				String Value = PlantPage.UpdateButton.getCssValue("padding");
				System.out.println(Value);
// Thread.sleep(2000);
				TestCasePrint("4)UPDATE BUTTON UI - padding", "4px 15px", String.valueOf(Value));
			} catch (Exception e) {
				TestCasePrint("4)UPDATE BUTTON UI - padding", "4px 15px", String.valueOf(e));
			}
			try {
				String Value = PlantPage.UpdateButton.getCssValue("font-family");
				System.out.println(Value);
// Thread.sleep(2000);
				TestCasePrint("5)UPDATE BUTTON UI - font-family", "Roboto, sans-serif", String.valueOf(Value));
			} catch (Exception e) {
				TestCasePrint("5)UPDATE BUTTON UI - font-family", "Roboto, sans-serif", String.valueOf(e));
			}
			try {
				String Value = PlantPage.UpdateButton.getCssValue("color");
				System.out.println(Value);
// Thread.sleep(2000);
				TestCasePrint("6)UPDATE BUTTON UI - color", "rgba(255, 255, 255, 1)", String.valueOf(Value));
			} catch (Exception e) {
				TestCasePrint("6)UPDATE BUTTON UI - color", "rgba(255, 255, 255, 1)", String.valueOf(e));
			}
			try {
				String Value = PlantPage.UpdateButton.getCssValue("font-size");
				System.out.println(Value);
// Thread.sleep(2000);
				TestCasePrint("7)UPDATE BUTTON  UI - font-size", "14px", String.valueOf(Value));
			} catch (Exception e) {
				TestCasePrint("7)UPDATE BUTTON UI - font-size", "14px", String.valueOf(e));
			}
			try {
				String Value = PlantPage.UpdateButton.getCssValue("border-radius");
				System.out.println(Value);
// Thread.sleep(2000);
				TestCasePrint("8)UPDATE BUTTON UI -border-radius", "2px", String.valueOf(Value));
			} catch (Exception e) {
				TestCasePrint("8)UPDATE BUTTON UI - border-radius", "2px", String.valueOf(e));
			}
			try {
				String Value = PlantPage.UpdateButton.getCssValue("border-color");
				System.out.println(Value);
// Thread.sleep(2000);
				TestCasePrint("9)UPDATE BUTTON  UI -border-color", "rgb(255, 255, 255)", String.valueOf(Value));
			} catch (Exception e) {
				TestCasePrint("9)UPDATE BUTTON UI -border-color", "rgb(255, 255, 255)", String.valueOf(e));
			}
			try {
				String Value = PlantPage.UpdateButton.getCssValue("box-shadow");
				System.out.println(Value);
// Thread.sleep(2000);
				TestCasePrint("10)UPDATE BUTTON UI -box-shadow", "rgba(0, 0, 0, 0.016) 0px 2px 0px 0px",
						String.valueOf(Value));
			} catch (Exception e) {
				TestCasePrint("10)UPDATE BUTTON UI - box-shadow", "rgba(0, 0, 0, 0.016) 0px 2px 0px 0px",
						String.valueOf(e));
			}
			try {
				String Value = PlantPage.UpdateButton.getCssValue("font-weight");
				System.out.println(Value);
// Thread.sleep(2000);
				TestCasePrint("11)UPDATE BUTTON  UI -font-weight", "400", String.valueOf(Value));
			} catch (Exception e) {
				TestCasePrint("11)UPDATE BUTTON UI - font-weight", "400", String.valueOf(e));
			}
			try {
				String Value = PlantPage.UpdateButton.getCssValue("cursor");
				System.out.println(Value);
// Thread.sleep(2000);
				TestCasePrint("12)UPDATE BUTTON UI -cursor", "pointer", String.valueOf(Value));
			} catch (Exception e) {
				TestCasePrint("12)UPDATE BUTTON UI - cursor", "pointer", String.valueOf(e));
			}
			try {
				String Value = PlantPage.UpdateButton.getCssValue("opacity");
				System.out.println(Value);
// Thread.sleep(2000);
				TestCasePrint("13)UPDATE BUTTON UI -opacity", "1", String.valueOf(Value));
			} catch (Exception e) {
				TestCasePrint("13)UPDATE BUTTON UI -opacity", "1", String.valueOf(e));
			}
			try {
				String Value = PlantPage.UpdateButton.getText();
				System.out.println(Value);
// Thread.sleep(2000);
				TestCasePrint("14)UPDATE BUTTON UI -text spelling", "Update", String.valueOf(Value));
			} catch (Exception e) {
				TestCasePrint("14)UPDATE BUTTON UI -text spelling", "Update", String.valueOf(e));
			}
			try {
				Dimension Value = PlantPage.UpdateButton.getSize();
				System.out.println(Value);
// Thread.sleep(2000);
				TestCasePrint("15)UPDATE BUTTON UI -Size", "(74, 32)", String.valueOf(Value));
			} catch (Exception e) {
				TestCasePrint("15)UPDATE BUTTON UI -Size", "(74, 32)", String.valueOf(e));
			}

			try {
				Point Value = PlantPage.UpdateButton.getLocation();
				System.out.println(Value);
// Thread.sleep(2000);
				TestCasePrint("16)UPDATE BUTTON  UI -position", "(887, 670)", String.valueOf(Value));
			} catch (Exception e) {
				TestCasePrint("16)UPDATE BUTTON UI -position", "(887, 670)", String.valueOf(e));
			}

		} else {
			TestCasePrint("ELEMENT IS NOT DIPLAYED", "true", String.valueOf(Value1));
		}

	}
//*************************************************************************************************************
//*************************************************************************************************************

	public static void ClickUpdateButton() throws InterruptedException, IOException {
		try {
			PlantPage.UpdateButton.click();
			testCase = extent.createTest("STEP-06 --CONFIRM THE CLICKED UPDATE BUTTON");
		} catch (Exception e) {
			testCase = extent.createTest("STEP-06--UPDATE BUTTON DID NOT CLICKED");
		}
	}

	/*****************************************************************************************
	 * DATA GETTING FROM EXCEL EDIT VALIDATION
	 *****************************************************************************************/
	public static void excelcall() throws InterruptedException, IOException {

		Thread.sleep(2000);
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Plant";
		String testCaseId = "TC-PLANT-0070";
		DataFormatter data = new DataFormatter();
		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			code = data.formatCellValue(row.getCell(1));
			plant = data.formatCellValue(row.getCell(2));
			address = data.formatCellValue(row.getCell(3));
			contactNo = data.formatCellValue(row.getCell(4));
			fax = data.formatCellValue(row.getCell(5));
			description = data.formatCellValue(row.getCell(6));
			sbu = data.formatCellValue(row.getCell(7));

		}
	}

}
