package com.qa.automation.qdms.testconfig.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.automation.qdms.base.DriverIntialization;

public class ManageTestsPage extends DriverIntialization {

	@FindBy(xpath = "//a[@href='#/managetests']")
	public static WebElement managetestconfigure;

	@FindBy(xpath = "//div[text()=' Manage Test Configuration ']")
	public static WebElement managetestconfigureheading;

	// sub category

	/* Manage Test Heading */

	@FindBy(xpath = "(//span[@role='button'])[3]")
	public static WebElement subcategorysearchicon;

	// * Configure Equation Container
	@FindBy(xpath = "(//div[@class='ant-spin-container'])[2]")
	public static WebElement configureequationcontainer;

	// EDIT ICON POPUP HEADING EDIT
	@FindBy(xpath = "//p[normalize-space()='Edit Test Configuration']")
	public static WebElement EditIconHeading;

	// EDIT ICON POPUP HEADING EDIT
	@FindBy(xpath = "//*[@id=\"rcDialogTitle1\"]")
	public static WebElement testparameterEditHeading;

	// ADDITIONAL INFORMATION DELETE ICON FUNCTION TABLE CONTAINER 2
	@FindBy(xpath = "(//tbody)[2]")
	public static WebElement additionalinformationtablecontainer2;

	// ACCEPTED VALUE DELETE ICON FUNCTION TABLE CONTAINER 2
	@FindBy(xpath = "(//tbody)[2]")
	public static WebElement acceptedvaluetablecontainer2;

	// TEST PARAMETER
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[8]/span/span")
	public static WebElement TestparameterIcon;

	// ACCEPTED CONDITION DELETE ICON FUNCTION TABLE CONTAINER 4

	@FindBy(xpath = "(//tbody)[3]")
	public static WebElement acceptedconditiontablecontainer4;

	// * TEST PARAMETER TABLE CONTAINER
	@FindBy(xpath = "//div[@class='ant-modal-body']")
	public static WebElement testparametertablecontainer;

	// * TEST PARAMETER CONFIRM OK BUTTON
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']/span")
	public static WebElement confirmokbtn;

	// TEST PARAMETER CLOSE BUTTON
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-ghost sc-gZMcBi dMdnOw']")
	public static WebElement Testparameterclosebuttonedit;

	@FindBy(xpath = "//input[@placeholder='Sub Category']")
	public static WebElement subcategorysearchtextbox;

	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']/div/div/button[1]")
	public static WebElement subcategorysearchbutton;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[4]")
	public static List<WebElement> subcategoryColumn;

	public static String subcategoryBeforesearch = "//tbody[@class='ant-table-tbody']/tr[";
	public static String subcategoryAftersearch = "]/td[4]";

	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']/div/div/button[2]")
	public static WebElement subcategoryResetbutton;

	// raw material
	@FindBy(xpath = "(//span[@role='button'])[4]")
	public static WebElement rowmaterialsearchicon;

	@FindBy(xpath = "//input[@placeholder='Raw Material']")
	public static WebElement rowmaterialsearchtextbox;

	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']/div/div/button[1]")
	public static WebElement rowmaterialsearchbutton;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[5]")
	public static List<WebElement> rowmaterialColumn;

	public static String rowmaterialBeforesearch = "//tbody[@class='ant-table-tbody']/tr[";
	public static String rowmaterialAftersearch = "]/td[5]";

	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']/div/div/button[2]")
	public static WebElement rowmaterialResetbutton;

	/* Manage Test Heading */
	@FindBy(xpath = "//div[contains(text(),'Manage Test Configuration')]")
	public static WebElement managetestheading;

	/* Test Search Icon */
	@FindBy(xpath = "//thead[@class='ant-table-thead']/tr/th[1]/div/span[2]")
	public static WebElement testsearchicon;

	/* Test Search Text box */
	@FindBy(xpath = "//input[@placeholder='Test']")
	public static WebElement testtextbox;

	/* Main Category Search Icon */
	@FindBy(xpath = "(//span[@aria-label='search'])[2]")
	public static WebElement maincategorysearchicon;

	/* Main Category Text box */
	@FindBy(xpath = "//input[@placeholder='Main Category']")
	public static WebElement maincategorytextbox;

	/* Sub Category Search Icon */
	@FindBy(xpath = "(//span[@aria-label='search'])[3]")
	public static WebElement subcategoryicon;

	/* Main Category Text box */
	@FindBy(xpath = "//input[@placeholder='Sub Category']")
	public static WebElement subcategorytextbox;

	/* Raw Material Search Icon */
	@FindBy(xpath = "(//span[@aria-label='search'])[4]")
	public static WebElement rawmaterialicon;

	/* Raw Material Text box */
	@FindBy(xpath = "//input[@placeholder='Raw Material']")
	public static WebElement rawmaterialtextbox;

	/* Test Type Search Icon */
	@FindBy(xpath = "(//span[@aria-label='search'])[5]")
	public static WebElement testtypeicon;

	/* Test Type Text box */
	@FindBy(xpath = "//div[@name='mainType']//div[@class='ant-select-selector']")
	public static WebElement testtypetextbox;

	/* Due Day Search Icon */
	@FindBy(xpath = "(//span[@aria-label='search'])[5]")
	public static WebElement duedayicon;

	/* Due Day Text box */
	@FindBy(xpath = "//input[@placeholder='Due Day']")
	public static WebElement duedaytextbox;

	/* Search Button */
	@FindBy(xpath = "(//button[@type='button'])[3]")
	public static WebElement searchbtn;

	/* Table Container */
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static WebElement tablecontainernew;

	/* Manage Test Table Container */
	@FindBy(xpath = "//div[@class='ant-table-container']")
	public static WebElement managetexttablecontainer;

	// sub category

	/* Table Container */
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> tablecontainer;

	// MANAGE TEST ACCEPTED VALUE DELETE BUTTON FUNTION
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/form/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[5]/span/a[2]/a/span")
	public static WebElement ManageTestAcceptedValueDeleteButtonFuntion;

	// Accepted Value Delete Button Window Heading
	@FindBy(xpath = "/html/body/div[4]/div/div/div/div[2]/div/div[1]/div")
	public static WebElement AcceptedValueDeleteButtonWindowHeading;

	// Can't Delete this module
	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	public static WebElement CantDeletethismodule;

	// Manage Test Equation Value Delete Button Function
	@FindBy(xpath = "//div[@class='ant-table-content']//span[@class='anticon anticon-delete']")
	public static WebElement ManageTestEquationValueDeleteButtonFuntion;

	// Equation Value Delete Button Window Heading
	@FindBy(xpath = "/html/body/div[7]/div/div/div/div[2]/div/div[1]/div")
	public static WebElement EquationValueDeleteButtonWindowHeading;

	/* Caption Field */
	@FindBy(xpath = "//input[@id='caption']")
	public static WebElement captionfield;

	/* Record Type Dropdown */
	@FindBy(xpath = "//input[@id='recordType']")
	public static WebElement recordtypefield;

	/* Max Length */
	@FindBy(xpath = "//input[@id='length']")
	public static WebElement maxlengthfield;

	/* Add Files */
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-dashed ant-btn-block']")
	public static WebElement addfilesbtn;

	/* Add Button */
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement addbtn;

	/* Add Button */
	@FindBy(xpath = "//div[@class='ant-form-item-control-input-content']//span[@class='ant-checkbox']")
	public static WebElement checkbox;

	// * Success Message
	@FindBy(xpath = "//div[contains(@class,'ant-notification ant-notification-topRight')]//div")
	public static WebElement successMsg;

	// * Table Page DropDown X_path before
	public static String before = "(//div[contains(@class,'ant-select-item-option')]//div[contains(.,'page')])[";

	// * Table Page DropDown X_path after
	public static String after = "]/div";

	// SUCESS MESSAGE - EDIT MANAGE TEST
	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	public static WebElement editSuceesMessage;

	// SUCESS MESSAGE - DELETE MANAGE TEST
	@FindBy(xpath = "(//div[@class='ant-notification-notice-message'])[1]")
	public static WebElement DeleteSucessMessageMangeTest;

	/* Add Button */
	@FindBy(xpath = "//*[@id='equation_formula']")
	public static WebElement EditEquipment;

	@FindBy(xpath = "//li[@title='Next Page']//button")
	public static WebElement next;

	@FindBy(xpath = "//input[@id='dueDayEdit']")
	public static WebElement duedatetextbox;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[4]/div[1]/div/div")
	public static WebElement duedatevalidationmessage;

	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[@type='button']/span[text()='Cancel']")
	public static WebElement edittestconfigcancelbutton;

	// POPUP EDIT BTN
	@FindBy(xpath = "(//span[@aria-label='edit'])[11]")
	public static WebElement editBtnPopup;

	// POPUP EDIT CANCEL
	@FindBy(xpath = "(//button[@type='button'])[8]")
	public static WebElement EditPopUpCancelbtn;

	// POPUP SAVE BUTTON X PATH
	@FindBy(xpath = "//div[text()='Edit Equation']/../following::div[5]//span[text()='Save']/..")
	public static WebElement SaveBtnPopup;

	// DELETE MESSAGE
	@FindBy(xpath = "//div[contains(text(),'Test Record Deleted Sucessfully')]")
	public static WebElement DeleteSucessMessage;

	// Accepted Condition Table Container
	@FindBy(xpath = "//div[@class='ant-col ant-col-14']//div[@class='ant-table-container']")
	public static WebElement acceptedcondition;

	// Edit Condition TextArea
	@FindBy(xpath = "//textarea[@id='equation_formula']")
	public static WebElement editconditiontxtarea;

	// Edit Condition Update Button
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[2]")
	public static WebElement updatebtn;

	// Edit Condition Cancel Button
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[1]")
	public static WebElement cancelbtn;

	@FindBy(xpath = "//tbody/tr[3]/td[2]/span[1]/span[1]")
	public static WebElement keytesticon;

	// KEY TEST HEADING
	@FindBy(xpath = "//*[@id=\"rcDialogTitle0\"]")
	public static WebElement Editkeytestheading;

	// KEY TEST CLOSE ICON
	@FindBy(xpath = "//span[@aria-label='close']")
	public static WebElement EditkeytestClose;

