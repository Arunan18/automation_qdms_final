/***********************************************************************************
* Description
*------------
*TC-PRO-SAM-0294	Check New Added Sample Status AS NEW


***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 02/05/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*  TC-MIX-DES-0064     12/05/2023     RAHUL.S       Original Version
*                                                     By using Sasi kala Method
************************************************************************************/
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
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class AddInprocessSampleStatusAsNew extends DriverIntialization {
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
	static int BLLCNo = 0;
	static int GRN = 0;
	static int Quantityandbrandreceived = 0;
	static String SuccessMsg = "";
	static String ConfirmCode = "";
	static String status = "";

	@Test(priority = 0)
	public static void LoginMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

		InprocessSamplePage.username.sendKeys("admin");
		InprocessSamplePage.password.sendKeys("tokyo@admin");
		InprocessSamplePage.login.click();

	}

	@Test(priority = 1)
	public static void SampleMainMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1500);
		InprocessSamplePage.Sample.click();
		InprocessSamplePage.RawMaterialTopbar.click();
		InprocessSamplePage.InprocessSample.click();
	}

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
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("INPROCESS ADD BUTTON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

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
				"TC-PRO-SAM-0294");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx", "Process Sample",
				"TC-PRO-SAM-0294");
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
			BLLCNo = (int) row.getCell(13).getNumericCellValue();
			GRN = (int) row.getCell(14).getNumericCellValue();
			Quantityandbrandreceived = (int) row.getCell(15).getNumericCellValue();
			SuccessMsg = (String) row.getCell(16).getStringCellValue();
			ConfirmCode = (String) row.getCell(17).getStringCellValue();
			status = (String) row.getCell(18).getStringCellValue();

		}
	}

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
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SUPPLIER CATEGORY FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

//XPATH SUPPLIER CATEGORY EDIT

		String Name = SupplierCategory;
		String NameXpath_firstPart = "/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div[";
		String NameXpath_lastPart = "]";
		String EditXpath_firstPart = "/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div[";
		String EditXpath_lastPart = "]";

//****************************************************************************************************
		// EDIT BASIC LOOP FUNCTIONS
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
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("PLANT FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

//XPATH PLANT EDIT

		String PlantName = Plant;
		String NameXpath_firstPart = "/html/body/div[5]/div/div/div/div[2]/div[1]/div/div/div[";
		String NameXpath_lastPart = "]";
		String EditXpath_firstPart = "/html/body/div[5]/div/div/div/div[2]/div[1]/div/div/div[";
		String EditXpath_lastPart = "]";

//****************************************************************************************************
		// EDIT BASIC LOOP FUNCTIONS
//****************************************************************************************************
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
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SUPPLIER FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		InprocessSamplePage.SupplierNameField.sendKeys(SupplierEnterLetter);

//XPATH SUPPLIER EDIT

		String SupplierName = Supplier;
		String NameXpath_firstPart = "/html/body/div[6]/div/div/div/div[2]/div[1]/div/div/div[";
		String NameXpath_lastPart = "]";
		String EditXpath_firstPart = "/html/body/div[6]/div/div/div/div[2]/div[1]/div/div/div[";
		String EditXpath_lastPart = "]";

//****************************************************************************************************
		// EDIT BASIC LOOP FUNCTIONS
//****************************************************************************************************
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
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("RAW MATERIAL FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
		Thread.sleep(1000);
		InprocessSamplePage.RawMaterialField.sendKeys(RawMaterialEnterLetter);
//XPATH Raw Material EDIT

		String RawmaterialName = RawMaterial;
		String NameXpath_firstPart = "/html/body/div[7]/div/div/div/div[2]/div[1]/div/div/div[";
		String NameXpath_lastPart = "]";
		String EditXpath_firstPart = "/html/body/div[7]/div/div/div/div[2]/div[1]/div/div/div[";
		String EditXpath_lastPart = "]";

//****************************************************************************************************
		// EDIT BASIC LOOP FUNCTIONS
//****************************************************************************************************
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

	@Test(priority = 8)
	public static void InprocessVehicleNumberFieldMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
		SampleActionMethods.sendkeys(InprocessSamplePage.VehicleNoField, VehicleNumber, "VEHICLE NUMBER FIELD");
	}

	@Test(priority = 9)
	public static void InprocessSampleCodeFieldMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
		SampleActionMethods.sendkeys(InprocessSamplePage.SampleCodeField, SampleCode, "SAMPLE CODE FIELD");
	}

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
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SOURCE FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

