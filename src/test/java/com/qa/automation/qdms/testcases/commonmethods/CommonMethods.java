//************************************************************************************
//				DO NOT TOUCH THESE CODES - VOLTA
//************************************************************************************

package com.qa.automation.qdms.testcases.commonmethods;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;

public class CommonMethods extends DriverIntialization {

	public static void setElementProperties(WebElement ielement, String iWebPageName, String iWebElementName,
			String iXlocation, int iXSheetNumber, int iXRowNumber) {
		/**
		 * 
		 * This method is used to set the properties of a given web element and write
		 * them to an excel sheet. The method takes in the following parameters:
		 * 
		 * @param ielement        WebElement to set properties for
		 * @param iWebPageName    Name of the web page the WebElement belongs to
		 * @param iWebElementName Name of the WebElement to set properties for
		 * @param iXlocation      Excel sheet's file path and name
		 * @param iXSheetNumber   Excel sheet's sheet number
		 * @param iXRowNumber     Row number to start writing the properties in Excel
		 *                        sheet. The method performs the following operations:
		 *                        Writes the Web page Name and Web element Name to the
		 *                        Excel sheet Sets the properties of the WebElement
		 *                        Writes each property and its value to the Excel sheet
		 *                        in the given row number The properties include: Common
		 *                        - Visibility, Common - Enability, JS - Hidden, JS -
		 *                        Disabled, Size, Position, Background - color, Font -
		 *                        color, Border - color, Font - type, Font - size, Text,
		 *                        Box - shadow, Padding
		 */
		WebElement element = ielement;
		String WebPageName = iWebPageName;
		String WebElementName = iWebElementName;

		String Xlocation = iXlocation;
		int XSheetNumber = iXSheetNumber;
		int XRowNumber = iXRowNumber;

		// Print Web page Name, Web element Name on excel sheet
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber, 1, WebPageName);
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber, 2, WebElementName);

		// Common - Visiblity (+0)
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 0, 3, "Common - Visibility");
		String property = String.valueOf(element.isDisplayed());
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 0, 4, property);
		property = "";

		// Common - Enability (+1)
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 1, 3, "Common - Enability");
		property = String.valueOf(element.isEnabled());
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 1, 4, property);
		property = "";

		// JS-Hidden (+2)
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 2, 3, "JS - Hidden");
		property = String.valueOf(element.getAttribute("hidden"));
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 2, 4, property);
		property = "";

		// JS - Disabled (+3)
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 3, 3, "JS - Disabled");
		property = String.valueOf(element.getAttribute("disabled"));
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 3, 4, property);
		property = "";

		// Size (+4)
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 4, 3, "Size");
		property = String.valueOf(element.getSize());
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 4, 4, property);
		property = "";

		// Position (+5)
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 5, 3, "Position");
		property = String.valueOf(element.getLocation());
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 5, 4, property);
		property = "";

		// Background-color (+6)
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 6, 3, "Background - color");
		property = String.valueOf(element.getCssValue("background-color"));
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 6, 4, property);
		property = "";

		// font - color (+7)
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 7, 3, "Font - color");
		property = String.valueOf(element.getCssValue("color"));
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 7, 4, property);
		property = "";

		// Border- Color (+8)
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 8, 3, "Border - color");
		property = String.valueOf(element.getCssValue("border-color"));
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 8, 4, property);
		property = "";

		// Font - Type (+9)
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 9, 3, "Font - type");
		property = String.valueOf(element.getCssValue("font-style"));
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 9, 4, property);
		property = "";

		// Font - size (+10)
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 10, 3, "Font - size");
		property = String.valueOf(element.getCssValue("font-size"));
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 10, 4, property);
		property = "";

		// Text (+11)
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 11, 3, "Text");
		property = String.valueOf(element.getText());
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 11, 4, property);
		property = "";

		// Box - shadow (+12)
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 12, 3, "Box - shadow");
		property = String.valueOf(element.getCssValue("box-shadow"));
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 12, 4, property);
		property = "";

		// Padding (+13)
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 13, 3, "Padding");
		property = String.valueOf(element.getCssValue("padding"));
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 13, 4, property);
		property = "";

		// Cursor (+14)
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 14, 3, "Cursor");
		property = String.valueOf(element.getCssValue("cursor"));
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 14, 4, property);
		property = "";

		// Border Radius (+15)
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 15, 3, "Border - radius");
		property = String.valueOf(element.getCssValue("border-radius"));
		ExcelSheetWrite(Xlocation, XSheetNumber, XRowNumber + 15, 4, property);
		property = "";

	}

	public static void checkElementProperties(WebElement ielement, String iXlocation, int iXSheetNumber,
			int iXRowNumber) {

		/**
		 * 
		 * This method is used to check the properties of a given web element.
		 * 
		 * @param ielement      the web element to be checked
		 * 
		 * @param iXlocation    the location of the Excel sheet containing the test
		 *                      cases
		 * 
		 * @param iXSheetNumber the sheet number of the Excel sheet containing the test
		 *                      cases
		 * 
		 * @param iXRowNumber   the row number of the test case
		 */
		WebElement element = ielement;

		String Xlocation = iXlocation;
		int XSheetNumber = iXSheetNumber;
		int XRowNumber = iXRowNumber;

		String WebPageName = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 0, 1);
		String WebElementName = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 0, 2);

