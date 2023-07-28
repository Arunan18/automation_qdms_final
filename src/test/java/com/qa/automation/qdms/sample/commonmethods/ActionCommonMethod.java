/***********************************************************************************
* Description
*------------
*Common Methoid
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 17/04/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*                        17/03/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.commonmethods;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class ActionCommonMethod extends DriverIntialization {
	public static boolean enable = false;
	public static int countOfData=0;
	public static boolean sendkey=false;
	public static boolean cilicka=false;
	public static boolean dropdwn=false;
	public static boolean actions=false;
	/**
	 * 
	 * @param Wookbook       :-ExcelBook
	 * @param tab			 :-Excel Sheet Name
	 * @param uniqueID		 :-Test Id
	 * @param addButton      :-Add Button WebElement
	 * @param textBox        :-Text Boo
	 * @param validationText
	 * @param button
	 */
	public static void addValidation(String Wookbook, String tab, String uniqueID, WebElement addButton,WebElement textBox,
			WebElement validationText, WebElement button) {
		DataFormatter dataValue = new DataFormatter();
		XSSFWorkbook wbook = null;
		XSSFRow row = null;
		XSSFCell cell = null;

		try {
			String filelocation = "./src/test/resources/Excel/" + Wookbook;
			FileInputStream fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			fileIn.close();
		} catch (Exception e) {
		}
		PropertiesCommonMethods.excalRowCount(Wookbook, tab, uniqueID);
		XSSFSheet sheet = wbook.getSheet(tab);
		int r = PropertiesCommonMethods.countRow - 1;
		int stop = sheet.getLastRowNum() + 2;
		for (int i = r; i < stop; i++) {
			
			row = sheet.getRow(i);
			cell = row.getCell(3);
			String type = dataValue.formatCellValue(cell);

			if (type == "") {
				break;
			}
			row = sheet.getRow(i);
			cell = row.getCell(4);
			String validation1 = dataValue.formatCellValue(cell);
			row = sheet.getRow(i);
			cell = row.getCell(5);
			String expated1 = dataValue.formatCellValue(cell);
			addButton.click();
			try {
				Thread.sleep(800);
			} catch (InterruptedException e2) {
			}
			
			textBox.click();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			textBox.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			textBox.sendKeys(validation1);
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {

			}
			String textErrMe = null;
			try {
				textErrMe = validationText.getText();
				
				if (textErrMe=="") {
					button.click();
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
					}
					textErrMe = validationText.getText();
					
				}
			} catch (Exception e1) {
				button.click();
				try {
					Thread.sleep(800);
					textErrMe = validationText.getText();
				} catch (InterruptedException e) {
				}
				
			}
			

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}

			try {
				textErrMe = validationText.getText();
			} catch (Exception e) {
				break;
			}
			button.click();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			Boolean modal=null;
			try {
				 modal=  driver.findElement(By.className("ant-modal-content")).isDisplayed();
			} catch (Exception e) {
				modal=false;
			}
			PropertiesCommonMethods.cTestReports(type, expated1+",Modal Is Displayed-"+true, textErrMe+",Modal Is Displayed-"+modal, "Edit Validation");
         driver.navigate().refresh();
         try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		}
		
	}

	/**
	 * 
	 * @param Wookbook       :-Exceal Name
	 * @param tab			 :-Exceal Tab
	 * @param uniqueID		 :-Test Case Id
	 * @param textBox        :-TExt Box Finder
	 * @param column         :-Search Column
	 * @param clickcolumn    :-Edit Icon Column
	 * @param table          :-Table finder
	 * @param validationText :-Error Message Finder
	 * @param button         :-Save / Update Button
	 * @throws InterruptedException 
	 */
	public static void editValidation(String Wookbook, String tab, String uniqueID,int column,int clickcolumn, WebElement table,WebElement textBox,
			WebElement validationText, WebElement button) throws InterruptedException {
		try {
			driver.findElement(By.xpath("//ul/li[@title='1']")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		WebDriverWait wai=new WebDriverWait(driver, 3);
		DataFormatter dataValue = new DataFormatter();
		XSSFWorkbook wbook = null;
		XSSFRow row = null;
		XSSFCell cell = null;

		try {
			String filelocation = "./src/test/resources/Excel/" + Wookbook;
			FileInputStream fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);
			fileIn.close();
		} catch (Exception e) {
		}
		PropertiesCommonMethods.excalRowCount(Wookbook, tab, uniqueID);
		XSSFSheet sheet = wbook.getSheet(tab);
		int r = PropertiesCommonMethods.countRow - 1;
		int stop = sheet.getLastRowNum() + 2;
		for (int i = r; i < stop; i++) {
			
			row = sheet.getRow(i);
			cell = row.getCell(3);
			String type = dataValue.formatCellValue(cell);

			if (type == "") {
				break;
			}
			row = sheet.getRow(i);
			cell = row.getCell(4);
			String validation1 = dataValue.formatCellValue(cell);
			row = sheet.getRow(i);
			cell = row.getCell(5);
			String expated1 = dataValue.formatCellValue(cell);
			ActionCommonMethod.actionS(column, clickcolumn, table, "edit", Wookbook, tab, uniqueID, 2);
			try {
				wai.until(ExpectedConditions.elementToBeClickable(textBox));
			} catch (Exception e) {
				// TODO: handle exception
			}
			ActionCommonMethod.sendkey(textBox, validation1,type);
			
			if(ActionCommonMethod.sendkey) {
			try {
				button.click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				wai.until(ExpectedConditions.invisibilityOf(textBox));
			} catch (Exception e) {
			}
			String textErrMe = null;
			try {
				textErrMe = validationText.getText();
			} catch (Exception e) {
				// TODO: handle exception
			}
			Boolean modal=null;
			try {
				 modal=  driver.findElement(By.className("ant-modal-content")).isDisplayed();
			} catch (Exception e) {
				modal=false;
			}
			
			PropertiesCommonMethods.cTestReports(type, expated1+",Modal Is Displayed-"+true, textErrMe+",Modal Is Displayed-"+modal, "Edit Validation");
		if (modal) {
			materialMethodes.validationconfirm("","",type);
		}
			}
			try {
			driver.findElement(By.xpath("//div[@class='ant-modal-content']/div[@class='ant-modal-footer']/button[1]"))
					.click();
		} catch (Exception e) {
		}
       
		}

	}

	public static boolean visbleEnable(WebElement Element, String discription) {
		enable=false;
		WebDriverWait wait =new  WebDriverWait(driver, 5);
		boolean x = false;
		boolean dis=false;
		boolean ene=false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Element));
			int hj = Element.getLocation().x;
			x = true;
		} catch (Exception e) {
			x = false;
			PropertiesCommonMethods.TestReportsq(discription + "-Identified By Locator", "true", x, discription);

		}
		if (x == true) {
			 dis = Element.isDisplayed();
			boolean dis1 = dis;
			

			if (dis1==true) {
				 ene = Element.isEnabled();
				enable = ene;
				
			}else {
				PropertiesCommonMethods.cTestReports("Enablety Of " + discription, "true", ene, discription);
			}
		}
		else {
			PropertiesCommonMethods.cTestReports("Visibility Of " + discription, "true", dis, discription);
		}
		return enable;
	}

	/**
	 * @author Quenthan
	 * @param column      :-Web Table Search Data Column
	 * @param clickColumn :-Web Table Target Poin Column(edit / delete/ view
	 *                    /discription)
	 * @param table       :-Table Locator
	 * @param action      :-"edit"/"delete"/"Description"/"Add Key Test"
	 * @param r           :-Search data Row
	 * @param c           :-Search data Column
	 */
	public static void actionS(int column, int clickColumn, WebElement table, String action, String wookBook,
			String tab, String uniqueId, int c) {
		actions=false;
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;
		Boolean not = false;
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
		String iV = dataValue.formatCellValue(cell);
		
		System.out.println(iV);

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

		} 
		else if (action == "Form") {
			value = ".anticon-form";
			value2 = ".ant-modal-content";

		}
		
		else if (action == "Add Key Test") {
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
		

		boolean rept = true;
		List<WebElement> allrows = null;
		int num;

		while (rept == true) {
			allrows = table.findElements(By.cssSelector("tbody tr"));
			num = allrows.size();
			System.out.println(num);
			for (i = 0; i < num; i++) {

				List<WebElement> rows = allrows.get(i).findElements(By.tagName("td"));
				String name = rows.get(column).getText();
				 System.out.println("lk:-"+name);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
				}
				
				try {
					rept = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
							.isEnabled();
				} catch (Exception e) {
					rept=false;				}
				
				if (name.equals(iV)) {
					WebElement input = rows.get(clickColumn).findElement(By.cssSelector(value));
					Boolean dis = input.isDisplayed();

					if (dis == true) {
						Boolean ena = input.isEnabled();
						
						if (ena == true) {
							input.click();
							actions=true;
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {

							}

							Boolean popup=false;
							try {
								 popup = driver.findElement(By.cssSelector(value2)).isDisplayed();
							}catch (Exception e) {
								popup=false;
							}

							
							
							rept = false;
							not = true;
							break;
						
					}else {
						PropertiesCommonMethods.cTestReports("II." + action.toUpperCase() + "-ICON ENABLE", "true", ena,
								action + "-Icon");
					}

				}else {
					PropertiesCommonMethods.cTestReports("I." + action.toUpperCase() + "-ICON DISPLAYED", "true", dis,
							action + "-Icon");
				}
			}}
			if (rept == true) {
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {

				}

			}

			else if (rept == false & not == false) {
				extent.createTest("SEARCHING DATA NOT FIND IN TABLE");

			}
		
	}
		}
		
