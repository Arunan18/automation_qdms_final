package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.FileInputStream;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;

public class IncSamTestTrialInputValue extends DriverIntialization {
	public static ArrayList<String> addData = new ArrayList<String>();

	public static Actions action = new Actions(driver);

	public static void TestTrialInputValueIncSam() throws InterruptedException {

		String code1 = null;
		/**********************************************************************************
		 * Get Data From Exceal
		 **********************************************************************************/

		// get data from exceal
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;

		try {
			filelocation = "./src/test/resources/Excel/Samples Module.xlsx";

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			// fileIn.close();

		} catch (Exception e) {

		}

		PropertiesCommonMethods.excalRowCount("Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0301-01");
		int I = PropertiesCommonMethods.countRow - 1;

		for (int j = 2; j < 20; j++) {
			XSSFSheet sheet = wbook.getSheet("Incoming Sample");
			row = sheet.getRow(I);
			cell = row.getCell(j);
			String Tatal = dataValue.formatCellValue(cell);
			// System.out.println(Tatal);
			if (Tatal.equals("")) {
				break;

			}
			addData.add(Tatal);

		}
		System.out.println(addData);

	}

	public static void ClickTestResultTest() throws InterruptedException {

		extent.createTest("STEP 01 - Click Test Result Icon & Click Test");
		ActionCommonMethod.actionS(0, 17, driver.findElement(By.xpath("//div[@class='ant-table-container']")),
				"Test Status", "Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0301-01", 1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='" + addData.get(1) + "']")).click();

	}

//	/**********************************************************************************
//	 * Step-02--Date Field Is Displayed & Enable
//	 **********************************************************************************/
//

	public static void InputDate() {

		WebElement dete = driver.findElement(By.id("date"));
		ActionCommonMethod.visbleEnable2(dete, "Date Text Box", 02);
		ActionCommonMethod.dateS(dete, addData.get(0), 1);

	}

//	/**********************************************************************************
//	 * Step-03--No Of Field Is Displayed & Enable
//	 **********************************************************************************/

	public static void InputNoofTrial() {
		WebElement noOfTest = driver.findElement(By.id("no_of_trial"));
		ActionCommonMethod.visbleEnable2(noOfTest, "No Of Trails Text Box", 03);
		ActionCommonMethod.sendkey(noOfTest, addData.get(2));
	}

//	/**********************************************************************************
//	 * Step-04--Status Field Check New
//	 **********************************************************************************/

	public static void Status() {
		WebElement status = driver.findElement(By.id("status"));
		PropertiesCommonMethods.cTestReports("Step-04--Status Field Check New", "NEW", status.getAttribute("value"),
				"Status Field");

	}

//	/**********************************************************************************
//	 * Step-05--Submit Button Is Displayed & Enable
//	 **********************************************************************************/
	public static void SubmitButton() throws InterruptedException {

		WebElement submit = driver.findElement(By.xpath("//span[text()='Submit']/.."));
		ActionCommonMethod.visbleEnable2(submit, "Submit Button", 05);
		submit.click();
		Thread.sleep(500);
	}

//	**********************************************************************************
//	 * Step-06--Check Submit Button Is Function
//	 **********************************************************************************/

	public static void SuccessMessage() throws InterruptedException {
		PropertiesCommonMethods.cTestReports("Step-06--Check Submit Button Is Function",
				"Material Test Added Successfully",
				driver.findElement(By.xpath("//div[@class='ant-notification-notice-message']")).getText(),
				"Submit Function");
		Thread.sleep(4000);
	}
//	/**********************************************************************************
//	 * Step-07--Check Procedure Button Is Displayed & Enable Step-08--Check
//	 * Procedure Button Funcation
//	 **********************************************************************************/

	public static void ProcedureIcon() throws InterruptedException {
		WebElement proceder = driver.findElement(By.xpath("//div[contains(@class,'ant-col-3')]//*[@fill]"));
		ActionCommonMethod.visbleEnable2(proceder, "Procedure Icon", 07);
		proceder.click();
		Thread.sleep(500);

		PropertiesCommonMethods.cTestReports("Step-08--Check Procedure Button Funcation", "true",
				driver.findElement(By.xpath("//div[text()='Test Procedure']")).isDisplayed(),
				"Proceder Icon Funcation");

	}
//	/**********************************************************************************
//	 * Add Trail Data
//	 **********************************************************************************/

	public static void AddTrialData() throws InterruptedException {
		int ik = 1;
		System.out.println(addData.size());
		for (int j = 3; j < addData.size(); j++) {
			WebElement value = driver.findElement(By.xpath("(//input[@class='ant-input'])[" + ik + "]"));
			value.click();
			value.sendKeys(addData.get(j));
			ik = ik + 1;
			action.sendKeys(Keys.TAB);
		}
		Thread.sleep(3000);
		WebElement trail = driver.findElement(By.xpath("//button[contains(.,'Trial')]/.."));

//	/**********************************************************************************
//	 * Step-09--Check Trail Button Is Displayed & Enable Step-10--Check Trail Button
//	 * Funcation
//	 **********************************************************************************/

		ActionCommonMethod.visbleEnable2(trail, "Procedure Icon", 9);
		trail.click();
		Thread.sleep(1000);
		PropertiesCommonMethods.cTestReports("Step-10--Check Trail Button Funcation", "true",
				driver.findElement(By.xpath("//*[text()='View Results']/..")).isDisplayed(), "Trail Button Funcation");

//	/**********************************************************************************
//	 * Step-11--Check Go To Sample Link Is Displayed & Enable Step-12--Check Go To
//	 * Sample Link Funcation
//	 **********************************************************************************/
		Thread.sleep(5000);
		WebElement go = driver.findElement(By.xpath("//a[text()='Go To Samples']"));
		ActionCommonMethod.visbleEnable2(go, "Check Go To Sample Link", 11);

		go.click();
		Thread.sleep(2000);
		PropertiesCommonMethods.cTestReports("Step-12--Check Go To Sample Link Funcation", "true", driver
				.findElement(By.xpath("//div[@class='ant-table-title']//*[text()=' Incoming Sample']")).isDisplayed(),
				"Go To Sample Page");
	}

