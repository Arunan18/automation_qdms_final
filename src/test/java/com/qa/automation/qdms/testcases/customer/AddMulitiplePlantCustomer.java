  
//****************************************************************************************
//		DESCRIPTION
//------------------
//					ADD MULTIPLE PLANT ALLOCATE CUSTOMER DROPDOWN FUNCTION
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   13:03:2023	
//****************************************************************************************
//* Test Case Number     	  Date          Intis        Comments
//* ================       	  ======       ========      ========
//*  TC-CUS-0097             13.03.2023   @SASIKALA     Original Version
//*	 
//****************************************************************************************


package com.qa.automation.qdms.testcases.customer;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class AddMulitiplePlantCustomer extends DriverIntialization{
	static CustomerPage customerfunpg = new CustomerPage();
	
//********************************************************************************************
	static String PlantnametobeSelect = "";
	static String PlantSelect = "";
	static String Customername = "";
	static String Email = "";
	static String Address = "";
	static int ContactNumber = 151454548;
	static String Successmsg = "";
	static String Confirmcustomername ="";


/**********************************************************************************************
 * 							Customer Add Form Functional
//**********************************************************************************************/

					@Test(priority = 1)
					public static void fieldvisible() throws InterruptedException, IOException {
						PageFactory.initElements(driver, customerfunpg);
						
//****************************************************************************************						
		// 						Login & Click Master Module
//****************************************************************************************
						CustomerMethods.custombasicway();

//****************************************************************************************						
		// 						Customer Menu Navigation
//****************************************************************************************					
						CustomerMethods.customerMenuMethod();

//****************************************************************************************						
		// 						Customer Site Bar Navigation
//****************************************************************************************					
						CustomerMethods.custombarsitebuttonMethod();
}
					
//****************************************************************************************
			/*******Customer ADD BUTTON VISIBLE & ENABLED******************/
//*****************************************************************************************
					@Test(priority = 2)
						public static void field() throws InterruptedException, IOException {
							PageFactory.initElements(driver, customerfunpg);		 
							Thread.sleep(2000);
							if (CustomerPage.AddCustomerbtn.isDisplayed()) {
								testCase = extent.createTest("CUSTOMER ADD BUTTON VISIBLE");
								testCase.log(Status.PASS, "TEST PASS");
								if (CustomerPage.AddCustomerbtn.isEnabled()) {
									testCase = extent.createTest("CUSTOMER ADD BUTTON IS ENABLED");
									testCase.log(Status.PASS, "TEST PASS");
									try {
										CustomerPage.AddCustomerbtn.click();
										Thread.sleep(2000);
									} catch (Exception e) {
						
									}
						
								} else {
									testCase = extent.createTest("CUSTOMER ADD BUTTON IS ENABLED");
									testCase.log(Status.PASS, "TEST FAIL");
								}
							} else {
								testCase = extent.createTest("CUSTOMER ADD BUTTON VISIBLE");
								testCase.log(Status.FAIL, "TEST FAIL");
							}
								
						
		/*******************************ADD CUSTOMER FORM PLANT FIELD VISIBLE & ENABLED*********************************/
						 
						Thread.sleep(2000);
						if (CustomerPage.Customerplantfiled.isDisplayed()) {
							testCase = extent.createTest("ADD CUSTOMER FORM DELIVERY FIELD VISIBLE");
							testCase.log(Status.PASS, "TEST PASS");
							if (CustomerPage.Customerplantfiled.isEnabled()) {
								testCase = extent.createTest("CUSTOMER FORM PLANT FIELD IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS");
								try {
									CustomerPage.Customerplantfiled.click();
									
									
								

      								} catch (Exception e) {
					
								}
					
							} else {
								testCase = extent.createTest("CUSTOMER FORM PLANT FIELD IS ENABLED");
								testCase.log(Status.FAIL, "TEST FAIL");
							}
						} else {
							testCase = extent.createTest("ADD CUSTOMER FORM PLANT FIELD VISIBLE");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
						
						
						
						
						FileInputStream file = new FileInputStream(
								System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
						XSSFWorkbook workbook = new XSSFWorkbook(file);
						XSSFSheet sheet = workbook.getSheet("Customer");

						int firstrow = CommonMethods.getFirstRowNum(
								System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx",
								"Customer", "TC-CUS-0097");
						int lastrow = CommonMethods.getLastRowNum(
								System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx",
								"Customer", "TC-CUS-0097");
						for (int j = firstrow; j <= lastrow; j++) {
							XSSFRow row = sheet.getRow(j);

							String PlantnametobeSelect = (String) row.getCell(1).getStringCellValue();
							String PlantSelect = (String) row.getCell(2).getStringCellValue();
							String Customername = (String) row.getCell(3).getStringCellValue();
							String Email = (String) row.getCell(4).getStringCellValue();
							String Address = (String) row.getCell(5).getStringCellValue();
							int ContactNumber = (int) row.getCell(6).getNumericCellValue();
							String Successmsg = (String) row.getCell(7).getStringCellValue();
							Confirmcustomername = (String) row.getCell(8).getStringCellValue();
							Thread.sleep(2000);		
						
						
							Thread.sleep(2000);
						Actions actions = new Actions(driver);


						String x = PlantnametobeSelect;
						
						boolean notfound = true;
				        while (notfound) {
				            try {
				                driver.findElement(By.xpath("//div[contains(text(),'" + x +"')]")).click();
				                notfound = false;
				            } catch (Exception e) {
				                actions.sendKeys(Keys.ARROW_DOWN).perform();
				            }
				        }
				        Thread.sleep(2000);
				
						String y = PlantSelect;
						
						boolean notfounds = true;
				        while (notfounds) {
				            try {
				                driver.findElement(By.xpath("//div[contains(text(),'" + y +"')]")).click();
				                notfounds = false;
				            } catch (Exception e) {
				                actions.sendKeys(Keys.ARROW_DOWN).perform();
				            }
				        }
				        
				        CustomerPage.AddCustomerheader.click();
						
				
//*************************************************************************************				
				
				
				Thread.sleep(2000);			
		
				if (CustomerPage.CustomerFiled.isDisplayed()) {
					testCase = extent.createTest("CUSTOMER FIELD VISIBLE");
					testCase.log(Status.PASS, "TEST PASS");
					if (CustomerPage.CustomerFiled.isEnabled()) {
						testCase = extent.createTest("CUSTOMER FIELD IS ENABLED");
						testCase.log(Status.PASS, "TEST PASS");
						try {
							CustomerPage.CustomerFiled.click();
							CustomerPage.CustomerFiled.sendKeys(Customername);
							Thread.sleep(2000);
						} catch (Exception e) {
			
						}
			
					} else {
						testCase = extent.createTest("CUSTOMER FIELD IS ENABLED");
						testCase.log(Status.PASS, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("CUSTOMER FIELD VISIBLE");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
					
				
	//*****************************************************************************************			
				
				
				Thread.sleep(1000);
				if (CustomerPage.CustomerEmailFiled.isDisplayed()) {
					testCase = extent.createTest("CUSTOMER EMAIL FIELD VISIBLE");
					testCase.log(Status.PASS, "TEST PASS");
					if (CustomerPage.CustomerEmailFiled.isEnabled()) {
						testCase = extent.createTest("CUSTOMER EMAIL FIELD IS ENABLED");
						testCase.log(Status.PASS, "TEST PASS");
						try {
							CustomerPage.CustomerEmailFiled.click();
							CustomerPage.CustomerEmailFiled.sendKeys(Email);
							Thread.sleep(2000);
						} catch (Exception e) {
			
						}
			
					} else {
						testCase = extent.createTest("CUSTOMER EMAIL FIELD IS ENABLED");
						testCase.log(Status.PASS, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("CUSTOMER EMAIL FIELD VISIBLE");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
					
				
//******************************************************************************************	
				Thread.sleep(1000);
				if (CustomerPage.CustomerAddressFiled.isDisplayed()) {
					testCase = extent.createTest("CUSTOMER ADDRESS FIELD VISIBLE");
					testCase.log(Status.PASS, "TEST PASS");
					if (CustomerPage.CustomerAddressFiled.isEnabled()) {
						testCase = extent.createTest("CUSTOMER ADDRESS FIELD IS ENABLED");
						testCase.log(Status.PASS, "TEST PASS");
						try {
							CustomerPage.CustomerAddressFiled.click();
							CustomerPage.CustomerAddressFiled.sendKeys(Address);
							Thread.sleep(2000);
						} catch (Exception e) {
			
						}
			
					} else {
						testCase = extent.createTest("CUSTOMER ADDRESS FILED IS ENABLED");
						testCase.log(Status.PASS, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("CUSTOMER ADDRESS FIELD VISIBLE");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
									
//*****************************************************************************************
				Thread.sleep(1000);
				if (CustomerPage.CustomerContactNoFiled.isDisplayed()) {
					testCase = extent.createTest("CUSTOMER CONTACT NUMBER FIELD VISIBLE");
					testCase.log(Status.PASS, "TEST PASS");
					if (CustomerPage.CustomerContactNoFiled.isEnabled()) {
						testCase = extent.createTest("CUSTOMER CONTACT NUMBER FIELD IS ENABLED");
						testCase.log(Status.PASS, "TEST PASS");
						try {
							CustomerPage.CustomerContactNoFiled.click();
							CustomerPage.CustomerContactNoFiled.sendKeys(String.valueOf(ContactNumber));
							Thread.sleep(2000);
						} catch (Exception e) {
			
						}
			
					} else {
						testCase = extent.createTest("CUSTOMER CONTACT NUMBER FILED IS ENABLED");
						testCase.log(Status.PASS, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("CUSTOMER CONTACT NUMBER FILED VISIBLE");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
														
//*******************************************************************************
												
				Thread.sleep(1000);
				if (CustomerPage.Customersavebtn.isDisplayed()) {
					testCase = extent.createTest("CUSTOMER SAVE BUTTON VISIBLE");
					testCase.log(Status.PASS, "TEST PASS");
					if (CustomerPage.Customersavebtn.isEnabled()) {
						testCase = extent.createTest("CUSTOMER SAVE BUTTON IS ENABLED");
						testCase.log(Status.PASS, "TEST PASS");
						try {
							CustomerPage.Customersavebtn.click();
							Thread.sleep(2000);
						} catch (Exception e) {
			
						}
			
					} else {
						testCase = extent.createTest("CUSTOMER SAVE BUTTON IS ENABLED");
						testCase.log(Status.PASS, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("CUSTOMER SAVE BUTTON VISIBLE");
					testCase.log(Status.FAIL, "TEST FAIL");
				}			
				
//*************************************************************************************
				
				Thread.sleep(1000);
		        String AddSuccessMessage = CustomerPage.AddCustomersuccessmsg.getText();
		        System.out.println(AddSuccessMessage);
		        String expectedatamsg = Successmsg;
		        
		        
		         testCase = extent.createTest("Data Added Success Message");
		                try {
		                    Assert.assertEquals(AddSuccessMessage, expectedatamsg);
		                    testCase.log(Status.INFO, "Actual Data :- " + AddSuccessMessage);
		                    testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
		                    testCase.log(Status.PASS, "Success Message Enable");
		                } catch (AssertionError e) {
		                	        
		                    testCase.log(Status.INFO, "Actual Data :- " + AddSuccessMessage);
		                    testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
		                    testCase.log(Status.FAIL, "Wrong Success Message Not Enable");
		                }	
		}
					}
		
//****************************************************************************************			
//	 					CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE
//****************************************************************************************
		@Test(priority = 6)		
		public static  void checkLastAddvalue() throws InterruptedException, IOException {
			CustomerPage customerfunpg = new CustomerPage();
		PageFactory.initElements(driver, customerfunpg);
		
			Thread.sleep(2000);
			String actualdata = CustomerPage.AddCustomerfirstdata.getText();
			System.out.println("First row of table : " + actualdata);

		
			String expecteddata =Confirmcustomername;
		
			boolean firstdata = true;
			testCase = extent.createTest("CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE");
					try {
						AssertJUnit.assertEquals(actualdata, expecteddata);
				
					} catch (AssertionError e) {
						firstdata = false;
					}
					if (firstdata) {
						testCase.log(Status.INFO, "Actual Data :- " + actualdata);
						testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
						testCase.log(Status.PASS, "Correct last added data");
					} else {
						testCase.log(Status.INFO, "Actual Data :- " + actualdata);
						testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
						testCase.log(Status.FAIL, "Wrong last added data");
					}
	}
		@Test(priority = 7)
		public static void LogoutMethod() throws InterruptedException {
			Thread.sleep(1000);
			PageFactory.initElements(driver, customerfunpg);
			MultiSearchMethods.Logout();

		}
}
