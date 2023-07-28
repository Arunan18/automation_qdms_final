package com.qa.automation.qdms.testconfig.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.automation.qdms.base.DriverIntialization;

public class TestParameterPage extends DriverIntialization{
	

	// parameter search 
		@FindBy(xpath = "(//span[@role='button'])[1]")
		public static WebElement parametersearchicon;
		
		@FindBy(xpath = "(//span[@role='button'])[3]")
		public static WebElement parameterdatatpesearchicon;
		
		@FindBy(xpath = "//input[@placeholder='Search Parameter']")
		public static WebElement parametersearchtextbox;
		
		@FindBy(xpath = "//input[@id='parameterDataType']")
		public static WebElement parameterdatatypesearchtextbox;
		
		@FindBy(xpath = " /html/body/div[3]/div/div/div/div/div/button[1]")
		public static WebElement parametersearchbutton ;
		
		@FindBy(xpath = "//body//div//div[contains(@class,'ant-table-filter-dropdown')]//div//div[1]//button[1]//span[1]")
		public static WebElement parameterdatatypesearchbutton ;
		
		@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
		public static  List  <WebElement> parameterColumn ;
		
		@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[3]")
		public static  List  <WebElement> parameterDATATYPEColumn ;
		
		public static String parameterBeforesearch="//tbody[@class='ant-table-tbody']/tr[";
		public static String parameterAftersearch="]/td[1]";
		public static String parameterDATATYPEAftersearch="]/td[3]";
		
		@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/button[2]")
		public static WebElement parameterResetbutton ;
		
		@FindBy(xpath = "//body//div//div[contains(@class,'ant-table-filter-dropdown')]//div//div[1]//button[1]//span[1]")
		public static WebElement parameterDATATYPEResetbutton ;
		
		@FindBy(xpath = "//tbody[@class='ant-table-tbody']")
		public static WebElement tablecontent;
		
		
		//parameter type
		@FindBy(xpath = "(//span[@role='button'])[2]")
		public static WebElement parametertypesearchicon;
		
		@FindBy(xpath = "//input[@id='parameterType']")
		public static WebElement parametertypesearchtextbox;
		
		@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[2]/button[1]")
		public static WebElement parametertypesearchbutton ;
		
		@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[2]")
		public static  List  <WebElement> parametertypeColumn ;
		
		public static String parametertypeBeforesearch="//tbody[@class='ant-table-tbody']/tr[";
		public static String parametertypeAftersearch="]/td[2]";
		
		@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[2]/button[2]")
		public static WebElement parametertypeResetbutton ;
		
		
		
		
	//* Test Parameter Heading
	@FindBy(xpath = "//div[@class='ant-typography'][normalize-space()='Parameter']")
	public static WebElement testparameterheadding;
	
	/* Test Parameter Add */
	
	//* Add Parameter Button
	@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']")
	public static WebElement addparameter;
		
	//* Parameter Text Area
	@FindBy(xpath = "//div[@class='ant-modal-content']/div[2]/form/div[1]/div/div/div/textarea")
	public static WebElement parameterteatarea;
	
	//* Parameter Type 
	@FindBy(xpath = "//div[@name='parameterType']")
	public static WebElement parametertype;
	
	//* Parameter DataType 
	@FindBy(xpath = "//div[@name='parameterDataType']")
	public static WebElement parameterdatatype;
	
	//* Save Button 
	@FindBy(xpath = "//div[@class='ant-modal-root']//button[2]")
	public static WebElement savebutton;
	
	//* Cancel Button 
	@FindBy(xpath = "//div[@class='ant-modal-root']//button[1]")
	public static WebElement cancelbutton;
	
