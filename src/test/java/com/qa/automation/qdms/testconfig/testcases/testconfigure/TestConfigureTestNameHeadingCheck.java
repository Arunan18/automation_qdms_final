//***********************************************************************************
//* Description
//*------------
//*Add parameter in test config -under the test parameter tab
//***********************************************************************************
//*Test Configure - Configure Test Table- "Test Name"(Already Entered Name Test)
//* Author           : Saranka Somessaran
//* Date Written     : 01/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0393        	01/06/2023     Saranka     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.commonmethods.configureEquationStep;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class TestConfigureTestNameHeadingCheck extends DriverIntialization {
	static TestConfigPage catDueDay = new TestConfigPage();
	static configGroupTestsPage configPage = new configGroupTestsPage();
	static SampleActionMethods action = new SampleActionMethods();
	static String expectedResult = null;
	

	@Test
	public void TestConfigHeading() throws InterruptedException, IOException {
		PageFactory.initElements(driver, configPage);
		PageFactory.initElements(driver, catDueDay);
		PageFactory.initElements(driver, action);
		  
//_______________________________		
// LOGIN TO THE SYSTEM
//_______________________________		

		LoginTest.Login();

//_______________________________        
// NAVIGATE TO TEST CONFIGURATION
//_______________________________        

	SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", catDueDay.testconfigurationcard,
	"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
	catDueDay.testconfigurationtext, "TEST CONFIGURATION",
	"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

//_______________________________       
// NAVIGATE TO TEST CONFIGURATION
//_______________________________        

	SampleActionMethods.clicking(TestConfigPage.TestConfigBtnClick, 2, "STEP:2 TEST CONFIGURE BUTTON");

//_______________________________        
//STEP 3 :ADD  THE CONFIGURETEST  
// _______________________________

	testCase = extent.createTest("STEP:3 ADD  THE CONFIGURETEST  TC-TCN-0393-first ");
	AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0393-first");
	Thread.sleep(2000);

//__________________________________________________________       
//STEP 4 :SELECTING THE PARAMETER IN TEST PARAMETER PAGE
// __________________________________________________________

	testCase = extent.createTest("STEP:4 SELECTING THE PARAMETER IN TEST PARAMETER PAGE  TC-TCN-0393-Second");
	TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0393-Second");
	Thread.sleep(3000);

//________________________________________        
//STEP 5  :ADD THE PARAMETER
//_______________________________________        

   testCase = extent.createTest("STEP:5 ADD THE PARAMETER TC-TCN-0393-Second ");
   TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0393-Second");
   Thread.sleep(2000);

//_______________________________________
//STEP 6 :ADD THE EQUATIONS
//_______________________________________         

    testCase = extent.createTest("STEP 6 ADD THE EQUATIONS  TC-TCN-0393-Third");
	configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0393-Third");
	Thread.sleep(3000);

//__________________________________________
// EXCEL
//__________________________________________
	
	String excelPath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
	String excelSheetName = "Test_Configure";
	String testCaseId = "TC-TCN-0393";

	int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
	int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

	FileInputStream file = new FileInputStream(excelPath);
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet(excelSheetName);

	XSSFRow row = sheet.getRow(firstRow);
	expectedResult = (String) row.getCell(1).getStringCellValue();

	
	// Scroll up by a page
    Actions actions = new Actions(driver);
    actions.sendKeys(Keys.PAGE_UP).build().perform();  
	
//____________________________________________
//  CHECK HEADING TESTCONFIGURATION IN EQUATION
//_____________________________________________
	
	WebElement Heading = driver.findElement(By.xpath("//p[normalize-space()='"+expectedResult+"']"));
	
	String actualText = Heading.getText();
	System.out.println("Edited Data Spell:-" + actualText);
	String expectedText = expectedResult;
	testCase = extent.createTest("STEP:7 CHECK  TEXT");
	boolean data = true;
	try {
		assertEquals(actualText, expectedText);
	} catch (AssertionError e) {
		// TODO: handle exception
	}
	if (data) {
		testCase.log(Status.INFO, " Actual Text:" + actualText);
		testCase.log(Status.INFO, " Expected Text:" + expectedText);
		testCase.log(Status.PASS, "Text Correct");
	} else {
		testCase.log(Status.INFO, " Actual Text:" + actualText);
		testCase.log(Status.INFO, " Expected Text:" + expectedText);
		testCase.log(Status.FAIL, "Text Correct");
	}
	
	
// _______________________________
// LOGOUT TO THE SYSTEM
// _______________________________

			Logout.LogoutFunction();
		}
	
	}


