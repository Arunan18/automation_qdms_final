/***********************************************************************************
* Description
*------------
* EQUIPMENT EDIT METHODS
***********************************************************************************
*
* Author           : VITHUSHA MOHAN
* Date Written     : 06/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*                     				   VITHUSHA.M    Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testcases.Equipment;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SelectDate;
import com.qa.automation.qdms.testcases.material.materialMethodes;
import com.qa.automation.qdms.testcases.plantequipment.PlantEquipmentAddMethods;
import com.qa.automation.qdms.testcases.user.UserMainTests;

public class EquipmentEditPageWise extends DriverIntialization {
	static EquipmentPage equipment = new EquipmentPage();
	public static String excel_path = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Excel\\Master Module.xlsx";
//    Validation
	public static void ValidationEquipment() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 4);
         DataFormatter formater= new DataFormatter();
		PageFactory.initElements(driver, equipment);
		
		PlantEquipmentAddMethods.dataFromPlanEqupment("Equipment", "TC-EQU-0042-01");
		String equipment=null;
		try {
			equipment = PlantEquipmentAddMethods.equipData.get(0);
		} catch (Exception e) {
			// TODO: handle exception
		}

		FileInputStream file = new FileInputStream(excel_path);

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Equipment");
		int firstrow = CommonMethods.getFirstRowNum(excel_path, "Equipment","TC-EQU-0042");
		int lastrow = CommonMethods.getLastRowNum(excel_path, "Equipment","TC-EQU-0042");
//System.out.println("lastrow"+lastrow);
		
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			SelectDate.click(0, 3, EquipmentPage.table, "edit",equipment);
			//boolean check = (boolean) row.getCell(2).getBooleanCellValue();
			String Equipment =formater.formatCellValue(row.getCell(2)) ;
			String Validation1 = formater.formatCellValue(row.getCell(3));
			String Validation2 = formater.formatCellValue(row.getCell(4));
			
			try {
				wait.until(ExpectedConditions.elementToBeClickable(EquipmentPage.equipmenttextbox));
			} catch (Exception e) {
			}
		 ActionCommonMethod.sendkey(EquipmentPage.equipmenttextbox, Equipment);	
		 
		 try {
			EquipmentPage. equipmentsavebutton.click();
		} catch (Exception e) {
		}
		 
		 boolean conti=false;
		 try {
			 wait.until(ExpectedConditions.invisibilityOf(EquipmentPage. equipmentsavebutton));
			
			conti=true;
		} catch (Exception e) {
			conti=false;
		}
		 
		 if (conti) {
			 PropertiesCommonMethods.cTestReports("Edit Validation Of :-"+Validation2, "Validation Message Throws", "Data Is Saved", "Edit Validation");
			
		}else {
			
			String errme=null;
			
			try {
				errme=EquipmentPage.equipmenttypevalidation.getText();
			} catch (Exception e) {
				
			}
			
			PropertiesCommonMethods.cTestReports("Edit Validation Of :-"+Validation2, Validation1, errme, "Edit Validation");
		}
		 
		 try {
			EquipmentPage.equipmentCancelbutton.click();
		} catch (Exception e) {
		}
		 

}
		
	}


	public static String[] equipmentDataFromtable(String testCaseId,String equipment) throws InterruptedException {
		Thread.sleep(3000);
		int firstrow = CommonMethods.getFirstRowNum(excel_path,"Equipment",testCaseId);
		System.out.println("row num"+firstrow);
		
		String expectEquipType = driver
				.findElement(By.xpath("//td[normalize-space()='" + equipment + "']/following-sibling::td[2]")).getText().trim();
		String expectEquipdes = driver
				.findElement(By.xpath("//td[normalize-space()='" + equipment + "']/following-sibling::td[1]")).getText().trim();
		String[] result = {expectEquipType, expectEquipdes};
		System.out.println(result.toString());
		return result;
	}

	public static void equipmentDataconfirm(String testCaseId,String equipment) throws InterruptedException {
		// To use the method and access the variables:
		
		extent.createTest("CONFIRM TABLE DATA IS PRESENT IN EDIT MODEL");
		String[] result = equipmentDataFromtable(testCaseId,equipment);
		String expectEquipType = result[0];
		System.out.println("expected equipment type is" + expectEquipType);
		String expectEquipdes = result[1];
		System.out.println("expected equipment description is"+expectEquipdes);
		
		System.out.println("expected equipment "+equipment);
	    Thread.sleep(3000);
		String actualequipment = EquipmentPage.equipmenttextbox.getAttribute("value").trim();
		System.out.println("Actual equipment  is" + actualequipment);
		String actualEquipType = EquipmentPage.equipmenttypetextbox.getText().trim();
		System.out.println("Actual equipment type is" + actualEquipType);
		String actualEquipmentDes = EquipmentPage.descriptiontextbox.getText().trim();
		System.out.println("Actual equipment description is" + actualEquipmentDes);
		testCaseResult(equipment, actualequipment,"EQUIPMENT IS SAME" );
		testCaseResult(expectEquipType, actualEquipType,"EQUIPMENT TYPE IS SAME");
		testCaseResult(expectEquipdes, actualEquipmentDes,"EQUIPMENT DESCRIPTION IS SAME");
	}

	public static void editdata() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, equipment);
		WebDriverWait wait = new WebDriverWait(driver, 6);
		boolean editclick=false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(EquipmentPage.equipmenttextbox));
		} catch (Exception e) {
		}
		String text1=EquipmentPage.equipmenttextbox.getAttribute("value");
		String text2=driver.findElement(By.xpath("//input[@id='type']/../../span[2]")).getText();
		String text3=EquipmentPage.descriptiontextbox.getText();
		try {
			assertEquals(PlantEquipmentAddMethods.equipData.get(0)+PlantEquipmentAddMethods.equipData.get(2)+PlantEquipmentAddMethods.equipData.get(4), text1+text2+text3);
		System.out.println("is correct");
		
		
		
			String EquipmentNew = PlantEquipmentAddMethods.equipData.get(1);
			String EquipmentTypeNew = PlantEquipmentAddMethods.equipData.get(3);
			String DescriptionNew = PlantEquipmentAddMethods.equipData.get(5);

			
			ActionCommonMethod.visbleEnable(EquipmentPage.equipmenttextbox, "Equipment Text Box");
		 if (ActionCommonMethod.enable && !PlantEquipmentAddMethods.equipData.get(0).equals(PlantEquipmentAddMethods.equipData.get(1))) {
			ActionCommonMethod.sendkey(EquipmentPage.equipmenttextbox, EquipmentNew);
			editclick=true;
		}
		 
		try {
		String	cuser=EquipmentPage.equipmenttypetextbox.getCssValue("Cursor");
		System.out.println(cuser);
			ActionCommonMethod.visbleEnable(EquipmentPage.equipmenttypetextbox, "Type Drop Down");
			
			 if (ActionCommonMethod.enable && !PlantEquipmentAddMethods.equipData.get(2).equals(PlantEquipmentAddMethods.equipData.get(3))) {
				 if(!cuser.equals("not-allowed")) {
				 EquipmentPage.equipmenttypetextbox.click();
			ActionCommonMethod.dropDown("//div[@id='type_list']/../div[1]", EquipmentTypeNew, "type_list");
			editclick=true;}else {
				extent.createTest("Equipment Text Box Not Editable ⚠️");
				PlantEquipmentAddMethods.equipData.add(3,text2 );
			}
			}
			 
			 
	} catch (Exception e) {
		String []x=e.toString().split(":");
		PropertiesCommonMethods.cTestReports("Type Text Box Fill", true, false,x[1]);
	}
		ActionCommonMethod.visbleEnable(EquipmentPage.descriptiontextbox, "Description Drop Down");
		 if (ActionCommonMethod.enable && !PlantEquipmentAddMethods.equipData.get(4).equals(PlantEquipmentAddMethods.equipData.get(5))) {
		 ActionCommonMethod.sendkey(EquipmentPage.descriptiontextbox, DescriptionNew);
		 editclick=true;
		 }
		 if(editclick) {
		
			ActionCommonMethod.clicking(EquipmentPage.equipmentsavebutton, "Update Button");
		
		boolean cont=false;
		 try {
			wait.until(ExpectedConditions.invisibilityOf(EquipmentPage.descriptiontextbox));
			cont=false;
		} catch (Exception e) {
			cont=true;
		}
		 
		 if (cont) {
			 ArrayList< String>data=new ArrayList<String>();
			 String ess=null;
			 int Lx=0;
			 try {
				Lx = driver
						.findElements(
								By.xpath("//div[@class='ant-modal-body']//div[@class='input_wrapper']//div[@style]"))
						.size();
			} catch (Exception e) {
			}
			 for (int i = 1; i <= Lx; i++) {
				 
				  try {
					ess = driver.findElement(By.xpath(
							"(//div[@class='ant-modal-body']//div[@class='input_wrapper']//div[@style])[" + i + "]"))
							.getText();
				} catch (Exception e) {
				}
				  
				  if (!ess.replace(" ", "").isEmpty()) {
					  data.add(ess);
				}
			}
			 
				try {
//					System.out.println(errm);
					
					extent.createTest(data.get(0) + "Validation While Saving Plant Equipment Add Not Complete ⚠️");
				} catch (Exception e) {
					extent.createTest("Plant Equipment Add Not Complete ⚠️");
				}
			materialMethodes.validationconfirm("", "", "Equipment Edit");
		}else {
			/****************************************************************************************
			 * CONFIRM EQUIPMENT EDIT FUNCTIONALITY
			 ****************************************************************************************/
			EquipmentEditPageWise.afterEditorAdd();
		}
		 
		 
		 }else {
			 extent.createTest("Any Data Not Edited ⚠️");
		}

		} catch (AssertionError e) {
			PropertiesCommonMethods.cTestReports("Edit Data Checking", "Matching", "Not Matching", "");
		}	
		
	}
	public static void editmiddledata() throws IOException, InterruptedException {

		PageFactory.initElements(driver, equipment);
		boolean pass = false;
		Thread.sleep(1000);

		FileInputStream file = new FileInputStream(excel_path);
		// C:\Automation_Workspace\QDMS-AUTOMATION\src\test\java\com\invicta\qa\excel\Data.xlsx
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Equipment");
		int firstrow = CommonMethods.getFirstRowNum(excel_path, "Equipment","TC-EQU-0057");
		int lastrow = CommonMethods.getLastRowNum(excel_path, "Equipment","TC-EQU-0057");
		
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			
			String EquipmentNew = (String) row.getCell(2).getStringCellValue();
			String EquipmentTypeNew = (String) row.getCell(3).getStringCellValue();
			String DescriptionNew = (String) row.getCell(4).getStringCellValue();

			
				EquipmentPage.equipmenttextbox.sendKeys(Keys.END);
				Thread.sleep(2000);
				int num = 100;
				for (int j = 0; j < num; j++) {
					EquipmentPage.equipmenttextbox.sendKeys(Keys.BACK_SPACE);
				}
				

				EquipmentPage.equipmenttextbox.sendKeys(EquipmentNew);
				EquipmentPage.equipmenttypetextbox.click();

				Thread.sleep(2000);
				for (int j = 1; j <= 2; j++) {
					WebElement name = driver
							.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[" + j + "]"));
					String dropcontent = name.getText();
					if (dropcontent.contentEquals(EquipmentTypeNew)) {
						name.click();
						pass = true;
					} else if (dropcontent.isEmpty()) {
						pass = true;
					}
				}

				
				EquipmentPage.descriptiontextbox.clear();
				EquipmentPage.descriptiontextbox.sendKeys(DescriptionNew);
				EquipmentPage.equipmentsavebutton.click();
			
		}
	}
	public static void testCaseResult(Object expect, Object actual,String heading) {
		
		boolean searchdata = true;

		try {
			AssertJUnit.assertTrue(actual.equals(expect));
		} catch (AssertionError e) {
			searchdata = false;
		}

		if (searchdata) {
			testCase = extent.createTest(heading);
			testCase.log(Status.INFO, "Actual Data :" +actual );
			testCase.log(Status.INFO, "Expected Data :" +expect );
			testCase.log(Status.PASS, "Test Pass").assignCategory("Medium-Severity");
		} else {
			testCase = extent.createTest(heading);
			testCase.log(Status.INFO, "Actual Data :" +actual );
			testCase.log(Status.INFO, "Expected Data :" +expect );
			testCase.log(Status.FAIL, "Test Fail").assignCategory("Medium-Severity");
		}
	}
	public static void afterEditorAdd()  {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, equipment);
		
			String expectEquipment = PlantEquipmentAddMethods.equipData.get(1);
			String expectEquipType = PlantEquipmentAddMethods.equipData.get(3);
			String expectEquipdes = PlantEquipmentAddMethods.equipData.get(5);
			
		String actualEquipment = EquipmentPage.equipdata.getText();
		
		String actualEquipType = EquipmentPage.typedata.getText();
		
		String actualEquipdes =EquipmentPage.descriptiondata.getText();
		
		testCaseResult(expectEquipment, actualEquipment,"Verify Equipment Data After Edit" );
		testCaseResult(expectEquipType, actualEquipType,"Verify EquipmentType Data After Edit");
		testCaseResult(expectEquipdes, actualEquipdes,"Verify Equipment Description Data After Edit");
	}
	public static void ElementFunction(WebElement element,String Field) {
		
		try {
			element.isDisplayed();
			testCase = extent.createTest(Field+"  IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			try {
				element.isEnabled();
				testCase = extent.createTest(Field+" IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
			} catch (Exception e) {
				testCase = extent.createTest(Field+"IS NOT ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");// TODO: handle exception
			}
		} catch (Exception e) {
			testCase = extent.createTest(Field+"IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");// TODO: handle exception
		}
	}


}
