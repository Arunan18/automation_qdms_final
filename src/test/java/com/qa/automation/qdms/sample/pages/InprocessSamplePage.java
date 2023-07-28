
//****************************************************************************************
//DESCRIPTION
//------------------
//				IN-PROCESS SAMPLE PAGE XPATHS
//					Author :-		 @SASIKALA AMBALAVANAR
//					DATE Written:-   11:04:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* 					  11:04:2023     @SASIKALA     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.sample.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InprocessSamplePage {

	// QDMS user name XPath
	@FindBy(xpath = "//*[@id ='usernameOrEmail']")
	public static WebElement username;

	// QDMS Password XPath
	@FindBy(id = "password")
	public static WebElement password;

	// QDMS Login button XPath
	@FindBy(xpath = "//button[@type]")
	public static WebElement login;

	// Sample card
	@FindBy(xpath = "//a[@href='#/samples']")
	public static WebElement Sample;

	// Raw Material top click
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[1]")
	public static WebElement RawMaterialTopbar;

	// InprocessSample Site button Click
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[2]/div[1]")
	public static WebElement InprocessSample;

	// Add InprocessSample button
	@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']/span")
	public static WebElement AddInprocessSamplebtn;

	// Supplier Category Filed
	@FindBy(xpath = "//div[@name='supplierCategory']")
	public static WebElement SupplierCategoryField;

	// Plant Filed
	@FindBy(xpath = "//div[@name='plant']")
	public static WebElement PlantField;

	// Supplier Filed
	@FindBy(xpath = "//input[@id='supplierName']")
	public static WebElement SupplierNameField;

	// RawMaterial Filed
	@FindBy(xpath = "//input[@id='rawMaterialId']")
	public static WebElement RawMaterialField;

	// Vehicle No Filed
	@FindBy(xpath = "//input[@id='vehicleNo']")
	public static WebElement VehicleNoField;

	// Sample Code Filed
	@FindBy(xpath = "//input[@id='finishProductCode']")
	public static WebElement SampleCodeField;

	// Source Filed
	@FindBy(xpath = "//input[@id='source']")
	public static WebElement SourceField;

	// Date of Sampling Filed
	@FindBy(xpath = "//input[@id='creationDate']")
	public static WebElement DateofSamplingField;

	// Date of Sampling Filed CLOSE button
	@FindBy(xpath = "//div[contains(@class,'ant-picker ant-picker-focused')]//span[contains(@role,'button')]")
	public static WebElement DateofSamplingFieldclosebtn;

	// Sampled Time Filed
	@FindBy(xpath = "//input[@name='sampledTime']")
	public static WebElement SampledTimeField;

	// Date of Sampling Time CLOSE button
	@FindBy(xpath = "//div[contains(@class,'ant-picker ant-picker-focused')]//span[contains(@role,'button')]")
	public static WebElement DateofSampleTimeFieldclosebtn;

	// Arrival Date Filed
	@FindBy(xpath = "//input[@id='arrivalDate']")
	public static WebElement ArrivalDateField;

	// BL/LC No Filed
	@FindBy(xpath = "//input[@id='bllcNo']")
	public static WebElement BLLCNoField;

	// GRN Filed
	@FindBy(xpath = "//input[@id='aod']")
	public static WebElement GRNField;

	// Quantity and brand received Filed
	@FindBy(xpath = "//input[@id='quantityAndBrandReceived']")
	public static WebElement QuantityandbrandreceivedField;

	// Save Button
	@FindBy(xpath = "//button[@style='background: rgb(0, 19, 40); color: white; border: none;']")
	public static WebElement Savebtn;

	// Cancel Button
	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement Cancelbtn;

	// Today Click
	@FindBy(xpath = "/html/body/div[12]/div/div/div/div/div[2]/a")
	public static WebElement Todaybtn;

	// Modifi Quenthan17.04.2023
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div/div[3]/a/div/div")
	public static WebElement sampleCard;

	@FindBy(xpath = "//*[@id='root']/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[1]/div/div[2]/button")
	public static WebElement addProcessSample;

	@FindBy(xpath = "//*[@id=\"rcDialogTitle0\"]/div")
	public static WebElement addprsamtitle;

	@FindBy(id = ("supplierCategory"))
	public static WebElement supplierCategoryTextbox;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[1]/div/div[2]")
	public static WebElement supplierCategoryTextboxerr;

	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[2]")
	public static WebElement addArocessSampleSave;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]")
	public static WebElement table;

	@FindBy(id = "plant")
	public static WebElement planttextbox;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[2]/div/div[2]")
	public static WebElement plantTextBoxErr;

	@FindBy(id = "supplierName")
	public static WebElement suupplierNameTextBox;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[3]/div/div[2]")
	public static WebElement suupplierNameTextBoxerr;

	@FindBy(id = "rawMaterialId")
	public static WebElement rawMaterialIdTextBox;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[1]/div/div[2]")
	public static WebElement rawMaterialIdTextBoxerr;

	@FindBy(id = "finishProductCode")
	public static WebElement sampleCodeTextBox;

	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[2]/div[3]/div/div[1]")
	public static WebElement sampleCodeTextBoxErr;

	@FindBy(xpath = "//*[@id=\'root\']/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]")
	public static WebElement processSampleTable;

	// In process Sample Dashboard
	@FindBy(xpath = "//div[@style='margin-top: -5px; margin-left: -10px; font-size: medium; font-weight: 600; align-self: auto; text-align: justify; padding: 10px; height: 25px; flex-basis: 650px;']")
	public static WebElement DashboardInProcess;

	// Add InProcess Sample Success Message
	@FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-success ant-notification-notice-closable']")
	public static WebElement AddInProcessSamplesuccessmsg;

	// Last added data come in first line
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement AddInProcessfirstdata;

