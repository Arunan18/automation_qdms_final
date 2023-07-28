/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Add Material State Validation
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (11) 	    TC-MATSTA-0026      	  27/02/2023       Niluxy			Original Version
*				   		 				  19/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.materialstate;

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
import com.qa.automation.qdms.pages.master.MaterialStatePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class AddMaterialStateValidation extends DriverIntialization {
	
//	PAGE OBJECT MODEL FOR MATERIAL STATE PAGE
	public static MaterialStatePage msp = new MaterialStatePage();
	
//	ADD MATERIAL STATE SAVE STATUS DECLARE
	public static boolean notSave = false;
	
//	AFTER FILL FORM STATUS DECLARE
	public static boolean fillForm = false;

//	IF ALREADY MATERIAL STATE ADDED VALIDATION STATUS DECLARE
	public static boolean validationStatus = false;

//	IF SUCCESSFULLY ADDED - ALERT STATUS DECLARE  
	public static boolean dataAddedSuccessAlertStatus;
	
//	EXCEL DATAS
	public static String StateData = null;
	public static String SuccessAlert = null;
	
	@Test
	public static void validation() throws InterruptedException, IOException {
		
//		1.DIRECTLY NAVIGATE TO MATERIAL STATE PAGE
		MaterialStatePageMethods.materialStatePageNavigation();
		
//		2.CHECKING FUNCTIONALITY MAIN METHOD
		CheckingAddMaterialStateValidation("Master Module","Material State","TC-MATSTA-0026");
		
//		3.REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		if (LoginTest.login) {
			
			LoginTest.login = false;
			
//	    	4.LOGOUT
			Logout.LogoutFunction();
	        
		}
	}
	
	
	/******************************************************************************************************************************************
	 * @category  METHOD FOR FILL MATERIAL STATE (WITH THAT TEXTBOX FUNCTIPONALITY CHECKING)
	 * @throws InterruptedException 
	 ******************************************************************************************************************************************/
	public static void fillAddMaterialStateDetails() throws InterruptedException {
							
//		POM INITIALIZATION
		PageFactory.initElements(driver, msp);

//		FILL THE MATERIAL STATE TEXTBOX
		functionality.funtionCheckAndSendKeys("➢ Checking Function And Fill Material State TextBox :",MaterialStatePage.materialStateTextBox ,
				"Materilal State TextBox",StateData );
		
//  	AFTER FILL FORM - STATUS
		fillForm = true;
	}
	

	/******************************************************************************************************************************************
	 * @category THE METHOD FOR CHECKING ADD MATERIAL STATE SUCCESS ALERT
	 * @throws InterruptedException
	 ******************************************************************************************************************************************/
	public static void addMaterialStateSuccessAlert() throws InterruptedException {
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, msp);
		
//		GET ALERT MESSAGE
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//		CHECKING SUCCESS ALERT DATA
		functionality.compareData("➢ Checking Add Material State Success Message ", MaterialStatePage.matStateSuccessMessage, SuccessAlert);
		
//  	AFTER GET SUCCESS MESSAGE - STATUS
		dataAddedSuccessAlertStatus  = true;

	}
	
	
	/******************************************************************************************************************************************
	 * @category THE METHOD FOR CHECKING ADDED MATERIAL STATE TABLE DATA AFTER SAVED
	 * @throws InterruptedException
	 ******************************************************************************************************************************************/
	public static void addMaterialStateTableDataStatus() throws InterruptedException {
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, msp);
		
//		CHECK DATA ADDED IN FIRST ROW
		functionality.compareData("➢ Checking Material State Added In The Table ", MaterialStatePage.firstTableData,StateData);
	
	}
	
	
	/*****************************************************************************************************************************************
	 * @category CHECKING ADDED MATERIAL STATE STATUS AFTER SAVED
	 * @throws InterruptedException 
	 ****************************************************************************************************************************************/
	public static void afterSave() throws InterruptedException {
		
//		SUCCESSFULL MESSAGE ALERT
		addMaterialStateSuccessAlert();
		
		if (dataAddedSuccessAlertStatus) {
			
			dataAddedSuccessAlertStatus = false;
			
//			CHECKING ADDED MATERIAL STATE STATUS
			addMaterialStateTableDataStatus();
			
		}
					
	}

	
	/*******************************************************************************************************************************************
	 * @category METHOD FOR AFTER CLICK SAVE BUTTON ADDED MATERIAL STATE FUNCTIONALITY 
	 * @throws InterruptedException 
	 *******************************************************************************************************************************************/
	public static void afterClickSave() throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, msp);

		try {
			
//			ADD MATERIAL STATE POPUP VISIBLE CHECKING
			notSave = MaterialStatePage.popUpModel.isDisplayed();
					
		} catch (Exception e) {
			
			notSave = false;
			
		}
	
		if (notSave) {
			
//			VALIDATION CHECKING BY COMMON METHOD  			
			materialMethodes.validationconfirm("", "","➢ Add Material State Validation");
			
			if (materialMethodes.validCorfirm) {
				
				materialMethodes.validCorfirm = false ;
				
//				REFRESH
				driver.navigate().refresh();
				Thread.sleep(1000);	

			}
							
		}else {
			
//			IF MATERIAL STATE SAVED
			afterSave();
			
		}
				
	}
	
	
	/*******************************************************************************************************************************************
	 * @category MAIN METHOD FOR ADD MATERIAL STATE VALIDATION
	 * @param excelbook
	 * @param tabName
	 * @param testId
	 *******************************************************************************************************************************************/
	public static void CheckingAddMaterialStateValidation(String excelbook , String tabName, String testId){
		
		try {
			
//        	GET DATA FROM EXCEL SHEET

			DataFormatter dataValue = new DataFormatter();
			String Filelocation = "./src/test/resources/Excel/"+excelbook+".xlsx"; 
            FileInputStream file = new FileInputStream(Filelocation);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(tabName);
            
			int firstrow = CommonMethods.getFirstRowNum(Filelocation, tabName, testId);
            int lastrow = CommonMethods.getLastRowNum(Filelocation, tabName, testId);
 
            for (int j = firstrow; j <= lastrow; j++) {
            	
            	XSSFRow row = sheet.getRow(j);
            	
    			testCase = extent.createTest("➥ TEST : ADD MATERIAL STATE VALIDATION ");

//            	MATERIAL STATE DATA
    			StateData = dataValue.formatCellValue(row.getCell(1));
            	
//            	SUCCESS ALERT DATA
    			SuccessAlert = dataValue.formatCellValue(row.getCell(2));
            	       	
//            	CLICK ADD MATERIAL STATE BUTTON
            	MaterialStatePageMethods.addMaterialStateButtonClick();        	

        		if (MaterialStatePageMethods.clickAddMatState) {        			
        			MaterialStatePageMethods.clickAddMatState = false;
        			
//        			2.FILL ADD MATERIAL STATE DETAILS
        			fillAddMaterialStateDetails();
        			
        			if(fillForm) {        				
        				fillForm = false;
        				
//        				3.SAVE MATERIAL STATE
        				MaterialStatePageMethods.popUpModelSecondButtonFunctionAndClick("➢ Checking Add Designation Save Button Functionality");
        		
        				if (MaterialStatePageMethods.clickPopUpModelSecondButton) {       					
        					MaterialStatePageMethods.clickPopUpModelSecondButton = false;
        					
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
