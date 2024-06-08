package com.qa.amazon.pages;

import com.microsoft.playwright.Page;

public class AddProductPage {


	private Page page;
	
	//1 Locators
	private String selectProduct ="//*[contains(text(),'Redmi')]";
	private String search = "#twotabsearchtextbox";
	private String searchIcon = "#nav-search-submit-button";
	private String buyingOption ="a[title='See All Buying Options']";
	private String buyOptionCart ="//span[@id='a-autoid-2-offer-1']";
	private String newtabAddtoCart ="(//input[@id='add-to-cart-button'])[2]";
	private String cart="#nav-cart-count";
	
	
	//2 Page constructor
	
    public AddProductPage(Page page) {
	this.page=page;
		
	}
    
    public String getProductPageTitle() {
		return page.title();
	}

 public void searchAProduct(String product) {
	 page.fill(search, product);
	 page.click(searchIcon);
	 
 }
 
 public void addproducttoCart() {
	 page.click(newtabAddtoCart);
 }
 
 public void newwindowcart() { 
    Page cartWindow = page.waitForPopup(() ->{
 page.locator(selectProduct).nth(1).click();
});
    cartWindow.waitForLoadState();
    if(cartWindow.locator(newtabAddtoCart).isHidden()) {
    	cartWindow.click(buyingOption);
    	cartWindow.click(buyOptionCart);
    }else {
    cartWindow.locator(newtabAddtoCart).click();
    }
    cartWindow.close();
 }
 
 public CartPage navigatetocar() {
	 page.click(cart);
	 return new CartPage(page);
 }
}
