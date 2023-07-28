
//****************************************************************************************
//		DESCRIPTION
//------------------
//					ADD ALLOCATE PLANT CUSTOMER TEST
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   06:03:2023	
//****************************************************************************************
//* Test Case Number      		Date          Intis        Comments
//* =================       ======       	========       ========
//* TC-CUS-0055	       		06.03.2023    	@SASIKALA      Original Version
//* TC-CUS-0054				06.03.2023		@SASIKALA	   Original Version(Ok Button Function)
//*							12.07.2023      @Sasikala	   Modified
//************************************************************************************

package com.qa.automation.qdms.testcases.customer;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;
import com.qa.automation.qdms.testcases.source.SourceTest;

public class AddAllocatePlantCustomerTest extends DriverIntialization {
	static CustomerPage customerfunpg = new CustomerPage();
	static boolean work = false;
	static String CustomerPlantname = "";
	static String Customernametable = "";
	static String Customername = "";

	@Test
	public static void allocatePlantFunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, customerfunpg);
		WebDriverWait wait = new WebDriverWait(driver, 5);

// Login Functional
		LoginTest.Login();

// Click Master Card
		wait.until(ExpectedConditions.elementToBeClickable(CustomerPage.Master));
		if (LoginTest.login) {
			SourceTest.CommonMethod(CustomerPage.Master, "Master Card");
		}

// Click Customer Top Menu
		if (SourceTest.work) {
			work = false;
			SourceTest.CommonMethod(CustomerPage.Customertopmenu, "Customer Top Menu Card");
		}

// Customer Site Button
		if (SourceTest.work) {
			work = false;
			SourceTest.CommonMethod(CustomerPage.Customersitebutton, "Customer Site Bar Button");
		}

// ALLOCATE PLANT DATA FIELD SELECT
		if (SourceTest.work) {
			work = false;
			AddAllocateautoclickplant();
		}

// Allocate Plant
		if (plantclick) {
			AddAllocateautoselectplant();
		}

// Customer Allocate "OK" Button Functionality
		wait.until(ExpectedConditions.elementToBeClickable(CustomerPage.Okbtn));
		if (selectplant) {
			SourceTest.CommonMethod(CustomerPage.Okbtn, "CUSTOMER ALLOCATE OK BUTTON");
		}

		if (SourceTest.work) {
			work = false;
			customaddedvaluecheckway();
		}

		driver.navigate().refresh();

// Logout Functional
		if (LoginTest.login) {
			Logout.LogoutFunction();
		}
	}

//-------------------------ALLOCATE PLANT DATA FIELD SELECT-----------------------------------
	static boolean plantclick = false;

	public static void AddAllocateautoclickplant() throws InterruptedException, IOException {
		PageFactory.initElements(driver, customerfunpg);
		plantclick = false;

		Thread.sleep(3000);
		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Customer");

			int firstrow = CommonMethods.getFirstRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Customer",
					"TC-CUS-0055");
			int lastrow = CommonMethods.getLastRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Customer",
					"TC-CUS-0055");
			for (int j = firstrow; j <= lastrow; j++) {
				XSSFRow row = sheet.getRow(j);

				Customername = (String) row.getCell(1).getStringCellValue();
				CustomerPlantname = (String) row.getCell(2).getStringCellValue();
				Customernametable = (String) row.getCell(1).getStringCellValue();
				Thread.sleep(2000);

				String Name = Customername;

// ************************ EDIT BASIC LOOP FUNCTIONS ****************************

				boolean clickNextPage = true;
				boolean CustomerExist = false;
				while (clickNextPage) {
					for (int i = 2; i < 103; i++) {
						Thread.sleep(1000);
						try {
							String text = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).getText();

							System.out.println(text);
							if (text.equals(Name)) {
								CustomerExist = true;
								try {
									driver.findElement(By
											.xpath("//td[1][text()='" + Name + "']/following-sibling::td[5]/span/span"))
											.click();
									plantclick = true;
								} catch (Exception e) {

								}
								Thread.sleep(2000);
								clickNextPage = false;
								break;
							}
						} catch (Exception e) {
						}
					}
					if (clickNextPage == true) {

						clickNextPage = CustomerPage.NextPageBtn.isEnabled();

						if (CustomerPage.NextPageBtn.isEnabled()) {
							CustomerPage.NextPageBtn.click();
							Thread.sleep(2000);
						} else {
							System.out.println("Button Not Enabled");
						}
					} else {
						break;
					}

				}
				if (CustomerExist = false) {
					System.out.println("No such Element" + CustomerExist);
				}
			}
		} catch (Exception e) {
			testCase = extent.createTest("Excel Not Working ");
			testCase.log(Status.INFO, "check Excel data");
			testCase.log(Status.FAIL, "wrong");

		}
	}

//***************************ALLOCATE PLANT PATH EDIT*********************************
	static boolean selectplant = false;

	public static void AddAllocateautoselectplant() throws InterruptedException {
		PageFactory.initElements(driver, customerfunpg);
		selectplant = false;

		Thread.sleep(2000);
		String Name = CustomerPlantname;
		testCase = extent.createTest("SELECT ALLOCATE PLANT");
		try {
			driver.findElement(By.xpath("//div[@class='ant-modal-body']//span[text()='" + Name + "']/../span[1]"))
					.click();
			testCase.log(Status.INFO, "Element Plant Allocation Click");
			testCase.log(Status.PASS, "Correct");
			selectplant = true;

		} catch (Exception e) {
			testCase.log(Status.INFO, "Element Plant Allocation Not Click");
			testCase.log(Status.FAIL, "Wrong");

		}

	}

//-----------------------CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE--------------------------------

	public static void customaddedvaluecheckway() throws InterruptedException {
		PageFactory.initElements(driver, customerfunpg);

		String actualdata = CustomerPage.EditCustomerfirstdata.getText();
		Thread.sleep(1000);
		String expecteddata = Customernametable;

		boolean firstdata = true;
		testCase = extent.createTest("CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE");
		try {
			AssertJUnit.assertEquals(actualdata, expecteddata);

		} catch (AssertionError e) {
			firstdata = false;
		}
		Thread.sleep(1000);
		if (firstdata) {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.PASS, "Correct last added data");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.FAIL, "Wrong last added data");
		}

	}
}
