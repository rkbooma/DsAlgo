package com.dsalgo.pageObjects;

import org.openqa.selenium.By;

import com.dsalgo.dsbase.DsAlgoBase;

public class PortalPage extends DsAlgoBase {
	
	By getStartedbtn = By.xpath("//button[@class ='btn']");
	
	//Separate method for all Actions this portal page can do.......
	
	
	public String clickGetStarted() throws InterruptedException{
		driver.findElement(getStartedbtn).click();
		Thread.sleep(2000);
		return driver.getTitle();
	}

}
