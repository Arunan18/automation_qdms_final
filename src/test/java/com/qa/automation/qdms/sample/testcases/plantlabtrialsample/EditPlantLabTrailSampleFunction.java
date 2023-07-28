/***********************************************************************************
* Description
*------------
* TC-P-LAB-SAM-0013	Plant Lab Trial Sample Edit Functionality (Able to edit Process sample only for NEW Status)

***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 05/05/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-P-LAB-SAM-0013   05/05/2023     RAHUL.S      Original Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class EditPlantLabTrailSampleFunction extends EDitLabTrailSampleMethods {
	static ProductionSamplePage productionsample = new ProductionSamplePage();
	static SampleCommonMethods methods = new SampleCommonMethods();
	static PlantLabTrailSamplePage plantLab = new PlantLabTrailSamplePage();
	@Test
	public static void editPlantLabTrail() throws InterruptedException,IOException{
		PageFactory.initElements(driver, productionsample);
		PageFactory.initElements(driver, plantLab);
		// LOGIN TO THE SYSTEM
				LoginTest.Login();
				/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
				methods.methodoneclick("STEP_01-- PRODUCTION SAMPLE PROPERTIES", productionsample.samplexpath,
						"I--PRODUCTION SAMPLE CARD DISPLAYED",
						"II--PRODUCTION SAMPLE CARD ENABLED", productionsample.sampletext,"SAMPLES",
						"III--ON CLICK THE SAMPLE CARD IT'S REDERECT TO CORRECT WINDOW");
				
				/* FINISH PRODUCT SAMPLE PROPERTIES DISPLAYED & ENABLED */
				methods.mainmethod("STEP_02-- FINISH PRODUCT SAMPLE PROPERTIES", productionsample.topnavfinishproduct,
						"I--FINISH PRODUCT TOP NAVIGATION BUTTON DISPLAYED",
						"II--FINISH PRODUCT TOP NAVIGATION BUTTON ENABLED", productionsample.plantlabwindowheadding,
						productionsample.productionwindowheadding,
						"III--ON CLICK THE FINISH PRODUCT TOP NAVIGATION SHOWES CORRECT WINDOW");
				
				/* PRODUCTION SAMPLE PROPERTIES DISPLAYED & ENABLED */
				methods.methodoneclick("STEP_03-- PLANT LAB TRAIL SAMPLE BUTTON PROPERTIES", productionsample.plantLabTrailSampleLeftButton,
						"I-- PLANT LAB TRAIL SAMPLE BUTTON DISPLAYED",
						"II-- PLANT LAB TRAIL SAMPLE BUTTON ENABLED", productionsample.plantlabwindowheadding,"Plant-Lab Trial Sample",
						"III--ON CLICK  PLANT LAB TRAIL SAMPLE BUTTON SHOWES CORRECT WINDOW");
				Thread.sleep(2000);
				//PICK DATA FROM EXCEL TO EDIT VALIDATION
				dataPick();
				Thread.sleep(2000);
				//CHECKING THE INTERMEDIATE POINT FOR PLANT ,FINISH PRODUCT AND  MIXED DESIGN
				beforeEdit();
				Thread.sleep(2000);
				//CHECKING PLANT ,FINISH PRODUCT AND  MIXED DESIGN FIELDS ARE DISABLED
				checkDisabledField();
				Thread.sleep(2000);
				//VALIDATE WHILE EDITING SAMPLE CODE
				edit();
				Thread.sleep(2000);
				clickEditButton();
				Thread.sleep(2000);
				//CONFIRM THE EDIT
				dataPick();
				Thread.sleep(2000);
				afterEdit();
				Thread.sleep(2000);
				clickCancelButton();
				///LOGOUT
				Logout.LogoutFunction();
	}
}
