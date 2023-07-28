//  Sayan  - 08/05/2023

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.EmployeePage;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;

public class CommonElementsPlantLabTrial extends DriverIntialization{
	
	static EmployeePage EmployeePg = new EmployeePage();
	static PlantEquipmentPage page = new PlantEquipmentPage();
	static SourcePage SourcePg = new SourcePage();
	static PlantLabTrailSamplePage PlantLabTrailSamplePg = new PlantLabTrailSamplePage();
	
	static String FinishSample = null;
	
	
	
//	Excel for click test and trial
//	---------------------------------------------------

	public static void selectSampleExcelData() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Plant Lab Trial Sample");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx",
				"Plant Lab Trial Sample", "TC-P-LAB-SAM-0160");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx",
				"Plant Lab Trial Sample", "TC-P-LAB-SAM-0160");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			FinishSample = (String) row.getCell(1).getStringCellValue();

		}
	}
	
	
	public static void searchFinishProSample () throws InterruptedException {
		
		
		PageFactory.initElements(driver, EmployeePg);
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, SourcePg);
		
		driver.findElement(By.xpath("//div[@class='ant-table-body']")).click();

		try {
			boolean pass = false;
			Thread.sleep(1000);

			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("//th[@class='ant-table-cell'][4]")).click();
						pass = true;
					} catch (Exception e) {
					}
				}

				if (!pass) {
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2);
				} else {
					break;
				}

			}

		} catch (Exception e) {

		}
		

		boolean nextBtn = PlantEquipmentPage.next.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_fourth;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);

			}
			boolean isExist = list.contains(FinishSample);
			Thread.sleep(3000);
			nextBtn = PlantEquipmentPage.next.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				PlantEquipmentPage.next.click();
				Thread.sleep(3000);
			} else
				break;

		}

		
		
	}
	
	
	
	public static void testAndTrialFinishSample() throws InterruptedException {
		
		try {

			if (driver.findElement(By.xpath("//td[text()='"+ FinishSample +"']//following-sibling::td[4]//span[@class='anticon anticon-experiment']")).isDisplayed()) {

				testCase = extent.createTest("Test and Trial Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver.findElement(By.xpath("//td[text()='"+ FinishSample +"']//following-sibling::td[4]//span[@class='anticon anticon-experiment']")).isEnabled()) {
					testCase = extent.createTest("Test and Trial Icon Enable");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='"+ FinishSample +"']//following-sibling::td[4]//span[@class='anticon anticon-experiment']")).click();

	

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}
	
	
	public static void modalClose() throws InterruptedException {
		
		PageFactory.initElements(driver, PlantLabTrailSamplePg);
		
		boolean AcctualAfterClick = PlantLabTrailSamplePage.testAndTrialModal.isDisplayed();
        boolean ExpectedAfterClick = false;
        testCase = extent.createTest("TEST AND TRIAL MODAL CLOSING");
        try {
            AssertJUnit.assertEquals(AcctualAfterClick, ExpectedAfterClick);
        } catch (AssertionError e) {
            ExpectedAfterClick = true;
        }
        if (ExpectedAfterClick) {
            testCase.log(Status.INFO, "AcctualAfterClick :- " + AcctualAfterClick);
            testCase.log(Status.INFO, "Expectedfontweight :- " + ExpectedAfterClick);
            testCase.log(Status.PASS, "Modal is closed");
        } else {
            testCase.log(Status.INFO, "AcctualAfterClick :- " + AcctualAfterClick);
            testCase.log(Status.INFO, "ExpectedAfterClick :- " + ExpectedAfterClick);
            testCase.log(Status.FAIL, "Modal is not closed");
        }
        Thread.sleep(1000);
	}

}
