package com.qa.automation.qdms.commonmethods;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.automation.qdms.base.DriverIntialization;

public class Searching extends DriverIntialization{

	public static void searchvalue(String SearchValue, int column) throws InterruptedException {
		
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).perform();

        WebElement next=driver.findElement(By.xpath("//li[@title='Next Page']//button"));
        boolean nextBtn = next.isEnabled();
        Thread.sleep(3000);
        List<WebElement> Colu=driver.findElements(By.xpath("//tr[contains(@class,'ant-table-row')]/child::td["+ column + "]"));
        
        List<WebElement> sectionList = Colu;
        List<String> list = new ArrayList<String>();
        nextBtn = true;
        while (nextBtn) {
            for (WebElement linkElement : sectionList) {
                String linkText = linkElement.getText();
                System.out.println(linkText);
                list.add(linkText);
            }
            
            boolean isExist = list.contains(SearchValue);
            Thread.sleep(3000);
            nextBtn = next.isEnabled();
            System.out.println("ele" + isExist);
            System.out.println("next" + nextBtn);
            if (nextBtn && isExist != true) {
                next.click();
                Thread.sleep(3000);
            } else
                break;
        }
    }
	
	 
}
