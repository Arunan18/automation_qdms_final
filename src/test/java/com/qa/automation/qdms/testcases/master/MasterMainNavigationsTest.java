package com.qa.automation.qdms.testcases.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.pages.master.NavigationPage;
import com.qa.automation.qdms.pages.master.SbuPage;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class MasterMainNavigationsTest extends DriverIntialization {

	static NavigationPage np = new NavigationPage();

	public static boolean clickMaster = false;
	public static boolean clickPlantMain = false;
	public static boolean clickSbu = false;
	public static boolean clickMaterialMain = false;
	public static boolean clickUnit = false;
	public static boolean clickCustomer = false;
	public static boolean clickCustomermain = false;
	public static boolean clickProject = false;
	public static boolean clickDelivery = false;
	public static boolean navigateMaterialMain = false;
	public static boolean plntEquipmentclick = false;
	public static boolean mainEqupment = false;
	public static boolean Equipmentclick = false;
	public static boolean clickEmployeeMain = false;
	public static boolean clickDesignation = false;
	public static boolean clickMaterialState = false;
	public static boolean clicksubCategory = false;
	public static boolean mainSupplierCategory = false;
	public static boolean Plantclick = false;
	public static boolean supplierClick = false;
	public static boolean clickSuppliermain = false;
static WebDriverWait wait=new WebDriverWait(driver, 10);
//	Navigate Master
	public static void navigateMaster() {
		PageFactory.initElements(driver, np);
		clickMaster = false;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(NavigationPage.Master));
		} catch (Exception e) {
			// TODO: handle exception
		}
		MultiSearchMethods.BtnVisible = true;
		MultiSearchMethods.BtnEnable = true;
		try {

			// MultiSearchMethods.Buttons(NavigationPage.Master, "Master Main Card");
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
				NavigationPage.Master.click();
				clickMaster = true;
			}
		} catch (Exception e) {
			clickMaster = false;
			testCase = extent.createTest("Master Main Card Click");
			testCase.log(Status.INFO, "Master Main Card Not Clicked");
			testCase.log(Status.FAIL, "Clicked Fail");
		}
	}

//	Navigate Plant
	public static void navigatePlantMain() {
		PageFactory.initElements(driver, np);
		MultiSearchMethods.BtnVisible = true;
		MultiSearchMethods.BtnEnable = true;
		clickPlantMain = false;
		try {

			MultiSearchMethods.Buttons(NavigationPage.MainPlant, "Master Main Plant");
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
				NavigationPage.MainPlant.click();
				clickPlantMain = true;
			}
		} catch (Exception e) {
			clickPlantMain = false;
			testCase = extent.createTest("Master Main Plant Click");
			testCase.log(Status.INFO, "Master Main Plant Not Clicked");
			testCase.log(Status.FAIL, "Clicked Fail");
		}

	}

//	Navigate Equpment
	public static void navigateEqupmentMain() {
		mainEqupment = false;
		PageFactory.initElements(driver, np);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(NavigationPage.MainEqupment));
		} catch (Exception e) {

		}

		boolean viseq = NavigationPage.MainEqupment.isDisplayed();
		if (viseq) {
			boolean enableq = NavigationPage.MainEqupment.isEnabled();
			if (enableq) {
				NavigationPage.MainEqupment.click();
				mainEqupment = true;
			} else {
				PropertiesCommonMethods.cTestReports("Main Equipment Button Enable", true, enableq,
						"Main Equipment Button Enable");

			}
		} else {
			PropertiesCommonMethods.cTestReports("Main Equipment Button Visibilty", true, viseq,
					"Main Equipment Button Visibilty");
		}
	}

//	Navigate Material
	public static void navigateMaterialMain() {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		PageFactory.initElements(driver, np);

		MultiSearchMethods.BtnVisible = true;
		MultiSearchMethods.BtnEnable = true;
		clickMaterialMain = false;
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NavigationPage.MainMaterial));
			MultiSearchMethods.Buttons(NavigationPage.MainMaterial, "Master Main Material");
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {

				NavigationPage.MainMaterial.click();
				clickMaterialMain = true;
			}
		} catch (Exception e) {
		}

	}

