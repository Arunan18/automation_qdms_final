package com.qa.automation.qdms.pages.master;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SupplierPage {
//Supplier Multi Search XPath
	@FindBy(xpath = "//input[@name='supplierCategoryName']")
	public static WebElement SearchTextBox;
	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div/button[1]")
	public static WebElement SearchBtn;

	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[1]/div/span[2]")
	public static WebElement SupplierSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[2]/div/span[2]")
	public static WebElement PlantSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[3]/div/span[2]")
	public static WebElement EmailSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[4]/div/span[2]")
	public static WebElement ContactNoSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[5]/div/span[2]")
	public static WebElement AddressSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[6]/div/span[2]")
	public static WebElement SupplierCategorySearch;

	@FindBy(xpath = "//button[@type='button'][@class='ant-btn ant-btn-danger ant-btn-background-ghost']")
	public static WebElement ResetAll;
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']")
	public static WebElement SearchBox;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> SupplierColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[2]")
	public static List<WebElement> PlantColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[3]")
	public static List<WebElement> EmailColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[4]")
	public static List<WebElement> ContactNoColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[5]")
	public static List<WebElement> AddressColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[6]")
	public static List<WebElement> SupplierCategoryColumn;

	public static String SupplierColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String SupplierColumnAfter = "]/td[1]";
	public static String PlantColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String PlantColumnAfter = "]/td[2]";
	public static String EmailColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String EmailColumnAfter = "]/td[3]";
	public static String ContactNoColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String ContactNoColumnAfter = "]/td[4]";
	public static String AddressColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String AddressColumnAfter = "]/td[5]";
	public static String SupplierCategoryColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String SupplierCategoryColumnAfter = "]/td[6]";

//	SUPPLIER PAGINATION 
//	------------------------

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[10]/button")
	public static WebElement supplierFirstPage;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[2]/button")
	public static WebElement supplierSecoundPage;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[11]/div/div[1]/span[1]")
	public static WebElement currentPaginationOption;

	@FindBy(xpath = "//ul/li[5]/span/a[@href='#/master/supplierlevel']")
	public static WebElement mainSupplier;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[2]")
	public static WebElement sideSupplier;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[1]/div/div/div[5]/button")
	public static WebElement supplierExportButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[1]/div/div/div[4]/span/div/span/button")
	public static WebElement supplierImportButton;

//	adding supplier
//	--------------------------------

	@FindBy(xpath = "//div[@class='input_wrapper']/div[@class='ant-select ant-select-multiple ant-select-show-search']")
	public static WebElement supplierCategoryField;

	@FindBy(xpath = "//div[@class='input_wrapper']/div[@class='ant-select ant-select-single ant-select-show-arrow ant-select-show-search']")
	public static WebElement plantField;

	@FindBy(xpath = "//*[@id=\"supplier_name\"]")
	public static WebElement supplierField;

	@FindBy(xpath = "//*[@id=\"supplier_contactno\"]")
	public static WebElement contactNoField;

	@FindBy(xpath = "//*[@id=\"supplier_email\"]")
	public static WebElement emailField;

	@FindBy(xpath = "//*[@id=\"supplier_address\"]")
	public static WebElement addressField;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[1]/div/div/div[6]/div/button")
	public static WebElement addSupplierButton;

	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[@class='ant-btn sc-gZMcBi dMdnOw']")
	public static WebElement supplierSaveButton;

	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']")
	public static List<WebElement> supplierCategoryOption;

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div[2]")
	public static List<WebElement> plantOption;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement supplierFirstRow;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[1]")
	public static WebElement supplierCancelButton;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div")
	public static WebElement supplierModal;

	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement deleteSupplierModal;

	@FindBy(xpath = "//span[@class='anticon anticon-close-circle']")
	public static WebElement supplierCloseButton;

	// div[@class='ant-popover ant-popconfirm ant-popover-placement-top ']

	// div[@class='ant-popover ant-popconfirm ant-popover-placement-top
	// ']//div[@class='ant-popover-content']

//	supplier edit 
//	-----------------------------------

	@FindBy(xpath = "//td[text()='Pro Mark Holdings Private Limited']//following-sibling::td[7]//span[@class='anticon anticon-edit']")
	public static WebElement supplierEditButton;

	@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']//span[text()='Update']")
	public static WebElement supplierUpdateButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]")
	public static WebElement supplierFullRow;

	@FindBy(xpath = "//a[@class='sc-bdVaJa ieeiNp'][@href='#/master/plantlevel']")
	public static WebElement master;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[2]/div/div[1]")
	public static WebElement SupplierValidation;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[1]/div/div[2]")
	public static WebElement SupplierCategoryValidation;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div[2]/div[1]/div/div[2]")
	public static WebElement PlantValidation;

	@FindBy(xpath = "//td[text()='sayan@gmail.com']//following-sibling::td[5]//span[@class='anticon anticon-delete']")
	public static WebElement supplierDeleteButton;

	@FindBy(xpath = "//div[@class='ant-popover-buttons']//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement supplierDeleteConfirmBtn;

	@FindBy(xpath = "//div[@class='ant-popover-buttons']//button[@class='ant-btn ant-btn-sm']")
	public static WebElement supplierDeleteCancelBtn;

	@FindBy(xpath = "//div[@class='ant-table-body']")
	public static WebElement supplierTableBody;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr[2]/td[3]")
	public static WebElement firstRowSupplierEmail;

	@FindBy(xpath = "//tbody//tr[@class='ant-table-row ant-table-row-level-0'][1]/td[6]//span[@class='anticon anticon-idcard']")
	public static WebElement firstRowSupplierCategoryBtn;

	@FindBy(xpath = "//div[@class='ant-popover ant-popover-placement-top ']//div[@class='ant-popover-inner-content']")
	public static WebElement firstRowSupplierCategoryValue;

	@FindBy(xpath = "//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']/li/div")
	public static WebElement CurrentPaginationOption;

	@FindBy(xpath = "//div[@class='ant-popover ant-popconfirm ant-popover-placement-top ']//div[@class='ant-popover-inner-content']//div[@class='ant-popover-buttons']//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement supplierPaginationDelete;

//========================================================= SUPLIER SEARCH AND RESET-ALL ===================================

	// ******************************* MENU BAR SUPLIER **********************
	@FindBy(xpath = "//a[@href='#/master/supplierlevel']")
	public static WebElement SuplierMenuBar;

	// ******************************* MENU BAR SUPLIER **********************
	@FindBy(xpath = "(//div[@class='sc-gzVnrw geeJmJ'])[1]")
	public static WebElement SupplierBytton;

	// **************************** SEARCH BUTTON FOR PLANT**********************
	@FindBy(xpath = "(//span[@role='button'])[3]")
	public static WebElement SearchForPlantColoumn;

//********************************** PLACE HOLDER SEARCH _PLANT ***************
	@FindBy(xpath = "(//input[contains(@placeholder,'Plant')])[1]")
	public static WebElement placeHolderSearch;

//************************** SEARCH BUTTON ***************************************
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary ant-btn-sm'])[1]")
	public static WebElement plantPlaceHolderSearechButton;

//********************************** RESETALL BUTTON ****************************
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-danger ant-btn-background-ghost'])[1]")
	public static WebElement ReserallButton;

	// Supplier Edit

	@FindBy(xpath = "(//div[@class='ant-select-selector'])[2]")
	public static WebElement SupplierCategoryc;
	@FindBy(xpath = "//input[@id='supplier_name']")
	public static WebElement Supplierr;
	@FindBy(xpath = "//div[@name='supplier_plant']//div[@class='ant-select-selector']")
	public static WebElement Plant;
	@FindBy(xpath = "//input[@id='supplier_email']")
	public static WebElement Email;
	@FindBy(xpath = "//*[@id=\"supplier_contactno\"]")
	public static WebElement ContactNo;
	@FindBy(xpath = "//input[@id='supplier_address']")
	public static WebElement Address;

	// Edit Validation
	@FindBy(xpath = "//*[@id=\"supplier_name\"]")
	public static WebElement supplierNametextBox;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]")
	public static WebElement updateButton;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[2]/div/div[1]")
	public static WebElement validation;

	@FindBy(xpath = "//span[@class='ant-select-selection-item-remove']")
	public static WebElement suppliercategorycloseicon;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[1]")
	public static WebElement cancelButton;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[1]/div/div[1]/div/div/div[1]/span/span[1]")
	public static WebElement supplierCategoryTextBox;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[1]/div/div[1]/div/div/div[1]/span/span[2]/span")
	public static WebElement unselect;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[1]/div/div[2]")
	public static WebElement dropDownValid;

	// Add Button Form Success Message
	@FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-success ant-notification-notice-closable']/div/div/div[1]")
	public static WebElement successmsg;

	@FindBy(xpath = "//td[text()='supplierDeleteAdd']//following-sibling::td[6]//span[@class='anticon anticon-ellipsis']")
	public static WebElement moreDetailsSupplier;

	@FindBy(xpath = "//div[@class='ant-popover-inner-content']")
	public static WebElement moredetailsmodalfullcontent;

	@FindBy(xpath = "/html/body/div[3]/div/div")
	public static WebElement moredetailsmodalcontent;

	@FindBy(xpath = "//td[text()='Janaka Transport']//following-sibling::td[5]//span[@class='anticon anticon-idcard']")
	public static WebElement supplierCategoryBtn;

	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement supplierCategoryModalContent;

	// Model Form
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]")
	public static WebElement model;

