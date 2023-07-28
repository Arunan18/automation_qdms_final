/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking Add Material Main Category Functionality
******************************************************************************************************************
*
* @author 	 : 	Kajenthiran Yogalinkam
* 
* ======================================================================================================
* 	Test Case Number 	 ||  	Date      ||      Intis     ||   Comments
* ================================================================================================================
*  	 TC-MATMC-0037    	    				      Kajan		   Modified version (Rework)		      
******************************************************************************************************************/

package com.qa.automation.qdms.testcases.materialmaincategory;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.pages.master.MaterialMainCategoryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class AddMaterialMainCategoryValidation extends DriverIntialization {

	MaterialMainCategoryPage pg = new MaterialMainCategoryPage();
	public static String mainlast;
	public static String headlast;
	public static boolean CHE;
	public static String validation;
	public static String mainCategory;
	public static String prefix;
	public static String MAINtype;
	public static String checktd;
	public static String cdata;

	@Test
	public void test() throws InterruptedException, IOException {
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

			PropertiesCommonMethods.excalRowCount("Master Module.xlsx", "Material Main Category", "TC-MATMC-0037-01");
			XSSFSheet sheet = wbook.getSheet("Material Main Category");
			int r = PropertiesCommonMethods.countRow - 1;
			row = sheet.getRow(r);
			cell = row.getCell(2);
			mainCategory = dataValue.formatCellValue(cell);
			row = sheet.getRow(r);
			cell = row.getCell(3);
			prefix = dataValue.formatCellValue(cell);
			row = sheet.getRow(r);
			cell = row.getCell(4);
			MAINtype = dataValue.formatCellValue(cell);
			checktd=dataValue.formatCellValue(row.getCell(13));
			cdata=dataValue.formatCellValue(row.getCell(14));
			/*********************************************************************************************/
			PageFactory.initElements(driver, pg);

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
				
				if (MasterMainNavigationsTest.matmaincat) {
					materialMethodes.click(MaterialMainCategoryPage.addmainmaterialbtn, "ADD MATERIAL");
				}
				if (materialMethodes.click) {
					materialMethodes.click=false;
					
					materialMethodes.sendkey(MaterialMainCategoryPage.maincatTextbox, mainCategory, "MAIN CATEGORY TEXT BOX");
				}
				if (materialMethodes.sent) {
					materialMethodes.sent=false;
					materialMethodes.sendkey(MaterialMainCategoryPage.prefixTextbox, prefix, "PREFIX TEXT BOX");
				}
				if (materialMethodes.sent) {
					materialMethodes.sent=false;
					materialMethodes.nordropdown(MaterialMainCategoryPage.maintypeDropdown,"//div[contains(text(),'",MAINtype,"')]//..//div[@class='ant-select-item-option-content']", "main Type dropdown");
				}
				if (materialMethodes.drop) {
					materialMethodes.drop=false;
					materialMethodes.click(MaterialMainCategoryPage.savebtn, "SAVE");
				}
				
				if (materialMethodes.click) {
						materialMethodes.click=false;
						materialMethodes.popupcheck(driver.findElement(By.xpath("//div[@class='ant-modal-body']")), "ADD POPUP");
						
					}
				if (materialMethodes.pop) {

					
					materialMethodes.datacheckinfirstrow("1,2,3", 2,mainCategory+","+prefix+","+MAINtype, "ADD MATERIAL MAIN CATEGORY");
					
				}
				if (!materialMethodes.pop) {
					
					materialMethodes.validationconfirm(checktd,cdata,"add material validation");
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
