

package com.qa.automation.qdms.testcases.materialmaincategory;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.pages.master.MaterialMainCategoryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class MaterialmaincatEditCancelBtnFunction extends DriverIntialization{
	MaterialMainCategoryPage pg = new MaterialMainCategoryPage();
@Test
	public void materialmaincatEditCancelBtnFunction() throws InterruptedException {
		PageFactory.initElements(driver, pg);

		testCase = extent.createTest("TC-MATMC-0047 -- ADD MATERIAL MAIN CATEGORY FUNCTIONALITY");
		String mainCategory1=null;
		
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

			PropertiesCommonMethods.excalRowCount("Master Module.xlsx", "Material Main Category", "TC-MATMC-0047-01");
			XSSFSheet sheet = wbook.getSheet("Material Main Category");
			int r = PropertiesCommonMethods.countRow - 1;
			row = sheet.getRow(r);
			cell = row.getCell(2);
			mainCategory1 = dataValue.formatCellValue(cell);
			
			
			
			
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
			if (MasterMainNavigationsTest.matmaincat) {
				materialMethodes.iconclick( "1",mainCategory1 , "edit");
			}
			if (materialMethodes.click) {
				materialMethodes.click=false;
				materialMethodes.cancelOrCloseButtonFunction(MaterialMainCategoryPage.cancelbtn, MaterialMainCategoryPage.addmatpopup, "cancel button", "edit material main category popup");
			}
		}catch (Exception e) {
			
		}
		
//	          REFRESH
		          driver.navigate().refresh();
		          Thread.sleep(1000);
			
		Logout.LogoutFunction();
	}

}
