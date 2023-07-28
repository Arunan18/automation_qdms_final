//***********************************************************************************
//* Description
//*------------
//* MIX DESIGN MAIN TESTS 
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 20/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*				           20/04/2023    WATHI     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.sample.commonmethods.SampleMultisearchMethods;

public class MixDesignMainTests extends DriverIntialization {

	static MixDesignPage mixdispage = new MixDesignPage();

//*****************************MULTIPLE SEARCH COMMON METHOD CALLIGN******************************

	public static void mixdesignmultiplesearch() throws IOException, InterruptedException {

		PageFactory.initElements(driver, mixdispage);

		// Plant

		SampleMultisearchMethods.multiSearch(MixDesignPage.plantSearchIcon, MixDesignPage.plantTextbox,
				MixDesignPage.PlantSearchButton, "Plant", "Samples Module", "Mix Design", "TC-MIX-DES-0015", 1, 2,
				MixDesignPage.plantColumn, MixDesignPage.plantColumnBefore, MixDesignPage.plantColumnAfter, true);

		// Finish product

		SampleMultisearchMethods.multiSearch(MixDesignPage.FinishproductSearchIcon, MixDesignPage.FinishproductTextbox,
				MixDesignPage.FinishproductSearchButton, "Finish Product", "Samples Module", "Mix Design",
				"TC-MIX-DES-0015", 3, 4, MixDesignPage.FinishproductColumn, MixDesignPage.finishProductColumnBefore,
				MixDesignPage.finishProductColumnAfter, true);

		// Mix Design / BOM / Composition

		SampleMultisearchMethods.multiSearch(MixDesignPage.MBCSearchIcon, MixDesignPage.MBCTextbox,
				MixDesignPage.MBCSearchButton, "Mix Design / BOM / Composition", "Samples Module", "Mix Design",
				"TC-MIX-DES-0015", 5, 6, MixDesignPage.MBCColumn, MixDesignPage.MBCColumnBefore,
				MixDesignPage.MBCColumnAfter, true);

		// Date
		
		SampleMultisearchMethods.multiSearch(MixDesignPage.dateSearchIcon, MixDesignPage.dateTextbox,
				MixDesignPage.dateSearchButton, "Date", "Samples Module", "Mix Design", "TC-MIX-DES-0015",7, 8, MixDesignPage.dateColumn,
				MixDesignPage.dateColumnBefore, MixDesignPage.dateColumnAfter, true);

		// Status
		
//		SampleMultisearchMethods.multiSearch(MixDesignPage.statusSearchIcon, MixDesignPage.statusTextbox,
//				MixDesignPage.statusSearchButton, "Status", "Samples Module", "Mix Design", "TC-MIX-DES-0015",9, 10, MixDesignPage.dateColumn,
//				MixDesignPage.statusColumnBefore, MixDesignPage.statusColumnAfter, true);
//		

		SampleMultisearchMethods.MultipleSearch("MIX DESIGN");
	}
	
	public static void pagiantion() throws InterruptedException, IOException
	{
	PageFactory.initElements(driver, mixdispage);
	
	
		Paginationmethods.pagination("Samples Module","Mix Design","TC-MIX-DES-0016",MixDesignPage.PreviousPageButton, MixDesignPage.NextPageButton, MixDesignPage.FirstPageButton,MixDesignPage.SecondPageButton, MixDesignPage.DownArrow,MixDesignPage.BeforePagination, 4, MixDesignPage.AfterPagination,"MIX DESIGN");
	}

}
