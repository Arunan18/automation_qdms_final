package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;

public class AddTestEquation extends DriverIntialization {
	public static String comment=null;
	public static WebElement id=null;
	public static String TEST=null;
	
	public void AddTestEquation(String name, String ExcelTabName, String TestcaseId) throws IOException, InterruptedException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + name + ".xlsx";
		boolean Value1 = false;
		int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
		int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(ExcelTabName);
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow rowk = sheet.getRow(i);

			String	parameter = rowk.getCell(1).getStringCellValue();
			String resultsE = rowk.getCell(2).getStringCellValue();
			String TESTparameter = rowk.getCell(3).getStringCellValue();
			String EQUATION = rowk.getCell(4).getStringCellValue();
			
			
			
			Thread.sleep(5000);
			// ********equation type********
			WebElement pharameter = driver.findElement(By.xpath("//input[@value='INPUT']"));
			WebElement results = driver.findElement(By.xpath("//input[@value='INPUT']"));
			if (parameter.equals("true")) {
				WebElement id=pharameter;
				String comment = "PARAMETER";
				String TEST = parameter;
				
			}
			if (resultsE.equals("true")) {
				WebElement id=results;
				String comment = "RESULT";
				String TEST = resultsE;
			}
			
			
			try {
				
				boolean value1 = id.isDisplayed();
				SampleCommonMethods.TestCasePrint(comment+"RADIO BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("TEST RADIO BUTTON IS ENABLED", "true", String.valueOf(value2));
				Thread.sleep(2000);
				boolean value3 = id.isSelected();
				String v3=String.valueOf(value3);
				SampleCommonMethods.TestCasePrint("TEST RADIO BUTTON IS SELECTED", "false", String.valueOf(value3));
				if (TEST.equals(v3)) {

				}

				else {
					id.click();
				}

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("TEST RADIO BUTTON IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			
			
			
			Thread.sleep(3000);
			
			boolean isExist = false;
			// ******TEST parameter**********
			try {
				WebElement id = driver
						.findElement(By.xpath("//span[@class='ant-select-selection-item']"));
				boolean value1 = id.isDisplayed();
				SampleCommonMethods.TestCasePrint("PARAMETER DROP DOWN IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("PARAMETER DROP DOWN IS ENABLED", "true", String.valueOf(value2));
				id.click();
				// *********************************************************
				Actions actions = new Actions(driver);
				try {
					boolean pass = false;
					Thread.sleep(1000);

					for (int i1 = 0; i1 < 1000; i1++) {
						if (!pass) {
							try {
								WebElement list = driver
										.findElement(By.xpath("//div[contains(@title,'" + TESTparameter + "')]//div[1]"));
								System.out.println(list);
								list.click();

								pass = true;
							} catch (Exception e) {
							}
						}

						if (!pass) {
							actions.sendKeys(Keys.ARROW_DOWN).perform();
							Thread.sleep(2);
						} else {
							break;
						}

					}
				} catch (Exception e) {
				}
			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("PARAMETER DROP DOWN IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			Thread.sleep(3000);
			try {
				WebElement id = driver.findElement(By.xpath("//textarea[@class='ant-input equation_playground textEmph']"));
				boolean value1 = id.isDisplayed();
				SampleCommonMethods.TestCasePrint("PREFIX TEXT BOX IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("PREFIX TEXT BOX IS ENABLED", "true", String.valueOf(value2));
				id.click();
				id.clear();
				id.sendKeys(EQUATION);

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("PREFIX TEXT BOX IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			Thread.sleep(3000);
			try {
				WebElement element= driver.findElement(By.xpath("//span[normalize-space()='Save Equation']"));
				boolean value1 = element.isDisplayed();
				SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = element.isEnabled();
				SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS ENABLED", "true", String.valueOf(value2));
				element.click();

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS NOT THERE ", "true", String.valueOf(Value1), String.valueOf(e));

			}
			//*******excel end
		}
		
	}
	
	

}
