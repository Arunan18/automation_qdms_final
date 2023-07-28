/***********************************************************************************
* Description
*------------
* Production Sample Copy Paste Bulk Add Function
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 08/05/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-PRODUCT-SAM-0205    08/05/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProductionSampleCopyPasteBulkAddFunction extends DriverIntialization {
	@Test
	public static void copypast() throws InterruptedException, IOException {
		ArrayList<String> adddata = new ArrayList<String>();
		Actions action=new Actions(driver);
		ArrayList<String> samplecorr = new ArrayList<String>();
		ArrayList<String> productionCode = new ArrayList<String>();
		ProductionSampleAddFunctionalityBulkSendkeys lg = new ProductionSampleAddFunctionalityBulkSendkeys();
		PageFactory.initElements(driver, lg);
		LoginTest.Login();
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.finishProductSampleMainNavigation();
		SampleNavigateTest.productionSampleNavigation();
		Thread.sleep(1500);
		extent.createTest("Step-1--Copy From Table");
		ActionCommonMethod.actionS(0, 24, ProductionSampleAddFunctionalityBulkSendkeys.table,"copy", "Samples Module.xlsx", "Production Sample", "TC-PRODUCT-SAM-0217-01", 1);
		ProductionSampleAddFunctionalityBulkSendkeys.addkey.click();
		Thread.sleep(2000);
		ProductionSampleAddFunctionalityBulkSendkeys.bulkChickBox.click();
		Thread.sleep(1000);
		
		//get data from exceal
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

		PropertiesCommonMethods.excalRowCount("Samples Module.xlsx", "Production Sample", "TC-PRODUCT-SAM-0217-01");
		int I = PropertiesCommonMethods.countRow - 1;

		for (int j = 2; j < 20; j++) {
			XSSFSheet sheet = wbook.getSheet("Production Sample");
			row = sheet.getRow(I);
			cell = row.getCell(j);
			String Tatal = dataValue.formatCellValue(cell);
			if (Tatal == "") {
				break;

			}
			adddata.add(Tatal);
		}
		ProductionSampleAddFunctionalityBulkSendkeys.plantTextbox.click();
		
		for (int j = 0; j < 3; j++) {
			action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
			
		}
		ActionCommonMethod.visbleEnable2(ProductionSampleAddFunctionalityBulkSendkeys.date, "Date Text Box", 2);
		ActionCommonMethod.dateS(ProductionSampleAddFunctionalityBulkSendkeys.date, adddata.get(0), 1);	
		
				for (int l = 1; l <adddata.size(); l++) {
					driver.findElement(By.xpath("(//span[@class='data-grid-container']//tr)[" + l + "]/td[2]")).click();
					action.sendKeys(adddata.get(l)).perform();
				}

				ProductionSampleAddFunctionalityBulkSendkeys.saveButton.click();
				
				Thread.sleep(2000);
//				System.out.println(samplecode);
				List<WebElement> allrow = null;

				int h = 1;
				String fg = null;
				int sd = adddata.size()-1;
				//System.out.println("SAmplelen:- " + sd);
				Boolean nextPage = true;

				while (nextPage == true) {
					Boolean kl = true;
					Thread.sleep(3000);
					allrow = ProductionSampleAddFunctionalityBulkSendkeys.table.findElements(By.cssSelector("tbody tr"));
					int rowe = allrow.size();
//					System.out.println("rows:-"+rowe);
					for (int j = 0; j < rowe; j++) {

						nextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
						fg = allrow.get(j).findElements(By.tagName("td")).get(4).getText();
						String status = driver.findElement(By.xpath("//tr[2]/td[19]//p")).getText();
						System.out.println(status);
						try {
							adddata.get(h);
						} catch (Exception e) {
							nextPage=false;
							h=h-1;
							break;
							
							
						}
						if (fg.equals(adddata.get(h)) & status.equals("NEW")) {
							samplecorr.add(fg);
							h = h + 1;
							String sam = allrow.get(j).findElements(By.tagName("td")).get(0).getText();
							productionCode.add(sam);
							driver.findElement(By.xpath("(//td[contains(@class,'ant-table-cell')])[1]")).click();
							kl = false;
							break;
						}

					}
					if (nextPage == true & kl == true) {
						driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
					}
					

				}
				Object sdd=sd;
				String sdd1String=sdd.toString();
				PropertiesCommonMethods.cTestReports("Add Confiming",sdd1String, h,
						productionCode + "-Production Codes Are Added");
//				
				Logout.LogoutFunction();
					
	}}
