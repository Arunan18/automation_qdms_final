package com.qa.automation.qdms.testconfig.testcases.configgrouptest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
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

public class AddConfigGroupTest extends DriverIntialization {
	

	public static void addConfigGroupTest(String name, String ExcelTabName, String TestcaseId) throws InterruptedException, IOException {
		DataFormatter dataformet=new DataFormatter();
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + name + ".xlsx";
		boolean Value1 = false;
		int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
		int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
		System.out.println(firstrow+"ffffffffff");
		System.out.println(lastrow+"lllllllllll");
		XSSFWorkbook workbook = null;
		try {
			FileInputStream file = new FileInputStream(excelPath);
		 workbook = new XSSFWorkbook(file);
		
			
		
		XSSFSheet sheet = workbook.getSheet(ExcelTabName);
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow rowk = sheet.getRow(i);
			String MaterialMainCategory = dataformet.formatCellValue(rowk.getCell(1));
			
			System.out.println(MaterialMainCategory+"***/*********///////*");
			String SubCategory =dataformet.formatCellValue(rowk.getCell(2));
			String Material = dataformet.formatCellValue(rowk.getCell(3));
			String reporttype =dataformet.formatCellValue(rowk.getCell(4));
			String SpecialCategory = dataformet.formatCellValue(rowk.getCell(5));
			
			String groupname = dataformet.formatCellValue(rowk.getCell(6));
			String REPORT = dataformet.formatCellValue(rowk.getCell(7));
			String count1 = dataformet.formatCellValue(rowk.getCell(8));
			
			int count=Integer.valueOf(count1);
			
			//*********MaterialMainCategory**************
			
			try {
				Thread.sleep(3000);
				WebElement id = driver.findElement(By.id("material_category"));
				boolean value1 = id.isDisplayed();
				SampleCommonMethods.TestCasePrint("Material Main Category DROP DOWN IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("Material Main Category DROP DOWN IS ENABLED", "true", String.valueOf(value2));
				id.click();
 
				Actions actions = new Actions(driver);
				try {
					boolean pass = false;
					Thread.sleep(1000);

					for (int i1 = 0; i1 < 1000; i1++) {
						if (!pass) {
							try {
								WebElement list = driver
										.findElement(By.xpath("//div[contains(@title,'" + MaterialMainCategory + "')]//div[1]"));
								System.out.println(list);
								list.click();
								Thread.sleep(2000);
								

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
				SampleCommonMethods.TestCasePrint("Material Main Category DROP DOWN IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			//*****************SubCategory******
			Thread.sleep(3000);
			if (SubCategory!="") {
				
			
			try {
				Thread.sleep(3000);
				WebElement id = driver
						.findElement(By.id("sub_category"));
				boolean value1 = id.isDisplayed();
				SampleCommonMethods.TestCasePrint("Sub Category DROP DOWN IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("Sub Category DROP DOWN IS ENABLED", "true", String.valueOf(value2));
				id.click();

				Actions actions = new Actions(driver);
				try {
					boolean pass = false;
					Thread.sleep(1000);

					for (int i1 = 0; i1 < 1000; i1++) {
						if (!pass) {
							try {
								WebElement list = driver
										.findElement(By.xpath("//div[contains(@title,'" + SubCategory + "')]//div[1]"));
								System.out.println(list);
								list.click();
								Thread.sleep(2000);
								

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
				SampleCommonMethods.TestCasePrint("Sub Category DROP DOWN IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}}
			//**********************material*****************************
			Thread.sleep(3000);
			if (Material!="") {
				
			
			try {
				Thread.sleep(3000);
				WebElement id = driver
						.findElement(By.id("material"));
				boolean value1 = id.isDisplayed();
				SampleCommonMethods.TestCasePrint("Select Material DROP DOWN IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("Select Material DROP DOWN IS ENABLED", "true", String.valueOf(value2));
				id.click();

				Actions actions = new Actions(driver);
				try {
					boolean pass = false;
					Thread.sleep(1000);

					for (int i1 = 0; i1 < 1000; i1++) {
						if (!pass) {
							try {
								WebElement list = driver
										.findElement(By.xpath("//div[contains(@title,'" + Material + "')]//div[1]"));
								System.out.println(list);
								list.click();
								Thread.sleep(2000);
								

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
				SampleCommonMethods.TestCasePrint("Select Material DROP DOWN IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}}
			//***************report type**************
			Thread.sleep(3000);
if (reporttype.equals("true")) {
	

			
			try {
				Thread.sleep(3000);
				WebElement id = driver.findElement(By.xpath("(//span[@class='ant-checkbox-inner'])[1]"));
				boolean value1 = id.isDisplayed();
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS ENABLED", "true", String.valueOf(value2));
				WebElement id1 = driver.findElement(By.xpath("//input[@value='REPORT']"));
				Thread.sleep(2000);
				
				boolean value3 = id1.isSelected();
				String v3 = String.valueOf(value3);
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS SELECTED", "false", String.valueOf(value3));
				if (reporttype.equals(v3)) {

				}

				else {
					id1.click();
				}

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}}
			
			
			//*************Special Category*********************************

if (SpecialCategory.equals("true")) {
	

			
			try {
				Thread.sleep(3000);
				WebElement id = driver.findElement(By.xpath("(//span[@class='ant-checkbox-inner'])[2]"));
				boolean value1 = id.isDisplayed();
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS ENABLED", "true", String.valueOf(value2));
				WebElement id2 = driver.findElement(By.xpath("//input[@value='STATUS']"));
				Thread.sleep(2000);
				boolean value3 = id2.isSelected();
				String v3 = String.valueOf(value3);
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS SELECTED", "false", String.valueOf(value3));
				if (SpecialCategory.equals(v3)) {

				}

				else {
					id2.click();
				}

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}}
			//*******check box end
			// *********group name******
			Thread.sleep(3000);
			if (groupname!="") {
				
			
			try {
				Thread.sleep(3000);
				WebElement id = driver.findElement(By.id("group_name"));
				boolean value1 = id.isDisplayed();
				SampleCommonMethods.TestCasePrint("RESULT MINIMUM VALUE TEXT BOX IS DISPLAYED", "true",
						String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("RESULTS MINIMUM VALUE TEXT BOX IS ENABLED", "true", String.valueOf(value2));
				id.click();
				id.clear();
				id.sendKeys(groupname);

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("RESULTS MINIMUM VALUE TEXT BOX IS NOT THERE ", "true",
						String.valueOf(Value1), String.valueOf(e));

			}}
			// ******report type drop down ******
			Thread.sleep(3000);
			if (reporttype!=""&&reporttype.equals("true")) {
				
			
			try {
				Thread.sleep(3000);
				WebElement id = driver
						.findElement(By.xpath("//input[@id='report']"));
				//boolean value1 = id.isDisplayed();
				//SampleCommonMethods.TestCasePrint("TEST RESULT CONDITION DROP DOWN IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("TEST RESULT CONDITION DROP DOWN IS ENABLED", "true", String.valueOf(value2));
				id.click();

				Actions actions = new Actions(driver);
				try {
					boolean pass = false;
					Thread.sleep(1000);

					for (int i1 = 0; i1 < 1000; i1++) {
						if (!pass) {
							try {
								WebElement list = driver
										.findElement(By.xpath("//div[contains(@title,'" + REPORT + "')]//div[1]"));
								System.out.println(list);
								list.click();
								Thread.sleep(2000);
								

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
				SampleCommonMethods.TestCasePrint("TEST RESULTS CONDITION DROP DOWN IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}}
			//******************report typr dropdown end *******
			
			try {
				System.out.println(count+"jjjjjjjjjjj");
				for (int i1 = 1; i1 <= count; i1++) {
				String test = rowk.getCell(8+i1).getStringCellValue();
				System.out.println(test+"kkkkkkkkkk");
				WebElement tick4 = driver
						.findElement(By.xpath("//td[text()='"+test+"']/../td[1]"));
				
					
				tick4.click();
				Thread.sleep(2000);}
			}catch (Exception e) {
				
			}

			
			try {
				Thread.sleep(3000);
				WebElement element= driver.findElement(By.xpath("//span[normalize-space()='Save']"));
				boolean value1 = element.isDisplayed();
				SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = element.isEnabled();
				SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS ENABLED", "true", String.valueOf(value2));
				element.click();
				Thread.sleep(3000);
				
			

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS NOT THERE ", "true", String.valueOf(Value1), String.valueOf(e));

			}
				
			
//	conform add config group test in manage group test
		try {
			Thread.sleep(3000);
			WebElement element= driver.findElement(By.xpath("//a[@href='#/managetests']"));
			boolean value1 = element.isDisplayed();
		//	SampleCommonMethods.TestCasePrint("MANAGE TEST BUTTON IS DISPLAYED", "true", String.valueOf(value1));
			boolean value2 = element.isEnabled();
		//	SampleCommonMethods.TestCasePrint("MANAGE TEST BUTTON IS ENABLED", "true", String.valueOf(value2));
			element.click();
			Thread.sleep(5000);
			driver.navigate().refresh();
			
			
			try {
				Thread.sleep(6000);
				WebElement element1= driver.findElement(By.xpath("//div[@class='sc-dnqmqq fyMRQD'][normalize-space()='Group Tests']"));
				boolean value11 = element1.isDisplayed();
			//	SampleCommonMethods.TestCasePrint("MANAGE TEST BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value21 = element1.isEnabled();
			//	SampleCommonMethods.TestCasePrint("MANAGE TEST BUTTON IS ENABLED", "true", String.valueOf(value2));
				element1.click();
				
				
			
				Thread.sleep(6000);
				boolean clickNextPage = true;
				boolean sbuExist = false;
				int size = 0;
				while (clickNextPage) {
					Thread.sleep(2000); 
					List <WebElement> datacolumn= driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr"));
					System.out.println(datacolumn+"/****////****/**/*//*/");
					try {
						 size = datacolumn.size();
						 System.err.println(size);
						} catch (NoSuchElementException e) {
							CommonMethods.TestCasePrint("Table column Web Element Not There");
				
					
						}
					if (size>0) {
						System.out.println(size+"**********");
				
				for (int i1 = 1; i1 <= size; i1++) {
					WebElement Groupname = driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr["+i1+"]/td[1]"));
					System.out.println(Groupname+"xxxxxxxxx");
					try {
						Thread.sleep(2000);
					
					String value= Groupname.getText();
					System.out.println(value+"///////*********///////");
					System.out.println(groupname+"/***kkkkkkkkkkkkkk");
					if (value.contains(groupname)) {
						clickNextPage=false;
						for (int i2=1; i2<=4;i2++) {
							try {
								String Gname = null;
								WebElement data = driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr["+i1+"]/td["+i2+"]"));
								String datavalue= data.getText();
								if (i2==1) {
									 Gname="Group Name";
									 SampleCommonMethods.TestCasePrint(Gname, groupname, String.valueOf(datavalue));
								}
								else if (i2==2) {
									Gname="Main Category";
									SampleCommonMethods.TestCasePrint(Gname, MaterialMainCategory, String.valueOf(datavalue));
								} else if(i2==3) {
									Gname="Sub Category";
									SampleCommonMethods.TestCasePrint(Gname, SubCategory, String.valueOf(datavalue));
								}else if(i2==4) {
									Gname="Raw Material";
									SampleCommonMethods.TestCasePrint(Gname, Material, String.valueOf(datavalue));
								}else if(i2==5) {
									Gname="Group Type";
									SampleCommonMethods.TestCasePrint(Gname, Material, String.valueOf(datavalue));
								}
								
								
							} catch (Exception e) {
								SampleCommonMethods.TestCasePrint("GROUP TEST BUTTON IS NOT THERE ", "true", String.valueOf(Value1), String.valueOf(e));
							}
						
						
						
						}
						
						
					}
					else {
						WebElement nextpage= driver.findElement(By.xpath("//span[@aria-label='right']//*[name()='svg']"));
						clickNextPage = nextpage.isEnabled();
						if (clickNextPage == true) {
							Thread.sleep(2000);
							nextpage.click();
						}
					}
					} catch (Exception e) {
						SampleCommonMethods.TestCasePrint("CONFIG GROUP TEST IS NOT THERE ", "true", String.valueOf(Value1), String.valueOf(e));
					}
					if (clickNextPage==false) {
						break;
						
					}
				}
					}
					
				}
			

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("GROUP TEST BUTTON IS NOT THERE ", "true", String.valueOf(Value1), String.valueOf(e));

			}
		

		} catch (Exception e) {
			SampleCommonMethods.TestCasePrint("MANAGE TEST BUTTON IS NOT THERE ", "true", String.valueOf(Value1), String.valueOf(e));

		}
	
		}
} catch (Exception e) {
	SampleCommonMethods.TestCasePrint("excel data should be check ", "", String.valueOf(Value1), String.valueOf(e));
		}
	}

}
