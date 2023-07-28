//***********************************************************************************
//* Description
//*------------
//* Equipment Search in Last Page
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 09/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        09/03/2023   Gobithan     Orginal Version
//*TC-EQU-0055
//************************************************************************************
package com.qa.automation.qdms.testcases.Equipment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;
import com.qa.automation.qdms.testcases.plantequipment.PlantEquipmentAddMethods;

public class EquipmentSearchFuncation extends DriverIntialization {
	static EquipmentPage equipment = new EquipmentPage();
	@Test
	public static void singleSearchEquipment() {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		PageFactory.initElements(driver, equipment);

		testCase = extent.createTest("TC-EQU-0055:- Checking  Equipment Field Search Functionality");
		
		EquipmentAddValidationTest.naviCationToEqu();
		
		if (MasterMainNavigationsTest.Equipmentclick) {
			PlantEquipmentAddMethods.dataFromPlanEqupment("Equipment", "TC-EQU-0055-01");
			
			EquipmentSearchFuncation.singleSearchMethoid(EquipmentPage.equipmentSearchBox,1,PlantEquipmentAddMethods.equipData.get(0),"Equipment Search Box",PlantEquipmentAddMethods.equipData.get(1),PlantEquipmentAddMethods.equipData.get(2));
			
			
		}
		if (EquipmentAddValidationTest.continu) {
			EquipmentAddValidationTest.continu=false;
			driver.navigate().refresh();
			MultiSearchMethods.Logout();
			
		}
		
	}
	
	
	
	public static void singleSearchMethoid(WebElement searchBox,int i,String searchdata, String data,String expactedcount,String totalcount) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 5);
		
		try {
			wait.until(
					ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//th["+i+"]/div/span[2]"))));
		} catch (Exception e) {
		}
		
		
		try {
			driver.findElement(By.xpath("//th["+i+"]/div/span[2]")).click();
			
			try {
				wait.until(ExpectedConditions.elementToBeClickable(searchBox));
			} catch (Exception e) {
			}
			
			ActionCommonMethod.sendkey(searchBox,searchdata, data);
			if (ActionCommonMethod.sendkey) {
				
				try {
					driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//button[1]")).click();
					PropertiesCommonMethods.cTestReports(data+" Search Button Funcation", true, true, "search Button");
				} catch (Exception e) {
					PropertiesCommonMethods.cTestReports(data+" Search Button Funcation", true, false, "search Button");
				}
				try {
					wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul/li[@title='1']"))));
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					driver.findElement(By.xpath("//ul/li[@title='1']")).click();
				} catch (Exception e) {
					// TODO: handle exception
				}
				int total=0;
				int lastcount = 0;
				boolean next = true;
				while (next) {
					int l = 0;
					Thread.sleep(2000);
					try {
						next = driver.findElement(By.xpath("//li[@title='Next Page']//button")).isEnabled();
					} catch (Exception e1) {
						next = false;
					}

					int k=1;
				try {
					 k = driver.findElements(By.xpath("//tr/td[" + i + "]")).size();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				for (int j = 1; j <=k; j++) {
					
					String gettex=null;
					
					try {
						gettex=	driver.findElement(By.xpath("//tbody/tr["+j+"][contains(@class,'ant-table-row')]/td["+i+"]")).getText().toUpperCase();
						total=total+1;
						
							if (!gettex.isEmpty()) {
								System.out.println(searchdata.toUpperCase()+"_mfkgmkm_"+gettex.toUpperCase());
								if (gettex.contains(searchdata.toUpperCase())) {
									lastcount = lastcount + 1;
									System.out.println(lastcount + "lastco");

								} 
							}
							
					} catch (Exception e) {
					}
				
				}
				
					if (next) {
						driver.findElement(By.xpath("//li[@title='Next Page']//button")).click();
					}

				}
				
					PropertiesCommonMethods.cTestReports(data + " Single Search", "Data Count:-"+expactedcount+" & Matching Search Count:-"+expactedcount, "Data Count:-"+total+" & Matching Search Count:-"+lastcount, data);
				
				try {
					driver.findElement(By.xpath("//th[" + i + "]/div/span[2]")).click();
					
					try {
						wait.until(ExpectedConditions.elementToBeClickable(driver
								.findElement(By.xpath("(//div[@class='ant-table-filter-dropdown']//button)[2]"))));
					} catch (Exception e) {
					}
					try {
						driver.findElement(By.xpath("(//div[@class='ant-table-filter-dropdown']//button)[2]"))
								.click();
						PropertiesCommonMethods.cTestReports(data+" Reset Button Funcation", true, true, "search Button");
						try {
						try {
							wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul/li[@title='1']"))));
						} catch (Exception e) {
							// TODO: handle exception
						}
						try {
							driver.findElement(By.xpath("//ul/li[@title='1']")).click();
						} catch (Exception e) {
							// TODO: handle exception
						}
						
						int aftotal=0;
						 next=true;
						while (next) {

							Thread.sleep(2000);
							

							int k=1;
						try {
							 k = driver.findElements(By.xpath("//tbody/tr")).size();
						} catch (Exception e) {
							// TODO: handle exception
						}
						
						for (int j = 1; j <=k; j++) {
							
							
							try {
								String	gettex=	driver.findElement(By.xpath("//tbody/tr["+j+"][contains(@class,'ant-table-row')]/td[1]")).getText();
								aftotal=aftotal+1;
							} catch (Exception e) {
							}
					
						
						
						}
						try {
							next = driver.findElement(By.xpath("//li[@title='Next Page']//button")).isEnabled();
						} catch (Exception e1) {
							next = false;
						}
						
							if (next) {
								Actions actio= new Actions(driver);
								actio.sendKeys(Keys.ARROW_DOWN).build().perform();
								try {
									wait.until(ExpectedConditions.elementToBeClickable(
											driver.findElement(By.xpath("//li[@title='Next Page']//button"))));
								} catch (Exception e) {
								}
								driver.findElement(By.xpath("//li[@title='Next Page']//button")).click();
								
							}

						
						}
						
						PropertiesCommonMethods.cTestReports(data + " Reset Button Funcation", totalcount, aftotal, data);
						}catch (Exception e) {
							extent.createTest("Reset Count UnCommplited ⚠️");
						}
					} catch (Exception e) {
						PropertiesCommonMethods.cTestReports(data + " Reset Button Funcation", false, true, data);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
			
			
			
			
		} catch (Exception e) {
			String[]x=e.toString().split(":");
			PropertiesCommonMethods.cTestReports("Click Search Icon", true, false, x[1]);
		}
		
		
	}
}
