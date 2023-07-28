//***********************************************************************************
//* Description
//*------------
//* Supplier Multiple Search Functionality
//***********************************************************************************
//*
//* Author           : Suntharalingam Arunan
//* Date Written     : 08/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*   TC-SUP-0083       08/03/2023      Arunan     Orginal Version
//*TC-SUP-0084          18/07/2023      Quenthan
//************************************************************************************
package com.qa.automation.qdms.testcases.supplier;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.testcases.inprocesssample.ProcessSampleMultiSearch;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class SupplierMultiSearchTest extends DriverIntialization {
	

	@Test
	public void supplierMultiSearch() throws InterruptedException, IOException {
		EquipmentPage mi=new EquipmentPage();
		PageFactory.initElements(driver, mi);

	boolean contnew=false;

		LoginTest.Login();  
		contnew=true;
	

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {
				MasterMainNavigationsTest.navigateSupplierMain();
				if (MasterMainNavigationsTest.clickSuppliermain) {
					MasterMainNavigationsTest.navigateSupplier();
					if (MasterMainNavigationsTest.supplierClick) {
						ProcessSampleMultiSearch.multiSearch("Master Module.xlsx", "Supplier", "TC-SUP-0083-01", EquipmentPage.table, 1);
					}
				}
			}
		}
		if (contnew) {
			driver.navigate().refresh();
			Logout.LogoutFunction();
		}
	

	
	}
}
