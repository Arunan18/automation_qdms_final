package com.qa.automation.qdms.commonmethods;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class deleteFunction {
	static String deleteElement = null;
	static String deleteSuccessMessage = null;
	static String checkDepend=null;
	static int total=0;
	static DataFormatter dataValue = new DataFormatter();

	public static void clickDelete(String workbooks, String tabName, String testcaseId, String deletetable){
		boolean excel = false;
		try {
			String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + workbooks + ".xlsx";
			int firstrow = CommonMethods.getFirstRowNum(excelPath, tabName, testcaseId);
			int lastrow = CommonMethods.getLastRowNum(excelPath, tabName, testcaseId);
			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(tabName);
			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);
				WebDriverWait wait = new WebDriverWait(DriverIntialization.driver, 20);
				deleteElement = dataValue.formatCellValue(row.getCell(1));
				deleteSuccessMessage = dataValue.formatCellValue(row.getCell(2));
				checkDepend = dataValue.formatCellValue(row.getCell(3));
				String totals = dataValue.formatCellValue(row.getCell(4));
				System.out.println("!!!!!!!! " + deleteElement);
				
				String[] split = deleteElement.split(",");
				System.out.println("!!!!!!!! " + split.length);
				
				total=Integer.parseInt(totals);
				//				file.close();
				
				excel = true;
				
				boolean delete = false;
				if (excel) {
					excel = false;
					boolean enable = true;
					while (enable) {
						WebDriverWait wai = new WebDriverWait(DriverIntialization.driver, 2);

						if (split[0].contentEquals("Material Sub Category")) {
							if (split.length >= 1) {
								deleteElement = split[1];
							}
							try {
//								wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//										.findElements(By.xpath("//tr[td[1][text()='"+split[1]+"'] and td[3][text()='"+split[2]+"']]//td[1]"))));
								Thread.sleep(500);
								java.util.List<WebElement> sbus = DriverIntialization.driver
										.findElements(By.xpath("//tr[td[1][text()='" + split[1]
												+ "'] and td[3][text()='" + split[2] + "']]//td[1]"));
								System.out.println("***" + sbus);
								for (WebElement aa : sbus) {
									String SBU = aa.getText();
									wait.until(ExpectedConditions.visibilityOf(aa));
									MultiSearchMethods.icon(aa, deleteElement + " Delete Icon");
									if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
										wait.until(ExpectedConditions.elementToBeClickable(
												DriverIntialization.driver.findElement(By.xpath("//tr[td[1][text()='"
														+ split[1] + "'] and td[3][text()='" + split[2]
														+ "']]//following-sibling::td//span[contains(@class,'anticon-delete')]"))));
										DriverIntialization.driver.findElement(By.xpath("//tr[td[1][text()='" + split[1]
												+ "'] and td[3][text()='" + split[2]
												+ "']]//following-sibling::td//span[contains(@class,'anticon-delete')]"))
												.click();
										delete = true;
										break;
									}
								}
							} catch (Exception e) {
								// TODO: handle exception
							}
						} else if (split[0].contentEquals("Plant Equipment") || split[0].contentEquals("Material")) {
							if (split.length >= 1) {
								deleteElement = split[1];
							}
							try {
//								wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//										.findElements(By.xpath("//tr[td[1][text()='"+split[1]+"'] and td[4][text()='"+split[2]+"']]//td[1]"))));
								Thread.sleep(500);
								java.util.List<WebElement> sbus = DriverIntialization.driver
										.findElements(By.xpath("//tr[td[1][text()='" + split[1]
												+ "'] and td[4][text()='" + split[2] + "']]//td[1]"));
								System.out.println("***" + sbus);
								for (WebElement aa : sbus) {
									String SBU = aa.getText();
									wait.until(ExpectedConditions.visibilityOf(aa));
									MultiSearchMethods.icon(aa, deleteElement + " Delete Icon");
									if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
										wait.until(ExpectedConditions.elementToBeClickable(
												DriverIntialization.driver.findElement(By.xpath("//tr[td[1][text()='"
														+ split[1] + "'] and td[4][text()='" + split[2]
														+ "']]//following-sibling::td//span[contains(@class,'anticon-delete')]"))));
										DriverIntialization.driver.findElement(By.xpath("//tr[td[1][text()='" + split[1]
												+ "'] and td[4][text()='" + split[2]
												+ "']]//following-sibling::td//span[contains(@class,'anticon-delete')]"))
												.click();
										delete = true;
										break;
									}
								}
							} catch (Exception e) {
								// TODO: handle exception
							}
						} else if (split[0].contentEquals("Employee")) {
							if (split.length >= 1) {
								deleteElement = split[1];
							}
							try {
//								wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//										.findElements(By.xpath("//tr[td[1][text()='"+split[1]+"'] and td[4][text()='"+split[2]+"']]//td[1]"))));
								Thread.sleep(500);
								java.util.List<WebElement> sbus = DriverIntialization.driver
										.findElements(By.xpath("//tr[td[1][text()='" + split[1]
												+ "'] and td[5][text()='" + split[2] + "']]//td[1]"));
								System.out.println("***" + sbus);
								for (WebElement aa : sbus) {
									String SBU = aa.getText();
									wait.until(ExpectedConditions.visibilityOf(aa));
									MultiSearchMethods.icon(aa, deleteElement + " Delete Icon");
									if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
										wait.until(ExpectedConditions.elementToBeClickable(
												DriverIntialization.driver.findElement(By.xpath("//tr[td[1][text()='"
														+ split[1] + "'] and td[5][text()='" + split[2]
														+ "']]//following-sibling::td//span[contains(@class,'anticon-delete')]"))));
										DriverIntialization.driver.findElement(By.xpath("//tr[td[1][text()='" + split[1]
												+ "'] and td[5][text()='" + split[2]
												+ "']]//following-sibling::td//span[contains(@class,'anticon-delete')]"))
												.click();
										delete = true;
										break;
									}
								}
							} catch (Exception e) {
								// TODO: handle exception
							}
						} else if (split[0].contentEquals("Material Main Category")) {
							if (split.length >= 1) {
								deleteElement = split[1];
							}
							try {
//								wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//								.findElements(By.xpath("//tr[td[1][text()='"+split[1]+"'] and td[4][text()='"+split[2]+"']]//td[1]"))));
								Thread.sleep(500);
								java.util.List<WebElement> sbus = DriverIntialization.driver
										.findElements(By.xpath("//tr[td[1][text()='" + split[1]
												+ "'] and td[2][text()='" + split[2] + "']]//td[1]"));
								System.out.println("***" + sbus);
								for (WebElement aa : sbus) {
									String SBU = aa.getText();
									wait.until(ExpectedConditions.visibilityOf(aa));
									MultiSearchMethods.icon(aa, deleteElement + " Delete Icon");
									if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
										wait.until(ExpectedConditions.elementToBeClickable(
												DriverIntialization.driver.findElement(By.xpath("//tr[td[1][text()='"
														+ split[1] + "'] and td[2][text()='" + split[2]
														+ "']]//following-sibling::td//span[contains(@class,'anticon-delete')]"))));
										DriverIntialization.driver.findElement(By.xpath("//tr[td[1][text()='" + split[1]
												+ "'] and td[2][text()='" + split[2]
												+ "']]//following-sibling::td//span[contains(@class,'anticon-delete')]"))
												.click();
										delete = true;
										break;
									}
								}
							} catch (Exception e) {
								// TODO: handle exception
							}
						} else if (split[0].contentEquals("Supplier")) {
							try {
								if(split[0].contentEquals(" ")) {
									split[0]="";
								} else if (split[1].contentEquals(" ")) {
									split[1]="";
								}else if (split[2].contentEquals(" ")) {
									split[2]="";
								}else if (split[3].contentEquals(" ")) {
									split[3]="";
								}else if (split[4].contentEquals(" ")) {
									split[4]="";
								} else {

								} 
							} catch (Exception e) {
							}
							if (split.length >= 1) {
								deleteElement = split[1];
							}
							try {
//						wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//						.findElements(By.xpath("//tr[td[1][text()='"+split[1]+"'] and td[2][text()='"+split[2]+"']and td[3][text()='"+split[3]+"']and td[4][text()='"+split[4]+"']]//td[1]"))));
								Thread.sleep(500);
								System.out.println("//tr[td[1][text()='" + split[1] + "'] and td[2][text()='" + split[2]
										+ "'] | td[3][text()='" + split[3] + "'] | td[4][text()='" + split[4]
										+ "']]//td[1]");
								java.util.List<WebElement> sbus = DriverIntialization.driver
										.findElements(By.xpath("//tr[td[1][text()='" + split[1]
												+ "'] and td[2][text()='" + split[2] + "'] | td[3][text()='" + split[3]
												+ "'] | td[4][text()='" + split[4] + "']]//td[1]"));
								System.out.println("***" + sbus);
								for (WebElement aa : sbus) {
									String SBU = aa.getText();
									wait.until(ExpectedConditions.visibilityOf(aa));
									MultiSearchMethods.icon(aa, deleteElement + " Delete Icon");
									if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
										wait.until(ExpectedConditions.elementToBeClickable(DriverIntialization.driver
												.findElement(By.xpath("//tr[td[1][text()='" + split[1]
														+ "'] and td[2][text()='" + split[2] + "'] | td[3][text()='"
														+ split[3] + "'] | td[4][text()='" + split[4]
														+ "']]//following-sibling::td//span[contains(@class,'anticon-delete')]"))));
										DriverIntialization.driver.findElement(By.xpath("//tr[td[1][text()='" + split[1]
												+ "'] and td[2][text()='" + split[2] + "'] | td[3][text()='" + split[3]
												+ "'] | td[4][text()='" + split[4]
												+ "']]//following-sibling::td//span[contains(@class,'anticon-delete')]"))
												.click();
										delete = true;
										break;
									}
								}
							} catch (Exception e) {
								// TODO: handle exception
							}
						} else {
							try {
//								wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//										.findElements(By.xpath("//td[1][text()='" + deleteElement + "']"))));
								java.util.List<WebElement> sbus = DriverIntialization.driver
										.findElements(By.xpath("//td[1][text()='" + deleteElement + "']"));
								for (WebElement aa : sbus) {
									String SBU = aa.getText();
									wait.until(ExpectedConditions.visibilityOf(aa));
									MultiSearchMethods.icon(aa, deleteElement + " Delete Icon");
									if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
										wait.until(ExpectedConditions.elementToBeClickable(DriverIntialization.driver
												.findElement(By.xpath("//td[1][text()='" + deleteElement
														+ "']/following-sibling::td//span[contains(@class,'anticon-delete')]"))));
										DriverIntialization.driver.findElement(By.xpath("//td[1][text()='"
												+ deleteElement
												+ "']/following-sibling::td//span[contains(@class,'anticon-delete')]"))
												.click();
										delete = true;
										break;
									}
								}
							} catch (Exception e) {
								// TODO: handle exception
							}
						}
						if (delete) {
							break;
						}

						enable = DriverIntialization.driver.findElement(By.xpath("//li[@title='Next Page']/button"))
								.isEnabled();
