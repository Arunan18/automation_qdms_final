package com.qa.automation.qdms.mixdesign.commonmethods;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
public class MixDesignNavigation  extends DriverIntialization{
	
// ============================ MIX DESIGN CARD =========================	

	public static void mixDesignNavigation() {
		MixDesignPage.MixDesignXpath().click();
	}
//===========================  MIX DESIGN COMPOSITION ======================	
	public static void  mixBomDesignComposition() {
		MixDesignPage.MiXDesignBomComposition().click();
	}
}
