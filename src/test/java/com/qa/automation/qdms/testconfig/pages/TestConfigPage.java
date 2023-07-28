package com.qa.automation.qdms.testconfig.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.qa.automation.qdms.base.DriverIntialization;

public class TestConfigPage extends DriverIntialization {
	// _________________________ X PATH TEST NAVIGATION
	// __________________________________
	@FindBy(xpath = "//div[@class='sc-gzVnrw geeJmJ test_basic_card']")
	public static WebElement TestNavigation;

	// ________________________ X PATH MATERIAL TEST ADD BUTTON
	// ___________________________
	// @FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']")
	// //_________________________ X PATH TEST NAVIGATION
	// __________________________________
	// @FindBy(xpath = "//a[contains(@class,'sc-bdVaJa')][@href='#/testcreate']")
	// public static WebElement TestNavigation;
	// ________________________ X PATH MATERIAL TEST ADD BUTTON
	// ___________________________
	// @FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']")
	// //_________________TC-PAR-0067________ X PATH TEST NAVIGATION
	// __________________________________
	// @FindBy(xpath = "//a[contains(@class,'sc-bdVaJa')][@href='#/testcreate']")
	// public static WebElement TestNavigation;

	// ________________________ X PATH MATERIAL TEST ADD BUTTON
	// ___________________________
	@FindBy(xpath = "//div[@class='ant-table-title']//button")
	public static WebElement addButton;

	// ________________________ X PATH TEST NAME PLACE HOLDER
	// ___________________________
	@FindBy(xpath = "//input[@id='test_name']")
	public static WebElement PlaceHolderTestName;

	// _________________________ X PATH SAVE BUTTON
	// ____________________________________
	@FindBy(xpath = "(//button[@type='button'])[5]")
	public static WebElement SaveButton;

	// _________________________ X PATH TABLE
	// _________________________________________
	@FindBy(xpath = "//div[@class='ant-table-content']")
	public static WebElement Table;

	// __________________________ X PATH EDIT
	// __________________________________________
	@FindBy(xpath = "(//span[@aria-label='edit'])")
	public static WebElement EditIcon;

	// __________________________ X PATH FOR TEXT
	// ____________________________________
	@FindBy(xpath = "(//div[@class='ant-typography'][normalize-space()='Parameter'])[1]")
	public static WebElement ParameterText;

	// ___________________________ X PATH FOR GROUP TEST
	// ____________________________
	@FindBy(xpath = "//div[@class='sc-dnqmqq fyMRQD'][normalize-space()='Group Tests']")
	public static WebElement GroupTest;

	// _____________________________ X PATH FOR ADD FORM
	// _____________________________
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement AddTestConfigForm;

	// ______________________________ X PATH FOR DELETE CANCEL BUTTON
	// ________________________
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement DeleteCanCelButtonTest;

	// ____________________________ X PATH FOR VALIDATION
	// __________________________________
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[2]")
	public static WebElement ValidationMessage;

	// _____________________________X PATH FOR VALIDATION OF ALREADY EXIT
	// _____________
	@FindBy(xpath = "//div[@class='input_wrapper']//div[1]")
	public static WebElement ValidationText;

	@FindBy(xpath = "//div[@class='sc-dnqmqq bEdMec'][normalize-space()='Test']")
	public static WebElement TestText;

	// _________________________________ CLOSE BUTTON ______________________________
	@FindBy(xpath = "//span[@aria-label='close-circle']")
	public static WebElement CloseButton;

	// _______________________________ CANCEL BUTTON
	// _________________________________
	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	public static WebElement CancelBtn;

	// _________________________________ TEST BTN
	// _______________________________________
	@FindBy(xpath = "//section/main/div/div/div[1]/div/div[1]/div[1]")
	public static WebElement TestBtn;

	// _______________________________ TEST DELETE BUTTON
	// ___________________________
	@FindBy(xpath = "(//span[@aria-label='delete'])")
	public static WebElement TestDeleteButton;

	// _________________________________ EDIT BUTTON TEST
	// ___________________________
	@FindBy(xpath = "(//span[@aria-label='edit'])")
	public static WebElement EditButtontest;

	// ======================== TEST CONFIGURE
	// =========================================

	// ____________________________________ MANAGE CONFIGURE
	// ____________________________
	@FindBy(xpath = "//a[@href='#/managetests']")
	public static WebElement ManageCofigureMenuBar;

	// ==================== MANAGE TEST CONFIGURE EQUATION ========================

	// _______________________ EDITE BUTTON - EDIT EQUATION
	// ___________________________
	@FindBy(xpath = "(//span[@aria-label='edit'])[11]")
	public static WebElement EditButtonAccepetdValue;

	// _________________________ EDIT VALIATAION MESSAGE
	// ______________________________
	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	public static WebElement EditValidationMessageAccepetedValue;

	// _________________________ ACCEPETED VALUE UPDATE
	// _______________________________
	@FindBy(xpath = "//span[normalize-space()='Update']")
	public static WebElement UpdateBtnAccepetVal;

	// ________________________ SAVE BUTTON ____________________________
	@FindBy(xpath = "(//button[@type='button'])[9]")
	public static WebElement EquationEditSaveButton;

	// ________________________ TABLE ____________________________________
	@FindBy(xpath = "//div[@class='ant-table-container']")
	public static WebElement TableManageConfigure;

	// __________________________ DELETE _______________________________
	@FindBy(xpath = "(//span[@aria-label='delete'])[11]")
	public static WebElement EquationDeleteBtn;

	// _______________________DELETE OK BTN ___________________
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement DeletOkButtonEquation;

	// __________________ VALIDATION ___________________________________
	@FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-warning ant-notification-notice-closable']")
	public static WebElement ValidationMessageAfterDependDelete;

	// MANAGE TEST EDIT KEY ICON
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[15]/span/span")
	public static WebElement Editconfi;

	// __________________________________TABLECOLUNM_______________________________________
	@FindBy(xpath = "(//tbody[@class='ant-table-tbody'])[4]/tr/td[1]")
	public static List<WebElement> TableColumSearchTable;

	// __________________________ TABLE
	// ________________________________________________
	@FindBy(xpath = "(//div[@class='ant-table-container'])[4]")
	public static WebElement TableSearchParameter;

	// _________________________________ TEST CONFIGURE SIDE BUTTON
	// ___________________
	@FindBy(xpath = "//div[contains(text(),'Test Configure')]")
	public static WebElement TestConfigureSideButton;

	// __________________________________ CONFIGURE TEST
	// _________________________________
	@FindBy(xpath = "//div[@class='ant-steps-item ant-steps-item-finish']//div[@class='ant-steps-item-icon']")
	public static WebElement ConfigureTest;

	// __________________________________ CONFIGURE TEST
	// _________________________________
	@FindBy(xpath = "//div[@class='sc-bxivhb kvnLPi']//div[@class='sc-bxivhb fZlIKa']")
	public static WebElement ConfigureTestTable;

	// __________________________________ NEXT BUTTON
	// __________________________________
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary']")
	public static WebElement NextBtnConfigureTest;

	// ___________________________________ PARAMETER SEARCH ICON
	// ________________________
	@FindBy(xpath = "//div[@class='ant-table ant-table-fixed-header']//span[@aria-label='search']")
	public static WebElement ParameterSearchIcon;

	// __________________________________ PARAMERTE SEARCH TEXT BOX
	// ________________________
	@FindBy(xpath = "//input[contains(@placeholder,'Parameter')]")
	public static WebElement ParameterTextBox;

	// __________________________________ PARAMERTERRESET
	// ____________________________
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement ParameterReset;

	// _______________________________ SEARCH BUTTON PARAMETER
	// ______________________
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement SearchButtonParameter;

	// _______________________________ TEST PARAMETER NAVIGATION STEP 2
	// _______________________________
	@FindBy(xpath = "//span[@class='ant-steps-icon'][normalize-space()='2']")
	public static WebElement TestParameterStepTwo;

	// _______________________________ TEST PARAMETER NAVIGATION STEP 7
	// _______________________________
	@FindBy(xpath = "(//div[@role='button'])[7]")
	public static WebElement TestParameterStepSeven;

	// ______________________________ DATA TYPE SEARCH ICON
	// _____________________________________
	@FindBy(xpath = "(//span[@aria-label='search'])[2]")
	public static WebElement SearchIconDataType;

	// ________________________________ DATA TYPE SEARCH BUTTON
	// ________________________________
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement SeachButtonDataType;

	// ________________________________ DATA TYPE PLACE HOLDER
	// ________________________
	@FindBy(xpath = "//div[@name='parameterDataType']//div[@class='ant-select-selector']")
	public static WebElement PlaceHolderSearchDataType;

	// __________________________________ DATA TYPE RESET
	// ______________________________
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement DataTypeReset;

	// ___________________________________ SEARCH ICON
	// __________________________________
	@FindBy(xpath = "//th[@class='ant-table-cell ant-table-cell-fix-left ant-table-cell-fix-left-last']//span[@role='button']")
	public static WebElement outSideSearchIcon;

	// _______________________________ SEARCH PLACE HOLDER
	// _____________________________________
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//input")
	public static WebElement SearchPlaceHolder;

	// ________________________________ SEARCH INSIDE
	// ________________________________
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//button[1]")
	public static WebElement SearchBtn;

	// __________________________________ RESET BUTTON
	// _________________________________
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//button[2]")
	public static WebElement ResetBtn;

	// _____________________________ RESETALL BUTTON
	// ___________________________________
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-danger ant-btn-background-ghost']")
	public static WebElement ResetAllBtn;

	// _______________________________ MANAGE CONFIGURE
	// ____________________________________
	@FindBy(xpath = "//a[@href='#/managetests']")
	public static WebElement MANGECONFIGURE;

	// ________________________________ TEST CODE COLOUM
	// ____________________________________
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> testColoum;
	// __________________________________ TEST COLUM
	// _________________________________
	public static String TestSearchColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String TestSearchColumnAfter = "]/td[1]";
	public static String TestColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String TestColumnAfter = "]/td[2]";

	// ======================== GROUP TEST SEARCH ICONE
	// ==================================================

	@FindBy(xpath = "(//span[@role='button'])[3]")
	public static WebElement SearchIconGroupName;

	// ============================= GROUP TEST SEARCH TEXTBOE
	// =======================================
	@FindBy(xpath = "//input[contains(@placeholder,'Group Name')]")
	public static WebElement SearchGroupNameTextBox;

	// =========================== SEARCH BUTTON
	// ============================================
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement SearchButtonGroupName;

	// ============================ RESET BUTTON
	// =========================================
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement ResetButtonGroupName;

	// ============================= SEARCH TEXT BOX - GRIUP
	// ==========================
	@FindBy(xpath = "//input[contains(@placeholder,'Parameter')]")
	public static WebElement GroupTestParameterSearchTextBox;

	// ========================= DELETE BUTTON
	// =========================================
	@FindBy(xpath = "//span[@aria-label='delete']")
	public static WebElement DeletButtonGroupTest;

	// =========================== TABLE
	// ROW==========================================
	@FindBy(xpath = "//tr[@class='ant-table-row ant-table-row-level-0']")
	public static WebElement TableRowGroupTest;

	// =========================== TABLE ==========================================
	@FindBy(xpath = "//div[@class='ant-table-content']")
	public static WebElement TableFullGroupTest;
	// ============================= GROUP TEST DETETEOK
	// =============================
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement OkDeleteBtnGroupTest;

	// ================================= TABLE ROW
	// ==================================
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement TableOfGrouPTest;

	@FindBy(xpath = "//span[normalize-space()='Parameter']")
	public static WebElement parameterheading;

	// * Test Configuration Card

	@FindBy(xpath = "//div[@class='sc-htpNat boOfVg']")
	public static WebElement testconfigurationcard;

	// * Test Configuration Home Text
	@FindBy(xpath = "//div[normalize-space()='TEST CONFIGURATION']")
	public static WebElement testconfigurationtext;

	// * Top Navigation Test Button
	@FindBy(xpath = "//a[@href='#/testcreate']")
	public static WebElement testtopnav;

	// * Left Navigation Test Button
	@FindBy(xpath = "//div[@class='sc-dnqmqq bEdMec'][normalize-space()='Test']")
	public static WebElement testleftnav;

	// * Left Navigation Test Parameter Button
	@FindBy(xpath = "//div[contains(text(),'Test Parameter')]")
	public static WebElement testparameterleftnav;

	// * Left Navigation Test Configure Button
	@FindBy(xpath = "//div[contains(text(),'Test Configure')]")
	public static WebElement testconfigleftnav;

	// * Left Navigation Config Group Test Button
	@FindBy(xpath = "//div[@class='sc-dnqmqq bxMwVY']")
	public static WebElement configgrouptestleftnav;

	// test parameter table heading
	@FindBy(xpath = "//div[contains(@class,'ant-typography')][normalize-space()='Parameter']")
	public static WebElement testParametertableHeading;

	@FindBy(xpath = "//div[@class='sc-htpNat boOfVg']//div[@class='flex-card-home']")
	public static WebElement testconfiguration;

	@FindBy(xpath = "//div[contains(text(),'Configure Test')]")
	public static WebElement testconfigurationheading;

	//////////////// NILUX
	// SEARCH ICON FOR TEST
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div/table/thead/tr/th[1]/div/span[2]/span")
	public static WebElement SearchTestIcon;

	// SEARCH TEXTBOX FOR TEST
	@FindBy(xpath = "//input[@placeholder=' Test']")
	public static WebElement SearchTestTextBox;

	// SEARCH TEXTBOX FOR TEST
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement SearchTestSearchbutton;

	// COLOUM NO FOR TEST
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> tableColoumno;

	// DELETE OK BUTTON FOR TEST
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement deleteButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div/div[2]/div[5]/button")
	public static WebElement SubmitButton;

	@FindBy(xpath = "//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']/li[@title='Previous Page']//button")
	public static WebElement previousbt;

	@FindBy(xpath = "//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']/li[@title='Next Page']//button")
	public static WebElement nextbt;

	@FindBy(xpath = "//a[normalize-space()='2']")
	public static WebElement pag2nd;

	@FindBy(xpath = "//a[normalize-space()='1']")
	public static WebElement pag1st;

	@FindBy(xpath = "//span[@title='10 / page']")
	public static WebElement pagdrp;

