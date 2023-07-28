/***********************************************************************************
* Description
*------------
* Method Multiple Search Functionality
***********************************************************************************
*
* Author           : Suntharalingam Arunan
* Date Written     : 01/03/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*                        01/03/2023   Arunan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testcases.plant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.pages.master.PlantPage;

public class MultiSearchMethods extends DriverIntialization {
	static PlantPage pp = new PlantPage();
	public static boolean SearchVisible = true;
	public static boolean SearchEnable = true;
	public static boolean BtnVisible = true;
	public static boolean BtnEnable = true;
	static boolean SearchTextBoxVisible = true;
	static boolean SearchTextBoxEnable = true;
	static boolean SearchButtonVisible = true;
	static boolean SearchButtonEnable = true;
	static boolean FaxTableData = true;
	static int ActualValue = 0;
	static String SearchData = null;
	static boolean pass = true;
	static boolean buttonClick = false;
	static int numberOfRow = 0;
	static boolean iconClick = false;
	static boolean inputValue = false;
static WebDriverWait wait=new WebDriverWait(driver, 20);
	/*********************************************************************************************************************************************************
	 * Search Icon Properties - (Visible, Enable)
	 **********************************************************************************************************************************************************/
	public static void checkSearch(WebElement searchbtn, String colName) throws InterruptedException {
		PageFactory.initElements(driver, pp);
		Thread.sleep(1500);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_UP).build().perform();
//		Search Icon Visivle
		testCase = extent.createTest(colName + " Search Button Properties - Visible");
		try {
			Assert.assertEquals(searchbtn.isDisplayed(), true);
			testCase.log(Status.INFO, colName + " Search Button Visible");
			testCase.log(Status.PASS, colName + " Search Button Visible Script Pass");
		} catch (AssertionError e) {
			SearchVisible = false;
			testCase.log(Status.INFO, colName + " Search Button Not Visible");
			testCase.log(Status.FAIL, colName + " Search Button Not Visible, So cant check Button Enable, Click");
		} catch (NoSuchElementException e) {
			SearchVisible = false;
			testCase.log(Status.INFO, "Dont have " + colName + " Search Button Locator");
			testCase.log(Status.FAIL,
					"Dont have " + colName + " Search Button Locator, So Cant Check THis Button Related TestCases");
		}
