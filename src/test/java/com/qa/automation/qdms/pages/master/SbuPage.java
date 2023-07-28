package com.qa.automation.qdms.pages.master;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SbuPage {

	@FindBy(xpath = "//div[@class='sc-dnqmqq bxMwVY']")
	public static WebElement SbuLeftButton;
	@FindBy(xpath = "//div[@class='sc-htoDjs jApeNY']/div[6]")
	public static WebElement unit;

	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	public static WebElement totalText;
	@FindBy(xpath = "//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']/li/div")
	public static WebElement CurrentPaginationOpction;
	@FindBy(xpath = "//li[@title='1']/a")
	public static WebElement PageNumber;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[1]")
	public static WebElement paginationcount;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> UnitColumn;
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

	@FindBy(xpath = "//*[@class='ant-select-item ant-select-item-option'][@title='20 / page']")
	public static WebElement Page_20;
	@FindBy(xpath = "//*[@class='ant-select-item ant-select-item-option'][@title='30 / page']")
	public static WebElement Page_30;
	@FindBy(xpath = "//*[@class='ant-select-item ant-select-item-option'][@title='100 / page']")
	public static WebElement Page_100;

	@FindBy(xpath = "//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']")
	public static WebElement pagination;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[1]")
	public static WebElement paginationCount;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[1]")
	public static WebElement paginationtext;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[5]/a")
	public static WebElement PageCount;

	@FindBy(id = "unit_name")
	public static WebElement UnitTextbox;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/button")
	public static WebElement AddUnitButton;

	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[2]")
	public static WebElement UnitSaveButton;

	@FindBy(xpath = "//div[@class='ant-modal-body']/form/div/div[1]/div/div[1]")

	public static WebElement validationmsg;

	@FindBy(xpath = "//tr[2]/td[1]")

	public static WebElement tableRow;

	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[1]")
	public static WebElement CancelBtn;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement Deleteok;

	public static String UnitNameBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String UnitNameAfter = "]/td[1]";

	public static String EditBtnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String EditBtnAfter = "]/td[3]/span/a[1]";

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> UnitNameColumn;

	@FindBy(xpath = "//input[@id='unit_name']")
	public static WebElement EditUnitTextbox;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]")
	public static WebElement UpdateButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[2]/span/a[1]/span")
	public static WebElement UpdateIcoFnButton;

	// search sbu
	@FindBy(xpath = "(//li[@role='menuitem'])[1]")
	public static WebElement plantTab;

	@FindBy(xpath = "//*[@id=\"sub_business_unit\"]")
	public static WebElement sbuTextBox;
	@FindBy(xpath = "//body//div//button[2]")
	public static WebElement sbuUpdateButton;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div/div[1]")
	public static WebElement validationMessage;
	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement cancelSbuButton;
	@FindBy(xpath = "//tbody/tr[2]/td[3]/span[1]/a[1]/span[1]")
	public static WebElement tableFirstRow;

//	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[2]")
//	public static WebElement deleteOkButton;

//add sbu
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/button")
	public static WebElement addsbubutton;

	@FindBy(xpath = "//input[@id='sub_business_unit']")
	public static WebElement addsbutextbox;

	@FindBy(xpath = "//body//div//button[2]")
	public static WebElement addsbusavebutton;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div/div[1]")
	public static WebElement validation;

	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement cancelbutton;

	// *******************************************************************************************
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[1]/div[1]")
	public static WebElement SBUButton;

	@FindBy(xpath = "//div[normalize-space()='Sub Business Units']")
	public static WebElement SubBusinessUnitsTableHeading;

	@FindBy(xpath = "//span[@class='ant-table-column-title']")
	public static WebElement SBUColumnHeading;

	@FindBy(xpath = "//th[normalize-space()='Description']")
	public static WebElement DescriptionColumnHeading;

	@FindBy(xpath = "//th[normalize-space()='Action']")
	public static WebElement ActionColumnHeading;

	@FindBy(xpath = "//span[@role='button']")
	public static WebElement SBUColumnSearchicon;

	@FindBy(xpath = "//body/div/div/div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div[@class='ant-table-filter-dropdown']/div[1]")
	public static WebElement SBUColumnSearchPopup;

	@FindBy(xpath = "//input[@placeholder=' SBU Name']")
	public static WebElement sbunamesearchbox;

	@FindBy(xpath = "//input[contains(@placeholder,'SBU Name')]")
	public static WebElement SearchTextBox;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement sbunameboxSearchButton;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']\r\n")
	public static WebElement ResetButton;

	@FindBy(xpath = "//tbody/tr[2]/td[2]/div[1]/span[1]//*[name()='svg']")
	public static WebElement Descriptionicon;

	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement DescriptionPopup;

	@FindBy(xpath = "/html/body/div[4]/div/div[2]/div/div[2]/div[3]/div/button[2]")
	public static WebElement updatebutton;

	@FindBy(xpath = "//div[@class='ant-modal-header']")
	public static WebElement DescriptionpopupHeading;

	@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']")
	public static WebElement AddSBUButtonUI;

	@FindBy(xpath = "//body[1]/div[4]/div[1]/div[2]/div[1]/div[2]")
	public static WebElement AddSBUPopupUI;

	@FindBy(xpath = "//div[@class='sc-VigVT jzVhIp']")
	public static WebElement AddSBUPopupHeading;

	@FindBy(xpath = "//div[@class='ant-modal-body']")
	public static WebElement Descriptionpopupbody;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[3]/span/a[1]/span")
	public static WebElement editbutton;

	@FindBy(xpath = " //input[@id='sub_business_unit']")
	public static WebElement sbuedittextbox;

	@FindBy(xpath = "(//li[contains(@class, 'ant-pagination-item') and not(contains(@class, 'ant-pagination-item-74'))])[position()=last() div 2 + 1]\r\n")
	public static WebElement middlepage;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement sbutabledata;

