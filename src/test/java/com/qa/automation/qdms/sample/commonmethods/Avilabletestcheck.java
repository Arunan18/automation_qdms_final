package com.qa.automation.qdms.sample.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;

public class Avilabletestcheck  extends DriverIntialization{
	
	static String value = null;
	static int testCount=0;
	static int newStatus = 0;
	static int processStatus = 0;
	static int passStatus = 0;
	static int failStatus = 0;
	static int newKeyTest = 0;
	static int newNonKeyTest = 0; 
	static int processKeyTest = 0;
	static int processNonKeyTest = 0;
	static int passKeyTest = 0;
	static int passNonKeyTest = 0;
	static int failKeyTest = 0;
	static int failNonKeyTest = 0;
	static int totalKeyTest = 0;
	static int totalNonKeyTest = 0;
	static String test1 = null;
	static String test2 = null;
	static String test3 = null;
	static String test4 = null;
	static String test5 = null;
	static String test6 = null;
	static String test7 = null;
	static String test8 = null;
	static String test9 = null;
	static String test10 = null;
	static String test11 = null;
	static String test12 = null;
	static String test13 = null;
	static String test14 = null;
	static String test15 = null;
	
	public static void AvilableTest(String WorkbookName, String TabName, String TestCaseId, String comment ,int nameColumnNo,
			int TestTrialColumnNo) throws InterruptedException, IOException {
		
		String workbooks = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + WorkbookName + ".xlsx";
		int firstrow = CommonMethods.getFirstRowNum(workbooks, TabName, TestCaseId);
		int lastrow = CommonMethods.getLastRowNum(workbooks, TabName, TestCaseId);
		FileInputStream file = new FileInputStream(workbooks);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(TabName);
		int rowcount = sheet.getLastRowNum();
		for (int i = firstrow; i <= lastrow; i++) { 
			XSSFRow rowk = sheet.getRow(i);

			String searchQuery = rowk.getCell(1).getStringCellValue();
			String test1 =rowk.getCell(2).getStringCellValue();
			String test2 =rowk.getCell(3).getStringCellValue();
			String test3 =rowk.getCell(4).getStringCellValue();
			String test4 =rowk.getCell(5).getStringCellValue();
			String test5 =rowk.getCell(6).getStringCellValue();
			String test6 =rowk.getCell(7).getStringCellValue();
			String test7 =rowk.getCell(8).getStringCellValue();
			String test8 =rowk.getCell(9).getStringCellValue();
			String test9 =rowk.getCell(10).getStringCellValue();
			String test10 =rowk.getCell(11).getStringCellValue();
			String test11 =rowk.getCell(12).getStringCellValue();
			String test12 =rowk.getCell(13).getStringCellValue();
			String test13 =rowk.getCell(14).getStringCellValue();
			String test14 =rowk.getCell(15).getStringCellValue();
			String test15 =rowk.getCell(16).getStringCellValue();
			
			
			
			
			
			
			System.out.println(searchQuery + "******************");
			// ********************************************************************
			boolean clickNextPage = true;
			boolean sbuExist = false; 
			while (clickNextPage) {
				Thread.sleep(2000);
				int size=	driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")).size();
				
			//	int size = column.size();
				System.out.println(size);
				for (int j = 2; j <= size; j++) {
					System.out.println(j);
					Thread.sleep(1000);
					String NameXpath_firstPart = "//tbody[@class='ant-table-tbody']/tr[";
					String text=null;
					try {
					 text = driver.findElement(By.xpath(NameXpath_firstPart + j + "]/td[" + nameColumnNo + "]"))
							.getText();
					} catch (NoSuchElementException e) {
						TestCasePrint("Searched Element Not There");
					}
					System.out.println(text);
					Thread.sleep(500);
					if (text.contains(searchQuery)) {  
						Thread.sleep(500); 
						
						try {
						driver.findElement(
								By.xpath(NameXpath_firstPart + j + "]/td[" + TestTrialColumnNo + "]/span"))
								.click();
						} catch (NoSuchElementException e) {
							TestCasePrint("Clicked Element Not There");
						}
						sbuExist = true;
						break;
					}

					if(sbuExist) {
						break;
					}
				}
				if(sbuExist) {
					break;
				}
				try {
				WebElement next=driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"));
				clickNextPage = next.isEnabled();
				if (clickNextPage == true) {
					Thread.sleep(2000);
					next.click();
				}
				}catch (NoSuchElementException e) {
					TestCasePrint("Next Button Element Not There");
				}
				
			}

		}
		TestCasePrint(comment + "AVILABLE TESTS");

			Thread.sleep(500);
			 testCount = driver.findElements(By.xpath("//div[@class='ant-ribbon-wrapper']")).size();
//		System.out.println(testCount);

			for (int i = 1; i <= testCount; i++) {
				Thread.sleep(500);
//			get Test Name
				String testname = driver
						.findElement(By.xpath("//div[@class='sc-bxivhb hSswcz']/div[" + i + "]/div[1]/div/li"))
						.getText();
				if (testname==test1) {
					TestCasePrint("1ST TEST IS AVILABLE", test1, String.valueOf(testname));	
				}
				else if (testname==test2) {
					TestCasePrint("2ND TEST IS AVILABLE", test2, String.valueOf(testname));	
				}
				else if (testname==test3) {
					TestCasePrint("3RD TEST IS AVILABLE", test3, String.valueOf(testname));	
				}
				else if (testname==test4) {
					TestCasePrint("4TH TEST IS AVILABLE", test4, String.valueOf(testname));	
				}
				else if (testname==test5) {
					TestCasePrint("5TH TEST IS AVILABLE", test5, String.valueOf(testname));	
				}
				else if (testname==test6) {
					TestCasePrint("6TH TEST IS AVILABLE", test6, String.valueOf(testname));	
				}
				else if (testname==test7) {
					TestCasePrint("7TH TEST IS AVILABLE", test7, String.valueOf(testname));	
				}
				else if (testname==test8) {
					TestCasePrint("8TH TEST IS AVILABLE", test8, String.valueOf(testname));	
				}
				else if (testname==test9) {
					TestCasePrint("9TH TEST IS AVILABLE", test9, String.valueOf(testname));	
				}
				else if (testname==test10) {
					TestCasePrint("10TH TEST IS AVILABLE", test10, String.valueOf(testname));	
				}
				else if (testname==test11) {
					TestCasePrint("11TH TEST IS AVILABLE", test11, String.valueOf(testname));	
				}
				else if (testname==test12) {
					TestCasePrint("12TH TEST IS AVILABLE", test12, String.valueOf(testname));	
				}
				else if (testname==test13) {
					TestCasePrint("13TH TEST IS AVILABLE", test13, String.valueOf(testname));	
				}
				else if (testname==test14) {
					TestCasePrint("14TH TEST IS AVILABLE", test14, String.valueOf(testname));	
				}
				else if (testname==test15) {
					TestCasePrint("15TH TEST IS AVILABLE", test15, String.valueOf(testname));	
				}
				else {
					TestCasePrint("NO ANY TESTS AVILABLE THERE");
					
				}
				
			}	
	}



//test case print
	public static void TestCasePrint(String TestCaseName) {
		TestCasePrint(TestCaseName, null, null, null);
	}

