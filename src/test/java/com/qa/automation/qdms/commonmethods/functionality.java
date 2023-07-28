
/***********************************************************************************************************
 * 	SOME COMMAN METHODS FOR MY ALLOCATED TASKS
 *----------------------------------------------------------------------------------------------------------
 * @author Jathu Jana
 ***********************************************************************************************************/

package com.qa.automation.qdms.commonmethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;

public class functionality extends DriverIntialization {
	static WebDriverWait waiting = new WebDriverWait(driver, 10);
	public static boolean popUpModelOpen;
	public static boolean innerpopUpOpen;
	public static boolean clickCancelOrCloseStatus;
	public static boolean Clicking = false;
	public static boolean searching = false;
	public static int rowCount;
	public static String rowNumberAsString;
	public static boolean selectData= false;
	public static boolean compareData = false;
	public static String actualResult = null;
	public static boolean ability = false ;
	public static boolean Inablity = false;
	public static boolean nopage = false;
	public static boolean pageSelect = false;
	public static boolean page = false;
	public static boolean tablePage = false;
	// METHOD ~ (1)[Button & Icon Functionality]
	/**
	 * 
	 * @param TestCaseName
	 * @param finderKey
	 * @param element
	 */
	public static void ButtonAndIconunctionalityMtd(String TestCaseName, WebElement finderKey, String element) {
		boolean status = false;
		try {

			finderKey.isDisplayed();
			finderKey.isEnabled();
			status = true;

		} catch (Exception e) {
			status = false;
		}

		if (status) {

			boolean isVisible = finderKey.isDisplayed();
			boolean isEnable = finderKey.isEnabled();
			ExtentTest testCase = extent.createTest(TestCaseName);

			// CHECKING BUTTON VISIBILITY &
			// ENABILITY.........................................
			if (isVisible) {
				testCase = extent.createTest("[1]" + element + " IS VISIBLE. ");
				testCase.log(Status.INFO, "Define Test   : Button visibility.");
				testCase.log(Status.INFO, "Actual value  : " + isVisible);
				testCase.log(Status.PASS, "TEST PASS ☑");

				// AS BUTTON VISIBLE...CHECK ENABLE...........................................
				if (isEnable) {
					// BUTTON ALSO ENABLE.....................................................
					testCase = extent.createTest("[2]" + element + " IS ENABLE. ");
					testCase.log(Status.INFO, "Define Test   : Button enability.");
					testCase.log(Status.INFO, "Actual value  : " + isEnable);
					testCase.log(Status.PASS, "TEST PASS ☑");
					
					ability  = true;

				} else {
					// BUTTON VISIBLE BUT INABLE...............................................
					testCase = extent.createTest("[2]" + element + " IS INABLE.");
					testCase.log(Status.INFO, "Define Test   : Button enablity.");
					testCase.log(Status.INFO, "Actual value  : " + isEnable);
					testCase.log(Status.FAIL, "TEST FAIL❌");

				}
			} else {
				// BUTTON INVISIBLE & INABLE..............................................
				testCase = extent.createTest("#" + element + " IS INVISIBLE. ");
				testCase.log(Status.INFO, "Define Test   : Button visibility.");
				testCase.log(Status.INFO, "Actual value  : " + isVisible);
				testCase.log(Status.FAIL, "TEST FAIL ❌ !.....THE FUNCTON NOT WORK. CHECKING TERMITATED⚠️");
			}
		}
	}

	// METHOD ~ (2)[Method for Search TextBox]
	/**
	 * 
	 * @param TestCaseName
	 * @param finderKey
	 * @param heading_finder
	 * @param name
	 */
	public static void defaultSelection(String TestCaseName, WebElement finderKey, WebElement heading_finder,
			String name) {
		boolean status = false;
		try {

			finderKey.isDisplayed();
			finderKey.isEnabled();
			status = true;

		} catch (Exception e) {
			status = false;
			testCase = extent.createTest("➢ WEB ELEMENT EXCEPTION 🛑");
			testCase.log(Status.INFO, "THE FUNCTON NOT WORK. FUNCTIONALITY CHECKING TERMITATED⚠️");
		}

		if (status) {

			boolean isVisible = finderKey.isDisplayed();
			boolean isEnable = finderKey.isEnabled();
			String actualHeading = heading_finder.getText();
			ExtentTest testCase = extent.createTest(TestCaseName);

			// CHECKING BUTTON VISIBILITY &
			// ENABILITY.........................................
			if (isVisible) {
				testCase = extent.createTest("[1]'" + name + "' BUTTON IS VISIBLE.");
				testCase.log(Status.INFO, "Define Test   : Button visibility.");
				testCase.log(Status.INFO, "Actual value  : " + isVisible);
				testCase.log(Status.PASS, "TEST PASS ☑");

				// AS BUTTON VISIBLE...CHECK ENABLE...........................................
				if (isEnable) {
					testCase = extent.createTest("[2]'" + name + "' BUTTON IS ENABLE. ");
					testCase.log(Status.INFO, "Define Test   : Button enability.");
					testCase.log(Status.INFO, "Actual value  : " + isEnable);
					testCase.log(Status.PASS, "TEST PASS ☑");

					// BUTTON VISIBLE & ENABLE....CHECK NAVIGATION
					try {
						// IF NAVIGATION SUCCESS
						AssertJUnit.assertEquals(actualHeading, name);
						testCase = extent.createTest("[3] EXPECTED WINDOW VISIBLE.");
						testCase.log(Status.INFO, "Actual value  : " + actualHeading);
						testCase.log(Status.INFO, "Expected value: " + name);
						testCase.log(Status.PASS, "TEST PASS ☑");
					} catch (AssertionError e) {
						// NAVIGATION UNSUCCESS
						testCase = extent.createTest("[3] EXPECTED PAGE IS NOT VISIBLE.");
						testCase.log(Status.INFO, "Actual value  : " + actualHeading);
						testCase.log(Status.INFO, "Expected value: " + name);
						testCase.log(Status.FAIL, "TEST FAIL❌");
					}
				}
				// BUTTON INVISIBLE & INABLE
				else {
					testCase = extent.createTest("[2]'" + name + "' BUTTON IS INABLE.");
					testCase.log(Status.INFO, "Define Test   : Button enablity.");
					testCase.log(Status.INFO, "Actual value  : " + isEnable);
					testCase.log(Status.FAIL, "TEST FAIL❌");

				}
			}
			// BUTTON INVISIBLE, INABLE &
			// UNSELECTABLE..............................................
			else {
				testCase = extent.createTest("# '" + name + "' BUTTON IS INVISIBLE.");
				testCase.log(Status.INFO, "Define Test   : Button visibility.");
				testCase.log(Status.INFO, "Actual value  : " + isVisible);
				testCase.log(Status.FAIL, "TEST FAIL ❌!.....THE BUTTON UNSELECTABLE. CHECKING TERMITATED⚠️");
			}
		}
	}

