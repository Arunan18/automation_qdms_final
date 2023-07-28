//***********************************************************************************
//* Description
//*------------
//* Check Edited Validation --TC-ROL-0032
//***********************************************************************************
//*
//* Author � � � � � : Saranka Somessaran
//* Date Written � � : 13/03/2023
//* 
//*
//* 
//* Test Case Number � � � Date � � � � Intis � � � �Comments
//* ================ � � � ==== � � � � ===== � � � �========
//* � � � � � � � � � � � �13/03/2023 � Saranka � � Original Version
//*                      25/07/2023-- RAHUL.S      Modified
//************************************************************************************
package com.qa.automation.qdms.testcases.role;

import java.io.FileInputStream;
import java.util.NoSuchElementException;
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
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.RolePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class CheckEditedValidation extends DriverIntialization {

	@Test
	public static void editRole() throws InterruptedException {
		navigaterole("TC-ROL-0032 - Role Edit Validation Function");

		if (MasterMainNavigationsTest.clickEmployeeMain) {
			editRole("Master Module", "Role", "TC-ROL-0032");
		}
		logout();

	}

	static DataFormatter dataValue = new DataFormatter();
	static RolePage role = new RolePage();
	static boolean checkValues = false;
	public static boolean clickAddButton = false;

	static String roleName = "";
	static String SuccessMsg = "";
	static boolean inputValue = false;
	public static boolean clickSaveBtn = false;

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
					testCase.log(Status.FAIL, "So, Empty Validation Wrong");

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
					testCase.log(Status.FAIL, "So, Lenth Not Match Validation Wrong");

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
					testCase.log(Status.FAIL, "So, Wrong Characters Validation Wrong");

				}
			} catch (Exception e) {

			}
			driver.navigate().refresh();
		} else {
			testCase = extent.createTest("Role Edit Validation fail");
			testCase.log(Status.INFO, "Role Edit VALidation Fail");
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
					try {
						validation = RolePage.roleValidation.getText();
					} catch (NoSuchElementException e) {

					} catch (Exception e) {

					}
					validation(newRole);
					testCase = extent.createTest("Role edit validation function");
					if (exit) {
//						testCase.log(Status.INFO, "Already Exits Validation Throwing");
//						testCase.log(Status.INFO, "But, Already Exits Validation is Confirmed");
//						testCase.log(Status.PASS, "Add Role Function is Pass");
//						testCase.log(Status.INFO, "Already Exits Validation Throwing");
//						testCase.log(Status.INFO, "But, Already Exits Validation Not Confirmed");
						testCase.log(Status.PASS, "Edit Role Function is Pass");
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

}