	public static String bef = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/ul/li[7]/div/div[2]/div/div/div/div[2]/div/div/div/div[";
	public static String aft = "]";

	// TABLE CONTAINER

	@FindBy(xpath = "//div[@class='ant-table-container']")
	public static WebElement tableContainer;

	// RESET BUTTON TEXT
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement Resetbutton;

	@FindBy(xpath = "//span[normalize-space()='Reset']")
	public static WebElement Resetbuttonmaincat;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[1]")
	public static WebElement ManageTestcard;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[3]/div/span[2]/span")
	public static WebElement Maincategorysearchicon;

	@FindBy(xpath = "//input[@placeholder='Main Category']")
	public static WebElement Maincategorysearchtextbox;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement Maincategorysearchbutton;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement Maincategoryresetbutton;

	// COLOUM NO FOR MAIN CATGORY
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[3]")
	public static List<WebElement> tableColoumnoMaincategory;

	// SEARCH ICON TEST TYPE IN MANAGE TEST
	@FindBy(xpath = "//th[6]//div[1]//span[2]//span[1]")
	public static WebElement testtypesearchicon;

	// SEARCH TEXTBOX TEST TYPE IN MANAGE TEST
	@FindBy(xpath = "//input[@id='mainType']")
	public static WebElement testtypesearchTextbox;

	// SEARCH BUTTON TEST TYPE IN MANAGE TEST
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[2]/button[1]/span[1]")
	public static WebElement testtypesearchButton;

	// SEARCH BUTTON TEST TYPE IN MANAGE TEST
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement testtypeResetButton;

	// COLOUM NO FOR TEST TYPE
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[6]")
	public static List<WebElement> tableColoumnoTestType;

	// SEARCH ICON TEST TYPE IN DUE DAY
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[7]/div/span[2]/span")
	public static WebElement DueDaysearchicon;

	// SEARCH TEXTBOX TEST TYPE IN DUE DAY
	@FindBy(xpath = "//input[@placeholder='Due Day']")
	public static WebElement DueDaysearchTextbox;

	// SEARCH BUTTON TEST TYPE IN DUE DAY
	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']//button[1]")
	public static WebElement DueDaysearchButton;

	// SEARCH BUTTON TEST TYPE IN DUE DAY
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/button[2]")
	public static WebElement DueDayResetButton;

	// COLOUM NO FOR TEST TYPE
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[7]")
	public static List<WebElement> tableColoumnoDueDay;

	// * Success Message
	@FindBy(xpath = "//div[contains(@class,'ant-notification ant-notification-topRight')]//div")
	public static WebElement successMsg;

	// * Success Message for additional infomation
	@FindBy(xpath = "//*[text()='Test Records Added Sucessfully']")
	public static WebElement successMsgadditionalinfo;

	// warning message
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[5]")
	public static WebElement editmsgfordepended;

	// * Table Count
	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	public static WebElement tablecount;

	/* Manage Test Configure */

	// * Manage Test
	@FindBy(xpath = "//div[contains(text(),'Manage Tests')]")
	public static WebElement managetest;

	// MANAGE TEST LEFT BUTON
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[1]/div[1]")
	public static WebElement manageTest;

	// MULTI SEARCH FUNCTION IN GROUP TEST

	// GROUP NAME ICON IN GROUP TEST
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/form/div/div/div/div/div[2]/div/table/thead/tr/th[1]/div/span[2]/span")
	public static WebElement Groupnameicon;

	// GROUP NAME SEARCHBOX IN GROUP TEST
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/input")
	public static WebElement Groupnamesearchbox;

	// GROUP NAME SEARCHBUTTON IN GROUP TEST
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/button[1]")
	public static WebElement Groupnamesearchbutton;

	// COLOUM NO FOR GROUP NAME
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> tableColoumnogroupname;

	///////////////
	// MAIN CATEGORY ICON IN GROUP TEST
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/form/div/div/div/div/div[2]/div/table/thead/tr/th[2]/div/span[2]/span")
	public static WebElement maincategorygroupicon;

	// MAIN CATEGORY SEARCHBOX IN GROUP TEST
	@FindBy(xpath = "//input[@placeholder=' Category Name']")
	public static WebElement maincategorygroupsearchbox;

	// MAIN CATEGORY SEARCHBUTTON IN GROUP TEST
	@FindBy(xpath = "(//div[@class='ant-table-filter-dropdown'])[2]/div/div/button[1]")
	public static WebElement maincategorygroupsearchbutton;

	// COLOUM NO FOR MAIN CATEGOR
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[2]")
	public static List<WebElement> tableColoumnomaincategorygroup;

	///////////////

	// SUB CATEGORY ICON IN GROUP TEST
	@FindBy(xpath = "//thead/tr/th[3]/div/span[2]")
	public static WebElement subcategorygroupicon;

	// SUB CATEGORY SEARCHBOX IN GROUP TEST
	@FindBy(xpath = "//input[@placeholder=' Sub Category Name']")
	public static WebElement subcategorygroupsearchbox;

	// SUB CATEGORY SEARCHBUTTON IN GROUP TEST
	@FindBy(xpath = "(//div[@class='ant-table-filter-dropdown'])[3]/div/div/button[1]")
	public static WebElement subcategorygroupsearchbutton;

	// COLOUM NO FOR SUB CATEGORY
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[3]")
	public static List<WebElement> tableColoumnosubcategorygroup;

	// RAW MATERIAL ICON IN GROUP TEST
	@FindBy(xpath = "//th[4]//div[1]//span[2]//span[1]")
	public static WebElement rawmaterialgroupicon;

	// RAW MATERIAL SEARCHBOX IN GROUP TEST
	@FindBy(xpath = "//input[@placeholder=' Raw Material Name']")
	public static WebElement rawmaterialgroupsearchbox;

	// RAW MATERIAL SEARCHBUTTON IN GROUP TEST
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown'])[4]/div/div/button[1]")
	public static WebElement rawmaterialgroupsearchbutton;

	// COLOUM NO FOR RAW MATERIAL
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[4]")
	public static List<WebElement> tableColoumnosrawmaterialgroup;

	// GROUP TYPE ICON IN GROUP TEST
	@FindBy(xpath = "//th[5]//div[1]//span[2]//span[1]")
	public static WebElement grouptypegroupicon;

	// GROUP TYPE SEARCHBOX IN GROUP TEST
	@FindBy(xpath = "//input[@id='groupType']")
	public static WebElement grouptypegroupsearchbox;

	// GROUP TYPE SEARCHBUTTON IN GROUP TEST
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown'])[5]/div/div/button[1]")
	public static WebElement grouptypegroupsearchbutton;

	// COLOUM NO FOR GROUP TYPE
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[5]")
	public static List<WebElement> tableColoumnosgrouptypegroup;
	/////////////
	// RESET ALL IN GROUP TEST
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/form/div/div/div/div/div[1]/div/button")
	public static WebElement ResetAllButtongroup;

	/* Configure Test */

	// * Test Field DropDown
	@FindBy(xpath = "//div[@name='test']//div[@class='ant-select-selector']/..")
	public static WebElement testfield;

	// * Test Type Field DropDown
	@FindBy(xpath = "//div[@name='test_type']//div[@class='ant-select-selector']")
	public static WebElement testtype;

	// * Prefix Field DropDown
	@FindBy(xpath = "//input[@id='prefix']")
	public static WebElement prefix;

	// * Main Category Field DropDown
	@FindBy(xpath = "//div[@name='main_category']//div[@class='ant-select-selector']")
	public static WebElement maincategory;

	// * Report Field DropDown
	@FindBy(xpath = "//div[@name='report_format']//div[@class='ant-select-selector']")
	public static WebElement reportfield;

	// * Submit Field DropDown
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-submit sc-gZMcBi jVssxC']")
	public static WebElement submitbtn;

	// * Test Validation
	@FindBy(xpath = "(//div[normalize-space()=\"Test can't be empty\"])[1]")
	public static WebElement testvalidation;

	// * Test Type Validation
	@FindBy(xpath = "(//div[normalize-space()=\"Test Type can't be empty\"])[1]")
	public static WebElement testtypevalidation;

	// * Prefix Empty Validation
	@FindBy(xpath = "(//div[normalize-space()=\"Prefix can't be empty\"])[1]")
	public static WebElement prefixemptyvalidation;

	// * Prefix allow only letters and Numbers Validation
	@FindBy(xpath = "//div[normalize-space()='Prefix allow only letters and Numbers']")
	public static WebElement prefixnumbervalidation;

	// * Material Main Validation
	@FindBy(xpath = "(//div[normalize-space()=\"Material Main Category can't be empty\"])[1]")
	public static WebElement materialmainvalidation;

	// * Report Validation
	@FindBy(xpath = "//div[@class=\"sc-bxivhb fZlIKa\"]/div/div/div[4]/div[1]/div/div[2]")
	public static WebElement reportvalidation;

	///////////////////

	// MANAGE TEST EDIT KEY ICON
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[15]/span/span")
	public static WebElement Editkeyiconinmanagetest;

	//////// TEST CONFIGURE///////

	// ADD TEST PARAMETER BUTTON IN TEST CONGIG
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div/form[1]/div/div/div/div/div[1]/div/div/div[4]/div[2]/button")
	public static WebElement AddTestparameterButton;

	// PARAMETER TEXT BOX
	@FindBy(xpath = "//*[@id=\"parameter_name\"]")
	public static WebElement parametertextbox;

	// PARAMETER TEXT BOX
	@FindBy(xpath = "//*[@id=\"parameterDataType\"]")
	public static WebElement parameterTypetextbox;

	// PARAMETER SAVE BUTTON
	@FindBy(xpath = "//div[@class=\"ant-modal-content\"]/div[3]//button[@class=\"ant-btn sc-gZMcBi dMdnOw\"][1]")
	public static WebElement parametersavebutton;

	// TEST PARAMETER ICON IN TEST CONFIGURE
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div[2]/div/div[2]")
	public static WebElement TestparameterRadiobuttonTCicon;

	// TEST PARAMETER ICON IN TEST CONFIGURE
	@FindBy(xpath = "	//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div/form[1]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]/span")
	public static WebElement TestparametersearchTCicon;

	// TEST PARAMETER SEARCHBOX IN TEST CONFIGURE
	@FindBy(xpath = "//input[@placeholder=' Parameter']")
	public static WebElement TestparameterTCisearchbox;

	// TEST PARAMETER SEARCHBUTTON IN TEST CONFIGURE
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/button[1]")
	public static WebElement TestparameterTCisearchbutton;

	// COLOUM NO FOR TEST PARAMETER
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> tableColoumnosTestparameterTCi;

	// TEST PARAMETER SEARCHBUTTON IN TEST CONFIGURE
	@FindBy(xpath = "//span[@aria-label='close-circle']")
	public static WebElement addparameterTClosebuttoninTC;

	// TEST PARAMETER SEARCHBUTTON IN TEST CONFIGURE
	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	public static WebElement addparameterTCancelbuttoninTC;

	// TEST PARAMETER MODEL INDOW
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement addparameterModelwindow;

	// TEST PARAMETER ADD PARAMETER CONTAINER IN TEST CONFIGURE
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]")
	public static WebElement addparameterTablecontainerinTC;

