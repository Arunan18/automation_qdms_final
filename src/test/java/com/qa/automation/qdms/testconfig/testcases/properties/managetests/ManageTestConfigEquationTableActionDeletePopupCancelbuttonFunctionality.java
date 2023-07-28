//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab-Equation- Action - Delete Pop up Screen  "Cancel" button Functionality    
//***************************************************************************************
//*
//* Author           : BFH.Rakshana
//* Date Written     : 11/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-267             11/07/2023   BFH.Rakshana   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfigEquationTableActionDeletePopupCancelbuttonFunctionality extends DriverIntialization{
	@Test
	public static void manageTestConfigEquationTableActionDeletePopupOkbutton() throws InterruptedException, IOException {
				NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests",8);
				
				//click
				actionDeleteIconClick();
				
				// LOGOUT
				Logout.LogoutFunction();
				
	}
	public static void actionDeleteIconCancelButtonFunction(){
		try {
	        if (ManageTestsPage.DeleteCancelButton.isDisplayed()) {
	            testCase = extent.createTest("STEP-01--Cancel Button IS DISPLAYED");
	            testCase.log(Status.PASS, "TEST PASS ☑");
	            if (ManageTestsPage.DeleteCancelButton.isEnabled()) {
	                testCase = extent.createTest("STEP-02--Cancel Button IS ENABLED");
	                testCase.log(Status.PASS, "TEST PASS ☑");
	                ManageTestsPage.DeleteCancelButton.click();
	            } else {
	                testCase = extent.createTest("STEP-02--Cancel Button IS NOT ENABLED");
	                testCase.log(Status.FAIL, "TEST FAIL ❎");
	            }
	        } else {
	            testCase = extent.createTest("STEP-01--Cancel Button IS NOT DISPLAYED");
	            testCase.log(Status.FAIL, "TEST FAIL ❎");
	        }
	    } catch (Exception e) {
	        // TODO: handle exception
	    }
	}
	public static void actionDeleteIconClick() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir")
						+ "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Manage_Tests", "MTC-MT-267");

		XSSFRow row = sheet.getRow(firstrow);

		String SearchData = (String) row.getCell(2).getStringCellValue();
		try {
		driver.findElement(By.xpath("//td[text()='"+SearchData+"']//following-sibling::td[16]/span/a[2]/a/span")).click();
		actionDeleteIconCancelButtonFunction();
		}
		catch (NoSuchElementException e) {
            testCase = extent.createTest("Checking The Deleteicon");
            testCase.log(Status.INFO, "Unable to Click on the element 'Deleteicon'");
            testCase.log(Status.FAIL, "TEST FAIL ❎");
        }
        catch (ElementClickInterceptedException e) {
        	testCase = extent.createTest("Checking The Deleteicon");
            testCase.log(Status.INFO, "Unable to Click on the element 'Deleteicon'");
            testCase.log(Status.FAIL, "TEST FAIL ❎");
        }
        catch (Exception e) {
        	testCase = extent.createTest("Checking The Deleteicon");
            testCase.log(Status.FAIL, "TEST FAIL ❎"); 
        }
	}

}
