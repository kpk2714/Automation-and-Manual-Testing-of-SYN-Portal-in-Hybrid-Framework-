package com.syn.pageobject;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.mail.Store;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.aventstack.extentreports.ExtentTest;
import com.syn.uistore.RegisterPage;
import com.syn.utilities.ExcelReader;
import com.syn.utilities.LoggerHandler;
import com.syn.utilities.PropertyReader;
import com.syn.utilities.WebDriverHelper;
import com.testing.framework.EmailUtils;


public class RegisterPageObject {

	RegisterPage registerPage = new RegisterPage();
	
	String path = System.getProperty("user.dir")+"/TestData/testdata.xlsx";
	ExcelReader reader = new ExcelReader();
	
	static Properties prop = PropertyReader.getTwilioProperties();
	
	public void enterName(WebDriver driver , ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String name = reader.readDataFromExcel(path, "SYN", 1, 2);
			
			helper.ElementToBeClickable(registerPage.name, 20);
			helper.ClickOnElement(registerPage.name);
			helper.SendKeys(registerPage.name,name);
			
			test.pass("Enter Name "+name+" Successed .");
			LoggerHandler.logInfo("Enter Name "+name+" Successed .");
		}
		catch(Exception e) {
			test.fail("Enter Name Failed .");
			LoggerHandler.logError("Enter Name Failed .");
			e.getMessage();
		}
	}
	
	
	public void enterEmail(WebDriver driver , ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String email = reader.readDataFromExcel(path, "SYN", 2, 2);
			
			helper.ElementToBeClickable(registerPage.email, 20);
			helper.ClickOnElement(registerPage.email);
			helper.SendKeys(registerPage.email,email);
			
			test.pass("Enter Email "+email+" Successed .");
			LoggerHandler.logInfo("Enter Email "+email+" Successed .");
		}
		catch(Exception e) {
			test.fail("Enter Email Failed .");
			LoggerHandler.logError("Enter Email Failed .");
			e.getMessage();
		}
	}
	
	public void clickOnEmailSendOtp(WebDriver driver , ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElementToBeClickable(registerPage.emailSendOtp, 20);
			helper.ClickOnElement(registerPage.emailSendOtp);
			
			
			test.pass("Click on Send OTP Successed .");
			LoggerHandler.logInfo("Click on Send OTP Successed .");
		}
		catch(Exception e) {
			test.fail("Click on Send OTP Failed .");
			LoggerHandler.logError("Click on Send OTP Failed .");
			e.getMessage();
		}
	}
	
	public void clickOnEmailReSendOtp(WebDriver driver , ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElementToBeClickable(registerPage.emailResendOtp, 20);
			helper.ClickOnElement(registerPage.emailResendOtp);
			
			
			test.pass("Click on Re-Send OTP Successed .");
			LoggerHandler.logInfo("Click on Re-Send OTP Successed .");
		}
		catch(Exception e) {
			test.fail("Click on Re-Send OTP Failed .");
			LoggerHandler.logError("Click on Re-Send OTP Failed .");
			e.getMessage();
		}
	}
	
	public void enterEmailVerifyOtp(WebDriver driver , ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElementToBeClickable(registerPage.enterEmailOtp, 40);
			helper.ClickOnElement(registerPage.enterEmailOtp);
			
			EmailUtils emailUtils = new EmailUtils();
			Properties prop = PropertyReader.getDotClickProperties();
			
			Store connection = emailUtils.connectToGmail(prop);

			List<String> emailText = emailUtils.getUnreadMessageByFromEmail(connection,"Inbox","onlineexamportalboot@gmail.com","Email Verfication Code");
			
			String OTP = "";
			
			if(emailText.size()>1) {
				throw new Exception("No Email Received.");
			}
			else {
				String regex = "[^\\d]+";
				String[] otp = emailText.get(0).split(regex);
				OTP = OTP + otp[1];
			}
			
			helper.SendKeys(registerPage.enterEmailOtp, OTP);
			
			test.pass("Enter Email Verification OTP Successed .");
			LoggerHandler.logInfo("Enter Email Verification OTP Successed .");
		}
		catch(Exception e) {
			test.fail("Enter Email Verification OTP Failed .");
			LoggerHandler.logError("Enter Email Verification OTP Failed .");
			e.getMessage();
		}
	}
	
	
	public void clickEmailSubmit(WebDriver driver , ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElementToBeClickable(registerPage.emailSubmit, 20);
			helper.ClickOnElement(registerPage.emailSubmit);
			
			
			test.pass("Click on Submit in Email verification Successed .");
			LoggerHandler.logInfo("Click on Submit in Email verification Successed .");
		}
		catch(Exception e) {
			test.fail("Click on Submit in Email verification Failed .");
			LoggerHandler.logError("Click on Submit in Email Verification OTP Failed .");
			e.getMessage();
		}
	}
	
	public void verifyEmail(WebDriver driver , ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 3, 2);
			
			helper.ElemenetToBeLocated(registerPage.verifyEmail, 20);
			String text = helper.GetText(registerPage.verifyEmail);
			
			if(data.equalsIgnoreCase(text)) {
				test.pass("Email Id Verification Successed .");
				LoggerHandler.logInfo("Email Id Verification Successed .");
			}
			else {
				test.fail("Email Id Verification Failed .");
				LoggerHandler.logError("Email Id Verification Failed .");
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	
	public void enterMobile(WebDriver driver , ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 21, 2);
			
			String mobile = "";
			for(int i=0;i<data.length();i++) {
				if(i==1)
					continue;
				else
					mobile = mobile + data.charAt(i);
			}
			
			helper.ElementToBeClickable(registerPage.mobile, 20);
			helper.ClickOnElement(registerPage.mobile);
			helper.SendKeys(registerPage.mobile,mobile);
			
			test.pass("Enter Mobile "+mobile+" Successed .");
			LoggerHandler.logInfo("Enter Mobile "+mobile+" Successed .");
		}
		catch(Exception e) {
			test.fail("Enter Mobile Failed .");
			LoggerHandler.logError("Enter Mobile Failed .");
			e.getMessage();
		}
	}
	
	public void clickOnMobileSendOtp(WebDriver driver , ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElementToBeClickable(registerPage.mobileSendOtp, 20);
			helper.ClickOnElement(registerPage.mobileSendOtp);
			
			test.pass("Click on Mobile Send OTP Successed .");
			LoggerHandler.logInfo("Click on Mobile Send OTP Successed .");
		}
		catch(Exception e) {
			test.fail("Click on Mobile Send OTP Failed .");
			LoggerHandler.logError("Click on Mobile Send OTP Failed .");
			e.getMessage();
		}
	}
	
	public void enterMobileVerifyOtp(WebDriver driver , ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			Twilio.init(path, path);
			
			Twilio.init(prop.getProperty("accountSID"),prop.getProperty("authToken"));
			
			String body = getMessage();
			String otp = body.replaceAll("[^?0-9]+","");
			
			Thread.sleep(5000);
			
			helper.ElementToBeClickable(registerPage.enterMobileOtp,20);
			helper.SendKeys(registerPage.enterMobileOtp,otp);

			test.pass("Enter Mobile Verification OTP Successed .");
			LoggerHandler.logInfo("Enter Mobile Verification OTP Successed .");
		}
		catch(Exception e) {
			test.fail("Enter Mobile Verification OTP Failed .");
			LoggerHandler.logError("Enter Mobile Verification OTP Failed .");
			e.getMessage();
		}
	}
	
	public static String getMessage() {
		return getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.OUTBOUND_API)==0)
				.filter(m -> m.getTo().equals("+916296395758")).map(Message::getBody).findFirst()
				.orElseThrow(IllegalStateException::new);
	}
	
	public static Stream<Message> getMessages(){
		ResourceSet<Message> messages = Message.reader(prop.getProperty("accountSID")).read();
		return StreamSupport.stream(messages.spliterator(), false);
	}
	
	public void clickMobileSubmit(WebDriver driver , ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElementToBeClickable(registerPage.mobileSubmit, 20);
			helper.ClickOnElement(registerPage.mobileSubmit);
			
			
			test.pass("Click on Submit in Mobile verification Successed .");
			LoggerHandler.logInfo("Click on Submit in Mobile verification Successed .");
		}
		catch(Exception e) {
			test.fail("Click on Submit in Mobile verification Failed .");
			LoggerHandler.logError("Click on Submit in Mobile verification Failed .");
			e.getMessage();
		}
	}
	
	public void verifyMobile(WebDriver driver , ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 22, 2);
			
			helper.ElemenetToBeLocated(registerPage.verifyMobile, 20);
			String text = helper.GetText(registerPage.verifyMobile);
			
			if(data.equalsIgnoreCase(text)) {
				test.pass("Mobile Verification Successed .");
				LoggerHandler.logInfo("Mobile Verification Successed .");
			}
			else {
				test.fail("Mobile Verification Failed .");
				LoggerHandler.logError("Mobile Verification Failed .");
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	
	public void chooseDOB(WebDriver driver , ExtentTest test) {
			
			try {
				Screen screen = new Screen();
				Pattern clickCalender = new Pattern("C:\\Users\\hp\\OneDrive\\Desktop\\AngularProject\\FontEndAutomationTesting\\com.syn\\SkiuliImages\\date.PNG");
				Pattern clickTopArrow = new Pattern("C:\\Users\\hp\\OneDrive\\Desktop\\AngularProject\\FontEndAutomationTesting\\com.syn\\SkiuliImages\\toparrow.PNG");
				Pattern clickMonth = new Pattern("C:\\Users\\hp\\OneDrive\\Desktop\\AngularProject\\FontEndAutomationTesting\\com.syn\\SkiuliImages\\august.PNG");
				Pattern clickDate = new Pattern("C:\\Users\\hp\\OneDrive\\Desktop\\AngularProject\\FontEndAutomationTesting\\com.syn\\SkiuliImages\\selectdate.PNG");
				
				screen.click(clickCalender);
				
				screen.click(clickTopArrow);
				for(int i=0;i<24;i++) {
					screen.type(Key.PAGE_UP,1);
				}

				screen.click(clickMonth);
				screen.click(clickDate);
				
				test.pass("Date of Birth choosen successed .");
				LoggerHandler.logInfo("Date of Birth choosen successed .");
			}
			catch(Exception e) {
				test.fail("Date of Birth choosen failed .");
				LoggerHandler.logError("Date of Birth choosen failed .");
				e.getMessage();
			}
		
	}
	
	public void chooseState(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 4, 2);
			
			helper.ElemenetToBeLocated(registerPage.state, 20);
			WebElement state = helper.FindElement(registerPage.state);
			
			Select s = new Select(state);
			s.selectByVisibleText(data);
			
			test.pass("Choose State "+data+" successed .");
			LoggerHandler.logInfo("Choose State "+data+" successed .");
		}
		catch(Exception e) {
			test.fail("Choose State failed .");
			LoggerHandler.logError("Choose State failed .");
			e.getMessage();
		}
	}
	
	public void chooseUniversity(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 5, 2);
			
			helper.ElemenetToBeLocated(registerPage.university, 20);
			WebElement university = helper.FindElement(registerPage.university);
			
			Select s = new Select(university);
			s.selectByVisibleText(data);
			
			test.pass("Choose University "+data+" successed .");
			LoggerHandler.logInfo("Choose University "+data+" successed .");
		}
		catch(Exception e) {
			test.fail("Choose University failed .");
			LoggerHandler.logError("Choose University failed .");
			e.getMessage();
		}
	}
	
	public void chooseInstitution(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 6, 2);
			
			helper.ElemenetToBeLocated(registerPage.institution, 20);
			WebElement institution = helper.FindElement(registerPage.institution);
			
			Select s = new Select(institution);
			s.selectByVisibleText(data);
			
			test.pass("Choose Institution "+data+" successed .");
			LoggerHandler.logInfo("Choose Institution "+data+" successed .");
		}
		catch(Exception e) {
			test.fail("Choose Institution failed .");
			LoggerHandler.logError("Choose Institution failed .");
			e.getMessage();
		}
	}
	
	public void chooseDepartment(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 7, 2);
			
			helper.ElemenetToBeLocated(registerPage.department, 20);
			WebElement department = helper.FindElement(registerPage.department);
			
			Select s = new Select(department);
			s.selectByVisibleText(data);
			
			test.pass("Choose Department "+data+" successed .");
			LoggerHandler.logInfo("Choose Department "+data+" successed .");
		}
		catch(Exception e) {
			test.fail("Choose Department failed .");
			LoggerHandler.logError("Choose Department failed .");
			e.getMessage();
		}
	}
	
	public void chooseDegree(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 8, 2);
			
			helper.ElemenetToBeLocated(registerPage.degree, 20);
			WebElement degree = helper.FindElement(registerPage.degree);
			
			Select s = new Select(degree);
			s.selectByVisibleText(data);
			
			test.pass("Choose Degree "+data+" successed .");
			LoggerHandler.logInfo("Choose Degree "+data+" successed .");
		}
		catch(Exception e) {
			test.fail("Choose Degree failed .");
			LoggerHandler.logError("Choose Degree failed .");
			e.getMessage();
		}
	}
	
	public void chooseYearOfStudy(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 9, 2);
			
			helper.ElemenetToBeLocated(registerPage.yos, 20);
			WebElement yos = helper.FindElement(registerPage.yos);
			
			Select s = new Select(yos);
			s.selectByVisibleText(data);
			
			test.pass("Choose Year of Study "+data+" successed .");
			LoggerHandler.logInfo("Choose Year of Study "+data+" successed .");
		}
		catch(Exception e) {
			test.fail("Choose Year of Study failed .");
			LoggerHandler.logError("Choose Year of Study failed .");
			e.getMessage();
		}
	}
	
	public void chooseSemester(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 10, 2);
			
			helper.ElemenetToBeLocated(registerPage.semester, 20);
			WebElement semester = helper.FindElement(registerPage.semester);
			
			Select s = new Select(semester);
			s.selectByVisibleText(data);
			
			test.pass("Choose Semester "+data+" successed .");
			LoggerHandler.logInfo("Choose Semester "+data+" successed .");
		}
		catch(Exception e) {
			test.fail("Choose Semester failed .");
			LoggerHandler.logError("Choose Semester failed .");
			e.getMessage();
		}
	}
	
	public void enterRegistrationNo(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 11, 2);
			String regisNo = "";
			for(int i=0;i<data.length();i++) {
				if(i==2) {
					continue;
				}
				regisNo = regisNo + data.charAt(i);
			}
			
			helper.ElementToBeClickable(registerPage.registrationNo, 20);
			helper.ClickOnElement(registerPage.registrationNo);
			helper.SendKeys(registerPage.registrationNo, regisNo);
			
			test.pass("Enter Registration Number "+regisNo+" successed .");
			LoggerHandler.logInfo("Enter Registration Number "+regisNo+" successed .");
		}
		catch(Exception e) {
			test.fail("Enter Registration Number failed .");
			LoggerHandler.logError("Enter Registration Number failed .");
			e.getMessage();
		}
	}
	
	public void enterRollNo(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 12, 2);
			String rollNo = "";
			for(int i=0;i<data.length();i++) {
				if(i==2) {
					continue;
				}
				rollNo = rollNo + data.charAt(i);
			}
			
			helper.ElementToBeClickable(registerPage.rollNo, 20);
			helper.ClickOnElement(registerPage.rollNo);
			helper.SendKeys(registerPage.rollNo, rollNo);
			
			test.pass("Enter Roll Number "+rollNo+" successed .");
			LoggerHandler.logInfo("Enter Roll Number "+rollNo+" successed .");
		}
		catch(Exception e) {
			test.fail("Enter Roll Number failed .");
			LoggerHandler.logError("Enter Roll Number failed .");
			e.getMessage();
		}
	}
	
	public void chooseDistrict(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 13, 2);
			
			helper.ElemenetToBeLocated(registerPage.district, 20);
			WebElement district = helper.FindElement(registerPage.district);
			
			Select s = new Select(district);
			s.selectByVisibleText(data);
			
			test.pass("Choose District "+data+" successed .");
			LoggerHandler.logInfo("Choose District "+data+" successed .");
		}
		catch(Exception e) {
			test.fail("Choose District failed .");
			LoggerHandler.logError("Choose District failed .");
			e.getMessage();
		}
	}
	
	public void enterPoliceStation(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 14, 2);
			
			helper.ElementToBeClickable(registerPage.policeStation, 20);
			helper.ClickOnElement(registerPage.policeStation);
			helper.SendKeys(registerPage.policeStation, data);
			
			test.pass("Enter Police Station "+data+" successed .");
			LoggerHandler.logInfo("Enter Police Station "+data+" successed .");
		}
		catch(Exception e) {
			test.fail("Enter Police Station failed .");
			LoggerHandler.logError("Enter Police Station failed .");
			e.getMessage();
		}
	}
	
	public void choosePostOffice(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 15, 2);
			
			helper.ElemenetToBeLocated(registerPage.postOffice, 20);
			
			WebElement element = helper.FindElement(registerPage.postOffice);
			Select s = new Select(element);
			s.selectByVisibleText(data);
			
			test.pass("Enter Post Office "+data+" successed .");
			LoggerHandler.logInfo("Enter Post Office "+data+" successed .");
		}
		catch(Exception e) {
			test.fail("Enter Post Office failed .");
			LoggerHandler.logError("Enter Post Office failed .");
			e.getMessage();
		}
	}
	
	public void choosePinCode(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 16, 2);
			
			String pin = "";
			for(int i=0;i<data.length()-2;i++) {
				pin = pin + data.charAt(i);
			}
			
			helper.ElemenetToBeLocated(registerPage.pinCode, 20);
			
			WebElement element = helper.FindElement(registerPage.pinCode);
			Select s = new Select(element);
			s.selectByVisibleText(data);
			
			test.pass("Enter Pin Code "+pin+" successed .");
			LoggerHandler.logInfo("Enter Pin Code "+pin+" successed .");
		}
		catch(Exception e) {
			test.fail("Enter Pin Code failed .");
			LoggerHandler.logError("Enter Pin Code failed .");
			e.getMessage();
		}
	}
	
	public void enterAddress(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 17, 2);
			
			helper.ElementToBeClickable(registerPage.address, 20);
			helper.ClickOnElement(registerPage.address);
			helper.SendKeys(registerPage.address, data);
			
			test.pass("Enter Address "+data+" successed .");
			LoggerHandler.logInfo("Enter Address "+data+" successed .");
		}
		catch(Exception e) {
			test.fail("Enter Address failed .");
			LoggerHandler.logError("Enter Address failed .");
			e.getMessage();
		}
	}
	
	public void enterUserName(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 18, 2);
			
			helper.ElementToBeClickable(registerPage.username, 20);
			helper.ClickOnElement(registerPage.username);
			helper.SendKeys(registerPage.username, data);
			
			test.pass("Enter User Name "+data+" successed .");
			LoggerHandler.logInfo("Enter User Name "+data+" successed .");
		}
		catch(Exception e) {
			test.fail("Enter User Name failed .");
			LoggerHandler.logError("Enter User Name failed .");
			e.getMessage();
		}
	}
	
	public void enterPassword(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 19, 2);
			
			helper.ElementToBeClickable(registerPage.password, 20);
			helper.ClickOnElement(registerPage.password);
			helper.SendKeys(registerPage.password, data);
			
			test.pass("Enter Password "+data+" successed .");
			LoggerHandler.logInfo("Enter Password "+data+" successed .");
		}
		catch(Exception e) {
			test.fail("Enter Password failed .");
			LoggerHandler.logError("Enter Password failed .");
			e.getMessage();
		}
	}
	
	public void enterRePassword(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			String data = reader.readDataFromExcel(path, "SYN", 20, 2);
			
			helper.ElementToBeClickable(registerPage.repassword, 20);
			helper.ClickOnElement(registerPage.repassword);
			helper.SendKeys(registerPage.repassword, data);
			
			test.pass("Enter Re-Password "+data+" successed .");
			LoggerHandler.logInfo("Enter Re-Password "+data+" successed .");
		}
		catch(Exception e) {
			test.fail("Enter Re-Password failed .");
			LoggerHandler.logError("Enter Re-Password failed .");
			e.getMessage();
		}
	}
	
	public void clickTermsAndCondition(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElementToBeClickable(registerPage.checkBox, 20);
			helper.ClickOnElement(registerPage.checkBox);
			
			test.pass("Click Terms and Condition successed .");
			LoggerHandler.logInfo("Click Terms and Condition successed .");
		}
		catch(Exception e) {
			test.fail("Click Terms and Condition failed .");
			LoggerHandler.logError("Click Terms and Condition failed .");
			e.getMessage();
		}
	}
	
	public void clickOnSubmit(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElementToBeClickable(registerPage.submit, 20);
			helper.ClickOnElement(registerPage.submit);
			
			test.pass("Click on Submit successed .");
			LoggerHandler.logInfo("Click on Submit successed .");
		}
		catch(Exception e) {
			test.fail("Click on Submit failed .");
			LoggerHandler.logError("Click on Submit failed .");
			e.getMessage();
		}
	}
	
	public void verifyRegistration(WebDriver driver,ExtentTest test) {
		try {
			String data = reader.readDataFromExcel(path, "SYN", 23, 2);
			
			Screen screen = new Screen();
			Pattern registration = new Pattern("C:\\Users\\hp\\OneDrive\\Desktop\\AngularProject\\FontEndAutomationTesting\\com.syn\\SkiuliImages\\register.PNG");
			
			screen.wait(registration,20);
			String text = screen.find(registration).text();
			
			if(text.contains(data)) {
				test.pass("Registration Successfully Completed .");
				LoggerHandler.logInfo("Registration Successfully Completed .");
			}
			else {
				test.fail("Registration Successfully Not Completed .");
				LoggerHandler.logError("Registration Successfully Not Completed .");
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	
	public void clickOnClear(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			
			helper.ElementToBeClickable(registerPage.clear, 20);
			helper.ClickOnElement(registerPage.clear);
			
			test.pass("Data Cleared .");
			LoggerHandler.logInfo("Data Cleared .");
		}
		catch(Exception e) {
			test.fail("Data Not Cleared .");
			LoggerHandler.logError("Data Not Cleared .");
			e.getMessage();
		}
	}
}