	// KEY TEST RETURN BUTTON
	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement Editkeytestreturn;

	@FindBy(xpath = "//td[@class='ant-table-cell ant-table-selection-column']")
	public static WebElement EditkeytestCheckbox;
	// Accepted Condition Heading
	@FindBy(xpath = "//div[@id='rcDialogTitle6']")
	public static WebElement acceptedheading;

	// KEY TEST RETURN BUTTON
	@FindBy(xpath = "//span[normalize-space()='save']")
	public static WebElement EditkeytestSavebutton;

	// EDIT ICON
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[17]/span/a[1]/span")
	public static WebElement Editkeytestediticon;

	// EQUATION ICON
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[3]/td[10]/span/span")
	public static WebElement EqautionIcon;

	// EQUATION ICON POPUP HEADING EDIT
	@FindBy(xpath = "//*[@id=\"rcDialogTitle0\"]")
	public static WebElement equationEditHeading;

	// EQUATION ICON CANCEL BUTTON
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/div/button/span")
	public static WebElement equationEditCancel;

	// ACCPETED VALUE ICON
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[9]/span/span")
	public static WebElement acceptedvalueIcon;

	// ACCPETED VALUE ICON POPUP HEADING EDIT
	@FindBy(xpath = "//*[@id=\"rcDialogTitle2\"]")
	public static WebElement acceptedvalueEditHeading;

	// ACCPETED VALUE ICON CLOSE BUTTON
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/div/button")
	public static WebElement acceptedvalueEditclose;

	// ACCPETED VALUE EDIT ICON
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/form/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[5]/span/a[1]/span")
	public static WebElement acceptedvalueEditIcon;

	// ACCPETED VALUE ICON POPUP HEADING INSIDE EDIT
	@FindBy(xpath = "//*[@id=\"rcDialogTitle4\"]/div/p")
	public static WebElement acceptedvalueinsideEditHeading;

	// ACCPETED VALUE EDITCLOSE INSIDE EDIT
	@FindBy(xpath = "//span[@aria-label='close-circle']")
	public static WebElement acceptedvalueinsideEditcloseicon;

	// ACCPETED VALUE EDIT CANCEL INSIDE EDIT
	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	public static WebElement acceptedvalueinsideEditcancelbutton;

	// * ADDITIONAL INFORMATION CLOSE ICON
	@FindBy(xpath = "//div[2]//div[1]//div[2]//button[1]//span[1]//span[1]//*[name()='svg']")
	public static WebElement additionalinformationcloseicon;

	// * ADDITIONAL INFORMATION CLOSE BUTTON
	@FindBy(xpath = "//div[text()='Additional Information']/../..//span[text()='Close']")
	public static WebElement additionalinformationclosebutton;

	// ACCPETED VALUE EDIT CANCEL INSIDE EDIT
	@FindBy(xpath = "//input[@id='finishPDValue']")
	public static WebElement acceptedvalueinsideNumberTextbox;

	// ACCPETED VALUE EDIT CANCEL INSIDE EDIT
	@FindBy(xpath = "//span[normalize-space()='Update']")
	public static WebElement acceptedvalueinsideUpdatebutton;

	// ACCPETED VALUE CONTAINER
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/form/div[2]/div/div/div/div/div/div[2]")
	public static WebElement acceptedvalueContainer;

	// ACCPETED VALUE EDIT PARAMETERTEXTBOX
	@FindBy(xpath = "//div[@name='parameter']//div[@class='ant-select-selector']")
	public static WebElement acceptedvalueparameterdropdowntextbox;

	// ACCPETED VALUE SAVE BUTTON
	@FindBy(xpath = "//button[contains(@class,'ant-btn ant-btn-primary sc-gZMcBi jVssxC')]")
	public static WebElement acceptedvalueSaveButton;

	// ACCPETED VALUE EDIT CANCEL INSIDE EDIT
	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	public static WebElement acceptedvaluedeletecancelbutton;

	// EDIT ACCEPTED VALUE PARAMETER DROPDOWN
	@FindBy(xpath = "//input[@id='parameter']")
	public static WebElement editAcceptedvalueparameterdropdown;

	// EDIT ACCEPTED VALUE PARAMETER DROPDOWN 2
	@FindBy(xpath = "//div[@name='finishPDTestParameter']")
	public static WebElement editAcceptedvalueparameterdropdown2;

	// ADDITIONAL INFORMATION CLEAR BUTTON
	@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw'][1]")
	public static WebElement clearbutton;

	// ACCEPTED CONDITION CONDAINER BUTTON
	@FindBy(xpath = "(//div[@class='ant-table-container'])[3]")
	public static WebElement acceptedconditioncontainer;

	// Equation Validation
	@FindBy(xpath = "(//div[normalize-space()=\"Equation can't be Empty\"])[1]")
	public static WebElement equationvalidation;

	// Equation Space Validation
	@FindBy(xpath = "//div[contains(text(),'All the relevant result parameters must be include')]")
	public static WebElement equationspacevalidation;

	// Equation Cancel Button
	@FindBy(xpath = "//*[text()='Edit Condition']//..//..//*[text()='Cancel']/..")
	public static WebElement equationcancelbtn;

	// Accepted Condition Cancel Button
	@FindBy(xpath = "//*[text()='Accepeted Condition']/../..//*[text()='Cancel']/..")
	public static WebElement acceptedconditioncancelbtn;

	// Accepted Condition Close Icon
	@FindBy(xpath = "//*[text()='Edit Condition']/../../button/span")
	public static WebElement closeicon;

	// SEND THE DATA FOR TEXTBOX EDIT ACCEPTED VALUE
	@FindBy(xpath = "(//input[@class='ant-input'])[3]")
	public static WebElement textboxeditacceptevalue;

	// Accept Value Update Success Message
	@FindBy(xpath = "//div[@class='ant-notification ant-notification-topRight']")
	public static WebElement acceptvalueupdatesuccessmessage;

	// Accepted Condition Input box
	@FindBy(xpath = "//*[text()='Add Condition']/../../..//div[@class='ant-col ant-col-14']//textarea")
	public static WebElement acceptedconditioninputbox;

	// Edit Equation Input Box
	@FindBy(xpath = "//input[@id='equation_formula']")
	public static WebElement editequationinputbox;

	// ACCEPTED CONDITION TEXYAREA FIELD
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/textarea")
	public static WebElement acceptedconditioneqautiontextarea;

	// save Equation button
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/button/span")
	public static WebElement saveequationbutton;

	// ACCEPTED VALUE HEADING
	@FindBy(xpath = "//thead//th[9]")
	public static WebElement acceptedvalueheading1;

	// ACCEPTED VALUE TEST RADIO BUTTON SPAN
	@FindBy(xpath = "(//span[@class='ant-radio-inner'])[1]")
	public static WebElement acceptedvaluetestradiobuttonspan;

	// ACCEPTED VALUE TEST RADIO BUTTON INPUT
	@FindBy(xpath = "//input[@value='TEST']")
	public static WebElement acceptedvaluetestradiobuttoninput;

	// ACCEPTED VALUE SAVE BUTTON
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary sc-gZMcBi jVssxC']")
	public static WebElement acceptedvaluesavebutton;

	// Edit Accepted value Dropdown 3
	@FindBy(xpath = "//input[@id='editCondition']/../../span[2]")
	public static WebElement editacceptedvaluedropdown3;

	// SEND THE DATA FOR TEXTBOX EDIT ACCEPTED VALUE 1
	@FindBy(xpath = "(//input[@class='ant-input'])[4]")
	public static WebElement textboxeditacceptevalue1;

	//EDIT ACCEPTED VALUE UPDATE BUTTON
	@FindBy(xpath = "(//button[@class='ant-btn sc-gZMcBi dMdnOw'])[2]")
	public static WebElement editacceptedvalueupdatebutton;

	// EDIT ACCEPT VALUE RELEVENT BOX
	@FindBy(xpath = "//input[@id='finishPDFinalResult']")
	public static WebElement editacceptreleventbox;

	// ACCEPTED VALUE DELETE OK BUTTON
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement acceptedvaluedeleteokbutton;

	// ACCEPTED CONDITION HEADING
	@FindBy(xpath = "//thead//th[12]")
	public static WebElement acceptedconditionheading;

	// ACCEPTED CONDITION CANCEL BUTTON
	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement acceptedconditioncancelbutton;

	// ACCEPTED CONDITON MODAL
	@FindBy(xpath = "//div[text()='Accepeted Condition']/../..")
	public static WebElement acceptedconditionmodal;

	// ACCEPTED CONDITION DELETE OK BUTTON
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement acceptedconditiondeleteokbutton;

	// * Additional Information cancel icon
	@FindBy(xpath = "//span[@class='anticon anticon-close ant-modal-close-icon']")
	public static WebElement cancelicon;

	// Accepted Value Parameter can't be empty validation
	@FindBy(xpath = "//form/div/div/div[1]/div/div[2]")
	public static WebElement emptyvalidation;

	// Accepted Value Test Radio Button
	@FindBy(xpath = "//form/div/div/div[2]/div/span//input[@class='ant-radio-input']/..")
	public static WebElement testradiobtn;

	// Accepted Value material Radio Button
	@FindBy(xpath = "//input[@value='MATERIAL']/..")
	public static WebElement materialradiobtn;

	// Accepted Value Common Radio Button
	@FindBy(xpath = "//form/div/div[2]/div[2]//label[1]//input/..")
	public static WebElement commonradiobtn;

	// Accepted Value individual Radio Button
	@FindBy(xpath = "//form/div/div[2]/div[2]//label[2]//input/..")
	public static WebElement individualradiobtn;

	// Select Text Parameter
	@FindBy(xpath = "//input[@id='parameter']/..")
	public static WebElement selecttextparameter;
	// EQUATION EDIT HEADING
	@FindBy(xpath = "//thead//th[10]")
	public static WebElement equationeditheading;

	// EQUATION PAGINATION NEXT BUTTON
	@FindBy(xpath = "//div[text()='Equation']/../..//ul//span[@class='anticon anticon-right']/..")
	public static WebElement equationpaginationnextbutton;

