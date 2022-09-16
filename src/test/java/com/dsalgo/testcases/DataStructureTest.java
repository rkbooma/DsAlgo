package com.dsalgo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dsalgo.dsbase.DsAlgoBase;
import com.dsalgo.pageObjects.DataStructurePage;
import com.dsalgo.pageObjects.HomePage;
import com.dsalgo.pageObjects.PortalPage;
import com.dsalgo.pageObjects.RegisterPage;
import com.dsalgo.pageObjects.SignInPage;
import com.dsalgo.util.DsAlgoUtil;


public class DataStructureTest extends DsAlgoBase{
	RegisterPage registerPage;
	HomePage homePage;
	PortalPage portalPage;
	SignInPage signinPage;
	DataStructurePage dataStructurePage;
	
	public DataStructureTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		registerPage = new RegisterPage();
		homePage = new HomePage();
		portalPage = new PortalPage();
		signinPage = new SignInPage();
		dataStructurePage = new DataStructurePage();
	}
	@Test(priority=1)
	public void click_Getstarted_below_DataStructureTest() throws InterruptedException
	{
		portalPage.clickGetStarted();
		homePage.displaysignIn();
		Thread.sleep(1000);
		signinPage.signIn_User_With_validDetails("TEST5678","asdfghjk1l");
		
		dataStructurePage.click_Getstarted_below_DataStructure();
		DsAlgoUtil.scroll(driver, 0, 350);
		
		
	}
	@Test(priority=2)
	public void click_timeComplexityTest() throws InterruptedException
	{
		dataStructurePage.click_timeComplexity();
	}
	@Test(priority=3)
	public void click_practiceQnsTest() throws InterruptedException
	{
		dataStructurePage.click_practiceQns();
		Thread.sleep(2000);
		driver.navigate().back();
		DsAlgoUtil.scroll(driver, 0, 350);
		
		
	}
	@Test(priority=4)
	public void click_tryHereTest() throws InterruptedException
	{
		dataStructurePage.click_tryHere();
	}
	@Test(priority=5)
	public void sendCodeTest() throws InterruptedException
	{
		dataStructurePage.sendCode();
		dataStructurePage.clickRun_btn();
		Thread.sleep(2000);
		driver.navigate().back();
	}
	@Test(priority=6)
	public void signOut_from_dataStructurePage_Test() throws InterruptedException
	
	{	
		String message = homePage.signOut();
		Assert.assertEquals(message, prop.getProperty("signout.success.title"),prop.getProperty("signout.success.title.notFound"));
		}	
	@AfterClass
	public void tearDown() throws InterruptedException{
		driver.quit();
	}
	
	
	

}