//	Navigate Customer
	public static void navigateCustomerMain(){
		PageFactory.initElements(driver, np);

		MultiSearchMethods.BtnVisible = true;
		MultiSearchMethods.BtnEnable = true;
		clickCustomermain = false;
		try {

			MultiSearchMethods.Buttons(NavigationPage.MainCustomer, "Master Customer");
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {

				NavigationPage.MainCustomer.click();
				clickCustomermain = true;
			}
		} catch (Exception e) {
			clickMaterialMain = false;
			testCase = extent.createTest("Customer Click");
			testCase.log(Status.INFO, "Customer Not Clicked");
			testCase.log(Status.FAIL, "Clicked Fail");
		}

	}

//	Navigate Supplier
	public static void navigateSupplierMain() {
		PageFactory.initElements(driver, np);

		MultiSearchMethods.BtnVisible = true;
		MultiSearchMethods.BtnEnable = true;
		clickSuppliermain = false;
		try {

			MultiSearchMethods.Buttons(NavigationPage.MainSupplier, "Master Supplier");
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {

				NavigationPage.MainSupplier.click();
				clickSuppliermain = true;
			}
		} catch (Exception e) {
			clickMaterialMain = false;
			testCase = extent.createTest("Customer Click");
			testCase.log(Status.INFO, "Customer Not Clicked");
			testCase.log(Status.FAIL, "Clicked Fail");
		}
	}

//	Navigate Employee
	public static void navigateEmployeeMain(){
		PageFactory.initElements(driver, np);
		MultiSearchMethods.BtnVisible = true;
		MultiSearchMethods.BtnEnable = true;

		try {

			MultiSearchMethods.Buttons(NavigationPage.MainEmployee, "Employee Main");
			System.out.println(MultiSearchMethods.BtnVisible +" "+ MultiSearchMethods.BtnEnable);
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
//				WebDriverWait wai=new WebDriverWait(driver, 30);
//				wai.until(ExpectedConditions.elementToBeClickable(NavigationPage.MainEmployee));
				Thread.sleep(4000);
				NavigationPage.MainEmployee.click();
				clickEmployeeMain = true;
			}
		} catch (Exception e) {
			clickEmployeeMain = false;
			testCase = extent.createTest("Employee Main Click");
			testCase.log(Status.INFO, "Employee Main Not Clicked");
			testCase.log(Status.FAIL, "Clicked Fail");
		}
	}

//	Navigate SBU
	public static void navigateSbu(String testcase) throws InterruptedException {
		PageFactory.initElements(driver, np);
		try {

			MultiSearchMethods.Buttons(NavigationPage.Sbu, "SBU");
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
				NavigationPage.Sbu.click();
				clickSbu = true;
				testCase = extent.createTest("Check Sub Business Unit Button Functionality");
				try {
					Assert.assertEquals(SbuPage.addSbuBtn.isDisplayed(), true);
					testCase.log(Status.INFO, "Add SBU Button Visible");
					testCase.log(Status.INFO, "So Correctly working SBU Button Functionality");
					testCase.log(Status.PASS, "So, SBU Button Functionality Pass");
				} catch (Exception e) {
					testCase.log(Status.INFO, "Add SBU Button Not Visible");
					testCase.log(Status.INFO, "So Wrongly working SBU Button Functionality");
					testCase.log(Status.FAIL, "So, SBU Button Functionality Fail");
				}
			}
		} catch (Exception e) {
			clickSbu = false;
			testCase = extent.createTest("SBU Click");
			testCase.log(Status.INFO, "SBU Not Clicked");
			testCase.log(Status.FAIL, "Clicked Fail");
		}
	}

