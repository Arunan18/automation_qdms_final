
//****************************************************************************************
//		DESCRIPTION
//------------------
//					 SAMPLE TRAIL STATUS COMMON METHOD FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   16:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* 				  	 16:05:2023     @SASIKALA     Original Version

//*****************************************************************************************

package com.qa.automation.qdms.sample.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;



public class TrailStatusCommonMethod extends DriverIntialization{
	
	static InprocessSamplePage inpropg = new InprocessSamplePage();
	
	static String SampleCode = null;
	static String TestName = null;
	static String statusText = null;
	
		public static void TesttrailStatusChange(String ExcelName, String TabName,String TestCaseID) throws IOException, InterruptedException {
		PageFactory.initElements(driver, inpropg);
		
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + ExcelName + ".xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(TabName);
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + ExcelName + ".xlsx", TabName,
				TestCaseID);
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + ExcelName + ".xlsx", TabName,
				TestCaseID);

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			SampleCode = (String) row.getCell(1).getStringCellValue();
			TestName = (String) row.getCell(2).getStringCellValue();
			statusText = (String) row.getCell(3).getStringCellValue();

	}
		// XPATH SAMPLECODE

				String Code = SampleCode;
//							
				String CodeXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
				String CodeXpath_lastPart = "]/td[1]";
				String TesticonXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
				String TesticonXpath_lastPart = "]/td[18]/span/span";
				
				boolean clickNextPage = true;
				boolean PageExist = false;
				while (clickNextPage) {
					for (int i = 2; i < 103; i++) {
						try {
							String text = driver.findElement(By.xpath(CodeXpath_firstPart + i + CodeXpath_lastPart)).getText();
							System.out.println(text);
							if (text.equals(Code)) {
								PageExist = true;
								driver.findElement(By.xpath(TesticonXpath_firstPart + i + TesticonXpath_lastPart)).click();
								Thread.sleep(2000);
								clickNextPage = false;
								break;
							}
						} catch (Exception e) {
						}
					}
					if (clickNextPage == true) {
						clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
								.isEnabled();
						if (driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled()) {
							driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
							Thread.sleep(2000);
						} else {
							System.out.println("Button Not Enabled");
						}
					} else {
						break;
					}

				}
				if (PageExist = false) {
					System.out.println("No such Element" + PageExist);
				}
			
	// CLICK ON THE TEST
	Thread.sleep(2000);
	driver.findElement(By.xpath(
			"//div[@class='ant-ribbon-wrapper']//li[text()='" + TestName + "']"))
			.click();
	
	//*************************
	try {
		Thread.sleep(1000);
		WebElement mm=driver.findElement(By.xpath("//td[@class='ant-table-cell ant-table-cell-fix-right'][2]"));
		if(mm.isDisplayed()){
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[@class='ant-table-cell ant-table-cell-fix-right'][2]/span/span")).click();
	}
}
	catch (NoSuchElementException e) {
		System.out.println("No To Trail");
	}
			
	
	
		
//	CHECK THE FUNCTIONALITY OF STATUS FIELD
	Thread.sleep(2000);
	if (InprocessSamplePage.trailstatusfield.isDisplayed()) {
		testCase = extent.createTest("STATUS FIELD IS DISPLAYED");
		testCase.log(Status.PASS, "TEST PASS â˜‘");

		if (InprocessSamplePage.trailstatusfield.isEnabled()) {
			testCase = extent.createTest("STATUS FIELD IS ENABLED");
			testCase.log(Status.PASS, "TEST PASS â˜‘");

			WebElement testStatus = InprocessSamplePage.trailstatusfield;

			testStatus.getText();

		} else {
			testCase = extent.createTest("STATUS FIELD IS NOT ENABLED");
			testCase.log(Status.PASS, "TEST FAIL â�Ž");
		}
	} else {
		testCase = extent.createTest("STATUS FIELD IS NOT DISPLAYED");
		testCase.log(Status.PASS, "TEST FAIL â�Ž");
	}
//	VERIFY THE STATUS FIELD FUNCTIONALITY

		String ActualData = driver.findElement(By.id("status")).getAttribute("value");
		String ExpectedData = statusText;
		System.out.println("Status : " + ActualData);
		testCase = extent.createTest("VERIFY THE STATUS FUNCTIONALITY");
		if (ActualData.equals(statusText)) {
			testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
			testCase.log(Status.INFO, "Expectedvalue :- " + ExpectedData);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, ActualData);
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
			testCase.log(Status.INFO, "ExpectedValue :- " + ExpectedData);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, ActualData);
		}

}


}