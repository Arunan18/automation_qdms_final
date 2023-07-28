/***********************************************************************************
* Description
*------------
* Test Configure - Configure Test Table-  Top Bar Review Test - Key Test - Material Pop up Screen - "Material" Sub  Heading  Properties
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 10/05/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-TCN-0838            22/06/2023   Quenthan     Orginal Version
*
************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class TestConfiRev_MaterialSubHeadingProperties extends DriverIntialization {
	public static ArrayList<String> adddata = new ArrayList<String>();

	@Test
	public static void propertiesChecking() throws InterruptedException, IOException {
		WebDriverWait wit = new WebDriverWait(driver, 20);

		TestConfiRev_MaterialSubHeadingProperties.navicateAndProperties("Test_Configure", "TC-TCN-0838-01",2);
		
		

		// Click Material View Icon
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Test_Configure", "TC-TCN-0838-01");
		System.out.println(adddata);

		try {
			wit.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//td[text()='" + adddata.get(1)
					+ "']/following-sibling::td[2]//span[contains(@class,'anticon-container')]"))));
			driver.findElement(By.xpath("//td[text()='" + adddata.get(1)
					+ "']/following-sibling::td[2]//span[contains(@class,'anticon-container')]")).click();
		} catch (NoSuchElementException e) {
			PropertiesCommonMethods.cTestReports("Click Material View Icon", true, false, e.toString());
		} catch (ElementClickInterceptedException e) {
			PropertiesCommonMethods.cTestReports("Click Material View Icon", true, false, e.toString());
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Click Material View Icon", true, false, e.toString());
		}
		
//		Check Properties
		propertiesMatrialSubHeading();
		
		
		driver.navigate().refresh();
		Logout.LogoutFunction();

	}
	
	
	

	public static void navicateAndProperties(String tab,String id,int i) throws InterruptedException, IOException {
		TestConfigPage lk = new TestConfigPage();
		PageFactory.initElements(driver, lk);
		WebDriverWait wait=new WebDriverWait(driver, 15);


		// login
		LoginTest.Login();

//		Navicate Test Config
		TestConfigNavigation.TestConfigurationCard();

		try {
			// Navicate Manage Test Config
			wait.until(ExpectedConditions.elementToBeClickable(TestConfigPage.ManageTestConfigMain));
			ActionCommonMethod.visbleEnable2(TestConfigPage.ManageTestConfigMain, "Manage Tests Configure Navication",
					1);
			TestConfigPage.ManageTestConfigMain.click();
		} catch (NoSuchElementException e) {
			PropertiesCommonMethods.cTestReports("Manage Tests Configure Clicking", true, false, e.toString());
		} catch (ElementClickInterceptedException e) {
			PropertiesCommonMethods.cTestReports("Manage Tests Configure Clicking", true, false, e.toString());
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Manage Tests Configure Clicking", true, false, e.toString());
		}
		
		
		
		
		
		try {
			// Navicate Manage Tests
			wait.until(ExpectedConditions.elementToBeClickable(TestConfigPage.manageTestButton));
			ActionCommonMethod.visbleEnable2(TestConfigPage.manageTestButton, "Manage Tests Navication", 2);
			TestConfigPage.manageTestButton.click();

		} catch (NoSuchElementException e) {
			PropertiesCommonMethods.cTestReports("Manage Test Button Clicking", true, false, e.toString());
		} catch (ElementClickInterceptedException e) {
			PropertiesCommonMethods.cTestReports("Manage Test Button Clicking", true, false, e.toString());
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Manage Test Button Clicking", true, false, e.toString());
		}
		
		
//		scroling
		TestConfiRev_MaterialSubHeadingProperties.scrole(TestConfigPage.tableTH);
		
		

//		Click & Navicate Test Configure 
		AddGroupKey.actionS(0, 14, TestConfigPage.mainTable, "Description", "Test Configuration Properties.xlsx",
				tab, id, i);

		try {
			// click Review Test
			wait.until(ExpectedConditions.elementToBeClickable(TestConfigPage.reviewTestButtonS));
			ActionCommonMethod.visbleEnable2(TestConfigPage.reviewTestButtonS, "Review Button", 4);
			TestConfigPage.reviewTestButtonS.click();
		} catch (NoSuchElementException e) {
			PropertiesCommonMethods.cTestReports("Review Test Button Clicking", true, false, e.toString());
		} catch (ElementClickInterceptedException e) {
			PropertiesCommonMethods.cTestReports("Review Test Button Clicking", true, false, e.toString());
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Review Test Button Clicking", true, false, e.toString());
		}

	}
	

	public static void propertiesMatrialSubHeading() {
		
		TestConfigPage lk = new TestConfigPage();
		PageFactory.initElements(driver, lk);
		
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx","Test_Configure", "TC-TCN-0838-02",TestConfigPage.materialPuMheading, "Step-5-- Matriel Sub Heading Properties");
		
		

	}
	
	
	

	public static void scrole(WebElement find) {
		WebDriverWait wait=new WebDriverWait(driver, 10);

		boolean pass = false;
		while (pass == false) {
			if (!pass) {
				try {
					find.click();
					pass = true;
				} catch (Exception e) {
				}
			}
			if (!pass) {

				Actions actions = new Actions(driver);
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//tbody/tr[2]/td[1]"))));
				driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).click();
				actions.sendKeys(Keys.ARROW_RIGHT).perform();

			}

		}

	}

	public static void dataExcel(String tab, String id) {

		adddata.clear();
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;

		try {
			filelocation = "./src/test/resources/Excel/Test Configuration Properties.xlsx";

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);

			PropertiesCommonMethods.excalRowCount("Test Configuration Properties.xlsx", tab, id);
			int I = PropertiesCommonMethods.countRow - 1;

			for (int j = 2; j < 20; j++) {
				XSSFSheet sheet = wbook.getSheet(tab);
				row = sheet.getRow(I);
				cell = row.getCell(j);
				String Total = dataValue.formatCellValue(cell);
				if (Total == "") {
					break;

				}
				adddata.add(Total);

			}

		} catch (Exception e) {
			testCase = extent.createTest("Check The Excel Name Or Tab Name");
			testCase.log(Status.INFO, "Excel is not available ");
			testCase.log(Status.FAIL, "Excel is not Found");

		}

	}

}
