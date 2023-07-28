/***********************************************************************************
* Description
*------------
* 
Mix Design  Delete Functionality after Depended
TC-MIX-DES-0014
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* 
* Date Written     : 01/05/2023
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* 
*TC-MIX-DES-0014      01/05/2023       RAHUL.S       Original Version
************************************************************************************/
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class DeleteAfterDepended extends DriverIntialization {
	static String pickForDelete = null;
	static MixDesignPage mixed = new MixDesignPage();
	@Test
	public static void deleteAfterDepended() throws InterruptedException,IOException{
		PageFactory.initElements(driver, mixed);
		/* LOGIN */
		LoginTest.Login();

		// CLICK THE MIXED DESIGN CARD
		AddmixedDesignMethods.mixedDesignCard();
		//CHECKING THE DELETE ICON AFTER DEPENDED
		pickData();
		//LOGOUT
		Logout.LogoutFunction();
	}
	
	
	public static void pickData() throws InterruptedException, IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Mix Design";
		String testCaseId = "TC-MIX-DES-0014";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		XSSFRow row = sheet.getRow(firstRow);
		pickForDelete = (String) row.getCell(1).getStringCellValue();
		testCase = extent.createTest("STEP-03--CHECKING DELETE AFTER DEPENDED");
		
		if(driver.findElement(By.xpath("//td[text()='"+pickForDelete+"']//following-sibling::td[9]//span[@aria-label='delete']")).isDisplayed()) {
			testCase.log(Status.INFO, "DELETE ICON IS DISPLAYED");
			testCase.log(Status.FAIL, "CAN BE DELETE AFTER DEPENDED");
		}else {
			testCase.log(Status.INFO, "DELETE ICON IS NOT DISPLAYED");
			testCase.log(Status.PASS, "CAN NOT DELETE AFTER DEPENDED");
		}
		
	}
}
