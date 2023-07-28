package com.qa.automation.qdms.testconfig.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class configGroupTestsPage {

	@FindBy(xpath = "//div[@class='ant-table-title']//div//div[contains(text(),'Group Tests')]")
	public static WebElement materialmaintestdropdown; 
	
	@FindBy(xpath = "//div[contains(text(),'Config Group Test')]")
	public static WebElement configgrouptestsleftnav;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/form/div[1]")
	public static WebElement configgrouptesttableHeading;
	
	
	//CONFIG GROUP TEST//


		@FindBy(xpath = "//div[@class='sc-dnqmqq bxMwVY']")
		public static WebElement configgrouptestbutton;
		
		@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
		public static WebElement deleteconfirmationOKbutton;
		
		@FindBy(xpath = "//li[@class='ant-pagination-item ant-pagination-item-1']")
		public static WebElement pageone;
		
		@FindBy(xpath = "//label[text()=' Name:']/..//div[1]")
		public static WebElement validation1;
		
		@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/form/div[4]/div[1]/div[1]/div/div[2]/div[3]")
		public static WebElement validation2;
		
		@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/form/div[4]/div[2]/div[2]")
		public static WebElement validation3;
		
		@FindBy(xpath = "//input[@id='group_name']")
		public static WebElement nametextbox;
		
		@FindBy(xpath = "//input[@id='report']")
		public static WebElement reportformattextbox;
		
		@FindBy(xpath = "//span[normalize-space()='Save']")
		public static WebElement Savebutton;
		
		@FindBy(xpath = "//button[@class='ant-btn sc-gZMcBi dMdnOw'][1]")
		public static WebElement clearbutton;
	
		@FindBy(xpath = "//div[contains(text(),'Test Configure')]")
		public static WebElement testconfigure;
		
		@FindBy(xpath = "//div[contains(text(),'Configure Test')]")
		public static WebElement testconfigureheadding;
		
//		Modify Quenthan

		@FindBy(xpath = "//main/div/div/div[1]/div/div[4]")
		public static WebElement ConfigGroupTestSiteButton;
		
		@FindBy(xpath = "//header//li[1]/span")
		public static WebElement mainTestNavication ;
		
		@FindBy(xpath = "//header//li[2]/span")
		public static WebElement mainManagetestConfigureNavication ;
		
		@FindBy(xpath = "//main/div/div/div[2]//h3")
		public static WebElement ConfigGroupTest_Heading;
		
		@FindBy(xpath = "//input[@id='material_category']/ancestor::div[@class='input_wrapper']/label")
		public static WebElement ConfigGroupTest_MaterialMainCategoryHeading;
		
		@FindBy(xpath = "//input[@id='material_category']")
		public static WebElement ConfigGroupTest_MaterialMainCategoryDropDown;
		
		@FindBy(xpath = "//input[@id='sub_category']/ancestor::div[@class='input_wrapper']/label")
		public static WebElement ConfigGroupTest_SubCategoryHeading;
		
		@FindBy(xpath = "//input[@id='sub_category']")
		public static WebElement ConfigGroupTest_SubCategoryDropDown;
		
		@FindBy(xpath = "//input[@id='material']/ancestor::div[@class='input_wrapper']/label")
		public static WebElement ConfigGroupTest_SelectMaterialHeading;
		
		@FindBy(xpath = "//input[@id='material']")
		public static WebElement ConfigGroupTest_SelectMaterialDropdown;
		
		@FindBy(xpath = "//form/div[3]/div[2]/div/div/div[1]/label/span[2]")
		public static WebElement ConfigGroupTest_ReportTypeCheckBoxHeading;
		

		@FindBy(xpath = "//form/div[3]/div[2]/div/div/div[1]//span[2]")
		public static WebElement ConfigGroupTest_ReportTypeCheckBoxButton;
		
		
		@FindBy(xpath = "//form/div[3]/div[2]/div/div/div[2]/label/span[2]")
		public static WebElement ConfigGroupTest_SpecialCategoryCheckBoxHeading;
		
		@FindBy(xpath = "//form/div[3]/div[2]/div/div/div[2]/label/span[1]")
		public static WebElement configGroupTest_SpecialCategoryCheckBoxButton;
		
		@FindBy(xpath = "//main[@class='ant-layout-content']/div/div/div[2]/div/form//button[1]")
		public static WebElement ConfigGroupTest_AfterDropDownTableClearButton;
		
		@FindBy(xpath = "//main[@class='ant-layout-content']/div/div/div[2]/div/form//button[2]")
		public static WebElement configGroupTest_AfterDropDownTablesaveButton;
		
		@FindBy(xpath = "//main[@class='ant-layout-content']/div/div/div[2]/div/form/div[4]/div[1]/div[1]/h4")
		public static WebElement configGroupTest_AfterDropDowncreategroupheading;
		
		@FindBy(xpath = "//main[@class='ant-layout-content']/div/div/div[2]/div/form/div[4]/div[1]/div[1]/div/div[1]/label")
		public static WebElement configGroupTest_AfterDropDowncreategroupnameheading;
		
		@FindBy(xpath = "//main[@class='ant-layout-content']/div/div/div[2]/div/form/div[4]/div[1]/div[1]/div/div[1]/input")
		public static WebElement configGroupTest_AfterDropDowncreategroupnametextbox;
		
		@FindBy(xpath = "//main[@class='ant-layout-content']/div/div/div[2]/div/form/div[4]/div[1]/div[1]/div/div[2]//label")
		public static WebElement configGroupTest_AfterDropDowncreatereportformatheading;
		
		@FindBy(xpath = "//main[@class='ant-layout-content']/div/div/div[2]/div/form/div[4]/div[1]/div[1]/div/div[2]/div[1]/div/span[1]/input")
		public static WebElement configGroupTest_AfterDropDowncreatereportformatdropdown;
		
		@FindBy(xpath = "//main[@class='ant-layout-content']/div/div/div[2]/div/form/div[4]/div[2]/h4")
		public static WebElement configGroupTest_AfterDropDownapplicabletestsheading;
		
		@FindBy(xpath = "//main[@class='ant-layout-content']/div/div/div[2]/div/form/div[4]/div[2]//thead//th[2]")
		public static WebElement configGroupTest_AfterDropDownapplicabletesttestnamesheading;
		
		@FindBy(xpath = "//main[@class='ant-layout-content']/div/div/div[2]/div/form/div[4]/div[2]//thead//th[1]")
		public static WebElement configGroupTest_AfterDropDownapplicabletesttestnamescheckbox;
		
		@FindBy(xpath = "//form/div[4]/div[2]/div[1]/div/div[1]//ul//span[@aria-label='right']/..")
		public static WebElement ConfigGroupTest_AfterDropDownapplicabletesttestnamenextbutton;
		
		@FindBy(xpath = "//form/div[4]/div[2]/div[1]/div/div[1]//ul//span[@aria-label='left']/..")
		public static WebElement configGroupTest_AfterDropDownapplicabletesttestnamenpriviousbutton;
		
		@FindBy(xpath = "//main[@class='ant-layout-content']/div/div/div[2]/div/form/div[4]/div[1]/div[2]/form/div/div/div/div/div[1]//h4")
		public static WebElement configGroupTest_AfterDropDownconfiguredgroupsheading;
		
		@FindBy(xpath = "//main[@class='ant-layout-content']/div/div/div[2]/div/form/div[4]/div[1]/div[2]/form/div/div/div/div//table/thead//th[1]")
		public static WebElement configGroupTest_AfterDropDownconfiguredgroupnameheading;
		
		
		@FindBy(xpath = "//form//form/div/div/div/div//table/thead//th[2]")
		public static WebElement configGroupTest_AfterDropDownconfiguredreportformatheading;
		
		@FindBy(xpath = "//form//form/div/div/div/div//table/thead//th[3]")
		public static WebElement configGroupTest_AfterDropDownconfiguredtestheading;
		
		@FindBy(xpath = "//div[@class='ant-modal-content']")
		public static WebElement configGroupTest_AfterDropDownconfiguredtesticonpopupscreen;
		
		@FindBy(xpath = "//div[@class='ant-modal-content']//thead//th[1]")
		public static WebElement configGroupTest_AfterDropDownconfiguredtesttestheading;
		
		@FindBy(xpath = "//div[@class='ant-modal-content']//button")
		public static WebElement configGroupTest_AfterDropDownconfiguredtesttestclosebutton;
		
		
		
		@FindBy(xpath = "//form//form/div/div/div/div//table/thead//th[4]")
		public static WebElement configGroupTest_AfterDropDownconfiguredactionheading;
		
		@FindBy(xpath = "//div[@class='ant-popover-content']")
		public static WebElement configGroupTest_AfterDropDownconfiguredeletepopupscreen;
		
		@FindBy(xpath = "//div[@class='ant-popover-content']/div/div/div[1]//span")
		public static WebElement configGroupTest_AfterDropDownconfiguredeletepopupquestionicon;
		
		@FindBy(xpath = "//div[@class='ant-popover-content']/div/div/div[2]/button[2]")
		public static WebElement configGroupTest_AfterDropDownconfiguredeletepopupokbutton;
		
		@FindBy(xpath = "//div[@class='ant-popover-content']/div/div/div[2]/button[1]")
		public static WebElement configGroupTest_AfterDropDownconfiguredeletepopupcancelbutton;
		
		@FindBy(xpath = "//form//form/div/div/div/ul//span[contains(@class,'anticon-right')]/..")
		public static WebElement configGroupTest_AfterDropDownconfiguregrouptablepaginatrionnextbutton;
		
		@FindBy(xpath = "//form//form/div/div/div/ul//span[contains(@class,'anticon-left')]/..")
		public static WebElement configGroupTest_AfterDropDownconfiguregrouptablepaginatrionpreviousbutton;
		
		@FindBy(xpath = "//main//form//div[5]/button[1]")
		public static WebElement configGroupTest_AfterDropDownconfiguregroupendtableclearbutton;
		
		@FindBy(xpath = "//main//form//div[5]/button[2]")
		public static WebElement configGroupTest_AfterDropDownconfiguregroupendtablesavebutton;
}
