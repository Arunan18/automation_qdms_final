////***********************************************************************************
////* Description
////*------------
////* Project Pagination Functionality 
////***********************************************************************************
////*
////* Author           : Priyanka Sundaramoorthy
////* Date Written     : 22/02/2023
////* 
////*
////* 
////* Test Case Number       Date         Intis        Comments
////* ================       ====         =====        ========
////* TC-PRO-0050            22/02/2023   Priyanka     Orginal Version
////*
////************************************************************************************
//
//package com.qa.automation.qdms.testcases.project;
//
//import java.io.IOException;
//
//import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.Test;
//
//import com.qa.automation.qdms.base.DriverIntialization;
//import com.qa.automation.qdms.commonmethods.Logout;
//import com.qa.automation.qdms.pages.master.ProjectPage;
//import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
//import com.qa.automation.qdms.testcases.login.LoginTest;
//import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
//
//public class ProjectPaginationTest extends DriverIntialization {
//
//	ProjectPage projectpage = new ProjectPage();
//
//	@Test(priority = 0)
//	public void ProjectPagination() throws InterruptedException, IOException {
//
//		LoginTest.Login();
//
//		if (LoginTest.login) {
//			MasterMainNavigationsTest.navigateMaster();
//		}
//
//		if (MasterMainNavigationsTest.clickMaster) {
//			MasterMainNavigationsTest.navigateCustomerMain();
//		}
//
//		if (MasterMainNavigationsTest.clickCustomermain) {
//
//			MasterMainNavigationsTest.navigateProject();
//
//		}
//
//		if (MasterMainNavigationsTest.clickProject) {
//
//			PageFactory.initElements(driver, projectpage);
//
//			Paginationmethods.pagination("Master Module", "Project", "TC-PRO-0050", ProjectPage.PreviousPageBtn,
//					ProjectPage.NextPageBtn, ProjectPage.PaginationSecoundPage, ProjectPage.DefaultPaginationPage,
//					ProjectPage.PageDropdown, ProjectPage.bef, 4, ProjectPage.aft, "PROJECT");
//
//		}
//
//		driver.navigate().refresh();
//
//		Logout.LogoutFunction();
//
//	}
//}