	// METHOD ~ (3)[Method for Search TextBox - Low Test Case]

	/**
	 * 
	 * @param TestCaseName
	 * @param finderKey
	 * @param searchInput
	 */
	public static void searchBoxFunctionalityMtd(String TestCaseName, WebElement finderKey, String searchInput) {
		boolean status = false;
		try {

			finderKey.isDisplayed();
			finderKey.isEnabled();
			status = true;

		} catch (Exception e) {
			status = false;
			testCase = extent.createTest("➢ WEB ELEMENT EXCEPTION 🛑");
			testCase.log(Status.INFO, "THE FUNCTON NOT WORK. FUNCTIONALITY CHECKING TERMITATED⚠️");
		}

		if (status) {

			boolean isVisible = finderKey.isDisplayed();
			boolean isEnable = finderKey.isEnabled();
			ExtentTest testCase = extent.createTest(TestCaseName);

			// SEARCH TEXT BOX VISIBILITY &
			// ENABILITY.........................................
			if (isVisible) {
				testCase = extent.createTest("[1]SEARCH BOX IS VISIBLE.");
				testCase.log(Status.INFO, "Define Test   : Search box  visibility.");
				testCase.log(Status.INFO, "Actual value  : " + isVisible);
				testCase.log(Status.PASS, "TEST PASS ☑");
				if (isEnable) {
					// AS TEXT BOX VISIBLE...CHECK ENABLE...........................................
					testCase = extent.createTest("[2]SEARCH BOX IS ENABLE.");
					testCase.log(Status.INFO, "Define Test   : Search box enability.");
					testCase.log(Status.INFO, "Actual value  : " + isEnable);
					testCase.log(Status.PASS, "TEST PASS ☑");

					// BUTTON VISIBLE & ENABLE....CHECK ITEM SEARCHING
					try {
						finderKey.click();// CLICK THE SEARCH TEXT BOX
						finderKey.sendKeys(searchInput);// TYPE THE SEARCHING TERM IN THE BOX
						testCase = extent.createTest("[3]GET THE SEARCHING TERM.");
						testCase.log(Status.INFO, "Define Test   : Type Something");
						testCase.log(Status.INFO, "I got search item");
						testCase.log(Status.PASS, "TEST PASS ☑");
					}

					catch (Exception e) {

						testCase = extent.createTest("[3]GET THE SEARCHING TERM.");
						testCase.log(Status.INFO, "Define Test   : Type Something");
						testCase.log(Status.INFO, "I didn't get search item");
						testCase.log(Status.FAIL, "TEST FAIL❌`W");
					}
				}

				else {
					testCase = extent.createTest("#SEARCH BOX INVISIBLE.");
					testCase.log(Status.INFO, "Define Test   : Search box  enability.");
					testCase.log(Status.INFO, "Actual value  : " + isEnable);
					testCase.log(Status.FAIL, "TEST FAIL❌");
				}
			}
			// SEARCH TEXT BOX INVISIBLE &
			// INABLE..............................................
			else {

				testCase = extent.createTest("#SEARCH BOX INVISIBLE.");
				testCase.log(Status.INFO, "Define Test   : Search box  visibility.");
				testCase.log(Status.INFO, "Actual value  : " + isVisible);
				testCase.log(Status.FAIL, "TEST FAIL ❌!.....CAN NOT SEARCH ANYTHING. CHECKING TERMITATED⚠️");
			}
		}
	}

