//***********************************************************************************
//* Description
//*------------
//* EQUIPMENT MAIN METHODS
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
package com.qa.automation.qdms.testcases.Equipment;

import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.mixdesign.commonmethods.Validation;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.pages.master.UserPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SelectDate;
import com.qa.automation.qdms.testcases.plantequipment.PlantEquipmentAddMethods;
import com.qa.automation.qdms.testcases.user.UserMainTests;

public class EquipmentMainTests extends DriverIntialization {
	static EquipmentPage equipment = new EquipmentPage();
	static UserPage user = new UserPage();
	static PlantEquipmentPage page = new PlantEquipmentPage();
	static SourcePage SourcePg = new SourcePage();

	public static String Equipment = null;
	public static String EquipmentType = null;
	public static String Description = null;

	static String EquipmentNew = null;
	static String EquipmentTypeNew = null;
	static String DescriptionNew = null;

	static int page10 = 0;
	static int page20 = 0;
	static int page30 = 0;

	static String SamEquipment = null;

	static int BeforeCount = 0;
	static int AfterCount = 0;
	
	static String Equipment1=null;
	static String Equipment2=null;
	static String Equipmentlastpage=null;
	
	static boolean check=false;

	public static void pagedata() throws IOException, InterruptedException {

		PageFactory.initElements(driver, equipment);
		boolean pass = false;
		Thread.sleep(1000);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Equipment";
		String testCaseId = "TC-EQU-0024";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Equipment");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(1).getBooleanCellValue();
			page10 = (int) row.getCell(2).getNumericCellValue();
			page20 = (int) row.getCell(3).getNumericCellValue();
			page30 = (int) row.getCell(4).getNumericCellValue();
		}
	}
	// equipments pagination

	public static void paginationtestEquipments() throws InterruptedException {

		PageFactory.initElements(driver, equipment);

//		Default Index Page
		boolean ActualDefaultPageIndex = EquipmentPage.DefaultPaginationPageeq.isDisplayed();
		boolean ExpectedDefaultPageIndex = true;

		UserMainTests.TestCasePrint("STEP 4-PAGINATION-DEFAULT-PAGE-INDEX", ExpectedDefaultPageIndex,
				ActualDefaultPageIndex);
//		Refresh pagination into default page 

		EquipmentPage.NextPageBtnEq.click();
		Thread.sleep(20000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		boolean ActualDefaultPageIndex1 = EquipmentPage.DefaultPaginationPageeq.isDisplayed();
		boolean ExpectedDefaultPageIndex1 = true;

		UserMainTests.TestCasePrint("STEP 4-PAGINATION-REFERESH-INTO-DEFAULT-PAGE", ExpectedDefaultPageIndex1,
				ActualDefaultPageIndex1);

//		Page Redirect to the next page 
		EquipmentPage.NextPageBtnEq.click();
		Thread.sleep(2000);
		boolean ActualSecoundPageIndex = EquipmentPage.PaginationSecoundPageEq.isDisplayed();
		boolean ExpectedSecoundPageIndex = true;

		UserMainTests.TestCasePrint("STEP 4-PAGINATION-PAGE-REDIRECT-TO-NEXT-PAGE", ExpectedSecoundPageIndex,
				ActualSecoundPageIndex);
		// Total Text Visible
		boolean ActualVisibleTotalText = EquipmentPage.totalTextSecondPageEq.isDisplayed();
		boolean ExpectedVisibleTotalText = true;

		UserMainTests.TestCasePrint("STEP 4-PAGINATION_TOTAL_TEXT_VISIBLE", ExpectedVisibleTotalText,
				ActualVisibleTotalText);

		// number of rows
		int TotalRowActual = EquipmentPage.totalrowsEq.size();
		System.out.println("Number of rows " + TotalRowActual);

		int TotalRowExpected = 11;

		UserMainTests.TestCasePrint("STEP 4-FIRST-PAGE-ROWS", TotalRowExpected, TotalRowActual);
		// pagination function

//			driver.navigate().refresh();
		//
//			Thread.sleep(2000);
		//
//			Master_UserPages.CurrentPaginationOpctionEq.click();
		//
//			Thread.sleep(2000);
		//
//			Master_UserPages.Page_20Eq.click();
		//
//			Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)");

	}

	public static void paginationtEquipmentsFunction() throws InterruptedException {

		PageFactory.initElements(driver, equipment);

		System.out.println(EquipmentPage.CurrentPaginationOpctionEq.getText());
		Thread.sleep(2000);
		// Thread.sleep(2000);
//			Master_UserPages.Page_30.click();
//			Thread.sleep(2000);
//			Master_UserPages.Page_100.click();
//			Thread.sleep(2000); 
//			System.out.println("****"+Master_UserPages.CurrentPaginationOpction.getText());
//			Total Count of the 10/page index
		if (EquipmentPage.CurrentPaginationOpctionEq.getText().contentEquals("10 / page")) {
			int ActualPageIndex_10 = (EquipmentPage.totalrowsEq.size() - 1);
			int ExpectedIndex_10 = page10;

			if (0 <= ActualPageIndex_10) {
				if (ActualPageIndex_10 <= 10) {

					UserMainTests.TestCasePrint("PAGINATION-TOTAL-DATA-OF-10/PAGE-INDEX", ExpectedIndex_10,
							ActualPageIndex_10);

				} else {
					testCase.log(Status.INFO,
							"Current Pagination Opction :- " + EquipmentPage.CurrentPaginationOpctionEq.getText());
					testCase.log(Status.INFO, "Actual TotalData :- " + ActualPageIndex_10);
					testCase.log(Status.FAIL, "Wrong TotalData");
				}
			} else {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EquipmentPage.CurrentPaginationOpctionEq.getText());
				testCase.log(Status.INFO, "Actual TotalData :- " + ActualPageIndex_10);
				testCase.log(Status.FAIL, "Wrong TotalData");
			}

		}
//			Total Count of the 20/page index
		else if (EquipmentPage.CurrentPaginationOpctionEq.getText().contentEquals("20 / page")) {
			int ActualPageIndex_20 = (EquipmentPage.when20equipmentnamecolumnEq.size() - 1);
			System.out.println(ActualPageIndex_20);
			int ExpectedPageIndex_20 = page20;

			if (0 <= ActualPageIndex_20) {

				if (ActualPageIndex_20 <= 20) {

					UserMainTests.TestCasePrint("STEP 7-PAGINATION-TOTAL-DATA-OF-20/PAGE-INDEX", ExpectedPageIndex_20,
							ActualPageIndex_20);
				} else {
					testCase.log(Status.INFO,
							"Current Pagination Opction :- " + EquipmentPage.CurrentPaginationOpctionEq.getText());
					testCase.log(Status.INFO, "Actual TotalData :- " + ActualPageIndex_20);
					testCase.log(Status.FAIL, "Wrong TotalData");
				}
			} else {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EquipmentPage.CurrentPaginationOpctionEq.getText());
				testCase.log(Status.INFO, "Actual TotalData :- " + ActualPageIndex_20);
				testCase.log(Status.FAIL, "Wrong TotalData");
			}

		}
