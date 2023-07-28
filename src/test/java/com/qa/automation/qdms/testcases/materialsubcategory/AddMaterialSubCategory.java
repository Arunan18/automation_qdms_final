/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking Add Material Sub Category Functionality
******************************************************************************************************************
*
* @author 	 : 	 Suntharalingam Arunan
* 
* ======================================================================================================
* 	Test Case Number 	 ||  	Date      ||      Intis     ||   Comments
* ================================================================================================================
*  	TC-MATSC-0040    	    				      Arunan		   Modified version (Rework)		      
******************************************************************************************************************/
package com.qa.automation.qdms.testcases.materialsubcategory;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.MaterialSubCategoryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class AddMaterialSubCategory extends DriverIntialization {

	@Test
	public static void subCat() {
		boolean logout = false;

		LoginTest.Login();
		logout = LoginTest.login;

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateMaterialMain();
		}

		if (MasterMainNavigationsTest.clickMaterialMain) {
			MasterMainNavigationsTest.navigateMaterialSubCategory();
		}
		if (MasterMainNavigationsTest.clicksubCategory) {
			inputSbuValue();
		}

		if (logout) {
			MultiSearchMethods.Logout();
		}
	}

	static MaterialSubCategoryPage mscp = new MaterialSubCategoryPage();
	static DataFormatter dataValue = new DataFormatter();
	static boolean inputValue = false;
	static boolean clickSaveBtn = false;
	static String mainType = null;
	static String materialMainCategory = null;
	static String prefix = null;
	static String materialSubCategory = null;

	public static void inputSbuValue() {
		WebDriverWait wai = new WebDriverWait(driver, 5);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, mscp);
		String testcaseId = "TC-MATSC-0040";
		String tabName = "Material Sub Category";
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		try {
			int firstrow = CommonMethods.getFirstRowNum(excelPath, tabName, testcaseId);
			int lastrow = CommonMethods.getLastRowNum(excelPath, tabName, testcaseId);
			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(tabName);
			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);
				mainType = dataValue.formatCellValue(row.getCell(1));
				materialMainCategory = dataValue.formatCellValue(row.getCell(2));
				prefix = dataValue.formatCellValue(row.getCell(3));
				materialSubCategory = dataValue.formatCellValue(row.getCell(4));
				boolean addBtnClick = false;
				MultiSearchMethods.Button(MaterialSubCategoryPage.addSubCategory, "Material Sub Category Add ");
				if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
					MaterialSubCategoryPage.addSubCategory.click();
					addBtnClick = true;
				}
				boolean input = false;
				if (addBtnClick) {

					MultiSearchMethods.Button(MaterialSubCategoryPage.mainTypes, "Main Type Dropdown");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
//						wait.until(ExpectedConditions.elementToBeClickable(MaterialSubCategoryPage.mainTypes));
						MaterialSubCategoryPage.mainTypes.click();

						if (mainType.contains("RAW_MATERIAL") || mainType.contentEquals("RAW MATERIAL")) {
							wai.until(
									ExpectedConditions.elementToBeClickable(MaterialSubCategoryPage.selectRawMaterial));
							MaterialSubCategoryPage.selectRawMaterial.click();
						} else if (mainType.contains("FINISH_PRODUCT") || mainType.contentEquals("FINISH PRODUCT")) {
							wai.until(ExpectedConditions
									.elementToBeClickable(MaterialSubCategoryPage.selectFinishProduct));
							MaterialSubCategoryPage.selectFinishProduct.click();
						}
					}

					MultiSearchMethods.Button(MaterialSubCategoryPage.materialCategorys,
							"Material Main Category Dropdown");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						MaterialSubCategoryPage.materialCategorys.sendKeys(materialMainCategory);
						int size = 0;
						try {
							size = driver.findElements(By.xpath(
									"//div[@id='material_category_list']//../div[@class='rc-virtual-list']//div[@class='ant-select-item ant-select-item-option']"))
									.size();

							for (int k = 1; k <= size; k++) {
								Thread.sleep(200);
								WebElement main = driver.findElement(By.xpath(
										"//div[@id='material_category_list']//../div[@class='rc-virtual-list']//div[@aria-selected='false']["
												+ k + "]/div"));
								String maincat = main.getText();
								if (maincat.contentEquals(materialMainCategory)) {
									main.click();
								}
							}
						} catch (Exception e) {
						}
					}

					MultiSearchMethods.textBox(MaterialSubCategoryPage.prefixs, "Prefix ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						MaterialSubCategoryPage.prefixs.sendKeys(prefix);
					}

					MultiSearchMethods.textBox(MaterialSubCategoryPage.materialSubCategorys, "Material Sub Category ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						MaterialSubCategoryPage.materialSubCategorys.sendKeys(materialSubCategory);
					}

					input = true;
				}
				boolean save = false;
				if (input) {
					MultiSearchMethods.Button(MaterialSubCategoryPage.SaveBtn, "Save ");
					if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
						MaterialSubCategoryPage.SaveBtn.click();
						save = true;
					}
				}
				boolean saveVisible = false;
				if (save) {
					try {
						wait.until(ExpectedConditions.invisibilityOf(MaterialSubCategoryPage.SaveBtn));
						saveVisible = true;
					} catch (Exception e) {
						saveVisible = false;
					}
				}

				if (saveVisible) {
					String SuccessMsg = "Material Subcategory Added Successfully";
					testCase = extent.createTest(
							"Material Sub Category :- " + materialSubCategory + " - Adding Success Message");
					try {
						wait.until(ExpectedConditions.visibilityOf(MaterialSubCategoryPage.successMessages));
						Assert.assertEquals(MaterialSubCategoryPage.successMessages.getText(), SuccessMsg);
						testCase.log(Status.INFO,
								"Actual Success Message :- " + MaterialSubCategoryPage.successMessages.getText());
						testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
						testCase.log(Status.PASS, "Success Message  Matching, So Throwing Success Message Pass");

						try {
							MaterialSubCategoryPage.successMessageCloseBtn.click();
						} catch (Exception e) {
						}
					} catch (AssertionError e) {
						testCase.log(Status.INFO,
								"Actual Success Message :- " + MaterialSubCategoryPage.successMessages.getText());
						testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
						testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
					} catch (Exception e) {
						testCase.log(Status.INFO,
								"Actual Success Message :- " + MaterialSubCategoryPage.successMessages.getText());
						testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
						testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
					}

					check(MaterialSubCategoryPage.subData, materialSubCategory);
					check(MaterialSubCategoryPage.mainData, materialMainCategory);
					check(MaterialSubCategoryPage.prefixData, prefix);
					check(MaterialSubCategoryPage.mainTypeData, mainType);

					testCase = extent.createTest("Material Sub Category Add Check in First Raw");
					if (check) {
						testCase.log(Status.INFO, "Last Added Material sub Category in First Raw");
						testCase.log(Status.PASS, "Last Added Material sub Category correctly Showing in First Raw ");
					} else {
						testCase.log(Status.INFO, "Last Added Material sub Category Not in First Raw");
						testCase.log(Status.FAIL, "Last Added Material sub Category Wrongly Showing in First Raw ");
					}

				} else {

					try {
						String validation = MaterialSubCategoryPage.mainCatValidation.getText();
						if (validation != "") {
							report("Material Main Category", validation);
							
						}
					} catch (Exception e) {
						// TODO: handle exception
					}

					try {
						String validation1 = MaterialSubCategoryPage.prefiValidation.getText();
						if (validation1 != "") {
							report("Prefix", validation1);
						}
					} catch (Exception e) {
						// TODO: handle exception
					}

					try {
						String validation2 = MaterialSubCategoryPage.subCatValidation.getText();
						if (validation2 != "") {
							report("Material Sub Category", validation2);
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
driver.navigate().refresh();
				}
			}
		} catch (Exception e) {
			driver.navigate().refresh();
			testCase = extent.createTest("Excel File Not Found");
			testCase.log(Status.INFO, "Excel File Not Found");
			testCase.log(Status.FAIL, "Excel File Not Found, So fail");
		}
	}

	static boolean check = false;

	public static void check(WebElement test, String test1) {
		try {
			Assert.assertEquals(test.getText(), test1);
			check = true;
		} catch (AssertionError e) {
			check = false;
		} catch (Exception e) {
			check = false;
		}
	}

public static void report(String name,String Valida) {
	testCase=extent.createTest(name+" Validation Throwing");
	testCase.log(Status.INFO, name+"Validation : "+Valida);
	testCase.log(Status.PASS, "Validation Throwing");
}

	
}