//XPATH SOURCE EDIT

		String SourceName = Source;
		String NameXpath_firstPart = "/html/body/div[8]/div/div/div/div[2]/div[1]/div/div/div[";
		String NameXpath_lastPart = "]";
		String EditXpath_firstPart = "/html/body/div[8]/div/div/div/div[2]/div[1]/div/div/div[";
		String EditXpath_lastPart = "]";

//****************************************************************************************************
		// EDIT BASIC LOOP FUNCTIONS
//****************************************************************************************************
		boolean clickNextPage = true;
		boolean CustomerExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					Thread.sleep(3000);
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
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("DATE OF SAMPLING FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

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
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SAMPLING TIME FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

//****************
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
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("DATE OF SAMPLING ARRIVAL FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

//*****************
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
					InprocessSamplePage.BLLCNoField.sendKeys(String.valueOf(BLLCNo));

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("SAMPLE BLLC FIELD ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SAMPLE BLLC FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

//*****************
	@Test(priority = 15)
	public static void InprocessGRNMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
//SampleActionMethods.sendkeys(InprocessSamplePage.GRNField,GRN,"SAMPLE GRN FIELD");
		if (InprocessSamplePage.GRNField.isDisplayed()) {
			testCase = extent.createTest("SAMPLE GRN FIELD VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.GRNField.isEnabled()) {
				testCase = extent.createTest("SAMPLE GRN FIELD ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.GRNField.click();
					Thread.sleep(1000);
					InprocessSamplePage.GRNField.sendKeys(String.valueOf(GRN));

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("SAMPLE GRN FIELD ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SAMPLE GRN FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

	@Test(priority = 16)
	public static void InprocessQuantityMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
//SampleActionMethods.sendkeys(InprocessSamplePage.QuantityandbrandreceivedField,Quantityandbrandreceived,"SAMPLE QUANTITY BRANCH RECEIVE FIELD");
		if (InprocessSamplePage.QuantityandbrandreceivedField.isDisplayed()) {
			testCase = extent.createTest("SAMPLE QUANTITY BRAND RECEIVED FIELD VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.QuantityandbrandreceivedField.isEnabled()) {
				testCase = extent.createTest("SAMPLE QUANTITY BRAND RECEIVED FIELD ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.QuantityandbrandreceivedField.click();
					Thread.sleep(1000);
					InprocessSamplePage.QuantityandbrandreceivedField
							.sendKeys(String.valueOf(Quantityandbrandreceived));

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("SAMPLE QUANTITY BRAND RECEIVED FIELD ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SAMPLE QUANTITY BRAND RECEIVED FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

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
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SAMPLE SAVE BUTTON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

//*************************************************************************************
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

//****************************************************************************************			
//		 					CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE
//****************************************************************************************

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

	@Test(priority = 20)
	public static void checkingStatus() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

		String actual = driver.findElement(By.xpath("//tbody/tr[2]/td[16]/span[1]/span[1]/p[1]")).getText();
		String expected = status;
		testCase = extent.createTest("Checking New Added Sample Status AS NEW");
		try {
			Assert.assertEquals(actual, expected);
			testCase.log(Status.INFO, "ACTUAL STATUS :- " + actual);
			testCase.log(Status.INFO, "EXPECTED STATUS:- " + expected);
			testCase.log(Status.PASS, "ADD STATUS IS CORRECT");
		} catch (AssertionError e) {

			testCase.log(Status.INFO, "ACTUAL STATUS :- " + actual);
			testCase.log(Status.INFO, "EXPECTED STATUS :- " + expected);
			testCase.log(Status.FAIL, "ADD STATUS IS NOT CORRECT");
		}

	}

	@Test(priority = 21)
	public static void LogoutMethod() throws InterruptedException {
		Thread.sleep(1000);
		PageFactory.initElements(driver, inprocesssample);
		MultiSearchMethods.Logout();

	}
}