//			Total Count of the 30/page index
		else if (EquipmentPage.CurrentPaginationOpctionEq.getText().contentEquals("30 / page")) {
			int ActualPageIndex_30 = (EquipmentPage.when30equipmentnamecolumn.size() - 1);
			System.out.println(ActualPageIndex_30);
			int ExpectedPageIndex_30 = page30;

			if (0 <= ActualPageIndex_30) {
				if (ActualPageIndex_30 <= 30) {

					UserMainTests.TestCasePrint("STEP 12-PAGINATION-TOTAL-DATA-OF-30/PAGE-INDEX", ExpectedPageIndex_30,
							ActualPageIndex_30);
				} else {
					testCase.log(Status.INFO,
							"Current Pagination Opction :- " + EquipmentPage.CurrentPaginationOpctionEq.getText());
					testCase.log(Status.INFO, "Actual TotalData :- " + ActualPageIndex_30);
					testCase.log(Status.FAIL, "Wrong TotalData");
				}
			} else {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EquipmentPage.CurrentPaginationOpctionEq.getText());
				testCase.log(Status.INFO, "Actual TotalData :- " + ActualPageIndex_30);
				testCase.log(Status.FAIL, "Wrong TotalData");
			}

		}
//			Total Count of the 100/page index
		else if (EquipmentPage.CurrentPaginationOpctionEq.getText().contentEquals("100 / page")) {
			int ActualPageIndex_100 = (EquipmentPage.when100equipmentnamecolumnEq.size() - 1);
			System.out.println(ActualPageIndex_100);
			int ExpectedPageIndex_100 = 100;

			if (0 <= ActualPageIndex_100) {
				if (ActualPageIndex_100 <= 100) {

					UserMainTests.TestCasePrint("PAGINATION-TOTAL-DATA-OF-100/PAGE-INDEX", ExpectedPageIndex_100,
							ActualPageIndex_100);

				} else {
					testCase.log(Status.INFO,
							"Current Pagination Opction :- " + EquipmentPage.CurrentPaginationOpctionEq.getText());
					testCase.log(Status.INFO, "Actual TotalData :- " + ActualPageIndex_100);
					testCase.log(Status.FAIL, "Wrong TotalData");
				}
			} else {
				testCase.log(Status.INFO,
						"Current Pagination Opction :- " + EquipmentPage.CurrentPaginationOpctionEq.getText());
				testCase.log(Status.INFO, "Actual TotalData :- " + ActualPageIndex_100);
				testCase.log(Status.FAIL, "Wrong TotalData");
			}

		}
	}

