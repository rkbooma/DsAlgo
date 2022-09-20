package com.dsalgo.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/*
@purpose method which will accept web element and click action
@param element
@return boolean
@exception Exception
*/
public class webClick {
	//public static WebDriver driver;
	
	public static boolean webClickAll(WebElement element, WebDriver driver) 
	{
	
		try
		{
			WebElement ele = new WebDriverWait (driver,Duration.ofSeconds(10)).
					until(ExpectedConditions.visibilityOf(element));
			
			if (ele.isDisplayed()) {
				
				if (ele.isEnabled()) {
					
					try {
//							Actions action =new Actions(driver);
//							action.moveToElement(ele);
//							action.click(ele);
						ele.click();
							return true;
						}
					catch(Exception e) {
						e.printStackTrace();
					}
					
				} else {
					throw new Exception("element not enabled");
				}
				
			} else {
				throw new Exception("element not displayed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}

	
	
