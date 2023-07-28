package com.qa.automation.qdms.pages.master;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MaterialPage {

	// material->plantwise to SBU -> soursefield check
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[3]")
	public static WebElement materialheader;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[5]")
	public static WebElement materialbutton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[6]/div/button")
	public static WebElement addmaterial;

	@FindBy(xpath = "//*[@id=\"materialType\"]/label[1]")
	public static WebElement plant;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/form/div[5]/div[2]/div/label[2]")
	public static WebElement active;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/form/div[2]/div[2]/div/div[1]")
	public static WebElement subcategory;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/form/div[5]/div[1]/div/div[1]/div/div")
	public static WebElement sourse;

	@FindBy(xpath = "//span[normalize-space()='Reset']")
	public static WebElement Reset;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement tableFirstRow;

	@FindBy(xpath = "//*[@id=\"materialType\"]/label[1]")
	public static WebElement plantradiobutton;

	@FindBy(xpath = "//div[@id='materialType']//label[3]")
	public static WebElement commonradiobutton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[13]/span/a[1]/span/svg/path")
	public static WebElement editicon;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[2]/span/a[1]/span")
	public static WebElement editMaterial;

	@FindBy(xpath = "//*[@id=\"plant\"]")
	public static WebElement plantbox;

	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/form/div[2]/div[1]/div/div[1]")
	public static WebElement plantdropdowndata;

	@FindBy(xpath = "//div[@name='sub_category ']//div[@class='ant-select-selector']")
	public static WebElement subcategorybox;

	@FindBy(xpath = "//*[@id=\"description\"]")
	public static WebElement Description;

	@FindBy(xpath = "//input[@id='sub_category']")
	public static WebElement subcategorydata;

	@FindBy(xpath = "//*[@id=\"material_name\"]")
	public static WebElement materialnew;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/form/div[5]/div[1]/div/div[1]")
	public static WebElement soursedata;

	@FindBy(xpath = "//input[@id='prefix']")
	public static WebElement prefix;

	@FindBy(xpath = "//div[@name='material_nature']")
	public static WebElement materialstate;

	@FindBy(xpath = "//*[@id=\"erpCode\"]")
	public static WebElement ERP;

	@FindBy(xpath = "div[title='Semi Solid'] div[class='ant-select-item-option-content']")
	public static WebElement materialstatedata;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]")
	public static WebElement save;

	@FindBy(xpath = "(//span[@aria-label='edit'])[1]")
	public static WebElement edit;

	@FindBy(xpath = "//td[text()='PRE12']//following-sibling::td[7]//span[@class= 'anticon anticon-container']")
	public static WebElement materialDescription;

	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[@class='ant-btn ant-btn-ghost sc-gZMcBi dMdnOw']")
	public static WebElement materialDescriptionCloseBtn;

	@FindBy(xpath = "//button[@class='ant-modal-close']")
	public static WebElement materialDescriptionCloseIcon;

	@FindBy(xpath = "//div/div/div[2]/div//div[@class='ant-modal-content']")
	public static WebElement materialDescriptionModal;

//.........................................	

