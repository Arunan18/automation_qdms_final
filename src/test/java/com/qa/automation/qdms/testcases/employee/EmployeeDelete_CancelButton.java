//***********************************************************************************
//* Description
//*------------
//* Check Edit Employee Form Close Button Function
//***********************************************************************************
//*
//* Author           : Quenthan
//* Date Written     : 26/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*   TC-EMP-0095   26/07/2023   Quenthan       Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.employee;

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

public class EmployeeDelete_CancelButton extends DriverIntialization {
	@Test
	public static void editfuncationCancel() throws InterruptedException {
		CustomerEditCancelButton dd = new CustomerEditCancelButton();
		PageFactory.initElements(driver, dd);

		 EquipmentPage aa = new EquipmentPage();
		PageFactory.initElements(driver, aa);
		boolean contnew=false;
		extent.createTest("TC-EMP-0101:-Check Delete Employee Cancel Button Functionality");
			LoginTest.Login();  
			contnew=true;
			if (LoginTest.login) {
				MasterMainNavigationsTest.navigateMaster();
				
				if (MasterMainNavigationsTest.clickMaster) {
					MasterMainNavigationsTest.navigateEmployeeMain();
					if (MasterMainNavigationsTest.clickEmployeeMain) {
						MasterMainNavigationsTest.navigateEmployee();
						if (MasterMainNavigationsTest.clickEmployee) 
						{
							
							PlantEquipmentAddMethods.dataFromPlanEqupment("Employee", "TC-EMP-0101-01");	
							SelectDate.click(4, 9,EquipmentPage.table, "delete", PlantEquipmentAddMethods.equipData.get(0));
							if (SelectDate.clickDon) {
								
								materialMethodes.cancelOrCloseButtonFunction(CustomerEditCancelButton.Delete, CustomerEditCancelButton.deleteModal, 
										"Employee Delete cancel Button", "Employee Cencal");}
							
							
							
						}}}}
			if (contnew) {
				driver.navigate().refresh();
				Logout.LogoutFunction();
			}
			
		
	}

}