	// EQUATION CONFIGURE EQUATION COUNT
	@FindBy(xpath = "//*[text()='Configure Equation '] /.././../../div[2]//tr")

	public static WebElement equationconfigureequationcount;

	// ACCEPTED VALUE UPDATE BUTTON MESSAGE
	@FindBy(xpath = "//div[@class='ant-notification ant-notification-topRight']")
	public static WebElement acceptedvalueupdatebuttonmessage;

	// Tokyo cement group Logo
	@FindBy(xpath = "//header[@class ='ant-layout-header']/a[1]")
	public static WebElement tcgLogo;

	// EDIT CONFIGURE HEADING

	// ACCEPTED VALUE CLOSE BUTTON
	@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']")
	public static WebElement acceptedvalueclosebutton;

	// ACCEPTED VALUE MUST FOOTER VALIDATION
	@FindBy(xpath = "//div[@class='ant-table-footer']/div")
	public static WebElement acceptedvaluefootervalidation;

	// ACCEPTED VALUE TABLE ROW COUNT
	@FindBy(xpath = "//div[@class='ant-col ant-col-24']//table//tbody/tr")
	public static List<WebElement> tablerowcount;

	// ACCEPTED VALUE TABLE DELETE BUTTON
	@FindBy(xpath = "//div[@class='ant-col ant-col-24']//table//tbody/tr//td[6]/span//a[2]//span[contains(@class,'anticon-delete')][contains(@class,'anticon-delete')]")
	public static WebElement tabledeletebtn;

	// ACCEPTED VALUE VALUE FIELD
	@FindBy(xpath = "//*[@id='value']")
	public static WebElement valuefield;

	// ACCEPTED VALUE MINIMUM VALUE FIELD
	@FindBy(xpath = "//div[@class='ant-table-wrapper']//table//tbody/tr[2]/td[2]/div//span/input[@id='min']")
	public static WebElement minimum;

	// EDIT CONFIGURE HEADING

	@FindBy(xpath = "//thead//th[15]")
	public static WebElement editconfigureheading;

	// TEST PARAMETER ICON
	@FindBy(xpath = "(//div[@class='ant-steps-item-icon'])[2]")
	public static WebElement testparametericon;

	// TEST PARAMETER ICON BUTTON
	@FindBy(xpath = "(//span[@class='ant-dropdown-trigger ant-table-filter-trigger'])[1]")
	public static WebElement testparametericonbutton;

	// TEST PARAMETER TEXTBOX FUNCTION
	@FindBy(xpath = "//input[@class='ant-input']")
	public static WebElement testparametertextboxfunction;

	// ADDITIONAL INFORMATION HEADING
	@FindBy(xpath = "//thead//th[11]")
	public static WebElement additionalinformationheading;

	// ADDITIONAL INFORMATION DELETE BUTTON
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement additionalinformationdeletebutton;

	// THE TEST RECORD SUCESSFULLY MESSAGE
	@FindBy(xpath = "//div[@class='ant-notification ant-notification-topRight']")
	public static WebElement testrecordsucessfullymessage;

	// ADDITIONAL INFORMATION TABLE CONTAINER 2 SEARCH DATA
	@FindBy(xpath = "(//div[@class='ant-table-container'])[2]")
	public static WebElement additionalinformationtablecontainer2searchdata;

	// EDIT EQUATION SAVE BUTTON

	// EDIT EQUATION SAVE BUTTON

	// ACCEPTED CONDITION SAVE BUTTON
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-submit sc-gZMcBi jVssxC']")
	public static WebElement conditionsavebtn;

	// ACCEPTED CONDITION SAVE BUTTON
	@FindBy(xpath = "//div[@class='ant-table-footer']/p")
	public static WebElement addconditionvalidation;

	// EDIT EQUATION SAVE BUTTON

	@FindBy(xpath = "(//button[@class='ant-btn sc-gZMcBi dMdnOw'])[2]")
	public static WebElement editequationsavebutton;

	// EDIT EQUATION VALIDATION MESSAGE
	@FindBy(xpath = "//*[text()='Edit Equation']/../../div[2]/div[3]")
	public static WebElement editequationvalidationmessage;

	// EDIT EQUATION CANCEL BUTTON
	@FindBy(xpath = "//*[text()='Edit Equation']/../..//span[text()='Cancel']/..")
	public static WebElement editequationcancelbutton;

	// ACCEPT CONDITION HEADING
	@FindBy(xpath = "//thead//th[12]")
	public static WebElement acceptconditionheading;

	// ACCEPT CONDITON INPUT BOX
	@FindBy(xpath = "//*[text()='Add Condition']/../../..//div[@class='ant-col ant-col-14']//textarea")
	public static WebElement acceptconditioninputbox;

	// ACCEPT CONDITION SAVE EQUATION BUTTON
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-submit sc-gZMcBi jVssxC']")
	public static WebElement acceptconditionsaveequationbutton;

	// ACCEPT CONDITION EQUATION IS INVALID
	@FindBy(xpath = "//*[text()='Add Condition']/../../..//p")
	public static WebElement acceptconditionequationisinvalid;

	// ACCEPT CONDITION FORMULA ALREADY EXIT MESSAGE
	@FindBy(xpath = "//*[text()='Add Condition']/../../../div[2]/div[2]")
	public static WebElement acceptconditionformulaalreayexit;

	// ACCEPTED VALUE SELECT TEST PARAMETER
	@FindBy(xpath = "//input[@id='parameter']")
	public static WebElement acceptedvalueselecttestparameter;

	@FindBy(xpath = "//input[@id='condition']/..")
	public static WebElement condition;

	// CONFIGURE TEST DISCRIPTION
	@FindBy(xpath = "//textarea[@id='description']/..//div[1]")
	public static WebElement configuretestdiscription;

	// CONFIGURE TEST PROCEDURE
	@FindBy(xpath = "//textarea[@id='procedure']/..//div[1]")
	public static WebElement configuretestprocedure;

	// CONFIGURE TEST DISCRIPTION VALIDATION MESSAGE
	@FindBy(xpath = "//textarea[@id='description']/../div[1]")
	public static WebElement configuretestdiscriptionvalidationmessage;

	// CONFIGURE TEST PROCEDURE VALIDATION MESSAGE
	@FindBy(xpath = "//textarea[@id='procedure']/../div[1]")
	public static WebElement configuretestprocedurevalidationmessage;

	// CONFIGURETEST TEST VALIDATION MESSAGE
	@FindBy(xpath = "//input[@id='test']/../../../div/../../../div[1]/div[3]")
	public static WebElement configuretestvalidationmessage;

	// CONFIGURE TEST TEST TYPE VALIDATION MESSAGE
	@FindBy(xpath = "//*[text()=' Test Type']/../div[2]")
	public static WebElement configuretesttypevalidationmessage;

	// CONFIGURE TEST PREFIX VALIDATION MESSAGE
	@FindBy(xpath = "//input[@id='prefix']/../div[2]")
	public static WebElement configuretestprefixvalidationmessage;

	// CONFIGURE TEST MAINCATEGORY VALIDATION MESSAGE
	@FindBy(xpath = "//*[text()=' Main Category']/../../div/../div/div[2]/.")
	public static WebElement configuretestmaincategoryvalidationmessage;

	// CONFIGURE TEST REPORT FORMAT VALIDATION MESSAGE
	@FindBy(xpath = "//input[@id='report_format']/../../../div/../../div[2]/.")
	public static WebElement configuretestreportformatvalidationmessage;

	// CONFIGURE TEST TEST INPUT
	@FindBy(xpath = "//input[@id='test']/..")
	public static WebElement configuretesttestinput;

	// CONFIGURE TEST TEST TYPE INPUT
	@FindBy(xpath = "//input[@id='test_type']/..")
	public static WebElement configuretesttesttypeinput;

	// CONFIGURE TEST PREFIX INPUT
	@FindBy(xpath = "//input[@id='prefix']")
	public static WebElement configuretesttestprefixinput;

	// CONFIGURE TEST MAINCATEGORY INPUT
	@FindBy(xpath = "//input[@id='main_category']/..")
	public static WebElement configuretesttestmaincategoryinput;

	// CONFIGURE TEST SUBCATEGORY INPUT
	@FindBy(xpath = "//input[@id='sub_category']/..")
	public static WebElement configuretesttestsubcategoryinput;

	// CONFIGURE TEST MATERIAL INPUT
	@FindBy(xpath = "//input[@id='material']/..")
	public static WebElement configuretesttestamterialinput;

	// CONFIGURE TEST DESCRIPTION TEXT BOX
	@FindBy(xpath = "//textarea[@id='description']")
	public static WebElement configuretestdescriptiontextbox;

	// CONFIGURE TEST PROCEDURE TEXT BOX
	@FindBy(xpath = "//textarea[@id='procedure']")
	public static WebElement configuretestproceduretextbox;

	// CONFIGURE TEST REPORTFORMAT TEXTBOX
	@FindBy(xpath = "//input[@id='report_format']/..")
	public static WebElement configuretestreportformattextbox;

	// CONFIGURE TEST ACTIVE BOX
	@FindBy(xpath = "//input[@id='active']/..")
	public static WebElement configuretestactivebox;

	// CONFIGURE TEST DUEDAY
	@FindBy(xpath = "//button[@role='switch']")
	public static WebElement configuretestdueday;

	// CONFIGURE TEST DUEDAYS
	@FindBy(xpath = "//input[@id='dueDay']")
	public static WebElement configuretestduedays;

	// CONFIGURE TEST SUBMIT BUTTON
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-submit sc-gZMcBi jVssxC']")
	public static WebElement configuretestsubmitbutton;

	// CONFIGURE TEST INPUT SELECTOR
	@FindBy(xpath = "//input[@id='test']/../..")
	public static WebElement configuretestinputselector;

	/* Due Day Text box */
	@FindBy(xpath = "//input[@id='dueDayEdit']")
	public static WebElement duedayedittextbox;

	/* Due Day Validation */
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[4]/div[1]/div/div")
	public static WebElement duedayvalidation;

	// Equaion Edit Cancel Button
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[@type='button']/span[text()='Cancel']")
	public static WebElement eqcancelbtn;

