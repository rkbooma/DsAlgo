package com.dsalgo.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dsalgo.dsbase.DsAlgoBase;
import com.dsalgo.pageObjects.DataStructurePage;
import com.dsalgo.pageObjects.HomePage;
import com.dsalgo.pageObjects.LinkedListPage;
import com.dsalgo.pageObjects.PortalPage;
import com.dsalgo.pageObjects.RegisterPage;
import com.dsalgo.pageObjects.SignInPage;
import com.dsalgo.util.DsAlgoUtil;

public class LinkedListTest extends DsAlgoBase {
	RegisterPage registerPage;
	HomePage homePage;
	PortalPage portalPage;
	SignInPage signinPage;
	DataStructurePage dataStructurePage;
	LinkedListPage linkedListPage;
	
	public LinkedListTest() {
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
		linkedListPage = new LinkedListPage();
	}
	@Test(priority=1)
	public void click_Getstarted_below_LinkedListTest() throws InterruptedException
	{
		portalPage.clickGetStarted();
		homePage.displaysignIn();
		Thread.sleep(1000);
		signinPage.signIn_User_With_validDetails("TEST5678","asdfghjk1l");
		
		linkedListPage.click_Getstarted_below_LinkedListPage();
		DsAlgoUtil.scroll(driver, 0, 350);
		
		
	}
	@Test(priority=2)
	public void click_Introduction_Test() throws InterruptedException
	{
		linkedListPage.click_Introduction();
		DsAlgoUtil.scroll(driver, 0, 350);
		
	}
	@Test(priority=3)
	public void click_tryHere_Test() throws InterruptedException
	{
		linkedListPage.click_tryHere();
		
	}
	@Test(priority=5)
	public void sendCodeTest() throws InterruptedException
	{
		linkedListPage.sendCode();
		linkedListPage.clickRun_btn();
		Thread.sleep(2000);
		driver.navigate().back();
	}
	@Test(priority=6)
	public void click_createLinkedlist_Test() throws InterruptedException
	
	{
		linkedListPage.click_createLinkedlist();
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException{
		driver.quit();
	}
}
