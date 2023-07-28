
//****************************************************************************************
//		DESCRIPTION
//------------------
//					DELETE SOURCE CANCEL BUTTON FUNCTION
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   28:03:2023	
//****************************************************************************************
//* Test Case Number      		Date          Intis        Comments
//* =====================       ======       ========      ========
//*  TC-SRC-0054		      28:03:2023   @SASIKALA     Original Version
//*							  05:07:2023   @Sasikala     Modified
//************************************************************************************

package com.qa.automation.qdms.testcases.source;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class DeleteSourceCancelButtonFunctionality extends DriverIntialization {
	static SourcePage Sourcepg = new SourcePage();
	static boolean work = false;

	@Test
	public static void DeleteSourceCancel() throws InterruptedException, IOException {
		PageFactory.initElements(driver, Sourcepg);
		WebDriverWait wait = new WebDriverWait(driver, 5);

		// Call Login Function
		LoginTest.Login();

		wait.until(ExpectedConditions.elementToBeClickable(SourcePage.Master));

		// Click Master Card
		SourceTest.CommonMethod(SourcePage.Master, "Master Card");

		if (SourceTest.work) {
			work = false;
			// Check Material Top Bar
			SourceTest.CommonMethod(SourcePage.Materialtopbar, "Material Top Bar");
		}

		if (SourceTest.work) {
			work = false;
			// Check Source Side Bar
			SourceTest.CommonMethod(SourcePage.sourcesitebar, "Source Side Button");
		}

		if (SourceTest.work) {
			work = false;
			// Delete Source Search data get from Excel
			deleteSourcebuttonMethod();
		}

		if (deletesource) {
			deletesource = false;
			SourceTest.CommonMethod(SourcePage.Sourcedeletecancelbtn, "Source Delete Cancel Button");
		}
		// Logout Function
		MultiSearchMethods.Logout();
	}

//************************************Delete-Source-Button-Check******************************************************
	static boolean deletesource = false;

	public static void deleteSourcebuttonMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, Sourcepg);

		try {
			deletesource = false;
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Source");

			int firstrow = CommonMethods.getFirstRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Source",
					"TC-SRC-0054");
			int lastrow = CommonMethods.getLastRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Source",
					"TC-SRC-0054");
			for (int j = firstrow; j <= lastrow; j++) {
				XSSFRow row = sheet.getRow(j);

				String sourcedeletenameselect = (String) row.getCell(1).getStringCellValue();
				Thread.sleep(2000);

				String Name = sourcedeletenameselect;
				String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
				String NameXpath_lastPart = "]/td[1]";
				String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
				String EditXpath_lastPart = "]/td[3]/span/a[2]/a/span";

// *********************************EDIT BASIC LOOP FUNCTIONS**********************

				boolean clickNextPage = true;
				boolean customerExist = false;
				while (clickNextPage) {
					for (int i = 2; i < 103; i++) {
						try {
							String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart))
									.getText();
							System.out.println(text);
							if (text.equals(Name)) {
								customerExist = true;
								driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
								Thread.sleep(2000);
								clickNextPage = false;
								break;
							}
						} catch (Exception e) {
						}
					}
					if (clickNextPage == true) {
						clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
								.isEnabled();
						if (driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
								.isEnabled()) {

							driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
							Thread.sleep(2000);
						} else {
							System.out.println("Button is Disabled");
						}
					} else {
						break;
					}
				}
				if (customerExist = false) {
					System.out.println("No such Element" + customerExist);
				}
			}
			deletesource = true;
		} catch (Exception e) {
			testCase.log(Status.INFO, "Expected Visible:-Delete Source Excel Data not Entered");
			testCase.log(Status.FAIL, "Wrong");
		}
	}
}
