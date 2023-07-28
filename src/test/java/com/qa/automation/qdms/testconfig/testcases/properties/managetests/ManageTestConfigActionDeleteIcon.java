/***********************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab - Equation - Action Column  - Delete Icon Properties
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 17/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-262        17/07/2023      K.Saranga     Original Version
//*
//************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfigActionDeleteIcon extends DriverIntialization {
	static ManageTestsPage mtp = new ManageTestsPage();
	static String code = null;
	@Test
	public static void actionDeleteIcon() throws InterruptedException, IOException {
		PageFactory.initElements(driver,mtp);

		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 9, "Description", "Test Configuration Properties","Manage_Tests", "MTC-MT-262");

		//Calling the method
		actionDeleteIconPropertiess();

		// REFRESH
		driver.navigate().refresh();

		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}
	public static void actionDeleteIconPropertiess() throws IOException {
		PageFactory.initElements(driver,mtp);
		// Excel Method
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Manage_Tests", "MTC-MT-262");

		XSSFRow row = sheet.getRow(firstrow);
		code= (String) row.getCell(3).getStringCellValue();

		properr(code);
	}
	public static void  properr(String code) {
		PageFactory.initElements(driver, mtp);

		//Check Action Column Delete Icon Properties
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests","MTC-MT-262-02", driver.findElement(By.xpath("//td[text()='"+code+"']//following-sibling::td[4]//span[@class='anticon anticon-delete']")), "Action Column Delete Icon Properties");
	}	
}








