package com.qa.automation.qdms.sample.commonmethods;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;

public class SelectDate extends DriverIntialization {
public static	int	countPage=0;
	public static boolean clickDon=false;
	
	/**
	 * @author Quenthan
	 * @param wookBook :-Excel Book
	 * @param tab      :-Tab Name
	 * @param uniqueId :-Test Casee Id
	 * @param c        :-Date Column
	 * @param dateTextBox :-Text Box Id/Xpath/class Name
	 */
public static void dateSelect(String wookBook,String tab,String uniqueId,int c,WebElement dateTextBox) {
		
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;
		
		try {
			filelocation = "./src/test/resources/Excel/" + wookBook;

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);

		} catch (Exception e) {
			// TODO: handle exception
		}

		XSSFSheet sheet = wbook.getSheet(tab);
		PropertiesCommonMethods.excalRowCount(wookBook, tab, uniqueId);
		int r=PropertiesCommonMethods.countRow-1;

		row = sheet.getRow(r);
		cell = row.getCell(c);
		String date = dataValue.formatCellValue(cell);
		
		
		dateTextBox.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
		
		
		dateTextBox.sendKeys(date);
		String dates[]=date.split("-");
		String dateee=dates[2];
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		WebElement table =driver.findElement(By.className("ant-picker-content"));
		List<WebElement>	allrows = table.findElements(By.cssSelector("tbody tr"));
	             int	num = allrows.size();
	             
	             for (int j = 0; j < num; j++) {
					List<WebElement> rows = allrows.get(j).findElements(By.tagName("td"));
					for (int i = 0; i < 7; i++) {
			String name = rows.get(i).getText();
					if (name.equals(dateee)) {
						rows.get(i).click();
						
					}
						
					}
					
					
				}
		
	}

/**
 * @author Quenthan
 * @category Get Page Count
 * @param table:-Table WebElement
 * @return
 */
public static int pageCount(WebElement table) {
	int num = 1;
	int counte = 1;
Boolean	nextPage=true;
	List<WebElement> allrows = null;
	

	 while (nextPage==true) {
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			}
			allrows = table.findElements(By.cssSelector("tbody tr"));
			num = allrows.size() - 1;

			nextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
					.isEnabled();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
			}

			if (nextPage == true) {
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				counte = counte + 1;
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}
			} else {
				break;

			}
		} 
	}
	countPage = counte;
	return countPage;
	
}

/**
 * @author Quenthan
 * @param wookBook :-Excel Book
 * @param tab      :-Tab Name
 * @param uniqueId :-Test Casee Id
 * @param c        :-Date Column
 * @param dateTextBox :-Text Box Id/Xpath/class Name
 */
public static void dateSelectT(String wookBook,String tab,String uniqueId,int c,WebElement dateTextBox) {
	try {
		driver.findElement(By.xpath("//ul/li[@title='1']")).click();
	} catch (Exception e) {
	}
	XSSFRow row = null;
	XSSFCell cell = null;
	DataFormatter dataValue = new DataFormatter();
	FileInputStream fileIn = null;
	String filelocation = null;
	XSSFWorkbook wbook = null;
	
	try {
		filelocation = "./src/test/resources/Excel/" + wookBook;

		fileIn = new FileInputStream(filelocation);
		wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);

	} catch (Exception e) {
		// TODO: handle exception
	}

	XSSFSheet sheet = wbook.getSheet(tab);
	PropertiesCommonMethods.excalRowCount(wookBook, tab, uniqueId);
	int r=PropertiesCommonMethods.countRow-1;

	row = sheet.getRow(r);
	cell = row.getCell(c);
	String date = dataValue.formatCellValue(cell);
	
	
	dateTextBox.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
	
	
dateTextBox.sendKeys(date);
	
	
    driver.findElement(By.xpath("//td[@title='"+date+"']")).click();
	
}
/**
 * @author Quenthan
 * @category Get Page Count
 * @param table:-Table WebElement
 * @return
 */
