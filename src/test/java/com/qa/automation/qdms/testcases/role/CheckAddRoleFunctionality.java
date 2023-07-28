//***********************************************************************************
//* Description
//*------------
//*Check Add Role Functionality - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 03/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-ROL-0016           03/04/2023   Saranka     Original Version
//*                       18/07/2023   RAHUL.S     Modified(change the methods)
//  TC-ROL-0022           19//07/2023  RAHUL.S     Modified(for validation)
//************************************************************************************

package com.qa.automation.qdms.testcases.role;

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
import com.qa.automation.qdms.pages.master.RolePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class CheckAddRoleFunctionality extends DriverIntialization {

	static DataFormatter dataValue = new DataFormatter();
	static RolePage role = new RolePage();
	static boolean checkValues = false;
	public static boolean clickAddButton = false;

	public static void clickAddRoleBtn(String TestCase) {
		clickAddButton = false;
		PageFactory.initElements(driver, role);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		MultiSearchMethods.Button(RolePage.addRoleButton, "Add Role");
		if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(RolePage.addRoleButton));
				RolePage.addRoleButton.click();
				clickAddButton = true;
			} catch (Exception e) {
				testCase = extent.createTest("Add Role Button Click");
				testCase.log(Status.INFO, "Add Role Button Clicked Fail");
				testCase.log(Status.FAIL, "Role Save Button not Visible, Button Clicked Fail");
			}
		}
	}

	static String roleName = "";
	static String SuccessMsg = "";
	static boolean inputValue = false;
	public static boolean clickSaveBtn = false;

	public static void inputRoleValue(String testcaseId, String tabName, String add) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		inputValue = false;
		clickSaveBtn = false;
		PageFactory.initElements(driver, role);
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
				SuccessMsg = "Role Added Successfully";
				roleName = "";
				roleName = dataValue.formatCellValue(row.getCell(1));

				clickAddRoleBtn("Add Role Button Click");

				if (clickAddButton) {
					MultiSearchMethods.textBox(RolePage.RoleNameTextField, " Role TextBox");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						RolePage.RoleNameTextField.sendKeys(roleName);
					}
