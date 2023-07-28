//***********************************************************************************
//* Description
//*------------
//* Project Multi Search in Last Page 
//***********************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 08/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*            08/03/2023   Priyanka     Orginal Version
//*TC-PRO-0091
//TC-PRO-0092
//TC-PRO-0093
//TC-PRO-0094
//************************************************************************************

package com.qa.automation.qdms.testcases.project;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.testcases.inprocesssample.ProcessSampleMultiSearch;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;


public class ProjectMultisearchLast extends DriverIntialization {



	@Test
public void projectMultiSearchLast() throws InterruptedException, IOException {


		 EquipmentPage sourcepage = new EquipmentPage();
		PageFactory.initElements(driver, sourcepage);
	boolean contnew=false;
	extent.createTest("TC-PRO-0091:- Project MULTI SEARCH FUNCTIONALITY,RESET ALL");
		LoginTest.Login();  
		contnew=true;
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {
				MasterMainNavigationsTest.navigateCustomerMain();
				if (MasterMainNavigationsTest.clickCustomermain) {
					MasterMainNavigationsTest.navigateProject();
					if (MasterMainNavigationsTest.clickProject) {
						
						ProcessSampleMultiSearch.multiSearch("Master Module.xlsx", "Project", "TC-PRO-0091-01", EquipmentPage.table, 1);
						
					}
					
				}}}
		if (contnew) {
			driver.navigate().refresh();
			Logout.LogoutFunction();
		}
		
	
	
	
	}
}
