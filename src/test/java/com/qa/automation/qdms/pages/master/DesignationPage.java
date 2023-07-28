package com.qa.automation.qdms.pages.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DesignationPage {

	//Employee --> Designation -->Add Form		
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div/div[1]/a/div/div")
	public static WebElement master;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[6]")
	public static WebElement mainEmployee;
	
	@FindBy(xpath = "//div[@class='ant-row']/div/div/div[@class='sc-gzVnrw flBzTM']")
	public static WebElement sideEmployee;
	
	/**********************************************************************************************************
	* MATERIAL STATE PAGE WEBELEMENTS			||		 @author Jathu Jana		||  		Date : 04/07/2023 
	**********************************************************************************************************/
	//Add Designation
	@FindBy(xpath = "//div[@class='ant-table-title']/div/div/div[6]//button")
	public static WebElement addDesignationButton;
	
	//Add Designation Designation TextBox
	@FindBy(xpath = "//*[@id='designation_name']")
	public static WebElement desiDesignationTextBox;
	
	//Add Designation Description TextBox
	@FindBy(xpath = "//*[@id='designation_description']")
	public static WebElement desiDescriptionTextBox;
	
	//Designation Page - Any PopUp Model
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement popUpModel;
	
	//Designation Page - Any PopUp Model Cancel Button
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[2]")
	public static WebElement popUpModelSecondButton;
	
	//Designation Page - Any PopUp Model Save/Update/OK/Edit Button
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[1]")
	public static WebElement popUpModelFirstButton;
	
	//Designation Page - Any PopUp Model Close Button
	@FindBy(xpath = "//div[@class='ant-modal-title']/div/span")
	public static WebElement popUpModelCloseButton;
		
	// Add Designation Success Message
	@FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-success ant-notification-notice-closable']/div/div/div[1]")
	public static WebElement desiSuccessMessage;
	
	//Designation Table First Added Data
	@FindBy(xpath = "//tbody/tr[2]/td[1]")
	public static WebElement firstTableData;
	
	// Add Designation - Designation Validation
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[1]/div[1]")
	public static WebElement desiDesignationValidation;
	
	//Designation Page - Any Inner PopUp Cancel Button
	@FindBy(xpath = "//div[@class='ant-popover-inner-content']")
	public static WebElement innerPopUp;
			
	//Designation Page - Any Inner PopUp Cancel Button
	@FindBy(xpath = "//div[@class='ant-popover-inner-content']//button[1]")
	public static WebElement innerPopUpFirstButton;
	
	//Designation Page - Sub Module Designation Button
	@FindBy(xpath = "//main/div/div/div[1]/div/div[1]")
	public static WebElement desiSubModule;
		
	//Designation Page - Table Title
	@FindBy(xpath = "//div[@class='ant-table-title']/div/div[1]")
	public static WebElement mainTableTitle;
	
	//Designation Page - Search TextBox
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//input")
	public static WebElement SearchPopTextBox;
	
}