//	Navigate SBU
	public static void navigateSbu() {
		PageFactory.initElements(driver, np);
		MultiSearchMethods.BtnVisible = true;
		MultiSearchMethods.BtnEnable = true;
		clickSbu = false;
		try {

			MultiSearchMethods.Buttons(NavigationPage.Sbu, "SBU");
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
				NavigationPage.Sbu.click();
				clickSbu = true;
			}
		} catch (Exception e) {
			clickSbu = false;
			testCase = extent.createTest("SBU Click");
			testCase.log(Status.INFO, "SBU Not Clicked");
			testCase.log(Status.FAIL, "Clicked Fail");
		}
	}

//	Navigate Plant
	public static void navigatePlant() throws InterruptedException {
		PageFactory.initElements(driver, np);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(NavigationPage.Plant));

		boolean equiment = NavigationPage.Plant.isDisplayed();
		if (equiment) {
			boolean equimentena = NavigationPage.Plant.isEnabled();
			if (equimentena) {
				NavigationPage.Plant.click();
				Plantclick = true;
			} else {
				PropertiesCommonMethods.cTestReports("Plant Button Enable", true, equimentena, "Plant Button Enable");

			}
		} else {
			PropertiesCommonMethods.cTestReports("Plant Button Visibilty", true, equiment, "Plant Button Visibilty");

		}
	}

//	Navigate Equipment
	public static void navigateEquipment() {
		Equipmentclick = false;
		PageFactory.initElements(driver, np);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(NavigationPage.Equipment));

		boolean equiment = NavigationPage.Equipment.isDisplayed();
		if (equiment) {
			boolean equimentena = NavigationPage.Equipment.isEnabled();
			if (equimentena) {
				NavigationPage.Equipment.click();
				Equipmentclick = true;
			} else {
				PropertiesCommonMethods.cTestReports("Equipment Button Enable", true, equimentena,
						"Equipment Button Enable");

			}
		} else {
			PropertiesCommonMethods.cTestReports("Equipment Button Visibilty", true, equiment,
					"Equipment Button Visibilty");

		}
	}

//	Navigate PlantEquipment
	public static void navigatePlantEquipment() {
		PageFactory.initElements(driver, np);
		boolean pequiment = NavigationPage.PlantEquipment.isDisplayed();
		if (pequiment) {
			boolean pequimentena = NavigationPage.PlantEquipment.isEnabled();
			if (pequimentena) {
				NavigationPage.PlantEquipment.click();
				plntEquipmentclick = true;
			} else {
				PropertiesCommonMethods.cTestReports("Plant Equipment Button Enable", true, pequimentena,
						"Plant Equipment Button Enable");

			}
		} else {
			PropertiesCommonMethods.cTestReports("Plant Equipment Button Visible", true, pequiment,
					"Plant Equipment Button Visible");

		}

	}

	public static boolean matmaincat = false;
	public static boolean clickMaterial = false;
	public static boolean clickSource = false;
	public static boolean clickRole = false;
	public static boolean clickEmployee = false;
	public static boolean clickUser = false;

//	Navigate MaterialMainCategory
	public static void navigateMaterialMainCategory() throws InterruptedException {
		PageFactory.initElements(driver, np);
		Thread.sleep(2000);
		try {
			NavigationPage.MaterialMainCategory.click();
			matmaincat = true;
		} catch (Exception e) {

		}
	}

//	Navigate MaterialSubCategory
	public static void navigateMaterialSubCategory() {
		PageFactory.initElements(driver, np);
		MultiSearchMethods.BtnVisible = true;
		MultiSearchMethods.BtnEnable = true;
		clicksubCategory = false;
		try {

			MultiSearchMethods.Buttons(NavigationPage.MaterialSubCategory, "Material Sub Category");
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {

				NavigationPage.MaterialSubCategory.click();
				clicksubCategory = true;
			}
		} catch (Exception e) {
			testCase = extent.createTest("material sub Click");
			testCase.log(Status.INFO, "material sub Not Clicked");
			testCase.log(Status.FAIL, "Clicked Fail");
		}
	}

