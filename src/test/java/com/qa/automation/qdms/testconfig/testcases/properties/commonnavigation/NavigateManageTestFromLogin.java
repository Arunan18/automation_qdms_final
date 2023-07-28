package com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class NavigateManageTestFromLogin extends DriverIntialization {
	static TestConfigPage tcp = new TestConfigPage();
	static ManageTestsPage mtp = new ManageTestsPage();
	static DataFormatter dataValue=new DataFormatter();
	static boolean nullPoint = false;
	static String commonCondition=null;
	public static ArrayList<String> excelDataValue = new ArrayList<String>();
	static String Workbook=null;
	static String TabName=null;
	static String TestCaseId=null;
	static boolean manageTests = true;
	static boolean data=true; 
	public static boolean clicked=false;
	
	public static void navigateManageTestFromLogin(String value,int clickColumnNo)  {
		PageFactory.initElements(driver, tcp);
		PageFactory.initElements(driver, mtp);
		boolean clickConfig = true;
		boolean manageTestConfigure = true;
		
		
//		Login the system
		LoginTest.Login();

		try {
			MultiSearchMethods.Button1(TestConfigPage.testtopnav, "Test Configuration");
			if(MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
			TestConfigPage.testtopnav.click();
			}
			MultiSearchMethods.BtnVisible=true;
			MultiSearchMethods.BtnEnable=true;
		} catch (Exception e) {
			clickConfig = false;
			testCase = extent.createTest("Test Configuration Card Click");
			testCase.log(Status.INFO,"TestConfiguration Card Not Clicked");
			testCase.log(Status.INFO,e.toString());
			testCase.log(Status.FAIL,"Click Fail");
		}

		if (clickConfig) { 
			try {
				MultiSearchMethods.Button1(ManageTestsPage.managetestconfigure, "Manage Test Configure");
				if(MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
				ManageTestsPage.managetestconfigure.click();
				}
				MultiSearchMethods.BtnVisible=true;
				MultiSearchMethods.BtnEnable=true;
			} catch (Exception e) {
				manageTestConfigure = false;
				testCase = extent.createTest("Manage Test Configure Click");
				testCase.log(Status.INFO,"Manage Test Configure Not Clicked");
				testCase.log(Status.INFO,e.toString());
				testCase.log(Status.FAIL,"Click Fail");
			}
		}

		if (manageTestConfigure) {
			if(value.contains("Manage Tests")) {
			try {
				MultiSearchMethods.Button1(ManageTestsPage.manageTest, "Manage Test Configure");
				if(MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
				ManageTestsPage.manageTest.click();
				}
				MultiSearchMethods.BtnVisible=true;
				MultiSearchMethods.BtnEnable=true;
			} catch (Exception e) {
				manageTests = false;
				testCase = extent.createTest("Manage Test  Click");
				testCase.log(Status.INFO,"Manage Test  Not Clicked");
				testCase.log(Status.INFO,e.toString());
				testCase.log(Status.FAIL,"Click Fail");
			}
			} else if (value.contains("Group Tests")) {
				try {
					MultiSearchMethods.Button1(ManageTestsPage.manageGroupTest, "Manage Test Configure");
					if(MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
					ManageTestsPage.manageGroupTest.click();
				}
				MultiSearchMethods.BtnVisible=true;
				MultiSearchMethods.BtnEnable=true;
				} catch (Exception e) {
					manageTests = false;
					testCase = extent.createTest("Manage Test  Click");
					testCase.log(Status.INFO,"Manage Test  Not Clicked");
					testCase.log(Status.INFO,e.toString());
					testCase.log(Status.FAIL,"Click Fail");
				}
			}
		}
		if(manageTests) {
			scroll(clickColumnNo);
		}
		
	}

	
	
	public static void scroll(int size) {
		boolean click=true;
try {
	Thread.sleep(1000);
	driver.findElement(By.xpath("//tr[2]/td[1]")).click();
} catch (Exception e) {
	click=false;
	testCase = extent.createTest("Table Container Click");
	testCase.log(Status.INFO,"Table Container Not Clicked");
	testCase.log(Status.INFO,e.toString());
	testCase.log(Status.FAIL,"Click Fail");
}		
if(click) {
try {
			boolean pass = false;
//			Thread.sleep(1000);

			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("//th[@class='ant-table-cell'][" + size + "]")).click();
						pass = true;
					} catch (Exception e) {
					}
				}

				if (!pass) {
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2);
				} else {
					break;
				}

			}
		} catch (Exception e) {
		}
	}
	}
	
	public static void data() {
		excelDataValue = new ArrayList<String>();
		try {
		String excelPath=System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\"+ Workbook+".xlsx";
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(TabName);

		int firstrow = CommonMethods.getFirstRowNum(excelPath,TabName, TestCaseId);
		
			XSSFRow row = sheet.getRow(firstrow);
			for (int k = 2; k <= 20; k++) {
				try {
					 commonCondition = dataValue.formatCellValue(row.getCell(k));
					String condition = dataValue.formatCellValue(row.getCell(k+1));
					excelDataValue.add(commonCondition);
				} catch (NullPointerException e) {
					nullPoint = true;
					break;
				}
				if (commonCondition.isEmpty()) {
					nullPoint = true;
					break;
				}
				if (nullPoint) {
					break;
				}
			}
			data=true;
			System.out.println(excelDataValue);
			file.close();
		}catch (Exception e) {
			data=false;
			testCase = extent.createTest("Check Excel");
			testCase.log(Status.INFO,"Excel Not Found");
			testCase.log(Status.INFO,e.toString());
			testCase.log(Status.FAIL,"Excel Fail");
		}
	}
	
	public static void clickIcon(String value,int clickColumnNo,String clickType,String Workbooks,String TabNames,String TestCaseIds) {
		Workbook=Workbooks;
		TabName=TabNames;
		TestCaseId=TestCaseIds;
		clicked=false;
		navigateManageTestFromLogin(value,clickColumnNo);
		if(manageTests) {
			scroll(clickColumnNo);
			data();
			String testcase=TestCaseId+"-01";
			AddGroupKey.actionS(0, clickColumnNo, driver.findElement(By.xpath("//div[@class='ant-spin-container']")), clickType,Workbook+".xlsx", TabName, testcase, 2);
			if(AddGroupKey.clicked) {
			clicked=true;
			}
		}
	}
	
	public static void clickandClickIcon(String value,int clickColumnNo,String clickType,String Workbooks,String TabNames,String TestCaseIds,int iconNo){
		Workbook=Workbooks;
		TabName=TabNames;
		TestCaseId=TestCaseIds;
		clicked=false;
		navigateManageTestFromLogin(value,clickColumnNo);
		if(manageTests) {
			scroll(clickColumnNo);
			data();
			String testcase=TestCaseId+"-01";
			AddGroupKey.actionS(0, clickColumnNo, driver.findElement(By.xpath("//div[@class='ant-spin-container']")), clickType,Workbook+".xlsx", TabName, testcase, 2);
			
			try {
				Thread.sleep(500);
				//System.out.println("//td[text()='" + excelDataValue.get(1) + "']//following-sibling::td[4]/span/a["+iconNo+"]/span");
			driver.findElement(By.xpath("//td[text()='" + excelDataValue.get(1) + "']//following-sibling::td[4]/span/a["+iconNo+"]/span")).click();
			} catch (Exception e) {
				if(iconNo==1) {
				testCase = extent.createTest(excelDataValue.get(1)+" Additional Information Edit Click.");
				testCase.log(Status.INFO,"Edit Button Not Clicked");
				testCase.log(Status.INFO,e.toString());
				testCase.log(Status.FAIL,"Edit Click Fail");
				} else if (iconNo==2) {
					testCase = extent.createTest(excelDataValue.get(1)+" Additional Information Delete Click.");
					testCase.log(Status.INFO,"Delete Button Not Clicked");
					testCase.log(Status.INFO,e.toString());
					testCase.log(Status.FAIL,"Delete Click Fail");
				}
			}
			clicked=true;
		}
	}
	
	public static void clickCancelClick(String value,int clickColumnNo,String clickType,String Workbooks,String TabNames,String TestCaseIds,int iconNo) {
		Workbook=Workbooks;
		TabName=TabNames;
		TestCaseId=TestCaseIds;
		clicked=false;
		boolean aa=false;
		navigateManageTestFromLogin(value,clickColumnNo);
		if(manageTests) {
			scroll(clickColumnNo);
			data();
			String testcase=TestCaseId+"-01";
			AddGroupKey.actionS(0, clickColumnNo, driver.findElement(By.xpath("//div[@class='ant-spin-container']")), clickType,Workbook+".xlsx", TabName, testcase, 2);
			
			try {
				Thread.sleep(500);
				//System.out.println("//td[text()='" + excelDataValue.get(1) + "']//following-sibling::td[4]/span/a["+iconNo+"]/span");
			driver.findElement(By.xpath("//td[text()='" + excelDataValue.get(1) + "']//following-sibling::td[4]/span/a["+iconNo+"]/span")).click();
			aa=true;
			} catch (Exception e) {
				if(iconNo==1) {
				testCase = extent.createTest(excelDataValue.get(1)+" Additional Information Edit Click.");
				testCase.log(Status.INFO,"Edit Button Not Clicked");
				testCase.log(Status.INFO,e.toString());
				testCase.log(Status.FAIL,"Edit Click Fail");
				} else if (iconNo==2) {
					testCase = extent.createTest(excelDataValue.get(1)+" Additional Information Delete Click.");
					testCase.log(Status.INFO,"Delete Button Not Clicked");
					testCase.log(Status.INFO,e.toString());
					testCase.log(Status.FAIL,"Delete Click Fail");
				}
			}
			
			if(aa) {
				try {
				driver.findElement(By.xpath("//a[text()='Cancel']")).click();
				} catch (Exception e) {
					testCase = extent.createTest(excelDataValue.get(1)+" Additional Information Edit Cancel Click.");
					testCase.log(Status.INFO,"Edit Cancel Button Not Clicked");
					testCase.log(Status.INFO,e.toString());
					testCase.log(Status.FAIL,"Edit Cancel Click Fail");
				}
			}
			clicked=true;
		}
	}
 
}
