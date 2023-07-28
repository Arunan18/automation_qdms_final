package com.qa.automation.qdms.testcases.delivery;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.DeliveryPage;
import com.qa.automation.qdms.pages.master.ProjectPage;

public class DeliverySingleSearchCommonMethod extends DriverIntialization {

  static int BeforeCount = 0;
  static int AfterCount = 0;
  static boolean validation = true;
  static String searchdelivery = "Domesticc";
  static int actualElementCount = 0;

  static DeliveryPage deliveryPage = new DeliveryPage();


  // ********************************************************************************************************
  // THE METHOD IS FOR GENERATING REPORT
  // ********************************************************************************************************
  public static void testCasePrint(String TestCaseName, String expectedValue, String actualValue) {
    boolean position = true;
    ExtentTest testCase = extent.createTest(TestCaseName);
    try {
      AssertJUnit.assertEquals(actualValue, expectedValue);
    } catch (AssertionError e) {
      position = false;
    }
    if (position) {
      testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
      testCase.log(Status.INFO, "Expectedvalue :- " + expectedValue);
      testCase.log(Status.INFO, "Correct value");
      testCase.log(Status.PASS, actualValue);
    } else {
      testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
      testCase.log(Status.INFO, "ExpectedValue :- " + expectedValue);
      testCase.log(Status.INFO, "wrong value");
      testCase.log(Status.FAIL, actualValue);
    }

  }


  // ****************************************************************************************
  // STEP-01--CUSTOMER TAB IS DISPLAYED & STEP-02--CUSTOMER TAB IS ENABLED
  // ****************************************************************************************

  public static void customertopTab() {
    if (ProjectPage.customerTopTab.isDisplayed()) {
      testCase = extent.createTest("STEP-01--CUSTOMER TAB IS DISPLAYED");
      testCase.log(Status.PASS, "TEST PASS ☑");

      if (ProjectPage.customerTopTab.isEnabled()) {
        testCase = extent.createTest("STEP-02--CUSTOMER TAB IS ENABLED");
        testCase.log(Status.PASS, "TEST PASS ☑");
        ProjectPage.customerTopTab.click();

      } else {
        testCase = extent.createTest("STEP-02--CUSTOMER TAB IS ENABLED");
        testCase.log(Status.PASS, "TEST FAIL ❎");
      }
    } else {
      testCase = extent.createTest("STEP-01--CUSTOMER TAB IS DISPLAYED");
      testCase.log(Status.PASS, "TEST FAIL ❎");
    }
  }

  // ****************************************************************************************
  // STEP-03--PROJECT BUTTON IS DISPLAYED & STEP-04--PROJECT BUTTON IS ENABLED
  // ****************************************************************************************
  public static void DeliveryleftButton() throws InterruptedException {
    Thread.sleep(2000);
    if (DeliveryPage.deliveryleftbutton.isDisplayed()) {
      testCase = extent.createTest("STEP-03--PROJECT BUTTON IS DISPLAYED");
      testCase.log(Status.PASS, "TEST PASS ☑");

      if (DeliveryPage.deliveryleftbutton.isEnabled()) {
        testCase = extent.createTest("STEP-04--PROJECT BUTTON IS ENABLED");
        testCase.log(Status.PASS, "TEST PASS ☑");
        DeliveryPage.deliveryleftbutton.click();

      } else {
        testCase = extent.createTest("STEP-04--PROJECT BUTTON IS ENABLED");
        testCase.log(Status.PASS, "TEST FAIL ❎");
      }
    } else {
      testCase = extent.createTest("STEP-03--PROJECT BUTTON IS DISPLAYED");
      testCase.log(Status.PASS, "TEST FAIL ❎");
    }

  }


  // ****************************************************************************************
  // STEP-05--DELIVERY MODULE DELIVERY FIELD SEARCH ICON IS DISPLAYED &
  // STEP-06--DELIVERY MODULE DELIVERY FIELD SEARCH ICON IS
  // ENABLED
  // ****************************************************************************************