/**
 * @author Quenthan
 * @category Get Cout Table Data
 * @param table:-wenElement
 * @return
 */
	public static int countDataTable(WebElement table) {
		int num = 0;
		int counte = 0;
		boolean nextPage=true;
		List<WebElement> allrows = null;

		 while (nextPage==true) {
			 num=0;
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					
				}
				try {
					allrows = table.findElements(By.xpath("//tbody/tr[contains(@class,'ant-table-row')]"));
					num = allrows.size();
				} catch (Exception e) {
				}
				counte = counte + num;
				 try {
					nextPage = driver.findElement(By.xpath("//ul/li[@title='Next Page']//button"))
							.isEnabled();
				} catch (Exception e) {
					nextPage = false;
				}
				if (nextPage == true) {
					WebDriverWait wait = new WebDriverWait(driver, 2);
					Actions actio= new Actions(driver);
					actio.sendKeys(Keys.ARROW_DOWN).build().perform();
					try {
						wait.until(ExpectedConditions.elementToBeClickable(
								driver.findElement(By.xpath("//li[@title='Next Page']//button"))));
					} catch (Exception e) {
					}
					driver.findElement(By.xpath("//li[@title='Next Page']//button")).click();
				} 
			 
		}
		countOfData = counte;
		return countOfData;
	}
	
	public static void editValiAction(int column, int clickColumn, WebElement table, String action, String wookBook,
			String tab, String uniqueId, int c) {


		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;
		Boolean not = false;
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
		String iV = dataValue.formatCellValue(cell);
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

		boolean rept = true;
		List<WebElement> allrows = null;
		int num;

		while (rept == true) {
			allrows = table.findElements(By.cssSelector("tbody tr"));
			num = allrows.size();
			for (i = 0; i < num; i++) {

				List<WebElement> rows = allrows.get(i).findElements(By.tagName("td"));
				String name = rows.get(column).getText();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
				}
				rept = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
				// System.out.println(rept);
				if (name.equals(iV)) {
					WebElement input = rows.get(clickColumn).findElement(By.cssSelector(value));
					Boolean dis = input.isDisplayed();
					PropertiesCommonMethods.cTestReports( "EDIT ICON DISPLAYED", "true", dis,
							action + "Edit Icon");

					if (dis == true) {
						Boolean ena = input.isEnabled();
						PropertiesCommonMethods.cTestReports("EDIT ICON ENABLE", "true", ena,
								action + "Edit Icon");
						if (ena == true) {
							input.click();
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {

							}
							Boolean popup = driver.findElement(By.cssSelector(value2)).isDisplayed();
							PropertiesCommonMethods.cTestReports("EDIT ICON IS CLICKED",
									"true", popup, action + "Edit");
							rept = false;
							not = true;
							break;
						}
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

			}
		}
	
		
	}
	
	public static void sendkey(WebElement textbox,String data) {
		String x=textbox.getCssValue("Cursor");
		if (!x.equals("not-allowed")) {
			textbox.click();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
			textbox.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
			textbox.sendKeys(data);
		}else {
			extent.createTest(data +"Send Fail Text Box Not Editable");
		}
		
	}
	public static void sendkey(WebElement textbox,String data,String discription) {

		String v1=textbox.getCssValue("Cursor");


		WebDriverWait wait= new WebDriverWait(driver, 6);
		
		sendkey = false;
		boolean Value1 = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(textbox));
			boolean value1 = textbox.isDisplayed();
			
			if (value1) {
				boolean value2 = textbox.isEnabled();
				
				
				if (value2) {
					if(!v1.equals("not-allowed")) {
					try {
						try {
							textbox.click();
						} catch (Exception e) {
						}
						try {
							textbox.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
						} catch (Exception e) {
						}
												textbox.sendKeys(data);
						sendkey=true;
					} catch (Exception e) {
						String[]x=e.toString().split(":");
						SampleCommonMethods.TestCasePrint(discription + " IS ENABLED", "true", x[1]);
					}}else {
						extent.createTest(discription+" Not Editable ⚠️");
					}
					
				}else {
					SampleCommonMethods.TestCasePrint(discription + " IS ENABLED", "true","false" );
				}
			}
			else {
				SampleCommonMethods.TestCasePrint(discription + " IS DISPLAYED", "true", "false");
			}
			
		} catch (Exception e) {
			String[]x=e.toString().split(":");
			SampleCommonMethods.TestCasePrint(discription + " SendKey Fail", "true", String.valueOf(Value1), x[1]);

		}


		

		
		
		
		
		
		
	
		
	}
	public static void dropdDown(WebElement textbox,String data) {
		
		
		try {
			textbox.click();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	try {
		textbox.sendKeys(data);
		Thread.sleep(1000);
		textbox.sendKeys(Keys.ENTER);
	} catch (Exception e) {
		// TODO: handle exception
		textbox.click();
	}
	
		try {
			driver.findElement(By.xpath("//*[text()='" + data + "']/..")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static boolean visbleEnable2(WebElement Element, String discription,int step) {
		WebDriverWait wit = new WebDriverWait(driver, 20);
		Object x = "false";

		try {
			wit.until(ExpectedConditions.elementToBeClickable(Element));
			x = Element.getLocation().x;
			x = "true";
			PropertiesCommonMethods.TestReportsq("Step-"+step+".I--"+discription + "-Identify Successfully", "true", x, discription);
		} catch (Exception e) {
			x = "false";
			PropertiesCommonMethods.TestReportsq("Step-"+step+".I--"+discription + "-Not Identified", "true", x, discription);

		}
		if (x == "true") {
			Object dis = Element.isDisplayed();
			String dis1 = dis.toString();
			PropertiesCommonMethods.cTestReports("Step-"+step+".II--Visibility Of " + discription, "true", dis, discription);

			if (dis1.equals("true")) {
				boolean ene = Element.isEnabled();
				enable = ene;
				PropertiesCommonMethods.cTestReports("Step-"+step+".III--Enablety Of " + discription, "true", ene, discription);
			}
		}
		return enable;
	}
	
	public static void dateS(WebElement dateTextBox,String date,int I) {
		dateTextBox.click();
		try {
			dateTextBox.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
		} catch (Exception e) {
			// TODO: handle exception
		}
		dateTextBox.click();
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
			driver.findElement(By.xpath("(//td[@title='"+date+"'])["+I+"]")).click();
		
	}
public static void dropedDown(WebElement textbox,String data,int x,String detail ) {
	
	textbox.click();

	
try {
	Thread.sleep(1500);
} catch (InterruptedException e1) {
	// TODO Auto-generated catch block
}
	try {
		driver.findElement(By.xpath("(//div[text()='" + data + "']/..)["+x+"]")).click();
//		PropertiesCommonMethods.cTestReports(detail+"-Drop Down selected", true, true, "Drop Down");
	} catch (Exception e) {
		PropertiesCommonMethods.cTestReports(detail+"-Drop Down selected", false, true, "Drop Down");
	}
	
}

public static void dropDown(String  xpath,String data,String id) {
	driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
	Actions actions = new Actions(driver);
	ArrayList<String> bre=new ArrayList<String>();
	boolean pass = true;
	dropdwn=false;
    while (pass) {
        if (pass) {
            try { 
                try {
                    String fgs= driver.findElement(By.xpath(xpath)).getAttribute("id");
                    bre.add(fgs);
//                    System.out.println(bre);
                    int inb=bre.size();
                    if (inb>=10) {
                        if (bre.get(0).equals(fgs)) {
                            break;
                        } 
                    }
                    
                } catch (Exception e) {
                    // TODO: handle exception
                }
                WebElement list = driver.findElement(By.xpath("//div[contains(@id,'"+id+"')]/..//div[@class='rc-virtual-list']//*[text()='"+data+"']"));
                list.click();
                dropdwn=true;
                pass = false;
            } catch (Exception e) {
            }
        }
        if (pass) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            
        }
        
    }
	
}
public static void clicking(WebElement element,String comment) {


	WebDriverWait wait= new WebDriverWait(driver, 6);
	
	cilicka = false;
	boolean Value1 = false;
	try {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			// TODO: handle exception
		}
		boolean value1 = element.isDisplayed();
		
		if (value1) {
			boolean value2 = element.isEnabled();
			
			
			if (value2) {
				try {
					String cx= element.getCssValue("Cursor");
					System.out.println(cx);
					if (!cx.equals("not-allowed")) {
						element.click();
						cilicka = true;
					}else {
extent.createTest(comment+" Not Clicable ⚠️");
					}
					
				} catch (Exception e) {
					String[] x=e.toString().split(":");
					SampleCommonMethods.TestCasePrint(comment + " IS Clicked", "true", x[1]);
				}
			}else {
				SampleCommonMethods.TestCasePrint(comment + " IS ENABLED", "true", "false");
			}
		}
		else {
			SampleCommonMethods.TestCasePrint(comment + " IS DISPLAYED", "true", "false");
		}
		
	} catch (Exception e) {
		String[] x=e.toString().split(":");
		System.out.println(e);
		SampleCommonMethods.TestCasePrint(comment + " Clicking Fail ", "true", String.valueOf(Value1), x[1]);

	}


	

}
	
}
