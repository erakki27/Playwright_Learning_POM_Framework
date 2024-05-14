package com.qa.amazon.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

	Playwright playwright;
	Browser browser;
	BrowserContext browsercontext;
	static Page page;
	Properties prop;
	
	public Page initBrowser(Properties prop) {
		String browserName= prop.getProperty("browser").trim();
		System.out.println("Browser name is : " +browserName);
		
		playwright=Playwright.create();
		switch(browserName.toLowerCase()) {
		case "chromium" :
			browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "fireforx" :
			browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "safari" :
			browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "chrome" :
			browser=playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		default :
			System.out.println("please pass the right browser name......");
			break;
		
		}
		
		browsercontext=browser.newContext();
		
		page= browsercontext.newPage();
		page.navigate(prop.getProperty("url").trim());
		return page;
		
	}
	
	//method is used to initialize the properties from config file
	public Properties initi_prop() {
		try{
			FileInputStream ip = new FileInputStream("./src/test/resource/config/config.properties");
			prop = new Properties();
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}
	
	/**
	 * take screenshot
	 * 
	 */

	public static String takeScreenshot() {
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		//getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		
		byte[] buffer = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		String base64Path = Base64.getEncoder().encodeToString(buffer);
		
		return base64Path;
	}
}
