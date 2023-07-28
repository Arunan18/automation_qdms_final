//***********************************************************************************
//* Description
//*------------
//* USER MAIN METHODS
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 01/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        01/03/2023   WATHI     Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testcases.user;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.pages.master.UserPage;

public class UserMainTests extends DriverIntialization {

	public static final String SearchRightSide = null;

	static String usernametable = null;
	static String usertype = null;
	static boolean check = true;
	static boolean pass = true;
	static int number = 0;
	static String selectthetype = null;
	static String selectPlant = null;
	static String expectedtopdata = null;
	static String expectedplantrecordontop = null;
	static String selectusername = null;
	static String toggleoff = null;
	static String toggleoffcolour = null;
	static String toggleon = null;
	static String toggleoncolour = null;
	static String username47 = null;
	static String usertype47 = null;
	static String role47 = null;
	static String usernamesearch = null;
	static String employeesearch = null;
	static String usernametrans = null;
	static String planttrans = null;
	static String username43 = null;
	static String data = null;
	static String data1 = null;

	static UserPage user = new UserPage();
	static SourcePage src = new SourcePage();
	static PlantEquipmentPage plantequ = new PlantEquipmentPage();

//******************GENRALIZED METHOD FOR THE REPORT GENERATION******************

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

//******************CHECK THE PROPERTIES OF THE CHECK-BOX******************	

	public static void checkBoxProprties() throws InterruptedException {

		PageFactory.initElements(driver, user);

		boolean Acctualenable = UserPage.leftsidefirstitemcheckbox.isEnabled();
		boolean Expectedenable = true;

		TestCasePrint("CHECK BOX ENABLE", Expectedenable, Acctualenable);

	}

//******************CHECK THE TRANSACTION ARROW******************	

	public static void transactionRightArrow() throws InterruptedException {

		PageFactory.initElements(driver, user);
		try {
			if (UserPage.sendrightarrow.isDisplayed()) {

				boolean Acctualtra = UserPage.sendrightarrow.isDisplayed();
				boolean Expectedetra = true;

				TestCasePrint("RIGHT SIDE TRANSFER ARROW VISIBLE", Expectedetra, Acctualtra);

				try {
					if (UserPage.sendrightarrow.isEnabled()) {

						boolean Acctualena = UserPage.sendrightarrow.isEnabled();
						boolean Expectedena = true;

						TestCasePrint("RIGHT SIDE TRANSFER ARROW ENABLE", Expectedena, Acctualena);

					} else {
						testCase = extent.createTest("RIGHT SIDE TRANSFER ARROW VISIBLE");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("BUTTON Locator");
					testCase.log(Status.INFO, "Dont Have Image Locator");
					testCase.log(Status.FAIL, " Dont Have Image Locator");
				}

			} else {
				testCase = extent.createTest("RIGHT SIDE TRANSFER ARROW ENABLE");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("BUTTON Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}
	}

	static String username = null;

//******************SELECT ONE RECORD BY USENAME******************

	public static void exceldata() throws InterruptedException, IOException {

		PageFactory.initElements(driver, user);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "User";
		String testCaseId = "TC-USER-0089";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("User");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			row.getCell(1).getBooleanCellValue();
			username = (String) row.getCell(2).getStringCellValue();
			usertype = (String) row.getCell(3).getStringCellValue();
			role = (String) row.getCell(4).getStringCellValue();

			// driver.findElement(By.xpath("//td[text()='" + username +
			// "']//preceding-sibling::td/label")).click();

		}
	}

	// ******************SELECT ONE RECORD BY USENAME******************

	public static void exceldata105() throws InterruptedException, IOException {

		PageFactory.initElements(driver, user);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "User";
		String testCaseId = "TC-USER-0105";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("User");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			row.getCell(1).getBooleanCellValue();
			selectusername = (String) row.getCell(2).getStringCellValue();

		}
	}

	public static void searchData105() throws InterruptedException {
		Thread.sleep(2000);

		PageFactory.initElements(driver, user);

		int rowcount = UserPage.transferlistusernameRowCountrightside.size();
		System.out.println("row count " + rowcount);
		boolean click = false;
		boolean enable = true;
		while (enable) {
			Thread.sleep(2000);
			for (int i = 2; i <= rowcount; i++) {
				Thread.sleep(500);
				WebElement username1 = driver.findElement(By.xpath(UserPage.transferlistusernameRowCountrightsideBefore
						+ i + UserPage.transferlistusernameRowCountrightsideAfter));
				Thread.sleep(500);
				String usernametext = username1.getText();
				Thread.sleep(500);
				System.out.println(usernametext);
				if (usernametext.contentEquals(selectusername)) {

					driver.findElement(By.xpath("//td[text()='" + selectusername + "']//preceding-sibling::td/label"))
							.click();

				}
			}

			if (click) {
				break;
			}

			enable = UserPage.transferlistNextPageBtn.isEnabled();
			if (enable) {
				UserPage.transferlistNextPageBtn.click();
			}
		}
	}

	public static void searchDatafromemail() throws InterruptedException {
		Thread.sleep(2000);

		PageFactory.initElements(driver, user);

		int rowcount = UserPage.transferlistusernameRowCount.size();
		System.out.println("row count " + rowcount);
		boolean click = false;
		boolean enable = true;
		while (enable) {
			Thread.sleep(2000);
			for (int i = 2; i <= rowcount; i++) {
				Thread.sleep(500);
				WebElement username1 = driver.findElement(
						By.xpath(UserPage.transferlistusernameBefore + i + UserPage.transferlistusernameAfter));
				Thread.sleep(500);
				String usernametext = username1.getText();
				Thread.sleep(500);
				System.out.println(usernametext);
				if (usernametext.contentEquals(username)) {

					driver.findElement(By.xpath("//td[text()='" + username + "']//preceding-sibling::td/label"))
							.click();

				}
			}

			if (click) {
				break;
			}

			enable = UserPage.transferlistNextPageBtn.isEnabled();
			if (enable) {
				UserPage.transferlistNextPageBtn.click();
			}
		}
	}

	// ******************SELECT ONE RECORD BY USENAME******************

	public static void exceldata47() throws InterruptedException, IOException {

		PageFactory.initElements(driver, user);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "User";
		String testCaseId = "TC-USER-0047";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("User");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			row.getCell(1).getBooleanCellValue();
			username47 = (String) row.getCell(2).getStringCellValue();
			usertype47 = (String) row.getCell(3).getStringCellValue();
			role47 = (String) row.getCell(4).getStringCellValue();

		}
	}

	public static void selectusertname47() throws InterruptedException, IOException {

		// PageFactory.initElements(driver, EmployeePg);
		PageFactory.initElements(driver, plant);
		PageFactory.initElements(driver, src);

		boolean nextBtn = PlantEquipmentPage.next.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_first;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);

			}
			boolean isExist = list.contains(username47);
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

