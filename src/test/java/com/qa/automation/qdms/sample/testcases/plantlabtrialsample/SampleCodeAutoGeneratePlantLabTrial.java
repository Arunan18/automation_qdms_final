//***********************************************************************************
//* Description
//*------------
//* Checking sample code auto generate in Plant Lab Trial Sample
//***********************************************************************************
//*
//* Author           : S.Quenthan
//* Date Written     : 10/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-P-LAB-SAM-0162     10/05/2023   Sayan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.testcases.productionsample.ProductionSampleAddFunctionalityBulkSendkeys;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class SampleCodeAutoGeneratePlantLabTrial extends DriverIntialization {

	static PlantLabTrailSamplePage PlantLabTrailSamplePg = new PlantLabTrailSamplePage();
	
	@Test
	public static void autogenerateSampleCode() throws InterruptedException, IOException {
		DataFormatter dataValue = new DataFormatter();
		ArrayList<String> datsD= new ArrayList<String>();
		ArrayList<String>search1 =new ArrayList<String>();
		ArrayList<Integer>lastnum=new ArrayList<Integer>();
		ArrayList<String>samplecode=new ArrayList<String>();
		Actions action=new Actions(driver);
		int max=0;
		int olk=0;
		
		PageFactory.initElements(driver, PlantLabTrailSamplePg);
		
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Plant Lab Trial Sample");
		int rowcount = sheet.getLastRowNum();
		PropertiesCommonMethods.excalRowCount("Samples Module.xlsx", "Plant Lab Trial Sample", "TC-P-LAB-SAM-0162-01");
		int I = PropertiesCommonMethods.countRow - 1;
	
		for (int i = 1; i <= 20; i++) {
			XSSFRow row = sheet.getRow(I);
			XSSFCell cell = row.getCell(i);
			String datas= dataValue.formatCellValue(cell);
			if (datas.equals("")) {
				break;
			}
			datsD.add(datas);
 
		}
		System.out.println(datsD);

		LoginTest.Login();

//		NAVIGATE TO THE PLANT lAB TRIAL PAGE
//		--------------------------------------

		
		PlantLabTrailSamplePage.Sample.click();

	
		PlantLabTrailSamplePage.FinishProductTopbar.click();

	
		PlantLabTrailSamplePage.PlantLabTrialSample.click();
		
        
//Get Last Add Auto Genarate Sample Code
		//Get Last Auto Genarate Code
		Boolean nextPage2=true;
		List<WebElement> allrow2 = null;
		
		
		while (nextPage2==true) {
			Thread.sleep(2000);
			allrow2 = PlantLabTrailSamplePage.Table.findElements(By.cssSelector("tbody tr"));
			int rowe2 = allrow2.size();
			for (int jl = 0; jl < rowe2; jl++) {
				nextPage2 = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				String code = allrow2.get(jl).findElements(By.tagName("td")).get(4).getText();
				if (code.contains(datsD.get(2))) {
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
		//Coppy data
		extent.createTest("Step-1--Copy From Table");
		ActionCommonMethod.actionS(4, 14, PlantLabTrailSamplePage.Table,"copy", "Samples Module.xlsx", "Plant Lab Trial Sample", "TC-P-LAB-SAM-0162-01", 1);
		
//		past data
		PlantLabTrailSamplePage.addPlantLabTrailButton.click();
		
		Thread.sleep(1000);

		PlantLabTrailSamplePage.PlantTextbox.click();
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		ActionCommonMethod.dateS(PlantLabTrailSamplePage.SampledateTextbox, datsD.get(1), 1);
		driver.findElement(By.xpath("//*[text()='Save']/..")).click();
		
		Thread.sleep(2000);
		
		//Confirm auto genate
		
		Boolean nextPage = true;
		List<WebElement> allrow = null;
		while (nextPage == true) {
			Thread.sleep(4000);
			allrow = PlantLabTrailSamplePage.Table.findElements(By.cssSelector("tbody tr"));
			int rowe = allrow.size();
//			System.out.println("rows:-"+rowe);
			for (int j = 0; j < rowe; j++) {

				nextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
				
				String sam = allrow.get(j).findElements(By.tagName("td")).get(4).getText();
				
				if (sam.equals(search1.get(olk))) {
					nextPage=false;
					break;
					
				}
							
			if (sam.contains(datsD.get(2))) {
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
		Object sdd=1;
		String sdd1String=sdd.toString();
		PropertiesCommonMethods.cTestReports("Add Confiming & Autogenerate Confirming",sdd1String, samplecode.size(),
				samplecode + "-Sample Code Is Autogenerate");
		Logout.LogoutFunction();
	
		
		

	}

}
