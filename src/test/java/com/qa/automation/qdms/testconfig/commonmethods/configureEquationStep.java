package com.qa.automation.qdms.testconfig.commonmethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

public class configureEquationStep extends DriverIntialization {

	static String equation=null;
	public static boolean cli=false;
	public static boolean paraa=false;
	static String equationType=null;
	public static boolean eqsav=false;
	static DataFormatter dataValue=new DataFormatter();
//	@Test    



	public static void equation(String workBookName, String ExcelTabName, String TestcaseId) throws InterruptedException, IOException {
	
			
		boolean select = false;  
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + workBookName + ".xlsx";
		int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
		int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(ExcelTabName);
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow rowk = sheet.getRow(i);
			String text1 = dataValue.formatCellValue(rowk.getCell(1));
			String testParameter = dataValue.formatCellValue(rowk.getCell(2));
			 equation = dataValue.formatCellValue(rowk.getCell(3));
			 String equParameterCount1 = dataValue.formatCellValue(rowk.getCell(4));
			 int equParameterCount=Integer.valueOf(equParameterCount1);
			 if(text1.toUpperCase().contentEquals("Input".toUpperCase())) {
				 equationType="PARAMETER";
			 } else {
				 equationType=text1;
			}
			 Thread.sleep(1500);
			try {   
				List<WebElement> radioCount = driver
						.findElements(By.xpath("//div[@class='ant-radio-group ant-radio-group-outline']/label"));
				for (int k = 1; k <= radioCount.size(); k++) {
  
					WebElement type = driver.findElement(By
							.xpath("//div[@class='ant-radio-group ant-radio-group-outline']/label[" + k + "]/span[2]"));
					String equeType = type.getText();
					System.out.println(equeType + " ***  " + equationType);
					if (equeType.contains(equationType)) {
						WebElement radio = driver.findElement(
								By.xpath("//div[@class='ant-radio-group ant-radio-group-outline']/label[" +k+ "]/span[1]"));
						Thread.sleep(200);
						MultiSearchMethods.BtnVisible = true;
						MultiSearchMethods.BtnEnable = true;
						System.err.println(MultiSearchMethods.BtnVisible + " ********************** " + MultiSearchMethods.BtnEnable);
						MultiSearchMethods.Button1(radio, equationType + " Radio Button");
						System.err.println(MultiSearchMethods.BtnVisible + " !!! " + MultiSearchMethods.BtnEnable);
						if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
//							Thread.sleep(200);
							radio.click();
							select = true;
							cli=true;
							MultiSearchMethods.BtnVisible = true;
							MultiSearchMethods.BtnEnable = true;
							break;
						}
						System.out.println(MultiSearchMethods.BtnVisible + " !!! " + MultiSearchMethods.BtnEnable);
//						if (select) {
//							break;
//						}
					}
//					if (select) {
//						break;
//					}
				}
			} catch (NoSuchElementException e) {

			}
//			if (select) {
//				break;
//			}
			if(cli) {
				cli=false;
			WebElement parameterTextBox = driver.findElement(By.xpath("//div[@class='ant-select ant-select-single ant-select-show-arrow']/div"));
			System.out.println(MultiSearchMethods.BtnVisible + " !!! " + MultiSearchMethods.BtnEnable);
			MultiSearchMethods.Button1(parameterTextBox, "Parameter DropDown Button");
			System.err.println(MultiSearchMethods.BtnVisible + " !!! " + MultiSearchMethods.BtnEnable);
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
				Thread.sleep(200);
				driver.findElement(By.xpath("//div[@class='ant-select ant-select-single ant-select-show-arrow']/div")).click();
				Thread.sleep(1000);
				List<WebElement> para=driver.findElements(By.xpath("//div[@class='rc-virtual-list']/div[1]/div/div/div"));
				for(int j=1; j<=para.size(); j++) {
					Thread.sleep(2000);
					WebElement param=driver.findElement(By.xpath("(//div[@class='rc-virtual-list']/div[1]/div/div/div/div/span)[" + j + "]"));
					String parameter=param.getText();
					System.out.println(parameter + "## "+testParameter+"##" );
					if(parameter.contains(testParameter)) {
						param.click();
						paraa=true;
//						MultiSearchMethods.clickButton(param, testParameter+" Parameter Selected");
					} 
				}
				//div[@class='rc-virtual-list']/div[1]/div/div/div
			}
			MultiSearchMethods.BtnVisible = true;
			MultiSearchMethods.BtnEnable = true;
			} else {
				CommonMethods.print("Radio Button Not Clicked");
			}
			
			if(paraa) {
				paraa=false;
			for(int k=5; k<=(4+equParameterCount); k++) {
				String parameterName = dataValue.formatCellValue(rowk.getCell(k));
				Thread.sleep(500);
				List<WebElement> selectPara=driver.findElements(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr/td[1]"));
				for(int m=2; m<=selectPara.size(); m++) {
					System.out.println(selectPara.size());
					System.err.println("(//tbody[@class='ant-table-tbody'])[1]/tr[" + m + "]/td[1]");
					WebElement param=driver.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr[" + m + "]/td[1]"));
					System.out.println("(//tbody[@class='ant-table-tbody'])[1]/tr[" + m + "]/td[1]");
					String paraName=param.getText();
					if(paraName.contentEquals(parameterName)) {
						WebElement checkBox=driver.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr[" + m + "]/td[4]/label/span"));
						System.err.println("(//tbody[@class='ant-table-tbody'])[1]/tr[" + m + "]/td[4]/label/span");
						MultiSearchMethods.Button1(checkBox, "Parameter Select checkBox");
						System.err.println(MultiSearchMethods.BtnVisible + " !!! " + MultiSearchMethods.BtnEnable);
						if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
//							checkBox.click();
							MultiSearchMethods.clickButton(checkBox, parameterName+" checkbox clicked");
						}
						MultiSearchMethods.BtnVisible = true;
						MultiSearchMethods.BtnEnable = true;
						}
					}
			}
			boolean k=false;
			try {
				WebElement text=driver.findElement(By.xpath("(//div[@class='sc-bxivhb fZlIKa'])[3]/div[1]/textarea"));
				MultiSearchMethods.Button1(text, "Equation Input Text Box");

				String[] splitEquation = equation.split("=");
				String rightSide = splitEquation[1];
				System.out.println("((((((" + rightSide + " )))))))");
				if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
					text.sendKeys(rightSide);
//					CommonMethods.print("Equation Selected");
					k=true;
				}
				MultiSearchMethods.BtnVisible = true;
				MultiSearchMethods.BtnEnable = true;
				} catch (NoSuchElementException e) {
					CommonMethods.print("Equation TextBox Not There");
				}
				
				
				if (k) {
					try {
						WebElement save = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
						MultiSearchMethods.Button1(save, "Equation Save Button");
						if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
							//					save.click();
							MultiSearchMethods.clickButton(save, "Equation Save Button Clicked");
							eqsav = true;
						}
						MultiSearchMethods.BtnVisible = true;
						MultiSearchMethods.BtnEnable = true;
					} catch (NoSuchElementException e) {
						CommonMethods.print("Save Button Element Not there");
					} 
				}
				Thread.sleep(500);
		} else {
			CommonMethods.print("Equation Parameter Not Selected");
		}
		} 
		

	}
		
	}