//***********************DELETE XPATH - IN PROCESS SAMPLE*******************

	// Delete Ok button Filed
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement Deleteokbtn;

	// Delete InProcess Sample Success Message
	@FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-success ant-notification-notice-closable']")
	public static WebElement deleteInProcessSamplesuccessmsg;

	@FindBy(xpath = "//*[@id='root']/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/ul/li[9]/div/div[1]/span[2]")
	public static WebElement pageSelector;

	@FindBy(xpath = "//*[@id=\'root\']/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/ul/li[9]/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div")
	public static WebElement tenPage;

	@FindBy(xpath = "//*[@id='root']/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/ul/li[9]/div/div[2]/div/div/div/div[2]/div/div/div/div[2]/div")
	public static WebElement twntyPage;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/ul/li[9]/div/div[2]/div/div/div/div[2]/div/div/div/div[3]/div")
	public static WebElement thtyPage;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/ul/li[9]/div/div[2]/div/div/div/div[2]/div/div/div/div[4]/div")
	public static WebElement huPage;

//*********************In Process Sample Code Search XPath*************************
	// Code Search icon XPath
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]/span")
	public static WebElement Codesearchicon;

	// Code Search text box XPath
	@FindBy(xpath = "//input[@placeholder=' Code']")
	public static WebElement Codesearchtextbox;

	// Code Search button XPath
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement Codesearchbutton;

	// Code Search Reset XPath
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement Codereseticon;

	// Code Search screen PopUp icon XPath
	@FindBy(xpath = "//div[@style='padding: 8px; margin-top: -140px; width: 200px;']")
	public static WebElement Codesearchpopup;

	// *********************In Process Sample Plant Search
	// XPath*************************
	// Plant Search icon XPath
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[3]/div[1]/span[2]/span[1]")
	public static WebElement Plantsearchicon;

	// ============================== TABLE X PATH//
	// =======================================
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div")
	public static WebElement Table;

	// ================================== COPY //
	// ===========================================
	@FindBy(xpath = "(//span[@aria-label='copy'])[2]")
	public static WebElement copyIcon;

	// ==================================== NEXT BUTTON //
	// =================================
	@FindBy(xpath = "//li[@title='Next Page']//button[@type='button']")
	public static WebElement NextButton;

	// ==================================== ADD PROCESS SAMPLE//
	// ============================
	@FindBy(xpath = "(//button[@class='ant-btn sc-gZMcBi dMdnOw'])[1]")
	public static WebElement addProcessSampleButton;

	// ===================================== SAVE BUTTON //
	// ==================================
	@FindBy(xpath = "(//button[@type='button'])[5]")
	public static WebElement SaveButton;

	// ==================================== BODY //
	// ===========================================
	@FindBy(xpath = "//div[@class='ant-modal-body']")
	public static WebElement ModalBody;

	// =================================== TIME FIELD //
	// ======================================
	@FindBy(xpath = "//input[@placeholder='Select time']")
	public static WebElement beforeTimeField;

	// =============================== TABLE DATA //
	// ============================================
	@FindBy(xpath = "(//td[@class='ant-table-cell'])[8]")
	public static WebElement aftertableDataTimeField;

	// ============================= STATUS//
	// =================================================
	@FindBy(xpath = "//body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[16]/span[1]/span[1]")
	public static WebElement StatusBarNew;

