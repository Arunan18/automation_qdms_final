//***********************************************************************************
//* Description
//*------------
//* EDIT PRODUCTION SAMPLE ON STATUS IN NEW
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 20/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PRODUCT-SAM-0011   20/04/2023   Gobithan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProductionSampleEditForNewStatus extends DriverIntialization {
	static ProductionSamplePage productionsample = new ProductionSamplePage();
	static SampleCommonMethods methods = new SampleCommonMethods();
	static SampleActionMethods samplemethod = new SampleActionMethods();
	static Logout logout = new Logout();

	static String editvalue = "";
	static String equipment = "";
	static String samplecode = "";
	static String sampledate = "";
	static String customer = "";
	static String message = "";
	
	
	
	@Test
	public static void function() throws InterruptedException, IOException {
		PageFactory.initElements(driver, productionsample);
		PageFactory.initElements(driver, samplemethod);

		/* LOGIN */
		LoginTest.Login();

		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- PRODUCTION SAMPLE PROPERTIES", productionsample.samplexpath,
				"01--PRODUCTION SAMPLE CARD DISPLAYED", "02--PRODUCTION SAMPLE CARD ENABLED",
				productionsample.sampletext, "SAMPLES", "03--ON CLICK THE SAMPLE CARD IT'S REDERECT TO CORRECT WINDOW");

		/* FINISH PRODUCT SAMPLE PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- FINISH PRODUCT SAMPLE PROPERTIES",
				productionsample.topnavfinishproduct, "01--FINISH PRODUCT TOP NAVIGATION BUTTON DISPLAYED",
				"02--FINISH PRODUCT TOP NAVIGATION BUTTON ENABLED", productionsample.plantlabwindowheadding,
				productionsample.productionwindowheadding,
				"03--ON CLICK THE FINISH PRODUCT TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* PRODUCTION SAMPLE PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- PRODUCTION SAMPLE PROPERTIES",
				productionsample.productionsampleLeftNav, "01--PRODUCTION SAMPLE LEFT NAVIGATION BUTTON DISPLAYED",
				"02--PRODUCTION SAMPLE LEFT NAVIGATION BUTTON ENABLED", productionsample.productionwindowheadding,
				"Production Sample", "03--ON CLICK THE PRODUCTION SAMPLE LEFT NAVIGATION SHOWES CORRECT WINDOW");

		/* SELECT THE NEW STATUS EDIT BUTTON */
		editonnewstatus();
		
		
/*Excel Sheet Value Passing*/	
		
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Production Sample";
		String testCaseId = "TC-PRODUCT-SAM-0011";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Production Sample");
			 
			XSSFRow row = sheet.getRow(firstRow);
			
			editvalue = (String) row.getCell(1).getStringCellValue();
			equipment = (String) row.getCell(2).getStringCellValue();
			samplecode = (String) row.getCell(3).getStringCellValue();
			sampledate = (String) row.getCell(4).getStringCellValue();
			customer = (String) row.getCell(5).getStringCellValue();
			message = (String) row.getCell(6).getStringCellValue();
				
		
	/*EQUIPMENT FIELD DISPLAYED & ENABLED & SELECTED */  
		productionsample.equipment.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		SampleCommonMethods.fieldmethodselect("STEP_04-- EQUIPMENT FIELD PROPERTYS ", productionsample.equipment, "01--  EQUIPMENT FIELD DISPLAYED", "02--  EQUIPMENT FIELD ENABLED" , equipment, "03-- DATA SUCCESSFULLY SELECTED");
	
 
   /* SAMPLE FIELD DISPLAYED & ENABLED & SELECTED */  
		productionsample.samplecode.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		SampleCommonMethods.fieldmethodselect("STEP_05-- SAMPLE FIELD PROPERTYS ", productionsample.samplecode,"01--  SAMPLE FIELD DISPLAYED", "02--  SAMPLE FIELD ENABLED" , samplecode , "03-- DATA SUCCESSFULLY SELECTED");

   /* SAMPLE DATE FIELD DISPLAYED & ENABLED & SELECTED */
		productionsample.sampledate.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		SampleCommonMethods.fieldmethodselect("STEP_06-- SAMPLE DATE PROPERTYS ", productionsample.sampledate,"01--  SAMPLE DATE FIELD DISPLAYED", "02--  SAMPLE DATE FIELD ENABLED" , sampledate, "03-- DATA SUCCESSFULLY SELECTED");
 
   /* CUSTOMER FIELD DISPLAYED & ENABLED & SELECTED */ 
		productionsample.customer.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		SampleCommonMethods.fieldmethodselect("STEP_07-- CUSTOMER FIELD PROPERTYS ", productionsample.customer,"01--  CUSTOMER FIELD DISPLAYED", "02--  CUSTOMER FIELD ENABLED" , customer, "03-- DATA SUCCESSFULLY SELECTED");
  
   /* SAVE BUTTON DISPLAYED & ENABLED & SELECTED */
		SampleCommonMethods.singleclick("STEP_08-- UPDATE BUTTON PROPERTIES", productionsample.updatebtn,"01-- UPDATE BUTTON DISPLAYED", "02-- UPDATE BUTTON ENABLED");

   /* DATA ADDED SUCCESS MESSAGE */
		SampleCommonMethods.dataaddedsuccessmsg("STEP_09-- DATA ADDED SUCCESSFULLY",productionsample.successMsg, message);
	
   /*CHECK FIRST DATA OF THE TABLE*/
		SampleCommonMethods.firstrowdata("STEP_10-- DATA ADDED IN FIRST ROW", productionsample.firsteditdata, editvalue);
    
   /*LOGOUT FROM FINISH PRODUCT SAMPLE*/
		logout.LogoutFunction();

	}

	
	/* METHOD FOR SELECT EDIT BUTTON IN NEW STATUS */
	
	public static void editonnewstatus() {
		String status = null;
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;
		Boolean not = false;
		Boolean re = null;
		try {
			filelocation = "./src/test/resources/Excel/Samples Module.xlsx";

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);

		} catch (Exception e) {
			// TODO: handle exception
		}

		XSSFSheet sheet = wbook.getSheet("Production Sample");
		PropertiesCommonMethods.excalRowCount("Samples Module.xlsx", "Production Sample", "TC-PRODUCT-SAM-0011-01");
		int r = PropertiesCommonMethods.countRow - 1;

		row = sheet.getRow(r);
		cell = row.getCell(1);
		String iV = dataValue.formatCellValue(cell);
		// System.out.println(iV);

		int i = 0;
		String value = null;
		String value2 = null;

		boolean rept = true;
		List<WebElement> allrows = null;
		int num;

		while (rept == true) {
			allrows = ProductionSamplePage.productionSampleTable.findElements(By.cssSelector("tbody tr"));
			num = allrows.size();
			for (i = 0; i < num; i++) {

				List<WebElement> rows = allrows.get(i).findElements(By.tagName("td"));
				// In table selected record column
				String name = rows.get(0).getText();
				status = rows.get(18).getText();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
				}
				rept = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
				// System.out.println(rept);

				if (name.equals(iV)) {
					rept = false;
					not = true;
					re = true;
					System.out.println(status);

					if (status.equals("NEW")) {

						testCase = extent.createTest("04--STATUS IS NEW");
						testCase.log(Status.PASS, "TEST PASS");

						try {
							WebElement input = rows.get(24).findElement(By.cssSelector(".anticon-edit"));
							Boolean dis = input.isDisplayed();
							PropertiesCommonMethods.cTestReports("05--EDIT BUTTON IS DISPLAYED", "true", dis,
									"Edit Icon");

							if (dis == true) {
								Boolean ena = input.isEnabled();
								PropertiesCommonMethods.cTestReports("06--EDIT BUTTON IS ENABLED", "true", ena,
										"Edit-Icon");
								if (ena == true) {
									input.click();
									try {
										Thread.sleep(3000);
									} catch (InterruptedException e) {

									}
									Boolean popup = driver.findElement(By.cssSelector(".ant-modal-content"))
											.isDisplayed();
									PropertiesCommonMethods.cTestReports("07--EDIT SCREEN IS DISPLAYED", "true", popup,
											"Edit-Icon");
									rept = false;
									not = true;
									re = false;
									break;
								}
							}
						} catch (Exception e) {

							rept = false;
							break;
						}

					} else {
						break;
					}

				}

			}
			if (rept == true) {
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

				}

			}

			else if (rept == false & not == false) {
				testCase = extent.createTest("SEARCHING DATA NOT FIND IN TABLE");

			} else if (rept == false & not == true) {

				if (re == true) {
					testCase.log(Status.PASS, "Status not in new");
					

				} else {
					testCase.log(Status.PASS, "Status In New Edit Sucess");
				}

			}
		}
	}

}
