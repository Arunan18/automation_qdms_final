package com.qa.automation.qdms.pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	// **********************************************************************************
	// Xpath for Login Username Textbox
	// **********************************************************************************

	@FindBy(id = "usernameOrEmail")
	public static WebElement Username;

	// **********************************************************************************
	// Xpath for Login Password Textbox
	// **********************************************************************************
	
	@FindBy(id = "password")
	public static WebElement Password;

	// **********************************************************************************
	// Xpath for Login Button
	// **********************************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/form/div/div[3]/div/div/span/button")
	public static WebElement LoginButton;

}
