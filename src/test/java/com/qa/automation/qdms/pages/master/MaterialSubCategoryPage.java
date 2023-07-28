package com.qa.automation.qdms.pages.master;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MaterialSubCategoryPage {
//RELEVANT TEST	
//#########################################################################################################
//*****************************************************************************************************
//                 xpath of material in tabs 
//******************************************************************************************************	
	@FindBy(xpath = "//a[@href='#/master/materiallevel']")
	public static WebElement equipment;
	
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/header/ul/li[3]")
	public static WebElement material;

//******************************************************************************************************
//                       xpath of material sub catergory button
//*******************************************************************************************************
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[2]")
	public static WebElement materialsubcatergorybutton;

	@FindBy(xpath = "//div[@class='sc-htoDjs jApeNY']/div[2]")
	public static WebElement materialsubcatergorybuttonnew;
	
	
//*****************************************************************************************************
//                     xpath of relevant test checkbox
//*****************************************************************************************************
	@FindBy(xpath = "//*[@id=\"status\"]")
	public static WebElement materialsubcatergorycheckbox;

//**********************************************************************************************************
//              xpath   material sub category cancel button
//**********************************************************************************************************	

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/div/button[1]")
	public static WebElement materialsubcatergorycancel;

//**********************************************************************************************************
//                    xpath   material sub category save button
//**********************************************************************************************************	

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/div/button[2]")
	public static WebElement materialsubcatergorysavebutton;

//**********************************************************************************************************
//    xpath of relevant test icon
//**********************************************************************************************************	

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[5]/span")
	public static WebElement relevanttest;
//#############################################################################################################

//PAGINATION
//###########################################################################################################	

//**********************************************************************************************************
//	    xpath of 1st page of pagination
//**********************************************************************************************************	

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/ul/li[3]")
	public static WebElement DefaultPaginationPage;

//**********************************************************************************************************
//	    xpath of 1st page of pagination
//********************************************************************************************************

	@FindBy(xpath = "//li[@title='Next Page']//button[@type='button']")
	public static WebElement nxtpage;

//**********************************************************************************************************
//	    xpath of 2st page of pagination
//********************************************************************************************************
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/ul/li[4]")
	public static WebElement PaginationSecoundPage;

//**********************************************************************************************************
//	    xpath of prevoius button of pagination
//********************************************************************************************************
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/ul/li[2]/button")
	public static WebElement PreviousPageBtn;

//**********************************************************************************************************
//	    xpath of page count text of pagination
//********************************************************************************************************
	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	public static WebElement paginationCount;

//**********************************************************************************************************
//	    xpath of dropdown text of pagination
//********************************************************************************************************
	@FindBy(xpath = "//ul[@class='ant-pagination mini ant-table-pagination ant-table-pagination-right']/li/div")
	public static WebElement CurrentPaginationOpction;

//**********************************************************************************************************
//	    xpath of 20 / page text of pagination
//********************************************************************************************************		

	@FindBy(xpath = "//div[contains(text(),'20 / page')]")
	public static WebElement Page_20;

//**********************************************************************************************************
//	    xpath of 30 / page text of pagination
//********************************************************************************************************		

	@FindBy(xpath = "//div[contains(text(),'30 / page')]")
	public static WebElement Page_30;

//**********************************************************************************************************
//	    xpath of 100 / page text of pagination
//********************************************************************************************************		

	@FindBy(xpath = "//div[contains(text(),'100 / page')]")
	public static WebElement Page_100;

//#########################################################################################################

//**********************************************************************************************************
//        xpath of add material sub catergory button
//********************************************************************************************************	

	@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']")
	public static WebElement addmaterialsubcatergorybutton;

//**********************************************************************************************************
//             xpath of main type text box
//********************************************************************************************************	

	@FindBy(xpath = "//div[@name='mainType']//div[@class='ant-select-selector']")
	public static WebElement Maintypetextbox;

//**********************************************************************************************************
//          xpath of material main category text box
//********************************************************************************************************	

	@FindBy(xpath = "//div[@name='material_category']//div[@class='ant-select-selector']")
	public static WebElement materialmaincategory;

//**********************************************************************************************************
//      xpath of material main category text box
//********************************************************************************************************	

	@FindBy(xpath = "//input[@id='prefix']")
	public static WebElement prefixtextbox;
//**********************************************************************************************************
//  xpath of material main category text box
//********************************************************************************************************	

	@FindBy(xpath = "//input[@id='subcategory_name']")
	public static WebElement subtextbox;

//**********************************************************************************************************
//  xpath of material main category text box
//********************************************************************************************************	

	@FindBy(xpath = "//div[@class='ant-modal-content']/div[@class='ant-modal-footer']/button[2]")
	public static WebElement modelsave;
//##########################################################################################################

//**********************************************************************************************************
//                 xpath of search button of material sub category
//********************************************************************************************************	

	@FindBy(xpath = "//body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[1]/div[1]/span[2]")
	public static WebElement searchbutton;

//**********************************************************************************************************
//                  xpath of search text box
//********************************************************************************************************	

	@FindBy(xpath = "//input[@placeholder='Material Sub Category']")
	public static WebElement textbox;

//#########################################################################################################

//***********************************************************************************************************
//              xpath of text of pagination
//***********************************************************************************************************
	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	public static WebElement textpagination;

//########################################################################################
//***********************************************************************************************************
//                  xpath of rest button in search
//***********************************************************************************************************	 

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/button[2]")
	public static WebElement reset;

//#######################################################################################
//***********************************************************************************************************
//                   xpath of reset all button in search
//**************************************************************************************	 
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-danger ant-btn-background-ghost']")
	public static WebElement resetall;
//####################################################################################

//**********************************************************************************************************
//	                 xpath of search button of material main category
//********************************************************************************************************	

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[2]/div/span[2]")
	public static WebElement mainsearchbutton;

//**********************************************************************************************************
//      xpath of search text box of main category
//********************************************************************************************************	

	@FindBy(xpath = "//input[@placeholder='Material Main Category']")
	public static WebElement maintextbox;

//***********************************************************************************************************
//  xpath of rest button in search
//***********************************************************************************************************	 

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/button[2]")
	public static WebElement mainreset;
//######################################################################################################################	

//**********************************************************************************************************
//xpath of search button of prefix
//********************************************************************************************************	

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[3]/div/span[2]")
	public static WebElement prefixsearchbutton;
	
//**********************************************************************************************************
//xpath of search button of maintype
//********************************************************************************************************	

		@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div/div[2]/div[1]/table/thead/tr/th[4]/div/span[2]")
		public static WebElement maintypesearchbutton;	

//**********************************************************************************************************
//xpath of search text box of prefix
//********************************************************************************************************	

	@FindBy(xpath = "//input[@placeholder='Prefix']")
	public static WebElement prefixxtextbox;

//**********************************************************************************************************
//xpath of search textbox of maintype
//********************************************************************************************************	

			@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[1]/div")
			public static WebElement maintypetextbox;	
	
//***********************************************************************************************************
//xpath of rest button in prefix search
//***********************************************************************************************************	 

	@FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']//button[2]")
	public static WebElement prefixreset;

	//***********************************************************************************************************
	//xpath of rest button in maintype search
	//***********************************************************************************************************	 

		@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[2]/button[2]")
		public static WebElement maintypereset;
	
	
	// ***************************************************************************************************************************//
	// Material sub category Multisearch
	// vithusha Mohan
	// ***************************************************************************************************************************//
	// material subcategory search input
	@FindBy(xpath = "//input[@placeholder='Material Sub Category' and @name='name']")
	public static WebElement subcategory_input;
	// material maincategory search input
	@FindBy(xpath = "//input[@placeholder='Material Main Category' and @name='materialCategoryName']")
	public static WebElement subMaincategory_input;
	// Prefix
	@FindBy(xpath = "//input[@placeholder='Prefix' and @name='prefix']")
	public static WebElement subPrefix_input;
	@FindBy(xpath = "//input[@id='materialCategoryMainType'  and @type='search']")
	public static WebElement subMainType_input;
	
//#####################################################################################################
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]")
	public static WebElement updatebutton;
	
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[4]/div/div/div")
	public static WebElement validation;
	
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[1]")
	public static WebElement cancel;
	
	public static String MaterialSubCatColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String MaterialSubCatColumnAfter="]/td[1]"; 
	public static String deleteBtnBefore="//tbody[@class='ant-table-tbody']/tr[";
	public static String deleteBtnAfter="]/td[6]/span/a[2]";
	@FindBy(xpath = "//li[@title='Next Page']/button")
	public static WebElement NextPageBtn;
	@FindBy(xpath = "//div[@class='ant-popover ant-popconfirm ant-popover-placement-top ']/div/div[2]/div/div[2]/button[2]")
	public static WebElement deleteOkBtn;
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> MaterialSubColumn;
	
	//###############################################################################################
	@FindBy(xpath = "//*[@id=\"material_category\"]")
	public static WebElement materialDropDown;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div/div/div[2]")
	public static WebElement dropDownValidation;
	@FindBy(xpath = "//*[@id=\"mainType\"]")
	public static WebElement mainType;
	@FindBy(xpath = "/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div[1]/div")
	public static WebElement dropDownSelect;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]")
	public static WebElement saveButton;
	
	@FindBy(xpath = "//*[@id=\"prefix\"]")
	public static WebElement prefixTextBox;
	 
	@FindBy(xpath = "//input[@placeholder='Prefix']")
	public static WebElement prefixTextBoxplaceholder;
	
	@FindBy(xpath = "//th[3]//div[1]//span[2]//span[1]")
	public static WebElement searchicon;
	
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement searchbuttonprefix;
	
	
	@FindBy(xpath = "//input[@id='subcategory_name']")
	public static WebElement subcategoryfield;
	
	@FindBy(xpath = "//body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[3]/button[2]")
	public static WebElement editupdatebutton;
	
	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement cancelbuttonedit; 
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[4]/div/div/div")
	public static WebElement validationedit;
	
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[3]/div/div/div[2]")
	public static WebElement prefixValidation;
	
	@FindBy(xpath = "(//button[@class='ant-btn'])[1]")
	public static WebElement cancelButton;
	
	@FindBy(xpath = "//*[@id=\"subcategory_name\"]")
	public static WebElement subCategoryTextBox;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[4]/div/div/div")
	public static WebElement subCategoryValid;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/div/div/div/div[2]/table")
	public static WebElement tablecontantforMortar;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div")
	public static WebElement popUpWindow;
	
