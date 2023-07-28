package com.qa.automation.qdms.sample.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.automation.qdms.base.DriverIntialization;

public class ProductionSamplePage extends DriverIntialization {

	@FindBy(xpath = "//a[@class='sc-bdVaJa ieeiNp'][@href='#/samples']")
	public static WebElement samplexpath;

	// * Sample Page Home Icon Text
	@FindBy(xpath = "//div[normalize-space()='SAMPLES']")
	public static WebElement sampletext;

	// * Top Navigation Finish Product Sample
	@FindBy(xpath = "//header[@class='ant-layout-header']//li[2]")
	public static WebElement topnavfinishproduct;

	// * Top Navigation Finish Product Sample Text
	@FindBy(xpath = "//a[@href='#/finshproductsamples']")
	public static WebElement topnavfinishproducttext;

	// * Plant-Lab Trial Sample Window Heading
	@FindBy(xpath = "//div[@class='ant-typography'][normalize-space()='Plant-Lab Trial Sample']")
	public static WebElement plantlabwindowheadding;

	// * Production Sample Window Heading
	@FindBy(xpath = "//div[@class='ant-typography'][normalize-space()='Production Sample']")
	public static WebElement productionwindowheadding;

	// * Production Sample Left Nevigation
	@FindBy(xpath = "//div[@class='sc-dnqmqq bxMwVY'][normalize-space()='Production Sample']")
	public static WebElement productionsampleLeftNav;

	// * Add Production Sample Add Button Xpath
	@FindBy(xpath = "//div[@class='ant-col ant-col-2']/div/button[@class='ant-btn sc-gZMcBi dMdnOw']")
	public static WebElement addproductionsample;

	// * Add Production Form Heading
	@FindBy(xpath = "//div[@class='sc-VigVT jzVhIp']/p")
	public static WebElement addproductionheading;

	/* Add Production Sample Form xpath */

	// * Single Radio Button Field
	@FindBy(xpath = "//*[@id='addType']/label[1]")
	public static WebElement singleradiobtn;

	// * Plant Field
	@FindBy(xpath = "//*[@id='plantName']")
	public static WebElement plant;

	// * Finish Product Field
	@FindBy(xpath = "//input[@id='rawMaterialId']")
	public static WebElement finishproduct;

	// * Mix Design Field
	@FindBy(xpath = "//div[@name='mixDesignCode']")
	public static WebElement mixdesign;

	// * Equipment Field
	@FindBy(xpath = "//*[@id='equipmentId']")
	public static WebElement equipment;

	// * Sample Code Field
	@FindBy(xpath = "//*[@id='finishProductCode']")
	public static WebElement samplecode;

	// * Sample Date Field
	@FindBy(xpath = "//*[@id='date']")
	public static WebElement sampledate;

	// * Customer Field
	@FindBy(xpath = "//*[@id='customer']")
	public static WebElement customer;

	// * Project Field
	@FindBy(xpath = "//div[@name='projectId']")
	public static WebElement project;

	// * Work Order Field
	@FindBy(xpath = "//*[@id='workOrderNo']")
	public static WebElement workorder;

	// * Creation Date Field
	@FindBy(xpath = "//*[@id='creationDate']")
	public static WebElement creationdate;

	// * Production Date Field
	@FindBy(xpath = "//*[@id='arrivalDate']")
	public static WebElement productiondate;

	// * Delivery Field
	@FindBy(xpath = "//div[contains(@name,'pourName')]//div[contains(@class,'ant-select-selector')]")
	public static WebElement delivery;

	// * Vehicle No Field
	@FindBy(xpath = "//*[@id='vehicleNo']")
	public static WebElement vehicleno;

	// * Vehicle No Field
	@FindBy(xpath = "//*[@name='sampledTime']")
	public static WebElement sampletime;

	// * Commodity Field
	@FindBy(xpath = "//*[@id='commodity']")
	public static WebElement commodity;

	// * Save Button
	@FindBy(xpath = "//button[contains(@formaction,'test')]")
	public static WebElement save;

	// * Cancel Button
	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement cancelbtn;

	// * Success Message
	@FindBy(xpath = "//div[contains(@class,'ant-notification ant-notification-topRight')]//div")
	public static WebElement successMsg;

