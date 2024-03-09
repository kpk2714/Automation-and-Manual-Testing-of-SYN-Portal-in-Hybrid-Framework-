package com.syn.pageobject;

import java.util.List;
import java.util.Properties;

import javax.mail.Store;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.aventstack.extentreports.ExtentTest;
import com.syn.uistore.ContactPage;
import com.syn.utilities.ExcelReader;
import com.syn.utilities.LoggerHandler;
import com.syn.utilities.PropertyReader;
import com.syn.utilities.WebDriverHelper;
import com.testing.framework.EmailUtils;

public class ContactPageObject {

	ContactPage contactpage = new ContactPage();
	
	String path = System.getProperty("user.dir")+"/TestData/testdata.xlsx";
	ExcelReader reader = new ExcelReader();
	
	public void enterName(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String name = reader.readDataFromExcel(path, "SYN", 1, 5);
			
			helper.ElementToBeClickable(contactpage.name, 20);
			helper.ClickOnElement(contactpage.name);
			helper.SendKeys(contactpage.name, name);
			
			test.pass("Enter Name Successed .");
			LoggerHandler.logInfo("Enter Name Successed .");
		}
		catch(Exception e) {
			test.fail("Enter Name Failed .");
			LoggerHandler.logError("Enter Name Failed .");
			e.getMessage();
		}
	}
	
	public void enterEmail(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String email = reader.readDataFromExcel(path, "SYN", 2, 5);
			
			helper.ElementToBeClickable(contactpage.email, 20);
			helper.ClickOnElement(contactpage.email);
			helper.SendKeys(contactpage.email, email);
			
			test.pass("Enter Email Successed .");
			LoggerHandler.logInfo("Enter Email Successed .");
		}
		catch(Exception e) {
			test.fail("Enter Email Failed .");
			LoggerHandler.logError("Enter Email Failed .");
			e.getMessage();
		}
	}
	
	public void enterContent(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String content = reader.readDataFromExcel(path, "SYN", 3, 5);
			
			helper.ElementToBeClickable(contactpage.content, 20);
			helper.ClickOnElement(contactpage.content);
			helper.SendKeys(contactpage.content, content);
			
			test.pass("Enter Content Successed .");
			LoggerHandler.logInfo("Enter Content Successed .");
		}
		catch(Exception e) {
			test.fail("Enter Content Failed .");
			LoggerHandler.logError("Enter Content Failed .");
			e.getMessage();
		}
	}
	
	public void clickSendMessage(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElementToBeClickable(contactpage.sendMessage, 20);
			helper.ClickOnElement(contactpage.sendMessage);
			
			test.pass("Click on Send Message Successed .");
			LoggerHandler.logInfo("Click on Send Message Successed .");
		}
		catch(Exception e) {
			test.fail("Click on Send Message Failed .");
			LoggerHandler.logError("Click on Send Message Failed .");
			e.getMessage();
		}
	}
	
	public void verifyEmailSent(WebDriver driver,ExtentTest test) {
		try {
			String verifyMessage = reader.readDataFromExcel(path, "SYN", 4, 5);
			
			Screen screen = new Screen();
			Pattern pattern = new Pattern("C:\\Users\\hp\\OneDrive\\Desktop\\AngularProject\\FontEndAutomationTesting\\com.syn\\SkiuliImages\\mailsent.PNG");
			
			screen.wait(pattern,20);
			String text = screen.find(pattern).text();
			if(text.contains(verifyMessage)) {
				test.pass("Email Sent Successfully");
				LoggerHandler.logInfo("Email Sent Successfully");
			}
			else {
				test.fail("Sent Email Failed");
				LoggerHandler.logError("Sent Email Failed");
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
}
