package com.qa.automation.qdms.testcases.materialsubcategory;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.pages.master.MaterialSubCategoryPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SelectDate;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;
import com.qa.automation.qdms.testcases.plantequipment.PlantEquipmentAddMethods;

public class MatSubEdit extends DriverIntialization{
	@Test
	public static void edit() throws InterruptedException {

		MaterialSubCategoryPage msp= new MaterialSubCategoryPage();
		PageFactory.initElements(driver, msp);

		boolean contnew=false;
		extent.createTest("TC-MATSC-0050:- Check Edit Material Sub Category Functionality (Material Sub Category  Edit Functionality)");
				LoginTest.Login();  
				contnew=true;
				if (LoginTest.login) {
					MasterMainNavigationsTest.navigateMaster();
					
					if (MasterMainNavigationsTest.clickMaster) {
						MasterMainNavigationsTest.navigateMaterialMain();
						if (MasterMainNavigationsTest.clickMaterialMain) {
		MasterMainNavigationsTest.navigateMaterialSubCategory();
		
		//String validation1="";
		//String expated1="Prefix can't be empty";		
		
		
		
		
		if (MasterMainNavigationsTest.clicksubCategory) {
			PlantEquipmentAddMethods.dataFromPlanEqupment("Material Sub Category", "TC-MATSC-0050-01");		
			valueedit();
		}
						
						}}}
				if (contnew) {
					driver.navigate().refresh();
					Logout.LogoutFunction();
				}
		
		
		
		
	
		
	}
	public static void valueedit() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		MaterialSubCategoryPage msp= new MaterialSubCategoryPage();
		PageFactory.initElements(driver, msp);
		SelectDate.click(2, 5, MaterialSubCategoryPage.matSubTable, "edit",PlantEquipmentAddMethods.equipData.get(2));
		
