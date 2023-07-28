/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Add Designation Validation 
**********************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (11) 	  	  TC-DES-0003      	      	  -              Volta		    Original Version
*				   		 				  19/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.designation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.DesignationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class AddDesignationValidation extends DriverIntialization {
	
//	PAGE OBJECT MODEL FOR DESIGNATION PAGE
	public static DesignationPage dp = new DesignationPage();
	
//	ADD DESIGNATION SAVE STATUS DECLARE
	public static boolean notSave = false;
	
//	AFTER FILL FORM STATUS DECLARE
	public static boolean fillForm = false;

//	IF ALREADY DESIGNATION ADDED VALIDATION STATUS DECLARE
	public static boolean validationStatus = false;

//	IF SUCCESSFULLY ADDED - ALERT STATUS DECLARE  
	public static boolean dataAddedSuccessAlertStatus;
	
//	EXCEL DATAS
	public static String designationData = null;
	public static String descriptionData = null;
	public static String SuccessAlert = null;
	
	@Test
	public static void validation() throws InterruptedException, IOException {
		
//		1.DIRECTLY NAVIGATE TO DESIGNATION PAGE
		DesignationPageMethods.designationPageNavigation();
		
//		2.CHECKING FUNCTIONALITY MAIN METHOD
		CheckingAddDesignationValidation("Master Module","Designation","TC-DES-0003");
		
//		3.REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		if (LoginTest.login) {
			
			LoginTest.login = false;
			
//	     	4.LOGOUT
			Logout.LogoutFunction();
	        
		}
	}
	
	
	/******************************************************************************************************************************************
	 * @category  METHOD FOR FILL DESIGNATION AND DESCRIPTION (WITH THOSE TEXTBOX FUNCTIPONALITY CHECKING)
	 * @throws InterruptedException 
	 ******************************************************************************************************************************************/
	public static void fillAddDesignationDetails() throws InterruptedException {
							
//		POM INITIALIZATION
		PageFactory.initElements(driver, dp);

//		FILL THE DESIGNATION TEXTBOX
		functionality.funtionCheckAndSendKeys("➢ Checking Function And Fill Designation TextBox :",DesignationPage.desiDesignationTextBox ,
				"Designation TextBox",designationData );
		
//		FILL THE DESCRIPTION TEXTBOX
		try {
			
			functionality.funtionCheckAndSendKeys("➢ Checking Function And Fill Description TextBox ",DesignationPage.desiDescriptionTextBox , 
					"Description TextBox",descriptionData );
			
		} catch (Exception e) {
			
			testCase = extent.createTest("➢ Checking Function And Fill Description TextBox ");
			testCase.log(Status.INFO, "Description Empty ");
			testCase.log(Status.PASS, "TEST PASS ☑");
		}
		
//  	AFTER FILL FORM - STATUS
		fillForm = true;
	}
	

	/******************************************************************************************************************************************
	 * @category THE METHOD FOR CHECKING ADD DESIGNATION SUCCESS ALERT
	 * @throws InterruptedException
	 ******************************************************************************************************************************************/
	public static void addDesiSuccessAlert() throws InterruptedException {
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, dp);
		
//		GET ALERT MESSAGE
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//		CHECKING SUCCESS ALERT DATA
		functionality.compareData("➢ Checking Add Designation Success Message ", DesignationPage.desiSuccessMessage, SuccessAlert);
		
//  	AFTER GET SUCCESS MESSAGE - STATUS
		dataAddedSuccessAlertStatus  = true;

	}
	
	
	/******************************************************************************************************************************************
	 * @category THE METHOD FOR CHECKING ADDED DESIGNATION TABLE DATA AFTER SAVED
	 * @throws InterruptedException
	 ******************************************************************************************************************************************/
	public static void addDesiTableDataStatus() throws InterruptedException {
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, dp);
		
