//****************************************************************************************
//										ADD CUSTOMER FUNCTIONAL PAGE
//					@SASIKALA AMBALAVANAR
//					DATE :- 25:02:2023

//****************************************************************************************

package com.qa.automation.qdms.pages.master;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPage {
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

	// Customersitebutton Click
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[1]")
	public static WebElement Customersitebutton;

	// Add Customer Button
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[1]/div/div/div[6]/div/button/span")
	public static WebElement AddCustomerbtn;

	// Customer Import button
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[1]/div/div/div[4]/span/div/span/button/span[2]")
	public static WebElement Customerimportbtn;

	// Customer Export button
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[1]/div/div/div[5]/button/span[2]")
	public static WebElement Customerexportbtn;

	// Customer Save button
	@FindBy(xpath = "//button[@style='background: rgb(0, 19, 40); color: white; border: none;']")
	public static WebElement Customersavebtn;

	// Customer Cancel button
	@FindBy(xpath = "/html/body/div[6]/div/div[2]/div/div[2]/div[3]/button[1]/span")
	/// html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[1]/span")
	public static WebElement Customercancelbtn;

	// Customer Plant Filed
	@FindBy(xpath = "//div[@class='ant-select ant-select-multiple ant-select-show-search']/div/div")
	public static WebElement Customerplantfiled;

	// Customer Plant customer Filed
	@FindBy(xpath = "//input[@id='customer_name']")
	public static WebElement CustomerFiled;

	// Customer Plant Email Filed
	@FindBy(xpath = "//input[@id='customer_email']")
	public static WebElement CustomerEmailFiled;

	// Customer Plant Address Filed
	@FindBy(xpath = "//input[@id='customer_address']")
	public static WebElement CustomerAddressFiled;

	// Customer Plant ContactNumber Filed
	@FindBy(xpath = "//input[@class='ant-input input_number']")
	public static WebElement CustomerContactNoFiled;

	// Customer Allocate Plant ok button
	@FindBy(xpath = "/html/body/div[5]/div/div[2]/div/div[2]/div[3]/button[2]")
	public static WebElement AllocatePlantokbtn;

	// Customer Allocate Plant cancel button
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[1]")
	public static WebElement AllocatePlantcancelbtn;

	// Customer Allocate Plant viewtable button
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[6]/span/span")
	public static WebElement AllocatePlantviewtablebtn;

	// Customer Allocate Plant addplant-emplipitiya button
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/label[7]/span[1]/input")
	public static WebElement AllocatePlantaddplant;

	// Customer RMC Jaffna Plant xpath
	@FindBy(xpath = "//div[@title='RMC Jaffna Plant']")
	public static WebElement Jaffnaplant;

	// Customer RMC Ankanda Plant xpath
	@FindBy(xpath = "//div[@title='RMC Ankanda Plant']")
	public static WebElement Ankandaplant;

	// Customer RMC Elipitiya CLC Plant xpath
	@FindBy(xpath = "//div[@title='Elipitiya CLC Plant']")
	public static WebElement ElipitiyaPlant;

	// Add Customer header click
	@FindBy(xpath = "//div[@class='sc-VigVT jzVhIp']")
	public static WebElement AddCustomerheader;

	// Last added data come in first line
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement AddCustomerfirstdata;

	// Total Size DropDown
	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']")
	public static List<WebElement> AddCustomerdatasizedata;

	// Plant Name Before
	public static String CustomerPlantBefore = "//div[@class='rc-virtual-list']/div/div/div/div[";

	// Plant Name After
	public static String CustomerPlantAfter = "]";

	// Add Customer Close Icon
	@FindBy(xpath = "//span[@aria-label='close-circle']//*[name()='svg']")
	public static WebElement closeicon;

	// plant dropdown
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[1]/div/div[1]")
	public static WebElement plantdropdownholder;

	// Click Allocate Plant button
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[6]/span/span")
	public static WebElement Allocateplantbtn;

	// Click Allocate Plant button
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/label[7]/span[2]")
	public static WebElement Allocateplantckboxclick;

	// Click Cancel Button
	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[1]")
	public static WebElement Cancelbtn;

	// Click ok button
	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[2]")
	public static WebElement Okbtn;

	// Customersitebutton Click
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[1]")
	public static WebElement Customersitebuttons;

	// Count Pagination
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[1]")
	public static WebElement totalpaginationcount;

	// CurrentPaginationOption
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[11]/div")
	public static WebElement CurrentPaginationOption;

	// First page number(1-xapth)
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[3]/a")
	public static WebElement PageNumber;

	// Customer Column xpath first
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]")
	public static List<WebElement> UnitColumn;

	// page 10
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[11]/div/div[1]/span[2]")
	public static WebElement page10;

	// Page 20
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[11]/div/div[1]/span[2]")
	public static WebElement Page_20;
	// Page 30
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[11]/div/div[1]/span[2]")
	public static WebElement Page_30;
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[11]/div/div[1]/span[2]")
	public static WebElement Page_100;

	@FindBy(xpath = "//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']")
	public static WebElement pagination;

	// Edit Customer Button
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[7]/span/a[1]/span")
	public static WebElement EditCustomerbtn;

	// Edit (Update) button
	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[2]")
	public static WebElement Updatebtn;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[2]/div/div[1]")
	public static WebElement validation;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[1]/div/div[1]/div/div/div[1]/span/span[2]/span")
	public static WebElement unselect;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[1]/div/div[2]")
	public static WebElement dropDownValid;

	// Last added data come in first line
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement EditCustomerfirstdata;

	// Customer Add Success Message
	@FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-success ant-notification-notice-closable']")
	public static WebElement AddCustomersuccessmsg;

	// Customer Update Success Message
	@FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-success ant-notification-notice-closable']")
	public static WebElement UpdateCustomersuccessmsg;

	// DropdownBoxclick
	@FindBy(xpath = "//div[@class='ant-select ant-select-sm ant-pagination-options-size-changer ant-select-single ant-select-show-arrow']")
	public static WebElement DropdownBoxclick;

	// Dropdown10Pageclick
	@FindBy(xpath = "//div[@title='10 / page']")
	public static WebElement Dropdown10Pageclick;

	// Dropdown20Pageclick
	@FindBy(xpath = "//div[@title='20 / page']")
	public static WebElement Dropdown20Pageclick;

	// Dropdown30Pageclick
	@FindBy(xpath = "//div[@title='30 / page']")
	public static WebElement Dropdown30Pageclick;

	// Dropdown30Pageclick
	@FindBy(xpath = "//div[@title='100 / page']")
	public static WebElement Dropdown100Pageclick;

	// DropDownValidation
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[1]/div/div[2]")
	public static WebElement dropDownValidation;

	// CustomerValidation
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[2]/div/div[1]")
	public static WebElement CustomerValidation;

	// Cancelbuttoncustomer
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[1]/span")
	public static WebElement cancelbuttoncustomer;

	// CustomerReset Button
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement Resetbutton;

	//
	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement CancelbuttonCustomerscreen;

