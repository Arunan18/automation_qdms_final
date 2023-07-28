//**********************************************************************************
//* Description
//*------------
//* PROJECT CONTACT PERSON RESET BUTTON TEST
//* This Script includes TC-PRO-0035 , TC-PRO-0036 , TC-PRO-0037 
//***********************************************************************************
//*
//* Author           : NILUXY KRISHNATHAVAM
//* Date Written     : 17/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*   TC-PRO-0037        17/03/2023   NILUXY     Orginal Version
//*
//************************************************************************************

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

public class ProjectSingleSearchContactPerson extends DriverIntialization {

	static ProjectPage projectpage = new ProjectPage();

	@Test
	public void ProjectSingleSearchContactPer() throws InterruptedException, IOException {

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

			PlantEquipmentAddMethods.dataFromPlanEqupment("Project", "TC-PRO-0035-01");

			EquipmentSearchFuncation.singleSearchMethoid(ProjectPage.SearchBoxContactPerson, 5,
					PlantEquipmentAddMethods.equipData.get(0), "Project Search Box",
					PlantEquipmentAddMethods.equipData.get(1), PlantEquipmentAddMethods.equipData.get(2));

		}

		Logout.LogoutFunction();

	}
}