//	// *********************In Process Sample Plant Search
//	// XPath*************************
//	// Plant Search icon XPath
//	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[3]/div[1]/span[2]/span[1]")
//	public static WebElement Plantsearchicon;

	// Plant Search text box XPath
	@FindBy(xpath = "//input[@placeholder=' Plant']")
	public static WebElement Plantsearchtextbox;

	// Plant Search button XPath
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary ant-btn-sm'])[1]")
	public static WebElement Plantsearchbutton;

	// Plant Search Reset XPath
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div[3]/button")
	public static WebElement Plantreseticon;

	// Plant Search screen PopUp icon XPath
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div")
	public static WebElement Plantsearchpopup;

// *********************In Process Sample Raw Material Search XPath*************************
	// Raw Material Search icon XPath
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[4]/div/span[2]/span")
	public static WebElement RMsearchicon;

	// Raw Material Search text box XPath
	@FindBy(xpath = "//input[@placeholder=' Raw Material']")
	public static WebElement RMsearchtextbox;

	// Raw Material Search button XPath
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div[1]/button")
	public static WebElement RMsearchbutton;

	// Raw Material Search Reset XPath
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div[3]/button")
	public static WebElement RMreseticon;

	// Raw Material Search screen PopUp icon XPath
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div")
	public static WebElement RMsearchpopup;

	// In Process Sample Scroll bar horizontal XPath
	@FindBy(xpath = "//div[@class='ant-table-body']")
	public static WebElement HRScroll;

	// In Process Sample Table XPath
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement Inprocesssampletable;

	// *********************In Process Sample Sub Category Search
	// XPath*************************
	// Sub Category Search icon XPath
	@FindBy(xpath = "(//span[@aria-label='search'])[5]")
	public static WebElement SCsearchicon;

	// Sub Category Search text box XPath
	@FindBy(xpath = "//input[@placeholder=' Sub Category']")
	public static WebElement Scsearchtextbox;

	// Sub Category Search button XPath
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div[1]/button")
	public static WebElement SCsearchbutton;

	// Sub Category Search Reset XPath
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div[3]/button")
	public static WebElement SCreseticon;

	// Sub Category Search screen PopUp icon XPath
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div")
	public static WebElement SCsearchpopup;

//*********************In Process Sample Date Search XPath*************************
	// Date Search icon XPath
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[6]/div[1]/span[2]/span[1]")
	public static WebElement Datesearchicon;

	// Date Search text box XPath
	@FindBy(xpath = "//input[@placeholder=' Date ']")
	public static WebElement Datesearchtextbox;

	// Date Search button XPath
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div[1]/button")
	public static WebElement Datesearchbutton;

	// Date Search Reset XPath
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div[3]/button")
	public static WebElement Datereseticon;

	// Date Search screen PopUp icon XPath
	@FindBy(xpath = "(//div[@class='ant-table-filter-dropdown'])[1]")
	public static WebElement Datesearchpopup;

// *********************In Process Sample Vehicle Number Search XPath*************************
	// Vehicle Number Search icon XPath
	@FindBy(xpath = "(//span[@aria-label='search'])[10]")
	public static WebElement VNsearchicon;

	// Vehicle Number Search text box XPath
	@FindBy(xpath = "//input[@placeholder='  Vehicle No / Vessels']")
	public static WebElement VNsearchtextbox;

	// Vehicle Number Search button XPath
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary ant-btn-sm'])[1]")
	public static WebElement VNsearchbutton;

	// Vehicle Number Search Reset XPath
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm'][1]")
	public static WebElement VNreseticon;

	// Vehicle Number Search screen PopUp icon XPath
	@FindBy(xpath = "(//div[@class='ant-table-filter-dropdown'])[1]")
	public static WebElement VNsearchpopup;

