package com.qa.automation.qdms.testconfig.commonmethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class AcceptCondition extends DriverIntialization {

	static String equation = null;
	static String text = "";
	public static String stringToSplit=null;
	static DataFormatter dataValue=new DataFormatter();
	public static void condition(String workBookName, String ExcelTabName, String TestcaseId)
			throws InterruptedException, IOException {
		boolean select = false;
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + workBookName + ".xlsx";
		int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
		int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(ExcelTabName);
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow rowk = sheet.getRow(i);
			stringToSplit = dataValue.formatCellValue(rowk.getCell(1));
			String testCount1 = dataValue.formatCellValue(rowk.getCell(2));
			int testCount=Integer.valueOf(testCount1);
			for (int k = 3; k <= (2 + testCount); k++) {
				String testName = dataValue.formatCellValue(rowk.getCell(k));
				Thread.sleep(1000);
				String extractedString = testName.substring(0, testName.indexOf("("));
				List<WebElement> selectPara = driver
						.findElements(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr/td[1]"));
				for (int m = 2; m <= selectPara.size(); m++) {
					System.out.println(selectPara.size());
					System.err.println("(//tbody[@class='ant-table-tbody'])[1]/tr[" + m + "]/td[1]");
					WebElement param = driver
							.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr[" + m + "]/td[1]"));
					System.out.println("(//tbody[@class='ant-table-tbody'])[1]/tr[" + m + "]/td[1]");
					String paraName = param.getText();
					if (paraName.contains(extractedString)) {
						WebElement checkBox = driver.findElement(
								By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr[" + m + "]/td[3]/label/span"));
						System.err.println("(//tbody[@class='ant-table-tbody'])[1]/tr[" + m + "]/td[3]/label/span");
						MultiSearchMethods.Button(checkBox, "Parameter Select checkBox");
						System.err.println(MultiSearchMethods.BtnVisible + " !!! " + MultiSearchMethods.BtnEnable);
						if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
							checkBox.click();
//							extractedString=null;
						}
						MultiSearchMethods.BtnVisible = true;
						MultiSearchMethods.BtnEnable = true;
					}
				}
			}

			ArrayList<String> equationLetter = new ArrayList<String>();
			String[] characters = stringToSplit.split("");
			for (String character : characters) {
				equationLetter.add(character);
			}
			System.err.println(equationLetter);
			for (int j = 0; j < equationLetter.size(); j++) {
				String letter = equationLetter.get(j);

				List<WebElement> abb = driver.findElements(By.xpath("//div[@class='ant-col ant-col-4']/div/div"));
				for (int n = 1; n <= abb.size(); n++) {
					WebElement le = driver
							.findElement(By.xpath("//div[@class='ant-col ant-col-4']/div/div[" + n + "]/div"));
					String AbbLetter = le.getText();
					if (AbbLetter.contentEquals(letter)) {
						le.click();
					}
				}

				List<WebElement> operator = driver.findElements(By.xpath("//div[@class='calculatorsAccepet']/div"));
				for (int o = 1; o <= operator.size(); o++) {
					System.err.println("!!! " + letter + "  **  " + o);
					Thread.sleep(1000);
					if (letter.equalsIgnoreCase("&")) {
						text = text + letter;
						if (text.contentEquals("&&")) {
							driver.findElement(By.xpath("//div[@class='calculatorsAccepet']/div[1]/div")).click();
							text = "";
						}
						break;
					} else if (letter.equalsIgnoreCase("|")) {
						text = text + letter;
						if (text.contentEquals("||")) {
							driver.findElement(By.xpath("//div[@class='calculatorsAccepet']/div[2]/div")).click();
							text = "";
						}
						break;
					} else if (letter.equalsIgnoreCase("(")) {
						driver.findElement(By.xpath("//div[@class='calculatorsAccepet']/div[3]/div")).click();
					} else if (letter.equalsIgnoreCase(")")) {
						driver.findElement(By.xpath("//div[@class='calculatorsAccepet']/div[4]/div")).click();
					}
					break;
				}
			}
			try {
				WebElement save = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
				MultiSearchMethods.Button(save, "Equation Save Button");
				if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
					save.click();
				}
				MultiSearchMethods.BtnVisible = true;
				MultiSearchMethods.BtnEnable = true;
			} catch (NoSuchElementException e) {
				CommonMethods.TestCasePrint("Save Button Element Not there");
			}
			Thread.sleep(2500);
		}

	}

}
