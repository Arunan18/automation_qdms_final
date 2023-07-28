package com.qa.automation.qdms.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.MaterialSubCategoryPage;
import com.qa.automation.qdms.testcases.material.CheckEditMaterialCancelButtonFunctionalityTest;

public class PropertiesCommonMethods extends DriverIntialization {
	public static int count = 0;
	public static int countRow = 0;
	public static int countOfData=0;

	/**
	 * @author Quenthan
	 * @category :- Element IS Displayed
	 * @param finder : Webelement @findBy(xpath,Css value, Classname, id....)
	 * @param detail : Name of Button/Text/Textbox/Icon.....
	 */
	// Check Webelement is Present
	public static void checkWbeElementq(WebElement finder, String detail) {
		WebDriverWait wit = new WebDriverWait(driver, 20);
		Object x = false;
		try {
			wit.until(ExpectedConditions.elementToBeClickable(finder));
		} catch (Exception e) {
		}
		try {
		
			x = finder.getLocation().x;
			x = true;
			PropertiesCommonMethods.TestReportsq(detail + "-Identify Successfully ✅", "true", x, detail);
		} catch (Exception e) {
			x = false;
			PropertiesCommonMethods.TestReportsq(detail + "-Not Identified ⚠️", "true", x, detail);

		}

	}

	/**
	 * 
	 * @param TestCaseName            :- Testcase Number/ Testcase
	 * @param expectedValue:-Expected Value
	 * @param actualValue             :-actual Value
	 * @param definition              :-About Test type(button name/ text
	 *                                name......)
	 * @author :-Quenthan
	 * @category :-Test Report
	 */
	// Test reports For Properties
	public static void TestReportsq(String TestCaseName, Object expectedValue, Object actualValue, String definition) {
		/*********************************************************************************************************
		 *     THE METHOD IS FOR GENERATING REPORT
		 ********************************************************************************************************/

		boolean position = true;
		ExtentTest testCase = extent.createTest(TestCaseName);
		Object myvalue = null;

		if (actualValue==null) {
			myvalue = "null";
		} 
		else if (actualValue.equals("") ) {
			myvalue = "null";

		}

		else {
			myvalue = actualValue.toString();
		}

		if (expectedValue.equals("")) {
			expectedValue = "null";
		}
		
		else {
			expectedValue=expectedValue.toString();
		}

		try {
			AssertJUnit.assertEquals(myvalue, expectedValue);
		} catch (AssertionError e) {
			position = false;
		}

		if (position) {
			testCase.log(Status.INFO, "Definition    : " + definition);
			testCase.log(Status.INFO, "Actual value  : " + myvalue);
			testCase.log(Status.INFO, "Expected value: " + expectedValue);
			testCase.log(Status.PASS, "TEST PASS ☑🆗");

		} // Define Test

		else {
			testCase.log(Status.INFO, "Define Test   : " + definition);
			testCase.log(Status.INFO, "Actual value  : " + myvalue);
			testCase.log(Status.INFO, "Expected value: " + expectedValue);
			testCase.log(Status.FAIL, "TEST FAIL ❌🔴");
		}

	}

	/**
	 * @author Quenthan
	 * @param excelName  :- Name of Excel.xlsx File(String)
	 * @param sheetName  :- Name of Expected value Excel Sheet (String)
	 * @param I          :- Excel Sheet Row index value of Expected Result
	 * @param finder     :- WebElement of Text
	 *                   :-@FindBy(xpath,id,name,classname.....)
	 * @param definition :- Define Test(Types,module name, )
	 * @param Excal      Sheet Property Data Must Be Blow Order In Column number
	 *                   3-18 :- Visible, Enable, button Hight, button Width,
	 *                   xPostion, yPostion, Background Color, fontColour,
	 *                   borderColor, fontType, fontSize, CheckSpelling, boxShadow,
	 *                   Padding, Cursor, Opacity, FontWeight
	 * 
	 * @category Button Properties
	 */
	// Button Properties
	public static void getButtonPropertiesq(String excelName, String sheetName, String uniqueId, WebElement finder,
			String definition) {

		/*******************************************************************************************************************
		 * get data from excel sheet
		 *******************************************************************************************************************/

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
			// fileIn.close();

//				 
//				
//					wbook = new XSSFWorkbook(filelocation);

		} catch (Exception e) {
			// TODO: handle exception
			PropertiesCommonMethods.TestReportsq("Button Properties Test Fail⚠️- Check file Location or File name❗",
					"Get Propertis", "Fail Get Properties", definition);
		}

		PropertiesCommonMethods.excalRowCount(excelName, sheetName, uniqueId);
		int I = PropertiesCommonMethods.countRow - 1;
		XSSFSheet sheet = wbook.getSheet(sheetName);