//Material Multi Search XPath
	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/input")
	public static WebElement SearchTextBox;
	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div/button[1]")
	public static WebElement SearchBtn;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[1]/div/span[2]")
	public static WebElement MaterialSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[2]/div/span[2]")
	public static WebElement MainCatSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[3]/div/span[2]")
	public static WebElement SubCatSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[4]/div/span[2]")
	public static WebElement PrefixSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[5]/div/span[2]")
	public static WebElement PlantSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[6]/div/span[2]")
	public static WebElement StateSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[8]/div/span[2]")
	public static WebElement ErpSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[9]/div/span[2]")
	public static WebElement SbuSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[10]/div/span[2]")
	public static WebElement SourceSearch;

	@FindBy(xpath = "//li[@title='Next Page']/button")
	public static WebElement NextPageBtn;
	@FindBy(xpath = "//li[@title='Previous Page']/button")
	public static WebElement PreviousPageBtn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> MaterialColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[2]")
	public static List<WebElement> MainCatColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[3]")
	public static List<WebElement> SubCatColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[4]")
	public static List<WebElement> PrefixColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[5]")
	public static List<WebElement> PlantColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[6]")
	public static List<WebElement> StateColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[8]")
	public static List<WebElement> ErpColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[9]")
	public static List<WebElement> SbuColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[10]")
	public static List<WebElement> SourceColumn;

	@FindBy(xpath = "//button[@type='button'][@class='ant-btn ant-btn-danger ant-btn-background-ghost']")
	public static WebElement ResetAll;
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']")
	public static WebElement SearchBox;

	public static String MaterialColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String MaterialColumnAfter = "]/td[1]";
	public static String MainCatColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String MainCatColumnAfter = "]/td[2]";
	public static String SubCatColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String SubCatColumnAfter = "]/td[3]";
	public static String PrefixColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String PrefixColumnAfter = "]/td[4]";
	public static String PlantColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String PlantColumnAfter = "]/td[5]";
	public static String StateColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String StateColumnAfter = "]/td[6]";
	public static String ErpColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String ErpColumnAfter = "]/td[8]";
	public static String SbuColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String SbuColumnAfter = "]/td[9]";
	public static String SourceColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String SourceColumnAfter = "]/td[10]";

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[3]/span/a")
	public static WebElement tabMaterial;

	@FindBy(xpath = "//div[@class='sc-dnqmqq hnktPT'][normalize-space()='Material']")
	public static WebElement navigationMaterial;

	@FindBy(xpath = "//tbody/tr[2]/td[12]/span[1]/a[1]/span[1]")
	public static WebElement clickReleventEditIcon;

	@FindBy(xpath = "//*[@id=\"status\"]")
	public static WebElement Checkbox;

	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[2]")
	public static WebElement saveButton;

	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[1]")
	public static WebElement cancelButton;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[3]/td[5]")
	public static WebElement plantName;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[3]/td[12]/span/a/span")
	public static WebElement relevantIcon;

	@FindBy(xpath = "//td[text()='Iron Material']//following-sibling::td[12]//span/a/span")
	public static WebElement selectrecord;

	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']")
	public static WebElement editmaterialmodal;

	@FindBy(xpath = "//span[@class='ant-radio']//input[@value='SBU']")
	public static WebElement SBUradiobutton;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[1]/div/label[1]/span[1]/input")
	public static WebElement Plantradiobutton;

	// material nav bar
	@FindBy(xpath = "//a[@href='#/master/materiallevel']")
	public static WebElement materialnav;
	// material sub category button in side bar
	@FindBy(xpath = "//div[@class='sc-dnqmqq eHflwQ' and text()='Material Sub Category']")
	public static WebElement materialSubCategory;
	// matrial MAin Category in side bar
	@FindBy(xpath = "//div[@class='sc-dnqmqq eHflwQ' and text()='Material Main Category']")
	public static WebElement materialMainCategory;

	// MATTERIALWISE -COMMON ADD-
	@FindBy(xpath = "//*[@id=\"materialType\"]/label[3]/span[1]")
	public static WebElement commonSelect;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]")
	public static WebElement dropDownText;
	@FindBy(xpath = "/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div[5]/div")
	public static WebElement dropDownSelect;

	@FindBy(xpath = "//*[@id=\"prefix\"]")
	public static WebElement prefixTextBox;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/form/div[3]/div[2]/div/div[1]")
	public static WebElement materialStateText;

	@FindBy(xpath = "/html/body/div[5]/div/div/div/div[2]/div[1]/div/div/div[1]")
	public static WebElement materialSelect;
	@FindBy(xpath = "//*[@id=\"material_name\"]")
	public static WebElement materialText;
	@FindBy(xpath = "//*[@id=\"erpCode\"]")
	public static WebElement erpCode;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/form/div[5]/div[2]/div/label[2]/span")
	public static WebElement checkBox;

	@FindBy(xpath = "//*[@id=\"description\"]")
	public static WebElement description;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/ul/li[1]")
	public static WebElement pagnation;

	// pagination

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

	@FindBy(xpath = "//li[@title='1'][@class='ant-pagination-item ant-pagination-item-1 ant-pagination-item-active']")
	public static WebElement DefaultPaginationPage;

	@FindBy(xpath = "//li[@title='2'][@class='ant-pagination-item ant-pagination-item-2 ant-pagination-item-active']")
	public static WebElement PaginationSecoundPage;

	@FindBy(xpath = "//*[@class='ant-select-item ant-select-item-option'][@title='20 / page']")
	public static WebElement Page_20;

	@FindBy(xpath = "//*[@class='ant-select-item ant-select-item-option'][@title='50 / page']")
	public static WebElement Page_50;

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

	// Add source Validation

	@FindBy(xpath = "//*[@id=\"name\"]")
	public static WebElement sourceTextBox;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div/div/div")
	public static WebElement validationMesage;
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[4]")
	public static WebElement sourceNavigation;
	@FindBy(xpath = "//div[@class='sc-bxivhb hiMnNy']//div//button[@type='button']")
	public static WebElement addSourceButton;

