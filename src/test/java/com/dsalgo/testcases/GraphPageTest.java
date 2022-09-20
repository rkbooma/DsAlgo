package com.dsalgo.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dsalgo.dsbase.DsAlgoBase;
import com.dsalgo.pageObjects.GraphPage;
import com.dsalgo.pageObjects.HomePage;
import com.dsalgo.pageObjects.PortalPage;
import com.dsalgo.pageObjects.SignInPage;

public class GraphPageTest {
	GraphPage gp;
	
	DsAlgoBase algoBase;
	HomePage homePage;

	
	@BeforeClass
	public void beforeClass() throws InterruptedException {
//		landingPage = new LandingPage();
//		landingPage.lunchApp();
//		landingPage.clickOnGetStarted();
//		hmp = new HomePage(landingPage.getDriver());
//		hmp.clickSignIn();
//		LogInPage logInPage = new LogInPage(landingPage.getDriver());
//		logInPage.signIn("Priya.Acharya", "Pwd@1234");
//		gp = new GraphPage(landingPage.getDriver());
		
		algoBase = new DsAlgoBase();
		DsAlgoBase.initialization();
		PortalPage portalPage = new PortalPage();
		portalPage.clickGetStarted();
		gp = new GraphPage(DsAlgoBase.driver);
		
		homePage = new HomePage();
		homePage.displaysignIn();
		SignInPage signInPage = new SignInPage();
		signInPage.signIn_User_With_validDetails("Priya.Acharya","Pwd@1234");

	}

	
	@Test(priority = 1)
	public void graphPageOpenTest() throws InterruptedException {
		String gpTitel = gp.graphPageOpen();
		assertEquals(gpTitel, "Graph");

	}

	@Test(priority = 2)
	public void clickGraphBtnTest() throws InterruptedException {
		gp.clickGraphBtn();
		assertTrue(true);
	}

	

	@Test(priority = 3)
	public void clickTryBtnTest_graph() throws InterruptedException {
		boolean result = gp.clickTryBtn();
		assertEquals(result, true);

	}

	@Test(priority = 4)
	public void addTextTryEditorTest_graph() {
		gp.addTextTryEditor();
		assertTrue(true);
	}
		

	
	@Test(priority = 5)
	public void clickGraphRepresenBtnTest() throws InterruptedException {
		DsAlgoBase.driver.navigate().back();	
		DsAlgoBase.driver.navigate().back();
		String gpTitel=gp.clickGraphRepresenBtn();
		assertEquals(gpTitel, "Graph Representations");
		assertTrue(true);
	}

	
	@Test(priority = 7)
	public void clickTryBtnTest_GraphRepres() throws InterruptedException {
		boolean result = gp.clickTryBtn();
		assertEquals(result, true);

	}

	@Test(priority = 8)
	public void addTextTryEditorTest__GraphRepres() {
		gp.addTextTryEditor_clickTryBtnTest_GraphRepres();
		assertTrue(true);
	}

	@Test(priority = 9)
	public void signOut_from_graph_Test() throws InterruptedException

	{
		DsAlgoBase.driver.navigate().back();
		homePage.signOut();
		// Assert.assertEquals(message,
		// prop.getProperty("signout.success.title"),prop.getProperty("signout.success.title.notFound"));
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		DsAlgoBase.driver.quit();
	}

}
