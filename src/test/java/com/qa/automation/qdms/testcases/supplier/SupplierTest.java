//***********************************************************************************
//* Description
//*------------
//* Methods of supplier testcases
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 30/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        30/03/2023   Sayan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.supplier;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.Status;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.pages.master.SupplierPage;

public class SupplierTest extends DriverIntialization {

	static SupplierPage SupplierPg = new SupplierPage();
	static PlantEquipmentPage page = new PlantEquipmentPage();
	static SourcePage SourcePg = new SourcePage();
	static String suppliercategory = null;
	static String supplier = null;
	static String plant = null;
	static String contactno = null;
	static String email = null;
	static String address = null;
	static boolean check = true;
	static boolean pass = true;

	static String expectedValue = null;

	static int ExpectedTotalPage = 0;
	static int ExpectedTotalPage20 = 0;
	static int ExpectedTotalPage30 = 0;
	static int ExpectedTotalPage100 = 0;

	static String cancelEditEmail = null;
	static String newemail = null;
	static String SupplierCategory = null;
	static String Supplier = null;
	static String Plant = null;
	static String Validation1 = null;
	static String Validation2 = null;
	static String Validation3 = null;
	static String Message = null;

//	ADD SUPPLIER fUNCTION EXCEL
//	---------------------------

	public static void addSupplierExcelData() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Supplier");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0064");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0064");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			suppliercategory = (String) row.getCell(1).getStringCellValue();
			supplier = (String) row.getCell(2).getStringCellValue();
			plant = (String) row.getCell(3).getStringCellValue();
			contactno = (String) row.getCell(4).getStringCellValue();
			email = (String) row.getCell(5).getStringCellValue();
			address = (String) row.getCell(6).getStringCellValue();
		}
	}

//	ADD SUPPLIER WITH MULTIPLE SUPPLIER CATEGORY fUNCTION EXCEL
//	------------------------------------------------------------

	public static void multipleSupplyCategoryExcelData() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Supplier");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0093");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0093");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
//			suppliercategory = (String) row.getCell(1).getStringCellValue();

			supplier = (String) row.getCell(4).getStringCellValue();
			email = (String) row.getCell(5).getStringCellValue();
			contactno = (String) row.getCell(6).getStringCellValue();
			address = (String) row.getCell(7).getStringCellValue();
			plant = (String) row.getCell(8).getStringCellValue();
		}
	}

//	ADD SUPPLIER WITH PAGINATION fUNCTION EXCEL
//	--------------------------------------------

	public static void addSupplierWithPaginationExcelData() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Supplier");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0091");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0091");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			suppliercategory = (String) row.getCell(1).getStringCellValue();
			supplier = (String) row.getCell(2).getStringCellValue();
			plant = (String) row.getCell(3).getStringCellValue();
			contactno = (String) row.getCell(4).getStringCellValue();
			email = (String) row.getCell(5).getStringCellValue();
			address = (String) row.getCell(6).getStringCellValue();
		}
	}

//	EDIT SUPPLIER EXCEL
//	--------------------

	public static void editExcel() throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Supplier");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0074");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0074");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			email = (String) row.getCell(1).getStringCellValue();
			expectedValue = (String) row.getCell(2).getStringCellValue();
		}

	}

//	EDIT SUPPLIER AFTER DEPEND EXCEL
//	---------------------------------

	public static void editAfterDependExcel() throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Supplier");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0087");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0087");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			email = (String) row.getCell(1).getStringCellValue();
			newemail = (String) row.getCell(2).getStringCellValue();
		}

	}

//	ADD DELETED SUPPLIER fUNCTION EXCEL
//	-----------------------------------

	public static void addDeletedSupplierExcelData() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Supplier");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0086");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0086");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			suppliercategory = (String) row.getCell(1).getStringCellValue();
			supplier = (String) row.getCell(2).getStringCellValue();
			plant = (String) row.getCell(3).getStringCellValue();
			contactno = (String) row.getCell(4).getStringCellValue();
			email = (String) row.getCell(5).getStringCellValue();
			address = (String) row.getCell(6).getStringCellValue();
		}
	}

//	FIRST PAGE SUPPLIER DELETE EXCEL
//	---------------------------------

	public static void deleteSupplierExcel() throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Supplier");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0080");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0080");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			email = (String) row.getCell(1).getStringCellValue();

		}

	}

//	MIDDLE PAGE SUPPLIER DELETE EXCEL
//	---------------------------------

	public static void deleteSupplierInMiddleExcel() throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Supplier");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0092");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0092");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			email = (String) row.getCell(1).getStringCellValue();

		}

	}

//	Excel for delete supplier after depend functionality
//	-------------------------------------------------------

	public static void deleteAfterDependExcelData() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Supplier");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0088");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0088");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			email = (String) row.getCell(1).getStringCellValue();
			expectedValue = (String) row.getCell(1).getStringCellValue();
		}
	}

//	PAGINATION fUNCTION EXCEL
//	---------------------------

	public static void paginationExcel() throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Supplier");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0090");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0090");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

//            ExpectedTotalPage = (String) row.getCell(1).getStringCellValue();
//            ExpectedTotalPage20 = (String) row.getCell(2).getStringCellValue();
//            ExpectedTotalPage30 = (String) row.getCell(3).getStringCellValue();
//            ExpectedTotalPage100 = (String) row.getCell(4).getStringCellValue();

			ExpectedTotalPage = (int) row.getCell(1).getNumericCellValue();
			ExpectedTotalPage20 = (int) row.getCell(2).getNumericCellValue();
			ExpectedTotalPage30 = (int) row.getCell(3).getNumericCellValue();
			ExpectedTotalPage100 = (int) row.getCell(4).getNumericCellValue();

		}
	}

//	CANCEL EDIT FUNCTIONALITY EXCEL
//	--------------------------------

	public static void cancelEditExcel() throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Supplier");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0076");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0076");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			email = (String) row.getCell(1).getStringCellValue();

		}

	}

//	CANCEL DELETE FUNCTIONALITY EXCEL
//	--------------------------------

	public static void cancelDeleteExcel() throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Supplier");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0082");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0082");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			email = (String) row.getCell(1).getStringCellValue();

		}

	}

//	SUPPLIER EXPORT BUTTON PROPERTIES
//	--------------------------------------------------

	public static void supplierExportUI() throws InterruptedException {

		PageFactory.initElements(driver, SupplierPg);

		// check if element visible
		testCase = extent.createTest("CHECKING THE \"SUP-EXPORT\" BUTTON PROPERTIES");
		boolean ActualElement = SupplierPage.supplierExportButton.isDisplayed();
		boolean ExpectedElement = true;

		boolean visibility = true;
		testCase = extent.createTest("SUP-EXPORT-BUTTON-VISIBILITY");
		try {
			AssertJUnit.assertEquals(ActualElement, ExpectedElement);

		} catch (AssertionError e) {

			visibility = false;

//			        	  throw(e);
		}
		if (visibility) {
			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
			testCase.log(Status.PASS, "Correct Element");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
			testCase.log(Status.FAIL, "No element");

		}
		Thread.sleep(1000);

		// check position

		Point ActualLocation = SupplierPage.supplierExportButton.getLocation();

		int actual_x = ActualLocation.getX();
		int actual_y = ActualLocation.getY();

		System.out.println("X axis: " + actual_x);
		System.out.println("Y axis: " + actual_y);

		Point ExpectedLocation = new Point(1116, 93);

		boolean Position = true;
		testCase = extent.createTest("SUP-EXPORT-BUTTON-POSITION");
		try {
			AssertJUnit.assertEquals(ActualLocation, ExpectedLocation);

		} catch (AssertionError e) {
			Position = false;
		}
		if (Position) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualLocation);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedLocation);
			testCase.log(Status.PASS, "Correct Location");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualLocation);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedLocation);
			testCase.log(Status.FAIL, "Wrong Location");
		}
		Thread.sleep(1000);

//					 check font size

		String ActualFontSize = SupplierPage.supplierExportButton.getCssValue("font-size");
		System.out.println("Font Size: " + ActualFontSize);
		String ExpectedFontSize = "14px";

		boolean Fontsize = true;
		testCase = extent.createTest("SUP-EXPORT-BUTTON-FONT-SIZE");
		try {
			AssertJUnit.assertEquals(ActualFontSize, ExpectedFontSize);

		} catch (AssertionError e) {
			Fontsize = false;
		}
		if (Fontsize) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualFontSize);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedFontSize);
			testCase.log(Status.PASS, "Correct Font Size");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualFontSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedFontSize);
			testCase.log(Status.FAIL, "Wrong Font Size");
		}
		Thread.sleep(1000);

//					 check the size 

		Dimension ActualSize = SupplierPage.supplierExportButton.getSize();
		System.out.println("Size : " + ActualSize);
		Dimension ExpectedSize = new Dimension(94, 32);

		boolean size = true;
		testCase = extent.createTest("SUP-EXPORT-BUTTON-SIZE");
		try {
			AssertJUnit.assertEquals(ActualSize, ExpectedSize);

		} catch (AssertionError e) {
			size = false;
		}
		if (size) {
			testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
			testCase.log(Status.PASS, "Correct Size");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
			testCase.log(Status.FAIL, "Wrong Size");
		}
		Thread.sleep(1000);

//			            check the enable

		boolean ActualElementEnable = SupplierPage.supplierExportButton.isEnabled();
		boolean ExpectedElementEnable = true;

		boolean enablity = true;
		testCase = extent.createTest("SUP-EXPORT-BUTTON-ENABLE");
		try {
			AssertJUnit.assertEquals(ActualElementEnable, ExpectedElementEnable);

		} catch (AssertionError e) {
			enablity = false;
		}
		if (enablity) {
			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
			testCase.log(Status.PASS, "Element enable");
		} else {
			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
			testCase.log(Status.FAIL, "Element is not enable");
		}
		Thread.sleep(1000);

//			            check the button color

		String ActualButtonColor = SupplierPage.supplierExportButton.getCssValue("background-color");
		System.out.println("rgb :" + ActualButtonColor);

		String ExpectedButtonColor = "rgba(0, 20, 34, 1)";

		boolean buttoncolor = true;
		testCase = extent.createTest("SUP-EXPORT-BUTTON-COLOR");
		try {
			AssertJUnit.assertEquals(ActualButtonColor, ExpectedButtonColor);

		} catch (AssertionError e) {
			buttoncolor = false;
		}
		if (buttoncolor) {
			testCase.log(Status.INFO, "ActualButtonColor :- " + ActualButtonColor);
			testCase.log(Status.INFO, "ExpectedButtonColor :- " + ExpectedButtonColor);
			testCase.log(Status.PASS, "Correct Button Color");
		} else {
			testCase.log(Status.INFO, "ActualButtonColor :- " + ActualButtonColor);
			testCase.log(Status.INFO, "ExpectedButtonColor :- " + ExpectedButtonColor);
			testCase.log(Status.FAIL, "Wrong Button Color");
		}
		Thread.sleep(1000);

//			            check the border color

		String ActualBorderColor = SupplierPage.supplierExportButton.getCssValue("border-colour");
		System.out.println("rgb :" + ActualBorderColor);

		String ExpectedBorderColor = " ";

		boolean bordercolor = true;
		testCase = extent.createTest("SUP-EXPORT-BUTTON-BORDER-COLOR");
		try {
			AssertJUnit.assertEquals(ActualBorderColor, ExpectedBorderColor);

		} catch (AssertionError e) {
			bordercolor = false;
		}
		if (bordercolor) {
			testCase.log(Status.INFO, "ActualBorderColor :- " + ActualBorderColor);
			testCase.log(Status.INFO, "ExpectedBorderColor :- " + ExpectedBorderColor);
			testCase.log(Status.PASS, "Correct Border Color");
		} else {
			testCase.log(Status.INFO, "ActualBorderColor :- " + ActualBorderColor);
			testCase.log(Status.INFO, "ExpectedBorderColor :- " + ExpectedBorderColor);
			testCase.log(Status.FAIL, "Wrong Border Color");
		}
		Thread.sleep(1000);

//			            check the font type 

		String ActualFontType = SupplierPage.supplierExportButton.getCssValue("font-type");
		System.out.println("Font type: " + ActualFontType);

		String ExpectedFontType = "";

		// input[@id='sub_business_unit']

		boolean fonttype = true;
		testCase = extent.createTest("SUP-EXPORT-BUTTON-FONT-TYPE");
		try {
			AssertJUnit.assertEquals(ActualFontType, ExpectedFontType);

		} catch (AssertionError e) {
			fonttype = false;
		}
		if (fonttype) {
			testCase.log(Status.INFO, "ActualFontType :- " + ActualFontType);
			testCase.log(Status.INFO, "ExpectedFontType :- " + ExpectedFontType);
			testCase.log(Status.PASS, "Correct Font Type");
		} else {
			testCase.log(Status.INFO, "ActualFontType :- " + ActualFontType);
			testCase.log(Status.INFO, "ExpectedFontType :- " + ExpectedFontType);
			testCase.log(Status.FAIL, "Wrong Font Type");
		}
		Thread.sleep(1000);

//			                    check font color

		String ActualFontColor = SupplierPage.supplierExportButton.getCssValue("color");

		System.out.println("Font colour: " + ActualFontColor);

		String ExpectedFontColor = "rgba(255, 255, 255, 1)";
		testCase = extent.createTest("SUP-EXPORT-BUTTON-FONT-COLOUR");
		try {
			AssertJUnit.assertEquals(ActualFontColor, ExpectedFontColor);
			testCase.log(Status.INFO, "ActualFontColor :- " + ActualFontColor);
			testCase.log(Status.INFO, "ExpectedFontColor :- " + ExpectedFontColor);

			testCase.log(Status.PASS, "Correct font Colour");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualFontColor :- " + ActualFontColor);
			testCase.log(Status.INFO, "ExpectedFontColor :- " + ExpectedFontColor);

			testCase.log(Status.FAIL, "wrong font Colour");
		}
		Thread.sleep(1000);

//					cursor

		String ActualActions = SupplierPage.supplierExportButton.getCssValue("cursor");
		System.out.println("cursor :" + ActualActions);
		String ExpectedActions = "pointer";

		boolean cursor = true;
		testCase = extent.createTest("SUP-EXPORT-BUTTON-CURSOR");
		try {
			AssertJUnit.assertEquals(ActualActions, ExpectedActions);

		} catch (AssertionError e) {
			cursor = false;
		}
		if (cursor) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualActions);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedActions);
			testCase.log(Status.PASS, "drop down auto");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualActions);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedActions);
			testCase.log(Status.FAIL, "drop dow not auto");
		}
		Thread.sleep(1000);

//					text spelling

		String text = SupplierPage.supplierExportButton.getText();

		String text1 = "Export";
		boolean txt1 = true;
		testCase = extent.createTest("SUP-EXPORT-BUTTON-SPELLING");

		try {
			AssertJUnit.assertEquals(text, text1);
		} catch (AssertionError e) {
			txt1 = false;
		}
		if (txt1) {
			testCase.log(Status.INFO, "ActualElement :- " + text);
			testCase.log(Status.INFO, "ExpectedElement :- " + text1);
			testCase.log(Status.INFO, "correct text");
			testCase.log(Status.PASS, "Correct ");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + text);
			testCase.log(Status.INFO, "ExpectedElement :- " + text1);
			testCase.log(Status.INFO, "wrong text");
			testCase.log(Status.FAIL, "wrong");
		}

		Thread.sleep(1000);

