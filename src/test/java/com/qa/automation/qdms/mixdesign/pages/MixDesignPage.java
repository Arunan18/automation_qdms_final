package com.qa.automation.qdms.mixdesign.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.automation.qdms.base.DriverIntialization;

public class MixDesignPage extends DriverIntialization {

	public static WebElement MixDesignXpath() {
		return driver.findElement(By.xpath("//a[@class='sc-bdVaJa ieeiNp'][@href='#/mixdesign']"));
	}

	public static WebElement MiXDesignBomComposition() {
		return driver.findElement(By.xpath("(//div[@class='sc-dnqmqq kXHGNP'])[1]"));
	}

	@FindBy(xpath = "//li[@title='Next Page']//button[@type='button']")
	public static WebElement NextPageButton;

	@FindBy(xpath = "//li[@title='Previous Page']//button[@type='button']")
	public static WebElement PreviousPageButton;

	@FindBy(xpath = "//li[@title='1']")
	public static WebElement FirstPageButton;

	@FindBy(xpath = "//li[@title='2']")
	public static WebElement SecondPageButton;

	@FindBy(xpath = "//span[@title='10 / page']")
	public static WebElement DownArrow;

	public static String BeforePagination = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/ul/li[11]/div/div[2]/div/div/div/div[2]/div/div/div/div[";
	public static String AfterPagination = "]/div";

	// Plant
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[2]/div[1]/button")
	public static WebElement PlantSearchButton;

	@FindBy(xpath = "//th[1]//div[1]//span[2]")
	public static WebElement plantSearchIcon;

	@FindBy(xpath = "//input[@name='plantName']")
	public static WebElement plantTextbox;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
	public static List<WebElement> plantColumn;

	public static String plantColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String plantColumnAfter = "]/td[1]";

	@FindBy(xpath = "//span[@class=\"ant-dropdown-trigger ant-table-filter-trigger\"]")
	public static WebElement plantsearchicon;

	@FindBy(xpath = "//input[@placeholder=' Plant']")
	public static WebElement plantsearchtextbox;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement plantsearchbutton;

	@FindBy(xpath = "//span[normalize-space()='Reset']")
	public static WebElement plantresetbutton;

	// Finish product

	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[2]/div[1]/button")
	public static WebElement FinishproductSearchButton;

	@FindBy(xpath = "//th[2]//div[1]//span[2]")
	public static WebElement FinishproductSearchIcon;

	@FindBy(xpath = "//input[@name='rawMaterialName']")
	public static WebElement FinishproductTextbox;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[2]")
	public static List<WebElement> FinishproductColumn;

	public static String finishProductColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String finishProductColumnAfter = "]/td[2]";

	@FindBy(xpath = "//span[normalize-space()='Search']")
	public static WebElement finishproductSearchbutton;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div[3]/button")
	public static WebElement FinishproductresetButton;

	// Mix Design / BOM / Composition

	@FindBy(xpath = "/html/body/div[5]/div/div/div/div/div[2]/div[1]/button")
	public static WebElement MBCSearchButton;

	@FindBy(xpath = "//th[3]//div[1]//span[2]")
	public static WebElement MBCSearchIcon;

	@FindBy(xpath = "//input[@name='code']")
	public static WebElement MBCTextbox;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[3]")
	public static List<WebElement> MBCColumn;

	public static String MBCColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String MBCColumnAfter = "]/td[3]";

	@FindBy(xpath = "//th[3]//div[1]//span[2]//span[1]//*[name()='svg']")
	public static WebElement mixdesignbomcompositionsearchicon;

	@FindBy(xpath = "//input[contains(@placeholder,'Mix Design / BOM / Composition')]")
	public static WebElement mixdesignbomcompositionsearchtextbox;

	@FindBy(xpath = "//span[normalize-space()='Search']")
	public static WebElement mixdesignbomcompositionsearchbutton;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div[3]/button")
	public static WebElement mbcresetButton;

	// Date

	@FindBy(xpath = "/html/body/div[6]/div/div/div/div/div[2]/div[1]/button")
	public static WebElement dateSearchButton;

	@FindBy(xpath = "//th[5]//div[1]//span[2]")
	public static WebElement dateSearchIcon;

	@FindBy(xpath = "//input[@name='mixDate']")
	public static WebElement dateTextbox;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[5]")
	public static List<WebElement> dateColumn;

	public static String dateColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String dateColumnAfter = "]/td[5]";

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement datesingleSearchButton;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement dateResetButton;

	// Status

	@FindBy(xpath = "/html/body/div[7]/div/div/div/div/div[2]/div[1]/button")
	public static WebElement statusSearchButton;

	@FindBy(xpath = "//th[8]//div[1]//span[2]")
	public static WebElement statusSearchIcon;

	@FindBy(xpath = "//*[@id=\"status\"]")
	public static WebElement statusTextbox;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td[8]")
	public static List<WebElement> statusColumn;

	public static String statusColumnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String statusColumnAfter = "]/td[8]";

	@FindBy(xpath = "//a[@class='sc-bdVaJa ieeiNp'][@href='#/mixdesign']")
	public static WebElement mixedDesignCard;

	@FindBy(xpath = "//*[@id=\"status\"]")
	public static WebElement statussearchTextbox;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public static WebElement StatussearchButton;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement StatussearchresetButton;

	// MIXED DESIGN ADD BUTTON
	@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']")
	public static WebElement mixedDesignAddButton;

	// PLANT DROPDOWN TEXT BOX
	@FindBy(xpath = "//*[@id=\"plant\"]")
	public static WebElement plantTextBoxR;

	// SUB CATEGORY DROPDOWN TEXT BOX
	@FindBy(xpath = "//*[@id=\"SubCategory\"]")
	public static WebElement subCategoryTextBox;

	// RAW MATERIAL DROPDOWN
	@FindBy(xpath = "//*[@id=\"rawMaterialId\"]")
	public static WebElement rawMeterialTextBox;

	// DATE TEXT BOX
	@FindBy(xpath = "//*[@id=\"date\"]")
	public static WebElement dateTextBox;

	// STATUS TEXT BOX
	@FindBy(xpath = "//*[@id=\"status\"]")
	public static WebElement statusTextBox;

	// MIXED DESIGN SAVE BUTTON
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[2]")
	public static WebElement mixedDesignSaveButton;

	// MIXED DESGIN RETURN BUTTON
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[1]")
	public static WebElement mixedDesignReturnButton;

	// TABLE FIRST ROW EDIT ICON
	@FindBy(xpath = "//tbody/tr[2]/td[10]/span[1]/a[1]/span[1]")
	public static WebElement firstRowEditIcon;

	// PLANT VALIDATION MESSAGE
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[1]/div[1]/div/div[2]")
	public static WebElement plantValidationMessage;

	// DATE VALIDATION MESSAGE
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[1]/div[2]/div/div[2]")
	public static WebElement dateValidationMessage;

	// FINISH PRODUCT VALIDATION MESSAGE
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[3]/div/div/div[2]")
	public static WebElement finishProductValidationMessage;

	// PROPTION VALIDATION MESSAGE
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/p")
	public static WebElement propotionValidationMessage;

	// DATE REMOVE ICON
	@FindBy(xpath = "//span[@role='button']//span[@aria-label='close-circle']")
	public static WebElement dateRemoveIcon;

	// Mix design Table
	@FindBy(xpath = "//div[@class='ant-table-container']")
	public static WebElement mixdesignTable;

	// Mix design More Icon
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	public static WebElement mixdesignMoreIcon;

	@FindBy(xpath = "//html/body/div[3]/div/div/div/div[2]")
	public static WebElement mixdesignMorePopup;

	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	public static WebElement paginationCount;

	// DELETE OK BUTTON
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[2]")
	public static WebElement deleteOkButton;

	// PROPORTION SUBMIT BUTTON
	@FindBy(xpath = "//div[@class='ant-table-footer']//div//button[@type='button']")
	public static WebElement proportionSubmitButton;

	// RAW MATERIAL CLOSE BUTTON
	@FindBy(xpath = "(//button[@aria-label='Close'])[1]")
	public static WebElement rawMaterialCloseButton;

	// VALIDATION FOR PROPORTION
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/p")
	public static WebElement validationMesssageProportion;

	// ADD PLANT LAB TRIAL SAMPLE ICON - MIX DESIGN
	@FindBy(xpath = "//tbody/tr[2]/td[4]/span[1]//*[name()='svg']")
	public static WebElement addplantlabtrialsampleIcon;

	// ADD PLANT LAB TRIAL SAMPLE ICON - MIX DESIGN
	@FindBy(xpath = "//input[@id='plantEquipmentSerialNo']")
	public static WebElement addplantlabtrialsampleplantTextbox;

	// ADD PLANT LAB TRIAL SAMPLE ICON - MIX DESIGN
	@FindBy(xpath = "//input[@id='plantEquipmentSerialNo']")
	public static WebElement addplantlabtrialsampleplantErrormsg;

	// ADD PLANT LAB TRIAL SAMPLE SAVE BUTTON - MIX DESIGN
	@FindBy(xpath = "//span[normalize-space()='Save']")
	public static WebElement addplantlabtrialsampleplantSavebutton;

	@FindBy(xpath = "//div[@class='ant-col ant-col-12']//div[3]")
	public static WebElement addplantlabtrialSTARTDATEErrormsg;

	@FindBy(xpath = "//input[@id='date']")
	public static WebElement addplantlabtrialsampleDateTextbox;

	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	public static WebElement addplantlabtrialcancelButton;

	// PLANT EQUIPMENT TEXT BOX IN PLANT LAB TRAIL SAMPLE
	@FindBy(xpath = "//*[@id=\"plantEquipmentSerialNo\"]")
	public static WebElement plantEquipmentTextBox;

	// SAMPLE DATE TEXT BOX IN PLANT LAB TRAIL SAMPLE
	@FindBy(xpath = "//*[@id=\"date\"]")
	public static WebElement sampleDate;

	// SAMPLE CODE TEXT BOX IN PLANT LAB TRAIL SAMPLE
	@FindBy(xpath = "//*[@id=\"finishProductCode\"]")
	public static WebElement sampleCode;

	// CREATION DATE TEXT BOX IN PLANT LAB TRAIL SAMPLE
	@FindBy(xpath = "//*[@id=\"creationDate\"]")
	public static WebElement creationDate;

	// SAVE BUTTON IN PLANT LAB TRAIL SAMPLE
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[2]")
	public static WebElement saveButtonPlantLabTrail;

	// CANCEL BUTTON IN PLANT LAB TRAIL SAMPLE
	@FindBy(xpath = "//div[@class='ant-modal-footer']//button[1]")
	public static WebElement cancelButtonPlantLabTrail;

	// CREATION DATE CLOSE BUTTON IN PLANT LAB TRAIL SAMPLE
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[4]/div/div/div/div/span[2]/span")
	public static WebElement closeButtonCreationDate;

	// ADD PRODUCTION SAMPLE BUTTON(RAHUL)
	@FindBy(xpath = "//div[@class='ant-table-title']/div/div[9]/div/button/span")
	public static WebElement productionSampelButton;

	@FindBy(xpath = "//div[@class='ant-table-container']")
	public static WebElement productionSampleTable;

	@FindBy(xpath = "//div[@class='ant-modal-content']")
	public static WebElement testandresulticonpopup;

	@FindBy(xpath = "//button[@class='ant-btn']")
	public static WebElement teststatuCancelbutton;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-default']")
	public static WebElement teststatusOkbutton;

	// @Sasi - 07.07.2023 Modified

	// Plant Equipment Field Validation
	@FindBy(xpath = "//input[@id='plantEquipmentSerialNo']/ancestor::div[@class='input_wrapper']/div[2]")
	public static WebElement plantequvalidation;

	// Add Plant-Lab Trial Sample Pop up Screen
	@FindBy(xpath = "//div[@class='ant-modal-body']")
	public static WebElement plantTrailPopUpScreen;

	// Sample Date Field Validation
	@FindBy(xpath = "//div[@class='ant-picker']/ancestor::div[@class='input_wrapper']/div[2]")
	public static WebElement sampleDateValidationField;

	// Sample Code Field Validation
	@FindBy(xpath = "//input[@id='finishProductCode']/ancestor::div[@class='input_wrapper']/div[1]")
	public static WebElement sampleCodeValidationField;

	// Admin Home Button
	@FindBy(xpath = "//div[@class='homebtn']")
	public static WebElement adminHomeButton;

}
