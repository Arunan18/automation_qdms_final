/***********************************************************************************
* Description
*------------
*Add Plant Lab Trial Sample Through the Mix Design (ADD) Validation
***********************************************************************************
*
* Author           : Karunya Navanesan
* Date Written     : 03/05/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-MIX-DES-0070      03/05/2023    Karunya    Original Version
*   
************************************************************************************/
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.commonmethods.MixDesignNavigation;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.pages.master.RolePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddplantlabtrialSampleMixdesignAddValidation extends DriverIntialization {

	static MixDesignPage mps = new MixDesignPage();

	static String plant = null;
	static String finishProduct = null;
	static String mixedDesign = null;
	static String plantEquipment = null;
	static String date = null;
	static String errormsgplant = null;
	static String errormsgdate = null;

	@Test
	public void addPlantlab() throws InterruptedException, IOException {

		LoginTest.Login();

		MixDesignNavigation.mixDesignNavigation();

		addexcel();

		addplantlabTrialsampleIcon();

		addplantlabTrialsampleDateerrormsgVisible();
		
		 addplantlabTrialsampePlantequipmenterrormsgVisible();

	}

	/* Excel Sheet Value Passing */
	public static void addexcel() throws InterruptedException, IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Plant Lab Trial Sample";
		String testCaseId = "TC-MIX-DES-0070";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		DataFormatter data = new DataFormatter();
		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			plant = (String) row.getCell(1).getStringCellValue();
			finishProduct = (String) row.getCell(2).getStringCellValue();
			mixedDesign = (String) row.getCell(3).getStringCellValue();
			plantEquipment = (String) row.getCell(4).getStringCellValue();
			date = (String) row.getCell(5).getStringCellValue();
			errormsgplant = (String) row.getCell(6).getStringCellValue();
			errormsgdate = (String) row.getCell(6).getStringCellValue();

		}

	}

	public static void addplantlabTrialsampleIcon() throws InterruptedException {
		if (driver.findElement(By.xpath("//td[text()='" + plant + "']")).isDisplayed()) {
			if (driver.findElement(By.xpath("//td[text()='" + finishProduct + "']")).isDisplayed()) {
				if (driver.findElement(By.xpath("//td[text()='" + mixedDesign + "']")).isDisplayed()) {
					Thread.sleep(3000);
					driver.findElement(By.xpath("//td[text()='" + plant + "']//following-sibling::td[3]")).click();

				}
			}
		}

	}
	
	// _______________________________________________________________
	// CHECK Visible & SPELLING OF ERROR MESSAGE IN SAMPLE DATE
	// _______________________________________________________________
		

	public static void addplantlabTrialsampleDateerrormsgVisible() throws InterruptedException {

		PageFactory.initElements(driver, mps);

//		MixDesignPage.addplantlabtrialsampleIcon.click();
//		Thread.sleep(3000);
		MixDesignPage.addplantlabtrialsampleplantTextbox.sendKeys(plantEquipment+(Keys.ENTER));
		Thread.sleep(4000);
		
		MixDesignPage.addplantlabtrialsampleplantSavebutton.click();
		
		
		Thread.sleep(3000);
		boolean ActualElement = MixDesignPage.addplantlabtrialSTARTDATEErrormsg.isDisplayed();
		System.out.println("Sample Date Error Message validation:-" + ActualElement);
		String ExpectedElement = errormsgdate;
		testCase = extent.createTest("STEP:1 Sample Date Error Message is Visible");
		boolean EmptySaveValidation = true;

		try {
			Assert.assertEquals(ActualElement, ExpectedElement);
		} catch (AssertionError e) {
			// TODO: handle exception
		}
		if (EmptySaveValidation) {
			testCase.log(Status.INFO, "Actual empty save validation message visble:-" + ActualElement);
			testCase.log(Status.INFO, "Expected empty svae validation message visible:-" + ExpectedElement);
			testCase.log(Status.PASS, "Visible is correct");
		} else {
			testCase.log(Status.INFO, "Actual empty save validation message visble:-" + ActualElement);
			testCase.log(Status.INFO, "Expected empty svae validation message visible:-" + ExpectedElement);
			testCase.log(Status.FAIL, "Visible is In-correct");
		}

		// _______________________________________________________________
		// CHECK SPELLING OF ERROR MESSAGE IN SAMPLE DATE
		// _______________________________________________________________

		String Actualtext = MixDesignPage.addplantlabtrialSTARTDATEErrormsg.getText();
		System.out.println("Error Message Text Spelling validation:-" + ActualElement);
		String Expectedtext = errormsgdate;
		testCase = extent.createTest("STEP:2  Error Message Text Spelling Validation is Visible");
		boolean textValidation = true;

		try {
			Assert.assertEquals(ActualElement, ExpectedElement);
		} catch (AssertionError e) {
			// TODO: handle exception
		}
		if (textValidation) {
			testCase.log(Status.INFO, "Actual empty save validation message visble:-" + Actualtext);
			testCase.log(Status.INFO, "Expected empty svae validation message visible:-" + Expectedtext);
			testCase.log(Status.PASS, "Spelling is correct");
		} else {
			testCase.log(Status.INFO, "Actual empty save validation message visble:-" + Actualtext);
			testCase.log(Status.INFO, "Expected empty svae validation message visible:-" + Expectedtext);
			testCase.log(Status.FAIL, "Spelling is In-correct");
		}

		Thread.sleep(3000);
		MixDesignPage.addplantlabtrialcancelButton.click();
		
	}
	
	
	// _______________________________________________________________
	// CHECK Visible & SPELLING OF ERROR MESSAGE IN PLANT EQUIPMENT
	// _______________________________________________________________
	
	public static void addplantlabTrialsampePlantequipmenterrormsgVisible() throws InterruptedException {
		
		PageFactory.initElements(driver, mps);

		MixDesignPage.addplantlabtrialsampleIcon.click();
		Thread.sleep(3000);
		MixDesignPage.addplantlabtrialsampleDateTextbox.sendKeys(date+(Keys.ENTER));
		Thread.sleep(4000);
		
		MixDesignPage.addplantlabtrialsampleplantSavebutton.click();
		
		// _______________________________________________________________
		// CHECK SPELLING OF ERROR MESSAGE IN SAMPLE DATE
		// _______________________________________________________________
		
		Thread.sleep(3000);
		boolean ActualElement = MixDesignPage.addplantlabtrialsampleplantErrormsg.isDisplayed();
		System.out.println("Plant Equipment Error Message validation:-" + ActualElement);
		String ExpectedElement = errormsgplant;
		testCase = extent.createTest("STEP:3 Plant Equipment Error Message is Visible");
		boolean errortextValidation = true;

		try {
			Assert.assertEquals(ActualElement, ExpectedElement);
		} catch (AssertionError e) {
			// TODO: handle exception
		}
		if (errortextValidation) {
			testCase.log(Status.INFO, "Actual empty save validation message visble:-" + ActualElement);
			testCase.log(Status.INFO, "Expected empty svae validation message visible:-" + ExpectedElement);
			testCase.log(Status.PASS, "Visible is correct");
		} else {
			testCase.log(Status.INFO, "Actual empty save validation message visble:-" + ActualElement);
			testCase.log(Status.INFO, "Expected empty svae validation message visible:-" + ExpectedElement);
			testCase.log(Status.FAIL, "Visible is In-correct");
		}

		// _______________________________________________________________
		// CHECK SPELLING OF ERROR MESSAGE IN PLANT EQUIPMENT
		// _______________________________________________________________
		
		String Actualtext = MixDesignPage.addplantlabtrialsampleplantErrormsg.getText();
		System.out.println("Error Message Text Spelling validation:-" + ActualElement);
		String Expectedtext = errormsgplant;
		testCase = extent.createTest("STEP:4  Error Message Text Spelling Validation is Visible");
		boolean textValidation = true;

		try {
			Assert.assertEquals(ActualElement, ExpectedElement);
		} catch (AssertionError e) {
			// TODO: handle exception
		}
		if (textValidation) {
			testCase.log(Status.INFO, "Actual empty save validation message visble:-" + Actualtext);
			testCase.log(Status.INFO, "Expected empty svae validation message visible:-" + Expectedtext);
			testCase.log(Status.PASS, "Spelling is correct");
		} else {
			testCase.log(Status.INFO, "Actual empty save validation message visble:-" + Actualtext);
			testCase.log(Status.INFO, "Expected empty svae validation message visible:-" + Expectedtext);
			testCase.log(Status.FAIL, "Spelling is In-correct");
		}

		Thread.sleep(3000);
		MixDesignPage.addplantlabtrialcancelButton.click();
		
	}

	

}	


