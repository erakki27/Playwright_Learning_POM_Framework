package com.qa.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.amazon.base.BaseTest;
import com.qa.amazon.constants.AppConstant;

public class HomePageTest extends BaseTest{
	
	@Test
	public void homePageTitleTest() {
		String actualTitle = homepage.getHomePageTitle();
		//Assert.assertEquals(actualTitle, "Amazon.com");
		Assert.assertTrue(actualTitle.contains(AppConstant.PAGE_TITLE));
	}
	
	@Test
	public void homePageUrlTest() {
		String actualUrl = homepage.getHomepageUrl();
		Assert.assertEquals(actualUrl, prop.getProperty("url"));
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{ "watch" },
			//{ "tshirt" },
			{ "iphone" }
			
		};
		
	}
	
	@Test(dataProvider = "getProductData")
	public void searchTest(String productName) throws InterruptedException {
		Thread.sleep(5000);
		String actualsearchedHeader = homepage.doSearch(productName);
		Assert.assertTrue(actualsearchedHeader.contains(productName));
	}

}
