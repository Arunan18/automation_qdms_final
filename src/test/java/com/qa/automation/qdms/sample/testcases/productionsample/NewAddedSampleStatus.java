//***********************************************************************************
//* Description
//*------------
//* Select Key Test Production Sample - Process
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 10/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PRODUCT-SAM-0282   10/05/2023    Sayan     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class NewAddedSampleStatus extends DriverIntialization {
	
	static ProductionSamplePage productionsamplepg = new ProductionSamplePage();
	static SampleCommonMethods methods = new SampleCommonMethods();
	static SampleActionMethods samplemethod = new SampleActionMethods();
	
	static String Plant = "";
	static String finishproduct = "";
	static String mixdesign = "";
	static String equipment = "";
	static String samplecode = "";
	static String sampledate = "";
	static String customer = "";
	static String project = "";
	static int workorder = 0;
	static String creationdate = "";
	static String productiondate = "";
	static String delivery = "";
	static String vehicleno = "";
	static String sampletime = "";
	static String commodity = "";
	static String status = "";
	
	@Test
	
	public static void newAddedSampleStatus () throws InterruptedException, IOException {
		
		PageFactory.initElements(driver, productionsamplepg);
		PageFactory.initElements(driver, samplemethod);
		
		
	/* LOGIN */
		LoginTest.Login(); 
		
	/*Excel Sheet Value Passing*/	
		
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Production Sample";
		String testCaseId = "TC-PRODUCT-SAM-0282";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Production Sample");
			 
			XSSFRow row = sheet.getRow(firstRow);
			
				Plant = (String) row.getCell(1).getStringCellValue();
				finishproduct = (String) row.getCell(2).getStringCellValue();
				mixdesign = (String) row.getCell(3).getStringCellValue();
				equipment = (String) row.getCell(4).getStringCellValue();
				samplecode = (String) row.getCell(5).getStringCellValue();
				sampledate = (String) row.getCell(6).getStringCellValue();
				customer = (String) row.getCell(7).getStringCellValue();
				project = (String) row.getCell(8).getStringCellValue();
				workorder = (int) row.getCell(9).getNumericCellValue();
				creationdate = (String) row.getCell(10).getStringCellValue();
				productiondate = (String) row.getCell(11).getStringCellValue();
				delivery = (String) row.getCell(12).getStringCellValue();
				vehicleno = (String) row.getCell(13).getStringCellValue();
				sampletime = (String) row.getCell(14).getStringCellValue();
				commodity = (String) row.getCell(15).getStringCellValue();
				status = (String) row.getCell(16).getStringCellValue();
		
	/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- PRODUCTION SAMPLE PROPERTIES", ProductionSamplePage.samplexpath,
				"01--PRODUCTION SAMPLE CARD DISPLAYED",
				"02--PRODUCTION SAMPLE CARD ENABLED", ProductionSamplePage.sampletext,"SAMPLES",
				"03--ON CLICK THE SAMPLE CARD IT'S REDERECT TO CORRECT WINDOW");
		
	/* FINISH PRODUCT SAMPLE PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- FINISH PRODUCT SAMPLE PROPERTIES", ProductionSamplePage.topnavfinishproduct,
				"01--FINISH PRODUCT TOP NAVIGATION BUTTON DISPLAYED",
				"02--FINISH PRODUCT TOP NAVIGATION BUTTON ENABLED", ProductionSamplePage.plantlabwindowheadding,
				ProductionSamplePage.productionwindowheadding,
				"03--ON CLICK THE FINISH PRODUCT TOP NAVIGATION SHOWES CORRECT WINDOW"); 
		
	/* PRODUCTION SAMPLE PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- PRODUCTION SAMPLE PROPERTIES", ProductionSamplePage.productionsampleLeftNav,
				"01--PRODUCTION SAMPLE LEFT NAVIGATION BUTTON DISPLAYED",
				"02--PRODUCTION SAMPLE LEFT NAVIGATION BUTTON ENABLED", ProductionSamplePage.productionwindowheadding,"Production Sample",
				"03--ON CLICK THE PRODUCTION SAMPLE LEFT NAVIGATION SHOWES CORRECT WINDOW");
		
	/* ADD PRODUCTION SAMPLE BUTTON PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_04-- ADD PRODUCTION SAMPLE BUTTON PROPERTIES", ProductionSamplePage.addproductionsample,
				"01-- ADD PRODUCTION SAMPLE BUTTON DISPLAYED",
				"02-- ADD PRODUCTION SAMPLE BUTTON ENABLED", ProductionSamplePage.addproductionheading,"Add Production Sample",
				"03-- ON CLICK THE ADD PRODUCTION SAMPLE BUTTON IT'S SHOWES THE ADD PRODUCTION SAMPLE WINDOW");
	
		
   /* RADIO BUTTON DISPLAYED & ENABLED & SELECTED */
		SampleCommonMethods.singleclick("STEP_05-- SINGLE RADIO BUTTON PROPERTIES", ProductionSamplePage.singleradiobtn,"01-- SINGLE RADIO BUTTON DISPLAYED", "02-- SINGLE RADIO BUTTON ENABLED");
		
   /* PLANT FIELD DISPLAYED & ENABLED & SELECTED */
		SampleCommonMethods.fieldmethodselect("STEP_06-- PLANT FIELD PROPERTIES", ProductionSamplePage.plant,"01-- PLANT FIELD DISPLAYED", "02-- PLANT FIELD ENABLED" , Plant , "03-- DATA SUCCESSFULLY SELECTED");
	
   /* FINISH PRODUCT FIELD DISPLAYED & ENABLED & SELECTED */  
		SampleCommonMethods.fieldmethodselect("STEP_07-- FINISH PRODUCT FIELD PROPERTYS ", ProductionSamplePage.finishproduct,"01-- FINISH PRODUCT FIELD DISPLAYED", "02-- FINISH PRODUCT FIELD ENABLED" , finishproduct, "03-- DATA SUCCESSFULLY SELECTED");
	
   /* MIX DESIGN FIELD DISPLAYED & ENABLED & SELECTED */  
		SampleCommonMethods.fieldmethoddropdown("STEP_08-- MIX DESIGN FIELD PROPERTYS ", ProductionSamplePage.mixdesign,"01--  MIX DESIGN FIELD DISPLAYED", "02--  MIX DESIGN FIELD ENABLED" , "//div[contains(@class,'ant-select-item-option-content')][normalize-space()='"+ mixdesign +"']", "03-- DATA SUCCESSFULLY SELECTED");
	   
   /*EQUIPMENT FIELD DISPLAYED & ENABLED & SELECTED */  
		SampleCommonMethods.fieldmethodselect("STEP_09-- EQUIPMENT FIELD PROPERTYS ", ProductionSamplePage.equipment, "01--  EQUIPMENT FIELD DISPLAYED", "02--  EQUIPMENT FIELD ENABLED" , equipment, "03-- DATA SUCCESSFULLY SELECTED");
	
   /* SAMPLE FIELD DISPLAYED & ENABLED & SELECTED */  
		SampleCommonMethods.fieldmethodselect("STEP_10-- SAMPLE FIELD PROPERTYS ", ProductionSamplePage.samplecode,"01--  SAMPLE FIELD DISPLAYED", "02--  SAMPLE FIELD ENABLED" , samplecode , "03-- DATA SUCCESSFULLY SELECTED");

   /* SAMPLE DATE FIELD DISPLAYED & ENABLED & SELECTED */  
		SampleCommonMethods.fieldmethodselect("STEP_11-- SAMPLE DATE PROPERTYS ", ProductionSamplePage.sampledate,"01--  SAMPLE DATE FIELD DISPLAYED", "02--  SAMPLE DATE FIELD ENABLED" , sampledate, "03-- DATA SUCCESSFULLY SELECTED");
 
   /* CUSTOMER FIELD DISPLAYED & ENABLED & SELECTED */  
		SampleCommonMethods.fieldmethodselect("STEP_12-- CUSTOMER FIELD PROPERTYS ", ProductionSamplePage.customer,"01--  CUSTOMER FIELD DISPLAYED", "02--  CUSTOMER FIELD ENABLED" , customer, "03-- DATA SUCCESSFULLY SELECTED");

   /* PROJECT FIELD DISPLAYED & ENABLED & SELECTED */  
		SampleCommonMethods.fieldmethoddropdown("STEP_13-- PROJECT FIELD PROPERTYS ", ProductionSamplePage.project,"01--  PROJECT FIELD DISPLAYED", "02--  PROJECT FIELD ENABLED" , "//div[contains(text(),'"+ project +"')]", "03-- DATA SUCCESSFULLY SELECTED");
    
   /* WORK ORDER FIELD DISPLAYED & ENABLED & SELECTED */  
		SampleCommonMethods.fieldmethodselect("STEP_14-- WORK ORDER NO FIELD PROPERTYS ", ProductionSamplePage.workorder,"01--  WORK ORDER NO FIELD DISPLAYED", "02-- WORK ORDER NO FIELD ENABLED" , String.valueOf(workorder) , "03-- DATA SUCCESSFULLY SELECTED");

   /* CREATE DATE FIELD DISPLAYED & ENABLED & SELECTED */  
		SampleCommonMethods.fieldmethodselect("STEP_15-- CREATE DATE FIELD PROPERTYS ", ProductionSamplePage.creationdate,"01-- CREATE DATE FIELD DISPLAYED", "02-- CREATE DATE FIELD ENABLED" , creationdate , "03-- DATA SUCCESSFULLY SELECTED");

   /* PRODUCTION DATE FIELD DISPLAYED & ENABLED & SELECTED */  
		SampleCommonMethods.fieldmethodselect("STEP_16-- PRODUCTION DATE FIELD PROPERTYS ", ProductionSamplePage.productiondate,"01-- PRODUCTION DATE FIELD DISPLAYED", "02-- PRODUCTION DATE FIELD ENABLED" , productiondate , "03-- DATA SUCCESSFULLY SELECTED");

   /* DELIVERY FIELD DISPLAYED & ENABLED & SELECTED */  
		SampleCommonMethods.fieldmethoddropdown("STEP_17-- DELIVERY FIELD PROPERTYS ", ProductionSamplePage.delivery,"01-- DELIVERY FIELD DISPLAYED", "02-- DELIVERY FIELD ENABLED" , "//div[contains(@class,'ant-select-item-option-content')][normalize-space()='"+delivery+"']", "03-- DATA SUCCESSFULLY SELECTED");
  
   /* VEHICLE NO DISPLAYED & ENABLED & SELECTED */  
		SampleCommonMethods.fieldmethodselect("STEP_18-- VEHICLE NO FIELD PROPERTYS ", ProductionSamplePage.vehicleno,"01-- VEHICLE NO FIELD DISPLAYED", "02-- VEHICLE NO FIELD ENABLED" , vehicleno, "03-- DATA SUCCESSFULLY SELECTED");
  
   /* SAMPLE TIME DISPLAYED & ENABLED & SELECTED */  
		SampleCommonMethods.fieldmethodselect("STEP_19-- SAMPLE TIME FIELD PROPERTYS ", ProductionSamplePage.sampletime,"01-- SAMPLE TIME FIELD DISPLAYED", "02-- SAMPLE TIME FIELD ENABLED" , sampletime, "03-- DATA SUCCESSFULLY SELECTED");
  
   /* COMMODITY FIELD DISPLAYED & ENABLED & SELECTED */  
		SampleCommonMethods.fieldmethodselect("STEP_20-- COMMODITY FIELD PROPERTYS ", ProductionSamplePage.commodity,"01-- COMMODITY FIELD DISPLAYED", "02-- COMMODITY FIELD ENABLED" , commodity, "03-- DATA SUCCESSFULLY SELECTED");
  
   /* SAVE BUTTON DISPLAYED & ENABLED & SELECTED */
		SampleCommonMethods.singleclick("STEP_21-- SAVE BUTTON PROPERTIES", ProductionSamplePage.save,"01-- SAVE BUTTON DISPLAYED", "02-- SAVE BUTTON ENABLED");

   /* DATA ADDED SUCCESS MESSAGE */
		SampleCommonMethods.dataaddedsuccessmsg("STEP_22-- DATA ADDED SUCCESSFULLY",ProductionSamplePage.successMsg,"Production Sample Added Sucessfully");
	
   /*CHECK FIRST DATA OF THE TABLE*/
		SampleCommonMethods.firstrowdata("STEP_23-- DATA ADDED IN FIRST ROW", ProductionSamplePage.firstdata, "RMC Ankanda Plant");
  
		
		
		
//		CONFIRM THE STATUS
//		---------------------
		
		Thread.sleep(2000);
		String ActualData = ProductionSamplePage.firstRowStatus.getText();
        String ExpectedData = "NEW";
        System.out.println("status : " + ActualData);
        testCase = extent.createTest("STEP_24-- VERIFY THE STATUS OF SAMPLE");
        if (ActualData.equals("NEW")) {
//            Assert.assertEquals(ActualData, ExpectedData);
            testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
            testCase.log(Status.INFO, "Expectedvalue :- " + ExpectedData);
            testCase.log(Status.INFO, "Correct value");
            testCase.log(Status.PASS, ActualData);
        } else {
            testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
            testCase.log(Status.INFO, "ExpectedValue :- " + ExpectedData);
            testCase.log(Status.INFO, "wrong value");
            testCase.log(Status.FAIL, ActualData);
        }
		
		
	}

}