//					MultiSearchMethods.textBox(RolePage.RoleNameTextField,  " Description TextBox");
//					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
//						RolePage.RoleNameTextField.sendKeys(des);
//					}
					inputValue = true;
				}
				clickSaveBtn = false;
				if (inputValue) {
					MultiSearchMethods.Button(RolePage.saveButton, " Role Save ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						wait.until(ExpectedConditions.elementToBeClickable(RolePage.saveButton));
						RolePage.saveButton.click();
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
		PageFactory.initElements(driver, role);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		boolean roleSaveBtnVisible = false;
		try {

			Thread.sleep(1000);
			Assert.assertEquals(RolePage.saveButton.isDisplayed(), true);
			roleSaveBtnVisible = true;
		} catch (AssertionError e) {
			roleSaveBtnVisible = false;
		} catch (Exception e) {
			roleSaveBtnVisible = false;
		}
		if (roleSaveBtnVisible) {
			try {
				wait.until(ExpectedConditions.visibilityOf(RolePage.roleValidation));
				validation = RolePage.roleValidation.getText();
//				if (validation == "") {
//					wait.until(ExpectedConditions.visibilityOf(RolePage.descValidations));
//					validation = RolePage.descValidations.getText();
//				}
				vali = true;
			} catch (Exception e) {
				vali = false;
			}

			if (vali) {
				validation(roleName);
				if (add.contains("add")) {
					testCase = extent.createTest("Add Role Function");
					if (exit) {
						testCase.log(Status.INFO, "Validation Throwing");
						testCase.log(Status.INFO, "But, Throwing Validation Not Confirmed");
						testCase.log(Status.FAIL, "Add Role Function is Fail");
					}
				} else if (add.contains("validation")) {

//					testCase = extent.createTest("Add Role Function");
//					if (exit) {
//						testCase.log(Status.INFO, "Validation Throwing");
//						testCase.log(Status.INFO, "But, Throwing Validation is Confirmed");
//						testCase.log(Status.PASS, "Add Role Function is Pass");
//					} 	else {
//					testCase.log(Status.INFO, "Validation Throwing");
//					testCase.log(Status.INFO, "But, Throwing Validation Not Confirmed");
//					testCase.log(Status.FAIL, "Add Role Function is Fail");
//				}
				}
			}
		} else {
			boolean success = false;
			testCase = extent.createTest("Role :- " + roleName + " - Adding Success Message");
			try {
				Assert.assertEquals(RolePage.successMessages.getText(), SuccessMsg);
				testCase.log(Status.INFO, "Actual Success Message :- " + RolePage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
				testCase.log(Status.PASS, "Success Message  Matching, So Throwing Success Message Pass");
				success = true;
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Success Message :- " + RolePage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
				testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
			} catch (Exception e) {
				testCase.log(Status.INFO, "Actual Success Message :- " + RolePage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
				testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
			}

			boolean firstRow = false;
			testCase = extent.createTest("Role :- " + roleName + " - Added Value Check In First Row");

			try {
				Assert.assertEquals(RolePage.firstRowData.getText(), roleName);
				testCase.log(Status.INFO, "Role :- " + roleName + " Added Check in First Row");
				testCase.log(Status.INFO, "Added Value Founded In First Row");
				testCase.log(Status.PASS, "So, Add Role Script Pass");
				firstRow = true;
			} catch (Exception e) {
				testCase.log(Status.INFO, "Role :- " + roleName + " Added Check in First Row");
				testCase.log(Status.INFO, "Added Value Not Founded In First Row");
				testCase.log(Status.FAIL, "So, Add Role Script Fail");
			}

			if (success) {

				try {
					RolePage.successMessageCloseBtn.click();
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
								driver.findElements(By.xpath("//td[1][text()='" + roleName + "']"))));
						x = driver.findElements(By.xpath("//td[1][text()='" + roleName + "']")).size();
					} catch (Exception e) {
						e.printStackTrace();
					}
					counts = counts + x;
					try {
						enable = RolePage.NextPageBtn.isEnabled();
//		Click Next page Button
						if (enable) {

							RolePage.NextPageBtn.click();
//							wai.until(
//									ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//tr"))));
						}
					} catch (Exception e) {

					}

				}

				testCase = extent.createTest("Role :- " + roleName + " - Added Value Check In Role Table");
				if (counts == 1) {
					testCase.log(Status.INFO, "Role :- " + roleName + " Added Check in Role Table");
					testCase.log(Status.INFO, "Added Value Founded In Role Table");
					testCase.log(Status.PASS, "So, Add Role Script Pass");
				} else {
					testCase.log(Status.INFO, "Role :- " + roleName + " Added Check in Role Table");
					testCase.log(Status.INFO, "Added Value Duplicate In Role Table");
					testCase.log(Status.FAIL, "So, Add Role Script Fail");
				}
			}
			driver.navigate().refresh();
		}

	}

	public static boolean logout = false;

	public static void navigaterole(String testcase) throws InterruptedException {
		logout = false;
		RolePage role = new RolePage();
		PageFactory.initElements(driver, role);

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
			MasterMainNavigationsTest.navigateEmployeeMain();
		}
		if (MasterMainNavigationsTest.clickEmployeeMain) {
			MasterMainNavigationsTest.navigateRole();
		}
	}

	public static void logout() {
		if (logout) {
			MultiSearchMethods.Logout();
		}
	}

	static String validation = "";
	static boolean vali = false;
	static String rrole = "";
	static String roleVal = "";

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
				rrole = dataValue.formatCellValue(row.getCell(1));

				roleVal = dataValue.formatCellValue(row.getCell(3));

				clickAddRoleBtn("Add Role Button Click");

				if (clickAddButton) {
					MultiSearchMethods.textBox(RolePage.RoleNameTextField, "Role TextBox");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						RolePage.RoleNameTextField.clear();
						RolePage.RoleNameTextField.sendKeys(rrole);
					}