//************************************************************************************************

//Customer Multi Search XPath

	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//input")
	public static WebElement SearchTextBox;
	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div/button[1]")
	public static WebElement SearchBtn;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[1]/div/span[2]")
	public static WebElement CustomerSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[2]/div/span[2]")
	public static WebElement PlantSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[3]/div/span[2]")
	public static WebElement EmailSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[4]/div/span[2]")
	public static WebElement ContactNoSearch;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[1]/div/div/div[3]/button/span")
	public static WebElement ResetAll;
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']")
	public static WebElement SearchBox;

//	@FindBy(xpath = "//li[@title='Next Page']/button")
//	public static WebElement NextPageBtn;
//	@FindBy(xpath = "//li[@title='Previous Page']/button")
//	public static WebElement PreviousPageBtn;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> CustomerColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[2]")
	public static List<WebElement> PlantColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[3]")
	public static List<WebElement> EmailColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[4]")
	public static List<WebElement> ContactNoColumn;

	public static String CustomerColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String CustomerColumnAfter = "]/td[1]";
	public static String PlantColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String PlantColumnAfter = "]/td[2]";
	public static String EmailColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String EmailColumnAfter = "]/td[3]";
	public static String ContactNoColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String ContactNoColumnAfter = "]/td[4]";

	// ***********************************************************************
	// Xpath for Pagination Last Page - Priyanka
	// **********************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[9]")
	public static WebElement paginationlastpage;

	// ****************************************************************************************************

	@FindBy(xpath = "//a[@href='#/master/customerlevel']")
	public static WebElement customerlevel;

	@FindBy(xpath = "//div[@class='sc-dnqmqq hnktPT'][normalize-space()='Customer']")
	public static WebElement customer;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement customerdata;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]/span")
	public static WebElement searchicon;

	@FindBy(xpath = "//input[@placeholder=' Customer']")
	public static WebElement searchtextbox;

	@FindBy(xpath = "//span[normalize-space()='Search']")
	public static WebElement searchok;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[7]/span/a[2]/a/span")
	public static WebElement deletebutton;

	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement deletepopover;

	@FindBy(xpath = "//span[normalize-space()='OK']")
	public static WebElement deleteok;

	@FindBy(xpath = "//div[@class='sc-dnqmqq hnktPT'][normalize-space()='Project']")
	public static WebElement project;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[4]/div/span[2]/span")
	public static WebElement searchiconcustomer;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[4]")
	public static WebElement customernameinproject;

	@FindBy(xpath = "//li[contains(@class, 'ant-pagination-item') and not(contains(@class, 'ant-pagination-item-74'))][(last() + 1) div 2]")
	public static WebElement middlepage;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[4]")
	public static WebElement projectcudata;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[2]")
	public static WebElement deleteOkButton;

	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	public static WebElement dataCount;

	@FindBy(xpath = "//td[text()='K - P Construction']//following-sibling::td[4]//span[@class='anticon anticon-ellipsis']")
	public static WebElement moreDetailsCustomer;

	@FindBy(xpath = "//div[@class='ant-popover ant-popover-placement-top ']//div[@class='ant-popover-inner']")
	public static WebElement moredetailsmodalcontent;

	@FindBy(xpath = "//div[@class='ant-popover ant-popover-placement-top ']//div[@class='ant-popover-inner-content']")
	public static WebElement moremodalcontent;

	@FindBy(xpath = "//td[text()='K - P Construction']//following-sibling::td[5]//span[@class='anticon anticon-idcard']")
	public static WebElement allocatePlantBtnCustomer;

	@FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='ant-modal-body']")
	public static WebElement allocatePlantmodalcontent;

	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement cancelButton;

	@FindBy(xpath = "(//span[@aria-label='search'])[1]")
	public static WebElement customerSearchICon;
	@FindBy(xpath = "//input[@placeholder=' Customer']")
	public static WebElement customerSearchTextBox;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/button[1]/span[1]")
	public static WebElement customerSearchButton;

