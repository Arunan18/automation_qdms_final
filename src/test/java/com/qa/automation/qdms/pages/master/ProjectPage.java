package com.qa.automation.qdms.pages.master;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage {

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[1]/div/div/div[4]/span/div/span/button")
	public static WebElement ImportButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[1]/div/div/div[5]/button")
	public static WebElement ExportButton;

	@FindBy(xpath = "//a[@class='sc-bdVaJa ieeiNp'][@href='#/master/plantlevel']")
	public static WebElement masterBtn;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[4]")
	public static WebElement customerheader;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[2]")
	public static WebElement projectbutton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[4]/span")
	public static WebElement CustomermenuBtn;

	@FindBy(xpath = "//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']/li/div")
	public static WebElement CurrentPaginationOpction;

	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	public static WebElement totalText;

	@FindBy(xpath = "//li[@title='1']/a")
	public static WebElement PageNumber;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> projectColumn;

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
	@FindBy(xpath = "//span[@title='10 / page']")
	public static WebElement PageDropdown;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[1]")
	public static WebElement paginationcount;

	// Project Multi Search XPath
	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div/div/div/input")
	public static WebElement SearchTextBox;

	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div[2]/div/button[1]")
	public static WebElement SearchBtn;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[2]/div[1]/button")
	public static WebElement SearchBtnnew;

	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[1]/div/span[2]")
	public static WebElement CodeSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[2]/div/span[2]")
	public static WebElement PlantSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[3]/div/span[2]")
	public static WebElement ProjectSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[4]/div/span[2]")
	public static WebElement CustomerSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[5]/div/span[2]")
	public static WebElement ContactPersonSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[6]/div/span[2]")
	public static WebElement ContactNoSearch;
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[7]/div/span[2]")
	public static WebElement DateSearch;

	@FindBy(xpath = "//button[@type='button'][@class='ant-btn ant-btn-danger ant-btn-background-ghost']")
	public static WebElement ResetAll;
	@FindBy(xpath = "//input[@name='plantName']")
	public static WebElement SearchBox;
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[1]/div[1]/div[1]/input")
	public static WebElement SearchBoxplaceholder;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[2]/div/span[2]")
	public static WebElement Searchicon;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> CodeColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[2]")
	public static List<WebElement> PlantColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[3]")
	public static List<WebElement> ProjectColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[4]")
	public static List<WebElement> CustomerColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[5]")
	public static List<WebElement> ContactPersonColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[6]")
	public static List<WebElement> ContactNoColumn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[7]")
	public static List<WebElement> DateColumn;

	public static String CodeColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String CodeColumnAfter = "]/td[1]";
	public static String PlantColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String PlantColumnAfter = "]/td[2]";
	public static String ProjectColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String ProjectColumnAfter = "]/td[3]";
	public static String CustomerColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String CustomerColumnAfter = "]/td[4]";
	public static String ContactPersonColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String ContactPersonColumnAfter = "]/td[5]";
	public static String ContactNoColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String ContactNoColumnAfter = "]/td[6]";
	public static String DateColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String DateColumnAfter = "]/td[7]";

	// Next and Previous Button xpath
	@FindBy(xpath = "//li[@title='Next Page']/button")
	public static WebElement NextPageBtn;
	@FindBy(xpath = "//li[@title='Previous Page']/button")
	public static WebElement PreviousPageBtn;
	@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']")
	public static WebElement projectaddbtn;
	@FindBy(xpath = "//div[@name='plant']//div[@class='ant-select-selector']")
	public static WebElement enterplant;
	@FindBy(xpath = "//*[@id=\"plant\"]")
	public static WebElement planttextenter;
	@FindBy(xpath = "/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div/div")
	public static WebElement dropdownfield;
	@FindBy(xpath = "//*[@id=\"project_name\"]")
	public static WebElement projectname;
	@FindBy(xpath = "//div[@name='customer']//div[@class='ant-select-selector']")
	public static WebElement customername;
	@FindBy(xpath = "//*[@id='customer']")
	public static WebElement customertextenter;
	@FindBy(xpath = "/html/body/div[5]/div/div/div/div[2]/div[1]/div/div/div[1]/div")
	public static WebElement customernamedropdown;
	@FindBy(xpath = "//*[@id=\"contact_person\"]")
	public static WebElement contactperson;
	@FindBy(xpath = "//*[@id=\"contact_no\"]")
	public static WebElement contactno;
	@FindBy(xpath = "//*[@id='start_date']")
	public static WebElement startdate;
	@FindBy(xpath = "//td[contains(@class,'ant-picker-cell-selected')]")
	public static WebElement startdateselection;
	@FindBy(xpath = "//div[@class='ant-modal-content']//button[2]")
	public static WebElement projectsavebutton;
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/div[1]")
	public static WebElement projecraddsucessmsg;
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement ProjectTablename;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement projectdeleteok;
	@FindBy(xpath = " //input[@placeholder=' Code']")
	public static WebElement projectsearchtextbox;
	@FindBy(xpath = " //div[@class='sc-gzVnrw flBzTM']")
	public static WebElement projectleftbutton;
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[4]/span/a")
	public static WebElement customerTopTab;
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[9]")
	public static WebElement paginationlastpage;
	@FindBy(xpath = "//li[@class = 'ant-pagination-total-text']")
	public static WebElement projectpaginationcount;
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[9]/span/a[1]/span")
	public static WebElement tableFirstRow;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[2]/div/div[1]")
	public static WebElement validationmsg;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[2]/div/div[1]")
	public static WebElement editvalidationmsg;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[2]/div/div[1]")
	public static WebElement contatpersonvalidationmsg;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[2]/div/div[1]")
	public static WebElement contatpersoneditvalidationmsg;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[3]/div[1]/div/div[1]")
	public static WebElement contatnovalidationmsg;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[3]/div[1]/div/div[1]")
	public static WebElement contatnoeditvalidationmsg;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[1]")
	public static WebElement CancelBtn;
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[2]")
	public static WebElement projectupdatebutton;
	@FindBy(id = "plant")
	public static WebElement planttextbox;
	@FindBy(xpath = "//*[@id=\"project_name\"]")
	public static WebElement projecttextbox;
	@FindBy(id = "customer")
	public static WebElement customertextbox;
	@FindBy(xpath = "//*[@id=\"contact_person\"]")
	public static WebElement contactPersontextbox;
	@FindBy(xpath = "//*[@id=\"contact_no\"]")
	public static WebElement contactnotextbox;
	@FindBy(xpath = "//*[@id=\"start_date\"]")
	public static WebElement startdatetextbox;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[2]")
	public static WebElement projectleftmenubutton;

	// after depend delete
	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	public static WebElement dataCount;
	@FindBy(xpath = "//div[@class = 'ant-popover-buttons']//button[2]")
	public static WebElement deleteOkButton;
	@FindBy(xpath = "(//span[@aria-label='search'])[1]")
	public static WebElement codeSearchButton;

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[1]/div[1]/div[1]/input")
	public static WebElement codeSearchTextBox;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[2]/div[1]/button")
	public static WebElement searchButton;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[2]/div[1]/button")
	public static WebElement plantSearchResetBut;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[2]/div[1]/button")
	public static WebElement projectnameSearchResetBut;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[3]/div/span[2]/span")
	public static WebElement projectnamesearchiconbutton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[2]/div/span[2]/span")
	public static WebElement plantsearchiconbutton;

	@FindBy(xpath = "//*[@id=\"rcDialogTitle0\"]/div/span")
	public static WebElement ProjectCloseButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[9]/span/a[2]/a/span")
	public static WebElement projectdeleteicon;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/div/div[2]")
	public static WebElement projectcancelbutton;

	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	public static WebElement successMessages;

	@FindBy(xpath = "//tr[2]/td[1]")
	public static WebElement firstRowData;

	@FindBy(xpath = "//span[@class='anticon anticon-close ant-notification-close-icon']")
	public static WebElement successMessageCloseBtn;

	@FindBy(xpath = "//span[@class='anticon anticon-close ant-notification-close-icon']")
	public static WebElement plantValidation;

	@FindBy(xpath = "//input[@id='project_name']//..//div[1]")
	public static WebElement projectvalidation;

	@FindBy(xpath = "//input[@id='customer']//ancestor::div[@class='input_wrapper']//div[2]")
	public static WebElement customerValidation;

	@FindBy(xpath = "//input[@id='contact_person']/..//div[1]")
	public static WebElement contactpersonValidation;

	@FindBy(xpath = "//input[@id='contact_no']/..//div[1]")
	public static WebElement contactnoValidation;

	@FindBy(xpath = "//input[@id='start_date']//ancestor::div[@class='input_wrapper']//div[2]")
	public static WebElement startdateValidation;

	public static String bef = "(//div[@class= 'ant-select-item-option-content'])[";
	public static String aft = "]";

	@FindBy(xpath = "//input[@name='name']")
	public static WebElement SearchBoxProject;

	@FindBy(xpath = "//input[@name='customerName']")
	public static WebElement SearchBoxCustomer;

	@FindBy(xpath = "//input[@name='contactPerson']")
	public static WebElement SearchBoxContactPerson;

	@FindBy(xpath = "//input[@name='contactNumber']")
	public static WebElement SearchBoxContactNo;

	@FindBy(xpath = "//input[@name='startDate']")
	public static WebElement SearchBoxStartdate;

	@FindBy(xpath = "//div[@class = 'ant-modal-content']")
	public static WebElement editModal;

	@FindBy(xpath = "//span[@class='ant-btn-loading-icon']")
	public static WebElement loadingUpdate;

	@FindBy(xpath = "//div[@class = 'ant-modal-content']")
	public static WebElement editpopup;

	@FindBy(xpath = "//div[@id='rcDialogTitle0']//span")
	public static WebElement closebutton;

}
