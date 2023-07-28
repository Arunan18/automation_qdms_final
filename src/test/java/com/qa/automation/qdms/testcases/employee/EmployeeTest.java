//***********************************************************************************
//* Description
//*------------
//* Methods of employee testcases
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

package com.qa.automation.qdms.testcases.employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.EmployeePage;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.pages.master.SourcePage;

public class EmployeeTest extends DriverIntialization {

	static EmployeePage EmployeePg = new EmployeePage();
	static PlantEquipmentPage page = new PlantEquipmentPage();
	static SourcePage SourcePg = new SourcePage();

	static String verifiedEmail = null;

	static int ExpectedTotalPage = 0;
	static int ExpectedTotalPage20 = 0;
	static int ExpectedTotalPage30 = 0;
	static int ExpectedTotalPage100 = 0;

	static String firstname = null;
	static String lastname = null;
	static String designation = null;

	static String plant = null;
	static String contactno = null;
	static String email = null;
	static String address = null;
	static boolean check = true;
	static boolean pass = true;
	static String addDeleteEmail = null;
	static String newemail = null;
	static String expectedValue = null;

//	ADD EMPLOYEE fUNCTION EXCEL
//	---------------------------

	public static void addEmployeerExcelData() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Employee");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0083");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0083");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			firstname = (String) row.getCell(1).getStringCellValue();
			lastname = (String) row.getCell(2).getStringCellValue();
			plant = (String) row.getCell(3).getStringCellValue();
			designation = (String) row.getCell(4).getStringCellValue();
			address = (String) row.getCell(5).getStringCellValue();
			contactno = (String) row.getCell(6).getStringCellValue();
			email = (String) row.getCell(7).getStringCellValue();

		}
	}

//	Excel for delete employee after depend functionality
//	-------------------------------------------------------

	public static void deleteAfterDependExcelData() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Employee");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0112");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0112");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			verifiedEmail = (String) row.getCell(1).getStringCellValue();

		}
	}

//	Excel for delete employee before depend functionality
//	-------------------------------------------------------

	public static void deleteEmployeeBeforeExcelData() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Employee");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0099");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0099");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			verifiedEmail = (String) row.getCell(1).getStringCellValue();

		}
	}

//	Excel for delete employee after change Pagination
//	---------------------------------------------------

	public static void deleteAfterPaginationExcelData() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Employee");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0114");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0114");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			email = (String) row.getCell(1).getStringCellValue();

		}
	}

//	ADD DELETED EMPLOYEE fUNCTION EXCEL
//	-----------------------------------

	public static void addDeletedEmployeeExcelData() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Employee");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0110");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0110");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			firstname = (String) row.getCell(1).getStringCellValue();
			lastname = (String) row.getCell(2).getStringCellValue();
			plant = (String) row.getCell(3).getStringCellValue();
			designation = (String) row.getCell(4).getStringCellValue();
			address = (String) row.getCell(5).getStringCellValue();
			contactno = (String) row.getCell(6).getStringCellValue();
			email = (String) row.getCell(7).getStringCellValue();
		}
	}

//	CANCEL DELETE FUNCTIONALITY EXCEL
//	----------------------------------

	public static void cancelDeleteExcel() throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Employee");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0101");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0101");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			email = (String) row.getCell(1).getStringCellValue();

		}

	}

//	CANCEL EDIT FUNCTIONALITY EXCEL
//	----------------------------------

	public static void cancelEditExcel() throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Employee");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0095");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0095");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			email = (String) row.getCell(1).getStringCellValue();

		}

	}

//  EDIT FUNCTIONALITY EXCEL
//	----------------------------------

	public static void editExcel() throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Employee");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0093");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0093");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			email = (String) row.getCell(1).getStringCellValue();
			newemail = (String) row.getCell(2).getStringCellValue();
		}

	}

//  MORE VIEW FUNCTIONALITY EXCEL
//	----------------------------------

	public static void moreViewExcel() throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Employee");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0065");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0065");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			email = (String) row.getCell(1).getStringCellValue();
			expectedValue = (String) row.getCell(2).getStringCellValue();
		}

	}

//	PAGINATION fUNCTION EXCEL
//	---------------------------

	public static void paginationExcel() throws IOException, InterruptedException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Employee");
		sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0112");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Supplier\\Master Module.xlsx",
				"Employee", "TC-EMP-0112");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			ExpectedTotalPage = (int) row.getCell(1).getNumericCellValue();
			ExpectedTotalPage20 = (int) row.getCell(2).getNumericCellValue();
			ExpectedTotalPage30 = (int) row.getCell(3).getNumericCellValue();
			ExpectedTotalPage100 = (int) row.getCell(4).getNumericCellValue();

		}
	}

