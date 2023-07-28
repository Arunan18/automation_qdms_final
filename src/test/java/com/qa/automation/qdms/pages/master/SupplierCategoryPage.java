package com.qa.automation.qdms.pages.master;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SupplierCategoryPage {
	@FindBy(xpath = "//a[@href='#/master/supplierlevel']")
	public static WebElement clickSupplier;
	@FindBy(xpath = "//div[contains(@class,'sc-htoDjs')]/div[2]")
	public static WebElement clickSupplierCategory;
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul")
	public static WebElement pagination;

	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	public static WebElement totalText;

	@FindBy(xpath = "//a[normalize-space()='1']")
	public static WebElement PageNumber;

	@FindBy(xpath = "//span[@aria-label='close-circle']//*[name()='svg']")
	public static WebElement closeBtn;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[6]/div")
	public static WebElement CurrentPaginationOpction;
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[5]/div/div[1]/span[1]")
	public static WebElement CurrentPaginationOpction20;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> UnitColumn;

	@FindBy(xpath = "//div[@title='20 / page']")
	public static WebElement when20usernamecolumn;

	@FindBy(xpath = "//div[contains(text(),'30 / page')]")
	public static WebElement when30usernamecolumn;

	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']/div[2]/div[1]")
	public static WebElement Page_20;

	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']/div[3]/div[1]")
	public static WebElement Page_30;

	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']/div[4]/div[1]")
	public static WebElement Page_100;
	@FindBy(xpath = "//div[@class='ant-select-selector']")
	public static WebElement Paginationdropdown;

	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	public static WebElement paginationCount;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[6]/div/div[1]/span[1]")
	public static WebElement page10;
	// span[@aria-label='search']
	@FindBy(xpath = "//span[@role='button']")
	public static WebElement searchIcon;

	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']")
	public static WebElement searchmodal;

	@FindBy(xpath = "//div[@class='sc-gzVnrw flBzTM']")
	public static WebElement suppliercategory;

	@FindBy(xpath = "//input[@placeholder=' Supplier Category']")
	public static WebElement searchbox;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement searchbutton;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement resetButton;

	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement cancelbutton;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[1]")
	public static WebElement cancelbuttonedit;

	@FindBy(xpath = "//input[@id='supplier_category']")
	public static WebElement supplierCategorytextBox;

	@FindBy(xpath = "//div[@class='ant-modal-content']//button[2]")
	public static WebElement UpdateButton;

	@FindBy(xpath = "//tbody/tr[2]/td[3]/span[1]/a[1]/span[1]")
	public static WebElement tableFirstRow;

	@FindBy(xpath = "//td[normalize-space()='kGHT']")
	public static WebElement tableFirstRownew;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[2]")
	public static WebElement okButton;

	@FindBy(xpath = "//body[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[2]")
	public static WebElement okButtonnew;

	@FindBy(xpath = "(//li[contains(@class, 'ant-pagination-item') and not(contains(@class, 'ant-pagination-item-74'))])[last()]")
	public static WebElement lastPage;

	@FindBy(xpath = "//div[contains(@class,'sc-bxivhb')]//button")
	public static WebElement addSuppilerCategotyButton;

	@FindBy(xpath = "//textarea[@id='supplierCategory_description']")
	public static WebElement description;

	@FindBy(xpath = "//div[@class='ant-modal-content']//button[2]")
	public static WebElement saveButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public static WebElement saveButtonnew;

	// span[normalize-space()='Save']

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[1]")
	public static WebElement validation;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr[2]/td[1]")
	public static WebElement firstSupplierCategory;

	@FindBy(xpath = "//tbody/tr[6]/td[6]/span[1]/span[1]")
	public static WebElement popup;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/div[1]")
	public static WebElement headding;

	@FindBy(xpath = "(//div[@role='tooltip'])")
	public static WebElement popupwindow;

	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement supplierCategoryModal;

	@FindBy(xpath = "//*[@id=\"rcDialogTitle0\"]/div/p")
	public static WebElement popupHeading;
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement popUp;

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

	@FindBy(xpath = "//input[@id='supplier_category']/..//div[1]")
	public static WebElement supplierCategoryValidation;

	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	public static WebElement successMessages;

	@FindBy(xpath = "//tr[2]/td[1]")
	public static WebElement firstRowData;

	@FindBy(xpath = "//span[contains(@class,'ant-notification-close-icon')]")
	public static WebElement successMessageCloseBtn;

	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement deletePopUP;

	@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[1]")
	public static WebElement deleteCancelButton;

	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement supplierCatTable;
	@FindBy(xpath = "//div[@class = 'ant-modal-content']")
	public static WebElement editpopup;

	@FindBy(xpath = "//div[@id='rcDialogTitle0']//span")
	public static WebElement closebutton;

}