//					MultiSearchMethods.textBox(RolePage.RoleNameTextField, " Description TextBox");
//					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
//						RolePage.RoleNameTextField.clear();
//						RolePage.RoleNameTextField.sendKeys(descr);
//					}
					inputValue = true;
				}
				clickSaveBtn = false;
				if (inputValue) {
					MultiSearchMethods.Button(RolePage.saveButton, " Role Save ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						WebDriverWait wait = new WebDriverWait(driver, 20);
						wait.until(ExpectedConditions.elementToBeClickable(RolePage.saveButton));
						RolePage.saveButton.click();
						clickSaveBtn = true;
					}
				}
				boolean roleSaveBtnVisible = false;
				if (clickSaveBtn) {
					roleSaveBtnVisible = false;
					try {
						Thread.sleep(1000);
						Assert.assertEquals(RolePage.saveButton.isDisplayed(), true);
						roleSaveBtnVisible = true;
					} catch (AssertionError e) {
						roleSaveBtnVisible = false;
					} catch (Exception e) {
						roleSaveBtnVisible = false;
					}
				}
				if (roleSaveBtnVisible) {

					validation = "";
					vali = false;
					try {
						WebDriverWait wait = new WebDriverWait(driver, 5);
						wait.until(ExpectedConditions.visibilityOf(RolePage.roleValidation));
						validation = RolePage.roleValidation.getText();
//						if (validation == "") {
//							wait.until(ExpectedConditions.visibilityOf(RolePage.descValidations));
//							validation = RolePage.descValidations.getText();
//						}
						vali = true;
					} catch (Exception e) {
						vali = false;
					}

					validation(roleName);
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

	public static void validation(String role) {

		if (validation.contains("Role can't be empty")) {
			testCase = extent.createTest("Empty Validation Throwing");
			try {
				String val = RolePage.RoleNameTextField.getAttribute("value");
				testCase = extent.createTest("Empty Validation Confirmation For Role :- " + role);
				if (val == "") {
					exit = false;
					testCase.log(Status.INFO, "Role Data is :- " + val);
					testCase.log(Status.INFO, "Role Data is Empty");
					testCase.log(Status.PASS, "So, Empty Validation Correct");
					exit = true;
				} else {
					testCase.log(Status.INFO, "Role Data is :- " + val);
					testCase.log(Status.INFO, "Role Data is not Empty");
					testCase.log(Status.PASS, "So, Empty Validation Wrong");

				}
			} catch (Exception e) {

			}
			driver.navigate().refresh();
		} else if (validation.contains("Role Already Exist")) {
			testCase = extent.createTest("Already Exists Validation Throwing For Role :- " + role);
			driver.navigate().refresh();
			boolean checkValue = false;

			boolean enable = true;
			while (enable) {

				int x = 0;
				try {
					WebDriverWait wai = new WebDriverWait(driver, 5);
					wai.until(ExpectedConditions
							.visibilityOfAllElements(driver.findElements(By.xpath("//td[1][text()='" + role + "']"))));
					x = driver.findElements(By.xpath("//td[1][text()='" + role + "']")).size();
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (x == 1) {
					checkValue = true;
					break;
				}
				try {
					enable = RolePage.NextPageBtn.isEnabled();
//		Click Next page Button
					if (enable) {

						RolePage.NextPageBtn.click();
//						WebDriverWait wait = new WebDriverWait(driver, 20);
//						wait.until(ExpectedConditions
//								.visibilityOfAllElements(driver.findElements(By.xpath("//tr"))));
					}
				} catch (Exception e) {

				}

			}
			testCase = extent.createTest("Already Exists Validation Confirmation For Role :- " + role);
			if (checkValue) {
				exit = false;
				testCase.log(Status.INFO, "Role :- " + role + " Already Exits in Role Table");
				testCase.log(Status.INFO, "Role :- " + role + " Founded In Role Table");
				testCase.log(Status.PASS, "So, Already Exists Validation Correct");
				exit = true;
			} else {
				testCase.log(Status.INFO, "Role :- " + role + " Not in Role Table");
				testCase.log(Status.INFO, "Added Value Not Founded In Role Table");
				testCase.log(Status.FAIL, "So, System  Fail");
			}

		} else if (validation.contains("At Least 2 characters long!")) {
			testCase = extent.createTest("Added Data Lenth Not Match Validation Throwing");

			try {
				String val = RolePage.RoleNameTextField.getAttribute("value");
				int length = val.length();
				testCase = extent.createTest("Lenth Not Match Validation Confirmation For Role :- " + roleName);
				if (length <= 3) {
					exit = false;
					testCase.log(Status.INFO, "Role Lenth is:- " + length);
					testCase.log(Status.INFO, "Role Lenth is grater than 3");
					testCase.log(Status.PASS, "So, Lenth Not Match Validation Correct");
					exit = true;
				} else {
					testCase.log(Status.INFO, "Role Lenth is:- " + length);
					testCase.log(Status.PASS, "So, Lenth Not Match Validation Wrong");

				}
			} catch (Exception e) {

			}

			driver.navigate().refresh();
		} else if (validation.contains("Role allow only letters")) {
			testCase = extent.createTest("Wrong Characters Validation Throwing");

			try {
				String val = RolePage.RoleNameTextField.getAttribute("value");
				boolean result = areAllLetters(val);
				testCase = extent.createTest("Wrong Characters Validation Confirmation For Role :- " + role);
				if (result == false) {
					exit = false;
					testCase.log(Status.INFO, "Role Name is:- " + val);
					testCase.log(Status.INFO, "Role Having Correct Format Letters");
					testCase.log(Status.PASS, "So, Wrong Characters Validation Correct");
					exit = true;
				} else {
					testCase.log(Status.INFO, "Role Name is:- " + val);
					testCase.log(Status.INFO, "Role Having Wrong Format Letters");
					testCase.log(Status.PASS, "So, Wrong Characters Validation Wrong");

				}
			} catch (Exception e) {

			}
			driver.navigate().refresh();
		} else {
			testCase = extent.createTest("Role added fail");
			testCase.log(Status.INFO, "Role Added Fail");
			testCase.log(Status.FAIL, "Validation Throwing, So Role Added Fail");
			driver.navigate().refresh();
		}
	}

	public static boolean areAllLetters(String word) {
		return word.matches("[a-zA-Z]+");
	}

	public static void editRole(String excelName, String tabName, String testCaseId) {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + excelName + ".xlsx";
		int firstrow = CommonMethods.getFirstRowNum(excelPath, tabName, testCaseId);
		int lastrow = CommonMethods.getLastRowNum(excelPath, tabName, testCaseId);
		try {
			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(tabName);
			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);
				String editRole = dataValue.formatCellValue(row.getCell(1));

				String newRole = dataValue.formatCellValue(row.getCell(2));

				int size = 0;
				try {
					size = driver.findElements(By.xpath("//tbody/tr")).size();
				} catch (Exception e) {
					size = 11;
				}
				boolean next = true;
				boolean check = false;
				while (next) {
					for (int k = 1; k <= size; k++) {
						WebElement role = driver.findElement(By.xpath("//tbody/tr[" + k + "]/td[1]"));
						String roleName = role.getText();
						System.out.println(roleName + " " + editRole);
						if (roleName.contentEquals(editRole)) {
							WebElement editElement = driver.findElement(
									By.xpath("//td[text()='" + editRole + "']/following-sibling::td[1]/span/a[1]"));
							MultiSearchMethods.icon(editElement, editRole + " Edit ");
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
						next = RolePage.NextPageBtn.isEnabled();
						if (next) {
							RolePage.NextPageBtn.click();
							Thread.sleep(1000);
						}
					} catch (Exception e) {
					}
				}
				if (check == false) {
					testCase = extent.createTest("Searched Element Not There");
					testCase.log(Status.INFO, "Searched data : " + editRole);
					testCase.log(Status.FAIL, "Searched Data Not In WebTable");
				}
				boolean save = false;
				boolean input = false;
				if (check) {

					MultiSearchMethods.textBox(RolePage.RoleNameTextField, "Role ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						Thread.sleep(1000);
						testCase = extent.createTest("Role Data Confirm Before Edit");
						try {
							Assert.assertEquals(RolePage.RoleNameTextField.getAttribute("value"), editRole);
							testCase.log(Status.INFO,
									"Role Field Actual Data : " + RolePage.RoleNameTextField.getAttribute("value"));
							testCase.log(Status.INFO, "Role Field Expected Data : " + editRole);
							testCase.log(Status.PASS, "Expected and Actual are matching, So Pass");
						} catch (AssertionError e) {
							testCase.log(Status.INFO,
									"Role Field Actual Data : " + RolePage.RoleNameTextField.getAttribute("value"));
							testCase.log(Status.INFO, "Role Field Expected Data : " + editRole);
							testCase.log(Status.FAIL, "Expected and Actual are not matching, So Fail");
						} catch (Exception e) {
							testCase.log(Status.INFO,
									"Role Field Actual Data : " + RolePage.RoleNameTextField.getAttribute("value"));
							testCase.log(Status.INFO, "Role Field Expected Data : " + editRole);
							testCase.log(Status.FAIL, "Expected and Actual are not matching, So Fail");
						}
						RolePage.RoleNameTextField.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
						RolePage.RoleNameTextField.sendKeys(newRole);
						input = true;
					}

					if (input) {
						MultiSearchMethods.Button(RolePage.UpdateButton, "Role Update");
						if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
							WebDriverWait wait = new WebDriverWait(driver, 10);
							wait.until(ExpectedConditions.elementToBeClickable(RolePage.UpdateButton));
							RolePage.UpdateButton.click();
							save = true;
						}
					}
				}
				boolean saveCheck = false;
				if (save) {
					try {
						Thread.sleep(2000);
						Assert.assertEquals(RolePage.UpdateButton.isDisplayed(), true);
						saveCheck = true;
					} catch (Exception e) {
						saveCheck = false;
					} catch (AssertionError e) {
						saveCheck = false;
					}
				}

				if (saveCheck) {
					validation = RolePage.roleValidation.getText();
					validation(newRole);
					testCase = extent.createTest("Update Role Function");
					if (exit) {
//						testCase.log(Status.INFO, "Already Exits Validation Throwing");
//						testCase.log(Status.INFO, "But, Already Exits Validation is Confirmed");
//						testCase.log(Status.PASS, "Add Role Function is Pass");
//						testCase.log(Status.INFO, "Already Exits Validation Throwing");
//						testCase.log(Status.INFO, "But, Already Exits Validation Not Confirmed");
						testCase.log(Status.FAIL, "Edit Role Function is Fail");
					} else {
//						testCase.log(Status.INFO, "Already Exits Validation Throwing");
//						testCase.log(Status.INFO, "But, Already Exits Validation Not Confirmed");
						testCase.log(Status.FAIL, "Edit Role Function is Fail");
					}
				} else {
					String updateSuccessMsg = "Role Updated Successfully";
					testCase = extent.createTest("Role :- " + roleName + " - Updating Success Message");
					try {
						Assert.assertEquals(RolePage.successMessages.getText(), updateSuccessMsg);
						testCase.log(Status.INFO, "Actual Success Message :- " + RolePage.successMessages.getText());
						testCase.log(Status.INFO, "Expected Success Message :- " + updateSuccessMsg);
						testCase.log(Status.PASS, "Success Message  Matching, So Throwing Success Message Pass");
						try {
							RolePage.successMessageCloseBtn.click();
						} catch (Exception e) {
							// TODO: handle exception
						}
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "Actual Success Message :- " + RolePage.successMessages.getText());
						testCase.log(Status.INFO, "Expected Success Message :- " + updateSuccessMsg);
						testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
					} catch (Exception e) {
						testCase.log(Status.INFO, "Actual Success Message :- " + RolePage.successMessages.getText());
						testCase.log(Status.INFO, "Expected Success Message :- " + updateSuccessMsg);
						testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
					}

					testCase = extent.createTest("Role :- " + roleName + " - Updated Value Check In First Row");

					try {
						Assert.assertEquals(RolePage.firstRowData.getText(), newRole);
						testCase.log(Status.INFO, "Role :- " + newRole + " Updated Check in First Row");
						testCase.log(Status.INFO, "Added Value Founded In First Row");
						testCase.log(Status.PASS, "So, Add Role Script Pass");

					} catch (Exception e) {
						testCase.log(Status.INFO, "Role :- " + newRole + " Updated Check in First Row");
						testCase.log(Status.INFO, "Added Value Not Founded In First Row");
						testCase.log(Status.FAIL, "So, Add Role Script Fail");
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