	// * First Data Of the Table
	@FindBy(xpath = "//body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[2]")
	public static WebElement firstdata;

//===================================== X PATH SARANKA ==================

	// ============================== TABLE X PATH
	// =======================================
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement Table;

//================================== COPY ===========================================
	@FindBy(xpath = "(//span[@aria-label='copy'])")
	public static WebElement copyIcon;

//==================================== NEXT BUTTON =================================
	@FindBy(xpath = "//li[@title='Next Page']//button[@type='button']")
	public static WebElement NextButton;

//==================================== ADD PROCESS SAMPLE ============================
	@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']")
	public static WebElement addProductionSamplecopyPaste;

//==================================== CALENDAR SELECT ================================
	@FindBy(xpath = "//input[@id='date']")
	public static WebElement Date;

//===================================== SAVE BUTTON ==================================
	@FindBy(xpath = "//button[@formaction='test']")
	public static WebElement SaveButton;

//==================================== BODY ===========================================
	@FindBy(xpath = "//input[@id='workOrderNo']")
	public static WebElement ClickPlaceHolderWorkOrdeNo;

//=================================== TIME FIELD ======================================
	@FindBy(xpath = "//input[@id='creationDate']")
	public static WebElement beforeDateCreationField;

//=============================== TABLE DATA ============================================
	@FindBy(xpath = "(//td[@class='ant-table-cell'])[11] ")
	public static WebElement aftertableCreationDateField;

//============================= STATUS =================================================
	@FindBy(xpath = "//body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[16]/span[1]/span[1]")
	public static WebElement StatusBarNew;

	/* Validation Xpath */

	// * Finish Product Validation
	@FindBy(xpath = "//form/div[2]/div[1]/div[1]/div/div[1]/div[2]/div/div[3]")
	public static WebElement finishproductvalidation;

	// * Mix Design Validation
	@FindBy(xpath = "//form/div[2]/div[1]/div[1]/div/div[1]/div[3]/div/div[2]")
	public static WebElement mixdesignvalidation;

	// * Equipment Validation
	@FindBy(xpath = "//form/div[2]/div[1]/div[1]/div/div[2]/div[1]/div/div[2]")
	public static WebElement equipmentvalidation;

	// * Sample Date Validation
	@FindBy(xpath = "//form/div[2]/div[1]/div[1]/div/div[2]/div[3]/div/div[2]")
	public static WebElement sampledatevalidation;

	// * Sample Code Validation
	@FindBy(xpath = "//form/div[2]/div[1]/div[1]/div/div[2]/div[2]/div/div[1]")
	public static WebElement samplecodevalidation;

	/* Edit Validation */

	// * Production Sample Table Container
	@FindBy(xpath = "//*[@id='root']/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]")
	public static WebElement productionSampleTable;

	// * Calendar Cancel Icon
	@FindBy(xpath = "(//span[@role='button'])[17]")
	public static WebElement cancelicon;

	// * Sample Date Validation
	@FindBy(xpath = "//form/div[1]/div[1]/div[1]/div/div[2]/div[3]/div/div[2]")
	public static WebElement editsampledatevalidation;

	// * Sample Code Validation
	@FindBy(xpath = "//form/div[1]/div[1]/div[1]/div/div[2]/div[2]/div/div[1]")
	public static WebElement editsamplecodevalidation;

	// * Update Button
	@FindBy(xpath = "//button[@formaction='test']")
	public static WebElement updatebtn;

	/* Delete */

	// * Delete confirm Button
	@FindBy(xpath = "//span[normalize-space()='OK']")
	public static WebElement okbtn;

	// * Delete Message
	@FindBy(xpath = "//div[@class='ant-notification ant-notification-topRight']/div/div/div/div/div[1]")
	public static WebElement deletemsg;

	// * Table Count
	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	public static WebElement tablecount;

	/* Edit */

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement firsteditdata;

	/* Pagination */

	// * Previous Button
	@FindBy(xpath = "//li[@title='Previous Page']//button[@type='button']")
	public static WebElement previousbtn;

	// * Next Button
	@FindBy(xpath = "//li[@title='Next Page']//button[@type='button']")
	public static WebElement nextbtn;

