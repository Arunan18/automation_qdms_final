package com.qa.automation.qdms.pages.master;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlantPage {
//	@FindBy(xpath = "//th[2]//div[1]//span[2]")
//	public static WebElement search;
	@FindBy(xpath = "//span[@class='ant-dropdown-trigger ant-table-filter-trigger ant-dropdown-open']")
	public static WebElement search;

	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div[1]/div/div[2]")
	public static WebElement clickplant;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[3]")
	public static WebElement material;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]")
	public static WebElement searchicon;
	// *[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[2]/div/span[2]

	@FindBy(xpath = "//input[@placeholder=' Code']")
	public static WebElement searchboxplaceholder;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement searchbuttonnew;

	@FindBy(xpath = "(//span[contains(@role,'button')])[2]")
	public static WebElement planticon;

//	@FindBy(xpath = "//tbody/tr[2]/td[9]/span[1]/a[1]/span[1]")
//	public static WebElement EditPlantIcon;
//	@FindBy(xpath = "//tbody/tr[5]/td[9]/span[1]/a[1]/span[1]")
//	public static WebElement EditPlantIcon;

	@FindBy(xpath = "//tbody/tr[5]/td[9]/span[1]")
	public static WebElement EditPlantIcon;

	@FindBy(xpath = "//input[@id='plant_code']")
	public static WebElement mandatory;
//	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[1]/div/input")
//	public static WebElement mandatory;

	@FindBy(xpath = "//*[@id='plant_name']")
	public static WebElement plantname;
	@FindBy(xpath = "//*[@id='plant_address']")
	public static WebElement Address;
	@FindBy(xpath = "//*[@id='plant_contactno']")
	public static WebElement ContactNo;
	@FindBy(xpath = "//*[@id='fax']")
	public static WebElement fax;
	@FindBy(xpath = "//input[@id='sub_business_unit']")
	public static WebElement ClickSubBusinessUnitDropDown;

	@FindBy(xpath = "(//div[contains(@class,'ant-select-item-option-content')])[6]")
	public static WebElement SelectSubBusiness;

	@FindBy(xpath = "//div[@name='employeeIds']")
	public static WebElement PlantManagerDropDown;

	@FindBy(xpath = "(//div[contains(text(),'Sarath')])[1]")
	public static WebElement SelectPlantManager;

	@FindBy(xpath = "//*[@id='plant_description']")
	public static WebElement Description;

	@FindBy(xpath = "//body//div//button[2]")
	public static WebElement UpdateButton;

	@FindBy(xpath = "//tbody/tr[2]")
	public static WebElement confirmUpdate;

	@FindBy(xpath = "//div[@class='ant-modal-body']")
	public static WebElement modal;

//	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/div")
//	public static WebElement admin;
//	@FindBy(xpath = "//ul[@class='ant-menu-overflow ant-menu ant-menu-root ant-menu-horizontal ant-menu-dark']/div/div[2]/div/div/span[@class='ant-tag ant-tag-has-color']")
//	public static WebElement admin ;

	@FindBy(xpath = "//ul[@role='menu']//div//span[@class='ant-tag ant-tag-has-color']")
	public static WebElement admin;
	@FindBy(xpath = "//tbody/tr[8]/td[5]")
	public static WebElement logout;

	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement cancelbutton;

	@FindBy(xpath = "//tbody/tr[2]/td[9]/span[1]/a[1]/span[1]")
	public static WebElement tableFirstRow;

	// *****************************************************************************************
	// FOR SINGLE SEARCH
	// *****************************************************************************************
	@FindBy(xpath = "//li[@title='Next Page']/button")
	public static WebElement NextPageBtn;

	// Plant Multi Search and Reset All XPath
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//input")
	public static WebElement SearchTextBox;
	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div/button[1]")
	public static WebElement SearchBtn;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[1]/div/span[2]")
	public static WebElement PlantCodeSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[2]/div/span[2]")
	public static WebElement PlantNameSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[3]/div/span[2]")
	public static WebElement SbuSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[4]/div/span[2]")
	public static WebElement PlantManagerSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[5]/div/span[2]")
	public static WebElement AddressSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[6]/div/span[2]")
	public static WebElement ContactNoSearch;

	@FindBy(xpath = "//button[@type='button'][@class='ant-btn ant-btn-danger ant-btn-background-ghost']")
	public static WebElement ResetAll;
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']")
	public static WebElement SearchBox;
	@FindBy(xpath = "//span[normalize-space()='Reset']")
	public static WebElement reset;

