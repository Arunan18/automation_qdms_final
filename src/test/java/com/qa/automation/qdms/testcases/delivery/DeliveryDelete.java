//***********************************************************************************
//* Description
//*------------
//* Delivery DeleteButton 
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 01/03/2023
//* 

//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        01/03/2023   Gobithan     Orginal Version
//* TC-DEL-0052            10-07-2023   Priyanka     Update all methods
//************************************************************************************

package com.qa.automation.qdms.testcases.delivery;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.deleteFunction;
import com.qa.automation.qdms.pages.master.DeliveryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.project.ProjectMethods;
import com.qa.automation.qdms.testcases.unit.UnitMethods;

public class DeliveryDelete extends DriverIntialization {

	static DeliveryTest DeliveryDelete = new DeliveryTest();
	static Logout logout = new Logout();

	@Test
	public static void function() throws InterruptedException, IOException {
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
			deleteFunction.clickDelete("Master Module", "Delivery", "TC-DEL-0052", "DELIVERY");
		}

		Logout.LogoutFunction();

	}
}