//					padding

		String Actualvalue = SupplierPage.supplierExportButton.getCssValue("padding");
		System.out.println("paddingvalue :" + Actualvalue);
		String Expectedvalue = "4px 16px";

		boolean padding = true;
		testCase = extent.createTest("SUP-EXPORT-BUTTON-PADDING");
		try {
			AssertJUnit.assertEquals(Actualvalue, Expectedvalue);

		} catch (AssertionError e) {
			padding = false;
		}
		if (padding) {
			testCase.log(Status.INFO, "Actualvalue :- " + Actualvalue);
			testCase.log(Status.INFO, "Expectedvalue :- " + Expectedvalue);
			testCase.log(Status.PASS, "Correct value");
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + Actualvalue);
			testCase.log(Status.INFO, "Expectedvalue :- " + Expectedvalue);
			testCase.log(Status.FAIL, "Wrong Value");
		}
		Thread.sleep(1000);

//			  		border radius

		String Actualradius = SupplierPage.supplierExportButton.getCssValue("border-radius");
		System.out.println("radius value :" + Actualradius);
		String Expectedradius = "32px";

		testCase = extent.createTest("SUP-EXPORT-BUTTON-RADIUS");
		try {
			AssertJUnit.assertEquals(Actualradius, Expectedradius);

		} catch (AssertionError e) {
			padding = false;
		}
		if (padding) {
			testCase.log(Status.INFO, "Actualradius :- " + Actualradius);
			testCase.log(Status.INFO, "Expectedradius :- " + Expectedradius);
			testCase.log(Status.PASS, "Correct value");
		} else {
			testCase.log(Status.INFO, "Actualradius :- " + Actualradius);
			testCase.log(Status.INFO, "Expectedradius :- " + Expectedradius);
			testCase.log(Status.FAIL, "Wrong Value");
		}
		Thread.sleep(1000);

//					opacity

		String Actualopacity = SupplierPage.supplierExportButton.getCssValue("opacity");
		System.out.println("opacity  :" + Actualopacity);
		String Expectedopacity = "1";

		boolean opacity = true;
		testCase = extent.createTest("SUP-EXPORT-BUTTON-OPACITY");
		try {
			AssertJUnit.assertEquals(Actualopacity, Expectedopacity);

		} catch (AssertionError e) {
			opacity = false;
		}
		if (opacity) {
			testCase.log(Status.INFO, "Actualopacity :- " + Actualopacity);
			testCase.log(Status.INFO, "Expectedopacity :- " + Expectedopacity);
			testCase.log(Status.PASS, "Correct value");
		} else {
			testCase.log(Status.INFO, "Actualopacity :- " + Actualopacity);
			testCase.log(Status.INFO, "Expectedopacity :- " + Expectedopacity);
			testCase.log(Status.FAIL, "Wrong Value");
		}
		Thread.sleep(1000);

//					font weight

		String Actualfontweight = SupplierPage.supplierExportButton.getCssValue("font-weight");
		System.out.println("fontweight  :" + Actualfontweight);
		String Expectedfontweight = "400";

		boolean fontweight = true;
		testCase = extent.createTest("SUP-EXPORT-BUTTON-FONT-WEIGHT");
		try {
			AssertJUnit.assertEquals(Actualfontweight, Expectedfontweight);

		} catch (AssertionError e) {
			fontweight = false;
		}
		if (fontweight) {
			testCase.log(Status.INFO, "Actualfontweight :- " + Actualfontweight);
			testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedfontweight);
			testCase.log(Status.PASS, "Correct font weight");
		} else {
			testCase.log(Status.INFO, "Actualfontweight :- " + Actualfontweight);
			testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedfontweight);
			testCase.log(Status.FAIL, "Wrong font weight");
		}
		Thread.sleep(1000);
	}

//	-------------------------------------------------------------------------------------------------------
//	----------------------------------------------------------------------------------------------------------
//	----------------------------------------------------------------------------------------------------------

//	SUPPLIER IMPORT BUTTON PROPERTIES
//	--------------------------------------------------

	public static void supplierImportUI() throws InterruptedException {

		PageFactory.initElements(driver, SupplierPg);

		// check if element visible
		testCase = extent.createTest("STEP 2 - CHECKING THE \"SUP-IMPORT\" BUTTON PROPERTIES");
		boolean ActualElement = SupplierPage.supplierImportButton.isDisplayed();
		boolean ExpectedElement = true;

		boolean visibility = true;
		testCase = extent.createTest("SUP-IMPORT-BUTTON-VISIBILITY");
		try {
			AssertJUnit.assertEquals(ActualElement, ExpectedElement);

		} catch (AssertionError e) {

			visibility = false;

//			        	  throw(e);
		}
		if (visibility) {
			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
			testCase.log(Status.PASS, "Correct Element");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
			testCase.log(Status.FAIL, "No element");

		}
		Thread.sleep(1000);

		// check position

		Point ActualLocation = SupplierPage.supplierImportButton.getLocation();

		int actual_x = ActualLocation.getX();
		int actual_y = ActualLocation.getY();

		System.out.println("X axis: " + actual_x);
		System.out.println("Y axis: " + actual_y);

		Point ExpectedLocation = new Point(588, 93);

		boolean Position = true;
		testCase = extent.createTest("SUP-IMPORT-BUTTON-POSITION");
		try {
			AssertJUnit.assertEquals(ActualLocation, ExpectedLocation);

		} catch (AssertionError e) {
			Position = false;
		}
		if (Position) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualLocation);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedLocation);
			testCase.log(Status.PASS, "Correct Location");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualLocation);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedLocation);
			testCase.log(Status.FAIL, "Wrong Location");
		}
		Thread.sleep(1000);

//					 check font size

		String ActualFontSize = SupplierPage.supplierImportButton.getCssValue("font-size");
		System.out.println("Font Size: " + ActualFontSize);
		String ExpectedFontSize = "14px";

		boolean Fontsize = true;
		testCase = extent.createTest("SUP-IMPORT-BUTTON-FONT-SIZE");
		try {
			AssertJUnit.assertEquals(ActualFontSize, ExpectedFontSize);

		} catch (AssertionError e) {
			Fontsize = false;
		}
		if (Fontsize) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualFontSize);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedFontSize);
			testCase.log(Status.PASS, "Correct Font Size");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualFontSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedFontSize);
			testCase.log(Status.FAIL, "Wrong Font Size");
		}
		Thread.sleep(1000);

//					 check the size 

		Dimension ActualSize = SupplierPage.supplierImportButton.getSize();
		System.out.println("Size : " + ActualSize);
		Dimension ExpectedSize = new Dimension(180, 32);

		boolean size = true;
		testCase = extent.createTest("SUP-IMPORT-BUTTON-SIZE");
		try {
			AssertJUnit.assertEquals(ActualSize, ExpectedSize);

		} catch (AssertionError e) {
			size = false;
		}
		if (size) {
			testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
			testCase.log(Status.PASS, "Correct Size");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
			testCase.log(Status.FAIL, "Wrong Size");
		}
		Thread.sleep(1000);

//			            check the enable

		boolean ActualElementEnable = SupplierPage.supplierImportButton.isEnabled();
		boolean ExpectedElementEnable = true;

		boolean enablity = true;
		testCase = extent.createTest("SUP-IMPORT-BUTTON-ENABLE");
		try {
			AssertJUnit.assertEquals(ActualElementEnable, ExpectedElementEnable);

		} catch (AssertionError e) {
			enablity = false;
		}
		if (enablity) {
			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
			testCase.log(Status.PASS, "Element enable");
		} else {
			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
			testCase.log(Status.FAIL, "Element is not enable");
		}
		Thread.sleep(1000);

//			            check the button color

		String ActualButtonColor = SupplierPage.supplierImportButton.getCssValue("background-color");
		System.out.println("rgb :" + ActualButtonColor);

		String ExpectedButtonColor = "rgba(0, 19, 40, 1)";

		boolean buttoncolor = true;
		testCase = extent.createTest("SUP-IMPORT-BUTTON-COLOR");
		try {
			AssertJUnit.assertEquals(ActualButtonColor, ExpectedButtonColor);

		} catch (AssertionError e) {
			buttoncolor = false;
		}
		if (buttoncolor) {
			testCase.log(Status.INFO, "ActualButtonColor :- " + ActualButtonColor);
			testCase.log(Status.INFO, "ExpectedButtonColor :- " + ExpectedButtonColor);
			testCase.log(Status.PASS, "Correct Button Color");
		} else {
			testCase.log(Status.INFO, "ActualButtonColor :- " + ActualButtonColor);
			testCase.log(Status.INFO, "ExpectedButtonColor :- " + ExpectedButtonColor);
			testCase.log(Status.FAIL, "Wrong Button Color");
		}
		Thread.sleep(1000);

//			            check the border color

		String ActualBorderColor = SupplierPage.supplierImportButton.getCssValue("border-colour");
		System.out.println("rgb :" + ActualBorderColor);

		String ExpectedBorderColor = " ";

		boolean bordercolor = true;
		testCase = extent.createTest("SUP-IMPORT-BUTTON-BORDER-COLOR");
		try {
			AssertJUnit.assertEquals(ActualBorderColor, ExpectedBorderColor);

		} catch (AssertionError e) {
			bordercolor = false;
		}
		if (bordercolor) {
			testCase.log(Status.INFO, "ActualBorderColor :- " + ActualBorderColor);
			testCase.log(Status.INFO, "ExpectedBorderColor :- " + ExpectedBorderColor);
			testCase.log(Status.PASS, "Correct Border Color");
		} else {
			testCase.log(Status.INFO, "ActualBorderColor :- " + ActualBorderColor);
			testCase.log(Status.INFO, "ExpectedBorderColor :- " + ExpectedBorderColor);
			testCase.log(Status.FAIL, "Wrong Border Color");
		}
		Thread.sleep(1000);

//			            check the font type 

		String ActualFontType = SupplierPage.supplierImportButton.getCssValue("font-type");
		System.out.println("Font type: " + ActualFontType);

		String ExpectedFontType = "";

		// input[@id='sub_business_unit']

		boolean fonttype = true;
		testCase = extent.createTest("SUP-IMPORT-BUTTON-FONT-TYPE");
		try {
			AssertJUnit.assertEquals(ActualFontType, ExpectedFontType);

		} catch (AssertionError e) {
			fonttype = false;
		}
		if (fonttype) {
			testCase.log(Status.INFO, "ActualFontType :- " + ActualFontType);
			testCase.log(Status.INFO, "ExpectedFontType :- " + ExpectedFontType);
			testCase.log(Status.PASS, "Correct Font Type");
		} else {
			testCase.log(Status.INFO, "ActualFontType :- " + ActualFontType);
			testCase.log(Status.INFO, "ExpectedFontType :- " + ExpectedFontType);
			testCase.log(Status.FAIL, "Wrong Font Type");
		}
		Thread.sleep(1000);

//			                    check font color

		String ActualFontColor = SupplierPage.supplierImportButton.getCssValue("color");

		System.out.println("Font colour: " + ActualFontColor);

		String ExpectedFontColor = "rgba(255, 255, 255, 1)";
		testCase = extent.createTest("SUP-IMPORT-BUTTON-FONT-COLOUR");
		try {
			AssertJUnit.assertEquals(ActualFontColor, ExpectedFontColor);
			testCase.log(Status.INFO, "ActualFontColor :- " + ActualFontColor);
			testCase.log(Status.INFO, "ExpectedFontColor :- " + ExpectedFontColor);

			testCase.log(Status.PASS, "Correct font Colour");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualFontColor :- " + ActualFontColor);
			testCase.log(Status.INFO, "ExpectedFontColor :- " + ExpectedFontColor);

			testCase.log(Status.FAIL, "wrong font Colour");
		}
		Thread.sleep(1000);

//					cursor

		String ActualActions = SupplierPage.supplierImportButton.getCssValue("cursor");
		System.out.println("cursor :" + ActualActions);
		String ExpectedActions = "pointer";

		boolean cursor = true;
		testCase = extent.createTest("SUP-IMPORT-BUTTON-CURSOR");
		try {
			AssertJUnit.assertEquals(ActualActions, ExpectedActions);

		} catch (AssertionError e) {
			cursor = false;
		}
		if (cursor) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualActions);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedActions);
			testCase.log(Status.PASS, "drop down auto");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualActions);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedActions);
			testCase.log(Status.FAIL, "drop dow not auto");
		}
		Thread.sleep(1000);

//					text spelling

		String text = SupplierPage.supplierImportButton.getText();

		String text1 = "Add SBU";
		boolean txt1 = true;
		testCase = extent.createTest("SUP-IMPORT-BUTTON-SPELLING");

		try {
			AssertJUnit.assertEquals(text, text1);
		} catch (AssertionError e) {
			txt1 = false;
		}
		if (txt1) {
			testCase.log(Status.INFO, "ActualElement :- " + text);
			testCase.log(Status.INFO, "ExpectedElement :- " + text1);
			testCase.log(Status.INFO, "correct text");
			testCase.log(Status.PASS, "Correct ");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + text);
			testCase.log(Status.INFO, "ExpectedElement :- " + text1);
			testCase.log(Status.INFO, "wrong text");
			testCase.log(Status.FAIL, "wrong");
		}

		Thread.sleep(1000);

//					padding

		String Actualvalue = SupplierPage.supplierImportButton.getCssValue("padding");
		System.out.println("paddingvalue :" + Actualvalue);
		String Expectedvalue = "4px 15px";

		boolean padding = true;
		testCase = extent.createTest("SUP-IMPORT-BUTTON-PADDING");
		try {
			AssertJUnit.assertEquals(Actualvalue, Expectedvalue);

		} catch (AssertionError e) {
			padding = false;
		}
		if (padding) {
			testCase.log(Status.INFO, "Actualvalue :- " + ActualActions);
			testCase.log(Status.INFO, "Expectedvalue :- " + Expectedvalue);
			testCase.log(Status.PASS, "Correct value");
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + ActualActions);
			testCase.log(Status.INFO, "Expectedvalue :- " + Expectedvalue);
			testCase.log(Status.FAIL, "Wrong Value");
		}
		Thread.sleep(1000);

//			  		border radius

		String Actualradius = SupplierPage.supplierImportButton.getCssValue("border-radius");
		System.out.println("radius value :" + Actualradius);
		String Expectedradius = "2px";

		testCase = extent.createTest("SUP-IMPORT-BUTTON-RADIUS");
		try {
			AssertJUnit.assertEquals(Actualradius, Expectedradius);

		} catch (AssertionError e) {
			padding = false;
		}
		if (padding) {
			testCase.log(Status.INFO, "Actualradius :- " + ActualActions);
			testCase.log(Status.INFO, "Expectedradius :- " + Expectedradius);
			testCase.log(Status.PASS, "Correct value");
		} else {
			testCase.log(Status.INFO, "Actualradius :- " + ActualActions);
			testCase.log(Status.INFO, "Expectedradius :- " + Expectedradius);
			testCase.log(Status.FAIL, "Wrong Value");
		}
		Thread.sleep(1000);

//					opacity

		String Actualopacity = SupplierPage.supplierImportButton.getCssValue("opacity");
		System.out.println("opacity  :" + Actualopacity);
		String Expectedopacity = "1";

		boolean opacity = true;
		testCase = extent.createTest("SUP-IMPORT-BUTTON-OPACITY");
		try {
			AssertJUnit.assertEquals(Actualopacity, Expectedopacity);

		} catch (AssertionError e) {
			opacity = false;
		}
		if (opacity) {
			testCase.log(Status.INFO, "Actualopacity :- " + Actualopacity);
			testCase.log(Status.INFO, "Expectedopacity :- " + Expectedopacity);
			testCase.log(Status.PASS, "Correct value");
		} else {
			testCase.log(Status.INFO, "Actualopacity :- " + Actualopacity);
			testCase.log(Status.INFO, "Expectedopacity :- " + Expectedopacity);
			testCase.log(Status.FAIL, "Wrong Value");
		}
		Thread.sleep(1000);

