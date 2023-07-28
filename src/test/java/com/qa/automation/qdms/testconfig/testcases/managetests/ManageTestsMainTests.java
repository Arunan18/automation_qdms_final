package com.qa.automation.qdms.testconfig.testcases.managetests;

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
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.pages.master.UserPage;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleSingleSearchMethods;
import com.qa.automation.qdms.testcases.user.UserMainTests;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;
import com.qa.automation.qdms.testconfig.testcases.testparameter.TestParameterMainTests;

public class ManageTestsMainTests extends DriverIntialization {

	static TestConfigPage tc = new TestConfigPage();
	static ManageTestsPage mtp = new ManageTestsPage();
	static TestParameterPage tpp = new TestParameterPage();
	static UserPage user = new UserPage();
	static SourcePage src =new SourcePage();
	static PlantEquipmentPage plantequ=new PlantEquipmentPage();

	static String Ectcolumn = null;
	static String Actcolumn = null;
	static String select_test = null;
	static String message=null;
	static String validation1=null;
	static String duedate=null;

	public static void clickonManageTestConfigure()

	{

		SampleCommonMethods.methodoneclick("STEP 01-CLICK ON MANAGE TEST CONFIGURE BUTTON",
				ManageTestsPage.managetestconfigure, "MANAGE TEST CONFIGURE IS DISPLAY",
				"MANAGE TEST CONFIGURE IS ENABLED", ManageTestsPage.managetestconfigureheading,
				"Manage Test Configuration", "MANAGE TEST CONFIGURE BUTTON HAS BEEN TESTED");
		
	}

	public static void firstcolumnBefore() {

		Actcolumn = TestParameterPage.tablecontent.getText();
		System.out.println(Actcolumn);
	}

	public static void firstcolumnAfter() {

		Ectcolumn = TestParameterPage.tablecontent.getText();
		System.out.println(Ectcolumn);

		CommonMethods.TestCasePrint("STEP 05-TABLE IS RESET CORRECTLY", Ectcolumn, Actcolumn);
	}

	public static void subcategorysinglesearch() throws IOException, InterruptedException

	{

		SampleSingleSearchMethods.singleSearch(ManageTestsPage.subcategorysearchicon,
				ManageTestsPage.subcategorysearchtextbox, ManageTestsPage.subcategorysearchbutton, "SUB CATEGORY",
				"Test Configuragtion Module", "Manage_Tests", "MTC-MT-016", 1, 2, ManageTestsPage.subcategoryColumn,
				ManageTestsPage.subcategoryBeforesearch, ManageTestsPage.subcategoryAftersearch, true);

	}

	public static void subcategoryButtondisapper() {

		try {

			boolean ActualrestButton = ManageTestsPage.subcategoryResetbutton.isDisplayed();
			boolean ExpectedButton = false;
			CommonMethods.TestCasePrint("RESET BUTTON IS NOT VISIBLE", ExpectedButton, ActualrestButton);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void rowmaterialsinglesearch() throws IOException, InterruptedException

	{

		SampleSingleSearchMethods.singleSearch(ManageTestsPage.rowmaterialsearchicon,
				ManageTestsPage.rowmaterialsearchtextbox, ManageTestsPage.rowmaterialsearchbutton, "ROW MATERIAL",
				"Test Configuragtion Module", "Manage_Tests", "MTC-MT-018", 1, 2, ManageTestsPage.rowmaterialColumn,
				ManageTestsPage.rowmaterialBeforesearch, ManageTestsPage.rowmaterialAftersearch, true);

	}

	public static void rowmaterialButtondisapper() {

		try {

			boolean ActualrestButton = ManageTestsPage.rowmaterialResetbutton.isDisplayed();
			boolean ExpectedButton = false;
			CommonMethods.TestCasePrint("RESET BUTTON IS NOT VISIBLE", ExpectedButton, ActualrestButton);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// ******************EDIT MATERIAL MODAL EXCEL DATA******************

	public static void Excel() throws IOException {

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Manage_Tests";
		String testCaseId = "MTC-MT-002";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			//boolean check = (boolean) row.getCell(1).getBooleanCellValue();

			select_test = (String) row.getCell(1).getStringCellValue();

		}
	}

//	Employee Delete Element

	public static void clickediticon() throws InterruptedException {

		try {

			if (driver.findElement(By.xpath(
					"//td[text()='" + select_test + "']//following-sibling::td[16]/span/a/span[@aria-label='edit']"))
					.isDisplayed()) {

				testCase = extent.createTest("edit Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver.findElement(By.xpath(
						"//td[text()='" + select_test + "']//following-sibling::td[16]/span/a/span[@aria-label='edit']"))
						.isEnabled()) {
					testCase = extent.createTest("edit Icon Enable");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath(
								"//td[text()='" + select_test + "']//following-sibling::td[16]/span/a/span[@aria-label='edit']"))
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
					boolean isExist = list.contains(select_test);
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

public static void validation() throws IOException, InterruptedException {

	PageFactory.initElements(driver, mtp);

	boolean pass = false;
	Thread.sleep(1000);

	String excelPath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
	String excelSheetName = "Manage_Tests";
	String testCaseId = "MTC-MT-validation";

	int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
	int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

	FileInputStream file = new FileInputStream(excelPath);
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet("Manage_Tests");

	for (int i = firstRow; i <= lastRow; i++) {
		XSSFRow row = sheet.getRow(i);


		boolean check = (boolean) row.getCell(1).getBooleanCellValue();

		duedate = (String) row.getCell(2).getStringCellValue();
		
		validation1 = (String) row.getCell(3).getStringCellValue();
		
		message = (String) row.getCell(4).getStringCellValue();
		
		if (check) {
			
			ManageTestsMainTests.clickediticon();
			
			ManageTestsPage.duedatetextbox.sendKeys(duedate);

			

			Thread.sleep(3000);

			boolean text = ManageTestsPage.duedatevalidationmessage.isDisplayed();

			try {
				if (text == true) {

					String actval1 = ManageTestsPage.duedatevalidationmessage.getText();
					System.out.println("prefix " + actval1);
					System.out.println("text display " + text);
					String expval1 = validation1;
					UserMainTests.TestCasePrint(message, expval1, actval1);

					Thread.sleep(3000);

					
				} else {
					testCase = extent.createTest("Not displayed");
					testCase.log(Status.INFO, "Not Displayed");
					testCase.log(Status.FAIL, "Not Displayed");
				}
			} catch (NoSuchElementException e) {

			}
		}
		Thread.sleep(1000);
		if (ManageTestsPage.edittestconfigcancelbutton.isDisplayed()) {
			Thread.sleep(1000);
			ManageTestsPage.edittestconfigcancelbutton.click();
		}
		
	}
}
}
