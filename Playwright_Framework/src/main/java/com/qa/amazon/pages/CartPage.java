package com.qa.amazon.pages;

import com.microsoft.playwright.Page;

public class CartPage {
	private Page page;
	
	// 1. Locator
	
	private String emptyCart=".a-spacing-mini a-spacing-top-base";
	private String cartItem="#sc-subtotal-label-buybox";
	
	
  //2 constructor
	public CartPage(Page page) {
		this.page=page;
	}
	
	//3 Method
	
	public String getCartPageTitle() {
		String title = page.title();
		System.out.println("Page Title is : " +title);
		return title;
		
	}
	
	public String beforeproductaddCart() {
		String emptycontnet=page.locator(emptyCart).textContent();
		return emptycontnet;
		
	}
	
	public String afterproductCart() {
		return page.locator(cartItem).textContent();
	}

}
