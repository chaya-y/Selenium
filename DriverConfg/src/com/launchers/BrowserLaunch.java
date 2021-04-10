package com.launchers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch {

	public static void main(String[] args) {
		
		 WebDriver driver;
		 
		//System.setProperty("webdriver.chrome.driver", "F:\\chaya\\Selenium drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.ebay.in");
		
		//System.setProperty("webdriver.chrome.driver","F:\\chaya\\Selenium drivers\\geckodriver.exe");
		 driver=new FirefoxDriver();
		 driver.get("https://www.amazon.in");

	}

}
