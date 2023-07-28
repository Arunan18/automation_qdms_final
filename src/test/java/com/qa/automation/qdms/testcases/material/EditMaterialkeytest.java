/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking EditMaterialkeytest Functionality
******************************************************************************************************************
*
* @author 	 : 	Kajenthiran Yogalingam
* 
* ======================================================================================================
* 	Test Case Number 	 ||  	Date      ||      Intis     ||   Comments
* ================================================================================================================
*  	 TC-MAT-0083    	    				      Kajan		   Modified version (Rework)		      
******************************************************************************************************************/

package com.qa.automation.qdms.testcases.material;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class EditMaterialkeytest extends DriverIntialization{

	@Test
	public static void materialEditKeyTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		materialMethodes.navicateMaterial();
		
		// get data from excel

		XSSFRow row = null;

		DataFormatter dataValue = new DataFormatter();
		String filelocation;
		String td = null;
		String icclickdata = null;
		String name1 = null;
		String name2=null;
		boolean exdata=false;
		String tic3=null;
		
		String excelbook="Master Module";
		String exceltab="Material";
		String testid="TC-MAT-0083";

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

				td=dataValue.formatCellValue(row.getCell(1));
				icclickdata = dataValue.formatCellValue(row.getCell(2));
				
				name1=dataValue.formatCellValue(row.getCell(3));
				name2=dataValue.formatCellValue(row.getCell(4));
				tic3=dataValue.formatCellValue(row.getCell(5));
				
				
				exdata = true;
		
		
		if (materialMethodes.kmnavication) {
			materialMethodes.kmnavication=false;
			materialMethodes.iconclick( td, icclickdata, "funnel-plot");	
		}
		if (materialMethodes.iconclick) {
			materialMethodes.iconclick=false;
			materialMethodes.materialEditkey(name1, name2,tic3, "material key test");
		}if (exdata) {
			WebElement savebtn=driver.findElement(By.xpath("//div[@class='ant-modal-footer']//span[text()='Save']/.."));
			materialMethodes.click(savebtn, "add key test save button");
			
		}
		if (materialMethodes.click) {
			materialMethodes.click=false;
			WebElement popup=driver.findElement(By.xpath("//div[text()='Add Key Test']/../../../div[@class='ant-modal-content']"));
			materialMethodes.popupcheck(popup, "add key popup");
		}System.out.println(materialMethodes.pop+"popcheck");
		if (materialMethodes.pop) {
			
		}if (!materialMethodes.pop) {
			
		}
		

			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		if (LoginTest.login) {
			
			Logout.LogoutFunction();
			
		}
		
	}



}
