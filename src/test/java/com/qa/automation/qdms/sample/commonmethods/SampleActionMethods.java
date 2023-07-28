package com.qa.automation.qdms.sample.commonmethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automation.qdms.base.DriverIntialization;

public class SampleActionMethods extends DriverIntialization {
	public static boolean cilick=false;
	public static boolean cilicka=false;
//	this is click action
	//@element :- where should be do the action
	//@wait time in second :- expected wait time
	//@comment :- what should be print in test report
	
	public static void clicking(WebElement element, long waitTimeInSecond, String comment) {
		WebDriverWait wait= new WebDriverWait(driver, 6);
		
		cilick = false;
		boolean Value1 = false;
		boolean isExist = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			boolean value1 = element.isDisplayed();
			
			if (value1) {
				boolean value2 = element.isEnabled();
				
				
				if (value2) {
					element.click();
					cilick = true;
				}else {
					SampleCommonMethods.TestCasePrint(comment + " IS ENABLED", "true", String.valueOf(value2));
				}
			}
			else {
				SampleCommonMethods.TestCasePrint(comment + " IS DISPLAYED", "true", String.valueOf(value1));
			}
			
		} catch (Exception e) {
			SampleCommonMethods.TestCasePrint(comment + " Clicking Fail ", "true", String.valueOf(Value1), String.valueOf(e));

		}

	}
	

	public static void sendkeys(WebElement element, String text, String comment) {

		boolean Value1 = false;
		boolean isExist = false;
		try {
			boolean value1 = element.isDisplayed();
			SampleCommonMethods.TestCasePrint(comment + " IS DISPLAYED", "true", String.valueOf(value1));
			boolean value2 = element.isEnabled();
			SampleCommonMethods.TestCasePrint(comment + " IS ENABLED", "true", String.valueOf(value2));
			element.click();
			element.clear();
			element.sendKeys(text);

		} catch (Exception e) {
			SampleCommonMethods.TestCasePrint(comment + " IS NOT THERE ", "true", String.valueOf(Value1), String.valueOf(e));

		}

	}

