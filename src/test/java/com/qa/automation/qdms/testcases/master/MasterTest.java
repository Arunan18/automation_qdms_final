package com.qa.automation.qdms.testcases.master;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.MasterPage;

public class MasterTest extends DriverIntialization {

	static MasterPage master = new MasterPage();

	@Test

	public static void MasterCard()  {
WebDriverWait wait = new WebDriverWait(driver, 15);
		PageFactory.initElements(driver, master);
		wait.until(ExpectedConditions.elementToBeClickable(MasterPage.masterBtn));
		MasterPage.masterBtn.click();
	}

}
