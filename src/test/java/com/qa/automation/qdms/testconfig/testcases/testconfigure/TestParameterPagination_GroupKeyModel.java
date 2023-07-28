
//***********************************************************************************
//* Description
//*------------
//* PAGINATION FUNCTIONALITY- GROUP TEST CONFIGURE
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 2/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0079    2/05/2023  Niluxy       Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class TestParameterPagination_GroupKeyModel extends DriverIntialization {

	static TestConfigPage page = new TestConfigPage();
	static SampleActionMethods action = new SampleActionMethods();
	static boolean testdata = true;
	public static String excelpath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
	public static String pageName = "Test_Configure";

	static String succesnotification = "";
	static String parameter = "";
	static String parametertype = "";

	@Test
	public static void pagination() throws InterruptedException, IOException {

		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		
		
		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		// CLICK TEST CONFIGURATION

		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 1000,
				"STEP 1:CHECKING THE TESTCONFIGRATION");
		// CLICK ON THE MANAGE TEST CONFIG
		action.clicking(TestConfigPage.MANGECONFIGURE, 2000, "STEP 2:CHECKING THE MANAGE TEST CONFIG");
		Thread.sleep(2000);

		// CLICK MANAGE TEST LEFT BUTTON
		action.clicking(TestConfigPage.manageTest, 2000, "STEP 3:CHECKING THE MANAGE TEST CONFIG MODULE ");

		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//div[@class='ant-table-body']")).click();
		try {
			boolean pass = false;
			Thread.sleep(1000);
			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("///th[@class='ant-table-cell'][13]")).click();
						pass = true;
					} catch (Exception e) {
					}
				}
				if (!pass) {
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2);
				} else {
					break;
				}
			}
		} catch (Exception e) {
		}

		Thread.sleep(3000);
		// ScrollRight.scroll(13);

		// CLICK EDITKEYICON IN MANAGE TEST
		action.clicking(TestConfigPage.Editkeyiconinmanagetest, 20, "STEP 4:CHECKING THE EDIT KEY ICON ");
		Thread.sleep(2000);
		// click test configure left button
		action.clicking(TestConfigPage.testconfigleftnav, 20, "STEP 5:CHECKING THE TEST CONFIGURE");


		// CHECK THE TEST PARAMETER RADIO BUTTON
		Thread.sleep(2000);
		action.clicking(TestConfigPage.TestparameterRadiobuttonTCicon, 20,
				"STEP 6:CHECKING THE RADIO BUTTON TEST PARAMETER");

		// CHECK THE TEST PARAMETER ADD GROUP BUTTON
		Thread.sleep(2000);
		action.clicking(TestConfigPage.Addgroupbuttonintc, 20, "STEP 7:CHECKING THE ADD GROUP TEST");

		Thread.sleep(2000);
		//PAGE DOWN
		Actions actions1 = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

//		// CHECK THE PAGINATION FUCNTIONALITY
		Paginationmethods.paginationmodify("Test Configuragtion Module", "Test_Configure", "TC-TCN-0079",
				TestConfigPage.previousbtgp, TestConfigPage.nextbtgp, TestConfigPage.pag2ndgp, TestConfigPage.pag1stgp,
				TestConfigPage.pagdrpgp, TestConfigPage.bef, 4, TestConfigPage.aft, "TEST PAGINATION");

		
		//PAGE UP
		actions.sendKeys(Keys.PAGE_UP).build().perform();
		
		// CHECK THE GROUP KEY CLOSE BUTTON
				Thread.sleep(1000);
				action.clicking(TestConfigPage.GroupkeyCrossicon, 20, "STEP 12:CHECKING THE GROUP KEY CROSS ICON ");
		
		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}
}
