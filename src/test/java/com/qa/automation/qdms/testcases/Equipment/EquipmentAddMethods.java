/***********************************************************************************
* Description
*------------
* EQUIPMENT TEST STEP METHODS
***********************************************************************************
*
* Author           : QUENTHAN
* Date Written     : 
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*                        
*
************************************************************************************/
package com.qa.automation.qdms.testcases.Equipment;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class EquipmentAddMethods extends DriverIntialization {
	static EquipmentPage equipmentPage = new EquipmentPage();
	public static String excel_path = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Excel\\Master Module.xlsx";
	static ArrayList<String> adddata = new ArrayList<String>();
	static int total = 0;

	public static void EquipmentAddButtonUI() {
		PageFactory.initElements(driver, equipmentPage);
		WebDriverWait wait = new WebDriverWait(driver, 15);

		// check if element visible
		wait.until(ExpectedConditions.visibilityOf(EquipmentPage.AddequButton));
		boolean ActualElement = EquipmentPage.AddequButton.isDisplayed();
		boolean ExpectedElement = true;

		boolean visibility = true;
		testCase = extent.createTest("EQUIPMENT-BUTTON-VISIBILITY");
		try {
			AssertJUnit.assertEquals(ActualElement, ExpectedElement);

		} catch (AssertionError e) {

			visibility = false;

//        	  throw(e);
		}
		if (visibility) {
			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
			testCase.log(Status.PASS, "Correct Element");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
			testCase.log(Status.FAIL, "No element");

		}

//            check the enable

		boolean ActualElementEnable = EquipmentPage.AddequButton.isEnabled();
		boolean ExpectedElementEnable = true;

		boolean enablity = true;
		testCase = extent.createTest("ADD-EQUIPMENT-BUTTON-ENABLE");
		try {
			AssertJUnit.assertEquals(ActualElementEnable, ExpectedElementEnable);

		} catch (AssertionError e) {
			enablity = false;
		}
		if (enablity) {
			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
			testCase.log(Status.PASS, "Element enable");
		} else {
			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
			testCase.log(Status.FAIL, "Element is not enable");
		}

	}

	public static void EquipmentSendValues() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, equipmentPage);
		adddata.clear();
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;

		try {
			filelocation = "./src/test/resources/Excel/Master Module.xlsx";

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);

			PropertiesCommonMethods.excalRowCount("Master Module.xlsx", "Equipment", "TC-EQU-0033-01");
			int I = PropertiesCommonMethods.countRow - 1;

			for (int j = 1; j < 20; j++) {
				XSSFSheet sheet = wbook.getSheet("Equipment");
				row = sheet.getRow(I);
				cell = row.getCell(j);
				String Total = dataValue.formatCellValue(cell);
				if (Total == "") {
					break;

				}
				adddata.add(Total);

			}

			String equipment = adddata.get(0);
			String type = adddata.get(1);
			String description = adddata.get(2);

			try {
				wait.until(ExpectedConditions.visibilityOf(EquipmentPage.Equipmenttextbox));
				EquipmentPage.Equipmenttextbox.sendKeys(equipment);
				EquipmentPage.EquipmentType.click();
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(
						By.xpath("//div[@class='ant-select-item-option-content' and text()='" + type + "']"))));
				driver.findElement(By.xpath("//div[@class='ant-select-item-option-content' and text()='" + type + "']"))
						.click();
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				EquipmentPage.equipmentdes.sendKeys(description);
			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (Exception e) {
			ExtentTest test = extent.createTest("Check Exceal Data");
			test.log(Status.FAIL, "Check Exceal Data");
		}
	}

	// AddEquipment SAVE BUTTON PROPERTIES
	// --------------------------------------------------

	public static void EquipmentSaveButtonUI() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		PageFactory.initElements(driver, equipmentPage);
		// check if element visible
		wait.until(ExpectedConditions.visibilityOf(EquipmentPage.equSave));
		boolean ActualElement = EquipmentPage.equSave.isDisplayed();
		boolean ExpectedElement = true;

		boolean visibility = true;
		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-VISIBILITY");
		try {
			AssertJUnit.assertEquals(ActualElement, ExpectedElement);

		} catch (AssertionError e) {

			visibility = false;

		}
		if (visibility) {
			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
			testCase.log(Status.PASS, "Correct Element");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
			testCase.log(Status.FAIL, "No element");

		}

