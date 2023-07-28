/***********************************************************************************************************
 * EXCEL METHOD TO GET DATA FOR 'ICON (DELETE/ EDIT)' IN THE TABLE
 *----------------------------------------------------------------------------------------------------------
 * @author Jathu Jana    	Date: 11/5/2023
 * @category Method for Button & Icon Functionality								 										    
 ***********************************************************************************************************/
	
package com.qa.automation.qdms.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.automation.qdms.base.DriverIntialization;

public class dataFromExcel extends DriverIntialization
{
	public static WebElement Icon;
	
	//GET DATA FROM EXCEL......................................................................................................
	
	/**
	 * 
	 * @param workbookname
	 * @param Sheet
	 * @param itestCaseID
	 * @param dataColumn
	 * @param iconColumn
	 * @param action
	 * @throws IOException
	 * @throws InterruptedException
	 */
		public static void getExcelDataForIcon (String workbookname, String Sheet, String itestCaseID , int dataColumn , int iconColumn, String action) throws IOException, InterruptedException
		{
	
			//DECLARE FILE, WORKBOOK AND SHEET
			FileInputStream file = new FileInputStream(
	                System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" +workbookname+".xlsx");
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheet(Sheet);
	        
	        //GET FIRST ROW DATA IN EXCEL BY TSETCASE ID
	        int firstrow = CommonMethods.getFirstRowNum(
	                System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" +workbookname+".xlsx",
	                Sheet, itestCaseID);
	        
	        //GET LAST ROW DATA IN EXCEL BY TSETCASE ID
	        int lastrow = CommonMethods.getLastRowNum(
	                System.getProperty("user.dir") +"\\src\\test\\resources\\Excel\\" +workbookname+".xlsx",
	                Sheet, itestCaseID);
	        
	        //GET PERTICULAR DATA BETWEEN FIRST & LAST ROW   
	        String value1 = null;
			for (int i = firstrow; i <= lastrow; i++)
	        {
	            XSSFRow row = sheet.getRow(i);
	              value1 =row.getCell(dataColumn).getStringCellValue();    
	        }
	        
			//IDENTIFY THE DATA USING SEARCHING VALUE COMMAN MTD
			Searching.searchvalue(value1, dataColumn);
			Thread.sleep(2000);
			
			//PRINT THAT XPATH 
			System.out.println("//td[text()='"+ value1 +"']//following-sibling::td["+iconColumn+"]//span[@class='anticon anticon-"+ action+"']");
	        
	     
			try 
			{
	    	  //GET WEBELEMENT WITH SPACE
	    	  Icon = driver.findElement(By.xpath(
		                "//td[text()='"+ value1 +"']//following-sibling::td["+iconColumn+"]//span[@class='anticon anticon-"+ action+"']"));
	    	}catch (Exception e) 
			{
			//GET WEBELEMENT WITH NO SPACE
			 Icon = driver.findElement(By.xpath(
		                "//td[text()='"+ value1 +" "+"']//following-sibling::td["+iconColumn+"]//span[@class='anticon anticon-"+ action+"']"));
			}
	     
	      
		}
		
//RETURN METHOD TO GET ELEMENT...............................................................................................................................................
		public static WebElement getElement() 
		{
			return Icon;	
		}
		
		
		
}
