package com.qa.automation.qdms.testcases.user;

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

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.pages.master.UserPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SelectDate;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plantequipment.PlantEquipmentAddMethods;

public class UserRoleAllocation extends DriverIntialization {
	static ArrayList<String>adde=new ArrayList<String>();
	static ArrayList<String>delete=new ArrayList<String>();
	@Test
	
public static void userRoleal() {


	 EquipmentPage sourcepage = new EquipmentPage();
	PageFactory.initElements(driver, sourcepage);
boolean contnew=false;
extent.createTest("TC-USER-0099:- Edit Role Allocation");
	LoginTest.Login();  
	contnew=true;
	if (LoginTest.login) {
		MasterMainNavigationsTest.navigateMaster();
		
		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateEmployeeMain();
			if (MasterMainNavigationsTest.clickEmployeeMain) {
				MasterMainNavigationsTest.navigateUser();
				if (MasterMainNavigationsTest.clickUser) {
					PlantEquipmentAddMethods.dataFromPlanEqupment("User", "TC-USER-0099-01");	
					SelectDate.click(0, 6, EquipmentPage.table, "Id", PlantEquipmentAddMethods.equipData.get(0));
					if (SelectDate.clickDon) {
						selectdata();
					}
				}
				
			}}}
	if (contnew) {
		driver.navigate().refresh();
		Logout.LogoutFunction();
	}
	



	
}
	public static void selectdata() {
		boolean cont= false;
		UserPage xe= new UserPage();
		PageFactory.initElements(driver, xe);
		WebDriverWait wait = new WebDriverWait(driver, 3);
		int I=0;
		ArrayList<String>indata=new ArrayList<String>();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(UserPage.plantRoleEdit));
		} catch (Exception e) {
		}
		
		try {
			I = driver.findElements(By
					.xpath("//div[@class='ant-modal-content']//div[@class='ant-select-selector']/div/div/span/span[1]"))
					.size();
		} catch (Exception e) {
		}
		
		
		for (int j = 1; j <= I; j++) {
			String x="";
			
			try {
			x=	driver.findElement(
						By.xpath("//div[@class='ant-modal-content']//div[@class='ant-select-selector']/div/div[" + j
								+ "]/span/span[1]"))
						.getText();
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (!x.isEmpty()) {
				indata.add(x);
			}
			System.out.println(indata);
		}
		
		
		ActionCommonMethod.clicking(UserPage.plantRoleEdit,"User Role Alocation Text Box" );
		
		if (ActionCommonMethod.cilicka) {

			XSSFRow row = null;
			DataFormatter dataValue = new DataFormatter();
			FileInputStream fileIn = null;
			String filelocation = null;
			XSSFWorkbook wbook = null;

			try {
				filelocation = "./src/test/resources/Excel/Master Module.xlsx";

				fileIn = new FileInputStream(filelocation);
				wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);

				PropertiesCommonMethods.excalRowCount("Master Module.xlsx", "User", "TC-USER-0099-01");
				int Ix = PropertiesCommonMethods.countRow - 1;

				for (int j = 2; j < 20; j++) {
					XSSFSheet sheet = wbook.getSheet("User");
					row = sheet.getRow(Ix);
					String click = dataValue.formatCellValue(row.getCell(j));
					if (click.isEmpty()) {
						break;
					}
					String tru =dataValue.formatCellValue(sheet.getRow(Ix+1).getCell(j));
					if (tru.equals("true") && !indata.contains(click)) {
						ActionCommonMethod.dropDown("//div[contains(@id,'rc_select')]/div[1]", click,
								"rc_select");
						if (ActionCommonMethod.dropdwn) {
							adde.add(click);
							cont=true;
						}
					}
				else if (tru.contentEquals("false")) {
try {
	driver.findElement(
			By.xpath("//div[@class='ant-modal-content']//div[@class='ant-select-selector']/div/div/span/span[text()='"
					+ click + "']/../span[2]/span"))
			.click();
	delete.add(click);
	cont=true;
} catch (Exception e) {
	// TODO: handle exception
}
				
				}
				}

			} catch (Exception e) {
				testCase = extent.createTest("Check The Excel Name Or Tab Name");
				testCase.log(Status.INFO, "Excel is not available ");
				testCase.log(Status.FAIL, "Excel is not Found");

			}
		
			try {
				UserPage.plantRoleEdit.click();
			if (cont) {
				ActionCommonMethod.clicking(UserPage.plantRoleEditok, "User Role Allocation OK Button");
			}
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (ActionCommonMethod.cilicka) {
				confrm();
			}
			
		}
		
	}
	public static void confrm() {
		WebDriverWait wait =new WebDriverWait(driver, 2);
		SelectDate.click(0, 5, EquipmentPage.table, "Id", PlantEquipmentAddMethods.equipData.get(0));
		String ed="";
		try {
			wait.until(ExpectedConditions
					.invisibilityOf(driver.findElement(By.xpath("//div[@class='ant-popover-inner-content']"))));
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (SelectDate.clickDon) {
		try {
			ed=driver.findElement(By.xpath("//div[@class='ant-popover-inner-content']")).getText();
			int add=adde.size();
			int dele=delete.size();
				
			if (add>=1) {
				
				for (int i = 0; i < add; i++) {
					
				if (ed.contains(adde.get(i))) {
					PropertiesCommonMethods.cTestReports(adde.get(i)+"-Added In Role", adde.get(i), adde.get(i), "");
				}else {
					PropertiesCommonMethods.cTestReports(adde.get(i)+"-Added In Role", adde.get(i), "", "");
				}
					
				}
				
			}
		if (dele>=1) {
				
				for (int i = 0; i < dele; i++) {
					
				if (!ed.contains(delete.get(i))) {
					PropertiesCommonMethods.cTestReports(delete.get(i)+"-Remove In Role", delete.get(i), delete.get(i), "");
				}else {
					PropertiesCommonMethods.cTestReports(delete.get(i)+"-Remove In Role", delete.get(i), "", "");
				}
					
				}
				
			}
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		}
		
	
	}
}