// this is for selecting drop down
	//@element :- which drop down should be handle
	//text     :- which should be select from drop down list by visible text 
	//@comment :- what should be print in test report
	
		public static void selectByVisibleText(WebElement element, String text, String comment) {

			boolean Value1 = false;
			boolean isExist = false;
			try {
				boolean value1 = element.isDisplayed();
				SampleCommonMethods.TestCasePrint(comment + " IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = element.isEnabled();
				SampleCommonMethods.TestCasePrint(comment + " IS ENABLED", "true", String.valueOf(value2));
				Select select = new Select(element);
				select.selectByVisibleText(text);

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint(comment + " IS NOT THERE ", "true", String.valueOf(Value1), String.valueOf(e));

			}

		}
		
// Accepting alert 
		public static void alertaccepting(WebDriver driver) {
			driver.switchTo().alert().accept();

		}

// dismiss alert 
		public static void alertdismiss(WebDriver driver) {
			driver.switchTo().alert().dismiss();

		}
// this is mouse hover from one element to other element
		//@element :- where should be change the action
		//@@comment :- what should be print in test report
		

		public static void mousehover(WebElement element, String comment) {

			boolean Value1 = false;
			boolean isExist = false;
			try {
				boolean value1 = element.isDisplayed();
				SampleCommonMethods.TestCasePrint(comment + " IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = element.isEnabled();
				SampleCommonMethods.TestCasePrint(comment + " IS ENABLED", "true", String.valueOf(value2));
				Actions action = new Actions(driver);
				action.moveToElement(element).build().perform();

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint(comment + " IS NOT THERE ", "true", String.valueOf(Value1), String.valueOf(e));

			}

		}

// checking web element properties (for test status)
		//@element :- which element's UI should be check
		//@clour  :- expected clour
		//@text   :- expected content text of element
		//@comment :- what should be print in test report
		
		public static void webelementUi(WebElement element, String clour, String text, String comment) {
			boolean Value1 = false;
			boolean isExist = false;
			try {
				boolean value1 = element.isDisplayed();
				SampleCommonMethods.TestCasePrint(comment + " IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = element.isEnabled();
				SampleCommonMethods.TestCasePrint(comment + " IS ENABLED", "true", String.valueOf(value2));
				String value = element.getText();
				SampleCommonMethods.TestCasePrint(comment + " TEXT", text, String.valueOf(value));
				String value3 = element.getAttribute(clour);
				SampleCommonMethods.TestCasePrint(comment + " CCLOUR", clour, String.valueOf(value3));

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint(comment + " IS NOT THERE ", "true", String.valueOf(Value1), String.valueOf(e));
			}	

		}
		
//table data row count and cell count
		//@table :- which table data count should be check
		//@count :- expected table data count
		//@comment :- heading of the table(will print in report)
		public static void tableDataCount(WebElement table,String count,WebElement nextPageButton ,String comment) {
			//WebElement table = driver.findElement(By.id("table-id"));
			// Check if the table data spans across multiple pages
			boolean Value1 = false;
			boolean isExist = false;
			try {
				boolean value1 = table.isDisplayed();
				SampleCommonMethods.TestCasePrint(comment + " IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = table.isEnabled();
				SampleCommonMethods.TestCasePrint(comment + " IS ENABLED", "true", String.valueOf(value2));
						boolean hasNextPage = true;
						while (hasNextPage) {
						    // Extract the table data for the current page
						    List<WebElement> rows = table.findElements(By.tagName("tr"));
						    int rowCount = rows.size();
						    List<WebElement> columns = rows.get(0).findElements(By.tagName("td"));
						    int columnCount = columns.size();
						    
						    // Count the table data for the current page
						    int dataCount = 0;
						    for (WebElement row : rows) {
						        List<WebElement> cells = row.findElements(By.tagName("td"));
						        for (WebElement cell : cells) {
						            String cellText = cell.getText();
						            // Do something with the cell text, e.g. count it
						            dataCount++;
						        }
						    }
						    
						    // Check if there is a next page
						   
						    hasNextPage = nextPageButton.isEnabled();
						    
						    // Navigate to the next page if there is one
						    if (hasNextPage) {
						        nextPageButton.click();
						    }
						
						if (count.equals(rowCount)) {
							SampleCommonMethods.TestCasePrint("EXPECTED DATA COUNT AVILABLE IN "+comment, count, String.valueOf(rowCount));
							
						}else {
							SampleCommonMethods.TestCasePrint("EXPECTED DATA COUNT NOT AVILABLE IN "+comment, count, String.valueOf(rowCount));	
						}
						}
				
			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint(comment + " IS NOT THERE ", "true", String.valueOf(Value1), String.valueOf(e));
			}	
		
		}
// search particular data from table data and click button
		//@table :- which table data should be search and find
		//@searchQuery:- search data
		//@button :- which button should be click in row
		//@nextPageButton:- next page button 
		public static void  perticularDataSearch(WebElement table, String searchQuery,WebElement button,WebElement nextPageButton ) {
			// Identify the web element that contains the table data
			//WebElement table = driver.findElement(By.id("table-id"));

			// Define the search query
			//String searchQuery = "search term";

			// Check if the table data spans across multiple pages
			boolean hasNextPage = true;
			while (hasNextPage) {
			    // Search for the particular data on the current page
				
			    boolean foundData = false;
			    List<WebElement> rows = table.findElements(By.tagName("tr"));
			    for (WebElement row : rows) {
			        List<WebElement> cells = row.findElements(By.tagName("td"));
			        for (WebElement cell : cells) {
			            String cellText = cell.getText();
			            if (cellText.contains(searchQuery)) {
			                // Take the necessary action if the data is found
			                foundData = true;
			                // Example action: Click a button in the same row as the data
			              //  WebElement button = row.findElement(By.tagName("button"));
			                button.click();
			                break;
			            }
			        }
			        if (foundData) {
			        //	SampleCommonMethods.TestCasePrint("EXPECTED DATA FOUND IN DATA TABLE ");
			            break;
			        }
			    }
			    if (foundData) {
		        	
		            break;}
			    // Check if there is a next page
			  
			    hasNextPage = nextPageButton.isEnabled();
			    
			    // Navigate to the next page if there is one
			    if (hasNextPage) {
			        nextPageButton.click();
			    }
			    SampleCommonMethods.TestCasePrint("EXPECTED DATA FOUND IN DATA TABLE "); 
			}

			
		}
		
public static void clicking(WebElement element,String comment) {

	WebDriverWait wait= new WebDriverWait(driver, 6);
	
	cilicka = false;
	boolean Value1 = false;
	try {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		boolean value1 = element.isDisplayed();
		
		if (value1) {
			boolean value2 = element.isEnabled();
			
			
			if (value2) {
				try {
					element.click();
					cilicka=true;
				} catch (Exception e) {
					SampleCommonMethods.TestCasePrint(comment + " IS ENABLED", "true", String.valueOf(e));
				}
			}else {
				SampleCommonMethods.TestCasePrint(comment + " IS ENABLED", "true", String.valueOf(value2));
			}
		}
		else {
			SampleCommonMethods.TestCasePrint(comment + " IS DISPLAYED", "true", String.valueOf(value1));
		}
		
	} catch (Exception e) {
		SampleCommonMethods.TestCasePrint(comment + " Clicking Fail ", "true", String.valueOf(Value1), String.valueOf(e));

	}


	
}
		
}