//	@FindBy(xpath = "//li[@title='Next Page']/button")
//	public static WebElement NextPageBtn;
	@FindBy(xpath = "//li[@title='Previous Page']/button")
	public static WebElement PreviousPageBtn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> PlantCodeColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[2]")
	public static List<WebElement> PlantColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[3]")
	public static List<WebElement> SbuColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[4]")
	public static List<WebElement> managerColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[5]")
	public static List<WebElement> AddressColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[6]")
	public static List<WebElement> MobileColumn;

	public static String PlantCodeColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String PlantCodeColumnAfter = "]/td[1]";
	public static String PlantColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String PlantColumnAfter = "]/td[2]";
	public static String SbuColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String SbuColumnAfter = "]/td[3]";
	public static String managerColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String managerColumnAfter = "]/td[4]";
	public static String addressColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String addressColumnAfter = "]/td[5]";
	public static String mobileColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String mobileColumnAfter = "]/td[6]";

	// pagination
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
	@FindBy(xpath = "//li[@title='Next Page']//button[@type='button']")
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

	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	public static WebElement paginationCount;

	@FindBy(xpath = "//header[@class='ant-layout-header']//li[1]")
	public static WebElement plantTab;

	@FindBy(xpath = "//div[@class='sc-gzVnrw flBzTM']")
	public static WebElement plantNavigation;

	@FindBy(xpath = "//*[@id='addPlant']")
	public static WebElement addPlantButton;

	@FindBy(xpath = "//div[contains(@class,'ant-modal-root')]//button[2]")
	public static WebElement saveButton;

	@FindBy(xpath = "//div[@class='ant-table-body']//tr[2]/td[9]/span")
	public static WebElement checkingFirstRow;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[2]/div/div[1]")
	public static WebElement validation;

	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement cancelButton;

	@FindBy(xpath = "//input[@id='plant_code']/../div[1]")
	public static WebElement codeValidation;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[3]/div[2]/div/div[2]")
	public static WebElement dropDownValidation;

//####################################################################################################
//************************************************************************************************
//      xpath of plant in tabs
//**********************************************************************************************
	@FindBy(xpath = "//a[@href='#/master/plantlevel']")
	public static WebElement planttab;

//***********************************************************************************************
//    xpath of search icon of code
//********************************************************************************************8

	@FindBy(xpath = "//th[1]//div[1]//span[2]")
	public static WebElement codesearch;

//***********************************************************************************************
//  xpath of search textbox of code
//********************************************************************************************8	

	@FindBy(xpath = "//input[contains(@placeholder,'Code')]")
	public static WebElement codetexbox;

// ***********************************************************************************************
// xpath of search icon of plant manager 
// ********************************************************************************************8

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[4]/div/span[2]")
	public static WebElement plantmanagersearch;

//***********************************************************************************************
//  xpath of search textbox of code
//********************************************************************************************8	

	@FindBy(xpath = "//input[@placeholder=' Plant Manager']")
	public static WebElement plantmanagertexbox;

//***********************************************************************************************
//  xpath ofreset button of code
//********************************************************************************************8		
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/button[2]")
	public static WebElement resetcode;
//#######################################################################################################

	// ***********************************************************************************************
	// xpath of search icon of sbu
	// ********************************************************************************************8

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[3]/div/span[2]")
	public static WebElement sbusearch;

	// ***********************************************************************************************
	// xpath of search text box of sbu
	// ********************************************************************************************8
	@FindBy(xpath = "//input[@placeholder=' Sub Business Unit Name']")
	public static WebElement sbutextbox;

	// ***********************************************************************************************
	// xpath of search button of sbu
	// ********************************************************************************************8
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement sbusearchbutton;

	// ***********************************************************************************************
	// xpath of search icon of contact no
	// ********************************************************************************************8

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[6]/div/span[2]")
	public static WebElement contactnosearch;

	// ***********************************************************************************************
	// xpath of search textbox of contact no
	// ********************************************************************************************8

	@FindBy(xpath = "//input[@placeholder=' Contact No']")
	public static WebElement contactnotexbox;

	// ***********************************************************************************************
	// xpath of text pagination
	// ********************************************************************************************8

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[1]")
	public static WebElement textpagination;

