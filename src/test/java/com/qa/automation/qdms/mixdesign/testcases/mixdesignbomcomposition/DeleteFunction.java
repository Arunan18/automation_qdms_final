/***********************************************************************************
* Description
*------------
* 

Mix Design  Delete Functionality

 
TC-MIX-DES-0013



***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* 
* Date Written     : 01/05/2023
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* 
*TC-MIX-DES-0013      01/05/2023       RAHUL.S       Original Version
************************************************************************************/
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class DeleteFunction extends DriverIntialization {

	static int BeforeCount = 0;
	static int AfterCount = 0;
	static String searchdata = null;
	boolean afterdeletion;
	static MixDesignPage mixed = new MixDesignPage();

	@Test
	public void deleteFunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, mixed);
		/* LOGIN */
		LoginTest.Login();

		// CLICK THE MIXED DESIGN CARD
		AddmixedDesignMethods.mixedDesignCard();

		excel();
		Thread.sleep(3000);

		// **********************************************************************************
		// STEP-03 Clicking Delete Button
		// **********************************************************************************

		MixDesignPage.deleteOkButton.click();
		Thread.sleep(4000);

		// **********************************************************************************
		// STEP-04 Checking count after deletion
		// **********************************************************************************

		mixedDesignAfterDeleteconfirm();

		mixedDesignDeleteEqu("STEP-04 ", afterdeletion);

	}

	public static void mixedDesignDeleteconfirm() throws InterruptedException {

		//// ---------------------------------------------------------------------------------------
		//// Count Number of elements before search
		//// ---------------------------------------------------------------------------------------
		String DataCountText = MixDesignPage.paginationCount.getText();

		System.out.println("Projectpagination count :" + DataCountText);
		String[] BeforeCount = DataCountText.split("of");

		System.out.println("Final Count :" + BeforeCount[1]);

	}

	public static void mixedDesignDeletesearch(String colname, String colname1, String searchdata)
			throws InterruptedException, IOException {
		String Name = searchdata;
		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String DeleteXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String DeleteXpath_lastPart = "]/td[10]/span/a[2]/span/span";

		boolean clickNextPage = true;
		boolean sbuExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 102; i++) {
				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(Name)) {
						sbuExist = true;
						if (driver.findElement(By.xpath(DeleteXpath_firstPart + i + DeleteXpath_lastPart))
								.isDisplayed()) {

							testCase = extent.createTest(colname + "CHECKING DELETE ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");

							if (driver.findElement(By.xpath(DeleteXpath_firstPart + i + DeleteXpath_lastPart))
									.isEnabled()) {

								testCase = extent.createTest(colname1 + "CHECKING DELETE ICON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");
								driver.findElement(By.xpath(DeleteXpath_firstPart + i + DeleteXpath_lastPart)).click();
								// driver.findElement(By.xpath(DeleteOk)).click();
								Thread.sleep(2000);
								clickNextPage = false;
								break;
							} else {
								testCase.log(Status.FAIL, "TEST FAIL ❎");
								System.out.println("Button NOT Enabled");
							}
						} else {
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

	}

	public static void mixedDesignAfterDeleteconfirm() throws InterruptedException {

		//// ---------------------------------------------------------------------------------------
		//// Count Number of elements after search
		//// ---------------------------------------------------------------------------------------
		String DataCountText = MixDesignPage.paginationCount.getText();

		System.out.println("Projectpagination count :" + DataCountText);
		String[] AfterCount = DataCountText.split("of");

		System.out.println("Final Count :" + AfterCount[1]);

	}

	public static void mixedDesignDeleteEqu(String colname, boolean expected) {

		try {

			boolean Output = AfterCount == BeforeCount - 1;
			System.out.println("Output is" + Output);
			testCase = extent.createTest(colname + "Checking count after deletion");
			try {

				Assert.assertEquals(Output, expected);
				testCase.log(Status.INFO, "Actual Visible :- " + Output);
				testCase.log(Status.INFO, "Expected Visible :- " + expected);
				testCase.log(Status.PASS, " Unit deleted Succesfully");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualVisible :- " + Output);
				testCase.log(Status.INFO, "Expected Visible :- " + expected);
				testCase.log(Status.FAIL, "Wrong");
			}
		} catch (Exception e) {
			testCase = extent.createTest("1-VISIBLE");
			testCase.log(Status.FAIL, "No element");
		}

	}

	public static void excel() throws InterruptedException, IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Mix Design";
		String testCaseId = "TC-MIX-DES-0013";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		XSSFRow row = sheet.getRow(firstRow);

		String searchdata = (String) row.getCell(1).getStringCellValue();
		Boolean afterdeletion = (Boolean) row.getCell(2).getBooleanCellValue();
		Thread.sleep(2000);
		mixedDesignDeleteconfirm();
		Thread.sleep(2000);
		mixedDesignDeletesearch("STEP-01 ", "STEP-02 ", searchdata);
		Thread.sleep(2000);

	}
}