	// @Sasi - Modified :- 22-06-2023

	// Delete Question Mark icon XPath
	@FindBy(xpath = "//span[contains(@class,'anticon-question-circle')]")
	public static WebElement deleteQuestionIconMT;

	// Delete OK Button XPath
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement deleteOkButtonMT;

	// Delete Cancel Button XPath
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement deleteCancelButtonMT;

	// Manage Test "Arrow >" Button XPath
	@FindBy(xpath = "//span[contains(@class,'anticon-right')]")
	public static WebElement arrowButtonMT;

	// Manage Test Previous Button XPath
	@FindBy(xpath = "//span[contains(@class,'anticon-left')]")
	public static WebElement previousButtonMT;

	// Manage Test Pagination DropDown XPath
	@FindBy(xpath = "//li[@class='ant-pagination-options']")
	public static WebElement paginationdropdownMT;

	@FindBy(xpath = "//div[text()='Manage Tests']")
	public static WebElement manageTest;

	@FindBy(xpath = "//div[text()='Group Tests']")
	public static WebElement manageGroupTest;

	/* Reset Button */
	@FindBy(xpath = "(//button[@type='button'])[4]")
	public static WebElement resetbtn;

	/* DueDay Heading */
	@FindBy(xpath = "//th[7]//span[@class='ant-table-column-title']")
	public static WebElement duedayheading;

	/* Test Parameter Heading */
	@FindBy(xpath = "//div[@class = 'ant-table-header']//th[8]")
	public static WebElement testparameterheading;

	/* Test Parameter Heading */
	@FindBy(xpath = "//div[@class = 'ant-table-header']//th[10]")
	public static WebElement equationheading;

	/* Accepted Value Heading */
	@FindBy(xpath = "//div[@class = 'ant-table-header']//th[9]")
	public static WebElement acceptedvalueheading;

	/* Test Parameter Pop Up Icon */
	@FindBy(xpath = "//td[text()='BalangodaTest']//following-sibling::td[7]//span//span[1]")
	public static WebElement testparameterpopicon;

	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement additionalInfoPopUp;

	@FindBy(xpath = "//div[@class='ant-modal-title']")
	public static WebElement additionalInfoPopUpHeading;

	@FindBy(xpath = "//label[@title='Caption']")
	public static WebElement captionTextBoxHeading;

	@FindBy(xpath = "//label[@title='Active']")
	public static WebElement ActiveCheckBoxHeading;

	@FindBy(xpath = "//label[@title='Record type']")
	public static WebElement RecordTypeTextBoxHeading;

	@FindBy(xpath = "//label[@title='Max length']")
	public static WebElement MaxLengthTextBoxHeading;

	@FindBy(id = "caption")
	public static WebElement CaptionTextBox;

	@FindBy(id = "recordType")
	public static WebElement RecordTypeTextBox;

	@FindBy(id = "length")
	public static WebElement MaxLengthTextBox;

	// @Sasi - Modified :- 23-06-2023

	// Manage Test ResetAll XPath
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-danger ant-btn-background-ghost']")
	public static WebElement resetAllMT;

	/* Pop up Equation Heading */
	@FindBy(xpath = "//div[@id = 'rcDialogTitle0']")
	public static WebElement popupequationheading;

	/* Pop up Config Equation Heading */
	@FindBy(xpath = "//div[@id = 'rcDialogTitle0']")
	public static WebElement popupconfigequationheading;

	/* Pop up test parameter Heading */
	@FindBy(xpath = "//div[@id = 'rcDialogTitle0']")
	public static WebElement popuptestparameterheading;

	/* Pop up table Parameter Heading */
	@FindBy(xpath = "//div[@class='ant-modal-content']//table/thead//th[1]")
	public static WebElement popuptableparameterheading;

	/* Pop up table Abbrivation Heading */
	@FindBy(xpath = "//div[@class='ant-modal-content']//table/thead//th[2]")
	public static WebElement popuptableabbrivationheading;

	@FindBy(id = "recordType")
	public static WebElement RecodrTypeDropdown;

	@FindBy(xpath = "//button[@type='button']//span[text()='Add fields']")
	public static WebElement AddFielButton;

	@FindBy(xpath = "//button[@type='submit']//span[text()='Add']")
	public static WebElement addButton;

	@FindBy(xpath = "//button[@type='button']//span[text()='Clear']")
	public static WebElement clearButton;

	@FindBy(xpath = "//div[@class='ant-table-wrapper']//thead/tr[1]/th[1]")
	public static WebElement captionHeading;

	@FindBy(xpath = "//div[@class='ant-table-wrapper']//thead/tr[1]/th[2]")
	public static WebElement maxLengthHeading;

	@FindBy(xpath = "//div[@class='ant-table-wrapper']//thead/tr[1]/th[3]")
	public static WebElement recordTypeHeading;

	@FindBy(xpath = "//div[@class='ant-table-wrapper']//thead/tr[1]/th[4]")
	public static WebElement statusHeading;

	@FindBy(xpath = "//div[@class='ant-table-wrapper']//thead/tr[1]/th[5]")
	public static WebElement actionButton;

	@FindBy(xpath = "//span[@class='ant-checkbox']")
	public static WebElement activeCheckbox;

	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement removeBtn;

	@FindBy(xpath = "//a[text()='Save']")
	public static WebElement editSaveBtn;

	@FindBy(xpath = "//a[text()='Cancel']")
	public static WebElement editCancelBtn;

	@FindBy(xpath = "//div[@class='ant-popover-inner']")
	public static WebElement editCancelpopUp;

	@FindBy(xpath = "//button[@type='button']//span[text()='OK']")
	public static WebElement editCancelOkBtn;

	@FindBy(xpath = "//button[@type='button']//span[text()='Cancel']")
	public static WebElement editCancelCancelBtn;

	// Modified By:- @Sasi		28-06-2023

	// Test Search icon
	@FindBy(xpath = "//th[1]//span[@role='img']")
	public static WebElement Testicon;

	/* Pop up table Type Heading */
	@FindBy(xpath = "//div[@class='ant-modal-content']//table/thead//th[3]")
	public static WebElement popuptabletypeheading;

	/* Pop up table Input Method Heading */
	@FindBy(xpath = "//div[@class='ant-modal-content']//table/thead//th[4]")
	public static WebElement popuptablinputmethodheading;

	/* Pop up table Input Method Heading */
	@FindBy(xpath = "//div[@class='ant-modal-content']//table/thead//th[5]")
	public static WebElement popuptabldatatypeheading;

	/* Pop up table Value Heading */
	@FindBy(xpath = "//div[@class='ant-modal-content']//table/thead//th[6]")
	public static WebElement popuptablvalueheading;

	/* Pop up table Unit Heading */
	@FindBy(xpath = "//div[@class='ant-modal-content']//table/thead//th[7]")
	public static WebElement popuptableunitheading;

	/* Pop up table Decimal Value Heading */
	@FindBy(xpath = "//div[@class='ant-modal-content']//table/thead//th[8]")
	public static WebElement popuptabledecimalvalueheading;

	/* Pop up table Relevant to accepted Value Heading */
	@FindBy(xpath = "//div[@class='ant-modal-content']//table/thead//th[9]")
	public static WebElement popuptablereltoaccvalueheading;

	// @Sasi Modified :- 03-07-2023

	// "Manage Test" Test Search icon XPath
	@FindBy(xpath = "//th[1]//span[@role='img']")
	public static WebElement TestSearchicon;

	// "Manage Test" Test Search TextBox XPath
	@FindBy(xpath = "//input[@placeholder='Test']")
	public static WebElement TestTextBox;

	// "Manage Test" ResetAll Button XPath
	@FindBy(xpath = "//div[@class='ant-table-title']//button")
	public static WebElement ResetAllButton;

	// Additional Information Popup Screen Close Icon XPath - N.Karunya - Date:
	// 04/07/2023
	@FindBy(xpath = "//button[@class='ant-modal-close']/span/span//*[@viewBox]")
	public static WebElement additonalinfopopupscreencloseIcon;

	// Additional Information Popup Screen Close Button XPath - N.Karunya - Date:
	// 04/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button")
	public static WebElement additonalinfopopupscreencloseButton;

	// Accepted Condition Heading XPath - N.Karunya - Date: 04/07/2023
	@FindBy(xpath = "//main//thead//tr//th[12]")
	public static WebElement acceptedconditioncolumnHeading;

	// Accepted Condition Popup XPath - N.Karunya - Date: 04/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement acceptedconditionpopup;

	// Add Condition Heading XPath - N.Karunya - Date: 04/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-body']/div/div[1]/div[1]//h2")
	public static WebElement addconditionheading;

	// Parameter Heading XPath - N.Karunya - Date: 04/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[1]/div[1]/div[2]//thead//th[1]")
	public static WebElement parameterheading;

	// Abbreviation Heading XPath - N.Karunya - Date: 04/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[1]/div[1]/div[2]//thead//th[2]")
	public static WebElement abbreviationheading;

	// Relevant Heading XPath - N.Karunya - Date: 05/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[1]/div[1]/div[2]//thead//th[3]")
	public static WebElement relevantheading;

	// Main Textbox XPath - N.Karunya - Date: 05/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[1]/div[2]/div[1]//textarea")
	public static WebElement maintextbox;

	// "U" icon XPath - N.Karunya - Date: 05/07/2023
	@FindBy(xpath = "//div[@class='calculatorsAccepet']/div[2]")
	public static WebElement UIcon;

	// "n" icon XPath - N.Karunya - Date: 05/07/2023
	@FindBy(xpath = "//div[@class='calculatorsAccepet']/div[1]")
	public static WebElement nIcon;

	// "(" icon XPath - N.Karunya - Date: 05/07/2023
	@FindBy(xpath = "// div[@class='calculatorsAccepet']/div[3]")
	public static WebElement leftsidebracketIcon;

	// ")" icon XPath - N.Karunya - Date: 05/07/2023
	@FindBy(xpath = "//div[@class='calculatorsAccepet']/div[4]")
	public static WebElement RightsidebracketIcon;