	// METHOD ~ (4)[Method for Checking Function with sendkeys]
	/*****************************************************************************************************************************
	 * @author Jathu Jana
	 * @category Checking Functionality with Send Keys
	 * @param TestCaseName
	 * @param finderKey
	 * @param element
	 * @param input
	 ****************************************************************************************************************************/
	public static void funtionCheckAndSendKeys(String TestCaseName, WebElement finderKey, String element,
			String input) {

		waiting.until(ExpectedConditions.elementToBeClickable(finderKey));
	
		boolean status = false;
		try {

			finderKey.isDisplayed();
			finderKey.isEnabled();
			status = true;

		} catch (Exception e) {
			status = false;
			testCase = extent.createTest("➢ WEB ELEMENT EXCEPTION 🛑");
			testCase.log(Status.INFO, "THE FUNCTON NOT WORK. FUNCTIONALITY CHECKING TERMITATED⚠️");
		}
		if (status) {

			boolean isVisible = finderKey.isDisplayed();
			boolean isEnable = finderKey.isEnabled();
			ExtentTest testCase = extent.createTest(TestCaseName);

			// CHECKING BUTTON VISIBILITY &
			// ENABILITY.........................................
			if (isVisible) {
				testCase = extent.createTest("[1]" + element + " Visibility. ");
				testCase.log(Status.INFO, "Define Test   :  is visible.");
				testCase.log(Status.INFO, "Actual value  : " + isVisible);
				testCase.log(Status.PASS, "TEST PASS ☑");

				// AS BUTTON VISIBLE...CHECK ENABLE...........................................
				if (isEnable) {
					// BUTTON ALSO ENABLE.....................................................
					testCase = extent.createTest("[2]" + element + " Enability. ");
					testCase.log(Status.INFO, "Define Test   :  is enable.");
					testCase.log(Status.INFO, "Actual value  : " + isEnable);
					testCase.log(Status.PASS, "TEST PASS ☑");
					
					try {
						
						finderKey.sendKeys(Keys.CONTROL+"A",Keys.DELETE);
						finderKey.sendKeys(input);
						searching = true;
						
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else {
					// BUTTON VISIBLE BUT INABLE...............................................
					testCase = extent.createTest("[2]" + element + " Enability. ");
					testCase.log(Status.INFO, "Define Test   : Button enablity.");
					testCase.log(Status.INFO, "Actual value  : " + isEnable);
					testCase.log(Status.FAIL, "TEST FAIL❌");
				}
			} else {
				// BUTTON INVISIBLE & INABLE..............................................
				testCase = extent.createTest("[1]" + element + " Visibility. ");
				testCase.log(Status.INFO, "Define Test   : Button visibility.");
				testCase.log(Status.INFO, "Actual value  : " + isVisible);
				testCase.log(Status.FAIL, "TEST FAIL ❌ !.....THE FUNCTON NOT WORK. CHECKING TERMITATED⚠️");
			}
		}
	}

	// METHOD ~ (5)[Checking Functinality with Click]
	/*******************************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category Checking Function with Click
	 * @param TestCaseName
	 * @param finderKey
	 * @param element
	 * @throws InterruptedException
	 *******************************************************************************************************************************************************/

	public static void FunctionCheckWithClick(String TestCaseName, WebElement finderKey, String element)
			throws InterruptedException {

		boolean status = false;
		try {

			finderKey.isDisplayed();
			finderKey.isEnabled();
			status = true;

		} catch (Exception e) {
			status = false;
			testCase = extent.createTest("➢ WEB ELEMENT EXCEPTION 🛑");
			testCase.log(Status.INFO, "THE FUNCTON NOT WORK. FUNCTIONALITY CHECKING TERMITATED⚠️");
		}
		if (status) {

			boolean isVisible = finderKey.isDisplayed();
			boolean isEnable = finderKey.isEnabled();
			ExtentTest testCase = extent.createTest(TestCaseName);

			// CHECKING BUTTON VISIBILITY &
			// ENABILITY.........................................
			if (isVisible) {
				testCase = extent.createTest("[1]" + element + " Visibility. ");
				testCase.log(Status.INFO, "Define Test   :" + element + " visible.");
				testCase.log(Status.INFO, "Actual value  : " + isVisible);
				testCase.log(Status.PASS, "TEST PASS ☑");

				// AS BUTTON VISIBLE...CHECK ENABLE...........................................
				if (isEnable) {
					// BUTTON ALSO ENABLE.....................................................
					testCase = extent.createTest("[2]" + element + " Enability. ");
					testCase.log(Status.INFO, "Define Test   : " + element + " enable.");
					testCase.log(Status.INFO, "Actual value  : " + isEnable);
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						waiting.until(ExpectedConditions.elementToBeClickable(finderKey));

						Thread.sleep(3000);
						finderKey.click();
						testCase = extent.createTest("[3]" + element + " Clickable. ");
						testCase.log(Status.INFO, "Define Test   : " + element + " clicked.");
						testCase.log(Status.PASS, "TEST PASS ☑");
						Clicking = true;

					}catch (NoSuchElementException e) {
						
						testCase = extent.createTest("[3]" + element + " Clickable. ");
						testCase.log(Status.INFO, "No SuchElement Exception !" );
						testCase.log(Status.FAIL, "TEST FAIL❌");
						
					}catch (ElementClickInterceptedException e) {
						
						testCase = extent.createTest("[3]" + element + " Clickable. ");
						testCase.log(Status.INFO, "Element Click Intercepted Exception !" );
						testCase.log(Status.FAIL, "TEST FAIL❌");
						
					}catch (Exception e) {

						testCase = extent.createTest("[3]" + element + " Clickable. ");
						testCase.log(Status.INFO, "Define Test   : " + element + " not clicked.");
						testCase.log(Status.FAIL, "TEST FAIL❌");
					}

				} else {
					// BUTTON VISIBLE BUT INABLE...............................................
					testCase = extent.createTest("[2]" + element + " Enability.");
					testCase.log(Status.INFO, "Define Test   : " + element + " enablity.");
					testCase.log(Status.INFO, "Actual value  : " + isEnable);
					testCase.log(Status.FAIL, "TEST FAIL❌");

				}
			} else {
				// BUTTON INVISIBLE & INABLE..............................................
				testCase = extent.createTest("#" + element + " Visibility. ");
				testCase.log(Status.INFO, "Define Test   :" + element + " visibility.");
				testCase.log(Status.INFO, "Actual value  : " + isVisible);
				testCase.log(Status.FAIL, "TEST FAIL ❌ !.....THE FUNCTON NOT WORK. CHECKING TERMITATED⚠️");

			}

		}

	}

	// METHOD ~ (6)[Checking Navigation page using Text]
	/**********************************************************************************************************************
	 * @author Jathu Jana
	 * @category Navigation Test
	 * @param Xpath
	 * @param ExpectText
	 ***********************************************************************************************************************/

	public static void NavigateAndComparePage(WebElement finder, String ExpectText) {

		try {
			String actualNavigatePageText = finder.getText();
			System.out.println(actualNavigatePageText + "<---------------Actual Value");

			if (actualNavigatePageText.equals(ExpectText)) {
				Assert.assertEquals(actualNavigatePageText, ExpectText);
				testCase = extent.createTest("➢ Got Expect Window. Successfully .");
				testCase.log(Status.INFO, "Actual Text :" + actualNavigatePageText);
				testCase.log(Status.INFO, "Expect Text :" + ExpectText);
				testCase.log(Status.PASS, "TEST PASS ☑");

			} else {

				testCase = extent.createTest("➢Did n't get Expect Window🛑 ");
				testCase.log(Status.INFO, "Actual Text :" + actualNavigatePageText);
				testCase.log(Status.INFO, "Expect Text :" + ExpectText);
				testCase.log(Status.FAIL, "TEST FAIL ❌");
			}
		} catch (Exception e) {
			System.out.println("➢ Perticular Window not identified.......🛑");
			testCase = extent.createTest("Window Identification.");
			testCase.log(Status.FAIL, "TEST FAIL ❌ !.....NAVIGATION FAILED . CHECKING TERMITATED⚠️");
		}

	}

	// METHOD ~ (7)[Checking Navigation using URL]
	/***************************************************************************************************************
	 * @author Jathu Jana
	 * @category Check Navigation And Get URL
	 * @param TestCaseName
	 * @param ExcpectResult
	 * @param ActualResult
	 **************************************************************************************************************/
	public static void navigateAndCompareWithPage(String TestCaseName, String TestCaseNameAboutWindow,
			WebElement finderKey, String element, String ExcpectResult) {

		boolean status = false;
		try {

			finderKey.isDisplayed();
			finderKey.isEnabled();
			status = true;

		} catch (Exception e) {

			status = false;
			testCase = extent.createTest("➢ WEB ELEMENT EXCEPTION 🛑");
			testCase.log(Status.INFO, "CAN'T REACH THAT PARTICULAR PAGE⚠️");
			
		}
		if (status) {
			try {

				FunctionCheckWithClick(TestCaseName, finderKey, element);
				testCase = extent.createTest(TestCaseName);
				testCase.log(Status.INFO, element + " clicked.");
				testCase.log(Status.PASS, "TEST PASS ☑");

				Thread.sleep(3000);
				String ActualResult = driver.getCurrentUrl();
				System.out.println("Actual URL is [" + ActualResult + "]");

				if (ActualResult.equals(ExcpectResult)) {

					testCase = extent.createTest("#" + TestCaseNameAboutWindow + ". Got Expect Window. Successfully .");
					testCase.log(Status.INFO, "Actual Text :" + ActualResult);
					testCase.log(Status.INFO, "Expect Text :" + ExcpectResult);
					testCase.log(Status.PASS, "TEST PASS ☑");

				}

				else {
					testCase = extent.createTest("#" +
							TestCaseNameAboutWindow + ". Did n't get expect window");
					testCase.log(Status.INFO, "Actual Text :" + ActualResult);
					testCase.log(Status.INFO, "Expect Text :" + ExcpectResult);
					testCase.log(Status.FAIL, "TEST FAIL ❌.......Expected window does n't match");
				}
			} catch (Exception e) {
				testCase = extent.createTest(TestCaseName);
				testCase.log(Status.INFO, element + " not clicked.");
				testCase.log(Status.FAIL, "TEST FAIL ❌..........Couldn't get expect window.");
			}

		}
	}

	// METHOD ~ (8)[Checking Comparation]->1
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category THE METHOD FOR COMPARE DATA
	 * @param TestCase     Description
	 * @param actualData
	 * @param expectedData
	 ******************************************************************************************************************************************/
	public static void compareData(String TestCase, String actualData, String expectedData) {

		boolean status = true;
		testCase = extent.createTest(TestCase);
		try {

			AssertJUnit.assertEquals(actualData, expectedData);

		} catch (AssertionError e) {
			status = false;

		}
		if (status) {
			testCase.log(Status.INFO, "Actual Data :- " + actualData);
			testCase.log(Status.INFO, "Expected Data :- " + expectedData);
			testCase.log(Status.PASS, "TEST PASS ☑");
			compareData  = true ;
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualData);
			testCase.log(Status.INFO, "Expected Data :- " + expectedData);
			testCase.log(Status.FAIL, "TEST FAIL ❌");
		}
	}

//	Method (8) -[Checking Comparation]->2
	/**
	 *@author Jathu Jana
	 * @category THE METHOD FOR COMPARE DATA
	 * @param TestCase
	 * @param actualTextFinder
	 * @param expectedData
	 */
	public static void compareData(String TestCase, WebElement actualTextFinder , String expectedData) {

		boolean status = true;
		String actualData =null;
		testCase = extent.createTest(TestCase);

		try {
			
			actualData = actualTextFinder.getText();
				
			try {

				AssertJUnit.assertEquals(actualData, expectedData);

			} catch (AssertionError e) {
				status = false;

			}
			if (status) {
				testCase.log(Status.INFO, "Actual Data :- " + actualData);
				testCase.log(Status.INFO, "Expected Data :- " + expectedData);
				testCase.log(Status.PASS, "TEST PASS ☑");
				compareData  = true ;
			} else {
				testCase.log(Status.INFO, "Actual Data :- " + actualData);
				testCase.log(Status.INFO, "Expected Data :- " + expectedData);
				testCase.log(Status.FAIL, "TEST FAIL ❌");
			}
			
		} catch (Exception e) {

			testCase.log(Status.INFO, "🛑 Couldn't Get Actual Text!");
			testCase.log(Status.FAIL, "TEST FAIL ❌");
		
		}
		
	}
	// METHOD ~ (9)[Print Pass Report]
	public static void printPassStatus(String TestCase, String Info) {

		testCase = extent.createTest(TestCase);
		testCase.log(Status.INFO, Info);
		testCase.log(Status.PASS, "TEST PASS ☑");

	}

