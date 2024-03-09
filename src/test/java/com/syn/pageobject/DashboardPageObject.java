package com.syn.pageobject;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.syn.uistore.DashboardPage;
import com.syn.utilities.ExcelReader;
import com.syn.utilities.LoggerHandler;
import com.syn.utilities.WebDriverHelper;

public class DashboardPageObject {

	DashboardPage dashboardPage = new DashboardPage();
	
	String path = System.getProperty("user.dir")+"/TestData/testdata.xlsx";
	ExcelReader reader = new ExcelReader();
	
	public void verifyDashboardPage(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 3, 3);
			
			helper.ElemenetToBeLocated(dashboardPage.dashboard, 20);
			String text = helper.GetText(dashboardPage.dashboard);

			if(data.equalsIgnoreCase(text)) {
				test.pass("Login Successed and This is Dashboard Page");
				LoggerHandler.logInfo("Login Successed and This is Dashboard Page");
			}
			else {
				test.fail("Login Failed and This is not Dashboard Page");
				LoggerHandler.logError("Login Failed and This is not Dashboard Page");
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	
	public void clickOnLogout(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(dashboardPage.logout, 20);
			helper.ClickOnElement(dashboardPage.logout);
			
			test.pass("Click on Logout Successed.");
			LoggerHandler.logInfo("Click on Logout Successed.");
		}
		catch(Exception e) {
			test.fail("Click on Logout Failed.");
			LoggerHandler.logError("Click on Logout Failed.");
			e.getMessage();
		}
	}
	
	
	public void displaySYNId(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(dashboardPage.synId, 20);
			String synId = helper.GetText(dashboardPage.synId);
			
			test.pass("SYN Id is "+synId);
			LoggerHandler.logInfo("SYN Id is "+synId);
		}
		catch(Exception e) {
			test.fail("Display SYN Id failed.");
			LoggerHandler.logError("Display SYN Id failed.");
			e.getMessage();
		}
	}
	
	public void displayName(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(dashboardPage.name, 20);
			String name = helper.GetText(dashboardPage.name);
			
			test.pass("Name is "+name);
			LoggerHandler.logInfo("Name is "+name);
		}
		catch(Exception e) {
			test.fail("Display Name failed.");
			LoggerHandler.logError("Display Name failed.");
			e.getMessage();
		}
	}
	
	
	public void displayEmail(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(dashboardPage.email, 20);
			String email = helper.GetText(dashboardPage.email);
			
			test.pass("Email Id is "+email);
			LoggerHandler.logInfo("Email Id is "+email);
		}
		catch(Exception e) {
			test.fail("Display Email Id failed.");
			LoggerHandler.logError("Display Email Id failed.");
			e.getMessage();
		}
	}
	
	public void displayMobile(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(dashboardPage.mobile, 20);
			String mobile = helper.GetText(dashboardPage.mobile);
			
			test.pass("Mobile Number is "+mobile);
			LoggerHandler.logInfo("Mobile Number is "+mobile);
		}
		catch(Exception e) {
			test.fail("Display Mobile Number failed.");
			LoggerHandler.logError("Display Mobile Number failed.");
			e.getMessage();
		}
	}
	
	public void displayDOB(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(dashboardPage.dob, 20);
			String dob = helper.GetText(dashboardPage.dob);
			
			test.pass("Date of Birth is "+dob);
			LoggerHandler.logInfo("Date of Birth is "+dob);
		}
		catch(Exception e) {
			test.fail("Display Date of Birth failed.");
			LoggerHandler.logError("Display Date of Birth failed.");
			e.getMessage();
		}
	}
	
	public void displayState(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(dashboardPage.state, 20);
			String state = helper.GetText(dashboardPage.state);
			
			test.pass("State is "+state);
			LoggerHandler.logInfo("State is "+state);
		}
		catch(Exception e) {
			test.fail("Display State failed.");
			LoggerHandler.logError("Display State failed.");
			e.getMessage();
		}
	}
	
	public void displayUniversity(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(dashboardPage.university, 20);
			String university = helper.GetText(dashboardPage.university);
			
			test.pass("University is "+university);
			LoggerHandler.logInfo("University is "+university);
		}
		catch(Exception e) {
			test.fail("Display University failed.");
			LoggerHandler.logError("Display University failed.");
			e.getMessage();
		}
	}
	
	
	public void displayInstitution(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(dashboardPage.institution, 20);
			String institution = helper.GetText(dashboardPage.institution);
			
			test.pass("Institution is "+institution);
			LoggerHandler.logInfo("Institution is "+institution);
		}
		catch(Exception e) {
			test.fail("Display Institution failed.");
			LoggerHandler.logError("Display Institution failed.");
			e.getMessage();
		}
	}
	
	
	public void displayDegree(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(dashboardPage.degree, 20);
			String degree = helper.GetText(dashboardPage.degree);
			
			test.pass("Degree is "+degree);
			LoggerHandler.logInfo("Degree is "+degree);
		}
		catch(Exception e) {
			test.fail("Display Degree failed.");
			LoggerHandler.logError("Display Degree failed.");
			e.getMessage();
		}
	}
	
	
	public void displayDepartment(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(dashboardPage.department, 20);
			String department = helper.GetText(dashboardPage.department);
			
			test.pass("Department is "+department);
			LoggerHandler.logInfo("Department is "+department);
		}
		catch(Exception e) {
			test.fail("Display Department failed.");
			LoggerHandler.logError("Display Department failed.");
			e.getMessage();
		}
	}
	
	
	public void displaySemester(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(dashboardPage.semester, 20);
			String semester = helper.GetText(dashboardPage.semester);
			
			test.pass("Semester is "+semester);
			LoggerHandler.logInfo("Semester is "+semester);
		}
		catch(Exception e) {
			test.fail("Display Semester failed.");
			LoggerHandler.logError("Display Semester failed.");
			e.getMessage();
		}
	}
	
	
	public void displayRegistrationNo(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(dashboardPage.registrationNo, 20);
			String registrationNo = helper.GetText(dashboardPage.registrationNo);
			
			test.pass("Registration No is "+registrationNo);
			LoggerHandler.logInfo("Registration No is "+registrationNo);
		}
		catch(Exception e) {
			test.fail("Display Registration No failed.");
			LoggerHandler.logError("Display Registration No failed.");
			e.getMessage();
		}
	}
	
	public void displayRollNo(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(dashboardPage.rollNo, 20);
			String rollNo = helper.GetText(dashboardPage.rollNo);
			
			test.pass("Roll No is "+rollNo);
			LoggerHandler.logInfo("Roll No is "+rollNo);
		}
		catch(Exception e) {
			test.fail("Display Roll No failed.");
			LoggerHandler.logError("Display Registration No failed.");
			e.getMessage();
		}
	}
	
	
	public void displayDistrict(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(dashboardPage.district, 20);
			String district = helper.GetText(dashboardPage.district);
			
			test.pass("District is "+district);
			LoggerHandler.logInfo("District is "+district);
		}
		catch(Exception e) {
			test.fail("Display District failed.");
			LoggerHandler.logError("Display District failed.");
			e.getMessage();
		}
	}
	
	public void displayPoliceStation(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(dashboardPage.policeStation, 20);
			String policeStation = helper.GetText(dashboardPage.policeStation);
			
			test.pass("Police Station is "+policeStation);
			LoggerHandler.logInfo("Police Station is "+policeStation);
		}
		catch(Exception e) {
			test.fail("Display Police Station failed.");
			LoggerHandler.logError("Display Police Station failed.");
			e.getMessage();
		}
	}
	
	public void displayPinCode(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(dashboardPage.pinCode, 20);
			String pinCode = helper.GetText(dashboardPage.pinCode);
			
			test.pass("Pin Code is "+pinCode);
			LoggerHandler.logInfo("Pin Code is "+pinCode);
		}
		catch(Exception e) {
			test.fail("Display Pin Code failed.");
			LoggerHandler.logError("Display Pin Code failed.");
			e.getMessage();
		}
	}
	
	
	public void displayAddress(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElemenetToBeLocated(dashboardPage.address, 20);
			String address = helper.GetText(dashboardPage.address);
			
			test.pass("Address is "+address);
			LoggerHandler.logInfo("Address is "+address);
		}
		catch(Exception e) {
			test.fail("Display Address failed.");
			LoggerHandler.logError("Display Address failed.");
			e.getMessage();
		}
	}
}