	// Condition Heading XPath - N.Karunya - Date: 05/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[1]/div[2]/div[5]//th[1]")
	public static WebElement conditionheading;

	// Action Heading XPath - N.Karunya - Date: 05/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[1]/div[2]/div[5]//th[2]")
	public static WebElement actionheading;

	// Accepted Condition - Action - Edit Popup XPath - N.Karunya - Date: 05/07/2023
	@FindBy(xpath = "//textarea[@id='equation_formula']/ancestor::div[@class='ant-modal-content']")
	public static WebElement editpopup;

	// Accepted Condition - Action - Edit Popup - Edit Condition Heading XPath -
	// N.Karunya - Date: 05/07/2023
	@FindBy(xpath = "//textarea[@id='equation_formula']/ancestor::div[@class='ant-modal-content']//div[@class='ant-modal-title']")
	public static WebElement editConditionHeading;

	// Accepted Condition - Action - Edit Popup - Textbox XPath -
	// N.Karunya - Date: 05/07/2023
	@FindBy(xpath = "//textarea[@id='equation_formula']")
	public static WebElement editConditiontextbox;

	// Accepted Condition - Action - Edit Popup - Cancel Button XPath - N.Karunya -
	// Date: 05/07/2023
	@FindBy(xpath = "//textarea[@id='equation_formula']/ancestor::div[@class='ant-modal-content']//div[@class='ant-modal-footer']//button[1]")
	public static WebElement editConditioncancelbutton;

	// Accepted Condition - Action - Edit Popup - Update Button XPath - N.Karunya -
	// Date: 05/07/2023
	@FindBy(xpath = "//textarea[@id='equation_formula']/ancestor::div[@class='ant-modal-content']//div[@class='ant-modal-footer']//button[2]")
	public static WebElement editConditionupdatebutton;

	// Accepted Condition - Action - Edit Popup - Close Button XPath - N.Karunya -
	// Date: 05/07/2023
	@FindBy(xpath = "//textarea[@id='equation_formula']/ancestor::div[@class='ant-modal-content']//button[@class='ant-modal-close']")
	public static WebElement editConditionclosebutton;

	// Equation - Cancel Button XPath - BFH.Rakshana -
	// Date: 06/07/2023
	@FindBy(xpath = "//div[@class='ant-modal']/div[2]/div[3]/div/button")
	public static WebElement EquationCancelButton;

	// Equation - Close Icon XPath - BFH.Rakshana -
	// Date: 07/07/2023
	@FindBy(xpath = "//div[2]/div/div[2]/button/span/span")
	public static WebElement EquationCloseIcon;

	// Additional Information Popup Screen Save Equation Button XPath - N.Karunya -
	// Date:
	// 06/07/2023
	@FindBy(xpath = "// div[@class='ant-modal-footer']/ancestor::div[@class='ant-modal-content']//div[2]//button")
	public static WebElement additonalinfopopupscreensaveequationButton;

	// Accepted Condition - Action - Delete Popup XPath - N.Karunya - Date:
	// 06/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement deletepopup;

	// Accepted Condition - Action - Delete Popup "?" Icon XPath - N.Karunya - Date:
	// 06/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-content']//*[@viewBox]")
	public static WebElement deletepopupquestionmarkIcon;

	// Accepted Condition - Action - Delete Popup Ok Button XPath - N.Karunya -
	// Date:
	// 06/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-buttons']//button[2]")
	public static WebElement deletepopupquestionokbutton;

	// Accepted Condition - Action - Delete Popup Cancel Button XPath - N.Karunya -
	// Date:
	// 06/07/2023
	@FindBy(xpath = "// div[@class='ant-popover-buttons']//button[1]")
	public static WebElement deletepopupcancelbutton;

	// Created Date Heading XPath - N.Karunya - Date: 06/07/2023
	@FindBy(xpath = "//main//thead//tr//th[13]")
	public static WebElement createddatecolumnHeading;

	// Created Mathushan 07/07/2023//

	@FindBy(xpath = "//header//li[2]/span")
	public static WebElement mainManagetestConfigureNavication;

	@FindBy(xpath = "//thead//th[1]/div/span[1]")
	public static WebElement testConfigureManageTestConfigurationTabTestHeadingUIProperties;

	@FindBy(xpath = "//div[@class='ant-spin-container']/div/div[1]/div/div/div[1]")
	public static WebElement testConfigureManageTestConfigurationTabmainHeadingUIProperties;

	@FindBy(xpath = "//main[@class='ant-layout-content']/div/div/div[1]/div/div[1]")
	public static WebElement mainManagetestConfigureNavicationsitemanagetestbutton;

	// Additionalinformation Heading XPath - BFH.Rakshana -



	@FindBy(xpath = "//div[@class='ant-table-title']/div/div/div[1]")
	public static WebElement mainManagetestConfigureNavicationsitemanagetestdefaultnavigationuiprop;

	@FindBy(xpath = "//thead//th[1]/div//span[@role='button']")
	public static WebElement testConfigureManageTestConfigurationTabTestSearchIconUIProperties;

	@FindBy(xpath = "//input[@name='testName']")
	public static WebElement testConfigureManageTestConfigurationTabTestTextboxUIProperties;

	@FindBy(xpath = "//input[@name='testName']/../div/button[1]")
	public static WebElement testConfigureManageTestConfigurationTabTestTextSearchbuttonProperties;

	@FindBy(xpath = "//input[@name='testName']/../div/button[2]")
	public static WebElement testConfigureManageTestConfigurationTabTestTextResetbuttonProperties;

	@FindBy(xpath = "//thead//th[2]")
	public static WebElement testConfigureManageTestConfigurationTabKeytestheadingProperties;

	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement testConfigureManageTestConfigurationTabKeytesticonpopupProperties;

	@FindBy(xpath = "//div[@class='ant-modal-content']/div[1]/div")
	public static WebElement testConfigureManageTestConfigurationTabeditKeytestheadingProperties;

	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[1]/div/div[2]/div/label[1]/span[2]")
	public static WebElement testConfigureManageTestConfigurationTabeditKeytestsubcategoryheadingProperties;

	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[1]/div/div[2]/div/label[1]/span[1]")
	public static WebElement testConfigureManageTestConfigurationTabeditKeytestsubcategoryradiobuttonProperties;

	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[1]/div/div[2]/div/label[2]/span[1]")
	public static WebElement testConfigureManageTestConfigurationTabeditKeytestmaterialradiobuttonProperties;

	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[1]/div/div[2]/div/label[2]/span[2]")
	public static WebElement testConfigureManageTestConfigurationTabeditKeytestmaterialheadingProperties;

