
package com.qa.automation.qdms.testconfig.testcases.testconfigure;



import java.io.FileInputStream;
import java.io.IOException;

import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;

import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;

public class ReviewTestConfig extends DriverIntialization {
	static String Tableheading = null;
	static String tablesubheading = null;
	static String matconditionvalue = null;
	static String mainheading = null;
	static DataFormatter dataValue=new DataFormatter();
	public static void ReviewTest(String name, String ExcelTabName, String TestcaseI1, String TestcaseI2,
			String TestcaseI3, String TestcaseI4, String TestcaseI5, String TestcaseI6, String TestcaseI7)
			throws IOException, InterruptedException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + name + ".xlsx";
		boolean Value1 = false;

		Thread.sleep(3000);
//config test*************
		if (TestcaseI1 != "") {

			try {
				int i = 1;
				String TestcaseId = TestcaseI1;
				System.out.println(TestcaseId + "ttttttttttttttttttttt");
				int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
				int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
				System.out.println(firstrow + "ffffffff");
				System.out.println(lastrow + "llllllllllllll");

				FileInputStream file = new FileInputStream(excelPath);
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet(ExcelTabName);
				WebElement tablemainheading = driver
						.findElement(By.xpath("(//div[@class='ant-card-head'])[" + i + "]/div/div"));
				String mainheading = tablemainheading.getText();
				System.out.println(mainheading + "main heading");
				for (int j = firstrow; j <= firstrow; j++) {
					XSSFRow rowk = sheet.getRow(j);
					Tableheading = dataValue.formatCellValue(rowk.getCell(19));
				}
				System.out.println(Tableheading + "table heading");

				if (mainheading.toUpperCase().contentEquals(Tableheading.toUpperCase()) && mainheading != null) {
					System.out.println("main heading matching");
					TestCasePrint(Tableheading.toUpperCase() + "MAIN HEADING IS MATCHING", Tableheading.toUpperCase(),
							String.valueOf(mainheading.toUpperCase()));

					// Locate the table element
					WebElement table = driver
							.findElement(By.xpath("(//thead[@class='ant-table-thead'])[" + i + "]/tr[1]"));

					// Find all TH elements within the table
					List<WebElement> headings = table.findElements(By.tagName("th"));

					// Get the count of table headings
					int count = headings.size();
					System.out.println(count + "count************");

					for (int i1 = 1; i1 <= count; i1++) {
						System.out.println(i1 + "loooopppppppp");
						WebElement tableeachheading = driver.findElement(
								By.xpath("(//thead[@class='ant-table-thead'])[" + i + "]/tr/th[" + i1 + "]"));
						String subheading = tableeachheading.getText();
						System.out.println(subheading + "subtable");
						for (int j = firstrow - 1; j <= firstrow - 1; j++) {
							XSSFRow rowk = sheet.getRow(j);
							if (i1 <= 3) {
								tablesubheading = dataValue.formatCellValue(rowk.getCell(i1));
								System.out.println(tablesubheading + "tablesubheading");
							}
							if (i1 == 4) {
								tablesubheading = dataValue.formatCellValue(rowk.getCell(12));
								System.out.println(tablesubheading + "tablesubheading");
							}
						}
						if (subheading.toUpperCase().contentEquals(tablesubheading.toUpperCase())) {
							System.out.println("sub data heading matching");
							TestCasePrint(
									mainheading.toUpperCase() + " " + tablesubheading.toUpperCase()
											+ " SUB DATA HEADING IS MATCHING",
									tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));

							// Locate the table element
							WebElement table1 = driver
									.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[" + i + "]"));

							// Find all TH elements within the table
							List<WebElement> headings1 = table1.findElements(By.tagName("tr"));

							// Get the count of table headings
							int count1 = headings1.size();
							System.out.println(count1 + "count1************");

							// for (int i2 = 1; i2 <= count1; i2++) {
							int i2 = 1;
							for (int j = firstrow; j <= lastrow; j++) {

								WebElement tabledata = driver
										.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[" + i + "]/tr[" + i2
												+ "]/td[" + i1 + "]"));
								String eachdata = tabledata.getText();
								System.out.println(eachdata + "eachdata");
								XSSFRow rowk = sheet.getRow(j);
								if (i1 == 1) {
									String tableachdata = dataValue.formatCellValue(rowk.getCell(i1));
									System.out.println(tableachdata + "tableechdata");
									if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
										System.out.println("pass");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										TestCasePrint(tablesubheading.toUpperCase() + "DATA IS NOT MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}
								}
								if (i1 == 2) {
									String tableachdata = dataValue.formatCellValue(rowk.getCell(i1));
									System.out.println(tableachdata + "tableechdata");
									if (tableachdata.contains("RAW MATERIAL")) {

										tableachdata = "RAW_MATERIAL";
									} else {
										tableachdata = "FINISH_PRODUCT";
									}
									if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
										System.out.println("pass");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										// TestCasePrint(tablesubheading.toUpperCase()+"DATA IS NOT MATCHING",
										// tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}
								}
								if (i1 == 3) {
									String tableachdata = dataValue.formatCellValue(rowk.getCell(i1));
									System.out.println(tableachdata + "tableechdata");
									if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
										System.out.println("pass");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										TestCasePrint(tablesubheading.toUpperCase() + "DATA IS NOT MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}
								}
								if (i1 == 4) {
									String tableachdata = dataValue.formatCellValue(rowk.getCell(12));
									System.out.println(tableachdata + "tableechdata");
									if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
										System.out.println("pass");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										TestCasePrint(tablesubheading.toUpperCase() + "DATA IS NOT MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}
								}
								i2++;
							}

							// }
						} else {
							TestCasePrint(
									mainheading.toUpperCase() + " " + tablesubheading.toUpperCase()
											+ "SUB DATA HEADING IS NOT MATCHING",
									tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
						}

					}

				} else if (mainheading == "") {
					TestCasePrint(Tableheading.toUpperCase() + "TABLE NOT THERE", Tableheading.toUpperCase(),
							String.valueOf(mainheading.toUpperCase()));
				} else {
					TestCasePrint(Tableheading.toUpperCase() + "MAIN HEADING IS NOT MATCHING",
							Tableheading.toUpperCase(), String.valueOf(mainheading.toUpperCase()));
				}

			} catch (Exception e) {
				TestCasePrint(Tableheading.toUpperCase() + "MAIN TABLE HEADING IS NOT THERE ", Tableheading,
						String.valueOf(mainheading), String.valueOf(e));
			}
		}
		// ******first table end*******************
		Thread.sleep(3000);
		// equation***************
		if (TestcaseI3 != "") {
			try {
				int i = 2;
				String TestcaseId = TestcaseI3;
				System.out.println(TestcaseId + "ttttttttttttttttttttt");
				int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
				int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
				System.out.println(firstrow + "ffffffff");
				System.out.println(lastrow + "llllllllllllll");

				FileInputStream file = new FileInputStream(excelPath);
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet(ExcelTabName);
				WebElement tablemainheading = driver
						.findElement(By.xpath("(//div[@class='ant-card-head'])[" + i + "]/div/div"));
				String mainheading = tablemainheading.getText();
				System.out.println(mainheading + "main heading");
				for (int j = firstrow; j <= firstrow; j++) {
					XSSFRow rowk = sheet.getRow(j);
					Tableheading = dataValue.formatCellValue(rowk.getCell(19));
				}
				System.out.println(Tableheading + "table heading");

				if (mainheading.toUpperCase().contentEquals(Tableheading.toUpperCase()) && mainheading != null) {
					System.out.println("main heading matching");
					TestCasePrint(Tableheading.toUpperCase() + "MAIN HEADING IS MATCHING", Tableheading.toUpperCase(),
							String.valueOf(mainheading.toUpperCase()));
//				}else {
//					 TestCasePrint(Tableheading+"MAIN HEADING IS NOT MATCHING", Tableheading, String.valueOf(mainheading));
//				}
					// Locate the table element
					WebElement table = driver
							.findElement(By.xpath("(//thead[@class='ant-table-thead'])[" + i + "]/tr[1]"));

					// Find all TH elements within the table
					List<WebElement> headings = table.findElements(By.tagName("th"));

					// Get the count of table headings
					int count = headings.size();
					System.out.println(count + "count************");

					for (int i1 = 1; i1 <= count; i1++) {
						System.out.println(i1 + "loooopppppppp");
						WebElement tableeachheading = driver.findElement(
								By.xpath("(//thead[@class='ant-table-thead'])[" + i + "]/tr/th[" + i1 + "]"));
						String subheading = tableeachheading.getText();
						System.out.println(subheading + "subtable");
						for (int j = firstrow - 1; j <= firstrow - 1; j++) {
							XSSFRow rowk = sheet.getRow(j);
							if (i1 == 1) {
								tablesubheading = dataValue.formatCellValue(rowk.getCell(2));
								System.out.println(tablesubheading + "tablesubheading");
							}
							if (i1 == 2) {
								tablesubheading = dataValue.formatCellValue(rowk.getCell(3));
								System.out.println(tablesubheading + "tablesubheading");
							}
							if (i1 == 3) {
								tablesubheading = dataValue.formatCellValue(rowk.getCell(1));
								System.out.println(tablesubheading + "tablesubheading");
							}

						}
						if (subheading.toUpperCase().contentEquals(tablesubheading.toUpperCase())) {
							System.out.println("sub data heading matching");
							TestCasePrint(
									mainheading.toUpperCase() + " " + tablesubheading.toUpperCase()
											+ " SUB DATA HEADING IS MATCHING",
									tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
//						}else {
//							 TestCasePrint(tablesubheading.toUpperCase()+"SUB DATA HEADING IS NOT MATCHING", tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
//						}
							// Locate the table element
							WebElement table1 = driver
									.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[" + i + "]"));

							// Find all TH elements within the table
							List<WebElement> headings1 = table1.findElements(By.tagName("tr"));

							// Get the count of table headings
							int count1 = headings1.size();
							System.out.println(count1 + "count1************");

							// for (int i2 = 1; i2 <= count1; i2++) {

							int i2 = 1;
							for (int j = firstrow; j <= lastrow; j++) {

								WebElement tabledata = driver
										.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[" + i + "]/tr[" + i2
												+ "]/td[" + i1 + "]"));
								System.out.println(tabledata);
								String eachdata = tabledata.getText();
								System.out.println(eachdata + "eachdata");
								XSSFRow rowk = sheet.getRow(j);
								if (i1 == 1) {
									String tableachdata = dataValue.formatCellValue(rowk.getCell(2));
									eachdata = eachdata.toUpperCase();
									tableachdata = tableachdata.toUpperCase();
									System.out.println(tableachdata + "tableechdata");
									if (eachdata.contains(tableachdata)) {
										System.out.println("pass");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}
								}
								if (i1 == 2) {
									String tableachdata = dataValue.formatCellValue(rowk.getCell(3));
									System.out.println(tableachdata + "tableechdata");
									if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
										System.out.println("pass");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}
								}
								if (i1 == 3) {
									String tableachdata = dataValue.formatCellValue(rowk.getCell(1));
									System.out.println(tableachdata + "tableechdata");
									if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
										System.out.println("pass");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}
								}
								i2++;
							}

							// }

						} else {
							TestCasePrint(
									mainheading.toUpperCase() + " " + tablesubheading.toUpperCase()
											+ " SUB DATA HEADING IS NOT MATCHING",
									tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
						}

					}

				} else if (mainheading == "") {
					TestCasePrint(Tableheading.toUpperCase() + "TABLE NOT THERE", Tableheading.toUpperCase(),
							String.valueOf(mainheading.toUpperCase()));
				} else {
					TestCasePrint(Tableheading.toUpperCase() + "MAIN HEADING IS NOT MATCHING",
							Tableheading.toUpperCase(), String.valueOf(mainheading.toUpperCase()));
				}

			} catch (Exception e) {
				TestCasePrint(Tableheading + "MAIN TABLE HEADING IS NOT THERE ", Tableheading,
						String.valueOf(mainheading), String.valueOf(e));
			}
		}
		// second table end************************
		Thread.sleep(3000);
		// parameter***********
		if (TestcaseI2 != "") {
			try {
				int i = 3;
				String TestcaseId = TestcaseI2;
				System.out.println(TestcaseId + "ttttttttttttttttttttt");
				int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
				int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
				System.out.println(firstrow + "ffffffff");
				System.out.println(lastrow + "llllllllllllll");

				FileInputStream file = new FileInputStream(excelPath);
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet(ExcelTabName);
				WebElement tablemainheading = driver
						.findElement(By.xpath("(//div[@class='ant-card-head'])[" + i + "]/div/div"));
				String mainheading = tablemainheading.getText();
				System.out.println(mainheading + "main heading");
				for (int j = firstrow; j <= firstrow; j++) {
					XSSFRow rowk = sheet.getRow(j);
					Tableheading = dataValue.formatCellValue(rowk.getCell(19));
					System.out.println(Tableheading + "/////////////////////////");
				}
				System.out.println(Tableheading + "table heading");

				if (mainheading.toUpperCase().contentEquals(Tableheading.toUpperCase()) && mainheading != null) {
					System.out.println("main heading matching");
					TestCasePrint(Tableheading.toUpperCase() + "MAIN HEADING IS MATCHING", Tableheading.toUpperCase(),
							String.valueOf(mainheading.toUpperCase()));
//				}else {
//					 TestCasePrint(Tableheading.toUpperCase()+"MAIN HEADING NOT IS MATCHING", Tableheading.toUpperCase(), String.valueOf(mainheading.toUpperCase()));
//				}
					// Locate the table element
					WebElement table = driver
							.findElement(By.xpath("(//thead[@class='ant-table-thead'])[" + i + "]/tr[1]"));

					// Find all TH elements within the table
					List<WebElement> headings = table.findElements(By.tagName("th"));

					// Get the count of table headings
					int count = headings.size();
					System.out.println(count + "count************");

					for (int i1 = 1; i1 < count; i1++) {
						System.out.println(i1 + "loooopppppppp");
						WebElement tableeachheading = driver.findElement(
								By.xpath("(//thead[@class='ant-table-thead'])[" + i + "]/tr/th[" + i1 + "]"));
						String subheading = tableeachheading.getText();
						System.out.println(subheading + "subtable");
						for (int j = firstrow - 1; j <= firstrow - 1; j++) {
							XSSFRow rowk = sheet.getRow(j);
							if (i1 <= 2) {
								tablesubheading = dataValue.formatCellValue(rowk.getCell(i1));
								System.out.println(tablesubheading + "tablesubheading");
							}
							if (i1 == 3) {
								tablesubheading = dataValue.formatCellValue(rowk.getCell(4));
								System.out.println(tablesubheading + "tablesubheading");
							}
							if (i1 == 4) {
								tablesubheading = dataValue.formatCellValue(rowk.getCell(3));
								System.out.println(tablesubheading + "tablesubheading");
							}
							if (i1 == 5) {
								tablesubheading = dataValue.formatCellValue(rowk.getCell(7));
								System.out.println(tablesubheading + "tablesubheading");
							}
							if (i1 == 6) {
								tablesubheading = dataValue.formatCellValue(rowk.getCell(6));
								System.out.println(tablesubheading + "tablesubheading");
							}
							if (i1 == 7) {
								tablesubheading = dataValue.formatCellValue(rowk.getCell(5));
								System.out.println(tablesubheading + "tablesubheading");
							}
						}
						if (subheading.toUpperCase().contentEquals(tablesubheading.toUpperCase())) {
							System.out.println("sub data heading matching");
							TestCasePrint(
									mainheading.toUpperCase() + " " + tablesubheading.toUpperCase()
											+ " SUB DATA HEADING IS MATCHING",
									tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
//						}else {
//							 TestCasePrint(tablesubheading.toUpperCase()+"SUB DATA HEADING IS NOT MATCHING", tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
//						}
							// Locate the table element
							WebElement table1 = driver
									.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[" + i + "]"));

							// Find all TH elements within the table
							List<WebElement> headings1 = table1.findElements(By.tagName("tr"));

							// Get the count of table headings
							int count1 = headings1.size();
							System.out.println(count1 + "count1************");

							// for (int i2 = 1; i2 <= count1; i2++) {
							int i2 = 1;
							for (int j = firstrow; j <= lastrow; j++) {
								WebElement tabledata = driver
										.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[" + i + "]/tr["
												+ (i2 + 1) + "]/td[" + i1 + "]"));
								System.out.println(tabledata);
								String eachdata = tabledata.getText();
								System.out.println(eachdata + "eachdata");
								XSSFRow rowk = sheet.getRow(j);
								if (i1 == 1) {
									
									if (TestParameterStep.addgroupkey) {
										
										String tabled = dataValue.formatCellValue(rowk.getCell(1));
										String groupname =dataValue.formatCellValue(rowk.getCell(9));
										String tableachdata = tabled+" "+groupname;
										System.out.println(tableachdata + "tableechdata");
										if (tableachdata.toUpperCase().contains(eachdata.toUpperCase())) {
											System.out.println("pass");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
													tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										} else {
											System.out.println("fail");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
													tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										}
									}else {
										
									
									String tableachdata = dataValue.formatCellValue(rowk.getCell(1));
									System.out.println(tableachdata + "tableechdata");
									if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
										System.out.println("pass");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}}
								}if (i1 == 2) {
									String tableachdata =dataValue.formatCellValue(rowk.getCell(2));
									System.out.println(tableachdata + "tableechdata");
									if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
										System.out.println("pass");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}
								}
								if (i1 == 3) {
									String tableachdata = dataValue.formatCellValue(rowk.getCell(4));
									System.out.println(tableachdata + "tableechdata");
									if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
										System.out.println("pass");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}
								}
								if (i1 == 4) {
									String tableachdata = dataValue.formatCellValue(rowk.getCell(3));
									System.out.println(tableachdata + "tableechdata");
									if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
										System.out.println("pass");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}
								}
								if (i1 == 5) {
									String tableachdata = dataValue.formatCellValue(rowk.getCell(7));
									System.out.println(tableachdata + "tableechdata");
									if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
										System.out.println("pass");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}
								}
								if (i1 == 6) {
									String tableachdata = dataValue.formatCellValue(rowk.getCell(6));
									System.out.println(tableachdata + "tableechdata");
									if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
										System.out.println("pass");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}
								}
								if (i1 == 7) {
									String tableachdata = dataValue.formatCellValue(rowk.getCell(5));
									System.out.println(tableachdata + "tableechdata");
									if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
										System.out.println("pass");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}
								}
								i2++;
							}

						} else {
							TestCasePrint(
									mainheading.toUpperCase() + " " + tablesubheading.toUpperCase()
											+ " SUB DATA HEADING IS NOT MATCHING",
									tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
						}

					}

				} else if (mainheading == "") {
					TestCasePrint(Tableheading.toUpperCase() + "TABLE NOT THERE", Tableheading.toUpperCase(),
							String.valueOf(mainheading.toUpperCase()));
				} else {
					TestCasePrint(Tableheading.toUpperCase() + "MAIN HEADING IS NOT MATCHING",
							Tableheading.toUpperCase(), String.valueOf(mainheading.toUpperCase()));
				}

			} catch (Exception e) {
				TestCasePrint(Tableheading + "MAIN TABLE HEADING IS NOT THERE ", Tableheading,
						String.valueOf(mainheading), String.valueOf(e));
			}
		}

		// third table end*************************
		Thread.sleep(3000);
		// Accepted Value***************

		if (TestcaseI4 != "") {
			String type = null;
			try {
				int i = 4;
				String TestcaseId = TestcaseI4;
				System.out.println(TestcaseId + "ttttttttttttttttttttt");
				int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
				int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
				System.out.println(firstrow + "ffffffff");
				System.out.println(lastrow + "llllllllllllll");

				FileInputStream file = new FileInputStream(excelPath);
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet(ExcelTabName);
				WebElement tablemainheading = driver
						.findElement(By.xpath("(//div[@class='ant-card-head'])[" + i + "]/div/div"));
				String mainheading = tablemainheading.getText();
				System.out.println(mainheading + "main heading");
				for (int j = firstrow; j <= firstrow; j++) {
					XSSFRow rowk = sheet.getRow(j);
					type = rowk.getCell(2).getStringCellValue();
					System.out.println(type+"test type");

					Tableheading = dataValue.formatCellValue(rowk.getCell(19));
				}

				System.out.println(Tableheading + "table heading");

				if (mainheading.toUpperCase().contentEquals(Tableheading.toUpperCase()) && mainheading != null) {
					System.out.println("main heading matching");
					TestCasePrint(Tableheading.toUpperCase() + "MAIN HEADING IS MATCHING", Tableheading.toUpperCase(),
							String.valueOf(mainheading.toUpperCase()));
					if (type.toUpperCase().contains("TRUE") || type.toUpperCase().contains("FALSE")) {

						WebElement table = driver
								.findElement(By.xpath("(//thead[@class='ant-table-thead'])[" + i + "]/tr[1]"));

						// Find all TH elements within the table
						List<WebElement> headings = table.findElements(By.tagName("th"));

						// Get the count of table headings
						int count = headings.size();
						System.out.println(count + "count************");

						for (int i1 = 1; i1 <= count - 2; i1++) {
							System.out.println(i1 + "loooopppppppp");
							WebElement tableeachheading = driver.findElement(
									By.xpath("(//thead[@class='ant-table-thead'])[" + i + "]/tr/th[" + i1 + "]"));

							String subheading = tableeachheading.getText();
							System.out.println(subheading + "subtable");
							for (int j = firstrow - 1; j <= firstrow - 1; j++) {
								XSSFRow rowk = sheet.getRow(j);
								if (i1 == 1) {
									tablesubheading = dataValue.formatCellValue(rowk.getCell(i1));
									System.out.println(tablesubheading + "tablesubheading");
								}
								if (i1 == 2) {
									tablesubheading = dataValue.formatCellValue(rowk.getCell(3));
									System.out.println(tablesubheading + "tablesubheading");
								}
								if (i1 == 3) {
									tablesubheading = dataValue.formatCellValue(rowk.getCell(6));
									System.out.println(tablesubheading + "tablesubheading");
								}
								if (i1 == 4) {
									tablesubheading = dataValue.formatCellValue(rowk.getCell(18));
									System.out.println(tablesubheading + "tablesubheading");
								}
							}
							if (subheading.toUpperCase().contentEquals(tablesubheading.toUpperCase())) {
								System.out.println("sub data heading matching");
								TestCasePrint(
										mainheading.toUpperCase() + " " + tablesubheading.toUpperCase()
												+ " SUB DATA HEADING IS MATCHING",
										tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
//						}else {
//							 TestCasePrint(tablesubheading.toUpperCase()+"SUB DATA HEADING IS NOT MATCHING", tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
//						}
								// Locate the table element
								WebElement table1 = driver
										.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[" + i + "]"));

								// Find all TH elements within the table
								List<WebElement> headings1 = table1.findElements(By.tagName("tr"));

								// Get the count of table headings
								int count1 = headings1.size();
								System.out.println(count1 + "count1************");

								// for (int i2 = 1; i2 <= count1; i2++) {
								int i2 = 1;
								for (int j = firstrow; j <= lastrow; j++) {
									WebElement tabledata = driver
											.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[" + i + "]/tr["
													+ (i2 + 1) + "]/td[" + i1 + "]"));
									System.out.println(tabledata);
									String eachdata = tabledata.getText();
									System.out.println(eachdata + "eachdata");
									XSSFRow rowk = sheet.getRow(j);
									if (i1 == 1) {
										String tableachdata = dataValue.formatCellValue(rowk.getCell(i1));
										System.out.println(tableachdata + "tableechdata");
										if (eachdata.toUpperCase().replaceAll(" ", "").contains(tableachdata.toUpperCase().replaceAll(" ", ""))) {
											System.out.println("pass");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
													tableachdata.toUpperCase().replaceAll(" ", "") , String.valueOf(eachdata.toUpperCase().replaceAll(" ", "")));
										} else {
											System.out.println("fail");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
													tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										}
									}
									if (i1 == 2) {
										String tableachdata = dataValue.formatCellValue(rowk.getCell(3));
										System.out.println(tableachdata + "tableechdata");
										if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
											System.out.println("pass");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
													tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										} else {
											System.out.println("fail");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
													tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										}
									}
									if (i1 == 3) {
										String tableachdata = dataValue.formatCellValue(rowk.getCell(6));
										System.out.println(tableachdata + "tableechdata");
										if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
											System.out.println("pass");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
													tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										} else {
											System.out.println("fail");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
													tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										}
									}
									if (i1 == 4) {
										String tableachdata = dataValue.formatCellValue(rowk.getCell(18));
										System.out.println(tableachdata + "tableechdata");
										if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
											System.out.println("pass");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
													tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										} else {
											System.out.println("fail");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
													tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										}
									}
									i2++;
								}

							} else {
								TestCasePrint(
										mainheading.toUpperCase() + " " + tablesubheading.toUpperCase()
												+ " SUB DATA HEADING IS NOT MATCHING",
										tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
							}

						}
					}
					// material wise conform
					else {

						WebElement table = driver
								.findElement(By.xpath("(//thead[@class='ant-table-thead'])[" + i + "]/tr[1]"));

						// Find all TH elements within the table
						List<WebElement> headings = table.findElements(By.tagName("th"));

						// Get the count of table headings
						int count = headings.size();
						System.out.println(count + "count************");

						for (int i1 = 1; i1 <= count - 2; i1++) {
							System.out.println(i1 + "loooopppppppp");
							WebElement tableeachheading = driver.findElement(
									By.xpath("(//thead[@class='ant-table-thead'])[" + i + "]/tr/th[" + i1 + "]"));

							String subheading = tableeachheading.getText();
							System.out.println(subheading + "subtable");
							for (int j = firstrow - 1; j <= firstrow - 1; j++) {
								XSSFRow rowk = sheet.getRow(j);
								if (i1 == 1) {
									tablesubheading = dataValue.formatCellValue(rowk.getCell(i1));
									System.out.println(tablesubheading + "tablesubheading");
								} else if (i1 == 2) {
									matconditionvalue = dataValue.formatCellValue(rowk.getCell(5));
									String[] splitData = matconditionvalue.split(",");
									tablesubheading = splitData[0];
									System.out.println(tablesubheading + "tablesubheading");
								} else if (i1 == 3) {
									matconditionvalue = dataValue.formatCellValue(rowk.getCell(5));
									String[] splitData = matconditionvalue.split(",");
									String conditionvalue = splitData[1];
									String[] splittData = conditionvalue.trim().split(" ");
									tablesubheading = splittData[0];
									System.out.println(tablesubheading + "tablesubheading");
								} else if (i1 == 4) {
									matconditionvalue = dataValue.formatCellValue(rowk.getCell(5));
									String[] splitData = matconditionvalue.split(",");
									String conditionvalue = splitData[1];
									String[] splittData = conditionvalue.split(" ");
									tablesubheading = splittData[1];
									System.out.println(tablesubheading + "--tablesubheading");
								}
							}
							if (subheading.toUpperCase().contentEquals(tablesubheading.toUpperCase())) {
								System.out.println("sub data heading matching");
								TestCasePrint(
										mainheading.toUpperCase() + " " + tablesubheading.toUpperCase()
												+ " SUB DATA HEADING IS MATCHING",
										tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
//						}else {
//							 TestCasePrint(tablesubheading.toUpperCase()+"SUB DATA HEADING IS NOT MATCHING", tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
//						}
								// Locate the table element
								WebElement table1 = driver
										.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[" + i + "]"));

								// Find all TH elements within the table
								List<WebElement> headings1 = table1.findElements(By.tagName("tr"));

								// Get the count of table headings
								int count1 = headings1.size();
								System.out.println(count1 + "count1************");

								// for (int i2 = 1; i2 <= count1; i2++) {
								int i2 = 1;
								for (int j = firstrow; j <= lastrow; j++) {
									WebElement tabledata = driver
											.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[" + i + "]/tr["
													+ (i2 + 1) + "]/td[" + i1 + "]"));
									System.out.println(tabledata);
									String eachdata = tabledata.getText();
									System.out.println(eachdata + "eachdata");
									XSSFRow rowk = sheet.getRow(j);
									if (i1 == 1) {
										String tableachdata = dataValue.formatCellValue(rowk.getCell(i1));
										System.out.println(tableachdata + "tableechdata");
										if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
											System.out.println("pass");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
													tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										} else {
											System.out.println("fail");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
													tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										}
									}
									if (i1 == 2) {
										matconditionvalue = dataValue.formatCellValue(rowk.getCell(5));
										String[] splitData = matconditionvalue.split(",");
										String tableachdata = splitData[0];

										System.out.println(tableachdata + "tableechdata");
										if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
											System.out.println("pass");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
													tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										} else {
											System.out.println("fail");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
													tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										}
									}
									String stableachdata;
									if (i1 == 3) {
										matconditionvalue = dataValue.formatCellValue(rowk.getCell(5));
										String[] splitData = matconditionvalue.split(",");
										String conditionvalue = splitData[1];
										String[] splittData = conditionvalue.split(" ");
										int datalength = splittData.length;
										stableachdata = splittData[0];
										System.out.println(stableachdata + "///////*********/////");
										String tableachdata = null;
										if (datalength == 2) {
											stableachdata = splittData[0];

											if (stableachdata.equals("=")) {
												tableachdata = "EQUAL";
											} else if (stableachdata.equals(">=")) {
												tableachdata = "Greater than or Equal";
											} else if (stableachdata.equals("<=")) {
												tableachdata = " Less than or Equal";
											}
										} else if (datalength > 2) {
											stableachdata = splittData[1];
											if (stableachdata.equals("-")) {
												tableachdata = "Between";
											}
										}
										System.out.println(tableachdata + "tableechdata");
										if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
											System.out.println("pass");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
													tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										} else {
											System.out.println("fail");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
													tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										}
									}
									if (i1 == 4) {

										matconditionvalue = dataValue.formatCellValue(rowk.getCell(5));
										String[] splitData = matconditionvalue.split(",");
										String conditionvalue = splitData[1];
										String[] splittData = conditionvalue.split(" ");
										int datalength = splittData.length;
										String tableachdata = null;
										if (datalength == 2) {
											tableachdata = splittData[1];
											System.out.println(tableachdata + "///////*********/////");

										} else if (datalength > 2) {
											matconditionvalue = dataValue.formatCellValue(rowk.getCell(5));
											splitData = matconditionvalue.split(",");
											 conditionvalue = splitData[1];
										}
System.out.println(conditionvalue +"****/////////*******");
										System.out.println(tableachdata + "tableechdata");
										if (eachdata.toUpperCase().contains(conditionvalue.toUpperCase())) {
											System.out.println("pass");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
													conditionvalue.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										} else {
											System.out.println("fail");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
													tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										}
									}
									i2++;
								}

							} else {
								TestCasePrint(
										mainheading.toUpperCase() + " " + tablesubheading.toUpperCase()
												+ " SUB DATA HEADING IS NOT MATCHING",
										tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
							}

						}
					}
				} else if (mainheading == "") {
					TestCasePrint(Tableheading.toUpperCase() + "TABLE NOT THERE", Tableheading.toUpperCase(),
							String.valueOf(mainheading.toUpperCase()));
				} else {
					TestCasePrint(Tableheading.toUpperCase() + "MAIN HEADING IS NOT MATCHING",
							Tableheading.toUpperCase(), String.valueOf(mainheading.toUpperCase()));
				}

			} catch (Exception e) {
				TestCasePrint(Tableheading + "MAIN TABLE HEADING IS NOT THERE ", Tableheading,
						String.valueOf(mainheading), String.valueOf(e));
			}
		}
		// 4th table end***************************
		Thread.sleep(3000);
		// add keytest***************
		if (TestcaseI5 != "") {
			try {
				int i = 5;
				String TestcaseId = TestcaseI5;
				System.out.println(TestcaseId + "ttttttttttttttttttttt");
				int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
				int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
				System.out.println(firstrow + "ffffffff");
				System.out.println(lastrow + "llllllllllllll");

				FileInputStream file = new FileInputStream(excelPath);
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet(ExcelTabName);
				WebElement tablemainheading = driver
						.findElement(By.xpath("(//div[@class='ant-card-head'])[5]/div/div"));
				String mainheading = tablemainheading.getText();
				System.out.println(mainheading + "main heading");
				for (int j = firstrow; j <= firstrow; j++) {
					XSSFRow rowk = sheet.getRow(j);
					Tableheading = dataValue.formatCellValue(rowk.getCell(19));
				}
				System.out.println(Tableheading + "table heading");

				if (mainheading.toUpperCase().contentEquals(Tableheading.toUpperCase()) && mainheading != null) {
					System.out.println("main heading matching");
					TestCasePrint(Tableheading.toUpperCase() + "MAIN HEADING IS MATCHING", Tableheading.toUpperCase(),
							String.valueOf(mainheading.toUpperCase()));
//				}else {
//					 TestCasePrint(Tableheading.toUpperCase()+"MAIN HEADING IS NOT MATCHING", Tableheading.toUpperCase(), String.valueOf(mainheading.toUpperCase()));
//				}
					// Locate the table element
					WebElement table = driver
							.findElement(By.xpath("(//thead[@class='ant-table-thead'])[" + i + "]/tr[1]"));

					// Find all TH elements within the table
					List<WebElement> headings = table.findElements(By.tagName("th"));

					// Get the count of table headings
					int count = headings.size();
					System.out.println(count + "count************");

					for (int i1 = 1; i1 <= 1; i1++) {
						System.out.println(i1 + "loooopppppppp");
						WebElement tableeachheading = driver.findElement(
								By.xpath("(//thead[@class='ant-table-thead'])[" + i + "]/tr/th[" + i1 + "]"));
						String subheading = tableeachheading.getText();
						System.out.println(subheading + "subtable");
						for (int j = firstrow - 1; j <= firstrow - 1; j++) {
							XSSFRow rowk = sheet.getRow(j);
							if (i1 == 1) {
								tablesubheading = dataValue.formatCellValue(rowk.getCell(3));
								System.out.println(tablesubheading + "tablesubheading");
							}
//							if (i1 == 4) {
//								tablesubheading = rowk.getCell(12).getStringCellValue();
//								System.out.println(tablesubheading + "tablesubheading");
//							}
						}
						if (subheading.toUpperCase().contentEquals(tablesubheading.toUpperCase())) {
							System.out.println("sub data heading matching");
							TestCasePrint(
									mainheading.toUpperCase() + " " + tablesubheading.toUpperCase()
											+ " SUB DATA HEADING IS MATCHING",
									tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
//						}else {
//							 TestCasePrint(tablesubheading.toUpperCase()+"SUB DATA HEADING IS NOT MATCHING", tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
//						}
							// Locate the table element
							WebElement table1 = driver
									.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[" + i + "]"));

							// Find all TH elements within the table
							List<WebElement> headings1 = table1.findElements(By.tagName("tr"));

							// Get the count of table headings
							int count1 = headings1.size();
							System.out.println(count1 + "count1************");

							// for (int i2 = 1; i2 <= count1; i2++) {
							int i2 = 1;
							for (int j = firstrow; j <= lastrow; j++) {
								WebElement tabledata = driver
										.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[" + i + "]/tr["
												+ (i2 + 1) + "]/td[" + i1 + "]"));
								System.out.println(tabledata);
								String eachdata = tabledata.getText();
								System.out.println(eachdata + "eachdata");
								XSSFRow rowk = sheet.getRow(j);
								if (i1 == 1) {
									if (Value1) {

									}
									String tableachdata = dataValue.formatCellValue(rowk.getCell(3));
									System.out.println(tableachdata + "tableechdata");
									if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
										System.out.println("pass");
										// TestCasePrint(tablesubheading.toUpperCase()+" DATA IS MATCHING",
										// tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										// TestCasePrint(tablesubheading.toUpperCase()+" DATA IS NOT MATCHING",
										// tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}
								}
//									if (i1 == 4) {
//										String tableachdata = rowk.getCell(12).getStringCellValue();
//										System.out.println(tableachdata + "tableechdata");
//										if (eachdata == tableachdata) {
//											System.out.println("pass");
//										} else {
//											System.out.println("fail");
//										}
//									}
								i2++;
							}

						} else {
							TestCasePrint(
									mainheading.toUpperCase() + " " + tablesubheading.toUpperCase()
											+ " SUB DATA HEADING IS NOT MATCHING",
									tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
						}

					}

				} else if (mainheading == "") {
					TestCasePrint(Tableheading.toUpperCase() + "TABLE NOT THERE", Tableheading.toUpperCase(),
							String.valueOf(mainheading.toUpperCase()));
				} else {
					TestCasePrint(Tableheading.toUpperCase() + "MAIN HEADING IS NOT MATCHING",
							Tableheading.toUpperCase(), String.valueOf(mainheading.toUpperCase()));
				}

			} catch (Exception e) {
				TestCasePrint(Tableheading + "MAIN TABLE HEADING IS NOT THERE ", Tableheading,
						String.valueOf(mainheading), String.valueOf(e));
			}
		}

		// 5th table end***************************
		if (TestcaseI7 != "") {

			Thread.sleep(3000);
			try {
				int i = 6;
				String TestcaseId = TestcaseI7;
				System.out.println(TestcaseId + "ttttttttttttttttttttt");
				int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
				int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
				System.out.println(firstrow + "ffffffff");
				System.out.println(lastrow + "llllllllllllll");

				FileInputStream file = new FileInputStream(excelPath);
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet(ExcelTabName);
				WebElement tablemainheading = driver
						.findElement(By.xpath("(//div[@class='ant-card-head'])[" + i + "]/div/div"));
				System.out.println(tablemainheading);
				mainheading = tablemainheading.getText();
				System.out.println(mainheading + "main heading");
				for (int j = firstrow; j <= firstrow; j++) {
					XSSFRow rowk = sheet.getRow(j);
					Tableheading = dataValue.formatCellValue(rowk.getCell(19));
				}
				System.out.println(Tableheading + "table heading");

				if (mainheading.toUpperCase().contentEquals(Tableheading.toUpperCase()) && mainheading != null) {
					System.out.println("main heading matching");
					TestCasePrint(Tableheading.toUpperCase() + "MAIN HEADING IS MATCHING", Tableheading.toUpperCase(),
							String.valueOf(mainheading.toUpperCase()));
//				}else {
//					 TestCasePrint(Tableheading.toUpperCase()+"MAIN HEADING IS NOT MATCHING", Tableheading.toUpperCase(), String.valueOf(mainheading.toUpperCase()));
//				}
					// Locate the table element
					WebElement table = driver
							.findElement(By.xpath("(//thead[@class='ant-table-thead'])[" + i + "]/tr[1]"));

					// Find all TH elements within the table
					List<WebElement> headings = table.findElements(By.tagName("th"));

					// Get the count of table headings
					int count = headings.size();
					System.out.println(count + "count************");

					for (int i1 = 1; i1 < count; i1++) {
						System.out.println(i1 + "loooopppppppp");
						WebElement tableeachheading = driver.findElement(
								By.xpath("(//thead[@class='ant-table-thead'])[" + i + "]/tr/th[" + i1 + "]"));
						System.out.println(tableeachheading);
						String subheading = tableeachheading.getText();
						System.out.println(subheading + "subtable");
						for (int j = firstrow - 1; j <= firstrow - 1; j++) {
							XSSFRow rowk = sheet.getRow(j);
							if (i1 == 1) {
								tablesubheading = dataValue.formatCellValue(rowk.getCell(1));
								System.out.println(tablesubheading + "tablesubheading");
							}
							if (i1 == 2) {
								tablesubheading = dataValue.formatCellValue(rowk.getCell(3));
								System.out.println(tablesubheading + "tablesubheading");
							}
							if (i1 == 3) {
								tablesubheading = dataValue.formatCellValue(rowk.getCell(2));
								System.out.println(tablesubheading + "tablesubheading");
							}
							if (i1 == 4) {
								tablesubheading = dataValue.formatCellValue(rowk.getCell(5));
								System.out.println(tablesubheading + "tablesubheading");
							}
						}
						if (subheading.toUpperCase().contentEquals(tablesubheading.toUpperCase())) {
							System.out.println("sub data heading matching");
							TestCasePrint(
									mainheading.toUpperCase() + " " + tablesubheading.toUpperCase()
											+ " SUB DATA HEADING IS MATCHING",
									tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
//						}else {
//							 TestCasePrint(tablesubheading.toUpperCase()+"SUB DATA HEADING IS NOT MATCHING", tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
//						}
//							// Locate the table element
							WebElement table1 = driver
									.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[" + i + "]"));

							// Find all TH elements within the table
							List<WebElement> headings1 = table1.findElements(By.tagName("tr"));

							// Get the count of table headings
							int count1 = headings1.size();
							System.out.println(count1 + "count1************");

							// for (int i2 = 1; i2 <= count1; i2++) {
							int i2 = 1;

							for (int j = firstrow; j <= lastrow; j++) {
								WebElement tabledata = driver
										.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[" + i + "]/tr[" + i2
												+ "]/td[" + i1 + "]"));
								System.out.println(tabledata);
								String eachdata = tabledata.getText();
								System.out.println(eachdata + "eachdata");
								XSSFRow rowk = sheet.getRow(j);
								if (i1 == 1) {
									String tableachdata = dataValue.formatCellValue(rowk.getCell(1));
									System.out.println(tableachdata + "tableechdata");
									if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
										System.out.println("pass");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}
								}
								if (i1 == 2) {
									String tableachdata = dataValue.formatCellValue(rowk.getCell(3));
									System.out.println(tableachdata + "tableechdata");
									if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
										System.out.println("pass");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}
								}
								if (i1 == 3) {
									String tableachdata = dataValue.formatCellValue(rowk.getCell(2));
									System.out.println(tableachdata + "tableechdata");
									if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
										System.out.println("pass");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}
								}
								if (i1 == 4) {
//										String tableachdata = rowk.getCell(5).getStringCellValue();
//										System.out.println(tableachdata + "tableechdata");
//										if (eachdata.equals(tableachdata)) {
//											System.out.println("pass");
//											 TestCasePrint(tablesubheading+" DATA IS MATCHING", tableachdata, String.valueOf(eachdata));
//										} else {
//											System.out.println("fail");
//											 TestCasePrint(tablesubheading+"DATA IS NOT MATCHING", tableachdata, String.valueOf(eachdata));
//										}
								}
								i2++;
							}

						} else {
							TestCasePrint(
									mainheading.toUpperCase() + " " + tablesubheading.toUpperCase()
											+ " SUB DATA HEADING IS NOT MATCHING",
									tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
						}

					}

				} else if (mainheading == "") {
					TestCasePrint(Tableheading.toUpperCase() + "TABLE NOT THERE", Tableheading.toUpperCase(),
							String.valueOf(mainheading.toUpperCase()));

				} else {
					TestCasePrint(Tableheading.toUpperCase() + "MAIN HEADING IS NOT MATCHING",
							Tableheading.toUpperCase(), String.valueOf(mainheading.toUpperCase()));
				}

			} catch (Exception e) {
				TestCasePrint(Tableheading + "MAIN TABLE HEADING IS NOT THERE *****", Tableheading,
						String.valueOf(mainheading), String.valueOf(e));
			}
		}

		// 6th table end****************************
		Thread.sleep(3000);
		if (TestcaseI6 != "") {
			Tableheading = null;
			try {
				int i = 7;
				String TestcaseId = TestcaseI6;
				System.out.println(TestcaseId + "ttttttttttttttttttttt");
				int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
				int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
				System.out.println(firstrow + "ffffffff");
				System.out.println(lastrow + "llllllllllllll");

				FileInputStream file = new FileInputStream(excelPath);
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet(ExcelTabName);
				WebElement tablemainheading = driver
						.findElement(By.xpath("(//div[@class='ant-card-head'])[" + i + "]/div/div"));
				mainheading = tablemainheading.getText();
				System.out.println(mainheading + "main heading");
				for (int j = firstrow; j <= firstrow; j++) {
					XSSFRow rowk = sheet.getRow(j);
					Tableheading = dataValue.formatCellValue(rowk.getCell(19));
				}
				System.out.println(Tableheading + "table heading");

				if (mainheading.toUpperCase().contentEquals(Tableheading.toUpperCase()) && Tableheading != "") {
					System.out.println("main heading matching");
					TestCasePrint(Tableheading.toUpperCase() + "MAIN HEADING IS MATCHING", Tableheading.toUpperCase(),
							String.valueOf(mainheading.toUpperCase()));
//				}else {
//					 TestCasePrint(Tableheading.toUpperCase()+"MAIN HEADING IS NOT MATCHING", Tableheading.toUpperCase(), String.valueOf(mainheading.toUpperCase()));
//				}
					// Locate the table element
					WebElement table = driver
							.findElement(By.xpath("(//thead[@class='ant-table-thead'])[" + i + "]/tr[1]"));

					// Find all TH elements within the table
					List<WebElement> headings = table.findElements(By.tagName("th"));

					// Get the count of table headings
					int count = headings.size();
					System.out.println(count + "count************");

					for (int i1 = 1; i1 <= count; i1++) {
						System.out.println(i1 + "loooopppppppp");
						WebElement tableeachheading = driver.findElement(
								By.xpath("(//thead[@class='ant-table-thead'])[" + i + "]/tr/th[" + i1 + "]"));
						String subheading = tableeachheading.getText();
						System.out.println(subheading + "subtable");
						for (int j = firstrow - 1; j <= firstrow - 1; j++) {
							XSSFRow rowk = sheet.getRow(j);
							if (i1 == 1) {
								tablesubheading = dataValue.formatCellValue(rowk.getCell(1));
								System.out.println(tablesubheading + "tablesubheading");
							}
							if (i1 == 2) {
								tablesubheading = dataValue.formatCellValue(rowk.getCell(3));
								System.out.println(tablesubheading + "tablesubheading");
							}

						}
						if (subheading.toUpperCase().contentEquals(tablesubheading.toUpperCase())) {
							System.out.println("sub data heading matching");
							TestCasePrint(
									mainheading.toUpperCase() + " " + tablesubheading.toUpperCase()
											+ " SUB DATA HEADING IS MATCHING",
									tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
//						}else {
//							 TestCasePrint(tablesubheading.toUpperCase()+"SUB DATA HEADING IS NOT MATCHING", tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
//						}
							// Locate the table element
							WebElement table1 = driver
									.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[" + i + "]"));

							// Find all TH elements within the table
							List<WebElement> headings1 = table1.findElements(By.tagName("tr"));

							// Get the count of table headings
							int count1 = headings1.size();
							System.out.println(count1 + "count1************");
							// int testCount = (int) rowk.getCell(2).getNumericCellValue();
							// for (int i2 = 1; i2 <= count1; i2++) {
							int i2 = 1;
							for (int j = firstrow; j <= lastrow; j++) {

								XSSFRow rowk = sheet.getRow(j);
								String testCount11 = dataValue.formatCellValue(rowk.getCell(2));
								int testCount=Integer.valueOf(testCount11);
								int i4 = 1;

								if (i1 == 1) {
									WebElement tabledata = driver
											.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[" + i + "]/tr["
													+ i2 + "]/td[" + i1 + "]"));
									String eachdata = tabledata.getText();
									System.out.println(eachdata + "eachdata");
									String tableachdata = dataValue.formatCellValue(rowk.getCell(1));
									System.out.println(tableachdata + "tableechdata");
									if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
										System.out.println("pass");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									} else {
										System.out.println("fail");
										TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
												tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
									}
								}
								for (int i3 = 3; i3 < (3 + testCount); i3++) {
									if (i1 == 2) {
										WebElement tabledata = driver
												.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[" + i
														+ "]/tr[" + i2 + "]/td[" + i1 + "]/p[" + i4 + "]"));
										String eachdata = tabledata.getText();
										System.out.println(eachdata + "eachdata");
										String tableachdata = dataValue.formatCellValue(rowk.getCell(i3));
										System.out.println(tableachdata + "tableechdata");
										if (eachdata.toUpperCase().contains(tableachdata.toUpperCase())) {
											System.out.println("pass");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS MATCHING",
													tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										} else {
											System.out.println("fail");
											TestCasePrint(tablesubheading.toUpperCase() + " DATA IS NOT MATCHING",
													tableachdata.toUpperCase(), String.valueOf(eachdata.toUpperCase()));
										}
									}
									i4++;
								}
								i2++;
							}

						} else {
							TestCasePrint(
									mainheading.toUpperCase() + " " + tablesubheading.toUpperCase()
											+ " SUB DATA HEADING IS NOT MATCHING",
									tablesubheading.toUpperCase(), String.valueOf(subheading.toUpperCase()));
						}

					}

				} else if (mainheading == "") {
					TestCasePrint(Tableheading.toUpperCase() + "TABLE NOT THERE", Tableheading.toUpperCase(),
							String.valueOf(mainheading.toUpperCase()));
				} else {
					TestCasePrint(Tableheading.toUpperCase() + "MAIN HEADING IS NOT MATCHING",
							Tableheading.toUpperCase(), String.valueOf(mainheading.toUpperCase()));
				}

			} catch (Exception e) {
				TestCasePrint(Tableheading + "MAIN TABLE HEADING IS NOT THERE ", Tableheading,
						String.valueOf(mainheading), String.valueOf(e));
			}
		}

		// 7th table end****************************
//		}
		TestParameterStep.addgroupkey=false;
	}

	// test case print
	public static void TestCasePrint(String TestCaseName) {
		TestCasePrint(TestCaseName, null, null, null);
	}

	public static void TestCasePrint(String TestCaseName, Object expectedValue, Object actualValue) {
		TestCasePrint(TestCaseName, expectedValue, actualValue, null);
	}

	public static void TestCasePrint(String TestCaseName, Object expectedValue, Object actualValue1,
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
		CharSequence actualValue = actualValue1.toString();
		if (expectedValue != null && actualValue != null) {
			boolean position = true;

			ExtentTest testCase = extent.createTest(TestCaseName);

			try {
				AssertJUnit.assertEquals(actualValue, expectedValue);
			} catch (AssertionError e) {
				position = false;
			}
			if (((String) expectedValue).contains(actualValue)) {

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
//					testCase.log(Status.INFO, TestCaseName);
		}

	}

}
