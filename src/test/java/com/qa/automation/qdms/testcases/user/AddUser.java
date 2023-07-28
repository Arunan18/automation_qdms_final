/***********************************************************************************
* Description
*------------
* USER EDIT ROLE ALLOCATION
***********************************************************************************
*
* Author           : Arunan
* Date Written     : 01/03/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-USER-0065     	26/07/2023   Arun     Orginal Version
*TC-USER-0071
*TC-USER-0072
*TC-USER-0089
*TC-USER-0090
*TC-USER-0094
*TC-USER-0102
*TC-USER-0106
*TC-USER-0107
*TC-USER-0081
*
************************************************************************************/
package com.qa.automation.qdms.testcases.user;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.UserPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class AddUser extends DriverIntialization {
	static UserPage up = new UserPage();

	@Test
	public static void addUser() throws IOException, InterruptedException {
		PageFactory.initElements(driver, up);
		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateEmployeeMain();
		}

		if (MasterMainNavigationsTest.clickEmployeeMain) {
			MasterMainNavigationsTest.navigateUser();
		}
		if (MasterMainNavigationsTest.clickUser) {
			dataMove("individual", "priyankamoorthy29+10@gmail.com,sarunan156@gmail.com,kajan28296+35@gmail.com", "",
					excelDataValue);
		}

//		MultiSearchMethods.Logout();
	}

	static boolean addUserClick = false;
	static DataFormatter datavalue = new DataFormatter();
	static String excelbook = "Master Module";
	static String exceltab = "User";
	static String testid = "TC-USER-0112";
	static DataFormatter dataValue = new DataFormatter();
	static boolean nullPoint = false;
	static String commonCondition = null;
	static String[] array = null;
	static int z = 0;
	static String[] array1 = null;
	public static ArrayList<String> excelDataValue = new ArrayList<String>();

	public static void dataMove(String test, String TestData, String common, ArrayList<String> datass)
			throws IOException {
		try {
		String filelocation = "./src/test/resources/Excel/" + excelbook + ".xlsx";
		System.out.println(testid + "ttttttttttttttttttttt");
		int firstrow = CommonMethods.getFirstRowNum(filelocation, exceltab, testid);
		int lastrow = CommonMethods.getLastRowNum(filelocation, exceltab, testid);
		System.out.println(firstrow + "ffffffff");
		System.out.println(lastrow + "llllllllllllll");

		FileInputStream file = new FileInputStream(filelocation);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(exceltab);
		XSSFRow rows = sheet.getRow(firstrow);
		for (int k = 6; k <= 20; k++) {
			try {
				commonCondition = dataValue.formatCellValue(rows.getCell(k));
				String condition = dataValue.formatCellValue(rows.getCell(k + 1));
				excelDataValue.add(commonCondition);
			} catch (NullPointerException e) {
				nullPoint = true;
				break;
			}
			if (commonCondition.isEmpty()) {
				nullPoint = true;
				break;
			}
			if (nullPoint) {
				break;
			}
		}
		for (int n = firstrow; n <= firstrow; n++) {
			XSSFRow row = sheet.getRow(n);

			String usertpe = dataValue.formatCellValue(row.getCell(1));
			String plant = dataValue.formatCellValue(row.getCell(2));
			String plantusertype = dataValue.formatCellValue(row.getCell(3));
			String selecttype = dataValue.formatCellValue(row.getCell(4));
			String gmail = dataValue.formatCellValue(row.getCell(5));

			addUserClick = false;
			MultiSearchMethods.Button(UserPage.addUser, "Add User");
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
				UserPage.addUser.click();
				addUserClick = true;
			}

			if (addUserClick) {
				try {
					WebElement usertype = driver.findElement(
							By.xpath("//div[@class='ant-modal-body']//div[@class='ant-switch-handle']/../span"));
					Thread.sleep(500);
					String userty = usertype.getText();
					System.out.println(userty + "::::::::::::");
					if (!userty.toUpperCase().equals(usertpe.toUpperCase())) {

						WebElement usert = driver.findElement(By
								.xpath("//div[@class='ant-modal-body']//div[@class='ant-switch-handle']/../../button"));
						usert.click();
					}
				} catch (Exception e) {
				}
			}

			if (usertpe.toUpperCase().equals("INDIVIDUAL")) {
				materialMethodes.dropdown(driver.findElement(By.xpath("//span[text()='Select Plant']/../span")), plant,
						"//div[@class='ant-select-item-option-content']/span[text()='", "']", "plant");
			}

			if (materialMethodes.select) {
				materialMethodes.dropdown(driver.findElement(By.xpath("//span[text()='Select the Type']/../span")),
						plantusertype, "//div[@class='ant-select-item-option-content'][text()='", "']",
						"plant user type");
			}
			if (materialMethodes.select) {
				select(selecttype, gmail, usertpe, datass);
			}

			if (usertpe.toUpperCase().equals("COMMON")) {
				select(selecttype, gmail, usertpe, datass);
			}

		}
		} catch (Exception e) {
			driver.navigate().refresh();
			testCase = extent.createTest("Excel File Not Found");
			testCase.log(Status.INFO, "Excel File Not Found");
			testCase.log(Status.FAIL, "Excel File Not Found, So fail");
		}
	}

	public static void select(String test, String TestData, String common, ArrayList<String> datass) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		if (test.contentEquals("all")) {

			boolean select = false;

			MultiSearchMethods.Button(UserPage.rightCheckBox, "Check Box all");
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
				UserPage.rightCheckBoxInput.click();
				select = true;
			}

			boolean right = false;
			if (select) {
				try {
					MultiSearchMethods.Button(UserPage.goToRightBtn, "Go to Right Button");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						UserPage.goToRight.click();
						right = true;
					}
				} catch (Exception e) {
					testCase = extent.createTest("Go to Right Button");
					testCase.log(Status.INFO, "Go to Right Button Not There");
					testCase.log(Status.FAIL, "So, Fail");
				}
			}
			if (right) {
				testCase = extent.createTest("Confirmation to All Data Move to Right Side");
				try {
					Assert.assertEquals(UserPage.leftNodata.getText(), "No Data");
					testCase.log(Status.INFO, "All Datas Move to Right Side");
					testCase.log(Status.PASS, "So Pass");
				} catch (Exception e) {
					testCase.log(Status.INFO, "All Datas Not Move to Right Side");
					testCase.log(Status.FAIL, "So Fail");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "All Datas Not Move to Right Side");
					testCase.log(Status.FAIL, "So Fail");
				}
			}
		} else if (test.contentEquals("user")) {

			boolean select = false;

			MultiSearchMethods.Button(UserPage.rightUserCheckBox, "Check Box all");
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
				UserPage.rightUserCheckBoxInput.click();
				select = true;

			}
			boolean right = false;
			if (select) {
				try {
					MultiSearchMethods.Button(UserPage.goToRightBtn, "Go to Right Button");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						UserPage.goToRight.click();
						right = true;
					}
				} catch (Exception e) {
					testCase = extent.createTest("Go to Right Button");
					testCase.log(Status.INFO, "Go to Right Button Not There");
					testCase.log(Status.FAIL, "So, Fail");
				}
			}
			if (right) {
				int x = 0;
				int count = 0;
				boolean next = true;
				while (next) {
					int m = 0;
					try {
						Thread.sleep(1500);
						m = driver.findElements(By.xpath("(//tbody)[3]/tr/td[2][contains(@class,'ant-table-cell')]"))
								.size();
					} catch (Exception e) {
//						m = 10;
					}
					count = count + m;
					try {
						next = driver.findElement(By.xpath(
								"//div[contains(@class,'ant-transfer-customize-list')]/div[3]//li[@title='Next Page']/button"))
								.isEnabled();
						if (next) {
							wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
									"//div[contains(@class,'ant-transfer-customize-list')]/div[3]//li[@title='Next Page']/button"))));
							driver.findElement(By.xpath(
									"//div[contains(@class,'ant-transfer-customize-list')]/div[3]//li[@title='Next Page']/button"))
									.click();
						}
					} catch (Exception e) {
						break;
					}
				}
				boolean confirm = false;
				System.out.println(count + " 555555555");
				if (count == 10) {
					confirm = true;
				}
				testCase = extent.createTest("Confirmation to All Data Move to Right Side");
				if (confirm) {
					testCase.log(Status.INFO, "10 Datas Move to Right Side");
					testCase.log(Status.PASS, "So Pass");
				} else {
					testCase.log(Status.INFO, "10 Datas Not Move to Right Side");
					testCase.log(Status.FAIL, "So Fail");
				}
			}
		} else if (test.contentEquals("employee")) {

		} else if (test.contentEquals("select-all")) {

		} else if (test.contentEquals("current-page")) {

		} else {

			String[] user = TestData.split(",");
			System.out.println(TestData + "!!!!!!!!!!!!!!");
			System.out.println(user.length + "!!!!!!!!!!!!!!");
			boolean next = true;

			boolean check = false;
			int le = 0;
			while (next) {
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.PAGE_UP).perform();
				int m = 0;
				try {
					m = driver.findElements(By.xpath("(//tbody)[2]/tr/td[2][contains(@class,'ant-table-cell')]"))
							.size();
				} catch (Exception e) {
					m = 10;
				}
				for (int j = 0; j < user.length; j++) {
					for (int k = 1; k <= m; k++) {
						String email = "";
						try {
							Thread.sleep(200);
							email = driver.findElement(By.xpath("(//tbody)[2]/tr[" + k + "]/td[2]")).getText();
						} catch (Exception e) {
						}
						if (email.contentEquals(user[j])) {
							MultiSearchMethods.Button(
									driver.findElement(By.xpath("(//tbody)[2]/tr[" + k + "]/td[1]//input//..")),
									"Check Box");
							if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
								try {
									Thread.sleep(100);
									driver.findElement(By.xpath("(//tbody)[2]/tr[" + k + "]/td[1]//input")).click();
								} catch (Exception e) {
								}
								k = 1;
								le = le + 1;
								break;
							}
						}
					}
					if (user.length == le) {
						check = true;
						break;
					}
				}
				if (check) {
					break;
				}
				actions.sendKeys(Keys.PAGE_DOWN).perform();
				actions.sendKeys(Keys.PAGE_DOWN).perform();
				try {
					next = driver.findElement(By.xpath(
							"//div[contains(@class,'ant-transfer-customize-list')]/div[1]//li[@title='Next Page']/button"))
							.isEnabled();
					if (next) {
						Thread.sleep(1000);
						driver.findElement(By.xpath(
								"//div[contains(@class,'ant-transfer-customize-list')]/div[1]//li[@title='Next Page']/button"))
								.click();
					}
				} catch (Exception e) {
//						break;
				}
			}
			boolean right = false;
			if (check) {
				try {
					MultiSearchMethods.Button(UserPage.goToRightBtn, "Go to Right Button");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						UserPage.goToRight.click();
						right = true;
					}
				} catch (Exception e) {
					testCase = extent.createTest("Go to Right Button");
					testCase.log(Status.INFO, "Go to Right Button Not There");
					testCase.log(Status.FAIL, "So, Fail");
				}
			}
			boolean checked = false;
			if (right) {
				int le1 = 0;
				boolean nedxtt = false;
				while (next) {
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.PAGE_UP).perform();
					int m = 0;
					try {
						m = driver.findElements(By.xpath("(//tbody)[3]/tr/td[2][contains(@class,'ant-table-cell')]"))
								.size();
					} catch (Exception e) {
						m = 10;
					}
					for (int j = 0; j < user.length; j++) {
						for (int k = 1; k <= m; k++) {
							String email = "";
							try {
								Thread.sleep(200);
								email = driver.findElement(By.xpath("(//tbody)[3]/tr[" + k + "]/td[2]")).getText();
							} catch (Exception e) {
							}
							if (email.contentEquals(user[j])) {
								k = 1;
								le1 = le1 + 1;
								break;

							}
						}
						if (user.length == le1) {
							checked = true;
							break;
						}
					}
					if (checked) {
						break;
					}
					actions.sendKeys(Keys.PAGE_DOWN).perform();
					try {
						nedxtt = driver.findElement(By.xpath(
								"//div[contains(@class,'ant-transfer-customize-list')]/div[1]//li[@title='Next Page']/button"))
								.isEnabled();
						if (nedxtt) {
							driver.findElement(By.xpath(
									"//div[contains(@class,'ant-transfer-customize-list')]/div[1]//li[@title='Next Page']/button"))
									.click();
						}
					} catch (Exception e) {
						break;
					}
				}
			}
			testCase = extent.createTest("Confirmation to send to Right Value");
			if (checked) {
				testCase.log(Status.INFO, "All Datas Having in Right Side");
				testCase.log(Status.PASS, "So Pass");
			} else {
				testCase.log(Status.INFO, "All Datas Dont Have in Right Side");
				testCase.log(Status.FAIL, "So Fail");
			}

			if (checked) {
				if (common.toUpperCase().contentEquals("common".toUpperCase())) {
					System.out.println(datass);
					boolean nextBtn = true;
					while (nextBtn) {
						int rawCount = 0;
						try {
							Thread.sleep(1000);
							rawCount = driver.findElements(By.xpath(
									"//div[contains(@class,'ant-transfer-customize-list')]/div[3]//tr[contains(@class,'ant-table-row')]"))
									.size();
						} catch (Exception e) {
							rawCount = 10;
						}
						for (int h = 0; h < datass.size() - 1; h++) {
							System.out.println(datass.get(h));
							String rolle = datass.get(h);
							array = rolle.split(",");
							int d = 0;
//						 for (String value : array) {
//					            System.out.println(value);
//					        }
							z = array.length - 2;
							array1 = new String[z];
							System.out.println("z : " + z);
							;
							for (int a = 2; a < array.length; a++) {
								System.out.println(d + " " + array[a]);
								array1[d] = array[a];
								d = d + 1;
							}
							for (int l = 1; l <= rawCount; l++) {
								String email = "";
								try {
									Thread.sleep(500);
									WebElement ema = driver.findElement(By.xpath(
											"//div[contains(@class,'ant-transfer-customize-list')]/div[3]//tr[contains(@class,'ant-table-row')]["
													+ l + "]/td[2]"));
									email = ema.getText();
								} catch (Exception e) {
								}
								if (email.contentEquals(array[0])) {
									materialMethodes.dropdown(driver.findElement(By.xpath(
											"//div[contains(@class,'ant-transfer-customize-list')]/div[3]//tr[contains(@class,'ant-table-row')]["
													+ l + "]/td[3]/div/div/span[1]")),
											array[1], "(//div[@class='ant-select-item-option-content'][text()='",
											"'])[" + l + "]", "User Type");

									if (materialMethodes.select) {
										WebElement rol = null;
										try {
											rol = driver.findElement(By.xpath(
													"//div[contains(@class,'ant-transfer-customize-list')]/div[3]//tr[contains(@class,'ant-table-row')]["
															+ l + "]/td[4]//input"));
										} catch (Exception e) {
											// TODO: handle exception
										}
										selects(array1, rol);

									}
								}
							}
						}
						try {
							nextBtn = driver.findElement(By.xpath(
									"//div[contains(@class,'ant-transfer-customize-list')]/div[3]//li[@title='Next Page']/button"))
									.isEnabled();
							if (nextBtn) {
								driver.findElement(By.xpath(
										"//div[contains(@class,'ant-transfer-customize-list')]/div[3]//li[@title='Next Page']/button"))
										.click();
							}
						} catch (Exception e) {
							break;
						}
					}

					boolean save = false;
					if (checking) {
						MultiSearchMethods.Button(UserPage.saveBtns, "User Save ");
						if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
							UserPage.saveBtns.click();
							save = true;
						}
					}

					if (save) {
						String Success = "";
						try {
							wait.until(ExpectedConditions.visibilityOf(UserPage.successMessage));
							Success = UserPage.successMessage.getText();
						} catch (Exception e) {
							// TODO: handle exception
						}
						testCase = extent.createTest("User Add Success Message");
						try {
							Assert.assertEquals(Success, "User Added Successfully");
							testCase.log(Status.INFO, "Actual : " + Success);
							testCase.log(Status.INFO, "Expected : " + "User Added Successfully");
							testCase.log(Status.PASS, "Actual and Expected are matching, So Pass");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual : " + Success);
							testCase.log(Status.INFO, "Expected : " + "User Added Successfully");
							testCase.log(Status.FAIL, "Actual and Expected are Not matching, So Fail");
						} catch (Exception e) {
							testCase.log(Status.INFO, "Actual : " + Success);
							testCase.log(Status.INFO, "Expected : " + "User Added Successfully");
							testCase.log(Status.FAIL, "Actual and Expected are Not matching, So Fail");
						}

						String nodata = "";
						try {
							wait.until(ExpectedConditions.visibilityOf(UserPage.rightNodata));
							nodata = UserPage.rightNodata.getText();
						} catch (Exception e) {
							// TODO: handle exception
						}
						boolean val = false;
						testCase = extent.createTest("User Added Confirmation");
						try {
							Assert.assertEquals(nodata, "No Data");
							testCase.log(Status.INFO, "Dont have any data in Right Side");
							testCase.log(Status.PASS, "So Pass");
						} catch (Exception e) {
							val = true;
							testCase.log(Status.INFO, "have any data in Right Side");
							testCase.log(Status.FAIL, "So Fail");
						} catch (AssertionError e) {
							val = true;
							testCase.log(Status.INFO, "have any data in Right Side");
							testCase.log(Status.FAIL, "So Fail");
						}

						if (val) {
							testCase = extent.createTest("User Added Confirmation");
							try {
								Assert.assertEquals(UserPage.validation.getText(), "Field can't be empty");
								testCase.log(Status.INFO, "Role Field is Empty");
								testCase.log(Status.FAIL, "So Fail");
							} catch (Exception e) {
								testCase.log(Status.INFO, "Role Field is Empty");
								testCase.log(Status.FAIL, "So Fail");
							} catch (AssertionError e) {
								testCase.log(Status.INFO, "Role Field is Empty");
								testCase.log(Status.FAIL, "So Fail");
							}
						}
						driver.navigate().refresh();
					}
				} else if (common.toUpperCase().contentEquals("individual".toUpperCase())) {
					System.out.println(datass);

					for (int h = 0; h < datass.size() - 1; h++) {
						System.out.println(datass.get(h));
						String rolle = datass.get(h);
						array = rolle.split(",");
//						for (String value : array) {
//				            System.out.println(value);
//				        }

					}
					select(array);
					boolean save = false;
					if (checking) {
						MultiSearchMethods.Button(UserPage.saveBtns, "User Save ");
						if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
							UserPage.saveBtns.click();
							save = true;
						}
					}

					if (save) {
						String Success = "";
						try {
							wait.until(ExpectedConditions.visibilityOf(UserPage.successMessage));
							Success = UserPage.successMessage.getText();
						} catch (Exception e) {
							// TODO: handle exception
						}
						testCase = extent.createTest("User Add Success Message");
						try {
							Assert.assertEquals(Success, "User Added Successfully");
							testCase.log(Status.INFO, "Actual : " + Success);
							testCase.log(Status.INFO, "Expected : " + "User Added Successfully");
							testCase.log(Status.PASS, "Actual and Expected are matching, So Pass");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual : " + Success);
							testCase.log(Status.INFO, "Expected : " + "User Added Successfully");
							testCase.log(Status.FAIL, "Actual and Expected are Not matching, So Fail");
						} catch (Exception e) {
							testCase.log(Status.INFO, "Actual : " + Success);
							testCase.log(Status.INFO, "Expected : " + "User Added Successfully");
							testCase.log(Status.FAIL, "Actual and Expected are Not matching, So Fail");
						}

						String nodata = "";
						try {
							wait.until(ExpectedConditions.visibilityOf(UserPage.rightNodata));
							nodata = UserPage.rightNodata.getText();
						} catch (Exception e) {
							// TODO: handle exception
						}
						boolean val = false;
						testCase = extent.createTest("User Added Confirmation");
						try {
							Assert.assertEquals(nodata, "No Data");
							testCase.log(Status.INFO, "Dont have any data in Right Side");
							testCase.log(Status.PASS, "So Pass");
						} catch (Exception e) {
							val = true;
							testCase.log(Status.INFO, "have any data in Right Side");
							testCase.log(Status.FAIL, "So Fail");
						} catch (AssertionError e) {
							val = true;
							testCase.log(Status.INFO, "have any data in Right Side");
							testCase.log(Status.FAIL, "So Fail");
						}

						if (val) {
							testCase = extent.createTest("User Added Confirmation");
							try {
								Assert.assertEquals(UserPage.validation.getText(), "Field can't be empty");
								testCase.log(Status.INFO, "Role Field is Empty");
								testCase.log(Status.FAIL, "So Fail");
							} catch (Exception e) {
								testCase.log(Status.INFO, "Role Field is Empty");
								testCase.log(Status.FAIL, "So Fail");
							} catch (AssertionError e) {
								testCase.log(Status.INFO, "Role Field is Empty");
								testCase.log(Status.FAIL, "So Fail");
							}
						}
						driver.navigate().refresh();
					}
				}
			}

		}
	}

	static boolean checking = false;

	public static void select(String[] aa) {
		int count = 0;
//		WebElement plants = driver.findElement(By.id("customer_plant"));
		for (int n = 0; n < aa.length; n++) {
			UserPage.role.click();
			UserPage.role.clear();
			UserPage.role.sendKeys(aa[n], Keys.ENTER);
			checking = true;
//			try {
////				Thread.sleep(500);
//				Thread.sleep(2500);
//				UserPage.role.click();
////				Thread.sleep(500);
//				count = driver.findElements(By
//						.xpath("//div[@class='rc-virtual-list']//div[@class='ant-select-item ant-select-item-option']"))
//						.size();
//			} catch (Exception e1) {
//
//			}
//			if (count == 0) {
//				count = 9;
//			}
//			for (int m = 0; m < count; m++) {
//				System.out.println("//div[@class='rc-virtual-list-holder-inner']/div[" + m + "]/div");
//				WebElement mm = null;
//				check = false;
//				try {
//					mm = driver
//							.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[" + m + "]/div"));
//					check = true;
//				} catch (Exception e) {
//					check = false;
//				}
//				if (check) {
//					String nn = mm.getText();
//					if (nn.contentEquals(aa[n])) {
//						UserPage.role.sendKeys(Keys.ENTER);
//						break;
//					}
//				}
//			}
//
		}
	}

	public static void selects(String[] aa, WebElement role) {
		int count = 0;
//		WebElement plants = driver.findElement(By.id("customer_plant"));
		for (int n = 0; n < aa.length; n++) {
			role.click();
			role.clear();
			role.sendKeys(aa[n], Keys.ENTER);
			checking = true;
		}
	}

}
