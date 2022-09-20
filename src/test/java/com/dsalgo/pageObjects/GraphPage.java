package com.dsalgo.pageObjects;

//import java.util.List;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.util.webClick;

public class GraphPage {

	public WebDriver driver = null;
	// String user = null;
	GraphPage graphPage;

	// parameterize constructor
	public GraphPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//a[@href= 'graph'] ")
	WebElement graphBtn;// Graph button
	@FindBy(xpath = "//a[@href= 'graph-representations']")
	WebElement graphRepresenBtn;// Graph reperesentation button
	@FindBy(xpath = "//a[@class=\"btn btn-info\"]")	WebElement tryBtnGraph;// try button
	@FindBy(xpath = "//a[@class=\"btn btn-info\"]")	WebElement tryBtnGraphRepre;// try button graph repres
	@FindBy(xpath = ("//div[@class='dropdown-menu show']//a[contains(text(),'Graph')]"))
	WebElement GetStartGraph;
	@FindBy(xpath = ("//div[@class='nav-item dropdown']//a"))	WebElement dropDownlink;
	@FindBy(xpath = ("//h4[contains(text(), 'Graph')]")) WebElement graphPgTitle;
	@FindBy(xpath=("//span[@role='presentation']//span")) WebElement textEditor;
	@FindBy(xpath=("//button[@type='button']")) WebElement runBtn;
	@FindBy(xpath="//p[contains(text(),'Graph Representations')]")WebElement titleGraphReprestBtn;

	public String graphPageOpen() throws InterruptedException {
		webClick.webClickAll(dropDownlink, driver);
		webClick.webClickAll(GetStartGraph, driver);
		Thread.sleep(2000);
		if (graphPgTitle.isDisplayed()) {
			return graphPgTitle.getText();
		} else {
			return null;
		}
	}
	
	public String clickGraphBtn() throws InterruptedException {
		webClick.webClickAll(graphBtn, driver);
		Thread.sleep(2000);
		if (tryBtnGraph.isDisplayed()) {
			return tryBtnGraph.getText();
		} else {
			return null;
		}
		
	}
	
	public String clickGraphRepresenBtn() throws InterruptedException {
		webClick.webClickAll(graphRepresenBtn, driver);
		Thread.sleep(2000);
		if (titleGraphReprestBtn.isDisplayed()) {
			return titleGraphReprestBtn.getText();
		} else {
			return null;
		}
		
	}
	
	
		
	public boolean clickTryBtn() throws InterruptedException {
		webClick.webClickAll(tryBtnGraph, driver);
		Thread.sleep(2000);
		if (textEditor.isDisplayed()&& runBtn.isDisplayed() ) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addTextTryEditor() {
		Actions action = new Actions(driver);
		action.moveToElement(textEditor).click().sendKeys("print('hello')").build().perform();
		webClick.webClickAll(runBtn, driver);
		return true;
		
	}
	public String validateGraphRepresenPg() throws InterruptedException {
		Thread.sleep(2000);
		if (titleGraphReprestBtn.isDisplayed()) {
			return titleGraphReprestBtn.getText();
		} else {
			return null;
		}
	}
	
	public boolean clickTryBtnTest_GraphRepres() throws InterruptedException {
		webClick.webClickAll(tryBtnGraphRepre, driver);
		Thread.sleep(2000);
		if (textEditor.isDisplayed()&& runBtn.isDisplayed() ) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addTextTryEditor_clickTryBtnTest_GraphRepres() {
		Actions action = new Actions(driver);
		action.moveToElement(textEditor).click().sendKeys("print('Good bye')").build().perform();;
		webClick.webClickAll(runBtn, driver);
		return true;
		
	}

//	public static void main(String[] args) throws InterruptedException 
//	{
//		LandingPage landingPage = new LandingPage();
//		landingPage.lunchApp();
//		landingPage.clickOnGetStarted();
//		HomePage hmp = new HomePage(landingPage.getDriver());
//		hmp.clickSignIn();
//		LogInPage logInPage = new LogInPage(landingPage.getDriver());
//		;
//		logInPage.signIn("Priya.Acharya", "Pwd@1234");
//
//		GraphPage gp = new GraphPage(landingPage.getDriver());
//
//		gp.graphPageOpen();
//		gp.clickGraphBtn();
//		gp.clickTryBtn();
//		gp.addTextTryEditor();
//
//	}
}
