package com.qa.automation.qdms.sample.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;

public class Paginationmethods extends DriverIntialization {
	static int BeforeCount = 0;
	static int AfterCount = 0;
	static boolean validation = true;
	static String searchMaterial = "day";
	static int actualElementCount = 0;
	Actions actions = new Actions(driver);
	static boolean ExpectedDefaultPageIndex = true;
	static boolean ExpectedRefreshDefaultIndexPage = true;
	static boolean ExpectedPageDirect = true;
	static boolean ExpectedVisiblePreviousButton = true;
	static boolean ExpectedVisibleNextButton = true;
	static boolean ExpectedNextBtnEnable = true;
	static boolean ExpectedPreviousBtnDisable = false;
	static boolean AfterMovetoSecPagepreButEnable = true;
	static int ExpectedTotalPage5 = 0;
	static int ExpectedTotalPage10 = 0;
	static int ExpectedTotalPage20 = 0;
	static int ExpectedTotalPage30 = 0;
	static int ExpectedTotalPage50 = 0;
	static int ExpectedTotalPage100 = 0;
	static boolean ExpectedTextVisible = false;
	static String tobepick = null;
	static String beforeedit = null;
	public static void pagination(String excelworkbook,String tab,String TestId, WebElement PreviousPageBtn, WebElement NextPageBtn,
			WebElement PaginationSecoundPage, WebElement PaginationfirstPage, WebElement PageDropdown,
			String Pagebefore, int size, String pageafter,String COMMENT) throws InterruptedException, IOException {
		//***********************************************************************
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\"+ excelworkbook+".xlsx";
		String excelSheetName = tab;
		String testCaseId = TestId;

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			
			ExpectedTotalPage10 = (int) row.getCell(1).getNumericCellValue();
			ExpectedTotalPage20 = (int) row.getCell(2).getNumericCellValue();
			ExpectedTotalPage30 = (int) row.getCell(3).getNumericCellValue();
			ExpectedTotalPage100 = (int) row.getCell(4).getNumericCellValue();

		}
		
		
		//**********************************************************************
		testCase = extent.createTest(COMMENT +"PAGINATION FUNCTIONALITY");
		try {
			boolean value1 = PreviousPageBtn.isDisplayed();
			testCase = extent.createTest( "STEP-01 Checking Previous Button Dispaly");
			try {
				Assert.assertEquals(value1, ExpectedVisiblePreviousButton);
				testCase.log(Status.INFO, "ActualElement :- " + value1);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisiblePreviousButton);
				testCase.log(Status.INFO, "Element Available");
				testCase.log(Status.PASS, "Correct element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualElement :- " + value1);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisiblePreviousButton);
				testCase.log(Status.INFO, "Element not available");
				testCase.log(Status.FAIL, "Not Visible Element");
			}
			
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("STEP-04 Checking Previous Button Dispaly is failed because of no element");
			
		}
		try {boolean value2 = NextPageBtn.isDisplayed();
		testCase = extent.createTest( "STEP-02 Checking Next Button Dispaly");
		try {
			Assert.assertEquals(value2, ExpectedVisibleNextButton);
			testCase.log(Status.INFO, "ActualElement :- " + value2);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisibleNextButton);
			testCase.log(Status.INFO, "Element Available");
			testCase.log(Status.PASS, "Correct element");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualElement :- " + value2);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisibleNextButton);
			testCase.log(Status.INFO, "Element not available");
			testCase.log(Status.FAIL, "Not Visible Element");
		}
		} catch (Exception e) {testCase.log(Status.FAIL, "No Element");
		testCase = extent.createTest("STEP-05 CHecking Next Button Dispaly is failed because of no element");

		}
		try {Thread.sleep(2000);
		boolean value3 = PaginationfirstPage
				.isDisplayed();

		testCase = extent.createTest("STEP-03 Checking Default Index Page");
		try {
			Assert.assertEquals(value3, ExpectedDefaultPageIndex);
			testCase.log(Status.INFO, "Actual Default Index Page :- " + value3);
			testCase.log(Status.INFO, "Expected Default Index Page :- " + ExpectedDefaultPageIndex);
			testCase.log(Status.PASS, "Correct Default Index Page");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual Default Index Page :- " + value3);
			testCase.log(Status.INFO, "Expected Default Index Page:- " + ExpectedDefaultPageIndex);
			testCase.log(Status.FAIL, "Wrong Default Index Page");

		}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("STEP-01 Checking Default Index Page Failed because of no Element");
		}
		try {

			NextPageBtn.click();
			Thread.sleep(2000);
			boolean value4 = PaginationSecoundPage.isDisplayed();
			boolean ExpectedPageDirect = true;
			testCase = extent.createTest("STEP-04 Checking Page Redriect to the next page");
			try {
				Assert.assertEquals(value4, ExpectedPageDirect);
				testCase.log(Status.INFO, "Actual Default Index Page :- " + value4);
				testCase.log(Status.INFO, "Expected Default Index Page :- " + ExpectedPageDirect);
				testCase.log(Status.PASS, "Correct Default Index Page");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Default Index Page :- " + value4);
				testCase.log(Status.INFO, "Expected Default Index Page:- " + ExpectedPageDirect);
				testCase.log(Status.FAIL, "Wrong Default Index Page");
			}

		} catch (Exception e) {testCase.log(Status.FAIL, "No Element");
		testCase = extent
				.createTest(" STEP-03 Checking Page Redriect to the next page is Failed because of no element");

		}
		try {
			

			driver.navigate().refresh();
			Thread.sleep(2000);
			boolean value5 = PaginationfirstPage.isDisplayed();

			testCase = extent.createTest("STEP-05 Checking Default Index Page after Refresh");
			try {
				Assert.assertEquals(value5, ExpectedRefreshDefaultIndexPage);
				testCase.log(Status.INFO, "Actual Default Index Page :- " + value5);
				testCase.log(Status.INFO, "Expected Default Index Page :- " + ExpectedRefreshDefaultIndexPage);
				testCase.log(Status.PASS, "Correct Default Index Page");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Default Index Page :- " + value5);
				testCase.log(Status.INFO, "Expected Default Index Page:- " + ExpectedRefreshDefaultIndexPage);
				testCase.log(Status.FAIL, "Wrong Default Index Page");
			}

		} catch (Exception e) {testCase.log(Status.FAIL, "No Element");
		testCase = extent
				.createTest("STEP-02 Checking Default Index Page after Refresh is Failed because of no element");

		}
		try {
			
			Thread.sleep(2000);
			
			boolean value6 = PreviousPageBtn.isEnabled();
			testCase = extent.createTest("STEP-06 Checking Before navigate to 2 Page Previous Button is Disabled");
			try {
				Assert.assertEquals(value6, ExpectedPreviousBtnDisable);
				testCase.log(Status.INFO, "ActualElement :- " + value6);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedPreviousBtnDisable);
				testCase.log(Status.PASS, "Enable element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualElement :- " + value6);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedPreviousBtnDisable);
				testCase.log(Status.FAIL, "Not Enable Element");
			}
		} catch (Exception e) {testCase.log(Status.FAIL, "No Element");
		testCase = extent.createTest(
				"STEP-07 Checking Before navigate to 2 Page Previous Button is Disabledc is failed because of no element");

		}
		//***********************************************************
		try {
			NextPageBtn.click();
			Thread.sleep(2000);
			boolean value6 = PreviousPageBtn.isEnabled();
			boolean AfterMovetoSecPagepreButEnable = true;
			testCase = extent
					.createTest("STEP-07 Checking After Navigate to the Seconfd Page Previous button Enabled");
			try {
				Assert.assertEquals(value6, AfterMovetoSecPagepreButEnable);
				testCase.log(Status.INFO, "ActualElement :- " + value6);
				testCase.log(Status.INFO, "ExpectedElement :- " + AfterMovetoSecPagepreButEnable);
				testCase.log(Status.PASS, "Enable element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualElement :- " + value6);
				testCase.log(Status.INFO, "ExpectedElement :- " + AfterMovetoSecPagepreButEnable);
				testCase.log(Status.FAIL, "Not Enable Element");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest(
					"STEP-08 Checking After Navigate to the Seconfd Page Previous button Enabled is failed because of no element");
		}

		driver.navigate().refresh();
		Thread.sleep(3000);
	
		
		//**********************************************************

		

		System.out.println(size);
		for (int j = 1; j <= size; j++) {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			PageDropdown.click();
			Thread.sleep(4000);
			System.out.println(Pagebefore + j + pageafter +"*****************");
			WebElement Page = driver.findElement(By.xpath(Pagebefore + j + pageafter));
			Page.click();
        
			 Thread.sleep(2000);
			int ActualTotalPage = 1;
			boolean Enablity = NextPageBtn.isEnabled();
			while (Enablity) {
				Thread.sleep(2000);
				NextPageBtn.click();
				ActualTotalPage = ActualTotalPage + 1;

				Enablity = NextPageBtn.isEnabled();
				Thread.sleep(1000);
				System.out.println(ActualTotalPage+"*****************");
				 try {
					wait.until(ExpectedConditions.invisibilityOfAllElements(NextPageBtn));
				} catch (Exception e) {
					
				}
				Enablity = NextPageBtn.isEnabled();			
				System.out.println(Enablity+"////////////");
			}
			System.out.println(ActualTotalPage);
			
			WebElement pags= driver.findElement(By.xpath("//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']/li/div"));
			if (pags.getText().contentEquals("10 / page")) {
				System.out.println(Page.getText());
				testCase = extent.createTest("STEP-09 Checking Total Page for 10 Data per page");
				try {
					Assert.assertEquals(ActualTotalPage, ExpectedTotalPage10);
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+Page.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage10);
					testCase.log(Status.PASS, "Correct Page Count");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+ PageDropdown.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage10);
					testCase.log(Status.FAIL, "Wrong Page Count");
				}

			} else if (pags.getText().contentEquals("20 / page")) {
				testCase = extent.createTest("STEP-10 Checking Total Page for 20 Data per page");
				try {
					Assert.assertEquals(ActualTotalPage, ExpectedTotalPage20);
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+ Page.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage20);
					testCase.log(Status.PASS, "Correct Page Count");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+ Page.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage20);
					testCase.log(Status.FAIL, "Wrong Page Count");
				}

			} else if (pags.getText().contentEquals("30 / page")) {
				testCase = extent.createTest("STEP-11 Checking Total Page for 30 Data per page");
				try {
					Assert.assertEquals(ActualTotalPage, ExpectedTotalPage30);
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+Page.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage30);
					testCase.log(Status.PASS, "Correct Page Count");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+ Page.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage30);
					testCase.log(Status.FAIL, "Wrong Page Count");
				}

			} else if (pags.getText().contentEquals("100 / page")) {
				testCase = extent.createTest("STEP-13 Checking Total Page for 100 Data per page");
				try {
					Assert.assertEquals(ActualTotalPage, ExpectedTotalPage100);
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+ Page.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage100);
					testCase.log(Status.PASS, "Correct Page Count");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+ Page.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage100);
					testCase.log(Status.FAIL, "Wrong Page Count");
				}

			} else if (pags.getText().contentEquals("5 / page")) {
				testCase = extent.createTest("STEP-8 Checking Total Page for 5 Data per page");
				try {
					Assert.assertEquals(ActualTotalPage, ExpectedTotalPage5);
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+ Page.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage5);
					testCase.log(Status.PASS, "Correct Page Count");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+ Page.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage5);
					testCase.log(Status.FAIL, "Wrong Page Count");
				}

			}else if (pags.getText().contentEquals("50 / page")) {
				testCase = extent.createTest("STEP-12 Checking Total Page for 5 Data per page");
				try {
					Assert.assertEquals(ActualTotalPage, ExpectedTotalPage50);
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+ Page.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage50);
					testCase.log(Status.PASS, "Correct Page Count");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+ Page.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage50);
					testCase.log(Status.FAIL, "Wrong Page Count");
				}

			}

			driver.navigate().refresh();
			Thread.sleep(2000);

		}

	}

	
	public static void paginationmodify(String excelworkbook,String tab,String TestId, WebElement PreviousPageBtn, WebElement NextPageBtn,
			WebElement PaginationSecoundPage, WebElement PaginationfirstPage, WebElement PageDropdown,
			String Pagebefore, int size, String pageafter,String COMMENT) throws InterruptedException, IOException {
		//***********************************************************************
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\"+ excelworkbook+".xlsx";
		String excelSheetName = tab;
		String testCaseId = TestId;

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			
			ExpectedTotalPage10 = (int) row.getCell(2).getNumericCellValue();
			ExpectedTotalPage20 = (int) row.getCell(3).getNumericCellValue();
			ExpectedTotalPage30 = (int) row.getCell(4).getNumericCellValue();
			ExpectedTotalPage50 = (int) row.getCell(5).getNumericCellValue();
			ExpectedTotalPage5 = (int) row.getCell(1).getNumericCellValue();
			ExpectedTotalPage100 = (int) row.getCell(6).getNumericCellValue();

		}
		
		
		//**********************************************************************
		testCase = extent.createTest(COMMENT +"PAGINATION FUNCTIONALITY");
		try {
			boolean value1 = PreviousPageBtn.isDisplayed();
			testCase = extent.createTest( "STEP-01 Checking Previous Button Dispaly");
			try {
				Assert.assertEquals(value1, ExpectedVisiblePreviousButton);
				testCase.log(Status.INFO, "ActualElement :- " + value1);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisiblePreviousButton);
				testCase.log(Status.INFO, "Element Available");
				testCase.log(Status.PASS, "Correct element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualElement :- " + value1);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisiblePreviousButton);
				testCase.log(Status.INFO, "Element not available");
				testCase.log(Status.FAIL, "Not Visible Element");
			}
			
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("STEP-04 Checking Previous Button Dispaly is failed because of no element");
			
		}
		try {boolean value2 = NextPageBtn.isDisplayed();
		testCase = extent.createTest( "STEP-02 Checking Next Button Dispaly");
		try {
			Assert.assertEquals(value2, ExpectedVisibleNextButton);
			testCase.log(Status.INFO, "ActualElement :- " + value2);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisibleNextButton);
			testCase.log(Status.INFO, "Element Available");
			testCase.log(Status.PASS, "Correct element");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualElement :- " + value2);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisibleNextButton);
			testCase.log(Status.INFO, "Element not available");
			testCase.log(Status.FAIL, "Not Visible Element");
		}
		} catch (Exception e) {testCase.log(Status.FAIL, "No Element");
		testCase = extent.createTest("STEP-05 CHecking Next Button Dispaly is failed because of no element");

		}
		try {Thread.sleep(2000);
		boolean value3 = PaginationfirstPage
				.isDisplayed();

		testCase = extent.createTest("STEP-03 Checking Default Index Page");
		try {
			Assert.assertEquals(value3, ExpectedDefaultPageIndex);
			testCase.log(Status.INFO, "Actual Default Index Page :- " + value3);
			testCase.log(Status.INFO, "Expected Default Index Page :- " + ExpectedDefaultPageIndex);
			testCase.log(Status.PASS, "Correct Default Index Page");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual Default Index Page :- " + value3);
			testCase.log(Status.INFO, "Expected Default Index Page:- " + ExpectedDefaultPageIndex);
			testCase.log(Status.FAIL, "Wrong Default Index Page");

		}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("STEP-01 Checking Default Index Page Failed because of no Element");
		}
		try {

			NextPageBtn.click();
			Thread.sleep(2000);
			boolean value4 = PaginationSecoundPage.isDisplayed();
			boolean ExpectedPageDirect = true;
			testCase = extent.createTest("STEP-04 Checking Page Redriect to the next page");
			try {
				Assert.assertEquals(value4, ExpectedPageDirect);
				testCase.log(Status.INFO, "Actual Default Index Page :- " + value4);
				testCase.log(Status.INFO, "Expected Default Index Page :- " + ExpectedPageDirect);
				testCase.log(Status.PASS, "Correct Default Index Page");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Default Index Page :- " + value4);
				testCase.log(Status.INFO, "Expected Default Index Page:- " + ExpectedPageDirect);
				testCase.log(Status.FAIL, "Wrong Default Index Page");
			}

		} catch (Exception e) {testCase.log(Status.FAIL, "No Element");
		testCase = extent
				.createTest(" STEP-03 Checking Page Redriect to the next page is Failed because of no element");

		}
		try {
			PaginationfirstPage.click();
			//driver.navigate().refresh();
			Thread.sleep(2000);
			boolean value5 = PaginationfirstPage.isDisplayed();

			testCase = extent.createTest("STEP-05 Checking Default Index Page after Refresh");
			try {
				Assert.assertEquals(value5, ExpectedRefreshDefaultIndexPage);
				testCase.log(Status.INFO, "Actual Default Index Page :- " + value5);
				testCase.log(Status.INFO, "Expected Default Index Page :- " + ExpectedRefreshDefaultIndexPage);
				testCase.log(Status.PASS, "Correct Default Index Page");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Default Index Page :- " + value5);
				testCase.log(Status.INFO, "Expected Default Index Page:- " + ExpectedRefreshDefaultIndexPage);
				testCase.log(Status.FAIL, "Wrong Default Index Page");
			}

		} catch (Exception e) {testCase.log(Status.FAIL, "No Element");
		testCase = extent
				.createTest("STEP-02 Checking Default Index Page after Refresh is Failed because of no element");

		}
		try {
			
			Thread.sleep(2000);
			
			boolean value6 = PreviousPageBtn.isEnabled();
			testCase = extent.createTest("STEP-06 Checking Before navigate to 2 Page Previous Button is Disabled");
			try {
				Assert.assertEquals(value6, ExpectedPreviousBtnDisable);
				testCase.log(Status.INFO, "ActualElement :- " + value6);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedPreviousBtnDisable);
				testCase.log(Status.PASS, "Enable element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualElement :- " + value6);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedPreviousBtnDisable);
				testCase.log(Status.FAIL, "Not Enable Element");
			}
		} catch (Exception e) {testCase.log(Status.FAIL, "No Element");
		testCase = extent.createTest(
				"STEP-07 Checking Before navigate to 2 Page Previous Button is Disabledc is failed because of no element");

		}
		//***********************************************************
		try {
			NextPageBtn.click();
			Thread.sleep(2000);
			boolean value6 = PreviousPageBtn.isEnabled();
			boolean AfterMovetoSecPagepreButEnable = true;
			testCase = extent
					.createTest("STEP-07 Checking After Navigate to the Seconfd Page Previous button Enabled");
			try {
				Assert.assertEquals(value6, AfterMovetoSecPagepreButEnable);
				testCase.log(Status.INFO, "ActualElement :- " + value6);
				testCase.log(Status.INFO, "ExpectedElement :- " + AfterMovetoSecPagepreButEnable);
				testCase.log(Status.PASS, "Enable element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualElement :- " + value6);
				testCase.log(Status.INFO, "ExpectedElement :- " + AfterMovetoSecPagepreButEnable);
				testCase.log(Status.FAIL, "Not Enable Element");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest(
					"STEP-08 Checking After Navigate to the Seconfd Page Previous button Enabled is failed because of no element");
		}

		PaginationfirstPage.click();
		//driver.navigate().refresh();
		Thread.sleep(3000);
	
		
		//**********************************************************

		

		System.out.println(size);
		for (int j = 1; j <= size; j++) {
			PageDropdown.click();
			Thread.sleep(4000);
			System.out.println(Pagebefore + j + pageafter +"*****************");
			WebElement Page = driver.findElement(By.xpath(Pagebefore + j + pageafter));
			Page.click();

			 Thread.sleep(2000);
			int ActualTotalPage = 1;
			boolean Enablity = NextPageBtn.isEnabled();
			while (Enablity) {
				Thread.sleep(2000);
				NextPageBtn.click();
				ActualTotalPage = ActualTotalPage + 1;
				Enablity = NextPageBtn.isEnabled();			
			}
			System.out.println(ActualTotalPage);
			
			WebElement pags= driver.findElement(By.xpath("//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']/li/div"));
			if (pags.getText().contentEquals("10 / page")) {
				System.out.println(Page.getText());
				testCase = extent.createTest("STEP-08 Checking Total Page for 10 Data per page");
				try {
					Assert.assertEquals(ActualTotalPage, ExpectedTotalPage10);
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+Page.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage10);
					testCase.log(Status.PASS, "Correct Page Count");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+ PageDropdown.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage10);
					testCase.log(Status.FAIL, "Wrong Page Count");
				}

			} else if (pags.getText().contentEquals("20 / page")) {
				testCase = extent.createTest("STEP-09 Checking Total Page for 20 Data per page");
				try {
					Assert.assertEquals(ActualTotalPage, ExpectedTotalPage20);
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+ Page.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage20);
					testCase.log(Status.PASS, "Correct Page Count");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+ Page.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage20);
					testCase.log(Status.FAIL, "Wrong Page Count");
				}

			} else if (pags.getText().contentEquals("30 / page")) {
				testCase = extent.createTest("STEP-10 Checking Total Page for 30 Data per page");
				try {
					Assert.assertEquals(ActualTotalPage, ExpectedTotalPage30);
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+Page.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage30);
					testCase.log(Status.PASS, "Correct Page Count");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+ Page.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage30);
					testCase.log(Status.FAIL, "Wrong Page Count");
				}

			} else if (pags.getText().contentEquals("100 / page")) {
				testCase = extent.createTest("STEP-11 Checking Total Page for 100 Data per page");
				try {
					Assert.assertEquals(ActualTotalPage, ExpectedTotalPage100);
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+ Page.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage100);
					testCase.log(Status.PASS, "Correct Page Count");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Current Pagination Opction :- "
							+ Page.getText());
					testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
					testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage100);
					testCase.log(Status.FAIL, "Wrong Page Count");
				}

			}
			PaginationfirstPage.click();
			//driver.navigate().refresh();
			Thread.sleep(2000);

		}

	}
}