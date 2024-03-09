package com.syn.pageobject;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.syn.uistore.LoginPage;
import com.syn.utilities.ExcelReader;
import com.syn.utilities.LoggerHandler;
import com.syn.utilities.WebDriverHelper;

public class LoginPageObject {

	LoginPage loginpage = new LoginPage();
	
	String path = System.getProperty("user.dir")+"/TestData/testdata.xlsx";
	ExcelReader reader = new ExcelReader();
	
	public void enterUsername(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String username = reader.readDataFromExcel(path,"SYN", 1, 3);
			
			helper.ElementToBeClickable(loginpage.username, 20);
			helper.ClickOnElement(loginpage.username);
			helper.SendKeys(loginpage.username, username);
			
			test.pass("Enter Username Successed .");
			LoggerHandler.logInfo("Enter Username Successed .");
		}
		catch(Exception e) {
			test.fail("Enter Username Failed .");
			LoggerHandler.logError("Enter Username Failed .");
			e.getMessage();
		}
	}
	
	public void enterPassword(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String password = reader.readDataFromExcel(path,"SYN", 2, 3);
			
			helper.ElementToBeClickable(loginpage.password, 20);
			helper.ClickOnElement(loginpage.password);
			helper.SendKeys(loginpage.password, password);
			
			test.pass("Enter Password Successed .");
			LoggerHandler.logInfo("Enter Password Successed .");
		}
		catch(Exception e) {
			test.fail("Enter Password Failed .");
			LoggerHandler.logError("Enter Password Failed .");
			e.getMessage();
		}
	}
	
	public void clickSubmit(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElementToBeClickable(loginpage.submit, 20);
			helper.ClickOnElement(loginpage.submit);
			
			test.pass("Click on Submit Successed .");
			LoggerHandler.logInfo("Click on Submit Successed .");
		}
		catch(Exception e) {
			test.fail("Click on Submit Failed .");
			LoggerHandler.logError("Click on Submit Failed .");
			e.getMessage();
		}
	}
	
	
	public void clickOnForgotPassword(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElementToBeClickable(loginpage.forgot, 20);
			helper.ClickOnElement(loginpage.forgot);
			
			test.pass("Click on Forgot Password Successed .");
			LoggerHandler.logInfo("Click on Forgot Password Successed .");
		}
		catch(Exception e) {
			test.fail("Click on Forgot Password Failed .");
			LoggerHandler.logError("Click on Forgot Password Failed .");
			e.getMessage();
		}
	}
	
	public void verifyPasswordChange(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String url = reader.readDataFromExcel(path, "SYN", 4, 4);
			
			Thread.sleep(3000);
			
			String text = helper.getUrl(driver);
			if(text.contains(url)) {
				test.pass("Password Chnaged Successfully");
				LoggerHandler.logInfo("Password Chnaged Successfully");
			}
			else {
				test.fail("Change Password Failed");
				LoggerHandler.logError("Change Password Failed");
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	
	public void verifyLogout(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String url = reader.readDataFromExcel(path, "SYN", 4, 4);
			
			Thread.sleep(3000);
			
			String text = helper.getUrl(driver);
			if(text.contains(url)) {
				test.pass("Logout Successed .");
				LoggerHandler.logInfo("Logout Successed .");
			}
			else {
				test.fail("Logout Failed .");
				LoggerHandler.logError("Logout Failed .");
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
}
