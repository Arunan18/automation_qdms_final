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

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterTest;

public class DeleteCustomerMethodCalling extends DeleteCustomer {
	@Test
	public static void methodCallingForDelete() throws InterruptedException, IOException {
		CustomerPage delete = new CustomerPage();
		PageFactory.initElements(driver, delete);
		try {
			// LOGIN
			LoginTest.Login();

			// CLICK THE MASTER CARD
			MasterTest.MasterCard();
			// CLICK CUSTOMER TAB
			customerTab();
			Thread.sleep(2000);
			// COUNT BEFORE DELETE
//			countBeforeDelete();
//			Thread.sleep(2000);
//			// PICK SPECIFIC DATA FROM EXCEL
//			dataPickDeleteCustomer();
//			Thread.sleep(2000);
//			// CLICK DELETE OK BUTTON
//			clickOkButton();
//			Thread.sleep(2000);
//			// COUNT AFTER THE DELETE
//			countAfterDelete();
//			Thread.sleep(3000);
//			// CONFIRM THE DELETION
//			DeleteEqu();
			Thread.sleep(2000);
			// LOGOUT
			Logout.LogoutFunction();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
