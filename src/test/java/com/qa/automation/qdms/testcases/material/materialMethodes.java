package com.qa.automation.qdms.testcases.material;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class materialMethodes extends DriverIntialization {
	public static boolean kmnavication = false;
	public static boolean sent = false;
	public static boolean click = false;
	public static boolean tick = false;
	public static boolean exdata = false;
	public static boolean select = false;
	public static boolean pop = false;
	public static String valid;
	static WebDriverWait wait = new WebDriverWait(driver, 10);

	public static void navicateMaterial() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginTest.Login();
		if (LoginTest.login) {

			// Go to master page
			MasterMainNavigationsTest.navigateMaster();
			if (MasterMainNavigationsTest.clickMaster) {
				MasterMainNavigationsTest.clickMaster = false;
				// click to material main
				MasterMainNavigationsTest.navigateMaterialMain();
				if (MasterMainNavigationsTest.clickMaterialMain) {
					MasterMainNavigationsTest.clickMaterialMain = false;
					// goto Material page
					MasterMainNavigationsTest.navigateMaterial();
					kmnavication = true;
				}
			}
		}
		System.out.println(kmnavication + "nnnnn");
		System.out.println(LoginTest.login + "lllll");
		System.out.println(MasterMainNavigationsTest.clickMaster + "master");
		System.out.println(MasterMainNavigationsTest.navigateMaterialMain + "material");

	}

	public static void click(WebElement webElement, String element) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
			boolean v = webElement.isDisplayed();
			SampleCommonMethods.TestCasePrint(element.toUpperCase() + " VISIBILITY", "TRUE",
					String.valueOf(v).toUpperCase());
			Boolean V2 = webElement.isEnabled();
			SampleCommonMethods.TestCasePrint(element.toUpperCase() + "ENABLITY", "TRUE",
					String.valueOf(V2).toUpperCase());

			webElement.click();
			click = true;

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE " + element);
			testCase.log(Status.INFO, "UNABLE TO LOCATE THE ELEMENT " + element);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("CHECKING THE " + element);
			testCase.log(Status.INFO, "UNABLE TO CLICK ON THE ELEMENT " + element);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE " + element);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void sendkey(WebElement webElement, String data, String element) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
			boolean v = webElement.isDisplayed();
			SampleCommonMethods.TestCasePrint(element.toUpperCase() + " VISIBILITY", "TRUE",
					String.valueOf(v).toUpperCase());
			Boolean V2 = webElement.isEnabled();
			SampleCommonMethods.TestCasePrint(element.toUpperCase() + "ENABLITY", "TRUE",
					String.valueOf(V2).toUpperCase());

			webElement.sendKeys(data);
			sent = true;

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE " + element);
			testCase.log(Status.INFO, "UNABLE TO LOCATE THE ELEMENT " + element);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("CHECKING THE " + element);
			testCase.log(Status.INFO, "UNABLE TO CLICK ON THE ELEMENT " + element);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE " + element);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void dropdown(WebElement webElement, String data, String before, String after, String element) {