		driver.findElement(By.xpath("//td[text()='" + username47 + "']//preceding-sibling::td/label")).click();
	}

	public static void exceldata43() throws InterruptedException, IOException {

		PageFactory.initElements(driver, user);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "User";
		String testCaseId = "TC-USER-0043";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("User");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			row.getCell(1).getBooleanCellValue();
			username43 = (String) row.getCell(2).getStringCellValue();
			data = (String) row.getCell(3).getStringCellValue();
			data1 = data = (String) row.getCell(4).getStringCellValue();

		}
	}

	public static void selectusertname43() throws InterruptedException, IOException {

		PageFactory.initElements(driver, user);
		PageFactory.initElements(driver, plantequ);
		PageFactory.initElements(driver, src);

		boolean nextBtn = PlantEquipmentPage.next.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_first;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);

			}
			boolean isExist = list.contains(username43);
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

	public static void clickmoreselectusertname43() throws InterruptedException, IOException {

		try {

			if (driver.findElement(By.xpath("//td[text()='" + username43 + "']//following-sibling::td[7]//span/span"))
					.isDisplayed()) {

				testCase = extent.createTest("STEP 5-MORE ICON DISPLAY");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver
						.findElement(By.xpath("//td[text()='" + username43 + "']//following-sibling::td[7]//span/span"))
						.isEnabled()) {
					testCase = extent.createTest("STEP 5-MORE ICON ENABLE");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(
								By.xpath("//td[text()='" + username43 + "']//following-sibling::td[7]//span/span"))
								.click();

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

//******************PASS THE VALUE FOR THE USER TYPE DROPDOWN******************	

	public static void checkUserTypeDropDownData() throws InterruptedException {

		PageFactory.initElements(driver, user);

		if (check) {

			Thread.sleep(5000);
			for (int j = 1; j <= 1; j++) {
				WebElement name = driver
						.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[" + j + "]"));
				String dropcontent = name.getText();
				if (dropcontent.contentEquals(usertype47)) {
					name.click();
					pass = true;

				} else if (dropcontent.isEmpty()) {
					pass = true;
				}

			}

		}

		String Actualvaluse = driver
				.findElement(By.xpath("//div[@class='ant-select-selector']//span[@title='PLANT_USER']")).getText();
		System.out.println("user type " + Actualvaluse);
		String Expectedvalue = usertype47;

		TestCasePrint("SELECT-VALUE-FROM-USER-TYPE-DROP-DOWN", Expectedvalue, Actualvaluse);

	}

//******************PASS THE VALUE FOR THE ROLE DROPDOWN******************

	static String role = null;

	public static void checkRoleDropDownData() throws InterruptedException, IOException {

		PageFactory.initElements(driver, user);

		if (check) {

			Thread.sleep(5000);
			for (int j = 1; j <= 10; j++) {
				WebElement name = driver
						.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[" + j + "]/div/span"));
				String dropcontent = name.getText();
				if (dropcontent.contentEquals(role47)) {
					name.click();
					pass = true;

				} else if (dropcontent.isEmpty()) {
					pass = true;
				}

			}

		}
		String Actualvaluse = driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']//div[@name='role']"))
				.getText();
		System.out.println("role  " + Actualvaluse);
		String Expectedvalue = role47;

		TestCasePrint("SELECT-VALUE-FROM-ROLE-DROP-DOWN", Expectedvalue, Actualvaluse);

		Thread.sleep(3000);
		UserPage.searchhereplaceholder.click();
	}

//******************CHECK WHETHER LAST ADDED VALUSE HAS COME TO FIRST******************

	public static void checkLastAddvalue() throws InterruptedException {

		PageFactory.initElements(driver, user);
		Thread.sleep(2000);
		String actualdata = UserPage.firstuserValue.getText();
		System.out.println("First row of table : " + actualdata);

		String expecteddata = username;

		TestCasePrint("CHECK THE LAST ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE", expecteddata, actualdata);

	}

//******************CHECK WEATHER MODAL IS CLOSED******************

	public static void modalClose() throws InterruptedException {

		PageFactory.initElements(driver, user);

		UserPage.adduserscancelbutton.click();
//
//		Actions action = new Actions(driver);
//		action.moveByOffset(0, 0).click().build().perform();

		boolean AcctualAfterClick = UserPage.modal.isDisplayed();
		boolean ExpectedAfterClick = true;

		TestCasePrint("MODAL-INVISIBLE-ONCLICK-OUTSIDE", ExpectedAfterClick, AcctualAfterClick);

	}

//******************SELECT A DATA TO EDIT ROLE ALLOCATION BY NAME******************

	static String name = null;

	public static void searchspecificdatatoeditroleAllocation() throws IOException, InterruptedException {
		PageFactory.initElements(driver, user);

		Thread.sleep(1000);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "User";
		String testCaseId = "TC-USER-0099";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("User");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			row.getCell(1).getBooleanCellValue();
			name = (String) row.getCell(2).getStringCellValue();

			// driver.findElement(By.xpath("//td[text()='" + name +
			// "']//following-sibling::td[6]//span/span")).click();
		}
	}

	public static void search() throws InterruptedException {
		Thread.sleep(2000);
		int rowcount = UserPage.usernameRowCount.size();
		boolean click = false;
		boolean enable = true;
		while (enable) {
			Thread.sleep(2000);
			for (int i = 2; i <= rowcount; i++) {
				Thread.sleep(500);
				WebElement username = driver
						.findElement(By.xpath(UserPage.usernameBefore + i + UserPage.usernameAfter));
				Thread.sleep(500);
				String usernametext = username.getText();
				Thread.sleep(500);
				System.out.println(usernametext);
				if (usernametext.contentEquals(name)) {
					WebElement roleAllo = driver
							.findElement(By.xpath(UserPage.roleAllocationBefore + i + UserPage.roleAllocationAfter));

					boolean visible = false;
					try {
						TestCasePrint("STEP 4-ROLE ALLOCATION EDIT BUTTON IS VISIBLE", true, roleAllo.isDisplayed());
						visible = true;
					} catch (NoSuchElementException e) {
						TestCasePrint("STEP 4-ROLE ALLOCATION EDIT BUTTON IS NOT VISIBLE", true,
								roleAllo.isDisplayed());
					}

					boolean enableed = false;
					try {
						TestCasePrint("STEP 4-ROLE ALLOCATION EDIT BUTTON IS ENABLED", true, roleAllo.isEnabled());
						enableed = true;
					} catch (NoSuchElementException e) {
						TestCasePrint("STEP 4-ROLE ALLOCATION EDIT BUTTON IS NOT ENABLED", true, roleAllo.isEnabled());
					}

					if (visible && enableed) {
						roleAllo.click();
						click = true;
						break;
					}

				}
			}

			if (click) {
				break;
			}

			enable = UserPage.NextPageBtn.isEnabled();
			if (enable) {
				UserPage.NextPageBtn.click();
			}
		}
	}

	public static void searchedit() throws InterruptedException {

		driver.findElement(By.xpath("//td[text()='" + name + "']//following-sibling::td[6]//span/span")).click();
	}

	static String roledropdown = null;
	static String Actualdata = null;

//******************EDIT THE PLANT ROLE******************

	public static void plantRoleEdit() throws InterruptedException, IOException {

		PageFactory.initElements(driver, user);

		Thread.sleep(1000);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "User";
		String testCaseId = "TC-USER-0099";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("User");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(1).getBooleanCellValue();
//			name = (String) row.getCell(2).getStringCellValue();
			roledropdown = (String) row.getCell(3).getStringCellValue();

			if (check)
				Thread.sleep(5000);
			for (int j = 1; j <= 10; j++) {
				WebElement name1 = driver
						.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[" + j + "]"));
				String dropcontent1 = name1.getText();

				if (dropcontent1.contentEquals(roledropdown)) {
					name1.click();
				} else if (dropcontent1.isEmpty()) {
				}

			}

			Thread.sleep(2000);

			Actualdata = UserPage.plantroldropdowntext.getText();

		}
	}

//******************CHECK THE PLANT ROLE HAS EDITED CORRECTLY******************	

	public static void checkthedata() {
		PageFactory.initElements(driver, user);

		String Expecteddata = UserPage.plantroldropdowntext.getText();
		System.out.println(Expecteddata);

		TestCasePrint("STEP 10-EDIT-ROLE-ALLOCATION", Expecteddata, Actualdata);
	}

//******************CHECK THE PROPERTIES OF THE SAEV BUTTON******************

	public static void SaveButton() {
		PageFactory.initElements(driver, user);

		try {
			if (UserPage.addusersavebutton.isDisplayed()) {

				// button Displayed

				boolean ActualbiuttonDisplay = UserPage.addusersavebutton.isDisplayed();
				boolean ExpectedbuttonDisplay = true;
				TestCasePrint("ADD-USER-SAVE-BUTTON-DISPLAYED", ExpectedbuttonDisplay, ActualbiuttonDisplay);

				try {
					if (UserPage.addusersavebutton.isEnabled()) {

						// button enabled

						boolean ActualImageDisplay = UserPage.addusersavebutton.isEnabled();
						boolean ExpectedImageDisplay = true;
						TestCasePrint("ADD-USER-SAVE-BUTTON-ENABLED", ExpectedImageDisplay, ActualImageDisplay);

						// check font size

						String ActualfontsSize = UserPage.addusersavebutton.getCssValue("font-size");
						System.out.println("Font Size: " + ActualfontsSize);

						String ExpectedfontsSize = "14px";

						TestCasePrint("ADD-USER-SAVE-BUTTON-FONT-SIZE", ExpectedfontsSize, ActualfontsSize);

						// Check the size

						Dimension ActualSize = UserPage.addusersavebutton.getSize();
						System.out.println("Size :" + ActualSize);
						Dimension ExpectedSize = new Dimension(60, 32);

						TestCasePrint("ADD-USER-SAVE-BUTTON-SIZE", ExpectedSize, ActualSize);

						// Check test button color

						String ActualColour = UserPage.addusersavebutton.getCssValue("background-color");
						System.out.println("rgb :" + ActualColour);

						// String hexcolour = Color.fromString(ActualColour).asHex();
						String ExpectedColour = "rgba(0, 19, 40, 1)";

						TestCasePrint("ADD-USER-SAVE-BUTTON-COLOUR", ExpectedColour, ActualColour);

						// Check border colour

						String ActualBorderColour = UserPage.addusersavebutton.getCssValue("border-color");
						System.out.println("rgb :" + ActualBorderColour);

						// String hexcolour = Color.fromString(ActualColour).asHex();
						String ExpectedBorderColour = "rgb(255, 255, 255)";

						TestCasePrint("ADD-USER-SAVE-BORDER-COLOUR", ExpectedBorderColour, ActualBorderColour);

						// check the font colour

						String ActualfontsColour = UserPage.addusersavebutton.getCssValue("color");
						System.out.println("Font colour: " + ActualfontsColour);

						String ExpectedfontsColour = "rgba(255, 255, 255, 1)";

						TestCasePrint("ADD-USER-SAVE-BUTTON-FONT-COLOUR", ExpectedfontsColour, ActualfontsColour);

						// check the font type

						String ActualfontsType = UserPage.addusersavebutton.getCssValue("font-style");
						System.out.println("Font type: " + ActualfontsType);

						String ExpectedfontsType = "normal";

						TestCasePrint("ADD-USER-SAVE-BUTTON-FONT-TYPE", ExpectedfontsType, ActualfontsType);

						// check text

						String ActualText = UserPage.addusersavebutton.getText();
						System.out.println("Text : " + ActualText);

						String ExpectedText = "Save";

						TestCasePrint("ADD-USER-SAVE-BUTTON-TEXT", ExpectedText, ActualText);

						// check cursor

						String ActualActions = UserPage.addusersavebutton.getCssValue("cursor");
						System.out.println("cursor :" + ActualActions);
						String ExpectedActions = "pointer";

						TestCasePrint("ADD-USER-SAVE-BUTTON-CURSOR-TYPE", ExpectedActions, ActualActions);

						// check button shape

						String ActualShape = UserPage.addusersavebutton.getCssValue("border-radius");
						System.out.println("shape :" + ActualShape);
						String ExpectedShape = "2px";

						TestCasePrint("USER-SAVE-BUTTON-SHAPE", ExpectedShape, ActualShape);

						// check box shadow

						String ActualShadow = UserPage.addusersavebutton.getCssValue("box-shadow");
						System.out.println("shadow :" + ActualShadow);
						String ExpectedShadow = "rgba(0, 0, 0, 0.016) 0px 2px 0px 0px";

						TestCasePrint("ADD-USER-SAVE-BUTTON-BOX-SHADOW", ExpectedShadow, ActualShadow);

						// check padding

						String ActualPadding = UserPage.addusersavebutton.getCssValue("padding");
						System.out.println("padding :" + ActualPadding);
						String ExpectedPadding = "4px 15px";

						TestCasePrint("ADD-USER-SAVE-BUTTON-PADDING", ExpectedPadding, ActualPadding);

					} else {
						testCase = extent.createTest("ADD-USER-SAVE-BUTTON-NOT-ENABLED");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("BUTTON Locator");
					testCase.log(Status.INFO, "Dont Have Image Locator");
					testCase.log(Status.FAIL, " Dont Have Image Locator");
				}

			} else {
				testCase = extent.createTest("ADD-USER-SAVE-BUTTON-NOT-DISPLAYED");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("BUTTON Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}
	}

//******************CHECK THE PROPERTIES OF THE OK BUTTON******************

	public static void OKbutton() {

		PageFactory.initElements(driver, user);

		htmlreporter.config().setReportName("Test Report- USER MODULE-Plant Role Edit OK button properties");
		htmlreporter.config().setDocumentTitle("QDMS reports");

		try {
			if (UserPage.plantroleeditOkbutton.isDisplayed()) {

//							button Displayed

				boolean ActualbiuttonDisplay = UserPage.plantroleeditOkbutton.isDisplayed();
				boolean ExpectedbuttonDisplay = true;

				TestCasePrint("PLANT-ROLE-EDIT-OK BUTTON-DISPLAYED", ExpectedbuttonDisplay, ActualbiuttonDisplay);

				try {
					if (UserPage.plantroleeditOkbutton.isEnabled()) {

//									button enabled

						boolean ActualImageDisplay = UserPage.plantroleeditOkbutton.isEnabled();
						boolean ExpectedImageDisplay = true;

						TestCasePrint("PLANT-ROLE-EDIT-OK BUTTON-ENABLED", ExpectedImageDisplay, ActualImageDisplay);

						// check font size

						String ActualfontsSize = UserPage.plantroleeditOkbutton.getCssValue("font-size");
						System.out.println("Font Size: " + ActualfontsSize);

						String ExpectedfontsSize = "14px";

						TestCasePrint("PLANT-ROLE-EDIT-OK BUTTON-FONT-SIZE", ExpectedfontsSize, ActualfontsSize);

						// Check the size

						Dimension ActualSize = UserPage.plantroleeditOkbutton.getSize();
						System.out.println("Size :" + ActualSize);
						Dimension ExpectedSize = new Dimension(50, 32);

						TestCasePrint("PLANT-ROLE-EDIT-OK BUTTON-SIZE", ExpectedSize, ActualSize);

						// Check test button color

						String ActualColour = UserPage.plantroleeditOkbutton.getCssValue("background-color");
						System.out.println("rgb :" + ActualColour);

						// String hexcolour = Color.fromString(ActualColour).asHex();
						String ExpectedColour = "rgba(24, 144, 255, 1)";

						TestCasePrint("PLANT-ROLE-EDIT-OK BUTTON-COLOUR", ExpectedColour, ActualColour);

						// Check border colour

						String ActualBorderColour = UserPage.plantroleeditOkbutton.getCssValue("border-color");
						System.out.println("rgb :" + ActualBorderColour);

						// String hexcolour = Color.fromString(ActualColour).asHex();
						String ExpectedBorderColour = "rgb(24, 144, 255)";

						TestCasePrint("PLANT-ROLE-EDIT-OK BUTTON-BORDER-COLOUR", ExpectedBorderColour,
								ActualBorderColour);

						// check the font colour

						String ActualfontsColour = UserPage.plantroleeditOkbutton.getCssValue("color");
						System.out.println("Font colour: " + ActualfontsColour);

						String ExpectedfontsColour = "rgba(255, 255, 255, 1)";

						TestCasePrint("PLANT-ROLE-EDIT-OK BUTTON-FONT-COLOUR", ExpectedfontsColour, ActualfontsColour);

						// check the font type

						String ActualfontsType = UserPage.plantroleeditOkbutton.getCssValue("font-style");
						System.out.println("Font type: " + ActualfontsType);

						String ExpectedfontsType = "normal";

						TestCasePrint("PLANT-ROLE-EDIT-OK BUTTON-FONT-TYPE", ExpectedfontsType, ActualfontsType);
						// check text

						String ActualText = UserPage.plantroleeditOkbutton.getText();
						System.out.println("Text : " + ActualText);

						String ExpectedText = "OK";

						TestCasePrint("PLANT-ROLE-EDIT-OK BUTTON-TEXT", ExpectedText, ActualText);

						// check cursor

						String ActualActions = UserPage.plantroleeditOkbutton.getCssValue("cursor");
						System.out.println("cursor :" + ActualActions);
						String ExpectedActions = "pointer";

						TestCasePrint("PLANT-ROLE-EDIT-OK BUTTON-CURSOR-TYPE", ExpectedActions, ActualActions);

						// check button shape

						String ActualShape = UserPage.plantroleeditOkbutton.getCssValue("border-radius");
						System.out.println("shape :" + ActualShape);
						String ExpectedShape = "2px";

						TestCasePrint("PLANT-ROLE-EDIT-OK BUTTON-SHAPE", ExpectedShape, ActualShape);

						// check box shadow

						String ActualShadow = UserPage.plantroleeditOkbutton.getCssValue("box-shadow");
						System.out.println("shadow :" + ActualShadow);
						String ExpectedShadow = "rgba(0, 0, 0, 0.043) 0px 2px 0px 0px";

						TestCasePrint("PLANT-ROLE-EDIT-OK BUTTON-BOX-SHADOW", ExpectedShadow, ActualShadow);

						// check padding

						String ActualPadding = UserPage.plantroleeditOkbutton.getCssValue("padding");
						System.out.println("padding :" + ActualPadding);
						String ExpectedPadding = "4px 15px";

						TestCasePrint("PLANT-ROLE-EDIT-OK BUTTON-PADDING", ExpectedPadding, ActualPadding);

					} else {
						testCase = extent.createTest("PLANT-ROLE-EDIT-OK BUTTON-NOT-ENABLED");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("BUTTON Locator");
					testCase.log(Status.INFO, "Dont Have Image Locator");
					testCase.log(Status.FAIL, " Dont Have Image Locator");
				}

			} else {
				testCase = extent.createTest("PLANT-ROLE-EDIT-OK BUTTON-NOT-DISPLAYED");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("BUTTON Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}
		System.out.println();
	}

//******************CHECK THE CREATED TIME IS CORRECT******************

	public static void compareCreatedTime() throws InterruptedException {

		PageFactory.initElements(driver, user);

		String ActualTime = UserPage.createdtime.getText();
		String ExpectedTime = data;
		System.out.println(ActualTime);

		TestCasePrint("CREATED TIME", ExpectedTime, ActualTime);

	}

//******************CHECK THE UPDATED TIME IS CORRECT******************

	public static void compareUpdatedtedTime() throws InterruptedException {

		PageFactory.initElements(driver, user);

		String ActualTime = UserPage.updatedtime.getText();
		String ExpectedTime = data1;
		System.out.println(ActualTime);

		TestCasePrint("UPDATED TIME", ExpectedTime, ActualTime);

	}

//******************USER MODULE PAGINATION PROPERTIES******************	

	public static void paginationUser() throws InterruptedException {

		PageFactory.initElements(driver, user);

//		Default Index Page
		boolean ActualDefaultPageIndex = UserPage.DefaultPaginationPage.isDisplayed();
		boolean ExpectedDefaultPageIndex = true;

		TestCasePrint("PAGINATION-DEFAULT-PAGE-INDEX", ExpectedDefaultPageIndex, ActualDefaultPageIndex);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

//		Refresh pagination into default page 
		UserPage.NextPageBtn.click();
		Thread.sleep(20000);
		driver.navigate().refresh();
		Thread.sleep(2000);

		boolean ActualDefaultPageIndex1 = UserPage.DefaultPaginationPage.isDisplayed();
		boolean ExpectedDefaultPageIndex1 = true;

		TestCasePrint("PAGINATION-REFERESH-INTO-DEFAULT-PAGE", ExpectedDefaultPageIndex1, ActualDefaultPageIndex1);

//		Page Redirect to the next page 
		UserPage.NextPageBtn.click();
		Thread.sleep(2000);
		boolean ActualSecoundPageIndex = UserPage.PaginationSecoundPage.isDisplayed();
		boolean ExpectedSecoundPageIndex = true;

		TestCasePrint("PAGINATION-PAGE-REDIRECT-TO-NEXT-PAGE", ExpectedSecoundPageIndex, ActualSecoundPageIndex);

		// Total Text Visible
		boolean ActualVisibleTotalText = UserPage.totalTextSecondPage.isDisplayed();
		boolean ExpectedVisibleTotalText = true;

		TestCasePrint("PAGINATION_TOTAL_TEXT_VISIBLE", ExpectedVisibleTotalText, ActualVisibleTotalText);

		// number of rows
		int TotalRowActual = UserPage.totalrows.size();
		System.out.println("Number of rows " + TotalRowActual);

		int TotalRowExpected = 11;

		TestCasePrint("TOTAL-ROW", TotalRowExpected, TotalRowActual);

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	static int page10 = 0;
	static int page20 = 0;
	static int page30 = 0;

//******************COMPARE THE DATA IN EACH PAGINATION******************

	public static void pagedata() throws IOException, InterruptedException {

		PageFactory.initElements(driver, user);
		Thread.sleep(1000);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "User";
		String testCaseId = "TC-USER-0057";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("User");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			row.getCell(1).getBooleanCellValue();
			page10 = (int) row.getCell(2).getNumericCellValue();
			page20 = (int) row.getCell(3).getNumericCellValue();
			page30 = (int) row.getCell(4).getNumericCellValue();
		}
	}

//******************USER MODULE PAGINATION FUNCTION******************

	public static void paginationtUserFunction() throws InterruptedException {

		PageFactory.initElements(driver, user);

		System.out.println(UserPage.CurrentPaginationOpction.getText());
		Thread.sleep(2000);

		if (UserPage.CurrentPaginationOpction.getText().contentEquals("10 / page")) {
			int ActualPageIndex_10 = (UserPage.usernameColumn.size() - 1);
			int ExpectedOageIndex_10 = page10;

			if (0 <= ActualPageIndex_10) {
				if (ActualPageIndex_10 <= 10) {
					TestCasePrint("PAGINATION-TOTAL-DATA-OF-10/PAGE-INDEX", ExpectedOageIndex_10, ActualPageIndex_10);

				} else {
					testCase.log(Status.INFO,
							"Current Pagination Opction :- " + UserPage.CurrentPaginationOpction.getText());
					testCase.log(Status.INFO, "Actual TotalData :- " + ActualPageIndex_10);
					testCase.log(Status.FAIL, "Wrong TotalData");
				}
			} else {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + UserPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual TotalData :- " + ActualPageIndex_10);
				testCase.log(Status.FAIL, "Wrong TotalData");
			}

		}
//			Total Count of the 20/page index
		else if (UserPage.CurrentPaginationOpction.getText().contentEquals("20 / page")) {
			int ActualPageIndex_20 = (UserPage.when20usernamecolumn.size() - 1);
			System.out.println((UserPage.when20usernamecolumn.size() - 1));
			int ExpectedPageIndex_20 = page20;

			if (0 <= ActualPageIndex_20) {
				if (ActualPageIndex_20 <= 20) {

					TestCasePrint("PAGINATION-TOTAL-DATA-OF-20/PAGE-INDEX", ExpectedPageIndex_20, ActualPageIndex_20);
				} else {
					testCase.log(Status.INFO,
							"Current Pagination Opction :- " + UserPage.CurrentPaginationOpction.getText());
					testCase.log(Status.INFO, "Actual TotalData :- " + ActualPageIndex_20);
					testCase.log(Status.FAIL, "Wrong TotalData");
				}
			} else {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + UserPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual TotalData :- " + ActualPageIndex_20);
				testCase.log(Status.FAIL, "Wrong TotalData");
			}

		}
//			Total Count of the 30/page index

		else if (UserPage.DefaultPaginationPage30.getText().contentEquals("30 / page")) {

			int ActualPageIndex_30 = (UserPage.when30usernamecolumn.size() - 1);
			System.out.println((UserPage.when30usernamecolumn.size() - 1));
			int ExpectedPageIndex_30 = page30;

			if (0 <= ActualPageIndex_30) {
				if (ActualPageIndex_30 <= 30) {

					TestCasePrint("PAGINATION-TOTAL-DATA-OF-30/PAGE-INDEX", ExpectedPageIndex_30, ActualPageIndex_30);
				} else {
					testCase.log(Status.INFO,
							"Current Pagination Opction :- " + UserPage.CurrentPaginationOpction.getText());
					testCase.log(Status.INFO, "Actual TotalData :- " + ActualPageIndex_30);
					testCase.log(Status.FAIL, "Wrong TotalData");
				}
			} else {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + UserPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual TotalData :- " + ActualPageIndex_30);
				testCase.log(Status.FAIL, "Wrong TotalData");
			}

			Thread.sleep(2000);
		}

//			Total Count of the 100/page index
		else if (UserPage.CurrentPaginationOpction.getText().contentEquals("100 / page")) {
			int ActualPageIndex_100 = (UserPage.usernameColumn.size() - 1);
			int expectedPageIndex_100 = 100;

			if (0 <= ActualPageIndex_100) {
				if (ActualPageIndex_100 <= 100) {

					TestCasePrint("PAGINATION-TOTAL-DATA-OF-100/PAGE-INDEX", expectedPageIndex_100,
							ActualPageIndex_100);
				} else {
					testCase.log(Status.INFO,
							"Current Pagination Opction :- " + UserPage.CurrentPaginationOpction.getText());
					testCase.log(Status.INFO, "Actual TotalData :- " + ActualPageIndex_100);
					testCase.log(Status.FAIL, "Wrong TotalData");
				}
			} else {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + UserPage.CurrentPaginationOpction.getText());
				testCase.log(Status.INFO, "Actual TotalData :- " + ActualPageIndex_100);
				testCase.log(Status.FAIL, "Wrong TotalData");
			}

		}
	}

//******************NAVIGATE TO THE LAST PAGE******************

	public static void lastpage() throws InterruptedException {

		PageFactory.initElements(driver, user);

		boolean clickNextPage = true;

		// ArrayList<String> AfterstringList = new ArrayList<String>();

//		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
//		String NameXpath_lastPart = "]/td[1]";
		while (clickNextPage) {

//			for (int i = 2; i < 18; i++) {
//
//				try {
//					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
//					
//					System.out.println(text);
//					AfterCount = AfterCount + 1;
//					AfterstringList.add(text);
//				} catch (Exception e) {
//				}
//			}
			try {
				if (clickNextPage == true) {
					clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
							.isEnabled();
					System.out.println(clickNextPage);
					Thread.sleep(2000);
					driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
					Thread.sleep(2000);
				}
			} catch (Exception e) {

			}
			// TODO: handle exception
		}

	}

	static String name2 = null;

//SEARCH SPECIFIC DATA TO EDIT THE ROLE ALLOCATION IN THE LAST PAGE******************

	public static void searchspecificdatatoeditroleAllocationLastPage() throws InterruptedException, IOException {
		PageFactory.initElements(driver, user);

		Thread.sleep(1000);

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Data-equipment-material-user.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("usertable_username_lastpage");

		int rowcount = sheet.getLastRowNum();
		for (int i = 0; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);

			row.getCell(0).getBooleanCellValue();
			name2 = (String) row.getCell(1).getStringCellValue();

			driver.findElement(By.xpath("//td[text()='" + name2 + "']//following-sibling::td[6]//span/span")).click();
		}
	}

//******************SEARCH SPECIFIC DATA TO EDIT THE ROLE ALLOCATION IN THE SECONFD PAGE

	public static void searchspecificdatatoeditroleAllocatioSecondPage(String data) {

		PageFactory.initElements(driver, user);

		driver.findElement(By.xpath("//td[text()='" + data + "']//following-sibling::td[6]//span/span")).click();
	}

//******************EDIT PLANT ROLE IN THE SECOND PAGE******************

	public static void plantRoleEditSecondPage() throws InterruptedException {

		PageFactory.initElements(driver, user);

		// List<WebElement> options = UserPage.usertypeoptions;

		String value = null;

		for (WebElement options : UserPage.plantroledropdowncontent) {
			value = options.getText();
			Thread.sleep(2000);
			System.out.println(value);
			System.out.println();
			if (value.valueOf(1) != null)
				Thread.sleep(2000);
			System.out.println(value.valueOf(1));
			Thread.sleep(2000);

			options.click();

		}
		Thread.sleep(2000);
		// STEP 5- CLICK ON SOMEWHERE INSIDE THE MODAL TO CLOSE THE DROPDOWN LIST
		UserPage.plantroleeditmodelheading.click();

		OKbutton();

		String Actualdata = UserPage.plantroledropdown.getText();

		// STEP 7- CLICK ON "OK" BUTTON
		UserPage.plantroleeditOkbutton.click();

		Thread.sleep(2000);

		searchspecificdatatoeditroleAllocatioSecondPage("fipay57796@wwgoc.com");

		Thread.sleep(2000);

		String expecteddata = UserPage.plantroledropdown.getText();

		TestCasePrint("EDIT-ROLE-ALLOCATION", expecteddata, Actualdata);
	}

//******************USERNAME SEARCH ICON PROPETIES******************	

	public static void usernameSearchIcon() throws InterruptedException {

		PageFactory.initElements(driver, user);
		try {
			if (UserPage.usernamesearchicon.isDisplayed()) {

				boolean Acctualtra = UserPage.usernamesearchicon.isDisplayed();
				boolean Expectedetra = true;

				TestCasePrint("STEP 4-USERNAME SEARCH ICON IS VISIBLE", Expectedetra, Acctualtra);

				try {
					if (UserPage.usernamesearchicon.isEnabled()) {

						boolean Acctualena = UserPage.usernamesearchicon.isEnabled();
						boolean Expectedena = true;

						TestCasePrint("STEP 4-USERNAME ICON IS ENABLE", Expectedena, Acctualena);

					} else {
						testCase = extent.createTest("STEP 4-USERNAME SEARCH ICON NOT VISIBLE");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("BUTTON Locator");
					testCase.log(Status.INFO, "Dont Have Image Locator");
					testCase.log(Status.FAIL, " Dont Have Image Locator");
				}

			} else {
				testCase = extent.createTest("STEP 4-USERNAME ICON IS NOT ENABLE");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("BUTTON Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}
	}

//******************CHECK THE PROPETIES OF CONTACT NUMBER SEARCH BUTTON******************	

	public static void conductNoSearchbutton() throws InterruptedException {

		PageFactory.initElements(driver, user);
		try {
			if (UserPage.conductNosearchbutton.isDisplayed()) {

				boolean Acctualtra = UserPage.conductNosearchbutton.isDisplayed();
				boolean Expectedetra = true;

				TestCasePrint("CONDUCTNUMBER SEARCH BUTTON VISIBLE", Expectedetra, Acctualtra);

				try {
					if (UserPage.conductNosearchbutton.isEnabled()) {

						boolean Acctualena = UserPage.conductNosearchbutton.isEnabled();
						boolean Expectedena = true;

						TestCasePrint("CONDUCTNUMBER SEARCH BUTTON ENABLE", Expectedena, Acctualena);

					} else {
						testCase = extent.createTest("CONDUCTNUMBER SEARCH BUTTON NOT VISIBLE");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("BUTTON Locator");
					testCase.log(Status.INFO, "Dont Have Image Locator");
					testCase.log(Status.FAIL, " Dont Have Image Locator");
				}

			} else {
				testCase = extent.createTest("CONDUCTNUMBER BUTTON NOT ENABLE");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("BUTTON Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}
	}

//******************CHECK THE PROPETIES OF USER NAME SEARCH BUTTON******************	

	public static void usernameSearchbutton() throws InterruptedException {

		PageFactory.initElements(driver, user);
		try {
			if (UserPage.usernamesearchbutton.isDisplayed()) {

				boolean Acctualtra = UserPage.usernamesearchbutton.isDisplayed();
				boolean Expectedetra = true;

				TestCasePrint("USERNAME SEARCH BUTTON VISIBLE", Expectedetra, Acctualtra);

				try {
					if (UserPage.usernamesearchbutton.isEnabled()) {

						boolean Acctualena = UserPage.usernamesearchbutton.isEnabled();
						boolean Expectedena = true;

						TestCasePrint("USERNAME SEARCH BUTTON ENABLE", Expectedena, Acctualena);

					} else {
						testCase = extent.createTest("USERNAME SEARCH BUTTON NOT VISIBLE");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("BUTTON Locator");
					testCase.log(Status.INFO, "Dont Have Image Locator");
					testCase.log(Status.FAIL, " Dont Have Image Locator");
				}

			} else {
				testCase = extent.createTest("USERNAME BUTTON NOT ENABLE");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("BUTTON Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}
	}

//******************CHECK THE SEARCHED RECOD IS AVAILABLE OR  NOT	

	public static void searchedrecordAvailable() {

		PageFactory.initElements(driver, user);

		String act = driver.findElement(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0'][1]/td[1]"))
				.getText();
		String exp = usernamesearch;

		UserMainTests.TestCasePrint("STEP 9-SEARCHED VALUE IS AVAIABLE", exp, act);
	}

//******************NAVIGATE TO THE LAST PAGE******************

	public static void navigateLastpage() throws InterruptedException {

		PageFactory.initElements(driver, user);

		boolean clickNextPage = true;

		// ArrayList<String> BeforestringList = new ArrayList<String>();

		while (clickNextPage) {

			for (int i = 2; i < 165; i++) {

//			try {
//				
//				String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
//
//				BeforestringList.add(text);
//				BeforeCount = BeforeCount + 1;
//			} catch (Exception e) {
//			}

				if (clickNextPage == true) {
					clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
							.isEnabled();

					driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();

//		} else {
//			break;
				}
			}
		}
	}

//******************NAVIGATE TO THE LAST PAGE******************

	public static void lastpageNavigate() {

		driver.findElement(By.xpath(
				"(//li[contains(@class, 'ant-pagination-item') and not(contains(@class, 'ant-pagination-item-74'))])[last()]"))
				.click();

	}

//******************NAVIGATE TO THE  MIDDLE PGAE******************	

	public static void MidpageNavigate() {

		driver.findElement(By.xpath(
				"(//li[contains(@class, 'ant-pagination-item') and not(contains(@class, 'ant-pagination-item-74'))])[last() div 2 + 1]"))
				.click();

	}

	static int contactno = 0;
	static int contactnocount = 0;

//ContactNo search for lastpage from excel
	public static void Searchcontactnumberlastpage() throws InterruptedException, IOException {
		PageFactory.initElements(driver, user);
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("User");
		Thread.sleep(2000);
		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "User",
				"TC-USER-0059");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "User",
				"TC-USER-0059");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			System.out.println(firstrow);

			int contactno = (int) row.getCell(1).getNumericCellValue();
			System.out.println("contactno" + contactno);
			row.getCell(2).getNumericCellValue();

			Thread.sleep(2000);
			// CLICK ON "CONTACTNUMBER" PLACEHOLDER

			UserPage.conductNoSearchPlaceholdernew.sendKeys(String.valueOf(contactno));
			Thread.sleep(3000);

			// CHECK THE ENABILITY AND VISIBILITY OF THE SEARCH BUTTON
			UserMainTests.conductNoSearchbutton();

			// CLICK ON SEARCH BUTTON
			Thread.sleep(2000);
			UserPage.conductNosearchbutton.click();

			// ******************CHECK THE AVAILABILITY OF CONTACT NUMBER SEARCHED
			// RECORD******************
			Thread.sleep(3000);
			String actualdata = UserPage.conductNoSearchPlaceholdernew.getText();
			System.out.println("searchbox data : " + String.valueOf(actualdata));

			boolean firstdata = true;
			testCase = extent.createTest("THE VALUE IS AVAILABLE ");
			try {
				Thread.sleep(2000);
				AssertJUnit.assertEquals(String.valueOf(actualdata), String.valueOf(contactno));

			} catch (AssertionError e) {
				firstdata = false;
			}
			if (firstdata) {
				testCase.log(Status.INFO, "Actual Data :- " + actualdata);
				testCase.log(Status.INFO, "Expected Data :- " + contactno);
				testCase.log(Status.PASS, "THE VALUE IS AVAILABLE ");
			} else {
				testCase.log(Status.INFO, "Actual Data :- " + actualdata);
				testCase.log(Status.INFO, "Expected Data :- " + contactno);
				testCase.log(Status.FAIL, "THE VALUE IS NOT AVAILABLE ");
			}
		}

	}

	static String emailrightside = "";

	// static String plant = "";
//SEARCH RIGHT SIDE EMAIL SEARCH TAKES FROM EXCEL
	public static void SearchRightSide() throws InterruptedException, IOException {
		PageFactory.initElements(driver, user);
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("User");
		Thread.sleep(2000);
		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "User",
				"TC-USER-0108");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "User",
				"TC-USER-0108");

		for (int i = firstrow; i <= lastrow; i++) {
			Thread.sleep(2000);
			XSSFRow row = sheet.getRow(i);
			System.out.println(firstrow);
			Thread.sleep(3000);
			String emailrightside = row.getCell(1).getStringCellValue();
			System.out.println("emailrightside" + emailrightside);
			// String plantrightside =row.getCell(2).getStringCellValue();

			Thread.sleep(2000);
			UserPage.Rightsigesearchhereplaceholder.sendKeys(emailrightside);
			System.out.println(emailrightside);

			// ******************CHECK WHEATHER SEARCHED DATA IS AVAILBE IN THE
			// TOP******************

			PageFactory.initElements(driver, user);
			// SEARCHED EMAIL XPATH
			String act = driver.findElement(By.xpath("//td[normalize-space()='priyankamoorthy29+1@gmail.com']"))
					.getText();
			System.out.println("actual" + act);

			boolean firstdata = true;
			testCase = extent.createTest("THE SEARCHED VALUE AVAILABLILITY");
			try {
				Thread.sleep(2000);
				AssertJUnit.assertEquals(act, emailrightside);

			} catch (AssertionError e) {
				firstdata = false;
			}
			if (firstdata) {
				testCase.log(Status.INFO, "Actual Data :- " + act);
				testCase.log(Status.INFO, "Expected Data :- " + emailrightside);
				testCase.log(Status.PASS, "THE SEARCHED VALUE IS AVAILABLE");
			} else {
				testCase.log(Status.INFO, "Actual Data :- " + act);
				testCase.log(Status.INFO, "Expected Data :- " + emailrightside);
				testCase.log(Status.FAIL, "THE SEARCHED VALUE IS NOT AVAILABLE");
			}

		}
	}

//******************CHECK THE PROPERTIES OF EMPLOYEE SEARCH ICON******************	

	public static void employeeSearchIcon() throws InterruptedException {

		PageFactory.initElements(driver, user);
		try {
			if (UserPage.employeesearchicon.isDisplayed()) {

				boolean Acctualtra = UserPage.employeesearchicon.isDisplayed();
				boolean Expectedetra = true;

				TestCasePrint("STEP 4-EMPLOYEE SEARCH ICON IS VISIBLE", Expectedetra, Acctualtra);

				try {
					if (UserPage.usernamesearchicon.isEnabled()) {

						boolean Acctualena = UserPage.employeesearchicon.isEnabled();
						boolean Expectedena = true;

						TestCasePrint("STEP 4-EMPLOYEE ICON IS ENABLE", Expectedena, Acctualena);

					} else {
						testCase = extent.createTest("STEP 4-EMPLOYEE SEARCH ICON NOT VISIBLE");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("BUTTON Locator");
					testCase.log(Status.INFO, "Dont Have Image Locator");
					testCase.log(Status.FAIL, " Dont Have Image Locator");
				}

			} else {
				testCase = extent.createTest("STEP 4-EMPLOYEE ICON IS NOT ENABLE");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("BUTTON Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}
	}

//******************CHECK THE PROPERTIES OF EMPLYEE SEACH BUTTON******************

	public static void employeeSearchbutton() throws InterruptedException {

		PageFactory.initElements(driver, user);
		try {
			if (UserPage.employeesearchbutton.isDisplayed()) {

				boolean Acctualtra = UserPage.employeesearchbutton.isDisplayed();
				boolean Expectedetra = true;

				TestCasePrint("STEP 7-EMPLOYEE SEARCH BUTTON VISIBLE", Expectedetra, Acctualtra);

				try {
					if (UserPage.employeesearchbutton.isEnabled()) {

						boolean Acctualena = UserPage.employeesearchbutton.isEnabled();
						boolean Expectedena = true;

						TestCasePrint("STEP 7-EMPLOYEE SEARCH BUTTON ENABLE", Expectedena, Acctualena);

					} else {
						testCase = extent.createTest("STEP 7-EMPLOYEE SEARCH BUTTON NOT VISIBLE");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("BUTTON Locator");
					testCase.log(Status.INFO, "Dont Have Image Locator");
					testCase.log(Status.FAIL, " Dont Have Image Locator");
				}

			} else {
				testCase = extent.createTest("STEP 7-EMPLOYEE SEARCH BUTTON NOT ENABLE");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("BUTTON Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}
	}

//******************CHECK THE SEARCHED RECORD IS VAIABLE IN THE LAST PAGE******************

	public static void searchedrecordAvailableinLastpage() {

		PageFactory.initElements(driver, user);

		String act = driver.findElement(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0'][1]/td[2]"))
				.getText();
		String exp = employeesearch;

		UserMainTests.TestCasePrint("STEP 9-SEARCHED VALUE IS AVAILABLE", exp, act);
	}

//multiple search

//******************MULTIPLE SEARCH IN USER MODULE******************

	public List<String> tableColumnList(List<String> list, List<WebElement> elements) throws InterruptedException {
		PageFactory.initElements(driver, user);
		try {

			boolean nextBtn = user.next.isEnabled();

			nextBtn = true;
			while (nextBtn) {

				for (WebElement linkElement : elements) {
					String linkText = linkElement.getText();

					list.add(linkText);
					System.out.println(linkText);

				}

				nextBtn = user.next.isEnabled();
				if (nextBtn) {
					Thread.sleep(2000);
					user.next.click();

				} else
					break;

			}
		} catch (Exception e) {
		}

		return list;

	}

//******************ADD USER BUTTON PROPERTIES******************

	static void adduserButton() throws InterruptedException {

		PageFactory.initElements(driver, user);
		try {
			if (UserPage.adduserbutton.isDisplayed()) {

				boolean Acctualtra = UserPage.adduserbutton.isDisplayed();
				boolean Expectedetra = true;

				TestCasePrint("STEP 3-ADD USER BUTTON VISIBLE", Expectedetra, Acctualtra);

				try {
					if (UserPage.adduserbutton.isEnabled()) {

						boolean Acctualena = UserPage.adduserbutton.isEnabled();
						boolean Expectedena = true;

						TestCasePrint("STEP 3-ADD USER BUTTON ENABLE", Expectedena, Acctualena);

					} else {
						testCase = extent.createTest("ADD USER BUTTON NOT VISIBLE");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("BUTTON Locator");
					testCase.log(Status.INFO, "Dont Have Image Locator");
					testCase.log(Status.FAIL, " Dont Have Image Locator");
				}

			} else {
				testCase = extent.createTest("STEP 3-ADD USER NOT ENABLE");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("BUTTON Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}
	}

	public static void searchedrecordAvailableintop() {

		PageFactory.initElements(driver, user);

		String act = driver.findElement(By.xpath(
				"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr/td[2]"))
				.getText();
		String exp = expectedtopdata;

		UserMainTests.TestCasePrint("USER VALUE IS AVAIABLE ON LEFT SIDE TOP", exp, act);
	}

	public static void searchedPalntrecordAvailableintop() {

		PageFactory.initElements(driver, user);

		String act = driver.findElement(By.xpath(
				"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr/td[3]"))
				.getText();
		String exp = expectedplantrecordontop;

		UserMainTests.TestCasePrint("PLANT VALUE IS AVAIABLE ON LEFT SIDE TOP", exp, act);
	}

//******************PASS DATA FOR THE PLACEHOLDER******************

	static String usernametransferlist = null;
	static String plant = null;

	public static void placeholdrdata() throws IOException, InterruptedException {

		PageFactory.initElements(driver, user);
		Thread.sleep(1000);

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Data-equipment-material-user.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("user_placeholderdata");

		sheet.getLastRowNum();
		for (int i = 0; i < 1; i++) {
			XSSFRow row = sheet.getRow(i);

			row.getCell(0).getBooleanCellValue();
			usernametransferlist = (String) row.getCell(1).getStringCellValue();
			plant = (String) row.getCell(2).getStringCellValue();

		}
	}

	// ******************SELECT ONE RECORD BY USENAME******************

	public static void exceldata72_73() throws InterruptedException, IOException {

		PageFactory.initElements(driver, user);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "User";
		String testCaseId = "TC-USER-0072";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("User");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			row.getCell(1).getBooleanCellValue();
			toggleoff = (String) row.getCell(2).getStringCellValue();
			toggleoffcolour = (String) row.getCell(3).getStringCellValue();
			toggleon = (String) row.getCell(4).getStringCellValue();
			toggleoncolour = (String) row.getCell(5).getStringCellValue();

		}
	}

//******************CHECK THE TOGGLE BUTTON PROPETIES******************

	public static void toggleButtonOff() {

		PageFactory.initElements(driver, user);

		try {
			if (UserPage.togglebuttonoff.isDisplayed()) {

				boolean actToggle = UserPage.togglebuttonoff.isEnabled();
				System.out.println("toggle button status " + actToggle);
				boolean exptoggle = true;

				TestCasePrint("TOGGLE BUTTON IS ENABLE", exptoggle, actToggle);

				String actOffText = UserPage.togglebuttonofftext.getText();
				String expOffText = toggleoff;

				TestCasePrint("OFF TOGGLE TEXT IS CORRECT", expOffText, actOffText);

				String actOffColour = UserPage.togglebuttonoff.getCssValue("background-color");
				String expOffColour = toggleoffcolour;

				TestCasePrint("OFF TOGGLE COLOUR", expOffColour, actOffColour);

			} else {
				testCase = extent.createTest("TOGGLE BUTTON IS NOT VISIBLE");
				testCase.log(Status.INFO, " Not Displayed");
				testCase.log(Status.FAIL, " Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("TOGGLE BUTTON IS NOT VISIBLE");
			testCase.log(Status.INFO, "Dont Have Locator");
			testCase.log(Status.FAIL, " Dont Have Locator");
		}

	}

//******************CHECK THE SELECT PLANT DROP DOWN WHEN TOGGLE BUTTON IS NOT ON******************

	public static void selectPlantDropdowntogglenotON() {

		PageFactory.initElements(driver, user);

		boolean actToggle = UserPage.addplantdropdown.isDisplayed();
		System.out.println("add plant status " + actToggle);
		boolean exptoggle = false;

		TestCasePrint("SELECT PLANT DROP DOWN IS NOT VISIBLE", exptoggle, actToggle);
	}

//******************CHECK THE SELECT TYPE DROPDAOWN WHEN TOGGLE BUTTON IS NOT ON******************

	public static void selectypeDropdowntogglenotON() {

		PageFactory.initElements(driver, user);

		boolean actToggle = UserPage.addplantdropdown.isDisplayed();
		System.out.println("add plant status " + actToggle);
		boolean exptoggle = false;

		TestCasePrint("SELECT THE TYPE DROP DOWN IS NOT VISIBLE", exptoggle, actToggle);
	}

//******************CHEKC THE TOGGLE BUTTON WHEN IT IS ON******************

	public static void toggleButtonOn() {

		PageFactory.initElements(driver, user);

		try {
			if (UserPage.togglebuttonoff.isDisplayed()) {

				boolean actToggle = UserPage.togglebuttonoff.isEnabled();
				System.out.println("toggle button status " + actToggle);
				boolean exptoggle = true;

				TestCasePrint("TOGGLE BUTTON IS ENABLE", exptoggle, actToggle);

				String actOffText = UserPage.togglebuttonofftext.getText();
				String expOffText = toggleon;

				TestCasePrint("ON TOGGLE TEXT IS CORRECT", expOffText, actOffText);

				String actOffColour = UserPage.togglebuttonoff.getCssValue("background-color");
				String expOffColour = toggleoncolour;

				TestCasePrint("ON TOGGLE COLOUR", expOffColour, actOffColour);

			} else {
				testCase = extent.createTest("TOGGLE BUTTON IS NOT VISIBLE");
				testCase.log(Status.INFO, " Not Displayed");
				testCase.log(Status.FAIL, " Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("TOGGLE BUTTON IS NOT VISIBLE");
			testCase.log(Status.INFO, "Dont Have Locator");
			testCase.log(Status.FAIL, " Dont Have Locator");
		}

	}

//******************CHECK THE SELECT PLANT DROPDOWN WHEN TOGGLE BUTTON IS ON******************	

	public static void selectPlantDropdowntoggleON() {

		PageFactory.initElements(driver, user);

		boolean actToggle = UserPage.addplantdropdown.isDisplayed();
		System.out.println("add plant status " + actToggle);
		boolean exptoggle = true;

		TestCasePrint("SELECT PLANT DROP DOWN IS VISIBLE", exptoggle, actToggle);
	}

//******************CHECK THE SEELCT TYPE DROPDOWN WHEN THE TOGGLE BUTTON IS ON******************

	public static void selectypeDropdowntoggleON() {

		PageFactory.initElements(driver, user);

		boolean actToggle = UserPage.addplantdropdown.isDisplayed();
		System.out.println("add plant status " + actToggle);
		boolean exptoggle = true;

		TestCasePrint("SELECT THE TYPE DROP DOWN IS VISIBLE", exptoggle, actToggle);
	}

//******************PASS VALUSES TO THE DROPDOWN WHEN TOGGLE BUTTON IS ON******************

	public static void addvaluestodropdowntogglebuttonon() throws IOException, InterruptedException {

		PageFactory.initElements(driver, user);
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "User";
		String testCaseId = "TC-USER-0103";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("User");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(1).getBooleanCellValue();
			selectPlant = (String) row.getCell(2).getStringCellValue();
			selectthetype = (String) row.getCell(3).getStringCellValue();
			usernametransferlist = (String) row.getCell(4).getStringCellValue();
			plant = (String) row.getCell(5).getStringCellValue();
			expectedtopdata = (String) row.getCell(6).getStringCellValue();
			expectedplantrecordontop = (String) row.getCell(7).getStringCellValue();

			if (check) {
				UserPage.addplantdropdownbox.click();
				Thread.sleep(5000);
				for (int j = 1; j <= 10; j++) {
					WebElement name1 = driver
							.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[" + j + "]"));
					String dropcontent1 = name1.getText();

					if (dropcontent1.contentEquals(selectPlant)) {
						name1.click();
						pass = true;
					} else if (dropcontent1.isEmpty()) {
						pass = true;
					}

				}

				UserPage.selectthetypedropdownbox.click();
				Thread.sleep(2000);
				for (int j = 1; j <= 2; j++) {
					Thread.sleep(1000);
					WebElement name2 = driver.findElement(By.xpath(
							"//div[@style='position: absolute; top: 0px; left: 0px; width: 100%;'][2]/div/div/div/div[2]/div[1]/div/div/div["
									+ j + "]/div"));
					Thread.sleep(1000);
					String dropcontent2 = name2.getText();
					Thread.sleep(1000);
					System.out.println("second dropdown" + dropcontent2);
					if (dropcontent2.contentEquals(selectthetype)) {
						name2.click();
						pass = true;
					} else if (dropcontent2.isEmpty()) {
						pass = true;
					}
				}

			}
		}
	}

//******************CHECK WHETHER THE SEARCHED VALUSE IS DISPLAYED ON THE TOP******************

	public static void searchedrecordAvailableintopleft() {

		PageFactory.initElements(driver, user);

		String act = driver.findElement(By.xpath(
				"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr/td[2]"))
				.getText();
		String exp = expectedtopdata;

		UserMainTests.TestCasePrint(" USER VALUE IS AVAIABLE AT THE RIGHT SIDE TOP", exp, act);
	}

//******************CHECK WHEATHER THE RIGHT SIDE ARROW BUTTON IS DISABLE OR NOT******************	

	public static void rightSideArrowDiabale() {

		PageFactory.initElements(driver, user);

		boolean actarroright = UserPage.rightsidearrow.isEnabled();
		System.out.println("right side arrow " + actarroright);
		boolean exparroright = false;

		TestCasePrint("RIGHT ARROW IS DISABLE", exparroright, actarroright);

	}

//******************CHECK WEATHER THE LEFT SIDE ARROW IS DIABLE OR NOT******************	

	public static void leftSideArrowDisable() {

		PageFactory.initElements(driver, user);

		boolean actToggle = UserPage.lefttsidearrow.isEnabled();
		System.out.println("toggle button status " + actToggle);
		boolean exptoggle = false;

		TestCasePrint("LEFT ARROW IS DISABLE", exptoggle, actToggle);

	}

//******************CHECK THE NO-DATA MESSAGE VISIBILITY******************

	public static void Nodata() {

		PageFactory.initElements(driver, user);

		boolean actToggle = UserPage.nodata.isDisplayed();
		System.out.println("toggle button status " + actToggle);
		boolean exptoggle = true;

		TestCasePrint("NO DATA MESSAGE IS VISIBLE", exptoggle, actToggle);

	}

//******************CHECK THE NO-DATA MESSAAGE IS VISIBLE ON RIGHT SIDE******************

	public static void NodataInRightside() {

		PageFactory.initElements(driver, user);

		boolean actToggle = UserPage.nodatarightside.isDisplayed();
		System.out.println("toggle button status " + actToggle);
		boolean exptoggle = true;

		TestCasePrint("NO DATA MESSAGE IS VISIBLE-RIGHT SIDE", exptoggle, actToggle);

	}

//******************PAGINATION PROPERTIES IN THE USER TRASFTER LIST******************

	public static void paginationuserTransferList() throws InterruptedException {

		PageFactory.initElements(driver, user);

//	Default Index Page
		boolean ActualDefaultPageIndex = UserPage.DefaultPaginationPage.isDisplayed();
		boolean ExpectedDefaultPageIndex = true;

		TestCasePrint("PAGINATION-DEFAULT-PAGE-INDEX", ExpectedDefaultPageIndex, ActualDefaultPageIndex);

//	Refresh pagination into default page 

//	UserPage.transferlistnextpagebutton.click();
//	Thread.sleep(20000);
//	driver.navigate().refresh();
//	Thread.sleep(2000);
//
//	boolean ActualDefaultPageIndex1 = UserPage.DefaultPaginationPage.isDisplayed();
//	boolean ExpectedDefaultPageIndex1 = true;
//
//	TestCasePrint("PAGINATION-REFERESH-INTO-DEFAULT-PAGE", ExpectedDefaultPageIndex1, ActualDefaultPageIndex1);

//	Page Redirect to the next page 

		UserPage.transferlistnextpagebutton.click();
		Thread.sleep(2000);
		boolean ActualSecoundPageIndex = UserPage.PaginationSecoundPage.isDisplayed();
		boolean ExpectedSecoundPageIndex = true;

		TestCasePrint("PAGINATION-PAGE-REDIRECT-TO-NEXT-PAGE", ExpectedSecoundPageIndex, ActualSecoundPageIndex);

		// Total Text Visible
		boolean ActualVisibleTotalText = UserPage.totalTextSecondPage.isDisplayed();
		boolean ExpectedVisibleTotalText = true;

		TestCasePrint("PAGINATION-TOTAL-TEXT-VISIBLE", ExpectedVisibleTotalText, ActualVisibleTotalText);

	}

//******************CHECK THE NUMBER OF ROWS IN THE TRANSFER LIST EACH PAGE******************

	public static void transferlistrightsiderows() throws IOException, InterruptedException {

		PageFactory.initElements(driver, user);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "User";
		String testCaseId = "TC-USER-0077";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("User");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			row.getCell(1).getBooleanCellValue();
			number = (int) row.getCell(2).getNumericCellValue();

		}

		if (check) {
			try {
				boolean enable = true;
				while (enable) {
					for (int j = 1; j <= 2; j++) {

						Thread.sleep(5000);
						WebElement page = driver.findElement(By.xpath(UserPage.pageBefore + j + UserPage.pageAfter));
						page.click();
						Thread.sleep(2500);
						int actualRow = UserPage.transferlistusernameRowCountrightside.size();
						Thread.sleep(2500);
						System.out.println("row count " + actualRow);
						int expecetedRow = number;

						TestCasePrint("NUMBER-OF-RECORDS-IN-EACH-PAGE", expecetedRow, actualRow);
					}

					enable = UserPage.transferlistNextPageBtnright.isEnabled();
					if (enable) {
						UserPage.transferlistNextPageBtnright.click();
					}
				}
			} catch (NoSuchElementException e) {
			}
		}
	}

//******************CHECK ADD USER BUTTON FUNCTIONALITY******************

	public static void adduserbuttonfucntionality() {
		boolean AcctualmodalOpen = UserPage.modal.isDisplayed();
		boolean ExpectedmodalOpen = true;

		TestCasePrint("ADD USER MODAL HAS OPEND", ExpectedmodalOpen, AcctualmodalOpen);

		String ActualModalheading = driver.findElement(By.xpath("//*[@id=\"rcDialogTitle0\"]")).getText();
		String ExpectedModalheading = "Add User";

		TestCasePrint("ADD USER MODAL HEADING", ExpectedModalheading, ActualModalheading);
	}

//******************CHECK THE DROPDOWNS VISIBITY******************

	public static void dropdownsvisible() throws InterruptedException {

		boolean Acctual = driver.findElement(By.xpath(
				"//div[@class='ant-select ant-select-single ant-select-allow-clear ant-select-show-arrow'][@name='plant']"
						+ ""))
				.isDisplayed();
		boolean Expected = false;

		TestCasePrint("PLANT DROPDOWN IS NOT VISIBLE", Expected, Acctual);

		Thread.sleep(2000);

//		boolean Actual1=false;
//		boolean Expected1=false;

		try {
			boolean Actual1 = driver
					.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[3]/div"))
					.isDisplayed();
			boolean Expected1 = false;
			TestCasePrint("USERTYPE DROPDOWN IS NOT VISIBLE", Expected1, Actual1);

		} catch (NoSuchElementException e) {
			// TODO: handle exception

		}

	}

//******************SELECT RECORD FROM USER TABLE******************

	public static void selectrecoredfromusertable() throws IOException, InterruptedException {

		driver.findElement(By.xpath("//td[text()='" + username47 + "']//following-sibling::td[5]/span/span")).click();
	}

//******************CHECK THE ROLE VALUE******************

	public static void roledata() {

		String actualRole = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]")).getText();
		System.out.println("expected role" + actualRole);

		String expectedRole = role47;

		UserMainTests.TestCasePrint("CHECK THE ROLE VALUE", expectedRole, actualRole);

	}

//******************CHECK THE ADD USER MODAL VISIBILTY******************

	public static void cancelbutton() {

		boolean actualmodal = UserPage.modal.isDisplayed();
		boolean expectedmodal = true;

		UserMainTests.TestCasePrint("ADD USER MODAL IS VISIBLE", expectedmodal, actualmodal);

		UserPage.cancelbutton.click();

		UserPage.modal.isDisplayed();
		UserMainTests.TestCasePrint("ADD USER MODAL IS NOT VISIBLE", expectedmodal, actualmodal);

	}

//******************EDIT PLANT ROLE IN LAST PAGE******************	

	static String roledropdownlast = null;
	static String Actualdata2 = null;

	public static void plantRoleEditlastpage() throws InterruptedException, IOException {

		PageFactory.initElements(driver, user);

		Thread.sleep(1000);

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Data-equipment-material-user.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("usertable_username_lastpage");

		int rowcount = sheet.getLastRowNum();
		for (int i = 0; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(0).getBooleanCellValue();
			name = (String) row.getCell(1).getStringCellValue();
			roledropdownlast = (String) row.getCell(2).getStringCellValue();

			if (check)
				Thread.sleep(5000);
			for (int j = 1; j <= 10; j++) {
				WebElement name1 = driver
						.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[" + j + "]"));
				String dropcontent1 = name1.getText();

				if (dropcontent1.contentEquals(roledropdownlast)) {
					name1.click();
				} else if (dropcontent1.isEmpty()) {
				}

			}

			Thread.sleep(2000);

			Actualdata2 = UserPage.plantroldropdowntext.getText();

		}
	}

//******************CHECK THE DATA IN THE LAST PAGE******************

	public static void checkthedatalastpage() throws InterruptedException {
		PageFactory.initElements(driver, user);

		Thread.sleep(2000);

		String Expecteddata = UserPage.plantroldropdowntext.getText();

		TestCasePrint("EDIT-ROLE-ALLOCATION", Expecteddata, Actualdata2);
	}

//******************SELECT SPECIFIC DATA TO EDIT ROLE ALLOCATION IN THE SECOND PAGE******************

	static String name3 = null;

	public static void searchspecificdatatoeditroleAllocationSecondPage() throws InterruptedException, IOException {
		PageFactory.initElements(driver, user);

		Thread.sleep(1000);

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Data-equipment-material-user.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("usertable_username_lastpage");

		int rowcount = sheet.getLastRowNum();
		for (int i = 0; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);

			row.getCell(0).getBooleanCellValue();
			name3 = (String) row.getCell(3).getStringCellValue();

			driver.findElement(By.xpath("//td[text()='" + name3 + "']//following-sibling::td[6]//span/span")).click();
		}
	}

//******************EDIT PLANT ROLE IN SECOND PAGE******************	

	static String roledropdownsecond = null;
	static String Actualdata3 = null;

	public static void plantRoleEditSecondpage() throws InterruptedException, IOException {

		PageFactory.initElements(driver, user);

		Thread.sleep(1000);

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Data-equipment-material-user.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("usertable_username_lastpage");

		int rowcount = sheet.getLastRowNum();
		for (int i = 0; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(0).getBooleanCellValue();
			name = (String) row.getCell(1).getStringCellValue();
			roledropdownsecond = (String) row.getCell(4).getStringCellValue();

			if (check)
				Thread.sleep(5000);
			for (int j = 1; j <= 10; j++) {
				WebElement name1 = driver
						.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[" + j + "]"));
				String dropcontent1 = name1.getText();

				if (dropcontent1.contentEquals(roledropdownsecond)) {
					name1.click();
				} else if (dropcontent1.isEmpty()) {
				}

			}

			Thread.sleep(2000);

			Actualdata3 = UserPage.plantroldropdowntext.getText();

		}
	}

//******************COMPARE THE EDIT ROLE DATA IN SECOND PAGE******************

	public static void checkthedatasecondpage() throws InterruptedException {
		PageFactory.initElements(driver, user);

		Thread.sleep(2000);

		String Expecteddata = UserPage.plantroldropdowntext.getText();

		TestCasePrint("EDIT-ROLE-ALLOCATION", Expecteddata, Actualdata3);
	}

	public static void searchusername() throws IOException, InterruptedException {
		PageFactory.initElements(driver, user);

		Thread.sleep(1000);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "User";
		String testCaseId = "TC-USER-0097";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("User");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			row.getCell(1).getBooleanCellValue();
			usernamesearch = (String) row.getCell(2).getStringCellValue();

		}
	}

	public static void searchemployee() throws IOException, InterruptedException {
		PageFactory.initElements(driver, user);

		Thread.sleep(1000);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "User";
		String testCaseId = "TC-USER-0098";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("User");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			row.getCell(1).getBooleanCellValue();
			employeesearch = (String) row.getCell(2).getStringCellValue();

		}
	}
	// ******************SELECT ONE RECORD BY USENAME******************

	public static void exceldata86() throws InterruptedException, IOException {

		PageFactory.initElements(driver, user);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "User";
		String testCaseId = "TC-USER-0086";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("User");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			row.getCell(1).getBooleanCellValue();
			usernametrans = (String) row.getCell(2).getStringCellValue();
			planttrans = (String) row.getCell(3).getStringCellValue();

		}
	}

	public static void searchedrecordAvailableintop1() {

		PageFactory.initElements(driver, user);

		String act = driver.findElement(By.xpath(
				"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr/td[2]"))
				.getText();
		String exp = usernametrans;

		UserMainTests.TestCasePrint("USER VALUE IS AVAIABLE ON LEFT SIDE TOP", exp, act);
	}

	public static void searchedrecordAvailableintop2() {

		PageFactory.initElements(driver, user);

		String act = driver.findElement(By.xpath(
				"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr/td[3]"))
				.getText();
		String exp = planttrans;

		UserMainTests.TestCasePrint("PLANT VALUE IS AVAIABLE ON LEFT SIDE TOP", exp, act);
	}
}