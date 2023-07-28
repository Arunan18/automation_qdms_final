/***********************************************************************************
* Description
*------------
* Production Sample Bulk add Validation
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 09/05/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-PRODUCT-SAM-0215    09/05/2023   Quenthan     Orginal Version
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProductionSampleBulkaddValidation extends DriverIntialization {
	@Test
	public static void validationBulk() throws InterruptedException, IOException {
		ArrayList<String> validationType = new ArrayList<String>();
		ArrayList<String> validationData = new ArrayList<String>();
		ArrayList<String> expactedValue = new ArrayList<String>();
		ArrayList<String> addData = new ArrayList<String>();
		Actions action =new Actions(driver);
		ProductionSampleBulkaddValidation nj=new ProductionSampleBulkaddValidation();
		ProductionSampleAddFunctionalityBulkSendkeys lg = new ProductionSampleAddFunctionalityBulkSendkeys();
		PageFactory.initElements(driver, lg);
		PageFactory.initElements(driver, nj);
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

		PropertiesCommonMethods.excalRowCount("Samples Module.xlsx", "Production Sample", "TC-PRODUCT-SAM-0215-01");
		int I = PropertiesCommonMethods.countRow - 1;
		XSSFSheet sheet = wbook.getSheet("Production Sample");
		 System.out.println(sheet.getLastRowNum()+4);

		for (int j = I; j < sheet.getLastRowNum()+4; j++) {
			row = sheet.getRow(j);
			cell = row.getCell(2);
			String Tatal1 = dataValue.formatCellValue(cell);
			addData.add(Tatal1);
			row = sheet.getRow(j);
			cell = row.getCell(3);
			String Tatal = dataValue.formatCellValue(cell);
			if (Tatal.equals("stop")) {
				break;

			}
			validationType.add(Tatal);
			row = sheet.getRow(j);
			cell = row.getCell(4);
			String srr = dataValue.formatCellValue(cell);
			validationData.add(srr);
			row = sheet.getRow(j);
			cell = row.getCell(5);
			String sdf = dataValue.formatCellValue(cell);
			expactedValue.add(sdf);

		}
		System.out.println(expactedValue);
		System.out.println(validationData);
		System.out.println(validationType);
		System.out.println(addData);
		int kl=2;
		
		for (int p = 1; p < 5; p++) {
			ProductionSampleAddFunctionalityBulkSendkeys.addkey.click();
			Thread.sleep(2000);
			ProductionSampleAddFunctionalityBulkSendkeys.bulkChickBox.click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("(//div[@class='input_wrapperBulk']//input)["+kl+"]"))
					.sendKeys(validationData.get(p));
			ProductionSampleAddFunctionalityBulkSendkeys.saveButton.click();
			Thread.sleep(1000);
			kl=kl+1;
			String err = driver.findElement(By.xpath("(//div[@role='alert'])["+p+"]")).getText();
			Boolean nam=false ;
			try {
				 nam = driver.findElement(By.xpath("//div[@class='ant-modal-header']")).isDisplayed();
			} catch (Exception e) {
				nam=false;
			}
			PropertiesCommonMethods.cTestReports(validationType.get(p), expactedValue.get(p)+",Modal View-"+true, err+",Modal View-"+nam, "Validation");
			try {
				driver.findElement(By.xpath("//span[text()='Cancel']/..")).click();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		
		for (int k = 5; k <validationData.size() ; k++) {
			ProductionSampleAddFunctionalityBulkSendkeys.addkey.click();
			Thread.sleep(2000);
			ProductionSampleAddFunctionalityBulkSendkeys.bulkChickBox.click();
			Thread.sleep(1000);
			ActionCommonMethod.dropdDown(ProductionSampleAddFunctionalityBulkSendkeys.plantTextbox, addData.get(0));
			ActionCommonMethod.dropdDown(ProductionSampleAddFunctionalityBulkSendkeys.finishProductTextBox,addData.get(1));
			ActionCommonMethod.dropdDown(ProductionSampleAddFunctionalityBulkSendkeys.MixDesign, addData.get(2));
			ActionCommonMethod.dropdDown(ProductionSampleAddFunctionalityBulkSendkeys.equipment, addData.get(3));
			ActionCommonMethod.dateS(ProductionSampleAddFunctionalityBulkSendkeys.date, addData.get(4), 1);
			
			driver.findElement(By.xpath("(//span[@class='data-grid-container']//tr)[1]/td[2]")).click();
			action.sendKeys(validationData.get(k)).perform();
			ProductionSampleAddFunctionalityBulkSendkeys.saveButton.click();
			Thread.sleep(1000);
			String moda = null;
			try {
				moda = driver.findElement(By.xpath("(//form[@id='test']/following::div)[1]")).getText();
			} catch (Exception e) {
				// TODO: handle exception
			}
			Boolean nam = false;
			try {
				nam = driver.findElement(By.xpath("//div[@class='ant-modal-header']")).isDisplayed();
			} catch (Exception e) {
				nam = false;
			}
			PropertiesCommonMethods.cTestReports(validationType.get(k), expactedValue.get(k) + ",Modal View-" + true,
					moda + ",Modal View-" + nam, "Validation");
			try {
				driver.findElement(By.xpath("//span[text()='Cancel']/..")).click();
			} catch (Exception e) {
				Thread.sleep(4000);
			} 
		}
		Logout.LogoutFunction();		
				
				
	}
@FindBy(xpath = "(//div[@class='input_wrapper'])[2]//div[@style='color: red; font-size: 12px; width: 160px; height: 0.2px;'][2]")
public static WebElement finishProductErr;

@FindBy(xpath = "(//div[@class='input_wrapper'])[2]//div[@style='color: red; font-size: 12px; width: 160px; height: 0.2px;'][2]")
public static WebElement mixDisErr;
}