//				            check the enable

		boolean ActualElementEnable = EquipmentPage.equSave.isEnabled();
		boolean ExpectedElementEnable = true;

		boolean enablity = true;
		testCase = extent.createTest("AddEquipment-SAVE-BUTTON-ENABLE");
		try {
			AssertJUnit.assertEquals(ActualElementEnable, ExpectedElementEnable);

		} catch (AssertionError e) {
			enablity = false;
		}
		if (enablity) {
			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
			testCase.log(Status.PASS, "Element enable");
		} else {
			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
			testCase.log(Status.FAIL, "Element is not enable");
		}

	}

	public static void checkSuccessMessage() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 3);
		PageFactory.initElements(driver, equipmentPage);

		adddata.clear();
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;

		try {
			filelocation = "./src/test/resources/Excel/Master Module.xlsx";

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);

			PropertiesCommonMethods.excalRowCount("Master Module.xlsx", "Equipment", "TC-EQU-0033-01");
			int I = PropertiesCommonMethods.countRow - 1;

			for (int j = 1; j < 20; j++) {
				XSSFSheet sheet = wbook.getSheet("Equipment");
				row = sheet.getRow(I);
				cell = row.getCell(j);
				String Total = dataValue.formatCellValue(cell);
				if (Total == "") {
					break;

				}
				adddata.add(Total);

			}
			EquipmentPage.equSave.click();
			String expect_message = adddata.get(3);
			Boolean x = false;
			String actual_message = null;
			try {
				wait.until(ExpectedConditions.invisibilityOf(EquipmentPage.equSave));
				x = true;
			} catch (Exception e) {

			}
			if (x == false) {

				String vs = driver.findElement(By.xpath("//input[@id='equipment_name']/../div[1]")).getText();
				if (vs == "") {
					vs = driver.findElement(By.xpath("//input[@id='type']/ancestor::div[3]/div[2]")).getText();

				}
				extent.createTest(vs + "-Validation Throw In Saveing Data ⚠️");

				materialMethodes.validationconfirm("", "", "Add Equipment");
			}

			else {
				try {
					try {
						wait.until(ExpectedConditions.visibilityOf(EquipmentPage.addsuccessmessage));
					} catch (Exception e) {
						// TODO: handle exception
					}
					try {
						actual_message = EquipmentPage.addsuccessmessage.getText();
					} catch (Exception e) {
						// TODO: handle exception
					}
//			System.out.println("++++++++++++"+actual_message);
					CommonMethods.TestCasePrint("ADD EQUIPMENT SUCCESS MESSAGE", expect_message, actual_message);
					EquipmentAddMethods.checkData();
					EquipmentAddMethods.countelement(adddata.get(0), 1);
					PropertiesCommonMethods.cTestReports("Conforme Alredy Data Not Added", 1, total,
							"Conforme Alredy Data Not Added");

				}

				catch (Exception e) {
					ExtentTest test = extent.createTest("Add Equipment Save Fail");
					test.log(Status.FAIL, "Add Equipment Send Save Fail");
				}

			}
		} catch (Exception e) {
			ExtentTest test = extent.createTest("Check Exceal Data");
			test.log(Status.FAIL, "Check Exceal Data");
		}
	}

	// check save button functionality

	public static void checkData() {
		PageFactory.initElements(driver, equipmentPage);
		testCase = extent.createTest(" CHECK EQUIPMENT ADD FUNCTIONALITY");

		String expect_equipment = adddata.get(0);
		String expect_type = adddata.get(1);
		String expect_description = adddata.get(2);

		String actual_equipment_data = null;
		try {
			actual_equipment_data = EquipmentPage.equipdata.getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String actual_equipment_description = null;
		try {
			actual_equipment_description = EquipmentPage.descriptiondata.getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String actual_equipment_type = null;
		try {
			actual_equipment_type = EquipmentPage.typedata.getText();
		} catch (Exception e) {
			// TODO: handle exception
		}

		CommonMethods.TestCasePrint("VERIFY EQUIPMENT ADDED DATA", expect_equipment, actual_equipment_data);
		CommonMethods.TestCasePrint("VERIFY EQUIPMENT TYPE ADDED DATA", expect_type, actual_equipment_type);
		CommonMethods.TestCasePrint("VERIFY EQUIPMENT DESCRIPTION ADDED DATA", expect_description,
				actual_equipment_description);

	}

	public static void countelement(String text, int i) {
		WebDriverWait wit = new WebDriverWait(driver, 2);
		total = 0;
		Boolean rept = true;

		while (rept.equals(true)) {
			int te = 0;
			try {
				try {
					wit.until(ExpectedConditions.invisibilityOf(
							driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))));
				} catch (Exception e) {
					// TODO: handle exception
				}
				rept = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				te = driver.findElements(By.xpath("//td[" + i + "][text()='" + text + "']")).size();
			} catch (Exception e) {
				// TODO: handle exception
			}
			total = total + te;

			if (rept.equals(true)) {
				try {
					driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				} catch (Exception e) {
					// TODO: handle exception
				}

			}

		}

	}

}
