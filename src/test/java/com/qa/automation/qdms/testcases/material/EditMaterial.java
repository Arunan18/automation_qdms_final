package com.qa.automation.qdms.testcases.material;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class EditMaterial extends DriverIntialization {
	@Test
	public static void editMaterialtest() throws InterruptedException {
		materialMethodes.navicateMaterial();
		if (materialMethodes.kmnavication) {
			materialMethodes.kmnavication=false;
			
			materialMethodes.editmaterial("Master Module", "Material", "TC-MAT-0155");	
		}
		if (LoginTest.login) {
			
			Logout.LogoutFunction();
			
		}
		
	}
	

}
