package com.dsalgo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dsalgo.dsbase.DsAlgoBase;
import com.dsalgo.pageObjects.HomePage;
import com.dsalgo.pageObjects.PortalPage;

//@Listeners(DsAlgoListener.class)

public class HomeTest extends DsAlgoBase {

	HomePage homePage;
	PortalPage portalPage;
	String user = null;
	
	public HomeTest() {
		super();
	}

	
	@BeforeClass
	public void setUp() {
		initialization();
		homePage = new HomePage();
		portalPage = new PortalPage();
	}
	

	
	@Test(priority=1)
	public void getPaneCountTest() throws InterruptedException
	{
		portalPage.clickGetStarted();
		int paneCount = homePage.getPaneCount();
		Assert.assertEquals(paneCount, Integer.valueOf(prop.getProperty("pane.count")));
	}
	
	@Test(priority=2)
	public void getDropDownListCountTest() throws InterruptedException
	{
		int dropDownListCount = homePage.getDropDownListCount();
		Assert.assertEquals(dropDownListCount, Integer.valueOf(prop.getProperty("dropdown.list.count")),
				prop.getProperty("dropdown.list.count.not.matching"));
	}
	
	@Test(priority=3)
	public void getStartedFromPaneTest() throws InterruptedException
	{
		homePage.getStartedFromPane("Data-structure");
		String loginAlertTxt = homePage.locateLoginAlertText();
		Assert.assertEquals(loginAlertTxt, prop.getProperty("login.alert.text"),prop.getProperty("login.alert.text.not.displayed"));
	}
	
	@Test(priority=4)
	public void getStartedFromDropDownTest() throws InterruptedException
	{
		homePage.getStartedFromDropDown();
		String loginAlertTxt = homePage.locateLoginAlertText();
		Assert.assertEquals(loginAlertTxt, prop.getProperty("login.alert.text"),prop.getProperty("login.alert.text.not.displayed"));
	}
	
	@Test(priority=5)
	public void displaySignInTest() throws InterruptedException
	{
		homePage.displaysignIn();
		String loginText = homePage.locateLogin();
		Assert.assertEquals(loginText, prop.getProperty("login.page.title"),prop.getProperty("login.page.title.not.displayed"));
	}
	@Test(priority=6)
	public void clickRegbtnTest() throws InterruptedException
	{
		String registartionPageTitle=homePage.clickRegisterBtn();
		Assert.assertEquals(registartionPageTitle, prop.getProperty("regis.title"),prop.getProperty("regis.title.notFound"));
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException{
		driver.quit();
	}
}
