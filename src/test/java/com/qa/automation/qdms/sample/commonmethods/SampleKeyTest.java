package com.qa.automation.qdms.sample.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;

public class SampleKeyTest extends DriverIntialization{
	static String value = null;
	static int testCount = 0;
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
	static String NameXpath_firstPart = null;
	static int num = 0;
	static String searchQuery = null;
	static int testRowCount = 0;
static int k=0;
	static ArrayList<String> arr = new ArrayList<String>();

	public static void keyTest(String WorkbookName, String TabName, String TestCaseId, List<WebElement> column,
			int nameColumnNo, int keyColumn, int StatusColumnNo, int TestTrialColumnNo) throws IOException, InterruptedException {
		DataFormatter fData= new DataFormatter();
		WebDriverWait wait=new WebDriverWait(driver, 2);
		String workbooks = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + WorkbookName + ".xlsx";
		int firstrow = CommonMethods.getFirstRowNum(workbooks, TabName, TestCaseId);
		int lastrow = CommonMethods.getLastRowNum(workbooks, TabName, TestCaseId);
		FileInputStream file = new FileInputStream(workbooks);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(TabName);
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow rowk = sheet.getRow(i);

			searchQuery = fData.formatCellValue(rowk.getCell(1));
			boolean nextPagee = true;
			boolean sbuExist = false;
			while (nextPagee) {
				Thread.sleep(3000);
				int size = 0;
				try {
					size=driver.findElements(By.xpath("//tbody/tr/td[1]")).size();
				} catch (Exception e) {
					 size = 11;
				}
				System.out.println(size); 
				for (int j = 2; j <= size; j++) {
					System.out.println(j); 
					Thread.sleep(100);
					NameXpath_firstPart = "//tbody[@class='ant-table-tbody']/tr[";
					String text = null;
					try {
						try {
							wait.until(ExpectedConditions.visibilityOf(driver.findElement(
									By.xpath(NameXpath_firstPart + j + "]/td[" + nameColumnNo + "]"))));
						} catch (Exception e) {
							// TODO: handle exception
						}
						text = driver.findElement(By.xpath(NameXpath_firstPart + j + "]/td[" + nameColumnNo + "]"))
								.getText();
					} catch (NoSuchElementException e) {
						TestCasePrint("Searched Element Not There");
					}
					System.out.println(text);
					Thread.sleep(100);
					if (text.contains(searchQuery)) {
						num = j;

						try {
						wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(NameXpath_firstPart + j + "]/td[" + keyColumn + "]/span"))));
							driver.findElement(By.xpath(NameXpath_firstPart + j + "]/td[" + keyColumn + "]/span"))
									.click();
							k=j;
						} catch (NoSuchElementException e) {
							TestCasePrint("Clicked Element Not There");
						}
						sbuExist = true;
						break;
					}

