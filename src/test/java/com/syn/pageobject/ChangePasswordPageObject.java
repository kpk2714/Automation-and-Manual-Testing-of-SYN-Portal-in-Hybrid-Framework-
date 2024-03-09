package com.syn.pageobject;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.syn.uistore.ChangePasswordPage;
import com.syn.utilities.ExcelReader;
import com.syn.utilities.LoggerHandler;
import com.syn.utilities.WebDriverHelper;

public class ChangePasswordPageObject {

	ChangePasswordPage changepasswordpage = new ChangePasswordPage();
	
	String path = System.getProperty("user.dir")+"/TestData/testdata.xlsx";
	ExcelReader reader = new ExcelReader();
	
	public void enterNewPassword(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String password = reader.readDataFromExcel(path, "SYN", 2, 4);

			helper.ElementToBeClickable(changepasswordpage.password, 20);
			Thread.sleep(2000);
			helper.ClickOnElement(changepasswordpage.password);
			Thread.sleep(2000);
			helper.SendKeys(changepasswordpage.password, password);
			
			test.pass("Enter New Password Successed.");
			LoggerHandler.logInfo("Enter New Password Successed.");
		}
		catch(Exception e) {
			test.fail("Enter New Password Failed.");
			LoggerHandler.logError("Enter New Password Failed.");
			e.getMessage();
		}
	}
	
	public void enterConfirmPassword(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String confirmPassword = reader.readDataFromExcel(path, "SYN", 3, 4);

			helper.ElementToBeClickable(changepasswordpage.confirmPassword, 20);
			helper.ClickOnElement(changepasswordpage.confirmPassword);
			helper.SendKeys(changepasswordpage.confirmPassword, confirmPassword);
			
			test.pass("Enter Confirm Password Successed.");
			LoggerHandler.logInfo("Enter Confirm Password Successed.");
		}
		catch(Exception e) {
			test.fail("Enter Confirm Password Failed.");
			LoggerHandler.logError("Enter Confirm Password Failed.");
			e.getMessage();
		}
	}
	
	
	public void clickOnSubmit(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElementToBeClickable(changepasswordpage.submit, 20);
			helper.ClickOnElement(changepasswordpage.submit);
			
			test.pass("Click on Submit Successed.");
			LoggerHandler.logInfo("Click on Submit Successed.");
		}
		catch(Exception e) {
			test.fail("Click on Submit Failed.");
			LoggerHandler.logError("Click on Submit Failed.");
			e.getMessage();
		}
	}
}
