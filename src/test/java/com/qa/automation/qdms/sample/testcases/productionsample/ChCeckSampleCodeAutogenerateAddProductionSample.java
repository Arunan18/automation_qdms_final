/***********************************************************************************
* Description
*------------
* Check Sample Code Autogenerate Add Production Sample
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 05/05/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-PRODUCT-SAM-0205    05/05/2023   Quenthan     Orginal Version
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

public class ChCeckSampleCodeAutogenerateAddProductionSample extends DriverIntialization {
	@Test
	public static void autogenarate() throws InterruptedException, IOException {
		ArrayList<String> adddata = new ArrayList<String>();
		ArrayList<String> vehicle = new ArrayList<String>();
		ArrayList<String> samplecode = new ArrayList<String>();
		ArrayList<String> workOrderNo = new ArrayList<String>();
		ArrayList<String> search1 = new ArrayList<String>();
		ArrayList<Integer> lastnum = new ArrayList<Integer>();
		int max=0;
		int olk=0;
		Actions action = new Actions(driver);
		ProductionSampleAddFunctionalityBulkSendkeys lg = new ProductionSampleAddFunctionalityBulkSendkeys();
		PageFactory.initElements(driver, lg);
		LoginTest.Login();
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.finishProductSampleMainNavigation();
		SampleNavigateTest.productionSampleNavigation();
		Thread.sleep(2000);

		
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

		PropertiesCommonMethods.excalRowCount("Samples Module.xlsx", "Production Sample", "TC-PRODUCT-SAM-0205-01");
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
				if (code.contains(adddata.get(11))) {
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

		ProductionSampleAddFunctionalityBulkSendkeys.addkey.click();

		Thread.sleep(2000);
		ProductionSampleAddFunctionalityBulkSendkeys.bulkChickBox.click();
		Thread.sleep(1000);
		

//		System.out.println(adddata);
		// Step1 Plant TExt Box Visible, Enable
		ActionCommonMethod.visbleEnable2(ProductionSampleAddFunctionalityBulkSendkeys.plantTextbox, "Plant Text Box",
				1);
		ActionCommonMethod.dropdDown(ProductionSampleAddFunctionalityBulkSendkeys.plantTextbox, adddata.get(0));

		// Step2 FinishProduct Text Box Visible, Enable
		ActionCommonMethod.visbleEnable2(ProductionSampleAddFunctionalityBulkSendkeys.finishProductTextBox,
				"FinishProduct Text Box", 2);
		ActionCommonMethod.dropdDown(ProductionSampleAddFunctionalityBulkSendkeys.finishProductTextBox, adddata.get(1));

		// Step3 Mix Desine Text Box Visible, Enable
		ActionCommonMethod.visbleEnable2(ProductionSampleAddFunctionalityBulkSendkeys.MixDesignt, "Mix Desine Text Box",
				3);
		ActionCommonMethod.dropdDown(ProductionSampleAddFunctionalityBulkSendkeys.MixDesign, adddata.get(2));

		// Step4 Equipment Text Box Visible, Enable
		ActionCommonMethod.visbleEnable2(ProductionSampleAddFunctionalityBulkSendkeys.equipment, "Equipment Text Box",
				4);
		ActionCommonMethod.dropdDown(ProductionSampleAddFunctionalityBulkSendkeys.equipment, adddata.get(3));

		// Step5 Date Text Box Visible, Enable
		ActionCommonMethod.visbleEnable2(ProductionSampleAddFunctionalityBulkSendkeys.date, "Date Text Box", 5);
		ActionCommonMethod.dateS(ProductionSampleAddFunctionalityBulkSendkeys.date, adddata.get(4), 1);

		// Step6 Customer Text Box Visible, Enable
		ActionCommonMethod.visbleEnable2(ProductionSampleAddFunctionalityBulkSendkeys.customerTextBox,
				"Customer Text Box", 6);
		ActionCommonMethod.dropdDown(ProductionSampleAddFunctionalityBulkSendkeys.customerTextBox, adddata.get(5));

		// Step7 Project Text Box Visible, Enable
		ActionCommonMethod.visbleEnable2(ProductionSampleAddFunctionalityBulkSendkeys.projectTextBox,
				"Project Text Box", 7);
		ActionCommonMethod.dropdDown(ProductionSampleAddFunctionalityBulkSendkeys.projectTextBox, adddata.get(6));

		// Step8 Delivery Text Box Visible, Enable
		ActionCommonMethod.visbleEnable2(ProductionSampleAddFunctionalityBulkSendkeys.DeliveryTextBox,
				"Delivery Text Box", 8);
		ActionCommonMethod.dropdDown(ProductionSampleAddFunctionalityBulkSendkeys.DeliveryTextBox, adddata.get(7));

		// Step9 Production date Text Box Visible, Enable
		ActionCommonMethod.visbleEnable2(ProductionSampleAddFunctionalityBulkSendkeys.ProductiondateTextBox,
				"Production date Text Box", 9);
		ActionCommonMethod.dateS(ProductionSampleAddFunctionalityBulkSendkeys.ProductiondateTextBox, adddata.get(8), 2);

		// Step10 Creation Date Text Box Visible, Enable
		ActionCommonMethod.visbleEnable2(ProductionSampleAddFunctionalityBulkSendkeys.CreationDatedateTextBox,
				"Creation Date Text Box", 10);
		ActionCommonMethod.dateS(ProductionSampleAddFunctionalityBulkSendkeys.CreationDatedateTextBox, adddata.get(9),
				3);

		// Step11 Creation Date Text Box Visible, Enable
		ActionCommonMethod.visbleEnable2(ProductionSampleAddFunctionalityBulkSendkeys.CreationDatedateTextBox,
				"Commodity Text Box", 11);
		ActionCommonMethod.sendkey(ProductionSampleAddFunctionalityBulkSendkeys.commodityTextBox, adddata.get(10));

		// get sample Time
		

		// add bulk
		XSSFSheet sheet = wbook.getSheet("Production Sample");
		int allrows = sheet.getLastRowNum() + 2;
	//	System.out.println(allrows);
		int lk = 1;
		for (int j = I + 2; j < allrows; j++) {

			row = sheet.getRow(j);
			cell = row.getCell(2);
			String d1 = dataValue.formatCellValue(cell);
			if (d1.equals("stop")) {
				break;

			}
			row = sheet.getRow(j);
			cell = row.getCell(3);
			String d2 = dataValue.formatCellValue(cell);
			row = sheet.getRow(j);
			cell = row.getCell(4);
			String d3 = dataValue.formatCellValue(cell);

			driver.findElement(By.xpath("(//span[@class='data-grid-container']//tr)[" + lk + "]/td[1]")).click();
			action.sendKeys(d1).perform();
			workOrderNo.add(d1);
			driver.findElement(By.xpath("(//span[@class='data-grid-container']//tr)[" + lk + "]/td[2]")).click();
			action.sendKeys(d2).perform();
			
			driver.findElement(By.xpath("(//span[@class='data-grid-container']//tr)[" + lk + "]/td[3]")).click();
			action.sendKeys(d3).perform();
			vehicle.add(d3);
			lk = lk + 1;
		}

		ProductionSampleAddFunctionalityBulkSendkeys.saveButton.click();

		Thread.sleep(2000);
		
//		System.out.println(samplecode);
		List<WebElement> allrow = null;

		int sd = vehicle.size();
		//System.out.println("SAmplelen:- " + sd);
		Boolean nextPage = true;

		while (nextPage == true) {
			Thread.sleep(4000);
			allrow = ProductionSampleAddFunctionalityBulkSendkeys.table.findElements(By.cssSelector("tbody tr"));
			int rowe = allrow.size();
//			System.out.println("rows:-"+rowe);
			for (int j = 0; j < rowe; j++) {

				nextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
				
				String sam = allrow.get(j).findElements(By.tagName("td")).get(4).getText();
				
				if (sam.equals(search1.get(olk))) {
					nextPage=false;
					break;
					
				}
							
			if (sam.contains(adddata.get(11))) {
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
		Object sdd=sd;
		String sdd1String=sdd.toString();
		PropertiesCommonMethods.cTestReports("Add Confiming & Autogenerate Confirming",sdd1String, samplecode.size(),
				samplecode + "-Sample Codes Are Autogenerate");

Logout.LogoutFunction();
		
	}
	

}
