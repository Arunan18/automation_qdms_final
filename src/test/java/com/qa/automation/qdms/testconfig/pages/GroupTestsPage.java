package com.qa.automation.qdms.testconfig.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.automation.qdms.base.DriverIntialization;

public class GroupTestsPage extends DriverIntialization {

	// * Group Test Expected Window Heading
	@FindBy(xpath = "//div[@class='ant-table-title']//div//div[contains(text(),'Group Tests')]")
	public static WebElement grouptestheading;

	// * Main Category Search Icon
	@FindBy(xpath = "(//span[@role='button'])[2]")
	public static WebElement maincatsearchicon;

	// * Main Category Search TextBox
	@FindBy(xpath = "//input[@placeholder=' Category Name']")
	public static WebElement maincatsearchtextbox;

	// * Main Category Search Button
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement maincatsearchbutton;

	// * COLOUM NO FOR MAIN CATGORY
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[2]")
	public static List<WebElement> tableColoumnoMaincategory;

	// * Main Category Reset Button
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement resetbtn;

	// * Table Container
	@FindBy(xpath = "//div[@class='ant-table-content']")
	public static WebElement tablecontainer;

	// * COLOUM NO FOR SUB CATGORY
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[3]")
	public static List<WebElement> tableColoumnoSubcategory;

	// * Sub Category Search Icon
	@FindBy(xpath = "(//span[@role='button'])[3]")
	public static WebElement subcatsearchicon;

	// * Sub Category Search TextBox
	@FindBy(xpath = "//input[@placeholder=' Sub Category Name']")
	public static WebElement subcatsearchtextbox;

	// * Raw Material Search Icon
	@FindBy(xpath = "(//span[@aria-label='search'])[4]")
	public static WebElement rawmatsearchicon;

	// * Raw Material Search TextBox
	@FindBy(xpath = "//input[@placeholder=' Raw Material Name']")
	public static WebElement rawmatsearchtextbox;

	// * COLOUM NO FOR RAW MATERIAL
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[3]")
	public static List<WebElement> tableColoumnorawmaterial;

	// * Group Type Search Icon
	@FindBy(xpath = "(//span[@aria-label='search'])[5]")
	public static WebElement groupsearchicon;

	// * Raw Material Search TextBox
	@FindBy(xpath = "//div[@name='groupType']//div[@class='ant-select-selector']")
	public static WebElement groupsearchtextbox;

	// * COLOUM NO FOR RAW MATERIAL
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[4]")
	public static List<WebElement> tableColoumnogroupmaterial;

	// * GROUP TEXT CONTAINER
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement grouptestcontainer;

	// * CREATE GROUP NAME
	@FindBy(xpath = "//*[@id='group_name']")
	public static WebElement groupname;

	// * GROUP NAME VALIDATION
	@FindBy(xpath = "//form/div[4]/div/div[1]/div/div/div")
	public static WebElement groupnamevalidation;

	// TESTS//
	// TESTS ICON
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/form/div/div/div/div/div[2]/div/table/tbody/tr[1]/td[6]/span/span/span")
	public static WebElement testIcon;

	// TESTs HEADING POPUP
	@FindBy(xpath = "/html/body/div[4]/div/div[2]/div/div[2]/div[1]/div/div/div/div/div/div[1]/table/thead/tr/th[1]/text()")
	public static WebElement testheadingpopup;

	// CLOSE BUTTON IN TESTS
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/button/span/span")
	public static WebElement testIconClose;

