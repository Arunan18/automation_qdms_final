package com.qa.automation.qdms.testcases.customer;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SelectDate;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plantequipment.PlantEquipmentAddMethods;

public class AllocatePlantEdit extends DriverIntialization {
	static ArrayList<String>adde=new ArrayList<String>();
	static ArrayList<String>delete=new ArrayList<String>();
	@Test
	public static void allocatePlant () {
		EquipmentPage aa = new EquipmentPage();
		PageFactory.initElements(driver, aa);


		 EquipmentPage sourcepage = new EquipmentPage();
		PageFactory.initElements(driver, sourcepage);
	boolean contnew=false;
	extent.createTest("TC-CUS-0046 :- Checking the allocate plant check box Functionality & Allocate Plants");
		LoginTest.Login();  
		contnew=true;
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {
				MasterMainNavigationsTest.navigateCustomerMain();
				if (MasterMainNavigationsTest.clickCustomermain) {
					MasterMainNavigationsTest.navigateCustomer();
					if (MasterMainNavigationsTest.clickCustomer) {
						PlantEquipmentAddMethods.dataFromPlanEqupment("Customer", "TC-CUS-0046-01");	
						SelectDate.click(2, 5,EquipmentPage.table, "Id", PlantEquipmentAddMethods.equipData.get(0));
						if (SelectDate.clickDon) {
							
							selectData();
						}
					}
					
				}}}
		if (contnew) {
			driver.navigate().refresh();
			Logout.LogoutFunction();
		}
		
	
	
	
		
	}
	public static void selectData() {
		WebDriverWait wait =new WebDriverWait(driver, 3);
		
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='ant-modal-content']"))));
		} catch (Exception e) {
			// TODO: handle exception
		}
boolean cont=false;
		XSSFRow row = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;

		try {
			filelocation = "./src/test/resources/Excel/Master Module.xlsx";

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);

			PropertiesCommonMethods.excalRowCount("Master Module.xlsx", "Customer", "TC-CUS-0046-01");
			int Ix = PropertiesCommonMethods.countRow - 1;

			for (int j = 2; j < 30; j++) {
				XSSFSheet sheet = wbook.getSheet("Customer");
				row = sheet.getRow(Ix);
				String click = dataValue.formatCellValue(row.getCell(j));
				if (click.isEmpty()) {
					break;
				}
				boolean tru =Boolean.parseBoolean( dataValue.formatCellValue(sheet.getRow(Ix+1).getCell(j)));
			
try {
	boolean cli = driver
			.findElement(By.xpath("//div[@class='ant-modal-content']//span[text()='" + click + "']/../span[1]/input"))
			.isSelected();
	if (!tru == cli) {
		driver.findElement(By.xpath("//div[@class='ant-modal-content']//span[text()='"+click+"']/../span[1]/input"))
				.click();
		cont=true;
		if (tru) {
			adde.add(click);
		}
		else if (!tru) {
			delete.add(click);
			
		}
	} 
	
	
} catch (Exception e) {
}
			}
			if (cont) {
				ActionCommonMethod.clicking(driver.findElement(By.xpath("//div[@class='ant-modal-footer']/button[2]")),
						"Ok Button");
				if (ActionCommonMethod.cilicka) {
					confirms();
					
				}
			}
		
	}catch (Exception e) {
		// TODO: handle exception
	}
		
		
	}
	
	public static void confirms() {
		String ed="";
		WebDriverWait wait = new WebDriverWait(driver, 3);
		SelectDate.click(2, 1,EquipmentPage.table, "Id", PlantEquipmentAddMethods.equipData.get(0));
		try {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//div[@class='ant-popover-inner-content']"))));
		} catch (Exception e) {
		}
		if (SelectDate.clickDon) {
			try {
				ed=driver.findElement(By.xpath("//div[@class='ant-popover-inner-content']")).getText();
				int add=adde.size();
				int dele=delete.size();
					
				if (add>=1) {
					
					for (int i = 0; i < add; i++) {
						
					if (ed.contains(adde.get(i))) {
						PropertiesCommonMethods.cTestReports(adde.get(i)+"-Added Allocate Plant", adde.get(i), adde.get(i), "");
					}else {
						PropertiesCommonMethods.cTestReports(adde.get(i)+"-Added Allocate Plant", adde.get(i), "", "");
					}
						
					}
					
				}
			if (dele>=1) {
					
					for (int i = 0; i < dele; i++) {
						
					if (!ed.contains(delete.get(i))) {
						PropertiesCommonMethods.cTestReports(delete.get(i)+"-Remove Allocate Plant", false, false, "");
					}else {
						PropertiesCommonMethods.cTestReports(delete.get(i)+"-Remove Allocate Plant",false , delete.get(i), "");
					}
						
					}
					
				}
			
			}catch (Exception e) {
				// TODO: handle exception
			}
			}
		
	}
}
