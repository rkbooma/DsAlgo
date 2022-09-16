package com.dsalgo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsalgo.dsbase.DsAlgoBase;
import com.dsalgo.pageObjects.PortalPage;

public class PortalTest extends DsAlgoBase {

	PortalPage portalPage;
	
	public PortalTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		portalPage = new PortalPage();
	}
	
	@Test(priority=1)
	public void clickGetStartedTest() throws InterruptedException{
		String homePageTitle = portalPage.clickGetStarted();
		Assert.assertEquals(homePageTitle, prop.getProperty("app.title"),prop.getProperty("app.title.notFound"));
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException{
		driver.quit();
	}
}
