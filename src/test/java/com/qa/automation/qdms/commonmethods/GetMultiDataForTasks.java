/***********************************************************************************************************
 * EXCEL METHOD TO GET DATA 
 *----------------------------------------------------------------------------------------------------------
 * @author Jathu Jana    	Date: 3/7/2023
 * @category Method for Getting Multi Data In Excel by row wise								 										    
 ***********************************************************************************************************/

package com.qa.automation.qdms.commonmethods;

import java.io.FileInputStream;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;

public class GetMultiDataForTasks extends DriverIntialization
{
	public static ArrayList<String> adddata=new ArrayList<String>(); 
	static String Total = null;
	public static String Data = null;
	public static String Data1 = null;;
	public static String Data2 = null;;
	public static String Data3 = null;;
	public static String Data4 = null;;
	public static String Data5 = null;;
	public static String Data6 = null;;
	public static String Data7 = null;;
	public static String Data8 = null;;
	public static String Data9 = null;;
	public static String Data10 = null;;

	/***********************************************************************************************************
	 * @category DATA GETTING (EMPTY CELL BREAK)
	 * @param WorkBookName
	 * @param SheetName
	 * @param TestCaseNo
	 * @return
	 ***********************************************************************************************************/
	public static ArrayList<String> Data(String WorkBookName, String SheetName,String TestCaseNo) {
		
		adddata.clear();
        XSSFRow row = null;
        XSSFCell cell = null;
        DataFormatter dataValue = new DataFormatter();
        FileInputStream fileIn = null;
        String filelocation = null;
        XSSFWorkbook wbook = null;

		boolean status=false;
        try {
           // filelocation = "./src/test/resources/Excel/QDMS Properties.xlsx";
        	 filelocation = "./src/test/resources/Excel/"+WorkBookName ;
            fileIn = new FileInputStream(filelocation);
            wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
            status=true;
            // fileIn.close();

        } catch (Exception e) {
        	status=false;
    		testCase = extent.createTest("FILES EXCEPTION 🛑");
			testCase.log(Status.FAIL, "TEST FAIL ❌ !.....⚠️");	
        }

        if(status) {
        	PropertiesCommonMethods.excalRowCount(WorkBookName,SheetName,TestCaseNo);
            int I = PropertiesCommonMethods.countRow - 1;

            for (int j = 1; j < 20; j++) {
                XSSFSheet sheet = wbook.getSheet(SheetName);
                row = sheet.getRow(I);
                cell = row.getCell(j);
                Total = dataValue.formatCellValue(cell);
                if (Total == "") {
                    break;

                }
                adddata.add(Total);
                System.out.println(Total);
               
            }      	
        }
		return adddata;
        
	}
	
	/***********************************************************************************************************
	 * @category DATA GETTING WITHOUT EMPTY CELL
	 * @param WorkBookName
	 * @param SheetName
	 * @param TestCaseNo
	 * @return
	 ***********************************************************************************************************/
	public static ArrayList<String> Data2(String WorkBookName, String SheetName,String TestCaseNo) {
		
		adddata.clear();
        XSSFRow row = null;
        XSSFCell cell = null;
        DataFormatter dataValue = new DataFormatter();
        FileInputStream fileIn = null;
        String filelocation = null;
        XSSFWorkbook wbook = null;

		boolean status=false;
        try {
           // filelocation = "./src/test/resources/Excel/QDMS Properties.xlsx";
        	 filelocation = "./src/test/resources/Excel/"+WorkBookName ;
            fileIn = new FileInputStream(filelocation);
            wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
            status=true;
            // fileIn.close();

        } catch (Exception e) {
        	status=false;
    		testCase = extent.createTest("FILES EXCEPTION 🛑");
			testCase.log(Status.FAIL, "TEST FAIL ❌ !.....⚠️");	
        }

        if(status) {
        	PropertiesCommonMethods.excalRowCount(WorkBookName,SheetName,TestCaseNo);
            int I = PropertiesCommonMethods.countRow - 1;

            for (int j = 1; j < 20; j++) {
                XSSFSheet sheet = wbook.getSheet(SheetName);
                row = sheet.getRow(I);
                cell = row.getCell(j);
                Total = dataValue.formatCellValue(cell);
                if (Total == "") {
                    continue;

                }
                adddata.add(Total);
                System.out.println(Total);
               
            }      	
        }
		return adddata;
        
	}
	
	/***************************************************************************************************************
	 * @category GETTING ONE BY ONE CELL
	 * @param excelName
	 * @param sheetName
	 * @param uniqueId
	 * @param cellNo
	 * @return
	 ***************************************************************************************************************/
	public static String getDataByCellOneByOne(String excelName, String sheetName, String uniqueId,int cellNo) {

		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;

		try {
			filelocation = "./src/test/resources/Excel/" + excelName;
			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
		} catch (Exception e) {
			
		}

		PropertiesCommonMethods.excalRowCount(excelName, sheetName, uniqueId);
		int I = PropertiesCommonMethods.countRow - 1;
		XSSFSheet sheet = wbook.getSheet(sheetName);
		
		for (int j = 0; j < I; j++) {
			
			row = sheet.getRow(I);
			cell = row.getCell(j);
		    Data = dataValue.formatCellValue(cell).toString();
			System.out.println(Data);
			
		}
		return Data;
	}
	
	/***********************************************************************************************************
	 * @category DATAS GETTING CELL WISE
	 * @param excelName
	 * @param sheetName
	 * @param uniqueId
	 * @param Data
	 **********************************************************************************************************/
	public static void getDatasByCells(String excelName, String sheetName, String uniqueId,String Data) {

		XSSFRow row = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;

		try {
			filelocation = "./src/test/resources/Excel/" + excelName;
			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
		} catch (Exception e) {
			
		}

		PropertiesCommonMethods.excalRowCount(excelName, sheetName, uniqueId);
		int I = PropertiesCommonMethods.countRow - 1;
		XSSFSheet sheet = wbook.getSheet(sheetName);
		
		row = sheet.getRow(I);
		Data1 = dataValue.formatCellValue( row.getCell(1)).toString();
		System.out.println("First Data :"+Data1);
			
		Data2 =dataValue.formatCellValue( row.getCell(2)).toString();
		System.out.println("First Data :"+Data2);
			
		Data3 =dataValue.formatCellValue( row.getCell(3)).toString();
		System.out.println("First Data :"+Data3);
		
		Data4 = dataValue.formatCellValue( row.getCell(4)).toString();
		System.out.println("First Data :"+Data5);
			
		Data5 =dataValue.formatCellValue( row.getCell(5)).toString();
		System.out.println("First Data :"+Data5);
			
		Data6 =dataValue.formatCellValue( row.getCell(6)).toString();
		System.out.println("First Data :"+Data6);
		
		Data7 =dataValue.formatCellValue( row.getCell(7)).toString();
		System.out.println("First Data :"+Data7);
		
		Data8 =dataValue.formatCellValue( row.getCell(8)).toString();
		System.out.println("First Data :"+Data8);
			
		Data9 =dataValue.formatCellValue( row.getCell(9)).toString();
		System.out.println("First Data :"+Data9);
		
		Data10 =dataValue.formatCellValue( row.getCell(10)).toString();
		System.out.println("First Data :"+Data10);
				
	}
}	