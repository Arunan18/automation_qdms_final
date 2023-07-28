//***********************************************************************************
//* Description
//*------------
//* Select Key Test Production Sample - Process
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 10/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-P-LAB-SAM-0157   10/05/2023    Sayan     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class MoreOptionPlantLabTrialSample extends DriverIntialization {

	static PlantLabTrailSamplePage PlantLabTrailSamplePg = new PlantLabTrailSamplePage();

	static String sample = "";

	public static void moreView() throws InterruptedException, IOException {

		PageFactory.initElements(driver, PlantLabTrailSamplePg);

		LoginTest.Login();

		Thread.sleep(500);
		PlantLabTrailSamplePage.Sample.click();

		Thread.sleep(500);
		PlantLabTrailSamplePage.FinishProductTopbar.click();

		Thread.sleep(500);
		PlantLabTrailSamplePage.PlantLabTrialSample.click();

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Plant Lab Trial Sample");
		int rowcount = sheet.getLastRowNum();
		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx",
				"Plant Lab Trial Sample", "TC-P-LAB-SAM-0157");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx",
				"Plant Lab Trial Sample", "TC-P-LAB-SAM-0157");
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			sample = (String) row.getCell(1).getStringCellValue();
		}

		boolean nextBtn = PlantEquipmentPage.next.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_fourth;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);
			}
			boolean isExist = list.contains(sample);
			Thread.sleep(3000);
			nextBtn = PlantEquipmentPage.next.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				PlantEquipmentPage.next.click();
				Thread.sleep(3000);
			} else
				break;
		}

	}

}