////MODIFIED BY : Quenthan 28.03.2023
	//Material sub category Table Heading
	@FindBy(xpath = "//*[@id='root']/div/section/section/main/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[1]")
	public static WebElement matSubTableTitle;
	
	@FindBy(xpath = "//div[@class='ant-table-container']")
	public static WebElement matSubTable;
	
	@FindBy (xpath = "//input[@id='prefix']/../div[2]")
	public static WebElement prefixErrMessage;
	@FindBy (xpath = "//input[@id='prefix']/../div")
	public static WebElement prefixErrMessaget;
	@FindBy(xpath = "//input[@id='subcategory_name']/../div[1]")
	public static WebElement subCategoryErrMe;
	

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/div/button[1]")
	public static WebElement cancelButtonForTestRelevant;

	@FindBy (xpath = "//*[@id='root']/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[1]/div/div[1]")
	public static WebElement subTableTitle;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]")
	public static WebElement relavantTestTable;


	
	
	@FindBy(xpath = "//a[@href='#/master/materiallevel']")
	public static WebElement materialtab;
	
	@FindBy(xpath = "//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU brqWbd']/div[1]/div/div/div[1]/div/span[1]/input")
	public static WebElement maintype;
	
	
@FindBy(xpath = "//button[@type='button']//span[text()='Add Material Sub Category']")
public static WebElement addSubCategory;

