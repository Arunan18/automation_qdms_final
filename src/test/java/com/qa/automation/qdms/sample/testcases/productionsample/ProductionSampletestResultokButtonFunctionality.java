/***********************************************************************************
* Description
*------------
*Production sample Test & Result Ok button Functionality 
***********************************************************************************
*
* Author           : Karunya Navanesan
* Date Written     : 05/05/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PRODUCT-SAM-0213     05/05/2023    Karunya    Original Version
* 
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.productionsample;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.sample.testcases.incommingsample.IncomingSmapleMoreOption;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProductionSampletestResultokButtonFunctionality extends DriverIntialization {
	
	 static  ProductionSamplePage mps = new ProductionSamplePage();
	 
	 static String SeachData = null;
	 static String alertMessage = null;
	
	
// ********************************************************************************************************
//	 THE METHOD IS FOR GENERATING REPORT 
//********************************************************************************************************		
	public static void TestCasePrint(String TestCaseName, String expectedValue, String actualValue) {
		boolean position = true;
		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			position = false;
		}
		if (position) {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "Expectedvalue :- " + expectedValue);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, actualValue);
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "ExpectedValue :- " + expectedValue);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, actualValue);
		}

	}
	

    
	
	@Test
	 public static void productionsampleTestOkButton() throws InterruptedException, IOException {
		 
		
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
	//  NAVIAGTE TO PRODUCT SAMPLE TEST AND RESULT ICON OK BUTTON FUNCTIONALITY
	//_______________________________________________________	
				 
		 
		 ProductionSampletestResultokButtonFunctionality.SeachDataToTestandResultOkbuttonFunctionality();
		
		 
	}
	
	public static void SeachDataToTestandResultOkbuttonFunctionality() throws InterruptedException, IOException {
		
	 	
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
			ActionCommonMethod.actionS(0, 17, ProductionSamplePage.productionsampletable, "Test Status", "Samples Module.xlsx", "Production Sample", "TC-PRODUCT-SAM-0213-01", 1);
			
			
		
	//____________________________________________________________________________________
	//  AFTER CLICK TEST & RESULT ICON  VIEW ALERT MESSAGE 
	//_____________________________________________________________________________________	
		
			testCase = extent.createTest("STEP:2 TEST STATUS ALERT POPUP VISIBLE");
			
			WebElement alert = ProductionSamplePage.testandresulticonpopup;
			
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
		
			
		
			 
	//************************************************************************************************************
   //		STEP-05--TEST STATUS OK BUTTON DISPLAYED &	STEP-06--TEST STATUS BUTTON ENABLED
  //************************************************************************************************************			
					
		 if (ProductionSamplePage.teststatusOkbutton.isDisplayed()) {
					testCase = extent.createTest("STEP-03--TEST STATUS OK BUTTON IS DISPLAYED");
					testCase.log(Status.PASS, "TEST PASS");
					 if (ProductionSamplePage.teststatusOkbutton.isEnabled()) {
							testCase = extent.createTest("STEP-04---TEST STATUS OK BUTTON  IS ENABLED");
							testCase.log(Status.PASS, "TEST PASS");
							
							try {
								
								Thread.sleep(3000);
								ProductionSamplePage.teststatusOkbutton.click();
								testCase = extent.createTest("STEP-05---TEST STATUS OK BUTTON  IS  CLICKED");
								testCase.log(Status.PASS, "TEST PASS");

								Thread.sleep(3000);

								} catch (Exception e) {
									testCase = extent.createTest("STEP-05---TEST STATUS OK BUTTON  IS NOT  CLICKED");
									testCase.log(Status.PASS, "TEST FAIL");

								}
							} else {
								testCase = extent.createTest("STEP-04---TEST STATUS OK BUTTON  IS NOT ENABLED");
								testCase.log(Status.PASS, "TEST FAIL");
							}
						} else {
							testCase = extent.createTest("STEP-03---TEST STATUS OK BUTTON  IS NOT DISPLAYED");
							testCase.log(Status.PASS, "TEST FAIL");
						}
	
		}	 

}
}