// Check Common - Visiblity (+0)======================================================================

		String DoTest = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 0, 5);
		String ExpectedProperty = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 0, 4);
		String ActualProperty = String.valueOf(element.isDisplayed());

		if (DoTest.equals("true") || DoTest.equals("")) {
			if (!ExpectedProperty.equals("null") || !ExpectedProperty.equals(ActualProperty)) {
				TestCasePrint(WebPageName + ": " + WebElementName + ": Common - Visiblity", ExpectedProperty,
						ActualProperty);
				System.out.println("Testing " + WebPageName + ": " + WebElementName
						+ ": Common - Visiblity - expected:-" + ExpectedProperty + " actual:- " + ActualProperty);
			}
		}
		DoTest = ExpectedProperty = ActualProperty = "";

// Check Common - Enability (+1)======================================================================

		DoTest = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 1, 5);
		ExpectedProperty = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 1, 4);
		ActualProperty = String.valueOf(element.isEnabled());

		if (DoTest.equals("true") || DoTest.equals("")) {
			if (!ExpectedProperty.equals("null") || !ExpectedProperty.equals(ActualProperty)) {
				TestCasePrint(WebPageName + ": " + WebElementName + ": Common - Enability ", ExpectedProperty,
						ActualProperty);
				System.out.println("Testing " + WebPageName + ": " + WebElementName
						+ ": Common - Enability - expected:-" + ExpectedProperty + " actual:- " + ActualProperty);
			}
		}
		DoTest = ExpectedProperty = ActualProperty = "";

// Check JS - Hidden (+2)======================================================================

		DoTest = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 2, 5);
		ExpectedProperty = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 2, 4);
		ActualProperty = String.valueOf(element.getAttribute("hidden"));

		if (DoTest.equals("true") || DoTest.equals("")) {
			if (!ExpectedProperty.equals("null") || !ExpectedProperty.equals(ActualProperty)) {
				TestCasePrint(WebPageName + ": " + WebElementName + ": JS - Hidden ", ExpectedProperty, ActualProperty);
				System.out.println("Testing " + WebPageName + ": " + WebElementName + ": JS - Hidden  - expected:-"
						+ ExpectedProperty + " actual:- " + ActualProperty);
			}
		}
		DoTest = ExpectedProperty = ActualProperty = "";

// Check JS - Disabled (+3)======================================================================

		DoTest = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 3, 5);
		ExpectedProperty = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 3, 4);
		ActualProperty = String.valueOf(element.getAttribute("disabled"));

		if (DoTest.equals("true") || DoTest.equals("")) {
			if (!ExpectedProperty.equals("null") || !ExpectedProperty.equals(ActualProperty)) {
				TestCasePrint(WebPageName + ": " + WebElementName + ": JS - Disabled ", ExpectedProperty,
						ActualProperty);
				System.out.println("Testing " + WebPageName + ": " + WebElementName + ": JS - Disabled  - expected:-"
						+ ExpectedProperty + " actual:- " + ActualProperty);
			}
		}
		DoTest = ExpectedProperty = ActualProperty = "";