//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		try {

			boolean value1 = webElement.isDisplayed();
			SampleCommonMethods.TestCasePrint(element.toUpperCase() + " VISIBILITY", "TRUE",
					String.valueOf(value1).toUpperCase());
			boolean value2 = webElement.isEnabled();
			SampleCommonMethods.TestCasePrint(element.toUpperCase() + "ENABLITY", "TRUE",
					String.valueOf(value2).toUpperCase());
			webElement.click();
			Actions actions = new Actions(driver);
			try {
				boolean pass = false;

				WebElement id = null;
				for (int i1 = 0; i1 < 50; i1++) {
					if (!pass) {
						try {

							id = driver.findElement(By.xpath(before + data + after));

							wait.until(ExpectedConditions.elementToBeClickable(id));
							// Thread.sleep(500);
							id.click();
							pass = true;
							select = true;
						} catch (Exception e) {

						}
					}

					if (!pass) {

						actions.sendKeys(Keys.ARROW_DOWN).build().perform();

					} else {
						break;
					}

				}
			} catch (Exception e) {
				testCase = extent.createTest(data.toUpperCase() + "IS NOT THERE IN DROPDOWN LIST");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE " + element.toUpperCase());
			testCase.log(Status.INFO, "UNABLE TO LOCATE THE ELEMENT " + element.toUpperCase());
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("CHECKING THE " + element.toUpperCase());
			testCase.log(Status.INFO, "UNABLE TO CLICK ON THE ELEMENT " + element.toUpperCase());
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE " + element.toUpperCase());
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static boolean drop = false;

	public static void nordropdown(WebElement webElement, String before, String text, String after, String element) {
		try {
			WebElement id = webElement;
			id.isDisplayed();
			// SampleCommonMethods.TestCasePrint(element+" IS DISPLAYED", "true",
			// String.valueOf(value1));
			id.isEnabled();
			// SampleCommonMethods.TestCasePrint(element+" IS ENABLED", "true",
			// String.valueOf(value2));
			id.click();
			Thread.sleep(2000);
			WebElement dro = driver.findElement(By.xpath(before + text + after));
			dro.click();
			drop = true;
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking The " + element);
			testCase.log(Status.INFO, "Unable to Locate the element " + element);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking The " + element);
			testCase.log(Status.INFO, "Unable to Click on the element " + element);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("Checking The " + element);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void checkbox(WebElement webElement, WebElement iner, boolean thick, String element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		System.out.println("!!!!!!!!!!!!!!!!!");
		try {

			boolean v = webElement.isDisplayed();
			SampleCommonMethods.TestCasePrint(element.toUpperCase() + " VISIBILITY", "TRUE",
					String.valueOf(v).toUpperCase());
			Boolean V2 = webElement.isEnabled();
			SampleCommonMethods.TestCasePrint(element.toUpperCase() + "ENABLITY", "TRUE",
					String.valueOf(V2).toUpperCase());

			boolean b = iner.isSelected();
			if (b != thick) {
				iner.click();

			}
			tick = true;

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE " + element);
			testCase.log(Status.INFO, "UNABLE TO LOCATE THE ELEMENT " + element);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("CHECKING THE " + element);
			testCase.log(Status.INFO, "UNABLE TO CLICK ON THE ELEMENT " + element);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE " + element);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void addmaterial(String excelbook, String exceltab, String testid) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// get data from excel

		XSSFRow row = null;

		DataFormatter dataValue = new DataFormatter();
		String filelocation;
		String plant = null;
		String maincatogory = null;
		String subcatogory = null;
		String Prefix = null;
		String MaterialState = null;
		String Material = null;
		String ERPCode = null;
		String Act = null;
		String Description = null;
		String MaterialSource = null;
		String materialType=null;
		boolean Active = false;

		try {
			filelocation = "./src/test/resources/Excel/" + excelbook + ".xlsx";
			System.out.println(testid + "ttttttttttttttttttttt");
			int firstrow = CommonMethods.getFirstRowNum(filelocation, exceltab, testid);
			int lastrow = CommonMethods.getLastRowNum(filelocation, exceltab, testid);
			System.out.println(firstrow + "ffffffff");
			System.out.println(lastrow + "llllllllllllll");

			FileInputStream file = new FileInputStream(filelocation);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(exceltab);

			for (int j = firstrow; j <= firstrow; j++) {
				row = sheet.getRow(j);
				materialType = dataValue.formatCellValue(row.getCell(1));
				
				String tic = dataValue.formatCellValue(row.getCell(2));
				Boolean.valueOf(tic);
				plant = dataValue.formatCellValue(row.getCell(3));
				maincatogory = dataValue.formatCellValue(row.getCell(4));
				subcatogory = dataValue.formatCellValue(row.getCell(5));
				Prefix = dataValue.formatCellValue(row.getCell(6));
				MaterialState = dataValue.formatCellValue(row.getCell(7));
				Material = dataValue.formatCellValue(row.getCell(8));
				ERPCode = dataValue.formatCellValue(row.getCell(9));
				MaterialSource = dataValue.formatCellValue(row.getCell(10));
				Act = dataValue.formatCellValue(row.getCell(11));
				Active = Boolean.valueOf(Act);
				Description = dataValue.formatCellValue(row.getCell(12));
				exdata = true;
				/*********************************************************************************************/
				Thread.sleep(2000);
				if (exdata) {

					click(driver
							.findElement(By.xpath("//div[@class='ant-table-title']//span[text()='Add Material']//..")),
							"ADD MATERIAL BUTTON");
				}
				Thread.sleep(10000);
				System.out.println(click + "kkkkkkk");
			if (click) {
				System.out.println("kkkkkkkkkkkyyyyyyyyyy");
//				checkbox(driver.findElement(By.xpath("//div[@class='ant-modal-body']//input[@value='" + materialType + "']//..")),driver.findElement(By.xpath("//div[@class='ant-modal-body']//input[@value='" + materialType + "']")),materialTypetic, "MATERIAL TYPE");
			}
				if (click) {
					click = false;
					dropdown(driver.findElement(By.xpath("//label[@for='plant']//..//div[1]/div")), plant,
							"//div[@class='rc-virtual-list-holder-inner']/div[@title='", "']/div", "PLANT");
				}
				if (select) {
					select = false;
					dropdown(driver.findElement(By.xpath("//label[@for='sub_category']//..//div[1]/div")), subcatogory,
							"//div[@class='ant-select-item-option-content']/span[text()='", "']", "SUB CATEGORY");
				}
				if (select) {
					sendkey(driver.findElement(By.xpath("//label[@for='prefix']//..//input")), Prefix, "PREFIX");
				}
				if (sent) {
					dropdown(driver.findElement(By.xpath("//label[@for='material_state']//..//div[1]/div")),
							MaterialState, "//div[text()='", "']", "MATERIAL STATE");
				}
				if (select) {
					sendkey(driver.findElement(By.xpath("//label[@for='material_name']//..//input")), Material,
							"MATERIAL");
				}
				if (ERPCode != "" && select) {
					sendkey(driver.findElement(By.xpath("//label[text()='ERP Code:']//..//input")), ERPCode,
							"ERP CODE");
				}
//				if (MaterialSource != "" && select) {
//					dropdown(driver.findElement(By.xpath("//label[text()='Material Source :']//..//input")),
//							MaterialSource, "//div[@class='ant-select-item-option-content'][text()='", "']",
//							"MATRIAL SOURCE");
//				}
				if (Act != "" && select) {
					checkbox(driver.findElement(By.xpath("//div[@class='ant-modal-body']//input[@id='active']//..")),
							driver.findElement(By.xpath("//div[@class='ant-modal-body']//input[@id='active']")), Active,
							"ACTIVE");

				}
				if (Description != "" && select) {
					sendkey(driver.findElement(By.xpath("//label[text()='Description:']//..//textarea")), Description,
							"DESCRIPTION");
				}
				if (sent) {

					click(driver.findElement(By.xpath("//div[@class='ant-modal-footer']//button[2]")),
							"ADD MATERIAL SAVE BUTTON");
				}
				if (click) {
					click = false;
					popupcheck(driver.findElement(By.xpath("//div[@class='ant-modal-content']")), "ADD MATERIAL");
				}
				if (!pop) {

					datacheckinfirstrow("1,2,3,4,5,6", 2, Material + "," + maincatogory + "," + subcatogory + ","
							+ Prefix + "," + plant + "," + MaterialState, "ADD MATERIAL PLANT WISE");

				} else if (pop) {

					validation();
				}
//          REFRESH
				driver.navigate().refresh();
				Thread.sleep(1000);

			}
		} catch (Exception e) {
			testCase = extent.createTest("EXCEL DATA NOT THERE");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
//	          REFRESH
			driver.navigate().refresh();
			Thread.sleep(1000);

		}

	}

	public static void popupcheck(WebElement webElement, String element) {

		try {

			wait.until(ExpectedConditions.invisibilityOfAllElements(webElement));

			pop = webElement.isDisplayed();
			pop = true;
		} catch (Exception e) {
			pop = false;
		}
		if (pop) {
			pop = true;

		} else {
			pop = false;
		}

	}

	public static void datacheckinfirstrow(String checktd, int tr, String data, String TEST) {
//    REFRESH
		driver.navigate().refresh();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Boolean pass = false;
		String[] numberStrings = checktd.split(",");
		String[] dataStrings = data.split(",");

		int[] numbers = new int[numberStrings.length];
		System.out.println(numberStrings.length);
		for (int i = 0; i < numberStrings.length; i++) {
//	    numbers[i] = Integer.parseInt(numberStrings[i].trim());
			String coldata = numberStrings[i];
			String excoldata = dataStrings[i];
			System.out.println(coldata + "jjjjjjjjjjjjj");
			WebElement table = driver.findElement(By.xpath("//tbody/tr[" + tr + "]/td[" + coldata + "]"));
			String actvalue = table.getText();

			if (excoldata.equals(actvalue)) {
				pass = true;

			}
			if (!pass) {
				testCase = extent.createTest("CHECKING THE ADDED DATA");
				testCase.log(Status.INFO, tr + "ROW" + numbers + "COLUMN");
				testCase.log(Status.INFO, "ACCTUAL DATA:-" + actvalue);
				testCase.log(Status.INFO, "EXPECTED DATA:-" + excoldata);
				testCase.log(Status.FAIL, "TEST FAIL ❎");
				break;

			}

		}
		if (pass) {
			testCase = extent.createTest("CHECKING THE ADDED DATA");
			testCase.log(Status.INFO, "DATASET CORRECTL ADDED");
			testCase.log(Status.PASS, "TEST PASS");

			testCase = extent.createTest(TEST);
			testCase.log(Status.PASS, "TEST PASS");

		} else {
			testCase = extent.createTest(TEST);
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		}

	}

	public static int vi;

	public static void validation() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int filed1 = 0;
		try {
			List<WebElement> trwithtext = driver.findElements(By.xpath("//div[@class='ant-modal-body']//label//../div[text()]"));
			filed1 = trwithtext.size();
		} catch (Exception e) {
			// TODO: handle exception
		}

		
			try {
				WebElement vali = driver.findElement(By.xpath("(//div[@class='ant-modal-body']//label//../div[text()])[1]"));
				valid = vali.getText();
				testCase = extent.createTest("CHECKING THE ADD FUNCTION");
				testCase.log(Status.INFO, "ACCTUAL DATA:-" + valid);
				testCase.log(Status.FAIL, "TEST FAIL ❎");

			} catch (Exception e) {
				// testCase =extent.createTest("NO ANY TEXTBOX VALIDATION IS THERE");
			}
			

	

	}

	public static boolean nod = false;
	public static int length;

	public static void tabledatacountwithtext(String searchvalue, int datacount) throws InterruptedException {
		SampleCommonMethods.TestCasePrint("CHECKING TABLE DATA COUNT");
//	check data avilability
		try {
			driver.findElement(By.xpath("//tbody//div[@class='ant-empty-image']"));
			nod = true;
		} catch (Exception e) {

		}
		int count = 0;
		if (!nod) {
			boolean next = true;

			while (next) {
				List<WebElement> trwithtext = driver.findElements(By.xpath("//tbody//*[text()='" + searchvalue + "']"));
				int trsizewt = trwithtext.size();
				for (WebElement element : trwithtext) {
					String text = element.getText();
					length = text.length();
					System.out.println("Text: " + text + ", Length: " + length);
				}

				try {
					WebElement nextbtn = driver.findElement(By.xpath("//li[@title='Next Page']/button"));
					wait.until(ExpectedConditions.elementToBeClickable(nextbtn));
					next = nextbtn.isEnabled();
					nextbtn.click();

				} catch (Exception e) {
					next = false;
					break;
				}
				System.out.println(next + "*********");

				count = count + trsizewt;
				System.out.println(count);
			}
		}

		SampleCommonMethods.TestCasePrint("CHECKING DATA COUNT", datacount, count);
	}

	public static void tabledatacount(String searchvalue2, int datacount1, int num) throws InterruptedException {
		SampleCommonMethods.TestCasePrint("CHECKING TABLE DATA COUNT");
//	check data avilability
		try {
			driver.findElement(By.xpath("//tbody//div[@class='ant-empty-image']"));
			nod = true;
		} catch (Exception e) {

		}
		int count1 = 0;
		int count11 = 0;
		if (!nod) {
			boolean next = true;
			while (next) {

				int x = 0;

				try {
					Thread.sleep(1000);
					x = driver.findElements(By.xpath("//tbody/tr")).size();
					int trsizew = 0;
					try {
						List<WebElement> trwithtex = driver
								.findElements(By.xpath("//tbody//*[text()='" + searchvalue2 + "']"));
						trsizew = trwithtex.size();
					} catch (Exception e) {

					}
					count11 = count11 + trsizew - num;
				} catch (Exception e) {
				}

				count1 = count1 + x - num;

				try {
					WebElement nexT = driver.findElement(By.xpath("//li[@title='Next Page']/button"));
					next = nexT.isEnabled();
					if (next) {
						nexT.click();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			System.out.println(count1 + "!!!!!!!!!!!!!");
		}

		if (count1 == count11) {
			SampleCommonMethods.TestCasePrint("CHECKING DATA COUNT", datacount1, count1);
			if (datacount1 == count1) {
				SampleCommonMethods.TestCasePrint("SEARCH FUNCTION PASS");

			} else {
				SampleCommonMethods.TestCasePrint("SEARCH FUNCTION FAIL");
			}

		} else {
			SampleCommonMethods.TestCasePrint("CHECKING DATA COUNT", datacount1, count1);
			// SampleCommonMethods.TestCasePrint("SEARCH FUNCTION FAILED");
		}

	}

	public static void paginationnew(String excelname, String tabname, String testid, String testCaseDescroption) {

		// get data from excel

		XSSFRow row = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		XSSFWorkbook wbook = null;
		String filelocation;

		try {
			filelocation = "./src/test/resources/Excel/" + excelname + ".xlsx";
			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			fileIn.close();

			PropertiesCommonMethods.excalRowCount(excelname + ".xlsx", tabname, testid);
			XSSFSheet sheet = wbook.getSheet(tabname);
			int r = PropertiesCommonMethods.countRow - 1;
			row = sheet.getRow(r);
			String pagecount5 = dataValue.formatCellValue(row.getCell(2));
			int ExpectedTotalPage5 = Integer.parseInt(pagecount5);
			String pagecount10 = dataValue.formatCellValue(row.getCell(3));
			int ExpectedTotalPage10 = Integer.parseInt(pagecount10);
			String pagecount20 = dataValue.formatCellValue(row.getCell(4));
			int ExpectedTotalPage20 = Integer.parseInt(pagecount20);
			String pagecount30 = dataValue.formatCellValue(row.getCell(5));
			int ExpectedTotalPage30 = Integer.parseInt(pagecount30);
			String pagecount50 = dataValue.formatCellValue(row.getCell(6));
			int ExpectedTotalPage50 = Integer.parseInt(pagecount50);
			String pagecount100 = dataValue.formatCellValue(row.getCell(7));
			int ExpectedTotalPage100 = Integer.parseInt(pagecount100);

			WebElement previousbtn = null;
			WebElement nextbtn = null;
			WebElement fistpagebtn = null;
			WebElement secoundpagebtn = null;

			try {

				previousbtn = driver.findElement(By.xpath("//li[@title='Previous Page']//button"));
				wait.until(ExpectedConditions.elementToBeClickable(previousbtn));

			} catch (Exception e) {
				// TODO: handle exception
			}
			try {

				nextbtn = driver.findElement(By.xpath("//li[@title='Next Page']/button"));
				wait.until(ExpectedConditions.elementToBeClickable(nextbtn));

			} catch (Exception e) {
				// TODO: handle exception
			}
			try {

				fistpagebtn = driver.findElement(By.xpath("//li[@title='1']"));
				wait.until(ExpectedConditions.elementToBeClickable(fistpagebtn));

			} catch (Exception e) {
				// TODO: handle exception
			}
			try {

				secoundpagebtn = driver.findElement(By.xpath("//li[@title='2']"));
				wait.until(ExpectedConditions.elementToBeClickable(secoundpagebtn));

			} catch (Exception e) {
				// TODO: handle exception
			}

//				REOPRT HEADING
			testCase = extent.createTest(testCaseDescroption);

			functionality.ButtonAndIconFunctionalityPassInable("CHECKING DEFAULT PREVIOUS BUTTON", previousbtn,
					"Button");
			functionality.ButtonAndIconunctionalityMtd("CHECKING DEFAULT NEXT BUTTON", nextbtn, "Button");
			functionality.ButtonAndIconunctionalityMtd("CHECKING DEFAULT FIRST PAGE BUTTON", fistpagebtn,
					"Page Button");
			materialMethodes.click(driver.findElement(By.xpath("//li[@title='Next Page']/button")), "NEXT");
			functionality.ButtonAndIconunctionalityMtd("CHECKING DEFAULT SECOUND PAGE BUTTON", secoundpagebtn,
					"Page Button");
//              REFRESH
			driver.navigate().refresh();
			Thread.sleep(1000);
			functionality.ButtonAndIconunctionalityMtd("CHECKING DEFAULT FIRST PAGE BUTTON", fistpagebtn,
					"Page Button");
			functionality.ButtonAndIconFunctionalityPassInable("CHECKING DEFAULT PREVIOUS BUTTON", previousbtn,
					"Button");
			materialMethodes.click(driver.findElement(By.xpath("//li[@title='Next Page']/button")), "NEXT");
			functionality.ButtonAndIconunctionalityMtd("CHECKING DEFAULT PREVIOUS BUTTON", previousbtn, "Button");
//            REFRESH
			driver.navigate().refresh();
			Thread.sleep(1000);
			// **********************************************************
			List<WebElement> trwithtext = driver
					.findElements(By.xpath("//div[@class='ant-select-item-option-content']"));
			String Pagebefore = "(//div[@class='ant-select-item-option-content'])[";
			String pageafter = "]";
			WebElement PageDropdown = driver.findElement(By.xpath("//div[@class='ant-select-selector']"));

			int size = trwithtext.size();
			System.out.println(size);
			for (int j = 1; j <= 4; j++) {
				System.out.println("loop" + j);
				System.out.println("***********");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@class='ant-select-selector']")).click();
				Thread.sleep(1500);
				System.out.println(Pagebefore + j + pageafter + "*****************");
				WebElement Page = driver.findElement(By.xpath(Pagebefore + j + pageafter));
				Page.click();
				Thread.sleep(2000);
				int ActualTotalPage = 1;
				boolean Enablity1 = driver.findElement(By.xpath("//li[@title='Next Page']/button")).isEnabled();
				while (Enablity1) {
					Thread.sleep(2000);
					driver.findElement(By.xpath("//li[@title='Next Page']/button")).click();
					ActualTotalPage = ActualTotalPage + 1;
					Enablity1 = driver.findElement(By.xpath("//li[@title='Next Page']/button")).isEnabled();
					Thread.sleep(2000);
					System.out.println(ActualTotalPage + "*****************");
					Enablity1 = driver.findElement(By.xpath("//li[@title='Next Page']/button")).isEnabled();
				}
				System.out.println(ActualTotalPage);
				WebElement pags = driver.findElement(By.xpath("//div[@class='ant-select-selector']"));
				System.out.println(pags.getText() + "***************");
				if (pags.getText().contentEquals("5 / page")) {
					System.out.println(
							driver.findElement(By.xpath(Pagebefore + j + pageafter)).getText() + "//////////////////");
					testCase = extent.createTest("➢ Checking Total Page for 5 Data per page");
					try {
						Assert.assertEquals(ActualTotalPage, ExpectedTotalPage10);
						testCase.log(Status.INFO, "Current Pagination Opction :- " + Page.getText());
						testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
						testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage10);
						testCase.log(Status.PASS, "Correct Page Count");
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "Current Pagination Opction :- " + PageDropdown.getText());
						testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
						testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage10);
						testCase.log(Status.FAIL, "Wrong Page Count");
					}
				} else if (pags.getText().contentEquals("10 / page")) {
					testCase = extent.createTest("➢ Checking Total Page for 10 Data per page");
					try {
						Assert.assertEquals(ActualTotalPage, ExpectedTotalPage5);
						testCase.log(Status.INFO, "Current Pagination Opction :- " + Page.getText());
						testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
						testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage5);
						testCase.log(Status.PASS, "Correct Page Count");
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "Current Pagination Opction :- " + Page.getText());
						testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
						testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage5);
						testCase.log(Status.FAIL, "Wrong Page Count");
					}
				} else if (pags.getText().contentEquals("20 / page")) {
					testCase = extent.createTest("➢ Checking Total Page for 20 Data per page");
					try {
						Assert.assertEquals(ActualTotalPage, ExpectedTotalPage20);
						testCase.log(Status.INFO, "Current Pagination Opction :- " + Page.getText());
						testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
						testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage20);
						testCase.log(Status.PASS, "Correct Page Count");
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "Current Pagination Opction :- " + Page.getText());
						testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
						testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage20);
						testCase.log(Status.FAIL, "Wrong Page Count");
					}
				} else if (pags.getText().contentEquals("30 / page")) {
					testCase = extent.createTest("➢ Checking Total Page for 30 Data per page");

					try {
						Assert.assertEquals(ActualTotalPage, ExpectedTotalPage30);
						testCase.log(Status.INFO, "Current Pagination Opction :- " + Page.getText());
						testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
						testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage30);
						testCase.log(Status.PASS, "Correct Page Count");
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "Current Pagination Opction :- " + Page.getText());
						testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
						testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage30);
						testCase.log(Status.FAIL, "Wrong Page Count");
					}
				} else if (pags.getText().contentEquals("50 / page")) {
					testCase = extent.createTest("➢ Checking Total Page for 50 Data per page");
					try {
						Assert.assertEquals(ActualTotalPage, ExpectedTotalPage50);
						testCase.log(Status.INFO, "Current Pagination Opction :- " + Page.getText());
						testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
						testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage50);
						testCase.log(Status.PASS, "Correct Page Count");
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "Current Pagination Opction :- " + Page.getText());
						testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
						testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage50);
						testCase.log(Status.FAIL, "Wrong Page Count");
					}
				} else if (pags.getText().contentEquals("100 / page")) {
					testCase = extent.createTest("➢ Checking Total Page for 100 Data per page");
					try {
						Assert.assertEquals(ActualTotalPage, ExpectedTotalPage100);
						testCase.log(Status.INFO, "Current Pagination Opction :- " + Page.getText());
						testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
						testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage100);
						testCase.log(Status.PASS, "Correct Page Count");
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "Current Pagination Opction :- " + Page.getText());
						testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
						testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage100);
						testCase.log(Status.FAIL, "Wrong Page Count");
					}
				}
				driver.navigate().refresh();
				Thread.sleep(2000);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void alldatacount(int datacount1, int num) {

		SampleCommonMethods.TestCasePrint("CHECKING TABLE DATA COUNT");
//	check data avilability
		try {
			WebElement nodata = driver.findElement(By.xpath("//tbody//div[@class='ant-empty-image']"));
			nod = true;
		} catch (Exception e) {

		}
		int count1 = 0;
		int count11 = 0;
		if (!nod) {
			boolean next = true;
			while (next) {

				int x = 0;

				try {
					Thread.sleep(1000);
					x = driver.findElements(By.xpath("//tbody/tr")).size();
				} catch (Exception e) {
				}

				count1 = count1 + x - num;

				try {
					WebElement nexT = driver.findElement(By.xpath("//li[@title='Next Page']/button"));
					next = nexT.isEnabled();
					if (next) {
						nexT.click();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			System.out.println(count1 + "!!!!!!!!!!!!!");
		}

		SampleCommonMethods.TestCasePrint("CHECKING DATA COUNT", datacount1, count1);
		if (datacount1 == count1) {
			SampleCommonMethods.TestCasePrint("RESET FUNCTION PASS");

		} else {
			SampleCommonMethods.TestCasePrint("RESET FUNCTION FAILED");
		}

	}

	public static void addmatvalidation(String excelbook, String exceltab, String testid) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// get data from excel

		XSSFRow row = null;

		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		XSSFWorkbook wbook = null;
		String filelocation;
		String materialType = null;
		String plant = null;
		String maincatogory = null;
		String subcatogory = null;
		String Prefix = null;
		String MaterialState = null;
		String Material = null;
		String ERPCode = null;
		String Act = null;
		String Description = null;
		String MaterialSource = null;
		String checktd=null;
		String cdata=null;
		boolean materialTypetic = false;
		boolean Active = false;

		try {
			filelocation = "./src/test/resources/Excel/" + excelbook + ".xlsx";
			System.out.println(testid + "ttttttttttttttttttttt");
			int firstrow = CommonMethods.getFirstRowNum(filelocation, exceltab, testid);
			int lastrow = CommonMethods.getLastRowNum(filelocation, exceltab, testid);
			System.out.println(firstrow + "ffffffff");
			System.out.println(lastrow + "llllllllllllll");

			FileInputStream file = new FileInputStream(filelocation);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(exceltab);

			for (int j = firstrow; j <= firstrow; j++) {
				row = sheet.getRow(j);

				materialType = dataValue.formatCellValue(row.getCell(1));
				String tic = dataValue.formatCellValue(row.getCell(2));
				materialTypetic = Boolean.valueOf(tic);
				plant = dataValue.formatCellValue(row.getCell(3));
				maincatogory = dataValue.formatCellValue(row.getCell(4));
				subcatogory = dataValue.formatCellValue(row.getCell(5));
				Prefix = dataValue.formatCellValue(row.getCell(6));
				MaterialState = dataValue.formatCellValue(row.getCell(7));
				Material = dataValue.formatCellValue(row.getCell(8));
				ERPCode = dataValue.formatCellValue(row.getCell(9));
				MaterialSource = dataValue.formatCellValue(row.getCell(10));
				Act = dataValue.formatCellValue(row.getCell(11));
				Active = Boolean.valueOf(Act);
				Description = dataValue.formatCellValue(row.getCell(12));
				checktd=dataValue.formatCellValue(row.getCell(13));
				cdata=dataValue.formatCellValue(row.getCell(14));
				exdata = true;
				/*********************************************************************************************/
				Thread.sleep(2000);
				if (exdata) {

					click(driver
							.findElement(By.xpath("//div[@class='ant-table-title']//span[text()='Add Material']//..")),
							"ADD MATERIAL BUTTON");
				}
				Thread.sleep(10000);
				System.out.println(click + "kkkkkkk");
			if (click) {
				System.out.println("kkkkkkkkkkkyyyyyyyyyy");
				checkbox(driver.findElement(By.xpath("//div[@class='ant-modal-body']//input[@value='" + materialType.toUpperCase() + "']//..//span[contains(@class,'ant-radio')]")),driver.findElement(By.xpath("//div[@class='ant-modal-body']//input[@value='" + materialType.toUpperCase() + "']")),materialTypetic, "MATERIAL TYPE");
			}
				if (click&&materialType.toUpperCase().equals("PLANT")) {
					click = false;
					dropdown(driver.findElement(By.xpath("//label[text()='Plant :']//..//div[1]/div")), plant,
							"//div[@class='rc-virtual-list-holder-inner']/div[@title='", "']/div", "PLANT");
				}else if (click&&materialType.toUpperCase().equals("SBU")) {
					click = false;
					dropdown(driver.findElement(By.xpath("//label[text()=' SBU :']//..//div[1]/div")), plant,
							"//div[@class='rc-virtual-list-holder-inner']/div[@title='", "']/div", "SBU");
				}else if (click&&materialType.toUpperCase().equals("COMMON")) {
					click = false;
					select = true;
				}
				if (select) {
					select = false;
					dropdown(driver.findElement(By.xpath("//label[@for='sub_category']//..//div[1]/div")), subcatogory,
							"//div[@class='ant-select-item-option-content']/span[text()='", "']", "SUB CATEGORY");
				}
				if (select) {
					sendkey(driver.findElement(By.xpath("//label[@for='prefix']//..//input")), Prefix, "PREFIX");
				}
				if (sent) {
					dropdown(driver.findElement(By.xpath("//label[@for='material_state']//..//div[1]/div")),
							MaterialState, "//div[text()='", "']", "MATERIAL STATE");
				}
				if (select) {
					sendkey(driver.findElement(By.xpath("//label[@for='material_name']//..//input")), Material,
							"MATERIAL");
				}
				if (ERPCode != "" && select) {
					sendkey(driver.findElement(By.xpath("//label[text()='ERP Code:']//..//input")), ERPCode,
							"ERP CODE");
				}
				if (MaterialSource != "" && select) {
					sendkey(driver.findElement(By.xpath("//label[text()='Material Source :']//..//input//..//..//..//..//..//div[@class='ant-select-selector']")),
							MaterialSource, "MATRIAL SOURCE");
				}
				if (Act != "" && select) {
					checkbox(driver.findElement(By.xpath("//div[@class='ant-modal-body']//input[@id='active']//..")),
							driver.findElement(By.xpath("//div[@class='ant-modal-body']//input[@id='active']")), Active,
							"ACTIVE");

				}
				if (Description != "" && select) {
					sendkey(driver.findElement(By.xpath("//label[text()='Description:']//..//textarea")), Description,
							"DESCRIPTION");
				}
				if (sent) {

					click(driver.findElement(By.xpath("//div[@class='ant-modal-footer']//button[2]")),
							"ADD MATERIAL SAVE BUTTON");
				}
				if (click) {
					click = false;
					popupcheck(driver.findElement(By.xpath("//div[@class='ant-modal-content']")), "ADD MATERIAL");
				}
				if (pop) {

					click(driver
							.findElement(By.xpath("//div[@class='ant-table-title']//span[text()='Add Material']//..")),
							"ADD MATERIAL BUTTON");

				} else if (!pop) {
					
					

					validationconfirm(checktd,cdata,"add material validation");
				}
//          REFRESH
				driver.navigate().refresh();
				Thread.sleep(1000);

			}
		} catch (Exception e) {
			testCase = extent.createTest("EXCEL DATA NOT THERE");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
//	          REFRESH
			driver.navigate().refresh();
			Thread.sleep(1000);

		}

	}
	static int count=0;
	public static boolean	validCorfirm=false;
	public static void validationconfirm( String checktd ,String data, String TEST) throws InterruptedException {
	validCorfirm = false;
		String valed = null;
		String fieled = null;
		String fieleddata=null;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int filed1 = 0;
		try {
			List<WebElement> trwithtext = driver.findElements(By.xpath("//div[@class='ant-modal-body']//label//../div[text()]"));
			filed1 = trwithtext.size();
		} catch (Exception e) {
			// TODO: handle exception
		}

		for (int vi = 1; vi <= filed1; vi++) {
			try {
				WebElement vali = driver
						.findElement(By.xpath("(//div[@class='ant-modal-body']//label//../div[text()])[" + vi + "]"));
				valed = vali.getText();
				if (valed!="") {
					try {
						WebElement field = driver.findElement(
								By.xpath("(//div[@class='ant-modal-body']//label//../div[text()])[" + vi + "]//../label"));
					String	fieledbs = field.getText();
					String[] fieledas=fieledbs.split(":");
					fieled=fieledas[0];
					
						System.out.println(fieled+"fieldddddd/////");
					} catch (Exception e) {

					}
					try {
						WebElement sentdata = driver
								.findElement(By.xpath("(//div[@class='ant-modal-body']//label//../div[text()])[" + vi
										+ "]//.. //*[@class='ant-input' or @class='ant-select-selection-item']"));
						System.out.println(sentdata+"fielddata xpath");
						fieleddata = sentdata.getAttribute("value");
						System.out.println(fieleddata+"fielddata********");
					} catch (Exception e) {
						fieleddata="";
					} 
				}
			} catch (Exception e) {
				testCase = extent.createTest("NO ANY TEXTBOX VALIDATION IS THERE");
			}
			System.out.println(valed+"validation");
			if (valed.toUpperCase().contains("CAN'T BE EMPTY")) {
				if (fieleddata.contains("")) {
					System.out.println("validation pass");
					System.out.println("validation pass");
					testCase = extent.createTest("CONFIRM VALIDATION");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
					
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
					
				}else {
					System.out.println("validation fail");
					
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}

			} else if (valed.toUpperCase().contains("ALREADY EXIST")) {
				try {
					driver.findElement(By.xpath("//div[@class='ant-modal-footer']//button[1]")).click();
					try {
						driver.findElement(By.xpath("//ul[contains(@class,'ant-pagination')]//li[@title='1']")).click();
					} catch (Exception e) {
						// TODO: handle exception
					}
				} catch (Exception e) {

				}
				Thread.sleep(5000);

				int th = 0;
				try {
					List<WebElement> trwithte = driver.findElements(By.xpath("//thead/tr/th"));
					th = trwithte.size();
					System.out.println(th+"thead++++++++++");
				} catch (Exception e) {

				}

				try {
					for (int L = 1; L <= th; L++) {
						String head = driver.findElement(By.xpath("//thead/tr/th[" + L + "]")).getText();
						System.out.println(head+"headtext------");
						System.out.println(fieled+"field///////////");
						String[] subcat=fieled.split("_");
						fieled=subcat[0];
						System.out.println(fieled+"after split");
						if (fieled.toUpperCase().contains(head.toUpperCase())) {
							// ***********************
//	check data avilability
							try {
								WebElement nodata = driver
										.findElement(By.xpath("//tbody//div[@class='ant-empty-image']"));
								nod = true;
							} catch (Exception e) {
								nod=false;
							}
							
							
							if (!nod) {
								nod=false;
								boolean next = true;
								while (next) {

									int x = 0;
									int i=0;
									String y = null;
									try {
										Thread.sleep(1000);
										x = driver
												.findElements(By.xpath(
														"//tbody//tr[contains(@class,'ant-table-row')]/td[" + L + "]"))
												.size();
										for ( i = 1; i <= x; i++) {
											y = driver.findElement(
													By.xpath("(//tbody//tr[contains(@class,'ant-table-row')]/td[" + L
															+ "])[" + i + "]"))
													.getText();
											
											System.out.println(y+"tabletextttttt");
											
											if (y.equals(fieleddata) ) {
												if (data!="") {
													tabledatamatching(i, checktd, data, TEST);
												}
												else {
													countk=1;
													
												}
												System.out.println(countk+"data count*******");
												

											}
										}
									} catch (Exception e) {
									}

									try {
										WebElement nexT = driver
												.findElement(By.xpath("//li[@title='Next Page']/button"));
										next = nexT.isEnabled();
										
										if (next) {
											nexT.click();
										}else {
											if (countk==1) {
												System.out.println("validation pass");
												testCase = extent.createTest("CONFIRM VALIDATION");
												testCase.log(Status.INFO, valed+" validation");
												testCase.log(Status.PASS, "TEST PASS");
												
												testCase = extent.createTest(TEST+" Validation");
												testCase.log(Status.INFO, valed+" validation");
												testCase.log(Status.PASS, "TEST PASS");
												
											}else {
											if (i==x) {
												System.out.println("validation fail");
												testCase = extent.createTest(TEST+" Validation");
												testCase.log(Status.INFO, valed+" validation");
												testCase.log(Status.FAIL, "TEST FAIL ❎");
											}}
										}
									} catch (Exception e) {
										// TODO: handle exception
									}
								}
								System.out.println(countk + "!!!!!!!!!!!!!");
							}

							// ***********************
							break;
						}

					}

				} catch (Exception e) {
					// TODO: handle exception
				}
//		          REFRESH
				driver.navigate().refresh();
				Thread.sleep(1000);
			} else if (valed.toUpperCase().contains("INVALID CHARATERS")||valed.toUpperCase().contains("INVALID CHARACTERS")) {
				String specilcharacter="0123456789.* [~!@#$%^&*()+/\\[\\]{}=?><.,`].*";
				if (containsSpecialCharacter(fieleddata, specilcharacter)) {
				    // Do something if the string contains any of the special characters
					System.out.println("validation pass");
					testCase = extent.createTest("CONFIRM VALIDATION");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
					
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
        }
				else {
					System.out.println("validation fail");
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}

			} else if (valed.toUpperCase().contains("allow only letters & Number")) {
				String specilcharacter=".* [~!@#$%^&*()+/\\[\\]{}=?><.,`].*";
				if (containsSpecialCharacter(fieleddata, specilcharacter)) {
				    // Do something if the string contains any of the special characters
					System.out.println("validation pass");
					testCase = extent.createTest("CONFIRM VALIDATION");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
					
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
        }
				else {
					System.out.println("validation fail");
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}

			}
			else if (valed.toUpperCase().contains("should contain @")) {
				String specilcharacter="@";
				if (containsSpecialCharacter(fieleddata, specilcharacter)) {
				    // Do something if the string contains any of the special characters
					System.out.println("validation fail");
					testCase = extent.createTest("CONFIRM VALIDATION");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.FAIL, "TEST PASS");
					
					
        }
				else {
					System.out.println("validation pass");
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}

			}
			else if (valed.toUpperCase().contains("ALLOW ONLY LETTERS")) {
				String specilcharacter="1234567890.*[~!@#$%^&*()+/\\[\\]{}=?><.,`].*";
				if (containsSpecialCharacter(fieleddata, specilcharacter)) {
				    // Do something if the string contains any of the special characters
					System.out.println("validation pass");
					testCase = extent.createTest("CONFIRM VALIDATION");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
					
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
        }
				else {
					System.out.println("validation fail");
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
				
				
			}else if (valed.toUpperCase().contains("MUST BE A NUMBER")) {
				String specilcharacter="qwertyuiopasdfghjklzxcvbnm.*[~!@#$%^&*()+/\\[\\]{}=?><.,`].*";
				if (containsSpecialCharacter(fieleddata, specilcharacter)) {
				    // Do something if the string contains any of the special characters
					System.out.println("validation pass");
					testCase = extent.createTest("CONFIRM VALIDATION");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
					
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
        }
				else {
					System.out.println("validation fail");
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
				
				
			}else if (valed.contains("At Least 2 charaters long!")) {
				if (fieleddata.length()<=2) {
				    // Do something if the string contains any of the special characters
					System.out.println("validation pass");
					testCase = extent.createTest("CONFIRM VALIDATION");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
					
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
        }
				else {
					System.out.println("validation fail");
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
				
				
			}else if (valed.contains("Contact No must be 10 to 12 digit")) {
				if (fieleddata.length()<=10 || fieleddata.length()>=12 ) {
				    // Do something if the string contains any of the special characters
					System.out.println("validation pass");
					testCase = extent.createTest("CONFIRM VALIDATION");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
					
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
        }
				else {
					System.out.println("validation fail");
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
				
				
			}else if (valed.contains("At least 3 characters long!")) {
				if (fieleddata.length()<=3) {
				    // Do something if the string contains any of the special characters
					System.out.println("validation pass");
					testCase = extent.createTest("CONFIRM VALIDATION");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
					
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
        }
				else {
					System.out.println("validation fail");
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
				
				
			}else if (valed.contains("must be 3 characters long!")) {
				if (fieleddata.length()<=3) {
				    // Do something if the string contains any of the special characters
					System.out.println("validation pass");
					testCase = extent.createTest("CONFIRM VALIDATION");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
					
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
        }
				else {
					System.out.println("validation fail");
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
				
				
			}
			else if (valed.contains("cant not be Space")) {
				String specilcharacter=" ";
				if (fieleddata.contains(specilcharacter)) {
				    // Do something if the string contains any of the special characters
					System.out.println("validation pass");
					testCase = extent.createTest("CONFIRM VALIDATION");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
					
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.PASS, "TEST PASS");
        }
				else {
					System.out.println("validation fail");
					testCase = extent.createTest(TEST+" Validation");
					testCase.log(Status.INFO, valed+" validation");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
				
				
			}

		}
		validCorfirm = true;
	}
	static int countk=0;
	public static void tabledatamatching(int trsearch, String checktd ,String data, String TEST) {

//	   

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			boolean pass = false;
			String[] numberStrings = checktd.split(",");
			String[] dataStrings = data.split(",");

			int[] numbers = new int[numberStrings.length];
			System.out.println(numberStrings.length);
			for (int ci = 0; ci < numberStrings.length; ci++) {
				System.out.println("looop"+ci);
//		    numbers[i] = Integer.parseInt(numberStrings[i].trim());
				String coldata = numberStrings[ci];
				String excoldata = dataStrings[ci];
				System.out.println(coldata + "jjjjjjjjjjjjj");
				System.out.println(excoldata+"exdataaaaaaa");
				if (coldata.equals("3")) {
					System.out.println(coldata+"[[[[[[[[[");
					String[] subcat=excoldata.split("-");
					excoldata=subcat[0];
					System.out.println(excoldata+"]]]]]]]]");
					
				}
				WebElement table = driver.findElement(By.xpath("(//tbody//tr[contains(@class,'ant-table-row')]/td[" + coldata + "])["+trsearch +"]"));
				String actvalue = table.getText();
System.out.println(actvalue+"kajancheck************///////*****");
				if (excoldata.equals(actvalue)) {
					pass = true;
          
				}
				else {
					pass = false;
				}
				if (!pass) {
					
					break;

				}

			}
			if (pass) {
				countk=countk+1;
				
			}

				
	}

	public static void paginationWithoutPageSelection(String excelname,String tabname,String testid,String testCaseDescroption) {
		
		// get data from excel

				XSSFRow row = null;
				DataFormatter dataValue = new DataFormatter();
				FileInputStream fileIn = null;
				XSSFWorkbook wbook = null;
				String filelocation;

				try {
					filelocation = "./src/test/resources/Excel/"+excelname+".xlsx";
					fileIn = new FileInputStream(filelocation);
					wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
					fileIn.close();

					PropertiesCommonMethods.excalRowCount(excelname+".xlsx", tabname, testid);
					XSSFSheet sheet = wbook.getSheet(tabname);
					int r = PropertiesCommonMethods.countRow - 1;
					row = sheet.getRow(r);
					String pagecount = dataValue.formatCellValue(row.getCell(2));
					int ExpectedTotalPage5= Integer.parseInt(pagecount);
					
					WebElement  previousbtn = null;
					WebElement nextbtn = null ;
					WebElement fistpagebtn = null;
					WebElement secoundpagebtn= null;
					
					try {
						
					    previousbtn =driver.findElement(By.xpath("//li[@title='Previous Page']//button"));
						wait.until(ExpectedConditions.elementToBeClickable(previousbtn));

					} catch (Exception e) {
						// TODO: handle exception
					}
					try {
						
						nextbtn=driver.findElement(By.xpath("//li[@title='Next Page']/button"));
						wait.until(ExpectedConditions.elementToBeClickable(nextbtn));

					} catch (Exception e) {
						// TODO: handle exception
					}
					try {
						
						fistpagebtn=driver.findElement(By.xpath("//li[@title='1']"));
						wait.until(ExpectedConditions.elementToBeClickable(fistpagebtn));

					} catch (Exception e) {
						// TODO: handle exception
					}
					try {
						
						secoundpagebtn=driver.findElement(By.xpath("//li[@title='2']"));
						wait.until(ExpectedConditions.elementToBeClickable(secoundpagebtn));

					} catch (Exception e) {
						// TODO: handle exception
					}
					
//					REOPRT HEADING
					testCase = extent.createTest(testCaseDescroption);

					functionality.ButtonAndIconFunctionalityPassInable("CHECKING DEFAULT PREVIOUS BUTTON", previousbtn, "Button");
					functionality.ButtonAndIconunctionalityMtd("CHECKING DEFAULT NEXT BUTTON", nextbtn, "Button");
					functionality.ButtonAndIconunctionalityMtd("CHECKING DEFAULT FIRST PAGE BUTTON", fistpagebtn, "Page Button");
					materialMethodes.click(driver.findElement(By.xpath("//li[@title='Next Page']/button")), "NEXT BUTTON");
					functionality.ButtonAndIconunctionalityMtd("CHECKING DEFAULT SECOUND PAGE BUTTON", secoundpagebtn, "Page Button");
//	              REFRESH
					driver.navigate().refresh();
		              Thread.sleep(1000);
	              functionality.ButtonAndIconunctionalityMtd("CHECKING DEFAULT FIRST PAGE BUTTON", fistpagebtn, "Page Button");
	              functionality.ButtonAndIconFunctionalityPassInable("CHECKING DEFAULT PREVIOUS BUTTON", previousbtn, "Button");
	              materialMethodes.click(driver.findElement(By.xpath("//li[@title='Next Page']/button")), "NEXT");
	              functionality.ButtonAndIconunctionalityMtd("CHECKING DEFAULT PREVIOUS BUTTON", previousbtn, "Button");
//	            REFRESH
	              driver.navigate().refresh();
	              Thread.sleep(1000);
	              
	               int ActualTotalPage = 1;
	               boolean Enablity1 = driver.findElement(By.xpath("//li[@title='Next Page']/button")).isEnabled();
	               while (Enablity1) {
	                      Thread.sleep(2000);
	                      driver.findElement(By.xpath("//li[@title='Next Page']/button")).click();
	                      ActualTotalPage = ActualTotalPage + 1;
	                      Enablity1 = driver.findElement(By.xpath("//li[@title='Next Page']/button")).isEnabled();
	                      Thread.sleep(2000);
	                      System.out.println(ActualTotalPage+"*****************");
	                      Enablity1 = driver.findElement(By.xpath("//li[@title='Next Page']/button")).isEnabled();            
	                  }
	                  System.out.println(ActualTotalPage);
	                 
	                     
	                      testCase = extent.createTest("➢ Checking Total Page for 5 Data per page");
	                      try {
	                          Assert.assertEquals(ActualTotalPage, ExpectedTotalPage5);
	                          testCase.log(Status.INFO, "Current Pagination Opction ");
	                          testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
	                          testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage5);
	                          testCase.log(Status.PASS, "Correct Page Count");
	                      } catch (AssertionError e) {
	                          testCase.log(Status.INFO, "Current Pagination Opction :- "
	                                  );
	                          testCase.log(Status.INFO, "Actual Page Count :- " + ActualTotalPage);
	                          testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedTotalPage5);
	                          testCase.log(Status.FAIL, "Wrong Page Count");
	                      }
	                   
	                  
	                  driver.navigate().refresh();
	                  Thread.sleep(2000);
	              
	              
				}catch (Exception e) {
					// TODO: handle exception
				}
	

	}
	public static boolean containsSpecialCharacter(String mydata, String specilcharacter) {
	    for (char c : mydata.toCharArray()) {
	        if (specilcharacter.indexOf(c) != -1) {
	            // If the character exists in specilcharacter, it's a special character
	            return true;
	        }
	    }
	    return false;
	}
	public static boolean iconclick=false;
	public static void iconclick(String td,String datas,String act) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
				
				boolean pass = false;
				String[] numberStrings = td.split(",");
				String[] dataStrings = datas.split(",");
				String coltd = numberStrings[0];
				String excoldata = dataStrings[0];
				
				//****************************************************
				boolean nextt=true;
				while (nextt) {
				List<WebElement> trxpath	=driver.findElements(By.xpath("//tbody//tr[contains(@class,'ant-table-row')]"));
				int trcount=trxpath.size();
				System.out.println(trcount+"trcountttttttt");
				
				String actvaluee;
				int ti;
				  
				for ( ti = 1; ti <= trcount; ti++) {
					 WebElement tablee = driver.findElement(By.xpath("(//tbody//tr[contains(@class,'ant-table-row')]/td[" + coltd + "])[" + ti + "]"));
					actvaluee = tablee.getText();
					System.out.println(ti+"check trrrrr");
					System.out.println(actvaluee+"tabledatavalueeeeeee");
					System.out.println(excoldata+"exxxxxxxx");
					System.out.println(actvaluee+"acccccccc");
					if (actvaluee.equals(excoldata)) {
						
						

						int[] numbers = new int[numberStrings.length];
						if (numberStrings.length==1) {
							pass=true;
							
						}
						System.out.println(numberStrings.length);
						for (int ei = 1; ei < numberStrings.length; ei++) {
							System.out.println("looop"+ei);
//					    numbers[i] = Integer.parseInt(numberStrings[i].trim());
							 coltd = numberStrings[ei];
							String excoldat = dataStrings[ei];
							 if (coltd.equals("3")) {
								 System.out.println(excoldat+"xxxxxxxxxxxx");
									String[] coldt=excoldat.split("-");
									 excoldata=coldt[0];
								
						}else {
							excoldata=excoldat;
						}
							System.out.println(coltd + "jjjjjjjjjjjjj");
							System.out.println(excoldata+"exdataaaaaaa");
							String actvalue;
							
		
				
				WebElement table = driver.findElement(By
						.xpath("(//tbody//tr[contains(@class,'ant-table-row')]/td[" + coltd + "])[" + ti + "]"));
				actvalue = table.getText();
				System.out.println(actvalue + "kajancheck************///////*****");
			
			
							if (excoldata.equals(actvalue)) {
								pass = true;
			          
							}
							else {
								pass = false;
							}
							if (!pass) {
								
								break;

							}

						}
						System.out.println(pass+"can click");
						if (pass) {
							System.out.println(coltd+"kkkkk"+act+"yyyy"+ti);
							WebElement action = driver.findElement(By
									.xpath("(//tbody//tr[contains(@class,'ant-table-row')]/td[" + coltd + "]//..//..//td//span//span[contains(@class,'anticon-"+act+"')])[" + ti + "]"));
							System.out.println(action+"xxxxxpath");
							action.click();
							iconclick=true;
							
						}

							
				

						
					}
					if (pass) {
						break;
					}
					
				}
				
				if (!pass) {
					try {
						WebElement nexT = driver.findElement(By.xpath("//li[@title='Next Page']/button"));
						nextt = nexT.isEnabled();
						if (nextt) {
							nexT.click();
						}
					} catch (Exception e) {
						// TODO: handle exception
					} 
				}else {
					break;
				}
			}
				
				//**********************************************
				
			}

		public static boolean edit =false;
		public static void popupdatacompare(String dataa) {
			int sendfieldc;
			boolean ok=false;
			String[] numberStrings = dataa.split(",");
			try {
				List<WebElement> sendfield=driver.findElements(By.xpath("//div[@class='ant-modal-body']//div[@class='input_wrapper']//*[contains(@class,'ant-input') or @class='ant-select-selector' or @class='ant-checkbox-input']"));
				sendfieldc=sendfield.size();
				System.out.println(sendfieldc+"sizeee");
				for(int c=1;c<=sendfieldc;c++) {
					System.out.println(c+"looop");
					String coltd = numberStrings[c-1];
					
					System.out.println(coltd+"dataaaaa from excel");
					WebElement csendfield=driver.findElement(By.xpath("(//div[@class='ant-modal-body']//div[@class='input_wrapper']//*[contains(@class,'ant-input') or @class='ant-select-selector' or @class='ant-checkbox-input'])["+c +"]"));
					 String tagName = csendfield.getTagName();
					 String filldata="";
					 //***********************************
					 if (tagName.equals("input")) {
						 filldata =   csendfield.getAttribute("value");
					    } else if (tagName.equals("select")) {
					    	filldata =	csendfield.getText(); // or use element.getAttribute("value") for selected option value
					    } else if (tagName.equals("input") && csendfield.getAttribute("type").equals("checkbox")) {
					    boolean	filldat =	csendfield.isSelected();
					    filldata = String.valueOf(filldat);
					    
					    } else if(tagName.equals("div")){
					    	
					    		filldata =csendfield.getText();
					    		if(filldata.contentEquals("Enter Plant Name") || filldata.contentEquals("Enter Supplier Category")) {
								filldata ="";
					    		}
					    	
					    }else {
					    	filldata =csendfield.getText();
					    }
					 //**********************
					
					System.out.println(filldata+"data from popup");
					if (filldata.toUpperCase().equals(coltd.toUpperCase())) {
						ok=true;
						System.out.println("passssss");
					}else {
						ok=false;
						System.out.println("can't be delete unmatch data popup is opened");
						 testCase = extent.createTest("can't be delete unmatch data popup is opened");
	                      try {
	                          Assert.assertEquals(filldata.toUpperCase(), coltd.toUpperCase());
	                          testCase.log(Status.INFO, "can't be delete unmatch data popup is opened");
	                          testCase.log(Status.INFO, "Actual data :- " + filldata.toUpperCase());
	                          testCase.log(Status.INFO, "Expected data :- " + coltd.toUpperCase());
	                          testCase.log(Status.PASS, "Correct data");
	                      } catch (AssertionError e) {
	                          testCase.log(Status.INFO, "can't be delete unmatch data popup is opened"
	                                  );
	                          testCase.log(Status.INFO, "Actual data :- " + filldata.toUpperCase());
	                          testCase.log(Status.INFO, "Expected data :- " + coltd.toUpperCase());
	                          testCase.log(Status.FAIL, "Wrong data");
	                      }
						break;
					}
				}
				if (ok) {
					System.out.println("can be edit");
					edit=true;
					
				}
				
			} catch (Exception e) {
				
			}
			
			
			
		}
		
		public static void editmaterial(String excelbook, String exceltab, String testid) throws InterruptedException {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// get data from excel

			XSSFRow row = null;

			DataFormatter dataValue = new DataFormatter();
			String filelocation;
			String plant1 = null;
			String plant2 = null;
			String maincatogory1 = null;
			String maincatogory2 = null;
			String subcatogory1 = null;
			String subcatogory2 = null;
			String Prefix1 = null;
			String Prefix2 = null;
			String MaterialState1 = null;
			String MaterialState2 = null;
			String Material1 = null;
			String Material2 = null;
			String ERPCode1 = null;
			String ERPCode2 = null;
			String Act1 = null;
			String Act2 = null;
			String Description1 = null;
			String Description2 = null;
			String MaterialSource1 = null;
			String MaterialSource2 = null;
			String materialType1=null;
			String materialType2=null;
			String checktd=null;
			String cdata=null;
			boolean depend=false;
			boolean materialTypetic1=false;
			boolean materialTypetic2=false;
			
			boolean Active1 = false;
			boolean Active2 = false;

			try {
				filelocation = "./src/test/resources/Excel/" + excelbook + ".xlsx";
				System.out.println(testid + "ttttttttttttttttttttt");
				int firstrow = CommonMethods.getFirstRowNum(filelocation, exceltab, testid);
				int lastrow = CommonMethods.getLastRowNum(filelocation, exceltab, testid);
				System.out.println(firstrow + "ffffffff");
				System.out.println(lastrow + "llllllllllllll");

				FileInputStream file = new FileInputStream(filelocation);
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet(exceltab);

				for (int j = firstrow; j <= firstrow; j++) {
					row = sheet.getRow(j);

					materialType1=dataValue.formatCellValue(row.getCell(1));
					materialType2=dataValue.formatCellValue(row.getCell(14));
					
					String typetic1=dataValue.formatCellValue(row.getCell(2));
					materialTypetic1=Boolean.valueOf(typetic1);
					String typetic2 =dataValue.formatCellValue(row.getCell(15));
					materialTypetic2=Boolean.valueOf(typetic2);
					
					plant1 = dataValue.formatCellValue(row.getCell(3));
					plant2 = dataValue.formatCellValue(row.getCell(16));
					
					maincatogory1 = dataValue.formatCellValue(row.getCell(4));
					maincatogory2 = dataValue.formatCellValue(row.getCell(17));
					
					subcatogory1 = dataValue.formatCellValue(row.getCell(5));
					subcatogory2 = dataValue.formatCellValue(row.getCell(18));
					
					Prefix1 = dataValue.formatCellValue(row.getCell(6));
					Prefix2 = dataValue.formatCellValue(row.getCell(19));
					
					MaterialState1 = dataValue.formatCellValue(row.getCell(7));
					MaterialState2 = dataValue.formatCellValue(row.getCell(20));
					
					Material1 = dataValue.formatCellValue(row.getCell(8));
					Material2 = dataValue.formatCellValue(row.getCell(21));
					
					ERPCode1 = dataValue.formatCellValue(row.getCell(9));
					ERPCode2 = dataValue.formatCellValue(row.getCell(22));
					
					MaterialSource1 = dataValue.formatCellValue(row.getCell(10));
					MaterialSource2 = dataValue.formatCellValue(row.getCell(23));
					
					Act1 = dataValue.formatCellValue(row.getCell(11));
					Active1 = Boolean.valueOf(Act1);
					Act2 = dataValue.formatCellValue(row.getCell(24));
					Active2 = Boolean.valueOf(Act2);
					
					Description1 = dataValue.formatCellValue(row.getCell(12));
					String dependd=dataValue.formatCellValue(row.getCell(13));
					depend=Boolean.valueOf(dependd);
					Description2 = dataValue.formatCellValue(row.getCell(25));
					checktd=dataValue.formatCellValue(row.getCell(26));
					cdata=dataValue.formatCellValue(row.getCell(27));
					exdata = true;
					/*********************************************************************************************/
					String cdataC=null;
					String td=null;
					String icclickdata=null;
					if (materialType1.toUpperCase().equals("PLANT")) {
						cdataC=plant1+","+subcatogory1+","+Prefix1+","+MaterialState1+","+Material1+","+ERPCode1+","+MaterialSource1+","+Active1+","+Description1;
						td=	"1,2,3,4,5";
						icclickdata=Material1+","+maincatogory1+","+subcatogory1+","+Prefix1+","+plant1;
					}else if (materialType1.toUpperCase().equals("SBU")) {
						cdataC=plant1+","+subcatogory1+","+Prefix1+","+MaterialState1+","+Material1+","+ERPCode1+","+MaterialSource1+","+Active1+","+Description1;
						td="1,2,3,4,9";
						icclickdata=Material1+","+maincatogory1+","+subcatogory1+","+Prefix1+","+plant1;
					}else if (materialType1.toUpperCase().equals("COMMON")){
						cdataC=subcatogory1+","+Prefix1+","+MaterialState1+","+Material1+","+ERPCode1+","+MaterialSource1+","+Active1+","+Description1;
						td="1,4";
						icclickdata=Material1+","+Prefix1;
					}
					
					materialMethodes.iconclick( td, icclickdata, "edit");
					materialpopupdatacompare(cdataC,materialType1.toUpperCase());
					boolean ed=false;
					if (edit) {
						Thread.sleep(2000);
						if (!materialType2.equals( materialType1)&&!depend) {
							ed=true;
							System.out.println("kkkkkkkkkkkyyyyyyyyyy");
							checkbox(driver.findElement(By.xpath("//div[@class='ant-modal-body']//input[@value='" + materialType2.toUpperCase() + "']//..//span[contains(@class,'ant-radio')]")),driver.findElement(By.xpath("//div[@class='ant-modal-body']//input[@value='" + materialType2.toUpperCase() + "']")),materialTypetic2, "MATERIAL TYPE");
						}
							if (materialType2.toUpperCase().equals("PLANT")&&!plant2.equals( plant1)&&!depend) {
								ed=true;
								dropdown(driver.findElement(By.xpath("//label[text()='Plant :']//..//div[1]/div")), plant2,
										"//div[@class='rc-virtual-list-holder-inner']/div[@title='", "']/div", "PLANT");
							}else if (click&&materialType2.toUpperCase().equals("SBU")&&!plant2.equals( plant1)&&!depend) {
								ed=true;
								dropdown(driver.findElement(By.xpath("//label[text()=' SBU :']//..//div[1]/div")), plant2,
										"//div[@class='rc-virtual-list-holder-inner']/div[@title='", "']/div", "SBU");
							}else if (click&&materialType2.toUpperCase().equals("COMMON")&&!plant2.equals( plant1)&&!depend) {
								ed=true;
								select = true;
							}
							if (!subcatogory2.equals(subcatogory1)&&!depend) {
								ed=true;
								select = false;
								dropdown(driver.findElement(By.xpath("//label[@for='sub_category']//..//div[1]/div")), subcatogory2,
										"//div[@class='ant-select-item-option-content']/span[text()='", "']", "SUB CATEGORY");
							}
							if (!Prefix2.equals(Prefix1)&&!depend) {
								ed=true;
								sendkey(driver.findElement(By.xpath("//label[@for='prefix']//..//input")), Prefix2, "PREFIX");
							}
						
						
						if (!MaterialState2.equals(MaterialState1)) {
							ed=true;
							dropdown(driver.findElement(By.xpath("//label[@for='material_state']//..//div[1]/div")),
									MaterialState2, "//div[text()='", "']", "MATERIAL STATE");
						}
						if (!Material2.equals( Material1)) {
							ed=true;
							sendkey(driver.findElement(By.xpath("//label[@for='material_name']//..//input")), Material2,
									"MATERIAL");
						}
						if (!ERPCode2.equals(ERPCode1)) {
							ed=true;
							sendkey(driver.findElement(By.xpath("//label[text()='ERP Code:']//..//input")), ERPCode2,
									"ERP CODE");
						}
						if (!MaterialSource1.equals( MaterialSource2) ){
							ed=true;
							dropdown(driver.findElement(By.xpath("//label[text()='Material Source :']//..//input")),
									MaterialSource2, "//div[@class='ant-select-item-option-content'][text()='", "']",
									"MATRIAL SOURCE");
						}
						if (Active2!= Active1) {
							ed=true;
							checkbox(
									driver.findElement(
											By.xpath("//div[@class='ant-modal-body']//input[@id='active']//..")),
									driver.findElement(By.xpath("//div[@class='ant-modal-body']//input[@id='active']")),
									Active2, "ACTIVE");

						}
						if (!Description1.toUpperCase().equals( Description2.toUpperCase())) {
							ed=true;
							sendkey(driver.findElement(By.xpath("//label[text()='Description:']//..//textarea")),
									Description2, "DESCRIPTION");
						}
						if (ed) {
							//**************************************
							if (materialType2.toUpperCase().equals("PLANT")) {
								cdataC=plant2+","+subcatogory2+","+Prefix2+","+MaterialState2+","+Material2+""+ERPCode2+""+MaterialSource2+""+Active2+""+Description2;
									
				
							}else if (materialType2.toUpperCase().equals("SBU")) {
								cdataC=plant2+","+subcatogory2+","+Prefix2+","+MaterialState2+","+Material2+""+ERPCode2+""+MaterialSource2+""+Active2+""+Description2;
								
							}else if (materialType2.toUpperCase().equals("COMMON")){
								cdataC=subcatogory2+","+Prefix2+","+MaterialState2+","+Material2+""+ERPCode2+""+MaterialSource2+""+Active2+""+Description2;
								
							}
							popupdatacompare(cdataC);
							
							//**********************************
							
						
							click(driver.findElement(By.xpath("//div[@class='ant-modal-footer']//button[2]")),
									"ADD MATERIAL SAVE BUTTON");
						}else {
							testCase = extent.createTest("CHECKING THE EDITED DATA");
							testCase.log(Status.INFO, "DO NOT ANY CHANGES IS THERE");
							testCase.log(Status.INFO, "CHECK EXCEL DATA");
							testCase.log(Status.FAIL, "TEST FAIL ❎");
							
						}
						if (click) {
							click = false;
							popupcheck(driver.findElement(By.xpath("//div[@class='ant-modal-content']")),
									"ADD MATERIAL");
						}
						if (!pop&&ed) {

							datacheckinfirstrow("1,2,3,4,5,6", 2, Material2 + "," + maincatogory2 + "," + subcatogory2
									+ "," + Prefix2 + "," + plant2 + "," + MaterialState2, "ADD MATERIAL PLANT WISE");

						} else if (pop&&ed) {
							validation();
							validationconfirm(checktd, cdata, "edit material validation");
						} 
					}
					//	          REFRESH
					driver.navigate().refresh();
					Thread.sleep(1000);

				}
			} catch (Exception e) {
				testCase = extent.createTest("EXCEL DATA NOT THERE");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
//		          REFRESH
				driver.navigate().refresh();
				Thread.sleep(1000);

			}

		
			
		}
	public static void materialpopupdatacompare(String dataa,String mattype) {

		int sendfieldc;
		boolean ok=false;
		String[] numberStrings = dataa.split(",");
		try {
			List<WebElement> sendfield=driver.findElements(By.xpath("//div[@class='ant-modal-body']//div[@class='input_wrapper']//*[contains(@class,'ant-input') or @class='ant-select-selector' or @class='ant-checkbox-input']"));
			sendfieldc=sendfield.size();
			System.out.println(sendfieldc+"sizeee");
			for(int c=1;c<=sendfieldc;c++) {
				System.out.println(c+"looop");
				String coltd=numberStrings[c-1];
				
				System.out.println(coltd+"dataaaaa from excel");
				WebElement csendfield=driver.findElement(By.xpath("(//div[@class='ant-modal-body']//div[@class='input_wrapper']//*[contains(@class,'ant-input') or @class='ant-select-selector' or @class='ant-checkbox-input'])["+c +"]"));
				 String tagName = csendfield.getTagName();
				 String filldat=null;
				 String filldata;
				 //***********************************
				 if (tagName.equals("input")) {
					 filldat =   csendfield.getAttribute("value");
				    } else if (tagName.equals("select")) {
				    	filldat =	csendfield.getText(); // or use element.getAttribute("value") for selected option value
				    } else if (tagName.equals("input") && csendfield.getAttribute("type").equals("checkbox")) {
				    boolean	filldatc =	csendfield.isSelected();
				    filldata = String.valueOf(filldatc);
				    
				    } else {
				    	filldat =csendfield.getText();
				    }
				 if (c==2&& mattype.equals("COMMN") ) {
						
					 filldata= filldat+"-RM";
					}
					if (c==2&& mattype!=("COMMN")) {
						
						filldata= filldat+"-RM";
						 System.out.println(coltd+"joinnnn");
					}else {
						filldata= filldat;
					}
				 //**********************
				
				System.out.println(filldata+"data from popup");
				if (filldata.toUpperCase().equals(coltd.toUpperCase())) {
					ok=true;
					System.out.println("passssss");
				}else {
					ok=false;
					System.out.println("can't be delete unmatch data popup is opened");
					 testCase = extent.createTest("can't be delete unmatch data popup is opened");
                      try {
                          Assert.assertEquals(filldata.toUpperCase(), coltd.toUpperCase());
                          testCase.log(Status.INFO, "can't be delete unmatch data popup is opened");
                          testCase.log(Status.INFO, "Actual data :- " + filldata.toUpperCase());
                          testCase.log(Status.INFO, "Expected data :- " + coltd.toUpperCase());
                          testCase.log(Status.PASS, "Correct data");
                      } catch (AssertionError e) {
                          testCase.log(Status.INFO, "can't be delete unmatch data popup is opened"
                                  );
                          testCase.log(Status.INFO, "Actual data :- " + filldata.toUpperCase());
                          testCase.log(Status.INFO, "Expected data :- " + coltd.toUpperCase());
                          testCase.log(Status.FAIL, "Wrong data");
                      }
					break;
				}
			}
			if (ok) {
				System.out.println("can be edit");
				edit=true;
				
			}
			
		} catch (Exception e) {
			
		}
		
		
	}
	//****************************************
	 public static List<String> getRowData(String excelbook, String exceltab, String testid,int rowIndex,int fromcell ) throws IOException {
	        List<String> rowData = new ArrayList<String>();
	        String filelocation=null;
	        try {
				filelocation = "./src/test/resources/Excel/" + excelbook + ".xlsx";
				System.out.println(testid + "ttttttttttttttttttttt");
				int firstrow = CommonMethods.getFirstRowNum(filelocation, exceltab, testid);
				int lastrow = CommonMethods.getLastRowNum(filelocation, exceltab, testid);
				System.out.println(firstrow + "ffffffff");
				System.out.println(lastrow + "llllllllllllll");

				FileInputStream file = new FileInputStream(filelocation);
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet(exceltab);
	            Row row = sheet.getRow(rowIndex);

	            if (row != null) {
	                Iterator<Cell> cellIterator = row.cellIterator();
	                int currentCellIndex = 0;

	                while (cellIterator.hasNext()) {
	                    Cell cell = cellIterator.next();
	                    if (currentCellIndex < fromcell) {
	                        // Skip cells before cell 5 (index 4)
	                        currentCellIndex++;
	                        continue;
	                    }

	                    String cellValue = getCellValueAsString(cell);
	                    rowData.add(cellValue);

	                    if (cellValue == null || cellValue.isEmpty()) {
	                        // Stop collecting data if the cell value is null or empty
	                        break;
	                    }

	                    currentCellIndex++;
	                }
	            }
	        }catch (Exception e) {
				
			}

	        return rowData;
	    }
	 
	 //************************
	 private static String getCellValueAsString(Cell cell) {
	        if (cell == null) {
	            return null;
	        }

	       // switch (cell.getCellType()) {
	           // case STRING:
	            //	case String
	                return cell.getStringCellValue().trim();
//	            case NUMERIC:
//	                return String.valueOf(cell.getNumericCellValue()).trim();
//	            case BOOLEAN:
//	                return String.valueOf(cell.getBooleanCellValue()).trim();
//	            case FORMULA:
//	                return cell.getCellFormula().trim();
	       //     default:
	         //       return null;
	      //  }
	    }
	 //************************************
	
	
	//**************************************
	 
	 public static void cancelOrCloseButtonFunction(WebElement button,WebElement popup,String testbutton,String testpopup) {
		 
		 materialMethodes.click(button, testbutton);
		 if (click) {
			 click=false;
			 popupcheck(popup, testpopup);
			
		}
		 if (!pop) {
			 testCase = extent.createTest("checking the "+testbutton+" function");
			 testCase.log(Status.INFO, testpopup+" popup is there after clicking "+testbutton); 
			 testCase.log(Status.FAIL, "TEST FAIL ❎");
		}else if (pop) {
			testCase = extent.createTest("checking the "+testbutton+" function");
			testCase.log(Status.INFO, testpopup+" popup is not there after clicking "+testbutton); 
			 testCase.log(Status.PASS, "TEST PASS ");
			
		}
		
	}

	 public static void materialAddkey(String test,String TestOrigin,String field) {
		 String[] testname = test.split(",");
		 String[] testorig=TestOrigin.split(",");
		 List<WebElement> tic=null;
			int ticsize = 0;
			try {
				tic=driver.findElements(By.xpath("//div[@class='ant-modal-content']//tbody//tr[contains(@class,'ant-table-row')]"));
				ticsize=tic.size();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			for(int a=1;a<=ticsize;a++) {
				WebElement chet=driver.findElement(By.xpath("(//div[@class='ant-modal-content']//tbody//tr[contains(@class,'ant-table-row')]/td/label[@class='ant-checkbox-wrapper']//input)["+a+"]"));
			boolean ctic=	chet.isSelected();
			if (ctic) {
				chet.click();
			}
			}
		 int lengtgh=testname.length;
		 for(int k=0; k<lengtgh;k++) {
		String name1= testname[k];
		String name2 = testorig[k];
		
			 WebElement keytesttic=null;
			try {
				keytesttic = driver.findElement(By.xpath("//div[@class='ant-modal-content']//tbody//tr[contains(@class,'ant-table-row')]/td[text()='"+name1+"']/../td[text()='"+name2+"']/../td/label[@class='ant-checkbox-wrapper']"));
			} catch (Exception e) {
				
			}
			 WebElement ticccc=null;
			try {
				ticccc = driver.findElement(By.xpath("//div[@class='ant-modal-content']//tbody//tr[contains(@class,'ant-table-row')]/td[text()='"+name1+"']/../td[text()='"+name2+"']/../td/label[@class='ant-checkbox-wrapper']//input"));
			} catch (Exception e) {
				
			}
			System.out.println(keytesttic+" 1111111 "+ticccc);
			
			 checkboxn(keytesttic, ticccc,field);
			 
			 
		 }
		 
		
	}
	 
	 public static void checkboxn(WebElement webElement, WebElement iner, String element) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
			System.out.println("!!!!!!!!!!!!!!!!!");
			try {

				boolean v = webElement.isDisplayed();
				SampleCommonMethods.TestCasePrint(element.toUpperCase() + " VISIBILITY", "TRUE",
						String.valueOf(v).toUpperCase());
				Boolean V2 = webElement.isEnabled();
				SampleCommonMethods.TestCasePrint(element.toUpperCase() + "ENABLITY", "TRUE",
						String.valueOf(V2).toUpperCase());

				boolean b = iner.isSelected();
				System.out.println(b+"sssssss");
				
				if (!b ) {
					iner.click();

				}
				tick = true;

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("CHECKING THE " + element);
				testCase.log(Status.INFO, "UNABLE TO LOCATE THE ELEMENT " + element);
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("CHECKING THE " + element);
				testCase.log(Status.INFO, "UNABLE TO CLICK ON THE ELEMENT " + element);
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			} catch (Exception e) {
				testCase = extent.createTest("CHECKING THE " + element);
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		}
	 public static void materialEditkey(String test,String TestOrigin,String type, String field) {
		 String[] testname = test.split(",");
		 String[] testorig=TestOrigin.split(",");
		 String[] typet=type.split(",");
		 List<WebElement> tic=null;
			int ticsize = 0;
			try {
				tic=driver.findElements(By.xpath("//div[@class='ant-modal-content']//tbody//tr[contains(@class,'ant-table-row')]"));
				ticsize=tic.size();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			for(int a=1;a<=ticsize;a++) {
				WebElement chet=driver.findElement(By.xpath("(//div[@class='ant-modal-content']//tbody//tr[contains(@class,'ant-table-row')]/td/label[@class='ant-checkbox-wrapper']//input)["+a+"]"));
			boolean ctic=	chet.isSelected();
			if (ctic) {
				chet.click();
			}
			}
		 int lengtgh=testname.length;
		 for(int k=0; k<lengtgh;k++) {
		String name1= testname[k];
		String name2 = testorig[k];
		String typee=typet[k];
		boolean typeeee=Boolean.valueOf(typee);
			 WebElement keytesttic=null;
			try {
				keytesttic = driver.findElement(By.xpath("//div[@class='ant-modal-content']//tbody//tr[contains(@class,'ant-table-row')]/td[text()='"+name1+"']/../td[text()='"+name2+"']/../td/label[@class='ant-checkbox-wrapper']"));
			} catch (Exception e) {
				
			}
			 WebElement ticccc=null;
			try {
				ticccc = driver.findElement(By.xpath("//div[@class='ant-modal-content']//tbody//tr[contains(@class,'ant-table-row')]/td[text()='"+name1+"']/../td[text()='"+name2+"']/../td/label[@class='ant-checkbox-wrapper']//input"));
			} catch (Exception e) {
				
			}
			System.out.println(keytesttic+" 1111111 "+ticccc);
			
			 checkbox(keytesttic, ticccc,typeeee,field);
			 
			 
		 }
		 
		
	}
	 
}