		if (SelectDate.clickDon) {
			String oldmainType=null;
			String OldMainCat=null;	
			String oldPrifix=null;
			String oldSubcat=null;
			try {
				wait.until(ExpectedConditions.elementToBeClickable(MaterialSubCategoryPage.prefixtextbox));
			} catch (Exception e) {
			}
			try {
				oldmainType = driver.findElement(By.xpath("//input[@id='mainType']/../../span[2]"))
						.getAttribute("title");
			} catch (Exception e) {
			}
			try {
				OldMainCat = driver.findElement(By.xpath("//input[@id='material_category']/../../span[2]"))
						.getAttribute("title");
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				oldPrifix = MaterialSubCategoryPage.prefixtextbox.getAttribute("value");
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				oldSubcat = MaterialSubCategoryPage.subtextbox.getAttribute("value");
			} catch (Exception e) {
				// TODO: handle exception
			}
			boolean edit=false;
			try {
				assertEquals(oldmainType+OldMainCat+oldPrifix+oldSubcat, PlantEquipmentAddMethods.equipData.get(3)+PlantEquipmentAddMethods.equipData.get(1)+PlantEquipmentAddMethods.equipData.get(2)+PlantEquipmentAddMethods.equipData.get(0));
				
				if (!oldmainType.contentEquals(PlantEquipmentAddMethods.equipData.get(7))) {
					ActionCommonMethod.clicking(MaterialSubCategoryPage.editMainType, "Main Type Text Box");
					if (ActionCommonMethod.cilicka) {
						ActionCommonMethod.dropDown("//div[@id='mainType_list']/div[1]",
								PlantEquipmentAddMethods.equipData.get(7), "mainType_list");
						if (ActionCommonMethod.dropdwn) {
							edit = true;
						}else {
							PlantEquipmentAddMethods.equipData.remove(7);
							PlantEquipmentAddMethods.equipData.add(7, oldmainType);
						} 
					}
					
				}
				
				if (!oldmainType.contentEquals(PlantEquipmentAddMethods.equipData.get(5)) && ActionCommonMethod.enable) {
					ActionCommonMethod.clicking(MaterialSubCategoryPage.editMainmaterial, "Material Main Category Text Box");
					if (ActionCommonMethod.cilicka) {
						ActionCommonMethod.dropDown("//div[@id='material_category_list']/div[1]",
								PlantEquipmentAddMethods.equipData.get(5), "material_category_list");
						if (ActionCommonMethod.dropdwn) {
							edit = true;
						} else {
							PlantEquipmentAddMethods.equipData.remove(5);
							PlantEquipmentAddMethods.equipData.add(5, oldmainType);
						}
					}
					
				}
				
		if (!oldPrifix.equals(PlantEquipmentAddMethods.equipData.get(6))) {
			ActionCommonMethod.sendkey(MaterialSubCategoryPage.prefixtextbox, PlantEquipmentAddMethods.equipData.get(6),
					"Prefix Text Box");
			if (ActionCommonMethod.sendkey) {
				edit=true;
			}else {
				PlantEquipmentAddMethods.equipData.remove(6);
				PlantEquipmentAddMethods.equipData.add(6, oldPrifix);
			}
		}
		
		if (!oldSubcat.equals(PlantEquipmentAddMethods.equipData.get(4))) {
			ActionCommonMethod.sendkey(MaterialSubCategoryPage.subtextbox, PlantEquipmentAddMethods.equipData.get(4),
					"Sub Category Text Box");
			if (ActionCommonMethod.sendkey) {
				edit=true;
			}else {
				PlantEquipmentAddMethods.equipData.remove(4);
				PlantEquipmentAddMethods.equipData.add(4, oldSubcat);
			}
		}
		
		if (edit) {
			ActionCommonMethod.clicking(MaterialSubCategoryPage.Update, "Update Button");
			
		}
		boolean conti =false;
		if (ActionCommonMethod.cilicka) {
			try {
				wait.until(ExpectedConditions.invisibilityOf(MaterialSubCategoryPage.prefixtextbox));
				conti =true;
			} catch (Exception e) {
				conti =false;
			}
			
			
			if (conti) {
				String message=null;
				try {
					wait.until(ExpectedConditions.visibilityOf(
							driver.findElement(By.xpath("//div[@class='ant-notification-notice-message']"))));
				} catch (Exception e) {
				}
				try {
					message = driver.findElement(By.xpath("//div[@class='ant-notification-notice-message']"))
							.getText();
				} catch (Exception e) {
				}
				PropertiesCommonMethods.cTestReports("Confirm Edit Successfully Message", "Material Subcategory Updated Successfully", message, "");
				confirm();
			}else {
				materialMethodes.validationconfirm("", "", "Add Material Sub Category Edit");
			}
			
			
			
		}
		
				
				
			} catch (AssertionError e) {
				extent.createTest("Edit Datas Not Matching ⚠️");
			}
			
			
			
			
			
			
			
		}
		
	}
	
public static void confirm() throws InterruptedException {
	Thread.sleep(500);
	try {
		driver.findElement(By.xpath("//ul/li[@title='1']")).click();
	} catch (Exception e) {
		
	}
	Thread.sleep(1000);
	String mainType=null;
	String MainCat=null;	
	String Prifix=null;
	String Subcat=null;
	
	
	Subcat=	driver.findElement(By.xpath("//tr[2]/td[1]")).getText();
	MainCat=	driver.findElement(By.xpath("//tr[2]/td[2]")).getText();
	Prifix=	driver.findElement(By.xpath("//tr[2]/td[3]")).getText();
	mainType=	driver.findElement(By.xpath("//tr[2]/td[4]")).getText();
	
	PropertiesCommonMethods.cTestReports("After Edit Confirm Material Sub Category ", PlantEquipmentAddMethods.equipData.get(4), Subcat, "");
	PropertiesCommonMethods.cTestReports("After Edit Confirm Material Main Category ", PlantEquipmentAddMethods.equipData.get(5), MainCat, "");
	PropertiesCommonMethods.cTestReports("After Edit Confirm Prefix ", PlantEquipmentAddMethods.equipData.get(6), Prifix, "");
	PropertiesCommonMethods.cTestReports("After Edit Confirm Prefix ", PlantEquipmentAddMethods.equipData.get(7), mainType, "");
	
}

}
