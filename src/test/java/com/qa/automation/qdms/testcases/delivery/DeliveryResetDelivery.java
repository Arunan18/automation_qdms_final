//***********************************************************************************
//* Description
//*------------
//* Delivery Reset Functionality
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 30/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-DEL-0012                   30/03/2023   Sayan     Orginal Version
//*  TC-DEL-0014
//*  TC-DEL-0016
//************************************************************************************

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

public class DeliveryResetDelivery extends DriverIntialization {

	static DeliveryPage delivery = new DeliveryPage();

	@Test

	public static void ResetDeliverySearch() throws InterruptedException, IOException {

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

			PlantEquipmentAddMethods.dataFromPlanEqupment("Delivery", "TC-DEL-0012-01");

			EquipmentSearchFuncation.singleSearchMethoid(DeliveryPage.SearchBoxDelviery, 1,
					PlantEquipmentAddMethods.equipData.get(0), "Delviery Search Box",
					PlantEquipmentAddMethods.equipData.get(1), PlantEquipmentAddMethods.equipData.get(2));

		}

		Logout.LogoutFunction();

	}

}
