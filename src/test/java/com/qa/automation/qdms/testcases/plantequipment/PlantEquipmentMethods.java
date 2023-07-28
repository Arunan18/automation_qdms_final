
package com.qa.automation.qdms.testcases.plantequipment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;

public class PlantEquipmentMethods extends DriverIntialization {

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

	static PlantEquipmentPage PlantequipmentMethod = new PlantEquipmentPage();

	@Test(priority = 0)
	public static void PlantEquipmentPagination() throws InterruptedException {

		// UnitPaginationPages UnitPage = new UnitPaginationPages();
		PageFactory.initElements(driver, PlantequipmentMethod);
		// Thread.sleep(1000);
//		PlantEquipmentPage.masterBtn.click();
//		Thread.sleep(2000);
		PlantEquipmentPage.Equipmentmenu.click();
		// Thread.sleep(1000);
		PlantEquipmentPage.PlantEquipment.click();
		// Thread.sleep(1000);

	}

	public static void Excel() throws IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Plant Equipment";
		String testCaseId = "TC-PLA-EQU-0063";

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

	@Test(priority = 1)
	public static void DefaultIndexPage(String colname) throws InterruptedException {

		boolean ActualDefaultPageIndex = PlantEquipmentPage.DefaultPaginationPage.isDisplayed();

		testCase = extent.createTest(colname + "PAGINATION-DEFAULT-PAGE-INDEX");
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
	}

	@Test(priority = 2)
	public static void RefreshDefaultPage(String colname) throws InterruptedException {
		// UnitPaginationPages UnitPage = new UnitPaginationPages();

		PlantEquipmentPage.NextPageBtn.click();
		// Thread.sleep(2000);
		driver.navigate().refresh();
		// Thread.sleep(2000);
		PlantEquipmentPage.PlantEquipment.click();
		// Thread.sleep(1000);

		boolean ActualDefaultPageIndex1 = PlantEquipmentPage.DefaultPaginationPage.isDisplayed();

		testCase = extent.createTest(colname + "PAGINATION-REFERESH-INTO-DEFAULT-PAGE");
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
	}

//		Page Redirect to the next page 

	@Test(priority = 3)
	public static void PageRedrict(String colname) throws InterruptedException {

		PlantEquipmentPage.NextPageBtn.click();
		Thread.sleep(3000);
		boolean ActualSecoundPageIndex = PlantEquipmentPage.PaginationSecoundPage.isDisplayed();

		testCase = extent.createTest(colname + "PAGINATION-PAGE-REDIRECT-TO-NEXT-PAGE");
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
	}

//		Previous Button Displayed
	@Test(priority = 4)
	public static void PreButtonDispaly(String colname) throws InterruptedException {

		// UnitPaginationPages UnitPage = new UnitPaginationPages();
		boolean ActualVisiblePreviousButton = PlantEquipmentPage.PreviousPageBtn.isDisplayed();
		boolean ExpectedVisiblePreviousButton = true;
		testCase = extent.createTest(colname +"PAGINATION-PREVIOUS-BUTTON-VISIBLE");
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
	}

//		Next Button Displayed
	@Test(priority = 5)
	public static void NextButtonDispaly(String colname) throws InterruptedException {

		boolean ActualVisibleNextButton = PlantEquipmentPage.NextPageBtn.isDisplayed();

		testCase = extent.createTest(colname + "PAGINATION-NEXT-BUTTON-VISIBLE");
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
	}

//	Next Button Enable
	@Test(priority = 6)
	public static void NextButtonEanble() throws InterruptedException {

		boolean ActualNextBtnEnable = PlantEquipmentPage.NextPageBtn.isEnabled();
		boolean ExpectedNextBtnEnable = true;
		testCase = extent.createTest("STEP-06-PAGINATION-NEXT-BUTTON-ENABLE");
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
		// Thread.sleep(2000);
		driver.navigate().refresh();

		// Thread.sleep(2000);
		PlantEquipmentPage.PlantEquipment.click();
		Thread.sleep(1000);
	}

//	Before move to 2nd page, previous button disable
	@Test(priority = 7)
	public static void SecPagepreButDisable(String colname) throws InterruptedException {
		Thread.sleep(2000);
		boolean ActualPreviousBtnDisable = PlantEquipmentPage.PreviousPageBtn.isEnabled();

		testCase = extent.createTest(colname + "PAGINATION-PREVIOUS-BUTTON-DISABLE-BEFORE MOVE THE 2ND PAGE");
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

	}

//		After move to 2nd page, previous button Enable
	@Test(priority = 8)
	public static void AfterMovetoSecPagepreButEnable(String colname) throws InterruptedException {

		PlantEquipmentPage.NextPageBtn.click();
		Thread.sleep(3000);
		boolean ActualPreviousBtnEnable = PlantEquipmentPage.PreviousPageBtn.isEnabled();
		System.out.println(ActualPreviousBtnEnable);
		testCase = extent.createTest(colname + "PAGINATION-PREVIOUS-BUTTON-DISABLE-AFTER MOVE THE 2ND PAGE");
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

		driver.navigate().refresh();
		// Thread.sleep(2000);
		PlantEquipmentPage.PlantEquipment.click();
		Thread.sleep(1000);
	}