  public static void DeliverySearchIcon() {
    if (driver.findElement(By.xpath(
        "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]"))
        .isDisplayed()) {
      testCase =
          extent.createTest("STEP-05--DELIVERY MODULE DELIVERY FIELD SEARCH ICON IS DISPLAYED");
      testCase.log(Status.PASS, "TEST PASS ☑");
      if (driver.findElement(By.xpath(
          "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]"))
          .isEnabled()) {
        testCase =
            extent.createTest("STEP-06--DELIVERY MODULE DELIVERY FIELD SEARCH ICON IS ENABLED");
        testCase.log(Status.PASS, "TEST PASS ☑");
        try {
          driver.findElement(By.xpath(
              "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]"))
              .click();
          Thread.sleep(2000);

        } catch (Exception e) {

        }
      } else {
        testCase =
            extent.createTest("STEP-06--DELIVERY MODULE DELIVERY FIELD SEARCH ICON IS ENABLED");
        testCase.log(Status.PASS, "TEST FAIL ❎");
      }
    } else {
      testCase =
          extent.createTest("STEP-05--DELIVERY MODULE  DELIVERY FIELD SEARCH ICON IS DISPLAYED");
      testCase.log(Status.PASS, "TEST FAIL ❎");
    }

  }

  public static void DeliverySearchTextbox() {
    PageFactory.initElements(driver, deliveryPage);
    if (DeliveryPage.DeliverySearchTextBox.isDisplayed()) {

      testCase =
          extent.createTest("STEP-07-- DELIVERY MODULE DELIVERY FIELD SEARCH TEXTBOX IS DISPLAYED");
      testCase.log(Status.PASS, "TEST PASS ☑");
      if (DeliveryPage.DeliverySearchTextBox.isEnabled()) {
        testCase = extent
            .createTest("STEP-08--DELIVERY MODULE DELIVERY FIELD SEARCH TEXTBOX ICON IS ENABLED");
        testCase.log(Status.PASS, "TEST PASS ☑");
        try {
          DeliveryPage.DeliverySearchTextBox.sendKeys(searchdelivery);

          // driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

          Thread.sleep(3000);

        } catch (Exception e) {

        }
      } else {
        testCase = extent.createTest(
            "STEP-08-- DELIVERY MODULE DELIVERY PERSON FIELD SEARCH TEXTBOX ICON IS ENABLED");
        testCase.log(Status.PASS, "TEST FAIL ❎");
      }
    } else {
      testCase = extent
          .createTest("STEP-07-- DELIVERY MODULE DELIVERY  FIELD SEARCH TEXTBOX IS DISPLAYED");
      testCase.log(Status.PASS, "TEST FAIL ❎");
    }

  }


