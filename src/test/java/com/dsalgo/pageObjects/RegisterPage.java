package com.dsalgo.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.dsalgo.dsbase.DsAlgoBase;

public class RegisterPage extends DsAlgoBase {
	
	By clickRegister = By.xpath("//input[@value ='Register']");
	
	By userName = By.name("username");
	By passWord = By.name("password1");
	By confirmPassword = By.name("password2");
	
	
	
	public List<String> registerUser_With_invalidDetails(String uName, String uPasswd, String confPasswd) throws InterruptedException {
		
		List<String> valError = new ArrayList<String>();
		
		driver.findElement(userName).sendKeys(uName);
		driver.findElement(passWord).sendKeys(uPasswd);
		driver.findElement(confirmPassword).sendKeys(confPasswd);
		driver.findElement(clickRegister).click();
		
		Thread.sleep(1000);
		
		String usrNameMessage = driver.findElement(userName).getAttribute("validationMessage"); 
		String passwdMessage = driver.findElement(passWord).getAttribute("validationMessage");  
		String confPasswdMsg = driver.findElement(confirmPassword).getAttribute("validationMessage");  
		
		if(!(usrNameMessage.isEmpty()))
		{
			valError.add(usrNameMessage);
		}
		
		if(!(passwdMessage.isEmpty()))
		{
			valError.add(passwdMessage);
		}
		
		if(!(confPasswdMsg.isEmpty()))
		{
			valError.add(confPasswdMsg);
		}
		return valError;
	}
	
public void registerUser_With_validDetails(String uName, String uPasswd, String confPasswd) throws InterruptedException {
		
		driver.findElement(userName).sendKeys(uName);
		driver.findElement(passWord).sendKeys(uPasswd);
		driver.findElement(confirmPassword).sendKeys(confPasswd);
		driver.findElement(clickRegister).click();
		
		Thread.sleep(1000);
	}
	
	public void clearUserName() throws InterruptedException {
		driver.findElement(userName).clear();
		Thread.sleep(1000);
	}
	public void clearPasswd() throws InterruptedException {
		driver.findElement(passWord).clear();
		Thread.sleep(1000);
	}
	public void clearConfPasswd()throws InterruptedException  {
		driver.findElement(confirmPassword).clear();
		Thread.sleep(1000);
	}


}
