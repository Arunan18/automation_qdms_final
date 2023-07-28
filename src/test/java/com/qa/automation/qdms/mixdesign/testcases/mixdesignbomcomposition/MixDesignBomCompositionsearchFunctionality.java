/***********************************************************************************
* Description
*------------
*Single Search  in BOM COMPOSITION 
***********************************************************************************
*
* Author           : Karunya Navanesan
* Date Written     : 28/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-MIX-DES-0041      28/04/2023    Karunya    Original Version
* TC-MIX-DES-0043
* TC-MIX-DES-0045    
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

public class MixDesignBomCompositionsearchFunctionality extends DriverIntialization{
	static  MixDesignPage mps = new MixDesignPage();
    static String Searchitem = null;
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
	public void mixDesignBomCompositionsearchicon() throws InterruptedException, IOException {
		// _______________________________________________________________
				// LOGIN
				// _______________________________________________________________

						LoginTest.Login();
								
				// _______________________________________________________________
				// NAVIAGATE TO MIX DESIGN COMPOSITION
				// _______________________________________________________________

						MixDesignNavigation.mixDesignNavigation();
									
						MixDesignBomCompositionsearchFunctionality.mixDesignBomCompositionsearchiconFunctionality();
									
						MixDesignBomCompositionsearchFunctionality.mixDesignBomCompositionsearchtextboxFunctionality();
						
						MixDesignBomCompositionsearchFunctionality.mixDesignBomCompositionsearchButtonFunctionality();
		
	}
	

	
	public static void mixDesignBomCompositionsearchiconFunctionality() throws InterruptedException {

//****************************************************************************************
//    	STEP-01--BOM COMPOSITION SEARCH ICON IS DISPLAYED &	STEP-02--BOM COMPOSITION ICON IS ENABLED
//****************************************************************************************		
		 
		 PageFactory.initElements(driver, mps);
		 Thread.sleep(3000);
		
		 
		 if ( MixDesignPage.mixdesignbomcompositionsearchicon.isDisplayed()) {
				testCase = extent.createTest("STEP-01--BOM COMPOSITION SEARCH ICON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS");

				if ( MixDesignPage.mixdesignbomcompositionsearchicon.isEnabled()) {
					testCase = extent.createTest("STEP-02--BOM COMPOSITION SEARCH ICON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS");
					 MixDesignPage.mixdesignbomcompositionsearchicon.click();

				} else {
					testCase = extent.createTest("STEP-02-BOM COMPOSITION SEARCH ICON IS NOT ENABLED");
					testCase.log(Status.PASS, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("STEP-01--BOM COMPOSITION SEARCH ICON IS NOT DISPLAYED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		
	}
	

//****************************************************************************************
//	    	STEP-03--BOM COMPOSITION SEARCH TEXTBOX IS DISPLAYED &	STEP-04--BOM COMPOSITION TEXTBOX IS ENABLED
//****************************************************************************************		
	
	public static void mixDesignBomCompositionsearchtextboxFunctionality() throws InterruptedException, IOException {
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(file);
	    XSSFSheet sheet = workbook.getSheet("Mix Design");
	    int rowcount = sheet.getLastRowNum();
	    
	    int firstrow = CommonMethods.getFirstRowNum(System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx","Mix Design","TC-MIX-DES-0043");
	    int lastrow = CommonMethods.getLastRowNum(System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx", "Mix Design", "TC-MIX-DES-0043");
	    
	    for (int i = firstrow; i <= lastrow; i++) {
	        XSSFRow row = sheet.getRow(i);
	        Searchitem = (String) row.getCell(1).getStringCellValue();
			expectedValue = (String) row.getCell(2).getStringCellValue();
	    }
	 Thread.sleep(3000);
	
	 if (MixDesignPage.mixdesignbomcompositionsearchtextbox.isDisplayed()) {
			testCase = extent.createTest("STEP-03--BOM COMPOSITION  SEARCH TEXTBOX IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS");
			if (MixDesignPage.mixdesignbomcompositionsearchtextbox.isEnabled()) {
				testCase = extent.createTest("STEP-04---BOM COMPOSITION  SEARCH TEXTBOX IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					MixDesignPage.mixdesignbomcompositionsearchtextbox.sendKeys(Searchitem+(Keys.ENTER));

					Thread.sleep(3000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest("STEP-04---BOM COMPOSITION  SEARCH TEXTBOX IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP-03---BOM COMPOSITION  SEARCH TEXTBOX IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL");
		}
	
		
		
	}
	
	public static void mixDesignBomCompositionsearchButtonFunctionality() throws InterruptedException {
		
//************************************************************************************************************
//   	STEP-05--BOM COMPOSITION SEARCH BUTTON DISPLAYED &	STEP-06--BOM COMPOSITION SEARCH BUTTON ENABLED
//************************************************************************************************************			
		
		if (MixDesignPage.mixdesignbomcompositionsearchbutton.isDisplayed()) {
			testCase = extent.createTest("STEP-05--BOM COMPOSITION  SEARCH BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS");
			if (MixDesignPage.mixdesignbomcompositionsearchbutton.isEnabled()) {
				testCase = extent.createTest("STEP-06---BOM COMPOSITION  SEARCH BUTTON  IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					MixDesignPage.mixdesignbomcompositionsearchbutton.click();

					Thread.sleep(3000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest("STEP-06---BOM COMPOSITION  SEARCH BUTTON  IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP-05---BOM COMPOSITION  SEARCH BUTTON  IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL");
		}
		
		 boolean clickNextPage = true;
	        int actualElementCount = 0;
	        boolean passorfail = true;
	        ArrayList<String> ActualList = new ArrayList<String>();
	        ArrayList<String> ExpectedList = new ArrayList<String>();
	        String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[";
	        String NameXpath_lastPart = "]/td[3]";
	        while (clickNextPage) {
	            for (int i = 2; i < 750; i++) {
	                try {
	                    String textFull = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart))
	                            .getText();
	                    String text = textFull.toLowerCase();
	                    if (!text.contains(Searchitem)) {
	                        passorfail = false;
	                    }
	                    if (text.contains(Searchitem)) {
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
    


