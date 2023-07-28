package com.qa.automation.qdms.testcases.supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.SupplierPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class SupplierMethod extends DriverIntialization {
	
	
	@Test
	public static void navigateSupplier() {
		SupplierPage sp=new SupplierPage();
		PageFactory.initElements(driver, sp);

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateSupplierMain();
		}

		if (MasterMainNavigationsTest.clickSuppliermain) {
			MasterMainNavigationsTest.navigateSupplier();
		}

		if (MasterMainNavigationsTest.supplierClick) {
			SupplierPage.addSupplierBtn.click();
			try {
			Thread.sleep(10000);
			}catch (Exception e) {
				// TODO: handle exception
			}
			SupplierPage.saveSupplierBtn.click(); 
			
			int ra=driver.findElements(By.xpath("//div[@class='input_wrapper']//input")).size();
			
			for(int k=1; k<=ra; k++) {
				String aaa=null;

				
			}
		}
		
//		if(LoginTest.login) {
//			MultiSearchMethods.Logout();
//		}
	}
}