	@Test(priority = 9)
	public static void TotalPage(String colname) throws InterruptedException {

		String DataCountText = PlantEquipmentPage.paginationCount.getText();

		System.out.println(DataCountText);
		Pattern pattern = Pattern.compile("\\d+ of (\\d+)");
		System.out.println(pattern);
		Matcher matcher = pattern.matcher(DataCountText);
		if (matcher.find()) {
			String pageCount = matcher.group(1);
			double Value = Integer.parseInt(pageCount) / 10;
			int Finalvalue = (int) Math.ceil(Value);
			System.out.println("Total pages: " + Finalvalue);

			testCase = extent.createTest(colname + "Checking Total Page for 10 Data per page");
			try {
				Assert.assertEquals(Finalvalue, ExpectedPageCount);

				testCase.log(Status.INFO, "Actual Page Count :- " + Finalvalue);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedPageCount);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {

				testCase.log(Status.INFO, "Actual Page Count :- " + Finalvalue);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedPageCount);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}

		}
	}

//		String DataCountText = PlantEquipmentPage.paginationCount.getText();
//		System.out.println(DataCountText);
//		Pattern pattern = Pattern.compile("\\d+ of (\\d+)");
//		Matcher matcher = pattern.matcher(DataCountText);
//		if (matcher.find()) {
//			String pageCount = matcher.group(1);
//			System.out.println("Total pages: " + pageCount);
//
//			int Expected =10;
//			testCase = extent.createTest("STEP-9 Checking Total Page for 10 Data per page");
//			try {
//				Assert.assertEquals(pageCount, Expected);
//				testCase.log(Status.INFO, "ActualElement :- " + pageCount);
//				testCase.log(Status.INFO, "ExpectedElement :- " + Expected);
//				testCase.log(Status.PASS, "Enable element");
//			} catch (AssertionError e) {
//				testCase.log(Status.INFO, "ActualElement :- " + pageCount);
//				testCase.log(Status.INFO, "ExpectedElement :- " + Expected);
//				testCase.log(Status.FAIL, "Not Enable Element");
//			}
//		}
//	}

	@Test(priority = 10)
	public static void Pages(String colname, String colname1, String colname2) throws InterruptedException {

		int ActualTotalPage = 1;
		boolean Enablity = PlantEquipmentPage.NextPageBtn.isEnabled();
		while (Enablity) {
			Thread.sleep(1000);
			PlantEquipmentPage.NextPageBtn.click();
			ActualTotalPage = ActualTotalPage + 1;
			Enablity = PlantEquipmentPage.NextPageBtn.isEnabled();
		}
		System.out.println(ActualTotalPage);
		Thread.sleep(2000);

		if (PlantEquipmentPage.CurrentPaginationOpction.getText().contentEquals("10 / page")) {

			int ExpectedTotalPage = 10;
			testCase = extent.createTest("STEP-09 Checking Total Page for 10 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + PlantEquipmentPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + PlantEquipmentPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (PlantEquipmentPage.CurrentPaginationOpction.getText().contentEquals("20 / page")) {

			testCase = extent.createTest(colname + "Checking Total Page for 20 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage20);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + PlantEquipmentPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage20);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + PlantEquipmentPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage20);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (PlantEquipmentPage.CurrentPaginationOpction.getText().contentEquals("30 / page")) {

			testCase = extent.createTest(colname1 + "Checking Total Page for 30 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage30);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + PlantEquipmentPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage30);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + PlantEquipmentPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage30);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (PlantEquipmentPage.CurrentPaginationOpction.getText().contentEquals("100 / page")) {

			testCase = extent.createTest(colname2 + "Checking Total Page for 100 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage100);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + PlantEquipmentPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage100);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + PlantEquipmentPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage100);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}

		}
		driver.navigate().refresh();

		Thread.sleep(2000);
		PlantEquipmentPage.PlantEquipment.click();
		Thread.sleep(2000);
	}

	@Test(priority = 11)
	public static void PlantEquipmentImport() throws InterruptedException, FileNotFoundException, AWTException {

		Thread.sleep(2000);
		PlantEquipmentPage.ImportButton.click();

		Thread.sleep(2000);
		String file = "C:\\Users\\Priyanka\\Export\\Project.csv";

		StringSelection selection = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	@Test(priority = 11)
	public static void ProjectImportButton() throws InterruptedException {
		testCase = extent.createTest("PLANT-EQUIPMENT-IMPORT-BUTTON UI PROPERTIES");
		try {
			boolean ExpectedTextVisible = true;
			System.out.println("IsVisible");
			boolean ActualTextVisible = PlantEquipmentPage.ImportButton.isDisplayed();
			testCase = extent.createTest("1-PLANT-EQUIPMENT-IMPORT-BUTTON-VISIBLE");
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
			String ActualTitleFontColor = PlantEquipmentPage.ImportButton.getCssValue("color");
			System.out.println("Font color of button: " + ActualTitleFontColor);
			String ExpectedTitleFontColor = "rgba(255, 255, 255, 1)";
			testCase = extent.createTest("2.PLANT-EQUIPMENT-IMPORT-BUTTON-FONT-COLOUR");

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
			testCase = extent.createTest("2.PLANT-EQUIPMENT-IMPORT-BUTTON-FONT-COLOUR");
			testCase.log(Status.FAIL, "No element");
		}

		// Employee Import Button FONTSIZE

		try {
			String ActualTitleFontsSize = PlantEquipmentPage.ImportButton.getCssValue("font-size");
			System.out.println("Font Size: " + ActualTitleFontsSize);
			String ExpectedTitleFontsSize = "14px";
			testCase = extent.createTest("3.PLANT-EQUIPMENT-IMPORT-BUTTON-FONT-SIZE");
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
			testCase = extent.createTest("3.PROJECT-IMPORT-BUTTON-FONT- SIZE");
			testCase.log(Status.FAIL, "No Element");
		}

		// Employee Import Button Font-Family

		try {
			String ActualElementfamily = PlantEquipmentPage.ImportButton.getCssValue("font-family");
			System.out.println("FONT-FAMILY: " + ActualElementfamily);
			String ExpectedElementFamily = "Roboto, sans-serif";
			testCase = extent.createTest("4.PLANT-EQUIPMENT-IMPORT-BUTTON-FONT-FAMILY");
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
			testCase = extent.createTest("4.PROJECT-IMPORT-BUTTON-FONT-FAMILY");
			testCase.log(Status.FAIL, "NO ELEMENT");
		}

		// Employee Import Button Spelling

		try {
			String AcctualTitleText = PlantEquipmentPage.ImportButton.getText();
			String ExpectedTitleText = "Import";
			System.out.println(" Text:" + AcctualTitleText);
			testCase = extent.createTest("5.PLANT-EQUIPMENT-IMPORT-BUTTON-SPELLING-TEXT");
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
			testCase = extent.createTest("5.PLANT-EQUIPMENT-IMPORT-BUTTON-SPELLING-TEXT");
			testCase.log(Status.FAIL, "No Element");
		}

		// Employee Import Button Position

		try {
			Point ActulalLocation = PlantEquipmentPage.ImportButton.getLocation();
			int actual_x = ActulalLocation.getX();
			int actual_y = ActulalLocation.getY();
			System.out.println("X axis: " + actual_x);
			System.out.println("Y axis: " + actual_y);
			Point ExpectedLocation = new Point(962, 93);

			testCase = extent.createTest("6.PLANT-EQUIPMENT-IMPORT-BUTTON-POSITION");
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
			testCase = extent.createTest("6.PLANT-EQUIPMENT-IMPORT-BUTTON-POSITION");
			testCase.log(Status.FAIL, "NO ELEMENT");

		}

		// Employee Import Button Padding

		try {
			String Actualpadding = PlantEquipmentPage.ImportButton.getCssValue("padding");
			System.out.println("PADDING: " + Actualpadding);
			String Expectedpadding = "4px 16px";
			testCase = extent.createTest("7.PLANT-EQUIPMENT-IMPORT-BUTTON-TEXT-PADDING");
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
			testCase = extent.createTest("7.PLANT-EQUIPMENT-IMPORT-BUTTON-PADDING");
			testCase.log(Status.FAIL, "NO ELEMENT");
		}

		// Employee Import Button Shadow

		try {
			String Actualshadow = PlantEquipmentPage.ImportButton.getCssValue("box-shadow");
			System.out.println("Text Shadow :" + Actualshadow);
			String ExpectedShadow = "rgba(0, 0, 0, 0.043) 0px 2px 0px 0px";
			testCase = extent.createTest("8.PLANT-EQUIPMENT-IMPORT-BUTTON-BOX-SHADOW");
			try {
				AssertJUnit.assertEquals(Actualshadow, ExpectedShadow);
				testCase.log(Status.INFO, "ActualShadow :- " + Actualshadow);
				testCase.log(Status.INFO, "ExpectedShadow :- " + ExpectedShadow);
				testCase.log(Status.PASS, "Shadow available");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualShadow :- " + Actualshadow);
				testCase.log(Status.INFO, "ExpectedShadow :- " + ExpectedShadow);
				testCase.log(Status.FAIL, "Shadow not available");
			}
		} catch (Exception e) {
			testCase = extent.createTest("8.PLANT-EQUIPMENT-IMPORT-BUTTON-BOX-SHADOW");
			testCase.log(Status.FAIL, "No Element");
		}

		// Employee Import Button Background Color

		try {
			String Actualbackground = PlantEquipmentPage.ImportButton.getCssValue("color");
			System.out.println("BACKGROUND COLOR:" + Actualbackground);
			String Expectedbackground = "rgba(255, 255, 255, 1)";

			testCase = extent.createTest("9.PLANT-EQUIPMENT-IMPORT-BUTTON-BACKGROUND COLOR");
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
			testCase = extent.createTest("9.PLANT-EQUIPMENT-IMPORT-BUTTON-BACKGROUND COLOR");
		}

		// Employee Import Button BORDER COLOR
		try {
			String actualbordercolor = PlantEquipmentPage.ImportButton.getCssValue("border-color");
			System.out.println(" border-color:" + actualbordercolor);
			String Expectedbordercolor = "rgb(255, 255, 255)";
			testCase = extent.createTest("10.PLANT-EQUIPMENT-IMPORT-BUTTON-BORDER-COLOR");
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
			testCase = extent.createTest("10.PLANT-EQUIPMENT-IMPORT-BUTTON-BORDER-COLOR");
		}

		// Employee Import Button CURSER POINT

		try {
			String ActualCursor = PlantEquipmentPage.ImportButton.getCssValue("cursor");
			System.out.println("cursor :" + ActualCursor);
			String Expectedcursor = "pointer";
			testCase = extent.createTest("11.PLANT-EQUIPMENT-IMPORT-BUTTON-CURSOR");
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
			testCase = extent.createTest("11.PLANT-EQUIPMENT-IMPORT-BUTTON-CURSOR");
		}

		// Employee Import Button OPACITY

		try {
			String Actualopacity = PlantEquipmentPage.ImportButton.getCssValue("opacity");
			System.out.println("OPACITY :" + Actualopacity);

			String Expectedopacity = "1";
			testCase = extent.createTest("12.PLANT-EQUIPMENT-IMPORT-BUTTON-OPACITY");
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
			testCase = extent.createTest("12.PLANT-EQUIPMENT-IMPORT-BUTTON-OPACITY");
			testCase.log(Status.FAIL, "No Element");
		}

		// Employee Import Button HEIGHT

		try {
			String ActualHeight = PlantEquipmentPage.ImportButton.getCssValue("height");
			System.out.println("Height :" + ActualHeight);
			String ExpectedHeight = "32px";
			testCase = extent.createTest("13.PLANT-EQUIPMENT-IMPORT-BUTTON-HEIGHT");
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
			testCase = extent.createTest("13.PLANT-EQUIPMENT-IMPORT-BUTTON-HEIGHT");
			testCase.log(Status.FAIL, "No element");
		}

		// Employee Import Button Width

		try {
			String Actualwidth = PlantEquipmentPage.ImportButton.getCssValue("width");
			System.out.println("width :" + Actualwidth);

			String Expectedwidth = "95.5781px";
			testCase = extent.createTest("14.PLANT-EQUIPMENT-IMPORT-BUTTON-WIDTH");
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
			testCase = extent.createTest("14.PLANT-EQUIPMENT-IMPORT-BUTTON-WIDTH");
			testCase.log(Status.FAIL, "No element");
		}

		// Employee Import Button Font-weight

		try {
			String Actualweight = PlantEquipmentPage.ImportButton.getCssValue("font-weight");
			System.out.println("16.Font-weight :" + Actualweight);
			String Expectedweight = "400";
			testCase = extent.createTest("15.PLANT-EQUIPMENT-IMPORT-BUTTON-FONT-WEIGHT");
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
			testCase = extent.createTest("15.PLANT-EQUIPMENT-IMPORT-BUTTON-FONT-WEIGHT");
		}
		Thread.sleep(2000);

	}

}
