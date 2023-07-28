package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class EditEquationPopupCancelButtonFuction extends DriverIntialization {
	static ManageTestsPage cancelBtn = new ManageTestsPage();
	static TestConfigPage canceButton = new TestConfigPage();
	
//===================================================== M E T H O D  =======================================================
	@Test
	public void method() throws InterruptedException, IOException {
		
		LoginTest.Login();
		
		EditEquationPopupCancelButtonFuction.CancelButtonFunctionality();
		
		Logout.LogoutFunction();
		
		
	}

//======================================================  T E S T C A S E S ================================================

//_____________________________________________
// NAVIGATE TO MANAGE TEST
//______________________________________________	

	public static void CancelButtonFunctionality() throws InterruptedException, IOException {
		PageFactory.initElements(driver, cancelBtn);
		PageFactory.initElements(driver, canceButton);

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		Thread.sleep(2000);
		TestConfigPage.ManageCofigureMenuBar.click();

//____________ SCROLL ______________________________

		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//div[@class='ant-table-body']")).click();
		try {
			boolean pass = false;
			Thread.sleep(1000);
			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("(//th[contains(text(),'Equation')])[1]")).click();
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

//______________________________________________
//  DATA SEARCH TO CLICK
//______________________________________________
		

		ActionCommonMethod.actionS(0, 9, TestConfigPage.TableManageConfigure, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0144-01", 1);
		
//____________________________________________
// CLICK EDIT POPUP CANCEL BUTTON
//____________________________________________		

		SampleActionMethods.clicking(ManageTestsPage.editBtnPopup, 2, "STEP:1 EDIT BUTTON VISIBLE");
		
		WebElement ModalContent = driver.findElement(By.xpath("//div[@class='ant-modal-content']"));
		boolean isModalVisible = ModalContent.isDisplayed();

		SampleActionMethods.clicking(ManageTestsPage.EditPopUpCancelbtn, 2, "STEP:2 CANCEL BUTTON");
		
//____________________________________________
// AFTER CLICK CANCEL BUTTON
//____________________________________________
		Thread.sleep(2000);
		ModalContent = driver.findElement(By.xpath("(//div[@class='ant-modal-content'])[2]"));
		boolean isModalNotVisible = !ModalContent.isDisplayed();

		testCase = extent.createTest("STEP:3 AFTER CLICK CLOSE BUTTON VERIFY");
		if (isModalVisible && isModalNotVisible) {
		    testCase.log(Status.PASS, "Modal was visible and then hidden after clicking close button");
		    System.out.println("Modal was visible and then hidden after clicking close button");
		} else {
		    testCase.log(Status.FAIL, "Modal was not visible or not hidden after clicking close button");
		    System.out.println("Modal was not visible or not hidden after clicking close button");
		}
		
		Thread.sleep(2000);
		driver.navigate().refresh();

	}
	
}
