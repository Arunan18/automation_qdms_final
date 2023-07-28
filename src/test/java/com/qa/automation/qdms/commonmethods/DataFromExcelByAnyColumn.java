/***********************************************************************************************************
 * 	METHOD FOR GET ICON DATA DROM EXCEL AND GET THAT ELEMENT 
 *----------------------------------------------------------------------------------------------------------
 * @author Jathu Jana	    ||       Status : 07/07/2023
 ***********************************************************************************************************/
package com.qa.automation.qdms.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;

public class DataFromExcelByAnyColumn extends DriverIntialization {
	
	public static WebElement Icon = null;
	public static boolean status =false;
	public static boolean nodata = false;
	/************************************************************************************************************
	 * @category FIND THE DATA IN ANY PAGE OF THE TABLE
	 * @param SearchData - Which Data Want To Search 
	 * @param tableDataColumn - Search Data Column Number
	 * @throws InterruptedException
	 ************************************************************************************************************/
	public static void searchvalueJ(String SearchData , int tableDataColumn) throws InterruptedException {
		
//		PAGE DOWN
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).perform();
     
		boolean nextButton = true;		
		while(nextButton) {
			
//			NEXT BUTTON INABILITY & IDENTIFICATION
			try {
				Thread.sleep(1000);
				nextButton = driver.findElement(By.xpath("//li[@title='Next Page']//button")).isEnabled();
				
			}catch (Exception e) {
				
			}
			
//			SEARCH DATA IIDENTIFICATION
			try {
				Thread.sleep(500);
				driver.findElement(By.xpath("//td["+tableDataColumn+"][text()='"+SearchData+"']"));
				testCase = extent.createTest("➢ Search Data Identification");
				testCase.log(Status.INFO, "Successfully Found Search Data In That Table");				
				testCase.log(Status.PASS, "TEST PASS ☑");
				nextButton=false;
				break;
				
			} catch (Exception e) {
						
			}

//			IF DATA NOT IDENTIFIED.....NEXT BUTTON CLICK
			if (nextButton) {
				
				driver.findElement(By.xpath("//li[@title='Next Page']//button")).click();
			
			} else {

				testCase = extent.createTest("➢ Data Identification 🛑");
				testCase.log(Status.INFO, "Next Button Identification issue. Unable To Find Search Data In That Table ⚠️");				
				testCase.log(Status.FAIL, "TEST FAIL ⚠️");	
				nodata  = true;
			}
		}
    }
		
	/***************************************************************************************************************************************
	 * @category GET THE DATA FROM EXCEL AND GET THAT ICON 
	 * @param workbookname
	 * @param Sheet
	 * @param itestCaseID
	 * @param excelDataColumn - Data Column Number In Excel
	 * @param tableDataColumn - Data Column Number In Table
	 * @param iconColumn 
	 * @param action - delete / edit / .....
	 * @throws IOException
	 * @throws InterruptedException
	 ****************************************************************************************************************************************/
	public static void getExcelDataForIcon (String workbookname, String Sheet, String itestCaseID ,
			int excelDataColumn , int tableDataColumn,int iconColumn, String action) throws IOException, InterruptedException{

//		DECLARE FILE, WORKBOOK AND SHEET
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" +workbookname+".xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(Sheet);
        System.out.println("File Name :"+file);
        System.out.println("WorkBook Name :"+workbook);
        System.out.println("Sheet Name :"+sheet);

//      GET FIRST ROW DATA IN EXCEL BY COMMON METHOD 
        PropertiesCommonMethods.excalRowCount(workbookname+".xlsx", Sheet, itestCaseID);
        int firstrow =PropertiesCommonMethods.countRow-1;
            
//      GET PERTICULAR DATA    
        String data = null;
        XSSFRow row = sheet.getRow(firstrow);
        data =row.getCell(excelDataColumn).getStringCellValue();    
        System.out.println("The Cell Data :"+data);       
        
//		IDENTIFY THE DATA USING SEARCHING VALUE COMMON MTD
		searchvalueJ(data, tableDataColumn);
		Thread.sleep(2000);
		
//		PRINT THAT XPATH 
		System.out.println("//td[text()='"+ data +"']//following-sibling::td["+iconColumn+"]//span[@class='anticon anticon-"+ action+"']");
        
		
     
		try {
			
//    	  GET WEBELEMENT WITH SPACE
    	  Icon = driver.findElement(By.xpath(
	                "//td[text()='"+ data +"']//following-sibling::td["+iconColumn+"]//span[@class='anticon anticon-"+ action+"']"));
    	
    	  status = true;
		}catch (NoSuchElementException e){
    		
//			GET WEBELEMENT WITH NO SPACE
			Icon = driver.findElement(By.xpath(
		                "//td[text()='"+ data +" "+"']//following-sibling::td["+iconColumn+"]//span[@class='anticon anticon-"+ action+"']"));
		status =true ;
		}catch (Exception e) {
			 
			testCase = extent.createTest("➢ Icon Exception 🛑");
			testCase.log(Status.FAIL, "TEST FAIL ⚠️");	
		}
          
	}
	
//	CLICK ELEMENT...............................................................................................................................................
	public static void getElement() 
	{
		if (status) {
			
			Icon().click();
		}
		else {
			
			testCase = extent.createTest("➢ Data Issues🛑");
			testCase.log(Status.FAIL, "TEST FAIL ❌");
			status= false;
		}
			
	}
	
//	RETURN METHOD TO GET ELEMENT
	public static WebElement Icon() 
	{
	
		return Icon;
			
	}
	
	/*************************************************************************************************************************************************************\
	 * @category METHOD FOR CLICK SEARCH 
	 * @param SearchData
	 * @param tableDataColumn
	 * @param action
	 * @throws InterruptedException 
	 ***************************************************************************************************************************************************************/
	public static void clickTheSearchIcon(String SearchData , int tableDataColumn,int iconCoumn, String action) throws InterruptedException {
		
//		IDENTIFY THE DATA USING SEARCHING VALUE COMMON MTD
		searchvalueJ(SearchData, tableDataColumn);
		Thread.sleep(2000);
		
//		PRINT THAT XPATH 
		System.out.println("//td[text()='"+ SearchData +"']//following-sibling::td["+iconCoumn+"]//span[@class='anticon anticon-"+ action+"']");
        
		
     
		try {
			
//    	  GET WEBELEMENT WITH SPACE
    	  Icon = driver.findElement(By.xpath(
	                "//td[text()='"+ SearchData +"']//following-sibling::td["+iconCoumn+"]//span[@class='anticon anticon-"+ action+"']"));
    	
    	  status = true;
		}catch (NoSuchElementException e){
    		
//			GET WEBELEMENT WITH NO SPACE
			Icon = driver.findElement(By.xpath(
		                "//td[text()='"+ SearchData +" "+"']//following-sibling::td["+iconCoumn+"]//span[@class='anticon anticon-"+ action+"']"));
		status =true ;
		}catch (Exception e) {
			 
			testCase = extent.createTest("➢ Icon Exception 🛑");
			testCase.log(Status.FAIL, "TEST FAIL ⚠️");
			
//			REFRESH
			driver.navigate().refresh();
			Thread.sleep(500);
				
		
		}
	
		if (status) {
			
			Icon.click();
		
		}
          
	}
}

