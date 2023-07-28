package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.automation.qdms.base.DriverIntialization;

import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;

public class AddKeyTestfunction extends DriverIntialization{
	public static String comment = null;
	public static WebElement id = null;
	public static String TEST = null;
	public static String v4 = null;
	public static boolean keysave=false;
	static DataFormatter dataValue=new DataFormatter();

	public static void AddTestEquation(String name, String ExcelTabName, String TestcaseId)
			throws IOException, InterruptedException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + name + ".xlsx";
		boolean Value1 = false;
		int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
		int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
		System.out.println(firstrow+"ffffffff");
		System.out.println(lastrow+"llllllllllllll");
		  
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(ExcelTabName);
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow rowk = sheet.getRow(i);

			String SUBCATEGORY = dataValue.formatCellValue(rowk.getCell(1));
			String main = dataValue.formatCellValue(rowk.getCell(2));
			String sub = dataValue.formatCellValue(rowk.getCell(3));
			String last = dataValue.formatCellValue(rowk.getCell(4));
			System.out.println(main+"kkkkkkkkkk");
			System.out.println(sub+"aaaaaaaaaaa");
			System.out.println(last+"jjjjjjjjjjj");

			Thread.sleep(1000);
			// ********equation type********
			WebElement subcatagory = driver.findElement(By.xpath("//input[@value='SubCategory']"));
			WebElement material = driver.findElement(By.xpath("//input[@value='matrial']"));
			if (SUBCATEGORY.equals("Sub Category")) {
				id = subcatagory;
				comment = "SUB CATEGORY";
				TEST = SUBCATEGORY;

			}
			if (SUBCATEGORY.equals("matrial")) {
				id = material;
				comment = "MATERIAL";
				TEST = SUBCATEGORY;
			}
			Thread.sleep(500);
			try {

				boolean value1 = id.isDisplayed();
			//	SampleCommonMethods.TestCasePrint(comment + "RADIO BUTTON IS DISPLAYED", "true",String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("TEST RADIO BUTTON IS ENABLED", "true", String.valueOf(value2));
				Thread.sleep(500);
				boolean value3 = id.isSelected();
				String v3 = String.valueOf(value3);
			//	SampleCommonMethods.TestCasePrint("TEST RADIO BUTTON IS SELECTED", "false", String.valueOf(value3));
				if (TEST.equals(v3)) {

				}

				else {
					id.click();
				}

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("TEST RADIO BUTTON IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			Thread.sleep(500);

			// locate the table element using a locator strategy of your choice
			WebElement table = driver.findElement(By.tagName("tbody"));

			// set a flag to indicate whether the text has been found or not
			boolean textFound = false;

			// set a counter to keep track of the number of rows in the table
			int rowCount = table.findElements(By.tagName("tr")).size();

			// use a while loop to iterate through each row of the table
			int i1 = 0;
			while (i1 < rowCount && !textFound) {
				// get the i-th row of the table
				WebElement row = table.findElements(By.tagName("tr")).get(i1);

				// get the cells of the row
				List<WebElement> cells = row.findElements(By.tagName("td"));

				// iterate through each cell to find the text
				for (WebElement cell : cells) {
					// ****************************

					// the text has been found, set the flag to true and break out of the loop
					Thread.sleep(500);
					try {
						WebElement tick1 = driver.findElement(By.xpath("//*[text()='" + last + "']/../td[1]"));
						tick1.click();
						Thread.sleep(500);

					} catch (Exception e) {
						try {
							WebElement tick2 = driver
									.findElement(By.xpath("//*[text()='" + sub + "']/../td[2]/button"));
							if (last.equals("")) {
								WebElement tick21 = driver.findElement(By.xpath("//*[text()='" + sub + "']/../td[1]"));
								tick21.click();	
							}
							else {
								tick2.click();
							
							
							Thread.sleep(500);
							try {
								WebElement tick3 = driver.findElement(By.xpath("//*[text()='" + last + "']/../td[1]"));
								tick3.click();
								Thread.sleep(500);

							} catch (Exception e6) {
								System.out.println("last not under this sub");
								
							}}

						} catch (Exception e2) {
							try {
								WebElement tick4 = driver
										.findElement(By.xpath("//*[text()='" + main + "']/../td[2]/button"));
								if (sub.equals("")) {
									WebElement tick21 = driver.findElement(By.xpath("//*[text()='" + main + "']/../td[1]"));
									tick21.click();	
								}
								else {
									
								tick4.click();
								Thread.sleep(500);
								// *********************************
								try {
									WebElement tick5 = driver
											.findElement(By.xpath("//*[text()='" + sub + "']/../td[2]/button"));
									if (last.equals("")) {
										WebElement tick21 = driver.findElement(By.xpath("//*[text()='" + sub + "']/../td[1]"));
										tick21.click();	
									}else {
											tick5.click();
										}
									
									
									Thread.sleep(500);
									try {
										WebElement tick6 = driver
												.findElement(By.xpath("//*[text()='" + last + "']/../td[1]"));
										
										tick6.click();
										Thread.sleep(500);

									} catch (Exception e5) {
										System.out.println("last is not under this sub");

									}

								} catch (Exception e3) {
									System.out.println("sub is not under this main");
								}}

								// *******************************

							} catch (Exception e3) {
								System.out.println("no main category under tis subcategory");

							}
						}
					}

					textFound = true;
					break;

				}

				// increment the row counter
				i1++;
			}

			if (textFound) {
				System.out.println("Text found!");
			} else {
				System.out.println("Text not found!");
			}
//			Thread.sleep(500);
try {
	WebElement click=driver.findElement(By.xpath("//div[@class='ant-table-footer']/div/button"));
	click.click();
	keysave=true;
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		} // *******excel end **********
	}

}