//					font weight

		String Actualfontweight = SupplierPage.supplierImportButton.getCssValue("font-weight");
		System.out.println("fontweight  :" + Actualfontweight);
		String Expectedfontweight = "400";

		boolean fontweight = true;
		testCase = extent.createTest("SUP-IMPORT-BUTTON-FONT-WEIGHT");
		try {
			AssertJUnit.assertEquals(Actualfontweight, Expectedfontweight);

		} catch (AssertionError e) {
			fontweight = false;
		}
		if (fontweight) {
			testCase.log(Status.INFO, "Actualfontweight :- " + Actualfontweight);
			testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedfontweight);
			testCase.log(Status.PASS, "Correct font weight");
		} else {
			testCase.log(Status.INFO, "Actualfontweight :- " + Actualfontweight);
			testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedfontweight);
			testCase.log(Status.FAIL, "Wrong font weight");
		}
		Thread.sleep(1000);
	}

//--------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------

//  SUPPLIER EXPORT
//----------------------------------------------------------------

	public static void supplierExport() throws InterruptedException {

		SupplierPage.supplierExportButton.click();

		Thread.sleep(3000);

		File fileLocation = new File("C:\\Users\\sgic\\Downloads");

		boolean isFileExist = false;

		// List the total files
		File[] totalFiles = fileLocation.listFiles();

		for (File file : totalFiles) {

			if (file.getName().equals("supplier.csv")) {

				System.out.println("File is downloaded");

				// if find the file name stop the loop
				isFileExist = true;
				break;

			}
		}

		boolean Expectedweight = true;
		testCase = extent.createTest("SUPPLIER EXPORT");
		if (isFileExist == true) {
			AssertJUnit.assertEquals(isFileExist, Expectedweight);
			System.out.println(isFileExist);
			System.out.println(Expectedweight);
			testCase.log(Status.INFO, "Actualfontweight :- " + isFileExist);
			testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedweight);
			testCase.log(Status.PASS, "correct");
		} else {
			testCase.log(Status.INFO, "Actualfontweight :- " + isFileExist);
			testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedweight);
			testCase.log(Status.FAIL, "wrong");
		}
	}

// ADD SUPPLIER BUTTON PROPERTIES
// --------------------------------------------------

	public static void addSupplierButtonUI() throws InterruptedException {

		// check if element visible
		testCase = extent.createTest("CHECKING THE \"ADD SUPPLIER\" BUTTON PROPERTIES");
		boolean ActualElement = SupplierPage.addSupplierButton.isDisplayed();
		boolean ExpectedElement = true;

		boolean visibility = true;
		testCase = extent.createTest("ADD SUPPLIER-BUTTON-VISIBILITY");
		try {
			AssertJUnit.assertEquals(ActualElement, ExpectedElement);

		} catch (AssertionError e) {

			visibility = false;

//	        	  throw(e);
		}
		if (visibility) {
			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
			testCase.log(Status.PASS, "Correct Element");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
			testCase.log(Status.FAIL, "No element");

		}
		Thread.sleep(1000);

		// check position

		Point ActualLocation = SupplierPage.addSupplierButton.getLocation();

		int actual_x = ActualLocation.getX();
		int actual_y = ActualLocation.getY();

		System.out.println("X axis: " + actual_x);
		System.out.println("Y axis: " + actual_y);

		Point ExpectedLocation = new Point(1225, 93);

		boolean Position = true;
		testCase = extent.createTest("ADD SUPPLIER-BUTTON-POSITION");
		try {
			AssertJUnit.assertEquals(ActualLocation, ExpectedLocation);

		} catch (AssertionError e) {
			Position = false;
		}
		if (Position) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualLocation);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedLocation);
			testCase.log(Status.PASS, "Correct Location");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualLocation);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedLocation);
			testCase.log(Status.FAIL, "Wrong Location");
		}
		Thread.sleep(1000);

//			 check font size

		String ActualFontSize = SupplierPage.addSupplierButton.getCssValue("font-size");
		System.out.println("Font Size: " + ActualFontSize);
		String ExpectedFontSize = "14px";

		boolean Fontsize = true;
		testCase = extent.createTest("ADD SUPPLIER-BUTTON-FONT-SIZE");
		try {
			AssertJUnit.assertEquals(ActualFontSize, ExpectedFontSize);

		} catch (AssertionError e) {
			Fontsize = false;
		}
		if (Fontsize) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualFontSize);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedFontSize);
			testCase.log(Status.PASS, "Correct Font Size");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualFontSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedFontSize);
			testCase.log(Status.FAIL, "Wrong Font Size");
		}
		Thread.sleep(1000);

//			 check the size 

		Dimension ActualSize = SupplierPage.addSupplierButton.getSize();
		System.out.println("Size : " + ActualSize);
		Dimension ExpectedSize = new Dimension(120, 32);

		boolean size = true;
		testCase = extent.createTest("ADD SUPPLIER-BUTTON-SIZE");
		try {
			AssertJUnit.assertEquals(ActualSize, ExpectedSize);

		} catch (AssertionError e) {
			size = false;
		}
		if (size) {
			testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
			testCase.log(Status.PASS, "Correct Size");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
			testCase.log(Status.FAIL, "Wrong Size");
		}
		Thread.sleep(1000);

//	            check the enable

		boolean ActualElementEnable = SupplierPage.addSupplierButton.isEnabled();
		boolean ExpectedElementEnable = true;

		boolean enablity = true;
		testCase = extent.createTest("ADD SUPPLIER-BUTTON-ENABLE");
		try {
			AssertJUnit.assertEquals(ActualElementEnable, ExpectedElementEnable);

		} catch (AssertionError e) {
			enablity = false;
		}
		if (enablity) {
			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
			testCase.log(Status.PASS, "Element enable");
		} else {
			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
			testCase.log(Status.FAIL, "Element is not enable");
		}
		Thread.sleep(1000);

//	            check the button color

		String ActualButtonColor = SupplierPage.addSupplierButton.getCssValue("background-color");
		System.out.println("rgb :" + ActualButtonColor);

		String ExpectedButtonColor = "rgba(0, 19, 40, 1)";

		boolean buttoncolor = true;
		testCase = extent.createTest("ADD SUPPLIER-BUTTON-COLOR");
		try {
			AssertJUnit.assertEquals(ActualButtonColor, ExpectedButtonColor);

		} catch (AssertionError e) {
			buttoncolor = false;
		}
		if (buttoncolor) {
			testCase.log(Status.INFO, "ActualButtonColor :- " + ActualButtonColor);
			testCase.log(Status.INFO, "ExpectedButtonColor :- " + ExpectedButtonColor);
			testCase.log(Status.PASS, "Correct Button Color");
		} else {
			testCase.log(Status.INFO, "ActualButtonColor :- " + ActualButtonColor);
			testCase.log(Status.INFO, "ExpectedButtonColor :- " + ExpectedButtonColor);
			testCase.log(Status.FAIL, "Wrong Button Color");
		}
		Thread.sleep(1000);

//	            check the border color

		String ActualBorderColor = SupplierPage.addSupplierButton.getCssValue("border-colour");
		System.out.println("rgb :" + ActualBorderColor);

		String ExpectedBorderColor = " ";

		boolean bordercolor = true;
		testCase = extent.createTest("ADD SUPPLIER-BUTTON-BORDER-COLOR");
		try {
			AssertJUnit.assertEquals(ActualBorderColor, ExpectedBorderColor);

		} catch (AssertionError e) {
			bordercolor = false;
		}
		if (bordercolor) {
			testCase.log(Status.INFO, "ActualBorderColor :- " + ActualBorderColor);
			testCase.log(Status.INFO, "ExpectedBorderColor :- " + ExpectedBorderColor);
			testCase.log(Status.PASS, "Correct Border Color");
		} else {
			testCase.log(Status.INFO, "ActualBorderColor :- " + ActualBorderColor);
			testCase.log(Status.INFO, "ExpectedBorderColor :- " + ExpectedBorderColor);
			testCase.log(Status.FAIL, "Wrong Border Color");
		}
		Thread.sleep(1000);

//	            check the font type 

		String ActualFontType = SupplierPage.addSupplierButton.getCssValue("font-type");
		System.out.println("Font type: " + ActualFontType);

		String ExpectedFontType = "";

		// input[@id='sub_business_unit']

		boolean fonttype = true;
		testCase = extent.createTest("ADD SUPPLIER-BUTTON-FONT-TYPE");
		try {
			AssertJUnit.assertEquals(ActualFontType, ExpectedFontType);

		} catch (AssertionError e) {
			fonttype = false;
		}
		if (fonttype) {
			testCase.log(Status.INFO, "ActualFontType :- " + ActualFontType);
			testCase.log(Status.INFO, "ExpectedFontType :- " + ExpectedFontType);
			testCase.log(Status.PASS, "Correct Font Type");
		} else {
			testCase.log(Status.INFO, "ActualFontType :- " + ActualFontType);
			testCase.log(Status.INFO, "ExpectedFontType :- " + ExpectedFontType);
			testCase.log(Status.FAIL, "Wrong Font Type");
		}
		Thread.sleep(1000);

//	                    check font color

		String ActualFontColor = SupplierPage.addSupplierButton.getCssValue("color");

		System.out.println("Font colour: " + ActualFontColor);

		String ExpectedFontColor = "rgba(255, 255, 255, 1)";
		testCase = extent.createTest("ADD SUPPLIER-BUTTON-FONT-COLOUR");
		try {
			AssertJUnit.assertEquals(ActualFontColor, ExpectedFontColor);
			testCase.log(Status.INFO, "ActualFontColor :- " + ActualFontColor);
			testCase.log(Status.INFO, "ExpectedFontColor :- " + ExpectedFontColor);

			testCase.log(Status.PASS, "Correct font Colour");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualFontColor :- " + ActualFontColor);
			testCase.log(Status.INFO, "ExpectedFontColor :- " + ExpectedFontColor);

			testCase.log(Status.FAIL, "wrong font Colour");
		}
		Thread.sleep(1000);

//			cursor

		String ActualActions = SupplierPage.addSupplierButton.getCssValue("cursor");
		System.out.println("cursor :" + ActualActions);
		String ExpectedActions = "pointer";

		boolean cursor = true;
		testCase = extent.createTest("ADD SUPPLIER-BUTTON-CURSOR");
		try {
			AssertJUnit.assertEquals(ActualActions, ExpectedActions);

		} catch (AssertionError e) {
			cursor = false;
		}
		if (cursor) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualActions);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedActions);
			testCase.log(Status.PASS, "drop down auto");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualActions);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedActions);
			testCase.log(Status.FAIL, "drop dow not auto");
		}
		Thread.sleep(1000);

//			text spelling

		String text = SupplierPage.addSupplierButton.getText();

		String text1 = "Add Supplier";
		boolean txt1 = true;
		testCase = extent.createTest("ADD SUPPLIER-BUTTON-SPELLING");

		try {
			AssertJUnit.assertEquals(text, text1);
		} catch (AssertionError e) {
			txt1 = false;
		}
		if (txt1) {
			testCase.log(Status.INFO, "ActualElement :- " + text);
			testCase.log(Status.INFO, "ExpectedElement :- " + text1);
			testCase.log(Status.INFO, "correct text");
			testCase.log(Status.PASS, "Correct ");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + text);
			testCase.log(Status.INFO, "ExpectedElement :- " + text1);
			testCase.log(Status.INFO, "wrong text");
			testCase.log(Status.FAIL, "wrong");
		}

		Thread.sleep(1000);

//			padding

		String Actualvalue = SupplierPage.addSupplierButton.getCssValue("padding");
		System.out.println("paddingvalue :" + Actualvalue);
		String Expectedvalue = "4px 15px";

		boolean padding = true;
		testCase = extent.createTest("ADD SUPPLIER-BUTTON-PADDING");
		try {
			AssertJUnit.assertEquals(Actualvalue, Expectedvalue);

		} catch (AssertionError e) {
			padding = false;
		}
		if (padding) {
			testCase.log(Status.INFO, "Actualvalue :- " + Actualvalue);
			testCase.log(Status.INFO, "Expectedvalue :- " + Expectedvalue);
			testCase.log(Status.PASS, "Correct value");
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + Actualvalue);
			testCase.log(Status.INFO, "Expectedvalue :- " + Expectedvalue);
			testCase.log(Status.FAIL, "Wrong Value");
		}
		Thread.sleep(1000);

//	  		border radius

		String Actualradius = SupplierPage.addSupplierButton.getCssValue("border-radius");
		System.out.println("radius value :" + Actualradius);
		String Expectedradius = "2px";

		testCase = extent.createTest("ADD SUPPLIER-BUTTON-RADIUS");
		try {
			AssertJUnit.assertEquals(Actualradius, Expectedradius);

		} catch (AssertionError e) {
			padding = false;
		}
		if (padding) {
			testCase.log(Status.INFO, "Actualradius :- " + Actualradius);
			testCase.log(Status.INFO, "Expectedradius :- " + Expectedradius);
			testCase.log(Status.PASS, "Correct value");
		} else {
			testCase.log(Status.INFO, "Actualradius :- " + Actualradius);
			testCase.log(Status.INFO, "Expectedradius :- " + Expectedradius);
			testCase.log(Status.FAIL, "Wrong Value");
		}
		Thread.sleep(1000);

//			opacity

		String Actualopacity = SupplierPage.addSupplierButton.getCssValue("opacity");
		System.out.println("opacity  :" + Actualopacity);
		String Expectedopacity = "1";

		boolean opacity = true;
		testCase = extent.createTest("ADD SUPPLIER-BUTTON-OPACITY");
		try {
			AssertJUnit.assertEquals(Actualopacity, Expectedopacity);

		} catch (AssertionError e) {
			opacity = false;
		}
		if (opacity) {
			testCase.log(Status.INFO, "Actualopacity :- " + Actualopacity);
			testCase.log(Status.INFO, "Expectedopacity :- " + Expectedopacity);
			testCase.log(Status.PASS, "Correct value");
		} else {
			testCase.log(Status.INFO, "Actualopacity :- " + Actualopacity);
			testCase.log(Status.INFO, "Expectedopacity :- " + Expectedopacity);
			testCase.log(Status.FAIL, "Wrong Value");
		}
		Thread.sleep(1000);

//			font weight

		String Actualfontweight = SupplierPage.addSupplierButton.getCssValue("font-weight");
		System.out.println("fontweight  :" + Actualfontweight);
		String Expectedfontweight = "400";

		boolean fontweight = true;
		testCase = extent.createTest("ADD SUPPLIER-BUTTON-FONT-WEIGHT");
		try {
			AssertJUnit.assertEquals(Actualfontweight, Expectedfontweight);

		} catch (AssertionError e) {
			fontweight = false;
		}
		if (fontweight) {
			testCase.log(Status.INFO, "Actualfontweight :- " + Actualfontweight);
			testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedfontweight);
			testCase.log(Status.PASS, "Correct font weight");
		} else {
			testCase.log(Status.INFO, "Actualfontweight :- " + Actualfontweight);
			testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedfontweight);
			testCase.log(Status.FAIL, "Wrong font weight");
		}
		Thread.sleep(1000);

	}

//	selecting supplier category dropdown 
//	--------------------------------------------------

	public static void addSupplierDropdown() throws InterruptedException {

		PageFactory.initElements(driver, SupplierPg);

		if (check) {
			Thread.sleep(5000);
			for (int j = 1; j <= 10; j++) {
				WebElement name = driver
						.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[" + j + "]"));
				String dropcontent = name.getText();
				if (dropcontent.contentEquals(suppliercategory)) {
					name.click();
					pass = true;
				} else if (dropcontent.isEmpty()) {
					pass = true;
				}
			}
		}
	}

