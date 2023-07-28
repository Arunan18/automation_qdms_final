package com.qa.automation.qdms.pages.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MasterPage {

	// **********************************************************************************
	// Xpath for Master Card
	// **********************************************************************************

	@FindBy(xpath = "//a[@class='sc-bdVaJa ieeiNp'][@href='#/master/plantlevel']")
	public static WebElement masterBtn;

	/**********************************************************************
	 * Xpath for home button
	 **********************************************************************/
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/a[2]")
	public static WebElement homeButton;
	
	@FindBy(xpath = "//div[normalize-space()='MASTER']")
	public static WebElement masterLogo;
	
		
	}


