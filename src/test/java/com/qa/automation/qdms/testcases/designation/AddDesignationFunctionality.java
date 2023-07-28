/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Add Designation Functionality (Designation add Functionality)
**********************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (2) 	  	 	  TC-DES-0027      	      06/03/2023       Gobithan			Original Version
*				   		 				  03/07/2023       Jathu Jana       Modified version (Rework)
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

public class AddDesignationFunctionality extends DriverIntialization{
	
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
	public static String SuccesAlert = null;
	
	@Test
	public static void function() throws InterruptedException, IOException {
		
//		1.DIRECTLY NAVIGATE TO DESIGNATION PAGE
		DesignationPageMethods.designationPageNavigation();
		
//		2.CHECKING FUNCTIONALITY MAIN METHOD
		CheckingAddDesignationFunctionality("Master Module","Designation","TC-DES-0027");
		
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
		functionality.compareData("➢ Checking Add Designation Success Message ", DesignationPage.desiSuccessMessage, SuccesAlert);
		
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

	
	/******************************************************************************************************************************************
	 * @category THE METHOD FOR ADD DESIGNATION VALIDATION & PRINT REPORT IF NOT SAVED
	 * @throws InterruptedException
	 ******************************************************************************************************************************************/
	public static void validationThrow() {
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, dp);

//		GET VALIDATION & PRINT REPORT
		testCase = extent.createTest("➢ Check Designation Added Status");
		testCase.log(Status.INFO, "This Designation Unable To Add The Table.");
		try {
			
			testCase.log(Status.INFO, "Add Designation Validation Message Shows : "+DesignationPage.desiDesignationValidation.getText());
			testCase.log(Status.PASS, "TEST PASS ☑");

		} catch (Exception e) {
			
			testCase.log(Status.INFO, "Something Wrong. Unable to get Validation Message");
			testCase.log(Status.FAIL, "TEST FAIL ❌");

		}
		
//  	AFTER GET VALIDATION - STATUS
		validationStatus  = true;
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
			
//			IF DESIGNATION NOT SAVE
			validationThrow();
			
			if (validationStatus) {
				
				validationStatus = false ;
				
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
	 * @category MAIN METHOD FOR ADD DESIGNATION FUNCTIONALITY
	 * @param excelbook
	 * @param tabName
	 * @param testId
	 *******************************************************************************************************************************************/
	public static void CheckingAddDesignationFunctionality(String excelbook , String tabName, String testId){
		
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
            	
    			testCase = extent.createTest("➥ TEST : ADD DESIGNATION FUNCTIONALITY ");

//            	DESIGNATION DATA
            	designationData = dataValue.formatCellValue(row.getCell(1));
            	
//            	DESCRIPTION DATA
            	descriptionData = dataValue.formatCellValue(row.getCell(2));
            	
//            	SUCCESS ALERT DATA
            	SuccesAlert = dataValue.formatCellValue(row.getCell(3));
            	
            	
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