	@FindBy(xpath = "//div[@class='ant-modal-content']//div[2]//div[1]/div[1]/table//thead//th[2]")
	public static WebElement testConfigureManageTestConfigurationTabeditKeytestselectforkeytestUIProperties;

	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]//div[@class='ant-spin-container']/div/div[2]//button")
	public static WebElement editKeyTestPopupScreenSaveButtonProperties;

	@FindBy(xpath = "//input[@id='SubCategory']/..")
	public static WebElement editKeyTestPopupmaterialselectsubcategorydropdownProperties;

	@FindBy(xpath = "//input[@name='prefix']")
	public static WebElement editKeyTestPopupmaterialselectsubcategorysearchmaterialtextboxProperties;

	@FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='ant-spin-container']//thead//th[2]")
	public static WebElement editKeyTestPopupmaterialselectsubcategorysearchmaterialnameheadingProperties;

	@FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='ant-table-footer']//button")
	public static WebElement editKeyTestPopupmaterialselectsubcategorysearchmaterialsavebuttonProperties;

	@FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='ant-modal-footer']//button")
	public static WebElement testIconEditKeyTestPopupScreenReturnButtonProperties;

	@FindBy(xpath = "//div[@class='ant-modal-content']/button[1]")
	public static WebElement testIconEditKeyTestPopupScreenCloseButtonProperties;
	
	
	@FindBy(xpath = "//thead//th[3]/div/span[1]")
	public static WebElement testConfigureManageTestConfigurationTabedmaincategoryheadingProperties;

	@FindBy(xpath = "//thead//th[3]/div/span[2]")
	public static WebElement testConfigureManageTestConfigurationTabedmaincategorysearchiconProperties;
	
	
	@FindBy(xpath = "//input[@name='mainCategoryName']/../div/button[1]")
	public static WebElement testConfigureManageTestConfigurationTabedmaincategorysearchbuttonProperties;

	@FindBy(xpath = "//input[@name='mainCategoryName']/../div/button[2]")
	public static WebElement testConfigureManageTestConfigurationTabedmaincategoryresetbuttonProperties;

	@FindBy(xpath = "//thead//th[4]/div/span[1]")
	public static WebElement testConfigureManageTestConfigurationTabedsubcategoryheadingProperties;

	@FindBy(xpath = "//thead//th[4]/div/span[2]")
	public static WebElement testConfigureManageTestConfigurationTabedsubcategoryiconProperties;

	@FindBy(xpath = "//input[@name='subCategoryName']")
	public static WebElement testConfigureManageTestConfigurationTabedsubcategorytextboxProperties;

	@FindBy(xpath = "//input[@name='subCategoryName']/../div/button[1]")
	public static WebElement testConfigureManageTestConfigurationTabedsubcategorysearchbutton;

	@FindBy(xpath = "//input[@name='subCategoryName']/../div/button[2]")
	public static WebElement testConfigureManageTestConfigurationTabedsubcategoryresetbutton;

	@FindBy(xpath = "//thead//th[5]/div/span[1]")
	public static WebElement testConfigureManageTestConfigurationTabedrawmaterialheadingProperties;


	@FindBy(xpath = "//thead//th[5]/div/span[2]")
	public static WebElement testConfigureManageTestConfigurationTabedrawmaterialiconProperties;

	@FindBy(xpath = "//input[@name='materialName']")
	public static WebElement testConfigureManageTestConfigurationTabedRawmaterialtextboxProperties;

	@FindBy(xpath = "//input[@name='materialName']/../div/button[1]")
	public static WebElement testConfigureManageTestConfigurationTabedrawmaterialsearchbutton;

	@FindBy(xpath = "//input[@name='materialName']/../div/button[2]")
	public static WebElement testConfigureManageTestConfigurationTabedrawmaterialresetbutton;

	@FindBy(xpath = "//thead//th[6]/div/span[1]")
	public static WebElement testConfigureManageTestConfigurationTabedtesttypeheadingProperties;

	// Additionalinformation Heading XPath - BFH.Rakshana -
	// Date: 07/07/2023
	@FindBy(xpath = "//th[11]")
	public static WebElement AdditionalinformationHeading;

	// PaginationDropdown XPath - BFH.Rakshana -
	// Date: 07/07/2023
	@FindBy(xpath = "//li[@class='ant-pagination-options']")
	public static WebElement PaginationDropdown;

	// PaginationNext Button XPath - BFH.Rakshana -
	// Date: 07/07/2023
	@FindBy(xpath = "//li[@class='ant-pagination-next']/button")
	public static WebElement PaginationNextButton;
	
	//PaginationPrevious Button XPath - BFH.Rakshana -
	// Date: 07/07/2023
	@FindBy(xpath = "//li[2]/button[@class='ant-pagination-item-link']")
	public static WebElement PaginationPreviousButton;

	// Updated Date Heading XPath - N.Karunya - Date: 06/07/2023
	@FindBy(xpath = "//main//thead//tr//th[14]")
	public static WebElement updateddatecolumnHeading;

	// Edit Configure Heading XPath - N.Karunya - Date: 06/07/2023
	@FindBy(xpath = "//main//thead//tr//th[15]")
	public static WebElement editConfigurecolumnHeading;

	// Edit Configure- Configure Test-"Description" Text Box XPath - N.Karunya -
	// Date: 06/07/2023
	@FindBy(xpath = "//textarea[@id='description']")
	public static WebElement descriptionTextbox;

	// Edit Configure- Configure Test-"Procedure" Text Box XPath - N.Karunya -
	// Date: 07/07/2023
	@FindBy(xpath = "//textarea[@id='procedure']")
	public static WebElement procedureTextbox;

	// Edit Configure- Configure Test-"Active" Check Box XPath - N.Karunya -
	// Date: 07/07/2023
	@FindBy(xpath = "//span[contains(@class,'ant-checkbox-checked')]")
	public static WebElement activeChecktbox;

	// Edit Configure- Configure Test- "Due Day" Toggle Button XPath - N.Karunya -
	// Date: 07/07/2023
	@FindBy(xpath = "//button[contains(@class,'ant-switch-checked')]")
	public static WebElement dueDaytoggleButton;

	// Edit Configure- Configure Test- Due Day(s) Text Box XPath - N.Karunya -
	// Date: 07/07/2023
	@FindBy(xpath = "//input[@id='dueDay']")
	public static WebElement dueDaysTextbox;

	// Edit Configure- Configure Test - "Edit" Button XPath - N.Karunya -
	// Date: 07/07/2023
	@FindBy(xpath = "//button[contains(@class,'ant-btn-submit')]")
	public static WebElement editButton;

	// Edit Configure- Configure Test - "Next" Button XPath - N.Karunya -
	// Date: 07/07/2023
	@FindBy(xpath = "//div[@class='steps-action']//button")
	public static WebElement nextButton;

	// Equation Table Action Delete Ok Button

	// Equation Table Action Delete Ok Button
	// Date: 11/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-inner-content']/div[2]/button[2]")
	public static WebElement DeleteOkButton;

	// Equation Table Action Delete Cancel Button
	// Date: 11/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-inner-content']/div[2]/button[1]")
	public static WebElement DeleteCancelButton;

	// Manage Test - Accepted criteria - Test - Radio Button XPath - N.Karunya -
	// Date: 07/07/2023
	@FindBy(xpath = "//div[contains(@class,'ant-radio-group-outline')]/span//label[1]//span[@class='ant-radio']")
	public static WebElement testRadioButton;

	// Manage Test - Accepted criteria - Material - Radio Button XPath - N.Karunya -
	// Date: 07/07/2023
	@FindBy(xpath = "//main[@class='ant-layout-content']/div/div/div[2]/div//form/div[1]/div[1]/div[2]/div[1]/label/span[1]")
	public static WebElement materialRadioButton;

	// Manage Test - Add Key Test -"Save" Button XPath - N.Karunya -
	// Date: 07/07/2023
	@FindBy(xpath = "//div[@class='ant-table-footer']//button")
	public static WebElement addkeytestSaveButton;

	// Active Heading XPath - N.Karunya - Date: 07/07/2023
	@FindBy(xpath = "//main//thead//tr//th[16]")
	public static WebElement activecolumnHeading;

	// Action Heading XPath - N.Karunya - Date: 07/07/2023
	@FindBy(xpath = "//main//thead//tr//th[17]")
	public static WebElement actioncolumnHeading;

	// Action Edit Popup XPath - N.Karunya - Date: 10/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement actionEditpopup;

	// Edit Test Configuration Heading XPath - N.Karunya - Date: 10/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-title']//p")
	public static WebElement edittestconfigurationHeading;

	// Action - Edit Pop up Screen "Test" UI Heading XPath - N.Karunya - Date:
	// 10/07/2023
	@FindBy(xpath = "//input[@id='test']/ancestor::div[@class='input_wrapper']//label")
	public static WebElement testHeading;

	// Action - Edit Pop up Screen "Test" Dropdown XPath - N.Karunya - Date:
	// 10/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[1]/div[1]/div/div/div//span[1]")
	public static WebElement testDropdown;

	// Action - Edit Pop up Screen "Test Type" UI Heading XPath - N.Karunya - Date:
	// 10/07/2023
	@FindBy(xpath = "//input[@id='test_type']/ancestor::div[@class='input_wrapper']//label")
	public static WebElement testTypeHeading;

	// Action - Edit Pop up Screen "Test Type" Dropdown XPath - N.Karunya -
	// Date:
	// 10/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[1]/div[2]/div/div/div//span[1]")
	public static WebElement testTypeDropdown;

	// Action - Edit Pop up Screen "Prefix" UI Heading XPath - N.Karunya - Date:
	// 10/07/2023
	@FindBy(xpath = "//input[@id='prefix']/ancestor::div[@class='input_wrapper']//label")
	public static WebElement prefixHeading;

	// Action - Edit Pop up Screen "Prefix" Textbox XPath - N.Karunya -
	// Date: 10/07/2023
	@FindBy(xpath = "//input[@id='prefix']")
	public static WebElement prefixtextbox;

	// Action - Edit Pop up Screen "Maincategory" UI Heading XPath - N.Karunya -
	// Date:
	// 10/07/2023
	@FindBy(xpath = "//input[@id='main_category']/ancestor::div[@class='input_wrapper']//label")
	public static WebElement maincategoryHeading;

	// Equation Heading
	// Date: 11/07/2023
	@FindBy(xpath = "//div[@class='ant-table-content']/table/thead/tr/th[3]")
	public static WebElement EquationHeading;

	// Configure Equation Heading
	// Date: 11/07/2023
	@FindBy(xpath = "//div/div[2]/div[2]/div/div/div/div/div[1]/div/div[@class='ant-typography']")
	public static WebElement ConfigureEquationHeading;

	// Equation Top Heading Edited By Shangeetha On 17/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[1]/div")
	public static WebElement EquationTopHeading;

	// Equation Top Heading
	// Date: 11/07/2023
	@FindBy(xpath = "//div[@class='ant-table-content']/table/thead/tr/th[1]")
	public static WebElement ParameterHeading;

	// Equation Top Heading
	// Date: 11/07/2023
	@FindBy(xpath = "//div[@class='ant-table-content']/table/thead/tr/th[2]")
	public static WebElement UnitHeading;

	// Equation Top Heading
	// Date: 11/07/2023
	@FindBy(xpath = "//div[@class='ant-table-content']/table/thead/tr/th[4]")
	public static WebElement TypeHeading;

	// Equation Top Heading
	// Date: 11/07/2023
	@FindBy(xpath = "//div[@class='ant-table-content']/table/thead/tr/th[5]")
	public static WebElement ActionHeading;

	// Action - Edit Pop up Screen "Maincategory" Dropdown XPath - N.Karunya -
	// Date: 11/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[2]/div[1]/div/div/div/span[1]")
	public static WebElement maincategoryDropdown;

	// Action - Edit Pop up Screen "Subcategory" UI Heading XPath - N.Karunya -
	// Date: 11/07/2023
	@FindBy(xpath = "//input[@id='sub_category']/ancestor::div[@class='input_wrapper']//label")
	public static WebElement subcategoryHeading;

	// Action - Edit Pop up Screen "Subcategory" Dropdown XPath - N.Karunya -
	// Date: 11/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[2]/div[2]/div/div/div/span[1]")
	public static WebElement subcategoryDropdown;

	// Action - Edit Pop up Screen "Due Day(s)" UI Heading XPath - N.Karunya -
	// Date: 11/07/2023
	@FindBy(xpath = "//input[@id='dueDayEdit']/ancestor::div[@class='input_wrapper']//label")
	public static WebElement dueDaysHeading;

	// Action - Edit Pop up Screen "Due Day(s)" UI Textbox XPath - N.Karunya -
	// Date: 11/07/2023
	@FindBy(xpath = "//input[@id='dueDayEdit']")
	public static WebElement dueDaystextbox;

	// Action - Edit Pop up Screen "Active Test" UI Heading XPath - N.Karunya -
	// Date: 11/07/2023
	@FindBy(xpath = "//input[@id='activeTest']/ancestor::div[@class='input_wrapper']//label[1]")
	public static WebElement activeTestHeading;

	// Action - Edit Pop up Screen "Active Test" UI Checkbox XPath - N.Karunya -
	// Date: 11/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/div/div[4]//label[2]/span")
	public static WebElement activeTestCheckbox;

	// Action - Edit Pop up Screen "Description" UI Heading XPath - N.Karunya -
	// Date: 11/07/2023
	@FindBy(xpath = "//textarea[@id='description']/ancestor::div[@class='input_wrapper']//label[1]")
	public static WebElement descriptionHeading;

	// Action - Edit Pop up Screen "Description"Textbox XPath - N.Karunya -
	// Date: 11/07/2023
	@FindBy(xpath = "//textarea[@id='description']")
	public static WebElement descriptiontextbox;

	// Action - Edit Pop up Screen "Procedure" UI Heading XPath - N.Karunya -
	// Date: 11/07/2023
	@FindBy(xpath = "//textarea[@id='procedure']/ancestor::div[@class='input_wrapper']//label[1]")
	public static WebElement procedureHeading;

	// Action - Edit Pop up Screen "Procedure"Textbox XPath - N.Karunya -
	// Date: 11/07/2023
	@FindBy(xpath = "//textarea[@id='procedure']")
	public static WebElement proceduretextbox;

	// Action - Edit Pop up Screen Close Button XPath - N.Karunya -
	// Date: 11/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='ant-modal-header']/../button")
	public static WebElement actionEditpopupcloseButton;

	// Action - Edit Pop up Screen Save Button XPath - N.Karunya -
	// Date: 11/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[2]")
	public static WebElement actionEditpopupsaveButton;

	// Action - Edit Pop up Screen Cancel Button XPath - N.Karunya -
	// Date: 11/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[1]")
	public static WebElement actionEditpopupCancelButton;

	// Action - Delete Pop up Screen XPath - N.Karunya -
	// Date: 12/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement actionDeletepopup;

	// Manage Test- Configuration Tab- "Edit Configure"- Configure Test-"Test" Drop
	// Down XPath - N.Karunya - Date: 12/07/2023
	@FindBy(xpath = "//main[@class='ant-layout-content']/div/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/div[1]/div//span[2]")
	public static WebElement configuretestTestDropdown;

	// Manage Test- Configuration Tab- "Edit Configure"- Configure TestType
	// -"TestType" Drop Down XPath - N.Karunya -Date: 12/07/2023
	@FindBy(xpath = "//main[@class='ant-layout-content']/div/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div//span[2]")
	public static WebElement configuretestTesttypeDropdown;

	// Manage Test- Configuration Tab- "Edit Configure"- Configure TestType
	// -"Prefix" Textbox XPath - N.Karunya -Date: 12/07/2023
	@FindBy(xpath = "//input[@placeholder='Enter Prefix']")
	public static WebElement configuretestPrefixtextbox;

	// Manage Test- Configuration Tab- "Edit Configure"- Configure TestType
	// -"Maincategory" Dropdown XPath - N.Karunya -Date: 12/07/2023
	@FindBy(xpath = "//main[@class='ant-layout-content']/div/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div//span[2]")
	public static WebElement configuretestmaincategrydropdown;

	// Manage Test- Configuration Tab- "Edit Configure"- Configure TestType
	// -"ReportFormat" Dropdown XPath - N.Karunya -Date: 12/07/2023
	@FindBy(xpath = "// main[@class='ant-layout-content']/div/div/div[2]/div/div[2]/div/div/div[2]/div[4]/div/div/div/div//span[2]")
	public static WebElement configuretestReportFormatdropdown;
	
	//AcceptedValue Heading BFH.Rakshana
	// Date: 11/07/2023
	@FindBy(xpath = "//div[@id='rcDialogTitle0']")
	public static WebElement AcceptedValueHeading;
	
	//TestParameter DropDown BFH.Rakshana
	// Date: 11/07/2023
	@FindBy(xpath = "//input[@id='parameter']/../..")
	public static WebElement TestParameterDropDown;

	// Additional Information Pop-up-Add Field- Action -Delete Icon -Popup XPath -
	// N.Karunya -Date: 12/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement additionalinfoPopupDeletePopupscreen;

	// Additional Information Pop-up-Add Field- Action -Delete Icon -Popup Ok button
	// XPath -
	// N.Karunya -Date: 12/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-content']//button[2]")
	public static WebElement additionalinfoPopupDeletePopupokBtn;

	// Additional Information Pop-up-Add Field- Action -Delete Icon -Popup Cancel
	// button
	// XPath -
	// N.Karunya -Date: 12/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-content']//button[1]")
	public static WebElement additionalinfoPopupDeletePopupcancelBtn;

