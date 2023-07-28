/***********************************************************************************
* Description
*------------
*TC-MIX-DES-0069	Check Sample Code Autogenerate Add Plant Lab Trial Sample Through the Mix Design	


***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     :04.05.2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-MIX-DES-0069      04.05.2023     RAHUL.S       Original Version
      
*
************************************************************************************/
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class SampleCodeAutoGenerateWhileAddingPlantLabTrailSampleFunction extends SampleCodeAutoGenerateMethods {
	static MixDesignPage mixed = new MixDesignPage();
	static SampleCommonMethods methods = new SampleCommonMethods();
	static ProductionSamplePage productionsample = new ProductionSamplePage();
	@Test
	public static void AutoGenerate() throws InterruptedException,IOException{
		PageFactory.initElements(driver, mixed);
		PageFactory.initElements(driver, productionsample);
		
		try {
			/* LOGIN */
			LoginTest.Login();

			// CLICK THE MIXED DESIGN CARD
			AddmixedDesignMethods.mixedDesignCard();
			Thread.sleep(3000);
			// EXCEL
			excelAutoGenerate();
			Thread.sleep(2000);
			//CLICK THE PLANT LAB TRAIL SAMPLE ICON 
			clickPlantLabtrailAuto();
			Thread.sleep(2000);
			//CLICK THE PLANT EQUIPMENT IN DROPDOWN
			plantEquipmentAuto();
			Thread.sleep(2000);
			//CLICK AND SELECT THE SAMPLE DATE
			sampleDateForAuto();
			Thread.sleep(2000);
			//CLICK AND SELECT THE CREATION DATE
			creationDateForAuto();
			Thread.sleep(2000);
			//CLICK THE SAVE BUTTON
			saveButttonForAuto();
			Thread.sleep(2000);
			//CLICK THE HOME BUTTON
			driver.findElement(By.xpath("//div[@class='homebtn']")).click();
			
			Thread.sleep(2000);
			/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
			methods.methodoneclick("STEP_10-- PRODUCTION SAMPLE PROPERTIES", productionsample.samplexpath,
					"I--PRODUCTION SAMPLE CARD DISPLAYED", "II--PRODUCTION SAMPLE CARD ENABLED",
					productionsample.sampletext, "SAMPLES",
					"III--ON CLICK THE SAMPLE CARD IT'S REDERECT TO CORRECT WINDOW");

			/* FINISH PRODUCT SAMPLE PROPERTIES DISPLAYED & ENABLED */
			methods.mainmethod("STEP_11-- FINISH PRODUCT SAMPLE PROPERTIES", productionsample.topnavfinishproduct,
					"I--FINISH PRODUCT TOP NAVIGATION BUTTON DISPLAYED", "II--FINISH PRODUCT TOP NAVIGATION BUTTON ENABLED",
					productionsample.plantlabwindowheadding, productionsample.productionwindowheadding,
					"III--ON CLICK THE FINISH PRODUCT TOP NAVIGATION SHOWES CORRECT WINDOW");

			/* PLANT LAB TRAIL SAMPLE BUTTON PROPERTIES DISPLAYED & ENABLED */
			methods.methodoneclick("STEP_12-- PLANT LAB TRAIL SAMPLE BUTTON PROPERTIES",
					productionsample.plantLabTrailSampleLeftButton, "I-- PLANT LAB TRAIL SAMPLE BUTTON DISPLAYED",
					"II-- PLANT LAB TRAIL SAMPLE BUTTON ENABLED", productionsample.plantlabwindowheadding,
					"Plant-Lab Trial Sample", "III--ON CLICK  PLANT LAB TRAIL SAMPLE BUTTON SHOWES CORRECT WINDOW");
			}catch (Exception e) {
				// TODO: handle exception
			}
		//CONFIRM THR INTERMIDATE POINT
		addGenerateConfirm();
		Thread.sleep(2000);
		//CONFIRM THE AUTOGENERATE SAMPLE CODE
		autoGenerateConfirm();
		
		//LOGOUT
		Logout.LogoutFunction();
		
	}
}
