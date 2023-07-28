package com.qa.automation.qdms.sample.commonmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;

import com.qa.automation.qdms.sample.pages.SampleNavigationPage;

public class SampleNavigateTest extends DriverIntialization{

	
	public static void sampleNavigation() {
		SampleNavigationPage.sampleXpath().click();
	}

	public static void rawMaterialSampleMainNavigation() {
		SampleNavigationPage.rawMaterialMainXpath().click();
	}
	
	public static void finishProductSampleMainNavigation(){
		SampleNavigationPage.finishProductMainXpath().click();
	}
	
	public static void incommingSampleNavigation() {
		SampleNavigationPage.incommingSampleXpath().click();
	}
	
	public static void inprocessSampleNavigation() {
		SampleNavigationPage.inprocessSampleXpath().click();
	}
	
	public static void labTrialSampleNavigation() {
		SampleNavigationPage.labTrialSampleXpath().click();
	}
	
	public static void productionSampleNavigation() {
		SampleNavigationPage.productionSampleXpath().click();
	}
}  
