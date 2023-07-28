//****************************************************************************************
//		DESCRIPTION
//------------------
//					 SAMPLE ENABLE / DISABLE COMMON METHOD FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   10:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* 				  	 10:05:2023     @SASIKALA     Original Version

//*****************************************************************************************


package com.qa.automation.qdms.sample.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;

public class SampleCheckEnableDisableKeyTest extends DriverIntialization {
	static IncomingSamplePage Incomepg = new IncomingSamplePage();
	static String value = null;
	static String ane = null;
	static boolean set = true;
	static String CodeNumber = null;
	static String ExpectedStatus = null;

//***********************************ENABLE DISABLE COMMON METHOD KEY TEST*****************************************************************
	public static void CheckEnableDisableKeyMethod(String exname, String tabname, String testID,int a,int s,int b)
			throws InterruptedException, IOException {
		ArrayList<String> ena = new ArrayList<String>();
		PageFactory.initElements(driver, Incomepg);

// *******************************************EXCEl**********************************************
		
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + exname + ".xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(tabname);

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + exname + ".xlsx", tabname, testID);
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + exname + ".xlsx", tabname, testID);
		for (int j = firstrow; j <= lastrow; j++) {
			XSSFRow row = sheet.getRow(j);

			CodeNumber = row.getCell(1).getStringCellValue();
			}

		
// ******************************************XPATH Code Select**********************************************
		Thread.sleep(3000);
		String Code = CodeNumber;
		String CodeXpath_firstPart = "//tbody[@class='ant-table-tbody']/tr[";
		String CodeXpath_lastPart = "]/td[";
		String CodeXpathEnd="]";
		String KeyiconXpath_firstPart = "//tbody[@class='ant-table-tbody']/tr[";
		String KeyiconXpath_lastPart = "]/td[";
		String KeyIconXpathEndPart ="]/span/span";
		String StatusXpath_firstPart = "//tbody[@class='ant-table-tbody']/tr[";
		String StatusXpath_lastPart = "]/td[";
	    String StatusXpathEnd = "]";
		
//**********************************************KEY TEST ICON*************************************************							
		boolean clickNextPage = true;
		boolean SampleExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
				//	Thread.sleep(2000);
					String text = driver.findElement(By.xpath(CodeXpath_firstPart + i + CodeXpath_lastPart+ a + CodeXpathEnd)).getText();
					System.out.println(text);
					if (text.equals(Code)) {
						SampleExist = true;
						Thread.sleep(i);
						value = driver.findElement(By.xpath(StatusXpath_firstPart + i + StatusXpath_lastPart + b +StatusXpathEnd))
								.getText();

						System.out.println(value);
												
						if(driver.findElement(By.xpath(KeyiconXpath_firstPart + i + KeyiconXpath_lastPart+ s +KeyIconXpathEndPart)).isDisplayed()){
							testCase = extent.createTest("SAMPLE KEY ICON BUTTON VISIBLE");
							testCase.log(Status.PASS, "TEST PASS");
							if (driver.findElement(By.xpath(KeyiconXpath_firstPart + i + KeyiconXpath_lastPart+ s +KeyIconXpathEndPart)).isEnabled()) {
								testCase = extent.createTest("SAMPLE KEY ICON BUTTON ENABLED");
								testCase.log(Status.PASS, "TEST PASS");
								try {
									driver.findElement(By.xpath(KeyiconXpath_firstPart + i + KeyiconXpath_lastPart+ s +KeyIconXpathEndPart)).click();
									Thread.sleep(2000);
								} catch (Exception e) {

								}

							} else {
								testCase = extent.createTest("SAMPLE KEY ICON BUTTON ENABLED");
								testCase.log(Status.PASS, "TEST FAIL");
							}
						} else {
							testCase = extent.createTest("SAMPLE KEY ICON BUTTON VISIBLE");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
			
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
		if (SampleExist = false) {
			System.out.println("No such Element" + SampleExist);
		}

//*************************************Disable / Enable Check************************************

		WebElement relaventTable = driver.findElement(By.className("ant-modal-content"));
		List<WebElement> allrows = relaventTable.findElements(By.cssSelector("tbody tr"));
		// checking can clickable
		allrows.size();
		for (int ik = 1; ik < allrows.size(); ik++) {
			List<WebElement> rows = allrows.get(ik).findElements(By.tagName("td"));
			Boolean colum_3af1 = rows.get(2).findElement(By.id("status")).isEnabled();
			String aa = String.valueOf(colum_3af1);
			ena.add(aa);
		}
		System.out.println(ena);

//*******************IF CONDITION - PASS FAIL OR NEW PROCESS STATUS CHECK*******************************
		
		if (value.equals("PASS") || value.equals("FAIL")) {
			for (int k = 0; k < ena.size(); k++) {
				String aa = ena.get(k);
				System.err.println(aa);
				if (aa.equalsIgnoreCase("false")) {
					set = true;
				} else {
					set = false;
					break;
				}
				if (set = false) {
					break;
				}
			}

			Thread.sleep(2000);
			testCase = extent.createTest("SAMPLE KEY TEST ALL CHECKBOX DISABLE- SAMPLE ALREADY CONDUCTED");
			if (set = true) {
				testCase.log(Status.INFO, "SAMPLE STATUS: "+value);
				testCase.log(Status.PASS, "Correct Text");
			} else {
			System.err.println("SAMPLE KEY TEST ALL CHECKBOX ENABLE- SAMPLE ALREADY NOT CONDUCTED");
			testCase.log(Status.INFO, "SAMPLE STATUS: "+value);
				testCase.log(Status.FAIL, "wrong Text");
			}

			} else {
			if (value.equals("NEW") || value.equals("PROCESS")) {
				for (int k = 0; k < ena.size(); k++) {
					String aa = ena.get(k);
					System.err.println(aa);
					if (aa.equalsIgnoreCase("true")) {
						set = true;
					} else {
						set = false;
						break;
					}
					if (set = false) {
						break;
					}
				}
				System.out.println("!!!!!!!!!!");
				Thread.sleep(2000);
				testCase = extent.createTest("SAMPLE KEY TEST ALL CHECKBOX ENABLE- SAMPLE NOT CONDUCTED");
				if (set = true) {
					testCase.log(Status.INFO, "SAMPLE STATUS: "+value);
					testCase.log(Status.PASS, "Correct Text");
				
				} else {
				System.err.println("SAMPLE KEY TEST ALL CHECKBOX DISABLE- SAMPLE ALREADY CONDUCTED");
				testCase.log(Status.INFO, "SAMPLE STATUS: "+value);
					testCase.log(Status.FAIL, "wrong Text");
				}

			}

		}

	}
}
