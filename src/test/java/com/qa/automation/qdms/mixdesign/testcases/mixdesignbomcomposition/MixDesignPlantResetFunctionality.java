/***********************************************************************************
* Description
*------------
*Single Search Reset in Mix design Plant 
***********************************************************************************
*
* Author           : Karunya Navanesan
* Date Written     : 28/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-MIX-DES-0029      28/04/2023    Karunya    Original Version
*
************************************************************************************/
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.mixdesign.commonmethods.MixDesignNavigation;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class MixDesignPlantResetFunctionality extends DriverIntialization {
	 static  MixDesignPage mps = new MixDesignPage();
	 
	 @Test
	 public void mixdesignPlantreset() throws InterruptedException, IOException {
		// _______________________________________________________________
		// LOGIN
		// _______________________________________________________________

					LoginTest.Login();
				
		// _______________________________________________________________
		// NAVIAGATE TO MIX DESIGN COMPOSITION
		// _______________________________________________________________

					MixDesignNavigation.mixDesignNavigation();
				
					
					MixDesignPlantResetFunctionality.mixdesignPlantresetbuttonfunction();
					
		
	}
	 
//****************************************************************************************
//  	STEP-01--PLANT RESET BUTTON  IS DISPLAYED &	STEP-02--PLANT RESET BUTTON IS ENABLED
//****************************************************************************************	
	 
	 public static void mixdesignPlantresetbuttonfunction () throws InterruptedException, IOException {
		 
		 PageFactory.initElements(driver, mps);
		 
		 boolean clickNextPage = true;
			int BeforeCount = 0;

			ArrayList<String> BeforestringList = new ArrayList<String>();

			String PlantXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[";
			String PlantXpath_lastPart = "]/td[1]";
			while (clickNextPage) {

				for (int i = 2; i < 250; i++) {

					try {
						String text = driver.findElement(By.xpath(PlantXpath_firstPart + i + PlantXpath_lastPart)).getText();

						BeforestringList.add(text);
						BeforeCount = BeforeCount + 1;
					} catch (Exception e) {
					}
				}
				if (clickNextPage == true) {
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.PAGE_DOWN).build().perform();
					clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
							.isEnabled();
					driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
					Thread.sleep(2000);
				} else {
					break;
				}
			}

			Thread.sleep(500);
			
			driver.navigate().refresh();
			Thread.sleep(3000);
			System.out.println("before count " + BeforeCount);
			System.out.println(BeforestringList);

			

		 Thread.sleep(3000);
		
		// --------------------------------------------------------------------------------------  
		// Search the Plant
		// --------------------------------------------------------------------------------------
		 

    	    MixDesignPlantSearchFunctionality.planticonClick();
			
			MixDesignPlantSearchFunctionality.plantTextbox();
			
			MixDesignPlantSearchFunctionality.plantSearchButton();
			
		// --------------------------------------------------------------------------------------  
		// Click the pant Icon after Search
		// --------------------------------------------------------------------------------------

			 MixDesignPlantSearchFunctionality.planticonClick();
			 
		// --------------------------------------------------------------------------------------  
		// Check the Enablity and Visiblity of the Reset Plant Button
		// --------------------------------------------------------------------------------------

      
      try {
    	  
    	  Thread.sleep(3000);
    	  
    	  if ( MixDesignPage.plantresetbutton.isDisplayed()) {
				testCase = extent.createTest("STEP-01--PLANT RESET BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS");

				if ( MixDesignPage.plantresetbutton.isEnabled()) {
					testCase = extent.createTest("STEP-02--PLANT RESET BUTTON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS");
					Thread.sleep(3000);
					 MixDesignPage.plantresetbutton.click();

				} else {
					testCase = extent.createTest("STEP-02-PLANT RESET BUTTON IS NOT ENABLED");
					testCase.log(Status.PASS, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("STEP-01--PLANT RESET BUTTON IS NOT DISPLAYED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
    	  
    	  
    	  
       } catch (Exception e) {
    
       }
      
 // --------------------------------------------------------------------------------------  
 // Search after Count
 // --------------------------------------------------------------------------------------

   		ArrayList<String> AfterstringList = new ArrayList<String>();
   		clickNextPage = true;
   		int AfterCount = 0;

   		while (clickNextPage) {

   			for (int i = 2; i < 250; i++) {

   				try {
   					String text = driver.findElement(By.xpath(PlantXpath_firstPart + i + PlantXpath_lastPart)).getText();

   					AfterCount = AfterCount + 1;
   					AfterstringList.add(text);
   				} catch (Exception e) {
   				}
   			}
   			
   			if (clickNextPage == true) {
   				Actions actions = new Actions(driver);
   				actions.sendKeys(Keys.PAGE_DOWN).build().perform();
   				clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
   						.isEnabled();
   				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
   				Thread.sleep(2000);
   			} else {
   				break;
   			}
   		}

   		driver.navigate().refresh();
   		Thread.sleep(3000);
   		System.out.println("after count " + AfterCount);
   		System.out.println(AfterstringList);
// *****************************************************************************************************
//   										STEP-08--CONFIRM THE RESET BUTTON	
// *****************************************************************************************************
   		try {
   			testCase = extent.createTest("STEP-08--CONFIRM THE RESET BUTTON");

   			try {
   				Assert.assertEquals(BeforeCount, AfterCount);
   				testCase.log(Status.INFO, "BeforeCount :- " + BeforeCount);
   				testCase.log(Status.INFO, "AfterCount :- " + AfterCount);

   				testCase.log(Status.PASS, "RESET WORKED");
   			} catch (AssertionError e) {
   				testCase.log(Status.INFO, "BeforeCount :- " + BeforeCount);
   				testCase.log(Status.INFO, "AfterCount :- " + AfterCount);

   				testCase.log(Status.FAIL, "RESET WORKED");
   			}
   		} catch (Exception e) {

   		}

   	}
		
	

}
