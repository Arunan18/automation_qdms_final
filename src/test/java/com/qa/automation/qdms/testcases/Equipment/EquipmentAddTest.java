/***********************************************************************************
* Description
*------------
* CHECK ADD EQUIPMENT FUNCTIONALITY
***********************************************************************************
*
* Author           : VITHUSHA MOHAN
* Date Written     : 06/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-EQU-0033            06/04/2023   VITHUSHA.M    Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testcases.Equipment;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterTest;

public class EquipmentAddTest extends DriverIntialization {

	static EquipmentAddMethods addMethods = new EquipmentAddMethods();
	static EquipmentPage equipmentPage = new EquipmentPage();

	@Test
	public static void AddEquipment() {
		WebDriverWait wait = new WebDriverWait(driver, 15);

		PageFactory.initElements(driver, equipmentPage);

		testCase = extent.createTest("TC-EQU-0033 - Equipment Add Function".toUpperCase());
		
		try {
			LoginTest.Login();
			
			MasterTest.MasterCard();
			
			try {
				wait.until(ExpectedConditions.elementToBeClickable(EquipmentPage.Equipment));
				EquipmentPage.Equipment.click();
				
				try {
					wait.until(ExpectedConditions.elementToBeClickable(EquipmentPage.SideEquipment));
					EquipmentPage.SideEquipment.click();
				
					
				
				
					try {
						/****************************************************************************************
						 * EQUIPMENT ADDBUTTON PROPERTIES
						 ****************************************************************************************/

						EquipmentAddMethods.EquipmentAddButtonUI();
						wait.until(ExpectedConditions.elementToBeClickable(EquipmentPage.AddequButton));
						EquipmentPage.AddequButton.click();
						
						/****************************************************************************************
						 * EQUIPMENT BUTTON IS DISPLAYED & IS ENABLED
						 ****************************************************************************************/
						
						try {
							EquipmentAddMethods.EquipmentSendValues();
							try {
								/****************************************************************************************
														 * CHECK ADD EQUIPMENT SAVE BUTTON PROPERTIES
														 ****************************************************************************************/
								EquipmentAddMethods.EquipmentSaveButtonUI();
								/****************************************************************************************
								 * CHECK ADD EQUIPMENT SUCCESS MESSAGE
								 ****************************************************************************************/
								EquipmentAddMethods.checkSuccessMessage();
								/****************************************************************************************
								 * CHECK EQUIPMENT ADD FUNCTIONALITY
								 ****************************************************************************************/
								
							} catch (Exception e) {

								ExtentTest test= extent.createTest("Add Equipment Save Fail");
								test.log(Status.FAIL, "Add Equipment Send Save Fail");
							}
							
							
						} catch (Exception e) {
							ExtentTest test= extent.createTest("Add Equipment Send Value Fail");
							test.log(Status.FAIL, "Add Equipment Send Value Fail");
						}
						
						
						
					} catch (Exception e) {
						ExtentTest test= extent.createTest("Add Equipment Button Click");
						test.log(Status.FAIL, "Add Equipment Button Click");
					}
					
					
					
					
					
				} catch (Exception e) {
					ExtentTest test= extent.createTest("Side Equipment Button Click");
					test.log(Status.FAIL, "Side Equipment Button Click");
				}
				
				
				
			} catch (Exception e) {
				ExtentTest test= extent.createTest("Equipment Button Click");
				test.log(Status.FAIL, "Equipment Button Click");
				
			}
			
		} catch (Exception e) {
		}
	
		
	
driver.navigate().refresh();

		try {
			if(LoginTest.login) {
			Logout.LogoutFunction();}
		} catch (Exception e) {
		}

	}
}
