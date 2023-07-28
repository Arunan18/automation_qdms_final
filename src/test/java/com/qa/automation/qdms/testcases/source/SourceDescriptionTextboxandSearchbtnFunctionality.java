
//****************************************************************************************
//		DESCRIPTION
//------------------
//					SOURCE DESCRIPTION TEXTBOX AND SEARCH BUTTON FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   22:03:2023	
//****************************************************************************************
//* Test Case Number     Date          Intis        Comments
//* =================    ======       ========      ========
//* TC-SRC-0017       	22.03.2023   @SASIKALA     Original Version(Description "Search" TextBox Functionality)
//* TC-SRC-0020    		22.03.2023   @SASIKALA     Original Version(Description "Search" Button Functionality)
//************************************************************************************

package com.qa.automation.qdms.testcases.source;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class SourceDescriptionTextboxandSearchbtnFunctionality extends DriverIntialization {
	static SourcePage Sourcepg = new SourcePage();
	static boolean work = false;

	@Test
	public static void SourceDescriptionandButton() throws InterruptedException, IOException {
		SourcePage Sourcepg = new SourcePage();
		PageFactory.initElements(driver, Sourcepg);

		WebDriverWait wait = new WebDriverWait(driver, 5);

		// Login Test
		LoginTest.Login();

		wait.until(ExpectedConditions.elementToBeClickable(SourcePage.Master));

		// Master Card Click
		SourceTest.CommonMethod(SourcePage.Master, "Master Card");
		
		if(SourceTest.work) {
			work = false;
		// Material Top Master Card Click
		SourceTest.CommonMethod(SourcePage.Materialtopbar, "Material Top Bar");
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(SourcePage.sourcesitebar));

		if(SourceTest.work) {
			work = false;
		// Click Source Module
		SourceTest.CommonMethod(SourcePage.sourcesitebar, "Source Side Button");
		}
		
		if(SourceTest.work) {
			work = false;
		// Click Source Search icon
		SourceTest.CommonMethod(SourcePage.descriptionsearchicon, "Source Description Search icon");
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(SourcePage.Descriptionsearchtextbox));
		
		if(SourceTest.work) {
			work = false;
		// Click Source TextBox
		SourceTest.CommonMethod(SourcePage.Descriptionsearchtextbox, "Description Search TextBox Field");
		}
		
		if(SourceTest.work) {
			work = false;
		// Click Source Search Button
		SourceTest.CommonMethod(SourcePage.DescriptionsearchButton, "Description Search Button");
		}
		driver.navigate().refresh();

		// Logout
		MultiSearchMethods.Logout();
	}

}