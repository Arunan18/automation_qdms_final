/***********************************************************************************
* Description
*------------
*SEARCH IN SBU
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 07/03/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*                        07/03/2023   RAHUL.S    Original Version
*TC-SBU-0013            28/03/2023    RAHUL.S    MODIFIED- ADD EXCEL AND ADD METHODS
************************************************************************************/
package com.qa.automation.qdms.testcases.sbu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.SbuPage;

public class MethodsOfSBU extends DriverIntialization {
	static SbuPage singlesearch = new SbuPage();

	// static String editName = "newdata";
	static int actualElementCount = 0;
	static String tobepick = null;
	static String SearchSBU = null;
	static String defectmesage = null;
	static String mesage = null;
	static String sbuEditValidation = null;
	static String sbu = null;

	public static void Excel() throws IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "SBU";
		String testCaseId = "TC-SBU-0039";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("SBU");
	}

	/*******************************************************************************************************
	 * THE METHOD IS FOR GENERATING REPORT
	 ********************************************************************************************************/
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

	/****************************************************************************************
	 * STEP-01--PLANT TAB IS DISPLAYED & STEP-02--PLANT TAB IS ENABLED
	 ****************************************************************************************/
	public static void plantTab() throws InterruptedException, IOException {

		if (SbuPage.plantTab.isDisplayed()) {
			testCase = extent.createTest("STEP-01--PLANT TAB IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (SbuPage.plantTab.isEnabled()) {
				testCase = extent.createTest("STEP-02--PLANT TAB IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				SbuPage.plantTab.click();

			} else {
				testCase = extent.createTest("STEP-02--PLANT TAB IS ENABLED");

			}
		} else {
			testCase = extent.createTest("STEP-01--PLANT TAB IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	/****************************************************************************************
	 * STEP-03--SBU BUTTON IS DISPLAYED & STEP-04--SBU BUTTON IS ENABLED
	 ****************************************************************************************/
	public static void sbuButton() throws InterruptedException, IOException {

		if (SbuPage.SbuLeftButton.isDisplayed())

		{
			testCase = extent.createTest("STEP-03--SBU BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (SbuPage.SbuLeftButton.isEnabled()) {
				testCase = extent.createTest("STEP-04--SBU BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				SbuPage.SbuLeftButton.click();
				Thread.sleep(2000);

			} else {
				testCase = extent.createTest("STEP-04--SBU BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-03--SBU BUTTON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

//****************************************************************************************
//STEP-05--SBU SEARCH ICON IS DISPLAYED &	STEP-06--SBU SEARCH ICON IS ENABLED
//****************************************************************************************	
	public static void sbuSearchIcon() throws InterruptedException, IOException {
		if (driver.findElement(By.xpath("//span[@role='button']")).isDisplayed()) {
			testCase = extent.createTest("STEP-05--SBU SEARCH ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath("//span[@role='button']")).isEnabled()) {
				testCase = extent.createTest("STEP-06--SBU SEARCH ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					driver.findElement(By.xpath("//span[@role='button']")).click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest("STEP-06--SBU SEARCH ICON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-05--SBU SEARCH ICON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

//************************************************************************************************************
//STEP-07--CHECKING SBU SEARCH SEARCH TEXTBOX DISPLAYED &	STEP-08--CHECKING SBU SEARCH SEARCH TEXTBOX ENABLED
//************************************************************************************************************
	public static void sbuSearchTextBox() throws InterruptedException, IOException {
		if (driver.findElement(By.xpath("//input[@placeholder=' SBU Name']")).isDisplayed()) {
			testCase = extent.createTest("STEP-07--SBU SEARCH TEXT BOX IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath("//input[@placeholder=' SBU Name']")).isEnabled()) {
				testCase = extent.createTest("STEP-08--SBU SEARCH TEXT BOX IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					Thread.sleep(2000);
					searchFromExcel();

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest("STEP-08--SBU SEARCH TEXT BOX IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-07--SBU SEARCH TEXT BOX IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

//************************************************************************************************************
//STEP-09--CHECKING SBU SEARCH BUTTON DISPLAYED &	STEP-10--CHECKING SBU SEARCH BUTTON ENABLED
//************************************************************************************************************			
	public static void sbuSearchButton() throws InterruptedException, IOException {
		if (driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']")).isDisplayed()) {
			testCase = extent.createTest("STEP-09--SEARCH BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']")).isEnabled()) {
				testCase = extent.createTest("STEP-10--SEARCH BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']")).click();
					String sbu = driver.findElement(By.xpath(
							"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]"))
							.getText();
					System.out.println("SBU " + sbu);
					String TextBox1 = driver.findElement(By.xpath("//input[@placeholder='Plant']"))
							.getAttribute("value");
					System.out.println("text box  " + TextBox1);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP-10--SEARCH BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-09--SEARCH BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
	}

//*************************************************************************************************************************		
	public static void search(String SearchSBU) throws InterruptedException, IOException {
		boolean clickNextPage = true;

		boolean passorfail = true;
		ArrayList<String> ActualList = new ArrayList<String>();
		ArrayList<String> ExpectedList = new ArrayList<String>();
		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					String textFull = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart))
							.getText();
					String text = textFull.toLowerCase();
					// System.out.println(text);
					if (!text.contains(SearchSBU)) {
						passorfail = false;
					}
					if (text.contains(SearchSBU)) {
						ExpectedList.add(text);
					}
					ActualList.add(text);
					actualElementCount = actualElementCount + 1;
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
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

//******************************************************************************************************************	
//STEP-10--SINGLE SEARCH CONFIRM
//******************************************************************************************************************
	public static void count() throws InterruptedException, IOException {
		try {
			int Value = actualElementCount;
			TestCasePrint("STEP-11--SINGLE SEARCH CONFIRM", "1", String.valueOf(Value));
		} catch (Exception e) {

		}
	}

	/*****************************************************************************************
	 * DATA GETTING FROM EXCEL
	 *****************************************************************************************/
	public static void searchFromExcel() throws InterruptedException, IOException {

		PageFactory.initElements(driver, singlesearch);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "SBU";
		String testCaseId = "TC-SBU-0013";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			String SearchSBU = (String) row.getCell(1).getStringCellValue();

			driver.findElement(By.xpath("//input[@placeholder=' SBU Name']")).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder=' SBU Name']")).sendKeys(SearchSBU);
			Thread.sleep(2000);

		}
	}

//FOR EDIT VALIDATION	
	public static int search() throws InterruptedException, IOException {
		int a = 0;

		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[3]/span/a[1]/span";
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

							testCase = extent.createTest("STEP-05-CHECKING EDIT ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");

							String x = driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart))
									.getAttribute("disabled");
							System.out.println("disabled ************" + x);
							if (x == null) {
								testCase = extent.createTest("STEP-06-CHECKING EDIT ICON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");
								driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
								Thread.sleep(2000);
								clickNextPage = false;
								break;
							} else if (x.equals("true")) {
								testCase = extent.createTest("STEP-06-CHECKING EDIT ICON IS ENABLED");
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

	/**********************************************************************************************************************
	 * STEP-07-- CONFIRM BEFORE EDIT INTERMIATE
	 **********************************************************************************************************************/
	public static void beforeEdit() throws InterruptedException, IOException {
		try {
			String Value = SbuPage.sbuTextBox.getAttribute("value");

			TestCasePrint("STEP-07--CONFIRM BEFORE THE EDIT",tobepick, String.valueOf(Value));
		} catch (Exception e) {
			TestCasePrint("STEP-07--CONFIRM BEFORE THE EDIT", tobepick, String.valueOf(e));
		}

	}

	
	public static void searchedit(String searchData) throws InterruptedException, IOException {
		int a = 0;

		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[3]/span/a[1]/span";
		boolean clickNextPage = true;
		boolean sbuExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 102; i++) {
				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println("Plant name  " + text);
					if (text.equals(searchData)) {
						sbuExist = true;
						if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).isDisplayed()) {

							testCase = extent.createTest("STEP-05-CHECKING EDIT ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");

							String x = driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart))
									.getAttribute("disabled");
							System.out.println("disabled ************" + x);
							if (x == null) {
								testCase = extent.createTest("STEP-06-CHECKING EDIT ICON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");
								driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
								Thread.sleep(2000);
								clickNextPage = false;
								break;
							} else if (x.equals("true")) {
								testCase = extent.createTest("STEP-06-CHECKING EDIT ICON IS ENABLED");
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
		return;
	}

	/*****************************************************************************************
	 * DATA GETTING FROM EXCEL EDIT VALIDATION
	 *****************************************************************************************/
	public static void excelcall() throws InterruptedException, IOException {

		PageFactory.initElements(driver, singlesearch);

		SoftAssert sa = new SoftAssert();
		Thread.sleep(2000);
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "SBU";
		String testCaseId = "TC-SBU-0039";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("SBU");
		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			sbu = (String) row.getCell(1).getStringCellValue();
			sbuEditValidation = (String) row.getCell(2).getStringCellValue();
			mesage = (String) row.getCell(3).getStringCellValue();
			defectmesage = (String) row.getCell(4).getStringCellValue();
			beforeEdit();
			editValidationForSBU();

		}
	}
/****************************************************************************
 * 			DATA SEARCH AND CLICK THE EDIT BUTTON
 ***************************************************************************/

	public static void dataPick() throws InterruptedException, IOException {

		PageFactory.initElements(driver, singlesearch);
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "SBU";
		String testCaseId = "TC-SBU-0039-TD";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			tobepick = (String) row.getCell(1).getStringCellValue();
			search();
		}

	}
/********************************************************************************************
 * 										EDIT VALIDATION
 *******************************************************************************************/
	public static void editValidationForSBU() throws InterruptedException, IOException {

		PageFactory.initElements(driver, singlesearch);
		Thread.sleep(2000);
		SbuPage.sbuTextBox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		Thread.sleep(2000);
		SbuPage.sbuTextBox.sendKeys(sbu);
		Thread.sleep(2000);
		SbuPage.sbuUpdateButton.click();
		Thread.sleep(2000);
		String Value = SbuPage.validationMessage.getText();
		if (SbuPage.sbuUpdateButton.isDisplayed()) {
			try {
				TestCasePrint(mesage, sbuEditValidation, String.valueOf(Value));
			} catch (Exception e) {

			}
		} else {
			System.out.println("inside else");
			Thread.sleep(2000);

			try {
				testCase.log(Status.FAIL, mesage);
			} catch (Exception e) {

			}

			testCase = extent.createTest(defectmesage);
			searchedit(sbu);

		}
		Thread.sleep(3000);
		if (SbuPage.cancelSbuButton.isDisplayed()) {
			SbuPage.cancelSbuButton.click();
			Thread.sleep(2000);
			search();
		}
		

	}

}