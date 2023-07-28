package com.qa.automation.qdms.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverIntialization {

	public static String browser = "chrome";
	public static WebDriver driver;	
	public static String URL = "http://192.168.1.100:8088/#/";
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentTest testCase;


	@Test
	public void main() throws IOException {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.driver","C:\\Users\\Invicta\\Documents\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.get(URL);

		ExtentReport();

	}

	@AfterSuite
	public void closeChrome() {
		extent.flush();
		// driver.close();
	}

	public static void ExtentReport() throws IOException {
		extent = new ExtentReports();
		htmlreporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Report\\extentreport.html");

		extent.attachReporter(htmlreporter);
	}


}
