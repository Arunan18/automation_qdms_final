package com.qa.automation.qdms.sample.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;

public class SampleMultisearchMethods extends DriverIntialization {

	static boolean pass = true;

	/**
	 * 
	 * @param SearchIcon
	 * @param SearchTextBox
	 * @param SearchButton
	 * @param SearchName
	 * @param ExcelWorkbookName
	 * @param ExcelTabName
	 * @param TestcaseId
	 * @param SearchDataColumnNo
	 * @param searchedDataCountColumnNo
	 * @param SearchedData
	 * @param SearchedDataBefore
	 * @param SearchedDataAfter
	 * @param TableData
	 * @throws IOException
	 * @throws InterruptedException
	 */

	public static void multiSearch(WebElement SearchIcon, WebElement SearchTextBox, WebElement SearchButton,
			String SearchName, String ExcelWorkbookName, String ExcelTabName, String TestcaseId, int SearchDataColumnNo,
			int searchedDataCountColumnNo, List<WebElement> SearchedDataColumn, String SearchedDataBefore,
			String SearchedDataAfter, boolean TableData) throws IOException, InterruptedException {
		boolean searchIconVisible = false;
		boolean searchIconEnable = false;
		boolean searchIconClick = false;
		boolean textBoxVisible = false;
		boolean textBoxEnable = false;
		boolean dataEntered = false;
		boolean searchBtnVisible = false;
		boolean searchBtnEnable = false;
		boolean searchBtnClick = false;
		String searchValue = null;
		int searchedDataCount = 0;
		int totalCount = 0;

//		Search Icon Properties
		try {
			SearchIcon.isDisplayed(); 
			searchIconVisible = true;
		} catch (NoSuchElementException e) {
			searchIconVisible = false;
			CommonMethods.TestCasePrint(SearchName + " Search Icon Not Visibled");
		}

		if (searchIconVisible) {
			SearchIcon.isEnabled();
			searchIconEnable = true;
		} else {
			searchIconEnable = false;
			CommonMethods.TestCasePrint(SearchName + " Search Icon Not Enabled");
		}

//		Search Icon CLick
		if (searchIconVisible && searchIconEnable) {
			SearchIcon.click();
			searchIconClick = true;

		} else {
			CommonMethods.TestCasePrint(SearchName + " Search Icon Not Visibled or Enabled");
		}
//		Search Text Box Properties
		if (searchIconClick) {

			try {
				Thread.sleep(1000);
				SearchTextBox.isDisplayed();
				textBoxVisible = true;
			} catch (NoSuchElementException e) {
				textBoxVisible = false;
				CommonMethods.TestCasePrint(SearchName + " Search Icon Not Visibled");
			}

			if (textBoxVisible) {
				SearchTextBox.isEnabled();
				textBoxEnable = true;
			} else {
				textBoxEnable = false;
				CommonMethods.TestCasePrint(SearchName + " Search Icon Not Enabled");
			}

		} else {
			CommonMethods.TestCasePrint(SearchName + " Search Icon Not Clicked");
		}

//		Data Input
		if (textBoxVisible && textBoxEnable) {
			String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + ExcelWorkbookName
					+ ".xlsx";
			int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
			int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(ExcelTabName);
			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);

				searchValue = (String) row.getCell(SearchDataColumnNo).getStringCellValue();
				searchedDataCount = (int) row.getCell(searchedDataCountColumnNo).getNumericCellValue();

				SearchTextBox.sendKeys(searchValue);
				dataEntered = true;
			}

		} else {
			CommonMethods.TestCasePrint(SearchName + " Search TextBox Not Visibled or Enabled");
		}

//		Search Button Properties
		if (dataEntered) {
			try {
				SearchButton.isDisplayed();
				searchBtnVisible = true;
			} catch (NoSuchElementException e) {
				searchBtnVisible = false;
				CommonMethods.TestCasePrint(SearchName + " Search Icon Not Visibled");
			}

			if (searchBtnVisible) {
				SearchButton.isEnabled();
				searchBtnEnable = true;
			} else {
				searchBtnEnable = false;
				CommonMethods.TestCasePrint(SearchName + " Search Icon Not Enabled");
			}

		} else {
			CommonMethods.TestCasePrint("Search Data Not Entered in textBox");
		}

//		Search Button Click
		if (searchBtnVisible && searchBtnEnable) {
			Thread.sleep(1000);
			SearchButton.click();
			searchBtnClick = true;
			
		} else {
			CommonMethods.TestCasePrint(SearchName + " Search Button Not Visibled or Enabled");
		}