//	MODIFIED BY: ARUNAN
	// Delete Material Page
	public static String deleteBtnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String deleteBtnAfter = "]/td[13]/span/a[2]";
	@FindBy(xpath = "//div[@class='ant-popover ant-popconfirm ant-popover-placement-top ']/div/div[2]/div/div[2]/button[2]")
	public static WebElement deleteOkBtn;
	@FindBy(xpath = "//div[@class='ant-popover ant-popconfirm ant-popover-placement-bottom ']/div/div[2]/div/div[2]/button[2]")
	public static WebElement deleteOkBtnAfter20Pagination;
	@FindBy(xpath = "//div[@class='ant-popover ant-popconfirm ant-popover-placement-top ']/div/div[2]/div/div[2]/button[2]")
	public static WebElement deleteOkBtnAfter100Pagination;
	@FindBy(xpath = "//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']/li[11]")
	public static WebElement paginationOpction;
	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']/div[2]/div")
	public static WebElement select20PerPage;
	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']/div[3]")
	public static WebElement select50PerPage;
	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']/div[4]")
	public static WebElement select100PerPage;
	@FindBy(xpath = "//div[@class='ant-select-selector']/span[@class='ant-select-selection-item'][@title='20 / page']")
	public static WebElement afterSelect20PerPage;
	@FindBy(xpath = "//div[@class='ant-select-selector']/span[@class='ant-select-selection-item'][@title='30 / page']")
	public static WebElement afterSelect30PerPage;
	@FindBy(xpath = "//div[@class='ant-select-selector']/span[@class='ant-select-selection-item'][@title='100 / page']")
	public static WebElement afterSelect100PerPage;
	public static String editBtnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String editBtnAfter = "]/td[13]/span/a[1]";
	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[2]")
	public static WebElement UpdateBtn;

	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[2]/div[1]/div/div[1]/div/span[2]")
	public static WebElement sbuOrPlant;
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[2]/div[2]/div/div/div/span[2]")
	public static WebElement subCat;
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[3]/div[1]/div/input")
	public static WebElement prefixText;
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[3]/div[2]/div/div/div/span[2]")
	public static WebElement state;
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[4]/div[1]/div/input")
	public static WebElement material;
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[4]/div[2]/div/input")
	public static WebElement erp;
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[6]/div/div/textarea")
	public static WebElement descreption;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr[2]/td[4]")
	public static WebElement prefixFirstRow;
	@FindBy(xpath = "(//li[contains(@class, 'ant-pagination-item') and not(contains(@class, 'ant-pagination-item-74'))])[last()]")
	public static WebElement LastPage;

