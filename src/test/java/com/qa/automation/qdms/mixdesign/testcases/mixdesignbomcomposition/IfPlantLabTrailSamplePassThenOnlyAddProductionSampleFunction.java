/***********************************************************************************
* Description
*------------
*TC-MIX-DES-0076	Check If Plant lab trail sample pass then only add Production Sample


***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     :  04/05/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-MIX-DES-0076    04/05/2023      RAHUL.S       Original Version
*
************************************************************************************/
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class IfPlantLabTrailSamplePassThenOnlyAddProductionSampleFunction extends PassCheckingMethods {
	static MixDesignPage mixed = new MixDesignPage();
	static SampleCommonMethods methods = new SampleCommonMethods();
	static ProductionSamplePage productionsample = new ProductionSamplePage();
	@Test
	public static void checking() throws InterruptedException,IOException{
		PageFactory.initElements(driver, mixed);
		PageFactory.initElements(driver, productionsample);
		PageFactory.initElements(driver, methods);
		
		try {
			/* LOGIN */
			LoginTest.Login();

			// CLICK THE MIXED DESIGN CARD
			AddmixedDesignMethods.mixedDesignCard();
			Thread.sleep(3000);
			//EXCEL
			excel();
			//GET STATUS
			getStatus();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='homebtn']")).click();
			Thread.sleep(2000);
			/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
			methods.methodoneclick("STEP_05-- PRODUCTION SAMPLE PROPERTIES", productionsample.samplexpath,
					"I--PRODUCTION SAMPLE CARD DISPLAYED", "II--PRODUCTION SAMPLE CARD ENABLED",
					productionsample.sampletext, "SAMPLES",
					"III--ON CLICK THE SAMPLE CARD IT'S REDERECT TO CORRECT WINDOW");

			/* FINISH PRODUCT SAMPLE PROPERTIES DISPLAYED & ENABLED */
			methods.mainmethod("STEP_06-- FINISH PRODUCT SAMPLE PROPERTIES", productionsample.topnavfinishproduct,
					"I--FINISH PRODUCT TOP NAVIGATION BUTTON DISPLAYED", "II--FINISH PRODUCT TOP NAVIGATION BUTTON ENABLED",
					productionsample.plantlabwindowheadding, productionsample.productionwindowheadding,
					"III--ON CLICK THE FINISH PRODUCT TOP NAVIGATION SHOWES CORRECT WINDOW");

		
			
			//PRODUCTION SAMPLE LEFT BUTTON 
			productionSampleLeftButton();
			Thread.sleep(2000);
			//CLICK ADD PRODUCTION SAMPLE BUTTON
			clickAddproductionSampleButton();
			/*PLANT FIELD DISPLAYED & ENABLED & SELECTED */  
			SampleCommonMethods.fieldmethodselect("STEP_11-- PLANT FIELD PROPERTIES ", ProductionSamplePage.plant, "I--  PLANT FIELD DISPLAYED", "II--  PLANT FIELD ENABLED" , plantT, "III--PLANT DATA SUCCESSFULLY SELECTED");
			
			/*FINISH PRODUCT DISPLAYED & ENABLED & SELECTED */  
			SampleCommonMethods.fieldmethodselect("STEP_11-- FINISH PRODUCT FIELD PROPERTIES ", ProductionSamplePage.finishproduct, "I--  FINISH PRODUCT FIELD DISPLAYED", "II--  FINISH PRODUCT FIELD ENABLED" , finishProductT, "III--FINISH PRODUCT DATA SUCCESSFULLY SELECTED");
			mixedDesign();
			
			//CLICK THE CANCEL BUTTON
			clickCancelButton();
		}catch (Exception e) {
			// TODO: handle exception
		
		}
		
	}
}
