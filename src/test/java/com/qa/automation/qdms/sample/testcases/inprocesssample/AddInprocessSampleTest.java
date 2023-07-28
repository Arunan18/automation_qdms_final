
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS SAMPLE ADD TEST FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   11:04:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0004	 	 11:04:2023     @SASIKALA     Original Version
//* TC-PRO-SAM-0006
//* TC-PRO-SAM-0009
//*****************************************************************************************

/*
* Process Sample "Add Process Sample" Functionality - TC-PRO-SAM-0004
* Process Sample "Save" button  Functionality - TC-PRO-SAM-0006
* Process Sample "Cancel" button Functionality
* Process Sample Add Functionality -TC-PRO-SAM-0009 
*/

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class AddInprocessSampleTest extends DriverIntialization {

	static InprocessSamplePage inprocesssample = new InprocessSamplePage();
	static String SupplierCategory = "";
	static String Plant = "";
	static String SupplierEnterLetter = "";
	static String Supplier = "";
	static String RawMaterialEnterLetter = "";
	static String RawMaterial = "";
	static String VehicleNumber = "";
	static String SampleCode = "";
	static String Source = "";
	static String DateOfSampling = "";
	static String SampleTime = "";
	static String ArrivalDate = "";
	static String BLLCNo = "";
	static String GRN = "";
	static String Quantityandbrandreceived = "";
	static String SuccessMsg = "";
	static String ConfirmCode = "";

//*************************LOGIN METHOD**************************

	@Test(priority = 0)
	public static void LoginMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

		// ------Login-----------
		LoginTest.Login();
	}

//******************************SAMPLE METHOD***********************************

	@Test(priority = 1)
	public static void SampleMainMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1500);

		// ------Sample Navigation-----------
		SampleNavigateTest.sampleNavigation();

		// ------Raw Material Sample Navigation-----------
		SampleNavigateTest.rawMaterialSampleMainNavigation();

		// ------InProcess Sample Site Bar Button Navigation-----------
		SampleNavigateTest.inprocessSampleNavigation();

	}

