package com.qa.automation.qdms.sample.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;

public class TestStatus extends DriverIntialization {
	static String teststatus = null;
	static  String searchQuery=null;
	static String materialName=null;
	static String testName=null;
	static String date=null;
	static int noOfTrial=0;
	static int inputParameter=0;
	static String acceptedValue=null;
	static String finalResults=null;
	static String afterDoingTestStatus=null;
	static String excelPath1=null;
	static String ExcelTabName1=null;
	static String TestcaseId1=null;
	static List<WebElement> column1=null; 
	static int nameColumnNo1=0;
	static String workbookName=null;
	static int TestTrialColumnNo1=0;

	static String Specimen=null;



	public static void clickTestAndResults(String name, String ExcelTabName, String TestcaseId,List<WebElement> datacolumn, int nameColumnNo, int TestTrialColumnNo) throws InterruptedException, IOException {
		String excelPath=System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + name + ".xlsx";
		excelPath1=excelPath;
		workbookName=name;
		ExcelTabName1=ExcelTabName;
		TestcaseId1=TestcaseId;
		column1=datacolumn;
		nameColumnNo1=nameColumnNo;
		TestTrialColumnNo1=TestTrialColumnNo;
		int firstrow = CommonMethods.getFirstRowNum(excelPath, ExcelTabName, TestcaseId);
		int lastrow = CommonMethods.getLastRowNum(excelPath, ExcelTabName, TestcaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(ExcelTabName);
		for (int i = firstrow; i <= lastrow; i++) {  
			XSSFRow rowk = sheet.getRow(i);
			searchQuery = rowk.getCell(1).getStringCellValue();
			materialName =  rowk.getCell(2).getStringCellValue();
			testName =  rowk.getCell(3).getStringCellValue();
			date =  rowk.getCell(4).getStringCellValue();
			noOfTrial = (int) rowk.getCell(5).getNumericCellValue();
			inputParameter = (int) rowk.getCell(6).getNumericCellValue();
			acceptedValue = rowk.getCell(7).getStringCellValue();
			finalResults = rowk.getCell(8).getStringCellValue();
			afterDoingTestStatus = rowk.getCell(9).getStringCellValue();
			Specimen = rowk.getCell(10).getStringCellValue();
			// ********************************************************************
			boolean clickNextPage = true;
			boolean sbuExist = false; 
			while (clickNextPage) {
				Thread.sleep(2000); 
				int size=11;
//				try {
//				 size = datacolumn.size();
//				 System.err.println(size);
//				} catch (NoSuchElementException e) {
//					CommonMethods.TestCasePrint("Table column Web Element Not There");
//				}
				if(size>=1) {
				for (int j = 2; j <= size; j++) {
					Thread.sleep(1000);
					String NameXpath_firstPart = "//tbody[@class='ant-table-tbody']/tr[";
					String text=null; 
					try {
					 text = driver.findElement(By.xpath(NameXpath_firstPart + j + "]/td[" + nameColumnNo + "]"))
							.getText();
					 System.out.println(text);
					} catch (NoSuchElementException e) {
						CommonMethods.TestCasePrint("Searched Element Not There");
					}
					Thread.sleep(1500);
					if (text.contains(searchQuery)) {  
						System.out.println(text);
						
						try {
						driver.findElement(
								By.xpath(NameXpath_firstPart + j + "]/td[" + TestTrialColumnNo + "]/span"))
								.click();
						} catch (NoSuchElementException e) {
							CommonMethods.TestCasePrint("Clicked Element Not There");
						}
						sbuExist = true;
						break;
					}

					if(sbuExist) {
						break;
					}
				}
				} else {
					CommonMethods.TestCasePrint("Dont Have any data in WebTable");
				}
				if(sbuExist) {
					break;
				}
				try {
				WebElement next=driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"));
				clickNextPage = next.isEnabled();
				if (clickNextPage == true) {
					Thread.sleep(2000);
					next.click();
				}
				}catch (NoSuchElementException e) {
					CommonMethods.TestCasePrint("Next Button Element Not There");
				}
				
			}
		}
		}

	


	public static void inputTestDataForRawMaterial(String inputDataTestCaseID) throws InterruptedException, IOException {


		Thread.sleep(2000);
		int testCount=0;
		try {
			testCount=driver.findElements(By.xpath("//div[@class='ant-ribbon-wrapper']")).size();
		}catch (Exception e) {
			CommonMethods.TestCasePrint("Dont have any data in Webtable");
		}
		boolean testClick = false;
		for (int j = 1; j <= testCount; j++) {
			Thread.sleep(500);
			WebElement test = driver
					.findElement(By.xpath("//div[@class='sc-bxivhb hSswcz']/div[" + j + "]/div[1]/div/li"));
			String testname = test.getText();
			Thread.sleep(1000);
			if (testname.contains(testName)) {
				teststatus = driver
						.findElement(By.xpath("//div[@class='sc-bxivhb hSswcz']/div[" + j + "]/div[2]/span/div"))
						.getText();
				System.out.println(teststatus);
				test.click();
				testClick = true;
				break;
			}
			if (testClick) { 
				break;
			} 
		}
		Thread.sleep(3000);
		if (teststatus.contentEquals("NEW")) {
			Thread.sleep(1000);
			WebElement testDate = driver.findElement(
					By.xpath("//main[@class='ant-layout-content']/div/div[1]/div[1]/div[2]/div[1]/div[2]/div/div[1]"));
			testDate.click();
						WebElement Dates = driver.findElement(By.xpath("//td[@title='" + date + "']"));
			System.out.println(Dates);
			Thread.sleep(2000); 
			Dates.click();

			WebElement noOfTrials = driver.findElement(By.xpath(
					"//main[@class='ant-layout-content']/div/div[1]/div[1]/div[2]/div[1]/div[3]/div/div[1]/div[2]/input"));
			noOfTrials.sendKeys(String.valueOf(noOfTrial));

			WebElement submitBtn = driver.findElement(
					By.xpath("//main[@class='ant-layout-content']/div/div[1]/div[1]/div[2]/div[2]/div/div/button"));
			submitBtn.click();
		for(int k=1; k<=noOfTrial; k++) {  
			System.out.println("k : "+k);
			String parameterName=null; 
			int parameterValue=0;
			int firstrow1 = CommonMethods.getFirstRowNum(excelPath1, ExcelTabName1, inputDataTestCaseID);
			int lastrow1 = CommonMethods.getLastRowNum(excelPath1, ExcelTabName1, inputDataTestCaseID);
			FileInputStream file1 = new FileInputStream(excelPath1);
			XSSFWorkbook workbook1= new XSSFWorkbook(file1);
			XSSFSheet sheet1 = workbook1.getSheet(ExcelTabName1);
			for (int i = firstrow1; i <= lastrow1; i++) { 
				System.out.println("i : "+i);
				XSSFRow row = sheet1.getRow(i);
				parameterName = (String) row.getCell(1).getStringCellValue();
				System.out.println(parameterName);
				parameterValue = (int) row.getCell(k+1).getNumericCellValue();
			System.out.println(parameterValue);
				for (int j = 1; j <= inputParameter; j++) { 
					System.out.println("j : "+j);
					boolean find=false;
					Thread.sleep(1500);
					WebElement parameter = driver.findElement(By
							.xpath("//main[@class='ant-layout-content']/div/div/div[2]/div[1]/div/div[2]/div/div[" + j + "]"));
					String parametername = parameter.getText();
					Thread.sleep(2000); 
						if (parametername.contains(parameterName)) {
							WebElement inputvalue = driver.findElement(
									By.xpath("//main[@class='ant-layout-content']/div/div/div[2]/div[1]/div/div[2]/div/div[" + j
											+ "]/input"));
							inputvalue.sendKeys(Keys.CONTROL +"a" , Keys.DELETE);
							Thread.sleep(1000);
							inputvalue.sendKeys(String.valueOf(parameterValue));
							find=true;
							j=j+1;
							break; 
						}
						if(find) {
							break;
						}
						Thread.sleep(1500);
					} 
				
			}
			
			WebElement trial = driver.findElement(By.xpath(
					"//main[@class='ant-layout-content']/div/div/div[2]/div[1]/div/div[2]/div/div["+(inputParameter+1)+ "]/div[3]/button"));
			trial.click();
			Thread.sleep(2000); 

		} 
		}
		else if (teststatus.contentEquals("PROCESS")) {
			Thread.sleep(1000);
			WebElement Trial = driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[2]/td[17]/span/span"));
			Trial.click(); 
			Thread.sleep(1000);
				
			for(int k=1; k<=noOfTrial; k++) {  
				System.out.println("k : "+k);
				String parameterName=null; 
				int parameterValue=0;
				int firstrow1 = CommonMethods.getFirstRowNum(excelPath1, ExcelTabName1, inputDataTestCaseID);
				int lastrow1 = CommonMethods.getLastRowNum(excelPath1, ExcelTabName1, inputDataTestCaseID);
				FileInputStream file1 = new FileInputStream(excelPath1);
				XSSFWorkbook workbook1= new XSSFWorkbook(file1);
				XSSFSheet sheet1 = workbook1.getSheet(ExcelTabName1);
				for (int i = firstrow1; i <= lastrow1; i++) { 
					System.out.println("i : "+i);
					XSSFRow row = sheet1.getRow(i);
					parameterName = (String) row.getCell(1).getStringCellValue();
					System.out.println(parameterName);
					parameterValue = (int) row.getCell(k+1).getNumericCellValue();
				System.out.println(parameterValue);
					for (int j = 1; j <= inputParameter; j++) { 
						boolean find=false;
						Thread.sleep(1500);
						WebElement parameter = driver.findElement(By
								.xpath("//main[@class='ant-layout-content']/div/div/div[2]/div[1]/div/div[2]/div/div[" + j + "]"));
						String parametername = parameter.getText();
						Thread.sleep(2000); 
							if (parametername.contains(parameterName)) {
								WebElement inputvalue = driver.findElement(
										By.xpath("//main[@class='ant-layout-content']/div/div/div[2]/div[1]/div/div[2]/div/div[" + j
												+ "]/input"));
								inputvalue.sendKeys(Keys.CONTROL +"a" , Keys.DELETE);
								Thread.sleep(1000);
								inputvalue.sendKeys(String.valueOf(parameterValue));
								find=true;
								j=j+1;
								break; 
							}
							if(find) {
								break;
							}
							Thread.sleep(1500);
						} 
					
				}
				
				WebElement trial = driver.findElement(By.xpath(
						"//main[@class='ant-layout-content']/div/div/div[2]/div[1]/div/div[2]/div/div["+(inputParameter+1)+ "]/div[3]/button"));
				trial.click();
				Thread.sleep(2000); 
				try {
				if(trial.isDisplayed()) {
					trial.click();
				}
				} catch (NoSuchElementException e) {
				}
				Thread.sleep(2000);  
				}
			
		} else { 
			
			Thread.sleep(1000);
			WebElement Trial = driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[2]/td[17]/span/span"));
			Trial.click();
			Thread.sleep(3000);
			for(int i=1; i<=noOfTrial; i++) {
				try {
				WebElement trial = driver.findElement(By.xpath(
						"//main[@class='ant-layout-content']/div/div/div[2]/div[1]/div/div[2]/div/div["+(inputParameter+1)+ "]/div[2]/button"));
				trial.click();
				}catch (NoSuchElementException e) {
					CommonMethods.TestCasePrint("Not There Test Trial Back Button");
				}
			}
			for(int k=1; k<=noOfTrial; k++) {  
				System.out.println("k : "+k);
				String parameterName=null; 
				int parameterValue=0;
//				String TestcaseId1 ="Sample-input";
				int firstrow1 = CommonMethods.getFirstRowNum(excelPath1, ExcelTabName1, inputDataTestCaseID);
				int lastrow1 = CommonMethods.getLastRowNum(excelPath1, ExcelTabName1, inputDataTestCaseID);
				FileInputStream file1 = new FileInputStream(excelPath1);
				XSSFWorkbook workbook1= new XSSFWorkbook(file1);
				XSSFSheet sheet1 = workbook1.getSheet(ExcelTabName1);
				for (int i = firstrow1; i <= lastrow1; i++) { 
					XSSFRow row = sheet1.getRow(i);
					parameterName = (String) row.getCell(1).getStringCellValue();
					System.out.println(parameterName);
					parameterValue = (int) row.getCell(k+1).getNumericCellValue();
				System.out.println(parameterValue);
					for (int j = 1; j <= inputParameter; j++) { 
						boolean find=false;
						Thread.sleep(1500);
						WebElement parameter = driver.findElement(By
								.xpath("//main[@class='ant-layout-content']/div/div/div[2]/div[1]/div/div[2]/div/div[" + j + "]"));
						String parametername = parameter.getText();
						Thread.sleep(2000); 
							if (parametername.contains(parameterName)) {
								WebElement inputvalue = driver.findElement(
										By.xpath("//main[@class='ant-layout-content']/div/div/div[2]/div[1]/div/div[2]/div/div[" + j
												+ "]/input"));
								inputvalue.sendKeys(Keys.CONTROL +"a" , Keys.DELETE);
								Thread.sleep(1000);
								inputvalue.sendKeys(String.valueOf(parameterValue));
								find=true;
								j=j+1;
								break; 
							}
							if(find) {
								break;
							}
							Thread.sleep(1500);
						} 
					
				}
				
				WebElement trial = driver.findElement(By.xpath(
						"//main[@class='ant-layout-content']/div/div/div[2]/div[1]/div/div[2]/div/div["+(inputParameter+1)+ "]/div[3]/button"));
				trial.click();
				Thread.sleep(2000); 
				try {
					String buttonNAme= driver.findElement(By.xpath("//main[@class='ant-layout-content']/div/div/div[2]/div[1]/div/div[2]/div/div[\"+(inputParameter+1)+ \"]/div[3]/button/span")).getText();
				if(buttonNAme.contentEquals("View Results")) {
					trial.click();
				}
				try {
					WebElement next = driver.findElement(By.xpath(
							"//main[@class='ant-layout-content']/div/div/div[2]/div[1]/div/div[2]/div/div["+(inputParameter+1)+ "]/div[4]/button"));
					next.click();
					}catch (NoSuchElementException e) {
						CommonMethods.TestCasePrint("Not There Test Trial Back Button");
					}
				} catch (NoSuchElementException e) {
				}
				Thread.sleep(2000);  
				
				}
		}
					}
	

	public static void testExpected(String TestCaseID) throws IOException, InterruptedException {
	Thread.sleep(3000);
	
		try {
			WebElement testNNAme=driver.findElement(By.xpath("//main[@class='ant-layout-content']/div/div[1]/table/tbody/tr/td[1]"));
			CommonMethods.TestCasePrint("Test Name Visible", testName, testNNAme.getText());
		} catch (Exception e) {
			CommonMethods.TestCasePrint("Test Name Web Element Not There");
		}
		Thread.sleep(500);
		try {
			WebElement testDate=driver.findElement(By.xpath("//main[@class='ant-layout-content']/div/div[1]/table/tbody/tr/td[2]"));
			CommonMethods.TestCasePrint("Test Date Visible", date, testDate.getText());
		} catch (Exception e) {
			CommonMethods.TestCasePrint("Test Date Web Element Not There");
		}
		Thread.sleep(500);
		try {
			WebElement NoOfTrials=driver.findElement(By.xpath("//main[@class='ant-layout-content']/div/div[1]/table/tbody/tr/td[3]"));
			CommonMethods.TestCasePrint("No Of Trial Visible", String.valueOf(noOfTrial), NoOfTrials.getText());
		} catch (Exception e) {
			CommonMethods.TestCasePrint("No Of Trial Web Element Not There");
		}
		Thread.sleep(500);
		try {
			WebElement material=driver.findElement(By.xpath("//main[@class='ant-layout-content']/div/div[1]/table/tbody/tr/td[4]"));
			CommonMethods.TestCasePrint("Material Visible", materialName, material.getText());
		} catch (Exception e) {
			CommonMethods.TestCasePrint("TMaterial Web Element Not There");
		}

		int firstrow = CommonMethods.getFirstRowNum(excelPath1, ExcelTabName1, TestCaseID);
		int lastrow = CommonMethods.getLastRowNum(excelPath1, ExcelTabName1, TestCaseID);
		FileInputStream file = new FileInputStream(excelPath1);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(ExcelTabName1);
		int startRow=firstrow;
		int endRow=lastrow; 
		int startCol=1;

		int endCol=noOfTrial+1;

		Object[][] tableData = new String[endRow - startRow + 1][endCol - startCol + 1];
		for (int i = startRow; i <= endRow; i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=startCol; j<=endCol; j++) {
				XSSFCell cell = row.getCell(j);
				 tableData[i - startRow][j - startCol] = cell.getStringCellValue();
			}
		}
		for (Object[] row : tableData) {  
		    for (Object cell : row) {
		        System.out.print(cell + "\t");
		    }
		    System.out.println(); 
		}
		int startRow1=2;
		int endRow1=driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")).size();
		int startCol1=1;
		int endCol1=noOfTrial+1;
		Object[][] tableData1 = new String[endRow1 - startRow1 + 1][endCol1 - startCol1 + 1];
		for (int i = startRow1; i <= endRow1; i++) {
			for(int j=startCol1; j<=endCol1; j++) { 
				WebElement aa=driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[" +i+ "]/td[" +j+ "]"));
				 tableData1[i - startRow1][j - startCol1] = aa.getText();
			}
		}
		for (Object[] row : tableData1) {
		    for (Object cell : row) {
		        System.out.print(cell + "\t");
		    }
		    System.out.println();  
		}
		ExtentTest testCase = extent.createTest("Entered Value Check");
				try { 
					AssertJUnit.assertArrayEquals(tableData, tableData1);
					testCase.log(Status.INFO, "Web Table & Expected results are correct");
					testCase.log(Status.PASS, "TEST PASS âœ…" );
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Web Table & Expected results are not correct");
					testCase.log(Status.FAIL, "TEST FAIL â�Œ" );
				}
				
				String status=driver.findElement(By.xpath("//div[@class='sc-bxivhb OOFJv']/div[2]/div[2]/div[1]/span")).getText();
				Thread.sleep(1000); 
				String resultsXpath = driver.findElement(By.xpath("//div[@class='sc-bxivhb OOFJv']/div[2]/div[1]/h1/p")).getText();
				String obj[]=resultsXpath.split(": ");
				Object hj=obj[1];
				String result = hj.toString();
				System.out.println(result);
				
				String aceptdValue = driver
						.findElement(By.xpath("//div[@class='ant-spin-container']/div/div[2]/div/div/div[4]/p")).getText();
				System.out.println(aceptdValue);
				String input = aceptdValue;
				String max = "";
				String min = "";
				String[] words = input.split("\\s+");

				for (String word : words) {
					if (word.equalsIgnoreCase("Min")) {
						min = word;
						break;
					}
				}
				for (String word : words) {
					if (word.equalsIgnoreCase("Max")) {
						max = word;
						break;
					}
				}

				System.out.println("Max: " + max);
				System.out.println("Min: " + min);

				if (max.equals("Max") && min.equals("Min")) {
					int rangeStart = Integer.parseInt(input.substring(input.indexOf("is") + 3, input.indexOf("Min")).trim());
					int rangeEnd = Integer.parseInt(input.substring(input.indexOf("-") + 1, input.indexOf("Max")).trim());
					String strt = Double.toString(rangeStart);
					String end = Double.toString(rangeEnd);
					String accepted=strt + " - " + end;
					System.out.println(accepted);
					CommonMethods.TestCasePrint("Accepted Value",acceptedValue,accepted);
					CommonMethods.TestCasePrint("Result Value",finalResults,result);
					CommonMethods.TestCasePrint("Test Status ",afterDoingTestStatus,status);
				} else if (max.equals("Max") && min.equals("")) {
					int maxm = Integer.parseInt(input.substring(input.indexOf("Max") + 3, input.indexOf("is")).trim());
					String maxmium = Double.toString(maxm);
					System.out.println(maxmium);
					CommonMethods.TestCasePrint("Accepted Value",acceptedValue,maxmium);
					CommonMethods.TestCasePrint("Result Value",finalResults,result);
					CommonMethods.TestCasePrint("Test Status ",afterDoingTestStatus,status);

				} else if (max.equals("") && min.equals("Min")) {
					int minm = Integer.parseInt(input.substring(input.indexOf("Min") + 3, input.indexOf("is")).trim());
					String minium = Double.toString(minm);
					System.out.println(minium);
					CommonMethods.TestCasePrint("Accepted Value",acceptedValue,minium);
					CommonMethods.TestCasePrint("Result Value",finalResults,result);
					CommonMethods.TestCasePrint("Test Status ",afterDoingTestStatus,status);
				}
				
				WebElement goSample=driver.findElement(By.xpath("//div[@class='sc-bxivhb OOFJv']/div[2]/div[1]/div/a"));
				goSample.click();
				driver.navigate().refresh();
				Thread.sleep(2000);
				clickTestAndResults(workbookName, ExcelTabName1 , TestcaseId1 ,column1 ,  nameColumnNo1,  TestTrialColumnNo1);
				Thread.sleep(1500);
				int testCount = driver.findElements(By.xpath("//div[@class='ant-ribbon-wrapper']")).size();
				System.out.println(testCount+"************");
				boolean testClick = false;
				String teststatusNew=null;
				for (int k = 1; k <= testCount; k++) {
					Thread.sleep(500);
					WebElement test = driver
							.findElement(By.xpath("//div[@class='sc-bxivhb hSswcz']/div[" + k + "]/div[1]/div/li"));
					String testname = test.getText();
					Thread.sleep(1000);
					if (testname.contains(testName)) {
						teststatusNew = driver
								.findElement(By.xpath("//div[@class='sc-bxivhb hSswcz']/div[" + k + "]/div[2]/span/div"))
								.getText();
						testClick = true;
						break;
					} 
					if (testClick) { 
						break;
					} 
				}
				try {
					driver.findElement(By.xpath("//div[@class='ant-modal-footer']/button[1]")).click();
				}catch (NoSuchElementException e) {
					CommonMethods.TestCasePrint("Cancel Web Element Not There");	
				}
}
	
	
}
