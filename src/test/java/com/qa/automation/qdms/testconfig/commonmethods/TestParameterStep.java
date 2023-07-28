package com.qa.automation.qdms.testconfig.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;
import com.qa.automation.qdms.testconfig.testcases.testconfigure.AddConfigureTest;

public class TestParameterStep extends DriverIntialization {
	static String workBookName1 = null;
	static String ExcelTabName1 = null;
static WebElement list = null;
static String  addunit=null;
static boolean unit1=false;
public static boolean para=false;
static DataFormatter dataValue=new DataFormatter();

public static ArrayList<String> adddata= new ArrayList<String>();
public static Boolean addgroupkey=false;
//	@Test
	public static void selectParameter(String workBookName1, String ExcelTabName, String TestcaseId1) throws InterruptedException, IOException {
 
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + workBookName1 + ".xlsx";
		workBookName1 = excelPath;
		ExcelTabName1 = ExcelTabName;
		int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId1);
		int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId1);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(ExcelTabName);
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow rowk = sheet.getRow(i);
			String parameterName = dataValue.formatCellValue(rowk.getCell(1));

			boolean nextPageButton = true;
			boolean check = false;
			while (nextPageButton) {
				Thread.sleep(1000);
				List<WebElement> column = driver
						.findElements(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr/td[1]"));
				int size = column.size();
				System.out.println(size);
				for (int j = 2; j <= size; j++) {
//					Thread.sleep(500);
					String text = null;
					try {
						text = driver
								.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr[" + j + "]/td[1]"))
								.getText();
					} catch (NoSuchElementException e) {
						CommonMethods.print("Searched Element Not There");
					}
					System.out.println(text);
//					Thread.sleep(100);  
					if (text.equalsIgnoreCase(parameterName)) {
						try {

							WebElement checkboxinput = driver.findElement(By.xpath(
									"(//tbody[@class='ant-table-tbody'])[1]/tr[" + j + "]/td[4]/label/span/input"));
							WebElement checkbox = driver.findElement(
									By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr[" + j + "]/td[4]/label/span"));
							Thread.sleep(200);
//							MultiSearchMethods.Button(checkbox, parameterName + " Parameter CheckBox");
//							if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
								checkboxinput.click();
//								MultiSearchMethods.clickButton(checkboxinput, parameterName+" checkbox clicked");
//								System.out.println("***************");
								CommonMethods.TestCasePrint(parameterName + " Parameter Check Box Click",
										String.valueOf(true), String.valueOf(checkboxinput.isSelected()));
//							}

//							Thread.sleep(500);
							WebElement firstPage = driver.findElement(By.xpath("//li[@title='1']/a"));
							firstPage.click();
						} catch (NoSuchElementException e) {
							CommonMethods.print("Dont Have checkbox for this parameter");
						}
						check = true;
						break;
					}

					if (check) {
						break;
					}
				}
				if (check) {
					break;
				}
				try {
					WebElement next = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"));
					nextPageButton = next.isEnabled();
					if (nextPageButton == true) {
						Thread.sleep(200);
						next.click();

					}
				} catch (NoSuchElementException e) {
					CommonMethods.print("Next Button Element Not There");
				}
			}
		}}
	
	
	


	public static void addPaameter(String workBookName1, String ExcelTabName, String TestcaseId1) throws IOException, InterruptedException {
	
			
		String parameterName = null;
		String Abbreviation = null;
		String Type = null;  
		String InputMethod = null;
		String Value = null;
		String Unit = null;
		
		String DecimalValue = null;
		String RelevantToAcceptedCriteria = null;
		 ArrayList<String> stringList = new ArrayList<String>();
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + workBookName1 + ".xlsx";
int l=1;
int m=0;
		int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId1);
		int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId1);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(ExcelTabName); 
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow rowk = sheet.getRow(i);
			Unit = dataValue.formatCellValue(rowk.getCell(6));
			stringList.add(Unit); 
		}
		for (int i = firstrow; i <= lastrow; i++) { 
			XSSFRow rowk = sheet.getRow(i);
			parameterName = dataValue.formatCellValue(rowk.getCell(1));
			Abbreviation = dataValue.formatCellValue(rowk.getCell(2));
			Type = dataValue.formatCellValue(rowk.getCell(3));
			InputMethod = dataValue.formatCellValue(rowk.getCell(4));
			Value = dataValue.formatCellValue(rowk.getCell(5));
			Unit = dataValue.formatCellValue(rowk.getCell(6));
			
			DecimalValue =  dataValue.formatCellValue(rowk.getCell(7));
			RelevantToAcceptedCriteria = dataValue.formatCellValue(rowk.getCell(8));
			System.out.println(parameterName + " !!! " + Abbreviation + " !!! " + Type + " !!! " + InputMethod + " !!! "
					+ Value + " !!! " + Unit + " !!! " + DecimalValue + " !!! " + RelevantToAcceptedCriteria);
			
			int size = 0;
			try {
				List<WebElement> row = driver.findElements(By.xpath("(//tbody[@class='ant-table-tbody'])[2]/tr/td[1]"));
				size = row.size();
				System.out.println(size);
			} catch (NoSuchElementException e) {
				// TODO: handle exception
			}
			
//			Abbreviations
			for (int j = 2; j <= size; j++) {
				WebElement para=driver.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[2]/tr["+j+"]/td[1]"));
				String parametersName=para.getText();
				
				if(parametersName.contentEquals(parameterName)) {
					try {
//						Thread.sleep(500);
						WebElement Abbreviations = driver.findElement(
								By.xpath("((//tbody[@class='ant-table-tbody'])[2]/tr[" + j + "]/td[3]/span/input)[1]")); 
						WebElement Abbreviatio = driver.findElement(
								By.xpath("((//tbody[@class='ant-table-tbody'])[2]/tr[" + j + "]/td[3]/span)[1]")); 
//						MultiSearchMethods.TextBox(Abbreviatio, parameterName + " Parameter TextBox");
//						if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
							Abbreviations.sendKeys(Abbreviation); 
//						}
//						MultiSearchMethods.BtnVisible=true;
//						MultiSearchMethods.BtnEnable=true;
					} catch (NoSuchElementException e) {
						CommonMethods.print("Dont Have Abbreviations TextBox");
					}
				

//					type
				try {
					WebElement type = driver.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[2]/tr[" +j + "]/td[4]/div/div/span[1]/input"));
					
//					MultiSearchMethods.Button(type, parameterName + " Parameter Type Dropdown");
					type.click();   
//					Thread.sleep(500);   
					if(Type.contentEquals("Input")) {
						System.err.println("Input");
						type.sendKeys(Keys.ENTER);
					} else if (Type.contentEquals("Config")) {
						System.err.println("Config");
						type.sendKeys(Keys.ARROW_DOWN ,Keys.ENTER );
					} else if (Type.contentEquals("Result")) {
						System.err.println("Result");
						type.sendKeys(Keys.ARROW_DOWN , Keys.ARROW_DOWN ,  Keys.ENTER);
					}
				} catch (Exception e) {
					CommonMethods.print("Dont Have Type DropDown");
				}
				
				
//				inputMethod
				try {
					WebElement inputMethod = driver.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[2]/tr[" +j + "]/td[5]/div/div/span[1]/input"));
//					MultiSearchMethods.Button(inputMethod, parameterName + " Parameter Input Method Dropdown");
					inputMethod.click();
//					Thread.sleep(1000);
					if(InputMethod.contentEquals("Calculation")) {
						System.err.println("Calculation");
						inputMethod.sendKeys(Keys.ENTER);
					} else if (InputMethod.contentEquals("Observe")) {
						System.err.println("Observe");
						inputMethod.sendKeys(Keys.ARROW_DOWN ,Keys.ENTER );
					}
				} catch (Exception e) {
					CommonMethods.print("Dont Have Type DropDown");
				}
				
				
//				value
				try {
					WebElement values = driver.findElement(
							By.xpath("(//tbody[@class='ant-table-tbody'])[2]/tr[" +j+ "]/td[6]/input"));
//					Thread.sleep(1000);
					MultiSearchMethods.Button1(values, parameterName + " Value TextBox");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						values.sendKeys(Value);
					}
					MultiSearchMethods.BtnVisible=true;
					MultiSearchMethods.BtnEnable=true;
				} catch (AssertionError e) {
					CommonMethods.print("Dont Have Value TextBox");
				}
//				unit
				try {
					WebElement unit = driver.findElement(
							By.xpath("(//tbody[@class='ant-table-tbody'])[2]/tr[" +j+ "]/td[7]/div/div"));
					
//					Thread.sleep(1000);
				//	MultiSearchMethods.Button(unit, parameterName + " Value TextBox");
//					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						unit.click();
					//	Thread.sleep(2000);
						//**************scrole start*******
						
						Actions actions = new Actions(driver);
	                    try {
	                        boolean pass = false;
//	                        Thread.sleep(200);
	                        for (int i1 = 0; i1 < 1000; i1++) {
	                            if (!pass) {
	                                try {
	                                	 
	                                	
	                                		 list = driver
		                                            .findElement(By.xpath("(//div[@class='ant-select-item-option-content'][normalize-space()='" + Unit + "'])["+(j-1
		                                            		)+"]"));
	                                    System.out.println(list);
//	                                    Thread.sleep(1500);
	                                    list.click();
//	                                    Thread.sleep(2000);
	                                   addunit = unit.getText();
	                                    pass = true;
	                                    unit1=true;
	                                	
	                                } catch (Exception e) {
	                                }
	                            }
	                            if (!pass) {
	                                actions.sendKeys(Keys.ARROW_DOWN).perform();
//	                                Thread.sleep(2000);
	                            } else {
	                                break;
	                            }
	                        }
	                    } catch (Exception e) {
	                    }
						
						//************scrole end*******
			
//					}
//					MultiSearchMethods.BtnVisible=true;
//					MultiSearchMethods.BtnEnable=true;
					
					
					
				} catch (AssertionError e) {
					CommonMethods.print("Dont Have Value TextBox");
				}
				

				 
				
//				decimal
				try {
					WebElement decimal = driver.findElement(
						    	By.xpath("(//tbody[@class='ant-table-tbody'])[2]/tr[" +j+ "]/td[8]/span/input"));
//					Thread.sleep(1000);
//					MultiSearchMethods.Button(decimal, parameterName + " Decimal TextBox");
						decimal.sendKeys(Keys.CONTROL+"a" , Keys.DELETE);
						decimal.sendKeys(String.valueOf(DecimalValue));
//					MultiSearchMethods.BtnVisible=true;
//					MultiSearchMethods.BtnEnable=true;
				} catch (AssertionError e) {
					CommonMethods.print("Dont Have Decimal TextBox");
				}
				
				
				
				
//				checkbox
				try {
					WebElement check = driver.findElement(
							By.xpath("(//tbody[@class='ant-table-tbody'])[2]/tr[" +j+ "]/td[9]/label/span/input"));
//					Thread.sleep(1000);
//					MultiSearchMethods.Button(check, parameterName + " CheckBox");
					boolean select=check.isSelected();
					String sele=String.valueOf(select);
						if(RelevantToAcceptedCriteria.equalsIgnoreCase(sele)) {
							
						} else {
							check.click();
						}
						
//					MultiSearchMethods.BtnVisible=true;
//					MultiSearchMethods.BtnEnable=true;
				} catch (AssertionError e) {
					CommonMethods.print("Dont Have CheckBox");
				}
			
				}
		
			}
		}
		
		if (unit1) {
			try {
				//			Thread.sleep(500);
				WebElement saveBtn = driver.findElement(By.xpath("//div[@class='ant-table-footer']/div/div[2]/button"));
				saveBtn.click();
				//			MultiSearchMethods.clickButton(saveBtn, "Save PArameter Button clicked");
para=true;
			} catch (NoSuchElementException e) {
				CommonMethods.print("Dont Have Save PArameter Button");
			} 
		}
		
		
	
}

	public static void testParametersGroup(String workBookName1, String ExcelTabName, String TestcaseId1) throws InterruptedException {
		
			
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + workBookName1 + ".xlsx";
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;

		try {
			filelocation =excelPath ;

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			// fileIn.close();

		} catch (Exception e) {

		}
		
		int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId1);
		int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId1);
