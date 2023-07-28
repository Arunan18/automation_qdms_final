package com.qa.automation.qdms.testcases.project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import com.qa.automation.qdms.pages.master.ProjectPage;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class ProjectMethods extends DriverIntialization {

	static int BefCount = 0;
	static int BeforeCount = 0;
	static int AfterCount = 0;
	static int test = 0;
	static boolean validation = true;
	static String searchplant = "RMC Jaffna Plant";
	static int actualElementCount = 0;
	static String searchProjectCode = "PR-PRJ-208";
	static String searchPlant = "Test new";
	static String searchProjectname = "CEB Project";
	static ProjectPage projectpage = new ProjectPage();

	static boolean ExpectedVisiblePreviousButton = false;
	static boolean ExpectedVisibleNextButton = false;
	static boolean ExpectedDefaultPageIndex = false;
	static boolean ExpectedRefreshDefaultIndexPage = false;
	static boolean ExpectedPageDirect = false;
	static boolean ExpectedPreviousBtnDisable = true;
	static boolean AfterMovetoSecPagepreButEnable = false;
	static int ExpectedPageCount = 0;
	static int ExpectedTotalPage20 = 0;
	static int ExpectedTotalPage30 = 0;
	static int ExpectedTotalPage100 = 0;
	public static boolean clickdeleteicon = false;
	public static boolean projectafterdeletion = false;
	public static boolean clickAddButton = false;
	public static boolean clickSaveButton = false;
	public static boolean updateclick = false;
	public static boolean beforeedit = false;

	public static void Excel() throws IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Project";
		String testCaseId = "TC-PRO-0050";

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
			ExpectedPreviousBtnDisable = (Boolean) row.getCell(6).getBooleanCellValue();
			AfterMovetoSecPagepreButEnable = (Boolean) row.getCell(7).getBooleanCellValue();
			ExpectedPageCount = (int) row.getCell(8).getNumericCellValue();
			ExpectedTotalPage20 = (int) row.getCell(9).getNumericCellValue();
			ExpectedTotalPage30 = (int) row.getCell(10).getNumericCellValue();
			ExpectedTotalPage100 = (int) row.getCell(11).getNumericCellValue();

		}
	}

	@Test(priority = 2)
	public static void ProjectPagination() throws InterruptedException {

		ProjectPage Projectpage = new ProjectPage();
		PageFactory.initElements(driver, Projectpage);
		// Thread.sleep(1000);
		// ProjectPage.masterBtn.click();
		// Thread.sleep(2000);
		ProjectPage.CustomermenuBtn.click();
		// Thread.sleep(2000);

	}

	@Test(priority = 3)
	public static void DefaultIndexPage(String colname) throws InterruptedException {
		try {

			boolean ActualDefaultPageIndex = ProjectPage.DefaultPaginationPage.isDisplayed();

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
			testCase = extent.createTest(colname + "Checking Default Index Page is fialed because no element");
		}
	}

	@Test(priority = 4)
	public static void RefreshDefaultPage(String colname) throws InterruptedException {

		try {
			ProjectPage.NextPageBtn.click();
			// Thread.sleep(20000);
			driver.navigate().refresh();
			Thread.sleep(2000);
			boolean ActualDefaultPageIndex1 = ProjectPage.DefaultPaginationPage.isDisplayed();
			System.out.println(ActualDefaultPageIndex1);

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
					.createTest("STEP-02 Checking Default Index Page after Refresh is failed because no element");
		}
	}

	// Page Redirect to the next page

	@Test(priority = 5)
	public static void PageRedrict(String colname) throws InterruptedException {
		try {

			ProjectPage.NextPageBtn.click();
			Thread.sleep(2000);
			boolean ActualSecoundPageIndex = ProjectPage.PaginationSecoundPage.isDisplayed();

			testCase = extent.createTest("STEP-03 Checking Page Redriect to the next page");
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
					.createTest("STEP-03 Checking Page Redriect to the next page is failed because no element");
		}
	}

	// Previous Button Displayed
	@Test(priority = 6)
	public static void PreButtonDispaly(String colname) throws InterruptedException {

		try {
			boolean ActualVisiblePreviousButton = ProjectPage.PreviousPageBtn.isDisplayed();

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
			testCase = extent.createTest("STEP-04 Checking Previous Button Dispaly is failed because no element");
		}
	}

	// Next Button Displayed
	@Test(priority = 7)
	public static void NextButtonDispaly(String colname) throws InterruptedException {
		try {

			boolean ActualVisibleNextButton = ProjectPage.NextPageBtn.isDisplayed();

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
			testCase = extent.createTest("STEP-05 CHecking Next Button Dispaly is failed because no element");
		}
	}

	// Next Button Enable
	@Test(priority = 8)
	public static void NextButtonEanble() throws InterruptedException {
		try {
			boolean ActualNextBtnEnable = ProjectPage.NextPageBtn.isEnabled();
			boolean ExpectedNextBtnEnable = true;
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
			testCase = extent.createTest("STEP-06 Checking Next Button Enable is failed because no element");
		}
		// Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);

	}

	// Before move to 2nd page, previous button disable
	@Test(priority = 9)
	public static void SecPagepreButDisable(String colname) throws InterruptedException {

		try {
			boolean ActualPreviousBtnDisable = ProjectPage.PreviousPageBtn.isEnabled();
			boolean ExpectedPreviousBtnDisable = false;
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
			testCase = extent.createTest(colname
					+ "Checking Before navigate to 2 Page Previous Button is Disabled is failed because no element");
		}

	}

	// After move to 2nd page, previous button Enable
	@Test(priority = 10)
	public static void AfterMovetoSecPagepreButEnable(String colname) throws InterruptedException {
		try {
			ProjectPage.NextPageBtn.click();
			// Thread.sleep(2000);
			boolean ActualPreviousBtnEnable = ProjectPage.PreviousPageBtn.isEnabled();

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
					"STEP-08 Checking After Navigate to the Seconfd Page Previous button Enabled is failed because no element");
		}
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@Test(priority = 11)
	public static void TotalPage(String colname) throws InterruptedException {

		String DataCountText = ProjectPage.paginationcount.getText();

		System.out.println(DataCountText);
		Pattern pattern = Pattern.compile("\\d+ of (\\d+)");
		Matcher matcher = pattern.matcher(DataCountText);
		if (matcher.find()) {
			String pageCount = matcher.group(1);
			double Value = Integer.parseInt(pageCount) / 10;
			int Finalvalue = (int) Math.ceil(Value);
			System.out.println(colname + "Total pages: " + Finalvalue);

			testCase = extent.createTest("Checking Total Data");
			try {
				Assert.assertEquals(Finalvalue, ExpectedPageCount);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + ProjectPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + Finalvalue);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedPageCount);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + ProjectPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + Finalvalue);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedPageCount);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}

		}

	}

	@Test(priority = 14)
	public static void Pages(String colname, String colname1, String colname2) throws InterruptedException {

		int ActualTotalPage = 1;
		boolean Enablity = ProjectPage.NextPageBtn.isEnabled();
		while (Enablity) {
			Thread.sleep(1000);
			ProjectPage.NextPageBtn.click();
			ActualTotalPage = ActualTotalPage + 1;
			Enablity = ProjectPage.NextPageBtn.isEnabled();
		}
		System.out.println(ActualTotalPage);
		Thread.sleep(2000);

		if (ProjectPage.CurrentPaginationOpction.getText().contentEquals("10 / page")) {
			int ExpectedTotalPage = 84;
			testCase = extent.createTest("PAGINATION-TOTAL-PAGE-COUNT");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + ProjectPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + ProjectPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (ProjectPage.CurrentPaginationOpction.getText().contentEquals("20 / page")) {

			testCase = extent.createTest(colname + "Checking Total Page for 20 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage20);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + ProjectPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage20);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + ProjectPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage20);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (ProjectPage.CurrentPaginationOpction.getText().contentEquals("30 / page")) {

			testCase = extent.createTest(colname1 + "Checking Total Page for 30 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage30);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + ProjectPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage30);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + ProjectPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage30);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (ProjectPage.CurrentPaginationOpction.getText().contentEquals("100 / page")) {

			testCase = extent.createTest(colname2 + "Checking Total Page for 100 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage100);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + ProjectPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage100);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + ProjectPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage100);
				testCase.log(Status.FAIL, "Wrong Page Count");

				Thread.sleep(2000);
			}
			driver.navigate().refresh();
		}
	}

	// *******************************************************************************************
	// Project Add Functionality
	// *******************************************************************************************

	/*******************************
	 * PROJECT ADD BUTTON VISIBLE & ENABLED
	 * 
	 * @throws InterruptedException
	 *********************************/
	public static void ProjectAddButton(String colname, String colname1) throws InterruptedException {
		PageFactory.initElements(driver, projectpage);

		if (ProjectPage.projectaddbtn.isDisplayed()) {
			testCase = extent.createTest(colname + "ADD BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (ProjectPage.projectaddbtn.isEnabled()) {
				testCase = extent.createTest(colname1 + "ADD BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					ProjectPage.projectaddbtn.click();
					clickAddButton = true;
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest(colname1 + "ADD BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest(colname + "ADD BUTTON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

	// /******************************ADD PROJECT FORM SAVE BUTTON FIELD VISIBLE &
	// ENABLED*********************************/
	public static void ProjectSaveButton(String colname, String colname1) throws InterruptedException {
		Thread.sleep(2000);
		if (ProjectPage.projectsavebutton.isDisplayed()) {
			testCase = extent.createTest(colname + "SAVE BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS");
			if (ProjectPage.projectsavebutton.isEnabled()) {
				testCase = extent.createTest(colname1 + "SAVE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					ProjectPage.projectsavebutton.click();
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest(colname1 + "SAVE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest(colname + "SAVE BUTTON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	// /**********************************************************************************************
	// * Add Method for project
	// **********************************************************************************************/

	public static void Projectadddata(String colname, String colname1, String msg, String data)
			throws InterruptedException, IOException {

		Thread.sleep(1000);
		String AddSuccessMessage = ProjectPage.projecraddsucessmsg.getText();
		System.out.println(AddSuccessMessage);

		testCase = extent.createTest(colname + "DATA ADDED SUCCESFULLY");
		try {
			Assert.assertEquals(AddSuccessMessage, msg);
			testCase.log(Status.INFO, "Actual Data :- " + AddSuccessMessage);
			testCase.log(Status.INFO, "Expected Data :- " + msg);
			testCase.log(Status.PASS, "Success Message Enable");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual Data :- " + AddSuccessMessage);
			testCase.log(Status.INFO, "Expected Data :- " + msg);
			testCase.log(Status.FAIL, "Wrong Success Message Not Enable");
		}

		Thread.sleep(4000);
		driver.navigate().refresh();

		Thread.sleep(2000);
		String actualdata = ProjectPage.ProjectTablename.getText();
		System.out.println("First row of table : " + actualdata);

		boolean firstdata = true;
		testCase = extent.createTest(colname1 + "CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE");
		try {
			AssertJUnit.assertEquals(actualdata, data);

		} catch (AssertionError e) {
			firstdata = false;
		}
		if (firstdata) {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + data);
			testCase.log(Status.PASS, "Correct last data added in first row");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + data);
			testCase.log(Status.FAIL, "Wrong Last Data Not Added in first row");
		}

	}

	public static void ProjectDeleteconfirm() throws InterruptedException {
		PageFactory.initElements(driver, projectpage);
		//// ---------------------------------------------------------------------------------------
		//// Count Number of elemenets before search
		//// ---------------------------------------------------------------------------------------
		String DataCountText = ProjectPage.projectpaginationcount.getText();

		System.out.println("Projectpagination count :" + DataCountText);
		System.out.println("!!!!!!!!!!!!!!!!!" + DataCountText);
		String[] BeforeCount = DataCountText.split("of ");

		BefCount = Integer.parseInt(BeforeCount[1]);

		System.out.println("Final Count :" + BefCount);

	}

	public static void ProjectDeletesearch(String colname, String colname1, String searchdata, String colname2)
			throws InterruptedException, IOException {

		ProjectDeleteconfirm();

		String Name = searchdata;
		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String DeleteXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String DeleteXpath_lastPart = "]/td[9]/span/a[2]/a/span";

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
						Thread.sleep(2000);
						sbuExist = true;
						if (driver.findElement(By.xpath(DeleteXpath_firstPart + i + DeleteXpath_lastPart))
								.isDisplayed()) {

							testCase = extent.createTest(colname + "CHECKING DELETE ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");

							if (driver.findElement(By.xpath(DeleteXpath_firstPart + i + DeleteXpath_lastPart))
									.isEnabled()) {

								testCase = extent.createTest(colname1 + "CHECKING DELETE ICON IS ENABLED");
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

									ProjectPage.deleteOkButton.click();

									Thread.sleep(2000);

									String Actualmessage = driver
											.findElement(By.xpath("//div[@class='ant-notification-notice-message']"))
											.getText();

									System.out.println("&$^*&^^^^^^^^^^^^^^^*:" + Actualmessage);

									testCase = extent.createTest("PROJECT DATA DELETED SUCCESFULLY");

									try {
										// ExpectedTextVisible=false;
										Assert.assertEquals(Actualmessage, colname2);
										testCase.log(Status.INFO, "Actual Visible :- " + Actualmessage);
										testCase.log(Status.INFO, "Expected Visible :- " + colname2);
										testCase.log(Status.PASS, " Correct");
									} catch (AssertionError e) {
										testCase.log(Status.INFO, "ActualVisible :- " + Actualmessage);
										testCase.log(Status.INFO, "Expected Visible :- " + colname2);
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
		if (sbuExist = false) {
			System.out.println("No such Element" + sbuExist);
		}

	}

	public static void ProjectDeletesearchMid(String searchdata, String colname, String colname1)
			throws InterruptedException, IOException {
		String Name = searchdata;
		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String DeleteXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String DeleteXpath_lastPart = "]/td[9]/span/a[2]/a/span";

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

	public static void ProjectAfterDeleteconfirm() throws InterruptedException {

		//// ---------------------------------------------------------------------------------------
		//// Count Number of elemenets before search
		//// ---------------------------------------------------------------------------------------

		String DataCountText = ProjectPage.projectpaginationcount.getText();

		System.out.println("Projectpagination count :" + DataCountText);
		String[] AfterCount = DataCountText.split("of ");

		test = Integer.parseInt(AfterCount[1]);
		System.out.println("Final Count :" + AfterCount[1]);
		projectafterdeletion = true;

	}

	public static void ProjectDeleteEqu(String colname, boolean expected) {

		try {

			// System.out.println("IsVisible");
			System.out.println(BefCount + " !!!!!!!!!!!!!!1 " + (BefCount - 1));
			int aa = (BefCount - 1);
			System.out.println("Output is" + aa);
			testCase = extent.createTest(colname + "Checking count after deletion");

			try {
				// ExpectedTextVisible=false;
				Assert.assertEquals(aa, test);
				testCase.log(Status.INFO, "Actual Visible :- " + aa);
				testCase.log(Status.INFO, "Expected Visible :- " + test);
				testCase.log(Status.PASS, " Project deleted Succesfully");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualVisible :- " + aa);
				testCase.log(Status.INFO, "Expected Visible :- " + test);
				testCase.log(Status.FAIL, "Wrong");
			}
		} catch (Exception e) {
			testCase = extent.createTest("1-VISIBLE");
			testCase.log(Status.FAIL, "No element");
		}

		// AfterCount == BeforeCount - 1;

	}

	// ********************************************************************************************************
	// THE METHOD IS FOR GENERATING REPORT
	// ********************************************************************************************************
	public static void testCasePrint(String TestCaseName, String expectedValue, String actualValue) {
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
	// STEP-03--PROJECT BUTTON IS DISPLAYED & STEP-04--PROJECT BUTTON IS ENABLED
	// ****************************************************************************************
	public static void ProjectleftButton(String colname, String colname1) {
		if (ProjectPage.projectleftbutton.isDisplayed()) {
			testCase = extent.createTest(colname + "PROJECT BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (ProjectPage.projectleftbutton.isEnabled()) {
				testCase = extent.createTest(colname1 + "PROJECT BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				ProjectPage.projectleftbutton.click();

			} else {
				testCase = extent.createTest(colname1 + "PROJECT BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + "PROJECT BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

	}

	// ****************************************************************************************
	// STEP-05--PROJECT SEARCH ICON IS DISPLAYED & STEP-06--PROJECT SEARCH ICON IS
	// ENABLED
	// ****************************************************************************************
	public static void ProjectSearchIcon(String colname, String colname1) {
		if (driver.findElement(By.xpath(
				"//body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[1]/div[1]/span[2]"))
				.isDisplayed()) {
			testCase = extent.createTest(colname + "PROJECT SEARCH ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath(
					"//body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[1]/div[1]/span[2]"))
					.isEnabled()) {
				testCase = extent.createTest(colname1 + "PROJECT SEARCH ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					driver.findElement(By.xpath(
							"//body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[1]/div[1]/span[2]"))
							.click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest(colname1 + "PROJECT SEARCH ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + "PROJECT SEARCH ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

	}

	// ************************************************************************************************************
	// STEP-07--CHECKING UNIT SEARCH TEXTBOX DISPLAYED & STEP-08--CHECKING UNIT
	// SEARCH TEXTBOX ENABLED
	// ************************************************************************************************************
	public static void ProjectSearchTextbox(String searchdata, String colname, String colname1) {
		if (ProjectPage.projectsearchtextbox.isDisplayed()) {

			testCase = extent.createTest(colname + "SEARCH TEXTBOX IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (ProjectPage.projectsearchtextbox.isEnabled()) {
				testCase = extent.createTest(colname1 + "SEARCH TEXTBOX ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					ProjectPage.projectsearchtextbox.sendKeys(searchdata);

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
	// STEP-08--CHECKING PROJECT SEARCH BUTTON DISPLAYED & STEP-09--CHECKING PROJECT
	// SEARCH BUTTON
	// ENABLED
	// ************************************************************************************************************
	public static void ProjectSearchButton(String colname, String colname1) throws InterruptedException {

		if (driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']")).isDisplayed()) {
			testCase = extent.createTest(colname + "SEARCH BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']")).isEnabled()) {
				testCase = extent.createTest(colname1 + "SEARCH BUTTON IS ENABLED");
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
						if (!text.contains(searchProjectCode)) {
							passorfail = false;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (text.contains(searchProjectCode)) {
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

	public static void ProjectFSingleSearchConfirm(String colname, int expected) {
		try {
			int Value = actualElementCount;
			System.out.println(Value);
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

	// ****************************************************************************************
	// Next page
	// ****************************************************************************************
	public static void ProjectNavigatetoMiddle(int page) {
		for (int i = 0; i <= page; i++) {
			try {
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				Thread.sleep(2000);
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.PAGE_UP).build().perform();
			} catch (Exception e) {
			}
		}
	}

	// ****************************************************************************************
	// Next page to Last
	// ****************************************************************************************
	public static void ProjectNavigatetoLast() throws InterruptedException {
		// for (int i = 0; i < 84; i++) {
		// try {
		// driver.findElement(By.xpath("//li[@title='Next
		// Page']//button[@type='button']")).click();
		// Thread.sleep(2000);
		// } catch (Exception e) {
		// }
		// }
		Thread.sleep(3000);
		ProjectPage.paginationlastpage.click();

		// Scroll up by a page
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_UP).build().perform();
	}

	// ****************************************************************************************
	// STEP-05--PROJECT MODULE PLANT FIELD SEARCH ICON IS DISPLAYED &
	// STEP-06--PROJECT MODULE PLANT FIELD SEARCH ICON IS
	// ENABLED
	// ****************************************************************************************

	public static void ProjectSearchIconPlant(String colname, String colname1) {
		if (driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[2]/div/span[2]/span"))
				.isDisplayed()) {
			testCase = extent.createTest(colname + "PROEJCT MODULE PLANT FIELD SEARCH ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[2]/div/span[2]/span"))
					.isEnabled()) {
				testCase = extent.createTest(colname1 + "PROJECT MODULE PLANT FIELD SEARCH ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					driver.findElement(By.xpath(
							"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[2]/div/span[2]/span"))
							.click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest(colname1 + "PROJECT MODULE PLANT FIELD SEARCH ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + "PROEJCT MODULE PLANT FIELD SEARCH ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

	}

	public static void ProjectSearchTextboxplant(String colname, String colname1, String searchdata) {
		if (ProjectPage.SearchTextBox.isDisplayed()) {

			testCase = extent.createTest(colname + "PROEJCT MODULE PLANT FIELD SEARCH TEXTBOX IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (ProjectPage.SearchTextBox.isEnabled()) {
				testCase = extent.createTest(colname1 + "PROEJCT MODULE PLANT FIELD SEARCH TEXTBOX ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					ProjectPage.SearchTextBox.sendKeys(searchdata);

					// driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

					Thread.sleep(3000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest(colname1 + "PROEJCT MODULE PLANT FIELD SEARCH TEXTBOX ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + "PROEJCT MODULE PLANT FIELD SEARCH TEXTBOX IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

	}

	// **************************************************************************************************************************************
	// STEP-08--CHECKING PROJECT MODULE PLANT FIELD SEARCH BUTTON DISPLAYED &
	// STEP-09--CHECKING
	// PROJECT MODULE PLANT FIELD SEARCH BUTTON ENABLED
	// *******************************************************************************************************************************************
	public static void ProjectSearchButtonPlant(String colname, String colname1) throws InterruptedException {

		if (driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']")).isDisplayed()) {
			testCase = extent.createTest(colname + "PROEJCT MODULE PLANT FIELD SEARCH BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']")).isEnabled()) {
				testCase = extent.createTest(colname1 + "PROEJCT MODULE PLANT FIELD SEARCH BUTTON IS ENABLED");
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
				testCase = extent.createTest(colname1 + "PROEJCT MODULE PLANT FIELD SEARCH BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + "PROEJCT MODULE PLANT FIELD SEARCH BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
		// *************************************************************************************************************************

		boolean clickNextPage = true;

		boolean passorfail = true;
		ArrayList<String> actualList = new ArrayList<String>();
		ArrayList<String> expectedList = new ArrayList<String>();
		String nameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String nameXpath_lastPart = "]/td[2]";
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					String textFull = driver.findElement(By.xpath(nameXpath_firstPart + i + nameXpath_lastPart))
							.getText();
					String text = textFull.toLowerCase();
					// System.out.println(text);
					try {
						if (!text.contains(searchPlant)) {
							passorfail = false;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (text.contains(searchPlant)) {
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
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.PAGE_DOWN).build().perform();
				Thread.sleep(2000);

			} else {
				break;
			}
		}
		Thread.sleep(3000);
		ProjectPage.plantsearchiconbutton.click();
		Thread.sleep(3000);

	}

	public static void ProjectFSingleSearchConfirmPlant(String colname, int expected) {
		try {
			int Value = actualElementCount;
			System.out.println(Value);
			try {
				Assert.assertEquals(Value, expected);
				testCase = extent.createTest(colname + "PROJECT FIELD SINGLE SEARCH");
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

	}

	// ****************************************************************************************
	// STEP-05--PROJECT MODULE PROJECT FIELD SEARCH ICON IS DISPLAYED &
	// STEP-06--PROJECT MODULE PROJECT FIELD SEARCH ICON IS
	// ENABLED
	// ****************************************************************************************

	public static void ProjectSearchIconProject(String colname, String colname1) {
		if (driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[3]/div/span[2]/span"))
				.isDisplayed()) {
			testCase = extent.createTest(colname + "PROEJCT MODULE PLANT FIELD SEARCH ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[3]/div/span[2]/span"))
					.isEnabled()) {
				testCase = extent.createTest(colname1 + "PROJECT MODULE PLANT FIELD SEARCH ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					driver.findElement(By.xpath(
							"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[3]/div/span[2]/span"))
							.click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest(colname1 + "STEP-06--PROJECT MODULE PLANT FIELD SEARCH ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + "PROEJCT MODULE PLANT FIELD SEARCH ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

	}

	public static void ProjectSearchTextboxproject(String colname, String colname1, String searchdata) {
		if (ProjectPage.SearchTextBox.isDisplayed()) {

			testCase = extent.createTest(colname + "PROEJCT MODULE PLANT FIELD SEARCH TEXTBOX IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (ProjectPage.SearchTextBox.isEnabled()) {
				testCase = extent.createTest(colname1 + "PROEJCT MODULE PLANT FIELD SEARCH TEXTBOX ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					ProjectPage.SearchTextBox.sendKeys(searchdata);

					// driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

					Thread.sleep(3000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest(colname1 + "PROEJCT MODULE PLANT FIELD SEARCH TEXTBOX ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + "PROEJCT MODULE PLANT FIELD SEARCH TEXTBOX IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

	}

	// **************************************************************************************************************************************
	// STEP-08--CHECKING PROJECT MODULE PLANT FIELD SEARCH BUTTON DISPLAYED &
	// STEP-09--CHECKING
	// PROJECT MODULE PLANT FIELD SEARCH BUTTON ENABLED
	// *******************************************************************************************************************************************
	public static void ProjectSearchButtonProject(String colname, String colname1) throws InterruptedException {

		if (driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']")).isDisplayed()) {
			testCase = extent.createTest(colname + "PROEJCT MODULE PLANT FIELD SEARCH BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']")).isEnabled()) {
				testCase = extent.createTest(colname1 + "PROEJCT MODULE PLANT FIELD SEARCH BUTTON IS ENABLED");
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
				testCase = extent.createTest(colname1 + "PROEJCT MODULE PLANT FIELD SEARCH BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + "PROEJCT MODULE PLANT FIELD SEARCH BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
		// *************************************************************************************************************************

		boolean clickNextPage = true;

		boolean passorfail = true;
		ArrayList<String> actualList = new ArrayList<String>();
		ArrayList<String> expectedList = new ArrayList<String>();
		String nameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String nameXpath_lastPart = "]/td[2]";
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					String textFull = driver.findElement(By.xpath(nameXpath_firstPart + i + nameXpath_lastPart))
							.getText();
					String text = textFull.toLowerCase();
					// System.out.println(text);
					try {
						if (!text.contains(searchProjectname)) {
							passorfail = false;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (text.contains(searchProjectname)) {
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
		Thread.sleep(2000);
		ProjectPage.projectnamesearchiconbutton.click();
		Thread.sleep(3000);

	}

	public static void ProjectFSingleSearchConfirmProject(String colname, int expected) {
		try {
			int Value = actualElementCount;
			System.out.println(Value);
			try {
				Assert.assertEquals(Value, expected);
				testCase = extent.createTest(colname + "PROJECT FIELD SINGLE SEARCH");
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

	}

	public static void ProjectCheckValidation(String colname) throws IOException, InterruptedException {

		testCase = extent.createTest(colname + "CHECKING PROJECT FEILD VALIDATION");
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Project";
		String testCaseId = "TC-PRO-0067";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			String projectname = (String) row.getCell(1).getStringCellValue();
			String validation = (String) row.getCell(2).getStringCellValue();
			String Message = (String) row.getCell(3).getStringCellValue();

			Thread.sleep(1000);

			ProjectPage.projectname.sendKeys(projectname);
			ProjectPage.projectsavebutton.click();
			Thread.sleep(1000);
			String ActualValidation = ProjectPage.validationmsg.getText();
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

			Thread.sleep(3000);

			ProjectPage.projectname.sendKeys(Keys.CONTROL + "a", Keys.DELETE);

		}
		ProjectPage.CancelBtn.click();

	}

	// ********************************************************************************************************
	// THE METHOD IS FOR GENERATING REPORT
	// ********************************************************************************************************
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

	public static void ContactPersonCheckValidation(String colname) throws IOException, InterruptedException {

		ProjectPage.projectaddbtn.click();
		testCase = extent.createTest(colname + "CHECKING CONTACT NO FEILD VALIDATION");
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Project";
		String testCaseId = "TC-PRO-0067";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			String contactperson = (String) row.getCell(4).getStringCellValue();
			String validation = (String) row.getCell(5).getStringCellValue();
			String Message = (String) row.getCell(6).getStringCellValue();

			Thread.sleep(1000);

			ProjectPage.contactperson.sendKeys(contactperson);
			ProjectPage.projectsavebutton.click();
			Thread.sleep(1000);
			String ActualValidation = ProjectPage.contatpersonvalidationmsg.getText();
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

			Thread.sleep(3000);

			ProjectPage.contactperson.sendKeys(Keys.CONTROL + "a", Keys.DELETE);

		}
		ProjectPage.CancelBtn.click();
	}

	public static void ContactNoCheckValidation(String colname) throws IOException, InterruptedException {

		ProjectPage.projectaddbtn.click();
		testCase = extent.createTest(colname + "CHECKING CONTACT PERSON FEILD VALIDATION");
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Project";
		String testCaseId = "TC-PRO-0067";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			String contactperson = (String) row.getCell(7).getStringCellValue();
			String validation = (String) row.getCell(8).getStringCellValue();
			String Message = (String) row.getCell(9).getStringCellValue();

			Thread.sleep(1000);

			ProjectPage.contactnotextbox.sendKeys(contactperson);
			ProjectPage.projectsavebutton.click();
			Thread.sleep(1000);
			String ActualValidation = ProjectPage.contatnovalidationmsg.getText();
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

			Thread.sleep(3000);

			ProjectPage.contactnotextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);

		}
		ProjectPage.CancelBtn.click();
	}

	public static void Projectsearch(String colname, String colname1, String searchdata)
			throws InterruptedException, IOException {
		Thread.sleep(3000);
		String Name = searchdata;
		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[9]/span/a[1]/span";

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

							testCase = extent.createTest(colname + "CHECKING EDIT ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");

							if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart))
									.isEnabled()) {

								testCase = extent.createTest(colname1 + "CHECKING EDIT ICON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");
								Thread.sleep(3000);
								driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
								updateclick = true;
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
				Thread.sleep(2000);
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.PAGE_DOWN).build().perform();
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();

			} else {
				break;
			}
		}
		if (sbuExist = false) {
			System.out.println("No such Element" + sbuExist);
		}

	}

	public static void beforeEdit(String colname, String plant, String project, String customer, String person,
			String contact, String date) throws InterruptedException, IOException {

		PageFactory.initElements(driver, projectpage);

		testCase = extent.createTest(colname + "CONFIRMING VALUE BEFORE THE EDIT");
		try {
			String Value = ProjectPage.planttextbox.getText();
			String Value1 = ProjectPage.projecttextbox.getAttribute("value");
			String Value2 = ProjectPage.customertextbox.getText();
			String Value3 = ProjectPage.contactPersontextbox.getAttribute("value");
			String Value4 = ProjectPage.contactnotextbox.getAttribute("value");
			String Value5 = ProjectPage.startdatetextbox.getAttribute("value");

			TestCasePrint("CONFIRM PLANT NAME BEFORE THE EDIT", plant, String.valueOf(Value));
			TestCasePrint("CONFIRM PROJECT NAME BEFORE THE EDIT", project, String.valueOf(Value1));
			TestCasePrint("CONFIRM CUSTOMER BEFORE THE EDIT", customer, String.valueOf(Value2));
			TestCasePrint("CONFIRM CONTACT PERSON BEFORE THE EDIT", person, String.valueOf(Value3));
			TestCasePrint("CONFIRM CONTACT NO BEFORE THE EDIT", String.valueOf(contact), String.valueOf(Value4));
			TestCasePrint("CONFIRM START DATE BEFORE THE EDIT", String.valueOf(date), String.valueOf(Value5));

			beforeedit = true;
		} catch (Exception e) {
			TestCasePrint("CONFIRM PLANT NAME BEFORE THE EDIT", plant, String.valueOf(e));
			TestCasePrint("CONFIRM PROJECT NAME BEFORE THE EDIT", project, String.valueOf(e));
			TestCasePrint("CONFIRM CUSTOMER BEFORE THE EDIT", customer, String.valueOf(e));
			TestCasePrint("CONFIRM CONTACT PERSON BEFORE THE EDIT", person, String.valueOf(e));
			TestCasePrint("CONFIRM CONTACT NO BEFORE THE EDIT", String.valueOf(contact), String.valueOf(e));
			TestCasePrint("CONFIRM START DATE BEFORE THE EDIT", String.valueOf(date), String.valueOf(e));
		}

	}

	public static void ProjectEdit(String colname, String plant, String project, String customer, String person,
			int contact) throws InterruptedException, IOException {

		Thread.sleep(1500);
		try {
			ProjectPage.planttextbox.click();
			Thread.sleep(3000);
			ProjectPage.planttextenter.sendKeys(plant);
			Thread.sleep(3000);
			ProjectPage.dropdownfield.click();
			ProjectPage.projecttextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			ProjectPage.projecttextbox.sendKeys(project);
			ProjectPage.customername.click();
			Thread.sleep(2000);
			ProjectPage.customertextenter.sendKeys(customer);
			Thread.sleep(3000);
			ProjectPage.customernamedropdown.click();
			ProjectPage.contactPersontextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			ProjectPage.contactPersontextbox.sendKeys(person);
			ProjectPage.contactnotextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			ProjectPage.contactnotextbox.sendKeys(String.valueOf(contact));

			// ProjectPage.projectupdatebutton.click();

			testCase = extent.createTest(colname + "UNIT UPDATED SUCCESFULLY");
		} catch (Exception e) {
			testCase = extent.createTest("UNIT NAME IS NOT GET UPDATED");
		}
	}

	public static void ProjectUpdateButton() throws InterruptedException {
		testCase = extent.createTest("STEP-05 CHECKING UPDATE BUTTON UI PROPERTIES");
		try {
			boolean ExpectedTextVisible = true;
			System.out.println("IsVisible");
			boolean ActualTextVisible = ProjectPage.projectupdatebutton.isDisplayed();
			testCase = extent.createTest("1-UNIT-UPDATE-BUTTON-VISIBLE");
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

	public static void ProjectAftersearch(String colname, String colname1, String aftersearch)
			throws InterruptedException, IOException {
		Thread.sleep(3000);
		String Name = aftersearch;
		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[9]/span/a[1]/span";
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

							testCase = extent.createTest(colname + "CHECKING EDIT ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");

							if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart))
									.isEnabled()) {

								testCase = extent.createTest(colname1 + "CHECKING EDIT ICON IS ENABLED");
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

	public static void Projectnameconfirm(String colname, String check) throws InterruptedException, IOException {
		// String cofirmname = EditPlantPage.plantname.getText();
		// System.out.println("Confirm the Name " + cofirmname);
		try {
			Thread.sleep(4000);
			String Value = ProjectPage.projecttextbox.getAttribute("value");
			// System.out.println("plant name *************** " + plantName);
			// Thread.sleep(2000);
			// testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
			TestCasePrint(colname + "CONFIRM THE EDIT", check, String.valueOf(Value));

		} catch (Exception e) {
			TestCasePrint(colname + "CONFIRM THE EDIT", check, String.valueOf(e));
		}
		ProjectPage.CancelBtn.click();
	}

	public static void ProjecteditedFirstRow(String colname, String datarow) throws InterruptedException, IOException {
		try {
			ProjectPage.tableFirstRow.click();
			String Value = ProjectPage.projecttextbox.getAttribute("value");

			System.out.println(Value);
			TestCasePrint(colname + "CONFIRM THE EDITED VALUE IN THE FIRST ROW", datarow, String.valueOf(Value));
		} catch (Exception e) {
			TestCasePrint(colname + "CONFIRM THE EDITED VALUE IN THE FIRST ROW", datarow, String.valueOf(e));
		}
	}

	public static void ProjectsearchMid() throws InterruptedException, IOException {
		Thread.sleep(3000);
		String Name = "JB-PRJ-124";
		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[9]/span/a[1]/span";
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

	public static void beforeEditMid() throws InterruptedException, IOException {

		testCase = extent.createTest("STEP-03-CONFIRMING VALUE BEFORE THE EDIT");
		try {
			String Value = ProjectPage.planttextbox.getText();
			String Value1 = ProjectPage.projecttextbox.getAttribute("value");
			String Value2 = ProjectPage.customertextbox.getText();
			String Value3 = ProjectPage.contactPersontextbox.getAttribute("value");
			String Value4 = ProjectPage.contactnotextbox.getAttribute("value");
			String Value5 = ProjectPage.startdatetextbox.getAttribute("value");

			TestCasePrint("CONFIRM PLANT NAME BEFORE THE EDIT", "RMC Jaffna Plant", String.valueOf(Value));
			TestCasePrint("CONFIRM PROJECT NAME BEFORE THE EDIT", "BUILDING", String.valueOf(Value1));
			TestCasePrint("CONFIRM CUSTOMER BEFORE THE EDIT", "ANNAI HOLDINGS", String.valueOf(Value2));
			TestCasePrint("CONFIRM CONTACT PERSON BEFORE THE EDIT", "MR.VISHNU", String.valueOf(Value3));
			TestCasePrint("CONFIRM CONTACT NO BEFORE THE EDIT", "0771685789", String.valueOf(Value4));
			TestCasePrint("CONFIRM START DATE BEFORE THE EDIT", "2022-03-17", String.valueOf(Value5));
		} catch (Exception e) {
			TestCasePrint("CONFIRM PLANT NAME BEFORE THE EDIT", "RMC Jaffna Plant", String.valueOf(e));
			TestCasePrint("CONFIRM PROJECT NAME BEFORE THE EDIT", "BUILDING", String.valueOf(e));
			TestCasePrint("CONFIRM CUSTOMER BEFORE THE EDIT", "ANNAI HOLDINGS", String.valueOf(e));
			TestCasePrint("CONFIRM CONTACT PERSON BEFORE THE EDIT", "MR.VISHNU", String.valueOf(e));
			TestCasePrint("CONFIRM CONTACT NO BEFORE THE EDIT", "0771685789", String.valueOf(e));
			TestCasePrint("CONFIRM START DATE BEFORE THE EDIT", "2022-03-17", String.valueOf(e));
		}

	}

	public static void ProjectEditMid() throws InterruptedException, IOException {

		Thread.sleep(1500);
		try {
			ProjectPage.planttextbox.click();
			Thread.sleep(3000);
			ProjectPage.planttextenter.sendKeys("RMC Ankanda Plant");
			Thread.sleep(3000);
			ProjectPage.dropdownfield.click();
			ProjectPage.projecttextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			ProjectPage.projecttextbox.sendKeys("Checkss");
			ProjectPage.customername.click();
			Thread.sleep(2000);
			ProjectPage.customertextenter.sendKeys("CMK Construction");
			Thread.sleep(3000);
			ProjectPage.customernamedropdown.click();
			ProjectPage.contactPersontextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			ProjectPage.contactPersontextbox.sendKeys("test");
			ProjectPage.contactnotextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			ProjectPage.contactnotextbox.sendKeys("2345678765");

			// ProjectPage.projectupdatebutton.click();

			testCase = extent.createTest("STEP-04 UNIT UPDATED SUCCESFULLY");
		} catch (Exception e) {
			testCase = extent.createTest("UNIT NAME IS NOT GET UPDATED");
		}
	}

	public static void ProjectUpdateButtonMid() throws InterruptedException {
		testCase = extent.createTest("STEP-05 CHECKING UPDATE BUTTON UI PROPERTIES");
		try {
			boolean ExpectedTextVisible = true;
			System.out.println("IsVisible");
			boolean ActualTextVisible = ProjectPage.projectupdatebutton.isDisplayed();
			testCase = extent.createTest("1-UNIT-UPDATE-BUTTON-VISIBLE");
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

	public static void ProjectAftersearchMid() throws InterruptedException, IOException {
		Thread.sleep(3000);
		String Name = "JB-PRJ-124";
		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[9]/span/a[1]/span";
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

	public static void ProjectnameconfirmMid() throws InterruptedException, IOException {
		// String cofirmname = EditPlantPage.plantname.getText();
		// System.out.println("Confirm the Name " + cofirmname);
		try {
			Thread.sleep(4000);
			String Value = ProjectPage.projecttextbox.getAttribute("value");
			// System.out.println("plant name *************** " + plantName);
			// Thread.sleep(2000);
			// testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
			TestCasePrint("STEP-09--CONFIRM THE EDIT", "Checkss", String.valueOf(Value));

		} catch (Exception e) {
			TestCasePrint("CONFIRM THE EDIT", "Checkss", String.valueOf(e));
		}
		ProjectPage.CancelBtn.click();
	}

	public static void ProjecteditedFirstRowMid() throws InterruptedException, IOException {
		try {
			ProjectPage.tableFirstRow.click();
			String Value = ProjectPage.projecttextbox.getAttribute("value");

			System.out.println(Value);
			TestCasePrint("STEP-10--CONFIRM THE EDITED VALUE IN THE FIRST ROW", "Checkss", String.valueOf(Value));
		} catch (Exception e) {
			TestCasePrint("STEP-10--CONFIRM THE EDITED VALUE IN THE FIRST ROW", "Checkss", String.valueOf(e));
		}
	}

	public static void ProjectLeftMenuButton(String colname, String colname1) throws InterruptedException, IOException {

		// PageFactory.initElements(driver, UnitPage);

		if (ProjectPage.projectleftmenubutton.isDisplayed()) {
			testCase = extent.createTest(colname + "BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (ProjectPage.projectleftmenubutton.isEnabled()) {
				testCase = extent.createTest(colname1 + "BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					Thread.sleep(2000);
					ProjectPage.projectleftmenubutton.click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}
				Thread.sleep(3000);
			} else {
				testCase = extent.createTest(colname1 + "BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + "BUTTON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void ProjectcloseButton() throws InterruptedException, IOException {

		// PageFactory.initElements(driver, UnitPage);

		if (ProjectPage.ProjectCloseButton.isDisplayed()) {
			testCase = extent.createTest("STEP-02-- CLOSE BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (ProjectPage.ProjectCloseButton.isEnabled()) {
				testCase = extent.createTest("STEP-03-- CLOSE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					Thread.sleep(2000);
					ProjectPage.ProjectCloseButton.click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}
				Thread.sleep(3000);
			} else {
				testCase = extent.createTest("STEP-03-- CLOSE BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-02-- CLOSE BUTTON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void ProjectDeleteButton(String colname, String colname1) throws InterruptedException, IOException {

		if (ProjectPage.projectdeleteicon.isDisplayed()) {
			testCase = extent.createTest(colname + "ICON BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (ProjectPage.projectdeleteicon.isEnabled()) {
				testCase = extent.createTest(colname1 + "ICON BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					Thread.sleep(2000);
					ProjectPage.projectdeleteicon.click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}
				Thread.sleep(3000);
			} else {
				testCase = extent.createTest(colname1 + "ICON BUTTON IS DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + "ICON BUTTON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void ProjectCancelButton(String colname, String colname1) throws InterruptedException, IOException {

		// PageFactory.initElements(driver, UnitPage);
		Thread.sleep(2000);
		if (ProjectPage.projectcancelbutton.isDisplayed()) {
			testCase = extent.createTest(colname + " BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (ProjectPage.projectcancelbutton.isEnabled()) {
				testCase = extent.createTest(colname1 + " BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					Thread.sleep(2000);
					ProjectPage.projectcancelbutton.click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}
				Thread.sleep(3000);
			} else {
				testCase = extent.createTest(colname1 + " BUTTON IS DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + " BUTTON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void sendValues(WebElement xpath, String excelData, String displayedReport, String enabledReport) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(xpath));
			if (xpath.isDisplayed()) {
				testCase = extent.createTest(displayedReport);
				testCase.log(Status.PASS, "TEST PASS ☑");
				if (xpath.isEnabled()) {
					testCase = extent.createTest(enabledReport);
					testCase.log(Status.PASS, "TEST PASS ☑");
					wait.until(ExpectedConditions.elementToBeClickable(xpath));
					xpath.click();
					xpath.sendKeys(excelData);
				} else {
					testCase = extent.createTest(enabledReport);
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest(displayedReport);
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT FOUND");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT FOUND OR CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void startdate(WebElement xpath, WebElement xpath1, String excelData, String displayedReport,
			String enabledReport) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(xpath));
			if (xpath.isDisplayed()) {
				testCase = extent.createTest(displayedReport);
				testCase.log(Status.PASS, "TEST PASS ☑");
				if (xpath.isEnabled()) {
					testCase = extent.createTest(enabledReport);
					testCase.log(Status.PASS, "TEST PASS ☑");
					wait.until(ExpectedConditions.elementToBeClickable(xpath));
					xpath.click();
					xpath.sendKeys(excelData);
					xpath1.click();
				} else {
					testCase = extent.createTest(enabledReport);
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest(displayedReport);
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT FOUND");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT FOUND OR CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void plantfield(String colname, String colname1, String colname2) {

		ArrayList<String> projectlist = new ArrayList<String>();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, projectpage);
		if (ProjectPage.enterplant.isDisplayed()) {
			testCase = extent.createTest(colname1 + "DROP DOWN IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (ProjectPage.enterplant.isEnabled()) {
				testCase = extent.createTest(colname2 + "DROP DOWN IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				Actions actions = new Actions(driver);
				ProjectPage.enterplant.click();

				try {
					boolean pass = true;
					while (pass) {
						if (pass) {
							try {
								try {
									String gettigdata = null;
									try {
										wait.until(ExpectedConditions.elementToBeClickable(By
												.xpath("//div[@id='plant_list']/../div[2]/div[1]/div/div/div[2]/div")));
									} catch (Exception e) {
										// TODO: handle exception
									}
									try {
										gettigdata = driver
												.findElement(By.xpath(
														"//div[@id='plant_list']/../div[2]/div[1]/div/div/div[2]/div"))
												.getText();
									} catch (Exception e) {
										// TODO: handle exception
									}
									projectlist.add(gettigdata);
									int inb = projectlist.size();
									if (inb >= 11) {
										if (projectlist.get(9).equals(gettigdata)) {
											break;
										}
									}
								} catch (Exception e) {
								}
								WebElement list = driver.findElement(By.xpath("//div[text()='" + colname + "']"));
								System.out.println(list);
								list.click();
								pass = false;
							} catch (Exception e) {
							}
						}
						if (pass) {
							actions.sendKeys(Keys.ARROW_DOWN).perform();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				testCase = extent.createTest(colname2 + "DROP DOWN IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname1 + "DROP DOWN IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
	}

	public static void customerfield(String colname, String colname1, String colname2) throws InterruptedException {

		PageFactory.initElements(driver, projectpage);
		if (ProjectPage.customername.isDisplayed()) {
			testCase = extent.createTest(colname1 + "DROP DOWN IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (ProjectPage.customername.isEnabled()) {
				testCase = extent.createTest(colname2 + "DROP DOWN IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				ProjectPage.customername.click();
				Thread.sleep(2000);
				ProjectPage.customertextenter.sendKeys(colname);
				Thread.sleep(1000);
				ProjectPage.customertextenter.sendKeys(Keys.ENTER);

			} else {
				testCase = extent.createTest(colname2 + "DROP DOWN IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname1 + "DROP DOWN IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
	}

	public static void ProjectSaveButton() throws InterruptedException {

		PageFactory.initElements(driver, projectpage);
		clickSaveButton = false;

		WebDriverWait wait = new WebDriverWait(driver, 20);

		MultiSearchMethods.Buttons(ProjectPage.projectsavebutton, "Add Unit");
		if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(ProjectPage.projectsavebutton));
				ProjectPage.projectsavebutton.click();
				clickSaveButton = true;

			} catch (Exception e) {
				testCase.log(Status.INFO, "Add Unit Button Clicked Fail");
				testCase.log(Status.FAIL, "Unit Save Button not Visible, Button Clicked Fail");
			}
		}
	}

	public static void addedValueCheck(String colname, String colname1) throws InterruptedException {

		PageFactory.initElements(driver, projectpage);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		boolean unitSaveBtnVisible = false;
		try {
//		wait.until(ExpectedConditions.invisibilityOf(SbuPage.addSbuBtn));
			Thread.sleep(1000);
			Assert.assertEquals(ProjectPage.projectsavebutton.isDisplayed(), true);
			unitSaveBtnVisible = true;
		} catch (AssertionError e) {
			unitSaveBtnVisible = false;
		} catch (Exception e) {
			unitSaveBtnVisible = false;
		}
		if (unitSaveBtnVisible) {
			String validation = null;
			try {
				wait.until(ExpectedConditions.visibilityOf(ProjectPage.validationmsg));
				validation = ProjectPage.validationmsg.getText();
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
				testCase = extent.createTest("Already Exists Validation Throwing For UNIT :- " + colname);
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
								driver.findElements(By.xpath("//td[1][text()='" + colname + "']"))));
						x = driver.findElements(By.xpath("//td[1][text()='" + colname + "']")).size();
					} catch (Exception e) {
						e.printStackTrace();
					}

					if (x == 1) {
						checkValue = true;
						break;
					}
					try {
						ProjectPage.NextPageBtn.click();
						WebDriverWait wai = new WebDriverWait(driver, 2);
						wai.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//tr"))));
					} catch (Exception e) {

					}
				}
				testCase = extent.createTest("Already Exists Validation Conformation For UNIT :- " + colname);
				if (checkValue) {
					testCase.log(Status.INFO, "UNIT :- " + colname + " Already Exits in UNIT Table");
					testCase.log(Status.INFO, "UNIT :- " + colname + " Founded In UNIT Table");
					testCase.log(Status.FAIL, "So, Add UNIT Script Fail");
				} else {
					testCase.log(Status.INFO, "SBU :- " + colname + " Not in UNIT Table");
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
			testCase = extent.createTest("SBU :- " + colname + " - Adding Success Message");
			try {
				Assert.assertEquals(ProjectPage.successMessages.getText(), colname1);
				testCase.log(Status.INFO, "Actual Success Message :- " + ProjectPage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + colname);
				testCase.log(Status.PASS, "Success Message  Matching, So Throwing Success Message Pass");
				success = true;
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Success Message :- " + ProjectPage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + colname);
				testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
			} catch (Exception e) {
				testCase.log(Status.INFO, "Actual Success Message :- " + ProjectPage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + colname);
				testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
			}

			if (success) {
				testCase = extent.createTest("SBU :- " + colname + " - Added Value Check In First Row");

				try {
					Assert.assertEquals(ProjectPage.firstRowData.getText(), colname);
					testCase.log(Status.INFO, "UNIT :- " + colname + " Added Check in First Row");
					testCase.log(Status.INFO, "Added Value Founded In First Row");
					testCase.log(Status.PASS, "So, Add UNIT Script Pass");
				} catch (Exception e) {
					testCase.log(Status.INFO, "UNIT :- " + colname + " Added Check in First Row");
					testCase.log(Status.INFO, "Added Value Not Founded In First Row");
					testCase.log(Status.FAIL, "So, Add UNIT Script Fail");
				}
			}

			if (success) {

				try {
					ProjectPage.successMessageCloseBtn.click();
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
							driver.findElements(By.xpath("//td[1][text()='" + colname + "']"))));
					x = driver.findElements(By.xpath("//td[1][text()='" + colname + "']")).size();
				} catch (Exception e) {
					e.printStackTrace();
				}
				counts = counts + x;

				try {
					enable = ProjectPage.NextPageBtn.isEnabled();
//		Click Next page Button
					if (enable) {

						ProjectPage.NextPageBtn.click();
						wai.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//tr"))));
					}
				} catch (Exception e) {

				}

			}
			System.out.println(counts + "::::::::::::::::");
			testCase = extent.createTest("UNIT :- " + colname + " - Added Value Check In UNIT Table");
			if (counts == 1) {
				testCase.log(Status.INFO, "UNIT :- " + colname + " Added Check in UNIT Table");
				testCase.log(Status.INFO, "Added Value Founded In UNIT Table");
				testCase.log(Status.PASS, "So, Add UNIT Script Pass");
			} else {
				testCase.log(Status.INFO, "UNIT :- " + colname + " Added Check in UNIT Table");
				testCase.log(Status.INFO, "Added Value Duplicate In UNIT Table");
				testCase.log(Status.FAIL, "So, Add UNIT Script Fail");
			}
			driver.navigate().refresh();
		}

	}

	public static void buttonClick(WebElement xpath, WebElement successmsg, String reportDisplay, String reportEnable,
			String whichElement, String excelmsg) throws InterruptedException, IOException {

		String success = "";
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
			wait.until(ExpectedConditions.visibilityOf(xpath));
		} catch (Exception e) {
			testCase = extent.createTest("THE " + whichElement + " IS NOT FOUND");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
		if (xpath.isDisplayed()) {
			testCase = extent.createTest(reportDisplay);
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (xpath.isEnabled()) {
				testCase = extent.createTest(reportEnable);
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					wait.until(ExpectedConditions.elementToBeClickable(xpath));
					xpath.click();
					wait.until(ExpectedConditions.visibilityOf(successmsg));
					success = successmsg.getText();
					System.out.println("SUCCESS MESSAGE" + success);

					testCase = extent.createTest(excelmsg);
					try {
						Assert.assertEquals(success, excelmsg);
						testCase.log(Status.INFO, excelmsg);
						testCase.log(Status.INFO, excelmsg);
						testCase.log(Status.PASS, excelmsg);
					} catch (Exception e) {
						testCase.log(Status.INFO, "Success Message Failed");
						testCase.log(Status.INFO, "Success Message Failed");
						testCase.log(Status.FAIL, "Success Message Failed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("THERE IS NO ELEMENT");
					testCase.log(Status.INFO, "ELEMENT IS NOT FOUND");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				} catch (ElementClickInterceptedException e) {
					testCase = extent.createTest("THERE IS NO ELEMENT");
					testCase.log(Status.INFO, "ELEMENT IS NOT CLICKED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				} catch (Exception e) {
					testCase = extent.createTest("THERE IS NO ELEMENT");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-19--SAVE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-18--SAVE BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
	}

	public static void errorMessage() {

		PageFactory.initElements(driver, projectpage);

		String errme = ProjectPage.projectvalidation.getText();
		if (errme == "") {
			errme = ProjectPage.customerValidation.getText();
			if (errme == "") {
				errme = ProjectPage.contactpersonValidation.getText();
				if (errme == "") {
					errme = ProjectPage.contactnoValidation.getText();
					if (errme == "") {
						errme = ProjectPage.startdateValidation.getText();
					}
				}
			}
		}

		testCase = extent.createTest("THE VALIDATION MESSAGE IS APPEAR");
		testCase.log(Status.INFO, "THE VALIDATION MESSAGE IS : " + errme);
		testCase.log(Status.FAIL, "TEST FAIL ❎");
	}

	public static void confirmAdd(String data1) throws InterruptedException, IOException {

		String actualdata = ProjectPage.ProjectTablename.getText();
		System.out.println("First row of table : " + actualdata);

		boolean firstdata = true;
		testCase = extent.createTest("STEP-17.CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE");
		try {
			AssertJUnit.assertEquals(actualdata, data1);

		} catch (AssertionError e) {
			firstdata = false;
		}
		if (firstdata) {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + data1);
			testCase.log(Status.PASS, "Correct last data added in first row");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + data1);
			testCase.log(Status.FAIL, "Wrong Last Data Not Added in first row");
		}

	}

}
