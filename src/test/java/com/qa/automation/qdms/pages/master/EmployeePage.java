package com.qa.automation.qdms.pages.master;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeePage {
//Employee Multi Search XPath
	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/input")
	public static WebElement SearchTextBox;
	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div/button[1]")
	public static WebElement SearchBtn;

	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[1]/div/span[2]")
	public static WebElement FirstNameSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[2]/div/span[2]")
	public static WebElement LastNameSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[3]/div/span[2]")
	public static WebElement PlantSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[4]/div/span[2]")
	public static WebElement DesignationSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[5]/div/span[2]")
	public static WebElement EmailSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[6]/div/span[2]")
	public static WebElement ContactNoSearch;

	@FindBy(xpath = "//button[@type='button'][@class='ant-btn ant-btn-danger ant-btn-background-ghost']")
	public static WebElement ResetAll;
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']")
	public static WebElement SearchBox;

	@FindBy(xpath = "//li[@title='Next Page']/button")
	public static WebElement NextPageBtn;
	@FindBy(xpath = "//li[@title='Previous Page']/button")
	public static WebElement PreviousPageBtn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> FirstNameColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[2]")
	public static List<WebElement> LastNameColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[3]")
	public static List<WebElement> PlantColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[4]")
	public static List<WebElement> DesignationColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[5]")
	public static List<WebElement> EmailColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[6]")
	public static List<WebElement> ContactNoColumn;

	public static String FirstNameColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String FirstNameColumnAfter = "]/td[1]";
	public static String LastNameColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String LastNameColumnAfter = "]/td[2]";
	public static String PlantColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String PlantColumnAfter = "]/td[3]";
	public static String DesignationColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String DesignationColumnAfter = "]/td[4]";
	public static String EmailColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String EmailColumnAfter = "]/td[5]";
	public static String ContactNoColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String ContactNoColumnAfter = "]/td[6]";
	public static String StatusColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String StatusColumnAfter = "]/td[7]/span/span/p";
	public static String allocateUserColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String allocateUserColumnAfter = "]/td[8]/span/button";

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div/div[1]/a/div/div")
	public static WebElement master;

//	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[6]/span/a")

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[6]")
	public static WebElement mainEmployee;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[6]/span/a")
	public static WebElement mainmenuEmployee;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[3]/div[1]")
	public static WebElement sideEmployee;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div[5]/button")
	public static WebElement employeeExportButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div[4]/span/div/span/button")
	public static WebElement employeeImportButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[10]/button")
	public static WebElement employeeFirstPage;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[2]/button")
	public static WebElement employeeSecoundPage;

//	ADD EMPLOYEE
//	-----------------------------

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div[6]/div/button")
	public static WebElement addEmployeeButton;

	@FindBy(xpath = "//*[@id=\"plant\"]")
	public static WebElement plantDropdown;

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div[2]/div[1]")
	public static List<WebElement> plantDropdownOptions;

	@FindBy(xpath = "//*[@id=\"desigination\"]")
	public static WebElement designationDropdown;

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div[2]/div[1]/div/div")
	public static List<WebElement> designationDropdownOptions;
//	/html/body/div[5]/div/div/div/div[2]/div[1]

	@FindBy(xpath = "//*[@id=\"first_name\"]")
	public static WebElement firstNameField;

	@FindBy(xpath = "//*[@id=\"last_name\"]")
	public static WebElement lastNameField;

	@FindBy(xpath = "//*[@id=\"address\"]")
	public static WebElement employeeAddressField;

	@FindBy(xpath = "//*[@id=\"phoneno\"]")
	public static WebElement employeeContactNoField;

	@FindBy(xpath = "//*[@id='email']")
	public static WebElement employeeEmailField;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]")
	public static WebElement employeeSaveButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement employeeFirstRow;

	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[@class='ant-btn']")
	public static WebElement employeeCancelButton;

	@FindBy(xpath = "//span[@class='anticon anticon-close-circle']")
	public static WebElement employeeCloseButton;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[1]")
	public static WebElement employeeModal;

	// Pages
	@FindBy(xpath = "//*[@class='ant-select-item ant-select-item-option'][@title='20 / page']")
	public static WebElement Page_20;
	@FindBy(xpath = "//*[@class='ant-select-item ant-select-item-option'][@title='30 / page']")
	public static WebElement Page_30;
	@FindBy(xpath = "//*[@class='ant-select-item ant-select-item-option'][@title='100 / page']")
	public static WebElement Page_100;

