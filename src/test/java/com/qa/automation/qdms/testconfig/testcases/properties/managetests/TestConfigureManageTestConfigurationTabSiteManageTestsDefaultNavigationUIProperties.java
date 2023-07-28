/**********************************************************************************************************************************************
* Description
*------------
* Test Configure Manage Test Configuration Tab Site Manage Tests Default Navigation UI Properties  
************************************************************************************************************************************************
*
* Author           : M.Mathushan
* Date Written     : 07/07/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*MTC-MT-108           07/07/2023   M.Mathushan    Original Version
*
************************************************************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class TestConfigureManageTestConfigurationTabSiteManageTestsDefaultNavigationUIProperties extends DriverIntialization {
	static ManageTestsPage mtp = new ManageTestsPage();
	
static String Actualvalue;
 static String ExpectedValue;
	@Test

	public static void configureManageTestConfigurationTabMainHeadingUIProperties() throws InterruptedException, IOException {
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		configGroupTestsPage lk = new configGroupTestsPage();
		PageFactory.initElements(driver, lk);
		WebDriverWait wait = new WebDriverWait(driver, 15);

		// login
		LoginTest.Login();

        //Navicate Test Config
		TestConfigNavigation.TestConfigurationCard();

		try {
			// Navicate Manage Test Config
			wait.until(ExpectedConditions.elementToBeClickable(configGroupTestsPage.mainManagetestConfigureNavication));
			ActionCommonMethod.visbleEnable2(configGroupTestsPage.mainManagetestConfigureNavication,
					"Manage Tests Configure Navication", 1);
			configGroupTestsPage.mainManagetestConfigureNavication.click();
		} catch (NoSuchElementException e) {
			PropertiesCommonMethods.cTestReports("Test Clicking", true, false, e.toString());
		} catch (ElementClickInterceptedException e) {
			PropertiesCommonMethods.cTestReports("Test Clicking", true, false, e.toString());
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Test Clicking", true, false, e.toString());
		}
	//Check the Test Configure Manage Test Configuration Tab Main Header Button Properties
		manageTestConfigurationTabSiteManageTestsDefaultNavigationUIProperties();
		 
	// Click the Refresh
	 driver.navigate().refresh();

	// Click Logout
	 Logout.LogoutFunction();
}

	public static void manageTestConfigurationTabSiteManageTestsDefaultNavigationUIProperties() throws InterruptedException {
		
		PageFactory.initElements(driver, mtp);
	String Actualvalue= ManageTestsPage.mainManagetestConfigureNavicationsitemanagetestdefaultnavigationuiprop.getText();
	String ExpectedValue= "Manage Test Configuration";
		Thread.sleep(1000);
		PropertiesCommonMethods.cTestReports(" Manage Test Configuration is viewed", ExpectedValue, Actualvalue, "");
		
}

	
}
