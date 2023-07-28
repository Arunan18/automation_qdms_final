/***********************************************************************************
* Description
*------------
* Project Multiple Search Functionality
***********************************************************************************
*
* Author           : Suntharalingam Arunan
* Date Written     : 01/03/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
* TC-PRO-0086          01/03/2023     Arunan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testcases.project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.ProjectPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class ProjectMultiSearchTest extends DriverIntialization {
	ProjectPage pp = new ProjectPage();
	boolean CodeTableData = true;
	boolean PlantTableData = true;
	boolean ProjectTableData = true;
	boolean CustomerTableData = true;
	boolean ContactPersonTableData = true;
	boolean ContactNoTableData = true;
	boolean StartDateTableData = true;

	@Test
	public void projectMultiSearch() throws InterruptedException, IOException {
		PageFactory.initElements(driver, pp);
		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Project",
				"TC-PRO-0086");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Project",
				"TC-PRO-0086");
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Project");
		for (int i = firstrow; i <= lastrow; i++) { 
			XSSFRow row = sheet.getRow(i);

			int code = (int) row.getCell(11).getNumericCellValue();
			int Plant = (int) row.getCell(12).getNumericCellValue();
			int project = (int) row.getCell(13).getNumericCellValue();
			int customer = (int) row.getCell(14).getNumericCellValue();
			int contactPerson = (int) row.getCell(15).getNumericCellValue();
			int contactNo = (int) row.getCell(16).getNumericCellValue();
			int startDate = (int) row.getCell(17).getNumericCellValue();

			LoginTest.Login();

			MasterMainNavigationsTest.navigateMaster();

			MasterMainNavigationsTest.navigateCustomerMain();

			MasterMainNavigationsTest.navigateProject();

//		STEP 1 : Project - Code Search Button Properties
			MultiSearchMethods.checkSearch(ProjectPage.CodeSearch, "STEP 1 : Project - Code");

//		STEP 2 : Project - Code Search Icon Click
			MultiSearchMethods.ClickSearch(ProjectPage.CodeSearch, ProjectPage.SearchTextBox,
					"STEP 2 : Project - Code");

//		STEP 3 : Project - Code Search Text Box Properties
			MultiSearchMethods.SearchTextBox(ProjectPage.SearchTextBox, "STEP 3 : Project - Code");

//		STEP 4 : Project - Code Search Button Properties
			MultiSearchMethods.SearchButton(ProjectPage.SearchBtn, "STEP 4 : Project - Code");

//		STEP 5 : Project - Code Search Data Input 
			MultiSearchMethods.inputDataSearch("TC-PRO-0086", ProjectPage.SearchTextBox, "STEP 5 : Project - Code",
					"Project", 1, ProjectPage.CodeColumn);

//		STEP 6 : Project - Code Search Button Click
			MultiSearchMethods.SearchButtonClick(ProjectPage.SearchBtn, ProjectPage.ResetAll,
					"STEP 6 : Project - Code");

//		STEP 7 : Project - Code Single Search Function
			MultiSearchMethods.checkAfterSearchData(ProjectPage.CodeColumn, ProjectPage.CodeColumnBefore,
					ProjectPage.CodeColumnAfter, "STEP 7 : Project - Code", code, CodeTableData);

//		STEP 8 : Project - Plant Search Button Properties
			MultiSearchMethods.checkSearch(ProjectPage.PlantSearch, "STEP 8 : Project - Plant");

//		STEP 9 : Project - Plant Search Icon Click
			MultiSearchMethods.ClickSearch(ProjectPage.PlantSearch, ProjectPage.SearchTextBox,
					"STEP 9 : Project - Plant");

//		STEP 10 : Project - Plant Search Text Box Properties
			MultiSearchMethods.SearchTextBox(ProjectPage.SearchTextBox, "STEP 10 : Project - Plant");

//		STEP 11 : Project - Plant Search Button Properties
			MultiSearchMethods.SearchButton(ProjectPage.SearchBtn, "STEP 11 : Project - Plant");

//		STEP 12 : Project - Plant Search Data Input
			MultiSearchMethods.inputDataSearch("TC-PRO-0086", ProjectPage.SearchTextBox, "STEP 12 : Project - Plant",
					"Project", 2, ProjectPage.PlantColumn);

//		STEP 13 : Project - Plant Search Button Click
			MultiSearchMethods.SearchButtonClick(ProjectPage.SearchBtn, ProjectPage.ResetAll,
					"STEP 13 : Project - Plant");

//		STEP 14 : Project - Plant Single Search Function
			MultiSearchMethods.checkAfterSearchData(ProjectPage.PlantColumn, ProjectPage.PlantColumnBefore,
					ProjectPage.PlantColumnAfter, "STEP 14 : Project - Plant", Plant, PlantTableData);

//		STEP 15 : Project - Project Search Button Properties
			MultiSearchMethods.checkSearch(ProjectPage.ProjectSearch, "STEP 15 : Project - Project");

//		STEP 16 : Project - Project Search Icon Click
			MultiSearchMethods.ClickSearch(ProjectPage.ProjectSearch, ProjectPage.SearchTextBox,
					"STEP 16 : Project - Project");

//		STEP 17 : Project - Project Search Text Box Properties 
			MultiSearchMethods.SearchTextBox(ProjectPage.SearchTextBox, "STEP 17 : Project - Project");

//		STEP 18 : Project - Project Search Button Properties
			MultiSearchMethods.SearchButton(ProjectPage.SearchBtn, "STEP 18 : Project - Project");

//		STEP 19 : Project - Project Search Data Input
			MultiSearchMethods.inputDataSearch("TC-PRO-0086", ProjectPage.SearchTextBox, "STEP 19 : Project - Project",
					"Project", 3, ProjectPage.ProjectColumn);

//		STEP 20 : Project - Project Search Button Click
			MultiSearchMethods.SearchButtonClick(ProjectPage.SearchBtn, ProjectPage.ResetAll,
					"STEP 20 : Project - Project");

//		STEP 21 : Project - Project Single Search Function
			MultiSearchMethods.checkAfterSearchData(ProjectPage.ProjectColumn, ProjectPage.ProjectColumnBefore,
					ProjectPage.ProjectColumnAfter, "STEP 21 : Project - Project", project, ProjectTableData);

//		STEP 22 : Project - Customer Search Button Properties
			MultiSearchMethods.checkSearch(ProjectPage.CustomerSearch, "STEP 22 : Project - Customer");

//		STEP 23 : Project - Customer Search Icon Click
			MultiSearchMethods.ClickSearch(ProjectPage.CustomerSearch, ProjectPage.SearchTextBox,
					"STEP 23 : Project - Customer");

//		STEP 24 : Project - Customer Search Text Box Properties
			MultiSearchMethods.SearchTextBox(ProjectPage.SearchTextBox, "STEP 24 : Project - Customer");

//		STEP 25 : Project - Customer Search Button Properties
			MultiSearchMethods.SearchButton(ProjectPage.SearchBtn, "STEP 25 : Project - Customer");

//		STEP 26 : Project - Customer Search Data Input
			MultiSearchMethods.inputDataSearch("TC-PRO-0086", ProjectPage.SearchTextBox, "STEP 26 : Project - Customer",
					"Project", 4, ProjectPage.CustomerColumn);

//		STEP 27 : Project - Customer Search Button Click
			MultiSearchMethods.SearchButtonClick(ProjectPage.SearchBtn, ProjectPage.ResetAll,
					"STEP 27 : Project - Customer");

//		STEP 28 : Project - Customer Single Search Function
			MultiSearchMethods.checkAfterSearchData(ProjectPage.CustomerColumn, ProjectPage.CustomerColumnBefore,
					ProjectPage.CustomerColumnAfter, "STEP 28 : Project - Customer", customer, CustomerTableData);

//		STEP 29 : Project - Contact Person Search Button Properties
			MultiSearchMethods.checkSearch(ProjectPage.ContactPersonSearch, "STEP 29 : Project - Contact Person");

//		STEP 30 : Project - Contact Person Search Icon Click
			MultiSearchMethods.ClickSearch(ProjectPage.ContactPersonSearch, ProjectPage.SearchTextBox,
					"STEP 30 : Project - Contact Person");

//		STEP 31 : Project - Contact Person Search Text Box Properties
			MultiSearchMethods.SearchTextBox(ProjectPage.SearchTextBox, "STEP 31 : Project - Contact Person");

//		STEP 32 : Project - Contact Person Search Button Properties
			MultiSearchMethods.SearchButton(ProjectPage.SearchBtn, "STEP 32 : Project - Contact Person");

//		STEP 33 : Project - Contact Person Search Data Input
			MultiSearchMethods.inputDataSearch("TC-PRO-0086", ProjectPage.SearchTextBox,
					"STEP 33 : Project - Contact Person", "Project", 5, ProjectPage.ContactPersonColumn);

//		STEP 34 : Project - Contact Person Search Button Click
			MultiSearchMethods.SearchButtonClick(ProjectPage.SearchBtn, ProjectPage.ResetAll,
					"STEP 34 : Project - Contact Person");

//		STEP 35 : Project - Contact Person Single Search Function
			MultiSearchMethods.checkAfterSearchData(ProjectPage.ContactPersonColumn,
					ProjectPage.ContactPersonColumnBefore, ProjectPage.ContactPersonColumnAfter,
					"STEP 35 : Project - Contact Person", contactPerson, ContactPersonTableData);

//		STEP 36 : Project - Contact No Search Button Properties
			MultiSearchMethods.checkSearch(ProjectPage.ContactNoSearch, "STEP 36 : Project - Contact No");

//		STEP 37 : Project - Contact No Search Icon Click
			MultiSearchMethods.ClickSearch(ProjectPage.ContactNoSearch, ProjectPage.SearchTextBox,
					"STEP 37 : Project - Contact No");

//		STEP 38 : Project - Contact No Search Text Box Properties
			MultiSearchMethods.SearchTextBox(ProjectPage.SearchTextBox, "STEP 38 : Project - Contact No");

//		STEP 39 : Project - Contact No Search Button Properties
			MultiSearchMethods.SearchButton(ProjectPage.SearchBtn, "STEP 39 : Project - Contact No");

//		STEP 40 : Project - Contact No Search Data Input
			MultiSearchMethods.inputDataSearch("TC-PRO-0086", ProjectPage.SearchTextBox,
					"STEP 40 : Project - Contact No", "Project", 6, ProjectPage.ContactNoColumn);

//		STEP 41 : Project - Contact No Search Button Click
			MultiSearchMethods.SearchButtonClick(ProjectPage.SearchBtn, ProjectPage.ResetAll,
					"STEP 41 : Project - Contact No");

//		STEP 42 : Project - Contact No Single Search Function
			MultiSearchMethods.checkAfterSearchData(ProjectPage.ContactNoColumn, ProjectPage.ContactNoColumnBefore,
					ProjectPage.ContactNoColumnAfter, "STEP 42 : Project - Contact No", contactNo, ContactNoTableData);

//		STEP 43 : Project - Date Search Button Properties
			MultiSearchMethods.checkSearch(ProjectPage.DateSearch, "STEP 43 : Project - Date");

//		STEP 44 : Project - Date Search Icon Click
			MultiSearchMethods.ClickSearch(ProjectPage.DateSearch, ProjectPage.SearchTextBox,
					"STEP 44 : Project - Date");

//		STEP 45 : Project - Date Search Text Box Properties
			MultiSearchMethods.SearchTextBox(ProjectPage.SearchTextBox, "STEP 45 : Project - Date");

//		STEP 46 : Project - Date Search Button Properties
			MultiSearchMethods.SearchButton(ProjectPage.SearchBtn, "STEP 46 : Project - Date");

//		STEP 47 : Project - Date Search Data Input
			MultiSearchMethods.inputDataSearch("TC-PRO-0086", ProjectPage.SearchTextBox, "STEP 47 : Project - Date",
					"Project", 7, ProjectPage.DateColumn);

//		STEP 48 : Project - Date Search Button Click
			MultiSearchMethods.SearchButtonClick(ProjectPage.SearchBtn, ProjectPage.ResetAll,
					"STEP 48 : Project - Date");

//		STEP 49 : Project - Date Single Search Function
			MultiSearchMethods.checkAfterSearchData(ProjectPage.DateColumn, ProjectPage.DateColumnBefore,
					ProjectPage.DateColumnAfter, "STEP 49 : Project - Date", startDate, StartDateTableData);

//		STEP 50 : Project Multi Search (Check Correct Data Count Filter) ☑ 
			MultiSearchMethods.MultipleSearch("STEP 43 : Project");

			MultiSearchMethods.Logout();
		}

	}
}