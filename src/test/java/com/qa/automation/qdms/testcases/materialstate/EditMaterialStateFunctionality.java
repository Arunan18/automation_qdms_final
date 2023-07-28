/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Edit Material State Functionality (Material State Edit Functionality)
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (12) 	  	 TC-MATSTA-0036      	  04/03/2023        Niluxy			Original Version
*				   		 				  20/07/2023       Jathu Jana       Modified version (Rework)
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
import com.qa.automation.qdms.commonmethods.DataFromExcelByAnyColumn;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.DesignationPage;
import com.qa.automation.qdms.pages.master.MaterialStatePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class EditMaterialStateFunctionality extends DriverIntialization {
	
//	PAGE OBJECT MODEL FOR MATERIAL STATE PAGE
	public static MaterialStatePage msp = new MaterialStatePage();
	
//	EDIT MATERIAL STATE UPDATE STATUS DECLARE
	public static boolean notUpdate = false;
	
//	AFTER FILL FORM STATUS DECLARE
	public static boolean fillForm = false;

//	IF ALREADY MATERIAL STATE UPDATED VALIDATION STATUS DECLARE
	public static boolean validationStatus = false;

//	IF SUCCESSFULLY UPDATED - ALERT STATUS DECLARE  
	public static boolean dataUpdatedSuccessAlertStatus;
	
//	EXCEL DATAS
	public static String editStateData = null;
	public static String cursorTypeBeforeEdit = null;
	public static String newStateData = null;
	public static String cursorTypeAfterEdit  = null;
	public static String SuccessAlert = null;

	@Test
	public static void function() throws InterruptedException, IOException {
		
//		1.DIRECTLY NAVIGATE TO MATERIAL STATE PAGE
		MaterialStatePageMethods.materialStatePageNavigation();
		
		if (MasterMainNavigationsTest.clickMaterialState) {
			MasterMainNavigationsTest.clickMaterialState = false;
			
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			CheckingEditDesignationFunctionality("Master Module", "Material State", "TC-MATSTA-0036");
		
		}
		
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
	 * @category  METHOD FOR EDIT MATERIAL STATE (WITH THAT TEXTBOX FUNCTIONALITY CHECKING)
	 * @throws InterruptedException 
	 ******************************************************************************************************************************************/
	public static void EditMaterialStateDetails() throws InterruptedException {
							
//		POM INITIALIZATION
		PageFactory.initElements(driver, msp);
		
//	 	EDIT MATERIAL STATE POPUP - MATERIAL STATE TEXTBOX DATA COMPARE
		functionality.compareData("➢ Checking Edit Material State Data ", MaterialStatePage.materialStateTextBox.getAttribute("value"),editStateData);
		
		if (functionality.compareData) {
			functionality.compareData = false ;
			
//			EDIT MATERIAL STATE POPUP UPDATE BUTTON FUNCTION
			functionality.ButtonAndIconFunctionalityPassInable("➢ Checking Edit Material State Update Button Functionality ",
					MaterialStatePage.popUpModelSecondButton, "Button");
			
		}
		
		if (functionality.Inablity) {
			functionality.Inablity = false;
			
//			EDIT MATERIAL STATE POPUP UPDATE BUTTON CURSOR
			functionality.getOnePropertyAndCompare("➢ Checking Edit Material State Update Button Cursor Before Editing ",
					MaterialStatePage.popUpModelSecondButton, "cursor", cursorTypeBeforeEdit);
		
		}
		
		if (functionality.compareData) {
			functionality.compareData = false ;
			
			if (!editStateData.equals(newStateData)) {
				
//				EDIT THE MATERIAL STATE TEXTBOX
				functionality.funtionCheckAndSendKeys("➢ Checking Function And Fill Material State TextBox :",
						MaterialStatePage.materialStateTextBox, "Material State TextBox", newStateData);
			
				if (functionality.searching) {
					functionality.searching = false;
					
//					EDIT MATERIAL STATE POPUP UPDATE BUTTON CURSOR
					functionality.getOnePropertyAndCompare("➢ Checking Edit Material State Update Button Cursor After Editing ",
							MaterialStatePage.popUpModelSecondButton, "cursor", cursorTypeAfterEdit);

//					AFTER FILL FORM - STATUS
					fillForm = true;

				}
				
			}else {
				
				functionality.printFailStatus("➢ Checking Edit Material State Details", "Human Error. Edit Data and New Data Same. So, You Have to Change The Data");
				fillForm = false;
				
			}
			
		}
		
	}
	

	/******************************************************************************************************************************************
	 * @category THE METHOD FOR CHECKING UPDATE MATERIAL STATE SUCCESS ALERT
	 * @throws InterruptedException
	 ******************************************************************************************************************************************/
	public static void updateMaterialStateSuccessAlert() throws InterruptedException {
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, msp);
		
//		WEB DRIVER WAIT 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//		CHECKING SUCCESS ALERT DATA
		functionality.compareData("➢ Checking Updated Material State Success Message ", MaterialStatePage.matStateSuccessMessage, SuccessAlert);
		
//  	AFTER GET SUCCESS MESSAGE - STATUS
		dataUpdatedSuccessAlertStatus  = true;

	}
	
	
	/******************************************************************************************************************************************
	 * @category THE METHOD FOR CHECKING UPDATED MATERIAL STATE TABLE DATA AFTER EDITED
	 * @throws InterruptedException
	 ******************************************************************************************************************************************/
	public static void updateMaterialStateTableDataStatus() throws InterruptedException {
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, msp);
		
//		GO FIRST PAGE
		driver.navigate().refresh();
		Thread.sleep(500);
		
//		CHECK UPDATED IN FIRST ROW
		functionality.compareData("➢ Checking Material State Updated In The Table ", MaterialStatePage.firstTableData,newStateData);
	
	}
	
	
	/*****************************************************************************************************************************************
	 * @category CHECKING EDITED MATERIAL STATE STATUS AFTER UPDATED
	 * @throws InterruptedException 
	 ****************************************************************************************************************************************/
	public static void afterUpdate() throws InterruptedException {
		
//		UPDATED SUCCESSFULL MESSAGE ALERT
		updateMaterialStateSuccessAlert();
		
		if (dataUpdatedSuccessAlertStatus) {
			
			dataUpdatedSuccessAlertStatus = false;
			
//			CHECKING UPDATED MATERIAL STATE STATUS
			updateMaterialStateTableDataStatus();
			
		}
					
	}

	
	/******************************************************************************************************************************************
	 * @category THE METHOD FOR UPADTE MATERIAL STATE VALIDATION & PRINT REPORT IF NOT UPDATED
	 * @throws InterruptedException
	 ******************************************************************************************************************************************/
	public static void validationThrow() {
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, msp);

