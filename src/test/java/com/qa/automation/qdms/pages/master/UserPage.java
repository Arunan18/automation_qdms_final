// ***********************************************************************************
// * Description
// *------------
// * USER PAGE
// ***********************************************************************************
// *
// * Author : WATHSALA WEERAKOON
// * Date Written : 01/03/2023
// *
// *
// *
// * Test Case Number Date Intis Comments
// * ================ ==== ===== ========
// * 01/03/2023 WATHI Orginal Version
// *
// ************************************************************************************
package com.qa.automation.qdms.pages.master;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage {

	@FindBy(xpath = "/html/body/div[5]/div/div/div/div[2]")
	public static WebElement moredetailsmodal;

	@FindBy(xpath = "//li[@class='ant-menu-overflow-item ant-menu-item ant-menu-item-only-child'][6]")
	public static WebElement employeetab;

	@FindBy(xpath = "//a[@href='#/master/employeelevel']")
	public static WebElement employeetabnew;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[4]")
	public static WebElement user;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div[3]/button")
	public static WebElement adduserbutton;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr[1]/td[2]")
	public static WebElement leftsidefirstitem;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr[1]/td[1]/label/span")
	public static WebElement leftsidefirstitemcheckbox;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/button[1]")
	public static WebElement sendrightarrow;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr/td[3]/div/div")
	public static WebElement usertypebox;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr/td[4]/div/div/div")
	public static WebElement rolebox;

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div[2]/div[1]/div/div")
	public static List<WebElement> usertypeoptions;

	@FindBy(xpath = "/html/body/div[5]/div/div/div/div[2]/div[1]/div/div")
	public static List<WebElement> roleoptions;

	@FindBy(xpath = "//div[@class='ant-modal-content']/div[3]/button[2]")
	public static WebElement addusersavebutton;

	@FindBy(xpath = "//div[@class='ant-modal-content']/div[3]/button[1]")
	public static WebElement adduserscancelbutton;

	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr/td[1]/label/span/input")
	public static WebElement usercheckbox;

	@FindBy(xpath = "//label[@class='ant-checkbox-wrapper ant-checkbox-wrapper-checked ant-transfer-list-checkbox']")
	public static WebElement usercheckboxnew;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr")
	public static List<WebElement> transferdata;

	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/ul/li[3]/button/span/svg")
	public static WebElement nextpagearrowuserpage;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]")
	public static WebElement modal;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[7]/span/span")
	public static WebElement roleallocationicon;

	@FindBy(xpath = "//div[@class='ant-select-selection-overflow-item ant-select-selection-overflow-item-suffix']")
	public static WebElement plantroledropdown;

	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']")
	public static List<WebElement> plantroledropdowncontent;

	@FindBy(xpath = "//div[@class='ant-select-selector']/div[@class='ant-select-selection-overflow']")
	public static WebElement plantroldropdowntext;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary']")
	public static WebElement plantroleeditOkbutton;

	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement plantroleeditCancelbutton;

	@FindBy(xpath = "//div[@class='ant-modal-title']")
	public static WebElement plantroleeditmodelheading;

	@FindBy(xpath = "//body[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/p[1]")
	public static WebElement createdtime;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[8]/span/span")
	public static WebElement more;

	@FindBy(xpath = "//body[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/p[1]")
	public static WebElement updatedtime;

	@FindBy(xpath = "/html/body/div[3]/div/div")
	public static WebElement moredetailsmodalfullcontent;

	// pagination user module

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[3]")
	public static WebElement DefaultPaginationPage;

	@FindBy(xpath = "//li[@class='ant-pagination-next']")
	public static WebElement NextPageBtn;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[4]")
	public static WebElement PaginationSecoundPage;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]")
	public static WebElement totalTextSecondPage;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr/td[1]")
	public static List<WebElement> totalrows;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[11]/div/div[1]")
	public static WebElement CurrentPaginationOpction;

	@FindBy(xpath = "//span[@class='ant-select-selection-item']")
	public static WebElement DefaultPaginationPage30;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr/td[1]")
	public static List<WebElement> usernameColumn;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[11]/div/div[2]/div/div/div/div[2]/div/div/div/div[2]")
	public static WebElement Page_20;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[11]/div/div[2]/div/div/div/div[2]/div/div/div/div[3]")
	public static WebElement Page_30;

	@FindBy(xpath = "//*[@class='ant-select-selection-item'][@title='100 / page']")
	public static WebElement Page_100;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr/td[1]")
	public static List<WebElement> when20usernamecolumn;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr/td[1]")
	public static List<WebElement> when30usernamecolumn;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement firstuserValue;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[4]")
	public static WebElement page2;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[9]")
	public static WebElement pagelast;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]")
	public static WebElement usernamesearchicon;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]")
	public static WebElement usernamesearchbutton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[2]/div/span[2]")
	public static WebElement employeesearchicon;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/button[1]")
	public static WebElement employeesearchbutton;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[1]/input")
	public static WebElement searchhereplaceholder;

	@FindBy(xpath = "//a[@class='ant-transfer-list-search-action']//span[@class='anticon anticon-close-circle']")
	public static WebElement closebutton;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/div[1]/input\r\n")
	public static WebElement Rightsigesearchhereplaceholder;

	@FindBy(xpath = "")
	public static WebElement Rightsigesearchicon;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[5]/div/span[2]")
	public static WebElement conductNoSearchIcon;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/input")
	public static WebElement conductNoSearchPlaceholder;

	@FindBy(xpath = "//input[contains(@placeholder,'Contact No')]")
	public static WebElement conductNoSearchPlaceholdernew;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/button[1]")
	public static WebElement conductNosearchbutton;

	@FindBy(xpath = "//li[@title='Next Page']//button")
	public static WebElement next;

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

	// xpath for Employee in navbar
	@FindBy(xpath = "//a[@href='#/master/employeelevel']")
	public static WebElement employee;
	// User button sidebar
	@FindBy(xpath = "//div[@class='sc-dnqmqq hnktPT' and text()='User']")
	public static WebElement userside;
	@FindBy(xpath = "//input[@placeholder=' Username' and @name='userName']")
	public static WebElement userSearch_input;
	@FindBy(xpath = "//input[@placeholder=' Employee' and @name='firstName']")
	public static WebElement employeSearch_input;
	@FindBy(xpath = "//input[@placeholder=' Plant' and @name='plantName']")
	public static WebElement plantSearch_input;
	@FindBy(xpath = "//input[@placeholder=' Designation' and @name='designationName']")
	public static WebElement designationSearch_input;
	@FindBy(xpath = "//input[@placeholder=' Contact No' and @name='phoneNumber']")
	public static WebElement contactNoSearch_input;

	// user single search
	@FindBy(xpath = "//a[@href='#/master/employeelevel']")
	public static WebElement employeek;
	@FindBy(xpath = "//*[@id=\\\"root\\\"]/div/section/section/main/div/div/div[1]/div/div[4]")
	public static WebElement userk;
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/ul")
	public static WebElement Pagination;
	@FindBy(xpath = "//li[@title='Next Page']//button[@type='button']")
	public static WebElement nextpage;
	@FindBy(xpath = "(//li[contains(@class, 'ant-pagination-item') and not(contains(@class, 'ant-pagination-item-74'))])[last()]")
	public static WebElement lastpage;
	@FindBy(xpath = "(//span[@role='button'])[1]")
	public static WebElement usernamesearchbuttonk;
	@FindBy(xpath = "//input[@placeholder=' Username']")
	public static WebElement usernamesearchbox;
	@FindBy(xpath = "//span[normalize-space()='Search']")
	public static WebElement searchboxbutton;
	@FindBy(xpath = "//tr[@class='ant-table-row ant-table-row-level-0']//td[1]")
	public static WebElement usernametable;

	@FindBy(xpath = " //th[3]//div[1]//span[2]//span[1]//*[name()='svg']")
	public static WebElement plantsearchbutton;
	@FindBy(xpath = "//input[@placeholder=' Plant']")
	public static WebElement plantsearchbox;
	@FindBy(xpath = "//span[normalize-space()='Search']")
	public static WebElement plantsearchboxbutton;
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[3]")
	public static WebElement planttable;

	@FindBy(xpath = "//th[4]//div[1]//span[2]//span[1]//*[name()='svg']")
	public static WebElement designationsearchbutton;
	@FindBy(xpath = "//input[@placeholder=' Designation']")
	public static WebElement designationsearchbox;
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/button[1]")
	public static WebElement designationtsearchboxbutton;
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[4]")
	public static WebElement designationtable;

	// Search contact number second page

	@FindBy(xpath = "//th[5]//div[1]//span[2]//span[1]//*[name()='svg']")
	public static WebElement contactnumbersearchbutton;
	@FindBy(xpath = "//input[@placeholder=' Contact No']")
	public static WebElement contactnumbersearchbox;
	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']//div[@class='ant-table-filter-dropdown']//div//div//span[contains(text(),'Search')]")
	public static WebElement contactnumbersearchboxbutton;
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[5]")
	public static WebElement contactnumbertable;

	// toggle switch

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[1]/button")
	public static WebElement togglebuttonoff;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[1]/button/span")
	public static WebElement togglebuttonofftext;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[2]/div")
	public static WebElement addplantdropdown;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[3]/div")
	public static WebElement addthetypedropdown;

	@FindBy(xpath = "//*[@id=\"plant\"]")
	public static WebElement addplantdropdownbox;

	@FindBy(xpath = "//*[@id=\"userType\"]")
	public static WebElement selectthetypedropdownbox;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div/div/div/table/thead/tr/th[1]/div/label/span/input")
	public static WebElement selectalluserscheckbox;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/div[1]/input")
	public static WebElement searchhereplaceholderleft;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/button[2]")
	public static WebElement lefttsidearrow;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/button[1]")
	public static WebElement rightsidearrow;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr/td/div/div[2]")
	public static WebElement nodata;

	@FindBy(xpath = "//main[@class='ant-layout-content']")
	public static WebElement nodatarightside;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/ul/li[2]")
	public static WebElement DefaultIndexPaginationPage;

	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/ul/li[3]")
	public static WebElement PaginationSecoundPageredirect;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/ul/li[4]/button")
	public static WebElement NextPageButtonpopup;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/ul/li[4]/button")
	public static WebElement PreviousPageBtnDisplay;

