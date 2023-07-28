//***********************************************************************************
//* Description
//*------------
//* Plant Equipment Validation 
//***********************************************************************************
//*
//* Author           : kajenthiran
//* Date Written     : 19/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        19/07/2023   kajan     Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testcases.plantequipment;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.Equipment.EquipmentAddValidationTest;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class PlantEquipmentValidation extends DriverIntialization{

	public static boolean continu=false;
	
	static PlantEquipmentPage plantEquipmentPage = new PlantEquipmentPage();
	static EquipmentPage equipmentPage = new EquipmentPage();

	public static String excel_path = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Excel\\Master Module.xlsx";

	@Test
	public static void AddPLantEquipment() throws InterruptedException, IOException {
		PageFactory.initElements(driver, plantEquipmentPage);
		PageFactory.initElements(driver, equipmentPage);
extent.createTest("TC-PLA-EQU-0065:-Check Add  Plant  Equipment   Functionality (Equipment add Functionality)");
		PlantEquipmentAddTest.plantEquipmentNavication();
		
		/****************************************************************************************
		 * PLANTEQUIPMENT ADDBUTTON
		 *  ****************************************************************************************/
	
		if (MasterMainNavigationsTest.plntEquipmentclick) {
			MasterMainNavigationsTest.plntEquipmentclick=false;
			PlantEquipmentAddMethods.plantEquipmentAddButtonUI();
			
			if (PlantEquipmentAddMethods.addPlantEquipment) {
				PlantEquipmentAddMethods.addPlantEquipment = false;

				try {
					/****************************************************************************************
								 * PLANTEQUIPMENT ADDBUTTON FUNCTIONALITY
								 ****************************************************************************************/
					PlantEquipmentAddMethods.plantEquipmentSendValues();
				} catch (Exception e) {
					
				}
			
				if (continu) {
					try {
						driver.navigate().refresh();
						Logout.LogoutFunction();
					} catch (Exception e) {
					}
					
				}
			} 
		} 

		
	}
	
	public static void plantEquipmentNavication() {

		try {
			LoginTest.Login();
			LoginTest.login = true;
			continu=true;
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Login", true, false, "Login");
		}
		if (LoginTest.login) {
			LoginTest.login=false;
			MasterMainNavigationsTest.navigateMaster();
			EquipmentAddValidationTest.continu=true;
			
			if (MasterMainNavigationsTest.clickMaster) {
				MasterMainNavigationsTest.clickMaster=false;
				MasterMainNavigationsTest.navigateEqupmentMain();
				if (MasterMainNavigationsTest. mainEqupment) {
					MasterMainNavigationsTest. plntEquipmentclick=false;
					MasterMainNavigationsTest.navigatePlantEquipment();
				
				}
				
			}
		}
		
	
		
	}
	public static void plantEquipmentSendValues() throws InterruptedException  {
		PlantEquipmentAddMethods.dataFromPlanEqupment("Plant Equipment", "TC-PLA-EQU-0065-01");
		ArrayList<String> errm=  new ArrayList<String>();
		WebDriverWait wait=new WebDriverWait(driver, 6);


			String plant = PlantEquipmentAddMethods.equipData.get(0);
			String equipment = PlantEquipmentAddMethods.equipData.get(1);
			String serialNo =  PlantEquipmentAddMethods.equipData.get(2);
			String brand =  PlantEquipmentAddMethods.equipData.get(3);
			String Model =  PlantEquipmentAddMethods.equipData.get(4);
			String Type =  PlantEquipmentAddMethods.equipData.get(5);
			String FormatNo =  PlantEquipmentAddMethods.equipData.get(6);
			String Description =  PlantEquipmentAddMethods.equipData.get(7);
			String Calibration =  PlantEquipmentAddMethods.equipData.get(8);
			String checktd=PlantEquipmentAddMethods.equipData.get(9);
			String cdata=PlantEquipmentAddMethods.equipData.get(10);
			System.out.println("Description" + Calibration);
			
			//Fill Plant Text Box
//			PlantEquipmentPage.Plant_INPUT
			ActionCommonMethod.visbleEnable(PlantEquipmentPage.plant_INPUT, "Plant Text Box");
			if (ActionCommonMethod.enable) {
				try {
					PlantEquipmentPage.plant_INPUT.click();
					ActionCommonMethod.dropDown("//div[@id='plant_list']/../div[1]", plant, "plant_list");
				} catch (Exception e) {
					PropertiesCommonMethods.cTestReports("Plant Text Box Fill", true, false, e.toString());
				}
				
			}
			
//Fill Equipment text Box
			ActionCommonMethod.visbleEnable(PlantEquipmentPage.Equipmentform, "Equipment Text Box");
			if (ActionCommonMethod.enable) {
				try {
					PlantEquipmentPage.Equipmentform.click();
					ActionCommonMethod.dropDown("//div[@id='equipment_list']/div[1]", equipment, "equipment_list");
				} catch (Exception e) {
					PropertiesCommonMethods.cTestReports("Equipment Text Box Fill", true, false, e.toString());
				}
			}
			
			
//			fill Serial No Text Bpx	
			ActionCommonMethod.visbleEnable(PlantEquipmentPage.Serialno, "Serial No Text Box");
			if (ActionCommonMethod.enable) {
				try {
					PlantEquipmentPage.Serialno.sendKeys(String.valueOf(serialNo));
				} catch (Exception e) {
					String[] x= e.toString().split(":");
					PropertiesCommonMethods.cTestReports("Serial Text Box Fill", true, false, x[1]);
				}
			}
			
//			Fill Brand Text Box
			ActionCommonMethod.visbleEnable(PlantEquipmentPage.BrandName, "Brand Text Box");
			if (ActionCommonMethod.enable) {
				try {
					PlantEquipmentPage.BrandName.sendKeys(brand);
				} catch (Exception e) {
					String[] x= e.toString().split(":");
					PropertiesCommonMethods.cTestReports("Brand Text Box Fill", true, false, x[1]);				}
			}
//			Fill Modal Text Box
			ActionCommonMethod.visbleEnable(PlantEquipmentPage.Model, "Model Text Box");
			if (ActionCommonMethod.enable) {
				try {
					PlantEquipmentPage.Model.sendKeys(Model);
				} catch (Exception e) {
					String[] x= e.toString().split(":");
					PropertiesCommonMethods.cTestReports("Modal Text Box Fill", true, false, x[1]);
				}			}		
			
			ActionCommonMethod.visbleEnable(PlantEquipmentPage.Type, "Type Text Box");
			if (ActionCommonMethod.enable) {
				try {
					PlantEquipmentPage.Type.click();
					ActionCommonMethod.dropDown("//div[@id='equipmentType_list']/div[1]", Type,
							"equipmentType_list");
				} catch (Exception e) {
					String[] x= e.toString().split(":");
					PropertiesCommonMethods.cTestReports("Type Text Box Fill", true, false, x[1]);
				}
			}
			
			ActionCommonMethod.visbleEnable(PlantEquipmentPage.FormatNo, "Format Text Box");
			if (ActionCommonMethod.enable) {
				try {
					PlantEquipmentPage.FormatNo.sendKeys(FormatNo);
				} catch (Exception e) {
					String[] x= e.toString().split(":");
					PropertiesCommonMethods.cTestReports("Format NO Text Box Fill", true, false, x[1]);
				}
				}	
			
			ActionCommonMethod.visbleEnable(PlantEquipmentPage.Description, "Description Text Box");
			if (ActionCommonMethod.enable) {
				try {
					PlantEquipmentPage.Description.sendKeys(Description);
				} catch (Exception e) {
					String[] x= e.toString().split(":");
					PropertiesCommonMethods.cTestReports("Description Text Box Fill", true, false,x[1]
							
						);
				}				}
			
			if (Calibration.equals("true")) {
				
				ActionCommonMethod.visbleEnable(PlantEquipmentPage.clabration, "Relevant Calibration Check Box");
				if (ActionCommonMethod.enable) {
					try {
						PlantEquipmentPage.clabration.click();
					} catch (Exception e) {
						String[] x= e.toString().split(":");
						PropertiesCommonMethods.cTestReports("Relevant Calibration Check Box Fill", true, false,x[1]
								
							);
					}				}
				
			}
			boolean cli=false;
			ActionCommonMethod.visbleEnable(PlantEquipmentPage.SaveButton, "Save Button");
			if (ActionCommonMethod.enable) {
				try {
					PlantEquipmentPage.SaveButton.click();
					cli=true;
				} catch (Exception e) {
					cli=false;
					String[] x= e.toString().split(":");
					PropertiesCommonMethods.cTestReports("Save Button", true, false,x[1]);
				}}
			
			if (cli==true) {
				
				boolean con =false;
				try {
					wait.until(ExpectedConditions.invisibilityOf(PlantEquipmentPage.Serialno));
					con =true;
				} catch (Exception e) {
					con =false;
					// TODO: handle exception
				}
				
				if (con) {
					
					try {
						PlantEquipmentAddMethods.checkAfterAdd();
					} catch (Exception e) {
					}
				}
				else {
					materialMethodes.validationconfirm(checktd, cdata, "plant equpment add validation");
				}
				
				
			}
			
		

	}

	
}
