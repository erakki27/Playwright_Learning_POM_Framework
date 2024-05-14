package com.qa.amazon.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	
	//1. String Locator
	private String emailId ="#ap_email";
	private String continueButton ="#continue";
	private String password ="#ap_password";
	private String signInButton ="#signInSubmit";
	private String Account ="span[class='nav-line-2 ']";
	private String welcome ="#nav-link-accountList-nav-line-1";
	
	//2 Page constructor
	
	public LoginPage(Page page) {
		this.page=page;
		
	}
	
	// 3 Page Action/method
	
	public String getLoginPageTitle() {
		return page.title();
	}
	
	public String doSingIn(String Username, String Password) {
		page.fill(emailId, Username);
		page.click(continueButton);
		page.fill(password, Password);
		page.click(signInButton);
		page.locator(welcome).waitFor();
		String content = page.textContent(welcome);
		
		return content;
	}

}
