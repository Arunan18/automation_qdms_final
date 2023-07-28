package com.qa.automation.qdms.pages.master;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RolePage {

	// ============================================== ADD ROLE-
	// =========================================

	// ***************************** ADD ROLE BUTTON X-PATH
	// **********************************************
	@FindBy(xpath = "//div[@class='ant-table-title']//button")
	public static WebElement addRoleButton;

	// ********************************* ROLE NAME TEXT FIELD
	// *************************************
	@FindBy(xpath = "//input[@id='role_name']")
	public static WebElement RoleNameTextField;

	// ********************************* SAVE BUUTON
	// *************************************
	@FindBy(xpath = "//div[@class='ant-modal-content']//button[2]")
	public static WebElement saveButton;

	// ********************************* TABLE *************************************
	@FindBy(xpath = "(//div[@class='ant-table ant-table-small'])[1]")
	public static WebElement Table;

	// ********************************* FIRST ROW
	// *************************************
	@FindBy(xpath = "(//td[normalize-space()='eee'])[1]")
	public static WebElement FirstRow;

	// ========================================== PAGINATION X PATH
	// =======================================================

	// ***************************** MENU BAR EMPLOYEE CLICK
	// ************************
	@FindBy(xpath = "(//a[@href='#/master/employeelevel'])[1]")
	public static WebElement EmployeemneuBar;

	// ******************************* ROLE BUTTON ********************************
	@FindBy(xpath = "(//div[@class='sc-gzVnrw geeJmJ'])[1]")
	public static WebElement RoleButton;

	// **************************** TOTAL TEXT
	// **************************************
	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	public static WebElement TotalText;

	// ****************************** 10 PAGE / CURRENT PAGINATION
	// ******************
	@FindBy(xpath = "//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']/li/div")
	public static WebElement CurrentPaginationOption;

	// ******************************PAGE NUMBER
	// *************************************
	@FindBy(xpath = "//li[@title='1']/a")
	public static WebElement PageNumber;

	// ************************ PAGINATION COUNT
	// *************************************
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[1]")
	public static WebElement PaginationCount;

	// ****************************** UNIT COLOUMN-(TotalRow)
	// **************************
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static WebElement UnitColumn;

	// ******************************* DEFAULT PAGINATION PAGE(1)
	// ********************************
	@FindBy(xpath = "//li[@title='1'][@class='ant-pagination-item ant-pagination-item-1 ant-pagination-item-active']")
	public static WebElement DefaultPaginationPage;

	// ******************************* NEXT PAGE BUUTON
	// ********************************
	@FindBy(xpath = "//li[@title='Next Page']/button")
	public static WebElement NextPageBtn;

	// ******************************* PREVIOUS BUTTON
	// ********************************
	@FindBy(xpath = "//li[@title='Previous Page']/button")
	public static WebElement PreviousButton;

	// ******************************* SECOND PAGE(1)
	// ********************************
	@FindBy(xpath = "(//a[normalize-space()='2'])[1]")
	public static WebElement PaginationSecoundPage;

	// ***************** TOTAL DATA IN SECOND PAGE - IN DOWN BAR
	// **********************
	@FindBy(xpath = "(//li[@class='ant-pagination-total-text'])[1]")
	public static WebElement totalTextSecondPage;

	// ******************************* THIRD PAGE(3)
	// ********************************
	@FindBy(xpath = "(//a[normalize-space()='3'])[1]")
	public static WebElement PaginationThirdPage;

	// ******************************* TOTAL ROWS ********************************
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr")
	public static List<WebElement> totalrows;

	// *******************CURRENT PAGINATION OPTION DRODOWN LIST******************
	@FindBy(xpath = "(//div[@class='ant-select-selector'])[1]")
	public static WebElement CurrentPaginationOpction;

	// ***********************************OPTION DROP DOWN ************************
	@FindBy(xpath = "(//div[@class='ant-select-selector'])[1]")
	public static WebElement DropDown;

	// ******************************* 10 ROLE NAME COLUMN
	// ********************************
	@FindBy(xpath = "(//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[7]/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div")
	public static List<WebElement> RoleNameColumn;

	// ******************************* 20 PAGE ********************************
	@FindBy(xpath = "//*[@class='ant-select-item ant-select-item-option'][@title='20 / page']")
	public static List<WebElement> Page20;

	// ******************************* 30 ROLE NAME COLUMN
	// ********************************
	@FindBy(xpath = "//*[@class='ant-select-item ant-select-item-option'][@title='30 / page']")
	public static List<WebElement> Page30;

	// ******************************* 100 ROLE NAME COLUMN
	// ********************************
	@FindBy(xpath = "//*[@class='ant-select-item ant-select-item-option'][@title='100 / page']")
	public static List<WebElement> Page100;

	// ****************** PAGINATION OF DOWN BAR
	// ******************************************
	@FindBy(xpath = "//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']")
	public static WebElement Pagination;

	// ************************ PAGINATION COUNT
	// ***************************************
	@FindBy(xpath = "(//li[@class='ant-pagination-total-text'])[1]")
	public static WebElement PaginationCounttotal;

	// ******************* PAGE COUNT
	// *************************************************
	@FindBy(xpath = "//*[@id=\\\"root\\\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[5]/a")
	public static WebElement PageCount;

	// *************************** PAGINATION COUNT
	// ************************************
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[1]")
	public static WebElement paginationcount;

	// ================================================== VALIDATION CHECK X-PATH
	// ====================================

	// ****************** ADD ROLE FORM X-PATH ***********************
	@FindBy(xpath = "(//div[@role='document'])[1]")
	public static WebElement dialogboxmodal;

	// ****************** ADD ROLE PLACE HOLDER X-PATH ***********************
	@FindBy(xpath = "(//input[@id='role_name'])[1]")
	public static WebElement placeholoderRole;

	// ****************** SAVE BUTTON X-PATH ***********************
	@FindBy(xpath = "(//button[@type='button'])[5]")
	public static WebElement svaebuttton;

	// ****************** CANCEL BUTTON ***********************
	@FindBy(xpath = "(//button[@class='ant-btn'])[1]")
	public static WebElement cancelButton;

	// ****************** 2 CHAR ONLY VALIDATION MESSAGE***********************
	@FindBy(xpath = "//div[normalize-space()='At Least 2 characters long!']")
	public static WebElement validationt2Char;

	// ***************** EMPTY SAVE VALIDATION MESSAGE XPATH ***********************
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div[2]")
	public static WebElement ValidationEmptysave;

	// ****************** ONLY LETTERS VALIDATION MESSAGE X PATH*******************
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div[2]")
	public static WebElement ValidationAllowOnlyLetters;

	// ************************* ERROR MESSAGE X PATH
	// ********************************
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div[2]")
	public static WebElement errormessage;

	// ***************** ROLE CAN'T BE EMPTY VALIDATION X PATH
	// ************************
	@FindBy(xpath = "(//div[normalize-space()=\"Role can't be empty\"])[1]")
	public static WebElement RoleCantBeEmpty;

	// ***************** ROLE ALLOW ONLY LETTERS VALIDATION X PATH
	// *********************
	@FindBy(xpath = "//div[normalize-space()='Role allow only letters']")
	public static WebElement RoleonlyAllowLetters;

	// ************************** AL READY EXIT VALIDATION *************************
	@FindBy(xpath = "(//div[normalize-space()='Role Already Exist'])[1]")
	public static WebElement AlreadyExitValidation;

//========================================EDIT FUNCTION ====================================

	// ********************* EDIT DATA PRODUT DEVELOPMENT**********************
	@FindBy(xpath = "//td[normalize-space()='Product Development']")
	public static WebElement editedData;

	// ********************* EDIT BUTTON DEVELOPMENT**********************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div/table/tbody/tr[4]/td[2]/span")
	public static WebElement EditButton;

	// ********************* UPDATE BUTTON **********************
	@FindBy(xpath = "//input[@id='role_name']//ancestor::div[3]//button[2]")
	public static WebElement UpdateButton;

	@FindBy(xpath = "//input[@id='role_name']")
	public static WebElement PlaceholderEdit;

//======================================== SEARCH FUNCTION ====================================

	// ********************* SEARCH BUTTON **********************
	@FindBy(xpath = "//span[@role='button']")
	public static WebElement SearchButton;

	// ********************* PLACE HOLDER -SEARCH ****************
	@FindBy(xpath = "//input[@placeholder=' Role']")
	public static WebElement SearchPlaceHolder;

	// ********************* SEARCH INSIDE **********************
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary ant-btn-sm'])[1]")
	public static WebElement insideSearch;

	// ********************* RESET BUTTON **********************
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement ResetButton;

	// *********AFTER SEARCH DATA VISIBLE ROW/TABLE DATA***********
	@FindBy(xpath = "//td[1]")
	public static WebElement TableDataAfterSearch;

//=========================================== ROLE BUTTON SIDE =====================================
	@FindBy(xpath = "(//div[@class='ant-spin-container'])[1]")
	public static WebElement RoleForm;

//=========================================ROLE BUTTON HEADING ===============================
	@FindBy(xpath = "//div[contains(text(),'Add Role')]")
	public static WebElement Roletext;

//CANCEL BUTTON X PATHS

//========================================= ADD ROLE FORM ====================================
	@FindBy(xpath = "//div[@role='document']")
	public static WebElement AddRoleForm;

//============================================CLOSE BUTTON =====================================
	@FindBy(xpath = "//span[@aria-label='close-circle']")
	public static WebElement CloseButton;

//========================================== EDIT BUTTON FOR CANCEL FUN =========================
	@FindBy(xpath = "(//span[@aria-label='edit'])[1]")
	public static WebElement EditbtnForCancel;

	/**********************************************************************************************************
	 * ROLE PAGE WEBELEMENTS || @author Jathu Jana || Date : 13/07/2023
	 **********************************************************************************************************/
	// Role Page - Search TextBox
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//input")
	public static WebElement SearchPopTextBox;
	
	//Role Page - Any PopUp Model
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement popUpModel;
	
	//Role Page - Any PopUp Model Save/Update/OK/Edit Button
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[1]")
	public static WebElement popUpModelFirstButton;
	
	//Role Page - Any PopUp Model Close Button
	@FindBy(xpath = "//div[@class='ant-modal-title']/div/span")
	public static WebElement popUpModelCloseButton;
	
	//BY:RAHUL.S (18/07/2023)
	// Role field validation
	@FindBy(xpath = "//input[@name='role_name']//..//div[1]")
	public static WebElement roleValidation;

	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	public static WebElement successMessages;

	@FindBy(xpath = "//tr[1]/td[1]")
	public static WebElement firstRowData;
	
	@FindBy(xpath = "//span[contains(@class,'ant-notification-close-icon')]")
	public static WebElement successMessageCloseBtn;
	
	@FindBy(xpath = "//button[@type='button']//span[text()='Cancel']")
	public static WebElement CancelButton;
	
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement table;
	
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement editPopUP;
	
	@FindBy(xpath = "//div[@class='ant-modal-header']//span")
	public static WebElement editCloseIcon;

}
