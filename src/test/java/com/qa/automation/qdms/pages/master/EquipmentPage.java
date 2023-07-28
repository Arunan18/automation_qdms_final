//***********************************************************************************
//* Description
//*------------
//* EQUIPMENT PAGE
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 01/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        01/03/2023   WATHI     Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.pages.master;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EquipmentPage {

	// xpath of Equipment in NavBar
	@FindBy(xpath = "//a[@href='#/master/equipmentlevel']")
	public static WebElement Equipment;
	// xpath of side Navbar
	@FindBy(xpath = "//main/div/div/div[1]/div/div[1]")
	public static WebElement SideEquipment;
	// xpath of Equipment Search
	@FindBy(xpath = "//input[@placeholder=' Equipment']")
	public static WebElement EquipSearch;
	// xpath of Equipmentlist
	@FindBy(xpath = "//tr[contains(@class,'ant-table-row')]/child::td[1]")
	public static WebElement EquipmentList;
	@FindBy(xpath = "//input[@id='equipmentType' and @type='search']")
	public static WebElement searchequtype;
	@FindBy(xpath = "//button/span[text()='Add Equipment']")
	public static WebElement AddequButton;
	@FindBy(xpath = "//input[@id='equipment_name' and @name='equipment_name']")
	public static WebElement Equipmenttextbox;
	// xpath for equipmenttype textbox
	@FindBy(xpath = "//input[@id='type']")
	public static WebElement EquipmentTypeTextbox;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[1]/div/div[1]")
	public static WebElement Validation;
	@FindBy(xpath = "//input[@id='type' and @type='search']")
	public static WebElement EquipmentType;
	@FindBy(xpath = "//textarea[@id='equipment_description' and @name='equipment_description']")
	public static WebElement equipmentdes;
	@FindBy(xpath = "//span[text()='Save']")
	public static WebElement equSave;
	@FindBy(xpath = "//tr[2]/td[1]")
	public static WebElement equipdata;
	@FindBy(xpath = "//tr[2]/td[2]")
	public static WebElement descriptiondata;
	@FindBy(xpath = "//tr[2]/td[3]")
	public static WebElement typedata;
	@FindBy(xpath = "//span[normalize-space()='Reset All']")
	public static WebElement resetbutton;
	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	public static WebElement addsuccessmessage;

	@FindBy(xpath = "//li[@title='Next Page']/button")
	public static WebElement NextPageBtn;
	@FindBy(xpath = "//li[@title='Previous Page']/button")
	public static WebElement PreviousPageBtn;

	// pagination equipments

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[3]")
	public static WebElement DefaultPaginationPageeq;

	@FindBy(xpath = "//li[@class='ant-pagination-next']")
	public static WebElement NextPageBtnEq;
	//

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[4]")
	public static WebElement PaginationSecoundPageEq;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]")
	public static WebElement totalTextSecondPageEq;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr/td[1]")
	public static List<WebElement> totalrowsEq;

	@FindBy(xpath = "//div[@class='ant-select-selector']")
	public static WebElement CurrentPaginationOpctionEq;

	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']/div[2]/div[1]")
	public static WebElement Page_20Eq;

	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']/div[3]/div")
	public static WebElement Page_30Eq;

	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']/div[4]/div[1]")
	public static WebElement Page_100Eq;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr/td[1]")
	public static List<WebElement> when20equipmentnamecolumn;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement firstuserValue;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr[1]/td[2]")
	public static WebElement firstuserValueintransferlist;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr/td[1]")
	public static List<WebElement> when30equipmentnamecolumn;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr/td[1]")
	public static List<WebElement> when20equipmentnamecolumnEq;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr/td[1]")
	public static List<WebElement> when100equipmentnamecolumnEq;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> UserColumn;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[2]")
	public static WebElement equipmenttab;

	@FindBy(xpath = "//input[@id='equipment_name']/../div[1]")
	public static WebElement equipment;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement deleteconfirmationOKbutton;

	@FindBy(xpath = "//td[@class='ant-table-cell']")
	public static List<WebElement> numberofequcolumn;

	@FindBy(xpath = "\"//*[@id=\\\"root\\\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[\"+ j + \"]/td[1]\"")
	public static List<WebElement> Equname;

	// validation testing

	@FindBy(xpath = "//input[@id='equipment_name']")
	public static WebElement equipmenttextbox;

	@FindBy(xpath = "//input[@id='type']/../..")
	public static WebElement equipmenttypetextbox;

	@FindBy(xpath = "//textarea[@id='equipment_description']")
	public static WebElement descriptiontextbox;

	@FindBy(xpath = "//button[@type='button'][2]")
	public static WebElement equipmentsavebutton;

	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[1]")
	public static WebElement equipmentCancelbutton;

	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[1]/div/div/div[2]")
	public static WebElement equipmentvalidation;

	@FindBy(xpath = "//input[@id='equipment_name']/../div[1]")
	public static WebElement equipmenttypevalidation;

	@FindBy(xpath = "//div[@class='ant-table-title']//button")
	public static WebElement addequipmentbutton;

	@FindBy(xpath = "//input[@id='equipmentType']")
	public static WebElement equipmentType;
	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	public static WebElement deleteequipment;
	// equipment search

	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[1]/div/span[2]")
	public static WebElement equipmentsearch;

	@FindBy(xpath = "//input[@name='name']")
	public static WebElement equipmentsearchplaceholder;

	@FindBy(xpath = "//input[@name='name']/..//button[1]")
	public static WebElement equipmentsearchpopupsearchbutton;

	@FindBy(xpath = "//input[@name='name']/..//button[2]")
	public static WebElement reset1button;

	// equipment Serial No
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[4]/div/span[2]")
	public static WebElement serialnoicon;

	@FindBy(xpath = "//input[@placeholder='Serial No']")
	public static WebElement serialplaceholder;

	@FindBy(xpath = "//tbody[@class=\"ant-table-tbody\"]")
	public static WebElement firstaddeddata;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/button[2]")
	public static WebElement reset;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement equipmenttyperesetbtn;

	@FindBy(xpath = "//div[@class='sc-gzVnrw flBzTM']")
	public static WebElement equipmentnavigation;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[1]/span")
	public static WebElement equipmentDropDownButton;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/button[1]")
	public static WebElement searchButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]")
	public static WebElement equipmentmulti;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[2]/div[1]")
	public static WebElement planteequipment;

	@FindBy(xpath = "//input[@placeholder=\"Plant\"]")
	public static WebElement planteequipmentsearch;

	@FindBy(xpath = "/html/body/div[3]/div/div/div")
	public static WebElement cannotdeletevalidationmessage;

	// PlantEquipment Edit
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[1]/div[1]/div/div/div")
	public static WebElement plantdropdown;

	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[1]/div[2]/div/div/div")
	public static WebElement plantequipment;

	@FindBy(xpath = "//*[@id=\"serial_no\"]")
	public static WebElement serialno;

	@FindBy(xpath = "//*[@id=\"model_name\"]")
	public static WebElement model;

	@FindBy(xpath = "//*[@id=\"brand_name\"]")
	public static WebElement brand;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[3]/div[1]/div/div")
	public static WebElement type;

	@FindBy(xpath = "//*[@id=\"equipmentISONo\"]")
	public static WebElement formatno;

	@FindBy(xpath = "//*[@id=\"description\"]")
	public static WebElement descrioption;

	@FindBy(xpath = "//body//div//button[2]")
	public static WebElement updatebtn;

	// Add Button Form Success Message
	@FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-success ant-notification-notice-closable']/div/div/div[1]")
	public static WebElement successmsg;

	@FindBy(xpath = "//th[3]//div[1]//span[2]//span[1]")
	public static WebElement equipmenttypesearch;

	@FindBy(xpath = "//input[@id='equipmentType']")
	public static WebElement equipmenttypesearchtextbox;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div/div/div[1]/div")
	public static WebElement equipmenttypedropdownbox;

	@FindBy(xpath = "(//span[@role='button'])[2]")
	public static WebElement equipmenttypeicon;

	@FindBy(xpath = "//input[@id='equipmentType']")
	public static WebElement equipmenttypetxtbox;

	@FindBy(xpath = "//div[@title='Test Equipment']")
	public static WebElement equipmentclick;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[2]/span")
	public static WebElement equipmentdeleteconfirmationokbutton;

	@FindBy(xpath = "//a[normalize-space()='1']")
	public static WebElement DefaultPaginationPage;
	@FindBy(xpath = "//a[normalize-space()='2']")
	public static WebElement PaginationSecoundPage;

	@FindBy(xpath = "//span[@title='10 / page']")
	public static WebElement PageDropdown;

	public static String bef = "(//div[@class= 'ant-select-item-option-content'])[";
	public static String aft = "]";

	@FindBy(xpath = "//div[@class='ant-table-container']")
	public static WebElement table;

	@FindBy(xpath = "//input[@name='name']")
	public static WebElement equipmentSearchBox;
	@FindBy(xpath = "//input[@id='equipmentType']")
	public static WebElement equipmentTypeSearchBox;

	/************************************************************************************************************
	 * EQUIPMENT PAGE WEBELEMENTS || @author Jathu Jana || Date : 13/07/2023
	 *************************************************************************************************************/
	// Equipment Page - Search TextBox
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//input")
	public static WebElement SearchPopTextBox;
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//input")
	public static WebElement SearchBoxEquipment;

	@FindBy(xpath = "//div[@class = 'ant-modal-content']")
	public static WebElement editpopup;

	@FindBy(xpath = "//div[@id='rcDialogTitle0']//span")
	public static WebElement closebutton;
		
		
		
		@FindBy(xpath = "//div[@class='ant-spin-container']")
		public static WebElement equipmentTable;
		
		@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[1]")
		public static WebElement deleteCancelButton;
		
		@FindBy(xpath = "//div[@class='ant-popover-content']")
		public static WebElement deletePopUP;

}
