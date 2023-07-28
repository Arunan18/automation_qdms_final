//****************************************************************************************
//										CUSTOMER COMMON METHOD FUNCTION
//					@SASIKALA AMBALAVANAR
//					DATE :- 08:03:2023				
//****************************************************************************************

package com.qa.automation.qdms.testcases.customer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

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
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.EnableDisableCheckCommonTest;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.pages.master.DeliveryPage;
import com.qa.automation.qdms.pages.master.ProjectPage;
import com.qa.automation.qdms.pages.master.SourcePage;

public class CustomerMethods extends DriverIntialization {

	static CustomerPage customerfunpg = new CustomerPage();
	static String CustomerPlantname = "";
	static boolean clickAddButton = false;
	static boolean clickdeleteicon = false;
	static int BeforeCount = 0;
	static int BefCount = 0;
	public static boolean customerafterdeletion = false;
	static int test = 0;
//***************************************************************************************
//									LOGIN FUNCTION
//***************************************************************************************

	@Test(priority = 0)
	public static void custombasicway() throws InterruptedException {
		PageFactory.initElements(driver, customerfunpg);
		// Login credintial
		CustomerPage.username.sendKeys("Admin");
		CustomerPage.password.sendKeys("tokyo@admin");
		CustomerPage.login.click();
		// Master click
		Thread.sleep(2000);
		CustomerPage.Master.click();

	}
//***************************************************************************************
//-------------------- Customer Menu Method------------------------------			
//****************************************************************************************************

	@Test(priority = 1)
	public static void customerMenuMethod() throws InterruptedException {
		PageFactory.initElements(driver, customerfunpg);

//**************************CUSTOMER-TOP-MENU-VISIBLE********************************
		CustomerPage customerfunpg = new CustomerPage();
		PageFactory.initElements(driver, customerfunpg);

		boolean ExpectedTextVisible = true;
		System.out.println("CustomerTopMenuVisible");
		boolean ActualTextVisible = CustomerPage.Customertopmenu.isDisplayed();
		testCase = extent.createTest("CUSTOMER-TOP-MENU-VISIBLE");

		if (CustomerPage.Customertopmenu.isDisplayed()) {
			CustomerPage.Customertopmenu.click();

			Assert.assertEquals(ActualTextVisible, ExpectedTextVisible);
			testCase.log(Status.INFO, "Actual Visible :- " + ActualTextVisible);
			testCase.log(Status.INFO, "Expected Visible :- " + ExpectedTextVisible);
			testCase.log(Status.PASS, " Correct");

		} else {
			System.out.println("Not Visible Customer");
			testCase.log(Status.INFO, "ActualVisible :- " + ActualTextVisible);
			testCase.log(Status.INFO, "Expected Visible :- " + ExpectedTextVisible);
			testCase.log(Status.FAIL, "Wrong");
		}
	}

//*****************************************************************************************
//------------------------Customer Site Bar Method-----------------------------------
//****************************************************************************************
	@Test(priority = 2)
	public static void custombarsitebuttonMethod() throws InterruptedException {
		PageFactory.initElements(driver, customerfunpg);

		// CustomerAddFunctionPage.Customersitebutton.click();

		boolean ExpectedTextVisible = true;
		System.out.println("CustomerSiteBarMenuVisible");
		boolean ActualTextVisible = CustomerPage.Customersitebutton.isDisplayed();
		testCase = extent.createTest("CUSTOMER-SITE-BAR-MENU-VISIBLE");

		if (CustomerPage.Customersitebutton.isDisplayed()) {
			CustomerPage.Customersitebutton.click();

			Assert.assertEquals(ActualTextVisible, ExpectedTextVisible);
			testCase.log(Status.INFO, "Actual Visible :- " + ActualTextVisible);
			testCase.log(Status.INFO, "Expected Visible :- " + ExpectedTextVisible);
			testCase.log(Status.PASS, " Correct");

		} else {
			System.out.println("Not Visible Customer");
			testCase.log(Status.INFO, "ActualVisible :- " + ActualTextVisible);
			testCase.log(Status.INFO, "Expected Visible :- " + ExpectedTextVisible);
			testCase.log(Status.FAIL, "Wrong");
		}

	}
//-------------------------------------------------------------------------------------------

//***************************************************************************************
//											ADD-CUSTOMER-SUCESSFULLY 
//***************************************************************************************
	@Test(priority = 3)
	public static void CustomerAddFunction() throws InterruptedException {
		CustomerPage customerfunpg = new CustomerPage();
		PageFactory.initElements(driver, customerfunpg);
		Thread.sleep(2000);
		EnableDisableCheckCommonTest.EnableDisablecheckMethod(CustomerPage.Customerplantfiled, "PlantFieldChecked",
				"PlantFieldVisiblePass", "PlantFieldVisibleFail", "PlantFieldnablePass", "PlantFieldEnableFail");
		CustomerPage.Customerplantfiled.click();
//****************************************************************************************
// XPATH CUSTOMER EDIT 

		Thread.sleep(3000);
		String Name = "RMC Jaffna Plant";
		String NameXpath_firstPart = "/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div[";
		String NameXpath_lastPart = "]";
		String EditXpath_firstPart = "/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div[";
		String EditXpath_lastPart = "]";

//*****************************************************************************************   
//								EDIT BASIC LOOP FUNCTIONS
//*****************************************************************************************

//---------------------------------------------------------------------------------------
//				DON'T MAKE ANY CHANGE THIS CODE 
//=======================================================================================
		boolean clickNextPage = true;
		boolean sbuExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(Name)) {
						Thread.sleep(2000);
						sbuExist = true;
						driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
						Thread.sleep(2000);
						clickNextPage = false;
						break;
					}
				} catch (Exception e) {
				}
			}
			if (clickNextPage == true) {
				clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				if (clickNextPage) {

					driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
					Thread.sleep(2000);
				} else {
					System.out.println("Button is Disabled");
				}
			} else {
				break;
			}
		}
		if (sbuExist = false) {
			System.out.println("No such Element" + sbuExist);
		}