//		CHECK DATA ADDED IN FIRST ROW
		functionality.compareData("➢ Checking Designation Added In The table ", DesignationPage.firstTableData,designationData);
	
	}
	
	
	/*****************************************************************************************************************************************
	 * @category CHECKING ADDED DESIGNATION STATUS AFTER SAVED
	 * @throws InterruptedException 
	 ****************************************************************************************************************************************/
	public static void afterSave() throws InterruptedException {
		
//		SUCCESSFULL MESSAGE ALERT
		addDesiSuccessAlert();
		
		if (dataAddedSuccessAlertStatus) {
			
			dataAddedSuccessAlertStatus = false;
			
//			CHECKING ADDED DESIGNATION STATUS
			addDesiTableDataStatus();
			
		}
					
	}
	
	/*******************************************************************************************************************************************
	 * @category METHOD FOR AFTER CLICK SAVE BUTTON ADDED DESIGNATION FUNCTIONALITY 
	 * @throws InterruptedException 
	 *******************************************************************************************************************************************/
	public static void afterClickSave() throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, dp);

		try {
			
//			ADD DESIGNATION POPUP VISIBLE CHECKING
			notSave = DesignationPage.popUpModel.isDisplayed();
					
		} catch (Exception e) {
			
			notSave = false;
			
		}
	
		if (notSave) {
	
//			VALIDATION CHECKING BY COMMON METHOD 
			materialMethodes.validationconfirm("", "","➢ Add Designation Validation");

			if (materialMethodes.validCorfirm) {
				
				materialMethodes.validCorfirm = false ;
				
//				REFRESH
				driver.navigate().refresh();
				Thread.sleep(1000);	

			}
							
		}else {
			
//			IF DESIGNATION SAVED
			afterSave();
			
		}
				
	}
	
	
	/*******************************************************************************************************************************************
	 * @category MAIN METHOD FOR ADD DESIGNATION VALIDATION
	 * @param excelbook
	 * @param tabName
	 * @param testId
	 *******************************************************************************************************************************************/
	public static void CheckingAddDesignationValidation(String excelbook , String tabName, String testId){
		
		try {
			
//        	GET DATA FROM EXCEL SHEET

			DataFormatter dataValue = new DataFormatter();
			String Filelocation = "./src/test/resources/Excel/"+excelbook+".xlsx"; 
            FileInputStream file = new FileInputStream(Filelocation);
			int firstrow = CommonMethods.getFirstRowNum(Filelocation, tabName, testId);
            int lastrow = CommonMethods.getLastRowNum(Filelocation, tabName, testId);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(tabName);
            
            for (int j = firstrow; j <= lastrow; j++) {
            	
            	XSSFRow row = sheet.getRow(j);
            	
    			testCase = extent.createTest("➥ TEST : ADD DESIGNATION VALIDATION ");

//            	DESIGNATION DATA
            	designationData = dataValue.formatCellValue(row.getCell(1));
            	
//            	DESIGNATION DATA
            	descriptionData = dataValue.formatCellValue(row.getCell(2));
            	
//            	SUCCESS ALERT DATA
            	SuccessAlert = dataValue.formatCellValue(row.getCell(3));
            	
            	
//            	CLICK ADD DESIGNATION BUTTON
            	DesignationPageMethods.addDesignationButtonClick();        	

        		if (DesignationPageMethods.clickAddDesignation) {
        			
        			DesignationPageMethods.clickAddDesignation = false;
        			
//        			2.FILL ADD DESIGNATION DETAILS
        			fillAddDesignationDetails();
        			
        			if(fillForm) {
        				
        				fillForm = false;
        				
//        				3.SAVE DESIGNATION
        				DesignationPageMethods.popUpModelSecondButtonFunctionAndClick("➢ Checking Add Designation Save Button Functionality");
        		
        				if (DesignationPageMethods.clickPopUpModelSecondButton) {
        					
        					DesignationPageMethods.clickPopUpModelSecondButton = false;
        					
//        					4.CHECK METHOD
        					afterClickSave();	   	
        					
        				}
        			}
        		}   
            } 
		}catch (Exception e) {
    	   
			testCase = extent.createTest("➢ Data Identification 🛑");
			testCase.log(Status.INFO, "Unable to get Data. Have to Check Excel File!");
			testCase.log(Status.FAIL, "TEST FAIL ❌");

		}
		
	}
	
}
