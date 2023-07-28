/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* EQUIPMENT / PLANT EQUIPMENT SUB CATEGORY PAGE - METHODS 
**********************************************************************************************************
*
* @author 	 : Jathu Jana		||		Date : 14/07/2023		||		Original Version
*
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.plantequipment;

import java.util.concurrent.TimeUnit;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class PlantEquipmentPageMethods extends DriverIntialization{

	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO PLANT EQUIPMENT SUB MODULE PAGE
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void plantEquipmentPageNavigation() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		1.LOGIN SYSTEM
		LoginTest.Login();
		
		if (LoginTest.login) {
			
//			2.CLICK MASTER CARD 
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {
				MasterMainNavigationsTest.clickMaster = false;
							
//				3.CLICK EQUIPMENT (GO TO EQUIPMENT BY DEFAULT)
				MasterMainNavigationsTest.navigateEqupmentMain();
					 
				if (MasterMainNavigationsTest.mainEqupment) {
					MasterMainNavigationsTest.mainEqupment = false;

//					4.CLICK PLANT EQUIPMENT
					MasterMainNavigationsTest.navigatePlantEquipment();	
					MasterMainNavigationsTest.plntEquipmentclick = true;	
					
				}
									
			}
			
		}

	}
	
}
