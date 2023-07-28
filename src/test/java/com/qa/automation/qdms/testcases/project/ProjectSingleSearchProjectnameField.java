// ***********************************************************************************
// * Description
// *------------
// * Project Single Search Functionality for Project  Field
// *This Script includes TC-PRO-0027 , TC-PRO-0028 , TC-PRO-0029
// ***********************************************************************************
// *
// * Author : Priyanka Sundaramoorthy
// * Date Written : 22/02/2023
// *
// *
// *
// *  Date Intis Comments
// *  ==== ===== ========
// *  22/02/2023 Priyanka Orginal Version
// * 23/03/2023 Priyanka Updated ProjectresetButton Methods
// ************************************************************************************

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

public class ProjectSingleSearchProjectnameField extends DriverIntialization {

	static ProjectPage projectpage = new ProjectPage();

	@Test
	public void ProjectSingleSearchProjectname() throws InterruptedException, IOException {

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

			PlantEquipmentAddMethods.dataFromPlanEqupment("Project", "TC-PRO-0027-01");

			EquipmentSearchFuncation.singleSearchMethoid(ProjectPage.SearchBoxProject, 3,
					PlantEquipmentAddMethods.equipData.get(0), "Project Search Box",
					PlantEquipmentAddMethods.equipData.get(1), PlantEquipmentAddMethods.equipData.get(2));

		}

		Logout.LogoutFunction();
	}
}
