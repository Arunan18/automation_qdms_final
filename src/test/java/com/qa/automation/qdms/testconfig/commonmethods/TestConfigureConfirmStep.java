package com.qa.automation.qdms.testconfig.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;

public class TestConfigureConfirmStep extends DriverIntialization{
	static Actions actions = new Actions(driver);
	static String code=null;
	static boolean checkTestName=false;
	static int testCount=0;
	static DataFormatter dataValue=new DataFormatter();
	public static void confirmTestConfigure(String Workbook, String ExcelTabName,String TestcaseId, String testname, String testtype,String sampleType, boolean active) throws InterruptedException, IOException {
	String excelPath=System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + Workbook + ".xlsx";
		int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
		int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);
		System.out.println(firstrow + " !!!! " + lastrow);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(ExcelTabName);
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow rowk = sheet.getRow(i);
			code = dataValue.formatCellValue(rowk.getCell(1));
			System.out.println(code + "::::::::::::::::::::::::::");
		}
		try {
			WebElement testConfigure=driver.findElement(By.xpath("//a[@class='sc-bdVaJa ieeiNp'][@href='#/testcreate']"));
			testConfigure.click();
		} catch (NoSuchElementException e) {
			CommonMethods.print("Test Configuration Main Card Not There".toUpperCase());
		}
		Thread.sleep(1500);
		try {
			WebElement manageTestConfigure=driver.findElement(By.xpath("//a[@class='sc-bdVaJa ieeiNp'][@href='#/managetests']"));
			Thread.sleep(1500);
			manageTestConfigure.click();
		} catch (NoSuchElementException e) {
			CommonMethods.print("Manage Test Configure Not There".toUpperCase());
		}
		Thread.sleep(500);
		try {
			WebElement manageTest=driver.findElement(By.xpath("(//div[@class='sc-dnqmqq fyMRQD'])[1]"));
			manageTest.click();
		} catch (NoSuchElementException e) {
			CommonMethods.print("Manage Test Not There".toUpperCase());
		}
		boolean check=false;
		boolean clickNextPage=true;
		while (clickNextPage) {
			Thread.sleep(2000);
			int size =0;
			try {
				List<WebElement> column=driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]"));
			size= column.size();
			} catch (NoSuchElementException e) {
				CommonMethods.print("Table Column Not There".toUpperCase());
			}
			System.out.println(size);
			for (int j = 2; j <= size; j++) {
				System.out.println(j);
				WebElement test=driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[" +j+ "]/td[1]"));
				String testName=test.getText();
				System.err.println(testName);
				Thread.sleep(500);
				System.err.println(testName +" !!! "+testname );
				if(testName.contentEquals(testname)) {
					System.out.println(testName);
					WebElement testType=driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr["+j+"]/td[6]"));
					String testTypes=testType.getText();
					String test1=null;
					if(testTypes.contentEquals("RAW_MATERIAL")) {
						test1="RAW MATERIAL";
					} else if (testTypes.contentEquals("FINISH_PRODUCT")) {
						test1="FINISH PRODUCT";
					}
					System.out.println(testTypes+"+++++++++++++++++++++"+testtype);
					if(test1.contains(testtype)) {
					check=true;
					break;
					}
				}
				
				if(check) {
					break;
				}
			}
			if(check) {
				break;
			}
			try {
				WebElement next = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"));
				clickNextPage = next.isEnabled();
				if (clickNextPage == true) {
					Thread.sleep(500);
					next.click();
				}
			} catch (NoSuchElementException e) {
				CommonMethods.print("Next Button Element Not There".toUpperCase());
			}
			}
			
		ExtentTest testCase = extent.createTest("Check Created Test Available In Manage Test".toUpperCase());
	if(check) {
		testCase.log(Status.INFO, "Created Test there in Manage Test");
		testCase.log(Status.PASS, "TEST PASS ✅");
	} else {
		testCase.log(Status.INFO, "Created Test Not there in Manage Test");
		testCase.log(Status.FAIL, "TEST FAIL ✅");
	}
	
	
