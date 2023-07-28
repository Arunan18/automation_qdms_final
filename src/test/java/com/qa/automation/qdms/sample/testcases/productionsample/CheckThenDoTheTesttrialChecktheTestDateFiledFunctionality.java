/***********************************************************************************
* Description
*------------
* Check when do the Test trial Check the Test Date Filed Functionality
Check when do the Test trial Check the No of Trial Filed Functionality
Check when do the Test trial Check the Status Filed New  
Check when do the Test trial Check the Submit button Functionality
Check when do the Test trial Check the Test Procedure icon Functionality
Check when do the Test trial Check the Trial button Functionality
Check when do the Test trial Check the Go to Sample Link Functionality
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 11/05/2023
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-PRODUCT-SAM-0287   11/05/2023   Quenthan     Orginal Version
*TC-PRODUCT-SAM-0289
*TC-PRODUCT-SAM-0291
*TC-PRODUCT-SAM-0292
*TC-PRODUCT-SAM-0294
*TC-PRODUCT-SAM-0296
*TC-PRODUCT-SAM-0298     
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class CheckThenDoTheTesttrialChecktheTestDateFiledFunctionality extends DriverIntialization {
	@Test
	public static void funcationalityTest() throws InterruptedException, IOException {

		ArrayList<String> addData = new ArrayList<String>();
		Actions action = new Actions(driver);
		String code1 = null;
		/**********************************************************************************
		 * Get Data From Exceal
		 **********************************************************************************/

		// get data from exceal
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;

		try {
			filelocation = "./src/test/resources/Excel/Samples Module.xlsx";

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			// fileIn.close();

		} catch (Exception e) {

		}

		PropertiesCommonMethods.excalRowCount("Samples Module.xlsx", "Production Sample", "TC-PRODUCT-SAM-0287-01");
		int I = PropertiesCommonMethods.countRow - 1;

		for (int j = 2; j < 20; j++) {
			XSSFSheet sheet = wbook.getSheet("Production Sample");
			row = sheet.getRow(I);
			cell = row.getCell(j);
			String Tatal = dataValue.formatCellValue(cell);
			// System.out.println(Tatal);
			if (Tatal.equals("")) {
				break;

			}
			addData.add(Tatal);

		}
		System.out.println(addData);
		/**********************************************************************************
		 * Navigate Page
		 **********************************************************************************/

		LoginTest.Login();
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.finishProductSampleMainNavigation();
		SampleNavigateTest.productionSampleNavigation();
		Thread.sleep(1000);

		/**********************************************************************************
		 * Step-01--Click Test Result Icon & Click Test
		 **********************************************************************************/
		extent.createTest("Step-01--Click Test Result Icon & Click Test");
		ActionCommonMethod.actionS(0, 17, driver.findElement(By.xpath("//div[@class='ant-table-container']")),
				"Test Status", "Samples Module.xlsx", "Production Sample", "TC-PRODUCT-SAM-0287-01", 1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='" + addData.get(1) + "']")).click();

		/**********************************************************************************
		 * Step-02--Date Field Is Displayed & Enable
		 **********************************************************************************/

		WebElement dete = driver.findElement(By.id("date"));
		ActionCommonMethod.visbleEnable2(dete, "Date Text Box", 02);
		ActionCommonMethod.dateS(dete, addData.get(0), 1);

		/**********************************************************************************
		 * Step-03--No Of Field Is Displayed & Enable
		 **********************************************************************************/

		WebElement noOfTest = driver.findElement(By.id("noOfTrial"));
		ActionCommonMethod.visbleEnable2(noOfTest, "No Of Trails Text Box", 03);
		ActionCommonMethod.sendkey(noOfTest, addData.get(2));

		/**********************************************************************************
		 * Step-04--Status Field Check New
		 **********************************************************************************/
		WebElement status = driver.findElement(By.id("status"));
		PropertiesCommonMethods.cTestReports("Step-04--Status Field Check New", "NEW", status.getAttribute("value"),
				"Status Field");

		/**********************************************************************************
		 * Step-05--Submit Button Is Displayed & Enable
		 **********************************************************************************/
		WebElement submit = driver.findElement(By.xpath("//span[text()='Submit']/.."));
		ActionCommonMethod.visbleEnable2(submit, "Submit Button", 05);
		submit.click();
		Thread.sleep(500);

		/**********************************************************************************
		 * Step-06--Check Submit Button Is Function
		 **********************************************************************************/
		PropertiesCommonMethods.cTestReports("Step-06--Check Submit Button Is Function",
				"Finish Product Test Added SuccessFully",
				driver.findElement(By.xpath("//div[@class='ant-notification-notice-message']")).getText(),
				"Submit Function");
		Thread.sleep(4000);
		/**********************************************************************************
		 * Step-07--Check Procedure Button Is Displayed & Enable Step-08--Check
		 * Procedure Button Funcation
		 **********************************************************************************/
		WebElement proceder = driver.findElement(By.xpath("//div[contains(@class,'ant-col-2')]//*[@fill]"));
		ActionCommonMethod.visbleEnable2(proceder, "Procedure Icon", 07);
		proceder.click();
		Thread.sleep(500);

		PropertiesCommonMethods.cTestReports("Step-08--Check Procedure Button Funcation", "true",
				driver.findElement(By.xpath("//div[text()='Test Procedure']")).isDisplayed(),
				"Proceder Icon Funcation");

		;
		/**********************************************************************************
		 * Add Trail Data
		 **********************************************************************************/
		int ik = 1;
		System.out.println(addData.size());
		for (int j = 3; j < addData.size(); j++) {
			WebElement value = driver.findElement(By.xpath("(//input[@class='ant-input'])[" + ik + "]"));
			value.click();
			value.sendKeys(addData.get(j));
			ik = ik + 1;
			action.sendKeys(Keys.TAB);
		}
		WebElement trail = driver.findElement(By.xpath("//button[contains(.,'Trial')]/.."));

		/**********************************************************************************
		 * Step-09--Check Trail Button Is Displayed & Enable Step-10--Check Trail Button
		 * Funcation
		 **********************************************************************************/
		ActionCommonMethod.visbleEnable2(trail, "Procedure Icon", 9);
		trail.click();
		Thread.sleep(1000);
		PropertiesCommonMethods.cTestReports("Step-10--Check Trail Button Funcation", "true",
				driver.findElement(By.xpath("//*[text()='View Results']/..")).isDisplayed(), "Trail Button Funcation");

		WebElement go = driver.findElement(By.xpath("//a[text()='Go To Samples']"));
		/**********************************************************************************
		 * Step-11--Check Go To Sample Link Is Displayed & Enable Step-12--Check Go To
		 * Sample Link Funcation
		 **********************************************************************************/
		ActionCommonMethod.visbleEnable2(go, "Check Go To Sample Link", 11);
		go.click();
		Thread.sleep(1000);
		PropertiesCommonMethods.cTestReports("Step-12--Check Go To Sample Link Funcation", "true",
				driver.findElement(By.xpath("//div[@class='ant-table-title']//div[text()='Production Sample']"))
						.isDisplayed(),
				"Go To Sample Page");
Logout.LogoutFunction();
	}

}