	// TEST PARAMETER FIRST ROW
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div/form[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement TestparamfirstroTablecontainerinTC;

	// TEST PARAMETER TABLEROW IN TEST CONFIGURE
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div/form[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement Tablerowtestparameter;

	// ADD GROUP PAGINATION//
	// ADD GROUP BUTTON
	@FindBy(xpath = "//span[normalize-space()='Add Group']")
	public static WebElement Addgroupbuttonintc;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div/div/ul/li[1]")
	public static WebElement previousbtgp;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div/div/ul/li[9]")
	public static WebElement nextbtgp;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div/div/ul/li[3]")
	public static WebElement pag2ndgp;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div/div/ul/li[2]")
	public static WebElement pag1stgp;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div/div/ul/li[10]/div")
	public static WebElement pagdrpgp;

	public static String befgp = "/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div/div/ul/li[10]/div/div[1]/span[2]";
	public static String aftgp = "]/div";

	// * Parameter Pagination
	public static String configbefore = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div/form[1]/div/div/div/ul/li[11]/div/div[2]/div/div/div/div[2]/div/div/div/div[";
	public static String configafter = "]";

	// * DropDown
	@FindBy(xpath = "//div[@class='ant-select-selector']")
	public static WebElement dropdown;

	////////////// GROUP KEY///////////

	@FindBy(xpath = "//input[@placeholder='Enter GroupKey']")
	public static WebElement Groupkeytextbox;

	@FindBy(xpath = "//span[@aria-label='plus-square']")
	public static WebElement Groupkeyplusicon;

	@FindBy(xpath = "//button[@class=\"ant-btn ant-btn-danger ant-btn-background-ghost mr10\"]")
	public static WebElement Groupkeyremovebutton;

	@FindBy(xpath = "//span[@aria-label='close']")
	public static WebElement GroupkeyCrossicon;

	// ADD GROUP KEY BUTTON
	@FindBy(xpath = "//*[text()='Add Groupkeys']")
	public static WebElement addConfigGroupbutton;

	// TEST PARAMETER TABLE CONTAINER
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div/form[2]/div/div/div/div/div[2]")
	public static WebElement testparametertablecontainer;

	// TEST PARAMETER TABLE FIRST ROW
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div/form[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]")
	public static WebElement testparametertablefirstrow;

	// TALE FIRST CLOUMN
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div/form[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement tablefirstcloum;

	// TALE SECOND CLOUMN
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div/form[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[2]")
	public static WebElement tableSecondcloum;

	// REVIEW TEST TABLE IN TEST CONFIG
	@FindBy(xpath = "//div/div/div/div/div/div/form[3]//div[@class='ant-table-container']")
	public static WebElement tablecontainerreviewtest;

	// DELETE OK BUTTON

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement Reviewtestdeleteok;

	// DELETE CANCEL BUTTON
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[1]/span")
	public static WebElement Reviewtestdeletecancelbutton;

	// EDIT IN REVIEW TEST IN TEST CONFIG//
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div/form[3]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement tablefirstrow;

	@FindBy(xpath = "//div[@name='editParameter']")
	public static WebElement parametertextboxreviewtest;

	@FindBy(xpath = "//span[@title='Input']")
	public static WebElement typetextboxreviewtest;

	@FindBy(xpath = "//div[@name='editUnitId']")
	public static WebElement unittextboxreviewtest;

	@FindBy(xpath = "//input[@id='Abbrivation']")
	public static WebElement abbriviationtextboxreviewtest;

	@FindBy(xpath = "//span[@title='Observe']")
	public static WebElement inputmethodtextboxreviewtest;

	@FindBy(xpath = "//input[@id='relevant']/..")
	public static WebElement releventcheckboxreviewtest;

	@FindBy(xpath = "//input[@id='editDecimalType']")
	public static WebElement decimaaltextboxreviewtest;

	@FindBy(xpath = "//span[normalize-space()='Update']")
	public static WebElement updatebuttonreviewtest;

	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	public static WebElement cancelbuttonreviewtest;

	@FindBy(xpath = "//span[@aria-label='close']")
	public static WebElement closebuttonreviewtest;

	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement reviewdeleteopenmodelwindow;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div[2]	")
	public static WebElement validationmessageedit_reviewtest;

	/////////////// MANAGE TEST-EQUATION//////////////
	// EAUTION EDIT ICON
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[10]/span/span")
	public static WebElement Editquation_managetest;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/div/div/div[2]/div/table/tbody/tr/td[5]/span/a[1]/span")
	public static WebElement ConfigureEquationedit;

	@FindBy(xpath = "//input[@id='equation_formula']")
	public static WebElement Textboxequation;

	@FindBy(xpath = "//*[text()='Edit Equation']/../../div[@class=\"ant-modal-body\"]/div[1]")
	public static WebElement abovevalidationeditfinddefault;

	@FindBy(xpath = "//div[@class='ant-modal-body']//div[3]")
	public static WebElement belowvalidationeditfind;

	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement cancelbuttoninequationedit;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')])[1]")
	public static WebElement cancelbuttoninequationconfigure;

	/////// ADITIONAL INFORMATION EDIT CANCEL////

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/form/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[5]/span/a[1]/span")
	public static WebElement editiconAditionalinfo;

	@FindBy(xpath = "//td[@class='ant-table-cell']//input[@id='caption']")
	public static WebElement captiontextboxAditionalinfo;

	@FindBy(xpath = "//div[@class='ant-input-number-input-wrap']//input[@id='length']")
	public static WebElement maxlengthtextboxAditionalinfo;

	@FindBy(xpath = "//span[@title='HEADER']")
	public static WebElement typetextboxAditionalinfo;

	@FindBy(xpath = "//a[normalize-space()='Save']")
	public static WebElement SavebuttonAditionalinfo;

	@FindBy(xpath = "//a[normalize-space()='Cancel']")
	public static WebElement CancelbuttonAditionalinfo;

	@FindBy(xpath = "/html/body/div[4]/div/div/div")
	public static WebElement CancelmodalwindowAditionalinfo;

	@FindBy(xpath = "//div[@class='ant-popover-message-title']")
	public static WebElement HeadingmodalwindowAditionalinfo;

	@FindBy(xpath = "//input[@id='active']")
	public static WebElement checkboxactiveAditionalinfo;

	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	public static WebElement Cancelbuttonnewmodalwindow;

	@FindBy(xpath = "//span[normalize-space()='OK']")
	public static WebElement CancelmodalwindowOKBUTTONAditionalinfo;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/div/button")
	public static WebElement ClosemodalwindowAditionalinfo;

	///////////////////

	/* Accepted Criteria Material Individual Search */
	// * Material Radio Button
	@FindBy(xpath = "(//span[@class='ant-radio'])[2]")
	public static WebElement materialradiobtn;

	// * Individual Radio Button
	@FindBy(xpath = "(//span[contains(@class,'ant-radio')])[7]")
	public static WebElement individualradiobtn;

	// * Test Parameter Validation
	@FindBy(xpath = "//p[normalize-space()='Equation is Invalid']")
	public static WebElement equationvalidation;

	// * Save Button
	@FindBy(xpath = "//span[normalize-space()='Save Equation']")
	public static WebElement eqsavebtn;

	// * Result Radio Button
	@FindBy(xpath = "//*[@id='equationType']/label[2]/span[1]")
	public static WebElement resultradiobtn;

	// * Configure Equation circle
	@FindBy(xpath = "(//div[@class='ant-steps-item-icon'])[3]")
	public static WebElement configureequation;

	// * Accepted Condition
	@FindBy(xpath = "(//div[contains(@class,'ant-steps-item-icon')])[6]")
	public static WebElement Acceptedcondition;

	// * Additional Information
	@FindBy(xpath = "(//div[contains(@class,'ant-steps-item-icon')])[7]")
	public static WebElement Additionalinformation;

	// * Review Test
	@FindBy(xpath = "(//div[contains(@class,'ant-steps-item-icon')])[8]")
	public static WebElement Reviewtest;

	@FindBy(xpath = "//div[@class='ant-steps-item ant-steps-item-wait'][3]")
	public static WebElement acceptedcriteriatab;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div/div/div")
	public static WebElement acceptedvalueheading;

	@FindBy(xpath = "//input[@placeholder='minimum']")
	public static WebElement minimumplaceholder;

	@FindBy(xpath = "/html/body/div[4]/div/div[2]/div/div[2]/div[2]")
	public static WebElement editacceptedmodal;

	@FindBy(xpath = "//*[@id='finishPDAcMin']")
	public static WebElement minimumvalue;

	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement previousbutton;

	@FindBy(xpath = "//div[@class='sc-bxivhb OOFJv equation_wrapper']")
	public static WebElement calculator;

	@FindBy(xpath = "//div[@class='ant-steps-item ant-steps-item-process ant-steps-item-active']")
	public static WebElement configureEquiationselect;

	// * Additional Information Caption Validation
	@FindBy(xpath = "//form[@id='test']/div/div[1]/div/div/div[2]/div")
	public static WebElement captionvalidaion;

	// * Additional Information Record Type Validation
	@FindBy(xpath = "//form[@id='test']/div/div[2]/div/div/div[2]/div")
	public static WebElement recordtypevalidaion;

	// * Additional Information Max Length Validation
	@FindBy(xpath = "//form[@id='test']/div/div[3]/div/div/div[2]/div")
	public static WebElement maxlengthvalidaion;

	// * Additional Information Add Button
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div/form/form/div[3]/div/div/div/div[2]/button[2]")
	public static WebElement addbtn;

	// * Additional Table Container
	@FindBy(xpath = "(//div[@class='ant-spin-container'])[2]")
	public static WebElement additionaltable;

	// * Caption Edit Validation Field
	@FindBy(xpath = "(//input[@id='caption'])[2]")
	public static WebElement caption;

	// * Max Length Edit Validation Field
	@FindBy(xpath = "(//input[@id='length'])[2]")
	public static WebElement maxlength;

	// * Caption Validation
	@FindBy(xpath = "//div[contains(text(),'Please Input Caption!')]")
	public static WebElement captionvalidation;

	// * Caption Validation
	@FindBy(xpath = "//div[contains(text(),'Please Input Max length!')]")
	public static WebElement maxlengthvalidation;

	// * Additional Save Button
	@FindBy(xpath = "//a[normalize-space()='Save']")
	public static WebElement savebtnadditional;

	// * Test Dropdown Field
	@FindBy(xpath = "//div[contains(@name,'parameter')]//div[contains(@class,'ant-select-selector')]")
	public static WebElement individualdropdown;

	// * Material Search Box Field
	@FindBy(xpath = "//input[@placeholder='Search name']")
	public static WebElement materialsearchbox;

	// * Search icon
	@FindBy(xpath = "(//span[contains(@role,'button')])[1]")
	public static WebElement searchicon;

	// * Search Button
	@FindBy(xpath = "//div[@class=\"ant-table-filter-dropdown\"]/div/div/div/button[@class=\"ant-btn ant-btn-primary ant-btn-sm\"]")
	public static WebElement searchbtn;

	// * Reset Button
	@FindBy(xpath = "//div[contains(@class,'ant-space-item')]//span[contains(text(),'Reset')]")
	public static WebElement resetbtn;

	// * Table Container
	@FindBy(xpath = "(//div[@class='ant-table-container'])[1]")
	public static WebElement materialtablecontainer;

	@FindBy(xpath = "//div[contains(text(),'Test Configure ')]")
	public static WebElement testconfigureleftnavigation;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div/div[1]")
	public static WebElement testconfiguretableHeading;

	@FindBy(xpath = "(//div[@class='ant-steps-item-title'])[5]/p")
	public static WebElement acceptedcondtiontab;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/h2")
	public static WebElement addconditionheading;

	/* Equation Edit */
	// * Equation Table Container
	@FindBy(xpath = "(//div[@class='ant-table-container'])[2]")
	public static WebElement equationtablecontainer;

	// * Equation Test Depend Validation Message
	@FindBy(xpath = "//div[normalize-space()='Test Depend']")
	public static WebElement testdependValidationmsg;

	// * Edit Equipment Save Button
	@FindBy(xpath = "//div[@class='ant-modal-content']//button[2]")
	public static WebElement savebtn;

	// * Edit Equipment Save Button2
	@FindBy(xpath = "(//button[@type='button'])[9]")
	public static WebElement savebtnn;

	// * Edit Equipment Update Button
	@FindBy(xpath = "(//button[@type='button'])[8]")
	public static WebElement updatebtn;

	// * Edit Equipment Cancel Button
	@FindBy(xpath = "(//div[@class='ant-modal-footer'])[2]/div/button[1]")
	public static WebElement cancelbtn;

	// * Edit Equipment Cancel Button
	@FindBy(xpath = "(//button[@type='button'])[6]")
	public static WebElement equipmentcancelbtn;

	// * Configure Equipment Table container
	@FindBy(xpath = "//div[@class='ant-table-container']")
	public static WebElement equipmenttablecontainer;

	/* Validation */

	// * Configure Equipment Validation
	@FindBy(xpath = "(//div[normalize-space()=\"Equation Type can't be empty\"])[1]")
	public static WebElement equipmenttypevalidation;

	// * Test Parameter Validation
	@FindBy(xpath = "(//div[normalize-space()=\"Test Parameter can't be empty\"])[1]")
	public static WebElement testparametervalidation;

	@FindBy(xpath = "//div[@class='ant-steps-item ant-steps-item-wait'][2]")
	public static WebElement configureequatab;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement deleteconfirmationokbutton;

	/* Tab Page */
	// * Configure Test
	@FindBy(xpath = "(//div[contains(@class,'ant-steps-item-icon')])[1]")
	public static WebElement configuretest;

	// * Test Parameter
	@FindBy(xpath = "(//div[contains(@class,'ant-steps-item-icon')])[2]")
	public static WebElement TestParameter;

	// * Configure Equation
	@FindBy(xpath = "(//div[contains(@class,'ant-steps-item-icon')])[3]")
	public static WebElement Configureequation;

	// * Accepted Criteria
	@FindBy(xpath = "(//div[contains(@class,'ant-steps-item-icon')])[4]")
	public static WebElement Acceptedcriteria;

	// * AddKey Test
	@FindBy(xpath = "//main/div/div/div[2]/div/div[1]/div/div/div[5]/div/div[2]")
	public static WebElement addkeytest;

	// * Add Key Test
	@FindBy(xpath = "//main/div/div/div[2]/div/div[1]/div/div/div[5]//p")
	public static WebElement Addkeytest;

	// * Additional Information first row
	@FindBy(xpath = "//div[@class='ant-table-body']/table//tr[2]//td[1]")
	public static WebElement additionalinfofirstrowdata;

	// * Additional Information window heading
	@FindBy(xpath = "//p[@class='sc-EHOje hUhOoM']")
	public static WebElement additionalheading;

	// CONFIG TEST TAB HEADING IN TEST CONFIGURE
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div/div[1]")
	public static WebElement configtesttabheading;

	@FindBy(xpath = "//div[@class='ant-popover-inner-content']")
	public static WebElement deleteconfirmationpopup;
	// CONFIG EQUATION TAB HEADING IN TEST CONFIGURE
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div[3]/div/div[3]/div/p")
	public static WebElement configEquationtabheading;

	// * ACCEPTED CRETIERIA NEXT BUTTON
	@FindBy(xpath = "//span[normalize-space()='Next']")
	public static WebElement acceptedcretnextbutton;

	// * ACCEPTED CRETIERIA PREVIOUS BUTTON
	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement acceptedcretpreviousbutton;

	// * ACCEPTED CRETIERIA PREVIOUS BUTTON EXPECTED HEADING
	@FindBy(xpath = "//th[@class='ant-table-cell']")
	public static WebElement acceptedcretheading;

	// * ACCEPTED CRETIERIA RESET BUTTON
	@FindBy(xpath = "//span[normalize-space()='Reset']")
	public static WebElement acceptedcretresetbutton;

	// Material TextBox
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']/div/input")
	public static WebElement MaterialTextBox;

	// * ACCEPTED CRETIERIA TAB
	@FindBy(xpath = "//p[contains(text(),'Accepted criteria')]")
	public static WebElement acceptedcriteria;

	// * ACCEPTED CRETIERIA VALUE
	@FindBy(xpath = "//h3[normalize-space()='Accepted Value']")
	public static WebElement acceptedvalue;

	// Accepted window heading
	@FindBy(xpath = "//div[@class='sc-VigVT empmzV']/p")
	public static WebElement acceptheading;

	// * PARAMETER VALUE
	@FindBy(xpath = "(//span[normalize-space()='Parameter'])[1]")
	public static WebElement parametervalue;

	// * Add Condition Heading
	@FindBy(xpath = "//h2[normalize-space()='Add Condition']")
	public static WebElement addcondition;

	// * Equation Type Heading
	@FindBy(xpath = "//label[normalize-space()='Equation Type']")
	public static WebElement equationtypeheading;

	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement lastcancelbutton;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement deleteconfirmationOKbutton;

	// done button in review test last step 7
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[3]/button[1]")
	public static WebElement lastdonebutton;

	// * Review Test Add Button
	@FindBy(xpath = "//div[@class='steps-action']/button[1]")
	public static WebElement donebutton;

	// Next Button Click
	@FindBy(xpath = "//span[normalize-space()='Next']")
	public static WebElement nextBtn;

	@FindBy(xpath = "//span[text()='Manage Tests Configure']/../../..")
	public static WebElement managetestconfiguretopnavigation;

	@FindBy(xpath = "//div[text()=' Manage Test Configuration ']")
	public static WebElement managetesttableHeading;

	@FindBy(xpath = "//input[@placeholder='Test']")
	public static WebElement testsearchplaceholder;

	@FindBy(xpath = "(//span[@role='button'])[1]")
	public static WebElement testsearchicon;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement testsearchbutton;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> testColumn;

	public static String testBeforesearch = "//tbody[@class='ant-table-tbody']/tr[";
	public static String testAftersearch = "]/td[1]";

	@FindBy(xpath = "//td[@class='ant-table-cell ant-table-cell-fix-left ant-table-cell-fix-left-last']")
	public static WebElement firsttestdata;

	// * ACCEPTED CRETIERIA BUTTON
	@FindBy(xpath = "(//div[@class='ant-steps-item-icon'])[4]")
	public static WebElement acceptedcretieriabutton;

	// SLECT TEST PARAMETER
	@FindBy(xpath = "//input[@id='parameter']")
	public static WebElement selecttestparametertab;

	// ACCEPTED CRETIERIA SAVE BUTTON
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary sc-gZMcBi jVssxC']")
	public static WebElement acceptedcretieriasavebutton;

	// Manage Test Configure Scroll Page
	@FindBy(xpath = "//div[@class='ant-table-body']")
	public static WebElement managetestcongigurescrollpage;

	// EDIT CONFIGURE HEADING
	@FindBy(xpath = "(//th[@class='ant-table-cell'])[14]")
	public static WebElement editconfigureheading;

	// ACCEPTED VALUE EDIT
	@FindBy(xpath = "//thead//th[9]")
	public static WebElement acceptedvalueedit;

	// ACCEPTED VALUE MATERIAL BUTTON SPAN
	@FindBy(xpath = "//input[@value='MATERIAL']/..")
	public static WebElement acceptedvaluematerialbuttonspan;

	// ACCEPTED VALUE MATERIAL BUTTON INPUT
	@FindBy(xpath = "//input[@value='MATERIAL']/.")
	public static WebElement acceptedvaluematerialbuttoninput;

	// ACCEPTED VALUE COMMON BUTTON SPAN
	@FindBy(xpath = "(//span[@class='ant-radio ant-radio-checked'])[2]")
	public static WebElement acceptedvaluecommonbuttonspan;

	// ACCEPTED VALUE COMMON BUTTON INPUT
	@FindBy(xpath = "(//span[@class='ant-radio ant-radio-checked'])[2]/input")
	public static WebElement acceptedvaluecommonbuttoninput;

	// ACCEPTED VALUE MATERIAL SEARCH ICON
	@FindBy(xpath = "//tr[2]//td[2]//input[@id='min']/ancestor::div[@class='ant-table-wrapper']//th[1]//span[@role='button']")
	public static WebElement acceptedvaluematerialsearchicon;

	// ACCEPTED VALUE MATERIAL SEARCH BUTTON
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement acceptedvaluematerialsearchbutton;

	// ACCEPTED VALUE MATERIAL RESET BUTTON
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//button[@class='ant-btn ant-btn-sm']")
	public static WebElement acceptedvaluematerialresetbutton;

	// ACCEPTED VALUE MATERIAL DATA COUNT TABLE
	@FindBy(xpath = "(//div[@class='ant-table-body'])[2]")
	public static WebElement acceptedvaluematerialdatacounttable;

	// ACCEPTED VALUE MATERIAL GET VALUE
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']/div/input")
	public static WebElement acceptedvaluematerialgetvalue;

	// ______________________ TEST CONFIG ____________________________
	@FindBy(xpath = "//div[contains(text(),'Test Configure')]")
	public static WebElement TestConfigBtnClick;

	// _____________________ADD PARAMETR ___________________________
	@FindBy(xpath = "(//button[@type='button'])[2]")
	public static WebElement addParameterBTN;

	// ____________________TEXT BOX ADD PARAMETR______________________
	@FindBy(xpath = "//textarea[@id='parameter_name']")
	public static WebElement addParameterTextBox;

	// ____________________DATA TYPE _________________________________
	@FindBy(xpath = "//input[@id='parameterDataType']")
	public static WebElement TextboxDataType;

	// ___________________SAVE BUTTON ________________________________
	@FindBy(xpath = "//button[@type='button'])[10]")
	public static WebElement parameterSaveButtonTestConfig;

	@FindBy(xpath = "(//tbody[@class='ant-table-tbody'])[2]/tr[2]/td[1]")
	public static WebElement firstaddeddata;

	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	public static WebElement successmessage;

	// TESTPARAMETER NODATA DISPLAY
	@FindBy(xpath = "//div[text()='No Data']")
	public static WebElement testparameternodatadisplay;

	// CLICK THE SAVE PARAMETER BUTTON
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-submit sc-gZMcBi jVssxC']")
	public static WebElement clickthesaveparameterbutton;

	// GET THE VALIDATION MESSAGE TESTPARAMETER VA1
	@FindBy(xpath = "(//div[@class='ant-table-footer']//div[2]/.)[1]/..")
	public static WebElement validationmessagetestparameterva1;

	// GET THE VALIDATION MESSAGE TESTPARAMETER VA2
	@FindBy(xpath = "(//div[@class='ant-table-footer']//div[3]/.)[1]")
	public static WebElement validationmessagetestparameterva2;

	// GET THE VALIDATION MESSAGE TESTPARAMETER VA3
	@FindBy(xpath = "//input[@id='abbrivation']/../div")
	public static WebElement validationmessagetestparameterva3;

	// ADD KEY TEST
	// MATERIALRADIOBUTTON
	@FindBy(xpath = "//span[normalize-space()='Material']")
	public static WebElement MaterialRadioButton;
	// TEXTBOX FOR SELECT SUB CATEGORY
	@FindBy(xpath = "//input[@id='SubCategory']")
	public static WebElement selectSubCategoryTextox;

	// CHECKBOX FOR NAME
	@FindBy(xpath = "//div[@class='ant-table-selection']//input[@type='checkbox']")
	public static WebElement NamecheckBox;

	// SAVE BUTTON IN ADD KEY TEST
	@FindBy(xpath = "//button[normalize-space()='Save']")
	public static WebElement saveButtonAddkey;

	// DDITIONAL INFORMATION CANCEL BUTTON
	@FindBy(xpath = "//div[@class='ant-modal-footer']/div/button")
	public static WebElement additionalcancel;

	// *****CONFIGURE EQUATION TAB*****

	// EQUATION TYPE HEADING
	@FindBy(xpath = "//div[contains(@class,'ant-col-18')]//label[@class='label']")
	public static WebElement equationTypeHeading;

	// PARAMETER HEADING
	@FindBy(xpath = "//label[@class='ant-radio-wrapper']/span[2]")
	public static WebElement parameterHeading;

	// PARAMETER RADIO BUTTON
	@FindBy(xpath = "//*[@id='equationType']/label[1]/span[1]")
	public static WebElement parameterRadioButton;

	// RESULT HEADING
	@FindBy(xpath = "//label[contains(@class,'ant-radio-wrapper-checked')]//span[2]")
	public static WebElement resultHeading;

	// RESULT RADIO BUTTON
	@FindBy(xpath = "//*[@id='equationType']/label[2]/span[1]")
	public static WebElement resultRadioButton;

	// TEST PARAMETER HEADING
	@FindBy(xpath = "//main//div[contains(@class,'ant-col-10')]/div/div[2]/div[2]/label")
	public static WebElement testparameterHeading;

	// TEST PARAMETER EQUATION TEXTBOX
	@FindBy(xpath = "//div[contains(@class,'ant-select-show-arrow')]")
	public static WebElement testparameterTextbox;

	// "+" ICON
	@FindBy(xpath = "//div[@class='calculators']/div[1]/div[contains(@class,'backImg')]")
	public static WebElement plusIcon;
	// "-" ICON
	@FindBy(xpath = "//div[@class='calculators']/div[2]/div[contains(@class,'backImg')]")
	public static WebElement minusIcon;

	// "*" ICON
	@FindBy(xpath = "//div[@class='calculators']/div[3]/div[contains(@class,'backImg')]")
	public static WebElement multiplicationIcon;
	// "/" ICON
	@FindBy(xpath = "//div[@class='calculators']/div[4]/div[contains(@class,'backImg')]")
	public static WebElement divisionIcon;

	// "." ICON
	@FindBy(xpath = "//div[@class='calculators']/div[5]/div[contains(@class,'backImg')]")
	public static WebElement pointIcon;

	// "(" ICON
	@FindBy(xpath = "//div[@class='calculators']/div[6]/div[contains(@class,'backImg')]")
	public static WebElement openBracketIcon;

	// ")" ICON
	@FindBy(xpath = "//div[@class='calculators']/div[7]/div[contains(@class,'backImg')]")
	public static WebElement closeBracketIcon;

	// TEST PARAMETER DROPDOWN
	@FindBy(xpath = "//div[@name='testParameterForEquation']")
	public static WebElement dropDownTestParameter;

	// SELECT TEST PARAMETER CREATE EQUATION HEADING --------Modified By Shangeetha on 14/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/label")
	public static WebElement selectParameterHeading;

	// RESET BUTTON
	@FindBy(xpath = "//button[contains(@class,'ant-btn-danger')]")
	public static WebElement resetButtonEquation;

	// TEXTAREA CONFIGURE EQUATION

	@FindBy(xpath = "//textarea[@class='ant-input equation_playground textEmph']")
	public static WebElement textBoxEquation;

	// TEXTAREA CONFIGURE EQUATION
	@FindBy(xpath = "//div[contains(@class,'letters_area')]")
	public static WebElement textAreaEquation;

	// PARAMETER HEADING UNDER SELECT PARAMETER CREATE EQUATION
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[2]/div/div[1]//table//thead/tr/th[1]")
	public static WebElement ParameterHeadingUnderSelectParameter;

	// ABBRIVIATION HEADING UNDER SELECT PARAMETER CREATE EQUATION
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[2]/div/div[1]//table//thead/tr/th[2]")
	public static WebElement abbriviationHeadingUnderSelectParameter;

	// UNIT HEADING UNDER SELECT PARAMETER CREATE EQUATION
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[2]/div/div[1]//table//thead/tr/th[3]")
	public static WebElement unitHeadingUnderSelectParameter;

	// RELEVENT HEADING UNDER SELECT PARAMETER CREATE EQUATION
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[2]/div/div[1]//table//thead/tr/th[4]")
	public static WebElement releventHeadingUnderSelectParameter;

	// PARAMETER HEADING UNDER SECOND TABLE
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]//table//thead/tr/th[1]")
	public static WebElement ParameterHeadingUnder_SndTable;

	// EQUATION HEADING UNDER SECOND TABLE
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]//table//thead/tr/th[2]")
	public static WebElement equationHeadingUnder_SndTable;
	// EQUATION TYPE HEADING UNDER SECOND TABLE
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]//table//thead/tr/th[3]")
	public static WebElement equationTypeHeadingUnder_SndTable;
	// ACTION HEADING UNDER SECOND TABLE
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]//table//thead/tr/th[4]")
	public static WebElement actionHeadingUnder_SndTable;

	// Accepted Criteria Delete popup Question Icon
	@FindBy(xpath = "//div[@class='ant-popover-message']/span")
	public static WebElement questionicon;

	// modifi By Quenthan

	@FindBy(xpath = "//header//li[2]/span")
	public static WebElement ManageTestConfigMain;

	@FindBy(xpath = "//main/div/div/div[1]/div/div[1]")
	public static WebElement manageTestButton;

	@FindBy(xpath = "//div[@class='ant-table-container']")
	public static WebElement mainTable;

	@FindBy(xpath = "//th[16]")
	public static WebElement tableTH;

	@FindBy(xpath = "//p[text()='Review Test']/ancestor::div[@class='ant-steps-item-container']")
	public static WebElement reviewTestButtonS;

	@FindBy(xpath = "//div[@class='ant-modal-content']//th[1]")
	public static WebElement materialPuMheading;

	// test config card
	@FindBy(xpath = "//div[@class='sc-htpNat boOfVg']//div[@class='flex-card-home']")

	public static WebElement conficgcard;

	// test table heading
	@FindBy(xpath = "//div[@class='ant-table-title']/div/div[1]")
	public static WebElement testtableheading;

	// test tab test heading
	@FindBy(xpath = "//thead/tr[1]/th[1]")
	public static WebElement testtabtestheading;

	// testsearchpopup
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']")
	public static WebElement testsearchpopup;

	// Action - Delete Pop up Screen- "Cancel" button
	@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[1]")
	public static WebElement popupcancelbtn;

	// Next Button
	@FindBy(xpath = "//div[@class='steps-action']/button[contains(@class,'ant-btn-primary')]")
	public static WebElement testconfignextbtn;

	// Previous Button
	@FindBy(xpath = "//div[@class='steps-action']/button[@class='ant-btn']")
	public static WebElement testconfignprerviousbtn;

	// Reset Button
	@FindBy(xpath = "//div[@class='steps-action']/button[contains(@class,'ant-btn-danger')]")
	public static WebElement testconfignresetbtn;

	// Action - Delete Pop up Screen ok button
	@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[2]")
	public static WebElement okbtn;

	// test action heading
	@FindBy(xpath = "//thead/tr[1]/th[2]")
	public static WebElement testactionheading;

	// Add Key Sub Category Radio Button
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]//div[contains(@class,'ant-radio-group-outline')]/label[1]/span[1]")
	public static WebElement addkeysubcategory;

