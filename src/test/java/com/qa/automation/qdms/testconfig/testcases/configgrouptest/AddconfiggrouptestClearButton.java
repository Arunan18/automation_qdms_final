package com.qa.automation.qdms.testconfig.testcases.configgrouptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;

public class AddconfiggrouptestClearButton extends DriverIntialization {
	
	@Test
	public void addconfiggrouptestclearbuttonfun() throws InterruptedException {

		try {
			WebElement tick4 = driver
					.findElement(By.xpath("//*[text()='Test Name']/..//span"));
			
				
			tick4.click();
			Thread.sleep(2000);
		}catch (Exception e) {
			
		}
		Thread.sleep(3000);
		String Value1=null;
		String Value3=null;
		
		try {
			WebElement element= driver.findElement(By.xpath("//span[normalize-space()='Clear']"));
			boolean value1 = element.isDisplayed();
			SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS DISPLAYED", "true", String.valueOf(value1));
			boolean value2 = element.isEnabled();
			SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS ENABLED", "true", String.valueOf(value2));
			element.click();
			Thread.sleep(3000);
			
		

		} catch (Exception e) {
			SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS NOT THERE ", "true", String.valueOf(Value1), String.valueOf(e));

		}
		
		try {
			WebElement tick4 = driver
					.findElement(By.xpath("//*[text()='Test Name']/..//span"));
			boolean value1 = tick4.isDisplayed();
			SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS DISPLAYED", "true", String.valueOf(value1));
			boolean value2 = tick4.isEnabled();
			SampleCommonMethods.TestCasePrint("SUBMIT BUTTON IS ENABLED", "true", String.valueOf(value2));
			try {
				boolean value3 = tick4.isSelected();
				SampleCommonMethods.TestCasePrint("clear button is worked", "false", String.valueOf(value3));
				
			} catch (Exception e) {
				SampleCommonMethods.TestCasePrint("clear button is nit work ", "true", String.valueOf(Value3), String.valueOf(e));
			}
			
			
			
		} catch (Exception e) {
			
		}
		
		
	}

}