//*********************************SASI*********************************************
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

	// Plant click xpath
	@FindBy(xpath = "//div[@name='plant']")
	public static WebElement plantdropdownbox;

	// Source click xpath
	@FindBy(xpath = "//input[@id='material_name']")
	public static WebElement MaterialSource;

	// Checkbox click xpath
	@FindBy(xpath = "//input[@id='active']")
	public static WebElement Materialcheckbox;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[1]/div/div[1]/div/span[2]")
	public static WebElement sbudropdown;
	@FindBy(xpath = "//div[contains(@name,'sub_category')]//div[@class='ant-select-selector']")
	public static WebElement subcategorydropdown;
	@FindBy(xpath = "//*[@id=\"prefix\"]")
	public static WebElement prefixTextbox;
	@FindBy(xpath = "//div[@name='material_nature']//div[@class='ant-select-selector']")
	public static WebElement materialstatedropdown;
	@FindBy(xpath = "//*[@id=\"material_name\"]")
	public static WebElement materialtextbox;
	@FindBy(xpath = "//*[@id=\"erpCode\"]")
	public static WebElement erptextbox;
	@FindBy(xpath = "//*[@id=\"active\"]")
	public static WebElement activecheckbox;
	@FindBy(xpath = "//textarea[@id='description']")
	public static WebElement desctextbox;
	@FindBy(xpath = "//div[@name='plant']//div[@class='ant-select-selector']")
	public static WebElement plantdropdown;
	@FindBy(xpath = "//div[contains(text(),'trinco')]")
	public static WebElement plantdropdownoption;
	@FindBy(xpath = "/html/body/div[5]/div/div/div/div[2]/div[1]/div/div/div[7]/div/span")
	public static WebElement subcategorydropdownoption;
	@FindBy(xpath = "/html/body/div[6]/div/div/div/div[2]/div[1]/div/div/div[4]/div")
	public static WebElement materialstateoption;
	@FindBy(xpath = "//tbody/tr[2]/td[13]/span[1]/a[1]/span[1]")
	public static WebElement firstrowedit;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/ul/li[7]")
	public static WebElement middlePage;

//	@FindBy(xpath = "//button[@class='ant-btn ant-btn-danger ant-btn-background-ghost']")
//	public static WebElement resetAllButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/ul/li[1]")
	public static WebElement pageCount;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[3]/div[1]/div/div[1]")
	public static WebElement preFixValidation;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[4]/div[1]/div/div[1]")
	public static WebElement materialValidation;

	// *********************************************************
	@FindBy(xpath = "//th[5]//div[1]//span[2]//span[1]")
	public static WebElement searchicon;

	@FindBy(xpath = "//input[@placeholder='Plant']")
	public static WebElement searchtextbox;

	@FindBy(xpath = "//span[normalize-space()='Search']")
	public static WebElement searchok;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[5]")
	public static WebElement plantdata;

	@FindBy(xpath = "//tbody/tr[2]/td[12]/span[1]/a[1]/span[1]//*[name()='svg']")
	public static WebElement relevanticon;

	@FindBy(xpath = "//div[@class='ant-table ant-table-fixed-header ant-table-scroll-horizontal']//div[@class='ant-table-body']")
	public static WebElement popupbody;

	@FindBy(xpath = "//button[@class='ant-btn']//span[contains(text(),'Cancel')]")
	public static WebElement cancel;

//Validation 

	@FindBy(xpath = "(//div[normalize-space()=\"Plant Can't be empty\"])[1]")
	public static WebElement plantvalidation;

	@FindBy(xpath = "(//div[normalize-space()=\"Sub Category can't be empty\"])[1]")
	public static WebElement subcategoryvalidation;

	@FindBy(xpath = "(//div[normalize-space()=\"Prefix can't be empty\"])[1]")
	public static WebElement prefixvalidation;

	@FindBy(xpath = "(//div[normalize-space()=\"Material State can't be empty\"])[1]")
	public static WebElement materialstatevalidation;

	@FindBy(xpath = "(//div[normalize-space()=\"Name can't be empty\"])[1]")
	public static WebElement materialvalidation;

	@FindBy(xpath = "//div[normalize-space()='Invalid charaters']")
	public static WebElement prefixinvalidvalidation;

	// **************************Save Button Edit
	// Common******************************
	@FindBy(xpath = "//div[@class='ant-modal-root']//button[2]")
	public static WebElement savebtn;