//		GET VALIDATION & PRINT REPORT
		testCase = extent.createTest("➢ Check Designation Status If Not Updated");
		testCase.log(Status.INFO, "Unable to Update...Validation Message Throw!!!");
		try {
			
			testCase.log(Status.INFO, "Edit Designation Validation Message Shows : "+DesignationPage.desiDesignationValidation.getText());
			testCase.log(Status.PASS, "TEST PASS ☑");

		} catch (Exception e) {
			
			testCase.log(Status.INFO, "Something Wrong. Unable to get Validation Message");
			testCase.log(Status.FAIL, "TEST FAIL ❌");

		}

//  	AFTER GET VALIDATION - STATUS
		validationStatus  = true;
		
	}
	
	
	/*******************************************************************************************************************************************
	 * @category METHOD FOR AFTER CLICK UPDATE BUTTON EDITED MATERIAL STATE FUNCTIONALITY 
	 * @throws InterruptedException 
	 *******************************************************************************************************************************************/
	public static void afterClickUpdate() throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, msp);

		try {
			
//			EDITED MATERIAL STATE POPUP VISIBLE CHECKING
			notUpdate = MaterialStatePage.popUpModel.isDisplayed();
					
		} catch (Exception e) {
			
			notUpdate = false;
			
		}
	
		if (notUpdate) {
			
//			IF EDITED MATERIAL STATE NOT UPDATED
			validationThrow();
			
			if (validationStatus) {
				
				validationStatus = false ;
				
//				REFRESH
				driver.navigate().refresh();
				Thread.sleep(1000);	

			}
							
		}else {
			
//			IF EDITED MATERIAL STATE UPDATED
			afterUpdate();
			
		}
				
	}
	
	
	/*******************************************************************************************************************************************
	 * @category MAIN METHOD FOR EDIT MATERIAL STATE FUNCTIONALITY
	 * @param excelbook
	 * @param tabName
	 * @param testId
	 *******************************************************************************************************************************************/
	public static void CheckingEditDesignationFunctionality(String excelbook , String tabName, String testId){
		
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
            	
    			testCase = extent.createTest("➥ TEST : EDIT MATERIAL STATE FUNCTIONALITY ");

//            	MATERIAL STATE DATA
    			editStateData = dataValue.formatCellValue(row.getCell(1));
            	
//    			CURSOR TYPE DATA BEFORE EDIT
    			cursorTypeBeforeEdit = dataValue.formatCellValue(row.getCell(2));
            	
//            	NEW STATE DATA
    			newStateData = dataValue.formatCellValue(row.getCell(3));
            	
//            	CURSOR TYPE DATA AFTER EDIT
    			cursorTypeAfterEdit = dataValue.formatCellValue(row.getCell(4));
            
//            	SUCCESS ALERT DATA
    			SuccessAlert = dataValue.formatCellValue(row.getCell(5));
            	       	
//            	CLICK EDIT MATERIAL STATE BUTTON
            	DataFromExcelByAnyColumn.clickTheSearchIcon(editStateData, 1,1, "edit");

        		if (DataFromExcelByAnyColumn.status) {
        			DataFromExcelByAnyColumn.status = false;
        			
//        			2.FILL EDIT MATERIAL STATE DETAILS
        			EditMaterialStateDetails();
        			
        			if(fillForm) {
        				fillForm = false;
        				
//        				3.UPDATE MATERIAL STATE
        				MaterialStatePageMethods.popUpModelSecondButtonFunctionAndClick("➢ Checking Edit Material State Update Button Functionality and Click");

        				if (MaterialStatePageMethods.clickPopUpModelSecondButton) {
        					MaterialStatePageMethods.clickPopUpModelSecondButton = false;
        					
//        					4.CHECK METHOD
        					afterClickUpdate();	   	
        					
        				}
        			}else {
        				
//        				REFRESH
        				driver.navigate().refresh();
        				Thread.sleep(1000);
        				
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
