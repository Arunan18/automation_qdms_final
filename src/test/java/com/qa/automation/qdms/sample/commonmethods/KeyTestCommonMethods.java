/***********************************************************************************
* Description
*------------
* Common Methoid
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 21/04/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*        21/04/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.commonmethods;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;

public class KeyTestCommonMethods extends DriverIntialization {

/**
 * @author hp            :-Quenthan
 * @param wBook          :-exceal Name
 * @param tab            :-Exceal Sheet Name
 * @param uniqIdBeforEdit:-Uniquid Befor edit
 * @param UniqIdAfterEdit:-Uniqueid after edit
 * @param table          :-Web element Of Table
 * @param Search         :-Search Colum For Edit intex
 * @param click          :-Key Test Colum
 * @param stepNo         :-Step No
 * @param                :-Search data put in Colum C & maintain empty row between Both Expacted result
 */
	public static void keyTest(String wBook,String tab,String uniqIdBeforEdit ,String UniqIdAfterEdit,int Search,int click,int stepNo) {
//		inicate reprt
			Boolean visu=null;
			Boolean eneb=null;
			Object col3af1=null;
			Object col3af=null;
			Object col3=null;
			String keyTestclick=null;
			Object aft=null;
			int no=0;
			
			extent.createTest("𝗦𝘁𝗲𝗽-"+stepNo+"--𝗦𝗲𝗮𝗿𝗰𝗵 & 𝗖𝗹𝗶𝗰𝗸 𝗞𝗲𝘆 𝗧𝗲𝘀𝘁🔽");
			
			ActionCommonMethod.actionS(Search, click, driver.findElement(By.className("ant-table-container")), "Key test", wBook, tab, uniqIdBeforEdit, 2);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
			}
			no=stepNo+1;
			extent.createTest("𝗦𝘁𝗲𝗽-"+no+"--𝗖𝗵𝗲𝗰𝗸 𝗞𝗲𝘆 𝗧𝗲𝘀𝘁 𝗠𝗼𝗱𝗮𝗹 𝗧𝗮𝗯𝗹𝗲 𝗖𝗼𝗻𝘁𝗲𝗻𝘁 𝗩𝗮𝗹𝘂𝗲🔽");
			DataFormatter dataValue = new DataFormatter();
			XSSFWorkbook wbook = null;
			XSSFRow row = null;
			XSSFCell cell = null;
			int j = 1;

			try {
				String filelocation = "./src/test/resources/Excel/"+wBook;
				FileInputStream fileIn = new FileInputStream(filelocation);
				wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
				fileIn.close();
			} catch (Exception e) {
			}
			PropertiesCommonMethods.excalRowCount(wBook, tab, uniqIdBeforEdit);
			XSSFSheet sheet = wbook.getSheet(tab);
			WebElement relaventTable= driver.findElement(By.className("ant-modal-content"));
			List<WebElement> allrows = relaventTable.findElements(By.cssSelector("tbody tr"));
			//checking can clicable
			List<WebElement> rowse = allrows.get(1).findElements(By.tagName("td"));
			

			int fg=1;
			int num = allrows.size();
			
			int r = PropertiesCommonMethods.countRow - 1;
			for (int i = r; i < r + num; i++) {
				row = sheet.getRow(i);
				cell = row.getCell(3);
				String testType = dataValue.formatCellValue(cell);
				if (testType=="") {
					break;
				}
				row = sheet.getRow(i);
				cell = row.getCell(4);
				String testName = dataValue.formatCellValue(cell);
				row = sheet.getRow(i);
				cell = row.getCell(5);
				String testOrigin = dataValue.formatCellValue(cell);
				row = sheet.getRow(i);
				cell = row.getCell(6);
				String keyTest = dataValue.formatCellValue(cell);
				row = sheet.getRow(i);
				cell = row.getCell(7);
				keyTestclick = dataValue.formatCellValue(cell);
				System.out.println(keyTestclick);

				// get table

				List<WebElement> rows = allrows.get(j).findElements(By.tagName("td"));
				String colum_1 = rows.get(0).getText();
				String colum_2 = rows.get(1).getText();
				Boolean colum_3 = rows.get(2).findElement(By.id("status")).isSelected();
				col3 = colum_3.toString();
				if (keyTestclick.equals("click")) {
				
					 visu=rowse.get(2).findElement(By.cssSelector(".ant-checkbox-wrapper")).isDisplayed();
					
					 if (visu==true) {
						eneb = rowse.get(2).findElement(By.id("status")).isEnabled();
						aft=col3;
						if (col3 == "true") {
							rows.get(2).findElement(By.id("status")).click();
							Boolean colum_3af1 = rows.get(2).findElement(By.id("status")).isSelected();
							col3af1 = colum_3af1.toString();

						} else if (col3 == "false") {
							rows.get(2).findElement(By.id("status")).click();
							Boolean colum_3af = rows.get(2).findElement(By.id("status")).isSelected();
							col3af = colum_3af.toString();

						} 
					}
					
					  
					
				}
				j = j + 1;

				PropertiesCommonMethods.cTestReports(testType,
						"Test Name-" + testName + ",  Test Origin-" + testOrigin + ",  Clicked-" + keyTest,
						"Test Name-" + colum_1 + ",  Test Origin-" + colum_2 + ",  Clicked-" + col3, "Key Test Value");
           fg=fg+1;
			}
			//visible/enable/ediable repor
			no=stepNo+2;
			extent.createTest("𝗦𝘁𝗲𝗽-"+no+"--Check Key Test Checkbox Displayed,Enable & Clickable🔽");
			
				PropertiesCommonMethods.cTestReports("1.Key Test Checkbox Displayed", "true", visu, "Key Test");
				if (visu == true) {
					PropertiesCommonMethods.cTestReports("2.Key Test Checkbox Enable", "true", eneb, "Key Test");
					if (visu == true) {
						if (aft == "true") {
							PropertiesCommonMethods.cTestReports("3.Checkbox Can Clickable", "false", col3af1,
									"Key Test");
						} else if (aft == "false") {
							PropertiesCommonMethods.cTestReports("3.Checkbox Can Clickable", "true", col3af,
									"Key Test");
						}
					}
				} 
			
			no=stepNo+3;
			extent.createTest("𝗦𝘁𝗲𝗽-"+no+"--𝗖𝗵𝗲𝗰𝗸 𝗞𝗲𝘆 𝗧𝗲𝘀𝘁 𝗦𝗮𝘃𝗲 𝗕𝘂𝘁𝘁𝗼𝗻 𝗜𝘀 𝗗𝗶𝘀𝗽𝗹𝗮𝘆𝗲𝗱 & 𝗘𝗻𝗮𝗯𝗹𝗲🔽");
			ActionCommonMethod.visbleEnable(driver.findElement(By.xpath("//span[text()='Save']")), "Save Button");
			driver.findElement(By.xpath("//span[text()='Save']")).click();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
			}
		//***********************************************************************************************************
			no=stepNo+4;
			extent.createTest("𝗦𝘁𝗲𝗽-"+no+"--𝗦𝗲𝗮𝗿𝗰𝗵 & 𝗥𝗲-𝗘𝗱𝗶𝘁 𝗞𝗲𝘆 𝗧𝗲𝘀𝘁 𝗔𝗳𝘁𝗲𝗿 𝗦𝗮𝘃𝗲🔽");
			ActionCommonMethod.actionS(Search, click, driver.findElement(By.className("ant-table-container")), "Key test", wBook, tab, uniqIdBeforEdit, 2);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
			}
			no=stepNo+5;
			extent.createTest("𝗦𝘁𝗲𝗽-"+no+"--𝗥𝗲-𝗖𝗵𝗲𝗰𝗸 𝗔𝗳𝘁𝗲𝗿 𝗦𝗮𝘃𝗲 𝗖𝗵𝗲𝗰𝗸 𝗞𝗲𝘆 𝗧𝗲𝘀𝘁 𝗧𝗮𝗯𝗹𝗲 𝗗𝗮𝘁𝗮𝘀🔽");
			XSSFWorkbook wbookk = null;
			XSSFRow roww = null;
			XSSFCell celle = null;
			int k = 1;

			try {
				String filelocation = "./src/test/resources/Excel/"+wBook;
				FileInputStream fileIn = new FileInputStream(filelocation);
				wbookk = (XSSFWorkbook) WorkbookFactory.create(fileIn);
				fileIn.close();
			} catch (Exception e) {
			}
			PropertiesCommonMethods.excalRowCount(wBook, tab, uniqIdBeforEdit);
			XSSFSheet sheett = wbookk.getSheet(tab);
			WebElement relaventTablee= driver.findElement(By.className("ant-modal-content"));
			List<WebElement> allrowss = relaventTablee.findElements(By.cssSelector("tbody tr"));
			int numm = allrowss.size();
			System.out.println(numm);
			int l = PropertiesCommonMethods.countRow +fg-1;
			for (int i = l; i < l + numm; i++) {
				row = sheett.getRow(i);
				cell = row.getCell(3);
				String testType = dataValue.formatCellValue(cell);
				if (testType=="") {
					break;
				}
				roww = sheett.getRow(i);
				celle = roww.getCell(4);
				String testName = dataValue.formatCellValue(celle);
				roww = sheett.getRow(i);
				celle = roww.getCell(5);
				String testOrigin = dataValue.formatCellValue(celle);
				roww = sheett.getRow(i);
				celle = roww.getCell(6);
				String keyTest = dataValue.formatCellValue(celle);
				
			

				// get table

				List<WebElement> rows = allrowss.get(k).findElements(By.tagName("td"));
				String colum_1 = rows.get(0).getText();
				String colum_2 = rows.get(1).getText();
				Boolean colum_3 = rows.get(2).findElement(By.id("status")).isSelected();
				Object col3e = colum_3.toString();
				
				k = k + 1;

				PropertiesCommonMethods.cTestReports(testType,
						"Test Name-" + testName + ",  Test Origin-" + testOrigin + ",  Clicked-" + keyTest,
						"Test Name-" + colum_1 + ",  Test Origin-" + colum_2 + ",  Clicked-" + col3e, "Key Test Value");

			}
			driver.findElement(By.xpath("//span[text()='Cancel']")).click();
		
	}

}
