// ***********************************************************************************
// * Description
// *------------
// * Project Single Search Functionality for Customer Field
//*  This Script includes TC-PRO-0031 , TC-PRO-0032 , TC-PRO-0033 
// ***********************************************************************************
// *
// * Author : Priyanka Sundaramoorthy
// * Date Written : 22/02/2023
// * Test Case Number Date Intis Comments
// * ================ ==== ===== ========
// * 22/02/2023 Priyanka Orginal Version
// *
// ************************************************************************************

// ** CUSTOMER /RESET Functionality/ for Customer Field
// ***********************************************************************************
// *
// * Author : NILUXY KRISHNATHAVAM
// * Date Written : 17/03/2023
// * TC-PRO-0032
// *

package com.qa.automation.qdms.testcases.project;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.ProjectPage;
import com.qa.automation.qdms.testcases.Equipment.EquipmentSearchFuncation;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plantequipment.PlantEquipmentAddMethods;

public class ProjectSingleSearchCustomer extends DriverIntialization {

	static ProjectPage projectpage = new ProjectPage();

	@Test
	public void ProjectSingleSearchCustomerfield() throws InterruptedException, IOException {

		LoginTest.Login();

		if (LoginTest.login) {

			MasterMainNavigationsTest.navigateMaster();

		}

		if (MasterMainNavigationsTest.clickMaster) {

			MasterMainNavigationsTest.navigateCustomerMain();

		}

		if (MasterMainNavigationsTest.clickCustomermain) {

			MasterMainNavigationsTest.navigateProject();

		}

		if (MasterMainNavigationsTest.clickProject) {

			PageFactory.initElements(driver, projectpage);

			PlantEquipmentAddMethods.dataFromPlanEqupment("Project", "TC-PRO-0031-01");

			EquipmentSearchFuncation.singleSearchMethoid(ProjectPage.SearchBoxCustomer, 4,
					PlantEquipmentAddMethods.equipData.get(0), "Customer Search Box",
					PlantEquipmentAddMethods.equipData.get(1), PlantEquipmentAddMethods.equipData.get(2));

		}

		Logout.LogoutFunction();

	}

}