//	Activate employee
//	--------------------------------------

	@FindBy(xpath = "//td[text()='wagesom']//following-sibling::td[7]")
	public static WebElement wagesomActivateButton;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div[3]/div[3]/div/div")
	public static WebElement employeeActiveUserTypeDropdown;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div[3]/div[4]/div")
	public static WebElement employeeActiveRole;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]")
	public static WebElement employeeActiveAddButton;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div[3]/div[3]/div/div")
	public static WebElement userTypeArea;

	@FindBy(xpath = "//*[@id=\"userType_list\"]")
	public static List<WebElement> userTypeDropdownOptions;

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div/div")
	public static WebElement userTypeValue;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div[3]/div[4]/div")
	public static WebElement roleArea;

	@FindBy(xpath = "/html/body/div[5]/div/div")
	public static List<WebElement> roleOptions;

	@FindBy(xpath = "/html/body/div[5]/div/div/div/div[2]/div[1]/div/div/div[3]")
	public static WebElement roleselection;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/div[4]")
	public static WebElement roleTextClick;

	@FindBy(xpath = "/html/body/div[4]/div/div[2]/div/div[2]/div[3]/button[2]")
	public static WebElement employeeActivationSave;

//	edit employee

	@FindBy(xpath = "//td[text()='tabob90403@necktai.com']//following-sibling::td[5]//span[@class= 'anticon anticon-edit']")
	public static WebElement employeeEditButton;

	@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']//span[text()='Update']")
	public static WebElement employeeUpdateButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]")
	public static WebElement employeeFullRow;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[11]/div/div[1]/span[1]")
	public static WebElement currentPaginationOption;

	@FindBy(xpath = "//div[@class='ant-select-item ant-select-item-option ant-select-item-option-selected']")
	public static WebElement logistic;

	// Employee Search
	@FindBy(xpath = "//th[1]//div[1]//span[2]")
	public static WebElement EmployeeSearchicon;

	@FindBy(xpath = "//input[@name='firstName']")
	public static WebElement EmployeeSearchinput;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement EmployeeSearchbutton;

	@FindBy(xpath = "//td[text()='sayanthan']//following-sibling::td[9]//span[@class= 'anticon anticon-delete']")
	public static WebElement employeeDeleteButton;

	@FindBy(xpath = "//div[@class='ant-popover-buttons']//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement employeeDeleteConfirmBtn;

	@FindBy(xpath = "//div[@class='ant-popover ant-popconfirm ant-popover-placement-top ']//div[@class='ant-popover-inner-content']//div[@class='ant-popover-buttons']//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement employeePaginationDelete;

	@FindBy(xpath = "//td[text()='sayanthan']//following-sibling::td[9]//span[@class= 'anticon anticon-delete']")
	public static WebElement activeEmployeeDeleteButton;

	// div[@class='ant-popover ant-popconfirm ant-popover-placement-top
	// ']//div[@class='ant-popover-inner-content']//div[@class='ant-popover-buttons']//button[@class='ant-btn
	// ant-btn-primary ant-btn-sm']

	@FindBy(xpath = "//div[@class='ant-table-body']")
	public static WebElement employeeTableBody;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr[2]/td[7]/span/span/p")
	public static WebElement firstRowEmployeestatus;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr[2]/td[5]")
	public static WebElement firstRowEmployeeEmail;

	// tbody[@class='ant-table-tbody']/tr[2]/td[5]

	// tbody[@class='ant-table-tbody']/tr[2]/td[7]/span/span/p

	@FindBy(xpath = "//td[text()='chamikara@tokyocement.lk']//following-sibling::td[4]//span[@class='anticon anticon-ellipsis']")
	public static WebElement moreDetailsEmployee;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]")
	public static WebElement moreDetailsEmployeeModalContent;

	// Add Button Form Success Message
	@FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-success ant-notification-notice-closable']/div/div/div[1]")
	public static WebElement successmsg;

	// Employee Validation
	@FindBy(xpath = "//*[@id='desigination']")
	public static WebElement desField;
	public static String desiBefore = "//div[@class='rc-virtual-list-holder-inner']/div[";
	public static String desiAfter = "]/div";
	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[2]")
	public static WebElement saveBtn;
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[1]/div[1]/div/div[1]")
	public static WebElement firstNameValidation;
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[1]/div[2]/div/div[1]")
	public static WebElement lastNameValidation;
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[2]/div[2]/div/div[2]")
	public static WebElement desiginationValidation;
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[4]/div/div/div[1]")
	public static WebElement emailValidation;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/input")
	public static WebElement designationsearchtextbox;

	/** employee plant search icon **/
	@FindBy(xpath = "//th[3]//div[1]//span[2]")
	public static WebElement plantsearchicon;

	/** employee plant search textbox **/
	@FindBy(xpath = "//input[@placeholder=' Plant']")
	public static WebElement plantsearchtextbox;

	/** employee plant search button **/
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement plantsearchbutton;

	@FindBy(xpath = "//td[text()='tabob90403@necktai.com']//following-sibling::td[5]//span[@class='anticon anticon-delete']")
	public static WebElement cancelemployeeDeleteButton;

	@FindBy(xpath = "//div[@class='ant-popover-buttons']//button[@class='ant-btn ant-btn-sm']")
	public static WebElement employeeDeleteCancelBtn;

	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement deleteEmployeeModal;

	@FindBy(xpath = "//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']/li/div")
	public static WebElement CurrentPaginationOption;

//*************************************SASI DO NOt MAKE ANY CHANGE MY XPATH**********************
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

	// Click Employee Top Button
	@FindBy(xpath = "//a[@class='sc-bdVaJa ieeiNp'][@href='#/master/employeelevel']")
	public static WebElement Employeetopbutton;

	// Employee Site Button
	@FindBy(xpath = "//div[@class='ant-col ant-col-3']/div/div[3]")
	public static WebElement Employeesitebutton;

	// Allocate User button add
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[8]/span/button")
	public static WebElement Addboxbutton;

	// Employee User type dropdown
	@FindBy(xpath = "//div[@name='userType']")
	public static WebElement UserTypedropdown;

	// Employee Role dropdown
	@FindBy(xpath = "//div[@class='ant-select ant-select-multiple ant-select-show-search']")
	public static WebElement Roledropdown;

	// Employee Add button
	@FindBy(xpath = "// button[@type='button'][2]")
	public static WebElement AddButton;

	// Employee Add user Header
	@FindBy(xpath = "//*[@id='rcDialogTitle0']")
	public static WebElement AdduserHeader;

	// Employee Add Success Message
	@FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-success ant-notification-notice-closable']")
	public static WebElement AddEmployeesuccessmsg;

	// Employee Add user First Data
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement Adduserfirstdata;

	// Employee Add user AccountStatus
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[7]/span/span/p")
	public static WebElement AccountStatus;

//================================================================================
	// EMPLOYEE RESET ALL BUTTON FUNCTIONALITY CHECK

//_____________________________MENU BAR EMPLOYYE__________________________________
	@FindBy(xpath = "//a[@href='#/master/employeelevel']")
	public static WebElement employeeMenuBar;

//______________________________EMPLOYEE BUTTON____________________________________
	@FindBy(xpath = "(//div[@class='sc-gzVnrw geeJmJ'])[2]")
	public static WebElement employeeButtonside;

//_______________________________CONTACT OUT SIDE SEARCH __________________________
	@FindBy(xpath = "(//span[@role='button'])[7]")
	public static WebElement SearchOutside;

//________________________________SEARCH TEXTBOX__________________________________
	@FindBy(xpath = "//input[contains(@placeholder,'Contact No')]")
	public static WebElement PlaceHolderSearchContact;

//_________________________________RESET BUTTON___________________________________
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement ResetButton;

//__________________________________TOTAL TEXT____________________________________
	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	public static WebElement TotalPaginationCountEmployeeContact;

//__________________________________ NEXT BUTTON _________________________________
	@FindBy(xpath = "//li[@title='Next Page']//button[@type='button']")
	public static WebElement NextBtn;

//	@FindBy(xpath = "//*[@id ='usernameOrEmail']")
//	public static WebElement username;
//
//	// QDMS Password xpath
//	@FindBy(id = "password")
//	public static WebElement password;
//
//	// QDMS Loginbutton xpath
//	@FindBy(xpath = "//button[@type]")
//	public static WebElement login;
//
//	// Master card
//	@FindBy(xpath = "/html/body/div/div/section/section/main/div/div/div/div[1]/a/div/div")
//	public static WebElement Master;
//
//	// Click Employee Top Button
//	@FindBy(xpath = "//a[@class='sc-bdVaJa ieeiNp'][@href='#/master/employeelevel']")
//	public static WebElement Employeetopbutton;
//
//	// Employee Site Button
//	@FindBy(xpath = "//div[@class='ant-col ant-col-3']/div/div[3]")
//	public static WebElement Employeesitebutton;
//
//	// Allocate User button add
//	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[8]/span/button")
//	public static WebElement Addboxbutton;
//
//	// Employee User type dropdown
//	@FindBy(xpath = "//div[@name='userType']")
//	public static WebElement UserTypedropdown;
//
//	// Employee Role dropdown
//	@FindBy(xpath = "//div[@class='ant-select ant-select-multiple ant-select-show-search']")
//	public static WebElement Roledropdown;
//
//	// Employee Add button
//	@FindBy(xpath = "// button[@type='button'][2]")
//	public static WebElement AddButton;
//
//	// Employee Add user Header
//	@FindBy(xpath = "//*[@id='rcDialogTitle0']")
//	public static WebElement AdduserHeader;
//
//	// Employee Add Success Message
//	@FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-success ant-notification-notice-closable']")
//	public static WebElement AddEmployeesuccessmsg;
//
//	// Employee Add user First Data
//	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
//	public static WebElement Adduserfirstdata;
//
//	// Employee Add user AccountStatus
//	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[7]/span/span/p")
//	public static WebElement AccountStatus;

	// employee table total content

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']")
	public static WebElement employeetable;

	// employee firstname reset button

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement resetbutton;

	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div[3]/div[3]/div/div")
	public static WebElement userTypeInputField;
	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']/div/div")
	public static List<WebElement> userTypeList;
	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']/div/div")
	public static WebElement userTypeDropDownText;

	/**********************************************************************************************************
	 * EMPLOYEE PAGE WEBELEMENTS || @author Jathu Jana || Date : 13/07/2023
	 **********************************************************************************************************/
	// Employee Page - Search TextBox
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//input")
	public static WebElement SearchPopTextBox;
	
	//Add Employee Button
	@FindBy(xpath = "//div[@class='ant-table-title']/div/div/div[6]//button")
	public static WebElement addEmpButton;
	
	//Employee Page - Any PopUp Model
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement popUpModel;
	
	//Employee Page - Any PopUp Model Close Button
	@FindBy(xpath = "//div[@class='ant-modal-title']/div/span")
	public static WebElement popUpModelCloseButton;
	
	//Employee Page - Any PopUp Model Cancel Button
	@FindBy(xpath = "//div[@class='ant-modal-content']//button[1]")
	public static WebElement popUpModelFirstButton;
	
// @sasi - 18.07.2023

	// Allocate More Option
	@FindBy(xpath = "//div[@class='ant-popover ant-popover-placement-top ']//div[@class='ant-popover-inner-content']")
	public static WebElement moremodalcontent;

	// RAHUL.S(24/07/2023)
	@FindBy(xpath = "//input[@id='plant']/ancestor::div[2]//span[2]//span")
	public static WebElement closeButtonForPlant;

	@FindBy(xpath = "//*[@id='plant']/../..//span[2]")
	public static WebElement intermidateForPlant;

	@FindBy(xpath = "//*[@id='desigination']/../..//span[2]")
	public static WebElement intermidateForDesignation;

	// RAHUL.S(26/07/2023)
	@FindBy(xpath = "//input[@id='userType']//ancestor::div[1]")
	public static WebElement userTypeDrop;

	@FindBy(xpath = "//input[@id='role']")
	public static WebElement roleselect;

	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[2]")
	public static WebElement addUserButton;
	
	@FindBy(xpath = "//tr[2]//following-sibling::td[6]//span//p")
	public static WebElement firstRowStatus;
	
	@FindBy(xpath = "//tr[2]//following-sibling::td[7]//button")
	public static WebElement firstRowAddButton;
	
	@FindBy(xpath = "//div[@class='ant-modal-title']")
	public static WebElement addUserTitle;
	
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement deletePopUP;

	@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[1]")
	public static WebElement deleteCancelButton;

	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement employeeTable;

}