//	Confirm created test in Sample 
	Thread.sleep(500);
	try {
		WebElement home=driver.findElement(By.xpath("//a[@class='sc-bdVaJa ieeiNp'][@href='#/']"));
		home.click();
	} catch (NoSuchElementException e) {
		CommonMethods.print("Home Button Element Not There".toUpperCase());
	}
	
	Thread.sleep(500);
	try {
		WebElement sample=driver.findElement(By.xpath("//a[@class='sc-bdVaJa ieeiNp'][@href='#/samples']"));
		sample.click();
	} catch (NoSuchElementException e) {
		CommonMethods.print("Sample Button Element Not There".toUpperCase());
	}
	
	System.err.println(testtype+"********************");
	if(testtype.contains("RAW MATERIAL")) {
		try {
			WebElement first=driver.findElement(By.xpath("//*[@href='#/samples']"));
			first.click();
		} catch (NoSuchElementException e) {
			CommonMethods.print("Incomming Sample Button Element Not There".toUpperCase());
		}
		if(sampleType.equalsIgnoreCase("First")) {
			try {
				WebElement first=driver.findElement(By.xpath("//div[@class='sc-htoDjs jApeNY']/div[1]/div[1]"));
				first.click();
			} catch (NoSuchElementException e) {
				CommonMethods.print("Incomming Sample Button Element Not There".toUpperCase());
			}
			
			boolean check1=false;
			boolean clickNextPage1=true;
			while (clickNextPage1) {
				Thread.sleep(2000);
				int size =0;
				try {
					List<WebElement> column=driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]"));
				size= column.size();
				} catch (NoSuchElementException e) {
					CommonMethods.print("Table Column Not There".toUpperCase());
				}
				System.out.println(size+"++++++++++++");
				for (int j = 1; j <= size; j++) {
					System.out.println(j);
					WebElement test=driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[" +j+ "]/td[1]"));
					String testName=test.getText();
					System.err.println(testName);
					Thread.sleep(500);
					System.err.println(testName +" !!! "+testname );
					if(testName.contentEquals(code)) {
						System.out.println(testName);
						WebElement result=driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[" +j+ "]/td[18]/span"));
						result.click();
						check1=true;
						break;
					}
					
					if(check1) {
						break;
					}
				}
				if(check1) {
					break;
				}
				try {
					WebElement next = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"));
					clickNextPage1 = next.isEnabled();
					if (clickNextPage1 == true) {
						Thread.sleep(500);
						next.click();
					}
				} catch (NoSuchElementException e) {
					CommonMethods.print("Next Button Element Not There".toUpperCase());
				}
				}
			
			try {
				Thread.sleep(1000);
				testCount=driver.findElements(By.xpath("//div[@class='ant-modal-content']/div[2]/div/div")).size();
			} catch (NoSuchElementException e) {
				CommonMethods.print("Count Element Not There");
			}
			for(int k=1; k<=testCount; k++) {
				WebElement test=driver.findElement(By.xpath("//div[@class='ant-modal-content']/div[2]/div/div[" +k+ "]/div[1]/div/li"));
				String createdTestName=test.getText();
				Thread.sleep(500);
				System.out.println("!!!!!"+createdTestName+"##"+testname);
				if(createdTestName.contains(testname)) {
					System.out.println("!!!!! "+createdTestName+"  ##  "+testname);
					checkTestName=true;
				} 
			}
			
			if(active==true) {
				
				ExtentTest testCase1 = extent.createTest("Created Test Checking in Sample".toUpperCase());
				if(checkTestName==true) {
					testCase1.log(Status.INFO, "Created Active Test there in Sample");
					testCase1.log(Status.INFO, "Created Test there in Sample");
					testCase1.log(Status.PASS, "TEST PASS ✅");
				} else {
					testCase1.log(Status.INFO, "Created Active Test Not there in Sample");
					testCase1.log(Status.FAIL, "TEST FAIL ✅");
				}
			} else if (active==false) {
				ExtentTest testCase1 = extent.createTest("Created Test Checking in Sample".toUpperCase());
				if(checkTestName==false) {
					testCase1.log(Status.INFO, "Created Inactive Test there in Sample");
					testCase1.log(Status.PASS, "TEST PASS ✅");
				} else {
					testCase1.log(Status.INFO, "Created Inactive Test Not there in Sample");
					testCase1.log(Status.FAIL, "TEST FAIL ✅");
				}
			}
			if(check1) {
			Thread.sleep(500);
			try {
				WebElement cancel=driver.findElement(By.xpath("//div[@class='ant-modal-footer']/button[1]"));
				cancel.click();
			} catch (NoSuchElementException e) {
				CommonMethods.print("Incomming Sample Cancel Button Element Not There".toUpperCase());
			}
		}
		} else if (sampleType.equalsIgnoreCase("Second")) {
			try {
				WebElement secound=driver.findElement(By.xpath("//div[@class='sc-htoDjs jApeNY']/div[2]/div[1]"));
				secound.click();
			} catch (NoSuchElementException e) {
				CommonMethods.print("InProcess Sample Button Element Not There".toUpperCase());
			}
			
			boolean check1=false;
			boolean clickNextPage1=true;
			while (clickNextPage1) {
				Thread.sleep(2000);
				int size =0;
				try {
					List<WebElement> column=driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]"));
				size= column.size();
				} catch (NoSuchElementException e) {
					CommonMethods.print("Table Column Not There".toUpperCase());
				}
				System.out.println(size);
				for (int j = 1; j <= size; j++) {
					System.out.println(j);
					WebElement test=driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[" +j+ "]/td[1]"));
					String testName=test.getText();
					System.err.println(testName);
					Thread.sleep(500);
					System.err.println(testName +" !!! "+code +" !!!!!!!!!!!!!!");
					if(testName.contentEquals(code)) {
						System.out.println(testName);
						WebElement result=driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[" +j+ "]/td[18]/span"));
						result.click();
						check1=true;
						break;
					}
					
					if(check1) {
						break;
					}
				}
				if(check1) {
					break;
				}
				try {
					WebElement next = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"));
					clickNextPage1 = next.isEnabled();
					if (clickNextPage1 == true) {
						Thread.sleep(500);
						next.click();
					}
				} catch (NoSuchElementException e) {
					CommonMethods.print("Next Button Element Not There".toUpperCase());
				}
				}
			
			try {
				Thread.sleep(1000);
				testCount=driver.findElements(By.xpath("//div[@class='ant-modal-content']/div[2]/div/div")).size();
			} catch (NoSuchElementException e) {
				CommonMethods.print("Count Element Not There");
			}
			for(int k=1; k<=testCount; k++) {
				WebElement test=driver.findElement(By.xpath("//div[@class='ant-modal-content']/div[2]/div/div[" +k+ "]/div[1]/div/li"));
				String createdTestName=test.getText();
				if(createdTestName.contains(testname)) {
					checkTestName=true;
				}
			}
			
			if(active==true) {
				
				ExtentTest testCase1 = extent.createTest("Created Test Checking in Sample".toUpperCase());
				if(checkTestName==true) {
					testCase1.log(Status.INFO, "Created Active Test there in Sample");
					testCase1.log(Status.INFO, "Created Test there in Sample");
					testCase1.log(Status.PASS, "TEST PASS ✅");
				} else {
					testCase1.log(Status.INFO, "Created Active Test Not there in Sample");
					testCase1.log(Status.FAIL, "TEST FAIL ✅");
				}
			} else if (active==false) {
				ExtentTest testCase1 = extent.createTest("Created Test Checking in Sample".toUpperCase());
				if(checkTestName==false) {
					testCase1.log(Status.INFO, "Created Inactive Test there in Sample");
					testCase1.log(Status.PASS, "TEST PASS ✅");
				} else {
					testCase1.log(Status.INFO, "Created Inactive Test Not there in Sample");
					testCase1.log(Status.FAIL, "TEST FAIL ✅");
				}
			}
			if(check1) {
			Thread.sleep(500);
			try {
				WebElement cancel=driver.findElement(By.xpath("//div[@class='ant-modal-footer']/button[1]"));
				cancel.click();
			} catch (NoSuchElementException e) {
				CommonMethods.print("Inprocess Sample Cancel Button Element Not There".toUpperCase());
			}
			}
		} else {
ExtentTest testCase1 = extent.createTest("search added test in sample".toUpperCase());
			
			testCase1.log(Status.INFO, "Didn't Search added test in sample ".toUpperCase());
			testCase1.log(Status.FAIL, "TEST FAIL ".toUpperCase());
		}
		
		
	} else { 

		try {
			WebElement first=driver.findElement(By.xpath("//*[@href='#/finshproductsamples']"));
			first.click();
		} catch (NoSuchElementException e) {
			CommonMethods.print("Incomming Sample Button Element Not There".toUpperCase());
		}
		if(sampleType.equalsIgnoreCase("First")) {
			try {
				WebElement first=driver.findElement(By.xpath("//div[@class='sc-htoDjs jApeNY']/div[1]/div[1]"));
				first.click();
			} catch (NoSuchElementException e) {
				CommonMethods.print("Incomming Sample Button Element Not There".toUpperCase());
			}
			
//			 CALL METHOD TO SCROLL
	        driver.findElement(By.xpath("//div[@class='ant-spin-container']")).click();
	       scroll(3);
	       
			boolean check1=false;
			boolean clickNextPage1=true; 
			while (clickNextPage1) {
				Thread.sleep(2000);
				int size =0;
				try {
					List<WebElement> column=driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]"));
				size= column.size();
				} catch (NoSuchElementException e) {
					CommonMethods.print("Table Column Not There".toUpperCase());
				}
				System.out.println(size);
				for (int j = 1; j <= size; j++) {
					System.out.println(j);
					WebElement test=driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[" +j+ "]/td[4]"));
					String testName=test.getText();
					System.err.println(testName);
					Thread.sleep(500);
					System.err.println(testName +" !!! "+testname );
					if(testName.contentEquals(code)) {
						System.out.println(testName);
						WebElement result=driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[" +j+ "]/td[8]/span"));
						result.click();
						check1=true;
						break;
					}
					
					if(check1) {
						break;
					}
				}
				if(check1) {
					break;
				}
				try {
					WebElement next = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"));
					clickNextPage1 = next.isEnabled();
					if (clickNextPage1 == true) {
						Thread.sleep(500);
						next.click();
					}
				} catch (NoSuchElementException e) {
					CommonMethods.print("Next Button Element Not There".toUpperCase());
				}
				}
			
			try {
				Thread.sleep(1000);
				testCount=driver.findElements(By.xpath("//div[@class='ant-modal-content']/div[2]/div/div")).size();
			} catch (NoSuchElementException e) {
				CommonMethods.print("Count Element Not There");
			}
			
			System.out.println("&&&&&&&&&&&&&"+testCount);
			for(int k=1; k<=testCount; k++) {
				WebElement test=driver.findElement(By.xpath("//div[@class='ant-modal-content']/div[2]/div/div[" +k+ "]/div[1]/div/li"));
				String createdTestName=test.getText();
				if(createdTestName.contains(testname)) {
					checkTestName=true;
				}
			}
			
			if(active==true) {
				
				ExtentTest testCase1 = extent.createTest("Created Test Checking in Sample".toUpperCase());
				if(checkTestName==true) {
					testCase1.log(Status.INFO, "Created Active Test there in Sample");
					testCase1.log(Status.INFO, "Created Test there in Sample");
					testCase1.log(Status.PASS, "TEST PASS ✅");
				} else {
					testCase1.log(Status.INFO, "Created Active Test Not there in Sample");
					testCase1.log(Status.FAIL, "TEST FAIL ✅");
				}
			} else if (active==false) {
				ExtentTest testCase1 = extent.createTest("Created Test Checking in Sample".toUpperCase());
				if(checkTestName==false) {
					testCase1.log(Status.INFO, "Created Inactive Test there in Sample");
					testCase1.log(Status.PASS, "TEST PASS ✅");
				} else {
					testCase1.log(Status.INFO, "Created Inactive Test Not there in Sample");
					testCase1.log(Status.FAIL, "TEST FAIL ✅");
				}
			}
			if(check1) {
			Thread.sleep(500);
			try {
				WebElement cancel=driver.findElement(By.xpath("//div[@class='ant-modal-footer']/button[1]"));
				cancel.click();
			} catch (NoSuchElementException e) {
				CommonMethods.print("Lab Trial Sample Cancel Button Element Not There".toUpperCase());
			}
			}
		} else if (sampleType.equalsIgnoreCase("Second")) {
			try {
				WebElement secound=driver.findElement(By.xpath("//div[@class='sc-htoDjs jApeNY']/div[2]/div[1]"));
				secound.click();
			} catch (NoSuchElementException e) {
				CommonMethods.print("InProcess Sample Button Element Not There".toUpperCase());
			}
			
			boolean check1=false;
			boolean clickNextPage1=true;
			while (clickNextPage1) {
				Thread.sleep(2000);
				int size =0;
				try {
					List<WebElement> column=driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]"));
				size= column.size();
				} catch (NoSuchElementException e) {
					CommonMethods.print("Table Column Not There".toUpperCase());
				}
				System.out.println(size);
				for (int j = 1; j <= size; j++) {
					System.out.println(j);
					WebElement test=driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[" +j+ "]/td[1]"));
					String testName=test.getText();
					System.err.println(testName);
					Thread.sleep(500);
					System.err.println(testName +" !!! "+testname );
					if(testName.contentEquals(code)) {
						System.out.println(testName);
						WebElement result=driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[" +j+ "]/td[18]/span"));
						result.click();
						Thread.sleep(2000);
						check1=true;
						break;
					}
					
					if(check1) {
						break;
					}
				}
				if(check1) {
					break;
				}
				try {
					WebElement next = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"));
					clickNextPage1 = next.isEnabled();
					if (clickNextPage1 == true) {
						Thread.sleep(500);
						next.click();
					}
				} catch (NoSuchElementException e) {
					CommonMethods.print("Next Button Element Not There".toUpperCase());
				}
				}
			
			try {
				Thread.sleep(1000);
				testCount=driver.findElements(By.xpath("//div[@class='ant-modal-content']/div[2]/div/div")).size();
			} catch (NoSuchElementException e) {
				CommonMethods.print("Count Element Not There".toUpperCase());
			} 
			if(check1) {
			System.out.println(testCount+"");
			for(int k=1; k<=testCount; k++) {
				WebElement test=driver.findElement(By.xpath("//div[@class='ant-modal-content']/div[2]/div/div[" +k+ "]/div[1]/div/li"));
				String createdTestName=test.getText();
				if(createdTestName.contains(testname)) {
					checkTestName=true;
				}
			}
			}
			if(active==true) {
				
				ExtentTest testCase1 = extent.createTest("Created Test Checking in Sample".toUpperCase());
				if(checkTestName==true) {
					testCase1.log(Status.INFO, "Created Active Test there in Sample");
					testCase1.log(Status.INFO, "Created Test there in Sample");
					testCase1.log(Status.PASS, "TEST PASS ✅");
				} else {
					testCase1.log(Status.INFO, "Created Active Test Not there in Sample");
					testCase1.log(Status.FAIL, "TEST FAIL ✅");
				}
			} else if (active==false) {
				ExtentTest testCase1 = extent.createTest("Created Test Checking in Sample".toUpperCase());
				if(checkTestName==false) {
					testCase1.log(Status.INFO, "Created Inactive Test there in Sample");
					testCase1.log(Status.PASS, "TEST PASS ✅");
				} else {
					testCase1.log(Status.INFO, "Created Inactive Test Not there in Sample");
					testCase1.log(Status.FAIL, "TEST FAIL ✅");
				}
			}
			if(check1) {
			Thread.sleep(500);
			try {
				WebElement cancel=driver.findElement(By.xpath("//div[@class='ant-modal-footer']/button[1]"));
				cancel.click();
			} catch (NoSuchElementException e) {
				CommonMethods.print("Production Sample Cancel Button Element Not There".toUpperCase());
			}
			}
			testCount=0;
		}
		else {
			ExtentTest testCase1 = extent.createTest("search added test in sample".toUpperCase());
			
			testCase1.log(Status.INFO, "Didn't Search added test in sample ".toUpperCase());
			testCase1.log(Status.FAIL, "TEST FAIL ".toUpperCase());
		}
	}}     
	 public static void scroll(int size) {
		    
		    try {
		        boolean pass = false;
		        Thread.sleep(1000);
		    
		      for (int i = 0; i < 1000; i++) {
		         if (!pass) {
		             try {
		                 driver.findElement(
		                         By.xpath("//th[@class='ant-table-cell']["+size+"]"))
		                         .click();
		                 pass = true;
		             } catch (Exception e) {
		             }
		         } 
		         
		         if (!pass) {
		             
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
	

