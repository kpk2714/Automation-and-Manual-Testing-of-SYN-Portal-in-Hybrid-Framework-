package com.syn.pageobject;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.syn.uistore.HomePage;
import com.syn.utilities.ExcelReader;
import com.syn.utilities.LoggerHandler;
import com.syn.utilities.Screenshot;
import com.syn.utilities.WebDriverHelper;

public class HomePageObject {

	HomePage homepage = new HomePage();
	String path = System.getProperty("user.dir")+"/TestData/testdata.xlsx";
	ExcelReader reader = new ExcelReader();
	
	public void verifyHomePage(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(homepage.name,20);
			String text = helper.GetText(homepage.name);
			
			String data = reader.readDataFromExcel(path, "SYN", 1, 0);
			
			if(text.equalsIgnoreCase(data)) {
				String ss = Screenshot.GetScreenshot(driver,"homepage-verify-");
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(ss,"Landing Page is Home Page").build());
				LoggerHandler.logInfo("Landing Page is Home Page");
			}
			else {
				String ss = Screenshot.GetScreenshot(driver,"homepage-verify-");
				test.fail(MediaEntityBuilder.createScreenCaptureFromPath(ss,"Landing Page is not Home Page").build());
				LoggerHandler.logError("Landing Page is Not Home Page");
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void enterUserName(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String username = reader.readDataFromExcel(path, "SYN", 1, 1);
			
			helper.ElementToBeClickable(homepage.userName,20);
			helper.ClickOnElement(homepage.userName);
			helper.SendKeys(homepage.userName, username);
			test.pass("Enter Username "+username+" Successed .");
			LoggerHandler.logInfo("Enter Username "+username+" Successed .");
		}
		catch(Exception e) {
			test.fail("Enter Username Failed .");
			LoggerHandler.logError("Enter Username Failed .");
			e.getMessage();
		}
	}
	
	public void enterMobile(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String mobile = "8016199829";
			
			helper.ElementToBeClickable(homepage.mobile,20);
			helper.ClickOnElement(homepage.mobile);
			helper.SendKeys(homepage.mobile, mobile);
			test.pass("Enter Mobile "+mobile+" Successed .");
			LoggerHandler.logInfo("Enter Mobile "+mobile+" Successed .");
		}
		catch(Exception e) {
			test.fail("Enter Mobile Failed .");
			LoggerHandler.logError("Enter Mobile Failed .");
			e.getMessage();
		}
	}
	
	public void enterPincode(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 3, 1);
			String pin = "";
			for(int i=0;i<data.length()-2;i++) {
				pin = pin + data.charAt(i);
			}
			
			helper.ElementToBeClickable(homepage.pin,20);
			helper.ClickOnElement(homepage.pin);
			helper.SendKeys(homepage.pin, pin);
			test.pass("Enter Pincode "+pin+" Successed .");
			LoggerHandler.logInfo("Enter Pincode "+pin+" Successed .");
		}
		catch(Exception e) {
			test.fail("Enter Pincode Failed .");
			LoggerHandler.logError("Enter Pincode Failed .");
			e.getMessage();
		}
	}
	
	public void findNameOfUser(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(homepage.findName,5);
			String name = helper.GetText(homepage.findName);
			test.pass("User Registered and Name is "+name);
			LoggerHandler.logInfo("User Registered and Name is "+name);
		}
		catch(Exception e) {
			test.fail("User Not Registered .");
			LoggerHandler.logError("User Not Registered .");
		}
	}
	
	
	public void clickOnRegister(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(homepage.register,20);
			helper.ClickOnElement(homepage.register);
			test.pass("Click on Register Successed .");
			LoggerHandler.logInfo("Click on Register Successed .");
		}
		catch(Exception e) {
			test.fail("Click on Register Failed .");
			LoggerHandler.logError("Click on Register Failed .");
		}
	}
	
	
	public void clickOnLogin(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(homepage.login,20);
			helper.ClickOnElement(homepage.login);
			test.pass("Click on Login Successed .");
			LoggerHandler.logInfo("Click on Login Successed .");
		}
		catch(Exception e) {
			test.fail("Click on Login Failed .");
			LoggerHandler.logError("Click on Login Failed .");
		}
	}
	
	
	public void clickOnContact(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(homepage.contact,20);
			helper.ClickOnElement(homepage.contact);
			test.pass("Click on Contact Successed .");
			LoggerHandler.logInfo("Click on Contact Successed .");
		}
		catch(Exception e) {
			test.fail("Click on Contact Failed .");
			LoggerHandler.logError("Click on Contact Failed .");
		}
	}
}