	public static void ClickTestResultTestProcess() throws InterruptedException {

		extent.createTest("STEP 01 - Click Test Result Icon & Click Test");
		ActionCommonMethod.actionS(0, 17, driver.findElement(By.xpath("//div[@class='ant-table-container']")),
				"Test Status", "Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0316-01", 1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='" + addData.get(1) + "']")).click();

	}

	public static void ProcessStatus() {
		WebElement status = driver.findElement(By.id("status"));
		PropertiesCommonMethods.cTestReports("Step-04--Status Field Check Process", "PROCESS",
				status.getAttribute("value"), "Status Field");

	}

	public static void TestTrialInputValueIncSamProcess() throws InterruptedException {

		String code1 = null;
		/**********************************************************************************
		 * Get Data From Exceal
		 **********************************************************************************/

		// get data from exceal
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;

		try {
			filelocation = "./src/test/resources/Excel/Samples Module.xlsx";

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			// fileIn.close();

		} catch (Exception e) {

		}

		PropertiesCommonMethods.excalRowCount("Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0316-01");
		int I = PropertiesCommonMethods.countRow - 1;

		for (int j = 2; j < 20; j++) {
			XSSFSheet sheet = wbook.getSheet("Incoming Sample");
			row = sheet.getRow(I);
			cell = row.getCell(j);
			String Tatal = dataValue.formatCellValue(cell);
			// System.out.println(Tatal);
			if (Tatal.equals("")) {
				break;

			}
			addData.add(Tatal);

		}
		System.out.println(addData);

	}

	public static void TestTrialInputValueIncSamPass() throws InterruptedException {

		String code1 = null;
		/**********************************************************************************
		 * Get Data From Exceal
		 **********************************************************************************/

		// get data from exceal
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;

		try {
			filelocation = "./src/test/resources/Excel/Samples Module.xlsx";

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			// fileIn.close();

		} catch (Exception e) {

		}

		PropertiesCommonMethods.excalRowCount("Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0314-01");
		int I = PropertiesCommonMethods.countRow - 1;

		for (int j = 2; j < 20; j++) {
			XSSFSheet sheet = wbook.getSheet("Incoming Sample");
			row = sheet.getRow(I);
			cell = row.getCell(j);
			String Tatal = dataValue.formatCellValue(cell);
			// System.out.println(Tatal);
			if (Tatal.equals("")) {
				break;

			}
			addData.add(Tatal);

		}
		System.out.println(addData);

	}

	public static void ClickTestResultTestPass() throws InterruptedException {

		extent.createTest("STEP 01 - Click Test Result Icon & Click Test");
		ActionCommonMethod.actionS(0, 17, driver.findElement(By.xpath("//div[@class='ant-table-container']")),
				"Test Status", "Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0314-01", 1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='" + addData.get(1) + "']")).click();

	}

	public static void PassStatus() {
		WebElement status = driver.findElement(By.id("status"));
		PropertiesCommonMethods.cTestReports("Step-04--Status Field Check Process", "PASS",
				status.getAttribute("value"), "Status Field");

	}

	public static void TestTrialInputValueIncSamFail() throws InterruptedException {

		String code1 = null;
		/**********************************************************************************
		 * Get Data From Exceal
		 **********************************************************************************/

		// get data from exceal
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;

		try {
			filelocation = "./src/test/resources/Excel/Samples Module.xlsx";

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			// fileIn.close();

		} catch (Exception e) {

		}

		PropertiesCommonMethods.excalRowCount("Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0315-01");
		int I = PropertiesCommonMethods.countRow - 1;

		for (int j = 2; j < 20; j++) {
			XSSFSheet sheet = wbook.getSheet("Incoming Sample");
			row = sheet.getRow(I);
			cell = row.getCell(j);
			String Tatal = dataValue.formatCellValue(cell);
			// System.out.println(Tatal);
			if (Tatal.equals("")) {
				break;

			}
			addData.add(Tatal);

		}
		System.out.println(addData);

	}

	public static void ClickTestResultTestFail() throws InterruptedException {

		extent.createTest("STEP 01 - Click Test Result Icon & Click Test");
		ActionCommonMethod.actionS(0, 17, driver.findElement(By.xpath("//div[@class='ant-table-container']")),
				"Test Status", "Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0315-01", 1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='" + addData.get(1) + "']")).click();

	}

	public static void FailStatus() {
		WebElement status = driver.findElement(By.id("status"));
		PropertiesCommonMethods.cTestReports("Step-04--Status Field Check Process", "FAIL",
				status.getAttribute("value"), "Status Field");

	}

}