//******************************ADD IN PROCESS SAMPLE BUTTON METHOD***********************************

	@Test(priority = 2)
	public static void AddInprocessSampleButtonMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
		if (InprocessSamplePage.AddInprocessSamplebtn.isDisplayed()) {
			testCase = extent.createTest("INPROCESS ADD BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.AddInprocessSamplebtn.isEnabled()) {
				testCase = extent.createTest("INPROCESS ADD BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.AddInprocessSamplebtn.click();
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("INPROCESS ADD BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("INPROCESS ADD BUTTON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

//******************************ADD INPROCESS SAMPLE EXCEL METHOD***********************************

	@Test(priority = 3)
	public static void AddInprocessSampleExcelMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Process Sample");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx", "Process Sample",
				"TC-PRO-SAM-0009");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx", "Process Sample",
				"TC-PRO-SAM-0009");
		for (int j = firstrow; j <= lastrow; j++) {
			XSSFRow row = sheet.getRow(j);

			SupplierCategory = (String) row.getCell(1).getStringCellValue();
			Plant = (String) row.getCell(2).getStringCellValue();
			SupplierEnterLetter = (String) row.getCell(3).getStringCellValue();
			Supplier = (String) row.getCell(4).getStringCellValue();
			RawMaterialEnterLetter = (String) row.getCell(5).getStringCellValue();
			RawMaterial = (String) row.getCell(6).getStringCellValue();
			VehicleNumber = (String) row.getCell(7).getStringCellValue();
			SampleCode = (String) row.getCell(8).getStringCellValue();
			Source = (String) row.getCell(9).getStringCellValue();
			DateOfSampling = (String) row.getCell(10).getStringCellValue();
			SampleTime = (String) row.getCell(11).getStringCellValue();
			ArrivalDate = (String) row.getCell(12).getStringCellValue();
			BLLCNo = (String) row.getCell(13).getStringCellValue();
			GRN = (String) row.getCell(14).getStringCellValue();
			Quantityandbrandreceived = (String) row.getCell(15).getStringCellValue();
			SuccessMsg = (String) row.getCell(16).getStringCellValue();
			ConfirmCode = (String) row.getCell(17).getStringCellValue();

		}
	}

//******************************INPROCESS SAMPLE SUPPLIER CATEGORY FIELD METHOD***********************************

	@Test(priority = 4)
	public static void InprocessSupplierCategoryFieldMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);

		if (InprocessSamplePage.SupplierCategoryField.isDisplayed()) {
			testCase = extent.createTest("SUPPLIER CATEGORY FIELD VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.SupplierCategoryField.isEnabled()) {
				testCase = extent.createTest("SUPPLIER CATEGORY FIELD ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.SupplierCategoryField.click();
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("SUPPLIER CATEGORY FIELD ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SUPPLIER CATEGORY FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

//--------------XPATH SUPPLIER CATEGORY EDIT------------------

		String Name = SupplierCategory;
		String NameXpath_firstPart = "/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div[";
		String NameXpath_lastPart = "]";
		String EditXpath_firstPart = "/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div[";
		String EditXpath_lastPart = "]";

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

//******************************INPROCESS SAMPLE PLANT FIELD METHOD***********************************

	@Test(priority = 5)
	public static void InprocessPlantFieldMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
		if (InprocessSamplePage.PlantField.isDisplayed()) {
			testCase = extent.createTest("PLANT FIELD VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.PlantField.isEnabled()) {
				testCase = extent.createTest("PLANT FIELD ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.PlantField.click();
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("PLANT FIELD ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("PLANT FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		// -----------------XPATH PLANT EDIT------------------------
		String PlantName = Plant;
		String NameXpath_firstPart = "/html/body/div[5]/div/div/div/div[2]/div[1]/div/div/div[";
		String NameXpath_lastPart = "]";
		String EditXpath_firstPart = "/html/body/div[5]/div/div/div/div[2]/div[1]/div/div/div[";
		String EditXpath_lastPart = "]";

		boolean clickNextPage = true;
		boolean CustomerExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					Thread.sleep(3000);
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(PlantName)) {
						CustomerExist = true;
						driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
						Thread.sleep(2000);
						clickNextPage = false;
						break;
					}
				} catch (Exception e) {
				}
			}

		}
		if (CustomerExist = false) {
			System.out.println("No such Element" + CustomerExist);
		}
	}

//******************************INPROCESS SAMPLE SUPPLIER NAME FIELD METHOD***********************************

	@Test(priority = 6)
	public static void InprocessSupplierFieldMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
		if (InprocessSamplePage.SupplierNameField.isDisplayed()) {
			testCase = extent.createTest("SUPPLIER FIELD VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.SupplierNameField.isEnabled()) {
				testCase = extent.createTest("SUPPLIER FIELD ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.SupplierNameField.click();

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("SUPPLIER FIELD ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SUPPLIER FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		InprocessSamplePage.SupplierNameField.sendKeys(SupplierEnterLetter);

//----------------XPATH SUPPLIER SELECT-------------------

		String SupplierName = Supplier;
		String NameXpath_firstPart = "/html/body/div[6]/div/div/div/div[2]/div[1]/div/div/div[";
		String NameXpath_lastPart = "]";
		String EditXpath_firstPart = "/html/body/div[6]/div/div/div/div[2]/div[1]/div/div/div[";
		String EditXpath_lastPart = "]";

		boolean clickNextPage = true;
		boolean CustomerExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					Thread.sleep(3000);
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(SupplierName)) {
						CustomerExist = true;
						driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
						Thread.sleep(2000);
						clickNextPage = false;
						break;
					}
				} catch (Exception e) {
				}
			}

		}
		if (CustomerExist = false) {
			System.out.println("No such Element" + CustomerExist);
		}
	}

//******************************INPROCESS SAMPLE RAW MATERIAL FIELD METHOD***********************************

	@Test(priority = 7)
	public static void InprocessRawMaterialFieldMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
		if (InprocessSamplePage.RawMaterialField.isDisplayed()) {
			testCase = extent.createTest("RAW MATERIAL FIELD VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.RawMaterialField.isEnabled()) {
				testCase = extent.createTest("RAW MATERIAL FIELD ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.RawMaterialField.click();

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("RAW MATERIAL FIELD ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("RAW MATERIAL FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
		Thread.sleep(1000);
		InprocessSamplePage.RawMaterialField.sendKeys(RawMaterialEnterLetter);

//--------------XPATH RAW MATERIAL SELECT-------------------------

		String RawmaterialName = RawMaterial;
		String NameXpath_firstPart = "/html/body/div[7]/div/div/div/div[2]/div[1]/div/div/div[";
		String NameXpath_lastPart = "]";
		String EditXpath_firstPart = "/html/body/div[7]/div/div/div/div[2]/div[1]/div/div/div[";
		String EditXpath_lastPart = "]";

		boolean clickNextPage = true;
		boolean CustomerExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					Thread.sleep(3000);
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(RawmaterialName)) {
						CustomerExist = true;
						driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
						Thread.sleep(2000);
						clickNextPage = false;
						break;
					}
				} catch (Exception e) {
				}
			}

		}
		if (CustomerExist = false) {
			System.out.println("No such Element" + CustomerExist);
		}
	}

//******************************INPROCESS SAMPLE VEHICLE NUMBER FIELD METHOD***********************************

	@Test(priority = 8)
	public static void InprocessVehicleNumberFieldMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
		SampleActionMethods.sendkeys(InprocessSamplePage.VehicleNoField, VehicleNumber, "VEHICLE NUMBER FIELD");
	}

