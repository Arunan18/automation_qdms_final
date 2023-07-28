package com.qa.automation.qdms.testcases.login;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.login.LoginPage;

public class LoginTest extends DriverIntialization {
public static boolean login=false;
	static LoginPage loginpg = new LoginPage();

@Test
	public static void Login()  {
	login=false;  
WebDriverWait wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, loginpg);
		XSSFWorkbook workbook=null;
		SoftAssert sa = new SoftAssert();
	try {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Data.xlsx");
	         workbook = new XSSFWorkbook(file);
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	XSSFSheet sheet = workbook.getSheet("Login");
		int rowcount = sheet.getLastRowNum();
		for (int i = 0; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(0);

			String uName = (String) row.getCell(0).getStringCellValue();
			String pWord = (String) row.getCell(1).getStringCellValue();
			String expec = (String) row.getCell(2).getStringCellValue();

			wait.until(ExpectedConditions.elementToBeClickable(LoginPage.Username));
			LoginPage.Username.sendKeys(uName);
			LoginPage.Password.sendKeys(pWord);
			LoginPage.LoginButton.click();

		
//			LoginPage.Username.sendKeys("admin");
//			LoginPage.Password.sendKeys("tokyo@adminA1");
//			LoginPage.LoginButton.click();
login=true;
//			Thread.sleep(2500);

			String actualurl = driver.getCurrentUrl();
			System.out.println(actualurl);

			System.out.println(expec);

			sa.assertEquals(expec, actualurl);

		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[@class='ant-notification-close-x']")))).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