	//* Success Message
	@FindBy(xpath="//div[contains(@class,'ant-notification ant-notification-topRight')]//div")
	public static WebElement successMsg;
	
	
	//* First Data Of the Table
	@FindBy(xpath="//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement firstdata;
	
	/* Edit */
	
	//* Update Button
	@FindBy(xpath="//div[@class='ant-modal-root']//button[2]")
	public static WebElement updatebtn;
	
/* Delete */
	
	//* Table Container
	@FindBy(xpath="//*[@id='root']/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]")
	public static WebElement productionSampleTable;
		
	//* Delete confirm Button
	@FindBy(xpath="//span[normalize-space()='OK']")
	public static WebElement okbtn ;
	
	//* Table Count
	@FindBy(xpath="//li[@class='ant-pagination-total-text']")
	public static WebElement tablecount;
	
/* Validation Message */
	
	//* Table Count
	@FindBy(xpath="//div[normalize-space()='Test already depend']")
	public static WebElement alreaydependvalidation;
	
	//* Parameter Data Type Validation
	@FindBy(xpath="//div[@class=\"input_wrapper\"]/div[@style=\"color: red; font-size: 12px; width: 300px; height: 2px;\"][1]")
	public static WebElement parametervalidation;
	
	//* Parameter Type Validation
	@FindBy(xpath="/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[1]/div/div[2]")
	public static WebElement parametertypevalidation;
	
	//* Parameter Data Type Validation
	@FindBy(xpath="//div[normalize-space()='Parameter Data Type cant be empty']")
	public static WebElement parameterdatatypevalidation;
		

		
	
	//Add Parameter Window Heading
	@FindBy(xpath = "//*[@id=\"rcDialogTitle0\"]/div/p")
	public static WebElement AddParameterWindowHeading;
	
	//Add Test Button 
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/button")
	public static WebElement AddTestButton;
	
	//Add Test Button Window Heading
	@FindBy(xpath = "//*[@id=\"rcDialogTitle0\"]/div/p")
	public static WebElement AddTestButtonWindowHeading;
	
	
	//Parameter Search icon Button
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]")
	public static WebElement ParameterSearchiconButton;
	
	//Parameter Search text box
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/input")
	public static WebElement ParameterSearchtextbox;
	
	// Parameter Search Button
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div/button[1]")
	public static WebElement ParameterSearchButton;
	
	//AddGroup button function Under test parameter
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div/form[1]/div/div/div/div/div[1]/div/div/div[4]/button")
	public static WebElement AddGroupbuttonfunction;
	
	//Groupkeys Window Heading
	@FindBy(xpath = "//*[@id=\"rcDialogTitle0\"]")
	public static WebElement GroupkeysWindowHeading;  	
	
	
	//Add Parameter button function Under the test parameter
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div/form[1]/div/div/div/div/div[1]/div/div/div[4]/div[2]/button")
	public static WebElement AddParameterbuttonunctionUnderthetestparameter;
	
	//Add Parameter Button function window heading
	@FindBy(xpath = "//*[@id=\"rcDialogTitle0\"]/div/p")
	public static WebElement AddParameterButtonfunctionwindowheading;
	
	
	//Check Multi Search Functionality
	@FindBy(xpath = "//div[@class='ant-table-container']")
	public static WebElement MultiSearchFunction;
	//test parameter pagination
    @FindBy (xpath = "//span[@aria-label='left']//*[name()='svg']")
   	public static WebElement previousbt;
   	@FindBy (xpath = "//span[@aria-label='right']//*[name()='svg']")
   	public static WebElement nextbt;
   	@FindBy (xpath = "//a[normalize-space()='2']")
   	public static WebElement pag2nd;
   	@FindBy (xpath = "//a[normalize-space()='1']")
   	public static WebElement pag1st;
   	@FindBy (xpath = "//span[@title='10 / page']")
   
   	public static String bef="//div[@class='rc-virtual-list-holder-inner']/div[";
   	public static String aft= "]/div";
 
   
   	@FindBy (xpath = "//div[contains(text(),'Test Parameter')]")
   	public static WebElement pharameter;
   	
   	//test parameter button
   	@FindBy (xpath = "//section/section/main/div/div/div[1]/div/div[2]/div[1]")
   	public static WebElement testparameterbtn;
   	
   	//test parameter main heading
   	@FindBy(xpath = "//div[@class='ant-table-title']/div/div[1]")
   	public static WebElement testparameterheading;
   	
   	//parameter table heading
   	@FindBy (xpath = "//thead[@class='ant-table-thead']/tr/th[1]")
   	public static WebElement parametertableheading;
   	
   	//parametertpe heading
   	@FindBy (xpath = "//thead[@class='ant-table-thead']/tr/th[2]")
   	public static WebElement parametertpeheading;
   	
   	//parameter search icon
   	@FindBy (xpath = "//thead[@class='ant-table-thead']/tr/th[1]//span[2]/span")
   	public static WebElement parameterSearchicon;
   	
