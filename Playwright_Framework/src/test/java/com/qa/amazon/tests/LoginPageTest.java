package com.qa.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.amazon.base.BaseTest;
import com.qa.amazon.constants.AppConstant;

public class LoginPageTest extends BaseTest{
	
	
	@Test(priority=1)
	public void signInPagenavigationtest() throws InterruptedException {
		loginpage = homepage.navigateToSignIn();
		Thread.sleep(5000);
		String actualLoginPageTitle = loginpage.getLoginPageTitle();
		System.out.println("page actual title is  " +actualLoginPageTitle);
		Assert.assertEquals(actualLoginPageTitle, AppConstant.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void signInTest() {
		
		String actualContent=loginpage.doSingIn(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	    Assert.assertEquals(actualContent, AppConstant.LOGIN_ACCOUNT_CONTENT);
		
		
	}

}
