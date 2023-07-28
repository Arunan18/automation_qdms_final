package com.qa.automation.qdms.pages.master;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.qa.automation.qdms.base.DriverIntialization;

public class MaterialMainCategoryPage extends DriverIntialization {

	@FindBy(xpath = "//input[@type='text']")
	public static WebElement username;

	@FindBy(xpath = "//input[@name='password'][@id='password']")
	public static WebElement password;

	@FindBy(xpath = "//button[@type]")
	public static WebElement Login;

	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div/div[1]/a/div/div")
	public static WebElement master;

	@FindBy(xpath = "/html/body/div[1]/div/section/section/header/ul/li[3]/span/a")
	public static WebElement material;

	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div[1]/div/div[1]/div[1]")
	public static WebElement maincategory;

	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[4]/span/span/span")
	public static WebElement filter;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/div/div/div/div[2]/table/tbody/tr[6]/td[3]/label/span/input")
	public static WebElement RelTestcheckbox;

	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[2]")
	public static WebElement savebtn;
	
	

	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div[1]/div/div[1]")
	public static WebElement modulemainmaterial;

	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[1]/div/div[3]/button")
	public static WebElement addmainmaterialbtn;

	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div[1]/div/div[5]")
	public static WebElement material1;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/form/div[1]/div[1]/label[2]/span[1]/input")
	public static WebElement sburadiobtn;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/form/div[2]/div[2]/div/div[1]/div")
	public static WebElement subcategorydd;

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div[5]/div/span")
	public static WebElement FPfield;

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div[1]/div/span")
	public static WebElement RMfield;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/form/div[5]/div[1]/div/div[1]/div/div")
	public static WebElement sourcefield;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/form/div[5]/div[1]/div/div[1]/div/div")
	public static WebElement sourcefieldbox;

	@FindBy(xpath = "/html/body/div[5]/div/div/div/div[2]/div[1]/div/div/div[1]/div")
	public static WebElement place;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[1]")
	public static WebElement cancelbtn;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]")
	public static WebElement updatebtn;

	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div[2]/div/div/div/div/ul")
	public static WebElement pagination;

	@FindBy(xpath = "/html/body/div/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[3]")
	public static WebElement DefaultPaginationPage;

	@FindBy(xpath = "//li[@title='Next Page']//button[@type='button']")
	public static WebElement NextPageBtn;

	@FindBy(xpath = "/html/body/div/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[4]/a")
	public static WebElement PaginationSecoundPage;

	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[5]/span/span[1]/span/svg")
	public static WebElement editicon;

	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]/span")
	public static WebElement search;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/input")
	public static WebElement searchTextbox;

	@FindBy(xpath = "//*[@id=\"category_name\"]")
	public static WebElement maincatTextbox;

	@FindBy(xpath = "//input[@id='prefix']")
	public static WebElement prefixTextbox;

	@FindBy(xpath = "//input[@id='mainType']")
	public static WebElement maintypeDropdown;

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div[1]/div")
	public static WebElement FPDropdownOption;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[3]/div/div[1]/div/span[2]")
	public static WebElement RMDropdownOption;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]")
	public static WebElement addMaterialMainCategorymodal;

	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement rowdata1;

	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[2]")
	public static WebElement rowdata2;

	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[3]")
	public static WebElement rowdata3;

	@FindBy(xpath = "/html/body/div/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[2]/button/span")
	public static WebElement PreviousPageBtn;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[1]/div/div/p")
	public static WebElement addmaterialmaincattext;

	@FindBy(xpath = "//*[@id=\'category_name\']")
	public static WebElement editmaterialmaincattext;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[1]/div/label")
	public static WebElement maincatText;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[2]/div/label")
	public static WebElement prefixText;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[3]/div/label")
	public static WebElement mainTypeText;

	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[1]/div/div[1]")
	public static WebElement maincatMandotaryEmpty;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[5]/span[1]/span[1]")
	public static WebElement EditIcon;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/div/div/div/div[2]/table/tbody/tr[6]/td[3]")
	public static WebElement checkboxstatus;

	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	public static WebElement paginationCount;

	@FindBy(xpath = "//*[@id=\'root\']/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement editeddata;

	@FindBy(className = "ant-select-selection-item")
	public static WebElement CurrentPaginationOpction;

	@FindBy(xpath = "/html/body/div/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[5]/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div")
	public static WebElement Page_10;

	@FindBy(xpath = "/html/body/div/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[6]/div/div[2]/div/div/div/div[2]/div/div/div/div[2]/div")
	public static WebElement Page_20;

	@FindBy(xpath = "//*[@id=\'root\']/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[6]/div/div[2]/div/div/div/div[2]/div/div/div/div[3]")
	public static WebElement Page_30;

	@FindBy(xpath = "//*[@id='root']/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[6]/div/div[2]/div/div/div/div[2]/div/div/div/div[4]")
	public static WebElement Page_100;

	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]/span")
	public static WebElement maincategorysearchicon;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/input")
	public static WebElement maincategorysearchtextbox;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[2]/div/span[2]/span")
	public static WebElement prefixsearchicon;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/input")
	public static WebElement prefixsearchtextbox;

	@FindBy(xpath = "//*[@id=\"prefix\"]")
	public static WebElement editprefixtextbox;

	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[2]")
	public static WebElement prefixinfirstrow;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[5]/span/span[1]/span")
	public static WebElement firstRowEdit;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[2]")
	public static WebElement okbutton;

	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[5]/span/span[2]/a/span")
	public static WebElement deleteicon;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[1]")
	public static WebElement textpagination;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[1]/div/button")
	public static WebElement resetallbtn;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[3]/div/span[2]/span")
	public static WebElement maintypesearchicon;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[1]")
	public static WebElement maintypesearchdropdown;

	@FindBy(xpath = "/html/body/div[5]/div/div/div/div/div[1]/div/span[2]")
	public static WebElement rawmaterialddoption;