//******************************INPROCESS SAMPLE SAMPLE CODE FIELD METHOD***********************************
	@Test(priority = 9)
	public static void InprocessSampleCodeFieldMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
		SampleActionMethods.sendkeys(InprocessSamplePage.SampleCodeField, SampleCode, "SAMPLE CODE FIELD");
	}

//******************************INPROCESS SAMPLE SOURCE FIELD METHOD***********************************
	@Test(priority = 10)
	public static void InprocessSourceFieldMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
		if (InprocessSamplePage.SourceField.isDisplayed()) {
			testCase = extent.createTest("SOURCE FIELD VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.SourceField.isEnabled()) {
				testCase = extent.createTest("SOURCE FIELD ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.SourceField.click();

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("SOURCE FIELD ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SOURCE FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		// -------------XPATH SOURCE SELECT--------------
		String SourceName = Source;
		String NameXpath_firstPart = "/html/body/div[8]/div/div/div/div[2]/div[1]/div/div/div[";
		String NameXpath_lastPart = "]";
		String EditXpath_firstPart = "/html/body/div[8]/div/div/div/div[2]/div[1]/div/div/div[";
		String EditXpath_lastPart = "]";

		boolean clickNextPage = true;
		boolean CustomerExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					Thread.sleep(2000);
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(SourceName)) {
						CustomerExist = true;
						driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
						Thread.sleep(2000);
						clickNextPage = false;
						break;
					}
				} catch (Exception e) {
				}
			}

		}
		if (CustomerExist = false) {
			System.out.println("No such Element" + CustomerExist);
		}
	}

