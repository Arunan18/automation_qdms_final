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
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;

public class SampleStatus extends DriverIntialization {
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

	/**
	 * 
	 * @param WorkbookName      == Excel WorkBook Name
	 * @param TabName           == Excel Tab Name
	 * @param TestCaseId        == TestCase ID
	 * @param column            == Searched data column Xpath
	 * @param nameColumnNo      == search name column no
	 * @param StatusColumnNo    == status column no
	 * @param TestTrialColumnNo == test & results column no
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void sampleStatus(String WorkbookName, String TabName, String TestCaseId, List<WebElement> column,
			int nameColumnNo, int StatusColumnNo, int TestTrialColumnNo, String KeyBefore, String KeyAfter)
			throws InterruptedException, IOException {
		String workbooks = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + WorkbookName + ".xlsx";
		int firstrow = CommonMethods.getFirstRowNum(workbooks, TabName, TestCaseId);
		int lastrow = CommonMethods.getLastRowNum(workbooks, TabName, TestCaseId);
		System.out.println(firstrow + "  " + lastrow);
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
					NameXpath_firstPart = "//tbody[@class='ant-table-tbody']/tr[";
					String text = null;
					try {
						text = driver.findElement(By.xpath(NameXpath_firstPart + j + "]/td[" + nameColumnNo + "]"))
								.getText();
					} catch (NoSuchElementException e) {
						TestCasePrint("Searched Element Not There");
					}
					System.out.println(text);
					Thread.sleep(500);
					if (text.contains(searchQuery)) {
						num = j;
						Thread.sleep(500);
//						try {
//						WebElement status = driver.findElement(
//								By.xpath(NameXpath_firstPart + j + "]/td[" + StatusColumnNo + "]/span/span/p"));
//						Thread.sleep(500);
//						 value = status.getText();
//						 System.out.println(value+"##############");
//						}catch (NoSuchElementException e) {
//							TestCasePrint("Status Element Not There");
//						}
						Thread.sleep(500);

						try {
							System.out.println(NameXpath_firstPart + j + "]/td[" + TestTrialColumnNo + "]/span");
							Thread.sleep(1500);
							driver.findElement(
									By.xpath(NameXpath_firstPart + j + "]/td[" + TestTrialColumnNo + "]/span")).click();
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
				try {
					WebElement next = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"));
					clickNextPage = next.isEnabled();
					if (clickNextPage == true) {
						Thread.sleep(2000);
						next.click();
					}
				} catch (NoSuchElementException e) {
					TestCasePrint("Next Button Element Not There");
				}

			}

			Thread.sleep(500);
			testCount = driver.findElements(By.xpath("//div[@class='ant-ribbon-wrapper']")).size();
//		System.out.println(testCount);
			if (testCount >= 1) {
				for (int j = 1; j <= testCount; j++) {
					Thread.sleep(500);
//			get Test Name
					String testname = driver
							.findElement(By.xpath("//div[@class='sc-bxivhb hSswcz']/div[" + j + "]/div[1]/div/li"))
							.getText();
//				System.out.println(testname);
//			get Test Status
					String teststatus = driver
							.findElement(By.xpath("//div[@class='sc-bxivhb hSswcz']/div[" + j + "]/div[2]/span/div"))
							.getText();
//			System.out.println(teststatus);
					boolean testKey = true;
					if (teststatus.contentEquals("NEW")) {
						newStatus = newStatus + 1;
						try {
							System.out.println("!!!!!!!!!!!" + KeyBefore + j + KeyAfter);
							WebElement testKey1 = driver.findElement(By.xpath(KeyBefore + j + KeyAfter));
							Thread.sleep(500);
							System.out.println(testKey1.isDisplayed() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
							Assert.assertEquals(testKey1.isDisplayed(), true);
							testKey = true;
							newKeyTest = newKeyTest + 1;
							totalKeyTest = totalKeyTest + 1;
						} catch (AssertionError e) {
							testKey = false;
							newNonKeyTest = newNonKeyTest + 1;
							totalNonKeyTest = totalNonKeyTest + 1;
						} catch (NoSuchElementException e) {
							testKey = false;
							newNonKeyTest = newNonKeyTest + 1;
							totalNonKeyTest = totalNonKeyTest + 1;
						}

					} else if (teststatus.contentEquals("PROCESS")) {
						processStatus = processStatus + 1;
						try {
							WebElement testKey1 = driver.findElement(By.xpath(KeyBefore + j + KeyAfter));
							Assert.assertEquals(testKey1.isDisplayed(), true);
							testKey = true;
							processKeyTest = processKeyTest + 1;
							totalKeyTest = totalKeyTest + 1;
						} catch (AssertionError e) {
							testKey = false;
							processNonKeyTest = processNonKeyTest + 1;
							totalNonKeyTest = totalNonKeyTest + 1;
						} catch (NoSuchElementException e) {
							testKey = false;
							processNonKeyTest = processNonKeyTest + 1;
							totalNonKeyTest = totalNonKeyTest + 1;
						}
					} else if (teststatus.contentEquals("PASS")) {
						passStatus = passStatus + 1;
						try {
							WebElement testKey1 = driver.findElement(By.xpath(KeyBefore + j + KeyAfter));
							Assert.assertEquals(testKey1.isDisplayed(), true);
							testKey = true;
							passKeyTest = passKeyTest + 1;
							totalKeyTest = totalKeyTest + 1;
						} catch (AssertionError e) {
							testKey = false;
							passNonKeyTest = passNonKeyTest + 1;
							totalNonKeyTest = totalNonKeyTest + 1;
						} catch (NoSuchElementException e) {
							testKey = false;
							passNonKeyTest = passNonKeyTest + 1;
							totalNonKeyTest = totalNonKeyTest + 1;
						}
					} else if (teststatus.contentEquals("FAIL")) {
						failStatus = failStatus + 1;
						try {
							WebElement testKey1 = driver.findElement(By.xpath(KeyBefore + j + KeyAfter));
							Assert.assertEquals(testKey1.isDisplayed(), true);
							testKey = true;
							failKeyTest = failKeyTest + 1;
							totalKeyTest = totalKeyTest + 1;
						} catch (AssertionError e) {
							testKey = false;
							failNonKeyTest = failNonKeyTest + 1;
							totalNonKeyTest = totalNonKeyTest + 1;
						} catch (NoSuchElementException e) {
							testKey = false;
							failNonKeyTest = failNonKeyTest + 1;
							totalNonKeyTest = totalNonKeyTest + 1;
						}
					}
//			System.out.println(testKey);

				}
			} else {
				CommonMethods.TestCasePrint("Dont have any test to this sample");
				System.out.println("Dont have any test to this sample");
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
				System.out.println(value + "##############");
			} catch (NoSuchElementException e) {
				TestCasePrint("Status Element Not There");
			}
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
					TestCasePrint("NO ANY TESTS NOT COMPLETED FOR THIS SAMPLE (" + searchQuery + ")", "NEW",
							String.valueOf(value));
					// System.out.println("sample status should new");
				} else if (failKeyTest >= 1) {
					// System.out.println("sample status should be fail");
					TestCasePrint("KEY TESTS FAIL FOR THIS SAMPLE (" + searchQuery + ")", "FAIL",
							String.valueOf(value));
				} else if (totalKeyTest == passKeyTest && totalKeyTest != 0) {
					// System.out.println("sample status should be pass");
					TestCasePrint("ALL KEY TESTS ARE PASS FOR THIS SAMPLE (" + searchQuery + ")", "PASS",
							String.valueOf(value));
				} else {
					// System.out.println("sample status should be process");
					TestCasePrint("SAMPLE PROCESS STATUS FOR THIS SAMPLE (" + searchQuery + ")", "PROCESS",
							String.valueOf(value));
				}
			}
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
			driver.findElement(By.xpath(
					"//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']/li[@title='1']")).click();
			Thread.sleep(2000);
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
				testCase.log(Status.INFO, "New Status TestCount : " + newStatus);
				testCase.log(Status.INFO, "Process Status TestCount : " + processStatus);
				testCase.log(Status.INFO, "Pass Status TestCount : " + passStatus);
				testCase.log(Status.INFO, "Fail Status TestCount : " + failStatus);
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
				testCase.log(Status.PASS, "TEST PASS ✅");
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
				testCase.log(Status.FAIL, "TEST FAIL ❌");

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
