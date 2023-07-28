//***********************************************************************************
//* Description
//*------------
//* Plant Multiple Search Functionality
//***********************************************************************************
//*
//* Author           : Suntharalingam Arunan
//* Date Written     : 01/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PLANT-0073          01/03/2023     Arunan     Orginal Version
//* TC-PLANT-0074          19/07/2023     Quenthan   UPDATED
//************************************************************************************
package com.qa.automation.qdms.testcases.plant;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.testcases.inprocesssample.ProcessSampleMultiSearch;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class PlantMultiSearchTest extends DriverIntialization{
	EquipmentPage psp= new EquipmentPage();
	
	@Test
public void plantMultiSearch() throws InterruptedException, IOException {
		boolean contnew=false;
		PageFactory.initElements(driver, psp);

		LoginTest.Login();  
		contnew=true;
	

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {
				MasterMainNavigationsTest.navigatePlantMain();
				if (MasterMainNavigationsTest.clickPlantMain) {
					MasterMainNavigationsTest.navigatePlant();
					if (MasterMainNavigationsTest.Plantclick) {
						
						ProcessSampleMultiSearch.multiSearch("Master Module.xlsx", "Plant", "TC-PLANT-0073-01", EquipmentPage.table, 1);
						
					}
					
					
				}}}
		if (contnew) {
			driver.navigate().refresh();
			Logout.LogoutFunction();
		}
	
		
		
	}
}
