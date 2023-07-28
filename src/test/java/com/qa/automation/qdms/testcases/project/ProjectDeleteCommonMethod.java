//package com.qa.automation.qdms.testcases.project;
//
//import java.io.IOException;
//import org.openqa.selenium.By;
//import org.testng.Assert;
//import com.aventstack.extentreports.Status;
//import com.qa.automation.qdms.base.DriverIntialization;
//import com.qa.automation.qdms.pages.master.ProjectPage;
//
//public class ProjectDeleteCommonMethod extends DriverIntialization {
//
//
//  static int BeforeCount = 0;
//  static int AfterCount = 0;
//
//
//  public static void ProjectDeletedependconfirm() throws InterruptedException {
//
//    //// ---------------------------------------------------------------------------------------
//    //// Count Number of elemenets before search
//    //// ---------------------------------------------------------------------------------------
//    String DataCountText = ProjectPage.projectpaginationcount.getText();
//
//    System.out.println("Projectpagination count :" + DataCountText);
//    String[] BeforeCount = DataCountText.split("of");
//
//    System.out.println("Final Count :" + BeforeCount[1]);
//
//  }
//
//
//  public static void ProjectDeletedependsearch(String searchdata, String colname , String colname1) throws InterruptedException, IOException {
//    String Name = searchdata;
//    String NameXpath_firstPart =
//        "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
//    String NameXpath_lastPart = "]/td[1]";
//    String DeleteXpath_firstPart =
//        "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
//    String DeleteXpath_lastPart = "]/td[9]/span/a[2]/a/span";
//
//    // String DeleteOk = "/html/body/div[4]/div/div/div/div[2]/div/div[2]/button[2]"
//    // ;
//    // *[@id="root"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[6]/td[9]/span/a/span
//    boolean clickNextPage = true;
//    boolean sbuExist = false;
//    while (clickNextPage) {
//      for (int i = 2; i < 102; i++) {
//        try {
//          String text =
//              driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
//          System.out.println(text);
//          if (text.equals(Name)) {
//            sbuExist = true;
//            if (driver.findElement(By.xpath(DeleteXpath_firstPart + i + DeleteXpath_lastPart))
//                .isDisplayed()) {
//
//              testCase = extent.createTest(colname + "CHECKING DELETE ICON IS DISPLAYED");
//              testCase.log(Status.PASS, "TEST PASS ☑");
//
//              if (driver.findElement(By.xpath(DeleteXpath_firstPart + i + DeleteXpath_lastPart))
//                  .isEnabled()) {
//
//                testCase = extent.createTest(colname1 +"CHECKING DELETE ICON IS ENABLED");
//                testCase.log(Status.PASS, "TEST PASS ☑");
//                driver.findElement(By.xpath(DeleteXpath_firstPart + i + DeleteXpath_lastPart))
//                    .click();
//                // driver.findElement(By.xpath(DeleteOk)).click();
//                Thread.sleep(2000);
//                clickNextPage = false;
//                break;
//              } else {
//                testCase.log(Status.FAIL, "TEST FAIL ❎");
//                System.out.println("Button NOT Enabled");
//              }
//            } else {
//              testCase.log(Status.FAIL, "TEST FAIL ❎");
//              System.out.println("Button NOT Displayed");
//            }
//
//          }
//        } catch (Exception e) {
//        }
//      }
//      if (clickNextPage == true) {
//        clickNextPage = driver
//            .findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
//        driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
//        Thread.sleep(2000);
//      } else {
//        break;
//      }
//    }
//    if (sbuExist = false) {
//      System.out.println("No such Element" + sbuExist);
//    }
//
//  }
//
//
//  public static void ProjectAfterDeletedependconfirm() throws InterruptedException {
//
//    //// ---------------------------------------------------------------------------------------
//    //// Count Number of elemenets before search
//    //// ---------------------------------------------------------------------------------------
//    String DataCountText = ProjectPage.projectpaginationcount.getText();
//
//    System.out.println("Projectpagination count :" + DataCountText);
//    String[] AfterCount = DataCountText.split("of");
//
//    System.out.println("Final Count :" + AfterCount[1]);
//
//  }
//
//
//  public static void ProjectDeleteDependEqu(String colname ,boolean afterdeletion) {
//
//    try {
//     
//      // System.out.println("IsVisible");
//      boolean Output = AfterCount == BeforeCount ;
//      System.out.println("Output is" + Output);
//      testCase = extent.createTest(colname +"Checking count after deletion");
//      try {
//        // ExpectedTextVisible=false;
//        Assert.assertEquals(Output, afterdeletion);
//        testCase.log(Status.INFO, "Actual Visible :- " + Output);
//        testCase.log(Status.INFO, "Expected Visible :- " + afterdeletion);
//        testCase.log(Status.PASS, " Unit deleted Succesfully");
//      } catch (AssertionError e) {
//        testCase.log(Status.INFO, "ActualVisible :- " + Output);
//        testCase.log(Status.INFO, "Expected Visible :- " + afterdeletion);
//        testCase.log(Status.FAIL, "Wrong");
//      }
//    } catch (Exception e) {
//      testCase = extent.createTest("1-VISIBLE");
//      testCase.log(Status.FAIL, "No element");
//    }
//
//    // AfterCount == BeforeCount - 1;
//
//  }
//
//}
