/***********************************************************************************
* Description
*------------
* PLANTEQUIPMENT METODS
***********************************************************************************
*
* Author           : VITHUSHA MOHAN
* Date Written     : 07/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*                        07/04/2023   VITHUSHA.M    Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testcases.plantequipment;

import static org.testng.Assert.assertEquals;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.Equipment.EquipmentEditPageWise;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class PlantEquipmentAddMethods extends DriverIntialization {
//	public static boolean addPlantEquipment=false;
//	static PlantEquipmentPage equipmentPage = new PlantEquipmentPage();
//	static EquipmentPage equip = new EquipmentPage();
//	static SourcePage page = new SourcePage();
//	static PlantEquipmentMultipleSearchMethods equipmentMultipleSearchMethods = new PlantEquipmentMultipleSearchMethods();
//	EquipmentEditPageWise editPageWise = new EquipmentEditPageWise();
//	public static String excelpath = System.getProperty("user.dir")
//			+ "\\src\\test\\resources\\Excel\\Master Module.xlsx";
//	public static String TCPLANT0045 = System.getProperty("user.dir")
//			+ "src\\test\\resources\\Excel\\Plant\\Functionality\\PlantDescriptionCheck.xlsx";
//	public static ArrayList<String> equipData=new ArrayList<String>();
	public static boolean addPlantEquipment = false;
	static PlantEquipmentPage equipmentPage = new PlantEquipmentPage();
	static EquipmentPage equip = new EquipmentPage();
	static SourcePage page = new SourcePage();
//	static PlantEquipmentMultipleSearchMethods equipmentMultipleSearchMethods = new PlantEquipmentMultipleSearchMethods();
	EquipmentEditPageWise editPageWise = new EquipmentEditPageWise();
	public static String excelpath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Excel\\Master Module.xlsx";
	public static String TCPLANT0045 = System.getProperty("user.dir")
			+ "src\\test\\resources\\Excel\\Plant\\Functionality\\PlantDescriptionCheck.xlsx";

	public static void plantEquipmentAddButtonUI() throws InterruptedException {
		PageFactory.initElements(driver, equipmentPage);
		WebDriverWait wait = new WebDriverWait(driver, 5);

		try {
			wait.until(ExpectedConditions.elementToBeClickable(PlantEquipmentPage.AddPlantEquipment));
		} catch (Exception e) {
		}

		boolean ActualElement = PlantEquipmentPage.AddPlantEquipment.isDisplayed();
		if (ActualElement) {
			boolean ena = PlantEquipmentPage.AddPlantEquipment.isEnabled();
			if (ena) {
				try {
					PlantEquipmentPage.AddPlantEquipment.click();
					addPlantEquipment = true;
				} catch (Exception e) {
					addPlantEquipment = false;
					PropertiesCommonMethods.cTestReports("Add Plant Equipment Button Click", true, false, e.toString());
				}

			} else {
				PropertiesCommonMethods.cTestReports("Add Plant Equipment Button Visible", true, ena,
						"Plant Equipment Button Visible");
			}

		} else {
			PropertiesCommonMethods.cTestReports("Add Plant Equipment Button Visible", true, ActualElement,
					"Plant Equipment Button Visible");
		}

	}

	public static void plantEquipmentSendValues() throws InterruptedException {
		PlantEquipmentAddMethods.dataFromPlanEqupment("Plant Equipment", "TC-PLA-EQU-0078-01");
		ArrayList<String> errm = new ArrayList<String>();
		WebDriverWait wait = new WebDriverWait(driver, 6);

		String plant = PlantEquipmentAddMethods.equipData.get(0);
		String equipment = PlantEquipmentAddMethods.equipData.get(1);
		String serialNo = PlantEquipmentAddMethods.equipData.get(2);
		String brand = PlantEquipmentAddMethods.equipData.get(3);
		String Model = PlantEquipmentAddMethods.equipData.get(4);
		String Type = PlantEquipmentAddMethods.equipData.get(5);
		String FormatNo = PlantEquipmentAddMethods.equipData.get(6);
		String Description = PlantEquipmentAddMethods.equipData.get(7);
		String Calibration = PlantEquipmentAddMethods.equipData.get(8);
		System.out.println("Description" + Calibration);

		// Fill Plant Text Box
//			PlantEquipmentPage.Plant_INPUT
		ActionCommonMethod.visbleEnable(PlantEquipmentPage.plant_INPUT, "Plant Text Box");
		if (ActionCommonMethod.enable) {
			try {
				PlantEquipmentPage.plant_INPUT.click();
				ActionCommonMethod.dropDown("//div[@id='plant_list']/../div[1]", plant, "plant_list");
			} catch (Exception e) {
				String[] x = e.toString().split(":");
				PropertiesCommonMethods.cTestReports("Plant Text Box Fill", true, false, x[1]);
			}

		}

//Fill Equipment text Box
		ActionCommonMethod.visbleEnable(PlantEquipmentPage.Equipmentform, "Equipment Text Box");
		if (ActionCommonMethod.enable) {
			try {
				PlantEquipmentPage.Equipmentform.click();
				ActionCommonMethod.dropDown("//div[@id='equipment_list']/div[1]", equipment, "equipment_list");
			} catch (Exception e) {
				String[] x = e.toString().split(":");
				PropertiesCommonMethods.cTestReports("Equipment Text Box Fill", true, false, x[1]);
			}
		}

//			fill Serial No Text Bpx	
		ActionCommonMethod.visbleEnable(PlantEquipmentPage.Serialno, "Serial No Text Box");
		if (ActionCommonMethod.enable) {
			try {
				PlantEquipmentPage.Serialno.sendKeys(String.valueOf(serialNo));
			} catch (Exception e) {
				String[] x = e.toString().split(":");
				PropertiesCommonMethods.cTestReports("Serial Text Box Fill", true, false, x[1]);
			}
		}

//			Fill Brand Text Box
		ActionCommonMethod.visbleEnable(PlantEquipmentPage.BrandName, "Brand Text Box");
		if (ActionCommonMethod.enable) {
			try {
				PlantEquipmentPage.BrandName.sendKeys(brand);
			} catch (Exception e) {
				String[] x = e.toString().split(":");
				PropertiesCommonMethods.cTestReports("Brand Text Box Fill", true, false, x[1]);
			}
		}
//			Fill Modal Text Box
		ActionCommonMethod.visbleEnable(PlantEquipmentPage.Model, "Model Text Box");
		if (ActionCommonMethod.enable) {
			try {
				PlantEquipmentPage.Model.sendKeys(Model);
			} catch (Exception e) {
				String[] x = e.toString().split(":");
				PropertiesCommonMethods.cTestReports("Modal Text Box Fill", true, false, x[1]);
			}
		}

		ActionCommonMethod.visbleEnable(PlantEquipmentPage.Type, "Type Text Box");
		if (ActionCommonMethod.enable) {
			try {
				PlantEquipmentPage.Type.click();
				ActionCommonMethod.dropDown("//div[@id='equipmentType_list']/div[1]", Type, "equipmentType_list");
			} catch (Exception e) {
				String[] x = e.toString().split(":");
				PropertiesCommonMethods.cTestReports("Type Text Box Fill", true, false, x[1]);
			}
		}

		ActionCommonMethod.visbleEnable(PlantEquipmentPage.FormatNo, "Format Text Box");
		if (ActionCommonMethod.enable) {
			try {
				PlantEquipmentPage.FormatNo.sendKeys(FormatNo);
			} catch (Exception e) {
				String[] x = e.toString().split(":");
				PropertiesCommonMethods.cTestReports("Format NO Text Box Fill", true, false, x[1]);
			}
		}

		ActionCommonMethod.visbleEnable(PlantEquipmentPage.Description, "Description Text Box");
		if (ActionCommonMethod.enable) {
			try {
				PlantEquipmentPage.Description.sendKeys(Description);
			} catch (Exception e) {
				String[] x = e.toString().split(":");
				PropertiesCommonMethods.cTestReports("Description Text Box Fill", true, false, x[1]

				);
			}
		}

		if (Calibration.equals("true")) {

			ActionCommonMethod.visbleEnable(PlantEquipmentPage.clabration, "Relevant Calibration Check Box");
			if (ActionCommonMethod.enable) {
				try {
					PlantEquipmentPage.clabration.click();
				} catch (Exception e) {
					String[] x = e.toString().split(":");
					PropertiesCommonMethods.cTestReports("Relevant Calibration Check Box Fill", true, false, x[1]

					);
				}
			}

		}
		boolean cli = false;
		ActionCommonMethod.visbleEnable(PlantEquipmentPage.SaveButton, "Save Button");
		if (ActionCommonMethod.enable) {
			try {
				PlantEquipmentPage.SaveButton.click();
				cli = true;
			} catch (Exception e) {
				cli = false;
				String[] x = e.toString().split(":");
				PropertiesCommonMethods.cTestReports("Save Button", true, false, x[1]);
			}
		}

		if (cli == true) {

			boolean con = false;
			try {
				wait.until(ExpectedConditions.invisibilityOf(PlantEquipmentPage.Serialno));
				con = true;
			} catch (Exception e) {
				con = false;
				// TODO: handle exception
			}

			if (con) {

				try {
					PlantEquipmentAddMethods.checkAfterAdd();
				} catch (Exception e) {
				}
			} else {
				errm.clear();

				int I;
				try {
					I = driver
							.findElements(By
									.xpath("//div[@style='color: red; font-size: 12px; width: 200px; height: 0.2px;']"))
							.size();
				} catch (Exception e) {
					I = 0;
				}

				for (int j = 1; j <= I; j++) {

					try {
						String err = driver.findElement(
								By.xpath("(//div[@style='color: red; font-size: 12px; width: 200px; height: 0.2px;'])["
										+ j + "]"))
								.getText();

						if (err.replace(" ", "").isEmpty()) {

						} else {
							errm.add(err);
						}
					} catch (Exception e) {
						// TODO: handle exception
					}

				}
				try {
//					System.out.println(errm);

					extent.createTest(errm.get(0) + " Validation While Saving Plant Equipment Add Not Complete ⚠️");
				} catch (Exception e) {
					extent.createTest("Plant Equipment Add Not Complete ⚠️");
				}

				materialMethodes.validationconfirm("", "", "Plant Equipment Add");
			}

		}

	}

	// AddPlantEquipment SAVE BUTTON PROPERTIES
	// --------------------------------------------------

	public static void plantEquipmentSaveButtonUI() throws InterruptedException {
		PageFactory.initElements(driver, equipmentPage);
		// check if element visible
		testCase = extent.createTest("CHECKING THE \"AddPlantEquipment-SAVE\" BUTTON PROPERTIES");
		boolean ActualElement = PlantEquipmentPage.SaveButton.isDisplayed();
		boolean ExpectedElement = true;

		boolean visibility = true;
		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-VISIBILITY");
		try {
			AssertJUnit.assertEquals(ActualElement, ExpectedElement);

		} catch (AssertionError e) {

			visibility = false;

//				        	  throw(e);
		}
		if (visibility) {
			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
			testCase.log(Status.PASS, "Correct Element");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
			testCase.log(Status.FAIL, "No element");

		}

		// check position

		Point ActualLocation = PlantEquipmentPage.SaveButton.getLocation();

		int actual_x = ActualLocation.getX();
		int actual_y = ActualLocation.getY();

		System.out.println("X axis: " + actual_x);
		System.out.println("Y axis: " + actual_y);

		Point ExpectedLocation = new Point(1023, 559);

		boolean Position = true;
		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-POSITION");
		try {
			AssertJUnit.assertEquals(ActualLocation, ExpectedLocation);

		} catch (AssertionError e) {
			Position = false;
		}
		if (Position) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualLocation);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedLocation);
			testCase.log(Status.PASS, "Correct Location");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualLocation);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedLocation);
			testCase.log(Status.FAIL, "Wrong Location");
		}

//						 check font size

		String ActualFontSize = PlantEquipmentPage.SaveButton.getCssValue("font-size");
		System.out.println("Font Size: " + ActualFontSize);
		String ExpectedFontSize = "14px";

		boolean Fontsize = true;
		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-FONT-SIZE");
		try {
			AssertJUnit.assertEquals(ActualFontSize, ExpectedFontSize);

		} catch (AssertionError e) {
			Fontsize = false;
		}
		if (Fontsize) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualFontSize);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedFontSize);
			testCase.log(Status.PASS, "Correct Font Size");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualFontSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedFontSize);
			testCase.log(Status.FAIL, "Wrong Font Size");
		}

//						 check the size 

		Dimension ActualSize = PlantEquipmentPage.SaveButton.getSize();
		System.out.println("Size : " + ActualSize);
		Dimension ExpectedSize = new Dimension(30, 22);

		boolean size = true;
		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-SIZE");
		try {
			AssertJUnit.assertEquals(ActualSize, ExpectedSize);

		} catch (AssertionError e) {
			size = false;
		}
		if (size) {
			testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
			testCase.log(Status.PASS, "Correct Size");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
			testCase.log(Status.FAIL, "Wrong Size");
		}

//				            check the enable

		boolean ActualElementEnable = PlantEquipmentPage.SaveButton.isEnabled();
		boolean ExpectedElementEnable = true;

		boolean enablity = true;
		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-ENABLE");
		try {
			AssertJUnit.assertEquals(ActualElementEnable, ExpectedElementEnable);

		} catch (AssertionError e) {
			enablity = false;
		}
		if (enablity) {
			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
			testCase.log(Status.PASS, "Element enable");
		} else {
			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
			testCase.log(Status.FAIL, "Element is not enable");
		}

//				            check the button color

		String ActualButtonColor = PlantEquipmentPage.SaveButton.getCssValue("background-color");
		System.out.println("rgb :" + ActualButtonColor);

		String ExpectedButtonColor = "rgba(0, 0, 0, 0)";

		boolean buttoncolor = true;
		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-COLOR");
		try {
			AssertJUnit.assertEquals(ActualButtonColor, ExpectedButtonColor);

		} catch (AssertionError e) {
			buttoncolor = false;
		}
		if (buttoncolor) {
			testCase.log(Status.INFO, "ActualButtonColor :- " + ActualButtonColor);
			testCase.log(Status.INFO, "ExpectedButtonColor :- " + ExpectedButtonColor);
			testCase.log(Status.PASS, "Correct Button Color");
		} else {
			testCase.log(Status.INFO, "ActualButtonColor :- " + ActualButtonColor);
			testCase.log(Status.INFO, "ExpectedButtonColor :- " + ExpectedButtonColor);
			testCase.log(Status.FAIL, "Wrong Button Color");
		}
	}

////				            check the border color
//
//	public static void plantEquipmentAddButtonUI() throws InterruptedException {
//		PageFactory.initElements(driver, equipmentPage);
//		WebDriverWait wait =new WebDriverWait(driver, 5);
//		
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(PlantEquipmentPage.AddPlantEquipment));
//		} catch (Exception e) {
//		}
//		
//		boolean ActualElement = PlantEquipmentPage.AddPlantEquipment.isDisplayed();
//		if (ActualElement) {
//			boolean ena = PlantEquipmentPage.AddPlantEquipment.isEnabled();
//		if (ena) {
//			try {
//				PlantEquipmentPage.AddPlantEquipment.click();
//				addPlantEquipment=true;
//			} catch (Exception e) {
//				addPlantEquipment=false;
//				PropertiesCommonMethods.cTestReports("Add Plant Equipment Button Click", true, false, e.toString());
//			}
//			
//		}else {
//			PropertiesCommonMethods.cTestReports("Add Plant Equipment Button Visible", true, ena, "Plant Equipment Button Visible");
//		}
//			
//		}else {
//			PropertiesCommonMethods.cTestReports("Add Plant Equipment Button Visible", true, ActualElement, "Plant Equipment Button Visible");
//		}
//
//	}
//
//	public static void plantEquipmentSendValues()  {
//		PlantEquipmentAddMethods.dataFromPlanEqupment("Plant Equipment", "TC-PLA-EQU-0078-01");
//		ArrayList<String> errm=  new ArrayList<String>();
//		WebDriverWait wait=new WebDriverWait(driver, 6);
//
//
//			String plant = PlantEquipmentAddMethods.equipData.get(0);
//			String equipment = PlantEquipmentAddMethods.equipData.get(1);
//			String serialNo =  PlantEquipmentAddMethods.equipData.get(2);
//			String brand =  PlantEquipmentAddMethods.equipData.get(3);
//			String Model =  PlantEquipmentAddMethods.equipData.get(4);
//			String Type =  PlantEquipmentAddMethods.equipData.get(5);
//			String FormatNo =  PlantEquipmentAddMethods.equipData.get(6);
//			String Description =  PlantEquipmentAddMethods.equipData.get(7);
//			String Calibration =  PlantEquipmentAddMethods.equipData.get(8);
//			System.out.println("Description" + Calibration);
//			
//			//Fill Plant Text Box
////			PlantEquipmentPage.Plant_INPUT
//			ActionCommonMethod.visbleEnable(PlantEquipmentPage.plant_INPUT, "Plant Text Box");
//			if (ActionCommonMethod.enable) {
//				try {
//					PlantEquipmentPage.plant_INPUT.click();
//					ActionCommonMethod.dropDown("//div[@id='plant_list']/../div[1]", plant, "plant_list");
//				} catch (Exception e) {
//					PropertiesCommonMethods.cTestReports("Plant Text Box Fill", true, false, e.toString());
//				}
//				
//			}
//			
////Fill Equipment text Box
//			ActionCommonMethod.visbleEnable(PlantEquipmentPage.Equipmentform, "Equipment Text Box");
//			if (ActionCommonMethod.enable) {
//				try {
//					PlantEquipmentPage.Equipmentform.click();
//					ActionCommonMethod.dropDown("//div[@id='equipment_list']/div[1]", equipment, "equipment_list");
//				} catch (Exception e) {
//					PropertiesCommonMethods.cTestReports("Equipment Text Box Fill", true, false, e.toString());
//				}
//			}
//			
//			
////			fill Serial No Text Bpx	
//			ActionCommonMethod.visbleEnable(PlantEquipmentPage.Serialno, "Serial No Text Box");
//			if (ActionCommonMethod.enable) {
//				try {
//					PlantEquipmentPage.Serialno.sendKeys(String.valueOf(serialNo));
//				} catch (Exception e) {
//					String[] x= e.toString().split(":");
//					PropertiesCommonMethods.cTestReports("Serial Text Box Fill", true, false, x[1]);
//				}
//			}
//			
////			Fill Brand Text Box
//			ActionCommonMethod.visbleEnable(PlantEquipmentPage.BrandName, "Brand Text Box");
//			if (ActionCommonMethod.enable) {
//				try {
//					PlantEquipmentPage.BrandName.sendKeys(brand);
//				} catch (Exception e) {
//					String[] x= e.toString().split(":");
//					PropertiesCommonMethods.cTestReports("Brand Text Box Fill", true, false, x[1]);				}
//			}
////			Fill Modal Text Box
//			ActionCommonMethod.visbleEnable(PlantEquipmentPage.Model, "Model Text Box");
//			if (ActionCommonMethod.enable) {
//				try {
//					PlantEquipmentPage.Model.sendKeys(Model);
//				} catch (Exception e) {
//					String[] x= e.toString().split(":");
//					PropertiesCommonMethods.cTestReports("Modal Text Box Fill", true, false, x[1]);
//				}			}		
//			
//			ActionCommonMethod.visbleEnable(PlantEquipmentPage.Type, "Type Text Box");
//			if (ActionCommonMethod.enable) {
//				try {
//					PlantEquipmentPage.Type.click();
//					ActionCommonMethod.dropDown("//div[@id='equipmentType_list']/div[1]", Type,
//							"equipmentType_list");
//				} catch (Exception e) {
//					String[] x= e.toString().split(":");
//					PropertiesCommonMethods.cTestReports("Type Text Box Fill", true, false, x[1]);
//				}
//			}
//			
//			ActionCommonMethod.visbleEnable(PlantEquipmentPage.FormatNo, "Format Text Box");
//			if (ActionCommonMethod.enable) {
//				try {
//					PlantEquipmentPage.FormatNo.sendKeys(FormatNo);
//				} catch (Exception e) {
//					String[] x= e.toString().split(":");
//					PropertiesCommonMethods.cTestReports("Format NO Text Box Fill", true, false, x[1]);
//				}
//				}	
//			
//			ActionCommonMethod.visbleEnable(PlantEquipmentPage.Description, "Description Text Box");
//			if (ActionCommonMethod.enable) {
//				try {
//					PlantEquipmentPage.Description.sendKeys(Description);
//				} catch (Exception e) {
//					String[] x= e.toString().split(":");
//					PropertiesCommonMethods.cTestReports("Description Text Box Fill", true, false,x[1]
//							
//						);
//				}				}
//			
//			if (Calibration.equals("true")) {
//				
//				ActionCommonMethod.visbleEnable(PlantEquipmentPage.clabration, "Relevant Calibration Check Box");
//				if (ActionCommonMethod.enable) {
//					try {
//						PlantEquipmentPage.clabration.click();
//					} catch (Exception e) {
//						String[] x= e.toString().split(":");
//						PropertiesCommonMethods.cTestReports("Relevant Calibration Check Box Fill", true, false,x[1]
//								
//							);
//					}				}
//				
//			}
//			boolean cli=false;
//			ActionCommonMethod.visbleEnable(PlantEquipmentPage.SaveButton, "Save Button");
//			if (ActionCommonMethod.enable) {
//				try {
//					PlantEquipmentPage.SaveButton.click();
//					cli=true;
//				} catch (Exception e) {
//					cli=false;
//					String[] x= e.toString().split(":");
//					PropertiesCommonMethods.cTestReports("Save Button", true, false,x[1]);
//				}}
//			
//			if (cli==true) {
//				
//				boolean con =false;
//				try {
//					wait.until(ExpectedConditions.invisibilityOf(PlantEquipmentPage.Serialno));
//					con =true;
//				} catch (Exception e) {
//					con =false;
//					// TODO: handle exception
//				}
//				
//				if (con) {
//					
//					try {
//						PlantEquipmentAddMethods.checkAfterAdd();
//					} catch (Exception e) {
//					}
//				}
//				else {
//					errm.clear();
//					
//				int I;
//				try {
//					I = driver
//							.findElements(By
//									.xpath("//div[@style='color: red; font-size: 12px; width: 200px; height: 0.2px;']"))
//							.size();
//				} catch (Exception e) {
//					I=0;
//				}
//				
//				for (int j = 1; j <= I; j++) {
//					
//					try {
//						String err = driver
//								.findElement(By.xpath(
//										"(//div[@style='color: red; font-size: 12px; width: 200px; height: 0.2px;'])["+j+"]"))
//								.getText();
//						
//						if (err.replace(" ", "").isEmpty()) {
//							
//							
//						}
//						else {
//							errm.add(err);
//						}
//					} catch (Exception e) {
//						// TODO: handle exception
//					}
//					
//					
//				}
//				try {
////					System.out.println(errm);
//					
//					extent.createTest(errm.get(0) + "Validation While Saving Plant Equipment Add Not Complete ⚠️");
//				} catch (Exception e) {
//					extent.createTest("Plant Equipment Add Not Complete ⚠️");
//				}
//				
//				}
//				
//				
//			}
//			
//		
//
//	}
//
//	// AddPlantEquipment SAVE BUTTON PROPERTIES
//	// --------------------------------------------------
//
//	public static void plantEquipmentSaveButtonUI() throws InterruptedException {
//		PageFactory.initElements(driver, equipmentPage);
//		// check if element visible
//		testCase = extent.createTest("CHECKING THE \"AddPlantEquipment-SAVE\" BUTTON PROPERTIES");
//		boolean ActualElement = PlantEquipmentPage.SaveButton.isDisplayed();
//		boolean ExpectedElement = true;
//
//		boolean visibility = true;
//		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-VISIBILITY");
//		try {
//			AssertJUnit.assertEquals(ActualElement, ExpectedElement);
//
//		} catch (AssertionError e) {
//
//			visibility = false;
//
////				        	  throw(e);
//		}
//		if (visibility) {
//			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
//			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
//			testCase.log(Status.PASS, "Correct Element");
//		} else {
//			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
//			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
//			testCase.log(Status.FAIL, "No element");
//
//		}
//
//		// check position
//
//		Point ActualLocation = PlantEquipmentPage.SaveButton.getLocation();
//
//		int actual_x = ActualLocation.getX();
//		int actual_y = ActualLocation.getY();
//
//		System.out.println("X axis: " + actual_x);
//		System.out.println("Y axis: " + actual_y);
//
//		Point ExpectedLocation = new Point(1023, 559);
//
//		boolean Position = true;
//		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-POSITION");
//		try {
//			AssertJUnit.assertEquals(ActualLocation, ExpectedLocation);
//
//		} catch (AssertionError e) {
//			Position = false;
//		}
//		if (Position) {
//			testCase.log(Status.INFO, "ActualFontSize :- " + ActualLocation);
//			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedLocation);
//			testCase.log(Status.PASS, "Correct Location");
//		} else {
//			testCase.log(Status.INFO, "ActualSize :- " + ActualLocation);
//			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedLocation);
//			testCase.log(Status.FAIL, "Wrong Location");
//		}
//
////						 check font size
//
//		String ActualFontSize = PlantEquipmentPage.SaveButton.getCssValue("font-size");
//		System.out.println("Font Size: " + ActualFontSize);
//		String ExpectedFontSize = "14px";
//
//		boolean Fontsize = true;
//		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-FONT-SIZE");
//		try {
//			AssertJUnit.assertEquals(ActualFontSize, ExpectedFontSize);
//
//		} catch (AssertionError e) {
//			Fontsize = false;
//		}
//		if (Fontsize) {
//			testCase.log(Status.INFO, "ActualFontSize :- " + ActualFontSize);
//			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedFontSize);
//			testCase.log(Status.PASS, "Correct Font Size");
//		} else {
//			testCase.log(Status.INFO, "ActualSize :- " + ActualFontSize);
//			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedFontSize);
//			testCase.log(Status.FAIL, "Wrong Font Size");
//		}
//
////						 check the size 
//
//		Dimension ActualSize = PlantEquipmentPage.SaveButton.getSize();
//		System.out.println("Size : " + ActualSize);
//		Dimension ExpectedSize = new Dimension(30, 22);
//
//		boolean size = true;
//		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-SIZE");
//		try {
//			AssertJUnit.assertEquals(ActualSize, ExpectedSize);
//
//		} catch (AssertionError e) {
//			size = false;
//		}
//		if (size) {
//			testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
//			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
//			testCase.log(Status.PASS, "Correct Size");
//		} else {
//			testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
//			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
//			testCase.log(Status.FAIL, "Wrong Size");
//		}
//
////				            check the enable
//
//		boolean ActualElementEnable = PlantEquipmentPage.SaveButton.isEnabled();
//		boolean ExpectedElementEnable = true;
//
//		boolean enablity = true;
//		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-ENABLE");
//		try {
//			AssertJUnit.assertEquals(ActualElementEnable, ExpectedElementEnable);
//
//		} catch (AssertionError e) {
//			enablity = false;
//		}
//		if (enablity) {
//			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
//			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
//			testCase.log(Status.PASS, "Element enable");
//		} else {
//			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
//			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
//			testCase.log(Status.FAIL, "Element is not enable");
//		}
//
////				            check the button color
//
//		String ActualButtonColor = PlantEquipmentPage.SaveButton.getCssValue("background-color");
//		System.out.println("rgb :" + ActualButtonColor);
//
//		String ExpectedButtonColor = "rgba(0, 0, 0, 0)";
//
//		boolean buttoncolor = true;
//		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-COLOR");
//		try {
//			AssertJUnit.assertEquals(ActualButtonColor, ExpectedButtonColor);
//
//		} catch (AssertionError e) {
//			buttoncolor = false;
//		}
//		if (buttoncolor) {
//			testCase.log(Status.INFO, "ActualButtonColor :- " + ActualButtonColor);
//			testCase.log(Status.INFO, "ExpectedButtonColor :- " + ExpectedButtonColor);
//			testCase.log(Status.PASS, "Correct Button Color");
//		} else {
//			testCase.log(Status.INFO, "ActualButtonColor :- " + ActualButtonColor);
//			testCase.log(Status.INFO, "ExpectedButtonColor :- " + ExpectedButtonColor);
//			testCase.log(Status.FAIL, "Wrong Button Color");
//		}
//
//////				            check the border color
////
////			String ActualBorderColor = PlantEquipmentPage.SaveButton.getCssValue("border-colour");
////			System.out.println("rgb :" + ActualBorderColor);
////
////			String ExpectedBorderColor = " ";
////
////			boolean bordercolor = true;
////			testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-BORDER-COLOR");
////			try {
////				AssertJUnit.assertEquals(ActualBorderColor,ExpectedBorderColor);
////
////			} catch (AssertionError e) {
////				bordercolor = false;
////			}
////			if (bordercolor) {
////				testCase.log(Status.INFO, "ActualBorderColor :- " + ActualBorderColor);
////				testCase.log(Status.INFO, "ExpectedBorderColor :- " + ExpectedBorderColor);
////				testCase.log(Status.PASS, "Correct Border Color");
////			} else {
////				testCase.log(Status.INFO, "ActualBorderColor :- " + ActualBorderColor);
////				testCase.log(Status.INFO, "ExpectedBorderColor :- " + ExpectedBorderColor);
////				testCase.log(Status.FAIL, "Wrong Border Color");
////			}
////			Thread.sleep(1000);
//
////				            check the font type 
//
//		String ActualFontType = PlantEquipmentPage.SaveButton.getCssValue("font-type");
//		System.out.println("Font type: " + ActualFontType);
//
//		String ExpectedFontType = "";
//
//		// input[@id='sub_business_unit']
//
//		boolean fonttype = true;
//		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-FONT-TYPE");
//		try {
//			AssertJUnit.assertEquals(ActualFontType, ExpectedFontType);
//
//		} catch (AssertionError e) {
//			fonttype = false;
//		}
//		if (fonttype) {
//			testCase.log(Status.INFO, "ActualFontType :- " + ActualFontType);
//			testCase.log(Status.INFO, "ExpectedFontType :- " + ExpectedFontType);
//			testCase.log(Status.PASS, "Correct Font Type");
//		} else {
//			testCase.log(Status.INFO, "ActualFontType :- " + ActualFontType);
//			testCase.log(Status.INFO, "ExpectedFontType :- " + ExpectedFontType);
//			testCase.log(Status.FAIL, "Wrong Font Type");
//		}
//
////				                    check font color
//
//		String ActualFontColor = PlantEquipmentPage.SaveButton.getCssValue("color");
//
//		System.out.println("Font colour: " + ActualFontColor);
//
//		String ExpectedFontColor = "rgba(255, 255, 255, 1)";
//		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-FONT-COLOUR");
//		try {
//			AssertJUnit.assertEquals(ActualFontColor, ExpectedFontColor);
//			testCase.log(Status.INFO, "ActualFontColor :- " + ActualFontColor);
//			testCase.log(Status.INFO, "ExpectedFontColor :- " + ExpectedFontColor);
//
//			testCase.log(Status.PASS, "Correct font Colour");
//		} catch (AssertionError e) {
//			testCase.log(Status.INFO, "ActualFontColor :- " + ActualFontColor);
//			testCase.log(Status.INFO, "ExpectedFontColor :- " + ExpectedFontColor);
//
//			testCase.log(Status.FAIL, "wrong font Colour");
//		}
//
////						cursor
//
//		String ActualActions = PlantEquipmentPage.SaveButton.getCssValue("cursor");
//		System.out.println("cursor :" + ActualActions);
//		String ExpectedActions = "pointer";
//
//		boolean cursor = true;
//		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-CURSOR");
//		try {
//			AssertJUnit.assertEquals(ActualActions, ExpectedActions);
//
//		} catch (AssertionError e) {
//			cursor = false;
//		}
//		if (cursor) {
//			testCase.log(Status.INFO, "ActualFontSize :- " + ActualActions);
//			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedActions);
//			testCase.log(Status.PASS, "drop down auto");
//		} else {
//			testCase.log(Status.INFO, "ActualSize :- " + ActualActions);
//			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedActions);
//			testCase.log(Status.FAIL, "drop dow not auto");
//		}
//
////						text spelling
//
//		String text = PlantEquipmentPage.SaveButton.getText();
//
//		String text1 = "Save";
//		boolean txt1 = true;
//		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-SPELLING");
//
//		try {
//			AssertJUnit.assertEquals(text, text1);
//		} catch (AssertionError e) {
//			txt1 = false;
//		}
//		if (txt1) {
//			testCase.log(Status.INFO, "ActualElement :- " + text);
//			testCase.log(Status.INFO, "ExpectedElement :- " + text1);
//			testCase.log(Status.INFO, "correct text");
//			testCase.log(Status.PASS, "Correct ");
//		} else {
//			testCase.log(Status.INFO, "ActualElement :- " + text);
//			testCase.log(Status.INFO, "ExpectedElement :- " + text1);
//			testCase.log(Status.INFO, "wrong text");
//			testCase.log(Status.FAIL, "wrong");
//		}
//
////						padding
//
//		String Actualvalue = PlantEquipmentPage.SaveButton.getCssValue("padding");
//		System.out.println("paddingvalue :" + Actualvalue);
//		String Expectedvalue = "0px";
//
//		boolean padding = true;
//		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-PADDING");
//		try {
//			AssertJUnit.assertEquals(Actualvalue, Expectedvalue);
//
//		} catch (AssertionError e) {
//			padding = false;
//		}
//		if (padding) {
//			testCase.log(Status.INFO, "Actualvalue :- " + Actualvalue);
//			testCase.log(Status.INFO, "Expectedvalue :- " + Expectedvalue);
//			testCase.log(Status.PASS, "Correct value");
//		} else {
//			testCase.log(Status.INFO, "Actualvalue :- " + Actualvalue);
//			testCase.log(Status.INFO, "Expectedvalue :- " + Expectedvalue);
//			testCase.log(Status.FAIL, "Wrong Value");
//		}
//
////				  		border radius
//
//		String Actualradius = PlantEquipmentPage.SaveButton.getCssValue("border-radius");
//		System.out.println("radius value :" + Actualradius);
//		String Expectedradius = "0px";
//
//		boolean radius = true;
//		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-RADIUS");
//		try {
//			AssertJUnit.assertEquals(Actualradius, Expectedradius);
//
//		} catch (AssertionError e) {
//			radius = false;
//		}
//		if (radius) {
//			testCase.log(Status.INFO, "Actualradius :- " + Actualradius);
//			testCase.log(Status.INFO, "Expectedradius :- " + Expectedradius);
//			testCase.log(Status.PASS, "Correct value");
//		} else {
//			testCase.log(Status.INFO, "Actualradius :- " + Actualradius);
//			testCase.log(Status.INFO, "Expectedradius :- " + Expectedradius);
//			testCase.log(Status.FAIL, "Wrong Value");
//		}
//
////						opacity
//
//		String Actualopacity = PlantEquipmentPage.SaveButton.getCssValue("opacity");
//		System.out.println("opacity  :" + Actualopacity);
//		String Expectedopacity = "1";
//
//		boolean opacity = true;
//		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-OPACITY");
//		try {
//			AssertJUnit.assertEquals(Actualopacity, Expectedopacity);
//
//		} catch (AssertionError e) {
//			opacity = false;
//		}
//		if (opacity) {
//			testCase.log(Status.INFO, "Actualopacity :- " + Actualopacity);
//			testCase.log(Status.INFO, "Expectedopacity :- " + Expectedopacity);
//			testCase.log(Status.PASS, "Correct value");
//		} else {
//			testCase.log(Status.INFO, "Actualopacity :- " + Actualopacity);
//			testCase.log(Status.INFO, "Expectedopacity :- " + Expectedopacity);
//			testCase.log(Status.FAIL, "Wrong Value");
//		}
//
////						font weight
//
//		String Actualfontweight = PlantEquipmentPage.SaveButton.getCssValue("font-weight");
//		System.out.println("fontweight  :" + Actualfontweight);
//		String Expectedfontweight = "400";
//
//		boolean fontweight = true;
//		testCase = extent.createTest("AddPlantEquipment-SAVE-BUTTON-FONT-WEIGHT");
//		try {
//			AssertJUnit.assertEquals(Actualfontweight, Expectedfontweight);
//
//		} catch (AssertionError e) {
//			fontweight = false;
//		}
//		if (fontweight) {
//			testCase.log(Status.INFO, "Actualfontweight :- " + Actualfontweight);
//			testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedfontweight);
//			testCase.log(Status.PASS, "Correct font weight");
//		} else {
//			testCase.log(Status.INFO, "Actualfontweight :- " + Actualfontweight);
//			testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedfontweight);
//			testCase.log(Status.FAIL, "Wrong font weight");
//		}
//
//	}
//	// check success message
////	    public void checksuccessmessage() throws InterruptedException {
////	    	PageFactory.initElements(driver, adsbu);
////			testCase = extent.createTest("STEP-6 CHECK Successmessage");
////			Addsbu.SBUsavebutton.click();
////		try {
////				Thread.sleep(3000);
////				String actualmessage=Addsbu.successmessage.getText();
////				String expectedMessage="SubBusinessUnit Added Successfully";
////				
////				boolean msg=true;
////				testCase = extent.createTest("CHECK THE Successfulmessage");
////				
////				
////				try {
////		            AssertJUnit.assertEquals(actualmessage, expectedMessage);
////		        } catch (AssertionError e) {
////		        	msg = false;
////		        }
////		        if (msg) {
////		            testCase.log(Status.INFO, "Actual Data :- " + actualmessage);
////		            testCase.log(Status.INFO, "Expected Data :- " + expectedMessage);
////		            testCase.log(Status.PASS, "Correct message");
////		        } else {
////		            testCase.log(Status.INFO, "Actual Data :- " + actualmessage);
////		            testCase.log(Status.INFO, "Expected Data :- " + expectedMessage);
////		            testCase.log(Status.FAIL, "Wrong message");
////		        }
////			    } catch (Exception find9) {
////					  testCase = extent.createTest(" CHECK THE Successfulmessage");
////					  testCase.log(Status.FAIL, "No Element");
////				}
////			
////	    }
////	    
//
//	// check save button functionality
//
//	public static void checkData() throws InterruptedException {
//		PageFactory.initElements(driver, equipmentPage);
//		testCase = extent.createTest("STEP-7 CHECK Add Functionality");
//
//		try {
//			Thread.sleep(3000);
//			String actualdata = PlantEquipmentPage.firstcell.getText();
//			System.out.println("First row of table : " + actualdata);
//			String expecteddata = "RMC Jaffna Plant";
//			// WebElement
//			// element=driver.findElement(By.xpath("//td[normalize-space()='"+expecteddata+"']"));
//
//			// String actualdata = element.getText();
//
//			boolean firstdata = true;
//			testCase = extent.createTest("CHECK THE ENTERED VALUE HAS SAVED IN THE TABLE");
//			try {
//				AssertJUnit.assertEquals(actualdata, expecteddata);
//			} catch (AssertionError e) {
//				firstdata = false;
//			}
//			if (firstdata) {
//				testCase.log(Status.INFO, "Actual Data :- " + actualdata);
//				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
//				testCase.log(Status.PASS, "Correct last added data");
//			} else {
//				testCase.log(Status.INFO, "Actual Data :- " + actualdata);
//				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
//				testCase.log(Status.FAIL, "Wrong last added data");
//			}
//		} catch (Exception find9) {
//			testCase = extent.createTest(" CHECK THE ENTERED VALUE HAS SAVED IN THE TABLE");
//			testCase.log(Status.FAIL, "No Element");
//		}
//	}
//
//	public static void checkDescriptionData() throws InterruptedException {
//		PageFactory.initElements(driver, equipmentPage);
//		testCase = extent.createTest("STEP-7 CHECK Description button Functionality");
//		Thread.sleep(3000);
//		int firstrow = CommonMethods.getFirstRowNum(excelpath, "Plant", "TC-PLANT-0045");
//		System.out.println("row num" + firstrow);
//		String code = CommonMethods.ExcelSheetValue(excelpath, "Plant", firstrow + 1, 2);
//		String description = CommonMethods.ExcelSheetValue(excelpath, "Plant", firstrow + 1, 3);
//
//		driver.findElement(By
//				.xpath("//td[normalize-space()='" + code + "']/ancestor::tr//*[name()='svg'][@data-icon='container']"))
//				.click();
//		try {
//			Thread.sleep(3000);
//
//			String actualdata = PlantEquipmentPage.box.getText();
//			System.out.println("First row of tanble : " + actualdata);
//
//			// WebElement
//			// element=driver.findElement(By.xpath("//td[normalize-space()='"+expecteddata+"']"));
//
//			// String actualdata = element.getText();
//
//			boolean firstdata = true;
//			testCase = extent.createTest("CHECK THE ENTERED VALUE HAS SAVED IN THE Description");
//			try {
//				AssertJUnit.assertEquals(actualdata, description);
//			} catch (AssertionError e) {
//				firstdata = false;
//			}
//			if (firstdata) {
//				testCase.log(Status.INFO, "Actual Data :- " + actualdata);
//				testCase.log(Status.INFO, "Expected Data :- " + description);
//				testCase.log(Status.PASS, "Correct description added data");
//			} else {
//				testCase.log(Status.INFO, "Actual Data :- " + actualdata);
//				testCase.log(Status.INFO, "Expected Data :- " + description);
//				testCase.log(Status.FAIL, "Wrong description added data");
//			}
//		} catch (Exception find9) {
//			testCase = extent.createTest(" CHECK THE ENTERED VALUE HAS SAVED IN THE Description");
//			testCase.log(Status.FAIL, "No Element");
//		}
//	}
//
//	public static void checkAfterDependent(String plant) throws InterruptedException {
//		PageFactory.initElements(driver, equipmentPage);
//		PageFactory.initElements(driver, equip);
//		PageFactory.initElements(driver, page);
//
//		// check the message
//
//		testCase = extent.createTest("CHECK Delete Equipment function After depend");
//		EquipmentPage.Equipment.click();
//		EquipmentPage.SideEquipment.click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//td[text()='" + plant + "']/ancestor::tr//*[@data-icon='delete']")).click();
//		Thread.sleep(2000);
//		EquipmentPage.deleteconfirmationOKbutton.click();
//		Thread.sleep(2000);
//		String actualmessage = EquipmentPage.deleteequipment.getText();
//		System.out.println("message is : " + actualmessage);
//		String expectedmessage = "Can't delete this module";
//
//		// check data is available or not in the table after delete
//		SourcePage.firstColum_icon.click();
//		SourcePage.firstColum_icon.click();
//		EquipmentPage.EquipSearch.sendKeys(plant);
//		// Search it is still avilable
//		List<String> SerialNoTextList = new ArrayList<String>();
//		// Actual result of SerialNo
//		Thread.sleep(3000);
//		List<String> serialno_Return_List = PlantEquipmentMultipleSearchMethods.tableColumnList(SerialNoTextList,
//				SourcePage.column_fourth);
//
//		try {
//
//			boolean firstdata = false;
//			testCase = extent.createTest("CHECK Equipment delete After Equipment Depend");
//			Assert.assertNotNull(serialno_Return_List);
//
//			boolean dataIs = true;
//			try {
//				Assert.assertNotNull(serialno_Return_List);
//			} catch (AssertionError e) {
//				dataIs = false;
//			}
//			try {
//				AssertJUnit.assertEquals(actualmessage, expectedmessage);
//			} catch (AssertionError e) {
//				firstdata = false;
//			}
//			if (firstdata && dataIs) {
//				testCase.log(Status.INFO, "Actual Data :- " + actualmessage);
//				testCase.log(Status.INFO, "Expected Data :- " + expectedmessage);
//				testCase.log(Status.PASS, "Cant delete");
//			} else {
//				testCase.log(Status.INFO, "Actual Data :- " + actualmessage);
//				testCase.log(Status.INFO, "Expected Data :- " + expectedmessage);
//				testCase.log(Status.FAIL, "can delete");
//			}
//		} catch (AssertionError e) {
//			testCase = extent.createTest("CHECK Equipment delete After Equipment Depend");
//			testCase.log(Status.FAIL, "No Element");
//		}
//	}
//
//	public static void check() throws InterruptedException, IOException {
//		extent.createTest("CHECKING PLANT SHOW IN PLANTEQUIPMENT DROPDOWN");
//		PageFactory.initElements(driver, equipmentPage);
//		int firstrow = CommonMethods.getFirstRowNum(
//				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Plant",
//				"TC-PLANT-0080");
//		System.out.println("row num" + firstrow);
//		String plant = CommonMethods.ExcelSheetValue(
//				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Plant",
//				firstrow + 1, 2);
//		String expectedresult = CommonMethods.ExcelSheetValue(
//				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Plant",
//				firstrow + 1, 3);
//		EquipmentEditPageWise.ElementFunction(PlantEquipmentPage.plant_INPUT, "Plant Textbox");
//		PlantEquipmentPage.plant_INPUT.sendKeys(plant);
//		boolean actualresult = false;
//		try {
//			actualresult = driver.findElement(By.xpath("//span[normalize-space()='" + plant + "']")).isEnabled();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//		CommonMethods.TestCasePrint("Plant is Available in PlantEquipment Plant Dropdown", expectedresult.toLowerCase(),
//				String.valueOf(actualresult));
//
//	}
//
//	public static void checkPlantDescriptionData(String excelpath, String Sheetname) throws InterruptedException {
//		PageFactory.initElements(driver, equipmentPage);
//		testCase = extent.createTest("STEP--03--CHECK SPECIFIC PLANT DESCRIPTION");
//
//		try {
//
//			FileInputStream file = new FileInputStream(excelpath);
//			XSSFWorkbook workbook = new XSSFWorkbook(file);
//			XSSFSheet Editsheet = workbook.getSheet(Sheetname);
//			int editrowcount = Editsheet.getLastRowNum();
//
//			for (int i = 1; i <= editrowcount; i++) {
//				XSSFRow editrow = Editsheet.getRow(i);
//				String code = (String) editrow.getCell(0).getStringCellValue();
//				String expecteddata = (String) editrow.getCell(1).getStringCellValue();
//
//				driver.findElement(
//						By.xpath("//td[text()='" + code + "']/ancestor::tr//*[name()='svg'][@data-icon='container']"))
//						.click();
//				Thread.sleep(3000);
//				String actualdata = PlantEquipmentPage.box.getText();
//				System.out.println("First row of table : " + actualdata);
//				// WebElement
//				// element=driver.findElement(By.xpath("//td[normalize-space()='"+expecteddata+"']"));
//
//				// String actualdata = element.getText();
//
//				boolean firstdata = true;
//				testCase = extent.createTest("CHECK THE ENTERED VALUE HAS SAVED IN THE Description");
//				try {
//					AssertJUnit.assertEquals(actualdata, expecteddata);
//				} catch (AssertionError e) {
//					firstdata = false;
//				}
//				if (firstdata) {
//					testCase.log(Status.INFO, "Actual Data :- " + actualdata);
//					testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
//					testCase.log(Status.PASS, "Correct description added data");
//				} else {
//					testCase.log(Status.INFO, "Actual Data :- " + actualdata);
//					testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
//					testCase.log(Status.FAIL, "Wrong description added data");
//				}
//			}
//		} catch (Exception find9) {
//			testCase = extent.createTest(" CHECK THE ENTERED VALUE HAS SAVED IN THE Description");
//			testCase.log(Status.FAIL, "No Element");
//		}
//
//	}
//
//	public static void editplant() throws IOException, InterruptedException {
//		// TODO Auto-generated method stub
//		PageFactory.initElements(driver, equipmentPage);
//		FileInputStream file = new FileInputStream(PlantEquipmentAddTest.excel_path);
//		// C:\Automation_Workspace\QDMS-AUTOMATION\src\test\java\com\invicta\qa\excel\Data.xlsx
//		XSSFWorkbook workbook = new XSSFWorkbook(file);
//		XSSFSheet sheet = workbook.getSheet("Plant Equipment");
//		int firstrow = CommonMethods.getFirstRowNum(PlantEquipmentAddTest.excel_path, "Plant Equipment",
//				"TC-PLA-EQU-0087");
//		int lastrow = CommonMethods.getLastRowNum(PlantEquipmentAddTest.excel_path, "Plant Equipment",
//				"TC-PLA-EQU-0087");
//
//		for (int i = firstrow; i <= lastrow; i++) {
//			XSSFRow editrow = sheet.getRow(i);
//
//			String Editplant = (String) editrow.getCell(1).getStringCellValue().trim();
//			String Editequipment = (String) editrow.getCell(2).getStringCellValue().trim();
//			String Editserialno = (String) editrow.getCell(3).getStringCellValue().trim();
//			String Editbrand = (String) editrow.getCell(4).getStringCellValue().trim();
//			String Editmodel = (String) editrow.getCell(5).getStringCellValue().trim();
//			String Edittype = (String) editrow.getCell(6).getStringCellValue().trim();
//			String Editformatno = (String) editrow.getCell(7).getStringCellValue().trim();
//			String Editdescrip = (String) editrow.getCell(8).getStringCellValue().trim();
//
//			Thread.sleep(4000);
//			driver.findElement(By.xpath("//td[text()='" + Editserialno + "']/ancestor::tr//*[@data-icon='edit']"))
//					.click();
//
//			PlantEquipmentPage.plant_INPUT.sendKeys(Editplant);
//			Thread.sleep(1000);
//			driver.findElement(
//					By.xpath("//div[@class='ant-select-item-option-content']/span[text()='" + Editplant + "']"))
//					.click();
//
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("//div[@name='equipment']")).click();
//
//			Actions actions = new Actions(driver);
//
//			for (int j = 0; j < 200; j++)
//
//				try {
//					driver.findElement(By.xpath("//span[normalize-space()='" + Editequipment + "']")).click();
//					break;
//				} catch (Exception e) {
//
//					actions.sendKeys(Keys.ARROW_DOWN).perform();
//				}
//
//			// PlantEquipment.Equipmentform.sendKeys(Keys.RETURN);
//			PlantEquipmentPage.BrandName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//			PlantEquipmentPage.BrandName.sendKeys(Editbrand);
//			PlantEquipmentPage.Model.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//			PlantEquipmentPage.Model.sendKeys(Editmodel);
//
//			driver.findElement(By.xpath("//div[@name='equipmentType']")).click();
//
//			Thread.sleep(2000);
//
//			driver.findElement(
//					By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='" + Edittype + "']"))
//					.click();
//			PlantEquipmentPage.FormatNo.sendKeys(String.valueOf(Editformatno));
//			PlantEquipmentPage.Description.sendKeys(Editdescrip);
//
//			PlantEquipmentPage.Update.click();
//
//		}
//	}
//
//	public static void afterEdit(String testCaseNo) throws InterruptedException {
//		int firstrow = CommonMethods.getFirstRowNum(PlantEquipmentAddTest.excel_path, "Plant Equipment", testCaseNo);
//		System.out.println("row num" + firstrow);
//
//		String expectplant = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment",
//				firstrow + 1, 2);
//		String expectEquipment = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment",
//				firstrow + 1, 3);
//		String expectbrand = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment",
//				firstrow + 1, 5);
//		String expectmodel = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment",
//				firstrow + 1, 6);
//		String expecttype = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment",
//				firstrow + 1, 7);
//		String expectformatno = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment",
//				firstrow + 1, 8);
//		Thread.sleep(3000);
//		String actualplant = driver.findElement(By.xpath("//tr[2]/td[1]")).getText();
//		String actualequipment = driver.findElement(By.xpath("//tr[2]/td[2]")).getText();
//
//		String actualbrand = driver.findElement(By.xpath("//tr[2]/td[5]")).getText();
//
//		String actualmodel = driver.findElement(By.xpath("//tr[2]/td[6]")).getText();
//		String actualtype = driver.findElement(By.xpath("//tr[2]/td[8]")).getText();
//		String actualformatno = driver.findElement(By.xpath("//tr[2]/td[9]")).getText();
//
//		EquipmentEditPageWise.testCaseResult(expectplant, actualplant, "Verify plant Data After Edit");
//		EquipmentEditPageWise.testCaseResult(expectEquipment, actualequipment, "Verify Equipment Data After Edit");
//		EquipmentEditPageWise.testCaseResult(expectbrand, actualbrand, "Verify Brand Data After Edit");
//		EquipmentEditPageWise.testCaseResult(expectmodel, actualmodel, "Verify Model Data After Edit");
//		EquipmentEditPageWise.testCaseResult(expecttype, actualtype, "Verify Type Data After Edit");
//		EquipmentEditPageWise.testCaseResult(expectformatno, actualformatno, "Verify Formatno Data After Edit");
//	}
//
//	public static void equipmentFieldEdit() {
//		int firstrow = CommonMethods.getFirstRowNum(PlantEquipmentAddTest.excel_path, "Plant Equipment", "TC-PLA-EQU-0097");
//		String equipment = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment",firstrow + 1, 2).trim();
//
//		EquipmentPage.equipmenttextbox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//		EquipmentPage.equipmenttextbox.sendKeys(equipment);
//		EquipmentPage.equipmentsavebutton.click();
//	}
//
//	public static void checkEquipmentUpdate() {
//		int firstrow = CommonMethods.getFirstRowNum(PlantEquipmentAddTest.excel_path, "Plant Equipment", "TC-PLA-EQU-0097");
//		String Editequipment = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment",firstrow + 1, 3).trim();
//		driver.findElement(By.xpath("//div[@name='equipment']")).click();
//
//		Actions actions = new Actions(driver);
//		boolean update = false;
//		for (int j = 0; j < 200; j++) {
//
//			try {
//				Thread.sleep(1000);
//				
//				driver.findElement(By.xpath("//span[normalize-space()='" + Editequipment + "']")).click();
//				update = true;
//				break;
//			} catch (Exception e) {
//				update = false;
//				actions.sendKeys(Keys.ARROW_DOWN).perform();
//			}
//
//		}
//		CommonMethods.TestCasePrint("check Equipment name is updated in plantequipment Equipment dropdown field", true, update);
//	}
//
//	public static void checkAfterDelete(String code) throws InterruptedException {
//		PageFactory.initElements(driver, equipmentPage);
//		
//		PageFactory.initElements(driver, page);
//
//		// check the message
//
//		testCase = extent.createTest("Checking Delete After plant Equipment Depended");
//
//		Thread.sleep(3000);
//		String actualmessage = EquipmentPage.deleteequipment.getText();
//		String expectedmessage = "Can't delete this module";
//		String expectedsuccessmessage = "Plant Equipment Successfully Deleted";
//		
//		
//		PlantEquipmentMultipleSearchMethods.serialNoSearch(code);;
//
//		// Search it is still avilable
//		List<String> SerialNoTextList = new ArrayList<String>();
//		// Actual result of SerialNo
//		Thread.sleep(3000);
//		List<String> serialno_Return_List = PlantEquipmentMultipleSearchMethods.tableColumnList(SerialNoTextList,
//				SourcePage.column_fourth);
//		System.out.println("actal" + actualmessage);
//		try {
//
//			boolean dependdata = true;
//			testCase = extent.createTest("CHECK PlantEquipment Delete");
//			
//			boolean Successdata = true;
//			boolean dataIs = true;
//			try {
//				Assert.assertNotNull(serialno_Return_List);
//			} catch (AssertionError e) {
//				dataIs = false;
//			}
//			try {
//				AssertJUnit.assertEquals(actualmessage, expectedmessage);
//			} catch (AssertionError e) {
//				dependdata = false;
//			}
//			try {
//				AssertJUnit.assertEquals(actualmessage, expectedsuccessmessage);
//			} catch (AssertionError e) {
//				Successdata = false;
//			}
//			System.out.println("data is" + dataIs);
//			System.out.println("Successdata is" + Successdata);
//			System.out.println("dependdata is" + dependdata);
//			if (dataIs && dependdata) {
//				testCase.log(Status.INFO, "Actual Data :- " + actualmessage);
//				testCase.log(Status.INFO, "Expected Data :- " + expectedmessage);
//				testCase.log(Status.PASS, "Cant delete because its dependent");
//			} else if (dataIs == false && Successdata == true) {
//				testCase.log(Status.INFO, "Actual Data :- " + actualmessage);
//				testCase.log(Status.INFO, "Expected Data :- " + expectedsuccessmessage);
//				testCase.log(Status.PASS, "Delete Successfullly");
//			} else {
//				testCase.log(Status.INFO, "Actual Data :- " + actualmessage);
//				testCase.log(Status.INFO, "Expected Data if not dependent :- " + expectedsuccessmessage);
//				testCase.log(Status.INFO, "Expected Data if dependent:- " + expectedmessage);
//				testCase.log(Status.FAIL, "somthing wrong in delete");
//			}
//		} catch (AssertionError e) {
//			testCase = extent.createTest("CHECK Equipment delete");
//			testCase.log(Status.FAIL, "No Element");
//		}
//	}
//
//	public static void addWitChekbox(String testCaseNo) throws InterruptedException {
//		System.out.println("testCaseNo" + testCaseNo);
//		PageFactory.initElements(driver, equipmentPage);
//		int firstrow = CommonMethods.getFirstRowNum(PlantEquipmentAddTest.excel_path, "Plant Equipment", testCaseNo);
//		System.out.println("firstrow" + firstrow);
//		String plant = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment", firstrow + 1,
//				2);
//		System.out.println("plant" + plant);
//		String equipment = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment",
//				firstrow + 1, 3);
//		System.out.println("equipment" + equipment);
//		String serialno = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment",
//				firstrow + 1, 4);
//		System.out.println("serialno" + serialno);
//
//		String brand = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment", firstrow + 1,
//				5);
//		String model = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment", firstrow + 1,
//				6);
//		String type = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment", firstrow + 1,
//				7);
//		String formatno = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment",
//				firstrow + 1, 8);
//		String descrip = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment",
//				firstrow + 1, 9);
//
//		Thread.sleep(3000);
//		PlantEquipmentPage.plant_INPUT.sendKeys(plant, Keys.RETURN);
//		PlantEquipmentPage.Equipmentform.click();
//
//		Thread.sleep(2000);
//		Actions actions = new Actions(driver);
//
//		for (int j = 0; j < 200; j++) {
//
//			try {
//				driver.findElement(By.xpath(
//						"//div[contains(@class,'ant-select-item ant-select-item-option')]//child::span[contains(text(),'"
//								+ equipment + "')]"))
//						.click();
//
//				break;
//			} catch (Exception e) {
//
//				actions.sendKeys(Keys.ARROW_DOWN).perform();
//			}
//
//		}
//		try {
//			Double y = Double.parseDouble(serialno);
//			System.out.println(y);
//
//			int w = Double.valueOf(y).intValue();
//
//			PlantEquipmentPage.Serialno.sendKeys(String.valueOf(w));
//		} catch (NumberFormatException e) {
//			PlantEquipmentPage.Serialno.sendKeys(serialno);
//		}
//
//		PlantEquipmentPage.BrandName.sendKeys(brand);
//		PlantEquipmentPage.Model.sendKeys(model);
//
//		PlantEquipmentPage.Type.click();
//
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='" + type + "']"))
//				.click();
//		PlantEquipmentPage.FormatNo.sendKeys(formatno);
//		PlantEquipmentPage.Description.sendKeys(descrip);
//		PlantEquipmentPage.calibration.click();
//
//	}
//
//	public static void checkAfterAdd() {
//		
//		String expectplant = PlantEquipmentAddMethods.equipData.get(0);
//		String expectEquipment = PlantEquipmentAddMethods.equipData.get(1);;
//		String expectSerialNo = PlantEquipmentAddMethods.equipData.get(2);
//		String expectbrand = PlantEquipmentAddMethods.equipData.get(3);
//		String expectmodel = PlantEquipmentAddMethods.equipData.get(4);
//		String expecttype = PlantEquipmentAddMethods.equipData.get(5);
//		String expectformatno = PlantEquipmentAddMethods.equipData.get(6);
//
//		String expectcalibration = PlantEquipmentAddMethods.equipData.get(8);
//		boolean actualcalibration = true;
//		try {
//			actualcalibration = driver
//					.findElement(By.xpath("//tr[5]//td[7]//*[@viewBox]"))
//					.isDisplayed();
//		} catch (Exception e) {
//			actualcalibration = false;
//		}
//
//		System.out.println(actualcalibration);
//
//		String actualplant = driver.findElement(By.xpath("//tr[2]/td[1]")).getText();
//		String actualequipment = driver.findElement(By.xpath("//tr[2]/td[2]")).getText();
//
//		String actualbrand = driver.findElement(By.xpath("//tr[2]/td[5]")).getText();
//
//		String actualmodel = driver.findElement(By.xpath("//tr[2]/td[6]")).getText();
//		String actualtype = driver.findElement(By.xpath("//tr[2]/td[8]")).getText();
//		String actualformatno = driver.findElement(By.xpath("//tr[2]/td[9]")).getText();
//
//		EquipmentEditPageWise.testCaseResult(expectplant, actualplant, "Verify plant Data After ADD");
//		EquipmentEditPageWise.testCaseResult(expectEquipment, actualequipment, "Verify Equipment Data After ADD");
//		EquipmentEditPageWise.testCaseResult(expectbrand, actualbrand, "Verify Brand Data After ADD");
//		EquipmentEditPageWise.testCaseResult(expectmodel, actualmodel, "Verify Model Data After ADD");
//		EquipmentEditPageWise.testCaseResult(expecttype, actualtype, "Verify Type Data After ADD");
//		EquipmentEditPageWise.testCaseResult(expectformatno, actualformatno, "Verify Formatno Data After ADD");
//		EquipmentEditPageWise.testCaseResult(expectcalibration.toLowerCase(), String.valueOf(actualcalibration),
//				"Verify RelaventCalibration After ADD");
//	}
//
//	public static void editwithcheckbox() throws InterruptedException {
//		PageFactory.initElements(driver, equipmentPage);
//		int firstrow = CommonMethods.getFirstRowNum(PlantEquipmentAddTest.excel_path, "Plant Equipment", "TC-PLA-EQU-0102");
//		String serialno = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path,"Plant Equipment", firstrow + 1, 2);
//		String expectcalibration = CommonMethods.ExcelSheetValue(excelpath, "Plant Equipment", firstrow + 1, 3);
//		Thread.sleep(3000);
//		Double y = Double.parseDouble(serialno);
//		System.out.println(y);
//
//		int w = Double.valueOf(y).intValue();
//		driver.findElement(By.xpath("//td[text()='" + w + "']/ancestor::tr//*[@data-icon='edit']")).click();
//		EquipmentEditPageWise.ElementFunction(PlantEquipmentPage.calibration, "Relavant Calibration");
//		PlantEquipmentPage.calibration.click();
//		PlantEquipmentPage.Update.click();
//		Thread.sleep(3000);
//		boolean actualcalibration = false;
//		try {
//			driver.findElement(
//					By.xpath("//td[text()='" + serialno + "']/ancestor::tr//*[name()='svg'][@data-icon='check']"))
//					.isDisplayed();
//			actualcalibration = true;
//		} catch (Exception e) {
//			actualcalibration = false;
//		}
//		CommonMethods.TestCasePrint("Verify plant equipment edit with checkbox", expectcalibration.toLowerCase(),
//				actualcalibration);
//	}
//
//	public static void descriptionView(String plant) {
//		PageFactory.initElements(driver, equipmentPage);
//		driver.findElement(By.xpath("//td[text()='" + plant + "']/ancestor::tr//*[@data-icon='container']")).click();
//
//	}
//
//	public static void plEqcheckDescriptionData(String code, String description) throws InterruptedException {
//		PageFactory.initElements(driver, equipmentPage);
//		testCase = extent.createTest("STEP-7 CHECK Description button Functionality");
//		Thread.sleep(3000);
//
//		driver.findElement(By
//				.xpath("//td[normalize-space()='" + code + "']/ancestor::tr//*[name()='svg'][@data-icon='container']"))
//				.click();
//		try {
//			Thread.sleep(3000);
//
//			String actualdata = PlantEquipmentPage.box.getText();
//			System.out.println("First row of tanble : " + actualdata);
//
//			// WebElement
//			// element=driver.findElement(By.xpath("//td[normalize-space()='"+expecteddata+"']"));
//
//			// String actualdata = element.getText();
//
//			boolean firstdata = true;
//			testCase = extent.createTest("CHECK THE ENTERED VALUE HAS SAVED IN THE Description");
//			try {
//				AssertJUnit.assertEquals(actualdata, description);
//			} catch (AssertionError e) {
//				firstdata = false;
//			}
//			if (firstdata) {
//				testCase.log(Status.INFO, "Actual Data :- " + actualdata);
//				testCase.log(Status.INFO, "Expected Data :- " + description);
//				testCase.log(Status.PASS, "Correct description added data");
//			} else {
//				testCase.log(Status.INFO, "Actual Data :- " + actualdata);
//				testCase.log(Status.INFO, "Expected Data :- " + description);
//				testCase.log(Status.FAIL, "Wrong description added data");
//			}
//		} catch (Exception find9) {
//			testCase = extent.createTest(" CHECK THE ENTERED VALUE HAS SAVED IN THE Description");
//			testCase.log(Status.FAIL, "No Element");
//		}
//	}

	public static ArrayList<String> equipData = new ArrayList<String>();
	public static boolean dataExcel = false;

	// check save button functionality

	public static void checkData() throws InterruptedException {
		PageFactory.initElements(driver, equipmentPage);
		testCase = extent.createTest("STEP-7 CHECK Add Functionality");

		try {
			Thread.sleep(3000);
			String actualdata = PlantEquipmentPage.firstcell.getText();
			System.out.println("First row of table : " + actualdata);
			String expecteddata = "RMC Jaffna Plant";
			// WebElement
			// element=driver.findElement(By.xpath("//td[normalize-space()='"+expecteddata+"']"));

			// String actualdata = element.getText();

			boolean firstdata = true;
			testCase = extent.createTest("CHECK THE ENTERED VALUE HAS SAVED IN THE TABLE");
			try {
				AssertJUnit.assertEquals(actualdata, expecteddata);
			} catch (AssertionError e) {
				firstdata = false;
			}
			if (firstdata) {
				testCase.log(Status.INFO, "Actual Data :- " + actualdata);
				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
				testCase.log(Status.PASS, "Correct last added data");
			} else {
				testCase.log(Status.INFO, "Actual Data :- " + actualdata);
				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
				testCase.log(Status.FAIL, "Wrong last added data");
			}
		} catch (Exception find9) {
			testCase = extent.createTest(" CHECK THE ENTERED VALUE HAS SAVED IN THE TABLE");
			testCase.log(Status.FAIL, "No Element");
		}
	}

	public static void checkDescriptionData() throws InterruptedException {
		PageFactory.initElements(driver, equipmentPage);
		testCase = extent.createTest("STEP-7 CHECK Description button Functionality");
		Thread.sleep(3000);
		int firstrow = CommonMethods.getFirstRowNum(excelpath, "Plant", "TC-PLANT-0045");
		System.out.println("row num" + firstrow);
		String code = CommonMethods.ExcelSheetValue(excelpath, "Plant", firstrow + 1, 2);
		String description = CommonMethods.ExcelSheetValue(excelpath, "Plant", firstrow + 1, 3);

		driver.findElement(By
				.xpath("//td[normalize-space()='" + code + "']/ancestor::tr//*[name()='svg'][@data-icon='container']"))
				.click();
		try {
			Thread.sleep(3000);

			String actualdata = PlantEquipmentPage.box.getText();
			System.out.println("First row of tanble : " + actualdata);

			// WebElement
			// element=driver.findElement(By.xpath("//td[normalize-space()='"+expecteddata+"']"));

			// String actualdata = element.getText();

			boolean firstdata = true;
			testCase = extent.createTest("CHECK THE ENTERED VALUE HAS SAVED IN THE Description");
			try {
				AssertJUnit.assertEquals(actualdata, description);
			} catch (AssertionError e) {
				firstdata = false;
			}
			if (firstdata) {
				testCase.log(Status.INFO, "Actual Data :- " + actualdata);
				testCase.log(Status.INFO, "Expected Data :- " + description);
				testCase.log(Status.PASS, "Correct description added data");
			} else {
				testCase.log(Status.INFO, "Actual Data :- " + actualdata);
				testCase.log(Status.INFO, "Expected Data :- " + description);
				testCase.log(Status.FAIL, "Wrong description added data");
			}
		} catch (Exception find9) {
			testCase = extent.createTest(" CHECK THE ENTERED VALUE HAS SAVED IN THE Description");
			testCase.log(Status.FAIL, "No Element");
		}
	}

	public static void checkAfterDependent(String plant) throws InterruptedException {
		PageFactory.initElements(driver, equipmentPage);
		PageFactory.initElements(driver, equip);
		PageFactory.initElements(driver, page);

		// check the message

		testCase = extent.createTest("CHECK Delete Equipment function After depend");
		EquipmentPage.Equipment.click();
		EquipmentPage.SideEquipment.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[text()='" + plant + "']/ancestor::tr//*[@data-icon='delete']")).click();
		Thread.sleep(2000);
		EquipmentPage.deleteconfirmationOKbutton.click();
		Thread.sleep(2000);
		String actualmessage = EquipmentPage.deleteequipment.getText();
		System.out.println("message is : " + actualmessage);
		String expectedmessage = "Can't delete this module";

		// check data is available or not in the table after delete
		SourcePage.firstColum_icon.click();
		SourcePage.firstColum_icon.click();
		EquipmentPage.EquipSearch.sendKeys(plant);
		new ArrayList<String>();
		// Actual result of SerialNo
		Thread.sleep(3000);
//		List<String> serialno_Return_List = PlantEquipmentMultipleSearchMethods.tableColumnList(SerialNoTextList,
//				SourcePage.column_fourth);

		try {

			boolean firstdata = false;
			testCase = extent.createTest("CHECK Equipment delete After Equipment Depend");
//			Assert.assertNotNull(serialno_Return_List);

			boolean dataIs = true;
			try {
//				Assert.assertNotNull(serialno_Return_List);
			} catch (AssertionError e) {
				dataIs = false;
			}
			try {
				AssertJUnit.assertEquals(actualmessage, expectedmessage);
			} catch (AssertionError e) {
				firstdata = false;
			}
			if (firstdata && dataIs) {
				testCase.log(Status.INFO, "Actual Data :- " + actualmessage);
				testCase.log(Status.INFO, "Expected Data :- " + expectedmessage);
				testCase.log(Status.PASS, "Cant delete");
			} else {
				testCase.log(Status.INFO, "Actual Data :- " + actualmessage);
				testCase.log(Status.INFO, "Expected Data :- " + expectedmessage);
				testCase.log(Status.FAIL, "can delete");
			}
		} catch (AssertionError e) {
			testCase = extent.createTest("CHECK Equipment delete After Equipment Depend");
			testCase.log(Status.FAIL, "No Element");
		}
	}

	public static void check() throws InterruptedException, IOException {
		extent.createTest("CHECKING PLANT SHOW IN PLANTEQUIPMENT DROPDOWN");
		PageFactory.initElements(driver, equipmentPage);
		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Plant",
				"TC-PLANT-0080");
		System.out.println("row num" + firstrow);
		String plant = CommonMethods.ExcelSheetValue(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Plant",
				firstrow + 1, 2);
		String expectedresult = CommonMethods.ExcelSheetValue(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Plant",
				firstrow + 1, 3);
		EquipmentEditPageWise.ElementFunction(PlantEquipmentPage.plant_INPUT, "Plant Textbox");
		PlantEquipmentPage.plant_INPUT.sendKeys(plant);
		boolean actualresult = false;
		try {
			actualresult = driver.findElement(By.xpath("//span[normalize-space()='" + plant + "']")).isEnabled();
		} catch (Exception e) {
			// TODO: handle exception
		}

		CommonMethods.TestCasePrint("Plant is Available in PlantEquipment Plant Dropdown", expectedresult.toLowerCase(),
				String.valueOf(actualresult));

	}

	public static void checkPlantDescriptionData(String excelpath, String Sheetname) throws InterruptedException {
		PageFactory.initElements(driver, equipmentPage);
		testCase = extent.createTest("STEP--03--CHECK SPECIFIC PLANT DESCRIPTION");

		try {

			FileInputStream file = new FileInputStream(excelpath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet Editsheet = workbook.getSheet(Sheetname);
			int editrowcount = Editsheet.getLastRowNum();

			for (int i = 1; i <= editrowcount; i++) {
				XSSFRow editrow = Editsheet.getRow(i);
				String code = (String) editrow.getCell(0).getStringCellValue();
				String expecteddata = (String) editrow.getCell(1).getStringCellValue();

				driver.findElement(
						By.xpath("//td[text()='" + code + "']/ancestor::tr//*[name()='svg'][@data-icon='container']"))
						.click();
				Thread.sleep(3000);
				String actualdata = PlantEquipmentPage.box.getText();
				System.out.println("First row of table : " + actualdata);
				// WebElement
				// element=driver.findElement(By.xpath("//td[normalize-space()='"+expecteddata+"']"));

				// String actualdata = element.getText();

				boolean firstdata = true;
				testCase = extent.createTest("CHECK THE ENTERED VALUE HAS SAVED IN THE Description");
				try {
					AssertJUnit.assertEquals(actualdata, expecteddata);
				} catch (AssertionError e) {
					firstdata = false;
				}
				if (firstdata) {
					testCase.log(Status.INFO, "Actual Data :- " + actualdata);
					testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
					testCase.log(Status.PASS, "Correct description added data");
				} else {
					testCase.log(Status.INFO, "Actual Data :- " + actualdata);
					testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
					testCase.log(Status.FAIL, "Wrong description added data");
				}
			}
		} catch (Exception find9) {
			testCase = extent.createTest(" CHECK THE ENTERED VALUE HAS SAVED IN THE Description");
			testCase.log(Status.FAIL, "No Element");
		}

	}

	public static void editplant() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 4);
		// TODO Auto-generated method stub
		PageFactory.initElements(driver, equipmentPage);
		String EditplantOld = null;
		String EditequipmentOld = null;
		String EditserialnoOld = null;
		String EditbrandOld = null;
		String EditmodelOld = null;
		String EdittypeOld = null;
		String EditformatnoOld = null;
		String EditdescripOld = null;
		String CalifOld = null;

		String Editplant = PlantEquipmentAddMethods.equipData.get(9);
		String Editequipment = PlantEquipmentAddMethods.equipData.get(10);
		PlantEquipmentAddMethods.equipData.get(11);
		String Editbrand = PlantEquipmentAddMethods.equipData.get(12);
		String Editmodel = PlantEquipmentAddMethods.equipData.get(13);
		String Edittype = PlantEquipmentAddMethods.equipData.get(14);
		String Editformatno = PlantEquipmentAddMethods.equipData.get(15);
		String Editdescrip = PlantEquipmentAddMethods.equipData.get(16);
		String Calif = PlantEquipmentAddMethods.equipData.get(17);
		try {
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//input[@id='plant']/../../span[2]"))));
		} catch (Exception e) {
		}

		try {
			EditplantOld = driver.findElement(By.xpath("//input[@id='plant']/../../span[2]")).getAttribute("title");
		} catch (Exception e) {
		}

		try {
			EditequipmentOld = driver.findElement(By.xpath("//input[@id='equipment']/../../span[2]"))
					.getAttribute("title");
		} catch (Exception e) {
		}
		try {
			EditserialnoOld = PlantEquipmentPage.Serialno.getAttribute("value");
		} catch (Exception e) {
		}
		try {
			EditbrandOld = PlantEquipmentPage.BrandName.getAttribute("value");
		} catch (Exception e) {
		}
		try {
			EditmodelOld = PlantEquipmentPage.Model.getAttribute("value");
		} catch (Exception e) {
		}
		try {
			EdittypeOld = driver.findElement(By.xpath("//input[@id='equipmentType']/../../span[2]"))
					.getAttribute("title");
		} catch (Exception e) {
		}
		try {
			EditformatnoOld = PlantEquipmentPage.FormatNo.getAttribute("value");
		} catch (Exception e) {
		}
		try {
			EditdescripOld = PlantEquipmentPage.Description.getAttribute("value");
		} catch (Exception e) {
		}
		try {
			CalifOld = driver.findElement(By.xpath("//input[@id='calibrationExists']")).getAttribute("value");
		} catch (Exception e) {
		}

		try {
//				System.out.println(PlantEquipmentAddMethods.equipData.get(0)+"-"+PlantEquipmentAddMethods.equipData.get(1)+"-"+PlantEquipmentAddMethods.equipData.get(2)+"-"+PlantEquipmentAddMethods.equipData.get(3)+"-"+PlantEquipmentAddMethods.equipData.get(4)+"-"+PlantEquipmentAddMethods.equipData.get(5)+"-"+PlantEquipmentAddMethods.equipData.get(6)+"-"+PlantEquipmentAddMethods.equipData.get(7)+"-"+PlantEquipmentAddMethods.equipData.get(8)+"---"+ 
//						EditplantOld+"-"+EditequipmentOld+"-"+EditserialnoOld+"-"+	EditbrandOld+"-"+EditmodelOld+"-"+EdittypeOld+"-"+EditformatnoOld+"-"+EditdescripOld+"-"+CalifOld
//						);
			assertEquals(
					PlantEquipmentAddMethods.equipData.get(0) + PlantEquipmentAddMethods.equipData.get(1)
							+ PlantEquipmentAddMethods.equipData.get(2) + PlantEquipmentAddMethods.equipData.get(3)
							+ PlantEquipmentAddMethods.equipData.get(4) + PlantEquipmentAddMethods.equipData.get(5)
							+ PlantEquipmentAddMethods.equipData.get(6) + PlantEquipmentAddMethods.equipData.get(7)
							+ PlantEquipmentAddMethods.equipData.get(8),
					EditplantOld + EditequipmentOld + EditserialnoOld + EditbrandOld + EditmodelOld + EdittypeOld
							+ EditformatnoOld + EditdescripOld + CalifOld);

			boolean edit = false;

			if (!Editplant.equals(EditplantOld)) {
				ActionCommonMethod.clicking(driver.findElement(By.xpath("//input[@id='plant']/../..")),
						"Plant Text Box");
				if (ActionCommonMethod.cilicka) {
					ActionCommonMethod.dropDown("//div[@id='plant_list']/div[1]", Editplant, "plant_list");
				}
				if (ActionCommonMethod.dropdwn) {
					edit = true;
				} else {
					PlantEquipmentAddMethods.equipData.remove(9);
					PlantEquipmentAddMethods.equipData.add(9, EditplantOld);
				}
			}

			if (!Editequipment.equals(EditequipmentOld)) {
				ActionCommonMethod.clicking(driver.findElement(By.xpath("//input[@id='equipment']/../..")),
						"Equipment Text Box");
				if (ActionCommonMethod.cilicka) {
					ActionCommonMethod.dropDown("//div[@id='equipment_list']/div[1]", Editequipment, "equipment_list");
				}
				if (ActionCommonMethod.dropdwn) {
					edit = true;
				} else {
					PlantEquipmentAddMethods.equipData.remove(10);
					PlantEquipmentAddMethods.equipData.add(10, EditequipmentOld);
				}
			}

			if (!EditbrandOld.equals(Editbrand)) {
				ActionCommonMethod.sendkey(PlantEquipmentPage.BrandName, Editbrand, "Brand Text Box");
				if (ActionCommonMethod.sendkey) {
					edit = true;

				}
			}

			if (!Editmodel.equals(EditmodelOld)) {
				ActionCommonMethod.sendkey(PlantEquipmentPage.Model, Editmodel, "Modal Text Box");
				if (ActionCommonMethod.sendkey) {
					edit = true;

				}

			}
			if (!Edittype.equals(EdittypeOld)) {
				ActionCommonMethod.clicking(driver.findElement(By.xpath("//input[@id='equipmentType']/../..")),
						"Type Text Box");
				if (ActionCommonMethod.cilicka) {
					ActionCommonMethod.dropDown("//div[@id='equipmentType_list']/div[1]", Edittype,
							"equipmentType_list");
				}
				if (ActionCommonMethod.dropdwn) {
					edit = true;
				}

			}

			if (!Editformatno.equals(EditformatnoOld)) {
				ActionCommonMethod.sendkey(PlantEquipmentPage.FormatNo, Editformatno, "Format No Text Box");
				if (ActionCommonMethod.sendkey) {
					edit = true;

				}

			}
			if (!Editdescrip.equals(EditdescripOld)) {
				ActionCommonMethod.sendkey(PlantEquipmentPage.Description, Editdescrip, "Description Text Box");
				if (ActionCommonMethod.sendkey) {
					edit = true;

				}
			}

			if (!Calif.equals(CalifOld)) {

				ActionCommonMethod.visbleEnable(PlantEquipmentPage.clabration, "Relevant Calibration Check Box");
				if (ActionCommonMethod.enable) {
					try {
						PlantEquipmentPage.clabration.click();
						edit = true;
					} catch (Exception e) {
						String[] x = e.toString().split(":");
						PropertiesCommonMethods.cTestReports("Relevant Calibration Check Box Fill", true, false, x[1]

						);
					}
				}

			}
			if (edit) {
				ActionCommonMethod.clicking(PlantEquipmentPage.Update, "Update Button");
			}
			if (ActionCommonMethod.cilicka) {
				boolean cont = false;
				try {
					wait.until(ExpectedConditions.invisibilityOf(PlantEquipmentPage.FormatNo));
					cont = true;
				} catch (Exception e) {
					cont = false;
				}

				if (cont) {
					String message = null;
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
					PropertiesCommonMethods.cTestReports("Confirm Edit Successfully Message",
							"Plant Equipment Updated Successfully", message, "");
					PlantEquipmentAddMethods.afterEdit();

				} else {
					materialMethodes.validationconfirm("", "", "Plant Equipment Edit");
				}
			}

		} catch (AssertionError e) {
			extent.createTest("Edit Datas Not Match ⚠️");
		}
	}

	public static void afterEdit() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		Thread.sleep(4000);
		String expectplant = PlantEquipmentAddMethods.equipData.get(9);
		String expectEquipment = PlantEquipmentAddMethods.equipData.get(10);
		String expectbrand = PlantEquipmentAddMethods.equipData.get(12);
		String expectmodel = PlantEquipmentAddMethods.equipData.get(13);
		String expecttype = PlantEquipmentAddMethods.equipData.get(14);
		String expectformatno = PlantEquipmentAddMethods.equipData.get(15);
		String expectdescri = PlantEquipmentAddMethods.equipData.get(16);
		String eexpdic = PlantEquipmentAddMethods.equipData.get(17);

		String actualplant = driver.findElement(By.xpath("//tr[2]/td[1]")).getText();
		String actualequipment = driver.findElement(By.xpath("//tr[2]/td[2][@class='ant-table-cell']")).getText();

		String actualbrand = driver.findElement(By.xpath("//tr[2]/td[5]")).getText();

		String actualmodel = driver.findElement(By.xpath("//tr[2]/td[6]")).getText();
		String actualtype = driver.findElement(By.xpath("//tr[2]/td[8]")).getText();
		String actualformatno = driver.findElement(By.xpath("//tr[2]/td[9]")).getText();

		String actualcalibration = "true";
		try {
			driver.findElement(By.xpath("//tr[2]//td[7]//*[@viewBox]")).isDisplayed();
			actualcalibration = "true";
		} catch (Exception e) {
			actualcalibration = "false";
		}
		driver.findElement(By.xpath("//tr[2]/td[10]//*[@viewBox]")).click();
		WebElement cr = null;
		try {
			cr = driver.findElement(By.xpath("//div[text()='Description']/../..//div[@class='ant-modal-body']"));
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(cr));
		} catch (Exception e) {
			// TODO: handle exception
		}
		String actualdis = cr.getText();
		EquipmentEditPageWise.testCaseResult(expectplant, actualplant, "Verify plant Data After Edit");
		EquipmentEditPageWise.testCaseResult(expectEquipment.trim(), actualequipment.trim(),
				"Verify Equipment Data After Edit");
		EquipmentEditPageWise.testCaseResult(expectbrand, actualbrand, "Verify Brand Data After Edit");
		EquipmentEditPageWise.testCaseResult(expectmodel, actualmodel, "Verify Model Data After Edit");
		EquipmentEditPageWise.testCaseResult(expecttype, actualtype, "Verify Type Data After Edit");
		EquipmentEditPageWise.testCaseResult(expectformatno, actualformatno, "Verify Formatno Data After Edit");
		EquipmentEditPageWise.testCaseResult(expectdescri, actualdis, "Verify Description Data After Edit");
		EquipmentEditPageWise.testCaseResult(eexpdic, actualcalibration, "Verify Calibration Data After Edit");
	}

	public static void equipmentFieldEdit() {
		String equipment = null;

		EquipmentPage.equipmenttextbox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		EquipmentPage.equipmenttextbox.sendKeys(equipment);
		EquipmentPage.equipmentsavebutton.click();
	}

	public static void checkEquipmentUpdate() {
		String Editequipment = null;
		driver.findElement(By.xpath("//div[@name='equipment']")).click();

		Actions actions = new Actions(driver);
		boolean update = false;
		for (int j = 0; j < 200; j++) {

			try {
				Thread.sleep(1000);

				driver.findElement(By.xpath("//span[normalize-space()='" + Editequipment + "']")).click();
				update = true;
				break;
			} catch (Exception e) {
				update = false;
				actions.sendKeys(Keys.ARROW_DOWN).perform();
			}

		}
		CommonMethods.TestCasePrint("check Equipment name is updated in plantequipment Equipment dropdown field", true,
				update);
	}

	public static void checkAfterDelete(String code) throws InterruptedException {
		PageFactory.initElements(driver, equipmentPage);

		PageFactory.initElements(driver, page);

		// check the message

		testCase = extent.createTest("Checking Delete After plant Equipment Depended");

		Thread.sleep(3000);
		String actualmessage = EquipmentPage.deleteequipment.getText();
		String expectedmessage = "Can't delete this module";
		String expectedsuccessmessage = "Plant Equipment Successfully Deleted";

//		PlantEquipmentMultipleSearchMethods.serialNoSearch(code);;

		new ArrayList<String>();
		// Actual result of SerialNo
		Thread.sleep(3000);
//		List<String> serialno_Return_List = PlantEquipmentMultipleSearchMethods.tableColumnList(SerialNoTextList,
//				SourcePage.column_fourth);
		System.out.println("actal" + actualmessage);
		try {

			boolean dependdata = true;
			testCase = extent.createTest("CHECK PlantEquipment Delete");

			boolean Successdata = true;
			boolean dataIs = true;
			try {
//				Assert.assertNotNull(serialno_Return_List);
			} catch (AssertionError e) {
				dataIs = false;
			}
			try {
				AssertJUnit.assertEquals(actualmessage, expectedmessage);
			} catch (AssertionError e) {
				dependdata = false;
			}
			try {
				AssertJUnit.assertEquals(actualmessage, expectedsuccessmessage);
			} catch (AssertionError e) {
				Successdata = false;
			}
			System.out.println("data is" + dataIs);
			System.out.println("Successdata is" + Successdata);
			System.out.println("dependdata is" + dependdata);
			if (dataIs && dependdata) {
				testCase.log(Status.INFO, "Actual Data :- " + actualmessage);
				testCase.log(Status.INFO, "Expected Data :- " + expectedmessage);
				testCase.log(Status.PASS, "Cant delete because its dependent");
			} else if (dataIs == false && Successdata == true) {
				testCase.log(Status.INFO, "Actual Data :- " + actualmessage);
				testCase.log(Status.INFO, "Expected Data :- " + expectedsuccessmessage);
				testCase.log(Status.PASS, "Delete Successfullly");
			} else {
				testCase.log(Status.INFO, "Actual Data :- " + actualmessage);
				testCase.log(Status.INFO, "Expected Data if not dependent :- " + expectedsuccessmessage);
				testCase.log(Status.INFO, "Expected Data if dependent:- " + expectedmessage);
				testCase.log(Status.FAIL, "somthing wrong in delete");
			}
		} catch (AssertionError e) {
			testCase = extent.createTest("CHECK Equipment delete");
			testCase.log(Status.FAIL, "No Element");
		}
	}

	public static void addWitChekbox(String testCaseNo) throws InterruptedException {
		System.out.println("testCaseNo" + testCaseNo);
		PageFactory.initElements(driver, equipmentPage);
		int firstrow = CommonMethods.getFirstRowNum(PlantEquipmentAddTest.excel_path, "Plant Equipment", testCaseNo);
		System.out.println("firstrow" + firstrow);
		String plant = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment", firstrow + 1,
				2);
		System.out.println("plant" + plant);
		String equipment = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment",
				firstrow + 1, 3);
		System.out.println("equipment" + equipment);
		String serialno = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment",
				firstrow + 1, 4);
		System.out.println("serialno" + serialno);

		String brand = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment", firstrow + 1,
				5);
		String model = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment", firstrow + 1,
				6);
		String type = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment", firstrow + 1,
				7);
		String formatno = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment",
				firstrow + 1, 8);
		String descrip = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment",
				firstrow + 1, 9);

		Thread.sleep(3000);
		PlantEquipmentPage.plant_INPUT.sendKeys(plant, Keys.RETURN);
		PlantEquipmentPage.Equipmentform.click();

		Thread.sleep(2000);
		Actions actions = new Actions(driver);

		for (int j = 0; j < 200; j++) {

			try {
				driver.findElement(By.xpath(
						"//div[contains(@class,'ant-select-item ant-select-item-option')]//child::span[contains(text(),'"
								+ equipment + "')]"))
						.click();

				break;
			} catch (Exception e) {

				actions.sendKeys(Keys.ARROW_DOWN).perform();
			}

		}
		try {
			Double y = Double.parseDouble(serialno);
			System.out.println(y);

			int w = Double.valueOf(y).intValue();

			PlantEquipmentPage.Serialno.sendKeys(String.valueOf(w));
		} catch (NumberFormatException e) {
			PlantEquipmentPage.Serialno.sendKeys(serialno);
		}

		PlantEquipmentPage.BrandName.sendKeys(brand);
		PlantEquipmentPage.Model.sendKeys(model);

		PlantEquipmentPage.Type.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='" + type + "']"))
				.click();
		PlantEquipmentPage.FormatNo.sendKeys(formatno);
		PlantEquipmentPage.Description.sendKeys(descrip);
		PlantEquipmentPage.calibration.click();

	}

	public static void checkAfterAdd() {

		String expectplant = PlantEquipmentAddMethods.equipData.get(0);
		String expectEquipment = PlantEquipmentAddMethods.equipData.get(1);
		;
		String expectSerialNo = PlantEquipmentAddMethods.equipData.get(2);
		String expectbrand = PlantEquipmentAddMethods.equipData.get(3);
		String expectmodel = PlantEquipmentAddMethods.equipData.get(4);
		String expecttype = PlantEquipmentAddMethods.equipData.get(5);
		String expectformatno = PlantEquipmentAddMethods.equipData.get(6);

		String expectcalibration = PlantEquipmentAddMethods.equipData.get(8);
		boolean actualcalibration = true;
		try {
			actualcalibration = driver.findElement(By.xpath("//tr[2]//td[7]//*[@viewBox]")).isDisplayed();
		} catch (Exception e) {
			actualcalibration = false;
		}

		System.out.println(actualcalibration);

		String actualplant = driver.findElement(By.xpath("//tr[2]/td[1]")).getText();
		String actualequipment = driver.findElement(By.xpath("//tr[2]/td[2]")).getText();
		String actualSerial = driver.findElement(By.xpath("//tr[2]/td[4]")).getText();
		String actualbrand = driver.findElement(By.xpath("//tr[2]/td[5]")).getText();

		String actualmodel = driver.findElement(By.xpath("//tr[2]/td[6]")).getText();
		String actualtype = driver.findElement(By.xpath("//tr[2]/td[8]")).getText();
		String actualformatno = driver.findElement(By.xpath("//tr[2]/td[9]")).getText();

		EquipmentEditPageWise.testCaseResult(expectplant, actualplant, "Verify plant Data After ADD");
		EquipmentEditPageWise.testCaseResult(expectEquipment, actualequipment, "Verify Equipment Data After ADD");
		EquipmentEditPageWise.testCaseResult(expectSerialNo, actualSerial, "Verify Serial-No Data After ADD");
		EquipmentEditPageWise.testCaseResult(expectbrand, actualbrand, "Verify Brand Data After ADD");
		EquipmentEditPageWise.testCaseResult(expectmodel, actualmodel, "Verify Model Data After ADD");
		EquipmentEditPageWise.testCaseResult(expecttype, actualtype, "Verify Type Data After ADD");
		EquipmentEditPageWise.testCaseResult(expectformatno, actualformatno, "Verify Formatno Data After ADD");
		EquipmentEditPageWise.testCaseResult(expectcalibration.toLowerCase(), String.valueOf(actualcalibration),
				"Verify RelaventCalibration After ADD");
	}

	public static void editwithcheckbox() throws InterruptedException {
		PageFactory.initElements(driver, equipmentPage);
		int firstrow = CommonMethods.getFirstRowNum(PlantEquipmentAddTest.excel_path, "Plant Equipment",
				"TC-PLA-EQU-0102");
		String serialno = CommonMethods.ExcelSheetValue(PlantEquipmentAddTest.excel_path, "Plant Equipment",
				firstrow + 1, 2);
		String expectcalibration = CommonMethods.ExcelSheetValue(excelpath, "Plant Equipment", firstrow + 1, 3);
		Thread.sleep(3000);
		Double y = Double.parseDouble(serialno);
		System.out.println(y);

		int w = Double.valueOf(y).intValue();
		driver.findElement(By.xpath("//td[text()='" + w + "']/ancestor::tr//*[@data-icon='edit']")).click();
		EquipmentEditPageWise.ElementFunction(PlantEquipmentPage.calibration, "Relavant Calibration");
		PlantEquipmentPage.calibration.click();
		PlantEquipmentPage.Update.click();
		Thread.sleep(3000);
		boolean actualcalibration = false;
		try {
			driver.findElement(
					By.xpath("//td[text()='" + serialno + "']/ancestor::tr//*[name()='svg'][@data-icon='check']"))
					.isDisplayed();
			actualcalibration = true;
		} catch (Exception e) {
			actualcalibration = false;
		}
		CommonMethods.TestCasePrint("Verify plant equipment edit with checkbox", expectcalibration.toLowerCase(),
				actualcalibration);
	}

	public static void descriptionView(String plant) {
		PageFactory.initElements(driver, equipmentPage);
		driver.findElement(By.xpath("//td[text()='" + plant + "']/ancestor::tr//*[@data-icon='container']")).click();

	}

	public static void plEqcheckDescriptionData(String code, String description) throws InterruptedException {
		PageFactory.initElements(driver, equipmentPage);
		testCase = extent.createTest("STEP-7 CHECK Description button Functionality");
		Thread.sleep(3000);

		driver.findElement(By
				.xpath("//td[normalize-space()='" + code + "']/ancestor::tr//*[name()='svg'][@data-icon='container']"))
				.click();
		try {
			Thread.sleep(3000);

			String actualdata = PlantEquipmentPage.box.getText();
			System.out.println("First row of tanble : " + actualdata);

			// WebElement
			// element=driver.findElement(By.xpath("//td[normalize-space()='"+expecteddata+"']"));

			// String actualdata = element.getText();

			boolean firstdata = true;
			testCase = extent.createTest("CHECK THE ENTERED VALUE HAS SAVED IN THE Description");
			try {
				AssertJUnit.assertEquals(actualdata, description);
			} catch (AssertionError e) {
				firstdata = false;
			}
			if (firstdata) {
				testCase.log(Status.INFO, "Actual Data :- " + actualdata);
				testCase.log(Status.INFO, "Expected Data :- " + description);
				testCase.log(Status.PASS, "Correct description added data");
			} else {
				testCase.log(Status.INFO, "Actual Data :- " + actualdata);
				testCase.log(Status.INFO, "Expected Data :- " + description);
				testCase.log(Status.FAIL, "Wrong description added data");
			}
		} catch (Exception find9) {
			testCase = extent.createTest(" CHECK THE ENTERED VALUE HAS SAVED IN THE Description");
			testCase.log(Status.FAIL, "No Element");
		}
	}

	public static void dataFromPlanEqupment(String tab, String id) {
		equipData.clear();
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;

		try {
			filelocation = "./src/test/resources/Excel/Master Module.xlsx";

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);

			PropertiesCommonMethods.excalRowCount("Master Module.xlsx", tab, id);
			int I = PropertiesCommonMethods.countRow - 1;

			for (int j = 1; j < 20; j++) {
				XSSFSheet sheet = wbook.getSheet(tab);
				row = sheet.getRow(I);
				cell = row.getCell(j);
				String Total = dataValue.formatCellValue(cell);

				equipData.add(Total);

			}

		} catch (Exception e) {
			testCase = extent.createTest("Check The Excel Name Or Tab Name");
			testCase.log(Status.INFO, "Excel is not available ");
			testCase.log(Status.FAIL, "Excel is not Found");

		}
		dataExcel = true;
	}

}
