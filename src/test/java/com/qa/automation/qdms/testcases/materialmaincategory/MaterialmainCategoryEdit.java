/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking edit Material Main Category validation Functionality
******************************************************************************************************************
*
* @author 	 : 	Kajenthiran Yogalingam
* 
* ======================================================================================================
* 	Test Case Number 	 ||  	Date      ||      Intis     ||   Comments
* ================================================================================================================
*  	 TC-MATMC-0046    	    				      Kajan		   Modified version (Rework)		      
******************************************************************************************************************/


package com.qa.automation.qdms.testcases.materialmaincategory;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.pages.master.MaterialMainCategoryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class MaterialmainCategoryEdit extends DriverIntialization{


	static MaterialMainCategoryPage pg = new MaterialMainCategoryPage();
	@Test
	public static void materialmaincategoryeditvalidation() throws InterruptedException {
		PageFactory.initElements(driver, pg);
		String mainCategory1=null;
		String prefix1=null;
		String MAINtype1=null;
		String mainCategory2=null;
		String prefix2=null;
		String MAINtype2=null;
		boolean depend=false;
		boolean ed=false;
		// get data from excel

		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		XSSFWorkbook wbook = null;
		String filelocation;

		try {
			filelocation = "./src/test/resources/Excel/Master Module.xlsx";
			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			fileIn.close();

			PropertiesCommonMethods.excalRowCount("Master Module.xlsx", "Material Main Category", "TC-MATMC-0046-01");
			XSSFSheet sheet = wbook.getSheet("Material Main Category");
			int r = PropertiesCommonMethods.countRow - 1;
			row = sheet.getRow(r);
			cell = row.getCell(2);
			mainCategory1 = dataValue.formatCellValue(cell);
			cell = row.getCell(3);
			prefix1 = dataValue.formatCellValue(cell);
			cell = row.getCell(4);
			MAINtype1 = dataValue.formatCellValue(cell);
			cell = row.getCell(5);
			String MAINty = dataValue.formatCellValue(cell);
			depend=Boolean.valueOf(MAINty);
			
			
			cell = row.getCell(6);
			mainCategory2 = dataValue.formatCellValue(cell);
			cell = row.getCell(7);
			prefix2 = dataValue.formatCellValue(cell);
			cell = row.getCell(8);
			MAINtype2 = dataValue.formatCellValue(cell);
			/*********************************************************************************************/
			

			testCase = extent.createTest("TC-MATMC-0037 -- ADD MATERIAL MAIN CATEGORY FUNCTIONALITY");
			LoginTest.Login();
			
				if (LoginTest.login) {
					MasterMainNavigationsTest.navigateMaster();
				}
				if (MasterMainNavigationsTest.clickMaster) {
					MasterMainNavigationsTest.clickMaster=false;
					MasterMainNavigationsTest.navigateMaterialMain();
				}
				
				if (MasterMainNavigationsTest.clickMaterialMain) {
					MasterMainNavigationsTest.clickMaterialMain=false;
					MasterMainNavigationsTest.navigateMaterialMainCategory();
				}
				
//				if (MasterMainNavigationsTest.matmaincat) {
//					materialMethodes.click(MaterialMainCategoryPage.addmainmaterialbtn, "ADD MATERIAL");
//				}
				materialMethodes.iconclick( "1",mainCategory1 , "edit");
				materialMethodes.popupdatacompare(mainCategory1+","+prefix1+","+MAINtype1);
				if (materialMethodes.edit) {
					
				
				if (!mainCategory2.equals(mainCategory1)&& !depend) {
					ed=true;
					
					materialMethodes.sendkey(MaterialMainCategoryPage.maincatTextbox, mainCategory2, "MAIN CATEGORY TEXT BOX");
				}
				if (!prefix2.equals(prefix1)&& !depend) {
					ed=true;
					materialMethodes.sendkey(MaterialMainCategoryPage.prefixTextbox, prefix2, "PREFIX TEXT BOX");
				}
				if (!MAINtype2.equals(MAINtype1)&& !depend) {
					ed=true;
					materialMethodes.nordropdown(MaterialMainCategoryPage.maintypeDropdown,"//div[contains(text(),'",MAINtype2,"')]//..//div[@class='ant-select-item-option-content']", "main Type dropdown");
				}
				}
				if (ed) {
					materialMethodes.popupdatacompare(mainCategory2+","+prefix2+","+MAINtype2);
					materialMethodes.drop=false;
					materialMethodes.click(MaterialMainCategoryPage.savebtn, "SAVE");
				}else {
					testCase = extent.createTest("CHECKING THE EDITED DATA");
					testCase.log(Status.INFO, "DO NOT ANY CHANGES IS THERE");
					testCase.log(Status.INFO, "CHECK EXCEL DATA");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
					
				}
				
				
				if (materialMethodes.click&&ed) {
						materialMethodes.click=false;
						materialMethodes.popupcheck(driver.findElement(By.xpath("//div[@class='ant-modal-body']")), "ADD POPUP");
						
					}
				if (materialMethodes.pop&&ed) {

					
					materialMethodes.datacheckinfirstrow("1,2,3", 2,mainCategory2+","+prefix2+","+MAINtype2, "edit MATERIAL MAIN CATEGORY");
					
				}
				if (!materialMethodes.pop&&ed) {
					
					materialMethodes.validation();
					materialMethodes.validationconfirm("", "", "material main category");
				}

				//	REFRESH
		          driver.navigate().refresh();
		          Thread.sleep(1000);	
				

			} catch (Exception e) {
//	          REFRESH
		          driver.navigate().refresh();
		          Thread.sleep(1000);
			}
		Logout.LogoutFunction();
	
		
	}



	
	

}
