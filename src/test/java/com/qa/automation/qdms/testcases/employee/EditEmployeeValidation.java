//***********************************************************************************
//* Description
//*------------
//* Edit Employee Validation 
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 27/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-EMP-0094           27/03/2023   Gobithan     Original Version
//*                       25/07/2023   RAHUL.S      Modified
//************************************************************************************

package com.qa.automation.qdms.testcases.employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EmployeePage;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class EditEmployeeValidation extends DriverIntialization {

	static EmployeePage EmployeePg = new EmployeePage();
	static boolean clickeditButton = false;
	static boolean searchValue1 = false;
	static String tobeEdited = null;
	public static boolean sent = false;
	static String BEfirstName = null;
	static String BElasttname = null;
	static String BEplantt = null;
	static String BEdesigination = null;
	static String BEemployeeAddress = null;
	static String BEemployeeContactNo = null;
	public static boolean select = false;
	public static boolean click = false;
	static String status = null;
	public static boolean pop = false;
	public static boolean firstRow = false;
	public static boolean intermediate = false;
	static String firstName = null;
	static String lasttname = null;
	static String plantt = null;
	static String desigination = null;
	static String employeeAddress = null;
	static String employeeContactNo = null;
	static String employeeEmail = null;

	@Test
	public static void editValidationemployee() throws InterruptedException, IOException {
		testCase = extent.createTest("TC-EMP-0094--Edit Employee Validation");
		LoginTest.Login();
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}
		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.clickMaster = false;
			MasterMainNavigationsTest.navigateEmployeeMain();

		}
		if (MasterMainNavigationsTest.clickEmployeeMain) {
			MasterMainNavigationsTest.clickEmployeeMain = false;
			MasterMainNavigationsTest.navigateEmployee();
		}
		if (MasterMainNavigationsTest.clickEmployee) {
			MasterMainNavigationsTest.clickEmployee = false;
			editEmployee("Master Module", "Employee", "TC-EMP-0094");

		}
		if (LoginTest.login) {
			Logout.LogoutFunction();

		}

	}

	public static void editEmployee(String excelbook, String exceltab, String testid)
			throws InterruptedException, IOException {
		PageFactory.initElements(driver, EmployeePg);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// get data from excel

		XSSFRow row = null;

		DataFormatter dataValue = new DataFormatter();
		String filelocation;

		try {
			filelocation = "./src/test/resources/Excel/" + excelbook + ".xlsx";
			System.out.println(testid + "ttttttttttttttttttttt");
			int firstrow = CommonMethods.getFirstRowNum(filelocation, exceltab, testid);
			int lastrow = CommonMethods.getLastRowNum(filelocation, exceltab, testid);
			System.out.println(firstrow + "ffffffff");
			System.out.println(lastrow + "llllllllllllll");

			FileInputStream file = new FileInputStream(filelocation);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(exceltab);

			for (int j = firstrow; j <= lastrow; j++) {
				row = sheet.getRow(j);
				tobeEdited = dataValue.formatCellValue(row.getCell(1));
				BEfirstName = dataValue.formatCellValue(row.getCell(2));
				BElasttname = dataValue.formatCellValue(row.getCell(3));
				BEplantt = dataValue.formatCellValue(row.getCell(4));
				BEdesigination = dataValue.formatCellValue(row.getCell(5));
				BEemployeeAddress = dataValue.formatCellValue(row.getCell(6));
				BEemployeeContactNo = dataValue.formatCellValue(row.getCell(7));
				firstName = dataValue.formatCellValue(row.getCell(8));
				lasttname = dataValue.formatCellValue(row.getCell(9));
				plantt = dataValue.formatCellValue(row.getCell(10));
				desigination = dataValue.formatCellValue(row.getCell(11));
				employeeAddress = dataValue.formatCellValue(row.getCell(12));
				employeeContactNo = dataValue.formatCellValue(row.getCell(13));
				employeeEmail = dataValue.formatCellValue(row.getCell(14));
				boolean exdata = true;

				/*********************************************************************************************/
				Thread.sleep(2000);
				if (exdata) {
					exdata = false;

					// dataSearch();
					// search1("","",tobeEdited);
					search();
					checkTheAccountsStatus();

					if (intermediate) {
						confirmBeforeEdit();

					}
				}
				if (click) {
					click = false;

					sendkey(EmployeePage.firstNameField, firstName, "first name");

				}
				if (sent) {
					sent = false;
					sendkey(EmployeePage.lastNameField, lasttname, "last name");
				}
				if (sent) {
					sent = false;
					dropdown(EmployeePage.plantDropdown, plantt,
							"//div[@id='plant_list']//..//div[contains(@class,'ant-select-item')]/div[text()='", "']",
							"plant");

				}
				if (select) {

					select = false;
					dropdown1(EmployeePage.designationDropdown, desigination,
							"//div[@id='desigination_list']//..//div[contains(@class,'ant-select-item')]/div[text()='",
							"']", "desigination");

				}
				if (select) {
					select = false;
					sendkey(EmployeePage.employeeAddressField, employeeAddress, "employee");
				}
				if (sent) {
					sent = false;
					sendkey(EmployeePage.employeeContactNoField, employeeContactNo, "contact no");

				}
				if (sent) {
					sent = false;
					checkTheAccountsStatus();
					sendkey(EmployeePage.employeeEmailField, employeeEmail, "employee email");
				}
				if (sent) {
					sent = false;
					click(EmployeePage.saveBtn, "employee update");
				}
				if (click) {
					click = false;
					popupcheck(driver.findElement(By.xpath("//div[@class='ant-modal-content']")), "EDIT EMPLOYEE");

				}

				if (pop) {

					datacheckinfirstrow("1,2,4,5", 2,
							firstName + "," + lasttname + "," + desigination + "," + employeeEmail,
							"EIDT VALIDATION MATERIAL PLANT WISE");
					// cofirmFirstRow();
				} else if (!pop) {

					materialMethodes.validationconfirm("", "", "EDIT VALIDATION EMPLOYEE");
				}
//          REFRESH
				driver.navigate().refresh();
				Thread.sleep(1000);

			}
		} catch (Exception e) {
			testCase = extent.createTest("EXCEL DATA NOT THERE");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
//	          REFRESH
			driver.navigate().refresh();
			Thread.sleep(1000);

		}
	}

	public static boolean search() throws InterruptedException {

		boolean nextButtonEnabled = true;

		while (nextButtonEnabled) {
			// Wait for up to 5 seconds for the element to be present before throwing an
			// exception
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			try {
				WebDriverWait wait = new WebDriverWait(driver, 2);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[text()='" + tobeEdited
						+ "']//following-sibling::td[5]//span[contains(@class,'anticon-edit')]"))));
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(
						By.xpath("//td[text()='" + tobeEdited + "']//following-sibling::td[2]//span//p"))));
				// Find the delete button using XPath based on the provided material and prefix
				// values
				WebElement editButton = driver.findElement(By.xpath("//td[text()='" + tobeEdited
						+ "']//following-sibling::td[5]//span[contains(@class,'anticon-edit')]"));
				status = driver
						.findElement(By.xpath("//td[text()='" + tobeEdited + "']//following-sibling::td[2]//span//p"))
						.getText();

				// Set the searchValue1 flag to true and exit the loop
				editButton.click();
				intermediate = true;
				clickeditButton = true;
				searchValue1 = true;
				click = true;
				break;
			} catch (Exception e) {
				// If the element is not found, set searchValue1 flag to false
				searchValue1 = false;

			}

			try {
				// Check if the next button is enabled by using

				nextButtonEnabled = driver.findElement(By.xpath("//li[@title='Next Page']//button")).isEnabled();
			} catch (Exception e) {

			}

			if (nextButtonEnabled) {
				try {
					// Click the next button if it is enabled
					driver.findElement(By.xpath("//li[@title='Next Page']//button")).click();
				} catch (Exception e) {
					testCase = extent.createTest("CHECKING THE SEARCH DATA ");
					testCase.log(Status.INFO, "UNABLE TO LOCATE THE ELEMENT");
					testCase.log(Status.FAIL, "TEST FAIL ❎");

				}
			}
		}

		// Return the searchValue1 flag's final value after the loop completes
		return searchValue1;
	}

	public static void sendkey(WebElement webElement, String data, String element) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
			boolean v = webElement.isDisplayed();
			SampleCommonMethods.TestCasePrint(element.toUpperCase() + " VISIBILITY", "TRUE",
					String.valueOf(v).toUpperCase());
			Boolean V2 = webElement.isEnabled();
			SampleCommonMethods.TestCasePrint(element.toUpperCase() + "ENABLITY", "TRUE",
					String.valueOf(V2).toUpperCase());
			webElement.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			Thread.sleep(2000);
			webElement.sendKeys(data);
			sent = true;

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE " + element);
			testCase.log(Status.INFO, "UNABLE TO LOCATE THE ELEMENT " + element);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("CHECKING THE " + element);
			testCase.log(Status.INFO, "UNABLE TO CLICK ON THE ELEMENT " + element);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE " + element);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void checkTheAccountsStatus() throws InterruptedException, IOException {
		PageFactory.initElements(driver, EmployeePg);
		if (status.equals("New")) {

			boolean actual = EmployeePage.employeeEmailField.isEnabled();
			boolean expected = true;
			boolean position = true;
			ExtentTest testCase = extent.createTest("CONFIRM THE EMAIL FIELD ENABLED");
			try {
				AssertJUnit.assertEquals(actual, expected);
			} catch (AssertionError e) {
				position = false;
			}
			if (position) {
				testCase.log(Status.INFO, "Actualvalue :- " + actual);
				testCase.log(Status.INFO, "Expectedvalue :- " + expected);
				testCase.log(Status.PASS, "THE EMPLOYEE EMAIL FIELD IS ENABLED");
			} else {
				testCase.log(Status.INFO, "Actualvalue :- " + actual);
				testCase.log(Status.INFO, "ExpectedValue :- " + expected);
				testCase.log(Status.FAIL, "THE EMPLOYEE EMAIL FIELD IS NOT ENABLED");
			}
		} else if (status.equals("Active") || status.equals("Verified")) {

			boolean actual = EmployeePage.employeeEmailField.isEnabled();
			boolean expected = false;
			boolean position = true;
			ExtentTest testCase = extent.createTest("CONFIRM THE EMAIL FIELD ENABLED");
			try {
				AssertJUnit.assertEquals(actual, expected);
			} catch (AssertionError e) {
				position = false;
			}
			if (position) {
				testCase.log(Status.INFO, "Actualvalue :- " + actual);
				testCase.log(Status.INFO, "Expectedvalue :- " + expected);
				testCase.log(Status.PASS, "THE EMPLOYEE EMAIL FIELD IS NOT ENABLED");
			} else {
				testCase.log(Status.INFO, "Actualvalue :- " + actual);
				testCase.log(Status.INFO, "ExpectedValue :- " + expected);
				testCase.log(Status.FAIL, "THE EMPLOYEE EMAIL FIELD IS ENABLED");
			}
		}
	}

	public static void dropdown(WebElement webElement, String data, String before, String after, String element) {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		try {

			boolean value1 = webElement.isDisplayed();
			SampleCommonMethods.TestCasePrint(element.toUpperCase() + " VISIBILITY", "TRUE",
					String.valueOf(value1).toUpperCase());
			boolean value2 = webElement.isEnabled();
			SampleCommonMethods.TestCasePrint(element.toUpperCase() + "ENABLITY", "TRUE",
					String.valueOf(value2).toUpperCase());

			EmployeePage.closeButtonForPlant.click();
			webElement.click();
			Actions actions = new Actions(driver);
			try {
				boolean pass = false;

				WebElement id = null;
				for (int i1 = 0; i1 < 50; i1++) {
					if (!pass) {
						try {

							id = driver.findElement(By.xpath(before + data + after));

							wait.until(ExpectedConditions.elementToBeClickable(id));
							// Thread.sleep(500);
							id.click();
							pass = true;
							select = true;
						} catch (Exception e) {

						}
					}

					if (!pass) {

						actions.sendKeys(Keys.ARROW_DOWN).build().perform();

					} else {
						break;
					}

				}
			} catch (Exception e) {
				testCase = extent.createTest(data.toUpperCase() + "IS NOT THERE IN DROPDOWN LIST");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE " + element.toUpperCase());
			testCase.log(Status.INFO, "UNABLE TO LOCATE THE ELEMENT " + element.toUpperCase());
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("CHECKING THE " + element.toUpperCase());
			testCase.log(Status.INFO, "UNABLE TO CLICK ON THE ELEMENT " + element.toUpperCase());
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE " + element.toUpperCase());
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void dropdown1(WebElement webElement, String data, String before, String after, String element) {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		try {

			boolean value1 = webElement.isDisplayed();
			SampleCommonMethods.TestCasePrint(element.toUpperCase() + " VISIBILITY", "TRUE",
					String.valueOf(value1).toUpperCase());
			boolean value2 = webElement.isEnabled();
			SampleCommonMethods.TestCasePrint(element.toUpperCase() + "ENABLITY", "TRUE",
					String.valueOf(value2).toUpperCase());

			// webElement.click();
			webElement.clear();
			Thread.sleep(2000);
			webElement.sendKeys(data);
			Actions actions = new Actions(driver);
			try {
				boolean pass = false;

				WebElement id = null;
				for (int i1 = 0; i1 < 50; i1++) {
					if (!pass) {
						try {

							id = driver.findElement(By.xpath(before + data + after));

							wait.until(ExpectedConditions.elementToBeClickable(id));
							// Thread.sleep(500);
							id.click();
							pass = true;
							select = true;
						} catch (Exception e) {

						}
					}

					if (!pass) {

						actions.sendKeys(Keys.ARROW_DOWN).build().perform();

					} else {
						break;
					}

				}
			} catch (Exception e) {
				testCase = extent.createTest(data.toUpperCase() + "IS NOT THERE IN DROPDOWN LIST");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE " + element.toUpperCase());
			testCase.log(Status.INFO, "UNABLE TO LOCATE THE ELEMENT " + element.toUpperCase());
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("CHECKING THE " + element.toUpperCase());
			testCase.log(Status.INFO, "UNABLE TO CLICK ON THE ELEMENT " + element.toUpperCase());
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE " + element.toUpperCase());
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void click(WebElement webElement, String element) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
			boolean v = webElement.isDisplayed();
			SampleCommonMethods.TestCasePrint(element.toUpperCase() + " VISIBILITY", "TRUE",
					String.valueOf(v).toUpperCase());
			Boolean V2 = webElement.isEnabled();
			SampleCommonMethods.TestCasePrint(element.toUpperCase() + "ENABLITY", "TRUE",
					String.valueOf(V2).toUpperCase());

			webElement.click();
			click = true;

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE " + element);
			testCase.log(Status.INFO, "UNABLE TO LOCATE THE ELEMENT " + element);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("CHECKING THE " + element);
			testCase.log(Status.INFO, "UNABLE TO CLICK ON THE ELEMENT " + element);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE " + element);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void popupcheck(WebElement webElement, String element) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.invisibilityOfAllElements(webElement));

			pop = webElement.isDisplayed();
			pop = true;
		} catch (Exception e) {
			pop = false;
		}
		if (pop) {
			pop = true;

		} else {
			pop = false;
		}

	}

	public static void datacheckinfirstrow(String checktd, int tr, String data, String TEST) {
//	    REFRESH
		driver.navigate().refresh();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Boolean pass = false;
		String[] numberStrings = checktd.split(",");
		String[] dataStrings = data.split(",");

		int[] numbers = new int[numberStrings.length];
		System.out.println(numberStrings.length);
		for (int i = 0; i < numberStrings.length; i++) {
//		    numbers[i] = Integer.parseInt(numberStrings[i].trim());
			String coldata = numberStrings[i];
			String excoldata = dataStrings[i];
			System.out.println(coldata + "jjjjjjjjjjjjj");
			WebElement table = driver.findElement(By.xpath("//tbody/tr[" + tr + "]/td[" + coldata + "]"));
			String actvalue = table.getText();

			if (excoldata.equals(actvalue)) {
				pass = true;

			}
			if (!pass) {
				testCase = extent.createTest("CHECKING THE ADDED DATA");
				testCase.log(Status.INFO, tr + "ROW" + numbers + "COLUMN");
				testCase.log(Status.INFO, "ACCTUAL DATA:-" + actvalue);
				testCase.log(Status.INFO, "EXPECTED DATA:-" + excoldata);
				testCase.log(Status.FAIL, "TEST FAIL ❎");
				break;

			}

		}
		if (pass) {
			testCase = extent.createTest("CHECKING THE ADDED DATA");
			testCase.log(Status.INFO, "DATASET CORRECTL ADDED");
			testCase.log(Status.PASS, "TEST PASS");

			testCase = extent.createTest(TEST);
			testCase.log(Status.PASS, "TEST PASS");

		} else {
			testCase = extent.createTest(TEST);
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		}

	}

	public static void beforeEdit(WebElement xpath, String cofirmBeforeEdit, String toTheReport)
			throws IOException, InterruptedException {
		// CONFIRM THE DELIVERY FILED BEFORE EDIT
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(xpath));
			if (xpath.isDisplayed()) {

				String actualDelivery = xpath.getAttribute("value");
				String expectedDelivery = cofirmBeforeEdit;
				boolean position = true;
				ExtentTest testCase = extent.createTest(toTheReport);
				try {
					AssertJUnit.assertEquals(actualDelivery, expectedDelivery);
				} catch (AssertionError e) {
					position = false;
				}
				if (position) {
					testCase.log(Status.INFO, "Actualvalue :- " + actualDelivery);
					testCase.log(Status.INFO, "Expectedvalue :- " + expectedDelivery);
					testCase.log(Status.INFO, "Correct value");
					testCase.log(Status.PASS, actualDelivery);
				} else {
					testCase.log(Status.INFO, "Actualvalue :- " + actualDelivery);
					testCase.log(Status.INFO, "ExpectedValue :- " + expectedDelivery);
					testCase.log(Status.INFO, "wrong value");
					testCase.log(Status.FAIL, actualDelivery);
				}

			} else {
				testCase = extent.createTest("CHECKING THE ELEMENT");
				testCase.log(Status.INFO, "THE ELEMENT IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT FOUND");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT FOUND OR CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void beforeEdit1(WebElement xpath, String cofirmBeforeEdit, String toTheReport)
			throws IOException, InterruptedException {
		// CONFIRM THE DELIVERY FILED BEFORE EDIT
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(xpath));
			if (xpath.isDisplayed()) {

				String actualDelivery = xpath.getText();
				String expectedDelivery = cofirmBeforeEdit;
				boolean position = true;
				ExtentTest testCase = extent.createTest(toTheReport);
				try {
					AssertJUnit.assertEquals(actualDelivery, expectedDelivery);
				} catch (AssertionError e) {
					position = false;
				}
				if (position) {
					testCase.log(Status.INFO, "Actualvalue :- " + actualDelivery);
					testCase.log(Status.INFO, "Expectedvalue :- " + expectedDelivery);
					testCase.log(Status.INFO, "Correct value");
					testCase.log(Status.PASS, actualDelivery);
				} else {
					testCase.log(Status.INFO, "Actualvalue :- " + actualDelivery);
					testCase.log(Status.INFO, "ExpectedValue :- " + expectedDelivery);
					testCase.log(Status.INFO, "wrong value");
					testCase.log(Status.FAIL, actualDelivery);
				}

			} else {
				testCase = extent.createTest("CHECKING THE ELEMENT");
				testCase.log(Status.INFO, "THE ELEMENT IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT FOUND");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT FOUND OR CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void confirmBeforeEdit() throws IOException, InterruptedException {
		beforeEdit(EmployeePage.firstNameField, BEfirstName, "CONFIRM BEFORE EDIT FOR FIRST NAME FIELD");
		beforeEdit(EmployeePage.lastNameField, BElasttname, "CONFIRM BEFORE EDIT FOR LAST NAME FIELD");
		beforeEdit1(EmployeePage.intermidateForPlant, BEplantt, "CONFIRM BEFORE EDIT FOR PLANT  FELD");
		beforeEdit1(EmployeePage.intermidateForDesignation, BEdesigination,
				"CONFIRM BEFORE EDIT FOR DESIGNATION FIELD");
		beforeEdit(EmployeePage.employeeAddressField, BEemployeeAddress, "CONFIRM BEFORE EDIT FOR ADDRESS FIELD");
		beforeEdit(EmployeePage.employeeContactNoField, BEemployeeContactNo, "CONFIRM BEFORE EDIT FOR CONTACT FIELD");
		beforeEdit(EmployeePage.employeeEmailField, tobeEdited, "CONFIRM BEFORE EDIT FOR EMAIL FIELD");

	}

	public static void cofirmFirstRow() {

		try {
			driver.findElement(By.xpath("//tr[2][td[1][text()='" + firstName + "']and td[2][text()='" + lasttname
					+ "'] and td[3][text()='" + plantt + "'] and td[4][text()='" + desigination + "']and td[5][text()='"
					+ employeeEmail + "']and td[6][text()='" + employeeContactNo + "']]")).isDisplayed();
			firstRow = true;
		} catch (Exception e) {

		}
		if (firstRow) {
			testCase = extent.createTest("CHECKING THE EDITED VALUE IN THE FIRST ROW");
			testCase.log(Status.PASS, "TEST PASS ❎");
		} else {
			testCase = extent.createTest("CHECKING THE EDITED VALUE IN THE FIRST ROW");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}
}