// sending values to the fields 
// ----------------------------------------

	public static void addSupplierSendValues() throws InterruptedException {

		PageFactory.initElements(driver, SupplierPg);

		Thread.sleep(500);
		SupplierPage.supplierField.click();
		SupplierPage.supplierField.sendKeys(supplier);

		Thread.sleep(500);
		SupplierPage.contactNoField.click();
		SupplierPage.contactNoField.sendKeys(contactno);

		Thread.sleep(500);
		SupplierPage.emailField.click();
		SupplierPage.emailField.sendKeys(email);

		Thread.sleep(500);
		SupplierPage.addressField.click();
		SupplierPage.addressField.sendKeys(address);

	}

//	selecting plant dropdown 
//	--------------------------------------------------

	public static void addPlantDropdown() throws InterruptedException {

		PageFactory.initElements(driver, SupplierPg);

		if (check) {

			for (int j = 1; j <= 8; j++) {
				Thread.sleep(1000);
				WebElement name1 = driver.findElement(
						By.xpath("//body[@class='ant-scrolling-effect']/div[5]/div/div/div/div[2]/div[1]/div/div/div["
								+ j + "]/div"));
				String dropcontent1 = name1.getText();
				System.out.println(dropcontent1);
				Thread.sleep(500);
				if (dropcontent1.contentEquals(plant)) {
					Thread.sleep(2500);
					name1.click();
					pass = true;
				}
				if (dropcontent1.isEmpty()) {
					pass = true;
				}
			}
		}

	}

//SUPPLIER SAVE BUTTON PROPERTIES
//--------------------------------------------------

	public static void supplierSaveButtonUI() throws InterruptedException {

		// check if element visible
		testCase = extent.createTest("CHECKING THE \"SUPPLIER-SAVE\" BUTTON PROPERTIES");
		boolean ActualElement = SupplierPage.supplierSaveButton.isDisplayed();
		boolean ExpectedElement = true;

		boolean visibility = true;
		testCase = extent.createTest("SUPPLIER-SAVE-BUTTON-VISIBILITY");
		try {
			AssertJUnit.assertEquals(ActualElement, ExpectedElement);

		} catch (AssertionError e) {

			visibility = false;

//		        	  throw(e);
		}
		if (visibility) {
			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
			testCase.log(Status.PASS, "Correct Element");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
			testCase.log(Status.FAIL, "No element");

		}
		Thread.sleep(1000);

		// check position

		Point ActualLocation = SupplierPage.supplierSaveButton.getLocation();

		int actual_x = ActualLocation.getX();
		int actual_y = ActualLocation.getY();

		System.out.println("X axis: " + actual_x);
		System.out.println("Y axis: " + actual_y);

		Point ExpectedLocation = new Point(872, 459);

		boolean Position = true;
		testCase = extent.createTest("SUPPLIER-SAVE-BUTTON-POSITION");
		try {
			AssertJUnit.assertEquals(ActualLocation, ExpectedLocation);

		} catch (AssertionError e) {
			Position = false;
		}
		if (Position) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualLocation);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedLocation);
			testCase.log(Status.PASS, "Correct Location");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualLocation);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedLocation);
			testCase.log(Status.FAIL, "Wrong Location");
		}
		Thread.sleep(1000);

//				 check font size

		String ActualFontSize = SupplierPage.supplierSaveButton.getCssValue("font-size");
		System.out.println("Font Size: " + ActualFontSize);
		String ExpectedFontSize = "14px";

		boolean Fontsize = true;
		testCase = extent.createTest("SUPPLIER-SAVE-BUTTON-FONT-SIZE");
		try {
			AssertJUnit.assertEquals(ActualFontSize, ExpectedFontSize);

		} catch (AssertionError e) {
			Fontsize = false;
		}
		if (Fontsize) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualFontSize);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedFontSize);
			testCase.log(Status.PASS, "Correct Font Size");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualFontSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedFontSize);
			testCase.log(Status.FAIL, "Wrong Font Size");
		}
		Thread.sleep(1000);

//				 check the size 

		Dimension ActualSize = SupplierPage.supplierSaveButton.getSize();
		System.out.println("Size : " + ActualSize);
		Dimension ExpectedSize = new Dimension(30, 22);

		boolean size = true;
		testCase = extent.createTest("SUPPLIER-SAVE-BUTTON-SIZE");
		try {
			AssertJUnit.assertEquals(ActualSize, ExpectedSize);

		} catch (AssertionError e) {
			size = false;
		}
		if (size) {
			testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
			testCase.log(Status.PASS, "Correct Size");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
			testCase.log(Status.FAIL, "Wrong Size");
		}
		Thread.sleep(1000);

//		            check the enable

		boolean ActualElementEnable = SupplierPage.supplierSaveButton.isEnabled();
		boolean ExpectedElementEnable = true;

		boolean enablity = true;
		testCase = extent.createTest("SUPPLIER-SAVE-BUTTON-ENABLE");
		try {
			AssertJUnit.assertEquals(ActualElementEnable, ExpectedElementEnable);

		} catch (AssertionError e) {
			enablity = false;
		}
		if (enablity) {
			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
			testCase.log(Status.PASS, "Element enable");
		} else {
			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
			testCase.log(Status.FAIL, "Element is not enable");
		}
		Thread.sleep(1000);

//		            check the button color

		String ActualButtonColor = SupplierPage.supplierSaveButton.getCssValue("background-color");
		System.out.println("rgb :" + ActualButtonColor);

		String ExpectedButtonColor = "rgba(0, 0, 0, 0)";

		boolean buttoncolor = true;
		testCase = extent.createTest("SUPPLIER-SAVE-BUTTON-COLOR");
		try {
			AssertJUnit.assertEquals(ActualButtonColor, ExpectedButtonColor);

		} catch (AssertionError e) {
			buttoncolor = false;
		}
		if (buttoncolor) {
			testCase.log(Status.INFO, "ActualButtonColor :- " + ActualButtonColor);
			testCase.log(Status.INFO, "ExpectedButtonColor :- " + ExpectedButtonColor);
			testCase.log(Status.PASS, "Correct Button Color");
		} else {
			testCase.log(Status.INFO, "ActualButtonColor :- " + ActualButtonColor);
			testCase.log(Status.INFO, "ExpectedButtonColor :- " + ExpectedButtonColor);
			testCase.log(Status.FAIL, "Wrong Button Color");
		}
		Thread.sleep(1000);

//		            check the border color

		String ActualBorderColor = SupplierPage.supplierSaveButton.getCssValue("border-colour");
		System.out.println("rgb :" + ActualBorderColor);

		String ExpectedBorderColor = " ";

		boolean bordercolor = true;
		testCase = extent.createTest("SUPPLIER-SAVE-BUTTON-BORDER-COLOR");
		try {
			AssertJUnit.assertEquals(ActualBorderColor, ExpectedBorderColor);

		} catch (AssertionError e) {
			bordercolor = false;
		}
		if (bordercolor) {
			testCase.log(Status.INFO, "ActualBorderColor :- " + ActualBorderColor);
			testCase.log(Status.INFO, "ExpectedBorderColor :- " + ExpectedBorderColor);
			testCase.log(Status.PASS, "Correct Border Color");
		} else {
			testCase.log(Status.INFO, "ActualBorderColor :- " + ActualBorderColor);
			testCase.log(Status.INFO, "ExpectedBorderColor :- " + ExpectedBorderColor);
			testCase.log(Status.FAIL, "Wrong Border Color");
		}
		Thread.sleep(1000);

//		            check the font type 

		String ActualFontType = SupplierPage.supplierSaveButton.getCssValue("font-type");
		System.out.println("Font type: " + ActualFontType);

		String ExpectedFontType = "";

		// input[@id='sub_business_unit']

		boolean fonttype = true;
		testCase = extent.createTest("SUPPLIER-SAVE-BUTTON-FONT-TYPE");
		try {
			AssertJUnit.assertEquals(ActualFontType, ExpectedFontType);

		} catch (AssertionError e) {
			fonttype = false;
		}
		if (fonttype) {
			testCase.log(Status.INFO, "ActualFontType :- " + ActualFontType);
			testCase.log(Status.INFO, "ExpectedFontType :- " + ExpectedFontType);
			testCase.log(Status.PASS, "Correct Font Type");
		} else {
			testCase.log(Status.INFO, "ActualFontType :- " + ActualFontType);
			testCase.log(Status.INFO, "ExpectedFontType :- " + ExpectedFontType);
			testCase.log(Status.FAIL, "Wrong Font Type");
		}
		Thread.sleep(1000);

//		                    check font color

		String ActualFontColor = SupplierPage.supplierSaveButton.getCssValue("color");

		System.out.println("Font colour: " + ActualFontColor);

		String ExpectedFontColor = "rgba(255, 255, 255, 1)";
		testCase = extent.createTest("SUPPLIER-SAVE-BUTTON-FONT-COLOUR");
		try {
			AssertJUnit.assertEquals(ActualFontColor, ExpectedFontColor);
			testCase.log(Status.INFO, "ActualFontColor :- " + ActualFontColor);
			testCase.log(Status.INFO, "ExpectedFontColor :- " + ExpectedFontColor);

			testCase.log(Status.PASS, "Correct font Colour");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualFontColor :- " + ActualFontColor);
			testCase.log(Status.INFO, "ExpectedFontColor :- " + ExpectedFontColor);

			testCase.log(Status.FAIL, "wrong font Colour");
		}
		Thread.sleep(1000);

//				cursor

		String ActualActions = SupplierPage.supplierSaveButton.getCssValue("cursor");
		System.out.println("cursor :" + ActualActions);
		String ExpectedActions = "pointer";

		boolean cursor = true;
		testCase = extent.createTest("SUPPLIER-SAVE-BUTTON-CURSOR");
		try {
			AssertJUnit.assertEquals(ActualActions, ExpectedActions);

		} catch (AssertionError e) {
			cursor = false;
		}
		if (cursor) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualActions);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedActions);
			testCase.log(Status.PASS, "drop down auto");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualActions);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedActions);
			testCase.log(Status.FAIL, "drop dow not auto");
		}
		Thread.sleep(1000);

//				text spelling

		String text = SupplierPage.supplierSaveButton.getText();

		String text1 = "Save";
		boolean txt1 = true;
		testCase = extent.createTest("SUPPLIER-SAVE-BUTTON-SPELLING");

		try {
			AssertJUnit.assertEquals(text, text1);
		} catch (AssertionError e) {
			txt1 = false;
		}
		if (txt1) {
			testCase.log(Status.INFO, "ActualElement :- " + text);
			testCase.log(Status.INFO, "ExpectedElement :- " + text1);
			testCase.log(Status.INFO, "correct text");
			testCase.log(Status.PASS, "Correct ");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + text);
			testCase.log(Status.INFO, "ExpectedElement :- " + text1);
			testCase.log(Status.INFO, "wrong text");
			testCase.log(Status.FAIL, "wrong");
		}

		Thread.sleep(1000);

//				padding

		String Actualvalue = SupplierPage.supplierSaveButton.getCssValue("padding");
		System.out.println("paddingvalue :" + Actualvalue);
		String Expectedvalue = "0px";

		boolean padding = true;
		testCase = extent.createTest("SUPPLIER-SAVE-BUTTON-PADDING");
		try {
			AssertJUnit.assertEquals(Actualvalue, Expectedvalue);

		} catch (AssertionError e) {
			padding = false;
		}
		if (padding) {
			testCase.log(Status.INFO, "Actualvalue :- " + Actualvalue);
			testCase.log(Status.INFO, "Expectedvalue :- " + Expectedvalue);
			testCase.log(Status.PASS, "Correct value");
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + Actualvalue);
			testCase.log(Status.INFO, "Expectedvalue :- " + Expectedvalue);
			testCase.log(Status.FAIL, "Wrong Value");
		}
		Thread.sleep(1000);

//		  		border radius

		String Actualradius = SupplierPage.supplierSaveButton.getCssValue("border-radius");
		System.out.println("radius value :" + Actualradius);
		String Expectedradius = "0px";

		boolean radius = true;
		testCase = extent.createTest("SUPPLIER-SAVE-BUTTON-RADIUS");
		try {
			AssertJUnit.assertEquals(Actualradius, Expectedradius);

		} catch (AssertionError e) {
			radius = false;
		}
		if (radius) {
			testCase.log(Status.INFO, "Actualradius :- " + Actualradius);
			testCase.log(Status.INFO, "Expectedradius :- " + Expectedradius);
			testCase.log(Status.PASS, "Correct value");
		} else {
			testCase.log(Status.INFO, "Actualradius :- " + Actualradius);
			testCase.log(Status.INFO, "Expectedradius :- " + Expectedradius);
			testCase.log(Status.FAIL, "Wrong Value");
		}
		Thread.sleep(1000);

//				opacity

		String Actualopacity = SupplierPage.supplierSaveButton.getCssValue("opacity");
		System.out.println("opacity  :" + Actualopacity);
		String Expectedopacity = "1";

		boolean opacity = true;
		testCase = extent.createTest("SUPPLIER-SAVE-BUTTON-OPACITY");
		try {
			AssertJUnit.assertEquals(Actualopacity, Expectedopacity);

		} catch (AssertionError e) {
			opacity = false;
		}
		if (opacity) {
			testCase.log(Status.INFO, "Actualopacity :- " + Actualopacity);
			testCase.log(Status.INFO, "Expectedopacity :- " + Expectedopacity);
			testCase.log(Status.PASS, "Correct value");
		} else {
			testCase.log(Status.INFO, "Actualopacity :- " + Actualopacity);
			testCase.log(Status.INFO, "Expectedopacity :- " + Expectedopacity);
			testCase.log(Status.FAIL, "Wrong Value");
		}
		Thread.sleep(1000);

//				font weight

		String Actualfontweight = SupplierPage.supplierSaveButton.getCssValue("font-weight");
		System.out.println("fontweight  :" + Actualfontweight);
		String Expectedfontweight = "400";

		boolean fontweight = true;
		testCase = extent.createTest("SUPPLIER-SAVE-BUTTON-FONT-WEIGHT");
		try {
			AssertJUnit.assertEquals(Actualfontweight, Expectedfontweight);

		} catch (AssertionError e) {
			fontweight = false;
		}
		if (fontweight) {
			testCase.log(Status.INFO, "Actualfontweight :- " + Actualfontweight);
			testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedfontweight);
			testCase.log(Status.PASS, "Correct font weight");
		} else {
			testCase.log(Status.INFO, "Actualfontweight :- " + Actualfontweight);
			testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedfontweight);
			testCase.log(Status.FAIL, "Wrong font weight");
		}
		Thread.sleep(1000);

	}

