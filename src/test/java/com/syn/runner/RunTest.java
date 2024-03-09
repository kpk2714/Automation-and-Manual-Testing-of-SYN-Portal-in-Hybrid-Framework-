package com.syn.runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.syn.pageobject.ChangePasswordPageObject;
import com.syn.pageobject.ContactPageObject;
import com.syn.pageobject.DashboardPageObject;
import com.syn.pageobject.ForgotPasswordPageObject;
import com.syn.pageobject.HomePageObject;
import com.syn.pageobject.LoginPageObject;
import com.syn.pageobject.RegisterPageObject;
import com.syn.utilities.Base;
import com.syn.utilities.Reporter;

public class RunTest {

	WebDriver driver;
	Base base = new Base();
	ExtentReports reports;
	ExtentTest test;
	HomePageObject homepageObject = new HomePageObject();
	RegisterPageObject registerPageObject = new RegisterPageObject();
	LoginPageObject loginPageObject = new LoginPageObject();
	DashboardPageObject dashboardpageobject = new DashboardPageObject();
	ForgotPasswordPageObject forgotpasswordpageobject = new ForgotPasswordPageObject();
	ChangePasswordPageObject changepasswordpageobject = new ChangePasswordPageObject();
	ContactPageObject contactpageobject = new ContactPageObject();
	
	static int i = 1;
	static String testcaseName = "Verify the landing page is Home Page";
	
	@BeforeTest
	public void createReport() {
		reports = Reporter.getReport("syn");
	}
	
	@Parameters("browserName")
	@BeforeMethod
	public void openbrowser(String browserName) {
		test = reports.createTest("Test Cases "+i+" - "+testcaseName);
		i++;
		
		driver = base.openBrowser(browserName,test);
	}
	
	
	@Test(priority = 1,enabled = false)
	public void testcaseone() {
		
		homepageObject.verifyHomePage(driver, test);
		
		testcaseName = "Check User is registered or not .";
	}
	
	@Test(priority = 2,enabled = false)
	public void testcasetwo() {
		
		homepageObject.enterUserName(driver, test);
		homepageObject.enterMobile(driver, test);
		homepageObject.enterPincode(driver, test);
		homepageObject.findNameOfUser(driver, test);
		
		testcaseName = "Register User - Enter all details";
	}
	
	@Test(priority = 3,enabled = false)
	public void testcasethree() {
		
		homepageObject.clickOnRegister(driver, test);
		registerPageObject.enterName(driver, test);
		registerPageObject.enterEmail(driver, test);
		registerPageObject.clickOnEmailSendOtp(driver, test);
		registerPageObject.enterEmailVerifyOtp(driver, test);
		registerPageObject.clickEmailSubmit(driver, test);
		registerPageObject.verifyEmail(driver, test);
		
		registerPageObject.enterMobile(driver, test);
		registerPageObject.clickOnMobileSendOtp(driver, test);
		registerPageObject.enterMobileVerifyOtp(driver, test);
		registerPageObject.clickMobileSubmit(driver, test);
		registerPageObject.verifyMobile(driver, test);
		
		registerPageObject.chooseDOB(driver, test);
		
		registerPageObject.chooseState(driver, test);
		registerPageObject.chooseUniversity(driver, test);
		registerPageObject.chooseInstitution(driver, test);
		registerPageObject.chooseDepartment(driver, test);
		registerPageObject.chooseDegree(driver, test);
		registerPageObject.chooseYearOfStudy(driver, test);
		registerPageObject.chooseSemester(driver, test);
		registerPageObject.enterRegistrationNo(driver, test);
		registerPageObject.enterRollNo(driver, test);
		registerPageObject.chooseDistrict(driver, test);
		registerPageObject.enterPoliceStation(driver, test);
		registerPageObject.choosePostOffice(driver, test);
		registerPageObject.choosePinCode(driver, test);
		registerPageObject.enterAddress(driver, test);
		registerPageObject.enterUserName(driver, test);
		registerPageObject.enterPassword(driver, test);
		registerPageObject.enterRePassword(driver, test);
		registerPageObject.clickTermsAndCondition(driver, test);
		
		registerPageObject.clickOnSubmit(driver, test);
		registerPageObject.verifyRegistration(driver, test);
		
		testcaseName = "Clear Registration Form Data";
	}
	
	
	@Test(priority = 4,enabled = false)
	public void testcasefour() {
		homepageObject.clickOnRegister(driver, test);
		registerPageObject.enterName(driver, test);
		registerPageObject.enterEmail(driver, test);
		registerPageObject.chooseDOB(driver, test);
		registerPageObject.chooseState(driver, test);
		registerPageObject.chooseUniversity(driver, test);
		registerPageObject.chooseInstitution(driver, test);
		registerPageObject.chooseDepartment(driver, test);
		registerPageObject.chooseDegree(driver, test);
		registerPageObject.chooseYearOfStudy(driver, test);
		registerPageObject.chooseSemester(driver, test);
		registerPageObject.enterRegistrationNo(driver, test);
		registerPageObject.enterRollNo(driver, test);
		registerPageObject.chooseDistrict(driver, test);
		registerPageObject.enterPoliceStation(driver, test);
		registerPageObject.choosePostOffice(driver, test);
		registerPageObject.choosePinCode(driver, test);
		registerPageObject.enterAddress(driver, test);
		registerPageObject.enterUserName(driver, test);
		registerPageObject.enterPassword(driver, test);
		registerPageObject.enterRePassword(driver, test);
		registerPageObject.clickTermsAndCondition(driver, test);
		
		registerPageObject.clickOnClear(driver, test);
		
		testcaseName = "Login Functionality";
	}
	
	
	