//**************************************************************************************************
	@FindBy(xpath = "//div[@class='sc-dnqmqq hnktPT']")
	public static WebElement plantbutton;
	@FindBy(xpath = "//th[2]//div[1]//span[2]")
	public static WebElement plantsearchbutton;
	@FindBy(xpath = "//input[@placeholder=' Plant']")
	public static WebElement plantsearchbox;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement plantsearchboxbutton;
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[2]")
	public static WebElement planttable;
	@FindBy(xpath = "(//li[contains(@class, 'ant-pagination-item') and not(contains(@class, 'ant-pagination-item-74'))])[last()]")
	public static WebElement lastpage;

//Search Reset Button
	@FindBy(xpath = "//span[normalize-space()='Reset']")
	public static WebElement searchresetboxbutton;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[3]/div[2]/div/div[1]/div/span[2]")
	public static WebElement dropDownBeforeEdit;

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div[8]/div")
	public static WebElement selectDropDownEdit;

//PlantManager Field Search
	@FindBy(xpath = "//th[4]//div[1]//span[2]")
	public static WebElement Managersearchbutton;

	@FindBy(xpath = "//span[@class='ant-dropdown-trigger ant-table-filter-trigger ant-dropdown-open']//span[@aria-label='search']")
	public static WebElement msearchicon;

	@FindBy(xpath = "//input[@placeholder=' Plant Manager']")
	public static WebElement Managersearchbox;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement Managersearchboxbutton;

//Address Field Search

	@FindBy(xpath = "//th[5]//div[1]//span[2]")
	public static WebElement Addresssearchbutton;

	@FindBy(xpath = "//input[@placeholder=' Address']")
	public static WebElement Addresssearchbox;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement Addresssearchboxbutton;

//Contact No Field Search

	@FindBy(xpath = "//th[6]//div[1]//span[2]")
	public static WebElement Contactsearchbutton;

	@FindBy(xpath = "//input[@placeholder=' Contact No']")
	public static WebElement Contactsearchbox;

	@FindBy(xpath = "(//button[contains(@type,'button')])[6]")
	public static WebElement Contactsearchboxbutton;

	@FindBy(xpath = "//div[@class='ant-table-wrapper sc-jzJRlG dmOwxN']")
	public static WebElement plantTable;

	@FindBy(xpath = "//div[@class = 'ant-modal-content']")
	public static WebElement editpopup;

	@FindBy(xpath = "//header[@class='ant-layout-header']/ul/div/div[2]/div/div/span")
	public static WebElement clickAdmin;

	@FindBy(xpath = "//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']/li[5]")
	public static WebElement clickLogout;

	// RAHUL.S 2023/07/05
	// PLANT CODE VALIDATION MESSAGE
	@FindBy(xpath = "//input[@id='plant_code']/../div[1]")
	public static WebElement plantCodeValidation;

	// PLANT NAME VALIDATION MESSAGE
	@FindBy(xpath = "//input[@id='plant_name']/../div[1]")
	public static WebElement plantNameValidation;

	// SBU DROPDOWN VALIDATION MESSAGE
	@FindBy(xpath = "//input[@id='sub_business_unit']//ancestor::div[@class='input_wrapper']//div[2]")
	public static WebElement sbuValidation;

	// CONTACT NUMBER VALIDATION MESSAGE
	@FindBy(xpath = "//input[@id='plant_contactno']/..//div[1]")
	public static WebElement contactNoValidation;

	// FAX VALIDATION MESSAGE
	@FindBy(xpath = "//input[@id='fax']/..//div[1]")
	public static WebElement faxValidation;

	// FAX VALIDATION MESSAGE
	@FindBy(xpath = "//input[@id='sub_business_unit']//ancestor::div[@class='input_wrapper']//span[2]/span")
	public static WebElement sbuValidation1;

	@FindBy(xpath = "//span[@title='10 / page']")
	public static WebElement PageDropdown;

	public static String bef = "(//div[@class= 'ant-select-item-option-content'])[";
	public static String aft = "]";

	@FindBy(xpath = "//div[@id='rcDialogTitle0']//span")
	public static WebElement closebutton;
	
	@FindBy(xpath = "//button[@type='button']//span[text()='Cancel']")
	public static WebElement CancelButton;
	
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement table;
	
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement editPopUP;
	
	@FindBy(xpath = "//button//span[text()='Close']")
	public static WebElement descCloseBtn;
	
	@FindBy(xpath = "//span[@class='ant-modal-close-x']/span")
	public static WebElement descCloseIcon;
	
	@FindBy(xpath = "//div[@class='ant-modal-header']//span")
	public static WebElement editCloseIcon;

}