// CHECKING LAST ADDED VALUE COMES FIRST ROW 
// -------------------------------------------------

	public static void checkLastAddvalue() throws InterruptedException {
		PageFactory.initElements(driver, SupplierPg);
		Thread.sleep(2000);
		String actualdata = SupplierPage.supplierFirstRow.getText();
		System.out.println("First row of table : " + actualdata);
		String expecteddata = supplier;
//     TestCasePrint("CHECK THE LAST ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE", expecteddata, actualdata);

		boolean last = true;
		testCase = extent.createTest("CONFIRM THE ADD SUPPLIER FUNCTION");
		try {
			AssertJUnit.assertEquals(actualdata, expecteddata);

		} catch (AssertionError e) {
			last = false;
		}
		if (last) {
			testCase.log(Status.INFO, "actualdata :- " + actualdata);
			testCase.log(Status.INFO, "expecteddata :- " + expecteddata);
			testCase.log(Status.PASS, "Correct Data");
		} else {
			testCase.log(Status.INFO, "actualdata :- " + actualdata);
			testCase.log(Status.INFO, "expecteddata :- " + expecteddata);
			testCase.log(Status.FAIL, "Wrong Data");
		}
		Thread.sleep(1000);

	}

	// CHECKING MULTIPLE VALUE ADDED
	// ------------------------------

	public static void checkMultiplevalueAdd() throws InterruptedException {
		PageFactory.initElements(driver, SupplierPg);
		Thread.sleep(2000);

		SupplierPage.firstRowSupplierCategoryBtn.click();

		Thread.sleep(2000);
		String actualdata = SupplierPage.firstRowSupplierCategoryValue.getText();
		System.out.println("Supplier Category : " + actualdata);
		String expecteddata = "Innovation\n" + "Service Supplier\n" + "RIVER SAND\n";
//	     TestCasePrint("CHECK THE LAST ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE", expecteddata, actualdata);

		boolean last = true;
		testCase = extent.createTest("CHECKING MULTIPLE CATEGORY ADDING");
		try {
			AssertJUnit.assertEquals(actualdata, expecteddata);

		} catch (AssertionError e) {
			last = false;
		}
		if (last) {
			testCase.log(Status.INFO, "actualdata :- " + actualdata);
			testCase.log(Status.INFO, "expecteddata :- " + expecteddata);
			testCase.log(Status.PASS, "Correct Data");
		} else {
			testCase.log(Status.INFO, "actualdata :- " + actualdata);
			testCase.log(Status.INFO, "expecteddata :- " + expecteddata);
			testCase.log(Status.FAIL, "Wrong Data");
		}
		Thread.sleep(1000);

	}

	// modal close

// public static void modalClose() throws InterruptedException {
//     PageFactory.initElements(driver, elem);
//     elements.adduserscancelbutton.click();
////
////     Actions action = new Actions(driver);
////     action.moveByOffset(0, 0).click().build().perform();
//     boolean AcctualAfterClick = elements.modal.isDisplayed();
//     boolean ExpectedAfterClick = true;
//     TestCasePrint("MODAL-INVISIBLE-ONCLICK-OUTSIDE", ExpectedAfterClick, AcctualAfterClick);
// }

//  SUPPLIER CANCEL BUTTON PROPERTIES
// ----------------------------------------------------

	public static void supplierCancelButtonUI() throws InterruptedException {

		// check if element visible
		testCase = extent.createTest("CHECKING THE \"SUPPLIER-CANCEL\" BUTTON PROPERTIES");
		boolean ActualElement = SupplierPage.supplierCancelButton.isDisplayed();
		boolean ExpectedElement = true;

		boolean visibility = true;
		testCase = extent.createTest("SUPPLIER-CANCEL-BUTTON-VISIBILITY");
		try {
			AssertJUnit.assertEquals(ActualElement, ExpectedElement);

		} catch (AssertionError e) {

			visibility = false;

//				        	  throw(e);
		}
		if (visibility) {
			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
			testCase.log(Status.PASS, "Correct Element");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
			testCase.log(Status.FAIL, "No element");

		}
		Thread.sleep(1000);

		// check position

		Point ActualLocation = SupplierPage.supplierCancelButton.getLocation();

		int actual_x = ActualLocation.getX();
		int actual_y = ActualLocation.getY();

		System.out.println("X axis: " + actual_x);
		System.out.println("Y axis: " + actual_y);

		Point ExpectedLocation = new Point(774, 454);

		boolean Position = true;
		testCase = extent.createTest("SUPPLIER-CANCEL-BUTTON-POSITION");
		try {
			AssertJUnit.assertEquals(ActualLocation, ExpectedLocation);

		} catch (AssertionError e) {
			Position = false;
		}
		if (Position) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualLocation);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedLocation);
			testCase.log(Status.PASS, "Correct Location");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualLocation);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedLocation);
			testCase.log(Status.FAIL, "Wrong Location");
		}
		Thread.sleep(1000);

//						 check font size

		String ActualFontSize = SupplierPage.supplierCancelButton.getCssValue("font-size");
		System.out.println("Font Size: " + ActualFontSize);
		String ExpectedFontSize = "14px";

		boolean Fontsize = true;
		testCase = extent.createTest("SUPPLIER-CANCEL-BUTTON-FONT-SIZE");
		try {
			AssertJUnit.assertEquals(ActualFontSize, ExpectedFontSize);

		} catch (AssertionError e) {
			Fontsize = false;
		}
		if (Fontsize) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualFontSize);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedFontSize);
			testCase.log(Status.PASS, "Correct Font Size");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualFontSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedFontSize);
			testCase.log(Status.FAIL, "Wrong Font Size");
		}
		Thread.sleep(1000);

//						 check the size 

		Dimension ActualSize = SupplierPage.supplierCancelButton.getSize();
		System.out.println("Size : " + ActualSize);
		Dimension ExpectedSize = new Dimension(75, 32);

		boolean size = true;
		testCase = extent.createTest("SUPPLIER-CANCEL-BUTTON-SIZE");
		try {
			AssertJUnit.assertEquals(ActualSize, ExpectedSize);

		} catch (AssertionError e) {
			size = false;
		}
		if (size) {
			testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
			testCase.log(Status.PASS, "Correct Size");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
			testCase.log(Status.FAIL, "Wrong Size");
		}
		Thread.sleep(1000);

//				            check the enable

		boolean ActualElementEnable = SupplierPage.supplierCancelButton.isEnabled();
		boolean ExpectedElementEnable = true;

		boolean enablity = true;
		testCase = extent.createTest("SUPPLIER-CANCEL-BUTTON-ENABLE");
		try {
			AssertJUnit.assertEquals(ActualElementEnable, ExpectedElementEnable);

		} catch (AssertionError e) {
			enablity = false;
		}
		if (enablity) {
			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
			testCase.log(Status.PASS, "Element enable");
		} else {
			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
			testCase.log(Status.FAIL, "Element is not enable");
		}
		Thread.sleep(1000);

//				            check the button color

		String ActualButtonColor = SupplierPage.supplierCancelButton.getCssValue("background-color");
		System.out.println("rgb :" + ActualButtonColor);

		String ExpectedButtonColor = "rgba(255, 255, 255, 1)";

		boolean buttoncolor = true;
		testCase = extent.createTest("SUPPLIER-CANCEL-BUTTON-COLOR");
		try {
			AssertJUnit.assertEquals(ActualButtonColor, ExpectedButtonColor);

		} catch (AssertionError e) {
			buttoncolor = false;
		}
		if (buttoncolor) {
			testCase.log(Status.INFO, "ActualButtonColor :- " + ActualButtonColor);
			testCase.log(Status.INFO, "ExpectedButtonColor :- " + ExpectedButtonColor);
			testCase.log(Status.PASS, "Correct Button Color");
		} else {
			testCase.log(Status.INFO, "ActualButtonColor :- " + ActualButtonColor);
			testCase.log(Status.INFO, "ExpectedButtonColor :- " + ExpectedButtonColor);
			testCase.log(Status.FAIL, "Wrong Button Color");
		}
		Thread.sleep(1000);

//				            check the border color

		String ActualBorderColor = SupplierPage.supplierCancelButton.getCssValue("border-colour");
		System.out.println("rgb :" + ActualBorderColor);

		String ExpectedBorderColor = " ";

		boolean bordercolor = true;
		testCase = extent.createTest("SUPPLIER-CANCEL-BUTTON-BORDER-COLOR");
		try {
			AssertJUnit.assertEquals(ActualBorderColor, ExpectedBorderColor);

		} catch (AssertionError e) {
			bordercolor = false;
		}
		if (bordercolor) {
			testCase.log(Status.INFO, "ActualBorderColor :- " + ActualBorderColor);
			testCase.log(Status.INFO, "ExpectedBorderColor :- " + ExpectedBorderColor);
			testCase.log(Status.PASS, "Correct Border Color");
		} else {
			testCase.log(Status.INFO, "ActualBorderColor :- " + ActualBorderColor);
			testCase.log(Status.INFO, "ExpectedBorderColor :- " + ExpectedBorderColor);
			testCase.log(Status.FAIL, "Wrong Border Color");
		}
		Thread.sleep(1000);

//				            check the font type 

		String ActualFontType = SupplierPage.supplierCancelButton.getCssValue("font-type");
		System.out.println("Font type: " + ActualFontType);

		String ExpectedFontType = "";

		// input[@id='sub_business_unit']

		boolean fonttype = true;
		testCase = extent.createTest("SUPPLIER-CANCEL-BUTTON-FONT-TYPE");
		try {
			AssertJUnit.assertEquals(ActualFontType, ExpectedFontType);

		} catch (AssertionError e) {
			fonttype = false;
		}
		if (fonttype) {
			testCase.log(Status.INFO, "ActualFontType :- " + ActualFontType);
			testCase.log(Status.INFO, "ExpectedFontType :- " + ExpectedFontType);
			testCase.log(Status.PASS, "Correct Font Type");
		} else {
			testCase.log(Status.INFO, "ActualFontType :- " + ActualFontType);
			testCase.log(Status.INFO, "ExpectedFontType :- " + ExpectedFontType);
			testCase.log(Status.FAIL, "Wrong Font Type");
		}
		Thread.sleep(1000);

//				                    check font color

		String ActualFontColor = SupplierPage.supplierCancelButton.getCssValue("color");

		System.out.println("Font colour: " + ActualFontColor);

		String ExpectedFontColor = "rgba(0, 0, 0, 0.85)";
		testCase = extent.createTest("SUPPLIER-CANCEL-BUTTON-FONT-COLOUR");
		try {
			AssertJUnit.assertEquals(ActualFontColor, ExpectedFontColor);
			testCase.log(Status.INFO, "ActualFontColor :- " + ActualFontColor);
			testCase.log(Status.INFO, "ExpectedFontColor :- " + ExpectedFontColor);

			testCase.log(Status.PASS, "Correct font Colour");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualFontColor :- " + ActualFontColor);
			testCase.log(Status.INFO, "ExpectedFontColor :- " + ExpectedFontColor);

			testCase.log(Status.FAIL, "wrong font Colour");
		}
		Thread.sleep(1000);

//						cursor

		String ActualActions = SupplierPage.supplierCancelButton.getCssValue("cursor");
		System.out.println("cursor :" + ActualActions);
		String ExpectedActions = "pointer";

		boolean cursor = true;
		testCase = extent.createTest("SUPPLIER-CANCEL-BUTTON-CURSOR");
		try {
			AssertJUnit.assertEquals(ActualActions, ExpectedActions);

		} catch (AssertionError e) {
			cursor = false;
		}
		if (cursor) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualActions);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedActions);
			testCase.log(Status.PASS, "drop down auto");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualActions);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedActions);
			testCase.log(Status.FAIL, "drop dow not auto");
		}
		Thread.sleep(1000);

//						text spelling

		String text = SupplierPage.supplierCancelButton.getText();

		String text1 = "Cancel";
		boolean txt1 = true;
		testCase = extent.createTest("SUPPLIER-CANCEL-BUTTON-SPELLING");

		try {
			AssertJUnit.assertEquals(text, text1);
		} catch (AssertionError e) {
			txt1 = false;
		}
		if (txt1) {
			testCase.log(Status.INFO, "ActualElement :- " + text);
			testCase.log(Status.INFO, "ExpectedElement :- " + text1);
			testCase.log(Status.INFO, "correct text");
			testCase.log(Status.PASS, "Correct ");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + text);
			testCase.log(Status.INFO, "ExpectedElement :- " + text1);
			testCase.log(Status.INFO, "wrong text");
			testCase.log(Status.FAIL, "wrong");
		}

		Thread.sleep(1000);

//						padding

		String Actualvalue = SupplierPage.supplierCancelButton.getCssValue("padding");
		System.out.println("paddingvalue :" + Actualvalue);
		String Expectedvalue = "4px 15px";

		boolean padding = true;
		testCase = extent.createTest("SUPPLIER-CANCEL-BUTTON-PADDING");
		try {
			AssertJUnit.assertEquals(Actualvalue, Expectedvalue);

		} catch (AssertionError e) {
			padding = false;
		}
		if (padding) {
			testCase.log(Status.INFO, "Actualvalue :- " + Actualvalue);
			testCase.log(Status.INFO, "Expectedvalue :- " + Expectedvalue);
			testCase.log(Status.PASS, "Correct value");
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + Actualvalue);
			testCase.log(Status.INFO, "Expectedvalue :- " + Expectedvalue);
			testCase.log(Status.FAIL, "Wrong Value");
		}
		Thread.sleep(1000);

//				  		border radius

		String Actualradius = SupplierPage.supplierCancelButton.getCssValue("border-radius");
		System.out.println("radius value :" + Actualradius);
		String Expectedradius = "2px";

		testCase = extent.createTest("SUPPLIER-CANCEL-BUTTON-RADIUS");
		try {
			AssertJUnit.assertEquals(Actualradius, Expectedradius);

		} catch (AssertionError e) {
			padding = false;
		}
		if (padding) {
			testCase.log(Status.INFO, "Actualradius :- " + Actualradius);
			testCase.log(Status.INFO, "Expectedradius :- " + Expectedradius);
			testCase.log(Status.PASS, "Correct value");
		} else {
			testCase.log(Status.INFO, "Actualradius :- " + Actualradius);
			testCase.log(Status.INFO, "Expectedradius :- " + Expectedradius);
			testCase.log(Status.FAIL, "Wrong Value");
		}
		Thread.sleep(1000);

//						opacity

		String Actualopacity = SupplierPage.supplierCancelButton.getCssValue("opacity");
		System.out.println("opacity  :" + Actualopacity);
		String Expectedopacity = "1";

		boolean opacity = true;
		testCase = extent.createTest("SUPPLIER-CANCEL-BUTTON-OPACITY");
		try {
			AssertJUnit.assertEquals(Actualopacity, Expectedopacity);

		} catch (AssertionError e) {
			opacity = false;
		}
		if (opacity) {
			testCase.log(Status.INFO, "Actualopacity :- " + Actualopacity);
			testCase.log(Status.INFO, "Expectedopacity :- " + Expectedopacity);
			testCase.log(Status.PASS, "Correct value");
		} else {
			testCase.log(Status.INFO, "Actualopacity :- " + Actualopacity);
			testCase.log(Status.INFO, "Expectedopacity :- " + Expectedopacity);
			testCase.log(Status.FAIL, "Wrong Value");
		}
		Thread.sleep(1000);

//						font weight

		String Actualfontweight = SupplierPage.supplierCancelButton.getCssValue("font-weight");
		System.out.println("fontweight  :" + Actualfontweight);
		String Expectedfontweight = "400";

		boolean fontweight = true;
		testCase = extent.createTest("SUPPLIER-CANCEL-BUTTON-FONT-WEIGHT");
		try {
			AssertJUnit.assertEquals(Actualfontweight, Expectedfontweight);

		} catch (AssertionError e) {
			fontweight = false;
		}
		if (fontweight) {
			testCase.log(Status.INFO, "Actualfontweight :- " + Actualfontweight);
			testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedfontweight);
			testCase.log(Status.PASS, "Correct font weight");
		} else {
			testCase.log(Status.INFO, "Actualfontweight :- " + Actualfontweight);
			testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedfontweight);
			testCase.log(Status.FAIL, "Wrong font weight");
		}
		Thread.sleep(1000);

	}

	public static void modalClose() throws InterruptedException {
		PageFactory.initElements(driver, SupplierPg);

		boolean AcctualAfterClick = SupplierPage.supplierModal.isDisplayed();

		boolean ExpectedAfterClick = false;

		testCase = extent.createTest("SUPPLIER MODAL CLOSING");
		try {
			AssertJUnit.assertEquals(AcctualAfterClick, ExpectedAfterClick);

		} catch (AssertionError e) {
			ExpectedAfterClick = true;
		}
		if (ExpectedAfterClick) {
			testCase.log(Status.INFO, "AcctualAfterClick :- " + AcctualAfterClick);
			testCase.log(Status.INFO, "ExpectedAfterClick :- " + ExpectedAfterClick);
			testCase.log(Status.PASS, "Modal is closed");
		} else {
			testCase.log(Status.INFO, "AcctualAfterClick :- " + AcctualAfterClick);
			testCase.log(Status.INFO, "ExpectedAfterClick :- " + ExpectedAfterClick);
			testCase.log(Status.FAIL, "Modal is not closed");
		}
		Thread.sleep(1000);

	}

