package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;

public class Acceptedcriteria extends DriverIntialization {

	static String parameter = null;
	static String between = null;

	public static void Acceptedcriteriatest(String name, String ExcelTabName, String TestcaseId)
			throws IOException, InterruptedException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + name + ".xlsx";
		boolean Value1 = false;
		int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
		int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
		System.out.println(firstrow+"fffffffffffffffff");
		System.out.println(lastrow+"llllllllllllllllllll");
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(ExcelTabName);
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow rowk = sheet.getRow(i);

			parameter = rowk.getCell(1).getStringCellValue();
			
			String TEST = rowk.getCell(2).getStringCellValue();
			
			String between = rowk.getCell(3).getStringCellValue();
			String minimum = rowk.getCell(4).getStringCellValue();
			String maximum = rowk.getCell(5).getStringCellValue();
			String otherValue = rowk.getCell(6).getStringCellValue();
			String MATERIAL = rowk.getCell(7).getStringCellValue();
			
			String common = rowk.getCell(8).getStringCellValue();

			String condition = rowk.getCell(9).getStringCellValue();
			String mini1 = rowk.getCell(10).getStringCellValue();
			String maxi1 = rowk.getCell(11).getStringCellValue();
			String Valuem1 = rowk.getCell(12).getStringCellValue();

			String individual = rowk.getCell(13).getStringCellValue();

			String conditioni = rowk.getCell(14).getStringCellValue();
			String minii2 = rowk.getCell(15).getStringCellValue();
			String maxii2 = rowk.getCell(16).getStringCellValue();
			String Valuemi2 = rowk.getCell(17).getStringCellValue();

			String relevent = rowk.getCell(18).getStringCellValue();

