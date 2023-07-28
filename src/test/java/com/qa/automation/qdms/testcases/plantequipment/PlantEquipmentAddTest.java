package com.qa.automation.qdms.testcases.plantequipment;



/* Description
*------------
* VERIFY PLANTEQUIPMENT ADD  FUNCTIONALITY
***********************************************************************************
*
* Author           : VITHUSHA MOHAN
* Date Written     : 06/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PLA-EQU-0060                       06/04/2023   VITHUSHA.M    Orginal Version
* TC-PLA-EQU-0061                       
* TC-PLA-EQU-0065
* TC-PLA-EQU-0078
************************************************************************************/

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.testcases.Equipment.EquipmentAddValidationTest;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class PlantEquipmentAddTest extends DriverIntialization {
	public static boolean continu=false;
	
	static PlantEquipmentPage plantEquipmentPage = new PlantEquipmentPage();
	static EquipmentPage equipmentPage = new EquipmentPage();

	public static String excel_path = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Excel\\Master Module.xlsx";

	@Test
	public static void AddPLantEquipment() throws InterruptedException, IOException {
		PageFactory.initElements(driver, plantEquipmentPage);
		PageFactory.initElements(driver, equipmentPage);
extent.createTest("TC-PLA-EQU-0078:-Check Add  Plant  Equipment   Functionality (Equipment add Functionality)");
		PlantEquipmentAddTest.plantEquipmentNavication();
		
		/****************************************************************************************
		 * PLANTEQUIPMENT ADDBUTTON
		 *  ****************************************************************************************/
	
		if (MasterMainNavigationsTest.plntEquipmentclick) {
			MasterMainNavigationsTest.plntEquipmentclick=false;
			PlantEquipmentAddMethods.plantEquipmentAddButtonUI();
			
			if (PlantEquipmentAddMethods.addPlantEquipment) {
				PlantEquipmentAddMethods.addPlantEquipment = false;

				try {
					/****************************************************************************************
								 * PLANTEQUIPMENT ADDBUTTON FUNCTIONALITY
								 ****************************************************************************************/
					PlantEquipmentAddMethods.plantEquipmentSendValues();
				} catch (Exception e) {
					
				}
			
				if (continu) {
					try {
						driver.navigate().refresh();
						Logout.LogoutFunction();
					} catch (Exception e) {
					}
					
				}
			} 
		} 

		
	}
	
	public static void plantEquipmentNavication() {

		try {
			LoginTest.Login();
			LoginTest.login = true;
			continu=true;
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Login", true, false, "Login");
		}
		if (LoginTest.login) {
			LoginTest.login=false;
			MasterMainNavigationsTest.navigateMaster();
			EquipmentAddValidationTest.continu=true;
			
			if (MasterMainNavigationsTest.clickMaster) {
				MasterMainNavigationsTest.clickMaster=false;
				MasterMainNavigationsTest.navigateEqupmentMain();
				if (MasterMainNavigationsTest. mainEqupment) {
					MasterMainNavigationsTest. plntEquipmentclick=false;
					MasterMainNavigationsTest.navigatePlantEquipment();
				
				}
				
			}
		}
		
	
		
	}
}