//		Check data after search Button Click
		if (searchBtnClick) {
			Thread.sleep(1500);
			int rowcount = SearchedDataColumn.size();
			if (rowcount == 1) {
				totalCount = 0;
				System.out.println("!!!!!!!!!!!!!!!!!!!!!");
			} else if (rowcount > 1) {
				Thread.sleep(500);
				boolean nextBtnEnable = true;
				while (nextBtnEnable) {
					Thread.sleep(2000);
					int row = SearchedDataColumn.size();
					System.out.println(row);
					Thread.sleep(1500);
					for (int i = 2; i <= row; i++) {
						Thread.sleep(500);
						WebElement searchedDataXpath = driver
								.findElement(By.xpath(SearchedDataBefore + i + SearchedDataAfter));
						String FilteredData = searchedDataXpath.getText();
						Thread.sleep(500);
						if (FilteredData.contains(searchValue)) {
							totalCount = totalCount + 1;
						}
						if (!FilteredData.contains(searchValue)) {
//							Check Wrong data filter or not 
							TableData = false;
						}
					}
					try {
						WebElement nextButton = driver
								.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"));
						nextBtnEnable = nextButton.isEnabled();
						if (nextBtnEnable) {
							nextButton.click();
						}
					} catch (NoSuchElementException e) {
						CommonMethods.TestCasePrint("Dont Have Pagination Next Button");
					}
				}
			}

		} else {
			CommonMethods.TestCasePrint(SearchName + " Search Button Not Clicked");
		}

//		Single Search Function
		boolean check = true;
		System.out.println(totalCount + "****************" + searchedDataCount);
		System.out.println(TableData);
		try {
			Assert.assertEquals(totalCount, searchedDataCount);
			check = true;
		} catch (AssertionError e) {
			check = false;
		}
		if (check && TableData) {
			testCase = extent.createTest(SearchName + " Single Search Function");
			testCase.log(Status.INFO, SearchName + " Single Search Work Correctly");
			testCase.log(Status.PASS, SearchName + " Single Search Work Correctly");
		} else {
			pass = false;
			testCase = extent.createTest(SearchName + " Single Search Function");
			testCase.log(Status.INFO, SearchName + " Single Search Work Wrongly");
			testCase.log(Status.FAIL, SearchName + " Single Search Work Wrongly");
		}
	}

	
	
	/**
	 * 
	 * @param SearchName
	 */
	public static void MultipleSearch(String SearchName) {
		if (pass) {
			testCase = extent.createTest(SearchName + " Multi Search (Check Correct Data Count Filter) ☑");
			testCase.log(Status.INFO, "Correct Data Count Filtered");
			testCase.log(Status.PASS, "Correct Data Count Filtered");
		} else {
			testCase = extent.createTest(SearchName + " Multi Search (Check Correct Data Count Filter) ✘");
			testCase.log(Status.INFO, "Wrong Data Count Filtered");
			testCase.log(Status.FAIL, "Wrong Data Count Filtered");
		}
	}
	
	public static void multiSearchNew(WebElement SearchIcon, WebElement SearchTextBox, WebElement SearchButton,
			String SearchName, String ExcelWorkbookName, String ExcelTabName, String TestcaseId, int SearchDataColumnNo,
			int searchedDataCountColumnNo, List<WebElement> SearchedDataColumn, String SearchedDataBefore,
			String SearchedDataAfter, boolean TableData) throws IOException, InterruptedException {
		boolean searchIconVisible = false;
		boolean searchIconEnable = false;
		boolean searchIconClick = false;
		boolean textBoxVisible = false;
		boolean textBoxEnable = false;
		boolean dataEntered = false;
		boolean searchBtnVisible = false;
		boolean searchBtnEnable = false;
		boolean searchBtnClick = false;
		String searchValue = null;
		int searchedDataCount = 0;
		int totalCount = 0;

//		Search Icon Properties
		try {
			SearchIcon.isDisplayed(); 
			searchIconVisible = true;
		} catch (NoSuchElementException e) {
			searchIconVisible = false;
			CommonMethods.TestCasePrint(SearchName + " Search Icon Not Visibled");
		}

		if (searchIconVisible) {
			SearchIcon.isEnabled();
			searchIconEnable = true;
		} else {
			searchIconEnable = false;
			CommonMethods.TestCasePrint(SearchName + " Search Icon Not Enabled");
		}

//		Search Icon CLick
		if (searchIconVisible && searchIconEnable) {
			SearchIcon.click();
			searchIconClick = true;

		} else {
			CommonMethods.TestCasePrint(SearchName + " Search Icon Not Visibled or Enabled");
		}
//		Search Text Box Properties
		if (searchIconClick) {

			try {
				Thread.sleep(1000);
				SearchTextBox.isDisplayed();
				textBoxVisible = true;
			} catch (NoSuchElementException e) {
				textBoxVisible = false;
				CommonMethods.TestCasePrint(SearchName + " Search Icon Not Visibled");
			}

			if (textBoxVisible) {
				SearchTextBox.isEnabled();
				textBoxEnable = true;
			} else {
				textBoxEnable = false;
				CommonMethods.TestCasePrint(SearchName + " Search Icon Not Enabled");
			}

		} else {
			CommonMethods.TestCasePrint(SearchName + " Search Icon Not Clicked");
		}

//		Data Input
		if (textBoxVisible && textBoxEnable) {
			String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + ExcelWorkbookName
					+ ".xlsx";
			int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
			int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(ExcelTabName);
			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);

				searchValue = (String) row.getCell(SearchDataColumnNo).getStringCellValue();
				searchedDataCount = (int) row.getCell(searchedDataCountColumnNo).getNumericCellValue();

				SearchTextBox.sendKeys(searchValue);
				dataEntered = true;
			}

		} else {
			CommonMethods.TestCasePrint(SearchName + " Search TextBox Not Visibled or Enabled");
		}

