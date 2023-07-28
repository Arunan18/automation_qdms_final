/***********************************************************************************
* Description
*------------
* KEY TEST FOR Plant-Lab Trial Sample(TC-P-LAB-SAM-0019)
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 19/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-P-LAB-SAM-0019   19/04/2023   RAHUL.S    OrIginal Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;

public class KeyTestFunctionMethods extends DriverIntialization {
	static boolean expectselect;
	static String intermediateForKeyTest = null;
	static String tobepick = null;
	static String tocheckIntermediate = null;
	static String toBePickForKeyTestName = null;
	static String tableContains = null;

	/****************************************************************************
	 * DATA SEARCH AND CLICK THE KEY TEST BUTTON
	 ***************************************************************************/

	public static void dataPickForKeyTest() throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Plant Lab Trial Sample";
		String testCaseId = "TC-P-LAB-SAM-0019";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			tobepick = (String) row.getCell(1).getStringCellValue();
			intermediateForKeyTest = (String) row.getCell(2).getStringCellValue();
			toBePickForKeyTestName = (String) row.getCell(3).getStringCellValue();
			tableContains = (String) row.getCell(4).getStringCellValue();
			search();
		}

	}

	public static int search() throws InterruptedException, IOException {
		int a = 0;

		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[14]/span/span";
		boolean clickNextPage = true;
		boolean sbuExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 102; i++) {
				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println("Plant name  " + text);
					if (text.equals(tobepick)) {
						sbuExist = true;
						if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).isDisplayed()) {

							testCase = extent.createTest("STEP-04-CHECKING KEY TEST ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");
							String x = driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart))
									.getAttribute("disabled");
							if (x == null) {
								testCase = extent.createTest("STEP-05-CHECKING KEY TEST ICON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");

								driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();

								Thread.sleep(2000);

								clickNextPage = false;
								break;
							} else if (x.equals("true")) {
								testCase = extent.createTest("STEP-05-CHECKING KEY TEST ICON IS ENABLED");
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

	public static void keyTestModal() throws InterruptedException, IOException {
		try {
			if (PlantLabTrailSamplePage.keyTestModal.isDisplayed()) {
				testCase = extent.createTest("STEP-06-CHECKING KEY TEST POPUP WINDOW IS OPENED AND DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

			} else {
				testCase = extent.createTest("STEP-06-CHECKING KEY TEST POPUP WINDOW IS OPENED AND DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void keyTestModalHeading() throws InterruptedException, IOException {

		try {
			String keyHeading = PlantLabTrailSamplePage.KeyTestModalHeading.getText();

			System.out.println("Projectpagination count :" + keyHeading);
			String[] mixedDesignNo = keyHeading.split("TB-");
			PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-07--CONFIRM THE OPENED POPUPWINDOW IS CORRECT",
					intermediateForKeyTest, String.valueOf(mixedDesignNo[1]));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	

	/**********************************************************************************************************************
	 * CHECK THE KEY TEST CHECK BOX
	 ***********************************************************************************************************************/

	public static void checkTheKeyTestCheckBox() throws InterruptedException, IOException {
		boolean value = PlantLabTrailSamplePage.keyTestCheckBox.isSelected();
		expectselect = PlantLabTrailSamplePage.keyTestCheckBox.isSelected();
		System.out.println("actual:" + value);
		System.out.println("Expected:" + expectselect);
		if (value) {
			if (!expectselect) {
				PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-16-CHECKING KEY TEST FUNCTION", "true",
						String.valueOf(expectselect));
			} else {
				PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-16-CHECKING KEY TEST FUNCTION", "true",
						String.valueOf(expectselect));
			}
		} else if (!value) {
			if (expectselect) {
				PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-16-CHECKING KEY TEST FUNCTION", "false",
						String.valueOf(expectselect));
			} else {
				PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-16-CHECKING KEY TEST FUNCTION", "false",
						String.valueOf(expectselect));
			}
		}
	}

	public static void keyTestSaveButton() throws InterruptedException, IOException {
		try {
			if (PlantLabTrailSamplePage.keyTestSaveButton.isDisplayed()) {
				testCase = extent.createTest("STEP-14-CHECKING KEY TEST SAVE BUTTON DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				if (PlantLabTrailSamplePage.keyTestSaveButton.isEnabled()) {
					testCase = extent.createTest("STEP-15-CHECKING KEY TEST SAVE BUTTON ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					PlantLabTrailSamplePage.keyTestSaveButton.click();

				} else {
					testCase = extent.createTest("STEP-14-CHECKING KEY TEST SAVE BUTTON ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("STEP-15-CHECKING KEY TEST SAVE BUTTON DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static int keyTestCheckBoxClick() throws InterruptedException, IOException {
		int a = 0;

		String NameXpath_firstPart = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/div/div/div/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		boolean clickNextPage = true;
		boolean sbuExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 102; i++) {
				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println("Plant name  " + text);
					if (text.equals(toBePickForKeyTestName)) {
						sbuExist = true;
						if (PlantLabTrailSamplePage.keyTestCheckBox.isDisplayed()) {

							testCase = extent.createTest("STEP-12-CHECKING KEY TEST NAME IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");
							String x = PlantLabTrailSamplePage.keyTestCheckBox.getAttribute("disabled");
							if (x == null) {
								testCase = extent.createTest("STEP-13-CHECKING KEY TEST NAME CHECK BOX IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");

								PlantLabTrailSamplePage.keyTestCheckBox.click();

								Thread.sleep(2000);

								clickNextPage = false;
								break;
							} else if (x.equals("true")) {
								testCase = extent.createTest("STEP-13-CHECKING KEY TEST NAME CHECK BOX IS ENABLED");
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
	
	public static void keyTestCancelButton() throws InterruptedException, IOException {
		try {
			if (PlantLabTrailSamplePage.keyTestCancelButton.isDisplayed()) {
				testCase = extent.createTest("STEP-17-CHECKING KEY TEST CANCEL BUTTON DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				if (PlantLabTrailSamplePage.keyTestCancelButton.isEnabled()) {
					testCase = extent.createTest("STEP-18-CHECKING KEY TEST CANCEL BUTTON ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					PlantLabTrailSamplePage.keyTestCancelButton.click();

				} else {
					testCase = extent.createTest("STEP-17-CHECKING KEY TEST CANCEL BUTTON ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("STEP-18-CHECKING KEY TEST CANCEL BUTTON DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void keyTestTableTitleContains() throws InterruptedException, IOException {
		try {
			if (PlantLabTrailSamplePage.keyTestTableTitleContainer.isDisplayed()) {
				testCase = extent.createTest("STEP-08-CHECKING KEY TEST TABLE TITLE DATA DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				if (PlantLabTrailSamplePage.keyTestTableTitleContainer.isEnabled()) {
					testCase = extent.createTest("STEP-09-CHECKING KEY TEST TABLE TITLE DATA  ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					String tableContant =PlantLabTrailSamplePage.keyTestTableTitleContainer.getText();
					System.out.println("table HEADING data"  +  tableContant);
				} else {
					testCase = extent.createTest("STEP-09-CHECKING KEY TEST TABLE TITLE DATA ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("STEP-08-CHECKING KEY TEST TABLE TITLE DATA DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
}