	// METHOD ~ (10)[Print Fail Report]
	public static void printFailStatus(String TestCase, String Info) {

		testCase = extent.createTest(TestCase);
		testCase.log(Status.INFO, Info);
		testCase.log(Status.FAIL, "TEST FAIL ❌");

	}
	// METHOD ~ (10)[Print Fail Report]
		public static void printStatus(String TestCase, String Info) {

			testCase = extent.createTest(TestCase);
			testCase.log(Status.INFO, Info);
			testCase.log(Status.INFO, "TEST !!!!!!!!!!!!!!! ⚠️");

		}

	// METHOD ~ (11)--> USING (12)&(13)
	/*****************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR CANCEL / CLOSE BUTTON FUNCTIONALITY WITH POPUP CLOSING
	 *           STATUS
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void checkingCancelOrCloseFunctionanlity(String TestCaseDescription, WebElement button,
			WebElement popUp) throws InterruptedException {

		cancelOrCloseButtonClick(button);
		Thread.sleep(2500);

		if (functionality.Clicking) {

			// POPUP VISIBLE CHECKING FOR CLOSE
			popUpVisibleCheck(TestCaseDescription, popUp);

		}

	}

	// METHOD ~ (12)
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR CANCEL / CLOSE BUTTON CLICKING (WITH FUNCTIONALITY
	 *           CHECKING)
	 * @throws InterruptedException
	 ******************************************************************************************************************************************/
	public static void cancelOrCloseButtonClick(WebElement button) throws InterruptedException {

		// CLICK ADD DESIGNATION CANCEL BUTTON WITH FUNCTION CHECKING
		functionality.FunctionCheckWithClick("➢ Checking That Button Functionality ", button, "Button");

	}

