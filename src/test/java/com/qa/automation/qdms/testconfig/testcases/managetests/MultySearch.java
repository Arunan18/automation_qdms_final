//***********************************************************************************
//* Description
//*------------
//* MULTY SEARCH FOR GROUP TEST
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-006			 28/04/2023   Gobithan     Orginal Version
//* 
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleMultisearchMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleSingleSearchMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class MultySearch extends DriverIntialization {

	static SampleCommonMethods methods = new SampleCommonMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static ManageTestsPage managepage = new ManageTestsPage();
	static SampleMultisearchMethods multysearch = new SampleMultisearchMethods();
	static Logout logout = new Logout();

	static boolean testdata = true;

	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, methods);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, managepage);
		PageFactory.initElements(driver, multysearch);

		/* LOGIN */
		LoginTest.Login();

		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				testnav.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		/* MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES",
				testnav.MANGECONFIGURE, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", testnav.GroupTest, testnav.managetest,
				"03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* MANAGE TEST PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TEST PROPERTIES", testnav.managetest,
				"01--MANAGE TEST LEFT NAVIGATION BUTTON DISPLAYED", "02--MANAGE TEST LEFT NAVIGATION BUTTON ENABLED",
				managepage.managetestheading, " Manage Test Configuration",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");

		MultySearch.multiSearch("Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-006-01",
				ManageTestsPage.tablecontainernew, 1);

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}

	/**
	 * @author Quenthan
	 * @param webook :-Excel Book Name
	 * @param tab    :-Excel Sheet Name
	 * @param uniqId :-Test Case Id
	 * @param table  :-Webelement Table
	 * @param step   :-Step
	 */
	public static void multiSearch(String webook, String tab, String uniqId, WebElement table, int step) {
		Actions actions = new Actions(driver);
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;
int hg=1;
		int multi = 0;
		String Tatal = null;
		WebElement relaventTable = table;
		try {
			filelocation = "./src/test/resources/Excel/" + webook;

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			// fileIn.close();

		} catch (Exception e) {

		}

		PropertiesCommonMethods.excalRowCount(webook, tab, uniqId);
		int I = PropertiesCommonMethods.countRow - 1;
		int j = 3;

		for (int d = 0; d < 50; d++) {
			XSSFSheet sheet = wbook.getSheet(tab);
			row = sheet.getRow(I + 1);
			cell = row.getCell(2);
			Tatal = dataValue.formatCellValue(cell);
			row = sheet.getRow(I);
			cell = row.getCell(j);
			String heding = dataValue.formatCellValue(cell);
			row = sheet.getRow(I + 1);
			cell = row.getCell(j);
			String searchData = dataValue.formatCellValue(cell);
			if (searchData == "") {
				break;
			}
			System.out.println(searchData);
			row = sheet.getRow(I + 2);
			cell = row.getCell(j);
			String searchIcon = dataValue.formatCellValue(cell);
			row = sheet.getRow(I + 3);
			cell = row.getCell(j);
			String df = dataValue.formatCellValue(cell);
			int searchDataColumn = Integer.parseInt(df);
			row = sheet.getRow(I + 4);
			cell = row.getCell(j);
			String expacted = dataValue.formatCellValue(cell);

			row = sheet.getRow(I + 5);
			cell = row.getCell(j);
			String side = dataValue.formatCellValue(cell);

			row = sheet.getRow(I + 6);
			cell = row.getCell(j);
			String sType = dataValue.formatCellValue(cell);

			j = j + 1;
			int corrct = 0;
			driver.findElement(By.xpath("(//td[contains(@class,'ant-table-cell')])[1]")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e2) {
			}
			boolean pass = true;
			while (pass == true) {
				try {
					int se = searchDataColumn + 1;
					driver.findElement(By.xpath("(//span[contains(@class,'anticon-search')]/..)[" + se + "]")).click();
					pass = false;
				} catch (Exception e) {
				}
				if (pass == true) {
					if (side.equals("L")) {
						driver.findElement(By.xpath("(//td[contains(@class,'ant-table-cell')])[1]")).click();
						actions.sendKeys(Keys.ARROW_LEFT).perform();
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
						}
					} else {
						driver.findElement(By.xpath("(//td[contains(@class,'ant-table-cell')])[1]")).click();
						actions.sendKeys(Keys.ARROW_RIGHT).perform();
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
						}
					}
				}
			}
			try {
				Thread.sleep(800);
			} catch (InterruptedException e3) {
			}

			Boolean seacr = true;

			while (seacr == true) {
				try {

					if (sType.equals("D")) {
						Thread.sleep(500);
						driver.findElement(By.xpath("(//*[@class='ant-table-filter-dropdown']/div/div/div)["+hg+"]"))
								.click();
						Thread.sleep(500);
						driver.findElement(By.xpath("//div[text()='" + searchData + "']")).click();
						Thread.sleep(500);
						seacr = false;
						hg=hg+1;
					} else {
						Thread.sleep(500);
						driver.findElement(By.xpath("(//*[@class='ant-input'])[" + searchIcon + "]")).click();
						Thread.sleep(500);
						driver.findElement(By.xpath("(//*[@class='ant-input'])[" + searchIcon + "]"))
								.sendKeys(searchData);
						Thread.sleep(500);
						seacr = false;
					}

				} catch (Exception e) {
					if (seacr == true) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e1) {
						}
						driver.findElement(By.xpath("(//td[contains(@class,'ant-table-cell')])[1]")).click();
						actions.sendKeys(Keys.ARROW_UP).perform();
						int se = searchDataColumn + 1;
						driver.findElement(By.xpath("(//span[contains(@class,'anticon-search')]/..)[" + se + "]"))
								.click();

					}
				}
			}

			try {
				Thread.sleep(500);
				driver.findElement(By.xpath("(//span[text()='Search']/..)[" + searchIcon + "]")).click();
			} catch (Exception e) {
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e3) {
			}
			try {
				driver.findElement(By.xpath("//a[text()='1']/..")).click();
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
			int num1 = 0;
			corrct = 0;
			int counte = 0;
			boolean nextPage = true;
			String colum_2 = null;
			List<WebElement> allrows1 = null;
			while (nextPage == true) {
				{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
					}
					allrows1 = driver.findElements(By.cssSelector("tbody tr"));
					num1 = allrows1.size();
					try {
						nextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
								.isEnabled();
					} catch (Exception e) {
						nextPage = false;
					}
					System.out.println(nextPage);

					for (int i = 1; i < num1; i++) {
						List<WebElement> rows1 = allrows1.get(i).findElements(By.tagName("td"));

						if (sType.equals("D")) {
							try {
								String no = searchData.toUpperCase();
								String str = driver.findElement(By.xpath("//*[text()='" + no + "']")).getText();
								counte = counte + 1;

								if (str.contains(no)) {
									corrct = corrct + 1;
								}
							} catch (Exception e) {
							}
						} else {
							try {
								colum_2 = rows1.get(searchDataColumn).getText();
								counte = counte + 1;
								String bn = colum_2.toUpperCase();
								String st = searchData.toUpperCase();
								if (bn.contains(st)) {
									corrct = corrct + 1;
								}
							} catch (Exception e) {
							}
						}
					}
				}
				if (nextPage == true) {
					try {
						driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
					} catch (Exception e) {
						// TODO: handle exception
					}
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
					}
				}
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			PropertiesCommonMethods.cTestReports("Step-" + step + "--" + heding + " Column Single Search",
					"Data Count:-" + expacted + " & Matching Search Count:-" + expacted,
					"Data Count:-" + counte + " & Matching Search Count:-" + corrct, heding + "Columm");
			step = step + 1;
			Object c1 = null;
			Object c2 = null;
			String c1s = null;
			String c2s = null;
			c1 = counte;
			c1s = c1.toString();
			c2 = corrct;
			c2s = c2.toString();

			if (expacted.equals(c1s) & expacted.equals(c2s)) {
				multi = multi + 1;
			}
		}
		Object io = j - 3;
		String jk = io.toString();
		PropertiesCommonMethods.cTestReports("Step-" + step + "--" + "Multi Search Fianl Report", jk, multi,
				"Multi Search");

		driver.findElement(By.xpath("//*[text()='Reset All']/..")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		ActionCommonMethod.countDataTable(relaventTable);
		step = step + 1;
		Object total = ActionCommonMethod.countOfData;
		String tyty = total.toString();
		PropertiesCommonMethods.cTestReports("Step-" + step + "--" + "Reset Function Test", Tatal, tyty,
				"Reset Funcation");
	}
}
