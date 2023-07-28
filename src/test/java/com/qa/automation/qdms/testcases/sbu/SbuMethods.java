package com.qa.automation.qdms.testcases.sbu;

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
import com.qa.automation.qdms.pages.master.SbuPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class SbuMethods extends DriverIntialization {

	static DataFormatter dataValue = new DataFormatter();
	static SbuPage sbup = new SbuPage();
	static boolean checkValues = false;
	public static boolean clickAddButton = false;

//	MODIFIED BY : ARUNAN 13.03.2023
	public static void clickAddSbuBtn(String TestCase) {
		clickAddButton = false;
		PageFactory.initElements(driver, sbup);
		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOf(SbuPage.addSbuBtn));
		MultiSearchMethods.Button(SbuPage.addSbuBtn, "Add SBU");
		if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(SbuPage.addSbuBtn));
				SbuPage.addSbuBtn.click();
				clickAddButton = true;
			} catch (Exception e) {
				testCase = extent.createTest("Add Sbu Button Click");
				testCase.log(Status.INFO, "Add Sbu Button Clicked Fail");
				testCase.log(Status.FAIL, "Sbu Save Button not Visible, Button Clicked Fail");
			}
		}

		if (clickAddButton) {
//			testCase = extent.createTest("Add SBU Button Functionality");
//			try {
//				wait.until(ExpectedConditions.visibilityOf(sbupage.addSbuPopUp));
//Assert.assertEquals(sbupage.addSbuPopUp.isDisplayed(), true);
//testCase.log(Status.INFO, "Add SBU Pop Up Visible");
//testCase.log(Status.PASS, "So, Add SBU Button Functionality Pass");
//			} catch (AssertionError e) {
//				testCase.log(Status.INFO, "Add SBU Pop Up Not Visible");
//				testCase.log(Status.FAIL, "Add SBU Button Functionality Fail");
//			} catch (Exception e) {
//				testCase.log(Status.INFO, "Add SBU Pop Up Not Visible");
//				testCase.log(Status.FAIL, "Add SBU Button Functionality Fail");
//			}
		}
	}

	static String sbuName = "";
	static String SuccessMsg = "";
	static boolean inputValue = false;
	public static boolean clickSaveBtn = false;

	public static void inputSbuValue(String testcaseId, String tabName,String add) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		inputValue = false;
		clickSaveBtn = false;
		PageFactory.initElements(driver, sbup);
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
				SuccessMsg = "SubBusinessUnit Added Successfully";
				sbuName = "";
				sbuName = dataValue.formatCellValue(row.getCell(1));
				String des = dataValue.formatCellValue(row.getCell(2));