// *********************In Process Sample Sample Code Search XPath*************************
	// Sample Code Search icon XPath
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[11]/div/span[2]/span")
	public static WebElement SampleCodesearchicon;

	// Sample Code Search text box XPath
	@FindBy(xpath = "//input[@placeholder='  Sample code']")
	public static WebElement SampleCodesearchtextbox;

	// Sample Code Search button XPath
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary ant-btn-sm'])[1]")
	public static WebElement SampleCodesearchbutton;

	// Sample Code Search Reset XPath
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-sm'])[1]")
	public static WebElement SampleCodereseticon;

	// Sample Code Search screen PopUp icon XPath
	@FindBy(xpath = "(//div[@class='ant-table-filter-dropdown'])[1]")
	public static WebElement SampleCodesearchpopup;

//*********************In Process Sample GRN Search XPath*************************

	// GRN Search icon XPath
	@FindBy(xpath = "(//span[@aria-label='search'])[14]")
	public static WebElement GRNsearchicon;

	// Sample GRN Search screen PopUp icon XPath
	@FindBy(xpath = "(//div[@class='ant-table-filter-dropdown'])[1]")
	public static WebElement GRNsearchpopup;

	// Sample GRN Search text box XPath
	@FindBy(xpath = "//input[@placeholder=' GRN']")
	public static WebElement GRNsearchtextbox;

	// Sample GRN Search button XPath
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement GRNsearchbutton;

	// Sample GRN Search Reset XPath
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-sm'])[1]")
	public static WebElement GRNreseticon;

// *********************In Process Sample Supplier Search XPath*************************
	// Sample Supplier Search icon XPath
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[2]/div/span[2]")
	public static WebElement Suppliersearchicon;

	// Sample Supplier Search text box XPath
	@FindBy(xpath = "//input[@placeholder=' Supplier']")
	public static WebElement Suppliersearchtextbox;

	// Sample Supplier Search button XPath
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div[1]/button")
	public static WebElement Suppliersearchbutton;

	// Sample Supplier Search Reset XPath
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div[3]/button")
	public static WebElement Supplierreseticon;

	// Sample Supplier Search screen PopUp icon XPath
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div")
	public static WebElement Suppliersearchpopup;

// *********************In Process Sample Arrival Date Search XPath*************************
	// Sample Arrival Date Search icon XPath
	@FindBy(xpath = "(//span[@class='anticon anticon-search'])[7]")
	public static WebElement ArrivalDatesearchicon;

	// Sample Arrival Date Search text box XPath
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']/div/div[1]/div[1]/div[1]/input")
	public static WebElement ArrivalDatesearchtextbox;

	// Sample Arrival Date Search button XPath
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary ant-btn-sm'])[1]")
	public static WebElement ArrivalDatesearchbutton;

	// Sample Arrival Date Search Reset XPath
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-sm'])[1]")
	public static WebElement ArrivalDatereseticon;

	// Sample Arrival Date Search screen PopUp icon XPath
	@FindBy(xpath = "(//div[@class='ant-table-filter-dropdown'])[1]")
	public static WebElement ArrivalDatesearchpopup;

	// *********************In Process Sample Source Search
	// XPath*************************

	// Source Search icon XPath
	@FindBy(xpath = "(//span[@aria-label='search'])[12]")
	public static WebElement Sourcesearchicon;

	// Sample Source Search screen PopUp icon XPath
	@FindBy(xpath = "(//div[@class='ant-table-filter-dropdown'])[1]")
	public static WebElement Sourcesearchpopup;

	// Sample Source Search text box XPath
	@FindBy(xpath = "//input[@placeholder='  Source']")
	public static WebElement Sourcesearchtextbox;

	// Sample Source Search button XPath
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary ant-btn-sm'])[1]")
	public static WebElement Sourcesearchbutton;

	// Sample Source Search Reset XPath
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-sm'])[1]")
	public static WebElement Sourcereseticon;

