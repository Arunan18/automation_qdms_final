/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Add Source Validation 
**********************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||  	 Comments
* ========================================================================================================
*  (5) 	  	    TC-SRC-0032     	     07/03/2023	  	      Rahul		     Original Version
*  										 10/04/2023			  Rahul			 Modified version 	
* 										 18/04/2023			  Rahul			 Modified version 	
*  										 14/06/2023			  Rahul			 Modified version 	
*										 19/07/2023         Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.source;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class AddSourceValidation extends DriverIntialization {
	static String source = null;
	static String description = null;
	static String expectedErrorMessage = null;
	static String forReportGenerate = null;

	public static void materialHeader() throws IOException, InterruptedException {
		MaterialPage addSourceValidation = new MaterialPage();
		PageFactory.initElements(driver, addSourceValidation);

//STEP-01--MATERIAL TAB IS DISPLAYED and STEP-02--MATERIAL TAB IS ENABLED	
		if (MaterialPage.materialheader.isDisplayed()) {
			testCase = extent.createTest("STEP-01--MATERIAL TAB IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (MaterialPage.materialheader.isEnabled()) {
				testCase = extent.createTest("STEP-02--MATERIAL TAB IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				MaterialPage.materialheader.click();
				Thread.sleep(2000);
			} else {
				testCase = extent.createTest("STEP-02--MATERIAL TAB IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}

		} else {
			testCase = extent.createTest("STEP-01--MATERIAL TAB IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
	}

	public static void sourceNAvigation() throws InterruptedException, IOException {

//	STEP-03--SOURCE TAB IS DISPLAYED and STEP-04--SOURCE TAB IS ENABLED	
		if (MaterialPage.sourceNavigation.isDisplayed()) {
			testCase = extent.createTest("STEP-03--SOURCE TAB IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (MaterialPage.sourceNavigation.isEnabled()) {
				testCase = extent.createTest("STEP-04--SOURCE TAB IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				MaterialPage.sourceNavigation.click();
				Thread.sleep(2000);

			} else {
				testCase = extent.createTest("STEP-04--SOURCE TAB IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-03--SOURCE TAB IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
	}

	public static void addSourceBUtton() throws IOException, InterruptedException {
		if (SourcePage.AddSourcebtn.isDisplayed()) {
			testCase = extent.createTest("STEP-05--ADD SOURCE BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (SourcePage.AddSourcebtn.isEnabled()) {
				testCase = extent.createTest("STEP-06--ADD SOURCE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				SourcePage.AddSourcebtn.click();
				Thread.sleep(2000);

			} else {
				testCase = extent.createTest("STEP-06--ADD SOURCE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-05--ADD SOURCE BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
	}

	public static void excell() throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\MasterModuleFinal.xlsx";
		String excelSheetName = "Source";
		String testCaseId = "TC-SRC-0032";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			source = (String) row.getCell(1).getStringCellValue();
			description = (String) row.getCell(2).getStringCellValue();
			expectedErrorMessage = (String) row.getCell(3).getStringCellValue();
			forReportGenerate = (String) row.getCell(4).getStringCellValue();

			addPlantValid();
		}

	}

	public static void addPlantValid() throws InterruptedException, IOException {
		try {
			SourcePage.sourceTextBox.click();
			Thread.sleep(2000);
			SourcePage.sourceTextBox.sendKeys(source);

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("SOURCE TEXT BOX CHECKING");
			testCase.log(Status.FAIL, "THERE IS NO ELEMENT");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("SOURCE TEXT BOX CHECKING");
			testCase.log(Status.FAIL, "THE ELEMENT IS NOT CLICKED");
		} catch (Exception e) {
			testCase = extent.createTest("SOURCE TEXT BOX CHECKING");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
		try {
			SourcePage.sourceDescFied.click();
			Thread.sleep(2000);
			SourcePage.sourceDescFied.sendKeys(description);
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("SOURCE DESCRIPTION CHECKING");
			testCase.log(Status.FAIL, "THERE IS NO ELEMENT");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("SOURCE DESCRIPTION CHECKING");
			testCase.log(Status.FAIL, "THE ELEMENT IS NOT CLICKED");
		} catch (Exception e) {
			testCase = extent.createTest("SOURCE DESCRIPTION CHECKING");
			testCase.log(Status.FAIL, "THE ELEMENT IS NOT CLICKED");
		}
		try {
			SourcePage.saveButton.click();
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("SAVE BUTTON CHECKING");
			testCase.log(Status.FAIL, "THERE IS NO ELEMENT");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("SAVE BUTTON CHECKING");
			testCase.log(Status.FAIL, "THE ELEMENT IS NOT CLICKED");
		} catch (Exception e) {
			testCase = extent.createTest("SAVE BUTTON CHECKING");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		try {
			
//			VALIDATION CHECKING BY COMMON METHOD 
			materialMethodes.validationconfirm("","" ,"➢ Add Source Validation");

			
		} catch (Exception e) {
			testCase = extent.createTest("➢Add Source Validation");
			testCase.log(Status.INFO, "Something Wrong...Validation Can't be Check!");
			testCase.log(Status.FAIL, "FAIL");
		}
	}

}
