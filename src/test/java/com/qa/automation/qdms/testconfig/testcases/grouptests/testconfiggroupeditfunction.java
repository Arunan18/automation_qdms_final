package com.qa.automation.qdms.testconfig.testcases.grouptests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.configgrouptest.AddConfigGroupTest;

public class testconfiggroupeditfunction extends DriverIntialization{
	static TestConfigPage DeleteFunctionPage = new TestConfigPage();
	static String SearchDataToDelete = null;

//==================================== M E T H O D ===============================================
	@Test
	public void methodCalling() throws InterruptedException, IOException {

//__________________________________LOGIN ____________________________________________

		LoginTest.Login();

//____________________________ NAVIGATE TO GROUP TEST _______________________________

		navigateToGroupTest();
		
		

		DataSearchAndedit();
		AddConfigGroupTest.addConfigGroupTest("Test Configuragtion Module", "Group_Tests", "MTC-GT-editdata-001");

//_______________________________ LOGOUT ______________________________________________

		Logout.LogoutFunction();

	}
	// ================================ T E S T C A S E S  ============================================

	//_________________________________________________________________________
	// NAVIGATE TO MANAGE TEST CONFIGURE
	//__________________________________________________________________________	

		public static void navigateToGroupTest() {
			PageFactory.initElements(driver, DeleteFunctionPage);

			// NAVIGATE TO TEST CONFIGURATION

			SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
					"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
					TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
					"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

			// NAVIGATE TO MANAGE TEST CONFIGURE
			SampleCommonMethods.methodoneclick("STEP:1 MANGECONFIGURE PROPERTIES", TestConfigPage.MANGECONFIGURE,
					"MANGECONFIGURE SIDE BUTTON IS DISPLAY", "MANGECONFIGURE SIDE BUTTON IS ENABLED",
					TestConfigPage.ParameterText, "MANGECONFIGURE SIDE BUTTON",
					"ON CLICK THE MANGECONFIGURE BUTTON IT'S REDERECT TO CORRECT FORM");

			// NAVIGATE TO MANAGE GROUP TEST
			SampleActionMethods.clicking(TestConfigPage.GroupTest, 2, "GROUP TEST SIDE BUTTON");
		}

	
		

	//________________________________________________________
	//  SEARCH DATA TO BE  DELETE 
	//________________________________________________________	

		public static void DataSearchAndedit() throws InterruptedException {
			PageFactory.initElements(driver, DeleteFunctionPage);

			ActionCommonMethod.actionS(0, 6, TestConfigPage.TableFullGroupTest, "Form", "Test Configuragtion Module.xlsx",
					"Group_Tests", "MTC-GT-001-01", 1);
		}

}