//*********************In Process Sample BLLC Number Search XPath*************************

	// BLLC Number Search icon XPath
	@FindBy(xpath = "(//span[@aria-label='search'])[13]")
	public static WebElement Bllcsearchicon;

	// Sample BLLC Number Search screen PopUp icon XPath
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown'][1]")
	public static WebElement Bllcsearchpopup;

	// Sample BLLC Number Search text box XPath
	@FindBy(xpath = "//input[@placeholder=' BL/LC No']")
	public static WebElement Bllcsearchtextbox;

	// Sample BLLC Number Search button XPath
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary ant-btn-sm'])[1]")
	public static WebElement Bllcsearchbutton;

	// Sample BLLC Number Search Reset XPath
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-sm'])[1]")
	public static WebElement Bllcreseticon;

	// *********************In Process Sample QUALITY & BRAND RECEIVED Search
	// XPath*************************

	// GRN Search icon XPath
	@FindBy(xpath = "(//span[@aria-label='search'])[15]")
	public static WebElement QBRsearchicon;

	// Sample GRN Search screen PopUp icon XPath
	@FindBy(xpath = "(//div[@class='ant-table-filter-dropdown'])[1]")
	public static WebElement QBRsearchpopup;

	// Sample GRN Search text box XPath
	@FindBy(xpath = "//input[@placeholder=' Quantity & Brand Received']")
	public static WebElement QBRsearchtextbox;

	// Sample GRN Search button XPath
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div[1]/button")
	public static WebElement QBRsearchbutton;

	// Sample GRN Search Reset XPath
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-sm'])[1]")
	public static WebElement QBRreseticon;

//*********************In Process Sample DATE OF SAMPLING Search XPath*************************

	// DATE OF SAMPLING Search icon XPath
	@FindBy(xpath = "(//span[@aria-label='search'])[8]")
	public static WebElement DOSsearchicon;

	// Sample DATE OF SAMPLING Search screen PopUp icon XPath
	@FindBy(xpath = "(//div[@class='ant-table-filter-dropdown'])[1]")
	public static WebElement DOSsearchpopup;

	// Sample DATE OF SAMPLING Search text box XPath
	@FindBy(xpath = "//input[@placeholder=' Creation Date']")
	public static WebElement DOSsearchtextbox;

	// Sample DATE OF SAMPLING Search button XPath
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div[1]/button")
	public static WebElement DOSsearchbutton;

	// Sample DATE OF SAMPLING Search Reset XPath
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-sm'])[1]")
	public static WebElement DOSreseticon;

//*********************In Process Sample SAMPLING TIME Search XPath*************************

	// SAMPLING TIME Search icon XPath
	@FindBy(xpath = "(//span[@aria-label='search'])[9]")
	public static WebElement STsearchicon;

	// Sample SAMPLING TIME Search screen PopUp icon XPath
	@FindBy(xpath = "(//div[@class='ant-table-filter-dropdown'])[1]")
	public static WebElement STsearchpopup;

	// Sample SAMPLING TIME Search text box XPath
	@FindBy(xpath = "//input[@placeholder='  Sample Time']")
	public static WebElement STsearchtextbox;

	// Sample SAMPLING TIME Search button XPath
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div[1]/button")
	public static WebElement STsearchbutton;

	// Sample SAMPLING TIME Search Reset XPath
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-sm'])[1]")
	public static WebElement STreseticon;

//*********************In Process Sample STATUS Search XPath*************************

	// STATUS Search icon XPath
	@FindBy(xpath = "(//span[@aria-label='search'])[16]")
	public static WebElement STATUSsearchicon;

	// Sample STATUS Search screen PopUp icon XPath
	@FindBy(xpath = "(//div[@class='ant-table-filter-dropdown'])[1]")
	public static WebElement STATUSsearchpopup;

	// Sample STATUS Search text box XPath
	@FindBy(xpath = "//input[@id='status']")
	public static WebElement STATUSsearchtextbox;

	// Sample STATUS Search button XPath
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div[1]/button")
	public static WebElement STATUSsearchbutton;

	// Sample STATUS Search Reset XPath
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-sm'])[1]")
	public static WebElement STATUSreseticon;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[16]")
	public static List<WebElement> StatusColumn;

	// In-Process Sample Before Search XPath

	public static String InproBeforeSearch = "//div[@class='sc-bxivhb hSswcz']/div[";

	// In-Process Sample After Search XPath

	public static String InproAfterSearch = "]//span[@class='anticon anticon-key']";

