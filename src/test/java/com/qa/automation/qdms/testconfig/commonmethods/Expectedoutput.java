package com.qa.automation.qdms.testconfig.commonmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;

public class Expectedoutput extends DriverIntialization {

	public static void popupwindow(String step_heading, WebElement display_xpath, String display_testcase,
			String enabled_testcase, String Window_testcase) {

		WebElement Expected_Window_xpath = driver.findElement(By.xpath("//div[@class='ant-modal-content']"));
		try {
			testCase = extent.createTest(step_heading);
			if (display_xpath.isDisplayed()) {
				testCase = extent.createTest(display_testcase);
				testCase.log(Status.PASS, "TEST PASS");

				if (display_xpath.isEnabled()) {
					testCase = extent.createTest(enabled_testcase);
					testCase.log(Status.PASS, "TEST PASS");

					Thread.sleep(2000);
					display_xpath.click();

					/*
					 * Check After click the Button Expected Window Shows or Not Expected Window
					 */
					Thread.sleep(2000);
					try {
						if (Expected_Window_xpath.isDisplayed()) {
							testCase.log(Status.PASS, "TEST PASS");
							testCase.log(Status.INFO, Window_testcase + " IS APPEAR");

						} else {
							testCase.log(Status.FAIL, "TEST FAIL");
							testCase.log(Status.INFO, Window_testcase + " DOES NOT APPEAR");
						}

					} catch (Exception e) {
						
					}

				} else {
					testCase = extent.createTest(enabled_testcase);
					testCase.log(Status.FAIL, "TEST FAIL");
				}

			} else {
				testCase = extent.createTest(display_testcase);
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {
		}
	}
}
