package com.qa.automation.qdms.testcases.delivery;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.DeliveryPage;
import com.qa.automation.qdms.testcases.Equipment.EquipmentSearchFuncation;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plantequipment.PlantEquipmentAddMethods;

public class DeliverySingleSearchDelivery extends DriverIntialization {

	static DeliveryPage delivery = new DeliveryPage();

	@Test
	public void ProjectSingleSearchPlant() throws InterruptedException, IOException {

		LoginTest.Login();

		if (LoginTest.login) {

			MasterMainNavigationsTest.navigateMaster();

		}

		if (MasterMainNavigationsTest.clickMaster) {

			MasterMainNavigationsTest.navigateCustomerMain();

		}

		if (MasterMainNavigationsTest.clickCustomermain) {
			MasterMainNavigationsTest.navigateDelivery();

		}

		if (MasterMainNavigationsTest.clickDelivery) {

			PageFactory.initElements(driver, delivery);

			PlantEquipmentAddMethods.dataFromPlanEqupment("Delivery", "TC-DEL-0018-01");

			EquipmentSearchFuncation.singleSearchMethoid(DeliveryPage.SearchBoxProject, 2,
					PlantEquipmentAddMethods.equipData.get(0), "Project Search Box",
					PlantEquipmentAddMethods.equipData.get(1), PlantEquipmentAddMethods.equipData.get(2));

		}

		Logout.LogoutFunction();

	}

}
