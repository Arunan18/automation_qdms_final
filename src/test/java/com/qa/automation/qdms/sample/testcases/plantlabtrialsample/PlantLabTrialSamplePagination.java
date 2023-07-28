package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class PlantLabTrialSamplePagination extends DriverIntialization {

	static PlantLabTrailSamplePage plantlabtrialpage = new PlantLabTrailSamplePage();

	@Test
	public static void PlantLabSamValidation() throws InterruptedException, IOException {

		PageFactory.initElements(driver, plantlabtrialpage);

		LoginTest.Login();

		SampleNavigateTest.sampleNavigation();

		SampleNavigateTest.finishProductSampleMainNavigation();

		SampleNavigateTest.labTrialSampleNavigation();

		Paginationmethods.pagination("Samples Module", "Plant Lab Trial Sample", "TC-P-LAB-SAM-0018",
				PlantLabTrailSamplePage.PreviousPageBtn, PlantLabTrailSamplePage.NextPageBtn,
				PlantLabTrailSamplePage.PaginationSecoundPage, PlantLabTrailSamplePage.PaginationFirstPage,
				PlantLabTrailSamplePage.Paginationdropdown, PlantLabTrailSamplePage.PageBefore, 4,
				PlantLabTrailSamplePage.PageAfter, "PLANT LAB TRIAL SAMPLE");

	}

}
