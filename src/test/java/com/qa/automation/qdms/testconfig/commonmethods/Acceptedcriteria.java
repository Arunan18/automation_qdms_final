package com.qa.automation.qdms.testconfig.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
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
	static DataFormatter dataValue=new DataFormatter();

	public static void Acceptedcriteriatest(String name, String ExcelTabName, String TestcaseId)
			throws IOException, InterruptedException {
		
			String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + name + ".xlsx";
		boolean Value1 = false;
		int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
		int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(ExcelTabName);
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow rowk = sheet.getRow(i);

			parameter = dataValue.formatCellValue(rowk.getCell(1));
			
			String TEST = dataValue.formatCellValue(rowk.getCell(2));
			
			String between = dataValue.formatCellValue(rowk.getCell(3));
			String minimum = dataValue.formatCellValue(rowk.getCell(4));
			String maximum = dataValue.formatCellValue(rowk.getCell(5));
			String otherValue = dataValue.formatCellValue(rowk.getCell(6));
			String MATERIAL = dataValue.formatCellValue(rowk.getCell(7));
			
			String common = dataValue.formatCellValue(rowk.getCell(8));

			String condition = dataValue.formatCellValue(rowk.getCell(9));
			String mini1 = dataValue.formatCellValue(rowk.getCell(10));
			String maxi1 = dataValue.formatCellValue(rowk.getCell(11));
			String Valuem1 = dataValue.formatCellValue(rowk.getCell(12));

			String individual = dataValue.formatCellValue(rowk.getCell(13));

			String conditioni = dataValue.formatCellValue(rowk.getCell(14));
			String minii2 = dataValue.formatCellValue(rowk.getCell(15));
			String maxii2 = dataValue.formatCellValue(rowk.getCell(16));
			String Valuemi2 = dataValue.formatCellValue(rowk.getCell(17));

			String relevent = dataValue.formatCellValue(rowk.getCell(18));

			Thread.sleep(3000);
			// WebElement list =
			// driver.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div/span"));
			//boolean Value1 = false;
			boolean isExist = false;
			// ******parameter**********
			try {
				WebElement id = driver
						.findElement(By.xpath("//div[@name='parameter']//div[@class='ant-select-selector']"));
				boolean value1 = id.isDisplayed();
				SampleCommonMethods.TestCasePrint("PARAMETER DROP DOWN IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("PARAMETER DROP DOWN IS ENABLED", "true", String.valueOf(value2));
				id.click();
				// *********************************************************
				Actions actions = new Actions(driver);
				try {
					boolean pass = false;
					Thread.sleep(1000);

					for (int i1 = 0; i1 < 1000; i1++) {
						if (!pass) {
							try {
								WebElement list = driver
										.findElement(By.xpath("//div[contains(@title,'" + parameter + "')]//div[1]"));
								System.out.println(list);
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
			Thread.sleep(5000);
			// ********TEST********

			try {
				WebElement id = driver.findElement(By.xpath("//input[contains(@value,'TEST')]"));
				boolean value1 = id.isDisplayed();
				SampleCommonMethods.TestCasePrint("TEST RADIO BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("TEST RADIO BUTTON IS ENABLED", "true", String.valueOf(value2));
				Thread.sleep(2000);
				boolean value3 = id.isSelected();
				String v3=String.valueOf(value3);
				SampleCommonMethods.TestCasePrint("TEST RADIO BUTTON IS SELECTED", "false", String.valueOf(value3));
				if (TEST.equals(v3)) {

				}

				else {
					id.click();
				}

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("TEST RADIO BUTTON IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			Thread.sleep(5000);
			String condition1 = null;

			if (TEST.equals("true")) {
				try {
					WebElement id = driver
							.findElement(By.xpath("//div[@name='condition']//div[@class='ant-select-selector']"));
					boolean value1 = id.isDisplayed();
					SampleCommonMethods.TestCasePrint("TEST RESULT CONDITION DROP DOWN IS DISPLAYED", "true", String.valueOf(value1));
					boolean value2 = id.isEnabled();
					SampleCommonMethods.TestCasePrint("TEST RESULT CONDITION DROP DOWN IS ENABLED", "true", String.valueOf(value2));
					id.click();

					Actions actions = new Actions(driver);
					try {
						boolean pass = false;
						Thread.sleep(1000);

						for (int i1 = 0; i1 < 1000; i1++) {
							if (!pass) {
								try {
									WebElement list = driver
											.findElement(By.xpath("//div[contains(@title,'" + between + "')]//div[1]"));
									System.out.println(list);
									list.click();
									Thread.sleep(2000);
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
				if (between.equals("Between")) {

					// *********minimum******
					Thread.sleep(3000);
					try {
						WebElement id = driver.findElement(By.id("minimum"));
						boolean value1 = id.isDisplayed();
						SampleCommonMethods.TestCasePrint("RESULT MINIMUM VALUE TEXT BOX IS DISPLAYED", "true",
								String.valueOf(value1));
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
					Thread.sleep(3000);
					try {
						WebElement id = driver.findElement(By.id("maximum"));
						boolean value1 = id.isDisplayed();
						SampleCommonMethods.TestCasePrint("RESULTS MAXIMUM VALUE TEXT BOX IS DISPLAYED", "true",
								String.valueOf(value1));
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
					Thread.sleep(3000);
					try {
						WebElement id = driver.findElement(By.id("otherValue"));
						boolean value1 = id.isDisplayed();
						SampleCommonMethods.TestCasePrint("RESULT LIMIT VALUE TEXT BOX IS DISPLAYED", "true",
								String.valueOf(value1));
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
			Thread.sleep(3000);

			// ****MATERIAL
			try {
				WebElement id = driver.findElement(By.xpath("//input[@value='MATERIAL']"));
				boolean value1 = id.isDisplayed();
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS ENABLED", "true", String.valueOf(value2));
				Thread.sleep(2000);
				boolean value3 = id.isSelected();
				String v3 = String.valueOf(value3);
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS SELECTED", "false", String.valueOf(value3));
				if (MATERIAL.equals(v3)) {

				}

				else {
					id.click();
				}

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("MATERIAL RADIO BUTTON IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			Thread.sleep(3000);
			// ******material end ******
			if (MATERIAL.equals("true")) {
				try {
					WebElement id = driver.findElement(By.xpath("//input[@value='Common']"));
					boolean value1 = id.isDisplayed();
					SampleCommonMethods.TestCasePrint("COMMON WISE RADIO BUTTON IS DISPLAYED", "true", String.valueOf(value1));
					boolean value2 = id.isEnabled();
					SampleCommonMethods.TestCasePrint("COMMON WISE RADIO BUTTON IS ENABLED", "true", String.valueOf(value2));
					Thread.sleep(2000);
					boolean value3 = id.isSelected();
					String v3 = String.valueOf(value3);
					SampleCommonMethods.TestCasePrint("COMMON WISE RADIO BUTTON IS SELECTED", "true", String.valueOf(value3));
					if (common.equals(v3)) {

					}

					else {
						id.click();
					}

				} catch (Exception e) {
					SampleCommonMethods.TestCasePrint("COMMON WISE RADIO BUTTON IS NOT THERE ", "true", String.valueOf(Value1),
							String.valueOf(e));

				}
				Thread.sleep(3000);
				// ********individual*****************
				if (MATERIAL.equals("true")) {
					try {
						WebElement id = driver.findElement(By.xpath("//input[@value='individual']"));
						boolean value1 = id.isDisplayed();
						SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RADIO BUTTON IS DISPLAYED", "true", String.valueOf(value1));
						boolean value2 = id.isEnabled();
						SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RADIO BUTTON IS ENABLED", "true", String.valueOf(value2));
						boolean value3 = id.isSelected();
						String v3 = String.valueOf(value3);
						SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RADIO BUTTON IS SELECTED", "false", String.valueOf(value3));
						if (individual.equals(v3)) {

						}

						else {
							id.click();
						}

					} catch (Exception e) {
						SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RADIO BUTTON IS NOT THERE ", "true", String.valueOf(Value1),
								String.valueOf(e));

					}
					Thread.sleep(3000);
					// *********individual end*******************************
					if (common.equals("true")) {
						System.out.println(common +"//*********************");
						// ***********************common****************
						String conditionM = null;
						try {
							WebElement id = driver.findElement(By.xpath("//span[@title='Between']"));
							boolean value1 = id.isDisplayed();
							SampleCommonMethods.TestCasePrint("COMMON WISE RESULT CONDITION DROP DOWN IS DISPLAYED", "true",
									String.valueOf(value1));
							boolean value2 = id.isEnabled();
							SampleCommonMethods.TestCasePrint("COMMON WISE RESULT CONDITION DROP DOWN IS ENABLED", "true",
									String.valueOf(value2));
							Thread.sleep(3000);
							id.click();

							Actions actions = new Actions(driver);
							try {
								boolean pass = false;
								Thread.sleep(1000);

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
						if (conditionM.equals("Between")) {

							// *********minimum******
							Thread.sleep(3000);
							try {
								WebElement id = driver.findElement(By.xpath("//input[@id='min']"));
								boolean value1 = id.isDisplayed();
								SampleCommonMethods.TestCasePrint("COMMON WISE RESULT MINIMUM LIMIT TEXT BOX IS DISPLAYED", "true",
										String.valueOf(value1));
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
							Thread.sleep(3000);
							try {
								WebElement id = driver.findElement(By.xpath("//input[@id='max']"));
								boolean value1 = id.isDisplayed();
								SampleCommonMethods.TestCasePrint("COMMON WISE RESULT MAXIMUM LIMIT TEXT BOX IS DISPLAYED", "true",
										String.valueOf(value1));
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
							Thread.sleep(3000);
							try {
								WebElement id = driver.findElement(By.xpath("//input[@id='value']"));
								boolean value1 = id.isDisplayed();
								SampleCommonMethods.TestCasePrint("COMMON WISE RESULT LIMIT TEXT BOX IS DISPLAYED", "true",
										String.valueOf(value1));
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
					Thread.sleep(3000);
					if (individual.equals("true")) {
					String conditionM = null;
					try {
						WebElement id = driver.findElement(By.xpath("//input[@id='condition']"));
						boolean value1 = id.isDisplayed();
						SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RESULT CONDITION DROP DOWN IS DISPLAYED", "true",
								String.valueOf(value1));
						boolean value2 = id.isEnabled();
						SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RESULT CONDITION DROP DOWN IS ENABLED", "true", String.valueOf(value2));
						id.click();
						Thread.sleep(1000);

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
						SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RESULT CONDITION DROP DOWN IS NOT THERE ", "true",
								String.valueOf(Value1), String.valueOf(e));

					}
					Thread.sleep(3000);
					if (conditioni.equals("Between")) {

						// *********minimum******
						Thread.sleep(3000);
						try {
							WebElement id = driver.findElement(By.xpath("//input[@id='min']"));
							boolean value1 = id.isDisplayed();
							SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RESULT MINIMUM LIMIT TEXT BOX IS DISPLAYED", "true",
									String.valueOf(value1));
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
						Thread.sleep(3000);
						try {
							WebElement id = driver.findElement(By.xpath("//input[@id='max']"));
							boolean value1 = id.isDisplayed();
							SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RESULT MAXIMUM LIMIT TEXT BOX IS DISPLAYED", "true",
									String.valueOf(value1));
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
						Thread.sleep(3000);
						try {
							WebElement id = driver.findElement(By.xpath("//input[@id='value']"));
							boolean value1 = id.isDisplayed();
							SampleCommonMethods.TestCasePrint("INDIVIDUAL WISE RESULT LIMIT TEXT BOX IS DISPLAYED", "true",
									String.valueOf(value1));
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
			Thread.sleep(3000);
			try {
				WebElement id = driver.findElement(By.xpath("//input[@id='isResult']"));
				boolean value1 = id.isDisplayed();
				SampleCommonMethods.TestCasePrint("RELEVANT TO RESULT RADIO BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = id.isEnabled();
				SampleCommonMethods.TestCasePrint("RELEVANT TO RESULT RADIO BUTTON IS ENABLED", "true", String.valueOf(value2));
				boolean value3 = id.isSelected();
				String v3 = String.valueOf(value3);
				SampleCommonMethods.TestCasePrint("RELEVANT TO RESULT RADIO BUTTON IS SELECTED", "false", String.valueOf(value3));
				if (relevent.equals(v3)) {

				}

				else {
					id.click();
				}

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("ACTIVE BUTTON IS NOT THERE ", "true", String.valueOf(Value1),
						String.valueOf(e));

			}
			Thread.sleep(3000);
			
			try {
				WebElement element= driver.findElement(By.xpath("//span[normalize-space()='Save']"));
				boolean value1 = element.isDisplayed();
				SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS DISPLAYED", "true", String.valueOf(value1));
				boolean value2 = element.isEnabled();
				SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS ENABLED", "true", String.valueOf(value2));
				element.click();
				Thread.sleep(3000);
				
			

			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS NOT THERE ", "true", String.valueOf(Value1), String.valueOf(e));

			}
		}
		
	}
}
