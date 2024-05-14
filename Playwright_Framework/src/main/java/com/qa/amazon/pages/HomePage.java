package com.qa.amazon.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	private Page page;
	
	//1. String Locator--
	
	private String search = "#twotabsearchtextbox";
	private String searchIcon = "#nav-search-submit-button";
	private String searchTitle ="div[class='a-section a-spacing-small a-spacing-top-small']";
	private String Account ="span[class='nav-line-2 ']";
	private String signIn = ".nav-action-inner";
	
	//2. Page Constructor:
	
	public HomePage(Page page) {
		this.page=page;
		
	}
	
	//3 Page Methods/Actions
	
	public String getHomePageTitle() {
		String title = page.title();
		System.out.println("Page Title is : " +title);
		return title;
		
	}
	
	public String getHomepageUrl() {
		String url = page.url();
		System.out.println("Page Url is : " +url);
		return url;
	}

	public String doSearch(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
		String header= page.textContent(searchTitle);
		System.out.println("Searched header is : " +header);
		return header;
		
	}
	
	
	public LoginPage navigateToSignIn() {
		page.click(Account);
		return new LoginPage(page);
	}
	
	public AddProductPage navigateToProductPage(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
		return new AddProductPage(page);
	}
}
