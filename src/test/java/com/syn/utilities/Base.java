package com.syn.utilities;

import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentTest;

public class Base {

	WebDriver driver;
	static Logger logger = LoggerHandler.InitLogger();

	public WebDriver openBrowser(String browserName,ExtentTest test) {
		try {
			
			String path = System.getProperty("user.dir")+"/Config/browser.properties";
			FileReader fr = new FileReader(path);
			Properties prop = new Properties();
			prop.load(fr);
			
			if(prop.getProperty("browserName1").equalsIgnoreCase(browserName)) {
				ChromeOptions option = new ChromeOptions();
				option.addArguments("incognito");
				driver = new ChromeDriver(option);
				LoggerHandler.logInfo("Chrome Browser Launched Successed .");
				test.pass("Chrome Browser Launched Successed .");
				
				driver.get(prop.getProperty("url"));
				LoggerHandler.logInfo("Application Open in Chrome Browser Successed .");
				test.pass("Application Open in Chrome Browser Successed .");
				driver.manage().window().maximize();
			}
			else if(prop.getProperty("browserName2").equalsIgnoreCase(browserName)) {
				EdgeOptions option = new EdgeOptions();
				option.addArguments("incognito");
				driver = new EdgeDriver(option);
				LoggerHandler.logInfo("Microsoft Edge Browser Launched Successed .");
				test.pass("Microsoft Edge Browser Launched Successed .");
				
				driver.get(prop.getProperty("url"));
				LoggerHandler.logInfo("Application Open in Microsoft Edge Browser Successed .");
				test.pass("Application Open in Microsoft Edge Browser Successed .");
				driver.manage().window().maximize();
			}
			else if(prop.getProperty("browserName3").equalsIgnoreCase(browserName)) {
//				FirefoxOptions option = new FirefoxOptions();
//				option.addArguments("incognito");
				driver = new FirefoxDriver();
				LoggerHandler.logInfo("Firefox Browser Launched Successed .");
				test.pass("Firefox Browser Launched Successed .");
				
				driver.get(prop.getProperty("url"));
				LoggerHandler.logInfo("Application Open in Firefox Browser Launched Successed .");
				test.pass("Application Open in Firefox Browser Successed .");
				driver.manage().window().maximize();
			}
			else {
				LoggerHandler.logError("Browser Launched Failed .");
				LoggerHandler.logError("Application Open Failed .");
				test.fail("Browser Launched Failed .");
				test.fail("Application Open Failed .");
			}
			
		}
		catch(Exception e) {
			e.getMessage();
		}
		return driver;

	}
}