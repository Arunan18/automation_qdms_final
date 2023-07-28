
// ****************************************************************************************
// SOURCE PAGE
// @SASIKALA AMBALAVANAR
// DATE :- 25:02:2023

// ****************************************************************************************

package com.qa.automation.qdms.pages.master;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SourcePage {

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

	// Material Top Bar
	@FindBy(xpath = "//li[@class='ant-menu-overflow-item ant-menu-item ant-menu-item-only-child'][3]")
	public static WebElement Materialtopbar;

	// Source Site bar button
	@FindBy(xpath = "//div[@class='sc-gzVnrw geeJmJ'][3]")
	public static WebElement sourcesitebar;

	// Add Source Button
	@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']/span[1]")
	public static WebElement AddSourcebtn;

	// Source Add Field
	@FindBy(xpath = "//input[@id='name']")
	public static WebElement sourcefiled;

	// Source Description field
	@FindBy(xpath = "//input[@name='description']")
	public static WebElement sourceDescFied;

	// Source Save field
	@FindBy(xpath = "//button[@type='button']//span[text()='Save']")
	public static WebElement sourceSavebtn;

	// Source Last Added Data Come First
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement lastaddedfirstdata;

	// Sourcesitebutton Click
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[4]/div[1]")
	public static WebElement Sourcesitebutton;

	// Count Pagination
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[6]/div/div[1]")
	public static WebElement totalpaginationcount;

	// CurrentPaginationOption
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[3]/a")
	public static WebElement CurrentPaginationOption;

	// First page number(1-xapth)
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[3]/a")
	public static WebElement PageNumber;

	// Source Column xpath first
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]")
	public static List<WebElement> UnitColumn;

	// Next Page Arrow
	@FindBy(xpath = "//li[@title='Next Page']/button")
	public static WebElement NextPageBtn;

	// Previous Arrow click
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[2]/button/span")
	public static WebElement PreviousPageBtn;

	// Default active page one in pagination
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[3]/a")
	public static WebElement DefaultPaginationPage;

	// second pagination move
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[4]/a")
	public static WebElement PaginationSecoundPage;

	// page 10
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[6]/div/div[1]/span[2]")
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

	// Total Size DropDown
	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']")
	public static List<WebElement> AddCustomerdatasizedata;

	// Plant Name Before
	public static String CustomerPlantBefore = "//div[@class='rc-virtual-list']/div/div/div/div[";

	// Plant Name After
	public static String CustomerPlantAfter = "]";

	// Source Add Success Message
	@FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-success ant-notification-notice-closable']")
	public static WebElement AddSourcesuccessmsg;

//Add Source Close button
	@FindBy(xpath = "//span[@class='anticon anticon-close-circle']")
	public static WebElement closebutton;

// Source Delete Cancel button
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement Sourcedeletecancelbtn;

	// ****************************************************************************************
	// SOURCE PAGE
	// @VITHUSHA MOHAN
	// DATE :- 03:05:2023

	// ****************************************************************************************

	// xpath of material in navbar
	@FindBy(xpath = "//a[@href='#/master/materiallevel']")
	public static WebElement material;
	// xpath of source button
	@FindBy(xpath = "//div[@class='sc-dnqmqq hnktPT'][normalize-space()='Source']")
	public static WebElement sourceside;
	// xpath of first column row
	@FindBy(xpath = "//tr[contains(@class,'ant-table-row')]/child::td[1]")
	public static List<WebElement> column_first;
	// xpath of second column row
	@FindBy(xpath = "//tr[contains(@class,'ant-table-row')]/child::td[2]")
	public static List<WebElement> column_second;
	// xpath of third column row
	@FindBy(xpath = "//tr[contains(@class,'ant-table-row')]/child::td[3]")
	public static List<WebElement> column_third;
	// xpath of fourth column row
	@FindBy(xpath = "//tr[contains(@class,'ant-table-row')]/child::td[4]")
	public static List<WebElement> column_fourth;
	// xpath of fifth column row
	@FindBy(xpath = "//tr[contains(@class,'ant-table-row')]/child::td[5]")
	public static List<WebElement> column_fifth;
	// xpath of sixth column row
	@FindBy(xpath = "//tr[contains(@class,'ant-table-row')]/child::td[6]")
	public static List<WebElement> column_sixth;
	// xpath of seventh column row
	@FindBy(xpath = "//tr[contains(@class,'ant-table-row')]/child::td[7]")
	public static List<WebElement> column_seventh;
	// xpath of eight column row
	@FindBy(xpath = "//tr[contains(@class,'ant-table-row')]/child::td[8]")
	public static List<WebElement> column_eight;
	// xpath of nineth column row
	@FindBy(xpath = "//tr[contains(@class,'ant-table-row')]/child::td[9]")
	public static List<WebElement> column_nine;
	// xpath of firstcolumn search icon
	@FindBy(xpath = "//th[1]//*[name()='svg']")
	public static WebElement firstColum_icon;
	// xpath of secondcolumn search icon
	@FindBy(xpath = "//th[2]//*[name()='svg']")
	public static WebElement secondcolumn_icon;
	// xpath of thirdcolumn search icon
	@FindBy(xpath = "//th[3]//*[name()='svg']")
	public static WebElement thirdcolumn_icon;
	// xpath of fourthcolumn search icon
	@FindBy(xpath = "//th[4]//*[name()='svg']")
	public static WebElement fourthcolumn_icon;
	// xpath of fifthcolumn search icon
	@FindBy(xpath = "//th[5]//*[name()='svg']")
	public static WebElement fifthcolumn_icon;
	// xpath of sixthcolumn search icon
	@FindBy(xpath = "//th[6]//*[name()='svg']")
	public static WebElement sixthcolumn_icon;
	// xpath of seventhcolumn search icon
	@FindBy(xpath = "//th[7]//*[name()='svg']")
	public static WebElement seventhcolumn_icon;
	// xpath of eightcolumn search icon
	@FindBy(xpath = "//th[8]//*[name()='svg']")
	public static WebElement eightcolumn_icon;
	// xpath of eightcolumn search icon
	@FindBy(xpath = "//th[9]//*[name()='svg']")
	public static WebElement ninecolumn_icon;

	// xpath of source input textbox
	@FindBy(xpath = "//input[@placeholder =' Source' and @name='name']")
	public static WebElement source_input;
	// xpath of source input textbox
	@FindBy(xpath = "//input[@placeholder=' Description' and @name='description']")
	public static WebElement description_input;

	// Edit (Update) button
	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[2]")
	public static WebElement Updatebtn;

	// Validation Source
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div/div/div")
	public static WebElement validation;