		// isVisible
		row = sheet.getRow(I);
		cell = row.getCell(2);
		String iV = dataValue.formatCellValue(cell).toLowerCase();
		// System.out.println(iV);

//		isEnabled
		row = sheet.getRow(I);
		cell = row.getCell(3);
		String iE = dataValue.formatCellValue(cell).toLowerCase();
		// System.out.println(iE);

//		buttonHight
		row = sheet.getRow(I);
		cell = row.getCell(4);
		String butHig = dataValue.formatCellValue(cell);
		// System.out.println(butHig);

//		buttonWidth
		row = sheet.getRow(I);
		cell = row.getCell(5);
		String butWdth = dataValue.formatCellValue(cell);
		// System.out.println(butWdth);

//		xPostion
		row = sheet.getRow(I);
		cell = row.getCell(6);
		String xPos = dataValue.formatCellValue(cell);
		// System.out.println(xPos);

//		yPostion
		row = sheet.getRow(I);
		cell = row.getCell(7);
		String yPoi = dataValue.formatCellValue(cell);
		// System.out.println(yPoi);

//		BackgroundColor
		row = sheet.getRow(I);
		cell = row.getCell(8);
		String bgCol = dataValue.formatCellValue(cell);
		// System.out.println(bgCol);

//		fontColour
		row = sheet.getRow(I);
		cell = row.getCell(9);
		String ftCol = dataValue.formatCellValue(cell);
		// System.out.println(ftCol);

//		borderColor
		row = sheet.getRow(I);
		cell = row.getCell(10);
		String bodCol = dataValue.formatCellValue(cell);
		// System.out.println(bodCol);

//		fontType
		row = sheet.getRow(I);
		cell = row.getCell(11);
		String ftTy = dataValue.formatCellValue(cell);
		// System.out.println(ftTy);

//		fontSize
		row = sheet.getRow(I);
		cell = row.getCell(12);
		String ftSize = dataValue.formatCellValue(cell);
		// System.out.println(ftSize);

//		CheckSpelling
		row = sheet.getRow(I);
		cell = row.getCell(13);
		String btTextSp = dataValue.formatCellValue(cell);
		// System.out.println(btTextSp);

//		boxShadow
		row = sheet.getRow(I);
		cell = row.getCell(14);
		String bBoxShw = dataValue.formatCellValue(cell);
		// System.out.println(bBoxShw);

//		Padding
		row = sheet.getRow(I);
		cell = row.getCell(15);
		String btPad = dataValue.formatCellValue(cell);
		// System.out.println(btPad);

//		Cursor
		row = sheet.getRow(I);
		cell = row.getCell(16);
		String btCur = dataValue.formatCellValue(cell);
		// System.out.println(btCur);

//		Opacity
		row = sheet.getRow(I);
		cell = row.getCell(17);
		String btOpq = dataValue.formatCellValue(cell);
		// System.out.println(btOpq);

//		FontWeight
		row = sheet.getRow(I);
		cell = row.getCell(18);
		String btFotWt = dataValue.formatCellValue(cell);
		// System.out.println(btFotWt);

		/*******************************************************************************************************************
		 * Checking Button Properties
		 *******************************************************************************************************************/
		PropertiesCommonMethods.checkWbeElementq(finder, definition);

		Boolean isVisible = finder.isDisplayed();
		PropertiesCommonMethods.TestReportsq("1.Button Visible", iV, isVisible, definition);
		if (isVisible == true) {
			Boolean isEnabled = finder.isEnabled();
			PropertiesCommonMethods.TestReportsq("2.Button Enable", iE, isEnabled, definition);

			
				int buttonHight = finder.getSize().height;
				PropertiesCommonMethods.TestReportsq("3.Button Hight", butHig, buttonHight, definition);

				int buttonWidth = finder.getSize().width;
				PropertiesCommonMethods.TestReportsq("4.Button width", butWdth, buttonWidth, definition);

				int xPostion = finder.getLocation().x;
				PropertiesCommonMethods.TestReportsq("5.Button X position", xPos, xPostion, definition);

				int yPostion = finder.getLocation().y;
				PropertiesCommonMethods.TestReportsq("6.Button Y Position", yPoi, yPostion, definition);

				String backgroundColor = finder.getCssValue("background-color");
				PropertiesCommonMethods.TestReportsq("7.Button Backround Colour", bgCol, backgroundColor, definition);

				String fontColour = finder.getCssValue("color");
				PropertiesCommonMethods.TestReportsq("8.Button Font Text colour", ftCol, fontColour, definition);

				String borderColor = finder.getCssValue("border-color");
				PropertiesCommonMethods.TestReportsq("9.Button Border Colour", bodCol, borderColor, definition);

				String fontType = finder.getCssValue("font-family");
				PropertiesCommonMethods.TestReportsq("10.Button Text Font Types", ftTy, fontType, definition);

				String fontSize = finder.getCssValue("font-Size");
				PropertiesCommonMethods.TestReportsq("11.Button Text Font-Size", ftSize, fontSize, definition);

				String checkSpelling = finder.getText();
				PropertiesCommonMethods.TestReportsq("12.Button Check Button Text Spelling", btTextSp, checkSpelling,
						definition);

				String boxShadow = finder.getCssValue("box-shadow");
				PropertiesCommonMethods.TestReportsq("13.Button Box Shadow", bBoxShw, boxShadow, definition);

				String padding = finder.getCssValue("Padding");
				PropertiesCommonMethods.TestReportsq("14.Button Padding ", btPad, padding, definition);

				String cursor = finder.getCssValue("Cursor");
				PropertiesCommonMethods.TestReportsq("15.Button Cursor Type", btCur, cursor, definition);

				String opacity = finder.getCssValue("Opacity");
				PropertiesCommonMethods.TestReportsq("16.Button Opacity", btOpq, opacity, definition);

				String fontWeight = finder.getCssValue("font-weight");
				PropertiesCommonMethods.TestReportsq("17.Button Font Weight", btFotWt, fontWeight, definition);
			

			

		}