	// METHOD ~ (13) ---> USING (9),(10)
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category THE METHOD FOR - ANY POPUP VISIBILITY CHECKING (USING POSIBILITY
	 *           FOR CLOSE )
	 * @param TestCaseDescription
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/

	public static void popUpVisibleCheck(String TestCaseDescription, WebElement popUp) throws InterruptedException {

		boolean status = false;
		try {

			// POPUP MODEL VISIBILITY CHECKING
			popUpModelOpen = popUp.isDisplayed();
			status = true;

		} catch (Exception e) {

		}

		if (status) {

			// IF POPUP CLOSE
			printPassStatus(TestCaseDescription, "PopUp Closed");

		} else {

			// IF POPUP NOT CLOSE
			printFailStatus(TestCaseDescription, "PopUp Not Closed 🛑");

		}

	}

	/*************************************************************************************************************************
	 * @author Kajan Yoga
	 * @category THE METHOD FOR BUTTON / ICON FUNCTION FOR PASS INABLE
	 * @param TestCaseName
	 * @param finderKey
	 * @param element
	 *************************************************************************************************************************/
	public static void ButtonAndIconFunctionalityPassInable(String TestCaseName, WebElement finderKey, String element) {
		
		boolean status = false;
		try {

			finderKey.isDisplayed();
			finderKey.isEnabled();
			status = true;

		} catch (Exception e) {
			
			status = false;
			
		}
		
		if (status) {

			boolean isVisible = finderKey.isDisplayed();
			boolean isEnable = finderKey.isEnabled();
			ExtentTest testCase = extent.createTest(TestCaseName);

			// CHECKING BUTTON VISIBILITY &
			// ENABILITY.........................................
			if (isVisible) {
				testCase = extent.createTest("[1]" + element + " IS VISIBLE. ");
				testCase.log(Status.INFO, "Define Test   : Button visibility.");
				testCase.log(Status.INFO, "Actual value  : " + isVisible);
				testCase.log(Status.PASS, "TEST PASS ☑");

				// AS BUTTON VISIBLE...CHECK ENABLE...........................................
				if (!isEnable) {
					// BUTTON ALSO ENABLE.....................................................
					testCase = extent.createTest("[2]" + element + " IS INABLE. ");
					testCase.log(Status.INFO, "Define Test   : Button enability.");
					testCase.log(Status.INFO, "Actual value  : " + isEnable);
					testCase.log(Status.PASS, "TEST PASS ☑");
					Inablity  = true;

				} else {
					// BUTTON VISIBLE BUT INABLE...............................................
					testCase = extent.createTest("[2]" + element + " IS ENABLE.");
					testCase.log(Status.INFO, "Define Test   : Button enablity.");
					testCase.log(Status.INFO, "Actual value  : " + isEnable);
					testCase.log(Status.FAIL, "TEST FAIL❌");

				}
			} else {
				// BUTTON INVISIBLE & INABLE..............................................
				testCase = extent.createTest("#" + element + " IS INVISIBLE. ");
				testCase.log(Status.INFO, "Define Test   : Button visibility.");
				testCase.log(Status.INFO, "Actual value  : " + isVisible);
				testCase.log(Status.FAIL, "TEST FAIL ❌ !.....THE FUNCTON NOT WORK. CHECKING TERMITATED⚠️");
			}
		}
	}
		//METHOD ~ (14) 
		/**********************************************************************************************************************************************************************
		 * @category TABLE ROW COUNT USING TEXT
		 * @param searchDataColumnNo
		 * @param searchInput
		 * @param expectRowCount
		 **********************************************************************************************************************************************************************/
		public static void rowCountMethodWithText(String searchDataColumnNo, String searchInput,String expectRowCount) {
			
			rowCount=0;
		
	    	boolean nextButtonStatus = true;
			while (nextButtonStatus) {
	            try {
	            	
	            	Thread.sleep(1000);
	            	WebElement NextButton = driver.findElement(By.xpath("//li[@title='Next Page']//button"));
	            	nextButtonStatus = NextButton.isEnabled();
					
				} catch (Exception e) {
					
					nextButtonStatus=false;
				}
	            
//	          CALL TABLE ROW COUNT METHOD
	    		try {
	            	
//	            	Finding number of Rows
	            	List<WebElement> rows = driver.findElements(By.xpath("//table//tr/td["+searchDataColumnNo+"]"));
	            	
	            	for (WebElement searchRow : rows) {
	            		System.out.println(searchRow.getText()+"-"+searchRow.getText().contains(searchInput)+"");

	            		if (searchRow.getText().contains(searchInput)) {
	            			
	    					rowCount++;
	    					
	    				}       		
	    			}
	            	rowNumberAsString = String.valueOf(rowCount);
	            	System.out.println("*Rows of Searching Data : "+rowNumberAsString );
	            	
	    		} catch (Exception e) {
	    		}
	            
	            if(nextButtonStatus)  {
	            	
//	            	CLICK PAGINATION NEXT BUTTON 
	            	driver.findElement(By.xpath("//li[@title='Next Page']//button")).click();
	            	
	        	}
	            else{
	            	continue;
				}
			}
			
//			DATA COMPARATION
			compareData("➢ Checking Searching Data Identification", rowNumberAsString, expectRowCount);
		
		}	
		