			Thread.sleep(500);
			// WebElement list =
			// driver.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div/span"));
			//boolean Value1 = false;
			boolean isExist = false;
			// ******parameter**********
			try {
				WebElement id = driver
						.findElement(By.xpath("//div[@name='parameter']//div[@class='ant-select-selector']"));
				boolean value1 = id.isDisplayed();
			//	SampleCommonMethods.TestCasePrint("PARAMETER DROP DOWN IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("PARAMETER DROP DOWN IS ENABLED", "true", String.valueOf(value2));
				id.click();
				// *********************************************************
				Actions actions = new Actions(driver);
				try {
					boolean pass = false;
					Thread.sleep(500);

					for (int i1 = 0; i1 < 1000; i1++) {
						if (!pass) {
							try {
								WebElement list = driver
										.findElement(By.xpath("//div[contains(@title,'" + parameter + "')]//div[1]"));
								System.out.println(list+"kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
								list.click();

								pass = true;
							} catch (Exception e) {
							}
						}

						if (!pass) {
							actions.sendKeys(Keys.ARROW_DOWN).perform();
							Thread.sleep(2);
						} else {
							break;
						}

					}
				} catch (Exception e) {
				}
			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("PARAMETER DROP DOWN IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			// ******parameter end **********
			Thread.sleep(500);
			// ********TEST********
if (TEST.equalsIgnoreCase("true")) {
	

			try {
				WebElement id = driver.findElement(By.xpath("//input[contains(@value,'TEST')]"));
				boolean value1 = id.isDisplayed();
			//	SampleCommonMethods.TestCasePrint("TEST RADIO BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				if (i==firstrow) {
				SampleCommonMethods.TestCasePrint("TEST RADIO BUTTON IS ENABLED", "true", String.valueOf(value2));
				}
				if (i==(firstrow+1)) {
					SampleCommonMethods.TestCasePrint("TEST RADIO BUTTON IS ENABLED", "true", String.valueOf(value2));
					}
//				Thread.sleep(2000);
				boolean value3 = id.isSelected();
				String v3=String.valueOf(value3);
				if (i==firstrow) {
					SampleCommonMethods.TestCasePrint("TEST RADIO BUTTON IS SELECTED", "false", String.valueOf(v3));
					}
					if (i==(firstrow+1)) {
						SampleCommonMethods.TestCasePrint("TEST RADIO BUTTON IS SELECTED", "true", String.valueOf(v3));
						}
				if (TEST.equalsIgnoreCase(v3)) {

				}

				else {
					id.click();
				}

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("TEST RADIO BUTTON IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
}
			Thread.sleep(5000);
			String condition1 = null;

			if (TEST.equalsIgnoreCase("true")) {
				try {
					WebElement id = driver
							.findElement(By.xpath("//div[@name='condition']//div[@class='ant-select-selector']"));
					boolean value1 = id.isDisplayed();
			//		SampleCommonMethods.TestCasePrint("TEST RESULT CONDITION DROP DOWN IS DISPLAYED", "true", String.valueOf(value1));
					boolean value2 = id.isEnabled();
					SampleCommonMethods.TestCasePrint("TEST RESULT CONDITION DROP DOWN IS ENABLED", "true", String.valueOf(value2));
					id.click();

					Actions actions = new Actions(driver);
					try {
						boolean pass = false;
						Thread.sleep(500);

						for (int i1 = 0; i1 < 1000; i1++) {
							if (!pass) {
								try {
									WebElement list = driver
											.findElement(By.xpath("//div[contains(@title,'" + between + "')]//div[1]"));
									System.out.println(list);
									list.click();
									Thread.sleep(500);
									condition1 = list.getText();

									pass = true;
								} catch (Exception e) {
								}
							}

							if (!pass) {
								actions.sendKeys(Keys.ARROW_DOWN).perform();
								Thread.sleep(2);
							} else {
								break;
							}

						}
					} catch (Exception e) {
					}
				} catch (Exception e) {
					SampleCommonMethods.TestCasePrint("TEST RESULTS CONDITION DROP DOWN IS NOT THERE ", "true", String.valueOf(Value1),
							String.valueOf(e));

				}
				if (between.equalsIgnoreCase("Between")) {

					// *********minimum******
					Thread.sleep(3000);
					try {
						WebElement id = driver.findElement(By.id("minimum"));
						boolean value1 = id.isDisplayed();
				//		SampleCommonMethods.TestCasePrint("RESULT MINIMUM VALUE TEXT BOX IS DISPLAYED", "true",String.valueOf(value1));
						boolean value2 = id.isEnabled();
						SampleCommonMethods.TestCasePrint("RESULTS MINIMUM VALUE TEXT BOX IS ENABLED", "true", String.valueOf(value2));
						id.click();
						id.clear();
						id.sendKeys(minimum);

					} catch (Exception e) {
						SampleCommonMethods.TestCasePrint("RESULTS MINIMUM VALUE TEXT BOX IS NOT THERE ", "true",
								String.valueOf(Value1), String.valueOf(e));

					}
					// ******minimum end ******
					// *********maximum******
					Thread.sleep(500);
					try {
						WebElement id = driver.findElement(By.id("maximum"));
						boolean value1 = id.isDisplayed();
					//	SampleCommonMethods.TestCasePrint("RESULTS MAXIMUM VALUE TEXT BOX IS DISPLAYED", "true",String.valueOf(value1));
						boolean value2 = id.isEnabled();
						SampleCommonMethods.TestCasePrint("RESULTS MAXIMUM VALUE TEXT BOX IS ENABLED", "true", String.valueOf(value2));
						id.click();
						id.clear();
						id.sendKeys(maximum);

					} catch (Exception e) {
						SampleCommonMethods.TestCasePrint("RESULTS MAXIMUM VALUE TEXT BOX IS NOT THERE ", "true",
								String.valueOf(Value1), String.valueOf(e));

					}
					// ******max end****
				} else {
					Thread.sleep(500);
					try {
						WebElement id = driver.findElement(By.id("otherValue"));
						boolean value1 = id.isDisplayed();
				//		SampleCommonMethods.TestCasePrint("RESULT LIMIT VALUE TEXT BOX IS DISPLAYED", "true",String.valueOf(value1));
						boolean value2 = id.isEnabled();
						SampleCommonMethods.TestCasePrint("RESULT LIMIT VALUE TEXT BOX IS ENABLED", "true", String.valueOf(value2));
						id.click();
						id.clear();
						id.sendKeys(otherValue);

					} catch (Exception e) {
						SampleCommonMethods.TestCasePrint("RESULT LIMIT VALUE TEXT BOX IS NOT THERE ", "true",
								String.valueOf(Value1), String.valueOf(e));

					}

				}

			}
			Thread.sleep(500);

			// ****MATERIAL
			if (MATERIAL.equalsIgnoreCase("true")) {
			try {
				WebElement id = driver.findElement(By.xpath("//input[@value='MATERIAL']"));
				boolean value1 = id.isDisplayed();
			//	SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				if (i==firstrow) {
					SampleCommonMethods.TestCasePrint("TEST RADIO BUTTON IS ENABLED", "true", String.valueOf(value2));
					}
				if (i==(firstrow+1)) {
						SampleCommonMethods.TestCasePrint("TEST RADIO BUTTON IS ENABLED", "false", String.valueOf(value2));
						}
				Thread.sleep(2000);
				boolean value3 = id.isSelected();
				String v3 = String.valueOf(value3);
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS SELECTED", "false", String.valueOf(value3));
				if (MATERIAL.equalsIgnoreCase(v3)) {

				}

				else {
					id.click();
				}

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			}
			Thread.sleep(500);
			// ******material end ******
			if (MATERIAL.equalsIgnoreCase("true")) {
				try {
					WebElement id = driver.findElement(By.xpath("//input[@value='Common']"));
					boolean value1 = id.isDisplayed();
			//		SampleCommonMethods.TestCasePrint("COMMON WISE RADIO BUTTON IS DISPLAYED", "true", String.valueOf(value1));
					boolean value2 = id.isEnabled();
					SampleCommonMethods.TestCasePrint("COMMON WISE RADIO BUTTON IS ENABLED", "true", String.valueOf(value2));
					Thread.sleep(2000);
					boolean value3 = id.isSelected();
					String v3 = String.valueOf(value3);
			//		SampleCommonMethods.TestCasePrint("COMMON WISE RADIO BUTTON IS SELECTED", "true", String.valueOf(value3));
					if (common.equalsIgnoreCase(v3)) {

					}

					else {
						id.click();
					}

				} catch (Exception e) {
					SampleCommonMethods.TestCasePrint("COMMON WISE RADIO BUTTON IS NOT THERE ", "true", String.valueOf(Value1),
							String.valueOf(e));

				}
				Thread.sleep(500);
				// ********individual*****************
				if (MATERIAL.equalsIgnoreCase("true")) {
					try {
						WebElement id = driver.findElement(By.xpath("//input[@value='individual']"));
						boolean value1 = id.isDisplayed();
					//	SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RADIO BUTTON IS DISPLAYED", "true", String.valueOf(value1));
						boolean value2 = id.isEnabled();
						SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RADIO BUTTON IS ENABLED", "true", String.valueOf(value2));
						boolean value3 = id.isSelected();
						String v3 = String.valueOf(value3);
						SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RADIO BUTTON IS SELECTED", "false", String.valueOf(value3));
						if (individual.equalsIgnoreCase(v3)) {

						}

						else {
							id.click();
						}

					} catch (Exception e) {
						SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RADIO BUTTON IS NOT THERE ", "true", String.valueOf(Value1),
								String.valueOf(e));

					}
					Thread.sleep(500);
					// *********individual end*******************************
					if (common.equalsIgnoreCase("true")) {
						System.out.println(common +"//*********************");
						// ***********************common****************
						String conditionM = null;
						try {
							WebElement id = driver.findElement(By.xpath("//span[@title='Between']"));
							boolean value1 = id.isDisplayed();
					//		SampleCommonMethods.TestCasePrint("COMMON WISE RESULT CONDITION DROP DOWN IS DISPLAYED", "true",String.valueOf(value1));
							boolean value2 = id.isEnabled();
							SampleCommonMethods.TestCasePrint("COMMON WISE RESULT CONDITION DROP DOWN IS ENABLED", "true",
									String.valueOf(value2));
							Thread.sleep(500);
							id.click();

							Actions actions = new Actions(driver);
							try {
								boolean pass = false;
								Thread.sleep(500);

								for (int i1 = 0; i1 < 1000; i1++) {
									if (!pass) {
										try {
											WebElement list = driver.findElement(
													By.xpath("//div[contains(@title,'" + condition + "')]//div[1]"));
											System.out.println(list);
											list.click();
											Thread.sleep(2000);
											conditionM = list.getText();

											pass = true;
										} catch (Exception e) {
										}
									}

									if (!pass) {
										actions.sendKeys(Keys.ARROW_DOWN).perform();
										Thread.sleep(2);
									} else {
										break;
									}

								}
							} catch (Exception e) {
							}
						} catch (Exception e) {
							SampleCommonMethods.TestCasePrint("COMMON WISE RESULT CONDITION DROP DOWN IS NOT THERE ", "true",
									String.valueOf(Value1), String.valueOf(e));

						}
						if (conditionM.equalsIgnoreCase("Between")) {

							// *********minimum******
							Thread.sleep(500);
							try {
								WebElement id = driver.findElement(By.xpath("//input[@id='min']"));
								boolean value1 = id.isDisplayed();
							//	SampleCommonMethods.TestCasePrint("COMMON WISE RESULT MINIMUM LIMIT TEXT BOX IS DISPLAYED", "true",String.valueOf(value1));
								boolean value2 = id.isEnabled();
								SampleCommonMethods.TestCasePrint("COMMON WISE RESULT MINIMUM LIMIT TEXT BOX IS ENABLED", "true",
										String.valueOf(value2));
								id.click();
								id.clear();
								id.sendKeys(mini1);

							} catch (Exception e) {
								SampleCommonMethods.TestCasePrint("COMMON WISE RESULT MINIMUM LIMIT TEXT BOX IS NOT THERE ", "true",
										String.valueOf(Value1), String.valueOf(e));

							}
							// ******minimum end ******
							// *********maximum******
							Thread.sleep(500);
							try {
								WebElement id = driver.findElement(By.xpath("//input[@id='max']"));
								boolean value1 = id.isDisplayed();
							//	SampleCommonMethods.TestCasePrint("COMMON WISE RESULT MAXIMUM LIMIT TEXT BOX IS DISPLAYED", "true",String.valueOf(value1));
								boolean value2 = id.isEnabled();
								SampleCommonMethods.TestCasePrint("COMMON WISE RESULT MAXIMUM LIMIT TEXT BOX IS ENABLED", "true",
										String.valueOf(value2));
								id.click();
								id.clear();
								id.sendKeys(maxi1);

							} catch (Exception e) {
								SampleCommonMethods.TestCasePrint("COMMON WISE RESULT MAXIMUM LIMIT TEXT BOX IS NOT THERE ", "true",
										String.valueOf(Value1), String.valueOf(e));

							}
							// ******max end****
						} else {
							Thread.sleep(500);
							try {
								WebElement id = driver.findElement(By.xpath("//input[@id='value']"));
								boolean value1 = id.isDisplayed();
							//	SampleCommonMethods.TestCasePrint("COMMON WISE RESULT LIMIT TEXT BOX IS DISPLAYED", "true",String.valueOf(value1));
								boolean value2 = id.isEnabled();
								SampleCommonMethods.TestCasePrint("COMMON WISE RESULT LIMIT TEXT BOX IS ENABLED", "true",
										String.valueOf(value2));
								id.click();
								id.clear();
								id.sendKeys(Valuem1);

							} catch (Exception e) {
								SampleCommonMethods.TestCasePrint("COMMON WISE RESULT LIMIT TEXT BOX IS NOT THERE ", "true",
										String.valueOf(Value1), String.valueOf(e));

							}

						}

						// ***********************common end************

					}

					// ***********************indivual****************
					Thread.sleep(500);
					if (individual.equalsIgnoreCase("true")) {
					String conditionM = null;
					try {
						WebElement id = driver.findElement(By.xpath("//input[@id='condition']"));
						boolean value1 = id.isDisplayed();
					//	SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RESULT CONDITION DROP DOWN IS DISPLAYED", "true",String.valueOf(value1));
						boolean value2 = id.isEnabled();
						SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RESULT CONDITION DROP DOWN IS ENABLED", "true", String.valueOf(value2));
						id.click();
						Thread.sleep(500);

						Actions actions = new Actions(driver);
						try {
							boolean pass = false;
							Thread.sleep(1000);

							for (int i1 = 0; i1 < 1000; i1++) {
								if (!pass) {
									try {
										WebElement list = driver.findElement(
												By.xpath("//div[contains(@title,'" + conditioni + "')]//div[1]"));
										System.out.println(list);
										list.click();
										Thread.sleep(500);
										conditionM = list.getText();

										pass = true;
									} catch (Exception e) {
									}
								}

								if (!pass) {
									actions.sendKeys(Keys.ARROW_DOWN).perform();
									Thread.sleep(2);
								} else {
									break;
								}

							}
						} catch (Exception e) {
						}
					} catch (Exception e) {
						SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RESULT CONDITION DROP DOWN IS NOT THERE ", "true",
								String.valueOf(Value1), String.valueOf(e));

					}
					Thread.sleep(500);
					if (conditioni.equalsIgnoreCase("Between")) {

						// *********minimum******
						Thread.sleep(500);
						try {
							WebElement id = driver.findElement(By.xpath("//input[@id='min']"));
							boolean value1 = id.isDisplayed();
					//		SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RESULT MINIMUM LIMIT TEXT BOX IS DISPLAYED", "true",String.valueOf(value1));
							boolean value2 = id.isEnabled();
							SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RESULT MINIMUM LIMIT TEXT BOX IS ENABLED", "true",
									String.valueOf(value2));
							id.click();
							id.clear();
							id.sendKeys(minii2);

						} catch (Exception e) {
							SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RESULT MINIMUM LIMIT TEXT BOX IS NOT THERE ", "true",
									String.valueOf(Value1), String.valueOf(e));

						}
						// ******minimum end ******
						// *********maximum******
						Thread.sleep(500);
						try {
							WebElement id = driver.findElement(By.xpath("//input[@id='max']"));
							boolean value1 = id.isDisplayed();
						//	SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RESULT MAXIMUM LIMIT TEXT BOX IS DISPLAYED", "true",String.valueOf(value1));
							boolean value2 = id.isEnabled();
							SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RESULT MAXIMUM LIMIT TEXT BOX IS ENABLED", "true",
									String.valueOf(value2));
							id.click();
							id.clear();
							id.sendKeys(maxii2);

						} catch (Exception e) {
							SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RESULT MAXIMUM LIMIT TEXT BOX IS NOT THERE ", "true",
									String.valueOf(Value1), String.valueOf(e));

						}
						// ******max end****
					} else {
						Thread.sleep(500);
						try {
							WebElement id = driver.findElement(By.xpath("//input[@id='value']"));
							boolean value1 = id.isDisplayed();
					//		SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RESULT LIMIT TEXT BOX IS DISPLAYED", "true",String.valueOf(value1));
							boolean value2 = id.isEnabled();
							SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RESULT LIMIT TEXT BOX IS ENABLED", "true",
									String.valueOf(value2));
							id.click();
							id.clear();
							id.sendKeys(Valuemi2);

						} catch (Exception e) {
							SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RESULT LIMIT TEXT BOX IS NOT THERE ", "true",
									String.valueOf(Value1), String.valueOf(e));

						}

					}
					}

					// ***********************indiviual end************

				}

				// **********

				// **********

			}
			// ****relevent
			Thread.sleep(500);
			try {
				WebElement id = driver.findElement(By.xpath("//input[@id='isResult']"));
				boolean value1 = id.isDisplayed();
		//		SampleCommonMethods.TestCasePrint("RELEVANT TO RESULT RADIO BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("RELEVANT TO RESULT RADIO BUTTON IS ENABLED", "true", String.valueOf(value2));
				boolean value3 = id.isSelected();
				String v3 = String.valueOf(value3);
		//		SampleCommonMethods.TestCasePrint("RELEVANT TO RESULT RADIO BUTTON IS SELECTED", "false", String.valueOf(value3));
				if (relevent.equalsIgnoreCase(v3)) {

				}

				else {
					id.click();
				}

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("ACTIVE BUTTON IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			Thread.sleep(500);
			
			try {
				WebElement element= driver.findElement(By.xpath("//span[normalize-space()='Save']"));
				boolean value1 = element.isDisplayed();
		//		SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = element.isEnabled();
				SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS ENABLED", "true", String.valueOf(value2));
				element.click();
				Thread.sleep(500);
				
			

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS NOT THERE ", "true", String.valueOf(Value1), String.valueOf(e));

			}
		}
		
		
	}
}
