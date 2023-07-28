
//****************************************************************************************
//		DESCRIPTION
//------------------
//					ADD ALLOCATE MULTIPLE PLANT CUSTOMER TEST
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   13:03:2023	
//****************************************************************************************
//* Test Case Number     	  Date          Intis        Comments
//* ================       	  ======       ========      ========
//*  TC-CUS-0099             13.03.2023   @SASIKALA     Original Version
//*	 
//****************************************************************************************

package com.qa.automation.qdms.testcases.customer;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class AllocateMulitiplePlantCustomer extends DriverIntialization {
	static CustomerPage Customerfunpg = new CustomerPage();

	static String CustomerName = "";
	static String PlantName = "";
	static String OtherPlantName = "";
	static String VerifyCustomerName = "";

//*****************************************************************************************
//											LOGIN FUNCTION
//*****************************************************************************************
	@Test(priority = 0)
	public static void AddAllocatecustomerbasicway() throws InterruptedException {
		PageFactory.initElements(driver, Customerfunpg);
		// -------------------- Login credential Method---------------------------
		CustomerMethods.custombasicway();

		// -------------------- Customer Menu Method------------------------------
		Thread.sleep(1000);
		CustomerMethods.customerMenuMethod();

		// -------------Customer Site Bar Method-----------------------------------
		CustomerMethods.custombarsitebuttonMethod();

	}
	// -------------------------------------------------------------------------------------------

//*******************************************************************************************							
	@Test(priority = 1)
	public static void AddAllocateautoclickplant() throws InterruptedException, IOException {
		PageFactory.initElements(driver, Customerfunpg);
		// XPATH CUSTOMER EDIT

		Thread.sleep(3000);

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Customer");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Customer",
				"TC-CUS-0099");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Customer",
				"TC-CUS-0099");
		for (int j = firstrow; j <= lastrow; j++) {
			XSSFRow row = sheet.getRow(j);

			CustomerName = (String) row.getCell(1).getStringCellValue();
			PlantName = (String) row.getCell(2).getStringCellValue();
			OtherPlantName = (String) row.getCell(3).getStringCellValue();
			VerifyCustomerName = (String) row.getCell(4).getStringCellValue();
		}
		String Name = CustomerName;
		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[6]/span/span";

//****************************************************************************************************  
//									EDIT BASIC LOOP FUNCTIONS
//****************************************************************************************************

//---------------------------------------------------------------------------------------
//								DON'T MAKE ANY CHANGE THIS CODE 
//=======================================================================================
		boolean clickNextPage = true;
		boolean CustomerExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
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

//==================================================================================
//									ALLOCATE PLANT PATH EDIT 
	@Test(priority = 2)
	public static void AddAllocateautoselectplant() throws InterruptedException {
		PageFactory.initElements(driver, Customerfunpg);

		// XPATH CUSTOMER EDIT

		Thread.sleep(3000);
		String Name = PlantName;
		String NameXpath_firstPart = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/label[";
		String NameXpath_lastPart = "]";
		String EditXpath_firstPart = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/label[";
		String EditXpath_lastPart = "]";

//****************************************************************************************************  
//									EDIT BASIC LOOP FUNCTIONS
//****************************************************************************************************

//---------------------------------------------------------------------------------------
//								DON'T MAKE ANY CHANGE THIS CODE 
//=======================================================================================
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

//==================================================================================
//							ALLOCATE PLANT PATH EDIT 
	@Test(priority = 3)
	public static void AddAllocatesecondselectplant() throws InterruptedException {
		PageFactory.initElements(driver, Customerfunpg);

		// XPATH CUSTOMER EDIT

		Thread.sleep(3000);
		String Name = OtherPlantName;
		String NameXpath_firstPart = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/label[";
		String NameXpath_lastPart = "]";
		String EditXpath_firstPart = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/label[";
		String EditXpath_lastPart = "]";

//****************************************************************************************************  
//							EDIT BASIC LOOP FUNCTIONS
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

// ALLOCATE PLANT PATH & select plant & click
		Thread.sleep(2000);

		CustomerPage.Okbtn.click();

	}

	// CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE
	@Test(priority = 4)
	public static void customaddedvaluecheckway() throws InterruptedException {
		PageFactory.initElements(driver, Customerfunpg);
		Thread.sleep(2000);
		String actualdata = CustomerPage.EditCustomerfirstdata.getText();
		System.out.println("First row of table : " + actualdata);

		String expecteddata = VerifyCustomerName;

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
			testCase.log(Status.PASS, "Correct last added data");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.FAIL, "Wrong last added data");
		}

	}

	@Test(priority = 5)
	public static void LogoutMethod() throws InterruptedException {
		Thread.sleep(1000);
		PageFactory.initElements(driver, Customerfunpg);
		MultiSearchMethods.Logout();

	}
}
