//***********************************************************************************
//* Description
//*------------
//* TEST CONFIGURE MAIN TESTS 
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 08/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                      08/05/2023   WATHI     Orginal Version
//
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.pages.master.UserPage;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleSingleSearchMethods;
import com.qa.automation.qdms.testcases.user.UserMainTests;
import com.qa.automation.qdms.testconfig.commonmethods.AcceptCondition;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class TestConfiguteMainTests extends DriverIntialization {

	static TestConfigPage tc = new TestConfigPage();
	static ManageTestsPage mtp = new ManageTestsPage();
	static TestParameterPage tpp = new TestParameterPage();
	static UserPage user = new UserPage();
	static SourcePage src = new SourcePage();
	static PlantEquipmentPage plantequ = new PlantEquipmentPage();
	static TestConfigNavigation tcn = new TestConfigNavigation();
	static SampleSingleSearchMethods sssm = new SampleSingleSearchMethods();

	static String test = null;
	static String test2 = null;
	static String material = null;
	static String value1 = null;
	static String equation = null;
	static String test3 = null;
	static String condition = null;

	public static void clickontestconfigure()

	{

		SampleCommonMethods.methodoneclick("STEP 01-CLICK ON TEST CONFIGURE BUTTON",
				TestConfigPage.testconfigureleftnavigation, "TEST CONFIGURE IS DISPLAY", "TEST CONFIGURE IS ENABLED",
				TestConfigPage.testconfiguretableHeading, "Configure Test", "TEST CONFIGURE BUTTN HAS BEEN TESTED");
		;
	}

	public static void acceptancecondition() throws InterruptedException {

		PageFactory.initElements(driver, tc);
		try {
			if (TestConfigPage.acceptedcondtiontab.isDisplayed()) {

				boolean Acctualtra = TestConfigPage.acceptedcondtiontab.isDisplayed();
				boolean Expectedetra = true;

				UserMainTests.TestCasePrint("ACCEPTANCE CONDITION BUTTON VISIBLE", Expectedetra, Acctualtra);

				try {
					if (TestConfigPage.acceptedcondtiontab.isEnabled()) {

						boolean Acctualena = TestConfigPage.acceptedcondtiontab.isEnabled();
						boolean Expectedena = true;

						UserMainTests.TestCasePrint("ACCEPTANCE CONDITION BUTTON ENABLE", Expectedena, Acctualena);

					} else {
						testCase = extent.createTest("ACCEPTANCE CONDITION BUTTON NOT VISIBLE");
						testCase.log(Status.INFO, "element Not Displayed");
						testCase.log(Status.FAIL, "element Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("BUTTON Locator");
					testCase.log(Status.INFO, "Dont Have element Locator");
					testCase.log(Status.FAIL, " Dont Have element Locator");
				}

			} else {
				testCase = extent.createTest("ACCEPTANCE CONDITION BUTTON NOT ENABLE");
				testCase.log(Status.INFO, "element Not Displayed");
				testCase.log(Status.FAIL, " element Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("BUTTON Locator");
			testCase.log(Status.INFO, "Dont Have elemnt Locator");
			testCase.log(Status.FAIL, " Dont Have element Locator");
		}
	}

	// ******************EDIT MATERIAL MODAL EXCEL DATA******************

	public static void Excel() throws IOException {

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0014";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(1).getBooleanCellValue();

			test = (String) row.getCell(2).getStringCellValue();

		}
	}

	public static void clickeditconfigicon() throws InterruptedException {

		PageFactory.initElements(driver, tcn);

		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "(//span[@aria-label='check'])[1]");

		Thread.sleep(2000);

		try {

			if (driver.findElement(By.xpath("//td[text()='" + test + "']//following-sibling::td[14]")).isDisplayed()) {

				testCase = extent.createTest("edit configure Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver.findElement(By.xpath("//td[text()='" + test + "']//following-sibling::td[14]"))
						.isEnabled()) {
					testCase = extent.createTest("edit configure Icon Enable");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='" + test + "']//following-sibling::td[14]")).click();

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void selecttest() throws InterruptedException, IOException {

		PageFactory.initElements(driver, user);
		PageFactory.initElements(driver, plantequ);
		PageFactory.initElements(driver, src);

		boolean nextBtn = PlantEquipmentPage.next.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_first;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);

			}
			boolean isExist = list.contains(test);
			Thread.sleep(3000);
			nextBtn = PlantEquipmentPage.next.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				PlantEquipmentPage.next.click();
				Thread.sleep(3000);
			} else
				break;

		}

	}

	public static void clickonacceptedconditiontab()

	{

		SampleCommonMethods.methodoneclick("ACCEPTANCE CONDITION TAB BUTTON CHECK", TestConfigPage.acceptedcondtiontab,
				"ACCEPTANCE CONDITION TAB BUTTON IS DISPLAY", "ACCEPTANCE CONDITION TAB BUTTON IS ENABLED",
				TestConfigPage.addconditionheading, "Add Condition", "ACCEPTANCE CONDITION TAB BUTTON HAS BEEN TESTED");

	}

	public static void clickonacceptedcriteriatab()

	{

		SampleCommonMethods.methodoneclick("ACCEPTANCE CRITERIA TAB BUTTON CHECK", TestConfigPage.acceptedcriteriatab,
				"ACCEPTANCE CRITERIA TAB BUTTON IS DISPLAY", "ACCEPTANCE CRITERIA TAB BUTTON IS ENABLED",
				TestConfigPage.acceptedvalueheading, "Accepted Value   -   TESTCONFIGTC",
				"ACCEPTANCE CRITERIA TAB BUTTON HAS BEEN TESTED");

	}

	public static void scrollup() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	// ******************EDIT MATERIAL MODAL EXCEL DATA******************

	public static void Excel2() throws IOException {

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0177";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(1).getBooleanCellValue();

			test2 = (String) row.getCell(2).getStringCellValue();

		}
	}

	public static void clickeditconfigicon2() throws InterruptedException {

		PageFactory.initElements(driver, tcn);

		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "(//span[@aria-label='check'])[1]");

		Thread.sleep(2000);

		try {

			if (driver.findElement(By.xpath("//td[text()='" + test2 + "']//following-sibling::td[14]")).isDisplayed()) {

				testCase = extent.createTest("edit configure Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver.findElement(By.xpath("//td[text()='" + test2 + "']//following-sibling::td[14]"))
						.isEnabled()) {
					testCase = extent.createTest("edit configure Icon Enable");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='" + test2 + "']//following-sibling::td[14]")).click();

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void selecttest2() throws InterruptedException, IOException {

		PageFactory.initElements(driver, user);
		PageFactory.initElements(driver, plantequ);
		PageFactory.initElements(driver, src);

		boolean nextBtn = PlantEquipmentPage.next.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_first;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);

			}
			boolean isExist = list.contains(test2);
			Thread.sleep(3000);
			nextBtn = PlantEquipmentPage.next.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				PlantEquipmentPage.next.click();
				Thread.sleep(3000);
			} else
				break;

		}

	}

	// ******************EDIT MATERIAL MODAL EXCEL DATA******************

	public static void Excel3() throws IOException {

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-Edit-0177";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(1).getBooleanCellValue();

			material = (String) row.getCell(2).getStringCellValue();

		}
	}

	public static void clickeditmaterial() throws InterruptedException {

		PageFactory.initElements(driver, tcn);

		try {

			if (driver.findElement(By.xpath("//td[text()='" + material + "']//following-sibling::td[4]/span/a/span"))
					.isDisplayed()) {

				testCase = extent.createTest("edit configure Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver
						.findElement(By.xpath("//td[text()='" + material + "']//following-sibling::td[4]/span/a/span"))
						.isEnabled()) {
					testCase = extent.createTest("edit configure Icon Enable");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(
								By.xpath("//td[text()='" + material + "']//following-sibling::td[4]/span/a/span"))
								.click();

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void selectmaterial() throws InterruptedException, IOException {

		PageFactory.initElements(driver, user);
		PageFactory.initElements(driver, plantequ);
		PageFactory.initElements(driver, src);

		boolean nextBtn = PlantEquipmentPage.next.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_second;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);

			}
			boolean isExist = list.contains(material);
			Thread.sleep(3000);
			nextBtn = PlantEquipmentPage.next.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				PlantEquipmentPage.next.click();
				Thread.sleep(3000);
			} else
				break;

		}

	}

	public static void Exceledit() throws IOException, InterruptedException {

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-Editvalue-0177";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(1).getBooleanCellValue();

			value1 = (String) row.getCell(2).getStringCellValue();

			if (check) {

				TestConfigPage.minimumplaceholder.click();
				TestConfigPage.minimumplaceholder.sendKeys(Keys.END);
				Thread.sleep(2000);
				int num = 5;
				for (int j = 0; j < num; j++) {
					TestConfigPage.minimumplaceholder.sendKeys(Keys.BACK_SPACE);
				}

				TestConfigPage.minimumplaceholder.sendKeys(String.valueOf(value1));
			}

		}
	}

	public static void modalclose() {
		boolean AcctualAfterClick = TestConfigPage.editacceptedmodal.isDisplayed();
		boolean ExpectedAfterClick = true;

		boolean elementvisibleafterclick = false;
		testCase = extent.createTest("EDIT ACCEPTED VALUE MODAL INVISIBLE");
		try {
			AssertJUnit.assertEquals(AcctualAfterClick, ExpectedAfterClick);
		} catch (AssertionError e) {
			elementvisibleafterclick = true;
		}
		if (elementvisibleafterclick) {
			testCase.log(Status.INFO, "ActualElement :- " + AcctualAfterClick);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedAfterClick);

			testCase.log(Status.FAIL, "Modal visible ");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + AcctualAfterClick);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedAfterClick);

			testCase.log(Status.PASS, "Modal invisible");
		}
	}

	public static void compare() {
		String actual = TestConfigPage.minimumvalue.getAttribute("value");
		System.out.println("text " + actual);
		String expected = value1;

		UserMainTests.TestCasePrint("CORRECTLY UPDATED", expected, actual);

	}

	public static void expectedscreen() {
		try {

			if (TestConfigPage.calculator.isDisplayed()) {

				testCase = extent.createTest("correct screen heading is display");
				testCase.log(Status.PASS, "TEST PASS ☑");

			} else {
				testCase = extent.createTest("correct screen heading is not display");
				testCase.log(Status.FAIL, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("correct screen heading is not display");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void configureequeation() {
		try {

			if (TestConfigPage.configureEquiationselect.isDisplayed()) {

				testCase = extent.createTest("configure equiation is active");
				testCase.log(Status.PASS, "TEST PASS ☑");

			} else {
				testCase = extent.createTest("configure equiation is not active");
				testCase.log(Status.FAIL, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("configure equiation is not active");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void scrolldown() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_UP).build().perform();
	}

	public static void configureequiation() throws InterruptedException {

		PageFactory.initElements(driver, tc);
		try {
			if (TestConfigPage.configureequatab.isDisplayed()) {

				boolean Acctualtra = TestConfigPage.configureequatab.isDisplayed();
				boolean Expectedetra = true;

				UserMainTests.TestCasePrint("ACCEPTANCE CONDITION BUTTON VISIBLE", Expectedetra, Acctualtra);

				try {
					if (TestConfigPage.configureequatab.isEnabled()) {

						boolean Acctualena = TestConfigPage.configureequatab.isEnabled();
						boolean Expectedena = true;

						UserMainTests.TestCasePrint("ACCEPTANCE CONDITION BUTTON ENABLE", Expectedena, Acctualena);

					} else {
						testCase = extent.createTest("ACCEPTANCE CONDITION BUTTON NOT VISIBLE");
						testCase.log(Status.INFO, "element Not Displayed");
						testCase.log(Status.FAIL, "element Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("BUTTON Locator");
					testCase.log(Status.INFO, "Dont Have element Locator");
					testCase.log(Status.FAIL, " Dont Have element Locator");
				}

			} else {
				testCase = extent.createTest("ACCEPTANCE CONDITION BUTTON NOT ENABLE");
				testCase.log(Status.INFO, "element Not Displayed");
				testCase.log(Status.FAIL, " element Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("BUTTON Locator");
			testCase.log(Status.INFO, "Dont Have elemnt Locator");
			testCase.log(Status.FAIL, " Dont Have element Locator");
		}
	}

	public static void Excel4() throws IOException {

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0182";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(1).getBooleanCellValue();

			equation = (String) row.getCell(2).getStringCellValue();

		}
	}

	public static void clickdeleteparameter() throws InterruptedException {

		PageFactory.initElements(driver, tcn);

		try {

			if (driver
					.findElement(By.xpath("//td[text()='" + equation
							+ "']//following-sibling::td[3]/span/span/span[@class='anticon anticon-delete']"))
					.isDisplayed()) {

				testCase = extent.createTest("delete Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver
						.findElement(By.xpath("//td[text()='" + equation
								+ "']//following-sibling::td[3]/span/span/span[@class='anticon anticon-delete']"))
						.isEnabled()) {
					testCase = extent.createTest("delete Icon Enable");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='" + equation
								+ "']//following-sibling::td[3]/span/span/span[@class='anticon anticon-delete']"))
								.click();

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST PASS ❎");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST  ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void scrolluntil()

	{
		Actions actions = new Actions(driver);
		try {
			boolean pass = false;
			Thread.sleep(1000);

			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("//td[text()='" + equation
								+ "']//following-sibling::td[2]/span/span/span[@class='anticon anticon-delete']"))
								.click();
						pass = true;
					} catch (Exception e) {

					}
				}

				if (!pass) {
					actions.sendKeys(Keys.ARROW_DOWN).perform();
					Thread.sleep(2);
				} else {
					break;
				}

			}
		} catch (Exception e) {
		}
	}

	public static void scrolluntilafterdelete()

	{
		Actions actions = new Actions(driver);
		try {
			boolean pass = false;
			Thread.sleep(1000);

			if (!pass) {
				try {
					driver.findElement(By.xpath("//td[text()='" + equation
							+ "']//following-sibling::td[2]/span/span/span[@class='anticon anticon-delete']")).click();
					pass = true;
				} catch (Exception e) {

					testCase = extent.createTest("STEP 10-ELEMENT IS NOT DISPLAY");
					testCase.log(Status.PASS, "TEST pass ❎");
				}
			}

			if (!pass) {
				actions.sendKeys(Keys.ARROW_DOWN).perform();
				Thread.sleep(2);
			} else {

			}

		} catch (Exception e) {
		}
	}

	public static void Excel199() throws IOException {

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0199";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
//System.err.println(firstRow + "  !!  " +lastRow);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(1).getBooleanCellValue();

			test3 = (String) row.getCell(2).getStringCellValue();

		}
	}

	public static void clickacceptedcondition199() throws InterruptedException {

		PageFactory.initElements(driver, tcn);

		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "(//span[@aria-label='check'])[1]");

		Thread.sleep(2000);

		try {

			if (driver.findElement(By.xpath("//td[text()='" + test3 + "']//following-sibling::td[11]")).isDisplayed()) {

				testCase = extent.createTest("STEP 03-ACCEPTED CONDITION ICON DISPLAY");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver.findElement(By.xpath("//td[text()='" + test3 + "']//following-sibling::td[11]"))
						.isEnabled()) {
					testCase = extent.createTest("STEP 03-ACCEPTED CONDITION ICON ENABLE");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='" + test3 + "']//following-sibling::td[11]")).click();

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void selecttest199() throws InterruptedException, IOException {

		PageFactory.initElements(driver, user);
		PageFactory.initElements(driver, plantequ);
		PageFactory.initElements(driver, src);

		boolean nextBtn = PlantEquipmentPage.next.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_first;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);

			}
			boolean isExist = list.contains(test3);
			Thread.sleep(3000);
			nextBtn = PlantEquipmentPage.next.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				PlantEquipmentPage.next.click();
				Thread.sleep(3000);
			} else
				break;

		}

	}

	public static void Excel199delete() throws IOException {

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-delete-0199";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(1).getBooleanCellValue();

			condition = (String) row.getCell(2).getStringCellValue();

		}
	}

	public static void clickdeletecondiot() throws InterruptedException {

		PageFactory.initElements(driver, tcn);

		Thread.sleep(2000);

		try {

			if (driver
					.findElement(By.xpath("//td[text()='" + condition
							+ "']//following-sibling::td/span/a/a/span[@class='anticon anticon-delete']"))
					.isDisplayed()) {

				testCase = extent.createTest("DELETE CONDITION ICON DISPLAY");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver
						.findElement(By.xpath("//td[text()='" + condition
								+ "']//following-sibling::td/span/a/a/span[@class='anticon anticon-delete']"))
						.isEnabled()) {
					testCase = extent.createTest("DELETE CONDITION ICON EANABLE");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='" + condition
								+ "']//following-sibling::td/span/a/a/span[@class='anticon anticon-delete']")).click();

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void deletecancelbutton() throws InterruptedException {

		PageFactory.initElements(driver, tc);
		try {
			if (TestConfigPage.DeleteCanCelButtonTest.isDisplayed()) {

				boolean Acctualtra = TestConfigPage.DeleteCanCelButtonTest.isDisplayed();
				boolean Expectedetra = true;

				UserMainTests.TestCasePrint("STEP 07-CANCEL DELETE CONFIRMATION BUTTON VISIBLE", Expectedetra,
						Acctualtra);

				try {
					if (TestConfigPage.DeleteCanCelButtonTest.isEnabled()) {

						Thread.sleep(2000);

						boolean Acctualena = TestConfigPage.DeleteCanCelButtonTest.isEnabled();
						boolean Expectedena = true;

						UserMainTests.TestCasePrint("STEP 07-CANCEL DELETE CONFIRMATION BUTTON ENABLE", Expectedena,
								Acctualena);

					} else {
						testCase = extent.createTest("CANCEL DELETE CONFIRMATION BUTTON NOT VISIBLE");
						testCase.log(Status.INFO, "element Not Displayed");
						testCase.log(Status.FAIL, "element Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("BUTTON Locator");
					testCase.log(Status.INFO, "Dont Have element Locator");
					testCase.log(Status.FAIL, " Dont Have element Locator");
				}

			} else {
				testCase = extent.createTest("CANCEL DELETE CONFIRMATION BUTTON NOT ENABLE");
				testCase.log(Status.INFO, "element Not Displayed");
				testCase.log(Status.FAIL, " element Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("BUTTON Locator");
			testCase.log(Status.INFO, "Dont Have elemnt Locator");
			testCase.log(Status.FAIL, " Dont Have element Locator");
		}

		TestConfigPage.DeleteCanCelButtonTest.click();
	}

	public static void deleteconfirmationpopupclose() {
		boolean AcctualAfterClick = TestConfigPage.deleteconfirmationpopup.isDisplayed();
		boolean ExpectedAfterClick = true;

		boolean elementvisibleafterclick = false;
		testCase = extent.createTest("STEP 08-DELETE CONFIRMATION MODAL INVISIBLE");
		try {
			AssertJUnit.assertEquals(AcctualAfterClick, ExpectedAfterClick);
		} catch (AssertionError e) {
			elementvisibleafterclick = true;
		}
		if (elementvisibleafterclick) {
			testCase.log(Status.INFO, "ActualElement :- " + AcctualAfterClick);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedAfterClick);

			testCase.log(Status.FAIL, "Modal visible ");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + AcctualAfterClick);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedAfterClick);

			testCase.log(Status.PASS, "Modal invisible");
		}
	}

	public static void deleteOkbutton() throws InterruptedException {

		PageFactory.initElements(driver, tc);
		try {
			if (TestConfigPage.deleteconfirmationOKbutton.isDisplayed()) {

				boolean Acctualtra = TestConfigPage.deleteconfirmationOKbutton.isDisplayed();
				boolean Expectedetra = true;

				UserMainTests.TestCasePrint("STEP 11-OK DELETE CONFIRMATION BUTTON VISIBLE", Expectedetra, Acctualtra);

				try {
					if (TestConfigPage.deleteconfirmationOKbutton.isEnabled()) {

						boolean Acctualena = TestConfigPage.deleteconfirmationOKbutton.isEnabled();
						boolean Expectedena = true;

						UserMainTests.TestCasePrint("STEP 11-OK DELETE CONFIRMATION BUTTON ENABLE", Expectedena,
								Acctualena);

					} else {
						testCase = extent.createTest("OK DELETE CONFIRMATION BUTTON NOT VISIBLE");
						testCase.log(Status.INFO, "element Not Displayed");
						testCase.log(Status.FAIL, "element Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("BUTTON Locator");
					testCase.log(Status.INFO, "Dont Have element Locator");
					testCase.log(Status.FAIL, " Dont Have element Locator");
				}

			} else {
				testCase = extent.createTest("OK DELETE CONFIRMATION BUTTON NOT ENABLE");
				testCase.log(Status.INFO, "element Not Displayed");
				testCase.log(Status.FAIL, " element Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("BUTTON Locator");
			testCase.log(Status.INFO, "Dont Have elemnt Locator");
			testCase.log(Status.FAIL, " Dont Have element Locator");
		}

		TestConfigPage.deleteconfirmationOKbutton.click();
	}

	public static void confirmdeletion()

	{
		Actions actions = new Actions(driver);
		try {
			boolean pass = false;
			Thread.sleep(1000);

			if (!pass) {
				try {
					driver.findElement(By.xpath("//td[text()='" + condition
							+ "']//following-sibling::td/span/a/a/span[@class='anticon anticon-delete']")).click();
					pass = true;
				} catch (Exception e) {

					testCase = extent.createTest("STEP 12-ELEMENT IS NOT DISPLAY");
					testCase.log(Status.PASS, "TEST pass ❎");
				}
			}

			if (!pass) {
				actions.sendKeys(Keys.ARROW_DOWN).perform();
				Thread.sleep(2);
			} else {

			}

		} catch (Exception e) {
		}
	}

	public static void clickonmanagetestconfigure()

	{

		SampleCommonMethods.methodoneclick("STEP 01-CLICK ON MANAGE TEST CONFIGURE BUTTON",
				TestConfigPage.managetestconfiguretopnavigation, "MANAGE TEST CONFIGURE IS DISPLAY",
				"MANAGE TEST CONFIGURE IS ENABLED", TestConfigPage.managetesttableHeading, "Manage Test Configuration",
				"MANAGE TEST CONFIGURE BUTTON HAS BEEN TESTED");
		;
	}

	public static void managetestconfigutefieldsinglesearch() throws IOException, InterruptedException

	{

		SampleSingleSearchMethods.singleSearch(TestConfigPage.testsearchicon, TestConfigPage.testsearchplaceholder,
				TestConfigPage.testsearchbutton, "TEST", "Test Configuragtion Module", "Test_Configure",
				"TC-TCN-search-0378", 1, 2, TestConfigPage.testColumn, TestConfigPage.testBeforesearch,
				TestConfigPage.testAftersearch, true);

	}

	public static void searchtestavaiable()

	{
		
		String act_Value = SampleSingleSearchMethods.searchValue;
        

		String expected_val = TestConfigPage.firsttestdata.getText();
		System.out.println("exp Value: " + expected_val);

		UserMainTests.TestCasePrint("ADDED DATA AVAILABLE", expected_val, act_Value);
	}
	
	public static void conditionconfirm()

	{
		
		String act_Value =AcceptCondition.stringToSplit;  
        

		String expected_val =TestConfigPage.firstaddeddata.getText();
		System.out.println("exp Value: " + expected_val);

		UserMainTests.TestCasePrint("ADDED DATA AVAILABLE", expected_val, act_Value);
	}
	

}