		//METHOD ~ (15) 
		/*********************************************************************************************************************************************************************
		 * @category TABLE ROW COUNT
		 * @param searchDataColumnNo
		 * @param uncountRow
		 * @param expectRowCount
		 * @throws InterruptedException
		 *********************************************************************************************************************************************************************/
		public static void tableRowCountMethod(String searchDataColumnNo,int uncountRow,String expectRowCount) throws InterruptedException {
			
			rowCount=0;
			
			boolean nextButtonStatus = true;
			while (nextButtonStatus) {
	           
				try {
	            	
	            	WebElement NextButton = driver.findElement(By.xpath("//li[@title='Next Page']//button"));
	            	waiting.until(ExpectedConditions.elementToBeClickable(NextButton));
	            	nextButtonStatus = NextButton.isEnabled();
					
				} catch (Exception e) {
					
					nextButtonStatus=false;
				}
	            
	        	try {
	            	
//	            	FINDING NO OF ROWS
	            	List<WebElement> rows = driver.findElements(By.xpath("//table//tr/td["+searchDataColumnNo+"]"));
	            	rowCount = rows.size()-uncountRow +rowCount;
	            	
	            		if (!rows.isEmpty()) {
	            			
	    					rowCount++;
	    					
	    				}
	            		else {
	    	        		
	    				}	
	    			     		
	            	rowNumberAsString = String.valueOf(rowCount);
	            	System.out.println("# No of Rows Every Single Page : "+rowNumberAsString );
	            	
	    		} catch (Exception e) {
	    		}
	            
	            if(nextButtonStatus)  {
	            	
//	            	CLICK PAGINATION NEXT BUTTON 
	            	driver.findElement(By.xpath("//li[@title='Next Page']//button")).click();
	            	
	        	}else{
	        		
	            	continue;
	            	
				}
			}
			
//			DATA COMPARATION
			compareData("➢ Checking Table Data Count", rowNumberAsString, expectRowCount);
			
//			REFRESH
			driver.navigate().refresh();
			Thread.sleep(1500);

	}

	// METHOD ~ (16) ---> USING (14)
	/********************************************************************************************************************************************************************************
	 * @category METHOD FOR SEARCH FUNCTIONALITY METHOD IN TABLE
	 * @param searchDataColumnNo
	 * @param TestCaseName
	 * @param finderKey
	 * @param searchInput
	 * @throws InterruptedException
	 *******************************************************************************************************************************************************************************/
	public static void searchFunctionality(String searchDataColumnNo, String searchInput, String expectRowCount)
			throws InterruptedException {

		WebElement searchIcon = null;
		try {

			// CLICK SERACH ICON WITH FUNCTION CHECKING
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			searchIcon = driver
					.findElement(By.xpath("//table//thead//th[" + searchDataColumnNo + "]/div//span[@role='button']"));
			FunctionCheckWithClick("➢ Checking Search Icon Functionality", searchIcon, "Icon");

		} catch (Exception e) {

		}

		if (Clicking) {

			Clicking = false;

			// PASS SOMETHNG INTO THE SEARCH TEXTBOX WITH FUNCTION CHECKING
			funtionCheckAndSendKeys("➢ Checking Search box function and Search Something",
					driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input")),
					"Search TextBox", searchInput);

			if (searching) {

				searching = false;

				// CLICK SEARCH BUTTON WITH FUNCTION CHECKING
				functionality.FunctionCheckWithClick("➢ Checking Search box Search Button Functionality",
						driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//button[1]")),
						"Search Button");

				if (Clicking) {

					// CALL TABLE ROW COUNT METHOD USING TEXT
					rowCountMethodWithText(searchDataColumnNo, searchInput, expectRowCount);

				}

			}

		}

	}