//	    Validation
	public static void ValidationEquipment() throws IOException, InterruptedException {
driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageFactory.initElements(driver, equipment);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebDriverWait wai = new WebDriverWait(driver, 2);
		DataFormatter dataf=new DataFormatter();
		boolean pass = false;
		boolean cancel=false;
		String ActualValidation1="";

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Equipment";
		String testCaseId = "TC-EQU-0034";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Equipment");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check =Boolean.parseBoolean(dataf.formatCellValue(row.getCell(1))) ;
			String Equipment =dataf.formatCellValue(row.getCell(2));
			String EquipmentType =dataf.formatCellValue(row.getCell(3));
			String Description = dataf.formatCellValue(row.getCell(4));
			String Validation1 = dataf.formatCellValue(row.getCell(5));
			String Validation2 = dataf.formatCellValue(row.getCell(6));
			String Message = dataf.formatCellValue(row.getCell(7));

			if (check) {
				try {
					wait.until(ExpectedConditions.elementToBeClickable(EquipmentPage.addequipmentbutton));
					EquipmentPage.addequipmentbutton.click();
					cancel=true;
			
				try {
					EquipmentPage.equipmenttextbox.sendKeys(Equipment);
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					EquipmentPage.equipmenttypetextbox.click();
					ActionCommonMethod.dropDown("//div[@id='type_list']/div", EquipmentType, "type_list");
					// if(pass) {
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					EquipmentPage.descriptiontextbox.sendKeys(Description);
				} catch (Exception e) {
				}
				try {
					EquipmentPage.equipmentsavebutton.click();
				} catch (Exception e) {
					// TODO: handle exception
				}
				boolean modalview=true;
				
		
			
					try {
						wai.until(ExpectedConditions
								.invisibilityOf(driver.findElement(By.xpath("//div[@class='ant-modal-content']"))));
						modalview=true;
					} catch (Exception e) {
						modalview=false;
					}
					if (!modalview) {
					 ActualValidation1 = EquipmentPage.equipment.getText();
					String ExpectedValidation1 = Validation1;
					testCase = extent.createTest(Message);
					try {
						AssertJUnit.assertEquals(ActualValidation1+" & Modal View:-"+modalview, ExpectedValidation1+" & Modal View:-"+"false");
						testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation1);
						testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation1);
						testCase.log(Status.PASS, "Pass " + Message + "Script");
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation1);
						testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation1);
						testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("Low Priority");
						testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("High Priority");
					}
					boolean emp = false;
					if (Validation2 == "") {
						emp = true;

					}
					try {
						if (!emp) {

							String	 ActualValidation2 = EquipmentPage.equipmenttypevalidation.getText();
							String ExpectedValidation2 = Validation2;
							testCase = extent.createTest(Message);
							try {
								AssertJUnit.assertEquals(ActualValidation2, ExpectedValidation2);
								testCase.log(Status.INFO,
										"Actual Validation :- " + EquipmentPage.equipmenttypevalidation.getText());
								testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation2);
								testCase.log(Status.PASS, "Pass " + Message + "Script");
							} catch (AssertionError e) {
								testCase.log(Status.INFO,
										"Actual Validation :- " + EquipmentPage.equipmenttypevalidation.getText());
								testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation2);
								testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("Low Priority");
								testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("High Priority");
							}
							// } catch (NoSuchElementException e) {

						}
					} catch (Exception e) {
					} 
				}
			} catch (Exception e) {
				PropertiesCommonMethods.cTestReports("Add Equipment Button Click Fail", true, false, Message);
			}
			}
			
			try {
				if (cancel) {
					cancel=false;
					if (EquipmentPage.equipmentCancelbutton.isDisplayed()) {
						try {
							EquipmentPage.equipmentCancelbutton.click();
						} catch (Exception e) {
							// TODO: handle exception
						}
					} 
				} 
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			if (ActualValidation1.equals("Equipment name already exist")) {
				Validation.allredyExcet(1,Equipment );
				PropertiesCommonMethods.cTestReports("Equipment name already exist Confirm", 1, Validation.allredyexitCount, "");
			}
		}

