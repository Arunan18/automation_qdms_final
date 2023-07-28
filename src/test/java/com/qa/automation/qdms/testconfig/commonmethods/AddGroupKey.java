package com.qa.automation.qdms.testconfig.commonmethods;

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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;
import com.qa.automation.qdms.testconfig.testcases.testconfigure.AddConfigureTest;

public class AddGroupKey extends DriverIntialization {

	static boolean noElement = false;
	static boolean click = false;
	static String groupKeyValue = null; 
	static DataFormatter dataValue=new DataFormatter();
	public static boolean clicked=false;
	
	public static void groupKey(String workBookName, String ExcelTabName, String TestcaseId)
			throws InterruptedException, IOException {
		
		Thread.sleep(1500);
		ArrayList<String> param = new ArrayList<String>();
		ArrayList<String> groupkey = new ArrayList<String>();
		try {
			MultiSearchMethods.BtnVisible = true;
			MultiSearchMethods.BtnEnable = true;
			WebElement groupKey = driver.findElement(By.xpath("(//div[@class='sc-bxivhb fZlIKa'])[2]/div[4]/button"));
			MultiSearchMethods.Button1(groupKey, "Group Key");
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
				MultiSearchMethods.clickButton(groupKey, "Add Group Key");
			}
			MultiSearchMethods.BtnVisible = true;
			MultiSearchMethods.BtnEnable = true;
		} catch (NoSuchElementException e) {
			CommonMethods.print("Add Group Button Not there");
		}
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + workBookName + ".xlsx";
		int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
		int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(ExcelTabName);

