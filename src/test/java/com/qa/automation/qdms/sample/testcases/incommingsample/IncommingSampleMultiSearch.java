// Sayanthan


package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;

import com.qa.automation.qdms.sample.commonmethods.SampleMultisearchMethods;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class IncommingSampleMultiSearch extends DriverIntialization {
	
	static IncomingSamplePage InCommingSamplePg = new IncomingSamplePage();

	static WebElement CodeSearchIcon = null;
	static WebElement SupplierSearchIcon = null;
	static WebElement PlantSearchIcon = null;
	static WebElement RawMaterialSearchIcon = null;
	static WebElement SubCategorySearchIcon = null;
	static WebElement DateSearchIcon = null;
	static WebElement ArrivalDateSearchIcon = null;
	static WebElement SamplingDateSearchIcon = null;
	static WebElement VehicleNoSearchIcon = null;
	static WebElement SampleCodeSearchIcon = null;
	static WebElement SourceSearchIcon = null;
	static WebElement SampleTimeSearchIcon = null;
	static WebElement BL_LC_NoSearchIcon = null;
	static WebElement GRNSearchIcon = null;
	static WebElement QuantitySearchIcon = null;
	static WebElement StatusSearchIcon = null;

	static WebElement CodeTextBox = null;
	static WebElement SupplierTextBox = null;
	static WebElement PlantTextBox = null;
	static WebElement RawMaterialTextBox = null;
	static WebElement SubCategoryTextBox = null;
	static WebElement DateTextBox = null;
	static WebElement ArrivalDateTextBox = null;
	static WebElement SamplingDateTextBox = null;
	static WebElement VehicleNoTextBox = null;
	static WebElement SampleCodeTextBox = null;
	static WebElement SourceTextBox = null;
	static WebElement SampleTimeTextBox = null;
	static WebElement BL_LC_NoTextBox = null;
	static WebElement GRNTextBox = null;
	static WebElement QuantityTextBox = null;
	static WebElement StatusTextBox = null;

	static WebElement SearchButton = null;

	static String Code = null;
	static String Supplier = null;
	static String Plant = null;
	static String RawMaterial = null;
	static String SubCategory = null;
	static String Date = null;
	static String ArrivalDate = null;
	static String SamplingDate = null;
	static String VehicleNo = null;
	static String SampleCode = null;
	static String Source = null;
	static String SampleTime = null;
	static String BL_LC_No = null;
	static String GRN = null;
	static String Quantity = null;
	static String Status = null;
	
	static String codeBeforeSearch = null;

	static boolean codes = true;
	boolean CodeTableData = true;
	
	
@Test
	public static void incommingMultisearch() throws InterruptedException, IOException {
		PageFactory.initElements(driver, InCommingSamplePg);

//		Navigate to the Samples Page
//		------------------------------

		LoginTest.Login();

		Thread.sleep(500);
		SampleNavigationPage.sampleXpath();

		Thread.sleep(500);
		SampleNavigationPage.rawMaterialMainXpath();
        
		Thread.sleep(500);
		SampleNavigationPage.incommingSampleXpath();

//		Code
//		------

		SampleMultisearchMethods.multiSearch(IncomingSamplePage.CodeSearchIcon, IncomingSamplePage.CodeTextBox, IncomingSamplePage.SearchButton, "Code", "Samples Module",
				"Incoming Sample", "TC-INC-SAM-0017", 1, 2, IncomingSamplePage.codeColumn,
				codeBeforeSearch, IncomingSamplePage.codeAfterSearch, codes);

//		Supplier
//		---------

		SampleMultisearchMethods.multiSearch(IncomingSamplePage.SupplierSearchIcon, IncomingSamplePage.SupplierTextBox, IncomingSamplePage.SearchButton, "Supplier",
				"Samples Module", "Incoming Sample", "TC-INC-SAM-0017", 3, 4, IncomingSamplePage.SupplierColumn,
				IncomingSamplePage.SupplierBeforeSearch, IncomingSamplePage.SupplierAfterSearch, codes);

//		Plant
//		-------

		SampleMultisearchMethods.multiSearch(IncomingSamplePage.PlantSearchIcon, IncomingSamplePage.PlantTextBox, IncomingSamplePage.SearchButton, "Plant", "Samples Module",
				"Incoming Sample", "TC-INC-SAM-0017", 5, 6, IncomingSamplePage.PlantColumn,
				IncomingSamplePage.PlantBeforeSearch, IncomingSamplePage.PlantAfterSearch, codes);

//		Raw Material
//		--------------

		SampleMultisearchMethods.multiSearch(RawMaterialSearchIcon, RawMaterialTextBox, SearchButton, RawMaterial,
				"Samples Module", "Incoming Sample", "TC-INC-SAM-0017", 7, 8, IncomingSamplePage.RawMaterialColumn,
				IncomingSamplePage.RawMaterialBeforeSearch, IncomingSamplePage.RawMaterialAfterSearch, codes);

//		Sub Category
//		--------------

		SampleMultisearchMethods.multiSearch(SubCategorySearchIcon, SubCategoryTextBox, SearchButton, SubCategory,
				"Samples Module", "Incoming Sample", "TC-INC-SAM-0017", 9, 10, IncomingSamplePage.SubCategoryColumn,
				IncomingSamplePage.SubCategoryBeforeSearch, IncomingSamplePage.SubCategoryAfterSearch, codes);

//		Date
//		------

		SampleMultisearchMethods.multiSearch(DateSearchIcon, DateTextBox, SearchButton, Date, "Samples Module",
				"Incoming Sample", "TC-INC-SAM-0017", 11, 12, IncomingSamplePage.DateColumn,
				IncomingSamplePage.DateBeforeSearch, IncomingSamplePage.DateAfterSearch, codes);

//		Arrival Date
//		---------------

		SampleMultisearchMethods.multiSearch(ArrivalDateSearchIcon, ArrivalDateTextBox, SearchButton, ArrivalDate,
				"Samples Module", "Incoming Sample", "TC-INC-SAM-0017", 13, 14, IncomingSamplePage.ArrivalDateColumn,
				IncomingSamplePage.ArrivalDateBeforeSearch, IncomingSamplePage.ArrivalDateAfterSearch, codes);

//		Sampling Date
//		--------------

		SampleMultisearchMethods.multiSearch( SamplingDateSearchIcon, SamplingDateTextBox, SearchButton, SamplingDate,
				 "Samples Module","Incoming Sample","TC-INC-SAM-0017", 15, 16, IncomingSamplePage.SamplingDateColumn,
				IncomingSamplePage.SamplingDateBeforeSearch, IncomingSamplePage.SamplingDateAfterSearch, codes);

//		Vehicle No
//		------------

		SampleMultisearchMethods.multiSearch(VehicleNoSearchIcon, VehicleNoTextBox, SearchButton, VehicleNo,
				"Samples Module", "Incoming Sample", "TC-INC-SAM-0017", 17, 18, IncomingSamplePage.VehicleNoColumn,
				IncomingSamplePage.VehicleNoBeforeSearch, IncomingSamplePage.VehicleNoAfterSearch, codes);

//		Sample code
//		------------

		SampleMultisearchMethods.multiSearch(SampleCodeSearchIcon, SampleCodeTextBox, SearchButton, SampleCode,
				"Samples Module", "Incoming Sample", "TC-INC-SAM-0017", 19, 20, IncomingSamplePage.codeColumn,
				IncomingSamplePage.SampleCodeBeforeSearch, IncomingSamplePage.SampleCodeAfterSearch, codes);

//		Source
//		--------

		SampleMultisearchMethods.multiSearch(SourceSearchIcon, SourceTextBox, SearchButton, Source, "Samples Module",
				"Incoming Sample", "TC-INC-SAM-0017", 21, 22, IncomingSamplePage.SourceColumn,
				IncomingSamplePage.SourceBeforeSearch, IncomingSamplePage.SourceAfterSearch, codes);

//		Sample Time
//		-------------

		SampleMultisearchMethods.multiSearch(SampleTimeSearchIcon, SampleTimeTextBox, SearchButton, SampleTime,
				"Samples Module", "Incoming Sample", "TC-INC-SAM-0017", 23, 24, IncomingSamplePage.SampleTimeColumn,
				IncomingSamplePage.SampleTimeBeforeSearch, IncomingSamplePage.SampleTimeAfterSearch, codes);

//		BL/LC No
//		----------

		SampleMultisearchMethods.multiSearch(BL_LC_NoSearchIcon, BL_LC_NoTextBox, SearchButton, BL_LC_No,
				"Samples Module", "Incoming Sample", "TC-INC-SAM-0017", 25, 26, IncomingSamplePage.codeColumn,
				IncomingSamplePage.BL_LC_NoBeforeSearch, IncomingSamplePage.BL_LC_NoAfterSearch, codes);

//		GRN
//		-----

		SampleMultisearchMethods.multiSearch(IncomingSamplePage.GRNSearchIcon, IncomingSamplePage.GRNTextBox, IncomingSamplePage.SearchButton, GRN, "Samples Module",
				"Incoming Sample", "TC-INC-SAM-0017", 27, 28, IncomingSamplePage.GRNColumn,
				IncomingSamplePage.GRNBeforeSearch, IncomingSamplePage.GRNAfterSearch, codes);

//		Quantity
//		-----------

		SampleMultisearchMethods.multiSearch(IncomingSamplePage.QuantitySearchIcon, IncomingSamplePage.QuantityTextBox, IncomingSamplePage.SearchButton, Quantity,
				"Samples Module", "Incoming Sample", "TC-INC-SAM-0017", 29, 30, IncomingSamplePage.QuantityColumn,
				IncomingSamplePage.QuantityBeforeSearch, IncomingSamplePage.QuantityAfterSearch, codes);

//		Status
//		-------

		SampleMultisearchMethods.multiSearch(IncomingSamplePage.StatusSearchIcon, IncomingSamplePage.StatusTextBox, IncomingSamplePage.SearchButton, Status, "Samples Module",
				"Incoming Sample", "TC-INC-SAM-0017", 31, 32, IncomingSamplePage.StatusColumn,
				IncomingSamplePage.StatusBeforeSearch, IncomingSamplePage.StatusAfterSearch, codes);

		SampleMultisearchMethods.MultipleSearch("CODE");
		
		MultiSearchMethods.Logout();

	}

}
