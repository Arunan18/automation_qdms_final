package com.qa.automation.qdms.testconfig.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;

public class AcceeptedCretiaStep extends DriverIntialization {

	static String acceptedType = null;
	static String CommonIndividual = null;
	static String commonCondition = null;
	static String[] splitEquation = null;
	static boolean nullPoint = false;
	static String[] splitByComma = null;
	static String[] splitBySpace = null;
	static int n = 2;
	static String conditionText = null;
	static boolean check1 = true;
	public static boolean acepc=false;
	static int x=0;
	static DataFormatter dataValue=new DataFormatter();

	@Test
	public static void accepted(String workBookName, String ExcelTabName, String TestcaseId) throws IOException, InterruptedException {
		
			Thread.sleep(1500);
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + workBookName + ".xlsx";
		int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
		int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(ExcelTabName);
		for (int i = firstrow; i <= lastrow; i++) {
			x=i;
			XSSFRow rowk = sheet.getRow(i);
			String resultParameterName = dataValue.formatCellValue(rowk.getCell(1));
			acceptedType = dataValue.formatCellValue(rowk.getCell(2));
			String relevantToResult1 = dataValue.formatCellValue(rowk.getCell(3));
			boolean relevantToResult=Boolean.valueOf(relevantToResult1);
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!! " + resultParameterName + " *****************"+firstrow+" "+lastrow);
			try {
				WebElement parameterDropDown = driver.findElement(By.xpath(
						"//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU jKPlV']/div[1]/div[1]/div[1]/div/div[1]/div/span[1]/input"));
				parameterDropDown.click();
				Thread.sleep(2000);
			} catch (Exception e) {
				WebElement clear = driver.findElement(By.xpath(
						"//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU jKPlV']/div[1]/div[1]/div[1]/div/div[1]/span[2]"));
				clear.click();
				WebElement parameterDropDown = driver.findElement(By.xpath(
						"//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU jKPlV']/div[1]/div[1]/div[1]/div/div[1]/div/span[1]/input"));
				parameterDropDown.click();
				Thread.sleep(2000);
			}
			boolean Y=false;
			List<WebElement> param = driver
					.findElements(By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[1]/div/div"));
			int paraCount = param.size();
			System.err.println("***************" + paraCount + "  " + firstrow + "  " + lastrow);
//			result parameter select
			for (int j = 1; j <= paraCount; j++) {
				WebElement paraName = driver
						.findElement(By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[1]/div[" + j + "]/div"));
				String ParameterName = paraName.getText().replaceAll(" ", "");
				Thread.sleep(500);
				System.out.println(ParameterName + "*" + resultParameterName);
				if (ParameterName.contains(resultParameterName)) {

					paraName.click();
					Y=true;
				}
			}
			Thread.sleep(1500);

//			accepted type click
			if (acceptedType.contains("Test")) {
				WebElement test = driver.findElement(
						By.xpath("//div[@class='ant-radio-group ant-radio-group-outline']/span/label/span[1]/input"));
				test.click();
			} else if (acceptedType.contains("Material")) {
				WebElement material = driver.findElement(
						By.xpath("//div[@class='ant-radio-group ant-radio-group-outline']/label/span[1]/input"));
				material.click();
			}
Thread.sleep(1500);
//			relevant to result click
			WebElement check = driver.findElement(By.xpath(
					"//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU jKPlV']/div[1]/div[1]/div[3]/div/label[2]/span/input"));
			boolean checkBox = check.isSelected();
			System.out.println(checkBox + " " + relevantToResult);
			if (checkBox != relevantToResult) {
				check.click();
			}
			
		

		if (acceptedType.contains("Test")) {
//			for (int i1 = firstrow; i1 <= lastrow; i1++) {1
				XSSFRow rowk1 = sheet.getRow(x);
				String resultParameterName1 = dataValue.formatCellValue(rowk1.getCell(4));
				splitEquation = resultParameterName1.split(" ");
				int count = splitEquation.length;

//				Test wise Between , grather
				if (count == 3) {

					WebElement condition = driver.findElement(By.xpath(
							"//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU jKPlV']/div[1]/div[3]/div[1]/div"));
					condition.click();
					if (splitEquation[1].contains("-")) {
						WebElement between = driver
								.findElement(By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div[4]/div"));
						between.click();
					}
					WebElement min = driver.findElement(By.xpath(
							"//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU jKPlV']/div[1]/div[3]/div[2]/div/div/div[1]/div/input"));
					min.sendKeys(splitEquation[0]);
					WebElement max = driver.findElement(By.xpath(
							"//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU jKPlV']/div[1]/div[3]/div[2]/div/div/div[3]/div/input"));
					max.sendKeys(splitEquation[2]);
				} else if (count == 2) {
					WebElement condition = driver.findElement(By.xpath(
							"//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU jKPlV']/div[1]/div[3]/div[1]/div"));
					condition.click();
					if (splitEquation[0].contains(">=")) {
						WebElement between = driver
								.findElement(By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div[1]/div"));
						between.click();
					} else if (splitEquation[0].contains("<=")) {
						WebElement between = driver
								.findElement(By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div[2]/div"));
						between.click();
					} else if (splitEquation[0].contains("=")) {
						WebElement between = driver
								.findElement(By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div[3]/div"));
						between.click();
					}

					WebElement min = driver.findElement(By.xpath(
							"//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU jKPlV']/div[1]/div[3]/div[2]/div/div/input"));
					min.sendKeys(splitEquation[1]);

				}
//			}
     
			WebElement save = driver.findElement(By.xpath(
					"//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU jKPlV']/div[1]/div[6]/button"));
			save.click();
		} else if (acceptedType.contains("Material")) {
//			for (int i1 = firstrow; i1 <= lastrow; i1++) {
				XSSFRow rowk1 = sheet.getRow(x);
				CommonIndividual = dataValue.formatCellValue(rowk1.getCell(4));
//				accepted type click
				Thread.sleep(200);
				if (CommonIndividual.contains("Common")) {
					WebElement Common = driver.findElement(By.xpath(
							"//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU jKPlV']/div[1]/div[2]/div[2]/div[1]/label[1]/span[1]/input"));
					Common.click();
				} else if (CommonIndividual.contains("Individual")) {
					WebElement Individual = driver.findElement(By.xpath(
							"//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU jKPlV']/div[1]/div[2]/div[2]/div[1]/label[2]/span[1]/input"));
					Individual.click();
				}

//			}
			if (CommonIndividual.contains("Common")) {

//				for (int i1 = firstrow; i1 <= lastrow; i1++) {1
					XSSFRow rowk11 = sheet.getRow(i);
//					Condition for Commen wise

					for (int k = 5; k <= 20; k++) {

						try {
							commonCondition = dataValue.formatCellValue(rowk11.getCell(k));
							String condition = dataValue.formatCellValue(rowk11.getCell(5));
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
//						System.out.println(i1 + " " + k);

						System.out.println(commonCondition);
						// Splitting the string by comma
						splitByComma = commonCondition.split(",");

						// Splitting the second element of the previous split by space
						splitBySpace = splitByComma[1].trim().split(" ");

						System.out.println(splitByComma.length);
						System.out.println(splitBySpace.length);
						String[] splitByComma1 = commonCondition.split(",");
						String[] splitBySpace1 = splitByComma1[1].trim().split(" ");
						if (check1) {
							if (splitBySpace.length == 3) {
								conditionText = splitBySpace1[1];
								check1 = false;
							} else if (splitBySpace.length == 2) {
								conditionText = splitBySpace1[0];
								check1 = false;
							}

							WebElement cond = driver.findElement(By.xpath(
									"//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU jKPlV']/div[1]/div[3]/div[1]/div/div/div"));
							cond.click();
							Thread.sleep(1000);

							if (commonCondition.contains(">=") || commonCondition.contains("Greater than or Equal")) {
								WebElement grather = driver.findElement(
										By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div[1]/div"));
								grather.click();
							} else if (commonCondition.contains("<=")
									|| commonCondition.contains("Less than or Equal")) {
								WebElement less = driver.findElement(
										By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div[2]/div"));
								less.click();
							} else if (commonCondition.contains("=") || commonCondition.contains("Equal")) {
								WebElement equal = driver.findElement(
										By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div[3]/div"));
								equal.click();
							} else if (commonCondition.contains("-") || commonCondition.contains("Between")) {
								WebElement between = driver.findElement(
										By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div[4]/div"));
								between.click();
							}
						}
						if (splitBySpace1.length == 3) {
							Actions actions = new Actions(driver);
							try {
								boolean pass = false;
								Thread.sleep(1000);

								for (int i11 = 0; i11 < 1000; i11++) {
									if (!pass) {
										try {
											WebElement min = driver.findElement(By.xpath("//td[text()='"
													+ splitByComma[0] + "']/following-sibling::td//input[@id='min']"));
											min.click();
											min.sendKeys(splitBySpace[0]);
											WebElement max = driver.findElement(By.xpath("//td[text()='"
													+ splitByComma[0] + "']/following-sibling::td//input[@id='max']"));
											max.click();
											max.sendKeys(splitBySpace[2]);
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

						} else if (splitBySpace1.length == 2) {
							Actions actions = new Actions(driver);
							try {
								boolean pass = false;
								Thread.sleep(1000);

								for (int i11 = 0; i11 < 1000; i11++) {
									if (!pass) {
										try {
											WebElement value = driver
													.findElement(By.xpath("//td[text()='" + splitByComma[0]
															+ "']/following-sibling::td//input[@id='value']"));
											value.click();

											value.sendKeys(splitBySpace[1]);

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

//							
						}
					}
//				}
				WebElement save = driver.findElement(By.xpath(
						"//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU jKPlV']/div[1]/div[6]/button"));
				save.click();
				acepc=true;
			} else if (CommonIndividual.contains("Individual")) {
System.err.println("66666666666666666666");
//				for (int i1 = firstrow; i1 <= lastrow; i1++) {1
					XSSFRow rowk11 = sheet.getRow(x);
//					Condition for Commen wise
					Thread.sleep(1500);
					List<WebElement> count=driver.findElements(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr/td[1]"));
					
					for (int k = 5; k <= 20; k++) {

						try {
							commonCondition = dataValue.formatCellValue(rowk11.getCell(k));
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
					
						// Splitting the string by comma
						splitByComma = commonCondition.split(",");

						// Splitting the second element of the previous split by space
						splitBySpace = splitByComma[1].trim().split(" ");

						System.out.println(splitByComma.length);
						System.out.println(splitBySpace.length);

						Thread.sleep(500);
						System.out.println("COUNT :- "+count.size());
						for(int y=2; y<=count.size(); y++) {
						Thread.sleep(300);
							
							WebElement mate=driver.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr["+y+"]/td[1]"));
							String materialName=mate.getText();
							System.out.println(materialName+"*"+splitByComma[0]);
							if(materialName.contains(splitByComma[0])) {
								WebElement condition=driver.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr["+y+"]/td[2]/div"));
								condition.click();
								
								if(splitBySpace.length == 3) {
									WebElement between=driver.findElement(By.xpath("(//div[@class='rc-virtual-list-holder-inner'])["+n+"]/div[4]"));
									Thread.sleep(300);
									between.click();
								WebElement min=driver.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr["+y+"]/td[3]/div/div/div[1]/span/input"));
								min.sendKeys(splitBySpace[0]);
								WebElement max=driver.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr["+y+"]/td[3]/div/div/div[2]/span/input"));
								max.sendKeys(splitBySpace[2]);
								break;
								
								} else if (splitBySpace.length == 2) {
									
									if (splitBySpace[0].contains(">=") || splitBySpace[0].contains("Greater than or Equal")) {
									WebElement grather = driver.findElement(By.xpath("(//div[@class='rc-virtual-list-holder-inner'])["+n+"]/div[1]"));
									Thread.sleep(300);
									grather.click();
								} else if (splitBySpace[0].contains("<=")|| splitBySpace[0].contains("Less than or Equal")) {
									WebElement less = driver.findElement(By.xpath("(//div[@class='rc-virtual-list-holder-inner'])["+n+"]/div[2]"));
									Thread.sleep(300);
									less.click();
								} else if (splitBySpace[0].contains("=")|| splitBySpace[0].contains("Equal")) {
									WebElement equal = driver.findElement(By.xpath("(//div[@class='rc-virtual-list-holder-inner'])["+n+"]/div[3]"));
									Thread.sleep(300);
									equal.click();
								}
								
									WebElement value=driver.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr["+y+"]/td[3]/div/input"));
									value.sendKeys(splitBySpace[1]);
									break;
								}
							}
						}
						System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
						n=n+1;
					}
						WebElement save = driver.findElement(By.xpath(
								"//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU jKPlV']/div[1]/div[6]/button"));
						save.click();
						acepc=true;
						n=2;
						Thread.sleep(2000);
						nullPoint=false;
						
//						if (splitBySpace.length == 3) {
//							System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
//							Actions actions = new Actions(driver);
//							try {
//								boolean pass = false;
//								Thread.sleep(1000);
//
//								for (int i11 = 0; i11 < 1000; i11++) {
//									if (!pass) {
//										try {
//											WebElement condition = driver
//													.findElement(By.xpath("//td[text()='" + splitByComma[0]
//															+ "']/following-sibling::td//input[@id='condition']"));
//											condition.click();
//											System.out.println("***********" + splitBySpace[1]);
//
//											if (splitBySpace[1].contains("-") || splitBySpace[1].contains("Between")) {
//												WebElement between = driver.findElement(
//														By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[" + n
//																+ "]/div[4]/div"));
//												between.click();
//											}
//
//											WebElement min = driver.findElement(By.xpath("//td[text()='"
//													+ splitByComma[0] + "']/following-sibling::td//input[@id='min']"));
//											min.click();
//											min.sendKeys(splitBySpace[0]);
//											WebElement max = driver.findElement(By.xpath("//td[text()='"
//													+ splitByComma[0] + "']/following-sibling::td//input[@id='max']"));
//											max.click();
//											max.sendKeys(splitBySpace[2]);
//											pass = true;
//										} catch (Exception e) {
//										}
//									}
//
//									if (!pass) {
//										actions.sendKeys(Keys.ARROW_DOWN).perform();
//										Thread.sleep(2);
//									} else {
//										break;
//									}
//
//								}
//							} catch (Exception e) {
//							}
//
////						} else if (splitBySpace.length == 2) {
////							System.out.println("&&&&&&&&&&&&&&&&&&&&&&&");
////							Actions actions = new Actions(driver);
////							try {
////								boolean pass = false;
////								Thread.sleep(1000);
////
////								for (int i11 = 0; i11 < 1000; i11++) {
////									if (!pass) {
////										try {
////											WebElement condition = driver
////													.findElement(By.xpath("//td[text()='" + splitByComma[0]
////															+ "']/following-sibling::td//input[@id='condition']"));
////											condition.click();
////											System.out.println("***********" + splitBySpace[0]);
////											if (splitBySpace[0].contains(">=")
////													|| splitBySpace[0].contains("Greater than or Equal")) {
////												WebElement grather = driver.findElement(
////														By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[" + n
////																+ "]/div[1]/div"));
////												grather.click();
////											} else if (splitBySpace[0].contains("<=")
////													|| splitBySpace[0].contains("Less than or Equal")) {
////												WebElement less = driver.findElement(
////														By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[" + n
////																+ "]/div[2]/div"));
////												less.click();
////											} else if (splitBySpace[0].contains("=")
////													|| splitBySpace[0].contains("Equal")) {
////												WebElement equal = driver.findElement(
////														By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[" + n
////																+ "]/div[3]/div"));
////												equal.click();
////											}
////											WebElement value = driver
////													.findElement(By.xpath("//td[text()='" + splitByComma[0]
////															+ "']/following-sibling::td//input[@id='value']"));
////											value.click();
////											value.sendKeys(splitBySpace[1]);
////
////											pass = true;
////										} catch (Exception e) {
////										}
////									}
////
////									if (!pass) {
////										actions.sendKeys(Keys.ARROW_DOWN).perform();
////										Thread.sleep(2);
////									} else {
////										break;
////									}
////
////								}
////							} catch (Exception e) {
////							}
////
//////							
//						}
//						n = n + 1;
//					}
//				}
				
			}
		}
		}
	}
}