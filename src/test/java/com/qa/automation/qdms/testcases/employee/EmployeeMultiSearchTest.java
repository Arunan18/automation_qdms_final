//***********************************************************************************
//* Description
//*------------
//* Employee Multiple Search Functionality
//***********************************************************************************
//*
//* Author           : Suntharalingam Arunan
//* Date Written     : 01/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-EMP-0103         01/03/2023      Arunan     Orginal Version
//*TC-EMP-0107
//************************************************************************************
package com.qa.automation.qdms.testcases.employee;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.testcases.inprocesssample.ProcessSampleMultiSearch;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class EmployeeMultiSearchTest extends DriverIntialization{
	


	@Test
	public void employeeMultiearch() throws InterruptedException, IOException {




		 EquipmentPage sourcepage = new EquipmentPage();
		PageFactory.initElements(driver, sourcepage);
	boolean contnew=false;
	extent.createTest("TC-EMP-0103:- Employee MULTI SEARCH FUNCTIONALITY,RESET ALL");
		LoginTest.Login();  
		contnew=true;
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {
				MasterMainNavigationsTest.navigateEmployeeMain();
				if (MasterMainNavigationsTest.clickEmployeeMain) {
					MasterMainNavigationsTest.navigateEmployee();
					if (MasterMainNavigationsTest.clickEmployee) {
						
						ProcessSampleMultiSearch.multiSearch("Master Module.xlsx", "Employee", "TC-EMP-0103-01", EquipmentPage.table, 1);
						
					}
					
				}}}
		if (contnew) {
			driver.navigate().refresh();
			Logout.LogoutFunction();
		}
		
	
	
	
	
	
	}
}