//	MODIFIED BY: ARUNAN 17.03.2023
	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div/button[2]")
	public static WebElement resetBtn;

//reset button for email
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[1]")
	public static WebElement paginationtext;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[3]/div/span[2]")
	public static WebElement emailsearch;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/input")
	public static WebElement emailsearchtextbox;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/button[2]")
	public static WebElement resetbutton;

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


	// @sasi - 18.07.2023

	// Allocate More Option
	@FindBy(xpath = "//div[@class='ant-popover ant-popover-placement-top ']//div[@class='ant-popover-inner-content']")
	public static WebElement moremodalcontent;
	
	
	@FindBy(xpath = "//button[@type='button']//span[text()='Add Supplier']")
	public static WebElement addSupplierBtn;
	
	@FindBy(xpath = "//button[@type='button']//span[text()='Save']")
	public static WebElement saveSupplierBtn;
	
@FindBy(id = "supplier_category")
public static WebElement supplierCategorys;

@FindBy(id = "supplier_name")
public static WebElement suppliew;

@FindBy(xpath = "//label[@for='plant']//..//input")
public static WebElement plants;

@FindBy(id = "supplier_contactno")
public static WebElement contact;

@FindBy(id = "supplier_email")
public static WebElement emails;

@FindBy(id = "supplier_address")
public static WebElement address;