//==============================================================================================================			
//								 Add Customer Details	
//-----------------------------------------------------------------------------------------
//Thread.sleep(3000);

//CustomerAddFunctionPage.Customerplantfiled.click();
		Thread.sleep(1000);
//System.out.println("data count "+CustomerAddFunctionPage.AddCustomerdatasizedata.size());

//CustomerAddFunctionPage.Customerplantfiled.sendKeys("j");
		Thread.sleep(2000);
//CustomerAddFunctionPage.Customerplantfiled.sendKeys("RMC Jaffna Plant", Keys.ARROW_DOWN, Keys.ENTER);
//TestCasePrint("STEP 08 ➡: Add SBU");
		Actions actions = new Actions(driver);
		try {
//CustomerAddFunctionPage.Customerplantfiled.click();
			Thread.sleep(2000);
			actions.sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(500);
			actions.sendKeys(Keys.ENTER).perform();
// TestCasePrint("STEP 08 ➡: Add SBU", "✅", "✅");
		} catch (Exception e) {
// TestCasePrint("STEP 08 ➡: Add SBU", "✅", "❌");
		}
//CustomerAddFunctionPage.Jaffnaplant.click();
		CustomerPage.AddCustomerheader.click();

//*************************************************************************************				

		Thread.sleep(2000);
		EnableDisableCheckCommonTest.EnableDisablecheckMethod(CustomerPage.CustomerFiled, "Customer-Field-Checked",
				"Customer-Field-Visible-Pass", "Customer-Field-Visible-Fail", "Customer-Field-Enable-Pass",
				"Customer-Field-Enable-Fail");
		CustomerPage.CustomerFiled.click();
		CustomerPage.CustomerFiled.sendKeys("SasiKala");
//*****************************************************************************************			

		Thread.sleep(2000);
		EnableDisableCheckCommonTest.EnableDisablecheckMethod(CustomerPage.CustomerEmailFiled,
				"Customer-Email-Field-Checked", "Customer-Email-Field-Visible-Pass",
				"Customer-Email-Field-Visible-Fail", "Customer-Email-Field-Enable-Pass",
				"Customer-Email-Field-Enable-Fail");
		CustomerPage.CustomerEmailFiled.sendKeys("sasikala@gmail.com");
//******************************************************************************************
		Thread.sleep(2000);
		EnableDisableCheckCommonTest.EnableDisablecheckMethod(CustomerPage.CustomerAddressFiled,
				"Customer-Address-Field-Checked", "Customer-Address-Field-Visible-Pass",
				"Customer-Address-Field-Visible-Fail", "Customer-Address-Field-Enable-Pass",
				"Customer-Address-Field-Enable-Fail");
		CustomerPage.CustomerAddressFiled.sendKeys("Mirusuvil,Jaffna,Sri Lanka");
