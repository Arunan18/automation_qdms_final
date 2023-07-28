/***********************************************************************************
* Description
*------------
*Single Search in Mix design More Screen Content 
***********************************************************************************
*
* Author           : Karunya Navanesan
* Date Written     : 02/05/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-MIX-DES-0018     02/05/2023    Karunya    Original Version
* 
************************************************************************************/

package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.commonmethods.MixDesignNavigation;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class MixDesignMorescreenContent extends DriverIntialization {
	
	static  MixDesignPage mps = new MixDesignPage();
	static String SeachData = null;
	static String alertMessage = null;
	
	@Test
	public static void mixDesignMoreScreen() throws InterruptedException, IOException {
		
// _______________________________________________________________
// NAVIAGATE TO MIX DESIGN COMPOSITION
// _______________________________________________________________
		
		LoginTest.Login();
	
		MixDesignNavigation.mixDesignNavigation();
		
		ExcelMethod(); 
		
		MixDesignMorescreenContent.SeachDataToMore();
		
		Logout();
		
	}
	
	
//_______________________________________________________________
//  EXCEL METHOD
//_______________________________________________________________
	
    public static void ExcelMethod() throws IOException {
    	
	String excelPath = System.getProperty ("user.dir") +"\\src\\test\\resources\\Excel\\Samples Module.xlsx";
	String excelSheetName = "Mix Design";
	String testCaseId = "TC-MIX-DES-0018";
	
	int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
	int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

	FileInputStream file = new FileInputStream(excelPath);
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet(excelSheetName);  

	for (int i = firstRow; i <= lastRow; i++) { 
		XSSFRow row = sheet.getRow(i);
		SeachData = (String) row.getCell(1).getStringCellValue();  
		alertMessage = (String)row.getCell(2).getStringCellValue();
		
}
}
    
//________________________________________________________________________________
//  SEARCH DATA
//_________________________________________________________________________________
	public static void SeachDataToMore() throws InterruptedException {
		PageFactory.initElements(driver, mps);
		Thread.sleep(4000);
		testCase = extent.createTest("STEP:1");
		ActionCommonMethod.actionS(0, 6, MixDesignPage.mixdesignTable, "More", "Samples Module.xlsx", "Mix Design", "TC-MIX-DES-0018-01", 1);
		
		
		
	
//____________________________________________________________________________________
//  AFTER CLICK MORE ICON  VIEW ALERT MESSAGE 
//_____________________________________________________________________________________	
	
	testCase = extent.createTest("STEP:3 MORE ALERT POPUP VISIBLE");
	
	WebElement alert = MixDesignPage.mixdesignMorePopup;
	
	boolean Visible = alert.isDisplayed();
	if (Visible) {
		boolean actualVisible = alert.isDisplayed();
		System.out.println("Alert Visible:-"+actualVisible);
		boolean expectedVisible = true;
		try {
			assertEquals(actualVisible, expectedVisible);
			testCase.log(Status.INFO," Actual Visible:-"+actualVisible);
			testCase.log(Status.INFO," Expected Visible:-"+ expectedVisible);
			testCase.log(Status.PASS,"Correct Visible");
		}catch (AssertionError e) {
			// TODO: handle exception
			testCase.log(Status.INFO," Actual Visible:-"+actualVisible);
			testCase.log(Status.INFO," Expected Visible:-"+ expectedVisible);
			testCase.log(Status.PASS,"Correct Visible");
		}
	
	}
	
//______________________________________________________________________________
//  ALERT MESSAGE GET TEXT 
//______________________________________________________________________________
	
	testCase =extent.createTest("STEP:4 CHECK ALERT MESSAGE SPELLING");
	String actualText = alert.getText();
	System.out.println("Alert Text:-"+ actualText);
	String expectedText = alertMessage;
	boolean spelling = true;
	try {
	Assert.assertEquals(actualText, expectedText);
	}catch (AssertionError e) {
		// TODO: handle exception
	}
	if(spelling) {
		testCase.log(Status.INFO, "Actual text:"+actualText);
		testCase.log(Status.INFO,"Expected text:"+expectedText);
		testCase.log(Status.PASS,"Correct text");
		
	}else {
		testCase.log(Status.INFO, "Actual text:"+actualText);
		testCase.log(Status.INFO,"Expected text:"+expectedText);
		testCase.log(Status.FAIL,"Correct text");
	}
	
	
	
	}
	
// ____________________________________________________________
//  LOGOUT
//______________________________________________________________	
	public static void Logout() throws InterruptedException {

		Thread.sleep(2000);
		WebElement Admin = driver.findElement(By.xpath("(//span[@class='ant-tag ant-tag-has-color'])[1]"));
		Admin.click();

		Thread.sleep(2000);
		WebElement Logout = driver.findElement(By.xpath(
				"//body/div/div/div[contains(@class,'ant-dropdown ant-dropdown-placement-bottomRight')]/ul[@role='menu']/li[@role='menuitem']/span[@class='ant-dropdown-menu-title-content']/p[1]"));
		Logout.click();

	}

	}