//	DELETE SUPPLIER MODAL CLOSING
//	----------------------------------

	public static void deleteModalClose() throws InterruptedException {

		PageFactory.initElements(driver, SupplierPg);

		boolean ActualAfterClick = SupplierPage.deleteSupplierModal.isDisplayed();

		boolean ExpectedAfterClick = false;

		testCase = extent.createTest("DELETE SUPPLIER MODAL CLOSING");
		try {
			AssertJUnit.assertEquals(ActualAfterClick, ExpectedAfterClick);

		} catch (AssertionError e) {
			ExpectedAfterClick = true;
		}
		if (ExpectedAfterClick) {
			testCase.log(Status.INFO, "ActualAfterClick :- " + ActualAfterClick);
			testCase.log(Status.INFO, "ExpectedAfterClick :- " + ExpectedAfterClick);
			testCase.log(Status.PASS, "Modal is closed");
		} else {
			testCase.log(Status.INFO, "ActualAfterClick :- " + ActualAfterClick);
			testCase.log(Status.INFO, "ExpectedAfterClick :- " + ExpectedAfterClick);
			testCase.log(Status.FAIL, "Modal is not closed");
		}
		Thread.sleep(1000);

	}

//    VERIFYING THE SUPPLIER FORM WHEN BEFORE EDIT THE DATA
//	---------------------------------------------------------

	public static void verifySupplierForm() throws InterruptedException {

//		supplier verify

		String actualSupplier = driver.findElement(By.xpath("//td[text()='Pro Mark Holdings Private Limited']"))
				.getText();
		String expectedSupplier = SupplierPage.supplierField.getAttribute("value");
		System.out.println("fgyhdfdrfsd");

		boolean supplier = true;
		testCase = extent.createTest("CHECKING THE SUPPLIER ELEMENT");
		try {
			AssertJUnit.assertEquals(actualSupplier, expectedSupplier);

		} catch (AssertionError e) {
			supplier = false;
		}
		if (supplier) {
			testCase.log(Status.INFO, "actualSupplier :- " + actualSupplier);
			testCase.log(Status.INFO, "expectedSupplier :- " + expectedSupplier);
			testCase.log(Status.PASS, "Correct element");
		} else {
			testCase.log(Status.INFO, "actualSupplier :- " + actualSupplier);
			testCase.log(Status.INFO, "expectedSupplier :- " + expectedSupplier);
			testCase.log(Status.FAIL, "Wrong element");
		}
		Thread.sleep(1000);

//		Plant Verify

		String actualPlant = driver
				.findElement(By.xpath("//td[text()='Pro Mark Holdings Private Limited']//following-sibling::td[1]"))
				.getText();
		String expectedPlant = SupplierPage.plantField.getText();

		boolean plant = true;
		testCase = extent.createTest("CHECKING THE PLANT ELEMENT");
		try {
			AssertJUnit.assertEquals(actualPlant, expectedPlant);

		} catch (AssertionError e) {
			plant = false;
		}
		if (plant) {
			testCase.log(Status.INFO, "actualPlant :- " + actualPlant);
			testCase.log(Status.INFO, "expectedPlant :- " + expectedPlant);
			testCase.log(Status.PASS, "Correct element");
		} else {
			testCase.log(Status.INFO, "actualPlant :- " + actualPlant);
			testCase.log(Status.INFO, "expectedPlant :- " + expectedPlant);
			testCase.log(Status.FAIL, "Wrong element");
		}
		Thread.sleep(1000);

//		Verify email

		String actualEmail = driver
				.findElement(By.xpath("//td[text()='Pro Mark Holdings Private Limited']//following-sibling::td[2]"))
				.getText();
		String expectedEmail = SupplierPage.emailField.getAttribute("value");

		boolean email = true;
		testCase = extent.createTest("CHECKING THE EMAIL ELEMENT");
		try {
			AssertJUnit.assertEquals(actualEmail, expectedEmail);

		} catch (AssertionError e) {
			email = false;
		}
		if (email) {
			testCase.log(Status.INFO, "actualEmail :- " + actualEmail);
			testCase.log(Status.INFO, "expectedEmail :- " + expectedEmail);
			testCase.log(Status.PASS, "Correct element");
		} else {
			testCase.log(Status.INFO, "actualEmail :- " + actualEmail);
			testCase.log(Status.INFO, "expectedEmail :- " + expectedEmail);
			testCase.log(Status.FAIL, "Wrong element");
		}
		Thread.sleep(1000);

//		verify contactNo

		String actualContactNo = driver
				.findElement(By.xpath("//td[text()='Pro Mark Holdings Private Limited']//following-sibling::td[3]"))
				.getText();
		String expectedContactNo = SupplierPage.contactNoField.getAttribute("value");

		boolean contact = true;
		testCase = extent.createTest("CHECKING THE CONTACT-NO ELEMENT");
		try {
			AssertJUnit.assertEquals(actualContactNo, expectedContactNo);

		} catch (AssertionError e) {
			contact = false;
		}
		if (contact) {
			testCase.log(Status.INFO, "actualContactNo :- " + actualContactNo);
			testCase.log(Status.INFO, "expectedContactNo :- " + expectedContactNo);
			testCase.log(Status.PASS, "Correct element");
		} else {
			testCase.log(Status.INFO, "actualContactNo :- " + actualContactNo);
			testCase.log(Status.INFO, "expectedContactNo :- " + expectedContactNo);
			testCase.log(Status.FAIL, "Wrong element");
		}
		Thread.sleep(1000);

//		verify address

		String actualAddress = driver
				.findElement(By.xpath("//td[text()='Pro Mark Holdings Private Limited']//following-sibling::td[4]"))
				.getText();
		String expectedAddress = SupplierPage.addressField.getAttribute("value");

		boolean address = true;
		testCase = extent.createTest("CHECKING THE ADDRESS ELEMENT");
		try {
			AssertJUnit.assertEquals(actualAddress, expectedAddress);

		} catch (AssertionError e) {
			address = false;
		}
		if (address) {
			testCase.log(Status.INFO, "actualAddress :- " + actualAddress);
			testCase.log(Status.INFO, "expectedAddress :- " + expectedAddress);
			testCase.log(Status.PASS, "Correct element");
		} else {
			testCase.log(Status.INFO, "actualAddress :- " + actualAddress);
			testCase.log(Status.INFO, "expectedAddress :- " + expectedAddress);
			testCase.log(Status.FAIL, "Wrong element");
		}
		Thread.sleep(1000);

	}

//	$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$	

//		Edit value in supplier form 
//		--------------------------------------------------

	public static void supplierEdit() throws InterruptedException {

		PageFactory.initElements(driver, SupplierPg);

//		Thread.sleep(500);
//		elements.supplierField.click();
//		elements.supplierField.sendKeys("supplierone");
//
//		Thread.sleep(500);
//		elements.contactNoField.click();
//		elements.contactNoField.sendKeys("0770781234");
//
		Thread.sleep(500);
		SupplierPage.emailField.click();

		SupplierPage.emailField.sendKeys(Keys.CONTROL + "a");
		SupplierPage.emailField.sendKeys(Keys.DELETE);

		Thread.sleep(500);
		SupplierPage.emailField.sendKeys(newemail);

//		Thread.sleep(500);
//		elements.addressField.click();
//		elements.addressField.sendKeys("jaffna");

	}

//	Edit Supplier Value After Depend
//	------------------------------------

	public static void supplierEditAfterDepend() throws InterruptedException {

		PageFactory.initElements(driver, SupplierPg);

		boolean nextBtn = SupplierPage.NextPageBtn.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_third;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);

			}
			boolean isExist = list.contains(email);
			Thread.sleep(1000);
			nextBtn = SupplierPage.NextPageBtn.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				SupplierPage.NextPageBtn.click();
				Thread.sleep(2000);
			} else
				break;

		}

		Thread.sleep(3000);
		try {
			if (driver.findElement(By.xpath(
					"//td[text()='" + email + "']//following-sibling::td[5]//span[@class='anticon anticon-edit']"))
					.isDisplayed()) {

				testCase = extent.createTest("Edit Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver.findElement(By.xpath(
						"//td[text()='" + email + "']//following-sibling::td[5]//span[@class='anticon anticon-edit']"))
						.isEnabled()) {
					testCase = extent.createTest("Edit Icon Enable");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='" + email
								+ "']//following-sibling::td[5]//span[@class='anticon anticon-edit']")).click();

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

		Thread.sleep(500);
		SupplierPage.emailField.click();

		SupplierPage.emailField.sendKeys(Keys.CONTROL + "a");
		SupplierPage.emailField.sendKeys(Keys.DELETE);

		Thread.sleep(500);
		SupplierPage.emailField.sendKeys(newemail);

//		Thread.sleep(500);
//		elements.addressField.click();
//		elements.addressField.sendKeys("jaffna");

	}

	public static void verifyDependedSupplierEditFunction() throws InterruptedException {

		PageFactory.initElements(driver, SupplierPg);
		Thread.sleep(2000);
		String actualdata = SupplierPage.supplierFullRow.getText();
		System.out.println("First row of table : " + actualdata);
		String expecteddata = "TOKYO SUPER AGGREGATE LTD RMC Aladeniya Plant aggregates@tokyocement.lk 0112536556 Thelkekuna Mukulana, Indoamulla, Dompe.";
//     TestCasePrint("CHECK THE LAST ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE", expecteddata, actualdata);

		boolean last = true;
		testCase = extent.createTest("EDITED DATA COMES FIRST ROW");
		try {
			AssertJUnit.assertEquals(actualdata, expecteddata);

		} catch (AssertionError e) {
			last = false;
		}
		if (last) {
			testCase.log(Status.INFO, "actualdata :- " + actualdata);
			testCase.log(Status.INFO, "expecteddata :- " + expecteddata);
			testCase.log(Status.PASS, "Correct Data");
		} else {
			testCase.log(Status.INFO, "actualdata :- " + actualdata);
			testCase.log(Status.INFO, "expecteddata :- " + expecteddata);
			testCase.log(Status.FAIL, "Wrong Data");
		}
		Thread.sleep(1000);

	}

	public static void verifySupplierEditFunction() throws InterruptedException {

		PageFactory.initElements(driver, SupplierPg);
		Thread.sleep(2000);
		String actualdata = SupplierPage.firstRowSupplierEmail.getText();
		System.out.println("First row of table : " + actualdata);
		String expecteddata = newemail;
//     TestCasePrint("CHECK THE LAST ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE", expecteddata, actualdata);

		boolean last = true;
		testCase = extent.createTest("EDITED DATA COMES FIRST ROW");
		try {
			AssertJUnit.assertEquals(actualdata, expecteddata);

		} catch (AssertionError e) {
			last = false;
		}
		if (last) {
			testCase.log(Status.INFO, "actualdata :- " + actualdata);
			testCase.log(Status.INFO, "expecteddata :- " + expecteddata);
			testCase.log(Status.PASS, "Correct Data");
		} else {
			testCase.log(Status.INFO, "actualdata :- " + actualdata);
			testCase.log(Status.INFO, "expecteddata :- " + expecteddata);
			testCase.log(Status.FAIL, "Wrong Data");
		}
		Thread.sleep(1000);

	}

//	SUPPLIER PAGINATION
//	------------------------------------

	public static void supplierDefaultIndexPage() throws InterruptedException {
		try {
			new SupplierPage();

			// Default Index Page
			testCase = extent.createTest("SUPPLIER-PAGINATION-FUNCTIONALITY");
			Thread.sleep(2000);
			boolean ActualDefaultPageIndex = SupplierPage.supplierFirstPage.isDisplayed();
			boolean ExpectedDefaultPageIndex = true;
			testCase = extent.createTest("STEP-01 Checking Default Index Page");
			try {
				Assert.assertEquals(ActualDefaultPageIndex, ExpectedDefaultPageIndex);
				testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualDefaultPageIndex);
				testCase.log(Status.INFO, "Expected Default Index Page :- " + ExpectedDefaultPageIndex);
				testCase.log(Status.PASS, "Correct Default Index Page");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualDefaultPageIndex);
				testCase.log(Status.INFO, "Expected Default Index Page:- " + ExpectedDefaultPageIndex);
				testCase.log(Status.FAIL, "Wrong Default Index Page");

			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("STEP-01 Checking Default Index Page Failed because of no Element");
		}
	}

	public static void supplierRefreshDefaultPage() throws InterruptedException {
		try {
			new SupplierPage();

			SupplierPage.NextPageBtn.click();
			// Thread.sleep(20000);
			driver.navigate().refresh();
			Thread.sleep(2000);
			boolean ActualDefaultPageIndex1 = SupplierPage.supplierFirstPage.isDisplayed();
			boolean ExpectedDefaultPageIndex1 = true;
			testCase = extent.createTest("STEP-02 Checking Default Index Page after Refresh");
			try {
				Assert.assertEquals(ActualDefaultPageIndex1, ExpectedDefaultPageIndex1);
				testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualDefaultPageIndex1);
				testCase.log(Status.INFO, "Expected Default Index Page :- " + ExpectedDefaultPageIndex1);
				testCase.log(Status.PASS, "Correct Default Index Page");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualDefaultPageIndex1);
				testCase.log(Status.INFO, "Expected Default Index Page:- " + ExpectedDefaultPageIndex1);
				testCase.log(Status.FAIL, "Wrong Default Index Page");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent
					.createTest("STEP-02 Checking Default Index Page after Refresh is Failed because of no element");
		}
	}

//		Page Redirect to the next page 

	public static void supplierPageRedrict() throws InterruptedException {
		try {
			new SupplierPage();
			SupplierPage.NextPageBtn.click();
			Thread.sleep(2000);
			boolean ActualSecoundPageIndex = SupplierPage.supplierSecoundPage.isDisplayed();
			boolean ExpectedSecoundPageIndex = true;
			testCase = extent.createTest(" STEP-03 Checking Page Redriect to the next page");
			try {
				Assert.assertEquals(ActualSecoundPageIndex, ExpectedSecoundPageIndex);
				testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualSecoundPageIndex);
				testCase.log(Status.INFO, "Expected Default Index Page :- " + ExpectedSecoundPageIndex);
				testCase.log(Status.PASS, "Correct Default Index Page");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualSecoundPageIndex);
				testCase.log(Status.INFO, "Expected Default Index Page:- " + ExpectedSecoundPageIndex);
				testCase.log(Status.FAIL, "Wrong Default Index Page");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent
					.createTest(" STEP-03 Checking Page Redriect to the next page is Failed because of no element");
		}
	}

//		Previous Button Displayed

	public static void supplierPreButtonDispaly() throws InterruptedException {
		try {
			new SupplierPage();
			boolean ActualVisiblePreviousButton = SupplierPage.PreviousPageBtn.isDisplayed();
			boolean ExpectedVisiblePreviousButton = true;
			testCase = extent.createTest("STEP-04 Checking Previous Button Dispaly");
			try {
				Assert.assertEquals(ActualVisiblePreviousButton, ExpectedVisiblePreviousButton);
				testCase.log(Status.INFO, "ActualElement :- " + ActualVisiblePreviousButton);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisiblePreviousButton);
				testCase.log(Status.INFO, "Element Available");
				testCase.log(Status.PASS, "Correct element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualElement :- " + ActualVisiblePreviousButton);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisiblePreviousButton);
				testCase.log(Status.INFO, "Element not available");
				testCase.log(Status.FAIL, "Not Visible Element");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("STEP-04 Checking Previous Button Dispaly is failed because of no element");
		}
	}