// Check Size (+4)======================================================================

		DoTest = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 4, 5);
		ExpectedProperty = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 4, 4);
		ActualProperty = String.valueOf(element.getSize());

		if (DoTest.equals("true") || DoTest.equals("")) {
			if (!ExpectedProperty.equals("null") || !ExpectedProperty.equals(ActualProperty)) {
				TestCasePrint(WebPageName + ": " + WebElementName + ": Size ", ExpectedProperty, ActualProperty);
				System.out.println("Testing " + WebPageName + ": " + WebElementName + ": Size  - expected:-"
						+ ExpectedProperty + " actual:- " + ActualProperty);
			}
		}
		DoTest = ExpectedProperty = ActualProperty = "";

// Position (+5)======================================================================

		DoTest = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 5, 5);
		ExpectedProperty = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 5, 4);
		ActualProperty = String.valueOf(element.getLocation());

		if (DoTest.equals("true") || DoTest.equals("")) {
			if (!ExpectedProperty.equals("null") || !ExpectedProperty.equals(ActualProperty)) {
				TestCasePrint(WebPageName + ": " + WebElementName + ": Position ", ExpectedProperty, ActualProperty);
				System.out.println("Testing " + WebPageName + ": " + WebElementName + ": Position  - expected:-"
						+ ExpectedProperty + " actual:- " + ActualProperty);
			}
		}
		DoTest = ExpectedProperty = ActualProperty = "";

// Background - Color (+6)======================================================================

		DoTest = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 6, 5);
		ExpectedProperty = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 6, 4);
		ActualProperty = String.valueOf(element.getCssValue("background-color"));

		if (DoTest.equals("true") || DoTest.equals("")) {
			if (!ExpectedProperty.equals("null") || !ExpectedProperty.equals(ActualProperty)) {
				TestCasePrint(WebPageName + ": " + WebElementName + ": Background - color ", ExpectedProperty,
						ActualProperty);
				System.out.println("Testing " + WebPageName + ": " + WebElementName
						+ ": Background - color  - expected:-" + ExpectedProperty + " actual:- " + ActualProperty);
			}
		}
		DoTest = ExpectedProperty = ActualProperty = "";

// Font - Color (+7)======================================================================

		DoTest = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 7, 5);
		ExpectedProperty = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 7, 4);
		ActualProperty = String.valueOf(element.getCssValue("color"));

		if (DoTest.equals("true") || DoTest.equals("")) {
			if (!ExpectedProperty.equals("null") || !ExpectedProperty.equals(ActualProperty)) {
				TestCasePrint(WebPageName + ": " + WebElementName + ": Font - color ", ExpectedProperty,
						ActualProperty);
				System.out.println("Testing " + WebPageName + ": " + WebElementName + ": Font - color  - expected:-"
						+ ExpectedProperty + " actual:- " + ActualProperty);
			}
		}
		DoTest = ExpectedProperty = ActualProperty = "";

// Border - Color (+8)======================================================================

		DoTest = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 8, 5);
		ExpectedProperty = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 8, 4);
		ActualProperty = String.valueOf(element.getCssValue("border-color"));

		if (DoTest.equals("true") || DoTest.equals("")) {
			if (!ExpectedProperty.equals("null") || !ExpectedProperty.equals(ActualProperty)) {
				TestCasePrint(WebPageName + ": " + WebElementName + ": Border - color ", ExpectedProperty,
						ActualProperty);
				System.out.println("Testing " + WebPageName + ": " + WebElementName + ": Border - color  - expected:-"
						+ ExpectedProperty + " actual:- " + ActualProperty);
			}
		}
		DoTest = ExpectedProperty = ActualProperty = "";