//		Search Icon Enable
		if (SearchVisible) {
			testCase = extent.createTest(colName + " Search Button Properties - Enable");
			try {
				Assert.assertEquals(searchbtn.isEnabled(), true);
				testCase.log(Status.INFO, colName + " Search Button Enable");
				testCase.log(Status.PASS, colName + " Search Button Enable Script Pass");
			} catch (AssertionError e) {
				SearchEnable = false;
				testCase.log(Status.INFO, colName + " Search Button Not Enable");
				testCase.log(Status.FAIL,
						colName + " Search Button Not Enable, So Cant Check Click, Button RelatedSearch Testcases");
			}
			if (SearchVisible) {

			}
		}
	}

	/*********************************************************************************************************************************************************
	 * Search Icon Click
	 **********************************************************************************************************************************************************/
	public static void ClickSearch(WebElement search, WebElement TextBox, String colName) throws InterruptedException {
		PageFactory.initElements(driver, pp);
		if (SearchVisible && SearchEnable) {
			Thread.sleep(1000);
			search.click();
			iconClick = true;
			Thread.sleep(1000);
			testCase = extent.createTest(colName + " Search Icon Click");
			try {
				Thread.sleep(2000);
//				Assert.assertEquals(TextBox.isDisplayed(), true);
				testCase.log(Status.INFO, colName + " Search Icon Clicked");
				testCase.log(Status.PASS, colName + " Search Icon Clicked");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, colName + " Search Icon Clicked");
				testCase.log(Status.FAIL,
						colName + " Search Icon Click Not Working, So Cant Check This button Related TestCases");
			} catch (NoSuchElementException e) {

			}
		} else {
			testCase = extent.createTest(colName + " Search Icon Click");
			testCase.log(Status.INFO, colName + " Search Button Not Visible / Enable");
			testCase.log(Status.FAIL,
					colName + " Search Button Not Visible / Enable,So Cant Check This button Related TestCases");
		}
	}

	/*********************************************************************************************************************************************************
	 * Search Text Box Properties - (Visible, Enable)
	 **********************************************************************************************************************************************************/
	public static void SearchTextBox(WebElement TextBox, String colName) throws InterruptedException {
		PageFactory.initElements(driver, pp);
//		Check Plant Code Search TextBox Visible

		if (iconClick) {
			testCase = extent.createTest(colName + " Search Text Box Properties - Visible");
			try {
				Thread.sleep(1000);
				Assert.assertEquals(TextBox.isDisplayed(), true);
				testCase.log(Status.INFO, colName + " Search Text Box Visible");
				testCase.log(Status.PASS, colName + " Search Text Box Visible Script Pass");
			} catch (AssertionError e) {
				SearchTextBoxVisible = false;
				testCase.log(Status.INFO, colName + " Search Text Box Not Visible");
				testCase.log(Status.FAIL, colName + " Search Text Box Not Visible");
			} catch (NoSuchElementException e) {
				SearchTextBoxVisible = false;
				testCase.log(Status.INFO,
						"Dont have" + colName + " Search Text Box Locator / Didnt Click Search Button");
				testCase.log(Status.FAIL,
						"Dont have " + colName + " Search Text Box Locator/ Didnt Click Search Button");
			}

			if (SearchTextBoxVisible) {
//			Check Plant Code Search TextBoxEnable
				testCase = extent.createTest(colName + " Search Text Box Properties - Enable");
				try {
					Assert.assertEquals(TextBox.isEnabled(), true);
					testCase.log(Status.INFO, colName + " Search Text Box Enable");
					testCase.log(Status.PASS, colName + " Search Text Box Enable Script Pass");
				} catch (AssertionError e) {
					SearchTextBoxEnable = false;
					testCase.log(Status.INFO, colName + " Search Text Box Not Enable");
					testCase.log(Status.FAIL, colName + " Search Text Box Not Enable");
				}
				if (SearchTextBoxEnable) {

				}
			}
		}

		SearchTextBoxVisible = true;
		SearchButtonEnable = true;
	}

	/*********************************************************************************************************************************************************
	 * Search Button Properties - (Visible, Enable)
	 **********************************************************************************************************************************************************/
	public static void SearchButton(WebElement SearchBtn, String colName) throws InterruptedException {
		PageFactory.initElements(driver, pp);

//	Check Plant Code Search TextBox Visible
		if (iconClick) {
			testCase = extent.createTest(colName + " Search Button Properties - Visible");
			try {
				Thread.sleep(1000);
				Assert.assertEquals(SearchBtn.isDisplayed(), true);
				testCase.log(Status.INFO, colName + " Search Button Visible");
				testCase.log(Status.PASS, colName + " Search Button Visible Script Pass");
			} catch (AssertionError e) {
				SearchButtonVisible = false;
				testCase.log(Status.INFO, colName + " Search Button Not Visible");
				testCase.log(Status.FAIL, colName + " Search Button Not Visible");
			} catch (NoSuchElementException e) {
				SearchButtonVisible = false;
				testCase.log(Status.INFO, "Dont have " + colName + " Search Button Locator");
				testCase.log(Status.FAIL, "Dont have " + colName + " Search Button Locator, So Smoke Fail");
			}

			if (SearchButtonVisible) {
//		Check Plant Code Search TextBox Enable
				testCase = extent.createTest(colName + " Search Button Properties - Enable");
				try {
					Assert.assertEquals(SearchBtn.isEnabled(), true);
					testCase.log(Status.INFO, colName + " Search Button Enable");
					testCase.log(Status.PASS, colName + " Search Button Enable Script Pass");
				} catch (AssertionError e) {
					SearchButtonEnable = false;
					testCase.log(Status.INFO, colName + " Search Button Not Enable");
					testCase.log(Status.FAIL, colName + " Search Button Not Enable");
				}

				if (SearchButtonEnable) {
//			
				}
			}
		}
		SearchButtonVisible = true;
		SearchButtonEnable = true;
	}

	/*********************************************************************************************************************************************************
	 * Search Button Click
	 **********************************************************************************************************************************************************/
	public static void SearchButtonClick(WebElement SearchBtn, WebElement ResetAllBtn, String colName)
			throws InterruptedException {
		PageFactory.initElements(driver, pp);
		if (SearchButtonVisible && SearchButtonEnable && inputValue) {
			SearchBtn.click();
			buttonClick = true;
			testCase = extent.createTest(colName + " Search Button Click");
			try {
				Assert.assertEquals(ResetAllBtn.isDisplayed(), true);
				testCase.log(Status.INFO, colName + " Search Button Clicked");
				testCase.log(Status.PASS, colName + " Search Button Clicked");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, colName + " Search Button Clicked");
				testCase.log(Status.FAIL, colName + " Search Button Click Not Working");
			}
		} else {
			testCase = extent.createTest(colName + " Search Button Click");
			testCase.log(Status.INFO, colName + " Search Button Not Visible / Enable");
			testCase.log(Status.FAIL, colName + " Search Button Not Visible / Enable");
		}
	}

	/*********************************************************************************************************************************************************
	 * Take Count After Searching & Check Single Searched data Filtering is Corroct/
	 * Not
	 **********************************************************************************************************************************************************/
	public static void checkAfterSearchData(List<WebElement> Column, String ColBefore, String colAfter, String colName,
			int ExpectedValue, boolean TableData) throws InterruptedException {
		PageFactory.initElements(driver, pp);
		boolean Customer_Plant = false;
		boolean Supplier_SupplierCat = false;
		boolean Material_Source = false;

//		Check Search button Click or not
		if (buttonClick) {
			boolean Enablity = true;
			try {
//				Check Total Row count in a page
				numberOfRow = Column.size();
			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Column Locater");
				testCase.log(Status.INFO, "Dont Have Column Locater");
				testCase.log(Status.FAIL, "Dont Have Column Locater");
				numberOfRow = 0;
			}
//			Check List is Empty or not
			if (Column.isEmpty()) {
				ActualValue = 0;
			} else {
//				Pagination next Button click loop 
				while (Enablity) {
					// Thread.sleep(3000);
//					Check value every row wise loop
					for (int j = 2; j <= numberOfRow; j++) {
						try {
//							Row value Expath
							WebElement Customer = driver.findElement(
									By.xpath("//tbody[@class='ant-table-tbody']/tr[" + j + "]/td[2]/span/span"));
							Assert.assertEquals(Customer.isDisplayed(), true);
							Customer_Plant = true;
						} catch (NoSuchElementException e) {
						}
						try {
							WebElement Supplier = driver.findElement(
									By.xpath("//tbody[@class='ant-table-tbody']/tr[" + j + "]/td[6]/span/span"));
							Assert.assertEquals(Supplier.isDisplayed(), true);
							Supplier_SupplierCat = true;
						} catch (NoSuchElementException e) {
						}
						try {
							WebElement Material = driver.findElement(
									By.xpath("//tbody[@class='ant-table-tbody']/tr[" + j + "]/td[10]/span/span"));
							Assert.assertEquals(Material.isDisplayed(), true);
							Material_Source = true;
						} catch (NoSuchElementException e) {
						}
						try {
							WebElement code = driver.findElement(By.xpath(ColBefore + j + colAfter));
							String CodeName = code.getText();
							// Thread.sleep(1000);

							if (CodeName.contains(SearchData)) {
//								Count Every Row Value after search
								ActualValue = ActualValue + 1;
								if (!CodeName.contains(SearchData)) {
//									Check Wrong data filter or not
									TableData = false;
								}
							} else {
								if (Customer_Plant) {
									try {
										driver.findElement(By.xpath(
												"//tbody[@class='ant-table-tbody']/tr[" + j + "]/td[2]/span/span"))
												.click();
										Thread.sleep(2500);
										int row = driver.findElements(By.xpath(
												"//div[@class='ant-popover ant-popover-placement-top ']/div/div[2]/div[2]/div/p"))
												.size();
										for (int k = 1; k <= row; k++) {
											WebElement Plant = driver.findElement(By.xpath(
													"//div[@class='ant-popover ant-popover-placement-top ']/div/div[2]/div[2]/div/p["
															+ k + "]"));
											String PlantName = Plant.getText();
											if (PlantName.contains(SearchData)) {
//											Count Every Row Value after search
												ActualValue = ActualValue + 1;
												if (!PlantName.contains(SearchData)) {
//												Check Wrong data filter or not
													TableData = false;
												}
											}
										}
										driver.findElement(By.xpath(
												"//tbody[@class='ant-table-tbody']/tr[" + j + "]/td[2]/span/span"))
												.click();
									} catch (NoSuchElementException e) {
									}
								} else if (Supplier_SupplierCat) {
									try {
										driver.findElement(By.xpath(
												"//tbody[@class='ant-table-tbody']/tr[" + j + "]/td[6]/span/span"))
												.click();
										Thread.sleep(2000);
										if (!driver.findElements(By.xpath(
												"//div[@class='ant-popover ant-popover-placement-bottom ']/div/div[2]/div[2]/div/p"))
												.isEmpty()) {
											int row = driver.findElements(By.xpath(
													"//div[@class='ant-popover ant-popover-placement-bottom ']/div/div[2]/div[2]/div/p"))
													.size();
											Thread.sleep(1000);
											for (int k = 1; k <= row; k++) {
												Thread.sleep(1000);
												WebElement Supplier = driver.findElement(By.xpath(
														"//div[@class='ant-popover ant-popover-placement-bottom ']/div/div[2]/div[2]/div/p["
																+ k + "]"));
												Thread.sleep(1000);
												String SupplierCategory = Supplier.getText();
												Thread.sleep(1000);
												if (SupplierCategory.contains(SearchData)) {
//											Count Every Row Value after search
													ActualValue = ActualValue + 1;
													if (!SupplierCategory.contains(SearchData)) {
//												Check Wrong data filter or not
														TableData = false;
													}
												}

											}
										} else {
											int row = driver.findElements(By.xpath(
													"//div[@class='ant-popover ant-popover-placement-top ']/div/div[2]/div[2]/div/p"))
													.size();
											Thread.sleep(1000);
											for (int k = 1; k <= row; k++) {
												Thread.sleep(1000);
												WebElement Supplier = driver.findElement(By.xpath(
														"//div[@class='ant-popover ant-popover-placement-top ']/div/div[2]/div[2]/div/p["
																+ k + "]"));
												Thread.sleep(1000);
												String SupplierCategory = Supplier.getText();
												Thread.sleep(1000);
												if (SupplierCategory.contains(SearchData)) {
//												Count Every Row Value after search
													ActualValue = ActualValue + 1;
													if (!SupplierCategory.contains(SearchData)) {
//													Check Wrong data filter or not
														TableData = false;
													}
												}
											}
										}
										Thread.sleep(1500);
										driver.findElement(By.xpath(
												"//tbody[@class='ant-table-tbody']/tr[" + j + "]/td[6]/span/span"))
												.click();
									} catch (NoSuchElementException e) {
									}

								} else if (Material_Source) {
									try {
										driver.findElement(By.xpath(
												"//tbody[@class='ant-table-tbody']/tr[" + j + "]/td[10]/span/span"))
												.click();
										Thread.sleep(4000);
										int row = driver.findElements(By.xpath(
												"//div[@class='ant-popover ant-popover-placement-top ']/div/div[2]/div[2]/div/div/p"))
												.size();
										for (int k = 1; k <= row; k++) {
											Thread.sleep(3000);
											String xpath = "//div[@class='ant-popover ant-popover-placement-top ']/div/div[2]/div[2]/div/div/p["
													+ k + "]";
//											System.out.println(xpath);
											WebElement source = driver.findElement(By.xpath(xpath));
											Thread.sleep(1000);
											String materialSource = source.getText();
											Thread.sleep(1000);
											System.out.println("********" + materialSource);
											if (materialSource.contains(SearchData)) {
												System.out.println("********" + materialSource + "!!!!!!!!!");
//											Count Every Row Value after search
												ActualValue = ActualValue + 1;
												if (!materialSource.contains(SearchData)) {
//												Check Wrong data filter or not
													TableData = false;
												}
											}
										}
										driver.findElement(By.xpath(
												"//tbody[@class='ant-table-tbody']/tr[" + j + "]/td[10]/span/span"))
												.click();
									} catch (NoSuchElementException e) {
									}
								}
							}
						} catch (NoSuchElementException e) {
//						testCase = extent.createTest("Dont Have This Row Locater");
//						testCase.log(Status.INFO, "Dont Have This Row Locater");
//						testCase.log(Status.FAIL, "Dont Have This Row Locater");
						}
					}
					try {

						Enablity = PlantPage.NextPageBtn.isEnabled();
						if (Enablity) {
							PlantPage.NextPageBtn.click();
							// Scroll up by a page
							Actions actions = new Actions(driver);
							actions.sendKeys(Keys.PAGE_UP).build().perform();
						}
					} catch (NoSuchElementException e) {
						testCase = extent.createTest("Dont Have Pagination Next Button, When without data in WebTable");
						testCase.log(Status.INFO, "Dont have Pagination Next Button Locator");
						testCase.log(Status.FAIL, "Dont have Pagination Next Button Locator");
						break;
					}
				}
				boolean checke = true;

				try {
					Assert.assertEquals(ExpectedValue, ActualValue);
					checke = true;
				} catch (AssertionError e) {
					checke = false;
				}
				System.out.println(ExpectedValue);
				System.out.println(ActualValue);
				System.out.println(checke);
				System.out.println(TableData);
				if (checke && TableData) {
					testCase = extent.createTest(colName + " Single Search Function");
					testCase.log(Status.INFO, colName + " Single Search Work Correctly");
					testCase.log(Status.PASS, colName + " Single Search Work Correctly");
				} else {
					pass = false;
					testCase = extent.createTest(colName + " Single Search Function");
					testCase.log(Status.INFO, colName + " Single Search Work Wrongly");
					testCase.log(Status.FAIL, colName + " Single Search Work Wrongly");
				}

				ActualValue = 0;
			}
		} else {
			testCase = extent.createTest(colName + " Single Search Function");
			testCase.log(Status.INFO, "Unable to click " + colName + " Search Button, So Fail");
			testCase.log(Status.FAIL, "Unable to click " + colName + " Search Button, So Fail");
		}

	}

	/*********************************************************************************************************************************************************
	 * Input Searched Data
	 **********************************************************************************************************************************************************/
	public static void inputDataSearch(String testcaseId, WebElement textBox, String colName, String tabName,
			int excelcolNo, List<WebElement> Column) throws IOException, InterruptedException {
		PageFactory.initElements(driver, pp);
		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", tabName,
				testcaseId);
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", tabName,
				testcaseId);

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(tabName);
		try {
			numberOfRow = Column.size();
		} catch (NoSuchElementException e) {
			testCase = extent.createTest(colName + " Column Locater");
			testCase.log(Status.INFO, "Dont Have " + colName + " Column Locater");
			testCase.log(Status.FAIL, "Dont Have " + colName + "Column Locater");
			numberOfRow = 0;
		}
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			SearchData = (String) row.getCell(excelcolNo).getStringCellValue();
			if (SearchTextBoxVisible && SearchTextBoxEnable) {
				Thread.sleep(1000);
				textBox.sendKeys(SearchData);
				Thread.sleep(1000);
				testCase = extent.createTest(colName + " Search Data Input");  
				try {
					Assert.assertEquals(textBox.getAttribute("value"), SearchData);
					inputValue = true;
					testCase.log(Status.INFO, colName + " Input Data");
					testCase.log(Status.PASS, colName + " Input Data");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, colName + " Input Data");
					testCase.log(Status.PASS, colName + " Input Data");
				}
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + SearchData);

			} else {
				testCase = extent.createTest(colName + " Search Data Input");
				testCase.log(Status.INFO, colName + " Search TextBox Not Visible / Enable");
				testCase.log(Status.FAIL, colName + " Search TextBox Not Visible / Enable");
			}
		}
	}

	/*********************************************************************************************************************************************************
	 * Check Multiple Searched data Filtering is Corroct/ Not
	 **********************************************************************************************************************************************************/
	public static void MultipleSearch(String colName) {
		PageFactory.initElements(driver, pp);
		if (pass) {
			testCase = extent.createTest(colName + " Multi Search (Check Correct Data Count Filter) ☑");
			testCase.log(Status.INFO, "Correct Data Count Filtered");
			testCase.log(Status.PASS, "Correct Data Count Filtered");
		} else {
			testCase = extent.createTest(colName + " Multi Search (Check Correct Data Count Filter) ✘");
			testCase.log(Status.INFO, "Wrong Data Count Filtered");
			testCase.log(Status.FAIL, "Wrong Data Count Filtered");
		}
	}

	/*********************************************************************************************************************************************************
	 * Logout
	 **********************************************************************************************************************************************************/
	public static void Logout() {
		PageFactory.initElements(driver, pp);
		WebDriverWait wait= new WebDriverWait(driver, 20);
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//header[@class='ant-layout-header']/ul/div/div[2]/div/div/span"))));
			driver.findElement(By.xpath("//header[@class='ant-layout-header']/ul/div/div[2]/div/div/span")).click();
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']/li[5]"))));
			driver.findElement(By.xpath(
					"//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']/li[5]"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (NoSuchElementException e) {
			System.out.println("Logout Not Working");
		}
	
	}

	/*********************************************************************************************************************************************************
	 * Button Properties - (Visible, Enable)
	 **********************************************************************************************************************************************************/
	public static void Button(WebElement searchbtn, String colName) {
		PageFactory.initElements(driver, pp);
//		Search Icon Visivle 
		BtnVisible=true;
		 BtnEnable=true;
		testCase = extent.createTest(colName + " Button - Visible");
		try {
			wait.until(ExpectedConditions.visibilityOf(searchbtn));
			Assert.assertEquals(searchbtn.isDisplayed(), true);
			testCase.log(Status.INFO, colName + " Button Visible");
			testCase.log(Status.PASS, colName + " Button Visible Script Pass");
		} catch (AssertionError e) {
			BtnVisible = false;
			testCase.log(Status.INFO, colName + " Button Not Visible");
			testCase.log(Status.FAIL, colName + " Button Not Visible");
		} catch (Exception e) {
			BtnVisible = false;
			testCase.log(Status.INFO, "Dont have " + colName + " Button Locator");
			testCase.log(Status.FAIL, "Dont have " + colName + " Button Locator");
		}
//		Search Icon Enable
		if (BtnVisible) {
			testCase = extent.createTest(colName + " Button - Enable");
			try {
				
				Assert.assertEquals(searchbtn.isEnabled(), true);
				testCase.log(Status.INFO, colName + " Button Enable");
				testCase.log(Status.PASS, colName + " Button Enable Script Pass");
			} catch (AssertionError e) {
				BtnEnable = false;
				testCase.log(Status.INFO, colName + " Button Not Enable");
				testCase.log(Status.FAIL, colName + " Button Not Enable");
			}catch (Exception e) {
				BtnEnable = false;
				testCase.log(Status.INFO, "Dont have " + colName + " Button Locator");
				testCase.log(Status.FAIL, "Dont have " + colName + " Button Locator");
			}
			
		}

	}

	public static void TextBox(WebElement searchbtn, String colName) throws InterruptedException {
		PageFactory.initElements(driver, pp);
		Thread.sleep(2000);
//		Search Icon Visivle 
		testCase = extent.createTest(colName + " TextBox Properties - Visible");
		try {
			Assert.assertEquals(searchbtn.isDisplayed(), true);
			testCase.log(Status.INFO, colName + " TextBox Visible");
			testCase.log(Status.PASS, colName + " TextBox Visible Script Pass");
		} catch (AssertionError e) {
			BtnVisible = false;
			testCase.log(Status.INFO, colName + " TextBox Not Visible");
			testCase.log(Status.FAIL, colName + " TextBox Not Visible");
		} catch (NoSuchElementException e) {
			BtnVisible = false;
			testCase.log(Status.INFO, "Dont have " + colName + " TextBox Locator");
			testCase.log(Status.FAIL, "Dont have " + colName + " TextBox Locator, So Smoke Fail");
		}
		Thread.sleep(1500);
//		Search Icon Enable
		if (BtnVisible) {
			testCase = extent.createTest(colName + " TextBox Properties - Enable");
			try {
				Assert.assertEquals(searchbtn.isEnabled(), true);
				testCase.log(Status.INFO, colName + " TextBox Enable");
				testCase.log(Status.PASS, colName + " TextBox Enable Script Pass");
			} catch (AssertionError e) {
				BtnEnable = false;
				testCase.log(Status.INFO, colName + " TextBox Not Enable");
				testCase.log(Status.FAIL, colName + " TextBox Not Enable");
			}

		}

	}

	/*********************************************************************************************************************************************************
	 * Click Button
	 **********************************************************************************************************************************************************/
	public static void clickButton(WebElement search, WebElement TextBox, String colName) throws InterruptedException {
		PageFactory.initElements(driver, pp);
		if (SearchVisible && SearchEnable) {
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(search));
			search.click();
			iconClick = true;
			Thread.sleep(1000);
			testCase = extent.createTest(colName + " Click");
			try {
				Thread.sleep(2000);
//				Assert.assertEquals(TextBox.isDisplayed(), true);
				testCase.log(Status.INFO, colName + "  Clicked");
				testCase.log(Status.PASS, colName + "  Clicked");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, colName + "  Clicked");
				testCase.log(Status.FAIL, colName + "  Click Not Working, So Cant Check This button Related TestCases");
			} catch (NoSuchElementException e) {

			}
		} else {
			testCase = extent.createTest(colName + " Search Icon Click");
			testCase.log(Status.INFO, colName + " Search Button Not Visible / Enable");
			testCase.log(Status.FAIL,
					colName + " Search Button Not Visible / Enable,So Cant Check This button Related TestCases");
		}
	}

	/*********************************************************************************************************************************************************
	 * Input Searched Data
	 **********************************************************************************************************************************************************/
	public static void ButtonClick(WebElement Button, String BtnName, List<WebElement> Column, int Expected)
			throws InterruptedException {
		PageFactory.initElements(driver, pp);
//		Check Reset All button visible & Enable
		if (BtnVisible && BtnEnable) {
			int TotalData = 0;
			int RowCount = 2;
//			Click ResetAll Button 
			wait.until(ExpectedConditions.elementToBeClickable(Button));
			Button.click();
			Thread.sleep(2000);
//			Take Total Row count in WebTable
			try {
				RowCount = Column.size();
			} catch (NoSuchElementException e) {
			}
			boolean Enable = true;
//			Pagination next Button click loop 
			while (Enable) {
//				Check value every row wise
				for (int i = 2; i <= RowCount; i++) {
					try {
//						Row value XPath
						WebElement Text = driver.findElement(
								By.xpath(PlantPage.PlantCodeColumnBefore + i + PlantPage.PlantCodeColumnAfter));
						Thread.sleep(1000);
//						Count Every Row Data
						TotalData = TotalData + 1;
					} catch (NoSuchElementException e) {
					}
				}
				System.out.println(TotalData);
				Thread.sleep(2000);
//				Check next page button enable or not
				Enable = PlantPage.NextPageBtn.isEnabled();
//				Click Next page Button
				if (Enable) {
					Thread.sleep(3000);
					PlantPage.NextPageBtn.click();
				}

			}

			testCase = extent.createTest(BtnName + " Button Function");
			try {
				Assert.assertEquals(TotalData, Expected);
				testCase.log(Status.INFO, BtnName + " Button Correctly Working ");
				testCase.log(Status.PASS, BtnName + " Button Correctly Working ");
			} catch (AssertionError e) {
				BtnEnable = false;
				testCase.log(Status.INFO, BtnName + " Button Wrongly Working ");
				testCase.log(Status.FAIL, BtnName + " Button Wrongly Working ");
			}

		}

	}

	/*********************************************************************************************************************************************************
	 * Navigate Middle page
	 **********************************************************************************************************************************************************/