//		Next Button Displayed

	public static void supplierNextButtonDispaly() throws InterruptedException {
		try {
			new SupplierPage();
			boolean ActualVisibleNextButton = SupplierPage.NextPageBtn.isDisplayed();
			boolean ExpectedVisibleNextButton = true;
			testCase = extent.createTest("STEP-05 CHecking Next Button Dispaly");
			try {
				Assert.assertEquals(ActualVisibleNextButton, ExpectedVisibleNextButton);
				testCase.log(Status.INFO, "ActualElement :- " + ActualVisibleNextButton);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisibleNextButton);
				testCase.log(Status.INFO, "Element Available");
				testCase.log(Status.PASS, "Correct element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualElement :- " + ActualVisibleNextButton);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisibleNextButton);
				testCase.log(Status.INFO, "Element not available");
				testCase.log(Status.FAIL, "Not Visible Element");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("STEP-05 CHecking Next Button Dispaly is failed because of no element");
		}
	}

//	Next Button Enable

	public static void supplierNextButtonEanble() throws InterruptedException {
		try {
			boolean ActualNextBtnEnable = SupplierPage.NextPageBtn.isEnabled();
			boolean ExpectedNextBtnEnable = true;
			testCase = extent.createTest("STEP-06 Checking Next Button Enable");
			try {
				Assert.assertEquals(ActualNextBtnEnable, ExpectedNextBtnEnable);
				testCase.log(Status.INFO, "ActualElement :- " + ActualNextBtnEnable);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedNextBtnEnable);
				testCase.log(Status.PASS, "Enable element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualElement :- " + ActualNextBtnEnable);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedNextBtnEnable);
				testCase.log(Status.FAIL, "Not Enable Element");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("STEP-06 Checking Next Button Enable is failed because of no element");
		}
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);

	}

//	Before move to 2nd page, previous button disable

	public static void supplierSecPagepreButDisable() throws InterruptedException {
		try {
			Thread.sleep(2000);
			String ActualPreviousBtnDisable = SupplierPage.PreviousPageBtn.getAttribute("disabled");
			String ExpectedPreviousBtnDisable = "true";
			testCase = extent.createTest("STEP-07 Checking Before navigate to 2 Page Previous Button is Disabled");
			try {
				Assert.assertEquals(ActualPreviousBtnDisable, ExpectedPreviousBtnDisable);
				testCase.log(Status.INFO, "ActualElement :- " + ActualPreviousBtnDisable);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedPreviousBtnDisable);
				testCase.log(Status.PASS, "Enable element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualElement :- " + ActualPreviousBtnDisable);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedPreviousBtnDisable);
				testCase.log(Status.FAIL, "Not Enable Element");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest(
					"STEP-07 Checking Before navigate to 2 Page Previous Button is Disabledc is failed because of no element");
		}

	}

//		After move to 2nd page, previous button Enable

	public static void supplierAfterMovetoSecPagepreButEnable() throws InterruptedException {
		try {
			SupplierPage.NextPageBtn.click();
			Thread.sleep(2000);
			boolean ActualPreviousBtnEnable = SupplierPage.PreviousPageBtn.isEnabled();
			boolean ExpectedPreviousBtnEnable = true;
			testCase = extent.createTest("STEP-08 Checking After Navigate to the Seconfd Page Previous button Enabled");
			try {
				Assert.assertEquals(ActualPreviousBtnEnable, ExpectedPreviousBtnEnable);
				testCase.log(Status.INFO, "ActualElement :- " + ActualPreviousBtnEnable);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedPreviousBtnEnable);
				testCase.log(Status.PASS, "Enable element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualElement :- " + ActualPreviousBtnEnable);
				testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedPreviousBtnEnable);
				testCase.log(Status.FAIL, "Not Enable Element");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest(
					"STEP-08 Checking After Navigate to the Seconfd Page Previous button Enabled is failed because of no element");
		}

		driver.navigate().refresh();
		Thread.sleep(2000);
	}

//	@Test(priority = 10)
//	public static void TotalPages() throws InterruptedException {
//
//		String DataCountText = elements.paginationCount.getText();
//		System.out.println(DataCountText);
//		Pattern pattern = Pattern.compile("\\d+ of (\\d+)");
//		Matcher matcher = pattern.matcher(DataCountText);
//		if (matcher.find()) {
//			String pageCount = matcher.group(1);
//			System.out.println("Total pages: " + pageCount);
//
//			int Expected = 3;
//			testCase = extent.createTest("STEP-9 Checking Total Page for 10 Data per page");
//			try {
//				Assert.assertEquals(pageCount, Expected);
//				testCase.log(Status.INFO, "ActualElement :- " + pageCount);
//				testCase.log(Status.INFO, "ExpectedElement :- " + Expected);
//				testCase.log(Status.PASS, "Enable element");
//			} catch (AssertionError e) {
//				testCase.log(Status.INFO, "ActualElement :- " + pageCount);
//				testCase.log(Status.INFO, "ExpectedElement :- " + Expected);
//				testCase.log(Status.FAIL, "Not Enable Element");
//			}
//		}
////	//testCase = extent.createTest("STEP-09 -PAGINATION-TOTAL-COUNT:" + ActualTotalPage );
//	}

	public static void supplierPages() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(2000);

		// Thread.sleep(2000);
		int ActualTotalPage = 1;
		boolean Enablity = SupplierPage.NextPageBtn.isEnabled();
		while (Enablity) {
			Thread.sleep(1000);
			SupplierPage.NextPageBtn.click();
			ActualTotalPage = ActualTotalPage + 1;
			Enablity = SupplierPage.NextPageBtn.isEnabled();
		}
		System.out.println(ActualTotalPage);
		Thread.sleep(2000);

		if (SupplierPage.currentPaginationOption.getText().contentEquals("10 / page")) {
			int ExpectedTotalPage = 3;
			testCase = extent.createTest("STEP-09 Checking Total Page for 10 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + SupplierPage.currentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + SupplierPage.currentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (SupplierPage.currentPaginationOption.getText().contentEquals("20 / page")) {
			int ExpectedTotalPage = 2;
			testCase = extent.createTest("STEP-10 Checking Total Page for 20 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + SupplierPage.currentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + SupplierPage.currentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (SupplierPage.currentPaginationOption.getText().contentEquals("30 / page")) {
			int ExpectedTotalPage = 1;
			testCase = extent.createTest("STEP-11 Checking Total Page for 30 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + SupplierPage.currentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + SupplierPage.currentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (SupplierPage.currentPaginationOption.getText().contentEquals("100 / page")) {
			int ExpectedTotalPage = 1;
			testCase = extent.createTest("STEP-12 Checking Total Page for 100 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + SupplierPage.currentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + SupplierPage.currentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}

		}

		driver.navigate().refresh();
		Thread.sleep(2000);

	}

	public static void addPaginationSupplierFunction() throws InterruptedException {
		PageFactory.initElements(driver, SupplierPg);

//			change the pagination 

		try {
//				elements elem = new elements();
			SupplierPage.NextPageBtn.click();
			Thread.sleep(2000);
			boolean ActualSecoundPageIndex = SupplierPage.supplierSecoundPage.isDisplayed();
			boolean ExpectedSecoundPageIndex = true;
			testCase = extent.createTest(" Checking Page Redriect to the next page");
			try {
				Assert.assertEquals(ActualSecoundPageIndex, ExpectedSecoundPageIndex);
				testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualSecoundPageIndex);
				testCase.log(Status.INFO, "Expected Default Index Page :- " + ExpectedSecoundPageIndex);
				testCase.log(Status.PASS, "Correct Default Index Page");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualSecoundPageIndex);
				testCase.log(Status.INFO, "Expected Default Index Page:- " + ExpectedSecoundPageIndex);
				testCase.log(Status.FAIL, "Wrong Default Index Page");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest(" Checking Page Redriect to the next page is Failed because of no element");
		}

	}

//  Validation

	public static void supplierValidations() throws IOException, InterruptedException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Supplier");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0065");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Supplier", "TC-SUP-0065");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(1).getBooleanCellValue();
			String SupplierCategory = (String) row.getCell(2).getStringCellValue();
			String Supplier = (String) row.getCell(3).getStringCellValue();
			String Plant = (String) row.getCell(4).getStringCellValue();
			String Validation1 = (String) row.getCell(5).getStringCellValue();
			String Validation2 = (String) row.getCell(6).getStringCellValue();
			String Validation3 = (String) row.getCell(7).getStringCellValue();
			String Message = (String) row.getCell(8).getStringCellValue();

			if (check) {
				SupplierPage.addSupplierButton.click();
				Thread.sleep(1000);

				SupplierPage.supplierCategoryField.click();
				Thread.sleep(3000);
				for (int j = 1; j <= 2; j++) {
					WebElement name = driver
							.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[" + j + "]"));
					String dropcontent = name.getText();
					if (dropcontent.contentEquals(SupplierCategory)) {
						name.click();
						pass = true;
					} else if (dropcontent.isEmpty()) {
						pass = true;
					}
				}

				SupplierPage.supplierField.sendKeys(Supplier);

				SupplierPage.plantField.click();
//				SupplierPage.plantField.sendKeys(Plant);
				Thread.sleep(3000);
				for (int j = 1; j <= 2; j++) {

					WebElement name1 = driver
							.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[" + j + "]"));
					String dropcontent1 = name1.getText();
					if (dropcontent1.contentEquals(Plant)) {
						Thread.sleep(2000);

						name1.click();
						pass = true;
					} else if (dropcontent1.isEmpty()) {
						pass = true;
					}
				}

				Thread.sleep(2000);

//				SupplierPage.descriptiontextbox.sendKeys(Description);

				SupplierPage.supplierSaveButton.click();

				Thread.sleep(2000);

				try {
					if (SupplierPage.SupplierCategoryValidation.isDisplayed()) {
						String ActualValidation1 = SupplierPage.SupplierCategoryValidation.getText();
						String ExpectedValidation1 = Validation1;
						testCase = extent.createTest(Message);
						try {
							Assert.assertEquals(ActualValidation1, ExpectedValidation1);
							testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation1);
							testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation1);
							testCase.log(Status.PASS, "Pass " + Message + "Script");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation1);
							testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation1);
							testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("Low Priority");
							testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("High Priority");
						}

					} else {
						testCase = extent.createTest("SUPPLIER CATEGORY DROPDOWN NOT VISIBLE");
						testCase.log(Status.INFO, "Dropdown Not Displayed");
						testCase.log(Status.FAIL, "Dropdown Not Displayed");
					}
				} catch (NoSuchElementException e) {

				}

				try {
					if (SupplierPage.SupplierValidation.isDisplayed()) {

						String ActualValidation2 = SupplierPage.SupplierValidation.getText();
						String ExpectedValidation2 = Validation2;
						testCase = extent.createTest(Message);
						try {
							Assert.assertEquals(ActualValidation2, ExpectedValidation2);
							testCase.log(Status.INFO,
									"Actual Validation :- " + SupplierPage.SupplierValidation.getText());
							testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation2);
							testCase.log(Status.PASS, "Pass " + Message + "Script");
						} catch (AssertionError e) {
							testCase.log(Status.INFO,
									"Actual Validation :- " + SupplierPage.SupplierValidation.getText());
							testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation2);
							testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("Low Priority");
							testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("High Priority");
						}
						// } catch (NoSuchElementException e) {

					} else {
						testCase = extent.createTest("SUPPLIER FIELD NOT VISIBLITY");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {

				}
			}
			Thread.sleep(1000);

			try {
				if (SupplierPage.PlantValidation.isDisplayed()) {

					String ActualValidation3 = SupplierPage.PlantValidation.getText();
					String ExpectedValidation3 = Validation3;
					testCase = extent.createTest(Message);
					try {
						Assert.assertEquals(ActualValidation3, ExpectedValidation3);
						testCase.log(Status.INFO, "Actual Validation :- " + SupplierPage.PlantValidation.getText());
						testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation3);
						testCase.log(Status.PASS, "Pass " + Message + "Script");
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "Actual Validation :- " + SupplierPage.PlantValidation.getText());
						testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation3);
						testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("Low Priority");
						testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("High Priority");
					}
					// } catch (NoSuchElementException e) {

				} else {
					testCase = extent.createTest("PLANT DROPDOWN NOT VISIBLITY");
					testCase.log(Status.INFO, "Dropdown Not Displayed");
					testCase.log(Status.FAIL, " Dropdown Not Displayed");
				}
			} catch (NoSuchElementException e) {

			}

			Thread.sleep(1000);

			if (SupplierPage.supplierSaveButton.isDisplayed()) {
				Thread.sleep(1000);
				SupplierPage.supplierSaveButton.click();
			}

			if (SupplierPage.supplierCancelButton.isDisplayed()) {
				Thread.sleep(1000);
				SupplierPage.supplierCancelButton.click();
			}
		}
	}

//	confirm the first page delete
//	--------------------------------

	public static void deleteSupplierConfirm() throws InterruptedException {

		SupplierPage SupplierPg = new SupplierPage();
		PageFactory.initElements(driver, SupplierPg);
		new Actions(driver);
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[3]/div/span[2]"))
				.click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Email']"))
				.sendKeys(email);

		driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Email']"))
				.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		driver.findElement(
				By.xpath("//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div/button[1]"))
				.click();

		String ActualData = SupplierPage.supplierTableBody.getText();
		String ExpectedData = "No Data";

		System.out.println("data : " + ActualData);
		testCase = extent.createTest("verify the delete function");
		if (ActualData.equals("No Data")) {
//			Assert.assertEquals(ActualData, ExpectedData);

			testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
			testCase.log(Status.INFO, "Expectedvalue :- " + ExpectedData);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, ActualData);
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
			testCase.log(Status.INFO, "ExpectedValue :- " + ExpectedData);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, ActualData);

		}

	}

//	confirm the first page delete
//	--------------------------------

	public static void deleteSupplierInMiddleConfirm() throws InterruptedException {

		SupplierPage SupplierPg = new SupplierPage();
		PageFactory.initElements(driver, SupplierPg);
		new Actions(driver);
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[3]/div/span[2]"))
				.click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Email']"))
				.sendKeys(email);

		driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Email']"))
				.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		driver.findElement(
				By.xpath("//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div/button[1]"))
				.click();

		String ActualData = SupplierPage.supplierTableBody.getText();
		String ExpectedData = "No Data";

		System.out.println("data : " + ActualData);
		testCase = extent.createTest("verify the delete function");
		if (ActualData.equals("No Data")) {
//			Assert.assertEquals(ActualData, ExpectedData);

			testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
			testCase.log(Status.INFO, "Expectedvalue :- " + ExpectedData);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, ActualData);
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
			testCase.log(Status.INFO, "ExpectedValue :- " + ExpectedData);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, ActualData);

		}

	}

//	$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	public static void deleteElement() throws InterruptedException {
		Thread.sleep(3000);
		try {
			if (driver.findElement(By.xpath(
					"//td[text()='" + email + "']//following-sibling::td[5]//span[@class='anticon anticon-delete']"))
					.isDisplayed()) {

				testCase = extent.createTest("Delete Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver.findElement(By.xpath("//td[text()='" + email
						+ "']//following-sibling::td[5]//span[@class='anticon anticon-delete']")).isEnabled()) {
					testCase = extent.createTest("Delete Icon Enable");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='" + email
								+ "']//following-sibling::td[5]//span[@class='anticon anticon-delete']")).click();

						Thread.sleep(2000);
						SupplierPage.supplierPaginationDelete.click();

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

