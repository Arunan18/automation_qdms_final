/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Add Suppliear Validation 
**********************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||  	 Comments
* ========================================================================================================
*  (3) 	  	    TC-SUP-0065     	     30/03/2023	  	    Sayanthan		 Original Version
*										 20/07/2023         Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.supplier;

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
import com.qa.automation.qdms.pages.master.SupplierPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;


public class AddSupplierValidation extends DriverIntialization{
	
//	PAGE OBJECT MODEL FOR SUPPLIER PAGE
	static SupplierPage sp = new SupplierPage();
	
//	ADD SUPPLIER SAVE STATUS DECLARE
	public static boolean notSave = false;
	
//	AFTER FILL FORM STATUS DECLARE
	public static boolean fillForm = false;

//	IF ALREADY SUPPLIER ADDED VALIDATION STATUS DECLARE
	public static boolean validationStatus = false;

//	IF SUCCESSFULLY ADDED - ALERT STATUS DECLARE  
	public static boolean dataAddedSuccessAlertStatus;
	
//	EXCEL DATAS
	public static String supplierCategoryData = null;
	public static String supplierData = null;
	public static String plantData = null;
	public static String contactNoData = null;
	public static String emailData = null;
	public static String addressData = null;
	public static String SuccesAlert = null;
	
	@Test
	public static void validation() throws InterruptedException, IOException {
		
//		1.DIRECTLY NAVIGATE TO SUPPLIER PAGE
		SupplierPageMethods.supplierPageNavigation();
		
//		2.CHECKING VALIDATION MAIN METHOD
		CheckingAddSupplierValidation("Master Module","Supplier","TC-SUP-0065");
		
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
	 * @category  METHOD FOR FILL ADD SUPPLIER POPUP (WITH THOSE TEXTBOX FUNCTIPONALITY CHECKING)
	 * @throws InterruptedException 
	 ******************************************************************************************************************************************/
	public static void fillAddSupplierDetails() throws InterruptedException {
							
//		POM INITIALIZATION
		PageFactory.initElements(driver, sp);

//		FILL THE SUPPLIER CATEGORY BOX
		functionality.dropDownSelectionWithTextBoxFunction("Supplier Category",SupplierPage.addSupSupplierCategoryDropDownBox,
				supplierCategoryData);
		
		if (functionality.selectData) {
			functionality.selectData = false ;
			
//			FILL THE SUPPLIER TEXTBOX
			functionality.funtionCheckAndSendKeys("➢ Checking Function And Fill Supplier TextBox ",
					SupplierPage.addSupSupplierTextBox, "Supplier TextBox", supplierData);
			
		}
		
		if (functionality.searching) {
			functionality.searching = false ;

//			FILL THE PLANT BOX
			functionality.dropDownSelectionWithSendKeysAndTextBoxFunction("Plant",SupplierPage.addSupPlantDropDownBox,
					plantData);
						
		}
		
		if (functionality.selectData) {
			functionality.selectData = false ;
			
//			FILL THE CONTACT NO TEXTBOX
			functionality.funtionCheckAndSendKeys("➢ Checking Function And Fill Contact No TextBox ",
					SupplierPage.addSupSContactNoTextBox, "Contact No TextBox", contactNoData);
			
		}
		
		if (functionality.searching) {
			functionality.searching = false ;
			
//			FILL THE EMAIL TEXTBOX
			functionality.funtionCheckAndSendKeys("➢ Checking Function And Fill Email TextBox ",
					SupplierPage.addSupEmailTextBox, "Email TextBox", emailData);
			
		}
		
		if (functionality.searching) {
			functionality.searching = false ;
			
//			FILL THE EMAIL TEXTBOX
			functionality.funtionCheckAndSendKeys("➢ Checking Function And Fill Address TextBox ",
					SupplierPage.addSupAddressTextBox, "Address TextBox", addressData);
			
		}
		
//		  	AFTER FILL FORM - STATUS
			fillForm = true;
			
	}
	

	/******************************************************************************************************************************************
	 * @category THE METHOD FOR CHECKING ADD SUPPLIER SUCCESS ALERT
	 * @throws InterruptedException
	 ******************************************************************************************************************************************/
	public static void addSupSuccessAlert() throws InterruptedException {
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, sp);
		
//		GET ALERT MESSAGE
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//		CHECKING SUCCESS ALERT DATA
		functionality.compareData("➢ Checking Add Supplier Success Message ",
				SupplierPage.supplierAddedSuccessMessage.getText(), SuccesAlert);
		
//  	AFTER GET SUCCESS MESSAGE - STATUS
		dataAddedSuccessAlertStatus  = true;

	}
	
	
	/******************************************************************************************************************************************
	 * @category THE METHOD FOR CHECKING ADDED SUPPLIER TABLE DATA AFTER SAVED
	 * @throws InterruptedException
	 ******************************************************************************************************************************************/
	public static void addSupTableDataStatus() throws InterruptedException {
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, sp);
		
//		GET ALERT MESSAGE
		functionality.compareData("➢ Checking Supplier Category Data Added In The table ", SupplierPage.tableFirstRowFirstData.getText(),supplierData);
		
