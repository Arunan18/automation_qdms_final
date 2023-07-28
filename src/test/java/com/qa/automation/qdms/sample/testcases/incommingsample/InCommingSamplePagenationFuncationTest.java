//***********************************************************************************
//* Description
//*------------
//* InCommingSamplePagenationFuncationTest
//***********************************************************************************
//*
//* Author           : yogalingam kajenthiran
//* Date Written     : 25/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-PRODUCT-SAM-0019    24/04/2023     kajan     Original Version
//*						
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.commonmethods.SelectDate;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.material.CheckAddMaterialCancelButtonFunctionalityTest;

public class InCommingSamplePagenationFuncationTest extends DriverIntialization {
	
	@FindBy (xpath = "//li[@class='ant-pagination-prev']//span[@aria-label='left']//*[name()='svg']")
	public static WebElement previousbt;
	@FindBy (xpath = "//li[@class='ant-pagination-next']//span[@aria-label='right']//*[name()='svg']")
	public static WebElement nextbt;
	@FindBy (xpath = "//a[normalize-space()='2']")
	public static WebElement pag2nd;
	@FindBy (xpath = "//a[normalize-space()='1']")
	public static WebElement pag1st;
	@FindBy (xpath = "//span[@title='10 / page']")
	public static WebElement pagdrp;
	public static String bef="//*[@id=\\\"root\\\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/ul/li[9]/div/div[2]/div/div/div/div[2]/div/div/div/div[";
	public static String aft= "]/div";
	public static String com= "INCOMMING";
	
	
       @Test
	public static void inCommingPagination() throws InterruptedException, IOException {
    	  LoginTest.Login();
    	  Thread.sleep(3000);
    	  SampleNavigateTest.sampleNavigation();
    	  Thread.sleep(2000);
    	  SampleNavigateTest.rawMaterialSampleMainNavigation();
    	  Thread.sleep(2000);
    	  SampleNavigateTest.incommingSampleNavigation();
    	  Thread.sleep(2000);
		Paginationmethods.pagination("Samples Module (1)", "Incoming Sample", "TC-INC-SAM-0018", previousbt, nextbt, pag2nd, pag1st, pagdrp, bef, 4, aft, com);
		
	}
	
}
