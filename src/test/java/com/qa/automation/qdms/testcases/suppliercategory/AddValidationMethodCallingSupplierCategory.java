/***********************************************************************************
* Description
*------------
* ADD SUPPLIER CATEGORY VALIDATION METHOD CALLING
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 10/03/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-SUPCAT-0025         10/03/2023   RAHUL.S    Original Version
*                        11/04/2023   RAHUL.S    MODIFIED VERSION
*                        19/07/2023   RAHUL.S    changed every code
************************************************************************************/
package com.qa.automation.qdms.testcases.suppliercategory;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class AddValidationMethodCallingSupplierCategory extends AddValidation {
	@Test
	public static void addMethodCalling() throws InterruptedException, IOException {

		AddSupplierCategory.navigateSupplierCategory("TC-SUPCAT-0025- Supplier Category Add Validation");

		if (MasterMainNavigationsTest.clickSuppliermain) {
			AddSupplierCategory.inputSupplierCategoryValue("TC-SUPCAT-0025", "Supplier Category", "validation");
		}
		AddSupplierCategory.logout();

	}

}
