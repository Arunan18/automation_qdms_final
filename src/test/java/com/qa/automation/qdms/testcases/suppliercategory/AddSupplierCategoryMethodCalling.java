/***********************************************************************************
* Description
*------------
* ADD Supplier Category
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 10/03/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*   TC-SUPCAT-0018      10/03/2023   RAHUL.S    Original Version
*   TC-SUPCAT-0002      11/04/2023   RAHUL.S    MODIFIED VERSION
*	TC-SUPCAT-0024      17/07/2023   RAHUL.S    MODIFIED VERSION
************************************************************************************/
package com.qa.automation.qdms.testcases.suppliercategory;

import org.testng.annotations.Test;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class AddSupplierCategoryMethodCalling extends AddSupplierCategory {

	@Test
	public static void addSbuFunctionality() throws InterruptedException {

		AddSupplierCategory.navigateSupplierCategory("TC-SUPCAT-0024--Supplier Category Add Function");

		if (MasterMainNavigationsTest.clickSuppliermain) {
			AddSupplierCategory.inputSupplierCategoryValue("TC-SUPCAT-0024", "Supplier Category", "add");
		}
		AddSupplierCategory.logout();

	}

}
