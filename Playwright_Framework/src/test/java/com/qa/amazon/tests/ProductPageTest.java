package com.qa.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.amazon.base.BaseTest;
import com.qa.amazon.constants.AppConstant;

public class ProductPageTest extends BaseTest{
	
	@Test(priority=1)
	public void navigateToProductsPage() throws InterruptedException {
		productpage=homepage.navigateToProductPage("mobile");
		Thread.sleep(5000);
		String actualproductPageTitle = productpage.getProductPageTitle();
		System.out.println("page actual title is  " +actualproductPageTitle);
		Assert.assertTrue(actualproductPageTitle.contains(AppConstant.PRODUCT_PAGE_TITLE));
		
	}
	
	@Test(priority=2)
	public void clickonproductTestAndAddToCart() throws InterruptedException {
		productpage.newwindowcart();
		Thread.sleep(5000);
	}
	

}