	// METHOD ~ (17) ---> USING (15)
	/********************************************************************************************************************************************************************************
	 * @category METHOD FOR RESET FUNCTIONALITY
	 * @param searchDataColumnNo
	 * @param expectRowCount
	 * @param uncountRow
	 * @throws InterruptedException
	 *********************************************************************************************************************************************************************************/
	public static void afterResetFunctionality(String searchDataColumnNo, String expectRowCount, int uncountRow)
			throws InterruptedException {

		// CLICK RESET BUTTON WITH FUNCTION CHECKING
		functionality.FunctionCheckWithClick("➢ Checking Designation Reset Button Functionality",
				driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//button[2]")), "Reset Button");
		Thread.sleep(3000);

		if (Clicking) {

			// CALL TABLE ROW COUNT METHOD
			tableRowCountMethod(searchDataColumnNo, uncountRow, expectRowCount);

		}

	}
	
	// METHOD ~ (18) 
		/********************************************************************************************************************************************************************************
		 * @category METHOD FOR CLICKING WITHOUT FUNCTION CHECKING
		 * @param searchDataColumnNo
		 * @param expectRowCount
		 * @param uncountRow
		 * @throws InterruptedException
		 *********************************************************************************************************************************************************************************/

	public static void clicking(WebElement finderKey, String element) throws InterruptedException {
		
		try {
			
			Thread.sleep(2000);
			finderKey.click();
			testCase = extent.createTest("[3]" + element + " Clickable. ");
			testCase.log(Status.INFO, element + " clicked.");
			testCase.log(Status.PASS, "TEST PASS ☑");
			Clicking = true;
	
		} catch (ElementClickInterceptedException e) {
	
			testCase = extent.createTest("[3]" + element + " Clickable. ");
			testCase.log(Status.INFO, element + " not clicked.");
			testCase.log(Status.FAIL, "TEST FAIL❌");
			
		}catch (NullPointerException e) {
	
			testCase = extent.createTest("[3]" + element + " Clickable. ");
			testCase.log(Status.INFO, element + " not identified.");
			testCase.log(Status.FAIL, "TEST FAIL❌");
			
		}catch (Exception e) {
	
			testCase = extent.createTest("[3]" + element + " Clickable. ");
			testCase.log(Status.INFO,"Unkown Exception");
			testCase.log(Status.FAIL, "TEST FAIL❌");
			
		}
		
	}

	// METHOD ~ (19) 
	/********************************************************************************************************************************************************************************
	 * @category METHOD FOR CLICKING DROPDOWN WITH FUNCTION CHECKING
	 * @param DropDownBoxName
	 * @param TextBox
	 * @param dropDownData
	 * @throws InterruptedException
	 *********************************************************************************************************************************************************************************/
	public static void dropDownSelectionWithTextBoxFunction(String DropDownBoxName ,WebElement TextBox , String dropDownData) throws InterruptedException {
			
//		CLICK TEXT BOX
		FunctionCheckWithClick("➢ Checking "+DropDownBoxName+" DropDown Box Functionality", TextBox, "TextBox");
		Thread.sleep(2000);
		
		if (Clicking) {
			Clicking = false;
			
			try {
				
//				SELECT ONE DATA
				System.out.println("Dropdown Select Data -> "+dropDownData);
				driver.findElement(By.xpath("//div[@title='" + dropDownData + "']")).click();
				ExtentTest testCase = extent.createTest("➢Checking "+DropDownBoxName+" DropDown Data Selection ");
				testCase.log(Status.INFO, dropDownData+" selected" );
				testCase.log(Status.PASS, "TEST PASS ☑");
				selectData = true;
				
			} catch (NoSuchElementException e) {
				
				ExtentTest testCase = extent.createTest("➢ DropDown Data Selection 🛑");
				testCase.log(Status.INFO, "No SuchElement Exception !" );
				testCase.log(Status.FAIL, "TEST FAIL❌");
				
			}catch (ElementClickInterceptedException e) {
				
				ExtentTest testCase = extent.createTest("➢ DropDown Data Selection 🛑");
				testCase.log(Status.INFO, "Element Click Intercepted Exception !" );
				testCase.log(Status.FAIL, "TEST FAIL❌");
				
			}catch (Exception e) {
				
				ExtentTest testCase = extent.createTest("➢ DropDown Data Selection 🛑");
				testCase.log(Status.INFO, "Unknown Exception !" );
				testCase.log(Status.FAIL, "TEST FAIL❌");	
			}
	
		}
	
	}
	
	// METHOD ~ (20) 
	/********************************************************************************************************************************************************************************
	 * @category METHOD FOR CLICKING DROPDOWN WITH SEND KEYS AND FUNCTION CHECKING
	 * @param DropDownBoxName
	 * @param TextBox
	 * @param dropDownData
	 * @throws InterruptedException
	 *********************************************************************************************************************************************************************************/
	public static void dropDownSelectionWithSendKeysAndTextBoxFunction(String DropDownBoxName ,WebElement TextBox , String dropDownData) throws InterruptedException {
			
//		CLICK TEXT BOX
		FunctionCheckWithClick("➢ Checking "+DropDownBoxName+" DropDown Box Functionality", TextBox, "TextBox");
		Thread.sleep(2000);
		
		if (Clicking) {
			Clicking = false;
			
			try {
				
				System.out.println("Dropdown Select Data -> "+dropDownData);
				TextBox.sendKeys(dropDownData);
				Thread.sleep(1500);
				
			} catch (Exception e) {
				
				ExtentTest testCase = extent.createTest("➢ DropDown Data Selection 🛑");
				testCase.log(Status.INFO, "Unable to send the Data" );
				testCase.log(Status.FAIL, "TEST FAIL❌");
			}
			try {
				
//				SELECT ONE DATA
				driver.findElement(By.xpath("//div[@title='" + dropDownData + "']")).click();
				ExtentTest testCase = extent.createTest("➢Checking "+DropDownBoxName+" DropDown Data Selection ");
				testCase.log(Status.INFO, dropDownData+" selected" );
				testCase.log(Status.PASS, "TEST PASS ☑");
				selectData = true;
				
			} catch (NoSuchElementException e) {
				
				ExtentTest testCase = extent.createTest("➢ DropDown Data Selection 🛑");
				testCase.log(Status.INFO, "No SuchElement Exception !" );
				testCase.log(Status.FAIL, "TEST FAIL❌");
				
			}catch (ElementClickInterceptedException e) {
				
				ExtentTest testCase = extent.createTest("➢ DropDown Data Selection 🛑");
				testCase.log(Status.INFO, "Element Click Intercepted Exception !" );
				testCase.log(Status.FAIL, "TEST FAIL❌");
				
			}catch (Exception e) {
				
				ExtentTest testCase = extent.createTest("➢ DropDown Data Selection 🛑");
				testCase.log(Status.INFO, "Unknown Exception !" );
				testCase.log(Status.FAIL, "TEST FAIL❌");	
			}
	
		}
	
	}
	
	
	// METHOD ~ (21) 
	/********************************************************************************************************************************************************************************
	 * @category METHOD FOR CLICKING DROPDOWN WITH SEND KEYS AND FUNCTION CHECKING
	 * @param TestCase
	 * @param finder
	 * @param AttributeName
	 * @throws InterruptedException
	 *********************************************************************************************************************************************************************************/
	public static void getOnePropertyAndCompare(String TestCase ,WebElement finder,String AttributeName,String ExpectResult) throws InterruptedException {
			
//		GET ACTUAL RESULT			
		try {
			actualResult = finder.getCssValue(AttributeName);
			System.out.println("Actual Value :" + actualResult);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
        compareData(TestCase , actualResult, ExpectResult);
        compareData = true;
	}
	
	/*******************************************************************************************************************************************************************************
	 * @category METHOD FOR NAVIGATE TO TABLE ANY PAGE
	 * @param pageNo
	 *******************************************************************************************************************************************************************************/
	public static void navigateToTablePage(Object pageNo) {
		
//		PAGE DOWN
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		System.out.println("Page No You Given :"+pageNo);
		if (pageNo == null  || pageNo == "") {
			
			pageNo = 1;	
			printStatus("➢ Page Default Selection", "Given Data Null.First Page Selected By Default");
					
		}
		else {
			
			boolean nextButton = true;	
			while(nextButton) {
				
//				NEXT BUTTON INABILITY & IDENTIFICATION
				try {
					
					Thread.sleep(1000);
					nextButton = driver.findElement(By.xpath("//li[@title='Next Page']//button")).isEnabled();
					
				}catch (Exception e) {
					
				}
				
//				SEARCH DATA IIDENTIFICATION
				try {
					
					
					
					try {
						
						driver.findElement(By.xpath("//li[@title='"+pageNo+"']"));
						
					} catch (Exception e) {
						
					}
					driver.findElement(By.xpath("//li[@title='"+pageNo+"']")).click();
					printPassStatus("➢ Page Identification", "Found The Right Page : "+pageNo);
					pageSelect = true;
					nextButton=false;
					break;
					
				} catch (Exception e) {
					
				}
				

//				IF DATA NOT IDENTIFIED.....NEXT BUTTON CLICK
				if (nextButton) {
					
					try {
						
						driver.findElement(By.xpath("//span[contains(@class,'anticon-double-right ant-pagination-item-link-icon')]/../span[@class='ant-pagination-item-ellipsis']")).click();

					} catch (Exception e) {
						
//						IF PAGE NOT IDENTIFIED REPORT PRINT
						if(!pageSelect) {
							
							printFailStatus("➢ Page Identification", "Search Page ("+pageNo+ ") not Identified." );

						}
						break;
					}
					
				}
				

			System.out.println("Next Button : "+nextButton);
			
			}
			
		}
		tablePage  = true;
		
	}
	
	
	/*************************************************************************
	 * @category METHOD FOR CHECKING EXPECT PAGE SELECTION
	 * @param pageNo
	 *************************************************************************/
	public static void rightPageSelection(String TestCase,int pageNo) {
		
		String activePageNo= null;
		boolean visible = false;
		
		try {
			
			 visible = driver.findElement(By.xpath("//div[@class='ant-modal-content']")).isDisplayed();
		     visible = true;
		} catch (Exception e) {
			
		}
		
		if (!visible) {
			
			try {
				 
				activePageNo= driver.findElement(By.xpath("//li[contains(@class,'ant-pagination-item-active')]/a")).getText();
				System.out.println(activePageNo+" :: "+String.valueOf(pageNo));

			}catch (Exception e) {
				
			}
		}else {
			try {
				 
				activePageNo= driver.findElement(By.xpath("//div[@class='ant-modal-content']//li[contains(@class,'ant-pagination-item-active')]/a")).getText();
				System.out.println(activePageNo+" :: "+String.valueOf(pageNo));

			}catch (Exception e) {
				
			}
		}
		
		
		try {
			
			Assert.assertEquals(activePageNo, String.valueOf(pageNo));
			page   = true;
			
		} catch (AssertionError e) {
			
		}catch (Exception e) {
			
		}
		
		if (page) {
			
			printPassStatus(TestCase, "Right Page Selected.");
			
		} else {
			
			printFailStatus(TestCase, "Something Wrong..Expected Page Not Selected");
			
		}

	}
}