//	Navigate MaterialState
	public static void navigateMaterialState() throws InterruptedException {
		PageFactory.initElements(driver, np);
		Thread.sleep(2000);
		try {
			NavigationPage.MaterialState.click();
			clickMaterialState = true;
		} catch (Exception e) {
			testCase = extent.createTest("material state Click");
			testCase.log(Status.INFO, "material state Not Clicked");
			testCase.log(Status.FAIL, "Clicked Fail");
		}
	}

//	Navigate Source
	public static void navigateSource() throws InterruptedException {
		PageFactory.initElements(driver, np);
		Thread.sleep(2000);
		try {
			NavigationPage.Source.click();
			clickSource = true;
		} catch (Exception e) {
			testCase = extent.createTest("Source Click");
			testCase.log(Status.INFO, "source Not Clicked");
			testCase.log(Status.FAIL, "Clicked Fail");
		}
	}

//	Navigate Material
	public static void navigateMaterial() throws InterruptedException {

		PageFactory.initElements(driver, np);
		boolean materialdis = NavigationPage.Material.isDisplayed();
		if (materialdis) {
			boolean materialena = NavigationPage.Material.isEnabled();
			if (materialena) {
				NavigationPage.Material.click();
				clickMaterial = true;
			} else {
				PropertiesCommonMethods.cTestReports("Material Button Enable", true, materialena,
						"Material Button Enable");

			}
		} else {
			PropertiesCommonMethods.cTestReports("Material Button Visible", true, materialdis,
					"Material Button Visible");

		}
	}

//	Navigate Unit
	public static void navigateUnit() throws InterruptedException {
		PageFactory.initElements(driver, np);
		clickUnit = false;
		MultiSearchMethods.BtnVisible = true;
		MultiSearchMethods.BtnEnable = true;

		try {

			MultiSearchMethods.Buttons(NavigationPage.Unit, "UNIT");
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
				NavigationPage.Unit.click();
				clickUnit = true;
			}
		} catch (Exception e) {
			clickUnit = false;
			testCase = extent.createTest("Unit Click");
			testCase.log(Status.INFO, "Unit Not Clicked");
			testCase.log(Status.FAIL, "Clicked Fail");
		}
	}

//	Navigate Customer
	public static void navigateCustomer(){
		PageFactory.initElements(driver, np);
		clickCustomer = false;
		MultiSearchMethods.BtnVisible = true;
		MultiSearchMethods.BtnEnable = true;

		try {

			MultiSearchMethods.Buttons(NavigationPage.Customer, "Customer");
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
				NavigationPage.Customer.click();
				clickCustomer = true;
			}
		} catch (Exception e) {
			clickCustomer = false;
			testCase = extent.createTest("Customer Click");
			testCase.log(Status.INFO, "Customer Not Clicked");
			testCase.log(Status.FAIL, "Clicked Fail");
		}

	}

//	Navigate Project
	public static void navigateProject() throws InterruptedException {
		PageFactory.initElements(driver, np);
		clickProject = false;
		MultiSearchMethods.BtnVisible = true;
		MultiSearchMethods.BtnEnable = true;

		try {

			MultiSearchMethods.Buttons(NavigationPage.Project, "Project");
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
				NavigationPage.Project.click();
				clickProject = true;
			}
		} catch (Exception e) {
			clickProject = false;
			testCase = extent.createTest("Customer Click");
			testCase.log(Status.INFO, "Customer Not Clicked");
			testCase.log(Status.FAIL, "Clicked Fail");
		}

	}

