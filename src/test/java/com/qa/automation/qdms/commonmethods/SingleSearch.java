package com.qa.automation.qdms.commonmethods;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class SingleSearch extends DriverIntialization {
	public static boolean searchBtn = false;

	public static void singleSearchMethod(int searchColumnNo, WebElement searchTextBox, String workBookName,
			String tabName, String testcaseId, int searchData, int searchExpecte) {
		DataFormatter datavalue = new DataFormatter();
		boolean searchiconClick = false;
		boolean textBox = false;
		boolean input = false;
		searchBtn = false;
		int expetSearchCounts = 0;
		String TestData = null;
		boolean takecount = false;
		int count = 0;
		String column = null;

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + workBookName + ".xlsx";
		int firstrow = CommonMethods.getFirstRowNum(excelPath, tabName, testcaseId);
		int lastrow = CommonMethods.getLastRowNum(excelPath, tabName, testcaseId);
		try {
			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(tabName);

			for (int i = firstrow; i <= lastrow; i++) {
				
				XSSFRow row = sheet.getRow(i);
				TestData = datavalue.formatCellValue(row.getCell(searchData));
				String expetSearchCount = datavalue.formatCellValue(row.getCell(searchExpecte));

//				CREATE TEST
				testCase = extent.createTest("➦CHECKING SEARCH FUNCTIONALITY");
				
//				PAGE NAVIGATION
				String pageNo = datavalue.formatCellValue(row.getCell(searchExpecte + 2));
				System.out.println("Taken Page No  :"+pageNo);
				functionality.navigateToTablePage(pageNo);

				try {
					column = driver.findElement(By.xpath("//thead/tr/th[" + searchColumnNo + "]")).getText();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				if(functionality.tablePage) {
					
					MultiSearchMethods.icon(
							driver.findElement(By.xpath("//thead/tr/th[" + searchColumnNo + "]//span[@role='button']")),
							column + " search ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						MultiSearchMethods.elementClick(driver
								.findElement(By.xpath("//thead/tr/th[" + searchColumnNo + "]//span[@role='button']")));
						searchiconClick = true;
					}
				
				}
				if (searchiconClick) {
					MultiSearchMethods.textBox(searchTextBox, column + " search ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						MultiSearchMethods.elementClick(searchTextBox);
						textBox = true;
					}
					if (textBox) {
						try {
							expetSearchCounts = Integer.parseInt(expetSearchCount);
							searchTextBox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
							searchTextBox.sendKeys(TestData);
						} catch (Exception e) {
							// TODO: handle exception
						}
						input = true;
					}
					boolean data = false;
					if (input) {

						testCase = extent.createTest(column + " Searched Input Data Conformation");
						try {
							Assert.assertEquals(searchTextBox.getAttribute("value"), TestData);
							testCase.log(Status.INFO, " Expected Data : " + TestData);
							testCase.log(Status.INFO, " Actual Data : " + searchTextBox.getAttribute("value"));
							testCase.log(Status.INFO, column + " Searched Input Data Corret");
							testCase.log(Status.PASS, "So, Pass");
							data = true;
						} catch (AssertionError e) {
							testCase.log(Status.INFO, " Expected Data : " + TestData);
							testCase.log(Status.INFO, " Expected Data : " + TestData);
							testCase.log(Status.INFO, " Actual Data : " + searchTextBox.getAttribute("value"));
							testCase.log(Status.INFO, column + " Searched Input Data Wrong");
							testCase.log(Status.PASS, "So, Fail");
							data = false;
						} catch (Exception e) {
							testCase.log(Status.INFO, " Expected Data : " + TestData);
							testCase.log(Status.INFO, " Actual Data : " + searchTextBox.getAttribute("value"));
							testCase.log(Status.INFO, column + " Searched Input Data Wrong");
							testCase.log(Status.PASS, "So, Fail");
							data = false;
						}
					}
					if (data) {
						MultiSearchMethods.Button(
								driver.findElement(By.xpath("//button[@type='button']//span[text()='Search']")),
								column + " search ");
						if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) { 
							MultiSearchMethods.elementClick(
									driver.findElement(By.xpath("//button[@type='button']//span[text()='Search']")));
							searchBtn = true;

						}
						
//						AFTER CLICK SEARCH ICON CHECKING FIRST PAGE SELECTED BY DEFAULT 
						if (searchBtn) {
							
							functionality.rightPageSelection("➢ First Page Default Selection", 1);
						
						}
						
						boolean checkData = true;
						if (searchBtn) { 
							count = 0;
							boolean next = true;
							while (next) {
								int raw = 0;
								try {
									Thread.sleep(1000);
									raw = driver.findElements(By.xpath("//tr[contains(@class,'ant-table-row')]")).size();
								} catch (Exception e) {
//									raw=11;
								}
									for (int k = 1; k <= raw; k++) {
										try {
											WebElement name = driver
													.findElement(By.xpath("//tbody/tr[contains(@class,'ant-table-row')][" + k + "]/td[" + searchColumnNo + "]"));
											String nams = name.getText().toUpperCase();
											System.out.println("!!!!!!!!!"+nams);
											if(!nams.isEmpty() && !nams.contains("NO DATA")) {
											if (nams.contains(TestData.toUpperCase())) {
												count = count + 1;
												checkData = true;
											}
											if (!nams.contains(TestData.toUpperCase())) {
												checkData = false;
											}
											}
											
										} catch (Exception e) {
											// TODO: handle exception
										}
									}
								

							try {
								next = driver.findElement(By.xpath("//li[@title='Next Page']/button")).isEnabled();
								if (next) {
									driver.findElement(By.xpath("//li[@title='Next Page']/button")).click();
								}
							} catch (Exception e) {
								next = false;
								break;
							}
						}
						takecount = true;
					}

					if (takecount && input) {
						boolean check = true;
						testCase = extent.createTest(column + " Searched Data Count");
						try {
							Assert.assertEquals(count, expetSearchCounts);
							check = true;
							testCase.log(Status.INFO, column + " Searched Actual Data Count : " + count);
							testCase.log(Status.INFO, column + " Searched Expected Data Count : " + expetSearchCounts);
							testCase.log(Status.INFO, column + " Searched Data Count Corret");
							testCase.log(Status.PASS, "So, " + column + " Filtered Count is Pass");
						} catch (AssertionError e) {
							check = false;
							testCase.log(Status.INFO, column + " Searched Actual Data Count : " + count);
							testCase.log(Status.INFO, column + " Searched Expected Data Count : " + expetSearchCounts);
							testCase.log(Status.INFO, column + " Searched Data Count Wrong");
							testCase.log(Status.FAIL, "So, " + column + " Filtered Count is Fail");
						}

						testCase = extent.createTest(column + " Searched Data Value - (" + TestData + ")");
						if (checkData) {
							testCase.log(Status.INFO, "Only " + column + " Searched Data Value Filtered");
							testCase.log(Status.PASS, "So, " + column + " Filtered Value is Pass");
						} else {
							testCase.log(Status.INFO, "Not Only " + column + " Searched Data Value Filtered");
							testCase.log(Status.FAIL, "So, " + column + " Filtered Value is Fail");
						}

						if (check && checkData) {
							testCase = extent.createTest(column + " Search Function");
							try {
								Assert.assertEquals(count, expetSearchCounts);
								testCase.log(Status.INFO, column + " Searched Value Corretly Filtered");
								testCase.log(Status.PASS, "So, " + column + " Search Pass");
							} catch (AssertionError e) {
								testCase.log(Status.INFO, column + " Searched Value Wrongly Filtered");
								testCase.log(Status.FAIL, "So, " + column + " Search Fail");
							} catch (Exception e) {
								testCase.log(Status.INFO, column + " Searched Value Wrongly Filtered");
								testCase.log(Status.FAIL, "So, " + column + " Search Fail");
							}
						} else {
							testCase = extent.createTest(column + " Search Function");
							testCase.log(Status.INFO, column + " Searched Value Wrongly Filtered");
							testCase.log(Status.FAIL, "So, " + column + " Search Fail");
						}
					}
				}

				if (searchBtn) {
					int reset = searchExpecte + 1;
					resetFunction(column, searchColumnNo, workBookName, tabName, testcaseId, reset);
				}
				}}
			
		} catch (Exception e) {
			driver.navigate().refresh();
			testCase = extent.createTest("Excel File Not Found");
			testCase.log(Status.INFO, "Excel File Not Found");
			testCase.log(Status.FAIL, "Excel File Not Found, So fail");
		}

	}

	public static void resetFunction(String column, int searchColumnNo, String workBookName, String tabName,
			String testcaseId, int resetCountExcelNo) {

		boolean resetB = false;
		boolean input = false;
		int counts = 0;
		boolean resetInput = false;
		int resetCount = 0;
		try {
			Thread.sleep(500);
			driver.findElement(By.xpath("//li[@title='1']//a")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//thead/tr/th[" + searchColumnNo + "]//span[@role='button']")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		MultiSearchMethods.Button(driver.findElement(By.xpath("//button[@type='button']//span[text()='Reset']")),
				column + " reset");
		if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
			MultiSearchMethods
					.elementClick(driver.findElement(By.xpath("//button[@type='button']//span[text()='Reset']")));
			resetB = true;
		}

		if (resetB) {
			String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + workBookName
					+ ".xlsx";
			int firstrow = CommonMethods.getFirstRowNum(excelPath, tabName, testcaseId);
			int lastrow = CommonMethods.getLastRowNum(excelPath, tabName, testcaseId);
			try {
				FileInputStream file = new FileInputStream(excelPath);
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet(tabName);
				DataFormatter datavalue = new DataFormatter();
				for (int i = firstrow; i <= lastrow; i++) {
					XSSFRow row = sheet.getRow(i);
					String expetresetCount = datavalue.formatCellValue(row.getCell(resetCountExcelNo));
					try {
						resetCount = Integer.parseInt(expetresetCount);
					} catch (Exception e) {
						// TODO: handle exception
					}
					input = true;
				}
			} catch (Exception e) {
				driver.navigate().refresh();
				testCase = extent.createTest("Excel File Not Found");
				testCase.log(Status.INFO, "Excel File Not Found");
				testCase.log(Status.FAIL, "Excel File Not Found, So fail");
			}
		}
		int m = 1;
		if (input) {
			counts = 0;
			boolean next = true;
			while (next) {
				int x = 0;

				WebDriverWait wa = new WebDriverWait(driver, 2);
				try {
					wa.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//td[1]"))));
				} catch (Exception e) {

				}
				try {
					x = driver.findElements(By.xpath("//tr[contains(@class,'ant-table-row')]/td[1]")).size();
				} catch (Exception e) {
				}
				counts = counts + x;
				m = m + 1;

				try {
					next = driver.findElement(By.xpath("//li[@title='Next Page']/button")).isEnabled();
					if (next) {
						driver.findElement(By.xpath("//li[@title='Next Page']/button")).click();
					}
				} catch (Exception e) {
					next = false;
					break;
				}
			}
			resetInput = true;
		}
		if (resetInput && input) {

			testCase = extent.createTest(column + " Reset Function");
			try {
				Assert.assertEquals(counts, resetCount);
				testCase.log(Status.INFO, column + " Reset Actual Data Count : " + counts);
				testCase.log(Status.INFO, column + " Reset Expected Data Count : " + resetCount);
				testCase.log(Status.INFO, column + " Reset Function Corretly Working");
				testCase.log(Status.PASS, "So, " + column + " Reset Function Pass");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, column + " Reset Actual Data Count : " + counts);
				testCase.log(Status.INFO, column + " Reset Expected Data Count : " + resetCount);
				testCase.log(Status.INFO, column + " Reset Function Wrongly Working");
				testCase.log(Status.FAIL, "So, " + column + " Reset Function Fail");
			} catch (Exception e) {
				testCase.log(Status.INFO, column + " Reset Actual Data Count : " + counts);
				testCase.log(Status.INFO, column + " Reset Expected Data Count : " + resetCount);
				testCase.log(Status.INFO, column + " Reset Function Wrongly Working");
				testCase.log(Status.FAIL, "So, " + column + " Reset Function Fail");
			}
		}

		try {
			driver.findElement(By.xpath("//li[@title='1']//a")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	static boolean data = false;
	public static void userSingleSearchMethod(int searchColumnNo, WebElement searchTextBox, String workBookName,
			String tabName, String testcaseId, int searchData, int searchExpecte,int no) {
		new WebDriverWait(driver, 10);
		DataFormatter datavalue = new DataFormatter();
		boolean textBox = false;
		boolean input = false;
		searchBtn = false;
		int expetSearchCounts = 0;
		String TestData = null;
		boolean takecount = false;
		int count = 0;
		String column = null;
		column="Add User ";
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + workBookName + ".xlsx";
		int firstrow = CommonMethods.getFirstRowNum(excelPath, tabName, testcaseId);
		int lastrow = CommonMethods.getLastRowNum(excelPath, tabName, testcaseId);
		try {
			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(tabName);

			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);
				TestData = datavalue.formatCellValue(row.getCell(searchData));
				String expetSearchCount = datavalue.formatCellValue(row.getCell(searchExpecte));
				testCase = extent.createTest("➦CHECKING SEARCH FUNCTIONALITY");
//				PAGE NAVIGATION
				String pageNo = datavalue.formatCellValue(row.getCell(searchExpecte + 2));
				System.out.println("Taken Page No  :"+pageNo);
				functionality.navigateToTablePage(pageNo);
				
if(functionality.tablePage) {
					MultiSearchMethods.textBox(searchTextBox, column + " search ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						MultiSearchMethods.elementClick(searchTextBox);
						textBox = true;
					}
}
					if (textBox) {
						try {
							expetSearchCounts = Integer.parseInt(expetSearchCount);
							searchTextBox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
							searchTextBox.sendKeys(TestData);
						} catch (Exception e) {
							// TODO: handle exception
						}
						input = true;
					}
					
//					AFTER CLICK SEARCH ICON CHECKING FIRST PAGE SELECTED BY DEFAULT 
					if (input) {
						
						functionality.rightPageSelection("➢ First Page Default Selection", 1);
					
					}
					 data = false;
					if (input) {

						testCase = extent.createTest(column + " Searched Input Data Conformation");
						try {
							Assert.assertEquals(searchTextBox.getAttribute("value"), TestData);
							testCase.log(Status.INFO, " Expected Data : " + TestData);
							testCase.log(Status.INFO, " Actual Data : " + searchTextBox.getAttribute("value"));
							testCase.log(Status.INFO, column + " Searched Input Data Corret");
							testCase.log(Status.PASS, "So, Pass");
							data = true;
						} catch (AssertionError e) {
							testCase.log(Status.INFO, " Expected Data : " + TestData);
							testCase.log(Status.INFO, " Expected Data : " + TestData);
							testCase.log(Status.INFO, " Actual Data : " + searchTextBox.getAttribute("value"));
							testCase.log(Status.INFO, column + " Searched Input Data Wrong");
							testCase.log(Status.PASS, "So, Fail");
							data = false;
						} catch (Exception e) {
							testCase.log(Status.INFO, " Expected Data : " + TestData);
							testCase.log(Status.INFO, " Actual Data : " + searchTextBox.getAttribute("value"));
							testCase.log(Status.INFO, column + " Searched Input Data Wrong");
							testCase.log(Status.PASS, "So, Fail");
							data = false;
						}
					}
					
					
						boolean checkData = true;
						if (data) {
							count = 0;
							boolean next = true;
							while (next) {
								int raw = 0;
								try {
									Thread.sleep(1000);
									raw = driver.findElements(By.xpath("(//tbody)[2]//tr[contains(@class,'ant-table-row')]")).size();
								} catch (Exception e) {
//									raw=11;
								}
									for (int k = 1; k <= raw; k++) {
										try {
											WebElement name = driver
													.findElement(By.xpath("(//tbody)[2]/tr[contains(@class,'ant-table-row')][" + k + "]/td[" + searchColumnNo + "]"));
											String nams = name.getText().toUpperCase();
											System.out.println("!!!!!!!!!"+nams);
											if(!nams.isEmpty() && !nams.contains("NO DATA")) {
											if (nams.contains(TestData.toUpperCase())) {
												count = count + 1;
												checkData = true;
											}
											if (!nams.contains(TestData.toUpperCase())) {
												checkData = false;
											}
											}
											
										} catch (Exception e) {
											// TODO: handle exception
										}
									}
								

							try {
								next = driver.findElement(By.xpath("//div[@class='ant-transfer ant-transfer-customize-list']/div["+no+"]//li[@title='Next Page']/button")).isEnabled();
								if (next) {
									driver.findElement(By.xpath("//div[@class='ant-transfer ant-transfer-customize-list']/div["+no+"]//li[@title='Next Page']/button")).click();
								}
							} catch (Exception e) {
								next = false;
								break;
							}
						}
						takecount = true;
					}

					if (takecount && input) {
						boolean check = true;
						testCase = extent.createTest(column + " Searched Data Count");
						try {
							Assert.assertEquals(count, expetSearchCounts);
							check = true;
							testCase.log(Status.INFO, column + " Searched Actual Data Count : " + count);
							testCase.log(Status.INFO, column + " Searched Expected Data Count : " + expetSearchCounts);
							testCase.log(Status.INFO, column + " Searched Data Count Corret");
							testCase.log(Status.PASS, "So, " + column + " Filtered Count is Pass");
						} catch (AssertionError e) {
							check = false;
							testCase.log(Status.INFO, column + " Searched Actual Data Count : " + count);
							testCase.log(Status.INFO, column + " Searched Expected Data Count : " + expetSearchCounts);
							testCase.log(Status.INFO, column + " Searched Data Count Wrong");
							testCase.log(Status.FAIL, "So, " + column + " Filtered Count is Fail");
						}

						testCase = extent.createTest(column + " Searched Data Value - (" + TestData + ")");
						if (checkData) {
							testCase.log(Status.INFO, "Only " + column + " Searched Data Value Filtered");
							testCase.log(Status.PASS, "So, " + column + " Filtered Value is Pass");
						} else {
							testCase.log(Status.INFO, "Not Only " + column + " Searched Data Value Filtered");
							testCase.log(Status.FAIL, "So, " + column + " Filtered Value is Fail");
						}

						if (check && checkData) {
							testCase = extent.createTest(column + " Search Function");
							try {
								Assert.assertEquals(count, expetSearchCounts);
								testCase.log(Status.INFO, column + " Searched Value Corretly Filtered");
								testCase.log(Status.PASS, "So, " + column + " Search Pass");
							} catch (AssertionError e) {
								testCase.log(Status.INFO, column + " Searched Value Wrongly Filtered");
								testCase.log(Status.FAIL, "So, " + column + " Search Fail");
							} catch (Exception e) {
								testCase.log(Status.INFO, column + " Searched Value Wrongly Filtered");
								testCase.log(Status.FAIL, "So, " + column + " Search Fail");
							}
						} else {
							testCase = extent.createTest(column + " Search Function");
							testCase.log(Status.INFO, column + " Searched Value Wrongly Filtered");
							testCase.log(Status.FAIL, "So, " + column + " Search Fail");
						}
					}
				}

				if (data) {
					int reset = searchExpecte + 1;
					userResetFunction(column, searchColumnNo, workBookName, tabName, testcaseId, reset,no);
				}
				
			
		} catch (Exception e) {
			driver.navigate().refresh();
			testCase = extent.createTest("Excel File Not Found");
			testCase.log(Status.INFO, "Excel File Not Found");
			testCase.log(Status.FAIL, "Excel File Not Found, So fail");
		}

	}
	
	public static void userResetFunction(String column, int searchColumnNo, String workBookName, String tabName,
			String testcaseId, int resetCountExcelNo,int no) {

		boolean resetB = false;
		boolean input = false;
		int counts = 0;
		boolean resetInput = false;
		int resetCount = 0;
		try {
			Thread.sleep(500);
			driver.findElement(By.xpath("//div[@class='ant-transfer ant-transfer-customize-list']/div["+no+"]//li[@title='1']//a")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		MultiSearchMethods.icon(driver.findElement(By.xpath("//div[@class='ant-transfer ant-transfer-customize-list']/div["+no+"]//input[@placeholder='Search here']//../a/span")),
				column + " reset");
		if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
			MultiSearchMethods
					.elementClick(driver.findElement(By.xpath("//div[@class='ant-transfer ant-transfer-customize-list']/div["+no+"]//input[@placeholder='Search here']//../a/span")));
			resetB = true;
		}

		if (resetB) {
			String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + workBookName
					+ ".xlsx";
			int firstrow = CommonMethods.getFirstRowNum(excelPath, tabName, testcaseId);
			int lastrow = CommonMethods.getLastRowNum(excelPath, tabName, testcaseId);
			try {
				FileInputStream file = new FileInputStream(excelPath);
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet(tabName);
				DataFormatter datavalue = new DataFormatter();
				for (int i = firstrow; i <= lastrow; i++) {
					XSSFRow row = sheet.getRow(i);
					String expetresetCount = datavalue.formatCellValue(row.getCell(resetCountExcelNo));
					try {
						resetCount = Integer.parseInt(expetresetCount);
					} catch (Exception e) {
						// TODO: handle exception
					}
					input = true;
				}
			} catch (Exception e) {
				driver.navigate().refresh();
				testCase = extent.createTest("Excel File Not Found");
				testCase.log(Status.INFO, "Excel File Not Found");
				testCase.log(Status.FAIL, "Excel File Not Found, So fail");
			}
		}
		int m = 1;
		if (input) {
			counts = 0;
			boolean next = true;
			while (next) {
				int x = 0;

				WebDriverWait wa = new WebDriverWait(driver, 2);
				try {
					wa.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//td[1]"))));
				} catch (Exception e) {

				}
				try {
					x = driver.findElements(By.xpath("(//tbody)[2]//tr[contains(@class,'ant-table-row')]/td[1]")).size();
				} catch (Exception e) {
				}
				counts = counts + x;
				m = m + 1;

				try {
					next = driver.findElement(By.xpath("//div[@class='ant-transfer ant-transfer-customize-list']/div["+no+"]//li[@title='Next Page']/button")).isEnabled();
					if (next) {
						driver.findElement(By.xpath("//div[@class='ant-transfer ant-transfer-customize-list']/div["+no+"]//li[@title='Next Page']/button")).click();
					}
				} catch (Exception e) {
					next = false;
					break;
				}
			}
			resetInput = true;
		}
		if (resetInput && input) {

			testCase = extent.createTest(column + " Reset Function");
			try {
				Assert.assertEquals(counts, resetCount);
				testCase.log(Status.INFO, column + " Reset Actual Data Count : " + counts);
				testCase.log(Status.INFO, column + " Reset Expected Data Count : " + resetCount);
				testCase.log(Status.INFO, column + " Reset Function Corretly Working");
				testCase.log(Status.PASS, "So, " + column + " Reset Function Pass");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, column + " Reset Actual Data Count : " + counts);
				testCase.log(Status.INFO, column + " Reset Expected Data Count : " + resetCount);
				testCase.log(Status.INFO, column + " Reset Function Wrongly Working");
				testCase.log(Status.FAIL, "So, " + column + " Reset Function Fail");
			} catch (Exception e) {
				testCase.log(Status.INFO, column + " Reset Actual Data Count : " + counts);
				testCase.log(Status.INFO, column + " Reset Expected Data Count : " + resetCount);
				testCase.log(Status.INFO, column + " Reset Function Wrongly Working");
				testCase.log(Status.FAIL, "So, " + column + " Reset Function Fail");
			}
		}

		try {
			driver.findElement(By.xpath("//div[@class='ant-transfer ant-transfer-customize-list']/div["+no+"]//li[@title='1']//a")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
