//***********************************************************************************
//* Description
//*------------
//*AddKeyTestSubcatagoryMaterialEditWithMaterialField
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 12/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0409           12/06/2023      Niluxy       Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.commonmethods.configureEquationStep;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AddKeyTestSubcatagoryMaterialEditWithMaterialField extends DriverIntialization {
	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static ActionCommonMethod actions = new ActionCommonMethod();
	static SampleCommonMethods sample = new SampleCommonMethods();
	static TestConfigNavigation config = new TestConfigNavigation();

	static String subcategory = null;
	static String checkbox = null;
	static String message = null;
	static String ExcelTabName1 = null;

	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, config);
		PageFactory.initElements(driver, action);
		extent.createTest("TC-TCN-0409:AddKeyTestSubcatagoryMaterialEditWithMaterialField");

		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		/* TEST CONFIGURATION CARD PROPERTIES DISPLAYED & ENABLED */
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 2000, "TEST CONFIGURATION CARD");
		Thread.sleep(2000);

		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleActionMethods.clicking(TestConfigPage.testtopnav, 2000, "TEST CONFIGURE TOP NAVIGATION BUTTON");
		Thread.sleep(2000);
		/* TEST CONFIGURE SIDE NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleActionMethods.clicking(TestConfigPage.testconfigleftnav, 2000, "TEST CONFIGURE LEFT NAVIGATION BUTTON");
		Thread.sleep(2000);
//STEP1 :ADD  THE CONFIGURETEST	
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0409-first");
		Thread.sleep(2000);
//STEP2 :SELECTING THE PARAMETER IN TEST PARAMETER PAGE
		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0409-second");
		Thread.sleep(3000);
//STEP3 :ADD THE PARAMETER		
		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0409-second");
		Thread.sleep(3000);
//STEP4 :ADD THE EQUATIONS
		configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0409-third");
		Thread.sleep(3000);
//MOVE TO NEXT PAGE
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);
//STEP5 : ADD THE ACCEPTCRETERIA
		Acceptedcriteria.Acceptedcriteriatest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0409-fourth");
		Thread.sleep(3000);
//MOVE TO DOWN 
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
//MOVE TO NEXT PAGE 
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);
//STEP6 :ADD TEST KEYS 
		AddKeyTestfunction.AddTestEquation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0409-fifth");

		// CLICKING THE MATERIAL RADIO BUTTON
		SampleActionMethods.clicking(TestConfigPage.MaterialRadioButton, 200, "MATERIAL RADIO BUTTON");

		// CLICKING THE MATERIAL SUBCATEGORY TEXTBOX
		Thread.sleep(3000);
		SampleActionMethods.clicking(TestConfigPage.selectSubCategoryTextox, 200, "SUB CATEGORY TEXTOX ");
		Thread.sleep(4000);
		actions.sendKeys(Keys.ENTER).perform();

		// SELECTING THE SUBCATEGORY
		selectSubcategory("Test Configuragtion Module", "Test_Configure", "TC-TCN-0409-sixth");
		Thread.sleep(3000);
		// DOWN THE PAGE
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		// CLICK ON THE SAVE BUTTON
		SampleActionMethods.clicking(TestConfigPage.saveButtonAddkey, 100, "SAVE BUTTON");
		Thread.sleep(3000);

		// GET THE VALUE FROM THE EXCEL
		String message = TestConfigNavigation.excel("Test Configuragtion Module", "Test_Configure",
				"TC-TCN-0409-seventh", 1);

		// CHECK DATA EDITED SUCCESS MESSAGE
		SampleCommonMethods.dataaddedsuccessmsg("SUBCATEGORY DATA HAS BEEN UPDATED", TestConfigPage.successMsg,
				message);

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

	// METHOD FOR CHECKBOX TICKING
	public static void selectSubcategory(String workBookName1, String ExcelTabName, String TestcaseId1)
			throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + workBookName1 + ".xlsx";
		workBookName1 = excelPath;
		ExcelTabName1 = ExcelTabName;
		int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId1);
		int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId1);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(ExcelTabName);
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow rowk = sheet.getRow(i);
			String subcategoryName = rowk.getCell(1).getStringCellValue();

			boolean nextPageButton = true;
			boolean check = false;
			while (nextPageButton) {
				Thread.sleep(1000);

				List<WebElement> column = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
				int size = column.size();
				System.out.println(size);
				for (int j = 2; j <= size; j++) {
					String text = null;
					try {
						text = driver.findElement(By.xpath("//table/tbody/tr[" + j + "]/td[2]")).getText();
					} catch (NoSuchElementException e) {
						CommonMethods.print("Searched Element Not There");
					}
					System.out.println(text);

					if (text.equalsIgnoreCase(subcategoryName)) {

						try {

							WebElement checkboxinput = driver
									.findElement(By.xpath("//*[text()='" + subcategoryName + "']/../td[1]"));

							checkboxinput.click();
							CommonMethods.TestCasePrint(subcategoryName + " SubCategory Check Box Click",
									String.valueOf(false), String.valueOf(checkboxinput.isSelected()));

						} catch (NoSuchElementException e) {
							CommonMethods.print("Dont Have checkbox for this subcategory");
						}
						check = true;
						break;
					}

					if (check) {
						break;
					}
				}
				if (check) {
					break;
				}
				try {
					WebElement next = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"));
					nextPageButton = next.isEnabled();
					if (nextPageButton == true) {
						Thread.sleep(200);
						next.click();

					}
				} catch (NoSuchElementException e) {
					CommonMethods.print("Next Button Element Not There");
				}
			}
		}
	}

}
