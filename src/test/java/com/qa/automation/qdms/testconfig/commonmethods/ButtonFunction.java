package com.qa.automation.qdms.testconfig.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;

/*
 * Excel File Name
 * Excel Sheet Name
 * TestCase ID
 * TestCase Heading
 * Display 
 * Enabled
 * Expected Window
 * Expected Data
 * Expected Window TestCase
 * Pass The Value From Excel Sheet next || previous
 * */

public class ButtonFunction extends DriverIntialization {

	static String button = null;
	static WebElement nextbtn;
	static WebElement display_xpath;
	static WebElement previous;

	public static void buttonfunction(String ExcelFile_Name, String excelSheetName, String testCaseId,
			String step_heading, String display_testcase, String enabled_testcase, WebElement Expected_Window_xpath,
			String expecteddata, String Window_testcase) throws IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + ExcelFile_Name
				+ ".xlsx";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		XSSFRow row = sheet.getRow(firstRow);
		button = (String) row.getCell(1).getStringCellValue();

		try {
			nextbtn = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary']"));

		} catch (Exception e) {
		}
		try {
			previous = driver.findElement(By.xpath("//button[@type='button']//span[text()='Previous']"));
		} catch (Exception e) {
		}
		System.out.println("xpath" + nextbtn);

		try {
			if (button.equals("next")) {
				display_xpath = nextbtn;

			} else if (button.equals("previous")) {
				display_xpath = previous;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {

			testCase = extent.createTest(step_heading);
			if (display_xpath.isDisplayed()) {
				testCase = extent.createTest(display_testcase);
				testCase.log(Status.PASS, "TEST PASS");

				if (display_xpath.isEnabled()) {
					testCase = extent.createTest(enabled_testcase);
					testCase.log(Status.PASS, "TEST PASS");

					Thread.sleep(2000);
					display_xpath.click();

					/*
					 * Check After click the Button Expected Window Shows or Not Expected Window
					 */
					Thread.sleep(2000);
					try {

						if (Expected_Window_xpath.isDisplayed()) {
							String Actualvalue = Expected_Window_xpath.getText();
							System.out.println(Actualvalue);

							try {
								Assert.assertEquals(Actualvalue, expecteddata);
								testCase = extent.createTest(Window_testcase);
								testCase.log(Status.PASS, "TEST PASS");
								testCase.log(Status.INFO, "Actual Data :- " + Expected_Window_xpath.getText());
								testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
							} catch (AssertionError e) {

								testCase = extent.createTest(Window_testcase);
								testCase.log(Status.FAIL, "TEST FAIL");
								testCase.log(Status.INFO, "Actual Data :- " + Expected_Window_xpath.getText());
								testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
								testCase.log(Status.INFO, "THE EXPECTED WINDOW HEADING DOES NOT APPEAR");
							}
						} else {
							System.out.println("EXPECTED WINDOW NOT DISPLAYED");
						}

					} catch (Exception e) {
						System.out.println("Error in Sample1");
					}

				} else {
					testCase = extent.createTest(enabled_testcase);
					testCase.log(Status.FAIL, "TEST FAIL");
				}

			} else {
				testCase = extent.createTest(display_testcase);
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {
			System.out.println("Error in Method");
		}
	}
}
