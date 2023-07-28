
//****************************************************************************************
//		DESCRIPTION
//------------------
//					CUSTOMER EMAIL RESET FUNCTION
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   17:03:2023	
//****************************************************************************************
//* Test Case Number     	  Date          Intis        Comments
//* ================       	  ======       ========      ========
//*  TC-CUS-0025             17.03.2023   @SASIKALA     Original Version
//*	 TC-CUS-0026             13/07/2023   Priyanka      Updated
//*  TC-CUS-0027
//****************************************************************************************

package com.qa.automation.qdms.testcases.customer;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class customerSearchResetEmail extends DriverIntialization {
	static CustomerPage customerfunpg = new CustomerPage();

	// **********************************************************************************************
	// * Customer Add Form Functional
	// **********************************************************************************************/

	@Test
	public static void fieldvisible() throws InterruptedException, IOException {

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

			PageFactory.initElements(driver, customerfunpg);

			SingleSearch.singleSearchMethod(3, CustomerPage.SearchTextBox, "Master Module", "Customer", "TC-CUS-0025",
					1, 2);

		}

		Logout.LogoutFunction();

	}

}
