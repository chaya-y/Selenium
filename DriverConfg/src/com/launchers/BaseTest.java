package com.launchers;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class BaseTest {
	
	public static WebDriver driver;
	public static String projectPath=System.getProperty("user.dir"); 
	public static Properties p;
	public static FileInputStream fis;
	public static Properties mainProp;
	public static Properties childProp;
	
	public static void init() throws Exception {
		
		//FileInputStream fis=new FileInputStream(F:\\chaya\\Eclipse\\DriverConfg\\data.properties);--->static declaration
		fis = new FileInputStream(projectPath+"\\data.properties"); //dynamic declaration
		p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectPath +"\\env.properties");
		mainProp = new Properties();
		mainProp.load(fis);
		String e = mainProp.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectPath +"\\"+e+".properties");
		childProp = new Properties();
		childProp.load(fis);
		System.out.println(childProp.getProperty("amazonurl"));
	}
	
	
	public static void openBrowser(String browser)
	{
		if(p.getProperty(browser).equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(p.getProperty(browser).equals("firefox")) {
			
			ProfilesIni p=new ProfilesIni();
			FirefoxProfile profile = p.getProfile("seleniumProfile");
			
			FirefoxOptions option=new FirefoxOptions();
			option.setProfile(profile);
			driver=new FirefoxDriver(option); //we have to pass the argument for fireforx constructor as a argument

		}
			
	}

	public static void navigateUrl(String url)
	{
		//driver.get(childProp.getProperty(url)); //its checks the server to load the url every tym
		driver.navigate().to(childProp.getProperty(url)); //first tym it checks the server to load the url but second tym onwards it checks the local cache to load the url 
	}
	
	public static void windowMaximize() {
		
		driver.manage().window().maximize();
		
	}
	
	public static String getWindowTitle() {
	
		String title=driver.getTitle();			//this method is returning the string type 
		return title;
	}
	
	public static String getCurrentUrl() {
		
		String url = driver.getCurrentUrl();
		return url;
		
	}
	
	public static void deleteAllCookies() {
		
		driver.manage().deleteAllCookies();
	}

	public static void windowBack() {
		
		driver.navigate().back(); //backward
		
	}
	
	public static void windowForward() {
		
		driver.navigate().forward(); //forward
		
	}
	
	public static void windowRefresh() {
		
		driver.navigate().refresh(); //refresh
		
	}
	
	public static void closeBrowser() {
	
		//driver.close(); //to close active current window,(it only close the window it will nt kill the driver services)
		
		driver.quit();  //to close all consecutive windows open by webdriver(it will kill)
		
	}
	 
}
