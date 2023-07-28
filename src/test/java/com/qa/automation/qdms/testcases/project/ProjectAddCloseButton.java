package com.qa.automation.qdms.testcases.project;

import java.io.IOException;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.ProjectPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterTest;


public class ProjectAddCloseButton extends DriverIntialization {


  @Test
  public void ProjectAddCloseBut() throws InterruptedException, IOException {


    LoginTest.Login();

    MasterTest.MasterCard();

    ProjectMethods.ProjectPagination();

    ProjectPage.projectaddbtn.click();
    

    // ****************************************************************************************
    // STEP-01 CHECKING ADD PROJECT BUTTON IS DISPLAYED & STEP-02 CHECKING ADD UNIT BUTTON IS
    // ENABLED
    // ****************************************************************************************

    ProjectMethods.ProjectAddButton("STEP-01 - CHECKING ADD PROJECT ",
        "STEP-02 CHECKING ADD PROJECT");

    // ***************************************************************************************
    // STEP-02-- CLOSE BUTTON IS DISPLAYED & STEP-03-- CLOSE BUTTON IS ENABLED
    // ***************************************************************************************

    ProjectMethods.ProjectcloseButton();


  }

}
