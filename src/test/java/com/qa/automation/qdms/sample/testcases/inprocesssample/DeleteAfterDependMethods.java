/***********************************************************************************
* Description
*------------
*TC-PRO-SAM-0014	Process Sample Delete Functionality after Depended



***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 12/05/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*  TC-PRO-SAM-0014     12/05/2023     RAHUL.S       Original Version
*                                                    
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;

public class DeleteAfterDependMethods extends DriverIntialization {
	static String message = null;
	static String code = null;
	static String[] countADelete = null;;
	static String[] countBDelete = null;

	/* Excel Sheet Value Passing */
	public static void addexcel() throws InterruptedException, IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Process Sample";
		String testCaseId = "TC-PRO-SAM-0014";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		DataFormatter data = new DataFormatter();

		XSSFRow row = sheet.getRow(firstRow);

		code = (String) row.getCell(1).getStringCellValue();
		message = (String) row.getCell(2).getStringCellValue();
		searchvalue(code, 1);
	}

	// SEARCH PARTICULAR NAME
	public static void searchvalue(String SearchValue, int column) throws InterruptedException {
		WebElement next = driver.findElement(By.xpath("//li[@title='Next Page']//button"));
		boolean nextBtn = next.isEnabled();
		Thread.sleep(3000);
		List<WebElement> Colu = driver
				.findElements(By.xpath("//tr[contains(@class,'ant-table-row')]/child::td[" + column + "]"));

		List<WebElement> sectionList = Colu;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);
			}
			boolean isExist = list.contains(SearchValue);
			Thread.sleep(3000);
			nextBtn = next.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				next.click();
				Thread.sleep(3000);
			} else
				break;
		}

	}

	// CHECKING DELETE ICON
	public static void deleteClick() throws InterruptedException, IOException {
		try {
			if (driver
					.findElement(By.xpath(
							"//td[text()='" + code + "']//following-sibling::td[20]//span[@aria-label='delete']"))
					.isDisplayed()) {
				testCase = extent.createTest("STEP-01--THE DELETE ICON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS");
				if (driver
						.findElement(By.xpath(
								"//td[text()='" + code + "']//following-sibling::td[20]//span[@aria-label='delete']"))
						.isEnabled()) {
					testCase = extent.createTest("STEP-02--THE DELETE ICON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS");
					driver.findElement(By.xpath(
							"//td[text()='" + code + "']//following-sibling::td[20]//span[@aria-label='delete']"))
							.click();
				} else {
					testCase = extent.createTest("STEP-02--THE DELETE ICON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("STEP-01--THE DELETE ICON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// CHECKING OK BUTTON
	public static void clickOkButton() throws InterruptedException, IOException {
		try {
			if (driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[2]"))
					.isDisplayed()) {
				testCase = extent.createTest("STEP-03--THE OK BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS");
				if (driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[2]"))
						.isEnabled()) {
					testCase = extent.createTest("STEP-04--THE OK BUTTON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS");
					driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[2]")).click();
				} else {
					testCase = extent.createTest("STEP-04--THE OK BUTTON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("STEP-03--THE OK BUTTON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// CHECKING ALERT MESSAGE
	public static void alertMessage() throws InterruptedException, IOException {

		try {
			Thread.sleep(1000);
			String AddSuccessMessage = driver.findElement(By.xpath("//div[@class='ant-notification-notice-message']"))
					.getText();
			System.out.println(AddSuccessMessage);
			String expectedatamsg = message;

			testCase = extent.createTest("STEP-05--CONFIRM THE DELETION AFTER DEPEND-1");
			try {
				Assert.assertEquals(AddSuccessMessage, expectedatamsg);
				testCase.log(Status.INFO, "Actual Data :- " + AddSuccessMessage);
				testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
				testCase.log(Status.PASS, "Success Message Enable");
			} catch (AssertionError e) {

				testCase.log(Status.INFO, "Actual Data :- " + AddSuccessMessage);
				testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
				testCase.log(Status.FAIL, "Wrong Success Message Not Enable");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// DATA COUNT BEFORE DELETE
	public static void dataCountBeforeDelete() throws InterruptedException, IOException {
		try {
			String countBeforeDelete = driver.findElement(By.xpath("//li[@class='ant-pagination-total-text']"))
					.getText();
			System.out.println("DATA COUNT BEFORE DELETE" + countBeforeDelete);
			countBDelete = countBeforeDelete.split("of");

			System.out.println(String.valueOf(countBDelete[1]));
		} catch (Exception e) {

		}
	}

	// DATA COUNT AFTER CLICK THE DELETE OK BUTTON
	public static void dataCountAfterDelete() throws InterruptedException, IOException {
		try {
			String countAfterDelete = driver.findElement(By.xpath("//li[@class='ant-pagination-total-text']"))
					.getText();
			System.out.println("DATA COUNT AFTER DELETE" + countAfterDelete);
			countADelete = countAfterDelete.split("of");
			System.out.println(countADelete[1]);
		} catch (Exception e) {

		}
	}

	// CONFIRM THE FUNCTIONALITY DELETE AFTER DEPEND
	public static void confirm() throws InterruptedException, IOException {
		testCase = extent.createTest("STEP-06--CONFIRM THE DELETION AFTER DEPEND-2");

		if (countADelete[1].equals(countBDelete[1])) {
			testCase.log(Status.INFO, "Actual Data :- " + countADelete[1]);
			testCase.log(Status.INFO, "Expected Data :- " + countBDelete[1]);
			testCase.log(Status.PASS, "THE FUNCTION IS PASS - SHOULD NOT DELETE AFTER DELETE");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + countADelete[1]);
			testCase.log(Status.INFO, "Expected Data :- " + countBDelete[1]);
			testCase.log(Status.FAIL, "THE FUNCTION IS FAIL");
		}

	}

}
