/* ADD Supplier Category
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 10/03/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*  TC-SUPCAT-0024        10/03/2023   RAHUL.S    OrIginal Version
*   TC-SUPCAT-0018 
*   TC-SUPCAT-0002       11/04/2023   RAHUL.S    MOdified version
************************************************************************************/
package com.qa.automation.qdms.testcases.suppliercategory;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.SupplierCategoryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class AddSupplierCategory extends DriverIntialization {

	static DataFormatter dataValue = new DataFormatter();
	static SupplierCategoryPage supplierCategory = new SupplierCategoryPage();
	static boolean checkValues = false;
	public static boolean clickAddButton = false;

//RAHUL.S(2023/07/17)
	public static void clickAddSupplierCategoryBtn(String TestCase) {
		clickAddButton = false;
		PageFactory.initElements(driver, supplierCategory);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		MultiSearchMethods.Button(SupplierCategoryPage.addSuppilerCategotyButton, "ADD SUPPLIERCATEGORY");
		if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(SupplierCategoryPage.addSuppilerCategotyButton));
				SupplierCategoryPage.addSuppilerCategotyButton.click();
				clickAddButton = true;
			} catch (Exception e) {
				testCase = extent.createTest("Add SUPPLIER CATEGORY Button Click");
				testCase.log(Status.INFO, "Add SUPPLIER CATEGORY BUTTON Clicked Fail");
				testCase.log(Status.FAIL, "SUPPLIER CATEGORY Save Button not Visible, Button Clicked Fail");
			}
		}

		if (clickAddButton) {
//			testCase = extent.createTest("Add SUPPLIER Button Functionality");
//			try {
//				wait.until(ExpectedConditions.visibilityOf(SupplierCategoryPage.addSupplierCatPopUp));
//Assert.assertEquals(SupplierCategoryPage.addSupplierCatPopUp.isDisplayed(), true);
//testCase.log(Status.INFO, "Add Supplier Category Pop Up Visible");
//testCase.log(Status.PASS, "So, Add Supplier Category Button Functionality Pass");
//			} catch (AssertionError e) {
//				testCase.log(Status.INFO, "Add Supplier Category Pop Up Not Visible");
//				testCase.log(Status.FAIL, "Add Supplier Category Button Functionality Fail");
//			} catch (Exception e) {
//				testCase.log(Status.INFO, "Add Supplier Category Pop Up Not Visible");
//				testCase.log(Status.FAIL, "Add Supplier Category Button Functionality Fail");
//			}
		}
	}

	static String supplierCategoryName = "";
	static String SuccessMsg = "";
	static boolean inputValue = false;
	public static boolean clickSaveBtn = false;

	public static void inputSupplierCategoryValue(String testcaseId, String tabName, String add) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		inputValue = false;
		clickSaveBtn = false;
		PageFactory.initElements(driver, supplierCategory);
		try {
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
			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);
				SuccessMsg = "Supplier Category Added Successfully";
				supplierCategoryName = "";
				supplierCategoryName = dataValue.formatCellValue(row.getCell(1));
				String des = dataValue.formatCellValue(row.getCell(2));

				clickAddSupplierCategoryBtn("Add Supplier Category Button Click");

				if (clickAddButton) {
					MultiSearchMethods.textBox(SupplierCategoryPage.supplierCategorytextBox, "Supplier Category");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						SupplierCategoryPage.supplierCategorytextBox.sendKeys(supplierCategoryName);
					}
					MultiSearchMethods.textBox(SupplierCategoryPage.description, " Description");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						SupplierCategoryPage.description.sendKeys(des);
					}
					inputValue = true;
				}
				clickSaveBtn = false;
				if (inputValue) {
					MultiSearchMethods.Button(SupplierCategoryPage.saveButton, " Supplier category Save ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						wait.until(ExpectedConditions.elementToBeClickable(SupplierCategoryPage.saveButton));
						SupplierCategoryPage.saveButton.click();
						clickSaveBtn = true;
					}
				}
				if (clickSaveBtn) {
					addedValueCheck(add);
				}
			}
		} catch (Exception e) {
			driver.navigate().refresh();
			testCase = extent.createTest("Excel File Not Found");
			testCase.log(Status.INFO, "Excel File Not Found");
			testCase.log(Status.FAIL, "Excel File Not Found, So fail");
		}
	}

	public static void addedValueCheck(String add) {
		PageFactory.initElements(driver, supplierCategory);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		boolean SupplierCategorySaveBtnVisible = false;
		try {

			Thread.sleep(1000);
			Assert.assertEquals(SupplierCategoryPage.saveButton.isDisplayed(), true);
			SupplierCategorySaveBtnVisible = true;
		} catch (AssertionError e) {
			SupplierCategorySaveBtnVisible = false;
		} catch (Exception e) {
			SupplierCategorySaveBtnVisible = false;
		}
		if (SupplierCategorySaveBtnVisible) {
			try {
				wait.until(ExpectedConditions.visibilityOf(SupplierCategoryPage.supplierCategoryValidation));
				validation = SupplierCategoryPage.supplierCategoryValidation.getText();
//				if (validation == "") {
//					wait.until(ExpectedConditions.visibilityOf(SupplierCategoryPage.descValidations));
//					validation = SupplierCategoryPage.descValidations.getText();
//				}
				vali = true;
			} catch (Exception e) {
				vali = false;
			}

			if (vali) {
				validation(supplierCategoryName);
				if (add.contains("add")) {
					testCase = extent.createTest("Add Supplier Category Function");
					if (exit) {
						testCase.log(Status.INFO, "Validation Throwing");
						testCase.log(Status.INFO, "But, Throwing Validation Not Confirmed");
						testCase.log(Status.FAIL, "Add Supplier Category Function is Fail");
					}
				} else if (add.contains("validation")) {

//					testCase = extent.createTest("Add Supplier Category Function");
//					if (exit) {
//						testCase.log(Status.INFO, "Validation Throwing");
//						testCase.log(Status.INFO, "But, Throwing Validation is Confirmed");
//						testCase.log(Status.PASS, "Add Supplier Category Function is Pass");
//					} 	else {
//					testCase.log(Status.INFO, "Validation Throwing");
//					testCase.log(Status.INFO, "But, Throwing Validation Not Confirmed");
//					testCase.log(Status.FAIL, "Add Supplier Category Function is Fail");
//				}
				}
			}
		} else {
			boolean success = false;
			testCase = extent.createTest("Supplier Category :- " + supplierCategoryName + " - Adding Success Message");
			try {
				Assert.assertEquals(SupplierCategoryPage.successMessages.getText(), SuccessMsg);
				testCase.log(Status.INFO,
						"Actual Success Message :- " + SupplierCategoryPage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
				testCase.log(Status.PASS, "Success Message  Matching, So Throwing Success Message Pass");
				success = true;
			} catch (AssertionError e) {
				testCase.log(Status.INFO,
						"Actual Success Message :- " + SupplierCategoryPage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
				testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
			} catch (Exception e) {
				testCase.log(Status.INFO,
						"Actual Success Message :- " + SupplierCategoryPage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
				testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
			}

			boolean firstRow = false;
			testCase = extent
					.createTest("Supplier Category :- " + supplierCategoryName + " - Added Value Check In First Row");

			try {
				Assert.assertEquals(SupplierCategoryPage.firstRowData.getText(), supplierCategoryName);
				testCase.log(Status.INFO, "Supplier Category :- " + supplierCategoryName + " Added Check in First Row");
				testCase.log(Status.INFO, "Added Value Founded In First Row");
				testCase.log(Status.PASS, "So, Add Suppplier Category Script Pass");
				firstRow = true;
			} catch (Exception e) {
				testCase.log(Status.INFO, "Supplier Category :- " + supplierCategoryName + " Added Check in First Row");
				testCase.log(Status.INFO, "Added Value Not Founded In First Row");
				testCase.log(Status.FAIL, "So, Add Supplier Category Script Fail");
			}

			if (success) {

				try {
					SupplierCategoryPage.successMessageCloseBtn.click();
				} catch (Exception e) {

				}
			}
			if (firstRow) {
			} else {
				int counts = 0;

				boolean enable = true;
				while (enable) {
					WebDriverWait wai = new WebDriverWait(driver, 2);

					int x = 0;
					try {

						wai.until(ExpectedConditions.visibilityOfAllElements(
								driver.findElements(By.xpath("//td[1][text()='" + supplierCategoryName + "']"))));
						x = driver.findElements(By.xpath("//td[1][text()='" + supplierCategoryName + "']")).size();
					} catch (Exception e) {
						e.printStackTrace();
					}
					counts = counts + x;
					try {
						enable = SupplierCategoryPage.NextPageBtn.isEnabled();
//		Click Next page Button
						if (enable) {

							SupplierCategoryPage.NextPageBtn.click();
//							wai.until(
//									ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//tr"))));
						}
					} catch (Exception e) {

					}

				}

				testCase = extent.createTest("Supplier Category :- " + supplierCategoryName
						+ " - Added Value Check In Supplier Category Table");
				if (counts == 1) {
					testCase.log(Status.INFO, "Supplier Category  :- " + supplierCategoryName
							+ " Added Check in Supplier Category Table");
					testCase.log(Status.INFO, "Added Value Founded In Supplier Category  Table");
					testCase.log(Status.PASS, "So, Add Supplier Category  Script Pass");
				} else {
					testCase.log(Status.INFO, "Supplier Category  :- " + supplierCategoryName
							+ " Added Check in Supplier Category Table");
					testCase.log(Status.INFO, "Added Value Duplicate In Supplier Category  Table");
					testCase.log(Status.FAIL, "So, Add Supplier Category  Script Fail");
				}
			}
			driver.navigate().refresh();
		}

	}

	public static boolean logout = false;

	public static void navigateSupplierCategory(String testcase) throws InterruptedException {
		logout = false;
		SupplierCategoryPage supp = new SupplierCategoryPage();
		PageFactory.initElements(driver, supp);

		testCase = extent.createTest(testcase.toUpperCase());

		LoginTest.Login();
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			String success = driver.findElement(By.xpath("//div[@class='ant-notification-notice-message']")).getText();
			if (success.contains("Successfully Loged in")) {
				wait.until(ExpectedConditions.invisibilityOf(
						driver.findElement(By.xpath("//div[@class='ant-notification-notice-message']"))));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		logout = LoginTest.login;

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}
		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateSupplierMain();
		}
		if (MasterMainNavigationsTest.clickSuppliermain) {
			MasterMainNavigationsTest.navigateSupplierCategory();
		}
	}

	public static void logout() {
		if (logout) {
			MultiSearchMethods.Logout();
		}
	}

	static String validation = "";
	static boolean vali = false;
	static String SupplierCategory = "";
	static String descr = "";
	static String supplierCategoryVal = "";
	static String descVal = "";

	public static void excel(String tabName, String testcaseId) {
		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", tabName,
				testcaseId);
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", tabName,
				testcaseId);
		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(tabName);
			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);
				SupplierCategory = dataValue.formatCellValue(row.getCell(1));
				descr = dataValue.formatCellValue(row.getCell(2));
				supplierCategoryVal = dataValue.formatCellValue(row.getCell(3));
				descVal = dataValue.formatCellValue(row.getCell(4));

				clickAddSupplierCategoryBtn("Add Supplier Category  Button Click");

				if (clickAddButton) {
					MultiSearchMethods.textBox(SupplierCategoryPage.supplierCategorytextBox,
							" Supplier Category TextBox");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						SupplierCategoryPage.supplierCategorytextBox.clear();
						SupplierCategoryPage.supplierCategorytextBox.sendKeys(SupplierCategory);
					}
					MultiSearchMethods.textBox(SupplierCategoryPage.description, " Description TextBox");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						SupplierCategoryPage.description.clear();
						SupplierCategoryPage.description.sendKeys(descr);
					}
					inputValue = true;
				}
				clickSaveBtn = false;
				if (inputValue) {
					MultiSearchMethods.Button(SupplierCategoryPage.saveButton, " Supplier Category Save ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						WebDriverWait wait = new WebDriverWait(driver, 20);
						wait.until(ExpectedConditions.elementToBeClickable(SupplierCategoryPage.saveButton));
						SupplierCategoryPage.saveButton.click();
						clickSaveBtn = true;
					}
				}
				boolean supplierCategorySaveBtnVisible = false;
				if (clickSaveBtn) {
					supplierCategorySaveBtnVisible = false;
					try {
						Thread.sleep(1000);
						Assert.assertEquals(SupplierCategoryPage.saveButton.isDisplayed(), true);
						supplierCategorySaveBtnVisible = true;
					} catch (AssertionError e) {
						supplierCategorySaveBtnVisible = false;
					} catch (Exception e) {
						supplierCategorySaveBtnVisible = false;
					}
				}
				if (supplierCategorySaveBtnVisible) {

					validation = "";
					vali = false;
					try {
						WebDriverWait wait = new WebDriverWait(driver, 5);
						wait.until(ExpectedConditions.visibilityOf(SupplierCategoryPage.supplierCategoryValidation));
						validation = SupplierCategoryPage.supplierCategoryValidation.getText();
//						if (validation == "") {
//							wait.until(ExpectedConditions.visibilityOf(SupplierCategoryPage.descValidations));
//							validation = SupplierCategoryPage.descValidations.getText();
//						}
						vali = true;
					} catch (Exception e) {
						vali = false;
					}

					validation(supplierCategoryName);
				}
			}

		} catch (Exception e) {
			driver.navigate().refresh();
			testCase = extent.createTest("Excel File Not Found");
			testCase.log(Status.INFO, "Excel File Not Found");
			testCase.log(Status.FAIL, "Excel File Not Found, So fail");
		}
	}

	static boolean exit = false;

	public static void validation(String supplierCategory) {

		if (validation.contains("Supplier Category can't be empty")) {
			testCase = extent.createTest("Empty Validation Throwing");
			try {
				String val = SupplierCategoryPage.supplierCategorytextBox.getAttribute("value");
				testCase = extent
						.createTest("Empty Validation Confirmation For Supplier Category :- " + supplierCategory);
				if (val == "") {
					exit = false;
					testCase.log(Status.INFO, "Supplier Category Data is :- " + val);
					testCase.log(Status.INFO, "Supplier Category Data is Empty");
					testCase.log(Status.PASS, "So, Empty Validation Correct");
					exit = true;
				} else {
					testCase.log(Status.INFO, "Supplier Category Data is :- " + val);
					testCase.log(Status.INFO, "Supplier Category Data is not Empty");
					testCase.log(Status.PASS, "So, Empty Validation Wrong");

				}
			} catch (Exception e) {

			}
			driver.navigate().refresh();
		} else if(validation.contains("Supplier Category allow only letters and Numbers")) {

			testCase = extent.createTest("Special Characters Validation Throwing");

			try {
				String val = SupplierCategoryPage.supplierCategorytextBox.getAttribute("value");
				boolean result = areAllLetters(val);
				testCase = extent.createTest(
						"Special Characters Validation Confirmation For Supplier Category :- " + supplierCategory);
				if (result == false) {
					exit = false;
					testCase.log(Status.INFO, "supplier Category Name is:- " + val);
					testCase.log(Status.INFO, "supplier Category Having Correct Format Letters");
					testCase.log(Status.PASS, "So, Wrong Characters Validation Correct");
					exit = true;
				} else {
					testCase.log(Status.INFO, "supplier Category Name is:- " + val);
					testCase.log(Status.INFO, "supplier Category Having Wrong Format Letters");
					testCase.log(Status.PASS, "So, Wrong Characters Validation Wrong");

				}
			} catch (Exception e) {

			}
			driver.navigate().refresh();
		
		}
		else if (validation.contains("Supplier Category already exists")) {
			testCase = extent
					.createTest("Already Exists Validation Throwing For Supplier Category :- " + supplierCategory);
			driver.navigate().refresh();
			boolean checkValue = false;

			boolean enable = true;
			while (enable) {

				int x = 0;
				try {
					WebDriverWait wai = new WebDriverWait(driver, 5);
					wai.until(ExpectedConditions.visibilityOfAllElements(
							driver.findElements(By.xpath("//td[1][text()='" + supplierCategory + "']"))));
					x = driver.findElements(By.xpath("//td[1][text()='" + supplierCategory + "']")).size();
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (x == 1) {
					checkValue = true;
					break;
				}
				try {
					enable = SupplierCategoryPage.NextPageBtn.isEnabled();
//		Click Next page Button
					if (enable) {

						SupplierCategoryPage.NextPageBtn.click();
//						WebDriverWait wait = new WebDriverWait(driver, 20);
//						wait.until(ExpectedConditions
//								.visibilityOfAllElements(driver.findElements(By.xpath("//tr"))));
					}
				} catch (Exception e) {

				}

			}
			testCase = extent
					.createTest("Already Exists Validation Confirmation For Supplier Category :- " + supplierCategory);
			if (checkValue) {
				exit = false;
				testCase.log(Status.INFO, "SBU :- " + supplierCategory + " Already Exits in Supplier Category Table");
				testCase.log(Status.INFO, "SBU :- " + supplierCategory + " Founded In Supplier Category Table");
				testCase.log(Status.PASS, "So, Already Exists Validation Correct");
				exit = true;
			} else {
				testCase.log(Status.INFO, "SBU :- " + supplierCategory + " Not in Supplier Category Table");
				testCase.log(Status.INFO, "Added Value Not Founded In Supplier Category Table");
				testCase.log(Status.FAIL, "So, System  Fail");
			}

		} else if (validation.contains("At Least 2 characters long!")) {
			testCase = extent.createTest("Added Data Lenth Not Match Validation Throwing");

			try {
				String val = SupplierCategoryPage.supplierCategorytextBox.getAttribute("value");
				int length = val.length();
				testCase = extent.createTest(
						"Lenth Not Match Validation Confirmation For Supplier Category :- " + supplierCategoryName);
				if (length <= 3) {
					exit = false;
					testCase.log(Status.INFO, "Supplier Category Lenth is:- " + length);
					testCase.log(Status.INFO, "Supplier Category Lenth is grater than 3");
					testCase.log(Status.PASS, "So, Lenth Not Match Validation Correct");
					exit = true;
				} else {
					testCase.log(Status.INFO, "Supplier Category Lenth is:- " + length);
					testCase.log(Status.PASS, "So, Lenth Not Match Validation Wrong");

				}
			} catch (Exception e) {

			}

			driver.navigate().refresh();
		} 
		else {
			testCase = extent.createTest("There should be error message");
			testCase.log(Status.INFO, "supplier Category validation");
			testCase.log(Status.FAIL, "Validation Not Throwing, So supplier Category Added Fail");
			driver.navigate().refresh();
		}
	}

	public static boolean areAllLetters(String word) {
		return word.matches("[a-zA-Z]+");
	}

	public static void edit(String excelName, String tabName, String testCaseId) {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + excelName + ".xlsx";
		int firstrow = CommonMethods.getFirstRowNum(excelPath, tabName, testCaseId);
		int lastrow = CommonMethods.getLastRowNum(excelPath, tabName, testCaseId);
		try {
			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(tabName);
			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);
				String editsupCat = dataValue.formatCellValue(row.getCell(1));
				String editdes = dataValue.formatCellValue(row.getCell(2));
				String newsupCat = dataValue.formatCellValue(row.getCell(3));
				String newdes = dataValue.formatCellValue(row.getCell(4));

				int size = 0;
				try {
					size = driver.findElements(By.xpath("//tbody/tr")).size();
				} catch (Exception e) {
					size = 11;
				}
				boolean next = true;
				boolean check = false;
				while (next) {
					for (int k = 2; k <= size; k++) {
						WebElement supplierCat = driver.findElement(By.xpath("//tbody/tr[" + k + "]/td[1]"));
						String supCatName = supplierCat.getText();
						System.out.println(supCatName + " " + editsupCat);
						if (supCatName.contentEquals(editsupCat)) {
							WebElement editElement = driver.findElement(
									By.xpath("//td[text()='" + editsupCat + "']/following-sibling::td[2]/span/a[1]"));
							MultiSearchMethods.icon(editElement, editsupCat + " Edit ");
							if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
								editElement.click();
								check = true;
								break;
							}
						}
					}
					if (check) {
						break;
					}
					try {
						next = SupplierCategoryPage.NextPageBtn.isEnabled();
						if (next) {
							SupplierCategoryPage.NextPageBtn.click();
							Thread.sleep(1000);
						}
					} catch (Exception e) {
					}
				}
				if (check == false) {
					testCase = extent.createTest("Searched Element Not There");
					testCase.log(Status.INFO, "Searched data : " + editsupCat);
					testCase.log(Status.FAIL, "Searched Data Not In WebTable");
				}
				boolean save = false;
				boolean input = false;
				if (check) {

					MultiSearchMethods.textBox(SupplierCategoryPage.supplierCategorytextBox, "Supplier Category");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						Thread.sleep(1000);
						testCase = extent.createTest("Supplier Category Data Confirm Before Edit");
						try {
							Assert.assertEquals(SupplierCategoryPage.supplierCategorytextBox.getAttribute("value"),
									editsupCat);
							testCase.log(Status.INFO, "Supplier Category Field Actual Data : "
									+ SupplierCategoryPage.supplierCategorytextBox.getAttribute("value"));
							testCase.log(Status.INFO, "Supplier Category Field Expected Data : " + editsupCat);
							testCase.log(Status.PASS, "Expected and Actual are matching, So Pass");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Supplier Category Field Actual Data : "
									+ SupplierCategoryPage.supplierCategorytextBox.getAttribute("value"));
							testCase.log(Status.INFO, "Supplier Category Field Expected Data : " + editsupCat);
							testCase.log(Status.FAIL, "Expected and Actual are not matching, So Fail");
						} catch (Exception e) {
							testCase.log(Status.INFO, "Supplier Category Field Actual Data : "
									+ SupplierCategoryPage.supplierCategorytextBox.getAttribute("value"));
							testCase.log(Status.INFO, "Supplier Category Field Expected Data : " + editsupCat);
							testCase.log(Status.FAIL, "Expected and Actual are not matching, So Fail");
						}
						SupplierCategoryPage.supplierCategorytextBox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
						SupplierCategoryPage.supplierCategorytextBox.sendKeys(newsupCat);
						input = true;
					}

					MultiSearchMethods.textBox(SupplierCategoryPage.description, "Description ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						Thread.sleep(1000);
						testCase = extent.createTest("Description Data Confirm Before Edit");
						try {
							Assert.assertEquals(SupplierCategoryPage.description.getAttribute("value"),
									editdes);
							testCase.log(Status.INFO, "Supplier Category Field Actual Data : "
									+ SupplierCategoryPage.description.getAttribute("value"));
							testCase.log(Status.INFO, "Supplier Category Field Expected Data : " + editdes);
							testCase.log(Status.PASS, "Expected and Actual are matching, So Pass");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Supplier Category Field Actual Data : "
									+ SupplierCategoryPage.description.getAttribute("value"));
							testCase.log(Status.INFO, "Supplier Category Field Expected Data : " + editdes);
							testCase.log(Status.FAIL, "Expected and Actual are not matching, So Fail");
						} catch (Exception e) {
							testCase.log(Status.INFO, "Supplier Category Field Actual Data : "
									+ SupplierCategoryPage.description.getAttribute("value"));
							testCase.log(Status.INFO, "Supplier Category Field Expected Data : " + editdes);
							testCase.log(Status.FAIL, "Expected and Actual are not matching, So Fail");
						}
						SupplierCategoryPage.description.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
						SupplierCategoryPage.description.sendKeys(newdes);
						input = true;
					}

					if (input) {
						MultiSearchMethods.Button(SupplierCategoryPage.UpdateButton, "Supplier Category Update");
						if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
							WebDriverWait wait = new WebDriverWait(driver, 10);
							wait.until(ExpectedConditions.elementToBeClickable(SupplierCategoryPage.UpdateButton));
							SupplierCategoryPage.UpdateButton.click();
							save = true;
						}
					}
				}
				boolean saveCheck = false;
				if (save) {
					try {
						Thread.sleep(2000);
						Assert.assertEquals(SupplierCategoryPage.UpdateButton.isDisplayed(), true);
						saveCheck = true;
					} catch (Exception e) {
						saveCheck = false;
					} catch (AssertionError e) {
						saveCheck = false;
					}
				}

				if (saveCheck) {
					validation = SupplierCategoryPage.supplierCategoryValidation.getText();
					validation(newsupCat);
					testCase = extent.createTest("Update Supplier Category Function");
					if (exit) {
//						testCase.log(Status.INFO, "Already Exits Validation Throwing");
//						testCase.log(Status.INFO, "But, Already Exits Validation is Confirmed");
//						testCase.log(Status.PASS, "Add Supplier Category Function is Pass");
						testCase.log(Status.INFO, "Already Exits Validation Throwing");
						testCase.log(Status.INFO, "But, Already Exits Validation Not Confirmed");
						testCase.log(Status.FAIL, "Add Supplier Category Function is Fail");
					}
//					else {
//						testCase.log(Status.INFO, "Already Exits Validation Throwing");
//						testCase.log(Status.INFO, "But, Already Exits Validation Not Confirmed");
//						testCase.log(Status.FAIL, "Add Supplier Category Function is Fail");
//					}
				} else {
					String updateSuccessMsg = "Supplier Category Updated Successfully";
					testCase = extent
							.createTest("Supplier Category :- " + supplierCategoryName + " - Updating Success Message");
					try {
						Assert.assertEquals(SupplierCategoryPage.successMessages.getText(), updateSuccessMsg);
						testCase.log(Status.INFO,
								"Actual Success Message :- " + SupplierCategoryPage.successMessages.getText());
						testCase.log(Status.INFO, "Expected Success Message :- " + updateSuccessMsg);
						testCase.log(Status.PASS, "Success Message  Matching, So Throwing Success Message Pass");
						try {
							SupplierCategoryPage.successMessageCloseBtn.click();
						} catch (Exception e) {

						}
					} catch (AssertionError e) {
						testCase.log(Status.INFO,
								"Actual Success Message :- " + SupplierCategoryPage.successMessages.getText());
						testCase.log(Status.INFO, "Expected Success Message :- " + updateSuccessMsg);
						testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
					} catch (Exception e) {
						testCase.log(Status.INFO,
								"Actual Success Message :- " + SupplierCategoryPage.successMessages.getText());
						testCase.log(Status.INFO, "Expected Success Message :- " + updateSuccessMsg);
						testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
					}

					testCase = extent
							.createTest("Supplier Category :- " + supplierCategoryName + " - Updated Value Check In First Row");

					try {
						Assert.assertEquals(SupplierCategoryPage.firstRowData.getText(), newsupCat);
						testCase.log(Status.INFO, "Supplier Category :- " + newsupCat + " Updated Check in First Row");
						testCase.log(Status.INFO, "Added Value Founded In First Row");
						testCase.log(Status.PASS, "So, Add Supplier Category Script Pass");

					} catch (Exception e) {
						testCase.log(Status.INFO, "Supplier Category :- " + newsupCat + " Updated Check in First Row");
						testCase.log(Status.INFO, "Added Value Not Founded In First Row");
						testCase.log(Status.FAIL, "So, Add Supplier Category Script Fail");
					}
				}
			}
		} catch (Exception e) {
			driver.navigate().refresh();
			testCase = extent.createTest("Excel File Not Found");
			testCase.log(Status.INFO, "Excel File Not Found");
			testCase.log(Status.FAIL, "Excel File Not Found, So fail");
		}
	}

	public static void report(String name, String Valida) {
		testCase = extent.createTest(name + " Validation Throwing");
		testCase.log(Status.INFO, name + "Validation : " + Valida);
		testCase.log(Status.PASS, "Validation Throwing");
	}
}
