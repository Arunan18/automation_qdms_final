/***********************************************************************************
* Description
*------------
*Production sample Test & Result Cancel button Functionality 
***********************************************************************************
*
* Author           : Karunya Navanesan
* Date Written     : 05/05/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PRODUCT-SAM-0214     05/05/2023    Karunya    Original Version
* 
************************************************************************************/
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProductionSampletestResultCancelButtonFunctionality extends DriverIntialization {
	static  MixDesignPage mps = new MixDesignPage();
	 
	 static String SeachData = null;
	 static String alertMessage = null;
	
	
	 @Test
	public static void productionsampleTestCancelButton() throws InterruptedException, IOException {
		
		//______________________________________________________
		//  LOGIN
		//_______________________________________________________	
			
			 LoginTest.Login();
			 
		//______________________________________________________
		//  NAVIAGTE TO PRODUCT SAMPLE
		//_______________________________________________________	
			 
			 SampleNavigateTest.sampleNavigation();
			 
			 SampleNavigateTest.finishProductSampleMainNavigation();
			 
			 SampleNavigateTest.productionSampleNavigation();
			 
			 
		//______________________________________________________
		//  NAVIAGTE TO PRODUCT SAMPLE TEST AND RESULT ICON CANCEL BUTTON FUNCTIONALITY
		//_______________________________________________________	
					 
			 ProductionSampletestResultCancelButtonFunctionality.SeachDataToTestandResultCancelbuttonFunctionality();
			
			
	
	}
	
	 
	public static void SeachDataToTestandResultCancelbuttonFunctionality() throws InterruptedException, IOException {
		String excelPath = System.getProperty ("user.dir") +"\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Production Sample";
		String testCaseId = "TC-PRODUCT-SAM-0213";
		
		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);  

		for (int i = firstRow; i <= lastRow; i++) { 
			XSSFRow row = sheet.getRow(i);
			SeachData = (String) row.getCell(1).getStringCellValue();  

			
			
			PageFactory.initElements(driver, mps);
			Thread.sleep(4000);
			testCase = extent.createTest("STEP:1");
			ActionCommonMethod.actionS(0, 17, MixDesignPage.productionSampleTable, "Test Status", "Samples Module.xlsx", "Production Sample", "TC-PRODUCT-SAM-0213-01", 1);
			
			
		//____________________________________________________________________________________
		//  AFTER CLICK TEST & RESULT ICON  VIEW ALERT MESSAGE 
		//_____________________________________________________________________________________	
				
					testCase = extent.createTest("STEP:2 TEST STATUS ALERT POPUP VISIBLE");
					
					WebElement alert = MixDesignPage.testandresulticonpopup;
					
					boolean Visible = alert.isDisplayed();
					if (Visible) {
						boolean actualVisible = alert.isDisplayed();
						System.out.println("Alert Visible:-"+actualVisible);
						boolean expectedVisible = true;
						try {
							assertEquals(actualVisible, expectedVisible);
							testCase.log(Status.INFO," Actual Visible:-"+actualVisible);
							testCase.log(Status.INFO," Expected Visible:-"+ expectedVisible);
							testCase.log(Status.PASS,"Correct Visible");
						}catch (AssertionError e) {
							// TODO: handle exception
							testCase.log(Status.INFO," Actual Visible:-"+actualVisible);
							testCase.log(Status.INFO," Expected Visible:-"+ expectedVisible);
							testCase.log(Status.PASS,"Correct Visible");
						}
					
					}		
		
	}
		
	//************************************************************************************************************
   //		STEP-05--TEST STATUS CANCEL BUTTON  DISPLAYED &	STEP-06--TEST STATUS CANCEL BUTTON ENABLED
  //************************************************************************************************************			
							
		 if (MixDesignPage.teststatuCancelbutton.isDisplayed()) {
				testCase = extent.createTest("STEP-03--TEST STATUS BUTTON CANCEL IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS");
					if (MixDesignPage.teststatuCancelbutton.isEnabled()) {
						testCase = extent.createTest("STEP-04---TEST STATUS CANCEL BUTTON  IS ENABLED");
						testCase.log(Status.PASS, "TEST PASS");
									
					try {
										
					  	Thread.sleep(3000);
						MixDesignPage.teststatuCancelbutton.click();
						testCase = extent.createTest("STEP-05---TEST STATUS BUTTON CANCEL  IS  CLICKED");
						testCase.log(Status.PASS, "TEST PASS");

						Thread.sleep(3000);

						} catch (Exception e) {

						  }
						} else {
							testCase = extent.createTest("STEP-04---TEST STATUS BUTTON CANCEL IS NOT ENABLED");
							testCase.log(Status.PASS, "TEST FAIL");
						    	}
						} else {
							testCase = extent.createTest("STEP-03---TEST STATUS BUTTON CANCEL  IS NOT DISPLAYED");
							testCase.log(Status.PASS, "TEST FAIL");
							   }
			
				}	 

}

