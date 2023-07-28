//***********************************************************************************
//* Description
//*------------
//* Delivery Common Methods
//
// 1.DeliveryNavigatetoMiddle() ---- Priyanka Sundaramoorthy
// 2.DeliveryNavigatetoLast()   ---- Priyanka Sundaramoorthy
//
//***********************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 09/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        09/03/2023   Priyanka     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.delivery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.pages.master.DeliveryPage;
import com.qa.automation.qdms.pages.master.ProjectPage;

public class DeliveryMethod extends DriverIntialization {

	static int BeforeCount = 0;
	static int BefCount = 0;
	static boolean clickdeleteicon = false;
	public static boolean deliveryafterdeletion = false;
	static int test = 0;
	public static boolean clickAddButton = false;

	static DeliveryPage deliverypage = new DeliveryPage();

//****************************************************************************************
// Next page to Middle 
// ****************************************************************************************
	public static void DeliveryNavigatetoMiddle() {
		for (int i = 0; i < 13; i++) {
			try {
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				Thread.sleep(2000);
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.PAGE_UP).build().perform();
			} catch (Exception e) {
			}
		}
	}

// ****************************************************************************************
// Next page to Last
// ****************************************************************************************
	public static void DleiveryNavigatetoLast() throws InterruptedException {

		Thread.sleep(3000);
		CustomerPage.paginationlastpage.click();

// Scroll up by a page
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_UP).build().perform();
	}

	public static void DeliveryDesViewPopupSearch() throws InterruptedException, IOException {
		Thread.sleep(3000);
		String Name = "Testingneww";
		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[3]/div/span";
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

							testCase = extent.createTest("STEP-05-CHECKING VIEW ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");

							if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart))
									.isEnabled()) {

								testCase = extent.createTest("STEP-06-CHECKING VIEW ICON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");
								Thread.sleep(3000);
								driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
								Thread.sleep(2000);
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

	public static void DeliveryDesViewPopupValue() throws InterruptedException, IOException {

		String Actualvalue = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/p")).getText();

		System.out.println(Actualvalue);

		String ExpectedValue = "Textarea";

		testCase = extent.createTest("STEP-07 -DESCRIPTION POP UP VALUE CONFIRM");
		try {
			// ExpectedTextVisible=false;
			Assert.assertEquals(Actualvalue, ExpectedValue);
			testCase.log(Status.INFO, "Actual Visible :- " + Actualvalue);
			testCase.log(Status.INFO, "Expected Visible :- " + ExpectedValue);
			testCase.log(Status.PASS, " Correct");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualVisible :- " + Actualvalue);
			testCase.log(Status.INFO, "Expected Visible :- " + ExpectedValue);
			testCase.log(Status.FAIL, "Wrong");
		}

	}

	public static void DeliveryNavigateButton() throws InterruptedException, IOException {
		DeliveryPage deliverypage = new DeliveryPage();
		PageFactory.initElements(driver, deliverypage);

		Thread.sleep(2000);

		if (DeliveryPage.deliveryleftbutton.isDisplayed()) {

			testCase = extent.createTest("STEP-03- DELIVERY BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (DeliveryPage.deliveryleftbutton.isEnabled()) {
				testCase = extent.createTest("STEP-04--DELIVERY BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					DeliveryPage.deliveryleftbutton.click();

					// driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

					Thread.sleep(3000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest("STEP-04-- DELIVERY BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-03-- DELIVERY BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
	}

	public static void Deleteconfirm() throws InterruptedException {

		PageFactory.initElements(driver, deliverypage);

		String DataCountText = DeliveryPage.deliverypaginationcount.getText();

		String[] BeforeCount = DataCountText.split("of ");

		BefCount = Integer.parseInt(BeforeCount[1]);

		System.out.println("Final Count :" + BefCount);
	}

	public static void DeliveryDeletesearch(String colname, String colname1, String searchdata, String colname2)
			throws InterruptedException, IOException {

		Deleteconfirm();

		String Name = searchdata;
		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String DeleteXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String DeleteXpath_lastPart = "]/td[5]/span/a[2]/a/span";

		boolean clickNextPage = true;
		boolean sbuExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 102; i++) {
				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(Name)) {
						Thread.sleep(2000);
						sbuExist = true;
						if (driver.findElement(By.xpath(DeleteXpath_firstPart + i + DeleteXpath_lastPart))
								.isDisplayed()) {

							testCase = extent.createTest(colname + "CHECKING DELETE ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");

							if (driver.findElement(By.xpath(DeleteXpath_firstPart + i + DeleteXpath_lastPart))
									.isEnabled()) {

								testCase = extent.createTest(colname1 + "CHECKING DELETE ICON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");
								try {
									driver.findElement(By.xpath(DeleteXpath_firstPart + i + DeleteXpath_lastPart))
											.click();
								} catch (Exception e) {
									testCase = extent.createTest("Locate and Click On The Table Body");
									testCase.log(Status.INFO, "Unable to Locate Click on The Table Body");
									testCase.log(Status.FAIL, "TEST FAIL");
								}

								try {

									Thread.sleep(3000);

									DeliveryPage.deleteOkButton.click();

									Thread.sleep(2000);

									String Actualmessage = driver
											.findElement(By.xpath("//div[@class='ant-notification-notice-message']"))
											.getText();

									System.out.println("&$^*&^^^^^^^^^^^^^^^*:" + Actualmessage);

									testCase = extent.createTest("PROJECT DATA DELETED SUCCESFULLY");

									try {
										// ExpectedTextVisible=false;
										Assert.assertEquals(Actualmessage, colname2);
										testCase.log(Status.INFO, "Actual Visible :- " + Actualmessage);
										testCase.log(Status.INFO, "Expected Visible :- " + colname2);
										testCase.log(Status.PASS, " Correct");
									} catch (AssertionError e) {
										testCase.log(Status.INFO, "ActualVisible :- " + Actualmessage);
										testCase.log(Status.INFO, "Expected Visible :- " + colname2);
										testCase.log(Status.FAIL, "Wrong");
									}

									clickdeleteicon = true;
								}

								catch (Exception e) {
									testCase = extent.createTest("Locate and Click On The Table Body");
									testCase.log(Status.INFO, "Unable to Locate Click on The Table Body");
									testCase.log(Status.FAIL, "TEST FAIL");
								}

								Thread.sleep(2000);
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

	public static void deliveryAfterDeleteconfirm() throws InterruptedException {

		//// ---------------------------------------------------------------------------------------
		//// Count Number of elemenets before search
		//// ---------------------------------------------------------------------------------------

		String DataCountText = DeliveryPage.paginationCount.getText();

		System.out.println("Deliverypagination count :" + DataCountText);
		String[] AfterCount = DataCountText.split("of ");

		test = Integer.parseInt(AfterCount[1]);
		System.out.println("Final Count :" + AfterCount[1]);
		deliveryafterdeletion = true;

	}

	public static void deliveryDeleteEqu(String colname) {

		try {

			// System.out.println("IsVisible");
			System.out.println(BefCount + " !!!!!!!!!!!!!!1 " + (BefCount - 1));
			int aa = (BefCount - 1);
			System.out.println("Output is" + aa);
			testCase = extent.createTest(colname + "Checking count after deletion");

			try {
				// ExpectedTextVisible=false;
				Assert.assertEquals(aa, test);
				testCase.log(Status.INFO, "Actual Visible :- " + aa);
				testCase.log(Status.INFO, "Expected Visible :- " + test);
				testCase.log(Status.PASS, " Project deleted Succesfully");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualVisible :- " + aa);
				testCase.log(Status.INFO, "Expected Visible :- " + test);
				testCase.log(Status.FAIL, "Wrong");
			}
		} catch (Exception e) {
			testCase = extent.createTest("1-VISIBLE");
			testCase.log(Status.FAIL, "No element");
		}

	}

	public static void deliveryAddButton(String colname, String colname1) throws InterruptedException {
		PageFactory.initElements(driver, deliverypage);

		if (DeliveryPage.deliveryaddbtn.isDisplayed()) {
			testCase = extent.createTest(colname + "ADD BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (DeliveryPage.deliveryaddbtn.isEnabled()) {
				testCase = extent.createTest(colname1 + "ADD BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					DeliveryPage.deliveryaddbtn.click();
					clickAddButton = true;
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest(colname1 + "ADD BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest(colname + "ADD BUTTON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

	public static void sendValues(WebElement xpath, String excelData, String displayedReport, String enabledReport) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(xpath));
			if (xpath.isDisplayed()) {
				testCase = extent.createTest(displayedReport);
				testCase.log(Status.PASS, "TEST PASS ☑");
				if (xpath.isEnabled()) {
					testCase = extent.createTest(enabledReport);
					testCase.log(Status.PASS, "TEST PASS ☑");
					wait.until(ExpectedConditions.elementToBeClickable(xpath));
					xpath.click();
					xpath.sendKeys(excelData);
				} else {
					testCase = extent.createTest(enabledReport);
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest(displayedReport);
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT FOUND");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT FOUND OR CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void projectfield(String colname, String colname1, String colname2) throws InterruptedException {

		PageFactory.initElements(driver, deliverypage);
		if (DeliveryPage.ProjectField.isDisplayed()) {
			testCase = extent.createTest(colname1 + "DROP DOWN IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (DeliveryPage.ProjectField.isEnabled()) {
				testCase = extent.createTest(colname2 + "DROP DOWN IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				DeliveryPage.ProjectField.click();

				Thread.sleep(2000);
				DeliveryPage.ProjectField.sendKeys(colname);
				Thread.sleep(1000);
				DeliveryPage.ProjectField.sendKeys(Keys.ENTER);

			} else {
				testCase = extent.createTest(colname2 + "DROP DOWN IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname1 + "DROP DOWN IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void buttonClick(WebElement xpath, WebElement successmsg, String reportDisplay, String reportEnable,
			String whichElement, String excelmsg) throws InterruptedException, IOException {

		String success = "";
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.visibilityOf(xpath));
		} catch (Exception e) {
			testCase = extent.createTest("THE " + whichElement + " IS NOT FOUND");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
		if (xpath.isDisplayed()) {
			testCase = extent.createTest(reportDisplay);
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (xpath.isEnabled()) {
				testCase = extent.createTest(reportEnable);
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					wait.until(ExpectedConditions.elementToBeClickable(xpath));
					boolean x=xpath.isDisplayed();
					xpath.click();
					if(!x) {
					wait.until(ExpectedConditions.visibilityOf(successmsg));
					success = successmsg.getText();
					System.out.println("SUCCESS MESSAGE" + success);
					// wait.until(ExpectedConditions.visibilityOf(successmsg));

					System.out.println(excelmsg + "!!!!!!!!!!!!!!!!!!!!!!!11");
					testCase = extent.createTest(excelmsg);
					try {
						Assert.assertEquals(success, excelmsg);
						testCase.log(Status.INFO, excelmsg);
						testCase.log(Status.INFO, excelmsg);
						testCase.log(Status.PASS, excelmsg);
					} catch (Exception e) {
						testCase.log(Status.INFO, "Success Message Failed");
						testCase.log(Status.INFO, "Success Message Failed");
						testCase.log(Status.FAIL, "Success Message Failed");
					}
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("THERE IS NO ELEMENT");
					testCase.log(Status.INFO, "ELEMENT IS NOT FOUND");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				} catch (ElementClickInterceptedException e) {
					testCase = extent.createTest("THERE IS NO ELEMENT");
					testCase.log(Status.INFO, "ELEMENT IS NOT CLICKED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				} catch (Exception e) {
					testCase = extent.createTest("THERE IS NO ELEMENT");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-19--SAVE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-18--SAVE BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
	}

	public static void errorMessage() {

		PageFactory.initElements(driver, deliverypage);

		String errme = DeliveryPage.Deliveryvalidation.getText();
		if (errme == "") {
			errme = DeliveryPage.Projectvalidation.getText();

		}

		testCase = extent.createTest("THE VALIDATION MESSAGE IS APPEAR");
		testCase.log(Status.INFO, "THE VALIDATION MESSAGE IS : " + errme);
		testCase.log(Status.FAIL, "TEST FAIL ❎");
	}

	public static void confirmAdd(String data1) throws InterruptedException, IOException {
		PageFactory.initElements(driver, deliverypage);

		Thread.sleep(2000);

		String actualdata = DeliveryPage.tablecolumn.getText();
		System.out.println("First row of table : " + actualdata);

		boolean firstdata = true;
		testCase = extent.createTest("STEP-17.CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE");
		try {
			AssertJUnit.assertEquals(actualdata, data1);

		} catch (AssertionError e) {
			firstdata = false;
		}
		if (firstdata) {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + data1);
			testCase.log(Status.PASS, "Correct last data added in first row");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + data1);
			testCase.log(Status.FAIL, "Wrong Last Data Not Added in first row");
		}

	}

}
