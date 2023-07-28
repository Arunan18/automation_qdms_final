package com.qa.automation.qdms.pages.master;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UnitPage {

	@FindBy(xpath = "//a[@class='sc-bdVaJa ieeiNp'][@href='#/master/materiallevel']")
	public static WebElement MaterialSub;
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
	@FindBy(xpath = "//span[@aria-label='left']//*[name()='svg']")
	public static WebElement PreviousPageBtn;

	@FindBy(xpath = "//a[normalize-space()='1']")
	public static WebElement DefaultPaginationPage;
	@FindBy(xpath = "//a[normalize-space()='2']")
	public static WebElement PaginationSecoundPage;

	// Pagination Dropdown
	@FindBy(xpath = "//span[@title='10 / page']")
	public static WebElement PageDropdown;
	// Pages
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

	@FindBy(id = "unit_name")
	public static WebElement UnitTextbox;

	@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']")
	public static WebElement AddUnitButton;

	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[2]")
	public static WebElement UnitSaveButton;

	@FindBy(xpath = "//div[@class='ant-modal-body']/form/div/div[1]/div/div[1]")

	public static WebElement validationmsg;

	@FindBy(xpath = "//tr[2]/td[1]")

	public static WebElement tableRow;

	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[1]")
	public static WebElement CancelBtn;

	@FindBy(xpath = "//button[contains(@class,'ant-btn-primary')]")
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

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement tableFirstRow;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[3]/span/a")
	public static WebElement materialTab;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[6]")
	public static WebElement UnitLeftButton;

	@FindBy(xpath = "//input[@placeholder=' Unit']")
	public static WebElement SearchBox;

//	MODIFIED BY : ARUNAN 13.03.2023
	public static String DeleteBtnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String DeleteBtnAfter = "]/td[2]/span/a[2]";
	@FindBy(xpath = "//div[@class='ant-popover ant-popconfirm ant-popover-placement-top ']/div/div[2]/div/div[2]/button[2]")
	public static WebElement deleteOkBtn;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/button[2]")
	public static WebElement UnitSearchResetBut;
	@FindBy(xpath = "//span[@role='button']")
	public static WebElement UnitSearchIcon;

	@FindBy(xpath = "//*[@id=\"rcDialogTitle0\"]/div/span")
	public static WebElement UnitCloseButton;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[1]")
	public static WebElement UnitCancleButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[2]/span/a[2]/a/span")
	public static WebElement UnitDeleteIconButton;

	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	public static WebElement successMessages;

	@FindBy(xpath = "//span[@class='anticon anticon-close ant-notification-close-icon']")
	public static WebElement successMessageCloseBtn;

	@FindBy(xpath = "//tr[2]/td[1]")
	public static WebElement firstRowData;

	public static String bef = "(//div[@class= 'ant-select-item-option-content'])[";
	public static String aft = "]";

	/**********************************************************************************************************
	 * UNIT PAGE WEBELEMENTS || @author Jathu Jana || Date : 13/07/2023
	 **********************************************************************************************************/
	// Unit Page - Search TextBox
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//input")
	public static WebElement SearchPopTextBox;
	
	//Priyanka 26.07.2023

	@FindBy(xpath = "//div[@class = 'ant-modal-content']")
	public static WebElement editpopup;

  @FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement deletePopUP;
	
	@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[1]")
	public static WebElement deleteCancelButton;
	
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement unitTable;


}
