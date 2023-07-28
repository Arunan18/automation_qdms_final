/***********************************************************************************
* Description
*------------
* Edit Supplier Category method calling
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 05/03/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-SUPCAT-0034      05/03/2023     RAHUL.S    Original Version
*                     12/04/2023     RAHUL.S    MODIFIED 
*                     17/07/2023     RAHUL.S    MODIFIED
************************************************************************************/
package com.qa.automation.qdms.testcases.suppliercategory;

import org.testng.annotations.Test;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class EditSupplierCategoryMethodCalling extends AddSupplierCategory {

	@Test
	public static void editSupplierCategory() throws InterruptedException {
		navigateSupplierCategory("TC-SUPCAT-0034-- Supplier Category Edit Function");

		if (MasterMainNavigationsTest.clickSuppliermain) {
			edit("Master Module", "Supplier Category", "TC-SUPCAT-0034");
		}
		logout();

	}
}
