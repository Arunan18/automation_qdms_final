package com.qa.automation.qdms.testconfig.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.automation.qdms.base.DriverIntialization;

public class test extends DriverIntialization {
	
	//test pagination next button
	@FindBy (xpath = "//span[@aria-label='right']//*[name()='svg']")
	public static WebElement testpaginationnexbtn;
		
	//test pagination next button
	@FindBy (xpath = "//div[@class='ant-spin-container']//li[2]/button")
	public static WebElement testpaginationpreviousbtn;
	
	//test pagination dropdown button
	@FindBy (xpath = "//div[@class='ant-spin-container']//li[@class='ant-pagination-options']/div")
	public static WebElement testpaginationdropdownbtn;
	

}
