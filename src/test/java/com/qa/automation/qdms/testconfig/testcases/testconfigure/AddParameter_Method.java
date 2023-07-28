
//***********************************************************************************
//* Description
//*------------
//* ADD PARAMETER FUNCTIONALITY METHOD -TEST CONFIGURE
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 1/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0049             1/05/2023  Niluxy         Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AddParameter_Method extends DriverIntialization {

	public static String excelpath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
	public static String pageName = "Test_Configure";

	static TestConfigPage page = new TestConfigPage();
	static Actions actions = new Actions(driver);
	static SampleActionMethods action = new SampleActionMethods();
	
	static String parameter = "";
	static String parametertype = "";
	static String succesnotification = "";

	public static void excelselection() throws InterruptedException, IOException {

		String testCaseId = "TC-TCN-0049";
		int firstrow = CommonMethods.getFirstRowNum(excelpath, pageName, testCaseId);
		int lastrow = CommonMethods.getLastRowNum(excelpath, pageName, testCaseId);

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet pageName = workbook.getSheet("Test_Configure");
		Thread.sleep(2000);
		for (int i = firstrow; i <= lastrow; i++) {
			Thread.sleep(2000);
			XSSFRow row = pageName.getRow(i);

			String parameter = (String) row.getCell(1).getStringCellValue();
			String parametertype = (String) row.getCell(2).getStringCellValue();
			String succesnotification = (String) row.getCell(3).getStringCellValue();

			// PARAMETER FIELD
			// ________________________________________________________________________
			try {
				Thread.sleep(2000);
				SampleActionMethods.clicking(TestConfigPage.parametertextbox, 2, "CHECK PARAMETER TEXBOX");
				TestConfigPage.parametertextbox.sendKeys(parameter);
				Thread.sleep(2000);
			} catch (Exception e) {

			}

			// PARAMETER TYPE FIELD
			// ________________________________________________________________
			try {
				Thread.sleep(2000);

				SampleActionMethods.clicking(TestConfigPage.parameterTypetextbox, 2, "CHECK PARAMETERTYPE TEXBOX");

				Thread.sleep(2000);
				TestConfigPage.parameterTypetextbox.sendKeys(parametertype);
				Thread.sleep(2000);
				actions.sendKeys(Keys.ENTER).perform();
				Thread.sleep(1000);

			} catch (Exception e) {

			}			
		
		}
	}
	
}