//	// AcceptedValue Heading BFH.Rakshana
//	// Date: 11/07/2023
//	@FindBy(xpath = "//div[@id='rcDialogTitle0']")
//	public static WebElement AcceptedValueHeading;
//
//	// AcceptedValue Heading BFH.Rakshana
//	// Date: 11/07/2023
//	@FindBy(xpath = "//input[@id='parameter']/../..")
//	public static WebElement TestParameterDropDown;

	// Additional Information Pop-up-Add Field- Action -Delete Icon -Popup "?" icon
	// XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-content']//*[@viewBox]")
	public static WebElement additionalinfoPopupDeletePopupQuestionmarkIcon;

	// Manage Test- Configuration Tab- "Edit Configure"- Configure TestType
	// -"Subcategory" Dropdown XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//input[@id='sub_category']")
	public static WebElement configuretestSubcategrydropdown;

	// Manage Test- Configuration Tab- "Edit Configure"- Configure TestType
	// -"Material" Dropdown XPath - N.Karunya -Date: 13/07/2023
	@FindBy(xpath = "//input[@id='material']")
	public static WebElement configuretestMaterialdropdown;

	//TestEquation DropDown BFH.Rakshana
	// Date: 12/07/2023
	@FindBy(xpath = "//input[@id='equation']/../..")
	public static WebElement TestEquationDropDown;

	//Test Heading BFH.Rakshana
	// Date: 12/07/2023
	@FindBy(xpath = "//span/label/span[2]")
	public static WebElement TestHeading;

	//Material Heading BFH.Rakshana
	// Date: 12/07/2023
	@FindBy(xpath = "//form/div[1]/div[1]/div[2]/div[1]/label/span[2]")
	public static WebElement MaterialHeading;

	//RelevantToResult Heading BFH.Rakshana
	// Date: 12/07/2023
	@FindBy(xpath = "//div[@class='input_wrapper']/label[1]")
	public static WebElement RelevantToResultHeading;

	//TestEquation DropDown BFH.Rakshana
	// Date: 12/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']//input[@id='condition']/../..")
	public static WebElement EquationDropDown;

	//PopupParameter Heading BFH.Rakshana
	// Date: 12/07/2023
	@FindBy(xpath = "//form/div[2]/div/div/div/div/div/div/div[1]/table/thead/tr/th[1]/div/span[1]")
	public static WebElement PopupParameterHeading;

	//PopupCondition Heading BFH.Rakshana
	// Date: 12/07/2023
	@FindBy(xpath = "//form/div[2]/div/div/div/div/div/div/div[1]/table/thead/tr/th[3]/div/span[1]")
	public static WebElement PopupConditionHeading;

	//PopupMaterial Heading BFH.Rakshana
	// Date: 12/07/2023
	@FindBy(xpath = "//table/thead/tr/th[2]/div/span[1]")
	public static WebElement PopupMaterialHeading;

	//PopupValue Heading BFH.Rakshana
	// Date: 12/07/2023
	@FindBy(xpath = "//form/div[2]/div/div/div/div/div/div/div[1]/table/thead/tr/th[4]")
	public static WebElement PopupValueHeading;

	//PopupRelevantToResult Heading BFH.Rakshana
	// Date: 12/07/2023
	@FindBy(xpath = "//form/div[2]/div/div/div/div/div/div/div[1]/table/thead/tr/th[5]")
	public static WebElement PopupRelevantToResultHeading;

	//TestRadio Button BFH.Rakshana
	// Date: 12/07/2023
	@FindBy(xpath = "//form/div[1]/div[1]/div[2]/div[1]/span/label/span[1]")
	public static WebElement TestRadioButton;

	//MaterialRadio Button BFH.Rakshana
	// Date: 12/07/2023
	@FindBy(xpath = "//form/div[1]/div[1]/div[2]/div[1]/label/span[1]")
	public static WebElement MaterialRadioButton;

	//RelevantToResults Checkbox BFH.Rakshana
	// Date: 12/07/2023
	@FindBy(xpath = "//form/div[1]/div[1]/div[3]/div/label[2]/span")
	public static WebElement RelevantToResultsCheckbox;


	//Maximum Textbox BFH.Rakshana
	// Date: 13/07/2023
	@FindBy(xpath = "//input[@id='maximum']")
	public static WebElement MaximumTextbox;


	//Minimum Textbox  BFH.Rakshana

	// Minimum Textbox BFH.Rakshana
	// Date: 13/07/2023
	//To Textbox  BFH.Rakshana
	// Date: 13/07/2023
	@FindBy(xpath = "//form/div[1]/div[3]/div[2]/div/div/div[2]/div/button")
	public static WebElement ToTextbox;

	//Value Textbox  BFH.Rakshana
	// Date: 13/07/2023
	@FindBy(xpath = "//input[@id='otherValue']")
	public static WebElement ValueTextbox;

	//Equation Popup  BFH.Rakshana
	// Date: 13/07/2023
	@FindBy(xpath = "//div[3]/div/div[2]/div[@class='ant-modal']")
	public static WebElement EquationPopup;

	//Equation Popup  BFH.Rakshana
	// Date: 13/07/2023
	@FindBy(xpath = "//div/div[2]/div[1]/div/div/div[3]/div")
	public static WebElement Equal;

	// Test Parameters Pop up Screen - Action - Delete Popup XPath - N.Karunya -
	// Date:
	// 17/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement testParametersdeletepopup;

	// Test Parameters Pop-up - Action -Delete Icon -Popup "?" icon
	// XPath - N.Karunya -Date: 17/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-content']//*[@viewBox]")
	public static WebElement testParametersdeletepopupQuestionmarkIcon;

	// Additional Information Pop-up-Add Field- Action -Delete Icon -Popup Ok button
	// XPath - N.Karunya -Date: 17/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-content']//button[2]")
	public static WebElement testParametersdeletepopupokBtn;

	// Additional Information Pop-up-Add Field- Action -Delete Icon -Popup Cancel
	// button XPath - N.Karunya -Date: 17/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-content']//button[1]")
	public static WebElement testParametersdeletepopupCancelBtn;

	// Additional Information Pop-up-Add Field- Action -Delete Icon -Popup Next
	// button
	// XPath - N.Karunya -Date: 17/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='ant-modal-body']//ul//span[contains(@class,'anticon-right')]")
	public static WebElement testParametersdeletepopupNextlBtn;

	// Additional Information Pop-up-Add Field- Action -Delete Icon -Popup Previous
	// button XPath - N.Karunya -Date: 17/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='ant-modal-body']//ul//span[contains(@class,'anticon-left')]")
	public static WebElement testParametersdeletepopupPreviousBtn;

	// Equation Popup BFH.Rakshana
	//Edit By - K.Saranga ---------
	@FindBy(xpath = "//input[@id='mainType']")
	public static WebElement testTypeTextBox;

	@FindBy(xpath = "//main/div/div/div[2]/div/div/div/div/div/div[2]/div/table/thead/tr/th[6]/div/span[2]")
	public static WebElement testTypeSearchIcon;

	@FindBy(xpath = "//input[@placeholder='Due Day']")
	public static WebElement dueDayTextBox;

	@FindBy(xpath = "//main/div/div/div[2]/div/div/div/div/div/div[2]/div/table/thead/tr/th[7]/div/span[2]/span")
	public static WebElement dueDaySearchIcon;
	
	//Equation Popup  BFH.Rakshana
	// Date: 13/07/2023
	@FindBy(xpath = "//input[@id='equation_formula']/ancestor::div[@class='ant-modal-content']")
	public static WebElement ActionEditPopup;
	
	//Equation Popup Heading  BFH.Rakshana
	// Date: 13/07/2023
	@FindBy(xpath = "//div[@id='rcDialogTitle1']")
	public static WebElement ActionEditPopupHeading;
	
	//EditEquation Textbox  BFH.Rakshana
	// Date: 13/07/2023
	@FindBy(xpath = "//input[@id='equation_formula']")
	public static WebElement ActionEditEquationTextbox;
	
	//EditCancel Button  BFH.Rakshana
	// Date: 13/07/2023
	@FindBy(xpath = "//div/div[2]/div/div[2]/div[3]/div/button[1]")
	public static WebElement ActionEditCancelButton;
	
	//EditSave Button  BFH.Rakshana
	// Date: 13/07/2023
	@FindBy(xpath = "//div/div[2]/div/div[2]/div[3]/div/button[2]")
	public static WebElement ActionEditSaveButton;
	
	//EditClose Icon  BFH.Rakshana
	// Date: 13/07/2023
	@FindBy(xpath = "//div/div[2]/div/div[2]/button")
	public static WebElement ActionEditCloseIcon;
	
	//Delete Popup  BFH.Rakshana
	// Date: 13/07/2023
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement ActionDeletePopup;
	
	//DeletePopupQuestionMark Icon  BFH.Rakshana
	// Date: 13/07/2023
	@FindBy(xpath = "//div/div/div/div[2]/div/div[1]/span")
	public static WebElement ActionDeletePopupQuestionMarkIcon;
	
	
	
	//Added By Shangeetha 14/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[6]/div[1]/div/div/div")
	public static WebElement tableTwoActionColEditPopEquationDropTextBox;
	
	//Added By Shangeetha 14/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[6]/div[2]/div/div//*[@id='finishPDAcMin']")
	public static WebElement tableTwoActionColEditPopEquationMinimumTextBox;
	
	//Added By Shangeeth 14/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[6]/div[2]/div/div//*[@id='finishPDAcMax']")
	public static WebElement tableTwoActionColEditPopEquationMaximumTextBox;

	// Added By Shangeetha 14/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[6]/div[2]/div/div[3]//button")
	public static WebElement tableTwoActionColEditPopEquationToButton;

	// Added By Shangeetha 14/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[7]/div/div/label[1]")
	public static WebElement tableTwoActionColEditPopRelevantToTestLabel;
	
	// Added By K.Saranga 17/07/2023

	@FindBy(xpath ="//div[@class='ant-popover-content']")
	public static WebElement deleteiconpopup;
	
	@FindBy(xpath ="//span[contains(@class,'anticon-question-circle')]")
	public static WebElement questionIcon;
	
	//Added By Shangeetha 14/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']//form/div[7]/div/div/label[2]/span")
	public static WebElement tableTwoActionColEditPopRelevantToTestCheckBox;