@FindBy(xpath  = "//div[@name='mainType']/div/span")
public static WebElement mainTypes;

@FindBy(id = "material_category")
public static WebElement materialCategorys;

@FindBy(id = "prefix")
public static WebElement prefixs;

@FindBy(id = "subcategory_name")
public static WebElement materialSubCategorys;

@FindBy(xpath = "//button[@type='button']//span[text()='Save']")
public static WebElement SaveBtn;

@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']//div[text()='FINISH_PRODUCT']")
public static WebElement selectFinishProduct;

@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']//div[text()='RAW_MATERIAL']")
public static WebElement selectRawMaterial;

@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
public static WebElement successMessages;

@FindBy(xpath = "//span[@class='anticon anticon-close ant-notification-close-icon']")
public static WebElement successMessageCloseBtn;

@FindBy(xpath = "//tbody//tr[2]/td[1]")
public static WebElement subData;

@FindBy(xpath = "//tbody//tr[2]/td[2]")
public static WebElement mainData;

@FindBy(xpath = "//tbody//tr[2]/td[3]")
public static WebElement prefixData;

@FindBy(xpath = "//tbody//tr[2]/td[4]")
public static WebElement mainTypeData;

@FindBy(xpath = "//label[@for='material_category']//../div[2]")
public static WebElement mainCatValidation;

@FindBy(xpath = "//label[@for='prefix']//../div[2]")
public static WebElement prefiValidation;

@FindBy(xpath = "//label[@for='subcategory_name']//../div[1]")
public static WebElement subCatValidation;

/************************************************************************************************************
* MATERIAL SUB CATEGORY PAGE WEBELEMENTS	||		 @author Jathu Jana		||  		Date : 13/07/2023 
*************************************************************************************************************/
	//Material Sub Category Page - Search TextBox
	@FindBy(xpath = "//div[@class='ant-table-filter-dropdown']//input")
	public static WebElement SearchPopTextBox;

	//Material Sub Category - Any PopUp Model
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement popUpModel;
	
	//Material Sub Category - Any PopUp Model Save/Update/OK/Edit Button
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[1]")
	public static WebElement popUpModelFirstButton;
	
	//Material Sub Category - Any PopUp Model Close Button
	@FindBy(xpath = "//div[@class='ant-modal-title']/div/span")
	public static WebElement popUpModelCloseButton;
	
	//Add Material Sub Category Button
	@FindBy(xpath = "//div[@class='ant-table-title']//button")
	public static WebElement addMatSubCatButton;
	
	@FindBy(xpath = "//input[@id='mainType']/../..")
	public static WebElement editMainType;
	
	@FindBy(xpath = "//input[@id='material_category']/../..")
	public static WebElement editMainmaterial;
	
	@FindBy(xpath = "//div[@class='ant-modal-content']//button[2]")
	public static WebElement Update;
	
	@FindBy(xpath = "//div[@class='ant-popover-content']")
	public static WebElement deletePopUP;
	
	@FindBy(xpath = "//div[@class='ant-popover-buttons']/button[1]")
	public static WebElement deleteCancelButton;
	
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement materialSubTable;
	
	@FindBy(xpath = "//button[@type='button']//span[text()='Cancel']")
	public static WebElement CancelButton;
	
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement Table;
	
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement editPopUP;
	
	
	@FindBy(xpath = "//span[@class='ant-modal-close-x']/span")
	public static WebElement descCloseIcon;
}