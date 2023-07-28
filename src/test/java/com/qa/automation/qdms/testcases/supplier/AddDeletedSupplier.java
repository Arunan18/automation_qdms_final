//***********************************************************************************
//* Description
//*------------
//* Add Deleted Data Functionality In Supplier
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 30/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        30/03/2023   Sayan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.supplier;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.SupplierPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class AddDeletedSupplier extends DriverIntialization {
	
 static SupplierPage SupplierPg = new SupplierPage();
     
     @Test
	
	   public static void addingDeletedSupplier() throws InterruptedException, IOException {
    	 
    	   
    	 
		   
		   PageFactory.initElements(driver, SupplierPg);
			
	        Thread.sleep(2000);
	        
	        LoginTest.Login();
	   	 
	   	    MasterTest.MasterCard();
	        
	        
//	  NAVIGATE TO SUPPLIER PAGE
//	  -----------------------------------
	        
	        SupplierPage.mainSupplier.click();
			
	        SupplierPage.sideSupplier.click();
	        
	        
	        Thread.sleep(2000);
			SupplierTest.addDeletedSupplierExcelData();
			
			
//	  SEARCH ELEMENT IN TABLE
//	 -------------------------------
			
			SupplierTest.middleElementClickDeleteAdd();
			
			
//	  DELETE THE SUPPLIER 
//	 ---------------------------------------
			
			SupplierTest.deleteElementDeleteAdd();
			
			driver.navigate().refresh();
			Thread.sleep(2000);
			
//	  CONFIRM THE DELETE 
//	 ---------------------------
			
			
			SupplierTest.deleteSupplierConfirmDeleteAdd();
			
			
			
			driver.navigate().refresh();
			
			
//		    CLICK ON THE ADD SUPPLIER BUTTON
//			---------------------------------------------
			
			Thread.sleep(2000);
			SupplierPage.addSupplierButton.click();
			
//			SELECT VALUE FROM THE SUPPLIER CATEGORY DROPDOWN
//			---------------------------------------------		
			
			Thread.sleep(1000);
			SupplierPage.supplierCategoryField.click();
			SupplierTest.addSupplierDropdownDeleteAdd();
			
			
//		     SENDING VALUES TO THE FIELDS
//		    ---------------------------------------------
			
			SupplierTest.addSupplierSendValuesDeleteAdd();
			
			
//			SELECT VALUE FROM THE PLANT DROPDOWN
//			---------------------------------------------
			
			Thread.sleep(1000);
			SupplierPage.plantField.click();
			SupplierTest.addPlantDropdownDeleteAdd();
			

			
		
//			CLICK ON THE SUPPLIER SAVE BUTTON
//			---------------------------------------------
		
			SupplierPage.supplierSaveButton.click();
			
		    
//			CHECK WHETHER THE ADDED VALUE CAME TO FIRST ROW
//			---------------------------------------------
		    
		    SupplierTest.checkLastAddvalueDeleteAdd();	
			
			
				
		    MultiSearchMethods.Logout();
		
	}

}
