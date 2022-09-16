package com.dsalgo.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dsalgo.dsbase.DsAlgoBase;

public class HomePage extends DsAlgoBase {
	
	
	By pane = By.xpath("//div[@class='card h-100']");
	By dropDownlink = By.xpath("//div[@class='nav-item dropdown']//a");
	By dropDownlist = By.xpath("//a[@class ='dropdown-item']");
	By dsGetStartedPane = By.xpath("//a[@href= 'data-structures-introduction']");
	By loginAlert = By.xpath("//div[@class= 'alert alert-primary']");
	By ddGetStratedFromArray = By.xpath("//a[contains(text(), 'Arrays')]");
	By signInBtn = By.xpath("//a[contains(text(), 'Sign in')]");
	By userName = By.name("username");
	By signInPassword = By.name("password");
	By submit = By.xpath("//input [@type='submit']");
	By registerBtn = By.xpath("//a[contains(text(), 'Register')]");
	By accountCreatedmsg = By.xpath("//div[@class='alert alert-primary']");
	By signOutBtn = By.xpath("//a[contains(text(), 'Sign out')]"); 
	By signOutmsg = By.xpath("//div[@class='alert alert-primary']");
	
	
	//write down methods/actions which you can do in home page
	//NO Validation HERE.......
	
	
	//Actions
	public int getPaneCount(){
		List<WebElement> paneList = (List<WebElement>) driver.findElements(pane);
		return paneList.size();
	}

	public int getDropDownListCount() throws InterruptedException{
		driver.findElement(dropDownlink).click();
		Thread.sleep(2000);
		List<WebElement> dropDownList1 = (List<WebElement>) driver.findElements(dropDownlist);
		return dropDownList1.size();
	}
	
	//TO-DO
	public void getStartedFromPane(String paneName) throws InterruptedException{
		driver.findElement(dsGetStartedPane).click();
		Thread.sleep(2000);
	}
	
	public String locateLoginAlertText() {
		return driver.findElement(loginAlert).getText();
	}
	
	public void getStartedFromDropDown() throws InterruptedException{
		driver.findElement(dropDownlink).click();
		driver.findElement(ddGetStratedFromArray).click();
		Thread.sleep(2000);
	}
	
	public void displaysignIn() throws InterruptedException{
		driver.findElement(signInBtn).click();
		
	}
	public String locateLogin() throws InterruptedException{
		return driver.getTitle();
	}
	public String clickRegisterBtn() throws InterruptedException {
		driver.findElement(registerBtn).click();
		Thread.sleep(2000);
		return driver.getTitle();
	}
	public String validateAccountCreated() throws InterruptedException{
		return driver.findElement(accountCreatedmsg).getText();
	}
	public String signOut() throws InterruptedException{
		driver.findElement(signOutBtn).click();
		Thread.sleep(2000);
		return driver.findElement(signOutmsg).getText();
		
	}
	public String signIn() throws InterruptedException{
		driver.findElement(signOutBtn).click();
		Thread.sleep(2000);
		return driver.findElement(signOutmsg).getText();
		
	}
}