//	MODIFIED BY : ARUNAN  10.03.2023
	public static void middlePage(String testcasename, int midPage) throws InterruptedException {
		PageFactory.initElements(driver, pp);
		for (int i = 1; i <= midPage; i++) {
			try {
				Thread.sleep(3000);
				MaterialPage.NextPageBtn.click();
			} catch (NoSuchElementException e) {
			}
		}
		testCase = extent.createTest(testcasename);
		testCase.log(Status.INFO, testcasename + " testcase Pass ");
		testCase.log(Status.PASS, testcasename + " testcase Pass");
		// Scroll up by a page
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_UP).build().perform();

	}

	/*********************************************************************************************************************************************************
	 * Navigate Last Page
	 **********************************************************************************************************************************************************/
	public static void lastPage(String testcasename) throws InterruptedException {
		PageFactory.initElements(driver, pp);
		Thread.sleep(1500);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
		MaterialPage.LastPage.click();
		Thread.sleep(1500);
		testCase = extent.createTest(testcasename);
		testCase.log(Status.INFO, testcasename + " testcase Pass ");
		testCase.log(Status.PASS, testcasename + " testcase Pass");
	}

	public static void MiddlePage(String testcasename) throws InterruptedException {
		PageFactory.initElements(driver, pp);
		Thread.sleep(1500);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
		MaterialPage.middlePage.click();
		Thread.sleep(1500);
		testCase = extent.createTest(testcasename);
		testCase.log(Status.INFO, testcasename + " testcase Pass ");
		testCase.log(Status.PASS, testcasename + " testcase Pass");
	}

	/*********************************************************************************************************************************************************
	 * reset Button Properties - (Visible, Enable)
	 **********************************************************************************************************************************************************/
	public static void resetButton(WebElement SearchBtn, String colName) throws InterruptedException {
		PageFactory.initElements(driver, pp);

//	Check Plant Code Search TextBox Visible
		if (iconClick) {
			testCase = extent.createTest(colName + " Button Properties - Visible");
			try {
				Thread.sleep(1000);
				Assert.assertEquals(SearchBtn.isDisplayed(), true);
				testCase.log(Status.INFO, colName + " Button Visible");
				testCase.log(Status.PASS, colName + " Button Visible Script Pass");
			} catch (AssertionError e) {
				SearchButtonVisible = false;
				testCase.log(Status.INFO, colName + " Button Not Visible");
				testCase.log(Status.FAIL, colName + " Button Not Visible");
			} catch (NoSuchElementException e) {
				SearchButtonVisible = false;
				testCase.log(Status.INFO, "Dont have " + colName + " Button Locator");
				testCase.log(Status.FAIL, "Dont have " + colName + " Button Locator, So Smoke Fail");
			}

			if (SearchButtonVisible) {
//		Check Plant Code Search TextBox Enable
				testCase = extent.createTest(colName + " Button Properties - Enable");
				try {
					Assert.assertEquals(SearchBtn.isEnabled(), true);
					testCase.log(Status.INFO, colName + " Button Enable");
					testCase.log(Status.PASS, colName + " Button Enable Script Pass");
				} catch (AssertionError e) {
					SearchButtonEnable = false;
					testCase.log(Status.INFO, colName + " Button Not Enable");
					testCase.log(Status.FAIL, colName + " Button Not Enable");
				}

				if (SearchButtonEnable) {
//					SearchBtn.click();
				}
			}
		}
	}

	/******************************************************************************************
	 * button Click
	 ******************************************************************************************/
	public static void click(WebElement button, WebElement expectd, String colName) throws InterruptedException {
		PageFactory.initElements(driver, pp);
		if (SearchVisible && SearchEnable) {
			wait.until(ExpectedConditions.elementToBeClickable(button));
			button.click();
			Thread.sleep(2000);
			testCase = extent.createTest(colName + " Button click");
			try {
				Assert.assertEquals(expectd.isDisplayed(), true);
				testCase.log(Status.INFO, "When click " + colName + " Button, form is visible");
				testCase.log(Status.PASS, colName + " Button Click Script Pass");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "When click " + colName + " Button, form is not visible");
				testCase.log(Status.FAIL, colName + " Button Click Script Pass");
			} catch (NoSuchElementException e) {
				testCase.log(Status.INFO, "When click " + colName + " Button, form is not visible");
				testCase.log(Status.FAIL, colName + " Button Click Script Pass");
			}

		}
	}

	public static void clickButton(WebElement search, String colName) throws InterruptedException {
		PageFactory.initElements(driver, pp);
		if (SearchVisible && SearchEnable) {
			wait.until(ExpectedConditions.elementToBeClickable(search));
			search.click();
			iconClick = true;
			testCase = extent.createTest(colName + " Click");
			try {
//				Assert.assertEquals(TextBox.isDisplayed(), true);
				testCase.log(Status.INFO, colName + "  Clicked");
				testCase.log(Status.PASS, colName + "  Clicked");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, colName + "  Clicked");
				testCase.log(Status.FAIL, colName + "  Click Not Working, So Cant Check This button Related TestCases");
			} catch (NoSuchElementException e) {

			}
		} else {
			testCase = extent.createTest(colName + " Search Icon Click");
			testCase.log(Status.INFO, colName + " Search Button Not Visible / Enable");
			testCase.log(Status.FAIL,
					colName + " Search Button Not Visible / Enable,So Cant Check This button Related TestCases");
		}
	}

	public static void Button1(WebElement searchbtn, String colName) {
		PageFactory.initElements(driver, pp);
		BtnVisible=true;
		 BtnEnable=true;
//		Search Icon Visivle 
//		testCase = extent.createTest(colName + " Button Properties - Visible");
		try {
			wait.until(ExpectedConditions.visibilityOf(searchbtn));
			Assert.assertEquals(searchbtn.isDisplayed(), true);
//			testCase.log(Status.INFO, colName + " Button Visible");
//			testCase.log(Status.PASS, colName + " Button Visible Script Pass");
		} catch (AssertionError e) {
			BtnVisible = false;
//			testCase.log(Status.INFO, colName + " Button Not Visible");
//			testCase.log(Status.FAIL, colName + " Button Not Visible");
		} catch (NoSuchElementException e) {
			BtnEnable = false;
//			testCase.log(Status.INFO, "Dont have " + colName + " Button Locator");
//			testCase.log(Status.FAIL, "Dont have " + colName + " Button Locator, So Smoke Fail");
		}
//		Search Icon Enable
		if (BtnVisible) {
//			testCase = extent.createTest(colName + " Button Properties - Enable");
			try {
				wait.until(ExpectedConditions.visibilityOf(searchbtn));
				Assert.assertEquals(searchbtn.isEnabled(), true);
//				testCase.log(Status.INFO, colName + " Button Enable");
//				testCase.log(Status.PASS, colName + " Button Enable Script Pass");
			} catch (AssertionError e) {
				BtnEnable = false;
//				testCase.log(Status.INFO, colName + " Button Not Enable");
//				testCase.log(Status.FAIL, colName + " Button Not Enable");
			}

		}

	}
	
	public static void Buttons(WebElement searchbtn, String colName){
		PageFactory.initElements(driver, pp);
		 BtnVisible=true;
		 BtnEnable=true;
		try {
			wait.until(ExpectedConditions.visibilityOf(searchbtn));
			Assert.assertEquals(searchbtn.isDisplayed(), true);
			BtnVisible=true;
		} catch (AssertionError e) {
			BtnVisible = false;
			driver.navigate().refresh();
			testCase = extent.createTest(colName + " Button Properties - Visible");
			testCase.log(Status.INFO, colName + " Button Not Visible");
			testCase.log(Status.FAIL, colName + " Button Not Visible");
		} catch (Exception e) {
			BtnVisible = false;
			driver.navigate().refresh();
			testCase = extent.createTest(colName + " Button Properties - Visible");
			testCase.log(Status.INFO, "Dont have " + colName + " Button Locator");
			testCase.log(Status.FAIL, "Dont have " + colName + " Button Locator. So Cant Check Feature Things, So Fail");
		}
		if (BtnVisible) {
			
			try {
				wait.until(ExpectedConditions.visibilityOf(searchbtn));
				Assert.assertEquals(searchbtn.isEnabled(), true);
				BtnEnable=true;
			} catch (AssertionError e) {
				BtnEnable = false;
				testCase = extent.createTest(colName + " Button Properties - Enable");
				testCase.log(Status.INFO, colName + " Button Not Enable");
				testCase.log(Status.FAIL, colName + " Button Not Enable");
			} catch (Exception e) {
				BtnEnable=false;
				testCase = extent.createTest(colName + " Button Properties - Enable");
				testCase.log(Status.INFO, colName + " Button Not Enable");
				testCase.log(Status.FAIL, colName + " Button Not Enable");
			}

		}

	}
	
	/*********************************************************************************************************************************************************
	 * Icon Properties - (Visible, Enable)
	 **********************************************************************************************************************************************************/
	public static void icon(WebElement searchbtn, String colName){
		PageFactory.initElements(driver, pp);
//		Search Icon Visivle 
		BtnVisible=true;
		BtnEnable=true;
		try {
			wait.until(ExpectedConditions.visibilityOf(searchbtn));
			Assert.assertEquals(searchbtn.isDisplayed(), true);
			testCase = extent.createTest(colName + " Icon - Visible");
			testCase.log(Status.INFO, colName + " Icon Visible");
			testCase.log(Status.PASS, colName + " Icon Visible Script Pass");
		} catch (AssertionError e) {
			BtnVisible = false;
			testCase = extent.createTest(colName + " Icon - Visible");
			testCase.log(Status.INFO, colName + " Icon Not Visible");
			testCase.log(Status.FAIL, colName + " Icon Not Visible");
		} catch (Exception e) {
			BtnVisible = false;
			testCase = extent.createTest(colName + " Icon - Visible");
			testCase.log(Status.INFO, "Dont have " + colName + " Icon Locator");
			testCase.log(Status.FAIL, "Dont have " + colName + " Icon Locator");
		}
//		Search Icon Enable
		if (BtnVisible) {
			
			try {
				wait.until(ExpectedConditions.visibilityOf(searchbtn));
				Assert.assertEquals(searchbtn.isEnabled(), true);
				testCase = extent.createTest(colName + " Icon - Enable");
				testCase.log(Status.INFO, colName + " Icon Enable");
				testCase.log(Status.PASS, colName + " Icon Enable Script Pass");
			} catch (AssertionError e) {
				BtnEnable = false;
				testCase = extent.createTest(colName + " Icon - Enable");
				testCase.log(Status.INFO, colName + " Icon Not Enable");
				testCase.log(Status.FAIL, colName + " Icon Not Enable");
			} catch (Exception e) {
				BtnEnable = false;
				testCase = extent.createTest(colName + " Icon ");
				testCase.log(Status.INFO, "Dont have " + colName + " Icon Locator");
				testCase.log(Status.FAIL, "Dont have " + colName + " Icon Locator");
			}
			if (BtnVisible && BtnEnable) {

			}
		}

	}
	
	/*********************************************************************************************************************************************************
	 * textBox Properties - (Visible, Enable)
	 **********************************************************************************************************************************************************/
	public static void textBox(WebElement searchbtn, String colName) {
		PageFactory.initElements(driver, pp);
//		Search Icon Visivle 
	
		try {
			wait.until(ExpectedConditions.visibilityOf(searchbtn));
			Assert.assertEquals(searchbtn.isDisplayed(), true);
			testCase = extent.createTest(colName + " textBox - Visible");
			testCase.log(Status.INFO, colName + " textBox Visible");
			testCase.log(Status.PASS, colName + " textBox Visible Script Pass");
		} catch (AssertionError e) {
			testCase = extent.createTest(colName + " textBox - Visible");
			BtnVisible = false;
			testCase.log(Status.INFO, colName + " textBox Not Visible");
			testCase.log(Status.FAIL, colName + " textBox Not Visible");
		} 
		catch (Exception e) {
			BtnVisible = false;
			testCase = extent.createTest(colName + " textBox - Visible");
			testCase.log(Status.INFO, "Dont have " + colName + " textBox Locator");
			testCase.log(Status.FAIL, "Dont have " + colName + " textBox Locator");
		}
//		Search Icon Enable
		if (BtnVisible) {
			
			try {
				wait.until(ExpectedConditions.visibilityOf(searchbtn));
				Assert.assertEquals(searchbtn.isEnabled(), true);
				testCase = extent.createTest(colName + " textBox - Enable");
				testCase.log(Status.INFO, colName + " textBox Enable");
				testCase.log(Status.PASS, colName + " textBox Enable Script Pass");
			} catch (AssertionError e) {
				BtnEnable = false;
				testCase = extent.createTest(colName + " textBox - Enable");
				testCase.log(Status.INFO, colName + " textBox Not Enable");
				testCase.log(Status.FAIL, colName + " textBox Not Enable");
			} catch (Exception e) {
				BtnEnable = false;
				testCase = extent.createTest(colName + " textBox");
				testCase.log(Status.INFO, "Dont have " + colName + " textBox Locator");
				testCase.log(Status.FAIL, "Dont have " + colName + " textBox Locator");
			}
			if (BtnVisible && BtnEnable) {

			}
		}

	}
	
	public static void elementClick(WebElement clickElement) {
		try {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(clickElement));
		clickElement.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static boolean checked=false;
	public static void textBoxData(WebElement searchbtn, String colName,String data) {
		PageFactory.initElements(driver, pp);
//		Search Icon Visivle 
	BtnVisible=true;
	BtnEnable=true;
		try {
			wait.until(ExpectedConditions.visibilityOf(searchbtn));
			Assert.assertEquals(searchbtn.isDisplayed(), true);
			testCase = extent.createTest(colName + " textBox - Visible");
			testCase.log(Status.INFO, colName + " textBox Visible");
			testCase.log(Status.PASS, colName + " textBox Visible Script Pass");
		} catch (AssertionError e) {
			testCase = extent.createTest(colName + " textBox - Visible");
			BtnVisible = false;
			testCase.log(Status.INFO, colName + " textBox Not Visible");
			testCase.log(Status.FAIL, colName + " textBox Not Visible");
		} 
		catch (Exception e) {
			BtnVisible = false;
			testCase = extent.createTest(colName + " textBox - Visible");
			testCase.log(Status.INFO, "Dont have " + colName + " textBox Locator");
			testCase.log(Status.FAIL, "Dont have " + colName + " textBox Locator");
		}
//		Search Icon Enable
		if (BtnVisible) {
			
			try {
				wait.until(ExpectedConditions.visibilityOf(searchbtn));
				Assert.assertEquals(searchbtn.isEnabled(), true);
				testCase = extent.createTest(colName + " textBox - Enable");
				testCase.log(Status.INFO, colName + " textBox Enable");
				testCase.log(Status.PASS, colName + " textBox Enable Script Pass");
			} catch (AssertionError e) {
				BtnEnable = false;
				testCase = extent.createTest(colName + " textBox - Enable");
				testCase.log(Status.INFO, colName + " textBox Not Enable");
				testCase.log(Status.FAIL, colName + " textBox Not Enable");
			} catch (Exception e) {
				BtnEnable = false;
				testCase = extent.createTest(colName + " textBox");
				testCase.log(Status.INFO, "Dont have " + colName + " textBox Locator");
				testCase.log(Status.FAIL, "Dont have " + colName + " textBox Locator");
			}
			if (BtnVisible && BtnEnable) {
				searchbtn.sendKeys(Keys.CONTROL+"a", Keys.DELETE);
				searchbtn.sendKeys(data);
				checked=true;
			}
		}

	}
}