//		Search Button Properties
		if (dataEntered) {
			try {
				SearchButton.isDisplayed();
				searchBtnVisible = true;
			} catch (NoSuchElementException e) {
				searchBtnVisible = false;
				CommonMethods.TestCasePrint(SearchName + " Search Icon Not Visibled");
			}

			if (searchBtnVisible) {
				SearchButton.isEnabled();
				searchBtnEnable = true;
			} else {
				searchBtnEnable = false;
				CommonMethods.TestCasePrint(SearchName + " Search Icon Not Enabled");
			}

		} else {
			CommonMethods.TestCasePrint("Search Data Not Entered in textBox");
		}

//		Search Button Click
		if (searchBtnVisible && searchBtnEnable) {
			Thread.sleep(1000);
			SearchButton.click();
			searchBtnClick = true;
			
		} else {
			CommonMethods.TestCasePrint(SearchName + " Search Button Not Visibled or Enabled");
		}

//		Check data after search Button Click
		if (searchBtnClick) {
			Thread.sleep(1500);
			int rowcount = SearchedDataColumn.size();
			if (rowcount == 0) {
				totalCount = 0;
				System.out.println("!!!!!!!!!!!!!!!!!!!!!");
			} else if (rowcount >= 1) {
				Thread.sleep(500);
				boolean nextBtnEnable = true;
				while (nextBtnEnable) {
					Thread.sleep(2000);
					int row = SearchedDataColumn.size();
					System.out.println(row);
					Thread.sleep(1500);
					for (int i = 1; i <= row; i++) {
						Thread.sleep(500);
						WebElement searchedDataXpath = driver
								.findElement(By.xpath(SearchedDataBefore + i + SearchedDataAfter));
						String FilteredData = searchedDataXpath.getText();
						Thread.sleep(500);
						if (FilteredData.contains(searchValue)) {
							totalCount = totalCount + 1;
						}
						if (!FilteredData.contains(searchValue)) {
//							Check Wrong data filter or not 
							TableData = false;
						}
					}
					try {
						WebElement nextButton = driver
								.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"));
						nextBtnEnable = nextButton.isEnabled();
						if (nextBtnEnable) {
							nextButton.click();
						}
					} catch (NoSuchElementException e) {
						CommonMethods.TestCasePrint("Dont Have Pagination Next Button");
					}
				}
			}

		} else {
			CommonMethods.TestCasePrint(SearchName + " Search Button Not Clicked");
		}

//		Single Search Function
		boolean check = true;
		System.out.println(totalCount + "****************" + searchedDataCount);
		System.out.println(TableData);
		try {
			Assert.assertEquals(totalCount, searchedDataCount);
			check = true;
		} catch (AssertionError e) {
			check = false;
		}
		if (check && TableData) {
			testCase = extent.createTest(SearchName + " Single Search Function");
			testCase.log(Status.INFO, SearchName + " Single Search Work Correctly");
			testCase.log(Status.PASS, SearchName + " Single Search Work Correctly");
		} else {
			pass = false;
			testCase = extent.createTest(SearchName + " Single Search Function");
			testCase.log(Status.INFO, SearchName + " Single Search Work Wrongly");
			testCase.log(Status.FAIL, SearchName + " Single Search Work Wrongly");
		}
	}

}
