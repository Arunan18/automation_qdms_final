/***********************************************************************************
* Description
*------------
* Process Sample Multi Search
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 28/04/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*  TC-PRO-SAM-0015       28/04/2023   Quenthan     Orginal Version
*
************************************************************************************/

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProcessSampleMultiSearch extends DriverIntialization {
	
	@Test
	public static void ProcessSampleMulti() throws InterruptedException, IOException {
		ProcessSampleMultiSearch lk=new ProcessSampleMultiSearch();
		PageFactory.initElements(driver, lk);
		LoginTest.Login();
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.rawMaterialSampleMainNavigation();
		SampleNavigateTest.inprocessSampleNavigation();
		Thread.sleep(2000);
		
		
		ProcessSampleMultiSearch.multiSearch("Samples Module.xlsx", "Process Sample", "TC-PRO-SAM-0015-01",ProcessSampleMultiSearch.table,1);
		Logout.LogoutFunction();
	
		
		

		
	}
	
	
	
	/**
	 * @author Quenthan
	 * @param webook :-Excel Book Name
	 * @param tab    :-Excel Sheet Name
	 * @param uniqId :-Test Case Id
	 * @param table  :-Webelement Table
	 * @param step   :-Step
	 */
	public static void multiSearch(String webook,String tab,String uniqId,WebElement table, int step) {
		Actions actions = new Actions(driver);
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;
		int searchIcon=1;
		int dr=1;
	int	multi=0;
	String Tatal =null;
	WebElement relaventTable = table;
		try {
			filelocation = "./src/test/resources/Excel/"+webook;

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			// fileIn.close();

		} catch (Exception e) {
			
		}

		PropertiesCommonMethods.excalRowCount(webook, tab, uniqId);
		int I = PropertiesCommonMethods.countRow - 1;
		int j=3;
		
		for (int d = 0; d < 50; d++) {
			XSSFSheet sheet = wbook.getSheet(tab);
			row = sheet.getRow(I+1);
			cell = row.getCell(2);
			 Tatal = dataValue.formatCellValue(cell);
			 
			row = sheet.getRow(I);
			cell = row.getCell(j);
			String heding = dataValue.formatCellValue(cell);
			
			row = sheet.getRow(I+1);
			cell = row.getCell(j);
			String searchData = dataValue.formatCellValue(cell);
			System.out.println("searchData:-"+searchData);
			if (searchData=="") {
				break;
			}
//			System.out.println(searchData);
//			row = sheet.getRow(I + 2);
//			cell = row.getCell(j);
//			String SearchCofirmData = dataValue.formatCellValue(cell);
//			System.out.println("SearchCofirmData:-"+SearchCofirmData);
	
			
			row = sheet.getRow(I + 2);
			cell = row.getCell(j);
			String df = dataValue.formatCellValue(cell);
			int searchDataColumn=0;
			try {
				searchDataColumn = Integer.parseInt(df);
			} catch (Exception e) {
			}
			System.out.println("searchDataColumn:-"+searchDataColumn);
			
			
			row = sheet.getRow(I + 3);
			cell = row.getCell(j);
			String dff = dataValue.formatCellValue(cell);
			int se = Integer.parseInt(dff);
			System.out.println("searchIcon Intex:-"+se);
			
			
			row = sheet.getRow(I + 4);
			cell = row.getCell(j);
			String expacted = dataValue.formatCellValue(cell);
			
			
			
			row = sheet.getRow(I + 5);
			cell = row.getCell(j);
			String sType = dataValue.formatCellValue(cell);
			
			j = j + 1;
			if(!df.isEmpty()) {
			
			//List<WebElement> allrows = relaventTable.findElements(By.cssSelector("tbody tr"));
			int corrct = 0;
			try {
				//driver.findElement(By.xpath("//a[text()='1']/..")).click();	
				driver.findElement(By.xpath("(//td[contains(@class,'ant-table-cell')])[1]")).click();
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e2) {
			}
			boolean pass = true;
			while (pass == true) {
				try {
					
					driver.findElement(By.xpath("(//span[contains(@class,'anticon-search')]/..)[" + se + "]"))
							.click();
					pass = false;
				} catch (Exception e) {
				}
				if (pass == true) {
					
					
						try {
							driver.findElement(By.xpath("(//td[contains(@class,'ant-table-cell')])[1]")).click();
						} catch (Exception e) {
							// TODO: handle exception
						}
						actions.sendKeys(Keys.ARROW_RIGHT).perform();
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
					}
					
				

			}}
			try {
				Thread.sleep(800);
			} catch (InterruptedException e3) {
			}
			
			Boolean seacr=true;
			
			for (int k = 0; k < 1; k++) 
			{
				try {
					
					if (sType.equals("D")) {
						Thread.sleep(500);
						driver.findElement(By.xpath("(//div[@class='ant-table-filter-dropdown']/div/div/div/span[@class='ant-select-selection-search'])["+dr+"]")).click();
						Thread.sleep(500);
						driver.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']//div[text()='"+searchData+"']")).click();
						dr=dr+1;
				Thread.sleep(500);
			
				seacr = false;
				break;
					}
					else {
						Thread.sleep(500);
						driver.findElement(By.xpath("(//div[@class='ant-table-filter-dropdown']//input[@type='text'])[" + searchIcon + "]")).click();
						Thread.sleep(500);
						driver.findElement(By.xpath("(//div[@class='ant-table-filter-dropdown']//input[@type='text'])[" + searchIcon + "]"))
						.sendKeys(searchData);
				Thread.sleep(500);
				seacr = false;
				break;
					}
					
					
					

				} catch (Exception e) {
					if (seacr == true) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e1) {
						}
						driver.findElement(By.xpath("(//td[contains(@class,'ant-table-cell')])[1]")).click();
						actions.sendKeys(Keys.ARROW_UP).perform();
						
						driver.findElement(By.xpath("(//span[contains(@class,'anticon-search')]/..)[" + se + "]"))
								.click();
						
					}
				} 
			}
			
			
			try {
				Thread.sleep(500);
				driver.findElement(By.xpath("(//span[text()='Search']/..)[" + searchIcon + "]")).click();
				 searchIcon= searchIcon+1;
			} catch (Exception e) {
//				driver.findElement(By.xpath("(//span[text()='Search']/..)")).click();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e3) {
			}
			try {
				driver.findElement(By.xpath("//a[text()='1']/..")).click();
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e2) {
			}
			int num1 = 0;
			corrct=0;
			int counte = 0;
			boolean nextPage = true;
			String colum_2 = null;
			List<WebElement> allrows1 = null;
			if(seacr==false) {
			while (nextPage == true) {
				{
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
					}
					allrows1 = relaventTable.findElements(By.xpath("//tbody/tr"));
					num1 = allrows1.size();
					try {
						nextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
								.isEnabled();
					} catch (Exception e) {
						nextPage=false;
					}
					System.out.println(nextPage);
					

					for (int i = 1; i <= num1; i++) {
						
							try {
								int a=searchDataColumn+1;
							String	str =driver.findElement(By.xpath("//tbody/tr["+i+"][contains(@class,'ant-table-row')]/td["+a+"]")).getText();
							counte = counte + 1;
								if (!str.isEmpty()) {
									if (searchData.equals("Test Equipment")) {
										searchData="TEST_EQUIPMENT";
										
									}
									else if (searchData.equals("Production Equipment")) {
										searchData="PRODUCTION_EQUIPMENT";
										
									}
									else if (searchData.equals("Raw Material")) {
										searchData="RAW_MATERIAL";
										
									}
									
									else if (searchData.equals("Finish Product")) {
										searchData="FINISH_PRODUCT";
										
									}
//									System.out.println(
//											str.toLowerCase() + " djkfshjhgk " + SearchCofirmData.toLowerCase());
									if (str.toLowerCase().contains(searchData.toLowerCase())) {
										corrct = corrct + 1;
									} 
								}
							} catch (Exception e) {
							}
							
						
						
					
						
						
					

					
				}
			}
				if (nextPage == true) {
					
					try {
						driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}	
			}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			PropertiesCommonMethods.cTestReports("Step-"+step+"--"+heding+" Column Single Search", "Data Count:-"+expacted+" & Matching Search Count:-"+expacted, "Data Count:-"+counte+" & Matching Search Count:-"+corrct, heding+"Columm");
			step=step+1;
			
			Object c1=null;
			Object c2=null;
			String c1s=null;
			String c2s=null;
			        c1=counte;
			        c1s=c1.toString();
			        c2=corrct;
			        c2s=c2.toString();
			       
			if (expacted.equals(c1s) & expacted.equals(c2s) ) {
				multi=multi+1;
				
			}
		}
		}
         Object io=j-3;
         String jk=io.toString();
		PropertiesCommonMethods.cTestReports("Step-"+step+"--"+"Multi Search Fianl Report", jk, multi, "Multi Search");
		
		
		try {
			driver.findElement(By.xpath("//th[1]")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {wait.until(ExpectedConditions.elementToBeClickable(
			driver.findElement(By.xpath("//*[text()='Reset All']/.."))));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
		driver.findElement(By.xpath("//*[text()='Reset All']/..")).click();
		try {
			Thread.sleep(1000);
			try {
				try {
					wait.until(ExpectedConditions
							.elementToBeClickable(driver.findElement(By.xpath("//ul/li//a[text()='1']/.."))));
				} catch (Exception e) {
				}
				driver.findElement(By.xpath("//ul/li//a[text()='1']/..")).click();
			} catch (Exception e) {
			}
			
		} catch (InterruptedException e) {
		}
		ActionCommonMethod.countDataTable(relaventTable);
		step=step+1;
		
		Object total=ActionCommonMethod.countOfData;
		String tyty=total.toString();
		PropertiesCommonMethods.cTestReports("Step-"+step+"--"+"Reset Function Test", Tatal, tyty, "Reset Funcation");}catch (Exception e) {
			
			String[]x=e.toString().split(":");
			PropertiesCommonMethods.cTestReports("Reset Function Test", true, false, x[1]);
		}
	}
@FindBy(xpath = "(//div[@class='ant-spin-container'])[1]")
public static WebElement table;
}