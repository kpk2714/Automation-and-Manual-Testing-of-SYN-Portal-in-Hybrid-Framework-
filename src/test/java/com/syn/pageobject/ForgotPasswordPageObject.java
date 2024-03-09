package com.syn.pageobject;

import java.util.List;
import java.util.Properties;

import javax.mail.Store;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.syn.uistore.ForgotPasswordPage;
import com.syn.utilities.ExcelReader;
import com.syn.utilities.LoggerHandler;
import com.syn.utilities.PropertyReader;
import com.syn.utilities.WebDriverHelper;
import com.testing.framework.EmailUtils;

public class ForgotPasswordPageObject {

	ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
	
	String path = System.getProperty("user.dir")+"/TestData/testdata.xlsx";
	ExcelReader reader = new ExcelReader();
	
	public void enterEmail(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String email = reader.readDataFromExcel(path, "SYN", 1, 4);
			
			helper.ElementToBeClickable(forgotPasswordPage.emailId, 20);
			helper.ClickOnElement(forgotPasswordPage.emailId);
			helper.SendKeys(forgotPasswordPage.emailId, email);
			
			test.pass("Enter Email Id Successed .");
			LoggerHandler.logInfo("Enter Email Id Successed .");
		}
		catch(Exception e) {
			test.fail("Enter Email Id Failed .");
			LoggerHandler.logError("Enter Email Id Failed .");
			e.getMessage();
		}
	}
	
	public void clickOnSendOtp(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);

			helper.ElementToBeClickable(forgotPasswordPage.sendOtp, 20);
			helper.ClickOnElement(forgotPasswordPage.sendOtp);
			
			test.pass("Click on Send OTP Successed .");
			LoggerHandler.logInfo("Click on Send OTP Successed .");
		}
		catch(Exception e) {
			test.fail("Click on Send OTP Failed .");
			LoggerHandler.logError("Click on Send OTP Failed .");
			e.getMessage();
		}
	}
	
	public void enterEmailVerifyOtp(WebDriver driver , ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElementToBeClickable(forgotPasswordPage.enterOtp, 20);
			helper.ClickOnElement(forgotPasswordPage.enterOtp);
			
			EmailUtils emailUtils = new EmailUtils();
			Properties prop = PropertyReader.getDotClickProperties();
			
			Store connection = emailUtils.connectToGmail(prop);

			List<String> emailText = emailUtils.getUnreadMessageByFromEmail(connection,"Inbox","onlineexamportalboot@gmail.com","OTP for changing password");
			
			String OTP = "";
			
			if(emailText.size()>1) {
				throw new Exception("No Email Received.");
			}
			else {
				String regex = "[^\\d]+";
				String[] otp = emailText.get(0).split(regex);
				OTP = OTP + otp[1];
			}
			
			helper.SendKeys(forgotPasswordPage.enterOtp, OTP);
			
			test.pass("Enter Email Verification OTP Successed .");
			LoggerHandler.logInfo("Enter Email Verification OTP Successed .");
		}
		catch(Exception e) {
			test.fail("Enter Email Verification OTP Failed .");
			LoggerHandler.logError("Enter Email Verification OTP Failed .");
			e.getMessage();
		}
	}
	
	public void clickOnSubmit(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);

			helper.ElementToBeClickable(forgotPasswordPage.submit, 20);
			helper.ClickOnElement(forgotPasswordPage.submit);
			
			test.pass("Click on Submit Successed .");
			LoggerHandler.logInfo("Click on Submit Successed .");
		}
		catch(Exception e) {
			test.fail("Click on Submit Failed .");
			LoggerHandler.logError("Click on Submit Failed .");
			e.getMessage();
		}
	}
	
	public void clickOnReSendOtp(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);

			helper.ElementToBeClickable(forgotPasswordPage.resendOtp, 20);
			helper.ClickOnElement(forgotPasswordPage.resendOtp);
			
			test.pass("Click on Re-Send OTP Successed .");
			LoggerHandler.logInfo("Click on Re-Send OTP Successed .");
		}
		catch(Exception e) {
			test.fail("Click on Re-Send OTP Failed .");
			LoggerHandler.logError("Click on Re-Send OTP Failed .");
			e.getMessage();
		}
	}
}
