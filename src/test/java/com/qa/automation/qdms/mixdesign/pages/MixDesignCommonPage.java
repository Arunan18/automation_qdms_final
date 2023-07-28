package com.qa.automation.qdms.mixdesign.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MixDesignCommonPage {
	
	//======================================= COPY PASTE ==============================
	@FindBy(xpath = "(//span[@aria-label='copy'])")
	public static WebElement copy;
	
	//============================  ADD BUTTON ========================================
	@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw']")
	public static WebElement addbtn;
	
	//================================ TABLE ===========================================
	@FindBy(xpath = "//*[@id='root']/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]")
	public static WebElement Table;
	
	
	//================================ DATE ============================================
	@FindBy(xpath = "//input[@id='date']")
	public static WebElement datePlaceHolder;
	
	//================================  SAVE BUTTON ===================================
	@FindBy(xpath = "(//button[@type='button'])[8]")
	public static WebElement saveButton;
	
	//================================== NEXTBTN========================================
	@FindBy(xpath = "//li[@title='Next Page']")
	public static WebElement NextBtn;
	
	//============================== PLUS SIGN =========================================
	@FindBy(xpath = "(//span[@aria-label='plus-circle'])[1]")
	public static WebElement PlusSign;
	
	//============================== CREATION DATE PLACE HOLDER ========================
	@FindBy(xpath = "(//input[@id='creationDate'])[1]")
	public static WebElement CreationDate;
	
	//================================ ADD LABTRAIL CANCEL BUTTON ======================
	@FindBy(xpath = "(//button[@type='button'])[20]")
	public static WebElement CancelButtonOfaddplantLabtrail;
	
	//================================== TABLE DATA ====================================
	@FindBy(xpath = "(//td)[15]")
	public static WebElement TableDataDate;
	
	//================================== FORM =========================================
	@FindBy(xpath = "(//input[@id='rawMaterialId'])[1]")
	public static WebElement PlacHolderToClick;
	
	//========================== STATUS ==============================================
	@FindBy(xpath = "(//span[@class='ant-tag ant-tag-has-color'])[3]")
	public static WebElement StatusNew;
	
	//============================= EDIT BUTTON =====================================
	@FindBy(xpath = "(//span[@aria-label='edit'])")
	public static  WebElement EditButtonNEW;
	
	//============================ ML ==============================================
	@FindBy(xpath = "(//div[@title='ml'])[3]")
	public static WebElement ML;
	
	//===================== ARROW ===================================================
	@FindBy(xpath = "(//span[@aria-label='down'])[6]")
	public static WebElement Arrow; 
	
	//========================== FULL VIEW ==========================================
	@FindBy(xpath = "(//span[@aria-label='form'])[1]")
	public static WebElement FullView;
	
	
	
	
	//===================== SAVE BUTTON =========================================
	@FindBy(xpath = "(//button[@type='button'])[8]")
	public static WebElement Save_Btn;

	

}