//	MODIFIED BY : ARUNAN 13.03.2023
	@FindBy(xpath = "//div[@class='ant-table-title']//button")
	public static WebElement addSbuBtn;
	@FindBy(xpath = "//button[@type='button']//span[text()='Save']")
	public static WebElement sbuSaveBtn;
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div/div[1]/div/input")
	public static WebElement sbuTextField;
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div/div[2]/div/input")
	public static WebElement sbuDesTextField;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> sbuColumn;
	public static String sbuNameBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String sbuNameAfter = "]/td[1]";
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div/div[1]/div/div[1]")
	public static WebElement sbuValidation;
	@FindBy(xpath = "//div[@class='ant-modal-footer']/div/button[1]")
	public static WebElement sbuCancelBtn;

//=========================================================================
	// ADD SBU VALIDATION CHECK X-PATH

//============================= MENU BAR PLANT ============================
	@FindBy(xpath = "//a[@href='#/master/plantlevel']")
	public static WebElement MenuBarPlant;

//================================ SBU =====================================
	@FindBy(xpath = "//div[@class='sc-gzVnrw geeJmJ']")
	public static WebElement SBUBTN;

//==================================ADD SBU BUTTON ==========================
	@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']")
	public static WebElement AddSbuButtonValidation;

//=================================== ADD SUB PLACEHOLDER =================
	@FindBy(xpath = "//input[@id='sub_business_unit']")
	public static WebElement PlaceHolderUnit;

//============================== VALIDATION CAN'T BE EMPTY ==================
	@FindBy(xpath = "//div[@class='ant-col ant-col-12']//div[2]")
	public static WebElement ValidationsAll;

//==================================== SAVE BUTTON ========================
	@FindBy(xpath = "(//button[@type='button'])[5]")
	public static WebElement saveButton;

//==================================THREE CHAR ALONG ======================
	@FindBy(xpath = "//div[normalize-space()='Only 3 characters long!']")
	public static WebElement ThreeCharAlong;

//=================================== ALLOW ONLY LETTERS =====================
	@FindBy(xpath = "//div[normalize-space()='Sub Business Unit allow only letters']")
	public static WebElement AllowOnlyLetters;

//=====================================AL READY EXITS ========================
	@FindBy(xpath = "//div[@class='ant-modal-root']//div[@class='ant-row']//div[1]//div[1]//div[1]")
	public static WebElement AlreadyExits;

//======================================== SAVED SUCSSFULLY ===================
	@FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-success ant-notification-notice-closable']")
	public static WebElement savedSucessFully;

// Sbu Table ---------- Author-- N.Karunya
	@FindBy(xpath = " //div[@class='ant-table-container']")
	public static WebElement sbutable;

	// Sbu Ok Button ---------- Author-- N.Karunya
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement sbudeleteokbutton;

	// Sbu not delete notification ---------- Author-- N.Karunya
	@FindBy(xpath = "//div[@class='ant-notification-notice-content']")
	public static WebElement sbunotdeletenotification;

	@FindBy(xpath = "//input[@id='sub_business_unit']//../div[1]")
	public static WebElement sbuValidations;

	@FindBy(xpath = "//input[@id='description']//../div[1]")
	public static WebElement descValidations;

	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	public static WebElement successMessages;

	@FindBy(xpath = "//span[@class='anticon anticon-close ant-notification-close-icon']")
	public static WebElement successMessageCloseBtn;

	@FindBy(xpath = "//tr[2]/td[1]")
	public static WebElement firstRowData;

	@FindBy(xpath = "//button[@type='button']//span[text()='OK']")
	public static WebElement deleteOkBtn;

	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement addSbuPopUp;

	@FindBy(xpath = "//button[@type='button']//span[text()='Update']")
	public static WebElement sbuUpdateBtn;

	@FindBy(xpath = "//button[@type='button']//span[text()='Search']")
	public static WebElement sbuSearchBtn;

	public static String bef = "(//div[@class= 'ant-select-item-option-content'])[";
	public static String aft = "]";

	public static String CodeColumnBefore = "//tbody/tr[";

	public static String CodeColumnAfter = "]/td[1]";

	@FindBy(xpath = "//button[@type='button']/span[text()='Reset']")
	public static WebElement resetButton;

	@FindBy(xpath = "//div[@class = 'ant-modal-content']")
	public static WebElement editpopup;

	@FindBy(xpath = "//div[@id='rcDialogTitle0']//span")
	public static WebElement closebutton;

	
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement deletePopUP;
	
	@FindBy(xpath = "//button[@type='button']//span[text()='Cancel']")
	public static WebElement CancelButton;
	
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement sbuTable;
	
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement editPopUP;
	
	@FindBy(xpath = "//button//span[text()='Close']")
	public static WebElement descCloseBtn;
	
	@FindBy(xpath = "//span[@class='ant-modal-close-x']/span")
	public static WebElement descCloseIcon;
	
	@FindBy(xpath = "//div[@class='ant-modal-header']//span")
	public static WebElement editCloseIcon;
	
}
