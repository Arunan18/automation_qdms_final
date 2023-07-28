/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Edit Designation Functionality (Designation Edit Functionality)
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (13) 	  	 TC-DES-0037	     	  13-03-2023         Volta			Original Version
*				   		 				  21/07/2023       Jathu Jana       Modified version (Rework)
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
import com.qa.automation.qdms.commonmethods.DataFromExcelByAnyColumn;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.DesignationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class EditDesignationFunctionality extends DriverIntialization{
	
//	PAGE OBJECT MODEL FOR DESIGNATION PAGE
	public static DesignationPage dp = new DesignationPage();
	
//	EDIT DESIGNATION UPDATE STATUS DECLARE
	public static boolean notUpdate = false;
	
//	EDIT DESIGNATION - FORM DATA COMPARE STATUS DECLARE
	public static boolean compareData = false;
	
//	IF DATA INTO THE TEXT BOX - STATUS DECLARE
	public static boolean sendDataIntoTextox;
	
//	AFTER FILL FORM STATUS DECLARE
	public static boolean fillForm = false;

//	IF ALREADY DESIGNATION UPDATE VALIDATION STATUS DECLARE
	public static boolean validationStatus = false;

//	IF SUCCESSFULLY UPDATED - ALERT STATUS DECLARE  
	public static boolean dataUpdatedSuccessAlertStatus = false;
	

//	EXCEL DATAS
	public static String editDesignationData = null;
	public static String editDescriptionData = null;
	public static String cursorTypeBeforeEdit = null;
	public static String newDesignationData = null;
	public static String newDescriptionData = null;
	public static String cursorTypeAfterEdit  = null;
	public static String SuccessAlert = null;

	
	@Test
	public static void function() throws InterruptedException, IOException {
		
//		1.DIRECTLY NAVIGATE TO DESIGNATION PAGE
		DesignationPageMethods.designationPageNavigation();
		
//		2.CHECKING FUNCTIONALITY MAIN METHOD
		CheckingEditDesignationFunctionality("Master Module","Designation","TC-DES-0037");
		
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
	 * @category  METHOD FOR EDIT DESIGNATION AND DESCRIPTION (WITH THOSE TEXTBOX FUNCTIPONALITY CHECKING)
	 * @throws InterruptedException 
	 ******************************************************************************************************************************************/
	public static void editDesignationDetails() throws InterruptedException {

		
//		POM INITIALIZATION
		PageFactory.initElements(driver, dp);

//	 	EDIT DESIGNATION POPUP - DESIGNATION, DESCRIPTION TEXTBOX DATAS COMPARE
		if (DesignationPage.desiDesignationTextBox.getAttribute("value").equals(editDesignationData) && DesignationPage.desiDescriptionTextBox.getAttribute("value").equals(editDescriptionData) ) {
			
			functionality.printPassStatus("➢ Compare Edit Designation Details Datas ", "Given Details And Edit Designation TextBox Data Matched");
			compareData = true ;
			
		}
		else {
			
			functionality.printFailStatus("➢ Compare Edit Designation Details Datas ", "Given Details And Edit Designation TextBox Data did n't Match. You Have To Check Datas");

		}
		
		
		if (compareData) {
			compareData = false ;
			
//			EDIT DESIGNATION POPUP UPDATE BUTTON FUNCTION
			functionality.ButtonAndIconFunctionalityPassInable("➢ Checking Edit Designation Update Button Functionality ",
					DesignationPage.popUpModelSecondButton, "Button");
			
		}
		
		if (functionality.Inablity) {
			functionality.Inablity = false;
			
//			EDIT DESIGNATION POPUP UPDATE BUTTON CURSOR
			functionality.getOnePropertyAndCompare("➢ Checking Edit Designation Update Button Cursor Before Editing ",
					DesignationPage.popUpModelSecondButton, "cursor", cursorTypeBeforeEdit);
		}	
		
		if (functionality.compareData) {
			functionality.compareData = false ;

			if (editDesignationData.equals(newDesignationData)) {
				
				if (editDescriptionData.equals(newDescriptionData)) {
					
					functionality.printFailStatus("➢ Checking Edit Designation Details ", "Human Error. Edit Data and New Data are Same. So, You Have to Change The Data in Excel");
					
					fillForm = false;
					
				} else {
					
//					EDIT THE DESCRIPTION TEXTBOX
					functionality.funtionCheckAndSendKeys("➢ Checking Function And Fill Description TextBox :",
							DesignationPage.desiDescriptionTextBox, "Description TextBox", newDescriptionData);
				
					sendDataIntoTextox = true;
					
				}
				
			}else {
				
				if (editDescriptionData.equals(newDescriptionData)) {
					
//					EDIT THE DESIGNATION TEXTBOX
					functionality.funtionCheckAndSendKeys("➢ Checking Function And Fill Designation TextBox :",
						DesignationPage.desiDesignationTextBox, "Designation TextBox", newDesignationData);
				
				} else {

//					EDIT THE DESCRIPTION TEXTBOX
					functionality.funtionCheckAndSendKeys("➢ Checking Function And Fill Description TextBox :",
							DesignationPage.desiDescriptionTextBox, "Description TextBox", newDescriptionData);
						
					if (functionality.searching) {
							functionality.searching = false;
	
//						EDIT THE DESIGNATION TEXTBOX
						functionality.funtionCheckAndSendKeys("➢ Checking Function And Fill Designation TextBox :",
							DesignationPage.desiDesignationTextBox, "Designation TextBox", newDesignationData);
					}	
					
				}

				sendDataIntoTextox = true;
				
			}
			
		}

		if (sendDataIntoTextox) {
			sendDataIntoTextox = false;
					
//			EDIT MATERIAL STATE POPUP UPDATE BUTTON CURSOR
			functionality.getOnePropertyAndCompare("➢ Checking Edit Description Update Button Cursor After Editing ",
						DesignationPage.popUpModelSecondButton, "cursor", cursorTypeAfterEdit);
				
//			AFTER FILL FORM - STATUS
			fillForm = true;
					
		}
				
	}
	

	/******************************************************************************************************************************************
	 * @category THE METHOD FOR CHECKING UPDATE DESIGNATION SUCCESS ALERT
	 * @throws InterruptedException
	 ******************************************************************************************************************************************/
	public static void updatedDesiSuccessAlert() throws InterruptedException {
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, dp);
		
//		GET ALERT MESSAGE
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//		CHECKING SUCCESS ALERT DATA
		functionality.compareData("➢ Checking Updated Designation Success Message ", DesignationPage.desiSuccessMessage, SuccessAlert);
		
//  	AFTER GET SUCCESS MESSAGE - STATUS
		dataUpdatedSuccessAlertStatus  = true;

	}
	
	
	/******************************************************************************************************************************************
	 * @category THE METHOD FOR CHECKING UPDATED DESIGNATION TABLE DATA AFTER EDITED
	 * @throws InterruptedException
	 ******************************************************************************************************************************************/
	public static void updateDesiTableDataStatus() throws InterruptedException {
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, dp);
		
//		GO FIRST PAGE
		driver.navigate().refresh();
		Thread.sleep(500);
		
//		CHECK DATA UPDATED IN FIRST ROW
		functionality.compareData("➢ Checking Designation Updated In The table ", DesignationPage.firstTableData,newDesignationData);
	
	}
	
	/******************************************************************************************************************************************
	 * @category THE METHOD FOR CHECKING EDITED DATA BE / NOT
	 * @throws InterruptedException
	 ******************************************************************************************************************************************/
	public static void editDataChecking() throws InterruptedException {
		
		if (editDesignationData.equals(newDesignationData)) {
			
//			SEARCH THAT EDITED DATA VALUE
			DataFromExcelByAnyColumn.searchvalueJ(editDesignationData, 1);

		}
	}
	
	/*****************************************************************************************************************************************
	 * @category CHECKING EDITED DESIGNATION STATUS AFTER UPDATED
	 * @throws InterruptedException 
	 ****************************************************************************************************************************************/
	public static void afterUpdate() throws InterruptedException {
		
//		SUCCESSFULL MESSAGE ALERT
		updatedDesiSuccessAlert();
		
		if (dataUpdatedSuccessAlertStatus) {
			dataUpdatedSuccessAlertStatus = false;
			
//			CHECKING UPDATED DESIGNATION STATUS
			updateDesiTableDataStatus();
			
		}
					
	}

	
	/******************************************************************************************************************************************
	 * @category THE METHOD FOR UPADTE DESIGNATION VALIDATION & PRINT REPORT IF NOT SAVED
	 * @throws InterruptedException
	 ******************************************************************************************************************************************/
	public static void validationThrow() {
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, dp);

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
	 * @category METHOD FOR AFTER CLICK UPDATE BUTTON EDITED DESIGNATION FUNCTIONALITY 
	 * @throws InterruptedException 
	 *******************************************************************************************************************************************/
	public static void afterClickUpdate() throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, dp);

		try {
			
//			EDITED DESIGNATION POPUP VISIBLE CHECKING
			notUpdate = DesignationPage.popUpModel.isDisplayed();
					
		} catch (Exception e) {
			
			notUpdate = false;
			
		}
	
		if (notUpdate) {
			
//			IF EDITED DESIGNATION NOT UPDATED
			validationThrow();
			
			if (validationStatus) {
				
				validationStatus = false ;
				
//				REFRESH
				driver.navigate().refresh();
				Thread.sleep(1000);	

			}
							
		}else {
			
//			IF EDITED DESIGNATION UPDATED
			afterUpdate();
			
		}
				
	}
	
	
	/*******************************************************************************************************************************************
	 * @category MAIN METHOD FOR EDIT DESIGNATION FUNCTIONALITY
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
            	
    			testCase = extent.createTest("➥ TEST : EDIT DESIGNATION FUNCTIONALITY ");

//            	DESIGNATION DATA
    			editDesignationData = dataValue.formatCellValue(row.getCell(1));
            	
//            	DESCRIPTION DATA
            	editDescriptionData = dataValue.formatCellValue(row.getCell(2));
            	
//    			CURSOR TYPE DATA BEFORE EDIT
    			cursorTypeBeforeEdit = dataValue.formatCellValue(row.getCell(3));
            	
//            	NEW DESIGNATION DATA
    			newDesignationData = dataValue.formatCellValue(row.getCell(4));
 
//            	NEW DESCRIPTION DATA
    			newDescriptionData = dataValue.formatCellValue(row.getCell(5));

//            	CURSOR TYPE DATA AFTER EDIT
    			cursorTypeAfterEdit = dataValue.formatCellValue(row.getCell(6));
 
//            	SUCCESS ALERT DATA
            	SuccessAlert = dataValue.formatCellValue(row.getCell(7));
            	
//            	CLICK EDIT DESIGNATION BUTTON
            	DataFromExcelByAnyColumn.clickTheSearchIcon(editDesignationData,1, 2, "edit");

            	if (DataFromExcelByAnyColumn.status) {
        			DataFromExcelByAnyColumn.status = false;
        			
//        			2.FILL EDIT DESIGNATION DETAILS
        			editDesignationDetails();
        			
        			if(fillForm) {
        				fillForm = false;
        				
//        				3.UPDATE DESIGNATION
        				DesignationPageMethods.popUpModelSecondButtonFunctionAndClick("➢ Checking Edit Designation Update Button Functionality");
        		
        				if (DesignationPageMethods.clickPopUpModelSecondButton) {
        					DesignationPageMethods.clickPopUpModelSecondButton = false;
        					
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
