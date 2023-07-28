package com.qa.automation.qdms.pages.master;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlantEquipmentPage {

//===================================== SARANKA==========================================================

//**************************** MENUBAR X PATH **********************************************
	@FindBy(xpath = "(//a[@href='#/master/plantlevel'])[1]")
	public static WebElement Plant;

//******************************** PLANT BUTTON X_PATH **************************************
	@FindBy(xpath = "(//div[@class='sc-gzVnrw flBzTM'])[1]")
	public static WebElement PlantButton;

//************************************4 TH ROW *********************************************
	@FindBy(xpath = "(//tr[contains(@class,'ant-table-row ant-table-row-level-0')])[8]")
	public static WebElement Row8;

//*********************************** EDIT BUTTON 4 TH ROW *********************************
	@FindBy(xpath = "(//td[contains(@class,'ant-table-cell')])[36]")
	public static WebElement EditButton4THRow;

//******************************************TEXT FIELD PLANT *********************************
	@FindBy(xpath = "(//input[@id='plant_name'])[1]")
	public static WebElement TextFieldPlant;

//*********************************** UPDATE BUTTON *****************************************
	@FindBy(xpath = "(//button[@type='button'])[5]")
	public static WebElement UpdateButton;

//********************************* MENU BAR EQUIPMENT ***************************************
	@FindBy(xpath = "(//a[contains(@href,'#/master/equipmentlevel')])[1]")
	public static WebElement Equipment;

//************************************ PLANT EQUIPMENT ***************************************	
	@FindBy(xpath = "(//div[@class='sc-gzVnrw geeJmJ'])[1]")
	public static WebElement PlantEquipment;

//************************************ ADD PLANT EQUIPMENT BUTTON *****************************
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div[6]/div/button")
	public static WebElement AddPlantButtonEquipment;
	// button[@class='ant-btn sc-gZMcBi dMdnOw']

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div[4]/span/div/span/button")
	public static WebElement ImportButton;
//	

	@FindBy(xpath = "//a[@class='sc-bdVaJa ieeiNp'][@href='#/master/plantlevel']")
	public static WebElement masterBtn;

	@FindBy(xpath = "/html/body/div[1]/div/section/section/header/ul/li[2]/span/a")
	public static WebElement Equipmentmenu;

	@FindBy(xpath = "//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']/li/div")
	public static WebElement CurrentPaginationOpction;

	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	public static WebElement totalText;

	@FindBy(xpath = "//li[@title='1']/a")
	public static WebElement PageNumber;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> UnitColumn;
	@FindBy(xpath = "//li[@title='Next Page']/button")
	public static WebElement NextPageBtn;
	@FindBy(xpath = "//li[@title='Previous Page']/button")
	public static WebElement PreviousPageBtn;

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

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[1]")
	public static WebElement paginationCount;
	// ------------------------------------------------------------------------------------------------------------------------------------------------------
	// Vithusha Mohan
	// Multiple Search
	// ---------------------------------------------------------------------------------------------------------------------------------------------------
	// next button pagination
	@FindBy(xpath = "//li[@title='Next Page']//button")
	public static WebElement next;
	// PlantEquipment side button
	@FindBy(xpath = "//div[contains(text(),'Plant Equipment') and @class ='sc-dnqmqq bEdMec']")
	public static WebElement plantEquipSideButton;
	// PlantEquipment Plant search
	@FindBy(xpath = "//input[@placeholder='Plant' and @name='plantName']")
	public static WebElement plantsearch_input;

	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[2]")
	public static WebElement Updatebtn;

	@FindBy(xpath = "//div[normalize-space()='Brand Name allow only letters & Number']")
	public static WebElement Cancelbtn;

	// EquipmentType Search
	@FindBy(xpath = "//input[@id='equipmentType' and @type='search']")
	public static WebElement Equiptype_input;
	// Equipment Search
	@FindBy(xpath = "//input[@Placeholder='Equipment' and @name='equipmentName']")
	public static WebElement Equipsearch_input;
	// serialno Search
	@FindBy(xpath = "//input[@placeholder='Serial No' and @name='serialNo']")
	public static WebElement serialno_input;
	// brand Search
	@FindBy(xpath = "//input[@placeholder='Brand' and @name='brandName']")
	public static WebElement brand_input;

	@FindBy(xpath = "//*[@id=\"brand_name\"]")
	public static WebElement brandTextbox;
	// Model Search
	@FindBy(xpath = "//input[@placeholder='Model' and @name='modelName']")
	public static WebElement model_input;
	// Type Search
	@FindBy(xpath = "//input[@id='type' and @type='search']")
	public static WebElement type_input;
	@FindBy(xpath = "//input[@placeholder='formatNumber' and @name='formatNumber']")
	public static WebElement formatno_input;
	@FindBy(xpath = "//span[normalize-space()='Reset']")
	public static WebElement reset;
	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	// Vithusha Mohan
	// PlantEquipment AddFunctionality
	// ------------------------------------------------------------------------------------------------------------------------------------------------------

	@FindBy(xpath = "//div[@class='ant-table-title']/div/div/div/div[6]//button")
	public static WebElement AddPlantEquipment;

	@FindBy(xpath = "//input[@id='plant']")
	public static WebElement plant_INPUT;
	@FindBy(xpath = "//input[@id='calibrationExists']/..")
	public static WebElement clabration;
	@FindBy(xpath = "//input[@id='equipment']/..")
	public static WebElement Equipmentform;
	@FindBy(id = "serial_no")
	public static WebElement Serialno;
	@FindBy(id = "brand_name")
	public static WebElement BrandName;
	@FindBy(id = "model_name")
	public static WebElement Model;
	@FindBy(id = "equipmentISONo")
	public static WebElement FormatNo;
	@FindBy(id = "description")
	public static WebElement Description;
	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[2]")
	public static WebElement SaveButton;
	@FindBy(xpath = "//span[text()='OK']")
	public static WebElement OKButton;
	@FindBy(xpath = "//div[@class='ant-modal-content']//button[2]")
	public static WebElement Update;
	@FindBy(xpath = "//tr[2]/td[1]")
	public static WebElement firstcell;
	@FindBy(xpath = "//input[@id='equipmentType']/../..")
	public static WebElement Type;
	@FindBy(xpath = "//div[@class='ant-modal-body']/p")
	public static WebElement box;
	@FindBy(xpath = "//span[normalize-space()='Close']")
	public static WebElement closebutton;
	@FindBy(xpath = "//div[@name='plant']//div[@class='ant-select-selector']")
	public static WebElement plant;

	@FindBy(xpath = "//div[@name='equipment']//div[@class='ant-select-selector']")
	public static WebElement equipmentinput;

	// calibration
	@FindBy(xpath = "//input[@id='calibrationExists']")
	public static WebElement calibration;
	// Add Button Form Success Message
	@FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-success ant-notification-notice-closable']/div/div/div[1]")
	public static WebElement successmsg;

	@FindBy(xpath = "//div[normalize-space()='Brand Name allow only letters & Number']")
	public static WebElement validation;

	@FindBy(xpath = "(//button[@type='button'])[7]")
	public static WebElement savebtn;

	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement plantequipmentcancelbtn;
	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement cancelbtn;
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement firstrow;
	@FindBy(xpath = "//div[@name='plant']//div[@class='ant-select-selector']")
	public static WebElement plantdropdown;
	@FindBy(xpath = "//span[normalize-space()='test']")
	public static WebElement plantdropdownoption;
	@FindBy(xpath = "//div[@name='equipment']//div[@class='ant-select-selector']")
	public static WebElement equipmentdropdown;
	@FindBy(xpath = "//div[@class='ant-select-item ant-select-item-option ant-select-item-option-active']//div[@class='ant-select-item-option-content']")
	public static WebElement equipmentdropdownoption;
	@FindBy(xpath = "//input[@id='serial_no']")
	public static WebElement seriolnotextbox;

	// **************************plant
	// equipment************************************************
	@FindBy(xpath = "//a[@href='#/master/equipmentlevel']")
	public static WebElement equipment;

	@FindBy(xpath = "//div[contains(text(),'Plant Equipment')]")
	public static WebElement plantEquipment;

	@FindBy(xpath = "//th[2]//div[1]//span[2]//span[1]")
	public static WebElement plantequipmentsearch;

	@FindBy(xpath = "//input[@placeholder='Equipment']")
	public static WebElement equipmenttextbox;

	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div/button[1]")
	public static WebElement search;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/button[2]")
	public static WebElement resetall;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[4]")
	public static WebElement firstdata;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[2]")
	public static List<WebElement> equipmentcolumn;

	public static String equipmentColumnbefore = "//tbody[@class='ant-table-tbody']/tr[";

	public static String equipmentColumnAfter = "]/td[2]";

	// *******************plant equipment type**********

	@FindBy(xpath = "//th[3]//div[1]//span[2]//span[1]")
	public static WebElement plantequipmenttypesearch;

	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//div//div[@class='ant-select-selector']")
	public static WebElement equipmenttypetextbox;

	public static String testdatabefore = "//div[contains(text(),'";

	public static String testdataafter = "')]";

	@FindBy(xpath = "/html/body/div[9]/div/div/div/div/div[2]/button[1]")
	public static WebElement searchb;

	@FindBy(xpath = "/html/body/div[9]/div/div/div/div/div[2]/button[2]")
	public static WebElement resetallb;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[3]")
	public static List<WebElement> equipmenttypecolumnt;

	public static String equipmenttypeColumntbefore = "//tbody[@class='ant-table-tbody']/tr[";

	public static String equipmenttypeColumntAfter = "]/td[3]";
	// *******************************Serial No******************

	@FindBy(xpath = "//th[4]//div[1]//span[2]//span[1]")
	public static WebElement plantequipmentsosearch;

	@FindBy(xpath = "//input[@placeholder='Serial No']")
	public static WebElement equipmentsotextbox;

	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div/button[1]")
	public static WebElement searchso;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/button[2]")
	public static WebElement resetallso;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr/td[4]")
	public static List<WebElement> equipmentsocolumnt;
	public static String equipmentsoColumntbefore = "//*[@id=\\\"root\\\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr";

	public static String equipmentsoColumntAfter = "]/td[4]";

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[11]/span/a[1]/span")
	public static WebElement firstrowedit;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[1]/div/input")
	public static WebElement brandtextbox;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]")
	public static WebElement updatebtn;

	@FindBy(xpath = "//div[@name='equipment']")
	public static WebElement equipmentbox;

	@FindBy(xpath = "//div[@class='ant-modal-root']//div[@class='ant-row']//div[1]//div[1]//div[2]")
	public static WebElement plantvalidation;

	@FindBy(xpath = "(//div[normalize-space()=\"Equipment can't be empty\"])[1]")
	public static WebElement equipmentvalidation;

	@FindBy(xpath = "(//div[normalize-space()=\"Serial No can't be empty\"])[1]")
	public static WebElement serialnovalidation;

	@FindBy(xpath = "//div[@name='plant']")
	public static WebElement plantbox;

	// *******************brand************************

	@FindBy(xpath = "//th[5]//div[1]//span[2]//span[1]")
	public static WebElement plantequipmentbrsearch;

	@FindBy(xpath = "//input[@placeholder='Brand']")
	public static WebElement equipmentbrtextbox;

	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div/button[1]")
	public static WebElement searchbr;

	@FindBy(xpath = "//button[@type='button'][@class='ant-btn ant-btn-danger ant-btn-background-ghost']")
	public static WebElement resetallbr;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[5]")
	public static List<WebElement> equipmentbrcolumnt;

	public static String equipmentbrColumntbefore = "//tbody[@class='ant-table-tbody']/tr[";

	public static String equipmentbrColumntAfter = "]/td[5]";

	// *******************model************************

	@FindBy(xpath = "//th[6]//div[1]//span[2]//span[1]")
	public static WebElement plantequipmentmdsearch;

	@FindBy(xpath = "//input[@placeholder='Model']")
	public static WebElement equipmentmdtextbox;

	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div/button[1]")
	public static WebElement searchmd;

	@FindBy(xpath = "//button[@type='button'][@class='ant-btn ant-btn-danger ant-btn-background-ghost']")
	public static WebElement resetallmd;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr/td[6]")
	public static List<WebElement> equipmentmdcolumnt;

	public static String equipmentmdColumntbefore = "//*[@id=\\\"root\\\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr";

	public static String equipmentmdColumntAfter = "]/td[6]";

	@FindBy(xpath = "//th[1]//div[1]//span[2]")
	public static WebElement plantsearchicon;

	@FindBy(xpath = "//input[@placeholder='Plant']")
	public static WebElement plantsearchtextbox;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement plantsearchbtn;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement deleteokbtn;

	// Delete icon message
	@FindBy(xpath = "//div[@class=\"ant-notification ant-notification-topRight\"]")
	public static WebElement deletemsg;

	// Modyfiy by Quenthan 29/03/2023
	// Plant equipment Table
	@FindBy(xpath = "//*[@id='root']/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]")
	public static WebElement plantEquimentTable;

	// Edit Modal plant textbox
	@FindBy(id = "plant")
	public static WebElement plantTextBox;

	// edit Modal equipment text box
	@FindBy(id = "equipment")
	public static WebElement equipmentTextbox;

	// edit Modal serial no text box
	@FindBy(id = "serial_no")
	public static WebElement serialNoTextbox;

	// Plant reset button
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement resetbtn;

	// Plant Equipment Type Search Icon
	@FindBy(xpath = "(//span[@aria-label='search'])[3]")
	public static WebElement etypesearchicon;

	// Plant Equipment Type Text Box
	@FindBy(xpath = "//input[@id='equipmentType']")
	public static WebElement etypetextbox;

	// Plant Equipment Type Search Icon
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement etypesearchbtn;
	// plant Eqipment Serialno SEARCH ICON
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[4]/div/span[2]/span")
	public static WebElement searchserialno;

	// edit Modal serial no text box
	@FindBy(xpath = "//input[@placeholder='Serial No']")
	public static WebElement SerialNoTextbox;

	// brand search popup textbox
	@FindBy(xpath = "//input[@placeholder='Brand']")
	public static WebElement Brandtextbox;

	// Relevant Calibration
	@FindBy(xpath = "//input[@id='calibrationExists']/../span")
	public static WebElement relcal;
	// format number
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[9]/div/span[2]")
	public static WebElement formatsearch;