  // **************************************************************************************************************************************
  // STEP-08--CHECKING DELIVERY MODULE DELIVERY FIELD SEARCH BUTTON DISPLAYED & STEP-09--CHECKING
  // DELIVERY MODULE DELIVERY FIELD SEARCH BUTTON ENABLED
  // *******************************************************************************************************************************************
  public static void DeliverySearchButton() throws InterruptedException {

    if (driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']"))
        .isDisplayed()) {
      testCase =
          extent.createTest("STEP-09-- DELIVERY MODULE DELIVERY FIELD SEARCH BUTTON IS DISPLAYED");
      testCase.log(Status.PASS, "TEST PASS ☑");
      if (driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']"))
          .isEnabled()) {
        testCase =
            extent.createTest("STEP-10-- DELIVERY MODULE DELIVERY FIELD SEARCH BUTTON IS ENABLED");
        testCase.log(Status.PASS, "TEST PASS ☑");
        try {
          driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']"))
              .click();
          String Plant = driver.findElement(By.xpath(
              "//body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[5]/span[1]/mark[1]"))
              .getText();
          System.out.println("PPPPP " + Plant);
          String TextBox1 =
              driver.findElement(By.xpath("//input[@placeholder='Plant']")).getAttribute("value");
          System.out.println("text box  " + TextBox1);
        } catch (Exception e) {

        }

      } else {
        testCase =
            extent.createTest("STEP-09-- DELIVERY MODULE DELIVERY FIELD SEARCH BUTTON IS ENABLED");
        testCase.log(Status.PASS, "TEST FAIL ❎");
      }
    } else {
      testCase =
          extent.createTest("STEP-08--DELIVERY MODULE CONTACT DELIVERY SEARCH BUTTON IS DISPLAYED");
      testCase.log(Status.PASS, "TEST FAIL ❎");
    }
    // *************************************************************************************************************************

    boolean clickNextPage = true;

    boolean passorfail = true;
    ArrayList<String> actualList = new ArrayList<String>();
    ArrayList<String> expectedList = new ArrayList<String>();
    String nameXpath_firstPart =
        "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
    String nameXpath_lastPart = "]/td[2]";
    while (clickNextPage) {
      for (int i = 2; i < 103; i++) {
        try {
          String textFull =
              driver.findElement(By.xpath(nameXpath_firstPart + i + nameXpath_lastPart)).getText();
          String text = textFull.toLowerCase();
          // System.out.println(text);
          try {
            if (!text.contains(searchdelivery)) {
              passorfail = false;
            }
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          if (text.contains(searchdelivery)) {
            expectedList.add(text);
          }
          actualList.add(text);
          actualElementCount = actualElementCount + 1;
        } catch (Exception e) {
        }
      }
      if (clickNextPage == true) {
        clickNextPage = driver
            .findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
        driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
        Thread.sleep(2000);
      } else {
        break;
      }
    }
    Thread.sleep(2000);
    driver.navigate().refresh();
    Thread.sleep(3000);

  }

  public static void DeliveryFSingleSearchConfirm() {
    try {
      int Value = actualElementCount;
      System.out.println(Value);
      testCasePrint("STEP-11-- DELIVERY MODULE CONTACT DELIVERY FIELD SINGLE SEARCH CONFIRM", "1",
          String.valueOf(Value));
    } catch (Exception e) {

    }
    driver.quit();
  }



  public static void DeliveryDesPopupButton(String colname, String colname1)
      throws InterruptedException, IOException {

    // PageFactory.initElements(driver, UnitPage);
    Thread.sleep(2000);
    if (DeliveryPage.deliverydespopup.isDisplayed()) {
      testCase = extent.createTest(colname + " BUTTON IS DISPLAYED");
      testCase.log(Status.PASS, "TEST PASS ☑");
      if (DeliveryPage.deliverydespopup.isEnabled()) {
        testCase = extent.createTest(colname1 + " BUTTON IS DISPLAYED");
        testCase.log(Status.PASS, "TEST PASS ☑");
        try {
          Thread.sleep(2000);
          DeliveryPage.deliverydespopup.click();
          Thread.sleep(2000);

        } catch (Exception e) {

        }
        Thread.sleep(3000);
      } else {
        testCase = extent.createTest(colname1 + " BUTTON IS DISPLAYED");
        testCase.log(Status.FAIL, "TEST FAIL ❎");
      }
    } else {
      testCase = extent.createTest(colname + " BUTTON IS DISPLAYED");
      testCase.log(Status.FAIL, "TEST FAIL ❎");
    }
  }
  
  
  public static void DeliveryDesPopupCancelButton(String colname, String colname1)
      throws InterruptedException, IOException {

    
    Thread.sleep(2000);
    if (DeliveryPage.deliverydespopupcancelbutton.isDisplayed()) {
      testCase = extent.createTest(colname + " BUTTON IS DISPLAYED");
      testCase.log(Status.PASS, "TEST PASS ☑");
      if (DeliveryPage.deliverydespopupcancelbutton.isEnabled()) {
        testCase = extent.createTest(colname1 + " BUTTON IS DISPLAYED");
        testCase.log(Status.PASS, "TEST PASS ☑");
        try {
          Thread.sleep(2000);
          DeliveryPage.deliverydespopupcancelbutton.click();
          Thread.sleep(2000);

        } catch (Exception e) {

        }
        Thread.sleep(3000);
      } else {
        testCase = extent.createTest(colname1 + " BUTTON IS DISPLAYED");
        testCase.log(Status.FAIL, "TEST FAIL ❎");
      }
    } else {
      testCase = extent.createTest(colname + " BUTTON IS DISPLAYED");
      testCase.log(Status.FAIL, "TEST FAIL ❎");
    }
  }
  
  
  public static void DeliveryDesPopupCloseButton(String colname, String colname1)
      throws InterruptedException, IOException {

    
    Thread.sleep(2000);
    if (DeliveryPage.deliverydespopupclosebutton.isDisplayed()) {
      testCase = extent.createTest(colname + " BUTTON IS DISPLAYED");
      testCase.log(Status.PASS, "TEST PASS ☑");
      if (DeliveryPage.deliverydespopupclosebutton.isEnabled()) {
        testCase = extent.createTest(colname1 + " BUTTON IS DISPLAYED");
        testCase.log(Status.PASS, "TEST PASS ☑");
        try {
          Thread.sleep(2000);
          DeliveryPage.deliverydespopupclosebutton.click();
          Thread.sleep(2000);

        } catch (Exception e) {

        }
        Thread.sleep(3000);
      } else {
        testCase = extent.createTest(colname1 + " BUTTON IS DISPLAYED");
        testCase.log(Status.FAIL, "TEST FAIL ❎");
      }
    } else {
      testCase = extent.createTest(colname + " BUTTON IS DISPLAYED");
      testCase.log(Status.FAIL, "TEST FAIL ❎");
    }
  }



}