		boolean select = false;
		for (int i = firstrow; i <= lastrow; i++) {
			click = false;
			XSSFRow rowk = sheet.getRow(i);

			String ParameterName = dataValue.formatCellValue(rowk.getCell(1));
			System.out.println(ParameterName + " !!!!!!!");
			boolean nextBtn = true;
			while (nextBtn) {
				Thread.sleep(1000);
				List<WebElement> size = driver
						.findElements(By.xpath("(//tbody[@class='ant-table-tbody'])[4]/tr/td[1]"));

				for (int j = 2; j <= size.size(); j++) {
					Thread.sleep(100);
					WebElement text = driver
							.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[4]/tr[" + j + "]/td[1]"));
					String paraText = text.getText();
					if (paraText.contentEquals(ParameterName)) {
						System.err.println(">>>>>>>>> " + ParameterName);
						WebElement check = driver.findElement(
								By.xpath("(//tbody[@class='ant-table-tbody'])[4]/tr[" + j + "]/td[2]/label/span"));
						MultiSearchMethods.Button1(check, ParameterName + " Check Box");
						if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
							check.click();
							param.add(ParameterName);
							click = true;
							select = true;
							break;
						}
						if (click) {
							break;
						}
					}
					if (click) {
						break;
					} 
				}
				MultiSearchMethods.BtnVisible = true;
				MultiSearchMethods.BtnEnable = true;

				if (click) {
					break;
				}
				try {
					nextBtn = driver.findElement(By.xpath(
							"//ul[@class='ant-pagination ant-table-pagination ant-table-pagination-right']//li[@title='Next Page']/button"))
							.isEnabled();
					if (nextBtn) {
						driver.findElement(By.xpath(
								"//ul[@class='ant-pagination ant-table-pagination ant-table-pagination-right']//li[@title='Next Page']/button"))
								.click();
					}
				} catch (Exception e) {
					CommonMethods.print("Next Button Element Not There");
				}
			}
			WebElement first = driver.findElement(By.xpath(
					"//ul[@class='ant-pagination ant-table-pagination ant-table-pagination-right']//li[@title='1']/a"));
			first.click();
		}
		if (select == false) {
			CommonMethods.print("Searched Element Not There");
		}
		if (select) {

			for (int j = firstrow; j <= (lastrow+10) + 1; j++) {
				noElement = false;
				XSSFRow rowk = sheet.getRow(j);

				groupKeyValue = dataValue.formatCellValue(rowk.getCell(2));
				System.out.println(groupKeyValue + " ;;;;;;;;;; " + j);
				System.out.println(firstrow + " ;;;;;;;;;; " + (lastrow + 1));
				int k = 1;
				List<WebElement> button = driver.findElements(
						By.xpath("(//div[@class='ant-col ant-col-6'])[3]/div[2]/div/div/div[2]/div/button"));

				int buttonCount = button.size();
				if (buttonCount == 1) {

					WebElement inputGroupKeyValue = driver
							.findElement(By.xpath("(//input[@class='ant-input ml10'])[1]"));
					MultiSearchMethods.Button1(inputGroupKeyValue, groupKeyValue + " Text Box");
					inputGroupKeyValue.sendKeys(groupKeyValue);
					groupkey.add(groupKeyValue);
					if (!sheet.getRow(j + 1).getCell(2).getStringCellValue().equalsIgnoreCase("finished")) {
						WebElement addButton = driver.findElement(
								By.xpath("(//div[@class='ant-col ant-col-6'])[3]/div[2]/div[1]/div/div[2]/div/button"));
						MultiSearchMethods.Button1(addButton, " New add KEY ");
						if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
							addButton.click();
						}
						MultiSearchMethods.BtnVisible = true;
						MultiSearchMethods.BtnEnable = true;
					} else {
						break;
					}

				} else if (buttonCount >= 2) {
					for (k = 3; k <= buttonCount; k++) {
						WebElement inputGroupKeyValue = driver
								.findElement(By.xpath("(//input[@class='ant-input ml10'])[" + (k - 1) + "]"));
						inputGroupKeyValue.sendKeys(groupKeyValue);
						groupkey.add(groupKeyValue);
						if (!sheet.getRow(j + 1).getCell(2).getStringCellValue().equalsIgnoreCase("finished")) {
							WebElement addButton = driver
									.findElement(By.xpath("(//div[@class='ant-col ant-col-6'])[3]/div[2]/div[" + (k - 1)
											+ "]/div/div[2]/div/button[2]"));
							MultiSearchMethods.Button1(addButton, " New add KEY ");
							if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
								addButton.click();
							}
							MultiSearchMethods.BtnVisible = true;
							MultiSearchMethods.BtnEnable = true;
						} else {
							noElement = true;
							break;
						}

					}

				}
				if (noElement) {
					break;
				}
			}
			int m = 1;
			boolean test = false;
			System.err.println(param);
			System.err.println(groupkey);
			for (int i = 0; i < param.size(); i++) {
				for (int j = 0; j < groupkey.size(); j++) {
					String text = param.get(i) + "_" + groupkey.get(j);
					System.out.println(text);

					WebElement para = driver.findElement(By.xpath("//ul[@class='ant-list-items']/li[" + m + "]"));
					String paraName = para.getText();
					System.err.println(paraName);
					m = m + 1;

					try {
						Assert.assertEquals(paraName, text);
						test = true;
					} catch (AssertionError e) {
						test = false;
					}
				}
			}
			if (test) {
				CommonMethods.print("Selected Parameter and Group Key", test);
			} else {
				CommonMethods.print("Selected Parameter and Group Key", test);
			}

			WebElement addGroupKeyButton = driver.findElement(By.xpath("//div[@class='ant-modal-footer']/button[2]"));
			MultiSearchMethods.Button1(addGroupKeyButton, " Add Group keys ");
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
				addGroupKeyButton.click();
			}
			MultiSearchMethods.BtnVisible = true;
			MultiSearchMethods.BtnEnable = true;
		}
		
	}
	
	public static void actionS(int column, int clickColumn, WebElement table, String action, String wookBook,
			String tab, String uniqueId, int c) {
		clicked=false;
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;
		try {
			filelocation = "./src/test/resources/Excel/" + wookBook;

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);

		} catch (Exception e) {
			// TODO: handle exception
		}

		XSSFSheet sheet = wbook.getSheet(tab);
		PropertiesCommonMethods.excalRowCount(wookBook, tab, uniqueId);
		int r=PropertiesCommonMethods.countRow-1;

		row = sheet.getRow(r);
		cell = row.getCell(c);
		String iV = dataValue.formatCellValue(cell);
		
		System.out.println(iV);
		String sp[]=iV.split(",");
		
		
		
		String value =null;
		
		if (action == "delete") {
			value = "anticon-delete";
			
		}
		else if (action == "Description") {
			value = "anticon-container";

		}
		else if (action == "edit") {
			value = "anticon-edit";

		}
		
		
		Boolean rept=true;
		Boolean d =false;
		while (rept.equals(true)) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				
			}
			
			try {
				rept = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
			} catch (Exception e) {
				rept=false;				}
			
			try {
				
				WebElement xt =driver. findElement(By.xpath("//td[" + (column+1) + "][text()='" + sp[0]
						+ "']/following-sibling::td[5][text()='" + sp[1] + "']/following-sibling::td[" + (clickColumn-5)
						+ "]//span[contains(@class,'" + value + "')]"));
				d=true;
				ActionCommonMethod.visbleEnable(xt, action.toUpperCase());
				try {
					xt.click();
					clicked=true;
				} catch (Exception e) {
				PropertiesCommonMethods.cTestReports(action.toUpperCase()+"-Icon Clicking", "true", "false", action+"-icon Click");
				}
				rept=false;
			} catch (Exception e) {
				// TODO: handle exception
			} 
			
			
			if (rept.equals(true)) {
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
			}
			
			
		}
		
		if (d.equals(false)) {
PropertiesCommonMethods.cTestReports("Your Data Not In Table", true, d, "");		
		}

		
		
		
		
		
	}
}