	public static void TestCasePrint(String TestCaseName, Object expectedValue, Object actualValue) {
		TestCasePrint(TestCaseName, expectedValue, actualValue, null);
	}

	public static void TestCasePrint(String TestCaseName, Object expectedValue, Object actualValue,
			String Explanation) {
		/**
		 * 
		 * Prints the results of a test case to an extent report.
		 * 
		 * @param TestCaseName  the name of the test case
		 * 
		 * @param expectedValue the expected value of the test case
		 * 
		 * @param actualValue   the actual value of the test case
		 * 
		 * @param Explanation   an optional explanation for the test case
		 */

		if (expectedValue != null && actualValue != null) {
			boolean position = true;

			ExtentTest testCase = extent.createTest(TestCaseName);
			try {
				AssertJUnit.assertEquals(actualValue, expectedValue);
			} catch (AssertionError e) {
				position = false;
			}
			if (position) {
				testCase.log(Status.INFO, "Actual value: " + actualValue.toString());
				testCase.log(Status.INFO, "Expected value: " + expectedValue.toString());
				if (Explanation != null) {
					testCase.log(Status.INFO, Explanation);
				}
				testCase.log(Status.PASS, "TEST PASS ✅");
			} else {
				testCase.log(Status.INFO, "Actual value: " + actualValue.toString());
				testCase.log(Status.INFO, "Expected value: " + expectedValue.toString());
				if (Explanation != null) {
					testCase.log(Status.INFO, Explanation);
				}
				testCase.log(Status.FAIL, "TEST FAIL ❌");
			}
		} else {
			ExtentTest testCase = extent.createTest(TestCaseName);
//				testCase.log(Status.INFO, TestCaseName);
		}

	}
}