//				Thread.sleep(1000);
//				AddSbuFunPage.SBUName.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
//				AddSbuFunPage.Des.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
//				Thread.sleep(1000);

	}
	
	public static void exceldata() throws IOException, InterruptedException {

		PageFactory.initElements(driver, equipment);
		boolean pass = false;
		Thread.sleep(1000);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Equipment";
		String testCaseId = "TC-EQU-0047";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Equipment");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(1).getBooleanCellValue();
			Equipment1 = (String) row.getCell(2).getStringCellValue();
			
		}
	}

	public static void deleteEquipmentest() throws InterruptedException {
		PageFactory.initElements(driver, equipment);

		boolean foundEquipment = false;

		while (!foundEquipment) {
			List<WebElement> equipmentsListedonCurrentPage = driver.findElements(
					By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[text()='" + Equipment1 + "']"));
			List<WebElement> disableNextButton = driver.findElements(By.xpath(
					"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[8]/button/span"));

			// System.out.println(equipmentsListedonCurrentPage.size());
			if (equipmentsListedonCurrentPage.size() > 0) {
				foundEquipment = true;
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='" + Equipment1 + "']//following-sibling::td[3]//a[2]"))
						.click();
			} else if (disableNextButton.size() == 0) {
				EquipmentPage.NextPageBtnEq.click();
			}

		}

		// driver.findElement(By.xpath("//td[text()='"+Equipment+"']//following-sibling::td[3]//a[2]")).click();
	}
	
	public static void deleteDependingEquipmentest() throws InterruptedException {
		PageFactory.initElements(driver, equipment);

		boolean foundEquipment = false;

		while (!foundEquipment) {
			List<WebElement> equipmentsListedonCurrentPage = driver.findElements(
					By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[text()='" + Equipment2 + "']"));
			List<WebElement> disableNextButton = driver.findElements(By.xpath(
					"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[8]/button/span"));

			// System.out.println(equipmentsListedonCurrentPage.size());
			if (equipmentsListedonCurrentPage.size() > 0) {
				foundEquipment = true;
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='" + Equipment2 + "']//following-sibling::td[3]//a[2]"))
						.click();
			} else if (disableNextButton.size() == 0) {
				EquipmentPage.NextPageBtnEq.click();
			}

		}

	}

	public static void elementNumberBoeforeSearch() throws InterruptedException {

		PageFactory.initElements(driver, equipment);

	 BeforeCount=	ActionCommonMethod.countDataTable(EquipmentPage.table);
	
	}

	
	public static void checkresetallbutton() throws InterruptedException {

		PageFactory.initElements(driver, equipment);
		PageFactory.initElements(driver, user);

		try {
			if (EquipmentPage.reset1button.isDisplayed()) {

				boolean Acctualtra = EquipmentPage.reset1button.isDisplayed();
				boolean Expectedetra = true;

				UserMainTests.TestCasePrint("RESET BUTTON IS DISPLAYED", Expectedetra, Acctualtra);

				try {
					if (EquipmentPage.reset1button.isEnabled()) {

						boolean Acctualena = EquipmentPage.reset1button.isEnabled();
						boolean Expectedena = true;

						UserMainTests.TestCasePrint("RESET BUTTON IS ENABLE", Expectedena, Acctualena);

					} else {
						testCase = extent.createTest("REST BUTTON IS NOT VISIBLE");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("BUTTON Locator");
					testCase.log(Status.INFO, "Dont Have Image Locator");
					testCase.log(Status.FAIL, " Dont Have Image Locator");
				}

			} else {
				testCase = extent.createTest("RESET BUTTON IS NOT ENABLE");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("BUTTON Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}

	}

	public static void elementNumberAfterSearch() throws InterruptedException {
		PageFactory.initElements(driver, equipment);

		AfterCount=	ActionCommonMethod.countDataTable(EquipmentPage.table);
		

	}

	

	public static void checkresetallbuttondisapper() throws InterruptedException {

		PageFactory.initElements(driver, equipment);
		PageFactory.initElements(driver, user);
		
		boolean actual=false;
		try {
			boolean Acctualtra = EquipmentPage.reset1button.isDisplayed();
			actual=Acctualtra;
		} catch (NoSuchElementException e) {
			actual=false;
		}
		System.out.println("Reset all button status: " + actual);
		boolean Expectedetra = false;

		UserMainTests.TestCasePrint("RESET BUTTON IS NOT DISPLAYED", Expectedetra, actual);

		
	}

	public static void navigateLastpage() throws InterruptedException {

		PageFactory.initElements(driver, equipment);

		boolean clickNextPage = true;
		int BeforeCount = 0;

		ArrayList<String> BeforestringList = new ArrayList<String>();

		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		while (clickNextPage) {

			for (int i = 2; i < 45; i++) {

				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();

					BeforestringList.add(text);
					BeforeCount = BeforeCount + 1;
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
	}

	public static void selectrecord() throws InterruptedException {
		PageFactory.initElements(driver, user);

		//PageFactory.initElements(driver, EmployeePg);
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, SourcePg);

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
			boolean isExist = list.contains(Equipmentlastpage);
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
	
	public static void editElement() throws InterruptedException {
		
		try {

			if (driver.findElement(By.xpath("//td[text()='" + Equipmentlastpage
					+ "']//following-sibling::td[3]//span[@class='anticon anticon-edit']")).isDisplayed()) {

				testCase = extent.createTest("edit Icon Display");
				testCase.log(Status.PASS, "TEST PASS â˜‘");

				if (driver.findElement(By.xpath("//td[text()='" + Equipmentlastpage
						+ "']//following-sibling::td[3]//span[@class='anticon anticon-edit']")).isEnabled()) {
					testCase = extent.createTest("edit Icon Enable");
					testCase.log(Status.PASS, "TEST PASS â˜‘");

					try {
						driver.findElement(By.xpath("//td[text()='" + Equipmentlastpage
								+ "']//following-sibling::td[3]//span[@class='anticon anticon-edit']")).click();

	

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST FAIL â�Ž");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST FAIL â�Ž");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL â�Ž");
		}

	}	
	
public static void editElementlastadded() throws InterruptedException {
		
		try {

			if (driver.findElement(By.xpath("//td[text()='" + EquipmentNew
					+ "']//following-sibling::td[3]//span[@class='anticon anticon-edit']")).isDisplayed()) {

				testCase = extent.createTest("Delete Icon Display");
				testCase.log(Status.PASS, "TEST PASS â˜‘");

				if (driver.findElement(By.xpath("//td[text()='" +EquipmentNew
						+ "']//following-sibling::td[3]//span[@class='anticon anticon-edit']")).isEnabled()) {
					testCase = extent.createTest("Delete Icon Enable");
					testCase.log(Status.PASS, "TEST PASS â˜‘");

					try {
						driver.findElement(By.xpath("//td[text()='" + EquipmentNew
								+ "']//following-sibling::td[3]//span[@class='anticon anticon-edit']")).click();

	

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST FAIL â�Ž");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST FAIL â�Ž");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL â�Ž");
		}

	}	
	
	public static void selectrecordlastadded() throws InterruptedException {
		PageFactory.initElements(driver, user);

		//PageFactory.initElements(driver, EmployeePg);
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, SourcePg);

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
			boolean isExist = list.contains(EquipmentNew);
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

	public static void equipmentContent() throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Data-equipment-material-user.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("EditEquipmentExists");

		int rowcount = sheet.getLastRowNum();
		for (int i = 0; i < 1; i++) {
			XSSFRow row = sheet.getRow(i);

			// boolean check = (boolean) row.getCell(0).getBooleanCellValue();
			Equipment = (String) row.getCell(0).getStringCellValue();
			EquipmentType = (String) row.getCell(1).getStringCellValue();
			Description = (String) row.getCell(2).getStringCellValue();

			System.out.println("equipment1 " + Equipment);
		}
	}

	public static void equipment() throws IOException {

	
		System.out.println("equipment " + Equipment);
		WebElement EditmaterialModal = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]"));

		WebElement input_prifix = EditmaterialModal.findElement(By.id("equipment_name"));
		String Actinputvalue = input_prifix.getAttribute("value");
		System.out.println(Actinputvalue);

		String Expectedvalue = Equipment;

		UserMainTests.TestCasePrint("EQUIPMENT IS SAME", Expectedvalue, Actinputvalue);

	}

	public static void equipmentType() {

		WebElement plantdropdown = driver.findElement(
				By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div/div/div[1]/div/span[2]"));
		String selected_option = plantdropdown.getText();
		System.out.println(selected_option);
		// String selected_value = selected_option.getAttribute("value");

		String Expectedplantdropdown = EquipmentType;

		UserMainTests.TestCasePrint("EQUIPMENT TYPE DROPDOWN SAME ", Expectedplantdropdown, selected_option);
	}

	public static void description() {

		WebElement EditmaterialModal = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]"));

		WebElement input_prifix = EditmaterialModal.findElement(By.id("equipment_description"));
		String Actinputvalue = input_prifix.getAttribute("value");
		System.out.println(Actinputvalue);

		String Expectedvalue = Description;

		UserMainTests.TestCasePrint("DESCRIPTION IS SAME", Expectedvalue, Actinputvalue);

	}

	public static void editdata() throws IOException, InterruptedException {

		PageFactory.initElements(driver, user);
	boolean pass = false;
//		Thread.sleep(1000);
//
//		FileInputStream file = new FileInputStream(
//				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Data-equipment-material-user.xlsx");
//		// C:\Automation_Workspace\QDMS-AUTOMATION\src\test\java\com\invicta\qa\excel\Data.xlsx
//		XSSFWorkbook workbook = new XSSFWorkbook(file);
//		XSSFSheet sheet = workbook.getSheet("EditEquipmentData");
//
//		int rowcount = sheet.getLastRowNum();
//		for (int i = 0; i < 1; i++) {
//			XSSFRow row = sheet.getRow(i);
//
//			boolean check = (boolean) row.getCell(0).getBooleanCellValue();
//			EquipmentNew = (String) row.getCell(1).getStringCellValue();
//			EquipmentTypeNew = (String) row.getCell(2).getStringCellValue();
//			DescriptionNew = (String) row.getCell(3).getStringCellValue();

			if (check) {
				EquipmentPage.equipmenttextbox.sendKeys(Keys.END);
				Thread.sleep(2000);
				int num = 100;
				for (int j = 0; j < num; j++) {
					EquipmentPage.equipmenttextbox.sendKeys(Keys.BACK_SPACE);
				}
				Thread.sleep(2000);

				EquipmentPage.equipmenttextbox.sendKeys(EquipmentNew);
				EquipmentPage.equipmenttypetextbox.click();

				Thread.sleep(5000);
				try {
					if (EquipmentPage.equipmenttypetextbox.isEnabled()) {
						for (int j = 1; j <= 2; j++) {
							WebElement name = driver.findElement(
									By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[" + j + "]"));
							String dropcontent = name.getText();
							if (dropcontent.contentEquals(EquipmentTypeNew)) {
								name.click();
								pass = true;
							} else if (dropcontent.isEmpty()) {
								pass = true;
							}
						}
					}

				} catch (NoSuchElementException e) {
				}

				Thread.sleep(2000);

				EquipmentPage.descriptiontextbox.sendKeys(Keys.END);
				Thread.sleep(2000);
				int num1 = 100;
				for (int k = 0; k < num1; k++) {
					EquipmentPage.descriptiontextbox.sendKeys(Keys.BACK_SPACE);
				}
				Thread.sleep(3000);

				EquipmentPage.descriptiontextbox.sendKeys(DescriptionNew);
				EquipmentPage.equipmentsavebutton.click();

				System.out.println("EquipmentNew1 " + EquipmentNew);
			}

		}
		
	

	public static void editedDataAddedtoLast() {

		PageFactory.initElements(driver, user);
		PageFactory.initElements(driver, equipment);

		// driver.navigate().refresh();

		String actualdata = driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[2]/td[1]")).getText();
		System.out.println("First cell of table : " + actualdata);

		String expecteddata = EquipmentNew;
		System.out.println("EquipmentNew3 " + EquipmentNew);

		UserMainTests.TestCasePrint("CHECK THE LAST ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE", expecteddata,
				actualdata);

	}

	public static void equipmentUpdated() {

		PageFactory.initElements(driver, user);
		PageFactory.initElements(driver, equipment);

		WebElement EditmaterialModal = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]"));

		WebElement input_prifix = EditmaterialModal.findElement(By.id("equipment_name"));
		String Actinputvalue = input_prifix.getAttribute("value");
		System.out.println(Actinputvalue);

		String Expectedvalue = EquipmentNew;

		UserMainTests.TestCasePrint("EQUIPMENT IS SAME AFTER UPDATED", Expectedvalue, Actinputvalue);

	}

	public static void equipmentTypeupdated() {

		WebElement plantdropdown = driver.findElement(
				By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div/div/div[1]/div/span[2]"));
		String selected_option = plantdropdown.getText();
		System.out.println(selected_option);
		// String selected_value = selected_option.getAttribute("value");

		String Expectedplantdropdown = EquipmentTypeNew;

		UserMainTests.TestCasePrint("EQUIPMENT DROPDOWN SAME AFTER UPDATED", Expectedplantdropdown, selected_option);
	}

	public static void descriptionupdated() {

		PageFactory.initElements(driver, user);
		PageFactory.initElements(driver, equipment);

		WebElement EditmaterialModal = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]"));

		WebElement input_prifix = EditmaterialModal.findElement(By.id("equipment_description"));
		String Actinputvalue = input_prifix.getAttribute("value");
		System.out.println(Actinputvalue);

		String Expectedvalue = DescriptionNew;

		UserMainTests.TestCasePrint("DESCRIPTION IS SAME AFTER UPDATED", Expectedvalue, Actinputvalue);

	}

	public static void deleteReport() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		WebDriverWait wait =new WebDriverWait(driver, 3);
		String message=null;
		try {
//			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='ant-notification-notice-message']"))));
		} catch (Exception e) {
			// TODO: handle exception
		}try {
			message = driver.findElement(By.xpath("//div[@class='ant-notification-notice-message']"))
					.getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		driver.navigate().refresh();
		Thread.sleep(1000);
		EquipmentMainTests.elementNumberAfterSearch();
		

		PropertiesCommonMethods.cTestReports("Confirm Message", "Equipment Successfully Deleted", message, "Delete Check");
		
		driver.navigate().refresh();
Thread.sleep(2000);
		
		PropertiesCommonMethods.cTestReports("Confirm Data Not Deleted",  BeforeCount-1 ,AfterCount ,"BEFORE SEARCH AND AFTER SEARCH DATA COUNT");
	
		
	}

	public static void cannotDeleteValidation() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		WebDriverWait wait =new WebDriverWait(driver, 3);
		String message=null;
		try {
//			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='ant-notification-notice-message']"))));
			message = driver.findElement(By.xpath("//div[@class='ant-notification-notice-message']"))
					.getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		

		PropertiesCommonMethods.cTestReports("Confirm Message", "Can't delete this module", message, "Delete Check");
		
		driver.navigate().refresh();
Thread.sleep(2000);
		EquipmentMainTests.elementNumberAfterSearch();
		
		PropertiesCommonMethods.cTestReports("Confirm Data Not Deleted", AfterCount, BeforeCount, "BEFORE SEARCH AND AFTER SEARCH DATA COUNT");
	
		
	}

	public static void deletedrecordAvailable() {

		PageFactory.initElements(driver, user);
		PageFactory.initElements(driver, equipment);

		String act = driver.findElement(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0'][1]/td[1]"))
				.getText();
		String exp = Equipment2;

		UserMainTests.TestCasePrint("VALUE IS AVAIABLE", exp, act);

	}

	public static void SampleEquipment() throws IOException, InterruptedException {

		PageFactory.initElements(driver, equipment);


		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Equipment";
		String testCaseId = "TC-EQU-0053";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Equipment");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			SamEquipment = (String) row.getCell(1).getStringCellValue();

			System.out.println("equipment to be passed1" + SamEquipment);
		}
		System.out.println("equipment to be passed" + SamEquipment);
	}

//******************CHECK THE PROPERTIES OF THE ADD EQUIPMENT BUTTON******************	

	public static void addequipmentbutton() { 
	WebDriverWait wait = new WebDriverWait(driver, 10);
		
		try {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(EquipmentPage.addequipmentbutton));
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (EquipmentPage.addequipmentbutton.isDisplayed()) {

				// button Displayed

				boolean ActualbiuttonDisplay = EquipmentPage.addequipmentbutton.isDisplayed();
				boolean ExpectedbuttonDisplay = true;
				UserMainTests.TestCasePrint("ADD-EQUIPMENT-BUTTON-DISPLAYED", ExpectedbuttonDisplay, ActualbiuttonDisplay);

				try {
					if (EquipmentPage.addequipmentbutton.isEnabled()) {

						// button enabled

						boolean ActualImageDisplay = EquipmentPage.addequipmentbutton.isEnabled();
						boolean ExpectedImageDisplay = true;
						UserMainTests.TestCasePrint("ADD-EQUIPMENT-BUTTON-ENABLED", ExpectedImageDisplay, ActualImageDisplay);
						
					} else {
						testCase = extent.createTest("ADD-EQUIPMENT-BUTTON-NOT-ENABLED");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("BUTTON Locator");
					testCase.log(Status.INFO, "Dont Have Image Locator");
					testCase.log(Status.FAIL, " Dont Have Image Locator");
				}

			} else {
				testCase = extent.createTest("ADD-EQUIPMENT-BUTTON-NOT-DISPLAYED");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("BUTTON Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}
	}
	//******************CHECK THE PROPERTIES OF DELETE CONFIRMATION OK  BUTTON******************	

		
		public static void exceldatadepending() throws IOException, InterruptedException {

			PlantEquipmentAddMethods.dataFromPlanEqupment("Equipment", "TC-EQU-0051-01");
			Equipment2=PlantEquipmentAddMethods.equipData.get(0);
	
			
		}
		public static void exceldelete() {
			


			PlantEquipmentAddMethods.dataFromPlanEqupment("Equipment", "TC-EQU-0047-01");
			Equipment2=PlantEquipmentAddMethods.equipData.get(0);
	
			
		
		}
		
		
		
		public static void deleteElementdepending() throws InterruptedException {
			PageFactory.initElements(driver, equipment);
			driver.navigate().refresh();
			Thread.sleep(2000);
			SelectDate.click(0, 3, EquipmentPage.table, "delete",Equipment2);
			ActionCommonMethod.clicking(EquipmentPage.deleteconfirmationOKbutton, "Delete ok Button");

		}
		public static void middleElementClick() throws InterruptedException {

			//PageFactory.initElements(driver, EmployeePg);
			PageFactory.initElements(driver, page);
			PageFactory.initElements(driver, SourcePg);

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
				boolean isExist = list.contains(Equipment1);
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
		
		public static void deleteElement() throws InterruptedException {
			
			try {

				if (driver.findElement(By.xpath("//td[text()='" + Equipment1
						+ "']//following-sibling::td[3]//span[@class='anticon anticon-delete']")).isDisplayed()) {

					testCase = extent.createTest("Delete Icon Display");
					testCase.log(Status.PASS, "TEST PASS â˜‘");

					if (driver.findElement(By.xpath("//td[text()='" + Equipment1
							+ "']//following-sibling::td[3]//span[@class='anticon anticon-delete']")).isEnabled()) {
						testCase = extent.createTest("Delete Icon Enable");
						testCase.log(Status.PASS, "TEST PASS â˜‘");

						try {
							driver.findElement(By.xpath("//td[text()='" + Equipment1
									+ "']//following-sibling::td[3]//span[@class='anticon anticon-delete']")).click();

		

						} catch (Exception e) {

						}

					} else {
						testCase = extent.createTest("Element is not enable");
						testCase.log(Status.PASS, "TEST FAIL â�Ž");
					}
				} else {
					testCase = extent.createTest("Element is not display");
					testCase.log(Status.PASS, "TEST FAIL â�Ž");

				}
			} catch (Exception e) {
				testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
				testCase.log(Status.FAIL, "TEST FAIL â�Ž");
			}

		}	
		
		

		public static void excel54() throws InterruptedException, IOException {

			PageFactory.initElements(driver, equipment);
			boolean pass = false;
			Thread.sleep(1000);

			String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
			String excelSheetName = "Equipment";
			String testCaseId = "TC-EQU-0054";

			int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
			int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Equipment");

			for (int i = firstRow; i <= lastRow; i++) {
				XSSFRow row = sheet.getRow(i);

				 check = (boolean) row.getCell(1).getBooleanCellValue();
				Equipmentlastpage = (String) row.getCell(2).getStringCellValue();
				Equipment = (String) row.getCell(3).getStringCellValue();
				EquipmentType = (String) row.getCell(4).getStringCellValue();
				Description = (String) row.getCell(5).getStringCellValue();
				EquipmentNew = (String) row.getCell(6).getStringCellValue();
				EquipmentTypeNew = (String) row.getCell(7).getStringCellValue();
			DescriptionNew = (String) row.getCell(8).getStringCellValue();
				
			}	
	}
}