//				Before and After of KEY Author : Priyanka
//				-----------------------------------------

	public static String InproKeyBefore = "(//div[@class='ant-modal-content'])[1]/div[2]/div/div[";
	public static String InproKeyAfter = "]/div[1]/div/li/span";

	// inprocess sample edit icon -- N.Karunya
	@FindBy(xpath = "//span[@aria-label='edit']//*[name()='svg']")
	public static WebElement inprocessSampleEditicon;

	// inprocess sample supplier category textbox -- N.Karunya
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[1]/div/div[1]/div/span[2]")
	public static WebElement supplierCategory;

	// inprocess sample sample code textbox -- N.Karunya
	@FindBy(xpath = "//input[@id='finishProductCode']")
	public static WebElement sampleCode;

	// inprocess sample supplier category textbox -- N.Karunya
	@FindBy(xpath = "//span[normalize-space()='Save']")
	public static WebElement Editsavebutton;

//**********Author:- @Sasikala
	// In Process Sample Table
	@FindBy(xpath = "//div[@class='ant-table-container']")
	public static WebElement InpSampleTable;

	// In Process more pop up
	@FindBy(xpath = "//html/body/div[3]/div/div/div/div[2]")
	public static WebElement InProcessMorePopup;

	// Test And Trail OK button XPath
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-default']")
	public static WebElement okbtn;

	// Test And Trail Cancel button XPath
	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement cancelbtn;

	// Model close
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement testAndTrialModal;

	// **********Author:- @RAHUL.S
	// Test date(Rahul.S-16/05/2023)
	@FindBy(xpath = "//*[@id=\"date\"]")
	public static WebElement testDate;

	// Remove date(Rahul.S-16/05/2023)
	@FindBy(xpath = "//span[@aria-label='close-circle']")
	public static WebElement dateCloseIcon;

	// Test Date Validation message(Rahul.S-16/05/2023)
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div[1]/div[1]/div[2]/div[1]/div[2]/div/div[2]")
	public static WebElement testDateValidation;

	// No of trail Text box message(Rahul.S-16/05/2023)
	@FindBy(xpath = "//*[@id=\"no_of_trial\"]")
	public static WebElement noOfTrailTextBox;

	// No of trail Validation message(Rahul.S-16/05/2023)
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div[1]/div[1]/div[2]/div[1]/div[3]/div/div[2]")
	public static WebElement noOfTrailValidation;

	// Submit Button(Rahul.S-15/05/2023)
	@FindBy(xpath = "//button[@type='button']")
	public static WebElement submitButton;
//**********Author:- @Sasikala ------------Date :- 15-05-2023

	// Trail added success message
	@FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-success ant-notification-notice-closable']")
	public static WebElement Trialaddsuccessmsg;

	// Test And Trail submit button XPath
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary sc-gZMcBi jVssxC']")
	public static WebElement trailsubmitbtn;

	// Test And Trail status field XPath
	@FindBy(xpath = "//input[@id='status']")
	public static WebElement trailstatusfield;

	// Test And Trail Procedure icon XPath
	@FindBy(xpath = "//span[@class='anticon anticon-read']")
	public static WebElement trailprocedureicon;

	// Test And Trail no of trail field XPath
	@FindBy(xpath = "//input[@id='no_of_trial']")
	public static WebElement nooftrailfield;

	// Test And Trail no of Procedure verify field XPath
	@FindBy(xpath = "//div[@class='ant-popover-title']")
	public static WebElement procedureverify;

	// Test And Trail Button XPath
	@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']")
	public static WebElement TrailBtn;

	// Test And Trail Date field XPath
	@FindBy(xpath = "//input[@id='date']")
	public static WebElement trailDatefield;

	// Test And Trail Go To Sample Link field XPath
	@FindBy(xpath = "//a[text()='Go To Samples']")
	public static WebElement gotosamplelink;
	
	

	//Trial validation message
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

	// Additional Information field XPath
	@FindBy(xpath = "//p[@class='sc-EHOje hUhOoM']")
	public static WebElement additionalInfoModel;

	// Additional Information ClearAll field XPath
	@FindBy(xpath = "//*[@id=\"test\"]/div[2]/div/div/div/div/button[1]")
	public static WebElement additionalInfoClearAll;
}