	// * First Page Button
	@FindBy(xpath = "//div[@class='ant-table-wrapper sc-jzJRlG qfXxS']//a[@rel='nofollow'][normalize-space()='1']")
	public static WebElement firstpage;

	// * Second Page Button
	@FindBy(xpath = "//a[normalize-space()='2']")
	public static WebElement secondpage;

	// * DropDown Button
	@FindBy(xpath = "//div[@class='ant-select ant-select-sm ant-pagination-options-size-changer ant-select-single ant-select-show-arrow']")
	public static WebElement dropdown;

	@FindBy(xpath = "//div[@class='sc-gzVnrw flBzTM']")
	public static WebElement plantLabTrailSampleLeftButton;

	public static String beforr = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/ul/li[11]/div/div[2]/div/div/div/div[2]/div/div/div/div[";

	public static String after = "]/div";

	// **********************************************************************************
	// Production Sample Plant Field Search Icon || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/table/thead/tr/th[2]/div/span[2]/span")
	public static WebElement searchicon;

	// **********************************************************************************
	// Production Sample Plant Field Search textbox || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[1]/div[1]/div[1]/input")
	public static WebElement searchtextbox;

	// **********************************************************************************
	// Production Sample Plant Field Search search || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/div[1]/button")
	public static WebElement searchbutton;

	// **********************************************************************************
	// Production Sample Plant Field Column || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[2]")
	public static List<WebElement> colummplant;

	// **********************************************************************************
	// Production Sample Reset Button || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/div[3]/button")
	public static WebElement Resetbutton;

	// **********************************************************************************
	// Production Sample Finish Product Field Search Icon || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/table/thead/tr/th[3]/div/span[2]/span")
	public static WebElement FPsearchicon;

	// **********************************************************************************
	// Production Sample Finish Product Field Search textbox || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[1]/div[1]/div[1]/input")
	public static WebElement FPsearchtextbox;

	// **********************************************************************************
	// Production Sample Finish Product Field Search search || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[2]/div/div[1]/button")
	public static WebElement FPsearchbutton;

	// **********************************************************************************
	// Production Sample Finish Product Field Column || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[3]")
	public static List<WebElement> colummFP;

	// **********************************************************************************
	// Production Sample Finish Product Reset Button || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[2]/div/div[3]/button")
	public static WebElement FPResetbutton;

	// **********************************************************************************
	// Production Sample Finish Product Field Search Icon || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/table/thead/tr/th[4]/div/span[2]/span")
	public static WebElement MDsearchicon;

	// **********************************************************************************
	// Production Sample Finish Product Field Search textbox || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[1]/div[1]/div[1]/input")
	public static WebElement MDsearchtextbox;

	// **********************************************************************************
	// Production Sample Finish Product Field Search search || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[2]/div/div[1]/button")
	public static WebElement MDsearchbutton;

	// **********************************************************************************
	// Production Sample Finish Product Field Column || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[4]")
	public static List<WebElement> colummMD;

	// **********************************************************************************
	// Production Sample Finish Product Reset Button || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[2]/div/div[3]/button")
	public static WebElement MDResetbutton;

	// **********************************************************************************
	// Production Sample Production Code Field Search Icon || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]")
	public static WebElement PCsearchicon;

	// **********************************************************************************
	// Production Sample Production Code Field Search textbox || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[1]/div[1]/div[1]/input")
	public static WebElement PCsearchtextbox;

	// **********************************************************************************
	// Production Sample Production Code Field Search search || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[2]/div/div[1]/button")
	public static WebElement PCsearchbutton;

	// **********************************************************************************
	// Production Sample Production code Field Column || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> colummPC;

	// **********************************************************************************
	// Production Sample Production Code Reset Button || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[2]/div/div[3]/button")
	public static WebElement PCResetbutton;

	// **********************************************************************************
	// Production Sample Sample Code Field Search Icon || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]")
	public static WebElement SCsearchicon;

	// **********************************************************************************
	// Production Sample Sample Code Field Search textbox || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[1]/div[1]/div[1]/input")
	public static WebElement SCsearchtextbox;

	// **********************************************************************************
	// Production Sample Sample Code Field Search search || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[2]/div/div[1]/button")
	public static WebElement SCsearchbutton;

	// **********************************************************************************
	// Production Sample Sample code Field Column || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> colummSC;

	// **********************************************************************************
	// Production Sample Sample Code Reset Button || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[2]/div/div[3]/button")
	public static WebElement SCResetbutton;

	// **********************************************************************************
	// Production Sample Sample Date Field Search Icon || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]")
	public static WebElement SDsearchicon;

	// **********************************************************************************
	// Production Sample Sample Date Field Search textbox || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[1]/div[1]/div[1]/input")
	public static WebElement SDsearchtextbox;

	// **********************************************************************************
	// Production Sample Sample Date Field Search search || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[2]/div/div[1]/button")
	public static WebElement SDsearchbutton;

	// **********************************************************************************
	// Production Sample Sample Date Field Column || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> colummSD;

	// **********************************************************************************
	// Production Sample Sample Date Reset Button || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[2]/div/div[3]/button")
	public static WebElement SDResetbutton;

	// **********************************************************************************
	// Production Sample Creation Date Field Search Icon || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/table/thead/tr/th[11]/div/span[2]")
	public static WebElement CDsearchicon;

	// **********************************************************************************
	// Production Sample Creation Date Field Search textbox || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[5]/div/div/div/div/div[1]/div[1]/div[1]/input")
	public static WebElement CDsearchtextbox;

	// **********************************************************************************
	// Production Sample Creation Date Field Search search || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[5]/div/div/div/div/div[2]/div/div[1]/button")
	public static WebElement CDsearchbutton;

	// **********************************************************************************
	// Production Sample Creation Date Field Column || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[11]")
	public static List<WebElement> colummCD;

	// **********************************************************************************
	// Production Sample Creation Date Reset Button || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[5]/div/div/div/div/div[2]/div/div[3]/button")
	public static WebElement CDResetbutton;

	// **********************************************************************************
	// Production Sample Work Order No Field Search Icon || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]")
	public static WebElement WONsearchicon;

	// **********************************************************************************
	// Production Sample Work Order No Field Search textbox || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[1]/div[1]/div[1]/input")
	public static WebElement WONsearchtextbox;

	// **********************************************************************************
	// Production Sample Work Order No Field Search search || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[2]/div/div[1]/button")
	public static WebElement WONsearchbutton;

	// **********************************************************************************
	// Production Sample Work Order No Field Column || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> colummWON;

	// **********************************************************************************
	// Production Sample Work Order No Reset Button || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[2]/div/div[3]/button")
	public static WebElement WONResetbutton;

	// **********************************************************************************
	// Production Sample Customer Field Search Icon || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]")
	public static WebElement CUSsearchicon;

	// **********************************************************************************
	// Production Sample Customer Field Search textbox || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[1]/div[1]/div[1]/input")
	public static WebElement CUSsearchtextbox;

	// **********************************************************************************
	// Production Sample Customer Field Search search || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[2]/div/div[1]/button")
	public static WebElement CUSsearchbutton;

	// **********************************************************************************
	// Production Sample Customer Field Column || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> colummCUS;

	// **********************************************************************************
	// Production Sample Customer Reset Button || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[2]/div/div[3]/button")
	public static WebElement CUSResetbutton;

	// **********************************************************************************
	// Production Sample Project Field Search Icon || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]")
	public static WebElement PROsearchicon;

	// **********************************************************************************
	// Production Sample Project Field Search textbox || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[1]/div[1]/div[1]/input")
	public static WebElement PROsearchtextbox;

	// **********************************************************************************
	// Production Sample Project Field Search search || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[2]/div/div[1]/button")
	public static WebElement PROsearchbutton;

	// **********************************************************************************
	// Production Sample Project Field Column || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> colummPRO;

	// **********************************************************************************
	// Production Sample Project Reset Button || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[2]/div/div[3]/button")
	public static WebElement PROResetbutton;

	// **********************************************************************************
	// Production Sample Production Date Field Search Icon || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/table/thead/tr/th[12]/div/span[2]")
	public static WebElement PDsearchicon;

	// **********************************************************************************
	// Production Sample Production Date Field Search textbox || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']/div/div[1]/div[1]/div[1]/input")
	public static WebElement PDsearchtextbox;

	// **********************************************************************************
	// Production Sample Production Date Field Search search || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[2]/div/div[1]/button")
	public static WebElement PDsearchbutton;

	// **********************************************************************************
	// Production Sample Production Date Field Column || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[12]")
	public static List<WebElement> colummPD;

	// **********************************************************************************
	// Production Sample Production Date Reset Button || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[2]/div/div[3]/button")
	public static WebElement PDResetbutton;

	// **********************************************************************************
	// Production Sample Vehicle No Field Search Icon || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/table/thead/tr/th[13]/div/span[2]")
	public static WebElement VNsearchicon;

	// **********************************************************************************
	// Production Sample Vehicle No Field Search textbox || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']/div/div[1]/div[1]/div[1]/input")
	public static WebElement VNsearchtextbox;

	// **********************************************************************************
	// Production Sample Vehicle No Field Search search || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[2]/div/div[1]/button")
	public static WebElement VNsearchbutton;

	// **********************************************************************************
	// Production Sample Vehicle No Field Column || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[13]")
	public static List<WebElement> colummVN;

	// **********************************************************************************
	// Production Sample Vehicle No Reset Button || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[2]/div/div[3]/button")
	public static WebElement VNResetbutton;

	// **********************************************************************************
	// Production Sample Vehicle No Field Search Icon || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/table/thead/tr/th[19]/div/span[2]")
	public static WebElement statussearchicon;

	// **********************************************************************************
	// Production Sample Vehicle No Field Search textbox || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(id = "status")
	public static WebElement statussearchtextbox;

	// **********************************************************************************
	// Production Sample Vehicle No Field Search search || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']/div/div[2]/div/div[1]/button")
	public static WebElement statussearchbutton;

	// **********************************************************************************
	// Production Sample Vehicle No Field Column || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[19]")
	public static List<WebElement> colummstatus;

	// **********************************************************************************
	// Production Sample Vehicle No Reset Button || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']/div/div[2]/div/div[3]/button")
	public static WebElement statusResetbutton;

	// **********************************************************************************
	// Production Sample Commodity Field Search Icon || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/table/thead/tr/th[14]/div/span[2]")
	public static WebElement commoditysearchicon;

	// **********************************************************************************
	// Production Sample Commodity Field Search textbox || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[1]/div[1]/div[1]/input")
	public static WebElement commoditysearchtextbox;

	// **********************************************************************************
	// Production Sample Commodity Field Search search || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[2]/div/div[1]/button")
	public static WebElement commoditysearchbutton;

	// **********************************************************************************
	// Production Sample Commodity Field Column || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[14]")
	public static List<WebElement> colummcommodity;

	// **********************************************************************************
	// Production Sample Commodity Reset Button || Author :
	// Priyanka
	// **********************************************************************************

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[2]/div/div[3]/button")
	public static WebElement commodityResetbutton;

//	Before and After of KEY
//	--------------------------

	public static String ProKeyBefore = "//div[@class='ant-ribbon-wrapper'][";
	public static String ProKeyAfter = "]//span[@class='anticon anticon-key']";
	// Key Xpath Author : Priyanka

	public static String productionKeyBefore = "//div[@class='ant-modal-content']/div[2]/div/div[";
	public static String productionKeyAfter = " ]/div[1]/div/li/div/span";

	// Status Coulmn Author : Priyanka

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[19]")
	public static List<WebElement> statusColumn;

	// ***************Modify By:-*@Sasikala**********************//

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> StatusColumn;

	// Production Sample Before Search XPath

	public static String proBeforeSearch = "//div[@class='sc-bxivhb hSswcz']/div[";

	// Production Sample After Search XPath

	public static String proAfterSearch = "]//span[@class='anticon anticon-key']";

	// FINISH PRODUCT SAMPLES BUTTON - Authour - N.Karunya
	@FindBy(xpath = "//a[@href='#/finshproductsamples']")
	public static WebElement finishProductSamplesbutton;

	// PRODUCTION SAMPLE TABLE
	@FindBy(xpath = "//div[@class='ant-table-container']")
	public static WebElement productionsampletable;

	// PRODUCTION SAMPLE TABLE TEST & RESULT ICON
	@FindBy(xpath = "	/html/body/div[3]/div/div[2]/div/div[2]")
	public static WebElement testandresulticonpopup;

	// PRODUCTION SAMPLE TABLE TEST & RESULT ICON
	@FindBy(xpath = "\r\n" + "	//button[@class='ant-btn ant-btn-default']")
	public static WebElement teststatusOkbutton;

	// PRODUCTION SAMPLE TABLE TEST & RESULT ICON CANCEL BUTTON
	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	public static WebElement teststatuCancelbutton;

	// PRDOCTIONS SAMPLE HEADING(RAHUL)
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[1]/div/div[1]/div")
	public static WebElement productionSampelHeading;

	// RAW MATERIAL PREVIOUS BUTTON IN ADD PRODUCTION SAMPLE(RAHUL-2023/05/11)
	@FindBy(xpath = "//label[text()='Mix Design Proportion']/..//span[@class='anticon anticon-left']/..")
	public static WebElement previousButtonForRawMaterial;
	// RAW MATERIAL NEXT BUTTON IN ADD PRODUCTION SAMPLE(RAHUL-2023/05/11)
	@FindBy(xpath = "//label[text()='Mix Design Proportion']/..//span[@class='anticon anticon-right']/..")
	public static WebElement nextButtonForRawMaterial;

	// RAW MATERIAL FIRST IN ADD PRODUCTION SAMPLE(RAHUL-2023/05/11)
	@FindBy(xpath = "//div[@class='ant-table-wrapper']//li[@title='1']")
	public static WebElement firstPage;

//	first row status 

	@FindBy(xpath = "//tr[@class='ant-table-row ant-table-row-level-0'][1]//td[@class='ant-table-cell ant-table-cell-fix-right'][1]")
	public static WebElement firstRowStatus;

	// RAW MATERIAL FIRST IN ADD PRODUCTION SAMPLE(RAHUL-2023/05/11)
	@FindBy(xpath = "//div[@class='ant-table-wrapper']//li[@title='2']")
	public static WebElement secondPage;

				
				//Trial validation message
				@FindBy(xpath = "//div[@style='color: red; font-size: 12px; width: 160px; height: 2px; padding: 5px;']")
				public static WebElement trialValueValidation;
				
//				First Trial text box
				@FindBy(xpath = "(//div[@style='background-color: white;']/div/div/input[@placeholder='g'])[1]")
				public static WebElement firstTrialTextBox;
				
//				Second Trial text box
				@FindBy(xpath = "(//div[@style='background-color: white;']/div/div/input[@placeholder='g'])[2]")
				public static WebElement secondTrialTextBox;
				
//				Third Trial text box
				@FindBy(xpath = "(//div[@style='background-color: white;']/div/div/input[@placeholder='g'])[3]")
				public static WebElement thirdTrialTextBox;
				
			//  Trial Button
				@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']")
				public static WebElement trialButton;
				
				@FindBy(xpath = "//button[@type='button']")
				public static WebElement submitButton;			
				
				

	// production sample Table --- N.Karunya
	@FindBy(xpath = "//div[@class='ant-table-container']")
	public static WebElement productionsampleTable;
	
	// plant lab Trial sample Popup --- N.Karunya
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]")
	public static WebElement productionsampleMorePopup;


	// **********Author:- @RAHUL.S
	// Test date(Rahul.S-16/05/2023)
	@FindBy(xpath = "//*[@id=\"date\"]")
	public static WebElement testDate;

	// Remove date(Rahul.S-16/05/2023)
	@FindBy(xpath = "//span[@aria-label='close-circle']")
	public static WebElement dateCloseIcon;

	// Test Date Validation message(Rahul.S-16/05/2023)
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div/div[1]/div/div[4]/div/div[2]")
	public static WebElement testDateValidation;

	// No of trail Text box message(Rahul.S-16/05/2023)
	@FindBy(xpath = "//*[@id=\"noOfTrial\"]")
	public static WebElement noOfTrailTextBox;

	// No of trail Validation message(Rahul.S-16/05/2023)
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div/div[1]/div/div[5]/div/div[1]")
	public static WebElement noOfTrailValidation;

	

}
