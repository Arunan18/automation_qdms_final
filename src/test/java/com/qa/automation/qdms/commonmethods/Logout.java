package com.qa.automation.qdms.commonmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.PlantPage;

public class Logout extends DriverIntialization {
	static PlantPage pp = new PlantPage();
	/*********************************************************************************************************************************************************
	 * Logout
	 **********************************************************************************************************************************************************/
	@Test
	public static void LogoutFunction() {
		PageFactory.initElements(driver, pp);
		WebDriverWait wait= new WebDriverWait(driver, 15);
		try {
			
			try {
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(
						By.xpath("//header[@class='ant-layout-header']/ul/div/div[2]/div/div/span"))));
			} catch (Exception e) {
			}
			driver.findElement(By.xpath("//header[@class='ant-layout-header']/ul/div/div[2]/div/div/span")).click();
			try {
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
						"//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']/li[5]"))));
			} catch (Exception e) {
			}
			driver.findElement(By.xpath(
					"//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']/li[5]"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (NoSuchElementException e) {
System.out.println("Logout Not Working");
		}
	}
}
