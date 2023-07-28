package com.qa.automation.qdms.testconfig.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;

public class Addaditionalinformation extends DriverIntialization{
	static DataFormatter dataValue=new DataFormatter();
	/* Add Data Method */
	public static void adddata(String name, String ExcelTabName, String TestcaseId) throws IOException, InterruptedException {
		
		Boolean click = true;
		WebElement	select=null;
		WebElement list1=null;
		WebElement list2=null;
		WebElement list=null;
		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\"+name+".xlsx";
		

		int firstRow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");
		boolean Value1 = false;
		int l=1;
		for (int j = firstRow; j <= lastRow; j++) {

			XSSFRow row = sheet.getRow(j);
			String caption = dataValue.formatCellValue(row.getCell(1));
			String recordtype = dataValue.formatCellValue(row.getCell(2));
			String maxlength = dataValue.formatCellValue(row.getCell(3));
			String numberofinfo1 = dataValue.formatCellValue(row.getCell(4));
			String active = dataValue.formatCellValue(row.getCell(5));
			String selectloop1 = dataValue.formatCellValue(row.getCell(6));
			
			int numberofinfo=Integer.valueOf(numberofinfo1);
			boolean selectloop=Boolean.valueOf(selectloop1);
//			if (caption.equals("")) {
//				break;
//
//			}
			  
			if (selectloop) {
				for(int i = 2; i <= numberofinfo; i++) {
				try {
					WebElement addfilesbtn=driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-dashed ant-btn-block']")); 
					addfilesbtn.click();
				} catch (Exception e) {
					 
				}}
				
			}
			System.out.println(firstRow);
			System.out.println(lastRow);
			
			//*************************
			try {
				Thread.sleep(3000);
				WebElement id = driver.findElement(By.xpath("//form[@id='test']/div["+l+"]/div/div/div/div/div/input[@id='caption']"));
				boolean value1 = id.isDisplayed();
			//	SampleCommonMethods.TestCasePrint("CAPTION TEXT BOX IS DISPLAYED", "true",String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("CAPTION TEXT BOX IS ENABLED", "true", String.valueOf(value2));
				id.click();
				id.clear();
				id.sendKeys(caption);

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("CAPTION TEXT BOX IS NOT THERE ", "true",
						String.valueOf(Value1), String.valueOf(e));

			}
			
	//*********MaterialMainCategory**************
			
			try {
				Thread.sleep(3000);
				WebElement id = driver.findElement(By.xpath("//form[@id='test']/div["+l+"]/div[2]/div/div/div/div/div/div"));
				boolean value1 = id.isDisplayed();
			//	SampleCommonMethods.TestCasePrint("recordType DROP DOWN IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("recordType DROP DOWN IS ENABLED", "true", String.valueOf(value2));
				id.click();
 
				Actions actions = new Actions(driver);
				try {
					boolean pass = false;
					Thread.sleep(1000);

					for (int i1 = 0; i1 < 1000; i1++) {
						if (!pass) {
							try {
								 list1 = driver
										.findElement(By.xpath("//div[contains(@title,'" + recordtype + "')]//div[1]"));
								
								
							} catch (Exception e) {
								
							}
							try {
								 list2 = driver
										.findElement(By.xpath("(//div[contains(@title,'" + recordtype + "')]//div[1])["+l+"]"));
								//(//div[contains(@title,'Header')]//div[1])[2]
									
									
								} catch (Exception e) {
									
								
								
								
							}

								if (l==1) {
									list=list1;
																	
								}
								else {
									list=list2;
								}
								//(//div[contains(@title,'Body')]//div[1])[2]
								System.out.println(list);
								list.click();
								Thread.sleep(2000);
								

								pass = true;
//							
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
				SampleCommonMethods.TestCasePrint("recordType DROP DOWN IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			try {
				Thread.sleep(3000);
				WebElement id = driver.findElement(By.xpath("//form[@id='test']/div["+l+"]/div[3]/div/div/div/div/input[@id='length']"));
				boolean value1 = id.isDisplayed();
		//		SampleCommonMethods.TestCasePrint("LENGTH TEXT BOX IS DISPLAYED", "true",String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("LENGTH TEXT BOX IS ENABLED", "true", String.valueOf(value2));
				id.click();
				id.clear();
				id.sendKeys(maxlength);

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("LENGTH TEXT BOX IS NOT THERE ", "true",
						String.valueOf(Value1), String.valueOf(e));

			}

			try {
				Thread.sleep(3000);
				WebElement id = driver.findElement(By.xpath("//form[@id='test']/div["+l+"]/div[4]/div/div/div/div/label/span"));
				boolean value1 = id.isDisplayed();
			//	SampleCommonMethods.TestCasePrint("ACTIVE CHECK BOX IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("ACTIVE CHECK BOX IS ENABLED", "true", String.valueOf(value2));
				Thread.sleep(2000);
				boolean value3 = id.isSelected();
				String v3 = String.valueOf(value3);
			//	SampleCommonMethods.TestCasePrint("ACTIVE CHECK BOX IS SELECTED", "false", String.valueOf(value3));
				if (active.equalsIgnoreCase(v3)) {

				}

				else {
					id.click();
				}

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("ACTIVE CHECK BOX IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			//**********************
	l=l+1;
			
	}
		try {
			Thread.sleep(3000);
			WebElement element= driver.findElement(By.xpath("//span[normalize-space()='Add']"));
			boolean value1 = element.isDisplayed();
		//	SampleCommonMethods.TestCasePrint("ADD BUTTON IS DISPLAYED", "true", String.valueOf(value1));
			boolean value2 = element.isEnabled();
			SampleCommonMethods.TestCasePrint("ADD BUTTON IS ENABLED", "true", String.valueOf(value2));
			element.click();
			Thread.sleep(3000);
			
		

		} catch (Exception e) {
			SampleCommonMethods.TestCasePrint("ADD BUTTON IS NOT THERE ", "true", String.valueOf(Value1), String.valueOf(e));

		}
	}

}