public static int pageCount2(WebElement table) {
	int num = 1;
	int counte = 1;
Boolean	nextPage=true;
	List<WebElement> allrows = null;
	

	 while (nextPage==true) {
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			}
			allrows = table.findElements(By.cssSelector("tbody tr"));
			num = allrows.size() - 1;

			nextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
					.isEnabled();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
			}

			if (nextPage == true) {
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				counte = counte + 1;
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}
			} else {
				break;

			}
		} 
	}
	countPage = counte;
	return countPage;
	
}

public static void sampleAddFuncation() {
	
	
}
public static void click(int column, int clickColumn, WebElement table, String action,String data) {
	try {
		driver.findElement(By.xpath("//ul/li[@title='1']")).click();
	} catch (Exception e) {
		// TODO: handle exception
	}
	clickDon=false;
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e2) {
		// TODO Auto-generated catch block
	}
	Boolean not = false;
	String iV =data ;
	// System.out.println(iV);

	int i = 0;
	String value = null;
	String value2 = null;
	if (action == "delete") {
		value = ".anticon-delete";
		value2 = ".ant-popover-content";
	} else if (action == "edit") {
		value = ".anticon-edit";
		value2 = ".ant-modal-content";

	} else if (action == "copy") {
		value = ".anticon-copy";
		value2 = ".anticon-check-circle";

	}

	else if (action == "Description") {
		value = ".anticon-container";
		value2 = ".ant-modal-content";

	} else if (action == "Add Key Test") {
		value = ".anticon-funnel-plot";
		value2 = ".ant-modal-content";
	}
	else if (action=="Key test") {
		value =".anticon-key";
		value2 =".ant-modal-content";
	}
	else if (action=="More") {
		value =".anticon-ellipsis";
		value2 =".ant-popover-inner";
	}
	else if (action=="Test Status") {
		value =".anticon-experiment";
		value2 =".ant-modal-content";
	}
	else if (action=="Id") {
		value =".anticon-idcard";
		value2 =".ant-modal-content";
	}
	else if (action == "Add") {
		value = ".ant-btn";
		value2 = ".anticon-check-circle";

	}

	boolean rept = true;
	List<WebElement> allrows = null;
	int num;

	while (rept == true) {
		allrows = table.findElements(By.cssSelector("tbody tr"));
		num = allrows.size();
		for (i = 0; i < num; i++) {

			List<WebElement> rows = allrows.get(i).findElements(By.tagName("td"));
			String name = rows.get(column).getText();
			rept = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
			// System.out.println(rept);
			if (name.equals(iV)) {
				not = true;
				WebElement input=null;
				try {
					 input = rows.get(clickColumn).findElement(By.cssSelector(value));	
			
				
				
				Boolean dis = input.isDisplayed();
				
				if (dis == true) {
					Boolean ena = input.isEnabled();
					
					if (ena == true) {
						input.click();
						clickDon=true;
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {

						}
						
						try {
							Boolean popup = driver.findElement(By.cssSelector(value2)).isDisplayed();
							if (popup) {
								PropertiesCommonMethods.cTestReports(
										action.toUpperCase() + "POP UP IS DISPLAYED, " + action + "-ICON IS CLICKED",
										"true", popup, action + "-Icon");
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
						rept = false;
					
						break;
					}
					else {
						PropertiesCommonMethods.cTestReports( action.toUpperCase() + "-ICON ENABLE", "true", ena,
								action + "-Icon");
					}
				}
				else {
					PropertiesCommonMethods.cTestReports(action.toUpperCase() + "-ICON DISPLAYED", "true", dis,
							action + "-Icon");
				}
			}catch (Exception e) {
				
		extent.createTest(action+"- Icon Not Here ⚠️");
		rept = false;
		break;
			}
			}

		}
		if (rept == true) {
			driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}

		}

		else if (rept == false & not == false) {
			extent.createTest("SEARCHING DATA NOT FIND IN TABLE");
			clickDon=false;

		}
	}

	
}


}