		else {
			PropertiesCommonMethods.TestReportsq("Button Is Not Visible❗Properties Checking Terminated⚠️",
					"Button Displayed", "Button Not Displayed", definition);
		}

//					try {
//						
//						fileIn.close();
//					} catch (IOException e) {
//						extent.createTest("Excel File Not Closed⚠️");
//						// TODO Auto-generated catch block
////						e.printStackTrace();
//					}

	}

	/**
	 * @author Quenthan
	 * @param excelFileName :- Name of Excel.xlsx File(String)
	 * @param sheetName:-   expacted data sheet name
	 * @param I             :- Excel Expacted data column index value
	 * @param finder        :- WebElement of Text
	 *                      :-@FindBy(xpath,id,name,classname.....)
	 * @param definition    :- Define Test(Types,module name, )
	 * @param Excal         Sheet Property Data Must Be Blow Order In Row number
	 *                      2-16 :- Search Box Visibility, Search Box Enablity,
	 *                      Search Box border-color, Search Box Hight, Search Box
	 *                      Width, Search Box xPosition, Search Box yPosition,
	 *                      Search Box background color, Search Box cursor-pointer,
	 *                      Search Box overflow, Search Box margin, Search Box
	 *                      z-index, Search Box content, Inside Of Modal, Outside Of
	 *                      Modal
	 * @category Button Properties
	 */
	// Search Box Properties
	public static void searchBoxPropertiesq(String excelFileName, String sheetName, String uniqueId, WebElement finder,
			String definition) {

		/*******************************************************************************************************************
		 * Get data from excel sheet
		 *******************************************************************************************************************/

		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		Actions action = new Actions(driver);
		XSSFWorkbook wbook = null;
		FileInputStream fileIn = null;
		String filelocation;

		try {
			filelocation = "./src/test/resources/Excel/" + excelFileName;

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			fileIn.close();

		} catch (Exception e) {
			// TODO: handle exception
			PropertiesCommonMethods.TestReportsq("Search Box Properties Test Fail⚠️- Check file Location or File name❗",
					"Get Propertis", "Fail Get Properties", definition);
		}

		XSSFSheet sheet = wbook.getSheet(sheetName);
		PropertiesCommonMethods.excalRowCount(excelFileName, sheetName, uniqueId);
	     int r=	PropertiesCommonMethods.countRow-1;
		

		row = sheet.getRow(r);
		cell = row.getCell(2);
		String oN = dataValue.formatCellValue(cell).toLowerCase();
		
		// System.out.println(oN);

		row = sheet.getRow(r);
		cell = row.getCell(3);
		String tW = dataValue.formatCellValue(cell).toLowerCase();
		// System.out.println(tW);

		row = sheet.getRow(r);
		cell = row.getCell(4);
		String tH = dataValue.formatCellValue(cell);
		// System.out.println(tH);

		row = sheet.getRow(r);
		cell = row.getCell(5);
		String fO = dataValue.formatCellValue(cell);
		// System.out.println(fO);

		row = sheet.getRow(r);
		cell = row.getCell(6);
		String fI = dataValue.formatCellValue(cell);
		// System.out.println(fI);

		row = sheet.getRow(r);
		cell = row.getCell(7);
		String sI = dataValue.formatCellValue(cell);
		// System.out.println(sI);

		row = sheet.getRow(r);
		cell = row.getCell(8);
		String sE = dataValue.formatCellValue(cell);
		// System.out.println(sE);

		row = sheet.getRow(r);
		cell = row.getCell(9);
		String Et = dataValue.formatCellValue(cell);
		// System.out.println(Et);

		row = sheet.getRow(r);
		cell = row.getCell(10);
		String nIn = dataValue.formatCellValue(cell);
		// System.out.println(nIn);

		row = sheet.getRow(r);
		cell = row.getCell(11);
		String tN = dataValue.formatCellValue(cell);
		// System.out.println(tN);

		row = sheet.getRow(r);
		cell = row.getCell(12);
		String elv = dataValue.formatCellValue(cell);
		// System.out.println(elv);

		row = sheet.getRow(r);
		cell = row.getCell(13);
		String twl = dataValue.formatCellValue(cell);
		// System.out.println(twl);

		row = sheet.getRow(r);
		cell = row.getCell(14);
		String theteen = dataValue.formatCellValue(cell);
		// System.out.println(theteen);

		row = sheet.getRow(r);
		cell = row.getCell(15);
		String fteen = dataValue.formatCellValue(cell).toLowerCase();
		// System.out.println(fteen);

		row = sheet.getRow(r);
		cell = row.getCell(16);
		String fivteen = dataValue.formatCellValue(cell).toLowerCase();
		// System.out.println(fivteen);

//			row = sheet.getRow(16);
//			cell = row.getCell(I);
//			String sixteen = dataValue.formatCellValue(cell);
		// System.out.println(sixteen);

		/*******************************************************************************************************************
		 * Checking Scerch Box Properties
		 *******************************************************************************************************************/
		PropertiesCommonMethods.checkWbeElementq(finder, definition);
		// Visibility
		Boolean isVisible = finder.isDisplayed();
		PropertiesCommonMethods.TestReportsq("1.Serach Box Visible", oN, isVisible, definition);
		if (isVisible == true) {
			// Enablity
			Boolean isEnabled = finder.isEnabled();
			PropertiesCommonMethods.TestReportsq("2.Serach BoxEnable", tW, isEnabled, definition);

			

//								Modal border-color
				String bfillC = finder.getCssValue("border-colour");
				PropertiesCommonMethods.TestReportsq("3.Serach Box Border Color", tH, bfillC, definition);

//								Modal Hight
				int buttonHight = finder.getSize().height;
				PropertiesCommonMethods.TestReportsq("4.Serach Box Hight", fO, buttonHight, definition);
				// Modal Width
				int buttonWidth = finder.getSize().width;
				PropertiesCommonMethods.TestReportsq("5.Serach Box Width", fI, buttonWidth, definition);

				// Modal xPosition
				int xPostion = finder.getLocation().x;
				PropertiesCommonMethods.TestReportsq("6.Serach Box X position", sI, xPostion, definition);

				// Modal yPosition
				int yPostion = finder.getLocation().y;
				PropertiesCommonMethods.TestReportsq("7.Serach Box Y Position", sE, yPostion, definition);

//								Modal background color
				String backgroundColor = finder.getCssValue("background-color");
				PropertiesCommonMethods.TestReportsq("8.Serach Box Background Color", Et, backgroundColor, definition);

//								Modal cursor-pointer
				String fontColour = finder.getCssValue("cursor");
				PropertiesCommonMethods.TestReportsq("9.Serach Box Cursor Pointer", nIn, fontColour, definition);

//								Modal overflow
				String borderColor = finder.getCssValue("overflow");
				PropertiesCommonMethods.TestReportsq("10.Serach Box Overflow", tN, borderColor, definition);

//								Modal margin
				String margin = finder.getCssValue("margin");
				PropertiesCommonMethods.TestReportsq("11.Serach Box Margin", elv, margin, definition);

//								Modal z-index
				String zindax = finder.getCssValue("z-index");
				PropertiesCommonMethods.TestReportsq("12.Serach Box z-index", twl, zindax, definition);

//								modal content
				String content = finder.getText();
				PropertiesCommonMethods.TestReportsq("13.Serach Box Content", theteen, content, definition);
				System.out.println(content+"**************************************************");
//							After Click Inside Of Modal	
				finder.click();
				Boolean inClick = finder.isDisplayed();
				PropertiesCommonMethods.TestReportsq("14.Serach Box After Click Inside Of Box", fteen, inClick,
						definition);

//							After Click Outside Of Modal	
				action.moveByOffset(0, 0).click().build().perform();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
				}
				Boolean outside = true;
				try {
					outside = finder.isDisplayed();
				} catch (Exception e) {
					outside = false;
				}
				PropertiesCommonMethods.TestReportsq("After Click Outside Of Box", fivteen, outside, definition);

//								
 
			

		}

		else {
			PropertiesCommonMethods.TestReportsq("Search Box Is Not Visible❗Properties Checking Terminated⚠️",
					"Modal Displayed", "Modal Not Displayed", definition);
		}

		try {
			fileIn.close();
		} catch (IOException e) {
			extent.createTest("Excel File Not Closed⚠️");
			// PropertiesCommonMethods.TestReportsq("Excel File Not Closed⚠️", "Close
			// Excel", "Excel Not Closed", "Execl Sheet");
			// TODO Auto-generated catch block
//							e.printStackTrace();
		}

	}

	/**
	 * @author Quenthan
	 * @category Check Text Properties
	 * @param excelFileName:-Name of Excel.xlsx File(String)
	 * @param sheetName           :-Name of Expated data sheet
	 * @param I                   :-Expated data coloum intex value
	 * @param finder              :-WebElement of Text
	 *                            :-@FindBy(xpath,id,name,classname.....)
	 * @param definition          :- Define Test(Types,module name, ) Excal Sheet
	 *                            Property Data Must Be Blow Order In Row number
	 *                            2-21:- Visibility, Enablity, Text Align, Padding,
	 *                            xPosition, yPosition, Text-Line-Height,
	 *                            Font-color, Text-Transformation, Font-style ,
	 *                            Font-size, Check Text Spelling, Text Margin, Text
	 *                            Shadow, Word Spacing, Text-Decoration, Letter
	 *                            Spacing, Text-Vertical -Alignment, Text -Indent,
	 *                            Text -Orientation, Font-Family
	 * 
	 */
	// Text Properties
	public static void getTextPropertiesq(String excelFileName, String sheetName, String uniqueId, WebElement finder,
			String definition) {

		/*******************************************************************************************************************
		 * get data from excel sheet
		 *******************************************************************************************************************/

		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		XSSFWorkbook wbook = null;
		String filelocation;

		try {
			filelocation = "./src/test/resources/Excel/" + excelFileName;

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			fileIn.close();

		} catch (Exception e) {
			// TODO: handle exception
			PropertiesCommonMethods.TestReportsq("Text Properties Test Fail⚠️- Check file Location or File name❗",
					"Get Propertis", "Fail Get Properties", definition);
		}

		XSSFSheet sheet = wbook.getSheet(sheetName);
		PropertiesCommonMethods.excalRowCount(excelFileName, sheetName, uniqueId);
		int r=PropertiesCommonMethods.countRow-1;

		row = sheet.getRow(r);
		cell = row.getCell(2);
		String iV = dataValue.formatCellValue(cell).toLowerCase();
		// System.out.println(iV);

		row = sheet.getRow(r);
		cell = row.getCell(3);
		String iE = dataValue.formatCellValue(cell).toLowerCase();
		// System.out.println(iE);

		row = sheet.getRow(r);
		cell = row.getCell(4);
		String butHig = dataValue.formatCellValue(cell);
		// System.out.println(butHig);

		row = sheet.getRow(r);
		cell = row.getCell(5);
		String butWdth = dataValue.formatCellValue(cell);
		// System.out.println(butWdth);

		row = sheet.getRow(r);
		cell = row.getCell(6);
		String xPos = dataValue.formatCellValue(cell);
		// System.out.println(xPos);

		row = sheet.getRow(r);
		cell = row.getCell(7);
		String yPoi = dataValue.formatCellValue(cell);
		// System.out.println(yPoi);

		row = sheet.getRow(r);
		cell = row.getCell(8);
		String bgCol = dataValue.formatCellValue(cell);
		// System.out.println(bgCol);

		row = sheet.getRow(r);
		cell = row.getCell(9);
		String ftCol = dataValue.formatCellValue(cell);
		// System.out.println(ftCol);

		row = sheet.getRow(r);
		cell = row.getCell(10);
		String bodCol = dataValue.formatCellValue(cell);
		// System.out.println(bodCol);

		row = sheet.getRow(r);
		cell = row.getCell(11);
		String ftTy = dataValue.formatCellValue(cell);
		// System.out.println(ftTy);

		row = sheet.getRow(r);
		cell = row.getCell(12);
		String ftSize = dataValue.formatCellValue(cell);
		// System.out.println(ftSize);

		row = sheet.getRow(r);
		cell = row.getCell(13);
		String btTextSp = dataValue.formatCellValue(cell);
		// System.out.println(btTextSp);

		row = sheet.getRow(r);
		cell = row.getCell(14);
		String bBoxShw = dataValue.formatCellValue(cell);
		// System.out.println(bBoxShw);

		row = sheet.getRow(r);
		cell = row.getCell(15);
		String btPad = dataValue.formatCellValue(cell);
		// System.out.println(btPad);

		row = sheet.getRow(r);
		cell = row.getCell(16);
		String btCur = dataValue.formatCellValue(cell);
		// System.out.println(btCur);

		row = sheet.getRow(r);
		cell = row.getCell(17);
		String btOpq = dataValue.formatCellValue(cell);
		// System.out.println(btOpq);

		row = sheet.getRow(r);
		cell = row.getCell(18);
		String btFotWt = dataValue.formatCellValue(cell);
		// System.out.println(btFotWt);

		row = sheet.getRow(r);
		cell = row.getCell(19);
		String tDn = dataValue.formatCellValue(cell);
		// System.out.println(tDn);

		row = sheet.getRow(r);
		cell = row.getCell(20);
		String tOn = dataValue.formatCellValue(cell);
		// System.out.println(tOn);

		row = sheet.getRow(r);
		cell = row.getCell(21);
		String fTf = dataValue.formatCellValue(cell);
		// System.out.println(fTf);

		row = sheet.getRow(r);
		cell = row.getCell(22);
		String fgh = dataValue.formatCellValue(cell);
		// System.out.println(fgh);

		/*******************************************************************************************************************
		 * Checking Text Properties
		 *******************************************************************************************************************/
		PropertiesCommonMethods.checkWbeElementq(finder, definition);
		// Visibility
		Boolean isVisible = finder.isDisplayed();
		PropertiesCommonMethods.TestReportsq("1.Text Visible", iV, isVisible, definition);
		if (isVisible == true) {
			// Enablity
			Boolean isEnabled = finder.isEnabled();
			PropertiesCommonMethods.TestReportsq("2.Enable", iE, isEnabled, definition);

			
				// Text Align
				String buttonHight = finder.getCssValue("text-align");
				PropertiesCommonMethods.TestReportsq("3.Text Align", butHig, buttonHight, definition);

				// Padding
				String padg = finder.getCssValue("padding");
				PropertiesCommonMethods.TestReportsq("4.Text Padding", butWdth, padg, definition);

				// xPosition
				int xPostion = finder.getLocation().x;
				PropertiesCommonMethods.TestReportsq("5.Text X position", xPos, xPostion, definition);

				// yPosition
				int yPostion = finder.getLocation().y;
				PropertiesCommonMethods.TestReportsq("6.Text Y Position", yPoi, yPostion, definition);

				// Text-Line-Height
				String backgroundColor = finder.getCssValue("line-height");
				PropertiesCommonMethods.TestReportsq("7.Text Line-Height", bgCol, backgroundColor, definition);

				// Font-color
				String fontColour = finder.getCssValue("color");
				PropertiesCommonMethods.TestReportsq("8.Text Font-color", ftCol, fontColour, definition);

				// Text-Transformation
				String borderColor = finder.getCssValue("text-transform");
				PropertiesCommonMethods.TestReportsq("9.Text Transformation", bodCol, borderColor, definition);

				// Font-style
				String fontType = finder.getCssValue("font-style");
				PropertiesCommonMethods.TestReportsq("10.Text Font style", ftTy, fontType, definition);

				// Font-size
				String fontSize = finder.getCssValue("font-Size");
				PropertiesCommonMethods.TestReportsq("11.Text Font Size", ftSize, fontSize, definition);

				// Text-spelling
				String checkSpelling = finder.getText();
				PropertiesCommonMethods.TestReportsq("12.Text Text Spelling", btTextSp, checkSpelling, definition);

				// Margin
				String boxShadow = finder.getCssValue("margin");
				PropertiesCommonMethods.TestReportsq("13.Text Margin", bBoxShw, boxShadow, definition);

				// Shadow
				String padding = finder.getCssValue("box-shadow");
				PropertiesCommonMethods.TestReportsq("14.Text Shadow ", btPad, padding, definition);

				// Word Spacing
				String cursor = finder.getCssValue("word-spacing");
				PropertiesCommonMethods.TestReportsq("15.Text Spacing", btCur, cursor, definition);

				// Text-Decoration
				String opacity = finder.getCssValue("text-decoration");
				PropertiesCommonMethods.TestReportsq("16.Text Decoration", btOpq, opacity, definition);

				// Letter Spacing
				String fontWeight = finder.getCssValue("letter-spacing");
				PropertiesCommonMethods.TestReportsq("17.Text Letter Spacing", btFotWt, fontWeight, definition);

				// Text-Vertical-Alignment
				String vrtAlign = finder.getCssValue("vertical-align");
				PropertiesCommonMethods.TestReportsq("18.Text Alignment", tDn, vrtAlign, definition);

				// Text-Indent
				String txInt = finder.getCssValue("text-indent");
				PropertiesCommonMethods.TestReportsq("19.Text Indent", tOn, txInt, definition);

				// Text-Orientation
				String txOr = finder.getCssValue("text-orientation");
				PropertiesCommonMethods.TestReportsq("20.Text Orientation", fTf, txOr, definition);

				// Font-Family
				String fontfam = finder.getCssValue("font-family");
				PropertiesCommonMethods.TestReportsq("21.Text Font Family", fgh, fontfam, definition);

			

		}

		else {
			PropertiesCommonMethods.TestReportsq("Text Is Not Visible❗Properties Checking Terminated⚠️",
					"Text Displayed", "Text Not Displayed", definition);
		}

		try {
			fileIn.close();
		} catch (IOException e) {
			extent.createTest("Excel File Not Closed⚠️");
			// TODO Auto-generated catch block
//						e.printStackTrace();
		}

	}

	/*********************************************************************************************************
	 *   Common   THE METHOD IS FOR GENERATING REPORT
	 ********************************************************************************************************/

	public static void cTestReports(String TestCaseName, Object expectedValue, Object actualValue, String definition) {
		boolean position = true;
		ExtentTest testCase = extent.createTest(TestCaseName);
		Object myvalue = null;

		if (actualValue == null) {
			myvalue = actualValue;
		} else if (actualValue == "") {
			myvalue = null;

		}

		else {
			myvalue = actualValue.toString();
		}

		if (expectedValue == "") {
			expectedValue = null;

		}else {
			expectedValue=	expectedValue.toString();
		}

		try {
			AssertJUnit.assertEquals(myvalue, expectedValue);
		} catch (AssertionError e) {
			position = false;
		}

		if (position) {
			testCase.log(Status.INFO, "Definition    : " + definition);
			testCase.log(Status.INFO, "Actual value  : " + myvalue);
			testCase.log(Status.INFO, "Expected value: " + expectedValue);
			testCase.log(Status.PASS, "TEST PASS ☑🆗");

		} // Define Test

		else {
			testCase.log(Status.INFO, "Define Test   : " + definition);
			testCase.log(Status.INFO, "Actual value  : " + myvalue);
			testCase.log(Status.INFO, "Expected value: " + expectedValue);
			testCase.log(Status.FAIL, "TEST FAIL ❌🔴");
		}

	}

	/**
	 * @author Quenthan
	 * @category :-Icon properties
	 * @param excelFileName :-Name of Excel.xlsx File(String)
	 * @param sheetName     :-expacted value excel sheet name
	 * @param testCaseNo    :-Excel Test case Number
	 * @param finder        :-WebElement of Text
	 *                      :-@FindBy(xpath,id,name,classname.....)
	 * @param definition    :-Define Test(Types,module name, )
	 * @param Excal         Sheet Property Data Must Be Blow Order In Column C-L :-
	 *                      Visibilitty, Enablity, Icon fill color, Icon Hight, Icon
	 *                      Width, x- position, y- position, Icon background color,
	 *                      Cursor-pointer
	 */
	public static void getIconPPt(String excelFileName, String sheetName, String testCaseNo, WebElement finder,
			String definition) {

		/*******************************************************************************************************************
		 * get Icon Expacted data from excel sheet
		 *******************************************************************************************************************/

		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		XSSFWorkbook wbook = null;
		String filelocation;

		try {
			filelocation = "./src/test/resources/Excel/" + excelFileName;

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			fileIn.close();

		} catch (Exception e) {
			// TODO: handle exception
			PropertiesCommonMethods.TestReportsq("Icon Properties Test Fail⚠️- Check file Location or File name❗",
					"Get Propertis", "Fail Get Properties", definition);
		}

		XSSFSheet sheet = wbook.getSheet(sheetName);
		PropertiesCommonMethods.excalRowCount(excelFileName, sheetName, testCaseNo);
		int I = PropertiesCommonMethods.countRow - 1;
		row = sheet.getRow(I);
		cell = row.getCell(2);
		String oN = dataValue.formatCellValue(cell).toLowerCase();
		// System.out.println(oN);

		row = sheet.getRow(I);
		cell = row.getCell(3);
		String tW = dataValue.formatCellValue(cell).toLowerCase();
		// System.out.println(tW);

		row = sheet.getRow(I);
		cell = row.getCell(4);
		String tH = dataValue.formatCellValue(cell);
		// System.out.println(tH);

		row = sheet.getRow(I);
		cell = row.getCell(5);
		String fO = dataValue.formatCellValue(cell);
		// System.out.println(fO);

		row = sheet.getRow(I);
		cell = row.getCell(6);
		String fI = dataValue.formatCellValue(cell);
		// System.out.println(fI);

		row = sheet.getRow(I);
		cell = row.getCell(7);
		String sI = dataValue.formatCellValue(cell);
		// System.out.println(sI);

		row = sheet.getRow(I);
		cell = row.getCell(8);
		String sE = dataValue.formatCellValue(cell);
		// System.out.println(sE);

		row = sheet.getRow(I);
		cell = row.getCell(9);
		String Et = dataValue.formatCellValue(cell);
		// System.out.println(Et);

		row = sheet.getRow(I);
		cell = row.getCell(10);
		String nIn = dataValue.formatCellValue(cell);
		// System.out.println(nIn);

		row = sheet.getRow(I);
		cell = row.getCell(11);
		String tN = dataValue.formatCellValue(cell);
		// System.out.println(tN);

		/*******************************************************************************************************************
		 * Checking Text Properties
		 *******************************************************************************************************************/
		PropertiesCommonMethods.checkWbeElementq(finder, definition);
		// Visibility
		Boolean isVisible = finder.isDisplayed();
		PropertiesCommonMethods.TestReportsq("1.Icon visuble", oN, isVisible, definition);
		if (isVisible == true) {
			// Enablity
			Boolean isEnabled = finder.isEnabled();
			PropertiesCommonMethods.TestReportsq("2.Icon enalled", tW, isEnabled, definition);

			
//								icon fill color
				String bfillC = finder.getCssValue("color");
				PropertiesCommonMethods.TestReportsq("3.Icon fill color", tH, bfillC, definition);

//								icon Hight
				int buttonHight = finder.getSize().height;
				PropertiesCommonMethods.TestReportsq("4.Icon Hight", fO, buttonHight, definition);
				// Icon Width
				int buttonWidth = finder.getSize().width;
				PropertiesCommonMethods.TestReportsq("5.Icon width", fI, buttonWidth, definition);

				// xPosition
				int xPostion = finder.getLocation().x;
				PropertiesCommonMethods.TestReportsq("6.Icon X position", sI, xPostion, definition);

				// yPosition
				int yPostion = finder.getLocation().y;
				PropertiesCommonMethods.TestReportsq("7.Icon Y Position", sE, yPostion, definition);

//								icon background color
				String backgroundColor = finder.getCssValue("background-color");
				PropertiesCommonMethods.TestReportsq("8.Icon Background color", Et, backgroundColor, definition);

//								cursor-pointer
				String fontColour = finder.getCssValue("cursor");
				PropertiesCommonMethods.TestReportsq("9.Cursor pointer", nIn, fontColour, definition);

//								icon image

				String borderColor = finder.getAttribute("icon-image");
				 System.out.println("gshghg:-"+borderColor);
				PropertiesCommonMethods.TestReportsq("10.Icon image", tN, borderColor, definition);

		

		}

		else {
			PropertiesCommonMethods.TestReportsq("Icon Is Not Visible❗Properties Checking Terminated⚠️",
					"Text Displayed", "Text Not Displayed", definition);
		}

		try {
			fileIn.close();
		} catch (IOException e) {
			extent.createTest("Excel File Not Closed⚠️");
			// TODO Auto-generated catch block
//							e.printStackTrace();
		}
	}

	public static int CountOfData(WebElement table) {
		int num = 0;
		int counte = 0;
		List<WebElement> allrows = null;

		for (int i = 0; i < 103; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			}
			allrows = table.findElements(By.cssSelector("tbody tr"));
			num = allrows.size() - 1;
			counte = counte + num;
			boolean nextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
					.isEnabled();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
			}

			if (nextPage == true) {
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}
			} else {
				break;

			}
		}
		count = counte;
		return count;

	}

	/**
	 * 
	 * @param column      :-Web Table Search Data Column
	 * @param clickColumn :-Web Table Target Poin Column(edit / delete/ view
	 *                    /discription)
	 * @param table       :-Table Locator
	 * @param action      :-"edit"/"delete"/"Description"/"Add Key Test"
	 * @param r           :-Search data Row
	 * @param c           :-Search data Column
	 */
	public static void actionS(int column, int clickColumn, WebElement table, String action, String wookBook,
			String tab, int r, int c) {

		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;
		Boolean not = false;
		try {
			filelocation = "./src/test/resources/Excel/" + wookBook;

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);

		} catch (Exception e) {
			// TODO: handle exception
		}

		XSSFSheet sheet = wbook.getSheet(tab);

		row = sheet.getRow(r);
		cell = row.getCell(c);
		String iV = dataValue.formatCellValue(cell);
		// System.out.println(iV);

		int i = 0;
		String value = null;
		String value2 = null;
		if (action == "delete") {
			value = ".anticon-delete";
			value2 = ".ant-popover-content";
		} else if (action == "edit") {
			value = ".anticon-edit";
			value2 = ".ant-modal-content";

		}

		else if (action == "Description") {
			value = ".anticon-container";
			value2 = ".ant-modal-content";

		} else if (action == "Add Key Test") {
			value = ".anticon-funnel-plot";
			value2 = ".ant-modal-content";

		}

		boolean rept = true;
		List<WebElement> allrows = null;
		int num;

		while (rept == true) {
			allrows = table.findElements(By.cssSelector("tbody tr"));
			num = allrows.size();
			for (i = 0; i < num; i++) {

				List<WebElement> rows = allrows.get(i).findElements(By.tagName("td"));
				String name = rows.get(column).getText();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
				}
				rept = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
				// System.out.println(rept);
				if (name.equals(iV)) {
					WebElement input = rows.get(clickColumn).findElement(By.cssSelector(value));
					Boolean dis = input.isDisplayed();
					PropertiesCommonMethods.cTestReports("1." + action.toUpperCase() + "-Icon Displayed", "true", dis,
							action + "-Icon");

					if (dis == true) {
						Boolean ena = input.isEnabled();
						PropertiesCommonMethods.cTestReports("2." + action.toUpperCase() + "-Icon Enable", "true", ena,
								action + "-Icon");
						if (ena == true) {
							input.click();
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {

							}
							Boolean popup = driver.findElement(By.cssSelector(value2)).isDisplayed();
							PropertiesCommonMethods.cTestReports(
									action.toUpperCase() + "-Pop Up Is Displayed, " + action + "-Icon Is Clicked",
									"true", popup, action + "-Icon");
							rept = false;
							not = true;
							break;
						}
					}

				}

			}
			if (rept == true) {
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

				}

			}

			else if (rept == false & not == false) {
				extent.createTest("SEARCHING DATA NOT FIND IN TABLE");

			}
		}
	}

	public static void excalRowCount(String workBook, String sheetname, String TestNumber) {
		FileInputStream fileIn = null;
		String value = null;
		DataFormatter daaa = new DataFormatter();

		Boolean stop = false;
		int i = 0;
		int count = 0;
		XSSFRow rows = null;
		String filelocation = "./src/test/resources/Excel/" + workBook;
		XSSFWorkbook wbook = null;
		try {

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			//

//			 
//			
//				wbook = new XSSFWorkbook(filelocation);

		} catch (Exception e) {
			// TODO: handle exception
			// ("Button Properties Test Fail⚠️- Check file Location or File name❗", "Get
			// Propertis", "Fail Get Properties");
		}
		XSSFSheet sheets = wbook.getSheet(sheetname);
		int a = sheets.getLastRowNum() + 2;

		for (i = 0; i < a; i++) {
			rows = sheets.getRow(i);
			if (rows == null) {
				count = count + 1;

			} else {
				XSSFCell cell = rows.getCell(0);
				value = daaa.formatCellValue(cell);

				count = count + 1;

				if (value.equals(TestNumber)) {
					stop = true;
					break;

				}

			}

		}
		countRow = count;
		if (stop == false) {
			extent.createTest(TestNumber + "-Not In Excel");
			

		}
		try {
			fileIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

	}

	public static void validation(String Wookbook, String tab, String uniqueID, WebElement textBox,
			WebElement validationText, WebElement button, String define) {
		DataFormatter dataValue = new DataFormatter();
		XSSFWorkbook wbook = null;
		XSSFRow row = null;
		XSSFCell cell = null;

		try {
			String filelocation = "./src/test/resources/Excel/" + Wookbook;
			FileInputStream fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			fileIn.close();
		} catch (Exception e) {
		}
		PropertiesCommonMethods.excalRowCount(Wookbook, tab, uniqueID);
		XSSFSheet sheet = wbook.getSheet(tab);
		int r = PropertiesCommonMethods.countRow - 1;
		int stop = sheet.getLastRowNum() + 2;
		for (int i = r; i < stop; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(3);
			String type = dataValue.formatCellValue(cell);
			if (type.equals("break")) {
				break;
			}
			row = sheet.getRow(i);
			cell = row.getCell(4);
			String validation1 = dataValue.formatCellValue(cell);
			row = sheet.getRow(i);
			cell = row.getCell(5);
			String expated1 = dataValue.formatCellValue(cell);
			textBox.click();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			textBox.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			textBox.sendKeys(validation1);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}
			button.click();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String textErrMe = null;
			try {
				textErrMe = validationText.getText();
			} catch (Exception e) {
				break;
			}
			PropertiesCommonMethods.cTestReports(type, expated1, textErrMe, define);

		}

	}
	public static int CountOfData2(WebElement table) {
		int num = 0;
		int counte = 0;
		boolean nextPage=true;
		List<WebElement> allrows = null;

		 while (nextPage==true) {
			{
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
				}
				allrows = table.findElements(By.cssSelector("tbody tr"));
				num = allrows.size();
				System.err.println("err"+allrows.size());
				System.err.println(num);
				counte = counte + num;
				 try {
					nextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
							.isEnabled();
				} catch (Exception e) {
					nextPage=false;
					
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}

				if (nextPage == true) {
					driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
					}
				} else {
					break;

				}
			} 
		}
		countOfData = counte;
		return countOfData;
	}

}
