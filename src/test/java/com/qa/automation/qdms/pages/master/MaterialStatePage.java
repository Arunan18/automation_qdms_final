package com.qa.automation.qdms.pages.master;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MaterialStatePage {
	
	 /** material --> MaterialState --> Pagination**/
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[3]")
	public static WebElement material;

	//Material --> "Material State" Button
    @FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[3]")
	public static WebElement materialState;
    
    @FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/button")
   	public static WebElement materialStateButton; 
    
    @FindBy(xpath = "//*[@id=\"material_state\"]")
   	public static WebElement materialStatetextbox;  
    
    @FindBy(xpath="//span[normalize-space()='Reset']")
    public static WebElement Reset;
     
    @FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]")
    public static WebElement Searchicon;
  
    @FindBy(xpath = "//input[@placeholder=' Material State']")
    public static WebElement SearchBoxplaceholder;
    
    @FindBy(xpath = "//span[normalize-space()='Search']")
    public static WebElement Searchbutton;
  
    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]")
   	public static WebElement materialStatesavebutton; 
    
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/div[3]/button[2]")
	public static WebElement UpdateButton;
	
	
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/input")
    public static WebElement SearchBox;
	
	@FindBy(xpath = "//tr[2]/td[1]")
	public static WebElement tableRow;
	

	@FindBy(xpath = "//*[@id=\"material_state\"]")
	public static WebElement addtextbox;
	
	
	@FindBy(xpath = "//*[@id=\"material_state\"]")
	public static WebElement EditmaterialTextbox;
    
    public static String UnitNameBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String UnitNameAfter = "]/td[1]";

	public static String EditBtnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String EditBtnAfter = "]/td[3]/span/a[1]";
	@FindBy(xpath = "//*[@id=\"material_state\"]")
	public static WebElement EditmateriastateTextbox;
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
    public static WebElement tableFirstRow;
	
    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div/div/div[2]")
	public static WebElement validationmsg;
    
//    /html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div/div/div[2]
  //form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div/div/div/div[1]
    
    @FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	public static WebElement totalText;
    
    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[1]")
	public static WebElement CancelBtn;
  
    @FindBy(xpath = "//span[@aria-label='close-circle']//*[name()='svg']")
	public static WebElement closeBtn;
   
    @FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']//span[contains(text(),'Cancel')]")
	public static WebElement deleteCancelBtn;
  //button[contains(@class,'ant-btn ant-btn-sm')]
    
	@FindBy(xpath = "//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']/li/div")
	public static WebElement CurrentPaginationOption;
	@FindBy(xpath = "//li[@title='1']/a")
	public static WebElement PageNumber;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[7]/td[2]/span/a[1]/span")
	public static WebElement editicon;
	
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[6]/td[2]/span/a[1]/span")
	public static WebElement Midediticon;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[2]/span/a[1]/span")
	public static WebElement lastediticon;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[2]/span/a[2]/a/span")
	public static WebElement deleteicon;
	
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement OKbutton;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table")
	public static WebElement MaterialStateTableBody;


	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[1]")
	public static WebElement paginationcount;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> materialColumn;
	@FindBy(xpath = "//li[@title='Next Page']/button")
	public static WebElement NextPageBtn;
	@FindBy(xpath = "//li[@title='Previous Page']/button")
	public static WebElement PreviousPageBtn;

	@FindBy(xpath = "//li[@title='1'][@class='ant-pagination-item ant-pagination-item-1 ant-pagination-item-active']")
	public static WebElement DefaultPaginationPage;
	@FindBy(xpath = "//li[@title='2'][@class='ant-pagination-item ant-pagination-item-2 ant-pagination-item-active']")
	public static WebElement PaginationSecoundPage;

	@FindBy(xpath = "//div[@class='ant-select ant-select-sm ant-pagination-options-size-changer ant-select-single ant-select-show-arrow']")
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

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[5]/a")
	public static WebElement PageCount;
	
