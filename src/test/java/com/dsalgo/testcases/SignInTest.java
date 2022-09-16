package com.dsalgo.testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dsalgo.dsbase.DsAlgoBase;
import com.dsalgo.pageObjects.HomePage;
import com.dsalgo.pageObjects.PortalPage;
import com.dsalgo.pageObjects.RegisterPage;
import com.dsalgo.pageObjects.SignInPage;
import com.dsalgo.util.RandomString;


public class SignInTest extends DsAlgoBase {
	HomePage homePage;
	PortalPage portalPage;
	RegisterPage registerPage;
	SignInPage signinPage;
	String user = null;
	
	public SignInTest() {
		super();
	}

	
	@BeforeClass
	public void setUp() {
		initialization();
		registerPage = new RegisterPage();
		homePage = new HomePage();
		portalPage = new PortalPage();
		signinPage = new SignInPage();
	}
	
	@Test(priority=1)
	public void signIn_User_With_no_userpasswordTest() throws InterruptedException
	{
		
		portalPage.clickGetStarted();
		homePage.displaysignIn();
		List<String> message = signinPage.signIn_User_With_inValid_Details("","");
		if(!message.isEmpty())
			Assert.assertEquals(message.size(), 2, "This test case failed because the user signed in without giving user name, password");
	}	
	@Test(priority=2)
	public void signIn_User_With_noUname_Test() throws InterruptedException
	{	
		
		List<String> message = signinPage.signIn_User_With_inValid_Details("","Numpy1ninja");
		if(!message.isEmpty())
			Assert.assertEquals(message.size(), 1, "This test case failed because the user signed in without giving user name");
	}	
	
	@Test(priority=3)
	public void signIn_User_With_noPasswd_Test() throws InterruptedException
	
	{	
		signinPage.clearPasswd();
		user = "Booma" + RandomString.getAlphaNumericString(5);
		List<String> message = signinPage.signIn_User_With_inValid_Details(user,"");
		if(!message.isEmpty())
			Assert.assertEquals(message.size(), 1, "This test case failed because the user signed in without giving password");
	}	
	@Test(priority=4)
	public void signIn_User_With_invalid_Username_Password_Test() throws InterruptedException
	
	{	
		signinPage.clearUserName();
		List<String> message = signinPage.signIn_User_With_inValid_Details("Boomika","Numpy123");
		if(!message.isEmpty())
			Assert.assertEquals(message.size(), 2, "This test case failed because the user signed in with invalid user name and password");
	}	
	@Test(priority=5)
	public void signIn_User_With_valid_uName_Password_Test() throws InterruptedException
	
	{	
		signinPage.clearUserName();
		signinPage.clearPasswd();
		signinPage.signIn_User_With_validDetails(RegisterTest.user,"Numpy1ninja");
		Thread.sleep(3000);
		String message = homePage.validateAccountCreated();
		Assert.assertEquals(message, prop.getProperty("login.success.title"),prop.getProperty("login.success.title.notFound"));
		}	
	@Test(priority=6)
	public void signOut_fromSigninPage_Test() throws InterruptedException
	
	{	
		String message = homePage.signOut();
		Assert.assertEquals(message, prop.getProperty("signout.success.title"),prop.getProperty("signout.success.title.notFound"));
		}	
	@AfterClass
	public void tearDown() throws InterruptedException{
		driver.quit();
	}
}