//*****************************************************************************************
		Thread.sleep(2000);
		EnableDisableCheckCommonTest.EnableDisablecheckMethod(CustomerPage.CustomerContactNoFiled,
				"Customer-ContactNo-Field-Checked", "Customer-ContactNo-Field-Visible-Pass",
				"Customer-ContactNo-Field-Visible-Fail", "Customer-ContactNo-Field-Enable-Pass",
				"Customer-ContactNo-Field-Enable-Fail");

		CustomerPage.CustomerContactNoFiled.sendKeys("0774545475");

		Thread.sleep(2000);
		EnableDisableCheckCommonTest.EnableDisablecheckMethod(CustomerPage.Customersavebtn,
				"Customer-Save-Button-Checked", "Customer-Save-Button-Visible-Pass",
				"Customer-Save-Button-Visible-Fail", "Customer-Save-Button-Enable-Pass",
				"Customer-Save-Button-Enable-Fail");
		CustomerPage.Customersavebtn.click();

		Thread.sleep(1000);
		String AddSuccessMessage = CustomerPage.AddCustomersuccessmsg.getText();
		System.out.println(AddSuccessMessage);
		String expectedatamsg = "Customer Added Successfully";

		testCase = extent.createTest("Data Added Success Message");
		try {
			Assert.assertEquals(AddSuccessMessage, expectedatamsg);
			testCase.log(Status.INFO, "Actual Data :- " + AddSuccessMessage);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.PASS, "Success Message Enable");
		} catch (AssertionError e) {

			testCase.log(Status.INFO, "Actual Data :- " + AddSuccessMessage);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.FAIL, "Wrong Success Message Not Enable");
		}
	}

//****************************************************************************************			
//					CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE
//****************************************************************************************
	@Test(priority = 5)
	public static void checkLastAddedvalue() throws InterruptedException, IOException {
		CustomerPage customerfunpg = new CustomerPage();
		PageFactory.initElements(driver, customerfunpg);

		Thread.sleep(2000);
		String actualdata = CustomerPage.AddCustomerfirstdata.getText();
		System.out.println("First row of table : " + actualdata);

		String expecteddata = "SasiKala";

		boolean firstdata = true;
		testCase = extent.createTest("CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE");
		try {
			AssertJUnit.assertEquals(actualdata, expecteddata);

		} catch (AssertionError e) {
			firstdata = false;
		}
		if (firstdata) {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
//		testCase.log(Status.INFO, "").assignCategory("High Severity");
//		testCase.log(Status.INFO, "").assignCategory("High Priority");
			testCase.log(Status.PASS, "Correct last added data");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
//		testCase.log(Status.INFO, "").assignCategory("High Severity");
//		testCase.log(Status.INFO, "").assignCategory("High Priority");
			testCase.log(Status.FAIL, "Wrong last added data");
		}
	}

///-*******-------------------*********************--------------****************************

	@Test(priority = 4)
	public static void Editcustomerselect() throws InterruptedException {
		PageFactory.initElements(driver, customerfunpg);
		// XPATH CUSTOMER EDIT

		Thread.sleep(3000);
		String Name = "Sasi";
		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[7]/span/a[1]/span";

//*****************************************************************************************   
//	 									EDIT BASIC LOOP FUNCTIONS
//*****************************************************************************************

//---------------------------------------------------------------------------------------
//	 									DON'T MAKE ANY CHANGE THIS CODE 
//=======================================================================================
		boolean clickNextPage = true;
		boolean customerExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(Name)) {
						customerExist = true;
						driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
						Thread.sleep(2000);
						clickNextPage = false;
						break;
					}
				} catch (Exception e) {
				}
			}
			if (clickNextPage == true) {
				clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				if (driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled()) {

					driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
					Thread.sleep(2000);
				} else {
					System.out.println("Button is Disabled");
				}
			} else {
				break;
			}
		}
		if (customerExist = false) {
			System.out.println("No such Element" + customerExist);
		}
	}
//=======================================================================================

