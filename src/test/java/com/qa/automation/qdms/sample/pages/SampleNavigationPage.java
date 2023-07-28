package com.qa.automation.qdms.sample.pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.automation.qdms.base.DriverIntialization;


public class SampleNavigationPage extends DriverIntialization{
	@FindBy(xpath ="//a[@class='sc-bdVaJa ieeiNp'][@href='#/samples']" )
	public static WebElement sampleXpath;
	
	@FindBy(xpath ="//a[@href='#/samples']" )
	public static WebElement rawMaterialMainXpath;

	
	@FindBy(xpath ="//a[@href='#/finshproductsamples']" )
	public static WebElement finishProductMainXpath;
	
	@FindBy(xpath ="//div[@class='sc-htoDjs jApeNY']/div[1]/div[1]" )
	public static WebElement labTrialSampleXpath;
	
	public static WebElement sampleXpath() {
		return driver.findElement(By.xpath("//a[@class='sc-bdVaJa ieeiNp'][@href='#/samples']"));
	}
	
	public static WebElement rawMaterialMainXpath() {
		return driver.findElement(By.xpath("//a[@href=\'#/samples\']"));
	}
	
	public static WebElement finishProductMainXpath() {
		return driver.findElement(By.xpath("//a[@href=\'#/finshproductsamples\']"));
	}
	
	public static WebElement incommingSampleXpath() {
		return driver.findElement(By.xpath("//div[@class='sc-htoDjs jApeNY']/div[1]/div[1]"));
	}
	
	public static WebElement inprocessSampleXpath() {
		return driver.findElement(By.xpath("//div[@class='sc-htoDjs jApeNY']/div[2]/div[1]"));
	}
	
	public static WebElement labTrialSampleXpath() { 
		return driver.findElement(By.xpath("//div[@class='sc-htoDjs jApeNY']/div[1]/div[1]"));
	}
	
	public static WebElement productionSampleXpath() {
		return driver.findElement(By.xpath("//div[@class='sc-htoDjs jApeNY']/div[2]/div[1]"));
	}
	
	
}