//******************************INPROCESS SAMPLE SAMPLE DATE METHOD***********************************

	@Test(priority = 11)
	public static void InprocessSampleDateMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);

		if (InprocessSamplePage.DateofSamplingField.isDisplayed()) {
			testCase = extent.createTest("DATE OF SAMPLING FIELD VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.DateofSamplingField.isEnabled()) {
				testCase = extent.createTest("DATE OF SAMPLING FIELD ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.DateofSamplingField.click();
					Thread.sleep(1000);
					InprocessSamplePage.DateofSamplingFieldclosebtn.click();
					InprocessSamplePage.DateofSamplingField.sendKeys(DateOfSampling);
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.ENTER).perform();

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("DATE OF SAMPLING FIELD ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("DATE OF SAMPLING FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

//******************************INPROCESS SAMPLE SAMPLED TIME METHOD***********************************
	@Test(priority = 12)
	public static void InprocessSampleTimeMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);

		if (InprocessSamplePage.SampledTimeField.isDisplayed()) {
			testCase = extent.createTest("SAMPLING TIME FIELD VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.SampledTimeField.isEnabled()) {
				testCase = extent.createTest("SAMPLING TIME FIELD ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.SampledTimeField.click();
					Thread.sleep(1000);
					InprocessSamplePage.DateofSampleTimeFieldclosebtn.click();
					InprocessSamplePage.SampledTimeField.sendKeys(SampleTime);
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.ENTER).perform();

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("SAMPLING TIME FIELD ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SAMPLING TIME FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

//******************************INPROCESS SAMPLE ARRIVAL DATE METHOD***********************************
	@Test(priority = 13)
	public static void InprocessArrivalDateMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);

		if (InprocessSamplePage.ArrivalDateField.isDisplayed()) {
			testCase = extent.createTest("DATE OF SAMPLING ARRIVAL FIELD VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.ArrivalDateField.isEnabled()) {
				testCase = extent.createTest("DATE OF SAMPLING ARRIVAL FIELD ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.ArrivalDateField.click();
					Thread.sleep(1000);
					InprocessSamplePage.ArrivalDateField.sendKeys(ArrivalDate);
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.ENTER).perform();

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("DATE OF SAMPLING ARRIVAL FIELD ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("DATE OF SAMPLING ARRIVAL FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

//***************************************INPROCESS SAMPLE BLLC METHOD*********************************************

	@Test(priority = 14)
	public static void InprocessBLLCMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
		if (InprocessSamplePage.BLLCNoField.isDisplayed()) {
			testCase = extent.createTest("SAMPLE BLLC FIELD VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.BLLCNoField.isEnabled()) {
				testCase = extent.createTest("SAMPLE BLLC FIELD ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.BLLCNoField.click();
					Thread.sleep(1000);
					InprocessSamplePage.BLLCNoField.sendKeys(BLLCNo);

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("SAMPLE BLLC FIELD ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SAMPLE BLLC FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

//*******************************************INPROCESS SAMPLE GRN METHOD*********************************************

	@Test(priority = 15)
	public static void InprocessGRNMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
		if (InprocessSamplePage.GRNField.isDisplayed()) {
			testCase = extent.createTest("SAMPLE GRN FIELD VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.GRNField.isEnabled()) {
				testCase = extent.createTest("SAMPLE GRN FIELD ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.GRNField.click();
					Thread.sleep(1000);
					InprocessSamplePage.GRNField.sendKeys(GRN);

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("SAMPLE GRN FIELD ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SAMPLE GRN FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

//******************************INPROCESS SAMPLE QUANTITY METHOD***********************************
	@Test(priority = 16)
	public static void InprocessQuantityMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);

		if (InprocessSamplePage.QuantityandbrandreceivedField.isDisplayed()) {
			testCase = extent.createTest("SAMPLE QUANTITY BRAND RECEIVED FIELD VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.QuantityandbrandreceivedField.isEnabled()) {
				testCase = extent.createTest("SAMPLE QUANTITY BRAND RECEIVED FIELD ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.QuantityandbrandreceivedField.click();
					Thread.sleep(1000);
					InprocessSamplePage.QuantityandbrandreceivedField.sendKeys(Quantityandbrandreceived);

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("SAMPLE QUANTITY BRAND RECEIVED FIELD ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SAMPLE QUANTITY BRAND RECEIVED FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

//******************************INPROCESS SAMPLE SAVE BUTTON METHOD***********************************

	@Test(priority = 17)
	public static void InprocessSaveMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);

		if (InprocessSamplePage.Savebtn.isDisplayed()) {
			testCase = extent.createTest("SAMPLE SAVE BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.ArrivalDateField.isEnabled()) {
				testCase = extent.createTest("SAMPLE SAVE BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.Savebtn.click();

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("SAMPLE SAVE BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SAMPLE SAVE BUTTON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

//******************************INPROCESS SAMPLE ADDED SUCCESS METHOD***********************************

	@Test(priority = 18)
	public static void InprocessSuccessMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);

		Thread.sleep(1000);
		String AddSuccessMessage = InprocessSamplePage.AddInProcessSamplesuccessmsg.getText();
		System.out.println(AddSuccessMessage);
		String expectedatamsg = SuccessMsg;

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

//******************************CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE*********************************	

	@Test(priority = 19)
	public static void InprocessLastaddedcomefirstMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
		Thread.sleep(2000);
		String actualdata = InprocessSamplePage.AddInProcessfirstdata.getText();
		System.out.println("First row of table : " + actualdata);

		String expecteddata = ConfirmCode;

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

//******************************CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE*********************************

	@Test(priority = 20)
	public static void LogoutMethod() throws InterruptedException {
		Thread.sleep(1000);
		PageFactory.initElements(driver, inprocesssample);
		MultiSearchMethods.Logout();

	}

}