					if (sbuExist) {
						break;
					}
				}
				if (sbuExist) {
					break;
				}
				Thread.sleep(1000);
				try {
					WebElement next = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"));
					nextPagee = next.isEnabled();
					if (nextPagee == true) {
						next.click();
					}
				} catch (NoSuchElementException e) {
					TestCasePrint("Next Button Element Not There");
				}

			}
			
			if(sbuExist==false) {
				extent.createTest("Sample Code Not In Table");
				
			} else {
			try {
				Thread.sleep(2000);
				List<WebElement> keyColumnNo = driver.findElements(By.xpath("(//tbody[@class='ant-table-tbody'])[2]/tr/td[3]"));
				testRowCount = keyColumnNo.size();
				for (int j = 2; j <= testRowCount; j++) {
					Thread.sleep(1000);
					boolean check = driver.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[2]/tr[" + j+ "]/td[3]/label/span/input")).isSelected();
					if (check == true) {
						WebElement test = driver.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[2]/tr["+ j + "]/td[1]"));
						String testName = test.getText();
						arr.add(testName);

					}
				}
			} catch (NoSuchElementException e) {

			}
			try {
				WebElement cancel = driver.findElement(By.xpath("//div[@class='ant-modal-footer']/div/button[1]"));
				Thread.sleep(500);
				cancel.click();
			} catch (NoSuchElementException e) {
				CommonMethods.TestCasePrint("Cancel Button Not There");
			}
			System.out.println(arr.size() );
			if(arr.size()>0) {
			String firstString = arr.get(0);
			}
//			:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
			
					String text = null;
					try {
						text = driver.findElement(By.xpath(NameXpath_firstPart + k + "]/td[" + nameColumnNo + "]")).getText();
					} catch (NoSuchElementException e) {
						TestCasePrint("Searched Element Not There");
					}
					Thread.sleep(500);
					if (text.contains(searchQuery)) {
						num = k;
						Thread.sleep(500);

						try {
							driver.findElement(By.xpath(NameXpath_firstPart + k + "]/td[" + TestTrialColumnNo + "]/span"))
									.click();
						} catch (NoSuchElementException e) {
							TestCasePrint("Clicked Element Not There");
						}
						
				}
				

			System.err.println(arr);
			Thread.sleep(2000);
			try {
				testCount = driver.findElements(By.xpath("//div[@class='ant-ribbon-wrapper']")).size();
			} catch (Exception e) {
				// TODO: handle exception
			}
			int keyTestCount = arr.size();
			
			
			if(keyTestCount>=0) {
			for (int k = 0; k < keyTestCount; k++) {
				for (int j = 1; j <= testCount; j++) {
					Thread.sleep(1000);
					String testname =null;
					String ketTestNAme=null;
					String key=null;
try {
	//				get Test Name
	testname = driver.findElement(By.xpath("//div[@class='sc-bxivhb hSswcz']/div[" + j + "]/div[1]/div/li"))
			.getText();
} catch (Exception e) {
}
					Thread.sleep(1000);
					
					 try {
						ketTestNAme = arr.get(k);
					} catch (Exception e) {
					}
					 
					 
					 try {
						key = ketTestNAme + "  ";
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.out.println(testname+"!!!"+key+"!!!");
					if(testname.equalsIgnoreCase(key)) {
						System.err.println(testname+"!!!"+key+"!!!");
						String teststatus=null;
						
						 try {
							teststatus = driver
									.findElement(
											By.xpath("//div[@class='sc-bxivhb hSswcz']/div[" + j + "]/div[2]/span/div"))
									.getText();
						} catch (Exception e) {
						}
						if (teststatus.contentEquals("NEW")) {
							newKeyTest = newKeyTest + 1;
						} else if (teststatus.contentEquals("PROCESS")) {
							processKeyTest = processKeyTest + 1;
  
						} else if (teststatus.contentEquals("PASS")) {
							passKeyTest = passKeyTest + 1;

						} else if (teststatus.contentEquals("FAIL")) {
							failKeyTest = failKeyTest + 1;
					} 
						
				
}
			}
			
			}



			for (int k = 1; k <= testCount; k++) {
				String testname=null;
				String teststatus=null;
				Thread.sleep(500); 
try {
	//				get Test Name
	testname = driver.findElement(By.xpath("//div[@class='sc-bxivhb hSswcz']/div[" + k + "]/div[1]/div/li"))
			.getText();
	
} catch (Exception e) {
}
				try {
					
					teststatus = driver
							.findElement(By.xpath("//div[@class='sc-bxivhb hSswcz']/div[" + k + "]/div[2]/span/div"))
							.getText();
				} catch (Exception e) {
					// TODO: handle exception
				//				System.out.println(teststatus);
				boolean testKey = true;
				if (teststatus.contentEquals("NEW")) { 
					newStatus = newStatus + 1;

				} else if (teststatus.contentEquals("PROCESS")) {
					processStatus = processStatus + 1;

				} else if (teststatus.contentEquals("PASS")) {
					passStatus = passStatus + 1;

				} else if (teststatus.contentEquals("FAIL")) { 
					failStatus = failStatus + 1;
									}
//				System.out.println(testKey);

			}
			try {
				WebElement cancel = driver.findElement(By.xpath("//div[@class='ant-modal-footer']/button[1]"));
				Thread.sleep(500);
				cancel.click();
			} catch (NoSuchElementException e) {
				CommonMethods.TestCasePrint("Cancel Button Not There");
			}
			try {
				WebElement status = driver
						.findElement(By.xpath(NameXpath_firstPart + num + "]/td[" + StatusColumnNo + "]/span/span/p"));
				Thread.sleep(500);
				value = status.getText();
			} catch (NoSuchElementException e) {
				TestCasePrint("Status Element Not There");
			} 
			totalKeyTest=newKeyTest+processKeyTest+passKeyTest+failKeyTest;
			totalNonKeyTest = testCount - totalKeyTest;
			newNonKeyTest = newStatus - newKeyTest;
			processNonKeyTest = processStatus - processKeyTest;
			passNonKeyTest = passStatus - passKeyTest;
			failNonKeyTest = failStatus - failKeyTest;

			System.out.println("Total Test : " + testCount);
			System.out.println("Total Key Test : " + totalKeyTest);
			System.out.println("Total Non-Key Test : " + totalNonKeyTest);
			System.out.println("newStatus : " + newStatus);
			System.out.println("processStatus : " + processStatus);
			System.out.println("passStatus : " + passStatus);
			System.out.println("failStatus : " + failStatus);
			System.out.println("newKeyTest : " + newKeyTest);
			System.out.println("newNonKeyTest : " + newNonKeyTest);
			System.out.println("processKeyTest : " + processKeyTest);
			System.out.println("processNonKeyTest : " + processNonKeyTest);
			System.out.println("passKeyTest : " + passKeyTest);
			System.out.println("passNonKeyTest : " + passNonKeyTest);
			System.out.println("failKeyTest : " + failKeyTest);
			System.out.println("failNonKeyTest : " + failNonKeyTest);
			if (testCount == 0) {
				// System.out.println("Dont Have Test to this Sample");
				TestCasePrint("NO TESTS FOR THIS SAMPLE (" + searchQuery + ")", "NEW", String.valueOf(value));
			} else {
				if (testCount == newStatus + processStatus && passStatus == 0 && failStatus == 0) {
					TestCasePrint("NO ANY TESTS NOT COMPLETED FOR THIS SAMPLE (" + searchQuery + ")", "NEW", String.valueOf(value));
					// System.out.println("sample status should new");
				} else if (failKeyTest >= 1) {
					// System.out.println("sample status should be fail");
					TestCasePrint("KEY TESTS FAIL FOR THIS SAMPLE (" + searchQuery + ")", "FAIL", String.valueOf(value));
				} else if (totalKeyTest == passKeyTest && totalKeyTest != 0) {
					// System.out.println("sample status should be pass");
					TestCasePrint("ALL KEY TESTS ARE PASS FOR THIS SAMPLE (" + searchQuery + ")", "PASS", String.valueOf(value));
				} else {
					// System.out.println("sample status should be process");
					TestCasePrint("SAMPLE PROCESS STATUS FOR THIS SAMPLE (" + searchQuery + ")", "PROCESS", String.valueOf(value));
				}
			}
			arr.clear();
			System.out.println(arr);
			testCount = 0;
			newStatus = 0;
			processStatus = 0;
			passStatus = 0;
			failStatus = 0;
			newKeyTest = 0;
			newNonKeyTest = 0;
			processKeyTest = 0;
			processNonKeyTest = 0;
			passKeyTest = 0;
			passNonKeyTest = 0;
			failKeyTest = 0;
			failNonKeyTest = 0;
			totalKeyTest = 0;
			totalNonKeyTest = 0;
			Thread.sleep(1000);
			driver.findElement(By.xpath(
					"//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']/li[@title='1']")).click();
	
					}
			}
			}
		}
	}



	public static void TestCasePrint(String TestCaseName) throws InterruptedException {
		TestCasePrint(TestCaseName, null, null, null);
	}

	public static void TestCasePrint(String TestCaseName, Object expectedValue, Object actualValue)
			throws InterruptedException {
		TestCasePrint(TestCaseName, expectedValue, actualValue, null);
	}

	public static void TestCasePrint(String TestCaseName, Object expectedValue, Object actualValue, String Explanation)
			throws InterruptedException {
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
				testCase.log(Status.INFO, "Total TestCount : " + testCount);
				Thread.sleep(500);
				if (1 <= newStatus) {
					if (newKeyTest != 0) {
						testCase.log(Status.INFO, "New Status Key Test TestCount : " + newKeyTest);
					}
					if (newNonKeyTest != 0) {
						testCase.log(Status.INFO, "New Status Non-Key Test TestCount : " + newNonKeyTest);
					}
				}
				Thread.sleep(500);
				if (1 <= processStatus) {
					if (processKeyTest != 0) {
						testCase.log(Status.INFO, "Process Status Key Test TestCount : " + processKeyTest);
					}
					if (processNonKeyTest != 0) {
						testCase.log(Status.INFO, "Process Status Non Key Test TestCount : " + processNonKeyTest);
					}
				}
				Thread.sleep(500);
				if (1 <= passStatus) {
					if (passKeyTest != 0) {
						testCase.log(Status.INFO, "Pass Status Key Test TestCount : " + passKeyTest);
					}
					if (passNonKeyTest != 0) {
						testCase.log(Status.INFO, "Pass Status Non Key Test TestCount : " + passNonKeyTest);
					}
				}
				Thread.sleep(500);
				if (1 <= failStatus) {
					if (failKeyTest != 0) {
						testCase.log(Status.INFO, "Fail Status Key Test TestCount : " + failKeyTest);
					}
					if (failNonKeyTest != 0) {
						testCase.log(Status.INFO, "Fail Status Non Key Test TestCount : " + failNonKeyTest);
					}
				}
				testCase.log(Status.INFO, "Actual Sample Status : " + actualValue.toString());
				testCase.log(Status.INFO, "Expected Sample Status : " + expectedValue.toString());
				testCase.log(Status.PASS, "TEST PASS âœ…");
				if (Explanation != null) {
					testCase.log(Status.INFO, Explanation);
				}

			} else {
				testCase.log(Status.INFO, "Total TestCount : " + testCount);
				Thread.sleep(500);
				if (1 <= newStatus) {
					if (newKeyTest != 0) {
						testCase.log(Status.INFO, "New Status Key Test TestCount : " + newKeyTest);
					}
					if (newNonKeyTest != 0) {
						testCase.log(Status.INFO, "New Status Non-Key Test TestCount : " + newNonKeyTest);
					}
				}
				Thread.sleep(500);
				if (1 <= processStatus) {
					if (processKeyTest != 0) {
						testCase.log(Status.INFO, "Process Status Key Test TestCount : " + processKeyTest);
					}
					if (processNonKeyTest != 0) {
						testCase.log(Status.INFO, "Process Status Non Key Test TestCount : " + processNonKeyTest);
					}
				}
				Thread.sleep(500);
				if (1 <= passStatus) {
					if (passKeyTest != 0) {
						testCase.log(Status.INFO, "Pass Status Key Test TestCount : " + passKeyTest);
					}
					if (passNonKeyTest != 0) {
						testCase.log(Status.INFO, "Pass Status Non Key Test TestCount : " + passNonKeyTest);
					}
				}
				Thread.sleep(500);
				if (1 <= failStatus) {
					if (failKeyTest != 0) {
						testCase.log(Status.INFO, "Fail Status Key Test TestCount : " + failKeyTest);
					}
					if (failNonKeyTest != 0) {
						testCase.log(Status.INFO, "Fail Status Non Key Test TestCount : " + failNonKeyTest);
					}
				}
				testCase.log(Status.INFO, "Actual Sample Status : " + actualValue.toString());
				testCase.log(Status.INFO, "Expected Sample Status : " + expectedValue.toString());
				testCase.log(Status.FAIL, "TEST FAIL â�Œ");

				if (Explanation != null) {
					testCase.log(Status.INFO, Explanation);
				}
			}
		} else {
			ExtentTest testCase = extent.createTest(TestCaseName);
//				testCase.log(Status.INFO, TestCaseName);
		}

	}
}

