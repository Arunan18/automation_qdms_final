/***********************************************************************************
* Description
*------------
* Production Sample Copy Paste Bulk Add Sample code Autogenerate
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 09/05/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-PRODUCT-SAM-0219    09/05/2023   Quenthan     Orginal Version
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

public class ProductionSampleCopyPasteBulkAddSamplecodeAutogenerate extends DriverIntialization {
	@Test
	public static void autoGenarate() throws InterruptedException, IOException {
		ArrayList<Integer> lastnum = new ArrayList<Integer>();
		ArrayList<String> adddata = new ArrayList<String>();
		ArrayList<String> search1 = new ArrayList<String>();
		ArrayList<String> samplecode = new ArrayList<String>();
		int max=0;
		int olk=0;
		
		Actions action=new Actions(driver);
		ProductionSampleAddFunctionalityBulkSendkeys lg = new ProductionSampleAddFunctionalityBulkSendkeys();
		PageFactory.initElements(driver, lg);
		LoginTest.Login();
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.finishProductSampleMainNavigation();
		SampleNavigateTest.productionSampleNavigation();
		Thread.sleep(1500);
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

				PropertiesCommonMethods.excalRowCount("Samples Module.xlsx", "Production Sample", "TC-PRODUCT-SAM-0219-01");
				int I = PropertiesCommonMethods.countRow - 1;

				for (int j = 2; j < 20; j++) {
					XSSFSheet sheet = wbook.getSheet("Production Sample");
					row = sheet.getRow(I);
					cell = row.getCell(j);
					String Tatal = dataValue.formatCellValue(cell);
					System.out.println(Tatal);
					if (Tatal == "") {
						break;

					}
					adddata.add(Tatal);
					System.out.println(adddata);
				}
		//Get Last Auto Genarate Code
		Boolean nextPage2=true;
		List<WebElement> allrow2 = null;
		
		
		while (nextPage2==true) {
			Thread.sleep(2000);
			allrow2 = ProductionSampleAddFunctionalityBulkSendkeys.table.findElements(By.cssSelector("tbody tr"));
			int rowe2 = allrow2.size();
			for (int jl = 0; jl < rowe2; jl++) {
				nextPage2 = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				String code = allrow2.get(jl).findElements(By.tagName("td")).get(4).getText();
				if (code.contains(adddata.get(1))) {
					String coder = allrow2.get(jl).findElements(By.tagName("td")).get(4).getText();
					search1.add(coder);
					String codes[]=code.split("-");
					
					int codeI=Integer.parseInt(codes[4]);
					lastnum.add(codeI);
//					System.out.println("last number:-"+codeI);
					
				}

			} 
			
			if (nextPage2==true) {
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
				.click();
			} 
			
			
		}
		 max=lastnum.get(0);
		 int run =lastnum.size();
		 System.out.println(run);
		for ( int ol = 1; ol < run; ol++) {
		    if (lastnum.get(ol) > max) {
		        max = lastnum.get(ol);
		        olk=ol;
		    }
		}
		System.out.println("max number:-"+max);
		System.out.println(search1.get(olk));
        driver.navigate().refresh();
		Thread.sleep(1500);
		extent.createTest("Step-1--Copy From Table");
		ActionCommonMethod.actionS(0, 24, ProductionSampleAddFunctionalityBulkSendkeys.table,"copy", "Samples Module.xlsx", "Production Sample", "TC-PRODUCT-SAM-0219-01", 1);
		ProductionSampleAddFunctionalityBulkSendkeys.addkey.click();
		Thread.sleep(2000);
		ProductionSampleAddFunctionalityBulkSendkeys.bulkChickBox.click();
		Thread.sleep(1000);
		
		
		
			ProductionSampleAddFunctionalityBulkSendkeys.plantTextbox.click();
			
			for (int lo = 0; lo < 3; lo++) {
				action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
				
			}
			ActionCommonMethod.visbleEnable2(ProductionSampleAddFunctionalityBulkSendkeys.date, "Date Text Box", 2);
			ActionCommonMethod.dateS(ProductionSampleAddFunctionalityBulkSendkeys.date, adddata.get(0), 1);	
			
		Boolean	full=true;
		int lp=1;
			while (full==true) {
			String data=	driver.findElement(By.xpath("(//span[@class='data-grid-container']//tr)[" + lp + "]/td[1]")).getText();
			lp=lp+1;
				if (data=="") {
					full=false;
				}
			}
			ProductionSampleAddFunctionalityBulkSendkeys.saveButton.click();

			Thread.sleep(2000);
			
			System.out.println(lp-2);
			
			Boolean nextPage = true;
			List<WebElement> allrow = null;
			while (nextPage == true) {
				Thread.sleep(4000);
				allrow = ProductionSampleAddFunctionalityBulkSendkeys.table.findElements(By.cssSelector("tbody tr"));
				int rowe = allrow.size();
//				System.out.println("rows:-"+rowe);
				for (int j = 0; j < rowe; j++) {

					nextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
					
					String sam = allrow.get(j).findElements(By.tagName("td")).get(4).getText();
					
					if (sam.equals(search1.get(olk))) {
						nextPage=false;
						break;
						
					}
								
				if (sam.contains(adddata.get(1))) {
					String sam1[]=sam.split("-");
					int sam11=Integer.parseInt(sam1[4]);
					if (sam11 > max) {
						samplecode.add(sam);
					}
					
				}
								

				}
				if (nextPage == true ) {
					driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				}
				

			}
			Object sdd=lp-2;
			String sdd1String=sdd.toString();
			PropertiesCommonMethods.cTestReports("Add Confiming & Autogenerate Confirming",sdd1String, samplecode.size(),
					samplecode + "-Sample Codes Are Autogenerate");
			Logout.LogoutFunction();
			
	}
	}

