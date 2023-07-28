
//***********************************************************************************
//* Description
//*------------
//* Check Delete Customer "Cancel" Button Functionality
//***********************************************************************************
//*
//* Author           : Quenthan
//* Date Written     : 26/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*   TC-CUS-0089   26/07/2023   Quenthan       Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testcases.customer;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.commonmethods.SelectDate;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;
import com.qa.automation.qdms.testcases.plantequipment.PlantEquipmentAddMethods;

public class CustomerDeleteCancelButton extends DriverIntialization {
	@Test
	public static void deleteButtonCencal() {


		CustomerEditCancelButton dd = new CustomerEditCancelButton();
		PageFactory.initElements(driver, dd);

		 EquipmentPage aa = new EquipmentPage();
		PageFactory.initElements(driver, aa);
	boolean contnew=false;
	extent.createTest("TC-CUS-0089	:-Check Delete Customer Cancel Button Functionality");
		LoginTest.Login();  
		contnew=true;
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {
				MasterMainNavigationsTest.navigateCustomerMain();
				if (MasterMainNavigationsTest.clickCustomermain) {
					MasterMainNavigationsTest.navigateCustomer();
					if (MasterMainNavigationsTest.clickCustomer) {
						PlantEquipmentAddMethods.dataFromPlanEqupment("Customer", "TC-CUS-0089-01");	
						SelectDate.click(2, 6,EquipmentPage.table, "delete", PlantEquipmentAddMethods.equipData.get(0));
						if (SelectDate.clickDon) {
							
							materialMethodes.cancelOrCloseButtonFunction(CustomerEditCancelButton.Delete, CustomerEditCancelButton.deleteModal, 
									"Customer Delete Cancel Button", "Customer Delete");
						}
					}
					
				}}}
		if (contnew) {
			driver.navigate().refresh();
			Logout.LogoutFunction();
		}
		
	
	
	
		
	
		
		
	
	}
	

}
