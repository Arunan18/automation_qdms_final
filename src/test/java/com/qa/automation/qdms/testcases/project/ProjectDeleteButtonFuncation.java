//***********************************************************************************
//* Description
//*------------
//* Check Delete Project Cancel Button Functionality
//***********************************************************************************
//*
//* Author           : Quenthan
//* Date Written     : 26/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*   TC-PRO-0084   26/07/2023   Quenthan       Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testcases.project;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.commonmethods.SelectDate;
import com.qa.automation.qdms.testcases.customer.CustomerEditCancelButton;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;
import com.qa.automation.qdms.testcases.plantequipment.PlantEquipmentAddMethods;

public class ProjectDeleteButtonFuncation extends DriverIntialization {
	@Test
	public static void editClose() throws InterruptedException {

		
		CustomerEditCancelButton dd = new CustomerEditCancelButton();
		PageFactory.initElements(driver, dd);

		 EquipmentPage aa = new EquipmentPage();
		PageFactory.initElements(driver, aa);
	boolean contnew=false;
	extent.createTest("TC-PRO-0084	:-Check Delete Project Cancel Button Functionality");
		LoginTest.Login();  
		contnew=true;
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {
				MasterMainNavigationsTest.navigateCustomerMain();
				if (MasterMainNavigationsTest.clickCustomermain) {
					MasterMainNavigationsTest.navigateProject();
					if (MasterMainNavigationsTest.clickProject) {
						PlantEquipmentAddMethods.dataFromPlanEqupment("Project", "TC-PRO-0084-01");	
						SelectDate.click(0, 8,EquipmentPage.table, "delete", PlantEquipmentAddMethods.equipData.get(0));
						if (SelectDate.clickDon) {
							
							materialMethodes.cancelOrCloseButtonFunction(CustomerEditCancelButton.Delete, CustomerEditCancelButton.deleteModal, 
									"Projectr Delete Cancel Button", "Projectr Delete");
						}
						
					}
					
				}}}
		if (contnew) {
			driver.navigate().refresh();
			Logout.LogoutFunction();
		}
		

	}

}