//		        Click Next page Button
						if (enable) {
							try {
								DriverIntialization.driver.findElement(By.xpath("//li[@title='Next Page']/button"))
										.click();
								wai.until(ExpectedConditions.visibilityOfAllElements(
										DriverIntialization.driver.findElements(By.xpath("//tr"))));
							} catch (Exception e) {
								// TODO: handle exception
							}
						}
					}
					boolean deleteOkBtnClick = false;
					if (delete) {
						delete = false;
						MultiSearchMethods.Button(
								DriverIntialization.driver
										.findElement(By.xpath("//button[@type='button']//span[text()='OK']")),
								deleteElement + " Delete Ok ");
						if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
							wait.until(ExpectedConditions.elementToBeClickable(DriverIntialization.driver
									.findElement(By.xpath("//button[@type='button']//span[text()='OK']"))));
							DriverIntialization.driver
									.findElement(By.xpath("//button[@type='button']//span[text()='OK']")).click();
							deleteOkBtnClick = true;
						}

					} else {
						DriverIntialization.testCase = DriverIntialization.extent
								.createTest("Dont Have Searched Element to Delete");
						DriverIntialization.testCase.log(Status.INFO, "Dont Have Searched Element");
						DriverIntialization.testCase.log(Status.FAIL, "So fail");
					}
					if (deleteOkBtnClick) {
						deleteOkBtnClick = false;
						String successMessage = "";
						try {
							Thread.sleep(1000);
							wait.until(ExpectedConditions.visibilityOf(DriverIntialization.driver
									.findElement(By.xpath("//div[@class='ant-notification-notice-message']"))));
							successMessage = DriverIntialization.driver
									.findElement(By.xpath("//div[@class='ant-notification-notice-message']")).getText();

							try {
								Thread.sleep(500);
								wait.until(ExpectedConditions
										.elementToBeClickable(DriverIntialization.driver.findElement(By.xpath(
												"//span[@class='anticon anticon-close ant-notification-close-icon']"))));
								DriverIntialization.driver
										.findElement(By.xpath(
												"//span[@class='anticon anticon-close ant-notification-close-icon']"))
										.click();
//								DriverIntialization.driver.navigate().refresh();
							} catch (Exception e) {

							}

						} catch (Exception e) {
							DriverIntialization.testCase = DriverIntialization.extent
									.createTest("Success Message After Delete");
							DriverIntialization.testCase.log(Status.INFO, "Success Message Not Throw");
							DriverIntialization.testCase.log(Status.FAIL, "So fail");
						}
						System.out.println(successMessage + "*" + deleteSuccessMessage);
						if (checkDepend.equalsIgnoreCase("not-depend")) {
							DriverIntialization.testCase = DriverIntialization.extent.createTest(
									deletetable + " :- " + deleteElement + " - Delete Success Message Before Depend");
							try {
								Assert.assertEquals(successMessage, deleteSuccessMessage);
								DriverIntialization.testCase.log(Status.INFO,
										"Actual Success Message :- " + successMessage);
								DriverIntialization.testCase.log(Status.INFO,
										"Expected Success Message :- " + deleteSuccessMessage);
								DriverIntialization.testCase.log(Status.PASS,
										"Success Message  Matching, So Throwing Success Message Pass");

							} catch (AssertionError e) {
								DriverIntialization.testCase.log(Status.INFO,
										"Actual Success Message :- " + successMessage);
								DriverIntialization.testCase.log(Status.INFO,
										"Expected Success Message :- " + deleteSuccessMessage);
								DriverIntialization.testCase.log(Status.FAIL,
										"Success Message Not Matching, So Throwing Success Message Fail");
							} catch (Exception e) {
								DriverIntialization.testCase.log(Status.INFO,
										"Actual Success Message :- " + successMessage);
								DriverIntialization.testCase.log(Status.INFO,
										"Expected Success Message :- " + deleteSuccessMessage);
								DriverIntialization.testCase.log(Status.FAIL,
										"Success Message Not Matching, So Throwing Success Message Fail");
							}
							try {
								wait.until(ExpectedConditions.elementToBeClickable(
										DriverIntialization.driver.findElement(By.xpath("//li[@title='1']/a"))));
								DriverIntialization.driver.findElement(By.xpath("//li[@title='1']/a")).click();
							} catch (Exception e) {
								// TODO: handle exception
							}
							int counts = 0;
int totalCount=0;
							boolean enabled = true;
							while (enabled) {
								WebDriverWait wai = new WebDriverWait(DriverIntialization.driver, 5);

								int x = 0;
								int n=0;
									if (split[0].contentEquals("Material Sub Category")) {
										try {
//											wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//													.findElements(By.xpath("//tr[td[1][text()='"+split[1]+"'] and td[3][text()='"+split[2]+"']]"))));
											Thread.sleep(500);
											x = DriverIntialization.driver.findElements(By.xpath("//tr[td[1][text()='"
													+ split[1] + "'] and td[3][text()='" + split[2] + "']]")).size();
										} catch (Exception e) {
										}
									} else if (split[0].contentEquals("Plant Equipment")
											|| split[0].contentEquals("Material")) {
										try {
//										wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//										.findElements(By.xpath("//tr[td[1][text()='"+split[1]+"'] and td[4][text()='"+split[2]+"']]"))));
											Thread.sleep(500);
											x = DriverIntialization.driver.findElements(By.xpath("//tr[td[1][text()='"
													+ split[1] + "'] and td[4][text()='" + split[2] + "']]")).size();
										} catch (Exception e) {
										}
									} else if (split[0].contentEquals("Employee")) {
										try {
//										wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//										.findElements(By.xpath("//tr[td[1][text()='"+split[1]+"'] and td[4][text()='"+split[2]+"']]"))));
											Thread.sleep(500);
											x = DriverIntialization.driver.findElements(By.xpath("//tr[td[1][text()='"
													+ split[1] + "'] and td[5][text()='" + split[2] + "']]")).size();
										} catch (Exception e) {
										}
									} else if (split[0].contentEquals("Material Main Category")) {
										try {
//										wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//										.findElements(By.xpath("//tr[td[1][text()='"+split[1]+"'] and td[2][text()='"+split[2]+"']]"))));
											Thread.sleep(500);
											x = DriverIntialization.driver.findElements(By.xpath("//tr[td[1][text()='"
													+ split[1] + "'] and td[2][text()='" + split[2] + "']]")).size();
										} catch (Exception e) {
										}
									}else if (split[0].contentEquals("Supplier")) {
										try {
//											wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//											.findElements(By.xpath("//tr[td[1][text()='"+split[1]+"'] and td[2][text()='"+split[2]+"'] | td[3][text()='" + split[3] + "'] | td[4][text()='" + split[4] + "']]"))));
												Thread.sleep(500);
												x = DriverIntialization.driver.findElements(By.xpath("//tr[td[1][text()='"
														+ split[1] + "'] and td[2][text()='" + split[2] + "'] and td[3][text()='" + split[3] + "'] and td[4][text()='" + split[4] + "']]")).size();
											} catch (Exception e) {
											}
										} else {
										try {
//									wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//											.findElements(By.xpath("//td[1][text()='" + deleteElement + "']"))));
											x = DriverIntialization.driver
													.findElements(By.xpath("//td[1][text()='" + deleteElement + "']"))
													.size();
										} catch (Exception e) {
										}
									}
								counts = counts + x;
								try {
									Thread.sleep(500);
									n=DriverIntialization.driver.findElements(By.xpath("//tr[contains(@class,'ant-table-row')]/td[1]")).size();
								} catch (Exception e) {
									// TODO: handle exception
								}
								totalCount=totalCount+n;
								try {
									enabled = DriverIntialization.driver
											.findElement(By.xpath("//li[@title='Next Page']/button")).isEnabled();
//		        		Click Next page Button
									if (enabled) {

										DriverIntialization.driver
												.findElement(By.xpath("//li[@title='Next Page']/button")).click();
									}
								} catch (Exception e) {

								}

							}
boolean tot=false;
System.out.println(totalCount+" : "+(total-1));
							try {
								Assert.assertEquals(totalCount, total-1);
								tot=true;
							} catch (AssertionError e) {
								DriverIntialization.testCase = DriverIntialization.extent
										.createTest("Deleted Data Count");
								DriverIntialization.testCase.log(Status.INFO,
										"SuccessFully Data Deleted Count Wrong");
								
								// TODO: handle exception
							}
							DriverIntialization.testCase = DriverIntialization.extent
									.createTest(deletetable + " :- " + deleteElement
											+ " - Deleted Value Check Before Depend In " + deletetable + " Table");
							if (counts == 0 && tot==true) {
								DriverIntialization.testCase.log(Status.INFO, deletetable + " :- " + deleteElement
										+ " Deleted Check Not in " + deletetable + " Table");
								DriverIntialization.testCase.log(Status.INFO,
										deletetable + " :- " + deleteElement + " Not Depended");
								DriverIntialization.testCase.log(Status.INFO,
										"Deleted Value Not Founded In " + deletetable + " Table");
								DriverIntialization.testCase.log(Status.PASS,
										"So, Delete " + deletetable + " Script Pass");
							} else {
								DriverIntialization.testCase.log(Status.INFO, deletetable + " :- " + deleteElement
										+ " Deleted Check in " + deletetable + " Table");
								DriverIntialization.testCase.log(Status.INFO,
										deletetable + " :- " + deleteElement + " Not Depended");
								DriverIntialization.testCase.log(Status.INFO,
										"Deleted Value In " + deletetable + " Table");
								DriverIntialization.testCase.log(Status.FAIL,
										"So, Deleted " + deletetable + " Script Fail");
							}
							DriverIntialization.driver.navigate().refresh();
						} else if (checkDepend.equalsIgnoreCase("depend")) {
							DriverIntialization.testCase = DriverIntialization.extent.createTest(
									deletetable + " :- " + deleteElement + " - Delete Success Message After Depend");
							try {
								Assert.assertEquals(successMessage, "Can't delete this module");
								DriverIntialization.testCase.log(Status.INFO,
										"Actual Success Message :- " + successMessage);
								DriverIntialization.testCase.log(Status.INFO,
										"Expected Success Message :- " + "Can't delete this module");
								DriverIntialization.testCase.log(Status.PASS,
										"Success Message  Matching, So Throwing Success Message Pass");

							} catch (AssertionError e) {
								DriverIntialization.testCase.log(Status.INFO,
										"Actual Success Message :- " + successMessage);
								DriverIntialization.testCase.log(Status.INFO,
										"Expected Success Message :- " + "Can't delete this module");
								DriverIntialization.testCase.log(Status.FAIL,
										"Success Message Not Matching, So Throwing Success Message Fail");
							} catch (Exception e) {
								DriverIntialization.testCase.log(Status.INFO,
										"Actual Success Message :- " + successMessage);
								DriverIntialization.testCase.log(Status.INFO,
										"Expected Success Message :- " + "Can't delete this module");
								DriverIntialization.testCase.log(Status.FAIL,
										"Success Message Not Matching, So Throwing Success Message Fail");
							}

							try {
								wait.until(ExpectedConditions.elementToBeClickable(
										DriverIntialization.driver.findElement(By.xpath("//li[@title='1']/a"))));
								DriverIntialization.driver.findElement(By.xpath("//li[@title='1']/a")).click();
							} catch (Exception e) {
								// TODO: handle exception
							}

							int counts = 0;
							int totalCount=0;
							boolean enabled = true;
							while (enabled) {
								WebDriverWait wai = new WebDriverWait(DriverIntialization.driver, 5);

								int x = 0;
								int n=0;
									if (split[0].contentEquals("Material Sub Category")) {
										try {
//									wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//											.findElements(By.xpath("//tr[td[1][text()='"+split[1]+"'] and td[3][text()='"+split[2]+"']]"))));
										Thread.sleep(500);
										x = DriverIntialization.driver.findElements(By.xpath("//tr[td[1][text()='"
												+ split[1] + "'] and td[3][text()='" + split[2] + "']]")).size();
										}catch (Exception e) {
										}
									} else if (split[0].contentEquals("Plant Equipment")
											|| split[0].contentEquals("Material")) {
										try {
//										wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//										.findElements(By.xpath("//tr[td[1][text()='"+split[1]+"'] and td[4][text()='"+split[2]+"']]"))));
										Thread.sleep(500);
										x = DriverIntialization.driver.findElements(By.xpath("//tr[td[1][text()='"
												+ split[1] + "'] and td[4][text()='" + split[2] + "']]")).size();
										}catch (Exception e) {
										}
									} else if (split[0].contentEquals("Employee")) {
										try {
//										wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//										.findElements(By.xpath("//tr[td[1][text()='"+split[1]+"'] and td[4][text()='"+split[2]+"']]"))));
										Thread.sleep(500);
										x = DriverIntialization.driver.findElements(By.xpath("//tr[td[1][text()='"
												+ split[1] + "'] and td[5][text()='" + split[2] + "']]")).size();
										}catch (Exception e) {
										}
									} else if (split[0].contentEquals("Material Main Category")) {
										try {
//										wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//										.findElements(By.xpath("//tr[td[1][text()='"+split[1]+"'] and td[2][text()='"+split[2]+"']]"))));
										Thread.sleep(500);
										x = DriverIntialization.driver.findElements(By.xpath("//tr[td[1][text()='"
												+ split[1] + "'] and td[2][text()='" + split[2] + "']]")).size();
										}catch (Exception e) {
										}
									} else if (split[0].contentEquals("Supplier")) {
										try {
//										wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//										.findElements(By.xpath("//tr[td[1][text()='"+split[1]+"'] and td[2][text()='"+split[2]+"']and td[3][text()='"+split[3]+"']and td[4][text()='"+split[4]+"']]"))));
										Thread.sleep(500);
//										System.out.println("//tr[td[1][text()='"+ split[1] + "'] and td[2][text()='" + split[2] + "'] and td[3][text()='"+ split[3] + "'] and td[4][text()='" + split[4] + "']]");
										x = DriverIntialization.driver.findElements(By.xpath("//tr[td[1][text()='"
												+ split[1] + "'] and td[2][text()='" + split[2] + "'] and td[3][text()='"
												+ split[3] + "'] and td[4][text()='" + split[4] + "']]")).size();
										}catch (Exception e) {
										}
									} else {
										try {
//										wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//												.findElements(By.xpath("//td[1][text()='" + deleteElement + "']"))));
										Thread.sleep(500);
										x = DriverIntialization.driver
												.findElements(By.xpath("//td[1][text()='" + deleteElement + "']"))
												.size();
										}catch (Exception e) {
										}
									}
								counts = counts + x;
								
								try {
									n=DriverIntialization.driver.findElements(By.xpath("//tr[contains(@class,'ant-table-row')]/td[1]")).size();
								} catch (Exception e) {
									// TODO: handle exception
								}
								totalCount=totalCount+n;
								try {
									enabled = DriverIntialization.driver
											.findElement(By.xpath("//li[@title='Next Page']/button")).isEnabled();
//		        		Click Next page Button
									if (enabled) {

										DriverIntialization.driver
												.findElement(By.xpath("//li[@title='Next Page']/button")).click();
										Thread.sleep(1000);
//		        						wai.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//tr"))));
									}
								} catch (Exception e) {

								}
							}
							
							boolean tot=false;

							try {
								Assert.assertEquals(totalCount, total);
								tot=true;
							} catch (AssertionError e) {
								DriverIntialization.testCase = DriverIntialization.extent
										.createTest("Deleted Data Count");
								DriverIntialization.testCase.log(Status.INFO,
										"SuccessFully Data Deleted Count Wrong");
								
								// TODO: handle exception
							}
							
							System.out.println("**********" + counts);
							DriverIntialization.testCase = DriverIntialization.extent
									.createTest(deletetable + " :- " + deleteElement
											+ " - Deleted Value Check After Depend In " + deletetable + " Table");
							if (counts == 1 && tot==true) {
								DriverIntialization.testCase.log(Status.INFO, deletetable + " :- " + deleteElement
										+ " Deleted Check in " + deletetable + " Table");
								DriverIntialization.testCase.log(Status.INFO,
										deletetable + " :- " + deleteElement + " Depended");
								DriverIntialization.testCase.log(Status.INFO,
										"Deleted Value Founded In " + deletetable + " Table");
								DriverIntialization.testCase.log(Status.PASS,
										"So, Delete " + deletetable + " check After Depend Script Pass");
							} else {
								DriverIntialization.testCase.log(Status.INFO, deletetable + " :- " + deleteElement
										+ " Deleted Check in " + deletetable + " Table");
								DriverIntialization.testCase.log(Status.INFO,
										deletetable + " :- " + deleteElement + " Depended");
								DriverIntialization.testCase.log(Status.INFO,
										"Deleted Value Not In " + deletetable + " Table");
								DriverIntialization.testCase.log(Status.FAIL,
										"So, Deleted " + deletetable + " check After Depend Script Fail");
							}
							DriverIntialization.driver.navigate().refresh();
						} else {
							
							if(successMessage.contentEquals(deleteSuccessMessage)) {
								DriverIntialization.testCase = DriverIntialization.extent.createTest(
										deletetable + " :- " + deleteElement + " - Delete Success Message Before Depend");
								DriverIntialization.testCase.log(Status.INFO,
										"Actual Success Message :- " + successMessage);
								DriverIntialization.testCase.log(Status.INFO,
										"Expected Success Message :- " + deleteSuccessMessage);
								DriverIntialization.testCase.log(Status.PASS,
										"Success Message  Matching, So Throwing Success Message Pass");
							}else if (successMessage.contentEquals("Can't delete this module")) {
								DriverIntialization.testCase = DriverIntialization.extent.createTest(
										deletetable + " :- " + deleteElement + " - Delete Success Message After Depend");
								DriverIntialization.testCase.log(Status.INFO,
										"Actual Success Message :- " + successMessage);
								DriverIntialization.testCase.log(Status.INFO,
										"Expected Success Message :- " + "Can't delete this module");
								DriverIntialization.testCase.log(Status.PASS,
										"Success Message  Matching, So Throwing Success Message Pass");
							} else {
								DriverIntialization.testCase = DriverIntialization.extent.createTest(
										deletetable + " :- " + deleteElement + " - Delete Success Message");
								DriverIntialization.testCase.log(Status.INFO,
										"Actual Success Message :- " + successMessage);
								DriverIntialization.testCase.log(Status.INFO,
										"Expected Success Message :- " + deleteSuccessMessage);
								DriverIntialization.testCase.log(Status.FAIL,
										"Success Message Not Matching, So Throwing Success Message Fail");
							}
							DriverIntialization.testCase = DriverIntialization.extent
									.createTest(deletetable + " :- " + deleteElement + " - Delete Success Message");
							DriverIntialization.testCase.log(Status.FAIL,
									"Success Message Not Throwing, So Success Message Fail");

							try {
								wait.until(ExpectedConditions.elementToBeClickable(
										DriverIntialization.driver.findElement(By.xpath("//li[@title='1']/a"))));
								DriverIntialization.driver.findElement(By.xpath("//li[@title='1']/a")).click();
							} catch (Exception e) {
								// TODO: handle exception
							} 
							int counts = 0;
							int totalCount=0;
							boolean enabled = true;
							while (enabled) {
								WebDriverWait wai = new WebDriverWait(DriverIntialization.driver, 5);

								int x = 0;
								int n=0;
								try {
									if (split[0].contentEquals("Material Sub Category")) {
//											wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//													.findElements(By.xpath("//tr[td[1][text()='"+split[1]+"'] and td[3][text()='"+split[2]+"']]"))));
										Thread.sleep(500);
										x = DriverIntialization.driver.findElements(By.xpath("//tr[td[1][text()='"
												+ split[1] + "'] and td[3][text()='" + split[2] + "']]")).size();
									} else if (split[0].contentEquals("Material Sub Category")) {
//										wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//										.findElements(By.xpath("//tr[td[1][text()='"+split[1]+"'] and td[4][text()='"+split[2]+"']]"))));
										Thread.sleep(500);
										x = DriverIntialization.driver.findElements(By.xpath("//tr[td[1][text()='"
												+ split[1] + "'] and td[4][text()='" + split[2] + "']]")).size();
									} else if (split[0].contentEquals("Supplier")) {
//										wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//										.findElements(By.xpath("//tr[td[1][text()='" + split[1] + "'] and td[2][text()='" + split[2]
//										+ "'] | td[3][text()='" + split[3] + "'] | td[4][text()='" + split[4]
//										+ "']]"))));
										Thread.sleep(500);
										x = DriverIntialization.driver.findElements(By.xpath("//tr[td[1][text()='" + split[1] + "'] and td[2][text()='" + split[2]+ "'] and td[3][text()='" + split[3] + "'] and td[4][text()='" + split[4]
														+ "']]")).size();
										
									} else {
//									wai.until(ExpectedConditions.visibilityOfAllElements(DriverIntialization.driver
//											.findElements(By.xpath("//td[1][text()='" + deleteElement + "']"))));
										Thread.sleep(500);
										x = DriverIntialization.driver
												.findElements(By.xpath("//td[1][text()='" + deleteElement + "']"))
												.size();
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								counts = counts + x;
								
								try {
									n=DriverIntialization.driver.findElements(By.xpath("//tr[contains(@class,'ant-table-row')]/td[1]")).size();
								} catch (Exception e) {
									// TODO: handle exception
								}
								totalCount=totalCount+n;
								try {
									enabled = DriverIntialization.driver
											.findElement(By.xpath("//li[@title='Next Page']/button")).isEnabled();
//		        		Click Next page Button
									if (enabled) {

										DriverIntialization.driver
												.findElement(By.xpath("//li[@title='Next Page']/button")).click();
									}
								} catch (Exception e) {

								}

							}

							boolean deletot=false;

							try {
								Assert.assertEquals(totalCount, total-1);
								deletot=true;
							} catch (AssertionError e) {
								DriverIntialization.testCase = DriverIntialization.extent
										.createTest("Deleted Data Count");
								DriverIntialization.testCase.log(Status.INFO,
										"SuccessFully Data Deleted Count Wrong");
								
								// TODO: handle exception
							}
							boolean notdeletot=false;

							try {
								Assert.assertEquals(totalCount, total);
								notdeletot=true;
							} catch (AssertionError e) {
								DriverIntialization.testCase = DriverIntialization.extent
										.createTest("Deleted Data Count");
								DriverIntialization.testCase.log(Status.INFO,
										"SuccessFully Data Deleted Count Wrong");
								
								// TODO: handle exception
							}
							DriverIntialization.testCase = DriverIntialization.extent
									.createTest(deletetable + " :- " + deleteElement
											+ " - Deleted Value Check In " + deletetable + " Table");
							if (counts == 0 & deletot==true) { 
								DriverIntialization.testCase.log(Status.INFO, deleteElement + " Successfully deleted");
								DriverIntialization.testCase.log(Status.INFO, deletetable + " :- " + deleteElement
										+ " Deleted Check Not in " + deletetable + " Table");
								DriverIntialization.testCase.log(Status.INFO,
										deletetable + " :- " + deleteElement + " Not Depended");
								DriverIntialization.testCase.log(Status.INFO,
										"Deleted Value Not Founded In " + deletetable + " Table");
								DriverIntialization.testCase.log(Status.PASS,
										"So, Delete " + deletetable + " Script Pass");
							} if (counts == 1 && notdeletot==true) {
								DriverIntialization.testCase.log(Status.INFO,deleteElement + " Not Deleted");
								DriverIntialization.testCase.log(Status.INFO, deletetable + " :- " + deleteElement
										+ " Deleted Check in " + deletetable + " Table");
								DriverIntialization.testCase.log(Status.INFO,
										deletetable + " :- " + deleteElement + " Depended");
								DriverIntialization.testCase.log(Status.INFO,
										"Deleted Value Founded In " + deletetable + " Table");
								DriverIntialization.testCase.log(Status.PASS,
										"So, Delete " + deletetable + " Script Pass");
							}else {
								DriverIntialization.testCase.log(Status.INFO, " Delete Function Wronly Inplemented");
								DriverIntialization.testCase.log(Status.FAIL,
										"So, Deleted Function Fail");
							}
							DriverIntialization.driver.navigate().refresh();
						}

					}
				} 

			}
		} catch (Exception e) {
			DriverIntialization.driver.navigate().refresh();
			DriverIntialization.testCase = DriverIntialization.extent.createTest("Excel File Not Found");
			DriverIntialization.testCase.log(Status.INFO, "Excel File Not Found");
			DriverIntialization.testCase.log(Status.FAIL, "Excel File Not Found, So fail");
		}
	}
}
