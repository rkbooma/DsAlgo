package com.dsalgo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.dsalgo.dsbase.DsAlgoBase;

public class DataStructurePage extends DsAlgoBase{
	By clickGetstarted = By.xpath("//a[contains(text(), 'Get Started')]");
	By timeComplexity = By.xpath("//a[contains(text(), 'Time Complexity')]");
	By practiceQuestns = By.xpath("//a[contains(text(), 'Practice Questions')]");
	By tryHereBtn = By.xpath("//a[contains(text(), 'Try here')]");
	By textBoxcode = By.xpath("//pre//span[@role = 'presentation']/span");
	By clickRun = By.xpath("//button[contains(text(), 'Run')]");
	
	public void click_Getstarted_below_DataStructure() throws InterruptedException 
	{
		driver.findElement(clickGetstarted).click();
		Thread.sleep(1000);
	}
	public void click_timeComplexity() throws InterruptedException 
	{
		driver.findElement(timeComplexity).click();
		Thread.sleep(1000);
		
	}
	public void click_practiceQns() throws InterruptedException 
	{
		driver.findElement(practiceQuestns).click();
		Thread.sleep(1000);
		
	}
	public void click_tryHere() throws InterruptedException 
	{
		driver.findElement(tryHereBtn).click();
		Thread.sleep(2000);
		
	}
	public void sendCode() throws InterruptedException 
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(textBoxcode)).click().sendKeys("print ('Hello')").build().perform();
		
		Thread.sleep(1000);
		
	}
	public void clickRun_btn() throws InterruptedException 
	{
		driver.findElement(clickRun).click();
		Thread.sleep(3000);
		
	}
}