		if (functionality.compareData) {
			
			functionality.compareData("➢ Checking Supplier Added In The table ", SupplierPage.tableFirstRowFirstData.getText(),supplierData);

		}
	}
	
	
	/*****************************************************************************************************************************************
	 * @category CHECKING ADDED SUPPLIER STATUS AFTER SAVED
	 * @throws InterruptedException 
	 ****************************************************************************************************************************************/
	public static void afterSave() throws InterruptedException {
		
//		SUCCESSFULL MESSAGE ALERT
		addSupSuccessAlert();
		
		if (dataAddedSuccessAlertStatus) {
			
			dataAddedSuccessAlertStatus = false;
			
//			CHECKING ADDED SUPPLIER STATUS
			addSupTableDataStatus();
			
		}
					
	}

	
	/******************************************************************************************************************************************
	 * @category THE METHOD FOR ADD SUPPLIER VALIDATION & PRINT REPORT IF NOT SAVED
	 * @throws InterruptedException
	 ******************************************************************************************************************************************/
	public static void validationThrow() {
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, sp);

//		GET VALIDATION & PRINT REPORT
		testCase = extent.createTest("➢ Check Supplier Added Status");
		testCase.log(Status.INFO, "Already This Supplier Added in the Table");

		try {
			
			testCase.log(Status.INFO, "Supplier Supplier Message Shows : "+SupplierPage.popFirstValidation.getText());
			testCase.log(Status.PASS, "TEST PASS ☑");

		} catch (Exception e) {
			
			testCase.log(Status.INFO, "Unable to get the Validation Message");
			testCase.log(Status.FAIL, "TEST FAIL ❌");
		}
		
//  	AFTER GET VALIDATION - STATUS
		validationStatus  = true;
	}
	
	
	/*******************************************************************************************************************************************
	 * @category METHOD FOR AFTER CLICK SAVE BUTTON ADDED SUPPLIER FUNCTIONALITY 
	 * @throws InterruptedException 
	 *******************************************************************************************************************************************/
	public static void afterClickSave() throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, sp);

		try {
			
//			ADD SUPPLIER POPUP VISIBLE CHECKING
			notSave = SupplierPage.popUpModel.isDisplayed();
					
		} catch (Exception e) {
			
			notSave = false;
			
		}
	
		if (notSave) {

//			IF SUPPLIER NOT SAVE - VALIDATION CHECKING BY COMMON METHOD  			
			materialMethodes.validationconfirm("", "","➢ Add Suppplier Validation");			
							
		}else {
			
//			IF SUPPLIER SAVED
			afterSave();
			
		}
				
	}
	
	
	/*******************************************************************************************************************************************
	 * @category MAIN METHOD FOR ADD SUPPLIER VALIDATION
	 * @param excelbook
	 * @param tabName
	 * @param testId
	 *******************************************************************************************************************************************/
	public static void CheckingAddSupplierValidation(String excelbook , String tabName, String testId){
		
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
            	
    			testCase = extent.createTest("➥ TEST : ADD SUPPLIER FUNCTIONALITY ");

//            	SUPPLIER CATEGORY DATA
    			supplierCategoryData = dataValue.formatCellValue(row.getCell(1));
            	
//            	SUPPLIER DATA
    			supplierData = dataValue.formatCellValue(row.getCell(2));

//            	PLANT DATA
    			plantData = dataValue.formatCellValue(row.getCell(3));
            	
//            	CONTACT NO DATA
    			contactNoData = dataValue.formatCellValue(row.getCell(4));
            	
//            	EMAIL DATA
    			emailData = dataValue.formatCellValue(row.getCell(5));
            	
//            	ADDRESS DATA
    			addressData = dataValue.formatCellValue(row.getCell(6));            	
            	
//            	SUCCESS ALERT DATA
            	SuccesAlert = dataValue.formatCellValue(row.getCell(7));
            	            	
//            	CLICK ADD SUPPLIER BUTTON
            	SupplierPageMethods.addSupButtonClick();        	

        		if (SupplierPageMethods.clickAddSuppButton) {
        			
        			SupplierPageMethods.clickAddSuppButton = false;
        			
//        			2.FILL ADD SUPPLIER DETAILS
        			fillAddSupplierDetails();
        			
        			if(fillForm) {
        				
        				fillForm = false;
        				
//        				3.SAVE SUPPLIER
        				SupplierPageMethods.popUpModelSecondButtonFunctionAndClick("➢ Checking Add Supplier Save Button Functionality");
        		
        				if (SupplierPageMethods.clickPopUpModelSecondButton) {
        					
        					SupplierPageMethods.clickPopUpModelSecondButton = false;
        					
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
