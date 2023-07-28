/***********************************************************************************
* Description
*------------
*Single Search in Mix design Status 
***********************************************************************************
*
* Author           : Karunya Navanesan
* Date Written     : 01/05/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-MIX-DES-0057      01/05/2023    Karunya    Original Version
* TC-MIX-DES-0059
* TC-MIX-DES-0061
************************************************************************************/

package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.commonmethods.MixDesignNavigation;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class MixdesignStatussearchFunctionality extends DriverIntialization {
	static  MixDesignPage mps = new MixDesignPage();
	
	static String Searchstatus = null;
	static String expectedValue = null;
	
// ********************************************************************************************************
//	 THE METHOD IS FOR GENERATING REPORT 
//********************************************************************************************************		
	public static void TestCasePrint(String TestCaseName, String expectedValue, String actualValue) {
		boolean position = true;
		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			position = false;
		}
		if (position) {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "Expectedvalue :- " + expectedValue);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, actualValue);
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "ExpectedValue :- " + expectedValue);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, actualValue);
		}

	}
	
	 
	@Test
	 public static void mixdesignStatussearch() throws InterruptedException, IOException {
		 
         LoginTest.Login();
		 
		 MixDesignNavigation.mixDesignNavigation();
		 
		 mixdesignStatussearchIcon();
		 
		 mixdesignStatussearchTextbox();
		 
		 mixdesignStatussearchButton();
		
	}
	
	
	

	public static void mixdesignStatussearchIcon() throws InterruptedException {
		
//****************************************************************************************
//     	STEP-01--STATUS SEARCH ICON IS DISPLAYED &	STEP-02--STATUS SEARCH ICON IS ENABLED
//****************************************************************************************		
		 
		 PageFactory.initElements(driver, mps);
		 Thread.sleep(3000);
		
		 
		 if ( MixDesignPage.statusSearchIcon.isDisplayed()) {
				testCase = extent.createTest("STEP-01--STATUS SEARCH ICON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS");

				if ( MixDesignPage.statusSearchIcon.isEnabled()) {
					testCase = extent.createTest("STEP-02--STATUS SEARCH ICON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS");
					 MixDesignPage.statusSearchIcon.click();

				} else {
					testCase = extent.createTest("STEP-02-STATUS SEARCH ICON IS NOT ENABLED");
					testCase.log(Status.PASS, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("STEP-01--STATUS SEARCH ICON IS NOT DISPLAYED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		
	}
	
	public static void mixdesignStatussearchTextbox() throws InterruptedException, IOException {
		
//****************************************************************************************
//    	STEP-03--DATE SEARCH TEXTBOX IS DISPLAYED   &	STEP-04--DATE SEARCH TEXTBOX IS ENABLED
//****************************************************************************************	

		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(file);
	    XSSFSheet sheet = workbook.getSheet("Mix Design");
	    int rowcount = sheet.getLastRowNum();
	    
	    int firstrow = CommonMethods.getFirstRowNum(System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx","Mix Design","TC-MIX-DES-0059");
	    int lastrow = CommonMethods.getLastRowNum(System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx", "Mix Design", "TC-MIX-DES-0059");
	    
	    for (int i = firstrow; i <= lastrow; i++) {
	        XSSFRow row = sheet.getRow(i);
			Searchstatus = (String) row.getCell(1).getStringCellValue();
			expectedValue = (String) row.getCell(2).getStringCellValue();
	    }
	 Thread.sleep(3000);
	
	 if (MixDesignPage.statussearchTextbox.isDisplayed()) {
			testCase = extent.createTest("STEP-03--STATUS SEARCH TEXTBOX IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS");
			if (MixDesignPage.statussearchTextbox.isEnabled()) {
				testCase = extent.createTest("STEP-04---STATUS SEARCH TEXTBOX IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					MixDesignPage.statussearchTextbox.sendKeys(Searchstatus+(Keys.ENTER));

					Thread.sleep(3000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest("STEP-04---STATUS SEARCH TEXTBOX IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP-03---STATUS SEARCH TEXTBOX IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL");
		}
	
		
	}
	
	public static void mixdesignStatussearchButton() throws InterruptedException {
		
//************************************************************************************************************
//	   	STEP-05--STATUS SEARCH BUTTON DISPLAYED &	STEP-06--STATUS SEARCH BUTTON ENABLED
//************************************************************************************************************			
			
			 if (MixDesignPage.StatussearchButton.isDisplayed()) {
					testCase = extent.createTest("STEP-05--STATUS SEARCH BUTTON IS DISPLAYED");
					testCase.log(Status.PASS, "TEST PASS");
					if (MixDesignPage.StatussearchButton.isEnabled()) {
						testCase = extent.createTest("STEP-06---STATUS SEARCH BUTTON  IS ENABLED");
						testCase.log(Status.PASS, "TEST PASS");
						try {
							MixDesignPage.StatussearchButton.click();

							Thread.sleep(3000);

						} catch (Exception e) {

						}
					} else {
						testCase = extent.createTest("STEP-06---STATUS SEARCH BUTTON  IS NOT ENABLED");
						testCase.log(Status.PASS, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("STEP-05---STATUS SEARCH BUTTON  IS NOT DISPLAYED");
					testCase.log(Status.PASS, "TEST FAIL");
				}
			 
			// --------------------------------------------------------------------------------------  
			// compare actual and expect search Count from total count in pagination
			// --------------------------------------------------------------------------------------
			
			 boolean clickNextPage = true;
		        int actualElementCount = 0;
		        boolean passorfail = true;
		        ArrayList<String> ActualList = new ArrayList<String>();
		        ArrayList<String> ExpectedList = new ArrayList<String>();
		        String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[";
		        String NameXpath_lastPart = "]/td[8]";
		        while (clickNextPage) {
		            for (int i = 2; i < 750; i++) {
		                try {
		                    String textFull = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart))
		                            .getText();
		                    String text = textFull.toLowerCase();
		                    if (!text.contains(Searchstatus)) {
		                        passorfail = false;
		                    }
		                    if (text.contains(Searchstatus)) {
		                        ExpectedList.add(text);
		                    }
		                    ActualList.add(text);
		                    actualElementCount = actualElementCount + 1;
		                } catch (Exception e) {
		                }
		            }
		            if (clickNextPage == true) {
		            	Actions actions = new Actions(driver);
		                actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		                clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
		                        .isEnabled();
		                driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
		                Thread.sleep(2000);
		            } else {
		                break;
		            }
		        }
		
		 
		 try {
				int Value = actualElementCount;
				TestCasePrint("STEP-10--SINGLE SEARCH CONFIRM", expectedValue, String.valueOf(Value));
			} catch (Exception e) {

			}

	}
}
