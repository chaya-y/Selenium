package com.launchers;

public class TC1 extends BaseTest

{

	public static void main(String[] args) throws Exception {
		
		init();
		
		openBrowser("chromebrowser");
		
		navigateUrl("amazonurl");
 
		windowMaximize();
		
		getWindowTitle();
		String title = driver.getTitle();
		System.out.println(title);	
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
			
		deleteAllCookies();
		
		windowBack();
		
		Thread.sleep(5000);      //time for performing next task 5000ms=5sec
		
		windowForward();
		
		Thread.sleep(5000);
		
		windowRefresh();
		
		closeBrowser();
		
	}

}
