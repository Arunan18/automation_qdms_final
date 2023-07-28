//***********************************************************************************
//* Description
//*------------
//*Check "Description" Close button Functionality
//***********************************************************************************
//*
//* Author           : Quenthan
//* Date Written     : 26/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-DEL-0025   26/07/2023   Quenthan       Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testcases.delivery;

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

public class DeleveryDescriptionCloseButton extends DriverIntialization {
@Test
	public static void cancelButton() throws InterruptedException {
	CustomerEditCancelButton dd = new CustomerEditCancelButton();
	PageFactory.initElements(driver, dd);

	 EquipmentPage aa = new EquipmentPage();
	PageFactory.initElements(driver, aa);
		boolean contnew=false;
		extent.createTest("TC-DEL-0026:- Check Description Close button Functionality");
			LoginTest.Login();  
			contnew=true;
			if (LoginTest.login) {
				MasterMainNavigationsTest.navigateMaster();
				
				if (MasterMainNavigationsTest.clickMaster) {
					MasterMainNavigationsTest.navigateCustomerMain();
					if (MasterMainNavigationsTest.clickCustomermain) {
						MasterMainNavigationsTest.navigateDelivery();
						if (MasterMainNavigationsTest.clickDelivery) {
							PlantEquipmentAddMethods.dataFromPlanEqupment("Delivery", "TC-DEL-0026-01");	
							SelectDate.click(1, 2,EquipmentPage.table, "Description", PlantEquipmentAddMethods.equipData.get(0));
							if (SelectDate.clickDon) {
								
								materialMethodes.cancelOrCloseButtonFunction(CustomerEditCancelButton.cancelbutton, CustomerEditCancelButton.Modal, 
										"Delivery Description Close Button", "Delivery Description");
							}	
							
						}}}}
			if (contnew) {
				driver.navigate().refresh();
				Logout.LogoutFunction();
			}
	}
}
