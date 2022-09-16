package com.dsalgo.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.dsalgo.dsbase.DsAlgoBase;

public class SignInPage extends DsAlgoBase {

	
	
	By loginBtn = By.xpath("//input[@type= 'submit']");
	By userName = By.name("username");
	By passWd = By.name("password");
	
	//public void clickloginBtn()
	//{
	//	driver.findElement(loginBtn).click();
	//}	
	
	public List<String> signIn_User_With_inValid_Details(String uName, String uPasswd) throws InterruptedException {
		
		List<String> valError = new ArrayList<String>();
		
		driver.findElement(userName).sendKeys(uName);
		driver.findElement(passWd).sendKeys(uPasswd);
		
		driver.findElement(loginBtn).click();
		
		Thread.sleep(1000);
		
		String usrNameMessage = driver.findElement(userName).getAttribute("validationMessage"); 
		String passwdMessage = driver.findElement(passWd).getAttribute("validationMessage");  
		  
		
		if(!(usrNameMessage.isEmpty()))
		{
			valError.add(usrNameMessage);
		}
		
		if(!(passwdMessage.isEmpty()))
		{
			valError.add(passwdMessage);
		}
		
		
		return valError;
	}
public void signIn_User_With_validDetails(String uName, String uPasswd) throws InterruptedException {
		
		driver.findElement(userName).sendKeys(uName);
		driver.findElement(passWd).sendKeys(uPasswd);
		
		driver.findElement(loginBtn).click();
		
		Thread.sleep(1000);
	}

	public void clearUserName() throws InterruptedException {
		driver.findElement(userName).clear();
		Thread.sleep(1000);
	}
	public void clearPasswd() throws InterruptedException {
		driver.findElement(passWd).clear();
		Thread.sleep(1000);
	}
}
