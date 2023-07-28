//***********************************************************************************
//* Description
//*------------
//* 
//***********************************************************************************
//*
//* Author           : NILUXY KRISHNATHAVAM
//* Date Written     : 17/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-P-LAB-SAM   17/04/2023   NILUXY.K    Orginal Version
//
//************************************************************************************
package com.qa.automation.qdms.sample.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlantLabTrailSamplePage {

	// ADD PLANT LAB TRAIL SAPLE XPATH (nilux)

	@FindBy(xpath = "//span[normalize-space()='Add Plant-Lab Trial Sample']")
	public static WebElement AddPlantTrailSample;

	// PLANT DROPDOWN TEXTBOX XPATH (nilux)

	@FindBy(xpath = "//input[@id='plantName']")
	public static WebElement PlantTextbox;

	// FINISHED PRODUCT DROPDOWN TEXTBOX XPATH (nilux)

	@FindBy(xpath = "//input[@id='rawMaterialId']")
	public static WebElement FinishproductTextbox;

	// MIX DESIGN DROPDOWN TEXTBOX XPATH (nilux)

	@FindBy(xpath = "//input[@id='finsih_product_mixdesign_code']")
	public static WebElement MixdesignTextbox;

	// EQUIPMENT DROPDOWN TEXTBOX XPATH (nilux)

	@FindBy(xpath = "//input[@id='equipmentId']")
	public static WebElement EquipmentTextbox;

	// SAMPLEDATE TEXTBOX XPATH (nilux)

	@FindBy(xpath = "//input[@id='date']")
	public static WebElement SampledateTextbox;

	// SAMPLE FINISHED PRODUCT CODE TEXTBOX XPATH (nilux)

	@FindBy(xpath = "//input[@id='finishProductCode']")
	public static WebElement SampleproductCodeTextbox;

	// CREATION DATE TEXTBOX XPATH (nilux)

	@FindBy(xpath = "//input[@id='creationDate']")
	public static WebElement CreationDateTextbox;

	// SAVE BUTTON (nilux)
	@FindBy(xpath = "//body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[3]/button[2]")
	public static WebElement Savebutton;

	// CANCEL BUTTON (nilux)
	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement Cancelbutton;

	// FIRST ROW OF TABLE(nilux)
	@FindBy(xpath = "//body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[3]")
	public static WebElement TableFirstRow;

	// EMPTY VALIDATION DROPDOWN MESSAGE FOR PLANT (nilux)

	@FindBy(xpath = "//body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]")
	public static WebElement Plantvalidationempty;

	// EMPTY VALIDATION DROPDOWN MESSAGE FOR FINISHED PRODUCT (nilux)

	@FindBy(xpath = "//body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[1]/div[2]/div[1]/div[2]")
	public static WebElement finishproductvalidationempty;

	// EMPTY VALIDATION DROPDOWN MESSAGE FOR MIXED DESIGN (nilux)

	@FindBy(xpath = "//body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[1]/div[2]")
	public static WebElement Mixdesignvalidationempty;

	// EMPTY VALIDATION DROPDOWN MESSAGE FOR EQUIPMENT (nilux)

	@FindBy(xpath = "//body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[2]/div[2]/div[1]/div[2]")
	public static WebElement Equipementvalidationempty;

	// EMPTY VALIDATION DROPDOWN MESSAGE FOR START DATE (nilux)

	@FindBy(xpath = "//body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[3]/div[1]/div[1]/div[2]")
	public static WebElement Startdatevalidationempty;

	// SPCIEAL CHARECTER VALIDATION DROPDOWN MESSAGE FOR SAMPLE CODE (nilux)

	@FindBy(xpath = "//div[normalize-space()='Invalid Characters']")
	public static WebElement Spciealcharacterforsamplecodevalidationempty;

	// SUCCESS MESSAGE FOR DATA HAS ADDED-PLANT LAB TRAIL (nilux)

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div[1]")
	public static WebElement SuccessmesageNotification;

	// PLANT COLUMN ROW ONE BY ONE (nilux)
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> column;

	// SEARCH ICON FOR PLANT FIELD IN LAB TRAIL (nilux)

	@FindBy(xpath = "//th[@class='ant-table-cell ant-table-cell-fix-left ant-table-cell-fix-left-last']//span[@aria-label='search']")
	public static WebElement Plantfieldsearchicon;

	// SEARCH TEXTBOX FOR PLANT FIELD IN LAB TRAIL (nilux)

	@FindBy(xpath = "//input[@placeholder=' Plant']")
	public static WebElement Plantfieldsearchtextbox;

	// SEARCH BUTTON FOR PLANT FIELD IN LAB TRAIL (nilux)

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement PlantfieldsearchButton;

	// RESET BUTTON FOR PLANT FIELD IN LAB TRAIL (nilux)

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement ResetbuttonPlantfieldsearch;

	// TABLE DATA COUNT CONTAINER (nilux)
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement tableContainer;

	// 1ST PAGE IN TABLE PAGINATION (nilux)
	@FindBy(xpath = "//a[normalize-space()='1']")
	public static WebElement FirstPage;

	// FINISHED PRODUCT SEARCH ICON (nilux)
	@FindBy(xpath = "//th[2]//div[1]//span[2]//span[1]")
	public static WebElement Finisheproductsearchicon;

	// FINISHED PRODUCT SEARCH TEXT BOX (nilux)
	@FindBy(xpath = "//input[contains(@placeholder,'Finish Product')]")
	public static WebElement FinisheproductsearchTextbox;

	// MIXED DESIGN SEARCH ICON (nilux)
	@FindBy(xpath = "//th[3]//div[1]//span[2]//span[1]//*[name()='svg']")
	public static WebElement MixedDesignSearchicon;

	// MIXED DESIGN SEARCH TEXTBOX (nilux)
	@FindBy(xpath = "//input[contains(@placeholder,'Mix Design / BOM / Composition')]")
	public static WebElement MixedDesignSearchTextbox;

	// MIXED DESIGN SEARCH BUTTON (nilux)
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement MixedDesignSearchButton;

	// MIXED DESIGN COLUMN ROW ONE BY ONE (nilux)
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[3]")
	public static List<WebElement> columnMD;

	// FINISHED PRODUCT SAMPLE SEARCH ICON (nilux)
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/table/thead/tr/th[4]/div/span[2]/span")
	public static WebElement FPSAMPLESearchIcon;

	// FINISHED PRODUCT SAMPLE SEARCH TEXT BOX (nilux)
	@FindBy(xpath = "//input[contains(@placeholder,'Finish Product Sample')]")
	public static WebElement FPSAMPLESearchTextbox;

	// RESET BUTTON FOR PLANT FIELD IN LAB TRAIL (nilux)

	@FindBy(xpath = "/html/body/div[5]/div/div/div/div/div[2]/div/div[3]/button")
	public static WebElement ResetbuttonFPSAMPLEReset;

	// FINISHED PRODUCT SAMPLE COLUMN ROW ONE BY ONE (nilux)
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[4]")
	public static List<WebElement> columnFinishproductsample;

	// SAMPLECODE SEARCH ICON (nilux)
	@FindBy(xpath = "//th[5]//div[1]//span[2]//span[1]")
	public static WebElement Samplecodesearchicon;

	// SAMPLECODE SEARCH TEXTBOX (nilux)
	@FindBy(xpath = "//input[contains(@placeholder,'Sample Code')]")
	public static WebElement SamplecodesearchTextbox;

	// SAMPLECODE COLUMN ROW ONE BY ONE (nilux)
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[5]")
	public static List<WebElement> columnSamplecode;

	// SAMPLEDATE SEARCH ICON (nilux)
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/table/thead/tr/th[6]/div/span[2]/span")
	public static WebElement Sampledatesearchicon;

	// SAMPLEDATE SEARCH TEXTBOX (nilux)
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']/div/div[1]/div[1]/div[1]/input")
	public static WebElement SampledatesearchTextbox;

	// SAMPLEDATE COLUMN ROW ONE BY ONE (nilux)
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[6]")
	public static List<WebElement> columnSampledate;

	// CREATIONDATE SEARCH ICON (nilux)
	@FindBy(xpath = "//th[7]//div[1]//span[2]//span[1]")
	public static WebElement creationdatesearchicon;

	// CREATIONDATE SEARCH TEXTBOX (nilux)
	@FindBy(xpath = "//input[contains(@placeholder,'Creation Date')]")
	public static WebElement creationdatesearchTextbox;

	// CREATIONDATE COLUMN ROW ONE BY ONE (nilux)
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[7]")
	public static List<WebElement> columnCreationdate;

	// DEELTE OK BUTTON (nilux)
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement deleteokbutton;

	////////////////////////////////////////

	// FINISHED PRODUCT COLUMN ROW ONE BY ONE
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[2]")
	public static List<WebElement> columnFP;

	@FindBy(xpath = "//*[@id=\"plantName\"]")
	public static WebElement plantForCheckDisabled;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[1]/div/div[1]/div/span[2]")
	public static WebElement plantTextBox;

	@FindBy(xpath = "//*[@id=\"rawMaterialId\"]")
	public static WebElement finishProductForCheckDisabled;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[2]/div/div[1]/div/span[2]")
	public static WebElement finishProductTextBox;

	@FindBy(xpath = "//*[@id=\"finsih_product_mixdesign_code\"]")
	public static WebElement mixedDesignForCheckDisabled;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[1]/div/div[1]/div/span[2]")
	public static WebElement mixedDesignTextBox;

	@FindBy(xpath = "//*[@id=\"finishProductCode\"]")
	public static WebElement sampleCode;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[3]/div[1]/div/div[1]/div/span[2]/span")
	public static WebElement SampleDateClearButton;

	@FindBy(xpath = "(//button[@type='button'])[5]")
	public static WebElement UpdateButton;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[3]/div[2]/div/div[1]")
	public static WebElement sampleCodeValidation;
	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement cancelButtonForEditValidation;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[3]/div[1]/div/div[2]")
	public static WebElement validationForSampleDate;

	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement keyTestModal;

	@FindBy(xpath = "//*[@id=\"rcDialogTitle0\"]")
	public static WebElement KeyTestModalHeading;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[3]/label/span")
	public static WebElement keyTestCheckBox;

	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[2]")
	public static WebElement keyTestSaveButton;

	@FindBy(xpath = "//body//div//div[@class='ant-modal-footer']//div//button[1]")
	public static WebElement keyTestCancelButton;

	@FindBy(xpath = "//div[@class='ant-table ant-table-small ant-table-fixed-header ant-table-scroll-horizontal']//div[@class='ant-table-container']")
	public static WebElement keyTestTableTitleContainer;

	@FindBy(xpath = "//div[@class='ant-table ant-table-small ant-table-fixed-header ant-table-scroll-horizontal']//div[@class='ant-table-body']//table")
	public static WebElement keyTestTableContent;

	// *********************************************************************
	// Plant Lab Trial Sample "Previous" Button || Author : Priyanka
	// *********************************************************************

	@FindBy(xpath = "//li[@class='ant-pagination-prev']//span[@aria-label='left']//*[name()='svg']")
	public static WebElement PreviousPageBtn;

	// *********************************************************************
	// Plant Lab Trial Sample "Next" Button || Author : Priyanka
	// *********************************************************************

	@FindBy(xpath = "//li[@class='ant-pagination-next']//span[@aria-label='right']//*[name()='svg']")
	public static WebElement NextPageBtn;

	// *********************************************************************
	// Plant Lab Trial Sample "Pagination Second" Button || Author : Priyanka
	// *********************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/ul/li[4]")
	public static WebElement PaginationSecoundPage;

	// *********************************************************************
	// Plant Lab Trial Sample "Default Page" Button || Author : Priyanka
	// *********************************************************************

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/ul/li[3]")
	public static WebElement PaginationFirstPage;

	// *********************************************************************
	// Plant Lab Trial Sample "Page" Button || Author : Priyanka
	// *********************************************************************

	public static String PageBefore = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/ul/li[11]/div/div[2]/div/div/div/div[2]/div/div/div/div[";
	public static String PageAfter = "]/div";

	// *********************************************************************
	// Plant Lab Trial Sample "Drop down" Button || Author : Priyanka
	// *********************************************************************

	// ===========================================================================================
	// X-PATH -SARANKA FOR COPY PASTE

	// ============================== TABLE X PATH
	// =======================================
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement Table;

	// ================================== COPY
	// ===========================================
	@FindBy(xpath = "(//span[@aria-label='copy'])[8]")
	public static WebElement copyIcon;

	// ==================================== NEXT BUTTON
	// =================================
	@FindBy(xpath = "//li[@title='Next Page']//button[@type='button']")
	public static WebElement NextButton;

	// ==================================== ADD PROCESS SAMPLE
	// ============================
	@FindBy(xpath = "//div[@class='sc-bxivhb hiMnNy']//div//button[@type='button']")
	public static WebElement addPlantLabTrailButton;

	// ==================================== CALENDAR SELECT
	// ================================
	@FindBy(xpath = "//input[@id='date']")
	public static WebElement Date;

	// ===================================== SAVE BUTTON
	// ==================================
	@FindBy(xpath = "(//button[@type='button'])[5]")
	public static WebElement SaveButton;

	// ==================================== BODY
	// ===========================================
	@FindBy(xpath = "//div[@class='ant-modal-body']")
	public static WebElement ModalBody;

	// =================================== TIME FIELD
	// ======================================
	@FindBy(xpath = "//input[@id='creationDate']")
	public static WebElement beforeDate;

	// =============================== TABLE DATA
	// ============================================
	@FindBy(xpath = "//tbody/tr[2]/td[7]")
	public static WebElement aftertableDataTimeField;

	// ============================= STATUS
	// =================================================
	@FindBy(xpath = "//body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[10]/span[1]/span[1]")
	public static WebElement StatusBarNew;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/ul/li[11]/div/div[1]")
	public static WebElement Paginationdropdown;

	// Plant Lab Trail Sample Before Search XPath

	public static String labtrailBeforepath = "//div[@class='sc-bxivhb hSswcz']/div[";

	// Plant Lab Trail Sample After Search XPath

	public static String labtrailAfterpath = "]//span[@class='anticon anticon-key']";

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[10]")
	public static List<WebElement> StatusColumn;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[1]/div/div[1]")
	public static WebElement LabtrailHeadring;

	@FindBy(xpath = "//div[@class='ant-table-body']")
	public static WebElement Scrolllabtrail;

	// Key Xpath Author : Priyanka

	public static String plantLabKeyBefore = "//div[@class='ant-modal-content']/div[2]/div/div[";
	public static String plantLabKeyAfter = " ]/div[1]/div/li/div/span";

	// Status Coulmn Author : Priyanka

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[10]")
	public static List<WebElement> statusColumn;

	// Sample card

	@FindBy(xpath = "//a[@href='#/samples']")
	public static WebElement Sample;

	// Finish Product top click
	@FindBy(xpath = "//a[@class='sc-bdVaJa ieeiNp'][@href='#/finshproductsamples']")
	public static WebElement FinishProductTopbar;

	@FindBy(xpath = "(//div[@class='sc-dnqmqq bxMwVY'])[1]")
	public static WebElement PlantLabTrialSample;

	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement testAndTrialModal;

	@FindBy(xpath = "((//tr[@class='ant-table-row ant-table-row-level-0'])[1]//td[@class='ant-table-cell'])[3]")
	public static WebElement firstRowVerifyColumn;

//	

	// CREATION DATE REMOVE ICON Author : RAHUL
	@FindBy(xpath = "(//span[@aria-label='close-circle'])[3]")
	public static WebElement creationDateRemove;

	// SAMPLE DATE REMOVE ICON Author : RAHUL
	@FindBy(xpath = "(//span[@aria-label='close-circle'])[2]")
	public static WebElement sampleDateRemove;

	// FINISH PRODUCT SAMPLE BUTTON Author : Karunya
	@FindBy(xpath = "//a[@href='#/finshproductsamples']")
	public static WebElement finishproductsamplesbutton;

	// PLANT TRIAL SAMPLES SUB MENU BUTTON Author : Karunya
	@FindBy(xpath = "//div[@class='sc-dnqmqq bxMwVY'][normalize-space()='Plant-Lab Trial Sample']")
	public static WebElement plantlabTrialsamplesubmenubutton;

	// PLANT TRIAL SAMPLES STATUS SEARCH ICON Author : Karunya
	@FindBy(xpath = "//th[@class='ant-table-cell ant-table-cell-fix-right']//span[@aria-label='search']//*[name()='svg']")
	public static WebElement plantlabTrialsampleStatussearchIcon;

	// PLANT TRIAL SAMPLES STATUS SEARCH TEXTBOX Author : Karunya
	@FindBy(xpath = "//input[@id='status']")
	public static WebElement plantlabTrialsampleStatussearchTextbox;

	// PLANT TRIAL SAMPLES STATUS SEARCH BUTTON Author : Karunya
	@FindBy(xpath = "//span[normalize-space()='Search']")
	public static WebElement plantlabTrialsampleStatussearchButton;

	// PLANT TRIAL SAMPLES STATUS SEARCH BUTTON Author : Karunya
	@FindBy(xpath = "//span[normalize-space()='Reset']")
	public static WebElement plantlabTrialsampleStatussearchResetButton;

	// div[@class='ant-notification ant-notification-topRight']
	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	public static WebElement submitSuccessNotification;

	// plant lab Trial sample Table --- N.Karunya
	@FindBy(xpath = "//div[@class='ant-table-container']")
	public static WebElement plantlabTrialsampleTable;

	// plant lab Trial sample Popup --- N.Karunya
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]")
	public static WebElement plantlabTrialsampleMorePopup;

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

	// Submit Button(Rahul.S-15/05/2023)
	@FindBy(xpath = "//button[@type='button']")
	public static WebElement submitButton;

	// Trial validation message
	@FindBy(xpath = "//div[@style='color: red; font-size: 12px; width: 160px; height: 2px; padding: 5px;']")
	public static WebElement trialValueValidation;

//	First Trial text box
	@FindBy(xpath = "(//div[@style='background-color: white;']/div/div/input[@placeholder='g'])[1]")
	public static WebElement firstTrialTextBox;

//	Second Trial text box
	@FindBy(xpath = "(//div[@style='background-color: white;']/div/div/input[@placeholder='g'])[2]")
	public static WebElement secondTrialTextBox;

//	Third Trial text box
	@FindBy(xpath = "(//div[@style='background-color: white;']/div/div/input[@placeholder='g'])[3]")
	public static WebElement thirdTrialTextBox;

//  Trial Button
	@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']")
	public static WebElement trialButton;

}