System.out.println(firstrow+"qu"+lastrow);
int I=1;
		for (int i = firstrow; i <= lastrow; i++) {
			adddata.clear();
			for (int j = 1; j < 20; j++) {
				XSSFSheet sheet = wbook.getSheet(ExcelTabName);
				row = sheet.getRow(i);
				String tatal="";
				try {
					cell = row.getCell(j);
					tatal = dataValue.formatCellValue(cell);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				adddata.add(tatal);

			} 
			System.out.println(adddata);
		
		
		Thread.sleep(2000);
		
		
		
		
		try {
			if (driver.findElement(By.xpath("//td[text()='" + adddata.get(0) + "']/following-sibling::td[text()='"
					+ adddata.get(8) + "']/following-sibling::td/span/input[@id='abbrivation']")).isEnabled()) {
				
			
			driver.findElement(By.xpath("//td[text()='" + adddata.get(0) + "']/following-sibling::td[text()='"
					+ adddata.get(8) + "']/following-sibling::td/span/input[@id='abbrivation']"))
					.sendKeys(adddata.get(1));
			
			}
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Abbrivation TEXT box Filling Fail", true, "", "");
			
		
		}
		try {
			
			if (driver.findElement(By.xpath("//td[text()='" + adddata.get(0) + "']/following-sibling::td[text()='"
					+ adddata.get(8) + "']/following-sibling::td//input[@id='configLevel']")).isEnabled()) {
				
			
			//add Type
			ActionCommonMethod.dropedDown(
					driver.findElement(By.xpath("//td[text()='" + adddata.get(0) + "']/following-sibling::td[text()='"
							+ adddata.get(8) + "']/following-sibling::td//input[@id='configLevel']")),
					adddata.get(2),I,"Type");}
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Add Type Drop Down Select Fail", true, "", "");
			
		}
		try {
			if (driver.findElement(
					By.xpath("//td[text()='" + adddata.get(0) + "']/following-sibling::td[text()='"
							+ adddata.get(8) + "']/following-sibling::td//input[@id='input']")).isEnabled()) {
				
			
			//Add Input Method
			ActionCommonMethod
					.dropedDown(
							driver.findElement(
									By.xpath("//td[text()='" + adddata.get(0) + "']/following-sibling::td[text()='"
											+ adddata.get(8) + "']/following-sibling::td//input[@id='input']")),
							adddata.get(3),I,"Input Method");}
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Input Id Drop Down Select Fail", true, "", "");
			
		}
		try {
			//Add Value
			if(driver.findElement(
							By.xpath("//td[text()='" + adddata.get(0) + "']/following-sibling::td[text()='"
									+ adddata.get(8) + "']/following-sibling::td//input[@id='value']")).isEnabled()) {
			ActionCommonMethod
					.sendkey(
							driver.findElement(
									By.xpath("//td[text()='" + adddata.get(0) + "']/following-sibling::td[text()='"
											+ adddata.get(8) + "']/following-sibling::td//input[@id='value']")),
							adddata.get(4));}
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Add Value Text Box Filling Fail", "true", "", "");
			
		}
		
		try {
			//Add Unit
			if(driver.findElement(
					By.xpath("//td[text()='" + adddata.get(0) + "']/following-sibling::td[text()='"
							+ adddata.get(8) + "']/following-sibling::td//input[@id='unit']/..")).isEnabled()) {
			ActionCommonMethod
					.dropedDown(
							driver.findElement(
									By.xpath("//td[text()='" + adddata.get(0) + "']/following-sibling::td[text()='"
											+ adddata.get(8) + "']/following-sibling::td//input[@id='unit']")),
							adddata.get(5),I,"Unit");
			unit1=true;
			}
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Add Unit Drop Down Select fail", true, "", "");
			
		}
		
		Boolean devalue=driver.findElement(
				By.xpath("//td[text()='" + adddata.get(0) + "']/following-sibling::td[text()='"
						+ adddata.get(8) + "']/following-sibling::td//input[@id='decimalType']")).isEnabled();
		try {
			//Add Decimal Value	
			if(devalue.equals(true)) {
			ActionCommonMethod
					.sendkey(
							driver.findElement(
									By.xpath("//td[text()='" + adddata.get(0) + "']/following-sibling::td[text()='"
											+ adddata.get(8) + "']/following-sibling::td//input[@id='decimalType']")),
							adddata.get(6));}
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Value TextBox Entering Fail", true, "", "");
			
		}
		
		
		System.out.println(adddata.get(7));
		if (adddata.get(7).equals("true")) {
			
			try {
				if(driver.findElement(By.xpath("//td[text()='" + adddata.get(0) + "']/following-sibling::td[text()='"
						+ adddata.get(8) + "']/following-sibling::td//input[@id='check_relevant']")).isEnabled()) {
				driver.findElement(By.xpath("//td[text()='" + adddata.get(0) + "']/following-sibling::td[text()='"
						+ adddata.get(8) + "']/following-sibling::td//input[@id='check_relevant']")).click();}
			} catch (Exception e) {
				PropertiesCommonMethods.cTestReports("Check Box Click Fail", true, "", "");
				
				
			}
			
		}
		
		
		
		I=I+1;
		}
		
		try {
//			Thread.sleep(500);
			WebElement saveBtn=driver.findElement(By.xpath("//div[@class='ant-table-footer']/div/div[2]/button"));
			saveBtn.click();
//			MultiSearchMethods.clickButton(saveBtn, "Save PArameter Button clicked");
			addgroupkey=true;
			
		} catch (NoSuchElementException e) {
			ExtentTest testCase =extent.createTest("Dont Have Save PArameter Button");
			testCase.log(Status.FAIL, "TEST FAIL 🔴");
			
			
		}
		
		
	
	} 
	
	}
	

