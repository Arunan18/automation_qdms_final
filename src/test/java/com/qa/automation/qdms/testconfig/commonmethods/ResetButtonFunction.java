package com.qa.automation.qdms.testconfig.commonmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;

public class ResetButtonFunction extends DriverIntialization {

	public static void ResetButtonFunctions() {

		Boolean value10 = null;
		String value11 = null;
		try {
			WebElement reset = driver.findElement(By.xpath("//span[normalize-space()='Reset']"));
			boolean value1 = reset.isDisplayed();
			SampleCommonMethods.TestCasePrint("RESET BUTTON IS DISPLAYED", "true", String.valueOf(value1));
			try {
				boolean value2 = reset.isEnabled();
				SampleCommonMethods.TestCasePrint("RESET BUTTON IS ENABLED", "true", String.valueOf(value2));
				reset.click();
				try {
					WebElement yes = driver.findElement(By.xpath("//span[normalize-space()='Yes']"));
					boolean value15 = yes.isDisplayed();
					SampleCommonMethods.TestCasePrint("RESET YES BUTTON IS DISPLAYED", "true", String.valueOf(value15));
					boolean value16 = yes.isEnabled();
					SampleCommonMethods.TestCasePrint("RESET YES BUTTON IS DISPLAYED", "true", String.valueOf(value16));
					yes.click();
					try {
						WebElement expectedwindowtab = driver.findElement(By.xpath("//span[normalize-space()='1']"));
						boolean value3 = expectedwindowtab.isDisplayed();
						SampleCommonMethods.TestCasePrint("EXPECTED TAB IS DISPLAYED", "true", String.valueOf(value3));
						try {
							boolean value4 = expectedwindowtab.isEnabled();
							SampleCommonMethods.TestCasePrint("EXPECTED TAB IS ENABLED", "true",
									String.valueOf(value4));
							try {
								boolean value5 = expectedwindowtab.isSelected();
								SampleCommonMethods.TestCasePrint("EXPECTED TAB IS SELECTED", "true",
										String.valueOf(value5));
								try {
									WebElement expectwindowheading = driver.findElement(By.xpath(
											"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div/div[1]"));
									String heading = expectwindowheading.getText();
									SampleCommonMethods.TestCasePrint("EXPECTED TAB VIEW", "true",
											String.valueOf(heading));
									try {
										WebElement testfield = driver.findElement(By.id("test"));
										String testname = testfield.getText();
										SampleCommonMethods.TestCasePrint("TEST FIELD IS NOT RESET", "true",
												String.valueOf(testname));

									} catch (Exception e) {
										SampleCommonMethods.TestCasePrint("TEST FIELD IS RESET", "true",
												String.valueOf(value11), String.valueOf(e));
									}
								} catch (Exception e) {
									SampleCommonMethods.TestCasePrint("EXPECTED TAB IS NOT VIEW", "true",
											String.valueOf(value11), String.valueOf(e));

								}
							} catch (Exception e) {
								SampleCommonMethods.TestCasePrint("EXPECTED TAB IS NOT SELECTED", "true",
										String.valueOf(value11), String.valueOf(e));
							}

						} catch (Exception e) {
							SampleCommonMethods.TestCasePrint("EXPECTED TAB IS NOT ENABLED", "true",
									String.valueOf(value11), String.valueOf(e));
						}
					} catch (Exception e) {
						SampleCommonMethods.TestCasePrint("EXPECTED TAB IS NOT DISPLAYED AND THIS DATA CAN'T REST",
								"true", String.valueOf(value11), String.valueOf(e));
					}
				} catch (Exception e) {
					SampleCommonMethods.TestCasePrint("RESET YES BUTTON IS NOT ENABLED", "true",
							String.valueOf(value11), String.valueOf(e));
				}
			} catch (Exception e) {

				SampleCommonMethods.TestCasePrint("RESET BUTTON IS NOT ENABLED", "true", String.valueOf(value11),
						String.valueOf(e));
			}

		} catch (Exception e) {
			SampleCommonMethods.TestCasePrint("RESET BUTTON IS NOT DISPLAYED", "true", String.valueOf(value11),
					String.valueOf(e));
		}

	}

}