	// DELETE ICON IN TESTS
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[1]/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]/span/span/a/span")
	public static WebElement deleteIconinGroupTest;

	// DELETE OK BUTTON IN TESTS
	@FindBy(xpath = "/html/body/div[4]/div/div/div/div[2]/div/div[2]/button[2]/span")
	public static WebElement deleteokbuttoninGroupTest;

	// DELETE CANCEL BUTTON IN TESTS
	@FindBy(xpath = "/html/body/div[4]/div/div/div/div[2]/div/div[2]/button[1]/span")
	public static WebElement deletecancelbuttoninGroupTest;

	// GROUP TEST CONTAINER
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/form/div/div/div/div/div[2]")
	public static WebElement GroupTesttableContainer;

	// GROUP TEST INSIDE CONTAINER
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[1]/div/div/div/div/div")
	public static WebElement GroupTestinsideContainer;

	// DATA REMOVED SUCCESMESSAGE NOTIFICATION
	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div/div[1]")
	public static WebElement TestDeletensuccessmsg;

	// @Sasi - Modified :- 23-06-2023

	// Manage Test "Group Test" Site Button XPath
	@FindBy(xpath = "//div[@class='sc-gzVnrw flBzTM']")
	public static WebElement groupTestSiteBtn;

	// Manage Test "Group Test" Table Heading XPath
	@FindBy(xpath = "//div[@class='ant-table-title']")
	public static WebElement groupTestTableHeading;

	// Manage Test "Group Test" Group Name Heading XPath
	@FindBy(xpath = "//span[@class='ant-table-column-title' and text()='Group Name']")
	public static WebElement groupNameHeading;

	// "Group Test" Group Name Search icon XPath
	@FindBy(xpath = "//th[1]//span[@role='img']")
	public static WebElement groupNameSearchicon;

	// "Group Test" Group Name Search Button XPath
	@FindBy(xpath = "//button[@type='button']//span[text()='Search']")
	public static WebElement groupNameSearchButton;

	// "Group Test" Group Name Text Box XPath
	@FindBy(xpath = "//input[@placeholder=' Group Name']")
	public static WebElement groupNameTextBox;

	// "Group Test" Group Name Search PopUp XPath
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']")
	public static WebElement groupNameSearchpopup;

	// "Group Test" Group Name Reset Button XPath
	@FindBy(xpath = "//button[@type='button']//span[text()='Reset']")
	public static WebElement groupNameResetButton;

	// Manage Test "Group Test" Main Category Heading XPath
	@FindBy(xpath = "//span[@class='ant-table-column-title' and text()='Main Category']")
	public static WebElement mainCategoryHeading;

	// "Group Test" Main Category Search icon XPath
	@FindBy(xpath = "//th[2]//span[@role='img']")
	public static WebElement mainCategorySearchicon;

	// "Group Test" Main Category Search PopUp XPath
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']")
	public static WebElement mainCategorySearchpopup;

	// "Group Test" Main Category Text Box XPath
	@FindBy(xpath = "//input[@placeholder=' Category Name']")
	public static WebElement mainCategoryTextBox;

	// "Group Test" Main Category Search Button XPath
	@FindBy(xpath = "//button[@type='button']//span[text()='Search']")
	public static WebElement mainCategorySearchButton;

	// "Group Test" Main Category Reset Button XPath
	@FindBy(xpath = "//button[@type='button']//span[text()='Reset']")
	public static WebElement mainCategoryResetButton;

	// Manage Test "Group Test" Sub Category Heading XPath
	@FindBy(xpath = "//span[@class='ant-table-column-title' and text()='Sub Category']")
	public static WebElement subCategoryHeading;

	// "Group Test" Sub Category Search icon XPath
	@FindBy(xpath = "//th[3]//span[@role='img']")
	public static WebElement subCategorySearchicon;

	// "Group Test" Sub Category Search PopUp XPath
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']")
	public static WebElement subCategorySearchpopup;

	// "Group Test" Sub Category Text Box XPath
	@FindBy(xpath = "//input[@placeholder=' Sub Category Name']")
	public static WebElement subCategoryTextBox;

	// "Group Test" Sub Category Search Button XPath
	@FindBy(xpath = "//button[@type='button']//span[text()='Search']")
	public static WebElement subCategorySearchButton;

	// "Group Test" Sub Category Reset Button XPath
	@FindBy(xpath = "//button[@type='button']//span[text()='Reset']")
	public static WebElement subCategoryResetButton;

	// Manage Test "Group Test" Raw Material Heading XPath
	@FindBy(xpath = "//span[@class='ant-table-column-title' and text()='Raw Material']")
	public static WebElement rawMaterialHeading;

	// "Group Test" Raw Material Search icon XPath
	@FindBy(xpath = "//th[4]//span[@role='img']")
	public static WebElement rawMaterialSearchicon;

	// "Group Test" Raw Material Search PopUp XPath
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']")
	public static WebElement rawMaterialSearchpopup;

	// "Group Test" Raw Material Text Box XPath
	@FindBy(xpath = "//input[@placeholder=' Raw Material Name']")
	public static WebElement rawMaterialTextBox;

	// "Group Test" Raw Material Search Button XPath
	@FindBy(xpath = "//button[@type='button']//span[text()='Search']")
	public static WebElement rawMaterialSearchButton;

	// "Group Test" Raw Material Reset Button XPath
	@FindBy(xpath = "//button[@type='button']//span[text()='Reset']")
	public static WebElement rawMaterialResetButton;

	// Manage Test "Group Type" Heading XPath
	@FindBy(xpath = "//span[@class='ant-table-column-title' and text()='Group Type']")
	public static WebElement groupTypeHeading;

	// "Group Test" Group Type Search icon XPath
	@FindBy(xpath = "//th[5]//span[@role='img']")
	public static WebElement groupTypesSearchicon;

	// "Group Test" Group Type Search PopUp XPath
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']")
	public static WebElement groupTypeSearchpopup;

	// "Group Test" Group Type DropDown XPath
	@FindBy(xpath = "//input[@id='groupType']")
	public static WebElement groupTypedropdown;

	// "Group Test" Group Type Search Button XPath
	@FindBy(xpath = "//button[@type='button']//span[text()='Search']")
	public static WebElement groupTypeSearchButton;

	// "Tests" Table Heading XPath
	@FindBy(xpath = "//thead//th[6]")
	public static WebElement testtableheading;

	// "Tests" Icon Pop up XPath
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement testcolumnpopup;

	// "Tests" Pop up Screen tests heading XPath
	@FindBy(xpath = "//div[@class='ant-table-header']/table/thead/tr/th[1]")
	public static WebElement testcolumnpopuptestheading;

	// "Tests" Pop up Screen action heading XPath
	@FindBy(xpath = "//div[@class='ant-table-header']/table/thead/tr/th[2]")
	public static WebElement testcolumnpopupactionheading;

	// "Action" Column Delete Icon Pop up XPath
	@FindBy(xpath = "//div[@class='ant-popover-inner-content']")
	public static WebElement actioncolumnpopup;

	// "Action" Column Delete Pop up Screen Question Icon XPath
	@FindBy(xpath = "//div[@class='ant-popover-inner-content']/div/span")
	public static WebElement actionpopupquestionicon;

	// "Action" Column Delete Pop up Screen Ok Button XPath
	@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[2]")
	public static WebElement actionpopupokbutton;

	// "Action" Column Delete Pop up Screen Cancel Button XPath
	@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[1]")
	public static WebElement actionpopupcancelbutton;

	// "Tests" Column Pop up Screen Close Icon XPath
	@FindBy(xpath = "//span[@class='ant-modal-close-x']/span")
	public static WebElement testspopupcloseicon;

	// "Action" Table Heading XPath
	@FindBy(xpath = "//thead//th[7]")
	public static WebElement actiontableheading;

	// "Action" EditIcon Pop up XPath
	@FindBy(xpath = "//div//form")
	public static WebElement actionediticonpopup;

	// Material Main Category Heading XPath
	@FindBy(xpath = "//form/div[2]/div[1]/div/label")
	public static WebElement materialmaincategoryheading;

	//Sub Category Heading XPath
	@FindBy(xpath = "//form/div[2]/div[2]/div/label")
	public static WebElement editiconpopupsubcategoryheading;

	//Select Material Heading XPath
	@FindBy(xpath = "//form/div[2]/div[3]/div/label")
	public static WebElement editiconpopupselectmaterialheading;

	//Report Type Heading XPath
	@FindBy(xpath = "//div[@class='ant-row'][3]/div[2]/div[1]/div/div[1]/label/span[2]")
	public static WebElement editiconpopupreporttypeheading;

	//Special Category Heading XPath
	@FindBy(xpath = "//div[@class='ant-row'][3]/div[2]/div[1]/div/div[2]/label/span[2]")
	public static WebElement editiconpopupspecialcategoryheading;

	//Special Category Check Box Icon XPath
	@FindBy(xpath = "//div[@class='ant-row'][3]/div[2]/div[1]/div/div[2]/label/span[1]")
	public static WebElement editiconpopupspecialcategorycheckbox;

	//Report Type Check Box Icon XPath
	@FindBy(xpath = "//div[@class='ant-row'][3]/div[2]/div[1]/div/div[1]/label/span[1]")
	public static WebElement editiconpopupreporttypecheckbox;

	//Create Group Heading XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div[4]/div[1]/div[1]/h4")
	public static WebElement editiconpopupcreategroupheading;

	//EditIcon Pop up Name Heading XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div[4]/div[1]/div[1]/div/div/label")
	public static WebElement editiconpopupnameheading;

	//EditIcon Pop up Name TextBox XPath
	@FindBy(xpath = "//input[@class='ant-input']")
	public static WebElement editiconpopupnametextbox;

	//EditIcon Pop up Report Format Heading XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div[4]/div[1]/div[1]/div/div[2]/label")
	public static WebElement editiconpopupreportformatheading;

	//EditIcon Pop up Applicable Tests Heading XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div[4]/div[2]/h4")
	public static WebElement editiconpopupapplicabletestsheading;

	//EditIcon Pop up Test Name XPath
	@FindBy(xpath = "//form/div[4]/div[2]/div[1]/div/div/div/div/div/table/thead/tr/th[2]")
	public static WebElement editiconpopuptestname;

	//EditIcon Pop up Test Name Check Box XPath
	@FindBy(xpath = "//form/div[4]/div[2]/div[1]/div/div/div/div/div/table/thead/tr/th[1]")
	public static WebElement editiconpopuptestnamecheckboxicon;

	//EditIcon Pop up Pagination Next Button XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div[4]/div[2]/div/div/div/ul/li[3]")
	public static WebElement editiconpopupnextbutton;

	//EditIcon Pop up Pagination Previous Button XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div[4]/div[2]/div/div/div/ul/li[1]")
	public static WebElement editiconpopuppreviousbutton;

	//EditIcon Pop up Pagination Previous Button XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div[4]/div[1]/div[2]/form/div/div/div/div/div/div/h4")
	public static WebElement editiconpopupconfiguredgroups;

	//EditIcon Pop up Group Name XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div[4]/div[1]/div[2]/form/div/div/div/div/div[2]/div/table/thead/tr/th[1]")
	public static WebElement editiconpopupgroupname;

	//EditIcon Pop up Report Format XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div[4]/div[1]/div[2]/form/div/div/div/div/div[2]/div/table/thead/tr/th[2]")
	public static WebElement editiconpopupreportformat;

	//EditIcon Pop up Tests XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div[4]/div[1]/div[2]/form/div/div/div/div/div[2]/div/table/thead/tr/th[3]")
	public static WebElement editiconpopuptests;

	//EditIcon Pop up Action XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div[4]/div[1]/div[2]/form/div/div/div/div/div[2]/div/table/thead/tr/th[4]")
	public static WebElement editiconpopupaction;

	//Configured Groups Pagination Previous Button XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div[4]/div//form/div/div/div/ul/li[1]")
	public static WebElement configuredgrouppaginationpreviousbtn;

	//Configured Groups Pagination Next Button XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div[4]/div//form/div/div/div/ul/li[3]")
	public static WebElement configuredgrouppaginationnextbtn;

	//Group Tests Pagination Previous Button XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div/div/div/ul/li[2]/button")
	public static WebElement grouptestspreviousbtn;

	//Group Tests Pagination Next Button XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div/div/div/ul/li[6]")
	public static WebElement grouptestsnextbtn;

	//Tests Column Pop up Screen Action column Delete Icon XPath
	@FindBy(xpath = "//div[@class='ant-modal-root']/div/div/div[2]/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]/span")
	public static WebElement testspopupactioncolumndeleteicon;

	//Tests Icon Pop up Screen Action Delete Icon Pop up XPath
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement actionColumnDeleteIconPopup;

	//Tests Icon Pop up Screen - Action Delete Icon Pop up - Question Icon XPath
	@FindBy(xpath = "//div[@class='ant-popover-inner-content']/div/span")
	public static WebElement actionColumnDeleteIconPopupquestionIcon;

	//Tests Icon Pop up Screen - Action Delete Icon Pop up - Ok Button XPath
	@FindBy(xpath = "//div[@class='ant-popover-inner-content']/div[2]/button[2]")
	public static WebElement actionColumnDeleteIconPopupOkBtn;

	//Tests Icon Pop up Screen - Action Delete Icon Pop up - Cancel Button XPath
	@FindBy(xpath = "//div[@class='ant-popover-inner-content']/div[2]/button[1]")
	public static WebElement actionColumnDeleteIconPopupCancelBtn;

	//Action Edit Icon Pop up - Tests Column Icon pop up XPath
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement testscolumnPopup;

	//Action Edit Icon Pop up - Tests Column Icon pop up - Tests Heading XPath
	@FindBy(xpath = "//div[@class='ant-modal-content']/div/div/div/div/div/div/div/table/thead/tr/th[1]")
	public static WebElement testscolumnPopuptestsheading;

	//Action Edit Icon Pop up - Tests Column Icon pop up - Close Icon XPath
	@FindBy(xpath = "//div[@class='ant-modal-content']/button/span/span")
	public static WebElement testscolumnPopupCloseIcon;

	//Action Edit Icon Pop up - Action Column Delete Icon Pop up XPath
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement actioncolumndeleteiconpopup;

	// qdms/automation/properties/test-config-saranga
	//Action Edit Icon Pop up - Action Column Delete Icon Pop up - Question Icon XPath
	@FindBy(xpath = "//div[@class='ant-popover-inner-content']/div/span")
	public static WebElement actioncolumndeleteiconquestionicon;

	//Action Edit Icon Pop up - Action Column Delete Icon Pop up - Ok Button XPath
	@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[2]")
	public static WebElement actioncolumndeleteiconokbtn;

	//Action Edit Icon Pop up - Action Column Delete Icon Pop up - Cancel Button XPath
	@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[1]")
	public static WebElement actioncolumndeleteiconcancelbtn;

	//Config Group Test Table Clear Button XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div[5]/button[1]")
	public static WebElement configgrouptestclearbtn;

	//Config Group Test Table Edit Button XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div[5]/button[2]")
	public static WebElement configgrouptesteditbtn;

	// Material Main Category TextBox XPath
	@FindBy(xpath = "//form/div[2]/div[1]/div/div")
	public static WebElement materialmaincategorytextbox;

	//Sub Category TextBox XPath
	@FindBy(xpath = "//form/div[2]/div[2]/div/div[1]")
	public static WebElement editiconpopupsubcategorytextbox;

	//Select Material TextBox XPath
	@FindBy(xpath = "//form/div[2]/div[3]/div/div[1]/div/span[2]")
	public static WebElement editiconpopupselectmaterialtextbox;

	//Select Report type check box XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div[3]/div/div/div/div[1]/label/span[1]/input")
	public static WebElement reporttypecheckbox;
	// qdms/automation/properties/test-config

	//Configure Test XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/div[1]/div/div/div[1]/div/div[3]/div")
	public static WebElement configuretest;

	//Grouptests Drop down XPath
	@FindBy(xpath = "//span[@class='ant-select-selection-item']")
	public static WebElement grouptestsdropdown;

	//GroupName Search Icon XPath
	@FindBy(xpath = "//form/div/div/div/div/div[2]/div/table/thead/tr/th[1]/div/span[2]")
	public static WebElement groupNameSearchIcon;

	//GroupName Text Box XPath
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']/div/input")
	public static WebElement groupNameTextBoxx;

	//GroupName Reset All Button XPath
	@FindBy(xpath = "//form/div/div/div/div/div/div/button")
	public static WebElement groupNameResetAllBtn;

	//Config Group Tests Report Format Heading XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div[4]/div[1]/div[1]/div/div[2]/div/div/span/input")
	public static WebElement editiconpopupreportformatDropdown;

	//Main test configurations XPath
	@FindBy(xpath = "//main/div/div/div/div[2]")
	public static WebElement testconfigurationsmain;

	//Sub test configurations XPath
	@FindBy(xpath = "//main/div/div/div/div/div[3]")
	public static WebElement testconfiguresub;

	//Equation No Data Icon XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div/div/div/div/div/table/tbody/tr/td/div/div[1]")
	public static WebElement equationnodataicon;

	//Test Parameters Screen No Data XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div/div/div[2]/table/tbody/tr[2]/td/div/div[1]")
	public static WebElement testparametersnodataicon;

	//Material Accepted Value Screen No Data XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div/div/div[2]/table/tbody/tr[2]/td/div/div[1]")
	public static WebElement MaterialAcceptedValueScreennodataicon;

	//Key Test Screen No Data XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[5]/div[3]/div/div[2]/div/div/div/div/div/div[2]/table/tbody/tr[2]/td/div/div[1]")
	public static WebElement KeyTestScreennodataicon;

	//Edit By - K.Saranga-------------13.07.2023-------------

	//Accepted Condition No Data XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div[7]/div[2]/div/div[2]/div/div/div/div/div/div/table/tbody/tr/td/div/div[1]")
	public static WebElement acceptedConditionnodataicon;

	//Additional Information Screen No Data XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/div/form/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td/div/div[1]")
	public static WebElement additionalInformationScreenicon;

	//Accepted criteria Screen No Data XPath
	@FindBy(xpath = "//main/div/div/div[2]/div/div[2]/div/div/div/form/div/div[4]/div/div/div/div/div[1]/div[2]/table/tbody/tr[2]/td/div/div[1]")
	public static WebElement acceptedcriteriaScreenicon;

	//Accepted Condition Table XPath
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[1]/div[2]/div[5]/div/div/div/div/div[2]/table/tbody/tr[2]/td/div/div[1]")
	public static WebElement acceptedConditionTable;

	//Material text XPath
	@FindBy(xpath = "//span[text()='Material']")
	public static WebElement materialtext;

	//Material No Data text XPath
	@FindBy(xpath = "//div[@class='ant-spin-nested-loading']/div/div/div/div[2]/table/tbody/tr[2]/td/div/div[1]")
	public static WebElement materialnodataicon;

	//Edit By -K.Saranga

	@FindBy(xpath = "//main/div/div/div[1]/div/div[4]")
	public static WebElement ConfigGroupTestBtn;
	
	@FindBy(xpath = "//input[@id='material_category']")
	public static WebElement MaterialMainCategorytextbox;
	
	@FindBy(xpath = "//main/div/div/div[2]/div/form/div[4]/div[1]/div[2]/form/div/div/div/div/div[2]/div/table/tbody/tr/td/div/div[1]")
	public static WebElement ConfiguredGroupTableNoData;



}
