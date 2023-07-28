import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;

public class ClassSelector {
	 static List<Class<?>> testClasses = new ArrayList<Class<?>>();
	static DataFormatter dataValue=new DataFormatter();

public static void select(String testcaseId)  {
try {
    String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Data.xlsx";
    String tabName="classSelector";
    int firstrow = CommonMethods.getFirstRowNum(excelPath, tabName,testcaseId);
	int lastrow = CommonMethods.getLastRowNum(excelPath, tabName,testcaseId);
	FileInputStream file = new FileInputStream(excelPath);
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet(tabName);
//	int lastRow=sheet.getLastRowNum();
	for (int i = firstrow; i <= lastrow; i++) {
		XSSFRow rowk = sheet.getRow(i);
		String check=dataValue.formatCellValue(rowk.getCell(1));
		String className=dataValue.formatCellValue(rowk.getCell(2));
		boolean check1=Boolean.parseBoolean(check);
		System.out.println(className);
		Class<?> clazz = Class.forName(className);
		if(check1) {
			testClasses.add(clazz);
			
		}
	}
	System.out.println(testClasses);
}catch (Exception e) {
//	DriverIntialization.testCase = DriverIntialization.extent.createTest("Excel File Not Found");
//	DriverIntialization.testCase.log(Status.INFO, "Excel File Not Found");
//	DriverIntialization.testCase.log(Status.FAIL, "Excel File Not Found, So fail");
}
}
}