//Created By M.Mathushan 17/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement acceptedValuePopupScreenProperties;
	
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]//form/div[1]/div[1]/div[3]/div/label[2]/span")
	public static WebElement acceptedValueRelevantToResulticonProperties;
	
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]//form/div[2]//thead//th[6]")
	public static WebElement acceptedValueActionHeadingProperties;
	
	
	@FindBy(xpath = "//div[@id='rcDialogTitle1']/ancestor::div[2]")
	public static WebElement acceptedValueActionEditPopupScreenProperties;
	
	@FindBy(xpath = "//div[@id='rcDialogTitle1']/div/p")
	public static WebElement acceptedValueActionEditHeadingUIProperties;
	
	@FindBy(xpath = "//div[@name='finishPDTestParameter']/../label")
	public static WebElement acceptedValueActionEditacceptedparameterHeadingUIProperties;
	
	@FindBy(xpath = "//input[@id='finishPDTestParameter']/../..")
	public static WebElement acceptedValueActionEditacceptedparameterdropdownUIProperties;
	
	
	@FindBy(xpath = "//input[@id='finishPDEquationParameter']/ancestor::div[3]/label")
	public static WebElement acceptedValueActionEditacceptedequationparameterHeadingUIProperties;
	
	@FindBy(xpath = "//input[@id='finishPDEquationParameter']/ancestor::div[3]/div[1]/div/span[1]")
	public static WebElement actionEditacceptedEquationParametertextboxProperties;
	
	@FindBy(xpath = "//input[@id='editCondition']/../..")
	public static WebElement acceptedValueActionEditacceptedequationdropdownUIProperties;
	
	@FindBy(xpath = "//input[@id='finishPDFinalResult']/..")
	public static WebElement acceptedValueActionEditacceptedreleventcheckboxUIProperties;
	
	@FindBy(xpath = "//div[@id='rcDialogTitle1']/ancestor::div[2]/div[3]/button[1]")
	public static WebElement acceptedValueActionEditacceptedCancelbuttonUIProperties;
	
	
	
	// Manage Test - Test Parameters Pop up Screen- "Close" button
	// XPath - N.Karunya -
	// Date: 17/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='ant-modal-header']/../button")
	public static WebElement testparameterspopupcloseButton;

	// Manage Test - Test Parameters Pop up Screen- "Close" Icon XPath - N.Karunya - Date:
	// 17/07/2023
	@FindBy(xpath = "//button[@class='ant-modal-close']/span/span//*[@viewBox]")
	public static WebElement testparameterspopupcloseIcon;
	//Added By Shangeetha  17/07/2023
	@FindBy(xpath = "//div[@class='ant-modal-content']/button/span/span")
	public static WebElement acceptedValuePopCloseIcon;
	
	//***on-18.07.02.2023*****************************SHOBIKA**********************************************
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement popuptableparameter;
	
	@FindBy(xpath = "//div[@class='ant-modal-content']//th[10]")
	public static WebElement popuptableparameteractionheading;

	//Added By Shangeetha 17/07/2023
	@FindBy(xpath="//div[@class='ant-modal-content']")
	public static WebElement equationPop;

	//Added By Shangeetha 17/07/2023
	@FindBy(xpath="//*[@id='equation_formula']/ancestor::div[@class='ant-modal-content']")
	public static WebElement eqIconPopEditPopUp;

	//Added By Shangeetha 17/07/2023
	@FindBy(xpath = "//*[@id='equation_formula']/ancestor::div[@class='ant-modal-content']/div[1]/div")
	public static WebElement eqIconPopEditPopUpHeading;

	//Added By Shangeetha 17/07/2023
	@FindBy(xpath="//*[@id='equation_formula']/ancestor::div[@class='ant-modal-content']/button/span/span")
	public static WebElement eqIconPopEditPopUpCloseButton;

	//Added By Shangeetha 17/07/2023
	@FindBy(xpath="//*[@id='equation_formula']/ancestor::div[@class='ant-modal-content']/div[3]/div/button[1]")
	public static WebElement eqIconPopEditPopUpCancelButton;

	//Added By Shangeetha 17/07/2023
	@FindBy(xpath="//*[@id='equation_formula']/ancestor::div[@class='ant-modal-content']/div[3]/div/button[2]")
	public static WebElement eqIconPopEditPopUpSaveButton;

	//Added By Shangeetha 17/07/2023
	@FindBy(xpath="//div[@class='ant-modal-content']//*[@id='equation_formula']")
	public static WebElement eqIconPopEditPopUpEditEqTextBox;
	//*************************THAKSHILA******************************
	
	
		@FindBy(xpath="//span[@aria-label='question-circle']")
		public static WebElement acceptValuePopDeletePopUpQuesIcon;
		@FindBy(xpath="//span[@class='ant-modal-close-x']")
		public static WebElement acceptValuePopEditCloseButton;

		@FindBy(xpath="//button[@class='ant-btn ant-btn-sm']//span[contains(text(),'Cancel')]")
		public static WebElement acceptValuePopDeletePopUpCancelButton;
		@FindBy(xpath="//div[@class='ant-modal-footer']//*[contains(text(), 'Cancel')]")
		public static WebElement acceptValuePopDeletePopUpClsButton;
		@FindBy(xpath="//div[@class='ant-modal-footer']/button[1]/span[1]")
		public static WebElement acceptValuePopEditCancelButton;
		@FindBy(xpath="//div[@class='ant-modal-footer']/button[2]/span[1]")
		public static WebElement acceptValuePopEditUpdateButton;
		@FindBy(xpath="//div[@class='ant-popover-buttons']//button[2]")
		public static WebElement acceptValuePopDeletePopUpOkButton;
		@FindBy(xpath="//div[@class='ant-popover-content']")
		public static WebElement acceptValuePopDeletePopUp;
		@FindBy(xpath="//button[1]//span[contains(text(),'Save')]")
		public static WebElement acceptValuePopDeletePopUpSaveButton;
		@FindBy(xpath="//input[@id='minimum']")
		public static WebElement MinimumTextbox;
}
