package com.qa.automation.qdms.testcases.customer;

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
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class CustomerEdit extends DriverIntialization {

	static CustomerPage customerfunpg = new CustomerPage();
	static DataFormatter dataValue = new DataFormatter();

	@Test
	public static void fieldvisible(){
		PageFactory.initElements(driver, customerfunpg);

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateCustomerMain();
		}

		if (MasterMainNavigationsTest.clickCustomermain) {
			MasterMainNavigationsTest.navigateCustomer();
		}

		if (MasterMainNavigationsTest.clickCustomer) {
			edit("Master Module", "Customer", "TC-CUS-0081");
		}

		MultiSearchMethods.Logout();
	}

	public static void edit(String workBook, String tabName, String testcaseId) {
		boolean excel = false;
		boolean editClick = false;
		boolean saveBtnClick = false;
		boolean edit = false;
		try {
			String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + workBook + ".xlsx";
			int firstrow = CommonMethods.getFirstRowNum(excelPath, tabName, testcaseId);
			int lastrow = CommonMethods.getLastRowNum(excelPath, tabName, testcaseId);
			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(tabName);
			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);
				String plant = dataValue.formatCellValue(row.getCell(1));
				String customer = dataValue.formatCellValue(row.getCell(2));
				String email = dataValue.formatCellValue(row.getCell(3));
				String address = dataValue.formatCellValue(row.getCell(4));
				String contactNo = dataValue.formatCellValue(row.getCell(5));
				String editPlant = dataValue.formatCellValue(row.getCell(6));
				String editCustomer = dataValue.formatCellValue(row.getCell(7));
				String editEmail = dataValue.formatCellValue(row.getCell(8));
				String editAddress = dataValue.formatCellValue(row.getCell(9));
				String editContactNo = dataValue.formatCellValue(row.getCell(10));

				excel = true;
				String[] before = null;
				String[] after = null;
				try {
					before = plant.split("\n");
					after = editPlant.split("\n");
				} catch (Exception e) {
					// TODO: handle exception
				}
				if (excel) {

					boolean next = true;
					while (next) {
						WebDriverWait wait = new WebDriverWait(driver, 2);

						try {
							Thread.sleep(1000);
							java.util.List<WebElement> sbus = driver
									.findElements(By.xpath("//td[1][text()='" + customer + "']"));
							for (WebElement aa : sbus) {
								String SBU = aa.getText();
								wait.until(ExpectedConditions.visibilityOf(aa));
								MultiSearchMethods.icon(aa, customer + " Edit Icon");
								if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
									wait.until(ExpectedConditions.elementToBeClickable(
											driver.findElement(By.xpath("//td[1][text()='" + customer
													+ "']/following-sibling::td//span[contains(@class,'anticon-edit')]"))));
									driver.findElement(By.xpath("//td[1][text()='" + customer
											+ "']/following-sibling::td//span[contains(@class,'anticon-edit')]"))
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
						materialMethodes.popupdatacompare(
								plant + "," + customer + "," + email + "," + address + "," + contactNo);
					} else {
						testCase = extent.createTest("Dont Have Searched Element to Edit");
						testCase.log(Status.INFO, "Dont Have Searched Element");
						testCase.log(Status.FAIL, "So fail");
					}
					if (materialMethodes.edit) {
						materialMethodes.edit=false;
						int x = 0;
						boolean plan = false ;
						for (int j = 0; j < before.length; j++) {
							for (int k = 0; k < after.length; k++) {
								System.out.println(before[j] + "-" + after[k]);
								if (before[j].contentEquals(after[k])) {
									x=x+1;
								}
							}
						}
						if(before.length==x) {
							plan = true; 
						}
//						MultiSearchMethods.textBox(CustomerPage.plants, "Customer Plant");
						if(MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						if (!plan) {
							for (int m = 0; m < before.length; m++) {
								CustomerPage.plants.sendKeys(Keys.BACK_SPACE);
							}
							select(after);
							if (check) {
								MultiSearchMethods.checked = true;
							}
						}
					}
						
						if (!customer.contentEquals(editCustomer)) {
							MultiSearchMethods.textBoxData(CustomerPage.CustomerFiled, "Customer ",
									editCustomer);
						}

						if (!email.contentEquals(editEmail)) {
							MultiSearchMethods.textBoxData(CustomerPage.CustomerEmailFiled, "Customer Email",
									editEmail);
						}

						if (!address.contentEquals(editAddress)) {
							MultiSearchMethods.textBoxData(CustomerPage.CustomerAddressFiled, "Customer Address",
									editAddress);
						}

						if (!contactNo.contentEquals(editContactNo)) {
							MultiSearchMethods.textBoxData(CustomerPage.CustomerContactNoFiled, "Customer ContactNo",
									editContactNo);
						}
					} else {
						testCase = extent.createTest("Compare Edit Datas ");
						testCase.log(Status.INFO, "Given Data Matched");
						testCase.log(Status.FAIL, "So Fail");
					}
				}
				if(MultiSearchMethods.checked) {
					materialMethodes.popupdatacompare(
							editPlant + "," + editCustomer + "," + editEmail + "," + editAddress + "," + editContactNo);
				}
boolean update=false;
				if (materialMethodes.edit) {
					MultiSearchMethods.Button(CustomerPage.updateBtns,
							"Customer Update");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						MultiSearchMethods.elementClick(CustomerPage.updateBtns);
						update=true;
					}
				}
				boolean updateBtnVisi=false;
				WebDriverWait wait=new WebDriverWait(driver, 5);
				if(update) {
					try {
						wait.until(ExpectedConditions.invisibilityOf(CustomerPage.editModal));
//						Assert.assertEquals(CustomerPage.editModal.isDisplayed(), false);
						updateBtnVisi=true;
					} catch (Exception e) {
						updateBtnVisi=false;
					}  
//					catch (AssertionError e) {
//						updateBtnVisi=false;
//					}
					
					if(updateBtnVisi) {
						testCase = extent.createTest("Update Success Message");
						try {
							Assert.assertEquals(CustomerPage.updateSuccess.getText(), "Customer Updated Successfully");
							testCase.log(Status.INFO, "Actual : "+CustomerPage.updateSuccess.getText());
							testCase.log(Status.INFO, "Expected : Customer Updated Successfully");
							testCase.log(Status.PASS, "Success Message Correct, So Pass");
						} catch (Exception e) {
							testCase.log(Status.INFO, "Actual : "+CustomerPage.updateSuccess.getText());
							testCase.log(Status.INFO, "Expected : Customer Updated Successfully");
							testCase.log(Status.FAIL, "Success Message Wrong, So Fail");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual : "+CustomerPage.updateSuccess.getText());
							testCase.log(Status.INFO, "Expected : Customer Updated Successfully");
							testCase.log(Status.FAIL, "Success Message Wrong, So Fail");
						}
					boolean checkFirst=false;
					boolean checkSecond=false;
					boolean checkThird=false;
						try {
							driver.findElement(By.xpath("//tr[2][td[1][text()='"+editCustomer+"'] and td[3][text()='"+editEmail+"'] and td[4][text()='"+editContactNo+"']]")).isDisplayed();
							checkFirst=true;
						} catch (Exception e) {
							// TODO: handle exception
						}
						boolean clickMor=false;
						if(checkFirst) {
							try {
							wait.until(ExpectedConditions.elementToBeClickable(CustomerPage.editMore));
							CustomerPage.editMore.click();
							clickMor=true;
							} catch (Exception e) {
								// TODO: handle exception
							}
							if(clickMor) {
								try {
									wait.until(ExpectedConditions.visibilityOf(CustomerPage.addressCheck));
									String addre=CustomerPage.addressCheck.getText();
									Assert.assertEquals(addre, editAddress);
									checkSecond=true;
									CustomerPage.editMore.click();
								} catch (AssertionError e) {
								}catch (Exception e) {
								}
							}
						}
						
							boolean chePlan=false;
							if(checkSecond) {
								try {
									wait.until(ExpectedConditions.elementToBeClickable(CustomerPage.editplant));
									CustomerPage.editplant.click();
									chePlan=true;
									} catch (Exception e) {
									}
								
								if(chePlan) {
									int m=0;
									try {
										wait.until(ExpectedConditions.visibilityOfAllElements(CustomerPage.plantCheck));
										m=CustomerPage.plantCheck.size();
										System.out.println(m);
									} catch (Exception e) {
										m=after.length;
									}
									String plan="";
									int l=0;
									for(int j=0; j<after.length; j++) {
										
										for(int k=1; k<=m; k++) {
										
											System.out.println(j+" "+k);
											System.out.println("//div[@class='ant-popover-content']//div[text()='Plants']//..//p["+k+"]");
											try {
												Thread.sleep(500);
												plan=driver.findElement(By.xpath("//div[@class='ant-popover-content']//div[text()='Plants']//..//p["+k+"]")).getText();
											} catch (Exception e) {
											}
											System.err.println(plan+"||"+after[j]);
											if(plan.contentEquals(after[j])) {
												l=l+1;
												if(l==after.length) {
													checkThird=true;
												}
											}
											
										}
									}
									
								}
							}
							testCase = extent.createTest("Update Function Conformation");
							if(checkThird) {
								testCase.log(Status.INFO, "Last Updated Have in First Raw");
								testCase.log(Status.INFO, "All Updated datas are in Table");
								testCase.log(Status.PASS, "So, Updated Function Pass");
							} else {
								testCase.log(Status.INFO, "Last Updated Dont Have in First Raw");
								testCase.log(Status.INFO, "All Updated datas are Not in Table");
								testCase.log(Status.FAIL, "So, Updated Function Fail");
							}
					} else {
						try {
							CustomerPage.loadingUpdate.isDisplayed();
							testCase = extent.createTest("Update Button Loading");
							testCase.log(Status.INFO, "Network Error/Validation Not throwng/System Fail");
							testCase.log(Status.FAIL,"So Fail");
							driver.navigate().refresh();
						} catch (Exception e) {
							materialMethodes.validationconfirm("", "", "customer");
							driver.navigate().refresh();
						}
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
//		WebElement plants = driver.findElement(By.id("customer_plant"));
		for (int n = 0; n < aa.length; n++) {
			CustomerPage.plants.click();
			CustomerPage.plants.clear();
			CustomerPage.plants.sendKeys(aa[n]);
			try {
//				Thread.sleep(500);
				CustomerPage.plants.click();
//				Thread.sleep(500);
				count = driver.findElements(By
						.xpath("//div[@class='rc-virtual-list']//div[@class='ant-select-item ant-select-item-option']"))
						.size();
			} catch (Exception e1) {

			}
			if (count == 0) {
				count = 9;
			}
			System.out.println("::::::::::::" + count);
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
						CustomerPage.plants.sendKeys(Keys.ENTER);
						break;
					}
				}
			}

		}
	}
}
