package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.testcases.inprocesssample.ProcessSampleMultiSearch;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProductionSampleMultiSearch extends DriverIntialization{
@Test
	public static void productionMultisearch() throws InterruptedException, IOException {
		ProcessSampleMultiSearch lk=new ProcessSampleMultiSearch();
		PageFactory.initElements(driver, lk);
		LoginTest.Login();
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.finishProductSampleMainNavigation();
		SampleNavigateTest.productionSampleNavigation();
		ProcessSampleMultiSearch.multiSearch("Samples Module.xlsx", "Production Sample", "TC-PRODUCT-SAM-0015-01",ProcessSampleMultiSearch.table,1);
		Logout.LogoutFunction();
	}
	
}
