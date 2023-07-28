package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;

public class AddConfigureTest extends DriverIntialization {
	static String testname = null;
	static String testtype = null;
	static String prefix = null;
	static String maincatagory = null;

	static String subcatagory = null;
	static String material = null;
	static String discription = null;
	static String Procedure = null;
	static String reportformet = null;
	public static boolean active=false;
	public static boolean firstStepComplete=false;
	static DataFormatter dataValue=new DataFormatter();
	static boolean main=false;
	static boolean submit=false;
//	static	WebDriverWait wait = new WebDriverWait(driver, 3);
	
	public static void addConfigureTest(String name, String ExcelTabName, String TestcaseId) throws IOException, InterruptedException {
		int firstrow;
		int lastrow;
		XSSFSheet sheet;
		try {
			String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + name + ".xlsx";

			firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
			lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
			System.out.println(firstrow + " !!!! " + lastrow);
			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(ExcelTabName);
		
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow rowk = sheet.getRow(i);
			testname = dataValue.formatCellValue(rowk.getCell(1));

			testtype = dataValue.formatCellValue(rowk.getCell(2));
			prefix = dataValue.formatCellValue(rowk.getCell(3));
			maincatagory = dataValue.formatCellValue(rowk.getCell(4));
			subcatagory = dataValue.formatCellValue(rowk.getCell(5));
			material = dataValue.formatCellValue(rowk.getCell(6));
			discription = dataValue.formatCellValue(rowk.getCell(7));
			Procedure = dataValue.formatCellValue(rowk.getCell(8));
			reportformet = dataValue.formatCellValue(rowk.getCell(9));
			String active1 = dataValue.formatCellValue(rowk.getCell(10));
			String due1 = dataValue.formatCellValue(rowk.getCell(11));
			String duedays = dataValue.formatCellValue(rowk.getCell(12));
			
			active=Boolean.valueOf(active1);
			boolean due=Boolean.valueOf(due1);
			Thread.sleep(500);
		//	WebElement list = driver.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div/span"));
			boolean Value1 = false;
			boolean isExist = false;
			try {
				WebElement id = driver.findElement(By.id("test"));
				boolean value1 = id.isDisplayed();
			//	SampleCommonMethods.TestCasePrint("TEST DROP DOWN IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
			//	SampleCommonMethods.TestCasePrint("TEST DROP DOWN IS ENABLED", "true", String.valueOf(value2));
				id.click();
				//*********************************************************
				Actions actions = new Actions(driver);
				try {
	                boolean pass = false;
	                Thread.sleep(500);
	            
	              for (int i1 = 0; i1 < 1000; i1++) {
	                 if (!pass) {
	                     try {
	                         driver.findElement(
	                                 By.xpath("//div[@id='test_list']//..//span[text()='"+testname+"']"))
	                                 .click();
	                         pass = true;
	                     } catch (Exception e) {
	                     }
	                 }
	                 
	                 if (!pass) {
	                     actions.sendKeys(Keys.ARROW_DOWN).perform();
	                     Thread.sleep(200);
	                 } else {
	                     break;
	                 }
	                 
	             }        
	            } catch (Exception e) {
	            }
				
				//********************************************************
				
				
				
//				String NameXpath_firstPart = "/html/body/div[2]/div/div/div/div[2]/div[1]/div/div/div[";
//				String NameXpath_lastPart = "]";
//				String text=null;
//				String text1=null;
//				WebElement test = null;
//					for (int i1 = 2; i1 < 100; i1++) {
//						try {
//							Thread.sleep(3000);
//
//							test = driver.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[" +i1 + "]/div/span"));
//							System.out.println(test);
//							text=test.getText();
//							 Actions actions = new Actions(driver);
//							 actions.sendKeys(Keys.ARROW_DOWN).perform();
//							System.out.println(text);
//							if (text.equals(testname)) {
//								test.click();
//							//	Thread.sleep(2000);
//								
//								break;
//							}
////							else {
//////								
////
////									Actions actions = new Actions(driver);
////									 actions.sendKeys(Keys.ARROW_DOWN).perform();
////							
////							}
//						} catch (Exception e) {
//						}
//						
//						// text1=test.getText();
//						
//						if (text.equals(testname)) {
//							break;
//						}	
//					}
					
			
			//*******************************************************************
			
				
				

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("TEST DROP DOWN IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			Thread.sleep(500);
			try {
				WebElement id = driver.findElement(By.id("test_type"));
				boolean value1 = id.isDisplayed();
			//	SampleCommonMethods.TestCasePrint("TEST TYPE DROP DOWN IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
			//	SampleCommonMethods.TestCasePrint("TEST TYPE DROP DOWN IS ENABLED", "true", String.valueOf(value2));
				id.click();
				Thread.sleep(500);
				WebElement dro = driver.findElement(By.xpath("//div[@id='test_type_list']//..//div[contains(text(),'"+testtype+"')]"));
				dro.click();

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("TEST TYPE DROP DOWN IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			Thread.sleep(500);
			try {
				WebElement id = driver.findElement(By.id("prefix"));
				boolean value1 = id.isDisplayed();
				//SampleCommonMethods.TestCasePrint("PREFIX TEXT BOX IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
			//	SampleCommonMethods.TestCasePrint("PREFIX TEXT BOX IS ENABLED", "true", String.valueOf(value2));
				id.click();
				id.clear();
				id.sendKeys(prefix);

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("PREFIX TEXT BOX IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			Thread.sleep(500);
			try {
				WebElement id = driver.findElement(By.id("main_category"));
				boolean value1 = id.isDisplayed();
			//	SampleCommonMethods.TestCasePrint("MAIN CATEGORY DROP DOWN IS DISPLAYED", "true",String.valueOf(value1));
				boolean value2 = id.isEnabled();
			//	SampleCommonMethods.TestCasePrint("MAIN CATEGORY DROP DOWN IS ENABLED", "true", String.valueOf(value2));
				id.click();
				Actions actions = new Actions(driver);
				try {
	                boolean pass = false;
	                Thread.sleep(500);
	            
	              for (int i1 = 0; i1 < 50; i1++) {
	                 if (!pass) {
	                     try {
	                         driver.findElement(
	                                 By.xpath("//div[@id='main_category_list']//..//div[contains(text(),'"+maincatagory+"')]"))
	                                 .click();
	                         pass = true;
	                         main=true;
	                     } catch (Exception e) {
	                     }
	                 }
	                 
	                 if (!pass) {
	                     actions.sendKeys(Keys.ARROW_DOWN).perform();
	                     Thread.sleep(200);
	                 } else {
	                     break;
	                 }
	                 
	             }        
	            } catch (Exception e) {
	            }

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("MAIN CATEGORY DROP DOWN IS NOT THERE ", "true",
						String.valueOf(Value1), String.valueOf(e));

			}
			Thread.sleep(500);
			if(subcatagory.isEmpty()) {
				
			}
			else {
			if(main) {	
			try {
				WebElement id = driver.findElement(By.id("sub_category"));
				boolean value1 = id.isDisplayed();
			//	SampleCommonMethods.TestCasePrint("SUB CATEGORY DROP DOWN IS DISPLAYED", "true",String.valueOf(value1));
				boolean value2 = id.isEnabled();
			//	SampleCommonMethods.TestCasePrint("SUB CATEGORY DROP DOWN IS ENABLED", "true", String.valueOf(value2));
				id.click();
				Actions actions = new Actions(driver);
				try {
	                boolean pass = false;
	                Thread.sleep(500);
	            
	              for (int i1 = 0; i1 < 50; i1++) {
	                 if (!pass) {
	                     try {
	                         driver.findElement(
	                                 By.xpath("//div[@id='sub_category_list']//..//div[contains(text(),'"+subcatagory+"')]"))
	                                 .click();
	                         pass = true;
	                     } catch (Exception e) {
	                     }
	                 }
	                 
	                 if (!pass) {
	                     actions.sendKeys(Keys.ARROW_DOWN).perform();
	                     Thread.sleep(200);
	                 } else {
	                     break;
	                 }
	                 
	             }        
	            } catch (Exception e) {
	            }

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("SUB CATEGORY DROP DOWN IS NOT THERE ", "true",
						String.valueOf(Value1), String.valueOf(e));

			}
			}
			Thread.sleep(500);
			if(material.isEmpty()) { 
			} else {
			try { 
				WebElement id = driver.findElement(By.id("material"));
				boolean value1 = id.isDisplayed();
			//	SampleCommonMethods.TestCasePrint("MATERIAL DROP DOWN IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
			//	SampleCommonMethods.TestCasePrint("MATERIAL DROP DOWN IS ENABLED", "true", String.valueOf(value2));
				id.click();
				Actions actions = new Actions(driver);
				try {
	                boolean pass = false;
	                Thread.sleep(500);
	            
	              for (int i1 = 0; i1 < 50; i1++) {
	                 if (!pass) {
	                     try {
	                         driver.findElement(
	                                 By.xpath("//div[@id='material_list']//..//div[contains(@class,'ant-select-item-option-content')][normalize-space()='"+material+"']"))
	                                 .click();
	                         pass = true;
	                     } catch (Exception e) {
	                     }
	                 }
	                 
	                 if (!pass) {
	                     actions.sendKeys(Keys.ARROW_DOWN).perform();
	                     Thread.sleep(200);
	                 } else {
	                     break;
	                 }
	                 
	             }        
	            } catch (Exception e) { 
	            }

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("MATERIAL DROP DOWN IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
		}
			Thread.sleep(500);
			try {
				WebElement id = driver.findElement(By.id("description"));
				boolean value1 = id.isDisplayed();
			//	SampleCommonMethods.TestCasePrint("DESCRIPTION TEXT BOX IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
			//	SampleCommonMethods.TestCasePrint("DESCRIPTION TEXT BOX IS ENABLED", "true", String.valueOf(value2));
				id.click();
				id.clear();
				id.sendKeys(discription);

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("DESCRIPTION TEXT BOX IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			Thread.sleep(500);
			try {
				WebElement id = driver.findElement(By.id("procedure"));
				boolean value1 = id.isDisplayed();
		//		SampleCommonMethods.TestCasePrint("PROCEDURE TEXT BOX IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
			//	SampleCommonMethods.TestCasePrint("PROCEDURE TEXT BOX IS ENABLED", "true", String.valueOf(value2));
				id.click();
				id.clear();
				id.sendKeys(Procedure);

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("PROCEDURE TEXT BOX IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			Thread.sleep(500);
			try {
				WebElement id = driver.findElement(By.id("report_format"));
				boolean value1 = id.isDisplayed();
			//	SampleCommonMethods.TestCasePrint("REPORT FORMAT DROP DOWN IS DISPLAYED", "true",String.valueOf(value1));
				boolean value2 = id.isEnabled();
			//	SampleCommonMethods.TestCasePrint("REPORT FORMET DROP DOWN IS ENABLED", "true", String.valueOf(value2));
				id.click();
				Actions actions = new Actions(driver);
				try {
	                boolean pass = false;
	                Thread.sleep(500);
	            
	              for (int i1 = 0; i1 < 50; i1++) {
	                 if (!pass) {
	                     try {
	                         driver.findElement(
	                                 By.xpath("//div[contains(@title,'"+reportformet+"')]"))
	                                 .click();
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
				SampleCommonMethods.TestCasePrint("REPORT FORMET DROP DOWN IS NOT THERE ", "true",
						String.valueOf(Value1), String.valueOf(e));

			}
			Thread.sleep(500);
			// ********ACTIVE********
			try {
				WebElement id = driver.findElement(By.id("active"));
				boolean value1 = id.isDisplayed();
			//	SampleCommonMethods.TestCasePrint("ACTIVE BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
			//	SampleCommonMethods.TestCasePrint("ACTIVE BUTTON IS ENABLED", "true", String.valueOf(value2));
				boolean value3 = id.isSelected();
			//	SampleCommonMethods.TestCasePrint("ACTIVE BUTTON IS SELECTED", "true", String.valueOf(value3));
				if (value3 == active) {

				}
				

				else {
					id.click();
				}

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("ACTIVE BUTTON IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			Thread.sleep(500);
			// *****************************due

			try {
				WebElement id = driver.findElement(By.xpath("//button[@role='switch']"));
				boolean value1 = id.isDisplayed();
			//	SampleCommonMethods.TestCasePrint("DUE BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
			//	SampleCommonMethods.TestCasePrint("DUE BUTTON IS ENABLED", "true", String.valueOf(value2));
				boolean value3 = id.isSelected();
			//	SampleCommonMethods.TestCasePrint("DUE BUTTON IS SELECTED", "true", String.valueOf(value3));

				if (value3 == due) {
					if (value3) {

						try {
							WebElement idd = driver.findElement(By.xpath("//input[@id='dueDay']"));// dueDay
							boolean value4 = idd.isDisplayed();
						//	SampleCommonMethods.TestCasePrint("DUE BUTTON IS DISPLAYED", "true",String.valueOf(value4));
							boolean value5 = idd.isEnabled();
						//	SampleCommonMethods.TestCasePrint("DUE BUTTON IS ENABLED", "true", String.valueOf(value5));
							id.click();
							id.clear();
							id.sendKeys(duedays);

						} catch (Exception e) {
							SampleCommonMethods.TestCasePrint("DUE DATE BUTTON IS NOT THERE ", "true",
									String.valueOf(Value1), String.valueOf(e));
						}
					}

				}

				else {
					boolean value4 = false;
					WebElement idd= null;
					 id.click();
					try {idd = driver.findElement(By.xpath("//input[@id='dueDay']"));// dueDay
					 value4 = idd.isDisplayed();
					// SampleCommonMethods.TestCasePrint("DUE DATE BOX BUTTON IS DISPLAYED", "true",String.valueOf(value4));
						
					} catch (Exception e) {
						
					}
					
						if (value4) {
							try {
								
								
								boolean value5 = idd.isEnabled();
							//	SampleCommonMethods.TestCasePrint("DUE DATE BOX IS ENABLED", "true", String.valueOf(value5));
								idd.click();
								idd.clear();
								idd.sendKeys(duedays);

							} catch (Exception e) {
								SampleCommonMethods.TestCasePrint("DUE DATE TEXT BOX IS NOT THERE ", "true",
										String.valueOf(Value1), String.valueOf(e));
							}
						}
						
					
				}

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("ACTIVE BUTTON IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			Thread.sleep(500);
			try {
				WebElement element= driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-submit sc-gZMcBi jVssxC']"));
				boolean value1 = element.isDisplayed();
			//	SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = element.isEnabled();
			//	SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS ENABLED", "true", String.valueOf(value2));
				element.click();
				boolean heading=false;
				Thread.sleep(2000);
				try {
				//	wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(By.xpath("//div[contains(text(),'Configure Test')]"))));
					WebElement head= driver.findElement(By.xpath("//div[contains(text(),'Configure Test')]"));
					heading=head.isDisplayed();
					
				} catch (Exception e) {
					submit=true;
				}
				if (!heading) {
					submit=true;
				}
				
			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS NOT THERE ", "true", String.valueOf(Value1), String.valueOf(e));

			}
			
//			Thread.sleep(2000);
//			try {
//				WebElement element= driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary']"));
//				boolean value1 = element.isDisplayed();
//				
//				boolean value2 = element.isEnabled();
//				SampleCommonMethods.TestCasePrint("NEXT BUTTON IS ENABLED", "true", String.valueOf(value2));
//				element.click();
//
//			} catch (Exception e) {
//				SampleCommonMethods.TestCasePrint("NEXT BUTTON IS NOT THERE ", "true", String.valueOf(Value1), String.valueOf(e));
//
//			}

			}
			}
		
		
		} catch (FileNotFoundException e1) {
			SampleCommonMethods.TestCasePrint("EXCEL DATA IS NOT THERE");
		} catch (IOException e1) {
			SampleCommonMethods.TestCasePrint("EXCEL DATA IS NOT THERE");
		}
		catch (Exception e) {
			SampleCommonMethods.TestCasePrint("EXCEL DATA SHOULD BE CHECK");
		}
	}

}
