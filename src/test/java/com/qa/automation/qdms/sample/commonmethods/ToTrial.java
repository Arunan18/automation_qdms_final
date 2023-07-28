package com.qa.automation.qdms.sample.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;

public class ToTrial extends DriverIntialization {
	static String value = null;
	static String labvalue = null;
	static int testCount = 0;
	static int newStatus = 0;
	static int processStatus = 0;
	static int passStatus = 0;
	static int failStatus = 0;
	

	

		public static void mixdesign(String WorkbookName, String TabName, String TestCaseId, List<WebElement> column,int nameColumnNo,
				int mixdesignStatusColumnNo,int labtrialStatusColumnNo) throws InterruptedException, IOException {
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
				System.out.println(searchQuery + "******************");
				// ********************************************************************
				boolean clickNextPage = true;
				boolean sbuExist = false; 
				while (clickNextPage) {
					Thread.sleep(2000);
					int size = column.size();
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
							WebElement status = driver.findElement(
									By.xpath(NameXpath_firstPart + j + "]/td[" + mixdesignStatusColumnNo + "]/span/span/p"));
							 value = status.getText();
							}catch (NoSuchElementException e) {
								TestCasePrint("Status Element Not There");
							}
							 Thread.sleep(500);
							System.out.println(value+"##############");
							
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
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@class='homebtn']")).click();
				Thread.sleep(2000);
				SampleNavigateTest.sampleNavigation();
				Thread.sleep(2000);
				SampleNavigateTest.finishProductSampleMainNavigation();
				Thread.sleep(2000);
				SampleNavigateTest.labTrialSampleNavigation();
				Thread.sleep(2000);
				//*********************************************************************
				while (clickNextPage) {
					Thread.sleep(2000);
					int size = column.size();
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
							WebElement status = driver.findElement(
									By.xpath(NameXpath_firstPart + j + "]/td[" + labtrialStatusColumnNo + "]/span/span/p"));
							 labvalue = status.getText();
							}catch (NoSuchElementException e) {
								TestCasePrint("Status Element Not There");
							}
							 Thread.sleep(500);
							System.out.println(value+"##############");
							
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
				
				//*****************************************************
				try {
					TestCasePrint("SAMPLE STATUS IS MATCHING", value, String.valueOf(labvalue));
					
				} catch (Exception e) {
					TestCasePrint("SAMPLE STATUS IS NOT MATCHING ", value, String.valueOf(labvalue),
							String.valueOf(e));
				}

			}


	}
	public static void material(String WorkbookName, String TabName, String TestCaseId, List<WebElement> column,int nameColumnNo,
			int StatusColumnNo, int TestTrialColumnNo,int materialColumnNo) throws InterruptedException, IOException {
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
			System.out.println(searchQuery + "******************");
			// ********************************************************************
			boolean clickNextPage = true;
			boolean sbuExist = false; 
			while (clickNextPage) {
				Thread.sleep(2000);
				int size = column.size();
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
						WebElement status = driver.findElement(
								By.xpath(NameXpath_firstPart + j + "]/td[" + StatusColumnNo + "]/span/span/p"));
						 value = status.getText();
						}catch (NoSuchElementException e) {
							TestCasePrint("Status Element Not There");
						}
						 Thread.sleep(500);
						System.out.println(value+"##############");
						
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
//					testCase.log(Status.INFO, TestCaseName);
			}
		}	
	
}
