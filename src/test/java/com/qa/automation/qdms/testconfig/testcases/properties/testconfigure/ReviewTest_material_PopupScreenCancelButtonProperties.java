/***********************************************************************************
* Description
*------------
*Test Configure - Configure Test Table-  Top Bar Review Test - Key Test - Material Pop up Screen - "Key Test" icon  Properties
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 10/05/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-TCN-0841           22/06/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class ReviewTest_material_PopupScreenCancelButtonProperties extends DriverIntialization {
	@Test
	public void modalproperties() throws InterruptedException, IOException {

		WebDriverWait wit = new WebDriverWait(driver, 20);

		TestConfiRev_MaterialSubHeadingProperties.navicateAndProperties("Test_Configure", "TC-TCN-0841-01", 2);

		// Click Material View Icon
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Test_Configure", "TC-TCN-0841-01");
		List<String> data = TestConfiRev_MaterialSubHeadingProperties.adddata;
		try {
			wit.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[text()='" + data.get(1)
					+ "']/following-sibling::td[2]//span[contains(@class,'anticon-container')]"))));
			driver.findElement(By.xpath("//td[text()='" + data.get(1)
					+ "']/following-sibling::td[2]//span[contains(@class,'anticon-container')]")).click();
		} catch (NoSuchElementException e) {
			PropertiesCommonMethods.cTestReports("Click Material View Icon", true, false, e.toString());
		} catch (ElementClickInterceptedException e) {
			PropertiesCommonMethods.cTestReports("Click Material View Icon", true, false, e.toString());
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Click Material View Icon", true, false, e.toString());
		}

//		Check Properties
		propertiesKeyTestCancelButton();

		driver.navigate().refresh();
		Logout.LogoutFunction();

	}

	public static void propertiesKeyTestCancelButton() {
		TestConfigPage lk=new TestConfigPage();
		PageFactory.initElements(driver, lk);


		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0841-02",TestConfigPage.materialPuModalCancalButton ,
				"Step-5-Modal -Key Test Cancal Button Properties");

	}

}