   	//parameter tpe search icon
   	@FindBy (xpath = "//thead[@class='ant-table-thead']/tr/th[2]//span[2]/span")
   	public static WebElement parameterTypesearchicon;
   	
   	//parameter search popup
   	@FindBy (xpath = "//div[@class='ant-table-filter-dropdown']")
   	public static WebElement parametersearchpopup;
   	
   	//parameter type search popup
   	@FindBy (xpath = "//div[@class='ant-table-filter-dropdown']")
   	public static WebElement parametertypesearchpop;
   	
   	//parameter search text box
   	@FindBy (xpath = "//div[@class='ant-table-filter-dropdown']//input")
   	public static WebElement parameterSearchtextbox;
   	
   	//parmeter type search text box
   	@FindBy (xpath = "//input[@id='parameterType']")
   	public static WebElement parameterTypesearchtextbox;
   	
   	//parameter search button
   	@FindBy(xpath = "//body/div[2]/div/div/div/div/div/button[1]")
   	public static WebElement parameterSearchbutton;
   	
   	//parameter type search button
   	@FindBy (xpath = "//input[@id='parameterType']//..//..//..//..//button[1]")
   	public static WebElement parametertpesearchbutton;
   	
   	//parameter reset button
   	@FindBy (xpath = "//body/div[2]/div/div/div/div/div/button[2]")
   	public static WebElement parameterresetbutton;
   	
   	//parameter type rest button
   	@FindBy (xpath = "//input[@id='parameterType']//..//..//..//..//button[1]")
   	public static WebElement parametertyperestbutton;
   	
   	////*****************************************SHOBIKA****************************************************////////////////
   	
 	@FindBy(xpath = "//th[3]//span[@class='ant-table-column-title']")
	public static WebElement Parameterdata;
 	
 	@FindBy(xpath = "//th[3]//span[@role='button']")
	public static WebElement tpmsearchicon;
 	
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']")
	public static WebElement pmDatasearchpopup;
	
	@FindBy(xpath = "//input[@id='parameterDataType']")
	public static WebElement pmDatasearchdropdown;
	
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//button[1]")
	public static WebElement pmDatasearchbutton;

	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//button[2]")
	public static WebElement pmDataresetbutton;
//*******************************************************************************************
	
	@FindBy(xpath = "//thead//th[4]")
	public static WebElement parameteraction;
	
	@FindBy(xpath = "//div[@class='sc-bxivhb hiMnNy']//button")
	public static WebElement addparameterbtn;

	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement addparameterpopupscreen;
	
	@FindBy(xpath = "//div[@class='ant-modal-header']")
	public static WebElement addparameteheading ;
	
	@FindBy(xpath = "//input[@id='parameterType']/ancestor::div[@class='input_wrapper']/label")
	public static WebElement parametrtypeheading;
	
	@FindBy(xpath = "//input[@id='parameterDataType']/ancestor::div[@class='input_wrapper']/label")
	public static WebElement parametrdatatype;
	
	//********************************************************************************************
	@FindBy(xpath = "//textarea[@id='parameter_name']/ancestor::div[@class='input_wrapper']/label")
	public static WebElement datetypedropdownnameheading;
	
	@FindBy(xpath = "//textarea[@id='parameter_name']")
	public static WebElement ParameterFiledTextbox ;
	
	@FindBy(xpath = "//input[@id='parameterType']")
	public static WebElement Parametertypetextbox;
	
	@FindBy(xpath = "//input[@id='parameterDataType']")
	public static WebElement Parametertdataypetextbox ;
	
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[1]")
	public static WebElement parameterancelbutton;
	
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[2]")
	public static WebElement parametersavebutton ;
	//**********************************************************************************************
	
	@FindBy(xpath = "//div[@class='ant-modal-header']//span")
	public static WebElement parameterclosebutton;
	
	@FindBy(xpath = "//li[@class='ant-pagination-next']")
	public static WebElement Paginationnnextbtn;
	
	@FindBy(xpath = "//li[@class='ant-pagination-prev']")
	public static WebElement PaginationPreviousBtn;
	
	@FindBy(xpath = "//li[@class='ant-pagination-options']")
	public static WebElement Paginationdropdown;
	
	@FindBy(xpath = "//div[@class='ant-spin-nested-loading']//button[@type='button']")
	public static WebElement resetallbutton ;
	
	
	
	
}
   	
	

