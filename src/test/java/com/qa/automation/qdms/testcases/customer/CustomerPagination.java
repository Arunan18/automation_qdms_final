
//****************************************************************************************
//		DESCRIPTION
//------------------
//					CUSTOMER PAGINATION TEST FUNCTION
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   08:03:2023	
//****************************************************************************************
//* Test Case Number      		Date          Intis        Comments
//* =================       ======       	========       ========
//* TC-CUS-0056		       08.03.2023      @SASIKALA      Original Version
//*                        12/07/2023       Priyanka      Update with pagination common methods 
//************************************************************************************

package com.qa.automation.qdms.testcases.customer;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class CustomerPagination extends DriverIntialization {
	static CustomerPage customerfunpg = new CustomerPage();

	@Test
	public void PlantEquipmentPaginationTestcases() throws InterruptedException, IOException {

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

			Paginationmethods.pagination("Master Module", "Customer", "TC-CUS-0056", CustomerPage.PreviousPageBtn,
					CustomerPage.NextPageBtn, CustomerPage.PaginationSecoundPage, CustomerPage.DefaultPaginationPage,
					CustomerPage.PageDropdown, CustomerPage.bef, 4, CustomerPage.aft, "CUSTOMER ");

		}

		driver.navigate().refresh();

		Logout.LogoutFunction();

	}
}
