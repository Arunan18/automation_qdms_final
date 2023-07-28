//***********************************************************************************
//* Description
//*------------
//* CONFIG GROUP MAIN TESTS
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 08/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        08/05/2023   WATHI     Orginal Version
//
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.configgrouptest;

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
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.pages.master.UserPage;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class ConfigGroupTestMainTests extends DriverIntialization {

	static TestConfigPage tc = new TestConfigPage();
	static ManageTestsPage mtp = new ManageTestsPage();
	static TestParameterPage tpp = new TestParameterPage();
	static configGroupTestsPage cgt = new configGroupTestsPage();
	static UserPage user = new UserPage();
	static SourcePage src = new SourcePage();
	static PlantEquipmentPage plantequ = new PlantEquipmentPage();
	static TestConfigNavigation tcn = new TestConfigNavigation();

	static String material_main_category = null;
	static String groupname = null;
	static String names = null;
	static String name = null;
	static String reporeformat = null;
	static String Validation1 = null;
	static String Validation2 = null;
	static String Validation3 = null;
	static String message = null;

	// ******************EDIT MATERIAL MODAL EXCEL DATA******************

	public static void passvaluematerialmaincategorty() throws IOException {

		boolean pass = true;

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Config_Group_Test";
		String testCaseId = "TC-CGT-0002";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		System.out.println(firstRow + " !! " + lastRow);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Config_Group_Test");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(1).getBooleanCellValue();

			material_main_category = (String) row.getCell(2).getStringCellValue();

			if (check) {

				for (int j = 1; j <= 10; j++) {
					WebElement name1 = driver
							.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[" + j + "]"));
					String dropcontent1 = name1.getText();

					if (dropcontent1.contentEquals(material_main_category)) {
						name1.click();
						pass = true;
					} else if (dropcontent1.isEmpty()) {
						pass = true;
					}
				}

			}
		}

	}

	public static void clickonconfigGroupTets()

	{
		PageFactory.initElements(driver, cgt);

		SampleCommonMethods.methodoneclick("STEP 01-CLICK ON CONFIG GROUP TESTS BUTTON",
				configGroupTestsPage.configgrouptestsleftnav, "CONFIG GROUP TEST IS DISPLAY",
				"CONFIG GROUP TEST IS ENABLED", configGroupTestsPage.configgrouptesttableHeading, "Config Group Test",
				"CONFIG GROUP TEST BUTTN HAS BEEN TESTED");

	}

	public static void addconfig() throws InterruptedException, IOException {

		AddConfigGroupTest.addConfigGroupTest("Test Configuragtion Module", "Config_Group_Test", "TC-CGT-0016");
	}

	public static void addconfigmaterialmain_reporttype() throws InterruptedException, IOException {

		AddConfigGroupTest.addConfigGroupTest("Test Configuragtion Module", "Config_Group_Test", "TC-CGT-0017");
	}

	public static void addconfigmaterialmain_specialtype() throws InterruptedException, IOException {

		AddConfigGroupTest.addConfigGroupTest("Test Configuragtion Module", "Config_Group_Test", "TC-CGT-0018");
	}

	public static void addconfigmaterialmain_specialtype_delete() throws InterruptedException, IOException {

		AddConfigGroupTest.addConfigGroupTest("Test Configuragtion Module", "Config_Group_Test", "TC-CGT-0002");
	}

	public static void Excel2() throws IOException {

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Config_Group_Test";
		String testCaseId = "TC-CGT-delete-0002";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		System.err.println(firstRow + "  !!  " + lastRow);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Config_Group_Test");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(1).getBooleanCellValue();

			groupname = (String) row.getCell(2).getStringCellValue();

		}
	}

	public static void selectgroupname() throws InterruptedException, IOException {

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
			boolean isExist = list.contains(groupname);
			Thread.sleep(3000);
			nextBtn = PlantEquipmentPage.nextbuttonsub.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				PlantEquipmentPage.nextbuttonsub.click();
				Thread.sleep(3000);
			} else
				break;

		}

	}

	public static void clickdeletegroupname() throws InterruptedException {

		PageFactory.initElements(driver, tcn);

		try {

			if (driver.findElement(By.xpath("//td[text()='" + groupname + "']//following-sibling::td[3]"))
					.isDisplayed()) {

				testCase = extent.createTest("delete Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver.findElement(By.xpath("//td[text()='" + groupname + "']//following-sibling::td[3]"))
						.isEnabled()) {
					testCase = extent.createTest("delete Icon Enable");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='" + groupname + "']//following-sibling::td[3]"))
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

	public static void selectgroupnameafterdelete() throws InterruptedException, IOException {

		PageFactory.initElements(driver, user);
		PageFactory.initElements(driver, plantequ);
		PageFactory.initElements(driver, src);

		boolean confirm = false;
		boolean nextBtn = true;
		while (nextBtn) {
			List<WebElement> size = driver.findElements(By.xpath(
					"((//tbody[@class='ant-table-tbody'])[1]/tr[contains(@class,'ant-table-row')]/child::td[1])"));

			for (int i = 1; i <= size.size(); i++) {
				WebElement group = driver.findElement(By.xpath(
						"((//tbody[@class='ant-table-tbody'])[1]/tr[contains(@class,'ant-table-row')]/child::td[1])["
								+ i + "]"));
				String groupName1 = group.getText();
				if (groupName1.contentEquals(groupname)) {
					confirm = true;
					break;
				}
				if (confirm) {
					break;
				}
			}
			if (confirm) {
				break;
			}
			nextBtn = PlantEquipmentPage.nextbuttonsub.isEnabled();
			if (nextBtn) {
				PlantEquipmentPage.nextbuttonsub.click();
				Thread.sleep(3000);
			}

		}
		
		if (confirm) {
			testCase = extent.createTest("DATA IS AVAILABLE");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} else {
			testCase = extent.createTest("DATA IS NOT AVAILABLE");
			testCase.log(Status.PASS, "TEST PASS");
		}
	}

	public static void untilselectreporttype(String name, String ExcelTabName, String TestcaseId)
			throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + name + ".xlsx";
		boolean Value1 = false;
		int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
		int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(ExcelTabName);
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow rowk = sheet.getRow(i);

			String MaterialMainCategory = rowk.getCell(1).getStringCellValue();
			String SubCategory = rowk.getCell(2).getStringCellValue();
			String Material = rowk.getCell(3).getStringCellValue();
			String reporttype = rowk.getCell(4).getStringCellValue();
			String SpecialCategory = rowk.getCell(5).getStringCellValue();

			// *********MaterialMainCategory**************

			try {
				Thread.sleep(3000);
				WebElement id = driver.findElement(By.id("material_category"));
				boolean value1 = id.isDisplayed();
				SampleCommonMethods.TestCasePrint("Material Main Category DROP DOWN IS DISPLAYED", "true",
						String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("Material Main Category DROP DOWN IS ENABLED", "true",
						String.valueOf(value2));
				id.click();

				Actions actions = new Actions(driver);
				try {
					boolean pass = false;
					Thread.sleep(1000);

					for (int i1 = 0; i1 < 1000; i1++) {
						if (!pass) {
							try {
								WebElement list = driver.findElement(
										By.xpath("//div[contains(@title,'" + MaterialMainCategory + "')]//div[1]"));
								System.out.println(list);
								list.click();
								Thread.sleep(2000);

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
			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("Material Main Category DROP DOWN IS NOT THERE ", "true",
						String.valueOf(Value1), String.valueOf(e));

			}
			// *****************SubCategory******
			Thread.sleep(3000);
			if (SubCategory != "") {

				try {
					Thread.sleep(3000);
					WebElement id = driver.findElement(By.id("sub_category"));
					boolean value1 = id.isDisplayed();
					SampleCommonMethods.TestCasePrint("Sub Category DROP DOWN IS DISPLAYED", "true",
							String.valueOf(value1));
					boolean value2 = id.isEnabled();
					SampleCommonMethods.TestCasePrint("Sub Category DROP DOWN IS ENABLED", "true",
							String.valueOf(value2));
					id.click();

					Actions actions = new Actions(driver);
					try {
						boolean pass = false;
						Thread.sleep(1000);

						for (int i1 = 0; i1 < 1000; i1++) {
							if (!pass) {
								try {
									WebElement list = driver.findElement(
											By.xpath("//div[contains(@title,'" + SubCategory + "')]//div[1]"));
									System.out.println(list);
									list.click();
									Thread.sleep(2000);

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
				} catch (Exception e) {
					SampleCommonMethods.TestCasePrint("Sub Category DROP DOWN IS NOT THERE ", "true",
							String.valueOf(Value1), String.valueOf(e));

				}
			}
			// **********************material*****************************
			Thread.sleep(3000);
			if (Material != "") {

				try {
					Thread.sleep(3000);
					WebElement id = driver.findElement(By.id("material"));
					boolean value1 = id.isDisplayed();
					SampleCommonMethods.TestCasePrint("Select Material DROP DOWN IS DISPLAYED", "true",
							String.valueOf(value1));
					boolean value2 = id.isEnabled();
					SampleCommonMethods.TestCasePrint("Select Material DROP DOWN IS ENABLED", "true",
							String.valueOf(value2));
					id.click();

					Actions actions = new Actions(driver);
					try {
						boolean pass = false;
						Thread.sleep(1000);

						for (int i1 = 0; i1 < 1000; i1++) {
							if (!pass) {
								try {
									WebElement list = driver.findElement(
											By.xpath("//div[contains(@title,'" + Material + "')]//div[1]"));
									System.out.println(list);
									list.click();
									Thread.sleep(2000);

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
				} catch (Exception e) {
					SampleCommonMethods.TestCasePrint("Select Material DROP DOWN IS NOT THERE ", "true",
							String.valueOf(Value1), String.valueOf(e));

				}
			}
			// ***************report type**************
			Thread.sleep(3000);

			try {
				Thread.sleep(3000);
				WebElement id = driver.findElement(By.xpath("(//span[@class='ant-checkbox-inner'])[1]"));
				boolean value1 = id.isDisplayed();
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS ENABLED", "true", String.valueOf(value2));
				WebElement id1 = driver.findElement(By.xpath("//input[@value='REPORT']"));
				Thread.sleep(2000);

				boolean value3 = id1.isSelected();
				String v3 = String.valueOf(value3);
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS SELECTED", "false", String.valueOf(value3));
				if (reporttype.equals(v3)) {

				}

				else {
					id1.click();
				}

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}

			// *************Special Category*********************************

			try {
				Thread.sleep(3000);
				WebElement id = driver.findElement(By.xpath("(//span[@class='ant-checkbox-inner'])[2]"));
				boolean value1 = id.isDisplayed();
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS ENABLED", "true", String.valueOf(value2));
				WebElement id2 = driver.findElement(By.xpath("//input[@value='STATUS']"));
				Thread.sleep(2000);
				boolean value3 = id2.isSelected();
				String v3 = String.valueOf(value3);
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS SELECTED", "false", String.valueOf(value3));
				if (SpecialCategory.equals(v3)) {

				}

				else {
					id2.click();
				}

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
		}
	}

	
	public static void validationtest() throws IOException, InterruptedException

	{
		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		boolean Value1 = false;
		String excelSheetName = "Config_Group_Test";
		String testCaseId = "TC-CGT-validation-0013";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Config_Group_Test");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(1).getBooleanCellValue();
			names = (String) row.getCell(2).getStringCellValue();
			reporeformat = (String) row.getCell(3).getStringCellValue();
			Validation1 = (String) row.getCell(4).getStringCellValue();
			Validation2 = (String) row.getCell(5).getStringCellValue();
			Validation3 = (String) row.getCell(6).getStringCellValue();
			message = (String) row.getCell(7).getStringCellValue();

			if (check) {
				configGroupTestsPage.nametextbox.click();
				configGroupTestsPage.nametextbox.sendKeys(names);
				Thread.sleep(2000);
				configGroupTestsPage.reportformattextbox.click();
				configGroupTestsPage.reportformattextbox.sendKeys(reporeformat);
				Thread.sleep(2000);
				configGroupTestsPage.Savebutton.click();
				Thread.sleep(2000);

				String ActualValidation1 = configGroupTestsPage.validation1.getText();
				System.out.println("validation1 " + ActualValidation1);
				String ExpectedValidation1 = Validation1;
				testCase = extent.createTest(message);
				try {
					AssertJUnit.assertEquals(ActualValidation1, ExpectedValidation1);
					testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation1);
					testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation1);
					testCase.log(Status.PASS, "Pass " + message + "Script");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation1);
					testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation1);
					testCase.log(Status.FAIL, "Fail " + message + "Script").assignCategory("Low Priority");
					testCase.log(Status.FAIL, "Fail " + message + "Script").assignCategory("High Priority");
				}

				try {
					if (configGroupTestsPage.validation2.isDisplayed()) {

						String ActualValidation2 = configGroupTestsPage.validation2.getText();
						String ExpectedValidation2 = Validation2;
						testCase = extent.createTest(message);
						try {
							AssertJUnit.assertEquals(ActualValidation2, ExpectedValidation2);
							testCase.log(Status.INFO,
									"Actual Validation :- " + configGroupTestsPage.validation2.getText());
							testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation2);
							testCase.log(Status.PASS, "Pass " + message + "Script");
						} catch (AssertionError e) {
							testCase.log(Status.INFO,
									"Actual Validation :- " + configGroupTestsPage.validation2.getText());
							testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation2);
							testCase.log(Status.FAIL, "Fail " + message + "Script").assignCategory("Low Priority");
							testCase.log(Status.FAIL, "Fail " + message + "Script").assignCategory("High Priority");
						}
					} else {
						testCase = extent.createTest("RIGHT SIDE TRANSFER ARROW ENABLE");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {

				}

				try {
					if (configGroupTestsPage.validation3.isDisplayed()) {

						String ActualValidation3 = configGroupTestsPage.validation3.getText();
						String ExpectedValidation3 = Validation3;
						testCase = extent.createTest(message);
						try {
							AssertJUnit.assertEquals(ActualValidation3, ExpectedValidation3);
							testCase.log(Status.INFO,
									"Actual Validation :- " + configGroupTestsPage.validation2.getText());
							testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation3);
							testCase.log(Status.PASS, "Pass " + message + "Script");
						} catch (AssertionError e) {
							testCase.log(Status.INFO,
									"Actual Validation :- " + configGroupTestsPage.validation2.getText());
							testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation3);
							testCase.log(Status.FAIL, "Fail " + message + "Script").assignCategory("Low Priority");
							testCase.log(Status.FAIL, "Fail " + message + "Script").assignCategory("High Priority");
						}
					} else {
						testCase = extent.createTest("ELEMENT NOT VISIBLE");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {
				}
			}
			if (configGroupTestsPage.clearbutton.isDisplayed()) {
				Thread.sleep(1000);
				configGroupTestsPage.clearbutton.click();
			}

		}
	}

	public static void validationtestspecialcategory() throws IOException, InterruptedException

	{
		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		boolean Value1 = false;
		String excelSheetName = "Config_Group_Test";
		String testCaseId = "TC-CGT-validation-0014";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		System.out.println(firstRow + " !! " + lastRow);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Config_Group_Test");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(1).getBooleanCellValue();
			name = (String) row.getCell(2).getStringCellValue();
			Validation1 = (String) row.getCell(3).getStringCellValue();
			Validation3 = (String) row.getCell(4).getStringCellValue();
			message = (String) row.getCell(5).getStringCellValue();

			if (check) {
				configGroupTestsPage.nametextbox.click();
				System.err.println(name);
				configGroupTestsPage.nametextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
				configGroupTestsPage.nametextbox.sendKeys(name);
				Thread.sleep(2000);
				configGroupTestsPage.Savebutton.click();
				Thread.sleep(2000);

				String ActualValidation1 = configGroupTestsPage.validation1.getText();
				System.out.println("validation1 " + ActualValidation1);
				String ExpectedValidation1 = Validation1;
				testCase = extent.createTest(message);
				try {
					AssertJUnit.assertEquals(ActualValidation1, ExpectedValidation1);
					testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation1);
					testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation1);
					testCase.log(Status.PASS, "Pass " + message + "Script");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation1);
					testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation1);
					testCase.log(Status.FAIL, "Fail " + message + "Script").assignCategory("Low Priority");
					testCase.log(Status.FAIL, "Fail " + message + "Script").assignCategory("High Priority");
				}

				try {
					if (configGroupTestsPage.validation3.isDisplayed()) {

						String ActualValidation3 = configGroupTestsPage.validation3.getText();
						String ExpectedValidation3 = Validation3;
						testCase = extent.createTest(message);
						try {
							AssertJUnit.assertEquals(ActualValidation3, ExpectedValidation3);
							testCase.log(Status.INFO,
									"Actual Validation :- " + configGroupTestsPage.validation2.getText());
							testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation3);
							testCase.log(Status.PASS, "Pass " + message + "Script");
						} catch (AssertionError e) {
							testCase.log(Status.INFO,
									"Actual Validation :- " + configGroupTestsPage.validation2.getText());
							testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation3);
							testCase.log(Status.FAIL, "Fail " + message + "Script").assignCategory("Low Priority");
							testCase.log(Status.FAIL, "Fail " + message + "Script").assignCategory("High Priority");
						}
					} else {
						testCase = extent.createTest("ELEMENT NOT VISIBLE");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {
				}
			}
			if (configGroupTestsPage.clearbutton.isDisplayed()) {
				Thread.sleep(1000);
				configGroupTestsPage.clearbutton.click();
			}

		}
	}
}