//Field Box
	@FindBy(xpath = "//div[@name='plant']")
	public static WebElement plantoutbox;

	@FindBy(xpath = "//div[contains(@name,'sub_category')]")
	public static WebElement subcategoryoutbox;

	@FindBy(xpath = "//input[@id='sub_category']")
	public static WebElement categorydropdown;

	@FindBy(xpath = "//input[@id='prefix']")
	public static WebElement prefixoutbox;

	@FindBy(xpath = "//div[@name='material_nature']")
	public static WebElement materialstateoutbox;

	@FindBy(xpath = "//input[@id='material_name']")
	public static WebElement materialoutbox;
//sbu add validation	
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/button[2]")
	public static WebElement materialResetButton;

	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[3]/div[1]/div/div[1]")
	public static WebElement validationmessageofprefix;

	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[4]/div[2]/div[1]/div")
	public static WebElement validationmessageofEPRcode;

	@FindBy(xpath = "//tr[@class='ant-table-row ant-table-row-level-0']")
	public static List<WebElement> materialrownumbwer;
	@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']")
	public static WebElement addMaterialButton;

	@FindBy(xpath = "//*[@id=\"materialType\"]/label[2]/span[1]")
	public static WebElement sbuWise;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/form/div[2]/div[1]/div/div[2]")
	public static WebElement sbuValidation;

