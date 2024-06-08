package com.qa.amazon.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.amazon.factory.PlaywrightFactory;
import com.qa.amazon.pages.AddProductPage;
import com.qa.amazon.pages.HomePage;
import com.qa.amazon.pages.LoginPage;

public class BaseTest {
	
	PlaywrightFactory pf;
	Page page;
	protected Properties prop;
	protected HomePage homepage;
	protected LoginPage loginpage;
	protected AddProductPage productpage;
	
	@BeforeTest
	public void setup() {
		pf = new PlaywrightFactory();
		prop =pf.initi_prop();
		page= pf.initBrowser(prop);
		homepage = new HomePage(page);
		
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
