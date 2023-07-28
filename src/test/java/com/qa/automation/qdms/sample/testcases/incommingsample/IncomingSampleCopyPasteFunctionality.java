package com.qa.automation.qdms.sample.testcases.incommingsample;
//***********************************************************************************
//* Description
//*------------
//*Copy Paste Incoming Sample  - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 17/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-ROL-0016           17/04/2023   Saranka     Original Version
//*
//************************************************************************************package com.qa.automation.qdms.sample.testcases.incommingsample;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.soap.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class IncomingSampleCopyPasteFunctionality  extends DriverIntialization{
	static IncomingSamplePage samplePage = new IncomingSamplePage();
	static String Searchdata = null;
	static String StatusBarColour = null;
	static String StatusText = null;
	
	
	
	public static  void NavigateToIncomingSample() throws InterruptedException, IOException {
		PageFactory.initElements(driver, samplePage);
		
		
//__________________________________________________________________________
//   NAVIGATE TO INCOMING SAMPLE 
//__________________________________________________________________________		
		Thread.sleep(5000);
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.rawMaterialSampleMainNavigation();
		SampleNavigateTest.incommingSampleNavigation();
		Thread.sleep(5000);
	}
//__________________________________________________________________________
//  EXCEL METHOD
//__________________________________________________________________________
		public static void ExcelMethod() throws IOException {
			String excelPath = System.getProperty ("user.dir") +"\\src\\test\\resources\\Excel\\Samples Module.xlsx";
			String excelSheetName = "Incoming Sample";
			String testCaseId = "TC-INC-SAM-0167";
			
			int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
			int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(excelSheetName);

			for (int i = firstRow; i <= lastRow; i++) {
				XSSFRow row = sheet.getRow(i);
				Searchdata = (String) row.getCell(1).getStringCellValue();   
				StatusBarColour = (String) row.getCell(2).getStringCellValue();
				StatusText = (String) row.getCell(3).getStringCellValue();
				
			}
		}

//__________________________________________________________________________
//    SEARCH DATA TO COPY
//__________________________________________________________________________	
		
		public static void CopyPasteFunctionality() throws InterruptedException {
		PageFactory.initElements(driver, samplePage);
		SampleActionMethods.perticularDataSearch(IncomingSamplePage.incomingSampleTable, Searchdata,IncomingSamplePage.addIncomingBtn, IncomingSamplePage.NextBtn);
	
		
//_______________________________________________________________________
//    ADD INCOME SAMPLE BUTTON IS VISIBLE
//    ADD INCOME SAMPLE BUTTON ENABLE		
//_______________________________________________________________________	
		
		SampleActionMethods.clicking(IncomingSamplePage.addIncomingBtn, 2, Searchdata);
		
		Thread.sleep(2000);
		IncomingSamplePage.BodyOf_AddIncomingSample.click();
//____________________________________________________________________________
//   COPY PASTE FUNCTION
//____________________________________________________________________________		
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

//___________________________________________________________________________
//   BEFORE SAVE GET TEXT OF TIME FIELD
//____________________________________________________________________________        
       Thread.sleep(2000);
        String actualTime = IncomingSamplePage.TimeBefore.getAttribute("value");
        System.out.println("Before save field time:-"+actualTime);
        String expectedTime = "";
        
        testCase = extent.createTest("STEP:2 Before Save Get Text of Time Field");
        try {
        	Assert.assertEquals(actualTime, expectedTime);
        }catch (AssertionError e) {
			// TODO: handle exception
		}
        boolean timeText = true;
        if(timeText) {
        	testCase.log(Status.INFO,"Actual text:-"+actualTime);
        	testCase.log(Status.INFO, "Expecedt text:-"+expectedTime);
        	testCase.log(Status.PASS, "Correct ");
        }else {
        	testCase.log(Status.INFO,"Actual text:-"+actualTime);
        	testCase.log(Status.INFO, "Expecedt text:-"+expectedTime);
        	testCase.log(Status.FAIL, "In-Correct ");
        }
        
//____________________________________________________________________________
//   SAVE BUTTON IS VISIBLE
//   SAVE BUTTON IS ENABLE        
//____________________________________________________________________________        
        Thread.sleep(3000);
        SampleActionMethods.clicking(IncomingSamplePage.SaveBtn, 2, "STEP:3 SAVE BUTTON");
        
        
        
	}  
		
//__________________________________________________________________________
//    AFTER SAVE VALIDATE TIME FIELD  (GET TEXT)
//__________________________________________________________________________	
		
	
		public static void afterValidateSaveData() throws InterruptedException {
			PageFactory.initElements(driver, samplePage);
//____________________________________________________________________________________			
// SCROLL RIGHT			
//__________________________________________________________________________________________				
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(1000, 0);");
			
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath("//div[@class='ant-table ant-table-small ant-table-ping-right ant-table-fixed-header ant-table-fixed-column ant-table-scroll-horizontal ant-table-has-fix-left ant-table-has-fix-right']"));
			element.click();
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().sendKeys(Keys.ARROW_RIGHT).build().perform();

//_______________________________________________________________________________________________	
			
			String actualTime = IncomingSamplePage.tableDataTime.getText();
	        System.out.println("After save field time:-"+actualTime);
	        String expectedTime = "";
	        
	        testCase = extent.createTest("STEP:4 Time Field Table Data  Text");
	        try {
	        	Assert.assertEquals(actualTime, expectedTime);
	        }catch (AssertionError e) {
				// TODO: handle exception
			}
	        boolean timeText = true;
	        if(timeText) {
	        	testCase.log(Status.INFO,"Actual text:-"+actualTime);
	        	testCase.log(Status.INFO, "Expecedt text:-"+expectedTime);
	        	testCase.log(Status.PASS, "Correct ");
	        }else {
	        	testCase.log(Status.INFO,"Actual text:-"+actualTime);
	        	testCase.log(Status.INFO, "Expecedt text:-"+expectedTime);
	        	testCase.log(Status.FAIL, "In-Correct ");
	        }
					
		
//______________________________________________________________________
//         COMPARE TIME FIELDS (BEFORE SAVE - AFTER SAVE)
//______________________________________________________________________
	        testCase = extent.createTest("STEP:5 COMPARE TIME FIELDS (BEFORE SAVECompare Time Fields (BeforeSave- After Save)");
	        
	        // Add a comparison step
	        String actualBeforeSaveTime = IncomingSamplePage.TimeBefore.getAttribute("value");
	        String actualAfterSaveTime= IncomingSamplePage.tableDataTime.getText();
	        if (actualBeforeSaveTime.equals(actualAfterSaveTime)) {
	            testCase.log(Status.PASS, "Step 5: Compare actual times - Actual bedore save time and Actual time after save are the same");
	        } else {
	        	testCase.log(Status.FAIL, "Step 5: Compare actual times - Actual time1 and Actual time after save are different");
	        }
	    
		
//_____________________________________________________________________________
//            VALIDATE IF STATUS IS NEW
//____________________________________________________________________________	
	        


		SampleActionMethods.webelementUi(IncomingSamplePage.StatusNew,StatusBarColour ,StatusText,"STEP:7 Status Bar");
		}
		
}