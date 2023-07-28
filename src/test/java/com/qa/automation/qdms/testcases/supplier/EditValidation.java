//***********************************************************************************
//* Description
//*------------
//* Edit Supplier Functionality
//***********************************************************************************
//*
//* Author           : Arunan
//* Date Written     : 30/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*   TC-SUP-0075         25/07/2023   Arunan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.supplier;

import java.io.FileInputStream;
import java.io.IOException;

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
import com.qa.automation.qdms.pages.master.SupplierPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class EditValidation extends DriverIntialization {

	static SupplierPage SupplierPg = new SupplierPage();
	static DataFormatter dataValue = new DataFormatter();

	@Test

	public static void supplierEditFunction() throws InterruptedException, IOException {

		PageFactory.initElements(driver, SupplierPg);

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}
		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateSupplierMain();
		}
		if (MasterMainNavigationsTest.clickSuppliermain) {
			MasterMainNavigationsTest.navigateSupplier();
		}
		if (MasterMainNavigationsTest.supplierClick) {
			edit("Master Module", "Supplier", "TC-SUP-0075");
		}

		MultiSearchMethods.Logout();

	}

	public static void edit(String workBook, String tabName, String testcaseId) {
		boolean excel = false;
		boolean editClick = false;
		try {
			String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + workBook + ".xlsx";
			int firstrow = CommonMethods.getFirstRowNum(excelPath, tabName, testcaseId);
			int lastrow = CommonMethods.getLastRowNum(excelPath, tabName, testcaseId);
			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(tabName);
			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);
				String supplierCate = dataValue.formatCellValue(row.getCell(1));
				String supplier = dataValue.formatCellValue(row.getCell(2));
				String plant = dataValue.formatCellValue(row.getCell(3));
				String contactNo = dataValue.formatCellValue(row.getCell(4));
				String email = dataValue.formatCellValue(row.getCell(5));
				String address = dataValue.formatCellValue(row.getCell(6));
				String editSupplierCate = dataValue.formatCellValue(row.getCell(7));
				String editSupplier = dataValue.formatCellValue(row.getCell(8));
				String editPlant = dataValue.formatCellValue(row.getCell(9));
				String editContactNo = dataValue.formatCellValue(row.getCell(10));
				String editEmail = dataValue.formatCellValue(row.getCell(11));
				String editAddress = dataValue.formatCellValue(row.getCell(12));

				excel = true;
				String[] before = null;
				String[] after = null;
				try {
					before = supplierCate.split("\n");
					after = editSupplierCate.split("\n");
				} catch (Exception e) {
					// TODO: handle exception
				}
				if (excel) {

					boolean next = true;
					while (next) {
						WebDriverWait wait = new WebDriverWait(driver, 2);

						try {
							Thread.sleep(1000);
							System.out.println("//tr[td[1][text()='" + supplier + "'] and td[2][text()='" + plant
									+ "'] and  td[3][text()='" + email + "']  and td[4][text()='" + contactNo
									+ "']]//td[1]");
							java.util.List<WebElement> sbus = driver.findElements(By.xpath("//tr[td[1][text()='"
									+ supplier + "'] and td[2][text()='" + plant + "'] and  td[3][text()='" + email
									+ "']  and td[4][text()='" + contactNo + "']]//td[1]"));
							for (WebElement aa : sbus) {
								aa.getText();
								wait.until(ExpectedConditions.visibilityOf(aa));
								MultiSearchMethods.icon(aa, supplier + " Edit Icon");
								if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
									wait.until(ExpectedConditions.elementToBeClickable(
											driver.findElement(By.xpath("//tr[td[1][text()='" + supplier
													+ "'] and td[2][text()='" + plant + "'] and  td[3][text()='" + email
													+ "']  and td[4][text()='" + contactNo
													+ "']]//td[1]/following-sibling::td//span[contains(@class,'anticon-edit')]"))));
									driver.findElement(By.xpath("//tr[td[1][text()='" + supplier
											+ "'] and td[2][text()='" + plant + "'] and  td[3][text()='" + email
											+ "']  and td[4][text()='" + contactNo
											+ "']]//td[1]/following-sibling::td//span[contains(@class,'anticon-edit')]"))
											.click();
									editClick = true;
									break;
								}
							}
						} catch (Exception e) {
						}

						if (editClick) {
							break;
						}

						next = driver.findElement(By.xpath("//li[@title='Next Page']/button")).isEnabled();
//	        Click Next page Button
						if (next) {
							try {
								driver.findElement(By.xpath("//li[@title='Next Page']/button")).click();
							} catch (Exception e) {
								break;
							}
						}

					}
					if (editClick) {
						Thread.sleep(1000);
						materialMethodes.popupdatacompare(supplierCate + "," + supplier + "," + plant + "," + contactNo
								+ "," + email + "," + address);
					} else {
						testCase = extent.createTest("Dont Have Searched Element to Delete");
						testCase.log(Status.INFO, "Dont Have Searched Element");
						testCase.log(Status.FAIL, "So fail");
					}
					if (materialMethodes.edit) {
						materialMethodes.edit = false;
						int x = 0;
						boolean plan = false;
						for (int j = 0; j < before.length; j++) {

							for (int k = 0; k < after.length; k++) {
								if (before[j].contentEquals(after[k])) {
									x = x + 1;
								}
							}
						}
						if (before.length == x) {
							plan = true;
						}
//						MultiSearchMethods.textBox(SupplierPage.supplierCategorys, "Supplier Category");
//						if(MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						System.out.println(plan + " " + !plan);
						if (!plan == false) {
							for (int m = 0; m < before.length; m++) {
								SupplierPage.supplierCategorys.sendKeys(Keys.BACK_SPACE);
							}
							select(after);
							if (check) {
								MultiSearchMethods.checked = true;
							}
						}
//					}

						if (!supplier.contentEquals(editSupplier)) {
							MultiSearchMethods.textBoxData(SupplierPage.suppliew, "Supplier Name ", editSupplier);
						}

						if (!plant.contentEquals(editPlant)) {
//							MultiSearchMethods.textBox(SupplierPage.plants, "Plant");
//							if(MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
							selects(editPlant);
							if (check) {
								MultiSearchMethods.checked = true;
							}
//							}
						}

						if (!contactNo.contentEquals(editContactNo)) {
							MultiSearchMethods.textBoxData(SupplierPage.contact, "Contact Number", editContactNo);
						}

						if (!email.contentEquals(editEmail)) {
							MultiSearchMethods.textBoxData(SupplierPage.emails, "Email", editEmail);
						}

						if (!address.contentEquals(editAddress)) {
							MultiSearchMethods.textBoxData(SupplierPage.address, "Address", editAddress);
						}

					} else {
						testCase = extent.createTest("Compare Edit Datas ");
						testCase.log(Status.INFO, "Given Data Matched");
						testCase.log(Status.FAIL, "So Fail");
					}
				}

				if (MultiSearchMethods.checked) {
					materialMethodes.popupdatacompare(editSupplierCate + "," + editSupplier + "," + editPlant + ","
							+ editContactNo + "," + editEmail + "," + editAddress);
				}
				boolean update = false;
				if (materialMethodes.edit) {
					MultiSearchMethods.Button(SupplierPage.updateBtns, "Supplier Update");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						MultiSearchMethods.elementClick(SupplierPage.updateBtns);
						update = true;
					}
				}
				boolean updateBtnVisi = false;
				WebDriverWait wait = new WebDriverWait(driver, 10);
				if (update) {
					try {
						wait.until(ExpectedConditions.invisibilityOf(SupplierPage.editModal));
//						Assert.assertEquals(SupplierPage.editModal.isDisplayed(), true);

						updateBtnVisi = true;
					} catch (Exception e) {
						updateBtnVisi = false;
					}
				}
				if (updateBtnVisi) {
					testCase = extent.createTest("Update Success Message");
					try {
						Assert.assertEquals(SupplierPage.updateSuccess.getText(), "Supplier Updated Successfully");
						testCase.log(Status.INFO, "Actual : " + SupplierPage.updateSuccess.getText());
						testCase.log(Status.INFO, "Expected : Supplier Updated Successfully");
						testCase.log(Status.PASS, "Success Message Correct, So Pass");
					} catch (Exception e) {
						testCase.log(Status.INFO, "Actual : " + SupplierPage.updateSuccess.getText());
						testCase.log(Status.INFO, "Expected : Supplier Updated Successfully");
						testCase.log(Status.FAIL, "Success Message Wrong, So Fail");
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "Actual : " + SupplierPage.updateSuccess.getText());
						testCase.log(Status.INFO, "Expected : Supplier Updated Successfully");
						testCase.log(Status.FAIL, "Success Message Wrong, So Fail");
					}
					boolean checkFirst = false;
					boolean checkSecond = false;
					try {
						driver.findElement(By.xpath("//tr[2][td[1][text()='" + editSupplier + "'] and td[2][text()='"
								+ editPlant + "'] and td[3][text()='" + editEmail + "'] and td[4][text()='"
								+ editContactNo + "'] and td[5][text()='" + editAddress + "']]")).isDisplayed();
						checkFirst = true;
					} catch (Exception e) {
						// TODO: handle exception
					}

					boolean chePlan = false;
					if (checkFirst) {
						try {
							wait.until(ExpectedConditions.elementToBeClickable(SupplierPage.editSupplierCat));
							SupplierPage.editSupplierCat.click();
							chePlan = true;
						} catch (Exception e) {
							// TODO: handle exception
						}

						if (chePlan) {
							int m = 0;
							try {
								wait.until(ExpectedConditions.visibilityOfAllElements(SupplierPage.plantCheck));
								m = SupplierPage.plantCheck.size();
								System.out.println(m);
							} catch (Exception e) {
								m = after.length;
							}
							String suplierCa = "";
							int l = 0;
							for (int j = 0; j < after.length; j++) {

								for (int k = 1; k <= m; k++) {

									System.out.println(j + " " + k);
									System.out
											.println("//div[@class='ant-popover-content']//div[text()='Plants']//..//p["
													+ k + "]");
									try {
										Thread.sleep(500);
										suplierCa = driver.findElement(By.xpath(
												"//div[@class='ant-popover-content']//div[text()='Supplier Category']//..//p["
														+ k + "]"))
												.getText();
									} catch (Exception e) {
									}
									System.err.println(suplierCa + "||" + after[j]);
									if (suplierCa.contentEquals(after[j])) {
										l = l + 1;
										if (l == after.length) {
											checkSecond = true;
										}
									}

								}
							}
							try {
								SupplierPage.editSupplierCat.click();
							} catch (Exception e) {
								// TODO: handle exception
							}
						}
					}
					testCase = extent.createTest("Update Function Conformation");
					if (checkSecond) {
						testCase.log(Status.INFO, "Last Updated Have in First Raw");
						testCase.log(Status.INFO, "All Updated datas are in Table");
						testCase.log(Status.PASS, "So, Updated Function Pass");
						Thread.sleep(1000);
					} else {
						testCase.log(Status.INFO, "Last Updated Dont Have in First Raw");
						testCase.log(Status.INFO, "All Updated datas are Not in Table");
						testCase.log(Status.FAIL, "So, Updated Function Fail");
					}
				} else {
					try {
						SupplierPage.loadingUpdate.isDisplayed();
						testCase = extent.createTest("Update Button Loading");
						testCase.log(Status.INFO, "Network Error/Validation Not throwng/System Fail");
						testCase.log(Status.FAIL, "So Fail");
						driver.navigate().refresh();
					} catch (Exception e) {
						materialMethodes.validationconfirm("", "", "Supplier");
						driver.navigate().refresh();
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

	static boolean check = false;

	public static void select(String[] aa) {
		int count = 0;
		for (int n = 0; n < aa.length; n++) {
			SupplierPage.supplierCategorys.click();
			SupplierPage.supplierCategorys.clear();
			SupplierPage.supplierCategorys.sendKeys(aa[n]);
			try {
				SupplierPage.supplierCategorys.click();
				count = driver.findElements(By
						.xpath("//div[@class='rc-virtual-list']//div[@class='ant-select-item ant-select-item-option']"))
						.size();
			} catch (Exception e1) {

			}
			if (count == 0) {
				count = 9;
			}
			for (int m = 0; m < count; m++) {
				System.out.println("//div[@class='rc-virtual-list-holder-inner']/div[" + m + "]/div");
				WebElement mm = null;
				check = false;
				try {
					mm = driver
							.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[" + m + "]/div"));
					check = true;
				} catch (Exception e) {
					check = false;
				}
				if (check) {
					String nn = mm.getText();
					if (nn.contentEquals(aa[n])) {
						SupplierPage.supplierCategorys.sendKeys(Keys.ENTER);
						break;
					}
				}
			}

		}
	}

	public static void selects(String aa) {

		try {
			driver.findElement(By.xpath("//label[@for='plant']//..//span[@class='ant-select-selection-item']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//label[@for='plant']//..//input")).sendKeys(aa, Keys.ENTER);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