//*****************************************************************************************************
	@FindBy (xpath = "//a[@href='#/master/materiallevel']" )
	public static WebElement materialk;
	
	@FindBy (xpath = "//div[@class='sc-dnqmqq fyMRQD']")
	public static WebElement materialstatecbutton;
	
	@FindBy (xpath =  "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement msdata;
	
	@FindBy (xpath =  "//tbody/tr[2]/td[2]/span[1]/a[2]/a[1]/span[1]")
	public static WebElement deleteiconk;
	
	@FindBy (xpath = "//div[@class='ant-popover ant-popconfirm ant-popover-placement-top ']")
	public static WebElement popover;
	
	@FindBy (xpath = "//span[normalize-space()='OK']")
	public static WebElement okbuttonk;
	
	@FindBy (xpath = "//span[@aria-label='search']//*[name()='svg']")
	public static WebElement searchicon;
	
	@FindBy (xpath =  "//input[@placeholder=' Material State']")
	public static WebElement searchpopuptextbox;
	
	@FindBy (xpath =  "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement searchpopupsearchbutton;
	
//===============================================================================================================
	    // SARANKA -X PATH
	
	//*********************************** MENU BAR MATERIAL ***************************
	@FindBy(xpath = "//a[@href='#/master/materiallevel']")
	public static WebElement MenuBaraMaterial;
	
	//*********************************** MATERIAL STATE *******************************
	@FindBy(xpath = "//div[@class='sc-dnqmqq fyMRQD']")
	public static WebElement MaterialStateSideButton;
	
	//********************************* EDIT BUTTON **********************************
	@FindBy(xpath ="(//span[@aria-label='edit'])[5]")
	public static WebElement EditButton ;
	
	//***************************INVALID CHAR VALIDATION ******************************
	@FindBy(xpath = "(//div[normalize-space()='Invalid charaters'])[1]")
	public static WebElement InvalidChar;
	
	//******************************EDIT PLACE HOLDER**********************************
	@FindBy(xpath = "//input[@id='material_state']")
	public static WebElement PlacheHolderMaterial;
	
	//*********************************UPDATE BUTTON************************************
	@FindBy(xpath = "(//button[@type='button'])[5]")
	public static WebElement UpdateButtonMaterial;
	
	//***************************** EMPTY VALIDATION MESSAGE *****************************
	@FindBy(xpath = "(//div[normalize-space()=\"Material state can't be empty\"])[1]")
	public static WebElement  CantBeEmpty;
	
	//***********************************2 CHARACTER ONLY ******************************
	@FindBy(xpath = "(//div[normalize-space()='At Least 2 charaters long!'])[1]")
	public static WebElement twoCharcterOnly;
	
	//********************************* AL READY EXIT VALIDATION ***********************
	@FindBy(xpath = "(//div[normalize-space()='Material State already exist'])[1]")
	public static WebElement AlreadyExit;
	
	//************************* AFTER EDITED VALIDATION *********************************
	@FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-success ant-notification-notice-closable']")
	public static WebElement AfterEditValidation;
	
//****************************SASI'S DO NOT CHANGE OR DON'T TOUGH***************************
	// QDMS username xpath
				@FindBy(xpath="//*[@id ='usernameOrEmail']")
				public static WebElement username;
						
			// QDMS Password xpath
				@FindBy(id="password")
				public static WebElement password;

			// QDMS Loginbutton xpath
				@FindBy(xpath= "//button[@type]")
				public static WebElement login;
						
			// Master card 	
				@FindBy(xpath = "/html/body/div/div/section/section/main/div/div/div/div[1]/a/div/div")
				public static WebElement Master;
				

				// Materialtopmenu click
					@FindBy(xpath= "//*[@id=\"root\"]/div/section/section/header/ul/li[3]")
					public static WebElement Materialtopmenu;
								
				//Materialstatebutton Click
				@FindBy(xpath= "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[3]")
				public static WebElement Materialstatebutton;	

					// State filed click
					@FindBy(xpath= "//input[@id='material_state']")
					public static WebElement StateField;
				

					// Update button click
					@FindBy(xpath= "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]/span")
					public static WebElement Updatestatebutton;
					
					// Material State Validation click
					@FindBy(xpath= "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div/div/div[1]")
					public static WebElement Materialstatevalidation;
					
					// Material State cancel button click
					@FindBy(xpath= "//button[@class='ant-btn']")
					public static WebElement MaterialstateCancelbtn;
//******************************************************************************************	
	
/**********************************************************************************************************
* MATERIAL STATE PAGE WEBELEMENTS			||		 @author Jathu Jana		||  		Date : 07/07/2023 
**********************************************************************************************************/
	//Add Material State Material State TextBox
	@FindBy(xpath = "//div[@class='ant-table-title']/div/div/button")
	public static WebElement addMaterialStateButton;
					
	//Add Material State Material State TextBox
	@FindBy(xpath = "//*[@id='material_state']")
	public static WebElement materialStateTextBox;
			
	//Material State Page - Any PopUp Model
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement popUpModel;
					
	//Material State Page - Any PopUp Model Cancel Button
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[2]")
	public static WebElement popUpModelSecondButton;
					
	//Material State Page - Any PopUp Model Save/Update/OK/Edit Button
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[1]")
	public static WebElement popUpModelFirstButton;
					
	//Material State Page - Any PopUp Model Close Button
	@FindBy(xpath = "//div[@class='ant-modal-title']/div/span")
	public static WebElement popUpModelCloseButton;
						
	// Add Material State Success Message
	@FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-success ant-notification-notice-closable']/div/div/div[1]")
	public static WebElement matStateSuccessMessage;
					
	//Material State Table First Added Data
	@FindBy(xpath = "//tbody/tr[2]/td[1]")
	public static WebElement firstTableData;
					
	//Add Material State - Material State Validation
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[1]/div[1]")
	public static WebElement materialStateValidation;
					
	//Material State Page - Any Inner PopUp Cancel Button
	@FindBy(xpath = "//div[@class='ant-popover-inner-content']")
	public static WebElement innerPopUp;
							
	//Material State Page - Any Inner PopUp Cancel Button
	@FindBy(xpath = "//div[@class='ant-popover-inner-content']//button[1]")
	public static WebElement innerPopUpFirstButton;
	
	//Material State Page - Sub Module Material State Button
	@FindBy(xpath = "//main/div/div/div[1]/div/div[3]")
	public static WebElement materialStateSubModule;
		
	//Material State Page - Table Title
	@FindBy(xpath = "//div[@class='ant-table-title']/div/div[1]")
	public static WebElement mainTableTitle;
	
/*************************************************************************************************************
*	 MATERIAL STATE PAGE WEBELEMENTS		||		 @author Jathu Jana		||  		Date : 13/07/2023 
**************************************************************************************************************/
	//Material State Page - Search TextBox
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//input")
	public static WebElement SearchPopTextBox;
	
	
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement deletePopUP;
	
	@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[1]")
	public static WebElement deleteCancelButton;
	
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement materialStateTable;
}