//  @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/ul/li[4]/button")
//  public static WebElement PreviousPageBtndisable;

	// toggle switch

	// @FindBy (xpath =
	// "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[1]/button")
	// public static WebElement togglebuttonoff;

	// @FindBy (xpath =
	// "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[1]/button/span")
	// public static WebElement togglebuttonofftext;

	// @FindBy (xpath =
	// "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[2]/div")
	// public static WebElement addplantdropdown;

	// @FindBy (xpath =
	// "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[3]/div")
	// public static WebElement addthetypedropdown;

	// @FindBy (xpath = "//*[@id=\"plant\"]")
	// public static WebElement addplantdropdownbox;

	// @FindBy (xpath = "//*[@id=\"userType\"]")
	// public static WebElement selectthetypedropdownbox;

	// @FindBy (xpath =
	// "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div/div/div/table/thead/tr/th[1]/div/label/span/input")
	// public static WebElement selectalluserscheckbox;

	// @FindBy(xpath="/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/div[1]/input")
	// public static WebElement searchhereplaceholderleft;

	// @FindBy(xpath="/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/button[2]")
	// public static WebElement leftsidearrow;

	// @FindBy(xpath="/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/button[1]")
	// public static WebElement rightsidearrow;

	// @FindBy(xpath="/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr/td/div/div[2]")
	// public static WebElement nodata;

	// @FindBy(xpath="//main[@class='ant-layout-content']")
	// public static WebElement nodatarightside;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/label")
	public static WebElement checkBoxDropDown;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/span[1]")
	public static WebElement dropDown;

	@FindBy(xpath = "/html/body/div[4]/div/div/ul")
	public static WebElement modalCheckBoxDropDown;

	@FindBy(xpath = "//span[normalize-space()='Select all data']")
	public static WebElement selectAllXpath;

	@FindBy(xpath = "//span[normalize-space()='Invert current page']")
	public static WebElement invertCurrentPage;
	@FindBy(xpath = "/html/body/div[4]/div/div/ul/li[1]")
	public static WebElement selectAllSelect;

	@FindBy(xpath = "/html/body/div[4]/div/div/ul/li[2]")
	public static WebElement selectInvertAll;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/label/span/input")
	public static WebElement selectallemployee;

	@FindBy(xpath = "//div[@class='ant-modal-root']/div[2]/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/div[2]/div/div/div/ul/li[@title='Next Page']/button")
	public static WebElement transferlistnextpagebutton;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr")
	public static List<WebElement> totalrowsrightsidetransferlist;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/div[2]/div/div/div/ul/li[2]")
	public static WebElement transferlistpage1;

	public static String pageBefore = "//div[@class='ant-modal-root']/div[2]/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/div[2]/div/div/div/ul/li[@title='";
	public static String pageAfter = "']/a";

	@FindBy(xpath = "//div[@class='ant-table-title']/div/div/div[3]/button")
	public static WebElement addUserBtn;
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[1]/div/div/p")
	public static WebElement addUserForm;
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr/td[2]")
	public static List<WebElement> UserList;
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[2]/div[2]/button[1]")
	public static WebElement rightArrowBtn;
	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[2]")
	public static WebElement saveBtn;
	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[1]")
	public static WebElement cancelBtn;
	public static String checkBefore = "//div[@class='ant-modal-content']/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr[";
	public static String checkAfter = "]/td[1]/label/span/input";
	public static String userBefore = "//div[@class='ant-modal-content']/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr[";
	public static String userAfter = "]/td[2]";
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/ul/li[@title='Next Page']/button")
	public static WebElement nextBtn;
	@FindBy(xpath = "//body[@class='ant-scrolling-effect']/div[3]/div/div[2]/div/div[2]/div[2]/div/div[3]")
	public static WebElement userValidation;
	@FindBy(xpath = "//div[@class='ant-select ant-select-multiple ant-select-show-search']")
	public static WebElement transferlistrole;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-danger ant-btn-sm ant-btn-background-ghost']")
	public static WebElement clearbutton;

	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement cancelbutton;

	@FindBy(xpath = "//li[@title='2'][@class='ant-pagination-item ant-pagination-item-2']")
	public static WebElement manageuserspaginationsecondpage;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> usernameRowCount;
	public static String usernameBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String usernameAfter = "]/td[1]";
	public static String roleAllocationBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String roleAllocationAfter = "]/td[7]/span/span";

	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr/td[2]")
	public static List<WebElement> transferlistusernameRowCount;
	public static String transferlistusernameBefore = "/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[";
	public static String transferlistusernameAfter = "]/td[2]";

	@FindBy(xpath = "//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']/li[3]/button")
	public static WebElement transferlistNextPageBtn;

	@FindBy(xpath = "//div[3]//tr[@class='ant-table-row ant-table-row-level-0']/td[2]")
	public static List<WebElement> transferlistusernameRowCountrightside;
	public static String transferlistusernameRowCountrightsideBefore = "//div[3]//tr[@class='ant-table-row ant-table-row-level-0']/td[";
	public static String transferlistusernameRowCountrightsideAfter = "]";

	@FindBy(xpath = "//div[3]//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']/li[4]/button")
	public static WebElement transferlistNextPageBtnright;

	/**********************************************************************************************************
	 * USER PAGE WEBELEMENTS || @author Jathu Jana || Date : 13/07/2023
	 **********************************************************************************************************/
	// User Page - Search TextBox
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//input")
	public static WebElement SearchPopTextBox;

	// @sasi - 18.07.2023

	// Allocate More Option
	@FindBy(xpath = "//div[@class='ant-popover ant-popover-placement-top ']//div[@class='ant-popover-inner-content']")
	public static WebElement moremodalcontent;



