package com.qa.amazon.pages;

import com.microsoft.playwright.Page;

public class AddProductPage {


	private Page page;
	
	//1 Locators
	private String selectProduct ="";
	private String search = "#twotabsearchtextbox";
	private String searchIcon = "#nav-search-submit-button";
	private String addtoCart ="#a-autoid-10-announce";
	private String newtabAddtoCart ="#add-to-cart-button";
	
	
	//2 Page constructor
	
public AddProductPage(Page page) {
	this.page=page;
		
	}

 public void searchAProduct(String product) {
	 page.fill(search, product);
	 page.click(searchIcon);
	 
 }
 
 public void addproducttoCart() {
	 page.click(addtoCart);
 }
 
 public void newwindowcart() {
	 page.click(selectProduct);
 }

}