//	 MODIFIED BY : ARUNAN 20.03.2023
	@FindBy(xpath = "//input[@name='materialType'][@type='radio'][@value='PLANT']")
	public static WebElement plantRadioBtn;

	@FindBy(xpath = "//div[@class='ant-table-title']/div/div[6]/div/button")
	public static WebElement addMaterialBtn;

	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[2]")
	public static WebElement saveBtn;

	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[2]/div[1]/div/div[1]/div")
	public static WebElement plantTextBox;
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[2]/div[1]/div/div[2]")
	public static WebElement plantValidation;
	@FindBy(xpath = "//body[@class='ant-scrolling-effect']/div[4]/div/div/div/div[2]/div/div/div/div")
	public static List<WebElement> plantList;
	public static String plantBefore = "//body[@class='ant-scrolling-effect']/div[4]/div/div/div/div[2]/div/div/div/div[";
	public static String plantAfter = "]/div";

	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[2]/div[2]/div/div[1]/div")
	public static WebElement subCatTextBox;
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[2]/div[2]/div/div[2]")
	public static WebElement subCatValidation;
	@FindBy(xpath = "//body[@class='ant-scrolling-effect']/div[3]/div/div/div/div[2]/div/div/div/div")
	public static List<WebElement> subCatList;
	public static String subCatBefore = "//body[@class='ant-scrolling-effect']/div[5]/div/div/div/div[2]/div[1]/div/div/div[";
	public static String subCatAfter = "]/div/span";

	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[3]/div[1]/div/input")
	public static WebElement prefiTextBox;
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[3]/div[1]/div/div[1]")
	public static WebElement prefixValidation;

	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[3]/div[2]/div/div[1]/div")
	public static WebElement stateTextBox;
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[3]/div[2]/div/div[2]")
	public static WebElement stateValidation;
	@FindBy(xpath = "//body[@class='ant-scrolling-effect']/div[5]/div/div/div/div[2]/div/div/div/div")
	public static List<WebElement> stateList;
	public static String stateBefore = "//body[@class='ant-scrolling-effect']/div[6]/div/div/div/div[2]/div/div/div/div[";
	public static String stateAfter = "]/div";

	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[4]/div[1]/div/input")
	public static WebElement materialTextBox;
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[4]/div[1]/div/div[1]")
	public static WebElement materiaValidation;

	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[4]/div[2]/div/input")
	public static WebElement erpTextBox;

	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[4]/div[2]/div/div[1]")
	public static WebElement erpValidation;

	@FindBy(xpath = "(//div[normalize-space()=\"Name can't be empty\"])[1]")
	public static WebElement erpnameValidation;

	@FindBy(xpath = "//div[normalize-space()='RawMaterial already depended']")
	public static WebElement alreadydepended;

	@FindBy(xpath = "//div[@class='ant-table-wrapper sc-jzJRlG fuxfxa']")
	public static WebElement table;

	//// MODIFIED BY : Quenthan 24.03.2023
	@FindBy(className = "ant-modal-content")
	public static WebElement addMatrialPopUp;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[1]")
	public static WebElement addMatrialCancl;

	@FindBy(xpath = "//*[@id='rcDialogTitle0']/div/span")
	public static WebElement addMaterialPopupClose;

	@FindBy(xpath = "//*[@id=\'root\']/div/section/section/main/div/div/div[2]/div/div/div/div/div/div/div[2]")
	public static WebElement materialTables;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[1]")
	public static WebElement materialEditCancalButton;

	@FindBy(css = ".ant-modal-content")
	public static WebElement popUpModal;


	// @Modified By:-Sasi
	// Admin Click button
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/div/div[2]/div/div/span")
	public static WebElement Adminbtn;

	// Logout Button
	@FindBy(xpath = "//span[@class='ant-dropdown-menu-title-content']/p")
	public static WebElement Logoutbtn;

	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div/button[2]")
	public static WebElement resetBtn;

	@FindBy(xpath = "//span[@class='ant-select-selection-item'][@title='20 / page']")
	public static WebElement Page_20Active;

	@FindBy(xpath = "//span[@class='ant-select-selection-item'][@title='50 / page']")
	public static WebElement Page_50Active;

	@FindBy(xpath = "//span[@class='ant-select-selection-item'][@title='100 / page']")
	public static WebElement Page_100Active;

	public static String materialeditBefore="//tr[";
	public static String materialeditAfter="]/td[13]/span/a/span[@aria-label='edit']";

	
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/button[2]")
	public static WebElement materialStateResetButton;
	
	@FindBy(xpath = "//input[@placeholder='Description']")
	public static WebElement sourceDescription;
	
	@FindBy(xpath = "//input[@placeholder='ERP Code' and @name='erpCode']")
	  public static WebElement ERPcode_input;
	
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement resetbutton;
	
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']")
	public static WebElement materialtable;



// @Sasi - 14.07.2023
	
// Material State Search Text Box
	@FindBy(xpath = "//input[@placeholder='Material State']")
	public static WebElement MaterialStateTextbox;



/**********************************************************************************************************
* 	MATERIAL PAGE WEBELEMENTS			||		 @author Jathu Jana		||  		Date : 13/07/2023 
**********************************************************************************************************/
	//Material Page - Search TextBox
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//input")
	public static WebElement SearchPopTextBox;

	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//input")
	public static WebElement materialSorceTextBox;

	//Material Page - Any PopUp Model
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement popUpModel;
	
	//Material Page - Any PopUp Model Save/Update/OK/Edit Button
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[1]")
	public static WebElement popUpModelFirstButton;
	
	//Material Page - Any PopUp Model Close Button
	@FindBy(xpath = "//div[@class='ant-modal-title']/div/span")
	public static WebElement popUpModelCloseButton;
		
	
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement deletePopUP;
	
	@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[1]")
	public static WebElement deleteCancelButton;
	
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement materialTable;
	
	@FindBy(xpath = "//button[@type='button']//span[text()='Cancel']")
	public static WebElement CancelButton;
	
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement Table;
	
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement editPopUP;
	
	@FindBy(xpath = "//button//span[text()='Close']")
	public static WebElement descCloseBtn;
	
	@FindBy(xpath = "//span[@class='ant-modal-close-x']/span")
	public static WebElement descCloseIcon;

}


	

