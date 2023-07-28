//****************************************************************************************
//		DESCRIPTION
//------------------
//EMPLOYEE ALLOCATE USER ADD FUNCTION					
//****************************************************************************************
//* Test Case Number      		Date          Author        Comments
//* =================       ======       	========       ========
//*TC-EMP-0057    		  26/07/2023    	RAHUL.S       modified
//*			
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
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EmployeePage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class EmployeeAllocateUserAddFunction extends DriverIntialization {
	static EmployeePage EmployeePg = new EmployeePage();
	static String tobeEdited = null;
	static String userType = null;
	static String role = null;
	static String status = null;
	public static boolean intermediate = false;
	static boolean clickeditButton = false;
	static boolean searchValue1 = false;
	static boolean click = false;
	public static boolean select = false;
	public static boolean sent = false;
	public static boolean pop = false;
	public static boolean checking = false;
	static String status1 = null;
	public static boolean button = false;

	@Test
	public static void editemployee() throws InterruptedException, IOException {
		testCase = extent.createTest("TC-EMP-0057--EMPLOYEE ALLOCATE USER ADD FUNCTION");
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
			addAllocateUser("Master Module", "Employee", "TC-EMP-0057");

		}
		if (LoginTest.login) {
			Logout.LogoutFunction();

		}

	}

	public static void selectRole() {
		try {

			EmployeePage.roleselect.click();
			testCase = extent.createTest("CHECKING ROLE FIELD");
			testCase.log(Status.INFO, "ROLE FILED IS FOUND AND CLICKED");
			testCase.log(Status.PASS, "TEST PASS");

			ActionCommonMethod.dropDown("//div[@id='role_list']/div", role, "role_list");

			try {
				EmployeePage.addUserTitle.click();
				checking = true;
			} catch (Exception e) {

			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING ROLE FIELD");
			testCase.log(Status.INFO, "ROLE FILED IS NOT FOUND");
			testCase.log(Status.FAIL, "ROLE FIELD TEXT BOX IS FOUND");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("CHECKING ROLE FIELD");
			testCase.log(Status.INFO, "ROLE FILED IS NOT CLICKED");
			testCase.log(Status.FAIL, "ROLE FIELD TEXT BOX IS CLICKED");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING ROLE FIELD");
			testCase.log(Status.INFO, "ROLE FILED IS NOT FOUND AND CLICKED");
			testCase.log(Status.FAIL, "ROLE FIELD TEXT BOX IS CLICKED");
		}

	}

	public static void addAllocateUser(String excelbook, String exceltab, String testid)
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

			for (int j = firstrow; j <= firstrow; j++) {
				row = sheet.getRow(j);
				tobeEdited = dataValue.formatCellValue(row.getCell(1));
				userType = dataValue.formatCellValue(row.getCell(2));
				role = dataValue.formatCellValue(row.getCell(3));
				status1 = dataValue.formatCellValue(row.getCell(4));
				boolean exdata = true;
				/*********************************************************************************************/
				Thread.sleep(2000);
				if (exdata) {
					exdata = false;
					try {

						checkTheAccountsStatus();
					} catch (Exception e) {

					}

					if (button) {
						search();

					}

				}

				if (select) {

					select = false;
					Thread.sleep(2000);

					dropdown(EmployeePage.userTypeDrop, userType,
							"//div[@id='userType_list']/..//div[contains(@class,'ant-select-item-option-active')]/div[text()='",
							"']", "Role");

				}
				if (select) {

					select = false;
					Thread.sleep(2000);

					selectRole();

				}

				if (checking) {
					checking = false;
					click(EmployeePage.addUserButton, "ADD BUTTON");

				}
				if (click) {
					click = false;
					popupcheck(driver.findElement(By.xpath("//div[@class='ant-modal-content']")),
							"ALLOCATE USER ADD FUNCTION");

				}

				if (pop) {
					confirmAddUser();

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

	public static boolean search() throws InterruptedException, IOException {

		boolean nextButtonEnabled = true;

		while (nextButtonEnabled) {
			// Wait for up to 5 seconds for the element to be present before throwing an
			// exception

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			try {
				WebDriverWait wait = new WebDriverWait(driver, 2);
				wait.until(ExpectedConditions.visibilityOf(driver
						.findElement(By.xpath("//td[text()='" + tobeEdited + "']//following-sibling::td[3]//button"))));
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(
						By.xpath("//td[text()='" + tobeEdited + "']//following-sibling::td[2]//span//p"))));
				// Find the delete button using XPath based on the provided material and prefix
				// values
				WebElement editButton = driver
						.findElement(By.xpath("//td[text()='" + tobeEdited + "']//following-sibling::td[3]//button"));

				// Set the searchValue1 flag to true and exit the loop
				editButton.click();
				intermediate = true;

				searchValue1 = true;

				select = true;
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

	public static void checkTheAccountsStatus() throws InterruptedException, IOException {

		PageFactory.initElements(driver, EmployeePg);
		try {
			status = driver
					.findElement(By.xpath("//td[text()='" + tobeEdited + "']//following-sibling::td[2]//span//p"))
					.getText();
			if (status.equals("New")) {

				testCase = extent.createTest("THE ADD BUTTON IS NOT DISPALYED");
				testCase.log(Status.INFO, "THE ADD BUTTON IS NOT DISPLAYED BECAUSE THE STATUS IS NEW");
				testCase.log(Status.FAIL, "THE FAIL");

			} else if (status.equals("Active")) {
				testCase = extent.createTest("THE ADD BUTTON IS NOT DISPALYED");
				testCase.log(Status.INFO, "THE ADD BUTTON IS NOT DISPLAYED BECAUSE THE STATUS IS ACTIVE");
				testCase.log(Status.FAIL, "THE FAIL");

			} else if (status.equals("Verified")) {
				testCase = extent.createTest("THE ADD BUTTON IS DISPALYED");
				testCase.log(Status.INFO, "THE ADD BUTTON IS DISPLAYED BECAUSE THE STATUS IS VERIFIED");
				testCase.log(Status.PASS, "THE PASS");
				button = true;
			}
		} catch (Exception e) {

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

	public static void dropdown(WebElement webElement, String data, String before, String after, String element) {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(webElement));
		try {

			boolean value1 = webElement.isDisplayed();
			SampleCommonMethods.TestCasePrint(element.toUpperCase() + " VISIBILITY", "TRUE",
					String.valueOf(value1).toUpperCase());
			boolean value2 = webElement.isEnabled();
			SampleCommonMethods.TestCasePrint(element.toUpperCase() + "ENABLITY", "TRUE",
					String.valueOf(value2).toUpperCase());

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

	public static void confirmAddUser() {
		testCase = extent.createTest("CONFIRM THE STATUS");
		try {
			String actual = EmployeePage.firstRowStatus.getText();
			String expected = status1;
			boolean firstdata = true;

			try {
				AssertJUnit.assertEquals(actual, expected);

			} catch (AssertionError e) {
				firstdata = false;
			}
			if (firstdata) {
				testCase.log(Status.INFO, "Actual Data :- " + actual);
				testCase.log(Status.INFO, "Expected Data :- " + expected);
				testCase.log(Status.PASS, "Correct last data added in first row");
			} else {
				testCase.log(Status.INFO, "Actual Data :- " + actual);
				testCase.log(Status.INFO, "Expected Data :- " + expected);
				testCase.log(Status.FAIL, "Wrong Last Data Not Added in first row");
			}
		} catch (NoSuchElementException e) {
			testCase.log(Status.INFO, "STATUS IS NOT FOUND");
			testCase.log(Status.FAIL, "THE FAIL");
		} catch (Exception e) {
			testCase.log(Status.INFO, "STATUS IS NOT FOUND OR OTHER EXCEPTION");
			testCase.log(Status.FAIL, "THE FAIL");
		}

		try {
			boolean actualutton = EmployeePage.firstRowAddButton.isEnabled();
			boolean expectedButton = false;
			boolean firstdata1 = true;
			testCase = extent.createTest("CONFIRM THE BUTTON DISABLITY");
			try {
				AssertJUnit.assertEquals(actualutton, expectedButton);

			} catch (AssertionError e) {
				firstdata1 = false;
			}
			if (firstdata1) {
				testCase.log(Status.INFO, "Actual Data :- " + actualutton);
				testCase.log(Status.INFO, "Expected Data :- " + expectedButton);
				testCase.log(Status.PASS, "Correct last data added in first row");
			} else {
				testCase.log(Status.INFO, "Actual Data :- " + actualutton);
				testCase.log(Status.INFO, "Expected Data :- " + expectedButton);
				testCase.log(Status.FAIL, "Wrong Last Data Not Added in first row");
			}
		} catch (NoSuchElementException e) {
			testCase.log(Status.INFO, "ADD BUTTON IS NOT FOUND");
			testCase.log(Status.FAIL, "THE FAIL");
		} catch (Exception e) {
			testCase.log(Status.INFO, "ADD BUTTON IS NOT FOUND OR OTHER EXCEPTION");
			testCase.log(Status.FAIL, "THE FAIL");
		}

	}

}