// Font - Type (+9)======================================================================

		DoTest = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 9, 5);
		ExpectedProperty = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 9, 4);
		ActualProperty = String.valueOf(element.getCssValue("font-style"));

		if (DoTest.equals("true") || DoTest.equals("")) {
			if (!ExpectedProperty.equals("null") || !ExpectedProperty.equals(ActualProperty)) {
				TestCasePrint(WebPageName + ": " + WebElementName + ": Font-Type ", ExpectedProperty, ActualProperty);
				System.out.println("Testing " + WebPageName + ": " + WebElementName
						+ ": Font-Type - color  - expected:-" + ExpectedProperty + " actual:- " + ActualProperty);
			}
		}
		DoTest = ExpectedProperty = ActualProperty = "";

// Font - Size (+10)======================================================================

		DoTest = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 10, 5);
		ExpectedProperty = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 10, 4);
		ActualProperty = String.valueOf(element.getCssValue("font-size"));

		if (DoTest.equals("true") || DoTest.equals("")) {
			if (!ExpectedProperty.equals("null") || !ExpectedProperty.equals(ActualProperty)) {
				TestCasePrint(WebPageName + ": " + WebElementName + ": Font-Size ", ExpectedProperty, ActualProperty);
				System.out.println("Testing " + WebPageName + ": " + WebElementName + ": Font-Size - expected:-"
						+ ExpectedProperty + " actual:- " + ActualProperty);
			}
		}
		DoTest = ExpectedProperty = ActualProperty = "";

// Text (spelling)(+11)======================================================================

		DoTest = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 11, 5);
		ExpectedProperty = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 11, 4);
		ActualProperty = String.valueOf(element.getText());

		if (DoTest.equals("true") || DoTest.equals("")) {
			if (!ExpectedProperty.equals("null") || !ExpectedProperty.equals("null")
					|| !ExpectedProperty.equals(ActualProperty)) {
				TestCasePrint(WebPageName + ": " + WebElementName + ": Text (spelling) ", ExpectedProperty,
						ActualProperty);
				System.out.println("Testing " + WebPageName + ": " + WebElementName + ": Text (spelling) - expected:-"
						+ ExpectedProperty + " actual:- " + ActualProperty);
			}
		}
		DoTest = ExpectedProperty = ActualProperty = "";

// Box Shadow (+12)==============================================================================

		DoTest = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 12, 5);
		ExpectedProperty = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 12, 4);
		ActualProperty = String.valueOf(element.getCssValue("box-shadow"));

		if (DoTest.equals("true") || DoTest.equals("")) {
			if (!ExpectedProperty.equals("null") || !ExpectedProperty.equals(ActualProperty)) {
				TestCasePrint(WebPageName + ": " + WebElementName + ": Box Shadow ", ExpectedProperty, ActualProperty);
				System.out.println("Testing " + WebPageName + ": " + WebElementName + ": Box Shadow - expected:-"
						+ ExpectedProperty + " actual:- " + ActualProperty);
			}
		}
		DoTest = ExpectedProperty = ActualProperty = "";

// Padding (+13)==============================================================================

		DoTest = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 13, 5);
		ExpectedProperty = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 13, 4);
		ActualProperty = String.valueOf(element.getCssValue("padding"));

		if (DoTest.equals("true") || DoTest.equals("")) {
			if (!ExpectedProperty.equals("null") || !ExpectedProperty.equals(ActualProperty)) {
				TestCasePrint(WebPageName + ": " + WebElementName + ": Padding ", ExpectedProperty, ActualProperty);
				System.out.println("Testing " + WebPageName + ": " + WebElementName + ": Padding - expected:-"
						+ ExpectedProperty + " actual:- " + ActualProperty);
			}
		}
		DoTest = ExpectedProperty = ActualProperty = "";

// Cursor (+14)==============================================================================

		DoTest = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 14, 5);
		ExpectedProperty = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 14, 4);
		ActualProperty = String.valueOf(element.getCssValue("cursor"));

		if (DoTest.equals("true") || DoTest.equals("")) {
			if (!ExpectedProperty.equals("null") || !ExpectedProperty.equals(ActualProperty)) {
				TestCasePrint(WebPageName + ": " + WebElementName + ": Cursor ", ExpectedProperty, ActualProperty);
				System.out.println("Testing " + WebPageName + ": " + WebElementName + ": Cursor - expected:-"
						+ ExpectedProperty + " actual:- " + ActualProperty);
			}
		}
		DoTest = ExpectedProperty = ActualProperty = "";