//*************************************************************************************
//	 								EDIT DATA FIELD SELECT
//*************************************************************************************

	@Test(priority = 5)
	public static void CustomerEditFunction() throws InterruptedException {
		CustomerPage customerfunpg = new CustomerPage();
		PageFactory.initElements(driver, customerfunpg);

		// driver.navigate().refresh();
//---------------------------------------------------------------------------------------
//	 					Call Method form the EnableDisabled Test Page
//---------------------------------------------------------------------------------------

		Thread.sleep(2000);
		if (CustomerPage.CustomerFiled.isDisplayed()) {
			testCase = extent.createTest("1.CUSTOMER FIELD VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (CustomerPage.CustomerFiled.isEnabled()) {
				testCase = extent.createTest("2.USTOMER FIELD IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					CustomerPage.CustomerFiled.click();
					Thread.sleep(2000);

					CustomerPage.CustomerFiled.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
					CustomerPage.CustomerFiled.sendKeys("MAAHAEditCustomer");
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("2.CUSTOMER FIELD IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("1.CUSTOMER FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

//-------------------------------------------------------------------------------------

		Thread.sleep(2000);
		if (CustomerPage.Updatebtn.isDisplayed()) {
			testCase = extent.createTest("1.CUSTOMER UPDATE BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (CustomerPage.Updatebtn.isEnabled()) {
				testCase = extent.createTest("2.CUSTOMER UPDATE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					CustomerPage.Updatebtn.click();
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("2.CUSTOMER UPDATE IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("1.CUSTOMER UPDATE BUTTON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

//---------------------------------------------------------------------------------------

		Thread.sleep(1000);
		String UpdateSuccessMessage = CustomerPage.UpdateCustomersuccessmsg.getText();
		System.out.println(UpdateSuccessMessage);
		String expectedatamsg = "Customer Updated Successfully";

		testCase = extent.createTest("Data Update Success Message");
		try {
			Assert.assertEquals(UpdateSuccessMessage, expectedatamsg);
			testCase.log(Status.INFO, "Actual Data :- " + UpdateSuccessMessage);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.PASS, "Success Message Enable");
		} catch (AssertionError e) {

			testCase.log(Status.INFO, "Actual Data :- " + UpdateSuccessMessage);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.FAIL, "Wrong Success Message Not Enable");
		}
	}

//******************************************************************************************
//	 						CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE
//******************************************************************************************

	@Test(priority = 3)
	public static void checkLastAddvalue() throws InterruptedException, IOException {
		CustomerPage customerEditpg = new CustomerPage();
		PageFactory.initElements(driver, customerEditpg);

//	 	CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE
		Thread.sleep(2000);
		String actualdata = CustomerPage.EditCustomerfirstdata.getText();
		System.out.println("First row of table : " + actualdata);

		String expecteddata = "MAAHAEditCustomer";

		boolean firstdata = true;
		testCase = extent.createTest("CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE");
		try {
			AssertJUnit.assertEquals(actualdata, expecteddata);

		} catch (AssertionError e) {
			firstdata = false;
		}
		if (firstdata) {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			// testCase.log(Status.INFO, "").assignCategory("High Severity");
			// testCase.log(Status.INFO, "").assignCategory("High Priority");
			testCase.log(Status.PASS, "Correct last added data");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			// testCase.log(Status.INFO, "").assignCategory("High Severity");
			// testCase.log(Status.INFO, "").assignCategory("High Priority");
			testCase.log(Status.FAIL, "Wrong last added data");
		}

	}
//-----------------------------------------------------------------------------------
//*****************************ALLOCATE PLANT METHOD*********************************
//------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------
//*******************************************************************************************							
	@Test(priority = 1)
	public static void AddAllocateautoclickplant() throws InterruptedException, IOException {
		PageFactory.initElements(driver, customerfunpg);
		// XPATH CUSTOMER EDIT

		Thread.sleep(3000);

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Source\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Customer");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Source\\Master Module.xlsx",
				"Customer", "TC-CUS-0055");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Source\\Master Module.xlsx",
				"Customer", "TC-CUS-0055");
		for (int j = firstrow; j <= lastrow; j++) {
			XSSFRow row = sheet.getRow(j);

			String Customername = (String) row.getCell(1).getStringCellValue();
			String CustomerPlantname = (String) row.getCell(2).getStringCellValue();
			Thread.sleep(2000);

			String Name = Customername;
			String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
			String NameXpath_lastPart = "]/td[1]";
			String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
			String EditXpath_lastPart = "]/td[6]/span/span";

//****************************************************************************************************  
//	    								EDIT BASIC LOOP FUNCTIONS
//****************************************************************************************************

//---------------------------------------------------------------------------------------
//	    							DON'T MAKE ANY CHANGE THIS CODE 
//=======================================================================================
			boolean clickNextPage = true;
			boolean CustomerExist = false;
			while (clickNextPage) {
				for (int i = 2; i < 103; i++) {
					try {
						String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart))
								.getText();
						System.out.println(text);
						if (text.equals(Name)) {
							CustomerExist = true;
							driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
							Thread.sleep(2000);
							clickNextPage = false;
							break;
						}
					} catch (Exception e) {
					}
				}
				if (clickNextPage == true) {
					clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
							.isEnabled();
					if (driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled()) {
						driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
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
	}

//=====================================================================================
//	    								ALLOCATE PLANT PATH EDIT 
//=====================================================================================
	@Test(priority = 2)
	public static void AddAllocateautoselectplant() throws InterruptedException {
		PageFactory.initElements(driver, customerfunpg);

		// XPATH CUSTOMER EDIT

		Thread.sleep(2000);
		String Name = CustomerPlantname;
		String NameXpath_firstPart = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/label[";
		String NameXpath_lastPart = "]";
		String EditXpath_firstPart = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/label[";
		String EditXpath_lastPart = "]";

//****************************************************************************************************  
//	    								EDIT BASIC LOOP FUNCTIONS
//****************************************************************************************************
		boolean clickNextPage = true;
		boolean CustomerExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					Thread.sleep(3000);
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(Name)) {
						CustomerExist = true;
						driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
						Thread.sleep(2000);
						clickNextPage = false;
						break;
					}
				} catch (Exception e) {
				}
			}
			if (clickNextPage == true) {
				clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				if (driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled()) {
					driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
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
//-----------------------------------------------------------------------------------

	// ALLOCATE PLANT PATH & select plant & click

	// AddAllocatePlantCustomerPage.Allocateplantbtn.click();
	// Thread.sleep(1000);
	// AddAllocatePlantCustomerPage.Allocateplantckboxclick.click();

// Modified By-@SASI ----> Add allocate Plant ok button Function (23-03-2023)		
	@Test(priority = 3)
	public static void AddAllocateokbuttonMethod() throws InterruptedException {
		PageFactory.initElements(driver, customerfunpg);
		Thread.sleep(2000);

		if (CustomerPage.Okbtn.isDisplayed()) {
			testCase = extent.createTest("3. CUSTOMER ALLOCATE OK BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (CustomerPage.Okbtn.isEnabled()) {
				testCase = extent.createTest("4. CUSTOMER ALLOCATE OK BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					CustomerPage.Okbtn.click();

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("4. CUSTOMER ALLOCATE OK BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("3. CUSTOMER ALLOCATE OK BUTTON IS VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	// CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE

	@Test(priority = 4)
	public static void customaddedvaluecheckway() throws InterruptedException {
		PageFactory.initElements(driver, customerfunpg);
		Thread.sleep(2000);
		String actualdata = CustomerPage.EditCustomerfirstdata.getText();
		System.out.println("First row of table : " + actualdata);

		String expecteddata = "K - P Construction";

		boolean firstdata = true;
		testCase = extent.createTest("CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE");
		try {
			AssertJUnit.assertEquals(actualdata, expecteddata);

		} catch (AssertionError e) {
			firstdata = false;
		}
		if (firstdata) {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			// testCase.log(Status.INFO, "").assignCategory("High Severity");
			// testCase.log(Status.INFO, "").assignCategory("High Priority");
			testCase.log(Status.PASS, "Correct last added data");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			// testCase.log(Status.INFO, "").assignCategory("High Severity");
			// testCase.log(Status.INFO, "").assignCategory("High Priority");
			testCase.log(Status.FAIL, "Wrong last added data");
		}

	}

	// ****************************************************************************************
	// Next page
	// ****************************************************************************************
	public static void CustomerNavigatetoMiddle() {
		for (int i = 0; i < 13; i++) {
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
	public static void CustomerNavigatetoLast() throws InterruptedException {

		Thread.sleep(3000);
		CustomerPage.paginationlastpage.click();

		// Scroll up by a page
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_UP).build().perform();
	}

	public static void CustomerCancelButton(String colname, String colname1) throws InterruptedException, IOException {

		// PageFactory.initElements(driver, UnitPage);
		Thread.sleep(2000);
		if (CustomerPage.CustomerCancelBUtton.isDisplayed()) {
			testCase = extent.createTest(colname + " BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (CustomerPage.CustomerCancelBUtton.isEnabled()) {
				testCase = extent.createTest(colname1 + " BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					Thread.sleep(2000);
					CustomerPage.CustomerCancelBUtton.click();
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

	// *******************LOG OUT FUNCTIONALITY***********************

	public static void LogoutMethod() throws InterruptedException {
		Thread.sleep(1000);
		SourcePage Sourcepg = new SourcePage();
		PageFactory.initElements(driver, Sourcepg);
		SourcePage.Adminbtn.click();
		Thread.sleep(1000);
		SourcePage.Logoutbtn.click();

	}

	public static void CustomerAddButton(String colname, String colname1) throws InterruptedException {
		PageFactory.initElements(driver, customerfunpg);

		if (CustomerPage.AddCustomerbtn.isDisplayed()) {
			testCase = extent.createTest(colname + "ADD BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (CustomerPage.AddCustomerbtn.isEnabled()) {
				testCase = extent.createTest(colname1 + "ADD BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					CustomerPage.AddCustomerbtn.click();
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

	public static void plantfield(String colname) {

		PageFactory.initElements(driver, customerfunpg);
		if (CustomerPage.Customerplantfiled.isDisplayed()) {
			testCase = extent.createTest("STEP-15--DROP DOWN IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (CustomerPage.Customerplantfiled.isEnabled()) {
				testCase = extent.createTest("STEP-16--DROP DOWN IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				Actions actions = new Actions(driver);
				CustomerPage.Customerplantfiled.click();
				try {
					boolean pass = true;
					System.out.println("%%%%%%%%%%%%%%%%%%%%" + !pass);
					while (pass) {
						System.out.println("%%VVVVVVVVVVVVVV%%%%%%%%" + !pass);
						if (pass) {
							ArrayList arrayList = new ArrayList();
							try {
								WebDriverWait wait = new WebDriverWait(driver, 2);
								try {
									wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
											"//div[@id='sub_business_unit_list']/../div[2]/div[1]/div/div/div[2]/div/span")));
									String fgs = driver.findElement(By
											.xpath("//div[@id='customer_plant_list']/../div[2]/div[1]/div/div/div/div"))
											.getText();
									arrayList.add(fgs);
									System.out.println(arrayList);
									int inb = arrayList.size();
									if (inb >= 11) {
										if (arrayList.get(9).equals(fgs)) {
											break;
										}
									}

								} catch (Exception e) {
									// TODO: handle exception
								}
								WebElement list = driver.findElement(By.xpath("//span[text()='" + colname + "']"));
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
				testCase = extent.createTest("STEP-16--DROP DOWN IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-15--DROP DOWN IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
	}

	public static void errorMessage() {

		PageFactory.initElements(driver, customerfunpg);

		String errme = CustomerPage.plantvalidation.getText();
		System.out.println(errme);
		if (errme == "") {
			errme = CustomerPage.customervalidation.getText();

			if (errme == "") {
				errme = CustomerPage.emailvalidation.getText();
				if (errme == "") {
					errme = CustomerPage.addressvalidation.getText();
					if (errme == "") {
						errme = CustomerPage.contactnovalidation.getText();
					}
				}
			}
		}

		testCase = extent.createTest("THE VALIDATION MESSAGE IS APPEAR");
		testCase.log(Status.INFO, "THE VALIDATION MESSAGE IS : " + errme);
		testCase.log(Status.FAIL, "TEST FAIL ❎");
	}

	public static void confirmAdd(String data1) throws InterruptedException, IOException {

		String actualdata = CustomerPage.tablefirstrow.getText();
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
					boolean x = xpath.isDisplayed();
					System.out.println("%%%%%%%%%%%%%%"+x);
					xpath.click();
					if (!x) {
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
					}}
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

	public static void customerDeletesearch(String colname, String colname1, String searchdata, String colname2)
			throws InterruptedException, IOException {

		Deleteconfirm();

		String Name = searchdata;
		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String DeleteXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String DeleteXpath_lastPart = "]/td[7]/span/a[2]/a/span";

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

									CustomerPage.deleteOkButton.click();

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

	public static void Deleteconfirm() throws InterruptedException {

		PageFactory.initElements(driver, customerfunpg);

		String DataCountText = CustomerPage.totalpaginationcount.getText();

		String[] BeforeCount = DataCountText.split("of ");

		BefCount = Integer.parseInt(BeforeCount[1]);

		System.out.println("Final Count :" + BefCount);
	}

	public static void customerAfterDeleteconfirm() throws InterruptedException {

		String DataCountText = CustomerPage.totalpaginationcount.getText();

		System.out.println("Delivery pagination count :" + DataCountText);
		String[] AfterCount = DataCountText.split("of ");

		test = Integer.parseInt(AfterCount[1]);
		System.out.println("Final Count :" + AfterCount[1]);
		customerafterdeletion = true;

	}

	public static void customerDeleteEqu(String colname) {

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

	}

}
