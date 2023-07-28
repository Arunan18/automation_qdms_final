package com.qa.automation.qdms.sample.commonmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.qa.automation.qdms.base.DriverIntialization;

public class ScrollRight extends DriverIntialization {
	static Actions actions = new Actions(driver);
	 public static void scroll(int size) {
	
	try {
        boolean pass = false;
        Thread.sleep(1000);
    
      for (int i = 0; i < 1000; i++) {
         if (!pass) {
             try {
                 driver.findElement(
                         By.xpath("//th[@class='ant-table-cell']["+size+"]"))
                         .click();
                 pass = true;
             } catch (Exception e) {
             }
         }
         
         if (!pass) {
        	 
             actions.sendKeys(Keys.ARROW_RIGHT).perform();
             Thread.sleep(2);
         } else {
             break;
         }
         
     }        
    } catch (Exception e) {
    }
}
}