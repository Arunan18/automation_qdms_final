package com.qa.automation.qdms.testconfig.testcases.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class DeleteMethod  extends DriverIntialization{
	static String tobedelete  ="";
	public static String datacount ="";
	public static String message  ="";
	
	static String tobedeleteDepend  ="";
	public static String datacountDepend ="";
	public static String messageDepend  ="";
	// delete excel

			public static void Deleteselect() throws InterruptedException, IOException {

				FileInputStream file = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet("Test");
				int rowcount = sheet.getLastRowNum();

				int firstrow = CommonMethods.getFirstRowNum(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx", "Test",
						"TC-TST-0003");
				int lastrow = CommonMethods.getLastRowNum(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx", "Test",
						"TC-TST-0003");

				for (int i = firstrow; i <= lastrow; i++) {
					XSSFRow row = sheet.getRow(i);
					String tobedelete = (String) row.getCell(1).getStringCellValue();
					System.out.println("tobedelete"+tobedelete);
					message = (String) row.getCell(2).getStringCellValue();
					datacount = (String) row.getCell(3).getStringCellValue();
				}
			
			}
					
			public static void deleteElement() throws InterruptedException {
				Thread.sleep(3000);
				try {
					Thread.sleep(3000);
					if (driver.findElement(By.xpath("//td[text()='" + tobedelete
							+ "']//following-sibling::td[1]//span[@class='anticon anticon-delete']")).isDisplayed()) {

						Thread.sleep(3000);
						testCase = extent.createTest("DELETE ICON DISPLY");
						testCase.log(Status.PASS, "TEST PASS ☑");

						if (driver.findElement(By.xpath("//td[text()='" + tobedelete
								+ "']//following-sibling::td[1]//span[@class='anticon anticon-delete']")).isEnabled()) {
							testCase = extent.createTest("DELETE ICON ENABLE");
							testCase.log(Status.PASS, "TEST PASS ☑");

							try {
								driver.findElement(By.xpath("//td[text()='" + tobedelete
										+ "']//following-sibling::td[1]//span[@class='anticon anticon-delete']")).click();

							} catch (Exception e) {

							}

						} else {
							testCase = extent.createTest("ELEMENT IS NOT ENABLE");
							testCase.log(Status.FAIL, "TEST FAIL ❎");
						}
					} else {
						testCase = extent.createTest("ELEMENT IS NOT DISPLY");
						testCase.log(Status.FAIL, "TEST FAIL ❎");

					}
				} catch (Exception e) {
					testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			}
	
			public static void deleteConfirm() throws InterruptedException {

					String Searchdata = tobedelete;

					Thread.sleep(3000);
					TestConfigPage.SearchTestIcon.click();
					Thread.sleep(3000);

					TestConfigPage.SearchTestTextBox.sendKeys(tobedelete);
                System.out.println(" tobedlelte"+tobedelete);
					TestConfigPage.SearchTestTextBox.sendKeys(Keys.ENTER);

					Thread.sleep(3000);
					TestConfigPage.SearchTestSearchbutton.click();

					Thread.sleep(3000);
					String ActualData = TestConfigPage.SearchTestTextBox.getAttribute("value");
					System.out.println("TEXTBOX DELETE DATA : " + ActualData);
					String ExpectedData = "No Data";

					testCase = extent.createTest("VERIFY THE DELETE FUCNTION");
					AssertJUnit.assertNotSame(ActualData, ExpectedData);
					try {
						testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
						testCase.log(Status.INFO, "Expectedvalue :- " + ExpectedData);
						testCase.log(Status.INFO, "the value is not available");
						testCase.log(Status.PASS, ActualData);
					} catch (Exception e) {
						testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
						testCase.log(Status.INFO, "ExpectedValue :- " + ExpectedData);
						testCase.log(Status.INFO, "the value is available");
						testCase.log(Status.FAIL, ActualData);

					}

				}

			
					
				public static void Deleteselectafterdepend() throws InterruptedException, IOException {

					FileInputStream file = new FileInputStream(
							System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
					XSSFWorkbook workbook = new XSSFWorkbook(file);
					XSSFSheet sheet = workbook.getSheet("Test");
					int rowcount = sheet.getLastRowNum();

					int firstrow = CommonMethods.getFirstRowNum(
							System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx", "Test",
							"TC-TST-0018");
					int lastrow = CommonMethods.getLastRowNum(
							System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx", "Test",
							"TC-TST-0018");

					for (int i = firstrow; i <= lastrow; i++) {
						XSSFRow row = sheet.getRow(i);
						String tobedeleteDepend = (String) row.getCell(1).getStringCellValue();
						messageDepend = (String) row.getCell(2).getStringCellValue();
						System.out.println("messageDepend"+messageDepend);
						datacountDepend = (String) row.getCell(3).getStringCellValue();
						System.out.println("datacountDepend"+datacountDepend);
					}
				
				}
					
				
			}
		