@FindBy(xpath = "//div[@class='ant-modal-content']")
public static WebElement editModal;

@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
public static WebElement updateSuccess;

@FindBy(xpath = "//button[@type='button']//span[text()='Update']")
public static WebElement updateBtns;

@FindBy(xpath = "//tr[2]/td[6]/span/span")
public static WebElement editSupplierCat;

@FindBy(xpath = "//span[@class='ant-btn-loading-icon']")
public static WebElement loadingUpdate;

@FindBy(xpath = "//div[@class='ant-popover ant-popover-placement-top ']//p")
public static List<WebElement> plantCheck;

	/**********************************************************************************************************
	* SUPPLIER PAGE WEBELEMENTS			||		 @author Jathu Jana		||  		Date : 19/07/2023 
	**********************************************************************************************************/
	//Add Supplier
	@FindBy(xpath = "//div[@class='ant-table-title']/div/div/div[6]//button")
	public static WebElement addSupButton;
	
	//Add Supplier - Supplier Category DropDown Box
	@FindBy(xpath = "//*[@id='supplier_category']/../../..")
	public static WebElement addSupSupplierCategoryDropDownBox;
	
	//Add Supplier - Supplier TextBox
	@FindBy(xpath = "//*[@id='supplier_name']")
	public static WebElement addSupSupplierTextBox;
	
	//Add Supplier - Plant DropDown Box
	@FindBy(xpath = "//*[@id='supplier_plant']")
	public static WebElement addSupPlantDropDownBox;
		
	//Add Supplier - Contact No TextBox
	@FindBy(xpath = "//*[@id='supplier_contactno']")
	public static WebElement addSupSContactNoTextBox;
	
	//Add Supplier - Email TextBox
	@FindBy(xpath = "//*[@id='supplier_email']")
	public static WebElement addSupEmailTextBox;
	
	//Add Supplier - Address TextBox
	@FindBy(xpath = "//*[@id='supplier_address']")
	public static WebElement addSupAddressTextBox;

	//Supplier Page - Any PopUp Model
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement popUpModel;
	
	//Supplier Page - Any PopUp Model Cancel Button
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[2]")
	public static WebElement popUpModelSecondButton;
	
	//Supplier Page - Any PopUp Model Save/Update/OK/Edit Button
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[1]")
	public static WebElement popUpModelFirstButton;
	
	//Supplier Page - Any PopUp Model Close Button
	@FindBy(xpath = "//div[@class='ant-modal-title']/div/span")
	public static WebElement popUpModelCloseButton;
		
	// Add Supplier Success Message
	@FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-success ant-notification-notice-closable']/div/div/div[1]")
	public static WebElement supplierAddedSuccessMessage;
	
	//Supplier Table First Added Data
	@FindBy(xpath = "//tbody/tr[2]/td[1]")
	public static WebElement tableFirstRowFirstData;
	
	//Supplier Table Second Added Data
	@FindBy(xpath = "//tbody/tr[2]/td[2]")
	public static WebElement tableFirstRowSecondData;
	
	//Supplier Table Third Added Data
	@FindBy(xpath = "//tbody/tr[2]/td[3]")
	public static WebElement tableFirstRowThirdData;
	
	//Supplier Table Forth Added Data
	@FindBy(xpath = "//tbody/tr[2]/td[4]")
	public static WebElement tableFirstRowforthData;	
	
	//Supplier Table Fifth Added Data
	@FindBy(xpath = "//tbody/tr[2]/td[5]")
	public static WebElement tableFirstRowFifthData;
	
	
	// Add Supplier - PopUp Any Validation
	@FindBy(xpath = "(//div[@class='ant-modal-content']//form//div[@class='input_wrapper']//div[text()])[1]")
	public static WebElement popFirstValidation;
	
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement deletePopUP;
	
	@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[1]")
	public static WebElement deleteCancelButton;
	
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement supplierTable;

	
}
