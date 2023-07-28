//***********************************************************************************
//* Description
//*------------
//* Single Search Method
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 17/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        17/03/2023   Gobithan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.plant;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.MaterialPage;

public class SingleSearchMethods extends DriverIntialization{
	static MaterialPage material = new MaterialPage();
	public static boolean BtnVisible = true;
	public static boolean BtnEnable = true;
	
	/***************************************************************************************
	 *								Count Search Method
	 * @return 
	 ***************************************************************************************/
	 
	 
	
		public static int dataCount(int count,String firstPart_Xpath,String lastPart_Xpath) throws InterruptedException {
			Thread.sleep(1000);
			//redirect the page to 1st page
			driver.findElement(By.xpath("(//li[contains(@class, 'ant-pagination-item') and not(contains(@class, 'ant-pagination-item-74'))])[1]")).click();
			
			boolean clickNextPage = true;
			ArrayList<String> afterarrayStore = new ArrayList<String>();

			String rowXpath_firstPart = firstPart_Xpath;
			String rowXpath_lastPart = lastPart_Xpath;
			while (clickNextPage) {
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.PAGE_DOWN).build().perform();

				for (int i = 2; i < 103; i++) {
					try {
						String text = driver.findElement(By.xpath(rowXpath_firstPart + i + rowXpath_lastPart)).getText();
							System.out.println(text);

							afterarrayStore.add(text);
						count = count + 1;
					} catch (Exception e) {
					}
				}
				if (clickNextPage == true) {
					clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
							.isEnabled();
					driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
					Thread.sleep(2000);
				} else {
					break;
				}
			}
			driver.navigate().refresh();
			return count;

		}
		
		
		
		/*********************************************************************************************************************************************************
		 * Button Properties - (Visible, Enable)
		 **********************************************************************************************************************************************************/
		public static void Button(WebElement searchbtn, String colName) throws InterruptedException {
			
			PageFactory.initElements(driver, material);
			Thread.sleep(2000);
			//	Search Icon Visivle 
			testCase = extent.createTest(colName + " Button Properties - Visible");
			try {
				Assert.assertEquals(searchbtn.isDisplayed(), true);
				testCase.log(Status.INFO, colName + " Button Visible");
				testCase.log(Status.PASS, colName + " Button Visible Script Pass");
			} catch (AssertionError e) {
				BtnVisible = false;
				testCase.log(Status.INFO, colName + " Button Not Visible");
				testCase.log(Status.FAIL, colName + " Button Not Visible");
			} catch (NoSuchElementException e) {
				BtnEnable = false;
				testCase.log(Status.INFO, "Dont have " + colName + " Button Locator");
				testCase.log(Status.FAIL, "Dont have " + colName + " Button Locator, So Smoke Fail");
			}
			Thread.sleep(1500);
			//	Search Icon Enable
			if (BtnVisible) {
				testCase = extent.createTest(colName + " Button Properties - Enable");
				try {
					Assert.assertEquals(searchbtn.isEnabled(), true);
					testCase.log(Status.INFO, colName + " Button Enable");
					testCase.log(Status.PASS, colName + " Button Enable Script Pass");
				} catch (AssertionError e) {
					BtnEnable = false;
					testCase.log(Status.INFO, colName + " Button Not Enable");
					testCase.log(Status.FAIL, colName + " Button Not Enable");
				}
				if (BtnVisible && BtnEnable) {

					
				}
			}

		}
}
