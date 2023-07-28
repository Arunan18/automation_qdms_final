package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.awt.Desktop.Action;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;


public class AddDataforAdditionalInformation extends DriverIntialization{
	
	static TestParameterPage TPP = new TestParameterPage();
	static TestConfigPage TCP = new TestConfigPage();
	static SampleCommonMethods SCM = new SampleCommonMethods();
	static ManageTestsPage MTP = new ManageTestsPage();
	
	@Test
	public static void MultiSearchFunctionality() throws InterruptedException, IOException {

		PageFactory.initElements(driver, TPP);
		PageFactory.initElements(driver, TCP);
		PageFactory.initElements(driver, SCM);
		PageFactory.initElements(driver, MTP);
		
		// Click LOGIN Button
		LoginTest.Login();

		
		
		// PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
					"01--TEST CONFIGURATION CARD DISPLAYED",
					"02--TEST CONFIGURATION CARD ENABLED", TestConfigPage.testconfigurationtext,"TEST CONFIGURATION",
					"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");
			
		// MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES", TestConfigPage.MANGECONFIGURE,
				"01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", TestConfigPage.GroupTest,
				TestConfigPage.managetest,"03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");
		
		// MANAGE TESTS  PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TESTS PROPERTIES",TestConfigPage.managetest,
				"01--MANAGE TEST LEFT NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST LEFT NAVIGATION BUTTON ENABLED", ManageTestsPage.managetestheading,"Manage Test Configuration",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");
		
		
		ManageTestConfiguration();
		
 }

	public static void ManageTestConfiguration() {
		
		try {
            boolean pass = false;
            Thread.sleep(1000);
        
          for (int i = 0; i < 1000; i++) {
             if (!pass) {
                 try {
                     driver.findElement(
                             By.xpath("//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[11]"))
                             .click();
                     pass = true;
                 } catch (Exception e) {
                 }
             }
             
             if (!pass) {
            	 Actions actions = new Actions(driver);
                 actions.sendKeys(Keys.ARROW_RIGHT).perform();
                 Thread.sleep(2);
             } else {
                 break;
             }
             
         }        
        } catch (Exception e) {
        }
	}}