//	searching the element
//	----------------------------

	public static void middleElementClick() throws InterruptedException {

		PageFactory.initElements(driver, SupplierPg);
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, SourcePg);

		boolean nextBtn = SupplierPage.NextPageBtn.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_third;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);

			}
			boolean isExist = list.contains(email);
			Thread.sleep(1000);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			nextBtn = SupplierPage.NextPageBtn.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				SupplierPage.NextPageBtn.click();
				Thread.sleep(2000);
			} else
				break;

		}

	}

//	searching the element in first page
//	-----------------------------------

	public static void elementClick() throws InterruptedException {

		PageFactory.initElements(driver, SupplierPg);
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, SourcePg);

		boolean nextBtn = SupplierPage.NextPageBtn.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_third;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);

			}
			boolean isExist = list.contains(email);
			Thread.sleep(1000);
			nextBtn = SupplierPage.NextPageBtn.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				SupplierPage.NextPageBtn.click();
				Thread.sleep(2000);
			} else
				break;

		}

	}

//	delete the firstpage element in employee
//	-------------------------------------------

	public static void deleteFirstPageElement() throws InterruptedException {
		Thread.sleep(3000);
		try {
			if (driver.findElement(By.xpath(
					"//td[text()='" + email + "']//following-sibling::td[5]//span[@class='anticon anticon-delete']"))
					.isDisplayed()) {

				testCase = extent.createTest("Delete Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver.findElement(By.xpath("//td[text()='" + email
						+ "']//following-sibling::td[5]//span[@class='anticon anticon-delete']")).isEnabled()) {
					testCase = extent.createTest("Delete Icon Enable");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='" + email
								+ "']//following-sibling::td[5]//span[@class='anticon anticon-delete']")).click();

						Thread.sleep(2000);
						SupplierPage.supplierPaginationDelete.click();

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

//	FUNCTION FOR CANNOT DELETE VALIDATION CHECK
//	---------------------------------------------

	public static void cannotDeleteValidation() {

		try {
			if (driver.findElement(By.xpath("/html/body/div[3]/div")).isDisplayed()) {

				driver.findElement(By.xpath("/html/body/div[3]/div")).isDisplayed();
				testCase = extent.createTest("VALIDATION MESSAGE IS VISIBLE");
				testCase.log(Status.INFO, "record is exists");
				testCase.log(Status.PASS, "record is exists");

//				try {
//					
//				
//				String Actualtext= driver.findElement(By.xpath("//div[@class='ant-notification-notice-content']")).getText();
//				System.out.println("validation message "+Actualtext);
//				String Exptext="Can't delete this module";
//				
//				UserMainTests.TestCasePrint("RECORD IS DEPENDANT- VALIDATION MESSAGE", Exptext, Actualtext);
//				
//				
//			
//		} catch (NoSuchElementException e) {
//			testCase = extent.createTest("VALIDATON TEXT IS NOT VISIBLE");
//			testCase.log(Status.INFO, "no records");
//			testCase.log(Status.FAIL, "no records");
//		}

			} else {
				testCase = extent.createTest("VALIDATION MESSAGE IS NOT VISIBLE");
				testCase.log(Status.INFO, "no records");
				testCase.log(Status.FAIL, "no records");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("VALIDATON MESSAGE IS NOT VISIBLE");
			testCase.log(Status.INFO, "no records");
			testCase.log(Status.FAIL, "no records");
		}
	}

//  activated employee not able to delete confirmation
//  -----------------------------------------------------

	public static void deleteDependedSupplierConfirm() throws InterruptedException {

		SupplierPage SupplierPg = new SupplierPage();
		PageFactory.initElements(driver, SupplierPg);

		new Actions(driver);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//th[3]/div/span[@class='ant-dropdown-trigger ant-table-filter-trigger']"))
				.click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Email']"))
				.sendKeys(email);

		driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Email']"))
				.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		String ActualData = SupplierPage.firstRowSupplierEmail.getText();

		System.out.println("fsg : " + ActualData);
		testCase = extent.createTest("verify the row data");
		if (ActualData.equals(expectedValue)) {

			testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
			testCase.log(Status.INFO, "Expectedvalue :- " + expectedValue);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, ActualData);
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
			testCase.log(Status.INFO, "ExpectedValue :- " + expectedValue);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, ActualData);

		}

	}

// ###############################################################################
// ADD THE DELETED SUPPLIER
// ###############################################################################

	public static void middleElementClickDeleteAdd() throws InterruptedException {

		PageFactory.initElements(driver, SupplierPg);
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, SourcePg);

		boolean nextBtn = SupplierPage.NextPageBtn.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_third;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);

			}
			boolean isExist = list.contains(email);
			Thread.sleep(1000);
			nextBtn = SupplierPage.NextPageBtn.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				SupplierPage.NextPageBtn.click();
				Thread.sleep(2000);
			} else
				break;

		}

	}

	public static void deleteElementDeleteAdd() throws InterruptedException {
		Thread.sleep(3000);
		try {
			if (driver.findElement(By.xpath(
					"//td[text()='" + email + "']//following-sibling::td[5]//span[@class='anticon anticon-delete']"))
					.isDisplayed()) {

				testCase = extent.createTest("Delete Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver.findElement(By.xpath("//td[text()='" + email
						+ "']//following-sibling::td[5]//span[@class='anticon anticon-delete']")).isEnabled()) {
					testCase = extent.createTest("Delete Icon Enable");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='" + email
								+ "']//following-sibling::td[5]//span[@class='anticon anticon-delete']")).click();

						Thread.sleep(2000);
						SupplierPage.supplierDeleteConfirmBtn.click();

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void deleteSupplierConfirmDeleteAdd() throws InterruptedException {

		SupplierPage SupplierPg = new SupplierPage();
		PageFactory.initElements(driver, SupplierPg);

//		String SearchEmail = "say@gmail.com";

		new Actions(driver);
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[3]/div/span[2]"))
				.click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Email']"))
				.sendKeys(email);

		driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Email']"))
				.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		driver.findElement(
				By.xpath("//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div/button[1]"))
				.click();

		String ActualData = SupplierPage.supplierTableBody.getText();
		String ExpectedData = "No Data";

		System.out.println("data : " + ActualData);
		testCase = extent.createTest("verify the delete function");
		if (ActualData.equals("No Data")) {
//		Assert.assertEquals(ActualData, ExpectedData);

			testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
			testCase.log(Status.INFO, "Expectedvalue :- " + ExpectedData);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, ActualData);
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
			testCase.log(Status.INFO, "ExpectedValue :- " + ExpectedData);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, ActualData);

		}

	}

	public static void addSupplierDropdownDeleteAdd() throws InterruptedException {

		PageFactory.initElements(driver, SupplierPg);

		if (check) {
			Thread.sleep(5000);
			for (int j = 1; j <= 10; j++) {
				WebElement name = driver
						.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[" + j + "]"));
				String dropcontent = name.getText();
				if (dropcontent.contentEquals(suppliercategory)) {
					name.click();
					pass = true;
				} else if (dropcontent.isEmpty()) {
					pass = true;
				}
			}
		}
	}

	public static void addSupplierSendValuesDeleteAdd() throws InterruptedException {

		PageFactory.initElements(driver, SupplierPg);

		Thread.sleep(500);
		SupplierPage.supplierField.click();
		SupplierPage.supplierField.sendKeys(supplier);

		Thread.sleep(500);
		SupplierPage.contactNoField.click();
		SupplierPage.contactNoField.sendKeys(contactno);

		Thread.sleep(500);
		SupplierPage.emailField.click();
		SupplierPage.emailField.sendKeys(email);

		Thread.sleep(500);
		SupplierPage.addressField.click();
		SupplierPage.addressField.sendKeys(address);

	}

	public static void addPlantDropdownDeleteAdd() throws InterruptedException {

		PageFactory.initElements(driver, SupplierPg);

		if (check) {

			for (int j = 1; j <= 8; j++) {
				Thread.sleep(3000);
				WebElement name1 = driver.findElement(
						By.xpath("//body[@class='ant-scrolling-effect']/div[5]/div/div/div/div[2]/div[1]/div/div/div["
								+ j + "]/div"));
				String dropcontent1 = name1.getText();
				System.out.println(dropcontent1);
				Thread.sleep(500);
				if (dropcontent1.contentEquals(plant)) {
					Thread.sleep(2500);
					name1.click();
					pass = true;
				}
				if (dropcontent1.isEmpty()) {
					pass = true;
				}
			}
		}

	}

	public static void checkLastAddvalueDeleteAdd() throws InterruptedException {
		PageFactory.initElements(driver, SupplierPg);
		Thread.sleep(2000);
		String actualdata = SupplierPage.supplierFirstRow.getText();
		System.out.println("First row of table : " + actualdata);
		String expecteddata = "supplierDeleteAdd";
// TestCasePrint("CHECK THE LAST ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE", expecteddata, actualdata);

		boolean last = true;
		testCase = extent.createTest("ADDED DATA COMES FIRST ROW");
		try {
			AssertJUnit.assertEquals(actualdata, expecteddata);

		} catch (AssertionError e) {
			last = false;
		}
		if (last) {
			testCase.log(Status.INFO, "actualdata :- " + actualdata);
			testCase.log(Status.INFO, "expecteddata :- " + expecteddata);
			testCase.log(Status.PASS, "Correct Data");
		} else {
			testCase.log(Status.INFO, "actualdata :- " + actualdata);
			testCase.log(Status.INFO, "expecteddata :- " + expecteddata);
			testCase.log(Status.FAIL, "Wrong Data");
		}
		Thread.sleep(1000);

	}

//###############################################################################
//ADD THE DELETED SUPPLIER END
//###############################################################################

	// ******************************************************************************************************************
	// Checking total pages for 10,20,30,100 data per page
	// ******************************************************************************************************************
	public static void supplierDataPages() throws InterruptedException {

		// Thread.sleep(2000);
		int ActualTotalPage = 1;
		boolean Enablity = SupplierPage.NextPageBtn.isEnabled();
		while (Enablity) {
			Thread.sleep(1000);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(1000);
			SupplierPage.NextPageBtn.click();
			ActualTotalPage = ActualTotalPage + 1;
			Enablity = SupplierPage.NextPageBtn.isEnabled();
		}
		System.out.println(ActualTotalPage);
		Thread.sleep(2000);

		if (SupplierPage.CurrentPaginationOption.getText().contentEquals("10 / page")) {

			testCase = extent.createTest("Checking Total Page for 10 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + SupplierPage.CurrentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + SupplierPage.CurrentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (SupplierPage.CurrentPaginationOption.getText().contentEquals("20 / page")) {

			testCase = extent.createTest("Checking Total Page for 20 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage20);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + SupplierPage.CurrentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage20);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + SupplierPage.CurrentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage20);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (SupplierPage.CurrentPaginationOption.getText().contentEquals("30 / page")) {

			testCase = extent.createTest("Checking Total Page for 30 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage30);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + SupplierPage.CurrentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage30);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + SupplierPage.CurrentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage30);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (SupplierPage.CurrentPaginationOption.getText().contentEquals("100 / page")) {

			testCase = extent.createTest("Checking Total Page for 100 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage100);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + SupplierPage.CurrentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage100);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + SupplierPage.CurrentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage100);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}

		}

		driver.navigate().refresh();
		Thread.sleep(2000);

	}

//	$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//	$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

//	searching the element for edit
//	-----------------------------------

	public static void editElementClick() throws InterruptedException {

		PageFactory.initElements(driver, SupplierPg);
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, SourcePg);

		boolean nextBtn = SupplierPage.NextPageBtn.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_third;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);

			}
			boolean isExist = list.contains(email);
			Thread.sleep(1000);
			nextBtn = SupplierPage.NextPageBtn.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				SupplierPage.NextPageBtn.click();
				Thread.sleep(2000);
			} else
				break;

		}

	}

//	edit button click the element in employee
//	-------------------------------------------

	public static void cancelEditSupplierClick() throws InterruptedException {
		Thread.sleep(3000);
		try {
			if (driver.findElement(By.xpath(
					"//td[text()='" + email + "']//following-sibling::td[5]//span[@class='anticon anticon-edit']"))
					.isDisplayed()) {

				testCase = extent.createTest("Edit Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver.findElement(By.xpath(
						"//td[text()='" + email + "']//following-sibling::td[5]//span[@class='anticon anticon-edit']"))
						.isEnabled()) {
					testCase = extent.createTest("Edit Icon Enable");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='" + email
								+ "']//following-sibling::td[5]//span[@class='anticon anticon-edit']")).click();

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

//	$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//	$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

//	searching the element for delete cancel
//	---------------------------------------

	public static void deleteElementClick() throws InterruptedException {

		PageFactory.initElements(driver, SupplierPg);
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, SourcePg);

		boolean nextBtn = SupplierPage.NextPageBtn.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_third;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);

			}
			boolean isExist = list.contains(email);
			Thread.sleep(1000);
			nextBtn = SupplierPage.NextPageBtn.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				SupplierPage.NextPageBtn.click();
				Thread.sleep(2000);
			} else
				break;

		}

	}

//	delete button click the element in employee
//	-------------------------------------------

	public static void cancelDeleteSupplierClick() throws InterruptedException {
		Thread.sleep(3000);
		try {
			if (driver.findElement(By.xpath(
					"//td[text()='" + email + "']//following-sibling::td[5]//span[@class='anticon anticon-delete']"))
					.isDisplayed()) {

				testCase = extent.createTest("Edit Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver.findElement(By.xpath("//td[text()='" + email
						+ "']//following-sibling::td[5]//span[@class='anticon anticon-delete']")).isEnabled()) {
					testCase = extent.createTest("Edit Icon Enable");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='" + email
								+ "']//following-sibling::td[5]//span[@class='anticon anticon-delete']")).click();

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	public static void editElement() throws InterruptedException {
		Thread.sleep(3000);
		try {
			if (driver.findElement(By.xpath(
					"//td[text()='" + email + "']//following-sibling::td[5]//span[@class='anticon anticon-edit']"))
					.isDisplayed()) {

				testCase = extent.createTest("Edit Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver.findElement(By.xpath(
						"//td[text()='" + email + "']//following-sibling::td[5]//span[@class='anticon anticon-edit']"))
						.isEnabled()) {
					testCase = extent.createTest("Edit Icon Enable");

					try {
						driver.findElement(By.xpath("//td[text()='" + email
								+ "']//following-sibling::td[5]//span[@class='anticon anticon-edit']")).click();

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

//	more view element click in supplier
//	-------------------------------------------

	public static void moreViewElementClick() throws InterruptedException {
		Thread.sleep(3000);
		try {
			if (driver.findElement(By.xpath(
					"//td[text()='" + email + "']//following-sibling::td[4]//span[@class='anticon anticon-ellipsis']"))
					.isDisplayed()) {

				testCase = extent.createTest("More View Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver
						.findElement(By.xpath("//td[text()='" + email
								+ "']//following-sibling::td[4]//span[@class='anticon anticon-ellipsis']"))
						.isEnabled()) {
					testCase = extent.createTest("More View Icon Enable");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='" + email
								+ "']//following-sibling::td[4]//span[@class='anticon anticon-ellipsis']")).click();

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

//	supplier Category view element click in supplier
//	-------------------------------------------------

	public static void supplierCategoryViewElementClick() throws InterruptedException {
		Thread.sleep(3000);
		try {
			if (driver.findElement(By.xpath(
					"//td[text()='" + email + "']//following-sibling::td[3]//span[@class='anticon anticon-idcard']"))
					.isDisplayed()) {

				testCase = extent.createTest("supplier category View Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver.findElement(By.xpath("//td[text()='" + email
						+ "']//following-sibling::td[3]//span[@class='anticon anticon-idcard']")).isEnabled()) {
					testCase = extent.createTest("supplier category View Icon Enable");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='" + email
								+ "']//following-sibling::td[3]//span[@class='anticon anticon-idcard']")).click();

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

}