//					MultiSearchMethods.Buttons(SbuPage.addSbuBtn, "Add SBU Button");
				SbuMethods.clickAddSbuBtn("Add SBU Button Click");

				if (clickAddButton) {
					MultiSearchMethods.textBox(SbuPage.sbuTextField, " Sbu TextBox");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						SbuPage.sbuTextField.sendKeys(sbuName);
					}
					MultiSearchMethods.textBox(SbuPage.sbuDesTextField,  " Description TextBox");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						SbuPage.sbuDesTextField.sendKeys(des);
					}
					inputValue = true;
				}
				clickSaveBtn = false;
				if (inputValue) {
					MultiSearchMethods.Button(SbuPage.sbuSaveBtn,  " Sbu Save ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						wait.until(ExpectedConditions.elementToBeClickable(SbuPage.sbuSaveBtn));
						SbuPage.sbuSaveBtn.click();
						clickSaveBtn = true;
					}
				}
				if (SbuMethods.clickSaveBtn) {
					SbuMethods.addedValueCheck(add);
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
		PageFactory.initElements(driver, sbup);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		boolean sbuSaveBtnVisible = false;
		try {
//		wait.until(ExpectedConditions.invisibilityOf(SbuPage.addSbuBtn));
			Thread.sleep(1000);
			Assert.assertEquals(SbuPage.sbuSaveBtn.isDisplayed(), true);
			sbuSaveBtnVisible = true;
		} catch (AssertionError e) {
			sbuSaveBtnVisible = false;
		} catch (Exception e) {
			sbuSaveBtnVisible = false;
		}
		if (sbuSaveBtnVisible) {
			try {
				wait.until(ExpectedConditions.visibilityOf(SbuPage.sbuValidations));
				validation = SbuPage.sbuValidations.getText();
				if (validation == "") {
					wait.until(ExpectedConditions.visibilityOf(SbuPage.descValidations));
					validation = SbuPage.descValidations.getText();
				}
				vali = true;
			} catch (Exception e) {
				vali = false;
			}

			if (vali) {
				validation(sbuName);
				if(add.contains("add")) {
				testCase = extent.createTest("Add Sbu Function");
				if (exit) {
					testCase.log(Status.INFO, "Validation Throwing");
					testCase.log(Status.INFO, "But, Throwing Validation Not Confirmed");
					testCase.log(Status.FAIL, "Add Sbu Function is Fail");
				} 
				} else if (add.contains("validation")) {
					
//					testCase = extent.createTest("Add Sbu Function");
//					if (exit) {
//						testCase.log(Status.INFO, "Validation Throwing");
//						testCase.log(Status.INFO, "But, Throwing Validation is Confirmed");
//						testCase.log(Status.PASS, "Add Sbu Function is Pass");
//					} 	else {
//					testCase.log(Status.INFO, "Validation Throwing");
//					testCase.log(Status.INFO, "But, Throwing Validation Not Confirmed");
//					testCase.log(Status.FAIL, "Add Sbu Function is Fail");
//				}
				}
			}
		} else {
			boolean success = false;
			testCase = extent.createTest("SBU :- " + sbuName + " - Adding Success Message");
			try {
				Assert.assertEquals(SbuPage.successMessages.getText(), SuccessMsg);
				testCase.log(Status.INFO, "Actual Success Message :- " + SbuPage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
				testCase.log(Status.PASS, "Success Message  Matching, So Throwing Success Message Pass");
				success = true;
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Success Message :- " + SbuPage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
				testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
			} catch (Exception e) {
				testCase.log(Status.INFO, "Actual Success Message :- " + SbuPage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
				testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
			}

			boolean firstRow = false;
			testCase = extent.createTest("SBU :- " + sbuName + " - Added Value Check In First Row");

			try {
				Assert.assertEquals(SbuPage.firstRowData.getText(), sbuName);
				testCase.log(Status.INFO, "SBU :- " + sbuName + " Added Check in First Row");
				testCase.log(Status.INFO, "Added Value Founded In First Row");
				testCase.log(Status.PASS, "So, Add SBU Script Pass");
				firstRow = true;
			} catch (Exception e) {
				testCase.log(Status.INFO, "SBU :- " + sbuName + " Added Check in First Row");
				testCase.log(Status.INFO, "Added Value Not Founded In First Row");
				testCase.log(Status.FAIL, "So, Add SBU Script Fail");
			}

			if (success) {

				try {
					SbuPage.successMessageCloseBtn.click();
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
								driver.findElements(By.xpath("//td[1][text()='" + sbuName + "']"))));
						x = driver.findElements(By.xpath("//td[1][text()='" + sbuName + "']")).size();
					} catch (Exception e) {
						e.printStackTrace();
					}
					counts = counts + x;
					try {
						enable = SbuPage.NextPageBtn.isEnabled();
//		Click Next page Button
						if (enable) {

							SbuPage.NextPageBtn.click();
//							wai.until(
//									ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//tr"))));
						}
					} catch (Exception e) {

					}

				}

				testCase = extent.createTest("SBU :- " + sbuName + " - Added Value Check In SBU Table");
				if (counts == 1) {
					testCase.log(Status.INFO, "SBU :- " + sbuName + " Added Check in SBU Table");
					testCase.log(Status.INFO, "Added Value Founded In SBU Table");
					testCase.log(Status.PASS, "So, Add SBU Script Pass");
				} else {
					testCase.log(Status.INFO, "SBU :- " + sbuName + " Added Check in SBU Table");
					testCase.log(Status.INFO, "Added Value Duplicate In SBU Table");
					testCase.log(Status.FAIL, "So, Add SBU Script Fail");
				}
			}
			driver.navigate().refresh();
		}

	}

	public static boolean logout = false;

	public static void navigateSbu(String testcase) {
		logout = false;
		SbuPage sp = new SbuPage();
		PageFactory.initElements(driver, sp);

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
			MasterMainNavigationsTest.navigatePlantMain();
		}
		if (MasterMainNavigationsTest.clickPlantMain) {
			MasterMainNavigationsTest.navigateSbu();
		}
	}

	public static void logout() {
		if (SbuMethods.logout) {
			MultiSearchMethods.Logout();
		}
	}

	static String validation = "";
	static boolean vali = false;
	static String sbu = "";
	static String descr = "";
	static String sbuVal = "";
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
				sbu = dataValue.formatCellValue(row.getCell(1));
				descr = dataValue.formatCellValue(row.getCell(2));
				sbuVal = dataValue.formatCellValue(row.getCell(3));
				descVal = dataValue.formatCellValue(row.getCell(4));

				SbuMethods.clickAddSbuBtn("Add SBU Button Click");

				if (clickAddButton) {
					MultiSearchMethods.textBox(SbuPage.sbuTextField, " Sbu TextBox");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						SbuPage.sbuTextField.clear();
						SbuPage.sbuTextField.sendKeys(sbu);
					}
					MultiSearchMethods.textBox(SbuPage.sbuDesTextField, " Description TextBox");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						SbuPage.sbuDesTextField.clear();
						SbuPage.sbuDesTextField.sendKeys(descr);
					}
					inputValue = true;
				}
				clickSaveBtn = false;
				if (inputValue) {
					MultiSearchMethods.Button(SbuPage.sbuSaveBtn, " Sbu Save ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						WebDriverWait wait = new WebDriverWait(driver, 20);
						wait.until(ExpectedConditions.elementToBeClickable(SbuPage.sbuSaveBtn));
						SbuPage.sbuSaveBtn.click();
						clickSaveBtn = true;
					}
				}
				boolean sbuSaveBtnVisible = false;
				if (SbuMethods.clickSaveBtn) {
					sbuSaveBtnVisible = false;
					try {
						Thread.sleep(1000);
						Assert.assertEquals(SbuPage.sbuSaveBtn.isDisplayed(), true);
						sbuSaveBtnVisible = true;
					} catch (AssertionError e) {
						sbuSaveBtnVisible = false;
					} catch (Exception e) {
						sbuSaveBtnVisible = false;
					}
				}
				if (sbuSaveBtnVisible) {

					validation = "";
					vali = false;
					try {
						WebDriverWait wait = new WebDriverWait(driver, 5);
						wait.until(ExpectedConditions.visibilityOf(SbuPage.sbuValidations));
						validation = SbuPage.sbuValidations.getText();
						if (validation == "") {
							wait.until(ExpectedConditions.visibilityOf(SbuPage.descValidations));
							validation = SbuPage.descValidations.getText();
						}
						vali = true;
					} catch (Exception e) {
						vali = false;
					}

					validation(sbuName);
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

	public static void validation(String sbu) {

		if (validation.contains("Sub Business Unit can't be empty")) {
			testCase = extent.createTest("Empty Validation Throwing");
			try {
				String val = SbuPage.sbuTextField.getAttribute("value");
				testCase = extent.createTest("Empty Validation Confirmation For SBU :- " + sbu);
				if (val == "") {
					exit = false;
					testCase.log(Status.INFO, "SBU Data is :- " + val);
					testCase.log(Status.INFO, "SBU Data is Empty");
					testCase.log(Status.PASS, "So, Empty Validation Correct");
					exit = true;
				} else {
					testCase.log(Status.INFO, "SBU Data is :- " + val);
					testCase.log(Status.INFO, "SBU Data is not Empty");
					testCase.log(Status.PASS, "So, Empty Validation Wrong");

				}
			} catch (Exception e) {

			}
			driver.navigate().refresh();
		} else if (validation.contains("SBU already exists")) {
			testCase = extent.createTest("Already Exists Validation Throwing For SBU :- " + sbu);
			driver.navigate().refresh();
			boolean checkValue = false;

			boolean enable = true;
			while (enable) {

				int x = 0;
				try {
					WebDriverWait wai = new WebDriverWait(driver, 5);
					wai.until(ExpectedConditions.visibilityOfAllElements(
							driver.findElements(By.xpath("//td[1][text()='" + sbu + "']"))));
					x = driver.findElements(By.xpath("//td[1][text()='" + sbu + "']")).size();
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (x == 1) {
					checkValue = true;
					break;
				}
				try {
					enable = SbuPage.NextPageBtn.isEnabled();
//		Click Next page Button
					if (enable) {

						SbuPage.NextPageBtn.click();
//						WebDriverWait wait = new WebDriverWait(driver, 20);
//						wait.until(ExpectedConditions
//								.visibilityOfAllElements(driver.findElements(By.xpath("//tr"))));
					}
				} catch (Exception e) {

				}

			}
			testCase = extent.createTest("Already Exists Validation Confirmation For SBU :- " + sbu);
			if (checkValue) {
				exit = false;
				testCase.log(Status.INFO, "SBU :- " + sbu + " Already Exits in SBU Table");
				testCase.log(Status.INFO, "SBU :- " + sbu + " Founded In SBU Table");
				testCase.log(Status.PASS, "So, Already Exists Validation Correct");
				exit = true;
			} else {
				testCase.log(Status.INFO, "SBU :- " + sbu + " Not in SBU Table");
				testCase.log(Status.INFO, "Added Value Not Founded In SBU Table");
				testCase.log(Status.FAIL, "So, System  Fail");
			}

		} else if (validation.contains("Only 3 characters long!")) {
			testCase = extent.createTest("Added Data Lenth Not Match Validation Throwing");

			try {
				String val = SbuPage.sbuTextField.getAttribute("value");
				int length = val.length();
				testCase = extent.createTest("Lenth Not Match Validation Confirmation For SBU :- " + sbuName);
				if (length <= 3) {
					exit = false;
					testCase.log(Status.INFO, "SBU Lenth is:- " + length);
					testCase.log(Status.INFO, "SBU Lenth is grater than 3");
					testCase.log(Status.PASS, "So, Lenth Not Match Validation Correct");
					exit = true;
				} else {
					testCase.log(Status.INFO, "SBU Lenth is:- " + length);
					testCase.log(Status.PASS, "So, Lenth Not Match Validation Wrong");

				}
			} catch (Exception e) {

			}

			driver.navigate().refresh();
		} else if (validation.contains("Sub Business Unit allow only letters")) {
			testCase = extent.createTest("Wrong Characters Validation Throwing");

			try {
				String val = SbuPage.sbuTextField.getAttribute("value");
				boolean result = areAllLetters(val);
				testCase = extent.createTest("Wrong Characters Validation Confirmation For SBU :- " + sbu);
				if (result == false) {
					exit = false;
					testCase.log(Status.INFO, "SBU Name is:- " + val);
					testCase.log(Status.INFO, "SBU Having Correct Format Letters");
					testCase.log(Status.PASS, "So, Wrong Characters Validation Correct");
					exit = true;
				} else {
					testCase.log(Status.INFO, "SBU Name is:- " + val);
					testCase.log(Status.INFO, "SBU Having Wrong Format Letters");
					testCase.log(Status.PASS, "So, LWrong Characters Validation Wrong");

				}
			} catch (Exception e) {

			}
			driver.navigate().refresh();
		} else {
			testCase = extent.createTest("Any Validation Not Throwing");
			testCase.log(Status.INFO, "SBU Added Fail");
			testCase.log(Status.FAIL, "Validation Not Throwing, So SBU Added Fail");
			driver.navigate().refresh();
		}
	}

	public static boolean areAllLetters(String word) {
		return word.matches("[a-zA-Z]+");
	}

	public static void editSbu(String excelName, String tabName, String testCaseId) {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + excelName + ".xlsx";
		int firstrow = CommonMethods.getFirstRowNum(excelPath, tabName, testCaseId);
		int lastrow = CommonMethods.getLastRowNum(excelPath, tabName, testCaseId);
		try {
			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(tabName);
			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);
				String editsbu = dataValue.formatCellValue(row.getCell(1));
				String editdes = dataValue.formatCellValue(row.getCell(2));
				String newsbu = dataValue.formatCellValue(row.getCell(3));
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
						WebElement sbu = driver.findElement(By.xpath("//tbody/tr[" + k + "]/td[1]"));
						String sbuName = sbu.getText();
						System.out.println(sbuName + " " + editsbu);
						if (sbuName.contentEquals(editsbu)) {
							WebElement editElement = driver.findElement(
									By.xpath("//td[text()='" + editsbu + "']/following-sibling::td[2]/span/a[1]"));
							MultiSearchMethods.icon(editElement, editsbu + " Edit ");
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
						next = SbuPage.NextPageBtn.isEnabled();
						if (next) {
							SbuPage.NextPageBtn.click();
							Thread.sleep(1000);
						}
					} catch (Exception e) {
					}
				}
				if (check == false) {
					testCase = extent.createTest("Searched Element Not There");
					testCase.log(Status.INFO, "Searched data : " + editsbu);
					testCase.log(Status.FAIL, "Searched Data Not In WebTable");
				}
				boolean save = false;
				boolean input = false;
				if (check) {

					MultiSearchMethods.textBox(SbuPage.sbuTextField, "SBU ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						Thread.sleep(1000);
						testCase = extent.createTest("Sub Business Unit Data Confirm Before Edit");
						try {
							Assert.assertEquals(SbuPage.sbuTextField.getAttribute("value"), editsbu);
							testCase.log(Status.INFO,
									"SBU Field Actual Data : " + SbuPage.sbuTextField.getAttribute("value"));
							testCase.log(Status.INFO, "SBU Field Expected Data : " + editsbu);
							testCase.log(Status.PASS, "Expected and Actual are matching, So Pass");
						} catch (AssertionError e) {
							testCase.log(Status.INFO,
									"SBU Field Actual Data : " + SbuPage.sbuTextField.getAttribute("value"));
							testCase.log(Status.INFO, "SBU Field Expected Data : " + editsbu);
							testCase.log(Status.FAIL, "Expected and Actual are not matching, So Fail");
						} catch (Exception e) {
							testCase.log(Status.INFO,
									"SBU Field Actual Data : " + SbuPage.sbuTextField.getAttribute("value"));
							testCase.log(Status.INFO, "SBU Field Expected Data : " + editsbu);
							testCase.log(Status.FAIL, "Expected and Actual are not matching, So Fail");
						}
						SbuPage.sbuTextField.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
						SbuPage.sbuTextField.sendKeys(newsbu);
						input = true;
					}

					MultiSearchMethods.textBox(SbuPage.sbuDesTextField, "Description ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						Thread.sleep(1000);
						testCase = extent.createTest("Description Data Confirm Before Edit");
						try {
							Assert.assertEquals(SbuPage.sbuDesTextField.getAttribute("value"), editdes);
							testCase.log(Status.INFO,
									"SBU Field Actual Data : " + SbuPage.sbuDesTextField.getAttribute("value"));
							testCase.log(Status.INFO, "SBU Field Expected Data : " + editdes);
							testCase.log(Status.PASS, "Expected and Actual are matching, So Pass");
						} catch (AssertionError e) {
							testCase.log(Status.INFO,
									"SBU Field Actual Data : " + SbuPage.sbuDesTextField.getAttribute("value"));
							testCase.log(Status.INFO, "SBU Field Expected Data : " + editdes);
							testCase.log(Status.FAIL, "Expected and Actual are not matching, So Fail");
						} catch (Exception e) {
							testCase.log(Status.INFO,
									"SBU Field Actual Data : " + SbuPage.sbuDesTextField.getAttribute("value"));
							testCase.log(Status.INFO, "SBU Field Expected Data : " + editdes);
							testCase.log(Status.FAIL, "Expected and Actual are not matching, So Fail");
						}
						SbuPage.sbuDesTextField.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
						SbuPage.sbuDesTextField.sendKeys(newdes);
						input = true;
					}

					if (input) {
						MultiSearchMethods.Button(SbuPage.sbuUpdateBtn, "SBU Update");
						if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
							WebDriverWait wait = new WebDriverWait(driver, 10);
							wait.until(ExpectedConditions.elementToBeClickable(SbuPage.sbuUpdateBtn));
							SbuPage.sbuUpdateBtn.click();
							save = true;
						}
					}
				}
				boolean saveCheck = false;
				if (save) {
					try {
						Thread.sleep(500);
						Assert.assertEquals(SbuPage.sbuUpdateBtn.isDisplayed(), true);
						saveCheck = true;
					} catch (Exception e) {
						saveCheck = false;
					} catch (AssertionError e) {
						saveCheck = false;
					}
				}

				if (saveCheck) {
					validation = SbuPage.sbuValidations.getText();
					validation(newsbu);
					testCase = extent.createTest("Update Sbu Function");
					if (exit) {
//						testCase.log(Status.INFO, "Already Exits Validation Throwing");
//						testCase.log(Status.INFO, "But, Already Exits Validation is Confirmed");
//						testCase.log(Status.PASS, "Add Sbu Function is Pass");
						testCase.log(Status.INFO, "Already Exits Validation Throwing");
						testCase.log(Status.INFO, "But, Already Exits Validation Not Confirmed");
						testCase.log(Status.FAIL, "Add Sbu Function is Fail");
					} 
//					else {
//						testCase.log(Status.INFO, "Already Exits Validation Throwing");
//						testCase.log(Status.INFO, "But, Already Exits Validation Not Confirmed");
//						testCase.log(Status.FAIL, "Add Sbu Function is Fail");
//					}
				} else {
					String updateSuccessMsg = "SubBusinessUnit Updated Successfully";
					testCase = extent.createTest("SBU :- " + sbuName + " - Updating Success Message");
					try {
						Assert.assertEquals(SbuPage.successMessages.getText(), updateSuccessMsg);
						testCase.log(Status.INFO, "Actual Success Message :- " + SbuPage.successMessages.getText());
						testCase.log(Status.INFO, "Expected Success Message :- " + updateSuccessMsg);
						testCase.log(Status.PASS, "Success Message  Matching, So Throwing Success Message Pass");
						try {
							SbuPage.successMessageCloseBtn.click();
						} catch (Exception e) {
							// TODO: handle exception
						}
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "Actual Success Message :- " + SbuPage.successMessages.getText());
						testCase.log(Status.INFO, "Expected Success Message :- " + updateSuccessMsg);
						testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
					} catch (Exception e) {
						testCase.log(Status.INFO, "Actual Success Message :- " + SbuPage.successMessages.getText());
						testCase.log(Status.INFO, "Expected Success Message :- " + updateSuccessMsg);
						testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
					}

					testCase = extent.createTest("SBU :- " + sbuName + " - Updated Value Check In First Row");

					try {
						Assert.assertEquals(SbuPage.firstRowData.getText(), newsbu);
						testCase.log(Status.INFO, "SBU :- " + newsbu + " Updated Check in First Row");
						testCase.log(Status.INFO, "Added Value Founded In First Row");
						testCase.log(Status.PASS, "So, Add SBU Script Pass");

					} catch (Exception e) {
						testCase.log(Status.INFO, "SBU :- " + newsbu + " Updated Check in First Row");
						testCase.log(Status.INFO, "Added Value Not Founded In First Row");
						testCase.log(Status.FAIL, "So, Add SBU Script Fail");
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
	public static void report(String name,String Valida) {
		testCase=extent.createTest(name+" Validation Throwing");
		testCase.log(Status.INFO, name+"Validation : "+Valida);
		testCase.log(Status.PASS, "Validation Throwing");
	}
}