// ********************** Modified By:-@Sasi*********************************
	// CustomerHeader
	@FindBy(xpath = "//div[@class='ant-spin-container']/div/div/div/div/div[1]")
	public static WebElement CustomerHeader;

	// CustomerPLANTSEARCH Button
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement PLANTSEARCHButton;
	// ********************** Modified By:-Priyanka*********************************
	// CustomerHeader
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[1]")
	public static WebElement CustomerCancelBUtton;

	// *************@Modified By :- SASI****************

	// Admin Click button
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/div/div[2]/div/div/span")
	public static WebElement Adminbtn;

	// Logout Button
	@FindBy(xpath = "//span[@class='ant-dropdown-menu-title-content']/p")
	public static WebElement Logoutbtn;

	@FindBy(xpath = "//form/div[1]/div[1]/div/div[2]")
	public static WebElement plantvalidation;

	@FindBy(xpath = "//input[@id='customer_name']//ancestor::div[@class='input_wrapper']//div[1]")
	public static WebElement customervalidation;

	@FindBy(xpath = "//input[@id='customer_email']//ancestor::div[@class='input_wrapper']//div[1]")
	public static WebElement emailvalidation;

	@FindBy(xpath = "//input[@id='customer_address']//ancestor::div[@class='input_wrapper']//div[1]")
	public static WebElement addressvalidation;

	@FindBy(xpath = "//input[@id='customer_contactno']//ancestor::div[@class='input_wrapper']//div[1]")
	public static WebElement contactnovalidation;

	@FindBy(xpath = "//div[@class='ant-table-body']//tr[2]//td[1]")
	public static WebElement tablefirstrow;

