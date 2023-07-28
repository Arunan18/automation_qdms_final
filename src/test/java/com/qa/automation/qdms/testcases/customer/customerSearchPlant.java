
//****************************************************************************************
//		DESCRIPTION
//------------------
//					CUSTOMER PLANT SEARCH FUNCTION
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   10:03:2023	
//****************************************************************************************
//* Test Case Number     	  Date          Intis        Comments
//* ================       	  ======       ========      ========
//*  TC-CUS-0021             27.03.2023   @SASIKALA     Original Version
//*	 TC-CUS-0022			 27.03.2023	  @SASIKALA		Original Version
//* 					 	 11.07.2023	  @Sasikala     Modified
//*  TC-CUS-0021             13/07/2023   Priyanka      Updated
//*  TC-CUS-0022             13/07/2023   Priyanka      Updated
//*  TC-CUS-0023             13/07/2023   Priyanka      Updated
//****************************************************************************************

package com.qa.automation.qdms.testcases.customer;

import java.io.IOException;
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
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plantequipment.PlantEquipmentAddMethods;

public class customerSearchPlant extends DriverIntialization {
	static CustomerPage customerfunpg = new CustomerPage();

	@Test
	public static void Customersearch() throws InterruptedException, IOException {
		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateCustomerMain();
		}

		if (MasterMainNavigationsTest.clickCustomermain) {

			MasterMainNavigationsTest.navigateCustomer();

		}

		if (MasterMainNavigationsTest.clickCustomer) {

			PageFactory.initElements(driver, customerfunpg);
			PlantEquipmentAddMethods.dataFromPlanEqupment("Customer", "TC-CUS-0022-01");
			customerSearchPlant.singleSearchIcon(CustomerPage.SearchTextBox,2,PlantEquipmentAddMethods.equipData.get(0),"Equipment Search Box",PlantEquipmentAddMethods.equipData.get(1),PlantEquipmentAddMethods.equipData.get(2));

		}

		Logout.LogoutFunction();

	}
	public static void singleSearchIcon(WebElement searchBox,int i,String searchdata, String data,String expactedcount,String totalcount) {

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
//			Thread.sleep(3000);
			if (ActionCommonMethod.sendkey) {
				
				try {
					driver.findElement(By.xpath("(//div[@class='ant-table-filter-dropdown']//button)[1]")).click();
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
					int kk=1;
					int xc=0;
					Thread.sleep(2000);
					try {
						next = driver.findElement(By.xpath("//li[@title='Next Page']//button")).isEnabled();
					} catch (Exception e1) {
						next = false;
					}
					 xc=	driver.findElements(By.xpath("//tr[contains(@class,'ant-table-row')]/td["+i+"]//*[@viewBox]")).size();
						total=total+xc;
					int k=1;
				try {
					 k = driver.findElements(By.xpath("//tr/td[" + i + "]")).size();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				for (int j = 1; j <=k; j++) {
					
					String gettex=null;
					
					try {
						
						try {
							driver.findElement(By.xpath(
									"//tr[" + j + "][contains(@class,'ant-table-row')]/td[" + i + "]//*[@viewBox]"))
									.click();
							try {
								try {
									wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(
											By.xpath("(//div[@class='ant-popover-inner-content'])[" + kk + "]"))));
								} catch (Exception e) {
									// TODO: handle exception
								}
								Thread.sleep(1000);
								gettex=	driver.findElement(By.xpath("(//div[@class='ant-popover-inner-content'])["+kk+"]")).getText().toUpperCase();
								kk++;
								if (!gettex.isEmpty()) {
									System.out.println(searchdata.toUpperCase() + "_mfkgmkm_" + gettex.toUpperCase());
									if (gettex.contains(searchdata.toUpperCase())) {
										lastcount = lastcount + 1;
										System.out.println(lastcount + "lastco");
										
									}
								}
								try {
									driver.findElement(By.xpath("//tr[" + j + "][contains(@class,'ant-table-row')]/td["
											+ i + "]//*[@viewBox]")).click();
								} catch (Exception e) {
									// TODO: handle exception
								}
							} catch (Exception e) {
								// TODO: handle exception
							} 
						} catch (Exception e) {
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
