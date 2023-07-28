package com.qa.automation.qdms.pages.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationPage {
	@FindBy(xpath = "//main/div/div/div/div[1]/a")
	public static WebElement Master;
	@FindBy(xpath = "//header/ul//li[1]//a")
	public static WebElement MainPlant;
	@FindBy(xpath = "//header/ul//li[2]//a")
	public static WebElement MainEqupment;
	@FindBy(xpath = "//a[@href='#/master/materiallevel']")
	public static WebElement MainMaterial;
//	@FindBy(xpath = "//li[@class='ant-menu-overflow-item ant-menu-item ant-menu-item-only-child']//a[@href='#/master/customerlevel']")
//=======
//	@FindBy(xpath = "//header/ul//li[3]//a")
//	public static WebElement MainMaterial;
	@FindBy(xpath = "//header/ul//li[4]//a")
	
	public static WebElement MainCustomer;
	@FindBy(xpath = "//header/ul//li[5]//a")
	public static WebElement MainSupplier;
	@FindBy(xpath = "//a[@href='#/master/employeelevel']")
	public static WebElement MainEmployee;

	@FindBy(xpath = "//div[@class='sc-htoDjs jApeNY']/div[1]")
	public static WebElement Sbu;
	@FindBy(xpath = "//div[@class='sc-htoDjs jApeNY']/div[2]")
	public static WebElement Plant;
	@FindBy(xpath = "//main/div/div/div[1]/div/div[1]")
	public static WebElement Equipment;
	@FindBy(xpath = "//main/div/div/div[1]/div/div[2]")
	public static WebElement PlantEquipment;
	@FindBy(xpath = "//div[@class='sc-htoDjs jApeNY']/div[1]")
	public static WebElement MaterialMainCategory;
	@FindBy(xpath = "//div[@class='sc-htoDjs jApeNY']/div[2]")
	public static WebElement MaterialSubCategory;
	@FindBy(xpath = "//div[@class='sc-htoDjs jApeNY']/div[3]")
	public static WebElement MaterialState;
	@FindBy(xpath = "//div[@class='sc-htoDjs jApeNY']/div[4]")
	public static WebElement Source;
	@FindBy(xpath = "//div[@class='sc-htoDjs jApeNY']/div[5]")
	public static WebElement Material;
	@FindBy(xpath = "//div[@class='sc-htoDjs jApeNY']/div[6]")
	public static WebElement Unit;
	@FindBy(xpath = "//div[contains(@class,'sc-htoDjs')]/div[1]")
	public static WebElement Customer;
	@FindBy(xpath = "//div[@class='sc-htoDjs jApeNY']/div[2]")
	public static WebElement Project;
	@FindBy(xpath = "//div[@class='sc-htoDjs jApeNY']/div[3]")
	public static WebElement Delivery;
	@FindBy(xpath = "//div[contains(@class,'sc-htoDjs')]/div[1]")
	public static WebElement SupplierCategory;
	@FindBy(xpath = "//div[contains(@class,'sc-htoDjs')]/div[2]")
	public static WebElement Supplier;
	@FindBy(xpath = "//div[@class='sc-htoDjs jApeNY']/div[1]")
	public static WebElement Designation;
	@FindBy(xpath = "//div[@class='sc-htoDjs jApeNY']/div[2]")
	public static WebElement Role;
	@FindBy(xpath = "//div[@class='sc-htoDjs jApeNY']/div[3]")
	public static WebElement Employee;
	@FindBy(xpath = "//div[@class='sc-htoDjs jApeNY']/div[4]")
	public static WebElement User;
}
