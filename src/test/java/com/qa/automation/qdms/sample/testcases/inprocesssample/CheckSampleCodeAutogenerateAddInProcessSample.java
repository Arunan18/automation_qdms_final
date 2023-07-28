/***********************************************************************************
* Description
*------------
* in progress sample Bulk Add Sample code Autogenerate
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 10/05/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
  TC-PRO-SAM-0231   10/05/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.inprocesssample;

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
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class CheckSampleCodeAutogenerateAddInProcessSample extends DriverIntialization{
	@Test
	public static void autogenerate() throws InterruptedException, IOException {
		InprocessSamplePage njk=new InprocessSamplePage();
		DataFormatter dataValue = new DataFormatter();
		ArrayList<String> datsD= new ArrayList<String>();
		ArrayList<String>search1 =new ArrayList<String>();
		ArrayList<Integer>lastnum=new ArrayList<Integer>();
		ArrayList<String>samplecode=new ArrayList<String>();
		Actions action=new Actions(driver);
		int max=0;
		int olk=0;
		
		PageFactory.initElements(driver,njk );
		
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Process Sample");
		PropertiesCommonMethods.excalRowCount("Samples Module.xlsx", "Process Sample", "TC-PRO-SAM-0231-01");
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

		
		SampleNavigateTest.sampleNavigation();
	
		SampleNavigateTest.rawMaterialSampleMainNavigation();
		SampleNavigateTest.inprocessSampleNavigation();
		
        Thread.sleep(1000);
//Get Last Add Auto Genarate Sample Code
		//Get Last Auto Genarate Code
		Boolean nextPage2=true;
		List<WebElement> allrow2 = null;
		
		
		while (nextPage2==true) {
			Thread.sleep(2000);
			allrow2 = driver.findElement(By.xpath("//div[@class='ant-spin-container']")).findElements(By.cssSelector("tbody tr"));
			int rowe2 = allrow2.size();
			for (int jl = 0; jl < rowe2; jl++) {
				nextPage2 = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				String code = allrow2.get(jl).findElements(By.tagName("td")).get(10).getText();
				if (code.contains(datsD.get(1))) {
					String coder = allrow2.get(jl).findElements(By.tagName("td")).get(10).getText();
					search1.add(coder);
					String codes[]=code.split("-");
					
					int codeI=Integer.parseInt(codes[3]);
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
		ActionCommonMethod.actionS(0, 20, driver.findElement(By.xpath("//div[@class='ant-spin-container']")),"copy", "Samples Module.xlsx", "Process Sample", "TC-PRO-SAM-0231-01", 1);
		
//		past data
		InprocessSamplePage.addProcessSample.click();
		
		Thread.sleep(1000);

		InprocessSamplePage.planttextbox.click();
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		driver.findElement(By.xpath("//*[text()='Save']/..")).click();
		
		Thread.sleep(2000);
		
		//Confirm auto genate
		
		Boolean nextPage = true;
		List<WebElement> allrow = null;
		while (nextPage == true) {
			Thread.sleep(4000);
			allrow = driver.findElement(By.xpath("//div[@class='ant-spin-container']")).findElements(By.cssSelector("tbody tr"));
			int rowe = allrow.size();
//			System.out.println("rows:-"+rowe);
			for (int j = 0; j < rowe; j++) {

				nextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
				
				String sam = allrow.get(j).findElements(By.tagName("td")).get(10).getText();
				
				if (sam.equals(search1.get(olk))) {
					nextPage=false;
					break;
					
				}
							
			if (sam.contains(datsD.get(1))) {
				String sam1[]=sam.split("-");
				int sam11=Integer.parseInt(sam1[3]);
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
