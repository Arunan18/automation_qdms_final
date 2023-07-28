package com.qa.automation.qdms.testcases.source;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class SourceMethod extends DriverIntialization {

	public static boolean inputValue = false;
	public static boolean clickSaveBtn = false;
	public static String source = null;
	public static String searchdata = null;
	public static String updatedata = null;
	public static String SuccessMsg = null;
	public static boolean beforeeditting = false;
	public static String validation = null;
	public static boolean BtnVisible = true;
	public static boolean BtnEnable = true;
	static DataFormatter dataValue = new DataFormatter();

	static String sourceName = "";

	static SourcePage sourcepage = new SourcePage();

	public static void editSource(String excelName, String tabName, String testCaseId) {
		PageFactory.initElements(driver, sourcepage);
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + excelName + ".xlsx";
		int firstrow = CommonMethods.getFirstRowNum(excelPath, tabName, testCaseId);
		int lastrow = CommonMethods.getLastRowNum(excelPath, tabName, testCaseId);
		try {
			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(tabName);
			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);
				String editsource = dataValue.formatCellValue(row.getCell(1));
				String editdes = dataValue.formatCellValue(row.getCell(2));
				String newsource = dataValue.formatCellValue(row.getCell(3));
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
						WebElement source = driver.findElement(By.xpath("//tbody/tr[" + k + "]/td[1]"));
						String sour = source.getText();
						System.out.println("Source name : " + sour + " " + editsource);
						if (sour.contentEquals(editsource)) {
							WebElement editElement = driver.findElement(
									By.xpath("//td[text()='" + editsource + "']/following-sibling::td[2]/span/a[1]"));
							MultiSearchMethods.icon(editElement, editsource + " Edit ");
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
						next = SourcePage.NextPageBtn.isEnabled();
						if (next) {
							SourcePage.NextPageBtn.click();
							Thread.sleep(1000);
						}
					} catch (Exception e) {
					}
				}
				if (check == false) {
					testCase = extent.createTest("Searched Element Not There");
					testCase.log(Status.INFO, "Searched data : " + editsource);
					testCase.log(Status.FAIL, "Searched Data Not In WebTable");
				}
				boolean save = false;
				boolean input = false;

				if (check) {
					Thread.sleep(2000);
					MultiSearchMethods.textBox(SourcePage.sourcetextbox, "Source");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						Thread.sleep(1000);
						testCase = extent.createTest("Source Data Confirm Before Edit");
						try {
							Assert.assertEquals(SourcePage.sourcetextbox.getAttribute("value"), editsource);
							testCase.log(Status.INFO,
									"SOURCE Field Actual Data : " + SourcePage.sourcetextbox.getAttribute("value"));
							testCase.log(Status.INFO, "SOURCE Field Expected Data : " + editsource);
							testCase.log(Status.PASS, "Expected and Actual are matching, So Pass");
						} catch (AssertionError e) {
							testCase.log(Status.INFO,
									"SOURCE Field Actual Data : " + SourcePage.sourcetextbox.getAttribute("value"));
							testCase.log(Status.INFO, "SOURCE Field Expected Data : " + editsource);
							testCase.log(Status.FAIL, "Expected and Actual are not matching, So Fail");
						} catch (Exception e) {
							testCase.log(Status.INFO,
									"SOURCE Field Actual Data : " + SourcePage.sourcetextbox.getAttribute("value"));
							testCase.log(Status.INFO, "SOURCE Field Expected Data : " + editsource);
							testCase.log(Status.FAIL, "Expected and Actual are not matching, So Fail");
						}
						SourcePage.sourcetextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
						SourcePage.sourcetextbox.sendKeys(newsource);
						input = true;
					}

					MultiSearchMethods.textBox(SourcePage.sourceDescFied, "Description ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						Thread.sleep(1000);
						testCase = extent.createTest("Description Data Confirm Before Edit");
						try {
							Assert.assertEquals(SourcePage.sourceDescFied.getAttribute("value"), editdes);
							testCase.log(Status.INFO,
									"SOURCE Field Actual Data : " + SourcePage.sourceDescFied.getAttribute("value"));
							testCase.log(Status.INFO, "SOURCE Field Expected Data : " + editdes);
							testCase.log(Status.PASS, "Expected and Actual are matching, So Pass");
						} catch (AssertionError e) {
							testCase.log(Status.INFO,
									"SBU Field Actual Data : " + SourcePage.sourceDescFied.getAttribute("value"));
							testCase.log(Status.INFO, "SOURCE Field Expected Data : " + editdes);
							testCase.log(Status.FAIL, "Expected and Actual are not matching, So Fail");
						} catch (Exception e) {
							testCase.log(Status.INFO,
									"SBU Field Actual Data : " + SourcePage.sourceDescFied.getAttribute("value"));
							testCase.log(Status.INFO, "SOURCE Field Expected Data : " + editdes);
							testCase.log(Status.FAIL, "Expected and Actual are not matching, So Fail");
						}
						SourcePage.sourceDescFied.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
						SourcePage.sourceDescFied.sendKeys(newdes);
						input = true;
					}

					if (input) {
						MultiSearchMethods.Button(SourcePage.Updatebtn, "SOURCE Update");
						if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
							WebDriverWait wait = new WebDriverWait(driver, 10);
							wait.until(ExpectedConditions.elementToBeClickable(SourcePage.Updatebtn));
							SourcePage.Updatebtn.click();
							save = true;
						}
					}
				}
				boolean saveCheck = false;
				if (save) {
					try {
						Thread.sleep(1500);
						Assert.assertEquals(SourcePage.Updatebtn.isDisplayed(), true);
						saveCheck = true;
						System.out.println("WWWWWWWWWWWWWWWWWWWW" + saveCheck);
					} catch (Exception e) {
						saveCheck = false;
					} catch (AssertionError e) {
						saveCheck = false;
					}
				}
				System.out.println("WWWWWWWWWWWWWWWWWWWW***********" + saveCheck);
				if (saveCheck) {
					System.out.println("WWWWWWWWWWWWWWWWWWWW" + saveCheck);
					validation = SourcePage.SourceFieldValidation.getText();
					validation(newsource);
					testCase = extent.createTest("Update Source Function");
					if (exit) {
						testCase.log(Status.INFO, "Validation Throwing");
						testCase.log(Status.FAIL, "Update Source Function is Fail");
					}

				} else {
					String updateSuccessMsg = "Source Updated Successfully";
					testCase = extent.createTest("SOURCE :- " + editsource + " - Updating Success Message");
					try {
						Assert.assertEquals(SourcePage.AddSourcesuccessmsg.getText(), updateSuccessMsg);
						testCase.log(Status.INFO,
								"Actual Success Message :- " + SourcePage.AddSourcesuccessmsg.getText());
						testCase.log(Status.INFO, "Expected Success Message :- " + updateSuccessMsg);
						testCase.log(Status.PASS, "Success Message  Matching, So Throwing Success Message Pass");
						try {
							SourcePage.cancelbutton.click();
						} catch (Exception e) {
							// TODO: handle exception
						}
					} catch (AssertionError e) {
						testCase.log(Status.INFO,
								"Actual Success Message :- " + SourcePage.AddSourcesuccessmsg.getText());
						testCase.log(Status.INFO, "Expected Success Message :- " + updateSuccessMsg);
						testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
					} catch (Exception e) {
						testCase.log(Status.INFO,
								"Actual Success Message :- " + SourcePage.AddSourcesuccessmsg.getText());
						testCase.log(Status.INFO, "Expected Success Message :- " + updateSuccessMsg);
						testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
					}

					testCase = extent.createTest("SOURCE :- " + sourceName + " - Updated Value Check In First Row");

					try {
						Assert.assertEquals(SourcePage.firstRowData.getText(), newsource);
						testCase.log(Status.INFO, "SBU :- " + newsource + " Updated Check in First Row");
						testCase.log(Status.INFO, "Added Value Founded In First Row");
						testCase.log(Status.PASS, "So, Add SOURCE Script Pass");

					} catch (Exception e) {
						testCase.log(Status.INFO, "SOURCE :- " + newsource + " Updated Check in First Row");
						testCase.log(Status.INFO, "Added Value Not Founded In First Row");
						testCase.log(Status.FAIL, "So, Add SOURCE Script Fail");
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

	static boolean exit = false;

	public static void validation(String source) {

		if (validation.contains("Source can't be empty")) {
			testCase = extent.createTest("Empty Validation Throwing");
			try {
				String val = SourcePage.sourcetextbox.getAttribute("value");
				testCase = extent.createTest("Empty Validation Confirmation For SOURCE :- " + source);
				if (val == "") {
					exit = false;
					testCase.log(Status.INFO, "SOURCE Data is :- " + val);
					testCase.log(Status.INFO, "SOURCE Data is Empty");
					testCase.log(Status.PASS, "So, Empty Validation Correct");
					exit = true;
				} else {
					testCase.log(Status.INFO, "SOURCE Data is :- " + val);
					testCase.log(Status.INFO, "SOURCE Data is not Empty");
					testCase.log(Status.PASS, "So, Empty Validation Wrong");

				}
			} catch (Exception e) {

			}
			driver.navigate().refresh();
		} else if (validation.contains("Source already exists")) {
			testCase = extent.createTest("Already Exists Validation Throwing For SOURCE :- " + source);
			driver.navigate().refresh();
			boolean checkValue = false;

			boolean enable = true;
			while (enable) {

				int x = 0;
				try {
					WebDriverWait wai = new WebDriverWait(driver, 5);
					wai.until(ExpectedConditions.visibilityOfAllElements(
							driver.findElements(By.xpath("//td[1][text()='" + source + "']"))));
					x = driver.findElements(By.xpath("//td[1][text()='" + source + "']")).size();
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (x == 1) {
					checkValue = true;
					break;
				}
				try {
					enable = SourcePage.NextPageBtn.isEnabled();
//		Click Next page Button
					if (enable) {

						SourcePage.NextPageBtn.click();
//						WebDriverWait wait = new WebDriverWait(driver, 20);
//						wait.until(ExpectedConditions
//								.visibilityOfAllElements(driver.findElements(By.xpath("//tr"))));
					}
				} catch (Exception e) {

				}

			}
			testCase = extent.createTest("Already Exists Validation Confirmation For SOURCE :- " + source);
			if (checkValue) {
				exit = false;
				testCase.log(Status.INFO, "SOURCE :- " + source + " Already Exits in SOURCE Table");
				testCase.log(Status.INFO, "SOURCE :- " + source + " Founded In SOURCE Table");
				testCase.log(Status.PASS, "So, Already Exists Validation Correct");
				exit = true;
			} else {
				testCase.log(Status.INFO, "SBU :- " + source + " Not in SOURCE Table");
				testCase.log(Status.INFO, "Added Value Not Founded In SOURCE Table");
				testCase.log(Status.FAIL, "So, System  Fail");
			}

		} else if (validation.contains("Only 3 characters long!")) {
			testCase = extent.createTest("Added Data Lenth Not Match Validation Throwing");

			try {
				String val = SourcePage.sourcetextbox.getAttribute("value");
				int length = val.length();
				testCase = extent.createTest("Lenth Not Match Validation Confirmation For SOURCE :- " + sourceName);
				if (length <= 3) {
					exit = false;
					testCase.log(Status.INFO, "SOURCE Lenth is:- " + length);
					testCase.log(Status.INFO, "SOURCE Lenth is grater than 3");
					testCase.log(Status.PASS, "So, Lenth Not Match Validation Correct");
					exit = true;
				} else {
					testCase.log(Status.INFO, "SOURCE Lenth is:- " + length);
					testCase.log(Status.PASS, "So, Lenth Not Match Validation Wrong");

				}
			} catch (Exception e) {

			}

			driver.navigate().refresh();
		} else if (validation.contains("Source allow only letters")) {
			testCase = extent.createTest("Wrong Characters Validation Throwing");

			try {
				String val = SourcePage.sourcetextbox.getAttribute("value");
				boolean result = areAllLetters(val);
				testCase = extent.createTest("Wrong Characters Validation Confirmation For SOURCE :- " + source);
				if (result == false) {
					exit = false;
					testCase.log(Status.INFO, "SOURCE Name is:- " + val);
					testCase.log(Status.INFO, "SOURCE Having Correct Format Letters");
					testCase.log(Status.PASS, "So, Wrong Characters Validation Correct");
					exit = true;
				} else {
					testCase.log(Status.INFO, "SOURCE Name is:- " + val);
					testCase.log(Status.INFO, "SOURCE");
					testCase.log(Status.PASS, "So, LWrong Characters Validation Wrong");

				}
			} catch (Exception e) {

			}
			driver.navigate().refresh();
		} else {
			testCase = extent.createTest("Any Validation Not Throwing");
			testCase.log(Status.INFO, "SOURCE Added Fail");
			testCase.log(Status.FAIL, "Validation Not Throwing, So SOURCE Added Fail");
			driver.navigate().refresh();
		}
	}

	public static void search(String colname) throws InterruptedException, IOException {
		beforeeditting = false;
		Thread.sleep(3000);
		String Name = colname;
		String NameXpath_firstPart = "//tbody[@class='ant-table-tbody']/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[3]/span/a[1]/span";
		// *[@id="root"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[6]/td[9]/span/a/span
		boolean clickNextPage = true;
		boolean sbuExist = false;
		Thread.sleep(3000);
		while (clickNextPage) {
			for (int i = 2; i < 102; i++) {
				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(Name)) {
						sbuExist = true;
						if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).isDisplayed()) {

							testCase = extent.createTest("STEP-01-CHECKING EDIT ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");

							if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart))
									.isEnabled()) {

								testCase = extent.createTest("STEP-02-CHECKING EDIT ICON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");
								try {
									driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();

									beforeeditting = true;

								} catch (NoSuchElementException e) {
									testCase = extent.createTest("Locate the ' Source Edit Icon'");
									testCase.log(Status.INFO, "Unable to Locate 'Source Edit Icon'");
									testCase.log(Status.FAIL, "TEST FAIL ❎");
								} catch (ElementClickInterceptedException e) {
									testCase = extent.createTest("Click on the 'Source Edit Icon'");
									testCase.log(Status.INFO, "Unable to Click on 'Source Edit Icon'");
									testCase.log(Status.FAIL, "TEST FAIL ❎");
								} catch (Exception e) {
									testCase = extent.createTest("Locate and Click on the 'Source Edit Icon'");
									testCase.log(Status.INFO, "Unable to Locate and Click on 'Source Edit Icon'");
									testCase.log(Status.FAIL, "TEST FAIL ❎");
								}
								clickNextPage = false;
								break;
							} else {
								testCase.log(Status.FAIL, "TEST FAIL ❎");
								System.out.println("Button NOT Enabled");
							}
						} else {
							testCase.log(Status.FAIL, "TEST FAIL ❎");
							System.out.println("Button NOT Displayed");
						}

					}
				} catch (Exception e) {
				}
			}
			if (clickNextPage == true) {
				clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				Thread.sleep(2000);
			} else {
				break;
			}
		}
		if (sbuExist = false) {
			System.out.println("No such Element" + sbuExist);
		}

	}

	public static void beforeEdit(String colname) throws InterruptedException, IOException {

		PageFactory.initElements(driver, sourcepage);

		try {
			String Value = SourcePage.sourcetextbox.getAttribute("value");

			TestCasePrint("STEP-03--CONFIRM BEFORE THE EDIT", colname, String.valueOf(Value));
		} catch (Exception e) {
			TestCasePrint("STEP-03--CONFIRM BEFORE THE EDIT", colname, String.valueOf(e));
		}

	}

	public static boolean areAllLetters(String word) {
		return word.matches("[a-zA-Z]+");
	}

	public static void TestCasePrint(String TestCaseName, Object expectedValue, Object actualValue) {
		boolean position = true;

		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			position = false;
		}
		if (position) {
			testCase.log(Status.INFO, "Actual value: " + actualValue.toString());
			testCase.log(Status.INFO, "Expected value: " + expectedValue.toString());
			testCase.log(Status.PASS, "TEST PASS ☑");
		} else {
			testCase.log(Status.INFO, "Actual value: " + actualValue.toString());
			testCase.log(Status.INFO, "Expected value: " + expectedValue.toString());
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

}
