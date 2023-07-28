package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class IncomingSmapleMoreOption  extends DriverIntialization{
	 static IncomingSamplePage  moreOption = new IncomingSamplePage();
	static String Searchdata = null;
	static String CreatedDate = null;
	static String  UpdatedDate = null;
	
//=========================================================   M E T H O D - C A L L I N G  ================================================================
	@Test
	public void methodcalling() throws InterruptedException, IOException
	{
	
//______________________________________________________
//  LOGIN
//_______________________________________________________	
	
	LoginTest.Login();

//______________________________________________________
//  NAVIAGTE TO INCOMMING SMAPLE
//_______________________________________________________	
		
	IncomingSmapleMoreOption.navigateToIncomingSmaple();
	
//______________________________________________________
//  EXCEL METHOD
//_______________________________________________________	
	
	IncomingSmapleMoreOption.ExcelMethod();
	
//_______________________________________________________
//  STEP:1 POPUP ICON IS VISIBLE AND ENABLE		
//_______________________________________________________	
	
	IncomingSmapleMoreOption.SearchDataToClick();
	
//_______________________________________________________
//  STEP:2 CREATE DATE VISIBLE
//  STEP:3 CREATE DATE TEXT
//  STEP:4 UPDATE DATE VISIBLE
//  STEP:5 UPDATE DATE TEXT	
//_______________________________________________________	
	 
	IncomingSmapleMoreOption.morePopupVisibleAndSpelling();
	
//_______________________________________________________
//  LOGOUT
//_______________________________________________________
	
	IncomingSmapleMoreOption.Logout();
	}
	
	
	
	
//====================================================================== T E S T C A S E ===============================================================
//_____________________________________________________
// NAVIGATE TO INCOMING SAMPLE
//______________________________________________________	
	public static void navigateToIncomingSmaple() throws InterruptedException {
		PageFactory.initElements(driver, moreOption);

		Thread.sleep(2000);
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.rawMaterialSampleMainNavigation();
		SampleNavigateTest.incommingSampleNavigation();
		
	}
//__________________________________________________________
// EXCEL METHOD
//__________________________________________________________
	public static void ExcelMethod() throws IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Incoming Sample";
		String testCaseId = "TC-INC-SAM-0016";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			Searchdata = (String) row.getCell(1).getStringCellValue();
			CreatedDate = (String) row.getCell(2).getStringCellValue();
			UpdatedDate = (String) row.getCell(3).getStringCellValue();

		}
	}
	
//______________________________________________________________________
//   SEARCH PERTICULAR DATA
//_______________________________________________________________________	
	 public static void  SearchDataToClick() {
		 PageFactory.initElements(driver, moreOption);
		 
	testCase  = extent.createTest("STEP:1");	 
	 ActionCommonMethod.actionS(0, 16, IncomingSamplePage.incomingSampleTable, "More", "Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0020-01", 1);
	
	

	 } 
//___________________________________________________________________________
//   POPUP DATA VISIBLE AND TEXT SPELLING (create date)
//___________________________________________________________________________	
	 
	 public static void morePopupVisibleAndSpelling() throws InterruptedException{
		 PageFactory.initElements(driver, moreOption);
	
		 Thread.sleep(2000);
		 WebElement CreatedDateXpath = driver.findElement(By.xpath("//p[normalize-space()='2023-04-20 17:53:15.0']"));
		 
		 ActionCommonMethod.visbleEnable(CreatedDateXpath, " STEP:2 CREATED DATE");
		 
		 
			testCase = extent.createTest("STEP:3 CHECK CREATION DATE TEXT");
			String actualText = CreatedDateXpath.getText();
			System.out.println("Created Text :-" + actualText);
			String expectedText = CreatedDate;
			boolean spelling = true;
			try {
				Assert.assertEquals(actualText, expectedText);
			} catch (AssertionError e) {
				// TODO: handle exception
			}
			if (spelling) {
				testCase.log(Status.INFO, "Actual text:" + actualText);
				testCase.log(Status.INFO, "Expected text:" + expectedText);
				testCase.log(Status.PASS, "Correct text");

			} else {
				testCase.log(Status.INFO, "Actual text:" + actualText);
				testCase.log(Status.INFO, "Expected text:" + expectedText);
				testCase.log(Status.FAIL, "Correct text");
			}

		

//___________________________________________________________________________
//   POPUP DATA VISIBLE AND TEXT SPELLING (updated date)
//___________________________________________________________________________		
		  
	
	 WebElement UpdateDateXpath = driver.findElement(By.xpath("//p[normalize-space()='2023-04-20 17:54:42.0']"));
	 
	 ActionCommonMethod.visbleEnable(UpdateDateXpath, " STEP:4 UPDATED DATE ");
	 
	 testCase = extent.createTest("STEP:5 CHECK UPDATED DATE TEXT");
		String actualText1 = UpdateDateXpath.getText();
		System.out.println("Updated Date Text:-" + actualText1);
		String expectedText1 = UpdatedDate;
		boolean spelling1 = true;
		try {
			Assert.assertEquals(actualText1, expectedText1);
		} catch (AssertionError e) {
			// TODO: handle exception
		}
		if (spelling1) {
			testCase.log(Status.INFO, "Actual text:" + actualText1);
			testCase.log(Status.INFO, "Expected text:" + expectedText1);
			testCase.log(Status.PASS, "Correct text");

		} else {
			testCase.log(Status.INFO, "Actual text:" + actualText1);
			testCase.log(Status.INFO, "Expected text:" + expectedText1);
			testCase.log(Status.FAIL, "Correct text");
		}
	 
		driver.navigate().refresh();
		Thread.sleep(2000);
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
