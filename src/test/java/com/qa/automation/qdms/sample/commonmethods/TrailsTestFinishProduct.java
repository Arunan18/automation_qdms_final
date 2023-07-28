
/**
 * @author Quenthan
 * Sample Trails Test
 */
package com.qa.automation.qdms.sample.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;
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

public class TrailsTestFinishProduct extends DriverIntialization {
	public static ArrayList<String> addData = new ArrayList<String>();
	public static ArrayList<String> trailData = new ArrayList<String>();
	static int countRow = 0;

	public static void TestFuncations() {

	}

	// SearchMethoid
	public static void trailsTest(String bookName, String sheetname, String TestNumber, WebElement table,
			int testColumn) throws InterruptedException {
		// get data from exceal
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;

		try {
			filelocation = "./src/test/resources/Excel/" + bookName;

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			// fileIn.close();

		} catch (Exception e) {

		}

		TrailsTestFinishProduct.excalRowCount(bookName, sheetname, TestNumber, "-data-01");
		int I = TrailsTestFinishProduct.countRow;

//			System.out.println(I);
		for (int j = 1; j < 20; j++) {
			XSSFSheet sheet = wbook.getSheet(sheetname);
			row = sheet.getRow(I);
			cell = row.getCell(j);
			String Tatal = dataValue.formatCellValue(cell);
			// System.out.println(Tatal);
			if (Tatal.equals("")) {
				break;

			}
			addData.add(Tatal);

		}
		String title = driver.findElement(By.xpath("//div[@class='ant-table-title']//div[@class='ant-typography']"))
				.getText();
		System.out.println(title);
		SelectDate.click(4, testColumn, table, "Test Status", addData.get(0));
		Thread.sleep(2000);
		System.out.println("Size:-" + driver.findElements(By.xpath("//li[text()='" + addData.get(2) + "']")).size());
		System.out.println("status:-" + driver
				.findElement(By.xpath("//li[text()='" + addData.get(2) + "']/../../..//span[@class='ant-ribbon-text']"))
				.getText());
		if (addData.get(1).equals("New")) {
			String status = driver
					.findElement(
							By.xpath("//li[text()='" + addData.get(2) + "']/../../..//span[@class='ant-ribbon-text']"))
					.getText();
			int coutTest = driver.findElements(By.xpath("//li[text()='" + addData.get(2) + "']")).size();

			driver.findElement(By.xpath("//li[text()='" + addData.get(2) + "']")).click();

			Thread.sleep(2000);

			if (status.equals("NEW")) {
				// Add NEw Dats
				TrailsTestFinishProduct.addnewData();
				// add tail data
				TrailsTestFinishProduct.addTrailData(bookName, sheetname, TestNumber);
				// Check Report
				TrailsTestFinishProduct.reportCheck(bookName, sheetname, TestNumber);
			}

			else if (status.equals("PROCESS")) {
				// Add NEw Dats
				TrailsTestFinishProduct.addnewData();
				// add tail data
				TrailsTestFinishProduct.addTrailData(bookName, sheetname, TestNumber);
				// Check Report
				TrailsTestFinishProduct.reportCheck(bookName, sheetname, TestNumber);

				SampleNavigateTest.finishProductSampleMainNavigation();
				Thread.sleep(1500);
				if (title.equals("Plant-Lab Trial Sample")) {
					SampleNavigateTest.labTrialSampleNavigation();
				} else if (title.equals("Production Sample")) {
					SampleNavigateTest.productionSampleNavigation();
				}

				Thread.sleep(2000);
				Boolean rept = true;
				while (rept == true) {

					rept = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
					Thread.sleep(1500);

					try {
						driver.findElement(
								By.xpath("//td[5][text()='" + addData.get(0) + "']/following-sibling::td[13]/span"))
								.click();
						rept = false;
						break;
					} catch (Exception e) {
					}
					if (rept == true) {
						driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
					}

				}
				Thread.sleep(1500);
				PropertiesCommonMethods.cTestReports("Confirm Add new Sample Card", coutTest + 1,
						driver.findElements(By.xpath("//li[text()='" + addData.get(2) + "']")).size(), title);
			}
//add in fail & pass
			else {

				driver.findElement(By.xpath("//td[text()='" + addData.get(0) + "']/following-sibling::td[9]/span/span"))
						.click();
				Thread.sleep(1500);

				// Add NEw Dats
				TrailsTestFinishProduct.addnewData();
				// add tail data
				TrailsTestFinishProduct.addTrailData(bookName, sheetname, TestNumber);
				// Check Report
				TrailsTestFinishProduct.reportCheck(bookName, sheetname, TestNumber);

				SampleNavigateTest.finishProductSampleMainNavigation();
				Thread.sleep(1500);
				if (title.equals("Plant-Lab Trial Sample")) {
					SampleNavigateTest.labTrialSampleNavigation();
				} else if (title.equals("Production Sample")) {
					SampleNavigateTest.productionSampleNavigation();
				}

				Thread.sleep(2000);
				Boolean rept = true;
				while (rept == true) {

					rept = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
					Thread.sleep(1500);

					try {
						driver.findElement(
								By.xpath("//td[5][text()='" + addData.get(0) + "']/following-sibling::td[13]/span"))
								.click();
						rept = false;
						break;
					} catch (Exception e) {
					}
					if (rept == true) {
						driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
					}

				}
				Thread.sleep(1500);
				PropertiesCommonMethods.cTestReports("Confirm Add new Sample Card", coutTest + 1,
						driver.findElements(By.xpath("//li[text()='" + addData.get(2) + "']")).size(), title);

			}

		}

		else if (addData.get(1).equals("Continue")) {
			driver.findElement(By.xpath("//li[text()='" + addData.get(6) + "']")).click();
			Thread.sleep(1500);
			Boolean rept = true;
			while (rept == true) {

				rept = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
				Thread.sleep(1500);

				try {
					driver.findElement(
							By.xpath("//*[text()='" + addData.get(6) + "']/following-sibling::td[6]//button")).click();
					rept = false;
					break;
				} catch (Exception e) {
				}
				if (rept == true) {
					driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				}

			}
			Thread.sleep(1500);
			PropertiesCommonMethods.cTestReports("Click Continue Trail Specimen Code", "true",
					driver.findElement(By.xpath("//h3[text()='Test Trial']")).isDisplayed(), "Trails Test");
			Boolean isdis = false;
			WebElement viewReport = null;
			try {
				// Check Enter Field or View
				viewReport = driver.findElement(By.xpath("//*[text()='View Results']/.."));
				isdis = viewReport.isDisplayed();
			} catch (Exception e) {
			}
			if (isdis.equals(true)) {
				TrailsTestFinishProduct.addInformation(bookName, sheetname, TestNumber);
				viewReport.click();
				Thread.sleep(1000);

//			Check Report

				TrailsTestFinishProduct.reportCheck(bookName, sheetname, TestNumber);
			}

//		  add Trail Datas
			else {
				Thread.sleep(1000);

//			  add tail data
				TrailsTestFinishProduct.addTrailData(bookName, sheetname, TestNumber);
//			  Check Report
				TrailsTestFinishProduct.reportCheck(bookName, sheetname, TestNumber);

			}

		} else if (addData.get(1).equals("Update")) {

			driver.findElement(By.xpath("//li[text()='" + addData.get(6) + "']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[text()='" + addData.get(6) + "']/following-sibling::td[4]/span/span"))
					.click();
			Thread.sleep(1500);
			Boolean rept = true;
			while (rept == true) {

				rept = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
				Thread.sleep(1500);

				try {
					driver.findElement(
							By.xpath("//*[text()='" + addData.get(6) + "']/following-sibling::td[6]//button")).click();
					rept = false;
					break;
				} catch (Exception e) {
				}
				if (rept == true) {
					driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				}

			}
			Thread.sleep(1500);
			try {
				driver.findElement(By.xpath("//span[text()='OK']/..")).click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			Thread.sleep(1500);
			PropertiesCommonMethods.cTestReports("Click Update Trail Specimen Code", "true",
					driver.findElement(By.xpath("//h3[text()='Test Trial']")).isDisplayed(), "Trails Test");
//		Click arrow for 
			rept = true;
			while (rept == true) {
				Thread.sleep(500);
				rept = driver
						.findElement(By.xpath("//h3[text()='Test Trial']/../..//span[@aria-label='arrow-left']/.."))
						.isEnabled();

				try {
					driver.findElement(By.xpath("//h3[text()='Test Trial']/../..//span[@aria-label='arrow-left']/.."))
							.click();
				} catch (Exception e) {
					// TODO: handle exception
				}

			}

//	  add tail data
			TrailsTestFinishProduct.addTrailData(bookName, sheetname, TestNumber);
//	  Check Report
			TrailsTestFinishProduct.reportCheck(bookName, sheetname, TestNumber);

		}

	}

	public static void addTrailData(String bookName, String sheetname, String TestNumber) throws InterruptedException {

		TrailsTestFinishProduct.addInformation(bookName, sheetname, TestNumber);
		Actions action = new Actions(driver);
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;
		int sto = Integer.parseInt(addData.get(4));
		try {
			filelocation = "./src/test/resources/Excel/" + bookName;

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			// fileIn.close();

		} catch (Exception e) {

		}

		TrailsTestFinishProduct.excalRowCount(bookName, sheetname, TestNumber, "-Input-01");
		int I1 = TrailsTestFinishProduct.countRow;

		for (int j = 0; j < sto; j++) {
//			System.out.println(I);
			trailData.clear();
			for (int j2 = 2; j2 < 20; j2++) {
				XSSFSheet sheet = wbook.getSheet(sheetname);
				row = sheet.getRow(I1);
				cell = row.getCell(j2);
				String Tatal = dataValue.formatCellValue(cell);
				// System.out.println(Tatal);
				if (Tatal.equals("")) {
					break;

				}
				trailData.add(Tatal);

			}
			System.out.println(trailData);

			int ik = 1;
			System.out.println(trailData.size());
			for (int j1 = 0; j1 < trailData.size(); j1++) {
				WebElement value = driver.findElement(By.xpath("(//input[@class='ant-input'])[" + ik + "]"));
				value.click();
				value.sendKeys((Keys.CONTROL) + "a" + Keys.BACK_SPACE);

				value.sendKeys(trailData.get(j1));
				ik = ik + 1;
				action.sendKeys(Keys.TAB);
			}

			WebElement trail = driver.findElement(By.xpath("//button[contains(.,'Trial')]/.."));
			trail.click();
			Thread.sleep(1000);
			I1 = I1 + 1;
		}
		Thread.sleep(1000);
		WebElement viewReport = driver.findElement(By.xpath("//*[text()='View Results']/.."));
		PropertiesCommonMethods.cTestReports("Trails Add Success", "true", viewReport.isDisplayed(),
				"Trail Button Click");
		viewReport.click();

	}

	public static void addnewData() throws InterruptedException {
		// Enter Date

		WebElement dete = driver.findElement(By.id("date"));
		ActionCommonMethod.dateS(dete, addData.get(3), 1);
		// Enter No OF Trail
		WebElement noOfTest = driver.findElement(By.id("noOfTrial"));
		ActionCommonMethod.sendkey(noOfTest, addData.get(4));

//	click submit button

		WebElement submit = driver.findElement(By.xpath("//span[text()='Submit']/.."));
		submit.click();
		Thread.sleep(500);
		PropertiesCommonMethods.cTestReports("Trails Data Add Success", "Finish Product Test Added SuccessFully",
				driver.findElement(By.xpath("//div[@class='ant-notification-notice-message']")).getText(),
				"Submit Function");
		Thread.sleep(2000);

	}

	public static void reportCheck(String bookName, String sheetname, String TestNumber) throws InterruptedException {
		Thread.sleep(3000);
		// Check Date Is Correct
		PropertiesCommonMethods.cTestReports("Check Enter Date Is Correct", addData.get(3),
				driver.findElement(By.xpath("(//tbody)[1]/tr/td[2]")).getText(), "Date Field");

//	  No Of Traile correct
		PropertiesCommonMethods.cTestReports("Check No Of Trail Is Correct", addData.get(4),
				driver.findElement(By.xpath("(//tbody)[1]/tr/td[3]")).getText(), "No Of Trails Field");

//	  Sample Code Is Correct
		PropertiesCommonMethods.cTestReports("Check Sample Code Is Correct", addData.get(0),
				driver.findElement(By.xpath("(//tbody)[1]/tr/td[6]")).getText(), "Sample Code Field");

		// Get expacted Data
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;

		try {
			filelocation = "./src/test/resources/Excel/" + bookName;

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			// fileIn.close();

		} catch (Exception e) {

		}

		TrailsTestFinishProduct.excalRowCount(bookName, sheetname, TestNumber, "-Expected-01");
		int I1 = TrailsTestFinishProduct.countRow;
		int I2 = TrailsTestFinishProduct.countRow;
		int il = 1;
		Boolean repet = true;
		while (repet.equals(true)) {
			XSSFSheet sheet = wbook.getSheet(sheetname);
			row = sheet.getRow(I1);
			try {
				cell = row.getCell(1);
			} catch (Exception e) {
				repet = false;
				break;
			}
			String Tatal = dataValue.formatCellValue(cell);
			if (Tatal.equals("")) {
				repet = false;
				break;

			}

			PropertiesCommonMethods.cTestReports("Checking Trails Report Is Correct", Tatal,
					driver.findElement(By.xpath("(//tbody)[2]/tr[" + il + "]")).getText(), "Report Check");
			il = il + 1;
			I1 = I1 + 1;
		}

		// Result Is Correct
		il = 1;
		repet = true;

		Boolean repet1 = true;
		while (repet1.equals(true)) {
			XSSFSheet sheet = wbook.getSheet(sheetname);
			row = sheet.getRow(I2);
			try {
				cell = row.getCell(2);
			} catch (Exception e) {
				repet1 = false;
				break;
			}
			String Tatal = dataValue.formatCellValue(cell);
			if (Tatal.equals("")) {
				repet1 = false;
				break;

			}

			PropertiesCommonMethods.cTestReports("Checking Result Report Is Correct", Tatal,
					driver.findElement(By.xpath("(//tbody)[3]/tr[" + il + "]")).getText(), "Report Check");
			il = il + 1;
			I2 = I2 + 1;
		}
		// Checking Adistional Report
		boolean id = false;
		try {
			id = driver.findElement(By.xpath("//*[text()='Additional Information']")).isDisplayed();
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (id == true) {
			TrailsTestFinishProduct.excalRowCount(bookName, sheetname, TestNumber, "-Information-01");
			int I3 = TrailsTestFinishProduct.countRow;
			int no = 2;
			int ok = 1;

			String v1 = driver
					.findElement(By.xpath("//*[text()='Additional Information']/..//tbody/tr[" + no + "]/td[1]"))
					.getText();
			String v2 = driver
					.findElement(By.xpath("//*[text()='Additional Information']/..//tbody/tr[" + no + "]/td[2]"))
					.getText();
			XSSFSheet sheet = wbook.getSheet(sheetname);
			row = sheet.getRow(I3);
			cell = row.getCell(1);
			String In = dataValue.formatCellValue(cell);
			row = sheet.getRow(I3);
			cell = row.getCell(2);
			String In1 = dataValue.formatCellValue(cell);
			PropertiesCommonMethods.cTestReports("Additional Information Report Check", In + ", " + In1, v1 + ", " + v2,
					"Report");

			row = sheet.getRow(I3);
			String In2 = null;
			try {
				cell = row.getCell(3);
				In2 = dataValue.formatCellValue(cell);
				if (In2.equals("delete")) {
					driver.findElement(By.xpath("//*[text()='Additional Information']/..//tbody/tr[2]/td[3]//a"))
							.click();
					Thread.sleep(800);
					driver.findElement(By.xpath("(//span[text()='OK']/..)[" + ok + "]")).click();
					ok = ok + 1;
					PropertiesCommonMethods.cTestReports("Delete Adistional Information", "false", "false", "Delete");
				}
			} catch (Exception e) {
			}
			I3 = I3 + 1;

		}

//		Checking Status
		PropertiesCommonMethods.cTestReports("Checking Status Of Test Trail", addData.get(5),
				driver.findElement(By.xpath("//*[text()='Status']/../span")).getText(), "status");

	}

	public static void addInformation(String bookName, String sheetname, String TestNumber)
			throws InterruptedException {
		Boolean itIs = false;
		try {
			itIs = driver.findElement(By.xpath("//p[text()='Additional Information']")).isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}

		if (itIs == true) {
//		 Get exceal Data
			XSSFRow row = null;
			XSSFCell cell = null;
			DataFormatter dataValue = new DataFormatter();
			FileInputStream fileIn = null;
			String filelocation = null;
			XSSFWorkbook wbook = null;

			try {
				filelocation = "./src/test/resources/Excel/" + bookName;

				fileIn = new FileInputStream(filelocation);
				wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
				// fileIn.close();

			} catch (Exception e) {

			}

			TrailsTestFinishProduct.excalRowCount(bookName, sheetname, TestNumber, "-Information-01");
			int I1 = TrailsTestFinishProduct.countRow;
			System.out.println(I1);

			Boolean repet = true;
			Boolean save = false;

			while (repet.equals(true) & I1 > 0) {
				XSSFSheet sheet = wbook.getSheet(sheetname);
				row = sheet.getRow(I1);
				cell = row.getCell(0);
				String In = dataValue.formatCellValue(cell);

				if (In.contains("Information")) {
					row = sheet.getRow(I1);
					try {
						cell = row.getCell(1);
					} catch (Exception e) {
						repet = false;
						break;
					}
					String Tatal = dataValue.formatCellValue(cell);

					row = sheet.getRow(I1);
					cell = row.getCell(2);
					String Add = dataValue.formatCellValue(cell);
					driver.findElement(
							By.xpath("//label[contains(.,'" + Tatal + "')]/../following-sibling::div//input")).click();

					driver.findElement(
							By.xpath("//label[contains(.,'" + Tatal + "')]/../following-sibling::div//input"))
							.sendKeys((Keys.CONTROL) + "a" + Keys.BACK_SPACE);
					driver.findElement(
							By.xpath("//label[contains(.,'" + Tatal + "')]/../following-sibling::div//input"))
							.sendKeys(Add);
					save = true;
					I1 = I1 + 1;
				}

				else {
					repet = false;
				}

			}
			if (save == true) {
				try {
					driver.findElement(By.xpath("//*[text()='Additional Information']/../..//*[text()='Save']/.."))
							.click();
					Thread.sleep(1000);
					PropertiesCommonMethods.cTestReports("Additional Information Added Sucess", "true",
							driver.findElement(
									By.xpath("//*[text()='Additional Information']/../..//*[text()='Edit']/.."))
									.isDisplayed(),
							"Add Additional Information");
				} catch (Exception e) {
					driver.findElement(By.xpath("//*[text()='Additional Information']/../..//*[text()='Edit']/.."))
							.click();
					Thread.sleep(1000);
					PropertiesCommonMethods.cTestReports("Additional Information Edit Sucess", "false",
							driver.findElement(
									By.xpath("//*[text()='Additional Information']/../..//*[text()='Edit']/.."))
									.isEnabled(),
							"Add Additional Information");
				}
			}

		}

	}

	public static void excalRowCount(String workBook, String sheetname, String TestNumber, String type) {
		FileInputStream fileIn = null;
		String value = null;
		DataFormatter daaa = new DataFormatter();

		Boolean stop = false;
		int i = 0;
		int count = 0;
		XSSFRow rows = null;
		String filelocation = "./src/test/resources/Excel/" + workBook;
		XSSFWorkbook wbook = null;
		try {

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			//

//			 
//			
//				wbook = new XSSFWorkbook(filelocation);

		} catch (Exception e) {
			// TODO: handle exception
			// ("Button Properties Test Fail⚠️- Check file Location or File name❗", "Get
			// Propertis", "Fail Get Properties");
		}
		XSSFSheet sheets = wbook.getSheet(sheetname);
		int a = sheets.getLastRowNum() + 2;

		for (i = 0; i < a; i++) {
			rows = sheets.getRow(i);
			if (rows == null) {
				count = count + 1;

			} else {
				XSSFCell cell = rows.getCell(0);
				value = daaa.formatCellValue(cell);

				count = count + 1;

				if (value.equals(TestNumber + type)) {
					stop = true;
					break;

				}

			}

		}

		if (stop == false) {
			extent.createTest(TestNumber + "-Not In Excel");
			count = 1;

		}
		try {
			fileIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		countRow = count - 1;
	}

}
