
//***********************************************************************************
//* Description
//*------------
//* should not able to delete when depended
//***********************************************************************************
//*
//* Author           : YOGALINGAM KAJENTHIRAN
//* Date Written     : 11/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Author        Comments
//* ================       ====         =====        ========
//* TC-CUS-0050          11/03/2023   KAJAN.Y    Original Version
//* TC-CUS-0050          05/04/2023   KAJAN.Y    rework Version
//************************************************************************************

package com.qa.automation.qdms.testcases.customer;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.pages.master.MaterialMainCategoryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.master.MasterTest;

public class CheckingCustomerDeleteFunctionalityinMiddlePage extends DriverIntialization {

	static CustomerPage cu = new CustomerPage();

	@Test
	public static void shouldnotabletodeletewhendepended() throws InterruptedException, IOException {
		PageFactory.initElements(driver, cu);

		LoginTest.Login();
		Thread.sleep(3000);
		MasterTest.MasterCard();
		Thread.sleep(3000);
		MasterMainNavigationsTest.navigateCustomerMain();
		Thread.sleep(3000);
		MasterMainNavigationsTest.navigateCustomer();

		Thread.sleep(3000);
		boolean Value2 = false;
		boolean isExist1 = false;
		try {
			boolean Value3 = cu.customerdata.isDisplayed();
			CommonMethods.TestCasePrint("customer data avilable", "true", String.valueOf(Value3));
			isExist1 = true;

		}

		catch (NoSuchElementException e) {
			CommonMethods.TestCasePrint("NO matirial data THERE to delete ", "true", String.valueOf(Value2),
					String.valueOf(e));
		}
		Thread.sleep(3000);

//******************************************************************************************************************    
//      STEP-1-- GO TO middle PAGE
//******************************************************************************************************************    
		boolean Value1 = false;
		boolean isExist = false;
		try {
			boolean Value4 = cu.middlepage.isDisplayed();
			CommonMethods.TestCasePrint("middle page button IS DISPLAYED", "true", String.valueOf(Value4));
			isExist = true;

		}

		catch (NoSuchElementException e) {
			CommonMethods.TestCasePrint("NO more data avilable for go to middle page ", "true", String.valueOf(Value1),
					String.valueOf(e));
		}

		if (isExist) {
			Thread.sleep(2000);
			WebElement middlepage = cu.middlepage;
			middlepage.click();

			Thread.sleep(3000);
			Thread.sleep(5000);

			String value9 = cu.customerdata.getText();

			try {
				boolean Value3 = cu.deletebutton.isDisplayed();
				CommonMethods.TestCasePrint("delete button  DISPLAYED", "true", String.valueOf(Value3));
				isExist1 = true;
				cu.deletebutton.click();
				Thread.sleep(2000);
				try {
					boolean Value4 = cu.deletepopover.isDisplayed();
					CommonMethods.TestCasePrint("delete popover  DISPLAYED", "true", String.valueOf(Value3));
					isExist1 = true;
					if (isExist1) {
						cu.deleteok.click();
						Thread.sleep(5000);
					}
				}

				catch (NoSuchElementException e) {
					CommonMethods.TestCasePrint("No delete popover THERE ", "true", String.valueOf(Value2),
							String.valueOf(e));
				}

			}

			catch (NoSuchElementException e) {
				CommonMethods.TestCasePrint("No delete button THERE ", "true", String.valueOf(Value2),
						String.valueOf(e));
			}

			// ********************************************************************
			// check the delete data
			// ******************************************************************
			boolean isExist2 = false;
			boolean Value21 = false;
			try {
				boolean value3 = cu.searchicon.isDisplayed();
				CommonMethods.TestCasePrint("search button IS DISPLAYED", "true", String.valueOf(value3));
				isExist2 = true;
				if (isExist2) {
					cu.searchicon.click();
					Thread.sleep(5000);
					cu.searchtextbox.sendKeys(value9);

					Thread.sleep(3000);
					cu.searchok.click();
					Thread.sleep(2000);
					boolean Value4 = false;
					boolean isExist4 = false;
					try {
						boolean Value3 = cu.customerdata.isDisplayed();
						CommonMethods.TestCasePrint("material search data  DISPLAYED so data not delete ", "true",
								String.valueOf(Value3));
						isExist4 = true;
						Thread.sleep(3000);

						String value10 = cu.customerdata.getText();

						CommonMethods.TestCasePrint("material  data  cont be delete becouse data depend",
								String.valueOf(value9), String.valueOf(value10));

					}

					catch (NoSuchElementException e) {
						CommonMethods.TestCasePrint("matirial data can be delete ", "true", String.valueOf(Value2),
								String.valueOf(e));
					}

				}

			} catch (NoSuchElementException e) {
				CommonMethods.TestCasePrint("NO search button THERE ", "true", String.valueOf(Value21),
						String.valueOf(e));

			}

		}

	}
}