// Border - Radius (+15)==============================================================================

		DoTest = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 15, 5);
		ExpectedProperty = ExcelSheetValue(Xlocation, XSheetNumber, XRowNumber + 15, 4);
		ActualProperty = String.valueOf(element.getCssValue("border-radius"));

		if (DoTest.equals("true") || DoTest.equals("")) {
			if (!ExpectedProperty.equals("null") || !ExpectedProperty.equals(ActualProperty)) {
				TestCasePrint(WebPageName + ": " + WebElementName + ": Border Radius ", ExpectedProperty,
						ActualProperty);
				System.out.println("Testing " + WebPageName + ": " + WebElementName + ": Border Radius - expected:-"
						+ ExpectedProperty + " actual:- " + ActualProperty);
			}
		}
		DoTest = ExpectedProperty = ActualProperty = "";

	}

	public static void ExcelSheetWrite(String location, int sheetnum, int rownum, int columnnum, String printstatus) {
		/**
		 * 
		 * This method is used to write a string value to an Excel file at a specified
		 * location, sheet number, row number, and column number.
		 * 
		 * If the row or cell does not exist, it is created before writing the value.
		 * 
		 * @param location    The location of the Excel file.
		 * 
		 * @param sheetnum    The sheet number in the Excel file (starting from 1).
		 * 
		 * @param rownum      The row number in the sheet (starting from 1).
		 * 
		 * @param columnnum   The column number in the sheet (starting from 1).
		 * 
		 * @param printstatus The string value to be written to the specified cell.
		 */

		Workbook workbook = null;
		FileOutputStream fileOut = null;
		try {
			FileInputStream fileIn = new FileInputStream(location);
			workbook = WorkbookFactory.create(fileIn);
			fileIn.close();

			Sheet sheet = workbook.getSheetAt(sheetnum - 1);

			Row row = sheet.getRow(rownum - 1);
			if (row == null) {
				row = sheet.createRow(rownum - 1);
			}

			Cell cell = row.getCell(columnnum - 1);
			if (cell == null) {
				cell = row.createCell(columnnum - 1);
			}

			cell.setCellValue(printstatus);

			fileOut = new FileOutputStream(location);
			workbook.write(fileOut);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileOut != null)
					fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static String ExcelSheetValue(String location, int sheetnum, int rownum, int columnnum) {
		/**
		 * 
		 * This method retrieves the cell value at a specified location in an Excel
		 * workbook.
		 * 
		 * @param location  the file path of the Excel workbook
		 * 
		 * @param sheetnum  the number of the sheet to be accessed (starting from 1)
		 * 
		 * @param rownum    the row number to be accessed (starting from 1)
		 * 
		 * @param columnnum the column number to be accessed (starting from 1)
		 * 
		 * @return the value in the specified cell as a String
		 * 
		 * @throws IOException            if the file at the specified location cannot
		 *                                be read
		 * 
		 * @throws InvalidFormatException if the workbook is in an invalid format
		 * 
		 * @throws NullPointerException   if the specified cell is null
		 * 
		 * @throws IllegalStateException  if the specified cell has an invalid cell type
		 */

		String values = null;

		Workbook workbook = null;
		FileOutputStream fileOut = null;
		try {
			FileInputStream fileIn = new FileInputStream(location);
			workbook = WorkbookFactory.create(fileIn);
			fileIn.close();

			Sheet sheet = workbook.getSheetAt(sheetnum - 1);

			Row row = sheet.getRow(rownum - 1);
			if (row == null) {
				row = sheet.createRow(rownum - 1);
			}

			Cell cell = row.getCell(columnnum - 1);
			if (cell == null) {
				cell = row.createCell(columnnum - 1);
			}

			if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
				values = String.valueOf(cell.getBooleanCellValue());
			} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				values = cell.getStringCellValue();
			} else {
				values = "";
			}

			fileOut = new FileOutputStream(location);
			workbook.write(fileOut);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileOut != null)
					fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return values;
	}

	public static void ExcelSheetColor(String location, int sheetnum, int rownum, int columnnum, String cellcolor) {
		/*
		 * Method Name: ExcelSheetColor
		 * 
		 * Description: This method is used to change the background color of a
		 * particular cell in an Excel sheet. It takes as input the location of the
		 * Excel file, sheet number, row number, column number, and cell color. It then
		 * creates a workbook and a sheet object, gets the specified row and column,
		 * creates a new cell if it is null and sets its background color to the
		 * specified value. The method then writes the changes to the Excel file.
		 * 
		 * Parameters:
		 * 
		 * location (String) - the file path of the Excel file sheetnum (int) - the
		 * index number of the sheet in the Excel file (starting from 1) rownum (int) -
		 * the index number of the row in the sheet (starting from 1) columnnum (int) -
		 * the index number of the column in the row (starting from 1) cellcolor
		 * (String) - the color to be set as the background of the cell (options are
		 * "red", "green", or "white") Return Value: This method does not return any
		 * value.
		 * 
		 * Exceptions:
		 * 
		 * If any exception occurs during the execution of this method, it prints the
		 * stack trace of the exception.
		 * 
		 */

		Workbook workbook = null;
		FileOutputStream fileOut = null;
		try {
			FileInputStream fileIn = new FileInputStream(location);
			workbook = WorkbookFactory.create(fileIn);
			fileIn.close();

			Sheet sheet = workbook.getSheetAt(sheetnum - 1);

			Row row = sheet.getRow(rownum - 1);
			if (row == null) {
				row = sheet.createRow(rownum - 1);
			}

			Cell cell = row.getCell(columnnum - 1);
			if (cell == null) {
				cell = row.createCell(columnnum - 1);
			}

			if (cellcolor == "red") {
				//
				XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
				style.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 0, 0)));
				style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
				cell.setCellStyle(style);
				//
			} else if (cellcolor == "green") {
				//
				XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
				style.setFillForegroundColor(new XSSFColor(new java.awt.Color(0, 255, 0)));
				style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
				cell.setCellStyle(style);
				//
			} else if (cellcolor == "white") {
				//
				XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
				style.setFillForegroundColor(new XSSFColor(new java.awt.Color(0, 0, 0)));
				style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
				cell.setCellStyle(style);
				//
			}

			fileOut = new FileOutputStream(location);
			workbook.write(fileOut);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileOut != null)
					fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void TestCasePrint(String TestCaseName) {
		TestCasePrint(TestCaseName, null, null, null);
	}

	public static void TestCasePrint(String TestCaseName, Object expectedValue, Object actualValue) {
		TestCasePrint(TestCaseName, expectedValue, actualValue, null);
	}

	public static void TestCasePrint(String TestCaseName, Object expectedValue, Object actualValue,
			String Explanation) {
		/**
		 * 
		 * Prints the results of a test case to an extent report.
		 * 
		 * @param TestCaseName  the name of the test case
		 * 
		 * @param expectedValue the expected value of the test case
		 * 
		 * @param actualValue   the actual value of the test case
		 * 
		 * @param Explanation   an optional explanation for the test case
		 */

		if (expectedValue != null && actualValue != null) {
			boolean position = true;

			ExtentTest testCase = extent.createTest(TestCaseName);
			try {
				AssertJUnit.assertEquals(actualValue, expectedValue);
			} catch (AssertionError e) {
				position = false;
			}
			if (position) {
				testCase.log(Status.INFO, "Actual value: " + actualValue.toString());
				testCase.log(Status.INFO, "Expected value: " + expectedValue.toString());
				if (Explanation != null) {
					testCase.log(Status.INFO, Explanation);
				}
				testCase.log(Status.PASS, "TEST PASS ✅");
			} else {
				testCase.log(Status.INFO, "Actual value: " + actualValue.toString());
				testCase.log(Status.INFO, "Expected value: " + expectedValue.toString());
				if (Explanation != null) {
					testCase.log(Status.INFO, Explanation);
				}
				testCase.log(Status.FAIL, "TEST FAIL ❌");
			}
		} else {
			ExtentTest testCase = extent.createTest(TestCaseName);
//			testCase.log(Status.INFO, TestCaseName);
		}

	}

}