//	Navigate Delivery
	public static void navigateDelivery() throws InterruptedException {
		PageFactory.initElements(driver, np);

		clickDelivery = false;
		MultiSearchMethods.BtnVisible = true;
		MultiSearchMethods.BtnEnable = true;

		try {

			MultiSearchMethods.Buttons(NavigationPage.Delivery, "Delivery");
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
				NavigationPage.Delivery.click();
				clickDelivery = true;
			}
		} catch (Exception e) {
			clickDelivery = false;
			testCase = extent.createTest("Delivery Click");
			testCase.log(Status.INFO, "Dleivery Not Clicked");
			testCase.log(Status.FAIL, "Clicked Fail");
		}

	}

//	Navigate SupplierCategory
	public static void navigateSupplierCategory() throws InterruptedException {
		PageFactory.initElements(driver, np);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(NavigationPage.SupplierCategory));
		} catch (Exception e) {

		}

		boolean viseq = NavigationPage.SupplierCategory.isDisplayed();
		if (viseq) {
			boolean enableq = NavigationPage.SupplierCategory.isEnabled();
			if (enableq) {
				NavigationPage.SupplierCategory.click();
				mainSupplierCategory = true;
			} else {
				PropertiesCommonMethods.cTestReports("Supplier Category Button Enable", true, enableq,
						"Supplier Category Button Enable");

			}
		} else {
			PropertiesCommonMethods.cTestReports("Supplier Category Button Visibilty", true, viseq,
					"Supplier Category Button Visibilty");
		}
	}

//	Navigate Supplier
	public static void navigateSupplier() {
		PageFactory.initElements(driver, np);
		supplierClick = false;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(NavigationPage.Supplier));
		} catch (Exception e) {

		}

		boolean viseq = NavigationPage.Supplier.isDisplayed();
		if (viseq) {
			boolean enableq = NavigationPage.Supplier.isEnabled();
			if (enableq) {
				NavigationPage.Supplier.click();
				supplierClick = true;
			} else {
				PropertiesCommonMethods.cTestReports("Supplier Button Enable", true, enableq, "Supplier Button Enable");

			}
		} else {
			PropertiesCommonMethods.cTestReports("Supplier Button Visibilty", true, viseq, "Supplier Button Visibilty");
		}
	}

//	Navigate Designation
	public static void navigateDesignation() throws InterruptedException {
		PageFactory.initElements(driver, np);
		Thread.sleep(2000);
		try {
			NavigationPage.Designation.click();
			clickDesignation = true;
		} catch (Exception e) {
			testCase = extent.createTest("designation Click");
			testCase.log(Status.INFO, "Designation Not Clicked");
			testCase.log(Status.FAIL, "Clicked Fail");
		}
	}

//	Navigate Role
	public static void navigateRole() throws InterruptedException {
		PageFactory.initElements(driver, np);
		Thread.sleep(2000);
		try {
			NavigationPage.Role.click();
			clickRole = true;
		} catch (Exception e) {
			testCase = extent.createTest("Role Click");
			testCase.log(Status.INFO, "Role Not Clicked");
			testCase.log(Status.FAIL, "Clicked Fail");
		}
	}

//	Navigate Employee
	public static void navigateEmployee() throws InterruptedException{
		PageFactory.initElements(driver, np);
		Thread.sleep(2000);
		try {
			NavigationPage.Employee.click();
			clickEmployee = true;
		} catch (Exception e) {
			testCase = extent.createTest("employee Click");
			testCase.log(Status.INFO, "employee Not Clicked");
			testCase.log(Status.FAIL, "Clicked Fail");
		}
	}

//	Navigate User
	public static void navigateUser(){
		PageFactory.initElements(driver, np);
		MultiSearchMethods.BtnVisible = true;
		MultiSearchMethods.BtnEnable = true;

		try {

			MultiSearchMethods.Buttons(NavigationPage.User, "User");
			if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
				NavigationPage.User.click();
				clickUser = true;
			}
		} catch (Exception e) {
			clickUser = false;
			testCase = extent.createTest("User Click");
			testCase.log(Status.INFO, "User Not Clicked");
			testCase.log(Status.FAIL, "Clicked Fail");
		}
	}

}
