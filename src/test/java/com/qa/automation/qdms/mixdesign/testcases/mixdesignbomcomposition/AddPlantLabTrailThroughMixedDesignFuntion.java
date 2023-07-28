/***********************************************************************************
* Description
*------------
*TC-MIX-DES-0068	Add Plant Lab Trial Sample Through the Mix Design	


***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     :03.05.2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-MIX-DES-0068      03.05.2023     RAHUL.S       Original Version
*					   07.07.2023     Sasikala.A    Modified
************************************************************************************/
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.source.SourceTest;

public class AddPlantLabTrailThroughMixedDesignFuntion extends AddPlantLabTrailThroughMixedDesignMethods {
	static MixDesignPage mixed = new MixDesignPage();
	static SampleCommonMethods methods = new SampleCommonMethods();
	static ProductionSamplePage productionsample = new ProductionSamplePage();
	static boolean work = false;

	@Test
	public static void addPlantLabTrail() throws InterruptedException, IOException {
		PageFactory.initElements(driver, mixed);
		PageFactory.initElements(driver, productionsample);

		WebDriverWait wait = new WebDriverWait(driver, 5);

		try {

			// Login Method
			LoginTest.Login();

			// CLICK THE MIXED DESIGN CARD
			wait.until(ExpectedConditions.elementToBeClickable(MixDesignPage.mixedDesignCard));
			SourceTest.CommonMethod(MixDesignPage.mixedDesignCard, "MIX DESIGN CARD");

			if (SourceTest.work) {
				work = false;
				// EXCEL
				excel();
			}

			// MixDesign + icon Through that add Plant lab trail sample
			if (exceldata) {
				exceldata = false;
				clickPlantLabtrail();
			}

			// SENDING PLANT EQUIPMENT
			if (planttrailicon) {
				planttrailicon = false;
				plantEquipment();
			}

			// SENDING DATA TO SAMPLE DATE
			if (plantequ) {
				plantequ = false;
				sampleDate();
			}

			// SENDING DATA TO SAMPLE CODE
			sampleCode();

			// CLICKING REMOVE BUTTON IN CREATION DATE
			if (samplecode) {
				samplecode = false;
				MixDesignPage.closeButtonCreationDate.click();
			}

			// SENDING CREATION DATE
			creationDate();
			Thread.sleep(2000);

			// CLICK THE SAVE BUTTON
			SourceTest.CommonMethod(MixDesignPage.saveButtonPlantLabTrail, "SAVE BUTTON");
			boolean vism = false;
			try {
				wait.until(ExpectedConditions.invisibilityOf(MixDesignPage.plantTrailPopUpScreen));
				vism = true;
			} catch (Exception e) {
				vism = false;
			}
			if (vism == false) {
				String PlantValidation = MixDesignPage.plantequvalidation.getText();
				if (PlantValidation == "") {
					PlantValidation = MixDesignPage.sampleDateValidationField.getText();
				}
				if (PlantValidation == "") {
					PlantValidation = MixDesignPage.sampleCodeValidationField.getText();
				}
				testCase = extent.createTest("Mix Design Validation");
				testCase.log(Status.INFO, "Expected Visible:-" + PlantValidation);
				testCase.log(Status.FAIL, "Added Fail");

			} else {

				try {
					wait.until(ExpectedConditions.elementToBeClickable(MixDesignPage.adminHomeButton));
		// ************** Click Admin Home Button *******************
					MixDesignPage.adminHomeButton.click();

				} catch (Exception e) {

				}

// PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED 
				methods.methodoneclick("PRODUCTION SAMPLE PROPERTIES", productionsample.samplexpath,
						"I--PRODUCTION SAMPLE CARD DISPLAYED", "II--PRODUCTION SAMPLE CARD ENABLED",
						productionsample.sampletext, "SAMPLES",
						"III--ON CLICK THE SAMPLE CARD IT'S REDERECT TO CORRECT WINDOW");

// FINISH PRODUCT SAMPLE PROPERTIES DISPLAYED & ENABLED 
				methods.mainmethod("FINISH PRODUCT SAMPLE PROPERTIES", productionsample.topnavfinishproduct,
						"I--FINISH PRODUCT TOP NAVIGATION BUTTON DISPLAYED",
						"II--FINISH PRODUCT TOP NAVIGATION BUTTON ENABLED", productionsample.plantlabwindowheadding,
						productionsample.productionwindowheadding,
						"III--ON CLICK THE FINISH PRODUCT TOP NAVIGATION SHOWES CORRECT WINDOW");

// PLANT LAB TRAIL SAMPLE BUTTON PROPERTIES DISPLAYED & ENABLED */
				methods.methodoneclick("PLANT LAB TRAIL SAMPLE BUTTON PROPERTIES",
						productionsample.plantLabTrailSampleLeftButton, "I-- PLANT LAB TRAIL SAMPLE BUTTON DISPLAYED",
						"II-- PLANT LAB TRAIL SAMPLE BUTTON ENABLED", productionsample.plantlabwindowheadding,
						"Plant-Lab Trial Sample", "III--ON CLICK  PLANT LAB TRAIL SAMPLE BUTTON SHOWES CORRECT WINDOW");
				Thread.sleep(2000);

// Add Sample Confirmation in Plant Lab Trail Sample
				addConfirm();
			}
		} catch (Exception e) {

		}

		driver.navigate().refresh();
		if(LoginTest.login) {
		// Logout Method
		Logout.LogoutFunction();
		}
	}

}
