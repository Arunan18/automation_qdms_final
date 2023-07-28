/***********************************************************************************
* Description
*------------
* DELETE CUSTOMER METHODS
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 07/03/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*TC-CUS-0087          17/04/2023     RAHUL.S        MODIFIED
*                         
************************************************************************************/
package com.qa.automation.qdms.testcases.customer;

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
import com.qa.automation.qdms.commonmethods.deleteFunction;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class DeleteCustomer extends DriverIntialization {
	static CustomerPage customerfunpg = new CustomerPage();

	@Test

	public static void customerTab() throws InterruptedException, IOException {

		PageFactory.initElements(driver, customerfunpg);

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateCustomerMain();
		}

		if (MasterMainNavigationsTest.clickCustomermain) {

			MasterMainNavigationsTest.navigateCustomer();

		}

		if (MasterMainNavigationsTest.clickCustomer) {

			deleteFunction.clickDelete("Master Module", "Customer", "TC-CUS-0087", "CUSTOMER");

		}

		Logout.LogoutFunction();

	}

}
