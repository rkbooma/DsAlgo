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
import com.dsalgo.util.RandomString;

public class RegisterTest extends DsAlgoBase{
		RegisterPage registerPage;
		HomePage homePage;
		PortalPage portalPage;
		static String user = null;
		
		public RegisterTest() {
			super();
		}

		@BeforeClass
		public void setUp() {
			initialization();
			registerPage = new RegisterPage();
			homePage = new HomePage();
			portalPage = new PortalPage();
		}
		
		@Test(priority=1)
		public void registerUser_With_invalidDetails_With_emptyFieldTest() throws InterruptedException
		{
			portalPage.clickGetStarted();
			homePage.clickRegisterBtn();
			List<String> message = registerPage.registerUser_With_invalidDetails("","", "");
			if(!message.isEmpty())
				Assert.assertEquals(message.size(), 3,"This test case failed because it registered the user without giving user name, password, conf password. "
						+ "Whereas Gherkin says if the user id, password and confirm password is blank during registration, it whould throw validation error.");
			
		}
		@Test(priority=2)
		public void registerUser_With_invalidDetailsWith_No_PasswdTest() throws Exception
		{
			List<String> message = registerPage.registerUser_With_invalidDetails("RTYURRRRE","", "");
			if(!message.isEmpty())
				Assert.assertEquals(message.size(), 2,"Register user worked without mandatory fields");  //TO-DO
		}
		@Test(priority=3)
		public void registerUser_With_invalidDetails_With_No_confirmPasswdTest() throws InterruptedException
		{
			registerPage.clearUserName();
			List<String> message = registerPage.registerUser_With_invalidDetails("RTYURRRRE","Numpy1ninja", "");
			if(!message.isEmpty())
				Assert.assertEquals(message.size(), 1,"Register user worked without mandatory fields"); //TO-DO
		}
		@Test(priority=4)
		public void registerUser_With_invalidDetails_With_invalid_userName() throws InterruptedException
		{
			registerPage.clearUserName();
			registerPage.clearPasswd();
			List<String> message = registerPage.registerUser_With_invalidDetails("%,?{}:/|^","Numpy1ninja", "Numpy1ninja");
			if(!message.isEmpty())
				Assert.assertEquals(message.size(), 3,"Register user worked without mandatory fields"); //TO-DO
			
		}
		
		/*
		 * Password and confirm-password are different
		 */
		@Test(priority=5)
		public void registerUser_With_invalidDetails_With_diffPasswd() throws InterruptedException
		{
			registerPage.clearUserName();
			registerPage.clearPasswd();
			registerPage.clearConfPasswd();
			
			List<String> message = registerPage.registerUser_With_invalidDetails("RTYURRRRE","Numpy1ninja", "Nump23yninja");
			if(!message.isEmpty())
				Assert.assertEquals(message.size(), 3,"Register user worked without mandatory fields"); //TO-DO
		}
		@Test(priority=6)
		public void registerUser_With_invalidDetails_With_lessthan8characters_fPasswd() throws InterruptedException
		{
			registerPage.clearUserName();
			registerPage.clearPasswd();
			registerPage.clearConfPasswd();
			
			List<String> message = registerPage.registerUser_With_invalidDetails("RTYURRRRE","Dog12", "Dog12");
			if(!message.isEmpty())
				Assert.assertEquals(message.size(), 3,"Register user worked without mandatory fields"); //TO-DO
		}
		@Test(priority=7)
		public void registerUser_With_invalidDetails_With_Onlynumbersin_Passwd() throws InterruptedException
		{
			registerPage.clearUserName();
			registerPage.clearPasswd();
			registerPage.clearConfPasswd();
			
			List<String> message = registerPage.registerUser_With_invalidDetails("RTYURRRRE","1234", "1234");
			if(!message.isEmpty())
				Assert.assertEquals(message.size(), 2,"Register user worked without mandatory fields"); //TO-DO
		}
		@Test(priority=8)
		public void registerUser_With_correct_user_passwd() throws InterruptedException
		{
			registerPage.clearUserName();
			registerPage.clearPasswd();
			registerPage.clearConfPasswd();
			
			user = "Booma" + RandomString.getAlphaNumericString(5);
			
			registerPage.registerUser_With_validDetails(user,"Numpy1ninja", "Numpy1ninja");
			Thread.sleep(1000);
			String message = homePage.validateAccountCreated();
			Assert.assertEquals(message, prop.getProperty("registration.success.title")+user,prop.getProperty("registration.success.title.notFound"));
			System.out.println(user);
		}
			//New Account Created. You are logged in as Booma853
			
			@Test(priority=9)
			public void clickSignOutTest() throws InterruptedException {
				
				String message = homePage.signOut();
				Assert.assertEquals(message, prop.getProperty("signout.success.title"),prop.getProperty("signout.success.title.notFound"));
			}
			
			
			

		
		@AfterClass
		public void tearDown() throws InterruptedException{
			driver.quit();
		}
}
