//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab- Accepted Value Pop up Screen - Accepted Value-"Relevant To Result" icon Properties 
//***************************************************************************************
//*
//* Author           : BFH.Rakshana
//* Date Written     : 14/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-211             14/07/2023   BFH.Rakshana   Original Version                
//************************************************************************************
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

public class ManageTestConfigAcceptedValuePopupRelevantToResultIcon extends DriverIntialization{
	 
@Test
public static void manageTestConfigAcceptedValuePopupRelevantToResultIcon() throws InterruptedException, IOException {
	        NavigateManageTestFromLogin.clickIcon("Manage Tests", 8, "Description", "Test Configuration Properties",
		    "Manage_Tests", "MTC-MT-211");
			
			//search
	        iconSearch();
			
	        //REFRESH
	        driver.navigate().refresh();
	        Thread.sleep(2000);
	        
			// LOGOUT
			Logout.LogoutFunction();
			
}
public static void relevantToResultIcon(String SearchData) {
	ManageTestsPage mtp = new ManageTestsPage();
	PageFactory.initElements(driver, mtp);
	
	PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests",
	"MTC-MT-211-02",driver.findElement(By.xpath("//*[text()='"+SearchData+"']/following-sibling::td[4]")),"ActionDeletePopupQuestionMarkIcon UI Properties");
}
public static void iconSearch() throws IOException, InterruptedException {
FileInputStream file = new FileInputStream(System.getProperty("user.dir")
		+ "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
XSSFWorkbook workbook = new XSSFWorkbook(file);
XSSFSheet sheet = workbook.getSheet("Manage_Tests");

int firstrow = CommonMethods.getFirstRowNum(
		System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
		"Manage_Tests", "MTC-MT-211");

XSSFRow row = sheet.getRow(firstrow);

String pro = (String) row.getCell(3).getStringCellValue();
Thread.sleep(1000);
relevantToResultIcon(pro);
}

}