//format number 
	@FindBy(xpath = "//input[@placeholder='formatNumber']")
	public static WebElement Formatextbox;

	// description textbox props
	@FindBy(xpath = "//div[@class='ant-modal']")
	public static WebElement destextbox;

	// model text box
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/input")
	public static WebElement modeltextbox;

	// search open dropdown
	@FindBy(xpath = "//th[3]//div[1]//span[2]")
	public static WebElement searchopendrop;

	// search open dropdown
	@FindBy(xpath = "//input[@id='equipmentType']")
	public static WebElement clickdrop;

	// Type search open dropdown
	@FindBy(xpath = "//input[@id='type']")
	public static WebElement typeclickdrop;
	// type search click
	@FindBy(xpath = "//th[8]//div[1]//span[2]")
	public static WebElement typesrchclick;

	// ADD PLANT EQUIPMENT BUTTON PLANT DROPDOWN click
	@FindBy(xpath = "//input[@id='plant']")
	public static WebElement addplaequipplantdrop;

	// ADD PLANT EQUIPMENT BUTTON Equipment DROPDOWN click
	@FindBy(xpath = "//input[@id='equipment']")
	public static WebElement addplaequipequipdrop;

	// ADD PLANT EQUIPMENT BUTTON Equipment DROPDOWN click
	@FindBy(xpath = "//span[@title='DEFAULT']")
	public static WebElement addplaequiptypedrop;

	@FindBy(xpath = "(//button[@class='ant-pagination-item-link'])[2]")
	public static WebElement nextbuttonsub;

	@FindBy(xpath = "//span[@title='10 / page']")
	public static WebElement PageDropdown;

	public static String bef = "(//div[@class= 'ant-select-item-option-content'])[";
	public static String aft = "]";

	/************************************************************************************************************
	 * PLANT EQUIPMENT PAGE WEBELEMENTS || @author Jathu Jana || Date : 17/07/2023
	 *************************************************************************************************************/
	// Plant Equipment Page - Search TextBox
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//input")
	public static WebElement SearchPopTextBox;

	/// PRIYANKA SUNDARAMOORTHY

	@FindBy(xpath = "//input[@name='brandName']")
	public static WebElement SearchBoxBrand;

	@FindBy(xpath = "//input[@name='equipmentName']")
	public static WebElement SearchBoxEquipment;

	@FindBy(xpath = "//input[@name='modelName']")
	public static WebElement SearchBoxModal;

	@FindBy(xpath = "//input[@name='serialNo']")
	public static WebElement SearchBoxSerialNo;

	@FindBy(xpath = "//input[@name='formatNumber']")
	public static WebElement SearchBoxFormatNo;

	@FindBy(xpath = "//input[@name='plantName']")
	public static WebElement SearchBoxPlant;
	
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement equipmentTable;
	
	@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[1]")
	public static WebElement deleteCancelButton;
	
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement deletePopUP;


	@FindBy(xpath = "//div[@class = 'ant-modal-content']")
	public static WebElement editpopup;

	@FindBy(xpath = "//div[@id='rcDialogTitle0']//span")
	public static WebElement closebut;
	
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement Table;
	
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement editPopUP;
	
	@FindBy(xpath = "//button//span[text()='Close']")
	public static WebElement descCloseBtn;
	
	@FindBy(xpath = "//span[@class='ant-modal-close-x']/span")
	public static WebElement descCloseIcon;

}
