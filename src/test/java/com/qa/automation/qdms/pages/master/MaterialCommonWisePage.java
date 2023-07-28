package com.qa.automation.qdms.pages.master;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MaterialCommonWisePage{
	@FindBy (xpath =  "//a[@href='#/master/materiallevel']")
	public static WebElement material;
	
	@FindBy (xpath =  "//div[@class='sc-dnqmqq hnktPT'][normalize-space()='Material']")
	public static WebElement materialbutton;
	
	@FindBy (xpath =  "//span[normalize-space()='Add Material']")
	public static WebElement addmaterialbutton;
	
	@FindBy (xpath =  "//div[@class='ant-modal-content']")
	public static WebElement addmaterialpopup;
	
	@FindBy (xpath = "//input[@value='COMMON']")
	public static WebElement commonradiobutton;
	
	@FindBy (xpath =  "//th[4]//div[1]//span[2]//span[1]//*[name()='svg']")
	public static WebElement prefixsearchicon;
	
	@FindBy (xpath =  "//input[@placeholder='Prefix']")
	public static WebElement prefixsearchbox;
	
	@FindBy (xpath =  "/html[1]/body[1]/div[12]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/span[2]")
	public static WebElement searchbutton;
	
	@FindBy (xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[4]")
	public static WebElement prefixdata;
	
	@FindBy (xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[11]/div/span")
	public static WebElement descriptionbutton;
	
	@FindBy (xpath = "/html/body/div[13]/div/div[2]/div/div[2]")
	public static WebElement descriptionpopup;
	
	@FindBy (xpath = "/html/body/div[13]/div/div[2]/div/div[2]/div[2]")
	public static WebElement popupbody;
	
	
	
	@FindBy (xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[10]/span/span")
	public static WebElement sourceicon;
	
	@FindBy (xpath =  "//div[@class='ant-popover ant-popover-placement-top ']")
	public static WebElement sourcepopover;
	
	@FindBy (xpath = "//div[@class='ant-popover-inner-content']")
	public static WebElement popovercontent;
	
	
    //SARANKA XPATH MATERIAL PLANT WISE
	
	//=========================== MATERIAL MENU BAR ======================================
	@FindBy(xpath = "//a[@href='#/master/materiallevel']")
	public static WebElement MaterialMenuBar;
	
	//=========================== MATERIAL  ================================================
	@FindBy(xpath = "(//div[@class='sc-dnqmqq hnktPT'][normalize-space()='Material'])[1]")
	public static WebElement  mmaterialSubCategory;

	
	//=========================== SOURCE - DESCRIPITION POP-UP ICON X-PATH ===================
	@FindBy(xpath = "(//span[@aria-label='build'])[3]")
	public static WebElement SourceDescripitionIcon;
	
	//=========================== SOURCE - DESCRIPITION POP-UP BOX X-PATH ====================
	@FindBy(xpath = "(//div[@class='ant-popover ant-popover-placement-top '])[1]") 
	public static WebElement  sourcePopupBox;
	
	//=================================SOURCE POPUP CONTENT =================================== 
	@FindBy(xpath = "//div[@class='ant-popover-inner-content']")
	public static WebElement popupContent;
	
	//=========================== SOURCE - POP-UP TITLE 1st BOX X-PATH ========================
	@FindBy(xpath = "//div[@class='ant-popover-title']")
	public static WebElement popupFirstTitle;
	
	//=========================== SOURCE -POP-UP 2ND CONTENT BOX X-PATH =======================
	@FindBy(xpath = "(//div[@class='ant-popover-inner-content'])[1]")
	public static WebElement popupContentTwo;
	
	//=========================== SOURCE -POP-UP 2ND CONTENT BOX X-PATH ========================
	@FindBy(xpath = "//p[normalize-space()='New Material']")
	public static WebElement FirstList;
	
	//=========================== SOURCE -POP-UP ARROW X-PATH ==================================
	@FindBy(xpath = "//div[@class='ant-popover-arrow']")
	public static WebElement Arrow;
	
	//====================================== DESSCRIPITION =======================================
		@FindBy(xpath = "(//span[@aria-label='container'])[2]")
		public static WebElement DescripitionPopupIcon;
		
		//====================================== DESCRIPITION POPUP ===================================
		@FindBy(xpath = "(//div[@role='document'])[1]")
		public static WebElement DescripitionPopupBox;
		
		//====================================== DESCRIPITION TITLE ===================================
		@FindBy(xpath = "//*[@id=\"rcDialogTitle0\"]")
		public static WebElement TitleDescripition;
		
		//====================================== DESCRIPITION CONTENT ===================================
		@FindBy(xpath = "//body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[2]")
		public static WebElement  DescripitionContent;
		
		//====================================== CLSOE BUTTON===========================================
		@FindBy(xpath = "(//button[@class='ant-btn ant-btn-ghost sc-gZMcBi dMdnOw'])[1]")
		public static WebElement closeButton;
		
		//====================================== CLSOE ICON ===========================================
		@FindBy(xpath = "(//span[@class='ant-modal-close-x'])[1]")
		public static WebElement CloseIcon;
		
	
		
	

	



}
