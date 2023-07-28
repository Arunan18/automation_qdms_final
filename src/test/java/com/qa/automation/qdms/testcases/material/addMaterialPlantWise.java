/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking add material Functionality
******************************************************************************************************************
*
* @author 	 : 	Kajenthiran Yogalingam
* 
* ======================================================================================================
* 	Test Case Number 	 ||  	Date      ||      Intis     ||   Comments
* ================================================================================================================
*  	 TC-MAT-0160    	    				      Kajan		   Modified version (Rework)		      
******************************************************************************************************************/


package com.qa.automation.qdms.testcases.material;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class addMaterialPlantWise extends DriverIntialization{
	@Test
	public void addmaterialPlantWise() throws InterruptedException {
		materialMethodes.navicateMaterial();
		if (materialMethodes.kmnavication) {
			materialMethodes.kmnavication=false;
			materialMethodes.addmaterial("Master Module", "Material", "TC-MAT-0160");	
		}
		if (LoginTest.login) {
			
			Logout.LogoutFunction();
			
		}
		
	}

}