// @Sasikala - 11.07.2023

	// Customer Search icon
	@FindBy(xpath = "//th[1]//span[@role='img']")
	public static WebElement customersearchicon;

	// Customer Search TextBox
	@FindBy(xpath = "//input[@placeholder=' Customer']")
	public static WebElement customersearchtextbox;

	// Customer Search Button
	@FindBy(xpath = "//button[@type='button']//span[text()='Search']")
	public static WebElement customersearchButton;

	// Plant Search icon
	@FindBy(xpath = "//th[2]//span[@role='img']")
	public static WebElement Plantsearchicon;

	// Plant Search TextBox
	@FindBy(xpath = "//input[@placeholder=' Plant']")
	public static WebElement Plantsearchtextbox;

	// Plant Search Button
	@FindBy(xpath = "//button[@type='button']//span[text()='Search']")
	public static WebElement PlantsearchButton;

	@FindBy(xpath = "//li[@title='Next Page']/button")
	public static WebElement NextPageBtn;
	@FindBy(xpath = "//li[@title='Previous Page']/button")
	public static WebElement PreviousPageBtn;

	@FindBy(xpath = "//a[normalize-space()='1']")
	public static WebElement DefaultPaginationPage;
	@FindBy(xpath = "//a[normalize-space()='2']")
	public static WebElement PaginationSecoundPage;

	@FindBy(xpath = "//span[@title='10 / page']")
	public static WebElement PageDropdown;

	public static String bef = "(//div[@class= 'ant-select-item-option-content'])[";
	public static String aft = "]";

	// Email Search icon
	@FindBy(xpath = "//th[3]//span[@role='img']")
	public static WebElement emailsearchicon;

	// Email Search TextBox
	@FindBy(xpath = "//input[@placeholder=' Email']")
	public static WebElement emailsearchtextbox;

	// Email Search Button
	@FindBy(xpath = "//button[@type='button']//span[text()='Search']")
	public static WebElement emailsearchButton;

	// Contact Number Search icon
	@FindBy(xpath = "//th[4]//span[@role='img']")
	public static WebElement contactNoSearchIcon;

	// Contact Number Search TextBox
	@FindBy(xpath = "//input[@placeholder=' Contact No']")
	public static WebElement contactNosearchtextbox;

	// Contact Number Search Button
	@FindBy(xpath = "//button[@type='button']//span[text()='Search']")
	public static WebElement contactNosearchButton;

	@FindBy(xpath = "//input[@name='plantName']")
	public static WebElement plantSearchText;

	@FindBy(xpath = "//span[@class='ant-select-selection-item-content']")
	public static List<WebElement> plantt;

	@FindBy(xpath = "//span[@class='ant-btn-loading-icon']")
	public static WebElement loadingUpdate;

	@FindBy(id = "customer_plant")
	public static WebElement plants;

	@FindBy(xpath = "//button[@type='button']//span[text()='Update']")
	public static WebElement updateBtns;

	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement editModal;

	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	public static WebElement updateSuccess;

	@FindBy(xpath = "//tr[2]/td[5]/span/span")
	public static WebElement editMore;

	@FindBy(xpath = "//tr[2]/td[2]/span/span")
	public static WebElement editplant;

	@FindBy(xpath = "//div[@class='ant-popover-content']//div[2]/div[1]/p")
	public static WebElement addressCheck;

	@FindBy(xpath = "//div[@class='ant-popover ant-popover-placement-top ']//p")
	public static List<WebElement> plantCheck;

	@FindBy(xpath = "//div[@class = 'ant-modal-content']")
	public static WebElement editpopup;

	@FindBy(xpath = "//div[@id='rcDialogTitle0']//span")
	public static WebElement closebutton;
}
