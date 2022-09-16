package com.dsalgo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.dsalgo.dsbase.DsAlgoBase;
import com.dsalgo.util.DsAlgoUtil;

	
	public class LinkedListPage extends DsAlgoBase{
		By clickGetstarted = By.xpath("//a[@href = 'linked-list']");
		By clickIntroduction = By.xpath("//a[@href = 'introduction']");
		By createLinkedlist = By.xpath("//a[contains(text(), 'Creating Linked LIst')]");
		By practiceQuestns = By.xpath("//a[contains(text(), 'Practice Questions')]");
		By tryHereBtn = By.xpath("//a[contains(text(), 'Try here')]");
		By textBoxcode = By.xpath("//pre//span[@role = 'presentation']/span");
		By clickRun = By.xpath("//button[contains(text(), 'Run')]");
		
		public void click_Getstarted_below_LinkedListPage() throws InterruptedException 
		{
			driver.findElement(clickGetstarted).click();
			Thread.sleep(1000);
		}
		public void click_Introduction() throws InterruptedException 
		{
			driver.findElement(clickIntroduction).click();
			Thread.sleep(1000);
		}
		public void click_tryHere() throws InterruptedException 
		{
			driver.findElement(tryHereBtn).click();
			Thread.sleep(1000);
		}
		public void sendCode() throws InterruptedException 
		{
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(textBoxcode)).click().sendKeys("print ('Hello Selenium')").build().perform();
			
			Thread.sleep(1000);
			
		}
		public void clickRun_btn() throws InterruptedException 
		{
			driver.findElement(clickRun).click();
			
			
		}
		public void click_createLinkedlist() throws InterruptedException 
		{
			driver.findElement(createLinkedlist).click();
			DsAlgoUtil.scroll(driver, 0, 350);
			
			
		}
		
	}
	
	
	