//####################################################################################################

//***************************************************************************************************
// XPATH OF SEARCH BUTTON OF CODE

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]")
	public static WebElement codesearch;

//***************************************************************************************************
// XPATH OF TEXT OF PAGINATION	
	// Add Source Cancel button
	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[1]/span")
	public static WebElement cancelbutton;

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

	public static String SourceColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String SourceColumnAfter = "]/td[1]";
	public static String deleteBtnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String deleteBtnAfter = "]/td[3]/span/a[2]";
	@FindBy(xpath = "//div[@class='ant-popover ant-popconfirm ant-popover-placement-top ']/div/div[2]/div/div[2]/button[2]")
	public static WebElement deleteOkBtn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> SourceColumn;

	// ****************************************************************************************************************

	@FindBy(xpath = "//a[@href='#/master/materiallevel']")
	public static WebElement materialk;

	@FindBy(xpath = "//div[@class='sc-dnqmqq hnktPT'][normalize-space()='Source']")
	public static WebElement sourcebutton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[3]")
	public static WebElement firstpage;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement sourcedata;

	@FindBy(xpath = "//tbody/tr[2]/td[3]/span[1]/a[1]/span[1]//*[name()='svg']")
	public static WebElement editicon;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]")
	public static WebElement editpoup;

	@FindBy(id = "name")
	public static WebElement sourcetextbox;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]")
	public static WebElement updatebutton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]")
	public static WebElement tablesourcesearch;

	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//div//input[contains(@placeholder,'Source')]")
	public static WebElement sourceserchtextbox;

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div/button[1]")
	public static WebElement searchboxsearchbutton;

	// EditDescTextbox
	@FindBy(xpath = "//input[@placeholder='Description']")
	public static WebElement editdesctextbox;

	// firstRowEdit
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[3]/span/a[1]/span")
	public static WebElement firstRowEdit;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[1]")
	public static WebElement textpagination;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/input")
	public static WebElement textbox;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/button[2]")
	public static WebElement reset;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]")
	public static WebElement sourcemodal;

//*************@Modified By :- SASI****************
	// Source Header
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[1]/div/div[1]")
	public static WebElement Sourceheader;

	// Admin Click button
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/div/div[2]/div/div/span")
	public static WebElement Adminbtn;

	// Logout Button
	@FindBy(xpath = "//span[@class='ant-dropdown-menu-title-content']/p")
	public static WebElement Logoutbtn;

	@FindBy(xpath = "(//span[@role='button'])[2]")
	public static WebElement Descriptionicon;
	// Add source Validation

	@FindBy(xpath = "//*[@id=\"name\"]")
	public static WebElement sourceTextBox;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div/div/div")
	public static WebElement validationMesage;
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[4]")
	public static WebElement sourceNavigation;
	@FindBy(xpath = "//div[@class='sc-bxivhb hiMnNy']//div//button[@type='button']")
	public static WebElement addSourceButton;
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[2]")
	public static WebElement saveButton;
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[1]")
	public static WebElement cancelButton;

	// @Sasi - Modified :- 03-07-2023

	// Source Filed Validation
	@FindBy(xpath = "//input[@id='name']//../div[1]")
	public static WebElement SourceFieldValidation;

	// Source Search icon
	@FindBy(xpath = "//th[1]//span[@role='img']")
	public static WebElement Sourcesearchicon;

	// Source Text Box Field
	@FindBy(xpath = "//input[@placeholder=' Source']")
	public static WebElement Sourcesearchtextbox;

	// Source Search Button
	@FindBy(xpath = "//button[@type='button']//span[text()='Search']")
	public static WebElement sourcesearchButton;

	// Description Search icon
	@FindBy(xpath = "//th[2]//span[@role='img']")
	public static WebElement descriptionsearchicon;

	// Description Text Box icon
	@FindBy(xpath = "//input[@placeholder=' Description']")
	public static WebElement Descriptionsearchtextbox;

	// Description Search Button
	@FindBy(xpath = "//button[@type='button']//span[text()='Search']")
	public static WebElement DescriptionsearchButton;

	// Source Reset Button
	@FindBy(xpath = "//button[@type='button']//span[text()='Reset']")
	public static WebElement sourceresetButton;

	// Source Reset All Button
	@FindBy(xpath = "//button[@type='button']//span[text()='Reset All']")
	public static WebElement sourceresetallButton;

	/**********************************************************************************************************
	 * SOURCE PAGE WEBELEMENTS || @author Jathu Jana || Date : 13/07/2023
	 **********************************************************************************************************/
	// Source Page - Search TextBox
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//input")
	public static WebElement SearchPopTextBox;

	@FindBy(xpath = "//tr[2]/td[1]")
	public static WebElement firstRowData;
	
	
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement deletePopUP;
	
	@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[1]")
	public static WebElement deleteCancelButton;
	
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement sourceTable;

}
