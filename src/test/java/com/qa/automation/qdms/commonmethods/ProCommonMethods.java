//Properties Common Methoids 
/*24.04.2023
 * S.Quenthan
 * 
 */

package com.qa.automation.qdms.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.automation.qdms.base.DriverIntialization;


public class ProCommonMethods extends DriverIntialization {
	
	// Search Box Properties
	/**
	 * @author Quenthan
	 * @param excelFileName:-Name of Excel.xlsx File(String)
	 * @param sheetName :-expacted data sheet name
	 * @param UniqId    :-Test Case Id
	 * @param finder    :-WebElement of Text(xpath,id,name,classname.....)
	 * @param definition:-Define Test(Types,module name, )
	 * @param Sheet Property Data Must Be Blow Order In Row number :-:- Modal Visibility, Modal Enablity,
	 *                      Modal border-color, Modal Hight, Modal
	 *                      Width, Modal xPosition, Modal yPosition,
	 *                      Modal background color, Modal cursor-pointer,
	 *                      Modal overflow, Modal margin, Modal
	 *                      z-index,Modal Title, Modal content, Inside Of Modal, Outside Of
	 *                      Modal
	 */
	public static void modal(String excelFileName, String sheetName, String UniqId, WebElement finder,
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
PropertiesCommonMethods.excalRowCount(excelFileName, sheetName, UniqId);
int I=PropertiesCommonMethods.countRow-1;
		XSSFSheet sheet = wbook.getSheet(sheetName);
        
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

		row = sheet.getRow(I);
		cell = row.getCell(12);
		String elv = dataValue.formatCellValue(cell);
		// System.out.println(elv);

		row = sheet.getRow(I);
		cell = row.getCell(13);
		String twl = dataValue.formatCellValue(cell);
		// System.out.println(twl);

		row = sheet.getRow(I);
		cell = row.getCell(14);
		String theteen = dataValue.formatCellValue(cell);
		// System.out.println(theteen);

		row = sheet.getRow(I);
		cell = row.getCell(15);
		String fteen = dataValue.formatCellValue(cell);
		// System.out.println(fteen);

		row = sheet.getRow(I);
		cell = row.getCell(16);
		String fivteen = dataValue.formatCellValue(cell);
		// System.out.println(fivteen);

			row = sheet.getRow(I);
			cell = row.getCell(17);
			String sixteen = dataValue.formatCellValue(cell);
		// System.out.println(sixteen);

		/*******************************************************************************************************************
		 * Checking Scerch Box Properties
		 *******************************************************************************************************************/
		PropertiesCommonMethods.checkWbeElementq(finder, definition);
		// Visibility
		Boolean isVisible = finder.isDisplayed();
		PropertiesCommonMethods.TestReportsq("1.Modal Visible", oN, isVisible, definition);
		if (isVisible == true) {
			// Enablity
			Boolean isEnabled = finder.isEnabled();
			PropertiesCommonMethods.TestReportsq("2.Modal BoxEnable", tW, isEnabled, definition);

			

//								Modal border-color
				String bfillC = finder.getCssValue("border-colour");
				System.out.println("Border Colour:-"+bfillC);
				PropertiesCommonMethods.TestReportsq("3.Modal Border Color", tH, bfillC, definition);

//								Modal Hight
				int buttonHight = finder.getSize().height;
				PropertiesCommonMethods.TestReportsq("4.Modal Hight", fO, buttonHight, definition);
				// Modal Width
				int buttonWidth = finder.getSize().width;
				PropertiesCommonMethods.TestReportsq("5.Modal Width", fI, buttonWidth, definition);

				// Modal xPosition
				int xPostion = finder.getLocation().x;
				PropertiesCommonMethods.TestReportsq("6.Modal X position", sI, xPostion, definition);

				// Modal yPosition
				int yPostion = finder.getLocation().y;
				PropertiesCommonMethods.TestReportsq("7.Modal Y Position", sE, yPostion, definition);

//								Modal background color
				String backgroundColor = finder.getCssValue("background-color");
				PropertiesCommonMethods.TestReportsq("8.Modal Background Color", Et, backgroundColor, definition);

//								Modal cursor-pointer
				String fontColour = finder.getCssValue("cursor");
				PropertiesCommonMethods.TestReportsq("9.Modal Cursor Pointer", nIn, fontColour, definition);

//								Modal overflow
				String borderColor = finder.getCssValue("overflow");
				PropertiesCommonMethods.TestReportsq("10.Modal Overflow", tN, borderColor, definition);

//								Modal margin
				String margin = finder.getCssValue("margin");
				PropertiesCommonMethods.TestReportsq("11.Modal Margin", elv, margin, definition);

//								Modal z-index
				String zindax = finder.getCssValue("z-index");
				PropertiesCommonMethods.TestReportsq("12.Modal z-index", twl, zindax, definition);
				
				//modal title
				String contentTitle;
				try {
					contentTitle = finder.findElement(By.xpath("//div[@class='ant-modal-title']")).getText();
				} catch (Exception e) {
					contentTitle = finder.findElement(By.xpath("//div[@class='ant-popover-title']")).getText();
				}
				PropertiesCommonMethods.TestReportsq("13.Modal Title", theteen, contentTitle, definition);

//								modal content
				String content;
				try {
					content = finder.findElement(By.xpath("//div[@class='ant-modal-body']")).getText();
					System.out.print(content);
				} catch (Exception e) {
					 content = finder.findElement(By.xpath("//div[@class='ant-popover-inner-content']")).getText();
					 System.out.print(content);
				}
				
				PropertiesCommonMethods.TestReportsq("14.Modal Content", fteen, content, definition);

//							After Click Inside Of Modal	
				finder.click();
				Boolean inClick = finder.isDisplayed();
				PropertiesCommonMethods.TestReportsq("15.After Click Inside Of Modal", fivteen, inClick,
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
				PropertiesCommonMethods.TestReportsq("16.After Click Outside Of Modal", sixteen, outside, definition);

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
	  * 
	  * @param excelFileName:- Name of Excel.xlsx File(String)
	  * @param sheetName    :- sheetName:- expacted data sheet name
	  * @param I            :-  Excel data column index value
	  * @param finder		:- WebElement of Text :-@FindBy(xpath,id,name,classname.....)
	  * @param definition	:- Define Test(Types,module name, )
	  * @paramcExcal Sheet Property Data Must Be Blow Order In Row number :-Text Box visibility, Text Box Enability, Text Box Border Color, Text Box Hight, Text Box width, Text Box xPosition, Text Box yPosition, Text Box Background Color, Text Box PlaceHolder, Text Box Font Style, Text Box Font Size
	  */
	
	
	public static void textBoxProperties (String excelFileName, String sheetName, String UniqId, WebElement finder,
			String definition) {
		
		
		
		 
		
		
		/*******************************************************************************************************************
													Get data from excel sheet 
		*******************************************************************************************************************/			
				
				
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
	
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
					
				PropertiesCommonMethods.excalRowCount(excelFileName, sheetName, UniqId);
				int I=PropertiesCommonMethods.countRow-1;
				XSSFSheet sheet = wbook.getSheet(sheetName);
				

				row = sheet.getRow(I);
				cell = row.getCell(2);
				String oN= dataValue.formatCellValue(cell).toLowerCase();
				//System.out.println(oN);
				 


				row = sheet.getRow(I);
				cell = row.getCell(3);
				String tW= dataValue.formatCellValue(cell).toLowerCase();
				//System.out.println(tW);
				


				row = sheet.getRow(I);
				cell = row.getCell(4);
				String tH= dataValue.formatCellValue(cell);
				//System.out.println(tH);
				


				row = sheet.getRow(I);
				cell = row.getCell(5);
				String fO= dataValue.formatCellValue(cell);
				//System.out.println(fO);
				


				row = sheet.getRow(I);
				cell = row.getCell(6);
				String fI= dataValue.formatCellValue(cell);
				//System.out.println(fI);
				


				row = sheet.getRow(I);
				cell = row.getCell(7);
				String sI= dataValue.formatCellValue(cell);
				//System.out.println(sI);
				


				row = sheet.getRow(I);
				cell = row.getCell(8);
				String sE= dataValue.formatCellValue(cell);
				//System.out.println(sE);
				


				row = sheet.getRow(I);
				cell = row.getCell(9);
				String Et= dataValue.formatCellValue(cell);
				//System.out.println(Et);
				


				row = sheet.getRow(I);
				cell = row.getCell(10);
				String nIn= dataValue.formatCellValue(cell);
				//System.out.println(nIn);
				
				row = sheet.getRow(I);
				cell = row.getCell(11);
				String tN= dataValue.formatCellValue(cell);
				//System.out.println(tN);
		        
				row = sheet.getRow(I);
				cell = row.getCell(12);
				String elv = dataValue.formatCellValue(cell);
				//System.out.println(elv);
				 
				row = sheet.getRow(I);
				cell = row.getCell(13);
				String twl = dataValue.formatCellValue(cell);
				//System.out.println(twl);
//				
//				row = sheet.getRow(13);
//				cell = row.getCell(I);
//				String theteen = dataValue.formatCellValue(cell);
//				//System.out.println(theteen);
//				
//				row = sheet.getRow(14);
//				cell = row.getCell(I);
//				String fteen = dataValue.formatCellValue(cell).toLowerCase();
//				//System.out.println(fteen);
//				
//				row = sheet.getRow(15);
//				cell = row.getCell(I);
//				String fivteen= dataValue.formatCellValue(cell).toLowerCase();
//				//System.out.println(fivteen);
//				
//				row = sheet.getRow(16);
//				cell = row.getCell(I);
//				String sixteen = dataValue.formatCellValue(cell);
				// System.out.println(sixteen);
				
		 		
		 		
			
				
					
					
					

					
					
					
					
					
		/*******************************************************************************************************************
				                            Checking Modal Properties
		*******************************************************************************************************************/
				PropertiesCommonMethods.checkWbeElementq(finder, definition);
				try {
					finder.click();
				} catch (Exception e) {
				}
							//Visibility
							Boolean isVisible = finder.isDisplayed();
							PropertiesCommonMethods.TestReportsq("1.Text Box Visuble", oN, isVisible,definition);
							if (isVisible == true) {
								//Enablity
								Boolean isEnabled = finder.isEnabled();
								PropertiesCommonMethods.TestReportsq("2.Text Box Enalled", tW, isEnabled,definition);

								
								
//									Text box border-color
									String bfillC = finder.getCssValue("border-colour");
									PropertiesCommonMethods.TestReportsq("3.Text Box Border Color", tH , bfillC,definition);

//									Text Box Hight
									int buttonHight = finder.getSize().height;
									PropertiesCommonMethods.TestReportsq("4.Text Box Box Hight", fO, buttonHight,definition);
									//Text Box Width
									int buttonWidth = finder.getSize().width;
									PropertiesCommonMethods.TestReportsq("5.Text Box Length", fI, buttonWidth,definition);

									
									//Text Box xPosition
									int xPostion = finder.getLocation().x;
									PropertiesCommonMethods.TestReportsq("6.Text Box X position", sI, xPostion,definition);
									
									//Text Box yPosition
									int yPostion = finder.getLocation().y;
									PropertiesCommonMethods.TestReportsq("7.Text Box Y Position", sE, yPostion,definition);
									
//									Text Box background color
									String backgroundColor = finder.getCssValue("background-color");
									PropertiesCommonMethods.TestReportsq("8.Text Box Background Color", Et , backgroundColor,definition);
									
//									Text Box PlaceHolder
									String fontColour = finder.getAttribute("placeholder");
									PropertiesCommonMethods.TestReportsq("9.Text Box PlaceHolder", nIn, fontColour,definition);
									
//									Text Box Font Style
								    String borderColor = finder.getCssValue("font-style");
								    PropertiesCommonMethods.TestReportsq("10.Text Box Font Style", tN, borderColor,definition);
										 
//									Text Box Font Size
								    String margin = finder.getCssValue("font-style");
								    PropertiesCommonMethods.TestReportsq("11.Text Box Font Size", elv, margin,definition);
								    
//									Text Box Font Coluer
								    String zindax = finder.getCssValue("color");
								    PropertiesCommonMethods.TestReportsq("12.Text Box Font Colour",twl ,zindax ,definition);
//								    
////									modal content
//								    String content = finder.getText();
//								   testReport.TestReports("13.Search Box Content",theteen ,content ,definition);
//								    
////								After Click Inside Of Modal	
//								   finder.click();
//								   Boolean inClick = finder.isDisplayed();
//								    testReport.TestReports("14.After Click Inside Of Modal",fteen ,inClick ,definition);
								    
							   
									
									
									

								

							}

							else {
								PropertiesCommonMethods.TestReportsq("Text Box Is Not Visible❗Properties Checking Terminated⚠️", "Text Box Displayed" ,"Text Box Not Displayed",definition);
							}
							
							try {
								fileIn.close();
							} catch (IOException e) {
								extent.createTest("Excel File Not Closed⚠️");
								// TODO Auto-generated catch block
//								e.printStackTrace();
							}
			
		}
	
	/**
	  * @author Quenthan
	  * @param excelFileName:- Name of Excel.xlsx File(String)
	  * @param sheetName    :- sheetName:- expacted data sheet name
	  * @param UniqId     :-  Test Case ID
	  * @param finder		:- WebElement of Text :-@FindBy(xpath,id,name,classname.....)
	  * @param definition	:- Define Test(Types,module name, )
	  * @paramcExcal Sheet Property Data Must Be Blow Order In Row number :-Drop Down visibility, Drop Down Enability, Drop Down Border Color, Drop Down Hight, Drop Down width, Drop Down xPosition, Drop Down yPosition, Drop Down Background Color, 
	  */
	
	
	public static void dropDown (String excelFileName, String sheetName, String UniqId, WebElement finder,
			String definition,String in) {
		
		
		
		finder.click();
		
		
		/*******************************************************************************************************************
													Get data from excel sheet 
		*******************************************************************************************************************/			
				
				
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
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
					
				PropertiesCommonMethods.excalRowCount(excelFileName, sheetName, UniqId);
				int I=PropertiesCommonMethods.countRow-1;
				XSSFSheet sheet = wbook.getSheet(sheetName);
				

				row = sheet.getRow(I);
				cell = row.getCell(2);
				String oN= dataValue.formatCellValue(cell).toLowerCase();
				//System.out.println(oN);
				 


				row = sheet.getRow(I);
				cell = row.getCell(3);
				String tW= dataValue.formatCellValue(cell).toLowerCase();
				//System.out.println(tW);
				


				row = sheet.getRow(I);
				cell = row.getCell(4);
				String tH= dataValue.formatCellValue(cell);
				//System.out.println(tH);
				


				row = sheet.getRow(I);
				cell = row.getCell(5);
				String fO= dataValue.formatCellValue(cell);
				//System.out.println(fO);
				


				row = sheet.getRow(I);
				cell = row.getCell(6);
				String fI= dataValue.formatCellValue(cell);
				//System.out.println(fI);
				


				row = sheet.getRow(I);
				cell = row.getCell(7);
				String sI= dataValue.formatCellValue(cell);
				//System.out.println(sI);
				


				row = sheet.getRow(I);
				cell = row.getCell(8);
				String sE= dataValue.formatCellValue(cell);
				//System.out.println(sE);
				


				row = sheet.getRow(I);
				cell = row.getCell(9);
				String Et= dataValue.formatCellValue(cell);
				//System.out.println(Et);
				


				row = sheet.getRow(I);
				cell = row.getCell(10);
				String nIn= dataValue.formatCellValue(cell);
				//System.out.println(nIn);
				
				row = sheet.getRow(I);
				cell = row.getCell(11);
				String tN= dataValue.formatCellValue(cell);
				//System.out.println(tN);
		        
				row = sheet.getRow(I);
				cell = row.getCell(12);
				String elv = dataValue.formatCellValue(cell);
				//System.out.println(elv);
				 
				row = sheet.getRow(I);
				cell = row.getCell(13);
				String twl = dataValue.formatCellValue(cell);
				//System.out.println(twl);
//				
//				row = sheet.getRow(13);
//				cell = row.getCell(I);
//				String theteen = dataValue.formatCellValue(cell);
//				//System.out.println(theteen);
//				
//				row = sheet.getRow(14);
//				cell = row.getCell(I);
//				String fteen = dataValue.formatCellValue(cell).toLowerCase();
//				//System.out.println(fteen);
//				
//				row = sheet.getRow(15);
//				cell = row.getCell(I);
//				String fivteen= dataValue.formatCellValue(cell).toLowerCase();
//				//System.out.println(fivteen);
//				
//				row = sheet.getRow(16);
//				cell = row.getCell(I);
//				String sixteen = dataValue.formatCellValue(cell);
				// System.out.println(sixteen);
				
		 		
		 		
			
				
					
					
					

					
					
					
					
					
		/*******************************************************************************************************************
				                            Checking Modal Properties
		*******************************************************************************************************************/
				WebElement drop=driver.findElement(By.xpath("//div[@class='rc-virtual-list']"));
				PropertiesCommonMethods.checkWbeElementq(drop, definition+"-Drop Down");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
						 //Visibility
							Boolean isVisible = drop.isDisplayed();
							PropertiesCommonMethods.TestReportsq("1.Drop Down Visuble", oN, isVisible,definition);
							if (isVisible == true) {
								//Enablity
								Boolean isEnabled = drop.isEnabled();
								PropertiesCommonMethods.TestReportsq("2.Drop Down Enalled", tW, isEnabled,definition);

								
								
//									Text box border-color
									String bfillC = drop.getCssValue("border-colour");
									PropertiesCommonMethods.TestReportsq("3.Drop Down Border Color", tH , bfillC,definition);

//									Text Box Hight
									int buttonHight = drop.getSize().height;
									PropertiesCommonMethods.TestReportsq("4.Drop Down Box Hight", fO, buttonHight,definition);
									//Text Box Width
									int buttonWidth = drop.getSize().width;
									PropertiesCommonMethods.TestReportsq("5.Drop Down Width", fI, buttonWidth,definition);

									
									//Text Box xPosition
									int xPostion = drop.getLocation().x;
									PropertiesCommonMethods.TestReportsq("6.Drop Down X position", sI, xPostion,definition);
									
									//Text Box yPosition
									int yPostion = drop.getLocation().y;
									PropertiesCommonMethods.TestReportsq("7.Drop Down Y Position", sE, yPostion,definition);
									
//									Text Box background color
									String backgroundColor = drop.getCssValue("background-color");
									PropertiesCommonMethods.TestReportsq("8.Drop Down Background Color", Et , backgroundColor,definition);
									
//									Text Box Cursor
									String fontColour = drop.getAttribute("cursor");
									PropertiesCommonMethods.TestReportsq("9.Drop Down Cursor", nIn, fontColour,definition);
									
//									Text Box Font Box-shadow
								    String borderColor = drop.getCssValue("box-shadow");
								    PropertiesCommonMethods.TestReportsq("10.Drop Down Box-shadow", tN, borderColor,definition);
										 
//									Text Box Font Placeholder
								    String plas="(//span[@class='ant-select-selection-placeholder'])"+"["+in+"]";
								    String margin="";
									try {
										margin = driver.findElement(By.xpath(plas)).getText();
									} catch (Exception e) {
										margin="";
									}
								    PropertiesCommonMethods.TestReportsq("11.Drop Down Placeholder", elv, margin,definition);
								    System.out.println(margin);
//									Text Box Font Coluer
								    String zindax = drop.getCssValue("color");
								    PropertiesCommonMethods.TestReportsq("12.Drop Down Font Colour",twl ,zindax ,definition);
//								    
////									modal content
//								    String content = finder.getText();
//								   testReport.TestReports("13.Search Box Content",theteen ,content ,definition);
//								    
////								After Click Inside Of Modal	
//								   finder.click();
//								   Boolean inClick = finder.isDisplayed();
//								    testReport.TestReports("14.After Click Inside Of Modal",fteen ,inClick ,definition);
								    
							   
									
									
									

								

							}

							else {
								PropertiesCommonMethods.TestReportsq("Text Box Is Not Visible❗Properties Checking Terminated⚠️", "Text Box Displayed" ,"Text Box Not Displayed",definition);
							}
							
							try {
								fileIn.close();
							} catch (IOException e) {
								extent.createTest("Excel File Not Closed⚠️");
								// TODO Auto-generated catch block
//								e.printStackTrace();
							}
			
		}

	public static void dropDownMulti(String excelFileName, String sheetName, String UniqId, WebElement finder,
			String definition,String dropdownNo,int checkcount) {
		
		
		
		finder.click();
		
		
		/*******************************************************************************************************************
													Get data from excel sheet 
		*******************************************************************************************************************/			
				
				
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
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
					
				PropertiesCommonMethods.excalRowCount(excelFileName, sheetName, UniqId);
				int I=PropertiesCommonMethods.countRow-1;
				XSSFSheet sheet = wbook.getSheet(sheetName);
				

				row = sheet.getRow(I);
				cell = row.getCell(2);
				String oN= dataValue.formatCellValue(cell).toLowerCase();
				//System.out.println(oN);
				 


				row = sheet.getRow(I);
				cell = row.getCell(3);
				String tW= dataValue.formatCellValue(cell).toLowerCase();
				//System.out.println(tW);
				


				row = sheet.getRow(I);
				cell = row.getCell(4);
				String tH= dataValue.formatCellValue(cell);
				//System.out.println(tH);
				


				row = sheet.getRow(I);
				cell = row.getCell(5);
				String fO= dataValue.formatCellValue(cell);
				//System.out.println(fO);
				


				row = sheet.getRow(I);
				cell = row.getCell(6);
				String fI= dataValue.formatCellValue(cell);
				//System.out.println(fI);
				


				row = sheet.getRow(I);
				cell = row.getCell(7);
				String sI= dataValue.formatCellValue(cell);
				//System.out.println(sI);
				


				row = sheet.getRow(I);
				cell = row.getCell(8);
				String sE= dataValue.formatCellValue(cell);
				//System.out.println(sE);
				


				row = sheet.getRow(I);
				cell = row.getCell(9);
				String Et= dataValue.formatCellValue(cell);
				//System.out.println(Et);
				


				row = sheet.getRow(I);
				cell = row.getCell(10);
				String nIn= dataValue.formatCellValue(cell);
				//System.out.println(nIn);
				
				row = sheet.getRow(I);
				cell = row.getCell(11);
				String tN= dataValue.formatCellValue(cell);
				//System.out.println(tN);
		        
				row = sheet.getRow(I);
				cell = row.getCell(12);
				String elv = dataValue.formatCellValue(cell);
				//System.out.println(elv);
				 
				row = sheet.getRow(I);
				cell = row.getCell(13);
				String twl = dataValue.formatCellValue(cell);
				//System.out.println(twl);
//				
//				row = sheet.getRow(13);
//				cell = row.getCell(I);
//				String theteen = dataValue.formatCellValue(cell);
//				//System.out.println(theteen);
//				
//				row = sheet.getRow(14);
//				cell = row.getCell(I);
//				String fteen = dataValue.formatCellValue(cell).toLowerCase();
//				//System.out.println(fteen);
//				
//				row = sheet.getRow(15);
//				cell = row.getCell(I);
//				String fivteen= dataValue.formatCellValue(cell).toLowerCase();
//				//System.out.println(fivteen);
//				
//				row = sheet.getRow(16);
//				cell = row.getCell(I);
//				String sixteen = dataValue.formatCellValue(cell);
				// System.out.println(sixteen);
				
		 		
		 		
			
				
					
					
					

					
					
					
					
					
		/*******************************************************************************************************************
				                            Checking Modal Properties
		*******************************************************************************************************************/
				WebElement drop=driver.findElement(By.xpath("(//div[@class='rc-virtual-list'])["+checkcount+"]"));
				PropertiesCommonMethods.checkWbeElementq(drop, definition+"-Drop Down");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
						 //Visibility
							Boolean isVisible = drop.isDisplayed();
							PropertiesCommonMethods.TestReportsq("1.Drop Down Visuble", oN, isVisible,definition);
							if (isVisible == true) {
								//Enablity
								Boolean isEnabled = drop.isEnabled();
								PropertiesCommonMethods.TestReportsq("2.Drop Down Enalled", tW, isEnabled,definition);

								
								
//									Text box border-color
									String bfillC = drop.getCssValue("border-colour");
									PropertiesCommonMethods.TestReportsq("3.Drop Down Border Color", tH , bfillC,definition);

//									Text Box Hight
									int buttonHight = drop.getSize().height;
									PropertiesCommonMethods.TestReportsq("4.Drop Down Box Hight", fO, buttonHight,definition);
									//Text Box Width
									int buttonWidth = drop.getSize().width;
									PropertiesCommonMethods.TestReportsq("5.Drop Down Width", fI, buttonWidth,definition);

									
									//Text Box xPosition
									int xPostion = drop.getLocation().x;
									PropertiesCommonMethods.TestReportsq("6.Drop Down X position", sI, xPostion,definition);
									
									//Text Box yPosition
									int yPostion = drop.getLocation().y;
									PropertiesCommonMethods.TestReportsq("7.Drop Down Y Position", sE, yPostion,definition);
									
//									Text Box background color
									String backgroundColor = drop.getCssValue("background-color");
									PropertiesCommonMethods.TestReportsq("8.Drop Down Background Color", Et , backgroundColor,definition);
									
//									Text Box Cursor
									String fontColour = drop.getAttribute("cursor");
									PropertiesCommonMethods.TestReportsq("9.Drop Down Cursor", nIn, fontColour,definition);
									
//									Text Box Font Box-shadow
								    String borderColor = drop.getCssValue("box-shadow");
								    PropertiesCommonMethods.TestReportsq("10.Drop Down Box-shadow", tN, borderColor,definition);
										 
//									Text Box Font Placeholder
								    String plas="(//span[@class='ant-select-selection-placeholder'])"+"["+dropdownNo+"]";
								    String margin="";
									try {
										margin = driver.findElement(By.xpath(plas)).getText();
									} catch (Exception e) {
										margin="";
									}
								    PropertiesCommonMethods.TestReportsq("11.Drop Down Placeholder", elv, margin,definition);
								    System.out.println(margin);
//									Text Box Font Coluer
								    String zindax = drop.getCssValue("color");
								    PropertiesCommonMethods.TestReportsq("12.Drop Down Font Colour",twl ,zindax ,definition);
//								    
////									modal content
//								    String content = finder.getText();
//								   testReport.TestReports("13.Search Box Content",theteen ,content ,definition);
//								    
////								After Click Inside Of Modal	
//								   finder.click();
//								   Boolean inClick = finder.isDisplayed();
//								    testReport.TestReports("14.After Click Inside Of Modal",fteen ,inClick ,definition);
								    
							   
									
									
									

								

							}

							else {
								PropertiesCommonMethods.TestReportsq("Text Box Is Not Visible❗Properties Checking Terminated⚠️", "Text Box Displayed" ,"Text Box Not Displayed",definition);
							}
							
							try {
								fileIn.close();
							} catch (IOException e) {
								extent.createTest("Excel File Not Closed⚠️");
								// TODO Auto-generated catch block
//								e.printStackTrace();
							}
			
		}

}