	@Test(priority = 5,enabled = false)
	public void testcasefive() {
		homepageObject.clickOnLogin(driver, test);
		loginPageObject.enterUsername(driver, test);
		loginPageObject.enterPassword(driver, test);
		loginPageObject.clickSubmit(driver, test);
		dashboardpageobject.verifyDashboardPage(driver, test);
		
		testcaseName = "Logout - After Login";
	}
	
	
	@Test(priority = 6,enabled = false)
	public void testcasesix() {
		homepageObject.clickOnLogin(driver, test);
		loginPageObject.enterUsername(driver, test);
		loginPageObject.enterPassword(driver, test);
		loginPageObject.clickSubmit(driver, test);
		dashboardpageobject.clickOnLogout(driver, test);
		loginPageObject.verifyLogout(driver, test);
		
		
		testcaseName = "Display User's Details";
	}
	
	@Test(priority = 7,enabled = true)
	public void testcasenine() {
		homepageObject.clickOnLogin(driver, test);
		loginPageObject.enterUsername(driver, test);
		loginPageObject.enterPassword(driver, test);
		loginPageObject.clickSubmit(driver, test);
		
		dashboardpageobject.displaySYNId(driver, test);
		dashboardpageobject.displayName(driver, test);
		dashboardpageobject.displayEmail(driver, test);
		dashboardpageobject.displayMobile(driver, test);
		dashboardpageobject.displayDOB(driver, test);
		dashboardpageobject.displayUniversity(driver, test);
		dashboardpageobject.displayInstitution(driver, test);
		dashboardpageobject.displayDegree(driver, test);
		dashboardpageobject.displayDepartment(driver, test);
		dashboardpageobject.displaySemester(driver, test);
		dashboardpageobject.displayRegistrationNo(driver, test);
		dashboardpageobject.displayRollNo(driver, test);
		
		dashboardpageobject.displayState(driver, test);
		dashboardpageobject.displayDistrict(driver, test);
		dashboardpageobject.displayPoliceStation(driver, test);
		dashboardpageobject.displayPinCode(driver, test);
		dashboardpageobject.displayAddress(driver, test);
		
		
		testcaseName = "Forgot Password - Verify your Email First";
	}
	
	
	@Test(priority = 8,enabled = false)
	public void testcaseseven() {
		homepageObject.clickOnLogin(driver, test);
		loginPageObject.clickOnForgotPassword(driver, test);
		forgotpasswordpageobject.enterEmail(driver, test);
		forgotpasswordpageobject.clickOnSendOtp(driver, test);
		forgotpasswordpageobject.enterEmailVerifyOtp(driver, test);
		forgotpasswordpageobject.clickOnSubmit(driver, test);
		
		changepasswordpageobject.enterNewPassword(driver, test);
		changepasswordpageobject.enterConfirmPassword(driver, test);
		changepasswordpageobject.clickOnSubmit(driver, test);
		loginPageObject.verifyPasswordChange(driver, test);
		
		testcaseName = "Contact Us - Send an eamil";
	}
	
	
	@Test(priority = 9,enabled = false)
	public void testcaseeight() {
		homepageObject.clickOnContact(driver, test);
		contactpageobject.enterName(driver, test);
		contactpageobject.enterEmail(driver, test);
		contactpageobject.enterContent(driver, test);
		contactpageobject.clickSendMessage(driver, test);
		contactpageobject.verifyEmailSent(driver, test);
	}

	
	@AfterMethod
	public void exit() {
		driver.quit();
	}
	
	@AfterTest
	public void generateReport() {
		reports.flush();
	}
}