/************************************************************************************************************************
* 	USER PAGE ADD USER RELATED WEBELEMENTS			||		 @author Jathu Jana		||  		Date : 17/07/2023 
*************************************************************************************************************************/
	//User Page - Add User Button
	@FindBy(xpath = "//div[@class='ant-table-title']/div/div/div[3]//button")
	public static WebElement addUserButton;
	
	//User Page - Add User PopUp Employee Check Box
	@FindBy(xpath = "//div[contains(@class,'ant-transfer')]/div[1]/div[1]/label/span/input")
	public static WebElement addUserPopLeftSideEmployeeBox;
	
	//User Page - Add User PopUp Employee Transfer Button
	@FindBy(xpath = "//div[@class='ant-transfer-operation']/button[1]")
	public static WebElement addUserPopEmployeeAllocationArrowButtonForRight;
		
	@FindBy(xpath = "//div[contains(@class,'sc-bxivhb')]//button")
	public static WebElement addUser;
	
	//User Page - Add User PopUp Left Search TextBox
	@FindBy(xpath = "//div[contains(@class,'ant-transfer-customize-list')]/div[1]//input[@placeholder='Search here']")
	public static WebElement leftSearch;

	//User Page - Add User PopUp Right Search TextBox
	@FindBy(xpath = "//div[contains(@class,'ant-transfer-customize-list')]/div[3]//input[@placeholder='Search here']")
	public static WebElement rightSearch;
	
	@FindBy(xpath = "//div[contains(@class,'ant-transfer-customize-list')]/div[2]/button[1]")
	public static WebElement goToRightBtn;
	
	@FindBy(xpath = "//div[contains(@class,'ant-transfer-customize-list')]/div[2]/button[1]/span")
	public static WebElement goToRight;

	//User Page - Add User PopUp User Select Check Box
	@FindBy(xpath = "//div[contains(@class,'ant-transfer')]/div[1]/div[2]//thead//label/span/input")
	public static WebElement addUserPopUpLeftSideUserSelectBox;
	
	@FindBy(xpath = "//div[contains(@class,'ant-transfer-customize-list')]/div[1]/div[1]//input//..")
	public static WebElement rightCheckBox;
	
	@FindBy(xpath = "//div[contains(@class,'ant-transfer-customize-list')]/div[1]/div[1]//input")
	public static WebElement rightCheckBoxInput;
	
	@FindBy(xpath = "//div[contains(@class,'ant-transfer-customize-list')]/div[1]//div[text()='No Data']")
	public static WebElement leftNodata;
	
	@FindBy(xpath = "(//thead)[2]//input//..")
	public static WebElement rightUserCheckBox;
	
	@FindBy(xpath = "(//thead)[2]//input")
	public static WebElement rightUserCheckBoxInput;
	
	@FindBy(id="role")
	public static WebElement role;
	@FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='ant-select-selector']")
	public static WebElement plantRoleEdit;
	
	@FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='ant-modal-footer']/button[2]")
	public static WebElement plantRoleEditok;
	
	//User Page - Any PopUp Model
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement popUpModel;
	
	//User Page - Any PopUp Model Save/Update/OK/Edit Button
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[1]")
	public static WebElement popUpModelFirstButton;
	
	//User Page - Any PopUp Model Close Button
	@FindBy(xpath = "//div[@class='ant-modal-title']/div/span")
	public static WebElement popUpModelCloseButton;
	@FindBy(xpath = "//button[@type='button']//span[text()='Save']")
	public static WebElement saveBtns;
	
	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	public static WebElement successMessage;
	
	@FindBy(xpath = "//div[contains(@class,'ant-transfer-customize-list')]/div[3]//div[text()='No Data']")
	public static WebElement rightNodata;
	
@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[3]")
public static WebElement validation;
}