	// modifi By Quenthan
	@FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='ant-modal-title']")
	public static WebElement materialPuModalPopupheading;

	@FindBy(xpath = "//div[@class='ant-modal-content']//th[2]")
	public static WebElement materialPuModalkeyTestHeding;

	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement materialPuModalkeyTestModal;

	@FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='ant-modal-footer']//button[1]")
	public static WebElement materialPuModalCancalButton;

	@FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='ant-modal-footer']//button[2]")
	public static WebElement materialPuModalOkButton;

	@FindBy(xpath = "//div[@class='ant-modal-content']/button")
	public static WebElement materialPuModalCloseButton;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[7]/div[1]/div/div[1]/div/div")
	public static WebElement additionalInformationHeading;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[7]/div[1]//th[1]")
	public static WebElement additionalInformationCaptionHeading;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[7]/div[1]//th[2]")
	public static WebElement additionalInformationMaxLenthHeading;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[7]/div[1]//th[3]")
	public static WebElement additionalInformationRecordTypeHeading;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[7]/div[1]//th[4]")
	public static WebElement additionalInformationStatusHeading;

	// RAHUL(2023/06/26)
	@FindBy(xpath = "//input[@class='ant-select-selection-search-input']/../..")
	public static WebElement paginationParaMeter;

	@FindBy(xpath = "//li[contains(@title,'Previous')]/button")
	public static WebElement paginationPreviousButtonParaMeter;

	@FindBy(xpath = "//li[contains(@title,'Next')]/button")
	public static WebElement paginationNextButtonParaMeter;

	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//button[2]")
	public static WebElement dataTypeResetButton;

	@FindBy(xpath = "//input[@id='parameterDataType']/../..")
	public static WebElement dataTypeSearchButton;
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[7]/div[2]//div[@class='ant-card-head-title']")
	public static WebElement AcceptedConditionHeading;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[7]/div[2]//th[1]")
	public static WebElement AcceptedCondition_ConditionHeading;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[7]/div[2]//th[2]")
	public static WebElement AcceptedConditionParametersHeading;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[3]//button[1]")
	public static WebElement AcceptedConditionDoneuttons;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[3]//button[2]")
	public static WebElement AcceptedConditionPreviousuttons;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[3]//button[3]")
	public static WebElement AcceptedConditionResetButtons;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[5]/div[1]//th[2]")
	public static WebElement MaterialAcceptedalueMaterialHeading;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[5]/div[1]//th[3]")
	public static WebElement MaterialAcceptedalueConditionSubHeading;

	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement addParaMeterPopUp;

	@FindBy(xpath = "//div[@class='ant-modal-header']")
	public static WebElement addParaMeterPopUpHeading;

	@FindBy(xpath = "//textarea[@id='parameter_name']/../label")
	public static WebElement addParaMeterScreenParameterHeading;

	@FindBy(xpath = "//textarea[@id='parameter_name']")
	public static WebElement addParaMeterScreenParameterTextBox;

	@FindBy(xpath = "//div[@name='parameterType']/../label")
	public static WebElement addParaMeterScreenParameterTypeHeading;

	@FindBy(xpath = "//input[@id='parameterType']")
	public static WebElement addParaMeterScreenParameterTypeDropDown;

	@FindBy(xpath = "//input[@id='parameterDataType']/ancestor::div[4]//label")
	public static WebElement addParaMeterScreenParameterDataTypeHeading;

	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[1]")
	public static WebElement addParaMeterScreenCancelButton;

	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[2]")
	public static WebElement addParaMeterScreenSaveButton;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[5]/div[1]//th[4]")
	public static WebElement MaterialAcceptedalue_ValueSubHeading;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[5]/div[1]//th[5]")
	public static WebElement MaterialAcceptedalueRelevantToResultSubHeading;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[5]/div[3]//div[@class='ant-card-head-title']")
	public static WebElement KeyTestTopHeadingsF;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[5]/div[3]//th[1]")
	public static WebElement KeyTestSubCategorysubHeadings;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[5]/div[3]//th[2]")
	public static WebElement KeyTest_KeyTestsubHeadings;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[5]/div[3]//th[3]")
	public static WebElement KeyTest_MaterialsubHeadings;

	// By RAHUL(2023/06/28)
	@FindBy(xpath = "//div[@class='ant-modal-header']//span")
	public static WebElement paraMeterAddParaMeterCloseButton;
	// ***********************THAKSHILA***********************4/7/2023
	// add group button
	@FindBy(xpath = "//*[contains(text(), 'Add Group')]/..")
	public static WebElement paraMeterAddParaMeterAddGroupButton;
	// add group button popup screen
	@FindBy(xpath = "//div[@class='ant-modal']/div[@class='ant-modal-content']")
	public static WebElement paraMeterAddParaMeterAddGroupPopUpScreen;
	// add group button popup screen Group Key Head
	@FindBy(xpath = "//div[@class='ant-row']/div/div/p")
	public static WebElement paraMeterAddParaMeterAddGroupPopUpScreenGroupKeyHead;
	// add group button popup screen Group Keys Head
	@FindBy(xpath = "//div[@class='ant-modal-header']/div")
	public static WebElement paraMeterAddParaMeterAddGroupPopUpScreenGroupKeysHead;
	// add group button popup screen Test Parameter Head
	@FindBy(xpath = "//th[1]/div")
	public static WebElement paraMeterAddParaMeterAddGroupPopUpScreenTestParameterHead;
	// add group button popup screen Test Parameter search icon
	@FindBy(xpath = "//div[@class='ant-table ant-table-fixed-header']//span[@role='button']")
	public static WebElement paraMeterAddParaMeterAddGroupPopUpScreenTestParameterSearchICon;
	// add group button popup screen "Relavant" Filed UI Heading
	@FindBy(xpath = "//div[@class='ant-modal-body']//th[2]")
	public static WebElement paraMeterAddParaMeterAddGroupPopUpScreenRelavantHead;

	@FindBy(xpath = "//section/main/div/div/div[1]/div/div[2]/div[2]")
	public static WebElement paraMeterbutton;

	// add group button popup screen Test Parameter search icon popup
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']/div")
	public static WebElement paraMeterAddParaMeterAddGroupPopUpScreenTestParameterSearchIConPoP;
	// add group button popup screen Test Parameter search icon popup TextBox
	@FindBy(xpath = "//input[contains(@placeholder,'Parameter')]")
	public static WebElement paraMeterAddParaMeterAddGroupPopUpScreenTestParameterSearchIConTextBox;
	// add group button popup screen Test Parameter search icon popup search button
	@FindBy(xpath = "//*[contains(text(), 'Search')]/..")
	public static WebElement paraMeterAddParaMeterAddGroupPopUpScreenTestParameterSearchIConSearchButton;
	// add group button popup screen Test Parameter search icon popup Reset button
	@FindBy(xpath = "//*[contains(text(), 'Reset')]/..")
	public static WebElement paraMeterAddParaMeterAddGroupPopUpScreenTestParameterSearchIConResetButton;
	// Test Configure Table - Parameter Table-Add Parameter Pop up Screen- "Enter
	// GroupKey" Text box Properties
	@FindBy(xpath = "//div[@class='ant-modal-content']//input[@name='groupName']/..")
	public static WebElement paraMeterAddParaMeterAddGroupEnterGroupKeyTextBox;
	// Test Configure Table - Parameter Table-Add Parameter Pop up Screen- Enter
	// GroupKey- "+" icon Properties
	@FindBy(xpath = "//span[@aria-label='plus-square']//*[name()='svg']")
	public static WebElement paraMeterAddParaMeterAddGroupEnterGroupKeyPlusIcon;
	// Test Configure Table - Parameter Table-Add Parameter Pop up Screen- Enter
	// GroupKey- REMOVE button
	@FindBy(xpath = "//div[1]/div/div/div/button/*[contains(text(), 'Remove')]")
	public static WebElement paraMeterAddParaMeterAddGroupEnterGroupKeyRemoveButton;
	// Test Configure Table - Parameter Table-Add Parameter Pop up Screen- "Test
	// Parameter" (3rd Table) Filed UI Heading Properties
	@FindBy(xpath = "//div[@class='ant-list-header']/div/p")
	public static WebElement paraMeterAddParaMeterTestParaDataHead;
	// Test Configure Table - Parameter Table-Add Parameter Pop up Screen- "Test
	// Parameter" (3rd Table) Filed UI Heading Properties
	@FindBy(xpath = "//div[4]/div[2]/button/span")
	public static WebElement paraMeterAddParaMeterButton;
	// Test Configure Table - Parameter Table-Add Parameter Pop up Screen- "Test
	// Parameter" (3rd Table) NO data icon
	@FindBy(xpath = "//div[@class='ant-list-empty-text']//div[@class='ant-empty-image']//*[name()='svg']")
	public static WebElement paraMeterAddParaMeterNoDataIcon;
	// Test Configure Table - Parameter Table-Add Parameter Pop up Screen-
	// Pagination Next Button
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[1]//ul/li[@class='ant-pagination-next']")
	public static WebElement paraMeterAddParaMeterPagiNextArrow;
	// Test Configure Table - Parameter Table-Add Parameter Pop up Screen-
	// Pagination Previous
	@FindBy(xpath = "//ul//li[1]//button[1]")
	public static WebElement paraMeterAddParaMeterPagiPrevArrow;
	// Test Configure Table - Parameter Table-Add Parameter Pop up Screen-
	// Pagination Next Button
	@FindBy(xpath = "//ul//li[@class='ant-pagination-next']//button[1]")
	public static WebElement paraMeterAddParaMeterPagiNextArrowClick;
	// Test Configure Table - Parameter Table-Add Parameter Pop up Screen-Pagination
	// Drop down Properties
	@FindBy(xpath = "//div[@class='ant-modal-root']//li[@class='ant-pagination-options']//span[2]")
	public static WebElement paraMeterAddParaMeterPagiDropDown;
	// Test Configure Table - Parameter Table-Add Parameter Pop up Screen- "Cancel"
	// Button Properties
	@FindBy(xpath = "//*[contains(text(), 'Cancel')]/..")
	public static WebElement paraMeterAddParaMeterCancelButton;
	// Test Configure Table - Parameter Table-Add Parameter Pop up Screen- "Add
	// Group Keys" Button Properties
	@FindBy(xpath = "//div[@class='ant-modal']//div[@class='ant-modal-content']/div[3]/button[2]")
	public static WebElement paraMeterAddParaMeterAddGroupKeysButton;
	// Test Configure Table - Parameter Table-Add Parameter Pop up Screen- "Add
	// Group Keys" Close Button Properties
	@FindBy(xpath = "//span[@aria-label='close']//*[name()='svg']")
	public static WebElement paraMeterAddParaMeterAddGroupKeysCloseButton;
	// Test Configure Table - Parameter Table Middle Page- "Test Parameter" UI
	// Heading Properties
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/form[2]/div/div/div/div/div[@class='ant-table-title']/div/div")
	public static WebElement paraMeterAddParaMeterTestParaHead;
	// Test Configure Table - Parameter Table Middle Page- Test Parameter Table-
	// "Test Parameter" UI Heading Properties
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/form[2]//div[@class='ant-table-header']/table/thead/tr/th[1]")
	public static WebElement paraMeterAddParaMeterTestParaSubHead;
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/form[3]/div/div/div/div/div[@class='ant-table-title']/div/div")
	public static WebElement scrollDown;
	// Test Configure Table - Parameter Table Middle Page- Test Parameter Table-
	// "Group Parameter" UI Heading Properties
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/form[2]//div[@class='ant-table-header']/table/thead/tr/th[2]")
	public static WebElement paraMeterAddParaMeterGroupParaSubHead;
	// Test Configure Table - Parameter Table Middle Page- Test Parameter Table-
	// "Abbreviation " UI Heading Properties
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/form[2]//div[@class='ant-table-header']/table/thead/tr/th[3]")
	public static WebElement paraMeterAddParaMeterAbbreviationSubHead;
	// Abbreviation text box
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/form[2]//div[@class='ant-table-header']/table/thead/tr/th[3]")
	public static WebElement paraMeterAddParaMeterAbbreviationTextBox;
	// Test Configure Table - Parameter Table Middle Page- Test Parameter Table-
	// "Type" UI Heading Properties
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/form[2]//div[@class='ant-table-header']/table/thead/tr/th[4]")
	public static WebElement paraMeterAddParaMeterTypeSubHead;
	// Test Configure Table - Parameter Table Middle Page- Test Parameter Table-
	// "Input Method" UI Heading Properties
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/form[2]//div[@class='ant-table-header']/table/thead/tr/th[5]")
	public static WebElement paraMeterAddParaMeterInputMethodSubHead;

	// Delete Icon PopUp screen
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement reviewTestParaMeterDeleteIconPop;
	// Question Icon PopUp screen
	@FindBy(xpath = "//span[@aria-label='question-circle']")
	public static WebElement reviewTestParaMeterDeleteIconPopQuesIcon;
	// Ok button delete Icon PopUp screen
	@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[2]/span")
	public static WebElement reviewTestParaMeterDeleteIconPopOkButton;
	// Ok button delete Icon PopUp screen
	@FindBy(xpath = "//*[contains(text(), 'Cancel')]/..")
	public static WebElement reviewTestParaMeterDeleteIconPopCancelButton;
	// Next button
	@FindBy(xpath = "//div[@class='steps-action']/button[1]/span")
	public static WebElement reviewTestParaMeterNextButton;
	// Previous button
	@FindBy(xpath = "//div[@class='steps-action']/button[2]/span")
	public static WebElement reviewTestParaMeterPreviousButton;
	// Reset button
	@FindBy(xpath = "//div[@class='steps-action']/button[3]/span")
	public static WebElement reviewTestParaMeterResetButton;
	// 3 icon
	@FindBy(xpath = "//div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]")
	public static WebElement reviewConfigureEquationIcon;
	// Configure Equation
	@FindBy(xpath = "//div[3]/div[1]/div[3]")
	public static WebElement reviewConfigureEquationHeading;
	// Top Bar Add Key Test icon 5
	@FindBy(xpath = "//div[5]/div[1]/div[3]")
	public static WebElement reviewConfigureAddKeyHeading;

	// Test Configure Table - Parameter Table Middle Page- Test Parameter Table-
	// "Abbreviation " Text box Properties
	@FindBy(xpath = "//input[@id='abbrivation']")
	public static WebElement paraMeterTestParaMeterInputMethodSubHead;
	// Type dropdown
	@FindBy(xpath = "//input[@id='configLevel']/..")
	public static WebElement paraMeterTestParaMeterTypeDropdown;
	@FindBy(xpath = "//input[@aria-activedescendant='configLevel_list_1']")
	public static WebElement paraMeterTestparaMeterTestParaMeterTypeDropdownVale;
	// Input Method dropdown
	@FindBy(xpath = "//input[@id='input']")
	public static WebElement paraMeterTestParaMeterInputMethodDropdown;
	// Test Configure Table - Parameter Table Middle Page- Test Parameter Table-
	// "Value" UI Heading Properties
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/form[2]//div[@class='ant-table-header']/table/thead/tr/th[6]")
	public static WebElement paraMeterAddParaMeterValueSubHead;
	// Test Configure Table - Parameter Table Middle Page- Test Parameter Table-
	// "Value" UI Heading Properties
	@FindBy(xpath = "//div[@class='ant-picker-input']/..")
	public static WebElement paraMeterAddParaMeterCalendarFeild;
	// Calendar data
	@FindBy(xpath = "//div[@class='ant-picker-input']/span")
	public static WebElement paraMeterAddParaMeterCalendarDataFeild;
	// Test Configure Table - Parameter Table Middle Page- Test Parameter Table-
	// "Unit" UI Heading Properties
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/form[2]//div[@class='ant-table-header']/table/thead/tr/th[7]")
	public static WebElement paraMeterAddParaMeterUnitHead;
	// Test Configure Table - Parameter Table Middle Page- Test Parameter Table-
	// "Unit" Drop Down Properties
	@FindBy(xpath = "//input[@id='unit']")
	public static WebElement paraMeterTestParaMeterUnitDropdown;
	// Test Configure Table - Parameter Table Middle Page- Test Parameter Table-
	// "Decimal Value" UI Heading Properties
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/form[2]//div[@class='ant-table-header']/table/thead/tr/th[8]")
	public static WebElement paraMeterAddParaMeterDecimalValueSubHead;
	// text BOx
	@FindBy(xpath = "//input[@id='decimalType']")
	public static WebElement paraMeterAddParaMeterDecimalValueTextBox;
	// Up arrow
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/form[2]//div[@class='ant-table-header']/table/thead/tr/th[8]")
	public static WebElement paraMeterAddParaMeterDecimalValueUpArrow;
	// Down arrow
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/form[2]//div[@class='ant-table-header']/table/thead/tr/th[8]")
	public static WebElement paraMeterAddParaMeterDecimalValueDownArrow;
	// Test Configure Table - Parameter Table Middle Page- Test Parameter Table-
	// "Relevant To Accepted Criteria" UI Heading Properties
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/form[2]//div[@class='ant-table-header']/table/thead/tr/th[9]")
	public static WebElement paraMeterAddParaMeterRelToAcceptSubHead;
	// Test Configure Table - Parameter Table Middle Page- Test Parameter Table-
	// "Relevant To Accepted Criteria" UI Heading Properties
	@FindBy(xpath = "//div[@class='ant-table-footer']/div/div[2]/button/span")
	public static WebElement paraMeterAddParaMeterSaveParameter;
	// Test Configure Table - Parameter Table Last Part- "Review Test Parameter" UI
	// Heading Properties
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/form[2]//div[@class='ant-table-header']/table/thead/tr/th[9]")
	public static WebElement paraMeterReviewTestParameterHead;
	// Test Configure Table - Parameter Table Last Part- "Review Test Parameter"-
	// "Parameter" UI Heading Properties
	@FindBy(xpath = "//form[3]/div/div/div/div/div[1]/div/div/div[1]")
	public static WebElement paraMeterReviewTestParameter;
	// Test Configure Table - Parameter Table Middle Page-down
	@FindBy(xpath = "//footer")
	public static WebElement footPage;
	// Test Configure Table - Parameter Table Middle Page- Test Parameter Table-
	// "Relevant To Accepted Criteria" Check Box Properties
	@FindBy(xpath = "//td[9]/label[1]/span[1]/span[@class='ant-checkbox-inner']")
	public static WebElement paraMeterCheckBoxProps;
	// Test Configure Table - Parameter Table Last Part- "Review Test Parameter"-
	// "Parameter" UI Heading Properties
	@FindBy(xpath = "//form[3]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//table[1]//thead[1]//tr[1]//th[1]")
	public static WebElement reviewTestParaMeterParametersubHead;
	// Test Configure Table - Parameter Table Last Part- "Review Test Parameter"-
	// "Abbreviation" UI Heading Properties
	@FindBy(xpath = "//form[3]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//table[1]//thead[1]//tr[1]//th[2]")
	public static WebElement reviewTestParaMeterAbbreviationsubHead;
	// Test Configure Table - Parameter Table Last Part- "Review Test Parameter"-
	// "Type" UI Heading Properties
	@FindBy(xpath = "//form[3]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//table[1]//thead[1]//tr[1]//th[3]")
	public static WebElement reviewTestParaMeterTypesubHead;
	// Test Configure Table - Parameter Table Last Part- "Review Test Parameter"-
	// "Input Method" UI Heading Properties
	@FindBy(xpath = "//form[3]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//table[1]//thead[1]//tr[1]//th[4]")
	public static WebElement reviewTestParaMeterInputMethodsubHead;
	// Test Configure Table - Parameter Table Last Part- "Review Test Parameter"-
	// "Table Name" UI Heading Properties
	@FindBy(xpath = "//form[3]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//table[1]//thead[1]//tr[1]//th[5]")
	public static WebElement reviewTestParaMeterTableNamesubHead;
	// Test Configure Table - Parameter Table Last Part- "Review Test Parameter"-
	// "Data Type" UI Heading Properties
	@FindBy(xpath = "//form[3]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//table[1]//thead[1]//tr[1]//th[6]")
	public static WebElement reviewTestParaMeterDataTypesubHead;
	// Test Configure Table - Parameter Table Last Part- "Review Test Parameter"-
	// "Value" UI Heading Properties
	@FindBy(xpath = "//form[3]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//table[1]//thead[1]//tr[1]//th[7]")
	public static WebElement reviewTestParaMeterValuesubHead;
	// Test Configure Table - Parameter Table Last Part- "Review Test Parameter"-
	// "Unit" UI Heading Properties
	@FindBy(xpath = "//form[3]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//table[1]//thead[1]//tr[1]//th[8]")
	public static WebElement reviewTestParaMeterUnitsubHead;
	// Test Configure Table - Parameter Table Last Part- "Review Test Parameter"-
	// "Decimal value" UI Heading Properties
	@FindBy(xpath = "//form[3]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//table[1]//thead[1]//tr[1]//th[9]")
	public static WebElement reviewTestParaMeterDecimalvaluesubHead;
	// Test Configure Table - Parameter Table Last Part- "Review Test Parameter"-
	// "Relevant To Accepted Criteria" UI Heading Properties
	@FindBy(xpath = "//form[3]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//table[1]//thead[1]//tr[1]//th[10]")
	public static WebElement reviewTestParaMeterRelToAcceptCrisubHead;
	// Test Configure Table - Parameter Table Last Part- "Review Test Parameter"-
	// "Action" UI Heading Properties
	@FindBy(xpath = "//form[3]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//table[1]//thead[1]//tr[1]//th[11]")
	public static WebElement reviewTestParaMeterACtionheading;
	// Test Configure Table - Parameter Table Last Part- Review Test Parameter-
	// Action "Edit icon" Pop up Properties
	// pop up screen
	@FindBy(xpath = "//div[@class='ant-modal-body']/..")
	public static WebElement reviewTestParaMeterEditIconPop;
	// pop up screen Heading
	@FindBy(xpath = "//div[@id='rcDialogTitle0']")
	public static WebElement reviewTestParaMeterEditIconPopHead;
	// parameter Heading
	@FindBy(xpath = "//div[@class='ant-modal-body']/div/div[1]/div[1]/div/label")
	public static WebElement reviewTestParaMeterEditIconPopParaHead;
	// parameter Drop down
	@FindBy(xpath = "//div[@class='ant-modal-body']/div/div[1]/div[1]/div/div/div/span[2]")
	public static WebElement reviewTestParaMeterEditIconPopParaDropDown;
	// Type Heading
	@FindBy(xpath = "//div[@class='ant-modal-body']/div/div[1]/div[2]/div/label")
	public static WebElement reviewTestParaMeterEditIconPopTypeHead;
	// Type DropDown
	@FindBy(xpath = "//div[@class='ant-modal-body']/div/div[1]/div[2]/div/div/div/span[2]")
	public static WebElement reviewTestParaMeterEditIconPopTypeDropDown;
	// Unit Heading
	@FindBy(xpath = "//div[@class='ant-modal-body']/div/div[2]/div[1]/div/label")
	public static WebElement reviewTestParaMeterEditIconPopUnitHead;
	// Unit Drop Down
	@FindBy(xpath = "//div[@class='ant-modal-body']/div/div[2]/div[1]/div/div/div/span[2]")
	public static WebElement reviewTestParaMeterEditIconPopUnitDropDown;
	// Abbreviation Heading
	@FindBy(xpath = "//div[@class='ant-modal-body']/div/div[2]/div[2]/div/label")
	public static WebElement reviewTestParaMeterEditIconPopAbbreviationHead;
	// Abbreviation Text box
	@FindBy(xpath = "//div[@class='ant-modal-body']/div/div[2]/div[2]/div/input")
	public static WebElement reviewTestParaMeterEditIconPopAbbreviationTextBox;
	// Input method heading box
	@FindBy(xpath = "//div[@class='ant-modal-body']/div/div[3]/div[1]/div/label")
	public static WebElement reviewTestParaMeterEditIconPopInputMethodHeading;
	// Input method heading box
	@FindBy(xpath = "//div[@class='ant-modal-body']/div/div[3]/div[1]/div/div/div/span[2]")
	public static WebElement reviewTestParaMeterEditIconPopInputMethodDropDown;
	// Value Heading
	@FindBy(xpath = "//div[@class='ant-modal-body']/div/div[3]/div[2]/div/label")
	public static WebElement reviewTestParaMeterEditIconPopValueHead;
	// Test Configure Table - Parameter Table Last Part- Review Test Parameter-
	// Action -Edit icon Pop up Screen - "Relevant To Accepted Value" Data Field
	// Heading UI Properties
	@FindBy(xpath = "//div[@class='ant-modal-body']/div/div[4]/div[1]/div/label[1]")
	public static WebElement reviewTestParaMeterEditIconPopRelevantValueHead;
	// Test Configure Table - Parameter Table Last Part- Review Test Parameter-
	// Action -Edit icon Pop up Screen - "Relevant To Accepted Value" Data Field
	// Heading UI Properties
	@FindBy(xpath = "//div[@class='ant-modal-body']/div/div[4]/div[1]/div/label[2]/span")
	public static WebElement reviewTestParaMeterEditIconPopRelevantCheckBox;
	// Heading
	@FindBy(xpath = "//div[@class='ant-modal-body']/div/div[4]/div[2]/div/label")
	public static WebElement reviewTestParaMeterEditIconPopRelevantDecimalTypeHead;
	// (Type - Config) "Value" Enable Text box UI Properties
	@FindBy(xpath = "//div[@name='editType']//div[@class='ant-select-selector']/span[2]")
	public static WebElement reviewTestParaMeterEditIconPopRConfigTextBox;
	// (Type - Input) "Value" Enable Text box UI Properties
	@FindBy(xpath = "//input[@id='editValue']")
	public static WebElement reviewTestParaMeterEditIconPopRInputTextBox;
	// (Type - Result) "Value" Enable Text box UI Properties
	@FindBy(xpath = "//span[contains(text(),'Result')]")
	public static WebElement reviewTestParaMeterEditIconPopResultTextBox;
	// "Decimal Type" Text Box Properties
	@FindBy(xpath = "//div[@class='ant-modal-body']/div/div[4]/div[2]/div/input")
	public static WebElement reviewTestParaMeterEditIconPopDesiTypeTextBox;
	// Cancel button
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[1]")
	public static WebElement reviewTestParaMeterEditIconPopCancelButtonProps;
	// update button
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[2]")
	public static WebElement reviewTestParaMeterEditIconPopUpdateButtonProps;
	// Close button
	@FindBy(xpath = "//span[@aria-label='close']//*[name()='svg']")
	public static WebElement reviewTestParaMeterEditIconPopCloseButtonProps;
	// Value field Text box
	@FindBy(xpath = "//input[@id='value']")
	public static WebElement reviewTestParaMeterValueTextBox;
	// Type Drop down
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/form[2]//div[2]//td[4]/div/div/span[1]")
	public static WebElement reviewTestParaMeterTypeDropDow;

	// Test Configure - Configure Test Table- Top Bar "Add Key Test" - "Material" -
	// Radio Button Properties
	@FindBy(xpath = "//div[contains(@class,'ant-radio-group-outline')]/label[2]/span[1]")
	public static WebElement materualRadioButton;
	// material heading
	@FindBy(xpath = "//div[contains(@class,'ant-radio-group-outline')]/label[2]/span[2]")
	public static WebElement materialHeadingProps;

	/******
	 * Added By Shangeetha on 07/07/2023
	 **************************************/

	// Configure Equation Tab - Equation Type Action-"Edit Icon" Pop-Up
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement configEquActionEditIconPop;

	// Configure Equation Tab - Equation Type Action- Edit Icon Pop up Screen -
	// "Edit Equation" Heading
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[1]/div")
	public static WebElement configEquActionEditIconPopHeading;

	// Configure Equation Tab - Equation Type Action- Edit Icon Pop up Screen -
	// "Edit Equation" Text Box
	@FindBy(xpath = "//input[@id='equation_formula']")
	public static WebElement configEquActionEditIconPopEditEqTextBox;

	// Configure Equation Tab - Equation Type Action- Edit Icon Pop up Screen -
	// "Update" Button
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[3]/div/button[2]")
	public static WebElement configEquActionEditIconPopUpdateBtn;

	// Configure Equation Tab - Equation Type Action- Edit Icon Pop up Screen -
	// "Cancel" Button
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[3]/div/button[1]")
	public static WebElement configEquActionEditIconPopCancelBtn;

	// Configure Equation Tab - Equation Type Action- Edit Icon Pop up Screen -
	// "Close" Button
	@FindBy(xpath = "//div[@class='ant-modal-content']/button")
	public static WebElement configEquActionEditIconPopCloseBtn;

	// Test Configure - Configure Test Table- Top Bar "Accepted criteria" icon "4"
	@FindBy(xpath = "//main/div/div/div[2]/div/div[1]/div/div/div[4]/div/div[2]")
	public static WebElement acceptedCriteriaFourthNumberIcon;

	// Test Configure - Configure Test Table- Top Bar "Accepted criteria" UI Heading
	@FindBy(xpath = "//main/div/div/div[2]/div/div[1]/div/div/div[4]/div/div[3]/div/p")
	public static WebElement acceptedCriteriaHeading;

	// Test Configure - Configure Test Table- Top Bar Accepted criteria -"Accepted
	// Value" Top Heading
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/div/div/p")
	public static WebElement acceptedCriteriaAcccetedValueTilte;

	// Configure Equation Tab - Equation Type Action Column-"Delete" Icon Pop-Up
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement configEquActionDeleteIconPop;

	// Configure Equation Tab - Equation Type Action Column-"Delete Pop up Screen
	// "?" icon
	@FindBy(xpath = "//div[@class='ant-popover-content']/div[2]/div/div[1]/span")
	public static WebElement configEquActionDeleteIconPopQuestionMark;

	// Configure Equation Tab - Equation Type - Delete Pop up Screen "OK" Button
	@FindBy(xpath = "//div[@class='ant-popover-content']/div[2]/div/div[2]/button[2]")
	public static WebElement configEquActionDeleteIconPopOkBtn;

	// Configure Equation Tab - Equation Type Action Column - Delete Pop up Screen
	// "Cancel" Button
	@FindBy(xpath = "//div[@class='ant-popover-content']/div[2]/div/div[2]/button[1]")
	public static WebElement configEquActionDeleteIconPopCancelBtn;

	// Configure Equation Tab - "Save Equation" Button
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[3]/button")
	public static WebElement configEquationTabSaveEquationlBtn;

	// Select Test Parameter Text Box
	@FindBy(xpath = "//input[@id='parameter']/../..")
	public static WebElement acceptedCriteriaSelectTestParameterDropdownTextBox;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table -
	// "Test" Radio Button
	@FindBy(xpath = "//main//form/div[1]/div[1]/div[2]/div/span/label/span[1]")
	public static WebElement acceptedCriteriaTestRadioButton;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table -
	// "Test" Radio Button Label
	@FindBy(xpath = "//main//form/div[1]/div[1]/div[2]/div/span/label/span[2]")
	public static WebElement acceptedCriteriaTestRadioButtonLabel;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table -
	// "Material" Radio Button
	@FindBy(xpath = "//main//form/div[1]/div[1]/div[2]/div/label/span[1]")
	public static WebElement acceptedCriteriaMaterialRadioButton;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table -
	// "Material" Radio Button Label
	@FindBy(xpath = "//main//form/div[1]/div[1]/div[2]/div/label/span[2]")
	public static WebElement acceptedCriteriaMaterialRadioButtonLabel;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -"Common" Radio Button
	@FindBy(xpath = "//main//form/div[1]/div[2]/div[2]/div[1]/label[1]/span[1]")
	public static WebElement acceptedCriterialCommonRadioButton;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -"Common" Radio Button Label
	@FindBy(xpath = "//main//form/div[1]/div[2]/div[2]/div[1]/label[2]/span[2]")
	public static WebElement acceptedCriterialIndividualRadioButtonLabel;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -"Individual" Radio Button
	@FindBy(xpath = "//main//form/div[1]/div[2]/div[2]/div[1]/label[2]/span[1]")
	public static WebElement acceptedCriterialIndividualRadioButton;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -"Individual" Radio Button Label
	@FindBy(xpath = "//main//form/div[1]/div[2]/div[2]/div[1]/label[1]/span[2]")
	public static WebElement acceptedCriterialCommonRadioButtonLabel;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -"Relevant To Results" Check Box
	@FindBy(xpath = "//main//form/div[1]/div[1]/div[3]/div[1]/label[2]/span")
	public static WebElement acceptedCriterialRelevantToResultsCheckBox;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -"Relevant To Results" Check Box Label
	@FindBy(xpath = "//main//form/div[1]/div[1]/div[3]/div[1]/label[1]")
	public static WebElement acceptedCriterialRelevantToResultsCheckBoxLabel;

	// RAHUL.S (07/07/2023)
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement addTestPopUP;

	// RAHUL.S (07/07/2023)
	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	public static WebElement successMessages;

	// RAHUL.S (07/07/2023)
	@FindBy(xpath = "//a[@class='ant-notification-notice-close']")
	public static WebElement successMessageCloseBtn;

	@FindBy(xpath = "//li[@title='Next Page']/button")
	public static WebElement NextPageBtn;

	@FindBy(xpath = "//tr[1]/td[1]")
	public static WebElement firstRowData;

	@FindBy(xpath = "//input[@id='test_name']/../div[1]")
	public static WebElement testValidation;

	/*******************
	 * Added By Shangeetha on 08/07/2023
	 ***************************************************************************/
	//
	//	// Configure Test Table,Top Bar Accepted criteria, Accepted Value - "Equation
	//	// Condition Selection" DropDown Text Box
	//	@FindBy(xpath = "//main//input[@id='condition']")
	//	// Configure Test Table,Top Bar Accepted criteria, Accepted Value - "Equation Condition Selection" DropDown Text Box
	//	@FindBy(xpath="//main//form/div[1]/div[3]/div[1]/div/div/div")
	//	public static WebElement equationConditionSelectionDropdownTextBox;

	// Configure Test Table,Top Bar Accepted criteria, Accepted Value - "Equation
	// Condition Selection" DropDown Text Box
	@FindBy(xpath = "//main//form/div[1]/div[3]/div[1]/div/div/div")
	public static WebElement equationConditionSelectionDropdownTextBox;

	// Top Bar Accepted criteria, Accepted Value,Select Between- "Material" Heading
	@FindBy(xpath = "//main//form/div[1]/div[4]//thead/tr/th[1]/div/span[1]")
	public static WebElement equationConditionBetweenMaterialHeading;

	// Top Bar Accepted criteria, Accepted Value,Select Between- "Material" Column
	// Search Icon
	@FindBy(xpath = "//main//form/div[1]/div[4]//thead/tr/th[1]/div/span[2]/span")
	public static WebElement equationConditionBetweenMaterialColumnSearchIcon;

	// Top Bar Accepted criteria, Accepted Value,Select Between- "Material" Column
	// Search Icon's Pop Up
	@FindBy(xpath = "//input[contains(@placeholder, 'Search name')]/ancestor::div[@class='ant-table-filter-dropdown']")
	public static WebElement equationConditionBetweenMaterialColSearchPopUp;

	// Top Bar Accepted criteria, Accepted Value,Select Between- "Material" Column
	// Search Pop Up, Search Button
	@FindBy(xpath = "//input[contains(@placeholder, 'Search name')]/ancestor::div[@class='ant-table-filter-dropdown']/div/div/div[1]/button")
	public static WebElement equationConditionBetweenMaterialColSearchPopSearchBtn;

	// Top Bar Accepted criteria, Accepted Value,Select Between- "Material" Column
	// Search Pop Up, Reset Button
	@FindBy(xpath = "//input[contains(@placeholder, 'Search name')]/ancestor::div[@class='ant-table-filter-dropdown']/div/div/div[2]/button")
	public static WebElement equationConditionBetweenMaterialColSearchPopResetBtn;

	// Top Bar Accepted criteria, Accepted Value,Select Between- "Material" Column
	// Search Pop Up, Search Text Box
	@FindBy(xpath = "//input[contains(@placeholder, 'Search name')]")
	public static WebElement equationConditionBetweenMaterialColSearchPopSearchTextBox;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table -Save
	// Button
	@FindBy(xpath = "//main//form/div[1]/div[6]/button")
	public static WebElement acceptedCriteriaSaveButton;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Parameter Column Heading
	@FindBy(xpath = "//main//form/div[2]//th[1]/div/span[1]")
	public static WebElement acceptedCriteriaTableTwoParameterColumnHeading;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Parameter Column Search Icon
	@FindBy(xpath = "//main//form/div[2]//th[1]/div/span[2]/span")
	public static WebElement acceptedCriteriaTableTwoParameterColumnSearchIcon;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Parameter Column Search Pop-Up
	@FindBy(xpath = "//input[@name='testParamName']/ancestor::div[@class='ant-table-filter-dropdown']")
	public static WebElement acceptedCriteriaTableTwoParameterColSrchPop;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Parameter Column Search Pop-Up, Search Button
	@FindBy(xpath = "//input[@name='testParamName']/ancestor::div[@class='ant-table-filter-dropdown']/div/div/button[1]")
	public static WebElement acceptedCriteriaTableTwoParameterColSrchPopSearchBtn;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Parameter Column Search Pop-Up, Reset Button
	@FindBy(xpath = "//input[@name='testParamName']/ancestor::div[@class='ant-table-filter-dropdown']/div/div/button[2]")
	public static WebElement acceptedCriteriaTableTwoParameterColSrchPopResetBtn;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Parameter Column Search Pop-Up, Search Text Box
	@FindBy(xpath = "//input[@name='testParamName']")
	public static WebElement acceptedCriteriaTableTwoParameterColSrchPopSearchTextBox;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Material Column Heading
	@FindBy(xpath = "//main//form/div[2]//th[2]/div/span[1]")
	public static WebElement acceptedCriteriaTableTwoMaterialColumnHeading;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Material Column Search Icon
	@FindBy(xpath = "//main//form/div[2]//th[2]/div/span[2]/span")
	public static WebElement acceptedCriteriaTableTwoMaterialColumnSearchIcon;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Material Column Search Pop-Up
	@FindBy(xpath = "//input[@name='materialName']/ancestor::div[@class='ant-table-filter-dropdown']")
	public static WebElement acceptedCriteriaTableTwoMaterialColSrchPop;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Material Column Search Pop-Up, Search Button
	@FindBy(xpath = "//input[@name='materialName']/ancestor::div[@class='ant-table-filter-dropdown']/div/div/button[1]")
	public static WebElement acceptedCriteriaTableTwoMaterialColSrchPopSearchBtn;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Material Column Search Pop-Up, Reset Button
	@FindBy(xpath = "//input[@name='materialName']/ancestor::div[@class='ant-table-filter-dropdown']/div/div/button[2]")
	public static WebElement acceptedCriteriaTableTwoMaterialColSrchPopResetBtn;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Material Column Search Pop-Up, Search Text Box
	@FindBy(xpath = "//input[@name='materialName']")
	public static WebElement acceptedCriteriaTableTwoMaterialColSrchPopSearchTextBox;
	// Test Configure - Configure Test Table- Top Bar "Add Key Test" - "Select For
	// Key Test" - Heading UI Properties
	@FindBy(xpath = "//div[@class='ant-table-wrapper']//div[@class='ant-table-header']//th[2]")
	public static WebElement selectForKeyTestHead;
	// Test Configure - Configure Test Table- Top Bar "Add Key Test" - "Select For
	// Key Test" - Heading Check box Properties
	@FindBy(xpath = "//div[@class='ant-table-wrapper']//div[@class='ant-table-header']//th[1]")
	public static WebElement selectForKeyTestHeadCheckBox;
	// Test Configure - Configure Test Table- Top Bar "Add Key Test" - Select For
	// Key Test Under- "+" icon Properties
	@FindBy(xpath = "//td//button[@type='button'][1]")
	public static WebElement selectForKeyTestPlusIconOne;
	// Save button
	@FindBy(xpath = "//div[@class='ant-table-footer']//button/span")
	public static WebElement selectForKeyTestSaveButton;
	// Dropdown
	@FindBy(xpath = "//input[@id='SubCategory']")
	public static WebElement selectForKeyDropDown;
	// Name Heading
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[2]")
	public static WebElement selectForKeyNameHeading;
	// Save button
	@FindBy(xpath = "//div[@class='ant-table-footer']//button")
	public static WebElement selectForKeyMaterSaveButton;
	// Next button
	@FindBy(xpath = "//div[@class='steps-action']/button[1]")
	public static WebElement selectForKeyMaterNextButton;
	// Previous button
	@FindBy(xpath = "//div[@class='steps-action']/button[2]")
	public static WebElement selectForKeyMaterPrevButton;
	// Reset button
	@FindBy(xpath = "//div[@class='steps-action']/button[3]")
	public static WebElement selectForKeyMaterResButton;

	// Search Material Text Box
	@FindBy(xpath = "//input[@name='prefix']")
	public static WebElement selectForKeyMaterSearchMatTextBox;

	// @FindBy(xpath = "//input[@id='test_name']/../div[1]")
	// public static WebElement testValidation;

	// ********************************SHOBIKA********************************************************/

	@FindBy(xpath = "//main/div/div/div[1]/div/div[3]")
	public static WebElement testconfigureButton;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[1]/div/div/div[1]/div/div[3]//p")
	public static WebElement configuretesthading;

	@FindBy(xpath = "//header[@class='ant-layout-header']")
	public static WebElement TestConfigureTestTableHeading;

	@FindBy(xpath = "//div//div//div[1]//div[2]//div[2]//div[@class='ant-steps-item-icon']//span[1]")
	public static WebElement TopBarConfigureTesticon;

	@FindBy(xpath = "//input[@id='test']/ancestor::div[@class='input_wrapper']//label")
	public static WebElement TestUIHeading;

	@FindBy(xpath = "//input[@id='test']")
	public static WebElement testDropdown;

	@FindBy(xpath = "//input[@id='test_type']/ancestor::div[@class='input_wrapper']//label")
	public static WebElement TesttypeUIHeading;

	@FindBy(xpath = "//input[@id='test_type']")
	public static WebElement testtypeDropdown;

	@FindBy(xpath = "//input[@id='prefix']/ancestor::div[@class='input_wrapper']//label")
	public static WebElement prefixUIHeading;

	@FindBy(xpath = "//input[@name='prefix']")
	public static WebElement prefixdropdown;

	@FindBy(xpath = "//input[@id='main_category']/ancestor::div[@class='input_wrapper']//label")
	public static WebElement maincategoryHeading;

	@FindBy(xpath = "//input[@id='main_category']")
	public static WebElement maincategorydropdown;

	@FindBy(xpath = "//input[@id='sub_category']/ancestor::div[@class='input_wrapper']//label")
	public static WebElement subcategoryheading;

	@FindBy(xpath = "//input[@id='sub_category']/..")
	public static WebElement subcategorydropdown;

	@FindBy(xpath = "//input[@id='material']/ancestor::div[@class='input_wrapper']//label")
	public static WebElement sheading;

	@FindBy(xpath = "//textarea[@id='description']/ancestor::div[@class='input_wrapper']//label")
	public static WebElement descriptionHeading;

	@FindBy(xpath = "//textarea[@id='description']")
	public static WebElement descriptiontextbox;

	@FindBy(xpath = "//textarea[@id='procedure']/ancestor::div[@class='input_wrapper']//label")
	public static WebElement procedureeading;

	@FindBy(xpath = "//textarea[@id='procedure']")
	public static WebElement proceduretextbox;

	@FindBy(xpath = "//input[@id='report_format']/ancestor::div[@class='input_wrapper']//label")
	public static WebElement reportformatheading;

	@FindBy(xpath = "//input[@class='ant-checkbox-input']/ancestor::div[@class='input_wrapper']//label[1]")
	public static WebElement activeheading;

	/***************
	 * Added By Shangeetha on 10/07/2023
	 *****************************************************************************/
	/***************
	 * Added By Shangeetha on 10/07/2023
	 *****************************************************************************/

	/***************
	 * Added By Shangeetha on 10/07/2023
	 *****************************************************************************/

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Condition Column Heading
	@FindBy(xpath = "//main//form/div[2]//th[3]/div/span[1]")
	public static WebElement acceptedCriteriaTableTwoConditionColumnHeading;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Condition Column Search Icon
	@FindBy(xpath = "//main//form/div[2]//th[3]/div/span[2]/span")
	public static WebElement acceptedCriteriaTableTwoConditionColumnSearchIcon;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Condition Column Search Pop-Up
	@FindBy(xpath = "//input[@id='condition']/ancestor::div[@class='ant-table-filter-dropdown']")
	public static WebElement acceptedCriteriaTableTwoConditionColSrchPop;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Condition Column Search Pop-Up, Search Button
	@FindBy(xpath = "//input[@id='condition']/ancestor::div[@class='ant-table-filter-dropdown']/div/div/button[1]")
	public static WebElement acceptedCriteriaTableTwoConditionColSrchPopSearchBtn;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Condition Column Search Pop-Up, Reset Button
	@FindBy(xpath = "//input[@id='condition']/ancestor::div[@class='ant-table-filter-dropdown']/div/div/button[2]")
	public static WebElement acceptedCriteriaTableTwoConditionColSrchPopResetBtn;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Condition Column Search Pop-Up, Search DropDown Text Box
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//div[@name='condition']")
	public static WebElement acceptedCriteriaTableTwoConditionColSrchPopSearchDropDownTextBox;

	// Top Bar Accepted criteria, Accepted Value,Select Between- "Minimum" Heading
	@FindBy(xpath = "//main//form/div[1]/div[4]//thead/tr/th[2]/div/div[1]")
	public static WebElement equationConditionBetweenMinimumHeading;

	// Top Bar Accepted criteria, Accepted Value,Select Between- "Maximum" Heading
	@FindBy(xpath = "//main//form/div[1]/div[4]//thead/tr/th[2]/div/div[3]")
	public static WebElement equationConditionBetweenMaximumHeading;

	/*****************
	 * Added By Shangeetha on 11/07/2023
	 ************************************************************************************/

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table -Value
	// Column Heading
	@FindBy(xpath = "//main//form/div[2]//th[4]")
	public static WebElement acceptedCriteriaTableTwoValueColumnHeading;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column Heading
	@FindBy(xpath = "//main//form/div[2]//th[6]")
	public static WebElement acceptedCriteriaTableTwoActionColumnHeading;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Relevant To Results Column Heading
	@FindBy(xpath = "//main//form/div[2]//th[5]")
	public static WebElement acceptedCriteriaTableTwoRelevantToResultsColumnHeading;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement acceptedCriteriaTableTwoActionColEditPop;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement acceptedCriteriaTableTwoActionColDeletePop;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up heading
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[1]/div/div/p")
	public static WebElement acceptedCriteriaTableTwoActionColEditPopHeading;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up Update Button
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[3]/button[2]")
	public static WebElement acceptedCriteriaTableTwoActionColEditPopUpdateBtn;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up Cancel Button
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[3]/button[1]")
	public static WebElement acceptedCriteriaTableTwoActionColEditPopCancelBtn;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up Close Button
	//	@FindBy(xpath = "//div[@class='ant-modal-content']/div[1]/div/div/span")
	//	//Configure Test Table-  Top Bar Accepted criteria  - Accepted Value Table -Action Column: Edit Icon Pop-Up Close Button
	//	@FindBy(xpath = "//div[@class='ant-modal-content']/div[1]/div/div/span/*[starts-with(name(), 'svg')]")
	//	public static WebElement acceptedCriteriaTableTwoActionColEditPopCloseBtn;
	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up Close Button
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[1]/div/div/span/*[starts-with(name(), 'svg')]")
	public static WebElement acceptedCriteriaTableTwoActionColEditPopCloseBtn;

	// Configure Test Table-Additional Information Pop-up-Add Field- Action -Delete
	// Icon -Popup XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement additionalinfoaddActionPopupDeletePopupscreen;

	// Configure Test Table-Additional Information Pop-up-Add Field- Action -Delete
	// Icon -Ok Button XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-content']//button[2]")
	public static WebElement additionalinfoaddActionPopupDeleteokButton;

	// Configure Test Table-Additional Information Pop-up-Add Field- Action -Delete
	// Icon -Cancel Button XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-content']//button[1]")
	public static WebElement additionalinfoaddActionPopupDeleteCancelButton;

	// Top Bar Accepted criteria, Accepted Value,Select Between- "Minimum" Heading
	// @FindBy(xpath="//main//form/div[1]/div[4]//thead/tr/th[2]/div/div[1]")
	// public static WebElement equationConditionEqualMinimumHeading;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up, "Parameter" Label
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[1]/div/div/label")
	public static WebElement tableTwoActionColEditPopParameterLabel;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up, "Parameter" Drop-down Text Box
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[1]/div/div/div/div")
	public static WebElement tableTwoActionColEditPopParameterDropdownTextBox;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up, "Raw Material" Label
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[3]/div/div/label")
	public static WebElement tableTwoActionColEditPopRawMaterialLabel;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up, "Raw Material" Drop-down TextBox
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[3]/div/div/div/div")
	public static WebElement tableTwoActionColEditPopRawMaterialDropTextBox;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up, "EquationParameter" Label
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[2]/div/div/label")
	public static WebElement tableTwoActionColEditPopEquationParameterLabel;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up, "EquationParameter" Drop-down TextBox
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[2]/div/div/div/div")
	public static WebElement tableTwoActionColEditPopEquationParameterDropTextBox;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up, "Equation" Drop-down TextBox
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[6]/div[1]/div/div/div")
	public static WebElement tableTwoActionColEditPopEquationDropTextBox;

	// 13/07/2023 Additional Information Properties M.Mathushan

	// 13/07/2023 Additional Information Properties M.Mathushan

	@FindBy(xpath = "//main/div/div/div[2]/div/div[1]/div/div[1]/div[7]/div/div[2]")
	public static WebElement additionalInformationseveniconprop;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[1]/div/div[1]/div[7]/div/div[3]/div/p")
	public static WebElement additionalInformationheadingprop;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/div/div/p")
	public static WebElement additionalInformationtopUIheadingprop;

	@FindBy(xpath = "//form[@id='test']/div[1]/div[1]/div/div[1]/label")
	public static WebElement additionalInformationcaptionUIheadingprop;

	@FindBy(xpath = "//input[@id='caption']")
	public static WebElement additionalInformationcaptiontextboxprop;

	@FindBy(xpath = "//form[@id='test']/div[1]/div[2]/div/div[1]/label")
	public static WebElement additionalInformationReporttypeUIheadingprop;

	@FindBy(xpath = "//input[@id='recordType']")
	public static WebElement additionalInformationReporttypetextboxprop;

	@FindBy(xpath = "//form[@id='test']/div[1]/div[3]/div/div[1]/label")
	public static WebElement additionalInformationmaxlengthheadingprop;

	@FindBy(xpath = "//input[@id='length']")
	public static WebElement additionalInformationmaxlengthtextboxprop;

	@FindBy(xpath = "//form[@id='test']/div[1]/div[4]/div/div[1]/label")
	public static WebElement additionalInformationactiveheadingprop;

	@FindBy(xpath = "//input[@id='dynamic_form_nest_item_users_0_active']/..")
	public static WebElement additionalInformationactivecheckboxprop;

	@FindBy(xpath = "//form[@id='test']/div[1]/div[5]/button")
	public static WebElement additionalInformationactiveremoveiconprop;

	@FindBy(xpath = "//form[@id='test']/div[2]//button")
	public static WebElement additionalInformationaddfeildbuttonprop;

	@FindBy(xpath = "//form[@id='test']/div[3]/div/div/div//button[1]")
	public static WebElement additionalInformationaddfeildclearbuttonprop;

	@FindBy(xpath = "//form[@id='test']/div[3]/div/div/div//button[2]")
	public static WebElement additionalInformationaddfeildaddbuttonprop;

	@FindBy(xpath = "//div[@class='ant-table-wrapper']//thead//th[1]")
	public static WebElement additionalInformationaddfeildcaptionheadingprop;

	@FindBy(xpath = "//div[@class='ant-table-wrapper']//thead//th[2]")
	public static WebElement additionalInformationaddfeildMaxlengthheadingprop;

	@FindBy(xpath = "//div[@class='ant-table-wrapper']//thead//th[3]")
	public static WebElement additionalInformationaddfeildrecordtypeheadingprop;

	@FindBy(xpath = "//div[@class='ant-table-wrapper']//thead//th[4]")
	public static WebElement additionalInformationaddfeildstatusheadingprop;

	@FindBy(xpath = "//div[@class='ant-table-wrapper']//thead//th[5]")
	public static WebElement additionalInformationaddfeildactionheadingprop;

	// Edit By - K.Saranga -------------13.07.2023
	// Test Configure - "Accepted Condition" - Top Number Icon
	@FindBy(xpath = "//main/div/div/div[2]/div/div[1]/div/div/div[6]/div/div[2]")
	public static WebElement acceptedConditionNumberIcon;

	// Test Configure - "Accepted Condition" - Main Heading
	@FindBy(xpath = "//main/div/div/div[2]/div/div[1]/div/div/div[6]/div/div[3]")
	public static WebElement acceptedConditionheading;

	// Test Configure - "Add Condition" - Heading
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]")
	public static WebElement addConditionheading;

	// Test Configure - "Add Condition" Table Parameter Heading
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div/div/div/table[1]/thead/tr/th[1]")
	public static WebElement addconditiontableparameterheading;

	// Test Configure - "Add Condition" Table Abbreviation Heading
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div/div/div/table[1]/thead/tr/th[2]")
	public static WebElement addconditiontableAbbreviationheading;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up, "Relevant To Test" Label
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[7]/div/div/label[1]")
	public static WebElement tableTwoActionColEditPopRelevantToTestLabel;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up, "Relevant To Test" Check Box
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[7]/div/div/label[2]/span")
	public static WebElement tableTwoActionColEditPopRelevantToTestCheckBox;
	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up, "Relevant To Test" Check Box
	@FindBy(xpath = "//div[contains(@class,'ant-radio-group-outline')]/label[1]/span[2]")
	public static WebElement addKeyTestSubCatHead;

	
	 //* Added By Shangeetha***********13/07/2023
	 
	// Top Bar Accepted criteria, Accepted Value,Select Between- "Minimum" Text Box
	@FindBy(xpath = "//main//form/div[1]/div[4]//tbody/tr[2]/td[2]/div/div/div//*[@id='min']")
	public static WebElement equationConditionBetweenMinimumTextBox;

	// Top Bar Accepted criteria, Accepted Value,Select Between- "Maximum" Text Box
	@FindBy(xpath = "//main//form/div[1]/div[4]//tbody/tr[2]/td[2]/div/div/div//*[@id='max']")
	public static WebElement equationConditionBetweenMaximumTextBox;

	// Top Bar Accepted criteria, Accepted Value,Select Equal To- "Value" Heading
	@FindBy(xpath = "//main//form/div[1]/div[4]//thead/tr/th[2]")
	public static WebElement equationConditionEqualValueHeading;

	// Top Bar Accepted criteria, Accepted Value,Select Equal To- "Value" Text Box
	@FindBy(xpath = "//main//form/div[1]/div[4]//tbody/tr[2]/td[2]//*[@id='value']")
	public static WebElement equationConditionEqualValueTextBox;

	
	//






	//*on 12.07.2023*******************************SHOBIKA********************************************************/

	@FindBy(xpath = "//input[@name='active']/..")
	public static WebElement activecheckbox;

	// *on
	// 13.07.2023*******************************SHOBIKA********************************************************/
	@FindBy(xpath = "//button[@type='button']/ancestor::div[@class='input_wrapper']//label")
	public static WebElement duedayheading;

	// 13.07.2023*******************************SHOBIKA********************************************************/

	@FindBy(xpath = "//div[@class='input_wrapper']//button\r\n")
	public static WebElement togglebutton;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/div[2]/div[5]//button")
	public static WebElement submitbutton;

	@FindBy(xpath = "//div[@class='steps-action']//button")
	public static WebElement nextbutton;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[1]/div/div/div[2]/div")
	public static WebElement topbartestparametericon;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[1]/div/div/div[2]/div/div[3]//p")
	public static WebElement topbartestparameterhading;

	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/form[1]//div[@class='ant-table-title']")
	public static WebElement tbheading;
	
	
	//Created By M.Mathushan 14/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement  addFieldActionEditIconCancelButtonPopupScreenProperties;
	
	@FindBy(xpath = "//div[@class='ant-popover-content']/div[2]/div/div[2]/button[1]")
	public static WebElement  editIconCancelButtonPopupScreenCancelButtonProperties;
	
	@FindBy(xpath = "//div[@class='ant-popover-content']/div[2]/div/div[2]/button[2]")
	public static WebElement  editIconCancelButtonPopupScreenOkButtonProperties;
	

	// Configure Test Table-Additional Information Pop-up-Add Field- Action -Delete
	// Icon -"?" icon XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-content']//*[@viewBox]")
	public static WebElement additionalinfoaddActionPopupDeleteQuestionmarkIon;

	// Configure Test Table-Additional Information Pop-up-Add Field- "Next" button
	// XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//div[@class='steps-action']//button[1]")
	public static WebElement additionalinfoaddnextbutton;

	// Configure Test Table-Additional Information Pop-up-Add Field- "Previous"
	// button
	// XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//div[@class='steps-action']//button[2]")
	public static WebElement additionalinfoaddpreviousbutton;

	// Configure Test Table-Additional Information Pop-up-Add Field- "Reset"
	// button XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//div[@class='steps-action']//button[3]")
	public static WebElement additionalinfoaddResetbutton;

	// Configure Test Table-Top Bar Review Test -"Review Test" UI Heading XPath -
	// N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div/div/div/div[6]//p")
	public static WebElement reviewTestHeading;

	// Configure Test Table-Top Bar Review Test -"Configure Test" UI Heading XPath -
	// N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div[1]/div/div")
	public static WebElement configureTestHeading;

	@FindBy(xpath = "//thead[@class='ant-table-thead']//tr/th[1]//div[@class='ant-table-filter-column']")
	public static WebElement tbdataheading;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up, "Equation Minimum Value's" TextBox
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[6]/div[2]/div/div//*[@id='finishPDAcMin']")
	public static WebElement tableTwoActionColEditPopEquationMinimumTextBox;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up, "Equation Maximum Value's" TextBox
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[6]/div[2]/div/div//*[@id='finishPDAcMax']")
	public static WebElement tableTwoActionColEditPopEquationMaximumTextBox;

	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up, "Equation Maximum Value's" TextBox
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[6]/div[2]/div/div[3]//button")
	public static WebElement tableTwoActionColEditPopEquationToTextBox;
	// Configure Test Table- Top Bar Accepted criteria - Accepted Value Table
	// -Action Column: Edit Icon Pop-Up, "Equation Maximum Value's" TextBox
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[6]/div[2]/div/div[3]//button")
	public static WebElement tableTwoActionColEditPopEquationToButton;
	// *on*****12.07.2023*******************************SHOBIKA********************************************************/
	@FindBy(xpath = "//tr/th[1]//div[@class='ant-table-filter-column']//span[@role='button']")
	public static WebElement pmsearchicon;

	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']")
	public static WebElement pmsearchpopup;

	@FindBy(xpath = "//input[@placeholder=' Parameter']")
	public static WebElement pmsearchtextbox;

	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//button[1]")
	public static WebElement pmsearchbutton;

	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//button[2]")
	public static WebElement pmresetbutton;
	
	@FindBy(xpath = "//tr//th[2]//div[@class='ant-table-filter-column']")
	public static WebElement tatatypetopdataheading;
	
	@FindBy(xpath = "//tr//th[2]//div[@class='ant-table-filter-column']//span[2]")
	public static WebElement datatypesearchicon;
	
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']")
	public static WebElement pmdatatypepopup;
	
	@FindBy(xpath = "//input[@id='material']")
	public static WebElement materialdropdown;

	

	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement editiconpopup;


	// Edit By - K.Saranga ------------------

	// Test Configure - "Add Condition" Table Relevant Heading
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div/div/div/table[1]/thead/tr/th[3]")
	public static WebElement addconditiontableRelevantheading;

	// Test Configure - "Add Condition" Table Relevant CheckBox
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div/div/div[2]/table/tbody/tr[2]/td[3]")
	public static WebElement addconditiontableRelevantcheckbox;

	// Test Configure - "Add Condition" Main TextBox
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[1]/div/div/div/textarea")
	public static WebElement addconditiontablemaintextbox;

	// Test Configure - "Add Condition" U icon
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div/div[2]/div/h2")
	public static WebElement acceptedconditionUicon;

	// Test Configure - "Add Condition" n icon
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div/div[1]/div/h2")
	public static WebElement acceptedconditionNicon;

	// Test Configure - "Add Condition" ( icon
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div/div[3]/div/h2")
	public static WebElement acceptedconditionbracketicon;

	// Test Configure - "Add Condition" ) icon
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div/div[4]/div/h2")
	public static WebElement acceptedconditionicon;

	// Test Configure - "Add Condition" Condition Sub Heading
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[5]/div/div/div/div/div/table/thead/tr/th[1]")
	public static WebElement conditionsubheading;

	// Test Configure - "Add Condition" Condition Action Heading
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[5]/div/div/div/div/div/table/thead/tr/th[2]")
	public static WebElement conditionactionheading;

	// Test Configure - "Add Condition" Next Button
	@FindBy(xpath = "//main/div/div/div[2]/div/div[3]/button[1]")
	public static WebElement addconditionnxtbtn;

	// Configure Test Table,Top Bar Accepted criteria, Accepted Value - "Select Test
	// Equation" DropDown Text Box
