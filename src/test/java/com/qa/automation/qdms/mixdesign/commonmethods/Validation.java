package com.qa.automation.qdms.mixdesign.commonmethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.qa.automation.qdms.base.DriverIntialization;

public class Validation extends DriverIntialization{
public	static int allredyexitCount=0;
	public static void allredyExcet(int I,String data) {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		allredyexitCount=0;
		boolean next=true;
		try {
			driver.findElement(By.xpath("//ul/li[@title='1']")).click();
		} catch (Exception e) {
		}
		while (next) {
			try {
				Thread.sleep(1500);
			} catch (Exception e) {
			}
			
			
		int hj=	driver.findElements(By.xpath("//tr/td["+I+"]")).size();
			
			for (int j = 0; j <= hj; j++) {
				
				String datstra="";
				try {
					datstra = driver.findElement(By.xpath("//tr[" + j + "]/td[" + I + "]")).getText().toUpperCase();
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("-"+datstra+"-"+data.toUpperCase()+"-");
				      if (data.toUpperCase().equals(datstra)) {
				    	  allredyexitCount=allredyexitCount+1;
					}
				      
				
			}
		      try {
							next=	driver.findElement(By.xpath("//ul/li[@title='Next Page']/button")).isEnabled();
							System.out.println(next);
							} catch (Exception e) {
								next=false;
							}
						if (next) {
							driver.findElement(By.xpath("//ul/li[@title='Next Page']/button")).click();
						}
			
		}
		
		
	}

}
