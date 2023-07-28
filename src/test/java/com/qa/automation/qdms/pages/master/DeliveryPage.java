package com.qa.automation.qdms.pages.master;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryPage {

	// Delivery Multi Search & Reset All XPath
	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/input")
	public static WebElement SearchTextBox;
	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div/button[1]")
	public static WebElement SearchBtn;

	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[1]/div/span[2]")
	public static WebElement DeleverySearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[2]/div/span[2]")
	public static WebElement ProjectSearch;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> DeleveryColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[2]")
	public static List<WebElement> ProjectColumn;

	@FindBy(xpath = "//li[@title='Next Page']/button")
	public static WebElement NextPageBtn;
	@FindBy(xpath = "//li[@title='Previous Page']/button")
	public static WebElement PreviousPageBtn;
	public static String DeleveryColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String DeleveryColumnAfter = "]/td[1]";
	public static String ProjectColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String ProjectColumnAfter = "]/td[2]";

	@FindBy(xpath = "//button[@type='button'][@class='ant-btn ant-btn-danger ant-btn-background-ghost']")
	public static WebElement ResetAll;
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']")
	public static WebElement SearchBox;

	// Master card
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div/div[1]/a/div")
	public static WebElement master;

	/** Material Navigation --> Material **/

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div")
	public static WebElement SuccessMSG;

	@FindBy(xpath = "//div[@class='ant-notification ant-notification-topRight']//div")
	public static WebElement Updatemsg;

	// Top Navigation Bar Material Button
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[3]/span/a")
	public static WebElement NavMaterial;

	// Left Material Button
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[5]")
	public static WebElement LeftMaterial;

	// Import Button
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[4]/span/div/span/button")
	public static WebElement MaterialImportButton;

	// Export Button
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[5]/button")
	public static WebElement MaterialExportButton;

	// Delivery First Added Data
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement firstaddeddata;

	/* Material SBU Filter */

	// SBU Filter ICON
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[9]/div/span[2]")
	public static WebElement SBUIcon;

	// SBU Filter ICON
	@FindBy(xpath = "//input[@name=\"subBusinessUnitName\"]")
	public static WebElement SBUFilterInput;

	// SBU Search Button
	@FindBy(xpath = "//button[@class=\"ant-btn ant-btn-primary ant-btn-sm\"]")
	public static WebElement SBUSearchButton;

	// SBU Search Button
	@FindBy(xpath = "//button[@class=\"ant-btn ant-btn-danger ant-btn-background-ghost\"]")
	public static WebElement SBUSearchResetAllButton;

	/* Material Plant Filter */

	// SBU Filter ICON
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[5]/div/span[2]")
	public static WebElement PlantIcon;

	// SBU Filter ICON
	@FindBy(xpath = "//*[@name=\"plantName\"]")
	public static WebElement PlantFilterInput;

	// SBU Search Button
	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div/button[1]")
	public static WebElement PlantSearchButton;

	/** Customer Navigation --> Delivery **/

	// Top Navigation Bar Customer Button
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[4]/span/a")
	public static WebElement NavCustomer;

	// Left Delivery Button
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[3]")
	public static WebElement LeftDelivery;

	// Delivery Add Button
	@FindBy(xpath = "//div[@class='sc-bxivhb hiMnNy']/div/div/button")
	public static WebElement deliveryaddbtn;

	// Add Button Form Delivery field
	@FindBy(xpath = "//input[@name=\"pour_name\"]")
	public static WebElement enterdeliverycycle;

	// Add Button Form project Dropdown
	@FindBy(xpath = "//input[@id=\"project\"]")
	public static WebElement selectproject;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[2]/div/div[1]")
	public static WebElement dropdown;

	// Add Button Form project Dropdown
	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']/div/div/span")
	public static WebElement dropdownfield;

	// Add Button Form Textarea
	@FindBy(xpath = "//textarea[@id=\"description\"]")
	public static WebElement textarea;

	// Add Button Form Savebtn
	@FindBy(xpath = "(//button[@type='button'])[5]")
	public static WebElement Savebtn;

	// Add Button Form Cancelbtn
	@FindBy(xpath = "//div[@class=\"ant-modal-footer\"]/button[@class=\"ant-btn\"]")
	public static WebElement Cancelbtn;

	// Add Button Form Close Icon
	@FindBy(xpath = "//span[@aria-label='close-circle']//*[name()='svg']")
	public static WebElement Closeicon;

	// Add Button Form Success Message
	@FindBy(xpath = "//div[contains(@class,'ant-notification ant-notification-topRight')]//div")
	public static WebElement successmsg;

	// Delete icon message
	@FindBy(xpath = "//div[@class=\"ant-notification ant-notification-topRight\"]")
	public static WebElement deletemsg;

	/** Edit Button **/
	// Delivery Field Edit Form
	@FindBy(id = "pour_name")
	public static WebElement DeliveryFieldEdit;

	// Delivery Textarea Field Edit Form
	@FindBy(xpath = "//*[@id=\"description\"]")
	public static WebElement DeliverytextareaEdit;

	// Delivery Textarea Field Edit Form
	@FindBy(xpath = "//div[@class=\"ant-modal-footer\"]/button[@class=\"ant-btn sc-gZMcBi dMdnOw\"]")
	public static WebElement EditSavebtn;

	// Delivery Edit Cancel Form
	@FindBy(xpath = "//button[@class=\"ant-btn\"]")
	public static WebElement Editcancelbtn;

	// Delivery Edit project field
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[2]/div/div[1]/div")
	public static WebElement Editproject;

	// Delivery Add ValidationMsg
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[1]/div/div[2]")
	public static WebElement ValidationMsg;

	// Delivery table edit button
	@FindBy(xpath = "//tbody/tr[7]/td[5]/span[1]/a[1]/span[1]//*[name()='svg']")
	public static WebElement Editbtn;

	/** Delete Button */

	// Delivery table delete Confirmation button
	@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[2]")
	public static WebElement Deleteconfirmbtn;

	/** Customer --> Delivery --> Pagination **/

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/a[2]/div")
	public static WebElement NavHomeButton;

	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	public static WebElement totalText;

	@FindBy(xpath = "//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']/li/div")
	public static WebElement CurrentPaginationOpction;

	@FindBy(xpath = "//li[@title='1']/a")
	public static WebElement PageNumber;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> UnitColumn;

	// li[@title='Next Page']/button
	@FindBy(xpath = "//li[@title='Next Page']/button")
	public static WebElement NextPageBtnn;

	@FindBy(xpath = "//li[@title='Previous Page']/button")
	public static WebElement PreviousPageBtnn;

	@FindBy(xpath = "//a[normalize-space()='1']")
	public static WebElement DefaultPaginationPage;

	@FindBy(xpath = "//a[normalize-space()='2']")
	public static WebElement PaginationSecoundPage;

	@FindBy(xpath = "//*[@class='ant-select-item ant-select-item-option'][@title='20 / page']")
	public static WebElement Page_20;

	@FindBy(xpath = "//*[@class='ant-select-item ant-select-item-option'][@title='30 / page']")
	public static WebElement Page_30;

	@FindBy(xpath = "//*[@class='ant-select-item ant-select-item-option'][@title='100 / page']")
	public static WebElement Page_100;

	@FindBy(xpath = "//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']")
	public static WebElement pagination;

	@FindBy(xpath = "//div[@class=\"ant-spin-nested-loading\"]/div/ul/li[@class=\"ant-pagination-total-text\"]")
	public static WebElement paginationCount;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[3]")
	public static WebElement deliverysidebutton;

	/** Logout Button **/

	// LogoutAdminButton
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/div/div[2]/div/div/span")
	public static WebElement logoutAdmin;

	// LogoutButton
	@FindBy(xpath = "/html/body/div[2]/div/div/ul/li[5]")
	public static WebElement logoutButton;

	// ****************************************************************
	//
	// ****************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[3]")
	public static WebElement deliveryleftbutton;

	@FindBy(xpath = "//input[@placeholder='Search Delivery']")
	public static WebElement DeliverySearchTextBox;

//	MODIFIED BY: ARUNAN 16.03.2023
	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div/button[2]")
	public static WebElement resetBtn;

	public List<WebElement> findElements(By tagName) {
		// TODO Auto-generated method stub
		return null;
	}

//**********************SASI'S XPATH DON'T TOUCH *******************************

	// QDMS username xpath
	@FindBy(xpath = "//*[@id ='usernameOrEmail']")
	public static WebElement username;

	// QDMS Password xpath
	@FindBy(id = "password")
	public static WebElement password;

	// QDMS Loginbutton xpath
	@FindBy(xpath = "//button[@type]")
	public static WebElement login;

	// Master card
	@FindBy(xpath = "/html/body/div/div/section/section/main/div/div/div/div[1]/a/div/div")
	public static WebElement Master;

	// Customertopmenu click
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[4]")
	public static WebElement Customertopmenu;

	// Deliverysitebutton Click
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[3]")
	public static WebElement Deliverysitebutton;

	// DeliveryField Click
	@FindBy(xpath = "//input[@id='pour_name']")
	public static WebElement DeliveryField;

	// Savebutton Click
	@FindBy(xpath = "//button[@style='background: rgb(0, 19, 40); color: white; border: none;']")
	public static WebElement Deliverysavebtn;

	// Delivery Validation Click
	@FindBy(xpath = "//div[@style='color: red; font-size: 12px; width: 160px; height: 0.2px;']")
	public static WebElement Deliveryvalidation;

	// ProjectField Click
	@FindBy(xpath = "//input[@id = 'project']")
	public static WebElement ProjectField;

	// Project Validation Click
	@FindBy(xpath = "(//div[normalize-space()=\"Project can't be empty\"])[1]")
	public static WebElement Projectvalidation;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[3]/div/span")
	public static WebElement deliverydespopup;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button")
	public static WebElement deliverydespopupcancelbutton;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/button/span/span")
	public static WebElement deliverydespopupclosebutton;

	@FindBy(xpath = "//li[@class = 'ant-pagination-total-text']")
	public static WebElement deliverypaginationcount;

	@FindBy(xpath = "//div[@class = 'ant-popover-buttons']//button[2]")
	public static WebElement deleteOkButton;

	@FindBy(xpath = "//table//tbody//tr[2]//td[1]")
	public static WebElement tablecolumn;

	@FindBy(xpath = "//span[@title='10 / page']")
	public static WebElement PageDropdown;

	public static String bef = "(//div[@class= 'ant-select-item-option-content'])[";
	public static String aft = "]";

	@FindBy(xpath = "//input[@name='name']")
	public static WebElement SearchBoxDelviery;
	@FindBy(xpath = "//input[@name='projectName']")
	public static WebElement SearchBoxProject;

	// RAHUL.S(21/07/2023)
	@FindBy(xpath = "//input[@id = 'project']/../..")
	public static WebElement projectDropDownField;

	@FindBy(xpath = "//textarea[@id='description']")
	public static WebElement descriptionTextBox;

	@FindBy(xpath = "//table//tbody//tr[2]//td[2]")
	public static WebElement projectColoum;

	@FindBy(xpath = "//div[@class = 'ant-modal-content']")
	public static WebElement editpopup;

	@FindBy(xpath = "//div[@id='rcDialogTitle0']//span")
	public static WebElement closebutton;

}