//***************************************************************************************************************************//
	// Material Multisearch
	// vithusha Mohan
	// ***************************************************************************************************************************//
	// material maincategory input
	@FindBy(xpath = "//input[@placeholder='Main Category' and @name='name']")
	public static WebElement main_input;
	// material main category->Prefix
	@FindBy(xpath = "//input[@placeholder='Prefix' and @name='prefix']")
	public static WebElement mainPrefix_input;
	// material maincategory maintype
	@FindBy(xpath = "//input[@id='mainType'  and @type='search']")
	public static WebElement mainType_input;

//******************************************************************************************
	@FindBy(xpath = "//a[@href='#/master/materiallevel']")
	public static WebElement materialk;

	@FindBy(xpath = "//div[@class='sc-dnqmqq eHflwQ'][normalize-space()='Material Main Category']")
	public static WebElement materialmaincbutton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement mcdata;

	public static String mcdatabefore = "//td[text()='";
	public static String mcdataafter = "']";
	public static String mcdatadeleteafter = "']//following-sibling::td[4]/span/span//span[@aria-label='delete']";

	@FindBy(xpath = "//tbody/tr[2]/td[5]/span[1]/span[2]/a[1]/span[1]//*[name()='svg']")
	public static WebElement deleteiconk;

	@FindBy(xpath = "//div[@class='ant-popover-inner-content']")
	public static WebElement popover;

	@FindBy(xpath = "//span[normalize-space()='OK']")
	public static WebElement okbuttonk;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]")
	public static WebElement searchicon;

	@FindBy(xpath = "//input[@placeholder='Main Category']")
	public static WebElement searchpopuptextbox;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement searchpopupsearchbutton;


	
	

	
	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div/button[2]")
	public static WebElement resetBtn;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[1]/div/span[2]")
	public static WebElement mainCateCategorySearch;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> MainCatColumn;
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[1]/div/div[1]")
	public static WebElement MainTableTitle;
  
	@FindBy (xpath = "//div[@class='ant-modal-content']")
	public static WebElement addmatpopup;
	
	@FindBy (xpath = "//body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[1]/div/div[1]")
	public static WebElement vali1;
	@FindBy (xpath = "//body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[2]/div/div[1]")
	public static WebElement vali2;
	@FindBy (xpath = "//body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[3]/div/div[1]")
	public static WebElement vali3;
	
	@FindBy (xpath = "//div[@class='ant-modal-title']//span")
	public static WebElement popclose;
	
	@FindBy (xpath = "//tbody[@class='ant-table-tbody']//tr")
	public static WebElement col;
	
	
	public static String main1st="//tbody[@class='ant-table-tbody']//tr[";
	
	
	public static String mainlast="]//td[1]";
	public static String prefixlast="]//td[2]";
	public static String last="]//td[3]";
	
	@FindBy (xpath = "//tbody[@class='ant-table-tbody']")
	public static WebElement mainctable;
	
	@FindBy (xpath="//div[@class='ant-notification-notice-message']")
	public static WebElement notmessage;
	
	@FindBy (xpath = "//li[@title='1']")
	public static WebElement firstbutn;
	
	
/*************************************************************************************************************
*	 MATERIAL MAIN  PAGE WEBELEMENTS		||		 @author Jathu Jana		||  		Date : 25/07/2023 
**************************************************************************************************************/
	//Material Main Category Page - Search TextBox
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//input")
	public static WebElement SearchPopTextBox;
	
	

	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement deletePopUP;
	
	@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[1]")
	public static WebElement deleteCancelButton;
	
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement materialMainTable;
	

	//Material Main Category Page - Any PopUp Model
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement popUpModel;
	
	//Material Main Category Page - Any PopUp Model Save/Update/OK/Edit Button
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[1]")
	public static WebElement popUpModelFirstButton;
	
	//Material Main Category Page - Any PopUp Model Close Button
	@FindBy(xpath = "//div[@class='ant-modal-title']/div/span")
	public static WebElement popUpModelCloseButton;
	
	//Add Material Main Category Button
	@FindBy(xpath = "//div[@class='ant-table-title']//button")
	public static WebElement addMaterialMainCatButton;
	
}