//EMPLOYEE EXPORT BUTTON PROPERTIES
//--------------------------------------------------

	public static void employeeExportButtonUI() throws InterruptedException {
		PageFactory.initElements(driver, EmployeePg);

		// check if element visible
		testCase = extent.createTest("STEP 1 - CHECKING THE \"EMP-EXPORT\" BUTTON PROPERTIES");
		boolean ActualElement = EmployeePage.employeeExportButton.isDisplayed();
		boolean ExpectedElement = true;

		boolean visibility = true;
		testCase = extent.createTest("EMP-EXPORT-BUTTON-VISIBILITY");
		try {
			AssertJUnit.assertEquals(ActualElement, ExpectedElement);

		} catch (AssertionError e) {

			visibility = false;

//        	  throw(e);
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

		Point ActualLocation = EmployeePage.employeeExportButton.getLocation();

		int actual_x = ActualLocation.getX();
		int actual_y = ActualLocation.getY();

		System.out.println("X axis: " + actual_x);
		System.out.println("Y axis: " + actual_y);

		Point ExpectedLocation = new Point(588, 93);

		boolean Position = true;
		testCase = extent.createTest("EMP-EXPORT-BUTTON-POSITION");
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

//		 check font size

		String ActualFontSize = EmployeePage.employeeExportButton.getCssValue("font-size");
		System.out.println("Font Size: " + ActualFontSize);
		String ExpectedFontSize = "14px";

		boolean Fontsize = true;
		testCase = extent.createTest("EMP-EXPORT-BUTTON-FONT-SIZE");
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

//		 check the size 

		Dimension ActualSize = EmployeePage.employeeExportButton.getSize();
		System.out.println("Size : " + ActualSize);
		Dimension ExpectedSize = new Dimension(180, 32);

		boolean size = true;
		testCase = extent.createTest("EMP-EXPORT-BUTTON-SIZE");
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

//            check the enable

		boolean ActualElementEnable = EmployeePage.employeeExportButton.isEnabled();

		boolean ExpectedElementEnable = true;

		boolean enablity = true;
		testCase = extent.createTest("EMP-EXPORT-BUTTON-ENABLE");
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

//            check the button color

		String ActualButtonColor = EmployeePage.employeeExportButton.getCssValue("background-color");
		System.out.println("rgb :" + ActualButtonColor);

		String ExpectedButtonColor = "rgba(0, 19, 40, 1)";

		boolean buttoncolor = true;
		testCase = extent.createTest("EMP-EXPORT-BUTTON-COLOR");
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

//            check the border color

		String ActualBorderColor = EmployeePage.employeeExportButton.getCssValue("border-colour");
		System.out.println("rgb :" + ActualBorderColor);

		String ExpectedBorderColor = " ";

		boolean bordercolor = true;
		testCase = extent.createTest("EMP-EXPORT-BUTTON-BORDER-COLOR");
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

//            check the font type 

		String ActualFontType = EmployeePage.employeeExportButton.getCssValue("font-type");
		System.out.println("Font type: " + ActualFontType);

		String ExpectedFontType = "";

		// input[@id='sub_business_unit']

		boolean fonttype = true;
		testCase = extent.createTest("EMP-EXPORT-BUTTON-FONT-TYPE");
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

//                    check font color

		String ActualFontColor = EmployeePage.employeeExportButton.getCssValue("color");

		System.out.println("Font colour: " + ActualFontColor);

		String ExpectedFontColor = "rgba(255, 255, 255, 1)";
		testCase = extent.createTest("EMP-EXPORT-BUTTON-FONT-COLOUR");
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

//		cursor

		String ActualActions = EmployeePage.employeeExportButton.getCssValue("cursor");
		System.out.println("cursor :" + ActualActions);
		String ExpectedActions = "pointer";

		boolean cursor = true;
		testCase = extent.createTest("EMP-EXPORT-BUTTON-CURSOR");
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

//		text spelling

		String text = EmployeePage.employeeExportButton.getText();

		String text1 = "Add SBU";
		boolean txt1 = true;
		testCase = extent.createTest("EMP-EXPORT-BUTTON-SPELLING");

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

//		padding

		String Actualvalue = EmployeePage.employeeExportButton.getCssValue("padding");
		System.out.println("paddingvalue :" + Actualvalue);
		String Expectedvalue = "4px 15px";

		boolean padding = true;
		testCase = extent.createTest("EMP-EXPORT-BUTTON-PADDING");
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

//  		border radius

		String Actualradius = EmployeePage.employeeExportButton.getCssValue("border-radius");
		System.out.println("radius value :" + Actualradius);
		String Expectedradius = "2px";

		testCase = extent.createTest("EMP-EXPORT-BUTTON-RADIUS");
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

//		opacity

		String Actualopacity = EmployeePage.employeeExportButton.getCssValue("opacity");
		System.out.println("opacity  :" + Actualopacity);
		String Expectedopacity = "1";

		boolean opacity = true;
		testCase = extent.createTest("EMP-EXPORT-BUTTON-OPACITY");
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

//		font weight

		String Actualfontweight = EmployeePage.employeeExportButton.getCssValue("font-weight");
		System.out.println("fontweight  :" + Actualfontweight);
		String Expectedfontweight = "400";

		boolean fontweight = true;
		testCase = extent.createTest("EMP-EXPORT-BUTTON-FONT-WEIGHT");
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

//----------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------

//EMPLOYEE IMPORT BUTTON PROPERTIES
//--------------------------------------------------

	public static void employeeImportButtonUI() throws InterruptedException {
		PageFactory.initElements(driver, EmployeePg);

		// check if element visible
		testCase = extent.createTest("STEP 1 - CHECKING THE \"EMP-IMPORT\" BUTTON PROPERTIES");
		boolean ActualElement = EmployeePage.employeeImportButton.isDisplayed();
		boolean ExpectedElement = true;

		boolean visibility = true;
		testCase = extent.createTest("EMP-IMPORT-BUTTON-VISIBILITY");
		try {
			AssertJUnit.assertEquals(ActualElement, ExpectedElement);

		} catch (AssertionError e) {

			visibility = false;

//        	  throw(e);
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

		Point ActualLocation = EmployeePage.employeeImportButton.getLocation();

		int actual_x = ActualLocation.getX();
		int actual_y = ActualLocation.getY();

		System.out.println("X axis: " + actual_x);
		System.out.println("Y axis: " + actual_y);

		Point ExpectedLocation = new Point(588, 93);

		boolean Position = true;
		testCase = extent.createTest("EMP-IMPORT-BUTTON-POSITION");
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

//		 check font size

		String ActualFontSize = EmployeePage.employeeImportButton.getCssValue("font-size");
		System.out.println("Font Size: " + ActualFontSize);
		String ExpectedFontSize = "14px";

		boolean Fontsize = true;
		testCase = extent.createTest("EMP-IMPORT-BUTTON-FONT-SIZE");
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

//		 check the size 

		Dimension ActualSize = EmployeePage.employeeImportButton.getSize();
		System.out.println("Size : " + ActualSize);
		Dimension ExpectedSize = new Dimension(180, 32);

		boolean size = true;
		testCase = extent.createTest("EMP-IMPORT-BUTTON-SIZE");
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

//            check the enable

		boolean ActualElementEnable = EmployeePage.employeeImportButton.isEnabled();
		boolean ExpectedElementEnable = true;

		boolean enablity = true;
		testCase = extent.createTest("EMP-IMPORT-BUTTON-ENABLE");
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

//            check the button color

		String ActualButtonColor = EmployeePage.employeeImportButton.getCssValue("background-color");
		System.out.println("rgb :" + ActualButtonColor);

		String ExpectedButtonColor = "rgba(0, 19, 40, 1)";

		boolean buttoncolor = true;
		testCase = extent.createTest("EMP-IMPORT-BUTTON-COLOR");
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

//            check the border color

		String ActualBorderColor = EmployeePage.employeeImportButton.getCssValue("border-colour");
		System.out.println("rgb :" + ActualBorderColor);

		String ExpectedBorderColor = " ";

		boolean bordercolor = true;
		testCase = extent.createTest("EMP-IMPORT-BUTTON-BORDER-COLOR");
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

//            check the font type 

		String ActualFontType = EmployeePage.employeeImportButton.getCssValue("font-type");
		System.out.println("Font type: " + ActualFontType);

		String ExpectedFontType = "";

		// input[@id='sub_business_unit']

		boolean fonttype = true;
		testCase = extent.createTest("EMP-IMPORT-BUTTON-FONT-TYPE");
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

//                    check font color

		String ActualFontColor = EmployeePage.employeeImportButton.getCssValue("color");

		System.out.println("Font colour: " + ActualFontColor);

		String ExpectedFontColor = "rgba(255, 255, 255, 1)";
		testCase = extent.createTest("EMP-IMPORT-BUTTON-FONT-COLOUR");
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

//		cursor

		String ActualActions = EmployeePage.employeeImportButton.getCssValue("cursor");
		System.out.println("cursor :" + ActualActions);
		String ExpectedActions = "pointer";

		boolean cursor = true;
		testCase = extent.createTest("EMP-IMPORT-BUTTON-CURSOR");
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

//		text spelling

		String text = EmployeePage.employeeImportButton.getText();

		String text1 = "Add SBU";
		boolean txt1 = true;
		testCase = extent.createTest("EMP-IMPORT-BUTTON-SPELLING");

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

//		padding

		String Actualvalue = EmployeePage.employeeImportButton.getCssValue("padding");
		System.out.println("paddingvalue :" + Actualvalue);
		String Expectedvalue = "4px 15px";

		boolean padding = true;
		testCase = extent.createTest("EMP-IMPORT-BUTTON-PADDING");
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

//  		border radius

		String Actualradius = EmployeePage.employeeImportButton.getCssValue("border-radius");
		System.out.println("radius value :" + Actualradius);
		String Expectedradius = "2px";

		testCase = extent.createTest("EMP-IMPORT-BUTTON-RADIUS");
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

//		opacity

		String Actualopacity = EmployeePage.employeeImportButton.getCssValue("opacity");
		System.out.println("opacity  :" + Actualopacity);
		String Expectedopacity = "1";

		boolean opacity = true;
		testCase = extent.createTest("EMP-IMPORT-BUTTON-OPACITY");
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

//		font weight

		String Actualfontweight = EmployeePage.employeeImportButton.getCssValue("font-weight");
		System.out.println("fontweight  :" + Actualfontweight);
		String Expectedfontweight = "400";

		boolean fontweight = true;
		testCase = extent.createTest("EMP-IMPORT-BUTTON-FONT-WEIGHT");
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

//   EMPLOYEE EXPORT
//----------------------------------------------------------------------------------

	public static void employeeExport() throws InterruptedException {

		EmployeePage.employeeExportButton.click();

		Thread.sleep(3000);

		File fileLocation = new File("C:\\Users\\sgic\\Downloads");

		boolean isFileExist = false;

		// List the total files
		File[] totalFiles = fileLocation.listFiles();

		for (File file : totalFiles) {

			if (file.getName().equals("employee.csv")) {

				System.out.println("File is downloaded");

				// if find the file name stop the loop
				isFileExist = true;
				break;

			}
		}

		boolean Expectedweight = true;
		testCase = extent.createTest("EMPLOYEE EXPORT");
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

//   EMPLOYEE ACTIVATION THROUGH ADD BUTTON 
//   -----------------------------------------------------------

	public void employeeActivate() {

	}

//	ADD EMPLOYEE
//	 ------------------------------------

//	 Add Employee button properties 
//	 ----------------------------------------

	public static void addEmployeeButtonProperties() throws InterruptedException {

		// check if element visible
		testCase = extent.createTest("CHECKING THE \"ADD EMPLOYEE\" BUTTON PROPERTIES");
		boolean ActualElement = EmployeePage.addEmployeeButton.isDisplayed();
		boolean ExpectedElement = true;

		boolean visibility = true;
		testCase = extent.createTest("ADD EMPLOYEE-BUTTON-VISIBILITY");
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

		Point ActualLocation = EmployeePage.addEmployeeButton.getLocation();

		int actual_x = ActualLocation.getX();
		int actual_y = ActualLocation.getY();

		System.out.println("X axis: " + actual_x);
		System.out.println("Y axis: " + actual_y);

		Point ExpectedLocation = new Point(1214, 93);

		boolean Position = true;
		testCase = extent.createTest("ADD EMPLOYEE-BUTTON-POSITION");
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

		String ActualFontSize = EmployeePage.addEmployeeButton.getCssValue("font-size");
		System.out.println("Font Size: " + ActualFontSize);
		String ExpectedFontSize = "14px";

		boolean Fontsize = true;
		testCase = extent.createTest("ADD EMPLOYEE-BUTTON-FONT-SIZE");
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

		Dimension ActualSize = EmployeePage.addEmployeeButton.getSize();
		System.out.println("Size : " + ActualSize);
		Dimension ExpectedSize = new Dimension(120, 32);

		boolean size = true;
		testCase = extent.createTest("ADD EMPLOYEE-BUTTON-SIZE");
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

		boolean ActualElementEnable = EmployeePage.addEmployeeButton.isEnabled();
		boolean ExpectedElementEnable = true;

		boolean enablity = true;
		testCase = extent.createTest("ADD EMPLOYEE-BUTTON-ENABLE");
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

		String ActualButtonColor = EmployeePage.addEmployeeButton.getCssValue("background-color");
		System.out.println("rgb :" + ActualButtonColor);

		String ExpectedButtonColor = "rgba(0, 19, 40, 1)";

		boolean buttoncolor = true;
		testCase = extent.createTest("ADD EMPLOYEE-BUTTON-COLOR");
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

		String ActualBorderColor = EmployeePage.addEmployeeButton.getCssValue("border-colour");
		System.out.println("rgb :" + ActualBorderColor);

		String ExpectedBorderColor = " ";

		boolean bordercolor = true;
		testCase = extent.createTest("ADD EMPLOYEE-BUTTON-BORDER-COLOR");
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

		String ActualFontType = EmployeePage.addEmployeeButton.getCssValue("font-type");
		System.out.println("Font type: " + ActualFontType);

		String ExpectedFontType = "";

		// input[@id='sub_business_unit']

		boolean fonttype = true;
		testCase = extent.createTest("ADD EMPLOYEE-BUTTON-FONT-TYPE");
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

		String ActualFontColor = EmployeePage.addEmployeeButton.getCssValue("color");

		System.out.println("Font colour: " + ActualFontColor);

		String ExpectedFontColor = "rgba(255, 255, 255, 1)";
		testCase = extent.createTest("ADD EMPLOYEE-BUTTON-FONT-COLOUR");
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

		String ActualActions = EmployeePage.addEmployeeButton.getCssValue("cursor");
		System.out.println("cursor :" + ActualActions);
		String ExpectedActions = "pointer";

		boolean cursor = true;
		testCase = extent.createTest("ADD EMPLOYEE-BUTTON-CURSOR");
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

		String text = EmployeePage.addEmployeeButton.getText();

		String text1 = "Add Employee";
		boolean txt1 = true;
		testCase = extent.createTest("ADD EMPLOYEE-BUTTON-SPELLING");

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

		String Actualvalue = EmployeePage.addEmployeeButton.getCssValue("padding");
		System.out.println("paddingvalue :" + Actualvalue);
		String Expectedvalue = "4px 15px";

		boolean padding = true;
		testCase = extent.createTest("ADD EMPLOYEE-BUTTON-PADDING");
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

		String Actualradius = EmployeePage.addEmployeeButton.getCssValue("border-radius");
		System.out.println("radius value :" + Actualradius);
		String Expectedradius = "2px";

		testCase = extent.createTest("ADD EMPLOYEE-BUTTON-RADIUS");
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

//				opacity

		String Actualopacity = EmployeePage.addEmployeeButton.getCssValue("opacity");
		System.out.println("opacity  :" + Actualopacity);
		String Expectedopacity = "1";

		boolean opacity = true;
		testCase = extent.createTest("ADD EMPLOYEE-BUTTON-OPACITY");
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

		String Actualfontweight = EmployeePage.addEmployeeButton.getCssValue("font-weight");
		System.out.println("fontweight  :" + Actualfontweight);
		String Expectedfontweight = "400";

		boolean fontweight = true;
		testCase = extent.createTest("ADD EMPLOYEE-BUTTON-FONT-WEIGHT");
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

//		selecting Plant dropdown 
//		--------------------------------------------------

	public static void plantDropdown() throws InterruptedException {

		PageFactory.initElements(driver, EmployeePg);

		if (check) {

			for (int j = 1; j <= 10; j++) {
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

	// sending values to the fields
	// ----------------------------------------

	public static void addEmployeeSendValues() throws InterruptedException {

		PageFactory.initElements(driver, EmployeePg);

		Thread.sleep(500);
		EmployeePage.firstNameField.click();
		EmployeePage.firstNameField.sendKeys(firstname);

		Thread.sleep(500);
		EmployeePage.lastNameField.click();
		EmployeePage.lastNameField.sendKeys(lastname);

		Thread.sleep(500);
		EmployeePage.employeeAddressField.click();
		EmployeePage.employeeAddressField.sendKeys(address);

		Thread.sleep(500);
		EmployeePage.employeeContactNoField.click();
		EmployeePage.employeeContactNoField.sendKeys(contactno);

		Thread.sleep(500);
		EmployeePage.employeeEmailField.click();
		EmployeePage.employeeEmailField.sendKeys(email);

	}

//		selecting Designation dropdown 
//		--------------------------------------------------

	public static void designationDropdown() throws InterruptedException {

		PageFactory.initElements(driver, EmployeePg);

		if (check) {
			Thread.sleep(5000);
			for (int j = 1; j <= 10; j++) {
				WebElement name = driver.findElement(
						By.xpath("//body[@class='ant-scrolling-effect']/div[4]/div/div/div/div[2]/div[1]/div/div/div["
								+ j + "]/div"));
				String dropcontent = name.getText();
				if (dropcontent.contentEquals(designation)) {
					name.click();
					pass = true;
				} else if (dropcontent.isEmpty()) {
					pass = true;
				}
			}
		}
	}

	// EMPLOYEE SAVE BUTTON PROPERTIES
	// --------------------------------------------------

	public static void employeeSaveButtonUI() throws InterruptedException {

		// check if element visible
		testCase = extent.createTest("CHECKING THE \"EMPLOYEE-SAVE\" BUTTON PROPERTIES");
		boolean ActualElement = EmployeePage.employeeSaveButton.isDisplayed();
		boolean ExpectedElement = true;

		boolean visibility = true;
		testCase = extent.createTest("EMPLOYEE-SAVE-BUTTON-VISIBILITY");
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

		Point ActualLocation = EmployeePage.employeeSaveButton.getLocation();

		int actual_x = ActualLocation.getX();
		int actual_y = ActualLocation.getY();

		System.out.println("X axis: " + actual_x);
		System.out.println("Y axis: " + actual_y);

		Point ExpectedLocation = new Point(952, 542);

		boolean Position = true;
		testCase = extent.createTest("EMPLOYEE-SAVE-BUTTON-POSITION");
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

		String ActualFontSize = EmployeePage.employeeSaveButton.getCssValue("font-size");
		System.out.println("Font Size: " + ActualFontSize);
		String ExpectedFontSize = "14px";

		boolean Fontsize = true;
		testCase = extent.createTest("EMPLOYEE-SAVE-BUTTON-FONT-SIZE");
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

		Dimension ActualSize = EmployeePage.employeeSaveButton.getSize();
		System.out.println("Size : " + ActualSize);
		Dimension ExpectedSize = new Dimension(60, 32);

		boolean size = true;
		testCase = extent.createTest("EMPLOYEE-SAVE-BUTTON-SIZE");
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

		boolean ActualElementEnable = EmployeePage.employeeSaveButton.isEnabled();
		boolean ExpectedElementEnable = true;

		boolean enablity = true;
		testCase = extent.createTest("EMPLOYEE-SAVE-BUTTON-ENABLE");
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

		String ActualButtonColor = EmployeePage.employeeSaveButton.getCssValue("background-color");
		System.out.println("rgb :" + ActualButtonColor);

		String ExpectedButtonColor = "rgba(0, 19, 40, 1)";

		boolean buttoncolor = true;
		testCase = extent.createTest("EMPLOYEE-SAVE-BUTTON-COLOR");
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

		String ActualBorderColor = EmployeePage.employeeSaveButton.getCssValue("border-colour");
		System.out.println("rgb :" + ActualBorderColor);

		String ExpectedBorderColor = " ";

		boolean bordercolor = true;
		testCase = extent.createTest("EMPLOYEE-SAVE-BUTTON-BORDER-COLOR");
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

		String ActualFontType = EmployeePage.employeeSaveButton.getCssValue("font-type");
		System.out.println("Font type: " + ActualFontType);

		String ExpectedFontType = "";

		// input[@id='sub_business_unit']

		boolean fonttype = true;
		testCase = extent.createTest("EMPLOYEE-SAVE-BUTTON-FONT-TYPE");
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

		String ActualFontColor = EmployeePage.employeeSaveButton.getCssValue("color");

		System.out.println("Font colour: " + ActualFontColor);

		String ExpectedFontColor = "rgba(255, 255, 255, 1)";
		testCase = extent.createTest("EMPLOYEE-SAVE-BUTTON-FONT-COLOUR");
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

		String ActualActions = EmployeePage.employeeSaveButton.getCssValue("cursor");
		System.out.println("cursor :" + ActualActions);
		String ExpectedActions = "pointer";

		boolean cursor = true;
		testCase = extent.createTest("EMPLOYEE-SAVE-BUTTON-CURSOR");
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

		String text = EmployeePage.employeeSaveButton.getText();

		String text1 = "Save";
		boolean txt1 = true;
		testCase = extent.createTest("EMPLOYEE-SAVE-BUTTON-SPELLING");

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

		String Actualvalue = EmployeePage.employeeSaveButton.getCssValue("padding");
		System.out.println("paddingvalue :" + Actualvalue);
		String Expectedvalue = "4px 15px";

		boolean padding = true;
		testCase = extent.createTest("EMPLOYEE-SAVE-BUTTON-PADDING");
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

		String Actualradius = EmployeePage.employeeSaveButton.getCssValue("border-radius");
		System.out.println("radius value :" + Actualradius);
		String Expectedradius = "2px";

		testCase = extent.createTest("EMPLOYEE-SAVE-BUTTON-RADIUS");
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

		String Actualopacity = EmployeePage.employeeSaveButton.getCssValue("opacity");
		System.out.println("opacity  :" + Actualopacity);
		String Expectedopacity = "1";

		boolean opacity = true;
		testCase = extent.createTest("EMPLOYEE-SAVE-BUTTON-OPACITY");
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

		String Actualfontweight = EmployeePage.employeeSaveButton.getCssValue("font-weight");
		System.out.println("fontweight  :" + Actualfontweight);
		String Expectedfontweight = "400";

		boolean fontweight = true;
		testCase = extent.createTest("EMPLOYEE-SAVE-BUTTON-FONT-WEIGHT");
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

	public static void employeecheckLastAddvalue() throws InterruptedException {
		PageFactory.initElements(driver, EmployeePg);
		Thread.sleep(2000);
		String actualdata = EmployeePage.employeeFirstRow.getText();
		System.out.println("First row of table : " + actualdata);
		String expecteddata = "sayanthan";
//	     TestCasePrint("CHECK THE LAST ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE", expecteddata, actualdata);

		boolean firstrow = true;
		testCase = extent.createTest("ADDED DATA COMES FIRST ROW");
		try {
			AssertJUnit.assertEquals(actualdata, expecteddata);

		} catch (AssertionError e) {
			firstrow = false;
		}
		if (firstrow) {
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

	public static void employeeModalClose() throws InterruptedException {
		PageFactory.initElements(driver, EmployeePg);

//	     Actions action = new Actions(driver);
//	     action.moveByOffset(0, 0).click().build().perform();
		boolean AcctualAfterClick = EmployeePage.employeeModal.isDisplayed();

		boolean ExpectedAfterClick = false;

		testCase = extent.createTest("EMPLOYEE MODAL CLOSING");
		try {
			AssertJUnit.assertEquals(AcctualAfterClick, ExpectedAfterClick);

		} catch (AssertionError e) {
			ExpectedAfterClick = true;
		}
		if (ExpectedAfterClick) {
			testCase.log(Status.INFO, "AcctualAfterClick :- " + AcctualAfterClick);
			testCase.log(Status.INFO, "Expectedfontweight :- " + ExpectedAfterClick);
			testCase.log(Status.PASS, "Modal is closed");
		} else {
			testCase.log(Status.INFO, "AcctualAfterClick :- " + AcctualAfterClick);
			testCase.log(Status.INFO, "ExpectedAfterClick :- " + ExpectedAfterClick);
			testCase.log(Status.FAIL, "Wrong font weight");
		}
		Thread.sleep(1000);

	}

	public static void employeeCancelButtonUI() throws InterruptedException {

		// check if element visible
		testCase = extent.createTest("CHECKING THE \"EMPLOYEE-CANCEL\" BUTTON PROPERTIES");
		boolean ActualElement = EmployeePage.employeeCancelButton.isDisplayed();
		boolean ExpectedElement = true;

		boolean visibility = true;
		testCase = extent.createTest("EMPLOYEE-CANCEL-BUTTON-VISIBILITY");
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

		Point ActualLocation = EmployeePage.employeeCancelButton.getLocation();

		int actual_x = ActualLocation.getX();
		int actual_y = ActualLocation.getY();

		System.out.println("X axis: " + actual_x);
		System.out.println("Y axis: " + actual_y);

		Point ExpectedLocation = new Point(869, 542);

		boolean Position = true;
		testCase = extent.createTest("EMPLOYEE-CANCEL-BUTTON-POSITION");
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

		String ActualFontSize = EmployeePage.employeeCancelButton.getCssValue("font-size");
		System.out.println("Font Size: " + ActualFontSize);
		String ExpectedFontSize = "14px";

		boolean Fontsize = true;
		testCase = extent.createTest("EMPLOYEE-CANCEL-BUTTON-FONT-SIZE");
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

		Dimension ActualSize = EmployeePage.employeeCancelButton.getSize();
		System.out.println("Size : " + ActualSize);
		Dimension ExpectedSize = new Dimension(75, 32);

		boolean size = true;
		testCase = extent.createTest("EMPLOYEE-CANCEL-BUTTON-SIZE");
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

		boolean ActualElementEnable = EmployeePage.employeeCancelButton.isEnabled();
		boolean ExpectedElementEnable = true;

		boolean enablity = true;
		testCase = extent.createTest("EMPLOYEE-CANCEL-BUTTON-ENABLE");
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

		String ActualButtonColor = EmployeePage.employeeCancelButton.getCssValue("background-color");
		System.out.println("rgb :" + ActualButtonColor);

		String ExpectedButtonColor = "rgba(255, 255, 255, 1)";

		boolean buttoncolor = true;
		testCase = extent.createTest("EMPLOYEE-CANCEL-BUTTON-COLOR");
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

		String ActualBorderColor = EmployeePage.employeeCancelButton.getCssValue("border-colour");
		System.out.println("rgb :" + ActualBorderColor);

		String ExpectedBorderColor = " ";

		boolean bordercolor = true;
		testCase = extent.createTest("EMPLOYEE-CANCEL-BUTTON-BORDER-COLOR");
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

		String ActualFontType = EmployeePage.employeeCancelButton.getCssValue("font-type");
		System.out.println("Font type: " + ActualFontType);

		String ExpectedFontType = "";

		// input[@id='sub_business_unit']

		boolean fonttype = true;
		testCase = extent.createTest("EMPLOYEE-CANCEL-BUTTON-FONT-TYPE");
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

		String ActualFontColor = EmployeePage.employeeCancelButton.getCssValue("color");

		System.out.println("Font colour: " + ActualFontColor);

		String ExpectedFontColor = "rgba(0, 0, 0, 0.85)";
		testCase = extent.createTest("EMPLOYEE-CANCEL-BUTTON-FONT-COLOUR");
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

		String ActualActions = EmployeePage.employeeCancelButton.getCssValue("cursor");
		System.out.println("cursor :" + ActualActions);
		String ExpectedActions = "pointer";

		boolean cursor = true;
		testCase = extent.createTest("EMPLOYEE-CANCEL-BUTTON-CURSOR");
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

		String text = EmployeePage.employeeCancelButton.getText();

		String text1 = "Cancel";
		boolean txt1 = true;
		testCase = extent.createTest("EMPLOYEE-CANCEL-BUTTON-SPELLING");

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

		String Actualvalue = EmployeePage.employeeCancelButton.getCssValue("padding");
		System.out.println("paddingvalue :" + Actualvalue);
		String Expectedvalue = "4px 15px";

		boolean padding = true;
		testCase = extent.createTest("EMPLOYEE-CANCEL-BUTTON-PADDING");
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

		String Actualradius = EmployeePage.employeeCancelButton.getCssValue("border-radius");
		System.out.println("radius value :" + Actualradius);
		String Expectedradius = "2px";

		testCase = extent.createTest("EMPLOYEE-CANCEL-BUTTON-RADIUS");
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

//				opacity

		String Actualopacity = EmployeePage.employeeCancelButton.getCssValue("opacity");
		System.out.println("opacity  :" + Actualopacity);
		String Expectedopacity = "1";

		boolean opacity = true;
		testCase = extent.createTest("EMPLOYEE-CANCEL-BUTTON-OPACITY");
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

		String Actualfontweight = EmployeePage.employeeCancelButton.getCssValue("font-weight");
		System.out.println("fontweight  :" + Actualfontweight);
		String Expectedfontweight = "400";

		boolean fontweight = true;
		testCase = extent.createTest("EMPLOYEE-CANCEL-BUTTON-FONT-WEIGHT");
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

	public static void employeeActivationFunction() throws InterruptedException {

		WebElement status = driver.findElement(By.xpath("//td[text()='" + email + "']//following-sibling::td[2]"));
		String statusText = status.getText();

		System.out.println(statusText);

		if (statusText.contentEquals("Verified")) {

			driver.findElement(By.xpath("//td[text()='" + email + "']//following-sibling::td[3]")).click();

		}

		String text = status.getText();

		String text1 = "Verified";
		boolean txt1 = true;
		testCase = extent.createTest("EMPLOYEE-ACTIVATION-BUTTON-CLICK");

		try {
			AssertJUnit.assertEquals(text, text1);
		} catch (AssertionError e) {
			txt1 = false;
		}
		if (txt1) {
			testCase.log(Status.INFO, "ActualElement :- " + text);
			testCase.log(Status.INFO, "ExpectedElement :- " + text1);
			testCase.log(Status.INFO, "Employee can be activate");
			testCase.log(Status.PASS, "Employee can be activate ");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + text);
			testCase.log(Status.INFO, "ExpectedElement :- " + text1);
			testCase.log(Status.INFO, "Employee cannot be activate");
			testCase.log(Status.FAIL, "Employee cannot be activate");
		}

		Thread.sleep(1000);

	}

	public static void employeeActiveModal() throws InterruptedException {

		// check if element visible
//				testCase = extent.createTest("CHECKING THE \"EMPLOYEE-CANCEL\" BUTTON PROPERTIES");
		boolean ActualElement = EmployeePage.employeeActiveUserTypeDropdown.isDisplayed();
		boolean ExpectedElement = true;

		boolean visibility = true;
		testCase = extent.createTest("USERTYPE-BUTTON-VISIBILITY");
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

		String value = null;
		for (WebElement option : EmployeePage.userTypeDropdownOptions) {
			value = option.getText();
			Thread.sleep(3000);
			System.out.println(value);
			if (value.contentEquals("PLANT_USER"))
				Thread.sleep(2000);
			System.out.println(value);
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div/div")).click();
		}

	}

	public static void selectUser() throws InterruptedException {

		String valuee = null;
		// int count=0;
		for (WebElement options : EmployeePage.roleOptions) {

			valuee = options.getText();
			Thread.sleep(3000);
			System.out.println(valuee);
			System.out.println();
			if (valuee.valueOf(3) != null)
				Thread.sleep(2000);
			options.click();
		}
	}

//	check the employee activate after add

	public static void checkingActivationOfEmployee() throws InterruptedException {

		WebElement status = driver.findElement(By.xpath("//td[text()='" + email + "']//following-sibling::td[6]"));
		String statusText = status.getText();

		System.out.println(statusText);

		String text = status.getText();

		String text1 = "Active";
		boolean txt1 = true;
		testCase = extent.createTest("CHECKING EMPLOYEE-ACTIVATION");

		try {
			AssertJUnit.assertEquals(text, text1);
		} catch (AssertionError e) {
			txt1 = false;
		}
		if (txt1) {
			testCase.log(Status.INFO, "ActualElement :- " + text);
			testCase.log(Status.INFO, "ExpectedElement :- " + text1);
			testCase.log(Status.INFO, "Employee is activated");
			testCase.log(Status.PASS, "Employee is activated");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + text);
			testCase.log(Status.INFO, "ExpectedElement :- " + text1);
			testCase.log(Status.INFO, "Employee is not activated");
			testCase.log(Status.FAIL, "Employee is not activated");
		}

		Thread.sleep(1000);

	}

//  VERIFYING THE SUPPLIER FORM WHEN BEFORE EDIT THE DATA
//	---------------------------------------------------------

	public static void verifyEmployeeForm() throws InterruptedException {

//		First name verify

		String actualFirstName = driver.findElement(By.xpath("//td[text()='Nimantha']")).getText();
		String expectedFirstName = EmployeePage.firstNameField.getAttribute("value");

		boolean firstname = true;
		testCase = extent.createTest("CHECKING THE EMPLOYEE ELEMENT");
		try {
			AssertJUnit.assertEquals(actualFirstName, expectedFirstName);

		} catch (AssertionError e) {
			firstname = false;
		}
		if (firstname) {
			testCase.log(Status.INFO, "actualFirstName :- " + actualFirstName);
			testCase.log(Status.INFO, "expectedFirstName :- " + expectedFirstName);
			testCase.log(Status.PASS, "Correct element");
		} else {
			testCase.log(Status.INFO, "actualFirstName :- " + actualFirstName);
			testCase.log(Status.INFO, "expectedFirstName :- " + expectedFirstName);
			testCase.log(Status.FAIL, "Wrong element");
		}
		Thread.sleep(1000);

//		Last name verify

		String actualLastName = driver.findElement(By.xpath("//td[text()='Nimantha']//following-sibling::td[1]"))
				.getText();
		String expectedLastName = EmployeePage.lastNameField.getAttribute("value");
		System.out.println("fgyhdfdrfsd");

		boolean lastname = true;
		testCase = extent.createTest("CHECKING THE EMPLOYEE ELEMENT");
		try {
			AssertJUnit.assertEquals(actualLastName, expectedLastName);

		} catch (AssertionError e) {
			lastname = false;
		}
		if (lastname) {
			testCase.log(Status.INFO, "actualLastName :- " + actualLastName);
			testCase.log(Status.INFO, "expectedLastName :- " + expectedLastName);
			testCase.log(Status.PASS, "Correct element");
		} else {
			testCase.log(Status.INFO, "actualLastName :- " + actualLastName);
			testCase.log(Status.INFO, "expectedLastName :- " + expectedLastName);
			testCase.log(Status.FAIL, "Wrong element");
		}
		Thread.sleep(1000);

//		Plant Verify

		String actualPlant = driver.findElement(By.xpath("//td[text()='Nimantha']//following-sibling::td[2]"))
				.getText();
		String expectedPlant = EmployeePage.plantDropdown.getAttribute("value");

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

//		Verify Designation

		String actualDesignation = driver.findElement(By.xpath("//td[text()='Nimantha']//following-sibling::td[3]"))
				.getText();
		String expectedDesignation = EmployeePage.designationDropdown.getText();

		boolean address = true;
		testCase = extent.createTest("CHECKING THE DESIGNATION ELEMENT");
		try {
			AssertJUnit.assertEquals(actualDesignation, expectedDesignation);

		} catch (AssertionError e) {
			address = false;
		}
		if (address) {
			testCase.log(Status.INFO, "actualDesignation :- " + actualDesignation);
			testCase.log(Status.INFO, "expectedDesignation :- " + expectedDesignation);
			testCase.log(Status.PASS, "Correct element");
		} else {
			testCase.log(Status.INFO, "actualDesignation :- " + actualDesignation);
			testCase.log(Status.INFO, "expectedDesignation :- " + expectedDesignation);
			testCase.log(Status.FAIL, "Wrong element");
		}
		Thread.sleep(1000);

//		Verify email

		String actualEmail = driver.findElement(By.xpath("//td[text()='Nimantha']//following-sibling::td[4]"))
				.getText();
		String expectedEmail = EmployeePage.employeeEmailField.getAttribute("value");

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

		String actualContactNo = driver.findElement(By.xpath("//td[text()='Nimantha']//following-sibling::td[5]"))
				.getText();
		String expectedContactNo = EmployeePage.employeeContactNoField.getAttribute("value");

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

	}

//	$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$	

	public static void employeeEdit() throws InterruptedException {

		PageFactory.initElements(driver, EmployeePg);

		Thread.sleep(500);
		EmployeePage.employeeEmailField.click();

		EmployeePage.employeeEmailField.sendKeys(Keys.CONTROL + "a");
		EmployeePage.employeeEmailField.sendKeys(Keys.DELETE);

		Thread.sleep(500);
		EmployeePage.employeeEmailField.sendKeys(email);

	}

	public static void verifyEmployeeEditFunction() throws InterruptedException {

		PageFactory.initElements(driver, EmployeePg);

		Thread.sleep(2000);
		String actualdata = EmployeePage.employeeFirstRow.getText();
		System.out.println("First row of table : " + actualdata);
		String expecteddata = "Nimantha";
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

//------------------------------------------------
//EMPLOYEE pAGINATION
//------------------------------------------------

//public static void EmployeePagination() throws InterruptedException {
//
//	EmployeePage EmployeePg = new EmployeePage();
//	
//	PageFactory.initElements(driver, EmployeePg);
//	Thread.sleep(1000);
//
//	EmployeePage.mainEmployee.click();
//	Thread.sleep(1000);
//	
//	EmployeePage.sideEmployee.click();
//	Thread.sleep(1000);
//
//}

	public static void employeeDefaultIndexPage() throws InterruptedException {
		try {
			new EmployeePage();
			// Default Index Page
			testCase = extent.createTest("EMPLOYEE-PAGINATION-FUNCTIONALITY");
			Thread.sleep(2000);
			boolean ActualDefaultPageIndex = EmployeePage.employeeFirstPage.isDisplayed();
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

	public static void employeeRefreshDefaultPage() throws InterruptedException {
		try {
			new EmployeePage();

			EmployeePage.NextPageBtn.click();
			// Thread.sleep(20000);
			driver.navigate().refresh();
			Thread.sleep(2000);
			boolean ActualDefaultPageIndex1 = EmployeePage.employeeFirstPage.isDisplayed();
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

//	Page Redirect to the next page 

	public static void employeePageRedirect() throws InterruptedException {
		try {
			new EmployeePage();
			EmployeePage.NextPageBtn.click();
			Thread.sleep(2000);
			boolean ActualSecoundPageIndex = EmployeePage.employeeSecoundPage.isDisplayed();
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

//	Previous Button Displayed

	public static void employeePreviousButtonDispaly() throws InterruptedException {
		try {
			new EmployeePage();
			boolean ActualVisiblePreviousButton = EmployeePage.PreviousPageBtn.isDisplayed();
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

//	Next Button Displayed

	public static void employeeNextButtonDispaly() throws InterruptedException {
		try {
			new EmployeePage();
			boolean ActualVisibleNextButton = EmployeePage.NextPageBtn.isDisplayed();
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

//Next Button Enable

	public static void employeeNextButtonEanble() throws InterruptedException {
		try {
			boolean ActualNextBtnEnable = EmployeePage.NextPageBtn.isEnabled();
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

//Before move to 2nd page, previous button disable

	public static void employeeSecPagepreButDisable() throws InterruptedException {
		try {
			Thread.sleep(2000);
			String ActualPreviousBtnDisable = EmployeePage.PreviousPageBtn.getAttribute("disabled");
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

//	After move to 2nd page, previous button Enable

	public static void employeeAfterMovetoSecPagepreButEnable() throws InterruptedException {
		try {
			EmployeePage.NextPageBtn.click();
			Thread.sleep(2000);
			boolean ActualPreviousBtnEnable = EmployeePage.PreviousPageBtn.isEnabled();
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

	public static void employeePages() throws InterruptedException {

		// Thread.sleep(2000);
		int ActualTotalPage = 1;
		boolean Enablity = EmployeePage.NextPageBtn.isEnabled();
		while (Enablity) {
			Thread.sleep(1000);
			EmployeePage.NextPageBtn.click();
			ActualTotalPage = ActualTotalPage + 1;
			Enablity = EmployeePage.NextPageBtn.isEnabled();
		}
		System.out.println(ActualTotalPage);
		Thread.sleep(2000);

		if (EmployeePage.currentPaginationOption.getText().contentEquals("10 / page")) {
			int ExpectedTotalPage = 3;
			testCase = extent.createTest("STEP-09 Checking Total Page for 10 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EmployeePage.currentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EmployeePage.currentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (EmployeePage.currentPaginationOption.getText().contentEquals("20 / page")) {
			int ExpectedTotalPage = 2;
			testCase = extent.createTest("STEP-10 Checking Total Page for 20 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EmployeePage.currentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EmployeePage.currentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (EmployeePage.currentPaginationOption.getText().contentEquals("30 / page")) {
			int ExpectedTotalPage = 1;
			testCase = extent.createTest("STEP-11 Checking Total Page for 30 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EmployeePage.currentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EmployeePage.currentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (EmployeePage.currentPaginationOption.getText().contentEquals("100 / page")) {
			int ExpectedTotalPage = 1;
			testCase = extent.createTest("STEP-12 Checking Total Page for 100 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EmployeePage.currentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EmployeePage.currentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}

		}

		driver.navigate().refresh();
		Thread.sleep(2000);

	}

//   EMPLOYEE DELETE 
//   ----------------------------

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

	public static void deleteEmployeeConfirm() throws InterruptedException {

		EmployeePage EmployeePg = new EmployeePage();
		PageFactory.initElements(driver, EmployeePg);

		new Actions(driver);
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[5]/div/span[2]"))
				.click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Email']"))
				.sendKeys(email);

		driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Email']"))
				.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

//		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/button[1]")).click();

		String ActualData = EmployeePage.employeeTableBody.getText();
		String ExpectedData = "No Data";

		System.out.println("fsg : " + ActualData);
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

	public static void employeeStatus() {

		String ActualStatus = EmployeePage.firstRowEmployeestatus.getText();
		String ExpectedStatus = "New";

		System.out.println("fsg : " + ActualStatus);
		testCase = extent.createTest("confirm the employee data");
		if (ActualStatus.equals("New")) {
//			Assert.assertEquals(ActualData, ExpectedData);

			testCase.log(Status.INFO, "ActualStatus :- " + ActualStatus);
			testCase.log(Status.INFO, "ExpectedStatus :- " + ExpectedStatus);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, ActualStatus);
		} else {
			testCase.log(Status.INFO, "ActualStatus :- " + ActualStatus);
			testCase.log(Status.INFO, "ExpectedStatus :- " + ExpectedStatus);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, ActualStatus);

		}

	}

//	###################################################################################

//	Employee Delete Element

	public static void deleteElement() throws InterruptedException {

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

		PageFactory.initElements(driver, EmployeePg);
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, SourcePg);

		boolean nextBtn = PlantEquipmentPage.next.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_fifth;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);

			}
			boolean isExist = list.contains(email);
			Thread.sleep(3000);
			nextBtn = PlantEquipmentPage.next.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				PlantEquipmentPage.next.click();
				Thread.sleep(3000);
			} else
				break;

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

	public static void deleteActivatedEmployeeConfirm() throws InterruptedException {

		EmployeePage EmployeePg = new EmployeePage();
		PageFactory.initElements(driver, EmployeePg);

		new Actions(driver);
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[5]/div/span[2]"))
				.click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Email']"))
				.sendKeys(verifiedEmail);

		driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Email']"))
				.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

//	driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/button[1]")).click();

		String ActualData = EmployeePage.firstRowEmployeeEmail.getText();

		String ExpectedData = "loyoj33270@orgria.com";

		System.out.println("fsg : " + ActualData);
		testCase = extent.createTest("verify the row data");
		if (ActualData.equals("loyoj33270@orgria.com")) {

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

	// ###############################################################################
	// ADD THE DELETED EMPLOYEE
	// ###############################################################################

	public static void middleElementClickDeleteAdd() throws InterruptedException {

		PageFactory.initElements(driver, EmployeePg);
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, SourcePg);

		boolean nextBtn = PlantEquipmentPage.next.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_fifth;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);

			}
			boolean isExist = list.contains(email);
			Thread.sleep(3000);
			nextBtn = PlantEquipmentPage.next.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				PlantEquipmentPage.next.click();
				Thread.sleep(3000);
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
						EmployeePage.employeePaginationDelete.click();

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

	public static void deleteEmployeeConfirmDeleteAdd() throws InterruptedException {

		EmployeePage EmployeePg = new EmployeePage();
		PageFactory.initElements(driver, EmployeePg);

//		String SearchEmail = "employeesayan@gmail.com";

		new Actions(driver);
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[5]/div/span[2]"))
				.click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Email']"))
				.sendKeys(email);

		driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Email']"))
				.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

//		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/button[1]")).click();

		String ActualData = EmployeePage.employeeTableBody.getText();
		String ExpectedData = "No Data";

		System.out.println("fsg : " + ActualData);
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

	public static void designationDropdownDeleteAdd() throws InterruptedException {

		PageFactory.initElements(driver, EmployeePg);

		String value = null;
		for (WebElement option : EmployeePage.designationDropdownOptions) {
			value = option.getText();
			Thread.sleep(3000);
			System.out.println(value);
			if (value.contentEquals("Technical Officer agb"))
				Thread.sleep(2000);
			System.out.println(value);
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div[5]")).click();
		}
	}

//		String Actualvaluse = value;
//		String Expectedvalue = "new desig Manager - Testing Manager - Development Assistant Quality Controller Tester Sales Engineer Logistic Officer Store Assistant";
//
//		boolean designation = true;
//		testCase = extent.createTest("DESIGNATION DROPDOWN");
//		try {
//			AssertJUnit.assertEquals(Actualvaluse, Expectedvalue);
//
//		} catch (AssertionError e) {
//			designation = false;
//		}
//		if (designation) {
//			testCase.log(Status.INFO, "Actualvaluse :- " + Actualvaluse);
//			testCase.log(Status.INFO, "Expectedvalue :- " + Expectedvalue);
//			testCase.log(Status.PASS, "Correct option");
//		} else {
//			testCase.log(Status.INFO, "Actualvaluse :- " + Actualvaluse);
//			testCase.log(Status.INFO, "Expectedvalue :- " + Expectedvalue);
//			testCase.log(Status.FAIL, "Wrong option");
//		}
//		Thread.sleep(1000);
//
//	}

	public static void addEmployeeSendValuesDeleteAdd() throws InterruptedException {

		PageFactory.initElements(driver, EmployeePg);

		Thread.sleep(500);
		EmployeePage.firstNameField.click();
		EmployeePage.firstNameField.sendKeys("sayan");

		Thread.sleep(500);
		EmployeePage.lastNameField.click();
		EmployeePage.lastNameField.sendKeys("sayanthan");

		Thread.sleep(500);
		EmployeePage.employeeAddressField.click();
		EmployeePage.employeeAddressField.sendKeys("Jaffna");

		Thread.sleep(500);
		EmployeePage.employeeContactNoField.click();
		EmployeePage.employeeContactNoField.sendKeys("0779999999");

		Thread.sleep(500);
		EmployeePage.employeeEmailField.click();
		EmployeePage.employeeEmailField.sendKeys("employeesayan@gmail.com");

	}

	public static void employeecheckLastAddvalueDeleteAdd() throws InterruptedException {
		PageFactory.initElements(driver, EmployeePg);
		Thread.sleep(2000);
		String actualdata = EmployeePage.employeeFirstRow.getText();
		System.out.println("First row of table : " + actualdata);
		String expecteddata = "sayan";
//	     TestCasePrint("CHECK THE LAST ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE", expecteddata, actualdata);

		boolean firstrow = true;
		testCase = extent.createTest("ADDED DATA COMES FIRST ROW");
		try {
			AssertJUnit.assertEquals(actualdata, expecteddata);

		} catch (AssertionError e) {
			firstrow = false;
		}
		if (firstrow) {
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

	// ###############################################################################
	// ADD THE DELETED EMPLOYEE END
	// ###############################################################################

//	DELETE EMPLOYEE MODAL CLOSING
//	----------------------------------

	public static void deleteModalClose() throws InterruptedException {

		PageFactory.initElements(driver, EmployeePg);

		boolean ActualAfterClick = EmployeePage.deleteEmployeeModal.isDisplayed();

		boolean ExpectedAfterClick = false;

		testCase = extent.createTest("DELETE EMPLOYEE MODAL CLOSING");
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

	// ******************************************************************************************************************
	// Checking total pages for 10,20,30,100 data per page
	// ******************************************************************************************************************
	public static void employeeDataPages() throws InterruptedException {

		// Thread.sleep(2000);
		int ActualTotalPage = 1;
		boolean Enablity = EmployeePage.NextPageBtn.isEnabled();
		while (Enablity) {
			Thread.sleep(1000);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(1000);
			EmployeePage.NextPageBtn.click();
			ActualTotalPage = ActualTotalPage + 1;
			Enablity = EmployeePage.NextPageBtn.isEnabled();
		}
		System.out.println(ActualTotalPage);
		Thread.sleep(2000);

		if (EmployeePage.CurrentPaginationOption.getText().contentEquals("10 / page")) {

			testCase = extent.createTest("Checking Total Page for 10 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EmployeePage.CurrentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EmployeePage.CurrentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (EmployeePage.CurrentPaginationOption.getText().contentEquals("20 / page")) {

			testCase = extent.createTest("Checking Total Page for 20 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage20);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EmployeePage.CurrentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage20);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EmployeePage.CurrentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage20);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (EmployeePage.CurrentPaginationOption.getText().contentEquals("30 / page")) {

			testCase = extent.createTest("Checking Total Page for 30 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage30);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EmployeePage.CurrentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage30);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EmployeePage.CurrentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage30);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}
		} else if (EmployeePage.CurrentPaginationOption.getText().contentEquals("100 / page")) {

			testCase = extent.createTest("Checking Total Page for 100 Data per page");
			try {
				Assert.assertEquals(ActualTotalPage, ExpectedTotalPage100);
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EmployeePage.CurrentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage100);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EmployeePage.CurrentPaginationOption.getText());
				testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage100);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}

		}

		driver.navigate().refresh();
		Thread.sleep(2000);

	}

//	#############################################################################################
//	############################################################################################

//	searching the element
//	----------------------------

	public static void cancelMiddleElementClick() throws InterruptedException {

		PageFactory.initElements(driver, EmployeePg);
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, SourcePg);

		boolean nextBtn = PlantEquipmentPage.next.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_fifth;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);

			}
			boolean isExist = list.contains(email);
			Thread.sleep(3000);
			nextBtn = PlantEquipmentPage.next.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				PlantEquipmentPage.next.click();
				Thread.sleep(3000);
			} else
				break;

		}

	}

//	Employee Delete Element

	public static void cancelDeleteElement() throws InterruptedException {
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

//	############################################################################################
//	##############################################################################################

//	Employee Edit Element

	public static void editElement() throws InterruptedException {
		Thread.sleep(3000);
		try {

			if (driver.findElement(By.xpath(
					"//td[text()='" + email + "']//following-sibling::td[5]//span[@class= 'anticon anticon-edit']"))
					.isDisplayed()) {

				testCase = extent.createTest("Edit Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver.findElement(By.xpath(
						"//td[text()='" + email + "']//following-sibling::td[5]//span[@class= 'anticon anticon-edit']"))
						.isEnabled()) {
					testCase = extent.createTest("Edit Icon Enable");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='" + email
								+ "']//following-sibling::td[5]//span[@class= 'anticon anticon-edit']")).click();

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

//	Employee More View Element Click

	public static void moreViewElement() throws InterruptedException {
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

}
