// ***********************************************************************************
// * Description
// *------------
// * Unit Pagination Functionality
// ***********************************************************************************
// *
// * Author : Priyanka Sundaramoorthy
// * Date Written : 22/02/2023
// *
// *
// *
// * Test Case Number Date Intis Comments
// * ================ ==== ===== ========
// * 22/02/2023 Priyanka Orginal Version
// *
// ************************************************************************************

package com.qa.automation.qdms.testcases.unit;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.SbuPage;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class UnitMethods extends DriverIntialization {
	static int BeforeCount = 0;
	static int AfterCount = 0;
	static boolean validation = true;
	static String searchMaterial = "day";
	static int actualElementCount = 0;
	Actions actions = new Actions(driver);
	static boolean ExpectedDefaultPageIndex = false;
	static boolean ExpectedRefreshDefaultIndexPage = false;
	static boolean ExpectedPageDirect = false;
	static boolean ExpectedVisiblePreviousButton = false;
	static boolean ExpectedVisibleNextButton = false;
	static boolean ExpectedNextBtnEnable = false;
	static boolean ExpectedPreviousBtnDisable = true;
	static boolean AfterMovetoSecPagepreButEnable = false;
	static int ExpectedTotalPage = 0;
	static int ExpectedTotalPage20 = 0;
	static int ExpectedTotalPage30 = 0;
	static int ExpectedTotalPage100 = 0;
	static boolean ExpectedTextVisible = false;
	static String tobepick = null;
	static String beforeedit = null;
	public static boolean beforeeditting = false;
	public static boolean clickdeleteicon = false;
	public static boolean afterDeleteConfirm = false;
	static DataFormatter dataValue = new DataFormatter();

	static com.qa.automation.qdms.pages.master.UnitPage UnitPage = new com.qa.automation.qdms.pages.master.UnitPage();

	@Test(priority = 0)
	public static void UnitPagination() throws InterruptedException {

		com.qa.automation.qdms.pages.master.UnitPage UnitPage = new com.qa.automation.qdms.pages.master.UnitPage();
		PageFactory.initElements(driver, UnitPage);

		try {

			com.qa.automation.qdms.pages.master.UnitPage.MaterialSub.click();
		}

		catch (NoSuchElementException e) {
			testCase = extent.createTest("Locate the 'Material Menu'");
			testCase.log(Status.INFO, "Unable to Locate 'Material Menu'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Click on the 'Material Menu'");
			testCase.log(Status.INFO, "Unable to Click on 'Material Menu'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("Locate and Click on the 'Material Menu'");
			testCase.log(Status.INFO, "Unable to Locate and Click on 'Material Menu'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

		try {

			com.qa.automation.qdms.pages.master.UnitPage.unit.click();
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Locate the 'Unit Menu'");
			testCase.log(Status.INFO, "Unable to Locate 'Unit Menu'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Click on the 'Unit Menu'");
			testCase.log(Status.INFO, "Unable to Click on 'Unit Menu'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("Locate and Click on the 'Unit Menu'");
			testCase.log(Status.INFO, "Unable to Locate and Click on 'Unit Menu'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void Excel() throws IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Unit";
		String testCaseId = "TC-UNIT-0014";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			ExpectedDefaultPageIndex = (Boolean) row.getCell(1).getBooleanCellValue();
			ExpectedRefreshDefaultIndexPage = (Boolean) row.getCell(2).getBooleanCellValue();
			ExpectedPageDirect = (Boolean) row.getCell(3).getBooleanCellValue();
			ExpectedVisiblePreviousButton = (Boolean) row.getCell(4).getBooleanCellValue();
			ExpectedVisibleNextButton = (Boolean) row.getCell(5).getBooleanCellValue();
			ExpectedNextBtnEnable = (Boolean) row.getCell(6).getBooleanCellValue();
			ExpectedPreviousBtnDisable = (Boolean) row.getCell(7).getBooleanCellValue();
			AfterMovetoSecPagepreButEnable = (Boolean) row.getCell(8).getBooleanCellValue();
			ExpectedTotalPage = (int) row.getCell(9).getNumericCellValue();
			ExpectedTotalPage20 = (int) row.getCell(10).getNumericCellValue();
			ExpectedTotalPage30 = (int) row.getCell(11).getNumericCellValue();
			ExpectedTotalPage100 = (int) row.getCell(12).getNumericCellValue();

		}
	}

	@Test(priority = 1)
	public static void DefaultIndexPage(String colname) throws InterruptedException {
		try {

			Thread.sleep(2000);
			boolean ActualDefaultPageIndex = com.qa.automation.qdms.pages.master.UnitPage.DefaultPaginationPage
					.isDisplayed();

			testCase = extent.createTest(colname + "Checking Default Index Page");
			try {
				Assert.assertEquals(ActualDefaultPageIndex, ExpectedDefaultPageIndex);
				testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualDefaultPageIndex);
				testCase.log(Status.INFO, "Expected Default Index Page :- " + ExpectedDefaultPageIndex);
				testCase.log(Status.PASS, "Correct Default Index Page");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualDefaultPageIndex);
				testCase.log(Status.INFO, "Expected Default Index Page:- " + ExpectedDefaultPageIndex);
				testCase.log(Status.FAIL, "Wrong Default Index Page");

			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("STEP-01 Checking Default Index Page Failed because of no Element");
		}
	}

	// **********************************************************************************
	// Checking Default Index Page after Refresh %%%%%%% AUTHOR : PRIYANKA
	// SUNDARAMOORTHY
	// **********************************************************************************

	@Test(priority = 2)
	public static void RefreshDefaultPage(String colname) throws InterruptedException {
		try {

			com.qa.automation.qdms.pages.master.UnitPage.NextPageBtn.click();

			driver.navigate().refresh();
			Thread.sleep(2000);
			boolean ActualDefaultPageIndex1 = com.qa.automation.qdms.pages.master.UnitPage.DefaultPaginationPage
					.isDisplayed();

			testCase = extent.createTest(colname + "Checking Default Index Page after Refresh");
			try {
				Assert.assertEquals(ActualDefaultPageIndex1, ExpectedRefreshDefaultIndexPage);
				testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualDefaultPageIndex1);
				testCase.log(Status.INFO, "Expected Default Index Page :- " + ExpectedRefreshDefaultIndexPage);
				testCase.log(Status.PASS, "Correct Default Index Page");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualDefaultPageIndex1);
				testCase.log(Status.INFO, "Expected Default Index Page:- " + ExpectedRefreshDefaultIndexPage);
				testCase.log(Status.FAIL, "Wrong Default Index Page");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent
					.createTest("STEP-02 Checking Default Index Page after Refresh is Failed because of no element");
		}
	}

	// **********************************************************************************
	// Checking Page Redirect to the next page %%%%%%% AUTHOR : PRIYANKA
	// SUNDARAMOORTHY
	// **********************************************************************************
	@Test(priority = 3)
	public static void PageRedrict(String colname) throws InterruptedException {
		try {

			com.qa.automation.qdms.pages.master.UnitPage.NextPageBtn.click();
			Thread.sleep(2000);
			boolean ActualSecoundPageIndex = com.qa.automation.qdms.pages.master.UnitPage.PaginationSecoundPage
					.isDisplayed();
			boolean ExpectedPageDirect = true;
			testCase = extent.createTest(colname + "Checking Page Redriect to the next page");
			try {
				Assert.assertEquals(ActualSecoundPageIndex, ExpectedPageDirect);
				testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualSecoundPageIndex);
				testCase.log(Status.INFO, "Expected Default Index Page :- " + ExpectedPageDirect);
				testCase.log(Status.PASS, "Correct Default Index Page");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualSecoundPageIndex);
				testCase.log(Status.INFO, "Expected Default Index Page:- " + ExpectedPageDirect);
				testCase.log(Status.FAIL, "Wrong Default Index Page");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent
					.createTest(" STEP-03 Checking Page Redriect to the next page is Failed because of no element");
		}
	}

	// **********************************************************************************
	// Checking Previous Button Display %%%%%%% AUTHOR : PRIYANKA SUNDARAMOORTHY
	// **********************************************************************************
	@Test(priority = 4)
	public static void PreButtonDispaly(String colname) throws InterruptedException {
		try {
			// UnitPaginationPages UnitPage = new UnitPaginationPages();
			boolean ActualVisiblePreviousButton = com.qa.automation.qdms.pages.master.UnitPage.PreviousPageBtn
					.isDisplayed();

			testCase = extent.createTest(colname + "Checking Previous Button Dispaly");
			try {
				Assert.assertEquals(ActualVisiblePreviousButton, ExpectedVisiblePreviousButton);
				testCase.log(Status.INFO, "ActualElement :- " + ActualVisiblePreviousButton);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisiblePreviousButton);
				testCase.log(Status.INFO, "Element Available");
				testCase.log(Status.PASS, "Correct element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualElement :- " + ActualVisiblePreviousButton);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisiblePreviousButton);
				testCase.log(Status.INFO, "Element not available");
				testCase.log(Status.FAIL, "Not Visible Element");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("STEP-04 Checking Previous Button Dispaly is failed because of no element");
		}
	}

	// **********************************************************************************
	// Checking Next Button Display %%%%%%% AUTHOR : PRIYANKA SUNDARAMOORTHY
	// **********************************************************************************
	@Test(priority = 5)
	public static void NextButtonDispaly(String colname) throws InterruptedException {
		try {
			// UnitPaginationPages UnitPage = new UnitPaginationPages();
			boolean ActualVisibleNextButton = com.qa.automation.qdms.pages.master.UnitPage.NextPageBtn.isDisplayed();

			testCase = extent.createTest(colname + "Checking Next Button Dispaly");
			try {
				Assert.assertEquals(ActualVisibleNextButton, ExpectedVisibleNextButton);
				testCase.log(Status.INFO, "ActualElement :- " + ActualVisibleNextButton);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisibleNextButton);
				testCase.log(Status.INFO, "Element Available");
				testCase.log(Status.PASS, "Correct element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualElement :- " + ActualVisibleNextButton);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisibleNextButton);
				testCase.log(Status.INFO, "Element not available");
				testCase.log(Status.FAIL, "Not Visible Element");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("STEP-05 CHecking Next Button Dispaly is failed because of no element");
		}
	}

	// Next Button Enable
	@Test(priority = 6)
	public static void NextButtonEanble() throws InterruptedException {
		try {
			boolean ActualNextBtnEnable = com.qa.automation.qdms.pages.master.UnitPage.NextPageBtn.isEnabled();

			testCase = extent.createTest("STEP-06 Checking Next Button Enable");
			try {
				Assert.assertEquals(ActualNextBtnEnable, ExpectedNextBtnEnable);
				testCase.log(Status.INFO, "ActualElement :- " + ActualNextBtnEnable);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedNextBtnEnable);
				testCase.log(Status.PASS, "Enable element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualElement :- " + ActualNextBtnEnable);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedNextBtnEnable);
				testCase.log(Status.FAIL, "Not Enable Element");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("STEP-06 Checking Next Button Enable is failed because of no element");
		}
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);

	}

	// **********************************************************************************
	// Checking Before navigate to 2 Page Previous Button is Disabled %%%%%%% AUTHOR
	// : PRIYANKA SUNDARAMOORTHY
	// **********************************************************************************
	@Test(priority = 7)
	public static void SecPagepreButDisable(String colname) throws InterruptedException {
		try {
			Thread.sleep(3000);
			boolean ActualPreviousBtnDisable = com.qa.automation.qdms.pages.master.UnitPage.PreviousPageBtn.isEnabled();

			testCase = extent.createTest(colname + "Checking Before navigate to 2 Page Previous Button is Disabled");
			try {
				Assert.assertEquals(ActualPreviousBtnDisable, ExpectedPreviousBtnDisable);
				testCase.log(Status.INFO, "ActualElement :- " + ActualPreviousBtnDisable);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedPreviousBtnDisable);
				testCase.log(Status.PASS, "Enable element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualElement :- " + ActualPreviousBtnDisable);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedPreviousBtnDisable);
				testCase.log(Status.FAIL, "Not Enable Element");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest(
					"STEP-07 Checking Before navigate to 2 Page Previous Button is Disabledc is failed because of no element");
		}

	}

	// **********************************************************************************
	// Checking After Navigate to the Second Page Previous button Enabled %%%%%%%
	// AUTHOR : PRIYANKA SUNDARAMOORTHY
	// **********************************************************************************
	@Test(priority = 8)
	public static void AfterMovetoSecPagepreButEnable(String colname) throws InterruptedException {
		try {
			com.qa.automation.qdms.pages.master.UnitPage.NextPageBtn.click();
			Thread.sleep(2000);
			boolean ActualPreviousBtnEnable = com.qa.automation.qdms.pages.master.UnitPage.PreviousPageBtn.isEnabled();
			boolean AfterMovetoSecPagepreButEnable = true;
			testCase = extent
					.createTest(colname + "Checking After Navigate to the Seconfd Page Previous button Enabled");
			try {
				Assert.assertEquals(ActualPreviousBtnEnable, AfterMovetoSecPagepreButEnable);
				testCase.log(Status.INFO, "ActualElement :- " + ActualPreviousBtnEnable);
				testCase.log(Status.INFO, "ExpectedElement :- " + AfterMovetoSecPagepreButEnable);
				testCase.log(Status.PASS, "Enable element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualElement :- " + ActualPreviousBtnEnable);
				testCase.log(Status.INFO, "ExpectedElement :- " + AfterMovetoSecPagepreButEnable);
				testCase.log(Status.FAIL, "Not Enable Element");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest(
					"STEP-08 Checking After Navigate to the Seconfd Page Previous button Enabled is failed because of no element");
		}

		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@Test(priority = 10)
	public static void TotalPages() throws InterruptedException {

		String DataCountText = com.qa.automation.qdms.pages.master.UnitPage.paginationCount.getText();
		System.out.println(DataCountText);
		Pattern pattern = Pattern.compile("\\d+ of (\\d+)");
		Matcher matcher = pattern.matcher(DataCountText);
		if (matcher.find()) {
			String pageCount = matcher.group(1);
			System.out.println("Total pages: " + pageCount);

			int Expected = 97;
			testCase = extent.createTest("STEP-9 Checking Total Page for 10 Data per page");
			try {
				Assert.assertEquals(pageCount, Expected);
				testCase.log(Status.INFO, "ActualElement :- " + pageCount);
				testCase.log(Status.INFO, "ExpectedElement :- " + Expected);
				testCase.log(Status.PASS, "Enable element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualElement :- " + pageCount);
				testCase.log(Status.INFO, "ExpectedElement :- " + Expected);
				testCase.log(Status.FAIL, "Not Enable Element");
			}
		}
		// //testCase = extent.createTest("STEP-09 -PAGINATION-TOTAL-COUNT:" +
		// ActualTotalPage );
	}
	//

	// ****************************************************************************************
	// STEP-01--MATERIAL TAB IS DISPLAYED & STEP-02--MATERIAL TAB IS ENABLED
	// ****************************************************************************************

	public static void materialtopTab() {
		if (com.qa.automation.qdms.pages.master.UnitPage.materialTab.isDisplayed()) {
			testCase = extent.createTest("STEP-01--MATERIAL TAB IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (com.qa.automation.qdms.pages.master.UnitPage.materialTab.isEnabled()) {
				testCase = extent.createTest("STEP-02--MATERIAL TAB IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				com.qa.automation.qdms.pages.master.UnitPage.materialTab.click();

			} else {
				testCase = extent.createTest("STEP-02--MATERIAL TAB IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-01--MATERIAL TAB IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
	}

	// ****************************************************************************************
	// STEP-03--UNIT BUTTON IS DISPLAYED & STEP-04--UNIT BUTTON IS ENABLED
	// ****************************************************************************************
	public static void UnitleftButton() {
		if (com.qa.automation.qdms.pages.master.UnitPage.UnitLeftButton.isDisplayed()) {
			testCase = extent.createTest("STEP-03--MATERIAL BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (com.qa.automation.qdms.pages.master.UnitPage.UnitLeftButton.isEnabled()) {
				testCase = extent.createTest("STEP-04--MATERIAL BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				com.qa.automation.qdms.pages.master.UnitPage.UnitLeftButton.click();

			} else {
				testCase = extent.createTest("STEP-04--MATERIAL BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-03--MATERIAL BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

	}

	// ****************************************************************************************
	// Next page
	// ****************************************************************************************
	public static void Navigate(int page) {
		for (int i = 0; i < page; i++) {
			try {
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				Thread.sleep(2000);
			} catch (Exception e) {
			}
		}
	}

	// ****************************************************************************************
	// STEP-05--UNIT SEARCH ICON IS DISPLAYED & STEP-06--UNIT SEARCH ICON IS ENABLED
	// ****************************************************************************************
	public static void SearchIcon() {
		if (driver.findElement(By.xpath("//span[@role='button']")).isDisplayed()) {
			testCase = extent.createTest("STEP-05--UNIT SEARCH ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath("//span[@role='button']")).isEnabled()) {
				testCase = extent.createTest("STEP-06--UNIT SEARCH ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					driver.findElement(By.xpath("//span[@role='button']")).click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest("STEP-06--UNIT SEARCH ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-05--UNIT SEARCH ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

	}

	// ************************************************************************************************************
	// STEP-07--CHECKING UNIT SEARCH TEXTBOX DISPLAYED & STEP-08--CHECKING UNIT
	// SEARCH TEXTBOX ENABLED
	// ************************************************************************************************************
	public static void SearchTextbox(String testdata, String colname, String colname1) {
		if (com.qa.automation.qdms.pages.master.UnitPage.SearchBox.isDisplayed()) {

			testCase = extent.createTest(colname + "SEARCH TEXTBOX IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (com.qa.automation.qdms.pages.master.UnitPage.SearchBox.isEnabled()) {
				testCase = extent.createTest(colname1 + "SEARCH TEXTBOX ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					com.qa.automation.qdms.pages.master.UnitPage.SearchBox.sendKeys(testdata);

					// driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

					Thread.sleep(3000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest(colname1 + "SEARCH TEXTBOX ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + "SEARCH TEXTBOX IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

	}

	// ************************************************************************************************************
	// STEP-08--CHECKING UNIT SEARCH BUTTON DISPLAYED & STEP-09--CHECKING UNIT
	// SEARCH BUTTON ENABLED
	// ************************************************************************************************************
	public static void UnitSearchButton(String colname, String colname1) throws InterruptedException, IOException {

		if (driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']")).isDisplayed()) {
			testCase = extent.createTest(colname + "SEARCH BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']")).isEnabled()) {
				testCase = extent.createTest(colname1 + "STEP-10--SEARCH BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']")).click();
					String Plant = driver.findElement(By.xpath(
							"//body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[5]/span[1]/mark[1]"))
							.getText();
					System.out.println("PPPPP " + Plant);
					String TextBox1 = driver.findElement(By.xpath("//input[@placeholder='Plant']"))
							.getAttribute("value");
					System.out.println("text box  " + TextBox1);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest(colname1 + "SEARCH BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + "SEARCH BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
		// *************************************************************************************************************************

		boolean clickNextPage = true;

		boolean passorfail = true;
		ArrayList<String> actualList = new ArrayList<String>();
		ArrayList<String> expectedList = new ArrayList<String>();
		String nameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String nameXpath_lastPart = "]/td[1]";
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					String textFull = driver.findElement(By.xpath(nameXpath_firstPart + i + nameXpath_lastPart))
							.getText();
					String text = textFull.toLowerCase();
					// System.out.println(text);
					try {
						if (!text.contains(searchMaterial)) {
							passorfail = false;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (text.contains(searchMaterial)) {
						expectedList.add(text);
					}
					actualList.add(text);
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
		// driver.navigate().refresh();
		Thread.sleep(3000);
		com.qa.automation.qdms.pages.master.UnitPage.UnitSearchIcon.click();
		Thread.sleep(3000);

	}

	// ******************************************************************************************************************
	// STEP-10--SINGLE SEARCH CONFIRM
	// ******************************************************************************************************************

	public static void SingleSearchConfirm(String colname, int expected) {
		try {
			int Value = actualElementCount;
			System.out.println(Value);
			// testCasePrint(colname + "SINGLE SEARCH CONFIRM", String.valueOf(Value));
			try {
				Assert.assertEquals(Value, expected);
				testCase.log(Status.INFO, "ActualElement :- " + Value);
				testCase.log(Status.INFO, "ExpectedElement :- " + expected);
				testCase.log(Status.PASS, "Enable element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualElement :- " + Value);
				testCase.log(Status.INFO, "ExpectedElement :- " + expected);
				testCase.log(Status.FAIL, "Not Enable Element");
			}
		} catch (Exception e) {

		}
		driver.quit();
	}

	public static void SingleSearchMidConfirm() {
		try {
			int Value = actualElementCount;
			System.out.println(Value);
			// testCasePrint("STEP-11--SINGLE SEARCH CONFIRM", "1", String.valueOf(Value));
		} catch (Exception e) {

		}
		driver.quit();
	}

	// ******************************************************************************************************************
	// Checking total pages for 10,20,30,100 data per page
	// ******************************************************************************************************************
	public static void Pages(String colname, String colname1, String colname2, String colname3)
			throws InterruptedException {

		// Thread.sleep(2000);
		int ActualTotalPage = 1;
		boolean Enablity = com.qa.automation.qdms.pages.master.UnitPage.NextPageBtn.isEnabled();
		while (Enablity) {
			Thread.sleep(1000);
			com.qa.automation.qdms.pages.master.UnitPage.NextPageBtn.click();
			ActualTotalPage = ActualTotalPage + 1;
			Enablity = com.qa.automation.qdms.pages.master.UnitPage.NextPageBtn.isEnabled();
		}
		System.out.println(ActualTotalPage);
		Thread.sleep(2000);

		if (com.qa.automation.qdms.pages.master.UnitPage.CurrentPaginationOpction.getText()
				.contentEquals("10 / page")) {

			testCase = extent.createTest(colname + "Checking Total Page for 10 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage);
				testCase.log(Status.INFO, "Current Pagination Opction :- "
						+ com.qa.automation.qdms.pages.master.UnitPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Current Pagination Opction :- "
						+ com.qa.automation.qdms.pages.master.UnitPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (com.qa.automation.qdms.pages.master.UnitPage.CurrentPaginationOpction.getText()
				.contentEquals("20 / page")) {

			testCase = extent.createTest(colname1 + "Checking Total Page for 20 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage20);
				testCase.log(Status.INFO, "Current Pagination Opction :- "
						+ com.qa.automation.qdms.pages.master.UnitPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage20);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Current Pagination Opction :- "
						+ com.qa.automation.qdms.pages.master.UnitPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage20);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (com.qa.automation.qdms.pages.master.UnitPage.CurrentPaginationOpction.getText()
				.contentEquals("30 / page")) {

			testCase = extent.createTest(colname2 + "Checking Total Page for 30 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage30);
				testCase.log(Status.INFO, "Current Pagination Opction :- "
						+ com.qa.automation.qdms.pages.master.UnitPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage30);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Current Pagination Opction :- "
						+ com.qa.automation.qdms.pages.master.UnitPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage30);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (com.qa.automation.qdms.pages.master.UnitPage.CurrentPaginationOpction.getText()
				.contentEquals("100 / page")) {

			testCase = extent.createTest(colname3 + "Checking Total Page for 100 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage100);
				testCase.log(Status.INFO, "Current Pagination Opction :- "
						+ com.qa.automation.qdms.pages.master.UnitPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage100);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Current Pagination Opction :- "
						+ com.qa.automation.qdms.pages.master.UnitPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage100);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}

		}

		driver.navigate().refresh();
		Thread.sleep(2000);

	}

	@Test(priority = 11)
	public static void TotalPage() throws InterruptedException {

		String DataCountText = com.qa.automation.qdms.pages.master.UnitPage.paginationcount.getText();
		int ExpectedPageCount = 84;
		System.out.println(DataCountText);
		Pattern pattern = Pattern.compile("\\d+ of (\\d+)");
		Matcher matcher = pattern.matcher(DataCountText);
		if (matcher.find()) {
			String pageCount = matcher.group(1);
			double Value = Integer.parseInt(pageCount) / 10;
			int Finalvalue = (int) Math.ceil(Value);
			System.out.println("Total pages: " + Finalvalue);

			testCase = extent.createTest("PAGINATION-TOTAL-PAGE-COUNT");
			try {
				Assert.assertEquals(Finalvalue, ExpectedPageCount);
				testCase.log(Status.INFO, "Current Pagination Opction :- "
						+ com.qa.automation.qdms.pages.master.UnitPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + Finalvalue);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedPageCount);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Current Pagination Opction :- "
						+ com.qa.automation.qdms.pages.master.UnitPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + Finalvalue);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedPageCount);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}

		}
	}

	// ************************************************************************

	public static void CheckValidation() throws IOException, InterruptedException {
		testCase = extent.createTest("SCRIPT-04 - UNIT-VALIDATION-FUNCTIONALITY");

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Unit";
		String testCaseId = "TC-UNIT-0022";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			String sbu = (String) row.getCell(1).getStringCellValue();
			String validation = (String) row.getCell(2).getStringCellValue();
			String Message = (String) row.getCell(3).getStringCellValue();

			Thread.sleep(1000);

			com.qa.automation.qdms.pages.master.UnitPage.UnitTextbox.sendKeys(sbu);
			com.qa.automation.qdms.pages.master.UnitPage.UnitSaveButton.click();
			Thread.sleep(1000);
			String ActualValidation = com.qa.automation.qdms.pages.master.UnitPage.validationmsg.getText();
			System.out.println(ActualValidation);
			String ExpectedValidation = validation;
			testCase = extent.createTest("Check " + Message);
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass " + Message + "Script");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("High Priority");
			}

			Thread.sleep(2000);
			com.qa.automation.qdms.pages.master.UnitPage.UnitTextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			Thread.sleep(2000);

		}

		com.qa.automation.qdms.pages.master.UnitPage.CancelBtn.click();

	}

	// *****************************************************************************

	// Edit Functionality

	public static void search(String colname) throws InterruptedException, IOException {
		beforeeditting = false;
		Thread.sleep(3000);
		String Name = colname;
		String NameXpath_firstPart = "//tbody[@class='ant-table-tbody']/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[2]/span/a[1]/span";
		// *[@id="root"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[6]/td[9]/span/a/span
		boolean clickNextPage = true;
		boolean sbuExist = false;
		Thread.sleep(3000);
		while (clickNextPage) {
			for (int i = 2; i < 102; i++) {
				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(Name)) {
						sbuExist = true;
						if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).isDisplayed()) {

							testCase = extent.createTest("STEP-01-CHECKING EDIT ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");

							if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart))
									.isEnabled()) {

								testCase = extent.createTest("STEP-02-CHECKING EDIT ICON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");
								try {
									driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();

									beforeeditting = true;

								} catch (NoSuchElementException e) {
									testCase = extent.createTest("Locate the ' Unit Edit Icon'");
									testCase.log(Status.INFO, "Unable to Locate 'Unit Edit Icon'");
									testCase.log(Status.FAIL, "TEST FAIL ❎");
								} catch (ElementClickInterceptedException e) {
									testCase = extent.createTest("Click on the 'Unit Edit Icon'");
									testCase.log(Status.INFO, "Unable to Click on 'Unit Edit Icon'");
									testCase.log(Status.FAIL, "TEST FAIL ❎");
								} catch (Exception e) {
									testCase = extent.createTest("Locate and Click on the 'Unit Edit Icon'");
									testCase.log(Status.INFO, "Unable to Locate and Click on 'Unit Edit Icon'");
									testCase.log(Status.FAIL, "TEST FAIL ❎");
								}
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

	// MiddlePage Edit

	public static void Midsearch() throws InterruptedException, IOException {
		Thread.sleep(3000);
		String Name = "test01";
		String NameXpath_firstPart = "//tbody[@class='ant-table-tbody']/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[2]/span/a[1]/span";
		// *[@id="root"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[6]/td[9]/span/a/span
		boolean clickNextPage = true;
		boolean sbuExist = false;
		Thread.sleep(3000);
		while (clickNextPage) {
			for (int i = 2; i < 102; i++) {
				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(Name)) {
						sbuExist = true;
						if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).isDisplayed()) {

							testCase = extent.createTest("STEP-01-CHECKING EDIT ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");

							if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart))
									.isEnabled()) {

								testCase = extent.createTest("STEP-02-CHECKING EDIT ICON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");
								Thread.sleep(3000);
								driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
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

	// ++++++++++++++++++++++++++++++++++++++++++++++++

	public static void Aftersearch(String colname, String colname1, String colname2)
			throws InterruptedException, IOException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		String Name = colname;
		String NameXpath_firstPart = "//tbody[@class='ant-table-tbody']/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[2]/span/a[1]/span";

		boolean clickNextPage = true;
		boolean sbuExist = false;
		Thread.sleep(3000);
		while (clickNextPage) {
			for (int i = 2; i < 102; i++) {
				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(Name)) {
						sbuExist = true;
						if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).isDisplayed()) {

							testCase = extent.createTest(colname1 + "CHECKING EDIT ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");

							if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart))
									.isEnabled()) {

								testCase = extent.createTest(colname2 + "CHECKING EDIT ICON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");
								Thread.sleep(3000);
								driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
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

	public static void TestCasePrint(String TestCaseName, Object expectedValue, Object actualValue) {
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
			testCase.log(Status.PASS, "TEST PASS ☑");
		} else {
			testCase.log(Status.INFO, "Actual value: " + actualValue.toString());
			testCase.log(Status.INFO, "Expected value: " + expectedValue.toString());
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	// **********************************************************************************************************************
	// STEP-06-- CONFIRM THE EDIT
	// **********************************************************************************************************************
	public static void nameconfirm(String colname, String colname1) throws InterruptedException, IOException {
		// String cofirmname = EditPlantPage.plantname.getText();
		// System.out.println("Confirm the Name " + cofirmname);
		try {
			Thread.sleep(4000);
			String Value = ((WebElement) com.qa.automation.qdms.pages.master.UnitPage.EditUnitTextbox)
					.getAttribute("value");

			TestCasePrint(colname1 + "CONFIRM THE EDIT", colname, String.valueOf(Value));

		} catch (Exception e) {
			TestCasePrint("CONFIRM THE EDIT", colname, String.valueOf(e));
		}
		try {
			com.qa.automation.qdms.pages.master.UnitPage.CancelBtn.click();

		} catch (Exception e) {
			testCase = extent.createTest("Locate and Click on the 'Unit Edit Cancle Button'");
			testCase.log(Status.INFO, "Unable to Locate and Click on 'Unit Edit Cancle Button'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void MidAftersearch() throws InterruptedException, IOException {
		Thread.sleep(3000);
		String Name = "Changeeee";
		String NameXpath_firstPart = "//tbody[@class='ant-table-tbody']/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[2]/span/a[1]/span";
		// *[@id="root"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[6]/td[9]/span/a/span
		boolean clickNextPage = true;
		boolean sbuExist = false;
		Thread.sleep(3000);
		while (clickNextPage) {
			for (int i = 2; i < 102; i++) {
				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(Name)) {
						sbuExist = true;
						if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).isDisplayed()) {

							testCase = extent.createTest("STEP-07-CHECKING EDIT ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");

							if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart))
									.isEnabled()) {

								testCase = extent.createTest("STEP-08-CHECKING EDIT ICON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");
								Thread.sleep(3000);
								driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
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

	public static void Midnameconfirm() throws InterruptedException, IOException {

		try {
			Thread.sleep(4000);
			String Value = ((WebElement) com.qa.automation.qdms.pages.master.UnitPage.EditUnitTextbox)
					.getAttribute("value");

			TestCasePrint("STEP-09--CONFIRM THE EDIT", "Changeeee", String.valueOf(Value));

		} catch (Exception e) {
			TestCasePrint("CONFIRM THE EDIT", "Changeeee", String.valueOf(e));
		}
		Thread.sleep(2000);
		com.qa.automation.qdms.pages.master.UnitPage.CancelBtn.click();
	}

	public static void UnitEdit(String colname) throws InterruptedException, IOException {

		Thread.sleep(1500);
		try {
			com.qa.automation.qdms.pages.master.UnitPage.EditUnitTextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			com.qa.automation.qdms.pages.master.UnitPage.EditUnitTextbox.sendKeys(colname);

			testCase = extent.createTest("STEP-04 UNIT UPDATED SUCCESFULLY");
		} catch (Exception e) {
			testCase = extent.createTest("UNIT NAME IS NOT GET UPDATED");
		}
	}

	public static void UnitMidEdit() throws InterruptedException, IOException {

		Thread.sleep(1500);
		try {
			com.qa.automation.qdms.pages.master.UnitPage.EditUnitTextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			com.qa.automation.qdms.pages.master.UnitPage.EditUnitTextbox.sendKeys("Changeeee");
			testCase = extent.createTest("STEP-04 UNIT UPDATED SUCCESFULLY");
		} catch (Exception e) {
			testCase = extent.createTest("UNIT NAME IS NOT GET UPDATED");
		}
	}

	public static void beforeEdit(String colname) throws InterruptedException, IOException {

		PageFactory.initElements(driver, UnitPage);

		try {
			String Value = com.qa.automation.qdms.pages.master.UnitPage.EditUnitTextbox.getAttribute("value");

			TestCasePrint("STEP-03--CONFIRM BEFORE THE EDIT", colname, String.valueOf(Value));
		} catch (Exception e) {
			TestCasePrint("STEP-03--CONFIRM BEFORE THE EDIT", colname, String.valueOf(e));
		}

	}

	public static void beforeMidEdit() throws InterruptedException, IOException {
		try {
			String Value = com.qa.automation.qdms.pages.master.UnitPage.EditUnitTextbox.getAttribute("value");

			TestCasePrint("STEP-03--CONFIRM BEFORE THE EDIT", "test01", String.valueOf(Value));
		} catch (Exception e) {
			TestCasePrint("STEP-03--CONFIRM BEFORE THE EDIT", "test01", String.valueOf(e));
		}

	}

	// **********************************************************************************************************************
	// CONFIRM THE EDITED WILL BE IN THE FIRST ROW
	// **********************************************************************************************************************
	public static void editedFirstRow(String colname, String colname1) throws InterruptedException, IOException {
		try {
			com.qa.automation.qdms.pages.master.UnitPage.tableFirstRow.click();
			String Value = com.qa.automation.qdms.pages.master.UnitPage.EditUnitTextbox.getAttribute("value");

			System.out.println(Value);
			TestCasePrint(colname1 + "CONFIRM THE EDITED VALUE IN THE FIRST ROW", colname, String.valueOf(Value));
		} catch (Exception e) {
			TestCasePrint(colname1 + "CONFIRM THE EDITED VALUE IN THE FIRST ROW", colname, String.valueOf(e));
		}
	}

	// ************************************************************************************
	// Search the data for deletion (particular data)
	// ************************************************************************************

	public static void Deletesearch(String colname, String colname1, String colname2, String colname3)
			throws InterruptedException, IOException {

		PageFactory.initElements(driver, UnitPage);

		Deleteconfirm();

		String Name = colname;
		String NameXpath_firstPart = "//tbody[@class='ant-table-tbody']/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String DeleteXpath_firstPart = "//tbody/tr[";
		String DeleteXpath_lastPart = "]/td[2]/span[1]/a[2]/a[1]/span[1]//*[name()='svg']";

		// String DeleteOk = "/html/body/div[4]/div/div/div/div[2]/div/div[2]/button[2]"
		// ;
		// *[@id="root"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[6]/td[9]/span/a/span
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

							testCase = extent.createTest(colname1 + "CHECKING DELETE ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");

							if (driver.findElement(By.xpath(DeleteXpath_firstPart + i + DeleteXpath_lastPart))
									.isEnabled()) {

								testCase = extent.createTest(colname2 + "CHECKING DELETE ICON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");

								try {
									driver.findElement(By.xpath(DeleteXpath_firstPart + i + DeleteXpath_lastPart))
											.click();
								} catch (Exception e) {
									testCase = extent.createTest("Locate and Click On The Table Body");
									testCase.log(Status.INFO, "Unable to Locate Click on The Table Body");
									testCase.log(Status.FAIL, "TEST FAIL");
								}

								try {

									Thread.sleep(3000);

									com.qa.automation.qdms.pages.master.UnitPage.Deleteok.click();

									Thread.sleep(2000);

									String Actualmessage = driver
											.findElement(By.xpath("//div[@class='ant-notification-notice-message']"))
											.getText();

									System.out.println("&$^*&^^^^^^^^^^^^^^^*:" + Actualmessage);

									testCase = extent.createTest("UNIT DATA DELETED SUCCESFULLY");

									try {
										// ExpectedTextVisible=false;
										Assert.assertEquals(Actualmessage, colname3);
										testCase.log(Status.INFO, "Actual Visible :- " + Actualmessage);
										testCase.log(Status.INFO, "Expected Visible :- " + colname3);
										testCase.log(Status.PASS, " Correct");
									} catch (AssertionError e) {
										testCase.log(Status.INFO, "ActualVisible :- " + Actualmessage);
										testCase.log(Status.INFO, "Expected Visible :- " + colname3);
										testCase.log(Status.FAIL, "Wrong");
									}

									clickdeleteicon = true;
								}

								catch (Exception e) {
									testCase = extent.createTest("Locate and Click On The Table Body");
									testCase.log(Status.INFO, "Unable to Locate Click on The Table Body");
									testCase.log(Status.FAIL, "TEST FAIL");
								}

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
		if (sbuExist = false)

		{
			System.out.println("No such Element" + sbuExist);
		}

	}

	public static void Deletelastsearch() throws InterruptedException, IOException {
		String Name = "mg";
		String NameXpath_firstPart = "//tbody[@class='ant-table-tbody']/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String DeleteXpath_firstPart = "//tbody/tr[";
		String DeleteXpath_lastPart = "]/td[2]/span[1]/a[2]/a[1]/span[1]//*[name()='svg']";

		// String DeleteOk = "/html/body/div[4]/div/div/div/div[2]/div/div[2]/button[2]"
		// ;
		// *[@id="root"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[6]/td[9]/span/a/span
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

							testCase = extent.createTest("STEP-01-CHECKING DELETE ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");

							if (driver.findElement(By.xpath(DeleteXpath_firstPart + i + DeleteXpath_lastPart))
									.isEnabled()) {

								testCase = extent.createTest("STEP-02-CHECKING DELETE ICON IS ENABLED");
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

	// **********************************************************************************
	// Checking count before deletion
	// **********************************************************************************

	public static void Deleteconfirm() throws InterruptedException {

		//// ---------------------------------------------------------------------------------------
		//// Count Number of elemenets before search
		//// ---------------------------------------------------------------------------------------
		boolean clickNextPage = true;
		// int BeforeCount = 0;

		ArrayList<String> BeforestringList = new ArrayList<String>();

		String RowXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String RowXpath_lastPart = "]/td[1]";
		while (clickNextPage) {

			for (int i = 2; i < 103; i++) {

				try {
					String text = driver.findElement(By.xpath(RowXpath_firstPart + i + RowXpath_lastPart)).getText();
					// System.out.println(text);

					BeforestringList.add(text);
					BeforeCount = BeforeCount + 1;
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
		System.out.println("before count " + BeforeCount);
		System.out.println(BeforestringList);

	}

	public static void AfterDeleteconfirm() throws InterruptedException {
		driver.navigate().refresh();
		//// ---------------------------------------------------------------------------------------
		//// Count Number of elemenets before search
		//// ---------------------------------------------------------------------------------------
		boolean clickNextPage = true;
		// int AfterCount = 0;

		ArrayList<String> BeforestringList = new ArrayList<String>();

		String RowXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String RowXpath_lastPart = "]/td[1]";
		while (clickNextPage) {

			for (int i = 2; i < 103; i++) {

				try {
					String text = driver.findElement(By.xpath(RowXpath_firstPart + i + RowXpath_lastPart)).getText();
					// System.out.println(text);

					BeforestringList.add(text);
					AfterCount = AfterCount + 1;
					afterDeleteConfirm = true;

				} catch (Exception e) {
				}
			}
			if (clickNextPage == true) {
				clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				try {
					driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				} catch (Exception e) {
					testCase = extent.createTest("Locate and Click On The Table Body");
					testCase.log(Status.INFO, "Unable to Locate Click on The Table Body");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
				Thread.sleep(2000);
			} else {
				break;
			}
		}

		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println("After count " + AfterCount);
		System.out.println(BeforestringList);

	}

	// ************************************************************************************
	// Checking count after deletion
	// ************************************************************************************

	public static void DeleteEqu(String colname, Boolean colname1) throws InterruptedException {

		try {
			Thread.sleep(2000);
			// System.out.println("IsVisible");
			int aa = BeforeCount - 1;

			System.out.println("Output is" + aa);
			testCase = extent.createTest(colname + "CHECKING COUNT AFTER DELETION");
			try {
				// ExpectedTextVisible=false;
				// Assert.assertEquals(AfterCount, Boolean.getBoolean(colname));
				Assert.assertEquals(aa, AfterCount);
				testCase.log(Status.INFO, "Actual Visible :- " + aa);
				testCase.log(Status.INFO, "Expected Visible :- " + AfterCount);
				testCase.log(Status.PASS, " Unit deleted Succesfully");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualVisible :- " + aa);
				testCase.log(Status.INFO, "Expected Visible :- " + AfterCount);
				testCase.log(Status.FAIL, "Wrong");
			}
		} catch (Exception e) {
			testCase = extent.createTest("1-VISIBLE");
			testCase.log(Status.FAIL, "No element");
		}

		// AfterCount == BeforeCount - 1;

	}

	// **********************************************************************************
	// CHECKING ADD UNIT BUTTON VISIBLE AND ENABLE
	// **********************************************************************************

	public static void AddUnitButton(String colname, String colname1) throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.elementToBeClickable(com.qa.automation.qdms.pages.master.UnitPage.AddUnitButton));

		if (com.qa.automation.qdms.pages.master.UnitPage.AddUnitButton.isDisplayed()) {
			testCase = extent.createTest(colname + " BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (com.qa.automation.qdms.pages.master.UnitPage.AddUnitButton.isEnabled()) {
				testCase = extent.createTest(colname1 + " BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {

					com.qa.automation.qdms.pages.master.UnitPage.AddUnitButton.click();

					try {
						AddUnitSaveButton("STEP-03 CHECKING ADD UNIT SAVE", "STEP-04 CHECKNIG ADD UNIT SAVE");
					} catch (NoSuchElementException e) {
						testCase = extent.createTest("Locate the 'Unit Save Button'");
						testCase.log(Status.INFO, "Unable to Locate 'Unit Save Button'");
						testCase.log(Status.FAIL, "TEST FAIL ❎");
					} catch (ElementClickInterceptedException e) {
						testCase = extent.createTest("Click on the 'Unit Save Button'");
						testCase.log(Status.INFO, "Unable to Click on 'Unit Save Button'");
						testCase.log(Status.FAIL, "TEST FAIL ❎");
					} catch (Exception e) {
						testCase = extent.createTest("Locate and Click on the 'Unit Save Button'");
						testCase.log(Status.INFO, "Unable to Locate and Click on 'Unit Save Button'");
						testCase.log(Status.FAIL, "TEST FAIL ❎");
					}

				} catch (NoSuchElementException e) {
					testCase = extent.createTest("Locate the 'Add Unit Button'");
					testCase.log(Status.INFO, "Unable to Locate 'Add Unit Button'");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				} catch (ElementClickInterceptedException e) {
					testCase = extent.createTest("Click on the 'Add Unit Button'");
					testCase.log(Status.INFO, "Unable to Click on 'Add Unit Button'");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				} catch (Exception e) {
					testCase = extent.createTest("Locate and Click on the 'Add Unit Button'");
					testCase.log(Status.INFO, "Unable to Locate and Click on 'Add Unit Button'");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}

			} else {
				testCase = extent.createTest(colname1 + " BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + " BUTTON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	// **********************************************************************************
	// CHECKING ADD UNIT "SAVE" BUTTON VISIBLE AND ENABLE
	// **********************************************************************************

	public static void AddUnitSaveButton(String colname, String colname1) throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(
				ExpectedConditions.elementToBeClickable(com.qa.automation.qdms.pages.master.UnitPage.UnitSaveButton));

		if (com.qa.automation.qdms.pages.master.UnitPage.UnitSaveButton.isDisplayed()) {
			testCase = extent.createTest(colname + " BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (com.qa.automation.qdms.pages.master.UnitPage.UnitSaveButton.isEnabled()) {
				testCase = extent.createTest(colname1 + " BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");

			} else {
				testCase = extent.createTest(colname1 + " BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + " BUTTON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	// **********************************************************************************
	// CLICKING ADD UNIT SAVE BUTTON
	// **********************************************************************************

	public static void ClickAddUnitSaveButton() throws InterruptedException, IOException {

		com.qa.automation.qdms.pages.master.UnitPage.UnitSaveButton.click();

	}

	// *************************************************************************

	public static void UnitAddSaveButtonUI() throws InterruptedException {
		testCase = extent.createTest("STEP-06 CHECKING ADD UNIT SAVE BUTTON UI PROPERTIES");
		try {
			boolean ExpectedTextVisible = true;
			System.out.println("IsVisible");
			boolean ActualTextVisible = com.qa.automation.qdms.pages.master.UnitPage.UnitSaveButton.isDisplayed();
			testCase = extent.createTest("1-UNIT-SAVE-BUTTON-VISIBLE");
			try {
				// ExpectedTextVisible=false;
				Assert.assertEquals(ActualTextVisible, ExpectedTextVisible);
				testCase.log(Status.INFO, "Actual Visible :- " + ActualTextVisible);
				testCase.log(Status.INFO, "Expected Visible :- " + ExpectedTextVisible);
				testCase.log(Status.PASS, " Correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualVisible :- " + ActualTextVisible);
				testCase.log(Status.INFO, "Expected Visible :- " + ExpectedTextVisible);
				testCase.log(Status.FAIL, "Wrong");
			}
		} catch (Exception e) {
			testCase = extent.createTest("1-VISIBLE");
			testCase.log(Status.FAIL, "No element");
		}
	}
	// ***********************************************************************88

	public static void UnitUpdateButton(String colname, String colname1) throws InterruptedException {
		testCase = extent.createTest("STEP-05 CHECKING UPDATE BUTTON UI PROPERTIES");
		try {
			boolean ExpectedTextVisible = true;
			System.out.println("IsVisible");
			boolean ActualTextVisible = com.qa.automation.qdms.pages.master.UnitPage.UpdateButton.isDisplayed();
			testCase = extent.createTest("UNIT UPDATE BUTTON IS DISPLAYED");
			try {
				// ExpectedTextVisible=false;
				Assert.assertEquals(ActualTextVisible, ExpectedTextVisible);
				testCase.log(Status.INFO, "Actual Visible :- " + ActualTextVisible);
				testCase.log(Status.INFO, "Expected Visible :- " + ExpectedTextVisible);
				testCase.log(Status.PASS, " Correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualVisible :- " + ActualTextVisible);
				testCase.log(Status.INFO, "Expected Visible :- " + ExpectedTextVisible);
				testCase.log(Status.FAIL, "Wrong");
			}
		} catch (Exception e) {
			testCase = extent.createTest("1-VISIBLE");
			testCase.log(Status.FAIL, "No element");
		}

		// Employee Import Button FONT-COLOR

		try {
			String ActualTitleFontColor = com.qa.automation.qdms.pages.master.UnitPage.UpdateButton
					.getCssValue("color");
			System.out.println("Font color of button: " + ActualTitleFontColor);
			String ExpectedTitleFontColor = "rgba(255, 255, 255, 1)";
			testCase = extent.createTest("2.UNIT-UPDATE-BUTTON-FONT-COLOUR");

			try {
				AssertJUnit.assertEquals(ActualTitleFontColor, ExpectedTitleFontColor);
				testCase.log(Status.INFO, "ActualColour :- " + ActualTitleFontColor);
				testCase.log(Status.INFO, "ExpectedColour :- " + ExpectedTitleFontColor);
				testCase.log(Status.INFO, "Correct font Colour");
				testCase.log(Status.PASS, "Correct font Colour");

			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualColour :- " + ActualTitleFontColor);
				testCase.log(Status.INFO, "ExpectedColour :- " + ExpectedTitleFontColor);
				testCase.log(Status.INFO, "wrong font Colour");
				testCase.log(Status.FAIL, "wrong font Colour");
			}
		} catch (Exception e) {
			testCase = extent.createTest("2.UNIT-UPDATE-BUTTON-FONT-COLOUR");
			testCase.log(Status.FAIL, "No element");
		}

		// Employee Import Button FONTSIZE

		try {
			String ActualTitleFontsSize = com.qa.automation.qdms.pages.master.UnitPage.UpdateButton
					.getCssValue("font-size");
			System.out.println("Font Size: " + ActualTitleFontsSize);
			String ExpectedTitleFontsSize = "14px";
			testCase = extent.createTest("3.UNIT-UPDATE-BUTTON-FONT-SIZE");
			try {
				AssertJUnit.assertEquals(ActualTitleFontsSize, ExpectedTitleFontsSize);
				testCase.log(Status.INFO, "ActualfontSize :-" + ActualTitleFontsSize);
				testCase.log(Status.INFO, "ExpectedfontSize:-" + ExpectedTitleFontsSize);
				testCase.log(Status.PASS, "Correct font-size");
				testCase.log(Status.PASS, " Font-size Correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualfontsSize :- " + ActualTitleFontsSize);
				testCase.log(Status.INFO, "ExpectedfontsSize :- " + ExpectedTitleFontsSize);
				testCase.log(Status.INFO, "Wrong font-size");
				testCase.log(Status.FAIL, "Font-size Wrong");

			}
		} catch (Exception e) {
			testCase = extent.createTest("3.UNIT-UPDATE-BUTTON-FONT- SIZE");
			testCase.log(Status.FAIL, "No Element");
		}

		// Employee Import Button Font-Family

		try {
			String ActualElementfamily = com.qa.automation.qdms.pages.master.UnitPage.UpdateButton
					.getCssValue("font-family");
			System.out.println("FONT-FAMILY: " + ActualElementfamily);
			String ExpectedElementFamily = "Roboto, sans-serif";
			testCase = extent.createTest("4.UNIT-UPDATE-BUTTON-FONT-FAMILY");
			try {
				Assert.assertEquals(ActualElementfamily, ExpectedElementFamily);
				testCase.log(Status.INFO, "ActualText :- " + ActualElementfamily);
				testCase.log(Status.INFO, "ExpectedText :- " + ExpectedElementFamily);
				testCase.log(Status.PASS, "Correct Text");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualText :- " + ActualElementfamily);
				testCase.log(Status.INFO, "ExpectedText :- " + ExpectedElementFamily);
				testCase.log(Status.FAIL, "wrong Text");
			}
		} catch (Exception e) {
			testCase = extent.createTest("4.UNIT-UPDATE-BUTTON-FONT-FAMILY");
			testCase.log(Status.FAIL, "NO ELEMENT");
		}

		// Employee Import Button Spelling

		try {
			String AcctualTitleText = com.qa.automation.qdms.pages.master.UnitPage.UpdateButton.getText();
			String ExpectedTitleText = "Import";
			System.out.println(" Text:" + AcctualTitleText);
			testCase = extent.createTest("5.UNIT-UPDATE-BUTTON-SPELLING-TEXT");
			try {

				testCase.log(Status.INFO, "AcctualText :- " + AcctualTitleText);
				testCase.log(Status.INFO, "ExpectedText :- " + ExpectedTitleText);
				testCase.log(Status.PASS, "Correct element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "AcctualText :- " + AcctualTitleText);
				testCase.log(Status.INFO, "ExpectedText :- " + ExpectedTitleText);
				testCase.log(Status.FAIL, "Wrong Element");
			}
		} catch (Exception e) {
			testCase = extent.createTest("5.UNIT-UPDATE-BUTTON-SPELLING-TEXT");
			testCase.log(Status.FAIL, "No Element");
		}

		// Employee Import Button Position

		try {
			Point ActulalLocation = com.qa.automation.qdms.pages.master.UnitPage.UpdateButton.getLocation();
			int actual_x = ActulalLocation.getX();
			int actual_y = ActulalLocation.getY();
			System.out.println("X axis: " + actual_x);
			System.out.println("Y axis: " + actual_y);
			Point ExpectedLocation = new Point(792, 278);

			testCase = extent.createTest("6.UNIT-UPDATE-BUTTON-POSITION");
			try {
				AssertJUnit.assertEquals(ActulalLocation, ExpectedLocation);
				testCase.log(Status.INFO, "ActualFontSize :- " + ActulalLocation);
				testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedLocation);
				testCase.log(Status.PASS, "Correct Location");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualSize :- " + ActulalLocation);
				testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedLocation);
				testCase.log(Status.FAIL, "Wrong Location");
			}
		} catch (Exception e) {
			testCase = extent.createTest("6.UNIT-UPDATE-BUTTON-POSITION");
			testCase.log(Status.FAIL, "NO ELEMENT");

		}

		// Employee Import Button Padding

		try {
			String Actualpadding = com.qa.automation.qdms.pages.master.UnitPage.UpdateButton.getCssValue("padding");
			System.out.println("PADDING: " + Actualpadding);
			String Expectedpadding = "4px 15px";
			testCase = extent.createTest("7.UNIT-UPDATE-BUTTON-TEXT-PADDING");
			try {
				Assert.assertEquals(Actualpadding, Expectedpadding);
				testCase.log(Status.INFO, "Actual padding :- " + Actualpadding);
				testCase.log(Status.INFO, "Expected padding :- " + Expectedpadding);
				testCase.log(Status.PASS, "padding is Correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual padding :- " + Actualpadding);
				testCase.log(Status.INFO, "Expected padding :- " + Expectedpadding);
				testCase.log(Status.FAIL, "padding is Wrong");
			}
		} catch (Exception e) {
			testCase = extent.createTest("7.UNIT-UPDATE-BUTTON-PADDING");
			testCase.log(Status.FAIL, "NO ELEMENT");
		}

		try {
			String Actualbackground = com.qa.automation.qdms.pages.master.UnitPage.UpdateButton.getCssValue("color");
			System.out.println("BACKGROUND COLOR:" + Actualbackground);
			String Expectedbackground = "rgba(255, 255, 255, 1)";

			testCase = extent.createTest("8.UNIT-UPDATE-BUTTON-BACKGROUND COLOR");
			try {
				AssertJUnit.assertEquals(Actualbackground, Expectedbackground);

				testCase.log(Status.INFO, "Actualbackgroundcolor :- " + Actualbackground);
				testCase.log(Status.INFO, "Expectedbackgroundcolor :- " + Expectedbackground);
				testCase.log(Status.PASS, "correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actualbackgroundcolor :- " + Actualbackground);
				testCase.log(Status.INFO, "Expectedbackgroundcolor:- " + Expectedbackground);
				testCase.log(Status.FAIL, "wrong");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("8.UNIT-UPDATE-BUTTON-BACKGROUND COLOR");
		}

		// Employee Import Button BORDER COLOR
		try {
			String actualbordercolor = com.qa.automation.qdms.pages.master.UnitPage.UpdateButton
					.getCssValue("border-color");
			System.out.println(" border-color:" + actualbordercolor);
			String Expectedbordercolor = "rgb(255, 255, 255)";
			testCase = extent.createTest("9.UNIT-UPDATE-BUTTON-BORDER-COLOR");
			try {
				AssertJUnit.assertEquals(actualbordercolor, Expectedbordercolor);
				testCase.log(Status.INFO, "Actualbordercolor :- " + actualbordercolor);
				testCase.log(Status.INFO, "Expectedbordercolor :- " + Expectedbordercolor);
				testCase.log(Status.PASS, "correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actualbordercolor :- " + actualbordercolor);
				testCase.log(Status.INFO, "Expectedbordercolor :- " + Expectedbordercolor);
				testCase.log(Status.FAIL, "wrong");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "NO ELEMENT");
			testCase = extent.createTest("9.UNIT-UPDATE-BUTTON-BORDER-COLOR");
		}

		// Employee Import Button CURSER POINT

		try {
			String ActualCursor = com.qa.automation.qdms.pages.master.UnitPage.UpdateButton.getCssValue("cursor");
			System.out.println("cursor :" + ActualCursor);
			String Expectedcursor = "pointer";
			testCase = extent.createTest("10.UNIT-UPDATE-BUTTON-CURSOR");
			try {
				AssertJUnit.assertEquals(ActualCursor, Expectedcursor);
				testCase.log(Status.INFO, "ActualCursor :- " + ActualCursor);
				testCase.log(Status.INFO, "ActualCursor:- " + Expectedcursor);
				testCase.log(Status.PASS, "correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualCursor :- " + ActualCursor);
				testCase.log(Status.INFO, "ActualCursor :- " + Expectedcursor);
				testCase.log(Status.FAIL, "wrong");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("10.UNIT-UPDATE-BUTTON-CURSOR");
		}

		// Employee Import Button OPACITY

		try {
			String Actualopacity = com.qa.automation.qdms.pages.master.UnitPage.UpdateButton.getCssValue("opacity");
			System.out.println("OPACITY :" + Actualopacity);

			String Expectedopacity = "1";
			testCase = extent.createTest("11.UNIT-UPDATE-BUTTON-OPACITY");
			try {
				AssertJUnit.assertEquals(Actualopacity, Expectedopacity);
				testCase.log(Status.INFO, "ActualTextTransformation :- " + Actualopacity);
				testCase.log(Status.INFO, "ExpectedTextTransformation :- " + Expectedopacity);
				testCase.log(Status.PASS, "correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualTextTransformation :- " + Actualopacity);
				testCase.log(Status.INFO, "ExpectedTextTransformation :- " + Expectedopacity);
				testCase.log(Status.FAIL, "wrong");
			}
		} catch (Exception e) {
			testCase = extent.createTest("11.UNIT-UPDATE-BUTTON-OPACITY");
			testCase.log(Status.FAIL, "No Element");
		}

		// Employee Import Button HEIGHT

		try {
			String ActualHeight = com.qa.automation.qdms.pages.master.UnitPage.UpdateButton.getCssValue("height");
			System.out.println("Height :" + ActualHeight);
			String ExpectedHeight = "32px";
			testCase = extent.createTest("12.UNIT-UPDATE-BUTTON-HEIGHT");
			try {
				AssertJUnit.assertEquals(ActualHeight, ExpectedHeight);
				testCase.log(Status.INFO, "ActualLineHeight :- " + ActualHeight);
				testCase.log(Status.INFO, "ExpectedLineHeight :- " + ExpectedHeight);
				testCase.log(Status.PASS, "correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualLineHeight :- " + ActualHeight);
				testCase.log(Status.INFO, "ExpectedLineHeight :- " + ExpectedHeight);
				testCase.log(Status.FAIL, "wrong");
			}
		} catch (Exception e) {
			testCase = extent.createTest("12.UNIT-UPDATE-BUTTON-HEIGHT");
			testCase.log(Status.FAIL, "No element");
		}

		// Employee Import Button Width

		try {
			String Actualwidth = com.qa.automation.qdms.pages.master.UnitPage.UpdateButton.getCssValue("width");
			System.out.println("width :" + Actualwidth);

			String Expectedwidth = "74.4375px";
			testCase = extent.createTest("13.UNIT-UPDATE-BUTTON-WIDTH");
			try {
				AssertJUnit.assertEquals(Actualwidth, Expectedwidth);
				testCase.log(Status.INFO, "Actualwidth :- " + Actualwidth);
				testCase.log(Status.INFO, "Expectedwidth  :- " + Expectedwidth);
				testCase.log(Status.PASS, "correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actualwidth  :- " + Actualwidth);
				testCase.log(Status.INFO, "Expectedwidth  :- " + Expectedwidth);
				testCase.log(Status.FAIL, "wrong");
			}
		} catch (Exception e) {
			testCase = extent.createTest("13.UNIT-UPDATE-BUTTON-WIDTH");
			testCase.log(Status.FAIL, "No element");
		}

		// Employee Import Button Font-weight

		try {
			String Actualweight = com.qa.automation.qdms.pages.master.UnitPage.UpdateButton.getCssValue("font-weight");
			System.out.println("16.Font-weight :" + Actualweight);
			String Expectedweight = "400";
			testCase = extent.createTest("14.UNIT-UPDATE-BUTTON-FONT-WEIGHT");
			try {
				AssertJUnit.assertEquals(Actualweight, Expectedweight);
				testCase.log(Status.INFO, "Actualfontweight :- " + Actualweight);
				testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedweight);
				testCase.log(Status.PASS, "correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actualfontweight :- " + Actualweight);
				testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedweight);
				testCase.log(Status.FAIL, "wrong");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("14.UNIT-UPDATE-BUTTON-FONT-WEIGHT");
		}
		// Thread.sleep(2000);
		// EmployeeImportPage.ImportButton.click();

		// Single Search Method

		// ****************************************************************************************
		// STEP-03--MATERIAL BUTTON IS DISPLAYED & STEP-04--MATERIAL BUTTON IS ENABLED
		// ****************************************************************************************

		if (com.qa.automation.qdms.pages.master.UnitPage.UnitLeftButton.isDisplayed()) {
			testCase = extent.createTest("STEP-03--MATERIAL BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (com.qa.automation.qdms.pages.master.UnitPage.UnitLeftButton.isEnabled()) {
				testCase = extent.createTest("STEP-04--MATERIAL BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				com.qa.automation.qdms.pages.master.UnitPage.UnitLeftButton.click();

			} else {
				testCase = extent.createTest("STEP-04--MATERIAL BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-03--MATERIAL BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

		// ************************************************************************************************************
		// STEP-08--CHECKING PLANT SEARCH BUTTON DISPLAYED & STEP-09--CHECKING PLANT
		// SEARCH BUTTON
		// ENABLED
		// ************************************************************************************************************

		if (driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']")).isDisplayed()) {
			testCase = extent.createTest("STEP-08--SEARCH BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']")).isEnabled()) {
				testCase = extent.createTest("STEP-09--SEARCH BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']")).click();
					String Plant = driver.findElement(By.xpath(
							"//body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[5]/span[1]/mark[1]"))
							.getText();
					System.out.println("PPPPP " + Plant);
					String TextBox1 = driver.findElement(By.xpath("//input[@placeholder='Plant']"))
							.getAttribute("value");
					System.out.println("text box  " + TextBox1);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP-09--SEARCH BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-08--SEARCH BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
		// *************************************************************************************************************************

		boolean clickNextPage = true;
		int actualElementCount = 0;
		boolean passorfail = true;
		ArrayList<String> actualList = new ArrayList<String>();
		ArrayList<String> expectedList = new ArrayList<String>();
		String nameXpath_firstPart = "//body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[";
		String nameXpath_lastPart = "]/td[5]/span[1]/mark[1]";
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					String textFull = driver.findElement(By.xpath(nameXpath_firstPart + i + nameXpath_lastPart))
							.getText();
					String text = textFull.toLowerCase();
					// System.out.println(text);
					try {
						if (!text.contains(searchMaterial)) {
							passorfail = false;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (text.contains(searchMaterial)) {
						expectedList.add(text);
					}
					actualList.add(text);
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

	// Edit Validation

	public static void editvalidationsearch() throws InterruptedException, IOException {
		Thread.sleep(3000);

		String NameXpath_firstPart = "//tbody[@class='ant-table-tbody']/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[2]/span/a[1]/span";
		// *[@id="root"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[6]/td[9]/span/a/span
		boolean clickNextPage = true;
		boolean sbuExist = false;
		Thread.sleep(3000);
		while (clickNextPage) {
			for (int i = 2; i < 102; i++) {
				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(tobepick)) {
						sbuExist = true;
						if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).isDisplayed()) {

							testCase = extent.createTest("STEP-01-CHECKING EDIT ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");

							if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart))
									.isEnabled()) {

								testCase = extent.createTest("STEP-02-CHECKING EDIT ICON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");
								Thread.sleep(3000);
								driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
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

	public static void beforeEditvalidation() throws InterruptedException, IOException {
		try {
			String Value = com.qa.automation.qdms.pages.master.UnitPage.EditUnitTextbox.getAttribute("value");

			TestCasePrint("STEP-03--CONFIRM BEFORE THE EDIT", beforeedit, String.valueOf(Value));
		} catch (Exception e) {
			TestCasePrint("STEP-03--CONFIRM BEFORE THE EDIT", beforeedit, String.valueOf(e));
		}

	}

	public static void CheckeditValidation() throws IOException, InterruptedException {

		com.qa.automation.qdms.pages.master.UnitPage.EditUnitTextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Unit";
		String testCaseId = "TC-UNIT-0031";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			String sbu = (String) row.getCell(1).getStringCellValue();
			String validation = (String) row.getCell(2).getStringCellValue();
			String Message = (String) row.getCell(3).getStringCellValue();

			Thread.sleep(1000);

			com.qa.automation.qdms.pages.master.UnitPage.UnitTextbox.sendKeys(sbu);
			com.qa.automation.qdms.pages.master.UnitPage.UnitSaveButton.click();
			Thread.sleep(1000);
			String ActualValidation = com.qa.automation.qdms.pages.master.UnitPage.validationmsg.getText();
			System.out.println(ActualValidation);
			String ExpectedValidation = validation;
			testCase = extent.createTest("Check " + Message);
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass " + Message + "Script");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("High Priority");
			}

			Thread.sleep(2000);
			com.qa.automation.qdms.pages.master.UnitPage.UnitTextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			Thread.sleep(2000);

		}

		com.qa.automation.qdms.pages.master.UnitPage.CancelBtn.click();

	}

	public static void Navigatetolast() {
		for (int i = 0; i < 5; i++) {
			try {
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				Thread.sleep(2000);
			} catch (Exception e) {
			}
		}
	}

	public static void UnitresetButton(String colname, String colname1) throws InterruptedException, IOException {

		PageFactory.initElements(driver, UnitPage);

		if (com.qa.automation.qdms.pages.master.UnitPage.UnitSearchResetBut.isDisplayed()) {
			testCase = extent.createTest(colname + "RESET BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (com.qa.automation.qdms.pages.master.UnitPage.UnitSearchResetBut.isEnabled()) {
				testCase = extent.createTest(colname1 + "RESET BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					Thread.sleep(2000);
					com.qa.automation.qdms.pages.master.UnitPage.UnitSearchResetBut.click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}
				Thread.sleep(3000);
			} else {
				testCase = extent.createTest(colname1 + "RESET BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + "RESET BUTTON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void UnitcloseButton(String colname, String colname1) throws InterruptedException, IOException {

		PageFactory.initElements(driver, UnitPage);

		if (com.qa.automation.qdms.pages.master.UnitPage.UnitCloseButton.isDisplayed()) {
			testCase = extent.createTest(colname + "CLOSE BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (com.qa.automation.qdms.pages.master.UnitPage.UnitCloseButton.isEnabled()) {
				testCase = extent.createTest(colname1 + "CLOSE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					Thread.sleep(2000);
					com.qa.automation.qdms.pages.master.UnitPage.UnitCloseButton.click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}
				Thread.sleep(3000);
			} else {
				testCase = extent.createTest(colname1 + "CLOSE BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + "CLOSE BUTTON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void UnitdeletecancelButton() throws InterruptedException, IOException {

		Thread.sleep(2000);

		PageFactory.initElements(driver, UnitPage);

		if (com.qa.automation.qdms.pages.master.UnitPage.UnitCancleButton.isDisplayed()) {
			testCase = extent.createTest("STEP-01-- CANCEL BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (com.qa.automation.qdms.pages.master.UnitPage.UnitCancleButton.isEnabled()) {
				testCase = extent.createTest("STEP-02-- CANCEL BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					Thread.sleep(2000);
					com.qa.automation.qdms.pages.master.UnitPage.UnitCancleButton.click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}
				Thread.sleep(3000);
			} else {
				testCase = extent.createTest("STEP-02-- CANCEL BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-01-- CANCEL BUTTON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void dataPick() throws InterruptedException, IOException {

		// PageFactory.initElements(driver, singlesearch);
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Unit";
		String testCaseId = "TC-UNIT-0031-TD";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			tobepick = (String) row.getCell(1).getStringCellValue();
			beforeedit = (String) row.getCell(2).getStringCellValue();
			editvalidationsearch();
		}

	}

	public static boolean clickAddButton = false;

	public static void clickAddButton(String TestCase) throws InterruptedException {

		PageFactory.initElements(driver, UnitPage);
		clickAddButton = false;

		WebDriverWait wait = new WebDriverWait(driver, 20);

		MultiSearchMethods.Buttons(com.qa.automation.qdms.pages.master.UnitPage.AddUnitButton, "Add Unit");
		if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
			try {
				wait.until(ExpectedConditions
						.elementToBeClickable(com.qa.automation.qdms.pages.master.UnitPage.AddUnitButton));
				com.qa.automation.qdms.pages.master.UnitPage.AddUnitButton.click();
				clickAddButton = true;
			} catch (Exception e) {
				testCase.log(Status.INFO, "Add Unit Button Clicked Fail");
				testCase.log(Status.FAIL, "Unit Save Button not Visible, Button Clicked Fail");
			}
		}
	}

	static String unitName = null;
	static String SuccessMsg = null;
	static String searchdata = null;
	static String updatedata = null;
	static boolean validationView = true;
	static boolean inputValue = false;
	public static boolean clickSaveBtn = false;

	public static void inputUnitValue(String testcaseId, String tabName, String TestCaseBefore)
			throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		inputValue = false;
		clickSaveBtn = false;
		PageFactory.initElements(driver, UnitPage);
		try {
			int firstrow = CommonMethods.getFirstRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", tabName,
					testcaseId);
			int lastrow = CommonMethods.getLastRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", tabName,
					testcaseId);
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(tabName);
			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);

				unitName = dataValue.formatCellValue(row.getCell(1));
				SuccessMsg = dataValue.formatCellValue(row.getCell(2));

//					MultiSearchMethods.Buttons(SbuPage.addSbuBtn, "Add SBU Button");
				UnitMethods.clickAddButton("ADD UNIT BUTTON CLICK");

				if (clickAddButton) {
					MultiSearchMethods.Buttons(com.qa.automation.qdms.pages.master.UnitPage.UnitTextbox,
							TestCaseBefore + " Unit TextBox");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						com.qa.automation.qdms.pages.master.UnitPage.UnitTextbox.sendKeys(unitName);
					}

					inputValue = true;
				}
				clickSaveBtn = false;
				if (inputValue) {
					MultiSearchMethods.Buttons(com.qa.automation.qdms.pages.master.UnitPage.UnitSaveButton,
							TestCaseBefore + " Sbu Save ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						wait.until(ExpectedConditions
								.elementToBeClickable(com.qa.automation.qdms.pages.master.UnitPage.UnitSaveButton));
						com.qa.automation.qdms.pages.master.UnitPage.UnitSaveButton.click();
						clickSaveBtn = true;
					}
				}
				if (UnitMethods.clickSaveBtn) {
					UnitMethods.addedValueCheck();
				}
			}
		} catch (Exception e) {
			driver.navigate().refresh();
			testCase = extent.createTest("Excel File Not Found");
			testCase.log(Status.INFO, "Excel File Not Found");
			testCase.log(Status.FAIL, "Excel File Not Found, So fail");
		}
	}

	public static void addedValueCheck() throws InterruptedException {
		PageFactory.initElements(driver, UnitPage);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		boolean unitSaveBtnVisible = false;
		try {
//		wait.until(ExpectedConditions.invisibilityOf(SbuPage.addSbuBtn));
			Thread.sleep(1000);
			Assert.assertEquals(com.qa.automation.qdms.pages.master.UnitPage.UnitSaveButton.isDisplayed(), true);
			unitSaveBtnVisible = true;
		} catch (AssertionError e) {
			unitSaveBtnVisible = false;
		} catch (Exception e) {
			unitSaveBtnVisible = false;
		}
		if (unitSaveBtnVisible) {
			String validation = null;
			try {
				wait.until(ExpectedConditions.visibilityOf(com.qa.automation.qdms.pages.master.UnitPage.validationmsg));
				validation = com.qa.automation.qdms.pages.master.UnitPage.validationmsg.getText();
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (validation.contains("Unit can't be empty")) {
				testCase = extent.createTest("Empty Validation Throwing");
				testCase.log(Status.INFO, "Validation :- " + validation);
				testCase.log(Status.INFO, "UNIT Added Fail");
				testCase.log(Status.FAIL, "Empty Validation Throwing, So UNIT Added Fail");
				driver.navigate().refresh();
			} else if (validation.contains("Unit already exist")) {
				testCase = extent.createTest("Already Exists Validation Throwing For UNIT :- " + unitName);
				testCase.log(Status.INFO, "Validation :- " + validation);
				testCase.log(Status.INFO, "UNIT Added Fail");
				testCase.log(Status.FAIL, "Already Exists Validation Throwing, So UNIT Added Fail");
				driver.navigate().refresh();
				boolean checkValue = false;

				boolean enable = true;
				while (enable) {

					int x = 0;
					try {
						WebDriverWait wai = new WebDriverWait(driver, 5);
						wai.until(ExpectedConditions.visibilityOfAllElements(
								driver.findElements(By.xpath("//td[1][text()='" + unitName + "']"))));
						x = driver.findElements(By.xpath("//td[1][text()='" + unitName + "']")).size();
					} catch (Exception e) {
						e.printStackTrace();
					}

					if (x == 1) {
						checkValue = true;
						break;
					}
					try {
						UnitPage.NextPageBtn.click();
						WebDriverWait wai = new WebDriverWait(driver, 2);
						wai.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//tr"))));
					} catch (Exception e) {

					}
				}
				testCase = extent.createTest("Already Exists Validation Conformation For UNIT :- " + unitName);
				if (checkValue) {
					testCase.log(Status.INFO, "UNIT :- " + unitName + " Already Exits in UNIT Table");
					testCase.log(Status.INFO, "UNIT :- " + unitName + " Founded In UNIT Table");
					testCase.log(Status.FAIL, "So, Add UNIT Script Fail");
				} else {
					testCase.log(Status.INFO, "SBU :- " + unitName + " Not in UNIT Table");
					testCase.log(Status.INFO, "Added Value Not Founded In UNIT Table");
					testCase.log(Status.FAIL, "So, System  Fail");
				}

			} else if (validation.contains("Only 3 characters long!")) {
				testCase = extent.createTest("Added Data Lenth Not Match Validation Throwing");
				testCase.log(Status.INFO, "Validation :- " + validation);
				testCase.log(Status.INFO, "UNIT Added Fail");
				testCase.log(Status.FAIL, "Added Data Lenth Not Match Validation Throwing, So UNIT Added Fail");
				driver.navigate().refresh();
			} else if (validation.contains("UNIT Business Unit allow only letters")) {
				testCase = extent.createTest("Wrong Characters Validation Throwing");
				testCase.log(Status.INFO, "Validation :- " + validation);
				testCase.log(Status.INFO, "UNIT Added Fail");
				testCase.log(Status.FAIL, "Wrong Characters Validation Throwing, So UNIT Added Fail");
				driver.navigate().refresh();
			} else {
				testCase = extent.createTest("Any Validation Not Throwing");
				testCase.log(Status.INFO, "UNIT Added Fail");
				testCase.log(Status.FAIL, "Validation Not Throwing, So UNIT Added Fail");
				driver.navigate().refresh();
			}

		} else {
			boolean success = false;
			testCase = extent.createTest("SBU :- " + unitName + " - Adding Success Message");
			try {
				Assert.assertEquals(com.qa.automation.qdms.pages.master.UnitPage.successMessages.getText(), SuccessMsg);
				testCase.log(Status.INFO, "Actual Success Message :- "
						+ com.qa.automation.qdms.pages.master.UnitPage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
				testCase.log(Status.PASS, "Success Message  Matching, So Throwing Success Message Pass");
				success = true;
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Success Message :- "
						+ com.qa.automation.qdms.pages.master.UnitPage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
				testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
			} catch (Exception e) {
				testCase.log(Status.INFO, "Actual Success Message :- "
						+ com.qa.automation.qdms.pages.master.UnitPage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
				testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
			}

			if (success) {
				testCase = extent.createTest("SBU :- " + unitName + " - Added Value Check In First Row");

				try {
					Assert.assertEquals(com.qa.automation.qdms.pages.master.UnitPage.firstRowData.getText(), unitName);
					testCase.log(Status.INFO, "UNIT :- " + unitName + " Added Check in First Row");
					testCase.log(Status.INFO, "Added Value Founded In First Row");
					testCase.log(Status.PASS, "So, Add UNIT Script Pass");
				} catch (Exception e) {
					testCase.log(Status.INFO, "UNIT :- " + unitName + " Added Check in First Row");
					testCase.log(Status.INFO, "Added Value Not Founded In First Row");
					testCase.log(Status.FAIL, "So, Add UNIT Script Fail");
				}
			}

			if (success) {

				try {
					com.qa.automation.qdms.pages.master.UnitPage.successMessageCloseBtn.click();
				} catch (Exception e) {

				}
			}

			int counts = 0;

			boolean enable = true;
			while (enable) {
				WebDriverWait wai = new WebDriverWait(driver, 2);

				int x = 0;
				try {

					wai.until(ExpectedConditions.visibilityOfAllElements(
							driver.findElements(By.xpath("//td[1][text()='" + unitName + "']"))));
					x = driver.findElements(By.xpath("//td[1][text()='" + unitName + "']")).size();
				} catch (Exception e) {
					e.printStackTrace();
				}
				counts = counts + x;

				try {
					enable = com.qa.automation.qdms.pages.master.UnitPage.NextPageBtn.isEnabled();
//		Click Next page Button
					if (enable) {

						com.qa.automation.qdms.pages.master.UnitPage.NextPageBtn.click();
						wai.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//tr"))));
					}
				} catch (Exception e) {

				}

			}
			System.out.println(counts + "::::::::::::::::");
			testCase = extent.createTest("UNIT :- " + unitName + " - Added Value Check In UNIT Table");
			if (counts == 1) {
				testCase.log(Status.INFO, "UNIT :- " + unitName + " Added Check in UNIT Table");
				testCase.log(Status.INFO, "Added Value Founded In UNIT Table");
				testCase.log(Status.PASS, "So, Add UNIT Script Pass");
			} else {
				testCase.log(Status.INFO, "UNIT :- " + unitName + " Added Check in UNIT Table");
				testCase.log(Status.INFO, "Added Value Duplicate In UNIT Table");
				testCase.log(Status.FAIL, "So, Add UNIT Script Fail");
			}
			driver.navigate().refresh();
		}
	}

	public static void editInputUnitValue(String testcaseId, String tabName, String TestCaseBefore)
			throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		inputValue = false;
		clickSaveBtn = false;
		PageFactory.initElements(driver, UnitPage);
		try {
			int firstrow = CommonMethods.getFirstRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", tabName,
					testcaseId);
			int lastrow = CommonMethods.getLastRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", tabName,
					testcaseId);
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(tabName);
			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);

				unitName = dataValue.formatCellValue(row.getCell(1));
				searchdata = dataValue.formatCellValue(row.getCell(2));
				updatedata = dataValue.formatCellValue(row.getCell(3));
				SuccessMsg = dataValue.formatCellValue(row.getCell(4));

//						MultiSearchMethods.Buttons(SbuPage.addSbuBtn, "Add SBU Button");
				UnitMethods.search(searchdata);

				UnitMethods.beforeEdit(unitName);

				if (beforeeditting) {
					MultiSearchMethods.Buttons(com.qa.automation.qdms.pages.master.UnitPage.UnitTextbox,
							TestCaseBefore + " Unit TextBox");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {

						com.qa.automation.qdms.pages.master.UnitPage.UnitTextbox.sendKeys(Keys.CONTROL + "a",
								Keys.DELETE);
						com.qa.automation.qdms.pages.master.UnitPage.UnitTextbox.sendKeys(updatedata);
					}

					inputValue = true;
				}
				beforeeditting = false;
				if (inputValue) {
					MultiSearchMethods.Buttons(com.qa.automation.qdms.pages.master.UnitPage.UnitSaveButton,
							TestCaseBefore + " Unit Save ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						wait.until(ExpectedConditions
								.elementToBeClickable(com.qa.automation.qdms.pages.master.UnitPage.UnitSaveButton));
						com.qa.automation.qdms.pages.master.UnitPage.UnitSaveButton.click();
						beforeeditting = true;
					}
				}
				if (UnitMethods.beforeeditting) {
					UnitMethods.editValueCheck();
				}
			}
		} catch (Exception e) {
			driver.navigate().refresh();
			testCase = extent.createTest("Excel File Not Found");
			testCase.log(Status.INFO, "Excel File Not Found");
			testCase.log(Status.FAIL, "Excel File Not Found, So fail");
		}
	}

	public static void editValueCheck() throws InterruptedException {
		PageFactory.initElements(driver, UnitPage);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		boolean unitSaveBtnVisible = false;
		try {
//			wait.until(ExpectedConditions.invisibilityOf(SbuPage.addSbuBtn));
			Thread.sleep(1000);
			Assert.assertEquals(com.qa.automation.qdms.pages.master.UnitPage.UnitSaveButton.isDisplayed(), true);
			unitSaveBtnVisible = true;
		} catch (AssertionError e) {
			unitSaveBtnVisible = false;
		} catch (Exception e) {
			unitSaveBtnVisible = false;
		}
		if (unitSaveBtnVisible) {
			String validation = null;
			try {
				wait.until(ExpectedConditions.visibilityOf(com.qa.automation.qdms.pages.master.UnitPage.validationmsg));
				validation = com.qa.automation.qdms.pages.master.UnitPage.validationmsg.getText();
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (validation.contains("Unit can't be empty")) {
				testCase = extent.createTest("Empty Validation Throwing");
				testCase.log(Status.INFO, "Validation :- " + validation);
				testCase.log(Status.INFO, "UNIT Update Fail");
				testCase.log(Status.FAIL, "Empty Validation Throwing, So UNIT Update Fail");
				driver.navigate().refresh();
			} else if (validation.contains("Unit already exist")) {
				testCase = extent.createTest("Already Exists Validation Throwing For UNIT :- " + unitName);
				testCase.log(Status.INFO, "Validation :- " + validation);
				testCase.log(Status.INFO, "UNIT Update Fail");
				testCase.log(Status.FAIL, "Already Exists Validation Throwing, So UNIT Update Fail");
				driver.navigate().refresh();
				boolean checkValue = false;

				boolean enable = true;
				while (enable) {

					int x = 0;
					try {
						WebDriverWait wai = new WebDriverWait(driver, 5);
						wai.until(ExpectedConditions.visibilityOfAllElements(
								driver.findElements(By.xpath("//td[1][text()='" + unitName + "']"))));
						x = driver.findElements(By.xpath("//td[1][text()='" + unitName + "']")).size();
					} catch (Exception e) {
						e.printStackTrace();
					}

					if (x == 1) {
						checkValue = true;
						break;
					}
					try {
						com.qa.automation.qdms.pages.master.UnitPage.NextPageBtn.click();
						WebDriverWait wai = new WebDriverWait(driver, 2);
						wai.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//tr"))));
					} catch (Exception e) {

					}
				}
				testCase = extent.createTest("Already Exists Validation Conformation For UNIT :- " + unitName);
				if (checkValue) {
					testCase.log(Status.INFO, "UNIT :- " + unitName + " Already Exits in UNIT Table");
					testCase.log(Status.INFO, "UNIT :- " + unitName + " Founded In UNIT Table");
					testCase.log(Status.FAIL, "So, Add UNIT Script Fail");
				} else {
					testCase.log(Status.INFO, "SBU :- " + unitName + " Not in UNIT Table");
					testCase.log(Status.INFO, "Added Value Not Founded In UNIT Table");
					testCase.log(Status.FAIL, "So, System  Fail");
				}

			} else if (validation.contains("Only 3 characters long!")) {
				testCase = extent.createTest("Added Data Lenth Not Match Validation Throwing");
				testCase.log(Status.INFO, "Validation :- " + validation);
				testCase.log(Status.INFO, "UNIT Update Fail");
				testCase.log(Status.FAIL, "Added Data Lenth Not Match Validation Throwing, So UNIT Update Fail");
				driver.navigate().refresh();
			} else if (validation.contains("UNIT Business Unit allow only letters")) {
				testCase = extent.createTest("Wrong Characters Validation Throwing");
				testCase.log(Status.INFO, "Validation :- " + validation);
				testCase.log(Status.INFO, "UNIT Update Fail");
				testCase.log(Status.FAIL, "Wrong Characters Validation Throwing, So UNIT Update Fail");
				driver.navigate().refresh();
			} else {
				testCase = extent.createTest("Any Validation Not Throwing");
				testCase.log(Status.INFO, "UNIT Update Fail");
				testCase.log(Status.FAIL, "Validation Not Throwing, So UNIT Update Fail");
				driver.navigate().refresh();
			}

		} else {
			boolean success = false;
			testCase = extent.createTest("SBU :- " + unitName + " - Update Success Message");
			try {
				Assert.assertEquals(com.qa.automation.qdms.pages.master.UnitPage.successMessages.getText(), SuccessMsg);
				testCase.log(Status.INFO, "Actual Success Message :- "
						+ com.qa.automation.qdms.pages.master.UnitPage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
				testCase.log(Status.PASS, "Success Message  Matching, So Throwing Success Message Pass");
				success = true;
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Success Message :- "
						+ com.qa.automation.qdms.pages.master.UnitPage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
				testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
			} catch (Exception e) {
				testCase.log(Status.INFO, "Actual Success Message :- "
						+ com.qa.automation.qdms.pages.master.UnitPage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
				testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
			}

			if (success) {
				testCase = extent.createTest("UNIT :- " + unitName + " - Added Value Check In First Row");

				try {
					Assert.assertEquals(com.qa.automation.qdms.pages.master.UnitPage.firstRowData.getText(),
							updatedata);
					testCase.log(Status.INFO, "UNIT :- " + unitName + " Update Check in First Row");
					testCase.log(Status.INFO, "Updated Value Founded In First Row");
					testCase.log(Status.PASS, "So, Update UNIT Script Pass");
				} catch (Exception e) {
					testCase.log(Status.INFO, "UNIT :- " + unitName + " Update Check in First Row");
					testCase.log(Status.INFO, "Added Value Not Founded In First Row");
					testCase.log(Status.FAIL, "So, Update UNIT Script Fail");
				}
			}

			if (success) {

				try {
					com.qa.automation.qdms.pages.master.UnitPage.successMessageCloseBtn.click();
				} catch (Exception e) {

				}
			}

			int counts = 0;

			boolean enable = true;
			while (enable) {
				WebDriverWait wai = new WebDriverWait(driver, 2);

				int x = 0;
				try {

					wai.until(ExpectedConditions.visibilityOfAllElements(
							driver.findElements(By.xpath("//td[1][text()='" + updatedata + "']"))));
					x = driver.findElements(By.xpath("//td[1][text()='" + updatedata + "']")).size();
				} catch (Exception e) {
					e.printStackTrace();
				}
				counts = counts + x;

				try {
					enable = com.qa.automation.qdms.pages.master.UnitPage.NextPageBtn.isEnabled();
//			Click Next page Button
					if (enable) {

						com.qa.automation.qdms.pages.master.UnitPage.NextPageBtn.click();
						wai.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//tr"))));
					}
				} catch (Exception e) {

				}

			}
			System.out.println(counts + "::::::::::::::::");
			testCase = extent.createTest("UNIT :- " + updatedata + " - Update Value Check In UNIT Table");
			if (counts == 1) {
				testCase.log(Status.INFO, "UNIT :- " + updatedata + " Update Check in UNIT Table");
				testCase.log(Status.INFO, "Updated Value Founded In UNIT Table");
				testCase.log(Status.PASS, "So, Update UNIT Script Pass");
			} else {
				testCase.log(Status.INFO, "UNIT :- " + updatedata + " Update Check in UNIT Table");
				testCase.log(Status.INFO, "Updated Value Duplicate In UNIT Table");
				testCase.log(Status.FAIL, "So, Update UNIT Script Fail");
			}
			driver.navigate().refresh();
		}

	}

}