//	@FindBy(xpath = "//main//form/div[1]/div[2]/div[1]/div/div/div")
	//Test Configure - "Add Condition" Previous Button
	@FindBy(xpath ="//main/div/div/div[2]/div/div[3]/button[2]")
	public static WebElement addconditionpreviousbtn;

	//Test Configure - "Add Condition" Reset Button
	@FindBy(xpath ="//main/div/div/div[2]/div/div[3]/button[3]")
	public static WebElement addconditionresetbtn;

	//Test Configure - "Add Condition" Edit Icon Pop up
	@FindBy(xpath ="//div[@class='ant-modal-content']")
	public static WebElement actioncolumnediticonpopup;

	//Test Configure - "Add Condition" Edit Icon Pop up Screen Edit Condition Heading
	@FindBy(xpath ="//div[@class='ant-modal-title']")
	public static WebElement editConditionHeading;

	//Test Configure - "Add Condition" Edit Icon Pop up Screen TextBox
	@FindBy(xpath ="//div[@class='ant-modal-body']/textarea")
	public static WebElement editiconpopuptextbox;

	//Test Configure - "Add Condition" Edit Icon Pop up Screen Cancel Btn
	@FindBy(xpath ="//div[@class='ant-modal-footer']/div/button[1]")
	public static WebElement editiconpopupcancelbtn;

	//Test Configure - "Add Condition" Edit Icon Pop up Screen Update Btn
	@FindBy(xpath ="//div[@class='ant-modal-footer']/div/button[2]")
	public static WebElement editiconpopupupdatebtn;


	// Configure Test Table,Top Bar Accepted criteria, Accepted Value - "Select Test Equation" DropDown Text Box
	@FindBy(xpath="//main//form/div[1]/div[2]/div[1]/div/div/div")
	public static WebElement selectTestEquationDropdownTextBox;

	// Test Configure - Configure Test Table- Top Bar Accepted criteria - Accepted
	// Value Table - Pagination Drop down Properties
	@FindBy(xpath = "//main//form//li[@class='ant-pagination-options']/div/div[1]")
	public static WebElement acceptedCriteriaPaginationDropdownTextBox;
  
	//Config Equation: Test Parameter Dropdown Text Box   ********Added on 14/07/2023
	@FindBy(xpath="//main//div[@class='ant-select-selector']")
	public static WebElement configureEquationTestparameterdropdown;

	//Config Equation: Parameter Column Heading   ********Added on 14/07/2023
	@FindBy(xpath="//main/div/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div//thead//th[1]")
	public static WebElement configureEquationTestParameterColumnHeading;

	//Config Equation: Abbreviation Column Heading   ********Added on 14/07/2023
	@FindBy(xpath="//main/div/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div//thead//th[2]")
	public static WebElement configureEquationTestAbbreviationColumnHeading;



	//Config Equation: Unit Column Heading   ********Added on 14/07/2023
	@FindBy(xpath="//main/div/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div//thead//th[3]")
	public static WebElement configureEquationTestUnitColumnHeading;

	//Config Equation: Relevant Column Heading   ********Added on 14/07/2023
	@FindBy(xpath="//main/div/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div//thead//th[4]")
	public static WebElement configureEquationTestRelevantColumnHeading;

	// Configure Test Table-Top Bar Review Test - Configure Test -"Test" UI Sub
	// Heading XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/div/div/div/div/div/div/table//th[1]")
	public static WebElement configuretestTestsubHeading;

	// Configure Test Table-Top Bar Review Test - Configure Test -"Type" UI Sub
	// Heading XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/div/div/div/div/div/div/table//th[2]")
	public static WebElement configuretestTypesubHeading;

	// Configure Test Table-Top Bar Review Test - Configure Test -"Prefix" UI Sub
	// Heading XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/div/div/div/div/div/div/table//th[3]")
	public static WebElement configuretestPrefixsubHeading;

	// Configure Test Table-Top Bar Review Test - Configure Test -"Due Day (s)" UI
	// Sub
	// Heading XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/div/div/div/div/div/div/table//th[4]")
	public static WebElement configuretestDueDayssubHeading;

	// Configure Test Table-Top Bar Review Test - Configure Test -"Equation" UI
	// Top Heading XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/div[1]/div/div")
	public static WebElement configuretestEquationHeading;

	// Configure Test Table-Top Bar Review Test - Equation -"Parameter" UI
	// sub Heading XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div/div/div/div/div/div/table//th[1]")
	public static WebElement equationParameterHeading;

	// Configure Test Table-Top Bar Review Test - Equation -"Equation" UI
	// sub Heading XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div/div/div/div/div/div/table//th[2]")
	public static WebElement equationEquationsubHeading;

	// Configure Test Table-Top Bar Review Test - Equation -"Type" UI
	// sub Heading XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div/div/div/div/div/div/table//th[3]")
	public static WebElement equationTypesubHeading;

	// Configure Test Table-Top Bar Review Test -"Test Parameters" UI
	// Top Heading XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[3]/div/div[1]/div/div")
	public static WebElement testParametersHeading;

	// Configure Test Table-Top Bar Review Test -"Test Parameters" -"Parameter" UI
	
	// Sub Heading XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[3]/div/div[2]/div/div/div/div/div/div[1]/table//th[1]")
	public static WebElement testParametersParametersubHeading;

	//******on 15.07.2023*******************SHOBIKA***********************************************
	@FindBy(xpath = "//tr//th[2]//div[@class='ant-table-filter-column']")
	public static WebElement tcheading;
	
	@FindBy(xpath = "//div[@name='report_format']")
	public static WebElement reportformatdropdown;
	
	@FindBy(xpath = "//div[@class='ant-modal-title']")
	public static WebElement edittestpopheading;
	
	@FindBy(xpath = "//div[@class='ant-popover-inner']")
	public static WebElement deleteiconoposcreen;
	
	@FindBy(xpath = "//div[@class='ant-popover-inner']//button[2]")
	public static WebElement deleteiconoposcreenokbtn;
	
	@FindBy(xpath = "//div[@class='ant-popover-inner']//button[1]")
	public static WebElement deleteiconoposcreencancelbtn;
	
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement tpmediticonpopup;
	
	@FindBy(xpath = "//div[@class='ant-modal-content']//p")
	public static WebElement tpmediticonpopupheading;
	
	@FindBy(xpath = "//div[@class='ant-modal-content']//button[2]")
	public static WebElement tpmediticonpopupupdatebtn;
	
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement deleteiconpopupscreen;
	
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement deleteiconpopupscreenicon; 
	
	@FindBy(xpath = "//div[@class='ant-popover-content']//button[2]")
	public static WebElement deleteiconpopupscreenokbutton;
	
	@FindBy(xpath = "//div[@class='ant-popover-content']//button[1]")
	public static WebElement deleteiconpopupscreencancelbutton;
	
	@FindBy(xpath = "//div[@class='ant-popover-message']//span")
	public static WebElement deleteiconoposcreenicon; 
	
	@FindBy(xpath = "//section/section/main/div/div/div[1]/div/div[2]/div[1]")
	public static WebElement tesrparameterButton;

	
	// Configure Test Table-Top Bar Review Test -"Test Parameters" -"Abbreviation"
	// UI
	// Sub Heading XPath - N.Karunya -Date: 14/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[3]/div/div[2]/div/div/div/div/div/div[1]/table//th[2]")
	public static WebElement testParametersAbbreviationsubHeading;

	// Configure Test Table-Top Bar Review Test -"Test Parameters" -"Input Method"
	// UI Sub Heading XPath - N.Karunya -Date: 14/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[3]/div/div[2]/div/div/div/div/div/div[1]/table//th[3]")
	public static WebElement testParametersInputMethodsubHeading;

	// Configure Test Table-Top Bar Review Test -"Test Parameters" -"Type"
	// UI Sub Heading XPath - N.Karunya -Date: 14/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[3]/div/div[2]/div/div/div/div/div/div[1]/table//th[4]")
	public static WebElement testParametersTypesubHeading;

	// Configure Test Table-Top Bar Review Test -"Test Parameters" -"Decimal Value"
	// UI Sub Heading XPath - N.Karunya -Date: 14/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[3]/div/div[2]/div/div/div/div/div/div[1]/table//th[5]")
	public static WebElement testParametersDecimalValuesubHeading;

	// Configure Test Table-Top Bar Review Test -"Test Parameters" -"Unit"
	// UI Sub Heading XPath - N.Karunya -Date: 14/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[3]/div/div[2]/div/div/div/div/div/div[1]/table//th[6]")
	public static WebElement testParametersUnitsubHeading;

	// Configure Test Table-Top Bar Review Test -"Test Parameters" -"Value"
	// UI Sub Heading XPath - N.Karunya -Date: 14/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[3]/div/div[2]/div/div/div/div/div/div[1]/table//th[7]")
	public static WebElement testParametersValuesubHeading;

	// Configure Test Table-Top Bar Review Test -"Material Accepted Value" UI
	// Top Heading XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[5]/div[1]/div/div[1]/div/div")
	public static WebElement materialAcceptedValueHeading;

	// Configure Test Table-Top Bar Review Test -"Material Accepted Value"
	// -"Parameter"
	// UI Sub Heading XPath - N.Karunya -Date: 14/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div[1]/div[5]/div[1]/div/div[2]/div/div/div/div/div/div[1]//th[1]")
	public static WebElement materialAcceptedValueParametersubHeading;

	// Configure Test Table-Top Bar "Review Test" icon "8" UI
	// Top Heading XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//main/div/div/div[2]/div/div/div/div/div[6]/div/div[2]")
	public static WebElement iconEight;

	//Configure Test Table- Accepted Condition - Action - Delete Popup Cancel Button XPath - N.Karunya -
	// Date: 14/07/2023
	@FindBy(xpath = "// div[@class='ant-popover-buttons']//button[1]")
	public static WebElement deletepopupcancelbutton;

	//Edit By - K.Saranga ------------------

	//Test Configure - "Add Condition" Edit Icon Pop up Screen Close Icon
	@FindBy(xpath ="//span[@class='ant-modal-close-x']/span")
	public static WebElement editiconpopupupcloseicon;

	//Test Configure - "Add Condition" Save Equation Button
	@FindBy(xpath ="//main/div/div/div[2]/div/div[2]/div/div[3]/div[2]/button")
	public static WebElement saveequationbutton;

	//Test Configure - "Add Condition" Delete Icon Pop up
	@FindBy(xpath ="//div[@class='ant-popover-content']")
	public static WebElement deleteiconpopup;

	//Test Configure - "Add Condition" Delete Icon Pop up Question Icon
	@FindBy(xpath ="//span[contains(@class,'anticon-question-circle')]")
	public static WebElement deleteiconpopupquestionicon;

	//Test Configure - "Add Condition" Delete Icon Pop up Ok Button
	@FindBy(xpath ="//div[@class='ant-popover-buttons']/button[2]")
	public static WebElement deleteiconpopupokbutton;

	//Test Configure - "Add Condition" Delete Icon Pop up Cancel Button
	@FindBy(xpath ="//div[@class='ant-popover-buttons']/button[1]")
	public static WebElement deleteiconpopupcancelbutton;

}

